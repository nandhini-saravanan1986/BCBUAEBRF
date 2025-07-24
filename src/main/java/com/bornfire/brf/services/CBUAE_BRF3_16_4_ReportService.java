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

import com.bornfire.brf.entities.CBUAE_BRF3_16_4_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF3_16_4_Summary_Repo;

@Component
@Service
public class CBUAE_BRF3_16_4_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF3_16_4_ReportService.class);
	

	@Autowired
	private Environment env;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF3_16_4_Summary_Repo CBUAE_BRF3_16_4_Summary_Repos;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF_16_4View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF_16_4View");
		ModelAndView mv = new ModelAndView();
		if(type.equals("ARCHIVAL")&version!=null) {

			logger.info("Enter if statement");
			List<CBUAE_BRF3_16_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF3_16_4_Summary_Entity>();
		
				 T1Master=CBUAE_BRF3_16_4_Summary_Repos.getdatabydateList();
			
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF3_16_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF3_16_4_Summary_Entity>();

			 T1Master=CBUAE_BRF3_16_4_Summary_Repos.getdatabydateList();

			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF3_16_4");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		logger.info("scv" + mv.getViewName());

		return mv;

	}
	public byte[] getBRF3_16_4Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
	    logger.info("Service: Starting Excel generation process in memory.");

	    List<CBUAE_BRF3_16_4_Summary_Entity> dataList = CBUAE_BRF3_16_4_Summary_Repos.getdatabydateList();

	    if (dataList == null || dataList.isEmpty()) {
	        logger.warn("Service: No data found for Trade Market Risk report. Returning empty result.");
	        return new byte[0];
	    }

	    if (filename == null || filename.isEmpty()) {
	        throw new IllegalArgumentException("Filename is required but was null or empty.");
	    }

	    String templateDir = env.getProperty("output.exportpathtemp");
	    if (templateDir == null || templateDir.isEmpty()) {
	        throw new IllegalStateException("Excel template path property 'output.exportpathtemp' is not configured.");
	    }

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

	        Font font = workbook.createFont();
	        font.setFontHeightInPoints((short) 8);
	        font.setFontName("Arial");

	        CellStyle numberStyle = workbook.createCellStyle();
	        numberStyle.setBorderBottom(BorderStyle.THIN);
	        numberStyle.setBorderTop(BorderStyle.THIN);
	        numberStyle.setBorderLeft(BorderStyle.THIN);
	        numberStyle.setBorderRight(BorderStyle.THIN);
	        numberStyle.setFont(font);

	        int startRow = 11;

	        for (int i = 0; i < dataList.size(); i++) {
	            CBUAE_BRF3_16_4_Summary_Entity record = dataList.get(i);
	            Row row = sheet.getRow(startRow + i);
	            if (row == null) {
	                row = sheet.createRow(startRow + i);
	            }

	            int col = 0;

	            row.createCell(col++).setCellValue(record.getR0010_lfi_type());
	            row.createCell(col++).setCellValue(record.getR0020_lfi_name());
	            row.createCell(col++).setCellValue(record.getR0030_consumer_name());
	            row.createCell(col++).setCellValue(record.getR0040_service_request_number());
	            row.createCell(col++).setCellValue(record.getR0050_people_of_determination());
	            row.createCell(col++).setCellValue(record.getR0060_consumer_type());
	            row.createCell(col++).setCellValue(record.getR0070_residence_type());
	            row.createCell(col++).setCellValue(record.getR0080_emirates_id_only_for_resident_customer());
	            row.createCell(col++).setCellValue(record.getR0090_trade_license_no());
	            row.createCell(col++).setCellValue(record.getR0100_passport_no_for_resident_and_non_resident());
	            row.createCell(col++).setCellValue(record.getR0110_nationality());

	            Cell dobCell = row.createCell(col++);
	            if (record.getR0120_date_of_birth() != null) {
	                dobCell.setCellValue(record.getR0120_date_of_birth());
	                dobCell.setCellStyle(dateStyle);
	            }

	            Cell createDateCell = row.createCell(col++);
	            if (record.getR0130_complaint_creation_date() != null) {
	                createDateCell.setCellValue(record.getR0130_complaint_creation_date());
	                createDateCell.setCellStyle(dateStyle);
	            }

	            Cell closeDateCell = row.createCell(col++);
	            if (record.getR0140_complaint_closure_date() != null) {
	                closeDateCell.setCellValue(record.getR0140_complaint_closure_date());
	                closeDateCell.setCellStyle(dateStyle);
	            }

	            row.createCell(col++).setCellValue(record.getR0150_complaint_ack_duration());
	            row.createCell(col++).setCellValue(record.getR0160_complaint_closure_duration());
	            row.createCell(col++).setCellValue(record.getR0170_status());
	            row.createCell(col++).setCellValue(record.getR0180_complaint_outcome());
	            row.createCell(col++).setCellValue(record.getR0190_product());
	            row.createCell(col++).setCellValue(record.getR0200_category());
	            row.createCell(col++).setCellValue(record.getR0210_complaint_channel());
	            row.createCell(col++).setCellValue(record.getR0220_complaint_description());
	            row.createCell(col++).setCellValue(record.getR0230_root_cause_analysis_yn());
	            row.createCell(col++).setCellValue(record.getR0240_root_cause());
	            row.createCell(col++).setCellValue(record.getR0250_financial_redressal_yes_or_no());

	            Cell redressalValueCell = row.createCell(col++);
	            if (record.getR0260_financial_redressal_value_aed() != null) {
	                redressalValueCell.setCellValue(record.getR0260_financial_redressal_value_aed().doubleValue());
	                redressalValueCell.setCellStyle(numberStyle);
	            }

	            row.createCell(col++).setCellValue(record.getR0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint());
	            row.createCell(col++).setCellValue(record.getR0280_resposible_officer_and_team());
	            row.createCell(col++).setCellValue(record.getR0290_escalated_to_sanadak());
	            row.createCell(col++).setCellValue(record.getR0300_is_the_complaint_pending_in_court());
	            row.createCell(col++).setCellValue(record.getR0310_remarks());
	        }

	        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	        workbook.write(out);
	        logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
	        return out.toByteArray();
	    }
	}


}
