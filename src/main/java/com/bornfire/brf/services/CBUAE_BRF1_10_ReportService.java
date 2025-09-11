package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Summary_Entity_1;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Summary_Entity_2;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Summary_Entity_3;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Summary_Repo_1;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Summary_Repo_2;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Archival_Summary_Repo_3;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Summary_Entity3;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Summary_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF1_10_Summary_Repo3;

@Component
@Service

public class CBUAE_BRF1_10_ReportService {
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_10_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF1_10_Detail_Repo BRF1_10_DETAIL_Repo;

	@Autowired
	CBUAE_BRF1_10_Summary_Repo1 BRF1_10_Summary_Repo1;

	@Autowired
	CBUAE_BRF1_10_Summary_Repo2 BRF1_10_Summary_Repo2;

	@Autowired
	CBUAE_BRF1_10_Summary_Repo3 BRF1_10_Summary_Repo3;

	@Autowired
	CBUAE_BRF1_10_Archival_Detail_Repo BRF1_10_archival_detail_repo;

	@Autowired
	CBUAE_BRF1_10_Archival_Summary_Repo_1 BRF1_10_Archival_Summary_Repo_1;

	@Autowired
	CBUAE_BRF1_10_Archival_Summary_Repo_2 BRF1_10_Archival_Summary_Repo_2;

