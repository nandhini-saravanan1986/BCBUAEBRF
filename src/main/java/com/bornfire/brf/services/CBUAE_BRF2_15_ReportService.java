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

import com.bornfire.brf.entities.CBUAE_BRF2_15_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_15_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_15_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_15_Summary_Repo;



@Component
@Service

public class CBUAE_BRF2_15_ReportService {
private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_15_ReportService.class);
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF2_15_Detail_Repo BRF2_15_DETAIL_Repo;
	
	@Autowired
	CBUAE_BRF2_15_Summary_Repo BRF2_15_Summary_Repo;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF2_15View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	
		List<CBUAE_BRF2_15_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_15_Summary_Entity>();
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF2_15_Summary_Repo.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
		mv.setViewName("BRF/BRF2_15");
		
		mv.addObject("reportsummary", T1Master);
		//mv.addObject("reportmaster", T1Master);
		System.out.println(T1Master.size());
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());
		return mv;
	}
	
	
	public ModelAndView getBRF2_15currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF2_15_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = BRF2_15_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	            T1Dt1 = BRF2_15_DETAIL_Repo.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF2_15");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}
	
	
	public byte[] getBRF2_15Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		List<CBUAE_BRF2_15_Summary_Entity> dataList =BRF2_15_Summary_Repo.getdatabydateList(dateformat.parse(todate)) ;
		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.15 report. Returning empty result.");
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
					CBUAE_BRF2_15_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}
					
					
					//row13
					// Column E 
					Cell cell4 = row.createCell(4);
					if (record.getR0030_newdep_resi() != null) {
						cell4.setCellValue(record.getR0030_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					//row13
					// Column F 
					Cell cell5 = row.createCell(5);
					if (record.getR0030_minrate_resi() != null) {
						cell5.setCellValue(record.getR0030_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					//row13
					// Column G 
					Cell cell6 = row.createCell(6);
					if (record.getR0030_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0030_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					//row13
					// Column H
					Cell cell7 = row.createCell(7);
					if (record.getR0030_warate_resi() != null) {
						cell7.setCellValue(record.getR0030_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					//row13
					// Column I 
					Cell cell8 = row.createCell(8);
					if (record.getR0030_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0030_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					//row13
					// Column J 
					Cell cell9 = row.createCell(9);
					if (record.getR0030_intexp_resi() != null) {
						cell9.setCellValue(record.getR0030_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
					//row13
					// Column K 
					Cell cell10 = row.createCell(10);
					if (record.getR0030_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0030_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					//row13
					// Column L
					Cell cell11 = row.createCell(11);
					if (record.getR0030_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0030_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					//row13
					// Column M
					Cell cell12 = row.createCell(12);
					if (record.getR0030_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0030_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
					//row13
					// Column N
					Cell cell13 = row.createCell(13);
					if (record.getR0030_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0030_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					//row13
					// Column O
					Cell cell14 = row.createCell(14);
					if (record.getR0030_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0030_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					//row13
					// Column P
					Cell cell15 = row.createCell(15);
					if (record.getR0030_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0030_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
			
					
					
					//row14
					row = sheet.getRow(13);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0040_newdep_resi() != null) {
						cell4.setCellValue(record.getR0040_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0040_minrate_resi() != null) {
						cell5.setCellValue(record.getR0040_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0040_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0040_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0040_warate_resi() != null) {
						cell7.setCellValue(record.getR0040_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0040_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0040_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0040_intexp_resi() != null) {
						cell9.setCellValue(record.getR0040_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0040_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0040_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0040_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0040_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0040_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0040_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0040_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0040_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0040_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0040_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0040_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0040_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row15
					row = sheet.getRow(14);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0050_newdep_resi() != null) {
						cell4.setCellValue(record.getR0050_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0050_minrate_resi() != null) {
						cell5.setCellValue(record.getR0050_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0050_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0050_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0050_warate_resi() != null) {
						cell7.setCellValue(record.getR0050_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0050_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0050_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0050_intexp_resi() != null) {
						cell9.setCellValue(record.getR0050_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0050_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0050_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0050_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0050_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0050_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0050_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0050_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0050_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0050_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0050_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0050_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0050_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					//row16
					row = sheet.getRow(15);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0060_newdep_resi() != null) {
						cell4.setCellValue(record.getR0060_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0060_minrate_resi() != null) {
						cell5.setCellValue(record.getR0060_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0060_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0060_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0060_warate_resi() != null) {
						cell7.setCellValue(record.getR0060_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0060_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0060_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0060_intexp_resi() != null) {
						cell9.setCellValue(record.getR0060_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0060_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0060_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0060_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0060_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0060_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0060_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0060_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0060_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0060_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0060_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0060_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0060_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row17
					row = sheet.getRow(16);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0070_newdep_resi() != null) {
						cell4.setCellValue(record.getR0070_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0070_minrate_resi() != null) {
						cell5.setCellValue(record.getR0070_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0070_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0070_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0070_warate_resi() != null) {
						cell7.setCellValue(record.getR0070_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0070_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0070_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0070_intexp_resi() != null) {
						cell9.setCellValue(record.getR0070_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0070_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0070_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0070_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0070_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0070_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0070_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0070_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0070_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0070_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0070_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0070_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0070_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					//row18
					row = sheet.getRow(17);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0080_newdep_resi() != null) {
						cell4.setCellValue(record.getR0080_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0080_minrate_resi() != null) {
						cell5.setCellValue(record.getR0080_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0080_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0080_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0080_warate_resi() != null) {
						cell7.setCellValue(record.getR0080_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0080_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0080_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0080_intexp_resi() != null) {
						cell9.setCellValue(record.getR0080_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0080_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0080_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0080_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0080_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0080_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0080_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0080_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0080_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0080_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0080_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0080_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0080_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row19
					row = sheet.getRow(18);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0090_newdep_resi() != null) {
						cell4.setCellValue(record.getR0090_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0090_minrate_resi() != null) {
						cell5.setCellValue(record.getR0090_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0090_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0090_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0090_warate_resi() != null) {
						cell7.setCellValue(record.getR0090_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0090_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0090_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0090_intexp_resi() != null) {
						cell9.setCellValue(record.getR0090_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0090_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0090_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0090_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0090_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0090_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0090_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0090_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0090_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0090_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0090_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0090_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0090_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row22
					row = sheet.getRow(21);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0120_newdep_resi() != null) {
						cell4.setCellValue(record.getR0120_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0120_minrate_resi() != null) {
						cell5.setCellValue(record.getR0120_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0120_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0120_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0120_warate_resi() != null) {
						cell7.setCellValue(record.getR0120_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0120_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0120_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0120_intexp_resi() != null) {
						cell9.setCellValue(record.getR0120_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0120_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0120_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0120_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0120_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0120_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0120_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0120_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0120_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0120_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0120_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0120_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0120_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row23
					row = sheet.getRow(22);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0130_newdep_resi() != null) {
						cell4.setCellValue(record.getR0130_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0130_minrate_resi() != null) {
						cell5.setCellValue(record.getR0130_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0130_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0130_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0130_warate_resi() != null) {
						cell7.setCellValue(record.getR0130_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0130_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0130_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0130_intexp_resi() != null) {
						cell9.setCellValue(record.getR0130_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0130_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0130_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0130_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0130_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0130_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0130_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0130_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0130_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0130_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0130_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0130_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0130_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					//row24
					row = sheet.getRow(23);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0140_newdep_resi() != null) {
						cell4.setCellValue(record.getR0140_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0140_minrate_resi() != null) {
						cell5.setCellValue(record.getR0140_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0140_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0140_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0140_warate_resi() != null) {
						cell7.setCellValue(record.getR0140_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0140_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0140_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0140_intexp_resi() != null) {
						cell9.setCellValue(record.getR0140_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0140_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0140_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0140_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0140_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0140_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0140_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0140_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0140_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0140_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0140_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0140_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0140_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row25
					row = sheet.getRow(24);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0150_newdep_resi() != null) {
						cell4.setCellValue(record.getR0150_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0150_minrate_resi() != null) {
						cell5.setCellValue(record.getR0150_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0150_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0150_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0150_warate_resi() != null) {
						cell7.setCellValue(record.getR0150_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0150_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0150_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0150_intexp_resi() != null) {
						cell9.setCellValue(record.getR0150_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0150_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0150_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0150_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0150_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0150_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0150_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0150_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0150_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0150_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0150_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0150_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0150_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row26
					row = sheet.getRow(25);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0160_newdep_resi() != null) {
						cell4.setCellValue(record.getR0160_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0160_minrate_resi() != null) {
						cell5.setCellValue(record.getR0160_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0160_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0160_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0160_warate_resi() != null) {
						cell7.setCellValue(record.getR0160_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0160_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0160_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0160_intexp_resi() != null) {
						cell9.setCellValue(record.getR0160_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0160_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0160_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0160_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0160_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0160_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0160_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0160_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0160_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0160_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0160_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0160_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0160_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row27
					row = sheet.getRow(26);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0170_newdep_resi() != null) {
						cell4.setCellValue(record.getR0170_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0170_minrate_resi() != null) {
						cell5.setCellValue(record.getR0170_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0170_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0170_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0170_warate_resi() != null) {
						cell7.setCellValue(record.getR0170_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0170_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0170_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0170_intexp_resi() != null) {
						cell9.setCellValue(record.getR0170_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0170_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0170_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0170_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0170_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0170_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0170_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0170_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0170_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0170_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0170_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0170_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0170_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row28
					row = sheet.getRow(27);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0180_newdep_resi() != null) {
						cell4.setCellValue(record.getR0180_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0180_minrate_resi() != null) {
						cell5.setCellValue(record.getR0180_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0180_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0180_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0180_warate_resi() != null) {
						cell7.setCellValue(record.getR0180_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0180_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0180_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0180_intexp_resi() != null) {
						cell9.setCellValue(record.getR0180_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0180_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0180_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0180_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0180_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0180_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0180_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0180_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0180_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0180_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0180_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0180_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0180_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row30
					row = sheet.getRow(29);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0200_newdep_resi() != null) {
						cell4.setCellValue(record.getR0200_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0200_minrate_resi() != null) {
						cell5.setCellValue(record.getR0200_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0200_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0200_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0200_warate_resi() != null) {
						cell7.setCellValue(record.getR0200_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0200_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0200_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0200_intexp_resi() != null) {
						cell9.setCellValue(record.getR0200_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0200_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0200_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0200_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0200_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0200_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0200_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0200_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0200_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0200_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0200_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0200_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0200_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row31
					row = sheet.getRow(30);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0210_newdep_resi() != null) {
						cell4.setCellValue(record.getR0210_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0210_minrate_resi() != null) {
						cell5.setCellValue(record.getR0210_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0210_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0210_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0210_warate_resi() != null) {
						cell7.setCellValue(record.getR0210_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0210_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0210_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0210_intexp_resi() != null) {
						cell9.setCellValue(record.getR0210_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0210_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0210_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0210_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0210_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0210_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0210_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0210_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0210_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0210_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0210_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0210_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0210_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row32
					row = sheet.getRow(31);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0220_newdep_resi() != null) {
						cell4.setCellValue(record.getR0220_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0220_minrate_resi() != null) {
						cell5.setCellValue(record.getR0220_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0220_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0220_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0220_warate_resi() != null) {
						cell7.setCellValue(record.getR0220_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0220_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0220_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0220_intexp_resi() != null) {
						cell9.setCellValue(record.getR0220_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0220_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0220_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0220_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0220_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0220_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0220_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0220_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0220_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0220_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0220_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0220_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0220_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row33
					row = sheet.getRow(32);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0230_newdep_resi() != null) {
						cell4.setCellValue(record.getR0230_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0230_minrate_resi() != null) {
						cell5.setCellValue(record.getR0230_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0230_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0230_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0230_warate_resi() != null) {
						cell7.setCellValue(record.getR0230_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0230_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0230_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0230_intexp_resi() != null) {
						cell9.setCellValue(record.getR0230_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0230_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0230_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0230_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0230_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0230_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0230_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0230_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0230_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0230_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0230_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0230_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0230_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row34
					row = sheet.getRow(33);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0240_newdep_resi() != null) {
						cell4.setCellValue(record.getR0240_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0240_minrate_resi() != null) {
						cell5.setCellValue(record.getR0240_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0240_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0240_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0240_warate_resi() != null) {
						cell7.setCellValue(record.getR0240_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0240_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0240_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0240_intexp_resi() != null) {
						cell9.setCellValue(record.getR0240_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0240_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0240_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0240_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0240_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0240_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0240_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0240_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0240_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0240_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0240_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0240_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0240_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row35
					row = sheet.getRow(34);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0250_newdep_resi() != null) {
						cell4.setCellValue(record.getR0250_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0250_minrate_resi() != null) {
						cell5.setCellValue(record.getR0250_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0250_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0250_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0250_warate_resi() != null) {
						cell7.setCellValue(record.getR0250_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0250_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0250_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0250_intexp_resi() != null) {
						cell9.setCellValue(record.getR0250_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0250_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0250_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0250_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0250_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0250_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0250_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0250_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0250_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0250_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0250_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0250_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0250_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row36
					row = sheet.getRow(35);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0260_newdep_resi() != null) {
						cell4.setCellValue(record.getR0260_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0260_minrate_resi() != null) {
						cell5.setCellValue(record.getR0260_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0260_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0260_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0260_warate_resi() != null) {
						cell7.setCellValue(record.getR0260_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0260_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0260_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0260_intexp_resi() != null) {
						cell9.setCellValue(record.getR0260_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0260_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0260_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0260_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0260_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0260_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0260_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0260_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0260_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0260_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0260_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0260_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0260_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					//row38
					row = sheet.getRow(37);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0280_newdep_resi() != null) {
						cell4.setCellValue(record.getR0280_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0280_minrate_resi() != null) {
						cell5.setCellValue(record.getR0280_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0280_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0280_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0280_warate_resi() != null) {
						cell7.setCellValue(record.getR0280_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0280_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0280_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0280_intexp_resi() != null) {
						cell9.setCellValue(record.getR0280_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0280_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0280_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0280_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0280_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0280_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0280_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0280_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0280_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0280_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0280_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0280_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0280_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row39
					row = sheet.getRow(38);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0290_newdep_resi() != null) {
						cell4.setCellValue(record.getR0290_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0290_minrate_resi() != null) {
						cell5.setCellValue(record.getR0290_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0290_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0290_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0290_warate_resi() != null) {
						cell7.setCellValue(record.getR0290_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0290_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0290_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0290_intexp_resi() != null) {
						cell9.setCellValue(record.getR0290_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0290_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0290_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0290_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0290_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0290_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0290_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0290_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0290_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0290_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0290_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0290_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0290_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row40
					row = sheet.getRow(39);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0300_newdep_resi() != null) {
						cell4.setCellValue(record.getR0300_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0300_minrate_resi() != null) {
						cell5.setCellValue(record.getR0300_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0300_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0300_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0300_warate_resi() != null) {
						cell7.setCellValue(record.getR0300_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0300_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0300_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0300_intexp_resi() != null) {
						cell9.setCellValue(record.getR0300_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0300_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0300_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0300_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0300_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0300_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0300_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0300_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0300_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0300_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0300_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0300_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0300_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row41
					row = sheet.getRow(40);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0310_newdep_resi() != null) {
						cell4.setCellValue(record.getR0310_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0310_minrate_resi() != null) {
						cell5.setCellValue(record.getR0310_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0310_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0310_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0310_warate_resi() != null) {
						cell7.setCellValue(record.getR0310_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0310_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0310_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0310_intexp_resi() != null) {
						cell9.setCellValue(record.getR0310_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0310_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0310_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0310_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0310_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0310_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0310_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0310_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0310_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0310_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0310_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0310_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0310_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row42
					row = sheet.getRow(41);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0320_newdep_resi() != null) {
						cell4.setCellValue(record.getR0320_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0320_minrate_resi() != null) {
						cell5.setCellValue(record.getR0320_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0320_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0320_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0320_warate_resi() != null) {
						cell7.setCellValue(record.getR0320_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0320_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0320_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0320_intexp_resi() != null) {
						cell9.setCellValue(record.getR0320_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0320_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0320_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0320_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0320_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0320_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0320_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0320_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0320_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0320_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0320_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0320_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0320_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row43
					row = sheet.getRow(42);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0330_newdep_resi() != null) {
						cell4.setCellValue(record.getR0330_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0330_minrate_resi() != null) {
						cell5.setCellValue(record.getR0330_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0330_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0330_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0330_warate_resi() != null) {
						cell7.setCellValue(record.getR0330_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0330_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0330_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0330_intexp_resi() != null) {
						cell9.setCellValue(record.getR0330_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0330_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0330_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0330_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0330_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0330_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0330_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0330_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0330_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0330_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0330_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0330_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0330_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row44
					row = sheet.getRow(43);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0340_newdep_resi() != null) {
						cell4.setCellValue(record.getR0340_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0340_minrate_resi() != null) {
						cell5.setCellValue(record.getR0340_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0340_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0340_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0340_warate_resi() != null) {
						cell7.setCellValue(record.getR0340_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0340_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0340_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0340_intexp_resi() != null) {
						cell9.setCellValue(record.getR0340_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0340_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0340_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0340_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0340_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0340_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0340_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0340_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0340_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0340_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0340_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0340_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0340_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row46
					row = sheet.getRow(45);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0360_newdep_resi() != null) {
						cell4.setCellValue(record.getR0360_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0360_minrate_resi() != null) {
						cell5.setCellValue(record.getR0360_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0360_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0360_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0360_warate_resi() != null) {
						cell7.setCellValue(record.getR0360_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0360_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0360_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0360_intexp_resi() != null) {
						cell9.setCellValue(record.getR0360_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0360_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0360_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0360_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0360_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0360_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0360_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0360_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0360_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0360_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0360_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0360_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0360_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row47
					row = sheet.getRow(46);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0370_newdep_resi() != null) {
						cell4.setCellValue(record.getR0370_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0370_minrate_resi() != null) {
						cell5.setCellValue(record.getR0370_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0370_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0370_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0370_warate_resi() != null) {
						cell7.setCellValue(record.getR0370_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0370_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0370_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0370_intexp_resi() != null) {
						cell9.setCellValue(record.getR0370_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0370_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0370_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0370_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0370_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0370_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0370_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0370_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0370_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0370_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0370_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0370_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0370_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row48
					row = sheet.getRow(47);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0380_newdep_resi() != null) {
						cell4.setCellValue(record.getR0380_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0380_minrate_resi() != null) {
						cell5.setCellValue(record.getR0380_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0380_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0380_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0380_warate_resi() != null) {
						cell7.setCellValue(record.getR0380_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0380_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0380_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0380_intexp_resi() != null) {
						cell9.setCellValue(record.getR0380_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0380_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0380_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0380_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0380_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0380_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0380_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0380_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0380_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0380_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0380_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0380_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0380_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row49
					row = sheet.getRow(48);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0390_newdep_resi() != null) {
						cell4.setCellValue(record.getR0390_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0390_minrate_resi() != null) {
						cell5.setCellValue(record.getR0390_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0390_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0390_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0390_warate_resi() != null) {
						cell7.setCellValue(record.getR0390_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0390_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0390_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0390_intexp_resi() != null) {
						cell9.setCellValue(record.getR0390_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0390_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0390_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0390_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0390_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0390_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0390_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0390_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0390_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0390_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0390_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0390_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0390_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row50
					row = sheet.getRow(49);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0400_newdep_resi() != null) {
						cell4.setCellValue(record.getR0400_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0400_minrate_resi() != null) {
						cell5.setCellValue(record.getR0400_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0400_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0400_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0400_warate_resi() != null) {
						cell7.setCellValue(record.getR0400_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0400_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0400_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0400_intexp_resi() != null) {
						cell9.setCellValue(record.getR0400_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0400_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0400_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0400_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0400_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0400_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0400_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0400_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0400_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0400_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0400_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0400_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0400_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row51
					row = sheet.getRow(50);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0410_newdep_resi() != null) {
						cell4.setCellValue(record.getR0410_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0410_minrate_resi() != null) {
						cell5.setCellValue(record.getR0410_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0410_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0410_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0410_warate_resi() != null) {
						cell7.setCellValue(record.getR0410_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0410_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0410_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0410_intexp_resi() != null) {
						cell9.setCellValue(record.getR0410_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0410_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0410_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0410_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0410_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0410_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0410_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0410_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0410_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0410_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0410_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0410_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0410_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row52
					row = sheet.getRow(51);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0420_newdep_resi() != null) {
						cell4.setCellValue(record.getR0420_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0420_minrate_resi() != null) {
						cell5.setCellValue(record.getR0420_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0420_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0420_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0420_warate_resi() != null) {
						cell7.setCellValue(record.getR0420_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0420_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0420_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0420_intexp_resi() != null) {
						cell9.setCellValue(record.getR0420_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0420_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0420_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0420_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0420_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0420_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0420_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0420_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0420_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0420_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0420_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0420_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0420_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row55
					row = sheet.getRow(54);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0450_newdep_resi() != null) {
						cell4.setCellValue(record.getR0450_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0450_minrate_resi() != null) {
						cell5.setCellValue(record.getR0450_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0450_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0450_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0450_warate_resi() != null) {
						cell7.setCellValue(record.getR0450_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0450_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0450_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0450_intexp_resi() != null) {
						cell9.setCellValue(record.getR0450_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0450_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0450_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0450_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0450_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0450_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0450_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0450_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0450_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0450_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0450_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0450_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0450_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row56
					row = sheet.getRow(55);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0460_newdep_resi() != null) {
						cell4.setCellValue(record.getR0460_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0460_minrate_resi() != null) {
						cell5.setCellValue(record.getR0460_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0460_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0460_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0460_warate_resi() != null) {
						cell7.setCellValue(record.getR0460_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0460_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0460_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0460_intexp_resi() != null) {
						cell9.setCellValue(record.getR0460_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0460_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0460_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0460_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0460_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0460_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0460_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0460_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0460_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0460_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0460_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0460_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0460_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row58
					row = sheet.getRow(57);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0480_newdep_resi() != null) {
						cell4.setCellValue(record.getR0480_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0480_minrate_resi() != null) {
						cell5.setCellValue(record.getR0480_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0480_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0480_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0480_warate_resi() != null) {
						cell7.setCellValue(record.getR0480_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0480_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0480_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0480_intexp_resi() != null) {
						cell9.setCellValue(record.getR0480_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0480_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0480_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0480_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0480_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0480_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0480_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0480_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0480_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0480_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0480_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0480_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0480_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row59
					row = sheet.getRow(58);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0490_newdep_resi() != null) {
						cell4.setCellValue(record.getR0490_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0490_minrate_resi() != null) {
						cell5.setCellValue(record.getR0490_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0490_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0490_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0490_warate_resi() != null) {
						cell7.setCellValue(record.getR0490_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0490_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0490_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0490_intexp_resi() != null) {
						cell9.setCellValue(record.getR0490_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0490_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0490_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0490_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0490_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0490_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0490_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0490_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0490_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0490_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0490_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0490_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0490_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row61
					row = sheet.getRow(60);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0510_newdep_resi() != null) {
						cell4.setCellValue(record.getR0510_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0510_minrate_resi() != null) {
						cell5.setCellValue(record.getR0510_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0510_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0510_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0510_warate_resi() != null) {
						cell7.setCellValue(record.getR0510_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0510_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0510_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0510_intexp_resi() != null) {
						cell9.setCellValue(record.getR0510_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0510_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0510_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0510_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0510_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0510_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0510_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0510_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0510_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0510_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0510_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0510_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0510_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row62
					row = sheet.getRow(61);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0520_newdep_resi() != null) {
						cell4.setCellValue(record.getR0520_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0520_minrate_resi() != null) {
						cell5.setCellValue(record.getR0520_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0520_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0520_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0520_warate_resi() != null) {
						cell7.setCellValue(record.getR0520_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0520_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0520_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0520_intexp_resi() != null) {
						cell9.setCellValue(record.getR0520_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0520_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0520_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0520_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0520_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0520_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0520_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0520_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0520_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0520_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0520_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0520_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0520_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row64
					row = sheet.getRow(63);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0540_newdep_resi() != null) {
						cell4.setCellValue(record.getR0540_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0540_minrate_resi() != null) {
						cell5.setCellValue(record.getR0540_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0540_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0540_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0540_warate_resi() != null) {
						cell7.setCellValue(record.getR0540_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0540_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0540_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0540_intexp_resi() != null) {
						cell9.setCellValue(record.getR0540_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0540_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0540_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0540_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0540_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0540_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0540_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0540_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0540_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0540_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0540_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0540_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0540_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row65
					row = sheet.getRow(64);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0550_newdep_resi() != null) {
						cell4.setCellValue(record.getR0550_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0550_minrate_resi() != null) {
						cell5.setCellValue(record.getR0550_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0550_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0550_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0550_warate_resi() != null) {
						cell7.setCellValue(record.getR0550_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0550_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0550_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0550_intexp_resi() != null) {
						cell9.setCellValue(record.getR0550_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0550_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0550_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0550_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0550_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0550_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0550_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0550_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0550_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0550_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0550_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0550_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0550_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row67
					row = sheet.getRow(66);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0570_newdep_resi() != null) {
						cell4.setCellValue(record.getR0570_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0570_minrate_resi() != null) {
						cell5.setCellValue(record.getR0570_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0570_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0570_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0570_warate_resi() != null) {
						cell7.setCellValue(record.getR0570_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0570_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0570_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0570_intexp_resi() != null) {
						cell9.setCellValue(record.getR0570_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0570_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0570_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0570_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0570_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0570_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0570_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0570_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0570_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0570_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0570_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0570_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0570_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}
					
					
					
					
					//row68
					row = sheet.getRow(67);
					
					// Column E
					 cell4 = row.createCell(4);
					if (record.getR0580_newdep_resi() != null) {
						cell4.setCellValue(record.getR0580_newdep_resi().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
					
					
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0580_minrate_resi() != null) {
						cell5.setCellValue(record.getR0580_minrate_resi().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
					
					// Column G 
					 cell6 = row.createCell(6);
					if (record.getR0580_maxrate_resi() != null) {
						cell6.setCellValue(record.getR0580_maxrate_resi().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}
					
					
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0580_warate_resi() != null) {
						cell7.setCellValue(record.getR0580_warate_resi().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
				
					// Column I 
					 cell8 = row.createCell(8);
					if (record.getR0580_outstanding_resi() != null) {
						cell8.setCellValue(record.getR0580_outstanding_resi().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column J 
					 cell9 = row.createCell(9);
					if (record.getR0580_intexp_resi() != null) {
						cell9.setCellValue(record.getR0580_intexp_resi().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}
					
					
				
					// Column K 
					 cell10 = row.createCell(10);
					if (record.getR0580_newdep_nonresi() != null) {
						cell10.setCellValue(record.getR0580_newdep_nonresi().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
				
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0580_minrate_nonresi() != null) {
						cell11.setCellValue(record.getR0580_minrate_nonresi().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					// Column M
					 cell12 = row.createCell(12);
					if (record.getR0580_maxrate_nonresi() != null) {
						cell12.setCellValue(record.getR0580_maxrate_nonresi().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}
					
				
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0580_warate_nonresi() != null) {
						cell13.setCellValue(record.getR0580_warate_nonresi().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
					
					
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0580_outstanding_nonresi() != null) {
						cell14.setCellValue(record.getR0580_outstanding_nonresi().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
				
					// Column P
					 cell15 = row.createCell(15);
					if (record.getR0580_intexp_nonresi() != null) {
						cell15.setCellValue(record.getR0580_intexp_nonresi().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
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
	
	
	public byte[] getBRF2_15DetailExcel(String filename, String fromdate, String todate) {
	    try {
	        logger.info("Generating Excel for BRF2_15 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF2_15Details");

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
	        List<CBUAE_BRF2_15_Detail_Entity> reportData = BRF2_15_DETAIL_Repo.getdatabydateList(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF2_15_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF2_15 — only header will be written.");
	        }

	        // Write to byte[]
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        workbook.write(bos);
	        workbook.close();

	        logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF2_15 Excel", e);
	        return new byte[0];
	    }
	}


}
