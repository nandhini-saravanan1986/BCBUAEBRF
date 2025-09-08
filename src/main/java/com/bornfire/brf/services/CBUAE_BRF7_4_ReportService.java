
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
import java.util.Date;
import java.util.List;

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

import com.bornfire.brf.entities.CBUAE_BRF1_12_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Archival_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_1_Summary_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_1__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Detail_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Summary_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Summary_Archival_Repo;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Detail_Archival_Repo;

@Component
@Service
public class CBUAE_BRF7_4_ReportService {

	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF7_4_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF7_4_Detail_Repo CBUAE_BRF7_4_Detail_Repos;

	@Autowired
	CBUAE_BRF7_4_Summary_Repo CBUAE_BRF7_4_Summary_Repos;
	
	@Autowired
	CBUAE_BRF7_4_Summary_Archival_Repo CBUAE_BRF7_4_Summary_Archival_Repo;
	
	@Autowired
	CBUAE_BRF7_4_Detail_Archival_Repo CBUAE_BRF7_4_Detail_Archival_Repo;
	
	

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF7_4View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {
		
		System.out.println("getBRF7_4View");
		ModelAndView mv = new ModelAndView();
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF7_4_Summary_Archival_Entity> T1Master = new ArrayList<CBUAE_BRF7_4_Summary_Archival_Entity>();
			try {
				Date d1 = dateformat.parse(todate);
				T1Master = CBUAE_BRF7_4_Summary_Archival_Repo.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}

			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF7_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF7_4_Summary_Entity>();
			try {
				T1Master = CBUAE_BRF7_4_Summary_Repos.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
		}
					
			
		mv.setViewName("BRF/BRF7_4");
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF7_4currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter,String type, String version) {
		
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int totalPages=0;
		
		ModelAndView mv = new ModelAndView();
		
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF7_4_Detail_Archival_Entity> T1Dt1 = new ArrayList<CBUAE_BRF7_4_Detail_Archival_Entity>();
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
					T1Dt1 = CBUAE_BRF7_4_Detail_Archival_Repo.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate),
							version);

					System.out.println("countavd" + T1Dt1.size());
				} else {

					T1Dt1 = CBUAE_BRF7_4_Detail_Archival_Repo.getdatabydateList(dateformat.parse(todate), version,currentPage,pageSize);
					totalPages=CBUAE_BRF7_4_Detail_Archival_Repo.getdatacount(dateformat.parse(todate),version);
					mv.addObject("pagination","YES");
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		else {
			List<CBUAE_BRF7_4_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF7_4_Detail_Entity>();
			try {

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
					T1Dt1 = CBUAE_BRF7_4_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
			} else {

					T1Dt1 = CBUAE_BRF7_4_Detail_Repos.getdatabydateList(dateformat.parse(todate),currentPage,pageSize);
					totalPages=CBUAE_BRF7_4_Detail_Repos.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination","YES");
			}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);
				System.out.println("LISTCOUNT" + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

			

		mv.setViewName("BRF/BRF7_4");
		mv.addObject("displaymode", "Details");
   	  	mv.addObject("currentPage", currentPage);
   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
		mv.addObject("displaymode", "Details");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
	
	
	public byte[] getBRF7_4Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF7_4ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}
		
		
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF7_4_Summary_Entity> dataList = CBUAE_BRF7_4_Summary_Repos
				.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF7.4 report. Returning empty result.");
			return new byte[0];
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
//numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);

			String[] rowCodesPart1 = { "R0020","R0030", "R0040", "R0050", "R0060", "R0070", "R0080", "R0090",
					"R0100", "R0110", "R0120", "R0130", "R0140", "R0150", "R0160","R0170", "R0180", "R0190", 
					"R0200", "R0210", "R0220", "R0230"};
			String[] rowCodesPart2 = {
				    "R0250", "R0260", "R0270", "R0280", "R0290", "R0300", "R0310", "R0320", "R0330",
				    "R0340", "R0350", "R0360", "R0370", "R0380", "R0390", "R0400", "R0410", "R0420",
				    "R0430", "R0440", "R0450", "R0460", "R0470"
				};

			String[] rowCodesPart3 = {
				    "R0490", "R0500", "R0510", "R0520", "R0530", "R0540", "R0550", "R0560",
				    "R0570", "R0580", "R0590", "R0600", "R0610", "R0620", "R0630", "R0640"
				};


			String[] fieldSuffixes = {
				    "product",
				    "fedaral_govt",
				    "non_comm_entity_fed_govt",
				    "local_govt",
				    "non_comm_entity_emirates_govt",
				    "gre",
				    "private_sector_gre",
				    "private_sector_banks",
				    "private_sector_financial_institutions",
				    "private_sector_other_private_entities",
				    "total_amount"
				};


			writeRowData(sheet, dataList, rowCodesPart1, fieldSuffixes, 11, numberStyle, textStyle);
			writeRowData(sheet, dataList, rowCodesPart2, fieldSuffixes, 34, numberStyle, textStyle);
			writeRowData(sheet, dataList, rowCodesPart3, fieldSuffixes, 58, numberStyle, textStyle);
			
	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}
	
	
	private void writeRowData(Sheet sheet, List<CBUAE_BRF7_4_Summary_Entity> dataList, String[] rowCodes,
	        String[] fieldSuffixes, int baseRow, CellStyle numberStyle, CellStyle textStyle) {

	    for (CBUAE_BRF7_4_Summary_Entity record : dataList) {
	        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
	            String rowCode = rowCodes[rowIndex];

	            // ✅ Skip specific rows
	            if ("R0240".equals(rowCode) || "R0480".equals(rowCode)|| "R0020".equals(rowCode)|| "R0090".equals(rowCode)
	            		|| "R0160".equals(rowCode)|| "R0230".equals(rowCode)|| "R0250".equals(rowCode)|| "R0260".equals(rowCode)
	            		|| "R0330".equals(rowCode)|| "R0400".equals(rowCode)|| "R0470".equals(rowCode)|| "R0490".equals(rowCode)
	            		|| "R0560".equals(rowCode)|| "R0630".equals(rowCode)|| "R0640".equals(rowCode)) {
	                continue;
	            }

	            Row row = sheet.getRow(baseRow + rowIndex);
	            if (row == null) {
	                row = sheet.createRow(baseRow + rowIndex);
	            }

	            for (int colIndex = 0; colIndex < fieldSuffixes.length-1; colIndex++) {
	                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
	                System.out.println("fieldName:-" + fieldName);

	                Cell cell = row.createCell(3 + colIndex);
	                try {
	                    Field field = CBUAE_BRF7_4_Summary_Entity.class.getDeclaredField(fieldName);
	                    field.setAccessible(true);
	                    Object value = field.get(record);

	                    if (value instanceof BigDecimal) {
	                        cell.setCellValue(((BigDecimal) value).doubleValue());
	                        cell.setCellStyle(numberStyle);
	                    } else if (value != null) {
	                        cell.setCellValue(value.toString());
	                        cell.setCellStyle(textStyle);
	                    } else {
	                        cell.setCellValue("");
	                        cell.setCellStyle(textStyle);
	                    }
	                } catch (NoSuchFieldException | IllegalAccessException e) {
	                    cell.setCellValue("");
	                    cell.setCellStyle(textStyle);
	                    LoggerFactory.getLogger(getClass()).warn("Field not found or inaccessible: {}", fieldName);
	                }
	            }
	        }
	    }
	}
	
	
	
	public byte[] getBRF7_4ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		
		List<CBUAE_BRF7_4_Summary_Archival_Entity> dataList = CBUAE_BRF7_4_Summary_Archival_Repo.getdatabydateListarchival(dateformat.parse(todate), version);

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF7.4 report. Returning empty result.");
			return new byte[0];
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
//numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);

			String[] rowCodesPart1 = { "R0020","R0030", "R0040", "R0050", "R0060", "R0070", "R0080", "R0090",
					"R0100", "R0110", "R0120", "R0130", "R0140", "R0150", "R0160","R0170", "R0180", "R0190", 
					"R0200", "R0210", "R0220", "R0230"};
			String[] rowCodesPart2 = {
				    "R0250", "R0260", "R0270", "R0280", "R0290", "R0300", "R0310", "R0320", "R0330",
				    "R0340", "R0350", "R0360", "R0370", "R0380", "R0390", "R0400", "R0410", "R0420",
				    "R0430", "R0440", "R0450", "R0460", "R0470"
				};

			String[] rowCodesPart3 = {
				    "R0490", "R0500", "R0510", "R0520", "R0530", "R0540", "R0550", "R0560",
				    "R0570", "R0580", "R0590", "R0600", "R0610", "R0620", "R0630", "R0640"
				};


			String[] fieldSuffixes = {
				    "product",
				    "fedaral_govt",
				    "non_comm_entity_fed_govt",
				    "local_govt",
				    "non_comm_entity_emirates_govt",
				    "gre",
				    "private_sector_gre",
				    "private_sector_banks",
				    "private_sector_financial_institutions",
				    "private_sector_other_private_entities",
				    "total_amount"
				};


			writeRowDataARCHIVAL(sheet, dataList, rowCodesPart1, fieldSuffixes, 11, numberStyle, textStyle);
			writeRowDataARCHIVAL(sheet, dataList, rowCodesPart2, fieldSuffixes, 34, numberStyle, textStyle);
			writeRowDataARCHIVAL(sheet, dataList, rowCodesPart3, fieldSuffixes, 58, numberStyle, textStyle);
			
	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}
	
	
	
	private void writeRowDataARCHIVAL(Sheet sheet, List<CBUAE_BRF7_4_Summary_Archival_Entity> dataList, String[] rowCodes,
	        String[] fieldSuffixes, int baseRow, CellStyle numberStyle, CellStyle textStyle) {

	    for (CBUAE_BRF7_4_Summary_Archival_Entity record : dataList) {
	        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
	            String rowCode = rowCodes[rowIndex];

	            // ✅ Skip specific rows
	            if ("R0240".equals(rowCode) || "R0480".equals(rowCode)|| "R0020".equals(rowCode)|| "R0090".equals(rowCode)
	            		|| "R0160".equals(rowCode)|| "R0230".equals(rowCode)|| "R0250".equals(rowCode)|| "R0260".equals(rowCode)
	            		|| "R0330".equals(rowCode)|| "R0400".equals(rowCode)|| "R0470".equals(rowCode)|| "R0490".equals(rowCode)
	            		|| "R0560".equals(rowCode)|| "R0630".equals(rowCode)|| "R0640".equals(rowCode)) {
	                continue;
	            }

	            Row row = sheet.getRow(baseRow + rowIndex);
	            if (row == null) {
	                row = sheet.createRow(baseRow + rowIndex);
	            }

	            for (int colIndex = 0; colIndex < fieldSuffixes.length-1; colIndex++) {
	                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
	                System.out.println("fieldName:-" + fieldName);

	                Cell cell = row.createCell(3 + colIndex);
	                try {
	                    Field field = CBUAE_BRF7_4_Summary_Archival_Entity.class.getDeclaredField(fieldName);
	                    field.setAccessible(true);
	                    Object value = field.get(record);

	                    if (value instanceof BigDecimal) {
	                        cell.setCellValue(((BigDecimal) value).doubleValue());
	                        cell.setCellStyle(numberStyle);
	                    } else if (value != null) {
	                        cell.setCellValue(value.toString());
	                        cell.setCellStyle(textStyle);
	                    } else {
	                        cell.setCellValue("");
	                        cell.setCellStyle(textStyle);
	                    }
	                } catch (NoSuchFieldException | IllegalAccessException e) {
	                    cell.setCellValue("");
	                    cell.setCellStyle(textStyle);
	                    LoggerFactory.getLogger(getClass()).warn("Field not found or inaccessible: {}", fieldName);
	                }
	            }
	        }
	    }
	}
	
	
	

	


	// DetailExcel
	public byte[] getBRF7_4DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF7_4DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}	
		
		try {
			logger.info("Generating Excel for BRF7_4 Details...");
			System.out.println("came to Detail download service");
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF7_4Details");

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
			List<CBUAE_BRF7_4_Detail_Entity> reportData = CBUAE_BRF7_4_Detail_Repos.getdatabydateList(parsedToDate);
System.out.println("The size is"+reportData.size());
			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF7_4_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF7_4 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF7_4 Excel", e);
			return new byte[0];
		}
	}
	
	
	public byte[] getBRF7_4DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		try {
			logger.info("Generating Excel for BRF7_4 Details...");
			System.out.println("came to Detail download service");
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF7_4Details");

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
			List<CBUAE_BRF7_4_Detail_Archival_Entity> reportData = CBUAE_BRF7_4_Detail_Archival_Repo.getdatabydateList(parsedToDate, version);
			
			System.out.println("The size is"+reportData.size());
			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF7_4_Detail_Archival_Entity item : reportData) {
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
				logger.info("No data found for BRF7_4 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF7_4 Excel", e);
			return new byte[0];
		}
	}

	
	public List<Object> getBRF7_4Archival() {
		List<Object> BRF7_4Archivallist = new ArrayList<>();
		try {
			BRF7_4Archivallist = CBUAE_BRF7_4_Summary_Archival_Repo.getbrfarchival();
			System.out.println(BRF7_4Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF5_17 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF7_4Archivallist;
	}


}
