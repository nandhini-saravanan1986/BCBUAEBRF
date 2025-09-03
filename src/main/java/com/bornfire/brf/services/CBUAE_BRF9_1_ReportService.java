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
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF9_1_Detail_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Detail_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Detail_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Detail_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF9_1_Summary_Repo2;


@Component
@Service

public class CBUAE_BRF9_1_ReportService {
private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF9_1_ReportService.class);
	


	@Autowired
	private Environment env;
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF9_1_Detail_Repo1 BRF9_1_DETAIL_Repo1;
	
	@Autowired
	CBUAE_BRF9_1_Summary_Repo1 BRF9_1_Summary_Repo1;
	
	@Autowired
	CBUAE_BRF9_1_Detail_Repo2 BRF9_1_DETAIL_Repo2;
	
	@Autowired
	CBUAE_BRF9_1_Summary_Repo2 BRF9_1_Summary_Repo2;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF9_1View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF9_1_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF9_1_Summary_Entity1>();
		List<CBUAE_BRF9_1_Summary_Entity2> T1Master1 = new ArrayList<CBUAE_BRF9_1_Summary_Entity2>();
		
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF9_1_Summary_Repo1.getdatabydateList(dateformat.parse(todate));
			 T1Master1=BRF9_1_Summary_Repo2.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF9_1");
		
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF9_1currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter, String type, String version) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();
	    int totalPages=0;

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF9_1_Detail_Entity1> T1Dt1 = new ArrayList<>();
	    List<CBUAE_BRF9_1_Detail_Entity2> T1Dt2 = new ArrayList<>();

	    try {
	        Date d1 = dateformat.parse(todate);
	        Date d2 = dateformat.parse(todate);

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
	            T1Dt1 = BRF9_1_DETAIL_Repo1.GetDataByRowIdAndColumnId(rowId, columnId,  dateformat.parse(todate));
	            T1Dt2 = BRF9_1_DETAIL_Repo2.GetDataByRowIdAndColumnId(rowId, columnId,  dateformat.parse(todate));
	        } else {
	            //T1Dt1 = BRF9_1_DETAIL_Repo1.getdatabydateList(d1);
	            T1Dt1 = BRF9_1_DETAIL_Repo1.getdatabydateList(dateformat.parse(todate),currentPage,pageSize);
				totalPages=BRF9_1_DETAIL_Repo1.getdatacount(dateformat.parse(todate));
				mv.addObject("pagination","YES");
	            //T1Dt2 = BRF9_1_DETAIL_Repo2.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());
	        System.out.println("LISTCOUNT: " + T1Dt2.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF9_1");
	    mv.addObject("currentPage", currentPage);
   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportdetails1", T1Dt2);
	    //mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}
	
	
	public byte[] getBRF9_1Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF9_1_Summary_Entity1> dataList =BRF9_1_Summary_Repo1.getdatabydateList(dateformat.parse(todate)) ;

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF9.1 report. Returning empty result.");
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

			int startRow = 10;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF9_1_Summary_Entity1 record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					
					
					//row11
					// Column E 
					Cell cell4 = row.createCell(4);
					if (record.getR0020_outward_family() != null) {
						cell4.setCellValue(record.getR0020_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					Cell cell5 = row.createCell(5);
					if (record.getR0020_outward_investment() != null) {
						cell5.setCellValue(record.getR0020_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					Cell cell6 = row.createCell(6);
					if (record.getR0020_outward_trade() != null) {
						cell6.setCellValue(record.getR0020_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					Cell cell7 = row.createCell(7);
					if (record.getR0020_outward_other() != null) {
						cell7.setCellValue(record.getR0020_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					Cell cell9 = row.createCell(9);
					if (record.getR0020_inward_family() != null) {
						cell9.setCellValue(record.getR0020_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					Cell cell10 = row.createCell(10);
					if (record.getR0020_inward_investment() != null) {
						cell10.setCellValue(record.getR0020_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					Cell cell11 = row.createCell(11);
					if (record.getR0020_inward_trade() != null) {
						cell11.setCellValue(record.getR0020_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					Cell cell12 = row.createCell(12);
					if (record.getR0020_inward_other() != null) {
						cell12.setCellValue(record.getR0020_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row12
					row = sheet.getRow(11);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0030_outward_family() != null) {
						cell4.setCellValue(record.getR0030_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0030_outward_investment() != null) {
						cell5.setCellValue(record.getR0030_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0030_outward_trade() != null) {
						cell6.setCellValue(record.getR0030_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0030_outward_other() != null) {
						cell7.setCellValue(record.getR0030_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0030_inward_family() != null) {
						cell9.setCellValue(record.getR0030_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0030_inward_investment() != null) {
						cell10.setCellValue(record.getR0030_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0030_inward_trade() != null) {
						cell11.setCellValue(record.getR0030_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0030_inward_other() != null) {
						cell12.setCellValue(record.getR0030_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row14
					row = sheet.getRow(13);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0050_outward_family() != null) {
						cell4.setCellValue(record.getR0050_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0050_outward_investment() != null) {
						cell5.setCellValue(record.getR0050_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0050_outward_trade() != null) {
						cell6.setCellValue(record.getR0050_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0050_outward_other() != null) {
						cell7.setCellValue(record.getR0050_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0050_inward_family() != null) {
						cell9.setCellValue(record.getR0050_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0050_inward_investment() != null) {
						cell10.setCellValue(record.getR0050_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0050_inward_trade() != null) {
						cell11.setCellValue(record.getR0050_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0050_inward_other() != null) {
						cell12.setCellValue(record.getR0050_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row15
					row = sheet.getRow(14);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0060_outward_family() != null) {
						cell4.setCellValue(record.getR0060_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0060_outward_investment() != null) {
						cell5.setCellValue(record.getR0060_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0060_outward_trade() != null) {
						cell6.setCellValue(record.getR0060_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0060_outward_other() != null) {
						cell7.setCellValue(record.getR0060_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0060_inward_family() != null) {
						cell9.setCellValue(record.getR0060_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0060_inward_investment() != null) {
						cell10.setCellValue(record.getR0060_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0060_inward_trade() != null) {
						cell11.setCellValue(record.getR0060_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0060_inward_other() != null) {
						cell12.setCellValue(record.getR0060_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row16
					row = sheet.getRow(15);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0070_outward_family() != null) {
						cell4.setCellValue(record.getR0070_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0070_outward_investment() != null) {
						cell5.setCellValue(record.getR0070_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0070_outward_trade() != null) {
						cell6.setCellValue(record.getR0070_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0070_outward_other() != null) {
						cell7.setCellValue(record.getR0070_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0070_inward_family() != null) {
						cell9.setCellValue(record.getR0070_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0070_inward_investment() != null) {
						cell10.setCellValue(record.getR0070_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0070_inward_trade() != null) {
						cell11.setCellValue(record.getR0070_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0070_inward_other() != null) {
						cell12.setCellValue(record.getR0070_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row17
					row = sheet.getRow(16);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0080_outward_family() != null) {
						cell4.setCellValue(record.getR0080_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0080_outward_investment() != null) {
						cell5.setCellValue(record.getR0080_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0080_outward_trade() != null) {
						cell6.setCellValue(record.getR0080_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0080_outward_other() != null) {
						cell7.setCellValue(record.getR0080_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0080_inward_family() != null) {
						cell9.setCellValue(record.getR0080_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0080_inward_investment() != null) {
						cell10.setCellValue(record.getR0080_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0080_inward_trade() != null) {
						cell11.setCellValue(record.getR0080_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0080_inward_other() != null) {
						cell12.setCellValue(record.getR0080_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row18
					row = sheet.getRow(17);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0090_outward_family() != null) {
						cell4.setCellValue(record.getR0090_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0090_outward_investment() != null) {
						cell5.setCellValue(record.getR0090_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0090_outward_trade() != null) {
						cell6.setCellValue(record.getR0090_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0090_outward_other() != null) {
						cell7.setCellValue(record.getR0090_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0090_inward_family() != null) {
						cell9.setCellValue(record.getR0090_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0090_inward_investment() != null) {
						cell10.setCellValue(record.getR0090_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0090_inward_trade() != null) {
						cell11.setCellValue(record.getR0090_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0090_inward_other() != null) {
						cell12.setCellValue(record.getR0090_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row19
					row = sheet.getRow(18);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0100_outward_family() != null) {
						cell4.setCellValue(record.getR0100_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0100_outward_investment() != null) {
						cell5.setCellValue(record.getR0100_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0100_outward_trade() != null) {
						cell6.setCellValue(record.getR0100_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0100_outward_other() != null) {
						cell7.setCellValue(record.getR0100_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0100_inward_family() != null) {
						cell9.setCellValue(record.getR0100_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0100_inward_investment() != null) {
						cell10.setCellValue(record.getR0100_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0100_inward_trade() != null) {
						cell11.setCellValue(record.getR0100_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0100_inward_other() != null) {
						cell12.setCellValue(record.getR0100_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					

					//row20
					row = sheet.getRow(19);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0110_outward_family() != null) {
						cell4.setCellValue(record.getR0110_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0110_outward_investment() != null) {
						cell5.setCellValue(record.getR0110_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0110_outward_trade() != null) {
						cell6.setCellValue(record.getR0110_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0110_outward_other() != null) {
						cell7.setCellValue(record.getR0110_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0110_inward_family() != null) {
						cell9.setCellValue(record.getR0110_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0110_inward_investment() != null) {
						cell10.setCellValue(record.getR0110_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0110_inward_trade() != null) {
						cell11.setCellValue(record.getR0110_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0110_inward_other() != null) {
						cell12.setCellValue(record.getR0110_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row21
					row = sheet.getRow(20);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0120_outward_family() != null) {
						cell4.setCellValue(record.getR0120_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0120_outward_investment() != null) {
						cell5.setCellValue(record.getR0120_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0120_outward_trade() != null) {
						cell6.setCellValue(record.getR0120_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0120_outward_other() != null) {
						cell7.setCellValue(record.getR0120_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0120_inward_family() != null) {
						cell9.setCellValue(record.getR0120_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0120_inward_investment() != null) {
						cell10.setCellValue(record.getR0120_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0120_inward_trade() != null) {
						cell11.setCellValue(record.getR0120_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0120_inward_other() != null) {
						cell12.setCellValue(record.getR0120_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row22
					row = sheet.getRow(21);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0130_outward_family() != null) {
						cell4.setCellValue(record.getR0130_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0130_outward_investment() != null) {
						cell5.setCellValue(record.getR0130_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0130_outward_trade() != null) {
						cell6.setCellValue(record.getR0130_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0130_outward_other() != null) {
						cell7.setCellValue(record.getR0130_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0130_inward_family() != null) {
						cell9.setCellValue(record.getR0130_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0130_inward_investment() != null) {
						cell10.setCellValue(record.getR0130_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0130_inward_trade() != null) {
						cell11.setCellValue(record.getR0130_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0130_inward_other() != null) {
						cell12.setCellValue(record.getR0130_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row23
					row = sheet.getRow(22);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0140_outward_family() != null) {
						cell4.setCellValue(record.getR0140_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0140_outward_investment() != null) {
						cell5.setCellValue(record.getR0140_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0140_outward_trade() != null) {
						cell6.setCellValue(record.getR0140_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0140_outward_other() != null) {
						cell7.setCellValue(record.getR0140_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0140_inward_family() != null) {
						cell9.setCellValue(record.getR0140_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0140_inward_investment() != null) {
						cell10.setCellValue(record.getR0140_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0140_inward_trade() != null) {
						cell11.setCellValue(record.getR0140_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0140_inward_other() != null) {
						cell12.setCellValue(record.getR0140_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row24
					row = sheet.getRow(23);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0150_outward_family() != null) {
						cell4.setCellValue(record.getR0150_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0150_outward_investment() != null) {
						cell5.setCellValue(record.getR0150_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0150_outward_trade() != null) {
						cell6.setCellValue(record.getR0150_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0150_outward_other() != null) {
						cell7.setCellValue(record.getR0150_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0150_inward_family() != null) {
						cell9.setCellValue(record.getR0150_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0150_inward_investment() != null) {
						cell10.setCellValue(record.getR0150_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0150_inward_trade() != null) {
						cell11.setCellValue(record.getR0150_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0150_inward_other() != null) {
						cell12.setCellValue(record.getR0150_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row25
					row = sheet.getRow(24);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0160_outward_family() != null) {
						cell4.setCellValue(record.getR0160_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0160_outward_investment() != null) {
						cell5.setCellValue(record.getR0160_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0160_outward_trade() != null) {
						cell6.setCellValue(record.getR0160_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0160_outward_other() != null) {
						cell7.setCellValue(record.getR0160_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0160_inward_family() != null) {
						cell9.setCellValue(record.getR0160_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0160_inward_investment() != null) {
						cell10.setCellValue(record.getR0160_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0160_inward_trade() != null) {
						cell11.setCellValue(record.getR0160_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0160_inward_other() != null) {
						cell12.setCellValue(record.getR0160_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row26
					row = sheet.getRow(25);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0170_outward_family() != null) {
						cell4.setCellValue(record.getR0170_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0170_outward_investment() != null) {
						cell5.setCellValue(record.getR0170_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0170_outward_trade() != null) {
						cell6.setCellValue(record.getR0170_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0170_outward_other() != null) {
						cell7.setCellValue(record.getR0170_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0170_inward_family() != null) {
						cell9.setCellValue(record.getR0170_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0170_inward_investment() != null) {
						cell10.setCellValue(record.getR0170_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0170_inward_trade() != null) {
						cell11.setCellValue(record.getR0170_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0170_inward_other() != null) {
						cell12.setCellValue(record.getR0170_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row27
					row = sheet.getRow(26);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0180_outward_family() != null) {
						cell4.setCellValue(record.getR0180_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0180_outward_investment() != null) {
						cell5.setCellValue(record.getR0180_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0180_outward_trade() != null) {
						cell6.setCellValue(record.getR0180_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0180_outward_other() != null) {
						cell7.setCellValue(record.getR0180_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0180_inward_family() != null) {
						cell9.setCellValue(record.getR0180_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0180_inward_investment() != null) {
						cell10.setCellValue(record.getR0180_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0180_inward_trade() != null) {
						cell11.setCellValue(record.getR0180_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0180_inward_other() != null) {
						cell12.setCellValue(record.getR0180_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row28
					row = sheet.getRow(27);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0190_outward_family() != null) {
						cell4.setCellValue(record.getR0190_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0190_outward_investment() != null) {
						cell5.setCellValue(record.getR0190_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0190_outward_trade() != null) {
						cell6.setCellValue(record.getR0190_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0190_outward_other() != null) {
						cell7.setCellValue(record.getR0190_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0190_inward_family() != null) {
						cell9.setCellValue(record.getR0190_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0190_inward_investment() != null) {
						cell10.setCellValue(record.getR0190_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0190_inward_trade() != null) {
						cell11.setCellValue(record.getR0190_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0190_inward_other() != null) {
						cell12.setCellValue(record.getR0190_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row29
					row = sheet.getRow(28);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0200_outward_family() != null) {
						cell4.setCellValue(record.getR0200_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0200_outward_investment() != null) {
						cell5.setCellValue(record.getR0200_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0200_outward_trade() != null) {
						cell6.setCellValue(record.getR0200_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0200_outward_other() != null) {
						cell7.setCellValue(record.getR0200_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0200_inward_family() != null) {
						cell9.setCellValue(record.getR0200_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0200_inward_investment() != null) {
						cell10.setCellValue(record.getR0200_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0200_inward_trade() != null) {
						cell11.setCellValue(record.getR0200_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0200_inward_other() != null) {
						cell12.setCellValue(record.getR0200_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row30
					row = sheet.getRow(29);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0210_outward_family() != null) {
						cell4.setCellValue(record.getR0210_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0210_outward_investment() != null) {
						cell5.setCellValue(record.getR0210_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0210_outward_trade() != null) {
						cell6.setCellValue(record.getR0210_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0210_outward_other() != null) {
						cell7.setCellValue(record.getR0210_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0210_inward_family() != null) {
						cell9.setCellValue(record.getR0210_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0210_inward_investment() != null) {
						cell10.setCellValue(record.getR0210_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0210_inward_trade() != null) {
						cell11.setCellValue(record.getR0210_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0210_inward_other() != null) {
						cell12.setCellValue(record.getR0210_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row31
					row = sheet.getRow(30);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0220_outward_family() != null) {
						cell4.setCellValue(record.getR0220_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0220_outward_investment() != null) {
						cell5.setCellValue(record.getR0220_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0220_outward_trade() != null) {
						cell6.setCellValue(record.getR0220_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0220_outward_other() != null) {
						cell7.setCellValue(record.getR0220_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0220_inward_family() != null) {
						cell9.setCellValue(record.getR0220_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0220_inward_investment() != null) {
						cell10.setCellValue(record.getR0220_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0220_inward_trade() != null) {
						cell11.setCellValue(record.getR0220_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0220_inward_other() != null) {
						cell12.setCellValue(record.getR0220_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row32
					row = sheet.getRow(31);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0230_outward_family() != null) {
						cell4.setCellValue(record.getR0230_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0230_outward_investment() != null) {
						cell5.setCellValue(record.getR0230_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0230_outward_trade() != null) {
						cell6.setCellValue(record.getR0230_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0230_outward_other() != null) {
						cell7.setCellValue(record.getR0230_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0230_inward_family() != null) {
						cell9.setCellValue(record.getR0230_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0230_inward_investment() != null) {
						cell10.setCellValue(record.getR0230_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0230_inward_trade() != null) {
						cell11.setCellValue(record.getR0230_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0230_inward_other() != null) {
						cell12.setCellValue(record.getR0230_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row33
					row = sheet.getRow(32);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0240_outward_family() != null) {
						cell4.setCellValue(record.getR0240_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0240_outward_investment() != null) {
						cell5.setCellValue(record.getR0240_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0240_outward_trade() != null) {
						cell6.setCellValue(record.getR0240_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0240_outward_other() != null) {
						cell7.setCellValue(record.getR0240_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0240_inward_family() != null) {
						cell9.setCellValue(record.getR0240_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0240_inward_investment() != null) {
						cell10.setCellValue(record.getR0240_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0240_inward_trade() != null) {
						cell11.setCellValue(record.getR0240_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0240_inward_other() != null) {
						cell12.setCellValue(record.getR0240_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row34
					row = sheet.getRow(33);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0250_outward_family() != null) {
						cell4.setCellValue(record.getR0250_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0250_outward_investment() != null) {
						cell5.setCellValue(record.getR0250_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0250_outward_trade() != null) {
						cell6.setCellValue(record.getR0250_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0250_outward_other() != null) {
						cell7.setCellValue(record.getR0250_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0250_inward_family() != null) {
						cell9.setCellValue(record.getR0250_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0250_inward_investment() != null) {
						cell10.setCellValue(record.getR0250_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0250_inward_trade() != null) {
						cell11.setCellValue(record.getR0250_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0250_inward_other() != null) {
						cell12.setCellValue(record.getR0250_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row36
					row = sheet.getRow(35);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0270_outward_family() != null) {
						cell4.setCellValue(record.getR0270_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0270_outward_investment() != null) {
						cell5.setCellValue(record.getR0270_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0270_outward_trade() != null) {
						cell6.setCellValue(record.getR0270_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0270_outward_other() != null) {
						cell7.setCellValue(record.getR0270_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0270_inward_family() != null) {
						cell9.setCellValue(record.getR0270_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0270_inward_investment() != null) {
						cell10.setCellValue(record.getR0270_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0270_inward_trade() != null) {
						cell11.setCellValue(record.getR0270_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0270_inward_other() != null) {
						cell12.setCellValue(record.getR0270_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row37
					row = sheet.getRow(36);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0280_outward_family() != null) {
						cell4.setCellValue(record.getR0280_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0280_outward_investment() != null) {
						cell5.setCellValue(record.getR0280_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0280_outward_trade() != null) {
						cell6.setCellValue(record.getR0280_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0280_outward_other() != null) {
						cell7.setCellValue(record.getR0280_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0280_inward_family() != null) {
						cell9.setCellValue(record.getR0280_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0280_inward_investment() != null) {
						cell10.setCellValue(record.getR0280_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0280_inward_trade() != null) {
						cell11.setCellValue(record.getR0280_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0280_inward_other() != null) {
						cell12.setCellValue(record.getR0280_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row38
					row = sheet.getRow(37);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0290_outward_family() != null) {
						cell4.setCellValue(record.getR0290_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0290_outward_investment() != null) {
						cell5.setCellValue(record.getR0290_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0290_outward_trade() != null) {
						cell6.setCellValue(record.getR0290_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0290_outward_other() != null) {
						cell7.setCellValue(record.getR0290_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0290_inward_family() != null) {
						cell9.setCellValue(record.getR0290_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0290_inward_investment() != null) {
						cell10.setCellValue(record.getR0290_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0290_inward_trade() != null) {
						cell11.setCellValue(record.getR0290_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0290_inward_other() != null) {
						cell12.setCellValue(record.getR0290_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row39
					row = sheet.getRow(38);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0300_outward_family() != null) {
						cell4.setCellValue(record.getR0300_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0300_outward_investment() != null) {
						cell5.setCellValue(record.getR0300_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0300_outward_trade() != null) {
						cell6.setCellValue(record.getR0300_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0300_outward_other() != null) {
						cell7.setCellValue(record.getR0300_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0300_inward_family() != null) {
						cell9.setCellValue(record.getR0300_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0300_inward_investment() != null) {
						cell10.setCellValue(record.getR0300_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0300_inward_trade() != null) {
						cell11.setCellValue(record.getR0300_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0300_inward_other() != null) {
						cell12.setCellValue(record.getR0300_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row40
					row = sheet.getRow(39);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0310_outward_family() != null) {
						cell4.setCellValue(record.getR0310_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0310_outward_investment() != null) {
						cell5.setCellValue(record.getR0310_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0310_outward_trade() != null) {
						cell6.setCellValue(record.getR0310_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0310_outward_other() != null) {
						cell7.setCellValue(record.getR0310_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0310_inward_family() != null) {
						cell9.setCellValue(record.getR0310_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0310_inward_investment() != null) {
						cell10.setCellValue(record.getR0310_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0310_inward_trade() != null) {
						cell11.setCellValue(record.getR0310_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0310_inward_other() != null) {
						cell12.setCellValue(record.getR0310_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row42
					row = sheet.getRow(41);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0330_outward_family() != null) {
						cell4.setCellValue(record.getR0330_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0330_outward_investment() != null) {
						cell5.setCellValue(record.getR0330_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0330_outward_trade() != null) {
						cell6.setCellValue(record.getR0330_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0330_outward_other() != null) {
						cell7.setCellValue(record.getR0330_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0330_inward_family() != null) {
						cell9.setCellValue(record.getR0330_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0330_inward_investment() != null) {
						cell10.setCellValue(record.getR0330_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0330_inward_trade() != null) {
						cell11.setCellValue(record.getR0330_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0330_inward_other() != null) {
						cell12.setCellValue(record.getR0330_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row43
					row = sheet.getRow(42);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0340_outward_family() != null) {
						cell4.setCellValue(record.getR0340_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0340_outward_investment() != null) {
						cell5.setCellValue(record.getR0340_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0340_outward_trade() != null) {
						cell6.setCellValue(record.getR0340_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0340_outward_other() != null) {
						cell7.setCellValue(record.getR0340_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0340_inward_family() != null) {
						cell9.setCellValue(record.getR0340_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0340_inward_investment() != null) {
						cell10.setCellValue(record.getR0340_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0340_inward_trade() != null) {
						cell11.setCellValue(record.getR0340_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0340_inward_other() != null) {
						cell12.setCellValue(record.getR0340_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row44
					row = sheet.getRow(43);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0350_outward_family() != null) {
						cell4.setCellValue(record.getR0350_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0350_outward_investment() != null) {
						cell5.setCellValue(record.getR0350_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0350_outward_trade() != null) {
						cell6.setCellValue(record.getR0350_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0350_outward_other() != null) {
						cell7.setCellValue(record.getR0350_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0350_inward_family() != null) {
						cell9.setCellValue(record.getR0350_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0350_inward_investment() != null) {
						cell10.setCellValue(record.getR0350_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0350_inward_trade() != null) {
						cell11.setCellValue(record.getR0350_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0350_inward_other() != null) {
						cell12.setCellValue(record.getR0350_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row45
					row = sheet.getRow(44);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0360_outward_family() != null) {
						cell4.setCellValue(record.getR0360_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0360_outward_investment() != null) {
						cell5.setCellValue(record.getR0360_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0360_outward_trade() != null) {
						cell6.setCellValue(record.getR0360_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0360_outward_other() != null) {
						cell7.setCellValue(record.getR0360_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0360_inward_family() != null) {
						cell9.setCellValue(record.getR0360_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0360_inward_investment() != null) {
						cell10.setCellValue(record.getR0360_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0360_inward_trade() != null) {
						cell11.setCellValue(record.getR0360_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0360_inward_other() != null) {
						cell12.setCellValue(record.getR0360_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					
					

					//row46
					row = sheet.getRow(45);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0370_outward_family() != null) {
						cell4.setCellValue(record.getR0370_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0370_outward_investment() != null) {
						cell5.setCellValue(record.getR0370_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0370_outward_trade() != null) {
						cell6.setCellValue(record.getR0370_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0370_outward_other() != null) {
						cell7.setCellValue(record.getR0370_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0370_inward_family() != null) {
						cell9.setCellValue(record.getR0370_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0370_inward_investment() != null) {
						cell10.setCellValue(record.getR0370_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0370_inward_trade() != null) {
						cell11.setCellValue(record.getR0370_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0370_inward_other() != null) {
						cell12.setCellValue(record.getR0370_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row47
					row = sheet.getRow(46);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0380_outward_family() != null) {
						cell4.setCellValue(record.getR0380_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0380_outward_investment() != null) {
						cell5.setCellValue(record.getR0380_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0380_outward_trade() != null) {
						cell6.setCellValue(record.getR0380_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0380_outward_other() != null) {
						cell7.setCellValue(record.getR0380_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0380_inward_family() != null) {
						cell9.setCellValue(record.getR0380_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0380_inward_investment() != null) {
						cell10.setCellValue(record.getR0380_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0380_inward_trade() != null) {
						cell11.setCellValue(record.getR0380_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0380_inward_other() != null) {
						cell12.setCellValue(record.getR0380_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row48
					row = sheet.getRow(47);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0390_outward_family() != null) {
						cell4.setCellValue(record.getR0390_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0390_outward_investment() != null) {
						cell5.setCellValue(record.getR0390_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0390_outward_trade() != null) {
						cell6.setCellValue(record.getR0390_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0390_outward_other() != null) {
						cell7.setCellValue(record.getR0390_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0390_inward_family() != null) {
						cell9.setCellValue(record.getR0390_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0390_inward_investment() != null) {
						cell10.setCellValue(record.getR0390_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0390_inward_trade() != null) {
						cell11.setCellValue(record.getR0390_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0390_inward_other() != null) {
						cell12.setCellValue(record.getR0390_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					

					//row49
					row = sheet.getRow(48);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0400_outward_family() != null) {
						cell4.setCellValue(record.getR0400_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0400_outward_investment() != null) {
						cell5.setCellValue(record.getR0400_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0400_outward_trade() != null) {
						cell6.setCellValue(record.getR0400_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0400_outward_other() != null) {
						cell7.setCellValue(record.getR0400_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0400_inward_family() != null) {
						cell9.setCellValue(record.getR0400_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0400_inward_investment() != null) {
						cell10.setCellValue(record.getR0400_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0400_inward_trade() != null) {
						cell11.setCellValue(record.getR0400_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0400_inward_other() != null) {
						cell12.setCellValue(record.getR0400_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row50
					row = sheet.getRow(49);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0410_outward_family() != null) {
						cell4.setCellValue(record.getR0410_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0410_outward_investment() != null) {
						cell5.setCellValue(record.getR0410_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0410_outward_trade() != null) {
						cell6.setCellValue(record.getR0410_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0410_outward_other() != null) {
						cell7.setCellValue(record.getR0410_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0410_inward_family() != null) {
						cell9.setCellValue(record.getR0410_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0410_inward_investment() != null) {
						cell10.setCellValue(record.getR0410_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0410_inward_trade() != null) {
						cell11.setCellValue(record.getR0410_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0410_inward_other() != null) {
						cell12.setCellValue(record.getR0410_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					
					

					//row51
					row = sheet.getRow(50);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0420_outward_family() != null) {
						cell4.setCellValue(record.getR0420_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0420_outward_investment() != null) {
						cell5.setCellValue(record.getR0420_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0420_outward_trade() != null) {
						cell6.setCellValue(record.getR0420_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0420_outward_other() != null) {
						cell7.setCellValue(record.getR0420_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0420_inward_family() != null) {
						cell9.setCellValue(record.getR0420_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0420_inward_investment() != null) {
						cell10.setCellValue(record.getR0420_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0420_inward_trade() != null) {
						cell11.setCellValue(record.getR0420_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0420_inward_other() != null) {
						cell12.setCellValue(record.getR0420_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					
					

					//row53
					row = sheet.getRow(52);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0440_outward_family() != null) {
						cell4.setCellValue(record.getR0440_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0440_outward_investment() != null) {
						cell5.setCellValue(record.getR0440_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0440_outward_trade() != null) {
						cell6.setCellValue(record.getR0440_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0440_outward_other() != null) {
						cell7.setCellValue(record.getR0440_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0440_inward_family() != null) {
						cell9.setCellValue(record.getR0440_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0440_inward_investment() != null) {
						cell10.setCellValue(record.getR0440_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0440_inward_trade() != null) {
						cell11.setCellValue(record.getR0440_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0440_inward_other() != null) {
						cell12.setCellValue(record.getR0440_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row54
					row = sheet.getRow(53);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0450_outward_family() != null) {
						cell4.setCellValue(record.getR0450_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0450_outward_investment() != null) {
						cell5.setCellValue(record.getR0450_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0450_outward_trade() != null) {
						cell6.setCellValue(record.getR0450_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0450_outward_other() != null) {
						cell7.setCellValue(record.getR0450_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0450_inward_family() != null) {
						cell9.setCellValue(record.getR0450_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0450_inward_investment() != null) {
						cell10.setCellValue(record.getR0450_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0450_inward_trade() != null) {
						cell11.setCellValue(record.getR0450_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0450_inward_other() != null) {
						cell12.setCellValue(record.getR0450_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row55
					row = sheet.getRow(54);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0460_outward_family() != null) {
						cell4.setCellValue(record.getR0460_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0460_outward_investment() != null) {
						cell5.setCellValue(record.getR0460_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0460_outward_trade() != null) {
						cell6.setCellValue(record.getR0460_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0460_outward_other() != null) {
						cell7.setCellValue(record.getR0460_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0460_inward_family() != null) {
						cell9.setCellValue(record.getR0460_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0460_inward_investment() != null) {
						cell10.setCellValue(record.getR0460_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0460_inward_trade() != null) {
						cell11.setCellValue(record.getR0460_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0460_inward_other() != null) {
						cell12.setCellValue(record.getR0460_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row56
					row = sheet.getRow(55);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0470_outward_family() != null) {
						cell4.setCellValue(record.getR0470_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0470_outward_investment() != null) {
						cell5.setCellValue(record.getR0470_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0470_outward_trade() != null) {
						cell6.setCellValue(record.getR0470_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0470_outward_other() != null) {
						cell7.setCellValue(record.getR0470_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0470_inward_family() != null) {
						cell9.setCellValue(record.getR0470_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0470_inward_investment() != null) {
						cell10.setCellValue(record.getR0470_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0470_inward_trade() != null) {
						cell11.setCellValue(record.getR0470_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0470_inward_other() != null) {
						cell12.setCellValue(record.getR0470_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row57
					row = sheet.getRow(56);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0480_outward_family() != null) {
						cell4.setCellValue(record.getR0480_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0480_outward_investment() != null) {
						cell5.setCellValue(record.getR0480_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0480_outward_trade() != null) {
						cell6.setCellValue(record.getR0480_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0480_outward_other() != null) {
						cell7.setCellValue(record.getR0480_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0480_inward_family() != null) {
						cell9.setCellValue(record.getR0480_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0480_inward_investment() != null) {
						cell10.setCellValue(record.getR0480_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0480_inward_trade() != null) {
						cell11.setCellValue(record.getR0480_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0480_inward_other() != null) {
						cell12.setCellValue(record.getR0480_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row59
					row = sheet.getRow(58);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0500_outward_family() != null) {
						cell4.setCellValue(record.getR0500_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0500_outward_investment() != null) {
						cell5.setCellValue(record.getR0500_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0500_outward_trade() != null) {
						cell6.setCellValue(record.getR0500_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0500_outward_other() != null) {
						cell7.setCellValue(record.getR0500_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0500_inward_family() != null) {
						cell9.setCellValue(record.getR0500_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0500_inward_investment() != null) {
						cell10.setCellValue(record.getR0500_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0500_inward_trade() != null) {
						cell11.setCellValue(record.getR0500_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0500_inward_other() != null) {
						cell12.setCellValue(record.getR0500_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row60
					row = sheet.getRow(59);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0510_outward_family() != null) {
						cell4.setCellValue(record.getR0510_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0510_outward_investment() != null) {
						cell5.setCellValue(record.getR0510_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0510_outward_trade() != null) {
						cell6.setCellValue(record.getR0510_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0510_outward_other() != null) {
						cell7.setCellValue(record.getR0510_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0510_inward_family() != null) {
						cell9.setCellValue(record.getR0510_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0510_inward_investment() != null) {
						cell10.setCellValue(record.getR0510_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0510_inward_trade() != null) {
						cell11.setCellValue(record.getR0510_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0510_inward_other() != null) {
						cell12.setCellValue(record.getR0510_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					

					//row61
					row = sheet.getRow(60);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0520_outward_family() != null) {
						cell4.setCellValue(record.getR0520_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0520_outward_investment() != null) {
						cell5.setCellValue(record.getR0520_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0520_outward_trade() != null) {
						cell6.setCellValue(record.getR0520_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0520_outward_other() != null) {
						cell7.setCellValue(record.getR0520_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0520_inward_family() != null) {
						cell9.setCellValue(record.getR0520_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0520_inward_investment() != null) {
						cell10.setCellValue(record.getR0520_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0520_inward_trade() != null) {
						cell11.setCellValue(record.getR0520_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0520_inward_other() != null) {
						cell12.setCellValue(record.getR0520_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row62
					row = sheet.getRow(61);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0530_outward_family() != null) {
						cell4.setCellValue(record.getR0530_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0530_outward_investment() != null) {
						cell5.setCellValue(record.getR0530_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0530_outward_trade() != null) {
						cell6.setCellValue(record.getR0530_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0530_outward_other() != null) {
						cell7.setCellValue(record.getR0530_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0530_inward_family() != null) {
						cell9.setCellValue(record.getR0530_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0530_inward_investment() != null) {
						cell10.setCellValue(record.getR0530_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0530_inward_trade() != null) {
						cell11.setCellValue(record.getR0530_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0530_inward_other() != null) {
						cell12.setCellValue(record.getR0530_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row63
					row = sheet.getRow(62);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0540_outward_family() != null) {
						cell4.setCellValue(record.getR0540_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0540_outward_investment() != null) {
						cell5.setCellValue(record.getR0540_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0540_outward_trade() != null) {
						cell6.setCellValue(record.getR0540_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0540_outward_other() != null) {
						cell7.setCellValue(record.getR0540_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0540_inward_family() != null) {
						cell9.setCellValue(record.getR0540_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0540_inward_investment() != null) {
						cell10.setCellValue(record.getR0540_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0540_inward_trade() != null) {
						cell11.setCellValue(record.getR0540_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0540_inward_other() != null) {
						cell12.setCellValue(record.getR0540_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row64
					row = sheet.getRow(63);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0550_outward_family() != null) {
						cell4.setCellValue(record.getR0550_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0550_outward_investment() != null) {
						cell5.setCellValue(record.getR0550_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0550_outward_trade() != null) {
						cell6.setCellValue(record.getR0550_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0550_outward_other() != null) {
						cell7.setCellValue(record.getR0550_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0550_inward_family() != null) {
						cell9.setCellValue(record.getR0550_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0550_inward_investment() != null) {
						cell10.setCellValue(record.getR0550_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0550_inward_trade() != null) {
						cell11.setCellValue(record.getR0550_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0550_inward_other() != null) {
						cell12.setCellValue(record.getR0550_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row65
					row = sheet.getRow(64);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0560_outward_family() != null) {
						cell4.setCellValue(record.getR0560_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0560_outward_investment() != null) {
						cell5.setCellValue(record.getR0560_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0560_outward_trade() != null) {
						cell6.setCellValue(record.getR0560_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0560_outward_other() != null) {
						cell7.setCellValue(record.getR0560_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0560_inward_family() != null) {
						cell9.setCellValue(record.getR0560_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0560_inward_investment() != null) {
						cell10.setCellValue(record.getR0560_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0560_inward_trade() != null) {
						cell11.setCellValue(record.getR0560_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0560_inward_other() != null) {
						cell12.setCellValue(record.getR0560_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row66
					row = sheet.getRow(65);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0570_outward_family() != null) {
						cell4.setCellValue(record.getR0570_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0570_outward_investment() != null) {
						cell5.setCellValue(record.getR0570_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0570_outward_trade() != null) {
						cell6.setCellValue(record.getR0570_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0570_outward_other() != null) {
						cell7.setCellValue(record.getR0570_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0570_inward_family() != null) {
						cell9.setCellValue(record.getR0570_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0570_inward_investment() != null) {
						cell10.setCellValue(record.getR0570_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0570_inward_trade() != null) {
						cell11.setCellValue(record.getR0570_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0570_inward_other() != null) {
						cell12.setCellValue(record.getR0570_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row67
					row = sheet.getRow(66);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0580_outward_family() != null) {
						cell4.setCellValue(record.getR0580_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0580_outward_investment() != null) {
						cell5.setCellValue(record.getR0580_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0580_outward_trade() != null) {
						cell6.setCellValue(record.getR0580_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0580_outward_other() != null) {
						cell7.setCellValue(record.getR0580_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0580_inward_family() != null) {
						cell9.setCellValue(record.getR0580_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0580_inward_investment() != null) {
						cell10.setCellValue(record.getR0580_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0580_inward_trade() != null) {
						cell11.setCellValue(record.getR0580_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0580_inward_other() != null) {
						cell12.setCellValue(record.getR0580_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row68
					row = sheet.getRow(67);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0590_outward_family() != null) {
						cell4.setCellValue(record.getR0590_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0590_outward_investment() != null) {
						cell5.setCellValue(record.getR0590_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0590_outward_trade() != null) {
						cell6.setCellValue(record.getR0590_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0590_outward_other() != null) {
						cell7.setCellValue(record.getR0590_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0590_inward_family() != null) {
						cell9.setCellValue(record.getR0590_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0590_inward_investment() != null) {
						cell10.setCellValue(record.getR0590_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0590_inward_trade() != null) {
						cell11.setCellValue(record.getR0590_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0590_inward_other() != null) {
						cell12.setCellValue(record.getR0590_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row69
					row = sheet.getRow(68);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0600_outward_family() != null) {
						cell4.setCellValue(record.getR0600_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0600_outward_investment() != null) {
						cell5.setCellValue(record.getR0600_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0600_outward_trade() != null) {
						cell6.setCellValue(record.getR0600_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0600_outward_other() != null) {
						cell7.setCellValue(record.getR0600_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0600_inward_family() != null) {
						cell9.setCellValue(record.getR0600_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0600_inward_investment() != null) {
						cell10.setCellValue(record.getR0600_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0600_inward_trade() != null) {
						cell11.setCellValue(record.getR0600_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0600_inward_other() != null) {
						cell12.setCellValue(record.getR0600_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row70
					row = sheet.getRow(69);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0610_outward_family() != null) {
						cell4.setCellValue(record.getR0610_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0610_outward_investment() != null) {
						cell5.setCellValue(record.getR0610_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0610_outward_trade() != null) {
						cell6.setCellValue(record.getR0610_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0610_outward_other() != null) {
						cell7.setCellValue(record.getR0610_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0610_inward_family() != null) {
						cell9.setCellValue(record.getR0610_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0610_inward_investment() != null) {
						cell10.setCellValue(record.getR0610_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0610_inward_trade() != null) {
						cell11.setCellValue(record.getR0610_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0610_inward_other() != null) {
						cell12.setCellValue(record.getR0610_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row71
					row = sheet.getRow(70);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0620_outward_family() != null) {
						cell4.setCellValue(record.getR0620_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0620_outward_investment() != null) {
						cell5.setCellValue(record.getR0620_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0620_outward_trade() != null) {
						cell6.setCellValue(record.getR0620_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0620_outward_other() != null) {
						cell7.setCellValue(record.getR0620_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0620_inward_family() != null) {
						cell9.setCellValue(record.getR0620_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0620_inward_investment() != null) {
						cell10.setCellValue(record.getR0620_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0620_inward_trade() != null) {
						cell11.setCellValue(record.getR0620_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0620_inward_other() != null) {
						cell12.setCellValue(record.getR0620_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row72
					row = sheet.getRow(71);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0630_outward_family() != null) {
						cell4.setCellValue(record.getR0630_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0630_outward_investment() != null) {
						cell5.setCellValue(record.getR0630_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0630_outward_trade() != null) {
						cell6.setCellValue(record.getR0630_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0630_outward_other() != null) {
						cell7.setCellValue(record.getR0630_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0630_inward_family() != null) {
						cell9.setCellValue(record.getR0630_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0630_inward_investment() != null) {
						cell10.setCellValue(record.getR0630_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0630_inward_trade() != null) {
						cell11.setCellValue(record.getR0630_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0630_inward_other() != null) {
						cell12.setCellValue(record.getR0630_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row73
					row = sheet.getRow(72);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0640_outward_family() != null) {
						cell4.setCellValue(record.getR0640_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0640_outward_investment() != null) {
						cell5.setCellValue(record.getR0640_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0640_outward_trade() != null) {
						cell6.setCellValue(record.getR0640_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0640_outward_other() != null) {
						cell7.setCellValue(record.getR0640_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0640_inward_family() != null) {
						cell9.setCellValue(record.getR0640_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0640_inward_investment() != null) {
						cell10.setCellValue(record.getR0640_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0640_inward_trade() != null) {
						cell11.setCellValue(record.getR0640_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0640_inward_other() != null) {
						cell12.setCellValue(record.getR0640_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row74
					row = sheet.getRow(73);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0650_outward_family() != null) {
						cell4.setCellValue(record.getR0650_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0650_outward_investment() != null) {
						cell5.setCellValue(record.getR0650_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0650_outward_trade() != null) {
						cell6.setCellValue(record.getR0650_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0650_outward_other() != null) {
						cell7.setCellValue(record.getR0650_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0650_inward_family() != null) {
						cell9.setCellValue(record.getR0650_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0650_inward_investment() != null) {
						cell10.setCellValue(record.getR0650_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0650_inward_trade() != null) {
						cell11.setCellValue(record.getR0650_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0650_inward_other() != null) {
						cell12.setCellValue(record.getR0650_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row75
					row = sheet.getRow(74);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0660_outward_family() != null) {
						cell4.setCellValue(record.getR0660_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0660_outward_investment() != null) {
						cell5.setCellValue(record.getR0660_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0660_outward_trade() != null) {
						cell6.setCellValue(record.getR0660_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0660_outward_other() != null) {
						cell7.setCellValue(record.getR0660_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0660_inward_family() != null) {
						cell9.setCellValue(record.getR0660_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0660_inward_investment() != null) {
						cell10.setCellValue(record.getR0660_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0660_inward_trade() != null) {
						cell11.setCellValue(record.getR0660_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0660_inward_other() != null) {
						cell12.setCellValue(record.getR0660_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row76
					row = sheet.getRow(75);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0670_outward_family() != null) {
						cell4.setCellValue(record.getR0670_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0670_outward_investment() != null) {
						cell5.setCellValue(record.getR0670_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0670_outward_trade() != null) {
						cell6.setCellValue(record.getR0670_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0670_outward_other() != null) {
						cell7.setCellValue(record.getR0670_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0670_inward_family() != null) {
						cell9.setCellValue(record.getR0670_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0670_inward_investment() != null) {
						cell10.setCellValue(record.getR0670_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0670_inward_trade() != null) {
						cell11.setCellValue(record.getR0670_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0670_inward_other() != null) {
						cell12.setCellValue(record.getR0670_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row78
					row = sheet.getRow(77);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0690_outward_family() != null) {
						cell4.setCellValue(record.getR0690_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0690_outward_investment() != null) {
						cell5.setCellValue(record.getR0690_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0690_outward_trade() != null) {
						cell6.setCellValue(record.getR0690_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0690_outward_other() != null) {
						cell7.setCellValue(record.getR0690_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0690_inward_family() != null) {
						cell9.setCellValue(record.getR0690_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0690_inward_investment() != null) {
						cell10.setCellValue(record.getR0690_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0690_inward_trade() != null) {
						cell11.setCellValue(record.getR0690_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0690_inward_other() != null) {
						cell12.setCellValue(record.getR0690_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row79
					row = sheet.getRow(78);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0700_outward_family() != null) {
						cell4.setCellValue(record.getR0700_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0700_outward_investment() != null) {
						cell5.setCellValue(record.getR0700_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0700_outward_trade() != null) {
						cell6.setCellValue(record.getR0700_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0700_outward_other() != null) {
						cell7.setCellValue(record.getR0700_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0700_inward_family() != null) {
						cell9.setCellValue(record.getR0700_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0700_inward_investment() != null) {
						cell10.setCellValue(record.getR0700_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0700_inward_trade() != null) {
						cell11.setCellValue(record.getR0700_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0700_inward_other() != null) {
						cell12.setCellValue(record.getR0700_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row80
					row = sheet.getRow(79);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0710_outward_family() != null) {
						cell4.setCellValue(record.getR0710_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0710_outward_investment() != null) {
						cell5.setCellValue(record.getR0710_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0710_outward_trade() != null) {
						cell6.setCellValue(record.getR0710_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0710_outward_other() != null) {
						cell7.setCellValue(record.getR0710_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0710_inward_family() != null) {
						cell9.setCellValue(record.getR0710_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0710_inward_investment() != null) {
						cell10.setCellValue(record.getR0710_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0710_inward_trade() != null) {
						cell11.setCellValue(record.getR0710_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0710_inward_other() != null) {
						cell12.setCellValue(record.getR0710_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row81
					row = sheet.getRow(80);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0720_outward_family() != null) {
						cell4.setCellValue(record.getR0720_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0720_outward_investment() != null) {
						cell5.setCellValue(record.getR0720_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0720_outward_trade() != null) {
						cell6.setCellValue(record.getR0720_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0720_outward_other() != null) {
						cell7.setCellValue(record.getR0720_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0720_inward_family() != null) {
						cell9.setCellValue(record.getR0720_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0720_inward_investment() != null) {
						cell10.setCellValue(record.getR0720_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0720_inward_trade() != null) {
						cell11.setCellValue(record.getR0720_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0720_inward_other() != null) {
						cell12.setCellValue(record.getR0720_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row82
					row = sheet.getRow(81);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0730_outward_family() != null) {
						cell4.setCellValue(record.getR0730_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0730_outward_investment() != null) {
						cell5.setCellValue(record.getR0730_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0730_outward_trade() != null) {
						cell6.setCellValue(record.getR0730_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0730_outward_other() != null) {
						cell7.setCellValue(record.getR0730_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0730_inward_family() != null) {
						cell9.setCellValue(record.getR0730_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0730_inward_investment() != null) {
						cell10.setCellValue(record.getR0730_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0730_inward_trade() != null) {
						cell11.setCellValue(record.getR0730_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0730_inward_other() != null) {
						cell12.setCellValue(record.getR0730_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row83
					row = sheet.getRow(82);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0740_outward_family() != null) {
						cell4.setCellValue(record.getR0740_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0740_outward_investment() != null) {
						cell5.setCellValue(record.getR0740_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0740_outward_trade() != null) {
						cell6.setCellValue(record.getR0740_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0740_outward_other() != null) {
						cell7.setCellValue(record.getR0740_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0740_inward_family() != null) {
						cell9.setCellValue(record.getR0740_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0740_inward_investment() != null) {
						cell10.setCellValue(record.getR0740_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0740_inward_trade() != null) {
						cell11.setCellValue(record.getR0740_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0740_inward_other() != null) {
						cell12.setCellValue(record.getR0740_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row85
					row = sheet.getRow(84);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0760_outward_family() != null) {
						cell4.setCellValue(record.getR0760_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0760_outward_investment() != null) {
						cell5.setCellValue(record.getR0760_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0760_outward_trade() != null) {
						cell6.setCellValue(record.getR0760_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0760_outward_other() != null) {
						cell7.setCellValue(record.getR0760_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0760_inward_family() != null) {
						cell9.setCellValue(record.getR0760_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0760_inward_investment() != null) {
						cell10.setCellValue(record.getR0760_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0760_inward_trade() != null) {
						cell11.setCellValue(record.getR0760_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0760_inward_other() != null) {
						cell12.setCellValue(record.getR0760_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					
					

					//row86
					row = sheet.getRow(85);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0770_outward_family() != null) {
						cell4.setCellValue(record.getR0770_outward_family().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0770_outward_investment() != null) {
						cell5.setCellValue(record.getR0770_outward_investment().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G
					 cell6 = row.createCell(6);
					if (record.getR0770_outward_trade() != null) {
						cell6.setCellValue(record.getR0770_outward_trade().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0770_outward_other() != null) {
						cell7.setCellValue(record.getR0770_outward_other().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column J
					 cell9 = row.createCell(9);
					if (record.getR0770_inward_family() != null) {
						cell9.setCellValue(record.getR0770_inward_family().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0770_inward_investment() != null) {
						cell10.setCellValue(record.getR0770_inward_investment().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0770_inward_trade() != null) {
						cell11.setCellValue(record.getR0770_inward_trade().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0770_inward_other() != null) {
						cell12.setCellValue(record.getR0770_inward_other().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
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
	
	
	public byte[] getBRF9_1DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype, String type, String version) {
	    try {
	        logger.info("Generating Excel for BRF9_1 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF9_1Details");

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
	        List<CBUAE_BRF9_1_Detail_Entity1> reportData = BRF9_1_DETAIL_Repo1.getdatabydateList(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF9_1_Detail_Entity1 item : reportData) {
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
	            logger.info("No data found for BRF9_1 — only header will be written.");
	        }

	        // Write to byte[]
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        workbook.write(bos);
	        workbook.close();

	        logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF9_1 Excel", e);
	        return new byte[0];
	    }
	}
}
