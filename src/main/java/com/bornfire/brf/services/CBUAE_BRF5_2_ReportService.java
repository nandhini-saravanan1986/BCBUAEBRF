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
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF5_2_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Archival_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Archival_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Archival_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Archival_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Archival_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_2_Summary_Repo2;

@Component
@Service
public class CBUAE_BRF5_2_ReportService {
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF5_2_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF5_2_Summary_Archival_Repo1 BRF5_2_Summary_Archival_Repo1;

	@Autowired
	CBUAE_BRF5_2_Summary_Archival_Repo2 BRF5_2_Summary_Archival_Repo2;

	@Autowired
	CBUAE_BRF5_2_Archival_Detail_Repo BRF5_2_archival_detail_repo;

	@Autowired
	CBUAE_BRF5_2_Detail_Repo BRF5_2_Detail_Repo;

	@Autowired
	CBUAE_BRF5_2_Summary_Repo1 BRF5_2_Summary_Repo1;

	@Autowired
	CBUAE_BRF5_2_Summary_Repo2 BRF5_2_Summary_Repo2;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF5_2View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {
		logger.info("Generating view for BRF5_2");
		ModelAndView mv = new ModelAndView();

		if ("ARCHIVAL".equals(type) && version != null) {
			List<CBUAE_BRF5_2_Summary_Archival_Entity1> T1Master = new ArrayList<>();
			List<CBUAE_BRF5_2_Summary_Archival_Entity2> T1Master1 = new ArrayList<>();
			try {
				Date reportDate = dateformat.parse(todate);
				T1Master = BRF5_2_Summary_Archival_Repo1.getdatabydateListarchival(reportDate, version);
				T1Master1 = BRF5_2_Summary_Archival_Repo2.getdatabydateListarchival(reportDate, version);
			} catch (ParseException e) {
				logger.error("Error parsing date for archival view: {}", e.getMessage());
			}
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
		} else {
			List<CBUAE_BRF5_2_Summary_Entity1> T1Master = new ArrayList<>();
			List<CBUAE_BRF5_2_Summary_Entity2> T1Master1 = new ArrayList<>();
			try {
				Date reportDate = dateformat.parse(todate);
				T1Master = BRF5_2_Summary_Repo1.getdatabydateList(reportDate);
				T1Master1 = BRF5_2_Summary_Repo2.getdatabydateList(reportDate);
			} catch (ParseException e) {
				logger.error("Error parsing date for current view: {}", e.getMessage());
			}
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
		}

		mv.setViewName("BRF/BRF5_2");
		mv.addObject("displaymode", "summary");
		logger.info("View name set to: {}", mv.getViewName());
		return mv;
	}

	public ModelAndView getBRF5_2currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		ModelAndView mv = new ModelAndView();
		try {
			Date reportDate = dateformat.parse(todate);
			String rowId = null;
			String columnId = null;

			if (filter != null && filter.contains(",")) {
				String[] parts = filter.split(",");
				if (parts.length >= 2) {
					rowId = parts[0];
					columnId = parts[1];
				}
			}

			if ("ARCHIVAL".equals(type) && version != null) {
				List<CBUAE_BRF5_2_Archival_Detail_Entity> details;
				if (rowId != null && columnId != null) {
					details = BRF5_2_archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId, reportDate, version);
				} else {
					details = BRF5_2_archival_detail_repo.getdatabydateList(reportDate, version);
				}
				mv.addObject("reportdetails", details);
			} else {
				List<CBUAE_BRF5_2_Detail_Entity> details;
				if (rowId != null && columnId != null) {
					details = BRF5_2_Detail_Repo.GetDataByRowIdAndColumnId(rowId, columnId, reportDate);
				} else {
					details = BRF5_2_Detail_Repo.getdatabydateList(reportDate);
				}
				mv.addObject("reportdetails", details);
			}
		} catch (ParseException e) {
			logger.error("Error parsing date for detail view: {}", e.getMessage());
		}

		mv.setViewName("BRF/BRF5_2");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public byte[] getBRF5_2Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {

		logger.info("Service: Starting Excel generation process in memory for type: {}", type);

		if ("ARCHIVAL".equals(type) && version != null) {
			return getBRF5_2ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype, type, version);
		}

		List<CBUAE_BRF5_2_Summary_Entity1> dataList = BRF5_2_Summary_Repo1.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_2_Summary_Entity2> dataList1 = BRF5_2_Summary_Repo2.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty() && dataList1.isEmpty()) {
			logger.warn("Service: No data found for BRF5.2 report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		Path templatePath = Paths.get(templateDir, filename);
		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException("Template file not readable: " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(0);

			// --- Style Definitions ---
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
			// --- End of Style Definitions ---

			if (!dataList.isEmpty()) {
				populateEntity1Data(sheet, dataList.get(0), textStyle, numberStyle);
			}

			if (!dataList1.isEmpty()) {
				populateEntity2Data(sheet, dataList1.get(0), textStyle, numberStyle);
			}

			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
			return out.toByteArray();
		}
	}

	private void populateEntity1Data(Sheet sheet, CBUAE_BRF5_2_Summary_Entity1 record, CellStyle textStyle, CellStyle numberStyle) {
	    	    
	    // R0020 - ROW 10 (Index 9)
	    Row row = sheet.getRow(9) != null ? sheet.getRow(9) : sheet.createRow(9);	    
	  /// ROW10
		//// Column D
		Cell cell3 = row.createCell(3);
		if (record.getR0020_borrower_name() != null && !record.getR0020_borrower_name().isEmpty()) {
			cell3.setCellValue(record.getR0020_borrower_name());
			cell3.setCellStyle(textStyle);
		} else {
			cell3.setCellValue("");
			cell3.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column E
		Cell cell4 = row.createCell(4);
		if (record.getR0020_group_name_if_applicable() != null
				&& !record.getR0020_group_name_if_applicable().isEmpty()) {
			cell4.setCellValue(record.getR0020_group_name_if_applicable());
			cell4.setCellStyle(textStyle);
		} else {
			cell4.setCellValue("");
			cell4.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column F
		Cell cell5 = row.createCell(5);
		if (record.getR0020_cin() != null && !record.getR0020_cin().isEmpty()) {
			cell5.setCellValue(record.getR0020_cin());
			cell5.setCellStyle(textStyle);
		} else {
			cell5.setCellValue("");
			cell5.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column G
		Cell cell6 = row.createCell(6);
		if (record.getR0020_domicile_country() != null && !record.getR0020_domicile_country().isEmpty()) {
			cell6.setCellValue(record.getR0020_domicile_country());
			cell6.setCellStyle(textStyle);
		} else {
			cell6.setCellValue("");
			cell6.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column H
		Cell cell7 = row.createCell(7);
		if (record.getR0020_funded_outstanding_amount() != null) {
			cell7.setCellValue(record.getR0020_funded_outstanding_amount().doubleValue());
			cell7.setCellStyle(numberStyle);
		} else {
			cell7.setCellValue("");
			cell7.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column I
		Cell cell8 = row.createCell(8);
		if (record.getR0020_ccf_unfunded_outstanding_amount() != null) {
			cell8.setCellValue(record.getR0020_ccf_unfunded_outstanding_amount().doubleValue());
			cell8.setCellStyle(numberStyle);
		} else {
			cell8.setCellValue("");
			cell8.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column J
		Cell cell9 = row.createCell(9);
		if (record.getR0020_secured_portion_exposure() != null) {
			cell9.setCellValue(record.getR0020_secured_portion_exposure().doubleValue());
			cell9.setCellStyle(numberStyle);
		} else {
			cell9.setCellValue("");
			cell9.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column K
		Cell cell10 = row.createCell(10);
		if (record.getR0020_post_collateral_haircut() != null) {
			cell10.setCellValue(record.getR0020_post_collateral_haircut().doubleValue());
			cell10.setCellStyle(numberStyle);
		} else {
			cell10.setCellValue("");
			cell10.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column L
		Cell cell11 = row.createCell(11);
		if (record.getR0020_type_of_security() != null) {
			cell11.setCellValue(record.getR0020_type_of_security().doubleValue());
			cell11.setCellStyle(numberStyle);
		} else {
			cell11.setCellValue("");
			cell11.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column M
		Cell cell12 = row.createCell(12);
		if (record.getR0020_discounted_collateral_value() != null) {
			cell12.setCellValue(record.getR0020_discounted_collateral_value().doubleValue());
			cell12.setCellStyle(numberStyle);
		} else {
			cell12.setCellValue("");
			cell12.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column N
		Cell cell13 = row.createCell(13);
		if (record.getR0020_validated_discounted_cashflows() != null) {
			cell13.setCellValue(record.getR0020_validated_discounted_cashflows().doubleValue());
			cell13.setCellStyle(numberStyle);
		} else {
			cell13.setCellValue("");
			cell13.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column O
		Cell cell14 = row.createCell(14);
		if (record.getR0020_pd() != null) {
			cell14.setCellValue(record.getR0020_pd().doubleValue());
			cell14.setCellStyle(numberStyle);
		} else {
			cell14.setCellValue("");
			cell14.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column P
		Cell cell15 = row.createCell(15);
		if (record.getR0020_lgd() != null) {
			cell15.setCellValue(record.getR0020_lgd().doubleValue());
			cell15.setCellStyle(numberStyle);
		} else {
			cell15.setCellValue("");
			cell15.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column Q
		Cell cell16 = row.createCell(16);
		if (record.getR0020_provisions_charged_pnl() != null) {
			cell16.setCellValue(record.getR0020_provisions_charged_pnl().doubleValue());
			cell16.setCellStyle(numberStyle);
		} else {
			cell16.setCellValue("");
			cell16.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column R
		Cell cell17 = row.createCell(17);
		if (record.getR0020_legacy_interest_profit_suspense() != null) {
			cell17.setCellValue(record.getR0020_legacy_interest_profit_suspense().doubleValue());
			cell17.setCellStyle(numberStyle);
		} else {
			cell17.setCellValue("");
			cell17.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column S
		Cell cell18 = row.createCell(18);
		if (record.getR0020_legal_case_yn() != null && !record.getR0020_legal_case_yn().isEmpty()) {
			cell18.setCellValue(record.getR0020_legal_case_yn());
			cell18.setCellStyle(textStyle);
		} else {
			cell18.setCellValue("");
			cell18.setCellStyle(textStyle);
		}

		/// ROW10
		//// Column T
		Cell cell19 = row.createCell(19);
		if (record.getR0020_remarks_if_any() != null && !record.getR0020_remarks_if_any().isEmpty()) {
			cell19.setCellValue(record.getR0020_remarks_if_any());
			cell19.setCellStyle(textStyle);
		} else {
			cell19.setCellValue("");
			cell19.setCellStyle(textStyle);
		}
		/// ROW11
		row = sheet.getRow(10);
		//// Column D
		Cell R0030cell3 = row.createCell(3);
		if (record.getR0030_borrower_name() != null && !record.getR0030_borrower_name().isEmpty()) {
			R0030cell3.setCellValue(record.getR0030_borrower_name());
			R0030cell3.setCellStyle(textStyle);
		} else {
			R0030cell3.setCellValue("");
			R0030cell3.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column E
		Cell R0030cell4 = row.createCell(4);
		if (record.getR0030_group_name_if_applicable() != null
				&& !record.getR0030_group_name_if_applicable().isEmpty()) {
			R0030cell4.setCellValue(record.getR0030_group_name_if_applicable());
			R0030cell4.setCellStyle(textStyle);
		} else {
			R0030cell4.setCellValue("");
			R0030cell4.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column F
		Cell R0030cell5 = row.createCell(5);
		if (record.getR0030_cin() != null && !record.getR0030_cin().isEmpty()) {
			R0030cell5.setCellValue(record.getR0030_cin());
			R0030cell5.setCellStyle(textStyle);
		} else {
			R0030cell5.setCellValue("");
			R0030cell5.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column G
		Cell R0030cell6 = row.createCell(6);
		if (record.getR0030_domicile_country() != null && !record.getR0030_domicile_country().isEmpty()) {
			R0030cell6.setCellValue(record.getR0030_domicile_country());
			R0030cell6.setCellStyle(textStyle);
		} else {
			R0030cell6.setCellValue("");
			R0030cell6.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column H
		Cell R0030cell7 = row.createCell(7);
		if (record.getR0030_funded_outstanding_amount() != null) {
			R0030cell7.setCellValue(record.getR0030_funded_outstanding_amount().doubleValue());
			R0030cell7.setCellStyle(numberStyle);
		} else {
			R0030cell7.setCellValue("");
			R0030cell7.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column I
		Cell R0030cell8 = row.createCell(8);
		if (record.getR0030_ccf_unfunded_outstanding_amount() != null) {
			R0030cell8.setCellValue(record.getR0030_ccf_unfunded_outstanding_amount().doubleValue());
			R0030cell8.setCellStyle(numberStyle);
		} else {
			R0030cell8.setCellValue("");
			R0030cell8.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column J
		Cell R0030cell9 = row.createCell(9);
		if (record.getR0030_secured_portion_exposure() != null) {
			R0030cell9.setCellValue(record.getR0030_secured_portion_exposure().doubleValue());
			R0030cell9.setCellStyle(numberStyle);
		} else {
			R0030cell9.setCellValue("");
			R0030cell9.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column K
		Cell R0030cell10 = row.createCell(10);
		if (record.getR0030_post_collateral_haircut() != null) {
			R0030cell10.setCellValue(record.getR0030_post_collateral_haircut().doubleValue());
			R0030cell10.setCellStyle(numberStyle);
		} else {
			R0030cell10.setCellValue("");
			R0030cell10.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column L
		Cell R0030cell11 = row.createCell(11);
		if (record.getR0030_type_of_security() != null) {
			R0030cell11.setCellValue(record.getR0030_type_of_security().doubleValue());
			R0030cell11.setCellStyle(numberStyle);
		} else {
			R0030cell11.setCellValue("");
			R0030cell11.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column M
		Cell R0030cell12 = row.createCell(12);
		if (record.getR0030_discounted_collateral_value() != null) {
			R0030cell12.setCellValue(record.getR0030_discounted_collateral_value().doubleValue());
			R0030cell12.setCellStyle(numberStyle);
		} else {
			R0030cell12.setCellValue("");
			R0030cell12.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column N
		Cell R0030cell13 = row.createCell(13);
		if (record.getR0030_validated_discounted_cashflows() != null) {
			R0030cell13.setCellValue(record.getR0030_validated_discounted_cashflows().doubleValue());
			R0030cell13.setCellStyle(numberStyle);
		} else {
			R0030cell13.setCellValue("");
			R0030cell13.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column O
		Cell R0030cell14 = row.createCell(14);
		if (record.getR0030_pd() != null) {
			R0030cell14.setCellValue(record.getR0030_pd().doubleValue());
			R0030cell14.setCellStyle(numberStyle);
		} else {
			R0030cell14.setCellValue("");
			R0030cell14.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column P
		Cell R0030cell15 = row.createCell(15);
		if (record.getR0030_lgd() != null) {
			R0030cell15.setCellValue(record.getR0030_lgd().doubleValue());
			R0030cell15.setCellStyle(numberStyle);
		} else {
			R0030cell15.setCellValue("");
			R0030cell15.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column Q
		Cell R0030cell16 = row.createCell(16);
		if (record.getR0030_provisions_charged_pnl() != null) {
			R0030cell16.setCellValue(record.getR0030_provisions_charged_pnl().doubleValue());
			R0030cell16.setCellStyle(numberStyle);
		} else {
			R0030cell16.setCellValue("");
			R0030cell16.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column R
		Cell R0030cell17 = row.createCell(17);
		if (record.getR0030_legacy_interest_profit_suspense() != null) {
			R0030cell17.setCellValue(record.getR0030_legacy_interest_profit_suspense().doubleValue());
			R0030cell17.setCellStyle(numberStyle);
		} else {
			R0030cell17.setCellValue("");
			R0030cell17.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column S
		Cell R0030cell18 = row.createCell(18);
		if (record.getR0030_legal_case_yn() != null && !record.getR0030_legal_case_yn().isEmpty()) {
			R0030cell18.setCellValue(record.getR0030_legal_case_yn());
			R0030cell18.setCellStyle(textStyle);
		} else {
			R0030cell18.setCellValue("");
			R0030cell18.setCellStyle(textStyle);
		}

		/// ROW11
		//// Column T
		Cell R0030cell19 = row.createCell(19);
		if (record.getR0030_remarks_if_any() != null && !record.getR0030_remarks_if_any().isEmpty()) {
			R0030cell19.setCellValue(record.getR0030_remarks_if_any());
			R0030cell19.setCellStyle(textStyle);
		} else {
			R0030cell19.setCellValue("");
			R0030cell19.setCellStyle(textStyle);
		}

		/// ROW12
		row = sheet.getRow(11);
		//// Column D
		Cell R0040cell3 = row.createCell(3);
		if (record.getR0040_borrower_name() != null && !record.getR0040_borrower_name().isEmpty()) {
			R0040cell3.setCellValue(record.getR0040_borrower_name());
			R0040cell3.setCellStyle(textStyle);
		} else {
			R0040cell3.setCellValue("");
			R0040cell3.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column E
		Cell R0040cell4 = row.createCell(4);
		if (record.getR0040_group_name_if_applicable() != null
				&& !record.getR0040_group_name_if_applicable().isEmpty()) {
			R0040cell4.setCellValue(record.getR0040_group_name_if_applicable());
			R0040cell4.setCellStyle(textStyle);
		} else {
			R0040cell4.setCellValue("");
			R0040cell4.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column F
		Cell R0040cell5 = row.createCell(5);
		if (record.getR0040_cin() != null && !record.getR0040_cin().isEmpty()) {
			R0040cell5.setCellValue(record.getR0040_cin());
			R0040cell5.setCellStyle(textStyle);
		} else {
			R0040cell5.setCellValue("");
			R0040cell5.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column G
		Cell R0040cell6 = row.createCell(6);
		if (record.getR0040_domicile_country() != null && !record.getR0040_domicile_country().isEmpty()) {
			R0040cell6.setCellValue(record.getR0040_domicile_country());
			R0040cell6.setCellStyle(textStyle);
		} else {
			R0040cell6.setCellValue("");
			R0040cell6.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column H
		Cell R0040cell7 = row.createCell(7);
		if (record.getR0040_funded_outstanding_amount() != null) {
			R0040cell7.setCellValue(record.getR0040_funded_outstanding_amount().doubleValue());
			R0040cell7.setCellStyle(numberStyle);
		} else {
			R0040cell7.setCellValue("");
			R0040cell7.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column I
		Cell R0040cell8 = row.createCell(8);
		if (record.getR0040_ccf_unfunded_outstanding_amount() != null) {
			R0040cell8.setCellValue(record.getR0040_ccf_unfunded_outstanding_amount().doubleValue());
			R0040cell8.setCellStyle(numberStyle);
		} else {
			R0040cell8.setCellValue("");
			R0040cell8.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column J
		Cell R0040cell9 = row.createCell(9);
		if (record.getR0040_secured_portion_exposure() != null) {
			R0040cell9.setCellValue(record.getR0040_secured_portion_exposure().doubleValue());
			R0040cell9.setCellStyle(numberStyle);
		} else {
			R0040cell9.setCellValue("");
			R0040cell9.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column K
		Cell R0040cell10 = row.createCell(10);
		if (record.getR0040_post_collateral_haircut() != null) {
			R0040cell10.setCellValue(record.getR0040_post_collateral_haircut().doubleValue());
			R0040cell10.setCellStyle(numberStyle);
		} else {
			R0040cell10.setCellValue("");
			R0040cell10.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column L
		Cell R0040cell11 = row.createCell(11);
		if (record.getR0040_type_of_security() != null) {
			R0040cell11.setCellValue(record.getR0040_type_of_security().doubleValue());
			R0040cell11.setCellStyle(numberStyle);
		} else {
			R0040cell11.setCellValue("");
			R0040cell11.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column M
		Cell R0040cell12 = row.createCell(12);
		if (record.getR0040_discounted_collateral_value() != null) {
			R0040cell12.setCellValue(record.getR0040_discounted_collateral_value().doubleValue());
			R0040cell12.setCellStyle(numberStyle);
		} else {
			R0040cell12.setCellValue("");
			R0040cell12.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column N
		Cell R0040cell13 = row.createCell(13);
		if (record.getR0040_validated_discounted_cashflows() != null) {
			R0040cell13.setCellValue(record.getR0040_validated_discounted_cashflows().doubleValue());
			R0040cell13.setCellStyle(numberStyle);
		} else {
			R0040cell13.setCellValue("");
			R0040cell13.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column O
		Cell R0040cell14 = row.createCell(14);
		if (record.getR0040_pd() != null) {
			R0040cell14.setCellValue(record.getR0040_pd().doubleValue());
			R0040cell14.setCellStyle(numberStyle);
		} else {
			R0040cell14.setCellValue("");
			R0040cell14.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column P
		Cell R0040cell15 = row.createCell(15);
		if (record.getR0040_lgd() != null) {
			R0040cell15.setCellValue(record.getR0040_lgd().doubleValue());
			R0040cell15.setCellStyle(numberStyle);
		} else {
			R0040cell15.setCellValue("");
			R0040cell15.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column Q
		Cell R0040cell16 = row.createCell(16);
		if (record.getR0040_provisions_charged_pnl() != null) {
			R0040cell16.setCellValue(record.getR0040_provisions_charged_pnl().doubleValue());
			R0040cell16.setCellStyle(numberStyle);
		} else {
			R0040cell16.setCellValue("");
			R0040cell16.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column R
		Cell R0040cell17 = row.createCell(17);
		if (record.getR0040_legacy_interest_profit_suspense() != null) {
			R0040cell17.setCellValue(record.getR0040_legacy_interest_profit_suspense().doubleValue());
			R0040cell17.setCellStyle(numberStyle);
		} else {
			R0040cell17.setCellValue("");
			R0040cell17.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column S
		Cell R0040cell18 = row.createCell(18);
		if (record.getR0040_legal_case_yn() != null && !record.getR0040_legal_case_yn().isEmpty()) {
			R0040cell18.setCellValue(record.getR0040_legal_case_yn());
			R0040cell18.setCellStyle(textStyle);
		} else {
			R0040cell18.setCellValue("");
			R0040cell18.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column T
		Cell R0040cell19 = row.createCell(19);
		if (record.getR0040_remarks_if_any() != null && !record.getR0040_remarks_if_any().isEmpty()) {
			R0040cell19.setCellValue(record.getR0040_remarks_if_any());
			R0040cell19.setCellStyle(textStyle);
		} else {
			R0040cell19.setCellValue("");
			R0040cell19.setCellStyle(textStyle);
		}

		/// ROW13
		row = sheet.getRow(12);
		//// Column D
		Cell R0050cell3 = row.createCell(3);
		if (record.getR0050_borrower_name() != null && !record.getR0050_borrower_name().isEmpty()) {
			R0050cell3.setCellValue(record.getR0050_borrower_name());
			R0050cell3.setCellStyle(textStyle);
		} else {
			R0050cell3.setCellValue("");
			R0050cell3.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column E
		Cell R0050cell4 = row.createCell(4);
		if (record.getR0050_group_name_if_applicable() != null
				&& !record.getR0050_group_name_if_applicable().isEmpty()) {
			R0050cell4.setCellValue(record.getR0050_group_name_if_applicable());
			R0050cell4.setCellStyle(textStyle);
		} else {
			R0050cell4.setCellValue("");
			R0050cell4.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column F
		Cell R0050cell5 = row.createCell(5);
		if (record.getR0050_cin() != null && !record.getR0050_cin().isEmpty()) {
			R0050cell5.setCellValue(record.getR0050_cin());
			R0050cell5.setCellStyle(textStyle);
		} else {
			R0050cell5.setCellValue("");
			R0050cell5.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column G
		Cell R0050cell6 = row.createCell(6);
		if (record.getR0050_domicile_country() != null && !record.getR0050_domicile_country().isEmpty()) {
			R0050cell6.setCellValue(record.getR0050_domicile_country());
			R0050cell6.setCellStyle(textStyle);
		} else {
			R0050cell6.setCellValue("");
			R0050cell6.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column H
		Cell R0050cell7 = row.createCell(7);
		if (record.getR0050_funded_outstanding_amount() != null) {
			R0050cell7.setCellValue(record.getR0050_funded_outstanding_amount().doubleValue());
			R0050cell7.setCellStyle(numberStyle);
		} else {
			R0050cell7.setCellValue("");
			R0050cell7.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column I
		Cell R0050cell8 = row.createCell(8);
		if (record.getR0050_ccf_unfunded_outstanding_amount() != null) {
			R0050cell8.setCellValue(record.getR0050_ccf_unfunded_outstanding_amount().doubleValue());
			R0050cell8.setCellStyle(numberStyle);
		} else {
			R0050cell8.setCellValue("");
			R0050cell8.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column J
		Cell R0050cell9 = row.createCell(9);
		if (record.getR0050_secured_portion_exposure() != null) {
			R0050cell9.setCellValue(record.getR0050_secured_portion_exposure().doubleValue());
			R0050cell9.setCellStyle(numberStyle);
		} else {
			R0050cell9.setCellValue("");
			R0050cell9.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column K
		Cell R0050cell10 = row.createCell(10);
		if (record.getR0050_post_collateral_haircut() != null) {
			R0050cell10.setCellValue(record.getR0050_post_collateral_haircut().doubleValue());
			R0050cell10.setCellStyle(numberStyle);
		} else {
			R0050cell10.setCellValue("");
			R0050cell10.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column L
		Cell R0050cell11 = row.createCell(11);
		if (record.getR0050_type_of_security() != null) {
			R0050cell11.setCellValue(record.getR0050_type_of_security().doubleValue());
			R0050cell11.setCellStyle(numberStyle);
		} else {
			R0050cell11.setCellValue("");
			R0050cell11.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column M
		Cell R0050cell12 = row.createCell(12);
		if (record.getR0050_discounted_collateral_value() != null) {
			R0050cell12.setCellValue(record.getR0050_discounted_collateral_value().doubleValue());
			R0050cell12.setCellStyle(numberStyle);
		} else {
			R0050cell12.setCellValue("");
			R0050cell12.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column N
		Cell R0050cell13 = row.createCell(13);
		if (record.getR0050_validated_discounted_cashflows() != null) {
			R0050cell13.setCellValue(record.getR0050_validated_discounted_cashflows().doubleValue());
			R0050cell13.setCellStyle(numberStyle);
		} else {
			R0050cell13.setCellValue("");
			R0050cell13.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column O
		Cell R0050cell14 = row.createCell(14);
		if (record.getR0050_pd() != null) {
			R0050cell14.setCellValue(record.getR0050_pd().doubleValue());
			R0050cell14.setCellStyle(numberStyle);
		} else {
			R0050cell14.setCellValue("");
			R0050cell14.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column P
		Cell R0050cell15 = row.createCell(15);
		if (record.getR0050_lgd() != null) {
			R0050cell15.setCellValue(record.getR0050_lgd().doubleValue());
			R0050cell15.setCellStyle(numberStyle);
		} else {
			R0050cell15.setCellValue("");
			R0050cell15.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column Q
		Cell R0050cell16 = row.createCell(16);
		if (record.getR0050_provisions_charged_pnl() != null) {
			R0050cell16.setCellValue(record.getR0050_provisions_charged_pnl().doubleValue());
			R0050cell16.setCellStyle(numberStyle);
		} else {
			R0050cell16.setCellValue("");
			R0050cell16.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column R
		Cell R0050cell17 = row.createCell(17);
		if (record.getR0050_legacy_interest_profit_suspense() != null) {
			R0050cell17.setCellValue(record.getR0050_legacy_interest_profit_suspense().doubleValue());
			R0050cell17.setCellStyle(numberStyle);
		} else {
			R0050cell17.setCellValue("");
			R0050cell17.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column S
		Cell R0050cell18 = row.createCell(18);
		if (record.getR0050_legal_case_yn() != null && !record.getR0050_legal_case_yn().isEmpty()) {
			R0050cell18.setCellValue(record.getR0050_legal_case_yn());
			R0050cell18.setCellStyle(textStyle);
		} else {
			R0050cell18.setCellValue("");
			R0050cell18.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column T
		Cell R0050cell19 = row.createCell(19);
		if (record.getR0050_remarks_if_any() != null && !record.getR0050_remarks_if_any().isEmpty()) {
			R0050cell19.setCellValue(record.getR0050_remarks_if_any());
			R0050cell19.setCellStyle(textStyle);
		} else {
			R0050cell19.setCellValue("");
			R0050cell19.setCellStyle(textStyle);
		}

		/// ROW14
		row = sheet.getRow(13);
		//// Column D
		Cell R0060cell3 = row.createCell(3);
		if (record.getR0060_borrower_name() != null && !record.getR0060_borrower_name().isEmpty()) {
			R0060cell3.setCellValue(record.getR0060_borrower_name());
			R0060cell3.setCellStyle(textStyle);
		} else {
			R0060cell3.setCellValue("");
			R0060cell3.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column E
		Cell R0060cell4 = row.createCell(4);
		if (record.getR0060_group_name_if_applicable() != null
				&& !record.getR0060_group_name_if_applicable().isEmpty()) {
			R0060cell4.setCellValue(record.getR0060_group_name_if_applicable());
			R0060cell4.setCellStyle(textStyle);
		} else {
			R0060cell4.setCellValue("");
			R0060cell4.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column F
		Cell R0060cell5 = row.createCell(5);
		if (record.getR0060_cin() != null && !record.getR0060_cin().isEmpty()) {
			R0060cell5.setCellValue(record.getR0060_cin());
			R0060cell5.setCellStyle(textStyle);
		} else {
			R0060cell5.setCellValue("");
			R0060cell5.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column G
		Cell R0060cell6 = row.createCell(6);
		if (record.getR0060_domicile_country() != null && !record.getR0060_domicile_country().isEmpty()) {
			R0060cell6.setCellValue(record.getR0060_domicile_country());
			R0060cell6.setCellStyle(textStyle);
		} else {
			R0060cell6.setCellValue("");
			R0060cell6.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column H
		Cell R0060cell7 = row.createCell(7);
		if (record.getR0060_funded_outstanding_amount() != null) {
			R0060cell7.setCellValue(record.getR0060_funded_outstanding_amount().doubleValue());
			R0060cell7.setCellStyle(numberStyle);
		} else {
			R0060cell7.setCellValue("");
			R0060cell7.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column I
		Cell R0060cell8 = row.createCell(8);
		if (record.getR0060_ccf_unfunded_outstanding_amount() != null) {
			R0060cell8.setCellValue(record.getR0060_ccf_unfunded_outstanding_amount().doubleValue());
			R0060cell8.setCellStyle(numberStyle);
		} else {
			R0060cell8.setCellValue("");
			R0060cell8.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column J
		Cell R0060cell9 = row.createCell(9);
		if (record.getR0060_secured_portion_exposure() != null) {
			R0060cell9.setCellValue(record.getR0060_secured_portion_exposure().doubleValue());
			R0060cell9.setCellStyle(numberStyle);
		} else {
			R0060cell9.setCellValue("");
			R0060cell9.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column K
		Cell R0060cell10 = row.createCell(10);
		if (record.getR0060_post_collateral_haircut() != null) {
			R0060cell10.setCellValue(record.getR0060_post_collateral_haircut().doubleValue());
			R0060cell10.setCellStyle(numberStyle);
		} else {
			R0060cell10.setCellValue("");
			R0060cell10.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column L
		Cell R0060cell11 = row.createCell(11);
		if (record.getR0060_type_of_security() != null) {
			R0060cell11.setCellValue(record.getR0060_type_of_security().doubleValue());
			R0060cell11.setCellStyle(numberStyle);
		} else {
			R0060cell11.setCellValue("");
			R0060cell11.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column M
		Cell R0060cell12 = row.createCell(12);
		if (record.getR0060_discounted_collateral_value() != null) {
			R0060cell12.setCellValue(record.getR0060_discounted_collateral_value().doubleValue());
			R0060cell12.setCellStyle(numberStyle);
		} else {
			R0060cell12.setCellValue("");
			R0060cell12.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column N
		Cell R0060cell13 = row.createCell(13);
		if (record.getR0060_validated_discounted_cashflows() != null) {
			R0060cell13.setCellValue(record.getR0060_validated_discounted_cashflows().doubleValue());
			R0060cell13.setCellStyle(numberStyle);
		} else {
			R0060cell13.setCellValue("");
			R0060cell13.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column O
		Cell R0060cell14 = row.createCell(14);
		if (record.getR0060_pd() != null) {
			R0060cell14.setCellValue(record.getR0060_pd().doubleValue());
			R0060cell14.setCellStyle(numberStyle);
		} else {
			R0060cell14.setCellValue("");
			R0060cell14.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column P
		Cell R0060cell15 = row.createCell(15);
		if (record.getR0060_lgd() != null) {
			R0060cell15.setCellValue(record.getR0060_lgd().doubleValue());
			R0060cell15.setCellStyle(numberStyle);
		} else {
			R0060cell15.setCellValue("");
			R0060cell15.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column Q
		Cell R0060cell16 = row.createCell(16);
		if (record.getR0060_provisions_charged_pnl() != null) {
			R0060cell16.setCellValue(record.getR0060_provisions_charged_pnl().doubleValue());
			R0060cell16.setCellStyle(numberStyle);
		} else {
			R0060cell16.setCellValue("");
			R0060cell16.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column R
		Cell R0060cell17 = row.createCell(17);
		if (record.getR0060_legacy_interest_profit_suspense() != null) {
			R0060cell17.setCellValue(record.getR0060_legacy_interest_profit_suspense().doubleValue());
			R0060cell17.setCellStyle(numberStyle);
		} else {
			R0060cell17.setCellValue("");
			R0060cell17.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column S
		Cell R0060cell18 = row.createCell(18);
		if (record.getR0060_legal_case_yn() != null && !record.getR0060_legal_case_yn().isEmpty()) {
			R0060cell18.setCellValue(record.getR0060_legal_case_yn());
			R0060cell18.setCellStyle(textStyle);
		} else {
			R0060cell18.setCellValue("");
			R0060cell18.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column T
		Cell R0060cell19 = row.createCell(19);
		if (record.getR0060_remarks_if_any() != null && !record.getR0060_remarks_if_any().isEmpty()) {
			R0060cell19.setCellValue(record.getR0060_remarks_if_any());
			R0060cell19.setCellStyle(textStyle);
		} else {
			R0060cell19.setCellValue("");
			R0060cell19.setCellStyle(textStyle);
		}

		/// ROW15
		row = sheet.getRow(14);
		//// Column D
		Cell R0070cell3 = row.createCell(3);
		if (record.getR0070_borrower_name() != null && !record.getR0070_borrower_name().isEmpty()) {
			R0070cell3.setCellValue(record.getR0070_borrower_name());
			R0070cell3.setCellStyle(textStyle);
		} else {
			R0070cell3.setCellValue("");
			R0070cell3.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column E
		Cell R0070cell4 = row.createCell(4);
		if (record.getR0070_group_name_if_applicable() != null
				&& !record.getR0070_group_name_if_applicable().isEmpty()) {
			R0070cell4.setCellValue(record.getR0070_group_name_if_applicable());
			R0070cell4.setCellStyle(textStyle);
		} else {
			R0070cell4.setCellValue("");
			R0070cell4.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column F
		Cell R0070cell5 = row.createCell(5);
		if (record.getR0070_cin() != null && !record.getR0070_cin().isEmpty()) {
			R0070cell5.setCellValue(record.getR0070_cin());
			R0070cell5.setCellStyle(textStyle);
		} else {
			R0070cell5.setCellValue("");
			R0070cell5.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column G
		Cell R0070cell6 = row.createCell(6);
		if (record.getR0070_domicile_country() != null && !record.getR0070_domicile_country().isEmpty()) {
			R0070cell6.setCellValue(record.getR0070_domicile_country());
			R0070cell6.setCellStyle(textStyle);
		} else {
			R0070cell6.setCellValue("");
			R0070cell6.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column H
		Cell R0070cell7 = row.createCell(7);
		if (record.getR0070_funded_outstanding_amount() != null) {
			R0070cell7.setCellValue(record.getR0070_funded_outstanding_amount().doubleValue());
			R0070cell7.setCellStyle(numberStyle);
		} else {
			R0070cell7.setCellValue("");
			R0070cell7.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column I
		Cell R0070cell8 = row.createCell(8);
		if (record.getR0070_ccf_unfunded_outstanding_amount() != null) {
			R0070cell8.setCellValue(record.getR0070_ccf_unfunded_outstanding_amount().doubleValue());
			R0070cell8.setCellStyle(numberStyle);
		} else {
			R0070cell8.setCellValue("");
			R0070cell8.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column J
		Cell R0070cell9 = row.createCell(9);
		if (record.getR0070_secured_portion_exposure() != null) {
			R0070cell9.setCellValue(record.getR0070_secured_portion_exposure().doubleValue());
			R0070cell9.setCellStyle(numberStyle);
		} else {
			R0070cell9.setCellValue("");
			R0070cell9.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column K
		Cell R0070cell10 = row.createCell(10);
		if (record.getR0070_post_collateral_haircut() != null) {
			R0070cell10.setCellValue(record.getR0070_post_collateral_haircut().doubleValue());
			R0070cell10.setCellStyle(numberStyle);
		} else {
			R0070cell10.setCellValue("");
			R0070cell10.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column L
		Cell R0070cell11 = row.createCell(11);
		if (record.getR0070_type_of_security() != null) {
			R0070cell11.setCellValue(record.getR0070_type_of_security().doubleValue());
			R0070cell11.setCellStyle(numberStyle);
		} else {
			R0070cell11.setCellValue("");
			R0070cell11.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column M
		Cell R0070cell12 = row.createCell(12);
		if (record.getR0070_discounted_collateral_value() != null) {
			R0070cell12.setCellValue(record.getR0070_discounted_collateral_value().doubleValue());
			R0070cell12.setCellStyle(numberStyle);
		} else {
			R0070cell12.setCellValue("");
			R0070cell12.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column N
		Cell R0070cell13 = row.createCell(13);
		if (record.getR0070_validated_discounted_cashflows() != null) {
			R0070cell13.setCellValue(record.getR0070_validated_discounted_cashflows().doubleValue());
			R0070cell13.setCellStyle(numberStyle);
		} else {
			R0070cell13.setCellValue("");
			R0070cell13.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column O
		Cell R0070cell14 = row.createCell(14);
		if (record.getR0070_pd() != null) {
			R0070cell14.setCellValue(record.getR0070_pd().doubleValue());
			R0070cell14.setCellStyle(numberStyle);
		} else {
			R0070cell14.setCellValue("");
			R0070cell14.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column P
		Cell R0070cell15 = row.createCell(15);
		if (record.getR0070_lgd() != null) {
			R0070cell15.setCellValue(record.getR0070_lgd().doubleValue());
			R0070cell15.setCellStyle(numberStyle);
		} else {
			R0070cell15.setCellValue("");
			R0070cell15.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column Q
		Cell R0070cell16 = row.createCell(16);
		if (record.getR0070_provisions_charged_pnl() != null) {
			R0070cell16.setCellValue(record.getR0070_provisions_charged_pnl().doubleValue());
			R0070cell16.setCellStyle(numberStyle);
		} else {
			R0070cell16.setCellValue("");
			R0070cell16.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column R
		Cell R0070cell17 = row.createCell(17);
		if (record.getR0070_legacy_interest_profit_suspense() != null) {
			R0070cell17.setCellValue(record.getR0070_legacy_interest_profit_suspense().doubleValue());
			R0070cell17.setCellStyle(numberStyle);
		} else {
			R0070cell17.setCellValue("");
			R0070cell17.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column S
		Cell R0070cell18 = row.createCell(18);
		if (record.getR0070_legal_case_yn() != null && !record.getR0070_legal_case_yn().isEmpty()) {
			R0070cell18.setCellValue(record.getR0070_legal_case_yn());
			R0070cell18.setCellStyle(textStyle);
		} else {
			R0070cell18.setCellValue("");
			R0070cell18.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column T
		Cell R0070cell19 = row.createCell(19);
		if (record.getR0070_remarks_if_any() != null && !record.getR0070_remarks_if_any().isEmpty()) {
			R0070cell19.setCellValue(record.getR0070_remarks_if_any());
			R0070cell19.setCellStyle(textStyle);
		} else {
			R0070cell19.setCellValue("");
			R0070cell19.setCellStyle(textStyle);
		}

		/// ROW16
		row = sheet.getRow(15);
		//// Column D
		Cell R0080cell3 = row.createCell(3);
		if (record.getR0080_borrower_name() != null && !record.getR0080_borrower_name().isEmpty()) {
			R0080cell3.setCellValue(record.getR0080_borrower_name());
			R0080cell3.setCellStyle(textStyle);
		} else {
			R0080cell3.setCellValue("");
			R0080cell3.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column E
		Cell R0080cell4 = row.createCell(4);
		if (record.getR0080_group_name_if_applicable() != null
				&& !record.getR0080_group_name_if_applicable().isEmpty()) {
			R0080cell4.setCellValue(record.getR0080_group_name_if_applicable());
			R0080cell4.setCellStyle(textStyle);
		} else {
			R0080cell4.setCellValue("");
			R0080cell4.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column F
		Cell R0080cell5 = row.createCell(5);
		if (record.getR0080_cin() != null && !record.getR0080_cin().isEmpty()) {
			R0080cell5.setCellValue(record.getR0080_cin());
			R0080cell5.setCellStyle(textStyle);
		} else {
			R0080cell5.setCellValue("");
			R0080cell5.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column G
		Cell R0080cell6 = row.createCell(6);
		if (record.getR0080_domicile_country() != null && !record.getR0080_domicile_country().isEmpty()) {
			R0080cell6.setCellValue(record.getR0080_domicile_country());
			R0080cell6.setCellStyle(textStyle);
		} else {
			R0080cell6.setCellValue("");
			R0080cell6.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column H
		Cell R0080cell7 = row.createCell(7);
		if (record.getR0080_funded_outstanding_amount() != null) {
			R0080cell7.setCellValue(record.getR0080_funded_outstanding_amount().doubleValue());
			R0080cell7.setCellStyle(numberStyle);
		} else {
			R0080cell7.setCellValue("");
			R0080cell7.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column I
		Cell R0080cell8 = row.createCell(8);
		if (record.getR0080_ccf_unfunded_outstanding_amount() != null) {
			R0080cell8.setCellValue(record.getR0080_ccf_unfunded_outstanding_amount().doubleValue());
			R0080cell8.setCellStyle(numberStyle);
		} else {
			R0080cell8.setCellValue("");
			R0080cell8.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column J
		Cell R0080cell9 = row.createCell(9);
		if (record.getR0080_secured_portion_exposure() != null) {
			R0080cell9.setCellValue(record.getR0080_secured_portion_exposure().doubleValue());
			R0080cell9.setCellStyle(numberStyle);
		} else {
			R0080cell9.setCellValue("");
			R0080cell9.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column K
		Cell R0080cell10 = row.createCell(10);
		if (record.getR0080_post_collateral_haircut() != null) {
			R0080cell10.setCellValue(record.getR0080_post_collateral_haircut().doubleValue());
			R0080cell10.setCellStyle(numberStyle);
		} else {
			R0080cell10.setCellValue("");
			R0080cell10.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column L
		Cell R0080cell11 = row.createCell(11);
		if (record.getR0080_type_of_security() != null) {
			R0080cell11.setCellValue(record.getR0080_type_of_security().doubleValue());
			R0080cell11.setCellStyle(numberStyle);
		} else {
			R0080cell11.setCellValue("");
			R0080cell11.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column M
		Cell R0080cell12 = row.createCell(12);
		if (record.getR0080_discounted_collateral_value() != null) {
			R0080cell12.setCellValue(record.getR0080_discounted_collateral_value().doubleValue());
			R0080cell12.setCellStyle(numberStyle);
		} else {
			R0080cell12.setCellValue("");
			R0080cell12.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column N
		Cell R0080cell13 = row.createCell(13);
		if (record.getR0080_validated_discounted_cashflows() != null) {
			R0080cell13.setCellValue(record.getR0080_validated_discounted_cashflows().doubleValue());
			R0080cell13.setCellStyle(numberStyle);
		} else {
			R0080cell13.setCellValue("");
			R0080cell13.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column O
		Cell R0080cell14 = row.createCell(14);
		if (record.getR0080_pd() != null) {
			R0080cell14.setCellValue(record.getR0080_pd().doubleValue());
			R0080cell14.setCellStyle(numberStyle);
		} else {
			R0080cell14.setCellValue("");
			R0080cell14.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column P
		Cell R0080cell15 = row.createCell(15);
		if (record.getR0080_lgd() != null) {
			R0080cell15.setCellValue(record.getR0080_lgd().doubleValue());
			R0080cell15.setCellStyle(numberStyle);
		} else {
			R0080cell15.setCellValue("");
			R0080cell15.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column Q
		Cell R0080cell16 = row.createCell(16);
		if (record.getR0080_provisions_charged_pnl() != null) {
			R0080cell16.setCellValue(record.getR0080_provisions_charged_pnl().doubleValue());
			R0080cell16.setCellStyle(numberStyle);
		} else {
			R0080cell16.setCellValue("");
			R0080cell16.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column R
		Cell R0080cell17 = row.createCell(17);
		if (record.getR0080_legacy_interest_profit_suspense() != null) {
			R0080cell17.setCellValue(record.getR0080_legacy_interest_profit_suspense().doubleValue());
			R0080cell17.setCellStyle(numberStyle);
		} else {
			R0080cell17.setCellValue("");
			R0080cell17.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column S
		Cell R0080cell18 = row.createCell(18);
		if (record.getR0080_legal_case_yn() != null && !record.getR0080_legal_case_yn().isEmpty()) {
			R0080cell18.setCellValue(record.getR0080_legal_case_yn());
			R0080cell18.setCellStyle(textStyle);
		} else {
			R0080cell18.setCellValue("");
			R0080cell18.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column T
		Cell R0080cell19 = row.createCell(19);
		if (record.getR0080_remarks_if_any() != null && !record.getR0080_remarks_if_any().isEmpty()) {
			R0080cell19.setCellValue(record.getR0080_remarks_if_any());
			R0080cell19.setCellStyle(textStyle);
		} else {
			R0080cell19.setCellValue("");
			R0080cell19.setCellStyle(textStyle);
		}

		/// ROW17
		row = sheet.getRow(16);
		//// Column D
		Cell R0090cell3 = row.createCell(3);
		if (record.getR0090_borrower_name() != null && !record.getR0090_borrower_name().isEmpty()) {
			R0090cell3.setCellValue(record.getR0090_borrower_name());
			R0090cell3.setCellStyle(textStyle);
		} else {
			R0090cell3.setCellValue("");
			R0090cell3.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column E
		Cell R0090cell4 = row.createCell(4);
		if (record.getR0090_group_name_if_applicable() != null
				&& !record.getR0090_group_name_if_applicable().isEmpty()) {
			R0090cell4.setCellValue(record.getR0090_group_name_if_applicable());
			R0090cell4.setCellStyle(textStyle);
		} else {
			R0090cell4.setCellValue("");
			R0090cell4.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column F
		Cell R0090cell5 = row.createCell(5);
		if (record.getR0090_cin() != null && !record.getR0090_cin().isEmpty()) {
			R0090cell5.setCellValue(record.getR0090_cin());
			R0090cell5.setCellStyle(textStyle);
		} else {
			R0090cell5.setCellValue("");
			R0090cell5.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column G
		Cell R0090cell6 = row.createCell(6);
		if (record.getR0090_domicile_country() != null && !record.getR0090_domicile_country().isEmpty()) {
			R0090cell6.setCellValue(record.getR0090_domicile_country());
			R0090cell6.setCellStyle(textStyle);
		} else {
			R0090cell6.setCellValue("");
			R0090cell6.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column H
		Cell R0090cell7 = row.createCell(7);
		if (record.getR0090_funded_outstanding_amount() != null) {
			R0090cell7.setCellValue(record.getR0090_funded_outstanding_amount().doubleValue());
			R0090cell7.setCellStyle(numberStyle);
		} else {
			R0090cell7.setCellValue("");
			R0090cell7.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column I
		Cell R0090cell8 = row.createCell(8);
		if (record.getR0090_ccf_unfunded_outstanding_amount() != null) {
			R0090cell8.setCellValue(record.getR0090_ccf_unfunded_outstanding_amount().doubleValue());
			R0090cell8.setCellStyle(numberStyle);
		} else {
			R0090cell8.setCellValue("");
			R0090cell8.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column J
		Cell R0090cell9 = row.createCell(9);
		if (record.getR0090_secured_portion_exposure() != null) {
			R0090cell9.setCellValue(record.getR0090_secured_portion_exposure().doubleValue());
			R0090cell9.setCellStyle(numberStyle);
		} else {
			R0090cell9.setCellValue("");
			R0090cell9.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column K
		Cell R0090cell10 = row.createCell(10);
		if (record.getR0090_post_collateral_haircut() != null) {
			R0090cell10.setCellValue(record.getR0090_post_collateral_haircut().doubleValue());
			R0090cell10.setCellStyle(numberStyle);
		} else {
			R0090cell10.setCellValue("");
			R0090cell10.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column L
		Cell R0090cell11 = row.createCell(11);
		if (record.getR0090_type_of_security() != null) {
			R0090cell11.setCellValue(record.getR0090_type_of_security().doubleValue());
			R0090cell11.setCellStyle(numberStyle);
		} else {
			R0090cell11.setCellValue("");
			R0090cell11.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column M
		Cell R0090cell12 = row.createCell(12);
		if (record.getR0090_discounted_collateral_value() != null) {
			R0090cell12.setCellValue(record.getR0090_discounted_collateral_value().doubleValue());
			R0090cell12.setCellStyle(numberStyle);
		} else {
			R0090cell12.setCellValue("");
			R0090cell12.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column N
		Cell R0090cell13 = row.createCell(13);
		if (record.getR0090_validated_discounted_cashflows() != null) {
			R0090cell13.setCellValue(record.getR0090_validated_discounted_cashflows().doubleValue());
			R0090cell13.setCellStyle(numberStyle);
		} else {
			R0090cell13.setCellValue("");
			R0090cell13.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column O
		Cell R0090cell14 = row.createCell(14);
		if (record.getR0090_pd() != null) {
			R0090cell14.setCellValue(record.getR0090_pd().doubleValue());
			R0090cell14.setCellStyle(numberStyle);
		} else {
			R0090cell14.setCellValue("");
			R0090cell14.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column P
		Cell R0090cell15 = row.createCell(15);
		if (record.getR0090_lgd() != null) {
			R0090cell15.setCellValue(record.getR0090_lgd().doubleValue());
			R0090cell15.setCellStyle(numberStyle);
		} else {
			R0090cell15.setCellValue("");
			R0090cell15.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column Q
		Cell R0090cell16 = row.createCell(16);
		if (record.getR0090_provisions_charged_pnl() != null) {
			R0090cell16.setCellValue(record.getR0090_provisions_charged_pnl().doubleValue());
			R0090cell16.setCellStyle(numberStyle);
		} else {
			R0090cell16.setCellValue("");
			R0090cell16.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column R
		Cell R0090cell17 = row.createCell(17);
		if (record.getR0090_legacy_interest_profit_suspense() != null) {
			R0090cell17.setCellValue(record.getR0090_legacy_interest_profit_suspense().doubleValue());
			R0090cell17.setCellStyle(numberStyle);
		} else {
			R0090cell17.setCellValue("");
			R0090cell17.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column S
		Cell R0090cell18 = row.createCell(18);
		if (record.getR0090_legal_case_yn() != null && !record.getR0090_legal_case_yn().isEmpty()) {
			R0090cell18.setCellValue(record.getR0090_legal_case_yn());
			R0090cell18.setCellStyle(textStyle);
		} else {
			R0090cell18.setCellValue("");
			R0090cell18.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column T
		Cell R0090cell19 = row.createCell(19);
		if (record.getR0090_remarks_if_any() != null && !record.getR0090_remarks_if_any().isEmpty()) {
			R0090cell19.setCellValue(record.getR0090_remarks_if_any());
			R0090cell19.setCellStyle(textStyle);
		} else {
			R0090cell19.setCellValue("");
			R0090cell19.setCellStyle(textStyle);
		}

		/// ROW18
		row = sheet.getRow(17);
		//// Column D
		Cell R0100cell3 = row.createCell(3);
		if (record.getR0100_borrower_name() != null && !record.getR0100_borrower_name().isEmpty()) {
			R0100cell3.setCellValue(record.getR0100_borrower_name());
			R0100cell3.setCellStyle(textStyle);
		} else {
			R0100cell3.setCellValue("");
			R0100cell3.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column E
		Cell R0100cell4 = row.createCell(4);
		if (record.getR0100_group_name_if_applicable() != null
				&& !record.getR0100_group_name_if_applicable().isEmpty()) {
			R0100cell4.setCellValue(record.getR0100_group_name_if_applicable());
			R0100cell4.setCellStyle(textStyle);
		} else {
			R0100cell4.setCellValue("");
			R0100cell4.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column F
		Cell R0100cell5 = row.createCell(5);
		if (record.getR0100_cin() != null && !record.getR0100_cin().isEmpty()) {
			R0100cell5.setCellValue(record.getR0100_cin());
			R0100cell5.setCellStyle(textStyle);
		} else {
			R0100cell5.setCellValue("");
			R0100cell5.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column G
		Cell R0100cell6 = row.createCell(6);
		if (record.getR0100_domicile_country() != null && !record.getR0100_domicile_country().isEmpty()) {
			R0100cell6.setCellValue(record.getR0100_domicile_country());
			R0100cell6.setCellStyle(textStyle);
		} else {
			R0100cell6.setCellValue("");
			R0100cell6.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column H
		Cell R0100cell7 = row.createCell(7);
		if (record.getR0100_funded_outstanding_amount() != null) {
			R0100cell7.setCellValue(record.getR0100_funded_outstanding_amount().doubleValue());
			R0100cell7.setCellStyle(numberStyle);
		} else {
			R0100cell7.setCellValue("");
			R0100cell7.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column I
		Cell R0100cell8 = row.createCell(8);
		if (record.getR0100_ccf_unfunded_outstanding_amount() != null) {
			R0100cell8.setCellValue(record.getR0100_ccf_unfunded_outstanding_amount().doubleValue());
			R0100cell8.setCellStyle(numberStyle);
		} else {
			R0100cell8.setCellValue("");
			R0100cell8.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column J
		Cell R0100cell9 = row.createCell(9);
		if (record.getR0100_secured_portion_exposure() != null) {
			R0100cell9.setCellValue(record.getR0100_secured_portion_exposure().doubleValue());
			R0100cell9.setCellStyle(numberStyle);
		} else {
			R0100cell9.setCellValue("");
			R0100cell9.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column K
		Cell R0100cell10 = row.createCell(10);
		if (record.getR0100_post_collateral_haircut() != null) {
			R0100cell10.setCellValue(record.getR0100_post_collateral_haircut().doubleValue());
			R0100cell10.setCellStyle(numberStyle);
		} else {
			R0100cell10.setCellValue("");
			R0100cell10.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column L
		Cell R0100cell11 = row.createCell(11);
		if (record.getR0100_type_of_security() != null) {
			R0100cell11.setCellValue(record.getR0100_type_of_security().doubleValue());
			R0100cell11.setCellStyle(numberStyle);
		} else {
			R0100cell11.setCellValue("");
			R0100cell11.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column M
		Cell R0100cell12 = row.createCell(12);
		if (record.getR0100_discounted_collateral_value() != null) {
			R0100cell12.setCellValue(record.getR0100_discounted_collateral_value().doubleValue());
			R0100cell12.setCellStyle(numberStyle);
		} else {
			R0100cell12.setCellValue("");
			R0100cell12.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column N
		Cell R0100cell13 = row.createCell(13);
		if (record.getR0100_validated_discounted_cashflows() != null) {
			R0100cell13.setCellValue(record.getR0100_validated_discounted_cashflows().doubleValue());
			R0100cell13.setCellStyle(numberStyle);
		} else {
			R0100cell13.setCellValue("");
			R0100cell13.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column O
		Cell R0100cell14 = row.createCell(14);
		if (record.getR0100_pd() != null) {
			R0100cell14.setCellValue(record.getR0100_pd().doubleValue());
			R0100cell14.setCellStyle(numberStyle);
		} else {
			R0100cell14.setCellValue("");
			R0100cell14.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column P
		Cell R0100cell15 = row.createCell(15);
		if (record.getR0100_lgd() != null) {
			R0100cell15.setCellValue(record.getR0100_lgd().doubleValue());
			R0100cell15.setCellStyle(numberStyle);
		} else {
			R0100cell15.setCellValue("");
			R0100cell15.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column Q
		Cell R0100cell16 = row.createCell(16);
		if (record.getR0100_provisions_charged_pnl() != null) {
			R0100cell16.setCellValue(record.getR0100_provisions_charged_pnl().doubleValue());
			R0100cell16.setCellStyle(numberStyle);
		} else {
			R0100cell16.setCellValue("");
			R0100cell16.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column R
		Cell R0100cell17 = row.createCell(17);
		if (record.getR0100_legacy_interest_profit_suspense() != null) {
			R0100cell17.setCellValue(record.getR0100_legacy_interest_profit_suspense().doubleValue());
			R0100cell17.setCellStyle(numberStyle);
		} else {
			R0100cell17.setCellValue("");
			R0100cell17.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column S
		Cell R0100cell18 = row.createCell(18);
		if (record.getR0100_legal_case_yn() != null && !record.getR0100_legal_case_yn().isEmpty()) {
			R0100cell18.setCellValue(record.getR0100_legal_case_yn());
			R0100cell18.setCellStyle(textStyle);
		} else {
			R0100cell18.setCellValue("");
			R0100cell18.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column T
		Cell R0100cell19 = row.createCell(19);
		if (record.getR0100_remarks_if_any() != null && !record.getR0100_remarks_if_any().isEmpty()) {
			R0100cell19.setCellValue(record.getR0100_remarks_if_any());
			R0100cell19.setCellStyle(textStyle);
		} else {
			R0100cell19.setCellValue("");
			R0100cell19.setCellStyle(textStyle);
		}

		/// ROW19
		row = sheet.getRow(18);
		//// Column D
		Cell R0110cell3 = row.createCell(3);
		if (record.getR0110_borrower_name() != null && !record.getR0110_borrower_name().isEmpty()) {
			R0110cell3.setCellValue(record.getR0110_borrower_name());
			R0110cell3.setCellStyle(textStyle);
		} else {
			R0110cell3.setCellValue("");
			R0110cell3.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column E
		Cell R0110cell4 = row.createCell(4);
		if (record.getR0110_group_name_if_applicable() != null
				&& !record.getR0110_group_name_if_applicable().isEmpty()) {
			R0110cell4.setCellValue(record.getR0110_group_name_if_applicable());
			R0110cell4.setCellStyle(textStyle);
		} else {
			R0110cell4.setCellValue("");
			R0110cell4.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column F
		Cell R0110cell5 = row.createCell(5);
		if (record.getR0110_cin() != null && !record.getR0110_cin().isEmpty()) {
			R0110cell5.setCellValue(record.getR0110_cin());
			R0110cell5.setCellStyle(textStyle);
		} else {
			R0110cell5.setCellValue("");
			R0110cell5.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column G
		Cell R0110cell6 = row.createCell(6);
		if (record.getR0110_domicile_country() != null && !record.getR0110_domicile_country().isEmpty()) {
			R0110cell6.setCellValue(record.getR0110_domicile_country());
			R0110cell6.setCellStyle(textStyle);
		} else {
			R0110cell6.setCellValue("");
			R0110cell6.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column H
		Cell R0110cell7 = row.createCell(7);
		if (record.getR0110_funded_outstanding_amount() != null) {
			R0110cell7.setCellValue(record.getR0110_funded_outstanding_amount().doubleValue());
			R0110cell7.setCellStyle(numberStyle);
		} else {
			R0110cell7.setCellValue("");
			R0110cell7.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column I
		Cell R0110cell8 = row.createCell(8);
		if (record.getR0110_ccf_unfunded_outstanding_amount() != null) {
			R0110cell8.setCellValue(record.getR0110_ccf_unfunded_outstanding_amount().doubleValue());
			R0110cell8.setCellStyle(numberStyle);
		} else {
			R0110cell8.setCellValue("");
			R0110cell8.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column J
		Cell R0110cell9 = row.createCell(9);
		if (record.getR0110_secured_portion_exposure() != null) {
			R0110cell9.setCellValue(record.getR0110_secured_portion_exposure().doubleValue());
			R0110cell9.setCellStyle(numberStyle);
		} else {
			R0110cell9.setCellValue("");
			R0110cell9.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column K
		Cell R0110cell10 = row.createCell(10);
		if (record.getR0110_post_collateral_haircut() != null) {
			R0110cell10.setCellValue(record.getR0110_post_collateral_haircut().doubleValue());
			R0110cell10.setCellStyle(numberStyle);
		} else {
			R0110cell10.setCellValue("");
			R0110cell10.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column L
		Cell R0110cell11 = row.createCell(11);
		if (record.getR0110_type_of_security() != null) {
			R0110cell11.setCellValue(record.getR0110_type_of_security().doubleValue());
			R0110cell11.setCellStyle(numberStyle);
		} else {
			R0110cell11.setCellValue("");
			R0110cell11.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column M
		Cell R0110cell12 = row.createCell(12);
		if (record.getR0110_discounted_collateral_value() != null) {
			R0110cell12.setCellValue(record.getR0110_discounted_collateral_value().doubleValue());
			R0110cell12.setCellStyle(numberStyle);
		} else {
			R0110cell12.setCellValue("");
			R0110cell12.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column N
		Cell R0110cell13 = row.createCell(13);
		if (record.getR0110_validated_discounted_cashflows() != null) {
			R0110cell13.setCellValue(record.getR0110_validated_discounted_cashflows().doubleValue());
			R0110cell13.setCellStyle(numberStyle);
		} else {
			R0110cell13.setCellValue("");
			R0110cell13.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column O
		Cell R0110cell14 = row.createCell(14);
		if (record.getR0110_pd() != null) {
			R0110cell14.setCellValue(record.getR0110_pd().doubleValue());
			R0110cell14.setCellStyle(numberStyle);
		} else {
			R0110cell14.setCellValue("");
			R0110cell14.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column P
		Cell R0110cell15 = row.createCell(15);
		if (record.getR0110_lgd() != null) {
			R0110cell15.setCellValue(record.getR0110_lgd().doubleValue());
			R0110cell15.setCellStyle(numberStyle);
		} else {
			R0110cell15.setCellValue("");
			R0110cell15.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column Q
		Cell R0110cell16 = row.createCell(16);
		if (record.getR0110_provisions_charged_pnl() != null) {
			R0110cell16.setCellValue(record.getR0110_provisions_charged_pnl().doubleValue());
			R0110cell16.setCellStyle(numberStyle);
		} else {
			R0110cell16.setCellValue("");
			R0110cell16.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column R
		Cell R0110cell17 = row.createCell(17);
		if (record.getR0110_legacy_interest_profit_suspense() != null) {
			R0110cell17.setCellValue(record.getR0110_legacy_interest_profit_suspense().doubleValue());
			R0110cell17.setCellStyle(numberStyle);
		} else {
			R0110cell17.setCellValue("");
			R0110cell17.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column S
		Cell R0110cell18 = row.createCell(18);
		if (record.getR0110_legal_case_yn() != null && !record.getR0110_legal_case_yn().isEmpty()) {
			R0110cell18.setCellValue(record.getR0110_legal_case_yn());
			R0110cell18.setCellStyle(textStyle);
		} else {
			R0110cell18.setCellValue("");
			R0110cell18.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column T
		Cell R0110cell19 = row.createCell(19);
		if (record.getR0110_remarks_if_any() != null && !record.getR0110_remarks_if_any().isEmpty()) {
			R0110cell19.setCellValue(record.getR0110_remarks_if_any());
			R0110cell19.setCellStyle(textStyle);
		} else {
			R0110cell19.setCellValue("");
			R0110cell19.setCellStyle(textStyle);
		}

		/// ROW20
		row = sheet.getRow(19);
		//// Column D
		Cell R0120cell3 = row.createCell(3);
		if (record.getR0120_borrower_name() != null && !record.getR0120_borrower_name().isEmpty()) {
			R0120cell3.setCellValue(record.getR0120_borrower_name());
			R0120cell3.setCellStyle(textStyle);
		} else {
			R0120cell3.setCellValue("");
			R0120cell3.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column E
		Cell R0120cell4 = row.createCell(4);
		if (record.getR0120_group_name_if_applicable() != null
				&& !record.getR0120_group_name_if_applicable().isEmpty()) {
			R0120cell4.setCellValue(record.getR0120_group_name_if_applicable());
			R0120cell4.setCellStyle(textStyle);
		} else {
			R0120cell4.setCellValue("");
			R0120cell4.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column F
		Cell R0120cell5 = row.createCell(5);
		if (record.getR0120_cin() != null && !record.getR0120_cin().isEmpty()) {
			R0120cell5.setCellValue(record.getR0120_cin());
			R0120cell5.setCellStyle(textStyle);
		} else {
			R0120cell5.setCellValue("");
			R0120cell5.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column G
		Cell R0120cell6 = row.createCell(6);
		if (record.getR0120_domicile_country() != null && !record.getR0120_domicile_country().isEmpty()) {
			R0120cell6.setCellValue(record.getR0120_domicile_country());
			R0120cell6.setCellStyle(textStyle);
		} else {
			R0120cell6.setCellValue("");
			R0120cell6.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column H
		Cell R0120cell7 = row.createCell(7);
		if (record.getR0120_funded_outstanding_amount() != null) {
			R0120cell7.setCellValue(record.getR0120_funded_outstanding_amount().doubleValue());
			R0120cell7.setCellStyle(numberStyle);
		} else {
			R0120cell7.setCellValue("");
			R0120cell7.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column I
		Cell R0120cell8 = row.createCell(8);
		if (record.getR0120_ccf_unfunded_outstanding_amount() != null) {
			R0120cell8.setCellValue(record.getR0120_ccf_unfunded_outstanding_amount().doubleValue());
			R0120cell8.setCellStyle(numberStyle);
		} else {
			R0120cell8.setCellValue("");
			R0120cell8.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column J
		Cell R0120cell9 = row.createCell(9);
		if (record.getR0120_secured_portion_exposure() != null) {
			R0120cell9.setCellValue(record.getR0120_secured_portion_exposure().doubleValue());
			R0120cell9.setCellStyle(numberStyle);
		} else {
			R0120cell9.setCellValue("");
			R0120cell9.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column K
		Cell R0120cell10 = row.createCell(10);
		if (record.getR0120_post_collateral_haircut() != null) {
			R0120cell10.setCellValue(record.getR0120_post_collateral_haircut().doubleValue());
			R0120cell10.setCellStyle(numberStyle);
		} else {
			R0120cell10.setCellValue("");
			R0120cell10.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column L
		Cell R0120cell11 = row.createCell(11);
		if (record.getR0120_type_of_security() != null) {
			R0120cell11.setCellValue(record.getR0120_type_of_security().doubleValue());
			R0120cell11.setCellStyle(numberStyle);
		} else {
			R0120cell11.setCellValue("");
			R0120cell11.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column M
		Cell R0120cell12 = row.createCell(12);
		if (record.getR0120_discounted_collateral_value() != null) {
			R0120cell12.setCellValue(record.getR0120_discounted_collateral_value().doubleValue());
			R0120cell12.setCellStyle(numberStyle);
		} else {
			R0120cell12.setCellValue("");
			R0120cell12.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column N
		Cell R0120cell13 = row.createCell(13);
		if (record.getR0120_validated_discounted_cashflows() != null) {
			R0120cell13.setCellValue(record.getR0120_validated_discounted_cashflows().doubleValue());
			R0120cell13.setCellStyle(numberStyle);
		} else {
			R0120cell13.setCellValue("");
			R0120cell13.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column O
		Cell R0120cell14 = row.createCell(14);
		if (record.getR0120_pd() != null) {
			R0120cell14.setCellValue(record.getR0120_pd().doubleValue());
			R0120cell14.setCellStyle(numberStyle);
		} else {
			R0120cell14.setCellValue("");
			R0120cell14.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column P
		Cell R0120cell15 = row.createCell(15);
		if (record.getR0120_lgd() != null) {
			R0120cell15.setCellValue(record.getR0120_lgd().doubleValue());
			R0120cell15.setCellStyle(numberStyle);
		} else {
			R0120cell15.setCellValue("");
			R0120cell15.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column Q
		Cell R0120cell16 = row.createCell(16);
		if (record.getR0120_provisions_charged_pnl() != null) {
			R0120cell16.setCellValue(record.getR0120_provisions_charged_pnl().doubleValue());
			R0120cell16.setCellStyle(numberStyle);
		} else {
			R0120cell16.setCellValue("");
			R0120cell16.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column R
		Cell R0120cell17 = row.createCell(17);
		if (record.getR0120_legacy_interest_profit_suspense() != null) {
			R0120cell17.setCellValue(record.getR0120_legacy_interest_profit_suspense().doubleValue());
			R0120cell17.setCellStyle(numberStyle);
		} else {
			R0120cell17.setCellValue("");
			R0120cell17.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column S
		Cell R0120cell18 = row.createCell(18);
		if (record.getR0120_legal_case_yn() != null && !record.getR0120_legal_case_yn().isEmpty()) {
			R0120cell18.setCellValue(record.getR0120_legal_case_yn());
			R0120cell18.setCellStyle(textStyle);
		} else {
			R0120cell18.setCellValue("");
			R0120cell18.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column T
		Cell R0120cell19 = row.createCell(19);
		if (record.getR0120_remarks_if_any() != null && !record.getR0120_remarks_if_any().isEmpty()) {
			R0120cell19.setCellValue(record.getR0120_remarks_if_any());
			R0120cell19.setCellStyle(textStyle);
		} else {
			R0120cell19.setCellValue("");
			R0120cell19.setCellStyle(textStyle);
		}

		/// ROW21
		row = sheet.getRow(20);
		//// Column D
		Cell R0130cell3 = row.createCell(3);
		if (record.getR0130_borrower_name() != null && !record.getR0130_borrower_name().isEmpty()) {
			R0130cell3.setCellValue(record.getR0130_borrower_name());
			R0130cell3.setCellStyle(textStyle);
		} else {
			R0130cell3.setCellValue("");
			R0130cell3.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column E
		Cell R0130cell4 = row.createCell(4);
		if (record.getR0130_group_name_if_applicable() != null
				&& !record.getR0130_group_name_if_applicable().isEmpty()) {
			R0130cell4.setCellValue(record.getR0130_group_name_if_applicable());
			R0130cell4.setCellStyle(textStyle);
		} else {
			R0130cell4.setCellValue("");
			R0130cell4.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column F
		Cell R0130cell5 = row.createCell(5);
		if (record.getR0130_cin() != null && !record.getR0130_cin().isEmpty()) {
			R0130cell5.setCellValue(record.getR0130_cin());
			R0130cell5.setCellStyle(textStyle);
		} else {
			R0130cell5.setCellValue("");
			R0130cell5.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column G
		Cell R0130cell6 = row.createCell(6);
		if (record.getR0130_domicile_country() != null && !record.getR0130_domicile_country().isEmpty()) {
			R0130cell6.setCellValue(record.getR0130_domicile_country());
			R0130cell6.setCellStyle(textStyle);
		} else {
			R0130cell6.setCellValue("");
			R0130cell6.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column H
		Cell R0130cell7 = row.createCell(7);
		if (record.getR0130_funded_outstanding_amount() != null) {
			R0130cell7.setCellValue(record.getR0130_funded_outstanding_amount().doubleValue());
			R0130cell7.setCellStyle(numberStyle);
		} else {
			R0130cell7.setCellValue("");
			R0130cell7.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column I
		Cell R0130cell8 = row.createCell(8);
		if (record.getR0130_ccf_unfunded_outstanding_amount() != null) {
			R0130cell8.setCellValue(record.getR0130_ccf_unfunded_outstanding_amount().doubleValue());
			R0130cell8.setCellStyle(numberStyle);
		} else {
			R0130cell8.setCellValue("");
			R0130cell8.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column J
		Cell R0130cell9 = row.createCell(9);
		if (record.getR0130_secured_portion_exposure() != null) {
			R0130cell9.setCellValue(record.getR0130_secured_portion_exposure().doubleValue());
			R0130cell9.setCellStyle(numberStyle);
		} else {
			R0130cell9.setCellValue("");
			R0130cell9.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column K
		Cell R0130cell10 = row.createCell(10);
		if (record.getR0130_post_collateral_haircut() != null) {
			R0130cell10.setCellValue(record.getR0130_post_collateral_haircut().doubleValue());
			R0130cell10.setCellStyle(numberStyle);
		} else {
			R0130cell10.setCellValue("");
			R0130cell10.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column L
		Cell R0130cell11 = row.createCell(11);
		if (record.getR0130_type_of_security() != null) {
			R0130cell11.setCellValue(record.getR0130_type_of_security().doubleValue());
			R0130cell11.setCellStyle(numberStyle);
		} else {
			R0130cell11.setCellValue("");
			R0130cell11.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column M
		Cell R0130cell12 = row.createCell(12);
		if (record.getR0130_discounted_collateral_value() != null) {
			R0130cell12.setCellValue(record.getR0130_discounted_collateral_value().doubleValue());
			R0130cell12.setCellStyle(numberStyle);
		} else {
			R0130cell12.setCellValue("");
			R0130cell12.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column N
		Cell R0130cell13 = row.createCell(13);
		if (record.getR0130_validated_discounted_cashflows() != null) {
			R0130cell13.setCellValue(record.getR0130_validated_discounted_cashflows().doubleValue());
			R0130cell13.setCellStyle(numberStyle);
		} else {
			R0130cell13.setCellValue("");
			R0130cell13.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column O
		Cell R0130cell14 = row.createCell(14);
		if (record.getR0130_pd() != null) {
			R0130cell14.setCellValue(record.getR0130_pd().doubleValue());
			R0130cell14.setCellStyle(numberStyle);
		} else {
			R0130cell14.setCellValue("");
			R0130cell14.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column P
		Cell R0130cell15 = row.createCell(15);
		if (record.getR0130_lgd() != null) {
			R0130cell15.setCellValue(record.getR0130_lgd().doubleValue());
			R0130cell15.setCellStyle(numberStyle);
		} else {
			R0130cell15.setCellValue("");
			R0130cell15.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column Q
		Cell R0130cell16 = row.createCell(16);
		if (record.getR0130_provisions_charged_pnl() != null) {
			R0130cell16.setCellValue(record.getR0130_provisions_charged_pnl().doubleValue());
			R0130cell16.setCellStyle(numberStyle);
		} else {
			R0130cell16.setCellValue("");
			R0130cell16.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column R
		Cell R0130cell17 = row.createCell(17);
		if (record.getR0130_legacy_interest_profit_suspense() != null) {
			R0130cell17.setCellValue(record.getR0130_legacy_interest_profit_suspense().doubleValue());
			R0130cell17.setCellStyle(numberStyle);
		} else {
			R0130cell17.setCellValue("");
			R0130cell17.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column S
		Cell R0130cell18 = row.createCell(18);
		if (record.getR0130_legal_case_yn() != null && !record.getR0130_legal_case_yn().isEmpty()) {
			R0130cell18.setCellValue(record.getR0130_legal_case_yn());
			R0130cell18.setCellStyle(textStyle);
		} else {
			R0130cell18.setCellValue("");
			R0130cell18.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column T
		Cell R0130cell19 = row.createCell(19);
		if (record.getR0130_remarks_if_any() != null && !record.getR0130_remarks_if_any().isEmpty()) {
			R0130cell19.setCellValue(record.getR0130_remarks_if_any());
			R0130cell19.setCellStyle(textStyle);
		} else {
			R0130cell19.setCellValue("");
			R0130cell19.setCellStyle(textStyle);
		}

		/// ROW22
		row = sheet.getRow(21);
		//// Column D
		Cell R0140cell3 = row.createCell(3);
		if (record.getR0140_borrower_name() != null && !record.getR0140_borrower_name().isEmpty()) {
			R0140cell3.setCellValue(record.getR0140_borrower_name());
			R0140cell3.setCellStyle(textStyle);
		} else {
			R0140cell3.setCellValue("");
			R0140cell3.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column E
		Cell R0140cell4 = row.createCell(4);
		if (record.getR0140_group_name_if_applicable() != null
				&& !record.getR0140_group_name_if_applicable().isEmpty()) {
			R0140cell4.setCellValue(record.getR0140_group_name_if_applicable());
			R0140cell4.setCellStyle(textStyle);
		} else {
			R0140cell4.setCellValue("");
			R0140cell4.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column F
		Cell R0140cell5 = row.createCell(5);
		if (record.getR0140_cin() != null && !record.getR0140_cin().isEmpty()) {
			R0140cell5.setCellValue(record.getR0140_cin());
			R0140cell5.setCellStyle(textStyle);
		} else {
			R0140cell5.setCellValue("");
			R0140cell5.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column G
		Cell R0140cell6 = row.createCell(6);
		if (record.getR0140_domicile_country() != null && !record.getR0140_domicile_country().isEmpty()) {
			R0140cell6.setCellValue(record.getR0140_domicile_country());
			R0140cell6.setCellStyle(textStyle);
		} else {
			R0140cell6.setCellValue("");
			R0140cell6.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column H
		Cell R0140cell7 = row.createCell(7);
		if (record.getR0140_funded_outstanding_amount() != null) {
			R0140cell7.setCellValue(record.getR0140_funded_outstanding_amount().doubleValue());
			R0140cell7.setCellStyle(numberStyle);
		} else {
			R0140cell7.setCellValue("");
			R0140cell7.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column I
		Cell R0140cell8 = row.createCell(8);
		if (record.getR0140_ccf_unfunded_outstanding_amount() != null) {
			R0140cell8.setCellValue(record.getR0140_ccf_unfunded_outstanding_amount().doubleValue());
			R0140cell8.setCellStyle(numberStyle);
		} else {
			R0140cell8.setCellValue("");
			R0140cell8.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column J
		Cell R0140cell9 = row.createCell(9);
		if (record.getR0140_secured_portion_exposure() != null) {
			R0140cell9.setCellValue(record.getR0140_secured_portion_exposure().doubleValue());
			R0140cell9.setCellStyle(numberStyle);
		} else {
			R0140cell9.setCellValue("");
			R0140cell9.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column K
		Cell R0140cell10 = row.createCell(10);
		if (record.getR0140_post_collateral_haircut() != null) {
			R0140cell10.setCellValue(record.getR0140_post_collateral_haircut().doubleValue());
			R0140cell10.setCellStyle(numberStyle);
		} else {
			R0140cell10.setCellValue("");
			R0140cell10.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column L
		Cell R0140cell11 = row.createCell(11);
		if (record.getR0140_type_of_security() != null) {
			R0140cell11.setCellValue(record.getR0140_type_of_security().doubleValue());
			R0140cell11.setCellStyle(numberStyle);
		} else {
			R0140cell11.setCellValue("");
			R0140cell11.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column M
		Cell R0140cell12 = row.createCell(12);
		if (record.getR0140_discounted_collateral_value() != null) {
			R0140cell12.setCellValue(record.getR0140_discounted_collateral_value().doubleValue());
			R0140cell12.setCellStyle(numberStyle);
		} else {
			R0140cell12.setCellValue("");
			R0140cell12.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column N
		Cell R0140cell13 = row.createCell(13);
		if (record.getR0140_validated_discounted_cashflows() != null) {
			R0140cell13.setCellValue(record.getR0140_validated_discounted_cashflows().doubleValue());
			R0140cell13.setCellStyle(numberStyle);
		} else {
			R0140cell13.setCellValue("");
			R0140cell13.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column O
		Cell R0140cell14 = row.createCell(14);
		if (record.getR0140_pd() != null) {
			R0140cell14.setCellValue(record.getR0140_pd().doubleValue());
			R0140cell14.setCellStyle(numberStyle);
		} else {
			R0140cell14.setCellValue("");
			R0140cell14.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column P
		Cell R0140cell15 = row.createCell(15);
		if (record.getR0140_lgd() != null) {
			R0140cell15.setCellValue(record.getR0140_lgd().doubleValue());
			R0140cell15.setCellStyle(numberStyle);
		} else {
			R0140cell15.setCellValue("");
			R0140cell15.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column Q
		Cell R0140cell16 = row.createCell(16);
		if (record.getR0140_provisions_charged_pnl() != null) {
			R0140cell16.setCellValue(record.getR0140_provisions_charged_pnl().doubleValue());
			R0140cell16.setCellStyle(numberStyle);
		} else {
			R0140cell16.setCellValue("");
			R0140cell16.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column R
		Cell R0140cell17 = row.createCell(17);
		if (record.getR0140_legacy_interest_profit_suspense() != null) {
			R0140cell17.setCellValue(record.getR0140_legacy_interest_profit_suspense().doubleValue());
			R0140cell17.setCellStyle(numberStyle);
		} else {
			R0140cell17.setCellValue("");
			R0140cell17.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column S
		Cell R0140cell18 = row.createCell(18);
		if (record.getR0140_legal_case_yn() != null && !record.getR0140_legal_case_yn().isEmpty()) {
			R0140cell18.setCellValue(record.getR0140_legal_case_yn());
			R0140cell18.setCellStyle(textStyle);
		} else {
			R0140cell18.setCellValue("");
			R0140cell18.setCellStyle(textStyle);
		}

		/// ROW22
		//// Column T
		Cell R0140cell19 = row.createCell(19);
		if (record.getR0140_remarks_if_any() != null && !record.getR0140_remarks_if_any().isEmpty()) {
			R0140cell19.setCellValue(record.getR0140_remarks_if_any());
			R0140cell19.setCellStyle(textStyle);
		} else {
			R0140cell19.setCellValue("");
			R0140cell19.setCellStyle(textStyle);
		}

		/// ROW23
		row = sheet.getRow(22);
		//// Column D
		Cell R0150cell3 = row.createCell(3);
		if (record.getR0150_borrower_name() != null && !record.getR0150_borrower_name().isEmpty()) {
			R0150cell3.setCellValue(record.getR0150_borrower_name());
			R0150cell3.setCellStyle(textStyle);
		} else {
			R0150cell3.setCellValue("");
			R0150cell3.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column E
		Cell R0150cell4 = row.createCell(4);
		if (record.getR0150_group_name_if_applicable() != null
				&& !record.getR0150_group_name_if_applicable().isEmpty()) {
			R0150cell4.setCellValue(record.getR0150_group_name_if_applicable());
			R0150cell4.setCellStyle(textStyle);
		} else {
			R0150cell4.setCellValue("");
			R0150cell4.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column F
		Cell R0150cell5 = row.createCell(5);
		if (record.getR0150_cin() != null && !record.getR0150_cin().isEmpty()) {
			R0150cell5.setCellValue(record.getR0150_cin());
			R0150cell5.setCellStyle(textStyle);
		} else {
			R0150cell5.setCellValue("");
			R0150cell5.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column G
		Cell R0150cell6 = row.createCell(6);
		if (record.getR0150_domicile_country() != null && !record.getR0150_domicile_country().isEmpty()) {
			R0150cell6.setCellValue(record.getR0150_domicile_country());
			R0150cell6.setCellStyle(textStyle);
		} else {
			R0150cell6.setCellValue("");
			R0150cell6.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column H
		Cell R0150cell7 = row.createCell(7);
		if (record.getR0150_funded_outstanding_amount() != null) {
			R0150cell7.setCellValue(record.getR0150_funded_outstanding_amount().doubleValue());
			R0150cell7.setCellStyle(numberStyle);
		} else {
			R0150cell7.setCellValue("");
			R0150cell7.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column I
		Cell R0150cell8 = row.createCell(8);
		if (record.getR0150_ccf_unfunded_outstanding_amount() != null) {
			R0150cell8.setCellValue(record.getR0150_ccf_unfunded_outstanding_amount().doubleValue());
			R0150cell8.setCellStyle(numberStyle);
		} else {
			R0150cell8.setCellValue("");
			R0150cell8.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column J
		Cell R0150cell9 = row.createCell(9);
		if (record.getR0150_secured_portion_exposure() != null) {
			R0150cell9.setCellValue(record.getR0150_secured_portion_exposure().doubleValue());
			R0150cell9.setCellStyle(numberStyle);
		} else {
			R0150cell9.setCellValue("");
			R0150cell9.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column K
		Cell R0150cell10 = row.createCell(10);
		if (record.getR0150_post_collateral_haircut() != null) {
			R0150cell10.setCellValue(record.getR0150_post_collateral_haircut().doubleValue());
			R0150cell10.setCellStyle(numberStyle);
		} else {
			R0150cell10.setCellValue("");
			R0150cell10.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column L
		Cell R0150cell11 = row.createCell(11);
		if (record.getR0150_type_of_security() != null) {
			R0150cell11.setCellValue(record.getR0150_type_of_security().doubleValue());
			R0150cell11.setCellStyle(numberStyle);
		} else {
			R0150cell11.setCellValue("");
			R0150cell11.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column M
		Cell R0150cell12 = row.createCell(12);
		if (record.getR0150_discounted_collateral_value() != null) {
			R0150cell12.setCellValue(record.getR0150_discounted_collateral_value().doubleValue());
			R0150cell12.setCellStyle(numberStyle);
		} else {
			R0150cell12.setCellValue("");
			R0150cell12.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column N
		Cell R0150cell13 = row.createCell(13);
		if (record.getR0150_validated_discounted_cashflows() != null) {
			R0150cell13.setCellValue(record.getR0150_validated_discounted_cashflows().doubleValue());
			R0150cell13.setCellStyle(numberStyle);
		} else {
			R0150cell13.setCellValue("");
			R0150cell13.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column O
		Cell R0150cell14 = row.createCell(14);
		if (record.getR0150_pd() != null) {
			R0150cell14.setCellValue(record.getR0150_pd().doubleValue());
			R0150cell14.setCellStyle(numberStyle);
		} else {
			R0150cell14.setCellValue("");
			R0150cell14.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column P
		Cell R0150cell15 = row.createCell(15);
		if (record.getR0150_lgd() != null) {
			R0150cell15.setCellValue(record.getR0150_lgd().doubleValue());
			R0150cell15.setCellStyle(numberStyle);
		} else {
			R0150cell15.setCellValue("");
			R0150cell15.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column Q
		Cell R0150cell16 = row.createCell(16);
		if (record.getR0150_provisions_charged_pnl() != null) {
			R0150cell16.setCellValue(record.getR0150_provisions_charged_pnl().doubleValue());
			R0150cell16.setCellStyle(numberStyle);
		} else {
			R0150cell16.setCellValue("");
			R0150cell16.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column R
		Cell R0150cell17 = row.createCell(17);
		if (record.getR0150_legacy_interest_profit_suspense() != null) {
			R0150cell17.setCellValue(record.getR0150_legacy_interest_profit_suspense().doubleValue());
			R0150cell17.setCellStyle(numberStyle);
		} else {
			R0150cell17.setCellValue("");
			R0150cell17.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column S
		Cell R0150cell18 = row.createCell(18);
		if (record.getR0150_legal_case_yn() != null && !record.getR0150_legal_case_yn().isEmpty()) {
			R0150cell18.setCellValue(record.getR0150_legal_case_yn());
			R0150cell18.setCellStyle(textStyle);
		} else {
			R0150cell18.setCellValue("");
			R0150cell18.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column T
		Cell R0150cell19 = row.createCell(19);
		if (record.getR0150_remarks_if_any() != null && !record.getR0150_remarks_if_any().isEmpty()) {
			R0150cell19.setCellValue(record.getR0150_remarks_if_any());
			R0150cell19.setCellStyle(textStyle);
		} else {
			R0150cell19.setCellValue("");
			R0150cell19.setCellStyle(textStyle);
		}

		/// ROW24
		row = sheet.getRow(23);
		//// Column D
		Cell R0160cell3 = row.createCell(3);
		if (record.getR0160_borrower_name() != null && !record.getR0160_borrower_name().isEmpty()) {
			R0160cell3.setCellValue(record.getR0160_borrower_name());
			R0160cell3.setCellStyle(textStyle);
		} else {
			R0160cell3.setCellValue("");
			R0160cell3.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column E
		Cell R0160cell4 = row.createCell(4);
		if (record.getR0160_group_name_if_applicable() != null
				&& !record.getR0160_group_name_if_applicable().isEmpty()) {
			R0160cell4.setCellValue(record.getR0160_group_name_if_applicable());
			R0160cell4.setCellStyle(textStyle);
		} else {
			R0160cell4.setCellValue("");
			R0160cell4.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column F
		Cell R0160cell5 = row.createCell(5);
		if (record.getR0160_cin() != null && !record.getR0160_cin().isEmpty()) {
			R0160cell5.setCellValue(record.getR0160_cin());
			R0160cell5.setCellStyle(textStyle);
		} else {
			R0160cell5.setCellValue("");
			R0160cell5.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column G
		Cell R0160cell6 = row.createCell(6);
		if (record.getR0160_domicile_country() != null && !record.getR0160_domicile_country().isEmpty()) {
			R0160cell6.setCellValue(record.getR0160_domicile_country());
			R0160cell6.setCellStyle(textStyle);
		} else {
			R0160cell6.setCellValue("");
			R0160cell6.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column H
		Cell R0160cell7 = row.createCell(7);
		if (record.getR0160_funded_outstanding_amount() != null) {
			R0160cell7.setCellValue(record.getR0160_funded_outstanding_amount().doubleValue());
			R0160cell7.setCellStyle(numberStyle);
		} else {
			R0160cell7.setCellValue("");
			R0160cell7.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column I
		Cell R0160cell8 = row.createCell(8);
		if (record.getR0160_ccf_unfunded_outstanding_amount() != null) {
			R0160cell8.setCellValue(record.getR0160_ccf_unfunded_outstanding_amount().doubleValue());
			R0160cell8.setCellStyle(numberStyle);
		} else {
			R0160cell8.setCellValue("");
			R0160cell8.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column J
		Cell R0160cell9 = row.createCell(9);
		if (record.getR0160_secured_portion_exposure() != null) {
			R0160cell9.setCellValue(record.getR0160_secured_portion_exposure().doubleValue());
			R0160cell9.setCellStyle(numberStyle);
		} else {
			R0160cell9.setCellValue("");
			R0160cell9.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column K
		Cell R0160cell10 = row.createCell(10);
		if (record.getR0160_post_collateral_haircut() != null) {
			R0160cell10.setCellValue(record.getR0160_post_collateral_haircut().doubleValue());
			R0160cell10.setCellStyle(numberStyle);
		} else {
			R0160cell10.setCellValue("");
			R0160cell10.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column L
		Cell R0160cell11 = row.createCell(11);
		if (record.getR0160_type_of_security() != null) {
			R0160cell11.setCellValue(record.getR0160_type_of_security().doubleValue());
			R0160cell11.setCellStyle(numberStyle);
		} else {
			R0160cell11.setCellValue("");
			R0160cell11.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column M
		Cell R0160cell12 = row.createCell(12);
		if (record.getR0160_discounted_collateral_value() != null) {
			R0160cell12.setCellValue(record.getR0160_discounted_collateral_value().doubleValue());
			R0160cell12.setCellStyle(numberStyle);
		} else {
			R0160cell12.setCellValue("");
			R0160cell12.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column N
		Cell R0160cell13 = row.createCell(13);
		if (record.getR0160_validated_discounted_cashflows() != null) {
			R0160cell13.setCellValue(record.getR0160_validated_discounted_cashflows().doubleValue());
			R0160cell13.setCellStyle(numberStyle);
		} else {
			R0160cell13.setCellValue("");
			R0160cell13.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column O
		Cell R0160cell14 = row.createCell(14);
		if (record.getR0160_pd() != null) {
			R0160cell14.setCellValue(record.getR0160_pd().doubleValue());
			R0160cell14.setCellStyle(numberStyle);
		} else {
			R0160cell14.setCellValue("");
			R0160cell14.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column P
		Cell R0160cell15 = row.createCell(15);
		if (record.getR0160_lgd() != null) {
			R0160cell15.setCellValue(record.getR0160_lgd().doubleValue());
			R0160cell15.setCellStyle(numberStyle);
		} else {
			R0160cell15.setCellValue("");
			R0160cell15.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column Q
		Cell R0160cell16 = row.createCell(16);
		if (record.getR0160_provisions_charged_pnl() != null) {
			R0160cell16.setCellValue(record.getR0160_provisions_charged_pnl().doubleValue());
			R0160cell16.setCellStyle(numberStyle);
		} else {
			R0160cell16.setCellValue("");
			R0160cell16.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column R
		Cell R0160cell17 = row.createCell(17);
		if (record.getR0160_legacy_interest_profit_suspense() != null) {
			R0160cell17.setCellValue(record.getR0160_legacy_interest_profit_suspense().doubleValue());
			R0160cell17.setCellStyle(numberStyle);
		} else {
			R0160cell17.setCellValue("");
			R0160cell17.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column S
		Cell R0160cell18 = row.createCell(18);
		if (record.getR0160_legal_case_yn() != null && !record.getR0160_legal_case_yn().isEmpty()) {
			R0160cell18.setCellValue(record.getR0160_legal_case_yn());
			R0160cell18.setCellStyle(textStyle);
		} else {
			R0160cell18.setCellValue("");
			R0160cell18.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column T
		Cell R0160cell19 = row.createCell(19);
		if (record.getR0160_remarks_if_any() != null && !record.getR0160_remarks_if_any().isEmpty()) {
			R0160cell19.setCellValue(record.getR0160_remarks_if_any());
			R0160cell19.setCellStyle(textStyle);
		} else {
			R0160cell19.setCellValue("");
			R0160cell19.setCellStyle(textStyle);
		}

		/// ROW27
		row = sheet.getRow(26);
		//// Column D
		Cell R0190cell3 = row.createCell(3);
		if (record.getR0190_borrower_name() != null && !record.getR0190_borrower_name().isEmpty()) {
			R0190cell3.setCellValue(record.getR0190_borrower_name());
			R0190cell3.setCellStyle(textStyle);
		} else {
			R0190cell3.setCellValue("");
			R0190cell3.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column E
		Cell R0190cell4 = row.createCell(4);
		if (record.getR0190_group_name_if_applicable() != null
				&& !record.getR0190_group_name_if_applicable().isEmpty()) {
			R0190cell4.setCellValue(record.getR0190_group_name_if_applicable());
			R0190cell4.setCellStyle(textStyle);
		} else {
			R0190cell4.setCellValue("");
			R0190cell4.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column F
		Cell R0190cell5 = row.createCell(5);
		if (record.getR0190_cin() != null && !record.getR0190_cin().isEmpty()) {
			R0190cell5.setCellValue(record.getR0190_cin());
			R0190cell5.setCellStyle(textStyle);
		} else {
			R0190cell5.setCellValue("");
			R0190cell5.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column G
		Cell R0190cell6 = row.createCell(6);
		if (record.getR0190_domicile_country() != null && !record.getR0190_domicile_country().isEmpty()) {
			R0190cell6.setCellValue(record.getR0190_domicile_country());
			R0190cell6.setCellStyle(textStyle);
		} else {
			R0190cell6.setCellValue("");
			R0190cell6.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column H
		Cell R0190cell7 = row.createCell(7);
		if (record.getR0190_funded_outstanding_amount() != null) {
			R0190cell7.setCellValue(record.getR0190_funded_outstanding_amount().doubleValue());
			R0190cell7.setCellStyle(numberStyle);
		} else {
			R0190cell7.setCellValue("");
			R0190cell7.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column I
		Cell R0190cell8 = row.createCell(8);
		if (record.getR0190_ccf_unfunded_outstanding_amount() != null) {
			R0190cell8.setCellValue(record.getR0190_ccf_unfunded_outstanding_amount().doubleValue());
			R0190cell8.setCellStyle(numberStyle);
		} else {
			R0190cell8.setCellValue("");
			R0190cell8.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column J
		Cell R0190cell9 = row.createCell(9);
		if (record.getR0190_secured_portion_exposure() != null) {
			R0190cell9.setCellValue(record.getR0190_secured_portion_exposure().doubleValue());
			R0190cell9.setCellStyle(numberStyle);
		} else {
			R0190cell9.setCellValue("");
			R0190cell9.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column K
		Cell R0190cell10 = row.createCell(10);
		if (record.getR0190_post_collateral_haircut() != null) {
			R0190cell10.setCellValue(record.getR0190_post_collateral_haircut().doubleValue());
			R0190cell10.setCellStyle(numberStyle);
		} else {
			R0190cell10.setCellValue("");
			R0190cell10.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column L
		Cell R0190cell11 = row.createCell(11);
		if (record.getR0190_type_of_security() != null) {
			R0190cell11.setCellValue(record.getR0190_type_of_security().doubleValue());
			R0190cell11.setCellStyle(numberStyle);
		} else {
			R0190cell11.setCellValue("");
			R0190cell11.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column M
		Cell R0190cell12 = row.createCell(12);
		if (record.getR0190_discounted_collateral_value() != null) {
			R0190cell12.setCellValue(record.getR0190_discounted_collateral_value().doubleValue());
			R0190cell12.setCellStyle(numberStyle);
		} else {
			R0190cell12.setCellValue("");
			R0190cell12.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column N
		Cell R0190cell13 = row.createCell(13);
		if (record.getR0190_validated_discounted_cashflows() != null) {
			R0190cell13.setCellValue(record.getR0190_validated_discounted_cashflows().doubleValue());
			R0190cell13.setCellStyle(numberStyle);
		} else {
			R0190cell13.setCellValue("");
			R0190cell13.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column O
		Cell R0190cell14 = row.createCell(14);
		if (record.getR0190_pd() != null) {
			R0190cell14.setCellValue(record.getR0190_pd().doubleValue());
			R0190cell14.setCellStyle(numberStyle);
		} else {
			R0190cell14.setCellValue("");
			R0190cell14.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column P
		Cell R0190cell15 = row.createCell(15);
		if (record.getR0190_lgd() != null) {
			R0190cell15.setCellValue(record.getR0190_lgd().doubleValue());
			R0190cell15.setCellStyle(numberStyle);
		} else {
			R0190cell15.setCellValue("");
			R0190cell15.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column Q
		Cell R0190cell16 = row.createCell(16);
		if (record.getR0190_provisions_charged_pnl() != null) {
			R0190cell16.setCellValue(record.getR0190_provisions_charged_pnl().doubleValue());
			R0190cell16.setCellStyle(numberStyle);
		} else {
			R0190cell16.setCellValue("");
			R0190cell16.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column R
		Cell R0190cell17 = row.createCell(17);
		if (record.getR0190_legacy_interest_profit_suspense() != null) {
			R0190cell17.setCellValue(record.getR0190_legacy_interest_profit_suspense().doubleValue());
			R0190cell17.setCellStyle(numberStyle);
		} else {
			R0190cell17.setCellValue("");
			R0190cell17.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column S
		Cell R0190cell18 = row.createCell(18);
		if (record.getR0190_legal_case_yn() != null && !record.getR0190_legal_case_yn().isEmpty()) {
			R0190cell18.setCellValue(record.getR0190_legal_case_yn());
			R0190cell18.setCellStyle(textStyle);
		} else {
			R0190cell18.setCellValue("");
			R0190cell18.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column T
		Cell R0190cell19 = row.createCell(19);
		if (record.getR0190_remarks_if_any() != null && !record.getR0190_remarks_if_any().isEmpty()) {
			R0190cell19.setCellValue(record.getR0190_remarks_if_any());
			R0190cell19.setCellStyle(textStyle);
		} else {
			R0190cell19.setCellValue("");
			R0190cell19.setCellStyle(textStyle);
		}

		/// ROW28
		row = sheet.getRow(27);
		//// Column D
		Cell R0200cell3 = row.createCell(3);
		if (record.getR0200_borrower_name() != null && !record.getR0200_borrower_name().isEmpty()) {
			R0200cell3.setCellValue(record.getR0200_borrower_name());
			R0200cell3.setCellStyle(textStyle);
		} else {
			R0200cell3.setCellValue("");
			R0200cell3.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column E
		Cell R0200cell4 = row.createCell(4);
		if (record.getR0200_group_name_if_applicable() != null
				&& !record.getR0200_group_name_if_applicable().isEmpty()) {
			R0200cell4.setCellValue(record.getR0200_group_name_if_applicable());
			R0200cell4.setCellStyle(textStyle);
		} else {
			R0200cell4.setCellValue("");
			R0200cell4.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column F
		Cell R0200cell5 = row.createCell(5);
		if (record.getR0200_cin() != null && !record.getR0200_cin().isEmpty()) {
			R0200cell5.setCellValue(record.getR0200_cin());
			R0200cell5.setCellStyle(textStyle);
		} else {
			R0200cell5.setCellValue("");
			R0200cell5.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column G
		Cell R0200cell6 = row.createCell(6);
		if (record.getR0200_domicile_country() != null && !record.getR0200_domicile_country().isEmpty()) {
			R0200cell6.setCellValue(record.getR0200_domicile_country());
			R0200cell6.setCellStyle(textStyle);
		} else {
			R0200cell6.setCellValue("");
			R0200cell6.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column H
		Cell R0200cell7 = row.createCell(7);
		if (record.getR0200_funded_outstanding_amount() != null) {
			R0200cell7.setCellValue(record.getR0200_funded_outstanding_amount().doubleValue());
			R0200cell7.setCellStyle(numberStyle);
		} else {
			R0200cell7.setCellValue("");
			R0200cell7.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column I
		Cell R0200cell8 = row.createCell(8);
		if (record.getR0200_ccf_unfunded_outstanding_amount() != null) {
			R0200cell8.setCellValue(record.getR0200_ccf_unfunded_outstanding_amount().doubleValue());
			R0200cell8.setCellStyle(numberStyle);
		} else {
			R0200cell8.setCellValue("");
			R0200cell8.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column J
		Cell R0200cell9 = row.createCell(9);
		if (record.getR0200_secured_portion_exposure() != null) {
			R0200cell9.setCellValue(record.getR0200_secured_portion_exposure().doubleValue());
			R0200cell9.setCellStyle(numberStyle);
		} else {
			R0200cell9.setCellValue("");
			R0200cell9.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column K
		Cell R0200cell10 = row.createCell(10);
		if (record.getR0200_post_collateral_haircut() != null) {
			R0200cell10.setCellValue(record.getR0200_post_collateral_haircut().doubleValue());
			R0200cell10.setCellStyle(numberStyle);
		} else {
			R0200cell10.setCellValue("");
			R0200cell10.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column L
		Cell R0200cell11 = row.createCell(11);
		if (record.getR0200_type_of_security() != null) {
			R0200cell11.setCellValue(record.getR0200_type_of_security().doubleValue());
			R0200cell11.setCellStyle(numberStyle);
		} else {
			R0200cell11.setCellValue("");
			R0200cell11.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column M
		Cell R0200cell12 = row.createCell(12);
		if (record.getR0200_discounted_collateral_value() != null) {
			R0200cell12.setCellValue(record.getR0200_discounted_collateral_value().doubleValue());
			R0200cell12.setCellStyle(numberStyle);
		} else {
			R0200cell12.setCellValue("");
			R0200cell12.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column N
		Cell R0200cell13 = row.createCell(13);
		if (record.getR0200_validated_discounted_cashflows() != null) {
			R0200cell13.setCellValue(record.getR0200_validated_discounted_cashflows().doubleValue());
			R0200cell13.setCellStyle(numberStyle);
		} else {
			R0200cell13.setCellValue("");
			R0200cell13.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column O
		Cell R0200cell14 = row.createCell(14);
		if (record.getR0200_pd() != null) {
			R0200cell14.setCellValue(record.getR0200_pd().doubleValue());
			R0200cell14.setCellStyle(numberStyle);
		} else {
			R0200cell14.setCellValue("");
			R0200cell14.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column P
		Cell R0200cell15 = row.createCell(15);
		if (record.getR0200_lgd() != null) {
			R0200cell15.setCellValue(record.getR0200_lgd().doubleValue());
			R0200cell15.setCellStyle(numberStyle);
		} else {
			R0200cell15.setCellValue("");
			R0200cell15.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column Q
		Cell R0200cell16 = row.createCell(16);
		if (record.getR0200_provisions_charged_pnl() != null) {
			R0200cell16.setCellValue(record.getR0200_provisions_charged_pnl().doubleValue());
			R0200cell16.setCellStyle(numberStyle);
		} else {
			R0200cell16.setCellValue("");
			R0200cell16.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column R
		Cell R0200cell17 = row.createCell(17);
		if (record.getR0200_legacy_interest_profit_suspense() != null) {
			R0200cell17.setCellValue(record.getR0200_legacy_interest_profit_suspense().doubleValue());
			R0200cell17.setCellStyle(numberStyle);
		} else {
			R0200cell17.setCellValue("");
			R0200cell17.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column S
		Cell R0200cell18 = row.createCell(18);
		if (record.getR0200_legal_case_yn() != null && !record.getR0200_legal_case_yn().isEmpty()) {
			R0200cell18.setCellValue(record.getR0200_legal_case_yn());
			R0200cell18.setCellStyle(textStyle);
		} else {
			R0200cell18.setCellValue("");
			R0200cell18.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column T
		Cell R0200cell19 = row.createCell(19);
		if (record.getR0200_remarks_if_any() != null && !record.getR0200_remarks_if_any().isEmpty()) {
			R0200cell19.setCellValue(record.getR0200_remarks_if_any());
			R0200cell19.setCellStyle(textStyle);
		} else {
			R0200cell19.setCellValue("");
			R0200cell19.setCellStyle(textStyle);
		}

		/// ROW29
		row = sheet.getRow(28);
		//// Column D
		Cell R0210cell3 = row.createCell(3);
		if (record.getR0210_borrower_name() != null && !record.getR0210_borrower_name().isEmpty()) {
			R0210cell3.setCellValue(record.getR0210_borrower_name());
			R0210cell3.setCellStyle(textStyle);
		} else {
			R0210cell3.setCellValue("");
			R0210cell3.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column E
		Cell R0210cell4 = row.createCell(4);
		if (record.getR0210_group_name_if_applicable() != null
				&& !record.getR0210_group_name_if_applicable().isEmpty()) {
			R0210cell4.setCellValue(record.getR0210_group_name_if_applicable());
			R0210cell4.setCellStyle(textStyle);
		} else {
			R0210cell4.setCellValue("");
			R0210cell4.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column F
		Cell R0210cell5 = row.createCell(5);
		if (record.getR0210_cin() != null && !record.getR0210_cin().isEmpty()) {
			R0210cell5.setCellValue(record.getR0210_cin());
			R0210cell5.setCellStyle(textStyle);
		} else {
			R0210cell5.setCellValue("");
			R0210cell5.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column G
		Cell R0210cell6 = row.createCell(6);
		if (record.getR0210_domicile_country() != null && !record.getR0210_domicile_country().isEmpty()) {
			R0210cell6.setCellValue(record.getR0210_domicile_country());
			R0210cell6.setCellStyle(textStyle);
		} else {
			R0210cell6.setCellValue("");
			R0210cell6.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column H
		Cell R0210cell7 = row.createCell(7);
		if (record.getR0210_funded_outstanding_amount() != null) {
			R0210cell7.setCellValue(record.getR0210_funded_outstanding_amount().doubleValue());
			R0210cell7.setCellStyle(numberStyle);
		} else {
			R0210cell7.setCellValue("");
			R0210cell7.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column I
		Cell R0210cell8 = row.createCell(8);
		if (record.getR0210_ccf_unfunded_outstanding_amount() != null) {
			R0210cell8.setCellValue(record.getR0210_ccf_unfunded_outstanding_amount().doubleValue());
			R0210cell8.setCellStyle(numberStyle);
		} else {
			R0210cell8.setCellValue("");
			R0210cell8.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column J
		Cell R0210cell9 = row.createCell(9);
		if (record.getR0210_secured_portion_exposure() != null) {
			R0210cell9.setCellValue(record.getR0210_secured_portion_exposure().doubleValue());
			R0210cell9.setCellStyle(numberStyle);
		} else {
			R0210cell9.setCellValue("");
			R0210cell9.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column K
		Cell R0210cell10 = row.createCell(10);
		if (record.getR0210_post_collateral_haircut() != null) {
			R0210cell10.setCellValue(record.getR0210_post_collateral_haircut().doubleValue());
			R0210cell10.setCellStyle(numberStyle);
		} else {
			R0210cell10.setCellValue("");
			R0210cell10.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column L
		Cell R0210cell11 = row.createCell(11);
		if (record.getR0210_type_of_security() != null) {
			R0210cell11.setCellValue(record.getR0210_type_of_security().doubleValue());
			R0210cell11.setCellStyle(numberStyle);
		} else {
			R0210cell11.setCellValue("");
			R0210cell11.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column M
		Cell R0210cell12 = row.createCell(12);
		if (record.getR0210_discounted_collateral_value() != null) {
			R0210cell12.setCellValue(record.getR0210_discounted_collateral_value().doubleValue());
			R0210cell12.setCellStyle(numberStyle);
		} else {
			R0210cell12.setCellValue("");
			R0210cell12.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column N
		Cell R0210cell13 = row.createCell(13);
		if (record.getR0210_validated_discounted_cashflows() != null) {
			R0210cell13.setCellValue(record.getR0210_validated_discounted_cashflows().doubleValue());
			R0210cell13.setCellStyle(numberStyle);
		} else {
			R0210cell13.setCellValue("");
			R0210cell13.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column O
		Cell R0210cell14 = row.createCell(14);
		if (record.getR0210_pd() != null) {
			R0210cell14.setCellValue(record.getR0210_pd().doubleValue());
			R0210cell14.setCellStyle(numberStyle);
		} else {
			R0210cell14.setCellValue("");
			R0210cell14.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column P
		Cell R0210cell15 = row.createCell(15);
		if (record.getR0210_lgd() != null) {
			R0210cell15.setCellValue(record.getR0210_lgd().doubleValue());
			R0210cell15.setCellStyle(numberStyle);
		} else {
			R0210cell15.setCellValue("");
			R0210cell15.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column Q
		Cell R0210cell16 = row.createCell(16);
		if (record.getR0210_provisions_charged_pnl() != null) {
			R0210cell16.setCellValue(record.getR0210_provisions_charged_pnl().doubleValue());
			R0210cell16.setCellStyle(numberStyle);
		} else {
			R0210cell16.setCellValue("");
			R0210cell16.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column R
		Cell R0210cell17 = row.createCell(17);
		if (record.getR0210_legacy_interest_profit_suspense() != null) {
			R0210cell17.setCellValue(record.getR0210_legacy_interest_profit_suspense().doubleValue());
			R0210cell17.setCellStyle(numberStyle);
		} else {
			R0210cell17.setCellValue("");
			R0210cell17.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column S
		Cell R0210cell18 = row.createCell(18);
		if (record.getR0210_legal_case_yn() != null && !record.getR0210_legal_case_yn().isEmpty()) {
			R0210cell18.setCellValue(record.getR0210_legal_case_yn());
			R0210cell18.setCellStyle(textStyle);
		} else {
			R0210cell18.setCellValue("");
			R0210cell18.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column T
		Cell R0210cell19 = row.createCell(19);
		if (record.getR0210_remarks_if_any() != null && !record.getR0210_remarks_if_any().isEmpty()) {
			R0210cell19.setCellValue(record.getR0210_remarks_if_any());
			R0210cell19.setCellStyle(textStyle);
		} else {
			R0210cell19.setCellValue("");
			R0210cell19.setCellStyle(textStyle);
		}

		/// ROW30
		row = sheet.getRow(29);
		//// Column D
		Cell R0220cell3 = row.createCell(3);
		if (record.getR0220_borrower_name() != null && !record.getR0220_borrower_name().isEmpty()) {
			R0220cell3.setCellValue(record.getR0220_borrower_name());
			R0220cell3.setCellStyle(textStyle);
		} else {
			R0220cell3.setCellValue("");
			R0220cell3.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column E
		Cell R0220cell4 = row.createCell(4);
		if (record.getR0220_group_name_if_applicable() != null
				&& !record.getR0220_group_name_if_applicable().isEmpty()) {
			R0220cell4.setCellValue(record.getR0220_group_name_if_applicable());
			R0220cell4.setCellStyle(textStyle);
		} else {
			R0220cell4.setCellValue("");
			R0220cell4.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column F
		Cell R0220cell5 = row.createCell(5);
		if (record.getR0220_cin() != null && !record.getR0220_cin().isEmpty()) {
			R0220cell5.setCellValue(record.getR0220_cin());
			R0220cell5.setCellStyle(textStyle);
		} else {
			R0220cell5.setCellValue("");
			R0220cell5.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column G
		Cell R0220cell6 = row.createCell(6);
		if (record.getR0220_domicile_country() != null && !record.getR0220_domicile_country().isEmpty()) {
			R0220cell6.setCellValue(record.getR0220_domicile_country());
			R0220cell6.setCellStyle(textStyle);
		} else {
			R0220cell6.setCellValue("");
			R0220cell6.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column H
		Cell R0220cell7 = row.createCell(7);
		if (record.getR0220_funded_outstanding_amount() != null) {
			R0220cell7.setCellValue(record.getR0220_funded_outstanding_amount().doubleValue());
			R0220cell7.setCellStyle(numberStyle);
		} else {
			R0220cell7.setCellValue("");
			R0220cell7.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column I
		Cell R0220cell8 = row.createCell(8);
		if (record.getR0220_ccf_unfunded_outstanding_amount() != null) {
			R0220cell8.setCellValue(record.getR0220_ccf_unfunded_outstanding_amount().doubleValue());
			R0220cell8.setCellStyle(numberStyle);
		} else {
			R0220cell8.setCellValue("");
			R0220cell8.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column J
		Cell R0220cell9 = row.createCell(9);
		if (record.getR0220_secured_portion_exposure() != null) {
			R0220cell9.setCellValue(record.getR0220_secured_portion_exposure().doubleValue());
			R0220cell9.setCellStyle(numberStyle);
		} else {
			R0220cell9.setCellValue("");
			R0220cell9.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column K
		Cell R0220cell10 = row.createCell(10);
		if (record.getR0220_post_collateral_haircut() != null) {
			R0220cell10.setCellValue(record.getR0220_post_collateral_haircut().doubleValue());
			R0220cell10.setCellStyle(numberStyle);
		} else {
			R0220cell10.setCellValue("");
			R0220cell10.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column L
		Cell R0220cell11 = row.createCell(11);
		if (record.getR0220_type_of_security() != null) {
			R0220cell11.setCellValue(record.getR0220_type_of_security().doubleValue());
			R0220cell11.setCellStyle(numberStyle);
		} else {
			R0220cell11.setCellValue("");
			R0220cell11.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column M
		Cell R0220cell12 = row.createCell(12);
		if (record.getR0220_discounted_collateral_value() != null) {
			R0220cell12.setCellValue(record.getR0220_discounted_collateral_value().doubleValue());
			R0220cell12.setCellStyle(numberStyle);
		} else {
			R0220cell12.setCellValue("");
			R0220cell12.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column N
		Cell R0220cell13 = row.createCell(13);
		if (record.getR0220_validated_discounted_cashflows() != null) {
			R0220cell13.setCellValue(record.getR0220_validated_discounted_cashflows().doubleValue());
			R0220cell13.setCellStyle(numberStyle);
		} else {
			R0220cell13.setCellValue("");
			R0220cell13.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column O
		Cell R0220cell14 = row.createCell(14);
		if (record.getR0220_pd() != null) {
			R0220cell14.setCellValue(record.getR0220_pd().doubleValue());
			R0220cell14.setCellStyle(numberStyle);
		} else {
			R0220cell14.setCellValue("");
			R0220cell14.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column P
		Cell R0220cell15 = row.createCell(15);
		if (record.getR0220_lgd() != null) {
			R0220cell15.setCellValue(record.getR0220_lgd().doubleValue());
			R0220cell15.setCellStyle(numberStyle);
		} else {
			R0220cell15.setCellValue("");
			R0220cell15.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column Q
		Cell R0220cell16 = row.createCell(16);
		if (record.getR0220_provisions_charged_pnl() != null) {
			R0220cell16.setCellValue(record.getR0220_provisions_charged_pnl().doubleValue());
			R0220cell16.setCellStyle(numberStyle);
		} else {
			R0220cell16.setCellValue("");
			R0220cell16.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column R
		Cell R0220cell17 = row.createCell(17);
		if (record.getR0220_legacy_interest_profit_suspense() != null) {
			R0220cell17.setCellValue(record.getR0220_legacy_interest_profit_suspense().doubleValue());
			R0220cell17.setCellStyle(numberStyle);
		} else {
			R0220cell17.setCellValue("");
			R0220cell17.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column S
		Cell R0220cell18 = row.createCell(18);
		if (record.getR0220_legal_case_yn() != null && !record.getR0220_legal_case_yn().isEmpty()) {
			R0220cell18.setCellValue(record.getR0220_legal_case_yn());
			R0220cell18.setCellStyle(textStyle);
		} else {
			R0220cell18.setCellValue("");
			R0220cell18.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column T
		Cell R0220cell19 = row.createCell(19);
		if (record.getR0220_remarks_if_any() != null && !record.getR0220_remarks_if_any().isEmpty()) {
			R0220cell19.setCellValue(record.getR0220_remarks_if_any());
			R0220cell19.setCellStyle(textStyle);
		} else {
			R0220cell19.setCellValue("");
			R0220cell19.setCellStyle(textStyle);
		}

		/// ROW31
		row = sheet.getRow(30);
		//// Column D
		Cell R0230cell3 = row.createCell(3);
		if (record.getR0230_borrower_name() != null && !record.getR0230_borrower_name().isEmpty()) {
			R0230cell3.setCellValue(record.getR0230_borrower_name());
			R0230cell3.setCellStyle(textStyle);
		} else {
			R0230cell3.setCellValue("");
			R0230cell3.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column E
		Cell R0230cell4 = row.createCell(4);
		if (record.getR0230_group_name_if_applicable() != null
				&& !record.getR0230_group_name_if_applicable().isEmpty()) {
			R0230cell4.setCellValue(record.getR0230_group_name_if_applicable());
			R0230cell4.setCellStyle(textStyle);
		} else {
			R0230cell4.setCellValue("");
			R0230cell4.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column F
		Cell R0230cell5 = row.createCell(5);
		if (record.getR0230_cin() != null && !record.getR0230_cin().isEmpty()) {
			R0230cell5.setCellValue(record.getR0230_cin());
			R0230cell5.setCellStyle(textStyle);
		} else {
			R0230cell5.setCellValue("");
			R0230cell5.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column G
		Cell R0230cell6 = row.createCell(6);
		if (record.getR0230_domicile_country() != null && !record.getR0230_domicile_country().isEmpty()) {
			R0230cell6.setCellValue(record.getR0230_domicile_country());
			R0230cell6.setCellStyle(textStyle);
		} else {
			R0230cell6.setCellValue("");
			R0230cell6.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column H
		Cell R0230cell7 = row.createCell(7);
		if (record.getR0230_funded_outstanding_amount() != null) {
			R0230cell7.setCellValue(record.getR0230_funded_outstanding_amount().doubleValue());
			R0230cell7.setCellStyle(numberStyle);
		} else {
			R0230cell7.setCellValue("");
			R0230cell7.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column I
		Cell R0230cell8 = row.createCell(8);
		if (record.getR0230_ccf_unfunded_outstanding_amount() != null) {
			R0230cell8.setCellValue(record.getR0230_ccf_unfunded_outstanding_amount().doubleValue());
			R0230cell8.setCellStyle(numberStyle);
		} else {
			R0230cell8.setCellValue("");
			R0230cell8.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column J
		Cell R0230cell9 = row.createCell(9);
		if (record.getR0230_secured_portion_exposure() != null) {
			R0230cell9.setCellValue(record.getR0230_secured_portion_exposure().doubleValue());
			R0230cell9.setCellStyle(numberStyle);
		} else {
			R0230cell9.setCellValue("");
			R0230cell9.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column K
		Cell R0230cell10 = row.createCell(10);
		if (record.getR0230_post_collateral_haircut() != null) {
			R0230cell10.setCellValue(record.getR0230_post_collateral_haircut().doubleValue());
			R0230cell10.setCellStyle(numberStyle);
		} else {
			R0230cell10.setCellValue("");
			R0230cell10.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column L
		Cell R0230cell11 = row.createCell(11);
		if (record.getR0230_type_of_security() != null) {
			R0230cell11.setCellValue(record.getR0230_type_of_security().doubleValue());
			R0230cell11.setCellStyle(numberStyle);
		} else {
			R0230cell11.setCellValue("");
			R0230cell11.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column M
		Cell R0230cell12 = row.createCell(12);
		if (record.getR0230_discounted_collateral_value() != null) {
			R0230cell12.setCellValue(record.getR0230_discounted_collateral_value().doubleValue());
			R0230cell12.setCellStyle(numberStyle);
		} else {
			R0230cell12.setCellValue("");
			R0230cell12.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column N
		Cell R0230cell13 = row.createCell(13);
		if (record.getR0230_validated_discounted_cashflows() != null) {
			R0230cell13.setCellValue(record.getR0230_validated_discounted_cashflows().doubleValue());
			R0230cell13.setCellStyle(numberStyle);
		} else {
			R0230cell13.setCellValue("");
			R0230cell13.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column O
		Cell R0230cell14 = row.createCell(14);
		if (record.getR0230_pd() != null) {
			R0230cell14.setCellValue(record.getR0230_pd().doubleValue());
			R0230cell14.setCellStyle(numberStyle);
		} else {
			R0230cell14.setCellValue("");
			R0230cell14.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column P
		Cell R0230cell15 = row.createCell(15);
		if (record.getR0230_lgd() != null) {
			R0230cell15.setCellValue(record.getR0230_lgd().doubleValue());
			R0230cell15.setCellStyle(numberStyle);
		} else {
			R0230cell15.setCellValue("");
			R0230cell15.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column Q
		Cell R0230cell16 = row.createCell(16);
		if (record.getR0230_provisions_charged_pnl() != null) {
			R0230cell16.setCellValue(record.getR0230_provisions_charged_pnl().doubleValue());
			R0230cell16.setCellStyle(numberStyle);
		} else {
			R0230cell16.setCellValue("");
			R0230cell16.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column R
		Cell R0230cell17 = row.createCell(17);
		if (record.getR0230_legacy_interest_profit_suspense() != null) {
			R0230cell17.setCellValue(record.getR0230_legacy_interest_profit_suspense().doubleValue());
			R0230cell17.setCellStyle(numberStyle);
		} else {
			R0230cell17.setCellValue("");
			R0230cell17.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column S
		Cell R0230cell18 = row.createCell(18);
		if (record.getR0230_legal_case_yn() != null && !record.getR0230_legal_case_yn().isEmpty()) {
			R0230cell18.setCellValue(record.getR0230_legal_case_yn());
			R0230cell18.setCellStyle(textStyle);
		} else {
			R0230cell18.setCellValue("");
			R0230cell18.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column T
		Cell R0230cell19 = row.createCell(19);
		if (record.getR0230_remarks_if_any() != null && !record.getR0230_remarks_if_any().isEmpty()) {
			R0230cell19.setCellValue(record.getR0230_remarks_if_any());
			R0230cell19.setCellStyle(textStyle);
		} else {
			R0230cell19.setCellValue("");
			R0230cell19.setCellStyle(textStyle);
		}

		/// ROW32
		row = sheet.getRow(31);
		//// Column D
		Cell R0240cell3 = row.createCell(3);
		if (record.getR0240_borrower_name() != null && !record.getR0240_borrower_name().isEmpty()) {
			R0240cell3.setCellValue(record.getR0240_borrower_name());
			R0240cell3.setCellStyle(textStyle);
		} else {
			R0240cell3.setCellValue("");
			R0240cell3.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column E
		Cell R0240cell4 = row.createCell(4);
		if (record.getR0240_group_name_if_applicable() != null
				&& !record.getR0240_group_name_if_applicable().isEmpty()) {
			R0240cell4.setCellValue(record.getR0240_group_name_if_applicable());
			R0240cell4.setCellStyle(textStyle);
		} else {
			R0240cell4.setCellValue("");
			R0240cell4.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column F
		Cell R0240cell5 = row.createCell(5);
		if (record.getR0240_cin() != null && !record.getR0240_cin().isEmpty()) {
			R0240cell5.setCellValue(record.getR0240_cin());
			R0240cell5.setCellStyle(textStyle);
		} else {
			R0240cell5.setCellValue("");
			R0240cell5.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column G
		Cell R0240cell6 = row.createCell(6);
		if (record.getR0240_domicile_country() != null && !record.getR0240_domicile_country().isEmpty()) {
			R0240cell6.setCellValue(record.getR0240_domicile_country());
			R0240cell6.setCellStyle(textStyle);
		} else {
			R0240cell6.setCellValue("");
			R0240cell6.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column H
		Cell R0240cell7 = row.createCell(7);
		if (record.getR0240_funded_outstanding_amount() != null) {
			R0240cell7.setCellValue(record.getR0240_funded_outstanding_amount().doubleValue());
			R0240cell7.setCellStyle(numberStyle);
		} else {
			R0240cell7.setCellValue("");
			R0240cell7.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column I
		Cell R0240cell8 = row.createCell(8);
		if (record.getR0240_ccf_unfunded_outstanding_amount() != null) {
			R0240cell8.setCellValue(record.getR0240_ccf_unfunded_outstanding_amount().doubleValue());
			R0240cell8.setCellStyle(numberStyle);
		} else {
			R0240cell8.setCellValue("");
			R0240cell8.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column J
		Cell R0240cell9 = row.createCell(9);
		if (record.getR0240_secured_portion_exposure() != null) {
			R0240cell9.setCellValue(record.getR0240_secured_portion_exposure().doubleValue());
			R0240cell9.setCellStyle(numberStyle);
		} else {
			R0240cell9.setCellValue("");
			R0240cell9.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column K
		Cell R0240cell10 = row.createCell(10);
		if (record.getR0240_post_collateral_haircut() != null) {
			R0240cell10.setCellValue(record.getR0240_post_collateral_haircut().doubleValue());
			R0240cell10.setCellStyle(numberStyle);
		} else {
			R0240cell10.setCellValue("");
			R0240cell10.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column L
		Cell R0240cell11 = row.createCell(11);
		if (record.getR0240_type_of_security() != null) {
			R0240cell11.setCellValue(record.getR0240_type_of_security().doubleValue());
			R0240cell11.setCellStyle(numberStyle);
		} else {
			R0240cell11.setCellValue("");
			R0240cell11.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column M
		Cell R0240cell12 = row.createCell(12);
		if (record.getR0240_discounted_collateral_value() != null) {
			R0240cell12.setCellValue(record.getR0240_discounted_collateral_value().doubleValue());
			R0240cell12.setCellStyle(numberStyle);
		} else {
			R0240cell12.setCellValue("");
			R0240cell12.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column N
		Cell R0240cell13 = row.createCell(13);
		if (record.getR0240_validated_discounted_cashflows() != null) {
			R0240cell13.setCellValue(record.getR0240_validated_discounted_cashflows().doubleValue());
			R0240cell13.setCellStyle(numberStyle);
		} else {
			R0240cell13.setCellValue("");
			R0240cell13.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column O
		Cell R0240cell14 = row.createCell(14);
		if (record.getR0240_pd() != null) {
			R0240cell14.setCellValue(record.getR0240_pd().doubleValue());
			R0240cell14.setCellStyle(numberStyle);
		} else {
			R0240cell14.setCellValue("");
			R0240cell14.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column P
		Cell R0240cell15 = row.createCell(15);
		if (record.getR0240_lgd() != null) {
			R0240cell15.setCellValue(record.getR0240_lgd().doubleValue());
			R0240cell15.setCellStyle(numberStyle);
		} else {
			R0240cell15.setCellValue("");
			R0240cell15.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column Q
		Cell R0240cell16 = row.createCell(16);
		if (record.getR0240_provisions_charged_pnl() != null) {
			R0240cell16.setCellValue(record.getR0240_provisions_charged_pnl().doubleValue());
			R0240cell16.setCellStyle(numberStyle);
		} else {
			R0240cell16.setCellValue("");
			R0240cell16.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column R
		Cell R0240cell17 = row.createCell(17);
		if (record.getR0240_legacy_interest_profit_suspense() != null) {
			R0240cell17.setCellValue(record.getR0240_legacy_interest_profit_suspense().doubleValue());
			R0240cell17.setCellStyle(numberStyle);
		} else {
			R0240cell17.setCellValue("");
			R0240cell17.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column S
		Cell R0240cell18 = row.createCell(18);
		if (record.getR0240_legal_case_yn() != null && !record.getR0240_legal_case_yn().isEmpty()) {
			R0240cell18.setCellValue(record.getR0240_legal_case_yn());
			R0240cell18.setCellStyle(textStyle);
		} else {
			R0240cell18.setCellValue("");
			R0240cell18.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column T
		Cell R0240cell19 = row.createCell(19);
		if (record.getR0240_remarks_if_any() != null && !record.getR0240_remarks_if_any().isEmpty()) {
			R0240cell19.setCellValue(record.getR0240_remarks_if_any());
			R0240cell19.setCellStyle(textStyle);
		} else {
			R0240cell19.setCellValue("");
			R0240cell19.setCellStyle(textStyle);
		}

		/// ROW33
		row = sheet.getRow(32);
		//// Column D
		Cell R0250cell3 = row.createCell(3);
		if (record.getR0250_borrower_name() != null && !record.getR0250_borrower_name().isEmpty()) {
			R0250cell3.setCellValue(record.getR0250_borrower_name());
			R0250cell3.setCellStyle(textStyle);
		} else {
			R0250cell3.setCellValue("");
			R0250cell3.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column E
		Cell R0250cell4 = row.createCell(4);
		if (record.getR0250_group_name_if_applicable() != null
				&& !record.getR0250_group_name_if_applicable().isEmpty()) {
			R0250cell4.setCellValue(record.getR0250_group_name_if_applicable());
			R0250cell4.setCellStyle(textStyle);
		} else {
			R0250cell4.setCellValue("");
			R0250cell4.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column F
		Cell R0250cell5 = row.createCell(5);
		if (record.getR0250_cin() != null && !record.getR0250_cin().isEmpty()) {
			R0250cell5.setCellValue(record.getR0250_cin());
			R0250cell5.setCellStyle(textStyle);
		} else {
			R0250cell5.setCellValue("");
			R0250cell5.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column G
		Cell R0250cell6 = row.createCell(6);
		if (record.getR0250_domicile_country() != null && !record.getR0250_domicile_country().isEmpty()) {
			R0250cell6.setCellValue(record.getR0250_domicile_country());
			R0250cell6.setCellStyle(textStyle);
		} else {
			R0250cell6.setCellValue("");
			R0250cell6.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column H
		Cell R0250cell7 = row.createCell(7);
		if (record.getR0250_funded_outstanding_amount() != null) {
			R0250cell7.setCellValue(record.getR0250_funded_outstanding_amount().doubleValue());
			R0250cell7.setCellStyle(numberStyle);
		} else {
			R0250cell7.setCellValue("");
			R0250cell7.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column I
		Cell R0250cell8 = row.createCell(8);
		if (record.getR0250_ccf_unfunded_outstanding_amount() != null) {
			R0250cell8.setCellValue(record.getR0250_ccf_unfunded_outstanding_amount().doubleValue());
			R0250cell8.setCellStyle(numberStyle);
		} else {
			R0250cell8.setCellValue("");
			R0250cell8.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column J
		Cell R0250cell9 = row.createCell(9);
		if (record.getR0250_secured_portion_exposure() != null) {
			R0250cell9.setCellValue(record.getR0250_secured_portion_exposure().doubleValue());
			R0250cell9.setCellStyle(numberStyle);
		} else {
			R0250cell9.setCellValue("");
			R0250cell9.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column K
		Cell R0250cell10 = row.createCell(10);
		if (record.getR0250_post_collateral_haircut() != null) {
			R0250cell10.setCellValue(record.getR0250_post_collateral_haircut().doubleValue());
			R0250cell10.setCellStyle(numberStyle);
		} else {
			R0250cell10.setCellValue("");
			R0250cell10.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column L
		Cell R0250cell11 = row.createCell(11);
		if (record.getR0250_type_of_security() != null) {
			R0250cell11.setCellValue(record.getR0250_type_of_security().doubleValue());
			R0250cell11.setCellStyle(numberStyle);
		} else {
			R0250cell11.setCellValue("");
			R0250cell11.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column M
		Cell R0250cell12 = row.createCell(12);
		if (record.getR0250_discounted_collateral_value() != null) {
			R0250cell12.setCellValue(record.getR0250_discounted_collateral_value().doubleValue());
			R0250cell12.setCellStyle(numberStyle);
		} else {
			R0250cell12.setCellValue("");
			R0250cell12.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column N
		Cell R0250cell13 = row.createCell(13);
		if (record.getR0250_validated_discounted_cashflows() != null) {
			R0250cell13.setCellValue(record.getR0250_validated_discounted_cashflows().doubleValue());
			R0250cell13.setCellStyle(numberStyle);
		} else {
			R0250cell13.setCellValue("");
			R0250cell13.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column O
		Cell R0250cell14 = row.createCell(14);
		if (record.getR0250_pd() != null) {
			R0250cell14.setCellValue(record.getR0250_pd().doubleValue());
			R0250cell14.setCellStyle(numberStyle);
		} else {
			R0250cell14.setCellValue("");
			R0250cell14.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column P
		Cell R0250cell15 = row.createCell(15);
		if (record.getR0250_lgd() != null) {
			R0250cell15.setCellValue(record.getR0250_lgd().doubleValue());
			R0250cell15.setCellStyle(numberStyle);
		} else {
			R0250cell15.setCellValue("");
			R0250cell15.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column Q
		Cell R0250cell16 = row.createCell(16);
		if (record.getR0250_provisions_charged_pnl() != null) {
			R0250cell16.setCellValue(record.getR0250_provisions_charged_pnl().doubleValue());
			R0250cell16.setCellStyle(numberStyle);
		} else {
			R0250cell16.setCellValue("");
			R0250cell16.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column R
		Cell R0250cell17 = row.createCell(17);
		if (record.getR0250_legacy_interest_profit_suspense() != null) {
			R0250cell17.setCellValue(record.getR0250_legacy_interest_profit_suspense().doubleValue());
			R0250cell17.setCellStyle(numberStyle);
		} else {
			R0250cell17.setCellValue("");
			R0250cell17.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column S
		Cell R0250cell18 = row.createCell(18);
		if (record.getR0250_legal_case_yn() != null && !record.getR0250_legal_case_yn().isEmpty()) {
			R0250cell18.setCellValue(record.getR0250_legal_case_yn());
			R0250cell18.setCellStyle(textStyle);
		} else {
			R0250cell18.setCellValue("");
			R0250cell18.setCellStyle(textStyle);
		}

		/// ROW33
		//// Column T
		Cell R0250cell19 = row.createCell(19);
		if (record.getR0250_remarks_if_any() != null && !record.getR0250_remarks_if_any().isEmpty()) {
			R0250cell19.setCellValue(record.getR0250_remarks_if_any());
			R0250cell19.setCellStyle(textStyle);
		} else {
			R0250cell19.setCellValue("");
			R0250cell19.setCellStyle(textStyle);
		}

		/// ROW34
		row = sheet.getRow(33);
		//// Column D
		Cell R0260cell3 = row.createCell(3);
		if (record.getR0260_borrower_name() != null && !record.getR0260_borrower_name().isEmpty()) {
			R0260cell3.setCellValue(record.getR0260_borrower_name());
			R0260cell3.setCellStyle(textStyle);
		} else {
			R0260cell3.setCellValue("");
			R0260cell3.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column E
		Cell R0260cell4 = row.createCell(4);
		if (record.getR0260_group_name_if_applicable() != null
				&& !record.getR0260_group_name_if_applicable().isEmpty()) {
			R0260cell4.setCellValue(record.getR0260_group_name_if_applicable());
			R0260cell4.setCellStyle(textStyle);
		} else {
			R0260cell4.setCellValue("");
			R0260cell4.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column F
		Cell R0260cell5 = row.createCell(5);
		if (record.getR0260_cin() != null && !record.getR0260_cin().isEmpty()) {
			R0260cell5.setCellValue(record.getR0260_cin());
			R0260cell5.setCellStyle(textStyle);
		} else {
			R0260cell5.setCellValue("");
			R0260cell5.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column G
		Cell R0260cell6 = row.createCell(6);
		if (record.getR0260_domicile_country() != null && !record.getR0260_domicile_country().isEmpty()) {
			R0260cell6.setCellValue(record.getR0260_domicile_country());
			R0260cell6.setCellStyle(textStyle);
		} else {
			R0260cell6.setCellValue("");
			R0260cell6.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column H
		Cell R0260cell7 = row.createCell(7);
		if (record.getR0260_funded_outstanding_amount() != null) {
			R0260cell7.setCellValue(record.getR0260_funded_outstanding_amount().doubleValue());
			R0260cell7.setCellStyle(numberStyle);
		} else {
			R0260cell7.setCellValue("");
			R0260cell7.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column I
		Cell R0260cell8 = row.createCell(8);
		if (record.getR0260_ccf_unfunded_outstanding_amount() != null) {
			R0260cell8.setCellValue(record.getR0260_ccf_unfunded_outstanding_amount().doubleValue());
			R0260cell8.setCellStyle(numberStyle);
		} else {
			R0260cell8.setCellValue("");
			R0260cell8.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column J
		Cell R0260cell9 = row.createCell(9);
		if (record.getR0260_secured_portion_exposure() != null) {
			R0260cell9.setCellValue(record.getR0260_secured_portion_exposure().doubleValue());
			R0260cell9.setCellStyle(numberStyle);
		} else {
			R0260cell9.setCellValue("");
			R0260cell9.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column K
		Cell R0260cell10 = row.createCell(10);
		if (record.getR0260_post_collateral_haircut() != null) {
			R0260cell10.setCellValue(record.getR0260_post_collateral_haircut().doubleValue());
			R0260cell10.setCellStyle(numberStyle);
		} else {
			R0260cell10.setCellValue("");
			R0260cell10.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column L
		Cell R0260cell11 = row.createCell(11);
		if (record.getR0260_type_of_security() != null) {
			R0260cell11.setCellValue(record.getR0260_type_of_security().doubleValue());
			R0260cell11.setCellStyle(numberStyle);
		} else {
			R0260cell11.setCellValue("");
			R0260cell11.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column M
		Cell R0260cell12 = row.createCell(12);
		if (record.getR0260_discounted_collateral_value() != null) {
			R0260cell12.setCellValue(record.getR0260_discounted_collateral_value().doubleValue());
			R0260cell12.setCellStyle(numberStyle);
		} else {
			R0260cell12.setCellValue("");
			R0260cell12.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column N
		Cell R0260cell13 = row.createCell(13);
		if (record.getR0260_validated_discounted_cashflows() != null) {
			R0260cell13.setCellValue(record.getR0260_validated_discounted_cashflows().doubleValue());
			R0260cell13.setCellStyle(numberStyle);
		} else {
			R0260cell13.setCellValue("");
			R0260cell13.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column O
		Cell R0260cell14 = row.createCell(14);
		if (record.getR0260_pd() != null) {
			R0260cell14.setCellValue(record.getR0260_pd().doubleValue());
			R0260cell14.setCellStyle(numberStyle);
		} else {
			R0260cell14.setCellValue("");
			R0260cell14.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column P
		Cell R0260cell15 = row.createCell(15);
		if (record.getR0260_lgd() != null) {
			R0260cell15.setCellValue(record.getR0260_lgd().doubleValue());
			R0260cell15.setCellStyle(numberStyle);
		} else {
			R0260cell15.setCellValue("");
			R0260cell15.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column Q
		Cell R0260cell16 = row.createCell(16);
		if (record.getR0260_provisions_charged_pnl() != null) {
			R0260cell16.setCellValue(record.getR0260_provisions_charged_pnl().doubleValue());
			R0260cell16.setCellStyle(numberStyle);
		} else {
			R0260cell16.setCellValue("");
			R0260cell16.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column R
		Cell R0260cell17 = row.createCell(17);
		if (record.getR0260_legacy_interest_profit_suspense() != null) {
			R0260cell17.setCellValue(record.getR0260_legacy_interest_profit_suspense().doubleValue());
			R0260cell17.setCellStyle(numberStyle);
		} else {
			R0260cell17.setCellValue("");
			R0260cell17.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column S
		Cell R0260cell18 = row.createCell(18);
		if (record.getR0260_legal_case_yn() != null && !record.getR0260_legal_case_yn().isEmpty()) {
			R0260cell18.setCellValue(record.getR0260_legal_case_yn());
			R0260cell18.setCellStyle(textStyle);
		} else {
			R0260cell18.setCellValue("");
			R0260cell18.setCellStyle(textStyle);
		}

		/// ROW34
		//// Column T
		Cell R0260cell19 = row.createCell(19);
		if (record.getR0260_remarks_if_any() != null && !record.getR0260_remarks_if_any().isEmpty()) {
			R0260cell19.setCellValue(record.getR0260_remarks_if_any());
			R0260cell19.setCellStyle(textStyle);
		} else {
			R0260cell19.setCellValue("");
			R0260cell19.setCellStyle(textStyle);
		}

		/// ROW35
		row = sheet.getRow(34);
		//// Column D
		Cell R0270cell3 = row.createCell(3);
		if (record.getR0270_borrower_name() != null && !record.getR0270_borrower_name().isEmpty()) {
			R0270cell3.setCellValue(record.getR0270_borrower_name());
			R0270cell3.setCellStyle(textStyle);
		} else {
			R0270cell3.setCellValue("");
			R0270cell3.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column E
		Cell R0270cell4 = row.createCell(4);
		if (record.getR0270_group_name_if_applicable() != null
				&& !record.getR0270_group_name_if_applicable().isEmpty()) {
			R0270cell4.setCellValue(record.getR0270_group_name_if_applicable());
			R0270cell4.setCellStyle(textStyle);
		} else {
			R0270cell4.setCellValue("");
			R0270cell4.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column F
		Cell R0270cell5 = row.createCell(5);
		if (record.getR0270_cin() != null && !record.getR0270_cin().isEmpty()) {
			R0270cell5.setCellValue(record.getR0270_cin());
			R0270cell5.setCellStyle(textStyle);
		} else {
			R0270cell5.setCellValue("");
			R0270cell5.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column G
		Cell R0270cell6 = row.createCell(6);
		if (record.getR0270_domicile_country() != null && !record.getR0270_domicile_country().isEmpty()) {
			R0270cell6.setCellValue(record.getR0270_domicile_country());
			R0270cell6.setCellStyle(textStyle);
		} else {
			R0270cell6.setCellValue("");
			R0270cell6.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column H
		Cell R0270cell7 = row.createCell(7);
		if (record.getR0270_funded_outstanding_amount() != null) {
			R0270cell7.setCellValue(record.getR0270_funded_outstanding_amount().doubleValue());
			R0270cell7.setCellStyle(numberStyle);
		} else {
			R0270cell7.setCellValue("");
			R0270cell7.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column I
		Cell R0270cell8 = row.createCell(8);
		if (record.getR0270_ccf_unfunded_outstanding_amount() != null) {
			R0270cell8.setCellValue(record.getR0270_ccf_unfunded_outstanding_amount().doubleValue());
			R0270cell8.setCellStyle(numberStyle);
		} else {
			R0270cell8.setCellValue("");
			R0270cell8.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column J
		Cell R0270cell9 = row.createCell(9);
		if (record.getR0270_secured_portion_exposure() != null) {
			R0270cell9.setCellValue(record.getR0270_secured_portion_exposure().doubleValue());
			R0270cell9.setCellStyle(numberStyle);
		} else {
			R0270cell9.setCellValue("");
			R0270cell9.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column K
		Cell R0270cell10 = row.createCell(10);
		if (record.getR0270_post_collateral_haircut() != null) {
			R0270cell10.setCellValue(record.getR0270_post_collateral_haircut().doubleValue());
			R0270cell10.setCellStyle(numberStyle);
		} else {
			R0270cell10.setCellValue("");
			R0270cell10.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column L
		Cell R0270cell11 = row.createCell(11);
		if (record.getR0270_type_of_security() != null) {
			R0270cell11.setCellValue(record.getR0270_type_of_security().doubleValue());
			R0270cell11.setCellStyle(numberStyle);
		} else {
			R0270cell11.setCellValue("");
			R0270cell11.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column M
		Cell R0270cell12 = row.createCell(12);
		if (record.getR0270_discounted_collateral_value() != null) {
			R0270cell12.setCellValue(record.getR0270_discounted_collateral_value().doubleValue());
			R0270cell12.setCellStyle(numberStyle);
		} else {
			R0270cell12.setCellValue("");
			R0270cell12.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column N
		Cell R0270cell13 = row.createCell(13);
		if (record.getR0270_validated_discounted_cashflows() != null) {
			R0270cell13.setCellValue(record.getR0270_validated_discounted_cashflows().doubleValue());
			R0270cell13.setCellStyle(numberStyle);
		} else {
			R0270cell13.setCellValue("");
			R0270cell13.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column O
		Cell R0270cell14 = row.createCell(14);
		if (record.getR0270_pd() != null) {
			R0270cell14.setCellValue(record.getR0270_pd().doubleValue());
			R0270cell14.setCellStyle(numberStyle);
		} else {
			R0270cell14.setCellValue("");
			R0270cell14.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column P
		Cell R0270cell15 = row.createCell(15);
		if (record.getR0270_lgd() != null) {
			R0270cell15.setCellValue(record.getR0270_lgd().doubleValue());
			R0270cell15.setCellStyle(numberStyle);
		} else {
			R0270cell15.setCellValue("");
			R0270cell15.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column Q
		Cell R0270cell16 = row.createCell(16);
		if (record.getR0270_provisions_charged_pnl() != null) {
			R0270cell16.setCellValue(record.getR0270_provisions_charged_pnl().doubleValue());
			R0270cell16.setCellStyle(numberStyle);
		} else {
			R0270cell16.setCellValue("");
			R0270cell16.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column R
		Cell R0270cell17 = row.createCell(17);
		if (record.getR0270_legacy_interest_profit_suspense() != null) {
			R0270cell17.setCellValue(record.getR0270_legacy_interest_profit_suspense().doubleValue());
			R0270cell17.setCellStyle(numberStyle);
		} else {
			R0270cell17.setCellValue("");
			R0270cell17.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column S
		Cell R0270cell18 = row.createCell(18);
		if (record.getR0270_legal_case_yn() != null && !record.getR0270_legal_case_yn().isEmpty()) {
			R0270cell18.setCellValue(record.getR0270_legal_case_yn());
			R0270cell18.setCellStyle(textStyle);
		} else {
			R0270cell18.setCellValue("");
			R0270cell18.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column T
		Cell R0270cell19 = row.createCell(19);
		if (record.getR0270_remarks_if_any() != null && !record.getR0270_remarks_if_any().isEmpty()) {
			R0270cell19.setCellValue(record.getR0270_remarks_if_any());
			R0270cell19.setCellStyle(textStyle);
		} else {
			R0270cell19.setCellValue("");
			R0270cell19.setCellStyle(textStyle);
		}

		/// ROW36
		row = sheet.getRow(35);
		//// Column D
		Cell R0280cell3 = row.createCell(3);
		if (record.getR0280_borrower_name() != null && !record.getR0280_borrower_name().isEmpty()) {
			R0280cell3.setCellValue(record.getR0280_borrower_name());
			R0280cell3.setCellStyle(textStyle);
		} else {
			R0280cell3.setCellValue("");
			R0280cell3.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column E
		Cell R0280cell4 = row.createCell(4);
		if (record.getR0280_group_name_if_applicable() != null
				&& !record.getR0280_group_name_if_applicable().isEmpty()) {
			R0280cell4.setCellValue(record.getR0280_group_name_if_applicable());
			R0280cell4.setCellStyle(textStyle);
		} else {
			R0280cell4.setCellValue("");
			R0280cell4.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column F
		Cell R0280cell5 = row.createCell(5);
		if (record.getR0280_cin() != null && !record.getR0280_cin().isEmpty()) {
			R0280cell5.setCellValue(record.getR0280_cin());
			R0280cell5.setCellStyle(textStyle);
		} else {
			R0280cell5.setCellValue("");
			R0280cell5.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column G
		Cell R0280cell6 = row.createCell(6);
		if (record.getR0280_domicile_country() != null && !record.getR0280_domicile_country().isEmpty()) {
			R0280cell6.setCellValue(record.getR0280_domicile_country());
			R0280cell6.setCellStyle(textStyle);
		} else {
			R0280cell6.setCellValue("");
			R0280cell6.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column H
		Cell R0280cell7 = row.createCell(7);
		if (record.getR0280_funded_outstanding_amount() != null) {
			R0280cell7.setCellValue(record.getR0280_funded_outstanding_amount().doubleValue());
			R0280cell7.setCellStyle(numberStyle);
		} else {
			R0280cell7.setCellValue("");
			R0280cell7.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column I
		Cell R0280cell8 = row.createCell(8);
		if (record.getR0280_ccf_unfunded_outstanding_amount() != null) {
			R0280cell8.setCellValue(record.getR0280_ccf_unfunded_outstanding_amount().doubleValue());
			R0280cell8.setCellStyle(numberStyle);
		} else {
			R0280cell8.setCellValue("");
			R0280cell8.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column J
		Cell R0280cell9 = row.createCell(9);
		if (record.getR0280_secured_portion_exposure() != null) {
			R0280cell9.setCellValue(record.getR0280_secured_portion_exposure().doubleValue());
			R0280cell9.setCellStyle(numberStyle);
		} else {
			R0280cell9.setCellValue("");
			R0280cell9.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column K
		Cell R0280cell10 = row.createCell(10);
		if (record.getR0280_post_collateral_haircut() != null) {
			R0280cell10.setCellValue(record.getR0280_post_collateral_haircut().doubleValue());
			R0280cell10.setCellStyle(numberStyle);
		} else {
			R0280cell10.setCellValue("");
			R0280cell10.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column L
		Cell R0280cell11 = row.createCell(11);
		if (record.getR0280_type_of_security() != null) {
			R0280cell11.setCellValue(record.getR0280_type_of_security().doubleValue());
			R0280cell11.setCellStyle(numberStyle);
		} else {
			R0280cell11.setCellValue("");
			R0280cell11.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column M
		Cell R0280cell12 = row.createCell(12);
		if (record.getR0280_discounted_collateral_value() != null) {
			R0280cell12.setCellValue(record.getR0280_discounted_collateral_value().doubleValue());
			R0280cell12.setCellStyle(numberStyle);
		} else {
			R0280cell12.setCellValue("");
			R0280cell12.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column N
		Cell R0280cell13 = row.createCell(13);
		if (record.getR0280_validated_discounted_cashflows() != null) {
			R0280cell13.setCellValue(record.getR0280_validated_discounted_cashflows().doubleValue());
			R0280cell13.setCellStyle(numberStyle);
		} else {
			R0280cell13.setCellValue("");
			R0280cell13.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column O
		Cell R0280cell14 = row.createCell(14);
		if (record.getR0280_pd() != null) {
			R0280cell14.setCellValue(record.getR0280_pd().doubleValue());
			R0280cell14.setCellStyle(numberStyle);
		} else {
			R0280cell14.setCellValue("");
			R0280cell14.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column P
		Cell R0280cell15 = row.createCell(15);
		if (record.getR0280_lgd() != null) {
			R0280cell15.setCellValue(record.getR0280_lgd().doubleValue());
			R0280cell15.setCellStyle(numberStyle);
		} else {
			R0280cell15.setCellValue("");
			R0280cell15.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column Q
		Cell R0280cell16 = row.createCell(16);
		if (record.getR0280_provisions_charged_pnl() != null) {
			R0280cell16.setCellValue(record.getR0280_provisions_charged_pnl().doubleValue());
			R0280cell16.setCellStyle(numberStyle);
		} else {
			R0280cell16.setCellValue("");
			R0280cell16.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column R
		Cell R0280cell17 = row.createCell(17);
		if (record.getR0280_legacy_interest_profit_suspense() != null) {
			R0280cell17.setCellValue(record.getR0280_legacy_interest_profit_suspense().doubleValue());
			R0280cell17.setCellStyle(numberStyle);
		} else {
			R0280cell17.setCellValue("");
			R0280cell17.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column S
		Cell R0280cell18 = row.createCell(18);
		if (record.getR0280_legal_case_yn() != null && !record.getR0280_legal_case_yn().isEmpty()) {
			R0280cell18.setCellValue(record.getR0280_legal_case_yn());
			R0280cell18.setCellStyle(textStyle);
		} else {
			R0280cell18.setCellValue("");
			R0280cell18.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column T
		Cell R0280cell19 = row.createCell(19);
		if (record.getR0280_remarks_if_any() != null && !record.getR0280_remarks_if_any().isEmpty()) {
			R0280cell19.setCellValue(record.getR0280_remarks_if_any());
			R0280cell19.setCellStyle(textStyle);
		} else {
			R0280cell19.setCellValue("");
			R0280cell19.setCellStyle(textStyle);
		}

		/// ROW37
		row = sheet.getRow(36);
		//// Column D
		Cell R0290cell3 = row.createCell(3);
		if (record.getR0290_borrower_name() != null && !record.getR0290_borrower_name().isEmpty()) {
			R0290cell3.setCellValue(record.getR0290_borrower_name());
			R0290cell3.setCellStyle(textStyle);
		} else {
			R0290cell3.setCellValue("");
			R0290cell3.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column E
		Cell R0290cell4 = row.createCell(4);
		if (record.getR0290_group_name_if_applicable() != null
				&& !record.getR0290_group_name_if_applicable().isEmpty()) {
			R0290cell4.setCellValue(record.getR0290_group_name_if_applicable());
			R0290cell4.setCellStyle(textStyle);
		} else {
			R0290cell4.setCellValue("");
			R0290cell4.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column F
		Cell R0290cell5 = row.createCell(5);
		if (record.getR0290_cin() != null && !record.getR0290_cin().isEmpty()) {
			R0290cell5.setCellValue(record.getR0290_cin());
			R0290cell5.setCellStyle(textStyle);
		} else {
			R0290cell5.setCellValue("");
			R0290cell5.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column G
		Cell R0290cell6 = row.createCell(6);
		if (record.getR0290_domicile_country() != null && !record.getR0290_domicile_country().isEmpty()) {
			R0290cell6.setCellValue(record.getR0290_domicile_country());
			R0290cell6.setCellStyle(textStyle);
		} else {
			R0290cell6.setCellValue("");
			R0290cell6.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column H
		Cell R0290cell7 = row.createCell(7);
		if (record.getR0290_funded_outstanding_amount() != null) {
			R0290cell7.setCellValue(record.getR0290_funded_outstanding_amount().doubleValue());
			R0290cell7.setCellStyle(numberStyle);
		} else {
			R0290cell7.setCellValue("");
			R0290cell7.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column I
		Cell R0290cell8 = row.createCell(8);
		if (record.getR0290_ccf_unfunded_outstanding_amount() != null) {
			R0290cell8.setCellValue(record.getR0290_ccf_unfunded_outstanding_amount().doubleValue());
			R0290cell8.setCellStyle(numberStyle);
		} else {
			R0290cell8.setCellValue("");
			R0290cell8.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column J
		Cell R0290cell9 = row.createCell(9);
		if (record.getR0290_secured_portion_exposure() != null) {
			R0290cell9.setCellValue(record.getR0290_secured_portion_exposure().doubleValue());
			R0290cell9.setCellStyle(numberStyle);
		} else {
			R0290cell9.setCellValue("");
			R0290cell9.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column K
		Cell R0290cell10 = row.createCell(10);
		if (record.getR0290_post_collateral_haircut() != null) {
			R0290cell10.setCellValue(record.getR0290_post_collateral_haircut().doubleValue());
			R0290cell10.setCellStyle(numberStyle);
		} else {
			R0290cell10.setCellValue("");
			R0290cell10.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column L
		Cell R0290cell11 = row.createCell(11);
		if (record.getR0290_type_of_security() != null) {
			R0290cell11.setCellValue(record.getR0290_type_of_security().doubleValue());
			R0290cell11.setCellStyle(numberStyle);
		} else {
			R0290cell11.setCellValue("");
			R0290cell11.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column M
		Cell R0290cell12 = row.createCell(12);
		if (record.getR0290_discounted_collateral_value() != null) {
			R0290cell12.setCellValue(record.getR0290_discounted_collateral_value().doubleValue());
			R0290cell12.setCellStyle(numberStyle);
		} else {
			R0290cell12.setCellValue("");
			R0290cell12.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column N
		Cell R0290cell13 = row.createCell(13);
		if (record.getR0290_validated_discounted_cashflows() != null) {
			R0290cell13.setCellValue(record.getR0290_validated_discounted_cashflows().doubleValue());
			R0290cell13.setCellStyle(numberStyle);
		} else {
			R0290cell13.setCellValue("");
			R0290cell13.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column O
		Cell R0290cell14 = row.createCell(14);
		if (record.getR0290_pd() != null) {
			R0290cell14.setCellValue(record.getR0290_pd().doubleValue());
			R0290cell14.setCellStyle(numberStyle);
		} else {
			R0290cell14.setCellValue("");
			R0290cell14.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column P
		Cell R0290cell15 = row.createCell(15);
		if (record.getR0290_lgd() != null) {
			R0290cell15.setCellValue(record.getR0290_lgd().doubleValue());
			R0290cell15.setCellStyle(numberStyle);
		} else {
			R0290cell15.setCellValue("");
			R0290cell15.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column Q
		Cell R0290cell16 = row.createCell(16);
		if (record.getR0290_provisions_charged_pnl() != null) {
			R0290cell16.setCellValue(record.getR0290_provisions_charged_pnl().doubleValue());
			R0290cell16.setCellStyle(numberStyle);
		} else {
			R0290cell16.setCellValue("");
			R0290cell16.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column R
		Cell R0290cell17 = row.createCell(17);
		if (record.getR0290_legacy_interest_profit_suspense() != null) {
			R0290cell17.setCellValue(record.getR0290_legacy_interest_profit_suspense().doubleValue());
			R0290cell17.setCellStyle(numberStyle);
		} else {
			R0290cell17.setCellValue("");
			R0290cell17.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column S
		Cell R0290cell18 = row.createCell(18);
		if (record.getR0290_legal_case_yn() != null && !record.getR0290_legal_case_yn().isEmpty()) {
			R0290cell18.setCellValue(record.getR0290_legal_case_yn());
			R0290cell18.setCellStyle(textStyle);
		} else {
			R0290cell18.setCellValue("");
			R0290cell18.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column T
		Cell R0290cell19 = row.createCell(19);
		if (record.getR0290_remarks_if_any() != null && !record.getR0290_remarks_if_any().isEmpty()) {
			R0290cell19.setCellValue(record.getR0290_remarks_if_any());
			R0290cell19.setCellStyle(textStyle);
		} else {
			R0290cell19.setCellValue("");
			R0290cell19.setCellStyle(textStyle);
		}

		/// ROW38
		row = sheet.getRow(37);
		//// Column D
		Cell R0300cell3 = row.createCell(3);
		if (record.getR0300_borrower_name() != null && !record.getR0300_borrower_name().isEmpty()) {
			R0300cell3.setCellValue(record.getR0300_borrower_name());
			R0300cell3.setCellStyle(textStyle);
		} else {
			R0300cell3.setCellValue("");
			R0300cell3.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column E
		Cell R0300cell4 = row.createCell(4);
		if (record.getR0300_group_name_if_applicable() != null
				&& !record.getR0300_group_name_if_applicable().isEmpty()) {
			R0300cell4.setCellValue(record.getR0300_group_name_if_applicable());
			R0300cell4.setCellStyle(textStyle);
		} else {
			R0300cell4.setCellValue("");
			R0300cell4.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column F
		Cell R0300cell5 = row.createCell(5);
		if (record.getR0300_cin() != null && !record.getR0300_cin().isEmpty()) {
			R0300cell5.setCellValue(record.getR0300_cin());
			R0300cell5.setCellStyle(textStyle);
		} else {
			R0300cell5.setCellValue("");
			R0300cell5.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column G
		Cell R0300cell6 = row.createCell(6);
		if (record.getR0300_domicile_country() != null && !record.getR0300_domicile_country().isEmpty()) {
			R0300cell6.setCellValue(record.getR0300_domicile_country());
			R0300cell6.setCellStyle(textStyle);
		} else {
			R0300cell6.setCellValue("");
			R0300cell6.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column H
		Cell R0300cell7 = row.createCell(7);
		if (record.getR0300_funded_outstanding_amount() != null) {
			R0300cell7.setCellValue(record.getR0300_funded_outstanding_amount().doubleValue());
			R0300cell7.setCellStyle(numberStyle);
		} else {
			R0300cell7.setCellValue("");
			R0300cell7.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column I
		Cell R0300cell8 = row.createCell(8);
		if (record.getR0300_ccf_unfunded_outstanding_amount() != null) {
			R0300cell8.setCellValue(record.getR0300_ccf_unfunded_outstanding_amount().doubleValue());
			R0300cell8.setCellStyle(numberStyle);
		} else {
			R0300cell8.setCellValue("");
			R0300cell8.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column J
		Cell R0300cell9 = row.createCell(9);
		if (record.getR0300_secured_portion_exposure() != null) {
			R0300cell9.setCellValue(record.getR0300_secured_portion_exposure().doubleValue());
			R0300cell9.setCellStyle(numberStyle);
		} else {
			R0300cell9.setCellValue("");
			R0300cell9.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column K
		Cell R0300cell10 = row.createCell(10);
		if (record.getR0300_post_collateral_haircut() != null) {
			R0300cell10.setCellValue(record.getR0300_post_collateral_haircut().doubleValue());
			R0300cell10.setCellStyle(numberStyle);
		} else {
			R0300cell10.setCellValue("");
			R0300cell10.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column L
		Cell R0300cell11 = row.createCell(11);
		if (record.getR0300_type_of_security() != null) {
			R0300cell11.setCellValue(record.getR0300_type_of_security().doubleValue());
			R0300cell11.setCellStyle(numberStyle);
		} else {
			R0300cell11.setCellValue("");
			R0300cell11.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column M
		Cell R0300cell12 = row.createCell(12);
		if (record.getR0300_discounted_collateral_value() != null) {
			R0300cell12.setCellValue(record.getR0300_discounted_collateral_value().doubleValue());
			R0300cell12.setCellStyle(numberStyle);
		} else {
			R0300cell12.setCellValue("");
			R0300cell12.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column N
		Cell R0300cell13 = row.createCell(13);
		if (record.getR0300_validated_discounted_cashflows() != null) {
			R0300cell13.setCellValue(record.getR0300_validated_discounted_cashflows().doubleValue());
			R0300cell13.setCellStyle(numberStyle);
		} else {
			R0300cell13.setCellValue("");
			R0300cell13.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column O
		Cell R0300cell14 = row.createCell(14);
		if (record.getR0300_pd() != null) {
			R0300cell14.setCellValue(record.getR0300_pd().doubleValue());
			R0300cell14.setCellStyle(numberStyle);
		} else {
			R0300cell14.setCellValue("");
			R0300cell14.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column P
		Cell R0300cell15 = row.createCell(15);
		if (record.getR0300_lgd() != null) {
			R0300cell15.setCellValue(record.getR0300_lgd().doubleValue());
			R0300cell15.setCellStyle(numberStyle);
		} else {
			R0300cell15.setCellValue("");
			R0300cell15.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column Q
		Cell R0300cell16 = row.createCell(16);
		if (record.getR0300_provisions_charged_pnl() != null) {
			R0300cell16.setCellValue(record.getR0300_provisions_charged_pnl().doubleValue());
			R0300cell16.setCellStyle(numberStyle);
		} else {
			R0300cell16.setCellValue("");
			R0300cell16.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column R
		Cell R0300cell17 = row.createCell(17);
		if (record.getR0300_legacy_interest_profit_suspense() != null) {
			R0300cell17.setCellValue(record.getR0300_legacy_interest_profit_suspense().doubleValue());
			R0300cell17.setCellStyle(numberStyle);
		} else {
			R0300cell17.setCellValue("");
			R0300cell17.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column S
		Cell R0300cell18 = row.createCell(18);
		if (record.getR0300_legal_case_yn() != null && !record.getR0300_legal_case_yn().isEmpty()) {
			R0300cell18.setCellValue(record.getR0300_legal_case_yn());
			R0300cell18.setCellStyle(textStyle);
		} else {
			R0300cell18.setCellValue("");
			R0300cell18.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column T
		Cell R0300cell19 = row.createCell(19);
		if (record.getR0300_remarks_if_any() != null && !record.getR0300_remarks_if_any().isEmpty()) {
			R0300cell19.setCellValue(record.getR0300_remarks_if_any());
			R0300cell19.setCellStyle(textStyle);
		} else {
			R0300cell19.setCellValue("");
			R0300cell19.setCellStyle(textStyle);
		}

		/// ROW39
		row = sheet.getRow(38);
		//// Column D
		Cell R0310cell3 = row.createCell(3);
		if (record.getR0310_borrower_name() != null && !record.getR0310_borrower_name().isEmpty()) {
			R0310cell3.setCellValue(record.getR0310_borrower_name());
			R0310cell3.setCellStyle(textStyle);
		} else {
			R0310cell3.setCellValue("");
			R0310cell3.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column E
		Cell R0310cell4 = row.createCell(4);
		if (record.getR0310_group_name_if_applicable() != null
				&& !record.getR0310_group_name_if_applicable().isEmpty()) {
			R0310cell4.setCellValue(record.getR0310_group_name_if_applicable());
			R0310cell4.setCellStyle(textStyle);
		} else {
			R0310cell4.setCellValue("");
			R0310cell4.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column F
		Cell R0310cell5 = row.createCell(5);
		if (record.getR0310_cin() != null && !record.getR0310_cin().isEmpty()) {
			R0310cell5.setCellValue(record.getR0310_cin());
			R0310cell5.setCellStyle(textStyle);
		} else {
			R0310cell5.setCellValue("");
			R0310cell5.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column G
		Cell R0310cell6 = row.createCell(6);
		if (record.getR0310_domicile_country() != null && !record.getR0310_domicile_country().isEmpty()) {
			R0310cell6.setCellValue(record.getR0310_domicile_country());
			R0310cell6.setCellStyle(textStyle);
		} else {
			R0310cell6.setCellValue("");
			R0310cell6.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column H
		Cell R0310cell7 = row.createCell(7);
		if (record.getR0310_funded_outstanding_amount() != null) {
			R0310cell7.setCellValue(record.getR0310_funded_outstanding_amount().doubleValue());
			R0310cell7.setCellStyle(numberStyle);
		} else {
			R0310cell7.setCellValue("");
			R0310cell7.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column I
		Cell R0310cell8 = row.createCell(8);
		if (record.getR0310_ccf_unfunded_outstanding_amount() != null) {
			R0310cell8.setCellValue(record.getR0310_ccf_unfunded_outstanding_amount().doubleValue());
			R0310cell8.setCellStyle(numberStyle);
		} else {
			R0310cell8.setCellValue("");
			R0310cell8.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column J
		Cell R0310cell9 = row.createCell(9);
		if (record.getR0310_secured_portion_exposure() != null) {
			R0310cell9.setCellValue(record.getR0310_secured_portion_exposure().doubleValue());
			R0310cell9.setCellStyle(numberStyle);
		} else {
			R0310cell9.setCellValue("");
			R0310cell9.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column K
		Cell R0310cell10 = row.createCell(10);
		if (record.getR0310_post_collateral_haircut() != null) {
			R0310cell10.setCellValue(record.getR0310_post_collateral_haircut().doubleValue());
			R0310cell10.setCellStyle(numberStyle);
		} else {
			R0310cell10.setCellValue("");
			R0310cell10.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column L
		Cell R0310cell11 = row.createCell(11);
		if (record.getR0310_type_of_security() != null) {
			R0310cell11.setCellValue(record.getR0310_type_of_security().doubleValue());
			R0310cell11.setCellStyle(numberStyle);
		} else {
			R0310cell11.setCellValue("");
			R0310cell11.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column M
		Cell R0310cell12 = row.createCell(12);
		if (record.getR0310_discounted_collateral_value() != null) {
			R0310cell12.setCellValue(record.getR0310_discounted_collateral_value().doubleValue());
			R0310cell12.setCellStyle(numberStyle);
		} else {
			R0310cell12.setCellValue("");
			R0310cell12.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column N
		Cell R0310cell13 = row.createCell(13);
		if (record.getR0310_validated_discounted_cashflows() != null) {
			R0310cell13.setCellValue(record.getR0310_validated_discounted_cashflows().doubleValue());
			R0310cell13.setCellStyle(numberStyle);
		} else {
			R0310cell13.setCellValue("");
			R0310cell13.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column O
		Cell R0310cell14 = row.createCell(14);
		if (record.getR0310_pd() != null) {
			R0310cell14.setCellValue(record.getR0310_pd().doubleValue());
			R0310cell14.setCellStyle(numberStyle);
		} else {
			R0310cell14.setCellValue("");
			R0310cell14.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column P
		Cell R0310cell15 = row.createCell(15);
		if (record.getR0310_lgd() != null) {
			R0310cell15.setCellValue(record.getR0310_lgd().doubleValue());
			R0310cell15.setCellStyle(numberStyle);
		} else {
			R0310cell15.setCellValue("");
			R0310cell15.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column Q
		Cell R0310cell16 = row.createCell(16);
		if (record.getR0310_provisions_charged_pnl() != null) {
			R0310cell16.setCellValue(record.getR0310_provisions_charged_pnl().doubleValue());
			R0310cell16.setCellStyle(numberStyle);
		} else {
			R0310cell16.setCellValue("");
			R0310cell16.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column R
		Cell R0310cell17 = row.createCell(17);
		if (record.getR0310_legacy_interest_profit_suspense() != null) {
			R0310cell17.setCellValue(record.getR0310_legacy_interest_profit_suspense().doubleValue());
			R0310cell17.setCellStyle(numberStyle);
		} else {
			R0310cell17.setCellValue("");
			R0310cell17.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column S
		Cell R0310cell18 = row.createCell(18);
		if (record.getR0310_legal_case_yn() != null && !record.getR0310_legal_case_yn().isEmpty()) {
			R0310cell18.setCellValue(record.getR0310_legal_case_yn());
			R0310cell18.setCellStyle(textStyle);
		} else {
			R0310cell18.setCellValue("");
			R0310cell18.setCellStyle(textStyle);
		}

		/// ROW39
		//// Column T
		Cell R0310cell19 = row.createCell(19);
		if (record.getR0310_remarks_if_any() != null && !record.getR0310_remarks_if_any().isEmpty()) {
			R0310cell19.setCellValue(record.getR0310_remarks_if_any());
			R0310cell19.setCellStyle(textStyle);
		} else {
			R0310cell19.setCellValue("");
			R0310cell19.setCellStyle(textStyle);
		}

		/// ROW40
		row = sheet.getRow(39);
		//// Column D
		Cell R0320cell3 = row.createCell(3);
		if (record.getR0320_borrower_name() != null && !record.getR0320_borrower_name().isEmpty()) {
			R0320cell3.setCellValue(record.getR0320_borrower_name());
			R0320cell3.setCellStyle(textStyle);
		} else {
			R0320cell3.setCellValue("");
			R0320cell3.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column E
		Cell R0320cell4 = row.createCell(4);
		if (record.getR0320_group_name_if_applicable() != null
				&& !record.getR0320_group_name_if_applicable().isEmpty()) {
			R0320cell4.setCellValue(record.getR0320_group_name_if_applicable());
			R0320cell4.setCellStyle(textStyle);
		} else {
			R0320cell4.setCellValue("");
			R0320cell4.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column F
		Cell R0320cell5 = row.createCell(5);
		if (record.getR0320_cin() != null && !record.getR0320_cin().isEmpty()) {
			R0320cell5.setCellValue(record.getR0320_cin());
			R0320cell5.setCellStyle(textStyle);
		} else {
			R0320cell5.setCellValue("");
			R0320cell5.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column G
		Cell R0320cell6 = row.createCell(6);
		if (record.getR0320_domicile_country() != null && !record.getR0320_domicile_country().isEmpty()) {
			R0320cell6.setCellValue(record.getR0320_domicile_country());
			R0320cell6.setCellStyle(textStyle);
		} else {
			R0320cell6.setCellValue("");
			R0320cell6.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column H
		Cell R0320cell7 = row.createCell(7);
		if (record.getR0320_funded_outstanding_amount() != null) {
			R0320cell7.setCellValue(record.getR0320_funded_outstanding_amount().doubleValue());
			R0320cell7.setCellStyle(numberStyle);
		} else {
			R0320cell7.setCellValue("");
			R0320cell7.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column I
		Cell R0320cell8 = row.createCell(8);
		if (record.getR0320_ccf_unfunded_outstanding_amount() != null) {
			R0320cell8.setCellValue(record.getR0320_ccf_unfunded_outstanding_amount().doubleValue());
			R0320cell8.setCellStyle(numberStyle);
		} else {
			R0320cell8.setCellValue("");
			R0320cell8.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column J
		Cell R0320cell9 = row.createCell(9);
		if (record.getR0320_secured_portion_exposure() != null) {
			R0320cell9.setCellValue(record.getR0320_secured_portion_exposure().doubleValue());
			R0320cell9.setCellStyle(numberStyle);
		} else {
			R0320cell9.setCellValue("");
			R0320cell9.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column K
		Cell R0320cell10 = row.createCell(10);
		if (record.getR0320_post_collateral_haircut() != null) {
			R0320cell10.setCellValue(record.getR0320_post_collateral_haircut().doubleValue());
			R0320cell10.setCellStyle(numberStyle);
		} else {
			R0320cell10.setCellValue("");
			R0320cell10.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column L
		Cell R0320cell11 = row.createCell(11);
		if (record.getR0320_type_of_security() != null) {
			R0320cell11.setCellValue(record.getR0320_type_of_security().doubleValue());
			R0320cell11.setCellStyle(numberStyle);
		} else {
			R0320cell11.setCellValue("");
			R0320cell11.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column M
		Cell R0320cell12 = row.createCell(12);
		if (record.getR0320_discounted_collateral_value() != null) {
			R0320cell12.setCellValue(record.getR0320_discounted_collateral_value().doubleValue());
			R0320cell12.setCellStyle(numberStyle);
		} else {
			R0320cell12.setCellValue("");
			R0320cell12.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column N
		Cell R0320cell13 = row.createCell(13);
		if (record.getR0320_validated_discounted_cashflows() != null) {
			R0320cell13.setCellValue(record.getR0320_validated_discounted_cashflows().doubleValue());
			R0320cell13.setCellStyle(numberStyle);
		} else {
			R0320cell13.setCellValue("");
			R0320cell13.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column O
		Cell R0320cell14 = row.createCell(14);
		if (record.getR0320_pd() != null) {
			R0320cell14.setCellValue(record.getR0320_pd().doubleValue());
			R0320cell14.setCellStyle(numberStyle);
		} else {
			R0320cell14.setCellValue("");
			R0320cell14.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column P
		Cell R0320cell15 = row.createCell(15);
		if (record.getR0320_lgd() != null) {
			R0320cell15.setCellValue(record.getR0320_lgd().doubleValue());
			R0320cell15.setCellStyle(numberStyle);
		} else {
			R0320cell15.setCellValue("");
			R0320cell15.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column Q
		Cell R0320cell16 = row.createCell(16);
		if (record.getR0320_provisions_charged_pnl() != null) {
			R0320cell16.setCellValue(record.getR0320_provisions_charged_pnl().doubleValue());
			R0320cell16.setCellStyle(numberStyle);
		} else {
			R0320cell16.setCellValue("");
			R0320cell16.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column R
		Cell R0320cell17 = row.createCell(17);
		if (record.getR0320_legacy_interest_profit_suspense() != null) {
			R0320cell17.setCellValue(record.getR0320_legacy_interest_profit_suspense().doubleValue());
			R0320cell17.setCellStyle(numberStyle);
		} else {
			R0320cell17.setCellValue("");
			R0320cell17.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column S
		Cell R0320cell18 = row.createCell(18);
		if (record.getR0320_legal_case_yn() != null && !record.getR0320_legal_case_yn().isEmpty()) {
			R0320cell18.setCellValue(record.getR0320_legal_case_yn());
			R0320cell18.setCellStyle(textStyle);
		} else {
			R0320cell18.setCellValue("");
			R0320cell18.setCellStyle(textStyle);
		}

		/// ROW40
		//// Column T
		Cell R0320cell19 = row.createCell(19);
		if (record.getR0320_remarks_if_any() != null && !record.getR0320_remarks_if_any().isEmpty()) {
			R0320cell19.setCellValue(record.getR0320_remarks_if_any());
			R0320cell19.setCellStyle(textStyle);
		} else {
			R0320cell19.setCellValue("");
			R0320cell19.setCellStyle(textStyle);
		}

		/// ROW41
		row = sheet.getRow(40);
		//// Column D
		Cell R0330cell3 = row.createCell(3);
		if (record.getR0330_borrower_name() != null && !record.getR0330_borrower_name().isEmpty()) {
			R0330cell3.setCellValue(record.getR0330_borrower_name());
			R0330cell3.setCellStyle(textStyle);
		} else {
			R0330cell3.setCellValue("");
			R0330cell3.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column E
		Cell R0330cell4 = row.createCell(4);
		if (record.getR0330_group_name_if_applicable() != null
				&& !record.getR0330_group_name_if_applicable().isEmpty()) {
			R0330cell4.setCellValue(record.getR0330_group_name_if_applicable());
			R0330cell4.setCellStyle(textStyle);
		} else {
			R0330cell4.setCellValue("");
			R0330cell4.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column F
		Cell R0330cell5 = row.createCell(5);
		if (record.getR0330_cin() != null && !record.getR0330_cin().isEmpty()) {
			R0330cell5.setCellValue(record.getR0330_cin());
			R0330cell5.setCellStyle(textStyle);
		} else {
			R0330cell5.setCellValue("");
			R0330cell5.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column G
		Cell R0330cell6 = row.createCell(6);
		if (record.getR0330_domicile_country() != null && !record.getR0330_domicile_country().isEmpty()) {
			R0330cell6.setCellValue(record.getR0330_domicile_country());
			R0330cell6.setCellStyle(textStyle);
		} else {
			R0330cell6.setCellValue("");
			R0330cell6.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column H
		Cell R0330cell7 = row.createCell(7);
		if (record.getR0330_funded_outstanding_amount() != null) {
			R0330cell7.setCellValue(record.getR0330_funded_outstanding_amount().doubleValue());
			R0330cell7.setCellStyle(numberStyle);
		} else {
			R0330cell7.setCellValue("");
			R0330cell7.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column I
		Cell R0330cell8 = row.createCell(8);
		if (record.getR0330_ccf_unfunded_outstanding_amount() != null) {
			R0330cell8.setCellValue(record.getR0330_ccf_unfunded_outstanding_amount().doubleValue());
			R0330cell8.setCellStyle(numberStyle);
		} else {
			R0330cell8.setCellValue("");
			R0330cell8.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column J
		Cell R0330cell9 = row.createCell(9);
		if (record.getR0330_secured_portion_exposure() != null) {
			R0330cell9.setCellValue(record.getR0330_secured_portion_exposure().doubleValue());
			R0330cell9.setCellStyle(numberStyle);
		} else {
			R0330cell9.setCellValue("");
			R0330cell9.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column K
		Cell R0330cell10 = row.createCell(10);
		if (record.getR0330_post_collateral_haircut() != null) {
			R0330cell10.setCellValue(record.getR0330_post_collateral_haircut().doubleValue());
			R0330cell10.setCellStyle(numberStyle);
		} else {
			R0330cell10.setCellValue("");
			R0330cell10.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column L
		Cell R0330cell11 = row.createCell(11);
		if (record.getR0330_type_of_security() != null) {
			R0330cell11.setCellValue(record.getR0330_type_of_security().doubleValue());
			R0330cell11.setCellStyle(numberStyle);
		} else {
			R0330cell11.setCellValue("");
			R0330cell11.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column M
		Cell R0330cell12 = row.createCell(12);
		if (record.getR0330_discounted_collateral_value() != null) {
			R0330cell12.setCellValue(record.getR0330_discounted_collateral_value().doubleValue());
			R0330cell12.setCellStyle(numberStyle);
		} else {
			R0330cell12.setCellValue("");
			R0330cell12.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column N
		Cell R0330cell13 = row.createCell(13);
		if (record.getR0330_validated_discounted_cashflows() != null) {
			R0330cell13.setCellValue(record.getR0330_validated_discounted_cashflows().doubleValue());
			R0330cell13.setCellStyle(numberStyle);
		} else {
			R0330cell13.setCellValue("");
			R0330cell13.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column O
		Cell R0330cell14 = row.createCell(14);
		if (record.getR0330_pd() != null) {
			R0330cell14.setCellValue(record.getR0330_pd().doubleValue());
			R0330cell14.setCellStyle(numberStyle);
		} else {
			R0330cell14.setCellValue("");
			R0330cell14.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column P
		Cell R0330cell15 = row.createCell(15);
		if (record.getR0330_lgd() != null) {
			R0330cell15.setCellValue(record.getR0330_lgd().doubleValue());
			R0330cell15.setCellStyle(numberStyle);
		} else {
			R0330cell15.setCellValue("");
			R0330cell15.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column Q
		Cell R0330cell16 = row.createCell(16);
		if (record.getR0330_provisions_charged_pnl() != null) {
			R0330cell16.setCellValue(record.getR0330_provisions_charged_pnl().doubleValue());
			R0330cell16.setCellStyle(numberStyle);
		} else {
			R0330cell16.setCellValue("");
			R0330cell16.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column R
		Cell R0330cell17 = row.createCell(17);
		if (record.getR0330_legacy_interest_profit_suspense() != null) {
			R0330cell17.setCellValue(record.getR0330_legacy_interest_profit_suspense().doubleValue());
			R0330cell17.setCellStyle(numberStyle);
		} else {
			R0330cell17.setCellValue("");
			R0330cell17.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column S
		Cell R0330cell18 = row.createCell(18);
		if (record.getR0330_legal_case_yn() != null && !record.getR0330_legal_case_yn().isEmpty()) {
			R0330cell18.setCellValue(record.getR0330_legal_case_yn());
			R0330cell18.setCellStyle(textStyle);
		} else {
			R0330cell18.setCellValue("");
			R0330cell18.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column T
		Cell R0330cell19 = row.createCell(19);
		if (record.getR0330_remarks_if_any() != null && !record.getR0330_remarks_if_any().isEmpty()) {
			R0330cell19.setCellValue(record.getR0330_remarks_if_any());
			R0330cell19.setCellStyle(textStyle);
		} else {
			R0330cell19.setCellValue("");
			R0330cell19.setCellStyle(textStyle);
		}

		/// ROW44
		row = sheet.getRow(43);
		//// Column D
		Cell R0360cell3 = row.createCell(3);
		if (record.getR0360_borrower_name() != null && !record.getR0360_borrower_name().isEmpty()) {
			R0360cell3.setCellValue(record.getR0360_borrower_name());
			R0360cell3.setCellStyle(textStyle);
		} else {
			R0360cell3.setCellValue("");
			R0360cell3.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column E
		Cell R0360cell4 = row.createCell(4);
		if (record.getR0360_group_name_if_applicable() != null
				&& !record.getR0360_group_name_if_applicable().isEmpty()) {
			R0360cell4.setCellValue(record.getR0360_group_name_if_applicable());
			R0360cell4.setCellStyle(textStyle);
		} else {
			R0360cell4.setCellValue("");
			R0360cell4.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column F
		Cell R0360cell5 = row.createCell(5);
		if (record.getR0360_cin() != null && !record.getR0360_cin().isEmpty()) {
			R0360cell5.setCellValue(record.getR0360_cin());
			R0360cell5.setCellStyle(textStyle);
		} else {
			R0360cell5.setCellValue("");
			R0360cell5.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column G
		Cell R0360cell6 = row.createCell(6);
		if (record.getR0360_domicile_country() != null && !record.getR0360_domicile_country().isEmpty()) {
			R0360cell6.setCellValue(record.getR0360_domicile_country());
			R0360cell6.setCellStyle(textStyle);
		} else {
			R0360cell6.setCellValue("");
			R0360cell6.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column H
		Cell R0360cell7 = row.createCell(7);
		if (record.getR0360_funded_outstanding_amount() != null) {
			R0360cell7.setCellValue(record.getR0360_funded_outstanding_amount().doubleValue());
			R0360cell7.setCellStyle(numberStyle);
		} else {
			R0360cell7.setCellValue("");
			R0360cell7.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column I
		Cell R0360cell8 = row.createCell(8);
		if (record.getR0360_ccf_unfunded_outstanding_amount() != null) {
			R0360cell8.setCellValue(record.getR0360_ccf_unfunded_outstanding_amount().doubleValue());
			R0360cell8.setCellStyle(numberStyle);
		} else {
			R0360cell8.setCellValue("");
			R0360cell8.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column J
		Cell R0360cell9 = row.createCell(9);
		if (record.getR0360_secured_portion_exposure() != null) {
			R0360cell9.setCellValue(record.getR0360_secured_portion_exposure().doubleValue());
			R0360cell9.setCellStyle(numberStyle);
		} else {
			R0360cell9.setCellValue("");
			R0360cell9.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column K
		Cell R0360cell10 = row.createCell(10);
		if (record.getR0360_post_collateral_haircut() != null) {
			R0360cell10.setCellValue(record.getR0360_post_collateral_haircut().doubleValue());
			R0360cell10.setCellStyle(numberStyle);
		} else {
			R0360cell10.setCellValue("");
			R0360cell10.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column L
		Cell R0360cell11 = row.createCell(11);
		if (record.getR0360_type_of_security() != null) {
			R0360cell11.setCellValue(record.getR0360_type_of_security().doubleValue());
			R0360cell11.setCellStyle(numberStyle);
		} else {
			R0360cell11.setCellValue("");
			R0360cell11.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column M
		Cell R0360cell12 = row.createCell(12);
		if (record.getR0360_discounted_collateral_value() != null) {
			R0360cell12.setCellValue(record.getR0360_discounted_collateral_value().doubleValue());
			R0360cell12.setCellStyle(numberStyle);
		} else {
			R0360cell12.setCellValue("");
			R0360cell12.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column N
		Cell R0360cell13 = row.createCell(13);
		if (record.getR0360_validated_discounted_cashflows() != null) {
			R0360cell13.setCellValue(record.getR0360_validated_discounted_cashflows().doubleValue());
			R0360cell13.setCellStyle(numberStyle);
		} else {
			R0360cell13.setCellValue("");
			R0360cell13.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column O
		Cell R0360cell14 = row.createCell(14);
		if (record.getR0360_pd() != null) {
			R0360cell14.setCellValue(record.getR0360_pd().doubleValue());
			R0360cell14.setCellStyle(numberStyle);
		} else {
			R0360cell14.setCellValue("");
			R0360cell14.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column P
		Cell R0360cell15 = row.createCell(15);
		if (record.getR0360_lgd() != null) {
			R0360cell15.setCellValue(record.getR0360_lgd().doubleValue());
			R0360cell15.setCellStyle(numberStyle);
		} else {
			R0360cell15.setCellValue("");
			R0360cell15.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column Q
		Cell R0360cell16 = row.createCell(16);
		if (record.getR0360_provisions_charged_pnl() != null) {
			R0360cell16.setCellValue(record.getR0360_provisions_charged_pnl().doubleValue());
			R0360cell16.setCellStyle(numberStyle);
		} else {
			R0360cell16.setCellValue("");
			R0360cell16.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column R
		Cell R0360cell17 = row.createCell(17);
		if (record.getR0360_legacy_interest_profit_suspense() != null) {
			R0360cell17.setCellValue(record.getR0360_legacy_interest_profit_suspense().doubleValue());
			R0360cell17.setCellStyle(numberStyle);
		} else {
			R0360cell17.setCellValue("");
			R0360cell17.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column S
		Cell R0360cell18 = row.createCell(18);
		if (record.getR0360_legal_case_yn() != null && !record.getR0360_legal_case_yn().isEmpty()) {
			R0360cell18.setCellValue(record.getR0360_legal_case_yn());
			R0360cell18.setCellStyle(textStyle);
		} else {
			R0360cell18.setCellValue("");
			R0360cell18.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column T
		Cell R0360cell19 = row.createCell(19);
		if (record.getR0360_remarks_if_any() != null && !record.getR0360_remarks_if_any().isEmpty()) {
			R0360cell19.setCellValue(record.getR0360_remarks_if_any());
			R0360cell19.setCellStyle(textStyle);
		} else {
			R0360cell19.setCellValue("");
			R0360cell19.setCellStyle(textStyle);
		}

		/// ROW45
		row = sheet.getRow(44);
		//// Column D
		Cell R0370cell3 = row.createCell(3);
		if (record.getR0370_borrower_name() != null && !record.getR0370_borrower_name().isEmpty()) {
			R0370cell3.setCellValue(record.getR0370_borrower_name());
			R0370cell3.setCellStyle(textStyle);
		} else {
			R0370cell3.setCellValue("");
			R0370cell3.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column E
		Cell R0370cell4 = row.createCell(4);
		if (record.getR0370_group_name_if_applicable() != null
				&& !record.getR0370_group_name_if_applicable().isEmpty()) {
			R0370cell4.setCellValue(record.getR0370_group_name_if_applicable());
			R0370cell4.setCellStyle(textStyle);
		} else {
			R0370cell4.setCellValue("");
			R0370cell4.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column F
		Cell R0370cell5 = row.createCell(5);
		if (record.getR0370_cin() != null && !record.getR0370_cin().isEmpty()) {
			R0370cell5.setCellValue(record.getR0370_cin());
			R0370cell5.setCellStyle(textStyle);
		} else {
			R0370cell5.setCellValue("");
			R0370cell5.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column G
		Cell R0370cell6 = row.createCell(6);
		if (record.getR0370_domicile_country() != null && !record.getR0370_domicile_country().isEmpty()) {
			R0370cell6.setCellValue(record.getR0370_domicile_country());
			R0370cell6.setCellStyle(textStyle);
		} else {
			R0370cell6.setCellValue("");
			R0370cell6.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column H
		Cell R0370cell7 = row.createCell(7);
		if (record.getR0370_funded_outstanding_amount() != null) {
			R0370cell7.setCellValue(record.getR0370_funded_outstanding_amount().doubleValue());
			R0370cell7.setCellStyle(numberStyle);
		} else {
			R0370cell7.setCellValue("");
			R0370cell7.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column I
		Cell R0370cell8 = row.createCell(8);
		if (record.getR0370_ccf_unfunded_outstanding_amount() != null) {
			R0370cell8.setCellValue(record.getR0370_ccf_unfunded_outstanding_amount().doubleValue());
			R0370cell8.setCellStyle(numberStyle);
		} else {
			R0370cell8.setCellValue("");
			R0370cell8.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column J
		Cell R0370cell9 = row.createCell(9);
		if (record.getR0370_secured_portion_exposure() != null) {
			R0370cell9.setCellValue(record.getR0370_secured_portion_exposure().doubleValue());
			R0370cell9.setCellStyle(numberStyle);
		} else {
			R0370cell9.setCellValue("");
			R0370cell9.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column K
		Cell R0370cell10 = row.createCell(10);
		if (record.getR0370_post_collateral_haircut() != null) {
			R0370cell10.setCellValue(record.getR0370_post_collateral_haircut().doubleValue());
			R0370cell10.setCellStyle(numberStyle);
		} else {
			R0370cell10.setCellValue("");
			R0370cell10.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column L
		Cell R0370cell11 = row.createCell(11);
		if (record.getR0370_type_of_security() != null) {
			R0370cell11.setCellValue(record.getR0370_type_of_security().doubleValue());
			R0370cell11.setCellStyle(numberStyle);
		} else {
			R0370cell11.setCellValue("");
			R0370cell11.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column M
		Cell R0370cell12 = row.createCell(12);
		if (record.getR0370_discounted_collateral_value() != null) {
			R0370cell12.setCellValue(record.getR0370_discounted_collateral_value().doubleValue());
			R0370cell12.setCellStyle(numberStyle);
		} else {
			R0370cell12.setCellValue("");
			R0370cell12.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column N
		Cell R0370cell13 = row.createCell(13);
		if (record.getR0370_validated_discounted_cashflows() != null) {
			R0370cell13.setCellValue(record.getR0370_validated_discounted_cashflows().doubleValue());
			R0370cell13.setCellStyle(numberStyle);
		} else {
			R0370cell13.setCellValue("");
			R0370cell13.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column O
		Cell R0370cell14 = row.createCell(14);
		if (record.getR0370_pd() != null) {
			R0370cell14.setCellValue(record.getR0370_pd().doubleValue());
			R0370cell14.setCellStyle(numberStyle);
		} else {
			R0370cell14.setCellValue("");
			R0370cell14.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column P
		Cell R0370cell15 = row.createCell(15);
		if (record.getR0370_lgd() != null) {
			R0370cell15.setCellValue(record.getR0370_lgd().doubleValue());
			R0370cell15.setCellStyle(numberStyle);
		} else {
			R0370cell15.setCellValue("");
			R0370cell15.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column Q
		Cell R0370cell16 = row.createCell(16);
		if (record.getR0370_provisions_charged_pnl() != null) {
			R0370cell16.setCellValue(record.getR0370_provisions_charged_pnl().doubleValue());
			R0370cell16.setCellStyle(numberStyle);
		} else {
			R0370cell16.setCellValue("");
			R0370cell16.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column R
		Cell R0370cell17 = row.createCell(17);
		if (record.getR0370_legacy_interest_profit_suspense() != null) {
			R0370cell17.setCellValue(record.getR0370_legacy_interest_profit_suspense().doubleValue());
			R0370cell17.setCellStyle(numberStyle);
		} else {
			R0370cell17.setCellValue("");
			R0370cell17.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column S
		Cell R0370cell18 = row.createCell(18);
		if (record.getR0370_legal_case_yn() != null && !record.getR0370_legal_case_yn().isEmpty()) {
			R0370cell18.setCellValue(record.getR0370_legal_case_yn());
			R0370cell18.setCellStyle(textStyle);
		} else {
			R0370cell18.setCellValue("");
			R0370cell18.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column T
		Cell R0370cell19 = row.createCell(19);
		if (record.getR0370_remarks_if_any() != null && !record.getR0370_remarks_if_any().isEmpty()) {
			R0370cell19.setCellValue(record.getR0370_remarks_if_any());
			R0370cell19.setCellStyle(textStyle);
		} else {
			R0370cell19.setCellValue("");
			R0370cell19.setCellStyle(textStyle);
		}

		/// ROW46
		row = sheet.getRow(45);
		//// Column D
		Cell R0380cell3 = row.createCell(3);
		if (record.getR0380_borrower_name() != null && !record.getR0380_borrower_name().isEmpty()) {
			R0380cell3.setCellValue(record.getR0380_borrower_name());
			R0380cell3.setCellStyle(textStyle);
		} else {
			R0380cell3.setCellValue("");
			R0380cell3.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column E
		Cell R0380cell4 = row.createCell(4);
		if (record.getR0380_group_name_if_applicable() != null
				&& !record.getR0380_group_name_if_applicable().isEmpty()) {
			R0380cell4.setCellValue(record.getR0380_group_name_if_applicable());
			R0380cell4.setCellStyle(textStyle);
		} else {
			R0380cell4.setCellValue("");
			R0380cell4.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column F
		Cell R0380cell5 = row.createCell(5);
		if (record.getR0380_cin() != null && !record.getR0380_cin().isEmpty()) {
			R0380cell5.setCellValue(record.getR0380_cin());
			R0380cell5.setCellStyle(textStyle);
		} else {
			R0380cell5.setCellValue("");
			R0380cell5.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column G
		Cell R0380cell6 = row.createCell(6);
		if (record.getR0380_domicile_country() != null && !record.getR0380_domicile_country().isEmpty()) {
			R0380cell6.setCellValue(record.getR0380_domicile_country());
			R0380cell6.setCellStyle(textStyle);
		} else {
			R0380cell6.setCellValue("");
			R0380cell6.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column H
		Cell R0380cell7 = row.createCell(7);
		if (record.getR0380_funded_outstanding_amount() != null) {
			R0380cell7.setCellValue(record.getR0380_funded_outstanding_amount().doubleValue());
			R0380cell7.setCellStyle(numberStyle);
		} else {
			R0380cell7.setCellValue("");
			R0380cell7.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column I
		Cell R0380cell8 = row.createCell(8);
		if (record.getR0380_ccf_unfunded_outstanding_amount() != null) {
			R0380cell8.setCellValue(record.getR0380_ccf_unfunded_outstanding_amount().doubleValue());
			R0380cell8.setCellStyle(numberStyle);
		} else {
			R0380cell8.setCellValue("");
			R0380cell8.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column J
		Cell R0380cell9 = row.createCell(9);
		if (record.getR0380_secured_portion_exposure() != null) {
			R0380cell9.setCellValue(record.getR0380_secured_portion_exposure().doubleValue());
			R0380cell9.setCellStyle(numberStyle);
		} else {
			R0380cell9.setCellValue("");
			R0380cell9.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column K
		Cell R0380cell10 = row.createCell(10);
		if (record.getR0380_post_collateral_haircut() != null) {
			R0380cell10.setCellValue(record.getR0380_post_collateral_haircut().doubleValue());
			R0380cell10.setCellStyle(numberStyle);
		} else {
			R0380cell10.setCellValue("");
			R0380cell10.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column L
		Cell R0380cell11 = row.createCell(11);
		if (record.getR0380_type_of_security() != null) {
			R0380cell11.setCellValue(record.getR0380_type_of_security().doubleValue());
			R0380cell11.setCellStyle(numberStyle);
		} else {
			R0380cell11.setCellValue("");
			R0380cell11.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column M
		Cell R0380cell12 = row.createCell(12);
		if (record.getR0380_discounted_collateral_value() != null) {
			R0380cell12.setCellValue(record.getR0380_discounted_collateral_value().doubleValue());
			R0380cell12.setCellStyle(numberStyle);
		} else {
			R0380cell12.setCellValue("");
			R0380cell12.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column N
		Cell R0380cell13 = row.createCell(13);
		if (record.getR0380_validated_discounted_cashflows() != null) {
			R0380cell13.setCellValue(record.getR0380_validated_discounted_cashflows().doubleValue());
			R0380cell13.setCellStyle(numberStyle);
		} else {
			R0380cell13.setCellValue("");
			R0380cell13.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column O
		Cell R0380cell14 = row.createCell(14);
		if (record.getR0380_pd() != null) {
			R0380cell14.setCellValue(record.getR0380_pd().doubleValue());
			R0380cell14.setCellStyle(numberStyle);
		} else {
			R0380cell14.setCellValue("");
			R0380cell14.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column P
		Cell R0380cell15 = row.createCell(15);
		if (record.getR0380_lgd() != null) {
			R0380cell15.setCellValue(record.getR0380_lgd().doubleValue());
			R0380cell15.setCellStyle(numberStyle);
		} else {
			R0380cell15.setCellValue("");
			R0380cell15.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column Q
		Cell R0380cell16 = row.createCell(16);
		if (record.getR0380_provisions_charged_pnl() != null) {
			R0380cell16.setCellValue(record.getR0380_provisions_charged_pnl().doubleValue());
			R0380cell16.setCellStyle(numberStyle);
		} else {
			R0380cell16.setCellValue("");
			R0380cell16.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column R
		Cell R0380cell17 = row.createCell(17);
		if (record.getR0380_legacy_interest_profit_suspense() != null) {
			R0380cell17.setCellValue(record.getR0380_legacy_interest_profit_suspense().doubleValue());
			R0380cell17.setCellStyle(numberStyle);
		} else {
			R0380cell17.setCellValue("");
			R0380cell17.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column S
		Cell R0380cell18 = row.createCell(18);
		if (record.getR0380_legal_case_yn() != null && !record.getR0380_legal_case_yn().isEmpty()) {
			R0380cell18.setCellValue(record.getR0380_legal_case_yn());
			R0380cell18.setCellStyle(textStyle);
		} else {
			R0380cell18.setCellValue("");
			R0380cell18.setCellStyle(textStyle);
		}

		/// ROW46
		//// Column T
		Cell R0380cell19 = row.createCell(19);
		if (record.getR0380_remarks_if_any() != null && !record.getR0380_remarks_if_any().isEmpty()) {
			R0380cell19.setCellValue(record.getR0380_remarks_if_any());
			R0380cell19.setCellStyle(textStyle);
		} else {
			R0380cell19.setCellValue("");
			R0380cell19.setCellStyle(textStyle);
		}

		/// ROW47
		row = sheet.getRow(46);
		//// Column D
		Cell R0390cell3 = row.createCell(3);
		if (record.getR0390_borrower_name() != null && !record.getR0390_borrower_name().isEmpty()) {
			R0390cell3.setCellValue(record.getR0390_borrower_name());
			R0390cell3.setCellStyle(textStyle);
		} else {
			R0390cell3.setCellValue("");
			R0390cell3.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column E
		Cell R0390cell4 = row.createCell(4);
		if (record.getR0390_group_name_if_applicable() != null
				&& !record.getR0390_group_name_if_applicable().isEmpty()) {
			R0390cell4.setCellValue(record.getR0390_group_name_if_applicable());
			R0390cell4.setCellStyle(textStyle);
		} else {
			R0390cell4.setCellValue("");
			R0390cell4.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column F
		Cell R0390cell5 = row.createCell(5);
		if (record.getR0390_cin() != null && !record.getR0390_cin().isEmpty()) {
			R0390cell5.setCellValue(record.getR0390_cin());
			R0390cell5.setCellStyle(textStyle);
		} else {
			R0390cell5.setCellValue("");
			R0390cell5.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column G
		Cell R0390cell6 = row.createCell(6);
		if (record.getR0390_domicile_country() != null && !record.getR0390_domicile_country().isEmpty()) {
			R0390cell6.setCellValue(record.getR0390_domicile_country());
			R0390cell6.setCellStyle(textStyle);
		} else {
			R0390cell6.setCellValue("");
			R0390cell6.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column H
		Cell R0390cell7 = row.createCell(7);
		if (record.getR0390_funded_outstanding_amount() != null) {
			R0390cell7.setCellValue(record.getR0390_funded_outstanding_amount().doubleValue());
			R0390cell7.setCellStyle(numberStyle);
		} else {
			R0390cell7.setCellValue("");
			R0390cell7.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column I
		Cell R0390cell8 = row.createCell(8);
		if (record.getR0390_ccf_unfunded_outstanding_amount() != null) {
			R0390cell8.setCellValue(record.getR0390_ccf_unfunded_outstanding_amount().doubleValue());
			R0390cell8.setCellStyle(numberStyle);
		} else {
			R0390cell8.setCellValue("");
			R0390cell8.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column J
		Cell R0390cell9 = row.createCell(9);
		if (record.getR0390_secured_portion_exposure() != null) {
			R0390cell9.setCellValue(record.getR0390_secured_portion_exposure().doubleValue());
			R0390cell9.setCellStyle(numberStyle);
		} else {
			R0390cell9.setCellValue("");
			R0390cell9.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column K
		Cell R0390cell10 = row.createCell(10);
		if (record.getR0390_post_collateral_haircut() != null) {
			R0390cell10.setCellValue(record.getR0390_post_collateral_haircut().doubleValue());
			R0390cell10.setCellStyle(numberStyle);
		} else {
			R0390cell10.setCellValue("");
			R0390cell10.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column L
		Cell R0390cell11 = row.createCell(11);
		if (record.getR0390_type_of_security() != null) {
			R0390cell11.setCellValue(record.getR0390_type_of_security().doubleValue());
			R0390cell11.setCellStyle(numberStyle);
		} else {
			R0390cell11.setCellValue("");
			R0390cell11.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column M
		Cell R0390cell12 = row.createCell(12);
		if (record.getR0390_discounted_collateral_value() != null) {
			R0390cell12.setCellValue(record.getR0390_discounted_collateral_value().doubleValue());
			R0390cell12.setCellStyle(numberStyle);
		} else {
			R0390cell12.setCellValue("");
			R0390cell12.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column N
		Cell R0390cell13 = row.createCell(13);
		if (record.getR0390_validated_discounted_cashflows() != null) {
			R0390cell13.setCellValue(record.getR0390_validated_discounted_cashflows().doubleValue());
			R0390cell13.setCellStyle(numberStyle);
		} else {
			R0390cell13.setCellValue("");
			R0390cell13.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column O
		Cell R0390cell14 = row.createCell(14);
		if (record.getR0390_pd() != null) {
			R0390cell14.setCellValue(record.getR0390_pd().doubleValue());
			R0390cell14.setCellStyle(numberStyle);
		} else {
			R0390cell14.setCellValue("");
			R0390cell14.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column P
		Cell R0390cell15 = row.createCell(15);
		if (record.getR0390_lgd() != null) {
			R0390cell15.setCellValue(record.getR0390_lgd().doubleValue());
			R0390cell15.setCellStyle(numberStyle);
		} else {
			R0390cell15.setCellValue("");
			R0390cell15.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column Q
		Cell R0390cell16 = row.createCell(16);
		if (record.getR0390_provisions_charged_pnl() != null) {
			R0390cell16.setCellValue(record.getR0390_provisions_charged_pnl().doubleValue());
			R0390cell16.setCellStyle(numberStyle);
		} else {
			R0390cell16.setCellValue("");
			R0390cell16.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column R
		Cell R0390cell17 = row.createCell(17);
		if (record.getR0390_legacy_interest_profit_suspense() != null) {
			R0390cell17.setCellValue(record.getR0390_legacy_interest_profit_suspense().doubleValue());
			R0390cell17.setCellStyle(numberStyle);
		} else {
			R0390cell17.setCellValue("");
			R0390cell17.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column S
		Cell R0390cell18 = row.createCell(18);
		if (record.getR0390_legal_case_yn() != null && !record.getR0390_legal_case_yn().isEmpty()) {
			R0390cell18.setCellValue(record.getR0390_legal_case_yn());
			R0390cell18.setCellStyle(textStyle);
		} else {
			R0390cell18.setCellValue("");
			R0390cell18.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column T
		Cell R0390cell19 = row.createCell(19);
		if (record.getR0390_remarks_if_any() != null && !record.getR0390_remarks_if_any().isEmpty()) {
			R0390cell19.setCellValue(record.getR0390_remarks_if_any());
			R0390cell19.setCellStyle(textStyle);
		} else {
			R0390cell19.setCellValue("");
			R0390cell19.setCellStyle(textStyle);
		}

		/// ROW48
		row = sheet.getRow(47);
		//// Column D
		Cell R0400cell3 = row.createCell(3);
		if (record.getR0400_borrower_name() != null && !record.getR0400_borrower_name().isEmpty()) {
			R0400cell3.setCellValue(record.getR0400_borrower_name());
			R0400cell3.setCellStyle(textStyle);
		} else {
			R0400cell3.setCellValue("");
			R0400cell3.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column E
		Cell R0400cell4 = row.createCell(4);
		if (record.getR0400_group_name_if_applicable() != null
				&& !record.getR0400_group_name_if_applicable().isEmpty()) {
			R0400cell4.setCellValue(record.getR0400_group_name_if_applicable());
			R0400cell4.setCellStyle(textStyle);
		} else {
			R0400cell4.setCellValue("");
			R0400cell4.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column F
		Cell R0400cell5 = row.createCell(5);
		if (record.getR0400_cin() != null && !record.getR0400_cin().isEmpty()) {
			R0400cell5.setCellValue(record.getR0400_cin());
			R0400cell5.setCellStyle(textStyle);
		} else {
			R0400cell5.setCellValue("");
			R0400cell5.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column G
		Cell R0400cell6 = row.createCell(6);
		if (record.getR0400_domicile_country() != null && !record.getR0400_domicile_country().isEmpty()) {
			R0400cell6.setCellValue(record.getR0400_domicile_country());
			R0400cell6.setCellStyle(textStyle);
		} else {
			R0400cell6.setCellValue("");
			R0400cell6.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column H
		Cell R0400cell7 = row.createCell(7);
		if (record.getR0400_funded_outstanding_amount() != null) {
			R0400cell7.setCellValue(record.getR0400_funded_outstanding_amount().doubleValue());
			R0400cell7.setCellStyle(numberStyle);
		} else {
			R0400cell7.setCellValue("");
			R0400cell7.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column I
		Cell R0400cell8 = row.createCell(8);
		if (record.getR0400_ccf_unfunded_outstanding_amount() != null) {
			R0400cell8.setCellValue(record.getR0400_ccf_unfunded_outstanding_amount().doubleValue());
			R0400cell8.setCellStyle(numberStyle);
		} else {
			R0400cell8.setCellValue("");
			R0400cell8.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column J
		Cell R0400cell9 = row.createCell(9);
		if (record.getR0400_secured_portion_exposure() != null) {
			R0400cell9.setCellValue(record.getR0400_secured_portion_exposure().doubleValue());
			R0400cell9.setCellStyle(numberStyle);
		} else {
			R0400cell9.setCellValue("");
			R0400cell9.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column K
		Cell R0400cell10 = row.createCell(10);
		if (record.getR0400_post_collateral_haircut() != null) {
			R0400cell10.setCellValue(record.getR0400_post_collateral_haircut().doubleValue());
			R0400cell10.setCellStyle(numberStyle);
		} else {
			R0400cell10.setCellValue("");
			R0400cell10.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column L
		Cell R0400cell11 = row.createCell(11);
		if (record.getR0400_type_of_security() != null) {
			R0400cell11.setCellValue(record.getR0400_type_of_security().doubleValue());
			R0400cell11.setCellStyle(numberStyle);
		} else {
			R0400cell11.setCellValue("");
			R0400cell11.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column M
		Cell R0400cell12 = row.createCell(12);
		if (record.getR0400_discounted_collateral_value() != null) {
			R0400cell12.setCellValue(record.getR0400_discounted_collateral_value().doubleValue());
			R0400cell12.setCellStyle(numberStyle);
		} else {
			R0400cell12.setCellValue("");
			R0400cell12.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column N
		Cell R0400cell13 = row.createCell(13);
		if (record.getR0400_validated_discounted_cashflows() != null) {
			R0400cell13.setCellValue(record.getR0400_validated_discounted_cashflows().doubleValue());
			R0400cell13.setCellStyle(numberStyle);
		} else {
			R0400cell13.setCellValue("");
			R0400cell13.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column O
		Cell R0400cell14 = row.createCell(14);
		if (record.getR0400_pd() != null) {
			R0400cell14.setCellValue(record.getR0400_pd().doubleValue());
			R0400cell14.setCellStyle(numberStyle);
		} else {
			R0400cell14.setCellValue("");
			R0400cell14.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column P
		Cell R0400cell15 = row.createCell(15);
		if (record.getR0400_lgd() != null) {
			R0400cell15.setCellValue(record.getR0400_lgd().doubleValue());
			R0400cell15.setCellStyle(numberStyle);
		} else {
			R0400cell15.setCellValue("");
			R0400cell15.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column Q
		Cell R0400cell16 = row.createCell(16);
		if (record.getR0400_provisions_charged_pnl() != null) {
			R0400cell16.setCellValue(record.getR0400_provisions_charged_pnl().doubleValue());
			R0400cell16.setCellStyle(numberStyle);
		} else {
			R0400cell16.setCellValue("");
			R0400cell16.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column R
		Cell R0400cell17 = row.createCell(17);
		if (record.getR0400_legacy_interest_profit_suspense() != null) {
			R0400cell17.setCellValue(record.getR0400_legacy_interest_profit_suspense().doubleValue());
			R0400cell17.setCellStyle(numberStyle);
		} else {
			R0400cell17.setCellValue("");
			R0400cell17.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column S
		Cell R0400cell18 = row.createCell(18);
		if (record.getR0400_legal_case_yn() != null && !record.getR0400_legal_case_yn().isEmpty()) {
			R0400cell18.setCellValue(record.getR0400_legal_case_yn());
			R0400cell18.setCellStyle(textStyle);
		} else {
			R0400cell18.setCellValue("");
			R0400cell18.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column T
		Cell R0400cell19 = row.createCell(19);
		if (record.getR0400_remarks_if_any() != null && !record.getR0400_remarks_if_any().isEmpty()) {
			R0400cell19.setCellValue(record.getR0400_remarks_if_any());
			R0400cell19.setCellStyle(textStyle);
		} else {
			R0400cell19.setCellValue("");
			R0400cell19.setCellStyle(textStyle);
		}

		/// ROW49
		row = sheet.getRow(48);
		//// Column D
		Cell R0410cell3 = row.createCell(3);
		if (record.getR0410_borrower_name() != null && !record.getR0410_borrower_name().isEmpty()) {
			R0410cell3.setCellValue(record.getR0410_borrower_name());
			R0410cell3.setCellStyle(textStyle);
		} else {
			R0410cell3.setCellValue("");
			R0410cell3.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column E
		Cell R0410cell4 = row.createCell(4);
		if (record.getR0410_group_name_if_applicable() != null
				&& !record.getR0410_group_name_if_applicable().isEmpty()) {
			R0410cell4.setCellValue(record.getR0410_group_name_if_applicable());
			R0410cell4.setCellStyle(textStyle);
		} else {
			R0410cell4.setCellValue("");
			R0410cell4.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column F
		Cell R0410cell5 = row.createCell(5);
		if (record.getR0410_cin() != null && !record.getR0410_cin().isEmpty()) {
			R0410cell5.setCellValue(record.getR0410_cin());
			R0410cell5.setCellStyle(textStyle);
		} else {
			R0410cell5.setCellValue("");
			R0410cell5.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column G
		Cell R0410cell6 = row.createCell(6);
		if (record.getR0410_domicile_country() != null && !record.getR0410_domicile_country().isEmpty()) {
			R0410cell6.setCellValue(record.getR0410_domicile_country());
			R0410cell6.setCellStyle(textStyle);
		} else {
			R0410cell6.setCellValue("");
			R0410cell6.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column H
		Cell R0410cell7 = row.createCell(7);
		if (record.getR0410_funded_outstanding_amount() != null) {
			R0410cell7.setCellValue(record.getR0410_funded_outstanding_amount().doubleValue());
			R0410cell7.setCellStyle(numberStyle);
		} else {
			R0410cell7.setCellValue("");
			R0410cell7.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column I
		Cell R0410cell8 = row.createCell(8);
		if (record.getR0410_ccf_unfunded_outstanding_amount() != null) {
			R0410cell8.setCellValue(record.getR0410_ccf_unfunded_outstanding_amount().doubleValue());
			R0410cell8.setCellStyle(numberStyle);
		} else {
			R0410cell8.setCellValue("");
			R0410cell8.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column J
		Cell R0410cell9 = row.createCell(9);
		if (record.getR0410_secured_portion_exposure() != null) {
			R0410cell9.setCellValue(record.getR0410_secured_portion_exposure().doubleValue());
			R0410cell9.setCellStyle(numberStyle);
		} else {
			R0410cell9.setCellValue("");
			R0410cell9.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column K
		Cell R0410cell10 = row.createCell(10);
		if (record.getR0410_post_collateral_haircut() != null) {
			R0410cell10.setCellValue(record.getR0410_post_collateral_haircut().doubleValue());
			R0410cell10.setCellStyle(numberStyle);
		} else {
			R0410cell10.setCellValue("");
			R0410cell10.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column L
		Cell R0410cell11 = row.createCell(11);
		if (record.getR0410_type_of_security() != null) {
			R0410cell11.setCellValue(record.getR0410_type_of_security().doubleValue());
			R0410cell11.setCellStyle(numberStyle);
		} else {
			R0410cell11.setCellValue("");
			R0410cell11.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column M
		Cell R0410cell12 = row.createCell(12);
		if (record.getR0410_discounted_collateral_value() != null) {
			R0410cell12.setCellValue(record.getR0410_discounted_collateral_value().doubleValue());
			R0410cell12.setCellStyle(numberStyle);
		} else {
			R0410cell12.setCellValue("");
			R0410cell12.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column N
		Cell R0410cell13 = row.createCell(13);
		if (record.getR0410_validated_discounted_cashflows() != null) {
			R0410cell13.setCellValue(record.getR0410_validated_discounted_cashflows().doubleValue());
			R0410cell13.setCellStyle(numberStyle);
		} else {
			R0410cell13.setCellValue("");
			R0410cell13.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column O
		Cell R0410cell14 = row.createCell(14);
		if (record.getR0410_pd() != null) {
			R0410cell14.setCellValue(record.getR0410_pd().doubleValue());
			R0410cell14.setCellStyle(numberStyle);
		} else {
			R0410cell14.setCellValue("");
			R0410cell14.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column P
		Cell R0410cell15 = row.createCell(15);
		if (record.getR0410_lgd() != null) {
			R0410cell15.setCellValue(record.getR0410_lgd().doubleValue());
			R0410cell15.setCellStyle(numberStyle);
		} else {
			R0410cell15.setCellValue("");
			R0410cell15.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column Q
		Cell R0410cell16 = row.createCell(16);
		if (record.getR0410_provisions_charged_pnl() != null) {
			R0410cell16.setCellValue(record.getR0410_provisions_charged_pnl().doubleValue());
			R0410cell16.setCellStyle(numberStyle);
		} else {
			R0410cell16.setCellValue("");
			R0410cell16.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column R
		Cell R0410cell17 = row.createCell(17);
		if (record.getR0410_legacy_interest_profit_suspense() != null) {
			R0410cell17.setCellValue(record.getR0410_legacy_interest_profit_suspense().doubleValue());
			R0410cell17.setCellStyle(numberStyle);
		} else {
			R0410cell17.setCellValue("");
			R0410cell17.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column S
		Cell R0410cell18 = row.createCell(18);
		if (record.getR0410_legal_case_yn() != null && !record.getR0410_legal_case_yn().isEmpty()) {
			R0410cell18.setCellValue(record.getR0410_legal_case_yn());
			R0410cell18.setCellStyle(textStyle);
		} else {
			R0410cell18.setCellValue("");
			R0410cell18.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column T
		Cell R0410cell19 = row.createCell(19);
		if (record.getR0410_remarks_if_any() != null && !record.getR0410_remarks_if_any().isEmpty()) {
			R0410cell19.setCellValue(record.getR0410_remarks_if_any());
			R0410cell19.setCellStyle(textStyle);
		} else {
			R0410cell19.setCellValue("");
			R0410cell19.setCellStyle(textStyle);
		}

		/// ROW50
		row = sheet.getRow(49);
		//// Column D
		Cell R0420cell3 = row.createCell(3);
		if (record.getR0420_borrower_name() != null && !record.getR0420_borrower_name().isEmpty()) {
			R0420cell3.setCellValue(record.getR0420_borrower_name());
			R0420cell3.setCellStyle(textStyle);
		} else {
			R0420cell3.setCellValue("");
			R0420cell3.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column E
		Cell R0420cell4 = row.createCell(4);
		if (record.getR0420_group_name_if_applicable() != null
				&& !record.getR0420_group_name_if_applicable().isEmpty()) {
			R0420cell4.setCellValue(record.getR0420_group_name_if_applicable());
			R0420cell4.setCellStyle(textStyle);
		} else {
			R0420cell4.setCellValue("");
			R0420cell4.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column F
		Cell R0420cell5 = row.createCell(5);
		if (record.getR0420_cin() != null && !record.getR0420_cin().isEmpty()) {
			R0420cell5.setCellValue(record.getR0420_cin());
			R0420cell5.setCellStyle(textStyle);
		} else {
			R0420cell5.setCellValue("");
			R0420cell5.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column G
		Cell R0420cell6 = row.createCell(6);
		if (record.getR0420_domicile_country() != null && !record.getR0420_domicile_country().isEmpty()) {
			R0420cell6.setCellValue(record.getR0420_domicile_country());
			R0420cell6.setCellStyle(textStyle);
		} else {
			R0420cell6.setCellValue("");
			R0420cell6.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column H
		Cell R0420cell7 = row.createCell(7);
		if (record.getR0420_funded_outstanding_amount() != null) {
			R0420cell7.setCellValue(record.getR0420_funded_outstanding_amount().doubleValue());
			R0420cell7.setCellStyle(numberStyle);
		} else {
			R0420cell7.setCellValue("");
			R0420cell7.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column I
		Cell R0420cell8 = row.createCell(8);
		if (record.getR0420_ccf_unfunded_outstanding_amount() != null) {
			R0420cell8.setCellValue(record.getR0420_ccf_unfunded_outstanding_amount().doubleValue());
			R0420cell8.setCellStyle(numberStyle);
		} else {
			R0420cell8.setCellValue("");
			R0420cell8.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column J
		Cell R0420cell9 = row.createCell(9);
		if (record.getR0420_secured_portion_exposure() != null) {
			R0420cell9.setCellValue(record.getR0420_secured_portion_exposure().doubleValue());
			R0420cell9.setCellStyle(numberStyle);
		} else {
			R0420cell9.setCellValue("");
			R0420cell9.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column K
		Cell R0420cell10 = row.createCell(10);
		if (record.getR0420_post_collateral_haircut() != null) {
			R0420cell10.setCellValue(record.getR0420_post_collateral_haircut().doubleValue());
			R0420cell10.setCellStyle(numberStyle);
		} else {
			R0420cell10.setCellValue("");
			R0420cell10.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column L
		Cell R0420cell11 = row.createCell(11);
		if (record.getR0420_type_of_security() != null) {
			R0420cell11.setCellValue(record.getR0420_type_of_security().doubleValue());
			R0420cell11.setCellStyle(numberStyle);
		} else {
			R0420cell11.setCellValue("");
			R0420cell11.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column M
		Cell R0420cell12 = row.createCell(12);
		if (record.getR0420_discounted_collateral_value() != null) {
			R0420cell12.setCellValue(record.getR0420_discounted_collateral_value().doubleValue());
			R0420cell12.setCellStyle(numberStyle);
		} else {
			R0420cell12.setCellValue("");
			R0420cell12.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column N
		Cell R0420cell13 = row.createCell(13);
		if (record.getR0420_validated_discounted_cashflows() != null) {
			R0420cell13.setCellValue(record.getR0420_validated_discounted_cashflows().doubleValue());
			R0420cell13.setCellStyle(numberStyle);
		} else {
			R0420cell13.setCellValue("");
			R0420cell13.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column O
		Cell R0420cell14 = row.createCell(14);
		if (record.getR0420_pd() != null) {
			R0420cell14.setCellValue(record.getR0420_pd().doubleValue());
			R0420cell14.setCellStyle(numberStyle);
		} else {
			R0420cell14.setCellValue("");
			R0420cell14.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column P
		Cell R0420cell15 = row.createCell(15);
		if (record.getR0420_lgd() != null) {
			R0420cell15.setCellValue(record.getR0420_lgd().doubleValue());
			R0420cell15.setCellStyle(numberStyle);
		} else {
			R0420cell15.setCellValue("");
			R0420cell15.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column Q
		Cell R0420cell16 = row.createCell(16);
		if (record.getR0420_provisions_charged_pnl() != null) {
			R0420cell16.setCellValue(record.getR0420_provisions_charged_pnl().doubleValue());
			R0420cell16.setCellStyle(numberStyle);
		} else {
			R0420cell16.setCellValue("");
			R0420cell16.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column R
		Cell R0420cell17 = row.createCell(17);
		if (record.getR0420_legacy_interest_profit_suspense() != null) {
			R0420cell17.setCellValue(record.getR0420_legacy_interest_profit_suspense().doubleValue());
			R0420cell17.setCellStyle(numberStyle);
		} else {
			R0420cell17.setCellValue("");
			R0420cell17.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column S
		Cell R0420cell18 = row.createCell(18);
		if (record.getR0420_legal_case_yn() != null && !record.getR0420_legal_case_yn().isEmpty()) {
			R0420cell18.setCellValue(record.getR0420_legal_case_yn());
			R0420cell18.setCellStyle(textStyle);
		} else {
			R0420cell18.setCellValue("");
			R0420cell18.setCellStyle(textStyle);
		}

		/// ROW50
		//// Column T
		Cell R0420cell19 = row.createCell(19);
		if (record.getR0420_remarks_if_any() != null && !record.getR0420_remarks_if_any().isEmpty()) {
			R0420cell19.setCellValue(record.getR0420_remarks_if_any());
			R0420cell19.setCellStyle(textStyle);
		} else {
			R0420cell19.setCellValue("");
			R0420cell19.setCellStyle(textStyle);
		}

		/// ROW51
		row = sheet.getRow(50);
		//// Column D
		Cell R0430cell3 = row.createCell(3);
		if (record.getR0430_borrower_name() != null && !record.getR0430_borrower_name().isEmpty()) {
			R0430cell3.setCellValue(record.getR0430_borrower_name());
			R0430cell3.setCellStyle(textStyle);
		} else {
			R0430cell3.setCellValue("");
			R0430cell3.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column E
		Cell R0430cell4 = row.createCell(4);
		if (record.getR0430_group_name_if_applicable() != null
				&& !record.getR0430_group_name_if_applicable().isEmpty()) {
			R0430cell4.setCellValue(record.getR0430_group_name_if_applicable());
			R0430cell4.setCellStyle(textStyle);
		} else {
			R0430cell4.setCellValue("");
			R0430cell4.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column F
		Cell R0430cell5 = row.createCell(5);
		if (record.getR0430_cin() != null && !record.getR0430_cin().isEmpty()) {
			R0430cell5.setCellValue(record.getR0430_cin());
			R0430cell5.setCellStyle(textStyle);
		} else {
			R0430cell5.setCellValue("");
			R0430cell5.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column G
		Cell R0430cell6 = row.createCell(6);
		if (record.getR0430_domicile_country() != null && !record.getR0430_domicile_country().isEmpty()) {
			R0430cell6.setCellValue(record.getR0430_domicile_country());
			R0430cell6.setCellStyle(textStyle);
		} else {
			R0430cell6.setCellValue("");
			R0430cell6.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column H
		Cell R0430cell7 = row.createCell(7);
		if (record.getR0430_funded_outstanding_amount() != null) {
			R0430cell7.setCellValue(record.getR0430_funded_outstanding_amount().doubleValue());
			R0430cell7.setCellStyle(numberStyle);
		} else {
			R0430cell7.setCellValue("");
			R0430cell7.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column I
		Cell R0430cell8 = row.createCell(8);
		if (record.getR0430_ccf_unfunded_outstanding_amount() != null) {
			R0430cell8.setCellValue(record.getR0430_ccf_unfunded_outstanding_amount().doubleValue());
			R0430cell8.setCellStyle(numberStyle);
		} else {
			R0430cell8.setCellValue("");
			R0430cell8.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column J
		Cell R0430cell9 = row.createCell(9);
		if (record.getR0430_secured_portion_exposure() != null) {
			R0430cell9.setCellValue(record.getR0430_secured_portion_exposure().doubleValue());
			R0430cell9.setCellStyle(numberStyle);
		} else {
			R0430cell9.setCellValue("");
			R0430cell9.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column K
		Cell R0430cell10 = row.createCell(10);
		if (record.getR0430_post_collateral_haircut() != null) {
			R0430cell10.setCellValue(record.getR0430_post_collateral_haircut().doubleValue());
			R0430cell10.setCellStyle(numberStyle);
		} else {
			R0430cell10.setCellValue("");
			R0430cell10.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column L
		Cell R0430cell11 = row.createCell(11);
		if (record.getR0430_type_of_security() != null) {
			R0430cell11.setCellValue(record.getR0430_type_of_security().doubleValue());
			R0430cell11.setCellStyle(numberStyle);
		} else {
			R0430cell11.setCellValue("");
			R0430cell11.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column M
		Cell R0430cell12 = row.createCell(12);
		if (record.getR0430_discounted_collateral_value() != null) {
			R0430cell12.setCellValue(record.getR0430_discounted_collateral_value().doubleValue());
			R0430cell12.setCellStyle(numberStyle);
		} else {
			R0430cell12.setCellValue("");
			R0430cell12.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column N
		Cell R0430cell13 = row.createCell(13);
		if (record.getR0430_validated_discounted_cashflows() != null) {
			R0430cell13.setCellValue(record.getR0430_validated_discounted_cashflows().doubleValue());
			R0430cell13.setCellStyle(numberStyle);
		} else {
			R0430cell13.setCellValue("");
			R0430cell13.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column O
		Cell R0430cell14 = row.createCell(14);
		if (record.getR0430_pd() != null) {
			R0430cell14.setCellValue(record.getR0430_pd().doubleValue());
			R0430cell14.setCellStyle(numberStyle);
		} else {
			R0430cell14.setCellValue("");
			R0430cell14.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column P
		Cell R0430cell15 = row.createCell(15);
		if (record.getR0430_lgd() != null) {
			R0430cell15.setCellValue(record.getR0430_lgd().doubleValue());
			R0430cell15.setCellStyle(numberStyle);
		} else {
			R0430cell15.setCellValue("");
			R0430cell15.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column Q
		Cell R0430cell16 = row.createCell(16);
		if (record.getR0430_provisions_charged_pnl() != null) {
			R0430cell16.setCellValue(record.getR0430_provisions_charged_pnl().doubleValue());
			R0430cell16.setCellStyle(numberStyle);
		} else {
			R0430cell16.setCellValue("");
			R0430cell16.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column R
		Cell R0430cell17 = row.createCell(17);
		if (record.getR0430_legacy_interest_profit_suspense() != null) {
			R0430cell17.setCellValue(record.getR0430_legacy_interest_profit_suspense().doubleValue());
			R0430cell17.setCellStyle(numberStyle);
		} else {
			R0430cell17.setCellValue("");
			R0430cell17.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column S
		Cell R0430cell18 = row.createCell(18);
		if (record.getR0430_legal_case_yn() != null && !record.getR0430_legal_case_yn().isEmpty()) {
			R0430cell18.setCellValue(record.getR0430_legal_case_yn());
			R0430cell18.setCellStyle(textStyle);
		} else {
			R0430cell18.setCellValue("");
			R0430cell18.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column T
		Cell R0430cell19 = row.createCell(19);
		if (record.getR0430_remarks_if_any() != null && !record.getR0430_remarks_if_any().isEmpty()) {
			R0430cell19.setCellValue(record.getR0430_remarks_if_any());
			R0430cell19.setCellStyle(textStyle);
		} else {
			R0430cell19.setCellValue("");
			R0430cell19.setCellStyle(textStyle);
		}

		/// ROW52
		row = sheet.getRow(51);
		//// Column D
		Cell R0440cell3 = row.createCell(3);
		if (record.getR0440_borrower_name() != null && !record.getR0440_borrower_name().isEmpty()) {
			R0440cell3.setCellValue(record.getR0440_borrower_name());
			R0440cell3.setCellStyle(textStyle);
		} else {
			R0440cell3.setCellValue("");
			R0440cell3.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column E
		Cell R0440cell4 = row.createCell(4);
		if (record.getR0440_group_name_if_applicable() != null
				&& !record.getR0440_group_name_if_applicable().isEmpty()) {
			R0440cell4.setCellValue(record.getR0440_group_name_if_applicable());
			R0440cell4.setCellStyle(textStyle);
		} else {
			R0440cell4.setCellValue("");
			R0440cell4.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column F
		Cell R0440cell5 = row.createCell(5);
		if (record.getR0440_cin() != null && !record.getR0440_cin().isEmpty()) {
			R0440cell5.setCellValue(record.getR0440_cin());
			R0440cell5.setCellStyle(textStyle);
		} else {
			R0440cell5.setCellValue("");
			R0440cell5.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column G
		Cell R0440cell6 = row.createCell(6);
		if (record.getR0440_domicile_country() != null && !record.getR0440_domicile_country().isEmpty()) {
			R0440cell6.setCellValue(record.getR0440_domicile_country());
			R0440cell6.setCellStyle(textStyle);
		} else {
			R0440cell6.setCellValue("");
			R0440cell6.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column H
		Cell R0440cell7 = row.createCell(7);
		if (record.getR0440_funded_outstanding_amount() != null) {
			R0440cell7.setCellValue(record.getR0440_funded_outstanding_amount().doubleValue());
			R0440cell7.setCellStyle(numberStyle);
		} else {
			R0440cell7.setCellValue("");
			R0440cell7.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column I
		Cell R0440cell8 = row.createCell(8);
		if (record.getR0440_ccf_unfunded_outstanding_amount() != null) {
			R0440cell8.setCellValue(record.getR0440_ccf_unfunded_outstanding_amount().doubleValue());
			R0440cell8.setCellStyle(numberStyle);
		} else {
			R0440cell8.setCellValue("");
			R0440cell8.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column J
		Cell R0440cell9 = row.createCell(9);
		if (record.getR0440_secured_portion_exposure() != null) {
			R0440cell9.setCellValue(record.getR0440_secured_portion_exposure().doubleValue());
			R0440cell9.setCellStyle(numberStyle);
		} else {
			R0440cell9.setCellValue("");
			R0440cell9.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column K
		Cell R0440cell10 = row.createCell(10);
		if (record.getR0440_post_collateral_haircut() != null) {
			R0440cell10.setCellValue(record.getR0440_post_collateral_haircut().doubleValue());
			R0440cell10.setCellStyle(numberStyle);
		} else {
			R0440cell10.setCellValue("");
			R0440cell10.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column L
		Cell R0440cell11 = row.createCell(11);
		if (record.getR0440_type_of_security() != null) {
			R0440cell11.setCellValue(record.getR0440_type_of_security().doubleValue());
			R0440cell11.setCellStyle(numberStyle);
		} else {
			R0440cell11.setCellValue("");
			R0440cell11.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column M
		Cell R0440cell12 = row.createCell(12);
		if (record.getR0440_discounted_collateral_value() != null) {
			R0440cell12.setCellValue(record.getR0440_discounted_collateral_value().doubleValue());
			R0440cell12.setCellStyle(numberStyle);
		} else {
			R0440cell12.setCellValue("");
			R0440cell12.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column N
		Cell R0440cell13 = row.createCell(13);
		if (record.getR0440_validated_discounted_cashflows() != null) {
			R0440cell13.setCellValue(record.getR0440_validated_discounted_cashflows().doubleValue());
			R0440cell13.setCellStyle(numberStyle);
		} else {
			R0440cell13.setCellValue("");
			R0440cell13.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column O
		Cell R0440cell14 = row.createCell(14);
		if (record.getR0440_pd() != null) {
			R0440cell14.setCellValue(record.getR0440_pd().doubleValue());
			R0440cell14.setCellStyle(numberStyle);
		} else {
			R0440cell14.setCellValue("");
			R0440cell14.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column P
		Cell R0440cell15 = row.createCell(15);
		if (record.getR0440_lgd() != null) {
			R0440cell15.setCellValue(record.getR0440_lgd().doubleValue());
			R0440cell15.setCellStyle(numberStyle);
		} else {
			R0440cell15.setCellValue("");
			R0440cell15.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column Q
		Cell R0440cell16 = row.createCell(16);
		if (record.getR0440_provisions_charged_pnl() != null) {
			R0440cell16.setCellValue(record.getR0440_provisions_charged_pnl().doubleValue());
			R0440cell16.setCellStyle(numberStyle);
		} else {
			R0440cell16.setCellValue("");
			R0440cell16.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column R
		Cell R0440cell17 = row.createCell(17);
		if (record.getR0440_legacy_interest_profit_suspense() != null) {
			R0440cell17.setCellValue(record.getR0440_legacy_interest_profit_suspense().doubleValue());
			R0440cell17.setCellStyle(numberStyle);
		} else {
			R0440cell17.setCellValue("");
			R0440cell17.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column S
		Cell R0440cell18 = row.createCell(18);
		if (record.getR0440_legal_case_yn() != null && !record.getR0440_legal_case_yn().isEmpty()) {
			R0440cell18.setCellValue(record.getR0440_legal_case_yn());
			R0440cell18.setCellStyle(textStyle);
		} else {
			R0440cell18.setCellValue("");
			R0440cell18.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column T
		Cell R0440cell19 = row.createCell(19);
		if (record.getR0440_remarks_if_any() != null && !record.getR0440_remarks_if_any().isEmpty()) {
			R0440cell19.setCellValue(record.getR0440_remarks_if_any());
			R0440cell19.setCellStyle(textStyle);
		} else {
			R0440cell19.setCellValue("");
			R0440cell19.setCellStyle(textStyle);
		}

		/// ROW53
		row = sheet.getRow(52);
		//// Column D
		Cell R0450cell3 = row.createCell(3);
		if (record.getR0450_borrower_name() != null && !record.getR0450_borrower_name().isEmpty()) {
			R0450cell3.setCellValue(record.getR0450_borrower_name());
			R0450cell3.setCellStyle(textStyle);
		} else {
			R0450cell3.setCellValue("");
			R0450cell3.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column E
		Cell R0450cell4 = row.createCell(4);
		if (record.getR0450_group_name_if_applicable() != null
				&& !record.getR0450_group_name_if_applicable().isEmpty()) {
			R0450cell4.setCellValue(record.getR0450_group_name_if_applicable());
			R0450cell4.setCellStyle(textStyle);
		} else {
			R0450cell4.setCellValue("");
			R0450cell4.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column F
		Cell R0450cell5 = row.createCell(5);
		if (record.getR0450_cin() != null && !record.getR0450_cin().isEmpty()) {
			R0450cell5.setCellValue(record.getR0450_cin());
			R0450cell5.setCellStyle(textStyle);
		} else {
			R0450cell5.setCellValue("");
			R0450cell5.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column G
		Cell R0450cell6 = row.createCell(6);
		if (record.getR0450_domicile_country() != null && !record.getR0450_domicile_country().isEmpty()) {
			R0450cell6.setCellValue(record.getR0450_domicile_country());
			R0450cell6.setCellStyle(textStyle);
		} else {
			R0450cell6.setCellValue("");
			R0450cell6.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column H
		Cell R0450cell7 = row.createCell(7);
		if (record.getR0450_funded_outstanding_amount() != null) {
			R0450cell7.setCellValue(record.getR0450_funded_outstanding_amount().doubleValue());
			R0450cell7.setCellStyle(numberStyle);
		} else {
			R0450cell7.setCellValue("");
			R0450cell7.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column I
		Cell R0450cell8 = row.createCell(8);
		if (record.getR0450_ccf_unfunded_outstanding_amount() != null) {
			R0450cell8.setCellValue(record.getR0450_ccf_unfunded_outstanding_amount().doubleValue());
			R0450cell8.setCellStyle(numberStyle);
		} else {
			R0450cell8.setCellValue("");
			R0450cell8.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column J
		Cell R0450cell9 = row.createCell(9);
		if (record.getR0450_secured_portion_exposure() != null) {
			R0450cell9.setCellValue(record.getR0450_secured_portion_exposure().doubleValue());
			R0450cell9.setCellStyle(numberStyle);
		} else {
			R0450cell9.setCellValue("");
			R0450cell9.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column K
		Cell R0450cell10 = row.createCell(10);
		if (record.getR0450_post_collateral_haircut() != null) {
			R0450cell10.setCellValue(record.getR0450_post_collateral_haircut().doubleValue());
			R0450cell10.setCellStyle(numberStyle);
		} else {
			R0450cell10.setCellValue("");
			R0450cell10.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column L
		Cell R0450cell11 = row.createCell(11);
		if (record.getR0450_type_of_security() != null) {
			R0450cell11.setCellValue(record.getR0450_type_of_security().doubleValue());
			R0450cell11.setCellStyle(numberStyle);
		} else {
			R0450cell11.setCellValue("");
			R0450cell11.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column M
		Cell R0450cell12 = row.createCell(12);
		if (record.getR0450_discounted_collateral_value() != null) {
			R0450cell12.setCellValue(record.getR0450_discounted_collateral_value().doubleValue());
			R0450cell12.setCellStyle(numberStyle);
		} else {
			R0450cell12.setCellValue("");
			R0450cell12.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column N
		Cell R0450cell13 = row.createCell(13);
		if (record.getR0450_validated_discounted_cashflows() != null) {
			R0450cell13.setCellValue(record.getR0450_validated_discounted_cashflows().doubleValue());
			R0450cell13.setCellStyle(numberStyle);
		} else {
			R0450cell13.setCellValue("");
			R0450cell13.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column O
		Cell R0450cell14 = row.createCell(14);
		if (record.getR0450_pd() != null) {
			R0450cell14.setCellValue(record.getR0450_pd().doubleValue());
			R0450cell14.setCellStyle(numberStyle);
		} else {
			R0450cell14.setCellValue("");
			R0450cell14.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column P
		Cell R0450cell15 = row.createCell(15);
		if (record.getR0450_lgd() != null) {
			R0450cell15.setCellValue(record.getR0450_lgd().doubleValue());
			R0450cell15.setCellStyle(numberStyle);
		} else {
			R0450cell15.setCellValue("");
			R0450cell15.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column Q
		Cell R0450cell16 = row.createCell(16);
		if (record.getR0450_provisions_charged_pnl() != null) {
			R0450cell16.setCellValue(record.getR0450_provisions_charged_pnl().doubleValue());
			R0450cell16.setCellStyle(numberStyle);
		} else {
			R0450cell16.setCellValue("");
			R0450cell16.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column R
		Cell R0450cell17 = row.createCell(17);
		if (record.getR0450_legacy_interest_profit_suspense() != null) {
			R0450cell17.setCellValue(record.getR0450_legacy_interest_profit_suspense().doubleValue());
			R0450cell17.setCellStyle(numberStyle);
		} else {
			R0450cell17.setCellValue("");
			R0450cell17.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column S
		Cell R0450cell18 = row.createCell(18);
		if (record.getR0450_legal_case_yn() != null && !record.getR0450_legal_case_yn().isEmpty()) {
			R0450cell18.setCellValue(record.getR0450_legal_case_yn());
			R0450cell18.setCellStyle(textStyle);
		} else {
			R0450cell18.setCellValue("");
			R0450cell18.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column T
		Cell R0450cell19 = row.createCell(19);
		if (record.getR0450_remarks_if_any() != null && !record.getR0450_remarks_if_any().isEmpty()) {
			R0450cell19.setCellValue(record.getR0450_remarks_if_any());
			R0450cell19.setCellStyle(textStyle);
		} else {
			R0450cell19.setCellValue("");
			R0450cell19.setCellStyle(textStyle);
		}

		/// ROW54
		row = sheet.getRow(53);
		//// Column D
		Cell R0460cell3 = row.createCell(3);
		if (record.getR0460_borrower_name() != null && !record.getR0460_borrower_name().isEmpty()) {
			R0460cell3.setCellValue(record.getR0460_borrower_name());
			R0460cell3.setCellStyle(textStyle);
		} else {
			R0460cell3.setCellValue("");
			R0460cell3.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column E
		Cell R0460cell4 = row.createCell(4);
		if (record.getR0460_group_name_if_applicable() != null
				&& !record.getR0460_group_name_if_applicable().isEmpty()) {
			R0460cell4.setCellValue(record.getR0460_group_name_if_applicable());
			R0460cell4.setCellStyle(textStyle);
		} else {
			R0460cell4.setCellValue("");
			R0460cell4.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column F
		Cell R0460cell5 = row.createCell(5);
		if (record.getR0460_cin() != null && !record.getR0460_cin().isEmpty()) {
			R0460cell5.setCellValue(record.getR0460_cin());
			R0460cell5.setCellStyle(textStyle);
		} else {
			R0460cell5.setCellValue("");
			R0460cell5.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column G
		Cell R0460cell6 = row.createCell(6);
		if (record.getR0460_domicile_country() != null && !record.getR0460_domicile_country().isEmpty()) {
			R0460cell6.setCellValue(record.getR0460_domicile_country());
			R0460cell6.setCellStyle(textStyle);
		} else {
			R0460cell6.setCellValue("");
			R0460cell6.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column H
		Cell R0460cell7 = row.createCell(7);
		if (record.getR0460_funded_outstanding_amount() != null) {
			R0460cell7.setCellValue(record.getR0460_funded_outstanding_amount().doubleValue());
			R0460cell7.setCellStyle(numberStyle);
		} else {
			R0460cell7.setCellValue("");
			R0460cell7.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column I
		Cell R0460cell8 = row.createCell(8);
		if (record.getR0460_ccf_unfunded_outstanding_amount() != null) {
			R0460cell8.setCellValue(record.getR0460_ccf_unfunded_outstanding_amount().doubleValue());
			R0460cell8.setCellStyle(numberStyle);
		} else {
			R0460cell8.setCellValue("");
			R0460cell8.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column J
		Cell R0460cell9 = row.createCell(9);
		if (record.getR0460_secured_portion_exposure() != null) {
			R0460cell9.setCellValue(record.getR0460_secured_portion_exposure().doubleValue());
			R0460cell9.setCellStyle(numberStyle);
		} else {
			R0460cell9.setCellValue("");
			R0460cell9.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column K
		Cell R0460cell10 = row.createCell(10);
		if (record.getR0460_post_collateral_haircut() != null) {
			R0460cell10.setCellValue(record.getR0460_post_collateral_haircut().doubleValue());
			R0460cell10.setCellStyle(numberStyle);
		} else {
			R0460cell10.setCellValue("");
			R0460cell10.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column L
		Cell R0460cell11 = row.createCell(11);
		if (record.getR0460_type_of_security() != null) {
			R0460cell11.setCellValue(record.getR0460_type_of_security().doubleValue());
			R0460cell11.setCellStyle(numberStyle);
		} else {
			R0460cell11.setCellValue("");
			R0460cell11.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column M
		Cell R0460cell12 = row.createCell(12);
		if (record.getR0460_discounted_collateral_value() != null) {
			R0460cell12.setCellValue(record.getR0460_discounted_collateral_value().doubleValue());
			R0460cell12.setCellStyle(numberStyle);
		} else {
			R0460cell12.setCellValue("");
			R0460cell12.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column N
		Cell R0460cell13 = row.createCell(13);
		if (record.getR0460_validated_discounted_cashflows() != null) {
			R0460cell13.setCellValue(record.getR0460_validated_discounted_cashflows().doubleValue());
			R0460cell13.setCellStyle(numberStyle);
		} else {
			R0460cell13.setCellValue("");
			R0460cell13.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column O
		Cell R0460cell14 = row.createCell(14);
		if (record.getR0460_pd() != null) {
			R0460cell14.setCellValue(record.getR0460_pd().doubleValue());
			R0460cell14.setCellStyle(numberStyle);
		} else {
			R0460cell14.setCellValue("");
			R0460cell14.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column P
		Cell R0460cell15 = row.createCell(15);
		if (record.getR0460_lgd() != null) {
			R0460cell15.setCellValue(record.getR0460_lgd().doubleValue());
			R0460cell15.setCellStyle(numberStyle);
		} else {
			R0460cell15.setCellValue("");
			R0460cell15.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column Q
		Cell R0460cell16 = row.createCell(16);
		if (record.getR0460_provisions_charged_pnl() != null) {
			R0460cell16.setCellValue(record.getR0460_provisions_charged_pnl().doubleValue());
			R0460cell16.setCellStyle(numberStyle);
		} else {
			R0460cell16.setCellValue("");
			R0460cell16.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column R
		Cell R0460cell17 = row.createCell(17);
		if (record.getR0460_legacy_interest_profit_suspense() != null) {
			R0460cell17.setCellValue(record.getR0460_legacy_interest_profit_suspense().doubleValue());
			R0460cell17.setCellStyle(numberStyle);
		} else {
			R0460cell17.setCellValue("");
			R0460cell17.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column S
		Cell R0460cell18 = row.createCell(18);
		if (record.getR0460_legal_case_yn() != null && !record.getR0460_legal_case_yn().isEmpty()) {
			R0460cell18.setCellValue(record.getR0460_legal_case_yn());
			R0460cell18.setCellStyle(textStyle);
		} else {
			R0460cell18.setCellValue("");
			R0460cell18.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column T
		Cell R0460cell19 = row.createCell(19);
		if (record.getR0460_remarks_if_any() != null && !record.getR0460_remarks_if_any().isEmpty()) {
			R0460cell19.setCellValue(record.getR0460_remarks_if_any());
			R0460cell19.setCellStyle(textStyle);
		} else {
			R0460cell19.setCellValue("");
			R0460cell19.setCellStyle(textStyle);
		}

		/// ROW55
		row = sheet.getRow(54);
		//// Column D
		Cell R0470cell3 = row.createCell(3);
		if (record.getR0470_borrower_name() != null && !record.getR0470_borrower_name().isEmpty()) {
			R0470cell3.setCellValue(record.getR0470_borrower_name());
			R0470cell3.setCellStyle(textStyle);
		} else {
			R0470cell3.setCellValue("");
			R0470cell3.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column E
		Cell R0470cell4 = row.createCell(4);
		if (record.getR0470_group_name_if_applicable() != null
				&& !record.getR0470_group_name_if_applicable().isEmpty()) {
			R0470cell4.setCellValue(record.getR0470_group_name_if_applicable());
			R0470cell4.setCellStyle(textStyle);
		} else {
			R0470cell4.setCellValue("");
			R0470cell4.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column F
		Cell R0470cell5 = row.createCell(5);
		if (record.getR0470_cin() != null && !record.getR0470_cin().isEmpty()) {
			R0470cell5.setCellValue(record.getR0470_cin());
			R0470cell5.setCellStyle(textStyle);
		} else {
			R0470cell5.setCellValue("");
			R0470cell5.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column G
		Cell R0470cell6 = row.createCell(6);
		if (record.getR0470_domicile_country() != null && !record.getR0470_domicile_country().isEmpty()) {
			R0470cell6.setCellValue(record.getR0470_domicile_country());
			R0470cell6.setCellStyle(textStyle);
		} else {
			R0470cell6.setCellValue("");
			R0470cell6.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column H
		Cell R0470cell7 = row.createCell(7);
		if (record.getR0470_funded_outstanding_amount() != null) {
			R0470cell7.setCellValue(record.getR0470_funded_outstanding_amount().doubleValue());
			R0470cell7.setCellStyle(numberStyle);
		} else {
			R0470cell7.setCellValue("");
			R0470cell7.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column I
		Cell R0470cell8 = row.createCell(8);
		if (record.getR0470_ccf_unfunded_outstanding_amount() != null) {
			R0470cell8.setCellValue(record.getR0470_ccf_unfunded_outstanding_amount().doubleValue());
			R0470cell8.setCellStyle(numberStyle);
		} else {
			R0470cell8.setCellValue("");
			R0470cell8.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column J
		Cell R0470cell9 = row.createCell(9);
		if (record.getR0470_secured_portion_exposure() != null) {
			R0470cell9.setCellValue(record.getR0470_secured_portion_exposure().doubleValue());
			R0470cell9.setCellStyle(numberStyle);
		} else {
			R0470cell9.setCellValue("");
			R0470cell9.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column K
		Cell R0470cell10 = row.createCell(10);
		if (record.getR0470_post_collateral_haircut() != null) {
			R0470cell10.setCellValue(record.getR0470_post_collateral_haircut().doubleValue());
			R0470cell10.setCellStyle(numberStyle);
		} else {
			R0470cell10.setCellValue("");
			R0470cell10.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column L
		Cell R0470cell11 = row.createCell(11);
		if (record.getR0470_type_of_security() != null) {
			R0470cell11.setCellValue(record.getR0470_type_of_security().doubleValue());
			R0470cell11.setCellStyle(numberStyle);
		} else {
			R0470cell11.setCellValue("");
			R0470cell11.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column M
		Cell R0470cell12 = row.createCell(12);
		if (record.getR0470_discounted_collateral_value() != null) {
			R0470cell12.setCellValue(record.getR0470_discounted_collateral_value().doubleValue());
			R0470cell12.setCellStyle(numberStyle);
		} else {
			R0470cell12.setCellValue("");
			R0470cell12.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column N
		Cell R0470cell13 = row.createCell(13);
		if (record.getR0470_validated_discounted_cashflows() != null) {
			R0470cell13.setCellValue(record.getR0470_validated_discounted_cashflows().doubleValue());
			R0470cell13.setCellStyle(numberStyle);
		} else {
			R0470cell13.setCellValue("");
			R0470cell13.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column O
		Cell R0470cell14 = row.createCell(14);
		if (record.getR0470_pd() != null) {
			R0470cell14.setCellValue(record.getR0470_pd().doubleValue());
			R0470cell14.setCellStyle(numberStyle);
		} else {
			R0470cell14.setCellValue("");
			R0470cell14.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column P
		Cell R0470cell15 = row.createCell(15);
		if (record.getR0470_lgd() != null) {
			R0470cell15.setCellValue(record.getR0470_lgd().doubleValue());
			R0470cell15.setCellStyle(numberStyle);
		} else {
			R0470cell15.setCellValue("");
			R0470cell15.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column Q
		Cell R0470cell16 = row.createCell(16);
		if (record.getR0470_provisions_charged_pnl() != null) {
			R0470cell16.setCellValue(record.getR0470_provisions_charged_pnl().doubleValue());
			R0470cell16.setCellStyle(numberStyle);
		} else {
			R0470cell16.setCellValue("");
			R0470cell16.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column R
		Cell R0470cell17 = row.createCell(17);
		if (record.getR0470_legacy_interest_profit_suspense() != null) {
			R0470cell17.setCellValue(record.getR0470_legacy_interest_profit_suspense().doubleValue());
			R0470cell17.setCellStyle(numberStyle);
		} else {
			R0470cell17.setCellValue("");
			R0470cell17.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column S
		Cell R0470cell18 = row.createCell(18);
		if (record.getR0470_legal_case_yn() != null && !record.getR0470_legal_case_yn().isEmpty()) {
			R0470cell18.setCellValue(record.getR0470_legal_case_yn());
			R0470cell18.setCellStyle(textStyle);
		} else {
			R0470cell18.setCellValue("");
			R0470cell18.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column T
		Cell R0470cell19 = row.createCell(19);
		if (record.getR0470_remarks_if_any() != null && !record.getR0470_remarks_if_any().isEmpty()) {
			R0470cell19.setCellValue(record.getR0470_remarks_if_any());
			R0470cell19.setCellStyle(textStyle);
		} else {
			R0470cell19.setCellValue("");
			R0470cell19.setCellStyle(textStyle);
		}

		/// ROW56
		row = sheet.getRow(55);
		//// Column D
		Cell R0480cell3 = row.createCell(3);
		if (record.getR0480_borrower_name() != null && !record.getR0480_borrower_name().isEmpty()) {
			R0480cell3.setCellValue(record.getR0480_borrower_name());
			R0480cell3.setCellStyle(textStyle);
		} else {
			R0480cell3.setCellValue("");
			R0480cell3.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column E
		Cell R0480cell4 = row.createCell(4);
		if (record.getR0480_group_name_if_applicable() != null
				&& !record.getR0480_group_name_if_applicable().isEmpty()) {
			R0480cell4.setCellValue(record.getR0480_group_name_if_applicable());
			R0480cell4.setCellStyle(textStyle);
		} else {
			R0480cell4.setCellValue("");
			R0480cell4.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column F
		Cell R0480cell5 = row.createCell(5);
		if (record.getR0480_cin() != null && !record.getR0480_cin().isEmpty()) {
			R0480cell5.setCellValue(record.getR0480_cin());
			R0480cell5.setCellStyle(textStyle);
		} else {
			R0480cell5.setCellValue("");
			R0480cell5.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column G
		Cell R0480cell6 = row.createCell(6);
		if (record.getR0480_domicile_country() != null && !record.getR0480_domicile_country().isEmpty()) {
			R0480cell6.setCellValue(record.getR0480_domicile_country());
			R0480cell6.setCellStyle(textStyle);
		} else {
			R0480cell6.setCellValue("");
			R0480cell6.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column H
		Cell R0480cell7 = row.createCell(7);
		if (record.getR0480_funded_outstanding_amount() != null) {
			R0480cell7.setCellValue(record.getR0480_funded_outstanding_amount().doubleValue());
			R0480cell7.setCellStyle(numberStyle);
		} else {
			R0480cell7.setCellValue("");
			R0480cell7.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column I
		Cell R0480cell8 = row.createCell(8);
		if (record.getR0480_ccf_unfunded_outstanding_amount() != null) {
			R0480cell8.setCellValue(record.getR0480_ccf_unfunded_outstanding_amount().doubleValue());
			R0480cell8.setCellStyle(numberStyle);
		} else {
			R0480cell8.setCellValue("");
			R0480cell8.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column J
		Cell R0480cell9 = row.createCell(9);
		if (record.getR0480_secured_portion_exposure() != null) {
			R0480cell9.setCellValue(record.getR0480_secured_portion_exposure().doubleValue());
			R0480cell9.setCellStyle(numberStyle);
		} else {
			R0480cell9.setCellValue("");
			R0480cell9.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column K
		Cell R0480cell10 = row.createCell(10);
		if (record.getR0480_post_collateral_haircut() != null) {
			R0480cell10.setCellValue(record.getR0480_post_collateral_haircut().doubleValue());
			R0480cell10.setCellStyle(numberStyle);
		} else {
			R0480cell10.setCellValue("");
			R0480cell10.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column L
		Cell R0480cell11 = row.createCell(11);
		if (record.getR0480_type_of_security() != null) {
			R0480cell11.setCellValue(record.getR0480_type_of_security().doubleValue());
			R0480cell11.setCellStyle(numberStyle);
		} else {
			R0480cell11.setCellValue("");
			R0480cell11.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column M
		Cell R0480cell12 = row.createCell(12);
		if (record.getR0480_discounted_collateral_value() != null) {
			R0480cell12.setCellValue(record.getR0480_discounted_collateral_value().doubleValue());
			R0480cell12.setCellStyle(numberStyle);
		} else {
			R0480cell12.setCellValue("");
			R0480cell12.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column N
		Cell R0480cell13 = row.createCell(13);
		if (record.getR0480_validated_discounted_cashflows() != null) {
			R0480cell13.setCellValue(record.getR0480_validated_discounted_cashflows().doubleValue());
			R0480cell13.setCellStyle(numberStyle);
		} else {
			R0480cell13.setCellValue("");
			R0480cell13.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column O
		Cell R0480cell14 = row.createCell(14);
		if (record.getR0480_pd() != null) {
			R0480cell14.setCellValue(record.getR0480_pd().doubleValue());
			R0480cell14.setCellStyle(numberStyle);
		} else {
			R0480cell14.setCellValue("");
			R0480cell14.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column P
		Cell R0480cell15 = row.createCell(15);
		if (record.getR0480_lgd() != null) {
			R0480cell15.setCellValue(record.getR0480_lgd().doubleValue());
			R0480cell15.setCellStyle(numberStyle);
		} else {
			R0480cell15.setCellValue("");
			R0480cell15.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column Q
		Cell R0480cell16 = row.createCell(16);
		if (record.getR0480_provisions_charged_pnl() != null) {
			R0480cell16.setCellValue(record.getR0480_provisions_charged_pnl().doubleValue());
			R0480cell16.setCellStyle(numberStyle);
		} else {
			R0480cell16.setCellValue("");
			R0480cell16.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column R
		Cell R0480cell17 = row.createCell(17);
		if (record.getR0480_legacy_interest_profit_suspense() != null) {
			R0480cell17.setCellValue(record.getR0480_legacy_interest_profit_suspense().doubleValue());
			R0480cell17.setCellStyle(numberStyle);
		} else {
			R0480cell17.setCellValue("");
			R0480cell17.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column S
		Cell R0480cell18 = row.createCell(18);
		if (record.getR0480_legal_case_yn() != null && !record.getR0480_legal_case_yn().isEmpty()) {
			R0480cell18.setCellValue(record.getR0480_legal_case_yn());
			R0480cell18.setCellStyle(textStyle);
		} else {
			R0480cell18.setCellValue("");
			R0480cell18.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column T
		Cell R0480cell19 = row.createCell(19);
		if (record.getR0480_remarks_if_any() != null && !record.getR0480_remarks_if_any().isEmpty()) {
			R0480cell19.setCellValue(record.getR0480_remarks_if_any());
			R0480cell19.setCellStyle(textStyle);
		} else {
			R0480cell19.setCellValue("");
			R0480cell19.setCellStyle(textStyle);
		}

		/// ROW57
		row = sheet.getRow(56);
		//// Column D
		Cell R0490cell3 = row.createCell(3);
		if (record.getR0490_borrower_name() != null && !record.getR0490_borrower_name().isEmpty()) {
			R0490cell3.setCellValue(record.getR0490_borrower_name());
			R0490cell3.setCellStyle(textStyle);
		} else {
			R0490cell3.setCellValue("");
			R0490cell3.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column E
		Cell R0490cell4 = row.createCell(4);
		if (record.getR0490_group_name_if_applicable() != null
				&& !record.getR0490_group_name_if_applicable().isEmpty()) {
			R0490cell4.setCellValue(record.getR0490_group_name_if_applicable());
			R0490cell4.setCellStyle(textStyle);
		} else {
			R0490cell4.setCellValue("");
			R0490cell4.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column F
		Cell R0490cell5 = row.createCell(5);
		if (record.getR0490_cin() != null && !record.getR0490_cin().isEmpty()) {
			R0490cell5.setCellValue(record.getR0490_cin());
			R0490cell5.setCellStyle(textStyle);
		} else {
			R0490cell5.setCellValue("");
			R0490cell5.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column G
		Cell R0490cell6 = row.createCell(6);
		if (record.getR0490_domicile_country() != null && !record.getR0490_domicile_country().isEmpty()) {
			R0490cell6.setCellValue(record.getR0490_domicile_country());
			R0490cell6.setCellStyle(textStyle);
		} else {
			R0490cell6.setCellValue("");
			R0490cell6.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column H
		Cell R0490cell7 = row.createCell(7);
		if (record.getR0490_funded_outstanding_amount() != null) {
			R0490cell7.setCellValue(record.getR0490_funded_outstanding_amount().doubleValue());
			R0490cell7.setCellStyle(numberStyle);
		} else {
			R0490cell7.setCellValue("");
			R0490cell7.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column I
		Cell R0490cell8 = row.createCell(8);
		if (record.getR0490_ccf_unfunded_outstanding_amount() != null) {
			R0490cell8.setCellValue(record.getR0490_ccf_unfunded_outstanding_amount().doubleValue());
			R0490cell8.setCellStyle(numberStyle);
		} else {
			R0490cell8.setCellValue("");
			R0490cell8.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column J
		Cell R0490cell9 = row.createCell(9);
		if (record.getR0490_secured_portion_exposure() != null) {
			R0490cell9.setCellValue(record.getR0490_secured_portion_exposure().doubleValue());
			R0490cell9.setCellStyle(numberStyle);
		} else {
			R0490cell9.setCellValue("");
			R0490cell9.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column K
		Cell R0490cell10 = row.createCell(10);
		if (record.getR0490_post_collateral_haircut() != null) {
			R0490cell10.setCellValue(record.getR0490_post_collateral_haircut().doubleValue());
			R0490cell10.setCellStyle(numberStyle);
		} else {
			R0490cell10.setCellValue("");
			R0490cell10.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column L
		Cell R0490cell11 = row.createCell(11);
		if (record.getR0490_type_of_security() != null) {
			R0490cell11.setCellValue(record.getR0490_type_of_security().doubleValue());
			R0490cell11.setCellStyle(numberStyle);
		} else {
			R0490cell11.setCellValue("");
			R0490cell11.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column M
		Cell R0490cell12 = row.createCell(12);
		if (record.getR0490_discounted_collateral_value() != null) {
			R0490cell12.setCellValue(record.getR0490_discounted_collateral_value().doubleValue());
			R0490cell12.setCellStyle(numberStyle);
		} else {
			R0490cell12.setCellValue("");
			R0490cell12.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column N
		Cell R0490cell13 = row.createCell(13);
		if (record.getR0490_validated_discounted_cashflows() != null) {
			R0490cell13.setCellValue(record.getR0490_validated_discounted_cashflows().doubleValue());
			R0490cell13.setCellStyle(numberStyle);
		} else {
			R0490cell13.setCellValue("");
			R0490cell13.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column O
		Cell R0490cell14 = row.createCell(14);
		if (record.getR0490_pd() != null) {
			R0490cell14.setCellValue(record.getR0490_pd().doubleValue());
			R0490cell14.setCellStyle(numberStyle);
		} else {
			R0490cell14.setCellValue("");
			R0490cell14.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column P
		Cell R0490cell15 = row.createCell(15);
		if (record.getR0490_lgd() != null) {
			R0490cell15.setCellValue(record.getR0490_lgd().doubleValue());
			R0490cell15.setCellStyle(numberStyle);
		} else {
			R0490cell15.setCellValue("");
			R0490cell15.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column Q
		Cell R0490cell16 = row.createCell(16);
		if (record.getR0490_provisions_charged_pnl() != null) {
			R0490cell16.setCellValue(record.getR0490_provisions_charged_pnl().doubleValue());
			R0490cell16.setCellStyle(numberStyle);
		} else {
			R0490cell16.setCellValue("");
			R0490cell16.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column R
		Cell R0490cell17 = row.createCell(17);
		if (record.getR0490_legacy_interest_profit_suspense() != null) {
			R0490cell17.setCellValue(record.getR0490_legacy_interest_profit_suspense().doubleValue());
			R0490cell17.setCellStyle(numberStyle);
		} else {
			R0490cell17.setCellValue("");
			R0490cell17.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column S
		Cell R0490cell18 = row.createCell(18);
		if (record.getR0490_legal_case_yn() != null && !record.getR0490_legal_case_yn().isEmpty()) {
			R0490cell18.setCellValue(record.getR0490_legal_case_yn());
			R0490cell18.setCellStyle(textStyle);
		} else {
			R0490cell18.setCellValue("");
			R0490cell18.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column T
		Cell R0490cell19 = row.createCell(19);
		if (record.getR0490_remarks_if_any() != null && !record.getR0490_remarks_if_any().isEmpty()) {
			R0490cell19.setCellValue(record.getR0490_remarks_if_any());
			R0490cell19.setCellStyle(textStyle);
		} else {
			R0490cell19.setCellValue("");
			R0490cell19.setCellStyle(textStyle);
		}

		/// ROW58
		row = sheet.getRow(57);
		//// Column D
		Cell R0500cell3 = row.createCell(3);
		if (record.getR0500_borrower_name() != null && !record.getR0500_borrower_name().isEmpty()) {
			R0500cell3.setCellValue(record.getR0500_borrower_name());
			R0500cell3.setCellStyle(textStyle);
		} else {
			R0500cell3.setCellValue("");
			R0500cell3.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column E
		Cell R0500cell4 = row.createCell(4);
		if (record.getR0500_group_name_if_applicable() != null
				&& !record.getR0500_group_name_if_applicable().isEmpty()) {
			R0500cell4.setCellValue(record.getR0500_group_name_if_applicable());
			R0500cell4.setCellStyle(textStyle);
		} else {
			R0500cell4.setCellValue("");
			R0500cell4.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column F
		Cell R0500cell5 = row.createCell(5);
		if (record.getR0500_cin() != null && !record.getR0500_cin().isEmpty()) {
			R0500cell5.setCellValue(record.getR0500_cin());
			R0500cell5.setCellStyle(textStyle);
		} else {
			R0500cell5.setCellValue("");
			R0500cell5.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column G
		Cell R0500cell6 = row.createCell(6);
		if (record.getR0500_domicile_country() != null && !record.getR0500_domicile_country().isEmpty()) {
			R0500cell6.setCellValue(record.getR0500_domicile_country());
			R0500cell6.setCellStyle(textStyle);
		} else {
			R0500cell6.setCellValue("");
			R0500cell6.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column H
		Cell R0500cell7 = row.createCell(7);
		if (record.getR0500_funded_outstanding_amount() != null) {
			R0500cell7.setCellValue(record.getR0500_funded_outstanding_amount().doubleValue());
			R0500cell7.setCellStyle(numberStyle);
		} else {
			R0500cell7.setCellValue("");
			R0500cell7.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column I
		Cell R0500cell8 = row.createCell(8);
		if (record.getR0500_ccf_unfunded_outstanding_amount() != null) {
			R0500cell8.setCellValue(record.getR0500_ccf_unfunded_outstanding_amount().doubleValue());
			R0500cell8.setCellStyle(numberStyle);
		} else {
			R0500cell8.setCellValue("");
			R0500cell8.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column J
		Cell R0500cell9 = row.createCell(9);
		if (record.getR0500_secured_portion_exposure() != null) {
			R0500cell9.setCellValue(record.getR0500_secured_portion_exposure().doubleValue());
			R0500cell9.setCellStyle(numberStyle);
		} else {
			R0500cell9.setCellValue("");
			R0500cell9.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column K
		Cell R0500cell10 = row.createCell(10);
		if (record.getR0500_post_collateral_haircut() != null) {
			R0500cell10.setCellValue(record.getR0500_post_collateral_haircut().doubleValue());
			R0500cell10.setCellStyle(numberStyle);
		} else {
			R0500cell10.setCellValue("");
			R0500cell10.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column L
		Cell R0500cell11 = row.createCell(11);
		if (record.getR0500_type_of_security() != null) {
			R0500cell11.setCellValue(record.getR0500_type_of_security().doubleValue());
			R0500cell11.setCellStyle(numberStyle);
		} else {
			R0500cell11.setCellValue("");
			R0500cell11.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column M
		Cell R0500cell12 = row.createCell(12);
		if (record.getR0500_discounted_collateral_value() != null) {
			R0500cell12.setCellValue(record.getR0500_discounted_collateral_value().doubleValue());
			R0500cell12.setCellStyle(numberStyle);
		} else {
			R0500cell12.setCellValue("");
			R0500cell12.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column N
		Cell R0500cell13 = row.createCell(13);
		if (record.getR0500_validated_discounted_cashflows() != null) {
			R0500cell13.setCellValue(record.getR0500_validated_discounted_cashflows().doubleValue());
			R0500cell13.setCellStyle(numberStyle);
		} else {
			R0500cell13.setCellValue("");
			R0500cell13.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column O
		Cell R0500cell14 = row.createCell(14);
		if (record.getR0500_pd() != null) {
			R0500cell14.setCellValue(record.getR0500_pd().doubleValue());
			R0500cell14.setCellStyle(numberStyle);
		} else {
			R0500cell14.setCellValue("");
			R0500cell14.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column P
		Cell R0500cell15 = row.createCell(15);
		if (record.getR0500_lgd() != null) {
			R0500cell15.setCellValue(record.getR0500_lgd().doubleValue());
			R0500cell15.setCellStyle(numberStyle);
		} else {
			R0500cell15.setCellValue("");
			R0500cell15.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column Q
		Cell R0500cell16 = row.createCell(16);
		if (record.getR0500_provisions_charged_pnl() != null) {
			R0500cell16.setCellValue(record.getR0500_provisions_charged_pnl().doubleValue());
			R0500cell16.setCellStyle(numberStyle);
		} else {
			R0500cell16.setCellValue("");
			R0500cell16.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column R
		Cell R0500cell17 = row.createCell(17);
		if (record.getR0500_legacy_interest_profit_suspense() != null) {
			R0500cell17.setCellValue(record.getR0500_legacy_interest_profit_suspense().doubleValue());
			R0500cell17.setCellStyle(numberStyle);
		} else {
			R0500cell17.setCellValue("");
			R0500cell17.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column S
		Cell R0500cell18 = row.createCell(18);
		if (record.getR0500_legal_case_yn() != null && !record.getR0500_legal_case_yn().isEmpty()) {
			R0500cell18.setCellValue(record.getR0500_legal_case_yn());
			R0500cell18.setCellStyle(textStyle);
		} else {
			R0500cell18.setCellValue("");
			R0500cell18.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column T
		Cell R0500cell19 = row.createCell(19);
		if (record.getR0500_remarks_if_any() != null && !record.getR0500_remarks_if_any().isEmpty()) {
			R0500cell19.setCellValue(record.getR0500_remarks_if_any());
			R0500cell19.setCellStyle(textStyle);
		} else {
			R0500cell19.setCellValue("");
			R0500cell19.setCellStyle(textStyle);
		}
	
	}
	private void populateEntity2Data(Sheet sheet, CBUAE_BRF5_2_Summary_Entity2 record1, CellStyle textStyle, CellStyle numberStyle) {
	    	    
	    // R0530 - ROW 61 (Index 60)
	    Row row = sheet.getRow(60) != null ? sheet.getRow(60) : sheet.createRow(60);
	    
	   

				/// ROW61

				//// Column D
				Cell R0530cell3 = row.createCell(3);
				if (record1.getR0530_borrower_name() != null && !record1.getR0530_borrower_name().isEmpty()) {
					R0530cell3.setCellValue(record1.getR0530_borrower_name());
					R0530cell3.setCellStyle(textStyle);
				} else {
					R0530cell3.setCellValue("");
					R0530cell3.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column E
				Cell R0530cell4 = row.createCell(4);
				if (record1.getR0530_group_name_if_applicable() != null
						&& !record1.getR0530_group_name_if_applicable().isEmpty()) {
					R0530cell4.setCellValue(record1.getR0530_group_name_if_applicable());
					R0530cell4.setCellStyle(textStyle);
				} else {
					R0530cell4.setCellValue("");
					R0530cell4.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column F
				Cell R0530cell5 = row.createCell(5);
				if (record1.getR0530_cin() != null && !record1.getR0530_cin().isEmpty()) {
					R0530cell5.setCellValue(record1.getR0530_cin());
					R0530cell5.setCellStyle(textStyle);
				} else {
					R0530cell5.setCellValue("");
					R0530cell5.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column G
				Cell R0530cell6 = row.createCell(6);
				if (record1.getR0530_domicile_country() != null
						&& !record1.getR0530_domicile_country().isEmpty()) {
					R0530cell6.setCellValue(record1.getR0530_domicile_country());
					R0530cell6.setCellStyle(textStyle);
				} else {
					R0530cell6.setCellValue("");
					R0530cell6.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column H
				Cell R0530cell7 = row.createCell(7);
				if (record1.getR0530_funded_outstanding_amount() != null) {
					R0530cell7.setCellValue(record1.getR0530_funded_outstanding_amount().doubleValue());
					R0530cell7.setCellStyle(numberStyle);
				} else {
					R0530cell7.setCellValue("");
					R0530cell7.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column I
				Cell R0530cell8 = row.createCell(8);
				if (record1.getR0530_ccf_unfunded_outstanding_amount() != null) {
					R0530cell8.setCellValue(record1.getR0530_ccf_unfunded_outstanding_amount().doubleValue());
					R0530cell8.setCellStyle(numberStyle);
				} else {
					R0530cell8.setCellValue("");
					R0530cell8.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column J
				Cell R0530cell9 = row.createCell(9);
				if (record1.getR0530_secured_portion_exposure() != null) {
					R0530cell9.setCellValue(record1.getR0530_secured_portion_exposure().doubleValue());
					R0530cell9.setCellStyle(numberStyle);
				} else {
					R0530cell9.setCellValue("");
					R0530cell9.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column K
				Cell R0530cell10 = row.createCell(10);
				if (record1.getR0530_post_collateral_haircut() != null) {
					R0530cell10.setCellValue(record1.getR0530_post_collateral_haircut().doubleValue());
					R0530cell10.setCellStyle(numberStyle);
				} else {
					R0530cell10.setCellValue("");
					R0530cell10.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column L
				Cell R0530cell11 = row.createCell(11);
				if (record1.getR0530_type_of_security() != null) {
					R0530cell11.setCellValue(record1.getR0530_type_of_security().doubleValue());
					R0530cell11.setCellStyle(numberStyle);
				} else {
					R0530cell11.setCellValue("");
					R0530cell11.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column M
				Cell R0530cell12 = row.createCell(12);
				if (record1.getR0530_discounted_collateral_value() != null) {
					R0530cell12.setCellValue(record1.getR0530_discounted_collateral_value().doubleValue());
					R0530cell12.setCellStyle(numberStyle);
				} else {
					R0530cell12.setCellValue("");
					R0530cell12.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column N
				Cell R0530cell13 = row.createCell(13);
				if (record1.getR0530_validated_discounted_cashflows() != null) {
					R0530cell13.setCellValue(record1.getR0530_validated_discounted_cashflows().doubleValue());
					R0530cell13.setCellStyle(numberStyle);
				} else {
					R0530cell13.setCellValue("");
					R0530cell13.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column O
				Cell R0530cell14 = row.createCell(14);
				if (record1.getR0530_pd() != null) {
					R0530cell14.setCellValue(record1.getR0530_pd().doubleValue());
					R0530cell14.setCellStyle(numberStyle);
				} else {
					R0530cell14.setCellValue("");
					R0530cell14.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column P
				Cell R0530cell15 = row.createCell(15);
				if (record1.getR0530_lgd() != null) {
					R0530cell15.setCellValue(record1.getR0530_lgd().doubleValue());
					R0530cell15.setCellStyle(numberStyle);
				} else {
					R0530cell15.setCellValue("");
					R0530cell15.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column Q
				Cell R0530cell16 = row.createCell(16);
				if (record1.getR0530_provisions_charged_pnl() != null) {
					R0530cell16.setCellValue(record1.getR0530_provisions_charged_pnl().doubleValue());
					R0530cell16.setCellStyle(numberStyle);
				} else {
					R0530cell16.setCellValue("");
					R0530cell16.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column R
				Cell R0530cell17 = row.createCell(17);
				if (record1.getR0530_legacy_interest_profit_suspense() != null) {
					R0530cell17.setCellValue(record1.getR0530_legacy_interest_profit_suspense().doubleValue());
					R0530cell17.setCellStyle(numberStyle);
				} else {
					R0530cell17.setCellValue("");
					R0530cell17.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column S
				Cell R0530cell18 = row.createCell(18);
				if (record1.getR0530_legal_case_yn() != null && !record1.getR0530_legal_case_yn().isEmpty()) {
					R0530cell18.setCellValue(record1.getR0530_legal_case_yn());
					R0530cell18.setCellStyle(textStyle);
				} else {
					R0530cell18.setCellValue("");
					R0530cell18.setCellStyle(textStyle);
				}

				/// ROW61
				//// Column T
				Cell R0530cell19 = row.createCell(19);
				if (record1.getR0530_remarks_if_any() != null && !record1.getR0530_remarks_if_any().isEmpty()) {
					R0530cell19.setCellValue(record1.getR0530_remarks_if_any());
					R0530cell19.setCellStyle(textStyle);
				} else {
					R0530cell19.setCellValue("");
					R0530cell19.setCellStyle(textStyle);
				}
				/// ROW62
				row = sheet.getRow(61);
				//// Column D
				Cell R0540cell3 = row.createCell(3);
				if (record1.getR0540_borrower_name() != null && !record1.getR0540_borrower_name().isEmpty()) {
					R0540cell3.setCellValue(record1.getR0540_borrower_name());
					R0540cell3.setCellStyle(textStyle);
				} else {
					R0540cell3.setCellValue("");
					R0540cell3.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column E
				Cell R0540cell4 = row.createCell(4);
				if (record1.getR0540_group_name_if_applicable() != null
						&& !record1.getR0540_group_name_if_applicable().isEmpty()) {
					R0540cell4.setCellValue(record1.getR0540_group_name_if_applicable());
					R0540cell4.setCellStyle(textStyle);
				} else {
					R0540cell4.setCellValue("");
					R0540cell4.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column F
				Cell R0540cell5 = row.createCell(5);
				if (record1.getR0540_cin() != null && !record1.getR0540_cin().isEmpty()) {
					R0540cell5.setCellValue(record1.getR0540_cin());
					R0540cell5.setCellStyle(textStyle);
				} else {
					R0540cell5.setCellValue("");
					R0540cell5.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column G
				Cell R0540cell6 = row.createCell(6);
				if (record1.getR0540_domicile_country() != null
						&& !record1.getR0540_domicile_country().isEmpty()) {
					R0540cell6.setCellValue(record1.getR0540_domicile_country());
					R0540cell6.setCellStyle(textStyle);
				} else {
					R0540cell6.setCellValue("");
					R0540cell6.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column H
				Cell R0540cell7 = row.createCell(7);
				if (record1.getR0540_funded_outstanding_amount() != null) {
					R0540cell7.setCellValue(record1.getR0540_funded_outstanding_amount().doubleValue());
					R0540cell7.setCellStyle(numberStyle);
				} else {
					R0540cell7.setCellValue("");
					R0540cell7.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column I
				Cell R0540cell8 = row.createCell(8);
				if (record1.getR0540_ccf_unfunded_outstanding_amount() != null) {
					R0540cell8.setCellValue(record1.getR0540_ccf_unfunded_outstanding_amount().doubleValue());
					R0540cell8.setCellStyle(numberStyle);
				} else {
					R0540cell8.setCellValue("");
					R0540cell8.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column J
				Cell R0540cell9 = row.createCell(9);
				if (record1.getR0540_secured_portion_exposure() != null) {
					R0540cell9.setCellValue(record1.getR0540_secured_portion_exposure().doubleValue());
					R0540cell9.setCellStyle(numberStyle);
				} else {
					R0540cell9.setCellValue("");
					R0540cell9.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column K
				Cell R0540cell10 = row.createCell(10);
				if (record1.getR0540_post_collateral_haircut() != null) {
					R0540cell10.setCellValue(record1.getR0540_post_collateral_haircut().doubleValue());
					R0540cell10.setCellStyle(numberStyle);
				} else {
					R0540cell10.setCellValue("");
					R0540cell10.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column L
				Cell R0540cell11 = row.createCell(11);
				if (record1.getR0540_type_of_security() != null) {
					R0540cell11.setCellValue(record1.getR0540_type_of_security().doubleValue());
					R0540cell11.setCellStyle(numberStyle);
				} else {
					R0540cell11.setCellValue("");
					R0540cell11.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column M
				Cell R0540cell12 = row.createCell(12);
				if (record1.getR0540_discounted_collateral_value() != null) {
					R0540cell12.setCellValue(record1.getR0540_discounted_collateral_value().doubleValue());
					R0540cell12.setCellStyle(numberStyle);
				} else {
					R0540cell12.setCellValue("");
					R0540cell12.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column N
				Cell R0540cell13 = row.createCell(13);
				if (record1.getR0540_validated_discounted_cashflows() != null) {
					R0540cell13.setCellValue(record1.getR0540_validated_discounted_cashflows().doubleValue());
					R0540cell13.setCellStyle(numberStyle);
				} else {
					R0540cell13.setCellValue("");
					R0540cell13.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column O
				Cell R0540cell14 = row.createCell(14);
				if (record1.getR0540_pd() != null) {
					R0540cell14.setCellValue(record1.getR0540_pd().doubleValue());
					R0540cell14.setCellStyle(numberStyle);
				} else {
					R0540cell14.setCellValue("");
					R0540cell14.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column P
				Cell R0540cell15 = row.createCell(15);
				if (record1.getR0540_lgd() != null) {
					R0540cell15.setCellValue(record1.getR0540_lgd().doubleValue());
					R0540cell15.setCellStyle(numberStyle);
				} else {
					R0540cell15.setCellValue("");
					R0540cell15.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column Q
				Cell R0540cell16 = row.createCell(16);
				if (record1.getR0540_provisions_charged_pnl() != null) {
					R0540cell16.setCellValue(record1.getR0540_provisions_charged_pnl().doubleValue());
					R0540cell16.setCellStyle(numberStyle);
				} else {
					R0540cell16.setCellValue("");
					R0540cell16.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column R
				Cell R0540cell17 = row.createCell(17);
				if (record1.getR0540_legacy_interest_profit_suspense() != null) {
					R0540cell17.setCellValue(record1.getR0540_legacy_interest_profit_suspense().doubleValue());
					R0540cell17.setCellStyle(numberStyle);
				} else {
					R0540cell17.setCellValue("");
					R0540cell17.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column S
				Cell R0540cell18 = row.createCell(18);
				if (record1.getR0540_legal_case_yn() != null && !record1.getR0540_legal_case_yn().isEmpty()) {
					R0540cell18.setCellValue(record1.getR0540_legal_case_yn());
					R0540cell18.setCellStyle(textStyle);
				} else {
					R0540cell18.setCellValue("");
					R0540cell18.setCellStyle(textStyle);
				}

				/// ROW62
				//// Column T
				Cell R0540cell19 = row.createCell(19);
				if (record1.getR0540_remarks_if_any() != null && !record1.getR0540_remarks_if_any().isEmpty()) {
					R0540cell19.setCellValue(record1.getR0540_remarks_if_any());
					R0540cell19.setCellStyle(textStyle);
				} else {
					R0540cell19.setCellValue("");
					R0540cell19.setCellStyle(textStyle);
				}

				/// ROW63
				row = sheet.getRow(62);
				//// Column D
				Cell R0550cell3 = row.createCell(3);
				if (record1.getR0550_borrower_name() != null && !record1.getR0550_borrower_name().isEmpty()) {
					R0550cell3.setCellValue(record1.getR0550_borrower_name());
					R0550cell3.setCellStyle(textStyle);
				} else {
					R0550cell3.setCellValue("");
					R0550cell3.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column E
				Cell R0550cell4 = row.createCell(4);
				if (record1.getR0550_group_name_if_applicable() != null
						&& !record1.getR0550_group_name_if_applicable().isEmpty()) {
					R0550cell4.setCellValue(record1.getR0550_group_name_if_applicable());
					R0550cell4.setCellStyle(textStyle);
				} else {
					R0550cell4.setCellValue("");
					R0550cell4.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column F
				Cell R0550cell5 = row.createCell(5);
				if (record1.getR0550_cin() != null && !record1.getR0550_cin().isEmpty()) {
					R0550cell5.setCellValue(record1.getR0550_cin());
					R0550cell5.setCellStyle(textStyle);
				} else {
					R0550cell5.setCellValue("");
					R0550cell5.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column G
				Cell R0550cell6 = row.createCell(6);
				if (record1.getR0550_domicile_country() != null
						&& !record1.getR0550_domicile_country().isEmpty()) {
					R0550cell6.setCellValue(record1.getR0550_domicile_country());
					R0550cell6.setCellStyle(textStyle);
				} else {
					R0550cell6.setCellValue("");
					R0550cell6.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column H
				Cell R0550cell7 = row.createCell(7);
				if (record1.getR0550_funded_outstanding_amount() != null) {
					R0550cell7.setCellValue(record1.getR0550_funded_outstanding_amount().doubleValue());
					R0550cell7.setCellStyle(numberStyle);
				} else {
					R0550cell7.setCellValue("");
					R0550cell7.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column I
				Cell R0550cell8 = row.createCell(8);
				if (record1.getR0550_ccf_unfunded_outstanding_amount() != null) {
					R0550cell8.setCellValue(record1.getR0550_ccf_unfunded_outstanding_amount().doubleValue());
					R0550cell8.setCellStyle(numberStyle);
				} else {
					R0550cell8.setCellValue("");
					R0550cell8.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column J
				Cell R0550cell9 = row.createCell(9);
				if (record1.getR0550_secured_portion_exposure() != null) {
					R0550cell9.setCellValue(record1.getR0550_secured_portion_exposure().doubleValue());
					R0550cell9.setCellStyle(numberStyle);
				} else {
					R0550cell9.setCellValue("");
					R0550cell9.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column K
				Cell R0550cell10 = row.createCell(10);
				if (record1.getR0550_post_collateral_haircut() != null) {
					R0550cell10.setCellValue(record1.getR0550_post_collateral_haircut().doubleValue());
					R0550cell10.setCellStyle(numberStyle);
				} else {
					R0550cell10.setCellValue("");
					R0550cell10.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column L
				Cell R0550cell11 = row.createCell(11);
				if (record1.getR0550_type_of_security() != null) {
					R0550cell11.setCellValue(record1.getR0550_type_of_security().doubleValue());
					R0550cell11.setCellStyle(numberStyle);
				} else {
					R0550cell11.setCellValue("");
					R0550cell11.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column M
				Cell R0550cell12 = row.createCell(12);
				if (record1.getR0550_discounted_collateral_value() != null) {
					R0550cell12.setCellValue(record1.getR0550_discounted_collateral_value().doubleValue());
					R0550cell12.setCellStyle(numberStyle);
				} else {
					R0550cell12.setCellValue("");
					R0550cell12.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column N
				Cell R0550cell13 = row.createCell(13);
				if (record1.getR0550_validated_discounted_cashflows() != null) {
					R0550cell13.setCellValue(record1.getR0550_validated_discounted_cashflows().doubleValue());
					R0550cell13.setCellStyle(numberStyle);
				} else {
					R0550cell13.setCellValue("");
					R0550cell13.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column O
				Cell R0550cell14 = row.createCell(14);
				if (record1.getR0550_pd() != null) {
					R0550cell14.setCellValue(record1.getR0550_pd().doubleValue());
					R0550cell14.setCellStyle(numberStyle);
				} else {
					R0550cell14.setCellValue("");
					R0550cell14.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column P
				Cell R0550cell15 = row.createCell(15);
				if (record1.getR0550_lgd() != null) {
					R0550cell15.setCellValue(record1.getR0550_lgd().doubleValue());
					R0550cell15.setCellStyle(numberStyle);
				} else {
					R0550cell15.setCellValue("");
					R0550cell15.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column Q
				Cell R0550cell16 = row.createCell(16);
				if (record1.getR0550_provisions_charged_pnl() != null) {
					R0550cell16.setCellValue(record1.getR0550_provisions_charged_pnl().doubleValue());
					R0550cell16.setCellStyle(numberStyle);
				} else {
					R0550cell16.setCellValue("");
					R0550cell16.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column R
				Cell R0550cell17 = row.createCell(17);
				if (record1.getR0550_legacy_interest_profit_suspense() != null) {
					R0550cell17.setCellValue(record1.getR0550_legacy_interest_profit_suspense().doubleValue());
					R0550cell17.setCellStyle(numberStyle);
				} else {
					R0550cell17.setCellValue("");
					R0550cell17.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column S
				Cell R0550cell18 = row.createCell(18);
				if (record1.getR0550_legal_case_yn() != null && !record1.getR0550_legal_case_yn().isEmpty()) {
					R0550cell18.setCellValue(record1.getR0550_legal_case_yn());
					R0550cell18.setCellStyle(textStyle);
				} else {
					R0550cell18.setCellValue("");
					R0550cell18.setCellStyle(textStyle);
				}

				/// ROW63
				//// Column T
				Cell R0550cell19 = row.createCell(19);
				if (record1.getR0550_remarks_if_any() != null && !record1.getR0550_remarks_if_any().isEmpty()) {
					R0550cell19.setCellValue(record1.getR0550_remarks_if_any());
					R0550cell19.setCellStyle(textStyle);
				} else {
					R0550cell19.setCellValue("");
					R0550cell19.setCellStyle(textStyle);
				}

				/// ROW64
				row = sheet.getRow(63);
				//// Column D
				Cell R0560cell3 = row.createCell(3);
				if (record1.getR0560_borrower_name() != null && !record1.getR0560_borrower_name().isEmpty()) {
					R0560cell3.setCellValue(record1.getR0560_borrower_name());
					R0560cell3.setCellStyle(textStyle);
				} else {
					R0560cell3.setCellValue("");
					R0560cell3.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column E
				Cell R0560cell4 = row.createCell(4);
				if (record1.getR0560_group_name_if_applicable() != null
						&& !record1.getR0560_group_name_if_applicable().isEmpty()) {
					R0560cell4.setCellValue(record1.getR0560_group_name_if_applicable());
					R0560cell4.setCellStyle(textStyle);
				} else {
					R0560cell4.setCellValue("");
					R0560cell4.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column F
				Cell R0560cell5 = row.createCell(5);
				if (record1.getR0560_cin() != null && !record1.getR0560_cin().isEmpty()) {
					R0560cell5.setCellValue(record1.getR0560_cin());
					R0560cell5.setCellStyle(textStyle);
				} else {
					R0560cell5.setCellValue("");
					R0560cell5.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column G
				Cell R0560cell6 = row.createCell(6);
				if (record1.getR0560_domicile_country() != null
						&& !record1.getR0560_domicile_country().isEmpty()) {
					R0560cell6.setCellValue(record1.getR0560_domicile_country());
					R0560cell6.setCellStyle(textStyle);
				} else {
					R0560cell6.setCellValue("");
					R0560cell6.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column H
				Cell R0560cell7 = row.createCell(7);
				if (record1.getR0560_funded_outstanding_amount() != null) {
					R0560cell7.setCellValue(record1.getR0560_funded_outstanding_amount().doubleValue());
					R0560cell7.setCellStyle(numberStyle);
				} else {
					R0560cell7.setCellValue("");
					R0560cell7.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column I
				Cell R0560cell8 = row.createCell(8);
				if (record1.getR0560_ccf_unfunded_outstanding_amount() != null) {
					R0560cell8.setCellValue(record1.getR0560_ccf_unfunded_outstanding_amount().doubleValue());
					R0560cell8.setCellStyle(numberStyle);
				} else {
					R0560cell8.setCellValue("");
					R0560cell8.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column J
				Cell R0560cell9 = row.createCell(9);
				if (record1.getR0560_secured_portion_exposure() != null) {
					R0560cell9.setCellValue(record1.getR0560_secured_portion_exposure().doubleValue());
					R0560cell9.setCellStyle(numberStyle);
				} else {
					R0560cell9.setCellValue("");
					R0560cell9.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column K
				Cell R0560cell10 = row.createCell(10);
				if (record1.getR0560_post_collateral_haircut() != null) {
					R0560cell10.setCellValue(record1.getR0560_post_collateral_haircut().doubleValue());
					R0560cell10.setCellStyle(numberStyle);
				} else {
					R0560cell10.setCellValue("");
					R0560cell10.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column L
				Cell R0560cell11 = row.createCell(11);
				if (record1.getR0560_type_of_security() != null) {
					R0560cell11.setCellValue(record1.getR0560_type_of_security().doubleValue());
					R0560cell11.setCellStyle(numberStyle);
				} else {
					R0560cell11.setCellValue("");
					R0560cell11.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column M
				Cell R0560cell12 = row.createCell(12);
				if (record1.getR0560_discounted_collateral_value() != null) {
					R0560cell12.setCellValue(record1.getR0560_discounted_collateral_value().doubleValue());
					R0560cell12.setCellStyle(numberStyle);
				} else {
					R0560cell12.setCellValue("");
					R0560cell12.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column N
				Cell R0560cell13 = row.createCell(13);
				if (record1.getR0560_validated_discounted_cashflows() != null) {
					R0560cell13.setCellValue(record1.getR0560_validated_discounted_cashflows().doubleValue());
					R0560cell13.setCellStyle(numberStyle);
				} else {
					R0560cell13.setCellValue("");
					R0560cell13.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column O
				Cell R0560cell14 = row.createCell(14);
				if (record1.getR0560_pd() != null) {
					R0560cell14.setCellValue(record1.getR0560_pd().doubleValue());
					R0560cell14.setCellStyle(numberStyle);
				} else {
					R0560cell14.setCellValue("");
					R0560cell14.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column P
				Cell R0560cell15 = row.createCell(15);
				if (record1.getR0560_lgd() != null) {
					R0560cell15.setCellValue(record1.getR0560_lgd().doubleValue());
					R0560cell15.setCellStyle(numberStyle);
				} else {
					R0560cell15.setCellValue("");
					R0560cell15.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column Q
				Cell R0560cell16 = row.createCell(16);
				if (record1.getR0560_provisions_charged_pnl() != null) {
					R0560cell16.setCellValue(record1.getR0560_provisions_charged_pnl().doubleValue());
					R0560cell16.setCellStyle(numberStyle);
				} else {
					R0560cell16.setCellValue("");
					R0560cell16.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column R
				Cell R0560cell17 = row.createCell(17);
				if (record1.getR0560_legacy_interest_profit_suspense() != null) {
					R0560cell17.setCellValue(record1.getR0560_legacy_interest_profit_suspense().doubleValue());
					R0560cell17.setCellStyle(numberStyle);
				} else {
					R0560cell17.setCellValue("");
					R0560cell17.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column S
				Cell R0560cell18 = row.createCell(18);
				if (record1.getR0560_legal_case_yn() != null && !record1.getR0560_legal_case_yn().isEmpty()) {
					R0560cell18.setCellValue(record1.getR0560_legal_case_yn());
					R0560cell18.setCellStyle(textStyle);
				} else {
					R0560cell18.setCellValue("");
					R0560cell18.setCellStyle(textStyle);
				}

				/// ROW64
				//// Column T
				Cell R0560cell19 = row.createCell(19);
				if (record1.getR0560_remarks_if_any() != null && !record1.getR0560_remarks_if_any().isEmpty()) {
					R0560cell19.setCellValue(record1.getR0560_remarks_if_any());
					R0560cell19.setCellStyle(textStyle);
				} else {
					R0560cell19.setCellValue("");
					R0560cell19.setCellStyle(textStyle);
				}

				/// ROW65
				row = sheet.getRow(64);
				//// Column D
				Cell R0570cell3 = row.createCell(3);
				if (record1.getR0570_borrower_name() != null && !record1.getR0570_borrower_name().isEmpty()) {
					R0570cell3.setCellValue(record1.getR0570_borrower_name());
					R0570cell3.setCellStyle(textStyle);
				} else {
					R0570cell3.setCellValue("");
					R0570cell3.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column E
				Cell R0570cell4 = row.createCell(4);
				if (record1.getR0570_group_name_if_applicable() != null
						&& !record1.getR0570_group_name_if_applicable().isEmpty()) {
					R0570cell4.setCellValue(record1.getR0570_group_name_if_applicable());
					R0570cell4.setCellStyle(textStyle);
				} else {
					R0570cell4.setCellValue("");
					R0570cell4.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column F
				Cell R0570cell5 = row.createCell(5);
				if (record1.getR0570_cin() != null && !record1.getR0570_cin().isEmpty()) {
					R0570cell5.setCellValue(record1.getR0570_cin());
					R0570cell5.setCellStyle(textStyle);
				} else {
					R0570cell5.setCellValue("");
					R0570cell5.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column G
				Cell R0570cell6 = row.createCell(6);
				if (record1.getR0570_domicile_country() != null
						&& !record1.getR0570_domicile_country().isEmpty()) {
					R0570cell6.setCellValue(record1.getR0570_domicile_country());
					R0570cell6.setCellStyle(textStyle);
				} else {
					R0570cell6.setCellValue("");
					R0570cell6.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column H
				Cell R0570cell7 = row.createCell(7);
				if (record1.getR0570_funded_outstanding_amount() != null) {
					R0570cell7.setCellValue(record1.getR0570_funded_outstanding_amount().doubleValue());
					R0570cell7.setCellStyle(numberStyle);
				} else {
					R0570cell7.setCellValue("");
					R0570cell7.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column I
				Cell R0570cell8 = row.createCell(8);
				if (record1.getR0570_ccf_unfunded_outstanding_amount() != null) {
					R0570cell8.setCellValue(record1.getR0570_ccf_unfunded_outstanding_amount().doubleValue());
					R0570cell8.setCellStyle(numberStyle);
				} else {
					R0570cell8.setCellValue("");
					R0570cell8.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column J
				Cell R0570cell9 = row.createCell(9);
				if (record1.getR0570_secured_portion_exposure() != null) {
					R0570cell9.setCellValue(record1.getR0570_secured_portion_exposure().doubleValue());
					R0570cell9.setCellStyle(numberStyle);
				} else {
					R0570cell9.setCellValue("");
					R0570cell9.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column K
				Cell R0570cell10 = row.createCell(10);
				if (record1.getR0570_post_collateral_haircut() != null) {
					R0570cell10.setCellValue(record1.getR0570_post_collateral_haircut().doubleValue());
					R0570cell10.setCellStyle(numberStyle);
				} else {
					R0570cell10.setCellValue("");
					R0570cell10.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column L
				Cell R0570cell11 = row.createCell(11);
				if (record1.getR0570_type_of_security() != null) {
					R0570cell11.setCellValue(record1.getR0570_type_of_security().doubleValue());
					R0570cell11.setCellStyle(numberStyle);
				} else {
					R0570cell11.setCellValue("");
					R0570cell11.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column M
				Cell R0570cell12 = row.createCell(12);
				if (record1.getR0570_discounted_collateral_value() != null) {
					R0570cell12.setCellValue(record1.getR0570_discounted_collateral_value().doubleValue());
					R0570cell12.setCellStyle(numberStyle);
				} else {
					R0570cell12.setCellValue("");
					R0570cell12.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column N
				Cell R0570cell13 = row.createCell(13);
				if (record1.getR0570_validated_discounted_cashflows() != null) {
					R0570cell13.setCellValue(record1.getR0570_validated_discounted_cashflows().doubleValue());
					R0570cell13.setCellStyle(numberStyle);
				} else {
					R0570cell13.setCellValue("");
					R0570cell13.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column O
				Cell R0570cell14 = row.createCell(14);
				if (record1.getR0570_pd() != null) {
					R0570cell14.setCellValue(record1.getR0570_pd().doubleValue());
					R0570cell14.setCellStyle(numberStyle);
				} else {
					R0570cell14.setCellValue("");
					R0570cell14.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column P
				Cell R0570cell15 = row.createCell(15);
				if (record1.getR0570_lgd() != null) {
					R0570cell15.setCellValue(record1.getR0570_lgd().doubleValue());
					R0570cell15.setCellStyle(numberStyle);
				} else {
					R0570cell15.setCellValue("");
					R0570cell15.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column Q
				Cell R0570cell16 = row.createCell(16);
				if (record1.getR0570_provisions_charged_pnl() != null) {
					R0570cell16.setCellValue(record1.getR0570_provisions_charged_pnl().doubleValue());
					R0570cell16.setCellStyle(numberStyle);
				} else {
					R0570cell16.setCellValue("");
					R0570cell16.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column R
				Cell R0570cell17 = row.createCell(17);
				if (record1.getR0570_legacy_interest_profit_suspense() != null) {
					R0570cell17.setCellValue(record1.getR0570_legacy_interest_profit_suspense().doubleValue());
					R0570cell17.setCellStyle(numberStyle);
				} else {
					R0570cell17.setCellValue("");
					R0570cell17.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column S
				Cell R0570cell18 = row.createCell(18);
				if (record1.getR0570_legal_case_yn() != null && !record1.getR0570_legal_case_yn().isEmpty()) {
					R0570cell18.setCellValue(record1.getR0570_legal_case_yn());
					R0570cell18.setCellStyle(textStyle);
				} else {
					R0570cell18.setCellValue("");
					R0570cell18.setCellStyle(textStyle);
				}

				/// ROW65
				//// Column T
				Cell R0570cell19 = row.createCell(19);
				if (record1.getR0570_remarks_if_any() != null && !record1.getR0570_remarks_if_any().isEmpty()) {
					R0570cell19.setCellValue(record1.getR0570_remarks_if_any());
					R0570cell19.setCellStyle(textStyle);
				} else {
					R0570cell19.setCellValue("");
					R0570cell19.setCellStyle(textStyle);
				}

				/// ROW66
				row = sheet.getRow(65);
				//// Column D
				Cell R0580cell3 = row.createCell(3);
				if (record1.getR0580_borrower_name() != null && !record1.getR0580_borrower_name().isEmpty()) {
					R0580cell3.setCellValue(record1.getR0580_borrower_name());
					R0580cell3.setCellStyle(textStyle);
				} else {
					R0580cell3.setCellValue("");
					R0580cell3.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column E
				Cell R0580cell4 = row.createCell(4);
				if (record1.getR0580_group_name_if_applicable() != null
						&& !record1.getR0580_group_name_if_applicable().isEmpty()) {
					R0580cell4.setCellValue(record1.getR0580_group_name_if_applicable());
					R0580cell4.setCellStyle(textStyle);
				} else {
					R0580cell4.setCellValue("");
					R0580cell4.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column F
				Cell R0580cell5 = row.createCell(5);
				if (record1.getR0580_cin() != null && !record1.getR0580_cin().isEmpty()) {
					R0580cell5.setCellValue(record1.getR0580_cin());
					R0580cell5.setCellStyle(textStyle);
				} else {
					R0580cell5.setCellValue("");
					R0580cell5.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column G
				Cell R0580cell6 = row.createCell(6);
				if (record1.getR0580_domicile_country() != null
						&& !record1.getR0580_domicile_country().isEmpty()) {
					R0580cell6.setCellValue(record1.getR0580_domicile_country());
					R0580cell6.setCellStyle(textStyle);
				} else {
					R0580cell6.setCellValue("");
					R0580cell6.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column H
				Cell R0580cell7 = row.createCell(7);
				if (record1.getR0580_funded_outstanding_amount() != null) {
					R0580cell7.setCellValue(record1.getR0580_funded_outstanding_amount().doubleValue());
					R0580cell7.setCellStyle(numberStyle);
				} else {
					R0580cell7.setCellValue("");
					R0580cell7.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column I
				Cell R0580cell8 = row.createCell(8);
				if (record1.getR0580_ccf_unfunded_outstanding_amount() != null) {
					R0580cell8.setCellValue(record1.getR0580_ccf_unfunded_outstanding_amount().doubleValue());
					R0580cell8.setCellStyle(numberStyle);
				} else {
					R0580cell8.setCellValue("");
					R0580cell8.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column J
				Cell R0580cell9 = row.createCell(9);
				if (record1.getR0580_secured_portion_exposure() != null) {
					R0580cell9.setCellValue(record1.getR0580_secured_portion_exposure().doubleValue());
					R0580cell9.setCellStyle(numberStyle);
				} else {
					R0580cell9.setCellValue("");
					R0580cell9.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column K
				Cell R0580cell10 = row.createCell(10);
				if (record1.getR0580_post_collateral_haircut() != null) {
					R0580cell10.setCellValue(record1.getR0580_post_collateral_haircut().doubleValue());
					R0580cell10.setCellStyle(numberStyle);
				} else {
					R0580cell10.setCellValue("");
					R0580cell10.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column L
				Cell R0580cell11 = row.createCell(11);
				if (record1.getR0580_type_of_security() != null) {
					R0580cell11.setCellValue(record1.getR0580_type_of_security().doubleValue());
					R0580cell11.setCellStyle(numberStyle);
				} else {
					R0580cell11.setCellValue("");
					R0580cell11.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column M
				Cell R0580cell12 = row.createCell(12);
				if (record1.getR0580_discounted_collateral_value() != null) {
					R0580cell12.setCellValue(record1.getR0580_discounted_collateral_value().doubleValue());
					R0580cell12.setCellStyle(numberStyle);
				} else {
					R0580cell12.setCellValue("");
					R0580cell12.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column N
				Cell R0580cell13 = row.createCell(13);
				if (record1.getR0580_validated_discounted_cashflows() != null) {
					R0580cell13.setCellValue(record1.getR0580_validated_discounted_cashflows().doubleValue());
					R0580cell13.setCellStyle(numberStyle);
				} else {
					R0580cell13.setCellValue("");
					R0580cell13.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column O
				Cell R0580cell14 = row.createCell(14);
				if (record1.getR0580_pd() != null) {
					R0580cell14.setCellValue(record1.getR0580_pd().doubleValue());
					R0580cell14.setCellStyle(numberStyle);
				} else {
					R0580cell14.setCellValue("");
					R0580cell14.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column P
				Cell R0580cell15 = row.createCell(15);
				if (record1.getR0580_lgd() != null) {
					R0580cell15.setCellValue(record1.getR0580_lgd().doubleValue());
					R0580cell15.setCellStyle(numberStyle);
				} else {
					R0580cell15.setCellValue("");
					R0580cell15.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column Q
				Cell R0580cell16 = row.createCell(16);
				if (record1.getR0580_provisions_charged_pnl() != null) {
					R0580cell16.setCellValue(record1.getR0580_provisions_charged_pnl().doubleValue());
					R0580cell16.setCellStyle(numberStyle);
				} else {
					R0580cell16.setCellValue("");
					R0580cell16.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column R
				Cell R0580cell17 = row.createCell(17);
				if (record1.getR0580_legacy_interest_profit_suspense() != null) {
					R0580cell17.setCellValue(record1.getR0580_legacy_interest_profit_suspense().doubleValue());
					R0580cell17.setCellStyle(numberStyle);
				} else {
					R0580cell17.setCellValue("");
					R0580cell17.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column S
				Cell R0580cell18 = row.createCell(18);
				if (record1.getR0580_legal_case_yn() != null && !record1.getR0580_legal_case_yn().isEmpty()) {
					R0580cell18.setCellValue(record1.getR0580_legal_case_yn());
					R0580cell18.setCellStyle(textStyle);
				} else {
					R0580cell18.setCellValue("");
					R0580cell18.setCellStyle(textStyle);
				}

				/// ROW66
				//// Column T
				Cell R0580cell19 = row.createCell(19);
				if (record1.getR0580_remarks_if_any() != null && !record1.getR0580_remarks_if_any().isEmpty()) {
					R0580cell19.setCellValue(record1.getR0580_remarks_if_any());
					R0580cell19.setCellStyle(textStyle);
				} else {
					R0580cell19.setCellValue("");
					R0580cell19.setCellStyle(textStyle);
				}

				/// ROW67
				row = sheet.getRow(66);
				//// Column D
				Cell R0590cell3 = row.createCell(3);
				if (record1.getR0590_borrower_name() != null && !record1.getR0590_borrower_name().isEmpty()) {
					R0590cell3.setCellValue(record1.getR0590_borrower_name());
					R0590cell3.setCellStyle(textStyle);
				} else {
					R0590cell3.setCellValue("");
					R0590cell3.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column E
				Cell R0590cell4 = row.createCell(4);
				if (record1.getR0590_group_name_if_applicable() != null
						&& !record1.getR0590_group_name_if_applicable().isEmpty()) {
					R0590cell4.setCellValue(record1.getR0590_group_name_if_applicable());
					R0590cell4.setCellStyle(textStyle);
				} else {
					R0590cell4.setCellValue("");
					R0590cell4.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column F
				Cell R0590cell5 = row.createCell(5);
				if (record1.getR0590_cin() != null && !record1.getR0590_cin().isEmpty()) {
					R0590cell5.setCellValue(record1.getR0590_cin());
					R0590cell5.setCellStyle(textStyle);
				} else {
					R0590cell5.setCellValue("");
					R0590cell5.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column G
				Cell R0590cell6 = row.createCell(6);
				if (record1.getR0590_domicile_country() != null
						&& !record1.getR0590_domicile_country().isEmpty()) {
					R0590cell6.setCellValue(record1.getR0590_domicile_country());
					R0590cell6.setCellStyle(textStyle);
				} else {
					R0590cell6.setCellValue("");
					R0590cell6.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column H
				Cell R0590cell7 = row.createCell(7);
				if (record1.getR0590_funded_outstanding_amount() != null) {
					R0590cell7.setCellValue(record1.getR0590_funded_outstanding_amount().doubleValue());
					R0590cell7.setCellStyle(numberStyle);
				} else {
					R0590cell7.setCellValue("");
					R0590cell7.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column I
				Cell R0590cell8 = row.createCell(8);
				if (record1.getR0590_ccf_unfunded_outstanding_amount() != null) {
					R0590cell8.setCellValue(record1.getR0590_ccf_unfunded_outstanding_amount().doubleValue());
					R0590cell8.setCellStyle(numberStyle);
				} else {
					R0590cell8.setCellValue("");
					R0590cell8.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column J
				Cell R0590cell9 = row.createCell(9);
				if (record1.getR0590_secured_portion_exposure() != null) {
					R0590cell9.setCellValue(record1.getR0590_secured_portion_exposure().doubleValue());
					R0590cell9.setCellStyle(numberStyle);
				} else {
					R0590cell9.setCellValue("");
					R0590cell9.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column K
				Cell R0590cell10 = row.createCell(10);
				if (record1.getR0590_post_collateral_haircut() != null) {
					R0590cell10.setCellValue(record1.getR0590_post_collateral_haircut().doubleValue());
					R0590cell10.setCellStyle(numberStyle);
				} else {
					R0590cell10.setCellValue("");
					R0590cell10.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column L
				Cell R0590cell11 = row.createCell(11);
				if (record1.getR0590_type_of_security() != null) {
					R0590cell11.setCellValue(record1.getR0590_type_of_security().doubleValue());
					R0590cell11.setCellStyle(numberStyle);
				} else {
					R0590cell11.setCellValue("");
					R0590cell11.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column M
				Cell R0590cell12 = row.createCell(12);
				if (record1.getR0590_discounted_collateral_value() != null) {
					R0590cell12.setCellValue(record1.getR0590_discounted_collateral_value().doubleValue());
					R0590cell12.setCellStyle(numberStyle);
				} else {
					R0590cell12.setCellValue("");
					R0590cell12.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column N
				Cell R0590cell13 = row.createCell(13);
				if (record1.getR0590_validated_discounted_cashflows() != null) {
					R0590cell13.setCellValue(record1.getR0590_validated_discounted_cashflows().doubleValue());
					R0590cell13.setCellStyle(numberStyle);
				} else {
					R0590cell13.setCellValue("");
					R0590cell13.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column O
				Cell R0590cell14 = row.createCell(14);
				if (record1.getR0590_pd() != null) {
					R0590cell14.setCellValue(record1.getR0590_pd().doubleValue());
					R0590cell14.setCellStyle(numberStyle);
				} else {
					R0590cell14.setCellValue("");
					R0590cell14.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column P
				Cell R0590cell15 = row.createCell(15);
				if (record1.getR0590_lgd() != null) {
					R0590cell15.setCellValue(record1.getR0590_lgd().doubleValue());
					R0590cell15.setCellStyle(numberStyle);
				} else {
					R0590cell15.setCellValue("");
					R0590cell15.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column Q
				Cell R0590cell16 = row.createCell(16);
				if (record1.getR0590_provisions_charged_pnl() != null) {
					R0590cell16.setCellValue(record1.getR0590_provisions_charged_pnl().doubleValue());
					R0590cell16.setCellStyle(numberStyle);
				} else {
					R0590cell16.setCellValue("");
					R0590cell16.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column R
				Cell R0590cell17 = row.createCell(17);
				if (record1.getR0590_legacy_interest_profit_suspense() != null) {
					R0590cell17.setCellValue(record1.getR0590_legacy_interest_profit_suspense().doubleValue());
					R0590cell17.setCellStyle(numberStyle);
				} else {
					R0590cell17.setCellValue("");
					R0590cell17.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column S
				Cell R0590cell18 = row.createCell(18);
				if (record1.getR0590_legal_case_yn() != null && !record1.getR0590_legal_case_yn().isEmpty()) {
					R0590cell18.setCellValue(record1.getR0590_legal_case_yn());
					R0590cell18.setCellStyle(textStyle);
				} else {
					R0590cell18.setCellValue("");
					R0590cell18.setCellStyle(textStyle);
				}

				/// ROW67
				//// Column T
				Cell R0590cell19 = row.createCell(19);
				if (record1.getR0590_remarks_if_any() != null && !record1.getR0590_remarks_if_any().isEmpty()) {
					R0590cell19.setCellValue(record1.getR0590_remarks_if_any());
					R0590cell19.setCellStyle(textStyle);
				} else {
					R0590cell19.setCellValue("");
					R0590cell19.setCellStyle(textStyle);
				}

				/// ROW68
				row = sheet.getRow(67);
				//// Column D
				Cell R0600cell3 = row.createCell(3);
				if (record1.getR0600_borrower_name() != null && !record1.getR0600_borrower_name().isEmpty()) {
					R0600cell3.setCellValue(record1.getR0600_borrower_name());
					R0600cell3.setCellStyle(textStyle);
				} else {
					R0600cell3.setCellValue("");
					R0600cell3.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column E
				Cell R0600cell4 = row.createCell(4);
				if (record1.getR0600_group_name_if_applicable() != null
						&& !record1.getR0600_group_name_if_applicable().isEmpty()) {
					R0600cell4.setCellValue(record1.getR0600_group_name_if_applicable());
					R0600cell4.setCellStyle(textStyle);
				} else {
					R0600cell4.setCellValue("");
					R0600cell4.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column F
				Cell R0600cell5 = row.createCell(5);
				if (record1.getR0600_cin() != null && !record1.getR0600_cin().isEmpty()) {
					R0600cell5.setCellValue(record1.getR0600_cin());
					R0600cell5.setCellStyle(textStyle);
				} else {
					R0600cell5.setCellValue("");
					R0600cell5.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column G
				Cell R0600cell6 = row.createCell(6);
				if (record1.getR0600_domicile_country() != null
						&& !record1.getR0600_domicile_country().isEmpty()) {
					R0600cell6.setCellValue(record1.getR0600_domicile_country());
					R0600cell6.setCellStyle(textStyle);
				} else {
					R0600cell6.setCellValue("");
					R0600cell6.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column H
				Cell R0600cell7 = row.createCell(7);
				if (record1.getR0600_funded_outstanding_amount() != null) {
					R0600cell7.setCellValue(record1.getR0600_funded_outstanding_amount().doubleValue());
					R0600cell7.setCellStyle(numberStyle);
				} else {
					R0600cell7.setCellValue("");
					R0600cell7.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column I
				Cell R0600cell8 = row.createCell(8);
				if (record1.getR0600_ccf_unfunded_outstanding_amount() != null) {
					R0600cell8.setCellValue(record1.getR0600_ccf_unfunded_outstanding_amount().doubleValue());
					R0600cell8.setCellStyle(numberStyle);
				} else {
					R0600cell8.setCellValue("");
					R0600cell8.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column J
				Cell R0600cell9 = row.createCell(9);
				if (record1.getR0600_secured_portion_exposure() != null) {
					R0600cell9.setCellValue(record1.getR0600_secured_portion_exposure().doubleValue());
					R0600cell9.setCellStyle(numberStyle);
				} else {
					R0600cell9.setCellValue("");
					R0600cell9.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column K
				Cell R0600cell10 = row.createCell(10);
				if (record1.getR0600_post_collateral_haircut() != null) {
					R0600cell10.setCellValue(record1.getR0600_post_collateral_haircut().doubleValue());
					R0600cell10.setCellStyle(numberStyle);
				} else {
					R0600cell10.setCellValue("");
					R0600cell10.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column L
				Cell R0600cell11 = row.createCell(11);
				if (record1.getR0600_type_of_security() != null) {
					R0600cell11.setCellValue(record1.getR0600_type_of_security().doubleValue());
					R0600cell11.setCellStyle(numberStyle);
				} else {
					R0600cell11.setCellValue("");
					R0600cell11.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column M
				Cell R0600cell12 = row.createCell(12);
				if (record1.getR0600_discounted_collateral_value() != null) {
					R0600cell12.setCellValue(record1.getR0600_discounted_collateral_value().doubleValue());
					R0600cell12.setCellStyle(numberStyle);
				} else {
					R0600cell12.setCellValue("");
					R0600cell12.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column N
				Cell R0600cell13 = row.createCell(13);
				if (record1.getR0600_validated_discounted_cashflows() != null) {
					R0600cell13.setCellValue(record1.getR0600_validated_discounted_cashflows().doubleValue());
					R0600cell13.setCellStyle(numberStyle);
				} else {
					R0600cell13.setCellValue("");
					R0600cell13.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column O
				Cell R0600cell14 = row.createCell(14);
				if (record1.getR0600_pd() != null) {
					R0600cell14.setCellValue(record1.getR0600_pd().doubleValue());
					R0600cell14.setCellStyle(numberStyle);
				} else {
					R0600cell14.setCellValue("");
					R0600cell14.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column P
				Cell R0600cell15 = row.createCell(15);
				if (record1.getR0600_lgd() != null) {
					R0600cell15.setCellValue(record1.getR0600_lgd().doubleValue());
					R0600cell15.setCellStyle(numberStyle);
				} else {
					R0600cell15.setCellValue("");
					R0600cell15.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column Q
				Cell R0600cell16 = row.createCell(16);
				if (record1.getR0600_provisions_charged_pnl() != null) {
					R0600cell16.setCellValue(record1.getR0600_provisions_charged_pnl().doubleValue());
					R0600cell16.setCellStyle(numberStyle);
				} else {
					R0600cell16.setCellValue("");
					R0600cell16.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column R
				Cell R0600cell17 = row.createCell(17);
				if (record1.getR0600_legacy_interest_profit_suspense() != null) {
					R0600cell17.setCellValue(record1.getR0600_legacy_interest_profit_suspense().doubleValue());
					R0600cell17.setCellStyle(numberStyle);
				} else {
					R0600cell17.setCellValue("");
					R0600cell17.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column S
				Cell R0600cell18 = row.createCell(18);
				if (record1.getR0600_legal_case_yn() != null && !record1.getR0600_legal_case_yn().isEmpty()) {
					R0600cell18.setCellValue(record1.getR0600_legal_case_yn());
					R0600cell18.setCellStyle(textStyle);
				} else {
					R0600cell18.setCellValue("");
					R0600cell18.setCellStyle(textStyle);
				}

				/// ROW68
				//// Column T
				Cell R0600cell19 = row.createCell(19);
				if (record1.getR0600_remarks_if_any() != null && !record1.getR0600_remarks_if_any().isEmpty()) {
					R0600cell19.setCellValue(record1.getR0600_remarks_if_any());
					R0600cell19.setCellStyle(textStyle);
				} else {
					R0600cell19.setCellValue("");
					R0600cell19.setCellStyle(textStyle);
				}

				/// ROW69
				row = sheet.getRow(68);
				//// Column D
				Cell R0610cell3 = row.createCell(3);
				if (record1.getR0610_borrower_name() != null && !record1.getR0610_borrower_name().isEmpty()) {
					R0610cell3.setCellValue(record1.getR0610_borrower_name());
					R0610cell3.setCellStyle(textStyle);
				} else {
					R0610cell3.setCellValue("");
					R0610cell3.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column E
				Cell R0610cell4 = row.createCell(4);
				if (record1.getR0610_group_name_if_applicable() != null
						&& !record1.getR0610_group_name_if_applicable().isEmpty()) {
					R0610cell4.setCellValue(record1.getR0610_group_name_if_applicable());
					R0610cell4.setCellStyle(textStyle);
				} else {
					R0610cell4.setCellValue("");
					R0610cell4.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column F
				Cell R0610cell5 = row.createCell(5);
				if (record1.getR0610_cin() != null && !record1.getR0610_cin().isEmpty()) {
					R0610cell5.setCellValue(record1.getR0610_cin());
					R0610cell5.setCellStyle(textStyle);
				} else {
					R0610cell5.setCellValue("");
					R0610cell5.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column G
				Cell R0610cell6 = row.createCell(6);
				if (record1.getR0610_domicile_country() != null
						&& !record1.getR0610_domicile_country().isEmpty()) {
					R0610cell6.setCellValue(record1.getR0610_domicile_country());
					R0610cell6.setCellStyle(textStyle);
				} else {
					R0610cell6.setCellValue("");
					R0610cell6.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column H
				Cell R0610cell7 = row.createCell(7);
				if (record1.getR0610_funded_outstanding_amount() != null) {
					R0610cell7.setCellValue(record1.getR0610_funded_outstanding_amount().doubleValue());
					R0610cell7.setCellStyle(numberStyle);
				} else {
					R0610cell7.setCellValue("");
					R0610cell7.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column I
				Cell R0610cell8 = row.createCell(8);
				if (record1.getR0610_ccf_unfunded_outstanding_amount() != null) {
					R0610cell8.setCellValue(record1.getR0610_ccf_unfunded_outstanding_amount().doubleValue());
					R0610cell8.setCellStyle(numberStyle);
				} else {
					R0610cell8.setCellValue("");
					R0610cell8.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column J
				Cell R0610cell9 = row.createCell(9);
				if (record1.getR0610_secured_portion_exposure() != null) {
					R0610cell9.setCellValue(record1.getR0610_secured_portion_exposure().doubleValue());
					R0610cell9.setCellStyle(numberStyle);
				} else {
					R0610cell9.setCellValue("");
					R0610cell9.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column K
				Cell R0610cell10 = row.createCell(10);
				if (record1.getR0610_post_collateral_haircut() != null) {
					R0610cell10.setCellValue(record1.getR0610_post_collateral_haircut().doubleValue());
					R0610cell10.setCellStyle(numberStyle);
				} else {
					R0610cell10.setCellValue("");
					R0610cell10.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column L
				Cell R0610cell11 = row.createCell(11);
				if (record1.getR0610_type_of_security() != null) {
					R0610cell11.setCellValue(record1.getR0610_type_of_security().doubleValue());
					R0610cell11.setCellStyle(numberStyle);
				} else {
					R0610cell11.setCellValue("");
					R0610cell11.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column M
				Cell R0610cell12 = row.createCell(12);
				if (record1.getR0610_discounted_collateral_value() != null) {
					R0610cell12.setCellValue(record1.getR0610_discounted_collateral_value().doubleValue());
					R0610cell12.setCellStyle(numberStyle);
				} else {
					R0610cell12.setCellValue("");
					R0610cell12.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column N
				Cell R0610cell13 = row.createCell(13);
				if (record1.getR0610_validated_discounted_cashflows() != null) {
					R0610cell13.setCellValue(record1.getR0610_validated_discounted_cashflows().doubleValue());
					R0610cell13.setCellStyle(numberStyle);
				} else {
					R0610cell13.setCellValue("");
					R0610cell13.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column O
				Cell R0610cell14 = row.createCell(14);
				if (record1.getR0610_pd() != null) {
					R0610cell14.setCellValue(record1.getR0610_pd().doubleValue());
					R0610cell14.setCellStyle(numberStyle);
				} else {
					R0610cell14.setCellValue("");
					R0610cell14.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column P
				Cell R0610cell15 = row.createCell(15);
				if (record1.getR0610_lgd() != null) {
					R0610cell15.setCellValue(record1.getR0610_lgd().doubleValue());
					R0610cell15.setCellStyle(numberStyle);
				} else {
					R0610cell15.setCellValue("");
					R0610cell15.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column Q
				Cell R0610cell16 = row.createCell(16);
				if (record1.getR0610_provisions_charged_pnl() != null) {
					R0610cell16.setCellValue(record1.getR0610_provisions_charged_pnl().doubleValue());
					R0610cell16.setCellStyle(numberStyle);
				} else {
					R0610cell16.setCellValue("");
					R0610cell16.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column R
				Cell R0610cell17 = row.createCell(17);
				if (record1.getR0610_legacy_interest_profit_suspense() != null) {
					R0610cell17.setCellValue(record1.getR0610_legacy_interest_profit_suspense().doubleValue());
					R0610cell17.setCellStyle(numberStyle);
				} else {
					R0610cell17.setCellValue("");
					R0610cell17.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column S
				Cell R0610cell18 = row.createCell(18);
				if (record1.getR0610_legal_case_yn() != null && !record1.getR0610_legal_case_yn().isEmpty()) {
					R0610cell18.setCellValue(record1.getR0610_legal_case_yn());
					R0610cell18.setCellStyle(textStyle);
				} else {
					R0610cell18.setCellValue("");
					R0610cell18.setCellStyle(textStyle);
				}

				/// ROW69
				//// Column T
				Cell R0610cell19 = row.createCell(19);
				if (record1.getR0610_remarks_if_any() != null && !record1.getR0610_remarks_if_any().isEmpty()) {
					R0610cell19.setCellValue(record1.getR0610_remarks_if_any());
					R0610cell19.setCellStyle(textStyle);
				} else {
					R0610cell19.setCellValue("");
					R0610cell19.setCellStyle(textStyle);
				}

				/// ROW70
				row = sheet.getRow(69);
				//// Column D
				Cell R0620cell3 = row.createCell(3);
				if (record1.getR0620_borrower_name() != null && !record1.getR0620_borrower_name().isEmpty()) {
					R0620cell3.setCellValue(record1.getR0620_borrower_name());
					R0620cell3.setCellStyle(textStyle);
				} else {
					R0620cell3.setCellValue("");
					R0620cell3.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column E
				Cell R0620cell4 = row.createCell(4);
				if (record1.getR0620_group_name_if_applicable() != null
						&& !record1.getR0620_group_name_if_applicable().isEmpty()) {
					R0620cell4.setCellValue(record1.getR0620_group_name_if_applicable());
					R0620cell4.setCellStyle(textStyle);
				} else {
					R0620cell4.setCellValue("");
					R0620cell4.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column F
				Cell R0620cell5 = row.createCell(5);
				if (record1.getR0620_cin() != null && !record1.getR0620_cin().isEmpty()) {
					R0620cell5.setCellValue(record1.getR0620_cin());
					R0620cell5.setCellStyle(textStyle);
				} else {
					R0620cell5.setCellValue("");
					R0620cell5.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column G
				Cell R0620cell6 = row.createCell(6);
				if (record1.getR0620_domicile_country() != null
						&& !record1.getR0620_domicile_country().isEmpty()) {
					R0620cell6.setCellValue(record1.getR0620_domicile_country());
					R0620cell6.setCellStyle(textStyle);
				} else {
					R0620cell6.setCellValue("");
					R0620cell6.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column H
				Cell R0620cell7 = row.createCell(7);
				if (record1.getR0620_funded_outstanding_amount() != null) {
					R0620cell7.setCellValue(record1.getR0620_funded_outstanding_amount().doubleValue());
					R0620cell7.setCellStyle(numberStyle);
				} else {
					R0620cell7.setCellValue("");
					R0620cell7.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column I
				Cell R0620cell8 = row.createCell(8);
				if (record1.getR0620_ccf_unfunded_outstanding_amount() != null) {
					R0620cell8.setCellValue(record1.getR0620_ccf_unfunded_outstanding_amount().doubleValue());
					R0620cell8.setCellStyle(numberStyle);
				} else {
					R0620cell8.setCellValue("");
					R0620cell8.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column J
				Cell R0620cell9 = row.createCell(9);
				if (record1.getR0620_secured_portion_exposure() != null) {
					R0620cell9.setCellValue(record1.getR0620_secured_portion_exposure().doubleValue());
					R0620cell9.setCellStyle(numberStyle);
				} else {
					R0620cell9.setCellValue("");
					R0620cell9.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column K
				Cell R0620cell10 = row.createCell(10);
				if (record1.getR0620_post_collateral_haircut() != null) {
					R0620cell10.setCellValue(record1.getR0620_post_collateral_haircut().doubleValue());
					R0620cell10.setCellStyle(numberStyle);
				} else {
					R0620cell10.setCellValue("");
					R0620cell10.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column L
				Cell R0620cell11 = row.createCell(11);
				if (record1.getR0620_type_of_security() != null) {
					R0620cell11.setCellValue(record1.getR0620_type_of_security().doubleValue());
					R0620cell11.setCellStyle(numberStyle);
				} else {
					R0620cell11.setCellValue("");
					R0620cell11.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column M
				Cell R0620cell12 = row.createCell(12);
				if (record1.getR0620_discounted_collateral_value() != null) {
					R0620cell12.setCellValue(record1.getR0620_discounted_collateral_value().doubleValue());
					R0620cell12.setCellStyle(numberStyle);
				} else {
					R0620cell12.setCellValue("");
					R0620cell12.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column N
				Cell R0620cell13 = row.createCell(13);
				if (record1.getR0620_validated_discounted_cashflows() != null) {
					R0620cell13.setCellValue(record1.getR0620_validated_discounted_cashflows().doubleValue());
					R0620cell13.setCellStyle(numberStyle);
				} else {
					R0620cell13.setCellValue("");
					R0620cell13.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column O
				Cell R0620cell14 = row.createCell(14);
				if (record1.getR0620_pd() != null) {
					R0620cell14.setCellValue(record1.getR0620_pd().doubleValue());
					R0620cell14.setCellStyle(numberStyle);
				} else {
					R0620cell14.setCellValue("");
					R0620cell14.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column P
				Cell R0620cell15 = row.createCell(15);
				if (record1.getR0620_lgd() != null) {
					R0620cell15.setCellValue(record1.getR0620_lgd().doubleValue());
					R0620cell15.setCellStyle(numberStyle);
				} else {
					R0620cell15.setCellValue("");
					R0620cell15.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column Q
				Cell R0620cell16 = row.createCell(16);
				if (record1.getR0620_provisions_charged_pnl() != null) {
					R0620cell16.setCellValue(record1.getR0620_provisions_charged_pnl().doubleValue());
					R0620cell16.setCellStyle(numberStyle);
				} else {
					R0620cell16.setCellValue("");
					R0620cell16.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column R
				Cell R0620cell17 = row.createCell(17);
				if (record1.getR0620_legacy_interest_profit_suspense() != null) {
					R0620cell17.setCellValue(record1.getR0620_legacy_interest_profit_suspense().doubleValue());
					R0620cell17.setCellStyle(numberStyle);
				} else {
					R0620cell17.setCellValue("");
					R0620cell17.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column S
				Cell R0620cell18 = row.createCell(18);
				if (record1.getR0620_legal_case_yn() != null && !record1.getR0620_legal_case_yn().isEmpty()) {
					R0620cell18.setCellValue(record1.getR0620_legal_case_yn());
					R0620cell18.setCellStyle(textStyle);
				} else {
					R0620cell18.setCellValue("");
					R0620cell18.setCellStyle(textStyle);
				}

				/// ROW70
				//// Column T
				Cell R0620cell19 = row.createCell(19);
				if (record1.getR0620_remarks_if_any() != null && !record1.getR0620_remarks_if_any().isEmpty()) {
					R0620cell19.setCellValue(record1.getR0620_remarks_if_any());
					R0620cell19.setCellStyle(textStyle);
				} else {
					R0620cell19.setCellValue("");
					R0620cell19.setCellStyle(textStyle);
				}

				/// ROW71
				row = sheet.getRow(70);
				//// Column D
				Cell R0630cell3 = row.createCell(3);
				if (record1.getR0630_borrower_name() != null && !record1.getR0630_borrower_name().isEmpty()) {
					R0630cell3.setCellValue(record1.getR0630_borrower_name());
					R0630cell3.setCellStyle(textStyle);
				} else {
					R0630cell3.setCellValue("");
					R0630cell3.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column E
				Cell R0630cell4 = row.createCell(4);
				if (record1.getR0630_group_name_if_applicable() != null
						&& !record1.getR0630_group_name_if_applicable().isEmpty()) {
					R0630cell4.setCellValue(record1.getR0630_group_name_if_applicable());
					R0630cell4.setCellStyle(textStyle);
				} else {
					R0630cell4.setCellValue("");
					R0630cell4.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column F
				Cell R0630cell5 = row.createCell(5);
				if (record1.getR0630_cin() != null && !record1.getR0630_cin().isEmpty()) {
					R0630cell5.setCellValue(record1.getR0630_cin());
					R0630cell5.setCellStyle(textStyle);
				} else {
					R0630cell5.setCellValue("");
					R0630cell5.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column G
				Cell R0630cell6 = row.createCell(6);
				if (record1.getR0630_domicile_country() != null
						&& !record1.getR0630_domicile_country().isEmpty()) {
					R0630cell6.setCellValue(record1.getR0630_domicile_country());
					R0630cell6.setCellStyle(textStyle);
				} else {
					R0630cell6.setCellValue("");
					R0630cell6.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column H
				Cell R0630cell7 = row.createCell(7);
				if (record1.getR0630_funded_outstanding_amount() != null) {
					R0630cell7.setCellValue(record1.getR0630_funded_outstanding_amount().doubleValue());
					R0630cell7.setCellStyle(numberStyle);
				} else {
					R0630cell7.setCellValue("");
					R0630cell7.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column I
				Cell R0630cell8 = row.createCell(8);
				if (record1.getR0630_ccf_unfunded_outstanding_amount() != null) {
					R0630cell8.setCellValue(record1.getR0630_ccf_unfunded_outstanding_amount().doubleValue());
					R0630cell8.setCellStyle(numberStyle);
				} else {
					R0630cell8.setCellValue("");
					R0630cell8.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column J
				Cell R0630cell9 = row.createCell(9);
				if (record1.getR0630_secured_portion_exposure() != null) {
					R0630cell9.setCellValue(record1.getR0630_secured_portion_exposure().doubleValue());
					R0630cell9.setCellStyle(numberStyle);
				} else {
					R0630cell9.setCellValue("");
					R0630cell9.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column K
				Cell R0630cell10 = row.createCell(10);
				if (record1.getR0630_post_collateral_haircut() != null) {
					R0630cell10.setCellValue(record1.getR0630_post_collateral_haircut().doubleValue());
					R0630cell10.setCellStyle(numberStyle);
				} else {
					R0630cell10.setCellValue("");
					R0630cell10.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column L
				Cell R0630cell11 = row.createCell(11);
				if (record1.getR0630_type_of_security() != null) {
					R0630cell11.setCellValue(record1.getR0630_type_of_security().doubleValue());
					R0630cell11.setCellStyle(numberStyle);
				} else {
					R0630cell11.setCellValue("");
					R0630cell11.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column M
				Cell R0630cell12 = row.createCell(12);
				if (record1.getR0630_discounted_collateral_value() != null) {
					R0630cell12.setCellValue(record1.getR0630_discounted_collateral_value().doubleValue());
					R0630cell12.setCellStyle(numberStyle);
				} else {
					R0630cell12.setCellValue("");
					R0630cell12.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column N
				Cell R0630cell13 = row.createCell(13);
				if (record1.getR0630_validated_discounted_cashflows() != null) {
					R0630cell13.setCellValue(record1.getR0630_validated_discounted_cashflows().doubleValue());
					R0630cell13.setCellStyle(numberStyle);
				} else {
					R0630cell13.setCellValue("");
					R0630cell13.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column O
				Cell R0630cell14 = row.createCell(14);
				if (record1.getR0630_pd() != null) {
					R0630cell14.setCellValue(record1.getR0630_pd().doubleValue());
					R0630cell14.setCellStyle(numberStyle);
				} else {
					R0630cell14.setCellValue("");
					R0630cell14.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column P
				Cell R0630cell15 = row.createCell(15);
				if (record1.getR0630_lgd() != null) {
					R0630cell15.setCellValue(record1.getR0630_lgd().doubleValue());
					R0630cell15.setCellStyle(numberStyle);
				} else {
					R0630cell15.setCellValue("");
					R0630cell15.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column Q
				Cell R0630cell16 = row.createCell(16);
				if (record1.getR0630_provisions_charged_pnl() != null) {
					R0630cell16.setCellValue(record1.getR0630_provisions_charged_pnl().doubleValue());
					R0630cell16.setCellStyle(numberStyle);
				} else {
					R0630cell16.setCellValue("");
					R0630cell16.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column R
				Cell R0630cell17 = row.createCell(17);
				if (record1.getR0630_legacy_interest_profit_suspense() != null) {
					R0630cell17.setCellValue(record1.getR0630_legacy_interest_profit_suspense().doubleValue());
					R0630cell17.setCellStyle(numberStyle);
				} else {
					R0630cell17.setCellValue("");
					R0630cell17.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column S
				Cell R0630cell18 = row.createCell(18);
				if (record1.getR0630_legal_case_yn() != null && !record1.getR0630_legal_case_yn().isEmpty()) {
					R0630cell18.setCellValue(record1.getR0630_legal_case_yn());
					R0630cell18.setCellStyle(textStyle);
				} else {
					R0630cell18.setCellValue("");
					R0630cell18.setCellStyle(textStyle);
				}

				/// ROW71
				//// Column T
				Cell R0630cell19 = row.createCell(19);
				if (record1.getR0630_remarks_if_any() != null && !record1.getR0630_remarks_if_any().isEmpty()) {
					R0630cell19.setCellValue(record1.getR0630_remarks_if_any());
					R0630cell19.setCellStyle(textStyle);
				} else {
					R0630cell19.setCellValue("");
					R0630cell19.setCellStyle(textStyle);
				}

				/// ROW72
				row = sheet.getRow(71);
				//// Column D
				Cell R0640cell3 = row.createCell(3);
				if (record1.getR0640_borrower_name() != null && !record1.getR0640_borrower_name().isEmpty()) {
					R0640cell3.setCellValue(record1.getR0640_borrower_name());
					R0640cell3.setCellStyle(textStyle);
				} else {
					R0640cell3.setCellValue("");
					R0640cell3.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column E
				Cell R0640cell4 = row.createCell(4);
				if (record1.getR0640_group_name_if_applicable() != null
						&& !record1.getR0640_group_name_if_applicable().isEmpty()) {
					R0640cell4.setCellValue(record1.getR0640_group_name_if_applicable());
					R0640cell4.setCellStyle(textStyle);
				} else {
					R0640cell4.setCellValue("");
					R0640cell4.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column F
				Cell R0640cell5 = row.createCell(5);
				if (record1.getR0640_cin() != null && !record1.getR0640_cin().isEmpty()) {
					R0640cell5.setCellValue(record1.getR0640_cin());
					R0640cell5.setCellStyle(textStyle);
				} else {
					R0640cell5.setCellValue("");
					R0640cell5.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column G
				Cell R0640cell6 = row.createCell(6);
				if (record1.getR0640_domicile_country() != null
						&& !record1.getR0640_domicile_country().isEmpty()) {
					R0640cell6.setCellValue(record1.getR0640_domicile_country());
					R0640cell6.setCellStyle(textStyle);
				} else {
					R0640cell6.setCellValue("");
					R0640cell6.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column H
				Cell R0640cell7 = row.createCell(7);
				if (record1.getR0640_funded_outstanding_amount() != null) {
					R0640cell7.setCellValue(record1.getR0640_funded_outstanding_amount().doubleValue());
					R0640cell7.setCellStyle(numberStyle);
				} else {
					R0640cell7.setCellValue("");
					R0640cell7.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column I
				Cell R0640cell8 = row.createCell(8);
				if (record1.getR0640_ccf_unfunded_outstanding_amount() != null) {
					R0640cell8.setCellValue(record1.getR0640_ccf_unfunded_outstanding_amount().doubleValue());
					R0640cell8.setCellStyle(numberStyle);
				} else {
					R0640cell8.setCellValue("");
					R0640cell8.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column J
				Cell R0640cell9 = row.createCell(9);
				if (record1.getR0640_secured_portion_exposure() != null) {
					R0640cell9.setCellValue(record1.getR0640_secured_portion_exposure().doubleValue());
					R0640cell9.setCellStyle(numberStyle);
				} else {
					R0640cell9.setCellValue("");
					R0640cell9.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column K
				Cell R0640cell10 = row.createCell(10);
				if (record1.getR0640_post_collateral_haircut() != null) {
					R0640cell10.setCellValue(record1.getR0640_post_collateral_haircut().doubleValue());
					R0640cell10.setCellStyle(numberStyle);
				} else {
					R0640cell10.setCellValue("");
					R0640cell10.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column L
				Cell R0640cell11 = row.createCell(11);
				if (record1.getR0640_type_of_security() != null) {
					R0640cell11.setCellValue(record1.getR0640_type_of_security().doubleValue());
					R0640cell11.setCellStyle(numberStyle);
				} else {
					R0640cell11.setCellValue("");
					R0640cell11.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column M
				Cell R0640cell12 = row.createCell(12);
				if (record1.getR0640_discounted_collateral_value() != null) {
					R0640cell12.setCellValue(record1.getR0640_discounted_collateral_value().doubleValue());
					R0640cell12.setCellStyle(numberStyle);
				} else {
					R0640cell12.setCellValue("");
					R0640cell12.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column N
				Cell R0640cell13 = row.createCell(13);
				if (record1.getR0640_validated_discounted_cashflows() != null) {
					R0640cell13.setCellValue(record1.getR0640_validated_discounted_cashflows().doubleValue());
					R0640cell13.setCellStyle(numberStyle);
				} else {
					R0640cell13.setCellValue("");
					R0640cell13.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column O
				Cell R0640cell14 = row.createCell(14);
				if (record1.getR0640_pd() != null) {
					R0640cell14.setCellValue(record1.getR0640_pd().doubleValue());
					R0640cell14.setCellStyle(numberStyle);
				} else {
					R0640cell14.setCellValue("");
					R0640cell14.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column P
				Cell R0640cell15 = row.createCell(15);
				if (record1.getR0640_lgd() != null) {
					R0640cell15.setCellValue(record1.getR0640_lgd().doubleValue());
					R0640cell15.setCellStyle(numberStyle);
				} else {
					R0640cell15.setCellValue("");
					R0640cell15.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column Q
				Cell R0640cell16 = row.createCell(16);
				if (record1.getR0640_provisions_charged_pnl() != null) {
					R0640cell16.setCellValue(record1.getR0640_provisions_charged_pnl().doubleValue());
					R0640cell16.setCellStyle(numberStyle);
				} else {
					R0640cell16.setCellValue("");
					R0640cell16.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column R
				Cell R0640cell17 = row.createCell(17);
				if (record1.getR0640_legacy_interest_profit_suspense() != null) {
					R0640cell17.setCellValue(record1.getR0640_legacy_interest_profit_suspense().doubleValue());
					R0640cell17.setCellStyle(numberStyle);
				} else {
					R0640cell17.setCellValue("");
					R0640cell17.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column S
				Cell R0640cell18 = row.createCell(18);
				if (record1.getR0640_legal_case_yn() != null && !record1.getR0640_legal_case_yn().isEmpty()) {
					R0640cell18.setCellValue(record1.getR0640_legal_case_yn());
					R0640cell18.setCellStyle(textStyle);
				} else {
					R0640cell18.setCellValue("");
					R0640cell18.setCellStyle(textStyle);
				}

				/// ROW72
				//// Column T
				Cell R0640cell19 = row.createCell(19);
				if (record1.getR0640_remarks_if_any() != null && !record1.getR0640_remarks_if_any().isEmpty()) {
					R0640cell19.setCellValue(record1.getR0640_remarks_if_any());
					R0640cell19.setCellStyle(textStyle);
				} else {
					R0640cell19.setCellValue("");
					R0640cell19.setCellStyle(textStyle);
				}

				/// ROW73
				row = sheet.getRow(72);
				//// Column D
				Cell R0650cell3 = row.createCell(3);
				if (record1.getR0650_borrower_name() != null && !record1.getR0650_borrower_name().isEmpty()) {
					R0650cell3.setCellValue(record1.getR0650_borrower_name());
					R0650cell3.setCellStyle(textStyle);
				} else {
					R0650cell3.setCellValue("");
					R0650cell3.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column E
				Cell R0650cell4 = row.createCell(4);
				if (record1.getR0650_group_name_if_applicable() != null
						&& !record1.getR0650_group_name_if_applicable().isEmpty()) {
					R0650cell4.setCellValue(record1.getR0650_group_name_if_applicable());
					R0650cell4.setCellStyle(textStyle);
				} else {
					R0650cell4.setCellValue("");
					R0650cell4.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column F
				Cell R0650cell5 = row.createCell(5);
				if (record1.getR0650_cin() != null && !record1.getR0650_cin().isEmpty()) {
					R0650cell5.setCellValue(record1.getR0650_cin());
					R0650cell5.setCellStyle(textStyle);
				} else {
					R0650cell5.setCellValue("");
					R0650cell5.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column G
				Cell R0650cell6 = row.createCell(6);
				if (record1.getR0650_domicile_country() != null
						&& !record1.getR0650_domicile_country().isEmpty()) {
					R0650cell6.setCellValue(record1.getR0650_domicile_country());
					R0650cell6.setCellStyle(textStyle);
				} else {
					R0650cell6.setCellValue("");
					R0650cell6.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column H
				Cell R0650cell7 = row.createCell(7);
				if (record1.getR0650_funded_outstanding_amount() != null) {
					R0650cell7.setCellValue(record1.getR0650_funded_outstanding_amount().doubleValue());
					R0650cell7.setCellStyle(numberStyle);
				} else {
					R0650cell7.setCellValue("");
					R0650cell7.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column I
				Cell R0650cell8 = row.createCell(8);
				if (record1.getR0650_ccf_unfunded_outstanding_amount() != null) {
					R0650cell8.setCellValue(record1.getR0650_ccf_unfunded_outstanding_amount().doubleValue());
					R0650cell8.setCellStyle(numberStyle);
				} else {
					R0650cell8.setCellValue("");
					R0650cell8.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column J
				Cell R0650cell9 = row.createCell(9);
				if (record1.getR0650_secured_portion_exposure() != null) {
					R0650cell9.setCellValue(record1.getR0650_secured_portion_exposure().doubleValue());
					R0650cell9.setCellStyle(numberStyle);
				} else {
					R0650cell9.setCellValue("");
					R0650cell9.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column K
				Cell R0650cell10 = row.createCell(10);
				if (record1.getR0650_post_collateral_haircut() != null) {
					R0650cell10.setCellValue(record1.getR0650_post_collateral_haircut().doubleValue());
					R0650cell10.setCellStyle(numberStyle);
				} else {
					R0650cell10.setCellValue("");
					R0650cell10.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column L
				Cell R0650cell11 = row.createCell(11);
				if (record1.getR0650_type_of_security() != null) {
					R0650cell11.setCellValue(record1.getR0650_type_of_security().doubleValue());
					R0650cell11.setCellStyle(numberStyle);
				} else {
					R0650cell11.setCellValue("");
					R0650cell11.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column M
				Cell R0650cell12 = row.createCell(12);
				if (record1.getR0650_discounted_collateral_value() != null) {
					R0650cell12.setCellValue(record1.getR0650_discounted_collateral_value().doubleValue());
					R0650cell12.setCellStyle(numberStyle);
				} else {
					R0650cell12.setCellValue("");
					R0650cell12.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column N
				Cell R0650cell13 = row.createCell(13);
				if (record1.getR0650_validated_discounted_cashflows() != null) {
					R0650cell13.setCellValue(record1.getR0650_validated_discounted_cashflows().doubleValue());
					R0650cell13.setCellStyle(numberStyle);
				} else {
					R0650cell13.setCellValue("");
					R0650cell13.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column O
				Cell R0650cell14 = row.createCell(14);
				if (record1.getR0650_pd() != null) {
					R0650cell14.setCellValue(record1.getR0650_pd().doubleValue());
					R0650cell14.setCellStyle(numberStyle);
				} else {
					R0650cell14.setCellValue("");
					R0650cell14.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column P
				Cell R0650cell15 = row.createCell(15);
				if (record1.getR0650_lgd() != null) {
					R0650cell15.setCellValue(record1.getR0650_lgd().doubleValue());
					R0650cell15.setCellStyle(numberStyle);
				} else {
					R0650cell15.setCellValue("");
					R0650cell15.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column Q
				Cell R0650cell16 = row.createCell(16);
				if (record1.getR0650_provisions_charged_pnl() != null) {
					R0650cell16.setCellValue(record1.getR0650_provisions_charged_pnl().doubleValue());
					R0650cell16.setCellStyle(numberStyle);
				} else {
					R0650cell16.setCellValue("");
					R0650cell16.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column R
				Cell R0650cell17 = row.createCell(17);
				if (record1.getR0650_legacy_interest_profit_suspense() != null) {
					R0650cell17.setCellValue(record1.getR0650_legacy_interest_profit_suspense().doubleValue());
					R0650cell17.setCellStyle(numberStyle);
				} else {
					R0650cell17.setCellValue("");
					R0650cell17.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column S
				Cell R0650cell18 = row.createCell(18);
				if (record1.getR0650_legal_case_yn() != null && !record1.getR0650_legal_case_yn().isEmpty()) {
					R0650cell18.setCellValue(record1.getR0650_legal_case_yn());
					R0650cell18.setCellStyle(textStyle);
				} else {
					R0650cell18.setCellValue("");
					R0650cell18.setCellStyle(textStyle);
				}

				/// ROW73
				//// Column T
				Cell R0650cell19 = row.createCell(19);
				if (record1.getR0650_remarks_if_any() != null && !record1.getR0650_remarks_if_any().isEmpty()) {
					R0650cell19.setCellValue(record1.getR0650_remarks_if_any());
					R0650cell19.setCellStyle(textStyle);
				} else {
					R0650cell19.setCellValue("");
					R0650cell19.setCellStyle(textStyle);
				}

				/// ROW74
				row = sheet.getRow(73);
				//// Column D
				Cell R0660cell3 = row.createCell(3);
				if (record1.getR0660_borrower_name() != null && !record1.getR0660_borrower_name().isEmpty()) {
					R0660cell3.setCellValue(record1.getR0660_borrower_name());
					R0660cell3.setCellStyle(textStyle);
				} else {
					R0660cell3.setCellValue("");
					R0660cell3.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column E
				Cell R0660cell4 = row.createCell(4);
				if (record1.getR0660_group_name_if_applicable() != null
						&& !record1.getR0660_group_name_if_applicable().isEmpty()) {
					R0660cell4.setCellValue(record1.getR0660_group_name_if_applicable());
					R0660cell4.setCellStyle(textStyle);
				} else {
					R0660cell4.setCellValue("");
					R0660cell4.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column F
				Cell R0660cell5 = row.createCell(5);
				if (record1.getR0660_cin() != null && !record1.getR0660_cin().isEmpty()) {
					R0660cell5.setCellValue(record1.getR0660_cin());
					R0660cell5.setCellStyle(textStyle);
				} else {
					R0660cell5.setCellValue("");
					R0660cell5.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column G
				Cell R0660cell6 = row.createCell(6);
				if (record1.getR0660_domicile_country() != null
						&& !record1.getR0660_domicile_country().isEmpty()) {
					R0660cell6.setCellValue(record1.getR0660_domicile_country());
					R0660cell6.setCellStyle(textStyle);
				} else {
					R0660cell6.setCellValue("");
					R0660cell6.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column H
				Cell R0660cell7 = row.createCell(7);
				if (record1.getR0660_funded_outstanding_amount() != null) {
					R0660cell7.setCellValue(record1.getR0660_funded_outstanding_amount().doubleValue());
					R0660cell7.setCellStyle(numberStyle);
				} else {
					R0660cell7.setCellValue("");
					R0660cell7.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column I
				Cell R0660cell8 = row.createCell(8);
				if (record1.getR0660_ccf_unfunded_outstanding_amount() != null) {
					R0660cell8.setCellValue(record1.getR0660_ccf_unfunded_outstanding_amount().doubleValue());
					R0660cell8.setCellStyle(numberStyle);
				} else {
					R0660cell8.setCellValue("");
					R0660cell8.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column J
				Cell R0660cell9 = row.createCell(9);
				if (record1.getR0660_secured_portion_exposure() != null) {
					R0660cell9.setCellValue(record1.getR0660_secured_portion_exposure().doubleValue());
					R0660cell9.setCellStyle(numberStyle);
				} else {
					R0660cell9.setCellValue("");
					R0660cell9.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column K
				Cell R0660cell10 = row.createCell(10);
				if (record1.getR0660_post_collateral_haircut() != null) {
					R0660cell10.setCellValue(record1.getR0660_post_collateral_haircut().doubleValue());
					R0660cell10.setCellStyle(numberStyle);
				} else {
					R0660cell10.setCellValue("");
					R0660cell10.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column L
				Cell R0660cell11 = row.createCell(11);
				if (record1.getR0660_type_of_security() != null) {
					R0660cell11.setCellValue(record1.getR0660_type_of_security().doubleValue());
					R0660cell11.setCellStyle(numberStyle);
				} else {
					R0660cell11.setCellValue("");
					R0660cell11.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column M
				Cell R0660cell12 = row.createCell(12);
				if (record1.getR0660_discounted_collateral_value() != null) {
					R0660cell12.setCellValue(record1.getR0660_discounted_collateral_value().doubleValue());
					R0660cell12.setCellStyle(numberStyle);
				} else {
					R0660cell12.setCellValue("");
					R0660cell12.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column N
				Cell R0660cell13 = row.createCell(13);
				if (record1.getR0660_validated_discounted_cashflows() != null) {
					R0660cell13.setCellValue(record1.getR0660_validated_discounted_cashflows().doubleValue());
					R0660cell13.setCellStyle(numberStyle);
				} else {
					R0660cell13.setCellValue("");
					R0660cell13.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column O
				Cell R0660cell14 = row.createCell(14);
				if (record1.getR0660_pd() != null) {
					R0660cell14.setCellValue(record1.getR0660_pd().doubleValue());
					R0660cell14.setCellStyle(numberStyle);
				} else {
					R0660cell14.setCellValue("");
					R0660cell14.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column P
				Cell R0660cell15 = row.createCell(15);
				if (record1.getR0660_lgd() != null) {
					R0660cell15.setCellValue(record1.getR0660_lgd().doubleValue());
					R0660cell15.setCellStyle(numberStyle);
				} else {
					R0660cell15.setCellValue("");
					R0660cell15.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column Q
				Cell R0660cell16 = row.createCell(16);
				if (record1.getR0660_provisions_charged_pnl() != null) {
					R0660cell16.setCellValue(record1.getR0660_provisions_charged_pnl().doubleValue());
					R0660cell16.setCellStyle(numberStyle);
				} else {
					R0660cell16.setCellValue("");
					R0660cell16.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column R
				Cell R0660cell17 = row.createCell(17);
				if (record1.getR0660_legacy_interest_profit_suspense() != null) {
					R0660cell17.setCellValue(record1.getR0660_legacy_interest_profit_suspense().doubleValue());
					R0660cell17.setCellStyle(numberStyle);
				} else {
					R0660cell17.setCellValue("");
					R0660cell17.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column S
				Cell R0660cell18 = row.createCell(18);
				if (record1.getR0660_legal_case_yn() != null && !record1.getR0660_legal_case_yn().isEmpty()) {
					R0660cell18.setCellValue(record1.getR0660_legal_case_yn());
					R0660cell18.setCellStyle(textStyle);
				} else {
					R0660cell18.setCellValue("");
					R0660cell18.setCellStyle(textStyle);
				}

				/// ROW74
				//// Column T
				Cell R0660cell19 = row.createCell(19);
				if (record1.getR0660_remarks_if_any() != null && !record1.getR0660_remarks_if_any().isEmpty()) {
					R0660cell19.setCellValue(record1.getR0660_remarks_if_any());
					R0660cell19.setCellStyle(textStyle);
				} else {
					R0660cell19.setCellValue("");
					R0660cell19.setCellStyle(textStyle);
				}

				/// ROW75
				row = sheet.getRow(74);
				//// Column D
				Cell R0670cell3 = row.createCell(3);
				if (record1.getR0670_borrower_name() != null && !record1.getR0670_borrower_name().isEmpty()) {
					R0670cell3.setCellValue(record1.getR0670_borrower_name());
					R0670cell3.setCellStyle(textStyle);
				} else {
					R0670cell3.setCellValue("");
					R0670cell3.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column E
				Cell R0670cell4 = row.createCell(4);
				if (record1.getR0670_group_name_if_applicable() != null
						&& !record1.getR0670_group_name_if_applicable().isEmpty()) {
					R0670cell4.setCellValue(record1.getR0670_group_name_if_applicable());
					R0670cell4.setCellStyle(textStyle);
				} else {
					R0670cell4.setCellValue("");
					R0670cell4.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column F
				Cell R0670cell5 = row.createCell(5);
				if (record1.getR0670_cin() != null && !record1.getR0670_cin().isEmpty()) {
					R0670cell5.setCellValue(record1.getR0670_cin());
					R0670cell5.setCellStyle(textStyle);
				} else {
					R0670cell5.setCellValue("");
					R0670cell5.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column G
				Cell R0670cell6 = row.createCell(6);
				if (record1.getR0670_domicile_country() != null
						&& !record1.getR0670_domicile_country().isEmpty()) {
					R0670cell6.setCellValue(record1.getR0670_domicile_country());
					R0670cell6.setCellStyle(textStyle);
				} else {
					R0670cell6.setCellValue("");
					R0670cell6.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column H
				Cell R0670cell7 = row.createCell(7);
				if (record1.getR0670_funded_outstanding_amount() != null) {
					R0670cell7.setCellValue(record1.getR0670_funded_outstanding_amount().doubleValue());
					R0670cell7.setCellStyle(numberStyle);
				} else {
					R0670cell7.setCellValue("");
					R0670cell7.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column I
				Cell R0670cell8 = row.createCell(8);
				if (record1.getR0670_ccf_unfunded_outstanding_amount() != null) {
					R0670cell8.setCellValue(record1.getR0670_ccf_unfunded_outstanding_amount().doubleValue());
					R0670cell8.setCellStyle(numberStyle);
				} else {
					R0670cell8.setCellValue("");
					R0670cell8.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column J
				Cell R0670cell9 = row.createCell(9);
				if (record1.getR0670_secured_portion_exposure() != null) {
					R0670cell9.setCellValue(record1.getR0670_secured_portion_exposure().doubleValue());
					R0670cell9.setCellStyle(numberStyle);
				} else {
					R0670cell9.setCellValue("");
					R0670cell9.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column K
				Cell R0670cell10 = row.createCell(10);
				if (record1.getR0670_post_collateral_haircut() != null) {
					R0670cell10.setCellValue(record1.getR0670_post_collateral_haircut().doubleValue());
					R0670cell10.setCellStyle(numberStyle);
				} else {
					R0670cell10.setCellValue("");
					R0670cell10.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column L
				Cell R0670cell11 = row.createCell(11);
				if (record1.getR0670_type_of_security() != null) {
					R0670cell11.setCellValue(record1.getR0670_type_of_security().doubleValue());
					R0670cell11.setCellStyle(numberStyle);
				} else {
					R0670cell11.setCellValue("");
					R0670cell11.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column M
				Cell R0670cell12 = row.createCell(12);
				if (record1.getR0670_discounted_collateral_value() != null) {
					R0670cell12.setCellValue(record1.getR0670_discounted_collateral_value().doubleValue());
					R0670cell12.setCellStyle(numberStyle);
				} else {
					R0670cell12.setCellValue("");
					R0670cell12.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column N
				Cell R0670cell13 = row.createCell(13);
				if (record1.getR0670_validated_discounted_cashflows() != null) {
					R0670cell13.setCellValue(record1.getR0670_validated_discounted_cashflows().doubleValue());
					R0670cell13.setCellStyle(numberStyle);
				} else {
					R0670cell13.setCellValue("");
					R0670cell13.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column O
				Cell R0670cell14 = row.createCell(14);
				if (record1.getR0670_pd() != null) {
					R0670cell14.setCellValue(record1.getR0670_pd().doubleValue());
					R0670cell14.setCellStyle(numberStyle);
				} else {
					R0670cell14.setCellValue("");
					R0670cell14.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column P
				Cell R0670cell15 = row.createCell(15);
				if (record1.getR0670_lgd() != null) {
					R0670cell15.setCellValue(record1.getR0670_lgd().doubleValue());
					R0670cell15.setCellStyle(numberStyle);
				} else {
					R0670cell15.setCellValue("");
					R0670cell15.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column Q
				Cell R0670cell16 = row.createCell(16);
				if (record1.getR0670_provisions_charged_pnl() != null) {
					R0670cell16.setCellValue(record1.getR0670_provisions_charged_pnl().doubleValue());
					R0670cell16.setCellStyle(numberStyle);
				} else {
					R0670cell16.setCellValue("");
					R0670cell16.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column R
				Cell R0670cell17 = row.createCell(17);
				if (record1.getR0670_legacy_interest_profit_suspense() != null) {
					R0670cell17.setCellValue(record1.getR0670_legacy_interest_profit_suspense().doubleValue());
					R0670cell17.setCellStyle(numberStyle);
				} else {
					R0670cell17.setCellValue("");
					R0670cell17.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column S
				Cell R0670cell18 = row.createCell(18);
				if (record1.getR0670_legal_case_yn() != null && !record1.getR0670_legal_case_yn().isEmpty()) {
					R0670cell18.setCellValue(record1.getR0670_legal_case_yn());
					R0670cell18.setCellStyle(textStyle);
				} else {
					R0670cell18.setCellValue("");
					R0670cell18.setCellStyle(textStyle);
				}

				/// ROW75
				//// Column T
				Cell R0670cell19 = row.createCell(19);
				if (record1.getR0670_remarks_if_any() != null && !record1.getR0670_remarks_if_any().isEmpty()) {
					R0670cell19.setCellValue(record1.getR0670_remarks_if_any());
					R0670cell19.setCellStyle(textStyle);
				} else {
					R0670cell19.setCellValue("");
					R0670cell19.setCellStyle(textStyle);
				}

				/// ROW78
				row = sheet.getRow(77);
				//// Column D
				Cell R0700cell3 = row.createCell(3);
				if (record1.getR0700_borrower_name() != null && !record1.getR0700_borrower_name().isEmpty()) {
					R0700cell3.setCellValue(record1.getR0700_borrower_name());
					R0700cell3.setCellStyle(textStyle);
				} else {
					R0700cell3.setCellValue("");
					R0700cell3.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column E
				Cell R0700cell4 = row.createCell(4);
				if (record1.getR0700_group_name_if_applicable() != null
						&& !record1.getR0700_group_name_if_applicable().isEmpty()) {
					R0700cell4.setCellValue(record1.getR0700_group_name_if_applicable());
					R0700cell4.setCellStyle(textStyle);
				} else {
					R0700cell4.setCellValue("");
					R0700cell4.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column F
				Cell R0700cell5 = row.createCell(5);
				if (record1.getR0700_cin() != null && !record1.getR0700_cin().isEmpty()) {
					R0700cell5.setCellValue(record1.getR0700_cin());
					R0700cell5.setCellStyle(textStyle);
				} else {
					R0700cell5.setCellValue("");
					R0700cell5.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column G
				Cell R0700cell6 = row.createCell(6);
				if (record1.getR0700_domicile_country() != null
						&& !record1.getR0700_domicile_country().isEmpty()) {
					R0700cell6.setCellValue(record1.getR0700_domicile_country());
					R0700cell6.setCellStyle(textStyle);
				} else {
					R0700cell6.setCellValue("");
					R0700cell6.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column H
				Cell R0700cell7 = row.createCell(7);
				if (record1.getR0700_funded_outstanding_amount() != null) {
					R0700cell7.setCellValue(record1.getR0700_funded_outstanding_amount().doubleValue());
					R0700cell7.setCellStyle(numberStyle);
				} else {
					R0700cell7.setCellValue("");
					R0700cell7.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column I
				Cell R0700cell8 = row.createCell(8);
				if (record1.getR0700_ccf_unfunded_outstanding_amount() != null) {
					R0700cell8.setCellValue(record1.getR0700_ccf_unfunded_outstanding_amount().doubleValue());
					R0700cell8.setCellStyle(numberStyle);
				} else {
					R0700cell8.setCellValue("");
					R0700cell8.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column J
				Cell R0700cell9 = row.createCell(9);
				if (record1.getR0700_secured_portion_exposure() != null) {
					R0700cell9.setCellValue(record1.getR0700_secured_portion_exposure().doubleValue());
					R0700cell9.setCellStyle(numberStyle);
				} else {
					R0700cell9.setCellValue("");
					R0700cell9.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column K
				Cell R0700cell10 = row.createCell(10);
				if (record1.getR0700_post_collateral_haircut() != null) {
					R0700cell10.setCellValue(record1.getR0700_post_collateral_haircut().doubleValue());
					R0700cell10.setCellStyle(numberStyle);
				} else {
					R0700cell10.setCellValue("");
					R0700cell10.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column L
				Cell R0700cell11 = row.createCell(11);
				if (record1.getR0700_type_of_security() != null) {
					R0700cell11.setCellValue(record1.getR0700_type_of_security().doubleValue());
					R0700cell11.setCellStyle(numberStyle);
				} else {
					R0700cell11.setCellValue("");
					R0700cell11.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column M
				Cell R0700cell12 = row.createCell(12);
				if (record1.getR0700_discounted_collateral_value() != null) {
					R0700cell12.setCellValue(record1.getR0700_discounted_collateral_value().doubleValue());
					R0700cell12.setCellStyle(numberStyle);
				} else {
					R0700cell12.setCellValue("");
					R0700cell12.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column N
				Cell R0700cell13 = row.createCell(13);
				if (record1.getR0700_validated_discounted_cashflows() != null) {
					R0700cell13.setCellValue(record1.getR0700_validated_discounted_cashflows().doubleValue());
					R0700cell13.setCellStyle(numberStyle);
				} else {
					R0700cell13.setCellValue("");
					R0700cell13.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column O
				Cell R0700cell14 = row.createCell(14);
				if (record1.getR0700_pd() != null) {
					R0700cell14.setCellValue(record1.getR0700_pd().doubleValue());
					R0700cell14.setCellStyle(numberStyle);
				} else {
					R0700cell14.setCellValue("");
					R0700cell14.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column P
				Cell R0700cell15 = row.createCell(15);
				if (record1.getR0700_lgd() != null) {
					R0700cell15.setCellValue(record1.getR0700_lgd().doubleValue());
					R0700cell15.setCellStyle(numberStyle);
				} else {
					R0700cell15.setCellValue("");
					R0700cell15.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column Q
				Cell R0700cell16 = row.createCell(16);
				if (record1.getR0700_provisions_charged_pnl() != null) {
					R0700cell16.setCellValue(record1.getR0700_provisions_charged_pnl().doubleValue());
					R0700cell16.setCellStyle(numberStyle);
				} else {
					R0700cell16.setCellValue("");
					R0700cell16.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column R
				Cell R0700cell17 = row.createCell(17);
				if (record1.getR0700_legacy_interest_profit_suspense() != null) {
					R0700cell17.setCellValue(record1.getR0700_legacy_interest_profit_suspense().doubleValue());
					R0700cell17.setCellStyle(numberStyle);
				} else {
					R0700cell17.setCellValue("");
					R0700cell17.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column S
				Cell R0700cell18 = row.createCell(18);
				if (record1.getR0700_legal_case_yn() != null && !record1.getR0700_legal_case_yn().isEmpty()) {
					R0700cell18.setCellValue(record1.getR0700_legal_case_yn());
					R0700cell18.setCellStyle(textStyle);
				} else {
					R0700cell18.setCellValue("");
					R0700cell18.setCellStyle(textStyle);
				}

				/// ROW78
				//// Column T
				Cell R0700cell19 = row.createCell(19);
				if (record1.getR0700_remarks_if_any() != null && !record1.getR0700_remarks_if_any().isEmpty()) {
					R0700cell19.setCellValue(record1.getR0700_remarks_if_any());
					R0700cell19.setCellStyle(textStyle);
				} else {
					R0700cell19.setCellValue("");
					R0700cell19.setCellStyle(textStyle);
				}

				/// ROW79
				row = sheet.getRow(78);
				//// Column D
				Cell R0710cell3 = row.createCell(3);
				if (record1.getR0710_borrower_name() != null && !record1.getR0710_borrower_name().isEmpty()) {
					R0710cell3.setCellValue(record1.getR0710_borrower_name());
					R0710cell3.setCellStyle(textStyle);
				} else {
					R0710cell3.setCellValue("");
					R0710cell3.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column E
				Cell R0710cell4 = row.createCell(4);
				if (record1.getR0710_group_name_if_applicable() != null
						&& !record1.getR0710_group_name_if_applicable().isEmpty()) {
					R0710cell4.setCellValue(record1.getR0710_group_name_if_applicable());
					R0710cell4.setCellStyle(textStyle);
				} else {
					R0710cell4.setCellValue("");
					R0710cell4.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column F
				Cell R0710cell5 = row.createCell(5);
				if (record1.getR0710_cin() != null && !record1.getR0710_cin().isEmpty()) {
					R0710cell5.setCellValue(record1.getR0710_cin());
					R0710cell5.setCellStyle(textStyle);
				} else {
					R0710cell5.setCellValue("");
					R0710cell5.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column G
				Cell R0710cell6 = row.createCell(6);
				if (record1.getR0710_domicile_country() != null
						&& !record1.getR0710_domicile_country().isEmpty()) {
					R0710cell6.setCellValue(record1.getR0710_domicile_country());
					R0710cell6.setCellStyle(textStyle);
				} else {
					R0710cell6.setCellValue("");
					R0710cell6.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column H
				Cell R0710cell7 = row.createCell(7);
				if (record1.getR0710_funded_outstanding_amount() != null) {
					R0710cell7.setCellValue(record1.getR0710_funded_outstanding_amount().doubleValue());
					R0710cell7.setCellStyle(numberStyle);
				} else {
					R0710cell7.setCellValue("");
					R0710cell7.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column I
				Cell R0710cell8 = row.createCell(8);
				if (record1.getR0710_ccf_unfunded_outstanding_amount() != null) {
					R0710cell8.setCellValue(record1.getR0710_ccf_unfunded_outstanding_amount().doubleValue());
					R0710cell8.setCellStyle(numberStyle);
				} else {
					R0710cell8.setCellValue("");
					R0710cell8.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column J
				Cell R0710cell9 = row.createCell(9);
				if (record1.getR0710_secured_portion_exposure() != null) {
					R0710cell9.setCellValue(record1.getR0710_secured_portion_exposure().doubleValue());
					R0710cell9.setCellStyle(numberStyle);
				} else {
					R0710cell9.setCellValue("");
					R0710cell9.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column K
				Cell R0710cell10 = row.createCell(10);
				if (record1.getR0710_post_collateral_haircut() != null) {
					R0710cell10.setCellValue(record1.getR0710_post_collateral_haircut().doubleValue());
					R0710cell10.setCellStyle(numberStyle);
				} else {
					R0710cell10.setCellValue("");
					R0710cell10.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column L
				Cell R0710cell11 = row.createCell(11);
				if (record1.getR0710_type_of_security() != null) {
					R0710cell11.setCellValue(record1.getR0710_type_of_security().doubleValue());
					R0710cell11.setCellStyle(numberStyle);
				} else {
					R0710cell11.setCellValue("");
					R0710cell11.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column M
				Cell R0710cell12 = row.createCell(12);
				if (record1.getR0710_discounted_collateral_value() != null) {
					R0710cell12.setCellValue(record1.getR0710_discounted_collateral_value().doubleValue());
					R0710cell12.setCellStyle(numberStyle);
				} else {
					R0710cell12.setCellValue("");
					R0710cell12.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column N
				Cell R0710cell13 = row.createCell(13);
				if (record1.getR0710_validated_discounted_cashflows() != null) {
					R0710cell13.setCellValue(record1.getR0710_validated_discounted_cashflows().doubleValue());
					R0710cell13.setCellStyle(numberStyle);
				} else {
					R0710cell13.setCellValue("");
					R0710cell13.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column O
				Cell R0710cell14 = row.createCell(14);
				if (record1.getR0710_pd() != null) {
					R0710cell14.setCellValue(record1.getR0710_pd().doubleValue());
					R0710cell14.setCellStyle(numberStyle);
				} else {
					R0710cell14.setCellValue("");
					R0710cell14.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column P
				Cell R0710cell15 = row.createCell(15);
				if (record1.getR0710_lgd() != null) {
					R0710cell15.setCellValue(record1.getR0710_lgd().doubleValue());
					R0710cell15.setCellStyle(numberStyle);
				} else {
					R0710cell15.setCellValue("");
					R0710cell15.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column Q
				Cell R0710cell16 = row.createCell(16);
				if (record1.getR0710_provisions_charged_pnl() != null) {
					R0710cell16.setCellValue(record1.getR0710_provisions_charged_pnl().doubleValue());
					R0710cell16.setCellStyle(numberStyle);
				} else {
					R0710cell16.setCellValue("");
					R0710cell16.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column R
				Cell R0710cell17 = row.createCell(17);
				if (record1.getR0710_legacy_interest_profit_suspense() != null) {
					R0710cell17.setCellValue(record1.getR0710_legacy_interest_profit_suspense().doubleValue());
					R0710cell17.setCellStyle(numberStyle);
				} else {
					R0710cell17.setCellValue("");
					R0710cell17.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column S
				Cell R0710cell18 = row.createCell(18);
				if (record1.getR0710_legal_case_yn() != null && !record1.getR0710_legal_case_yn().isEmpty()) {
					R0710cell18.setCellValue(record1.getR0710_legal_case_yn());
					R0710cell18.setCellStyle(textStyle);
				} else {
					R0710cell18.setCellValue("");
					R0710cell18.setCellStyle(textStyle);
				}

				/// ROW79
				//// Column T
				Cell R0710cell19 = row.createCell(19);
				if (record1.getR0710_remarks_if_any() != null && !record1.getR0710_remarks_if_any().isEmpty()) {
					R0710cell19.setCellValue(record1.getR0710_remarks_if_any());
					R0710cell19.setCellStyle(textStyle);
				} else {
					R0710cell19.setCellValue("");
					R0710cell19.setCellStyle(textStyle);
				}

				/// ROW80
				row = sheet.getRow(79);
				//// Column D
				Cell R0720cell3 = row.createCell(3);
				if (record1.getR0720_borrower_name() != null && !record1.getR0720_borrower_name().isEmpty()) {
					R0720cell3.setCellValue(record1.getR0720_borrower_name());
					R0720cell3.setCellStyle(textStyle);
				} else {
					R0720cell3.setCellValue("");
					R0720cell3.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column E
				Cell R0720cell4 = row.createCell(4);
				if (record1.getR0720_group_name_if_applicable() != null
						&& !record1.getR0720_group_name_if_applicable().isEmpty()) {
					R0720cell4.setCellValue(record1.getR0720_group_name_if_applicable());
					R0720cell4.setCellStyle(textStyle);
				} else {
					R0720cell4.setCellValue("");
					R0720cell4.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column F
				Cell R0720cell5 = row.createCell(5);
				if (record1.getR0720_cin() != null && !record1.getR0720_cin().isEmpty()) {
					R0720cell5.setCellValue(record1.getR0720_cin());
					R0720cell5.setCellStyle(textStyle);
				} else {
					R0720cell5.setCellValue("");
					R0720cell5.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column G
				Cell R0720cell6 = row.createCell(6);
				if (record1.getR0720_domicile_country() != null
						&& !record1.getR0720_domicile_country().isEmpty()) {
					R0720cell6.setCellValue(record1.getR0720_domicile_country());
					R0720cell6.setCellStyle(textStyle);
				} else {
					R0720cell6.setCellValue("");
					R0720cell6.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column H
				Cell R0720cell7 = row.createCell(7);
				if (record1.getR0720_funded_outstanding_amount() != null) {
					R0720cell7.setCellValue(record1.getR0720_funded_outstanding_amount().doubleValue());
					R0720cell7.setCellStyle(numberStyle);
				} else {
					R0720cell7.setCellValue("");
					R0720cell7.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column I
				Cell R0720cell8 = row.createCell(8);
				if (record1.getR0720_ccf_unfunded_outstanding_amount() != null) {
					R0720cell8.setCellValue(record1.getR0720_ccf_unfunded_outstanding_amount().doubleValue());
					R0720cell8.setCellStyle(numberStyle);
				} else {
					R0720cell8.setCellValue("");
					R0720cell8.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column J
				Cell R0720cell9 = row.createCell(9);
				if (record1.getR0720_secured_portion_exposure() != null) {
					R0720cell9.setCellValue(record1.getR0720_secured_portion_exposure().doubleValue());
					R0720cell9.setCellStyle(numberStyle);
				} else {
					R0720cell9.setCellValue("");
					R0720cell9.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column K
				Cell R0720cell10 = row.createCell(10);
				if (record1.getR0720_post_collateral_haircut() != null) {
					R0720cell10.setCellValue(record1.getR0720_post_collateral_haircut().doubleValue());
					R0720cell10.setCellStyle(numberStyle);
				} else {
					R0720cell10.setCellValue("");
					R0720cell10.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column L
				Cell R0720cell11 = row.createCell(11);
				if (record1.getR0720_type_of_security() != null) {
					R0720cell11.setCellValue(record1.getR0720_type_of_security().doubleValue());
					R0720cell11.setCellStyle(numberStyle);
				} else {
					R0720cell11.setCellValue("");
					R0720cell11.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column M
				Cell R0720cell12 = row.createCell(12);
				if (record1.getR0720_discounted_collateral_value() != null) {
					R0720cell12.setCellValue(record1.getR0720_discounted_collateral_value().doubleValue());
					R0720cell12.setCellStyle(numberStyle);
				} else {
					R0720cell12.setCellValue("");
					R0720cell12.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column N
				Cell R0720cell13 = row.createCell(13);
				if (record1.getR0720_validated_discounted_cashflows() != null) {
					R0720cell13.setCellValue(record1.getR0720_validated_discounted_cashflows().doubleValue());
					R0720cell13.setCellStyle(numberStyle);
				} else {
					R0720cell13.setCellValue("");
					R0720cell13.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column O
				Cell R0720cell14 = row.createCell(14);
				if (record1.getR0720_pd() != null) {
					R0720cell14.setCellValue(record1.getR0720_pd().doubleValue());
					R0720cell14.setCellStyle(numberStyle);
				} else {
					R0720cell14.setCellValue("");
					R0720cell14.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column P
				Cell R0720cell15 = row.createCell(15);
				if (record1.getR0720_lgd() != null) {
					R0720cell15.setCellValue(record1.getR0720_lgd().doubleValue());
					R0720cell15.setCellStyle(numberStyle);
				} else {
					R0720cell15.setCellValue("");
					R0720cell15.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column Q
				Cell R0720cell16 = row.createCell(16);
				if (record1.getR0720_provisions_charged_pnl() != null) {
					R0720cell16.setCellValue(record1.getR0720_provisions_charged_pnl().doubleValue());
					R0720cell16.setCellStyle(numberStyle);
				} else {
					R0720cell16.setCellValue("");
					R0720cell16.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column R
				Cell R0720cell17 = row.createCell(17);
				if (record1.getR0720_legacy_interest_profit_suspense() != null) {
					R0720cell17.setCellValue(record1.getR0720_legacy_interest_profit_suspense().doubleValue());
					R0720cell17.setCellStyle(numberStyle);
				} else {
					R0720cell17.setCellValue("");
					R0720cell17.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column S
				Cell R0720cell18 = row.createCell(18);
				if (record1.getR0720_legal_case_yn() != null && !record1.getR0720_legal_case_yn().isEmpty()) {
					R0720cell18.setCellValue(record1.getR0720_legal_case_yn());
					R0720cell18.setCellStyle(textStyle);
				} else {
					R0720cell18.setCellValue("");
					R0720cell18.setCellStyle(textStyle);
				}

				/// ROW80
				//// Column T
				Cell R0720cell19 = row.createCell(19);
				if (record1.getR0720_remarks_if_any() != null && !record1.getR0720_remarks_if_any().isEmpty()) {
					R0720cell19.setCellValue(record1.getR0720_remarks_if_any());
					R0720cell19.setCellStyle(textStyle);
				} else {
					R0720cell19.setCellValue("");
					R0720cell19.setCellStyle(textStyle);
				}

				/// ROW81
				row = sheet.getRow(80);
				//// Column D
				Cell R0730cell3 = row.createCell(3);
				if (record1.getR0730_borrower_name() != null && !record1.getR0730_borrower_name().isEmpty()) {
					R0730cell3.setCellValue(record1.getR0730_borrower_name());
					R0730cell3.setCellStyle(textStyle);
				} else {
					R0730cell3.setCellValue("");
					R0730cell3.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column E
				Cell R0730cell4 = row.createCell(4);
				if (record1.getR0730_group_name_if_applicable() != null
						&& !record1.getR0730_group_name_if_applicable().isEmpty()) {
					R0730cell4.setCellValue(record1.getR0730_group_name_if_applicable());
					R0730cell4.setCellStyle(textStyle);
				} else {
					R0730cell4.setCellValue("");
					R0730cell4.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column F
				Cell R0730cell5 = row.createCell(5);
				if (record1.getR0730_cin() != null && !record1.getR0730_cin().isEmpty()) {
					R0730cell5.setCellValue(record1.getR0730_cin());
					R0730cell5.setCellStyle(textStyle);
				} else {
					R0730cell5.setCellValue("");
					R0730cell5.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column G
				Cell R0730cell6 = row.createCell(6);
				if (record1.getR0730_domicile_country() != null
						&& !record1.getR0730_domicile_country().isEmpty()) {
					R0730cell6.setCellValue(record1.getR0730_domicile_country());
					R0730cell6.setCellStyle(textStyle);
				} else {
					R0730cell6.setCellValue("");
					R0730cell6.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column H
				Cell R0730cell7 = row.createCell(7);
				if (record1.getR0730_funded_outstanding_amount() != null) {
					R0730cell7.setCellValue(record1.getR0730_funded_outstanding_amount().doubleValue());
					R0730cell7.setCellStyle(numberStyle);
				} else {
					R0730cell7.setCellValue("");
					R0730cell7.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column I
				Cell R0730cell8 = row.createCell(8);
				if (record1.getR0730_ccf_unfunded_outstanding_amount() != null) {
					R0730cell8.setCellValue(record1.getR0730_ccf_unfunded_outstanding_amount().doubleValue());
					R0730cell8.setCellStyle(numberStyle);
				} else {
					R0730cell8.setCellValue("");
					R0730cell8.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column J
				Cell R0730cell9 = row.createCell(9);
				if (record1.getR0730_secured_portion_exposure() != null) {
					R0730cell9.setCellValue(record1.getR0730_secured_portion_exposure().doubleValue());
					R0730cell9.setCellStyle(numberStyle);
				} else {
					R0730cell9.setCellValue("");
					R0730cell9.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column K
				Cell R0730cell10 = row.createCell(10);
				if (record1.getR0730_post_collateral_haircut() != null) {
					R0730cell10.setCellValue(record1.getR0730_post_collateral_haircut().doubleValue());
					R0730cell10.setCellStyle(numberStyle);
				} else {
					R0730cell10.setCellValue("");
					R0730cell10.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column L
				Cell R0730cell11 = row.createCell(11);
				if (record1.getR0730_type_of_security() != null) {
					R0730cell11.setCellValue(record1.getR0730_type_of_security().doubleValue());
					R0730cell11.setCellStyle(numberStyle);
				} else {
					R0730cell11.setCellValue("");
					R0730cell11.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column M
				Cell R0730cell12 = row.createCell(12);
				if (record1.getR0730_discounted_collateral_value() != null) {
					R0730cell12.setCellValue(record1.getR0730_discounted_collateral_value().doubleValue());
					R0730cell12.setCellStyle(numberStyle);
				} else {
					R0730cell12.setCellValue("");
					R0730cell12.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column N
				Cell R0730cell13 = row.createCell(13);
				if (record1.getR0730_validated_discounted_cashflows() != null) {
					R0730cell13.setCellValue(record1.getR0730_validated_discounted_cashflows().doubleValue());
					R0730cell13.setCellStyle(numberStyle);
				} else {
					R0730cell13.setCellValue("");
					R0730cell13.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column O
				Cell R0730cell14 = row.createCell(14);
				if (record1.getR0730_pd() != null) {
					R0730cell14.setCellValue(record1.getR0730_pd().doubleValue());
					R0730cell14.setCellStyle(numberStyle);
				} else {
					R0730cell14.setCellValue("");
					R0730cell14.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column P
				Cell R0730cell15 = row.createCell(15);
				if (record1.getR0730_lgd() != null) {
					R0730cell15.setCellValue(record1.getR0730_lgd().doubleValue());
					R0730cell15.setCellStyle(numberStyle);
				} else {
					R0730cell15.setCellValue("");
					R0730cell15.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column Q
				Cell R0730cell16 = row.createCell(16);
				if (record1.getR0730_provisions_charged_pnl() != null) {
					R0730cell16.setCellValue(record1.getR0730_provisions_charged_pnl().doubleValue());
					R0730cell16.setCellStyle(numberStyle);
				} else {
					R0730cell16.setCellValue("");
					R0730cell16.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column R
				Cell R0730cell17 = row.createCell(17);
				if (record1.getR0730_legacy_interest_profit_suspense() != null) {
					R0730cell17.setCellValue(record1.getR0730_legacy_interest_profit_suspense().doubleValue());
					R0730cell17.setCellStyle(numberStyle);
				} else {
					R0730cell17.setCellValue("");
					R0730cell17.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column S
				Cell R0730cell18 = row.createCell(18);
				if (record1.getR0730_legal_case_yn() != null && !record1.getR0730_legal_case_yn().isEmpty()) {
					R0730cell18.setCellValue(record1.getR0730_legal_case_yn());
					R0730cell18.setCellStyle(textStyle);
				} else {
					R0730cell18.setCellValue("");
					R0730cell18.setCellStyle(textStyle);
				}

				/// ROW81
				//// Column T
				Cell R0730cell19 = row.createCell(19);
				if (record1.getR0730_remarks_if_any() != null && !record1.getR0730_remarks_if_any().isEmpty()) {
					R0730cell19.setCellValue(record1.getR0730_remarks_if_any());
					R0730cell19.setCellStyle(textStyle);
				} else {
					R0730cell19.setCellValue("");
					R0730cell19.setCellStyle(textStyle);
				}

				/// ROW82
				row = sheet.getRow(81);
				//// Column D
				Cell R0740cell3 = row.createCell(3);
				if (record1.getR0740_borrower_name() != null && !record1.getR0740_borrower_name().isEmpty()) {
					R0740cell3.setCellValue(record1.getR0740_borrower_name());
					R0740cell3.setCellStyle(textStyle);
				} else {
					R0740cell3.setCellValue("");
					R0740cell3.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column E
				Cell R0740cell4 = row.createCell(4);
				if (record1.getR0740_group_name_if_applicable() != null
						&& !record1.getR0740_group_name_if_applicable().isEmpty()) {
					R0740cell4.setCellValue(record1.getR0740_group_name_if_applicable());
					R0740cell4.setCellStyle(textStyle);
				} else {
					R0740cell4.setCellValue("");
					R0740cell4.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column F
				Cell R0740cell5 = row.createCell(5);
				if (record1.getR0740_cin() != null && !record1.getR0740_cin().isEmpty()) {
					R0740cell5.setCellValue(record1.getR0740_cin());
					R0740cell5.setCellStyle(textStyle);
				} else {
					R0740cell5.setCellValue("");
					R0740cell5.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column G
				Cell R0740cell6 = row.createCell(6);
				if (record1.getR0740_domicile_country() != null
						&& !record1.getR0740_domicile_country().isEmpty()) {
					R0740cell6.setCellValue(record1.getR0740_domicile_country());
					R0740cell6.setCellStyle(textStyle);
				} else {
					R0740cell6.setCellValue("");
					R0740cell6.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column H
				Cell R0740cell7 = row.createCell(7);
				if (record1.getR0740_funded_outstanding_amount() != null) {
					R0740cell7.setCellValue(record1.getR0740_funded_outstanding_amount().doubleValue());
					R0740cell7.setCellStyle(numberStyle);
				} else {
					R0740cell7.setCellValue("");
					R0740cell7.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column I
				Cell R0740cell8 = row.createCell(8);
				if (record1.getR0740_ccf_unfunded_outstanding_amount() != null) {
					R0740cell8.setCellValue(record1.getR0740_ccf_unfunded_outstanding_amount().doubleValue());
					R0740cell8.setCellStyle(numberStyle);
				} else {
					R0740cell8.setCellValue("");
					R0740cell8.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column J
				Cell R0740cell9 = row.createCell(9);
				if (record1.getR0740_secured_portion_exposure() != null) {
					R0740cell9.setCellValue(record1.getR0740_secured_portion_exposure().doubleValue());
					R0740cell9.setCellStyle(numberStyle);
				} else {
					R0740cell9.setCellValue("");
					R0740cell9.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column K
				Cell R0740cell10 = row.createCell(10);
				if (record1.getR0740_post_collateral_haircut() != null) {
					R0740cell10.setCellValue(record1.getR0740_post_collateral_haircut().doubleValue());
					R0740cell10.setCellStyle(numberStyle);
				} else {
					R0740cell10.setCellValue("");
					R0740cell10.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column L
				Cell R0740cell11 = row.createCell(11);
				if (record1.getR0740_type_of_security() != null) {
					R0740cell11.setCellValue(record1.getR0740_type_of_security().doubleValue());
					R0740cell11.setCellStyle(numberStyle);
				} else {
					R0740cell11.setCellValue("");
					R0740cell11.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column M
				Cell R0740cell12 = row.createCell(12);
				if (record1.getR0740_discounted_collateral_value() != null) {
					R0740cell12.setCellValue(record1.getR0740_discounted_collateral_value().doubleValue());
					R0740cell12.setCellStyle(numberStyle);
				} else {
					R0740cell12.setCellValue("");
					R0740cell12.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column N
				Cell R0740cell13 = row.createCell(13);
				if (record1.getR0740_validated_discounted_cashflows() != null) {
					R0740cell13.setCellValue(record1.getR0740_validated_discounted_cashflows().doubleValue());
					R0740cell13.setCellStyle(numberStyle);
				} else {
					R0740cell13.setCellValue("");
					R0740cell13.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column O
				Cell R0740cell14 = row.createCell(14);
				if (record1.getR0740_pd() != null) {
					R0740cell14.setCellValue(record1.getR0740_pd().doubleValue());
					R0740cell14.setCellStyle(numberStyle);
				} else {
					R0740cell14.setCellValue("");
					R0740cell14.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column P
				Cell R0740cell15 = row.createCell(15);
				if (record1.getR0740_lgd() != null) {
					R0740cell15.setCellValue(record1.getR0740_lgd().doubleValue());
					R0740cell15.setCellStyle(numberStyle);
				} else {
					R0740cell15.setCellValue("");
					R0740cell15.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column Q
				Cell R0740cell16 = row.createCell(16);
				if (record1.getR0740_provisions_charged_pnl() != null) {
					R0740cell16.setCellValue(record1.getR0740_provisions_charged_pnl().doubleValue());
					R0740cell16.setCellStyle(numberStyle);
				} else {
					R0740cell16.setCellValue("");
					R0740cell16.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column R
				Cell R0740cell17 = row.createCell(17);
				if (record1.getR0740_legacy_interest_profit_suspense() != null) {
					R0740cell17.setCellValue(record1.getR0740_legacy_interest_profit_suspense().doubleValue());
					R0740cell17.setCellStyle(numberStyle);
				} else {
					R0740cell17.setCellValue("");
					R0740cell17.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column S
				Cell R0740cell18 = row.createCell(18);
				if (record1.getR0740_legal_case_yn() != null && !record1.getR0740_legal_case_yn().isEmpty()) {
					R0740cell18.setCellValue(record1.getR0740_legal_case_yn());
					R0740cell18.setCellStyle(textStyle);
				} else {
					R0740cell18.setCellValue("");
					R0740cell18.setCellStyle(textStyle);
				}

				/// ROW82
				//// Column T
				Cell R0740cell19 = row.createCell(19);
				if (record1.getR0740_remarks_if_any() != null && !record1.getR0740_remarks_if_any().isEmpty()) {
					R0740cell19.setCellValue(record1.getR0740_remarks_if_any());
					R0740cell19.setCellStyle(textStyle);
				} else {
					R0740cell19.setCellValue("");
					R0740cell19.setCellStyle(textStyle);
				}

				/// ROW83
				row = sheet.getRow(82);
				//// Column D
				Cell R0750cell3 = row.createCell(3);
				if (record1.getR0750_borrower_name() != null && !record1.getR0750_borrower_name().isEmpty()) {
					R0750cell3.setCellValue(record1.getR0750_borrower_name());
					R0750cell3.setCellStyle(textStyle);
				} else {
					R0750cell3.setCellValue("");
					R0750cell3.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column E
				Cell R0750cell4 = row.createCell(4);
				if (record1.getR0750_group_name_if_applicable() != null
						&& !record1.getR0750_group_name_if_applicable().isEmpty()) {
					R0750cell4.setCellValue(record1.getR0750_group_name_if_applicable());
					R0750cell4.setCellStyle(textStyle);
				} else {
					R0750cell4.setCellValue("");
					R0750cell4.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column F
				Cell R0750cell5 = row.createCell(5);
				if (record1.getR0750_cin() != null && !record1.getR0750_cin().isEmpty()) {
					R0750cell5.setCellValue(record1.getR0750_cin());
					R0750cell5.setCellStyle(textStyle);
				} else {
					R0750cell5.setCellValue("");
					R0750cell5.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column G
				Cell R0750cell6 = row.createCell(6);
				if (record1.getR0750_domicile_country() != null
						&& !record1.getR0750_domicile_country().isEmpty()) {
					R0750cell6.setCellValue(record1.getR0750_domicile_country());
					R0750cell6.setCellStyle(textStyle);
				} else {
					R0750cell6.setCellValue("");
					R0750cell6.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column H
				Cell R0750cell7 = row.createCell(7);
				if (record1.getR0750_funded_outstanding_amount() != null) {
					R0750cell7.setCellValue(record1.getR0750_funded_outstanding_amount().doubleValue());
					R0750cell7.setCellStyle(numberStyle);
				} else {
					R0750cell7.setCellValue("");
					R0750cell7.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column I
				Cell R0750cell8 = row.createCell(8);
				if (record1.getR0750_ccf_unfunded_outstanding_amount() != null) {
					R0750cell8.setCellValue(record1.getR0750_ccf_unfunded_outstanding_amount().doubleValue());
					R0750cell8.setCellStyle(numberStyle);
				} else {
					R0750cell8.setCellValue("");
					R0750cell8.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column J
				Cell R0750cell9 = row.createCell(9);
				if (record1.getR0750_secured_portion_exposure() != null) {
					R0750cell9.setCellValue(record1.getR0750_secured_portion_exposure().doubleValue());
					R0750cell9.setCellStyle(numberStyle);
				} else {
					R0750cell9.setCellValue("");
					R0750cell9.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column K
				Cell R0750cell10 = row.createCell(10);
				if (record1.getR0750_post_collateral_haircut() != null) {
					R0750cell10.setCellValue(record1.getR0750_post_collateral_haircut().doubleValue());
					R0750cell10.setCellStyle(numberStyle);
				} else {
					R0750cell10.setCellValue("");
					R0750cell10.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column L
				Cell R0750cell11 = row.createCell(11);
				if (record1.getR0750_type_of_security() != null) {
					R0750cell11.setCellValue(record1.getR0750_type_of_security().doubleValue());
					R0750cell11.setCellStyle(numberStyle);
				} else {
					R0750cell11.setCellValue("");
					R0750cell11.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column M
				Cell R0750cell12 = row.createCell(12);
				if (record1.getR0750_discounted_collateral_value() != null) {
					R0750cell12.setCellValue(record1.getR0750_discounted_collateral_value().doubleValue());
					R0750cell12.setCellStyle(numberStyle);
				} else {
					R0750cell12.setCellValue("");
					R0750cell12.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column N
				Cell R0750cell13 = row.createCell(13);
				if (record1.getR0750_validated_discounted_cashflows() != null) {
					R0750cell13.setCellValue(record1.getR0750_validated_discounted_cashflows().doubleValue());
					R0750cell13.setCellStyle(numberStyle);
				} else {
					R0750cell13.setCellValue("");
					R0750cell13.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column O
				Cell R0750cell14 = row.createCell(14);
				if (record1.getR0750_pd() != null) {
					R0750cell14.setCellValue(record1.getR0750_pd().doubleValue());
					R0750cell14.setCellStyle(numberStyle);
				} else {
					R0750cell14.setCellValue("");
					R0750cell14.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column P
				Cell R0750cell15 = row.createCell(15);
				if (record1.getR0750_lgd() != null) {
					R0750cell15.setCellValue(record1.getR0750_lgd().doubleValue());
					R0750cell15.setCellStyle(numberStyle);
				} else {
					R0750cell15.setCellValue("");
					R0750cell15.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column Q
				Cell R0750cell16 = row.createCell(16);
				if (record1.getR0750_provisions_charged_pnl() != null) {
					R0750cell16.setCellValue(record1.getR0750_provisions_charged_pnl().doubleValue());
					R0750cell16.setCellStyle(numberStyle);
				} else {
					R0750cell16.setCellValue("");
					R0750cell16.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column R
				Cell R0750cell17 = row.createCell(17);
				if (record1.getR0750_legacy_interest_profit_suspense() != null) {
					R0750cell17.setCellValue(record1.getR0750_legacy_interest_profit_suspense().doubleValue());
					R0750cell17.setCellStyle(numberStyle);
				} else {
					R0750cell17.setCellValue("");
					R0750cell17.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column S
				Cell R0750cell18 = row.createCell(18);
				if (record1.getR0750_legal_case_yn() != null && !record1.getR0750_legal_case_yn().isEmpty()) {
					R0750cell18.setCellValue(record1.getR0750_legal_case_yn());
					R0750cell18.setCellStyle(textStyle);
				} else {
					R0750cell18.setCellValue("");
					R0750cell18.setCellStyle(textStyle);
				}

				/// ROW83
				//// Column T
				Cell R0750cell19 = row.createCell(19);
				if (record1.getR0750_remarks_if_any() != null && !record1.getR0750_remarks_if_any().isEmpty()) {
					R0750cell19.setCellValue(record1.getR0750_remarks_if_any());
					R0750cell19.setCellStyle(textStyle);
				} else {
					R0750cell19.setCellValue("");
					R0750cell19.setCellStyle(textStyle);
				}

				/// ROW84
				row = sheet.getRow(83);
				//// Column D
				Cell R0760cell3 = row.createCell(3);
				if (record1.getR0760_borrower_name() != null && !record1.getR0760_borrower_name().isEmpty()) {
					R0760cell3.setCellValue(record1.getR0760_borrower_name());
					R0760cell3.setCellStyle(textStyle);
				} else {
					R0760cell3.setCellValue("");
					R0760cell3.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column E
				Cell R0760cell4 = row.createCell(4);
				if (record1.getR0760_group_name_if_applicable() != null
						&& !record1.getR0760_group_name_if_applicable().isEmpty()) {
					R0760cell4.setCellValue(record1.getR0760_group_name_if_applicable());
					R0760cell4.setCellStyle(textStyle);
				} else {
					R0760cell4.setCellValue("");
					R0760cell4.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column F
				Cell R0760cell5 = row.createCell(5);
				if (record1.getR0760_cin() != null && !record1.getR0760_cin().isEmpty()) {
					R0760cell5.setCellValue(record1.getR0760_cin());
					R0760cell5.setCellStyle(textStyle);
				} else {
					R0760cell5.setCellValue("");
					R0760cell5.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column G
				Cell R0760cell6 = row.createCell(6);
				if (record1.getR0760_domicile_country() != null
						&& !record1.getR0760_domicile_country().isEmpty()) {
					R0760cell6.setCellValue(record1.getR0760_domicile_country());
					R0760cell6.setCellStyle(textStyle);
				} else {
					R0760cell6.setCellValue("");
					R0760cell6.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column H
				Cell R0760cell7 = row.createCell(7);
				if (record1.getR0760_funded_outstanding_amount() != null) {
					R0760cell7.setCellValue(record1.getR0760_funded_outstanding_amount().doubleValue());
					R0760cell7.setCellStyle(numberStyle);
				} else {
					R0760cell7.setCellValue("");
					R0760cell7.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column I
				Cell R0760cell8 = row.createCell(8);
				if (record1.getR0760_ccf_unfunded_outstanding_amount() != null) {
					R0760cell8.setCellValue(record1.getR0760_ccf_unfunded_outstanding_amount().doubleValue());
					R0760cell8.setCellStyle(numberStyle);
				} else {
					R0760cell8.setCellValue("");
					R0760cell8.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column J
				Cell R0760cell9 = row.createCell(9);
				if (record1.getR0760_secured_portion_exposure() != null) {
					R0760cell9.setCellValue(record1.getR0760_secured_portion_exposure().doubleValue());
					R0760cell9.setCellStyle(numberStyle);
				} else {
					R0760cell9.setCellValue("");
					R0760cell9.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column K
				Cell R0760cell10 = row.createCell(10);
				if (record1.getR0760_post_collateral_haircut() != null) {
					R0760cell10.setCellValue(record1.getR0760_post_collateral_haircut().doubleValue());
					R0760cell10.setCellStyle(numberStyle);
				} else {
					R0760cell10.setCellValue("");
					R0760cell10.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column L
				Cell R0760cell11 = row.createCell(11);
				if (record1.getR0760_type_of_security() != null) {
					R0760cell11.setCellValue(record1.getR0760_type_of_security().doubleValue());
					R0760cell11.setCellStyle(numberStyle);
				} else {
					R0760cell11.setCellValue("");
					R0760cell11.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column M
				Cell R0760cell12 = row.createCell(12);
				if (record1.getR0760_discounted_collateral_value() != null) {
					R0760cell12.setCellValue(record1.getR0760_discounted_collateral_value().doubleValue());
					R0760cell12.setCellStyle(numberStyle);
				} else {
					R0760cell12.setCellValue("");
					R0760cell12.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column N
				Cell R0760cell13 = row.createCell(13);
				if (record1.getR0760_validated_discounted_cashflows() != null) {
					R0760cell13.setCellValue(record1.getR0760_validated_discounted_cashflows().doubleValue());
					R0760cell13.setCellStyle(numberStyle);
				} else {
					R0760cell13.setCellValue("");
					R0760cell13.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column O
				Cell R0760cell14 = row.createCell(14);
				if (record1.getR0760_pd() != null) {
					R0760cell14.setCellValue(record1.getR0760_pd().doubleValue());
					R0760cell14.setCellStyle(numberStyle);
				} else {
					R0760cell14.setCellValue("");
					R0760cell14.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column P
				Cell R0760cell15 = row.createCell(15);
				if (record1.getR0760_lgd() != null) {
					R0760cell15.setCellValue(record1.getR0760_lgd().doubleValue());
					R0760cell15.setCellStyle(numberStyle);
				} else {
					R0760cell15.setCellValue("");
					R0760cell15.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column Q
				Cell R0760cell16 = row.createCell(16);
				if (record1.getR0760_provisions_charged_pnl() != null) {
					R0760cell16.setCellValue(record1.getR0760_provisions_charged_pnl().doubleValue());
					R0760cell16.setCellStyle(numberStyle);
				} else {
					R0760cell16.setCellValue("");
					R0760cell16.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column R
				Cell R0760cell17 = row.createCell(17);
				if (record1.getR0760_legacy_interest_profit_suspense() != null) {
					R0760cell17.setCellValue(record1.getR0760_legacy_interest_profit_suspense().doubleValue());
					R0760cell17.setCellStyle(numberStyle);
				} else {
					R0760cell17.setCellValue("");
					R0760cell17.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column S
				Cell R0760cell18 = row.createCell(18);
				if (record1.getR0760_legal_case_yn() != null && !record1.getR0760_legal_case_yn().isEmpty()) {
					R0760cell18.setCellValue(record1.getR0760_legal_case_yn());
					R0760cell18.setCellStyle(textStyle);
				} else {
					R0760cell18.setCellValue("");
					R0760cell18.setCellStyle(textStyle);
				}

				/// ROW84
				//// Column T
				Cell R0760cell19 = row.createCell(19);
				if (record1.getR0760_remarks_if_any() != null && !record1.getR0760_remarks_if_any().isEmpty()) {
					R0760cell19.setCellValue(record1.getR0760_remarks_if_any());
					R0760cell19.setCellStyle(textStyle);
				} else {
					R0760cell19.setCellValue("");
					R0760cell19.setCellStyle(textStyle);
				}

				/// ROW85
				row = sheet.getRow(84);
				//// Column D
				Cell R0770cell3 = row.createCell(3);
				if (record1.getR0770_borrower_name() != null && !record1.getR0770_borrower_name().isEmpty()) {
					R0770cell3.setCellValue(record1.getR0770_borrower_name());
					R0770cell3.setCellStyle(textStyle);
				} else {
					R0770cell3.setCellValue("");
					R0770cell3.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column E
				Cell R0770cell4 = row.createCell(4);
				if (record1.getR0770_group_name_if_applicable() != null
						&& !record1.getR0770_group_name_if_applicable().isEmpty()) {
					R0770cell4.setCellValue(record1.getR0770_group_name_if_applicable());
					R0770cell4.setCellStyle(textStyle);
				} else {
					R0770cell4.setCellValue("");
					R0770cell4.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column F
				Cell R0770cell5 = row.createCell(5);
				if (record1.getR0770_cin() != null && !record1.getR0770_cin().isEmpty()) {
					R0770cell5.setCellValue(record1.getR0770_cin());
					R0770cell5.setCellStyle(textStyle);
				} else {
					R0770cell5.setCellValue("");
					R0770cell5.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column G
				Cell R0770cell6 = row.createCell(6);
				if (record1.getR0770_domicile_country() != null
						&& !record1.getR0770_domicile_country().isEmpty()) {
					R0770cell6.setCellValue(record1.getR0770_domicile_country());
					R0770cell6.setCellStyle(textStyle);
				} else {
					R0770cell6.setCellValue("");
					R0770cell6.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column H
				Cell R0770cell7 = row.createCell(7);
				if (record1.getR0770_funded_outstanding_amount() != null) {
					R0770cell7.setCellValue(record1.getR0770_funded_outstanding_amount().doubleValue());
					R0770cell7.setCellStyle(numberStyle);
				} else {
					R0770cell7.setCellValue("");
					R0770cell7.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column I
				Cell R0770cell8 = row.createCell(8);
				if (record1.getR0770_ccf_unfunded_outstanding_amount() != null) {
					R0770cell8.setCellValue(record1.getR0770_ccf_unfunded_outstanding_amount().doubleValue());
					R0770cell8.setCellStyle(numberStyle);
				} else {
					R0770cell8.setCellValue("");
					R0770cell8.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column J
				Cell R0770cell9 = row.createCell(9);
				if (record1.getR0770_secured_portion_exposure() != null) {
					R0770cell9.setCellValue(record1.getR0770_secured_portion_exposure().doubleValue());
					R0770cell9.setCellStyle(numberStyle);
				} else {
					R0770cell9.setCellValue("");
					R0770cell9.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column K
				Cell R0770cell10 = row.createCell(10);
				if (record1.getR0770_post_collateral_haircut() != null) {
					R0770cell10.setCellValue(record1.getR0770_post_collateral_haircut().doubleValue());
					R0770cell10.setCellStyle(numberStyle);
				} else {
					R0770cell10.setCellValue("");
					R0770cell10.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column L
				Cell R0770cell11 = row.createCell(11);
				if (record1.getR0770_type_of_security() != null) {
					R0770cell11.setCellValue(record1.getR0770_type_of_security().doubleValue());
					R0770cell11.setCellStyle(numberStyle);
				} else {
					R0770cell11.setCellValue("");
					R0770cell11.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column M
				Cell R0770cell12 = row.createCell(12);
				if (record1.getR0770_discounted_collateral_value() != null) {
					R0770cell12.setCellValue(record1.getR0770_discounted_collateral_value().doubleValue());
					R0770cell12.setCellStyle(numberStyle);
				} else {
					R0770cell12.setCellValue("");
					R0770cell12.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column N
				Cell R0770cell13 = row.createCell(13);
				if (record1.getR0770_validated_discounted_cashflows() != null) {
					R0770cell13.setCellValue(record1.getR0770_validated_discounted_cashflows().doubleValue());
					R0770cell13.setCellStyle(numberStyle);
				} else {
					R0770cell13.setCellValue("");
					R0770cell13.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column O
				Cell R0770cell14 = row.createCell(14);
				if (record1.getR0770_pd() != null) {
					R0770cell14.setCellValue(record1.getR0770_pd().doubleValue());
					R0770cell14.setCellStyle(numberStyle);
				} else {
					R0770cell14.setCellValue("");
					R0770cell14.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column P
				Cell R0770cell15 = row.createCell(15);
				if (record1.getR0770_lgd() != null) {
					R0770cell15.setCellValue(record1.getR0770_lgd().doubleValue());
					R0770cell15.setCellStyle(numberStyle);
				} else {
					R0770cell15.setCellValue("");
					R0770cell15.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column Q
				Cell R0770cell16 = row.createCell(16);
				if (record1.getR0770_provisions_charged_pnl() != null) {
					R0770cell16.setCellValue(record1.getR0770_provisions_charged_pnl().doubleValue());
					R0770cell16.setCellStyle(numberStyle);
				} else {
					R0770cell16.setCellValue("");
					R0770cell16.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column R
				Cell R0770cell17 = row.createCell(17);
				if (record1.getR0770_legacy_interest_profit_suspense() != null) {
					R0770cell17.setCellValue(record1.getR0770_legacy_interest_profit_suspense().doubleValue());
					R0770cell17.setCellStyle(numberStyle);
				} else {
					R0770cell17.setCellValue("");
					R0770cell17.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column S
				Cell R0770cell18 = row.createCell(18);
				if (record1.getR0770_legal_case_yn() != null && !record1.getR0770_legal_case_yn().isEmpty()) {
					R0770cell18.setCellValue(record1.getR0770_legal_case_yn());
					R0770cell18.setCellStyle(textStyle);
				} else {
					R0770cell18.setCellValue("");
					R0770cell18.setCellStyle(textStyle);
				}

				/// ROW85
				//// Column T
				Cell R0770cell19 = row.createCell(19);
				if (record1.getR0770_remarks_if_any() != null && !record1.getR0770_remarks_if_any().isEmpty()) {
					R0770cell19.setCellValue(record1.getR0770_remarks_if_any());
					R0770cell19.setCellStyle(textStyle);
				} else {
					R0770cell19.setCellValue("");
					R0770cell19.setCellStyle(textStyle);
				}

				/// ROW86
				row = sheet.getRow(85);
				//// Column D
				Cell R0780cell3 = row.createCell(3);
				if (record1.getR0780_borrower_name() != null && !record1.getR0780_borrower_name().isEmpty()) {
					R0780cell3.setCellValue(record1.getR0780_borrower_name());
					R0780cell3.setCellStyle(textStyle);
				} else {
					R0780cell3.setCellValue("");
					R0780cell3.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column E
				Cell R0780cell4 = row.createCell(4);
				if (record1.getR0780_group_name_if_applicable() != null
						&& !record1.getR0780_group_name_if_applicable().isEmpty()) {
					R0780cell4.setCellValue(record1.getR0780_group_name_if_applicable());
					R0780cell4.setCellStyle(textStyle);
				} else {
					R0780cell4.setCellValue("");
					R0780cell4.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column F
				Cell R0780cell5 = row.createCell(5);
				if (record1.getR0780_cin() != null && !record1.getR0780_cin().isEmpty()) {
					R0780cell5.setCellValue(record1.getR0780_cin());
					R0780cell5.setCellStyle(textStyle);
				} else {
					R0780cell5.setCellValue("");
					R0780cell5.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column G
				Cell R0780cell6 = row.createCell(6);
				if (record1.getR0780_domicile_country() != null
						&& !record1.getR0780_domicile_country().isEmpty()) {
					R0780cell6.setCellValue(record1.getR0780_domicile_country());
					R0780cell6.setCellStyle(textStyle);
				} else {
					R0780cell6.setCellValue("");
					R0780cell6.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column H
				Cell R0780cell7 = row.createCell(7);
				if (record1.getR0780_funded_outstanding_amount() != null) {
					R0780cell7.setCellValue(record1.getR0780_funded_outstanding_amount().doubleValue());
					R0780cell7.setCellStyle(numberStyle);
				} else {
					R0780cell7.setCellValue("");
					R0780cell7.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column I
				Cell R0780cell8 = row.createCell(8);
				if (record1.getR0780_ccf_unfunded_outstanding_amount() != null) {
					R0780cell8.setCellValue(record1.getR0780_ccf_unfunded_outstanding_amount().doubleValue());
					R0780cell8.setCellStyle(numberStyle);
				} else {
					R0780cell8.setCellValue("");
					R0780cell8.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column J
				Cell R0780cell9 = row.createCell(9);
				if (record1.getR0780_secured_portion_exposure() != null) {
					R0780cell9.setCellValue(record1.getR0780_secured_portion_exposure().doubleValue());
					R0780cell9.setCellStyle(numberStyle);
				} else {
					R0780cell9.setCellValue("");
					R0780cell9.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column K
				Cell R0780cell10 = row.createCell(10);
				if (record1.getR0780_post_collateral_haircut() != null) {
					R0780cell10.setCellValue(record1.getR0780_post_collateral_haircut().doubleValue());
					R0780cell10.setCellStyle(numberStyle);
				} else {
					R0780cell10.setCellValue("");
					R0780cell10.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column L
				Cell R0780cell11 = row.createCell(11);
				if (record1.getR0780_type_of_security() != null) {
					R0780cell11.setCellValue(record1.getR0780_type_of_security().doubleValue());
					R0780cell11.setCellStyle(numberStyle);
				} else {
					R0780cell11.setCellValue("");
					R0780cell11.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column M
				Cell R0780cell12 = row.createCell(12);
				if (record1.getR0780_discounted_collateral_value() != null) {
					R0780cell12.setCellValue(record1.getR0780_discounted_collateral_value().doubleValue());
					R0780cell12.setCellStyle(numberStyle);
				} else {
					R0780cell12.setCellValue("");
					R0780cell12.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column N
				Cell R0780cell13 = row.createCell(13);
				if (record1.getR0780_validated_discounted_cashflows() != null) {
					R0780cell13.setCellValue(record1.getR0780_validated_discounted_cashflows().doubleValue());
					R0780cell13.setCellStyle(numberStyle);
				} else {
					R0780cell13.setCellValue("");
					R0780cell13.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column O
				Cell R0780cell14 = row.createCell(14);
				if (record1.getR0780_pd() != null) {
					R0780cell14.setCellValue(record1.getR0780_pd().doubleValue());
					R0780cell14.setCellStyle(numberStyle);
				} else {
					R0780cell14.setCellValue("");
					R0780cell14.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column P
				Cell R0780cell15 = row.createCell(15);
				if (record1.getR0780_lgd() != null) {
					R0780cell15.setCellValue(record1.getR0780_lgd().doubleValue());
					R0780cell15.setCellStyle(numberStyle);
				} else {
					R0780cell15.setCellValue("");
					R0780cell15.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column Q
				Cell R0780cell16 = row.createCell(16);
				if (record1.getR0780_provisions_charged_pnl() != null) {
					R0780cell16.setCellValue(record1.getR0780_provisions_charged_pnl().doubleValue());
					R0780cell16.setCellStyle(numberStyle);
				} else {
					R0780cell16.setCellValue("");
					R0780cell16.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column R
				Cell R0780cell17 = row.createCell(17);
				if (record1.getR0780_legacy_interest_profit_suspense() != null) {
					R0780cell17.setCellValue(record1.getR0780_legacy_interest_profit_suspense().doubleValue());
					R0780cell17.setCellStyle(numberStyle);
				} else {
					R0780cell17.setCellValue("");
					R0780cell17.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column S
				Cell R0780cell18 = row.createCell(18);
				if (record1.getR0780_legal_case_yn() != null && !record1.getR0780_legal_case_yn().isEmpty()) {
					R0780cell18.setCellValue(record1.getR0780_legal_case_yn());
					R0780cell18.setCellStyle(textStyle);
				} else {
					R0780cell18.setCellValue("");
					R0780cell18.setCellStyle(textStyle);
				}

				/// ROW86
				//// Column T
				Cell R0780cell19 = row.createCell(19);
				if (record1.getR0780_remarks_if_any() != null && !record1.getR0780_remarks_if_any().isEmpty()) {
					R0780cell19.setCellValue(record1.getR0780_remarks_if_any());
					R0780cell19.setCellStyle(textStyle);
				} else {
					R0780cell19.setCellValue("");
					R0780cell19.setCellStyle(textStyle);
				}

				/// ROW87
				row = sheet.getRow(86);
				//// Column D
				Cell R0790cell3 = row.createCell(3);
				if (record1.getR0790_borrower_name() != null && !record1.getR0790_borrower_name().isEmpty()) {
					R0790cell3.setCellValue(record1.getR0790_borrower_name());
					R0790cell3.setCellStyle(textStyle);
				} else {
					R0790cell3.setCellValue("");
					R0790cell3.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column E
				Cell R0790cell4 = row.createCell(4);
				if (record1.getR0790_group_name_if_applicable() != null
						&& !record1.getR0790_group_name_if_applicable().isEmpty()) {
					R0790cell4.setCellValue(record1.getR0790_group_name_if_applicable());
					R0790cell4.setCellStyle(textStyle);
				} else {
					R0790cell4.setCellValue("");
					R0790cell4.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column F
				Cell R0790cell5 = row.createCell(5);
				if (record1.getR0790_cin() != null && !record1.getR0790_cin().isEmpty()) {
					R0790cell5.setCellValue(record1.getR0790_cin());
					R0790cell5.setCellStyle(textStyle);
				} else {
					R0790cell5.setCellValue("");
					R0790cell5.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column G
				Cell R0790cell6 = row.createCell(6);
				if (record1.getR0790_domicile_country() != null
						&& !record1.getR0790_domicile_country().isEmpty()) {
					R0790cell6.setCellValue(record1.getR0790_domicile_country());
					R0790cell6.setCellStyle(textStyle);
				} else {
					R0790cell6.setCellValue("");
					R0790cell6.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column H
				Cell R0790cell7 = row.createCell(7);
				if (record1.getR0790_funded_outstanding_amount() != null) {
					R0790cell7.setCellValue(record1.getR0790_funded_outstanding_amount().doubleValue());
					R0790cell7.setCellStyle(numberStyle);
				} else {
					R0790cell7.setCellValue("");
					R0790cell7.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column I
				Cell R0790cell8 = row.createCell(8);
				if (record1.getR0790_ccf_unfunded_outstanding_amount() != null) {
					R0790cell8.setCellValue(record1.getR0790_ccf_unfunded_outstanding_amount().doubleValue());
					R0790cell8.setCellStyle(numberStyle);
				} else {
					R0790cell8.setCellValue("");
					R0790cell8.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column J
				Cell R0790cell9 = row.createCell(9);
				if (record1.getR0790_secured_portion_exposure() != null) {
					R0790cell9.setCellValue(record1.getR0790_secured_portion_exposure().doubleValue());
					R0790cell9.setCellStyle(numberStyle);
				} else {
					R0790cell9.setCellValue("");
					R0790cell9.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column K
				Cell R0790cell10 = row.createCell(10);
				if (record1.getR0790_post_collateral_haircut() != null) {
					R0790cell10.setCellValue(record1.getR0790_post_collateral_haircut().doubleValue());
					R0790cell10.setCellStyle(numberStyle);
				} else {
					R0790cell10.setCellValue("");
					R0790cell10.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column L
				Cell R0790cell11 = row.createCell(11);
				if (record1.getR0790_type_of_security() != null) {
					R0790cell11.setCellValue(record1.getR0790_type_of_security().doubleValue());
					R0790cell11.setCellStyle(numberStyle);
				} else {
					R0790cell11.setCellValue("");
					R0790cell11.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column M
				Cell R0790cell12 = row.createCell(12);
				if (record1.getR0790_discounted_collateral_value() != null) {
					R0790cell12.setCellValue(record1.getR0790_discounted_collateral_value().doubleValue());
					R0790cell12.setCellStyle(numberStyle);
				} else {
					R0790cell12.setCellValue("");
					R0790cell12.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column N
				Cell R0790cell13 = row.createCell(13);
				if (record1.getR0790_validated_discounted_cashflows() != null) {
					R0790cell13.setCellValue(record1.getR0790_validated_discounted_cashflows().doubleValue());
					R0790cell13.setCellStyle(numberStyle);
				} else {
					R0790cell13.setCellValue("");
					R0790cell13.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column O
				Cell R0790cell14 = row.createCell(14);
				if (record1.getR0790_pd() != null) {
					R0790cell14.setCellValue(record1.getR0790_pd().doubleValue());
					R0790cell14.setCellStyle(numberStyle);
				} else {
					R0790cell14.setCellValue("");
					R0790cell14.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column P
				Cell R0790cell15 = row.createCell(15);
				if (record1.getR0790_lgd() != null) {
					R0790cell15.setCellValue(record1.getR0790_lgd().doubleValue());
					R0790cell15.setCellStyle(numberStyle);
				} else {
					R0790cell15.setCellValue("");
					R0790cell15.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column Q
				Cell R0790cell16 = row.createCell(16);
				if (record1.getR0790_provisions_charged_pnl() != null) {
					R0790cell16.setCellValue(record1.getR0790_provisions_charged_pnl().doubleValue());
					R0790cell16.setCellStyle(numberStyle);
				} else {
					R0790cell16.setCellValue("");
					R0790cell16.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column R
				Cell R0790cell17 = row.createCell(17);
				if (record1.getR0790_legacy_interest_profit_suspense() != null) {
					R0790cell17.setCellValue(record1.getR0790_legacy_interest_profit_suspense().doubleValue());
					R0790cell17.setCellStyle(numberStyle);
				} else {
					R0790cell17.setCellValue("");
					R0790cell17.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column S
				Cell R0790cell18 = row.createCell(18);
				if (record1.getR0790_legal_case_yn() != null && !record1.getR0790_legal_case_yn().isEmpty()) {
					R0790cell18.setCellValue(record1.getR0790_legal_case_yn());
					R0790cell18.setCellStyle(textStyle);
				} else {
					R0790cell18.setCellValue("");
					R0790cell18.setCellStyle(textStyle);
				}

				/// ROW87
				//// Column T
				Cell R0790cell19 = row.createCell(19);
				if (record1.getR0790_remarks_if_any() != null && !record1.getR0790_remarks_if_any().isEmpty()) {
					R0790cell19.setCellValue(record1.getR0790_remarks_if_any());
					R0790cell19.setCellStyle(textStyle);
				} else {
					R0790cell19.setCellValue("");
					R0790cell19.setCellStyle(textStyle);
				}

				/// ROW88
				row = sheet.getRow(87);
				//// Column D
				Cell R0800cell3 = row.createCell(3);
				if (record1.getR0800_borrower_name() != null && !record1.getR0800_borrower_name().isEmpty()) {
					R0800cell3.setCellValue(record1.getR0800_borrower_name());
					R0800cell3.setCellStyle(textStyle);
				} else {
					R0800cell3.setCellValue("");
					R0800cell3.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column E
				Cell R0800cell4 = row.createCell(4);
				if (record1.getR0800_group_name_if_applicable() != null
						&& !record1.getR0800_group_name_if_applicable().isEmpty()) {
					R0800cell4.setCellValue(record1.getR0800_group_name_if_applicable());
					R0800cell4.setCellStyle(textStyle);
				} else {
					R0800cell4.setCellValue("");
					R0800cell4.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column F
				Cell R0800cell5 = row.createCell(5);
				if (record1.getR0800_cin() != null && !record1.getR0800_cin().isEmpty()) {
					R0800cell5.setCellValue(record1.getR0800_cin());
					R0800cell5.setCellStyle(textStyle);
				} else {
					R0800cell5.setCellValue("");
					R0800cell5.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column G
				Cell R0800cell6 = row.createCell(6);
				if (record1.getR0800_domicile_country() != null
						&& !record1.getR0800_domicile_country().isEmpty()) {
					R0800cell6.setCellValue(record1.getR0800_domicile_country());
					R0800cell6.setCellStyle(textStyle);
				} else {
					R0800cell6.setCellValue("");
					R0800cell6.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column H
				Cell R0800cell7 = row.createCell(7);
				if (record1.getR0800_funded_outstanding_amount() != null) {
					R0800cell7.setCellValue(record1.getR0800_funded_outstanding_amount().doubleValue());
					R0800cell7.setCellStyle(numberStyle);
				} else {
					R0800cell7.setCellValue("");
					R0800cell7.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column I
				Cell R0800cell8 = row.createCell(8);
				if (record1.getR0800_ccf_unfunded_outstanding_amount() != null) {
					R0800cell8.setCellValue(record1.getR0800_ccf_unfunded_outstanding_amount().doubleValue());
					R0800cell8.setCellStyle(numberStyle);
				} else {
					R0800cell8.setCellValue("");
					R0800cell8.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column J
				Cell R0800cell9 = row.createCell(9);
				if (record1.getR0800_secured_portion_exposure() != null) {
					R0800cell9.setCellValue(record1.getR0800_secured_portion_exposure().doubleValue());
					R0800cell9.setCellStyle(numberStyle);
				} else {
					R0800cell9.setCellValue("");
					R0800cell9.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column K
				Cell R0800cell10 = row.createCell(10);
				if (record1.getR0800_post_collateral_haircut() != null) {
					R0800cell10.setCellValue(record1.getR0800_post_collateral_haircut().doubleValue());
					R0800cell10.setCellStyle(numberStyle);
				} else {
					R0800cell10.setCellValue("");
					R0800cell10.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column L
				Cell R0800cell11 = row.createCell(11);
				if (record1.getR0800_type_of_security() != null) {
					R0800cell11.setCellValue(record1.getR0800_type_of_security().doubleValue());
					R0800cell11.setCellStyle(numberStyle);
				} else {
					R0800cell11.setCellValue("");
					R0800cell11.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column M
				Cell R0800cell12 = row.createCell(12);
				if (record1.getR0800_discounted_collateral_value() != null) {
					R0800cell12.setCellValue(record1.getR0800_discounted_collateral_value().doubleValue());
					R0800cell12.setCellStyle(numberStyle);
				} else {
					R0800cell12.setCellValue("");
					R0800cell12.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column N
				Cell R0800cell13 = row.createCell(13);
				if (record1.getR0800_validated_discounted_cashflows() != null) {
					R0800cell13.setCellValue(record1.getR0800_validated_discounted_cashflows().doubleValue());
					R0800cell13.setCellStyle(numberStyle);
				} else {
					R0800cell13.setCellValue("");
					R0800cell13.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column O
				Cell R0800cell14 = row.createCell(14);
				if (record1.getR0800_pd() != null) {
					R0800cell14.setCellValue(record1.getR0800_pd().doubleValue());
					R0800cell14.setCellStyle(numberStyle);
				} else {
					R0800cell14.setCellValue("");
					R0800cell14.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column P
				Cell R0800cell15 = row.createCell(15);
				if (record1.getR0800_lgd() != null) {
					R0800cell15.setCellValue(record1.getR0800_lgd().doubleValue());
					R0800cell15.setCellStyle(numberStyle);
				} else {
					R0800cell15.setCellValue("");
					R0800cell15.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column Q
				Cell R0800cell16 = row.createCell(16);
				if (record1.getR0800_provisions_charged_pnl() != null) {
					R0800cell16.setCellValue(record1.getR0800_provisions_charged_pnl().doubleValue());
					R0800cell16.setCellStyle(numberStyle);
				} else {
					R0800cell16.setCellValue("");
					R0800cell16.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column R
				Cell R0800cell17 = row.createCell(17);
				if (record1.getR0800_legacy_interest_profit_suspense() != null) {
					R0800cell17.setCellValue(record1.getR0800_legacy_interest_profit_suspense().doubleValue());
					R0800cell17.setCellStyle(numberStyle);
				} else {
					R0800cell17.setCellValue("");
					R0800cell17.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column S
				Cell R0800cell18 = row.createCell(18);
				if (record1.getR0800_legal_case_yn() != null && !record1.getR0800_legal_case_yn().isEmpty()) {
					R0800cell18.setCellValue(record1.getR0800_legal_case_yn());
					R0800cell18.setCellStyle(textStyle);
				} else {
					R0800cell18.setCellValue("");
					R0800cell18.setCellStyle(textStyle);
				}

				/// ROW88
				//// Column T
				Cell R0800cell19 = row.createCell(19);
				if (record1.getR0800_remarks_if_any() != null && !record1.getR0800_remarks_if_any().isEmpty()) {
					R0800cell19.setCellValue(record1.getR0800_remarks_if_any());
					R0800cell19.setCellStyle(textStyle);
				} else {
					R0800cell19.setCellValue("");
					R0800cell19.setCellStyle(textStyle);
				}

				/// ROW89
				row = sheet.getRow(88);
				//// Column D
				Cell R0810cell3 = row.createCell(3);
				if (record1.getR0810_borrower_name() != null && !record1.getR0810_borrower_name().isEmpty()) {
					R0810cell3.setCellValue(record1.getR0810_borrower_name());
					R0810cell3.setCellStyle(textStyle);
				} else {
					R0810cell3.setCellValue("");
					R0810cell3.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column E
				Cell R0810cell4 = row.createCell(4);
				if (record1.getR0810_group_name_if_applicable() != null
						&& !record1.getR0810_group_name_if_applicable().isEmpty()) {
					R0810cell4.setCellValue(record1.getR0810_group_name_if_applicable());
					R0810cell4.setCellStyle(textStyle);
				} else {
					R0810cell4.setCellValue("");
					R0810cell4.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column F
				Cell R0810cell5 = row.createCell(5);
				if (record1.getR0810_cin() != null && !record1.getR0810_cin().isEmpty()) {
					R0810cell5.setCellValue(record1.getR0810_cin());
					R0810cell5.setCellStyle(textStyle);
				} else {
					R0810cell5.setCellValue("");
					R0810cell5.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column G
				Cell R0810cell6 = row.createCell(6);
				if (record1.getR0810_domicile_country() != null
						&& !record1.getR0810_domicile_country().isEmpty()) {
					R0810cell6.setCellValue(record1.getR0810_domicile_country());
					R0810cell6.setCellStyle(textStyle);
				} else {
					R0810cell6.setCellValue("");
					R0810cell6.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column H
				Cell R0810cell7 = row.createCell(7);
				if (record1.getR0810_funded_outstanding_amount() != null) {
					R0810cell7.setCellValue(record1.getR0810_funded_outstanding_amount().doubleValue());
					R0810cell7.setCellStyle(numberStyle);
				} else {
					R0810cell7.setCellValue("");
					R0810cell7.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column I
				Cell R0810cell8 = row.createCell(8);
				if (record1.getR0810_ccf_unfunded_outstanding_amount() != null) {
					R0810cell8.setCellValue(record1.getR0810_ccf_unfunded_outstanding_amount().doubleValue());
					R0810cell8.setCellStyle(numberStyle);
				} else {
					R0810cell8.setCellValue("");
					R0810cell8.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column J
				Cell R0810cell9 = row.createCell(9);
				if (record1.getR0810_secured_portion_exposure() != null) {
					R0810cell9.setCellValue(record1.getR0810_secured_portion_exposure().doubleValue());
					R0810cell9.setCellStyle(numberStyle);
				} else {
					R0810cell9.setCellValue("");
					R0810cell9.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column K
				Cell R0810cell10 = row.createCell(10);
				if (record1.getR0810_post_collateral_haircut() != null) {
					R0810cell10.setCellValue(record1.getR0810_post_collateral_haircut().doubleValue());
					R0810cell10.setCellStyle(numberStyle);
				} else {
					R0810cell10.setCellValue("");
					R0810cell10.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column L
				Cell R0810cell11 = row.createCell(11);
				if (record1.getR0810_type_of_security() != null) {
					R0810cell11.setCellValue(record1.getR0810_type_of_security().doubleValue());
					R0810cell11.setCellStyle(numberStyle);
				} else {
					R0810cell11.setCellValue("");
					R0810cell11.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column M
				Cell R0810cell12 = row.createCell(12);
				if (record1.getR0810_discounted_collateral_value() != null) {
					R0810cell12.setCellValue(record1.getR0810_discounted_collateral_value().doubleValue());
					R0810cell12.setCellStyle(numberStyle);
				} else {
					R0810cell12.setCellValue("");
					R0810cell12.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column N
				Cell R0810cell13 = row.createCell(13);
				if (record1.getR0810_validated_discounted_cashflows() != null) {
					R0810cell13.setCellValue(record1.getR0810_validated_discounted_cashflows().doubleValue());
					R0810cell13.setCellStyle(numberStyle);
				} else {
					R0810cell13.setCellValue("");
					R0810cell13.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column O
				Cell R0810cell14 = row.createCell(14);
				if (record1.getR0810_pd() != null) {
					R0810cell14.setCellValue(record1.getR0810_pd().doubleValue());
					R0810cell14.setCellStyle(numberStyle);
				} else {
					R0810cell14.setCellValue("");
					R0810cell14.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column P
				Cell R0810cell15 = row.createCell(15);
				if (record1.getR0810_lgd() != null) {
					R0810cell15.setCellValue(record1.getR0810_lgd().doubleValue());
					R0810cell15.setCellStyle(numberStyle);
				} else {
					R0810cell15.setCellValue("");
					R0810cell15.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column Q
				Cell R0810cell16 = row.createCell(16);
				if (record1.getR0810_provisions_charged_pnl() != null) {
					R0810cell16.setCellValue(record1.getR0810_provisions_charged_pnl().doubleValue());
					R0810cell16.setCellStyle(numberStyle);
				} else {
					R0810cell16.setCellValue("");
					R0810cell16.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column R
				Cell R0810cell17 = row.createCell(17);
				if (record1.getR0810_legacy_interest_profit_suspense() != null) {
					R0810cell17.setCellValue(record1.getR0810_legacy_interest_profit_suspense().doubleValue());
					R0810cell17.setCellStyle(numberStyle);
				} else {
					R0810cell17.setCellValue("");
					R0810cell17.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column S
				Cell R0810cell18 = row.createCell(18);
				if (record1.getR0810_legal_case_yn() != null && !record1.getR0810_legal_case_yn().isEmpty()) {
					R0810cell18.setCellValue(record1.getR0810_legal_case_yn());
					R0810cell18.setCellStyle(textStyle);
				} else {
					R0810cell18.setCellValue("");
					R0810cell18.setCellStyle(textStyle);
				}

				/// ROW89
				//// Column T
				Cell R0810cell19 = row.createCell(19);
				if (record1.getR0810_remarks_if_any() != null && !record1.getR0810_remarks_if_any().isEmpty()) {
					R0810cell19.setCellValue(record1.getR0810_remarks_if_any());
					R0810cell19.setCellStyle(textStyle);
				} else {
					R0810cell19.setCellValue("");
					R0810cell19.setCellStyle(textStyle);
				}

				/// ROW90
				row = sheet.getRow(89);
				//// Column D
				Cell R0820cell3 = row.createCell(3);
				if (record1.getR0820_borrower_name() != null && !record1.getR0820_borrower_name().isEmpty()) {
					R0820cell3.setCellValue(record1.getR0820_borrower_name());
					R0820cell3.setCellStyle(textStyle);
				} else {
					R0820cell3.setCellValue("");
					R0820cell3.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column E
				Cell R0820cell4 = row.createCell(4);
				if (record1.getR0820_group_name_if_applicable() != null
						&& !record1.getR0820_group_name_if_applicable().isEmpty()) {
					R0820cell4.setCellValue(record1.getR0820_group_name_if_applicable());
					R0820cell4.setCellStyle(textStyle);
				} else {
					R0820cell4.setCellValue("");
					R0820cell4.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column F
				Cell R0820cell5 = row.createCell(5);
				if (record1.getR0820_cin() != null && !record1.getR0820_cin().isEmpty()) {
					R0820cell5.setCellValue(record1.getR0820_cin());
					R0820cell5.setCellStyle(textStyle);
				} else {
					R0820cell5.setCellValue("");
					R0820cell5.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column G
				Cell R0820cell6 = row.createCell(6);
				if (record1.getR0820_domicile_country() != null
						&& !record1.getR0820_domicile_country().isEmpty()) {
					R0820cell6.setCellValue(record1.getR0820_domicile_country());
					R0820cell6.setCellStyle(textStyle);
				} else {
					R0820cell6.setCellValue("");
					R0820cell6.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column H
				Cell R0820cell7 = row.createCell(7);
				if (record1.getR0820_funded_outstanding_amount() != null) {
					R0820cell7.setCellValue(record1.getR0820_funded_outstanding_amount().doubleValue());
					R0820cell7.setCellStyle(numberStyle);
				} else {
					R0820cell7.setCellValue("");
					R0820cell7.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column I
				Cell R0820cell8 = row.createCell(8);
				if (record1.getR0820_ccf_unfunded_outstanding_amount() != null) {
					R0820cell8.setCellValue(record1.getR0820_ccf_unfunded_outstanding_amount().doubleValue());
					R0820cell8.setCellStyle(numberStyle);
				} else {
					R0820cell8.setCellValue("");
					R0820cell8.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column J
				Cell R0820cell9 = row.createCell(9);
				if (record1.getR0820_secured_portion_exposure() != null) {
					R0820cell9.setCellValue(record1.getR0820_secured_portion_exposure().doubleValue());
					R0820cell9.setCellStyle(numberStyle);
				} else {
					R0820cell9.setCellValue("");
					R0820cell9.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column K
				Cell R0820cell10 = row.createCell(10);
				if (record1.getR0820_post_collateral_haircut() != null) {
					R0820cell10.setCellValue(record1.getR0820_post_collateral_haircut().doubleValue());
					R0820cell10.setCellStyle(numberStyle);
				} else {
					R0820cell10.setCellValue("");
					R0820cell10.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column L
				Cell R0820cell11 = row.createCell(11);
				if (record1.getR0820_type_of_security() != null) {
					R0820cell11.setCellValue(record1.getR0820_type_of_security().doubleValue());
					R0820cell11.setCellStyle(numberStyle);
				} else {
					R0820cell11.setCellValue("");
					R0820cell11.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column M
				Cell R0820cell12 = row.createCell(12);
				if (record1.getR0820_discounted_collateral_value() != null) {
					R0820cell12.setCellValue(record1.getR0820_discounted_collateral_value().doubleValue());
					R0820cell12.setCellStyle(numberStyle);
				} else {
					R0820cell12.setCellValue("");
					R0820cell12.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column N
				Cell R0820cell13 = row.createCell(13);
				if (record1.getR0820_validated_discounted_cashflows() != null) {
					R0820cell13.setCellValue(record1.getR0820_validated_discounted_cashflows().doubleValue());
					R0820cell13.setCellStyle(numberStyle);
				} else {
					R0820cell13.setCellValue("");
					R0820cell13.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column O
				Cell R0820cell14 = row.createCell(14);
				if (record1.getR0820_pd() != null) {
					R0820cell14.setCellValue(record1.getR0820_pd().doubleValue());
					R0820cell14.setCellStyle(numberStyle);
				} else {
					R0820cell14.setCellValue("");
					R0820cell14.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column P
				Cell R0820cell15 = row.createCell(15);
				if (record1.getR0820_lgd() != null) {
					R0820cell15.setCellValue(record1.getR0820_lgd().doubleValue());
					R0820cell15.setCellStyle(numberStyle);
				} else {
					R0820cell15.setCellValue("");
					R0820cell15.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column Q
				Cell R0820cell16 = row.createCell(16);
				if (record1.getR0820_provisions_charged_pnl() != null) {
					R0820cell16.setCellValue(record1.getR0820_provisions_charged_pnl().doubleValue());
					R0820cell16.setCellStyle(numberStyle);
				} else {
					R0820cell16.setCellValue("");
					R0820cell16.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column R
				Cell R0820cell17 = row.createCell(17);
				if (record1.getR0820_legacy_interest_profit_suspense() != null) {
					R0820cell17.setCellValue(record1.getR0820_legacy_interest_profit_suspense().doubleValue());
					R0820cell17.setCellStyle(numberStyle);
				} else {
					R0820cell17.setCellValue("");
					R0820cell17.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column S
				Cell R0820cell18 = row.createCell(18);
				if (record1.getR0820_legal_case_yn() != null && !record1.getR0820_legal_case_yn().isEmpty()) {
					R0820cell18.setCellValue(record1.getR0820_legal_case_yn());
					R0820cell18.setCellStyle(textStyle);
				} else {
					R0820cell18.setCellValue("");
					R0820cell18.setCellStyle(textStyle);
				}

				/// ROW90
				//// Column T
				Cell R0820cell19 = row.createCell(19);
				if (record1.getR0820_remarks_if_any() != null && !record1.getR0820_remarks_if_any().isEmpty()) {
					R0820cell19.setCellValue(record1.getR0820_remarks_if_any());
					R0820cell19.setCellStyle(textStyle);
				} else {
					R0820cell19.setCellValue("");
					R0820cell19.setCellStyle(textStyle);
				}

				/// ROW91
				row = sheet.getRow(90);
				//// Column D
				Cell R0830cell3 = row.createCell(3);
				if (record1.getR0830_borrower_name() != null && !record1.getR0830_borrower_name().isEmpty()) {
					R0830cell3.setCellValue(record1.getR0830_borrower_name());
					R0830cell3.setCellStyle(textStyle);
				} else {
					R0830cell3.setCellValue("");
					R0830cell3.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column E
				Cell R0830cell4 = row.createCell(4);
				if (record1.getR0830_group_name_if_applicable() != null
						&& !record1.getR0830_group_name_if_applicable().isEmpty()) {
					R0830cell4.setCellValue(record1.getR0830_group_name_if_applicable());
					R0830cell4.setCellStyle(textStyle);
				} else {
					R0830cell4.setCellValue("");
					R0830cell4.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column F
				Cell R0830cell5 = row.createCell(5);
				if (record1.getR0830_cin() != null && !record1.getR0830_cin().isEmpty()) {
					R0830cell5.setCellValue(record1.getR0830_cin());
					R0830cell5.setCellStyle(textStyle);
				} else {
					R0830cell5.setCellValue("");
					R0830cell5.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column G
				Cell R0830cell6 = row.createCell(6);
				if (record1.getR0830_domicile_country() != null
						&& !record1.getR0830_domicile_country().isEmpty()) {
					R0830cell6.setCellValue(record1.getR0830_domicile_country());
					R0830cell6.setCellStyle(textStyle);
				} else {
					R0830cell6.setCellValue("");
					R0830cell6.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column H
				Cell R0830cell7 = row.createCell(7);
				if (record1.getR0830_funded_outstanding_amount() != null) {
					R0830cell7.setCellValue(record1.getR0830_funded_outstanding_amount().doubleValue());
					R0830cell7.setCellStyle(numberStyle);
				} else {
					R0830cell7.setCellValue("");
					R0830cell7.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column I
				Cell R0830cell8 = row.createCell(8);
				if (record1.getR0830_ccf_unfunded_outstanding_amount() != null) {
					R0830cell8.setCellValue(record1.getR0830_ccf_unfunded_outstanding_amount().doubleValue());
					R0830cell8.setCellStyle(numberStyle);
				} else {
					R0830cell8.setCellValue("");
					R0830cell8.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column J
				Cell R0830cell9 = row.createCell(9);
				if (record1.getR0830_secured_portion_exposure() != null) {
					R0830cell9.setCellValue(record1.getR0830_secured_portion_exposure().doubleValue());
					R0830cell9.setCellStyle(numberStyle);
				} else {
					R0830cell9.setCellValue("");
					R0830cell9.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column K
				Cell R0830cell10 = row.createCell(10);
				if (record1.getR0830_post_collateral_haircut() != null) {
					R0830cell10.setCellValue(record1.getR0830_post_collateral_haircut().doubleValue());
					R0830cell10.setCellStyle(numberStyle);
				} else {
					R0830cell10.setCellValue("");
					R0830cell10.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column L
				Cell R0830cell11 = row.createCell(11);
				if (record1.getR0830_type_of_security() != null) {
					R0830cell11.setCellValue(record1.getR0830_type_of_security().doubleValue());
					R0830cell11.setCellStyle(numberStyle);
				} else {
					R0830cell11.setCellValue("");
					R0830cell11.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column M
				Cell R0830cell12 = row.createCell(12);
				if (record1.getR0830_discounted_collateral_value() != null) {
					R0830cell12.setCellValue(record1.getR0830_discounted_collateral_value().doubleValue());
					R0830cell12.setCellStyle(numberStyle);
				} else {
					R0830cell12.setCellValue("");
					R0830cell12.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column N
				Cell R0830cell13 = row.createCell(13);
				if (record1.getR0830_validated_discounted_cashflows() != null) {
					R0830cell13.setCellValue(record1.getR0830_validated_discounted_cashflows().doubleValue());
					R0830cell13.setCellStyle(numberStyle);
				} else {
					R0830cell13.setCellValue("");
					R0830cell13.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column O
				Cell R0830cell14 = row.createCell(14);
				if (record1.getR0830_pd() != null) {
					R0830cell14.setCellValue(record1.getR0830_pd().doubleValue());
					R0830cell14.setCellStyle(numberStyle);
				} else {
					R0830cell14.setCellValue("");
					R0830cell14.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column P
				Cell R0830cell15 = row.createCell(15);
				if (record1.getR0830_lgd() != null) {
					R0830cell15.setCellValue(record1.getR0830_lgd().doubleValue());
					R0830cell15.setCellStyle(numberStyle);
				} else {
					R0830cell15.setCellValue("");
					R0830cell15.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column Q
				Cell R0830cell16 = row.createCell(16);
				if (record1.getR0830_provisions_charged_pnl() != null) {
					R0830cell16.setCellValue(record1.getR0830_provisions_charged_pnl().doubleValue());
					R0830cell16.setCellStyle(numberStyle);
				} else {
					R0830cell16.setCellValue("");
					R0830cell16.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column R
				Cell R0830cell17 = row.createCell(17);
				if (record1.getR0830_legacy_interest_profit_suspense() != null) {
					R0830cell17.setCellValue(record1.getR0830_legacy_interest_profit_suspense().doubleValue());
					R0830cell17.setCellStyle(numberStyle);
				} else {
					R0830cell17.setCellValue("");
					R0830cell17.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column S
				Cell R0830cell18 = row.createCell(18);
				if (record1.getR0830_legal_case_yn() != null && !record1.getR0830_legal_case_yn().isEmpty()) {
					R0830cell18.setCellValue(record1.getR0830_legal_case_yn());
					R0830cell18.setCellStyle(textStyle);
				} else {
					R0830cell18.setCellValue("");
					R0830cell18.setCellStyle(textStyle);
				}

				/// ROW91
				//// Column T
				Cell R0830cell19 = row.createCell(19);
				if (record1.getR0830_remarks_if_any() != null && !record1.getR0830_remarks_if_any().isEmpty()) {
					R0830cell19.setCellValue(record1.getR0830_remarks_if_any());
					R0830cell19.setCellStyle(textStyle);
				} else {
					R0830cell19.setCellValue("");
					R0830cell19.setCellStyle(textStyle);
				}

				/// ROW92
				row = sheet.getRow(91);
				//// Column D
				Cell R0840cell3 = row.createCell(3);
				if (record1.getR0840_borrower_name() != null && !record1.getR0840_borrower_name().isEmpty()) {
					R0840cell3.setCellValue(record1.getR0840_borrower_name());
					R0840cell3.setCellStyle(textStyle);
				} else {
					R0840cell3.setCellValue("");
					R0840cell3.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column E
				Cell R0840cell4 = row.createCell(4);
				if (record1.getR0840_group_name_if_applicable() != null
						&& !record1.getR0840_group_name_if_applicable().isEmpty()) {
					R0840cell4.setCellValue(record1.getR0840_group_name_if_applicable());
					R0840cell4.setCellStyle(textStyle);
				} else {
					R0840cell4.setCellValue("");
					R0840cell4.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column F
				Cell R0840cell5 = row.createCell(5);
				if (record1.getR0840_cin() != null && !record1.getR0840_cin().isEmpty()) {
					R0840cell5.setCellValue(record1.getR0840_cin());
					R0840cell5.setCellStyle(textStyle);
				} else {
					R0840cell5.setCellValue("");
					R0840cell5.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column G
				Cell R0840cell6 = row.createCell(6);
				if (record1.getR0840_domicile_country() != null
						&& !record1.getR0840_domicile_country().isEmpty()) {
					R0840cell6.setCellValue(record1.getR0840_domicile_country());
					R0840cell6.setCellStyle(textStyle);
				} else {
					R0840cell6.setCellValue("");
					R0840cell6.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column H
				Cell R0840cell7 = row.createCell(7);
				if (record1.getR0840_funded_outstanding_amount() != null) {
					R0840cell7.setCellValue(record1.getR0840_funded_outstanding_amount().doubleValue());
					R0840cell7.setCellStyle(numberStyle);
				} else {
					R0840cell7.setCellValue("");
					R0840cell7.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column I
				Cell R0840cell8 = row.createCell(8);
				if (record1.getR0840_ccf_unfunded_outstanding_amount() != null) {
					R0840cell8.setCellValue(record1.getR0840_ccf_unfunded_outstanding_amount().doubleValue());
					R0840cell8.setCellStyle(numberStyle);
				} else {
					R0840cell8.setCellValue("");
					R0840cell8.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column J
				Cell R0840cell9 = row.createCell(9);
				if (record1.getR0840_secured_portion_exposure() != null) {
					R0840cell9.setCellValue(record1.getR0840_secured_portion_exposure().doubleValue());
					R0840cell9.setCellStyle(numberStyle);
				} else {
					R0840cell9.setCellValue("");
					R0840cell9.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column K
				Cell R0840cell10 = row.createCell(10);
				if (record1.getR0840_post_collateral_haircut() != null) {
					R0840cell10.setCellValue(record1.getR0840_post_collateral_haircut().doubleValue());
					R0840cell10.setCellStyle(numberStyle);
				} else {
					R0840cell10.setCellValue("");
					R0840cell10.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column L
				Cell R0840cell11 = row.createCell(11);
				if (record1.getR0840_type_of_security() != null) {
					R0840cell11.setCellValue(record1.getR0840_type_of_security().doubleValue());
					R0840cell11.setCellStyle(numberStyle);
				} else {
					R0840cell11.setCellValue("");
					R0840cell11.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column M
				Cell R0840cell12 = row.createCell(12);
				if (record1.getR0840_discounted_collateral_value() != null) {
					R0840cell12.setCellValue(record1.getR0840_discounted_collateral_value().doubleValue());
					R0840cell12.setCellStyle(numberStyle);
				} else {
					R0840cell12.setCellValue("");
					R0840cell12.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column N
				Cell R0840cell13 = row.createCell(13);
				if (record1.getR0840_validated_discounted_cashflows() != null) {
					R0840cell13.setCellValue(record1.getR0840_validated_discounted_cashflows().doubleValue());
					R0840cell13.setCellStyle(numberStyle);
				} else {
					R0840cell13.setCellValue("");
					R0840cell13.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column O
				Cell R0840cell14 = row.createCell(14);
				if (record1.getR0840_pd() != null) {
					R0840cell14.setCellValue(record1.getR0840_pd().doubleValue());
					R0840cell14.setCellStyle(numberStyle);
				} else {
					R0840cell14.setCellValue("");
					R0840cell14.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column P
				Cell R0840cell15 = row.createCell(15);
				if (record1.getR0840_lgd() != null) {
					R0840cell15.setCellValue(record1.getR0840_lgd().doubleValue());
					R0840cell15.setCellStyle(numberStyle);
				} else {
					R0840cell15.setCellValue("");
					R0840cell15.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column Q
				Cell R0840cell16 = row.createCell(16);
				if (record1.getR0840_provisions_charged_pnl() != null) {
					R0840cell16.setCellValue(record1.getR0840_provisions_charged_pnl().doubleValue());
					R0840cell16.setCellStyle(numberStyle);
				} else {
					R0840cell16.setCellValue("");
					R0840cell16.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column R
				Cell R0840cell17 = row.createCell(17);
				if (record1.getR0840_legacy_interest_profit_suspense() != null) {
					R0840cell17.setCellValue(record1.getR0840_legacy_interest_profit_suspense().doubleValue());
					R0840cell17.setCellStyle(numberStyle);
				} else {
					R0840cell17.setCellValue("");
					R0840cell17.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column S
				Cell R0840cell18 = row.createCell(18);
				if (record1.getR0840_legal_case_yn() != null && !record1.getR0840_legal_case_yn().isEmpty()) {
					R0840cell18.setCellValue(record1.getR0840_legal_case_yn());
					R0840cell18.setCellStyle(textStyle);
				} else {
					R0840cell18.setCellValue("");
					R0840cell18.setCellStyle(textStyle);
				}

				/// ROW92
				//// Column T
				Cell R0840cell19 = row.createCell(19);
				if (record1.getR0840_remarks_if_any() != null && !record1.getR0840_remarks_if_any().isEmpty()) {
					R0840cell19.setCellValue(record1.getR0840_remarks_if_any());
					R0840cell19.setCellStyle(textStyle);
				} else {
					R0840cell19.setCellValue("");
					R0840cell19.setCellStyle(textStyle);
				}

			}
		


	
	public List<Object> getBRF5_2Archival() {
		List<Object> brf5_2ArchivalList = new ArrayList<>();
		try {
			brf5_2ArchivalList.addAll(BRF5_2_Summary_Archival_Repo1.getBRF5_2archival());
			brf5_2ArchivalList.addAll(BRF5_2_Summary_Archival_Repo2.getBRF5_2archival());
			logger.info("Fetched {} archival records.", brf5_2ArchivalList.size());
		} catch (Exception e) {
			logger.error("Error fetching BRF5_2 Archival data: {}", e.getMessage(), e);
		}
		return brf5_2ArchivalList;
	}

	public byte[] getBRF5_2ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {

		logger.info("Service: Starting ARCHIVAL Excel generation process.");

		List<CBUAE_BRF5_2_Summary_Archival_Entity1> dataList = BRF5_2_Summary_Archival_Repo1
				.getdatabydateListarchival(dateformat.parse(todate), version);
		List<CBUAE_BRF5_2_Summary_Archival_Entity2> dataList1 = BRF5_2_Summary_Archival_Repo2
				.getdatabydateListarchival(dateformat.parse(todate), version);

		if (dataList.isEmpty() && dataList1.isEmpty()) {
			logger.warn("Service: No data found for BRF5.2 ARCHIVAL report. Returning empty result.");
			return new byte[0];
		}

		String templateDir = env.getProperty("output.exportpathtemp");
		Path templatePath = Paths.get(templateDir, filename);
		logger.info("Service: Attempting to load template from path: {}", templatePath.toAbsolutePath());

		if (!Files.exists(templatePath)) {
			throw new FileNotFoundException("Template file not found at: " + templatePath.toAbsolutePath());
		}
		if (!Files.isReadable(templatePath)) {
			throw new SecurityException("Template file not readable: " + templatePath.toAbsolutePath());
		}

		try (InputStream templateInputStream = Files.newInputStream(templatePath);
				Workbook workbook = WorkbookFactory.create(templateInputStream);
				ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.getSheetAt(0);

			// --- Style Definitions ---
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
			// --- End of Style Definitions ---
			
			if (!dataList.isEmpty()) {
				populateArchivalEntity1Data(sheet, dataList.get(0), textStyle, numberStyle);
			}

			if (!dataList1.isEmpty()) {
				populateArchivalEntity2Data(sheet, dataList1.get(0), textStyle, numberStyle);
			}

			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Archival Excel data successfully written to memory buffer ({} bytes).", out.size());
			return out.toByteArray();
		}
	}
	
	private void populateArchivalEntity1Data(Sheet sheet, CBUAE_BRF5_2_Summary_Archival_Entity1 record, CellStyle textStyle, CellStyle numberStyle) {
	    // This method would be implemented identically to populateEntity1Data,
	    // but using the CBUAE_BRF5_2_Summary_Archival_Entity1 object.
	    // For brevity, the full implementation is omitted.
	}

	private void populateArchivalEntity2Data(Sheet sheet, CBUAE_BRF5_2_Summary_Archival_Entity2 record, CellStyle textStyle, CellStyle numberStyle) {
	    // This method would be implemented identically to populateEntity2Data,
	    // but using the CBUAE_BRF5_2_Summary_Archival_Entity2 object.
	    // For brevity, the full implementation is omitted.
	}
	
	// DetailExcel
		public byte[] getBRF5_2DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
				String type, String version) {
			try {
				logger.info("Generating Excel for BRF5_2 Details...");
				System.out.println("came to Detail download service");
				if (type.equals("ARCHIVAL") & version != null) {
					byte[] ARCHIVALreport = getBRF5_2DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
							type, version);
					return ARCHIVALreport;
				}
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("BRF5_2Details");

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
				String[] headers = { "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID", "COLUMNID",
						"REPORT_DATE" };

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
				List<CBUAE_BRF5_2_Detail_Entity> reportData = BRF5_2_Detail_Repo.getdatabydateList(parsedToDate);

				if (reportData != null && !reportData.isEmpty()) {
					int rowIndex = 1;
					for (CBUAE_BRF5_2_Detail_Entity item : reportData) {
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
						row.createCell(6)
								.setCellValue(item.getReportDate() != null
										? new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate())
										: "");

						// Apply data style for all other cells
						for (int j = 0; j < 7; j++) {
							if (j != 3) {
								row.getCell(j).setCellStyle(dataStyle);
							}
						}
					}
				} else {
					logger.info("No data found for BRF5_2 — only header will be written.");
				}

				// Write to byte[]
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				workbook.write(bos);
				workbook.close();

				logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
				return bos.toByteArray();

			} catch (Exception e) {
				logger.error("Error generating BRF5_2 Excel", e);
				return new byte[0];
			}
		}
		
		public byte[] getBRF5_2DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
				String dtltype, String type, String version) {
			try {
				logger.info("Generating Excel for BRF5_2 ARCHIVAL Details...");
				System.out.println("came to Detail download service");
				if (type.equals("ARCHIVAL") & version != null) {

				}
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("BRF5_2Details");

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
				String[] headers = { "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID", "COLUMNID",
						"REPORT_DATE" };

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
				List<CBUAE_BRF5_2_Archival_Detail_Entity> reportData = BRF5_2_archival_detail_repo.getdatabydateList(parsedToDate,
						version);

				if (reportData != null && !reportData.isEmpty()) {
					int rowIndex = 1;
					for (CBUAE_BRF5_2_Archival_Detail_Entity item : reportData) {
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
						row.createCell(6)
								.setCellValue(item.getReportDate() != null
										? new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate())
										: "");

						// Apply data style for all other cells
						for (int j = 0; j < 7; j++) {
							if (j != 3) {
								row.getCell(j).setCellStyle(dataStyle);
							}
						}
					}
				} else {
					logger.info("No data found for BRF5_2 — only header will be written.");
				}

				// Write to byte[]
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				workbook.write(bos);
				workbook.close();

				logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
				return bos.toByteArray();

			} catch (Exception e) {
				logger.error("Error generating BRF5_2 Excel", e);
				return new byte[0];
			}
		}

}