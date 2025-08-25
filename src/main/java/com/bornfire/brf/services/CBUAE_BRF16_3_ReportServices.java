
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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF16_2_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF16_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF16_3_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF16_3_SUMMARY_REPO;
import com.bornfire.brf.entities.CBUAE_BRF16_3_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_2_Summary_Entity1;




@Component
@Service
public class CBUAE_BRF16_3_ReportServices {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF16_2_Reportservice.class);
	

	@Autowired 
	AuditService auditService;
	@Autowired
	private Environment env;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF16_3_SUMMARY_REPO CBUAE_BRF16_3_Summary_Repos;
	@Autowired
	CBUAE_BRF16_3_Detail_Repo CBUAE_BRF16_3_Detail_Repos;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF_16_3View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF_16_3View...");
		ModelAndView mv = new ModelAndView();
		if(type.equals("ARCHIVAL")&version!=null) {

			logger.info("Enter if statement");
			List<CBUAE_BRF16_3_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF16_3_Summary_Entity>();
		
				 T1Master=CBUAE_BRF16_3_Summary_Repos.getdatabydateList();
			
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF16_3_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF16_3_Summary_Entity>();

			 T1Master=CBUAE_BRF16_3_Summary_Repos.getdatabydateList();

			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF16_3");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		mv.addObject("reportid", "BRF16_3");
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
	public ModelAndView getBRF16_3currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF16_3_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	        	T1Dt1 = CBUAE_BRF16_3_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
	        } else {
	            T1Dt1 = CBUAE_BRF16_3_Detail_Repos.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF16_3");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}





	public byte[] getBRF16_3Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
	    try {
	        List<CBUAE_BRF16_3_Summary_Entity> dataList = CBUAE_BRF16_3_Summary_Repos.getdatabydateList();

	        if (dataList.isEmpty()) {
	            logger.warn("No data found for BRF16.3 report.");
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
	            int startRow = 8;     // 9th row (0-based)
				/* int notesRow = 11; */  // "Notes:-" is at 12th row (Excel)

	            // Step 1: Shift "Notes:-" and below to make space for data rows
				/*
				 * if (sheet.getLastRowNum() >= notesRow) { sheet.shiftRows(notesRow,
				 * sheet.getLastRowNum(), dataList.size()); }
				 */

	            // Step 2: Write data rows before the "Notes:-"
	            for (int i = 0; i < dataList.size(); i++) {
	                CBUAE_BRF16_3_Summary_Entity record = dataList.get(i);
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
					/*
					 * Cell r0020Cell1 = rowR0020.createCell(colR0020++);
					 * r0020Cell1.setCellValue(record.getR0020_product() != null ?
					 * record.getR0020_product().doubleValue() : 0.0);
					 * r0020Cell1.setCellStyle(numberStyle);
					 */
	             
	             
	           

	             // Column: No. of Resigned Employees
	             Cell r0020Cell1 = rowR0020.createCell(colR0020++);
	             r0020Cell1.setCellValue(record.getR0020_lfi() != null
	                     ? record.getR0020_lfi().doubleValue() : 0.0);
	             r0020Cell1.setCellStyle(numberStyle);

	             // Column: No. of Complaints
	             Cell r0020Cell2 = rowR0020.createCell(colR0020++);
	             r0020Cell2.setCellValue(record.getR0020_evidence() != null
	                     ? record.getR0020_evidence().doubleValue() : 0.0);
	             r0020Cell2.setCellStyle(numberStyle);

	             Cell r0020Cell3 = rowR0020.createCell(colR0020++);
	             r0020Cell3.setCellValue(record.getR0020_evidencebylfi() != null
	                     ? record.getR0020_evidencebylfi().doubleValue() : 0.0);
	             r0020Cell3.setCellStyle(numberStyle);
	          
	            // Row rowR0030 = sheet.createRow(rowIndex++2); // Create new row
	            // int colR0030 = 6;
	             Row rowR0030 = sheet.getRow(startRow + i + 2);
	             if (rowR0030 == null) rowR0030 = sheet.createRow(startRow + i + 2);

	             int colR0030 = 7; // ✅ Declare column index (e.g., column G if 0-based indexing)

	            

	             // Column: LFI
	             Cell r0030Cell2 = rowR0030.createCell(colR0030++);
	             r0030Cell2.setCellValue(record.getR0030_lfi() != null
	                     ? record.getR0030_lfi().doubleValue() : 0.0);
	             r0030Cell2.setCellStyle(numberStyle);

	             // Column: Evidence
	             Cell r0030Cell3 = rowR0030.createCell(colR0030++);
	             r0030Cell3.setCellValue(record.getR0030_evidence() != null
	                     ? record.getR0030_evidence().doubleValue() : 0.0);
	             r0030Cell3.setCellStyle(numberStyle);

	             // Column: Evidence by LFI
	             Cell r0030Cell4 = rowR0030.createCell(colR0030++);
	             r0030Cell4.setCellValue(record.getR0030_evidencebylfi() != null
	                     ? record.getR0030_evidencebylfi().doubleValue() : 0.0);
	             r0030Cell4.setCellStyle(numberStyle);

	          // Assuming 'startRow' and 'i' are defined and looped properly for each record
	          // Assuming 'colR00XX' starts from 6 (or any starting column index as per your Excel layout)

	          // R0040
	          int colR0040 = 7;
	          Row rowR0040 = sheet.getRow(startRow + i + 3);
	          if (rowR0040 == null) rowR0040 = sheet.createRow(startRow + i + 3);

	         

	          // Column: LFI
	          Cell r0040Cell2 = rowR0040.createCell(colR0040++);
	          r0040Cell2.setCellValue(record.getR0040_lfi() != null ? record.getR0040_lfi().doubleValue() : 0.0);
	          r0040Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0040Cell3 = rowR0040.createCell(colR0040++);
	          r0040Cell3.setCellValue(record.getR0040_evidence() != null ? record.getR0040_evidence().doubleValue() : 0.0);
	          r0040Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0040Cell4 = rowR0040.createCell(colR0040++);
	          r0040Cell4.setCellValue(record.getR0040_evidencebylfi() != null ? record.getR0040_evidencebylfi().doubleValue() : 0.0);
	          r0040Cell4.setCellStyle(numberStyle);


	          // R0050
	          int colR0050 = 7;
	          Row rowR0050 = sheet.getRow(startRow + i + 4);
	          if (rowR0050 == null) rowR0050 = sheet.createRow(startRow + i + 4);

	          Cell r0050Cell2 = rowR0050.createCell(colR0050++);
	          r0050Cell2.setCellValue(record.getR0050_lfi() != null ? record.getR0050_lfi().doubleValue() : 0.0);
	          r0050Cell2.setCellStyle(numberStyle);

	          Cell r0050Cell3 = rowR0050.createCell(colR0050++);
	          r0050Cell3.setCellValue(record.getR0050_evidence() != null ? record.getR0050_evidence().doubleValue() : 0.0);
	          r0050Cell3.setCellStyle(numberStyle);

	          Cell r0050Cell4 = rowR0050.createCell(colR0050++);
	          r0050Cell4.setCellValue(record.getR0050_evidencebylfi() != null ? record.getR0050_evidencebylfi().doubleValue() : 0.0);
	          r0050Cell4.setCellStyle(numberStyle);


	          // R0060
	          int colR0060 = 7;
	          Row rowR0060 = sheet.getRow(startRow + i + 5);
	          if (rowR0060 == null) rowR0060 = sheet.createRow(startRow + i + 5);


	          Cell r0060Cell2 = rowR0060.createCell(colR0060++);
	          r0060Cell2.setCellValue(record.getR0060_lfi() != null ? record.getR0060_lfi().doubleValue() : 0.0);
	          r0060Cell2.setCellStyle(numberStyle);

	          Cell r0060Cell3 = rowR0060.createCell(colR0060++);
	          r0060Cell3.setCellValue(record.getR0060_evidence() != null ? record.getR0060_evidence().doubleValue() : 0.0);
	          r0060Cell3.setCellStyle(numberStyle);

	          Cell r0060Cell4 = rowR0060.createCell(colR0060++);
	          r0060Cell4.setCellValue(record.getR0060_evidencebylfi() != null ? record.getR0060_evidencebylfi().doubleValue() : 0.0);
	          r0060Cell4.setCellStyle(numberStyle);

	          int colR0070 = 7;
	          Row rowR0070 = sheet.getRow(startRow + i + 6);
	          if (rowR0070 == null) rowR0070 = sheet.createRow(startRow + i + 6);

	          // Column: LFI
	          Cell r0070Cell2 = rowR0070.createCell(colR0070++);
	          r0070Cell2.setCellValue(record.getR0070_lfi() != null ? record.getR0070_lfi().doubleValue() : 0.0);
	          r0070Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0070Cell3 = rowR0070.createCell(colR0070++);
	          r0070Cell3.setCellValue(record.getR0070_evidence() != null ? record.getR0070_evidence().doubleValue() : 0.0);
	          r0070Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0070Cell4 = rowR0070.createCell(colR0070++);
	          r0070Cell4.setCellValue(record.getR0070_evidencebylfi() != null ? record.getR0070_evidencebylfi().doubleValue() : 0.0);
	          r0070Cell4.setCellStyle(numberStyle);

	          int colR0080 = 7;
	          Row rowR0080 = sheet.getRow(startRow + i + 7);
	          if (rowR0080 == null) rowR0080 = sheet.createRow(startRow + i + 7);

	          // Column: LFI
	          Cell r0080Cell2 = rowR0080.createCell(colR0080++);
	          r0080Cell2.setCellValue(record.getR0080_lfi() != null ? record.getR0080_lfi().doubleValue() : 0.0);
	          r0080Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0080Cell3 = rowR0080.createCell(colR0080++);
	          r0080Cell3.setCellValue(record.getR0080_evidence() != null ? record.getR0080_evidence().doubleValue() : 0.0);
	          r0080Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0080Cell4 = rowR0080.createCell(colR0080++);
	          r0080Cell4.setCellValue(record.getR0080_evidencebylfi() != null ? record.getR0080_evidencebylfi().doubleValue() : 0.0);
	          r0080Cell4.setCellStyle(numberStyle);

	          int colR0090 = 7;
	          Row rowR0090 = sheet.getRow(startRow + i + 8);
	          if (rowR0090 == null) rowR0090 = sheet.createRow(startRow + i + 8);

	          // Column: LFI
	          Cell r0090Cell2 = rowR0090.createCell(colR0090++);
	          r0090Cell2.setCellValue(record.getR0090_lfi() != null ? record.getR0090_lfi().doubleValue() : 0.0);
	          r0090Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0090Cell3 = rowR0090.createCell(colR0090++);
	          r0090Cell3.setCellValue(record.getR0090_evidence() != null ? record.getR0090_evidence().doubleValue() : 0.0);
	          r0090Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0090Cell4 = rowR0090.createCell(colR0090++);
	          r0090Cell4.setCellValue(record.getR0090_evidencebylfi() != null ? record.getR0090_evidencebylfi().doubleValue() : 0.0);
	          r0090Cell4.setCellStyle(numberStyle);

	       // ====================== R0100 ======================
	          int colR0100 = 7;
	          Row rowR0100 = sheet.getRow(startRow + i + 9);
	          if (rowR0100 == null) rowR0100 = sheet.createRow(startRow + i + 9);

	          // Column: LFI
	          Cell r0100Cell2 = rowR0100.createCell(colR0100++);
	          r0100Cell2.setCellValue(record.getR0100_lfi() != null ? record.getR0100_lfi().doubleValue() : 0.0);
	          r0100Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0100Cell3 = rowR0100.createCell(colR0100++);
	          r0100Cell3.setCellValue(record.getR0100_evidence() != null ? record.getR0100_evidence().doubleValue() : 0.0);
	          r0100Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0100Cell4 = rowR0100.createCell(colR0100++);
	          r0100Cell4.setCellValue(record.getR0100_evidencebylfi() != null ? record.getR0100_evidencebylfi().doubleValue() : 0.0);
	          r0100Cell4.setCellStyle(numberStyle);

	          // ====================== R0120 ======================
	          int colR0120 = 7;
	          Row rowR0120 = sheet.getRow(startRow + i + 11);
	          if (rowR0120 == null) rowR0120 = sheet.createRow(startRow + i + 11);

	          // Column: LFI
	          Cell r0120Cell2 = rowR0120.createCell(colR0120++);
	          r0120Cell2.setCellValue(record.getR0120_lfi() != null ? record.getR0120_lfi().doubleValue() : 0.0);
	          r0120Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0120Cell3 = rowR0120.createCell(colR0120++);
	          r0120Cell3.setCellValue(record.getR0120_evidence() != null ? record.getR0120_evidence().doubleValue() : 0.0);
	          r0120Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0120Cell4 = rowR0120.createCell(colR0120++);
	          r0120Cell4.setCellValue(record.getR0120_evidencebylfi() != null ? record.getR0120_evidencebylfi().doubleValue() : 0.0);
	          r0120Cell4.setCellStyle(numberStyle);


	          // ====================== R0130 ======================
	          int colR0130 = 7;
	          Row rowR0130 = sheet.getRow(startRow + i + 12);
	          if (rowR0130 == null) rowR0130 = sheet.createRow(startRow + i + 12);

	          // Column: LFI
	          Cell r0130Cell2 = rowR0130.createCell(colR0130++);
	          r0130Cell2.setCellValue(record.getR0130_lfi() != null ? record.getR0130_lfi().doubleValue() : 0.0);
	          r0130Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0130Cell3 = rowR0130.createCell(colR0130++);
	          r0130Cell3.setCellValue(record.getR0130_evidence() != null ? record.getR0130_evidence().doubleValue() : 0.0);
	          r0130Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0130Cell4 = rowR0130.createCell(colR0130++);
	          r0130Cell4.setCellValue(record.getR0130_evidencebylfi() != null ? record.getR0130_evidencebylfi().doubleValue() : 0.0);
	          r0130Cell4.setCellStyle(numberStyle);

	       // ====================== R0150 ======================
	          int colR0150 = 7;
	          Row rowR0150 = sheet.getRow(startRow + i + 14);
	          if (rowR0150 == null) rowR0150 = sheet.createRow(startRow + i + 14);

	          // Column: LFI
	          Cell r0150Cell2 = rowR0150.createCell(colR0150++);
	          r0150Cell2.setCellValue(record.getR0150_lfi() != null ? record.getR0150_lfi().doubleValue() : 0.0);
	          r0150Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0150Cell3 = rowR0150.createCell(colR0150++);
	          r0150Cell3.setCellValue(record.getR0150_evidence() != null ? record.getR0150_evidence().doubleValue() : 0.0);
	          r0150Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0150Cell4 = rowR0150.createCell(colR0150++);
	          r0150Cell4.setCellValue(record.getR0150_evidencebylfi() != null ? record.getR0150_evidencebylfi().doubleValue() : 0.0);
	          r0150Cell4.setCellStyle(numberStyle);


	          // ====================== R0160 ======================
	          int colR0160 = 7;
	          Row rowR0160 = sheet.getRow(startRow + i + 15);
	          if (rowR0160 == null) rowR0160 = sheet.createRow(startRow + i + 15);

	          // Column: LFI
	          Cell r0160Cell2 = rowR0160.createCell(colR0160++);
	          r0160Cell2.setCellValue(record.getR0160_lfi() != null ? record.getR0160_lfi().doubleValue() : 0.0);
	          r0160Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0160Cell3 = rowR0160.createCell(colR0160++);
	          r0160Cell3.setCellValue(record.getR0160_evidence() != null ? record.getR0160_evidence().doubleValue() : 0.0);
	          r0160Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0160Cell4 = rowR0160.createCell(colR0160++);
	          r0160Cell4.setCellValue(record.getR0160_evidencebylfi() != null ? record.getR0160_evidencebylfi().doubleValue() : 0.0);
	          r0160Cell4.setCellStyle(numberStyle);


	          // ====================== R0170 ======================
	          int colR0170 = 7;
	          Row rowR0170 = sheet.getRow(startRow + i + 16);
	          if (rowR0170 == null) rowR0170 = sheet.createRow(startRow + i + 16);

	          // Column: LFI
	          Cell r0170Cell2 = rowR0170.createCell(colR0170++);
	          r0170Cell2.setCellValue(record.getR0170_lfi() != null ? record.getR0170_lfi().doubleValue() : 0.0);
	          r0170Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0170Cell3 = rowR0170.createCell(colR0170++);
	          r0170Cell3.setCellValue(record.getR0170_evidence() != null ? record.getR0170_evidence().doubleValue() : 0.0);
	          r0170Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0170Cell4 = rowR0170.createCell(colR0170++);
	          r0170Cell4.setCellValue(record.getR0170_evidencebylfi() != null ? record.getR0170_evidencebylfi().doubleValue() : 0.0);
	          r0170Cell4.setCellStyle(numberStyle);


	          // ====================== R0180 ======================
	          int colR0180 = 7;
	          Row rowR0180 = sheet.getRow(startRow + i + 17);
	          if (rowR0180 == null) rowR0180 = sheet.createRow(startRow + i + 17);

	          // Column: LFI
	          Cell r0180Cell2 = rowR0180.createCell(colR0180++);
	          r0180Cell2.setCellValue(record.getR0180_lfi() != null ? record.getR0180_lfi().doubleValue() : 0.0);
	          r0180Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0180Cell3 = rowR0180.createCell(colR0180++);
	          r0180Cell3.setCellValue(record.getR0180_evidence() != null ? record.getR0180_evidence().doubleValue() : 0.0);
	          r0180Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0180Cell4 = rowR0180.createCell(colR0180++);
	          r0180Cell4.setCellValue(record.getR0180_evidencebylfi() != null ? record.getR0180_evidencebylfi().doubleValue() : 0.0);
	          r0180Cell4.setCellStyle(numberStyle);


	          // ====================== R0190 ======================
	          int colR0190 = 7;
	          Row rowR0190 = sheet.getRow(startRow + i + 18);
	          if (rowR0190 == null) rowR0190 = sheet.createRow(startRow + i + 18);

	          // Column: LFI
	          Cell r0190Cell2 = rowR0190.createCell(colR0190++);
	          r0190Cell2.setCellValue(record.getR0190_lfi() != null ? record.getR0190_lfi().doubleValue() : 0.0);
	          r0190Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0190Cell3 = rowR0190.createCell(colR0190++);
	          r0190Cell3.setCellValue(record.getR0190_evidence() != null ? record.getR0190_evidence().doubleValue() : 0.0);
	          r0190Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0190Cell4 = rowR0190.createCell(colR0190++);
	          r0190Cell4.setCellValue(record.getR0190_evidencebylfi() != null ? record.getR0190_evidencebylfi().doubleValue() : 0.0);
	          r0190Cell4.setCellStyle(numberStyle);

	       // ====================== R0200 ======================
	          int colR0200 = 7;
	          Row rowR0200 = sheet.getRow(startRow + i + 19);
	          if (rowR0200 == null) rowR0200 = sheet.createRow(startRow + i + 19);

	          // Column: LFI
	          Cell r0200Cell2 = rowR0200.createCell(colR0200++);
	          r0200Cell2.setCellValue(record.getR0200_lfi() != null ? record.getR0200_lfi().doubleValue() : 0.0);
	          r0200Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0200Cell3 = rowR0200.createCell(colR0200++);
	          r0200Cell3.setCellValue(record.getR0200_evidence() != null ? record.getR0200_evidence().doubleValue() : 0.0);
	          r0200Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0200Cell4 = rowR0200.createCell(colR0200++);
	          r0200Cell4.setCellValue(record.getR0200_evidencebylfi() != null ? record.getR0200_evidencebylfi().doubleValue() : 0.0);
	          r0200Cell4.setCellStyle(numberStyle);


	          // ====================== R0210 ======================
	          int colR0210 = 7;
	          Row rowR0210 = sheet.getRow(startRow + i + 20);
	          if (rowR0210 == null) rowR0210 = sheet.createRow(startRow + i + 20);

	          // Column: LFI
	          Cell r0210Cell2 = rowR0210.createCell(colR0210++);
	          r0210Cell2.setCellValue(record.getR0210_lfi() != null ? record.getR0210_lfi().doubleValue() : 0.0);
	          r0210Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0210Cell3 = rowR0210.createCell(colR0210++);
	          r0210Cell3.setCellValue(record.getR0210_evidence() != null ? record.getR0210_evidence().doubleValue() : 0.0);
	          r0210Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0210Cell4 = rowR0210.createCell(colR0210++);
	          r0210Cell4.setCellValue(record.getR0210_evidencebylfi() != null ? record.getR0210_evidencebylfi().doubleValue() : 0.0);
	          r0210Cell4.setCellStyle(numberStyle);


	          // ====================== R0220 ======================
	          int colR0220 = 7;
	          Row rowR0220 = sheet.getRow(startRow + i + 21);
	          if (rowR0220 == null) rowR0220 = sheet.createRow(startRow + i + 21);

	          // Column: LFI
	          Cell r0220Cell2 = rowR0220.createCell(colR0220++);
	          r0220Cell2.setCellValue(record.getR0220_lfi() != null ? record.getR0220_lfi().doubleValue() : 0.0);
	          r0220Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0220Cell3 = rowR0220.createCell(colR0220++);
	          r0220Cell3.setCellValue(record.getR0220_evidence() != null ? record.getR0220_evidence().doubleValue() : 0.0);
	          r0220Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0220Cell4 = rowR0220.createCell(colR0220++);
	          r0220Cell4.setCellValue(record.getR0220_evidencebylfi() != null ? record.getR0220_evidencebylfi().doubleValue() : 0.0);
	          r0220Cell4.setCellStyle(numberStyle);

	       // ====================== R0240 ======================
	          int colR0240 = 7;
	          Row rowR0240 = sheet.getRow(startRow + i + 23);
	          if (rowR0240 == null) rowR0240 = sheet.createRow(startRow + i + 23);

	          // Column: LFI
	          Cell r0240Cell2 = rowR0240.createCell(colR0240++);
	          r0240Cell2.setCellValue(record.getR0240_lfi() != null ? record.getR0240_lfi().doubleValue() : 0.0);
	          r0240Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0240Cell3 = rowR0240.createCell(colR0240++);
	          r0240Cell3.setCellValue(record.getR0240_evidence() != null ? record.getR0240_evidence().doubleValue() : 0.0);
	          r0240Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0240Cell4 = rowR0240.createCell(colR0240++);
	          r0240Cell4.setCellValue(record.getR0240_evidencebylfi() != null ? record.getR0240_evidencebylfi().doubleValue() : 0.0);
	          r0240Cell4.setCellStyle(numberStyle);


	          // ====================== R0250 ======================
	          int colR0250 = 7;
	          Row rowR0250 = sheet.getRow(startRow + i + 24);
	          if (rowR0250 == null) rowR0250 = sheet.createRow(startRow + i + 24);

	          // Column: LFI
	          Cell r0250Cell2 = rowR0250.createCell(colR0250++);
	          r0250Cell2.setCellValue(record.getR0250_lfi() != null ? record.getR0250_lfi().doubleValue() : 0.0);
	          r0250Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0250Cell3 = rowR0250.createCell(colR0250++);
	          r0250Cell3.setCellValue(record.getR0250_evidence() != null ? record.getR0250_evidence().doubleValue() : 0.0);
	          r0250Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0250Cell4 = rowR0250.createCell(colR0250++);
	          r0250Cell4.setCellValue(record.getR0250_evidencebylfi() != null ? record.getR0250_evidencebylfi().doubleValue() : 0.0);
	          r0250Cell4.setCellStyle(numberStyle);

	       // ====================== R0270 ======================
	          int colR0270 = 7;
	          Row rowR0270 = sheet.getRow(startRow + i + 26);
	          if (rowR0270 == null) rowR0270 = sheet.createRow(startRow + i + 26);

	          // Column: LFI
	          Cell r0270Cell2 = rowR0270.createCell(colR0270++);
	          r0270Cell2.setCellValue(record.getR0270_lfi() != null ? record.getR0270_lfi().doubleValue() : 0.0);
	          r0270Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0270Cell3 = rowR0270.createCell(colR0270++);
	          r0270Cell3.setCellValue(record.getR0270_evidence() != null ? record.getR0270_evidence().doubleValue() : 0.0);
	          r0270Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0270Cell4 = rowR0270.createCell(colR0270++);
	          r0270Cell4.setCellValue(record.getR0270_evidencebylfi() != null ? record.getR0270_evidencebylfi().doubleValue() : 0.0);
	          r0270Cell4.setCellStyle(numberStyle);


	          // ====================== R0280 ======================
	          int colR0280 = 7;
	          Row rowR0280 = sheet.getRow(startRow + i + 27);
	          if (rowR0280 == null) rowR0280 = sheet.createRow(startRow + i + 27);

	          // Column: LFI
	          Cell r0280Cell2 = rowR0280.createCell(colR0280++);
	          r0280Cell2.setCellValue(record.getR0280_lfi() != null ? record.getR0280_lfi().doubleValue() : 0.0);
	          r0280Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0280Cell3 = rowR0280.createCell(colR0280++);
	          r0280Cell3.setCellValue(record.getR0280_evidence() != null ? record.getR0280_evidence().doubleValue() : 0.0);
	          r0280Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0280Cell4 = rowR0280.createCell(colR0280++);
	          r0280Cell4.setCellValue(record.getR0280_evidencebylfi() != null ? record.getR0280_evidencebylfi().doubleValue() : 0.0);
	          r0280Cell4.setCellStyle(numberStyle);


	          // ====================== R0300 ======================
	          int colR0300 = 7;
	          Row rowR0300 = sheet.getRow(startRow + i + 29);
	          if (rowR0300 == null) rowR0300 = sheet.createRow(startRow + i + 29);

	          // Column: LFI
	          Cell r0300Cell2 = rowR0300.createCell(colR0300++);
	          r0300Cell2.setCellValue(record.getR0300_lfi() != null ? record.getR0300_lfi().doubleValue() : 0.0);
	          r0300Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0300Cell3 = rowR0300.createCell(colR0300++);
	          r0300Cell3.setCellValue(record.getR0300_evidence() != null ? record.getR0300_evidence().doubleValue() : 0.0);
	          r0300Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0300Cell4 = rowR0300.createCell(colR0300++);
	          r0300Cell4.setCellValue(record.getR0300_evidencebylfi() != null ? record.getR0300_evidencebylfi().doubleValue() : 0.0);
	          r0300Cell4.setCellStyle(numberStyle);


	       // ====================== R0310 ======================
	          int colR0310 = 7;
	          Row rowR0310 = sheet.getRow(startRow + i + 30); // Changed from +31 to +30
	          if (rowR0310 == null) rowR0310 = sheet.createRow(startRow + i + 30);

	          // Column: LFI
	          Cell r0310Cell2 = rowR0310.createCell(colR0310++);
	          r0310Cell2.setCellValue(record.getR0310_lfi() != null ? record.getR0310_lfi().doubleValue() : 0.0);
	          r0310Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0310Cell3 = rowR0310.createCell(colR0310++);
	          r0310Cell3.setCellValue(record.getR0310_evidence() != null ? record.getR0310_evidence().doubleValue() : 0.0);
	          r0310Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0310Cell4 = rowR0310.createCell(colR0310++);
	          r0310Cell4.setCellValue(record.getR0310_evidencebylfi() != null ? record.getR0310_evidencebylfi().doubleValue() : 0.0);
	          r0310Cell4.setCellStyle(numberStyle);

	       // ====================== R0320 ======================
	          int colR0320 = 7;
	          Row rowR0320 = sheet.getRow(startRow + i + 31);
	          if (rowR0320 == null) rowR0320 = sheet.createRow(startRow + i + 31);

	          // Column: LFI
	          Cell r0320Cell2 = rowR0320.createCell(colR0320++);
	          r0320Cell2.setCellValue(record.getR0320_lfi() != null ? record.getR0320_lfi().doubleValue() : 0.0);
	          r0320Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0320Cell3 = rowR0320.createCell(colR0320++);
	          r0320Cell3.setCellValue(record.getR0320_evidence() != null ? record.getR0320_evidence().doubleValue() : 0.0);
	          r0320Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0320Cell4 = rowR0320.createCell(colR0320++);
	          r0320Cell4.setCellValue(record.getR0320_evidencebylfi() != null ? record.getR0320_evidencebylfi().doubleValue() : 0.0);
	          r0320Cell4.setCellStyle(numberStyle);


	          // ====================== R0340 ======================
	          int colR0340 = 7;
	          Row rowR0340 = sheet.getRow(startRow + i + 33); // skipping R0330
	          if (rowR0340 == null) rowR0340 = sheet.createRow(startRow + i + 33);

	          // Column: LFI
	          Cell r0340Cell2 = rowR0340.createCell(colR0340++);
	          r0340Cell2.setCellValue(record.getR0340_lfi() != null ? record.getR0340_lfi().doubleValue() : 0.0);
	          r0340Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0340Cell3 = rowR0340.createCell(colR0340++);
	          r0340Cell3.setCellValue(record.getR0340_evidence() != null ? record.getR0340_evidence().doubleValue() : 0.0);
	          r0340Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0340Cell4 = rowR0340.createCell(colR0340++);
	          r0340Cell4.setCellValue(record.getR0340_evidencebylfi() != null ? record.getR0340_evidencebylfi().doubleValue() : 0.0);
	          r0340Cell4.setCellStyle(numberStyle);


	          // ====================== R0360 ======================
	          int colR0360 = 7;
	          Row rowR0360 = sheet.getRow(startRow + i + 35); // skipping R0350
	          if (rowR0360 == null) rowR0360 = sheet.createRow(startRow + i + 35);

	          // Column: LFI
	          Cell r0360Cell2 = rowR0360.createCell(colR0360++);
	          r0360Cell2.setCellValue(record.getR0360_lfi() != null ? record.getR0360_lfi().doubleValue() : 0.0);
	          r0360Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0360Cell3 = rowR0360.createCell(colR0360++);
	          r0360Cell3.setCellValue(record.getR0360_evidence() != null ? record.getR0360_evidence().doubleValue() : 0.0);
	          r0360Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0360Cell4 = rowR0360.createCell(colR0360++);
	          r0360Cell4.setCellValue(record.getR0360_evidencebylfi() != null ? record.getR0360_evidencebylfi().doubleValue() : 0.0);
	          r0360Cell4.setCellStyle(numberStyle);


	          // ====================== R0370 ======================
	          int colR0370 = 7;
	          Row rowR0370 = sheet.getRow(startRow + i + 36);
	          if (rowR0370 == null) rowR0370 = sheet.createRow(startRow + i + 36);

	          // Column: LFI
	          Cell r0370Cell2 = rowR0370.createCell(colR0370++);
	          r0370Cell2.setCellValue(record.getR0370_lfi() != null ? record.getR0370_lfi().doubleValue() : 0.0);
	          r0370Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0370Cell3 = rowR0370.createCell(colR0370++);
	          r0370Cell3.setCellValue(record.getR0370_evidence() != null ? record.getR0370_evidence().doubleValue() : 0.0);
	          r0370Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0370Cell4 = rowR0370.createCell(colR0370++);
	          r0370Cell4.setCellValue(record.getR0370_evidencebylfi() != null ? record.getR0370_evidencebylfi().doubleValue() : 0.0);
	          r0370Cell4.setCellStyle(numberStyle);

	       // ====================== R0380 ======================
	          int colR0380 = 7;
	          Row rowR0380 = sheet.getRow(startRow + i + 37);
	          if (rowR0380 == null) rowR0380 = sheet.createRow(startRow + i + 37);

	          // Column: LFI
	          Cell r0380Cell2 = rowR0380.createCell(colR0380++);
	          r0380Cell2.setCellValue(record.getR0380_lfi() != null ? record.getR0380_lfi().doubleValue() : 0.0);
	          r0380Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0380Cell3 = rowR0380.createCell(colR0380++);
	          r0380Cell3.setCellValue(record.getR0380_evidence() != null ? record.getR0380_evidence().doubleValue() : 0.0);
	          r0380Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0380Cell4 = rowR0380.createCell(colR0380++);
	          r0380Cell4.setCellValue(record.getR0380_evidencebylfi() != null ? record.getR0380_evidencebylfi().doubleValue() : 0.0);
	          r0380Cell4.setCellStyle(numberStyle);


	          // ====================== R0390 ======================
	          int colR0390 = 7;
	          Row rowR0390 = sheet.getRow(startRow + i + 38);
	          if (rowR0390 == null) rowR0390 = sheet.createRow(startRow + i + 38);

	          // Column: LFI
	          Cell r0390Cell2 = rowR0390.createCell(colR0390++);
	          r0390Cell2.setCellValue(record.getR0390_lfi() != null ? record.getR0390_lfi().doubleValue() : 0.0);
	          r0390Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0390Cell3 = rowR0390.createCell(colR0390++);
	          r0390Cell3.setCellValue(record.getR0390_evidence() != null ? record.getR0390_evidence().doubleValue() : 0.0);
	          r0390Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0390Cell4 = rowR0390.createCell(colR0390++);
	          r0390Cell4.setCellValue(record.getR0390_evidencebylfi() != null ? record.getR0390_evidencebylfi().doubleValue() : 0.0);
	          r0390Cell4.setCellStyle(numberStyle);


	          // ====================== R0400 ======================
	          int colR0400 = 7;
	          Row rowR0400 = sheet.getRow(startRow + i + 39);
	          if (rowR0400 == null) rowR0400 = sheet.createRow(startRow + i + 39);

	          // Column: LFI
	          Cell r0400Cell2 = rowR0400.createCell(colR0400++);
	          r0400Cell2.setCellValue(record.getR0400_lfi() != null ? record.getR0400_lfi().doubleValue() : 0.0);
	          r0400Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0400Cell3 = rowR0400.createCell(colR0400++);
	          r0400Cell3.setCellValue(record.getR0400_evidence() != null ? record.getR0400_evidence().doubleValue() : 0.0);
	          r0400Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0400Cell4 = rowR0400.createCell(colR0400++);
	          r0400Cell4.setCellValue(record.getR0400_evidencebylfi() != null ? record.getR0400_evidencebylfi().doubleValue() : 0.0);
	          r0400Cell4.setCellStyle(numberStyle);


	          // ====================== R0410 ======================
	          int colR0410 = 7;
	          Row rowR0410 = sheet.getRow(startRow + i + 40);
	          if (rowR0410 == null) rowR0410 = sheet.createRow(startRow + i + 40);

	          // Column: LFI
	          Cell r0410Cell2 = rowR0410.createCell(colR0410++);
	          r0410Cell2.setCellValue(record.getR0410_lfi() != null ? record.getR0410_lfi().doubleValue() : 0.0);
	          r0410Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0410Cell3 = rowR0410.createCell(colR0410++);
	          r0410Cell3.setCellValue(record.getR0410_evidence() != null ? record.getR0410_evidence().doubleValue() : 0.0);
	          r0410Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0410Cell4 = rowR0410.createCell(colR0410++);
	          r0410Cell4.setCellValue(record.getR0410_evidencebylfi() != null ? record.getR0410_evidencebylfi().doubleValue() : 0.0);
	          r0410Cell4.setCellStyle(numberStyle);


	          // ====================== R0420 ======================
	          int colR0420 = 7;
	          Row rowR0420 = sheet.getRow(startRow + i + 41);
	          if (rowR0420 == null) rowR0420 = sheet.createRow(startRow + i + 41);

	          // Column: LFI
	          Cell r0420Cell2 = rowR0420.createCell(colR0420++);
	          r0420Cell2.setCellValue(record.getR0420_lfi() != null ? record.getR0420_lfi().doubleValue() : 0.0);
	          r0420Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0420Cell3 = rowR0420.createCell(colR0420++);
	          r0420Cell3.setCellValue(record.getR0420_evidence() != null ? record.getR0420_evidence().doubleValue() : 0.0);
	          r0420Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0420Cell4 = rowR0420.createCell(colR0420++);
	          r0420Cell4.setCellValue(record.getR0420_evidencebylfi() != null ? record.getR0420_evidencebylfi().doubleValue() : 0.0);
	          r0420Cell4.setCellStyle(numberStyle);


	          // ====================== R0430 ======================
	          int colR0430 = 7;
	          Row rowR0430 = sheet.getRow(startRow + i + 42);
	          if (rowR0430 == null) rowR0430 = sheet.createRow(startRow + i + 42);

	          // Column: LFI
	          Cell r0430Cell2 = rowR0430.createCell(colR0430++);
	          r0430Cell2.setCellValue(record.getR0430_lfi() != null ? record.getR0430_lfi().doubleValue() : 0.0);
	          r0430Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0430Cell3 = rowR0430.createCell(colR0430++);
	          r0430Cell3.setCellValue(record.getR0430_evidence() != null ? record.getR0430_evidence().doubleValue() : 0.0);
	          r0430Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0430Cell4 = rowR0430.createCell(colR0430++);
	          r0430Cell4.setCellValue(record.getR0430_evidencebylfi() != null ? record.getR0430_evidencebylfi().doubleValue() : 0.0);
	          r0430Cell4.setCellStyle(numberStyle);


	          // ====================== R0440 ======================
	          int colR0440 = 7;
	          Row rowR0440 = sheet.getRow(startRow + i + 43);
	          if (rowR0440 == null) rowR0440 = sheet.createRow(startRow + i + 43);

	          // Column: LFI
	          Cell r0440Cell2 = rowR0440.createCell(colR0440++);
	          r0440Cell2.setCellValue(record.getR0440_lfi() != null ? record.getR0440_lfi().doubleValue() : 0.0);
	          r0440Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0440Cell3 = rowR0440.createCell(colR0440++);
	          r0440Cell3.setCellValue(record.getR0440_evidence() != null ? record.getR0440_evidence().doubleValue() : 0.0);
	          r0440Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0440Cell4 = rowR0440.createCell(colR0440++);
	          r0440Cell4.setCellValue(record.getR0440_evidencebylfi() != null ? record.getR0440_evidencebylfi().doubleValue() : 0.0);
	          r0440Cell4.setCellStyle(numberStyle);


	          // ====================== R0450 ======================
	          int colR0450 = 7;
	          Row rowR0450 = sheet.getRow(startRow + i + 44);
	          if (rowR0450 == null) rowR0450 = sheet.createRow(startRow + i + 44);

	          // Column: LFI
	          Cell r0450Cell2 = rowR0450.createCell(colR0450++);
	          r0450Cell2.setCellValue(record.getR0450_lfi() != null ? record.getR0450_lfi().doubleValue() : 0.0);
	          r0450Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0450Cell3 = rowR0450.createCell(colR0450++);
	          r0450Cell3.setCellValue(record.getR0450_evidence() != null ? record.getR0450_evidence().doubleValue() : 0.0);
	          r0450Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0450Cell4 = rowR0450.createCell(colR0450++);
	          r0450Cell4.setCellValue(record.getR0450_evidencebylfi() != null ? record.getR0450_evidencebylfi().doubleValue() : 0.0);
	          r0450Cell4.setCellStyle(numberStyle);


	          // ====================== R0460 ======================
	          int colR0460 = 7;
	          Row rowR0460 = sheet.getRow(startRow + i + 45);
	          if (rowR0460 == null) rowR0460 = sheet.createRow(startRow + i + 45);

	          // Column: LFI
	          Cell r0460Cell2 = rowR0460.createCell(colR0460++);
	          r0460Cell2.setCellValue(record.getR0460_lfi() != null ? record.getR0460_lfi().doubleValue() : 0.0);
	          r0460Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0460Cell3 = rowR0460.createCell(colR0460++);
	          r0460Cell3.setCellValue(record.getR0460_evidence() != null ? record.getR0460_evidence().doubleValue() : 0.0);
	          r0460Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0460Cell4 = rowR0460.createCell(colR0460++);
	          r0460Cell4.setCellValue(record.getR0460_evidencebylfi() != null ? record.getR0460_evidencebylfi().doubleValue() : 0.0);
	          r0460Cell4.setCellStyle(numberStyle);


	          // ====================== R0470 ======================
	          int colR0470 = 7;
	          Row rowR0470 = sheet.getRow(startRow + i + 46);
	          if (rowR0470 == null) rowR0470 = sheet.createRow(startRow + i + 46);

	          // Column: LFI
	          Cell r0470Cell2 = rowR0470.createCell(colR0470++);
	          r0470Cell2.setCellValue(record.getR0470_lfi() != null ? record.getR0470_lfi().doubleValue() : 0.0);
	          r0470Cell2.setCellStyle(numberStyle);

	          // Column: Evidence
	          Cell r0470Cell3 = rowR0470.createCell(colR0470++);
	          r0470Cell3.setCellValue(record.getR0470_evidence() != null ? record.getR0470_evidence().doubleValue() : 0.0);
	          r0470Cell3.setCellStyle(numberStyle);

	          // Column: Evidence by LFI
	          Cell r0470Cell4 = rowR0470.createCell(colR0470++);
	          r0470Cell4.setCellValue(record.getR0470_evidencebylfi() != null ? record.getR0470_evidencebylfi().doubleValue() : 0.0);
	          r0470Cell4.setCellStyle(numberStyle);

	             // Column: Ombudsman Training
					/*
					 * Cell R0150Cell19 = rowR0150.createCell(colR0150++);
					 * R0150Cell19.setCellValue(record.getR0150_to_ombudsman_training() != null ?
					 * record.getR0150_to_ombudsman_training().doubleValue() : 0.0);
					 * R0150Cell19.setCellStyle(numberStyle);
					 */
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

	
	public byte[] getBRF16_3DetailExcel(String filename, String fromdate, String todate) {
	    try {
	        logger.info("Generating Excel for BRF16_3 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF16_3Details");

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
	        List<CBUAE_BRF16_3_Detail_Entity> reportData = CBUAE_BRF16_3_Detail_Repos.getdatabydateList(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF16_3_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF16_3 — only header will be written.");
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
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF16_3_DETAIL", null, "CBUAE_BRF16_3_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF16_3 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}





}

