package com.bornfire.brf.services;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bornfire.brf.entities.CBUAE_BRF5_5_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Detail_Repo;

import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity3;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity4;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity5;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity6;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity7;

import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo3;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo4;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo5;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo6;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Repo7;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity3;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Summary_Entity4;
import com.bornfire.brf.entities.CBUAE_BRF5_5_Detail_Entity;


@Component
@Service
public class CBUAE_BRF5_5_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF5_5_ReportService.class);
	
	@Autowired 
	AuditService auditService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	  @Autowired 
	  CBUAE_BRF5_5_Detail_Repo BRF5_5_DETAIL_Repo;
	 
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo1 BRF5_5Summary_Repo1;
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo2 BRF5_5Summary_Repo2;
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo3 BRF5_5Summary_Repo3;
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo4 BRF5_5Summary_Repo4;
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo5 BRF5_5Summary_Repo5;
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo6 BRF5_5Summary_Repo6;
	
	@Autowired
	CBUAE_BRF5_5_Summary_Repo7 BRF5_5Summary_Repo7;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF5_5View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF5_5_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity1>();
		List<CBUAE_BRF5_5_Summary_Entity2> T2Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity2>();
		List<CBUAE_BRF5_5_Summary_Entity3> T3Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity3>();
		List<CBUAE_BRF5_5_Summary_Entity4> T4Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity4>();
		List<CBUAE_BRF5_5_Summary_Entity5> T5Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity5>();
		List<CBUAE_BRF5_5_Summary_Entity6> T6Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity6>();

		
		
		//5,6 are iterative
		List<CBUAE_BRF5_5_Summary_Entity7> T7Master = new ArrayList<CBUAE_BRF5_5_Summary_Entity7>();
		
		
		
		
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF5_5Summary_Repo1.getdatabydateList(dateformat.parse(todate));
			 
			 System.out.println("count is" + T1Master.size());
			 T2Master=BRF5_5Summary_Repo2.getdatabydateList(dateformat.parse(todate));
			
			 T3Master=BRF5_5Summary_Repo3.getdatabydateList(dateformat.parse(todate));
				
			 T4Master=BRF5_5Summary_Repo4.getdatabydateList(dateformat.parse(todate));
			 
			 T5Master=BRF5_5Summary_Repo5.getdatabydateList(dateformat.parse(todate));
			 
			 T6Master=BRF5_5Summary_Repo6.getdatabydateList(dateformat.parse(todate));

             T7Master=BRF5_5Summary_Repo7.getdatabydateList(dateformat.parse(todate));
				
			
				
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF5_5");
		

		mv.addObject("reportsummary1", T1Master);
		mv.addObject("reportsummary2", T2Master);
		mv.addObject("reportsummary3", T3Master);
		mv.addObject("reportsummary4", T4Master);
		mv.addObject("reportsummary5", T5Master);
		mv.addObject("reportsummary6", T6Master);

		mv.addObject("reportsummary7", T7Master);
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	
	public ModelAndView getBRF5_5currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();
	    int totalPages=0;

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF5_5_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = BRF5_5_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	            T1Dt1 = BRF5_5_DETAIL_Repo.getdatabydateList(d1,currentPage,pageSize);
				totalPages=BRF5_5_DETAIL_Repo.getdatacount(d1);
				mv.addObject("pagination","YES");
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF5_5");
	    mv.addObject("currentPage", currentPage);
   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}

	
	
	// DetailExcel
			public byte[] getBRF5_5DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
					String type, String version) {
				try {
					logger.info("Generating Excel for BRF5_5 Details...");
					System.out.println("came to Detail download service");
					/*
					 * if (type.equals("ARCHIVAL") & version != null) { byte[] ARCHIVALreport =
					 * getBRF5_5DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
					 * type, version); return ARCHIVALreport; }
					 */
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("BRF5_5Details");

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
					List<CBUAE_BRF5_5_Detail_Entity> reportData = BRF5_5_DETAIL_Repo.getListbydate(parsedToDate);

					if (reportData != null && !reportData.isEmpty()) {
						int rowIndex = 1;
						for (CBUAE_BRF5_5_Detail_Entity item : reportData) {
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
						logger.info("No data found for BRF5_5 — only header will be written.");
					}

					// Write to byte[]
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					workbook.write(bos);
					workbook.close();

					logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
					return bos.toByteArray();

				} catch (Exception e) {
					logger.error("Error generating BRF5_5 Excel", e);
					return new byte[0];
				}
			}
			
			public byte[] getBRF5_5Excel(String filename, String reportId, String fromdate, String todate, String currency,
			        String dtltype, String type, String version) throws Exception {

			    logger.info("Service: Starting Excel generation process in memory.");

			    List<CBUAE_BRF5_5_Summary_Entity1> dataList = BRF5_5Summary_Repo1.getdatabydateList(dateformat.parse(todate));
			    List<CBUAE_BRF5_5_Summary_Entity2> dataList2 = BRF5_5Summary_Repo2.getdatabydateList(dateformat.parse(todate));
			    List<CBUAE_BRF5_5_Summary_Entity3> dataList3 = BRF5_5Summary_Repo3.getdatabydateList(dateformat.parse(todate));
			    List<CBUAE_BRF5_5_Summary_Entity4> dataList4 = BRF5_5Summary_Repo4.getdatabydateList(dateformat.parse(todate));
			    List<CBUAE_BRF5_5_Summary_Entity5> dataList5 = BRF5_5Summary_Repo5.getdatabydateList(dateformat.parse(todate));
			    List<CBUAE_BRF5_5_Summary_Entity6> dataList6 = BRF5_5Summary_Repo6.getdatabydateList(dateformat.parse(todate));



			    if (dataList.isEmpty()) {
			        logger.warn("Service: No data found for BRF5.5 report. Returning empty result.");
			        return new byte[0];
			    }
			    if (dataList2.isEmpty()) {
			        logger.error("No data found for Entity2 - check query for date: {}", todate);
			    }
			    if (dataList3.isEmpty()) {
			        logger.error("No data found for Entity3 - check query for date: {}", todate);
			    }
			    if (dataList4.isEmpty()) {
			        logger.error("No data found for Entity4 - check query for date: {}", todate);
			    }
			    if (dataList5.isEmpty()) {
			        logger.error("No data found for Entity5 - check query for date: {}", todate);
			    }
			    if (dataList6.isEmpty()) {
			        logger.error("No data found for Entity6 - check query for date: {}", todate);
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

			        String[] rowCodesPart1 = {
			        	    "R0030", "R0040" 
			        	};
			        String[] rowCodesPart2 = {
			        	    "R0060", "R0070",
			        	    "R0080", "R0090", "R0100", "R0110", "R0120",
			        	    "R0130", "R0140", "R0150"
			        	};
			        
			        String[] rowCodesPart3 = {
			        		"R0160", "R0170",
			        	    "R0180", "R0190", "R0200", "R0210", "R0220",
			        	    "R0230", "R0240", "R0250", "R0260", 
			        	   
			        	};
			        
			        String[] rowCodesPart4 = {
			        		
			        	    "R0280", "R0290", "R0300"
			        	};
			        String[] rowCodesPart5 = {
			        		"R0310", "R0320",
			        	    "R0330", "R0340", "R0350"
			        	};
			        
			        String[] rowCodesPart6 = {
			        		  "R0370",
			        	    "R0380", "R0390", "R0400", "R0410", "R0420",
			        	    "R0430", "R0440", "R0450"
			        	};
			        String[] rowCodesPart7 = {
			        		"R0460" 
			        	   
			        	};
			        String[] rowCodesPart8 = {
			        		
			        	    "R0480", "R0490", "R0500", "R0510", "R0520",
			        	   
			        	};
			        String[] rowCodesPart9 = {
			        		 "R0540", "R0550", "R0560", "R0570",
			        	    "R0580", "R0590", "R0600"
			        	};
			        String[] rowCodesPart10 = {
			        		 "R0610", "R0620",
				        	    "R0630", "R0640", "R0650", "R0660", "R0670",
				        	    "R0680", "R0690", "R0700", "R0710", 
				        	  
			        	};

			        String[] rowCodesPart11 = {
			        	    "R0730", "R0740", "R0750"
			        	};
			        String[] rowCodesPart12 = {
			        		"R0760", "R0770","R0780"
			        	};
			      
			        String[] rowCodesPart13 = {
			        		"R0800", "R0810"
			        	};
			        
			        String[] fieldSuffixes = {
			        	    
			        	    "resident_government_private_sector_outstanding_balance",
			        	    "resident_government_private_sector_loans_stage3",
			        	    "resident_government_private_sector_stage3_provisions",
			        	    "resident_government_private_sector_provision_interest_legacy_interest",
			        	    "resident_gre_outstanding_balance",
			        	    "resident_gre_loans_stage3",
			        	    "resident_gre_stage3_provisions",
			        	    "resident_gre_provision_interest_legacy_interest",
			        	    "resident_private_sector_outstanding_balance",
			        	    "resident_private_sector_loans_stage3",
			        	    "resident_private_sector_stage3_provisions",
			        	    "resident_private_sector_provision_interest_legacy_interest",
			        	    "resident_sme_outstanding_balance",
			        	    "resident_sme_loans_stage3",
			        	    "resident_sme_stage3_provisions",
			        	    "resident_sme_provision_interest_legacy_interest",
			        	    "resident_hni_outstanding_balance",
			        	    "resident_hni_loans_stage3",
			        	    "resident_hni_stage3_provisions",
			        	    "resident_hni_provision_interest_legacy_interest",
			        	    "resident_individuals_outstanding_balance",
			        	    "resident_individuals_loans_stage3",
			        	    "resident_individuals_stage3_provisions",
			        	    "resident_individuals_provision_interest_legacy_interest",
			        	    "resident_nonbanking_financial_outstanding_balance",
			        	    "resident_nonbanking_financial_loans_stage3",
			        	    "resident_nonbanking_financial_stage3_provisions",
			        	    "resident_nonbanking_financial_provision_interest_legacy_interest",
			        	    "resident_tradebills_outstanding_balance",
			        	    "resident_tradebills_loans_stage3",
			        	    "resident_tradebills_stage3_provisions",
			        	    "resident_tradebills_provision_interest_legacy_interest",
			        	    "non_resident_government_private_sector_outstanding_balance",
			        	    "non_resident_government_private_sector_loans_stage3",
			        	    "non_resident_government_private_sector_stage3_provisions",
			        	    "non_resident_government_private_sector_provision_interest_legacy_interest",
			        	    "non_resident_gre_outstanding_balance",
			        	    "non_resident_gre_loans_stage3",
			        	    "non_resident_gre_stage3_provisions",
			        	    "non_resident_gre_provision_interest_legacy_interest",
			        	    "non_resident_private_sector_outstanding_balance",
			        	    "non_resident_private_sector_loans_stage3",
			        	    "non_resident_private_sector_stage3_provisions",
			        	    "non_resident_private_sector_provision_interest_legacy_interest",
			        	    "non_resident_sme_outstanding_balance",
			        	    "non_resident_sme_loans_stage3",
			        	    "non_resident_sme_stage3_provisions",
			        	    "non_resident_sme_provision_interest_legacy_interest",
			        	    "non_resident_hni_outstanding_balance",
			        	    "non_resident_hni_loans_stage3",
			        	    "non_resident_hni_stage3_provisions",
			        	    "non_resident_hni_provision_interest_legacy_interest",
			        	    "non_resident_individuals_outstanding_balance",
			        	    "non_resident_individuals_loans_stage3",
			        	    "non_resident_individuals_stage3_provisions",
			        	    "non_resident_individuals_provision_interest_legacy_interest",
			        	    "non_resident_nonbanking_financial_outstanding_balance",
			        	    "non_resident_nonbanking_financial_loans_stage3",
			        	    "non_resident_nonbanking_financial_stage3_provisions",
			        	    "non_resident_nonbanking_financial_provision_interest_legacy_interest",
			        	    "non_resident_tradebills_outstanding_balance",
			        	    "non_resident_tradebills_loans_stage3",
			        	    "non_resident_tradebills_stage3_provisions",
			        	    "non_resident_tradebills_provision_interest_legacy_interest"
			        	};
			        
			     // First set: ROW0010 TO R0150
					writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes, 14, numberStyle, textStyle);
					
				// Second set: ROW0160 TO R0300
					writeRowData2(sheet, dataList, rowCodesPart2, fieldSuffixes, 17, numberStyle, textStyle);
					
				// Third  set: ROW0160 TO R0260
					writeRowData3(sheet, dataList2, rowCodesPart3, fieldSuffixes, 27, numberStyle, textStyle);	
					
				// Fourth  set: ROW0270 TO R0300
					writeRowData4(sheet, dataList2, rowCodesPart4, fieldSuffixes, 39, numberStyle, textStyle);	
					
				// Fifth set: ROW0310 TO R0350
					writeRowData5(sheet, dataList3, rowCodesPart5, fieldSuffixes, 42, numberStyle, textStyle);
					
				// Sixth set: ROW0370 TO R0450
					writeRowData6(sheet, dataList3, rowCodesPart6, fieldSuffixes, 49, numberStyle, textStyle);
					
				// Seventh set: R0460
					writeRowData7(sheet, dataList4, rowCodesPart7, fieldSuffixes, 57, numberStyle, textStyle);
					
				// Eighth set: R0480 to R0520
					writeRowData8(sheet, dataList4, rowCodesPart8, fieldSuffixes, 59, numberStyle, textStyle);
					
				// Ninth set: R0540 TO R0600
					writeRowData9(sheet, dataList4, rowCodesPart9, fieldSuffixes, 65, numberStyle, textStyle);		
					
				// Ninth set: R0610 TO R0710
					writeRowData10(sheet, dataList5, rowCodesPart10, fieldSuffixes, 72, numberStyle, textStyle);
					
				// Tenth set: R0730 TO R0750
					writeRowData11(sheet, dataList5, rowCodesPart11, fieldSuffixes, 84, numberStyle, textStyle);	
					
				// Eleven set: R0760 TO R0780
					writeRowData12(sheet, dataList6, rowCodesPart12, fieldSuffixes, 87, numberStyle, textStyle);
					
				// Twelve set: R0800 TO R0810
					writeRowData13(sheet, dataList6, rowCodesPart13, fieldSuffixes, 91, numberStyle, textStyle);	
					
				


			      
			        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					workbook.write(out);
					logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
					
					return out.toByteArray();
			       

			    } 

			} 
			
			   // R0010 TO R0040 ENTITY CHANGED
			private void writeRowData1(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity1> dataList,
				        String[] rowCodes, String[] fieldSuffixes, int baseRow,
				        CellStyle numberStyle, CellStyle textStyle) {

				    logger.info("writeRowData1 - Starting with {} records", dataList.size());

				    if (dataList.isEmpty()) {
				        logger.warn("writeRowData1 - dataList is empty!");
				        return;
				    }

				    for (CBUAE_BRF5_5_Summary_Entity1 record : dataList) {
				        logger.info("Processing record: {}", record.toString());

				        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
				            String rowCode = rowCodes[rowIndex];
				            Row row = sheet.getRow(baseRow + rowIndex);
				            if (row == null) {
				                row = sheet.createRow(baseRow + rowIndex);
				                logger.info("Created new row at index {}", baseRow + rowIndex);
				            }

				            int actualColIndex = 4; 
				            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
				               
				                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
				                Cell cell = row.createCell(actualColIndex++);

				                try {
				                    Field field = CBUAE_BRF5_5_Summary_Entity1.class.getDeclaredField(fieldName);
				                    field.setAccessible(true);
				                    Object value = field.get(record);

				                    if (value instanceof BigDecimal) {
				                        cell.setCellValue(((BigDecimal) value).doubleValue());
				                        cell.setCellStyle(numberStyle);
				                        logger.debug("Set value {} for field {}", value, fieldName);
				                    } else {
				                        cell.setCellValue("");
				                        cell.setCellStyle(textStyle);
				                    }
				                } catch (NoSuchFieldException e) {
				                    logger.error("Field not found: {}", fieldName);
				                    cell.setCellValue("");
				                    cell.setCellStyle(textStyle);
				                } catch (IllegalAccessException e) {
				                    logger.error("Access error for field: {}", fieldName, e);
				                    cell.setCellValue("");
				                    cell.setCellStyle(textStyle);
				                }
				            }
				        }
				    }
				}
			// ROW0060 TO R0150 ENTITY CHANGED
						private void writeRowData2(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity1> dataList,
							        String[] rowCodes, String[] fieldSuffixes, int baseRow,
							        CellStyle numberStyle, CellStyle textStyle) {

							    logger.info("writeRowData2 - Starting with {} records", dataList.size());

							    if (dataList.isEmpty()) {
							        logger.warn("writeRowData2 - dataList is empty!");
							        return;
							    }

							    for (CBUAE_BRF5_5_Summary_Entity1 record : dataList) {
							        logger.info("Processing record: {}", record.toString());

							        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
							            String rowCode = rowCodes[rowIndex];
							            Row row = sheet.getRow(baseRow + rowIndex);
							            if (row == null) {
							                row = sheet.createRow(baseRow + rowIndex);
							                logger.info("Created new row at index {}", baseRow + rowIndex);
							            }

							            int actualColIndex = 4; 
							            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
							               
							                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
							                Cell cell = row.createCell(actualColIndex++);

							                try {
							                    Field field = CBUAE_BRF5_5_Summary_Entity1.class.getDeclaredField(fieldName);
							                    field.setAccessible(true);
							                    Object value = field.get(record);

							                    if (value instanceof BigDecimal) {
							                        cell.setCellValue(((BigDecimal) value).doubleValue());
							                        cell.setCellStyle(numberStyle);
							                        logger.debug("Set value {} for field {}", value, fieldName);
							                    } else {
							                        cell.setCellValue("");
							                        cell.setCellStyle(textStyle);
							                    }
							                } catch (NoSuchFieldException e) {
							                    logger.error("Field not found: {}", fieldName);
							                    cell.setCellValue("");
							                    cell.setCellStyle(textStyle);
							                } catch (IllegalAccessException e) {
							                    logger.error("Access error for field: {}", fieldName, e);
							                    cell.setCellValue("");
							                    cell.setCellStyle(textStyle);
							                }
							            }
							        }
							    }
							}
						
						// R0160 TO R0260 ENTITY CHANGED
						private void writeRowData3(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity2> dataList,
							        String[] rowCodes, String[] fieldSuffixes, int baseRow,
							        CellStyle numberStyle, CellStyle textStyle) {

							    logger.info("writeRowData3 - Starting with {} records", dataList.size());

							    if (dataList.isEmpty()) {
							        logger.warn("writeRowData3 - dataList is empty!");
							        return;
							    }

							    for (CBUAE_BRF5_5_Summary_Entity2 record : dataList) {
							        logger.info("Processing record: {}", record.toString());

							        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
							            String rowCode = rowCodes[rowIndex];
							            Row row = sheet.getRow(baseRow + rowIndex);
							            if (row == null) {
							                row = sheet.createRow(baseRow + rowIndex);
							                logger.info("Created new row at index {}", baseRow + rowIndex);
							            }

							            int actualColIndex = 4; 
							            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
							               
							                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
							                Cell cell = row.createCell(actualColIndex++);

							                try {
							                    Field field = CBUAE_BRF5_5_Summary_Entity2.class.getDeclaredField(fieldName);
							                    field.setAccessible(true);
							                    Object value = field.get(record);

							                    if (value instanceof BigDecimal) {
							                        cell.setCellValue(((BigDecimal) value).doubleValue());
							                        cell.setCellStyle(numberStyle);
							                        logger.debug("Set value {} for field {}", value, fieldName);
							                    } else {
							                        cell.setCellValue("");
							                        cell.setCellStyle(textStyle);
							                    }
							                } catch (NoSuchFieldException e) {
							                    logger.error("Field not found: {}", fieldName);
							                    cell.setCellValue("");
							                    cell.setCellStyle(textStyle);
							                } catch (IllegalAccessException e) {
							                    logger.error("Access error for field: {}", fieldName, e);
							                    cell.setCellValue("");
							                    cell.setCellStyle(textStyle);
							                }
							            }
							        }
							    }
							}
						// ROW0280 TO R0300 ENTITY CHANGED
									private void writeRowData4(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity2> dataList,
										        String[] rowCodes, String[] fieldSuffixes, int baseRow,
										        CellStyle numberStyle, CellStyle textStyle) {

										    logger.info("writeRowData4 - Starting with {} records", dataList.size());

										    if (dataList.isEmpty()) {
										        logger.warn("writeRowData4 - dataList is empty!");
										        return;
										    }

										    for (CBUAE_BRF5_5_Summary_Entity2 record : dataList) {
										        logger.info("Processing record: {}", record.toString());

										        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
										            String rowCode = rowCodes[rowIndex];
										            Row row = sheet.getRow(baseRow + rowIndex);
										            if (row == null) {
										                row = sheet.createRow(baseRow + rowIndex);
										                logger.info("Created new row at index {}", baseRow + rowIndex);
										            }

										            int actualColIndex = 4; 
										            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
										               
										                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
										                Cell cell = row.createCell(actualColIndex++);

										                try {
										                    Field field = CBUAE_BRF5_5_Summary_Entity2.class.getDeclaredField(fieldName);
										                    field.setAccessible(true);
										                    Object value = field.get(record);

										                    if (value instanceof BigDecimal) {
										                        cell.setCellValue(((BigDecimal) value).doubleValue());
										                        cell.setCellStyle(numberStyle);
										                        logger.debug("Set value {} for field {}", value, fieldName);
										                    } else {
										                        cell.setCellValue("");
										                        cell.setCellStyle(textStyle);
										                    }
										                } catch (NoSuchFieldException e) {
										                    logger.error("Field not found: {}", fieldName);
										                    cell.setCellValue("");
										                    cell.setCellStyle(textStyle);
										                } catch (IllegalAccessException e) {
										                    logger.error("Access error for field: {}", fieldName, e);
										                    cell.setCellValue("");
										                    cell.setCellStyle(textStyle);
										                }
										            }
										        }
										    }
										}
									
									// R0310 TO R0350 ENTITY CHANGED
									private void writeRowData5(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity3> dataList,
										        String[] rowCodes, String[] fieldSuffixes, int baseRow,
										        CellStyle numberStyle, CellStyle textStyle) {

										    logger.info("writeRowData5 - Starting with {} records", dataList.size());

										    if (dataList.isEmpty()) {
										        logger.warn("writeRowData5 - dataList is empty!");
										        return;
										    }

										    for (CBUAE_BRF5_5_Summary_Entity3 record : dataList) {
										        logger.info("Processing record: {}", record.toString());

										        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
										            String rowCode = rowCodes[rowIndex];
										            Row row = sheet.getRow(baseRow + rowIndex);
										            if (row == null) {
										                row = sheet.createRow(baseRow + rowIndex);
										                logger.info("Created new row at index {}", baseRow + rowIndex);
										            }

										            int actualColIndex = 4; 
										            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
										               
										                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
										                Cell cell = row.createCell(actualColIndex++);

										                try {
										                    Field field = CBUAE_BRF5_5_Summary_Entity3.class.getDeclaredField(fieldName);
										                    field.setAccessible(true);
										                    Object value = field.get(record);

										                    if (value instanceof BigDecimal) {
										                        cell.setCellValue(((BigDecimal) value).doubleValue());
										                        cell.setCellStyle(numberStyle);
										                        logger.debug("Set value {} for field {}", value, fieldName);
										                    } else {
										                        cell.setCellValue("");
										                        cell.setCellStyle(textStyle);
										                    }
										                } catch (NoSuchFieldException e) {
										                    logger.error("Field not found: {}", fieldName);
										                    cell.setCellValue("");
										                    cell.setCellStyle(textStyle);
										                } catch (IllegalAccessException e) {
										                    logger.error("Access error for field: {}", fieldName, e);
										                    cell.setCellValue("");
										                    cell.setCellStyle(textStyle);
										                }
										            }
										        }
										    }
										}
									// ROW0370 TO R0450 ENTITY CHANGED
												private void writeRowData6(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity3> dataList,
													        String[] rowCodes, String[] fieldSuffixes, int baseRow,
													        CellStyle numberStyle, CellStyle textStyle) {

													    logger.info("writeRowData6 - Starting with {} records", dataList.size());

													    if (dataList.isEmpty()) {
													        logger.warn("writeRowData6 - dataList is empty!");
													        return;
													    }

													    for (CBUAE_BRF5_5_Summary_Entity3 record : dataList) {
													        logger.info("Processing record: {}", record.toString());

													        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
													            String rowCode = rowCodes[rowIndex];
													            Row row = sheet.getRow(baseRow + rowIndex);
													            if (row == null) {
													                row = sheet.createRow(baseRow + rowIndex);
													                logger.info("Created new row at index {}", baseRow + rowIndex);
													            }

													            int actualColIndex = 4; 
													            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
													               
													                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
													                Cell cell = row.createCell(actualColIndex++);

													                try {
													                    Field field = CBUAE_BRF5_5_Summary_Entity3.class.getDeclaredField(fieldName);
													                    field.setAccessible(true);
													                    Object value = field.get(record);

													                    if (value instanceof BigDecimal) {
													                        cell.setCellValue(((BigDecimal) value).doubleValue());
													                        cell.setCellStyle(numberStyle);
													                        logger.debug("Set value {} for field {}", value, fieldName);
													                    } else {
													                        cell.setCellValue("");
													                        cell.setCellStyle(textStyle);
													                    }
													                } catch (NoSuchFieldException e) {
													                    logger.error("Field not found: {}", fieldName);
													                    cell.setCellValue("");
													                    cell.setCellStyle(textStyle);
													                } catch (IllegalAccessException e) {
													                    logger.error("Access error for field: {}", fieldName, e);
													                    cell.setCellValue("");
													                    cell.setCellStyle(textStyle);
													                }
													            }
													        }
													    }
													}
												// R0470 ENTITY CHANGED
												private void writeRowData7(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity4> dataList,
													        String[] rowCodes, String[] fieldSuffixes, int baseRow,
													        CellStyle numberStyle, CellStyle textStyle) {

													    logger.info("writeRowData7 - Starting with {} records", dataList.size());

													    if (dataList.isEmpty()) {
													        logger.warn("writeRowData7 - dataList is empty!");
													        return;
													    }

													    for (CBUAE_BRF5_5_Summary_Entity4 record : dataList) {
													        logger.info("Processing record: {}", record.toString());

													        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
													            String rowCode = rowCodes[rowIndex];
													            Row row = sheet.getRow(baseRow + rowIndex);
													            if (row == null) {
													                row = sheet.createRow(baseRow + rowIndex);
													                logger.info("Created new row at index {}", baseRow + rowIndex);
													            }

													            int actualColIndex = 4; 
													            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
													               
													                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
													                Cell cell = row.createCell(actualColIndex++);

													                try {
													                    Field field = CBUAE_BRF5_5_Summary_Entity4.class.getDeclaredField(fieldName);
													                    field.setAccessible(true);
													                    Object value = field.get(record);

													                    if (value instanceof BigDecimal) {
													                        cell.setCellValue(((BigDecimal) value).doubleValue());
													                        cell.setCellStyle(numberStyle);
													                        logger.debug("Set value {} for field {}", value, fieldName);
													                    } else {
													                        cell.setCellValue("");
													                        cell.setCellStyle(textStyle);
													                    }
													                } catch (NoSuchFieldException e) {
													                    logger.error("Field not found: {}", fieldName);
													                    cell.setCellValue("");
													                    cell.setCellStyle(textStyle);
													                } catch (IllegalAccessException e) {
													                    logger.error("Access error for field: {}", fieldName, e);
													                    cell.setCellValue("");
													                    cell.setCellStyle(textStyle);
													                }
													            }
													        }
													    }
													}
												// ROW0480 TO R0520 ENTITY CHANGED
															private void writeRowData8(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity4> dataList,
																        String[] rowCodes, String[] fieldSuffixes, int baseRow,
																        CellStyle numberStyle, CellStyle textStyle) {

																    logger.info("writeRowData8 - Starting with {} records", dataList.size());

																    if (dataList.isEmpty()) {
																        logger.warn("writeRowData8 - dataList is empty!");
																        return;
																    }

																    for (CBUAE_BRF5_5_Summary_Entity4 record : dataList) {
																        logger.info("Processing record: {}", record.toString());

																        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
																            String rowCode = rowCodes[rowIndex];
																            Row row = sheet.getRow(baseRow + rowIndex);
																            if (row == null) {
																                row = sheet.createRow(baseRow + rowIndex);
																                logger.info("Created new row at index {}", baseRow + rowIndex);
																            }

																            int actualColIndex = 4; 
																            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
																               
																                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
																                Cell cell = row.createCell(actualColIndex++);

																                try {
																                    Field field = CBUAE_BRF5_5_Summary_Entity4.class.getDeclaredField(fieldName);
																                    field.setAccessible(true);
																                    Object value = field.get(record);

																                    if (value instanceof BigDecimal) {
																                        cell.setCellValue(((BigDecimal) value).doubleValue());
																                        cell.setCellStyle(numberStyle);
																                        logger.debug("Set value {} for field {}", value, fieldName);
																                    } else {
																                        cell.setCellValue("");
																                        cell.setCellStyle(textStyle);
																                    }
																                } catch (NoSuchFieldException e) {
																                    logger.error("Field not found: {}", fieldName);
																                    cell.setCellValue("");
																                    cell.setCellStyle(textStyle);
																                } catch (IllegalAccessException e) {
																                    logger.error("Access error for field: {}", fieldName, e);
																                    cell.setCellValue("");
																                    cell.setCellStyle(textStyle);
																                }
																            }
																        }
																    }
																}
															// ROW0540 TO R0600 ENTITY CHANGED
															private void writeRowData9(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity4> dataList,
																        String[] rowCodes, String[] fieldSuffixes, int baseRow,
																        CellStyle numberStyle, CellStyle textStyle) {

																    logger.info("writeRowData9 - Starting with {} records", dataList.size());

																    if (dataList.isEmpty()) {
																        logger.warn("writeRowData9 - dataList is empty!");
																        return;
																    }

																    for (CBUAE_BRF5_5_Summary_Entity4 record : dataList) {
																        logger.info("Processing record: {}", record.toString());

																        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
																            String rowCode = rowCodes[rowIndex];
																            Row row = sheet.getRow(baseRow + rowIndex);
																            if (row == null) {
																                row = sheet.createRow(baseRow + rowIndex);
																                logger.info("Created new row at index {}", baseRow + rowIndex);
																            }

																            int actualColIndex = 4; 
																            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
																               
																                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
																                Cell cell = row.createCell(actualColIndex++);

																                try {
																                    Field field = CBUAE_BRF5_5_Summary_Entity4.class.getDeclaredField(fieldName);
																                    field.setAccessible(true);
																                    Object value = field.get(record);

																                    if (value instanceof BigDecimal) {
																                        cell.setCellValue(((BigDecimal) value).doubleValue());
																                        cell.setCellStyle(numberStyle);
																                        logger.debug("Set value {} for field {}", value, fieldName);
																                    } else {
																                        cell.setCellValue("");
																                        cell.setCellStyle(textStyle);
																                    }
																                } catch (NoSuchFieldException e) {
																                    logger.error("Field not found: {}", fieldName);
																                    cell.setCellValue("");
																                    cell.setCellStyle(textStyle);
																                } catch (IllegalAccessException e) {
																                    logger.error("Access error for field: {}", fieldName, e);
																                    cell.setCellValue("");
																                    cell.setCellStyle(textStyle);
																                }
																            }
																        }
																    }
																}
															
															// R0610 t R0710 ENTITY CHANGED
															private void writeRowData10(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity5> dataList,
																        String[] rowCodes, String[] fieldSuffixes, int baseRow,
																        CellStyle numberStyle, CellStyle textStyle) {

																    logger.info("writeRowData10 - Starting with {} records", dataList.size());

																    if (dataList.isEmpty()) {
																        logger.warn("writeRowData10 - dataList is empty!");
																        return;
																    }

																    for (CBUAE_BRF5_5_Summary_Entity5 record : dataList) {
																        logger.info("Processing record: {}", record.toString());

																        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
																            String rowCode = rowCodes[rowIndex];
																            Row row = sheet.getRow(baseRow + rowIndex);
																            if (row == null) {
																                row = sheet.createRow(baseRow + rowIndex);
																                logger.info("Created new row at index {}", baseRow + rowIndex);
																            }

																            int actualColIndex = 4; 
																            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
																               
																                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
																                Cell cell = row.createCell(actualColIndex++);

																                try {
																                    Field field = CBUAE_BRF5_5_Summary_Entity5.class.getDeclaredField(fieldName);
																                    field.setAccessible(true);
																                    Object value = field.get(record);

																                    if (value instanceof BigDecimal) {
																                        cell.setCellValue(((BigDecimal) value).doubleValue());
																                        cell.setCellStyle(numberStyle);
																                        logger.debug("Set value {} for field {}", value, fieldName);
																                    } else {
																                        cell.setCellValue("");
																                        cell.setCellStyle(textStyle);
																                    }
																                } catch (NoSuchFieldException e) {
																                    logger.error("Field not found: {}", fieldName);
																                    cell.setCellValue("");
																                    cell.setCellStyle(textStyle);
																                } catch (IllegalAccessException e) {
																                    logger.error("Access error for field: {}", fieldName, e);
																                    cell.setCellValue("");
																                    cell.setCellStyle(textStyle);
																                }
																            }
																        }
																    }
																}
															// ROW0730 TO R0750 ENTITY CHANGED
																		private void writeRowData11(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity5> dataList,
																			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
																			        CellStyle numberStyle, CellStyle textStyle) {

																			    logger.info("writeRowData11 - Starting with {} records", dataList.size());

																			    if (dataList.isEmpty()) {
																			        logger.warn("writeRowData11 - dataList is empty!");
																			        return;
																			    }

																			    for (CBUAE_BRF5_5_Summary_Entity5 record : dataList) {
																			        logger.info("Processing record: {}", record.toString());

																			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
																			            String rowCode = rowCodes[rowIndex];
																			            Row row = sheet.getRow(baseRow + rowIndex);
																			            if (row == null) {
																			                row = sheet.createRow(baseRow + rowIndex);
																			                logger.info("Created new row at index {}", baseRow + rowIndex);
																			            }

																			            int actualColIndex = 4; 
																			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
																			               
																			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
																			                Cell cell = row.createCell(actualColIndex++);

																			                try {
																			                    Field field = CBUAE_BRF5_5_Summary_Entity5.class.getDeclaredField(fieldName);
																			                    field.setAccessible(true);
																			                    Object value = field.get(record);

																			                    if (value instanceof BigDecimal) {
																			                        cell.setCellValue(((BigDecimal) value).doubleValue());
																			                        cell.setCellStyle(numberStyle);
																			                        logger.debug("Set value {} for field {}", value, fieldName);
																			                    } else {
																			                        cell.setCellValue("");
																			                        cell.setCellStyle(textStyle);
																			                    }
																			                } catch (NoSuchFieldException e) {
																			                    logger.error("Field not found: {}", fieldName);
																			                    cell.setCellValue("");
																			                    cell.setCellStyle(textStyle);
																			                } catch (IllegalAccessException e) {
																			                    logger.error("Access error for field: {}", fieldName, e);
																			                    cell.setCellValue("");
																			                    cell.setCellStyle(textStyle);
																			                }
																			            }
																			        }
																			    }
																			}
																		
																		// R0760 t R0780 ENTITY CHANGED
																		private void writeRowData12(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity6> dataList,
																			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
																			        CellStyle numberStyle, CellStyle textStyle) {

																			    logger.info("writeRowData12 - Starting with {} records", dataList.size());

																			    if (dataList.isEmpty()) {
																			        logger.warn("writeRowData12 - dataList is empty!");
																			        return;
																			    }

																			    for (CBUAE_BRF5_5_Summary_Entity6 record : dataList) {
																			        logger.info("Processing record: {}", record.toString());

																			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
																			            String rowCode = rowCodes[rowIndex];
																			            Row row = sheet.getRow(baseRow + rowIndex);
																			            if (row == null) {
																			                row = sheet.createRow(baseRow + rowIndex);
																			                logger.info("Created new row at index {}", baseRow + rowIndex);
																			            }

																			            int actualColIndex = 4; 
																			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
																			               
																			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
																			                Cell cell = row.createCell(actualColIndex++);

																			                try {
																			                    Field field = CBUAE_BRF5_5_Summary_Entity6.class.getDeclaredField(fieldName);
																			                    field.setAccessible(true);
																			                    Object value = field.get(record);

																			                    if (value instanceof BigDecimal) {
																			                        cell.setCellValue(((BigDecimal) value).doubleValue());
																			                        cell.setCellStyle(numberStyle);
																			                        logger.debug("Set value {} for field {}", value, fieldName);
																			                    } else {
																			                        cell.setCellValue("");
																			                        cell.setCellStyle(textStyle);
																			                    }
																			                } catch (NoSuchFieldException e) {
																			                    logger.error("Field not found: {}", fieldName);
																			                    cell.setCellValue("");
																			                    cell.setCellStyle(textStyle);
																			                } catch (IllegalAccessException e) {
																			                    logger.error("Access error for field: {}", fieldName, e);
																			                    cell.setCellValue("");
																			                    cell.setCellStyle(textStyle);
																			                }
																			            }
																			        }
																			    }
																			}
																		// ROW0800 TO R0810 ENTITY CHANGED
																					private void writeRowData13(Sheet sheet, List<CBUAE_BRF5_5_Summary_Entity6> dataList,
																						        String[] rowCodes, String[] fieldSuffixes, int baseRow,
																						        CellStyle numberStyle, CellStyle textStyle) {

																						    logger.info("writeRowData13 - Starting with {} records", dataList.size());

																						    if (dataList.isEmpty()) {
																						        logger.warn("writeRowData13 - dataList is empty!");
																						        return;
																						    }

																						    for (CBUAE_BRF5_5_Summary_Entity6 record : dataList) {
																						        logger.info("Processing record: {}", record.toString());

																						        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
																						            String rowCode = rowCodes[rowIndex];
																						            Row row = sheet.getRow(baseRow + rowIndex);
																						            if (row == null) {
																						                row = sheet.createRow(baseRow + rowIndex);
																						                logger.info("Created new row at index {}", baseRow + rowIndex);
																						            }

																						            int actualColIndex = 4; 
																						            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
																						               
																						                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
																						                Cell cell = row.createCell(actualColIndex++);

																						                try {
																						                    Field field = CBUAE_BRF5_5_Summary_Entity6.class.getDeclaredField(fieldName);
																						                    field.setAccessible(true);
																						                    Object value = field.get(record);

																						                    if (value instanceof BigDecimal) {
																						                        cell.setCellValue(((BigDecimal) value).doubleValue());
																						                        cell.setCellStyle(numberStyle);
																						                        logger.debug("Set value {} for field {}", value, fieldName);
																						                    } else {
																						                        cell.setCellValue("");
																						                        cell.setCellStyle(textStyle);
																						                    }
																						                } catch (NoSuchFieldException e) {
																						                    logger.error("Field not found: {}", fieldName);
																						                    cell.setCellValue("");
																						                    cell.setCellStyle(textStyle);
																						                } catch (IllegalAccessException e) {
																						                    logger.error("Access error for field: {}", fieldName, e);
																						                    cell.setCellValue("");
																						                    cell.setCellStyle(textStyle);
																						                }
																						            }
																						        }
																						    }
																						}
																					
												
									
						
						 
			   
}

