
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
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF5_19_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity3;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity4;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity5;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity6;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Entity7;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep1;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep2;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep3;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep4;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep5;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep6;
import com.bornfire.brf.entities.CBUAE_BRF5_19_Summary_Rep7;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_4_Summary_Entity;


@Component
@Service
public class CBUAE_BRF5_19_ReportService {

	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF7_4_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF5_19_Detail_Repo CBUAE_BRF5_19_Detail_Repos;

	@Autowired
	CBUAE_BRF5_19_Summary_Rep1 CBUAE_BRF5_19_Summary_Reps1;
	@Autowired
	CBUAE_BRF5_19_Summary_Rep2 CBUAE_BRF5_19_Summary_Reps2;
	@Autowired
	CBUAE_BRF5_19_Summary_Rep3 CBUAE_BRF5_19_Summary_Reps3;
	@Autowired
	CBUAE_BRF5_19_Summary_Rep4 CBUAE_BRF5_19_Summary_Reps4;
	@Autowired
	CBUAE_BRF5_19_Summary_Rep5 CBUAE_BRF5_19_Summary_Reps5;
	@Autowired
	CBUAE_BRF5_19_Summary_Rep6 CBUAE_BRF5_19_Summary_Reps6;
	@Autowired
	CBUAE_BRF5_19_Summary_Rep7 CBUAE_BRF5_19_Summary_Reps7;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF5_19View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {
		System.out.println("getBRF5_19View");
		ModelAndView mv = new ModelAndView();
			List<CBUAE_BRF5_19_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity1>();
			List<CBUAE_BRF5_19_Summary_Entity2> T2Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity2>();
			List<CBUAE_BRF5_19_Summary_Entity3> T3Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity3>();
			List<CBUAE_BRF5_19_Summary_Entity4> T4Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity4>();
			List<CBUAE_BRF5_19_Summary_Entity5> T5Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity5>();
			List<CBUAE_BRF5_19_Summary_Entity6> T6Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity6>();
			List<CBUAE_BRF5_19_Summary_Entity7> T7Master = new ArrayList<CBUAE_BRF5_19_Summary_Entity7>();

			try {
				T1Master = CBUAE_BRF5_19_Summary_Reps1.getdatabydateList(dateformat.parse(todate));
				T2Master = CBUAE_BRF5_19_Summary_Reps2.getdatabydateList(dateformat.parse(todate));
				T3Master = CBUAE_BRF5_19_Summary_Reps3.getdatabydateList(dateformat.parse(todate));
				T4Master = CBUAE_BRF5_19_Summary_Reps4.getdatabydateList(dateformat.parse(todate));
				T5Master = CBUAE_BRF5_19_Summary_Reps5.getdatabydateList(dateformat.parse(todate));
				T6Master = CBUAE_BRF5_19_Summary_Reps6.getdatabydateList(dateformat.parse(todate));
				T7Master = CBUAE_BRF5_19_Summary_Reps7.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}

		mv.addObject("reportsummary1", T1Master);
		mv.addObject("reportsummary2", T2Master);
		mv.addObject("reportsummary3", T3Master);
		mv.addObject("reportsummary4", T4Master);
		mv.addObject("reportsummary5", T5Master);
		mv.addObject("reportsummary6", T6Master);
		mv.addObject("reportsummary7", T7Master);
		mv.setViewName("BRF/BRF5_19");
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF5_19currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {
		ModelAndView mv = new ModelAndView();

			List<CBUAE_BRF5_19_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF5_19_Detail_Entity>();
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
					T1Dt1 = CBUAE_BRF5_19_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
			} else {
					T1Dt1 = CBUAE_BRF5_19_Detail_Repos.getdatabydateList(dateformat.parse(todate));
			}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);
				System.out.println("LISTCOUNT" + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}

		mv.setViewName("BRF/BRF5_19");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
	
	public byte[] getBRF5_19Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory."+filename);

		List<CBUAE_BRF5_19_Summary_Entity1> dataList1 = CBUAE_BRF5_19_Summary_Reps1.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_19_Summary_Entity2> dataList2= CBUAE_BRF5_19_Summary_Reps2.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_19_Summary_Entity3> dataList3= CBUAE_BRF5_19_Summary_Reps3.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_19_Summary_Entity4> dataList4= CBUAE_BRF5_19_Summary_Reps4.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_19_Summary_Entity5> dataList5= CBUAE_BRF5_19_Summary_Reps5.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_19_Summary_Entity6> dataList6= CBUAE_BRF5_19_Summary_Reps6.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_19_Summary_Entity7> dataList7= CBUAE_BRF5_19_Summary_Reps7.getdatabydateList(dateformat.parse(todate));

		if (dataList1.isEmpty() || dataList2.isEmpty() || dataList3.isEmpty() || dataList4.isEmpty() || dataList5.isEmpty() || dataList6.isEmpty() || dataList7.isEmpty()) {
			logger.warn("Service: No data found for BRF5.19 report. Returning empty result.");
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
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);

