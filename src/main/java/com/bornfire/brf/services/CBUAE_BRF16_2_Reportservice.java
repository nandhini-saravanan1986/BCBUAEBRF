
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
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF16_2_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF16_2_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF16_2_SUMMARY_REPO;
import com.bornfire.brf.entities.CBUAE_BRF16_2_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_2_Detail_Entity;



@Component
@Service
public class CBUAE_BRF16_2_Reportservice {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF16_2_Reportservice.class);
	

	@Autowired 
	AuditService auditService;
	@Autowired
	private Environment env;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF16_2_SUMMARY_REPO CBUAE_BRF16_2_Summary_Repos;
	@Autowired
	CBUAE_BRF16_2_Detail_Repo CBUAE_BRF16_2_Detail_Repos;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF_16_2View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF_16_2View...");
		ModelAndView mv = new ModelAndView();
		if(type.equals("ARCHIVAL")&version!=null) {

			logger.info("Enter if statement");
			List<CBUAE_BRF16_2_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF16_2_Summary_Entity>();
		
				 T1Master=CBUAE_BRF16_2_Summary_Repos.getdatabydateList();
			
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF16_2_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF16_2_Summary_Entity>();

			 T1Master=CBUAE_BRF16_2_Summary_Repos.getdatabydateList();

			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF16_2");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		mv.addObject("reportid", "BRF16_2");
		logger.info("scv" + mv.getViewName());

		return mv;

	}
	/*
	 * public ModelAndView getBRF16_2currentDtl( String reportId, String fromdate,
	 * String todate, String currency, String dtltype, Pageable pageable, String
	 * filter) {
	 * 
	 * int pageSize = pageable.getPageSize(); int currentPage =
	 * pageable.getPageNumber();
	 * 
	 * ModelAndView mv = new ModelAndView(); List<CBUAE_BRF16_2_Detail_Entity> T1Dt1
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
	 * = CBUAE_BRF16_2_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId); }
	 * else { logger.info("enter else block"); T1Dt1 =
	 * CBUAE_BRF16_2_Detail_Repos.getdatabydateList(d1); }
	 * 
	 * System.out.println("LISTCOUNT: " + T1Dt1.size());
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); }
	 * 
	 * mv.setViewName("BRF/BRF16_2"); mv.addObject("displaymode", "Details");
	 * mv.addObject("reportdetails", T1Dt1); mv.addObject("reportmaster12", T1Dt1);
	 * mv.addObject("reportsflag", "reportsflag"); mv.addObject("menu", reportId);
	 * return mv; }
	 */
	public ModelAndView getBRF16_2currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF16_2_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	        	T1Dt1 = CBUAE_BRF16_2_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
	        } else {
	            T1Dt1 = CBUAE_BRF16_2_Detail_Repos.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF16_2");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}





	public byte[] getBRF16_2Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
	    try {
	        List<CBUAE_BRF16_2_Summary_Entity> dataList = CBUAE_BRF16_2_Summary_Repos.getdatabydateList();

	        if (dataList.isEmpty()) {
	            logger.warn("No data found for BRF16.5 report.");
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
	            
	            CellStyle textStyle = workbook.createCellStyle();
    			textStyle.setBorderBottom(BorderStyle.THIN);
    			textStyle.setBorderTop(BorderStyle.THIN);
    			textStyle.setBorderLeft(BorderStyle.THIN);
    			textStyle.setBorderRight(BorderStyle.THIN);

    			CellStyle numberStyle = workbook.createCellStyle();
    			numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
    			numberStyle.setBorderBottom(BorderStyle.THIN);
    			numberStyle.setBorderTop(BorderStyle.THIN);
    			numberStyle.setBorderLeft(BorderStyle.THIN);
    			numberStyle.setBorderRight(BorderStyle.THIN);


	            int startCol = 7;     // Column D (0-based)
	            int startRow = 9;     // 9th row (0-based)
				/* int notesRow = 11; */  // "Notes:-" is at 12th row (Excel)

	            // Step 1: Shift "Notes:-" and below to make space for data rows
				/*
				 * if (sheet.getLastRowNum() >= notesRow) { sheet.shiftRows(notesRow,
				 * sheet.getLastRowNum(), dataList.size()); }
				 */

	            // Step 2: Write data rows before the "Notes:-"
	            for (int i = 0; i < dataList.size(); i++) {
	                CBUAE_BRF16_2_Summary_Entity record = dataList.get(i);
	                Row row = sheet.getRow(startRow + i);
	                if (row == null) row = sheet.createRow(startRow + i);


					/* int col = 7; */ // starting column index

	             // Column B - Serial Number (now at col 8)
					/*
					 * Cell serialCell = row.createCell(col++);
					 * serialCell.setCellValue(String.format("%04d", (i + 1) * 10));
					 * serialCell.setCellStyle(centerStyle);
					 * 
					 * // Column: R0010 Product Cell cell0 = row.createCell(col++);
					 * cell0.setCellValue(record.getR0010_product() != null ?
					 * record.getR0010_product() : ""); cell0.setCellStyle(textStyle);
					 */

	             


	          // ====== R0020 row - next row ======
	             Row rowR0020 = sheet.getRow(startRow + i + 1);
	             if (rowR0020 == null) rowR0020 = sheet.createRow(startRow + i + 1);

	             int colR0020 = 7; // starting from same column index as R0010

	             // Column: No. of Consumer-Facing Employees
	             Cell r0020Cell1 = rowR0020.createCell(colR0020++);
	             r0020Cell1.setCellValue(record.getR0020_no_consumerfacing_employees() != null
	                     ? record.getR0020_no_consumerfacing_employees().doubleValue() : 0.0);
	             r0020Cell1.setCellStyle(numberStyle);

	             // Column: No. of Resigned Employees
	             Cell r0020Cell2 = rowR0020.createCell(colR0020++);
	             r0020Cell2.setCellValue(record.getR0020_no_resigned_employees() != null
	                     ? record.getR0020_no_resigned_employees().doubleValue() : 0.0);
	             r0020Cell2.setCellStyle(numberStyle);

	             // Column: No. of Complaints
	             Cell r0020Cell10 = rowR0020.createCell(colR0020++);
	             r0020Cell10.setCellValue(record.getR0020_no_complaints_employees() != null
	                     ? record.getR0020_no_complaints_employees().doubleValue() : 0.0);
	             r0020Cell10.setCellStyle(numberStyle);

	             // Column: Instances of Breaches
	             Cell r0020Cell11 = rowR0020.createCell(colR0020++);
	             r0020Cell11.setCellValue(record.getR0020_no_instancesbreaches_employees() != null
	                     ? record.getR0020_no_instancesbreaches_employees().doubleValue() : 0.0);
	             r0020Cell11.setCellStyle(numberStyle);

	             // Column: No. of Whistleblower Cases
	             Cell r0020Cell12 = rowR0020.createCell(colR0020++);
	             r0020Cell12.setCellValue(record.getR0020_no_whistleblower_employees() != null
	                     ? record.getR0020_no_whistleblower_employees().doubleValue() : 0.0);
	             r0020Cell12.setCellStyle(numberStyle);

	             // Column: Senior Management Training
	             Cell r0020Cell13 = rowR0020.createCell(colR0020++);
	             r0020Cell13.setCellValue(record.getR0020_seniormanagement_training() != null
	                     ? record.getR0020_seniormanagement_training().doubleValue() : 0.0);
	             r0020Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell r0020Cell14 = rowR0020.createCell(colR0020++);
	             r0020Cell14.setCellValue(record.getR0020_bankemployee_training() != null
	                     ? record.getR0020_bankemployee_training().doubleValue() : 0.0);
	             r0020Cell14.setCellStyle(numberStyle);

	             // Column: No. of CAVC Training
	             Cell r0020Cell15 = rowR0020.createCell(colR0020++);
	             r0020Cell15.setCellValue(record.getR0020_no_cavc_training() != null
	                     ? record.getR0020_no_cavc_training().doubleValue() : 0.0);
	             r0020Cell15.setCellStyle(numberStyle);

	             // Column: Frauds and Scam Training
	             Cell r0020Cell16 = rowR0020.createCell(colR0020++);
	             r0020Cell16.setCellValue(record.getR0020_fraudsandscam_training() != null
	                     ? record.getR0020_fraudsandscam_training().doubleValue() : 0.0);
	             r0020Cell16.setCellStyle(numberStyle);

	             // Column: Market Conduct Training
	             Cell r0020Cell17 = rowR0020.createCell(colR0020++);
	             r0020Cell17.setCellValue(record.getR0020_nmarketconduct_training() != null
	                     ? record.getR0020_nmarketconduct_training().doubleValue() : 0.0);
	             r0020Cell17.setCellStyle(numberStyle);

	             // Column: Consumer Protection Training
	             Cell r0020Cell18 = rowR0020.createCell(colR0020++);
	             r0020Cell18.setCellValue(record.getR0020_to_consumerprotection_training() != null
	                     ? record.getR0020_to_consumerprotection_training().doubleValue() : 0.0);
	             r0020Cell18.setCellStyle(numberStyle);

	             // Column: Ombudsman Training
	             Cell r0020Cell19 = rowR0020.createCell(colR0020++);
	             r0020Cell19.setCellValue(record.getR0020_to_ombudsman_training() != null
	                     ? record.getR0020_to_ombudsman_training().doubleValue() : 0.0);
	             r0020Cell19.setCellStyle(numberStyle);

	          // ====== R0030 row - next row ======
	             Row rowR0030 = sheet.getRow(startRow + i + 2);
	             if (rowR0030 == null) rowR0030 = sheet.createRow(startRow + i + 2);

	             int colR0030 = 7;

	             Cell R0030Cell1 = rowR0030.createCell(colR0030++);
	             R0030Cell1.setCellValue(record.getR0030_no_consumerfacing_employees() != null
	                     ? record.getR0030_no_consumerfacing_employees().doubleValue() : 0.0);
	             R0030Cell1.setCellStyle(numberStyle);

	             // Column: No. of Resigned Employees
	             Cell R0030Cell2 = rowR0030.createCell(colR0030++);
	             R0030Cell2.setCellValue(record.getR0030_no_resigned_employees() != null
	                     ? record.getR0030_no_resigned_employees().doubleValue() : 0.0);
	             R0030Cell2.setCellStyle(numberStyle);

	             // Column: No. of Dismissed Employees
	             Cell R0030Cell3 = rowR0030.createCell(colR0030++);
	             R0030Cell3.setCellValue(record.getR0030_no_dismissed_employees() != null
	                     ? record.getR0030_no_dismissed_employees().doubleValue() : 0.0);
	             R0030Cell3.setCellStyle(numberStyle);

	             // Column: Contractual Breaches
	             Cell R0030Cell4 = rowR0030.createCell(colR0030++);
	             R0030Cell4.setCellValue(record.getR0030_contractual_breaches_employees() != null
	                     ? record.getR0030_contractual_breaches_employees().doubleValue() : 0.0);
	             R0030Cell4.setCellStyle(numberStyle);

	             // Column: No. of Sales Staff
	             Cell R0030Cell5 = rowR0030.createCell(colR0030++);
	             R0030Cell5.setCellValue(record.getR0030_no_salesstaff_employees() != null
	                     ? record.getR0030_no_salesstaff_employees().doubleValue() : 0.0);
	             R0030Cell5.setCellStyle(numberStyle);

	             // Column: No. under Remuneration
	             Cell R0030Cell6 = rowR0030.createCell(colR0030++);
	             R0030Cell6.setCellValue(record.getR0030_no_remuneration_employees() != null
	                     ? record.getR0030_no_remuneration_employees().doubleValue() : 0.0);
	             R0030Cell6.setCellStyle(numberStyle);

	             // Column: Remuneration > 50%
	             Cell R0030Cell7 = rowR0030.createCell(colR0030++);
	             R0030Cell7.setCellValue(record.getR0030_no_remuneration50per_employees() != null
	                     ? record.getR0030_no_remuneration50per_employees().doubleValue() : 0.0);
	             R0030Cell7.setCellStyle(numberStyle);

	             // Column: Average Performance
	             Cell R0030Cell8 = rowR0030.createCell(colR0030++);
	             R0030Cell8.setCellValue(record.getR0030_aveperformance_employees() != null
	                     ? record.getR0030_aveperformance_employees().doubleValue() : 0.0);
	             R0030Cell8.setCellStyle(numberStyle);

	             // Column: Conduct Breaches
	             Cell R0030Cell9 = rowR0030.createCell(colR0030++);
	             R0030Cell9.setCellValue(record.getR0030_conduct_breaches_employees() != null
	                     ? record.getR0030_conduct_breaches_employees().doubleValue() : 0.0);
	             R0030Cell9.setCellStyle(numberStyle);

	             // Column: No. of Complaints
	             Cell R0030Cell10 = rowR0030.createCell(colR0030++);
	             R0030Cell10.setCellValue(record.getR0030_no_complaints_employees() != null
	                     ? record.getR0030_no_complaints_employees().doubleValue() : 0.0);
	             R0030Cell10.setCellStyle(numberStyle);

	             // Column: Instances of Breaches
	             Cell R0030Cell11 = rowR0030.createCell(colR0030++);
	             R0030Cell11.setCellValue(record.getR0030_no_instancesbreaches_employees() != null
	                     ? record.getR0030_no_instancesbreaches_employees().doubleValue() : 0.0);
	             R0030Cell11.setCellStyle(numberStyle);

	             // Column: No. of Whistleblower Cases
	             Cell R0030Cell12 = rowR0030.createCell(colR0030++);
	             R0030Cell12.setCellValue(record.getR0030_no_whistleblower_employees() != null
	                     ? record.getR0030_no_whistleblower_employees().doubleValue() : 0.0);
	             R0030Cell12.setCellStyle(numberStyle);

	             // ====== R0030 row - next row ======
	             Row rowR0040 = sheet.getRow(startRow + i + 3);
	             if (rowR0040 == null) rowR0040 = sheet.createRow(startRow + i + 3);

	             int colR0040 = 7;

	             Cell R0040Cell1 = rowR0040.createCell(colR0040++);
	             R0040Cell1.setCellValue(record.getR0040_no_consumerfacing_employees() != null
	                     ? record.getR0040_no_consumerfacing_employees().doubleValue() : 0.0);
	             R0040Cell1.setCellStyle(numberStyle);

	             // Column: No. of Resigned Employees
	             Cell R0040Cell2 = rowR0040.createCell(colR0040++);
	             R0040Cell2.setCellValue(record.getR0040_no_resigned_employees() != null
	                     ? record.getR0040_no_resigned_employees().doubleValue() : 0.0);
	             R0040Cell2.setCellStyle(numberStyle);

	             // Column: No. of Dismissed Employees
	             Cell R0040Cell3 = rowR0040.createCell(colR0040++);
	             R0040Cell3.setCellValue(record.getR0040_no_dismissed_employees() != null
	                     ? record.getR0040_no_dismissed_employees().doubleValue() : 0.0);
	             R0040Cell3.setCellStyle(numberStyle);

	             // Column: Contractual Breaches
	             Cell R0040Cell4 = rowR0040.createCell(colR0040++);
	             R0040Cell4.setCellValue(record.getR0040_contractual_breaches_employees() != null
	                     ? record.getR0040_contractual_breaches_employees().doubleValue() : 0.0);
	             R0040Cell4.setCellStyle(numberStyle);

	             // Column: No. of Sales Staff
	             Cell R0040Cell5 = rowR0040.createCell(colR0040++);
	             R0040Cell5.setCellValue(record.getR0040_no_salesstaff_employees() != null
	                     ? record.getR0040_no_salesstaff_employees().doubleValue() : 0.0);
	             R0040Cell5.setCellStyle(numberStyle);

	             // Column: No. under Remuneration
	             Cell R0040Cell6 = rowR0040.createCell(colR0040++);
	             R0040Cell6.setCellValue(record.getR0040_no_remuneration_employees() != null
	                     ? record.getR0040_no_remuneration_employees().doubleValue() : 0.0);
	             R0040Cell6.setCellStyle(numberStyle);

	             // Column: Remuneration > 50%
	             Cell R0040Cell7 = rowR0040.createCell(colR0040++);
	             R0040Cell7.setCellValue(record.getR0040_no_remuneration50per_employees() != null
	                     ? record.getR0040_no_remuneration50per_employees().doubleValue() : 0.0);
	             R0040Cell7.setCellStyle(numberStyle);

	             // Column: Average Performance
	             Cell R0040Cell8 = rowR0040.createCell(colR0040++);
	             R0040Cell8.setCellValue(record.getR0040_aveperformance_employees() != null
	                     ? record.getR0040_aveperformance_employees().doubleValue() : 0.0);
	             R0040Cell8.setCellStyle(numberStyle);

	             // Column: Conduct Breaches
	             Cell R0040Cell9 = rowR0040.createCell(colR0040++);
	             R0040Cell9.setCellValue(record.getR0040_conduct_breaches_employees() != null
	                     ? record.getR0040_conduct_breaches_employees().doubleValue() : 0.0);
	             R0040Cell9.setCellStyle(numberStyle);

	             // Column: No. of Complaints
	             Cell R0040Cell10 = rowR0040.createCell(colR0040++);
	             R0040Cell10.setCellValue(record.getR0040_no_complaints_employees() != null
	                     ? record.getR0040_no_complaints_employees().doubleValue() : 0.0);
	             R0040Cell10.setCellStyle(numberStyle);

	             // Column: Instances of Breaches
	             Cell R0040Cell11 = rowR0040.createCell(colR0040++);
	             R0040Cell11.setCellValue(record.getR0040_no_instancesbreaches_employees() != null
	                     ? record.getR0040_no_instancesbreaches_employees().doubleValue() : 0.0);
	             R0040Cell11.setCellStyle(numberStyle);

	             // Column: No. of Whistleblower Cases
	             Cell R0040Cell12 = rowR0040.createCell(colR0040++);
	             R0040Cell12.setCellValue(record.getR0040_no_whistleblower_employees() != null
	                     ? record.getR0040_no_whistleblower_employees().doubleValue() : 0.0);
	             R0040Cell12.setCellStyle(numberStyle);

	             
	             // ====== R0050 row - next row ======
	             Row rowR0050 = sheet.getRow(startRow + i + 4);
	             if (rowR0050 == null) rowR0050 = sheet.createRow(startRow + i + 4);

	             int colR0050 = 17;

	          
	             
	          // Column: Instances of Breaches
	             Cell R0050Cell11 = rowR0050.createCell(colR0050++);
	             R0050Cell11.setCellValue(record.getR0050_no_instancesbreaches_employees() != null
	                     ? record.getR0050_no_instancesbreaches_employees().doubleValue() : 0.0);
	             R0050Cell11.setCellStyle(numberStyle);

	             // Column: No. of Whistleblower Cases
	             Cell R0050Cell12 = rowR0050.createCell(colR0050++);
	             R0050Cell12.setCellValue(record.getR0050_no_whistleblower_employees() != null
	                     ? record.getR0050_no_whistleblower_employees().doubleValue() : 0.0);
	             R0050Cell12.setCellStyle(numberStyle);
	             
	             // ====== R0060 row - next row ======
	             Row rowR0060 = sheet.getRow(startRow + i + 5);
	             if (rowR0060 == null) rowR0060 = sheet.createRow(startRow + i + 5);

	             int colR0060 = 7;

	             Cell R0060Cell1 = rowR0060.createCell(colR0060++);
	             R0060Cell1.setCellValue(record.getR0060_no_consumerfacing_employees() != null
	                     ? record.getR0060_no_consumerfacing_employees().doubleValue() : 0.0);
	             R0060Cell1.setCellStyle(numberStyle);

	             // Column: No. of Resigned Employees
	             Cell R0060Cell2 = rowR0060.createCell(colR0060++);
	             R0060Cell2.setCellValue(record.getR0060_no_resigned_employees() != null
	                     ? record.getR0060_no_resigned_employees().doubleValue() : 0.0);
	             R0060Cell2.setCellStyle(numberStyle);

	             // Column: No. of Dismissed Employees
	             Cell R0060Cell3 = rowR0060.createCell(colR0060++);
	             R0060Cell3.setCellValue(record.getR0060_no_dismissed_employees() != null
	                     ? record.getR0060_no_dismissed_employees().doubleValue() : 0.0);
	             R0060Cell3.setCellStyle(numberStyle);

	             // Column: Contractual Breaches
	             Cell R0060Cell4 = rowR0060.createCell(colR0060++);
	             R0060Cell4.setCellValue(record.getR0060_contractual_breaches_employees() != null
	                     ? record.getR0060_contractual_breaches_employees().doubleValue() : 0.0);
	             R0060Cell4.setCellStyle(numberStyle);

	             // Column: No. of Sales Staff
	             Cell R0060Cell5 = rowR0060.createCell(colR0060++);
	             R0060Cell5.setCellValue(record.getR0060_no_salesstaff_employees() != null
	                     ? record.getR0060_no_salesstaff_employees().doubleValue() : 0.0);
	             R0060Cell5.setCellStyle(numberStyle);

	             // Column: No. under Remuneration
	             Cell R0060Cell6 = rowR0060.createCell(colR0060++);
	             R0060Cell6.setCellValue(record.getR0060_no_remuneration_employees() != null
	                     ? record.getR0060_no_remuneration_employees().doubleValue() : 0.0);
	             R0060Cell6.setCellStyle(numberStyle);

	             // Column: Remuneration > 50%
	             Cell R0060Cell7 = rowR0060.createCell(colR0060++);
	             R0060Cell7.setCellValue(record.getR0060_no_remuneration50per_employees() != null
	                     ? record.getR0060_no_remuneration50per_employees().doubleValue() : 0.0);
	             R0060Cell7.setCellStyle(numberStyle);

	             // Column: Average Performance
	             Cell R0060Cell8 = rowR0060.createCell(colR0060++);
	             R0060Cell8.setCellValue(record.getR0060_aveperformance_employees() != null
	                     ? record.getR0060_aveperformance_employees().doubleValue() : 0.0);
	             R0060Cell8.setCellStyle(numberStyle);

	             // Column: Conduct Breaches
	             Cell R0060Cell9 = rowR0060.createCell(colR0060++);
	             R0060Cell9.setCellValue(record.getR0060_conduct_breaches_employees() != null
	                     ? record.getR0060_conduct_breaches_employees().doubleValue() : 0.0);
	             R0060Cell9.setCellStyle(numberStyle);

	             // Column: No. of Complaints
	             Cell R0060Cell10 = rowR0060.createCell(colR0060++);
	             R0060Cell10.setCellValue(record.getR0060_no_complaints_employees() != null
	                     ? record.getR0060_no_complaints_employees().doubleValue() : 0.0);
	             R0060Cell10.setCellStyle(numberStyle);

	             // Column: Instances of Breaches
	             Cell R0060Cell11 = rowR0060.createCell(colR0060++);
	             R0060Cell11.setCellValue(record.getR0060_no_instancesbreaches_employees() != null
	                     ? record.getR0060_no_instancesbreaches_employees().doubleValue() : 0.0);
	             R0060Cell11.setCellStyle(numberStyle);

	             // Column: No. of Whistleblower Cases
	             Cell R0060Cell12 = rowR0060.createCell(colR0060++);
	             R0060Cell12.setCellValue(record.getR0060_no_whistleblower_employees() != null
	                     ? record.getR0060_no_whistleblower_employees().doubleValue() : 0.0);
	             R0060Cell12.setCellStyle(numberStyle);

	         
	             
	             // ====== R0070 row - next row ======
	             Row rowR0070 = sheet.getRow(startRow + i + 6);
	             if (rowR0070 == null) rowR0070 = sheet.createRow(startRow + i + 6);

	             int colR0070 = 7;

	             Cell R0070Cell1 = rowR0070.createCell(colR0070++);
	             R0070Cell1.setCellValue(record.getR0070_no_consumerfacing_employees() != null
	                     ? record.getR0070_no_consumerfacing_employees().doubleValue() : 0.0);
	             R0070Cell1.setCellStyle(numberStyle);

	             // Column: No. of Resigned Employees
	             Cell R0070Cell2 = rowR0070.createCell(colR0070++);
	             R0070Cell2.setCellValue(record.getR0070_no_resigned_employees() != null
	                     ? record.getR0070_no_resigned_employees().doubleValue() : 0.0);
	             R0070Cell2.setCellStyle(numberStyle);

	             // Column: No. of Dismissed Employees
	             Cell R0070Cell3 = rowR0070.createCell(colR0070++);
	             R0070Cell3.setCellValue(record.getR0070_no_dismissed_employees() != null
	                     ? record.getR0070_no_dismissed_employees().doubleValue() : 0.0);
	             R0070Cell3.setCellStyle(numberStyle);

	             // Column: Contractual Breaches
	             Cell R0070Cell4 = rowR0070.createCell(colR0070++);
	             R0070Cell4.setCellValue(record.getR0070_contractual_breaches_employees() != null
	                     ? record.getR0070_contractual_breaches_employees().doubleValue() : 0.0);
	             R0070Cell4.setCellStyle(numberStyle);

	             // Column: No. of Sales Staff
	             Cell R0070Cell5 = rowR0070.createCell(colR0070++);
	             R0070Cell5.setCellValue(record.getR0070_no_salesstaff_employees() != null
	                     ? record.getR0070_no_salesstaff_employees().doubleValue() : 0.0);
	             R0070Cell5.setCellStyle(numberStyle);

	             // Column: No. under Remuneration
	             Cell R0070Cell6 = rowR0070.createCell(colR0070++);
	             R0070Cell6.setCellValue(record.getR0070_no_remuneration_employees() != null
	                     ? record.getR0070_no_remuneration_employees().doubleValue() : 0.0);
	             R0070Cell6.setCellStyle(numberStyle);

	             // Column: Remuneration > 50%
	             Cell R0070Cell7 = rowR0070.createCell(colR0070++);
	             R0070Cell7.setCellValue(record.getR0070_no_remuneration50per_employees() != null
	                     ? record.getR0070_no_remuneration50per_employees().doubleValue() : 0.0);
	             R0070Cell7.setCellStyle(numberStyle);

	             // Column: Average Performance
	             Cell R0070Cell8 = rowR0070.createCell(colR0070++);
	             R0070Cell8.setCellValue(record.getR0070_aveperformance_employees() != null
	                     ? record.getR0070_aveperformance_employees().doubleValue() : 0.0);
	             R0070Cell8.setCellStyle(numberStyle);

	             // Column: Conduct Breaches
	             Cell R0070Cell9 = rowR0070.createCell(colR0070++);
	             R0070Cell9.setCellValue(record.getR0070_conduct_breaches_employees() != null
	                     ? record.getR0070_conduct_breaches_employees().doubleValue() : 0.0);
	             R0070Cell9.setCellStyle(numberStyle);

	             // Column: No. of Complaints
	             Cell R0070Cell10 = rowR0070.createCell(colR0070++);
	             R0070Cell10.setCellValue(record.getR0070_no_complaints_employees() != null
	                     ? record.getR0070_no_complaints_employees().doubleValue() : 0.0);
	             R0070Cell10.setCellStyle(numberStyle);

	             // Column: Instances of Breaches
	             Cell R0070Cell11 = rowR0070.createCell(colR0070++);
	             R0070Cell11.setCellValue(record.getR0070_no_instancesbreaches_employees() != null
	                     ? record.getR0070_no_instancesbreaches_employees().doubleValue() : 0.0);
	             R0070Cell11.setCellStyle(numberStyle);

	             // Column: No. of Whistleblower Cases
	             Cell R0070Cell12 = rowR0070.createCell(colR0070++);
	             R0070Cell12.setCellValue(record.getR0070_no_whistleblower_employees() != null
	                     ? record.getR0070_no_whistleblower_employees().doubleValue() : 0.0);
	             R0070Cell12.setCellStyle(numberStyle);


	           
	             
	             // ====== R0090 row - next row ======
	             Row rowR0090 = sheet.getRow(startRow + i + 8);
	             if (rowR0090 == null) rowR0090 = sheet.createRow(startRow + i + 8);

	             int colR0090 = 19;

	             // Column: Senior Management Training
	             Cell R0090Cell13 = rowR0090.createCell(colR0090++);
	             R0090Cell13.setCellValue(record.getR0090_seniormanagement_training() != null
	                     ? record.getR0090_seniormanagement_training().doubleValue() : 0.0);
	             R0090Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0090Cell14 = rowR0090.createCell(colR0090++);
	             R0090Cell14.setCellValue(record.getR0090_bankemployee_training() != null
	                     ? record.getR0090_bankemployee_training().doubleValue() : 0.0);
	             R0090Cell14.setCellStyle(numberStyle);

	             colR0090 += 2;

	             // Column: Market Conduct Training
	             Cell R0090Cell17 = rowR0090.createCell(colR0090++);
	             R0090Cell17.setCellValue(record.getR0090_nmarketconduct_training() != null
	                     ? record.getR0090_nmarketconduct_training().doubleValue() : 0.0);
	             R0090Cell17.setCellStyle(numberStyle);

	             // Column: Consumer Protection Training
	             Cell R0090cell18 = rowR0090.createCell(colR0090++);
	             R0090cell18.setCellValue(record.getR0090_to_consumerprotection_training() != null
	                     ? record.getR0090_to_consumerprotection_training().doubleValue() : 0.0);
	             R0090cell18.setCellStyle(numberStyle);
	           
	             // ====== R0100 row - next row ======
	             Row rowR0100 = sheet.getRow(startRow + i + 9);
	             if (rowR0100 == null) rowR0100 = sheet.createRow(startRow + i + 9);

	             int colR0100 = 19;
	             
	             // Column: Senior Management Training
	             Cell R0100Cell13 = rowR0100.createCell(colR0100++);
	             R0100Cell13.setCellValue(record.getR0100_seniormanagement_training() != null
	                     ? record.getR0100_seniormanagement_training().doubleValue() : 0.0);
	             R0100Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0100Cell14 = rowR0100.createCell(colR0100++);
	             R0100Cell14.setCellValue(record.getR0100_bankemployee_training() != null
	                     ? record.getR0100_bankemployee_training().doubleValue() : 0.0);
	             R0100Cell14.setCellStyle(numberStyle);

	             // Column: No. of CAVC Training
	             Cell R0100cell15 = rowR0100.createCell(colR0100++);
	             R0100cell15.setCellValue(record.getR0100_no_cavc_training() != null
	                     ? record.getR0100_no_cavc_training().doubleValue() : 0.0);
	             R0100cell15.setCellStyle(numberStyle);
	             
	             colR0100 += 1;
	             
	          // Column: Market Conduct Training
	             Cell R0100Cell17 = rowR0100.createCell(colR0100++);
	             R0100Cell17.setCellValue(record.getR0100_nmarketconduct_training() != null
	                     ? record.getR0100_nmarketconduct_training().doubleValue() : 0.0);
	             R0100Cell17.setCellStyle(numberStyle);

	             
	             
	             // ====== R0110 row - next row ======
	             Row rowR0110 = sheet.getRow(startRow + i + 10);
	             if (rowR0110 == null) rowR0110 = sheet.createRow(startRow + i + 10);

	             int colR0110 = 19;

	             // Column: Senior Management Training
	             Cell R0110Cell13 = rowR0110.createCell(colR0110++);
	             R0110Cell13.setCellValue(record.getR0110_seniormanagement_training() != null
	                     ? record.getR0110_seniormanagement_training().doubleValue() : 0.0);
	             R0110Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0110Cell14 = rowR0110.createCell(colR0110++);
	             R0110Cell14.setCellValue(record.getR0110_bankemployee_training() != null
	                     ? record.getR0110_bankemployee_training().doubleValue() : 0.0);
	             R0110Cell14.setCellStyle(numberStyle);

	             colR0110 += 2;

	             // Column: Market Conduct Training
	             Cell R0110Cell17 = rowR0110.createCell(colR0110++);
	             R0110Cell17.setCellValue(record.getR0110_nmarketconduct_training() != null
	                     ? record.getR0110_nmarketconduct_training().doubleValue() : 0.0);
	             R0110Cell17.setCellStyle(numberStyle);
	             
	          // ====== R0120 row - next row ======
	             Row rowR0120 = sheet.getRow(startRow + i + 11);
	             if (rowR0110 == null) rowR0120 = sheet.createRow(startRow + i + 11);

	             int colR0120 = 19;

	             // Column: Senior Management Training
	             Cell R0120Cell13 = rowR0120.createCell(colR0120++);
	             R0120Cell13.setCellValue(record.getR0120_seniormanagement_training() != null
	                     ? record.getR0120_seniormanagement_training().doubleValue() : 0.0);
	             R0120Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0120Cell14 = rowR0120.createCell(colR0120++);
	             R0120Cell14.setCellValue(record.getR0120_bankemployee_training() != null
	                     ? record.getR0120_bankemployee_training().doubleValue() : 0.0);
	             R0120Cell14.setCellStyle(numberStyle);

	             colR0120 += 2;

	             // Column: Market Conduct Training
	             Cell R0120Cell17 = rowR0120.createCell(colR0120++);
	             R0120Cell17.setCellValue(record.getR0120_nmarketconduct_training() != null
	                     ? record.getR0120_nmarketconduct_training().doubleValue() : 0.0);
	             R0120Cell17.setCellStyle(numberStyle);
	             
	          // ====== R0130 row - next row ======
	             Row rowR0130 = sheet.getRow(startRow + i + 12);
	             if (rowR0110 == null) rowR0130 = sheet.createRow(startRow + i + 12);

	             int colR0130 = 19;

	             // Column: Senior Management Training
	             Cell R0130Cell13 = rowR0130.createCell(colR0130++);
	             R0130Cell13.setCellValue(record.getR0130_seniormanagement_training() != null
	                     ? record.getR0130_seniormanagement_training().doubleValue() : 0.0);
	             R0130Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0130Cell14 = rowR0130.createCell(colR0130++);
	             R0130Cell14.setCellValue(record.getR0130_bankemployee_training() != null
	                     ? record.getR0130_bankemployee_training().doubleValue() : 0.0);
	             R0130Cell14.setCellStyle(numberStyle);

	             colR0130 += 2;

	             // Column: Market Conduct Training
	             Cell R0130Cell17 = rowR0130.createCell(colR0130++);
	             R0130Cell17.setCellValue(record.getR0130_nmarketconduct_training() != null
	                     ? record.getR0130_nmarketconduct_training().doubleValue() : 0.0);
	             R0130Cell17.setCellStyle(numberStyle);
	             
	          // ====== R0140 row - next row ======
	             Row rowR0140 = sheet.getRow(startRow + i + 13);
	             if (rowR0140 == null) rowR0140 = sheet.createRow(startRow + i + 13);

	             int colR0140 = 19;
	             
	             

	             // Column: Senior Management Training
	             Cell R0140Cell13 = rowR0140.createCell(colR0140++);
	             R0140Cell13.setCellValue(record.getR0140_seniormanagement_training() != null
	                     ? record.getR0140_seniormanagement_training().doubleValue() : 0.0);
	             R0140Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0140Cell14 = rowR0140.createCell(colR0140++);
	             R0140Cell14.setCellValue(record.getR0140_bankemployee_training() != null
	                     ? record.getR0140_bankemployee_training().doubleValue() : 0.0);
	             R0140Cell14.setCellStyle(numberStyle);

	             // Column: No. of CAVC Training
	             Cell R0140Cell15 = rowR0140.createCell(colR0140++);
	             R0140Cell15.setCellValue(record.getR0140_no_cavc_training() != null
	                     ? record.getR0140_no_cavc_training().doubleValue() : 0.0);
	             R0140Cell15.setCellStyle(numberStyle);

	             // Column: Frauds and Scam Training
	             Cell R0140Cell16 = rowR0140.createCell(colR0140++);
	             R0140Cell16.setCellValue(record.getR0140_fraudsandscam_training() != null
	                     ? record.getR0140_fraudsandscam_training().doubleValue() : 0.0);
	             R0140Cell16.setCellStyle(numberStyle);

	             // Column: Market Conduct Training
	             Cell R0140Cell17 = rowR0140.createCell(colR0140++);
	             R0140Cell17.setCellValue(record.getR0140_nmarketconduct_training() != null
	                     ? record.getR0140_nmarketconduct_training().doubleValue() : 0.0);
	             R0140Cell17.setCellStyle(numberStyle);

	             // Column: Consumer Protection Training
	             Cell R0140Cell18 = rowR0140.createCell(colR0140++);
	             R0140Cell18.setCellValue(record.getR0140_to_consumerprotection_training() != null
	                     ? record.getR0140_to_consumerprotection_training().doubleValue() : 0.0);
	             R0140Cell18.setCellStyle(numberStyle);

	             // Column: Ombudsman Training
	             Cell R0140Cell19 = rowR0140.createCell(colR0140++);
	             R0140Cell19.setCellValue(record.getR0140_to_ombudsman_training() != null
	                     ? record.getR0140_to_ombudsman_training().doubleValue() : 0.0);
	             R0140Cell19.setCellStyle(numberStyle);
	             
	             Row rowR0150 = sheet.getRow(startRow + i + 14);
	             if (rowR0150 == null) rowR0150 = sheet.createRow(startRow + i + 14);

	             int colR0150 = 19;
	             
	             

	             // Column: Senior Management Training
	             Cell R0150Cell13 = rowR0150.createCell(colR0150++);
	             R0150Cell13.setCellValue(record.getR0150_seniormanagement_training() != null
	                     ? record.getR0150_seniormanagement_training().doubleValue() : 0.0);
	             R0150Cell13.setCellStyle(numberStyle);

	             // Column: Bank Employee Training
	             Cell R0150Cell14 = rowR0150.createCell(colR0150++);
	             R0150Cell14.setCellValue(record.getR0150_bankemployee_training() != null
	                     ? record.getR0150_bankemployee_training().doubleValue() : 0.0);
	             R0150Cell14.setCellStyle(numberStyle);

	             // Column: No. of CAVC Training
	             Cell R0150Cell15 = rowR0150.createCell(colR0150++);
	             R0150Cell15.setCellValue(record.getR0150_no_cavc_training() != null
	                     ? record.getR0150_no_cavc_training().doubleValue() : 0.0);
	             R0150Cell15.setCellStyle(numberStyle);

	             // Column: Frauds and Scam Training
	             Cell R0150Cell16 = rowR0150.createCell(colR0150++);
	             R0150Cell16.setCellValue(record.getR0150_fraudsandscam_training() != null
	                     ? record.getR0150_fraudsandscam_training().doubleValue() : 0.0);
	             R0150Cell16.setCellStyle(numberStyle);

	             // Column: Market Conduct Training
	             Cell R0150Cell17 = rowR0150.createCell(colR0150++);
	             R0150Cell17.setCellValue(record.getR0150_nmarketconduct_training() != null
	                     ? record.getR0150_nmarketconduct_training().doubleValue() : 0.0);
	             R0150Cell17.setCellStyle(numberStyle);

	             // Column: Consumer Protection Training
	             Cell R0150Cell18 = rowR0150.createCell(colR0150++);
	             R0150Cell18.setCellValue(record.getR0150_to_consumerprotection_training() != null
	                     ? record.getR0150_to_consumerprotection_training().doubleValue() : 0.0);
	             R0150Cell18.setCellStyle(numberStyle);

	             // Column: Ombudsman Training
	             Cell R0150Cell19 = rowR0150.createCell(colR0150++);
	             R0150Cell19.setCellValue(record.getR0150_to_ombudsman_training() != null
	                     ? record.getR0150_to_ombudsman_training().doubleValue() : 0.0);
	             R0150Cell19.setCellStyle(numberStyle);
	                // Column C - ID
					/* row.createCell(2).setCellValue(record.getId()); */
	               
	             
	            }


	            workbook.write(out);
	            return out.toByteArray();
	        }

	    } catch (Exception e) {
	        logger.error("Error generating BRF16.2 Excel file", e);
	        throw e;
	    }
	}

	
	public byte[] getBRF16_2DetailExcel(String filename, String fromdate, String todate) {
	    try {
	        logger.info("Generating Excel for BRF16_2 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF16_2Details");

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
	        List<CBUAE_BRF16_2_Detail_Entity> reportData = CBUAE_BRF16_2_Detail_Repos.getdatabydateList(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF16_2_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF16_2 — only header will be written.");
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
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF16_2_DETAIL", null, "CBUAE_BRF16_2_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF16_2 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}





}
