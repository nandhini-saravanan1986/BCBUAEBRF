
package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
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

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF5_4_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_4_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_4_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_4_Summary_Repo;


@Component
@Service
public class CBUAE_BRF5_4_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF16_5_ReportService.class);
	

	@Autowired 
	AuditService auditService;
	@Autowired
	private Environment env;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF5_4_Summary_Repo CBUAE_BRF5_4_Summary_Repos;
	@Autowired
	CBUAE_BRF5_4_Detail_Repo CBUAE_BRF5_4_Detail_Repos;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF5_4View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF5_4View...");
		ModelAndView mv = new ModelAndView();
		if(type.equals("ARCHIVAL")&version!=null) {

			logger.info("Enter if statement");
			List<CBUAE_BRF5_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF5_4_Summary_Entity>();
		
				 T1Master=CBUAE_BRF5_4_Summary_Repos.getdatabydateList();
			
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF5_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF5_4_Summary_Entity>();

			 T1Master=CBUAE_BRF5_4_Summary_Repos.getdatabydateList();

			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF5_4");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		mv.addObject("reportid", "BRF5_4");
		logger.info("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF5_4currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF5_4_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	        	logger.info("enter if block");
	            T1Dt1 = CBUAE_BRF5_4_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	        	logger.info("enter else block");
	            T1Dt1 = CBUAE_BRF5_4_Detail_Repos.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF5_4");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}
	public byte[] getBRF5_4Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {

	    try {
	        List<CBUAE_BRF5_4_Summary_Entity> dataList = CBUAE_BRF5_4_Summary_Repos.getdatabydateList();

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

	         // Create DataFormat and CellStyle for numeric values
	            DataFormat dataFormat = workbook.createDataFormat();

	            CellStyle numberStyle = workbook.createCellStyle();
	            numberStyle.setDataFormat(dataFormat.getFormat("#,##0.00")); // e.g., 1,234.56

	            int startCol = 3;     // Column D (0-based)
	            int startRow = 9;     // 10th row (0-based)
	            int notesRow = 15;    // "Notes:-" is at 16th row (Excel)

	            // Step 1: Shift "Notes:-" and below to make space for data rows
	            if (sheet.getLastRowNum() >= notesRow) {
	                sheet.shiftRows(notesRow, sheet.getLastRowNum(), dataList.size());
	            }

	            // Step 2: Write data rows before the "Notes:-"
	            for (int i = 0; i < dataList.size(); i++) {
	                CBUAE_BRF5_4_Summary_Entity record = dataList.get(i);
	                Row row = sheet.getRow(startRow + i);
	                if (row == null) row = sheet.createRow(startRow + i);

	                int col = startCol;

	                // Column B - Serial Number (starts from 0010)
	                Cell serialCell = row.createCell(1);
	                serialCell.setCellValue(String.format("%04d", (i + 1) * 10));
	                serialCell.setCellStyle(centerStyle);

	                // Column C - ID
	                row.createCell(2).setCellValue(record.getId());

	                // Column D - Name of Borrower Group
	                Cell c3 = row.createCell(3);
	                c3.setCellValue(record.getR0010_name_of_the_borrower_group());
	                c3.setCellStyle(leftStyle);

	                // Column E - CIN
	                Cell c4 = row.createCell(4);
	                c4.setCellValue(record.getR0020_cin());
	                c4.setCellStyle(leftStyle);

	                // Column F - Nature of Credit Facility
	                Cell c5 = row.createCell(5);
	                c5.setCellValue(record.getR0030_nature_of_credit_facility_granted());
	                c5.setCellStyle(leftStyle);

	                // Column G - Date of Disbursement
	                Cell c6 = row.createCell(6);
	                if (record.getR0040_date_of_disbursement() != null) {
	                    c6.setCellValue(record.getR0040_date_of_disbursement());
	                    c6.setCellStyle(dateStyle);
	                }

	                // Column H - Due Date of Repayment
	                Cell c7 = row.createCell(7);
	                if (record.getR0050_due_date_of_repayment() != null) {
	                    c7.setCellValue(record.getR0050_due_date_of_repayment());
	                    c7.setCellStyle(dateStyle);
	                }

	                // Column I - Market Value
	                Cell c8 = row.createCell(8);
	                c8.setCellValue(getDouble(record.getR0060_market_value()));
	                c8.setCellStyle(numberStyle);

	                // Column J - Drawing Power
	                Cell c9 = row.createCell(9);
	                c9.setCellValue(getDouble(record.getR0070_drawing_power()));
	                c9.setCellStyle(numberStyle);

	                // Column K - Present Outstanding
	                Cell c10 = row.createCell(10);
	                c10.setCellValue(getDouble(record.getR0080_present_outstanding()));
	                c10.setCellStyle(numberStyle);

	                // Column L - Outstanding as % of Drawing Power
	                Cell c11 = row.createCell(11);
	                c11.setCellValue(getDouble(record.getR0090_outstanding_as_of_drawing_power()));
	                c11.setCellStyle(numberStyle);

	                // Column M - Excess Over Drawing Power
	                Cell c12 = row.createCell(12);
	                c12.setCellValue(getDouble(record.getR0100_excess_over_drawing_power()));
	                c12.setCellStyle(numberStyle);

	                // Column N - FD / Bank Guarantee
	                Cell c13 = row.createCell(13);
	                c13.setCellValue(getDouble(record.getR0110_fd_bank_guarantee()));
	                c13.setCellStyle(numberStyle);

	                // Column O - Mortgage of Real Estate
	                Cell c14 = row.createCell(14);
	                c14.setCellValue(getDouble(record.getR0120_mortgage_of_real_estate()));
	                c14.setCellStyle(numberStyle);

	                // Column P - Remarks / Status
	                Cell c15 = row.createCell(15);
	                c15.setCellValue(record.getR0130_remarks_status());
	                c15.setCellStyle(leftStyle);
	                

	            }


	            workbook.write(out);
	            return out.toByteArray();
	        }

	    } catch (Exception e) {
	        logger.error("Error generating BRF5.4 Excel file", e);
	        throw e;
	    }
	}

	private double getDouble(BigDecimal value) {
	    return value != null ? value.doubleValue() : 0.0;
	}

	public byte[] getBRF5_4DetailExcel(String filename, String fromdate, String todate) {
	    try {
	        logger.info("Generating Excel for BRF5.4 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF5_4Details");

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
	        List<CBUAE_BRF5_4_Detail_Entity> reportData = CBUAE_BRF5_4_Detail_Repos.getListbydate(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF5_4_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF5_4 — only header will be written.");
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
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF5_4_DETAIL", null, "CBUAE_BRF5_4_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF5_4 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}





}