			String[] rowCodesPart = {
				    "R0030", "R0040", "R0050", "R0060", "R0070", "R0080", "R0090",
				    "R0100", "R0110", "R0120", "R0130", "R0140", "R0150", "R0160", "R0170", "R0180", "R0190",
				    "R0200", "R0210", "R0220", "R0230", "R0240", "R0250", "R0260", "R0270", "R0280", "R0290",
				    "R0300", "R0310", "R0320", "R0330", "R0340", "R0350", "R0360", "R0370", "R0380", "R0390",
				    "R0400", "R0410", "R0420", "R0430", "R0440", "R0450", "R0460", "R0470", "R0480", "R0490",
				    "R0500", "R0510", "R0520", "R0530", "R0540", "R0550", "R0560", "R0570", "R0580", "R0590",
				    "R0600", "R0610", "R0620", "R0630", "R0640", "R0650", "R0660", "R0670", "R0680", "R0690",
				    "R0700", "R0710", "R0720", "R0730", "R0740", "R0750", "R0760", "R0770", "R0780", "R0790",
				    "R0800", "R0810", "R0820", "R0830", "R0840", "R0850", "R0860", "R0870", "R0880", "R0890",
				    "R0900", "R0910", "R0920", "R0930", "R0940", "R0950", "R0960", "R0970", "R0980", "R0990",
				    "R1000", "R1010", "R1020", "R1030", "R1040", "R1050", "R1060", "R1070", "R1080", "R1090",
				    "R1100", "R1110", "R1120", "R1130", "R1140", "R1150", "R1160", "R1170", "R1180", "R1190",
				    "R1200", "R1210", "R1220", "R1230", "R1240", "R1250", "R1260", "R1270", "R1280", "R1290",
				    "R1300", "R1310", "R1320", "R1330", "R1340", "R1350", "R1360", "R1370", "R1380", "R1390",
				    "R1400", "R1410", "R1420", "R1430", "R1440", "R1450", "R1460", "R1470", "R1480", "R1490",
				    "R1500", "R1510", "R1520", "R1530", "R1540", "R1550", "R1560", "R1570", "R1580", "R1590",
				    "R1600", "R1610", "R1620", "R1630", "R1640", "R1650", "R1660", "R1670", "R1680", "R1690",
				    "R1700", "R1710", "R1720", "R1730", "R1740", "R1750", "R1760", "R1770", "R1780", "R1790",
				    "R1800", "R1810", "R1820", "R1830", "R1840", "R1850", "R1860", "R1870", "R1880", "R1890",
				    "R1900", "R1910", "R1920", "R1930", "R1940", "R1950", "R1960", "R1970", "R1980", "R1990",
				    "R2000", "R2010", "R2020", "R2030", "R2040", "R2050", "R2060", "R2070", "R2080", "R2090",
				    "R2100", "R2110", "R2120", "R2130", "R2140", "R2150", "R2160", "R2170", "R2180", "R2190",
				    "R2200", "R2210", "R2220", "R2230", "R2240", "R2250", "R2260", "R2270", "R2280", "R2290",
				    "R2300", "R2310", "R2320", "R2330", "R2340", "R2350", "R2360", "R2370", "R2380", "R2390",
				    "R2400", "R2410", "R2420", "R2430", "R2440", "R2450", "R2460", "R2470", "R2480", "R2490",
				    "R2500", "R2510", "R2520", "R2530", "R2540", "R2550", "R2560", "R2570", "R2580", "R2590",
				    "R2600", "R2610", "R2620", "R2630", "R2640", "R2650", "R2660", "R2670", "R2680", "R2690",
				    "R2700", "R2710", "R2720", "R2730", "R2740", "R2750", "R2760", "R2770", "R2780", "R2790",
				    "R2800", "R2810", "R2820", "R2830", "R2840", "R2850", "R2860", "R2870", "R2880", "R2890",
				    "R2900", "R2910", "R2920", "R2930", "R2940", "R2950", "R2960", "R2970", "R2980", "R2990",
				    "R3000", "R3010", "R3020", "R3030", "R3040"
				};

			

			String[] fieldSuffixes = {
				    "product",
				    "less_thirty_no_of_borrowers",
				    "less_thirty_outstanding_loan_amount",
				    "less_thirty_no_of_borrowers_classified_under_stage_3",
				    "less_thirty_loans_classified_under_stage_3",
				    "thirty_fortyfive_no_of_borrowers",
				    "thirty_fortyfive_outstanding_loan_amount",
				    "thirty_fortyfive_no_of_borrowers_classified_under_stage_3",
				    "thirty_fortyfive_loans_classified_under_stage_3",
				    "fortyfive_sixty_no_of_borrowers",
				    "fortyfive_sixty_outstanding_loan_amount",
				    "fortyfive_sixty_no_of_borrowers_classified_under_stage_3",
				    "fortyfive_sixty_loans_classified_under_stage_3",
				    "above_sixty_no_of_borrowers",
				    "above_sixty_outstanding_loan_amount",
				    "above_sixty_no_of_borrowers_classified_under_stage_3",
				    "above_sixty_loans_classified_under_stage_3",
				    "out_of_this_no_of_borrowers",
				    "out_of_this_outstanding_loan_amount",
				    "out_of_this_no_of_borrowers_classified_under_stage_3",
				    "out_of_this_loans_classified_under_stage_3"
				};


