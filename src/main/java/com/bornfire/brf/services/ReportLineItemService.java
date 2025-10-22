package com.bornfire.brf.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bornfire.brf.dto.ReportLineItemDTO;

@Service
public class ReportLineItemService {

	@Value("${output.exportpathtemp}")
	private String baseExportPath;

	public List<ReportLineItemDTO> getReportData(String reportCode) throws Exception {
		// Support both XLS and XLSX
		String filePathXlsx = baseExportPath + reportCode.toUpperCase() + ".xlsx";
		String filePathXls = baseExportPath + reportCode.toUpperCase() + ".xls";

		File file = new File(filePathXlsx);
		if (!file.exists())
			file = new File(filePathXls);
		if (!file.exists())
			throw new Exception("File not found for report code " + reportCode);

		List<ReportLineItemDTO> reportData = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(file); Workbook workbook = getWorkbook(fis, file.getName())) {

			Sheet sheet = workbook.getSheetAt(0);

			// Detect description column dynamically
			int descColIndex = detectDescriptionColumn(sheet, workbook);

			// Start from the first row that has a valid ID in Column C
			int startRowIndex = detectStartRow(sheet, workbook);

			int endRowIndex = sheet.getLastRowNum();

			List<String> allIds = new ArrayList<>();

			// First pass → collect all IDs (from Column C index=2)
			for (int r = startRowIndex; r <= endRowIndex; r++) {
				Row row = sheet.getRow(r);
				if (row == null)
					continue;
				String idVal = getCellValueAsString(row.getCell(2), workbook);
				if (idVal != null && idVal.trim().matches("^\\d+(\\.\\d+)*$")) {
					allIds.add(idVal.trim());
				}
			}

			int srlNo = 1;

			// Second pass → build DTOs with header detection
			for (int r = startRowIndex; r <= endRowIndex; r++) {
				Row row = sheet.getRow(r);
				if (row == null)
					continue;

				Cell descCell = row.getCell(descColIndex);
				if (descCell == null)
					continue;

				String desc = getCellValueAsString(descCell, workbook);
				if (desc == null || desc.trim().isEmpty())
					continue;

				String idVal = getCellValueAsString(row.getCell(2), workbook);
				if (idVal == null || idVal.trim().isEmpty())
					continue;

				idVal = idVal.trim();
				boolean isHeader = isHeaderId(idVal, allIds);

				ReportLineItemDTO dto = new ReportLineItemDTO();
				dto.setSrlNo(srlNo++);
				dto.setFieldDescription(desc.trim());
				dto.setReportLabel(String.format("R%04d", (srlNo - 1) * 10));
				dto.setHeader(isHeader ? "Y" : " ");
				dto.setRemarks("");

				reportData.add(dto);
			}

		} catch (Exception e) {
			throw new Exception("Failed to read Excel for " + reportCode, e);
		}

		return reportData;
	}

	// ---------- HEADER LOGIC ----------
	private boolean isHeaderId(String id, List<String> allIds) {
		// Top-level IDs like "1", "2", "3", etc.
		if (!id.contains("."))
			return true;

		// IDs with children
		for (String other : allIds) {
			if (other.startsWith(id + ".")) {
				return true;
			}
		}

		// Child IDs without children
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
		// Default Column D (index 3) for description
		return 3;
	}

	private int detectStartRow(Sheet sheet, Workbook workbook) {
		// Find the first row with a valid ID in Column C (index 2)
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			if (row == null)
				continue;
			Cell cell = row.getCell(2);
			if (cell != null) {
				String idVal = getCellValueAsString(cell, workbook).trim();
				if (idVal.matches("^\\d+(\\.\\d+)*$")) {
					return r; // Start from this row
				}
			}
		}
		return 0; // fallback
	}
}
