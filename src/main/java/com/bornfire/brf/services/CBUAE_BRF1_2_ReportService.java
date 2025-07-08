package com.bornfire.brf.services;


import org.springframework.web.servlet.ModelAndView;


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

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

import com.bornfire.brf.controllers.CBUAE_BRF_ReportsController;


import com.bornfire.brf.entities.CBUAE_BRF1_2_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_2_DETAIL_REPO;
import com.bornfire.brf.entities.CBUAE_BRF1_2_SUMMARY_REPO1;
import com.bornfire.brf.entities.CBUAE_BRF1_2_SUMMARY_REPO2;
import com.bornfire.brf.entities.CBUAE_BRF1_2_SUMMARY_ENTITY1;
import com.bornfire.brf.entities.CBUAE_BRF1_2_SUMMARY_ENTITY2;



@Component
@Service

public class CBUAE_BRF1_2_ReportService {
	
	

	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_1_ReportService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF1_2_DETAIL_REPO CBUAE_BRF1_2_DETAIL_REPO;
	
	@Autowired
	CBUAE_BRF1_2_SUMMARY_REPO1 CBUAE_BRF1_2_REPORT_REPO1;
	
	@Autowired
	CBUAE_BRF1_2_SUMMARY_REPO2 CBUAE_BRF1_2_REPORT_REPO2;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF1_2View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF1_2_SUMMARY_ENTITY1> T1Master = new ArrayList<CBUAE_BRF1_2_SUMMARY_ENTITY1>();
		List<CBUAE_BRF1_2_SUMMARY_ENTITY2> T1Master1 = new ArrayList<CBUAE_BRF1_2_SUMMARY_ENTITY2>();
		try {
			Date d1 = dateformat.parse(todate);
			
		 

		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		mv.setViewName("BRF/BRF1_2");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF1_2currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF1_2_DETAIL_ENTITY> T1Dt1 = new ArrayList<CBUAE_BRF1_2_DETAIL_ENTITY>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=CBUAE_BRF1_2_DETAIL_REPO.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		
		mv.setViewName("BRF/BRF1_2");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportdetails",T1Dt1 );
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}


	public byte[] getBRF1_2Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF1_2_SUMMARY_ENTITY1> dataList = CBUAE_BRF1_2_REPORT_REPO1.getdatabydateList(dateformat.parse(todate)) ;

	
		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for Trade Market Risk report. Returning empty result.");
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
			font.setFontHeightInPoints((short)8); // size 8
			font.setFontName("Arial");    

			CellStyle numberStyle = workbook.createCellStyle();
			//numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 12;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {

