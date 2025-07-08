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

import com.bornfire.brf.entities.CBUAE_BRF1_12SummaryEntitiy;
import com.bornfire.brf.entities.CBUAE_BRF1_12SummaryRepo;
import com.bornfire.brf.entities.CBUAE_BRF1_12_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_12_DETAIL_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_1Summary_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_1_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_1_DETAIL_Repo;

@Component
@Service
public class CBUAE_BRF1_12_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_1_ReportService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF1_12_DETAIL_Repo BRF1_12_DETAIL_Repo;
	
	@Autowired
	CBUAE_BRF1_12SummaryRepo BRF1_12Summary_Repo;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF1_12View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		System.out.println("brf1_12");
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF1_12SummaryEntitiy> T1Master = new ArrayList<CBUAE_BRF1_12SummaryEntitiy>();
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF1_12Summary_Repo.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/CBUAE_BRF1_12");
		
		mv.addObject("reportsummary", T1Master);
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF1_12currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF1_12_DETAIL_ENTITY> T1Dt1 = new ArrayList<CBUAE_BRF1_12_DETAIL_ENTITY>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=BRF1_12_DETAIL_Repo.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		//Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("BRF/CBUAE_BRF1_12");
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
	
	public byte[] getBRF1_12Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		
		List<CBUAE_BRF1_12SummaryEntitiy> T1Master = new ArrayList<CBUAE_BRF1_12SummaryEntitiy>();

		List<CBUAE_BRF1_12SummaryEntitiy> dataList =BRF1_12Summary_Repo.getdatabydateList(dateformat.parse(todate)) ;

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

			int startRow = 9;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF1_12SummaryEntitiy record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

		
					
					  //row10 // Column 4: 
					Cell cell5 = row.createCell(4); 
					if(record.getR0020AverageQualify() != null) {
					  cell5.setCellValue(record.getR0020AverageQualify().doubleValue());
					  cell5.setCellStyle(numberStyle);
					  }
					else { cell5.setCellValue("");
					  cell5.setCellStyle(textStyle);
					  }
					
					// row11
					row = sheet.getRow(10);
					cell5 = row.createCell(4);
					if(record.getR0030AverageQualify() != null) {
					    cell5.setCellValue(record.getR0030AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row12
					row = sheet.getRow(11);
					cell5 = row.createCell(4);
					if(record.getR0040AverageQualify() != null) {
					    cell5.setCellValue(record.getR0040AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row13
					row = sheet.getRow(12);
					cell5 = row.createCell(4);
					if(record.getR0050AverageQualify() != null) {
					    cell5.setCellValue(record.getR0050AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row14
					row = sheet.getRow(13);
					cell5 = row.createCell(4);
					if(record.getR0060AverageQualify() != null) {
					    cell5.setCellValue(record.getR0060AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row15 — skipped

					// row16
					row = sheet.getRow(15);
					cell5 = row.createCell(4);
					if(record.getR0070AverageQualify() != null) {
					    cell5.setCellValue(record.getR0070AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row17
					row = sheet.getRow(16);
					cell5 = row.createCell(4);
					if(record.getR0080AverageQualify() != null) {
					    cell5.setCellValue(record.getR0080AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row18
					row = sheet.getRow(17);
					cell5 = row.createCell(4);
					if(record.getR0090AverageQualify() != null) {
					    cell5.setCellValue(record.getR0090AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row19
					row = sheet.getRow(18);
					cell5 = row.createCell(4);
					if(record.getR0100AverageQualify() != null) {
					    cell5.setCellValue(record.getR0100AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row20
					row = sheet.getRow(19);
					cell5 = row.createCell(4);
					if(record.getR0110AverageQualify() != null) {
					    cell5.setCellValue(record.getR0110AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row21 — skipped

					// row22
					row = sheet.getRow(21);
					cell5 = row.createCell(4);
					if(record.getR0120AverageQualify() != null) {
					    cell5.setCellValue(record.getR0120AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row23
					row = sheet.getRow(22);
					cell5 = row.createCell(4);
					if(record.getR0130AverageQualify() != null) {
					    cell5.setCellValue(record.getR0130AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row24
					row = sheet.getRow(23);
					cell5 = row.createCell(4);
					if(record.getR0140AverageQualify() != null) {
					    cell5.setCellValue(record.getR0140AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row25
					row = sheet.getRow(24);
					cell5 = row.createCell(4);
					if(record.getR0150AverageQualify() != null) {
					    cell5.setCellValue(record.getR0150AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row26
					row = sheet.getRow(25);
					cell5 = row.createCell(4);
					if(record.getR0160AverageQualify() != null) {
					    cell5.setCellValue(record.getR0160AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row27 — skipped

					// row28
					row = sheet.getRow(27);
					cell5 = row.createCell(4);
					if(record.getR0170AverageQualify() != null) {
					    cell5.setCellValue(record.getR0170AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row29
					row = sheet.getRow(28);
					cell5 = row.createCell(4);
					if(record.getR0180AverageQualify() != null) {
					    cell5.setCellValue(record.getR0180AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row30
					row = sheet.getRow(29);
					cell5 = row.createCell(4);
					if(record.getR0190AverageQualify() != null) {
					    cell5.setCellValue(record.getR0190AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row31
					row = sheet.getRow(30);
					cell5 = row.createCell(4);
					if(record.getR0200AverageQualify() != null) {
					    cell5.setCellValue(record.getR0200AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row32
					row = sheet.getRow(31);
					cell5 = row.createCell(4);
					if(record.getR0210AverageQualify() != null) {
					    cell5.setCellValue(record.getR0210AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
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
