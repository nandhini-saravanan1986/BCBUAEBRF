
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
	     

	             // Column: No. of Complaints
	           

	         
	             
	             // ====== R0070 row - next row ======
	             Row rowR0070 = sheet.getRow(startRow + i + 6);
	             if (rowR0070 == null) rowR0070 = sheet.createRow(startRow + i + 6);

	             int colR0070 = 7;

	            
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
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF16_3_DETAIL", null, "CBUAE_BRF16_3_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF16_3 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}





}

