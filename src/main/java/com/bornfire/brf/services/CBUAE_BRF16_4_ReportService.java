package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
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
import org.apache.poi.ss.usermodel.HorizontalAlignment;
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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF16_4_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF16_4_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF16_4_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF16_4_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_15_Detail_Entity;

@Component
@Service
public class CBUAE_BRF16_4_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF16_4_ReportService.class);
	

	@Autowired
	private Environment env;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CBUAE_BRF16_4_Summary_Repo CBUAE_BRF16_4_Summary_Repos;
	@Autowired
	CBUAE_BRF16_4_Detail_Repo CBUAE_BRF16_4_Detail_Repos;
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF_16_4View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		logger.info("getBRF_16_4View...");
		ModelAndView mv = new ModelAndView();
		if(type.equals("ARCHIVAL")&version!=null) {

			logger.info("Enter if statement");
			List<CBUAE_BRF16_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF16_4_Summary_Entity>();
		
				 T1Master=CBUAE_BRF16_4_Summary_Repos.getdatabydateList();
			
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF16_4_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF16_4_Summary_Entity>();

			 T1Master=CBUAE_BRF16_4_Summary_Repos.getdatabydateList();

			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF16_4");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		mv.addObject("reportid", "BRF16_4");
		logger.info("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF16_4currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF16_4_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	        	logger.info("enter if block");
	            T1Dt1 = CBUAE_BRF16_4_Detail_Repos.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	        	logger.info("enter else block");
	            T1Dt1 = CBUAE_BRF16_4_Detail_Repos.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF16_4");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}
	public byte[] getBRF16_4Excel(String filename, String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {

	    try {
	        List<CBUAE_BRF16_4_Summary_Entity> dataList = CBUAE_BRF16_4_Summary_Repos.getdatabydateList();

	        if (dataList.isEmpty()) {
	            logger.warn("No data found for BRF16.4 report.");
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
			try (InputStream templateInputStream = Files.newInputStream(templatePath);
					Workbook workbook = WorkbookFactory.create(templateInputStream);
					ByteArrayOutputStream out = new ByteArrayOutputStream()) {

	            Sheet sheet = workbook.getSheetAt(0);
	            CreationHelper createHelper = workbook.getCreationHelper();

	            CellStyle dateStyle = workbook.createCellStyle();
	            dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	            CellStyle centerStyle = workbook.createCellStyle();
	            centerStyle.setAlignment(HorizontalAlignment.CENTER);

	            CellStyle leftStyle = workbook.createCellStyle();
	            leftStyle.setAlignment(HorizontalAlignment.LEFT);


	            int startCol = 3;     // Column D (0-based)
	            int startRow = 7;     // 8th row (0-based)
	            int notesRow = 10;    // "Notes:-" is at 11th row (Excel)

	            // Step 1: Shift "Notes:-" and below to make space for data rows
	            if (sheet.getLastRowNum() >= notesRow) {
	                sheet.shiftRows(notesRow, sheet.getLastRowNum(), dataList.size());
	            }

	            // Step 2: Write data rows before the "Notes:-"
	            for (int i = 0; i < dataList.size(); i++) {
	                CBUAE_BRF16_4_Summary_Entity record = dataList.get(i);
	                Row row = sheet.getRow(startRow + i);
	                if (row == null) row = sheet.createRow(startRow + i);

	                int col = startCol;

	                // Column B - Serial Number (starts from 0010)
	                Cell serialCell = row.createCell(1);
	                serialCell.setCellValue(String.format("%04d", (i + 1) * 10));
	                serialCell.setCellStyle(centerStyle);

	                // Column C - ID
	                row.createCell(2).setCellValue(record.getId());

	                // Column D onwards
	                Cell lfi_type = row.createCell(col++);
	                lfi_type.setCellValue(record.getR0010_lfi_type());
	                lfi_type.setCellStyle(leftStyle);

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

	                Cell dob = row.createCell(col++);
	                if (record.getR0120_date_of_birth() != null) {
	                    dob.setCellValue(record.getR0120_date_of_birth());
	                    dob.setCellStyle(dateStyle);
	                }

	                Cell created = row.createCell(col++);
	                if (record.getR0130_complaint_creation_date() != null) {
	                    created.setCellValue(record.getR0130_complaint_creation_date());
	                    created.setCellStyle(dateStyle);
	                }

	                Cell closed = row.createCell(col++);
	                if (record.getR0140_complaint_closure_date() != null) {
	                    closed.setCellValue(record.getR0140_complaint_closure_date());
	                    closed.setCellStyle(dateStyle);
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

	                Cell redressal = row.createCell(col++);
	                if (record.getR0260_financial_redressal_value_aed() != null) {
	                    redressal.setCellValue(record.getR0260_financial_redressal_value_aed().doubleValue());
	                }

	                row.createCell(col++).setCellValue(record.getR0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint());
	                row.createCell(col++).setCellValue(record.getR0280_resposible_officer_and_team());
	                row.createCell(col++).setCellValue(record.getR0290_escalated_to_sanadak());
	                row.createCell(col++).setCellValue(record.getR0300_is_the_complaint_pending_in_court());
	                row.createCell(col++).setCellValue(record.getR0310_remarks());
	            }


	            workbook.write(out);
	            return out.toByteArray();
	        }

	    } catch (Exception e) {
	        logger.error("Error generating BRF16.4 Excel file", e);
	        throw e;
	    }
	}


}
