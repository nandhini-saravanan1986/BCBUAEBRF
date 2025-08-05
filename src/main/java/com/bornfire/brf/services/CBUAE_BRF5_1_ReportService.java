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

import com.bornfire.brf.entities.CBUAE_BRF5_1_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_1_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_1_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_1_Summary_Repo;


@Component
@Service

public class CBUAE_BRF5_1_ReportService {
private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF5_1_ReportService.class);
	


	@Autowired
	private Environment env;
	

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF5_1_Detail_Repo BRF5_1_DETAIL_Repo;
	
	@Autowired
	CBUAE_BRF5_1_Summary_Repo BRF5_1_Summary_Repo;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF5_1View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF5_1_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF5_1_Summary_Entity>();
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF5_1_Summary_Repo.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF5_1");
		
		mv.addObject("reportsummary", T1Master);
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF5_1currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter, String type, String version) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF5_1_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = BRF5_1_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId,  dateformat.parse(todate));
	        } else {
	            T1Dt1 = BRF5_1_DETAIL_Repo.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF5_1");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}
	public byte[] getBRF5_1Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF5_1_Summary_Entity> dataList =BRF5_1_Summary_Repo.getdatabydateList(dateformat.parse(todate)) ;

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF5.1 report. Returning empty result.");
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
					CBUAE_BRF5_1_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

		
					//row13
					// Column E 
					Cell cell4 = row.createCell(4);
					if (record.getR0020_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0020_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					Cell cell5 = row.createCell(5);
					if (record.getR0020_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0020_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					Cell cell7 = row.createCell(7);
					if (record.getR0020_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0020_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					Cell cell8 = row.createCell(8);
					if (record.getR0020_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0020_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					Cell cell10 = row.createCell(10);
					if (record.getR0020_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0020_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					Cell cell11 = row.createCell(11);
					if (record.getR0020_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0020_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					Cell cell13 = row.createCell(13);
					if (record.getR0020_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0020_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					Cell cell14 = row.createCell(14);
					if (record.getR0020_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0020_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					Cell cell16 = row.createCell(16);
					if (record.getR0020_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0020_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					Cell cell17 = row.createCell(17);
					if (record.getR0020_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0020_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					Cell cell19 = row.createCell(19);
					if (record.getR0020_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0020_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					Cell cell20 = row.createCell(20);
					if (record.getR0020_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0020_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					Cell cell22 = row.createCell(22);
					if (record.getR0020_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0020_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					Cell cell23 = row.createCell(23);
					if (record.getR0020_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0020_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					Cell cell25 = row.createCell(25);
					if (record.getR0020_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0020_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					Cell cell26 = row.createCell(26);
					if (record.getR0020_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0020_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					Cell cell28 = row.createCell(28);
					if (record.getR0020_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0020_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					Cell cell29 = row.createCell(29);
					if (record.getR0020_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0020_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					Cell cell31 = row.createCell(31);
					if (record.getR0020_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0020_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					Cell cell32 = row.createCell(32);
					if (record.getR0020_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0020_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					Cell cell34 = row.createCell(34);
					if (record.getR0020_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0020_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					Cell cell35 = row.createCell(35);
					if (record.getR0020_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0020_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					Cell cell37 = row.createCell(37);
					if (record.getR0020_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0020_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					Cell cell38 = row.createCell(38);
					if (record.getR0020_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0020_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					Cell cell40 = row.createCell(40);
					if (record.getR0020_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0020_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					Cell cell41 = row.createCell(41);
					if (record.getR0020_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0020_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					Cell cell43 = row.createCell(43);
					if (record.getR0020_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0020_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					Cell cell44 = row.createCell(44);
					if (record.getR0020_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0020_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					Cell cell46 = row.createCell(46);
					if (record.getR0020_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0020_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					Cell cell47 = row.createCell(47);
					if (record.getR0020_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0020_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					Cell cell49 = row.createCell(49);
					if (record.getR0020_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0020_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					Cell cell50 = row.createCell(50);
					if (record.getR0020_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0020_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row14
					row = sheet.getRow(13);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0030_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0030_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0030_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0030_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0030_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0030_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0030_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0030_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0030_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0030_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0030_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0030_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0030_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0030_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0030_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0030_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0030_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0030_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0030_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0030_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0030_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0030_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0030_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0030_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0030_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0030_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0030_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0030_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0030_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0030_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0030_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0030_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0030_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0030_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0030_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0030_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0030_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0030_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0030_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0030_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0030_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0030_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0030_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0030_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0030_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0030_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0030_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0030_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0030_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0030_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0030_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0030_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0030_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0030_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0030_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0030_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0030_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0030_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0030_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0030_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0030_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0030_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0030_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0030_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row15
					row = sheet.getRow(14);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0040_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0040_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0040_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0040_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0040_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0040_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0040_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0040_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0040_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0040_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0040_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0040_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0040_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0040_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0040_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0040_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0040_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0040_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0040_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0040_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0040_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0040_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0040_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0040_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0040_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0040_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0040_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0040_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0040_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0040_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0040_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0040_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0040_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0040_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0040_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0040_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0040_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0040_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0040_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0040_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0040_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0040_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0040_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0040_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0040_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0040_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0040_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0040_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0040_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0040_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0040_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0040_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0040_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0040_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0040_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0040_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0040_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0040_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0040_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0040_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0040_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0040_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0040_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0040_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row16
					row = sheet.getRow(15);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0050_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0050_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0050_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0050_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0050_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0050_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0050_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0050_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0050_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0050_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0050_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0050_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0050_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0050_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0050_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0050_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0050_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0050_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0050_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0050_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0050_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0050_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0050_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0050_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0050_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0050_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0050_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0050_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0050_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0050_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0050_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0050_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0050_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0050_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0050_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0050_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0050_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0050_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0050_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0050_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0050_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0050_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0050_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0050_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0050_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0050_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0050_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0050_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0050_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0050_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0050_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0050_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0050_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0050_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0050_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0050_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0050_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0050_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0050_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0050_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0050_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0050_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0050_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0050_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row17
					row = sheet.getRow(16);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0060_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0060_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0060_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0060_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0060_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0060_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0060_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0060_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0060_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0060_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0060_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0060_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0060_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0060_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0060_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0060_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0060_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0060_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0060_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0060_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0060_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0060_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0060_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0060_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0060_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0060_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0060_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0060_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0060_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0060_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0060_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0060_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0060_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0060_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0060_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0060_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0060_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0060_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0060_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0060_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0060_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0060_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0060_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0060_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0060_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0060_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0060_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0060_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0060_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0060_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0060_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0060_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0060_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0060_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0060_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0060_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0060_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0060_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0060_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0060_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0060_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0060_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0060_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0060_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row18
					row = sheet.getRow(17);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0070_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0070_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0070_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0070_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0070_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0070_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0070_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0070_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0070_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0070_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0070_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0070_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0070_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0070_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0070_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0070_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0070_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0070_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0070_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0070_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0070_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0070_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0070_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0070_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0070_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0070_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0070_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0070_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0070_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0070_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0070_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0070_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0070_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0070_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0070_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0070_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0070_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0070_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0070_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0070_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0070_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0070_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0070_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0070_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0070_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0070_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0070_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0070_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0070_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0070_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0070_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0070_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0070_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0070_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0070_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0070_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0070_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0070_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0070_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0070_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0070_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0070_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0070_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0070_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row19
					row = sheet.getRow(18);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0080_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0080_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0080_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0080_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0080_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0080_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0080_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0080_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0080_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0080_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0080_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0080_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0080_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0080_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0080_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0080_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0080_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0080_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0080_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0080_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0080_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0080_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0080_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0080_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0080_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0080_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0080_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0080_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0080_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0080_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0080_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0080_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0080_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0080_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0080_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0080_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0080_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0080_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0080_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0080_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0080_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0080_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0080_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0080_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0080_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0080_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0080_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0080_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0080_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0080_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0080_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0080_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0080_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0080_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0080_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0080_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0080_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0080_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0080_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0080_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0080_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0080_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0080_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0080_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row20
					row = sheet.getRow(19);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0090_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0090_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0090_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0090_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0090_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0090_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0090_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0090_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0090_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0090_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0090_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0090_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0090_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0090_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0090_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0090_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0090_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0090_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0090_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0090_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0090_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0090_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0090_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0090_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0090_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0090_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0090_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0090_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0090_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0090_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0090_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0090_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0090_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0090_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0090_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0090_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0090_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0090_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0090_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0090_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0090_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0090_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0090_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0090_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0090_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0090_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0090_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0090_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0090_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0090_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0090_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0090_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0090_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0090_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0090_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0090_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0090_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0090_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0090_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0090_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0090_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0090_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0090_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0090_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row21
					row = sheet.getRow(20);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0100_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0100_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0100_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0100_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0100_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0100_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0100_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0100_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0100_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0100_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0100_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0100_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0100_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0100_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0100_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0100_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0100_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0100_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0100_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0100_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0100_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0100_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0100_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0100_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0100_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0100_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0100_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0100_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0100_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0100_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0100_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0100_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0100_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0100_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0100_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0100_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0100_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0100_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0100_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0100_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0100_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0100_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0100_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0100_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0100_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0100_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0100_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0100_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0100_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0100_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0100_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0100_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0100_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0100_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0100_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0100_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0100_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0100_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0100_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0100_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0100_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0100_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0100_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0100_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					//row23
					row = sheet.getRow(22);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0120_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0120_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0120_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0120_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0120_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0120_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0120_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0120_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0120_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0120_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0120_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0120_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0120_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0120_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0120_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0120_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0120_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0120_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0120_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0120_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0120_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0120_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0120_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0120_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0120_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0120_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0120_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0120_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0120_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0120_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0120_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0120_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0120_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0120_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0120_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0120_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0120_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0120_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0120_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0120_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0120_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0120_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0120_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0120_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0120_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0120_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0120_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0120_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0120_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0120_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0120_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0120_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0120_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0120_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0120_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0120_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0120_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0120_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0120_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0120_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0120_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0120_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0120_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0120_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row24
					row = sheet.getRow(23);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0130_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0130_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0130_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0130_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0130_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0130_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0130_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0130_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0130_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0130_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0130_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0130_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0130_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0130_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0130_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0130_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0130_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0130_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0130_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0130_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0130_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0130_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0130_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0130_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0130_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0130_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0130_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0130_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0130_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0130_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0130_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0130_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0130_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0130_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0130_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0130_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0130_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0130_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0130_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0130_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0130_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0130_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0130_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0130_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0130_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0130_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0130_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0130_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0130_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0130_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0130_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0130_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0130_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0130_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0130_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0130_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0130_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0130_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0130_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0130_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0130_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0130_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0130_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0130_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row25
					row = sheet.getRow(24);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0140_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0140_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0140_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0140_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0140_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0140_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0140_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0140_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0140_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0140_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0140_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0140_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0140_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0140_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0140_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0140_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0140_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0140_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0140_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0140_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0140_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0140_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0140_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0140_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0140_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0140_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0140_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0140_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0140_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0140_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0140_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0140_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0140_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0140_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0140_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0140_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0140_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0140_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0140_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0140_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0140_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0140_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0140_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0140_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0140_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0140_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0140_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0140_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0140_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0140_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0140_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0140_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0140_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0140_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0140_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0140_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0140_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0140_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0140_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0140_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0140_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0140_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0140_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0140_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row26
					row = sheet.getRow(25);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0150_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0150_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0150_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0150_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0150_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0150_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0150_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0150_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0150_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0150_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0150_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0150_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0150_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0150_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0150_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0150_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0150_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0150_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0150_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0150_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0150_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0150_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0150_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0150_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0150_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0150_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0150_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0150_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0150_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0150_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0150_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0150_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0150_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0150_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0150_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0150_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0150_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0150_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0150_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0150_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0150_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0150_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0150_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0150_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0150_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0150_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0150_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0150_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0150_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0150_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0150_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0150_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0150_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0150_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0150_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0150_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0150_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0150_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0150_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0150_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0150_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0150_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0150_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0150_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row27
					row = sheet.getRow(26);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0160_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0160_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0160_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0160_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0160_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0160_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0160_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0160_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0160_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0160_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0160_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0160_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0160_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0160_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0160_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0160_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0160_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0160_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0160_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0160_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0160_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0160_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0160_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0160_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0160_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0160_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0160_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0160_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0160_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0160_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0160_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0160_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0160_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0160_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0160_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0160_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0160_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0160_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0160_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0160_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0160_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0160_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0160_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0160_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0160_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0160_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0160_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0160_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0160_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0160_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0160_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0160_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0160_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0160_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0160_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0160_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0160_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0160_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0160_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0160_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0160_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0160_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0160_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0160_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row28
					row = sheet.getRow(27);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0170_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0170_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0170_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0170_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0170_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0170_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0170_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0170_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0170_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0170_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0170_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0170_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0170_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0170_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0170_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0170_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0170_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0170_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0170_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0170_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0170_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0170_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0170_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0170_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0170_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0170_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0170_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0170_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0170_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0170_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0170_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0170_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0170_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0170_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0170_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0170_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0170_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0170_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0170_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0170_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0170_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0170_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0170_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0170_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0170_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0170_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0170_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0170_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0170_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0170_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0170_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0170_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0170_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0170_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0170_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0170_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0170_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0170_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0170_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0170_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0170_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0170_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0170_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0170_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row29
					row = sheet.getRow(28);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0180_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0180_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0180_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0180_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0180_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0180_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0180_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0180_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0180_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0180_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0180_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0180_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0180_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0180_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0180_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0180_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0180_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0180_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0180_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0180_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0180_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0180_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0180_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0180_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0180_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0180_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0180_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0180_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0180_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0180_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0180_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0180_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0180_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0180_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0180_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0180_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0180_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0180_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0180_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0180_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0180_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0180_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0180_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0180_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0180_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0180_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0180_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0180_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0180_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0180_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0180_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0180_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0180_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0180_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0180_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0180_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0180_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0180_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0180_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0180_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0180_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0180_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0180_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0180_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
					}
					
					
					
					
					//row30
					row = sheet.getRow(29);
					
					
					// Column E 
					 cell4 = row.createCell(4);
					if (record.getR0190_resi_aed_nos_male() != null) {
						cell4.setCellValue(record.getR0190_resi_aed_nos_male().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}
					
				
					// Column F 
					 cell5 = row.createCell(5);
					if (record.getR0190_resi_aed_nos_female() != null) {
						cell5.setCellValue(record.getR0190_resi_aed_nos_female().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}
					
					
				
					// Column H
					 cell7 = row.createCell(7);
					if (record.getR0190_resi_aed_amount_male() != null) {
						cell7.setCellValue(record.getR0190_resi_aed_amount_male().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}
					
					
					// Column I
					 cell8 = row.createCell(8);
					if (record.getR0190_resi_aed_amount_female() != null) {
						cell8.setCellValue(record.getR0190_resi_aed_amount_female().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}
					
					
					// Column K
					 cell10 = row.createCell(10);
					if (record.getR0190_resi_foreign_ccy_nos_male() != null) {
						cell10.setCellValue(record.getR0190_resi_foreign_ccy_nos_male().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}
					
					
					// Column L
					 cell11 = row.createCell(11);
					if (record.getR0190_resi_foreign_ccy_nos_female() != null) {
						cell11.setCellValue(record.getR0190_resi_foreign_ccy_nos_female().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}
					
					
					
					// Column N
					 cell13 = row.createCell(13);
					if (record.getR0190_resi_foreign_ccy_amount_male() != null) {
						cell13.setCellValue(record.getR0190_resi_foreign_ccy_amount_male().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}
					
			
					// Column O
					 cell14 = row.createCell(14);
					if (record.getR0190_resi_foreign_ccy_amount_female() != null) {
						cell14.setCellValue(record.getR0190_resi_foreign_ccy_amount_female().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}
					
					
				
					// Column Q
					 cell16 = row.createCell(16);
					if (record.getR0190_resi_newloans_in_repo_peri_nos_male() != null) {
						cell16.setCellValue(record.getR0190_resi_newloans_in_repo_peri_nos_male().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}
					
					
					
					// Column R
					 cell17 = row.createCell(17);
					if (record.getR0190_resi_newloans_in_repo_peri_nos_female() != null) {
						cell17.setCellValue(record.getR0190_resi_newloans_in_repo_peri_nos_female().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}
					
		
					// Column T
					 cell19 = row.createCell(19);
					if (record.getR0190_resi_newloans_in_repo_peri_amount_male() != null) {
						cell19.setCellValue(record.getR0190_resi_newloans_in_repo_peri_amount_male().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}
					
					
				
					// Column U
					 cell20 = row.createCell(20);
					if (record.getR0190_resi_newloans_in_repo_peri_amount_female() != null) {
						cell20.setCellValue(record.getR0190_resi_newloans_in_repo_peri_amount_female().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}
					
				
					// Column W
					 cell22 = row.createCell(22);
					if (record.getR0190_resi_loans_classifi_under_stage3_nos_male() != null) {
						cell22.setCellValue(record.getR0190_resi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}
					
					
				
					// Column X
					 cell23 = row.createCell(23);
					if (record.getR0190_resi_loans_classifi_under_stage3_nos_female() != null) {
						cell23.setCellValue(record.getR0190_resi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}
					
					
				
					// Column Z
					 cell25 = row.createCell(25);
					if (record.getR0190_resi_loans_classifi_under_stage3_amount_male() != null) {
						cell25.setCellValue(record.getR0190_resi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}
					
				
					// Column AA
					 cell26 = row.createCell(26);
					if (record.getR0190_resi_loans_classifi_under_stage3_amount_female() != null) {
						cell26.setCellValue(record.getR0190_resi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AC
					 cell28 = row.createCell(28);
					if (record.getR0190_nonresi_aed_nos_male() != null) {
						cell28.setCellValue(record.getR0190_nonresi_aed_nos_male().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}
					
					
					// Column AD
					 cell29 = row.createCell(29);
					if (record.getR0190_nonresi_aed_nos_female() != null) {
						cell29.setCellValue(record.getR0190_nonresi_aed_nos_female().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}
					
					
					// Column AF
					 cell31 = row.createCell(31);
					if (record.getR0190_nonresi_aed_amount_male() != null) {
						cell31.setCellValue(record.getR0190_nonresi_aed_amount_male().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}
					
					
					// Column AG
					 cell32 = row.createCell(32);
					if (record.getR0190_nonresi_aed_amount_female() != null) {
						cell32.setCellValue(record.getR0190_nonresi_aed_amount_female().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}
					
					
					// Column AI
					 cell34 = row.createCell(34);
					if (record.getR0190_nonresi_foreign_ccy_nos_male() != null) {
						cell34.setCellValue(record.getR0190_nonresi_foreign_ccy_nos_male().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}
					
					
					// Column AJ
					 cell35 = row.createCell(35);
					if (record.getR0190_nonresi_foreign_ccy_nos_female() != null) {
						cell35.setCellValue(record.getR0190_nonresi_foreign_ccy_nos_female().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell26.setCellStyle(textStyle);
					}
					
					
					// Column AL
					 cell37 = row.createCell(37);
					if (record.getR0190_nonresi_foreign_ccy_amount_male() != null) {
						cell37.setCellValue(record.getR0190_nonresi_foreign_ccy_amount_male().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}
					
					
					// Column AM
					 cell38 = row.createCell(38);
					if (record.getR0190_nonresi_foreign_ccy_amount_female() != null) {
						cell38.setCellValue(record.getR0190_nonresi_foreign_ccy_amount_female().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}
					
					
					// Column AO
					 cell40 = row.createCell(40);
					if (record.getR0190_nonresi_newloans_in_repo_peri_nos_male() != null) {
						cell40.setCellValue(record.getR0190_nonresi_newloans_in_repo_peri_nos_male().doubleValue());
						cell40.setCellStyle(numberStyle);
					} else {
						cell40.setCellValue("");
						cell40.setCellStyle(textStyle);
					}
					
					
					
					// Column AP
					 cell41 = row.createCell(41);
					if (record.getR0190_nonresi_newloans_in_repo_peri_nos_female() != null) {
						cell41.setCellValue(record.getR0190_nonresi_newloans_in_repo_peri_nos_female().doubleValue());
						cell41.setCellStyle(numberStyle);
					} else {
						cell41.setCellValue("");
						cell41.setCellStyle(textStyle);
					}
					
					
					// Column AR
					 cell43 = row.createCell(43);
					if (record.getR0190_nonresi_newloans_in_repo_peri_amount_male() != null) {
						cell43.setCellValue(record.getR0190_nonresi_newloans_in_repo_peri_amount_male().doubleValue());
						cell43.setCellStyle(numberStyle);
					} else {
						cell43.setCellValue("");
						cell43.setCellStyle(textStyle);
					}
					
					
					

					// Column AS
					 cell44 = row.createCell(44);
					if (record.getR0190_nonresi_newloans_in_repo_peri_amount_female() != null) {
						cell44.setCellValue(record.getR0190_nonresi_newloans_in_repo_peri_amount_female().doubleValue());
						cell44.setCellStyle(numberStyle);
					} else {
						cell44.setCellValue("");
						cell44.setCellStyle(textStyle);
					}
					
					
					// Column AU
					 cell46 = row.createCell(46);
					if (record.getR0190_nonresi_loans_classifi_under_stage3_nos_male() != null) {
						cell46.setCellValue(record.getR0190_nonresi_loans_classifi_under_stage3_nos_male().doubleValue());
						cell46.setCellStyle(numberStyle);
					} else {
						cell46.setCellValue("");
						cell46.setCellStyle(textStyle);
					}
					
					
					// Column AV
					 cell47 = row.createCell(47);
					if (record.getR0190_nonresi_loans_classifi_under_stage3_nos_female() != null) {
						cell47.setCellValue(record.getR0190_nonresi_loans_classifi_under_stage3_nos_female().doubleValue());
						cell47.setCellStyle(numberStyle);
					} else {
						cell47.setCellValue("");
						cell47.setCellStyle(textStyle);
					}
					
					
					// Column AX
					 cell49 = row.createCell(49);
					if (record.getR0190_nonresi_loans_classifi_under_stage3_amount_male() != null) {
						cell49.setCellValue(record.getR0190_nonresi_loans_classifi_under_stage3_amount_male().doubleValue());
						cell49.setCellStyle(numberStyle);
					} else {
						cell49.setCellValue("");
						cell49.setCellStyle(textStyle);
					}
					
					
					
					// Column AY
					 cell50 = row.createCell(50);
					if (record.getR0190_nonresi_loans_classifi_under_stage3_amount_female() != null) {
						cell50.setCellValue(record.getR0190_nonresi_loans_classifi_under_stage3_amount_female().doubleValue());
						cell50.setCellStyle(numberStyle);
					} else {
						cell50.setCellValue("");
						cell50.setCellStyle(textStyle);
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
	
	
	public byte[] getBRF5_1DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype, String type, String version) {
	    try {
	        logger.info("Generating Excel for BRF5_1 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF5_1Details");

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
	        List<CBUAE_BRF5_1_Detail_Entity> reportData = BRF5_1_DETAIL_Repo.getdatabydateList(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF5_1_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF5_1 — only header will be written.");
	        }

	        // Write to byte[]
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        workbook.write(bos);
	        workbook.close();

	        logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF5_1 Excel", e);
	        return new byte[0];
	    }
	}
	

}
