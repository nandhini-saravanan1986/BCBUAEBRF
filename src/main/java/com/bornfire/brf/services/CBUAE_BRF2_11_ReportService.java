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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF2_11_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_11_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_11_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_11_Summary_Repo;

@Component
@Service
public class CBUAE_BRF2_11_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_11_ReportService.class);
	

	@Autowired 
	AuditService auditService;
	@Autowired
	private Environment env;
	@Autowired
	CBUAE_BRF2_11_Detail_Repo CBUAE_BRF2_11_Detail_Repos;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF2_11_Summary_Repo CBUAE_BRF2_11_Summary_Repos;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF2_11View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF2_11View");
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		
		if(type.equals("ARCHIVAL")&version!=null) {
			List<CBUAE_BRF2_11_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_11_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				 //T1Master=BRF1_1_Summary_Archival_Repo.getdatabydateListarchival(dateformat.parse(todate),version);
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF2_11_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_11_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);


				 T1Master=CBUAE_BRF2_11_Summary_Repos.getdatabydateList();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF2_11");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		mv.addObject("reportid", "BRF2_11");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	
	public ModelAndView getBRF2_11currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();
	    int totalPages=0;

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF2_11_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = CBUAE_BRF2_11_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	        	logger.info("enter else block");
	            T1Dt1 = CBUAE_BRF2_11_Detail_Repos.getdatabydateList(dateformat.parse(todate),currentPage,pageSize);
				totalPages=CBUAE_BRF2_11_Detail_Repos.getdatacount(dateformat.parse(todate));
				mv.addObject("pagination","YES");
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF2_11");
   	  	mv.addObject("currentPage", currentPage);
   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}


	
	public byte[] getBRF2_11Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
	    try {
	        List<CBUAE_BRF2_11_Summary_Entity> dataList = CBUAE_BRF2_11_Summary_Repos.getdatabydateList();

	        if (dataList.isEmpty()) {
	            logger.warn("No data found for BRF2.11 report.");
	            return new byte[0];
	        }

	        String templateDir = env.getProperty("output.exportpathtemp");
	        Path templatePath = Paths.get(templateDir, filename);

	        if (!Files.exists(templatePath)) throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
	        if (!Files.isReadable(templatePath)) throw new SecurityException("Template file is not readable: " + templatePath.toAbsolutePath());

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

	            CellStyle numberStyle = workbook.createCellStyle();
	            numberStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));

	            int startRow = 12;
	            int startCol = 3;

	            // Initialize totals
	            BigDecimal totalDueFromPlacements = BigDecimal.ZERO;
	            BigDecimal totalDueToBorrowing = BigDecimal.ZERO;
	            BigDecimal totalDueFromRemaining = BigDecimal.ZERO;
	            BigDecimal totalDueToBRemaining = BigDecimal.ZERO;

	            for (int i = 0; i < dataList.size(); i++) {
	                CBUAE_BRF2_11_Summary_Entity record = dataList.get(i);
	                Row row = sheet.getRow(startRow + i);
	                if (row == null) row = sheet.createRow(startRow + i);

	                // Column B - Serial Number
	                Cell serialCell = row.createCell(1);
	                serialCell.setCellValue(String.format("%04d", (i + 1) * 10));
	                serialCell.setCellStyle(centerStyle);

	                // Column C - ID
	                row.createCell(2).setCellValue(record.getId());

	                // Column D - Country Party
	                Cell c3 = row.createCell(3);
	                c3.setCellValue(record.getCountry_party());
	                c3.setCellStyle(leftStyle);

	                // Column E - Branch
	                Cell c4 = row.createCell(4);
	                c4.setCellValue(record.getBranch());
	                c4.setCellStyle(leftStyle);

	                // Column F - Head Office
	                Cell c5 = row.createCell(5);
	                c5.setCellValue(record.getHead_office());
	                c5.setCellStyle(leftStyle);

	                // Column G to J - Numeric values
	                BigDecimal val6 = record.getDue_from_placements();
	                BigDecimal val7 = record.getDue_to_borrowing();
	                BigDecimal val8 = record.getDue_from_remaining();
	                BigDecimal val9 = record.getDue_to_remaining();

	                row.createCell(6).setCellValue(getDouble(val6));
	                row.getCell(6).setCellStyle(numberStyle);

	                row.createCell(7).setCellValue(getDouble(val7));
	                row.getCell(7).setCellStyle(numberStyle);

	                row.createCell(8).setCellValue(getDouble(val8));
	                row.getCell(8).setCellStyle(numberStyle);

	                row.createCell(9).setCellValue(getDouble(val9));
	                row.getCell(9).setCellStyle(numberStyle);

	                // Add to totals
	                totalDueFromPlacements = totalDueFromPlacements.add(val6 != null ? val6 : BigDecimal.ZERO);
	                totalDueToBorrowing = totalDueToBorrowing.add(val7 != null ? val7 : BigDecimal.ZERO);
	                totalDueFromRemaining = totalDueFromRemaining.add(val8 != null ? val8 : BigDecimal.ZERO);
	                totalDueToBRemaining = totalDueToBRemaining.add(val9 != null ? val9 : BigDecimal.ZERO);
	            }

	         // Total row
	            int totalRowNum = startRow + dataList.size();
	            Row totalRow = sheet.getRow(totalRowNum);
	            if (totalRow == null) totalRow = sheet.createRow(totalRowNum);

	            // Column E or F - Add "Total" label
	            Cell totalLabelCell = totalRow.createCell(5); // Column F
	            totalLabelCell.setCellValue("Total");
	            totalLabelCell.setCellStyle(leftStyle);

	            totalRow.createCell(6).setCellValue(totalDueFromPlacements.doubleValue());
	            totalRow.getCell(6).setCellStyle(numberStyle);

	            totalRow.createCell(7).setCellValue(totalDueToBorrowing.doubleValue());
	            totalRow.getCell(7).setCellStyle(numberStyle);

	            totalRow.createCell(8).setCellValue(totalDueFromRemaining.doubleValue());
	            totalRow.getCell(8).setCellStyle(numberStyle);

	            totalRow.createCell(9).setCellValue(totalDueToBRemaining.doubleValue());
	            totalRow.getCell(9).setCellStyle(numberStyle);

	            workbook.write(out);
	            return out.toByteArray();
	        }

	    } catch (Exception e) {
	        logger.error("Error generating BRF2.11 Excel file", e);
	        throw e;
	    }
	}

	private double getDouble(BigDecimal value) {
	    return value != null ? value.doubleValue() : 0.0;
	}

	
	
	public byte[] getBRF2_11DetailExcel(String filename, String fromdate, String todate) {
	    try {
	        logger.info("Generating Excel for BRF2.11 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF2_11Details");

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
	        List<CBUAE_BRF2_11_Detail_Entity> reportData = CBUAE_BRF2_11_Detail_Repos.getListbydate(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF2_11_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF2_11 — only header will be written.");
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
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF2_11_DETAIL", null, "CBUAE_BRF2_11_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF2_11 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}



}