					CBUAE_BRF1_2_SUMMARY_ENTITY1 record = dataList.get(i);

					

					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}


		/////ROW13///////////
										//row13
										// Column E: 
										Cell cell4 = row.createCell(4);
										if (record.getR0020_no_acct_aed_resident() != null) {
											cell4.setCellValue(record.getR0020_no_acct_aed_resident().doubleValue());
											cell4.setCellStyle(numberStyle);
										} else {
											cell4.setCellValue("");
											cell4.setCellStyle(textStyle);
										}
										
										//row13
										// Column F: 
										Cell cell5 = row.createCell(5);
										if (record.getR0020_amount_aed_resident() != null) {
											cell5.setCellValue(record.getR0020_amount_aed_resident().doubleValue());
											cell5.setCellStyle(numberStyle);
										} else {
											cell5.setCellValue("");
											cell5.setCellStyle(textStyle);
										}


										
										//row13
										// Column G: 
										Cell cell6 = row.createCell(6);
										if (record.getR0020_no_acct_fcy_resident() != null) {
											cell6.setCellValue(record.getR0020_no_acct_fcy_resident().doubleValue());
											cell6.setCellStyle(numberStyle);
										} else {
											cell6.setCellValue("");
											cell6.setCellStyle(textStyle);
										}
										
										//row13
										// Column H: 
										Cell cell7 = row.createCell(7);
										if (record.getR0020_amount_fcy_resident() != null) {
											cell7.setCellValue(record.getR0020_amount_fcy_resident().doubleValue());
											cell7.setCellStyle(numberStyle);
										} else {
											cell7.setCellValue("");
											cell7.setCellStyle(textStyle);
										}
										
										//row13
										// Column I: 
										Cell cell8 = row.createCell(8);
										if (record.getR0020_no_acct_aed_non_resident() != null) {
											cell8.setCellValue(record.getR0020_no_acct_aed_non_resident().doubleValue());
											cell8.setCellStyle(numberStyle);
										} else {
											cell8.setCellValue("");
											cell8.setCellStyle(textStyle);
										}
										
										//row13
										// Column J: 
										Cell cell9 = row.createCell(9);
										if (record.getR0020_amount_aed_non_resident() != null) {
											cell9.setCellValue(record.getR0020_amount_aed_non_resident().doubleValue());
											cell9.setCellStyle(numberStyle);
										} else {
											cell9.setCellValue("");
											cell9.setCellStyle(textStyle);
										}
										
										
										//row13
										// Column K: 
										Cell cell10 = row.createCell(10);
										if (record.getR0020_no_acct_fcy_non_resident() != null) {
											cell10.setCellValue(record.getR0020_no_acct_fcy_non_resident().doubleValue());
											cell10.setCellStyle(numberStyle);
										} else {
											cell10.setCellValue("");
											cell10.setCellStyle(textStyle);
										}
										
										//row13
										// Column L: 
										Cell cell11 = row.createCell(11);
										if (record.getR0020_amount_fcy_non_resident() != null) {
											cell11.setCellValue(record.getR0020_amount_fcy_non_resident().doubleValue());
											cell11.setCellStyle(numberStyle);
										} else {
											cell11.setCellValue("");
											cell11.setCellStyle(textStyle);
										}
										
										
										
									/////ROW14///////////
										//row14
										// Column E: 
									
										row = sheet.getRow(13);
										Cell R1cell4 = row.createCell(4);
										if (record.getR0030_no_acct_aed_resident() != null) {
											R1cell4.setCellValue(record.getR0030_no_acct_aed_resident().doubleValue());
											R1cell4.setCellStyle(numberStyle);
										} else {
											R1cell4.setCellValue("");
											R1cell4.setCellStyle(textStyle);
										}
										
										//row14
										// Column F: 
										Cell R1cell5 = row.createCell(5);
										if (record.getR0030_amount_aed_resident() != null) {
											R1cell5.setCellValue(record.getR0030_amount_aed_resident().doubleValue());
											R1cell5.setCellStyle(numberStyle);
										} else {
											R1cell5.setCellValue("");
											R1cell5.setCellStyle(textStyle);
										}
										
										//row14
										// Column G: 
										Cell R1cell6 = row.createCell(6);
										if (record.getR0030_no_acct_fcy_resident() != null) {
											R1cell6.setCellValue(record.getR0030_no_acct_fcy_resident().doubleValue());
											R1cell6.setCellStyle(numberStyle);
										} else {
											R1cell6.setCellValue("");
											R1cell6.setCellStyle(textStyle);
										}
										
										//row14
										// Column H: 
										Cell R1cell7 = row.createCell(7);
										if (record.getR0030_amount_fcy_resident() != null) {
											R1cell7.setCellValue(record.getR0030_amount_fcy_resident().doubleValue());
											R1cell7.setCellStyle(numberStyle);
										} else {
											cell7.setCellValue("");
											cell7.setCellStyle(textStyle);
										}
										
										//row14
										// Column I: 
										Cell R1cell8 = row.createCell(8);
										if (record.getR0030_no_acct_aed_non_resident() != null) {
											R1cell8.setCellValue(record.getR0030_no_acct_aed_non_resident().doubleValue());
											R1cell8.setCellStyle(numberStyle);
										} else {
											cell8.setCellValue("");
											cell8.setCellStyle(textStyle);
										}
										
										//row14
										// Column J: 
										Cell R1cell9 = row.createCell(9);
										if (record.getR0030_amount_aed_non_resident() != null) {
											R1cell9.setCellValue(record.getR0030_amount_aed_non_resident().doubleValue());
											R1cell9.setCellStyle(numberStyle);
										} else {
											cell9.setCellValue("");
											cell9.setCellStyle(textStyle);
										}
										
										
										//row14
										// Column K: 
										Cell R1cell10 = row.createCell(10);
										if (record.getR0030_no_acct_fcy_non_resident() != null) {
											R1cell10.setCellValue(record.getR0030_no_acct_fcy_non_resident().doubleValue());
											R1cell10.setCellStyle(numberStyle);
										} else {
											R1cell10.setCellValue("");
											R1cell10.setCellStyle(textStyle);
										}
										
										//row14
										// Column L: 
										Cell R1cell11 = row.createCell(11);
										if (record.getR0030_amount_fcy_non_resident() != null) {
											R1cell11.setCellValue(record.getR0030_amount_fcy_non_resident().doubleValue());
											R1cell11.setCellStyle(numberStyle);
										} else {
											R1cell11.setCellValue("");
											R1cell11.setCellStyle(textStyle);
										}
										
										
									/////ROW15///////////
										//row15
										// Column E: 
									
										row = sheet.getRow(14);
										Cell R2cell4 = row.createCell(4);
										if (record.getR0040_no_acct_aed_resident() != null) {
											R2cell4.setCellValue(record.getR0040_no_acct_aed_resident().doubleValue());
											R2cell4.setCellStyle(numberStyle);
										} else {
											R2cell4.setCellValue("");
											R2cell4.setCellStyle(textStyle);
										}
										
										//row15
										// Column F: 
										Cell R2cell5 = row.createCell(5);
										if (record.getR0040_amount_aed_resident() != null) {
											R2cell5.setCellValue(record.getR0040_amount_aed_resident().doubleValue());
											R2cell5.setCellStyle(numberStyle);
										} else {
											R2cell5.setCellValue("");
											R2cell5.setCellStyle(textStyle);
										}
										
										//row15
										// Column G: 
										Cell R2cell6 = row.createCell(6);
										if (record.getR0040_no_acct_fcy_resident() != null) {
											R2cell6.setCellValue(record.getR0040_no_acct_fcy_resident().doubleValue());
											R2cell6.setCellStyle(numberStyle);
										} else {
											R2cell6.setCellValue("");
											R2cell6.setCellStyle(textStyle);
										}
										
										//row15
										// Column H: 
										Cell R2cell7 = row.createCell(7);
										if (record.getR0040_amount_fcy_resident() != null) {
											R2cell7.setCellValue(record.getR0040_amount_fcy_resident().doubleValue());
											R2cell7.setCellStyle(numberStyle);
										} else {
											R2cell7.setCellValue("");
											R2cell7.setCellStyle(textStyle);
										}
										
										//row15
										// Column I: 
										Cell R2cell8 = row.createCell(8);
										if (record.getR0040_no_acct_aed_non_resident() != null) {
											R2cell8.setCellValue(record.getR0040_no_acct_aed_non_resident().doubleValue());
											R2cell8.setCellStyle(numberStyle);
										} else {
											R2cell8.setCellValue("");
											R2cell8.setCellStyle(textStyle);
										}
										
										//row15
										// Column J: 
										Cell R2cell9 = row.createCell(9);
										if (record.getR0040_amount_aed_non_resident() != null) {
											R2cell9.setCellValue(record.getR0040_amount_aed_non_resident().doubleValue());
											R2cell9.setCellStyle(numberStyle);
										} else {
											R2cell9.setCellValue("");
											R2cell9.setCellStyle(textStyle);
										}
										
										
										//row15
										// Column K: 
										Cell R2cell10 = row.createCell(10);
										if (record.getR0040_no_acct_fcy_non_resident() != null) {
											R2cell10.setCellValue(record.getR0040_no_acct_fcy_non_resident().doubleValue());
											R2cell10.setCellStyle(numberStyle);
										} else {
											R2cell10.setCellValue("");
											R2cell10.setCellStyle(textStyle);
										}
										
										//row15
										// Column L: 
										Cell R2cell11 = row.createCell(11);
										if (record.getR0040_amount_fcy_non_resident() != null) {
											R2cell11.setCellValue(record.getR0040_amount_fcy_non_resident().doubleValue());
											R2cell11.setCellStyle(numberStyle);
										} else {
											R2cell11.setCellValue("");
											R2cell11.setCellStyle(textStyle);
										}
										
										
										
										/////ROW16///////////
										//row16
										// Column E: 
									
										row = sheet.getRow(15);
										Cell R3cell4 = row.createCell(4);
										if (record.getR0050_no_acct_aed_resident() != null) {
											R3cell4.setCellValue(record.getR0050_no_acct_aed_resident().doubleValue());
											R3cell4.setCellStyle(numberStyle);
										} else {
											R3cell4.setCellValue("");
											R3cell4.setCellStyle(textStyle);
										}
										
										//row16
										// Column F: 
										Cell R3cell5 = row.createCell(5);
										if (record.getR0050_amount_aed_resident() != null) {
											R3cell5.setCellValue(record.getR0050_amount_aed_resident().doubleValue());
											R3cell5.setCellStyle(numberStyle);
										} else {
											R3cell5.setCellValue("");
											R3cell5.setCellStyle(textStyle);
										}
										
										//row16
										// Column G: 
										Cell R3cell6 = row.createCell(6);
										if (record.getR0050_no_acct_fcy_resident() != null) {
											R3cell6.setCellValue(record.getR0050_no_acct_fcy_resident().doubleValue());
											R3cell6.setCellStyle(numberStyle);
										} else {
											R2cell6.setCellValue("");
											R2cell6.setCellStyle(textStyle);
										}
										
										//row16
										// Column H: 
										Cell R3cell7 = row.createCell(7);
										if (record.getR0050_amount_fcy_resident() != null) {
											R3cell7.setCellValue(record.getR0050_amount_fcy_resident().doubleValue());
											R3cell7.setCellStyle(numberStyle);
										} else {
											R3cell7.setCellValue("");
											R3cell7.setCellStyle(textStyle);
										}
										
										//row16
										// Column I: 
										Cell R3cell8 = row.createCell(8);
										if (record.getR0050_no_acct_aed_non_resident() != null) {
											R3cell8.setCellValue(record.getR0050_no_acct_aed_non_resident().doubleValue());
											R3cell8.setCellStyle(numberStyle);
										} else {
											R3cell8.setCellValue("");
											R3cell8.setCellStyle(textStyle);
										}
										
										//row16
										// Column J: 
										Cell R3cell9 = row.createCell(9);
										if (record.getR0050_amount_aed_non_resident() != null) {
											R3cell9.setCellValue(record.getR0050_amount_aed_non_resident().doubleValue());
											R3cell9.setCellStyle(numberStyle);
										} else {
											R3cell9.setCellValue("");
											R3cell9.setCellStyle(textStyle);
										}
										
										
										//row16
										// Column K: 
										Cell R3cell10 = row.createCell(10);
										if (record.getR0050_no_acct_fcy_non_resident() != null) {
											R3cell10.setCellValue(record.getR0050_no_acct_fcy_non_resident().doubleValue());
											R3cell10.setCellStyle(numberStyle);
										} else {
											R3cell10.setCellValue("");
											R3cell10.setCellStyle(textStyle);
										}
										
										//row16
										// Column L: 
										Cell R3cell11 = row.createCell(11);
										if (record.getR0050_amount_fcy_non_resident() != null) {
											R3cell11.setCellValue(record.getR0050_amount_fcy_non_resident().doubleValue());
											R3cell11.setCellStyle(numberStyle);
										} else {
											R3cell11.setCellValue("");
											R3cell11.setCellStyle(textStyle);
										}
										
										
										/////ROW18///////////
										//ROW18
										// Column E: 
																		
									row = sheet.getRow(17);
									Cell R4cell4 = row.createCell(4);
									if (record.getR0070_no_acct_aed_resident() != null) {
									R4cell4.setCellValue(record.getR0070_no_acct_aed_resident().doubleValue());
									R4cell4.setCellStyle(numberStyle);
									} else {
									R4cell4.setCellValue("");
									R4cell4.setCellStyle(textStyle);
									}

									//ROW18
									// Column F: 
									Cell R4cell5 = row.createCell(5);
									if (record.getR0070_amount_aed_resident() != null) {
									R4cell5.setCellValue(record.getR0070_amount_aed_resident().doubleValue());
									R4cell5.setCellStyle(numberStyle);
									} else {
									R4cell5.setCellValue("");
									R4cell5.setCellStyle(textStyle);
									}

									//ROW18
									// Column G: 
									Cell R4cell6 = row.createCell(6);
									if (record.getR0070_no_acct_fcy_resident() != null) {
									R4cell6.setCellValue(record.getR0070_no_acct_fcy_resident().doubleValue());
									} else {
									R4cell6.setCellValue("");
									R4cell6.setCellStyle(textStyle);
									}

									//ROW18
									// Column H: 
									Cell R4cell7 = row.createCell(7);
									if (record.getR0070_amount_fcy_resident() != null) {
									R4cell7.setCellValue(record.getR0070_amount_fcy_resident().doubleValue());
									R4cell7.setCellStyle(numberStyle);
									} else {
									R4cell7.setCellValue("");
									R4cell7.setCellStyle(textStyle);
									}
																			
									//ROW18
									// Column I: 
									Cell R4cell8 = row.createCell(8);
									if (record.getR0070_no_acct_aed_non_resident() != null) {
									R4cell8.setCellValue(record.getR0070_no_acct_aed_non_resident().doubleValue());
									R4cell8.setCellStyle(numberStyle);
									} else {
									R4cell8.setCellValue("");
									R4cell8.setCellStyle(textStyle);
									}
																			
									//ROW18
									// Column J: 
									Cell R4cell9 = row.createCell(9);
									if (record.getR0070_amount_aed_non_resident() != null) {
									R4cell9.setCellStyle(numberStyle);
									} else {
									R4cell9.setCellValue("");
									R4cell9.setCellStyle(textStyle);
									}
																			
																			
									//ROW18
									// Column K: 
									Cell R4cell10 = row.createCell(10);
									if (record.getR0070_no_acct_fcy_non_resident() != null) {
									R4cell10.setCellValue(record.getR0070_no_acct_fcy_non_resident().doubleValue());
									R4cell10.setCellStyle(numberStyle);
									} else {
									R4cell10.setCellValue("");
									R4cell10.setCellStyle(textStyle);
									}
																			
									//ROW18
									// Column L: 
									Cell R4cell11 = row.createCell(11);
									if (record.getR0070_amount_fcy_non_resident() != null) {
									R4cell11.setCellValue(record.getR0070_amount_fcy_non_resident().doubleValue());
									R4cell11.setCellStyle(numberStyle);
									} else {
									R4cell11.setCellValue("");
									R4cell11.setCellStyle(textStyle);
									}
									
									/////ROW19///////////
									//ROW19
									// Column E: 
																	
								row = sheet.getRow(18);
								Cell R5cell4 = row.createCell(4);
								if (record.getR0080_no_acct_aed_resident() != null) {
								R5cell4.setCellValue(record.getR0080_no_acct_aed_resident().doubleValue());
								R5cell4.setCellStyle(numberStyle);
								} else {
								R5cell4.setCellValue("");
								R5cell4.setCellStyle(textStyle);
								}

								//ROW19
								// Column F: 
								Cell R5cell5 = row.createCell(5);
								if (record.getR0080_amount_aed_resident() != null) {
								R5cell5.setCellValue(record.getR0080_amount_aed_resident().doubleValue());
								R5cell5.setCellStyle(numberStyle);
								} else {
								R5cell5.setCellValue("");
								R5cell5.setCellStyle(textStyle);
								}

								//ROW19
								// Column G: 
								Cell R5cell6 = row.createCell(6);
								if (record.getR0080_no_acct_fcy_resident() != null) {
								R5cell6.setCellValue(record.getR0080_no_acct_fcy_resident().doubleValue());
								} else {
								R5cell6.setCellValue("");
								R5cell6.setCellStyle(textStyle);
								}

								//ROW19
								// Column H: 
								Cell R5cell7 = row.createCell(7);
								if (record.getR0080_amount_fcy_resident() != null) {
								R5cell7.setCellValue(record.getR0080_amount_fcy_resident().doubleValue());
								R5cell7.setCellStyle(numberStyle);
								} else {
								R5cell7.setCellValue("");
								R5cell7.setCellStyle(textStyle);
								}
																		
								//ROW19
								// Column I: 
								Cell R5cell8 = row.createCell(8);
								if (record.getR0080_no_acct_aed_non_resident() != null) {
								R5cell8.setCellValue(record.getR0080_no_acct_aed_non_resident().doubleValue());
								R5cell8.setCellStyle(numberStyle);
								} else {
								R5cell8.setCellValue("");
								R5cell8.setCellStyle(textStyle);
								}
																		
								//ROW19
								// Column J: 
								Cell R5cell9 = row.createCell(9);
								if (record.getR0080_amount_aed_non_resident() != null) {
								R5cell9.setCellStyle(numberStyle);
								} else {
								R5cell9.setCellValue("");
								R5cell9.setCellStyle(textStyle);
								}
																		
																		
								//ROW19
								// Column K: 
								Cell R5cell10 = row.createCell(10);
								if (record.getR0080_no_acct_fcy_non_resident() != null) {
								R5cell10.setCellValue(record.getR0080_no_acct_fcy_non_resident().doubleValue());
								R5cell10.setCellStyle(numberStyle);
								} else {
								R5cell10.setCellValue("");
								R5cell10.setCellStyle(textStyle);
								}
																		
								//ROW19
								// Column L: 
								Cell R5cell11 = row.createCell(11);
								if (record.getR0080_amount_fcy_non_resident() != null) {
								R5cell11.setCellValue(record.getR0080_amount_fcy_non_resident().doubleValue());
								R5cell11.setCellStyle(numberStyle);
								} else {
								R5cell11.setCellValue("");
								R5cell11.setCellStyle(textStyle);
								}
								
								/////ROW20///////////
								//ROW20
								// Column E: 
																
							row = sheet.getRow(19);
							Cell R6cell4 = row.createCell(4);
							if (record.getR0090_no_acct_aed_resident() != null) {
							R6cell4.setCellValue(record.getR0090_no_acct_aed_resident().doubleValue());
							R6cell4.setCellStyle(numberStyle);
							} else {
							R6cell4.setCellValue("");
							R6cell4.setCellStyle(textStyle);
							}

							//ROW20
							// Column F: 
							Cell R6cell5 = row.createCell(5);
							if (record.getR0090_amount_aed_resident() != null) {
							R6cell5.setCellValue(record.getR0090_amount_aed_resident().doubleValue());
							R6cell5.setCellStyle(numberStyle);
							} else {
							R6cell5.setCellValue("");
							R6cell5.setCellStyle(textStyle);
							}

							//ROW20
							// Column G: 
							Cell R6cell6 = row.createCell(6);
							if (record.getR0090_no_acct_fcy_resident() != null) {
							R6cell6.setCellValue(record.getR0090_no_acct_fcy_resident().doubleValue());
							} else {
							R6cell6.setCellValue("");
							R6cell6.setCellStyle(textStyle);
							}

							//ROW20
							// Column H: 
							Cell R6cell7 = row.createCell(7);
							if (record.getR0090_amount_fcy_resident() != null) {
							R6cell7.setCellValue(record.getR0090_amount_fcy_resident().doubleValue());
							R6cell7.setCellStyle(numberStyle);
							} else {
							R6cell7.setCellValue("");
							R6cell7.setCellStyle(textStyle);
							}
																	
							//ROW20
							// Column I: 
							Cell R6cell8 = row.createCell(8);
							if (record.getR0090_no_acct_aed_non_resident() != null) {
							R6cell8.setCellValue(record.getR0090_no_acct_aed_non_resident().doubleValue());
							R6cell8.setCellStyle(numberStyle);
							} else {
							R6cell8.setCellValue("");
							R6cell8.setCellStyle(textStyle);
							}
																	
							//ROW20
							// Column J: 
							Cell R6cell9 = row.createCell(9);
							if (record.getR0090_amount_aed_non_resident() != null) {
							R6cell9.setCellStyle(numberStyle);
							} else {
							R6cell9.setCellValue("");
							R6cell9.setCellStyle(textStyle);
							}
																	
																	
							//ROW20
							// Column K: 
							Cell R6cell10 = row.createCell(10);
							if (record.getR0090_no_acct_fcy_non_resident() != null) {
							R6cell10.setCellValue(record.getR0090_no_acct_fcy_non_resident().doubleValue());
							R6cell10.setCellStyle(numberStyle);
							} else {
							R6cell10.setCellValue("");
							R6cell10.setCellStyle(textStyle);
							}
																	
							//ROW20
							// Column L: 
							Cell R6cell11 = row.createCell(11);
							if (record.getR0090_amount_fcy_non_resident() != null) {
							R6cell11.setCellValue(record.getR0090_amount_fcy_non_resident().doubleValue());
							R6cell11.setCellStyle(numberStyle);
							} else {
							R6cell11.setCellValue("");
							R6cell11.setCellStyle(textStyle);
							}
										
										
							/////ROW21///////////
							//ROW21
							// Column E: 
															
						row = sheet.getRow(20);
						Cell R7cell4 = row.createCell(4);
						if (record.getR0100_no_acct_aed_resident() != null) {
						R7cell4.setCellValue(record.getR0100_no_acct_aed_resident().doubleValue());
						R7cell4.setCellStyle(numberStyle);
						} else {
						R7cell4.setCellValue("");
						R7cell4.setCellStyle(textStyle);
						}

						//ROW21
						// Column F: 
						Cell R7cell5 = row.createCell(5);
						if (record.getR0100_amount_aed_resident() != null) {
						R7cell5.setCellValue(record.getR0100_amount_aed_resident().doubleValue());
						R7cell5.setCellStyle(numberStyle);
						} else {
						R7cell5.setCellValue("");
						R7cell5.setCellStyle(textStyle);
						}

						//ROW21
						// Column G: 
						Cell R7cell6 = row.createCell(6);
						if (record.getR0100_no_acct_fcy_resident() != null) {
						R7cell6.setCellValue(record.getR0100_no_acct_fcy_resident().doubleValue());
						} else {
						R7cell6.setCellValue("");
						R7cell6.setCellStyle(textStyle);
						}

						//ROW21
						// Column H: 
						Cell R7cell7 = row.createCell(7);
						if (record.getR0100_amount_fcy_resident() != null) {
						R7cell7.setCellValue(record.getR0100_amount_fcy_resident().doubleValue());
						R7cell7.setCellStyle(numberStyle);
						} else {
						R7cell7.setCellValue("");
						R7cell7.setCellStyle(textStyle);
						}
																
						//ROW21
						// Column I: 
						Cell R7cell8 = row.createCell(8);
						if (record.getR0100_no_acct_aed_non_resident() != null) {
						R7cell8.setCellValue(record.getR0100_no_acct_aed_non_resident().doubleValue());
						R7cell8.setCellStyle(numberStyle);
						} else {
						R7cell8.setCellValue("");
						R7cell8.setCellStyle(textStyle);
						}
																
						//ROW21
						// Column J: 
						Cell R7cell9 = row.createCell(9);
						if (record.getR0100_amount_aed_non_resident() != null) {
						R7cell9.setCellStyle(numberStyle);
						} else {
						R7cell9.setCellValue("");
						R7cell9.setCellStyle(textStyle);
						}
																
																
						//ROW21
						// Column K: 
						Cell R7cell10 = row.createCell(10);
						if (record.getR0100_no_acct_fcy_non_resident() != null) {
						R7cell10.setCellValue(record.getR0100_no_acct_fcy_non_resident().doubleValue());
						R7cell10.setCellStyle(numberStyle);
						} else {
						R7cell10.setCellValue("");
						R7cell10.setCellStyle(textStyle);
						}
																
						//ROW21
						// Column L: 
						Cell R7cell11 = row.createCell(11);
						if (record.getR0100_amount_fcy_non_resident() != null) {
						R7cell11.setCellValue(record.getR0100_amount_fcy_non_resident().doubleValue());
						R7cell11.setCellStyle(numberStyle);
						} else {
						R7cell11.setCellValue("");
						R7cell11.setCellStyle(textStyle);
						}
						
						/////ROW24///////////
						//ROW24
						// Column E: 
														
					row = sheet.getRow(23);
					Cell R8cell4 = row.createCell(4);
					if (record.getR0130_no_acct_aed_resident() != null) {
					R8cell4.setCellValue(record.getR0130_no_acct_aed_resident().doubleValue());
					R8cell4.setCellStyle(numberStyle);
					} else {
					R8cell4.setCellValue("");
					R8cell4.setCellStyle(textStyle);
					}

					//ROW24
					// Column F: 
					Cell R8cell5 = row.createCell(5);
					if (record.getR0130_amount_aed_resident() != null) {
					R8cell5.setCellValue(record.getR0130_amount_aed_resident().doubleValue());
					R8cell5.setCellStyle(numberStyle);
					} else {
					R8cell5.setCellValue("");
					R8cell5.setCellStyle(textStyle);
					}

					//ROW24
					// Column G: 
					Cell R8cell6 = row.createCell(6);
					if (record.getR0130_no_acct_fcy_resident() != null) {
					R8cell6.setCellValue(record.getR0130_no_acct_fcy_resident().doubleValue());
					} else {
					R8cell6.setCellValue("");
					R8cell6.setCellStyle(textStyle);
					}

					//ROW24
					// Column H: 
					Cell R8cell7 = row.createCell(7);
					if (record.getR0130_amount_fcy_resident() != null) {
					R8cell7.setCellValue(record.getR0130_amount_fcy_resident().doubleValue());
					R8cell7.setCellStyle(numberStyle);
					} else {
					R8cell7.setCellValue("");
					R8cell7.setCellStyle(textStyle);
					}
															
					//ROW24
					// Column I: 
					Cell R8cell8 = row.createCell(8);
					if (record.getR0130_no_acct_aed_non_resident() != null) {
					R8cell8.setCellValue(record.getR0130_no_acct_aed_non_resident().doubleValue());
					R8cell8.setCellStyle(numberStyle);
					} else {
					R8cell8.setCellValue("");
					R8cell8.setCellStyle(textStyle);
					}
															
					//ROW24
					// Column J: 
					Cell R8cell9 = row.createCell(9);
					if (record.getR0130_amount_aed_non_resident() != null) {
					R8cell9.setCellStyle(numberStyle);
					} else {
					R8cell9.setCellValue("");
					R8cell9.setCellStyle(textStyle);
					}
															
															
					//ROW24
					// Column K: 
					Cell R8cell13 = row.createCell(13);
					if (record.getR0130_no_acct_fcy_non_resident() != null) {
					R8cell13.setCellValue(record.getR0130_no_acct_fcy_non_resident().doubleValue());
					R8cell13.setCellStyle(numberStyle);
					} else {
					R8cell13.setCellValue("");
					R8cell13.setCellStyle(textStyle);
					}
															
					//ROW24
					// Column L: 
					Cell R8cell11 = row.createCell(11);
					if (record.getR0130_amount_fcy_non_resident() != null) {
					R8cell11.setCellValue(record.getR0130_amount_fcy_non_resident().doubleValue());
					R8cell11.setCellStyle(numberStyle);
					} else {
					R8cell11.setCellValue("");
					R8cell11.setCellStyle(textStyle);
					}
					
					/////ROW25///////////
					//ROW25
					// Column E: 
													
				row = sheet.getRow(24);
				Cell R9cell4 = row.createCell(4);
				if (record.getR0140_no_acct_aed_resident() != null) {
				R9cell4.setCellValue(record.getR0140_no_acct_aed_resident().doubleValue());
				R9cell4.setCellStyle(numberStyle);
				} else {
				R9cell4.setCellValue("");
				R9cell4.setCellStyle(textStyle);
				}

				//ROW25
				// Column F: 
				Cell R9cell5 = row.createCell(5);
				if (record.getR0140_amount_aed_resident() != null) {
				R9cell5.setCellValue(record.getR0140_amount_aed_resident().doubleValue());
				R9cell5.setCellStyle(numberStyle);
				} else {
				R9cell5.setCellValue("");
				R9cell5.setCellStyle(textStyle);
				}

				//ROW25
				// Column G: 
				Cell R9cell6 = row.createCell(6);
				if (record.getR0140_no_acct_fcy_resident() != null) {
				R9cell6.setCellValue(record.getR0140_no_acct_fcy_resident().doubleValue());
				} else {
				R9cell6.setCellValue("");
				R9cell6.setCellStyle(textStyle);
				}

				//ROW25
				// Column H: 
				Cell R9cell7 = row.createCell(7);
				if (record.getR0140_amount_fcy_resident() != null) {
				R9cell7.setCellValue(record.getR0140_amount_fcy_resident().doubleValue());
				R9cell7.setCellStyle(numberStyle);
				} else {
				R9cell7.setCellValue("");
				R9cell7.setCellStyle(textStyle);
				}
														
				//ROW25
				// Column I: 
				Cell R9cell8 = row.createCell(8);
				if (record.getR0140_no_acct_aed_non_resident() != null) {
				R9cell8.setCellValue(record.getR0140_no_acct_aed_non_resident().doubleValue());
				R9cell8.setCellStyle(numberStyle);
				} else {
				R9cell8.setCellValue("");
				R9cell8.setCellStyle(textStyle);
				}
														
				//ROW25
				// Column J: 
				Cell R9cell9 = row.createCell(9);
				if (record.getR0140_amount_aed_non_resident() != null) {
				R9cell9.setCellStyle(numberStyle);
				} else {
				R9cell9.setCellValue("");
				R9cell9.setCellStyle(textStyle);
				}
														
														
				//ROW25
				// Column K: 
				Cell R9cell14 = row.createCell(14);
				if (record.getR0140_no_acct_fcy_non_resident() != null) {
				R9cell14.setCellValue(record.getR0140_no_acct_fcy_non_resident().doubleValue());
				R9cell14.setCellStyle(numberStyle);
				} else {
				R9cell14.setCellValue("");
				R9cell14.setCellStyle(textStyle);
				}
														
				//ROW25
				// Column L: 
				Cell R9cell11 = row.createCell(11);
				if (record.getR0140_amount_fcy_non_resident() != null) {
				R9cell11.setCellValue(record.getR0140_amount_fcy_non_resident().doubleValue());
				R9cell11.setCellStyle(numberStyle);
				} else {
				R9cell11.setCellValue("");
				R9cell11.setCellStyle(textStyle);
				}
				
				/////ROW26///////////
				//ROW26
				// Column E: 
												
			row = sheet.getRow(25);
			Cell R10cell4 = row.createCell(4);
			if (record.getR0150_no_acct_aed_resident() != null) {
			R10cell4.setCellValue(record.getR0150_no_acct_aed_resident().doubleValue());
			R10cell4.setCellStyle(numberStyle);
			} else {
			R10cell4.setCellValue("");
			R10cell4.setCellStyle(textStyle);
			}

			//ROW26
			// Column F: 
			Cell R10cell5 = row.createCell(5);
			if (record.getR0150_amount_aed_resident() != null) {
			R10cell5.setCellValue(record.getR0150_amount_aed_resident().doubleValue());
			R10cell5.setCellStyle(numberStyle);
			} else {
			R10cell5.setCellValue("");
			R10cell5.setCellStyle(textStyle);
			}

			//ROW26
			// Column G: 
			Cell R10cell6 = row.createCell(6);
			if (record.getR0150_no_acct_fcy_resident() != null) {
			R10cell6.setCellValue(record.getR0150_no_acct_fcy_resident().doubleValue());
			} else {
			R10cell6.setCellValue("");
			R10cell6.setCellStyle(textStyle);
			}

			//ROW26
			// Column H: 
			Cell R10cell7 = row.createCell(7);
			if (record.getR0150_amount_fcy_resident() != null) {
			R10cell7.setCellValue(record.getR0150_amount_fcy_resident().doubleValue());
			R10cell7.setCellStyle(numberStyle);
			} else {
			R10cell7.setCellValue("");
			R10cell7.setCellStyle(textStyle);
			}
													
			//ROW26
			// Column I: 
			Cell R10cell8 = row.createCell(8);
			if (record.getR0150_no_acct_aed_non_resident() != null) {
			R10cell8.setCellValue(record.getR0150_no_acct_aed_non_resident().doubleValue());
			R10cell8.setCellStyle(numberStyle);
			} else {
			R10cell8.setCellValue("");
			R10cell8.setCellStyle(textStyle);
			}
													
			//ROW26
			// Column J: 
			Cell R10cell9 = row.createCell(9);
			if (record.getR0150_amount_aed_non_resident() != null) {
			R10cell9.setCellStyle(numberStyle);
			} else {
			R10cell9.setCellValue("");
			R10cell9.setCellStyle(textStyle);
			}
													
													
			//ROW26
			// Column K: 
			Cell R10cell15 = row.createCell(15);
			if (record.getR0150_no_acct_fcy_non_resident() != null) {
			R10cell15.setCellValue(record.getR0150_no_acct_fcy_non_resident().doubleValue());
			R10cell15.setCellStyle(numberStyle);
			} else {
			R10cell15.setCellValue("");
			R10cell15.setCellStyle(textStyle);
			}
													
			//ROW26
			// Column L: 
			Cell R10cell11 = row.createCell(11);
			if (record.getR0150_amount_fcy_non_resident() != null) {
			R10cell11.setCellValue(record.getR0150_amount_fcy_non_resident().doubleValue());
			R10cell11.setCellStyle(numberStyle);
			} else {
			R10cell11.setCellValue("");
			R10cell11.setCellStyle(textStyle);
			}
					
										
										
			/////ROW27///////////
			//ROW27
			// Column E: 
											
		row = sheet.getRow(26);
		Cell R11cell4 = row.createCell(4);
		if (record.getR0160_no_acct_aed_resident() != null) {
		R11cell4.setCellValue(record.getR0160_no_acct_aed_resident().doubleValue());
		R11cell4.setCellStyle(numberStyle);
		} else {
		R11cell4.setCellValue("");
		R11cell4.setCellStyle(textStyle);
		}

		//ROW27
		// Column F: 
		Cell R11cell5 = row.createCell(5);
		if (record.getR0160_amount_aed_resident() != null) {
		R11cell5.setCellValue(record.getR0160_amount_aed_resident().doubleValue());
		R11cell5.setCellStyle(numberStyle);
		} else {
		R11cell5.setCellValue("");
		R11cell5.setCellStyle(textStyle);
		}

		//ROW27
		// Column G: 
		Cell R11cell6 = row.createCell(6);
		if (record.getR0160_no_acct_fcy_resident() != null) {
		R11cell6.setCellValue(record.getR0160_no_acct_fcy_resident().doubleValue());
		} else {
		R11cell6.setCellValue("");
		R11cell6.setCellStyle(textStyle);
		}

		//ROW27
		// Column H: 
		Cell R11cell7 = row.createCell(7);
		if (record.getR0160_amount_fcy_resident() != null) {
		R11cell7.setCellValue(record.getR0160_amount_fcy_resident().doubleValue());
		R11cell7.setCellStyle(numberStyle);
		} else {
		R11cell7.setCellValue("");
		R11cell7.setCellStyle(textStyle);
		}
												
		//ROW27
		// Column I: 
		Cell R11cell8 = row.createCell(8);
		if (record.getR0160_no_acct_aed_non_resident() != null) {
		R11cell8.setCellValue(record.getR0160_no_acct_aed_non_resident().doubleValue());
		R11cell8.setCellStyle(numberStyle);
		} else {
		R11cell8.setCellValue("");
		R11cell8.setCellStyle(textStyle);
		}
												
		//ROW27
		// Column J: 
		Cell R11cell9 = row.createCell(9);
		if (record.getR0160_amount_aed_non_resident() != null) {
		R11cell9.setCellStyle(numberStyle);
		} else {
		R11cell9.setCellValue("");
		R11cell9.setCellStyle(textStyle);
		}
												
												
		//ROW27
		// Column K: 
		Cell R11cell16 = row.createCell(16);
		if (record.getR0160_no_acct_fcy_non_resident() != null) {
		R11cell16.setCellValue(record.getR0160_no_acct_fcy_non_resident().doubleValue());
		R11cell16.setCellStyle(numberStyle);
		} else {
		R11cell16.setCellValue("");
		R11cell16.setCellStyle(textStyle);
		}
												
		//ROW27
		// Column L: 
		Cell R11cell11 = row.createCell(11);
		if (record.getR0160_amount_fcy_non_resident() != null) {
		R11cell11.setCellValue(record.getR0160_amount_fcy_non_resident().doubleValue());
		R11cell11.setCellStyle(numberStyle);
		} else {
		R11cell11.setCellValue("");
		R11cell11.setCellStyle(textStyle);
		}
		
		
		/////ROW28///////////
		//ROW28
		// Column E: 
										
	row = sheet.getRow(27);
	Cell R12cell4 = row.createCell(4);
	if (record.getR0170_no_acct_aed_resident() != null) {
	R12cell4.setCellValue(record.getR0170_no_acct_aed_resident().doubleValue());
	R12cell4.setCellStyle(numberStyle);
	} else {
	R12cell4.setCellValue("");
	R12cell4.setCellStyle(textStyle);
	}

	//ROW28
	// Column F: 
	Cell R12cell5 = row.createCell(5);
	if (record.getR0170_amount_aed_resident() != null) {
	R12cell5.setCellValue(record.getR0170_amount_aed_resident().doubleValue());
	R12cell5.setCellStyle(numberStyle);
	} else {
	R12cell5.setCellValue("");
	R12cell5.setCellStyle(textStyle);
	}

	//ROW28
	// Column G: 
	Cell R12cell6 = row.createCell(6);
	if (record.getR0170_no_acct_fcy_resident() != null) {
	R12cell6.setCellValue(record.getR0170_no_acct_fcy_resident().doubleValue());
	} else {
	R12cell6.setCellValue("");
	R12cell6.setCellStyle(textStyle);
	}

	//ROW28
	// Column H: 
	Cell R12cell7 = row.createCell(7);
	if (record.getR0170_amount_fcy_resident() != null) {
	R12cell7.setCellValue(record.getR0170_amount_fcy_resident().doubleValue());
	R12cell7.setCellStyle(numberStyle);
	} else {
	R12cell7.setCellValue("");
	R12cell7.setCellStyle(textStyle);
	}
											
	//ROW28
	// Column I: 
	Cell R12cell8 = row.createCell(8);
	if (record.getR0170_no_acct_aed_non_resident() != null) {
	R12cell8.setCellValue(record.getR0170_no_acct_aed_non_resident().doubleValue());
	R12cell8.setCellStyle(numberStyle);
	} else {
	R12cell8.setCellValue("");
	R12cell8.setCellStyle(textStyle);
	}
											
	//ROW28
	// Column J: 
	Cell R12cell9 = row.createCell(9);
	if (record.getR0170_amount_aed_non_resident() != null) {
	R12cell9.setCellStyle(numberStyle);
	} else {
	R12cell9.setCellValue("");
	R12cell9.setCellStyle(textStyle);
	}
											
											
	//ROW28
	// Column K: 
	Cell R12cell17 = row.createCell(17);
	if (record.getR0170_no_acct_fcy_non_resident() != null) {
	R12cell17.setCellValue(record.getR0170_no_acct_fcy_non_resident().doubleValue());
	R12cell17.setCellStyle(numberStyle);
	} else {
	R12cell17.setCellValue("");
	R12cell17.setCellStyle(textStyle);
	}
											
	//ROW28
	// Column L: 
	Cell R12cell11 = row.createCell(11);
	if (record.getR0170_amount_fcy_non_resident() != null) {
	R12cell11.setCellValue(record.getR0170_amount_fcy_non_resident().doubleValue());
	R12cell11.setCellStyle(numberStyle);
	} else {
	R12cell11.setCellValue("");
	R12cell11.setCellStyle(textStyle);
	}
	
	/////ROW29///////////
	//ROW29
	// Column E: 
									
