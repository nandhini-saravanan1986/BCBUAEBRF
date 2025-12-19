package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF2_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_1_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Archival_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Archival_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Archival_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_3_Summary_Repo;

@Component
@Service

public class CBUAE_BRF2_3_ReportService {

	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_3_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF2_3_Detail_Repo CBUAE_BRF2_3_DETAIL_REPO;

	@Autowired
	CBUAE_BRF2_3_Summary_Repo CBUAE_BRF2_3_SUMMARY_REPO;

	@Autowired
	CBUAE_BRF2_3_Archival_Detail_Repo BRF2_3_archival_detail_repo;

	@Autowired
	CBUAE_BRF2_3_Archival_Summary_Repo BRF2_3_Archival_Summary_Repo;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF2_3View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF2_3_Archival_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_3_Archival_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF2_3_Archival_Summary_Repo.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}

		else {
			List<CBUAE_BRF2_3_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_3_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = CBUAE_BRF2_3_SUMMARY_REPO.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}

		mv.setViewName("BRF/BRF2_3");
		// mv.addObject("reportsummary", T1Master);
		mv.addObject("displaymode", "summary");

		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF2_3currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int totalPages=0;

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF2_3_Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF2_3_Archival_Detail_Entity>();
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
					T1Dt1 = BRF2_3_archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId,
							dateformat.parse(todate), version);

					System.out.println("countavd" + T1Dt1.size());
				} else {

					T1Dt1 = BRF2_3_archival_detail_repo.getdatabydateList(dateformat.parse(todate), version);
					System.out.println("countavd" + T1Dt1.size());
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println(type);
			List<CBUAE_BRF2_3_Detail_Entity> T1Dt1 = new ArrayList<>();

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
					T1Dt1 = CBUAE_BRF2_3_DETAIL_REPO.GetDataByRowIdAndColumnId(rowId, columnId, d1);
				} else {
					T1Dt1 = CBUAE_BRF2_3_DETAIL_REPO.getdatabydateList(d1,currentPage,pageSize);
					totalPages=CBUAE_BRF2_3_DETAIL_REPO.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination","YES");
				}
				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);
				System.out.println("LISTCOUNT: " + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("BRF/BRF2_3");
		mv.addObject("displaymode", "Details");
		mv.addObject("currentPage", currentPage);
	   	System.out.println("totalPages"+(int)Math.ceil((double)totalPages / 100));
	   	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
		// mv.addObject("reportdetails", T1Dt1);
		// mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<Object> getBRF2_3Archival() {
		List<Object> BRF2_3Archivallist = new ArrayList<>();
		try {
			BRF2_3Archivallist = BRF2_3_Archival_Summary_Repo.getbrf2_3archival();
			System.out.println("countser" + BRF2_3Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF2_3 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF2_3Archivallist;
	}

	// DetailExcel
	public byte[] getBRF2_3DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {

			try {
				logger.info("Generating Excel for BRF2_3 Details...");
				System.out.println("came to Detail download service");
				if (type.equals("ARCHIVAL") & version != null) {
					byte[] ARCHIVALreport = getBRF2_3DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
							type, version);
					return ARCHIVALreport;
				}
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("BRF2_3Details");

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
				List<CBUAE_BRF2_3_Detail_Entity> reportData = CBUAE_BRF2_3_DETAIL_REPO.getdatabydateList(parsedToDate);

				if (reportData != null && !reportData.isEmpty()) {
					int rowIndex = 1;
					for (CBUAE_BRF2_3_Detail_Entity item : reportData) {
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
					logger.info("No data found for BRF2_3 — only header will be written.");
				}

				// Write to byte[]
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				workbook.write(bos);
				workbook.close();

				logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
				return bos.toByteArray();

			} catch (Exception e) {
				logger.error("Error generating BRF2_3 Excel", e);
				return new byte[0];
			}
		}
	

	public byte[] getBRF2_3Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF2_3ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}
		List<CBUAE_BRF2_3_Summary_Entity> dataList = CBUAE_BRF2_3_SUMMARY_REPO
				.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.3 report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		String templateFileName = filename;
		System.out.println(filename);
		Path templatePath = Paths.get(templateDir, templateFileName);
		System.out.println(templatePath);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			// This specific exception will be caught by the controller.
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			// A specific exception for permission errors.
			throw new SecurityException(
					"Template file exists but is not readable (check permissions): " + templatePath.toAbsolutePath());
		}

		// This try-with-resources block is perfect. It guarantees all resources are
		// closed automatically.
		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(0);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 11;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {

					CBUAE_BRF2_3_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

/////ROW12///////////
//row12
// Column E: 
					Cell R0030cell4 = row.createCell(4);
					if (record.getR0030_overdue() != null) {
						R0030cell4.setCellValue(record.getR0030_overdue().doubleValue());
						R0030cell4.setCellStyle(numberStyle);
					} else {
						R0030cell4.setCellValue("");
						R0030cell4.setCellStyle(textStyle);
					}

//row12
//Column F: 
					Cell R0030cell5 = row.createCell(5);
					if (record.getR0030_overdraft() != null) {
						R0030cell5.setCellValue(record.getR0030_overdraft().doubleValue());
						R0030cell5.setCellStyle(numberStyle);
					} else {
						R0030cell5.setCellValue("");
						R0030cell5.setCellStyle(textStyle);
					}

//row12
//Column G: 
					Cell R0030cell6 = row.createCell(6);
					if (record.getR0030_0_7days() != null) {
						R0030cell6.setCellValue(record.getR0030_0_7days().doubleValue());
						R0030cell6.setCellStyle(numberStyle);
					} else {
						R0030cell6.setCellValue("");
						R0030cell6.setCellStyle(textStyle);
					}

//row12
//Column H: 
					Cell R0030cell7 = row.createCell(7);
					if (record.getR0030_8_14days() != null) {
						R0030cell7.setCellValue(record.getR0030_8_14days().doubleValue());
						R0030cell7.setCellStyle(numberStyle);
					} else {
						R0030cell7.setCellValue("");
						R0030cell7.setCellStyle(textStyle);
					}

//row12
//Column I: 
					Cell R0030cell8 = row.createCell(8);
					if (record.getR0030_15days_1months() != null) {
						R0030cell8.setCellValue(record.getR0030_15days_1months().doubleValue());
						R0030cell8.setCellStyle(numberStyle);
					} else {
						R0030cell8.setCellValue("");
						R0030cell8.setCellStyle(textStyle);
					}

//row12
//Column J: 
					Cell R0030cell9 = row.createCell(9);
					if (record.getR0030_1_2months() != null) {
						R0030cell9.setCellValue(record.getR0030_1_2months().doubleValue());
						R0030cell9.setCellStyle(numberStyle);
					} else {
						R0030cell9.setCellValue("");
						R0030cell9.setCellStyle(textStyle);
					}

//row12
//Column K: 
					Cell R0030cell10 = row.createCell(10);
					if (record.getR0030_2_3months() != null) {
						R0030cell10.setCellValue(record.getR0030_2_3months().doubleValue());
						R0030cell10.setCellStyle(numberStyle);
					} else {
						R0030cell10.setCellValue("");
						R0030cell10.setCellStyle(textStyle);
					}

//row12
//Column L: 
					Cell R0030cell11 = row.createCell(11);
					if (record.getR0030_3_6months() != null) {
						R0030cell11.setCellValue(record.getR0030_3_6months().doubleValue());
						R0030cell11.setCellStyle(numberStyle);
					} else {
						R0030cell11.setCellValue("");
						R0030cell11.setCellStyle(textStyle);
					}

//row12
//Column M: 
					Cell R0030cell12 = row.createCell(12);
					if (record.getR0030_6_12months() != null) {
						R0030cell12.setCellValue(record.getR0030_6_12months().doubleValue());
						R0030cell12.setCellStyle(numberStyle);
					} else {
						R0030cell12.setCellValue("");
						R0030cell12.setCellStyle(textStyle);
					}

//row12
//Column N: 
					Cell R0030cell13 = row.createCell(13);
					if (record.getR0030_1_3years() != null) {
						R0030cell13.setCellValue(record.getR0030_1_3years().doubleValue());
						R0030cell13.setCellStyle(numberStyle);
					} else {
						R0030cell13.setCellValue("");
						R0030cell13.setCellStyle(textStyle);
					}

//row12
//Column O: 
					Cell R0030cell14 = row.createCell(14);
					if (record.getR0030_3_5years() != null) {
						R0030cell14.setCellValue(record.getR0030_3_5years().doubleValue());
						R0030cell14.setCellStyle(numberStyle);
					} else {
						R0030cell14.setCellValue("");
						R0030cell14.setCellStyle(textStyle);
					}

//row12
//Column P: 
					Cell R0030cell15 = row.createCell(15);
					if (record.getR0030_5years() != null) {
						R0030cell15.setCellValue(record.getR0030_5years().doubleValue());
						R0030cell15.setCellStyle(numberStyle);
					} else {
						R0030cell15.setCellValue("");
						R0030cell15.setCellStyle(textStyle);
					}

/////ROW13///////////
//ROW13

					row = sheet.getRow(12);

//Column E: 
					Cell R0040cell4 = row.createCell(4);
					if (record.getR0040_overdue() != null) {
						R0040cell4.setCellValue(record.getR0040_overdue().doubleValue());
						R0040cell4.setCellStyle(numberStyle);
					} else {
						R0040cell4.setCellValue("");
						R0040cell4.setCellStyle(textStyle);
					}

//ROW13
//Column F: 
					Cell R0040cell5 = row.createCell(5);
					if (record.getR0040_overdraft() != null) {
						R0040cell5.setCellValue(record.getR0040_overdraft().doubleValue());
						R0040cell5.setCellStyle(numberStyle);
					} else {
						R0040cell5.setCellValue("");
						R0040cell5.setCellStyle(textStyle);
					}

//ROW13
//Column G: 
					Cell R0040cell6 = row.createCell(6);
					if (record.getR0040_0_7days() != null) {
						R0040cell6.setCellValue(record.getR0040_0_7days().doubleValue());
						R0040cell6.setCellStyle(numberStyle);
					} else {
						R0040cell6.setCellValue("");
						R0040cell6.setCellStyle(textStyle);
					}

//ROW13
//Column H: 
					Cell R0040cell7 = row.createCell(7);
					if (record.getR0040_8_14days() != null) {
						R0040cell7.setCellValue(record.getR0040_8_14days().doubleValue());
						R0040cell7.setCellStyle(numberStyle);
					} else {
						R0040cell7.setCellValue("");
						R0040cell7.setCellStyle(textStyle);
					}

//ROW13
//Column I: 
					Cell R0040cell8 = row.createCell(8);
					if (record.getR0040_15days_1months() != null) {
						R0040cell8.setCellValue(record.getR0040_15days_1months().doubleValue());
						R0040cell8.setCellStyle(numberStyle);
					} else {
						R0040cell8.setCellValue("");
						R0040cell8.setCellStyle(textStyle);
					}

//ROW13
//Column J: 
					Cell R0040cell9 = row.createCell(9);
					if (record.getR0040_1_2months() != null) {
						R0040cell9.setCellValue(record.getR0040_1_2months().doubleValue());
						R0040cell9.setCellStyle(numberStyle);
					} else {
						R0040cell9.setCellValue("");
						R0040cell9.setCellStyle(textStyle);
					}

//ROW13
//Column K: 
					Cell R0040cell10 = row.createCell(10);
					if (record.getR0040_2_3months() != null) {
						R0040cell10.setCellValue(record.getR0040_2_3months().doubleValue());
						R0040cell10.setCellStyle(numberStyle);
					} else {
						R0040cell10.setCellValue("");
						R0040cell10.setCellStyle(textStyle);
					}

//ROW13
//Column L: 
					Cell R0040cell11 = row.createCell(11);
					if (record.getR0040_3_6months() != null) {
						R0040cell11.setCellValue(record.getR0040_3_6months().doubleValue());
						R0040cell11.setCellStyle(numberStyle);
					} else {
						R0040cell11.setCellValue("");
						R0040cell11.setCellStyle(textStyle);
					}

//ROW13
//Column M: 
					Cell R0040cell12 = row.createCell(12);
					if (record.getR0040_6_12months() != null) {
						R0040cell12.setCellValue(record.getR0040_6_12months().doubleValue());
						R0040cell12.setCellStyle(numberStyle);
					} else {
						R0040cell12.setCellValue("");
						R0040cell12.setCellStyle(textStyle);
					}

//ROW13
//Column N: 
					Cell R0040cell13 = row.createCell(13);
					if (record.getR0040_1_3years() != null) {
						R0040cell13.setCellValue(record.getR0040_1_3years().doubleValue());
						R0040cell13.setCellStyle(numberStyle);
					} else {
						R0040cell13.setCellValue("");
						R0040cell13.setCellStyle(textStyle);
					}

//ROW13
//Column O: 
					Cell R0040cell14 = row.createCell(14);
					if (record.getR0040_3_5years() != null) {
						R0040cell14.setCellValue(record.getR0040_3_5years().doubleValue());
						R0040cell14.setCellStyle(numberStyle);
					} else {
						R0040cell14.setCellValue("");
						R0040cell14.setCellStyle(textStyle);
					}

//ROW13
//Column P: 
					Cell R0040cell15 = row.createCell(15);
					if (record.getR0040_5years() != null) {
						R0040cell15.setCellValue(record.getR0040_5years().doubleValue());
						R0040cell15.setCellStyle(numberStyle);
					} else {
						R0040cell15.setCellValue("");
						R0040cell15.setCellStyle(textStyle);
					}

/////ROW14///////////
//ROW14

					row = sheet.getRow(13);

//Column E: 
					Cell R0050cell4 = row.createCell(4);
					if (record.getR0050_overdue() != null) {
						R0050cell4.setCellValue(record.getR0050_overdue().doubleValue());
						R0050cell4.setCellStyle(numberStyle);
					} else {
						R0050cell4.setCellValue("");
						R0050cell4.setCellStyle(textStyle);
					}

//ROW14
//Column F: 
					Cell R0050cell5 = row.createCell(5);
					if (record.getR0050_overdraft() != null) {
						R0050cell5.setCellValue(record.getR0050_overdraft().doubleValue());
						R0050cell5.setCellStyle(numberStyle);
					} else {
						R0050cell5.setCellValue("");
						R0050cell5.setCellStyle(textStyle);
					}

//ROW14
//Column G: 
					Cell R0050cell6 = row.createCell(6);
					if (record.getR0050_0_7days() != null) {
						R0050cell6.setCellValue(record.getR0050_0_7days().doubleValue());
						R0050cell6.setCellStyle(numberStyle);
					} else {
						R0050cell6.setCellValue("");
						R0050cell6.setCellStyle(textStyle);
					}

//ROW14
//Column H: 
					Cell R0050cell7 = row.createCell(7);
					if (record.getR0050_8_14days() != null) {
						R0050cell7.setCellValue(record.getR0050_8_14days().doubleValue());
						R0050cell7.setCellStyle(numberStyle);
					} else {
						R0050cell7.setCellValue("");
						R0050cell7.setCellStyle(textStyle);
					}

//ROW14
//Column I: 
					Cell R0050cell8 = row.createCell(8);
					if (record.getR0050_15days_1months() != null) {
						R0050cell8.setCellValue(record.getR0050_15days_1months().doubleValue());
						R0050cell8.setCellStyle(numberStyle);
					} else {
						R0050cell8.setCellValue("");
						R0050cell8.setCellStyle(textStyle);
					}

//ROW14
//Column J: 
					Cell R0050cell9 = row.createCell(9);
					if (record.getR0050_1_2months() != null) {
						R0050cell9.setCellValue(record.getR0050_1_2months().doubleValue());
						R0050cell9.setCellStyle(numberStyle);
					} else {
						R0050cell9.setCellValue("");
						R0050cell9.setCellStyle(textStyle);
					}

//ROW14
//Column K: 
					Cell R0050cell10 = row.createCell(10);
					if (record.getR0050_2_3months() != null) {
						R0050cell10.setCellValue(record.getR0050_2_3months().doubleValue());
						R0050cell10.setCellStyle(numberStyle);
					} else {
						R0050cell10.setCellValue("");
						R0050cell10.setCellStyle(textStyle);
					}

//ROW14
//Column L: 
					Cell R0050cell11 = row.createCell(11);
					if (record.getR0050_3_6months() != null) {
						R0050cell11.setCellValue(record.getR0050_3_6months().doubleValue());
						R0050cell11.setCellStyle(numberStyle);
					} else {
						R0050cell11.setCellValue("");
						R0050cell11.setCellStyle(textStyle);
					}

//ROW14
//Column M: 
					Cell R0050cell12 = row.createCell(12);
					if (record.getR0050_6_12months() != null) {
						R0050cell12.setCellValue(record.getR0050_6_12months().doubleValue());
						R0050cell12.setCellStyle(numberStyle);
					} else {
						R0050cell12.setCellValue("");
						R0050cell12.setCellStyle(textStyle);
					}

//ROW14
//Column N: 
					Cell R0050cell13 = row.createCell(13);
					if (record.getR0050_1_3years() != null) {
						R0050cell13.setCellValue(record.getR0050_1_3years().doubleValue());
						R0050cell13.setCellStyle(numberStyle);
					} else {
						R0050cell13.setCellValue("");
						R0050cell13.setCellStyle(textStyle);
					}

//ROW14
//Column O: 
					Cell R0050cell14 = row.createCell(14);
					if (record.getR0050_3_5years() != null) {
						R0050cell14.setCellValue(record.getR0050_3_5years().doubleValue());
						R0050cell14.setCellStyle(numberStyle);
					} else {
						R0050cell14.setCellValue("");
						R0050cell14.setCellStyle(textStyle);
					}

//ROW14
//Column P: 
					Cell R0050cell15 = row.createCell(15);
					if (record.getR0050_5years() != null) {
						R0050cell15.setCellValue(record.getR0050_5years().doubleValue());
						R0050cell15.setCellStyle(numberStyle);
					} else {
						R0050cell15.setCellValue("");
						R0050cell15.setCellStyle(textStyle);
					}

/////ROW16///////////
//ROW16

					row = sheet.getRow(15);

//Column E: 
					Cell R0070cell4 = row.createCell(4);
					if (record.getR0070_overdue() != null) {
						R0070cell4.setCellValue(record.getR0070_overdue().doubleValue());
						R0070cell4.setCellStyle(numberStyle);
					} else {
						R0070cell4.setCellValue("");
						R0070cell4.setCellStyle(textStyle);
					}

//ROW16
//Column F: 
					Cell R0070cell5 = row.createCell(5);
					if (record.getR0070_overdraft() != null) {
						R0070cell5.setCellValue(record.getR0070_overdraft().doubleValue());
						R0070cell5.setCellStyle(numberStyle);
					} else {
						R0070cell5.setCellValue("");
						R0070cell5.setCellStyle(textStyle);
					}

//ROW16
//Column G: 
					Cell R0070cell6 = row.createCell(6);
					if (record.getR0070_0_7days() != null) {
						R0070cell6.setCellValue(record.getR0070_0_7days().doubleValue());
						R0070cell6.setCellStyle(numberStyle);
					} else {
						R0070cell6.setCellValue("");
						R0070cell6.setCellStyle(textStyle);
					}

//ROW16
//Column H: 
					Cell R0070cell7 = row.createCell(7);
					if (record.getR0070_8_14days() != null) {
						R0070cell7.setCellValue(record.getR0070_8_14days().doubleValue());
						R0070cell7.setCellStyle(numberStyle);
					} else {
						R0070cell7.setCellValue("");
						R0070cell7.setCellStyle(textStyle);
					}

//ROW16
//Column I: 
					Cell R0070cell8 = row.createCell(8);
					if (record.getR0070_15days_1months() != null) {
						R0070cell8.setCellValue(record.getR0070_15days_1months().doubleValue());
						R0070cell8.setCellStyle(numberStyle);
					} else {
						R0070cell8.setCellValue("");
						R0070cell8.setCellStyle(textStyle);
					}

//ROW16
//Column J: 
					Cell R0070cell9 = row.createCell(9);
					if (record.getR0070_1_2months() != null) {
						R0070cell9.setCellValue(record.getR0070_1_2months().doubleValue());
						R0070cell9.setCellStyle(numberStyle);
					} else {
						R0070cell9.setCellValue("");
						R0070cell9.setCellStyle(textStyle);
					}

//ROW16
//Column K: 
					Cell R0070cell10 = row.createCell(10);
					if (record.getR0070_2_3months() != null) {
						R0070cell10.setCellValue(record.getR0070_2_3months().doubleValue());
						R0070cell10.setCellStyle(numberStyle);
					} else {
						R0070cell10.setCellValue("");
						R0070cell10.setCellStyle(textStyle);
					}

//ROW16
//Column L: 
					Cell R0070cell11 = row.createCell(11);
					if (record.getR0070_3_6months() != null) {
						R0070cell11.setCellValue(record.getR0070_3_6months().doubleValue());
						R0070cell11.setCellStyle(numberStyle);
					} else {
						R0070cell11.setCellValue("");
						R0070cell11.setCellStyle(textStyle);
					}

//ROW16
//Column M: 
					Cell R0070cell12 = row.createCell(12);
					if (record.getR0070_6_12months() != null) {
						R0070cell12.setCellValue(record.getR0070_6_12months().doubleValue());
						R0070cell12.setCellStyle(numberStyle);
					} else {
						R0070cell12.setCellValue("");
						R0070cell12.setCellStyle(textStyle);
					}

//ROW16
//Column N: 
					Cell R0070cell13 = row.createCell(13);
					if (record.getR0070_1_3years() != null) {
						R0070cell13.setCellValue(record.getR0070_1_3years().doubleValue());
						R0070cell13.setCellStyle(numberStyle);
					} else {
						R0070cell13.setCellValue("");
						R0070cell13.setCellStyle(textStyle);
					}

//ROW16
//Column O: 
					Cell R0070cell14 = row.createCell(14);
					if (record.getR0070_3_5years() != null) {
						R0070cell14.setCellValue(record.getR0070_3_5years().doubleValue());
						R0070cell14.setCellStyle(numberStyle);
					} else {
						R0070cell14.setCellValue("");
						R0070cell14.setCellStyle(textStyle);
					}

//ROW16
//Column P: 
					Cell R0070cell15 = row.createCell(15);
					if (record.getR0070_5years() != null) {
						R0070cell15.setCellValue(record.getR0070_5years().doubleValue());
						R0070cell15.setCellStyle(numberStyle);
					} else {
						R0070cell15.setCellValue("");
						R0070cell15.setCellStyle(textStyle);
					}

/////ROW17///////////
//ROW17

					row = sheet.getRow(16);

//Column E: 
					Cell R0080cell4 = row.createCell(4);
					if (record.getR0080_overdue() != null) {
						R0080cell4.setCellValue(record.getR0080_overdue().doubleValue());
						R0080cell4.setCellStyle(numberStyle);
					} else {
						R0080cell4.setCellValue("");
						R0080cell4.setCellStyle(textStyle);
					}

//ROW17
//Column F: 
					Cell R0080cell5 = row.createCell(5);
					if (record.getR0080_overdraft() != null) {
						R0080cell5.setCellValue(record.getR0080_overdraft().doubleValue());
						R0080cell5.setCellStyle(numberStyle);
					} else {
						R0080cell5.setCellValue("");
						R0080cell5.setCellStyle(textStyle);
					}

//ROW17
//Column G: 
					Cell R0080cell6 = row.createCell(6);
					if (record.getR0080_0_7days() != null) {
						R0080cell6.setCellValue(record.getR0080_0_7days().doubleValue());
						R0080cell6.setCellStyle(numberStyle);
					} else {
						R0080cell6.setCellValue("");
						R0080cell6.setCellStyle(textStyle);
					}

//ROW17
//Column H: 
					Cell R0080cell7 = row.createCell(7);
					if (record.getR0080_8_14days() != null) {
						R0080cell7.setCellValue(record.getR0080_8_14days().doubleValue());
						R0080cell7.setCellStyle(numberStyle);
					} else {
						R0080cell7.setCellValue("");
						R0080cell7.setCellStyle(textStyle);
					}

//ROW17
//Column I: 
					Cell R0080cell8 = row.createCell(8);
					if (record.getR0080_15days_1months() != null) {
						R0080cell8.setCellValue(record.getR0080_15days_1months().doubleValue());
						R0080cell8.setCellStyle(numberStyle);
					} else {
						R0080cell8.setCellValue("");
						R0080cell8.setCellStyle(textStyle);
					}

//ROW17
//Column J: 
					Cell R0080cell9 = row.createCell(9);
					if (record.getR0080_1_2months() != null) {
						R0080cell9.setCellValue(record.getR0080_1_2months().doubleValue());
						R0080cell9.setCellStyle(numberStyle);
					} else {
						R0080cell9.setCellValue("");
						R0080cell9.setCellStyle(textStyle);
					}

//ROW17
//Column K: 
					Cell R0080cell10 = row.createCell(10);
					if (record.getR0080_2_3months() != null) {
						R0080cell10.setCellValue(record.getR0080_2_3months().doubleValue());
						R0080cell10.setCellStyle(numberStyle);
					} else {
						R0080cell10.setCellValue("");
						R0080cell10.setCellStyle(textStyle);
					}

//ROW17
//Column L: 
					Cell R0080cell11 = row.createCell(11);
					if (record.getR0080_3_6months() != null) {
						R0080cell11.setCellValue(record.getR0080_3_6months().doubleValue());
						R0080cell11.setCellStyle(numberStyle);
					} else {
						R0080cell11.setCellValue("");
						R0080cell11.setCellStyle(textStyle);
					}

//ROW17
//Column M: 
					Cell R0080cell12 = row.createCell(12);
					if (record.getR0080_6_12months() != null) {
						R0080cell12.setCellValue(record.getR0080_6_12months().doubleValue());
						R0080cell12.setCellStyle(numberStyle);
					} else {
						R0080cell12.setCellValue("");
						R0080cell12.setCellStyle(textStyle);
					}

//ROW17
//Column N: 
					Cell R0080cell13 = row.createCell(13);
					if (record.getR0080_1_3years() != null) {
						R0080cell13.setCellValue(record.getR0080_1_3years().doubleValue());
						R0080cell13.setCellStyle(numberStyle);
					} else {
						R0080cell13.setCellValue("");
						R0080cell13.setCellStyle(textStyle);
					}

//ROW17
//Column O: 
					Cell R0080cell14 = row.createCell(14);
					if (record.getR0080_3_5years() != null) {
						R0080cell14.setCellValue(record.getR0080_3_5years().doubleValue());
						R0080cell14.setCellStyle(numberStyle);
					} else {
						R0080cell14.setCellValue("");
						R0080cell14.setCellStyle(textStyle);
					}

//ROW17
//Column P: 
					Cell R0080cell15 = row.createCell(15);
					if (record.getR0080_5years() != null) {
						R0080cell15.setCellValue(record.getR0080_5years().doubleValue());
						R0080cell15.setCellStyle(numberStyle);
					} else {
						R0080cell15.setCellValue("");
						R0080cell15.setCellStyle(textStyle);
					}

/////ROW18///////////
//ROW18

					row = sheet.getRow(17);

//Column E: 
					Cell R0090cell4 = row.createCell(4);
					if (record.getR0090_overdue() != null) {
						R0090cell4.setCellValue(record.getR0090_overdue().doubleValue());
						R0090cell4.setCellStyle(numberStyle);
					} else {
						R0090cell4.setCellValue("");
						R0090cell4.setCellStyle(textStyle);
					}

//ROW18
//Column F: 
					Cell R0090cell5 = row.createCell(5);
					if (record.getR0090_overdraft() != null) {
						R0090cell5.setCellValue(record.getR0090_overdraft().doubleValue());
						R0090cell5.setCellStyle(numberStyle);
					} else {
						R0090cell5.setCellValue("");
						R0090cell5.setCellStyle(textStyle);
					}

//ROW18
//Column G: 
					Cell R0090cell6 = row.createCell(6);
					if (record.getR0090_0_7days() != null) {
						R0090cell6.setCellValue(record.getR0090_0_7days().doubleValue());
						R0090cell6.setCellStyle(numberStyle);
					} else {
						R0090cell6.setCellValue("");
						R0090cell6.setCellStyle(textStyle);
					}

//ROW18
//Column H: 
					Cell R0090cell7 = row.createCell(7);
					if (record.getR0090_8_14days() != null) {
						R0090cell7.setCellValue(record.getR0090_8_14days().doubleValue());
						R0090cell7.setCellStyle(numberStyle);
					} else {
						R0090cell7.setCellValue("");
						R0090cell7.setCellStyle(textStyle);
					}

//ROW18
//Column I: 
					Cell R0090cell8 = row.createCell(8);
					if (record.getR0090_15days_1months() != null) {
						R0090cell8.setCellValue(record.getR0090_15days_1months().doubleValue());
						R0090cell8.setCellStyle(numberStyle);
					} else {
						R0090cell8.setCellValue("");
						R0090cell8.setCellStyle(textStyle);
					}

//ROW18
//Column J: 
					Cell R0090cell9 = row.createCell(9);
					if (record.getR0090_1_2months() != null) {
						R0090cell9.setCellValue(record.getR0090_1_2months().doubleValue());
						R0090cell9.setCellStyle(numberStyle);
					} else {
						R0090cell9.setCellValue("");
						R0090cell9.setCellStyle(textStyle);
					}

//ROW18
//Column K: 
					Cell R0090cell10 = row.createCell(10);
					if (record.getR0090_2_3months() != null) {
						R0090cell10.setCellValue(record.getR0090_2_3months().doubleValue());
						R0090cell10.setCellStyle(numberStyle);
					} else {
						R0090cell10.setCellValue("");
						R0090cell10.setCellStyle(textStyle);
					}

//ROW18
//Column L: 
					Cell R0090cell11 = row.createCell(11);
					if (record.getR0090_3_6months() != null) {
						R0090cell11.setCellValue(record.getR0090_3_6months().doubleValue());
						R0090cell11.setCellStyle(numberStyle);
					} else {
						R0090cell11.setCellValue("");
						R0090cell11.setCellStyle(textStyle);
					}

//ROW18
//Column M: 
					Cell R0090cell12 = row.createCell(12);
					if (record.getR0090_6_12months() != null) {
						R0090cell12.setCellValue(record.getR0090_6_12months().doubleValue());
						R0090cell12.setCellStyle(numberStyle);
					} else {
						R0090cell12.setCellValue("");
						R0090cell12.setCellStyle(textStyle);
					}

//ROW18
//Column N: 
					Cell R0090cell13 = row.createCell(13);
					if (record.getR0090_1_3years() != null) {
						R0090cell13.setCellValue(record.getR0090_1_3years().doubleValue());
						R0090cell13.setCellStyle(numberStyle);
					} else {
						R0090cell13.setCellValue("");
						R0090cell13.setCellStyle(textStyle);
					}

//ROW18
//Column O: 
					Cell R0090cell14 = row.createCell(14);
					if (record.getR0090_3_5years() != null) {
						R0090cell14.setCellValue(record.getR0090_3_5years().doubleValue());
						R0090cell14.setCellStyle(numberStyle);
					} else {
						R0090cell14.setCellValue("");
						R0090cell14.setCellStyle(textStyle);
					}

//ROW18
//Column P: 
					Cell R0090cell15 = row.createCell(15);
					if (record.getR0090_5years() != null) {
						R0090cell15.setCellValue(record.getR0090_5years().doubleValue());
						R0090cell15.setCellStyle(numberStyle);
					} else {
						R0090cell15.setCellValue("");
						R0090cell15.setCellStyle(textStyle);
					}

/////ROW20///////////
//ROW20

					row = sheet.getRow(19);

//Column E: 
					Cell R0110cell4 = row.createCell(4);
					if (record.getR0110_overdue() != null) {
						R0110cell4.setCellValue(record.getR0110_overdue().doubleValue());
						R0110cell4.setCellStyle(numberStyle);
					} else {
						R0110cell4.setCellValue("");
						R0110cell4.setCellStyle(textStyle);
					}

//ROW20
//Column F: 
					Cell R0110cell5 = row.createCell(5);
					if (record.getR0110_overdraft() != null) {
						R0110cell5.setCellValue(record.getR0110_overdraft().doubleValue());
						R0110cell5.setCellStyle(numberStyle);
					} else {
						R0110cell5.setCellValue("");
						R0110cell5.setCellStyle(textStyle);
					}

//ROW20
//Column G: 
					Cell R0110cell6 = row.createCell(6);
					if (record.getR0110_0_7days() != null) {
						R0110cell6.setCellValue(record.getR0110_0_7days().doubleValue());
						R0110cell6.setCellStyle(numberStyle);
					} else {
						R0110cell6.setCellValue("");
						R0110cell6.setCellStyle(textStyle);
					}

//ROW20
//Column H: 
					Cell R0110cell7 = row.createCell(7);
					if (record.getR0110_8_14days() != null) {
						R0110cell7.setCellValue(record.getR0110_8_14days().doubleValue());
						R0110cell7.setCellStyle(numberStyle);
					} else {
						R0110cell7.setCellValue("");
						R0110cell7.setCellStyle(textStyle);
					}

//ROW20
//Column I: 
					Cell R0110cell8 = row.createCell(8);
					if (record.getR0110_15days_1months() != null) {
						R0110cell8.setCellValue(record.getR0110_15days_1months().doubleValue());
						R0110cell8.setCellStyle(numberStyle);
					} else {
						R0110cell8.setCellValue("");
						R0110cell8.setCellStyle(textStyle);
					}

//ROW20
//Column J: 
					Cell R0110cell9 = row.createCell(9);
					if (record.getR0110_1_2months() != null) {
						R0110cell9.setCellValue(record.getR0110_1_2months().doubleValue());
						R0110cell9.setCellStyle(numberStyle);
					} else {
						R0110cell9.setCellValue("");
						R0110cell9.setCellStyle(textStyle);
					}

//ROW20
//Column K: 
					Cell R0110cell10 = row.createCell(10);
					if (record.getR0110_2_3months() != null) {
						R0110cell10.setCellValue(record.getR0110_2_3months().doubleValue());
						R0110cell10.setCellStyle(numberStyle);
					} else {
						R0110cell10.setCellValue("");
						R0110cell10.setCellStyle(textStyle);
					}

//ROW20
//Column L: 
					Cell R0110cell11 = row.createCell(11);
					if (record.getR0110_3_6months() != null) {
						R0110cell11.setCellValue(record.getR0110_3_6months().doubleValue());
						R0110cell11.setCellStyle(numberStyle);
					} else {
						R0110cell11.setCellValue("");
						R0110cell11.setCellStyle(textStyle);
					}

//ROW20
//Column M: 
					Cell R0110cell12 = row.createCell(12);
					if (record.getR0110_6_12months() != null) {
						R0110cell12.setCellValue(record.getR0110_6_12months().doubleValue());
						R0110cell12.setCellStyle(numberStyle);
					} else {
						R0110cell12.setCellValue("");
						R0110cell12.setCellStyle(textStyle);
					}

//ROW20
//Column N: 
					Cell R0110cell13 = row.createCell(13);
					if (record.getR0110_1_3years() != null) {
						R0110cell13.setCellValue(record.getR0110_1_3years().doubleValue());
						R0110cell13.setCellStyle(numberStyle);
					} else {
						R0110cell13.setCellValue("");
						R0110cell13.setCellStyle(textStyle);
					}

//ROW20
//Column O: 
					Cell R0110cell14 = row.createCell(14);
					if (record.getR0110_3_5years() != null) {
						R0110cell14.setCellValue(record.getR0110_3_5years().doubleValue());
						R0110cell14.setCellStyle(numberStyle);
					} else {
						R0110cell14.setCellValue("");
						R0110cell14.setCellStyle(textStyle);
					}

//ROW20
//Column P: 
					Cell R0110cell15 = row.createCell(15);
					if (record.getR0110_5years() != null) {
						R0110cell15.setCellValue(record.getR0110_5years().doubleValue());
						R0110cell15.setCellStyle(numberStyle);
					} else {
						R0110cell15.setCellValue("");
						R0110cell15.setCellStyle(textStyle);
					}

/////ROW21///////////
//ROW21

					row = sheet.getRow(20);

//Column E: 
					Cell R0120cell4 = row.createCell(4);
					if (record.getR0120_overdue() != null) {
						R0120cell4.setCellValue(record.getR0120_overdue().doubleValue());
						R0120cell4.setCellStyle(numberStyle);
					} else {
						R0120cell4.setCellValue("");
						R0120cell4.setCellStyle(textStyle);
					}

//ROW21
//Column F: 
					Cell R0120cell5 = row.createCell(5);
					if (record.getR0120_overdraft() != null) {
						R0120cell5.setCellValue(record.getR0120_overdraft().doubleValue());
						R0120cell5.setCellStyle(numberStyle);
					} else {
						R0120cell5.setCellValue("");
						R0120cell5.setCellStyle(textStyle);
					}

//ROW21
//Column G: 
					Cell R0120cell6 = row.createCell(6);
					if (record.getR0120_0_7days() != null) {
						R0120cell6.setCellValue(record.getR0120_0_7days().doubleValue());
						R0120cell6.setCellStyle(numberStyle);
					} else {
						R0120cell6.setCellValue("");
						R0120cell6.setCellStyle(textStyle);
					}

//ROW21
//Column H: 
					Cell R0120cell7 = row.createCell(7);
					if (record.getR0120_8_14days() != null) {
						R0120cell7.setCellValue(record.getR0120_8_14days().doubleValue());
						R0120cell7.setCellStyle(numberStyle);
					} else {
						R0120cell7.setCellValue("");
						R0120cell7.setCellStyle(textStyle);
					}

//ROW21
//Column I: 
					Cell R0120cell8 = row.createCell(8);
					if (record.getR0120_15days_1months() != null) {
						R0120cell8.setCellValue(record.getR0120_15days_1months().doubleValue());
						R0120cell8.setCellStyle(numberStyle);
					} else {
						R0120cell8.setCellValue("");
						R0120cell8.setCellStyle(textStyle);
					}

//ROW21
//Column J: 
					Cell R0120cell9 = row.createCell(9);
					if (record.getR0120_1_2months() != null) {
						R0120cell9.setCellValue(record.getR0120_1_2months().doubleValue());
						R0120cell9.setCellStyle(numberStyle);
					} else {
						R0120cell9.setCellValue("");
						R0120cell9.setCellStyle(textStyle);
					}

//ROW21
//Column K: 
					Cell R0120cell10 = row.createCell(10);
					if (record.getR0120_2_3months() != null) {
						R0120cell10.setCellValue(record.getR0120_2_3months().doubleValue());
						R0120cell10.setCellStyle(numberStyle);
					} else {
						R0120cell10.setCellValue("");
						R0120cell10.setCellStyle(textStyle);
					}

//ROW21
//Column L: 
					Cell R0120cell11 = row.createCell(11);
					if (record.getR0120_3_6months() != null) {
						R0120cell11.setCellValue(record.getR0120_3_6months().doubleValue());
						R0120cell11.setCellStyle(numberStyle);
					} else {
						R0120cell11.setCellValue("");
						R0120cell11.setCellStyle(textStyle);
					}

//ROW21
//Column M: 
					Cell R0120cell12 = row.createCell(12);
					if (record.getR0120_6_12months() != null) {
						R0120cell12.setCellValue(record.getR0120_6_12months().doubleValue());
						R0120cell12.setCellStyle(numberStyle);
					} else {
						R0120cell12.setCellValue("");
						R0120cell12.setCellStyle(textStyle);
					}

//ROW21
//Column N: 
					Cell R0120cell13 = row.createCell(13);
					if (record.getR0120_1_3years() != null) {
						R0120cell13.setCellValue(record.getR0120_1_3years().doubleValue());
						R0120cell13.setCellStyle(numberStyle);
					} else {
						R0120cell13.setCellValue("");
						R0120cell13.setCellStyle(textStyle);
					}

//ROW21
//Column O: 
					Cell R0120cell14 = row.createCell(14);
					if (record.getR0120_3_5years() != null) {
						R0120cell14.setCellValue(record.getR0120_3_5years().doubleValue());
						R0120cell14.setCellStyle(numberStyle);
					} else {
						R0120cell14.setCellValue("");
						R0120cell14.setCellStyle(textStyle);
					}

//ROW21
//Column P: 
					Cell R0120cell15 = row.createCell(15);
					if (record.getR0120_5years() != null) {
						R0120cell15.setCellValue(record.getR0120_5years().doubleValue());
						R0120cell15.setCellStyle(numberStyle);
					} else {
						R0120cell15.setCellValue("");
						R0120cell15.setCellStyle(textStyle);
					}

/////ROW22///////////
//ROW22

					row = sheet.getRow(21);

//Column E: 
					Cell R0130cell4 = row.createCell(4);
					if (record.getR0130_overdue() != null) {
						R0130cell4.setCellValue(record.getR0130_overdue().doubleValue());
						R0130cell4.setCellStyle(numberStyle);
					} else {
						R0130cell4.setCellValue("");
						R0130cell4.setCellStyle(textStyle);
					}

//ROW22
//Column F: 
					Cell R0130cell5 = row.createCell(5);
					if (record.getR0130_overdraft() != null) {
						R0130cell5.setCellValue(record.getR0130_overdraft().doubleValue());
						R0130cell5.setCellStyle(numberStyle);
					} else {
						R0130cell5.setCellValue("");
						R0130cell5.setCellStyle(textStyle);
					}

//ROW22
//Column G: 
					Cell R0130cell6 = row.createCell(6);
					if (record.getR0130_0_7days() != null) {
						R0130cell6.setCellValue(record.getR0130_0_7days().doubleValue());
						R0130cell6.setCellStyle(numberStyle);
					} else {
						R0130cell6.setCellValue("");
						R0130cell6.setCellStyle(textStyle);
					}

//ROW22
//Column H: 
					Cell R0130cell7 = row.createCell(7);
					if (record.getR0130_8_14days() != null) {
						R0130cell7.setCellValue(record.getR0130_8_14days().doubleValue());
						R0130cell7.setCellStyle(numberStyle);
					} else {
						R0130cell7.setCellValue("");
						R0130cell7.setCellStyle(textStyle);
					}

//ROW22
//Column I: 
					Cell R0130cell8 = row.createCell(8);
					if (record.getR0130_15days_1months() != null) {
						R0130cell8.setCellValue(record.getR0130_15days_1months().doubleValue());
						R0130cell8.setCellStyle(numberStyle);
					} else {
						R0130cell8.setCellValue("");
						R0130cell8.setCellStyle(textStyle);
					}

//ROW22
//Column J: 
					Cell R0130cell9 = row.createCell(9);
					if (record.getR0130_1_2months() != null) {
						R0130cell9.setCellValue(record.getR0130_1_2months().doubleValue());
						R0130cell9.setCellStyle(numberStyle);
					} else {
						R0130cell9.setCellValue("");
						R0130cell9.setCellStyle(textStyle);
					}

//ROW22
//Column K: 
					Cell R0130cell10 = row.createCell(10);
					if (record.getR0130_2_3months() != null) {
						R0130cell10.setCellValue(record.getR0130_2_3months().doubleValue());
						R0130cell10.setCellStyle(numberStyle);
					} else {
						R0130cell10.setCellValue("");
						R0130cell10.setCellStyle(textStyle);
					}

//ROW22
//Column L: 
					Cell R0130cell11 = row.createCell(11);
					if (record.getR0130_3_6months() != null) {
						R0130cell11.setCellValue(record.getR0130_3_6months().doubleValue());
						R0130cell11.setCellStyle(numberStyle);
					} else {
						R0130cell11.setCellValue("");
						R0130cell11.setCellStyle(textStyle);
					}

//ROW22
//Column M: 
					Cell R0130cell12 = row.createCell(12);
					if (record.getR0130_6_12months() != null) {
						R0130cell12.setCellValue(record.getR0130_6_12months().doubleValue());
						R0130cell12.setCellStyle(numberStyle);
					} else {
						R0130cell12.setCellValue("");
						R0130cell12.setCellStyle(textStyle);
					}

//ROW22
//Column N: 
					Cell R0130cell13 = row.createCell(13);
					if (record.getR0130_1_3years() != null) {
						R0130cell13.setCellValue(record.getR0130_1_3years().doubleValue());
						R0130cell13.setCellStyle(numberStyle);
					} else {
						R0130cell13.setCellValue("");
						R0130cell13.setCellStyle(textStyle);
					}

//ROW22
//Column O: 
					Cell R0130cell14 = row.createCell(14);
					if (record.getR0130_3_5years() != null) {
						R0130cell14.setCellValue(record.getR0130_3_5years().doubleValue());
						R0130cell14.setCellStyle(numberStyle);
					} else {
						R0130cell14.setCellValue("");
						R0130cell14.setCellStyle(textStyle);
					}

//ROW22
//Column P: 
					Cell R0130cell15 = row.createCell(15);
					if (record.getR0130_5years() != null) {
						R0130cell15.setCellValue(record.getR0130_5years().doubleValue());
						R0130cell15.setCellStyle(numberStyle);
					} else {
						R0130cell15.setCellValue("");
						R0130cell15.setCellStyle(textStyle);
					}

/////ROW23///////////
//ROW23

					row = sheet.getRow(22);

//Column E: 
					Cell R0140cell4 = row.createCell(4);
					if (record.getR0140_overdue() != null) {
						R0140cell4.setCellValue(record.getR0140_overdue().doubleValue());
						R0140cell4.setCellStyle(numberStyle);
					} else {
						R0140cell4.setCellValue("");
						R0140cell4.setCellStyle(textStyle);
					}

//ROW23
//Column F: 
					Cell R0140cell5 = row.createCell(5);
					if (record.getR0140_overdraft() != null) {
						R0140cell5.setCellValue(record.getR0140_overdraft().doubleValue());
						R0140cell5.setCellStyle(numberStyle);
					} else {
						R0140cell5.setCellValue("");
						R0140cell5.setCellStyle(textStyle);
					}

//ROW23
//Column G: 
					Cell R0140cell6 = row.createCell(6);
					if (record.getR0140_0_7days() != null) {
						R0140cell6.setCellValue(record.getR0140_0_7days().doubleValue());
						R0140cell6.setCellStyle(numberStyle);
					} else {
						R0140cell6.setCellValue("");
						R0140cell6.setCellStyle(textStyle);
					}

//ROW23
//Column H: 
					Cell R0140cell7 = row.createCell(7);
					if (record.getR0140_8_14days() != null) {
						R0140cell7.setCellValue(record.getR0140_8_14days().doubleValue());
						R0140cell7.setCellStyle(numberStyle);
					} else {
						R0140cell7.setCellValue("");
						R0140cell7.setCellStyle(textStyle);
					}

//ROW23
//Column I: 
					Cell R0140cell8 = row.createCell(8);
					if (record.getR0140_15days_1months() != null) {
						R0140cell8.setCellValue(record.getR0140_15days_1months().doubleValue());
						R0140cell8.setCellStyle(numberStyle);
					} else {
						R0140cell8.setCellValue("");
						R0140cell8.setCellStyle(textStyle);
					}

//ROW23
//Column J: 
					Cell R0140cell9 = row.createCell(9);
					if (record.getR0140_1_2months() != null) {
						R0140cell9.setCellValue(record.getR0140_1_2months().doubleValue());
						R0140cell9.setCellStyle(numberStyle);
					} else {
						R0140cell9.setCellValue("");
						R0140cell9.setCellStyle(textStyle);
					}

//ROW23
//Column K: 
					Cell R0140cell10 = row.createCell(10);
					if (record.getR0140_2_3months() != null) {
						R0140cell10.setCellValue(record.getR0140_2_3months().doubleValue());
						R0140cell10.setCellStyle(numberStyle);
					} else {
						R0140cell10.setCellValue("");
						R0140cell10.setCellStyle(textStyle);
					}

//ROW23
//Column L: 
					Cell R0140cell11 = row.createCell(11);
					if (record.getR0140_3_6months() != null) {
						R0140cell11.setCellValue(record.getR0140_3_6months().doubleValue());
						R0140cell11.setCellStyle(numberStyle);
					} else {
						R0140cell11.setCellValue("");
						R0140cell11.setCellStyle(textStyle);
					}

//ROW23
//Column M: 
					Cell R0140cell12 = row.createCell(12);
					if (record.getR0140_6_12months() != null) {
						R0140cell12.setCellValue(record.getR0140_6_12months().doubleValue());
						R0140cell12.setCellStyle(numberStyle);
					} else {
						R0140cell12.setCellValue("");
						R0140cell12.setCellStyle(textStyle);
					}

//ROW23
//Column N: 
					Cell R0140cell13 = row.createCell(13);
					if (record.getR0140_1_3years() != null) {
						R0140cell13.setCellValue(record.getR0140_1_3years().doubleValue());
						R0140cell13.setCellStyle(numberStyle);
					} else {
						R0140cell13.setCellValue("");
						R0140cell13.setCellStyle(textStyle);
					}

//ROW23
//Column O: 
					Cell R0140cell14 = row.createCell(14);
					if (record.getR0140_3_5years() != null) {
						R0140cell14.setCellValue(record.getR0140_3_5years().doubleValue());
						R0140cell14.setCellStyle(numberStyle);
					} else {
						R0140cell14.setCellValue("");
						R0140cell14.setCellStyle(textStyle);
					}

//ROW23
//Column P: 
					Cell R0140cell15 = row.createCell(15);
					if (record.getR0140_5years() != null) {
						R0140cell15.setCellValue(record.getR0140_5years().doubleValue());
						R0140cell15.setCellStyle(numberStyle);
					} else {
						R0140cell15.setCellValue("");
						R0140cell15.setCellStyle(textStyle);
					}

/////ROW24///////////
//ROW24

					row = sheet.getRow(23);

//Column E: 
					Cell R0150cell4 = row.createCell(4);
					if (record.getR0150_overdue() != null) {
						R0150cell4.setCellValue(record.getR0150_overdue().doubleValue());
						R0150cell4.setCellStyle(numberStyle);
					} else {
						R0150cell4.setCellValue("");
						R0150cell4.setCellStyle(textStyle);
					}

//ROW24
//Column F: 
					Cell R0150cell5 = row.createCell(5);
					if (record.getR0150_overdraft() != null) {
						R0150cell5.setCellValue(record.getR0150_overdraft().doubleValue());
						R0150cell5.setCellStyle(numberStyle);
					} else {
						R0150cell5.setCellValue("");
						R0150cell5.setCellStyle(textStyle);
					}

//ROW24
//Column G: 
					Cell R0150cell6 = row.createCell(6);
					if (record.getR0150_0_7days() != null) {
						R0150cell6.setCellValue(record.getR0150_0_7days().doubleValue());
						R0150cell6.setCellStyle(numberStyle);
					} else {
						R0150cell6.setCellValue("");
						R0150cell6.setCellStyle(textStyle);
					}

//ROW24
//Column H: 
					Cell R0150cell7 = row.createCell(7);
					if (record.getR0150_8_14days() != null) {
						R0150cell7.setCellValue(record.getR0150_8_14days().doubleValue());
						R0150cell7.setCellStyle(numberStyle);
					} else {
						R0150cell7.setCellValue("");
						R0150cell7.setCellStyle(textStyle);
					}

//ROW24
//Column I: 
					Cell R0150cell8 = row.createCell(8);
					if (record.getR0150_15days_1months() != null) {
						R0150cell8.setCellValue(record.getR0150_15days_1months().doubleValue());
						R0150cell8.setCellStyle(numberStyle);
					} else {
						R0150cell8.setCellValue("");
						R0150cell8.setCellStyle(textStyle);
					}

//ROW24
//Column J: 
					Cell R0150cell9 = row.createCell(9);
					if (record.getR0150_1_2months() != null) {
						R0150cell9.setCellValue(record.getR0150_1_2months().doubleValue());
						R0150cell9.setCellStyle(numberStyle);
					} else {
						R0150cell9.setCellValue("");
						R0150cell9.setCellStyle(textStyle);
					}

//ROW24
//Column K: 
					Cell R0150cell10 = row.createCell(10);
					if (record.getR0150_2_3months() != null) {
						R0150cell10.setCellValue(record.getR0150_2_3months().doubleValue());
						R0150cell10.setCellStyle(numberStyle);
					} else {
						R0150cell10.setCellValue("");
						R0150cell10.setCellStyle(textStyle);
					}

//ROW24
//Column L: 
					Cell R0150cell11 = row.createCell(11);
					if (record.getR0150_3_6months() != null) {
						R0150cell11.setCellValue(record.getR0150_3_6months().doubleValue());
						R0150cell11.setCellStyle(numberStyle);
					} else {
						R0150cell11.setCellValue("");
						R0150cell11.setCellStyle(textStyle);
					}

//ROW24
//Column M: 
					Cell R0150cell12 = row.createCell(12);
					if (record.getR0150_6_12months() != null) {
						R0150cell12.setCellValue(record.getR0150_6_12months().doubleValue());
						R0150cell12.setCellStyle(numberStyle);
					} else {
						R0150cell12.setCellValue("");
						R0150cell12.setCellStyle(textStyle);
					}

//ROW24
//Column N: 
					Cell R0150cell13 = row.createCell(13);
					if (record.getR0150_1_3years() != null) {
						R0150cell13.setCellValue(record.getR0150_1_3years().doubleValue());
						R0150cell13.setCellStyle(numberStyle);
					} else {
						R0150cell13.setCellValue("");
						R0150cell13.setCellStyle(textStyle);
					}

//ROW24
//Column O: 
					Cell R0150cell14 = row.createCell(14);
					if (record.getR0150_3_5years() != null) {
						R0150cell14.setCellValue(record.getR0150_3_5years().doubleValue());
						R0150cell14.setCellStyle(numberStyle);
					} else {
						R0150cell14.setCellValue("");
						R0150cell14.setCellStyle(textStyle);
					}

//ROW24
//Column P: 
					Cell R0150cell15 = row.createCell(15);
					if (record.getR0150_5years() != null) {
						R0150cell15.setCellValue(record.getR0150_5years().doubleValue());
						R0150cell15.setCellStyle(numberStyle);
					} else {
						R0150cell15.setCellValue("");
						R0150cell15.setCellStyle(textStyle);
					}

/////ROW25///////////
//ROW25

					row = sheet.getRow(24);

//Column E: 
					Cell R0160cell4 = row.createCell(4);
					if (record.getR0160_overdue() != null) {
						R0160cell4.setCellValue(record.getR0160_overdue().doubleValue());
						R0160cell4.setCellStyle(numberStyle);
					} else {
						R0160cell4.setCellValue("");
						R0160cell4.setCellStyle(textStyle);
					}

//ROW25
//Column F: 
					Cell R0160cell5 = row.createCell(5);
					if (record.getR0160_overdraft() != null) {
						R0160cell5.setCellValue(record.getR0160_overdraft().doubleValue());
						R0160cell5.setCellStyle(numberStyle);
					} else {
						R0160cell5.setCellValue("");
						R0160cell5.setCellStyle(textStyle);
					}

//ROW25
//Column G: 
					Cell R0160cell6 = row.createCell(6);
					if (record.getR0160_0_7days() != null) {
						R0160cell6.setCellValue(record.getR0160_0_7days().doubleValue());
						R0160cell6.setCellStyle(numberStyle);
					} else {
						R0160cell6.setCellValue("");
						R0160cell6.setCellStyle(textStyle);
					}

//ROW25
//Column H: 
					Cell R0160cell7 = row.createCell(7);
					if (record.getR0160_8_14days() != null) {
						R0160cell7.setCellValue(record.getR0160_8_14days().doubleValue());
						R0160cell7.setCellStyle(numberStyle);
					} else {
						R0160cell7.setCellValue("");
						R0160cell7.setCellStyle(textStyle);
					}

//ROW25
//Column I: 
					Cell R0160cell8 = row.createCell(8);
					if (record.getR0160_15days_1months() != null) {
						R0160cell8.setCellValue(record.getR0160_15days_1months().doubleValue());
						R0160cell8.setCellStyle(numberStyle);
					} else {
						R0160cell8.setCellValue("");
						R0160cell8.setCellStyle(textStyle);
					}

//ROW25
//Column J: 
					Cell R0160cell9 = row.createCell(9);
					if (record.getR0160_1_2months() != null) {
						R0160cell9.setCellValue(record.getR0160_1_2months().doubleValue());
						R0160cell9.setCellStyle(numberStyle);
					} else {
						R0160cell9.setCellValue("");
						R0160cell9.setCellStyle(textStyle);
					}

//ROW25
//Column K: 
					Cell R0160cell10 = row.createCell(10);
					if (record.getR0160_2_3months() != null) {
						R0160cell10.setCellValue(record.getR0160_2_3months().doubleValue());
						R0160cell10.setCellStyle(numberStyle);
					} else {
						R0160cell10.setCellValue("");
						R0160cell10.setCellStyle(textStyle);
					}

//ROW25
//Column L: 
					Cell R0160cell11 = row.createCell(11);
					if (record.getR0160_3_6months() != null) {
						R0160cell11.setCellValue(record.getR0160_3_6months().doubleValue());
						R0160cell11.setCellStyle(numberStyle);
					} else {
						R0160cell11.setCellValue("");
						R0160cell11.setCellStyle(textStyle);
					}

//ROW25
//Column M: 
					Cell R0160cell12 = row.createCell(12);
					if (record.getR0160_6_12months() != null) {
						R0160cell12.setCellValue(record.getR0160_6_12months().doubleValue());
						R0160cell12.setCellStyle(numberStyle);
					} else {
						R0160cell12.setCellValue("");
						R0160cell12.setCellStyle(textStyle);
					}

//ROW25
//Column N: 
					Cell R0160cell13 = row.createCell(13);
					if (record.getR0160_1_3years() != null) {
						R0160cell13.setCellValue(record.getR0160_1_3years().doubleValue());
						R0160cell13.setCellStyle(numberStyle);
					} else {
						R0160cell13.setCellValue("");
						R0160cell13.setCellStyle(textStyle);
					}

//ROW25
//Column O: 
					Cell R0160cell14 = row.createCell(14);
					if (record.getR0160_3_5years() != null) {
						R0160cell14.setCellValue(record.getR0160_3_5years().doubleValue());
						R0160cell14.setCellStyle(numberStyle);
					} else {
						R0160cell14.setCellValue("");
						R0160cell14.setCellStyle(textStyle);
					}

//ROW25
//Column P: 
					Cell R0160cell15 = row.createCell(15);
					if (record.getR0160_5years() != null) {
						R0160cell15.setCellValue(record.getR0160_5years().doubleValue());
						R0160cell15.setCellStyle(numberStyle);
					} else {
						R0160cell15.setCellValue("");
						R0160cell15.setCellStyle(textStyle);
					}

/////ROW26///////////
//ROW26

					row = sheet.getRow(25);

//Column E: 
					Cell R0170cell4 = row.createCell(4);
					if (record.getR0170_overdue() != null) {
						R0170cell4.setCellValue(record.getR0170_overdue().doubleValue());
						R0170cell4.setCellStyle(numberStyle);
					} else {
						R0170cell4.setCellValue("");
						R0170cell4.setCellStyle(textStyle);
					}

//ROW26
//Column F: 
					Cell R0170cell5 = row.createCell(5);
					if (record.getR0170_overdraft() != null) {
						R0170cell5.setCellValue(record.getR0170_overdraft().doubleValue());
						R0170cell5.setCellStyle(numberStyle);
					} else {
						R0170cell5.setCellValue("");
						R0170cell5.setCellStyle(textStyle);
					}

//ROW26
//Column G: 
					Cell R0170cell6 = row.createCell(6);
					if (record.getR0170_0_7days() != null) {
						R0170cell6.setCellValue(record.getR0170_0_7days().doubleValue());
						R0170cell6.setCellStyle(numberStyle);
					} else {
						R0170cell6.setCellValue("");
						R0170cell6.setCellStyle(textStyle);
					}

//ROW26
//Column H: 
					Cell R0170cell7 = row.createCell(7);
					if (record.getR0170_8_14days() != null) {
						R0170cell7.setCellValue(record.getR0170_8_14days().doubleValue());
						R0170cell7.setCellStyle(numberStyle);
					} else {
						R0170cell7.setCellValue("");
						R0170cell7.setCellStyle(textStyle);
					}

//ROW26
//Column I: 
					Cell R0170cell8 = row.createCell(8);
					if (record.getR0170_15days_1months() != null) {
						R0170cell8.setCellValue(record.getR0170_15days_1months().doubleValue());
						R0170cell8.setCellStyle(numberStyle);
					} else {
						R0170cell8.setCellValue("");
						R0170cell8.setCellStyle(textStyle);
					}

//ROW26
//Column J: 
					Cell R0170cell9 = row.createCell(9);
					if (record.getR0170_1_2months() != null) {
						R0170cell9.setCellValue(record.getR0170_1_2months().doubleValue());
						R0170cell9.setCellStyle(numberStyle);
					} else {
						R0170cell9.setCellValue("");
						R0170cell9.setCellStyle(textStyle);
					}

//ROW26
//Column K: 
					Cell R0170cell10 = row.createCell(10);
					if (record.getR0170_2_3months() != null) {
						R0170cell10.setCellValue(record.getR0170_2_3months().doubleValue());
						R0170cell10.setCellStyle(numberStyle);
					} else {
						R0170cell10.setCellValue("");
						R0170cell10.setCellStyle(textStyle);
					}

//ROW26
//Column L: 
					Cell R0170cell11 = row.createCell(11);
					if (record.getR0170_3_6months() != null) {
						R0170cell11.setCellValue(record.getR0170_3_6months().doubleValue());
						R0170cell11.setCellStyle(numberStyle);
					} else {
						R0170cell11.setCellValue("");
						R0170cell11.setCellStyle(textStyle);
					}

//ROW26
//Column M: 
					Cell R0170cell12 = row.createCell(12);
					if (record.getR0170_6_12months() != null) {
						R0170cell12.setCellValue(record.getR0170_6_12months().doubleValue());
						R0170cell12.setCellStyle(numberStyle);
					} else {
						R0170cell12.setCellValue("");
						R0170cell12.setCellStyle(textStyle);
					}

//ROW26
//Column N: 
					Cell R0170cell13 = row.createCell(13);
					if (record.getR0170_1_3years() != null) {
						R0170cell13.setCellValue(record.getR0170_1_3years().doubleValue());
						R0170cell13.setCellStyle(numberStyle);
					} else {
						R0170cell13.setCellValue("");
						R0170cell13.setCellStyle(textStyle);
					}

//ROW26
//Column O: 
					Cell R0170cell14 = row.createCell(14);
					if (record.getR0170_3_5years() != null) {
						R0170cell14.setCellValue(record.getR0170_3_5years().doubleValue());
						R0170cell14.setCellStyle(numberStyle);
					} else {
						R0170cell14.setCellValue("");
						R0170cell14.setCellStyle(textStyle);
					}

//ROW26
//Column P: 
					Cell R0170cell15 = row.createCell(15);
					if (record.getR0170_5years() != null) {
						R0170cell15.setCellValue(record.getR0170_5years().doubleValue());
						R0170cell15.setCellStyle(numberStyle);
					} else {
						R0170cell15.setCellValue("");
						R0170cell15.setCellStyle(textStyle);
					}

/////ROW27///////////
//ROW27

					row = sheet.getRow(26);

//Column E: 
					Cell R0180cell4 = row.createCell(4);
					if (record.getR0180_overdue() != null) {
						R0180cell4.setCellValue(record.getR0180_overdue().doubleValue());
						R0180cell4.setCellStyle(numberStyle);
					} else {
						R0180cell4.setCellValue("");
						R0180cell4.setCellStyle(textStyle);
					}

//ROW27
//Column F: 
					Cell R0180cell5 = row.createCell(5);
					if (record.getR0180_overdraft() != null) {
						R0180cell5.setCellValue(record.getR0180_overdraft().doubleValue());
						R0180cell5.setCellStyle(numberStyle);
					} else {
						R0180cell5.setCellValue("");
						R0180cell5.setCellStyle(textStyle);
					}

//ROW27
//Column G: 
					Cell R0180cell6 = row.createCell(6);
					if (record.getR0180_0_7days() != null) {
						R0180cell6.setCellValue(record.getR0180_0_7days().doubleValue());
						R0180cell6.setCellStyle(numberStyle);
					} else {
						R0180cell6.setCellValue("");
						R0180cell6.setCellStyle(textStyle);
					}

//ROW27
//Column H: 
					Cell R0180cell7 = row.createCell(7);
					if (record.getR0180_8_14days() != null) {
						R0180cell7.setCellValue(record.getR0180_8_14days().doubleValue());
						R0180cell7.setCellStyle(numberStyle);
					} else {
						R0180cell7.setCellValue("");
						R0180cell7.setCellStyle(textStyle);
					}

//ROW27
//Column I: 
					Cell R0180cell8 = row.createCell(8);
					if (record.getR0180_15days_1months() != null) {
						R0180cell8.setCellValue(record.getR0180_15days_1months().doubleValue());
						R0180cell8.setCellStyle(numberStyle);
					} else {
						R0180cell8.setCellValue("");
						R0180cell8.setCellStyle(textStyle);
					}

//ROW27
//Column J: 
					Cell R0180cell9 = row.createCell(9);
					if (record.getR0180_1_2months() != null) {
						R0180cell9.setCellValue(record.getR0180_1_2months().doubleValue());
						R0180cell9.setCellStyle(numberStyle);
					} else {
						R0180cell9.setCellValue("");
						R0180cell9.setCellStyle(textStyle);
					}

//ROW27
//Column K: 
					Cell R0180cell10 = row.createCell(10);
					if (record.getR0180_2_3months() != null) {
						R0180cell10.setCellValue(record.getR0180_2_3months().doubleValue());
						R0180cell10.setCellStyle(numberStyle);
					} else {
						R0180cell10.setCellValue("");
						R0180cell10.setCellStyle(textStyle);
					}

//ROW27
//Column L: 
					Cell R0180cell11 = row.createCell(11);
					if (record.getR0180_3_6months() != null) {
						R0180cell11.setCellValue(record.getR0180_3_6months().doubleValue());
						R0180cell11.setCellStyle(numberStyle);
					} else {
						R0180cell11.setCellValue("");
						R0180cell11.setCellStyle(textStyle);
					}

//ROW27
//Column M: 
					Cell R0180cell12 = row.createCell(12);
					if (record.getR0180_6_12months() != null) {
						R0180cell12.setCellValue(record.getR0180_6_12months().doubleValue());
						R0180cell12.setCellStyle(numberStyle);
					} else {
						R0180cell12.setCellValue("");
						R0180cell12.setCellStyle(textStyle);
					}

//ROW27
//Column N: 
					Cell R0180cell13 = row.createCell(13);
					if (record.getR0180_1_3years() != null) {
						R0180cell13.setCellValue(record.getR0180_1_3years().doubleValue());
						R0180cell13.setCellStyle(numberStyle);
					} else {
						R0180cell13.setCellValue("");
						R0180cell13.setCellStyle(textStyle);
					}

//ROW27
//Column O: 
					Cell R0180cell14 = row.createCell(14);
					if (record.getR0180_3_5years() != null) {
						R0180cell14.setCellValue(record.getR0180_3_5years().doubleValue());
						R0180cell14.setCellStyle(numberStyle);
					} else {
						R0180cell14.setCellValue("");
						R0180cell14.setCellStyle(textStyle);
					}

//ROW27
//Column P: 
					Cell R0180cell15 = row.createCell(15);
					if (record.getR0180_5years() != null) {
						R0180cell15.setCellValue(record.getR0180_5years().doubleValue());
						R0180cell15.setCellStyle(numberStyle);
					} else {
						R0180cell15.setCellValue("");
						R0180cell15.setCellStyle(textStyle);
					}

/////ROW28///////////
//ROW28

					row = sheet.getRow(27);

//Column E: 
					Cell R0190cell4 = row.createCell(4);
					if (record.getR0190_overdue() != null) {
						R0190cell4.setCellValue(record.getR0190_overdue().doubleValue());
						R0190cell4.setCellStyle(numberStyle);
					} else {
						R0190cell4.setCellValue("");
						R0190cell4.setCellStyle(textStyle);
					}

//ROW28
//Column F: 
					Cell R0190cell5 = row.createCell(5);
					if (record.getR0190_overdraft() != null) {
						R0190cell5.setCellValue(record.getR0190_overdraft().doubleValue());
						R0190cell5.setCellStyle(numberStyle);
					} else {
						R0190cell5.setCellValue("");
						R0190cell5.setCellStyle(textStyle);
					}

//ROW28
//Column G: 
					Cell R0190cell6 = row.createCell(6);
					if (record.getR0190_0_7days() != null) {
						R0190cell6.setCellValue(record.getR0190_0_7days().doubleValue());
						R0190cell6.setCellStyle(numberStyle);
					} else {
						R0190cell6.setCellValue("");
						R0190cell6.setCellStyle(textStyle);
					}

//ROW28
//Column H: 
					Cell R0190cell7 = row.createCell(7);
					if (record.getR0190_8_14days() != null) {
						R0190cell7.setCellValue(record.getR0190_8_14days().doubleValue());
						R0190cell7.setCellStyle(numberStyle);
					} else {
						R0190cell7.setCellValue("");
						R0190cell7.setCellStyle(textStyle);
					}

//ROW28
//Column I: 
					Cell R0190cell8 = row.createCell(8);
					if (record.getR0190_15days_1months() != null) {
						R0190cell8.setCellValue(record.getR0190_15days_1months().doubleValue());
						R0190cell8.setCellStyle(numberStyle);
					} else {
						R0190cell8.setCellValue("");
						R0190cell8.setCellStyle(textStyle);
					}

//ROW28
//Column J: 
					Cell R0190cell9 = row.createCell(9);
					if (record.getR0190_1_2months() != null) {
						R0190cell9.setCellValue(record.getR0190_1_2months().doubleValue());
						R0190cell9.setCellStyle(numberStyle);
					} else {
						R0190cell9.setCellValue("");
						R0190cell9.setCellStyle(textStyle);
					}

//ROW28
//Column K: 
					Cell R0190cell10 = row.createCell(10);
					if (record.getR0190_2_3months() != null) {
						R0190cell10.setCellValue(record.getR0190_2_3months().doubleValue());
						R0190cell10.setCellStyle(numberStyle);
					} else {
						R0190cell10.setCellValue("");
						R0190cell10.setCellStyle(textStyle);
					}

//ROW28
//Column L: 
					Cell R0190cell11 = row.createCell(11);
					if (record.getR0190_3_6months() != null) {
						R0190cell11.setCellValue(record.getR0190_3_6months().doubleValue());
						R0190cell11.setCellStyle(numberStyle);
					} else {
						R0190cell11.setCellValue("");
						R0190cell11.setCellStyle(textStyle);
					}

//ROW28
//Column M: 
					Cell R0190cell12 = row.createCell(12);
					if (record.getR0190_6_12months() != null) {
						R0190cell12.setCellValue(record.getR0190_6_12months().doubleValue());
						R0190cell12.setCellStyle(numberStyle);
					} else {
						R0190cell12.setCellValue("");
						R0190cell12.setCellStyle(textStyle);
					}

//ROW28
//Column N: 
					Cell R0190cell13 = row.createCell(13);
					if (record.getR0190_1_3years() != null) {
						R0190cell13.setCellValue(record.getR0190_1_3years().doubleValue());
						R0190cell13.setCellStyle(numberStyle);
					} else {
						R0190cell13.setCellValue("");
						R0190cell13.setCellStyle(textStyle);
					}

//ROW28
//Column O: 
					Cell R0190cell14 = row.createCell(14);
					if (record.getR0190_3_5years() != null) {
						R0190cell14.setCellValue(record.getR0190_3_5years().doubleValue());
						R0190cell14.setCellStyle(numberStyle);
					} else {
						R0190cell14.setCellValue("");
						R0190cell14.setCellStyle(textStyle);
					}

//ROW28
//Column P: 
					Cell R0190cell15 = row.createCell(15);
					if (record.getR0190_5years() != null) {
						R0190cell15.setCellValue(record.getR0190_5years().doubleValue());
						R0190cell15.setCellStyle(numberStyle);
					} else {
						R0190cell15.setCellValue("");
						R0190cell15.setCellStyle(textStyle);
					}

/////ROW29///////////
//ROW29

					row = sheet.getRow(28);

//Column E: 
					Cell R0200cell4 = row.createCell(4);
					if (record.getR0200_overdue() != null) {
						R0200cell4.setCellValue(record.getR0200_overdue().doubleValue());
						R0200cell4.setCellStyle(numberStyle);
					} else {
						R0200cell4.setCellValue("");
						R0200cell4.setCellStyle(textStyle);
					}

//ROW29
//Column F: 
					Cell R0200cell5 = row.createCell(5);
					if (record.getR0200_overdraft() != null) {
						R0200cell5.setCellValue(record.getR0200_overdraft().doubleValue());
						R0200cell5.setCellStyle(numberStyle);
					} else {
						R0200cell5.setCellValue("");
						R0200cell5.setCellStyle(textStyle);
					}

//ROW29
//Column G: 
					Cell R0200cell6 = row.createCell(6);
					if (record.getR0200_0_7days() != null) {
						R0200cell6.setCellValue(record.getR0200_0_7days().doubleValue());
						R0200cell6.setCellStyle(numberStyle);
					} else {
						R0200cell6.setCellValue("");
						R0200cell6.setCellStyle(textStyle);
					}

//ROW29
//Column H: 
					Cell R0200cell7 = row.createCell(7);
					if (record.getR0200_8_14days() != null) {
						R0200cell7.setCellValue(record.getR0200_8_14days().doubleValue());
						R0200cell7.setCellStyle(numberStyle);
					} else {
						R0200cell7.setCellValue("");
						R0200cell7.setCellStyle(textStyle);
					}

//ROW29
//Column I: 
					Cell R0200cell8 = row.createCell(8);
					if (record.getR0200_15days_1months() != null) {
						R0200cell8.setCellValue(record.getR0200_15days_1months().doubleValue());
						R0200cell8.setCellStyle(numberStyle);
					} else {
						R0200cell8.setCellValue("");
						R0200cell8.setCellStyle(textStyle);
					}

//ROW29
//Column J: 
					Cell R0200cell9 = row.createCell(9);
					if (record.getR0200_1_2months() != null) {
						R0200cell9.setCellValue(record.getR0200_1_2months().doubleValue());
						R0200cell9.setCellStyle(numberStyle);
					} else {
						R0200cell9.setCellValue("");
						R0200cell9.setCellStyle(textStyle);
					}

//ROW29
//Column K: 
					Cell R0200cell10 = row.createCell(10);
					if (record.getR0200_2_3months() != null) {
						R0200cell10.setCellValue(record.getR0200_2_3months().doubleValue());
						R0200cell10.setCellStyle(numberStyle);
					} else {
						R0200cell10.setCellValue("");
						R0200cell10.setCellStyle(textStyle);
					}

//ROW29
//Column L: 
					Cell R0200cell11 = row.createCell(11);
					if (record.getR0200_3_6months() != null) {
						R0200cell11.setCellValue(record.getR0200_3_6months().doubleValue());
						R0200cell11.setCellStyle(numberStyle);
					} else {
						R0200cell11.setCellValue("");
						R0200cell11.setCellStyle(textStyle);
					}

//ROW29
//Column M: 
					Cell R0200cell12 = row.createCell(12);
					if (record.getR0200_6_12months() != null) {
						R0200cell12.setCellValue(record.getR0200_6_12months().doubleValue());
						R0200cell12.setCellStyle(numberStyle);
					} else {
						R0200cell12.setCellValue("");
						R0200cell12.setCellStyle(textStyle);
					}

//ROW29
//Column N: 
					Cell R0200cell13 = row.createCell(13);
					if (record.getR0200_1_3years() != null) {
						R0200cell13.setCellValue(record.getR0200_1_3years().doubleValue());
						R0200cell13.setCellStyle(numberStyle);
					} else {
						R0200cell13.setCellValue("");
						R0200cell13.setCellStyle(textStyle);
					}

//ROW29
//Column O: 
					Cell R0200cell14 = row.createCell(14);
					if (record.getR0200_3_5years() != null) {
						R0200cell14.setCellValue(record.getR0200_3_5years().doubleValue());
						R0200cell14.setCellStyle(numberStyle);
					} else {
						R0200cell14.setCellValue("");
						R0200cell14.setCellStyle(textStyle);
					}

//ROW29
//Column P: 
					Cell R0200cell15 = row.createCell(15);
					if (record.getR0200_5years() != null) {
						R0200cell15.setCellValue(record.getR0200_5years().doubleValue());
						R0200cell15.setCellStyle(numberStyle);
					} else {
						R0200cell15.setCellValue("");
						R0200cell15.setCellStyle(textStyle);
					}

/////ROW31///////////
//ROW31

					row = sheet.getRow(30);

//Column E: 
					Cell R0220cell4 = row.createCell(4);
					if (record.getR0220_overdue() != null) {
						R0220cell4.setCellValue(record.getR0220_overdue().doubleValue());
						R0220cell4.setCellStyle(numberStyle);
					} else {
						R0220cell4.setCellValue("");
						R0220cell4.setCellStyle(textStyle);
					}

//ROW31
//Column F: 
					Cell R0220cell5 = row.createCell(5);
					if (record.getR0220_overdraft() != null) {
						R0220cell5.setCellValue(record.getR0220_overdraft().doubleValue());
						R0220cell5.setCellStyle(numberStyle);
					} else {
						R0220cell5.setCellValue("");
						R0220cell5.setCellStyle(textStyle);
					}

//ROW31
//Column G: 
					Cell R0220cell6 = row.createCell(6);
					if (record.getR0220_0_7days() != null) {
						R0220cell6.setCellValue(record.getR0220_0_7days().doubleValue());
						R0220cell6.setCellStyle(numberStyle);
					} else {
						R0220cell6.setCellValue("");
						R0220cell6.setCellStyle(textStyle);
					}

//ROW31
//Column H: 
					Cell R0220cell7 = row.createCell(7);
					if (record.getR0220_8_14days() != null) {
						R0220cell7.setCellValue(record.getR0220_8_14days().doubleValue());
						R0220cell7.setCellStyle(numberStyle);
					} else {
						R0220cell7.setCellValue("");
						R0220cell7.setCellStyle(textStyle);
					}

//ROW31
//Column I: 
					Cell R0220cell8 = row.createCell(8);
					if (record.getR0220_15days_1months() != null) {
						R0220cell8.setCellValue(record.getR0220_15days_1months().doubleValue());
						R0220cell8.setCellStyle(numberStyle);
					} else {
						R0220cell8.setCellValue("");
						R0220cell8.setCellStyle(textStyle);
					}

//ROW31
//Column J: 
					Cell R0220cell9 = row.createCell(9);
					if (record.getR0220_1_2months() != null) {
						R0220cell9.setCellValue(record.getR0220_1_2months().doubleValue());
						R0220cell9.setCellStyle(numberStyle);
					} else {
						R0220cell9.setCellValue("");
						R0220cell9.setCellStyle(textStyle);
					}

//ROW31
//Column K: 
					Cell R0220cell10 = row.createCell(10);
					if (record.getR0220_2_3months() != null) {
						R0220cell10.setCellValue(record.getR0220_2_3months().doubleValue());
						R0220cell10.setCellStyle(numberStyle);
					} else {
						R0220cell10.setCellValue("");
						R0220cell10.setCellStyle(textStyle);
					}

//ROW31
//Column L: 
					Cell R0220cell11 = row.createCell(11);
					if (record.getR0220_3_6months() != null) {
						R0220cell11.setCellValue(record.getR0220_3_6months().doubleValue());
						R0220cell11.setCellStyle(numberStyle);
					} else {
						R0220cell11.setCellValue("");
						R0220cell11.setCellStyle(textStyle);
					}

//ROW31
//Column M: 
					Cell R0220cell12 = row.createCell(12);
					if (record.getR0220_6_12months() != null) {
						R0220cell12.setCellValue(record.getR0220_6_12months().doubleValue());
						R0220cell12.setCellStyle(numberStyle);
					} else {
						R0220cell12.setCellValue("");
						R0220cell12.setCellStyle(textStyle);
					}

//ROW31
//Column N: 
					Cell R0220cell13 = row.createCell(13);
					if (record.getR0220_1_3years() != null) {
						R0220cell13.setCellValue(record.getR0220_1_3years().doubleValue());
						R0220cell13.setCellStyle(numberStyle);
					} else {
						R0220cell13.setCellValue("");
						R0220cell13.setCellStyle(textStyle);
					}

//ROW31
//Column O: 
					Cell R0220cell14 = row.createCell(14);
					if (record.getR0220_3_5years() != null) {
						R0220cell14.setCellValue(record.getR0220_3_5years().doubleValue());
						R0220cell14.setCellStyle(numberStyle);
					} else {
						R0220cell14.setCellValue("");
						R0220cell14.setCellStyle(textStyle);
					}

//ROW31
//Column P: 
					Cell R0220cell15 = row.createCell(15);
					if (record.getR0220_5years() != null) {
						R0220cell15.setCellValue(record.getR0220_5years().doubleValue());
						R0220cell15.setCellStyle(numberStyle);
					} else {
						R0220cell15.setCellValue("");
						R0220cell15.setCellStyle(textStyle);
					}

/////ROW32///////////
//ROW32

					row = sheet.getRow(31);

//Column E: 
					Cell R0230cell4 = row.createCell(4);
					if (record.getR0230_overdue() != null) {
						R0230cell4.setCellValue(record.getR0230_overdue().doubleValue());
						R0230cell4.setCellStyle(numberStyle);
					} else {
						R0230cell4.setCellValue("");
						R0230cell4.setCellStyle(textStyle);
					}

//ROW32
//Column F: 
					Cell R0230cell5 = row.createCell(5);
					if (record.getR0230_overdraft() != null) {
						R0230cell5.setCellValue(record.getR0230_overdraft().doubleValue());
						R0230cell5.setCellStyle(numberStyle);
					} else {
						R0230cell5.setCellValue("");
						R0230cell5.setCellStyle(textStyle);
					}

//ROW32
//Column G: 
					Cell R0230cell6 = row.createCell(6);
					if (record.getR0230_0_7days() != null) {
						R0230cell6.setCellValue(record.getR0230_0_7days().doubleValue());
						R0230cell6.setCellStyle(numberStyle);
					} else {
						R0230cell6.setCellValue("");
						R0230cell6.setCellStyle(textStyle);
					}

//ROW32
//Column H: 
					Cell R0230cell7 = row.createCell(7);
					if (record.getR0230_8_14days() != null) {
						R0230cell7.setCellValue(record.getR0230_8_14days().doubleValue());
						R0230cell7.setCellStyle(numberStyle);
					} else {
						R0230cell7.setCellValue("");
						R0230cell7.setCellStyle(textStyle);
					}

//ROW32
//Column I: 
					Cell R0230cell8 = row.createCell(8);
					if (record.getR0230_15days_1months() != null) {
						R0230cell8.setCellValue(record.getR0230_15days_1months().doubleValue());
						R0230cell8.setCellStyle(numberStyle);
					} else {
						R0230cell8.setCellValue("");
						R0230cell8.setCellStyle(textStyle);
					}

//ROW32
//Column J: 
					Cell R0230cell9 = row.createCell(9);
					if (record.getR0230_1_2months() != null) {
						R0230cell9.setCellValue(record.getR0230_1_2months().doubleValue());
						R0230cell9.setCellStyle(numberStyle);
					} else {
						R0230cell9.setCellValue("");
						R0230cell9.setCellStyle(textStyle);
					}

//ROW32
//Column K: 
					Cell R0230cell10 = row.createCell(10);
					if (record.getR0230_2_3months() != null) {
						R0230cell10.setCellValue(record.getR0230_2_3months().doubleValue());
						R0230cell10.setCellStyle(numberStyle);
					} else {
						R0230cell10.setCellValue("");
						R0230cell10.setCellStyle(textStyle);
					}

//ROW32
//Column L: 
					Cell R0230cell11 = row.createCell(11);
					if (record.getR0230_3_6months() != null) {
						R0230cell11.setCellValue(record.getR0230_3_6months().doubleValue());
						R0230cell11.setCellStyle(numberStyle);
					} else {
						R0230cell11.setCellValue("");
						R0230cell11.setCellStyle(textStyle);
					}

//ROW32
//Column M: 
					Cell R0230cell12 = row.createCell(12);
					if (record.getR0230_6_12months() != null) {
						R0230cell12.setCellValue(record.getR0230_6_12months().doubleValue());
						R0230cell12.setCellStyle(numberStyle);
					} else {
						R0230cell12.setCellValue("");
						R0230cell12.setCellStyle(textStyle);
					}

//ROW32
//Column N: 
					Cell R0230cell13 = row.createCell(13);
					if (record.getR0230_1_3years() != null) {
						R0230cell13.setCellValue(record.getR0230_1_3years().doubleValue());
						R0230cell13.setCellStyle(numberStyle);
					} else {
						R0230cell13.setCellValue("");
						R0230cell13.setCellStyle(textStyle);
					}

//ROW32
//Column O: 
					Cell R0230cell14 = row.createCell(14);
					if (record.getR0230_3_5years() != null) {
						R0230cell14.setCellValue(record.getR0230_3_5years().doubleValue());
						R0230cell14.setCellStyle(numberStyle);
					} else {
						R0230cell14.setCellValue("");
						R0230cell14.setCellStyle(textStyle);
					}

//ROW32
//Column P: 
					Cell R0230cell15 = row.createCell(15);
					if (record.getR0230_5years() != null) {
						R0230cell15.setCellValue(record.getR0230_5years().doubleValue());
						R0230cell15.setCellStyle(numberStyle);
					} else {
						R0230cell15.setCellValue("");
						R0230cell15.setCellStyle(textStyle);
					}

/////ROW33///////////
//ROW33

					row = sheet.getRow(32);

//Column E: 
					Cell R0240cell4 = row.createCell(4);
					if (record.getR0240_overdue() != null) {
						R0240cell4.setCellValue(record.getR0240_overdue().doubleValue());
						R0240cell4.setCellStyle(numberStyle);
					} else {
						R0240cell4.setCellValue("");
						R0240cell4.setCellStyle(textStyle);
					}

//ROW33
//Column F: 
					Cell R0240cell5 = row.createCell(5);
					if (record.getR0240_overdraft() != null) {
						R0240cell5.setCellValue(record.getR0240_overdraft().doubleValue());
						R0240cell5.setCellStyle(numberStyle);
					} else {
						R0240cell5.setCellValue("");
						R0240cell5.setCellStyle(textStyle);
					}

//ROW33
//Column G: 
					Cell R0240cell6 = row.createCell(6);
					if (record.getR0240_0_7days() != null) {
						R0240cell6.setCellValue(record.getR0240_0_7days().doubleValue());
						R0240cell6.setCellStyle(numberStyle);
					} else {
						R0240cell6.setCellValue("");
						R0240cell6.setCellStyle(textStyle);
					}

//ROW33
//Column H: 
					Cell R0240cell7 = row.createCell(7);
					if (record.getR0240_8_14days() != null) {
						R0240cell7.setCellValue(record.getR0240_8_14days().doubleValue());
						R0240cell7.setCellStyle(numberStyle);
					} else {
						R0240cell7.setCellValue("");
						R0240cell7.setCellStyle(textStyle);
					}

//ROW33
//Column I: 
					Cell R0240cell8 = row.createCell(8);
					if (record.getR0240_15days_1months() != null) {
						R0240cell8.setCellValue(record.getR0240_15days_1months().doubleValue());
						R0240cell8.setCellStyle(numberStyle);
					} else {
						R0240cell8.setCellValue("");
						R0240cell8.setCellStyle(textStyle);
					}

//ROW33
//Column J: 
					Cell R0240cell9 = row.createCell(9);
					if (record.getR0240_1_2months() != null) {
						R0240cell9.setCellValue(record.getR0240_1_2months().doubleValue());
						R0240cell9.setCellStyle(numberStyle);
					} else {
						R0240cell9.setCellValue("");
						R0240cell9.setCellStyle(textStyle);
					}

//ROW33
//Column K: 
					Cell R0240cell10 = row.createCell(10);
					if (record.getR0240_2_3months() != null) {
						R0240cell10.setCellValue(record.getR0240_2_3months().doubleValue());
						R0240cell10.setCellStyle(numberStyle);
					} else {
						R0240cell10.setCellValue("");
						R0240cell10.setCellStyle(textStyle);
					}

//ROW33
//Column L: 
					Cell R0240cell11 = row.createCell(11);
					if (record.getR0240_3_6months() != null) {
						R0240cell11.setCellValue(record.getR0240_3_6months().doubleValue());
						R0240cell11.setCellStyle(numberStyle);
					} else {
						R0240cell11.setCellValue("");
						R0240cell11.setCellStyle(textStyle);
					}

//ROW33
//Column M: 
					Cell R0240cell12 = row.createCell(12);
					if (record.getR0240_6_12months() != null) {
						R0240cell12.setCellValue(record.getR0240_6_12months().doubleValue());
						R0240cell12.setCellStyle(numberStyle);
					} else {
						R0240cell12.setCellValue("");
						R0240cell12.setCellStyle(textStyle);
					}

//ROW33
//Column N: 
					Cell R0240cell13 = row.createCell(13);
					if (record.getR0240_1_3years() != null) {
						R0240cell13.setCellValue(record.getR0240_1_3years().doubleValue());
						R0240cell13.setCellStyle(numberStyle);
					} else {
						R0240cell13.setCellValue("");
						R0240cell13.setCellStyle(textStyle);
					}

//ROW33
//Column O: 
					Cell R0240cell14 = row.createCell(14);
					if (record.getR0240_3_5years() != null) {
						R0240cell14.setCellValue(record.getR0240_3_5years().doubleValue());
						R0240cell14.setCellStyle(numberStyle);
					} else {
						R0240cell14.setCellValue("");
						R0240cell14.setCellStyle(textStyle);
					}

//ROW33
//Column P: 
					Cell R0240cell15 = row.createCell(15);
					if (record.getR0240_5years() != null) {
						R0240cell15.setCellValue(record.getR0240_5years().doubleValue());
						R0240cell15.setCellStyle(numberStyle);
					} else {
						R0240cell15.setCellValue("");
						R0240cell15.setCellStyle(textStyle);
					}

/////ROW34///////////
//ROW34

					row = sheet.getRow(33);

//Column E: 
					Cell R0250cell4 = row.createCell(4);
					if (record.getR0250_overdue() != null) {
						R0250cell4.setCellValue(record.getR0250_overdue().doubleValue());
						R0250cell4.setCellStyle(numberStyle);
					} else {
						R0250cell4.setCellValue("");
						R0250cell4.setCellStyle(textStyle);
					}

//ROW34
//Column F: 
					Cell R0250cell5 = row.createCell(5);
					if (record.getR0250_overdraft() != null) {
						R0250cell5.setCellValue(record.getR0250_overdraft().doubleValue());
						R0250cell5.setCellStyle(numberStyle);
					} else {
						R0250cell5.setCellValue("");
						R0250cell5.setCellStyle(textStyle);
					}

//ROW34
//Column G: 
					Cell R0250cell6 = row.createCell(6);
					if (record.getR0250_0_7days() != null) {
						R0250cell6.setCellValue(record.getR0250_0_7days().doubleValue());
						R0250cell6.setCellStyle(numberStyle);
					} else {
						R0250cell6.setCellValue("");
						R0250cell6.setCellStyle(textStyle);
					}

//ROW34
//Column H: 
					Cell R0250cell7 = row.createCell(7);
					if (record.getR0250_8_14days() != null) {
						R0250cell7.setCellValue(record.getR0250_8_14days().doubleValue());
						R0250cell7.setCellStyle(numberStyle);
					} else {
						R0250cell7.setCellValue("");
						R0250cell7.setCellStyle(textStyle);
					}

//ROW34
//Column I: 
					Cell R0250cell8 = row.createCell(8);
					if (record.getR0250_15days_1months() != null) {
						R0250cell8.setCellValue(record.getR0250_15days_1months().doubleValue());
						R0250cell8.setCellStyle(numberStyle);
					} else {
						R0250cell8.setCellValue("");
						R0250cell8.setCellStyle(textStyle);
					}

//ROW34
//Column J: 
					Cell R0250cell9 = row.createCell(9);
					if (record.getR0250_1_2months() != null) {
						R0250cell9.setCellValue(record.getR0250_1_2months().doubleValue());
						R0250cell9.setCellStyle(numberStyle);
					} else {
						R0250cell9.setCellValue("");
						R0250cell9.setCellStyle(textStyle);
					}

//ROW34
//Column K: 
					Cell R0250cell10 = row.createCell(10);
					if (record.getR0250_2_3months() != null) {
						R0250cell10.setCellValue(record.getR0250_2_3months().doubleValue());
						R0250cell10.setCellStyle(numberStyle);
					} else {
						R0250cell10.setCellValue("");
						R0250cell10.setCellStyle(textStyle);
					}

//ROW34
//Column L: 
					Cell R0250cell11 = row.createCell(11);
					if (record.getR0250_3_6months() != null) {
						R0250cell11.setCellValue(record.getR0250_3_6months().doubleValue());
						R0250cell11.setCellStyle(numberStyle);
					} else {
						R0250cell11.setCellValue("");
						R0250cell11.setCellStyle(textStyle);
					}

//ROW34
//Column M: 
					Cell R0250cell12 = row.createCell(12);
					if (record.getR0250_6_12months() != null) {
						R0250cell12.setCellValue(record.getR0250_6_12months().doubleValue());
						R0250cell12.setCellStyle(numberStyle);
					} else {
						R0250cell12.setCellValue("");
						R0250cell12.setCellStyle(textStyle);
					}

//ROW34
//Column N: 
					Cell R0250cell13 = row.createCell(13);
					if (record.getR0250_1_3years() != null) {
						R0250cell13.setCellValue(record.getR0250_1_3years().doubleValue());
						R0250cell13.setCellStyle(numberStyle);
					} else {
						R0250cell13.setCellValue("");
						R0250cell13.setCellStyle(textStyle);
					}

//ROW34
//Column O: 
					Cell R0250cell14 = row.createCell(14);
					if (record.getR0250_3_5years() != null) {
						R0250cell14.setCellValue(record.getR0250_3_5years().doubleValue());
						R0250cell14.setCellStyle(numberStyle);
					} else {
						R0250cell14.setCellValue("");
						R0250cell14.setCellStyle(textStyle);
					}

//ROW34
//Column P: 
					Cell R0250cell15 = row.createCell(15);
					if (record.getR0250_5years() != null) {
						R0250cell15.setCellValue(record.getR0250_5years().doubleValue());
						R0250cell15.setCellStyle(numberStyle);
					} else {
						R0250cell15.setCellValue("");
						R0250cell15.setCellStyle(textStyle);
					}

/////ROW35///////////
//ROW35

					row = sheet.getRow(34);

//Column E: 
					Cell R0260cell4 = row.createCell(4);
					if (record.getR0260_overdue() != null) {
						R0260cell4.setCellValue(record.getR0260_overdue().doubleValue());
						R0260cell4.setCellStyle(numberStyle);
					} else {
						R0260cell4.setCellValue("");
						R0260cell4.setCellStyle(textStyle);
					}

//ROW35
//Column F: 
					Cell R0260cell5 = row.createCell(5);
					if (record.getR0260_overdraft() != null) {
						R0260cell5.setCellValue(record.getR0260_overdraft().doubleValue());
						R0260cell5.setCellStyle(numberStyle);
					} else {
						R0260cell5.setCellValue("");
						R0260cell5.setCellStyle(textStyle);
					}

//ROW35
//Column G: 
					Cell R0260cell6 = row.createCell(6);
					if (record.getR0260_0_7days() != null) {
						R0260cell6.setCellValue(record.getR0260_0_7days().doubleValue());
						R0260cell6.setCellStyle(numberStyle);
					} else {
						R0260cell6.setCellValue("");
						R0260cell6.setCellStyle(textStyle);
					}

//ROW35
//Column H: 
					Cell R0260cell7 = row.createCell(7);
					if (record.getR0260_8_14days() != null) {
						R0260cell7.setCellValue(record.getR0260_8_14days().doubleValue());
						R0260cell7.setCellStyle(numberStyle);
					} else {
						R0260cell7.setCellValue("");
						R0260cell7.setCellStyle(textStyle);
					}

//ROW35
//Column I: 
					Cell R0260cell8 = row.createCell(8);
					if (record.getR0260_15days_1months() != null) {
						R0260cell8.setCellValue(record.getR0260_15days_1months().doubleValue());
						R0260cell8.setCellStyle(numberStyle);
					} else {
						R0260cell8.setCellValue("");
						R0260cell8.setCellStyle(textStyle);
					}

//ROW35
//Column J: 
					Cell R0260cell9 = row.createCell(9);
					if (record.getR0260_1_2months() != null) {
						R0260cell9.setCellValue(record.getR0260_1_2months().doubleValue());
						R0260cell9.setCellStyle(numberStyle);
					} else {
						R0260cell9.setCellValue("");
						R0260cell9.setCellStyle(textStyle);
					}

//ROW35
//Column K: 
					Cell R0260cell10 = row.createCell(10);
					if (record.getR0260_2_3months() != null) {
						R0260cell10.setCellValue(record.getR0260_2_3months().doubleValue());
						R0260cell10.setCellStyle(numberStyle);
					} else {
						R0260cell10.setCellValue("");
						R0260cell10.setCellStyle(textStyle);
					}

//ROW35
//Column L: 
					Cell R0260cell11 = row.createCell(11);
					if (record.getR0260_3_6months() != null) {
						R0260cell11.setCellValue(record.getR0260_3_6months().doubleValue());
						R0260cell11.setCellStyle(numberStyle);
					} else {
						R0260cell11.setCellValue("");
						R0260cell11.setCellStyle(textStyle);
					}

//ROW35
//Column M: 
					Cell R0260cell12 = row.createCell(12);
					if (record.getR0260_6_12months() != null) {
						R0260cell12.setCellValue(record.getR0260_6_12months().doubleValue());
						R0260cell12.setCellStyle(numberStyle);
					} else {
						R0260cell12.setCellValue("");
						R0260cell12.setCellStyle(textStyle);
					}

//ROW35
//Column N: 
					Cell R0260cell13 = row.createCell(13);
					if (record.getR0260_1_3years() != null) {
						R0260cell13.setCellValue(record.getR0260_1_3years().doubleValue());
						R0260cell13.setCellStyle(numberStyle);
					} else {
						R0260cell13.setCellValue("");
						R0260cell13.setCellStyle(textStyle);
					}

//ROW35
//Column O: 
					Cell R0260cell14 = row.createCell(14);
					if (record.getR0260_3_5years() != null) {
						R0260cell14.setCellValue(record.getR0260_3_5years().doubleValue());
						R0260cell14.setCellStyle(numberStyle);
					} else {
						R0260cell14.setCellValue("");
						R0260cell14.setCellStyle(textStyle);
					}

//ROW35
//Column P: 
					Cell R0260cell15 = row.createCell(15);
					if (record.getR0260_5years() != null) {
						R0260cell15.setCellValue(record.getR0260_5years().doubleValue());
						R0260cell15.setCellStyle(numberStyle);
					} else {
						R0260cell15.setCellValue("");
						R0260cell15.setCellStyle(textStyle);
					}

/////ROW36///////////
//ROW36

					row = sheet.getRow(35);

//Column E: 
					Cell R0270cell4 = row.createCell(4);
					if (record.getR0270_overdue() != null) {
						R0270cell4.setCellValue(record.getR0270_overdue().doubleValue());
						R0270cell4.setCellStyle(numberStyle);
					} else {
						R0270cell4.setCellValue("");
						R0270cell4.setCellStyle(textStyle);
					}

//ROW36
//Column F: 
					Cell R0270cell5 = row.createCell(5);
					if (record.getR0270_overdraft() != null) {
						R0270cell5.setCellValue(record.getR0270_overdraft().doubleValue());
						R0270cell5.setCellStyle(numberStyle);
					} else {
						R0270cell5.setCellValue("");
						R0270cell5.setCellStyle(textStyle);
					}

//ROW36
//Column G: 
					Cell R0270cell6 = row.createCell(6);
					if (record.getR0270_0_7days() != null) {
						R0270cell6.setCellValue(record.getR0270_0_7days().doubleValue());
						R0270cell6.setCellStyle(numberStyle);
					} else {
						R0270cell6.setCellValue("");
						R0270cell6.setCellStyle(textStyle);
					}

//ROW36
//Column H: 
					Cell R0270cell7 = row.createCell(7);
					if (record.getR0270_8_14days() != null) {
						R0270cell7.setCellValue(record.getR0270_8_14days().doubleValue());
						R0270cell7.setCellStyle(numberStyle);
					} else {
						R0270cell7.setCellValue("");
						R0270cell7.setCellStyle(textStyle);
					}

//ROW36
//Column I: 
					Cell R0270cell8 = row.createCell(8);
					if (record.getR0270_15days_1months() != null) {
						R0270cell8.setCellValue(record.getR0270_15days_1months().doubleValue());
						R0270cell8.setCellStyle(numberStyle);
					} else {
						R0270cell8.setCellValue("");
						R0270cell8.setCellStyle(textStyle);
					}

//ROW36
//Column J: 
					Cell R0270cell9 = row.createCell(9);
					if (record.getR0270_1_2months() != null) {
						R0270cell9.setCellValue(record.getR0270_1_2months().doubleValue());
						R0270cell9.setCellStyle(numberStyle);
					} else {
						R0270cell9.setCellValue("");
						R0270cell9.setCellStyle(textStyle);
					}

//ROW36
//Column K: 
					Cell R0270cell10 = row.createCell(10);
					if (record.getR0270_2_3months() != null) {
						R0270cell10.setCellValue(record.getR0270_2_3months().doubleValue());
						R0270cell10.setCellStyle(numberStyle);
					} else {
						R0270cell10.setCellValue("");
						R0270cell10.setCellStyle(textStyle);
					}

//ROW36
//Column L: 
					Cell R0270cell11 = row.createCell(11);
					if (record.getR0270_3_6months() != null) {
						R0270cell11.setCellValue(record.getR0270_3_6months().doubleValue());
						R0270cell11.setCellStyle(numberStyle);
					} else {
						R0270cell11.setCellValue("");
						R0270cell11.setCellStyle(textStyle);
					}

//ROW36
//Column M: 
					Cell R0270cell12 = row.createCell(12);
					if (record.getR0270_6_12months() != null) {
						R0270cell12.setCellValue(record.getR0270_6_12months().doubleValue());
						R0270cell12.setCellStyle(numberStyle);
					} else {
						R0270cell12.setCellValue("");
						R0270cell12.setCellStyle(textStyle);
					}

//ROW36
//Column N: 
					Cell R0270cell13 = row.createCell(13);
					if (record.getR0270_1_3years() != null) {
						R0270cell13.setCellValue(record.getR0270_1_3years().doubleValue());
						R0270cell13.setCellStyle(numberStyle);
					} else {
						R0270cell13.setCellValue("");
						R0270cell13.setCellStyle(textStyle);
					}

//ROW36
//Column O: 
					Cell R0270cell14 = row.createCell(14);
					if (record.getR0270_3_5years() != null) {
						R0270cell14.setCellValue(record.getR0270_3_5years().doubleValue());
						R0270cell14.setCellStyle(numberStyle);
					} else {
						R0270cell14.setCellValue("");
						R0270cell14.setCellStyle(textStyle);
					}

//ROW36
//Column P: 
					Cell R0270cell15 = row.createCell(15);
					if (record.getR0270_5years() != null) {
						R0270cell15.setCellValue(record.getR0270_5years().doubleValue());
						R0270cell15.setCellStyle(numberStyle);
					} else {
						R0270cell15.setCellValue("");
						R0270cell15.setCellStyle(textStyle);
					}

/////ROW38///////////
//ROW38

					row = sheet.getRow(37);

//Column E: 
					Cell R0290cell4 = row.createCell(4);
					if (record.getR0290_overdue() != null) {
						R0290cell4.setCellValue(record.getR0290_overdue().doubleValue());
						R0290cell4.setCellStyle(numberStyle);
					} else {
						R0290cell4.setCellValue("");
						R0290cell4.setCellStyle(textStyle);
					}

//ROW38
//Column F: 
					Cell R0290cell5 = row.createCell(5);
					if (record.getR0290_overdraft() != null) {
						R0290cell5.setCellValue(record.getR0290_overdraft().doubleValue());
						R0290cell5.setCellStyle(numberStyle);
					} else {
						R0290cell5.setCellValue("");
						R0290cell5.setCellStyle(textStyle);
					}

//ROW38
//Column G: 
					Cell R0290cell6 = row.createCell(6);
					if (record.getR0290_0_7days() != null) {
						R0290cell6.setCellValue(record.getR0290_0_7days().doubleValue());
						R0290cell6.setCellStyle(numberStyle);
					} else {
						R0290cell6.setCellValue("");
						R0290cell6.setCellStyle(textStyle);
					}

//ROW38
//Column H: 
					Cell R0290cell7 = row.createCell(7);
					if (record.getR0290_8_14days() != null) {
						R0290cell7.setCellValue(record.getR0290_8_14days().doubleValue());
						R0290cell7.setCellStyle(numberStyle);
					} else {
						R0290cell7.setCellValue("");
						R0290cell7.setCellStyle(textStyle);
					}

//ROW38
//Column I: 
					Cell R0290cell8 = row.createCell(8);
					if (record.getR0290_15days_1months() != null) {
						R0290cell8.setCellValue(record.getR0290_15days_1months().doubleValue());
						R0290cell8.setCellStyle(numberStyle);
					} else {
						R0290cell8.setCellValue("");
						R0290cell8.setCellStyle(textStyle);
					}

//ROW38
//Column J: 
					Cell R0290cell9 = row.createCell(9);
					if (record.getR0290_1_2months() != null) {
						R0290cell9.setCellValue(record.getR0290_1_2months().doubleValue());
						R0290cell9.setCellStyle(numberStyle);
					} else {
						R0290cell9.setCellValue("");
						R0290cell9.setCellStyle(textStyle);
					}

//ROW38
//Column K: 
					Cell R0290cell10 = row.createCell(10);
					if (record.getR0290_2_3months() != null) {
						R0290cell10.setCellValue(record.getR0290_2_3months().doubleValue());
						R0290cell10.setCellStyle(numberStyle);
					} else {
						R0290cell10.setCellValue("");
						R0290cell10.setCellStyle(textStyle);
					}

//ROW38
//Column L: 
					Cell R0290cell11 = row.createCell(11);
					if (record.getR0290_3_6months() != null) {
						R0290cell11.setCellValue(record.getR0290_3_6months().doubleValue());
						R0290cell11.setCellStyle(numberStyle);
					} else {
						R0290cell11.setCellValue("");
						R0290cell11.setCellStyle(textStyle);
					}

//ROW38
//Column M: 
					Cell R0290cell12 = row.createCell(12);
					if (record.getR0290_6_12months() != null) {
						R0290cell12.setCellValue(record.getR0290_6_12months().doubleValue());
						R0290cell12.setCellStyle(numberStyle);
					} else {
						R0290cell12.setCellValue("");
						R0290cell12.setCellStyle(textStyle);
					}

//ROW38
//Column N: 
					Cell R0290cell13 = row.createCell(13);
					if (record.getR0290_1_3years() != null) {
						R0290cell13.setCellValue(record.getR0290_1_3years().doubleValue());
						R0290cell13.setCellStyle(numberStyle);
					} else {
						R0290cell13.setCellValue("");
						R0290cell13.setCellStyle(textStyle);
					}

//ROW38
//Column O: 
					Cell R0290cell14 = row.createCell(14);
					if (record.getR0290_3_5years() != null) {
						R0290cell14.setCellValue(record.getR0290_3_5years().doubleValue());
						R0290cell14.setCellStyle(numberStyle);
					} else {
						R0290cell14.setCellValue("");
						R0290cell14.setCellStyle(textStyle);
					}

//ROW38
//Column P: 
					Cell R0290cell15 = row.createCell(15);
					if (record.getR0290_5years() != null) {
						R0290cell15.setCellValue(record.getR0290_5years().doubleValue());
						R0290cell15.setCellStyle(numberStyle);
					} else {
						R0290cell15.setCellValue("");
						R0290cell15.setCellStyle(textStyle);
					}

/////ROW39///////////
//ROW39

					row = sheet.getRow(38);

//Column E: 
					Cell R0300cell4 = row.createCell(4);
					if (record.getR0300_overdue() != null) {
						R0300cell4.setCellValue(record.getR0300_overdue().doubleValue());
						R0300cell4.setCellStyle(numberStyle);
					} else {
						R0300cell4.setCellValue("");
						R0300cell4.setCellStyle(textStyle);
					}

//ROW39
//Column F: 
					Cell R0300cell5 = row.createCell(5);
					if (record.getR0300_overdraft() != null) {
						R0300cell5.setCellValue(record.getR0300_overdraft().doubleValue());
						R0300cell5.setCellStyle(numberStyle);
					} else {
						R0300cell5.setCellValue("");
						R0300cell5.setCellStyle(textStyle);
					}

//ROW39
//Column G: 
					Cell R0300cell6 = row.createCell(6);
					if (record.getR0300_0_7days() != null) {
						R0300cell6.setCellValue(record.getR0300_0_7days().doubleValue());
						R0300cell6.setCellStyle(numberStyle);
					} else {
						R0300cell6.setCellValue("");
						R0300cell6.setCellStyle(textStyle);
					}

//ROW39
//Column H: 
					Cell R0300cell7 = row.createCell(7);
					if (record.getR0300_8_14days() != null) {
						R0300cell7.setCellValue(record.getR0300_8_14days().doubleValue());
						R0300cell7.setCellStyle(numberStyle);
					} else {
						R0300cell7.setCellValue("");
						R0300cell7.setCellStyle(textStyle);
					}

//ROW39
//Column I: 
					Cell R0300cell8 = row.createCell(8);
					if (record.getR0300_15days_1months() != null) {
						R0300cell8.setCellValue(record.getR0300_15days_1months().doubleValue());
						R0300cell8.setCellStyle(numberStyle);
					} else {
						R0300cell8.setCellValue("");
						R0300cell8.setCellStyle(textStyle);
					}

//ROW39
//Column J: 
					Cell R0300cell9 = row.createCell(9);
					if (record.getR0300_1_2months() != null) {
						R0300cell9.setCellValue(record.getR0300_1_2months().doubleValue());
						R0300cell9.setCellStyle(numberStyle);
					} else {
						R0300cell9.setCellValue("");
						R0300cell9.setCellStyle(textStyle);
					}

//ROW39
//Column K: 
					Cell R0300cell10 = row.createCell(10);
					if (record.getR0300_2_3months() != null) {
						R0300cell10.setCellValue(record.getR0300_2_3months().doubleValue());
						R0300cell10.setCellStyle(numberStyle);
					} else {
						R0300cell10.setCellValue("");
						R0300cell10.setCellStyle(textStyle);
					}

//ROW39
//Column L: 
					Cell R0300cell11 = row.createCell(11);
					if (record.getR0300_3_6months() != null) {
						R0300cell11.setCellValue(record.getR0300_3_6months().doubleValue());
						R0300cell11.setCellStyle(numberStyle);
					} else {
						R0300cell11.setCellValue("");
						R0300cell11.setCellStyle(textStyle);
					}

//ROW39
//Column M: 
					Cell R0300cell12 = row.createCell(12);
					if (record.getR0300_6_12months() != null) {
						R0300cell12.setCellValue(record.getR0300_6_12months().doubleValue());
						R0300cell12.setCellStyle(numberStyle);
					} else {
						R0300cell12.setCellValue("");
						R0300cell12.setCellStyle(textStyle);
					}

//ROW39
//Column N: 
					Cell R0300cell13 = row.createCell(13);
					if (record.getR0300_1_3years() != null) {
						R0300cell13.setCellValue(record.getR0300_1_3years().doubleValue());
						R0300cell13.setCellStyle(numberStyle);
					} else {
						R0300cell13.setCellValue("");
						R0300cell13.setCellStyle(textStyle);
					}

//ROW39
//Column O: 
					Cell R0300cell14 = row.createCell(14);
					if (record.getR0300_3_5years() != null) {
						R0300cell14.setCellValue(record.getR0300_3_5years().doubleValue());
						R0300cell14.setCellStyle(numberStyle);
					} else {
						R0300cell14.setCellValue("");
						R0300cell14.setCellStyle(textStyle);
					}

//ROW39
//Column P: 
					Cell R0300cell15 = row.createCell(15);
					if (record.getR0300_5years() != null) {
						R0300cell15.setCellValue(record.getR0300_5years().doubleValue());
						R0300cell15.setCellStyle(numberStyle);
					} else {
						R0300cell15.setCellValue("");
						R0300cell15.setCellStyle(textStyle);
					}

/////ROW40///////////
//ROW40

					row = sheet.getRow(39);

//Column E: 
					Cell R0310cell4 = row.createCell(4);
					if (record.getR0310_overdue() != null) {
						R0310cell4.setCellValue(record.getR0310_overdue().doubleValue());
						R0310cell4.setCellStyle(numberStyle);
					} else {
						R0310cell4.setCellValue("");
						R0310cell4.setCellStyle(textStyle);
					}

//ROW40
//Column F: 
					Cell R0310cell5 = row.createCell(5);
					if (record.getR0310_overdraft() != null) {
						R0310cell5.setCellValue(record.getR0310_overdraft().doubleValue());
						R0310cell5.setCellStyle(numberStyle);
					} else {
						R0310cell5.setCellValue("");
						R0310cell5.setCellStyle(textStyle);
					}

//ROW40
//Column G: 
					Cell R0310cell6 = row.createCell(6);
					if (record.getR0310_0_7days() != null) {
						R0310cell6.setCellValue(record.getR0310_0_7days().doubleValue());
						R0310cell6.setCellStyle(numberStyle);
					} else {
						R0310cell6.setCellValue("");
						R0310cell6.setCellStyle(textStyle);
					}

//ROW40
//Column H: 
					Cell R0310cell7 = row.createCell(7);
					if (record.getR0310_8_14days() != null) {
						R0310cell7.setCellValue(record.getR0310_8_14days().doubleValue());
						R0310cell7.setCellStyle(numberStyle);
					} else {
						R0310cell7.setCellValue("");
						R0310cell7.setCellStyle(textStyle);
					}

//ROW40
//Column I: 
					Cell R0310cell8 = row.createCell(8);
					if (record.getR0310_15days_1months() != null) {
						R0310cell8.setCellValue(record.getR0310_15days_1months().doubleValue());
						R0310cell8.setCellStyle(numberStyle);
					} else {
						R0310cell8.setCellValue("");
						R0310cell8.setCellStyle(textStyle);
					}

//ROW40
//Column J: 
					Cell R0310cell9 = row.createCell(9);
					if (record.getR0310_1_2months() != null) {
						R0310cell9.setCellValue(record.getR0310_1_2months().doubleValue());
						R0310cell9.setCellStyle(numberStyle);
					} else {
						R0310cell9.setCellValue("");
						R0310cell9.setCellStyle(textStyle);
					}

//ROW40
//Column K: 
					Cell R0310cell10 = row.createCell(10);
					if (record.getR0310_2_3months() != null) {
						R0310cell10.setCellValue(record.getR0310_2_3months().doubleValue());
						R0310cell10.setCellStyle(numberStyle);
					} else {
						R0310cell10.setCellValue("");
						R0310cell10.setCellStyle(textStyle);
					}

//ROW40
//Column L: 
					Cell R0310cell11 = row.createCell(11);
					if (record.getR0310_3_6months() != null) {
						R0310cell11.setCellValue(record.getR0310_3_6months().doubleValue());
						R0310cell11.setCellStyle(numberStyle);
					} else {
						R0310cell11.setCellValue("");
						R0310cell11.setCellStyle(textStyle);
					}

//ROW40
//Column M: 
					Cell R0310cell12 = row.createCell(12);
					if (record.getR0310_6_12months() != null) {
						R0310cell12.setCellValue(record.getR0310_6_12months().doubleValue());
						R0310cell12.setCellStyle(numberStyle);
					} else {
						R0310cell12.setCellValue("");
						R0310cell12.setCellStyle(textStyle);
					}

//ROW40
//Column N: 
					Cell R0310cell13 = row.createCell(13);
					if (record.getR0310_1_3years() != null) {
						R0310cell13.setCellValue(record.getR0310_1_3years().doubleValue());
						R0310cell13.setCellStyle(numberStyle);
					} else {
						R0310cell13.setCellValue("");
						R0310cell13.setCellStyle(textStyle);
					}

//ROW40
//Column O: 
					Cell R0310cell14 = row.createCell(14);
					if (record.getR0310_3_5years() != null) {
						R0310cell14.setCellValue(record.getR0310_3_5years().doubleValue());
						R0310cell14.setCellStyle(numberStyle);
					} else {
						R0310cell14.setCellValue("");
						R0310cell14.setCellStyle(textStyle);
					}

//ROW40
//Column P: 
					Cell R0310cell15 = row.createCell(15);
					if (record.getR0310_5years() != null) {
						R0310cell15.setCellValue(record.getR0310_5years().doubleValue());
						R0310cell15.setCellStyle(numberStyle);
					} else {
						R0310cell15.setCellValue("");
						R0310cell15.setCellStyle(textStyle);
					}

/////ROW41///////////
//ROW41

					row = sheet.getRow(40);

//Column E: 
					Cell R0320cell4 = row.createCell(4);
					if (record.getR0320_overdue() != null) {
						R0320cell4.setCellValue(record.getR0320_overdue().doubleValue());
						R0320cell4.setCellStyle(numberStyle);
					} else {
						R0320cell4.setCellValue("");
						R0320cell4.setCellStyle(textStyle);
					}

//ROW41
//Column F: 
					Cell R0320cell5 = row.createCell(5);
					if (record.getR0320_overdraft() != null) {
						R0320cell5.setCellValue(record.getR0320_overdraft().doubleValue());
						R0320cell5.setCellStyle(numberStyle);
					} else {
						R0320cell5.setCellValue("");
						R0320cell5.setCellStyle(textStyle);
					}

//ROW41
//Column G: 
					Cell R0320cell6 = row.createCell(6);
					if (record.getR0320_0_7days() != null) {
						R0320cell6.setCellValue(record.getR0320_0_7days().doubleValue());
						R0320cell6.setCellStyle(numberStyle);
					} else {
						R0320cell6.setCellValue("");
						R0320cell6.setCellStyle(textStyle);
					}

//ROW41
//Column H: 
					Cell R0320cell7 = row.createCell(7);
					if (record.getR0320_8_14days() != null) {
						R0320cell7.setCellValue(record.getR0320_8_14days().doubleValue());
						R0320cell7.setCellStyle(numberStyle);
					} else {
						R0320cell7.setCellValue("");
						R0320cell7.setCellStyle(textStyle);
					}

//ROW41
//Column I: 
					Cell R0320cell8 = row.createCell(8);
					if (record.getR0320_15days_1months() != null) {
						R0320cell8.setCellValue(record.getR0320_15days_1months().doubleValue());
						R0320cell8.setCellStyle(numberStyle);
					} else {
						R0320cell8.setCellValue("");
						R0320cell8.setCellStyle(textStyle);
					}

//ROW41
//Column J: 
					Cell R0320cell9 = row.createCell(9);
					if (record.getR0320_1_2months() != null) {
						R0320cell9.setCellValue(record.getR0320_1_2months().doubleValue());
						R0320cell9.setCellStyle(numberStyle);
					} else {
						R0320cell9.setCellValue("");
						R0320cell9.setCellStyle(textStyle);
					}

//ROW41
//Column K: 
					Cell R0320cell10 = row.createCell(10);
					if (record.getR0320_2_3months() != null) {
						R0320cell10.setCellValue(record.getR0320_2_3months().doubleValue());
						R0320cell10.setCellStyle(numberStyle);
					} else {
						R0320cell10.setCellValue("");
						R0320cell10.setCellStyle(textStyle);
					}

//ROW41
//Column L: 
					Cell R0320cell11 = row.createCell(11);
					if (record.getR0320_3_6months() != null) {
						R0320cell11.setCellValue(record.getR0320_3_6months().doubleValue());
						R0320cell11.setCellStyle(numberStyle);
					} else {
						R0320cell11.setCellValue("");
						R0320cell11.setCellStyle(textStyle);
					}

//ROW41
//Column M: 
					Cell R0320cell12 = row.createCell(12);
					if (record.getR0320_6_12months() != null) {
						R0320cell12.setCellValue(record.getR0320_6_12months().doubleValue());
						R0320cell12.setCellStyle(numberStyle);
					} else {
						R0320cell12.setCellValue("");
						R0320cell12.setCellStyle(textStyle);
					}

//ROW41
//Column N: 
					Cell R0320cell13 = row.createCell(13);
					if (record.getR0320_1_3years() != null) {
						R0320cell13.setCellValue(record.getR0320_1_3years().doubleValue());
						R0320cell13.setCellStyle(numberStyle);
					} else {
						R0320cell13.setCellValue("");
						R0320cell13.setCellStyle(textStyle);
					}

//ROW41
//Column O: 
					Cell R0320cell14 = row.createCell(14);
					if (record.getR0320_3_5years() != null) {
						R0320cell14.setCellValue(record.getR0320_3_5years().doubleValue());
						R0320cell14.setCellStyle(numberStyle);
					} else {
						R0320cell14.setCellValue("");
						R0320cell14.setCellStyle(textStyle);
					}

//ROW41
//Column P: 
					Cell R0320cell15 = row.createCell(15);
					if (record.getR0320_5years() != null) {
						R0320cell15.setCellValue(record.getR0320_5years().doubleValue());
						R0320cell15.setCellStyle(numberStyle);
					} else {
						R0320cell15.setCellValue("");
						R0320cell15.setCellStyle(textStyle);
					}

/////ROW42///////////
//ROW42

					row = sheet.getRow(41);

//Column E: 
					Cell R0330cell4 = row.createCell(4);
					if (record.getR0330_overdue() != null) {
						R0330cell4.setCellValue(record.getR0330_overdue().doubleValue());
						R0330cell4.setCellStyle(numberStyle);
					} else {
						R0330cell4.setCellValue("");
						R0330cell4.setCellStyle(textStyle);
					}

//ROW42
//Column F: 
					Cell R0330cell5 = row.createCell(5);
					if (record.getR0330_overdraft() != null) {
						R0330cell5.setCellValue(record.getR0330_overdraft().doubleValue());
						R0330cell5.setCellStyle(numberStyle);
					} else {
						R0330cell5.setCellValue("");
						R0330cell5.setCellStyle(textStyle);
					}

//ROW42
//Column G: 
					Cell R0330cell6 = row.createCell(6);
					if (record.getR0330_0_7days() != null) {
						R0330cell6.setCellValue(record.getR0330_0_7days().doubleValue());
						R0330cell6.setCellStyle(numberStyle);
					} else {
						R0330cell6.setCellValue("");
						R0330cell6.setCellStyle(textStyle);
					}

//ROW42
//Column H: 
					Cell R0330cell7 = row.createCell(7);
					if (record.getR0330_8_14days() != null) {
						R0330cell7.setCellValue(record.getR0330_8_14days().doubleValue());
						R0330cell7.setCellStyle(numberStyle);
					} else {
						R0330cell7.setCellValue("");
						R0330cell7.setCellStyle(textStyle);
					}

//ROW42
//Column I: 
					Cell R0330cell8 = row.createCell(8);
					if (record.getR0330_15days_1months() != null) {
						R0330cell8.setCellValue(record.getR0330_15days_1months().doubleValue());
						R0330cell8.setCellStyle(numberStyle);
					} else {
						R0330cell8.setCellValue("");
						R0330cell8.setCellStyle(textStyle);
					}

//ROW42
//Column J: 
					Cell R0330cell9 = row.createCell(9);
					if (record.getR0330_1_2months() != null) {
						R0330cell9.setCellValue(record.getR0330_1_2months().doubleValue());
						R0330cell9.setCellStyle(numberStyle);
					} else {
						R0330cell9.setCellValue("");
						R0330cell9.setCellStyle(textStyle);
					}

//ROW42
//Column K: 
					Cell R0330cell10 = row.createCell(10);
					if (record.getR0330_2_3months() != null) {
						R0330cell10.setCellValue(record.getR0330_2_3months().doubleValue());
						R0330cell10.setCellStyle(numberStyle);
					} else {
						R0330cell10.setCellValue("");
						R0330cell10.setCellStyle(textStyle);
					}

//ROW42
//Column L: 
					Cell R0330cell11 = row.createCell(11);
					if (record.getR0330_3_6months() != null) {
						R0330cell11.setCellValue(record.getR0330_3_6months().doubleValue());
						R0330cell11.setCellStyle(numberStyle);
					} else {
						R0330cell11.setCellValue("");
						R0330cell11.setCellStyle(textStyle);
					}

//ROW42
//Column M: 
					Cell R0330cell12 = row.createCell(12);
					if (record.getR0330_6_12months() != null) {
						R0330cell12.setCellValue(record.getR0330_6_12months().doubleValue());
						R0330cell12.setCellStyle(numberStyle);
					} else {
						R0330cell12.setCellValue("");
						R0330cell12.setCellStyle(textStyle);
					}

//ROW42
//Column N: 
					Cell R0330cell13 = row.createCell(13);
					if (record.getR0330_1_3years() != null) {
						R0330cell13.setCellValue(record.getR0330_1_3years().doubleValue());
						R0330cell13.setCellStyle(numberStyle);
					} else {
						R0330cell13.setCellValue("");
						R0330cell13.setCellStyle(textStyle);
					}

//ROW42
//Column O: 
					Cell R0330cell14 = row.createCell(14);
					if (record.getR0330_3_5years() != null) {
						R0330cell14.setCellValue(record.getR0330_3_5years().doubleValue());
						R0330cell14.setCellStyle(numberStyle);
					} else {
						R0330cell14.setCellValue("");
						R0330cell14.setCellStyle(textStyle);
					}

//ROW42
//Column P: 
					Cell R0330cell15 = row.createCell(15);
					if (record.getR0330_5years() != null) {
						R0330cell15.setCellValue(record.getR0330_5years().doubleValue());
						R0330cell15.setCellStyle(numberStyle);
					} else {
						R0330cell15.setCellValue("");
						R0330cell15.setCellStyle(textStyle);
					}

/////ROW43///////////
//ROW43

					row = sheet.getRow(42);

//Column E: 
					Cell R0340cell4 = row.createCell(4);
					if (record.getR0340_overdue() != null) {
						R0340cell4.setCellValue(record.getR0340_overdue().doubleValue());
						R0340cell4.setCellStyle(numberStyle);
					} else {
						R0340cell4.setCellValue("");
						R0340cell4.setCellStyle(textStyle);
					}

//ROW43
//Column F: 
					Cell R0340cell5 = row.createCell(5);
					if (record.getR0340_overdraft() != null) {
						R0340cell5.setCellValue(record.getR0340_overdraft().doubleValue());
						R0340cell5.setCellStyle(numberStyle);
					} else {
						R0340cell5.setCellValue("");
						R0340cell5.setCellStyle(textStyle);
					}

//ROW43
//Column G: 
					Cell R0340cell6 = row.createCell(6);
					if (record.getR0340_0_7days() != null) {
						R0340cell6.setCellValue(record.getR0340_0_7days().doubleValue());
						R0340cell6.setCellStyle(numberStyle);
					} else {
						R0340cell6.setCellValue("");
						R0340cell6.setCellStyle(textStyle);
					}

//ROW43
//Column H: 
					Cell R0340cell7 = row.createCell(7);
					if (record.getR0340_8_14days() != null) {
						R0340cell7.setCellValue(record.getR0340_8_14days().doubleValue());
						R0340cell7.setCellStyle(numberStyle);
					} else {
						R0340cell7.setCellValue("");
						R0340cell7.setCellStyle(textStyle);
					}

//ROW43
//Column I: 
					Cell R0340cell8 = row.createCell(8);
					if (record.getR0340_15days_1months() != null) {
						R0340cell8.setCellValue(record.getR0340_15days_1months().doubleValue());
						R0340cell8.setCellStyle(numberStyle);
					} else {
						R0340cell8.setCellValue("");
						R0340cell8.setCellStyle(textStyle);
					}

//ROW43
//Column J: 
					Cell R0340cell9 = row.createCell(9);
					if (record.getR0340_1_2months() != null) {
						R0340cell9.setCellValue(record.getR0340_1_2months().doubleValue());
						R0340cell9.setCellStyle(numberStyle);
					} else {
						R0340cell9.setCellValue("");
						R0340cell9.setCellStyle(textStyle);
					}

//ROW43
//Column K: 
					Cell R0340cell10 = row.createCell(10);
					if (record.getR0340_2_3months() != null) {
						R0340cell10.setCellValue(record.getR0340_2_3months().doubleValue());
						R0340cell10.setCellStyle(numberStyle);
					} else {
						R0340cell10.setCellValue("");
						R0340cell10.setCellStyle(textStyle);
					}

//ROW43
//Column L: 
					Cell R0340cell11 = row.createCell(11);
					if (record.getR0340_3_6months() != null) {
						R0340cell11.setCellValue(record.getR0340_3_6months().doubleValue());
						R0340cell11.setCellStyle(numberStyle);
					} else {
						R0340cell11.setCellValue("");
						R0340cell11.setCellStyle(textStyle);
					}

//ROW43
//Column M: 
					Cell R0340cell12 = row.createCell(12);
					if (record.getR0340_6_12months() != null) {
						R0340cell12.setCellValue(record.getR0340_6_12months().doubleValue());
						R0340cell12.setCellStyle(numberStyle);
					} else {
						R0340cell12.setCellValue("");
						R0340cell12.setCellStyle(textStyle);
					}

//ROW43
//Column N: 
					Cell R0340cell13 = row.createCell(13);
					if (record.getR0340_1_3years() != null) {
						R0340cell13.setCellValue(record.getR0340_1_3years().doubleValue());
						R0340cell13.setCellStyle(numberStyle);
					} else {
						R0340cell13.setCellValue("");
						R0340cell13.setCellStyle(textStyle);
					}

//ROW43
//Column O: 
					Cell R0340cell14 = row.createCell(14);
					if (record.getR0340_3_5years() != null) {
						R0340cell14.setCellValue(record.getR0340_3_5years().doubleValue());
						R0340cell14.setCellStyle(numberStyle);
					} else {
						R0340cell14.setCellValue("");
						R0340cell14.setCellStyle(textStyle);
					}

//ROW43
//Column P: 
					Cell R0340cell15 = row.createCell(15);
					if (record.getR0340_5years() != null) {
						R0340cell15.setCellValue(record.getR0340_5years().doubleValue());
						R0340cell15.setCellStyle(numberStyle);
					} else {
						R0340cell15.setCellValue("");
						R0340cell15.setCellStyle(textStyle);
					}

/////ROW44///////////
//ROW44

					row = sheet.getRow(43);

//Column E: 
					Cell R0350cell4 = row.createCell(4);
					if (record.getR0350_overdue() != null) {
						R0350cell4.setCellValue(record.getR0350_overdue().doubleValue());
						R0350cell4.setCellStyle(numberStyle);
					} else {
						R0350cell4.setCellValue("");
						R0350cell4.setCellStyle(textStyle);
					}

//ROW44
//Column F: 
					Cell R0350cell5 = row.createCell(5);
					if (record.getR0350_overdraft() != null) {
						R0350cell5.setCellValue(record.getR0350_overdraft().doubleValue());
						R0350cell5.setCellStyle(numberStyle);
					} else {
						R0350cell5.setCellValue("");
						R0350cell5.setCellStyle(textStyle);
					}

//ROW44
//Column G: 
					Cell R0350cell6 = row.createCell(6);
					if (record.getR0350_0_7days() != null) {
						R0350cell6.setCellValue(record.getR0350_0_7days().doubleValue());
						R0350cell6.setCellStyle(numberStyle);
					} else {
						R0350cell6.setCellValue("");
						R0350cell6.setCellStyle(textStyle);
					}

//ROW44
//Column H: 
					Cell R0350cell7 = row.createCell(7);
					if (record.getR0350_8_14days() != null) {
						R0350cell7.setCellValue(record.getR0350_8_14days().doubleValue());
						R0350cell7.setCellStyle(numberStyle);
					} else {
						R0350cell7.setCellValue("");
						R0350cell7.setCellStyle(textStyle);
					}

//ROW44
//Column I: 
					Cell R0350cell8 = row.createCell(8);
					if (record.getR0350_15days_1months() != null) {
						R0350cell8.setCellValue(record.getR0350_15days_1months().doubleValue());
						R0350cell8.setCellStyle(numberStyle);
					} else {
						R0350cell8.setCellValue("");
						R0350cell8.setCellStyle(textStyle);
					}

//ROW44
//Column J: 
					Cell R0350cell9 = row.createCell(9);
					if (record.getR0350_1_2months() != null) {
						R0350cell9.setCellValue(record.getR0350_1_2months().doubleValue());
						R0350cell9.setCellStyle(numberStyle);
					} else {
						R0350cell9.setCellValue("");
						R0350cell9.setCellStyle(textStyle);
					}

//ROW44
//Column K: 
					Cell R0350cell10 = row.createCell(10);
					if (record.getR0350_2_3months() != null) {
						R0350cell10.setCellValue(record.getR0350_2_3months().doubleValue());
						R0350cell10.setCellStyle(numberStyle);
					} else {
						R0350cell10.setCellValue("");
						R0350cell10.setCellStyle(textStyle);
					}

//ROW44
//Column L: 
					Cell R0350cell11 = row.createCell(11);
					if (record.getR0350_3_6months() != null) {
						R0350cell11.setCellValue(record.getR0350_3_6months().doubleValue());
						R0350cell11.setCellStyle(numberStyle);
					} else {
						R0350cell11.setCellValue("");
						R0350cell11.setCellStyle(textStyle);
					}

//ROW44
//Column M: 
					Cell R0350cell12 = row.createCell(12);
					if (record.getR0350_6_12months() != null) {
						R0350cell12.setCellValue(record.getR0350_6_12months().doubleValue());
						R0350cell12.setCellStyle(numberStyle);
					} else {
						R0350cell12.setCellValue("");
						R0350cell12.setCellStyle(textStyle);
					}

//ROW44
//Column N: 
					Cell R0350cell13 = row.createCell(13);
					if (record.getR0350_1_3years() != null) {
						R0350cell13.setCellValue(record.getR0350_1_3years().doubleValue());
						R0350cell13.setCellStyle(numberStyle);
					} else {
						R0350cell13.setCellValue("");
						R0350cell13.setCellStyle(textStyle);
					}

//ROW44
//Column O: 
					Cell R0350cell14 = row.createCell(14);
					if (record.getR0350_3_5years() != null) {
						R0350cell14.setCellValue(record.getR0350_3_5years().doubleValue());
						R0350cell14.setCellStyle(numberStyle);
					} else {
						R0350cell14.setCellValue("");
						R0350cell14.setCellStyle(textStyle);
					}

//ROW44
//Column P: 
					Cell R0350cell15 = row.createCell(15);
					if (record.getR0350_5years() != null) {
						R0350cell15.setCellValue(record.getR0350_5years().doubleValue());
						R0350cell15.setCellStyle(numberStyle);
					} else {
						R0350cell15.setCellValue("");
						R0350cell15.setCellStyle(textStyle);
					}

/////ROW45///////////
//ROW45

					row = sheet.getRow(44);

//Column E: 
					Cell R0360cell4 = row.createCell(4);
					if (record.getR0360_overdue() != null) {
						R0360cell4.setCellValue(record.getR0360_overdue().doubleValue());
						R0360cell4.setCellStyle(numberStyle);
					} else {
						R0360cell4.setCellValue("");
						R0360cell4.setCellStyle(textStyle);
					}

//ROW45
//Column F: 
					Cell R0360cell5 = row.createCell(5);
					if (record.getR0360_overdraft() != null) {
						R0360cell5.setCellValue(record.getR0360_overdraft().doubleValue());
						R0360cell5.setCellStyle(numberStyle);
					} else {
						R0360cell5.setCellValue("");
						R0360cell5.setCellStyle(textStyle);
					}

//ROW45
//Column G: 
					Cell R0360cell6 = row.createCell(6);
					if (record.getR0360_0_7days() != null) {
						R0360cell6.setCellValue(record.getR0360_0_7days().doubleValue());
						R0360cell6.setCellStyle(numberStyle);
					} else {
						R0360cell6.setCellValue("");
						R0360cell6.setCellStyle(textStyle);
					}

//ROW45
//Column H: 
					Cell R0360cell7 = row.createCell(7);
					if (record.getR0360_8_14days() != null) {
						R0360cell7.setCellValue(record.getR0360_8_14days().doubleValue());
						R0360cell7.setCellStyle(numberStyle);
					} else {
						R0360cell7.setCellValue("");
						R0360cell7.setCellStyle(textStyle);
					}

//ROW45
//Column I: 
					Cell R0360cell8 = row.createCell(8);
					if (record.getR0360_15days_1months() != null) {
						R0360cell8.setCellValue(record.getR0360_15days_1months().doubleValue());
						R0360cell8.setCellStyle(numberStyle);
					} else {
						R0360cell8.setCellValue("");
						R0360cell8.setCellStyle(textStyle);
					}

//ROW45
//Column J: 
					Cell R0360cell9 = row.createCell(9);
					if (record.getR0360_1_2months() != null) {
						R0360cell9.setCellValue(record.getR0360_1_2months().doubleValue());
						R0360cell9.setCellStyle(numberStyle);
					} else {
						R0360cell9.setCellValue("");
						R0360cell9.setCellStyle(textStyle);
					}

//ROW45
//Column K: 
					Cell R0360cell10 = row.createCell(10);
					if (record.getR0360_2_3months() != null) {
						R0360cell10.setCellValue(record.getR0360_2_3months().doubleValue());
						R0360cell10.setCellStyle(numberStyle);
					} else {
						R0360cell10.setCellValue("");
						R0360cell10.setCellStyle(textStyle);
					}

//ROW45
//Column L: 
					Cell R0360cell11 = row.createCell(11);
					if (record.getR0360_3_6months() != null) {
						R0360cell11.setCellValue(record.getR0360_3_6months().doubleValue());
						R0360cell11.setCellStyle(numberStyle);
					} else {
						R0360cell11.setCellValue("");
						R0360cell11.setCellStyle(textStyle);
					}

//ROW45
//Column M: 
					Cell R0360cell12 = row.createCell(12);
					if (record.getR0360_6_12months() != null) {
						R0360cell12.setCellValue(record.getR0360_6_12months().doubleValue());
						R0360cell12.setCellStyle(numberStyle);
					} else {
						R0360cell12.setCellValue("");
						R0360cell12.setCellStyle(textStyle);
					}

//ROW45
//Column N: 
					Cell R0360cell13 = row.createCell(13);
					if (record.getR0360_1_3years() != null) {
						R0360cell13.setCellValue(record.getR0360_1_3years().doubleValue());
						R0360cell13.setCellStyle(numberStyle);
					} else {
						R0360cell13.setCellValue("");
						R0360cell13.setCellStyle(textStyle);
					}

//ROW45
//Column O: 
					Cell R0360cell14 = row.createCell(14);
					if (record.getR0360_3_5years() != null) {
						R0360cell14.setCellValue(record.getR0360_3_5years().doubleValue());
						R0360cell14.setCellStyle(numberStyle);
					} else {
						R0360cell14.setCellValue("");
						R0360cell14.setCellStyle(textStyle);
					}

//ROW45
//Column P: 
					Cell R0360cell15 = row.createCell(15);
					if (record.getR0360_5years() != null) {
						R0360cell15.setCellValue(record.getR0360_5years().doubleValue());
						R0360cell15.setCellStyle(numberStyle);
					} else {
						R0360cell15.setCellValue("");
						R0360cell15.setCellStyle(textStyle);
					}

/////ROW46///////////
//ROW46

					row = sheet.getRow(45);

//Column E: 
					Cell R0370cell4 = row.createCell(4);
					if (record.getR0370_overdue() != null) {
						R0370cell4.setCellValue(record.getR0370_overdue().doubleValue());
						R0370cell4.setCellStyle(numberStyle);
					} else {
						R0370cell4.setCellValue("");
						R0370cell4.setCellStyle(textStyle);
					}

//ROW46
//Column F: 
					Cell R0370cell5 = row.createCell(5);
					if (record.getR0370_overdraft() != null) {
						R0370cell5.setCellValue(record.getR0370_overdraft().doubleValue());
						R0370cell5.setCellStyle(numberStyle);
					} else {
						R0370cell5.setCellValue("");
						R0370cell5.setCellStyle(textStyle);
					}

//ROW46
//Column G: 
					Cell R0370cell6 = row.createCell(6);
					if (record.getR0370_0_7days() != null) {
						R0370cell6.setCellValue(record.getR0370_0_7days().doubleValue());
						R0370cell6.setCellStyle(numberStyle);
					} else {
						R0370cell6.setCellValue("");
						R0370cell6.setCellStyle(textStyle);
					}

//ROW46
//Column H: 
					Cell R0370cell7 = row.createCell(7);
					if (record.getR0370_8_14days() != null) {
						R0370cell7.setCellValue(record.getR0370_8_14days().doubleValue());
						R0370cell7.setCellStyle(numberStyle);
					} else {
						R0370cell7.setCellValue("");
						R0370cell7.setCellStyle(textStyle);
					}

//ROW46
//Column I: 
					Cell R0370cell8 = row.createCell(8);
					if (record.getR0370_15days_1months() != null) {
						R0370cell8.setCellValue(record.getR0370_15days_1months().doubleValue());
						R0370cell8.setCellStyle(numberStyle);
					} else {
						R0370cell8.setCellValue("");
						R0370cell8.setCellStyle(textStyle);
					}

//ROW46
//Column J: 
					Cell R0370cell9 = row.createCell(9);
					if (record.getR0370_1_2months() != null) {
						R0370cell9.setCellValue(record.getR0370_1_2months().doubleValue());
						R0370cell9.setCellStyle(numberStyle);
					} else {
						R0370cell9.setCellValue("");
						R0370cell9.setCellStyle(textStyle);
					}

//ROW46
//Column K: 
					Cell R0370cell10 = row.createCell(10);
					if (record.getR0370_2_3months() != null) {
						R0370cell10.setCellValue(record.getR0370_2_3months().doubleValue());
						R0370cell10.setCellStyle(numberStyle);
					} else {
						R0370cell10.setCellValue("");
						R0370cell10.setCellStyle(textStyle);
					}

//ROW46
//Column L: 
					Cell R0370cell11 = row.createCell(11);
					if (record.getR0370_3_6months() != null) {
						R0370cell11.setCellValue(record.getR0370_3_6months().doubleValue());
						R0370cell11.setCellStyle(numberStyle);
					} else {
						R0370cell11.setCellValue("");
						R0370cell11.setCellStyle(textStyle);
					}

//ROW46
//Column M: 
					Cell R0370cell12 = row.createCell(12);
					if (record.getR0370_6_12months() != null) {
						R0370cell12.setCellValue(record.getR0370_6_12months().doubleValue());
						R0370cell12.setCellStyle(numberStyle);
					} else {
						R0370cell12.setCellValue("");
						R0370cell12.setCellStyle(textStyle);
					}

//ROW46
//Column N: 
					Cell R0370cell13 = row.createCell(13);
					if (record.getR0370_1_3years() != null) {
						R0370cell13.setCellValue(record.getR0370_1_3years().doubleValue());
						R0370cell13.setCellStyle(numberStyle);
					} else {
						R0370cell13.setCellValue("");
						R0370cell13.setCellStyle(textStyle);
					}

//ROW46
//Column O: 
					Cell R0370cell14 = row.createCell(14);
					if (record.getR0370_3_5years() != null) {
						R0370cell14.setCellValue(record.getR0370_3_5years().doubleValue());
						R0370cell14.setCellStyle(numberStyle);
					} else {
						R0370cell14.setCellValue("");
						R0370cell14.setCellStyle(textStyle);
					}

//ROW46
//Column P: 
					Cell R0370cell15 = row.createCell(15);
					if (record.getR0370_5years() != null) {
						R0370cell15.setCellValue(record.getR0370_5years().doubleValue());
						R0370cell15.setCellStyle(numberStyle);
					} else {
						R0370cell15.setCellValue("");
						R0370cell15.setCellStyle(textStyle);
					}

/////ROW47///////////
//ROW47

					row = sheet.getRow(46);

//Column E: 
					Cell R0380cell4 = row.createCell(4);
					if (record.getR0380_overdue() != null) {
						R0380cell4.setCellValue(record.getR0380_overdue().doubleValue());
						R0380cell4.setCellStyle(numberStyle);
					} else {
						R0380cell4.setCellValue("");
						R0380cell4.setCellStyle(textStyle);
					}

//ROW47
//Column F: 
					Cell R0380cell5 = row.createCell(5);
					if (record.getR0380_overdraft() != null) {
						R0380cell5.setCellValue(record.getR0380_overdraft().doubleValue());
						R0380cell5.setCellStyle(numberStyle);
					} else {
						R0380cell5.setCellValue("");
						R0380cell5.setCellStyle(textStyle);
					}

//ROW47
//Column G: 
					Cell R0380cell6 = row.createCell(6);
					if (record.getR0380_0_7days() != null) {
						R0380cell6.setCellValue(record.getR0380_0_7days().doubleValue());
						R0380cell6.setCellStyle(numberStyle);
					} else {
						R0380cell6.setCellValue("");
						R0380cell6.setCellStyle(textStyle);
					}

//ROW47
//Column H: 
					Cell R0380cell7 = row.createCell(7);
					if (record.getR0380_8_14days() != null) {
						R0380cell7.setCellValue(record.getR0380_8_14days().doubleValue());
						R0380cell7.setCellStyle(numberStyle);
					} else {
						R0380cell7.setCellValue("");
						R0380cell7.setCellStyle(textStyle);
					}

//ROW47
//Column I: 
					Cell R0380cell8 = row.createCell(8);
					if (record.getR0380_15days_1months() != null) {
						R0380cell8.setCellValue(record.getR0380_15days_1months().doubleValue());
						R0380cell8.setCellStyle(numberStyle);
					} else {
						R0380cell8.setCellValue("");
						R0380cell8.setCellStyle(textStyle);
					}

//ROW47
//Column J: 
					Cell R0380cell9 = row.createCell(9);
					if (record.getR0380_1_2months() != null) {
						R0380cell9.setCellValue(record.getR0380_1_2months().doubleValue());
						R0380cell9.setCellStyle(numberStyle);
					} else {
						R0380cell9.setCellValue("");
						R0380cell9.setCellStyle(textStyle);
					}

//ROW47
//Column K: 
					Cell R0380cell10 = row.createCell(10);
					if (record.getR0380_2_3months() != null) {
						R0380cell10.setCellValue(record.getR0380_2_3months().doubleValue());
						R0380cell10.setCellStyle(numberStyle);
					} else {
						R0380cell10.setCellValue("");
						R0380cell10.setCellStyle(textStyle);
					}

//ROW47
//Column L: 
					Cell R0380cell11 = row.createCell(11);
					if (record.getR0380_3_6months() != null) {
						R0380cell11.setCellValue(record.getR0380_3_6months().doubleValue());
						R0380cell11.setCellStyle(numberStyle);
					} else {
						R0380cell11.setCellValue("");
						R0380cell11.setCellStyle(textStyle);
					}

//ROW47
//Column M: 
					Cell R0380cell12 = row.createCell(12);
					if (record.getR0380_6_12months() != null) {
						R0380cell12.setCellValue(record.getR0380_6_12months().doubleValue());
						R0380cell12.setCellStyle(numberStyle);
					} else {
						R0380cell12.setCellValue("");
						R0380cell12.setCellStyle(textStyle);
					}

//ROW47
//Column N: 
					Cell R0380cell13 = row.createCell(13);
					if (record.getR0380_1_3years() != null) {
						R0380cell13.setCellValue(record.getR0380_1_3years().doubleValue());
						R0380cell13.setCellStyle(numberStyle);
					} else {
						R0380cell13.setCellValue("");
						R0380cell13.setCellStyle(textStyle);
					}

//ROW47
//Column O: 
					Cell R0380cell14 = row.createCell(14);
					if (record.getR0380_3_5years() != null) {
						R0380cell14.setCellValue(record.getR0380_3_5years().doubleValue());
						R0380cell14.setCellStyle(numberStyle);
					} else {
						R0380cell14.setCellValue("");
						R0380cell14.setCellStyle(textStyle);
					}

//ROW47
//Column P: 
					Cell R0380cell15 = row.createCell(15);
					if (record.getR0380_5years() != null) {
						R0380cell15.setCellValue(record.getR0380_5years().doubleValue());
						R0380cell15.setCellStyle(numberStyle);
					} else {
						R0380cell15.setCellValue("");
						R0380cell15.setCellStyle(textStyle);
					}

/////ROW49///////////
//ROW49

					row = sheet.getRow(48);

//Column E: 
					Cell R0400cell4 = row.createCell(4);
					if (record.getR0400_overdue() != null) {
						R0400cell4.setCellValue(record.getR0400_overdue().doubleValue());
						R0400cell4.setCellStyle(numberStyle);
					} else {
						R0400cell4.setCellValue("");
						R0400cell4.setCellStyle(textStyle);
					}

//ROW49
//Column F: 
					Cell R0400cell5 = row.createCell(5);
					if (record.getR0400_overdraft() != null) {
						R0400cell5.setCellValue(record.getR0400_overdraft().doubleValue());
						R0400cell5.setCellStyle(numberStyle);
					} else {
						R0400cell5.setCellValue("");
						R0400cell5.setCellStyle(textStyle);
					}

//ROW49
//Column G: 
					Cell R0400cell6 = row.createCell(6);
					if (record.getR0400_0_7days() != null) {
						R0400cell6.setCellValue(record.getR0400_0_7days().doubleValue());
						R0400cell6.setCellStyle(numberStyle);
					} else {
						R0400cell6.setCellValue("");
						R0400cell6.setCellStyle(textStyle);
					}

//ROW49
//Column H: 
					Cell R0400cell7 = row.createCell(7);
					if (record.getR0400_8_14days() != null) {
						R0400cell7.setCellValue(record.getR0400_8_14days().doubleValue());
						R0400cell7.setCellStyle(numberStyle);
					} else {
						R0400cell7.setCellValue("");
						R0400cell7.setCellStyle(textStyle);
					}

//ROW49
//Column I: 
					Cell R0400cell8 = row.createCell(8);
					if (record.getR0400_15days_1months() != null) {
						R0400cell8.setCellValue(record.getR0400_15days_1months().doubleValue());
						R0400cell8.setCellStyle(numberStyle);
					} else {
						R0400cell8.setCellValue("");
						R0400cell8.setCellStyle(textStyle);
					}

//ROW49
//Column J: 
					Cell R0400cell9 = row.createCell(9);
					if (record.getR0400_1_2months() != null) {
						R0400cell9.setCellValue(record.getR0400_1_2months().doubleValue());
						R0400cell9.setCellStyle(numberStyle);
					} else {
						R0400cell9.setCellValue("");
						R0400cell9.setCellStyle(textStyle);
					}

//ROW49
//Column K: 
					Cell R0400cell10 = row.createCell(10);
					if (record.getR0400_2_3months() != null) {
						R0400cell10.setCellValue(record.getR0400_2_3months().doubleValue());
						R0400cell10.setCellStyle(numberStyle);
					} else {
						R0400cell10.setCellValue("");
						R0400cell10.setCellStyle(textStyle);
					}

//ROW49
//Column L: 
					Cell R0400cell11 = row.createCell(11);
					if (record.getR0400_3_6months() != null) {
						R0400cell11.setCellValue(record.getR0400_3_6months().doubleValue());
						R0400cell11.setCellStyle(numberStyle);
					} else {
						R0400cell11.setCellValue("");
						R0400cell11.setCellStyle(textStyle);
					}

//ROW49
//Column M: 
					Cell R0400cell12 = row.createCell(12);
					if (record.getR0400_6_12months() != null) {
						R0400cell12.setCellValue(record.getR0400_6_12months().doubleValue());
						R0400cell12.setCellStyle(numberStyle);
					} else {
						R0400cell12.setCellValue("");
						R0400cell12.setCellStyle(textStyle);
					}

//ROW49
//Column N: 
					Cell R0400cell13 = row.createCell(13);
					if (record.getR0400_1_3years() != null) {
						R0400cell13.setCellValue(record.getR0400_1_3years().doubleValue());
						R0400cell13.setCellStyle(numberStyle);
					} else {
						R0400cell13.setCellValue("");
						R0400cell13.setCellStyle(textStyle);
					}

//ROW49
//Column O: 
					Cell R0400cell14 = row.createCell(14);
					if (record.getR0400_3_5years() != null) {
						R0400cell14.setCellValue(record.getR0400_3_5years().doubleValue());
						R0400cell14.setCellStyle(numberStyle);
					} else {
						R0400cell14.setCellValue("");
						R0400cell14.setCellStyle(textStyle);
					}

//ROW49
//Column P: 
					Cell R0400cell15 = row.createCell(15);
					if (record.getR0400_5years() != null) {
						R0400cell15.setCellValue(record.getR0400_5years().doubleValue());
						R0400cell15.setCellStyle(numberStyle);
					} else {
						R0400cell15.setCellValue("");
						R0400cell15.setCellStyle(textStyle);
					}

/////ROW50///////////
//ROW50

					row = sheet.getRow(49);

//Column E: 
					Cell R0410cell4 = row.createCell(4);
					if (record.getR0410_overdue() != null) {
						R0410cell4.setCellValue(record.getR0410_overdue().doubleValue());
						R0410cell4.setCellStyle(numberStyle);
					} else {
						R0410cell4.setCellValue("");
						R0410cell4.setCellStyle(textStyle);
					}

//ROW50
//Column F: 
					Cell R0410cell5 = row.createCell(5);
					if (record.getR0410_overdraft() != null) {
						R0410cell5.setCellValue(record.getR0410_overdraft().doubleValue());
						R0410cell5.setCellStyle(numberStyle);
					} else {
						R0410cell5.setCellValue("");
						R0410cell5.setCellStyle(textStyle);
					}

//ROW50
//Column G: 
					Cell R0410cell6 = row.createCell(6);
					if (record.getR0410_0_7days() != null) {
						R0410cell6.setCellValue(record.getR0410_0_7days().doubleValue());
						R0410cell6.setCellStyle(numberStyle);
					} else {
						R0410cell6.setCellValue("");
						R0410cell6.setCellStyle(textStyle);
					}

//ROW50
//Column H: 
					Cell R0410cell7 = row.createCell(7);
					if (record.getR0410_8_14days() != null) {
						R0410cell7.setCellValue(record.getR0410_8_14days().doubleValue());
						R0410cell7.setCellStyle(numberStyle);
					} else {
						R0410cell7.setCellValue("");
						R0410cell7.setCellStyle(textStyle);
					}

//ROW50
//Column I: 
					Cell R0410cell8 = row.createCell(8);
					if (record.getR0410_15days_1months() != null) {
						R0410cell8.setCellValue(record.getR0410_15days_1months().doubleValue());
						R0410cell8.setCellStyle(numberStyle);
					} else {
						R0410cell8.setCellValue("");
						R0410cell8.setCellStyle(textStyle);
					}

//ROW50
//Column J: 
					Cell R0410cell9 = row.createCell(9);
					if (record.getR0410_1_2months() != null) {
						R0410cell9.setCellValue(record.getR0410_1_2months().doubleValue());
						R0410cell9.setCellStyle(numberStyle);
					} else {
						R0410cell9.setCellValue("");
						R0410cell9.setCellStyle(textStyle);
					}

//ROW50
//Column K: 
					Cell R0410cell10 = row.createCell(10);
					if (record.getR0410_2_3months() != null) {
						R0410cell10.setCellValue(record.getR0410_2_3months().doubleValue());
						R0410cell10.setCellStyle(numberStyle);
					} else {
						R0410cell10.setCellValue("");
						R0410cell10.setCellStyle(textStyle);
					}

//ROW50
//Column L: 
					Cell R0410cell11 = row.createCell(11);
					if (record.getR0410_3_6months() != null) {
						R0410cell11.setCellValue(record.getR0410_3_6months().doubleValue());
						R0410cell11.setCellStyle(numberStyle);
					} else {
						R0410cell11.setCellValue("");
						R0410cell11.setCellStyle(textStyle);
					}

//ROW50
//Column M: 
					Cell R0410cell12 = row.createCell(12);
					if (record.getR0410_6_12months() != null) {
						R0410cell12.setCellValue(record.getR0410_6_12months().doubleValue());
						R0410cell12.setCellStyle(numberStyle);
					} else {
						R0410cell12.setCellValue("");
						R0410cell12.setCellStyle(textStyle);
					}

//ROW50
//Column N: 
					Cell R0410cell13 = row.createCell(13);
					if (record.getR0410_1_3years() != null) {
						R0410cell13.setCellValue(record.getR0410_1_3years().doubleValue());
						R0410cell13.setCellStyle(numberStyle);
					} else {
						R0410cell13.setCellValue("");
						R0410cell13.setCellStyle(textStyle);
					}

//ROW50
//Column O: 
					Cell R0410cell14 = row.createCell(14);
					if (record.getR0410_3_5years() != null) {
						R0410cell14.setCellValue(record.getR0410_3_5years().doubleValue());
						R0410cell14.setCellStyle(numberStyle);
					} else {
						R0410cell14.setCellValue("");
						R0410cell14.setCellStyle(textStyle);
					}

//ROW50
//Column P: 
					Cell R0410cell15 = row.createCell(15);
					if (record.getR0410_5years() != null) {
						R0410cell15.setCellValue(record.getR0410_5years().doubleValue());
						R0410cell15.setCellStyle(numberStyle);
					} else {
						R0410cell15.setCellValue("");
						R0410cell15.setCellStyle(textStyle);
					}

/////ROW51///////////
//ROW51

					row = sheet.getRow(50);

//Column E: 
					Cell R0420cell4 = row.createCell(4);
					if (record.getR0420_overdue() != null) {
						R0420cell4.setCellValue(record.getR0420_overdue().doubleValue());
						R0420cell4.setCellStyle(numberStyle);
					} else {
						R0420cell4.setCellValue("");
						R0420cell4.setCellStyle(textStyle);
					}

//ROW51
//Column F: 
					Cell R0420cell5 = row.createCell(5);
					if (record.getR0420_overdraft() != null) {
						R0420cell5.setCellValue(record.getR0420_overdraft().doubleValue());
						R0420cell5.setCellStyle(numberStyle);
					} else {
						R0420cell5.setCellValue("");
						R0420cell5.setCellStyle(textStyle);
					}

//ROW51
//Column G: 
					Cell R0420cell6 = row.createCell(6);
					if (record.getR0420_0_7days() != null) {
						R0420cell6.setCellValue(record.getR0420_0_7days().doubleValue());
						R0420cell6.setCellStyle(numberStyle);
					} else {
						R0420cell6.setCellValue("");
						R0420cell6.setCellStyle(textStyle);
					}

//ROW51
//Column H: 
					Cell R0420cell7 = row.createCell(7);
					if (record.getR0420_8_14days() != null) {
						R0420cell7.setCellValue(record.getR0420_8_14days().doubleValue());
						R0420cell7.setCellStyle(numberStyle);
					} else {
						R0420cell7.setCellValue("");
						R0420cell7.setCellStyle(textStyle);
					}

//ROW51
//Column I: 
					Cell R0420cell8 = row.createCell(8);
					if (record.getR0420_15days_1months() != null) {
						R0420cell8.setCellValue(record.getR0420_15days_1months().doubleValue());
						R0420cell8.setCellStyle(numberStyle);
					} else {
						R0420cell8.setCellValue("");
						R0420cell8.setCellStyle(textStyle);
					}

//ROW51
//Column J: 
					Cell R0420cell9 = row.createCell(9);
					if (record.getR0420_1_2months() != null) {
						R0420cell9.setCellValue(record.getR0420_1_2months().doubleValue());
						R0420cell9.setCellStyle(numberStyle);
					} else {
						R0420cell9.setCellValue("");
						R0420cell9.setCellStyle(textStyle);
					}

//ROW51
//Column K: 
					Cell R0420cell10 = row.createCell(10);
					if (record.getR0420_2_3months() != null) {
						R0420cell10.setCellValue(record.getR0420_2_3months().doubleValue());
						R0420cell10.setCellStyle(numberStyle);
					} else {
						R0420cell10.setCellValue("");
						R0420cell10.setCellStyle(textStyle);
					}

//ROW51
//Column L: 
					Cell R0420cell11 = row.createCell(11);
					if (record.getR0420_3_6months() != null) {
						R0420cell11.setCellValue(record.getR0420_3_6months().doubleValue());
						R0420cell11.setCellStyle(numberStyle);
					} else {
						R0420cell11.setCellValue("");
						R0420cell11.setCellStyle(textStyle);
					}

//ROW51
//Column M: 
					Cell R0420cell12 = row.createCell(12);
					if (record.getR0420_6_12months() != null) {
						R0420cell12.setCellValue(record.getR0420_6_12months().doubleValue());
						R0420cell12.setCellStyle(numberStyle);
					} else {
						R0420cell12.setCellValue("");
						R0420cell12.setCellStyle(textStyle);
					}

//ROW51
//Column N: 
					Cell R0420cell13 = row.createCell(13);
					if (record.getR0420_1_3years() != null) {
						R0420cell13.setCellValue(record.getR0420_1_3years().doubleValue());
						R0420cell13.setCellStyle(numberStyle);
					} else {
						R0420cell13.setCellValue("");
						R0420cell13.setCellStyle(textStyle);
					}

//ROW51
//Column O: 
					Cell R0420cell14 = row.createCell(14);
					if (record.getR0420_3_5years() != null) {
						R0420cell14.setCellValue(record.getR0420_3_5years().doubleValue());
						R0420cell14.setCellStyle(numberStyle);
					} else {
						R0420cell14.setCellValue("");
						R0420cell14.setCellStyle(textStyle);
					}

//ROW51
//Column P: 
					Cell R0420cell15 = row.createCell(15);
					if (record.getR0420_5years() != null) {
						R0420cell15.setCellValue(record.getR0420_5years().doubleValue());
						R0420cell15.setCellStyle(numberStyle);
					} else {
						R0420cell15.setCellValue("");
						R0420cell15.setCellStyle(textStyle);
					}

/////ROW52///////////
//ROW52

					row = sheet.getRow(51);

//Column E: 
					Cell R0430cell4 = row.createCell(4);
					if (record.getR0430_overdue() != null) {
						R0430cell4.setCellValue(record.getR0430_overdue().doubleValue());
						R0430cell4.setCellStyle(numberStyle);
					} else {
						R0430cell4.setCellValue("");
						R0430cell4.setCellStyle(textStyle);
					}

//ROW52
//Column F: 
					Cell R0430cell5 = row.createCell(5);
					if (record.getR0430_overdraft() != null) {
						R0430cell5.setCellValue(record.getR0430_overdraft().doubleValue());
						R0430cell5.setCellStyle(numberStyle);
					} else {
						R0430cell5.setCellValue("");
						R0430cell5.setCellStyle(textStyle);
					}

//ROW52
//Column G: 
					Cell R0430cell6 = row.createCell(6);
					if (record.getR0430_0_7days() != null) {
						R0430cell6.setCellValue(record.getR0430_0_7days().doubleValue());
						R0430cell6.setCellStyle(numberStyle);
					} else {
						R0430cell6.setCellValue("");
						R0430cell6.setCellStyle(textStyle);
					}

//ROW52
//Column H: 
					Cell R0430cell7 = row.createCell(7);
					if (record.getR0430_8_14days() != null) {
						R0430cell7.setCellValue(record.getR0430_8_14days().doubleValue());
						R0430cell7.setCellStyle(numberStyle);
					} else {
						R0430cell7.setCellValue("");
						R0430cell7.setCellStyle(textStyle);
					}

//ROW52
//Column I: 
					Cell R0430cell8 = row.createCell(8);
					if (record.getR0430_15days_1months() != null) {
						R0430cell8.setCellValue(record.getR0430_15days_1months().doubleValue());
						R0430cell8.setCellStyle(numberStyle);
					} else {
						R0430cell8.setCellValue("");
						R0430cell8.setCellStyle(textStyle);
					}

//ROW52
//Column J: 
					Cell R0430cell9 = row.createCell(9);
					if (record.getR0430_1_2months() != null) {
						R0430cell9.setCellValue(record.getR0430_1_2months().doubleValue());
						R0430cell9.setCellStyle(numberStyle);
					} else {
						R0430cell9.setCellValue("");
						R0430cell9.setCellStyle(textStyle);
					}

//ROW52
//Column K: 
					Cell R0430cell10 = row.createCell(10);
					if (record.getR0430_2_3months() != null) {
						R0430cell10.setCellValue(record.getR0430_2_3months().doubleValue());
						R0430cell10.setCellStyle(numberStyle);
					} else {
						R0430cell10.setCellValue("");
						R0430cell10.setCellStyle(textStyle);
					}

//ROW52
//Column L: 
					Cell R0430cell11 = row.createCell(11);
					if (record.getR0430_3_6months() != null) {
						R0430cell11.setCellValue(record.getR0430_3_6months().doubleValue());
						R0430cell11.setCellStyle(numberStyle);
					} else {
						R0430cell11.setCellValue("");
						R0430cell11.setCellStyle(textStyle);
					}

//ROW52
//Column M: 
					Cell R0430cell12 = row.createCell(12);
					if (record.getR0430_6_12months() != null) {
						R0430cell12.setCellValue(record.getR0430_6_12months().doubleValue());
						R0430cell12.setCellStyle(numberStyle);
					} else {
						R0430cell12.setCellValue("");
						R0430cell12.setCellStyle(textStyle);
					}

//ROW52
//Column N: 
					Cell R0430cell13 = row.createCell(13);
					if (record.getR0430_1_3years() != null) {
						R0430cell13.setCellValue(record.getR0430_1_3years().doubleValue());
						R0430cell13.setCellStyle(numberStyle);
					} else {
						R0430cell13.setCellValue("");
						R0430cell13.setCellStyle(textStyle);
					}

//ROW52
//Column O: 
					Cell R0430cell14 = row.createCell(14);
					if (record.getR0430_3_5years() != null) {
						R0430cell14.setCellValue(record.getR0430_3_5years().doubleValue());
						R0430cell14.setCellStyle(numberStyle);
					} else {
						R0430cell14.setCellValue("");
						R0430cell14.setCellStyle(textStyle);
					}

//ROW52
//Column P: 
					Cell R0430cell15 = row.createCell(15);
					if (record.getR0430_5years() != null) {
						R0430cell15.setCellValue(record.getR0430_5years().doubleValue());
						R0430cell15.setCellStyle(numberStyle);
					} else {
						R0430cell15.setCellValue("");
						R0430cell15.setCellStyle(textStyle);
					}

/////ROW56///////////
//ROW56

					row = sheet.getRow(55);

//Column E: 
					Cell R0470cell4 = row.createCell(4);
					if (record.getR0470_overdue() != null) {
						R0470cell4.setCellValue(record.getR0470_overdue().doubleValue());
						R0470cell4.setCellStyle(numberStyle);
					} else {
						R0470cell4.setCellValue("");
						R0470cell4.setCellStyle(textStyle);
					}

//ROW56
//Column F: 
					Cell R0470cell5 = row.createCell(5);
					if (record.getR0470_overdraft() != null) {
						R0470cell5.setCellValue(record.getR0470_overdraft().doubleValue());
						R0470cell5.setCellStyle(numberStyle);
					} else {
						R0470cell5.setCellValue("");
						R0470cell5.setCellStyle(textStyle);
					}

//ROW56
//Column G: 
					Cell R0470cell6 = row.createCell(6);
					if (record.getR0470_0_7days() != null) {
						R0470cell6.setCellValue(record.getR0470_0_7days().doubleValue());
						R0470cell6.setCellStyle(numberStyle);
					} else {
						R0470cell6.setCellValue("");
						R0470cell6.setCellStyle(textStyle);
					}

//ROW56
//Column H: 
					Cell R0470cell7 = row.createCell(7);
					if (record.getR0470_8_14days() != null) {
						R0470cell7.setCellValue(record.getR0470_8_14days().doubleValue());
						R0470cell7.setCellStyle(numberStyle);
					} else {
						R0470cell7.setCellValue("");
						R0470cell7.setCellStyle(textStyle);
					}

//ROW56
//Column I: 
					Cell R0470cell8 = row.createCell(8);
					if (record.getR0470_15days_1months() != null) {
						R0470cell8.setCellValue(record.getR0470_15days_1months().doubleValue());
						R0470cell8.setCellStyle(numberStyle);
					} else {
						R0470cell8.setCellValue("");
						R0470cell8.setCellStyle(textStyle);
					}

//ROW56
//Column J: 
					Cell R0470cell9 = row.createCell(9);
					if (record.getR0470_1_2months() != null) {
						R0470cell9.setCellValue(record.getR0470_1_2months().doubleValue());
						R0470cell9.setCellStyle(numberStyle);
					} else {
						R0470cell9.setCellValue("");
						R0470cell9.setCellStyle(textStyle);
					}

//ROW56
//Column K: 
					Cell R0470cell10 = row.createCell(10);
					if (record.getR0470_2_3months() != null) {
						R0470cell10.setCellValue(record.getR0470_2_3months().doubleValue());
						R0470cell10.setCellStyle(numberStyle);
					} else {
						R0470cell10.setCellValue("");
						R0470cell10.setCellStyle(textStyle);
					}

//ROW56
//Column L: 
					Cell R0470cell11 = row.createCell(11);
					if (record.getR0470_3_6months() != null) {
						R0470cell11.setCellValue(record.getR0470_3_6months().doubleValue());
						R0470cell11.setCellStyle(numberStyle);
					} else {
						R0470cell11.setCellValue("");
						R0470cell11.setCellStyle(textStyle);
					}

//ROW56
//Column M: 
					Cell R0470cell12 = row.createCell(12);
					if (record.getR0470_6_12months() != null) {
						R0470cell12.setCellValue(record.getR0470_6_12months().doubleValue());
						R0470cell12.setCellStyle(numberStyle);
					} else {
						R0470cell12.setCellValue("");
						R0470cell12.setCellStyle(textStyle);
					}

//ROW56
//Column N: 
					Cell R0470cell13 = row.createCell(13);
					if (record.getR0470_1_3years() != null) {
						R0470cell13.setCellValue(record.getR0470_1_3years().doubleValue());
						R0470cell13.setCellStyle(numberStyle);
					} else {
						R0470cell13.setCellValue("");
						R0470cell13.setCellStyle(textStyle);
					}

//ROW56
//Column O: 
					Cell R0470cell14 = row.createCell(14);
					if (record.getR0470_3_5years() != null) {
						R0470cell14.setCellValue(record.getR0470_3_5years().doubleValue());
						R0470cell14.setCellStyle(numberStyle);
					} else {
						R0470cell14.setCellValue("");
						R0470cell14.setCellStyle(textStyle);
					}

//ROW56
//Column P: 
					Cell R0470cell15 = row.createCell(15);
					if (record.getR0470_5years() != null) {
						R0470cell15.setCellValue(record.getR0470_5years().doubleValue());
						R0470cell15.setCellStyle(numberStyle);
					} else {
						R0470cell15.setCellValue("");
						R0470cell15.setCellStyle(textStyle);
					}

/////ROW57///////////
//ROW57

					row = sheet.getRow(56);

//Column E: 
					Cell R0480cell4 = row.createCell(4);
					if (record.getR0480_overdue() != null) {
						R0480cell4.setCellValue(record.getR0480_overdue().doubleValue());
						R0480cell4.setCellStyle(numberStyle);
					} else {
						R0480cell4.setCellValue("");
						R0480cell4.setCellStyle(textStyle);
					}

//ROW57
//Column F: 
					Cell R0480cell5 = row.createCell(5);
					if (record.getR0480_overdraft() != null) {
						R0480cell5.setCellValue(record.getR0480_overdraft().doubleValue());
						R0480cell5.setCellStyle(numberStyle);
					} else {
						R0480cell5.setCellValue("");
						R0480cell5.setCellStyle(textStyle);
					}

//ROW57
//Column G: 
					Cell R0480cell6 = row.createCell(6);
					if (record.getR0480_0_7days() != null) {
						R0480cell6.setCellValue(record.getR0480_0_7days().doubleValue());
						R0480cell6.setCellStyle(numberStyle);
					} else {
						R0480cell6.setCellValue("");
						R0480cell6.setCellStyle(textStyle);
					}

//ROW57
//Column H: 
					Cell R0480cell7 = row.createCell(7);
					if (record.getR0480_8_14days() != null) {
						R0480cell7.setCellValue(record.getR0480_8_14days().doubleValue());
						R0480cell7.setCellStyle(numberStyle);
					} else {
						R0480cell7.setCellValue("");
						R0480cell7.setCellStyle(textStyle);
					}

//ROW57
//Column I: 
					Cell R0480cell8 = row.createCell(8);
					if (record.getR0480_15days_1months() != null) {
						R0480cell8.setCellValue(record.getR0480_15days_1months().doubleValue());
						R0480cell8.setCellStyle(numberStyle);
					} else {
						R0480cell8.setCellValue("");
						R0480cell8.setCellStyle(textStyle);
					}

//ROW57
//Column J: 
					Cell R0480cell9 = row.createCell(9);
					if (record.getR0480_1_2months() != null) {
						R0480cell9.setCellValue(record.getR0480_1_2months().doubleValue());
						R0480cell9.setCellStyle(numberStyle);
					} else {
						R0480cell9.setCellValue("");
						R0480cell9.setCellStyle(textStyle);
					}

//ROW57
//Column K: 
					Cell R0480cell10 = row.createCell(10);
					if (record.getR0480_2_3months() != null) {
						R0480cell10.setCellValue(record.getR0480_2_3months().doubleValue());
						R0480cell10.setCellStyle(numberStyle);
					} else {
						R0480cell10.setCellValue("");
						R0480cell10.setCellStyle(textStyle);
					}

//ROW57
//Column L: 
					Cell R0480cell11 = row.createCell(11);
					if (record.getR0480_3_6months() != null) {
						R0480cell11.setCellValue(record.getR0480_3_6months().doubleValue());
						R0480cell11.setCellStyle(numberStyle);
					} else {
						R0480cell11.setCellValue("");
						R0480cell11.setCellStyle(textStyle);
					}

//ROW57
//Column M: 
					Cell R0480cell12 = row.createCell(12);
					if (record.getR0480_6_12months() != null) {
						R0480cell12.setCellValue(record.getR0480_6_12months().doubleValue());
						R0480cell12.setCellStyle(numberStyle);
					} else {
						R0480cell12.setCellValue("");
						R0480cell12.setCellStyle(textStyle);
					}

//ROW57
//Column N: 
					Cell R0480cell13 = row.createCell(13);
					if (record.getR0480_1_3years() != null) {
						R0480cell13.setCellValue(record.getR0480_1_3years().doubleValue());
						R0480cell13.setCellStyle(numberStyle);
					} else {
						R0480cell13.setCellValue("");
						R0480cell13.setCellStyle(textStyle);
					}

//ROW57
//Column O: 
					Cell R0480cell14 = row.createCell(14);
					if (record.getR0480_3_5years() != null) {
						R0480cell14.setCellValue(record.getR0480_3_5years().doubleValue());
						R0480cell14.setCellStyle(numberStyle);
					} else {
						R0480cell14.setCellValue("");
						R0480cell14.setCellStyle(textStyle);
					}

//ROW57
//Column P: 
					Cell R0480cell15 = row.createCell(15);
					if (record.getR0480_5years() != null) {
						R0480cell15.setCellValue(record.getR0480_5years().doubleValue());
						R0480cell15.setCellStyle(numberStyle);
					} else {
						R0480cell15.setCellValue("");
						R0480cell15.setCellStyle(textStyle);
					}

/////ROW58///////////
//ROW58

					row = sheet.getRow(57);

//Column E: 
					Cell R0490cell4 = row.createCell(4);
					if (record.getR0490_overdue() != null) {
						R0490cell4.setCellValue(record.getR0490_overdue().doubleValue());
						R0490cell4.setCellStyle(numberStyle);
					} else {
						R0490cell4.setCellValue("");
						R0490cell4.setCellStyle(textStyle);
					}

//ROW58
//Column F: 
					Cell R0490cell5 = row.createCell(5);
					if (record.getR0490_overdraft() != null) {
						R0490cell5.setCellValue(record.getR0490_overdraft().doubleValue());
						R0490cell5.setCellStyle(numberStyle);
					} else {
						R0490cell5.setCellValue("");
						R0490cell5.setCellStyle(textStyle);
					}

//ROW58
//Column G: 
					Cell R0490cell6 = row.createCell(6);
					if (record.getR0490_0_7days() != null) {
						R0490cell6.setCellValue(record.getR0490_0_7days().doubleValue());
						R0490cell6.setCellStyle(numberStyle);
					} else {
						R0490cell6.setCellValue("");
						R0490cell6.setCellStyle(textStyle);
					}

//ROW58
//Column H: 
					Cell R0490cell7 = row.createCell(7);
					if (record.getR0490_8_14days() != null) {
						R0490cell7.setCellValue(record.getR0490_8_14days().doubleValue());
						R0490cell7.setCellStyle(numberStyle);
					} else {
						R0490cell7.setCellValue("");
						R0490cell7.setCellStyle(textStyle);
					}

//ROW58
//Column I: 
					Cell R0490cell8 = row.createCell(8);
					if (record.getR0490_15days_1months() != null) {
						R0490cell8.setCellValue(record.getR0490_15days_1months().doubleValue());
						R0490cell8.setCellStyle(numberStyle);
					} else {
						R0490cell8.setCellValue("");
						R0490cell8.setCellStyle(textStyle);
					}

//ROW58
//Column J: 
					Cell R0490cell9 = row.createCell(9);
					if (record.getR0490_1_2months() != null) {
						R0490cell9.setCellValue(record.getR0490_1_2months().doubleValue());
						R0490cell9.setCellStyle(numberStyle);
					} else {
						R0490cell9.setCellValue("");
						R0490cell9.setCellStyle(textStyle);
					}

//ROW58
//Column K: 
					Cell R0490cell10 = row.createCell(10);
					if (record.getR0490_2_3months() != null) {
						R0490cell10.setCellValue(record.getR0490_2_3months().doubleValue());
						R0490cell10.setCellStyle(numberStyle);
					} else {
						R0490cell10.setCellValue("");
						R0490cell10.setCellStyle(textStyle);
					}

//ROW58
//Column L: 
					Cell R0490cell11 = row.createCell(11);
					if (record.getR0490_3_6months() != null) {
						R0490cell11.setCellValue(record.getR0490_3_6months().doubleValue());
						R0490cell11.setCellStyle(numberStyle);
					} else {
						R0490cell11.setCellValue("");
						R0490cell11.setCellStyle(textStyle);
					}

//ROW58
//Column M: 
					Cell R0490cell12 = row.createCell(12);
					if (record.getR0490_6_12months() != null) {
						R0490cell12.setCellValue(record.getR0490_6_12months().doubleValue());
						R0490cell12.setCellStyle(numberStyle);
					} else {
						R0490cell12.setCellValue("");
						R0490cell12.setCellStyle(textStyle);
					}

//ROW58
//Column N: 
					Cell R0490cell13 = row.createCell(13);
					if (record.getR0490_1_3years() != null) {
						R0490cell13.setCellValue(record.getR0490_1_3years().doubleValue());
						R0490cell13.setCellStyle(numberStyle);
					} else {
						R0490cell13.setCellValue("");
						R0490cell13.setCellStyle(textStyle);
					}

//ROW58
//Column O: 
					Cell R0490cell14 = row.createCell(14);
					if (record.getR0490_3_5years() != null) {
						R0490cell14.setCellValue(record.getR0490_3_5years().doubleValue());
						R0490cell14.setCellStyle(numberStyle);
					} else {
						R0490cell14.setCellValue("");
						R0490cell14.setCellStyle(textStyle);
					}

//ROW58
//Column P: 
					Cell R0490cell15 = row.createCell(15);
					if (record.getR0490_5years() != null) {
						R0490cell15.setCellValue(record.getR0490_5years().doubleValue());
						R0490cell15.setCellStyle(numberStyle);
					} else {
						R0490cell15.setCellValue("");
						R0490cell15.setCellStyle(textStyle);
					}

/////ROW59///////////
//ROW59

					row = sheet.getRow(58);

//Column E: 
					Cell R0500cell4 = row.createCell(4);
					if (record.getR0500_overdue() != null) {
						R0500cell4.setCellValue(record.getR0500_overdue().doubleValue());
						R0500cell4.setCellStyle(numberStyle);
					} else {
						R0500cell4.setCellValue("");
						R0500cell4.setCellStyle(textStyle);
					}

//ROW59
//Column F: 
					Cell R0500cell5 = row.createCell(5);
					if (record.getR0500_overdraft() != null) {
						R0500cell5.setCellValue(record.getR0500_overdraft().doubleValue());
						R0500cell5.setCellStyle(numberStyle);
					} else {
						R0500cell5.setCellValue("");
						R0500cell5.setCellStyle(textStyle);
					}

//ROW59
//Column G: 
					Cell R0500cell6 = row.createCell(6);
					if (record.getR0500_0_7days() != null) {
						R0500cell6.setCellValue(record.getR0500_0_7days().doubleValue());
						R0500cell6.setCellStyle(numberStyle);
					} else {
						R0500cell6.setCellValue("");
						R0500cell6.setCellStyle(textStyle);
					}

//ROW59
//Column H: 
					Cell R0500cell7 = row.createCell(7);
					if (record.getR0500_8_14days() != null) {
						R0500cell7.setCellValue(record.getR0500_8_14days().doubleValue());
						R0500cell7.setCellStyle(numberStyle);
					} else {
						R0500cell7.setCellValue("");
						R0500cell7.setCellStyle(textStyle);
					}

//ROW59
//Column I: 
					Cell R0500cell8 = row.createCell(8);
					if (record.getR0500_15days_1months() != null) {
						R0500cell8.setCellValue(record.getR0500_15days_1months().doubleValue());
						R0500cell8.setCellStyle(numberStyle);
					} else {
						R0500cell8.setCellValue("");
						R0500cell8.setCellStyle(textStyle);
					}

//ROW59
//Column J: 
					Cell R0500cell9 = row.createCell(9);
					if (record.getR0500_1_2months() != null) {
						R0500cell9.setCellValue(record.getR0500_1_2months().doubleValue());
						R0500cell9.setCellStyle(numberStyle);
					} else {
						R0500cell9.setCellValue("");
						R0500cell9.setCellStyle(textStyle);
					}

//ROW59
//Column K: 
					Cell R0500cell10 = row.createCell(10);
					if (record.getR0500_2_3months() != null) {
						R0500cell10.setCellValue(record.getR0500_2_3months().doubleValue());
						R0500cell10.setCellStyle(numberStyle);
					} else {
						R0500cell10.setCellValue("");
						R0500cell10.setCellStyle(textStyle);
					}

//ROW59
//Column L: 
					Cell R0500cell11 = row.createCell(11);
					if (record.getR0500_3_6months() != null) {
						R0500cell11.setCellValue(record.getR0500_3_6months().doubleValue());
						R0500cell11.setCellStyle(numberStyle);
					} else {
						R0500cell11.setCellValue("");
						R0500cell11.setCellStyle(textStyle);
					}

//ROW59
//Column M: 
					Cell R0500cell12 = row.createCell(12);
					if (record.getR0500_6_12months() != null) {
						R0500cell12.setCellValue(record.getR0500_6_12months().doubleValue());
						R0500cell12.setCellStyle(numberStyle);
					} else {
						R0500cell12.setCellValue("");
						R0500cell12.setCellStyle(textStyle);
					}

//ROW59
//Column N: 
					Cell R0500cell13 = row.createCell(13);
					if (record.getR0500_1_3years() != null) {
						R0500cell13.setCellValue(record.getR0500_1_3years().doubleValue());
						R0500cell13.setCellStyle(numberStyle);
					} else {
						R0500cell13.setCellValue("");
						R0500cell13.setCellStyle(textStyle);
					}

//ROW59
//Column O: 
					Cell R0500cell14 = row.createCell(14);
					if (record.getR0500_3_5years() != null) {
						R0500cell14.setCellValue(record.getR0500_3_5years().doubleValue());
						R0500cell14.setCellStyle(numberStyle);
					} else {
						R0500cell14.setCellValue("");
						R0500cell14.setCellStyle(textStyle);
					}

//ROW59
//Column P: 
					Cell R0500cell15 = row.createCell(15);
					if (record.getR0500_5years() != null) {
						R0500cell15.setCellValue(record.getR0500_5years().doubleValue());
						R0500cell15.setCellStyle(numberStyle);
					} else {
						R0500cell15.setCellValue("");
						R0500cell15.setCellStyle(textStyle);
					}

/////ROW60///////////
//ROW60

					row = sheet.getRow(59);

//Column E: 
					Cell R0510cell4 = row.createCell(4);
					if (record.getR0510_overdue() != null) {
						R0510cell4.setCellValue(record.getR0510_overdue().doubleValue());
						R0510cell4.setCellStyle(numberStyle);
					} else {
						R0510cell4.setCellValue("");
						R0510cell4.setCellStyle(textStyle);
					}

//ROW60
//Column F: 
					Cell R0510cell5 = row.createCell(5);
					if (record.getR0510_overdraft() != null) {
						R0510cell5.setCellValue(record.getR0510_overdraft().doubleValue());
						R0510cell5.setCellStyle(numberStyle);
					} else {
						R0510cell5.setCellValue("");
						R0510cell5.setCellStyle(textStyle);
					}

//ROW60
//Column G: 
					Cell R0510cell6 = row.createCell(6);
					if (record.getR0510_0_7days() != null) {
						R0510cell6.setCellValue(record.getR0510_0_7days().doubleValue());
						R0510cell6.setCellStyle(numberStyle);
					} else {
						R0510cell6.setCellValue("");
						R0510cell6.setCellStyle(textStyle);
					}

//ROW60
//Column H: 
					Cell R0510cell7 = row.createCell(7);
					if (record.getR0510_8_14days() != null) {
						R0510cell7.setCellValue(record.getR0510_8_14days().doubleValue());
						R0510cell7.setCellStyle(numberStyle);
					} else {
						R0510cell7.setCellValue("");
						R0510cell7.setCellStyle(textStyle);
					}

//ROW60
//Column I: 
					Cell R0510cell8 = row.createCell(8);
					if (record.getR0510_15days_1months() != null) {
						R0510cell8.setCellValue(record.getR0510_15days_1months().doubleValue());
						R0510cell8.setCellStyle(numberStyle);
					} else {
						R0510cell8.setCellValue("");
						R0510cell8.setCellStyle(textStyle);
					}

//ROW60
//Column J: 
					Cell R0510cell9 = row.createCell(9);
					if (record.getR0510_1_2months() != null) {
						R0510cell9.setCellValue(record.getR0510_1_2months().doubleValue());
						R0510cell9.setCellStyle(numberStyle);
					} else {
						R0510cell9.setCellValue("");
						R0510cell9.setCellStyle(textStyle);
					}

//ROW60
//Column K: 
					Cell R0510cell10 = row.createCell(10);
					if (record.getR0510_2_3months() != null) {
						R0510cell10.setCellValue(record.getR0510_2_3months().doubleValue());
						R0510cell10.setCellStyle(numberStyle);
					} else {
						R0510cell10.setCellValue("");
						R0510cell10.setCellStyle(textStyle);
					}

//ROW60
//Column L: 
					Cell R0510cell11 = row.createCell(11);
					if (record.getR0510_3_6months() != null) {
						R0510cell11.setCellValue(record.getR0510_3_6months().doubleValue());
						R0510cell11.setCellStyle(numberStyle);
					} else {
						R0510cell11.setCellValue("");
						R0510cell11.setCellStyle(textStyle);
					}

//ROW60
//Column M: 
					Cell R0510cell12 = row.createCell(12);
					if (record.getR0510_6_12months() != null) {
						R0510cell12.setCellValue(record.getR0510_6_12months().doubleValue());
						R0510cell12.setCellStyle(numberStyle);
					} else {
						R0510cell12.setCellValue("");
						R0510cell12.setCellStyle(textStyle);
					}

//ROW60
//Column N: 
					Cell R0510cell13 = row.createCell(13);
					if (record.getR0510_1_3years() != null) {
						R0510cell13.setCellValue(record.getR0510_1_3years().doubleValue());
						R0510cell13.setCellStyle(numberStyle);
					} else {
						R0510cell13.setCellValue("");
						R0510cell13.setCellStyle(textStyle);
					}

//ROW60
//Column O: 
					Cell R0510cell14 = row.createCell(14);
					if (record.getR0510_3_5years() != null) {
						R0510cell14.setCellValue(record.getR0510_3_5years().doubleValue());
						R0510cell14.setCellStyle(numberStyle);
					} else {
						R0510cell14.setCellValue("");
						R0510cell14.setCellStyle(textStyle);
					}

//ROW60
//Column P: 
					Cell R0510cell15 = row.createCell(15);
					if (record.getR0510_5years() != null) {
						R0510cell15.setCellValue(record.getR0510_5years().doubleValue());
						R0510cell15.setCellStyle(numberStyle);
					} else {
						R0510cell15.setCellValue("");
						R0510cell15.setCellStyle(textStyle);
					}

/////ROW62///////////
//ROW62

					row = sheet.getRow(61);

//Column E: 
					Cell R0530cell4 = row.createCell(4);
					if (record.getR0530_overdue() != null) {
						R0530cell4.setCellValue(record.getR0530_overdue().doubleValue());
						R0530cell4.setCellStyle(numberStyle);
					} else {
						R0530cell4.setCellValue("");
						R0530cell4.setCellStyle(textStyle);
					}

//ROW62
//Column F: 
					Cell R0530cell5 = row.createCell(5);
					if (record.getR0530_overdraft() != null) {
						R0530cell5.setCellValue(record.getR0530_overdraft().doubleValue());
						R0530cell5.setCellStyle(numberStyle);
					} else {
						R0530cell5.setCellValue("");
						R0530cell5.setCellStyle(textStyle);
					}

//ROW62
//Column G: 
					Cell R0530cell6 = row.createCell(6);
					if (record.getR0530_0_7days() != null) {
						R0530cell6.setCellValue(record.getR0530_0_7days().doubleValue());
						R0530cell6.setCellStyle(numberStyle);
					} else {
						R0530cell6.setCellValue("");
						R0530cell6.setCellStyle(textStyle);
					}

//ROW62
//Column H: 
					Cell R0530cell7 = row.createCell(7);
					if (record.getR0530_8_14days() != null) {
						R0530cell7.setCellValue(record.getR0530_8_14days().doubleValue());
						R0530cell7.setCellStyle(numberStyle);
					} else {
						R0530cell7.setCellValue("");
						R0530cell7.setCellStyle(textStyle);
					}

//ROW62
//Column I: 
					Cell R0530cell8 = row.createCell(8);
					if (record.getR0530_15days_1months() != null) {
						R0530cell8.setCellValue(record.getR0530_15days_1months().doubleValue());
						R0530cell8.setCellStyle(numberStyle);
					} else {
						R0530cell8.setCellValue("");
						R0530cell8.setCellStyle(textStyle);
					}

//ROW62
//Column J: 
					Cell R0530cell9 = row.createCell(9);
					if (record.getR0530_1_2months() != null) {
						R0530cell9.setCellValue(record.getR0530_1_2months().doubleValue());
						R0530cell9.setCellStyle(numberStyle);
					} else {
						R0530cell9.setCellValue("");
						R0530cell9.setCellStyle(textStyle);
					}

//ROW62
//Column K: 
					Cell R0530cell10 = row.createCell(10);
					if (record.getR0530_2_3months() != null) {
						R0530cell10.setCellValue(record.getR0530_2_3months().doubleValue());
						R0530cell10.setCellStyle(numberStyle);
					} else {
						R0530cell10.setCellValue("");
						R0530cell10.setCellStyle(textStyle);
					}

//ROW62
//Column L: 
					Cell R0530cell11 = row.createCell(11);
					if (record.getR0530_3_6months() != null) {
						R0530cell11.setCellValue(record.getR0530_3_6months().doubleValue());
						R0530cell11.setCellStyle(numberStyle);
					} else {
						R0530cell11.setCellValue("");
						R0530cell11.setCellStyle(textStyle);
					}

//ROW62
//Column M: 
					Cell R0530cell12 = row.createCell(12);
					if (record.getR0530_6_12months() != null) {
						R0530cell12.setCellValue(record.getR0530_6_12months().doubleValue());
						R0530cell12.setCellStyle(numberStyle);
					} else {
						R0530cell12.setCellValue("");
						R0530cell12.setCellStyle(textStyle);
					}

//ROW62
//Column N: 
					Cell R0530cell13 = row.createCell(13);
					if (record.getR0530_1_3years() != null) {
						R0530cell13.setCellValue(record.getR0530_1_3years().doubleValue());
						R0530cell13.setCellStyle(numberStyle);
					} else {
						R0530cell13.setCellValue("");
						R0530cell13.setCellStyle(textStyle);
					}

//ROW62
//Column O: 
					Cell R0530cell14 = row.createCell(14);
					if (record.getR0530_3_5years() != null) {
						R0530cell14.setCellValue(record.getR0530_3_5years().doubleValue());
						R0530cell14.setCellStyle(numberStyle);
					} else {
						R0530cell14.setCellValue("");
						R0530cell14.setCellStyle(textStyle);
					}

//ROW62
//Column P: 
					Cell R0530cell15 = row.createCell(15);
					if (record.getR0530_5years() != null) {
						R0530cell15.setCellValue(record.getR0530_5years().doubleValue());
						R0530cell15.setCellStyle(numberStyle);
					} else {
						R0530cell15.setCellValue("");
						R0530cell15.setCellStyle(textStyle);
					}

/////ROW63///////////
//ROW63

					row = sheet.getRow(62);

//Column E: 
					Cell R0540cell4 = row.createCell(4);
					if (record.getR0540_overdue() != null) {
						R0540cell4.setCellValue(record.getR0540_overdue().doubleValue());
						R0540cell4.setCellStyle(numberStyle);
					} else {
						R0540cell4.setCellValue("");
						R0540cell4.setCellStyle(textStyle);
					}

//ROW63
//Column F: 
					Cell R0540cell5 = row.createCell(5);
					if (record.getR0540_overdraft() != null) {
						R0540cell5.setCellValue(record.getR0540_overdraft().doubleValue());
						R0540cell5.setCellStyle(numberStyle);
					} else {
						R0540cell5.setCellValue("");
						R0540cell5.setCellStyle(textStyle);
					}

//ROW63
//Column G: 
					Cell R0540cell6 = row.createCell(6);
					if (record.getR0540_0_7days() != null) {
						R0540cell6.setCellValue(record.getR0540_0_7days().doubleValue());
						R0540cell6.setCellStyle(numberStyle);
					} else {
						R0540cell6.setCellValue("");
						R0540cell6.setCellStyle(textStyle);
					}

//ROW63
//Column H: 
					Cell R0540cell7 = row.createCell(7);
					if (record.getR0540_8_14days() != null) {
						R0540cell7.setCellValue(record.getR0540_8_14days().doubleValue());
						R0540cell7.setCellStyle(numberStyle);
					} else {
						R0540cell7.setCellValue("");
						R0540cell7.setCellStyle(textStyle);
					}

//ROW63
//Column I: 
					Cell R0540cell8 = row.createCell(8);
					if (record.getR0540_15days_1months() != null) {
						R0540cell8.setCellValue(record.getR0540_15days_1months().doubleValue());
						R0540cell8.setCellStyle(numberStyle);
					} else {
						R0540cell8.setCellValue("");
						R0540cell8.setCellStyle(textStyle);
					}

//ROW63
//Column J: 
					Cell R0540cell9 = row.createCell(9);
					if (record.getR0540_1_2months() != null) {
						R0540cell9.setCellValue(record.getR0540_1_2months().doubleValue());
						R0540cell9.setCellStyle(numberStyle);
					} else {
						R0540cell9.setCellValue("");
						R0540cell9.setCellStyle(textStyle);
					}

//ROW63
//Column K: 
					Cell R0540cell10 = row.createCell(10);
					if (record.getR0540_2_3months() != null) {
						R0540cell10.setCellValue(record.getR0540_2_3months().doubleValue());
						R0540cell10.setCellStyle(numberStyle);
					} else {
						R0540cell10.setCellValue("");
						R0540cell10.setCellStyle(textStyle);
					}

//ROW63
//Column L: 
					Cell R0540cell11 = row.createCell(11);
					if (record.getR0540_3_6months() != null) {
						R0540cell11.setCellValue(record.getR0540_3_6months().doubleValue());
						R0540cell11.setCellStyle(numberStyle);
					} else {
						R0540cell11.setCellValue("");
						R0540cell11.setCellStyle(textStyle);
					}

//ROW63
//Column M: 
					Cell R0540cell12 = row.createCell(12);
					if (record.getR0540_6_12months() != null) {
						R0540cell12.setCellValue(record.getR0540_6_12months().doubleValue());
						R0540cell12.setCellStyle(numberStyle);
					} else {
						R0540cell12.setCellValue("");
						R0540cell12.setCellStyle(textStyle);
					}

//ROW63
//Column N: 
					Cell R0540cell13 = row.createCell(13);
					if (record.getR0540_1_3years() != null) {
						R0540cell13.setCellValue(record.getR0540_1_3years().doubleValue());
						R0540cell13.setCellStyle(numberStyle);
					} else {
						R0540cell13.setCellValue("");
						R0540cell13.setCellStyle(textStyle);
					}

//ROW63
//Column O: 
					Cell R0540cell14 = row.createCell(14);
					if (record.getR0540_3_5years() != null) {
						R0540cell14.setCellValue(record.getR0540_3_5years().doubleValue());
						R0540cell14.setCellStyle(numberStyle);
					} else {
						R0540cell14.setCellValue("");
						R0540cell14.setCellStyle(textStyle);
					}

//ROW63
//Column P: 
					Cell R0540cell15 = row.createCell(15);
					if (record.getR0540_5years() != null) {
						R0540cell15.setCellValue(record.getR0540_5years().doubleValue());
						R0540cell15.setCellStyle(numberStyle);
					} else {
						R0540cell15.setCellValue("");
						R0540cell15.setCellStyle(textStyle);
					}

/////ROW64///////////
//ROW64

					row = sheet.getRow(63);

//Column E: 
					Cell R0550cell4 = row.createCell(4);
					if (record.getR0550_overdue() != null) {
						R0550cell4.setCellValue(record.getR0550_overdue().doubleValue());
						R0550cell4.setCellStyle(numberStyle);
					} else {
						R0550cell4.setCellValue("");
						R0550cell4.setCellStyle(textStyle);
					}

//ROW64
//Column F: 
					Cell R0550cell5 = row.createCell(5);
					if (record.getR0550_overdraft() != null) {
						R0550cell5.setCellValue(record.getR0550_overdraft().doubleValue());
						R0550cell5.setCellStyle(numberStyle);
					} else {
						R0550cell5.setCellValue("");
						R0550cell5.setCellStyle(textStyle);
					}

//ROW64
//Column G: 
					Cell R0550cell6 = row.createCell(6);
					if (record.getR0550_0_7days() != null) {
						R0550cell6.setCellValue(record.getR0550_0_7days().doubleValue());
						R0550cell6.setCellStyle(numberStyle);
					} else {
						R0550cell6.setCellValue("");
						R0550cell6.setCellStyle(textStyle);
					}

//ROW64
//Column H: 
					Cell R0550cell7 = row.createCell(7);
					if (record.getR0550_8_14days() != null) {
						R0550cell7.setCellValue(record.getR0550_8_14days().doubleValue());
						R0550cell7.setCellStyle(numberStyle);
					} else {
						R0550cell7.setCellValue("");
						R0550cell7.setCellStyle(textStyle);
					}

//ROW64
//Column I: 
					Cell R0550cell8 = row.createCell(8);
					if (record.getR0550_15days_1months() != null) {
						R0550cell8.setCellValue(record.getR0550_15days_1months().doubleValue());
						R0550cell8.setCellStyle(numberStyle);
					} else {
						R0550cell8.setCellValue("");
						R0550cell8.setCellStyle(textStyle);
					}

//ROW64
//Column J: 
					Cell R0550cell9 = row.createCell(9);
					if (record.getR0550_1_2months() != null) {
						R0550cell9.setCellValue(record.getR0550_1_2months().doubleValue());
						R0550cell9.setCellStyle(numberStyle);
					} else {
						R0550cell9.setCellValue("");
						R0550cell9.setCellStyle(textStyle);
					}

//ROW64
//Column K: 
					Cell R0550cell10 = row.createCell(10);
					if (record.getR0550_2_3months() != null) {
						R0550cell10.setCellValue(record.getR0550_2_3months().doubleValue());
						R0550cell10.setCellStyle(numberStyle);
					} else {
						R0550cell10.setCellValue("");
						R0550cell10.setCellStyle(textStyle);
					}

//ROW64
//Column L: 
					Cell R0550cell11 = row.createCell(11);
					if (record.getR0550_3_6months() != null) {
						R0550cell11.setCellValue(record.getR0550_3_6months().doubleValue());
						R0550cell11.setCellStyle(numberStyle);
					} else {
						R0550cell11.setCellValue("");
						R0550cell11.setCellStyle(textStyle);
					}

//ROW64
//Column M: 
					Cell R0550cell12 = row.createCell(12);
					if (record.getR0550_6_12months() != null) {
						R0550cell12.setCellValue(record.getR0550_6_12months().doubleValue());
						R0550cell12.setCellStyle(numberStyle);
					} else {
						R0550cell12.setCellValue("");
						R0550cell12.setCellStyle(textStyle);
					}

//ROW64
//Column N: 
					Cell R0550cell13 = row.createCell(13);
					if (record.getR0550_1_3years() != null) {
						R0550cell13.setCellValue(record.getR0550_1_3years().doubleValue());
						R0550cell13.setCellStyle(numberStyle);
					} else {
						R0550cell13.setCellValue("");
						R0550cell13.setCellStyle(textStyle);
					}

//ROW64
//Column O: 
					Cell R0550cell14 = row.createCell(14);
					if (record.getR0550_3_5years() != null) {
						R0550cell14.setCellValue(record.getR0550_3_5years().doubleValue());
						R0550cell14.setCellStyle(numberStyle);
					} else {
						R0550cell14.setCellValue("");
						R0550cell14.setCellStyle(textStyle);
					}

//ROW64
//Column P: 
					Cell R0550cell15 = row.createCell(15);
					if (record.getR0550_5years() != null) {
						R0550cell15.setCellValue(record.getR0550_5years().doubleValue());
						R0550cell15.setCellStyle(numberStyle);
					} else {
						R0550cell15.setCellValue("");
						R0550cell15.setCellStyle(textStyle);
					}

/////ROW65///////////
//ROW65

					row = sheet.getRow(64);

//Column E: 
					Cell R0560cell4 = row.createCell(4);
					if (record.getR0560_overdue() != null) {
						R0560cell4.setCellValue(record.getR0560_overdue().doubleValue());
						R0560cell4.setCellStyle(numberStyle);
					} else {
						R0560cell4.setCellValue("");
						R0560cell4.setCellStyle(textStyle);
					}

//ROW65
//Column F: 
					Cell R0560cell5 = row.createCell(5);
					if (record.getR0560_overdraft() != null) {
						R0560cell5.setCellValue(record.getR0560_overdraft().doubleValue());
						R0560cell5.setCellStyle(numberStyle);
					} else {
						R0560cell5.setCellValue("");
						R0560cell5.setCellStyle(textStyle);
					}

//ROW65
//Column G: 
					Cell R0560cell6 = row.createCell(6);
					if (record.getR0560_0_7days() != null) {
						R0560cell6.setCellValue(record.getR0560_0_7days().doubleValue());
						R0560cell6.setCellStyle(numberStyle);
					} else {
						R0560cell6.setCellValue("");
						R0560cell6.setCellStyle(textStyle);
					}

//ROW65
//Column H: 
					Cell R0560cell7 = row.createCell(7);
					if (record.getR0560_8_14days() != null) {
						R0560cell7.setCellValue(record.getR0560_8_14days().doubleValue());
						R0560cell7.setCellStyle(numberStyle);
					} else {
						R0560cell7.setCellValue("");
						R0560cell7.setCellStyle(textStyle);
					}

//ROW65
//Column I: 
					Cell R0560cell8 = row.createCell(8);
					if (record.getR0560_15days_1months() != null) {
						R0560cell8.setCellValue(record.getR0560_15days_1months().doubleValue());
						R0560cell8.setCellStyle(numberStyle);
					} else {
						R0560cell8.setCellValue("");
						R0560cell8.setCellStyle(textStyle);
					}

//ROW65
//Column J: 
					Cell R0560cell9 = row.createCell(9);
					if (record.getR0560_1_2months() != null) {
						R0560cell9.setCellValue(record.getR0560_1_2months().doubleValue());
						R0560cell9.setCellStyle(numberStyle);
					} else {
						R0560cell9.setCellValue("");
						R0560cell9.setCellStyle(textStyle);
					}

//ROW65
//Column K: 
					Cell R0560cell10 = row.createCell(10);
					if (record.getR0560_2_3months() != null) {
						R0560cell10.setCellValue(record.getR0560_2_3months().doubleValue());
						R0560cell10.setCellStyle(numberStyle);
					} else {
						R0560cell10.setCellValue("");
						R0560cell10.setCellStyle(textStyle);
					}

//ROW65
//Column L: 
					Cell R0560cell11 = row.createCell(11);
					if (record.getR0560_3_6months() != null) {
						R0560cell11.setCellValue(record.getR0560_3_6months().doubleValue());
						R0560cell11.setCellStyle(numberStyle);
					} else {
						R0560cell11.setCellValue("");
						R0560cell11.setCellStyle(textStyle);
					}

//ROW65
//Column M: 
					Cell R0560cell12 = row.createCell(12);
					if (record.getR0560_6_12months() != null) {
						R0560cell12.setCellValue(record.getR0560_6_12months().doubleValue());
						R0560cell12.setCellStyle(numberStyle);
					} else {
						R0560cell12.setCellValue("");
						R0560cell12.setCellStyle(textStyle);
					}

//ROW65
//Column N: 
					Cell R0560cell13 = row.createCell(13);
					if (record.getR0560_1_3years() != null) {
						R0560cell13.setCellValue(record.getR0560_1_3years().doubleValue());
						R0560cell13.setCellStyle(numberStyle);
					} else {
						R0560cell13.setCellValue("");
						R0560cell13.setCellStyle(textStyle);
					}

//ROW65
//Column O: 
					Cell R0560cell14 = row.createCell(14);
					if (record.getR0560_3_5years() != null) {
						R0560cell14.setCellValue(record.getR0560_3_5years().doubleValue());
						R0560cell14.setCellStyle(numberStyle);
					} else {
						R0560cell14.setCellValue("");
						R0560cell14.setCellStyle(textStyle);
					}

//ROW65
//Column P: 
					Cell R0560cell15 = row.createCell(15);
					if (record.getR0560_5years() != null) {
						R0560cell15.setCellValue(record.getR0560_5years().doubleValue());
						R0560cell15.setCellStyle(numberStyle);
					} else {
						R0560cell15.setCellValue("");
						R0560cell15.setCellStyle(textStyle);
					}

/////ROW66///////////
//ROW66

					row = sheet.getRow(65);

//Column E: 
					Cell R0570cell4 = row.createCell(4);
					if (record.getR0570_overdue() != null) {
						R0570cell4.setCellValue(record.getR0570_overdue().doubleValue());
						R0570cell4.setCellStyle(numberStyle);
					} else {
						R0570cell4.setCellValue("");
						R0570cell4.setCellStyle(textStyle);
					}

//ROW66
//Column F: 
					Cell R0570cell5 = row.createCell(5);
					if (record.getR0570_overdraft() != null) {
						R0570cell5.setCellValue(record.getR0570_overdraft().doubleValue());
						R0570cell5.setCellStyle(numberStyle);
					} else {
						R0570cell5.setCellValue("");
						R0570cell5.setCellStyle(textStyle);
					}

//ROW66
//Column G: 
					Cell R0570cell6 = row.createCell(6);
					if (record.getR0570_0_7days() != null) {
						R0570cell6.setCellValue(record.getR0570_0_7days().doubleValue());
						R0570cell6.setCellStyle(numberStyle);
					} else {
						R0570cell6.setCellValue("");
						R0570cell6.setCellStyle(textStyle);
					}

//ROW66
//Column H: 
					Cell R0570cell7 = row.createCell(7);
					if (record.getR0570_8_14days() != null) {
						R0570cell7.setCellValue(record.getR0570_8_14days().doubleValue());
						R0570cell7.setCellStyle(numberStyle);
					} else {
						R0570cell7.setCellValue("");
						R0570cell7.setCellStyle(textStyle);
					}

//ROW66
//Column I: 
					Cell R0570cell8 = row.createCell(8);
					if (record.getR0570_15days_1months() != null) {
						R0570cell8.setCellValue(record.getR0570_15days_1months().doubleValue());
						R0570cell8.setCellStyle(numberStyle);
					} else {
						R0570cell8.setCellValue("");
						R0570cell8.setCellStyle(textStyle);
					}

//ROW66
//Column J: 
					Cell R0570cell9 = row.createCell(9);
					if (record.getR0570_1_2months() != null) {
						R0570cell9.setCellValue(record.getR0570_1_2months().doubleValue());
						R0570cell9.setCellStyle(numberStyle);
					} else {
						R0570cell9.setCellValue("");
						R0570cell9.setCellStyle(textStyle);
					}

//ROW66
//Column K: 
					Cell R0570cell10 = row.createCell(10);
					if (record.getR0570_2_3months() != null) {
						R0570cell10.setCellValue(record.getR0570_2_3months().doubleValue());
						R0570cell10.setCellStyle(numberStyle);
					} else {
						R0570cell10.setCellValue("");
						R0570cell10.setCellStyle(textStyle);
					}

//ROW66
//Column L: 
					Cell R0570cell11 = row.createCell(11);
					if (record.getR0570_3_6months() != null) {
						R0570cell11.setCellValue(record.getR0570_3_6months().doubleValue());
						R0570cell11.setCellStyle(numberStyle);
					} else {
						R0570cell11.setCellValue("");
						R0570cell11.setCellStyle(textStyle);
					}

//ROW66
//Column M: 
					Cell R0570cell12 = row.createCell(12);
					if (record.getR0570_6_12months() != null) {
						R0570cell12.setCellValue(record.getR0570_6_12months().doubleValue());
						R0570cell12.setCellStyle(numberStyle);
					} else {
						R0570cell12.setCellValue("");
						R0570cell12.setCellStyle(textStyle);
					}

//ROW66
//Column N: 
					Cell R0570cell13 = row.createCell(13);
					if (record.getR0570_1_3years() != null) {
						R0570cell13.setCellValue(record.getR0570_1_3years().doubleValue());
						R0570cell13.setCellStyle(numberStyle);
					} else {
						R0570cell13.setCellValue("");
						R0570cell13.setCellStyle(textStyle);
					}

//ROW66
//Column O: 
					Cell R0570cell14 = row.createCell(14);
					if (record.getR0570_3_5years() != null) {
						R0570cell14.setCellValue(record.getR0570_3_5years().doubleValue());
						R0570cell14.setCellStyle(numberStyle);
					} else {
						R0570cell14.setCellValue("");
						R0570cell14.setCellStyle(textStyle);
					}

//ROW66
//Column P: 
					Cell R0570cell15 = row.createCell(15);
					if (record.getR0570_5years() != null) {
						R0570cell15.setCellValue(record.getR0570_5years().doubleValue());
						R0570cell15.setCellStyle(numberStyle);
					} else {
						R0570cell15.setCellValue("");
						R0570cell15.setCellStyle(textStyle);
					}

/////ROW67///////////
//ROW67

					row = sheet.getRow(66);

//Column E: 
					Cell R0580cell4 = row.createCell(4);
					if (record.getR0580_overdue() != null) {
						R0580cell4.setCellValue(record.getR0580_overdue().doubleValue());
						R0580cell4.setCellStyle(numberStyle);
					} else {
						R0580cell4.setCellValue("");
						R0580cell4.setCellStyle(textStyle);
					}

//ROW67
//Column F: 
					Cell R0580cell5 = row.createCell(5);
					if (record.getR0580_overdraft() != null) {
						R0580cell5.setCellValue(record.getR0580_overdraft().doubleValue());
						R0580cell5.setCellStyle(numberStyle);
					} else {
						R0580cell5.setCellValue("");
						R0580cell5.setCellStyle(textStyle);
					}

//ROW67
//Column G: 
					Cell R0580cell6 = row.createCell(6);
					if (record.getR0580_0_7days() != null) {
						R0580cell6.setCellValue(record.getR0580_0_7days().doubleValue());
						R0580cell6.setCellStyle(numberStyle);
					} else {
						R0580cell6.setCellValue("");
						R0580cell6.setCellStyle(textStyle);
					}

//ROW67
//Column H: 
					Cell R0580cell7 = row.createCell(7);
					if (record.getR0580_8_14days() != null) {
						R0580cell7.setCellValue(record.getR0580_8_14days().doubleValue());
						R0580cell7.setCellStyle(numberStyle);
					} else {
						R0580cell7.setCellValue("");
						R0580cell7.setCellStyle(textStyle);
					}

//ROW67
//Column I: 
					Cell R0580cell8 = row.createCell(8);
					if (record.getR0580_15days_1months() != null) {
						R0580cell8.setCellValue(record.getR0580_15days_1months().doubleValue());
						R0580cell8.setCellStyle(numberStyle);
					} else {
						R0580cell8.setCellValue("");
						R0580cell8.setCellStyle(textStyle);
					}

//ROW67
//Column J: 
					Cell R0580cell9 = row.createCell(9);
					if (record.getR0580_1_2months() != null) {
						R0580cell9.setCellValue(record.getR0580_1_2months().doubleValue());
						R0580cell9.setCellStyle(numberStyle);
					} else {
						R0580cell9.setCellValue("");
						R0580cell9.setCellStyle(textStyle);
					}

//ROW67
//Column K: 
					Cell R0580cell10 = row.createCell(10);
					if (record.getR0580_2_3months() != null) {
						R0580cell10.setCellValue(record.getR0580_2_3months().doubleValue());
						R0580cell10.setCellStyle(numberStyle);
					} else {
						R0580cell10.setCellValue("");
						R0580cell10.setCellStyle(textStyle);
					}

//ROW67
//Column L: 
					Cell R0580cell11 = row.createCell(11);
					if (record.getR0580_3_6months() != null) {
						R0580cell11.setCellValue(record.getR0580_3_6months().doubleValue());
						R0580cell11.setCellStyle(numberStyle);
					} else {
						R0580cell11.setCellValue("");
						R0580cell11.setCellStyle(textStyle);
					}

//ROW67
//Column M: 
					Cell R0580cell12 = row.createCell(12);
					if (record.getR0580_6_12months() != null) {
						R0580cell12.setCellValue(record.getR0580_6_12months().doubleValue());
						R0580cell12.setCellStyle(numberStyle);
					} else {
						R0580cell12.setCellValue("");
						R0580cell12.setCellStyle(textStyle);
					}

//ROW67
//Column N: 
					Cell R0580cell13 = row.createCell(13);
					if (record.getR0580_1_3years() != null) {
						R0580cell13.setCellValue(record.getR0580_1_3years().doubleValue());
						R0580cell13.setCellStyle(numberStyle);
					} else {
						R0580cell13.setCellValue("");
						R0580cell13.setCellStyle(textStyle);
					}

//ROW67
//Column O: 
					Cell R0580cell14 = row.createCell(14);
					if (record.getR0580_3_5years() != null) {
						R0580cell14.setCellValue(record.getR0580_3_5years().doubleValue());
						R0580cell14.setCellStyle(numberStyle);
					} else {
						R0580cell14.setCellValue("");
						R0580cell14.setCellStyle(textStyle);
					}

//ROW67
//Column P: 
					Cell R0580cell15 = row.createCell(15);
					if (record.getR0580_5years() != null) {
						R0580cell15.setCellValue(record.getR0580_5years().doubleValue());
						R0580cell15.setCellStyle(numberStyle);
					} else {
						R0580cell15.setCellValue("");
						R0580cell15.setCellStyle(textStyle);
					}

/////ROW69///////////
//ROW69

					row = sheet.getRow(68);

//Column E: 
					Cell R0600cell4 = row.createCell(4);
					if (record.getR0600_overdue() != null) {
						R0600cell4.setCellValue(record.getR0600_overdue().doubleValue());
						R0600cell4.setCellStyle(numberStyle);
					} else {
						R0600cell4.setCellValue("");
						R0600cell4.setCellStyle(textStyle);
					}

//ROW69
//Column F: 
					Cell R0600cell5 = row.createCell(5);
					if (record.getR0600_overdraft() != null) {
						R0600cell5.setCellValue(record.getR0600_overdraft().doubleValue());
						R0600cell5.setCellStyle(numberStyle);
					} else {
						R0600cell5.setCellValue("");
						R0600cell5.setCellStyle(textStyle);
					}

//ROW69
//Column G: 
					Cell R0600cell6 = row.createCell(6);
					if (record.getR0600_0_7days() != null) {
						R0600cell6.setCellValue(record.getR0600_0_7days().doubleValue());
						R0600cell6.setCellStyle(numberStyle);
					} else {
						R0600cell6.setCellValue("");
						R0600cell6.setCellStyle(textStyle);
					}

//ROW69
//Column H: 
					Cell R0600cell7 = row.createCell(7);
					if (record.getR0600_8_14days() != null) {
						R0600cell7.setCellValue(record.getR0600_8_14days().doubleValue());
						R0600cell7.setCellStyle(numberStyle);
					} else {
						R0600cell7.setCellValue("");
						R0600cell7.setCellStyle(textStyle);
					}

//ROW69
//Column I: 
					Cell R0600cell8 = row.createCell(8);
					if (record.getR0600_15days_1months() != null) {
						R0600cell8.setCellValue(record.getR0600_15days_1months().doubleValue());
						R0600cell8.setCellStyle(numberStyle);
					} else {
						R0600cell8.setCellValue("");
						R0600cell8.setCellStyle(textStyle);
					}

//ROW69
//Column J: 
					Cell R0600cell9 = row.createCell(9);
					if (record.getR0600_1_2months() != null) {
						R0600cell9.setCellValue(record.getR0600_1_2months().doubleValue());
						R0600cell9.setCellStyle(numberStyle);
					} else {
						R0600cell9.setCellValue("");
						R0600cell9.setCellStyle(textStyle);
					}

//ROW69
//Column K: 
					Cell R0600cell10 = row.createCell(10);
					if (record.getR0600_2_3months() != null) {
						R0600cell10.setCellValue(record.getR0600_2_3months().doubleValue());
						R0600cell10.setCellStyle(numberStyle);
					} else {
						R0600cell10.setCellValue("");
						R0600cell10.setCellStyle(textStyle);
					}

//ROW69
//Column L: 
					Cell R0600cell11 = row.createCell(11);
					if (record.getR0600_3_6months() != null) {
						R0600cell11.setCellValue(record.getR0600_3_6months().doubleValue());
						R0600cell11.setCellStyle(numberStyle);
					} else {
						R0600cell11.setCellValue("");
						R0600cell11.setCellStyle(textStyle);
					}

//ROW69
//Column M: 
					Cell R0600cell12 = row.createCell(12);
					if (record.getR0600_6_12months() != null) {
						R0600cell12.setCellValue(record.getR0600_6_12months().doubleValue());
						R0600cell12.setCellStyle(numberStyle);
					} else {
						R0600cell12.setCellValue("");
						R0600cell12.setCellStyle(textStyle);
					}

//ROW69
//Column N: 
					Cell R0600cell13 = row.createCell(13);
					if (record.getR0600_1_3years() != null) {
						R0600cell13.setCellValue(record.getR0600_1_3years().doubleValue());
						R0600cell13.setCellStyle(numberStyle);
					} else {
						R0600cell13.setCellValue("");
						R0600cell13.setCellStyle(textStyle);
					}

//ROW69
//Column O: 
					Cell R0600cell14 = row.createCell(14);
					if (record.getR0600_3_5years() != null) {
						R0600cell14.setCellValue(record.getR0600_3_5years().doubleValue());
						R0600cell14.setCellStyle(numberStyle);
					} else {
						R0600cell14.setCellValue("");
						R0600cell14.setCellStyle(textStyle);
					}

//ROW69
//Column P: 
					Cell R0600cell15 = row.createCell(15);
					if (record.getR0600_5years() != null) {
						R0600cell15.setCellValue(record.getR0600_5years().doubleValue());
						R0600cell15.setCellStyle(numberStyle);
					} else {
						R0600cell15.setCellValue("");
						R0600cell15.setCellStyle(textStyle);
					}

/////ROW70///////////
//ROW70

					row = sheet.getRow(69);

//Column E: 
					Cell R0610cell4 = row.createCell(4);
					if (record.getR0610_overdue() != null) {
						R0610cell4.setCellValue(record.getR0610_overdue().doubleValue());
						R0610cell4.setCellStyle(numberStyle);
					} else {
						R0610cell4.setCellValue("");
						R0610cell4.setCellStyle(textStyle);
					}

//ROW70
//Column F: 
					Cell R0610cell5 = row.createCell(5);
					if (record.getR0610_overdraft() != null) {
						R0610cell5.setCellValue(record.getR0610_overdraft().doubleValue());
						R0610cell5.setCellStyle(numberStyle);
					} else {
						R0610cell5.setCellValue("");
						R0610cell5.setCellStyle(textStyle);
					}

//ROW70
//Column G: 
					Cell R0610cell6 = row.createCell(6);
					if (record.getR0610_0_7days() != null) {
						R0610cell6.setCellValue(record.getR0610_0_7days().doubleValue());
						R0610cell6.setCellStyle(numberStyle);
					} else {
						R0610cell6.setCellValue("");
						R0610cell6.setCellStyle(textStyle);
					}

//ROW70
//Column H: 
					Cell R0610cell7 = row.createCell(7);
					if (record.getR0610_8_14days() != null) {
						R0610cell7.setCellValue(record.getR0610_8_14days().doubleValue());
						R0610cell7.setCellStyle(numberStyle);
					} else {
						R0610cell7.setCellValue("");
						R0610cell7.setCellStyle(textStyle);
					}

//ROW70
//Column I: 
					Cell R0610cell8 = row.createCell(8);
					if (record.getR0610_15days_1months() != null) {
						R0610cell8.setCellValue(record.getR0610_15days_1months().doubleValue());
						R0610cell8.setCellStyle(numberStyle);
					} else {
						R0610cell8.setCellValue("");
						R0610cell8.setCellStyle(textStyle);
					}

//ROW70
//Column J: 
					Cell R0610cell9 = row.createCell(9);
					if (record.getR0610_1_2months() != null) {
						R0610cell9.setCellValue(record.getR0610_1_2months().doubleValue());
						R0610cell9.setCellStyle(numberStyle);
					} else {
						R0610cell9.setCellValue("");
						R0610cell9.setCellStyle(textStyle);
					}

//ROW70
//Column K: 
					Cell R0610cell10 = row.createCell(10);
					if (record.getR0610_2_3months() != null) {
						R0610cell10.setCellValue(record.getR0610_2_3months().doubleValue());
						R0610cell10.setCellStyle(numberStyle);
					} else {
						R0610cell10.setCellValue("");
						R0610cell10.setCellStyle(textStyle);
					}

//ROW70
//Column L: 
					Cell R0610cell11 = row.createCell(11);
					if (record.getR0610_3_6months() != null) {
						R0610cell11.setCellValue(record.getR0610_3_6months().doubleValue());
						R0610cell11.setCellStyle(numberStyle);
					} else {
						R0610cell11.setCellValue("");
						R0610cell11.setCellStyle(textStyle);
					}

//ROW70
//Column M: 
					Cell R0610cell12 = row.createCell(12);
					if (record.getR0610_6_12months() != null) {
						R0610cell12.setCellValue(record.getR0610_6_12months().doubleValue());
						R0610cell12.setCellStyle(numberStyle);
					} else {
						R0610cell12.setCellValue("");
						R0610cell12.setCellStyle(textStyle);
					}

//ROW70
//Column N: 
					Cell R0610cell13 = row.createCell(13);
					if (record.getR0610_1_3years() != null) {
						R0610cell13.setCellValue(record.getR0610_1_3years().doubleValue());
						R0610cell13.setCellStyle(numberStyle);
					} else {
						R0610cell13.setCellValue("");
						R0610cell13.setCellStyle(textStyle);
					}

//ROW70
//Column O: 
					Cell R0610cell14 = row.createCell(14);
					if (record.getR0610_3_5years() != null) {
						R0610cell14.setCellValue(record.getR0610_3_5years().doubleValue());
						R0610cell14.setCellStyle(numberStyle);
					} else {
						R0610cell14.setCellValue("");
						R0610cell14.setCellStyle(textStyle);
					}

//ROW70
//Column P: 
					Cell R0610cell15 = row.createCell(15);
					if (record.getR0610_5years() != null) {
						R0610cell15.setCellValue(record.getR0610_5years().doubleValue());
						R0610cell15.setCellStyle(numberStyle);
					} else {
						R0610cell15.setCellValue("");
						R0610cell15.setCellStyle(textStyle);
					}

/////ROW71///////////
//ROW71

					row = sheet.getRow(70);

//Column E: 
					Cell R0620cell4 = row.createCell(4);
					if (record.getR0620_overdue() != null) {
						R0620cell4.setCellValue(record.getR0620_overdue().doubleValue());
						R0620cell4.setCellStyle(numberStyle);
					} else {
						R0620cell4.setCellValue("");
						R0620cell4.setCellStyle(textStyle);
					}

//ROW71
//Column F: 
					Cell R0620cell5 = row.createCell(5);
					if (record.getR0620_overdraft() != null) {
						R0620cell5.setCellValue(record.getR0620_overdraft().doubleValue());
						R0620cell5.setCellStyle(numberStyle);
					} else {
						R0620cell5.setCellValue("");
						R0620cell5.setCellStyle(textStyle);
					}

//ROW71
//Column G: 
					Cell R0620cell6 = row.createCell(6);
					if (record.getR0620_0_7days() != null) {
						R0620cell6.setCellValue(record.getR0620_0_7days().doubleValue());
						R0620cell6.setCellStyle(numberStyle);
					} else {
						R0620cell6.setCellValue("");
						R0620cell6.setCellStyle(textStyle);
					}

//ROW71
//Column H: 
					Cell R0620cell7 = row.createCell(7);
					if (record.getR0620_8_14days() != null) {
						R0620cell7.setCellValue(record.getR0620_8_14days().doubleValue());
						R0620cell7.setCellStyle(numberStyle);
					} else {
						R0620cell7.setCellValue("");
						R0620cell7.setCellStyle(textStyle);
					}

//ROW71
//Column I: 
					Cell R0620cell8 = row.createCell(8);
					if (record.getR0620_15days_1months() != null) {
						R0620cell8.setCellValue(record.getR0620_15days_1months().doubleValue());
						R0620cell8.setCellStyle(numberStyle);
					} else {
						R0620cell8.setCellValue("");
						R0620cell8.setCellStyle(textStyle);
					}

//ROW71
//Column J: 
					Cell R0620cell9 = row.createCell(9);
					if (record.getR0620_1_2months() != null) {
						R0620cell9.setCellValue(record.getR0620_1_2months().doubleValue());
						R0620cell9.setCellStyle(numberStyle);
					} else {
						R0620cell9.setCellValue("");
						R0620cell9.setCellStyle(textStyle);
					}

//ROW71
//Column K: 
					Cell R0620cell10 = row.createCell(10);
					if (record.getR0620_2_3months() != null) {
						R0620cell10.setCellValue(record.getR0620_2_3months().doubleValue());
						R0620cell10.setCellStyle(numberStyle);
					} else {
						R0620cell10.setCellValue("");
						R0620cell10.setCellStyle(textStyle);
					}

//ROW71
//Column L: 
					Cell R0620cell11 = row.createCell(11);
					if (record.getR0620_3_6months() != null) {
						R0620cell11.setCellValue(record.getR0620_3_6months().doubleValue());
						R0620cell11.setCellStyle(numberStyle);
					} else {
						R0620cell11.setCellValue("");
						R0620cell11.setCellStyle(textStyle);
					}

//ROW71
//Column M: 
					Cell R0620cell12 = row.createCell(12);
					if (record.getR0620_6_12months() != null) {
						R0620cell12.setCellValue(record.getR0620_6_12months().doubleValue());
						R0620cell12.setCellStyle(numberStyle);
					} else {
						R0620cell12.setCellValue("");
						R0620cell12.setCellStyle(textStyle);
					}

//ROW71
//Column N: 
					Cell R0620cell13 = row.createCell(13);
					if (record.getR0620_1_3years() != null) {
						R0620cell13.setCellValue(record.getR0620_1_3years().doubleValue());
						R0620cell13.setCellStyle(numberStyle);
					} else {
						R0620cell13.setCellValue("");
						R0620cell13.setCellStyle(textStyle);
					}

//ROW71
//Column O: 
					Cell R0620cell14 = row.createCell(14);
					if (record.getR0620_3_5years() != null) {
						R0620cell14.setCellValue(record.getR0620_3_5years().doubleValue());
						R0620cell14.setCellStyle(numberStyle);
					} else {
						R0620cell14.setCellValue("");
						R0620cell14.setCellStyle(textStyle);
					}

//ROW71
//Column P: 
					Cell R0620cell15 = row.createCell(15);
					if (record.getR0620_5years() != null) {
						R0620cell15.setCellValue(record.getR0620_5years().doubleValue());
						R0620cell15.setCellStyle(numberStyle);
					} else {
						R0620cell15.setCellValue("");
						R0620cell15.setCellStyle(textStyle);
					}

/////ROW72///////////
//ROW72

					row = sheet.getRow(71);

//Column E: 
					Cell R0630cell4 = row.createCell(4);
					if (record.getR0630_overdue() != null) {
						R0630cell4.setCellValue(record.getR0630_overdue().doubleValue());
						R0630cell4.setCellStyle(numberStyle);
					} else {
						R0630cell4.setCellValue("");
						R0630cell4.setCellStyle(textStyle);
					}

//ROW72
//Column F: 
					Cell R0630cell5 = row.createCell(5);
					if (record.getR0630_overdraft() != null) {
						R0630cell5.setCellValue(record.getR0630_overdraft().doubleValue());
						R0630cell5.setCellStyle(numberStyle);
					} else {
						R0630cell5.setCellValue("");
						R0630cell5.setCellStyle(textStyle);
					}

//ROW72
//Column G: 
					Cell R0630cell6 = row.createCell(6);
					if (record.getR0630_0_7days() != null) {
						R0630cell6.setCellValue(record.getR0630_0_7days().doubleValue());
						R0630cell6.setCellStyle(numberStyle);
					} else {
						R0630cell6.setCellValue("");
						R0630cell6.setCellStyle(textStyle);
					}

//ROW72
//Column H: 
					Cell R0630cell7 = row.createCell(7);
					if (record.getR0630_8_14days() != null) {
						R0630cell7.setCellValue(record.getR0630_8_14days().doubleValue());
						R0630cell7.setCellStyle(numberStyle);
					} else {
						R0630cell7.setCellValue("");
						R0630cell7.setCellStyle(textStyle);
					}

//ROW72
//Column I: 
					Cell R0630cell8 = row.createCell(8);
					if (record.getR0630_15days_1months() != null) {
						R0630cell8.setCellValue(record.getR0630_15days_1months().doubleValue());
						R0630cell8.setCellStyle(numberStyle);
					} else {
						R0630cell8.setCellValue("");
						R0630cell8.setCellStyle(textStyle);
					}

//ROW72
//Column J: 
					Cell R0630cell9 = row.createCell(9);
					if (record.getR0630_1_2months() != null) {
						R0630cell9.setCellValue(record.getR0630_1_2months().doubleValue());
						R0630cell9.setCellStyle(numberStyle);
					} else {
						R0630cell9.setCellValue("");
						R0630cell9.setCellStyle(textStyle);
					}

//ROW72
//Column K: 
					Cell R0630cell10 = row.createCell(10);
					if (record.getR0630_2_3months() != null) {
						R0630cell10.setCellValue(record.getR0630_2_3months().doubleValue());
						R0630cell10.setCellStyle(numberStyle);
					} else {
						R0630cell10.setCellValue("");
						R0630cell10.setCellStyle(textStyle);
					}

//ROW72
//Column L: 
					Cell R0630cell11 = row.createCell(11);
					if (record.getR0630_3_6months() != null) {
						R0630cell11.setCellValue(record.getR0630_3_6months().doubleValue());
						R0630cell11.setCellStyle(numberStyle);
					} else {
						R0630cell11.setCellValue("");
						R0630cell11.setCellStyle(textStyle);
					}

//ROW72
//Column M: 
					Cell R0630cell12 = row.createCell(12);
					if (record.getR0630_6_12months() != null) {
						R0630cell12.setCellValue(record.getR0630_6_12months().doubleValue());
						R0630cell12.setCellStyle(numberStyle);
					} else {
						R0630cell12.setCellValue("");
						R0630cell12.setCellStyle(textStyle);
					}

//ROW72
//Column N: 
					Cell R0630cell13 = row.createCell(13);
					if (record.getR0630_1_3years() != null) {
						R0630cell13.setCellValue(record.getR0630_1_3years().doubleValue());
						R0630cell13.setCellStyle(numberStyle);
					} else {
						R0630cell13.setCellValue("");
						R0630cell13.setCellStyle(textStyle);
					}

//ROW72
//Column O: 
					Cell R0630cell14 = row.createCell(14);
					if (record.getR0630_3_5years() != null) {
						R0630cell14.setCellValue(record.getR0630_3_5years().doubleValue());
						R0630cell14.setCellStyle(numberStyle);
					} else {
						R0630cell14.setCellValue("");
						R0630cell14.setCellStyle(textStyle);
					}

//ROW72
//Column P: 
					Cell R0630cell15 = row.createCell(15);
					if (record.getR0630_5years() != null) {
						R0630cell15.setCellValue(record.getR0630_5years().doubleValue());
						R0630cell15.setCellStyle(numberStyle);
					} else {
						R0630cell15.setCellValue("");
						R0630cell15.setCellStyle(textStyle);
					}

/////ROW73///////////
//ROW73

					row = sheet.getRow(72);

//Column E: 
					Cell R0640cell4 = row.createCell(4);
					if (record.getR0640_overdue() != null) {
						R0640cell4.setCellValue(record.getR0640_overdue().doubleValue());
						R0640cell4.setCellStyle(numberStyle);
					} else {
						R0640cell4.setCellValue("");
						R0640cell4.setCellStyle(textStyle);
					}

//ROW73
//Column F: 
					Cell R0640cell5 = row.createCell(5);
					if (record.getR0640_overdraft() != null) {
						R0640cell5.setCellValue(record.getR0640_overdraft().doubleValue());
						R0640cell5.setCellStyle(numberStyle);
					} else {
						R0640cell5.setCellValue("");
						R0640cell5.setCellStyle(textStyle);
					}

//ROW73
//Column G: 
					Cell R0640cell6 = row.createCell(6);
					if (record.getR0640_0_7days() != null) {
						R0640cell6.setCellValue(record.getR0640_0_7days().doubleValue());
						R0640cell6.setCellStyle(numberStyle);
					} else {
						R0640cell6.setCellValue("");
						R0640cell6.setCellStyle(textStyle);
					}

//ROW73
//Column H: 
					Cell R0640cell7 = row.createCell(7);
					if (record.getR0640_8_14days() != null) {
						R0640cell7.setCellValue(record.getR0640_8_14days().doubleValue());
						R0640cell7.setCellStyle(numberStyle);
					} else {
						R0640cell7.setCellValue("");
						R0640cell7.setCellStyle(textStyle);
					}

//ROW73
//Column I: 
					Cell R0640cell8 = row.createCell(8);
					if (record.getR0640_15days_1months() != null) {
						R0640cell8.setCellValue(record.getR0640_15days_1months().doubleValue());
						R0640cell8.setCellStyle(numberStyle);
					} else {
						R0640cell8.setCellValue("");
						R0640cell8.setCellStyle(textStyle);
					}

//ROW73
//Column J: 
					Cell R0640cell9 = row.createCell(9);
					if (record.getR0640_1_2months() != null) {
						R0640cell9.setCellValue(record.getR0640_1_2months().doubleValue());
						R0640cell9.setCellStyle(numberStyle);
					} else {
						R0640cell9.setCellValue("");
						R0640cell9.setCellStyle(textStyle);
					}

//ROW73
//Column K: 
					Cell R0640cell10 = row.createCell(10);
					if (record.getR0640_2_3months() != null) {
						R0640cell10.setCellValue(record.getR0640_2_3months().doubleValue());
						R0640cell10.setCellStyle(numberStyle);
					} else {
						R0640cell10.setCellValue("");
						R0640cell10.setCellStyle(textStyle);
					}

//ROW73
//Column L: 
					Cell R0640cell11 = row.createCell(11);
					if (record.getR0640_3_6months() != null) {
						R0640cell11.setCellValue(record.getR0640_3_6months().doubleValue());
						R0640cell11.setCellStyle(numberStyle);
					} else {
						R0640cell11.setCellValue("");
						R0640cell11.setCellStyle(textStyle);
					}

//ROW73
//Column M: 
					Cell R0640cell12 = row.createCell(12);
					if (record.getR0640_6_12months() != null) {
						R0640cell12.setCellValue(record.getR0640_6_12months().doubleValue());
						R0640cell12.setCellStyle(numberStyle);
					} else {
						R0640cell12.setCellValue("");
						R0640cell12.setCellStyle(textStyle);
					}

//ROW73
//Column N: 
					Cell R0640cell13 = row.createCell(13);
					if (record.getR0640_1_3years() != null) {
						R0640cell13.setCellValue(record.getR0640_1_3years().doubleValue());
						R0640cell13.setCellStyle(numberStyle);
					} else {
						R0640cell13.setCellValue("");
						R0640cell13.setCellStyle(textStyle);
					}

//ROW73
//Column O: 
					Cell R0640cell14 = row.createCell(14);
					if (record.getR0640_3_5years() != null) {
						R0640cell14.setCellValue(record.getR0640_3_5years().doubleValue());
						R0640cell14.setCellStyle(numberStyle);
					} else {
						R0640cell14.setCellValue("");
						R0640cell14.setCellStyle(textStyle);
					}

//ROW73
//Column P: 
					Cell R0640cell15 = row.createCell(15);
					if (record.getR0640_5years() != null) {
						R0640cell15.setCellValue(record.getR0640_5years().doubleValue());
						R0640cell15.setCellStyle(numberStyle);
					} else {
						R0640cell15.setCellValue("");
						R0640cell15.setCellStyle(textStyle);
					}

				}

				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {

			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}

	public byte[] getBRF2_3ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Archival Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		List<CBUAE_BRF2_3_Archival_Summary_Entity> dataList = BRF2_3_Archival_Summary_Repo
				.getdatabydateListarchival(dateformat.parse(todate), version);

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.3 report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		String templateFileName = filename;
		System.out.println(filename);
		Path templatePath = Paths.get(templateDir, templateFileName);
		System.out.println(templatePath);

		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			// This specific exception will be caught by the controller.
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			// A specific exception for permission errors.
			throw new SecurityException(
					"Template file exists but is not readable (check permissions): " + templatePath.toAbsolutePath());
		}

		// This try-with-resources block is perfect. It guarantees all resources are
		// closed automatically.
		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(0);

			// --- Style Definitions ---
			CreationHelper createHelper = workbook.getCreationHelper();

			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
			dateStyle.setBorderBottom(BorderStyle.THIN);
			dateStyle.setBorderTop(BorderStyle.THIN);
			dateStyle.setBorderLeft(BorderStyle.THIN);
			dateStyle.setBorderRight(BorderStyle.THIN);

			CellStyle textStyle = workbook.createCellStyle();
			textStyle.setBorderBottom(BorderStyle.THIN);
			textStyle.setBorderTop(BorderStyle.THIN);
			textStyle.setBorderLeft(BorderStyle.THIN);
			textStyle.setBorderRight(BorderStyle.THIN);

			// Create the font
			Font font = workbook.createFont();
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 11;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {

					CBUAE_BRF2_3_Archival_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

/////ROW12///////////
//row12
// Column E: 
					Cell R0030cell4 = row.createCell(4);
					if (record.getR0030_overdue() != null) {
						R0030cell4.setCellValue(record.getR0030_overdue().doubleValue());
						R0030cell4.setCellStyle(numberStyle);
					} else {
						R0030cell4.setCellValue("");
						R0030cell4.setCellStyle(textStyle);
					}

//row12
//Column F: 
					Cell R0030cell5 = row.createCell(5);
					if (record.getR0030_overdraft() != null) {
						R0030cell5.setCellValue(record.getR0030_overdraft().doubleValue());
						R0030cell5.setCellStyle(numberStyle);
					} else {
						R0030cell5.setCellValue("");
						R0030cell5.setCellStyle(textStyle);
					}

//row12
//Column G: 
					Cell R0030cell6 = row.createCell(6);
					if (record.getR0030_0_7days() != null) {
						R0030cell6.setCellValue(record.getR0030_0_7days().doubleValue());
						R0030cell6.setCellStyle(numberStyle);
					} else {
						R0030cell6.setCellValue("");
						R0030cell6.setCellStyle(textStyle);
					}

//row12
//Column H: 
					Cell R0030cell7 = row.createCell(7);
					if (record.getR0030_8_14days() != null) {
						R0030cell7.setCellValue(record.getR0030_8_14days().doubleValue());
						R0030cell7.setCellStyle(numberStyle);
					} else {
						R0030cell7.setCellValue("");
						R0030cell7.setCellStyle(textStyle);
					}

//row12
//Column I: 
					Cell R0030cell8 = row.createCell(8);
					if (record.getR0030_15days_1months() != null) {
						R0030cell8.setCellValue(record.getR0030_15days_1months().doubleValue());
						R0030cell8.setCellStyle(numberStyle);
					} else {
						R0030cell8.setCellValue("");
						R0030cell8.setCellStyle(textStyle);
					}

//row12
//Column J: 
					Cell R0030cell9 = row.createCell(9);
					if (record.getR0030_1_2months() != null) {
						R0030cell9.setCellValue(record.getR0030_1_2months().doubleValue());
						R0030cell9.setCellStyle(numberStyle);
					} else {
						R0030cell9.setCellValue("");
						R0030cell9.setCellStyle(textStyle);
					}

//row12
//Column K: 
					Cell R0030cell10 = row.createCell(10);
					if (record.getR0030_2_3months() != null) {
						R0030cell10.setCellValue(record.getR0030_2_3months().doubleValue());
						R0030cell10.setCellStyle(numberStyle);
					} else {
						R0030cell10.setCellValue("");
						R0030cell10.setCellStyle(textStyle);
					}

//row12
//Column L: 
					Cell R0030cell11 = row.createCell(11);
					if (record.getR0030_3_6months() != null) {
						R0030cell11.setCellValue(record.getR0030_3_6months().doubleValue());
						R0030cell11.setCellStyle(numberStyle);
					} else {
						R0030cell11.setCellValue("");
						R0030cell11.setCellStyle(textStyle);
					}

//row12
//Column M: 
					Cell R0030cell12 = row.createCell(12);
					if (record.getR0030_6_12months() != null) {
						R0030cell12.setCellValue(record.getR0030_6_12months().doubleValue());
						R0030cell12.setCellStyle(numberStyle);
					} else {
						R0030cell12.setCellValue("");
						R0030cell12.setCellStyle(textStyle);
					}

//row12
//Column N: 
					Cell R0030cell13 = row.createCell(13);
					if (record.getR0030_1_3years() != null) {
						R0030cell13.setCellValue(record.getR0030_1_3years().doubleValue());
						R0030cell13.setCellStyle(numberStyle);
					} else {
						R0030cell13.setCellValue("");
						R0030cell13.setCellStyle(textStyle);
					}

//row12
//Column O: 
					Cell R0030cell14 = row.createCell(14);
					if (record.getR0030_3_5years() != null) {
						R0030cell14.setCellValue(record.getR0030_3_5years().doubleValue());
						R0030cell14.setCellStyle(numberStyle);
					} else {
						R0030cell14.setCellValue("");
						R0030cell14.setCellStyle(textStyle);
					}

//row12
//Column P: 
					Cell R0030cell15 = row.createCell(15);
					if (record.getR0030_5years() != null) {
						R0030cell15.setCellValue(record.getR0030_5years().doubleValue());
						R0030cell15.setCellStyle(numberStyle);
					} else {
						R0030cell15.setCellValue("");
						R0030cell15.setCellStyle(textStyle);
					}

/////ROW13///////////
//ROW13

					row = sheet.getRow(12);

//Column E: 
					Cell R0040cell4 = row.createCell(4);
					if (record.getR0040_overdue() != null) {
						R0040cell4.setCellValue(record.getR0040_overdue().doubleValue());
						R0040cell4.setCellStyle(numberStyle);
					} else {
						R0040cell4.setCellValue("");
						R0040cell4.setCellStyle(textStyle);
					}

//ROW13
//Column F: 
					Cell R0040cell5 = row.createCell(5);
					if (record.getR0040_overdraft() != null) {
						R0040cell5.setCellValue(record.getR0040_overdraft().doubleValue());
						R0040cell5.setCellStyle(numberStyle);
					} else {
						R0040cell5.setCellValue("");
						R0040cell5.setCellStyle(textStyle);
					}

//ROW13
//Column G: 
					Cell R0040cell6 = row.createCell(6);
					if (record.getR0040_0_7days() != null) {
						R0040cell6.setCellValue(record.getR0040_0_7days().doubleValue());
						R0040cell6.setCellStyle(numberStyle);
					} else {
						R0040cell6.setCellValue("");
						R0040cell6.setCellStyle(textStyle);
					}

//ROW13
//Column H: 
					Cell R0040cell7 = row.createCell(7);
					if (record.getR0040_8_14days() != null) {
						R0040cell7.setCellValue(record.getR0040_8_14days().doubleValue());
						R0040cell7.setCellStyle(numberStyle);
					} else {
						R0040cell7.setCellValue("");
						R0040cell7.setCellStyle(textStyle);
					}

//ROW13
//Column I: 
					Cell R0040cell8 = row.createCell(8);
					if (record.getR0040_15days_1months() != null) {
						R0040cell8.setCellValue(record.getR0040_15days_1months().doubleValue());
						R0040cell8.setCellStyle(numberStyle);
					} else {
						R0040cell8.setCellValue("");
						R0040cell8.setCellStyle(textStyle);
					}

//ROW13
//Column J: 
					Cell R0040cell9 = row.createCell(9);
					if (record.getR0040_1_2months() != null) {
						R0040cell9.setCellValue(record.getR0040_1_2months().doubleValue());
						R0040cell9.setCellStyle(numberStyle);
					} else {
						R0040cell9.setCellValue("");
						R0040cell9.setCellStyle(textStyle);
					}

//ROW13
//Column K: 
					Cell R0040cell10 = row.createCell(10);
					if (record.getR0040_2_3months() != null) {
						R0040cell10.setCellValue(record.getR0040_2_3months().doubleValue());
						R0040cell10.setCellStyle(numberStyle);
					} else {
						R0040cell10.setCellValue("");
						R0040cell10.setCellStyle(textStyle);
					}

//ROW13
//Column L: 
					Cell R0040cell11 = row.createCell(11);
					if (record.getR0040_3_6months() != null) {
						R0040cell11.setCellValue(record.getR0040_3_6months().doubleValue());
						R0040cell11.setCellStyle(numberStyle);
					} else {
						R0040cell11.setCellValue("");
						R0040cell11.setCellStyle(textStyle);
					}

//ROW13
//Column M: 
					Cell R0040cell12 = row.createCell(12);
					if (record.getR0040_6_12months() != null) {
						R0040cell12.setCellValue(record.getR0040_6_12months().doubleValue());
						R0040cell12.setCellStyle(numberStyle);
					} else {
						R0040cell12.setCellValue("");
						R0040cell12.setCellStyle(textStyle);
					}

//ROW13
//Column N: 
					Cell R0040cell13 = row.createCell(13);
					if (record.getR0040_1_3years() != null) {
						R0040cell13.setCellValue(record.getR0040_1_3years().doubleValue());
						R0040cell13.setCellStyle(numberStyle);
					} else {
						R0040cell13.setCellValue("");
						R0040cell13.setCellStyle(textStyle);
					}

//ROW13
//Column O: 
					Cell R0040cell14 = row.createCell(14);
					if (record.getR0040_3_5years() != null) {
						R0040cell14.setCellValue(record.getR0040_3_5years().doubleValue());
						R0040cell14.setCellStyle(numberStyle);
					} else {
						R0040cell14.setCellValue("");
						R0040cell14.setCellStyle(textStyle);
					}

//ROW13
//Column P: 
					Cell R0040cell15 = row.createCell(15);
					if (record.getR0040_5years() != null) {
						R0040cell15.setCellValue(record.getR0040_5years().doubleValue());
						R0040cell15.setCellStyle(numberStyle);
					} else {
						R0040cell15.setCellValue("");
						R0040cell15.setCellStyle(textStyle);
					}

/////ROW14///////////
//ROW14

					row = sheet.getRow(13);

//Column E: 
					Cell R0050cell4 = row.createCell(4);
					if (record.getR0050_overdue() != null) {
						R0050cell4.setCellValue(record.getR0050_overdue().doubleValue());
						R0050cell4.setCellStyle(numberStyle);
					} else {
						R0050cell4.setCellValue("");
						R0050cell4.setCellStyle(textStyle);
					}

//ROW14
//Column F: 
					Cell R0050cell5 = row.createCell(5);
					if (record.getR0050_overdraft() != null) {
						R0050cell5.setCellValue(record.getR0050_overdraft().doubleValue());
						R0050cell5.setCellStyle(numberStyle);
					} else {
						R0050cell5.setCellValue("");
						R0050cell5.setCellStyle(textStyle);
					}

//ROW14
//Column G: 
					Cell R0050cell6 = row.createCell(6);
					if (record.getR0050_0_7days() != null) {
						R0050cell6.setCellValue(record.getR0050_0_7days().doubleValue());
						R0050cell6.setCellStyle(numberStyle);
					} else {
						R0050cell6.setCellValue("");
						R0050cell6.setCellStyle(textStyle);
					}

//ROW14
//Column H: 
					Cell R0050cell7 = row.createCell(7);
					if (record.getR0050_8_14days() != null) {
						R0050cell7.setCellValue(record.getR0050_8_14days().doubleValue());
						R0050cell7.setCellStyle(numberStyle);
					} else {
						R0050cell7.setCellValue("");
						R0050cell7.setCellStyle(textStyle);
					}

//ROW14
//Column I: 
					Cell R0050cell8 = row.createCell(8);
					if (record.getR0050_15days_1months() != null) {
						R0050cell8.setCellValue(record.getR0050_15days_1months().doubleValue());
						R0050cell8.setCellStyle(numberStyle);
					} else {
						R0050cell8.setCellValue("");
						R0050cell8.setCellStyle(textStyle);
					}

//ROW14
//Column J: 
					Cell R0050cell9 = row.createCell(9);
					if (record.getR0050_1_2months() != null) {
						R0050cell9.setCellValue(record.getR0050_1_2months().doubleValue());
						R0050cell9.setCellStyle(numberStyle);
					} else {
						R0050cell9.setCellValue("");
						R0050cell9.setCellStyle(textStyle);
					}

//ROW14
//Column K: 
					Cell R0050cell10 = row.createCell(10);
					if (record.getR0050_2_3months() != null) {
						R0050cell10.setCellValue(record.getR0050_2_3months().doubleValue());
						R0050cell10.setCellStyle(numberStyle);
					} else {
						R0050cell10.setCellValue("");
						R0050cell10.setCellStyle(textStyle);
					}

//ROW14
//Column L: 
					Cell R0050cell11 = row.createCell(11);
					if (record.getR0050_3_6months() != null) {
						R0050cell11.setCellValue(record.getR0050_3_6months().doubleValue());
						R0050cell11.setCellStyle(numberStyle);
					} else {
						R0050cell11.setCellValue("");
						R0050cell11.setCellStyle(textStyle);
					}

//ROW14
//Column M: 
					Cell R0050cell12 = row.createCell(12);
					if (record.getR0050_6_12months() != null) {
						R0050cell12.setCellValue(record.getR0050_6_12months().doubleValue());
						R0050cell12.setCellStyle(numberStyle);
					} else {
						R0050cell12.setCellValue("");
						R0050cell12.setCellStyle(textStyle);
					}

//ROW14
//Column N: 
					Cell R0050cell13 = row.createCell(13);
					if (record.getR0050_1_3years() != null) {
						R0050cell13.setCellValue(record.getR0050_1_3years().doubleValue());
						R0050cell13.setCellStyle(numberStyle);
					} else {
						R0050cell13.setCellValue("");
						R0050cell13.setCellStyle(textStyle);
					}

//ROW14
//Column O: 
					Cell R0050cell14 = row.createCell(14);
					if (record.getR0050_3_5years() != null) {
						R0050cell14.setCellValue(record.getR0050_3_5years().doubleValue());
						R0050cell14.setCellStyle(numberStyle);
					} else {
						R0050cell14.setCellValue("");
						R0050cell14.setCellStyle(textStyle);
					}

//ROW14
//Column P: 
					Cell R0050cell15 = row.createCell(15);
					if (record.getR0050_5years() != null) {
						R0050cell15.setCellValue(record.getR0050_5years().doubleValue());
						R0050cell15.setCellStyle(numberStyle);
					} else {
						R0050cell15.setCellValue("");
						R0050cell15.setCellStyle(textStyle);
					}

/////ROW16///////////
//ROW16

					row = sheet.getRow(15);

//Column E: 
					Cell R0070cell4 = row.createCell(4);
					if (record.getR0070_overdue() != null) {
						R0070cell4.setCellValue(record.getR0070_overdue().doubleValue());
						R0070cell4.setCellStyle(numberStyle);
					} else {
						R0070cell4.setCellValue("");
						R0070cell4.setCellStyle(textStyle);
					}

//ROW16
//Column F: 
					Cell R0070cell5 = row.createCell(5);
					if (record.getR0070_overdraft() != null) {
						R0070cell5.setCellValue(record.getR0070_overdraft().doubleValue());
						R0070cell5.setCellStyle(numberStyle);
					} else {
						R0070cell5.setCellValue("");
						R0070cell5.setCellStyle(textStyle);
					}

//ROW16
//Column G: 
					Cell R0070cell6 = row.createCell(6);
					if (record.getR0070_0_7days() != null) {
						R0070cell6.setCellValue(record.getR0070_0_7days().doubleValue());
						R0070cell6.setCellStyle(numberStyle);
					} else {
						R0070cell6.setCellValue("");
						R0070cell6.setCellStyle(textStyle);
					}

//ROW16
//Column H: 
					Cell R0070cell7 = row.createCell(7);
					if (record.getR0070_8_14days() != null) {
						R0070cell7.setCellValue(record.getR0070_8_14days().doubleValue());
						R0070cell7.setCellStyle(numberStyle);
					} else {
						R0070cell7.setCellValue("");
						R0070cell7.setCellStyle(textStyle);
					}

//ROW16
//Column I: 
					Cell R0070cell8 = row.createCell(8);
					if (record.getR0070_15days_1months() != null) {
						R0070cell8.setCellValue(record.getR0070_15days_1months().doubleValue());
						R0070cell8.setCellStyle(numberStyle);
					} else {
						R0070cell8.setCellValue("");
						R0070cell8.setCellStyle(textStyle);
					}

//ROW16
//Column J: 
					Cell R0070cell9 = row.createCell(9);
					if (record.getR0070_1_2months() != null) {
						R0070cell9.setCellValue(record.getR0070_1_2months().doubleValue());
						R0070cell9.setCellStyle(numberStyle);
					} else {
						R0070cell9.setCellValue("");
						R0070cell9.setCellStyle(textStyle);
					}

//ROW16
//Column K: 
					Cell R0070cell10 = row.createCell(10);
					if (record.getR0070_2_3months() != null) {
						R0070cell10.setCellValue(record.getR0070_2_3months().doubleValue());
						R0070cell10.setCellStyle(numberStyle);
					} else {
						R0070cell10.setCellValue("");
						R0070cell10.setCellStyle(textStyle);
					}

//ROW16
//Column L: 
					Cell R0070cell11 = row.createCell(11);
					if (record.getR0070_3_6months() != null) {
						R0070cell11.setCellValue(record.getR0070_3_6months().doubleValue());
						R0070cell11.setCellStyle(numberStyle);
					} else {
						R0070cell11.setCellValue("");
						R0070cell11.setCellStyle(textStyle);
					}

//ROW16
//Column M: 
					Cell R0070cell12 = row.createCell(12);
					if (record.getR0070_6_12months() != null) {
						R0070cell12.setCellValue(record.getR0070_6_12months().doubleValue());
						R0070cell12.setCellStyle(numberStyle);
					} else {
						R0070cell12.setCellValue("");
						R0070cell12.setCellStyle(textStyle);
					}

//ROW16
//Column N: 
					Cell R0070cell13 = row.createCell(13);
					if (record.getR0070_1_3years() != null) {
						R0070cell13.setCellValue(record.getR0070_1_3years().doubleValue());
						R0070cell13.setCellStyle(numberStyle);
					} else {
						R0070cell13.setCellValue("");
						R0070cell13.setCellStyle(textStyle);
					}

//ROW16
//Column O: 
					Cell R0070cell14 = row.createCell(14);
					if (record.getR0070_3_5years() != null) {
						R0070cell14.setCellValue(record.getR0070_3_5years().doubleValue());
						R0070cell14.setCellStyle(numberStyle);
					} else {
						R0070cell14.setCellValue("");
						R0070cell14.setCellStyle(textStyle);
					}

//ROW16
//Column P: 
					Cell R0070cell15 = row.createCell(15);
					if (record.getR0070_5years() != null) {
						R0070cell15.setCellValue(record.getR0070_5years().doubleValue());
						R0070cell15.setCellStyle(numberStyle);
					} else {
						R0070cell15.setCellValue("");
						R0070cell15.setCellStyle(textStyle);
					}

/////ROW17///////////
//ROW17

					row = sheet.getRow(16);

//Column E: 
					Cell R0080cell4 = row.createCell(4);
					if (record.getR0080_overdue() != null) {
						R0080cell4.setCellValue(record.getR0080_overdue().doubleValue());
						R0080cell4.setCellStyle(numberStyle);
					} else {
						R0080cell4.setCellValue("");
						R0080cell4.setCellStyle(textStyle);
					}

//ROW17
//Column F: 
					Cell R0080cell5 = row.createCell(5);
					if (record.getR0080_overdraft() != null) {
						R0080cell5.setCellValue(record.getR0080_overdraft().doubleValue());
						R0080cell5.setCellStyle(numberStyle);
					} else {
						R0080cell5.setCellValue("");
						R0080cell5.setCellStyle(textStyle);
					}

//ROW17
//Column G: 
					Cell R0080cell6 = row.createCell(6);
					if (record.getR0080_0_7days() != null) {
						R0080cell6.setCellValue(record.getR0080_0_7days().doubleValue());
						R0080cell6.setCellStyle(numberStyle);
					} else {
						R0080cell6.setCellValue("");
						R0080cell6.setCellStyle(textStyle);
					}

//ROW17
//Column H: 
					Cell R0080cell7 = row.createCell(7);
					if (record.getR0080_8_14days() != null) {
						R0080cell7.setCellValue(record.getR0080_8_14days().doubleValue());
						R0080cell7.setCellStyle(numberStyle);
					} else {
						R0080cell7.setCellValue("");
						R0080cell7.setCellStyle(textStyle);
					}

//ROW17
//Column I: 
					Cell R0080cell8 = row.createCell(8);
					if (record.getR0080_15days_1months() != null) {
						R0080cell8.setCellValue(record.getR0080_15days_1months().doubleValue());
						R0080cell8.setCellStyle(numberStyle);
					} else {
						R0080cell8.setCellValue("");
						R0080cell8.setCellStyle(textStyle);
					}

//ROW17
//Column J: 
					Cell R0080cell9 = row.createCell(9);
					if (record.getR0080_1_2months() != null) {
						R0080cell9.setCellValue(record.getR0080_1_2months().doubleValue());
						R0080cell9.setCellStyle(numberStyle);
					} else {
						R0080cell9.setCellValue("");
						R0080cell9.setCellStyle(textStyle);
					}

//ROW17
//Column K: 
					Cell R0080cell10 = row.createCell(10);
					if (record.getR0080_2_3months() != null) {
						R0080cell10.setCellValue(record.getR0080_2_3months().doubleValue());
						R0080cell10.setCellStyle(numberStyle);
					} else {
						R0080cell10.setCellValue("");
						R0080cell10.setCellStyle(textStyle);
					}

//ROW17
//Column L: 
					Cell R0080cell11 = row.createCell(11);
					if (record.getR0080_3_6months() != null) {
						R0080cell11.setCellValue(record.getR0080_3_6months().doubleValue());
						R0080cell11.setCellStyle(numberStyle);
					} else {
						R0080cell11.setCellValue("");
						R0080cell11.setCellStyle(textStyle);
					}

//ROW17
//Column M: 
					Cell R0080cell12 = row.createCell(12);
					if (record.getR0080_6_12months() != null) {
						R0080cell12.setCellValue(record.getR0080_6_12months().doubleValue());
						R0080cell12.setCellStyle(numberStyle);
					} else {
						R0080cell12.setCellValue("");
						R0080cell12.setCellStyle(textStyle);
					}

//ROW17
//Column N: 
					Cell R0080cell13 = row.createCell(13);
					if (record.getR0080_1_3years() != null) {
						R0080cell13.setCellValue(record.getR0080_1_3years().doubleValue());
						R0080cell13.setCellStyle(numberStyle);
					} else {
						R0080cell13.setCellValue("");
						R0080cell13.setCellStyle(textStyle);
					}

//ROW17
//Column O: 
					Cell R0080cell14 = row.createCell(14);
					if (record.getR0080_3_5years() != null) {
						R0080cell14.setCellValue(record.getR0080_3_5years().doubleValue());
						R0080cell14.setCellStyle(numberStyle);
					} else {
						R0080cell14.setCellValue("");
						R0080cell14.setCellStyle(textStyle);
					}

//ROW17
//Column P: 
					Cell R0080cell15 = row.createCell(15);
					if (record.getR0080_5years() != null) {
						R0080cell15.setCellValue(record.getR0080_5years().doubleValue());
						R0080cell15.setCellStyle(numberStyle);
					} else {
						R0080cell15.setCellValue("");
						R0080cell15.setCellStyle(textStyle);
					}

/////ROW18///////////
//ROW18

					row = sheet.getRow(17);

//Column E: 
					Cell R0090cell4 = row.createCell(4);
					if (record.getR0090_overdue() != null) {
						R0090cell4.setCellValue(record.getR0090_overdue().doubleValue());
						R0090cell4.setCellStyle(numberStyle);
					} else {
						R0090cell4.setCellValue("");
						R0090cell4.setCellStyle(textStyle);
					}

//ROW18
//Column F: 
					Cell R0090cell5 = row.createCell(5);
					if (record.getR0090_overdraft() != null) {
						R0090cell5.setCellValue(record.getR0090_overdraft().doubleValue());
						R0090cell5.setCellStyle(numberStyle);
					} else {
						R0090cell5.setCellValue("");
						R0090cell5.setCellStyle(textStyle);
					}

//ROW18
//Column G: 
					Cell R0090cell6 = row.createCell(6);
					if (record.getR0090_0_7days() != null) {
						R0090cell6.setCellValue(record.getR0090_0_7days().doubleValue());
						R0090cell6.setCellStyle(numberStyle);
					} else {
						R0090cell6.setCellValue("");
						R0090cell6.setCellStyle(textStyle);
					}

//ROW18
//Column H: 
					Cell R0090cell7 = row.createCell(7);
					if (record.getR0090_8_14days() != null) {
						R0090cell7.setCellValue(record.getR0090_8_14days().doubleValue());
						R0090cell7.setCellStyle(numberStyle);
					} else {
						R0090cell7.setCellValue("");
						R0090cell7.setCellStyle(textStyle);
					}

//ROW18
//Column I: 
					Cell R0090cell8 = row.createCell(8);
					if (record.getR0090_15days_1months() != null) {
						R0090cell8.setCellValue(record.getR0090_15days_1months().doubleValue());
						R0090cell8.setCellStyle(numberStyle);
					} else {
						R0090cell8.setCellValue("");
						R0090cell8.setCellStyle(textStyle);
					}

//ROW18
//Column J: 
					Cell R0090cell9 = row.createCell(9);
					if (record.getR0090_1_2months() != null) {
						R0090cell9.setCellValue(record.getR0090_1_2months().doubleValue());
						R0090cell9.setCellStyle(numberStyle);
					} else {
						R0090cell9.setCellValue("");
						R0090cell9.setCellStyle(textStyle);
					}

//ROW18
//Column K: 
					Cell R0090cell10 = row.createCell(10);
					if (record.getR0090_2_3months() != null) {
						R0090cell10.setCellValue(record.getR0090_2_3months().doubleValue());
						R0090cell10.setCellStyle(numberStyle);
					} else {
						R0090cell10.setCellValue("");
						R0090cell10.setCellStyle(textStyle);
					}

//ROW18
//Column L: 
					Cell R0090cell11 = row.createCell(11);
					if (record.getR0090_3_6months() != null) {
						R0090cell11.setCellValue(record.getR0090_3_6months().doubleValue());
						R0090cell11.setCellStyle(numberStyle);
					} else {
						R0090cell11.setCellValue("");
						R0090cell11.setCellStyle(textStyle);
					}

//ROW18
//Column M: 
					Cell R0090cell12 = row.createCell(12);
					if (record.getR0090_6_12months() != null) {
						R0090cell12.setCellValue(record.getR0090_6_12months().doubleValue());
						R0090cell12.setCellStyle(numberStyle);
					} else {
						R0090cell12.setCellValue("");
						R0090cell12.setCellStyle(textStyle);
					}

//ROW18
//Column N: 
					Cell R0090cell13 = row.createCell(13);
					if (record.getR0090_1_3years() != null) {
						R0090cell13.setCellValue(record.getR0090_1_3years().doubleValue());
						R0090cell13.setCellStyle(numberStyle);
					} else {
						R0090cell13.setCellValue("");
						R0090cell13.setCellStyle(textStyle);
					}

//ROW18
//Column O: 
					Cell R0090cell14 = row.createCell(14);
					if (record.getR0090_3_5years() != null) {
						R0090cell14.setCellValue(record.getR0090_3_5years().doubleValue());
						R0090cell14.setCellStyle(numberStyle);
					} else {
						R0090cell14.setCellValue("");
						R0090cell14.setCellStyle(textStyle);
					}

//ROW18
//Column P: 
					Cell R0090cell15 = row.createCell(15);
					if (record.getR0090_5years() != null) {
						R0090cell15.setCellValue(record.getR0090_5years().doubleValue());
						R0090cell15.setCellStyle(numberStyle);
					} else {
						R0090cell15.setCellValue("");
						R0090cell15.setCellStyle(textStyle);
					}

/////ROW20///////////
//ROW20

					row = sheet.getRow(19);

//Column E: 
					Cell R0110cell4 = row.createCell(4);
					if (record.getR0110_overdue() != null) {
						R0110cell4.setCellValue(record.getR0110_overdue().doubleValue());
						R0110cell4.setCellStyle(numberStyle);
					} else {
						R0110cell4.setCellValue("");
						R0110cell4.setCellStyle(textStyle);
					}

//ROW20
//Column F: 
					Cell R0110cell5 = row.createCell(5);
					if (record.getR0110_overdraft() != null) {
						R0110cell5.setCellValue(record.getR0110_overdraft().doubleValue());
						R0110cell5.setCellStyle(numberStyle);
					} else {
						R0110cell5.setCellValue("");
						R0110cell5.setCellStyle(textStyle);
					}

//ROW20
//Column G: 
					Cell R0110cell6 = row.createCell(6);
					if (record.getR0110_0_7days() != null) {
						R0110cell6.setCellValue(record.getR0110_0_7days().doubleValue());
						R0110cell6.setCellStyle(numberStyle);
					} else {
						R0110cell6.setCellValue("");
						R0110cell6.setCellStyle(textStyle);
					}

//ROW20
//Column H: 
					Cell R0110cell7 = row.createCell(7);
					if (record.getR0110_8_14days() != null) {
						R0110cell7.setCellValue(record.getR0110_8_14days().doubleValue());
						R0110cell7.setCellStyle(numberStyle);
					} else {
						R0110cell7.setCellValue("");
						R0110cell7.setCellStyle(textStyle);
					}

//ROW20
//Column I: 
					Cell R0110cell8 = row.createCell(8);
					if (record.getR0110_15days_1months() != null) {
						R0110cell8.setCellValue(record.getR0110_15days_1months().doubleValue());
						R0110cell8.setCellStyle(numberStyle);
					} else {
						R0110cell8.setCellValue("");
						R0110cell8.setCellStyle(textStyle);
					}

//ROW20
//Column J: 
					Cell R0110cell9 = row.createCell(9);
					if (record.getR0110_1_2months() != null) {
						R0110cell9.setCellValue(record.getR0110_1_2months().doubleValue());
						R0110cell9.setCellStyle(numberStyle);
					} else {
						R0110cell9.setCellValue("");
						R0110cell9.setCellStyle(textStyle);
					}

//ROW20
//Column K: 
					Cell R0110cell10 = row.createCell(10);
					if (record.getR0110_2_3months() != null) {
						R0110cell10.setCellValue(record.getR0110_2_3months().doubleValue());
						R0110cell10.setCellStyle(numberStyle);
					} else {
						R0110cell10.setCellValue("");
						R0110cell10.setCellStyle(textStyle);
					}

//ROW20
//Column L: 
					Cell R0110cell11 = row.createCell(11);
					if (record.getR0110_3_6months() != null) {
						R0110cell11.setCellValue(record.getR0110_3_6months().doubleValue());
						R0110cell11.setCellStyle(numberStyle);
					} else {
						R0110cell11.setCellValue("");
						R0110cell11.setCellStyle(textStyle);
					}

//ROW20
//Column M: 
					Cell R0110cell12 = row.createCell(12);
					if (record.getR0110_6_12months() != null) {
						R0110cell12.setCellValue(record.getR0110_6_12months().doubleValue());
						R0110cell12.setCellStyle(numberStyle);
					} else {
						R0110cell12.setCellValue("");
						R0110cell12.setCellStyle(textStyle);
					}

//ROW20
//Column N: 
					Cell R0110cell13 = row.createCell(13);
					if (record.getR0110_1_3years() != null) {
						R0110cell13.setCellValue(record.getR0110_1_3years().doubleValue());
						R0110cell13.setCellStyle(numberStyle);
					} else {
						R0110cell13.setCellValue("");
						R0110cell13.setCellStyle(textStyle);
					}

//ROW20
//Column O: 
					Cell R0110cell14 = row.createCell(14);
					if (record.getR0110_3_5years() != null) {
						R0110cell14.setCellValue(record.getR0110_3_5years().doubleValue());
						R0110cell14.setCellStyle(numberStyle);
					} else {
						R0110cell14.setCellValue("");
						R0110cell14.setCellStyle(textStyle);
					}

//ROW20
//Column P: 
					Cell R0110cell15 = row.createCell(15);
					if (record.getR0110_5years() != null) {
						R0110cell15.setCellValue(record.getR0110_5years().doubleValue());
						R0110cell15.setCellStyle(numberStyle);
					} else {
						R0110cell15.setCellValue("");
						R0110cell15.setCellStyle(textStyle);
					}

/////ROW21///////////
//ROW21

					row = sheet.getRow(20);

//Column E: 
					Cell R0120cell4 = row.createCell(4);
					if (record.getR0120_overdue() != null) {
						R0120cell4.setCellValue(record.getR0120_overdue().doubleValue());
						R0120cell4.setCellStyle(numberStyle);
					} else {
						R0120cell4.setCellValue("");
						R0120cell4.setCellStyle(textStyle);
					}

//ROW21
//Column F: 
					Cell R0120cell5 = row.createCell(5);
					if (record.getR0120_overdraft() != null) {
						R0120cell5.setCellValue(record.getR0120_overdraft().doubleValue());
						R0120cell5.setCellStyle(numberStyle);
					} else {
						R0120cell5.setCellValue("");
						R0120cell5.setCellStyle(textStyle);
					}

//ROW21
//Column G: 
					Cell R0120cell6 = row.createCell(6);
					if (record.getR0120_0_7days() != null) {
						R0120cell6.setCellValue(record.getR0120_0_7days().doubleValue());
						R0120cell6.setCellStyle(numberStyle);
					} else {
						R0120cell6.setCellValue("");
						R0120cell6.setCellStyle(textStyle);
					}

//ROW21
//Column H: 
					Cell R0120cell7 = row.createCell(7);
					if (record.getR0120_8_14days() != null) {
						R0120cell7.setCellValue(record.getR0120_8_14days().doubleValue());
						R0120cell7.setCellStyle(numberStyle);
					} else {
						R0120cell7.setCellValue("");
						R0120cell7.setCellStyle(textStyle);
					}

//ROW21
//Column I: 
					Cell R0120cell8 = row.createCell(8);
					if (record.getR0120_15days_1months() != null) {
						R0120cell8.setCellValue(record.getR0120_15days_1months().doubleValue());
						R0120cell8.setCellStyle(numberStyle);
					} else {
						R0120cell8.setCellValue("");
						R0120cell8.setCellStyle(textStyle);
					}

//ROW21
//Column J: 
					Cell R0120cell9 = row.createCell(9);
					if (record.getR0120_1_2months() != null) {
						R0120cell9.setCellValue(record.getR0120_1_2months().doubleValue());
						R0120cell9.setCellStyle(numberStyle);
					} else {
						R0120cell9.setCellValue("");
						R0120cell9.setCellStyle(textStyle);
					}

//ROW21
//Column K: 
					Cell R0120cell10 = row.createCell(10);
					if (record.getR0120_2_3months() != null) {
						R0120cell10.setCellValue(record.getR0120_2_3months().doubleValue());
						R0120cell10.setCellStyle(numberStyle);
					} else {
						R0120cell10.setCellValue("");
						R0120cell10.setCellStyle(textStyle);
					}

//ROW21
//Column L: 
					Cell R0120cell11 = row.createCell(11);
					if (record.getR0120_3_6months() != null) {
						R0120cell11.setCellValue(record.getR0120_3_6months().doubleValue());
						R0120cell11.setCellStyle(numberStyle);
					} else {
						R0120cell11.setCellValue("");
						R0120cell11.setCellStyle(textStyle);
					}

//ROW21
//Column M: 
					Cell R0120cell12 = row.createCell(12);
					if (record.getR0120_6_12months() != null) {
						R0120cell12.setCellValue(record.getR0120_6_12months().doubleValue());
						R0120cell12.setCellStyle(numberStyle);
					} else {
						R0120cell12.setCellValue("");
						R0120cell12.setCellStyle(textStyle);
					}

//ROW21
//Column N: 
					Cell R0120cell13 = row.createCell(13);
					if (record.getR0120_1_3years() != null) {
						R0120cell13.setCellValue(record.getR0120_1_3years().doubleValue());
						R0120cell13.setCellStyle(numberStyle);
					} else {
						R0120cell13.setCellValue("");
						R0120cell13.setCellStyle(textStyle);
					}

//ROW21
//Column O: 
					Cell R0120cell14 = row.createCell(14);
					if (record.getR0120_3_5years() != null) {
						R0120cell14.setCellValue(record.getR0120_3_5years().doubleValue());
						R0120cell14.setCellStyle(numberStyle);
					} else {
						R0120cell14.setCellValue("");
						R0120cell14.setCellStyle(textStyle);
					}

//ROW21
//Column P: 
					Cell R0120cell15 = row.createCell(15);
					if (record.getR0120_5years() != null) {
						R0120cell15.setCellValue(record.getR0120_5years().doubleValue());
						R0120cell15.setCellStyle(numberStyle);
					} else {
						R0120cell15.setCellValue("");
						R0120cell15.setCellStyle(textStyle);
					}

/////ROW22///////////
//ROW22

					row = sheet.getRow(21);

//Column E: 
					Cell R0130cell4 = row.createCell(4);
					if (record.getR0130_overdue() != null) {
						R0130cell4.setCellValue(record.getR0130_overdue().doubleValue());
						R0130cell4.setCellStyle(numberStyle);
					} else {
						R0130cell4.setCellValue("");
						R0130cell4.setCellStyle(textStyle);
					}

//ROW22
//Column F: 
					Cell R0130cell5 = row.createCell(5);
					if (record.getR0130_overdraft() != null) {
						R0130cell5.setCellValue(record.getR0130_overdraft().doubleValue());
						R0130cell5.setCellStyle(numberStyle);
					} else {
						R0130cell5.setCellValue("");
						R0130cell5.setCellStyle(textStyle);
					}

//ROW22
//Column G: 
					Cell R0130cell6 = row.createCell(6);
					if (record.getR0130_0_7days() != null) {
						R0130cell6.setCellValue(record.getR0130_0_7days().doubleValue());
						R0130cell6.setCellStyle(numberStyle);
					} else {
						R0130cell6.setCellValue("");
						R0130cell6.setCellStyle(textStyle);
					}

//ROW22
//Column H: 
					Cell R0130cell7 = row.createCell(7);
					if (record.getR0130_8_14days() != null) {
						R0130cell7.setCellValue(record.getR0130_8_14days().doubleValue());
						R0130cell7.setCellStyle(numberStyle);
					} else {
						R0130cell7.setCellValue("");
						R0130cell7.setCellStyle(textStyle);
					}

//ROW22
//Column I: 
					Cell R0130cell8 = row.createCell(8);
					if (record.getR0130_15days_1months() != null) {
						R0130cell8.setCellValue(record.getR0130_15days_1months().doubleValue());
						R0130cell8.setCellStyle(numberStyle);
					} else {
						R0130cell8.setCellValue("");
						R0130cell8.setCellStyle(textStyle);
					}

//ROW22
//Column J: 
					Cell R0130cell9 = row.createCell(9);
					if (record.getR0130_1_2months() != null) {
						R0130cell9.setCellValue(record.getR0130_1_2months().doubleValue());
						R0130cell9.setCellStyle(numberStyle);
					} else {
						R0130cell9.setCellValue("");
						R0130cell9.setCellStyle(textStyle);
					}

//ROW22
//Column K: 
					Cell R0130cell10 = row.createCell(10);
					if (record.getR0130_2_3months() != null) {
						R0130cell10.setCellValue(record.getR0130_2_3months().doubleValue());
						R0130cell10.setCellStyle(numberStyle);
					} else {
						R0130cell10.setCellValue("");
						R0130cell10.setCellStyle(textStyle);
					}

//ROW22
//Column L: 
					Cell R0130cell11 = row.createCell(11);
					if (record.getR0130_3_6months() != null) {
						R0130cell11.setCellValue(record.getR0130_3_6months().doubleValue());
						R0130cell11.setCellStyle(numberStyle);
					} else {
						R0130cell11.setCellValue("");
						R0130cell11.setCellStyle(textStyle);
					}

//ROW22
//Column M: 
					Cell R0130cell12 = row.createCell(12);
					if (record.getR0130_6_12months() != null) {
						R0130cell12.setCellValue(record.getR0130_6_12months().doubleValue());
						R0130cell12.setCellStyle(numberStyle);
					} else {
						R0130cell12.setCellValue("");
						R0130cell12.setCellStyle(textStyle);
					}

//ROW22
//Column N: 
					Cell R0130cell13 = row.createCell(13);
					if (record.getR0130_1_3years() != null) {
						R0130cell13.setCellValue(record.getR0130_1_3years().doubleValue());
						R0130cell13.setCellStyle(numberStyle);
					} else {
						R0130cell13.setCellValue("");
						R0130cell13.setCellStyle(textStyle);
					}

//ROW22
//Column O: 
					Cell R0130cell14 = row.createCell(14);
					if (record.getR0130_3_5years() != null) {
						R0130cell14.setCellValue(record.getR0130_3_5years().doubleValue());
						R0130cell14.setCellStyle(numberStyle);
					} else {
						R0130cell14.setCellValue("");
						R0130cell14.setCellStyle(textStyle);
					}

//ROW22
//Column P: 
					Cell R0130cell15 = row.createCell(15);
					if (record.getR0130_5years() != null) {
						R0130cell15.setCellValue(record.getR0130_5years().doubleValue());
						R0130cell15.setCellStyle(numberStyle);
					} else {
						R0130cell15.setCellValue("");
						R0130cell15.setCellStyle(textStyle);
					}

/////ROW23///////////
//ROW23

					row = sheet.getRow(22);

//Column E: 
					Cell R0140cell4 = row.createCell(4);
					if (record.getR0140_overdue() != null) {
						R0140cell4.setCellValue(record.getR0140_overdue().doubleValue());
						R0140cell4.setCellStyle(numberStyle);
					} else {
						R0140cell4.setCellValue("");
						R0140cell4.setCellStyle(textStyle);
					}

//ROW23
//Column F: 
					Cell R0140cell5 = row.createCell(5);
					if (record.getR0140_overdraft() != null) {
						R0140cell5.setCellValue(record.getR0140_overdraft().doubleValue());
						R0140cell5.setCellStyle(numberStyle);
					} else {
						R0140cell5.setCellValue("");
						R0140cell5.setCellStyle(textStyle);
					}

//ROW23
//Column G: 
					Cell R0140cell6 = row.createCell(6);
					if (record.getR0140_0_7days() != null) {
						R0140cell6.setCellValue(record.getR0140_0_7days().doubleValue());
						R0140cell6.setCellStyle(numberStyle);
					} else {
						R0140cell6.setCellValue("");
						R0140cell6.setCellStyle(textStyle);
					}

//ROW23
//Column H: 
					Cell R0140cell7 = row.createCell(7);
					if (record.getR0140_8_14days() != null) {
						R0140cell7.setCellValue(record.getR0140_8_14days().doubleValue());
						R0140cell7.setCellStyle(numberStyle);
					} else {
						R0140cell7.setCellValue("");
						R0140cell7.setCellStyle(textStyle);
					}

//ROW23
//Column I: 
					Cell R0140cell8 = row.createCell(8);
					if (record.getR0140_15days_1months() != null) {
						R0140cell8.setCellValue(record.getR0140_15days_1months().doubleValue());
						R0140cell8.setCellStyle(numberStyle);
					} else {
						R0140cell8.setCellValue("");
						R0140cell8.setCellStyle(textStyle);
					}

//ROW23
//Column J: 
					Cell R0140cell9 = row.createCell(9);
					if (record.getR0140_1_2months() != null) {
						R0140cell9.setCellValue(record.getR0140_1_2months().doubleValue());
						R0140cell9.setCellStyle(numberStyle);
					} else {
						R0140cell9.setCellValue("");
						R0140cell9.setCellStyle(textStyle);
					}

//ROW23
//Column K: 
					Cell R0140cell10 = row.createCell(10);
					if (record.getR0140_2_3months() != null) {
						R0140cell10.setCellValue(record.getR0140_2_3months().doubleValue());
						R0140cell10.setCellStyle(numberStyle);
					} else {
						R0140cell10.setCellValue("");
						R0140cell10.setCellStyle(textStyle);
					}

//ROW23
//Column L: 
					Cell R0140cell11 = row.createCell(11);
					if (record.getR0140_3_6months() != null) {
						R0140cell11.setCellValue(record.getR0140_3_6months().doubleValue());
						R0140cell11.setCellStyle(numberStyle);
					} else {
						R0140cell11.setCellValue("");
						R0140cell11.setCellStyle(textStyle);
					}

//ROW23
//Column M: 
					Cell R0140cell12 = row.createCell(12);
					if (record.getR0140_6_12months() != null) {
						R0140cell12.setCellValue(record.getR0140_6_12months().doubleValue());
						R0140cell12.setCellStyle(numberStyle);
					} else {
						R0140cell12.setCellValue("");
						R0140cell12.setCellStyle(textStyle);
					}

//ROW23
//Column N: 
					Cell R0140cell13 = row.createCell(13);
					if (record.getR0140_1_3years() != null) {
						R0140cell13.setCellValue(record.getR0140_1_3years().doubleValue());
						R0140cell13.setCellStyle(numberStyle);
					} else {
						R0140cell13.setCellValue("");
						R0140cell13.setCellStyle(textStyle);
					}

//ROW23
//Column O: 
					Cell R0140cell14 = row.createCell(14);
					if (record.getR0140_3_5years() != null) {
						R0140cell14.setCellValue(record.getR0140_3_5years().doubleValue());
						R0140cell14.setCellStyle(numberStyle);
					} else {
						R0140cell14.setCellValue("");
						R0140cell14.setCellStyle(textStyle);
					}

//ROW23
//Column P: 
					Cell R0140cell15 = row.createCell(15);
					if (record.getR0140_5years() != null) {
						R0140cell15.setCellValue(record.getR0140_5years().doubleValue());
						R0140cell15.setCellStyle(numberStyle);
					} else {
						R0140cell15.setCellValue("");
						R0140cell15.setCellStyle(textStyle);
					}

/////ROW24///////////
//ROW24

					row = sheet.getRow(23);

//Column E: 
					Cell R0150cell4 = row.createCell(4);
					if (record.getR0150_overdue() != null) {
						R0150cell4.setCellValue(record.getR0150_overdue().doubleValue());
						R0150cell4.setCellStyle(numberStyle);
					} else {
						R0150cell4.setCellValue("");
						R0150cell4.setCellStyle(textStyle);
					}

//ROW24
//Column F: 
					Cell R0150cell5 = row.createCell(5);
					if (record.getR0150_overdraft() != null) {
						R0150cell5.setCellValue(record.getR0150_overdraft().doubleValue());
						R0150cell5.setCellStyle(numberStyle);
					} else {
						R0150cell5.setCellValue("");
						R0150cell5.setCellStyle(textStyle);
					}

//ROW24
//Column G: 
					Cell R0150cell6 = row.createCell(6);
					if (record.getR0150_0_7days() != null) {
						R0150cell6.setCellValue(record.getR0150_0_7days().doubleValue());
						R0150cell6.setCellStyle(numberStyle);
					} else {
						R0150cell6.setCellValue("");
						R0150cell6.setCellStyle(textStyle);
					}

//ROW24
//Column H: 
					Cell R0150cell7 = row.createCell(7);
					if (record.getR0150_8_14days() != null) {
						R0150cell7.setCellValue(record.getR0150_8_14days().doubleValue());
						R0150cell7.setCellStyle(numberStyle);
					} else {
						R0150cell7.setCellValue("");
						R0150cell7.setCellStyle(textStyle);
					}

//ROW24
//Column I: 
					Cell R0150cell8 = row.createCell(8);
					if (record.getR0150_15days_1months() != null) {
						R0150cell8.setCellValue(record.getR0150_15days_1months().doubleValue());
						R0150cell8.setCellStyle(numberStyle);
					} else {
						R0150cell8.setCellValue("");
						R0150cell8.setCellStyle(textStyle);
					}

//ROW24
//Column J: 
					Cell R0150cell9 = row.createCell(9);
					if (record.getR0150_1_2months() != null) {
						R0150cell9.setCellValue(record.getR0150_1_2months().doubleValue());
						R0150cell9.setCellStyle(numberStyle);
					} else {
						R0150cell9.setCellValue("");
						R0150cell9.setCellStyle(textStyle);
					}

//ROW24
//Column K: 
					Cell R0150cell10 = row.createCell(10);
					if (record.getR0150_2_3months() != null) {
						R0150cell10.setCellValue(record.getR0150_2_3months().doubleValue());
						R0150cell10.setCellStyle(numberStyle);
					} else {
						R0150cell10.setCellValue("");
						R0150cell10.setCellStyle(textStyle);
					}

//ROW24
//Column L: 
					Cell R0150cell11 = row.createCell(11);
					if (record.getR0150_3_6months() != null) {
						R0150cell11.setCellValue(record.getR0150_3_6months().doubleValue());
						R0150cell11.setCellStyle(numberStyle);
					} else {
						R0150cell11.setCellValue("");
						R0150cell11.setCellStyle(textStyle);
					}

//ROW24
//Column M: 
					Cell R0150cell12 = row.createCell(12);
					if (record.getR0150_6_12months() != null) {
						R0150cell12.setCellValue(record.getR0150_6_12months().doubleValue());
						R0150cell12.setCellStyle(numberStyle);
					} else {
						R0150cell12.setCellValue("");
						R0150cell12.setCellStyle(textStyle);
					}

//ROW24
//Column N: 
					Cell R0150cell13 = row.createCell(13);
					if (record.getR0150_1_3years() != null) {
						R0150cell13.setCellValue(record.getR0150_1_3years().doubleValue());
						R0150cell13.setCellStyle(numberStyle);
					} else {
						R0150cell13.setCellValue("");
						R0150cell13.setCellStyle(textStyle);
					}

//ROW24
//Column O: 
					Cell R0150cell14 = row.createCell(14);
					if (record.getR0150_3_5years() != null) {
						R0150cell14.setCellValue(record.getR0150_3_5years().doubleValue());
						R0150cell14.setCellStyle(numberStyle);
					} else {
						R0150cell14.setCellValue("");
						R0150cell14.setCellStyle(textStyle);
					}

//ROW24
//Column P: 
					Cell R0150cell15 = row.createCell(15);
					if (record.getR0150_5years() != null) {
						R0150cell15.setCellValue(record.getR0150_5years().doubleValue());
						R0150cell15.setCellStyle(numberStyle);
					} else {
						R0150cell15.setCellValue("");
						R0150cell15.setCellStyle(textStyle);
					}

/////ROW25///////////
//ROW25

					row = sheet.getRow(24);

//Column E: 
					Cell R0160cell4 = row.createCell(4);
					if (record.getR0160_overdue() != null) {
						R0160cell4.setCellValue(record.getR0160_overdue().doubleValue());
						R0160cell4.setCellStyle(numberStyle);
					} else {
						R0160cell4.setCellValue("");
						R0160cell4.setCellStyle(textStyle);
					}

//ROW25
//Column F: 
					Cell R0160cell5 = row.createCell(5);
					if (record.getR0160_overdraft() != null) {
						R0160cell5.setCellValue(record.getR0160_overdraft().doubleValue());
						R0160cell5.setCellStyle(numberStyle);
					} else {
						R0160cell5.setCellValue("");
						R0160cell5.setCellStyle(textStyle);
					}

//ROW25
//Column G: 
					Cell R0160cell6 = row.createCell(6);
					if (record.getR0160_0_7days() != null) {
						R0160cell6.setCellValue(record.getR0160_0_7days().doubleValue());
						R0160cell6.setCellStyle(numberStyle);
					} else {
						R0160cell6.setCellValue("");
						R0160cell6.setCellStyle(textStyle);
					}

//ROW25
//Column H: 
					Cell R0160cell7 = row.createCell(7);
					if (record.getR0160_8_14days() != null) {
						R0160cell7.setCellValue(record.getR0160_8_14days().doubleValue());
						R0160cell7.setCellStyle(numberStyle);
					} else {
						R0160cell7.setCellValue("");
						R0160cell7.setCellStyle(textStyle);
					}

//ROW25
//Column I: 
					Cell R0160cell8 = row.createCell(8);
					if (record.getR0160_15days_1months() != null) {
						R0160cell8.setCellValue(record.getR0160_15days_1months().doubleValue());
						R0160cell8.setCellStyle(numberStyle);
					} else {
						R0160cell8.setCellValue("");
						R0160cell8.setCellStyle(textStyle);
					}

//ROW25
//Column J: 
					Cell R0160cell9 = row.createCell(9);
					if (record.getR0160_1_2months() != null) {
						R0160cell9.setCellValue(record.getR0160_1_2months().doubleValue());
						R0160cell9.setCellStyle(numberStyle);
					} else {
						R0160cell9.setCellValue("");
						R0160cell9.setCellStyle(textStyle);
					}

//ROW25
//Column K: 
					Cell R0160cell10 = row.createCell(10);
					if (record.getR0160_2_3months() != null) {
						R0160cell10.setCellValue(record.getR0160_2_3months().doubleValue());
						R0160cell10.setCellStyle(numberStyle);
					} else {
						R0160cell10.setCellValue("");
						R0160cell10.setCellStyle(textStyle);
					}

//ROW25
//Column L: 
					Cell R0160cell11 = row.createCell(11);
					if (record.getR0160_3_6months() != null) {
						R0160cell11.setCellValue(record.getR0160_3_6months().doubleValue());
						R0160cell11.setCellStyle(numberStyle);
					} else {
						R0160cell11.setCellValue("");
						R0160cell11.setCellStyle(textStyle);
					}

//ROW25
//Column M: 
					Cell R0160cell12 = row.createCell(12);
					if (record.getR0160_6_12months() != null) {
						R0160cell12.setCellValue(record.getR0160_6_12months().doubleValue());
						R0160cell12.setCellStyle(numberStyle);
					} else {
						R0160cell12.setCellValue("");
						R0160cell12.setCellStyle(textStyle);
					}

//ROW25
//Column N: 
					Cell R0160cell13 = row.createCell(13);
					if (record.getR0160_1_3years() != null) {
						R0160cell13.setCellValue(record.getR0160_1_3years().doubleValue());
						R0160cell13.setCellStyle(numberStyle);
					} else {
						R0160cell13.setCellValue("");
						R0160cell13.setCellStyle(textStyle);
					}

//ROW25
//Column O: 
					Cell R0160cell14 = row.createCell(14);
					if (record.getR0160_3_5years() != null) {
						R0160cell14.setCellValue(record.getR0160_3_5years().doubleValue());
						R0160cell14.setCellStyle(numberStyle);
					} else {
						R0160cell14.setCellValue("");
						R0160cell14.setCellStyle(textStyle);
					}

//ROW25
//Column P: 
					Cell R0160cell15 = row.createCell(15);
					if (record.getR0160_5years() != null) {
						R0160cell15.setCellValue(record.getR0160_5years().doubleValue());
						R0160cell15.setCellStyle(numberStyle);
					} else {
						R0160cell15.setCellValue("");
						R0160cell15.setCellStyle(textStyle);
					}

/////ROW26///////////
//ROW26

					row = sheet.getRow(25);

//Column E: 
					Cell R0170cell4 = row.createCell(4);
					if (record.getR0170_overdue() != null) {
						R0170cell4.setCellValue(record.getR0170_overdue().doubleValue());
						R0170cell4.setCellStyle(numberStyle);
					} else {
						R0170cell4.setCellValue("");
						R0170cell4.setCellStyle(textStyle);
					}

//ROW26
//Column F: 
					Cell R0170cell5 = row.createCell(5);
					if (record.getR0170_overdraft() != null) {
						R0170cell5.setCellValue(record.getR0170_overdraft().doubleValue());
						R0170cell5.setCellStyle(numberStyle);
					} else {
						R0170cell5.setCellValue("");
						R0170cell5.setCellStyle(textStyle);
					}

//ROW26
//Column G: 
					Cell R0170cell6 = row.createCell(6);
					if (record.getR0170_0_7days() != null) {
						R0170cell6.setCellValue(record.getR0170_0_7days().doubleValue());
						R0170cell6.setCellStyle(numberStyle);
					} else {
						R0170cell6.setCellValue("");
						R0170cell6.setCellStyle(textStyle);
					}

//ROW26
//Column H: 
					Cell R0170cell7 = row.createCell(7);
					if (record.getR0170_8_14days() != null) {
						R0170cell7.setCellValue(record.getR0170_8_14days().doubleValue());
						R0170cell7.setCellStyle(numberStyle);
					} else {
						R0170cell7.setCellValue("");
						R0170cell7.setCellStyle(textStyle);
					}

//ROW26
//Column I: 
					Cell R0170cell8 = row.createCell(8);
					if (record.getR0170_15days_1months() != null) {
						R0170cell8.setCellValue(record.getR0170_15days_1months().doubleValue());
						R0170cell8.setCellStyle(numberStyle);
					} else {
						R0170cell8.setCellValue("");
						R0170cell8.setCellStyle(textStyle);
					}

//ROW26
//Column J: 
					Cell R0170cell9 = row.createCell(9);
					if (record.getR0170_1_2months() != null) {
						R0170cell9.setCellValue(record.getR0170_1_2months().doubleValue());
						R0170cell9.setCellStyle(numberStyle);
					} else {
						R0170cell9.setCellValue("");
						R0170cell9.setCellStyle(textStyle);
					}

//ROW26
//Column K: 
					Cell R0170cell10 = row.createCell(10);
					if (record.getR0170_2_3months() != null) {
						R0170cell10.setCellValue(record.getR0170_2_3months().doubleValue());
						R0170cell10.setCellStyle(numberStyle);
					} else {
						R0170cell10.setCellValue("");
						R0170cell10.setCellStyle(textStyle);
					}

//ROW26
//Column L: 
					Cell R0170cell11 = row.createCell(11);
					if (record.getR0170_3_6months() != null) {
						R0170cell11.setCellValue(record.getR0170_3_6months().doubleValue());
						R0170cell11.setCellStyle(numberStyle);
					} else {
						R0170cell11.setCellValue("");
						R0170cell11.setCellStyle(textStyle);
					}

//ROW26
//Column M: 
					Cell R0170cell12 = row.createCell(12);
					if (record.getR0170_6_12months() != null) {
						R0170cell12.setCellValue(record.getR0170_6_12months().doubleValue());
						R0170cell12.setCellStyle(numberStyle);
					} else {
						R0170cell12.setCellValue("");
						R0170cell12.setCellStyle(textStyle);
					}

//ROW26
//Column N: 
					Cell R0170cell13 = row.createCell(13);
					if (record.getR0170_1_3years() != null) {
						R0170cell13.setCellValue(record.getR0170_1_3years().doubleValue());
						R0170cell13.setCellStyle(numberStyle);
					} else {
						R0170cell13.setCellValue("");
						R0170cell13.setCellStyle(textStyle);
					}

//ROW26
//Column O: 
					Cell R0170cell14 = row.createCell(14);
					if (record.getR0170_3_5years() != null) {
						R0170cell14.setCellValue(record.getR0170_3_5years().doubleValue());
						R0170cell14.setCellStyle(numberStyle);
					} else {
						R0170cell14.setCellValue("");
						R0170cell14.setCellStyle(textStyle);
					}

//ROW26
//Column P: 
					Cell R0170cell15 = row.createCell(15);
					if (record.getR0170_5years() != null) {
						R0170cell15.setCellValue(record.getR0170_5years().doubleValue());
						R0170cell15.setCellStyle(numberStyle);
					} else {
						R0170cell15.setCellValue("");
						R0170cell15.setCellStyle(textStyle);
					}

/////ROW27///////////
//ROW27

					row = sheet.getRow(26);

//Column E: 
					Cell R0180cell4 = row.createCell(4);
					if (record.getR0180_overdue() != null) {
						R0180cell4.setCellValue(record.getR0180_overdue().doubleValue());
						R0180cell4.setCellStyle(numberStyle);
					} else {
						R0180cell4.setCellValue("");
						R0180cell4.setCellStyle(textStyle);
					}

//ROW27
//Column F: 
					Cell R0180cell5 = row.createCell(5);
					if (record.getR0180_overdraft() != null) {
						R0180cell5.setCellValue(record.getR0180_overdraft().doubleValue());
						R0180cell5.setCellStyle(numberStyle);
					} else {
						R0180cell5.setCellValue("");
						R0180cell5.setCellStyle(textStyle);
					}

//ROW27
//Column G: 
					Cell R0180cell6 = row.createCell(6);
					if (record.getR0180_0_7days() != null) {
						R0180cell6.setCellValue(record.getR0180_0_7days().doubleValue());
						R0180cell6.setCellStyle(numberStyle);
					} else {
						R0180cell6.setCellValue("");
						R0180cell6.setCellStyle(textStyle);
					}

//ROW27
//Column H: 
					Cell R0180cell7 = row.createCell(7);
					if (record.getR0180_8_14days() != null) {
						R0180cell7.setCellValue(record.getR0180_8_14days().doubleValue());
						R0180cell7.setCellStyle(numberStyle);
					} else {
						R0180cell7.setCellValue("");
						R0180cell7.setCellStyle(textStyle);
					}

//ROW27
//Column I: 
					Cell R0180cell8 = row.createCell(8);
					if (record.getR0180_15days_1months() != null) {
						R0180cell8.setCellValue(record.getR0180_15days_1months().doubleValue());
						R0180cell8.setCellStyle(numberStyle);
					} else {
						R0180cell8.setCellValue("");
						R0180cell8.setCellStyle(textStyle);
					}

//ROW27
//Column J: 
					Cell R0180cell9 = row.createCell(9);
					if (record.getR0180_1_2months() != null) {
						R0180cell9.setCellValue(record.getR0180_1_2months().doubleValue());
						R0180cell9.setCellStyle(numberStyle);
					} else {
						R0180cell9.setCellValue("");
						R0180cell9.setCellStyle(textStyle);
					}

//ROW27
//Column K: 
					Cell R0180cell10 = row.createCell(10);
					if (record.getR0180_2_3months() != null) {
						R0180cell10.setCellValue(record.getR0180_2_3months().doubleValue());
						R0180cell10.setCellStyle(numberStyle);
					} else {
						R0180cell10.setCellValue("");
						R0180cell10.setCellStyle(textStyle);
					}

//ROW27
//Column L: 
					Cell R0180cell11 = row.createCell(11);
					if (record.getR0180_3_6months() != null) {
						R0180cell11.setCellValue(record.getR0180_3_6months().doubleValue());
						R0180cell11.setCellStyle(numberStyle);
					} else {
						R0180cell11.setCellValue("");
						R0180cell11.setCellStyle(textStyle);
					}

//ROW27
//Column M: 
					Cell R0180cell12 = row.createCell(12);
					if (record.getR0180_6_12months() != null) {
						R0180cell12.setCellValue(record.getR0180_6_12months().doubleValue());
						R0180cell12.setCellStyle(numberStyle);
					} else {
						R0180cell12.setCellValue("");
						R0180cell12.setCellStyle(textStyle);
					}

//ROW27
//Column N: 
					Cell R0180cell13 = row.createCell(13);
					if (record.getR0180_1_3years() != null) {
						R0180cell13.setCellValue(record.getR0180_1_3years().doubleValue());
						R0180cell13.setCellStyle(numberStyle);
					} else {
						R0180cell13.setCellValue("");
						R0180cell13.setCellStyle(textStyle);
					}

//ROW27
//Column O: 
					Cell R0180cell14 = row.createCell(14);
					if (record.getR0180_3_5years() != null) {
						R0180cell14.setCellValue(record.getR0180_3_5years().doubleValue());
						R0180cell14.setCellStyle(numberStyle);
					} else {
						R0180cell14.setCellValue("");
						R0180cell14.setCellStyle(textStyle);
					}

//ROW27
//Column P: 
					Cell R0180cell15 = row.createCell(15);
					if (record.getR0180_5years() != null) {
						R0180cell15.setCellValue(record.getR0180_5years().doubleValue());
						R0180cell15.setCellStyle(numberStyle);
					} else {
						R0180cell15.setCellValue("");
						R0180cell15.setCellStyle(textStyle);
					}

/////ROW28///////////
//ROW28

					row = sheet.getRow(27);

//Column E: 
					Cell R0190cell4 = row.createCell(4);
					if (record.getR0190_overdue() != null) {
						R0190cell4.setCellValue(record.getR0190_overdue().doubleValue());
						R0190cell4.setCellStyle(numberStyle);
					} else {
						R0190cell4.setCellValue("");
						R0190cell4.setCellStyle(textStyle);
					}

//ROW28
//Column F: 
					Cell R0190cell5 = row.createCell(5);
					if (record.getR0190_overdraft() != null) {
						R0190cell5.setCellValue(record.getR0190_overdraft().doubleValue());
						R0190cell5.setCellStyle(numberStyle);
					} else {
						R0190cell5.setCellValue("");
						R0190cell5.setCellStyle(textStyle);
					}

//ROW28
//Column G: 
					Cell R0190cell6 = row.createCell(6);
					if (record.getR0190_0_7days() != null) {
						R0190cell6.setCellValue(record.getR0190_0_7days().doubleValue());
						R0190cell6.setCellStyle(numberStyle);
					} else {
						R0190cell6.setCellValue("");
						R0190cell6.setCellStyle(textStyle);
					}

//ROW28
//Column H: 
					Cell R0190cell7 = row.createCell(7);
					if (record.getR0190_8_14days() != null) {
						R0190cell7.setCellValue(record.getR0190_8_14days().doubleValue());
						R0190cell7.setCellStyle(numberStyle);
					} else {
						R0190cell7.setCellValue("");
						R0190cell7.setCellStyle(textStyle);
					}

//ROW28
//Column I: 
					Cell R0190cell8 = row.createCell(8);
					if (record.getR0190_15days_1months() != null) {
						R0190cell8.setCellValue(record.getR0190_15days_1months().doubleValue());
						R0190cell8.setCellStyle(numberStyle);
					} else {
						R0190cell8.setCellValue("");
						R0190cell8.setCellStyle(textStyle);
					}

//ROW28
//Column J: 
					Cell R0190cell9 = row.createCell(9);
					if (record.getR0190_1_2months() != null) {
						R0190cell9.setCellValue(record.getR0190_1_2months().doubleValue());
						R0190cell9.setCellStyle(numberStyle);
					} else {
						R0190cell9.setCellValue("");
						R0190cell9.setCellStyle(textStyle);
					}

//ROW28
//Column K: 
					Cell R0190cell10 = row.createCell(10);
					if (record.getR0190_2_3months() != null) {
						R0190cell10.setCellValue(record.getR0190_2_3months().doubleValue());
						R0190cell10.setCellStyle(numberStyle);
					} else {
						R0190cell10.setCellValue("");
						R0190cell10.setCellStyle(textStyle);
					}

//ROW28
//Column L: 
					Cell R0190cell11 = row.createCell(11);
					if (record.getR0190_3_6months() != null) {
						R0190cell11.setCellValue(record.getR0190_3_6months().doubleValue());
						R0190cell11.setCellStyle(numberStyle);
					} else {
						R0190cell11.setCellValue("");
						R0190cell11.setCellStyle(textStyle);
					}

//ROW28
//Column M: 
					Cell R0190cell12 = row.createCell(12);
					if (record.getR0190_6_12months() != null) {
						R0190cell12.setCellValue(record.getR0190_6_12months().doubleValue());
						R0190cell12.setCellStyle(numberStyle);
					} else {
						R0190cell12.setCellValue("");
						R0190cell12.setCellStyle(textStyle);
					}

//ROW28
//Column N: 
					Cell R0190cell13 = row.createCell(13);
					if (record.getR0190_1_3years() != null) {
						R0190cell13.setCellValue(record.getR0190_1_3years().doubleValue());
						R0190cell13.setCellStyle(numberStyle);
					} else {
						R0190cell13.setCellValue("");
						R0190cell13.setCellStyle(textStyle);
					}

//ROW28
//Column O: 
					Cell R0190cell14 = row.createCell(14);
					if (record.getR0190_3_5years() != null) {
						R0190cell14.setCellValue(record.getR0190_3_5years().doubleValue());
						R0190cell14.setCellStyle(numberStyle);
					} else {
						R0190cell14.setCellValue("");
						R0190cell14.setCellStyle(textStyle);
					}

//ROW28
//Column P: 
					Cell R0190cell15 = row.createCell(15);
					if (record.getR0190_5years() != null) {
						R0190cell15.setCellValue(record.getR0190_5years().doubleValue());
						R0190cell15.setCellStyle(numberStyle);
					} else {
						R0190cell15.setCellValue("");
						R0190cell15.setCellStyle(textStyle);
					}

/////ROW29///////////
//ROW29

					row = sheet.getRow(28);

//Column E: 
					Cell R0200cell4 = row.createCell(4);
					if (record.getR0200_overdue() != null) {
						R0200cell4.setCellValue(record.getR0200_overdue().doubleValue());
						R0200cell4.setCellStyle(numberStyle);
					} else {
						R0200cell4.setCellValue("");
						R0200cell4.setCellStyle(textStyle);
					}

//ROW29
//Column F: 
					Cell R0200cell5 = row.createCell(5);
					if (record.getR0200_overdraft() != null) {
						R0200cell5.setCellValue(record.getR0200_overdraft().doubleValue());
						R0200cell5.setCellStyle(numberStyle);
					} else {
						R0200cell5.setCellValue("");
						R0200cell5.setCellStyle(textStyle);
					}

//ROW29
//Column G: 
					Cell R0200cell6 = row.createCell(6);
					if (record.getR0200_0_7days() != null) {
						R0200cell6.setCellValue(record.getR0200_0_7days().doubleValue());
						R0200cell6.setCellStyle(numberStyle);
					} else {
						R0200cell6.setCellValue("");
						R0200cell6.setCellStyle(textStyle);
					}

//ROW29
//Column H: 
					Cell R0200cell7 = row.createCell(7);
					if (record.getR0200_8_14days() != null) {
						R0200cell7.setCellValue(record.getR0200_8_14days().doubleValue());
						R0200cell7.setCellStyle(numberStyle);
					} else {
						R0200cell7.setCellValue("");
						R0200cell7.setCellStyle(textStyle);
					}

//ROW29
//Column I: 
					Cell R0200cell8 = row.createCell(8);
					if (record.getR0200_15days_1months() != null) {
						R0200cell8.setCellValue(record.getR0200_15days_1months().doubleValue());
						R0200cell8.setCellStyle(numberStyle);
					} else {
						R0200cell8.setCellValue("");
						R0200cell8.setCellStyle(textStyle);
					}

//ROW29
//Column J: 
					Cell R0200cell9 = row.createCell(9);
					if (record.getR0200_1_2months() != null) {
						R0200cell9.setCellValue(record.getR0200_1_2months().doubleValue());
						R0200cell9.setCellStyle(numberStyle);
					} else {
						R0200cell9.setCellValue("");
						R0200cell9.setCellStyle(textStyle);
					}

//ROW29
//Column K: 
					Cell R0200cell10 = row.createCell(10);
					if (record.getR0200_2_3months() != null) {
						R0200cell10.setCellValue(record.getR0200_2_3months().doubleValue());
						R0200cell10.setCellStyle(numberStyle);
					} else {
						R0200cell10.setCellValue("");
						R0200cell10.setCellStyle(textStyle);
					}

//ROW29
//Column L: 
					Cell R0200cell11 = row.createCell(11);
					if (record.getR0200_3_6months() != null) {
						R0200cell11.setCellValue(record.getR0200_3_6months().doubleValue());
						R0200cell11.setCellStyle(numberStyle);
					} else {
						R0200cell11.setCellValue("");
						R0200cell11.setCellStyle(textStyle);
					}

//ROW29
//Column M: 
					Cell R0200cell12 = row.createCell(12);
					if (record.getR0200_6_12months() != null) {
						R0200cell12.setCellValue(record.getR0200_6_12months().doubleValue());
						R0200cell12.setCellStyle(numberStyle);
					} else {
						R0200cell12.setCellValue("");
						R0200cell12.setCellStyle(textStyle);
					}

//ROW29
//Column N: 
					Cell R0200cell13 = row.createCell(13);
					if (record.getR0200_1_3years() != null) {
						R0200cell13.setCellValue(record.getR0200_1_3years().doubleValue());
						R0200cell13.setCellStyle(numberStyle);
					} else {
						R0200cell13.setCellValue("");
						R0200cell13.setCellStyle(textStyle);
					}

//ROW29
//Column O: 
					Cell R0200cell14 = row.createCell(14);
					if (record.getR0200_3_5years() != null) {
						R0200cell14.setCellValue(record.getR0200_3_5years().doubleValue());
						R0200cell14.setCellStyle(numberStyle);
					} else {
						R0200cell14.setCellValue("");
						R0200cell14.setCellStyle(textStyle);
					}

//ROW29
//Column P: 
					Cell R0200cell15 = row.createCell(15);
					if (record.getR0200_5years() != null) {
						R0200cell15.setCellValue(record.getR0200_5years().doubleValue());
						R0200cell15.setCellStyle(numberStyle);
					} else {
						R0200cell15.setCellValue("");
						R0200cell15.setCellStyle(textStyle);
					}

/////ROW31///////////
//ROW31

					row = sheet.getRow(30);

//Column E: 
					Cell R0220cell4 = row.createCell(4);
					if (record.getR0220_overdue() != null) {
						R0220cell4.setCellValue(record.getR0220_overdue().doubleValue());
						R0220cell4.setCellStyle(numberStyle);
					} else {
						R0220cell4.setCellValue("");
						R0220cell4.setCellStyle(textStyle);
					}

//ROW31
//Column F: 
					Cell R0220cell5 = row.createCell(5);
					if (record.getR0220_overdraft() != null) {
						R0220cell5.setCellValue(record.getR0220_overdraft().doubleValue());
						R0220cell5.setCellStyle(numberStyle);
					} else {
						R0220cell5.setCellValue("");
						R0220cell5.setCellStyle(textStyle);
					}

//ROW31
//Column G: 
					Cell R0220cell6 = row.createCell(6);
					if (record.getR0220_0_7days() != null) {
						R0220cell6.setCellValue(record.getR0220_0_7days().doubleValue());
						R0220cell6.setCellStyle(numberStyle);
					} else {
						R0220cell6.setCellValue("");
						R0220cell6.setCellStyle(textStyle);
					}

//ROW31
//Column H: 
					Cell R0220cell7 = row.createCell(7);
					if (record.getR0220_8_14days() != null) {
						R0220cell7.setCellValue(record.getR0220_8_14days().doubleValue());
						R0220cell7.setCellStyle(numberStyle);
					} else {
						R0220cell7.setCellValue("");
						R0220cell7.setCellStyle(textStyle);
					}

//ROW31
//Column I: 
					Cell R0220cell8 = row.createCell(8);
					if (record.getR0220_15days_1months() != null) {
						R0220cell8.setCellValue(record.getR0220_15days_1months().doubleValue());
						R0220cell8.setCellStyle(numberStyle);
					} else {
						R0220cell8.setCellValue("");
						R0220cell8.setCellStyle(textStyle);
					}

//ROW31
//Column J: 
					Cell R0220cell9 = row.createCell(9);
					if (record.getR0220_1_2months() != null) {
						R0220cell9.setCellValue(record.getR0220_1_2months().doubleValue());
						R0220cell9.setCellStyle(numberStyle);
					} else {
						R0220cell9.setCellValue("");
						R0220cell9.setCellStyle(textStyle);
					}

//ROW31
//Column K: 
					Cell R0220cell10 = row.createCell(10);
					if (record.getR0220_2_3months() != null) {
						R0220cell10.setCellValue(record.getR0220_2_3months().doubleValue());
						R0220cell10.setCellStyle(numberStyle);
					} else {
						R0220cell10.setCellValue("");
						R0220cell10.setCellStyle(textStyle);
					}

//ROW31
//Column L: 
					Cell R0220cell11 = row.createCell(11);
					if (record.getR0220_3_6months() != null) {
						R0220cell11.setCellValue(record.getR0220_3_6months().doubleValue());
						R0220cell11.setCellStyle(numberStyle);
					} else {
						R0220cell11.setCellValue("");
						R0220cell11.setCellStyle(textStyle);
					}

//ROW31
//Column M: 
					Cell R0220cell12 = row.createCell(12);
					if (record.getR0220_6_12months() != null) {
						R0220cell12.setCellValue(record.getR0220_6_12months().doubleValue());
						R0220cell12.setCellStyle(numberStyle);
					} else {
						R0220cell12.setCellValue("");
						R0220cell12.setCellStyle(textStyle);
					}

//ROW31
//Column N: 
					Cell R0220cell13 = row.createCell(13);
					if (record.getR0220_1_3years() != null) {
						R0220cell13.setCellValue(record.getR0220_1_3years().doubleValue());
						R0220cell13.setCellStyle(numberStyle);
					} else {
						R0220cell13.setCellValue("");
						R0220cell13.setCellStyle(textStyle);
					}

//ROW31
//Column O: 
					Cell R0220cell14 = row.createCell(14);
					if (record.getR0220_3_5years() != null) {
						R0220cell14.setCellValue(record.getR0220_3_5years().doubleValue());
						R0220cell14.setCellStyle(numberStyle);
					} else {
						R0220cell14.setCellValue("");
						R0220cell14.setCellStyle(textStyle);
					}

//ROW31
//Column P: 
					Cell R0220cell15 = row.createCell(15);
					if (record.getR0220_5years() != null) {
						R0220cell15.setCellValue(record.getR0220_5years().doubleValue());
						R0220cell15.setCellStyle(numberStyle);
					} else {
						R0220cell15.setCellValue("");
						R0220cell15.setCellStyle(textStyle);
					}

/////ROW32///////////
//ROW32

					row = sheet.getRow(31);

//Column E: 
					Cell R0230cell4 = row.createCell(4);
					if (record.getR0230_overdue() != null) {
						R0230cell4.setCellValue(record.getR0230_overdue().doubleValue());
						R0230cell4.setCellStyle(numberStyle);
					} else {
						R0230cell4.setCellValue("");
						R0230cell4.setCellStyle(textStyle);
					}

//ROW32
//Column F: 
					Cell R0230cell5 = row.createCell(5);
					if (record.getR0230_overdraft() != null) {
						R0230cell5.setCellValue(record.getR0230_overdraft().doubleValue());
						R0230cell5.setCellStyle(numberStyle);
					} else {
						R0230cell5.setCellValue("");
						R0230cell5.setCellStyle(textStyle);
					}

//ROW32
//Column G: 
					Cell R0230cell6 = row.createCell(6);
					if (record.getR0230_0_7days() != null) {
						R0230cell6.setCellValue(record.getR0230_0_7days().doubleValue());
						R0230cell6.setCellStyle(numberStyle);
					} else {
						R0230cell6.setCellValue("");
						R0230cell6.setCellStyle(textStyle);
					}

//ROW32
//Column H: 
					Cell R0230cell7 = row.createCell(7);
					if (record.getR0230_8_14days() != null) {
						R0230cell7.setCellValue(record.getR0230_8_14days().doubleValue());
						R0230cell7.setCellStyle(numberStyle);
					} else {
						R0230cell7.setCellValue("");
						R0230cell7.setCellStyle(textStyle);
					}

//ROW32
//Column I: 
					Cell R0230cell8 = row.createCell(8);
					if (record.getR0230_15days_1months() != null) {
						R0230cell8.setCellValue(record.getR0230_15days_1months().doubleValue());
						R0230cell8.setCellStyle(numberStyle);
					} else {
						R0230cell8.setCellValue("");
						R0230cell8.setCellStyle(textStyle);
					}

//ROW32
//Column J: 
					Cell R0230cell9 = row.createCell(9);
					if (record.getR0230_1_2months() != null) {
						R0230cell9.setCellValue(record.getR0230_1_2months().doubleValue());
						R0230cell9.setCellStyle(numberStyle);
					} else {
						R0230cell9.setCellValue("");
						R0230cell9.setCellStyle(textStyle);
					}

//ROW32
//Column K: 
					Cell R0230cell10 = row.createCell(10);
					if (record.getR0230_2_3months() != null) {
						R0230cell10.setCellValue(record.getR0230_2_3months().doubleValue());
						R0230cell10.setCellStyle(numberStyle);
					} else {
						R0230cell10.setCellValue("");
						R0230cell10.setCellStyle(textStyle);
					}

//ROW32
//Column L: 
					Cell R0230cell11 = row.createCell(11);
					if (record.getR0230_3_6months() != null) {
						R0230cell11.setCellValue(record.getR0230_3_6months().doubleValue());
						R0230cell11.setCellStyle(numberStyle);
					} else {
						R0230cell11.setCellValue("");
						R0230cell11.setCellStyle(textStyle);
					}

//ROW32
//Column M: 
					Cell R0230cell12 = row.createCell(12);
					if (record.getR0230_6_12months() != null) {
						R0230cell12.setCellValue(record.getR0230_6_12months().doubleValue());
						R0230cell12.setCellStyle(numberStyle);
					} else {
						R0230cell12.setCellValue("");
						R0230cell12.setCellStyle(textStyle);
					}

//ROW32
//Column N: 
					Cell R0230cell13 = row.createCell(13);
					if (record.getR0230_1_3years() != null) {
						R0230cell13.setCellValue(record.getR0230_1_3years().doubleValue());
						R0230cell13.setCellStyle(numberStyle);
					} else {
						R0230cell13.setCellValue("");
						R0230cell13.setCellStyle(textStyle);
					}

//ROW32
//Column O: 
					Cell R0230cell14 = row.createCell(14);
					if (record.getR0230_3_5years() != null) {
						R0230cell14.setCellValue(record.getR0230_3_5years().doubleValue());
						R0230cell14.setCellStyle(numberStyle);
					} else {
						R0230cell14.setCellValue("");
						R0230cell14.setCellStyle(textStyle);
					}

//ROW32
//Column P: 
					Cell R0230cell15 = row.createCell(15);
					if (record.getR0230_5years() != null) {
						R0230cell15.setCellValue(record.getR0230_5years().doubleValue());
						R0230cell15.setCellStyle(numberStyle);
					} else {
						R0230cell15.setCellValue("");
						R0230cell15.setCellStyle(textStyle);
					}

/////ROW33///////////
//ROW33

					row = sheet.getRow(32);

//Column E: 
					Cell R0240cell4 = row.createCell(4);
					if (record.getR0240_overdue() != null) {
						R0240cell4.setCellValue(record.getR0240_overdue().doubleValue());
						R0240cell4.setCellStyle(numberStyle);
					} else {
						R0240cell4.setCellValue("");
						R0240cell4.setCellStyle(textStyle);
					}

//ROW33
//Column F: 
					Cell R0240cell5 = row.createCell(5);
					if (record.getR0240_overdraft() != null) {
						R0240cell5.setCellValue(record.getR0240_overdraft().doubleValue());
						R0240cell5.setCellStyle(numberStyle);
					} else {
						R0240cell5.setCellValue("");
						R0240cell5.setCellStyle(textStyle);
					}

//ROW33
//Column G: 
					Cell R0240cell6 = row.createCell(6);
					if (record.getR0240_0_7days() != null) {
						R0240cell6.setCellValue(record.getR0240_0_7days().doubleValue());
						R0240cell6.setCellStyle(numberStyle);
					} else {
						R0240cell6.setCellValue("");
						R0240cell6.setCellStyle(textStyle);
					}

//ROW33
//Column H: 
					Cell R0240cell7 = row.createCell(7);
					if (record.getR0240_8_14days() != null) {
						R0240cell7.setCellValue(record.getR0240_8_14days().doubleValue());
						R0240cell7.setCellStyle(numberStyle);
					} else {
						R0240cell7.setCellValue("");
						R0240cell7.setCellStyle(textStyle);
					}

//ROW33
//Column I: 
					Cell R0240cell8 = row.createCell(8);
					if (record.getR0240_15days_1months() != null) {
						R0240cell8.setCellValue(record.getR0240_15days_1months().doubleValue());
						R0240cell8.setCellStyle(numberStyle);
					} else {
						R0240cell8.setCellValue("");
						R0240cell8.setCellStyle(textStyle);
					}

//ROW33
//Column J: 
					Cell R0240cell9 = row.createCell(9);
					if (record.getR0240_1_2months() != null) {
						R0240cell9.setCellValue(record.getR0240_1_2months().doubleValue());
						R0240cell9.setCellStyle(numberStyle);
					} else {
						R0240cell9.setCellValue("");
						R0240cell9.setCellStyle(textStyle);
					}

//ROW33
//Column K: 
					Cell R0240cell10 = row.createCell(10);
					if (record.getR0240_2_3months() != null) {
						R0240cell10.setCellValue(record.getR0240_2_3months().doubleValue());
						R0240cell10.setCellStyle(numberStyle);
					} else {
						R0240cell10.setCellValue("");
						R0240cell10.setCellStyle(textStyle);
					}

//ROW33
//Column L: 
					Cell R0240cell11 = row.createCell(11);
					if (record.getR0240_3_6months() != null) {
						R0240cell11.setCellValue(record.getR0240_3_6months().doubleValue());
						R0240cell11.setCellStyle(numberStyle);
					} else {
						R0240cell11.setCellValue("");
						R0240cell11.setCellStyle(textStyle);
					}

//ROW33
//Column M: 
					Cell R0240cell12 = row.createCell(12);
					if (record.getR0240_6_12months() != null) {
						R0240cell12.setCellValue(record.getR0240_6_12months().doubleValue());
						R0240cell12.setCellStyle(numberStyle);
					} else {
						R0240cell12.setCellValue("");
						R0240cell12.setCellStyle(textStyle);
					}

//ROW33
//Column N: 
					Cell R0240cell13 = row.createCell(13);
					if (record.getR0240_1_3years() != null) {
						R0240cell13.setCellValue(record.getR0240_1_3years().doubleValue());
						R0240cell13.setCellStyle(numberStyle);
					} else {
						R0240cell13.setCellValue("");
						R0240cell13.setCellStyle(textStyle);
					}

//ROW33
//Column O: 
					Cell R0240cell14 = row.createCell(14);
					if (record.getR0240_3_5years() != null) {
						R0240cell14.setCellValue(record.getR0240_3_5years().doubleValue());
						R0240cell14.setCellStyle(numberStyle);
					} else {
						R0240cell14.setCellValue("");
						R0240cell14.setCellStyle(textStyle);
					}

//ROW33
//Column P: 
					Cell R0240cell15 = row.createCell(15);
					if (record.getR0240_5years() != null) {
						R0240cell15.setCellValue(record.getR0240_5years().doubleValue());
						R0240cell15.setCellStyle(numberStyle);
					} else {
						R0240cell15.setCellValue("");
						R0240cell15.setCellStyle(textStyle);
					}

/////ROW34///////////
//ROW34

					row = sheet.getRow(33);

//Column E: 
					Cell R0250cell4 = row.createCell(4);
					if (record.getR0250_overdue() != null) {
						R0250cell4.setCellValue(record.getR0250_overdue().doubleValue());
						R0250cell4.setCellStyle(numberStyle);
					} else {
						R0250cell4.setCellValue("");
						R0250cell4.setCellStyle(textStyle);
					}

//ROW34
//Column F: 
					Cell R0250cell5 = row.createCell(5);
					if (record.getR0250_overdraft() != null) {
						R0250cell5.setCellValue(record.getR0250_overdraft().doubleValue());
						R0250cell5.setCellStyle(numberStyle);
					} else {
						R0250cell5.setCellValue("");
						R0250cell5.setCellStyle(textStyle);
					}

//ROW34
//Column G: 
					Cell R0250cell6 = row.createCell(6);
					if (record.getR0250_0_7days() != null) {
						R0250cell6.setCellValue(record.getR0250_0_7days().doubleValue());
						R0250cell6.setCellStyle(numberStyle);
					} else {
						R0250cell6.setCellValue("");
						R0250cell6.setCellStyle(textStyle);
					}

//ROW34
//Column H: 
					Cell R0250cell7 = row.createCell(7);
					if (record.getR0250_8_14days() != null) {
						R0250cell7.setCellValue(record.getR0250_8_14days().doubleValue());
						R0250cell7.setCellStyle(numberStyle);
					} else {
						R0250cell7.setCellValue("");
						R0250cell7.setCellStyle(textStyle);
					}

//ROW34
//Column I: 
					Cell R0250cell8 = row.createCell(8);
					if (record.getR0250_15days_1months() != null) {
						R0250cell8.setCellValue(record.getR0250_15days_1months().doubleValue());
						R0250cell8.setCellStyle(numberStyle);
					} else {
						R0250cell8.setCellValue("");
						R0250cell8.setCellStyle(textStyle);
					}

//ROW34
//Column J: 
					Cell R0250cell9 = row.createCell(9);
					if (record.getR0250_1_2months() != null) {
						R0250cell9.setCellValue(record.getR0250_1_2months().doubleValue());
						R0250cell9.setCellStyle(numberStyle);
					} else {
						R0250cell9.setCellValue("");
						R0250cell9.setCellStyle(textStyle);
					}

//ROW34
//Column K: 
					Cell R0250cell10 = row.createCell(10);
					if (record.getR0250_2_3months() != null) {
						R0250cell10.setCellValue(record.getR0250_2_3months().doubleValue());
						R0250cell10.setCellStyle(numberStyle);
					} else {
						R0250cell10.setCellValue("");
						R0250cell10.setCellStyle(textStyle);
					}

//ROW34
//Column L: 
					Cell R0250cell11 = row.createCell(11);
					if (record.getR0250_3_6months() != null) {
						R0250cell11.setCellValue(record.getR0250_3_6months().doubleValue());
						R0250cell11.setCellStyle(numberStyle);
					} else {
						R0250cell11.setCellValue("");
						R0250cell11.setCellStyle(textStyle);
					}

//ROW34
//Column M: 
					Cell R0250cell12 = row.createCell(12);
					if (record.getR0250_6_12months() != null) {
						R0250cell12.setCellValue(record.getR0250_6_12months().doubleValue());
						R0250cell12.setCellStyle(numberStyle);
					} else {
						R0250cell12.setCellValue("");
						R0250cell12.setCellStyle(textStyle);
					}

//ROW34
//Column N: 
					Cell R0250cell13 = row.createCell(13);
					if (record.getR0250_1_3years() != null) {
						R0250cell13.setCellValue(record.getR0250_1_3years().doubleValue());
						R0250cell13.setCellStyle(numberStyle);
					} else {
						R0250cell13.setCellValue("");
						R0250cell13.setCellStyle(textStyle);
					}

//ROW34
//Column O: 
					Cell R0250cell14 = row.createCell(14);
					if (record.getR0250_3_5years() != null) {
						R0250cell14.setCellValue(record.getR0250_3_5years().doubleValue());
						R0250cell14.setCellStyle(numberStyle);
					} else {
						R0250cell14.setCellValue("");
						R0250cell14.setCellStyle(textStyle);
					}

//ROW34
//Column P: 
					Cell R0250cell15 = row.createCell(15);
					if (record.getR0250_5years() != null) {
						R0250cell15.setCellValue(record.getR0250_5years().doubleValue());
						R0250cell15.setCellStyle(numberStyle);
					} else {
						R0250cell15.setCellValue("");
						R0250cell15.setCellStyle(textStyle);
					}

/////ROW35///////////
//ROW35

					row = sheet.getRow(34);

//Column E: 
					Cell R0260cell4 = row.createCell(4);
					if (record.getR0260_overdue() != null) {
						R0260cell4.setCellValue(record.getR0260_overdue().doubleValue());
						R0260cell4.setCellStyle(numberStyle);
					} else {
						R0260cell4.setCellValue("");
						R0260cell4.setCellStyle(textStyle);
					}

//ROW35
//Column F: 
					Cell R0260cell5 = row.createCell(5);
					if (record.getR0260_overdraft() != null) {
						R0260cell5.setCellValue(record.getR0260_overdraft().doubleValue());
						R0260cell5.setCellStyle(numberStyle);
					} else {
						R0260cell5.setCellValue("");
						R0260cell5.setCellStyle(textStyle);
					}

//ROW35
//Column G: 
					Cell R0260cell6 = row.createCell(6);
					if (record.getR0260_0_7days() != null) {
						R0260cell6.setCellValue(record.getR0260_0_7days().doubleValue());
						R0260cell6.setCellStyle(numberStyle);
					} else {
						R0260cell6.setCellValue("");
						R0260cell6.setCellStyle(textStyle);
					}

//ROW35
//Column H: 
					Cell R0260cell7 = row.createCell(7);
					if (record.getR0260_8_14days() != null) {
						R0260cell7.setCellValue(record.getR0260_8_14days().doubleValue());
						R0260cell7.setCellStyle(numberStyle);
					} else {
						R0260cell7.setCellValue("");
						R0260cell7.setCellStyle(textStyle);
					}

//ROW35
//Column I: 
					Cell R0260cell8 = row.createCell(8);
					if (record.getR0260_15days_1months() != null) {
						R0260cell8.setCellValue(record.getR0260_15days_1months().doubleValue());
						R0260cell8.setCellStyle(numberStyle);
					} else {
						R0260cell8.setCellValue("");
						R0260cell8.setCellStyle(textStyle);
					}

//ROW35
//Column J: 
					Cell R0260cell9 = row.createCell(9);
					if (record.getR0260_1_2months() != null) {
						R0260cell9.setCellValue(record.getR0260_1_2months().doubleValue());
						R0260cell9.setCellStyle(numberStyle);
					} else {
						R0260cell9.setCellValue("");
						R0260cell9.setCellStyle(textStyle);
					}

//ROW35
//Column K: 
					Cell R0260cell10 = row.createCell(10);
					if (record.getR0260_2_3months() != null) {
						R0260cell10.setCellValue(record.getR0260_2_3months().doubleValue());
						R0260cell10.setCellStyle(numberStyle);
					} else {
						R0260cell10.setCellValue("");
						R0260cell10.setCellStyle(textStyle);
					}

//ROW35
//Column L: 
					Cell R0260cell11 = row.createCell(11);
					if (record.getR0260_3_6months() != null) {
						R0260cell11.setCellValue(record.getR0260_3_6months().doubleValue());
						R0260cell11.setCellStyle(numberStyle);
					} else {
						R0260cell11.setCellValue("");
						R0260cell11.setCellStyle(textStyle);
					}

//ROW35
//Column M: 
					Cell R0260cell12 = row.createCell(12);
					if (record.getR0260_6_12months() != null) {
						R0260cell12.setCellValue(record.getR0260_6_12months().doubleValue());
						R0260cell12.setCellStyle(numberStyle);
					} else {
						R0260cell12.setCellValue("");
						R0260cell12.setCellStyle(textStyle);
					}

//ROW35
//Column N: 
					Cell R0260cell13 = row.createCell(13);
					if (record.getR0260_1_3years() != null) {
						R0260cell13.setCellValue(record.getR0260_1_3years().doubleValue());
						R0260cell13.setCellStyle(numberStyle);
					} else {
						R0260cell13.setCellValue("");
						R0260cell13.setCellStyle(textStyle);
					}

//ROW35
//Column O: 
					Cell R0260cell14 = row.createCell(14);
					if (record.getR0260_3_5years() != null) {
						R0260cell14.setCellValue(record.getR0260_3_5years().doubleValue());
						R0260cell14.setCellStyle(numberStyle);
					} else {
						R0260cell14.setCellValue("");
						R0260cell14.setCellStyle(textStyle);
					}

//ROW35
//Column P: 
					Cell R0260cell15 = row.createCell(15);
					if (record.getR0260_5years() != null) {
						R0260cell15.setCellValue(record.getR0260_5years().doubleValue());
						R0260cell15.setCellStyle(numberStyle);
					} else {
						R0260cell15.setCellValue("");
						R0260cell15.setCellStyle(textStyle);
					}

/////ROW36///////////
//ROW36

					row = sheet.getRow(35);

//Column E: 
					Cell R0270cell4 = row.createCell(4);
					if (record.getR0270_overdue() != null) {
						R0270cell4.setCellValue(record.getR0270_overdue().doubleValue());
						R0270cell4.setCellStyle(numberStyle);
					} else {
						R0270cell4.setCellValue("");
						R0270cell4.setCellStyle(textStyle);
					}

//ROW36
//Column F: 
					Cell R0270cell5 = row.createCell(5);
					if (record.getR0270_overdraft() != null) {
						R0270cell5.setCellValue(record.getR0270_overdraft().doubleValue());
						R0270cell5.setCellStyle(numberStyle);
					} else {
						R0270cell5.setCellValue("");
						R0270cell5.setCellStyle(textStyle);
					}

//ROW36
//Column G: 
					Cell R0270cell6 = row.createCell(6);
					if (record.getR0270_0_7days() != null) {
						R0270cell6.setCellValue(record.getR0270_0_7days().doubleValue());
						R0270cell6.setCellStyle(numberStyle);
					} else {
						R0270cell6.setCellValue("");
						R0270cell6.setCellStyle(textStyle);
					}

//ROW36
//Column H: 
					Cell R0270cell7 = row.createCell(7);
					if (record.getR0270_8_14days() != null) {
						R0270cell7.setCellValue(record.getR0270_8_14days().doubleValue());
						R0270cell7.setCellStyle(numberStyle);
					} else {
						R0270cell7.setCellValue("");
						R0270cell7.setCellStyle(textStyle);
					}

//ROW36
//Column I: 
					Cell R0270cell8 = row.createCell(8);
					if (record.getR0270_15days_1months() != null) {
						R0270cell8.setCellValue(record.getR0270_15days_1months().doubleValue());
						R0270cell8.setCellStyle(numberStyle);
					} else {
						R0270cell8.setCellValue("");
						R0270cell8.setCellStyle(textStyle);
					}

//ROW36
//Column J: 
					Cell R0270cell9 = row.createCell(9);
					if (record.getR0270_1_2months() != null) {
						R0270cell9.setCellValue(record.getR0270_1_2months().doubleValue());
						R0270cell9.setCellStyle(numberStyle);
					} else {
						R0270cell9.setCellValue("");
						R0270cell9.setCellStyle(textStyle);
					}

//ROW36
//Column K: 
					Cell R0270cell10 = row.createCell(10);
					if (record.getR0270_2_3months() != null) {
						R0270cell10.setCellValue(record.getR0270_2_3months().doubleValue());
						R0270cell10.setCellStyle(numberStyle);
					} else {
						R0270cell10.setCellValue("");
						R0270cell10.setCellStyle(textStyle);
					}

//ROW36
//Column L: 
					Cell R0270cell11 = row.createCell(11);
					if (record.getR0270_3_6months() != null) {
						R0270cell11.setCellValue(record.getR0270_3_6months().doubleValue());
						R0270cell11.setCellStyle(numberStyle);
					} else {
						R0270cell11.setCellValue("");
						R0270cell11.setCellStyle(textStyle);
					}

//ROW36
//Column M: 
					Cell R0270cell12 = row.createCell(12);
					if (record.getR0270_6_12months() != null) {
						R0270cell12.setCellValue(record.getR0270_6_12months().doubleValue());
						R0270cell12.setCellStyle(numberStyle);
					} else {
						R0270cell12.setCellValue("");
						R0270cell12.setCellStyle(textStyle);
					}

//ROW36
//Column N: 
					Cell R0270cell13 = row.createCell(13);
					if (record.getR0270_1_3years() != null) {
						R0270cell13.setCellValue(record.getR0270_1_3years().doubleValue());
						R0270cell13.setCellStyle(numberStyle);
					} else {
						R0270cell13.setCellValue("");
						R0270cell13.setCellStyle(textStyle);
					}

//ROW36
//Column O: 
					Cell R0270cell14 = row.createCell(14);
					if (record.getR0270_3_5years() != null) {
						R0270cell14.setCellValue(record.getR0270_3_5years().doubleValue());
						R0270cell14.setCellStyle(numberStyle);
					} else {
						R0270cell14.setCellValue("");
						R0270cell14.setCellStyle(textStyle);
					}

//ROW36
//Column P: 
					Cell R0270cell15 = row.createCell(15);
					if (record.getR0270_5years() != null) {
						R0270cell15.setCellValue(record.getR0270_5years().doubleValue());
						R0270cell15.setCellStyle(numberStyle);
					} else {
						R0270cell15.setCellValue("");
						R0270cell15.setCellStyle(textStyle);
					}

/////ROW38///////////
//ROW38

					row = sheet.getRow(37);

//Column E: 
					Cell R0290cell4 = row.createCell(4);
					if (record.getR0290_overdue() != null) {
						R0290cell4.setCellValue(record.getR0290_overdue().doubleValue());
						R0290cell4.setCellStyle(numberStyle);
					} else {
						R0290cell4.setCellValue("");
						R0290cell4.setCellStyle(textStyle);
					}

//ROW38
//Column F: 
					Cell R0290cell5 = row.createCell(5);
					if (record.getR0290_overdraft() != null) {
						R0290cell5.setCellValue(record.getR0290_overdraft().doubleValue());
						R0290cell5.setCellStyle(numberStyle);
					} else {
						R0290cell5.setCellValue("");
						R0290cell5.setCellStyle(textStyle);
					}

//ROW38
//Column G: 
					Cell R0290cell6 = row.createCell(6);
					if (record.getR0290_0_7days() != null) {
						R0290cell6.setCellValue(record.getR0290_0_7days().doubleValue());
						R0290cell6.setCellStyle(numberStyle);
					} else {
						R0290cell6.setCellValue("");
						R0290cell6.setCellStyle(textStyle);
					}

//ROW38
//Column H: 
					Cell R0290cell7 = row.createCell(7);
					if (record.getR0290_8_14days() != null) {
						R0290cell7.setCellValue(record.getR0290_8_14days().doubleValue());
						R0290cell7.setCellStyle(numberStyle);
					} else {
						R0290cell7.setCellValue("");
						R0290cell7.setCellStyle(textStyle);
					}

//ROW38
//Column I: 
					Cell R0290cell8 = row.createCell(8);
					if (record.getR0290_15days_1months() != null) {
						R0290cell8.setCellValue(record.getR0290_15days_1months().doubleValue());
						R0290cell8.setCellStyle(numberStyle);
					} else {
						R0290cell8.setCellValue("");
						R0290cell8.setCellStyle(textStyle);
					}

//ROW38
//Column J: 
					Cell R0290cell9 = row.createCell(9);
					if (record.getR0290_1_2months() != null) {
						R0290cell9.setCellValue(record.getR0290_1_2months().doubleValue());
						R0290cell9.setCellStyle(numberStyle);
					} else {
						R0290cell9.setCellValue("");
						R0290cell9.setCellStyle(textStyle);
					}

//ROW38
//Column K: 
					Cell R0290cell10 = row.createCell(10);
					if (record.getR0290_2_3months() != null) {
						R0290cell10.setCellValue(record.getR0290_2_3months().doubleValue());
						R0290cell10.setCellStyle(numberStyle);
					} else {
						R0290cell10.setCellValue("");
						R0290cell10.setCellStyle(textStyle);
					}

//ROW38
//Column L: 
					Cell R0290cell11 = row.createCell(11);
					if (record.getR0290_3_6months() != null) {
						R0290cell11.setCellValue(record.getR0290_3_6months().doubleValue());
						R0290cell11.setCellStyle(numberStyle);
					} else {
						R0290cell11.setCellValue("");
						R0290cell11.setCellStyle(textStyle);
					}

//ROW38
//Column M: 
					Cell R0290cell12 = row.createCell(12);
					if (record.getR0290_6_12months() != null) {
						R0290cell12.setCellValue(record.getR0290_6_12months().doubleValue());
						R0290cell12.setCellStyle(numberStyle);
					} else {
						R0290cell12.setCellValue("");
						R0290cell12.setCellStyle(textStyle);
					}

//ROW38
//Column N: 
					Cell R0290cell13 = row.createCell(13);
					if (record.getR0290_1_3years() != null) {
						R0290cell13.setCellValue(record.getR0290_1_3years().doubleValue());
						R0290cell13.setCellStyle(numberStyle);
					} else {
						R0290cell13.setCellValue("");
						R0290cell13.setCellStyle(textStyle);
					}

//ROW38
//Column O: 
					Cell R0290cell14 = row.createCell(14);
					if (record.getR0290_3_5years() != null) {
						R0290cell14.setCellValue(record.getR0290_3_5years().doubleValue());
						R0290cell14.setCellStyle(numberStyle);
					} else {
						R0290cell14.setCellValue("");
						R0290cell14.setCellStyle(textStyle);
					}

//ROW38
//Column P: 
					Cell R0290cell15 = row.createCell(15);
					if (record.getR0290_5years() != null) {
						R0290cell15.setCellValue(record.getR0290_5years().doubleValue());
						R0290cell15.setCellStyle(numberStyle);
					} else {
						R0290cell15.setCellValue("");
						R0290cell15.setCellStyle(textStyle);
					}

/////ROW39///////////
//ROW39

					row = sheet.getRow(38);

//Column E: 
					Cell R0300cell4 = row.createCell(4);
					if (record.getR0300_overdue() != null) {
						R0300cell4.setCellValue(record.getR0300_overdue().doubleValue());
						R0300cell4.setCellStyle(numberStyle);
					} else {
						R0300cell4.setCellValue("");
						R0300cell4.setCellStyle(textStyle);
					}

//ROW39
//Column F: 
					Cell R0300cell5 = row.createCell(5);
					if (record.getR0300_overdraft() != null) {
						R0300cell5.setCellValue(record.getR0300_overdraft().doubleValue());
						R0300cell5.setCellStyle(numberStyle);
					} else {
						R0300cell5.setCellValue("");
						R0300cell5.setCellStyle(textStyle);
					}

//ROW39
//Column G: 
					Cell R0300cell6 = row.createCell(6);
					if (record.getR0300_0_7days() != null) {
						R0300cell6.setCellValue(record.getR0300_0_7days().doubleValue());
						R0300cell6.setCellStyle(numberStyle);
					} else {
						R0300cell6.setCellValue("");
						R0300cell6.setCellStyle(textStyle);
					}

//ROW39
//Column H: 
					Cell R0300cell7 = row.createCell(7);
					if (record.getR0300_8_14days() != null) {
						R0300cell7.setCellValue(record.getR0300_8_14days().doubleValue());
						R0300cell7.setCellStyle(numberStyle);
					} else {
						R0300cell7.setCellValue("");
						R0300cell7.setCellStyle(textStyle);
					}

//ROW39
//Column I: 
					Cell R0300cell8 = row.createCell(8);
					if (record.getR0300_15days_1months() != null) {
						R0300cell8.setCellValue(record.getR0300_15days_1months().doubleValue());
						R0300cell8.setCellStyle(numberStyle);
					} else {
						R0300cell8.setCellValue("");
						R0300cell8.setCellStyle(textStyle);
					}

//ROW39
//Column J: 
					Cell R0300cell9 = row.createCell(9);
					if (record.getR0300_1_2months() != null) {
						R0300cell9.setCellValue(record.getR0300_1_2months().doubleValue());
						R0300cell9.setCellStyle(numberStyle);
					} else {
						R0300cell9.setCellValue("");
						R0300cell9.setCellStyle(textStyle);
					}

//ROW39
//Column K: 
					Cell R0300cell10 = row.createCell(10);
					if (record.getR0300_2_3months() != null) {
						R0300cell10.setCellValue(record.getR0300_2_3months().doubleValue());
						R0300cell10.setCellStyle(numberStyle);
					} else {
						R0300cell10.setCellValue("");
						R0300cell10.setCellStyle(textStyle);
					}

//ROW39
//Column L: 
					Cell R0300cell11 = row.createCell(11);
					if (record.getR0300_3_6months() != null) {
						R0300cell11.setCellValue(record.getR0300_3_6months().doubleValue());
						R0300cell11.setCellStyle(numberStyle);
					} else {
						R0300cell11.setCellValue("");
						R0300cell11.setCellStyle(textStyle);
					}

//ROW39
//Column M: 
					Cell R0300cell12 = row.createCell(12);
					if (record.getR0300_6_12months() != null) {
						R0300cell12.setCellValue(record.getR0300_6_12months().doubleValue());
						R0300cell12.setCellStyle(numberStyle);
					} else {
						R0300cell12.setCellValue("");
						R0300cell12.setCellStyle(textStyle);
					}

//ROW39
//Column N: 
					Cell R0300cell13 = row.createCell(13);
					if (record.getR0300_1_3years() != null) {
						R0300cell13.setCellValue(record.getR0300_1_3years().doubleValue());
						R0300cell13.setCellStyle(numberStyle);
					} else {
						R0300cell13.setCellValue("");
						R0300cell13.setCellStyle(textStyle);
					}

//ROW39
//Column O: 
					Cell R0300cell14 = row.createCell(14);
					if (record.getR0300_3_5years() != null) {
						R0300cell14.setCellValue(record.getR0300_3_5years().doubleValue());
						R0300cell14.setCellStyle(numberStyle);
					} else {
						R0300cell14.setCellValue("");
						R0300cell14.setCellStyle(textStyle);
					}

//ROW39
//Column P: 
					Cell R0300cell15 = row.createCell(15);
					if (record.getR0300_5years() != null) {
						R0300cell15.setCellValue(record.getR0300_5years().doubleValue());
						R0300cell15.setCellStyle(numberStyle);
					} else {
						R0300cell15.setCellValue("");
						R0300cell15.setCellStyle(textStyle);
					}

/////ROW40///////////
//ROW40

					row = sheet.getRow(39);

//Column E: 
					Cell R0310cell4 = row.createCell(4);
					if (record.getR0310_overdue() != null) {
						R0310cell4.setCellValue(record.getR0310_overdue().doubleValue());
						R0310cell4.setCellStyle(numberStyle);
					} else {
						R0310cell4.setCellValue("");
						R0310cell4.setCellStyle(textStyle);
					}

//ROW40
//Column F: 
					Cell R0310cell5 = row.createCell(5);
					if (record.getR0310_overdraft() != null) {
						R0310cell5.setCellValue(record.getR0310_overdraft().doubleValue());
						R0310cell5.setCellStyle(numberStyle);
					} else {
						R0310cell5.setCellValue("");
						R0310cell5.setCellStyle(textStyle);
					}

//ROW40
//Column G: 
					Cell R0310cell6 = row.createCell(6);
					if (record.getR0310_0_7days() != null) {
						R0310cell6.setCellValue(record.getR0310_0_7days().doubleValue());
						R0310cell6.setCellStyle(numberStyle);
					} else {
						R0310cell6.setCellValue("");
						R0310cell6.setCellStyle(textStyle);
					}

//ROW40
//Column H: 
					Cell R0310cell7 = row.createCell(7);
					if (record.getR0310_8_14days() != null) {
						R0310cell7.setCellValue(record.getR0310_8_14days().doubleValue());
						R0310cell7.setCellStyle(numberStyle);
					} else {
						R0310cell7.setCellValue("");
						R0310cell7.setCellStyle(textStyle);
					}

//ROW40
//Column I: 
					Cell R0310cell8 = row.createCell(8);
					if (record.getR0310_15days_1months() != null) {
						R0310cell8.setCellValue(record.getR0310_15days_1months().doubleValue());
						R0310cell8.setCellStyle(numberStyle);
					} else {
						R0310cell8.setCellValue("");
						R0310cell8.setCellStyle(textStyle);
					}

//ROW40
//Column J: 
					Cell R0310cell9 = row.createCell(9);
					if (record.getR0310_1_2months() != null) {
						R0310cell9.setCellValue(record.getR0310_1_2months().doubleValue());
						R0310cell9.setCellStyle(numberStyle);
					} else {
						R0310cell9.setCellValue("");
						R0310cell9.setCellStyle(textStyle);
					}

//ROW40
//Column K: 
					Cell R0310cell10 = row.createCell(10);
					if (record.getR0310_2_3months() != null) {
						R0310cell10.setCellValue(record.getR0310_2_3months().doubleValue());
						R0310cell10.setCellStyle(numberStyle);
					} else {
						R0310cell10.setCellValue("");
						R0310cell10.setCellStyle(textStyle);
					}

//ROW40
//Column L: 
					Cell R0310cell11 = row.createCell(11);
					if (record.getR0310_3_6months() != null) {
						R0310cell11.setCellValue(record.getR0310_3_6months().doubleValue());
						R0310cell11.setCellStyle(numberStyle);
					} else {
						R0310cell11.setCellValue("");
						R0310cell11.setCellStyle(textStyle);
					}

//ROW40
//Column M: 
					Cell R0310cell12 = row.createCell(12);
					if (record.getR0310_6_12months() != null) {
						R0310cell12.setCellValue(record.getR0310_6_12months().doubleValue());
						R0310cell12.setCellStyle(numberStyle);
					} else {
						R0310cell12.setCellValue("");
						R0310cell12.setCellStyle(textStyle);
					}

//ROW40
//Column N: 
					Cell R0310cell13 = row.createCell(13);
					if (record.getR0310_1_3years() != null) {
						R0310cell13.setCellValue(record.getR0310_1_3years().doubleValue());
						R0310cell13.setCellStyle(numberStyle);
					} else {
						R0310cell13.setCellValue("");
						R0310cell13.setCellStyle(textStyle);
					}

//ROW40
//Column O: 
					Cell R0310cell14 = row.createCell(14);
					if (record.getR0310_3_5years() != null) {
						R0310cell14.setCellValue(record.getR0310_3_5years().doubleValue());
						R0310cell14.setCellStyle(numberStyle);
					} else {
						R0310cell14.setCellValue("");
						R0310cell14.setCellStyle(textStyle);
					}

//ROW40
//Column P: 
					Cell R0310cell15 = row.createCell(15);
					if (record.getR0310_5years() != null) {
						R0310cell15.setCellValue(record.getR0310_5years().doubleValue());
						R0310cell15.setCellStyle(numberStyle);
					} else {
						R0310cell15.setCellValue("");
						R0310cell15.setCellStyle(textStyle);
					}

/////ROW41///////////
//ROW41

					row = sheet.getRow(40);

//Column E: 
					Cell R0320cell4 = row.createCell(4);
					if (record.getR0320_overdue() != null) {
						R0320cell4.setCellValue(record.getR0320_overdue().doubleValue());
						R0320cell4.setCellStyle(numberStyle);
					} else {
						R0320cell4.setCellValue("");
						R0320cell4.setCellStyle(textStyle);
					}

//ROW41
//Column F: 
					Cell R0320cell5 = row.createCell(5);
					if (record.getR0320_overdraft() != null) {
						R0320cell5.setCellValue(record.getR0320_overdraft().doubleValue());
						R0320cell5.setCellStyle(numberStyle);
					} else {
						R0320cell5.setCellValue("");
						R0320cell5.setCellStyle(textStyle);
					}

//ROW41
//Column G: 
					Cell R0320cell6 = row.createCell(6);
					if (record.getR0320_0_7days() != null) {
						R0320cell6.setCellValue(record.getR0320_0_7days().doubleValue());
						R0320cell6.setCellStyle(numberStyle);
					} else {
						R0320cell6.setCellValue("");
						R0320cell6.setCellStyle(textStyle);
					}

//ROW41
//Column H: 
					Cell R0320cell7 = row.createCell(7);
					if (record.getR0320_8_14days() != null) {
						R0320cell7.setCellValue(record.getR0320_8_14days().doubleValue());
						R0320cell7.setCellStyle(numberStyle);
					} else {
						R0320cell7.setCellValue("");
						R0320cell7.setCellStyle(textStyle);
					}

//ROW41
//Column I: 
					Cell R0320cell8 = row.createCell(8);
					if (record.getR0320_15days_1months() != null) {
						R0320cell8.setCellValue(record.getR0320_15days_1months().doubleValue());
						R0320cell8.setCellStyle(numberStyle);
					} else {
						R0320cell8.setCellValue("");
						R0320cell8.setCellStyle(textStyle);
					}

//ROW41
//Column J: 
					Cell R0320cell9 = row.createCell(9);
					if (record.getR0320_1_2months() != null) {
						R0320cell9.setCellValue(record.getR0320_1_2months().doubleValue());
						R0320cell9.setCellStyle(numberStyle);
					} else {
						R0320cell9.setCellValue("");
						R0320cell9.setCellStyle(textStyle);
					}

//ROW41
//Column K: 
					Cell R0320cell10 = row.createCell(10);
					if (record.getR0320_2_3months() != null) {
						R0320cell10.setCellValue(record.getR0320_2_3months().doubleValue());
						R0320cell10.setCellStyle(numberStyle);
					} else {
						R0320cell10.setCellValue("");
						R0320cell10.setCellStyle(textStyle);
					}

//ROW41
//Column L: 
					Cell R0320cell11 = row.createCell(11);
					if (record.getR0320_3_6months() != null) {
						R0320cell11.setCellValue(record.getR0320_3_6months().doubleValue());
						R0320cell11.setCellStyle(numberStyle);
					} else {
						R0320cell11.setCellValue("");
						R0320cell11.setCellStyle(textStyle);
					}

//ROW41
//Column M: 
					Cell R0320cell12 = row.createCell(12);
					if (record.getR0320_6_12months() != null) {
						R0320cell12.setCellValue(record.getR0320_6_12months().doubleValue());
						R0320cell12.setCellStyle(numberStyle);
					} else {
						R0320cell12.setCellValue("");
						R0320cell12.setCellStyle(textStyle);
					}

//ROW41
//Column N: 
					Cell R0320cell13 = row.createCell(13);
					if (record.getR0320_1_3years() != null) {
						R0320cell13.setCellValue(record.getR0320_1_3years().doubleValue());
						R0320cell13.setCellStyle(numberStyle);
					} else {
						R0320cell13.setCellValue("");
						R0320cell13.setCellStyle(textStyle);
					}

//ROW41
//Column O: 
					Cell R0320cell14 = row.createCell(14);
					if (record.getR0320_3_5years() != null) {
						R0320cell14.setCellValue(record.getR0320_3_5years().doubleValue());
						R0320cell14.setCellStyle(numberStyle);
					} else {
						R0320cell14.setCellValue("");
						R0320cell14.setCellStyle(textStyle);
					}

//ROW41
//Column P: 
					Cell R0320cell15 = row.createCell(15);
					if (record.getR0320_5years() != null) {
						R0320cell15.setCellValue(record.getR0320_5years().doubleValue());
						R0320cell15.setCellStyle(numberStyle);
					} else {
						R0320cell15.setCellValue("");
						R0320cell15.setCellStyle(textStyle);
					}

/////ROW42///////////
//ROW42

					row = sheet.getRow(41);

//Column E: 
					Cell R0330cell4 = row.createCell(4);
					if (record.getR0330_overdue() != null) {
						R0330cell4.setCellValue(record.getR0330_overdue().doubleValue());
						R0330cell4.setCellStyle(numberStyle);
					} else {
						R0330cell4.setCellValue("");
						R0330cell4.setCellStyle(textStyle);
					}

//ROW42
//Column F: 
					Cell R0330cell5 = row.createCell(5);
					if (record.getR0330_overdraft() != null) {
						R0330cell5.setCellValue(record.getR0330_overdraft().doubleValue());
						R0330cell5.setCellStyle(numberStyle);
					} else {
						R0330cell5.setCellValue("");
						R0330cell5.setCellStyle(textStyle);
					}

//ROW42
//Column G: 
					Cell R0330cell6 = row.createCell(6);
					if (record.getR0330_0_7days() != null) {
						R0330cell6.setCellValue(record.getR0330_0_7days().doubleValue());
						R0330cell6.setCellStyle(numberStyle);
					} else {
						R0330cell6.setCellValue("");
						R0330cell6.setCellStyle(textStyle);
					}

//ROW42
//Column H: 
					Cell R0330cell7 = row.createCell(7);
					if (record.getR0330_8_14days() != null) {
						R0330cell7.setCellValue(record.getR0330_8_14days().doubleValue());
						R0330cell7.setCellStyle(numberStyle);
					} else {
						R0330cell7.setCellValue("");
						R0330cell7.setCellStyle(textStyle);
					}

//ROW42
//Column I: 
					Cell R0330cell8 = row.createCell(8);
					if (record.getR0330_15days_1months() != null) {
						R0330cell8.setCellValue(record.getR0330_15days_1months().doubleValue());
						R0330cell8.setCellStyle(numberStyle);
					} else {
						R0330cell8.setCellValue("");
						R0330cell8.setCellStyle(textStyle);
					}

//ROW42
//Column J: 
					Cell R0330cell9 = row.createCell(9);
					if (record.getR0330_1_2months() != null) {
						R0330cell9.setCellValue(record.getR0330_1_2months().doubleValue());
						R0330cell9.setCellStyle(numberStyle);
					} else {
						R0330cell9.setCellValue("");
						R0330cell9.setCellStyle(textStyle);
					}

//ROW42
//Column K: 
					Cell R0330cell10 = row.createCell(10);
					if (record.getR0330_2_3months() != null) {
						R0330cell10.setCellValue(record.getR0330_2_3months().doubleValue());
						R0330cell10.setCellStyle(numberStyle);
					} else {
						R0330cell10.setCellValue("");
						R0330cell10.setCellStyle(textStyle);
					}

//ROW42
//Column L: 
					Cell R0330cell11 = row.createCell(11);
					if (record.getR0330_3_6months() != null) {
						R0330cell11.setCellValue(record.getR0330_3_6months().doubleValue());
						R0330cell11.setCellStyle(numberStyle);
					} else {
						R0330cell11.setCellValue("");
						R0330cell11.setCellStyle(textStyle);
					}

//ROW42
//Column M: 
					Cell R0330cell12 = row.createCell(12);
					if (record.getR0330_6_12months() != null) {
						R0330cell12.setCellValue(record.getR0330_6_12months().doubleValue());
						R0330cell12.setCellStyle(numberStyle);
					} else {
						R0330cell12.setCellValue("");
						R0330cell12.setCellStyle(textStyle);
					}

//ROW42
//Column N: 
					Cell R0330cell13 = row.createCell(13);
					if (record.getR0330_1_3years() != null) {
						R0330cell13.setCellValue(record.getR0330_1_3years().doubleValue());
						R0330cell13.setCellStyle(numberStyle);
					} else {
						R0330cell13.setCellValue("");
						R0330cell13.setCellStyle(textStyle);
					}

//ROW42
//Column O: 
					Cell R0330cell14 = row.createCell(14);
					if (record.getR0330_3_5years() != null) {
						R0330cell14.setCellValue(record.getR0330_3_5years().doubleValue());
						R0330cell14.setCellStyle(numberStyle);
					} else {
						R0330cell14.setCellValue("");
						R0330cell14.setCellStyle(textStyle);
					}

//ROW42
//Column P: 
					Cell R0330cell15 = row.createCell(15);
					if (record.getR0330_5years() != null) {
						R0330cell15.setCellValue(record.getR0330_5years().doubleValue());
						R0330cell15.setCellStyle(numberStyle);
					} else {
						R0330cell15.setCellValue("");
						R0330cell15.setCellStyle(textStyle);
					}

/////ROW43///////////
//ROW43

					row = sheet.getRow(42);

//Column E: 
					Cell R0340cell4 = row.createCell(4);
					if (record.getR0340_overdue() != null) {
						R0340cell4.setCellValue(record.getR0340_overdue().doubleValue());
						R0340cell4.setCellStyle(numberStyle);
					} else {
						R0340cell4.setCellValue("");
						R0340cell4.setCellStyle(textStyle);
					}

//ROW43
//Column F: 
					Cell R0340cell5 = row.createCell(5);
					if (record.getR0340_overdraft() != null) {
						R0340cell5.setCellValue(record.getR0340_overdraft().doubleValue());
						R0340cell5.setCellStyle(numberStyle);
					} else {
						R0340cell5.setCellValue("");
						R0340cell5.setCellStyle(textStyle);
					}

//ROW43
//Column G: 
					Cell R0340cell6 = row.createCell(6);
					if (record.getR0340_0_7days() != null) {
						R0340cell6.setCellValue(record.getR0340_0_7days().doubleValue());
						R0340cell6.setCellStyle(numberStyle);
					} else {
						R0340cell6.setCellValue("");
						R0340cell6.setCellStyle(textStyle);
					}

//ROW43
//Column H: 
					Cell R0340cell7 = row.createCell(7);
					if (record.getR0340_8_14days() != null) {
						R0340cell7.setCellValue(record.getR0340_8_14days().doubleValue());
						R0340cell7.setCellStyle(numberStyle);
					} else {
						R0340cell7.setCellValue("");
						R0340cell7.setCellStyle(textStyle);
					}

//ROW43
//Column I: 
					Cell R0340cell8 = row.createCell(8);
					if (record.getR0340_15days_1months() != null) {
						R0340cell8.setCellValue(record.getR0340_15days_1months().doubleValue());
						R0340cell8.setCellStyle(numberStyle);
					} else {
						R0340cell8.setCellValue("");
						R0340cell8.setCellStyle(textStyle);
					}

//ROW43
//Column J: 
					Cell R0340cell9 = row.createCell(9);
					if (record.getR0340_1_2months() != null) {
						R0340cell9.setCellValue(record.getR0340_1_2months().doubleValue());
						R0340cell9.setCellStyle(numberStyle);
					} else {
						R0340cell9.setCellValue("");
						R0340cell9.setCellStyle(textStyle);
					}

//ROW43
//Column K: 
					Cell R0340cell10 = row.createCell(10);
					if (record.getR0340_2_3months() != null) {
						R0340cell10.setCellValue(record.getR0340_2_3months().doubleValue());
						R0340cell10.setCellStyle(numberStyle);
					} else {
						R0340cell10.setCellValue("");
						R0340cell10.setCellStyle(textStyle);
					}

//ROW43
//Column L: 
					Cell R0340cell11 = row.createCell(11);
					if (record.getR0340_3_6months() != null) {
						R0340cell11.setCellValue(record.getR0340_3_6months().doubleValue());
						R0340cell11.setCellStyle(numberStyle);
					} else {
						R0340cell11.setCellValue("");
						R0340cell11.setCellStyle(textStyle);
					}

//ROW43
//Column M: 
					Cell R0340cell12 = row.createCell(12);
					if (record.getR0340_6_12months() != null) {
						R0340cell12.setCellValue(record.getR0340_6_12months().doubleValue());
						R0340cell12.setCellStyle(numberStyle);
					} else {
						R0340cell12.setCellValue("");
						R0340cell12.setCellStyle(textStyle);
					}

//ROW43
//Column N: 
					Cell R0340cell13 = row.createCell(13);
					if (record.getR0340_1_3years() != null) {
						R0340cell13.setCellValue(record.getR0340_1_3years().doubleValue());
						R0340cell13.setCellStyle(numberStyle);
					} else {
						R0340cell13.setCellValue("");
						R0340cell13.setCellStyle(textStyle);
					}

//ROW43
//Column O: 
					Cell R0340cell14 = row.createCell(14);
					if (record.getR0340_3_5years() != null) {
						R0340cell14.setCellValue(record.getR0340_3_5years().doubleValue());
						R0340cell14.setCellStyle(numberStyle);
					} else {
						R0340cell14.setCellValue("");
						R0340cell14.setCellStyle(textStyle);
					}

//ROW43
//Column P: 
					Cell R0340cell15 = row.createCell(15);
					if (record.getR0340_5years() != null) {
						R0340cell15.setCellValue(record.getR0340_5years().doubleValue());
						R0340cell15.setCellStyle(numberStyle);
					} else {
						R0340cell15.setCellValue("");
						R0340cell15.setCellStyle(textStyle);
					}

/////ROW44///////////
//ROW44

					row = sheet.getRow(43);

//Column E: 
					Cell R0350cell4 = row.createCell(4);
					if (record.getR0350_overdue() != null) {
						R0350cell4.setCellValue(record.getR0350_overdue().doubleValue());
						R0350cell4.setCellStyle(numberStyle);
					} else {
						R0350cell4.setCellValue("");
						R0350cell4.setCellStyle(textStyle);
					}

//ROW44
//Column F: 
					Cell R0350cell5 = row.createCell(5);
					if (record.getR0350_overdraft() != null) {
						R0350cell5.setCellValue(record.getR0350_overdraft().doubleValue());
						R0350cell5.setCellStyle(numberStyle);
					} else {
						R0350cell5.setCellValue("");
						R0350cell5.setCellStyle(textStyle);
					}

//ROW44
//Column G: 
					Cell R0350cell6 = row.createCell(6);
					if (record.getR0350_0_7days() != null) {
						R0350cell6.setCellValue(record.getR0350_0_7days().doubleValue());
						R0350cell6.setCellStyle(numberStyle);
					} else {
						R0350cell6.setCellValue("");
						R0350cell6.setCellStyle(textStyle);
					}

//ROW44
//Column H: 
					Cell R0350cell7 = row.createCell(7);
					if (record.getR0350_8_14days() != null) {
						R0350cell7.setCellValue(record.getR0350_8_14days().doubleValue());
						R0350cell7.setCellStyle(numberStyle);
					} else {
						R0350cell7.setCellValue("");
						R0350cell7.setCellStyle(textStyle);
					}

//ROW44
//Column I: 
					Cell R0350cell8 = row.createCell(8);
					if (record.getR0350_15days_1months() != null) {
						R0350cell8.setCellValue(record.getR0350_15days_1months().doubleValue());
						R0350cell8.setCellStyle(numberStyle);
					} else {
						R0350cell8.setCellValue("");
						R0350cell8.setCellStyle(textStyle);
					}

//ROW44
//Column J: 
					Cell R0350cell9 = row.createCell(9);
					if (record.getR0350_1_2months() != null) {
						R0350cell9.setCellValue(record.getR0350_1_2months().doubleValue());
						R0350cell9.setCellStyle(numberStyle);
					} else {
						R0350cell9.setCellValue("");
						R0350cell9.setCellStyle(textStyle);
					}

//ROW44
//Column K: 
					Cell R0350cell10 = row.createCell(10);
					if (record.getR0350_2_3months() != null) {
						R0350cell10.setCellValue(record.getR0350_2_3months().doubleValue());
						R0350cell10.setCellStyle(numberStyle);
					} else {
						R0350cell10.setCellValue("");
						R0350cell10.setCellStyle(textStyle);
					}

//ROW44
//Column L: 
					Cell R0350cell11 = row.createCell(11);
					if (record.getR0350_3_6months() != null) {
						R0350cell11.setCellValue(record.getR0350_3_6months().doubleValue());
						R0350cell11.setCellStyle(numberStyle);
					} else {
						R0350cell11.setCellValue("");
						R0350cell11.setCellStyle(textStyle);
					}

//ROW44
//Column M: 
					Cell R0350cell12 = row.createCell(12);
					if (record.getR0350_6_12months() != null) {
						R0350cell12.setCellValue(record.getR0350_6_12months().doubleValue());
						R0350cell12.setCellStyle(numberStyle);
					} else {
						R0350cell12.setCellValue("");
						R0350cell12.setCellStyle(textStyle);
					}

//ROW44
//Column N: 
					Cell R0350cell13 = row.createCell(13);
					if (record.getR0350_1_3years() != null) {
						R0350cell13.setCellValue(record.getR0350_1_3years().doubleValue());
						R0350cell13.setCellStyle(numberStyle);
					} else {
						R0350cell13.setCellValue("");
						R0350cell13.setCellStyle(textStyle);
					}

//ROW44
//Column O: 
					Cell R0350cell14 = row.createCell(14);
					if (record.getR0350_3_5years() != null) {
						R0350cell14.setCellValue(record.getR0350_3_5years().doubleValue());
						R0350cell14.setCellStyle(numberStyle);
					} else {
						R0350cell14.setCellValue("");
						R0350cell14.setCellStyle(textStyle);
					}

//ROW44
//Column P: 
					Cell R0350cell15 = row.createCell(15);
					if (record.getR0350_5years() != null) {
						R0350cell15.setCellValue(record.getR0350_5years().doubleValue());
						R0350cell15.setCellStyle(numberStyle);
					} else {
						R0350cell15.setCellValue("");
						R0350cell15.setCellStyle(textStyle);
					}

/////ROW45///////////
//ROW45

					row = sheet.getRow(44);

//Column E: 
					Cell R0360cell4 = row.createCell(4);
					if (record.getR0360_overdue() != null) {
						R0360cell4.setCellValue(record.getR0360_overdue().doubleValue());
						R0360cell4.setCellStyle(numberStyle);
					} else {
						R0360cell4.setCellValue("");
						R0360cell4.setCellStyle(textStyle);
					}

//ROW45
//Column F: 
					Cell R0360cell5 = row.createCell(5);
					if (record.getR0360_overdraft() != null) {
						R0360cell5.setCellValue(record.getR0360_overdraft().doubleValue());
						R0360cell5.setCellStyle(numberStyle);
					} else {
						R0360cell5.setCellValue("");
						R0360cell5.setCellStyle(textStyle);
					}

//ROW45
//Column G: 
					Cell R0360cell6 = row.createCell(6);
					if (record.getR0360_0_7days() != null) {
						R0360cell6.setCellValue(record.getR0360_0_7days().doubleValue());
						R0360cell6.setCellStyle(numberStyle);
					} else {
						R0360cell6.setCellValue("");
						R0360cell6.setCellStyle(textStyle);
					}

//ROW45
//Column H: 
					Cell R0360cell7 = row.createCell(7);
					if (record.getR0360_8_14days() != null) {
						R0360cell7.setCellValue(record.getR0360_8_14days().doubleValue());
						R0360cell7.setCellStyle(numberStyle);
					} else {
						R0360cell7.setCellValue("");
						R0360cell7.setCellStyle(textStyle);
					}

//ROW45
//Column I: 
					Cell R0360cell8 = row.createCell(8);
					if (record.getR0360_15days_1months() != null) {
						R0360cell8.setCellValue(record.getR0360_15days_1months().doubleValue());
						R0360cell8.setCellStyle(numberStyle);
					} else {
						R0360cell8.setCellValue("");
						R0360cell8.setCellStyle(textStyle);
					}

//ROW45
//Column J: 
					Cell R0360cell9 = row.createCell(9);
					if (record.getR0360_1_2months() != null) {
						R0360cell9.setCellValue(record.getR0360_1_2months().doubleValue());
						R0360cell9.setCellStyle(numberStyle);
					} else {
						R0360cell9.setCellValue("");
						R0360cell9.setCellStyle(textStyle);
					}

//ROW45
//Column K: 
					Cell R0360cell10 = row.createCell(10);
					if (record.getR0360_2_3months() != null) {
						R0360cell10.setCellValue(record.getR0360_2_3months().doubleValue());
						R0360cell10.setCellStyle(numberStyle);
					} else {
						R0360cell10.setCellValue("");
						R0360cell10.setCellStyle(textStyle);
					}

//ROW45
//Column L: 
					Cell R0360cell11 = row.createCell(11);
					if (record.getR0360_3_6months() != null) {
						R0360cell11.setCellValue(record.getR0360_3_6months().doubleValue());
						R0360cell11.setCellStyle(numberStyle);
					} else {
						R0360cell11.setCellValue("");
						R0360cell11.setCellStyle(textStyle);
					}

//ROW45
//Column M: 
					Cell R0360cell12 = row.createCell(12);
					if (record.getR0360_6_12months() != null) {
						R0360cell12.setCellValue(record.getR0360_6_12months().doubleValue());
						R0360cell12.setCellStyle(numberStyle);
					} else {
						R0360cell12.setCellValue("");
						R0360cell12.setCellStyle(textStyle);
					}

//ROW45
//Column N: 
					Cell R0360cell13 = row.createCell(13);
					if (record.getR0360_1_3years() != null) {
						R0360cell13.setCellValue(record.getR0360_1_3years().doubleValue());
						R0360cell13.setCellStyle(numberStyle);
					} else {
						R0360cell13.setCellValue("");
						R0360cell13.setCellStyle(textStyle);
					}

//ROW45
//Column O: 
					Cell R0360cell14 = row.createCell(14);
					if (record.getR0360_3_5years() != null) {
						R0360cell14.setCellValue(record.getR0360_3_5years().doubleValue());
						R0360cell14.setCellStyle(numberStyle);
					} else {
						R0360cell14.setCellValue("");
						R0360cell14.setCellStyle(textStyle);
					}

//ROW45
//Column P: 
					Cell R0360cell15 = row.createCell(15);
					if (record.getR0360_5years() != null) {
						R0360cell15.setCellValue(record.getR0360_5years().doubleValue());
						R0360cell15.setCellStyle(numberStyle);
					} else {
						R0360cell15.setCellValue("");
						R0360cell15.setCellStyle(textStyle);
					}

/////ROW46///////////
//ROW46

					row = sheet.getRow(45);

//Column E: 
					Cell R0370cell4 = row.createCell(4);
					if (record.getR0370_overdue() != null) {
						R0370cell4.setCellValue(record.getR0370_overdue().doubleValue());
						R0370cell4.setCellStyle(numberStyle);
					} else {
						R0370cell4.setCellValue("");
						R0370cell4.setCellStyle(textStyle);
					}

//ROW46
//Column F: 
					Cell R0370cell5 = row.createCell(5);
					if (record.getR0370_overdraft() != null) {
						R0370cell5.setCellValue(record.getR0370_overdraft().doubleValue());
						R0370cell5.setCellStyle(numberStyle);
					} else {
						R0370cell5.setCellValue("");
						R0370cell5.setCellStyle(textStyle);
					}

//ROW46
//Column G: 
					Cell R0370cell6 = row.createCell(6);
					if (record.getR0370_0_7days() != null) {
						R0370cell6.setCellValue(record.getR0370_0_7days().doubleValue());
						R0370cell6.setCellStyle(numberStyle);
					} else {
						R0370cell6.setCellValue("");
						R0370cell6.setCellStyle(textStyle);
					}

//ROW46
//Column H: 
					Cell R0370cell7 = row.createCell(7);
					if (record.getR0370_8_14days() != null) {
						R0370cell7.setCellValue(record.getR0370_8_14days().doubleValue());
						R0370cell7.setCellStyle(numberStyle);
					} else {
						R0370cell7.setCellValue("");
						R0370cell7.setCellStyle(textStyle);
					}

//ROW46
//Column I: 
					Cell R0370cell8 = row.createCell(8);
					if (record.getR0370_15days_1months() != null) {
						R0370cell8.setCellValue(record.getR0370_15days_1months().doubleValue());
						R0370cell8.setCellStyle(numberStyle);
					} else {
						R0370cell8.setCellValue("");
						R0370cell8.setCellStyle(textStyle);
					}

//ROW46
//Column J: 
					Cell R0370cell9 = row.createCell(9);
					if (record.getR0370_1_2months() != null) {
						R0370cell9.setCellValue(record.getR0370_1_2months().doubleValue());
						R0370cell9.setCellStyle(numberStyle);
					} else {
						R0370cell9.setCellValue("");
						R0370cell9.setCellStyle(textStyle);
					}

//ROW46
//Column K: 
					Cell R0370cell10 = row.createCell(10);
					if (record.getR0370_2_3months() != null) {
						R0370cell10.setCellValue(record.getR0370_2_3months().doubleValue());
						R0370cell10.setCellStyle(numberStyle);
					} else {
						R0370cell10.setCellValue("");
						R0370cell10.setCellStyle(textStyle);
					}

//ROW46
//Column L: 
					Cell R0370cell11 = row.createCell(11);
					if (record.getR0370_3_6months() != null) {
						R0370cell11.setCellValue(record.getR0370_3_6months().doubleValue());
						R0370cell11.setCellStyle(numberStyle);
					} else {
						R0370cell11.setCellValue("");
						R0370cell11.setCellStyle(textStyle);
					}

//ROW46
//Column M: 
					Cell R0370cell12 = row.createCell(12);
					if (record.getR0370_6_12months() != null) {
						R0370cell12.setCellValue(record.getR0370_6_12months().doubleValue());
						R0370cell12.setCellStyle(numberStyle);
					} else {
						R0370cell12.setCellValue("");
						R0370cell12.setCellStyle(textStyle);
					}

//ROW46
//Column N: 
					Cell R0370cell13 = row.createCell(13);
					if (record.getR0370_1_3years() != null) {
						R0370cell13.setCellValue(record.getR0370_1_3years().doubleValue());
						R0370cell13.setCellStyle(numberStyle);
					} else {
						R0370cell13.setCellValue("");
						R0370cell13.setCellStyle(textStyle);
					}

//ROW46
//Column O: 
					Cell R0370cell14 = row.createCell(14);
					if (record.getR0370_3_5years() != null) {
						R0370cell14.setCellValue(record.getR0370_3_5years().doubleValue());
						R0370cell14.setCellStyle(numberStyle);
					} else {
						R0370cell14.setCellValue("");
						R0370cell14.setCellStyle(textStyle);
					}

//ROW46
//Column P: 
					Cell R0370cell15 = row.createCell(15);
					if (record.getR0370_5years() != null) {
						R0370cell15.setCellValue(record.getR0370_5years().doubleValue());
						R0370cell15.setCellStyle(numberStyle);
					} else {
						R0370cell15.setCellValue("");
						R0370cell15.setCellStyle(textStyle);
					}

/////ROW47///////////
//ROW47

					row = sheet.getRow(46);

//Column E: 
					Cell R0380cell4 = row.createCell(4);
					if (record.getR0380_overdue() != null) {
						R0380cell4.setCellValue(record.getR0380_overdue().doubleValue());
						R0380cell4.setCellStyle(numberStyle);
					} else {
						R0380cell4.setCellValue("");
						R0380cell4.setCellStyle(textStyle);
					}

//ROW47
//Column F: 
					Cell R0380cell5 = row.createCell(5);
					if (record.getR0380_overdraft() != null) {
						R0380cell5.setCellValue(record.getR0380_overdraft().doubleValue());
						R0380cell5.setCellStyle(numberStyle);
					} else {
						R0380cell5.setCellValue("");
						R0380cell5.setCellStyle(textStyle);
					}

//ROW47
//Column G: 
					Cell R0380cell6 = row.createCell(6);
					if (record.getR0380_0_7days() != null) {
						R0380cell6.setCellValue(record.getR0380_0_7days().doubleValue());
						R0380cell6.setCellStyle(numberStyle);
					} else {
						R0380cell6.setCellValue("");
						R0380cell6.setCellStyle(textStyle);
					}

//ROW47
//Column H: 
					Cell R0380cell7 = row.createCell(7);
					if (record.getR0380_8_14days() != null) {
						R0380cell7.setCellValue(record.getR0380_8_14days().doubleValue());
						R0380cell7.setCellStyle(numberStyle);
					} else {
						R0380cell7.setCellValue("");
						R0380cell7.setCellStyle(textStyle);
					}

//ROW47
//Column I: 
					Cell R0380cell8 = row.createCell(8);
					if (record.getR0380_15days_1months() != null) {
						R0380cell8.setCellValue(record.getR0380_15days_1months().doubleValue());
						R0380cell8.setCellStyle(numberStyle);
					} else {
						R0380cell8.setCellValue("");
						R0380cell8.setCellStyle(textStyle);
					}

//ROW47
//Column J: 
					Cell R0380cell9 = row.createCell(9);
					if (record.getR0380_1_2months() != null) {
						R0380cell9.setCellValue(record.getR0380_1_2months().doubleValue());
						R0380cell9.setCellStyle(numberStyle);
					} else {
						R0380cell9.setCellValue("");
						R0380cell9.setCellStyle(textStyle);
					}

//ROW47
//Column K: 
					Cell R0380cell10 = row.createCell(10);
					if (record.getR0380_2_3months() != null) {
						R0380cell10.setCellValue(record.getR0380_2_3months().doubleValue());
						R0380cell10.setCellStyle(numberStyle);
					} else {
						R0380cell10.setCellValue("");
						R0380cell10.setCellStyle(textStyle);
					}

//ROW47
//Column L: 
					Cell R0380cell11 = row.createCell(11);
					if (record.getR0380_3_6months() != null) {
						R0380cell11.setCellValue(record.getR0380_3_6months().doubleValue());
						R0380cell11.setCellStyle(numberStyle);
					} else {
						R0380cell11.setCellValue("");
						R0380cell11.setCellStyle(textStyle);
					}

//ROW47
//Column M: 
					Cell R0380cell12 = row.createCell(12);
					if (record.getR0380_6_12months() != null) {
						R0380cell12.setCellValue(record.getR0380_6_12months().doubleValue());
						R0380cell12.setCellStyle(numberStyle);
					} else {
						R0380cell12.setCellValue("");
						R0380cell12.setCellStyle(textStyle);
					}

//ROW47
//Column N: 
					Cell R0380cell13 = row.createCell(13);
					if (record.getR0380_1_3years() != null) {
						R0380cell13.setCellValue(record.getR0380_1_3years().doubleValue());
						R0380cell13.setCellStyle(numberStyle);
					} else {
						R0380cell13.setCellValue("");
						R0380cell13.setCellStyle(textStyle);
					}

//ROW47
//Column O: 
					Cell R0380cell14 = row.createCell(14);
					if (record.getR0380_3_5years() != null) {
						R0380cell14.setCellValue(record.getR0380_3_5years().doubleValue());
						R0380cell14.setCellStyle(numberStyle);
					} else {
						R0380cell14.setCellValue("");
						R0380cell14.setCellStyle(textStyle);
					}

//ROW47
//Column P: 
					Cell R0380cell15 = row.createCell(15);
					if (record.getR0380_5years() != null) {
						R0380cell15.setCellValue(record.getR0380_5years().doubleValue());
						R0380cell15.setCellStyle(numberStyle);
					} else {
						R0380cell15.setCellValue("");
						R0380cell15.setCellStyle(textStyle);
					}

/////ROW49///////////
//ROW49

					row = sheet.getRow(48);

//Column E: 
					Cell R0400cell4 = row.createCell(4);
					if (record.getR0400_overdue() != null) {
						R0400cell4.setCellValue(record.getR0400_overdue().doubleValue());
						R0400cell4.setCellStyle(numberStyle);
					} else {
						R0400cell4.setCellValue("");
						R0400cell4.setCellStyle(textStyle);
					}

//ROW49
//Column F: 
					Cell R0400cell5 = row.createCell(5);
					if (record.getR0400_overdraft() != null) {
						R0400cell5.setCellValue(record.getR0400_overdraft().doubleValue());
						R0400cell5.setCellStyle(numberStyle);
					} else {
						R0400cell5.setCellValue("");
						R0400cell5.setCellStyle(textStyle);
					}

//ROW49
//Column G: 
					Cell R0400cell6 = row.createCell(6);
					if (record.getR0400_0_7days() != null) {
						R0400cell6.setCellValue(record.getR0400_0_7days().doubleValue());
						R0400cell6.setCellStyle(numberStyle);
					} else {
						R0400cell6.setCellValue("");
						R0400cell6.setCellStyle(textStyle);
					}

//ROW49
//Column H: 
					Cell R0400cell7 = row.createCell(7);
					if (record.getR0400_8_14days() != null) {
						R0400cell7.setCellValue(record.getR0400_8_14days().doubleValue());
						R0400cell7.setCellStyle(numberStyle);
					} else {
						R0400cell7.setCellValue("");
						R0400cell7.setCellStyle(textStyle);
					}

//ROW49
//Column I: 
					Cell R0400cell8 = row.createCell(8);
					if (record.getR0400_15days_1months() != null) {
						R0400cell8.setCellValue(record.getR0400_15days_1months().doubleValue());
						R0400cell8.setCellStyle(numberStyle);
					} else {
						R0400cell8.setCellValue("");
						R0400cell8.setCellStyle(textStyle);
					}

//ROW49
//Column J: 
					Cell R0400cell9 = row.createCell(9);
					if (record.getR0400_1_2months() != null) {
						R0400cell9.setCellValue(record.getR0400_1_2months().doubleValue());
						R0400cell9.setCellStyle(numberStyle);
					} else {
						R0400cell9.setCellValue("");
						R0400cell9.setCellStyle(textStyle);
					}

//ROW49
//Column K: 
					Cell R0400cell10 = row.createCell(10);
					if (record.getR0400_2_3months() != null) {
						R0400cell10.setCellValue(record.getR0400_2_3months().doubleValue());
						R0400cell10.setCellStyle(numberStyle);
					} else {
						R0400cell10.setCellValue("");
						R0400cell10.setCellStyle(textStyle);
					}

//ROW49
//Column L: 
					Cell R0400cell11 = row.createCell(11);
					if (record.getR0400_3_6months() != null) {
						R0400cell11.setCellValue(record.getR0400_3_6months().doubleValue());
						R0400cell11.setCellStyle(numberStyle);
					} else {
						R0400cell11.setCellValue("");
						R0400cell11.setCellStyle(textStyle);
					}

//ROW49
//Column M: 
					Cell R0400cell12 = row.createCell(12);
					if (record.getR0400_6_12months() != null) {
						R0400cell12.setCellValue(record.getR0400_6_12months().doubleValue());
						R0400cell12.setCellStyle(numberStyle);
					} else {
						R0400cell12.setCellValue("");
						R0400cell12.setCellStyle(textStyle);
					}

//ROW49
//Column N: 
					Cell R0400cell13 = row.createCell(13);
					if (record.getR0400_1_3years() != null) {
						R0400cell13.setCellValue(record.getR0400_1_3years().doubleValue());
						R0400cell13.setCellStyle(numberStyle);
					} else {
						R0400cell13.setCellValue("");
						R0400cell13.setCellStyle(textStyle);
					}

//ROW49
//Column O: 
					Cell R0400cell14 = row.createCell(14);
					if (record.getR0400_3_5years() != null) {
						R0400cell14.setCellValue(record.getR0400_3_5years().doubleValue());
						R0400cell14.setCellStyle(numberStyle);
					} else {
						R0400cell14.setCellValue("");
						R0400cell14.setCellStyle(textStyle);
					}

//ROW49
//Column P: 
					Cell R0400cell15 = row.createCell(15);
					if (record.getR0400_5years() != null) {
						R0400cell15.setCellValue(record.getR0400_5years().doubleValue());
						R0400cell15.setCellStyle(numberStyle);
					} else {
						R0400cell15.setCellValue("");
						R0400cell15.setCellStyle(textStyle);
					}

/////ROW50///////////
//ROW50

					row = sheet.getRow(49);

//Column E: 
					Cell R0410cell4 = row.createCell(4);
					if (record.getR0410_overdue() != null) {
						R0410cell4.setCellValue(record.getR0410_overdue().doubleValue());
						R0410cell4.setCellStyle(numberStyle);
					} else {
						R0410cell4.setCellValue("");
						R0410cell4.setCellStyle(textStyle);
					}

//ROW50
//Column F: 
					Cell R0410cell5 = row.createCell(5);
					if (record.getR0410_overdraft() != null) {
						R0410cell5.setCellValue(record.getR0410_overdraft().doubleValue());
						R0410cell5.setCellStyle(numberStyle);
					} else {
						R0410cell5.setCellValue("");
						R0410cell5.setCellStyle(textStyle);
					}

//ROW50
//Column G: 
					Cell R0410cell6 = row.createCell(6);
					if (record.getR0410_0_7days() != null) {
						R0410cell6.setCellValue(record.getR0410_0_7days().doubleValue());
						R0410cell6.setCellStyle(numberStyle);
					} else {
						R0410cell6.setCellValue("");
						R0410cell6.setCellStyle(textStyle);
					}

//ROW50
//Column H: 
					Cell R0410cell7 = row.createCell(7);
					if (record.getR0410_8_14days() != null) {
						R0410cell7.setCellValue(record.getR0410_8_14days().doubleValue());
						R0410cell7.setCellStyle(numberStyle);
					} else {
						R0410cell7.setCellValue("");
						R0410cell7.setCellStyle(textStyle);
					}

//ROW50
//Column I: 
					Cell R0410cell8 = row.createCell(8);
					if (record.getR0410_15days_1months() != null) {
						R0410cell8.setCellValue(record.getR0410_15days_1months().doubleValue());
						R0410cell8.setCellStyle(numberStyle);
					} else {
						R0410cell8.setCellValue("");
						R0410cell8.setCellStyle(textStyle);
					}

//ROW50
//Column J: 
					Cell R0410cell9 = row.createCell(9);
					if (record.getR0410_1_2months() != null) {
						R0410cell9.setCellValue(record.getR0410_1_2months().doubleValue());
						R0410cell9.setCellStyle(numberStyle);
					} else {
						R0410cell9.setCellValue("");
						R0410cell9.setCellStyle(textStyle);
					}

//ROW50
//Column K: 
					Cell R0410cell10 = row.createCell(10);
					if (record.getR0410_2_3months() != null) {
						R0410cell10.setCellValue(record.getR0410_2_3months().doubleValue());
						R0410cell10.setCellStyle(numberStyle);
					} else {
						R0410cell10.setCellValue("");
						R0410cell10.setCellStyle(textStyle);
					}

//ROW50
//Column L: 
					Cell R0410cell11 = row.createCell(11);
					if (record.getR0410_3_6months() != null) {
						R0410cell11.setCellValue(record.getR0410_3_6months().doubleValue());
						R0410cell11.setCellStyle(numberStyle);
					} else {
						R0410cell11.setCellValue("");
						R0410cell11.setCellStyle(textStyle);
					}

//ROW50
//Column M: 
					Cell R0410cell12 = row.createCell(12);
					if (record.getR0410_6_12months() != null) {
						R0410cell12.setCellValue(record.getR0410_6_12months().doubleValue());
						R0410cell12.setCellStyle(numberStyle);
					} else {
						R0410cell12.setCellValue("");
						R0410cell12.setCellStyle(textStyle);
					}

//ROW50
//Column N: 
					Cell R0410cell13 = row.createCell(13);
					if (record.getR0410_1_3years() != null) {
						R0410cell13.setCellValue(record.getR0410_1_3years().doubleValue());
						R0410cell13.setCellStyle(numberStyle);
					} else {
						R0410cell13.setCellValue("");
						R0410cell13.setCellStyle(textStyle);
					}

//ROW50
//Column O: 
					Cell R0410cell14 = row.createCell(14);
					if (record.getR0410_3_5years() != null) {
						R0410cell14.setCellValue(record.getR0410_3_5years().doubleValue());
						R0410cell14.setCellStyle(numberStyle);
					} else {
						R0410cell14.setCellValue("");
						R0410cell14.setCellStyle(textStyle);
					}

//ROW50
//Column P: 
					Cell R0410cell15 = row.createCell(15);
					if (record.getR0410_5years() != null) {
						R0410cell15.setCellValue(record.getR0410_5years().doubleValue());
						R0410cell15.setCellStyle(numberStyle);
					} else {
						R0410cell15.setCellValue("");
						R0410cell15.setCellStyle(textStyle);
					}

/////ROW51///////////
//ROW51

					row = sheet.getRow(50);

//Column E: 
					Cell R0420cell4 = row.createCell(4);
					if (record.getR0420_overdue() != null) {
						R0420cell4.setCellValue(record.getR0420_overdue().doubleValue());
						R0420cell4.setCellStyle(numberStyle);
					} else {
						R0420cell4.setCellValue("");
						R0420cell4.setCellStyle(textStyle);
					}

//ROW51
//Column F: 
					Cell R0420cell5 = row.createCell(5);
					if (record.getR0420_overdraft() != null) {
						R0420cell5.setCellValue(record.getR0420_overdraft().doubleValue());
						R0420cell5.setCellStyle(numberStyle);
					} else {
						R0420cell5.setCellValue("");
						R0420cell5.setCellStyle(textStyle);
					}

//ROW51
//Column G: 
					Cell R0420cell6 = row.createCell(6);
					if (record.getR0420_0_7days() != null) {
						R0420cell6.setCellValue(record.getR0420_0_7days().doubleValue());
						R0420cell6.setCellStyle(numberStyle);
					} else {
						R0420cell6.setCellValue("");
						R0420cell6.setCellStyle(textStyle);
					}

//ROW51
//Column H: 
					Cell R0420cell7 = row.createCell(7);
					if (record.getR0420_8_14days() != null) {
						R0420cell7.setCellValue(record.getR0420_8_14days().doubleValue());
						R0420cell7.setCellStyle(numberStyle);
					} else {
						R0420cell7.setCellValue("");
						R0420cell7.setCellStyle(textStyle);
					}

//ROW51
//Column I: 
					Cell R0420cell8 = row.createCell(8);
					if (record.getR0420_15days_1months() != null) {
						R0420cell8.setCellValue(record.getR0420_15days_1months().doubleValue());
						R0420cell8.setCellStyle(numberStyle);
					} else {
						R0420cell8.setCellValue("");
						R0420cell8.setCellStyle(textStyle);
					}

//ROW51
//Column J: 
					Cell R0420cell9 = row.createCell(9);
					if (record.getR0420_1_2months() != null) {
						R0420cell9.setCellValue(record.getR0420_1_2months().doubleValue());
						R0420cell9.setCellStyle(numberStyle);
					} else {
						R0420cell9.setCellValue("");
						R0420cell9.setCellStyle(textStyle);
					}

//ROW51
//Column K: 
					Cell R0420cell10 = row.createCell(10);
					if (record.getR0420_2_3months() != null) {
						R0420cell10.setCellValue(record.getR0420_2_3months().doubleValue());
						R0420cell10.setCellStyle(numberStyle);
					} else {
						R0420cell10.setCellValue("");
						R0420cell10.setCellStyle(textStyle);
					}

//ROW51
//Column L: 
					Cell R0420cell11 = row.createCell(11);
					if (record.getR0420_3_6months() != null) {
						R0420cell11.setCellValue(record.getR0420_3_6months().doubleValue());
						R0420cell11.setCellStyle(numberStyle);
					} else {
						R0420cell11.setCellValue("");
						R0420cell11.setCellStyle(textStyle);
					}

//ROW51
//Column M: 
					Cell R0420cell12 = row.createCell(12);
					if (record.getR0420_6_12months() != null) {
						R0420cell12.setCellValue(record.getR0420_6_12months().doubleValue());
						R0420cell12.setCellStyle(numberStyle);
					} else {
						R0420cell12.setCellValue("");
						R0420cell12.setCellStyle(textStyle);
					}

//ROW51
//Column N: 
					Cell R0420cell13 = row.createCell(13);
					if (record.getR0420_1_3years() != null) {
						R0420cell13.setCellValue(record.getR0420_1_3years().doubleValue());
						R0420cell13.setCellStyle(numberStyle);
					} else {
						R0420cell13.setCellValue("");
						R0420cell13.setCellStyle(textStyle);
					}

//ROW51
//Column O: 
					Cell R0420cell14 = row.createCell(14);
					if (record.getR0420_3_5years() != null) {
						R0420cell14.setCellValue(record.getR0420_3_5years().doubleValue());
						R0420cell14.setCellStyle(numberStyle);
					} else {
						R0420cell14.setCellValue("");
						R0420cell14.setCellStyle(textStyle);
					}

//ROW51
//Column P: 
					Cell R0420cell15 = row.createCell(15);
					if (record.getR0420_5years() != null) {
						R0420cell15.setCellValue(record.getR0420_5years().doubleValue());
						R0420cell15.setCellStyle(numberStyle);
					} else {
						R0420cell15.setCellValue("");
						R0420cell15.setCellStyle(textStyle);
					}

/////ROW52///////////
//ROW52

					row = sheet.getRow(51);

//Column E: 
					Cell R0430cell4 = row.createCell(4);
					if (record.getR0430_overdue() != null) {
						R0430cell4.setCellValue(record.getR0430_overdue().doubleValue());
						R0430cell4.setCellStyle(numberStyle);
					} else {
						R0430cell4.setCellValue("");
						R0430cell4.setCellStyle(textStyle);
					}

//ROW52
//Column F: 
					Cell R0430cell5 = row.createCell(5);
					if (record.getR0430_overdraft() != null) {
						R0430cell5.setCellValue(record.getR0430_overdraft().doubleValue());
						R0430cell5.setCellStyle(numberStyle);
					} else {
						R0430cell5.setCellValue("");
						R0430cell5.setCellStyle(textStyle);
					}

//ROW52
//Column G: 
					Cell R0430cell6 = row.createCell(6);
					if (record.getR0430_0_7days() != null) {
						R0430cell6.setCellValue(record.getR0430_0_7days().doubleValue());
						R0430cell6.setCellStyle(numberStyle);
					} else {
						R0430cell6.setCellValue("");
						R0430cell6.setCellStyle(textStyle);
					}

//ROW52
//Column H: 
					Cell R0430cell7 = row.createCell(7);
					if (record.getR0430_8_14days() != null) {
						R0430cell7.setCellValue(record.getR0430_8_14days().doubleValue());
						R0430cell7.setCellStyle(numberStyle);
					} else {
						R0430cell7.setCellValue("");
						R0430cell7.setCellStyle(textStyle);
					}

//ROW52
//Column I: 
					Cell R0430cell8 = row.createCell(8);
					if (record.getR0430_15days_1months() != null) {
						R0430cell8.setCellValue(record.getR0430_15days_1months().doubleValue());
						R0430cell8.setCellStyle(numberStyle);
					} else {
						R0430cell8.setCellValue("");
						R0430cell8.setCellStyle(textStyle);
					}

//ROW52
//Column J: 
					Cell R0430cell9 = row.createCell(9);
					if (record.getR0430_1_2months() != null) {
						R0430cell9.setCellValue(record.getR0430_1_2months().doubleValue());
						R0430cell9.setCellStyle(numberStyle);
					} else {
						R0430cell9.setCellValue("");
						R0430cell9.setCellStyle(textStyle);
					}

//ROW52
//Column K: 
					Cell R0430cell10 = row.createCell(10);
					if (record.getR0430_2_3months() != null) {
						R0430cell10.setCellValue(record.getR0430_2_3months().doubleValue());
						R0430cell10.setCellStyle(numberStyle);
					} else {
						R0430cell10.setCellValue("");
						R0430cell10.setCellStyle(textStyle);
					}

//ROW52
//Column L: 
					Cell R0430cell11 = row.createCell(11);
					if (record.getR0430_3_6months() != null) {
						R0430cell11.setCellValue(record.getR0430_3_6months().doubleValue());
						R0430cell11.setCellStyle(numberStyle);
					} else {
						R0430cell11.setCellValue("");
						R0430cell11.setCellStyle(textStyle);
					}

//ROW52
//Column M: 
					Cell R0430cell12 = row.createCell(12);
					if (record.getR0430_6_12months() != null) {
						R0430cell12.setCellValue(record.getR0430_6_12months().doubleValue());
						R0430cell12.setCellStyle(numberStyle);
					} else {
						R0430cell12.setCellValue("");
						R0430cell12.setCellStyle(textStyle);
					}

//ROW52
//Column N: 
					Cell R0430cell13 = row.createCell(13);
					if (record.getR0430_1_3years() != null) {
						R0430cell13.setCellValue(record.getR0430_1_3years().doubleValue());
						R0430cell13.setCellStyle(numberStyle);
					} else {
						R0430cell13.setCellValue("");
						R0430cell13.setCellStyle(textStyle);
					}

//ROW52
//Column O: 
					Cell R0430cell14 = row.createCell(14);
					if (record.getR0430_3_5years() != null) {
						R0430cell14.setCellValue(record.getR0430_3_5years().doubleValue());
						R0430cell14.setCellStyle(numberStyle);
					} else {
						R0430cell14.setCellValue("");
						R0430cell14.setCellStyle(textStyle);
					}

//ROW52
//Column P: 
					Cell R0430cell15 = row.createCell(15);
					if (record.getR0430_5years() != null) {
						R0430cell15.setCellValue(record.getR0430_5years().doubleValue());
						R0430cell15.setCellStyle(numberStyle);
					} else {
						R0430cell15.setCellValue("");
						R0430cell15.setCellStyle(textStyle);
					}

/////ROW56///////////
//ROW56

					row = sheet.getRow(55);

//Column E: 
					Cell R0470cell4 = row.createCell(4);
					if (record.getR0470_overdue() != null) {
						R0470cell4.setCellValue(record.getR0470_overdue().doubleValue());
						R0470cell4.setCellStyle(numberStyle);
					} else {
						R0470cell4.setCellValue("");
						R0470cell4.setCellStyle(textStyle);
					}

//ROW56
//Column F: 
					Cell R0470cell5 = row.createCell(5);
					if (record.getR0470_overdraft() != null) {
						R0470cell5.setCellValue(record.getR0470_overdraft().doubleValue());
						R0470cell5.setCellStyle(numberStyle);
					} else {
						R0470cell5.setCellValue("");
						R0470cell5.setCellStyle(textStyle);
					}

//ROW56
//Column G: 
					Cell R0470cell6 = row.createCell(6);
					if (record.getR0470_0_7days() != null) {
						R0470cell6.setCellValue(record.getR0470_0_7days().doubleValue());
						R0470cell6.setCellStyle(numberStyle);
					} else {
						R0470cell6.setCellValue("");
						R0470cell6.setCellStyle(textStyle);
					}

//ROW56
//Column H: 
					Cell R0470cell7 = row.createCell(7);
					if (record.getR0470_8_14days() != null) {
						R0470cell7.setCellValue(record.getR0470_8_14days().doubleValue());
						R0470cell7.setCellStyle(numberStyle);
					} else {
						R0470cell7.setCellValue("");
						R0470cell7.setCellStyle(textStyle);
					}

//ROW56
//Column I: 
					Cell R0470cell8 = row.createCell(8);
					if (record.getR0470_15days_1months() != null) {
						R0470cell8.setCellValue(record.getR0470_15days_1months().doubleValue());
						R0470cell8.setCellStyle(numberStyle);
					} else {
						R0470cell8.setCellValue("");
						R0470cell8.setCellStyle(textStyle);
					}

//ROW56
//Column J: 
					Cell R0470cell9 = row.createCell(9);
					if (record.getR0470_1_2months() != null) {
						R0470cell9.setCellValue(record.getR0470_1_2months().doubleValue());
						R0470cell9.setCellStyle(numberStyle);
					} else {
						R0470cell9.setCellValue("");
						R0470cell9.setCellStyle(textStyle);
					}

//ROW56
//Column K: 
					Cell R0470cell10 = row.createCell(10);
					if (record.getR0470_2_3months() != null) {
						R0470cell10.setCellValue(record.getR0470_2_3months().doubleValue());
						R0470cell10.setCellStyle(numberStyle);
					} else {
						R0470cell10.setCellValue("");
						R0470cell10.setCellStyle(textStyle);
					}

//ROW56
//Column L: 
					Cell R0470cell11 = row.createCell(11);
					if (record.getR0470_3_6months() != null) {
						R0470cell11.setCellValue(record.getR0470_3_6months().doubleValue());
						R0470cell11.setCellStyle(numberStyle);
					} else {
						R0470cell11.setCellValue("");
						R0470cell11.setCellStyle(textStyle);
					}

//ROW56
//Column M: 
					Cell R0470cell12 = row.createCell(12);
					if (record.getR0470_6_12months() != null) {
						R0470cell12.setCellValue(record.getR0470_6_12months().doubleValue());
						R0470cell12.setCellStyle(numberStyle);
					} else {
						R0470cell12.setCellValue("");
						R0470cell12.setCellStyle(textStyle);
					}

//ROW56
//Column N: 
					Cell R0470cell13 = row.createCell(13);
					if (record.getR0470_1_3years() != null) {
						R0470cell13.setCellValue(record.getR0470_1_3years().doubleValue());
						R0470cell13.setCellStyle(numberStyle);
					} else {
						R0470cell13.setCellValue("");
						R0470cell13.setCellStyle(textStyle);
					}

//ROW56
//Column O: 
					Cell R0470cell14 = row.createCell(14);
					if (record.getR0470_3_5years() != null) {
						R0470cell14.setCellValue(record.getR0470_3_5years().doubleValue());
						R0470cell14.setCellStyle(numberStyle);
					} else {
						R0470cell14.setCellValue("");
						R0470cell14.setCellStyle(textStyle);
					}

//ROW56
//Column P: 
					Cell R0470cell15 = row.createCell(15);
					if (record.getR0470_5years() != null) {
						R0470cell15.setCellValue(record.getR0470_5years().doubleValue());
						R0470cell15.setCellStyle(numberStyle);
					} else {
						R0470cell15.setCellValue("");
						R0470cell15.setCellStyle(textStyle);
					}

/////ROW57///////////
//ROW57

					row = sheet.getRow(56);

//Column E: 
					Cell R0480cell4 = row.createCell(4);
					if (record.getR0480_overdue() != null) {
						R0480cell4.setCellValue(record.getR0480_overdue().doubleValue());
						R0480cell4.setCellStyle(numberStyle);
					} else {
						R0480cell4.setCellValue("");
						R0480cell4.setCellStyle(textStyle);
					}

//ROW57
//Column F: 
					Cell R0480cell5 = row.createCell(5);
					if (record.getR0480_overdraft() != null) {
						R0480cell5.setCellValue(record.getR0480_overdraft().doubleValue());
						R0480cell5.setCellStyle(numberStyle);
					} else {
						R0480cell5.setCellValue("");
						R0480cell5.setCellStyle(textStyle);
					}

//ROW57
//Column G: 
					Cell R0480cell6 = row.createCell(6);
					if (record.getR0480_0_7days() != null) {
						R0480cell6.setCellValue(record.getR0480_0_7days().doubleValue());
						R0480cell6.setCellStyle(numberStyle);
					} else {
						R0480cell6.setCellValue("");
						R0480cell6.setCellStyle(textStyle);
					}

//ROW57
//Column H: 
					Cell R0480cell7 = row.createCell(7);
					if (record.getR0480_8_14days() != null) {
						R0480cell7.setCellValue(record.getR0480_8_14days().doubleValue());
						R0480cell7.setCellStyle(numberStyle);
					} else {
						R0480cell7.setCellValue("");
						R0480cell7.setCellStyle(textStyle);
					}

//ROW57
//Column I: 
					Cell R0480cell8 = row.createCell(8);
					if (record.getR0480_15days_1months() != null) {
						R0480cell8.setCellValue(record.getR0480_15days_1months().doubleValue());
						R0480cell8.setCellStyle(numberStyle);
					} else {
						R0480cell8.setCellValue("");
						R0480cell8.setCellStyle(textStyle);
					}

//ROW57
//Column J: 
					Cell R0480cell9 = row.createCell(9);
					if (record.getR0480_1_2months() != null) {
						R0480cell9.setCellValue(record.getR0480_1_2months().doubleValue());
						R0480cell9.setCellStyle(numberStyle);
					} else {
						R0480cell9.setCellValue("");
						R0480cell9.setCellStyle(textStyle);
					}

//ROW57
//Column K: 
					Cell R0480cell10 = row.createCell(10);
					if (record.getR0480_2_3months() != null) {
						R0480cell10.setCellValue(record.getR0480_2_3months().doubleValue());
						R0480cell10.setCellStyle(numberStyle);
					} else {
						R0480cell10.setCellValue("");
						R0480cell10.setCellStyle(textStyle);
					}

//ROW57
//Column L: 
					Cell R0480cell11 = row.createCell(11);
					if (record.getR0480_3_6months() != null) {
						R0480cell11.setCellValue(record.getR0480_3_6months().doubleValue());
						R0480cell11.setCellStyle(numberStyle);
					} else {
						R0480cell11.setCellValue("");
						R0480cell11.setCellStyle(textStyle);
					}

//ROW57
//Column M: 
					Cell R0480cell12 = row.createCell(12);
					if (record.getR0480_6_12months() != null) {
						R0480cell12.setCellValue(record.getR0480_6_12months().doubleValue());
						R0480cell12.setCellStyle(numberStyle);
					} else {
						R0480cell12.setCellValue("");
						R0480cell12.setCellStyle(textStyle);
					}

//ROW57
//Column N: 
					Cell R0480cell13 = row.createCell(13);
					if (record.getR0480_1_3years() != null) {
						R0480cell13.setCellValue(record.getR0480_1_3years().doubleValue());
						R0480cell13.setCellStyle(numberStyle);
					} else {
						R0480cell13.setCellValue("");
						R0480cell13.setCellStyle(textStyle);
					}

//ROW57
//Column O: 
					Cell R0480cell14 = row.createCell(14);
					if (record.getR0480_3_5years() != null) {
						R0480cell14.setCellValue(record.getR0480_3_5years().doubleValue());
						R0480cell14.setCellStyle(numberStyle);
					} else {
						R0480cell14.setCellValue("");
						R0480cell14.setCellStyle(textStyle);
					}

//ROW57
//Column P: 
					Cell R0480cell15 = row.createCell(15);
					if (record.getR0480_5years() != null) {
						R0480cell15.setCellValue(record.getR0480_5years().doubleValue());
						R0480cell15.setCellStyle(numberStyle);
					} else {
						R0480cell15.setCellValue("");
						R0480cell15.setCellStyle(textStyle);
					}

/////ROW58///////////
//ROW58

					row = sheet.getRow(57);

//Column E: 
					Cell R0490cell4 = row.createCell(4);
					if (record.getR0490_overdue() != null) {
						R0490cell4.setCellValue(record.getR0490_overdue().doubleValue());
						R0490cell4.setCellStyle(numberStyle);
					} else {
						R0490cell4.setCellValue("");
						R0490cell4.setCellStyle(textStyle);
					}

//ROW58
//Column F: 
					Cell R0490cell5 = row.createCell(5);
					if (record.getR0490_overdraft() != null) {
						R0490cell5.setCellValue(record.getR0490_overdraft().doubleValue());
						R0490cell5.setCellStyle(numberStyle);
					} else {
						R0490cell5.setCellValue("");
						R0490cell5.setCellStyle(textStyle);
					}

//ROW58
//Column G: 
					Cell R0490cell6 = row.createCell(6);
					if (record.getR0490_0_7days() != null) {
						R0490cell6.setCellValue(record.getR0490_0_7days().doubleValue());
						R0490cell6.setCellStyle(numberStyle);
					} else {
						R0490cell6.setCellValue("");
						R0490cell6.setCellStyle(textStyle);
					}

//ROW58
//Column H: 
					Cell R0490cell7 = row.createCell(7);
					if (record.getR0490_8_14days() != null) {
						R0490cell7.setCellValue(record.getR0490_8_14days().doubleValue());
						R0490cell7.setCellStyle(numberStyle);
					} else {
						R0490cell7.setCellValue("");
						R0490cell7.setCellStyle(textStyle);
					}

//ROW58
//Column I: 
					Cell R0490cell8 = row.createCell(8);
					if (record.getR0490_15days_1months() != null) {
						R0490cell8.setCellValue(record.getR0490_15days_1months().doubleValue());
						R0490cell8.setCellStyle(numberStyle);
					} else {
						R0490cell8.setCellValue("");
						R0490cell8.setCellStyle(textStyle);
					}

//ROW58
//Column J: 
					Cell R0490cell9 = row.createCell(9);
					if (record.getR0490_1_2months() != null) {
						R0490cell9.setCellValue(record.getR0490_1_2months().doubleValue());
						R0490cell9.setCellStyle(numberStyle);
					} else {
						R0490cell9.setCellValue("");
						R0490cell9.setCellStyle(textStyle);
					}

//ROW58
//Column K: 
					Cell R0490cell10 = row.createCell(10);
					if (record.getR0490_2_3months() != null) {
						R0490cell10.setCellValue(record.getR0490_2_3months().doubleValue());
						R0490cell10.setCellStyle(numberStyle);
					} else {
						R0490cell10.setCellValue("");
						R0490cell10.setCellStyle(textStyle);
					}

//ROW58
//Column L: 
					Cell R0490cell11 = row.createCell(11);
					if (record.getR0490_3_6months() != null) {
						R0490cell11.setCellValue(record.getR0490_3_6months().doubleValue());
						R0490cell11.setCellStyle(numberStyle);
					} else {
						R0490cell11.setCellValue("");
						R0490cell11.setCellStyle(textStyle);
					}

//ROW58
//Column M: 
					Cell R0490cell12 = row.createCell(12);
					if (record.getR0490_6_12months() != null) {
						R0490cell12.setCellValue(record.getR0490_6_12months().doubleValue());
						R0490cell12.setCellStyle(numberStyle);
					} else {
						R0490cell12.setCellValue("");
						R0490cell12.setCellStyle(textStyle);
					}

//ROW58
//Column N: 
					Cell R0490cell13 = row.createCell(13);
					if (record.getR0490_1_3years() != null) {
						R0490cell13.setCellValue(record.getR0490_1_3years().doubleValue());
						R0490cell13.setCellStyle(numberStyle);
					} else {
						R0490cell13.setCellValue("");
						R0490cell13.setCellStyle(textStyle);
					}

//ROW58
//Column O: 
					Cell R0490cell14 = row.createCell(14);
					if (record.getR0490_3_5years() != null) {
						R0490cell14.setCellValue(record.getR0490_3_5years().doubleValue());
						R0490cell14.setCellStyle(numberStyle);
					} else {
						R0490cell14.setCellValue("");
						R0490cell14.setCellStyle(textStyle);
					}

//ROW58
//Column P: 
					Cell R0490cell15 = row.createCell(15);
					if (record.getR0490_5years() != null) {
						R0490cell15.setCellValue(record.getR0490_5years().doubleValue());
						R0490cell15.setCellStyle(numberStyle);
					} else {
						R0490cell15.setCellValue("");
						R0490cell15.setCellStyle(textStyle);
					}

/////ROW59///////////
//ROW59

					row = sheet.getRow(58);

//Column E: 
					Cell R0500cell4 = row.createCell(4);
					if (record.getR0500_overdue() != null) {
						R0500cell4.setCellValue(record.getR0500_overdue().doubleValue());
						R0500cell4.setCellStyle(numberStyle);
					} else {
						R0500cell4.setCellValue("");
						R0500cell4.setCellStyle(textStyle);
					}

//ROW59
//Column F: 
					Cell R0500cell5 = row.createCell(5);
					if (record.getR0500_overdraft() != null) {
						R0500cell5.setCellValue(record.getR0500_overdraft().doubleValue());
						R0500cell5.setCellStyle(numberStyle);
					} else {
						R0500cell5.setCellValue("");
						R0500cell5.setCellStyle(textStyle);
					}

//ROW59
//Column G: 
					Cell R0500cell6 = row.createCell(6);
					if (record.getR0500_0_7days() != null) {
						R0500cell6.setCellValue(record.getR0500_0_7days().doubleValue());
						R0500cell6.setCellStyle(numberStyle);
					} else {
						R0500cell6.setCellValue("");
						R0500cell6.setCellStyle(textStyle);
					}

//ROW59
//Column H: 
					Cell R0500cell7 = row.createCell(7);
					if (record.getR0500_8_14days() != null) {
						R0500cell7.setCellValue(record.getR0500_8_14days().doubleValue());
						R0500cell7.setCellStyle(numberStyle);
					} else {
						R0500cell7.setCellValue("");
						R0500cell7.setCellStyle(textStyle);
					}

//ROW59
//Column I: 
					Cell R0500cell8 = row.createCell(8);
					if (record.getR0500_15days_1months() != null) {
						R0500cell8.setCellValue(record.getR0500_15days_1months().doubleValue());
						R0500cell8.setCellStyle(numberStyle);
					} else {
						R0500cell8.setCellValue("");
						R0500cell8.setCellStyle(textStyle);
					}

//ROW59
//Column J: 
					Cell R0500cell9 = row.createCell(9);
					if (record.getR0500_1_2months() != null) {
						R0500cell9.setCellValue(record.getR0500_1_2months().doubleValue());
						R0500cell9.setCellStyle(numberStyle);
					} else {
						R0500cell9.setCellValue("");
						R0500cell9.setCellStyle(textStyle);
					}

//ROW59
//Column K: 
					Cell R0500cell10 = row.createCell(10);
					if (record.getR0500_2_3months() != null) {
						R0500cell10.setCellValue(record.getR0500_2_3months().doubleValue());
						R0500cell10.setCellStyle(numberStyle);
					} else {
						R0500cell10.setCellValue("");
						R0500cell10.setCellStyle(textStyle);
					}

//ROW59
//Column L: 
					Cell R0500cell11 = row.createCell(11);
					if (record.getR0500_3_6months() != null) {
						R0500cell11.setCellValue(record.getR0500_3_6months().doubleValue());
						R0500cell11.setCellStyle(numberStyle);
					} else {
						R0500cell11.setCellValue("");
						R0500cell11.setCellStyle(textStyle);
					}

//ROW59
//Column M: 
					Cell R0500cell12 = row.createCell(12);
					if (record.getR0500_6_12months() != null) {
						R0500cell12.setCellValue(record.getR0500_6_12months().doubleValue());
						R0500cell12.setCellStyle(numberStyle);
					} else {
						R0500cell12.setCellValue("");
						R0500cell12.setCellStyle(textStyle);
					}

//ROW59
//Column N: 
					Cell R0500cell13 = row.createCell(13);
					if (record.getR0500_1_3years() != null) {
						R0500cell13.setCellValue(record.getR0500_1_3years().doubleValue());
						R0500cell13.setCellStyle(numberStyle);
					} else {
						R0500cell13.setCellValue("");
						R0500cell13.setCellStyle(textStyle);
					}

//ROW59
//Column O: 
					Cell R0500cell14 = row.createCell(14);
					if (record.getR0500_3_5years() != null) {
						R0500cell14.setCellValue(record.getR0500_3_5years().doubleValue());
						R0500cell14.setCellStyle(numberStyle);
					} else {
						R0500cell14.setCellValue("");
						R0500cell14.setCellStyle(textStyle);
					}

//ROW59
//Column P: 
					Cell R0500cell15 = row.createCell(15);
					if (record.getR0500_5years() != null) {
						R0500cell15.setCellValue(record.getR0500_5years().doubleValue());
						R0500cell15.setCellStyle(numberStyle);
					} else {
						R0500cell15.setCellValue("");
						R0500cell15.setCellStyle(textStyle);
					}

/////ROW60///////////
//ROW60

					row = sheet.getRow(59);

//Column E: 
					Cell R0510cell4 = row.createCell(4);
					if (record.getR0510_overdue() != null) {
						R0510cell4.setCellValue(record.getR0510_overdue().doubleValue());
						R0510cell4.setCellStyle(numberStyle);
					} else {
						R0510cell4.setCellValue("");
						R0510cell4.setCellStyle(textStyle);
					}

//ROW60
//Column F: 
					Cell R0510cell5 = row.createCell(5);
					if (record.getR0510_overdraft() != null) {
						R0510cell5.setCellValue(record.getR0510_overdraft().doubleValue());
						R0510cell5.setCellStyle(numberStyle);
					} else {
						R0510cell5.setCellValue("");
						R0510cell5.setCellStyle(textStyle);
					}

//ROW60
//Column G: 
					Cell R0510cell6 = row.createCell(6);
					if (record.getR0510_0_7days() != null) {
						R0510cell6.setCellValue(record.getR0510_0_7days().doubleValue());
						R0510cell6.setCellStyle(numberStyle);
					} else {
						R0510cell6.setCellValue("");
						R0510cell6.setCellStyle(textStyle);
					}

//ROW60
//Column H: 
					Cell R0510cell7 = row.createCell(7);
					if (record.getR0510_8_14days() != null) {
						R0510cell7.setCellValue(record.getR0510_8_14days().doubleValue());
						R0510cell7.setCellStyle(numberStyle);
					} else {
						R0510cell7.setCellValue("");
						R0510cell7.setCellStyle(textStyle);
					}

//ROW60
//Column I: 
					Cell R0510cell8 = row.createCell(8);
					if (record.getR0510_15days_1months() != null) {
						R0510cell8.setCellValue(record.getR0510_15days_1months().doubleValue());
						R0510cell8.setCellStyle(numberStyle);
					} else {
						R0510cell8.setCellValue("");
						R0510cell8.setCellStyle(textStyle);
					}

//ROW60
//Column J: 
					Cell R0510cell9 = row.createCell(9);
					if (record.getR0510_1_2months() != null) {
						R0510cell9.setCellValue(record.getR0510_1_2months().doubleValue());
						R0510cell9.setCellStyle(numberStyle);
					} else {
						R0510cell9.setCellValue("");
						R0510cell9.setCellStyle(textStyle);
					}

//ROW60
//Column K: 
					Cell R0510cell10 = row.createCell(10);
					if (record.getR0510_2_3months() != null) {
						R0510cell10.setCellValue(record.getR0510_2_3months().doubleValue());
						R0510cell10.setCellStyle(numberStyle);
					} else {
						R0510cell10.setCellValue("");
						R0510cell10.setCellStyle(textStyle);
					}

//ROW60
//Column L: 
					Cell R0510cell11 = row.createCell(11);
					if (record.getR0510_3_6months() != null) {
						R0510cell11.setCellValue(record.getR0510_3_6months().doubleValue());
						R0510cell11.setCellStyle(numberStyle);
					} else {
						R0510cell11.setCellValue("");
						R0510cell11.setCellStyle(textStyle);
					}

//ROW60
//Column M: 
					Cell R0510cell12 = row.createCell(12);
					if (record.getR0510_6_12months() != null) {
						R0510cell12.setCellValue(record.getR0510_6_12months().doubleValue());
						R0510cell12.setCellStyle(numberStyle);
					} else {
						R0510cell12.setCellValue("");
						R0510cell12.setCellStyle(textStyle);
					}

//ROW60
//Column N: 
					Cell R0510cell13 = row.createCell(13);
					if (record.getR0510_1_3years() != null) {
						R0510cell13.setCellValue(record.getR0510_1_3years().doubleValue());
						R0510cell13.setCellStyle(numberStyle);
					} else {
						R0510cell13.setCellValue("");
						R0510cell13.setCellStyle(textStyle);
					}

//ROW60
//Column O: 
					Cell R0510cell14 = row.createCell(14);
					if (record.getR0510_3_5years() != null) {
						R0510cell14.setCellValue(record.getR0510_3_5years().doubleValue());
						R0510cell14.setCellStyle(numberStyle);
					} else {
						R0510cell14.setCellValue("");
						R0510cell14.setCellStyle(textStyle);
					}

//ROW60
//Column P: 
					Cell R0510cell15 = row.createCell(15);
					if (record.getR0510_5years() != null) {
						R0510cell15.setCellValue(record.getR0510_5years().doubleValue());
						R0510cell15.setCellStyle(numberStyle);
					} else {
						R0510cell15.setCellValue("");
						R0510cell15.setCellStyle(textStyle);
					}

/////ROW62///////////
//ROW62

					row = sheet.getRow(61);

//Column E: 
					Cell R0530cell4 = row.createCell(4);
					if (record.getR0530_overdue() != null) {
						R0530cell4.setCellValue(record.getR0530_overdue().doubleValue());
						R0530cell4.setCellStyle(numberStyle);
					} else {
						R0530cell4.setCellValue("");
						R0530cell4.setCellStyle(textStyle);
					}

//ROW62
//Column F: 
					Cell R0530cell5 = row.createCell(5);
					if (record.getR0530_overdraft() != null) {
						R0530cell5.setCellValue(record.getR0530_overdraft().doubleValue());
						R0530cell5.setCellStyle(numberStyle);
					} else {
						R0530cell5.setCellValue("");
						R0530cell5.setCellStyle(textStyle);
					}

//ROW62
//Column G: 
					Cell R0530cell6 = row.createCell(6);
					if (record.getR0530_0_7days() != null) {
						R0530cell6.setCellValue(record.getR0530_0_7days().doubleValue());
						R0530cell6.setCellStyle(numberStyle);
					} else {
						R0530cell6.setCellValue("");
						R0530cell6.setCellStyle(textStyle);
					}

//ROW62
//Column H: 
					Cell R0530cell7 = row.createCell(7);
					if (record.getR0530_8_14days() != null) {
						R0530cell7.setCellValue(record.getR0530_8_14days().doubleValue());
						R0530cell7.setCellStyle(numberStyle);
					} else {
						R0530cell7.setCellValue("");
						R0530cell7.setCellStyle(textStyle);
					}

//ROW62
//Column I: 
					Cell R0530cell8 = row.createCell(8);
					if (record.getR0530_15days_1months() != null) {
						R0530cell8.setCellValue(record.getR0530_15days_1months().doubleValue());
						R0530cell8.setCellStyle(numberStyle);
					} else {
						R0530cell8.setCellValue("");
						R0530cell8.setCellStyle(textStyle);
					}

//ROW62
//Column J: 
					Cell R0530cell9 = row.createCell(9);
					if (record.getR0530_1_2months() != null) {
						R0530cell9.setCellValue(record.getR0530_1_2months().doubleValue());
						R0530cell9.setCellStyle(numberStyle);
					} else {
						R0530cell9.setCellValue("");
						R0530cell9.setCellStyle(textStyle);
					}

//ROW62
//Column K: 
					Cell R0530cell10 = row.createCell(10);
					if (record.getR0530_2_3months() != null) {
						R0530cell10.setCellValue(record.getR0530_2_3months().doubleValue());
						R0530cell10.setCellStyle(numberStyle);
					} else {
						R0530cell10.setCellValue("");
						R0530cell10.setCellStyle(textStyle);
					}

//ROW62
//Column L: 
					Cell R0530cell11 = row.createCell(11);
					if (record.getR0530_3_6months() != null) {
						R0530cell11.setCellValue(record.getR0530_3_6months().doubleValue());
						R0530cell11.setCellStyle(numberStyle);
					} else {
						R0530cell11.setCellValue("");
						R0530cell11.setCellStyle(textStyle);
					}

//ROW62
//Column M: 
					Cell R0530cell12 = row.createCell(12);
					if (record.getR0530_6_12months() != null) {
						R0530cell12.setCellValue(record.getR0530_6_12months().doubleValue());
						R0530cell12.setCellStyle(numberStyle);
					} else {
						R0530cell12.setCellValue("");
						R0530cell12.setCellStyle(textStyle);
					}

//ROW62
//Column N: 
					Cell R0530cell13 = row.createCell(13);
					if (record.getR0530_1_3years() != null) {
						R0530cell13.setCellValue(record.getR0530_1_3years().doubleValue());
						R0530cell13.setCellStyle(numberStyle);
					} else {
						R0530cell13.setCellValue("");
						R0530cell13.setCellStyle(textStyle);
					}

//ROW62
//Column O: 
					Cell R0530cell14 = row.createCell(14);
					if (record.getR0530_3_5years() != null) {
						R0530cell14.setCellValue(record.getR0530_3_5years().doubleValue());
						R0530cell14.setCellStyle(numberStyle);
					} else {
						R0530cell14.setCellValue("");
						R0530cell14.setCellStyle(textStyle);
					}

//ROW62
//Column P: 
					Cell R0530cell15 = row.createCell(15);
					if (record.getR0530_5years() != null) {
						R0530cell15.setCellValue(record.getR0530_5years().doubleValue());
						R0530cell15.setCellStyle(numberStyle);
					} else {
						R0530cell15.setCellValue("");
						R0530cell15.setCellStyle(textStyle);
					}

/////ROW63///////////
//ROW63

					row = sheet.getRow(62);

//Column E: 
					Cell R0540cell4 = row.createCell(4);
					if (record.getR0540_overdue() != null) {
						R0540cell4.setCellValue(record.getR0540_overdue().doubleValue());
						R0540cell4.setCellStyle(numberStyle);
					} else {
						R0540cell4.setCellValue("");
						R0540cell4.setCellStyle(textStyle);
					}

//ROW63
//Column F: 
					Cell R0540cell5 = row.createCell(5);
					if (record.getR0540_overdraft() != null) {
						R0540cell5.setCellValue(record.getR0540_overdraft().doubleValue());
						R0540cell5.setCellStyle(numberStyle);
					} else {
						R0540cell5.setCellValue("");
						R0540cell5.setCellStyle(textStyle);
					}

//ROW63
//Column G: 
					Cell R0540cell6 = row.createCell(6);
					if (record.getR0540_0_7days() != null) {
						R0540cell6.setCellValue(record.getR0540_0_7days().doubleValue());
						R0540cell6.setCellStyle(numberStyle);
					} else {
						R0540cell6.setCellValue("");
						R0540cell6.setCellStyle(textStyle);
					}

//ROW63
//Column H: 
					Cell R0540cell7 = row.createCell(7);
					if (record.getR0540_8_14days() != null) {
						R0540cell7.setCellValue(record.getR0540_8_14days().doubleValue());
						R0540cell7.setCellStyle(numberStyle);
					} else {
						R0540cell7.setCellValue("");
						R0540cell7.setCellStyle(textStyle);
					}

//ROW63
//Column I: 
					Cell R0540cell8 = row.createCell(8);
					if (record.getR0540_15days_1months() != null) {
						R0540cell8.setCellValue(record.getR0540_15days_1months().doubleValue());
						R0540cell8.setCellStyle(numberStyle);
					} else {
						R0540cell8.setCellValue("");
						R0540cell8.setCellStyle(textStyle);
					}

//ROW63
//Column J: 
					Cell R0540cell9 = row.createCell(9);
					if (record.getR0540_1_2months() != null) {
						R0540cell9.setCellValue(record.getR0540_1_2months().doubleValue());
						R0540cell9.setCellStyle(numberStyle);
					} else {
						R0540cell9.setCellValue("");
						R0540cell9.setCellStyle(textStyle);
					}

//ROW63
//Column K: 
					Cell R0540cell10 = row.createCell(10);
					if (record.getR0540_2_3months() != null) {
						R0540cell10.setCellValue(record.getR0540_2_3months().doubleValue());
						R0540cell10.setCellStyle(numberStyle);
					} else {
						R0540cell10.setCellValue("");
						R0540cell10.setCellStyle(textStyle);
					}

//ROW63
//Column L: 
					Cell R0540cell11 = row.createCell(11);
					if (record.getR0540_3_6months() != null) {
						R0540cell11.setCellValue(record.getR0540_3_6months().doubleValue());
						R0540cell11.setCellStyle(numberStyle);
					} else {
						R0540cell11.setCellValue("");
						R0540cell11.setCellStyle(textStyle);
					}

//ROW63
//Column M: 
					Cell R0540cell12 = row.createCell(12);
					if (record.getR0540_6_12months() != null) {
						R0540cell12.setCellValue(record.getR0540_6_12months().doubleValue());
						R0540cell12.setCellStyle(numberStyle);
					} else {
						R0540cell12.setCellValue("");
						R0540cell12.setCellStyle(textStyle);
					}

//ROW63
//Column N: 
					Cell R0540cell13 = row.createCell(13);
					if (record.getR0540_1_3years() != null) {
						R0540cell13.setCellValue(record.getR0540_1_3years().doubleValue());
						R0540cell13.setCellStyle(numberStyle);
					} else {
						R0540cell13.setCellValue("");
						R0540cell13.setCellStyle(textStyle);
					}

//ROW63
//Column O: 
					Cell R0540cell14 = row.createCell(14);
					if (record.getR0540_3_5years() != null) {
						R0540cell14.setCellValue(record.getR0540_3_5years().doubleValue());
						R0540cell14.setCellStyle(numberStyle);
					} else {
						R0540cell14.setCellValue("");
						R0540cell14.setCellStyle(textStyle);
					}

//ROW63
//Column P: 
					Cell R0540cell15 = row.createCell(15);
					if (record.getR0540_5years() != null) {
						R0540cell15.setCellValue(record.getR0540_5years().doubleValue());
						R0540cell15.setCellStyle(numberStyle);
					} else {
						R0540cell15.setCellValue("");
						R0540cell15.setCellStyle(textStyle);
					}

/////ROW64///////////
//ROW64

					row = sheet.getRow(63);

//Column E: 
					Cell R0550cell4 = row.createCell(4);
					if (record.getR0550_overdue() != null) {
						R0550cell4.setCellValue(record.getR0550_overdue().doubleValue());
						R0550cell4.setCellStyle(numberStyle);
					} else {
						R0550cell4.setCellValue("");
						R0550cell4.setCellStyle(textStyle);
					}

//ROW64
//Column F: 
					Cell R0550cell5 = row.createCell(5);
					if (record.getR0550_overdraft() != null) {
						R0550cell5.setCellValue(record.getR0550_overdraft().doubleValue());
						R0550cell5.setCellStyle(numberStyle);
					} else {
						R0550cell5.setCellValue("");
						R0550cell5.setCellStyle(textStyle);
					}

//ROW64
//Column G: 
					Cell R0550cell6 = row.createCell(6);
					if (record.getR0550_0_7days() != null) {
						R0550cell6.setCellValue(record.getR0550_0_7days().doubleValue());
						R0550cell6.setCellStyle(numberStyle);
					} else {
						R0550cell6.setCellValue("");
						R0550cell6.setCellStyle(textStyle);
					}

//ROW64
//Column H: 
					Cell R0550cell7 = row.createCell(7);
					if (record.getR0550_8_14days() != null) {
						R0550cell7.setCellValue(record.getR0550_8_14days().doubleValue());
						R0550cell7.setCellStyle(numberStyle);
					} else {
						R0550cell7.setCellValue("");
						R0550cell7.setCellStyle(textStyle);
					}

//ROW64
//Column I: 
					Cell R0550cell8 = row.createCell(8);
					if (record.getR0550_15days_1months() != null) {
						R0550cell8.setCellValue(record.getR0550_15days_1months().doubleValue());
						R0550cell8.setCellStyle(numberStyle);
					} else {
						R0550cell8.setCellValue("");
						R0550cell8.setCellStyle(textStyle);
					}

//ROW64
//Column J: 
					Cell R0550cell9 = row.createCell(9);
					if (record.getR0550_1_2months() != null) {
						R0550cell9.setCellValue(record.getR0550_1_2months().doubleValue());
						R0550cell9.setCellStyle(numberStyle);
					} else {
						R0550cell9.setCellValue("");
						R0550cell9.setCellStyle(textStyle);
					}

//ROW64
//Column K: 
					Cell R0550cell10 = row.createCell(10);
					if (record.getR0550_2_3months() != null) {
						R0550cell10.setCellValue(record.getR0550_2_3months().doubleValue());
						R0550cell10.setCellStyle(numberStyle);
					} else {
						R0550cell10.setCellValue("");
						R0550cell10.setCellStyle(textStyle);
					}

//ROW64
//Column L: 
					Cell R0550cell11 = row.createCell(11);
					if (record.getR0550_3_6months() != null) {
						R0550cell11.setCellValue(record.getR0550_3_6months().doubleValue());
						R0550cell11.setCellStyle(numberStyle);
					} else {
						R0550cell11.setCellValue("");
						R0550cell11.setCellStyle(textStyle);
					}

//ROW64
//Column M: 
					Cell R0550cell12 = row.createCell(12);
					if (record.getR0550_6_12months() != null) {
						R0550cell12.setCellValue(record.getR0550_6_12months().doubleValue());
						R0550cell12.setCellStyle(numberStyle);
					} else {
						R0550cell12.setCellValue("");
						R0550cell12.setCellStyle(textStyle);
					}

//ROW64
//Column N: 
					Cell R0550cell13 = row.createCell(13);
					if (record.getR0550_1_3years() != null) {
						R0550cell13.setCellValue(record.getR0550_1_3years().doubleValue());
						R0550cell13.setCellStyle(numberStyle);
					} else {
						R0550cell13.setCellValue("");
						R0550cell13.setCellStyle(textStyle);
					}

//ROW64
//Column O: 
					Cell R0550cell14 = row.createCell(14);
					if (record.getR0550_3_5years() != null) {
						R0550cell14.setCellValue(record.getR0550_3_5years().doubleValue());
						R0550cell14.setCellStyle(numberStyle);
					} else {
						R0550cell14.setCellValue("");
						R0550cell14.setCellStyle(textStyle);
					}

//ROW64
//Column P: 
					Cell R0550cell15 = row.createCell(15);
					if (record.getR0550_5years() != null) {
						R0550cell15.setCellValue(record.getR0550_5years().doubleValue());
						R0550cell15.setCellStyle(numberStyle);
					} else {
						R0550cell15.setCellValue("");
						R0550cell15.setCellStyle(textStyle);
					}

/////ROW65///////////
//ROW65

					row = sheet.getRow(64);

//Column E: 
					Cell R0560cell4 = row.createCell(4);
					if (record.getR0560_overdue() != null) {
						R0560cell4.setCellValue(record.getR0560_overdue().doubleValue());
						R0560cell4.setCellStyle(numberStyle);
					} else {
						R0560cell4.setCellValue("");
						R0560cell4.setCellStyle(textStyle);
					}

//ROW65
//Column F: 
					Cell R0560cell5 = row.createCell(5);
					if (record.getR0560_overdraft() != null) {
						R0560cell5.setCellValue(record.getR0560_overdraft().doubleValue());
						R0560cell5.setCellStyle(numberStyle);
					} else {
						R0560cell5.setCellValue("");
						R0560cell5.setCellStyle(textStyle);
					}

//ROW65
//Column G: 
					Cell R0560cell6 = row.createCell(6);
					if (record.getR0560_0_7days() != null) {
						R0560cell6.setCellValue(record.getR0560_0_7days().doubleValue());
						R0560cell6.setCellStyle(numberStyle);
					} else {
						R0560cell6.setCellValue("");
						R0560cell6.setCellStyle(textStyle);
					}

//ROW65
//Column H: 
					Cell R0560cell7 = row.createCell(7);
					if (record.getR0560_8_14days() != null) {
						R0560cell7.setCellValue(record.getR0560_8_14days().doubleValue());
						R0560cell7.setCellStyle(numberStyle);
					} else {
						R0560cell7.setCellValue("");
						R0560cell7.setCellStyle(textStyle);
					}

//ROW65
//Column I: 
					Cell R0560cell8 = row.createCell(8);
					if (record.getR0560_15days_1months() != null) {
						R0560cell8.setCellValue(record.getR0560_15days_1months().doubleValue());
						R0560cell8.setCellStyle(numberStyle);
					} else {
						R0560cell8.setCellValue("");
						R0560cell8.setCellStyle(textStyle);
					}

//ROW65
//Column J: 
					Cell R0560cell9 = row.createCell(9);
					if (record.getR0560_1_2months() != null) {
						R0560cell9.setCellValue(record.getR0560_1_2months().doubleValue());
						R0560cell9.setCellStyle(numberStyle);
					} else {
						R0560cell9.setCellValue("");
						R0560cell9.setCellStyle(textStyle);
					}

//ROW65
//Column K: 
					Cell R0560cell10 = row.createCell(10);
					if (record.getR0560_2_3months() != null) {
						R0560cell10.setCellValue(record.getR0560_2_3months().doubleValue());
						R0560cell10.setCellStyle(numberStyle);
					} else {
						R0560cell10.setCellValue("");
						R0560cell10.setCellStyle(textStyle);
					}

//ROW65
//Column L: 
					Cell R0560cell11 = row.createCell(11);
					if (record.getR0560_3_6months() != null) {
						R0560cell11.setCellValue(record.getR0560_3_6months().doubleValue());
						R0560cell11.setCellStyle(numberStyle);
					} else {
						R0560cell11.setCellValue("");
						R0560cell11.setCellStyle(textStyle);
					}

//ROW65
//Column M: 
					Cell R0560cell12 = row.createCell(12);
					if (record.getR0560_6_12months() != null) {
						R0560cell12.setCellValue(record.getR0560_6_12months().doubleValue());
						R0560cell12.setCellStyle(numberStyle);
					} else {
						R0560cell12.setCellValue("");
						R0560cell12.setCellStyle(textStyle);
					}

//ROW65
//Column N: 
					Cell R0560cell13 = row.createCell(13);
					if (record.getR0560_1_3years() != null) {
						R0560cell13.setCellValue(record.getR0560_1_3years().doubleValue());
						R0560cell13.setCellStyle(numberStyle);
					} else {
						R0560cell13.setCellValue("");
						R0560cell13.setCellStyle(textStyle);
					}

//ROW65
//Column O: 
					Cell R0560cell14 = row.createCell(14);
					if (record.getR0560_3_5years() != null) {
						R0560cell14.setCellValue(record.getR0560_3_5years().doubleValue());
						R0560cell14.setCellStyle(numberStyle);
					} else {
						R0560cell14.setCellValue("");
						R0560cell14.setCellStyle(textStyle);
					}

//ROW65
//Column P: 
					Cell R0560cell15 = row.createCell(15);
					if (record.getR0560_5years() != null) {
						R0560cell15.setCellValue(record.getR0560_5years().doubleValue());
						R0560cell15.setCellStyle(numberStyle);
					} else {
						R0560cell15.setCellValue("");
						R0560cell15.setCellStyle(textStyle);
					}

/////ROW66///////////
//ROW66

					row = sheet.getRow(65);

//Column E: 
					Cell R0570cell4 = row.createCell(4);
					if (record.getR0570_overdue() != null) {
						R0570cell4.setCellValue(record.getR0570_overdue().doubleValue());
						R0570cell4.setCellStyle(numberStyle);
					} else {
						R0570cell4.setCellValue("");
						R0570cell4.setCellStyle(textStyle);
					}

//ROW66
//Column F: 
					Cell R0570cell5 = row.createCell(5);
					if (record.getR0570_overdraft() != null) {
						R0570cell5.setCellValue(record.getR0570_overdraft().doubleValue());
						R0570cell5.setCellStyle(numberStyle);
					} else {
						R0570cell5.setCellValue("");
						R0570cell5.setCellStyle(textStyle);
					}

//ROW66
//Column G: 
					Cell R0570cell6 = row.createCell(6);
					if (record.getR0570_0_7days() != null) {
						R0570cell6.setCellValue(record.getR0570_0_7days().doubleValue());
						R0570cell6.setCellStyle(numberStyle);
					} else {
						R0570cell6.setCellValue("");
						R0570cell6.setCellStyle(textStyle);
					}

//ROW66
//Column H: 
					Cell R0570cell7 = row.createCell(7);
					if (record.getR0570_8_14days() != null) {
						R0570cell7.setCellValue(record.getR0570_8_14days().doubleValue());
						R0570cell7.setCellStyle(numberStyle);
					} else {
						R0570cell7.setCellValue("");
						R0570cell7.setCellStyle(textStyle);
					}

//ROW66
//Column I: 
					Cell R0570cell8 = row.createCell(8);
					if (record.getR0570_15days_1months() != null) {
						R0570cell8.setCellValue(record.getR0570_15days_1months().doubleValue());
						R0570cell8.setCellStyle(numberStyle);
					} else {
						R0570cell8.setCellValue("");
						R0570cell8.setCellStyle(textStyle);
					}

//ROW66
//Column J: 
					Cell R0570cell9 = row.createCell(9);
					if (record.getR0570_1_2months() != null) {
						R0570cell9.setCellValue(record.getR0570_1_2months().doubleValue());
						R0570cell9.setCellStyle(numberStyle);
					} else {
						R0570cell9.setCellValue("");
						R0570cell9.setCellStyle(textStyle);
					}

//ROW66
//Column K: 
					Cell R0570cell10 = row.createCell(10);
					if (record.getR0570_2_3months() != null) {
						R0570cell10.setCellValue(record.getR0570_2_3months().doubleValue());
						R0570cell10.setCellStyle(numberStyle);
					} else {
						R0570cell10.setCellValue("");
						R0570cell10.setCellStyle(textStyle);
					}

//ROW66
//Column L: 
					Cell R0570cell11 = row.createCell(11);
					if (record.getR0570_3_6months() != null) {
						R0570cell11.setCellValue(record.getR0570_3_6months().doubleValue());
						R0570cell11.setCellStyle(numberStyle);
					} else {
						R0570cell11.setCellValue("");
						R0570cell11.setCellStyle(textStyle);
					}

//ROW66
//Column M: 
					Cell R0570cell12 = row.createCell(12);
					if (record.getR0570_6_12months() != null) {
						R0570cell12.setCellValue(record.getR0570_6_12months().doubleValue());
						R0570cell12.setCellStyle(numberStyle);
					} else {
						R0570cell12.setCellValue("");
						R0570cell12.setCellStyle(textStyle);
					}

//ROW66
//Column N: 
					Cell R0570cell13 = row.createCell(13);
					if (record.getR0570_1_3years() != null) {
						R0570cell13.setCellValue(record.getR0570_1_3years().doubleValue());
						R0570cell13.setCellStyle(numberStyle);
					} else {
						R0570cell13.setCellValue("");
						R0570cell13.setCellStyle(textStyle);
					}

//ROW66
//Column O: 
					Cell R0570cell14 = row.createCell(14);
					if (record.getR0570_3_5years() != null) {
						R0570cell14.setCellValue(record.getR0570_3_5years().doubleValue());
						R0570cell14.setCellStyle(numberStyle);
					} else {
						R0570cell14.setCellValue("");
						R0570cell14.setCellStyle(textStyle);
					}

//ROW66
//Column P: 
					Cell R0570cell15 = row.createCell(15);
					if (record.getR0570_5years() != null) {
						R0570cell15.setCellValue(record.getR0570_5years().doubleValue());
						R0570cell15.setCellStyle(numberStyle);
					} else {
						R0570cell15.setCellValue("");
						R0570cell15.setCellStyle(textStyle);
					}

/////ROW67///////////
//ROW67

					row = sheet.getRow(66);

//Column E: 
					Cell R0580cell4 = row.createCell(4);
					if (record.getR0580_overdue() != null) {
						R0580cell4.setCellValue(record.getR0580_overdue().doubleValue());
						R0580cell4.setCellStyle(numberStyle);
					} else {
						R0580cell4.setCellValue("");
						R0580cell4.setCellStyle(textStyle);
					}

//ROW67
//Column F: 
					Cell R0580cell5 = row.createCell(5);
					if (record.getR0580_overdraft() != null) {
						R0580cell5.setCellValue(record.getR0580_overdraft().doubleValue());
						R0580cell5.setCellStyle(numberStyle);
					} else {
						R0580cell5.setCellValue("");
						R0580cell5.setCellStyle(textStyle);
					}

//ROW67
//Column G: 
					Cell R0580cell6 = row.createCell(6);
					if (record.getR0580_0_7days() != null) {
						R0580cell6.setCellValue(record.getR0580_0_7days().doubleValue());
						R0580cell6.setCellStyle(numberStyle);
					} else {
						R0580cell6.setCellValue("");
						R0580cell6.setCellStyle(textStyle);
					}

//ROW67
//Column H: 
					Cell R0580cell7 = row.createCell(7);
					if (record.getR0580_8_14days() != null) {
						R0580cell7.setCellValue(record.getR0580_8_14days().doubleValue());
						R0580cell7.setCellStyle(numberStyle);
					} else {
						R0580cell7.setCellValue("");
						R0580cell7.setCellStyle(textStyle);
					}

//ROW67
//Column I: 
					Cell R0580cell8 = row.createCell(8);
					if (record.getR0580_15days_1months() != null) {
						R0580cell8.setCellValue(record.getR0580_15days_1months().doubleValue());
						R0580cell8.setCellStyle(numberStyle);
					} else {
						R0580cell8.setCellValue("");
						R0580cell8.setCellStyle(textStyle);
					}

//ROW67
//Column J: 
					Cell R0580cell9 = row.createCell(9);
					if (record.getR0580_1_2months() != null) {
						R0580cell9.setCellValue(record.getR0580_1_2months().doubleValue());
						R0580cell9.setCellStyle(numberStyle);
					} else {
						R0580cell9.setCellValue("");
						R0580cell9.setCellStyle(textStyle);
					}

//ROW67
//Column K: 
					Cell R0580cell10 = row.createCell(10);
					if (record.getR0580_2_3months() != null) {
						R0580cell10.setCellValue(record.getR0580_2_3months().doubleValue());
						R0580cell10.setCellStyle(numberStyle);
					} else {
						R0580cell10.setCellValue("");
						R0580cell10.setCellStyle(textStyle);
					}

//ROW67
//Column L: 
					Cell R0580cell11 = row.createCell(11);
					if (record.getR0580_3_6months() != null) {
						R0580cell11.setCellValue(record.getR0580_3_6months().doubleValue());
						R0580cell11.setCellStyle(numberStyle);
					} else {
						R0580cell11.setCellValue("");
						R0580cell11.setCellStyle(textStyle);
					}

//ROW67
//Column M: 
					Cell R0580cell12 = row.createCell(12);
					if (record.getR0580_6_12months() != null) {
						R0580cell12.setCellValue(record.getR0580_6_12months().doubleValue());
						R0580cell12.setCellStyle(numberStyle);
					} else {
						R0580cell12.setCellValue("");
						R0580cell12.setCellStyle(textStyle);
					}

//ROW67
//Column N: 
					Cell R0580cell13 = row.createCell(13);
					if (record.getR0580_1_3years() != null) {
						R0580cell13.setCellValue(record.getR0580_1_3years().doubleValue());
						R0580cell13.setCellStyle(numberStyle);
					} else {
						R0580cell13.setCellValue("");
						R0580cell13.setCellStyle(textStyle);
					}

//ROW67
//Column O: 
					Cell R0580cell14 = row.createCell(14);
					if (record.getR0580_3_5years() != null) {
						R0580cell14.setCellValue(record.getR0580_3_5years().doubleValue());
						R0580cell14.setCellStyle(numberStyle);
					} else {
						R0580cell14.setCellValue("");
						R0580cell14.setCellStyle(textStyle);
					}

//ROW67
//Column P: 
					Cell R0580cell15 = row.createCell(15);
					if (record.getR0580_5years() != null) {
						R0580cell15.setCellValue(record.getR0580_5years().doubleValue());
						R0580cell15.setCellStyle(numberStyle);
					} else {
						R0580cell15.setCellValue("");
						R0580cell15.setCellStyle(textStyle);
					}

/////ROW69///////////
//ROW69

					row = sheet.getRow(68);

//Column E: 
					Cell R0600cell4 = row.createCell(4);
					if (record.getR0600_overdue() != null) {
						R0600cell4.setCellValue(record.getR0600_overdue().doubleValue());
						R0600cell4.setCellStyle(numberStyle);
					} else {
						R0600cell4.setCellValue("");
						R0600cell4.setCellStyle(textStyle);
					}

//ROW69
//Column F: 
					Cell R0600cell5 = row.createCell(5);
					if (record.getR0600_overdraft() != null) {
						R0600cell5.setCellValue(record.getR0600_overdraft().doubleValue());
						R0600cell5.setCellStyle(numberStyle);
					} else {
						R0600cell5.setCellValue("");
						R0600cell5.setCellStyle(textStyle);
					}

//ROW69
//Column G: 
					Cell R0600cell6 = row.createCell(6);
					if (record.getR0600_0_7days() != null) {
						R0600cell6.setCellValue(record.getR0600_0_7days().doubleValue());
						R0600cell6.setCellStyle(numberStyle);
					} else {
						R0600cell6.setCellValue("");
						R0600cell6.setCellStyle(textStyle);
					}

//ROW69
//Column H: 
					Cell R0600cell7 = row.createCell(7);
					if (record.getR0600_8_14days() != null) {
						R0600cell7.setCellValue(record.getR0600_8_14days().doubleValue());
						R0600cell7.setCellStyle(numberStyle);
					} else {
						R0600cell7.setCellValue("");
						R0600cell7.setCellStyle(textStyle);
					}

//ROW69
//Column I: 
					Cell R0600cell8 = row.createCell(8);
					if (record.getR0600_15days_1months() != null) {
						R0600cell8.setCellValue(record.getR0600_15days_1months().doubleValue());
						R0600cell8.setCellStyle(numberStyle);
					} else {
						R0600cell8.setCellValue("");
						R0600cell8.setCellStyle(textStyle);
					}

//ROW69
//Column J: 
					Cell R0600cell9 = row.createCell(9);
					if (record.getR0600_1_2months() != null) {
						R0600cell9.setCellValue(record.getR0600_1_2months().doubleValue());
						R0600cell9.setCellStyle(numberStyle);
					} else {
						R0600cell9.setCellValue("");
						R0600cell9.setCellStyle(textStyle);
					}

//ROW69
//Column K: 
					Cell R0600cell10 = row.createCell(10);
					if (record.getR0600_2_3months() != null) {
						R0600cell10.setCellValue(record.getR0600_2_3months().doubleValue());
						R0600cell10.setCellStyle(numberStyle);
					} else {
						R0600cell10.setCellValue("");
						R0600cell10.setCellStyle(textStyle);
					}

//ROW69
//Column L: 
					Cell R0600cell11 = row.createCell(11);
					if (record.getR0600_3_6months() != null) {
						R0600cell11.setCellValue(record.getR0600_3_6months().doubleValue());
						R0600cell11.setCellStyle(numberStyle);
					} else {
						R0600cell11.setCellValue("");
						R0600cell11.setCellStyle(textStyle);
					}

//ROW69
//Column M: 
					Cell R0600cell12 = row.createCell(12);
					if (record.getR0600_6_12months() != null) {
						R0600cell12.setCellValue(record.getR0600_6_12months().doubleValue());
						R0600cell12.setCellStyle(numberStyle);
					} else {
						R0600cell12.setCellValue("");
						R0600cell12.setCellStyle(textStyle);
					}

//ROW69
//Column N: 
					Cell R0600cell13 = row.createCell(13);
					if (record.getR0600_1_3years() != null) {
						R0600cell13.setCellValue(record.getR0600_1_3years().doubleValue());
						R0600cell13.setCellStyle(numberStyle);
					} else {
						R0600cell13.setCellValue("");
						R0600cell13.setCellStyle(textStyle);
					}

//ROW69
//Column O: 
					Cell R0600cell14 = row.createCell(14);
					if (record.getR0600_3_5years() != null) {
						R0600cell14.setCellValue(record.getR0600_3_5years().doubleValue());
						R0600cell14.setCellStyle(numberStyle);
					} else {
						R0600cell14.setCellValue("");
						R0600cell14.setCellStyle(textStyle);
					}

//ROW69
//Column P: 
					Cell R0600cell15 = row.createCell(15);
					if (record.getR0600_5years() != null) {
						R0600cell15.setCellValue(record.getR0600_5years().doubleValue());
						R0600cell15.setCellStyle(numberStyle);
					} else {
						R0600cell15.setCellValue("");
						R0600cell15.setCellStyle(textStyle);
					}

/////ROW70///////////
//ROW70

					row = sheet.getRow(69);

//Column E: 
					Cell R0610cell4 = row.createCell(4);
					if (record.getR0610_overdue() != null) {
						R0610cell4.setCellValue(record.getR0610_overdue().doubleValue());
						R0610cell4.setCellStyle(numberStyle);
					} else {
						R0610cell4.setCellValue("");
						R0610cell4.setCellStyle(textStyle);
					}

//ROW70
//Column F: 
					Cell R0610cell5 = row.createCell(5);
					if (record.getR0610_overdraft() != null) {
						R0610cell5.setCellValue(record.getR0610_overdraft().doubleValue());
						R0610cell5.setCellStyle(numberStyle);
					} else {
						R0610cell5.setCellValue("");
						R0610cell5.setCellStyle(textStyle);
					}

//ROW70
//Column G: 
					Cell R0610cell6 = row.createCell(6);
					if (record.getR0610_0_7days() != null) {
						R0610cell6.setCellValue(record.getR0610_0_7days().doubleValue());
						R0610cell6.setCellStyle(numberStyle);
					} else {
						R0610cell6.setCellValue("");
						R0610cell6.setCellStyle(textStyle);
					}

//ROW70
//Column H: 
					Cell R0610cell7 = row.createCell(7);
					if (record.getR0610_8_14days() != null) {
						R0610cell7.setCellValue(record.getR0610_8_14days().doubleValue());
						R0610cell7.setCellStyle(numberStyle);
					} else {
						R0610cell7.setCellValue("");
						R0610cell7.setCellStyle(textStyle);
					}

//ROW70
//Column I: 
					Cell R0610cell8 = row.createCell(8);
					if (record.getR0610_15days_1months() != null) {
						R0610cell8.setCellValue(record.getR0610_15days_1months().doubleValue());
						R0610cell8.setCellStyle(numberStyle);
					} else {
						R0610cell8.setCellValue("");
						R0610cell8.setCellStyle(textStyle);
					}

//ROW70
//Column J: 
					Cell R0610cell9 = row.createCell(9);
					if (record.getR0610_1_2months() != null) {
						R0610cell9.setCellValue(record.getR0610_1_2months().doubleValue());
						R0610cell9.setCellStyle(numberStyle);
					} else {
						R0610cell9.setCellValue("");
						R0610cell9.setCellStyle(textStyle);
					}

//ROW70
//Column K: 
					Cell R0610cell10 = row.createCell(10);
					if (record.getR0610_2_3months() != null) {
						R0610cell10.setCellValue(record.getR0610_2_3months().doubleValue());
						R0610cell10.setCellStyle(numberStyle);
					} else {
						R0610cell10.setCellValue("");
						R0610cell10.setCellStyle(textStyle);
					}

//ROW70
//Column L: 
					Cell R0610cell11 = row.createCell(11);
					if (record.getR0610_3_6months() != null) {
						R0610cell11.setCellValue(record.getR0610_3_6months().doubleValue());
						R0610cell11.setCellStyle(numberStyle);
					} else {
						R0610cell11.setCellValue("");
						R0610cell11.setCellStyle(textStyle);
					}

//ROW70
//Column M: 
					Cell R0610cell12 = row.createCell(12);
					if (record.getR0610_6_12months() != null) {
						R0610cell12.setCellValue(record.getR0610_6_12months().doubleValue());
						R0610cell12.setCellStyle(numberStyle);
					} else {
						R0610cell12.setCellValue("");
						R0610cell12.setCellStyle(textStyle);
					}

//ROW70
//Column N: 
					Cell R0610cell13 = row.createCell(13);
					if (record.getR0610_1_3years() != null) {
						R0610cell13.setCellValue(record.getR0610_1_3years().doubleValue());
						R0610cell13.setCellStyle(numberStyle);
					} else {
						R0610cell13.setCellValue("");
						R0610cell13.setCellStyle(textStyle);
					}

//ROW70
//Column O: 
					Cell R0610cell14 = row.createCell(14);
					if (record.getR0610_3_5years() != null) {
						R0610cell14.setCellValue(record.getR0610_3_5years().doubleValue());
						R0610cell14.setCellStyle(numberStyle);
					} else {
						R0610cell14.setCellValue("");
						R0610cell14.setCellStyle(textStyle);
					}

//ROW70
//Column P: 
					Cell R0610cell15 = row.createCell(15);
					if (record.getR0610_5years() != null) {
						R0610cell15.setCellValue(record.getR0610_5years().doubleValue());
						R0610cell15.setCellStyle(numberStyle);
					} else {
						R0610cell15.setCellValue("");
						R0610cell15.setCellStyle(textStyle);
					}

/////ROW71///////////
//ROW71

					row = sheet.getRow(70);

//Column E: 
					Cell R0620cell4 = row.createCell(4);
					if (record.getR0620_overdue() != null) {
						R0620cell4.setCellValue(record.getR0620_overdue().doubleValue());
						R0620cell4.setCellStyle(numberStyle);
					} else {
						R0620cell4.setCellValue("");
						R0620cell4.setCellStyle(textStyle);
					}

//ROW71
//Column F: 
					Cell R0620cell5 = row.createCell(5);
					if (record.getR0620_overdraft() != null) {
						R0620cell5.setCellValue(record.getR0620_overdraft().doubleValue());
						R0620cell5.setCellStyle(numberStyle);
					} else {
						R0620cell5.setCellValue("");
						R0620cell5.setCellStyle(textStyle);
					}

//ROW71
//Column G: 
					Cell R0620cell6 = row.createCell(6);
					if (record.getR0620_0_7days() != null) {
						R0620cell6.setCellValue(record.getR0620_0_7days().doubleValue());
						R0620cell6.setCellStyle(numberStyle);
					} else {
						R0620cell6.setCellValue("");
						R0620cell6.setCellStyle(textStyle);
					}

//ROW71
//Column H: 
					Cell R0620cell7 = row.createCell(7);
					if (record.getR0620_8_14days() != null) {
						R0620cell7.setCellValue(record.getR0620_8_14days().doubleValue());
						R0620cell7.setCellStyle(numberStyle);
					} else {
						R0620cell7.setCellValue("");
						R0620cell7.setCellStyle(textStyle);
					}

//ROW71
//Column I: 
					Cell R0620cell8 = row.createCell(8);
					if (record.getR0620_15days_1months() != null) {
						R0620cell8.setCellValue(record.getR0620_15days_1months().doubleValue());
						R0620cell8.setCellStyle(numberStyle);
					} else {
						R0620cell8.setCellValue("");
						R0620cell8.setCellStyle(textStyle);
					}

//ROW71
//Column J: 
					Cell R0620cell9 = row.createCell(9);
					if (record.getR0620_1_2months() != null) {
						R0620cell9.setCellValue(record.getR0620_1_2months().doubleValue());
						R0620cell9.setCellStyle(numberStyle);
					} else {
						R0620cell9.setCellValue("");
						R0620cell9.setCellStyle(textStyle);
					}

//ROW71
//Column K: 
					Cell R0620cell10 = row.createCell(10);
					if (record.getR0620_2_3months() != null) {
						R0620cell10.setCellValue(record.getR0620_2_3months().doubleValue());
						R0620cell10.setCellStyle(numberStyle);
					} else {
						R0620cell10.setCellValue("");
						R0620cell10.setCellStyle(textStyle);
					}

//ROW71
//Column L: 
					Cell R0620cell11 = row.createCell(11);
					if (record.getR0620_3_6months() != null) {
						R0620cell11.setCellValue(record.getR0620_3_6months().doubleValue());
						R0620cell11.setCellStyle(numberStyle);
					} else {
						R0620cell11.setCellValue("");
						R0620cell11.setCellStyle(textStyle);
					}

//ROW71
//Column M: 
					Cell R0620cell12 = row.createCell(12);
					if (record.getR0620_6_12months() != null) {
						R0620cell12.setCellValue(record.getR0620_6_12months().doubleValue());
						R0620cell12.setCellStyle(numberStyle);
					} else {
						R0620cell12.setCellValue("");
						R0620cell12.setCellStyle(textStyle);
					}

//ROW71
//Column N: 
					Cell R0620cell13 = row.createCell(13);
					if (record.getR0620_1_3years() != null) {
						R0620cell13.setCellValue(record.getR0620_1_3years().doubleValue());
						R0620cell13.setCellStyle(numberStyle);
					} else {
						R0620cell13.setCellValue("");
						R0620cell13.setCellStyle(textStyle);
					}

//ROW71
//Column O: 
					Cell R0620cell14 = row.createCell(14);
					if (record.getR0620_3_5years() != null) {
						R0620cell14.setCellValue(record.getR0620_3_5years().doubleValue());
						R0620cell14.setCellStyle(numberStyle);
					} else {
						R0620cell14.setCellValue("");
						R0620cell14.setCellStyle(textStyle);
					}

//ROW71
//Column P: 
					Cell R0620cell15 = row.createCell(15);
					if (record.getR0620_5years() != null) {
						R0620cell15.setCellValue(record.getR0620_5years().doubleValue());
						R0620cell15.setCellStyle(numberStyle);
					} else {
						R0620cell15.setCellValue("");
						R0620cell15.setCellStyle(textStyle);
					}

/////ROW72///////////
//ROW72

					row = sheet.getRow(71);

//Column E: 
					Cell R0630cell4 = row.createCell(4);
					if (record.getR0630_overdue() != null) {
						R0630cell4.setCellValue(record.getR0630_overdue().doubleValue());
						R0630cell4.setCellStyle(numberStyle);
					} else {
						R0630cell4.setCellValue("");
						R0630cell4.setCellStyle(textStyle);
					}

//ROW72
//Column F: 
					Cell R0630cell5 = row.createCell(5);
					if (record.getR0630_overdraft() != null) {
						R0630cell5.setCellValue(record.getR0630_overdraft().doubleValue());
						R0630cell5.setCellStyle(numberStyle);
					} else {
						R0630cell5.setCellValue("");
						R0630cell5.setCellStyle(textStyle);
					}

//ROW72
//Column G: 
					Cell R0630cell6 = row.createCell(6);
					if (record.getR0630_0_7days() != null) {
						R0630cell6.setCellValue(record.getR0630_0_7days().doubleValue());
						R0630cell6.setCellStyle(numberStyle);
					} else {
						R0630cell6.setCellValue("");
						R0630cell6.setCellStyle(textStyle);
					}

//ROW72
//Column H: 
					Cell R0630cell7 = row.createCell(7);
					if (record.getR0630_8_14days() != null) {
						R0630cell7.setCellValue(record.getR0630_8_14days().doubleValue());
						R0630cell7.setCellStyle(numberStyle);
					} else {
						R0630cell7.setCellValue("");
						R0630cell7.setCellStyle(textStyle);
					}

//ROW72
//Column I: 
					Cell R0630cell8 = row.createCell(8);
					if (record.getR0630_15days_1months() != null) {
						R0630cell8.setCellValue(record.getR0630_15days_1months().doubleValue());
						R0630cell8.setCellStyle(numberStyle);
					} else {
						R0630cell8.setCellValue("");
						R0630cell8.setCellStyle(textStyle);
					}

//ROW72
//Column J: 
					Cell R0630cell9 = row.createCell(9);
					if (record.getR0630_1_2months() != null) {
						R0630cell9.setCellValue(record.getR0630_1_2months().doubleValue());
						R0630cell9.setCellStyle(numberStyle);
					} else {
						R0630cell9.setCellValue("");
						R0630cell9.setCellStyle(textStyle);
					}

//ROW72
//Column K: 
					Cell R0630cell10 = row.createCell(10);
					if (record.getR0630_2_3months() != null) {
						R0630cell10.setCellValue(record.getR0630_2_3months().doubleValue());
						R0630cell10.setCellStyle(numberStyle);
					} else {
						R0630cell10.setCellValue("");
						R0630cell10.setCellStyle(textStyle);
					}

//ROW72
//Column L: 
					Cell R0630cell11 = row.createCell(11);
					if (record.getR0630_3_6months() != null) {
						R0630cell11.setCellValue(record.getR0630_3_6months().doubleValue());
						R0630cell11.setCellStyle(numberStyle);
					} else {
						R0630cell11.setCellValue("");
						R0630cell11.setCellStyle(textStyle);
					}

//ROW72
//Column M: 
					Cell R0630cell12 = row.createCell(12);
					if (record.getR0630_6_12months() != null) {
						R0630cell12.setCellValue(record.getR0630_6_12months().doubleValue());
						R0630cell12.setCellStyle(numberStyle);
					} else {
						R0630cell12.setCellValue("");
						R0630cell12.setCellStyle(textStyle);
					}

//ROW72
//Column N: 
					Cell R0630cell13 = row.createCell(13);
					if (record.getR0630_1_3years() != null) {
						R0630cell13.setCellValue(record.getR0630_1_3years().doubleValue());
						R0630cell13.setCellStyle(numberStyle);
					} else {
						R0630cell13.setCellValue("");
						R0630cell13.setCellStyle(textStyle);
					}

//ROW72
//Column O: 
					Cell R0630cell14 = row.createCell(14);
					if (record.getR0630_3_5years() != null) {
						R0630cell14.setCellValue(record.getR0630_3_5years().doubleValue());
						R0630cell14.setCellStyle(numberStyle);
					} else {
						R0630cell14.setCellValue("");
						R0630cell14.setCellStyle(textStyle);
					}

//ROW72
//Column P: 
					Cell R0630cell15 = row.createCell(15);
					if (record.getR0630_5years() != null) {
						R0630cell15.setCellValue(record.getR0630_5years().doubleValue());
						R0630cell15.setCellStyle(numberStyle);
					} else {
						R0630cell15.setCellValue("");
						R0630cell15.setCellStyle(textStyle);
					}

/////ROW73///////////
//ROW73

					row = sheet.getRow(72);

//Column E: 
					Cell R0640cell4 = row.createCell(4);
					if (record.getR0640_overdue() != null) {
						R0640cell4.setCellValue(record.getR0640_overdue().doubleValue());
						R0640cell4.setCellStyle(numberStyle);
					} else {
						R0640cell4.setCellValue("");
						R0640cell4.setCellStyle(textStyle);
					}

//ROW73
//Column F: 
					Cell R0640cell5 = row.createCell(5);
					if (record.getR0640_overdraft() != null) {
						R0640cell5.setCellValue(record.getR0640_overdraft().doubleValue());
						R0640cell5.setCellStyle(numberStyle);
					} else {
						R0640cell5.setCellValue("");
						R0640cell5.setCellStyle(textStyle);
					}

//ROW73
//Column G: 
					Cell R0640cell6 = row.createCell(6);
					if (record.getR0640_0_7days() != null) {
						R0640cell6.setCellValue(record.getR0640_0_7days().doubleValue());
						R0640cell6.setCellStyle(numberStyle);
					} else {
						R0640cell6.setCellValue("");
						R0640cell6.setCellStyle(textStyle);
					}

//ROW73
//Column H: 
					Cell R0640cell7 = row.createCell(7);
					if (record.getR0640_8_14days() != null) {
						R0640cell7.setCellValue(record.getR0640_8_14days().doubleValue());
						R0640cell7.setCellStyle(numberStyle);
					} else {
						R0640cell7.setCellValue("");
						R0640cell7.setCellStyle(textStyle);
					}

//ROW73
//Column I: 
					Cell R0640cell8 = row.createCell(8);
					if (record.getR0640_15days_1months() != null) {
						R0640cell8.setCellValue(record.getR0640_15days_1months().doubleValue());
						R0640cell8.setCellStyle(numberStyle);
					} else {
						R0640cell8.setCellValue("");
						R0640cell8.setCellStyle(textStyle);
					}

//ROW73
//Column J: 
					Cell R0640cell9 = row.createCell(9);
					if (record.getR0640_1_2months() != null) {
						R0640cell9.setCellValue(record.getR0640_1_2months().doubleValue());
						R0640cell9.setCellStyle(numberStyle);
					} else {
						R0640cell9.setCellValue("");
						R0640cell9.setCellStyle(textStyle);
					}

//ROW73
//Column K: 
					Cell R0640cell10 = row.createCell(10);
					if (record.getR0640_2_3months() != null) {
						R0640cell10.setCellValue(record.getR0640_2_3months().doubleValue());
						R0640cell10.setCellStyle(numberStyle);
					} else {
						R0640cell10.setCellValue("");
						R0640cell10.setCellStyle(textStyle);
					}

//ROW73
//Column L: 
					Cell R0640cell11 = row.createCell(11);
					if (record.getR0640_3_6months() != null) {
						R0640cell11.setCellValue(record.getR0640_3_6months().doubleValue());
						R0640cell11.setCellStyle(numberStyle);
					} else {
						R0640cell11.setCellValue("");
						R0640cell11.setCellStyle(textStyle);
					}

//ROW73
//Column M: 
					Cell R0640cell12 = row.createCell(12);
					if (record.getR0640_6_12months() != null) {
						R0640cell12.setCellValue(record.getR0640_6_12months().doubleValue());
						R0640cell12.setCellStyle(numberStyle);
					} else {
						R0640cell12.setCellValue("");
						R0640cell12.setCellStyle(textStyle);
					}

//ROW73
//Column N: 
					Cell R0640cell13 = row.createCell(13);
					if (record.getR0640_1_3years() != null) {
						R0640cell13.setCellValue(record.getR0640_1_3years().doubleValue());
						R0640cell13.setCellStyle(numberStyle);
					} else {
						R0640cell13.setCellValue("");
						R0640cell13.setCellStyle(textStyle);
					}

//ROW73
//Column O: 
					Cell R0640cell14 = row.createCell(14);
					if (record.getR0640_3_5years() != null) {
						R0640cell14.setCellValue(record.getR0640_3_5years().doubleValue());
						R0640cell14.setCellStyle(numberStyle);
					} else {
						R0640cell14.setCellValue("");
						R0640cell14.setCellStyle(textStyle);
					}

//ROW73
//Column P: 
					Cell R0640cell15 = row.createCell(15);
					if (record.getR0640_5years() != null) {
						R0640cell15.setCellValue(record.getR0640_5years().doubleValue());
						R0640cell15.setCellStyle(numberStyle);
					} else {
						R0640cell15.setCellValue("");
						R0640cell15.setCellStyle(textStyle);
					}

				}

				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {

			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}
	
	
	public byte[] getBRF2_3DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF2_3 ARCHIVAL Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {

			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF2_3Details");

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
			List<CBUAE_BRF2_3_Archival_Detail_Entity> reportData = BRF2_3_archival_detail_repo
					.getdatabydateList(parsedToDate, version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF2_3_Archival_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF2_3 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF2_3 Excel", e);
			return new byte[0];
		}
	}
	

	  public ModelAndView getViewOrEditPage(String custId, String acctNo, String formMode) {

		    ModelAndView mv = new ModelAndView("BRF/BRF2_3");

		    // Load data using acctNo (NOT custId)
		    if (acctNo != null && !acctNo.isEmpty()) {

		    	CBUAE_BRF2_3_Detail_Entity brf2_3Entity =
		    			CBUAE_BRF2_3_DETAIL_REPO.findByAcctNumber(acctNo);

		        if (brf2_3Entity != null && brf2_3Entity.getReportDate() != null) {
		            String formattedDate =
		                    new SimpleDateFormat("dd/MM/yyyy").format(brf2_3Entity.getReportDate());
		            mv.addObject("asondate", formattedDate);
		        }

		        mv.addObject("BRF2_3", brf2_3Entity);
		    }

		    mv.addObject("custId", custId);                      // keep if needed
		    mv.addObject("acctNo", acctNo);
		    mv.addObject("displaymode", "edit");
		    mv.addObject("formmode", (formMode != null ? formMode : "edit"));

		    return mv;
		}
	  
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Transactional
		public ResponseEntity<?> updateDetailEdit(HttpServletRequest request) {
			try {
				String acctNo = request.getParameter("acctNumber");
				String balanceStr = request.getParameter("acctBalanceInAed");
				String acctName = request.getParameter("acctName");
				String reportDateStr = request.getParameter("reportDate");

				logger.info("Received update for ACCT_NO: {}", acctNo);

				CBUAE_BRF2_3_Detail_Entity existing = CBUAE_BRF2_3_DETAIL_REPO.findByAcctNumber(acctNo);
				if (existing == null) {
					logger.warn("No record found for ACCT_NO: {}", acctNo);
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found for update.");
				}

				boolean isChanged = false;

				if (acctName != null && !acctName.isEmpty()) {
					if (existing.getAcctName() == null || !existing.getAcctName().equals(acctName)) {
						existing.setAcctName(acctName);
						isChanged = true;
						logger.info("Account name updated to {}", acctName);
					}
				}
				if (balanceStr != null && !balanceStr.isEmpty()) {
					BigDecimal newBalance = new BigDecimal(balanceStr);
					if (existing.getAcctBalanceInAed() == null
							|| existing.getAcctBalanceInAed().compareTo(newBalance) != 0) {
						existing.setAcctBalanceInAed(newBalance);
						isChanged = true;
						logger.info("Provision updated to {}", newBalance);
					}
				}

				if (isChanged) {
					CBUAE_BRF2_3_DETAIL_REPO.save(existing);
					logger.info("Record updated successfully for account {}", acctNo);

					// Format date for procedure
					String formattedDate = new SimpleDateFormat("dd-MM-yyyy")
							.format(new SimpleDateFormat("yyyy-MM-dd").parse(reportDateStr));

					// Run summary procedure after commit
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							try {
								logger.info("Transaction committed — calling CBUAE_BRF2_3_SUMMARY_PROCEDURE({})",
										formattedDate);
								jdbcTemplate.update("BEGIN CBUAE_BRF2_3_SUMMARY_PROCEDURE(?); END;", formattedDate);
								logger.info("Procedure executed successfully after commit.");
							} catch (Exception e) {
								logger.error("Error executing procedure after commit", e);
							}
						}
					});

					return ResponseEntity.ok("Record updated successfully!");
				} else {
					logger.info("No changes detected for ACCT_NO: {}", acctNo);
					return ResponseEntity.ok("No changes were made.");
				}

			} catch (Exception e) {
				logger.error("Error updating M_PLL record", e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Error updating record: " + e.getMessage());
			}
		}
	
}
