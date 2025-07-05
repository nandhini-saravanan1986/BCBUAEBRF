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
import com.bornfire.brf.entities.CBUAE_BRF1_1REPORT_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_1REPORT_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_1_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_1_DETAIL_Repo;


@Component
@Service
public class CBUAE_BRF1_1_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_1_ReportService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF1_1_DETAIL_Repo BRF1_1_DETAIL_Repo;
	
	@Autowired
	CBUAE_BRF1_1REPORT_Repo BRF1_1REPORT_Repo;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF1_1View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF1_1REPORT_ENTITY> T1Master = new ArrayList<CBUAE_BRF1_1REPORT_ENTITY>();
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF1_1REPORT_Repo.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/CBUAE_BRF1_1");
		
		mv.addObject("reportsummary", T1Master);
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF1_1currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF1_1_DETAIL_ENTITY> T1Dt1 = new ArrayList<CBUAE_BRF1_1_DETAIL_ENTITY>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=BRF1_1_DETAIL_Repo.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());
		mv.setViewName("BRF/CBUAE_BRF1_1");
		mv.addObject("displaymode", "Details");
		//mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportdetails",T1Dt1 );
		mv.addObject("reportmaster12", T1Dt1);
		//mv.addObject("reportmaster1", qr);
		//mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	public byte[] getBRF1_1Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		//List<RT_TradeMarketRiskData> dataList = tradeMarketRiskDataRepo.getlist();
		List<CBUAE_BRF1_1REPORT_ENTITY> dataList =BRF1_1REPORT_Repo.getdatabydateList(dateformat.parse(todate)) ;

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for Trade Market Risk report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		String templateFileName = filename+".xls";
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

			int startRow = 14;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF1_1REPORT_ENTITY record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

		
										//row15
										// Column 5: Date
										Cell cell5 = row.createCell(5);
										if (record.getR0020_AMOUNT_AED_RESIDENT() != null) {
											cell5.setCellValue(record.getR0020_AMOUNT_AED_RESIDENT().doubleValue());
											cell5.setCellStyle(numberStyle);
										} else {
											cell5.setCellValue("");
											cell5.setCellStyle(textStyle);
										}
										
										// Column 7: Date
										Cell cell7 = row.createCell(7);
										if (record.getR0020_AMOUNT_FCY_RESIDENT() != null) {
											cell7.setCellValue(record.getR0020_AMOUNT_FCY_RESIDENT().doubleValue());
											cell7.setCellStyle(numberStyle);
										} else {
											cell7.setCellValue("");
											cell7.setCellStyle(textStyle);
										}
										
										// Column 9: Date
										Cell cell9 = row.createCell(9);
										if (record.getR0020_AMOUNT_AED_NON_RESIDENT() != null) {
											cell9.setCellValue(record.getR0020_AMOUNT_AED_NON_RESIDENT().doubleValue());
											cell9.setCellStyle(numberStyle);
										} else {
											cell9.setCellValue("");
											cell9.setCellStyle(textStyle);
										}
										
										// Column 11: Date
										Cell cell11 = row.createCell(11);
										if (record.getR0020_AMOUNT_FCY_NON_RESIDENT()!= null) {
											cell11.setCellValue(record.getR0020_AMOUNT_FCY_NON_RESIDENT().doubleValue());
											cell11.setCellStyle(numberStyle);
										} else {
											cell11.setCellValue("");
											cell11.setCellStyle(textStyle);
										}
					
					
					
						//row16
						row = sheet.getRow(15);
						// Column 5: Date
						 cell5 = row.createCell(5);
						if (record.getR0030_AMOUNT_AED_RESIDENT() != null) {
							cell5.setCellValue(record.getR0030_AMOUNT_AED_RESIDENT().doubleValue());
							cell5.setCellStyle(numberStyle);
						} else {
							cell5.setCellValue("");
							cell5.setCellStyle(textStyle);
						}
						
						// Column 7: Date
						cell7 = row.createCell(7);
						if (record.getR0030_AMOUNT_FCY_RESIDENT() != null) {
							cell7.setCellValue(record.getR0030_AMOUNT_FCY_RESIDENT().doubleValue());
							cell7.setCellStyle(numberStyle);
						} else {
							cell7.setCellValue("");
							cell7.setCellStyle(textStyle);
						}
						
						// Column 9: Date
						 cell9 = row.createCell(9);
						if (record.getR0030_AMOUNT_AED_NON_RESIDENT() != null) {
							cell9.setCellValue(record.getR0030_AMOUNT_AED_NON_RESIDENT().doubleValue());
							cell9.setCellStyle(numberStyle);
						} else {
							cell9.setCellValue("");
							cell9.setCellStyle(textStyle);
						}
						
						// Column 11: Date
						cell11 = row.createCell(11);
						if (record.getR0030_AMOUNT_FCY_NON_RESIDENT()!= null) {
							cell11.setCellValue(record.getR0030_AMOUNT_FCY_NON_RESIDENT().doubleValue());
							cell11.setCellStyle(numberStyle);
						} else {
							cell11.setCellValue("");
							cell11.setCellStyle(textStyle);
						}

					
					//row17
					row = sheet.getRow(16);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0040_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0040_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0040_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0040_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0040_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0040_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0040_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0040_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					//row18
					row = sheet.getRow(17);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0050_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0050_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0050_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0050_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0050_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0050_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0050_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0050_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					//row19
					row = sheet.getRow(18);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0060_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0060_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0060_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0060_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0060_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0060_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0060_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0060_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					//row20
					row = sheet.getRow(19);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0070_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0070_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0070_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0070_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0070_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0070_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0070_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0070_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					//row21
					row = sheet.getRow(20);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0080_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0080_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0080_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0080_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0080_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0080_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0080_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0080_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					//row23
					row = sheet.getRow(22);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0100_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0100_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0100_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0100_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0100_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0100_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0100_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0100_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					//row24
					row = sheet.getRow(23);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0110_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0110_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0110_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0110_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0110_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0110_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0110_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0110_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}

					
					//row25
					row = sheet.getRow(24);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0120_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0120_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0120_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0120_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0120_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0120_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0120_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0120_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					//row27
					row = sheet.getRow(26);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0140_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0140_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0140_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0140_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0140_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0140_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0140_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0140_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					//row28
					row = sheet.getRow(27);
					// Column 5: Date
					 cell5 = row.createCell(5);
					if (record.getR0150_AMOUNT_AED_RESIDENT() != null) {
						cell5.setCellValue(record.getR0150_AMOUNT_AED_RESIDENT().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					// Column 7: Date
					cell7 = row.createCell(7);
					if (record.getR0150_AMOUNT_FCY_RESIDENT() != null) {
						cell7.setCellValue(record.getR0150_AMOUNT_FCY_RESIDENT().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					// Column 9: Date
					 cell9 = row.createCell(9);
					if (record.getR0150_AMOUNT_AED_NON_RESIDENT() != null) {
						cell9.setCellValue(record.getR0150_AMOUNT_AED_NON_RESIDENT().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					// Column 11: Date
					cell11 = row.createCell(11);
					if (record.getR0150_AMOUNT_FCY_NON_RESIDENT()!= null) {
						cell11.setCellValue(record.getR0150_AMOUNT_FCY_NON_RESIDENT().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
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