			writeRowData(sheet, dataList1, rowCodesPart, fieldSuffixes, 10, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity1.class);
			writeRowData(sheet, dataList2, rowCodesPart, fieldSuffixes, 55, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity2.class);
			writeRowData(sheet, dataList3, rowCodesPart, fieldSuffixes, 100, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity3.class);
			writeRowData(sheet, dataList4, rowCodesPart, fieldSuffixes, 145, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity4.class);
			writeRowData(sheet, dataList5, rowCodesPart, fieldSuffixes, 190, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity5.class);
			writeRowData(sheet, dataList6, rowCodesPart, fieldSuffixes, 235, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity6.class);
			writeRowData(sheet, dataList7, rowCodesPart, fieldSuffixes, 280, numberStyle, textStyle, CBUAE_BRF5_19_Summary_Entity7.class);
			
	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}

	private <T> void writeRowData(
	        Sheet sheet,
	        List<T> dataList,
	        String[] rowCodes,
	        String[] fieldSuffixes,
	        int baseRow,
	        CellStyle numberStyle,
	        CellStyle textStyle,
	        Class<T> entityClass) {

	    for (T record : dataList) {
	        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
	            String rowCode = rowCodes[rowIndex];

	            // ✅ Skip specific rows
	            if ("R0080".equals(rowCode) || "R0140".equals(rowCode) || "R0200".equals(rowCode) ||
	                "R0260".equals(rowCode) || "R0320".equals(rowCode) || "R0380".equals(rowCode) ||
	                "R0390".equals(rowCode) || "R0400".equals(rowCode) || "R0460".equals(rowCode) ||
	                "R0520".equals(rowCode) || "R0580".equals(rowCode) ||
	                "R0640".equals(rowCode) || "R0700".equals(rowCode) || "R0760".equals(rowCode) ||
	                "R0770".equals(rowCode) || "R0780".equals(rowCode) || "R0840".equals(rowCode) ||
	                "R0900".equals(rowCode) || "R0960".equals(rowCode) || "R1020".equals(rowCode) ||
	                "R1080".equals(rowCode) || "R1140".equals(rowCode) || "R1150".equals(rowCode) ||
	                "R1160".equals(rowCode) || "R1220".equals(rowCode) || "R1280".equals(rowCode) ||
	                "R1340".equals(rowCode) || "R1400".equals(rowCode) || "R1460".equals(rowCode) ||
	                "R1520".equals(rowCode) || "R1530".equals(rowCode) || "R1540".equals(rowCode) ||
	                "R1600".equals(rowCode) || "R1660".equals(rowCode) || "R1720".equals(rowCode) ||
	                "R1780".equals(rowCode) || "R1840".equals(rowCode) || "R1900".equals(rowCode) ||
	                "R1910".equals(rowCode) || "R1920".equals(rowCode) || "R1980".equals(rowCode) ||
	                "R2040".equals(rowCode) || "R2100".equals(rowCode) || "R2160".equals(rowCode) ||
	                "R2220".equals(rowCode) || "R2280".equals(rowCode) || "R2290".equals(rowCode) ||
	                "R2300".equals(rowCode) || "R2360".equals(rowCode) || "R2420".equals(rowCode) ||
	                "R2480".equals(rowCode) || "R2540".equals(rowCode) || "R2600".equals(rowCode) ||
	                "R2660".equals(rowCode) || "R2670".equals(rowCode) || "R2680".equals(rowCode) ||
	                "R2740".equals(rowCode) || "R2800".equals(rowCode) || "R2860".equals(rowCode) ||
	                "R2920".equals(rowCode) || "R2980".equals(rowCode) || "R3040".equals(rowCode)) {
	                continue;
	            }

	            Row row = sheet.getRow(baseRow + rowIndex);
	            if (row == null) {
	                row = sheet.createRow(baseRow + rowIndex);
	            }

	            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
	                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
	                System.out.println("fieldName:- " + fieldName);

	                Cell cell = row.createCell(3 + colIndex);
	                try {
	                    Field field = entityClass.getDeclaredField(fieldName);
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
	                    LoggerFactory.getLogger(getClass())
	                        .warn("Field not found or inaccessible: {}", fieldName);
	                }
	            }
	        }
	    }
	}



	// DetailExcel
	public byte[] getBRF5_19DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		try {
			logger.info("Generating Excel for BRF5_19 Details...");
			System.out.println("came to Detail download service");
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF5_19Details");

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
			List<CBUAE_BRF5_19_Detail_Entity> reportData = CBUAE_BRF5_19_Detail_Repos.getdatabydateList(parsedToDate);
System.out.println("The size is"+reportData.size());
			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF5_19_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF5_19 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF5_19 Excel", e);
			return new byte[0];
		}
	}

}