row = sheet.getRow(28);
Cell R13cell4 = row.createCell(4);
if (record.getR0180_no_acct_aed_resident() != null) {
R13cell4.setCellValue(record.getR0180_no_acct_aed_resident().doubleValue());
R13cell4.setCellStyle(numberStyle);
} else {
R13cell4.setCellValue("");
R13cell4.setCellStyle(textStyle);
}

//ROW29
// Column F: 
Cell R13cell5 = row.createCell(5);
if (record.getR0180_amount_aed_resident() != null) {
R13cell5.setCellValue(record.getR0180_amount_aed_resident().doubleValue());
R13cell5.setCellStyle(numberStyle);
} else {
R13cell5.setCellValue("");
R13cell5.setCellStyle(textStyle);
}

//ROW29
// Column G: 
Cell R13cell6 = row.createCell(6);
if (record.getR0180_no_acct_fcy_resident() != null) {
R13cell6.setCellValue(record.getR0180_no_acct_fcy_resident().doubleValue());
} else {
R13cell6.setCellValue("");
R13cell6.setCellStyle(textStyle);
}

//ROW29
// Column H: 
Cell R13cell7 = row.createCell(7);
if (record.getR0180_amount_fcy_resident() != null) {
R13cell7.setCellValue(record.getR0180_amount_fcy_resident().doubleValue());
R13cell7.setCellStyle(numberStyle);
} else {
R13cell7.setCellValue("");
R13cell7.setCellStyle(textStyle);
}
										
