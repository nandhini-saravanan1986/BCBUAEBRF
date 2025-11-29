package com.bornfire.brf.services;

import com.bornfire.brf.dto.ReportLineItemDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportLineItemService {

    @Value("${output.exportpathtemp}")
    private String baseExportPath;

    /**
     * Reads the main data rows from the report file with CORRECTED header detection.
     */
    public List<ReportLineItemDTO> getReportData(String reportCode) throws Exception {
        try (Workbook workbook = getWorkbookForReport(reportCode)) {
            Sheet sheet = workbook.getSheetAt(0);
            
            List<ReportLineItemDTO> reportData = new ArrayList<>();
            int startRowIndex = detectStartRow(sheet, workbook);
            int idColIndex = 2; // Column C for the ID
            int descColIndex = 3; // Column D for the Description
            int srlNo = 1;

            for (int r = startRowIndex; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;

                String idVal = getCellValueAsString(row.getCell(idColIndex), workbook).trim();
                
                // Skip rows that don't have a valid ID format
                if (idVal.isEmpty() || !idVal.matches("^\\d+(\\.\\d+)*$")) {
                    continue;
                }

                String desc = getCellValueAsString(row.getCell(descColIndex), workbook);
                if (desc.isEmpty()) continue;

                // --- THE CRITICAL FIX IS HERE ---
                // A row is a header if its ID in Column C does NOT contain a period.
                // e.g., "1", "2", "8" are headers. "1.1", "8.2.1" are not.
                boolean isHeader = !idVal.contains("."); 
                
                ReportLineItemDTO dto = new ReportLineItemDTO();
                dto.setSrlNo(srlNo++);
                dto.setFieldDescription(desc.trim());
                dto.setReportLabel(String.format("R%04d", Integer.parseInt(idVal.replace(".", "")) * 10)); // Generate label from ID
                dto.setHeader(isHeader ? "Y" : " "); // Set header status based on the new logic
                dto.setRemarks("");

                reportData.add(dto);
            }
            return reportData;
        }
    }

    /**
     * Reads the column headers (This method was already correct).
     */
    public List<ReportLineItemDTO> getReportColumns(String reportCode) throws Exception {
        try (Workbook workbook = getWorkbookForReport(reportCode)) {
            Sheet sheet = workbook.getSheetAt(0);
            List<ReportLineItemDTO> reportColumns = new ArrayList<>();

            Row idRow = null;
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if ("0010".equals(getCellValueAsString(cell, workbook).trim())) {
                        idRow = row;
                        break;
                    }
                }
                if (idRow != null) break;
            }

            if (idRow == null) {
                throw new Exception("FATAL: Could not find the column ID row (the row containing '0010').");
            }

            int idRowIndex = idRow.getRowNum();
            Row typeRow = sheet.getRow(idRowIndex - 1);
            Row currencyRow = sheet.getRow(idRowIndex - 2);
            Row residentRow = sheet.getRow(idRowIndex - 3);

            if (residentRow == null || currencyRow == null || typeRow == null) {
                throw new Exception("FATAL: Header rows are missing or not in the expected format.");
            }

            for (int c = 0; c < idRow.getLastCellNum(); c++) {
                String colId = getCellValueAsString(idRow.getCell(c), workbook).trim();
                String residentType = getMergedCellValue(sheet, residentRow, c, workbook);

                if (colId.matches("^\\d{4}$")) {
                    String currencyType = getMergedCellValue(sheet, currencyRow, c, workbook);
                    String valueType = getCellValueAsString(typeRow.getCell(c), workbook);
                    String fullColumnName = String.format("%s - %s - %s", residentType.trim(), currencyType.trim(), valueType.trim());
                    reportColumns.add(new ReportLineItemDTO(colId, fullColumnName));
                } else if ("Total (Amount)".equalsIgnoreCase(residentType.trim())) {
                    reportColumns.add(new ReportLineItemDTO(colId, "Total (Amount)"));
                }
            }
            return reportColumns;
        }
    }

    // ---------- HELPER METHODS (No changes needed here) ----------

    private Workbook getWorkbookForReport(String reportCode) throws IOException, Exception {
        String filePathXlsx = baseExportPath + reportCode.toUpperCase() + ".xlsx";
        String filePathXls = baseExportPath + reportCode.toUpperCase() + ".xls";
        File file = new File(filePathXlsx);
        if (!file.exists()) file = new File(filePathXls);
        if (!file.exists()) throw new Exception("File not found for report code " + reportCode);
        
        try (FileInputStream fis = new FileInputStream(file)) {
            if (file.getName().toLowerCase().endsWith(".xlsx")) return new XSSFWorkbook(fis);
            if (file.getName().toLowerCase().endsWith(".xls")) return new HSSFWorkbook(fis);
        }
        throw new Exception("Unsupported file type: " + file.getName());
    }

    private String getCellValueAsString(Cell cell, Workbook workbook) {
        if (cell == null) return "";
        DataFormatter df = new DataFormatter();
        return df.formatCellValue(cell).trim();
    }

    private String getMergedCellValue(Sheet sheet, Row row, int colNum, Workbook workbook) {
        if (row == null) return "";
        for (CellRangeAddress mergedRegion : sheet.getMergedRegions()) {
            if (mergedRegion.isInRange(row.getRowNum(), colNum)) {
                Row firstRow = sheet.getRow(mergedRegion.getFirstRow());
                if(firstRow == null) return "";
                Cell firstCell = firstRow.getCell(mergedRegion.getFirstColumn());
                return getCellValueAsString(firstCell, workbook);
            }
        }
        return getCellValueAsString(row.getCell(colNum), workbook);
    }
    
    private int detectStartRow(Sheet sheet, Workbook workbook) {
        for (Row row : sheet) {
            Cell cell = row.getCell(2);
            if (cell != null && getCellValueAsString(cell, workbook).trim().matches("^\\d+(\\.\\d+)*$")) {
                return row.getRowNum();
            }
        }
        return 0;
    }
}