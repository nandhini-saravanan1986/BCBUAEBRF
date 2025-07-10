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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF2_5_SUMMARY_ENTITY1;
import com.bornfire.brf.entities.CBUAE_BRF2_5_SUMMARY_ENTITY2;
import com.bornfire.brf.entities.CBUAE_BRF2_5_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF2_5_DETAIL_REPO;
import com.bornfire.brf.entities.CBUAE_BRF2_5_SUMMARY_REPO1;
import com.bornfire.brf.entities.CBUAE_BRF2_5_SUMMARY_REPO2;

@Component
@Service

public class CBUAE_BRF2_5_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_5_ReportService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF2_5_DETAIL_REPO CBUAE_BRF2_5_DETAIL_REPO;
	
	@Autowired
	CBUAE_BRF2_5_SUMMARY_REPO1 CBUAE_BRF2_5_SUMMARY_REPO1;
	
	@Autowired
	CBUAE_BRF2_5_SUMMARY_REPO2 CBUAE_BRF2_5_SUMMARY_REPO2;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	
	public ModelAndView getBRF2_5View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF2_5_SUMMARY_ENTITY1> T1Master = new ArrayList<CBUAE_BRF2_5_SUMMARY_ENTITY1>();
		List<CBUAE_BRF2_5_SUMMARY_ENTITY2> T1Master1 = new ArrayList<CBUAE_BRF2_5_SUMMARY_ENTITY2>();
		try {
			Date d1 = dateformat.parse(todate);
			
			 T1Master=CBUAE_BRF2_5_SUMMARY_REPO1.getdatabydateList(dateformat.parse(todate));
			 T1Master1=CBUAE_BRF2_5_SUMMARY_REPO2.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("BRF/BRF2_5");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
	    mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF2_5currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF2_5_DETAIL_ENTITY> T1Dt1 = new ArrayList<CBUAE_BRF2_5_DETAIL_ENTITY>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=CBUAE_BRF2_5_DETAIL_REPO.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		mv.setViewName("BRF/BRF2_5");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportdetails",T1Dt1 );
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	

	public byte[] getBRF2_5Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF2_5_SUMMARY_ENTITY1> dataList =CBUAE_BRF2_5_SUMMARY_REPO1.getdatabydateList(dateformat.parse(todate)) ;
		

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.3 report. Returning empty result.");
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

			int startRow = 11;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {


					CBUAE_BRF2_5_SUMMARY_ENTITY1 record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}



/////ROW12///////////
//row12
// Column E: 
Cell R0030cell4 = row.createCell(4);
if (record.getR0030_overdraft() != null) {
	R0030cell4.setCellValue(record.getR0030_overdraft().doubleValue());
	R0030cell4.setCellStyle(numberStyle);
} else {
	R0030cell4.setCellValue("");
	R0030cell4.setCellStyle(textStyle);
}


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
	}



