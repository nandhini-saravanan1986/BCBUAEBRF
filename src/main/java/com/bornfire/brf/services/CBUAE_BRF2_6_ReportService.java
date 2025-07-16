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

import com.bornfire.brf.entities.CBUAE_BRF2_4_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_6_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_6_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_6_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_6_Summary_Repo;

@Component
@Service

public class CBUAE_BRF2_6_ReportService {
private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_7_ReportService.class);
	


	@Autowired
	private Environment env;
	

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF2_6_Detail_Repo BRF2_6_DETAIL_REPO;
	
	@Autowired
	CBUAE_BRF2_6_Summary_Repo BRF2_6_SUMMARY_REPO;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF2_6View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF2_6_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_6_Summary_Entity>();
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF2_6_SUMMARY_REPO.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF2_6");
		
		mv.addObject("reportsummary", T1Master);
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF2_6currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF2_6_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF2_6_Detail_Entity>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=BRF2_6_DETAIL_REPO.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		//Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("BRF/BRF2_6");
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

	public byte[] getBRF2_6Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF2_6_Summary_Entity> dataList =BRF2_6_SUMMARY_REPO.getdatabydateList(dateformat.parse(todate)) ;

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.6 report. Returning empty result.");
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

			int startRow = 13;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF2_6_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

		
					//row14
					// Column E 
					Cell cell4 = row.createCell(4);
					if (record.getR0030_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0030_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					Cell cell5 = row.createCell(5);
					if (record.getR0030_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0030_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					Cell cell6 = row.createCell(6);
					if (record.getR0030_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0030_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					Cell cell7 = row.createCell(7);
					if (record.getR0030_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0030_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					Cell cell8 = row.createCell(8);
					if (record.getR0030_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0030_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					Cell cell9 = row.createCell(9);
					if (record.getR0030_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0030_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					Cell cell10 = row.createCell(10);
					if (record.getR0030_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0030_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					Cell cell11 = row.createCell(11);
					if (record.getR0030_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0030_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					Cell cell13 = row.createCell(13);
					if (record.getR0030_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0030_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					Cell cell14 = row.createCell(14);
					if (record.getR0030_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0030_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					Cell cell15 = row.createCell(15);
					if (record.getR0030_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0030_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					Cell cell16 = row.createCell(10);
					if (record.getR0030_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0030_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					Cell cell17 = row.createCell(11);
					if (record.getR0030_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0030_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					Cell cell18 = row.createCell(13);
					if (record.getR0030_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0030_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					Cell cell19 = row.createCell(14);
					if (record.getR0030_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0030_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					Cell cell20 = row.createCell(15);
					if (record.getR0030_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0030_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					//row15
					row = sheet.getRow(14);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0040_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0040_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0040_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0040_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0040_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0040_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0040_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0040_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0040_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0040_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0040_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0040_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0040_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0040_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0040_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0040_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0040_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0040_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0040_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0040_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0040_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0040_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0040_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0040_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0040_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0040_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0040_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0040_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0040_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0040_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0040_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0040_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					//row17
					row = sheet.getRow(16);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0060_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0060_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0060_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0060_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0060_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0060_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0060_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0060_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0060_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0060_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0060_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0060_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0060_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0060_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0060_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0060_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0060_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0060_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0060_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0060_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0060_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0060_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0060_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0060_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0060_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0060_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0060_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0060_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0060_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0060_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0060_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0060_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					
					//row18
					row = sheet.getRow(17);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0070_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0070_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0070_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0070_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0070_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0070_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0070_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0070_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0070_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0070_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0070_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0070_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0070_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0070_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0070_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0070_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0070_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0070_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0070_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0070_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0070_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0070_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0070_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0070_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0070_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0070_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0070_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0070_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0070_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0070_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0070_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0070_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					
					//row20
					row = sheet.getRow(19);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0090_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0090_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0090_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0090_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0090_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0090_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0090_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0090_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0090_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0090_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0090_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0090_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0090_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0090_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0090_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0090_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0090_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0090_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0090_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0090_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0090_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0090_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0090_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0090_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0090_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0090_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0090_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0090_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0090_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0090_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0090_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0090_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					//row21
					row = sheet.getRow(20);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0100_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0100_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0100_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0100_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0100_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0100_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0100_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0100_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0100_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0100_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0100_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0100_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0100_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0100_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0100_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0100_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0100_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0100_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0100_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0100_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0100_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0100_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0100_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0100_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0100_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0100_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0100_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0100_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0100_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0100_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0100_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0100_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					
					//row23
					row = sheet.getRow(22);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0120_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0120_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0120_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0120_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0120_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0120_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0120_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0120_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0120_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0120_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0120_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0120_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0120_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0120_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0120_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0120_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0120_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0120_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0120_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0120_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0120_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0120_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0120_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0120_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0120_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0120_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0120_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0120_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0120_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0120_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0120_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0120_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					
					//row24
					row = sheet.getRow(23);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0130_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0130_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0130_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0130_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0130_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0130_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0130_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0130_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0130_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0130_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0130_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0130_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0130_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0130_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0130_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0130_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0130_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0130_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0130_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0130_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0130_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0130_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0130_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0130_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0130_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0130_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0130_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0130_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0130_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0130_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0130_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0130_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					
					//row26
					row = sheet.getRow(25);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0150_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0150_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0150_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0150_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0150_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0150_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0150_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0150_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0150_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0150_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0150_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0150_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0150_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0150_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0150_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0150_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0150_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0150_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0150_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0150_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0150_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0150_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0150_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0150_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0150_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0150_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0150_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0150_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0150_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0150_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0150_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0150_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
					
					
					//row27
					row = sheet.getRow(26);
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0160_resi_aed_up_to_3_months() != null) {
						cell4.setCellValue(record.getR0160_resi_aed_up_to_3_months().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0160_resi_aed_above_3_and_up_to_6_months() != null) {
						cell5.setCellValue(record.getR0160_resi_aed_above_3_and_up_to_6_months().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0160_resi_aed_above_6_and_up_to_12_months() != null) {
						cell6.setCellValue(record.getR0160_resi_aed_above_6_and_up_to_12_months().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0160_resi_aed_exceeding_12_months() != null) {
						cell7.setCellValue(record.getR0160_resi_aed_exceeding_12_months().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0160_resi_fcy_up_to_3_months() != null) {
						cell8.setCellValue(record.getR0160_resi_fcy_up_to_3_months().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0160_resi_fcy_above_3_and_up_to_6_months() != null) {
						cell9.setCellValue(record.getR0160_resi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0160_resi_fcy_above_6_and_up_to_12_months() != null) {
						cell10.setCellValue(record.getR0160_resi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
			
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0160_resi_fcy_exceeding_12_months() != null) {
						cell11.setCellValue(record.getR0160_resi_fcy_exceeding_12_months().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0160_nonresi_aed_up_to_3_months() != null) {
						cell13.setCellValue(record.getR0160_nonresi_aed_up_to_3_months().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0160_nonresi_aed_above_3_and_up_to_6_months() != null) {
						cell14.setCellValue(record.getR0160_nonresi_aed_above_3_and_up_to_6_months().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
		
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0160_nonresi_aed_above_6_and_up_to_12_months() != null) {
						cell15.setCellValue(record.getR0160_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(10);
					if (record.getR0160_nonresi_aed_exceeding_12_months() != null) {
						cell16.setCellValue(record.getR0160_nonresi_aed_exceeding_12_months().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
				
					// Column R
					 cell17 = row.createCell(11);
					if (record.getR0160_nonresi_fcy_up_to_3_months() != null) {
						cell17.setCellValue(record.getR0160_nonresi_fcy_up_to_3_months().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
					
				
					// Column S
					 cell18 = row.createCell(13);
					if (record.getR0160_nonresi_fcy_above_3_and_up_to_6_months() != null) {
						cell18.setCellValue(record.getR0160_nonresi_fcy_above_3_and_up_to_6_months().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}
					
					
				
					// Column T
					 cell19 = row.createCell(14);
					if (record.getR0160_nonresi_fcy_above_6_and_up_to_12_months() != null) {
						cell19.setCellValue(record.getR0160_nonresi_fcy_above_6_and_up_to_12_months().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
				
					// Column U
					 cell20 = row.createCell(15);
					if (record.getR0160_nonresi_fcy_exceeding_12_months() != null) {
						cell20.setCellValue(record.getR0160_nonresi_aed_above_6_and_up_to_12_months().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
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
