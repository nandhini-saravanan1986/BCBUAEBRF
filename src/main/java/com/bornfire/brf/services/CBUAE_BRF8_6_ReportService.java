
package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.bornfire.brf.entities.CBUAE_BRF8_6_Detail_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Detail_Archival_Repo;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Summary_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Summary_Archival_Repo;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF8_6_Summary_Repo;


@Component
@Service
public class CBUAE_BRF8_6_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF8_6_ReportService.class);
	

	@Autowired 
	AuditService auditService;
	@Autowired
	private Environment env;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF8_6_Summary_Repo CBUAE_BRF8_6_Summary_Repos;
	@Autowired
	CBUAE_BRF8_6_Summary_Archival_Repo BRF8_6_Summary_Archival_Repo;
	@Autowired
	CBUAE_BRF8_6_Detail_Repo CBUAE_BRF8_6_Detail_Repos;
	/*
	 * @Autowired(required=true) CBUAE_BRF8_6_Detail_Archival_Repo
	 * CBUAE_BRF8_6_Detail_Archival_Repo;
	 */
	
	@Autowired
    private CBUAE_BRF8_6_Detail_Archival_Repo archivalRepo;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF8_6View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF8_6View...");
		ModelAndView mv = new ModelAndView();
		
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF8_6_Summary_Archival_Entity> T1Master = new ArrayList<CBUAE_BRF8_6_Summary_Archival_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF8_6_Summary_Archival_Repo.getdatabydateListarchival(dateformat.parse(todate), version);
				 System.out.println("LISTCOUNT: " + T1Master.size());
				 
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
			System.out.println("BRF8_6 rows: " + T1Master.size());

		}
		
		
		
		else {
			List<CBUAE_BRF8_6_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF8_6_Summary_Entity>();

			 T1Master=CBUAE_BRF8_6_Summary_Repos.getdatabydateList();

			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF8_6");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		mv.addObject("reportid", "BRF8_6");
		logger.info("scv" + mv.getViewName());

		return mv;

	}
	
	public List<Object> getBRF8_6Archival() {
		List<Object> BRF8_6Archivallist = new ArrayList<>();
		try {
			BRF8_6Archivallist = BRF8_6_Summary_Archival_Repo.getBRF8_6archival();
			System.out.println("countser" + BRF8_6Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF8_6 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF8_6Archivallist;
	}
	
	/*
	 * public ModelAndView getBRF8_6currentDtl( String reportId, String fromdate,
	 * String todate, String currency, String dtltype, Pageable pageable, String
	 * filter) {
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView(); List<CBUAE_BRF8_6_Detail_Entity> T1Dt1
	 * = new ArrayList<>();
	 * 
	 * try { Date d1 = dateformat.parse(todate);
	 * 
	 * String rowId = null; String columnId = null;
	 * 
	 * // ✅ Split the filter string here if (filter != null && filter.contains(","))
	 * { String[] parts = filter.split(","); if (parts.length >= 2) { rowId =
	 * parts[0]; columnId = parts[1]; } }
	 * 
	 * if (rowId != null && columnId != null) { logger.info("enter if block"); T1Dt1
	 * = CBUAE_BRF8_6_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId); }
	 * else { logger.info("enter else block"); T1Dt1 =
	 * CBUAE_BRF8_6_Detail_Repos.getdatabydateList(d1); }
	 * 
	 * System.out.println("LISTCOUNT: " + T1Dt1.size());
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); }
	 * 
	 * mv.setViewName("BRF/BRF8_6"); mv.addObject("displaymode", "Details");
	 * mv.addObject("reportdetails", T1Dt1); mv.addObject("reportmaster12", T1Dt1);
	 * mv.addObject("reportsflag", "reportsflag"); mv.addObject("menu", reportId);
	 * return mv; }
	 */
	
	public ModelAndView getBRF8_6currentDtl(String reportId, String fromdate, String todate, String currency,
            String dtltype, Pageable pageable, String filter, String type, String version) {

int pageSize = (pageable != null) ? pageable.getPageSize() : 100;   // ✅ avoid NPE
int currentPage = (pageable != null) ? pageable.getPageNumber() : 0;
int totalPages = 0;

ModelAndView mv = new ModelAndView();
Session hs = sessionFactory.getCurrentSession();

try {
Date parsedDate = dateformat.parse(todate);

String rowId = null;
String columnId = null;

// ✅ Extract rowId and columnId from filter
if (filter != null && filter.contains(",")) {
String[] parts = filter.split(",");
if (parts.length >= 2) {
rowId = parts[0];
columnId = parts[1];
}
}

// ✅ ARCHIVAL block
if ("ARCHIVAL".equalsIgnoreCase(type) && version != null) {
List<CBUAE_BRF8_6_Detail_Archival_Entity> T1Dt1;

if (rowId != null && columnId != null) {
T1Dt1 = archivalRepo.GetDataByRowIdAndColumnId(rowId, columnId, parsedDate, version);
} else {
T1Dt1 = archivalRepo.getdatabydateList(parsedDate, version);
}

mv.addObject("reportdetails", T1Dt1);
System.out.println("ARCHIVAL COUNT: " + (T1Dt1 != null ? T1Dt1.size() : 0));

} else {
// ✅ NON-ARCHIVAL block
List<CBUAE_BRF8_6_Detail_Entity> T1Dt1;

if (rowId != null && columnId != null) {
T1Dt1 = CBUAE_BRF8_6_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId, parsedDate);
} else {
T1Dt1 = CBUAE_BRF8_6_Detail_Repos.getdatabydateList(parsedDate, currentPage, pageSize);
totalPages = CBUAE_BRF8_6_Detail_Repos.getdatacount(parsedDate);
mv.addObject("pagination", "YES");
}

mv.addObject("reportdetails", T1Dt1);
System.out.println("DETAIL COUNT: " + (T1Dt1 != null ? T1Dt1.size() : 0));
}

} catch (ParseException e) {
e.printStackTrace();
}

// ✅ Common attributes
mv.setViewName("BRF/BRF8_6");
mv.addObject("displaymode", "Details");
mv.addObject("currentPage", currentPage);
mv.addObject("totalPages", (int) Math.ceil((double) totalPages / 100));
mv.addObject("reportsflag", "reportsflag");
mv.addObject("menu", reportId);

return mv;
}

	public byte[] getBRF8_6Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype,
			String type,String version) throws Exception {

	    try {
	        List<CBUAE_BRF8_6_Summary_Entity> dataList = CBUAE_BRF8_6_Summary_Repos.getdatabydateList();

	        if (dataList.isEmpty()) {
	            logger.warn("No data found for BRF8.6 report.");
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
			try (InputStream templateInputStream = Files.newInputStream(templatePath);
					Workbook workbook = WorkbookFactory.create(templateInputStream);
					ByteArrayOutputStream out = new ByteArrayOutputStream()) {

	            Sheet sheet = workbook.getSheetAt(0);
	            CreationHelper createHelper = workbook.getCreationHelper();

	            CellStyle dateStyle = workbook.createCellStyle();
	            dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	            CellStyle centerStyle = workbook.createCellStyle();
	            centerStyle.setAlignment(HorizontalAlignment.CENTER);

	            CellStyle leftStyle = workbook.createCellStyle();
	            leftStyle.setAlignment(HorizontalAlignment.LEFT);


	            int startCol = 3;     // Column D (0-based)
	            int startRow = 8;     // 9th row (0-based)
	            int notesRow = 15;    // "Notes:-" is at 16th row (Excel)

	            // Step 1: Shift "Notes:-" and below to make space for data rows
	            if (sheet.getLastRowNum() >= notesRow) {
	                sheet.shiftRows(notesRow, sheet.getLastRowNum(), dataList.size());
	            }

	            // Step 2: Write data rows before the "Notes:-"
	            for (int i = 0; i < dataList.size(); i++) {
	            	CBUAE_BRF8_6_Summary_Entity record = dataList.get(i);
	                Row row = sheet.getRow(startRow + i);
	                if (row == null) row = sheet.createRow(startRow + i);

	                int col = startCol;

	                // Column B - Serial Number (starts from 0010)
	                Cell serialCell = row.createCell(1);
	                serialCell.setCellValue(String.format("%04d", (i + 1) * 10));
	                serialCell.setCellStyle(centerStyle);

	                // Column C - ID
	                row.createCell(2).setCellValue(record.getId());

	                // Column D onwards
	                Cell lfi_type = row.createCell(col++);
	                lfi_type.setCellValue(record.getR0010_outsourced_activity_domain());
	                lfi_type.setCellStyle(leftStyle);

	                row.createCell(col++).setCellValue(record.getR0020_description_of_outsourced_activity());
	                row.createCell(col++).setCellValue(record.getR0030_name_of_institution());
	                row.createCell(col++).setCellValue(record.getR0040_department_responsible());
	                row.createCell(col++).setCellValue(record.getR0050_outsourcing_activity_core_noncore());
	                row.createCell(col++).setCellValue(record.getR0060_cbuae_no_objection_reference());
	                row.createCell(col++).setCellValue(record.getR0070_total_number_of_outsourced_jobs());
	                row.createCell(col++).setCellValue(record.getR0080_number_of_critical_outsourced_jobs());
	                row.createCell(col++).setCellValue(record.getR0090_data_access_by_third_parties());
	                row.createCell(col++).setCellValue(record.getR0100_nature_of_data_involved());
	                row.createCell(col++).setCellValue(record.getR0110_is_service_provider_owned_by_bank());
	                row.createCell(col++).setCellValue(record.getR0120_name_of_vendor());
	                row.createCell(col++).setCellValue(record.getR0130_country_of_registration());
	                row.createCell(col++).setCellValue(record.getR0140_vendor_lei_or_reg_number());
	                row.createCell(col++).setCellValue(record.getR0150_holding_parent_company());
	                row.createCell(col++).setCellValue(record.getR0160_countries_service_performed());
	                row.createCell(col++).setCellValue(record.getR0170_countries_data_stored());
	                row.createCell(col++).setCellValue(record.getR0180_governing_law());

	                Cell dob = row.createCell(col++);
	                if (record.getR0190_annual_contract_value_aed() != null) {
	                    dob.setCellValue(record.getR0190_annual_contract_value_aed().doubleValue());
	                    dob.setCellStyle(dateStyle);
	                }

	                Cell created = row.createCell(col++);
	                if (record.getR0200_total_contract_value_aed() != null) {
	                    created.setCellValue(record.getR0200_total_contract_value_aed().doubleValue());
	                    created.setCellStyle(dateStyle);
	                }
	                Cell date1 = row.createCell(col++);
	                if (record.getR0210_service_commencement_date() != null) {
	                	date1.setCellValue(record.getR0210_service_commencement_date());
	                	date1.setCellStyle(dateStyle);
	                } 
	                Cell date2 = row.createCell(col++);
	                if (record.getR0220_service_expiry_date() != null) {
	                	date2.setCellValue(record.getR0220_service_expiry_date());
	                	date2.setCellStyle(dateStyle);
	                }
	                row.createCell(col++).setCellValue(record.getR0230_outcome_of_risk_assessment());
	                row.createCell(col++).setCellValue(record.getR0240_substitutability());
	                row.createCell(col++).setCellValue(record.getR0250_time_critical_operation());
	                Cell date3 = row.createCell(col++);
	                if (record.getR0260_last_audit_date() != null) {
	                	date3.setCellValue(record.getR0260_last_audit_date());
	                	date3.setCellStyle(dateStyle);
	                }
	                row.createCell(col++).setCellValue(record.getR0270_comments());

	            }


	            workbook.write(out);
	            return out.toByteArray();
	        }

	    } catch (Exception e) {
	        logger.error("Error generating BRF8.6 Excel file", e);
	        throw e;
	    }
	}
	public byte[] getBRF8_6ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Archival Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		List<CBUAE_BRF8_6_Summary_Archival_Entity> dataList = BRF8_6_Summary_Archival_Repo
				.getdatabydateListarchival(dateformat.parse(todate), version);
		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF8.6 report. Returning empty result.");
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

			int startRow = 9;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF8_6_Summary_Archival_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					// row10
					// Column E
					
					/*
					 * Cell cell4 = row.createCell(4); if
					 * (record.getR0020_nonresi_aed_up_to_3_months() != null) {
					 * cell4.setCellValue(record.getR0020_nonresi_aed_up_to_3_months().doubleValue()
					 * ); cell4.setCellStyle(numberStyle); } else { cell4.setCellValue("");
					 * cell4.setCellStyle(textStyle); } Cell cell5 = row.createCell(4); if
					 * (record.getR0020_nonresi_aed_above_3_and_up_to_6_months() != null) {
					 * cell5.setCellValue(record.getR0020_nonresi_aed_above_3_and_up_to_6_months().
					 * doubleValue()); cell5.setCellStyle(numberStyle); } else {
					 * cell5.setCellValue(""); cell5.setCellStyle(textStyle); }
					 */
					
					// row11
					//row = sheet.getRow(10);

					// Column E
					/*
					 * cell4 = row.createCell(4); if (record.getR0030_year_to_date() != null) {
					 * cell4.setCellValue(record.getR0030_year_to_date().doubleValue());
					 * cell4.setCellStyle(numberStyle); } else { cell4.setCellValue("");
					 * cell4.setCellStyle(textStyle); }
					 */

					// row12
					//row = sheet.getRow(11);

					// Column E
					/*
					 * cell4 = row.createCell(4); if (record.getR0040_year_to_date() != null) {
					 * cell4.setCellValue(record.getR0040_year_to_date().doubleValue());
					 * cell4.setCellStyle(numberStyle); } else { cell4.setCellValue("");
					 * cell4.setCellStyle(textStyle); }
					 */
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
	
	public byte[] getBRF8_6DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
	    try {
	        logger.info("Generating Excel for BRF8_6 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF8_6Details");

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
	        String[] headers = {
	            "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID", "COLUMNID", "REPORT_DATE"
	        };

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
	        List<CBUAE_BRF8_6_Detail_Entity> reportData = CBUAE_BRF8_6_Detail_Repos.getListbydate(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF8_6_Detail_Entity item : reportData) {
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
	                row.createCell(6).setCellValue(
	                    item.getReportDate() != null ?
	                    new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate()) : ""
	                );

	                // Apply data style for all other cells
	                for (int j = 0; j < 7; j++) {
	                    if (j != 3) {
	                        row.getCell(j).setCellStyle(dataStyle);
	                    }
	                }
	            }
	        } else {
	            logger.info("No data found for BRF18_6 — only header will be written.");
	        }

	        // Write to byte[]
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        workbook.write(bos);
	        workbook.close();

	        logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
	        
	        //audit
	        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        if (attrs != null) {
	            HttpServletRequest request = attrs.getRequest();
	            String userid = (String) request.getSession().getAttribute("USERID");
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF8_6_DETAIL", null, "CBUAE_BRF8_6_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF8_6 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}





}