//ROW29
// Column I: 
Cell R13cell8 = row.createCell(8);
if (record.getR0180_no_acct_aed_non_resident() != null) {
R13cell8.setCellValue(record.getR0180_no_acct_aed_non_resident().doubleValue());
R13cell8.setCellStyle(numberStyle);
} else {
R13cell8.setCellValue("");
R13cell8.setCellStyle(textStyle);
}
										
//ROW29
// Column J: 
Cell R13cell9 = row.createCell(9);
if (record.getR0180_amount_aed_non_resident() != null) {
R13cell9.setCellStyle(numberStyle);
} else {
R13cell9.setCellValue("");
R13cell9.setCellStyle(textStyle);
}
										
										
//ROW29
// Column K: 
Cell R13cell18 = row.createCell(18);
if (record.getR0180_no_acct_fcy_non_resident() != null) {
R13cell18.setCellValue(record.getR0180_no_acct_fcy_non_resident().doubleValue());
R13cell18.setCellStyle(numberStyle);
} else {
R13cell18.setCellValue("");
R13cell18.setCellStyle(textStyle);
}
										
//ROW29
// Column L: 
Cell R13cell11 = row.createCell(11);
if (record.getR0180_amount_fcy_non_resident() != null) {
R13cell11.setCellValue(record.getR0180_amount_fcy_non_resident().doubleValue());
R13cell11.setCellStyle(numberStyle);
} else {
R13cell11.setCellValue("");
R13cell11.setCellStyle(textStyle);
}



										
										
										
										
										
										
										
										
				}

				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Trade Market Risk data found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

			return out.toByteArray();
		}
	}

}