	@Autowired
	CBUAE_BRF1_10_Archival_Summary_Repo_3 BRF1_10_Archival_Summary_Repo_3;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF1_10View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF1_10_Archival_Summary_Entity_1> T1Master = new ArrayList<CBUAE_BRF1_10_Archival_Summary_Entity_1>();
			List<CBUAE_BRF1_10_Archival_Summary_Entity_2> T2Master = new ArrayList<CBUAE_BRF1_10_Archival_Summary_Entity_2>();
			List<CBUAE_BRF1_10_Archival_Summary_Entity_3> T3Master = new ArrayList<CBUAE_BRF1_10_Archival_Summary_Entity_3>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF1_10_Archival_Summary_Repo_1.getdatabydateListarchival(dateformat.parse(todate), version);
				T2Master = BRF1_10_Archival_Summary_Repo_2.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary1", T1Master);
			mv.addObject("reportsummary2", T2Master);
			mv.addObject("reportsummary3", T3Master);
		} else {
			List<CBUAE_BRF1_10_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF1_10_Summary_Entity1>();
			List<CBUAE_BRF1_10_Summary_Entity2> T2Master = new ArrayList<CBUAE_BRF1_10_Summary_Entity2>();
			List<CBUAE_BRF1_10_Summary_Entity3> T3Master = new ArrayList<CBUAE_BRF1_10_Summary_Entity3>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF1_10_Summary_Repo1.getdatabydateList(dateformat.parse(todate));
				T2Master = BRF1_10_Summary_Repo2.getdatabydateList(dateformat.parse(todate));
				T3Master = BRF1_10_Summary_Repo3.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary1", T1Master);
			mv.addObject("reportsummary2", T2Master);
			mv.addObject("reportsummary3", T3Master);
		}

		mv.setViewName("BRF/BRF1_10");
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF1_10currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int totalPages = 0;

		ModelAndView mv = new ModelAndView();
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF1_10_Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF1_10_Archival_Detail_Entity>();
			try {
				Date d1 = dateformat.parse(todate);
				String rowId = null;
				String columnId = null;

				// ✅ Split the filter string here
				if (filter != null && filter.contains(",")) {
					String[] parts = filter.split(",");
					if (parts.length >= 2) {
						rowId = parts[0];
						columnId = parts[1];
					}
				}

				if (rowId != null && columnId != null) {
					T1Dt1 = BRF1_10_archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId,
							dateformat.parse(todate), version);

					System.out.println("countavd" + T1Dt1.size());
				} else {
					T1Dt1 = BRF1_10_archival_detail_repo.getdatabydateList(d1, version, currentPage, pageSize);
					totalPages = BRF1_10_archival_detail_repo.getdatacount(dateformat.parse(todate), version);
					mv.addObject("pagination", "YES");
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println(type);
			List<CBUAE_BRF1_10_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF1_10_Detail_Entity>();

			try {
				Date d1 = dateformat.parse(todate);

				String rowId = null;
				String columnId = null;

				// ✅ Split the filter string here
				if (filter != null && filter.contains(",")) {
					String[] parts = filter.split(",");
					if (parts.length >= 2) {
						rowId = parts[0];
						columnId = parts[1];
					}
				}

				if (rowId != null && columnId != null) {
					T1Dt1 = BRF1_10_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
				} else {
					T1Dt1 = BRF1_10_DETAIL_Repo.getdatabydateList(d1);
					T1Dt1 = BRF1_10_DETAIL_Repo.getdatabydateList(d1, currentPage, pageSize);
					totalPages = BRF1_10_DETAIL_Repo.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination", "YES");
				}
				mv.addObject("reportdetails", T1Dt1);
				System.out.println("LISTCOUNT: " + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		mv.setViewName("BRF/BRF1_10");
		mv.addObject("displaymode", "Details");
		mv.addObject("currentPage", currentPage);
		System.out.println("totalPages" + (int) Math.ceil((double) totalPages / 100));
		mv.addObject("totalPages", (int) Math.ceil((double) totalPages / 100));
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<Object> getBRF1_10Archival() {
		try {
			List<Object> merged = new ArrayList<>();
			merged.addAll(BRF1_10_Archival_Summary_Repo_1.getbrf1_10archival());
			merged.addAll(BRF1_10_Archival_Summary_Repo_2.getbrf1_10archival());
			merged.addAll(BRF1_10_Archival_Summary_Repo_3.getbrf1_10archival()); // added repo 3

			Set<String> seen = new HashSet<>();
			List<Object> uniqueList = new ArrayList<>();

			for (Object obj : merged) {
				Object[] row = (Object[]) obj;
				String key = row[0] + "_" + row[1]; // unique by date+version
				if (seen.add(key)) {
					uniqueList.add(row);
				}
			}

			System.out.println("Unique Count: " + uniqueList.size());
			return uniqueList;

		} catch (Exception e) {
			System.err.println("Error fetching BRF1_10 Archival data: " + e.getMessage());
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public byte[] getBRF1_10DetailExcel(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF1_10 Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {
				byte[] ARCHIVALreport = getBRF1_10DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
						type, version);
				return ARCHIVALreport;
			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF1_10Details");

			// Common border style
			BorderStyle border = BorderStyle.THIN;

			// Header style (left aligned)
			CellStyle headerStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 10);
			headerStyle.setFont(headerFont);
			headerStyle.setAlignment(HorizontalAlignment.LEFT);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderTop(border);
			headerStyle.setBorderBottom(border);
			headerStyle.setBorderLeft(border);
			headerStyle.setBorderRight(border);

			// Right-aligned header style for ACCT BALANCE
			CellStyle rightAlignedHeaderStyle = workbook.createCellStyle();
			rightAlignedHeaderStyle.cloneStyleFrom(headerStyle);
			rightAlignedHeaderStyle.setAlignment(HorizontalAlignment.RIGHT);

			// Default data style (left aligned)
			CellStyle dataStyle = workbook.createCellStyle();
			dataStyle.setAlignment(HorizontalAlignment.LEFT);
			dataStyle.setBorderTop(border);
			dataStyle.setBorderBottom(border);
			dataStyle.setBorderLeft(border);
			dataStyle.setBorderRight(border);

			// ACCT BALANCE style (right aligned with 3 decimals)
			CellStyle balanceStyle = workbook.createCellStyle();
			balanceStyle.setAlignment(HorizontalAlignment.RIGHT);
			balanceStyle.setDataFormat(workbook.createDataFormat().getFormat("0.000"));
			balanceStyle.setBorderTop(border);
			balanceStyle.setBorderBottom(border);
			balanceStyle.setBorderLeft(border);
			balanceStyle.setBorderRight(border);

			// Header row
			String[] headers = { "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID", "COLUMNID",
					"REPORT_DATE" };

			XSSFRow headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);

				if (i == 3) { // ACCT BALANCE
					cell.setCellStyle(rightAlignedHeaderStyle);
				} else {
					cell.setCellStyle(headerStyle);
				}

				sheet.setColumnWidth(i, 5000);
			}

			// Get data
			Date parsedToDate = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			List<CBUAE_BRF1_10_Detail_Entity> reportData = BRF1_10_DETAIL_Repo.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF1_10_Detail_Entity item : reportData) {
					XSSFRow row = sheet.createRow(rowIndex++);

					row.createCell(0).setCellValue(item.getCustId());
					row.createCell(1).setCellValue(item.getAcctNumber());
					row.createCell(2).setCellValue(item.getAcctName());

					// ACCT BALANCE (right aligned, 3 decimal places)
					Cell balanceCell = row.createCell(3);
					if (item.getAcctBalanceInAed() != null) {
						balanceCell.setCellValue(item.getAcctBalanceInAed().doubleValue());
					} else {
						balanceCell.setCellValue(0.000);
					}
					balanceCell.setCellStyle(balanceStyle);

					row.createCell(4).setCellValue(item.getRowId());
					row.createCell(5).setCellValue(item.getColumnId());
					row.createCell(6)
							.setCellValue(item.getReportDate() != null
									? new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate())
									: "");

					// Apply data style for all other cells
					for (int j = 0; j < 7; j++) {
						if (j != 3) {
							row.getCell(j).setCellStyle(dataStyle);
						}
					}
				}
			} else {
				logger.info("No data found for BRF1_10 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF1_10 Excel", e);
			return new byte[0];
		}
	}

	public byte[] getBRF1_10DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF1_10 ARCHIVAL Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {

			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF1_10Details");

			// Common border style
			BorderStyle border = BorderStyle.THIN;

			// Header style (left aligned)
			CellStyle headerStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 10);
			headerStyle.setFont(headerFont);
			headerStyle.setAlignment(HorizontalAlignment.LEFT);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderTop(border);
			headerStyle.setBorderBottom(border);
			headerStyle.setBorderLeft(border);
			headerStyle.setBorderRight(border);

			// Right-aligned header style for ACCT BALANCE
			CellStyle rightAlignedHeaderStyle = workbook.createCellStyle();
			rightAlignedHeaderStyle.cloneStyleFrom(headerStyle);
			rightAlignedHeaderStyle.setAlignment(HorizontalAlignment.RIGHT);

			// Default data style (left aligned)
			CellStyle dataStyle = workbook.createCellStyle();
			dataStyle.setAlignment(HorizontalAlignment.LEFT);
			dataStyle.setBorderTop(border);
			dataStyle.setBorderBottom(border);
			dataStyle.setBorderLeft(border);
			dataStyle.setBorderRight(border);

			// ACCT BALANCE style (right aligned with 3 decimals)
			CellStyle balanceStyle = workbook.createCellStyle();
			balanceStyle.setAlignment(HorizontalAlignment.RIGHT);
			balanceStyle.setDataFormat(workbook.createDataFormat().getFormat("0.000"));
			balanceStyle.setBorderTop(border);
			balanceStyle.setBorderBottom(border);
			balanceStyle.setBorderLeft(border);
			balanceStyle.setBorderRight(border);

			// Header row
			String[] headers = { "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID", "COLUMNID",
					"REPORT_DATE" };

			XSSFRow headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);

				if (i == 3) { // ACCT BALANCE
					cell.setCellStyle(rightAlignedHeaderStyle);
				} else {
					cell.setCellStyle(headerStyle);
				}

				sheet.setColumnWidth(i, 5000);
			}

			// Get data
			Date parsedToDate = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			List<CBUAE_BRF1_10_Archival_Detail_Entity> reportData = BRF1_10_archival_detail_repo
					.getdatabydateList(parsedToDate, version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF1_10_Archival_Detail_Entity item : reportData) {
					XSSFRow row = sheet.createRow(rowIndex++);

					row.createCell(0).setCellValue(item.getCustId());
					row.createCell(1).setCellValue(item.getAcctNumber());
					row.createCell(2).setCellValue(item.getAcctName());

					// ACCT BALANCE (right aligned, 3 decimal places)
					Cell balanceCell = row.createCell(3);
					if (item.getAcctBalanceInAed() != null) {
						balanceCell.setCellValue(item.getAcctBalanceInAed().doubleValue());
					} else {
						balanceCell.setCellValue(0.000);
					}
					balanceCell.setCellStyle(balanceStyle);

					row.createCell(4).setCellValue(item.getRowId());
					row.createCell(5).setCellValue(item.getColumnId());
					row.createCell(6)
							.setCellValue(item.getReportDate() != null
									? new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate())
									: "");

					// Apply data style for all other cells
					for (int j = 0; j < 7; j++) {
						if (j != 3) {
							row.getCell(j).setCellStyle(dataStyle);
						}
					}
				}
			} else {
				logger.info("No data found for BRF1_10 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF1_10 Excel", e);
			return new byte[0];
		}
	}

	public byte[] getBRF1_10Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {

		logger.info("Service: Starting Excel generation process in memory.");

		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF1_10ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}

		List<CBUAE_BRF1_10_Summary_Entity1> dataList = BRF1_10_Summary_Repo1
				.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF1_10_Summary_Entity2> dataList2 = BRF1_10_Summary_Repo2
				.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF1_10_Summary_Entity3> dataList3 = BRF1_10_Summary_Repo3
				.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF1.10 report. Returning empty result.");
			return new byte[0];
		}
		if (dataList2.isEmpty()) {
			logger.error("No data found for Entity2 - check query for date: {}", todate);
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		Path templatePath = Paths.get(templateDir, filename);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(0);

			CreationHelper createHelper = workbook.getCreationHelper();

			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8);
			font.setFontName("Arial");

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);
			textStyle.setFont(font);

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);

			String[] rowCodesPart1 = { "R0020", "R0030", "R0040", "R0050" };
			String[] rowCodesPart2 = { "R0070", "R0080", "R0090", "R0100", };
			String[] rowCodesPart3 = { "R0130", "R0140", "R0150", "R0160"

			};

			String[] rowCodesPart4 = { "R0180", "R0190", "R0200", "R0210"

			};

			String[] rowCodesPart5 = {

					"R0230", "R0240", "R0250", "R0260" };
			String[] rowCodesPart6 = { "R0280", "R0290" };

			String[] rowCodesPart7 = { "R0310", "R0320", "R0330" };

			String[] rowCodesPart8 = { "R0350", "R0360", };
			String[] rowCodesPart9 = { "R0380", "R0390", "R0400", "R0410" };

			String[] rowCodesPart10 = { "R0430", "R0440", "R0450", };
			String[] rowCodesPart11 = {

					"R0470", "R0480", "R0490", "R0500", "R0510", "R0520", "R0530", "R0540", "R0550", "R0560", "R0570",
					"R0580"

			};
			String[] rowCodesPart12 = {

					"R0600" };

			String[] rowCodesPart13 = { "R0620", "R0630", "R0640", "R0650", "R0660", "R0670", "R0680", "R0690", "R0700",
					"R0710" };

			String[] rowCodesPart14 = { "R0730", "R0740", "R0750", "R0760", "R0770", "R0780", "R0790" };

			String[] rowCodesPart15 = { "R0820", "R0830", "R0840" };
			String[] rowCodesPart16 = { "R0860", "R0870", "R0880", "R0890", "R0900", "R0910", "R0920", "R0930",
					"R0940" };
			String[] rowCodesPart17 = { "R0970", "R0980", "R0990", "R1000", "R1010" };
			String[] rowCodesPart18 = { "R1030", "R1040", "R1050", "R1060" };

			String[] fieldSuffixes = { "banking_operations", "banking_subsidiaries_uae", "financial_subsidiary_uae",
					"financial_subsidiary_outside_uae", "all_other_subsidiary_uae", "all_other_subsidiary_outside_uae",

			};

			String[] fieldSuffixes2 = {

					"elimination", "reclassification",

			};

			String[] fieldSuffixes3 = { "stage1_for_loans_advan", "stage1_for_investments", "stage1_for_all_oth_assets",
					"stage2_for_loans_advan", "stage2_for_investments", "stage2_for_all_oth_assets",
					"stage3_for_loans_advan", "stage3_for_investments", "stage3_for_all_oth_assets",
					"legacy_interest_suspense", "prov_inte_fee_due_mt90_days",

			};

			writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes, 11, 4, numberStyle, textStyle);
			writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes2, 11, 11, numberStyle, textStyle);

			writeRowData2(sheet, dataList, rowCodesPart2, fieldSuffixes, 16, 4, numberStyle, textStyle);
			writeRowData2(sheet, dataList, rowCodesPart2, fieldSuffixes2, 16, 11, numberStyle, textStyle);

			writeRowData3(sheet, dataList, rowCodesPart3, fieldSuffixes, 22, 4, numberStyle, textStyle);
			writeRowData3(sheet, dataList, rowCodesPart3, fieldSuffixes2, 22, 11, numberStyle, textStyle);

			writeRowData4(sheet, dataList, rowCodesPart4, fieldSuffixes, 27, 4, numberStyle, textStyle);
			writeRowData4(sheet, dataList, rowCodesPart4, fieldSuffixes2, 27, 11, numberStyle, textStyle);

			writeRowData5(sheet, dataList, rowCodesPart5, fieldSuffixes, 32, 4, numberStyle, textStyle);
			writeRowData5(sheet, dataList, rowCodesPart5, fieldSuffixes2, 32, 11, numberStyle, textStyle);

			writeRowData6(sheet, dataList, rowCodesPart6, fieldSuffixes, 37, 4, numberStyle, textStyle);
			writeRowData6(sheet, dataList, rowCodesPart6, fieldSuffixes2, 37, 11, numberStyle, textStyle);

			writeRowData7(sheet, dataList, rowCodesPart8, fieldSuffixes, 40, 4, numberStyle, textStyle);
			writeRowData7(sheet, dataList, rowCodesPart8, fieldSuffixes2, 40, 11, numberStyle, textStyle);

			writeRowData8(sheet, dataList, rowCodesPart8, fieldSuffixes, 44, 4, numberStyle, textStyle);
			writeRowData8(sheet, dataList, rowCodesPart8, fieldSuffixes2, 44, 11, numberStyle, textStyle);

			writeRowData9(sheet, dataList, rowCodesPart9, fieldSuffixes, 47, 4, numberStyle, textStyle);
			writeRowData9(sheet, dataList, rowCodesPart9, fieldSuffixes2, 47, 11, numberStyle, textStyle);

			writeRowData10(sheet, dataList, rowCodesPart10, fieldSuffixes, 52, 4, numberStyle, textStyle);
			writeRowData10(sheet, dataList, rowCodesPart10, fieldSuffixes2, 52, 11, numberStyle, textStyle);

			writeRowData11(sheet, dataList, rowCodesPart11, fieldSuffixes, 56, 4, numberStyle, textStyle);
			writeRowData11(sheet, dataList, rowCodesPart11, fieldSuffixes2, 56, 11, numberStyle, textStyle);

			writeRowData12(sheet, dataList, rowCodesPart12, fieldSuffixes, 69, 4, numberStyle, textStyle);
			writeRowData12(sheet, dataList, rowCodesPart12, fieldSuffixes2, 69, 11, numberStyle, textStyle);

			writeRowData13(sheet, dataList, rowCodesPart13, fieldSuffixes, 71, 4, numberStyle, textStyle);
			writeRowData13(sheet, dataList, rowCodesPart13, fieldSuffixes2, 71, 11, numberStyle, textStyle);

			writeRowData14(sheet, dataList, rowCodesPart14, fieldSuffixes, 82, 4, numberStyle, textStyle);
			writeRowData14(sheet, dataList, rowCodesPart14, fieldSuffixes2, 82, 11, numberStyle, textStyle);

			writeRowData15(sheet, dataList2, rowCodesPart15, fieldSuffixes, 91, 4, numberStyle, textStyle);
			writeRowData15(sheet, dataList2, rowCodesPart15, fieldSuffixes2, 91, 11, numberStyle, textStyle);

			writeRowData16(sheet, dataList2, rowCodesPart16, fieldSuffixes, 95, 4, numberStyle, textStyle);
			writeRowData16(sheet, dataList2, rowCodesPart16, fieldSuffixes2, 95, 11, numberStyle, textStyle);

			writeRowData17(sheet, dataList2, rowCodesPart17, fieldSuffixes, 106, 4, numberStyle, textStyle);
			writeRowData17(sheet, dataList2, rowCodesPart17, fieldSuffixes2, 106, 11, numberStyle, textStyle);

			writeRowData18(sheet, dataList3, rowCodesPart18, fieldSuffixes3, 115, 4, numberStyle, textStyle);

			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();

		}

	}

	private void writeRowData1(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData2(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData3(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData4(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData5(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData6(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData7(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData8(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData9(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData10(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData11(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData12(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData13(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData14(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity1> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData15(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity2> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity2 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity2.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}

	}

	private void writeRowData16(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity2> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity2 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity2.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData17(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity2> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity2 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity2.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowData18(Sheet sheet, List<CBUAE_BRF1_10_Summary_Entity3> dataList, String[] rowCodes,
			String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle, CellStyle textStyle) {

		for (CBUAE_BRF1_10_Summary_Entity3 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Summary_Entity3.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	public byte[] getBRF1_10ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Archival Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		logger.info("Service: Fetching archival data for report_date={} and version={}", todate, version);
		Date parsedDate = dateformat.parse(todate);
		logger.info("Service: Parsed date for query: {}", parsedDate);

		List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList = BRF1_10_Archival_Summary_Repo_1
				.getdatabydateListarchival(parsedDate, version);
		logger.info("Service: dataList (Repo 1) size: {}", dataList.size());

		List<CBUAE_BRF1_10_Archival_Summary_Entity_2> dataList2 = BRF1_10_Archival_Summary_Repo_2
				.getdatabydateListarchival(parsedDate, version);
		logger.info("Service: dataList1 (Repo 2) size: {}", dataList2.size());

		List<CBUAE_BRF1_10_Archival_Summary_Entity_3> dataList3 = BRF1_10_Archival_Summary_Repo_3
				.getdatabydateListarchival(parsedDate, version);
		logger.info("Service: dataList1 (Repo 3) size: {}", dataList3.size());

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF1.10 report. Returning empty result.");
			return new byte[0];
		}
		if (dataList2.isEmpty()) {
			logger.error("No data found for Entity2 - check query for date: {}", todate);
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		Path templatePath = Paths.get(templateDir, filename);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException("Template file exists but is not readable: " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(0);

			CreationHelper createHelper = workbook.getCreationHelper();

			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8);
			font.setFontName("Arial");

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);
			textStyle.setFont(font);

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);

			String[] rowCodesPart1 = { "R0020", "R0030", "R0040", "R0050" };
			String[] rowCodesPart2 = { "R0070", "R0080", "R0090", "R0100", };
			String[] rowCodesPart3 = { "R0130", "R0140", "R0150", "R0160"

			};

			String[] rowCodesPart4 = { "R0180", "R0190", "R0200", "R0210"

			};

			String[] rowCodesPart5 = {

					"R0230", "R0240", "R0250", "R0260" };
			String[] rowCodesPart6 = { "R0280", "R0290" };

			String[] rowCodesPart7 = { "R0310", "R0320", "R0330" };

			String[] rowCodesPart8 = { "R0350", "R0360", };
			String[] rowCodesPart9 = { "R0380", "R0390", "R0400", "R0410" };

			String[] rowCodesPart10 = { "R0430", "R0440", "R0450", };
			String[] rowCodesPart11 = {

					"R0470", "R0480", "R0490", "R0500", "R0510", "R0520", "R0530", "R0540", "R0550", "R0560", "R0570",
					"R0580"

			};
			String[] rowCodesPart12 = {

					"R0600" };

			String[] rowCodesPart13 = { "R0620", "R0630", "R0640", "R0650", "R0660", "R0670", "R0680", "R0690", "R0700",
					"R0710" };

			String[] rowCodesPart14 = { "R0730", "R0740", "R0750", "R0760", "R0770", "R0780", "R0790" };

			String[] rowCodesPart15 = { "R0820", "R0830", "R0840" };
			String[] rowCodesPart16 = { "R0860", "R0870", "R0880", "R0890", "R0900", "R0910", "R0920", "R0930",
					"R0940" };
			String[] rowCodesPart17 = { "R0970", "R0980", "R0990", "R1000", "R1010" };
			String[] rowCodesPart18 = { "R1030", "R1040", "R1050", "R1060" };

			String[] fieldSuffixes = { "banking_operations", "banking_subsidiaries_uae", "financial_subsidiary_uae",
					"financial_subsidiary_outside_uae", "all_other_subsidiary_uae", "all_other_subsidiary_outside_uae",

			};

			String[] fieldSuffixes2 = {

					"elimination", "reclassification",

			};

			String[] fieldSuffixes3 = { "stage1_for_loans_advan", "stage1_for_investments", "stage1_for_all_oth_assets",
					"stage2_for_loans_advan", "stage2_for_investments", "stage2_for_all_oth_assets",
					"stage3_for_loans_advan", "stage3_for_investments", "stage3_for_all_oth_assets",
					"legacy_interest_suspense", "prov_inte_fee_due_mt90_days",

			};

			writeRowDataArchival1(sheet, dataList, rowCodesPart1, fieldSuffixes, 11, 4, numberStyle, textStyle);
			writeRowDataArchival1(sheet, dataList, rowCodesPart1, fieldSuffixes2, 11, 11, numberStyle, textStyle);

			writeRowDataArchival2(sheet, dataList, rowCodesPart2, fieldSuffixes, 16, 4, numberStyle, textStyle);
			writeRowDataArchival2(sheet, dataList, rowCodesPart2, fieldSuffixes2, 16, 11, numberStyle, textStyle);

			writeRowDataArchival3(sheet, dataList, rowCodesPart3, fieldSuffixes, 22, 4, numberStyle, textStyle);
			writeRowDataArchival3(sheet, dataList, rowCodesPart3, fieldSuffixes2, 22, 11, numberStyle, textStyle);

			writeRowDataArchival4(sheet, dataList, rowCodesPart4, fieldSuffixes, 27, 4, numberStyle, textStyle);
			writeRowDataArchival4(sheet, dataList, rowCodesPart4, fieldSuffixes2, 27, 11, numberStyle, textStyle);

			writeRowDataArchival5(sheet, dataList, rowCodesPart5, fieldSuffixes, 32, 4, numberStyle, textStyle);
			writeRowDataArchival5(sheet, dataList, rowCodesPart5, fieldSuffixes2, 32, 11, numberStyle, textStyle);

			writeRowDataArchival6(sheet, dataList, rowCodesPart6, fieldSuffixes, 37, 4, numberStyle, textStyle);
			writeRowDataArchival6(sheet, dataList, rowCodesPart6, fieldSuffixes2, 37, 11, numberStyle, textStyle);

			writeRowDataArchival7(sheet, dataList, rowCodesPart8, fieldSuffixes, 40, 4, numberStyle, textStyle);
			writeRowDataArchival7(sheet, dataList, rowCodesPart8, fieldSuffixes2, 40, 11, numberStyle, textStyle);

			writeRowDataArchival8(sheet, dataList, rowCodesPart8, fieldSuffixes, 44, 4, numberStyle, textStyle);
			writeRowDataArchival8(sheet, dataList, rowCodesPart8, fieldSuffixes2, 44, 11, numberStyle, textStyle);

			writeRowDataArchival9(sheet, dataList, rowCodesPart9, fieldSuffixes, 47, 4, numberStyle, textStyle);
			writeRowDataArchival9(sheet, dataList, rowCodesPart9, fieldSuffixes2, 47, 11, numberStyle, textStyle);

			writeRowDataArchival10(sheet, dataList, rowCodesPart10, fieldSuffixes, 52, 4, numberStyle, textStyle);
			writeRowDataArchival10(sheet, dataList, rowCodesPart10, fieldSuffixes2, 52, 11, numberStyle, textStyle);

			writeRowDataArchival11(sheet, dataList, rowCodesPart11, fieldSuffixes, 56, 4, numberStyle, textStyle);
			writeRowDataArchival11(sheet, dataList, rowCodesPart11, fieldSuffixes2, 56, 11, numberStyle, textStyle);

			writeRowDataArchival12(sheet, dataList, rowCodesPart12, fieldSuffixes, 69, 4, numberStyle, textStyle);
			writeRowDataArchival12(sheet, dataList, rowCodesPart12, fieldSuffixes2, 69, 11, numberStyle, textStyle);

			writeRowDataArchival13(sheet, dataList, rowCodesPart13, fieldSuffixes, 71, 4, numberStyle, textStyle);
			writeRowDataArchival13(sheet, dataList, rowCodesPart13, fieldSuffixes2, 71, 11, numberStyle, textStyle);

			writeRowDataArchival14(sheet, dataList, rowCodesPart14, fieldSuffixes, 82, 4, numberStyle, textStyle);
			writeRowDataArchival14(sheet, dataList, rowCodesPart14, fieldSuffixes2, 82, 11, numberStyle, textStyle);

			writeRowDataArchival15(sheet, dataList2, rowCodesPart15, fieldSuffixes, 91, 4, numberStyle, textStyle);
			writeRowDataArchival15(sheet, dataList2, rowCodesPart15, fieldSuffixes2, 91, 11, numberStyle, textStyle);

			writeRowDataArchival16(sheet, dataList2, rowCodesPart16, fieldSuffixes, 95, 4, numberStyle, textStyle);
			writeRowDataArchival16(sheet, dataList2, rowCodesPart16, fieldSuffixes2, 95, 11, numberStyle, textStyle);

			writeRowDataArchival17(sheet, dataList2, rowCodesPart17, fieldSuffixes, 106, 4, numberStyle, textStyle);
			writeRowDataArchival17(sheet, dataList2, rowCodesPart17, fieldSuffixes2, 106, 11, numberStyle, textStyle);

			writeRowDataArchival18(sheet, dataList3, rowCodesPart18, fieldSuffixes3, 115, 4, numberStyle, textStyle);

			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();

		}

	}

	private void writeRowDataArchival1(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival2(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival3(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival4(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival5(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival6(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival7(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival8(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival9(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival10(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival11(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival12(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival13(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival14(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_1> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_1 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_1.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival15(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_2> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_2 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_2.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}

	}

	private void writeRowDataArchival16(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_2> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_2 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_2.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival17(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_2> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_2 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_2.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

	private void writeRowDataArchival18(Sheet sheet, List<CBUAE_BRF1_10_Archival_Summary_Entity_3> dataList,
			String[] rowCodes, String[] fieldSuffixes, int baseRow, int startColIndex, CellStyle numberStyle,
			CellStyle textStyle) {

		for (CBUAE_BRF1_10_Archival_Summary_Entity_3 record : dataList) {
			for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				String rowCode = rowCodes[rowIndex];
				Row row = sheet.getRow(baseRow + rowIndex);
				if (row == null) {
					row = sheet.createRow(baseRow + rowIndex);
				}

				int actualColIndex = startColIndex; // use passed index
				for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					Cell cell = row.createCell(actualColIndex++);

					try {
						Field field = CBUAE_BRF1_10_Archival_Summary_Entity_3.class.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object value = field.get(record);

						if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
							cell.setCellStyle(numberStyle);
						} else {
							cell.setCellValue("");
							cell.setCellStyle(textStyle);
						}
					} catch (NoSuchFieldException | IllegalAccessException e) {
						cell.setCellValue("");
						cell.setCellStyle(textStyle);
					}
				}
			}
		}
	}

}
