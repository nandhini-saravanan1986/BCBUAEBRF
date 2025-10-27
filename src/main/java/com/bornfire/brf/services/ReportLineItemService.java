package com.bornfire.brf.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bornfire.brf.dto.ReportLineItemDTO;

@Service
public class ReportLineItemService {

    @Value("${output.exportpathtemp}")
    private String baseExportPath;

    public List<ReportLineItemDTO> getReportData(String reportCode) throws Exception {
        String filePathXlsx = baseExportPath + reportCode.toUpperCase() + ".xlsx";
        String filePathXls = baseExportPath + reportCode.toUpperCase() + ".xls";

        File file = new File(filePathXlsx);
        if (!file.exists())
            file = new File(filePathXls);
        if (!file.exists())
            throw new Exception("File not found for report code " + reportCode);

        List<ReportLineItemDTO> reportData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = getWorkbook(fis, file.getName())) {

            Sheet sheet = workbook.getSheetAt(0);
            int descColIndex = detectDescriptionColumn(sheet, workbook);
            int startRowIndex = detectStartRow(sheet, workbook);
            int endRowIndex = sheet.getLastRowNum();

            int srlNo = 1;

            for (int r = startRowIndex; r <= endRowIndex; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;

                Cell descCell = row.getCell(descColIndex);
                if (descCell == null) continue;

                String desc = getCellValueAsString(descCell, workbook);
                if (desc == null || desc.trim().isEmpty()) continue;

                String idVal = getCellValueAsString(row.getCell(2), workbook);
                if (idVal == null || idVal.trim().isEmpty()) continue;

                idVal = idVal.trim();

                // Header detection: row has formula not repeated in all rows of that column
                boolean isHeader = isFormulaHeaderRow(row, sheet);

                ReportLineItemDTO dto = new ReportLineItemDTO();
                dto.setSrlNo(srlNo);
                dto.setFieldDescription(desc.trim());
                dto.setReportLabel(String.format("R%04d", srlNo * 10));
                dto.setHeader(isHeader ? "Y" : " ");
                dto.setRemarks("");

                reportData.add(dto);
                srlNo++;
            }

        } catch (Exception e) {
            throw new Exception("Failed to read Excel for " + reportCode, e);
        }

        return reportData;
    }

    // ---------- HEADER LOGIC ----------
    private boolean isFormulaHeaderRow(Row row, Sheet sheet) {
        short lastCol = row.getLastCellNum();

        for (int c = 0; c < lastCol; c++) {
            Cell cell = row.getCell(c);
            if (cell == null) continue;

            if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                // Check if formula is not in the majority of next rows (2 rows ahead)
                boolean formulaRepeatsBelow = true;
                for (int r = row.getRowNum() + 1; r <= row.getRowNum() + 2 && r <= sheet.getLastRowNum(); r++) {
                    Row nextRow = sheet.getRow(r);
                    if (nextRow == null) continue;

                    Cell nextCell = nextRow.getCell(c);
                    if (nextCell == null || nextCell.getCellType() != Cell.CELL_TYPE_FORMULA) {
                        formulaRepeatsBelow = false;
                        break;
                    }
                }

                if (!formulaRepeatsBelow) {
                    return true; // Unique formula → header
                }
            }
        }
        return false;
    }


    // ---------- HELPER METHODS ----------
    private Workbook getWorkbook(FileInputStream fis, String fileName) throws Exception {
        if (fileName.toLowerCase().endsWith(".xlsx"))
            return new XSSFWorkbook(fis);
        else if (fileName.toLowerCase().endsWith(".xls"))
            return new HSSFWorkbook(fis);
        else
            throw new Exception("Unsupported file: " + fileName);
    }

    private String getCellValueAsString(Cell cell, Workbook workbook) {
        if (cell == null)
            return "";
        DataFormatter df = new DataFormatter();
        try {
            return df.formatCellValue(cell, workbook.getCreationHelper().createFormulaEvaluator()).trim();
        } catch (Exception e) {
            return df.formatCellValue(cell).trim();
        }
    }

    private int detectDescriptionColumn(Sheet sheet, Workbook workbook) {
        return 3; // Default column D for description
    }

    private int detectStartRow(Sheet sheet, Workbook workbook) {
        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            Cell cell = row.getCell(2); // Column C
            if (cell != null) {
                String idVal = getCellValueAsString(cell, workbook).trim();
                if (idVal.matches("^\\d+(\\.\\d+)*$")) {
                    return r; // Start from this row
                }
            }
        }
        return 0;
    }
}
