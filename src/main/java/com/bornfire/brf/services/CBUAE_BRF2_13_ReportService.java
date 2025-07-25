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

import com.bornfire.brf.entities.CBUAE_BRF1_2_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Summary_Entity3;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Summary_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF2_13_Summary_Repo3;

@Component
@Service

public class CBUAE_BRF2_13_ReportService {

	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_13_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF2_13_Detail_Repo CBUAE_BRF2_13_DETAIL_REPO;

	@Autowired
	CBUAE_BRF2_13_Summary_Repo1 CBUAE_BRF2_13_REPORT_REPO1;

	@Autowired
	CBUAE_BRF2_13_Summary_Repo2 CBUAE_BRF2_13_REPORT_REPO2;

	@Autowired
	CBUAE_BRF2_13_Summary_Repo3 CBUAE_BRF2_13_REPORT_REPO3;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF2_13View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<CBUAE_BRF2_13_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF2_13_Summary_Entity1>();
		List<CBUAE_BRF2_13_Summary_Entity2> T1Master1 = new ArrayList<CBUAE_BRF2_13_Summary_Entity2>();
		List<CBUAE_BRF2_13_Summary_Entity3> T1Master2 = new ArrayList<CBUAE_BRF2_13_Summary_Entity3>();
		try {
			Date d1 = dateformat.parse(todate);

			T1Master = CBUAE_BRF2_13_REPORT_REPO1.getdatabydateList(dateformat.parse(todate));
			T1Master1 = CBUAE_BRF2_13_REPORT_REPO2.getdatabydateList(dateformat.parse(todate));
			T1Master2 = CBUAE_BRF2_13_REPORT_REPO3.getdatabydateList(dateformat.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("BRF/BRF2_13");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF2_13currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();

		ModelAndView mv = new ModelAndView();
		List<CBUAE_BRF2_13_Detail_Entity> T1Dt1 = new ArrayList<>();

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
				T1Dt1 = CBUAE_BRF2_13_DETAIL_REPO.GetDataByRowIdAndColumnId(rowId, columnId, d1);
			} else {
				T1Dt1 = CBUAE_BRF2_13_DETAIL_REPO.getdatabydateList(d1);
			}

			System.out.println("LISTCOUNT: " + T1Dt1.size());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("BRF/BRF2_13");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportdetails", T1Dt1);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public byte[] getBRF2_13Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF2_13_Summary_Entity1> dataList = CBUAE_BRF2_13_REPORT_REPO1
				.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF2_13_Summary_Entity2> dataList1 = CBUAE_BRF2_13_REPORT_REPO2
				.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF2_13_Summary_Entity3> dataList2 = CBUAE_BRF2_13_REPORT_REPO3
				.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.13 report. Returning empty result.");
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
			font.setFontHeightInPoints((short) 8); // size 8
			font.setFontName("Arial");

			CellStyle numberStyle = workbook.createCellStyle();
			// numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 14;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {

					CBUAE_BRF2_13_Summary_Entity1 record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					///// ROW15///////////
					// row15
					// Column E:
					Cell R0040cell4 = row.createCell(4);
					if (record.getR0040_aed_amount() != null) {
						R0040cell4.setCellValue(record.getR0040_aed_amount().doubleValue());
						R0040cell4.setCellStyle(numberStyle);
					} else {
						R0040cell4.setCellValue("");
						R0040cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0040cell5 = row.createCell(5);
					if (record.getR0040_fcy_amount() != null) {
						R0040cell5.setCellValue(record.getR0040_fcy_amount().doubleValue());
						R0040cell5.setCellStyle(numberStyle);
					} else {
						R0040cell5.setCellValue("");
						R0040cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0040cell7 = row.createCell(7);
					if (record.getR0040_non_commercial_entities() != null) {
						R0040cell7.setCellValue(record.getR0040_non_commercial_entities().doubleValue());
						R0040cell7.setCellStyle(numberStyle);
					} else {
						R0040cell7.setCellValue("");
						R0040cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0040cell8 = row.createCell(8);
					if (record.getR0040_commercial_entities() != null) {
						R0040cell8.setCellValue(record.getR0040_commercial_entities().doubleValue());
						R0040cell8.setCellStyle(numberStyle);
					} else {
						R0040cell8.setCellValue("");
						R0040cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0040cell9 = row.createCell(9);
					if (record.getR0040_private_corporates() != null) {
						R0040cell9.setCellValue(record.getR0040_private_corporates().doubleValue());
						R0040cell9.setCellStyle(numberStyle);
					} else {
						R0040cell9.setCellValue("");
						R0040cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0040cell10 = row.createCell(10);
					if (record.getR0040_sme() != null) {
						R0040cell10.setCellValue(record.getR0040_sme().doubleValue());
						R0040cell10.setCellStyle(numberStyle);
					} else {
						R0040cell10.setCellValue("");
						R0040cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0040cell11 = row.createCell(11);
					if (record.getR0040_individuals() != null) {
						R0040cell11.setCellValue(record.getR0040_individuals().doubleValue());
						R0040cell11.setCellStyle(numberStyle);
					} else {
						R0040cell11.setCellValue("");
						R0040cell11.setCellStyle(textStyle);
					}

					///// ROW16///////////
					// row16
					// Column E:
					row = sheet.getRow(15);
					Cell R0050cell4 = row.createCell(4);
					if (record.getR0050_aed_amount() != null) {
						R0050cell4.setCellValue(record.getR0050_aed_amount().doubleValue());
						R0050cell4.setCellStyle(numberStyle);
					} else {
						R0050cell4.setCellValue("");
						R0050cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0050cell5 = row.createCell(5);
					if (record.getR0050_fcy_amount() != null) {
						R0050cell5.setCellValue(record.getR0050_fcy_amount().doubleValue());
						R0050cell5.setCellStyle(numberStyle);
					} else {
						R0050cell5.setCellValue("");
						R0050cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0050cell7 = row.createCell(7);
					if (record.getR0050_non_commercial_entities() != null) {
						R0050cell7.setCellValue(record.getR0050_non_commercial_entities().doubleValue());
						R0050cell7.setCellStyle(numberStyle);
					} else {
						R0050cell7.setCellValue("");
						R0050cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0050cell8 = row.createCell(8);
					if (record.getR0050_commercial_entities() != null) {
						R0050cell8.setCellValue(record.getR0050_commercial_entities().doubleValue());
						R0050cell8.setCellStyle(numberStyle);
					} else {
						R0050cell8.setCellValue("");
						R0050cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0050cell9 = row.createCell(9);
					if (record.getR0050_private_corporates() != null) {
						R0050cell9.setCellValue(record.getR0050_private_corporates().doubleValue());
						R0050cell9.setCellStyle(numberStyle);
					} else {
						R0050cell9.setCellValue("");
						R0050cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0050cell10 = row.createCell(10);
					if (record.getR0050_sme() != null) {
						R0050cell10.setCellValue(record.getR0050_sme().doubleValue());
						R0050cell10.setCellStyle(numberStyle);
					} else {
						R0050cell10.setCellValue("");
						R0050cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0050cell11 = row.createCell(11);
					if (record.getR0050_individuals() != null) {
						R0050cell11.setCellValue(record.getR0050_individuals().doubleValue());
						R0050cell11.setCellStyle(numberStyle);
					} else {
						R0050cell11.setCellValue("");
						R0050cell11.setCellStyle(textStyle);
					}

					///// ROW17///////////
					// row17
					row = sheet.getRow(16);
					// Column E:
					Cell R0060cell4 = row.createCell(4);
					if (record.getR0060_aed_amount() != null) {
						R0060cell4.setCellValue(record.getR0060_aed_amount().doubleValue());
						R0060cell4.setCellStyle(numberStyle);
					} else {
						R0060cell4.setCellValue("");
						R0060cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0060cell5 = row.createCell(5);
					if (record.getR0060_fcy_amount() != null) {
						R0060cell5.setCellValue(record.getR0060_fcy_amount().doubleValue());
						R0060cell5.setCellStyle(numberStyle);
					} else {
						R0060cell5.setCellValue("");
						R0060cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0060cell7 = row.createCell(7);
					if (record.getR0060_non_commercial_entities() != null) {
						R0060cell7.setCellValue(record.getR0060_non_commercial_entities().doubleValue());
						R0060cell7.setCellStyle(numberStyle);
					} else {
						R0060cell7.setCellValue("");
						R0060cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0060cell8 = row.createCell(8);
					if (record.getR0060_commercial_entities() != null) {
						R0060cell8.setCellValue(record.getR0060_commercial_entities().doubleValue());
						R0060cell8.setCellStyle(numberStyle);
					} else {
						R0060cell8.setCellValue("");
						R0060cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0060cell9 = row.createCell(9);
					if (record.getR0060_private_corporates() != null) {
						R0060cell9.setCellValue(record.getR0060_private_corporates().doubleValue());
						R0060cell9.setCellStyle(numberStyle);
					} else {
						R0060cell9.setCellValue("");
						R0060cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0060cell10 = row.createCell(10);
					if (record.getR0060_sme() != null) {
						R0060cell10.setCellValue(record.getR0060_sme().doubleValue());
						R0060cell10.setCellStyle(numberStyle);
					} else {
						R0060cell10.setCellValue("");
						R0060cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0060cell11 = row.createCell(11);
					if (record.getR0060_individuals() != null) {
						R0060cell11.setCellValue(record.getR0060_individuals().doubleValue());
						R0060cell11.setCellStyle(numberStyle);
					} else {
						R0060cell11.setCellValue("");
						R0060cell11.setCellStyle(textStyle);
					}

					///// ROW18///////////
					// row18
					row = sheet.getRow(17);
					// Column E:
					Cell R0070cell4 = row.createCell(4);
					if (record.getR0070_aed_amount() != null) {
						R0070cell4.setCellValue(record.getR0070_aed_amount().doubleValue());
						R0070cell4.setCellStyle(numberStyle);
					} else {
						R0070cell4.setCellValue("");
						R0070cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0070cell5 = row.createCell(5);
					if (record.getR0070_fcy_amount() != null) {
						R0070cell5.setCellValue(record.getR0070_fcy_amount().doubleValue());
						R0070cell5.setCellStyle(numberStyle);
					} else {
						R0070cell5.setCellValue("");
						R0070cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0070cell7 = row.createCell(7);
					if (record.getR0070_non_commercial_entities() != null) {
						R0070cell7.setCellValue(record.getR0070_non_commercial_entities().doubleValue());
						R0070cell7.setCellStyle(numberStyle);
					} else {
						R0070cell7.setCellValue("");
						R0070cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0070cell8 = row.createCell(8);
					if (record.getR0070_commercial_entities() != null) {
						R0070cell8.setCellValue(record.getR0070_commercial_entities().doubleValue());
						R0070cell8.setCellStyle(numberStyle);
					} else {
						R0070cell8.setCellValue("");
						R0070cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0070cell9 = row.createCell(9);
					if (record.getR0070_private_corporates() != null) {
						R0070cell9.setCellValue(record.getR0070_private_corporates().doubleValue());
						R0070cell9.setCellStyle(numberStyle);
					} else {
						R0070cell9.setCellValue("");
						R0070cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0070cell10 = row.createCell(10);
					if (record.getR0070_sme() != null) {
						R0070cell10.setCellValue(record.getR0070_sme().doubleValue());
						R0070cell10.setCellStyle(numberStyle);
					} else {
						R0070cell10.setCellValue("");
						R0070cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0070cell11 = row.createCell(11);
					if (record.getR0070_individuals() != null) {
						R0070cell11.setCellValue(record.getR0070_individuals().doubleValue());
						R0070cell11.setCellStyle(numberStyle);
					} else {
						R0070cell11.setCellValue("");
						R0070cell11.setCellStyle(textStyle);
					}

					///// ROW20///////////
					// row20
					row = sheet.getRow(19);
					// Column E:
					Cell R0090cell4 = row.createCell(4);
					if (record.getR0090_aed_amount() != null) {
						R0090cell4.setCellValue(record.getR0090_aed_amount().doubleValue());
						R0090cell4.setCellStyle(numberStyle);
					} else {
						R0090cell4.setCellValue("");
						R0090cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0090cell5 = row.createCell(5);
					if (record.getR0090_fcy_amount() != null) {
						R0090cell5.setCellValue(record.getR0090_fcy_amount().doubleValue());
						R0090cell5.setCellStyle(numberStyle);
					} else {
						R0090cell5.setCellValue("");
						R0090cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0090cell7 = row.createCell(7);
					if (record.getR0090_non_commercial_entities() != null) {
						R0090cell7.setCellValue(record.getR0090_non_commercial_entities().doubleValue());
						R0090cell7.setCellStyle(numberStyle);
					} else {
						R0090cell7.setCellValue("");
						R0090cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0090cell8 = row.createCell(8);
					if (record.getR0090_commercial_entities() != null) {
						R0090cell8.setCellValue(record.getR0090_commercial_entities().doubleValue());
						R0090cell8.setCellStyle(numberStyle);
					} else {
						R0090cell8.setCellValue("");
						R0090cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0090cell9 = row.createCell(9);
					if (record.getR0090_private_corporates() != null) {
						R0090cell9.setCellValue(record.getR0090_private_corporates().doubleValue());
						R0090cell9.setCellStyle(numberStyle);
					} else {
						R0090cell9.setCellValue("");
						R0090cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0090cell10 = row.createCell(10);
					if (record.getR0090_sme() != null) {
						R0090cell10.setCellValue(record.getR0090_sme().doubleValue());
						R0090cell10.setCellStyle(numberStyle);
					} else {
						R0090cell10.setCellValue("");
						R0090cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0090cell11 = row.createCell(11);
					if (record.getR0090_individuals() != null) {
						R0090cell11.setCellValue(record.getR0090_individuals().doubleValue());
						R0090cell11.setCellStyle(numberStyle);
					} else {
						R0090cell11.setCellValue("");
						R0090cell11.setCellStyle(textStyle);
					}

					///// ROW21///////////
					// row21
					row = sheet.getRow(20);
					// Column E:
					Cell R0100cell4 = row.createCell(4);
					if (record.getR0100_aed_amount() != null) {
						R0100cell4.setCellValue(record.getR0100_aed_amount().doubleValue());
						R0100cell4.setCellStyle(numberStyle);
					} else {
						R0100cell4.setCellValue("");
						R0100cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0100cell5 = row.createCell(5);
					if (record.getR0100_fcy_amount() != null) {
						R0100cell5.setCellValue(record.getR0100_fcy_amount().doubleValue());
						R0100cell5.setCellStyle(numberStyle);
					} else {
						R0100cell5.setCellValue("");
						R0100cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0100cell7 = row.createCell(7);
					if (record.getR0100_non_commercial_entities() != null) {
						R0100cell7.setCellValue(record.getR0100_non_commercial_entities().doubleValue());
						R0100cell7.setCellStyle(numberStyle);
					} else {
						R0100cell7.setCellValue("");
						R0100cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0100cell8 = row.createCell(8);
					if (record.getR0100_commercial_entities() != null) {
						R0100cell8.setCellValue(record.getR0100_commercial_entities().doubleValue());
						R0100cell8.setCellStyle(numberStyle);
					} else {
						R0100cell8.setCellValue("");
						R0100cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0100cell9 = row.createCell(9);
					if (record.getR0100_private_corporates() != null) {
						R0100cell9.setCellValue(record.getR0100_private_corporates().doubleValue());
						R0100cell9.setCellStyle(numberStyle);
					} else {
						R0100cell9.setCellValue("");
						R0100cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0100cell10 = row.createCell(10);
					if (record.getR0100_sme() != null) {
						R0100cell10.setCellValue(record.getR0100_sme().doubleValue());
						R0100cell10.setCellStyle(numberStyle);
					} else {
						R0100cell10.setCellValue("");
						R0100cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0100cell11 = row.createCell(11);
					if (record.getR0100_individuals() != null) {
						R0100cell11.setCellValue(record.getR0100_individuals().doubleValue());
						R0100cell11.setCellStyle(numberStyle);
					} else {
						R0100cell11.setCellValue("");
						R0100cell11.setCellStyle(textStyle);
					}

					///// ROW22///////////
					// row22
					row = sheet.getRow(21);
					// Column E:
					Cell R0110cell4 = row.createCell(4);
					if (record.getR0110_aed_amount() != null) {
						R0110cell4.setCellValue(record.getR0110_aed_amount().doubleValue());
						R0110cell4.setCellStyle(numberStyle);
					} else {
						R0110cell4.setCellValue("");
						R0110cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0110cell5 = row.createCell(5);
					if (record.getR0110_fcy_amount() != null) {
						R0110cell5.setCellValue(record.getR0110_fcy_amount().doubleValue());
						R0110cell5.setCellStyle(numberStyle);
					} else {
						R0110cell5.setCellValue("");
						R0110cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0110cell7 = row.createCell(7);
					if (record.getR0110_non_commercial_entities() != null) {
						R0110cell7.setCellValue(record.getR0110_non_commercial_entities().doubleValue());
						R0110cell7.setCellStyle(numberStyle);
					} else {
						R0110cell7.setCellValue("");
						R0110cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0110cell8 = row.createCell(8);
					if (record.getR0110_commercial_entities() != null) {
						R0110cell8.setCellValue(record.getR0110_commercial_entities().doubleValue());
						R0110cell8.setCellStyle(numberStyle);
					} else {
						R0110cell8.setCellValue("");
						R0110cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0110cell9 = row.createCell(9);
					if (record.getR0110_private_corporates() != null) {
						R0110cell9.setCellValue(record.getR0110_private_corporates().doubleValue());
						R0110cell9.setCellStyle(numberStyle);
					} else {
						R0110cell9.setCellValue("");
						R0110cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0110cell10 = row.createCell(10);
					if (record.getR0110_sme() != null) {
						R0110cell10.setCellValue(record.getR0110_sme().doubleValue());
						R0110cell10.setCellStyle(numberStyle);
					} else {
						R0110cell10.setCellValue("");
						R0110cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0110cell11 = row.createCell(11);
					if (record.getR0110_individuals() != null) {
						R0110cell11.setCellValue(record.getR0110_individuals().doubleValue());
						R0110cell11.setCellStyle(numberStyle);
					} else {
						R0110cell11.setCellValue("");
						R0110cell11.setCellStyle(textStyle);
					}

					///// ROW23///////////
					// row23
					row = sheet.getRow(22);
					// Column E:
					Cell R0120cell4 = row.createCell(4);
					if (record.getR0120_aed_amount() != null) {
						R0120cell4.setCellValue(record.getR0120_aed_amount().doubleValue());
						R0120cell4.setCellStyle(numberStyle);
					} else {
						R0120cell4.setCellValue("");
						R0120cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0120cell5 = row.createCell(5);
					if (record.getR0120_fcy_amount() != null) {
						R0120cell5.setCellValue(record.getR0120_fcy_amount().doubleValue());
						R0120cell5.setCellStyle(numberStyle);
					} else {
						R0120cell5.setCellValue("");
						R0120cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0120cell7 = row.createCell(7);
					if (record.getR0120_non_commercial_entities() != null) {
						R0120cell7.setCellValue(record.getR0120_non_commercial_entities().doubleValue());
						R0120cell7.setCellStyle(numberStyle);
					} else {
						R0120cell7.setCellValue("");
						R0120cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0120cell8 = row.createCell(8);
					if (record.getR0120_commercial_entities() != null) {
						R0120cell8.setCellValue(record.getR0120_commercial_entities().doubleValue());
						R0120cell8.setCellStyle(numberStyle);
					} else {
						R0120cell8.setCellValue("");
						R0120cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0120cell9 = row.createCell(9);
					if (record.getR0120_private_corporates() != null) {
						R0120cell9.setCellValue(record.getR0120_private_corporates().doubleValue());
						R0120cell9.setCellStyle(numberStyle);
					} else {
						R0120cell9.setCellValue("");
						R0120cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0120cell10 = row.createCell(10);
					if (record.getR0120_sme() != null) {
						R0120cell10.setCellValue(record.getR0120_sme().doubleValue());
						R0120cell10.setCellStyle(numberStyle);
					} else {
						R0120cell10.setCellValue("");
						R0120cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0120cell11 = row.createCell(11);
					if (record.getR0120_individuals() != null) {
						R0120cell11.setCellValue(record.getR0120_individuals().doubleValue());
						R0120cell11.setCellStyle(numberStyle);
					} else {
						R0120cell11.setCellValue("");
						R0120cell11.setCellStyle(textStyle);
					}

					///// ROW24///////////
					// row24
					row = sheet.getRow(23);
					// Column E:
					Cell R0130cell4 = row.createCell(4);
					if (record.getR0130_aed_amount() != null) {
						R0130cell4.setCellValue(record.getR0130_aed_amount().doubleValue());
						R0130cell4.setCellStyle(numberStyle);
					} else {
						R0130cell4.setCellValue("");
						R0130cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0130cell5 = row.createCell(5);
					if (record.getR0130_fcy_amount() != null) {
						R0130cell5.setCellValue(record.getR0130_fcy_amount().doubleValue());
						R0130cell5.setCellStyle(numberStyle);
					} else {
						R0130cell5.setCellValue("");
						R0130cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0130cell7 = row.createCell(7);
					if (record.getR0130_non_commercial_entities() != null) {
						R0130cell7.setCellValue(record.getR0130_non_commercial_entities().doubleValue());
						R0130cell7.setCellStyle(numberStyle);
					} else {
						R0130cell7.setCellValue("");
						R0130cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0130cell8 = row.createCell(8);
					if (record.getR0130_commercial_entities() != null) {
						R0130cell8.setCellValue(record.getR0130_commercial_entities().doubleValue());
						R0130cell8.setCellStyle(numberStyle);
					} else {
						R0130cell8.setCellValue("");
						R0130cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0130cell9 = row.createCell(9);
					if (record.getR0130_private_corporates() != null) {
						R0130cell9.setCellValue(record.getR0130_private_corporates().doubleValue());
						R0130cell9.setCellStyle(numberStyle);
					} else {
						R0130cell9.setCellValue("");
						R0130cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0130cell10 = row.createCell(10);
					if (record.getR0130_sme() != null) {
						R0130cell10.setCellValue(record.getR0130_sme().doubleValue());
						R0130cell10.setCellStyle(numberStyle);
					} else {
						R0130cell10.setCellValue("");
						R0130cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0130cell11 = row.createCell(11);
					if (record.getR0130_individuals() != null) {
						R0130cell11.setCellValue(record.getR0130_individuals().doubleValue());
						R0130cell11.setCellStyle(numberStyle);
					} else {
						R0130cell11.setCellValue("");
						R0130cell11.setCellStyle(textStyle);
					}

					///// ROW25///////////
					// row25
					row = sheet.getRow(24);
					// Column E:
					Cell R0140cell4 = row.createCell(4);
					if (record.getR0140_aed_amount() != null) {
						R0140cell4.setCellValue(record.getR0140_aed_amount().doubleValue());
						R0140cell4.setCellStyle(numberStyle);
					} else {
						R0140cell4.setCellValue("");
						R0140cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0140cell5 = row.createCell(5);
					if (record.getR0140_fcy_amount() != null) {
						R0140cell5.setCellValue(record.getR0140_fcy_amount().doubleValue());
						R0140cell5.setCellStyle(numberStyle);
					} else {
						R0140cell5.setCellValue("");
						R0140cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0140cell7 = row.createCell(7);
					if (record.getR0140_non_commercial_entities() != null) {
						R0140cell7.setCellValue(record.getR0140_non_commercial_entities().doubleValue());
						R0140cell7.setCellStyle(numberStyle);
					} else {
						R0140cell7.setCellValue("");
						R0140cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0140cell8 = row.createCell(8);
					if (record.getR0140_commercial_entities() != null) {
						R0140cell8.setCellValue(record.getR0140_commercial_entities().doubleValue());
						R0140cell8.setCellStyle(numberStyle);
					} else {
						R0140cell8.setCellValue("");
						R0140cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0140cell9 = row.createCell(9);
					if (record.getR0140_private_corporates() != null) {
						R0140cell9.setCellValue(record.getR0140_private_corporates().doubleValue());
						R0140cell9.setCellStyle(numberStyle);
					} else {
						R0140cell9.setCellValue("");
						R0140cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0140cell10 = row.createCell(10);
					if (record.getR0140_sme() != null) {
						R0140cell10.setCellValue(record.getR0140_sme().doubleValue());
						R0140cell10.setCellStyle(numberStyle);
					} else {
						R0140cell10.setCellValue("");
						R0140cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0140cell11 = row.createCell(11);
					if (record.getR0140_individuals() != null) {
						R0140cell11.setCellValue(record.getR0140_individuals().doubleValue());
						R0140cell11.setCellStyle(numberStyle);
					} else {
						R0140cell11.setCellValue("");
						R0140cell11.setCellStyle(textStyle);
					}

					///// ROW26///////////
					// row26
					row = sheet.getRow(25);
					// Column E:
					Cell R0150cell4 = row.createCell(4);
					if (record.getR0150_aed_amount() != null) {
						R0150cell4.setCellValue(record.getR0150_aed_amount().doubleValue());
						R0150cell4.setCellStyle(numberStyle);
					} else {
						R0150cell4.setCellValue("");
						R0150cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0150cell5 = row.createCell(5);
					if (record.getR0150_fcy_amount() != null) {
						R0150cell5.setCellValue(record.getR0150_fcy_amount().doubleValue());
						R0150cell5.setCellStyle(numberStyle);
					} else {
						R0150cell5.setCellValue("");
						R0150cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0150cell7 = row.createCell(7);
					if (record.getR0150_non_commercial_entities() != null) {
						R0150cell7.setCellValue(record.getR0150_non_commercial_entities().doubleValue());
						R0150cell7.setCellStyle(numberStyle);
					} else {
						R0150cell7.setCellValue("");
						R0150cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0150cell8 = row.createCell(8);
					if (record.getR0150_commercial_entities() != null) {
						R0150cell8.setCellValue(record.getR0150_commercial_entities().doubleValue());
						R0150cell8.setCellStyle(numberStyle);
					} else {
						R0150cell8.setCellValue("");
						R0150cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0150cell9 = row.createCell(9);
					if (record.getR0150_private_corporates() != null) {
						R0150cell9.setCellValue(record.getR0150_private_corporates().doubleValue());
						R0150cell9.setCellStyle(numberStyle);
					} else {
						R0150cell9.setCellValue("");
						R0150cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0150cell10 = row.createCell(10);
					if (record.getR0150_sme() != null) {
						R0150cell10.setCellValue(record.getR0150_sme().doubleValue());
						R0150cell10.setCellStyle(numberStyle);
					} else {
						R0150cell10.setCellValue("");
						R0150cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0150cell11 = row.createCell(11);
					if (record.getR0150_individuals() != null) {
						R0150cell11.setCellValue(record.getR0150_individuals().doubleValue());
						R0150cell11.setCellStyle(numberStyle);
					} else {
						R0150cell11.setCellValue("");
						R0150cell11.setCellStyle(textStyle);
					}

					///// ROW27///////////
					// row27
					row = sheet.getRow(26);
					// Column E:
					Cell R0160cell4 = row.createCell(4);
					if (record.getR0160_aed_amount() != null) {
						R0160cell4.setCellValue(record.getR0160_aed_amount().doubleValue());
						R0160cell4.setCellStyle(numberStyle);
					} else {
						R0160cell4.setCellValue("");
						R0160cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0160cell5 = row.createCell(5);
					if (record.getR0160_fcy_amount() != null) {
						R0160cell5.setCellValue(record.getR0160_fcy_amount().doubleValue());
						R0160cell5.setCellStyle(numberStyle);
					} else {
						R0160cell5.setCellValue("");
						R0160cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0160cell7 = row.createCell(7);
					if (record.getR0160_non_commercial_entities() != null) {
						R0160cell7.setCellValue(record.getR0160_non_commercial_entities().doubleValue());
						R0160cell7.setCellStyle(numberStyle);
					} else {
						R0160cell7.setCellValue("");
						R0160cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0160cell8 = row.createCell(8);
					if (record.getR0160_commercial_entities() != null) {
						R0160cell8.setCellValue(record.getR0160_commercial_entities().doubleValue());
						R0160cell8.setCellStyle(numberStyle);
					} else {
						R0160cell8.setCellValue("");
						R0160cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0160cell9 = row.createCell(9);
					if (record.getR0160_private_corporates() != null) {
						R0160cell9.setCellValue(record.getR0160_private_corporates().doubleValue());
						R0160cell9.setCellStyle(numberStyle);
					} else {
						R0160cell9.setCellValue("");
						R0160cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0160cell10 = row.createCell(10);
					if (record.getR0160_sme() != null) {
						R0160cell10.setCellValue(record.getR0160_sme().doubleValue());
						R0160cell10.setCellStyle(numberStyle);
					} else {
						R0160cell10.setCellValue("");
						R0160cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0160cell11 = row.createCell(11);
					if (record.getR0160_individuals() != null) {
						R0160cell11.setCellValue(record.getR0160_individuals().doubleValue());
						R0160cell11.setCellStyle(numberStyle);
					} else {
						R0160cell11.setCellValue("");
						R0160cell11.setCellStyle(textStyle);
					}

					///// ROW28///////////
					// row28
					row = sheet.getRow(27);
					// Column E:
					Cell R0170cell4 = row.createCell(4);
					if (record.getR0170_aed_amount() != null) {
						R0170cell4.setCellValue(record.getR0170_aed_amount().doubleValue());
						R0170cell4.setCellStyle(numberStyle);
					} else {
						R0170cell4.setCellValue("");
						R0170cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0170cell5 = row.createCell(5);
					if (record.getR0170_fcy_amount() != null) {
						R0170cell5.setCellValue(record.getR0170_fcy_amount().doubleValue());
						R0170cell5.setCellStyle(numberStyle);
					} else {
						R0170cell5.setCellValue("");
						R0170cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0170cell7 = row.createCell(7);
					if (record.getR0170_non_commercial_entities() != null) {
						R0170cell7.setCellValue(record.getR0170_non_commercial_entities().doubleValue());
						R0170cell7.setCellStyle(numberStyle);
					} else {
						R0170cell7.setCellValue("");
						R0170cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0170cell8 = row.createCell(8);
					if (record.getR0170_commercial_entities() != null) {
						R0170cell8.setCellValue(record.getR0170_commercial_entities().doubleValue());
						R0170cell8.setCellStyle(numberStyle);
					} else {
						R0170cell8.setCellValue("");
						R0170cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0170cell9 = row.createCell(9);
					if (record.getR0170_private_corporates() != null) {
						R0170cell9.setCellValue(record.getR0170_private_corporates().doubleValue());
						R0170cell9.setCellStyle(numberStyle);
					} else {
						R0170cell9.setCellValue("");
						R0170cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0170cell10 = row.createCell(10);
					if (record.getR0170_sme() != null) {
						R0170cell10.setCellValue(record.getR0170_sme().doubleValue());
						R0170cell10.setCellStyle(numberStyle);
					} else {
						R0170cell10.setCellValue("");
						R0170cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0170cell11 = row.createCell(11);
					if (record.getR0170_individuals() != null) {
						R0170cell11.setCellValue(record.getR0170_individuals().doubleValue());
						R0170cell11.setCellStyle(numberStyle);
					} else {
						R0170cell11.setCellValue("");
						R0170cell11.setCellStyle(textStyle);
					}

					///// ROW29///////////
					// row29
					row = sheet.getRow(28);
					// Column E:
					Cell R0180cell4 = row.createCell(4);
					if (record.getR0180_aed_amount() != null) {
						R0180cell4.setCellValue(record.getR0180_aed_amount().doubleValue());
						R0180cell4.setCellStyle(numberStyle);
					} else {
						R0180cell4.setCellValue("");
						R0180cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0180cell5 = row.createCell(5);
					if (record.getR0180_fcy_amount() != null) {
						R0180cell5.setCellValue(record.getR0180_fcy_amount().doubleValue());
						R0180cell5.setCellStyle(numberStyle);
					} else {
						R0180cell5.setCellValue("");
						R0180cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0180cell7 = row.createCell(7);
					if (record.getR0180_non_commercial_entities() != null) {
						R0180cell7.setCellValue(record.getR0180_non_commercial_entities().doubleValue());
						R0180cell7.setCellStyle(numberStyle);
					} else {
						R0180cell7.setCellValue("");
						R0180cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0180cell8 = row.createCell(8);
					if (record.getR0180_commercial_entities() != null) {
						R0180cell8.setCellValue(record.getR0180_commercial_entities().doubleValue());
						R0180cell8.setCellStyle(numberStyle);
					} else {
						R0180cell8.setCellValue("");
						R0180cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0180cell9 = row.createCell(9);
					if (record.getR0180_private_corporates() != null) {
						R0180cell9.setCellValue(record.getR0180_private_corporates().doubleValue());
						R0180cell9.setCellStyle(numberStyle);
					} else {
						R0180cell9.setCellValue("");
						R0180cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0180cell10 = row.createCell(10);
					if (record.getR0180_sme() != null) {
						R0180cell10.setCellValue(record.getR0180_sme().doubleValue());
						R0180cell10.setCellStyle(numberStyle);
					} else {
						R0180cell10.setCellValue("");
						R0180cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0180cell11 = row.createCell(11);
					if (record.getR0180_individuals() != null) {
						R0180cell11.setCellValue(record.getR0180_individuals().doubleValue());
						R0180cell11.setCellStyle(numberStyle);
					} else {
						R0180cell11.setCellValue("");
						R0180cell11.setCellStyle(textStyle);
					}

					///// ROW31///////////
					// row31
					row = sheet.getRow(30);
					// Column E:
					Cell R0200cell4 = row.createCell(4);
					if (record.getR0200_aed_amount() != null) {
						R0200cell4.setCellValue(record.getR0200_aed_amount().doubleValue());
						R0200cell4.setCellStyle(numberStyle);
					} else {
						R0200cell4.setCellValue("");
						R0200cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0200cell5 = row.createCell(5);
					if (record.getR0200_fcy_amount() != null) {
						R0200cell5.setCellValue(record.getR0200_fcy_amount().doubleValue());
						R0200cell5.setCellStyle(numberStyle);
					} else {
						R0200cell5.setCellValue("");
						R0200cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0200cell7 = row.createCell(7);
					if (record.getR0200_non_commercial_entities() != null) {
						R0200cell7.setCellValue(record.getR0200_non_commercial_entities().doubleValue());
						R0200cell7.setCellStyle(numberStyle);
					} else {
						R0200cell7.setCellValue("");
						R0200cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0200cell8 = row.createCell(8);
					if (record.getR0200_commercial_entities() != null) {
						R0200cell8.setCellValue(record.getR0200_commercial_entities().doubleValue());
						R0200cell8.setCellStyle(numberStyle);
					} else {
						R0200cell8.setCellValue("");
						R0200cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0200cell9 = row.createCell(9);
					if (record.getR0200_private_corporates() != null) {
						R0200cell9.setCellValue(record.getR0200_private_corporates().doubleValue());
						R0200cell9.setCellStyle(numberStyle);
					} else {
						R0200cell9.setCellValue("");
						R0200cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0200cell10 = row.createCell(10);
					if (record.getR0200_sme() != null) {
						R0200cell10.setCellValue(record.getR0200_sme().doubleValue());
						R0200cell10.setCellStyle(numberStyle);
					} else {
						R0200cell10.setCellValue("");
						R0200cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0200cell11 = row.createCell(11);
					if (record.getR0200_individuals() != null) {
						R0200cell11.setCellValue(record.getR0200_individuals().doubleValue());
						R0200cell11.setCellStyle(numberStyle);
					} else {
						R0200cell11.setCellValue("");
						R0200cell11.setCellStyle(textStyle);
					}

					///// ROW32///////////
					// row32
					row = sheet.getRow(31);
					// Column E:
					Cell R0210cell4 = row.createCell(4);
					if (record.getR0210_aed_amount() != null) {
						R0210cell4.setCellValue(record.getR0210_aed_amount().doubleValue());
						R0210cell4.setCellStyle(numberStyle);
					} else {
						R0210cell4.setCellValue("");
						R0210cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0210cell5 = row.createCell(5);
					if (record.getR0210_fcy_amount() != null) {
						R0210cell5.setCellValue(record.getR0210_fcy_amount().doubleValue());
						R0210cell5.setCellStyle(numberStyle);
					} else {
						R0210cell5.setCellValue("");
						R0210cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0210cell7 = row.createCell(7);
					if (record.getR0210_non_commercial_entities() != null) {
						R0210cell7.setCellValue(record.getR0210_non_commercial_entities().doubleValue());
						R0210cell7.setCellStyle(numberStyle);
					} else {
						R0210cell7.setCellValue("");
						R0210cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0210cell8 = row.createCell(8);
					if (record.getR0210_commercial_entities() != null) {
						R0210cell8.setCellValue(record.getR0210_commercial_entities().doubleValue());
						R0210cell8.setCellStyle(numberStyle);
					} else {
						R0210cell8.setCellValue("");
						R0210cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0210cell9 = row.createCell(9);
					if (record.getR0210_private_corporates() != null) {
						R0210cell9.setCellValue(record.getR0210_private_corporates().doubleValue());
						R0210cell9.setCellStyle(numberStyle);
					} else {
						R0210cell9.setCellValue("");
						R0210cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0210cell10 = row.createCell(10);
					if (record.getR0210_sme() != null) {
						R0210cell10.setCellValue(record.getR0210_sme().doubleValue());
						R0210cell10.setCellStyle(numberStyle);
					} else {
						R0210cell10.setCellValue("");
						R0210cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0210cell11 = row.createCell(11);
					if (record.getR0210_individuals() != null) {
						R0210cell11.setCellValue(record.getR0210_individuals().doubleValue());
						R0210cell11.setCellStyle(numberStyle);
					} else {
						R0210cell11.setCellValue("");
						R0210cell11.setCellStyle(textStyle);
					}

					///// ROW33///////////
					// row33
					row = sheet.getRow(32);
					// Column E:
					Cell R0220cell4 = row.createCell(4);
					if (record.getR0220_aed_amount() != null) {
						R0220cell4.setCellValue(record.getR0220_aed_amount().doubleValue());
						R0220cell4.setCellStyle(numberStyle);
					} else {
						R0220cell4.setCellValue("");
						R0220cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0220cell5 = row.createCell(5);
					if (record.getR0220_fcy_amount() != null) {
						R0220cell5.setCellValue(record.getR0220_fcy_amount().doubleValue());
						R0220cell5.setCellStyle(numberStyle);
					} else {
						R0220cell5.setCellValue("");
						R0220cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0220cell7 = row.createCell(7);
					if (record.getR0220_non_commercial_entities() != null) {
						R0220cell7.setCellValue(record.getR0220_non_commercial_entities().doubleValue());
						R0220cell7.setCellStyle(numberStyle);
					} else {
						R0220cell7.setCellValue("");
						R0220cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0220cell8 = row.createCell(8);
					if (record.getR0220_commercial_entities() != null) {
						R0220cell8.setCellValue(record.getR0220_commercial_entities().doubleValue());
						R0220cell8.setCellStyle(numberStyle);
					} else {
						R0220cell8.setCellValue("");
						R0220cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0220cell9 = row.createCell(9);
					if (record.getR0220_private_corporates() != null) {
						R0220cell9.setCellValue(record.getR0220_private_corporates().doubleValue());
						R0220cell9.setCellStyle(numberStyle);
					} else {
						R0220cell9.setCellValue("");
						R0220cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0220cell10 = row.createCell(10);
					if (record.getR0220_sme() != null) {
						R0220cell10.setCellValue(record.getR0220_sme().doubleValue());
						R0220cell10.setCellStyle(numberStyle);
					} else {
						R0220cell10.setCellValue("");
						R0220cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0220cell11 = row.createCell(11);
					if (record.getR0220_individuals() != null) {
						R0220cell11.setCellValue(record.getR0220_individuals().doubleValue());
						R0220cell11.setCellStyle(numberStyle);
					} else {
						R0220cell11.setCellValue("");
						R0220cell11.setCellStyle(textStyle);
					}

					///// ROW34///////////
					// row34
					row = sheet.getRow(33);
					// Column E:
					Cell R0230cell4 = row.createCell(4);
					if (record.getR0230_aed_amount() != null) {
						R0230cell4.setCellValue(record.getR0230_aed_amount().doubleValue());
						R0230cell4.setCellStyle(numberStyle);
					} else {
						R0230cell4.setCellValue("");
						R0230cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0230cell5 = row.createCell(5);
					if (record.getR0230_fcy_amount() != null) {
						R0230cell5.setCellValue(record.getR0230_fcy_amount().doubleValue());
						R0230cell5.setCellStyle(numberStyle);
					} else {
						R0230cell5.setCellValue("");
						R0230cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0230cell7 = row.createCell(7);
					if (record.getR0230_non_commercial_entities() != null) {
						R0230cell7.setCellValue(record.getR0230_non_commercial_entities().doubleValue());
						R0230cell7.setCellStyle(numberStyle);
					} else {
						R0230cell7.setCellValue("");
						R0230cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0230cell8 = row.createCell(8);
					if (record.getR0230_commercial_entities() != null) {
						R0230cell8.setCellValue(record.getR0230_commercial_entities().doubleValue());
						R0230cell8.setCellStyle(numberStyle);
					} else {
						R0230cell8.setCellValue("");
						R0230cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0230cell9 = row.createCell(9);
					if (record.getR0230_private_corporates() != null) {
						R0230cell9.setCellValue(record.getR0230_private_corporates().doubleValue());
						R0230cell9.setCellStyle(numberStyle);
					} else {
						R0230cell9.setCellValue("");
						R0230cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0230cell10 = row.createCell(10);
					if (record.getR0230_sme() != null) {
						R0230cell10.setCellValue(record.getR0230_sme().doubleValue());
						R0230cell10.setCellStyle(numberStyle);
					} else {
						R0230cell10.setCellValue("");
						R0230cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0230cell11 = row.createCell(11);
					if (record.getR0230_individuals() != null) {
						R0230cell11.setCellValue(record.getR0230_individuals().doubleValue());
						R0230cell11.setCellStyle(numberStyle);
					} else {
						R0230cell11.setCellValue("");
						R0230cell11.setCellStyle(textStyle);
					}

					///// ROW36///////////
					// row36
					row = sheet.getRow(35);
					// Column E:
					Cell R0250cell4 = row.createCell(4);
					if (record.getR0250_aed_amount() != null) {
						R0250cell4.setCellValue(record.getR0250_aed_amount().doubleValue());
						R0250cell4.setCellStyle(numberStyle);
					} else {
						R0250cell4.setCellValue("");
						R0250cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0250cell5 = row.createCell(5);
					if (record.getR0250_fcy_amount() != null) {
						R0250cell5.setCellValue(record.getR0250_fcy_amount().doubleValue());
						R0250cell5.setCellStyle(numberStyle);
					} else {
						R0250cell5.setCellValue("");
						R0250cell5.setCellStyle(textStyle);
					}

					///// ROW39///////////
					// row39
					row = sheet.getRow(38);
					// Column E:
					Cell R0280cell4 = row.createCell(4);
					if (record.getR0280_aed_amount() != null) {
						R0280cell4.setCellValue(record.getR0280_aed_amount().doubleValue());
						R0280cell4.setCellStyle(numberStyle);
					} else {
						R0280cell4.setCellValue("");
						R0280cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0280cell5 = row.createCell(5);
					if (record.getR0280_fcy_amount() != null) {
						R0280cell5.setCellValue(record.getR0280_fcy_amount().doubleValue());
						R0280cell5.setCellStyle(numberStyle);
					} else {
						R0280cell5.setCellValue("");
						R0280cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0280cell7 = row.createCell(7);
					if (record.getR0280_non_commercial_entities() != null) {
						R0280cell7.setCellValue(record.getR0280_non_commercial_entities().doubleValue());
						R0280cell7.setCellStyle(numberStyle);
					} else {
						R0280cell7.setCellValue("");
						R0280cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0280cell8 = row.createCell(8);
					if (record.getR0280_commercial_entities() != null) {
						R0280cell8.setCellValue(record.getR0280_commercial_entities().doubleValue());
						R0280cell8.setCellStyle(numberStyle);
					} else {
						R0280cell8.setCellValue("");
						R0280cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0280cell9 = row.createCell(9);
					if (record.getR0280_private_corporates() != null) {
						R0280cell9.setCellValue(record.getR0280_private_corporates().doubleValue());
						R0280cell9.setCellStyle(numberStyle);
					} else {
						R0280cell9.setCellValue("");
						R0280cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0280cell10 = row.createCell(10);
					if (record.getR0280_sme() != null) {
						R0280cell10.setCellValue(record.getR0280_sme().doubleValue());
						R0280cell10.setCellStyle(numberStyle);
					} else {
						R0280cell10.setCellValue("");
						R0280cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0280cell11 = row.createCell(11);
					if (record.getR0280_individuals() != null) {
						R0280cell11.setCellValue(record.getR0280_individuals().doubleValue());
						R0280cell11.setCellStyle(numberStyle);
					} else {
						R0280cell11.setCellValue("");
						R0280cell11.setCellStyle(textStyle);
					}

					///// ROW40///////////
					// row40
					row = sheet.getRow(39);
					// Column E:
					Cell R0290cell4 = row.createCell(4);
					if (record.getR0290_aed_amount() != null) {
						R0290cell4.setCellValue(record.getR0290_aed_amount().doubleValue());
						R0290cell4.setCellStyle(numberStyle);
					} else {
						R0290cell4.setCellValue("");
						R0290cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0290cell5 = row.createCell(5);
					if (record.getR0290_fcy_amount() != null) {
						R0290cell5.setCellValue(record.getR0290_fcy_amount().doubleValue());
						R0290cell5.setCellStyle(numberStyle);
					} else {
						R0290cell5.setCellValue("");
						R0290cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0290cell7 = row.createCell(7);
					if (record.getR0290_non_commercial_entities() != null) {
						R0290cell7.setCellValue(record.getR0290_non_commercial_entities().doubleValue());
						R0290cell7.setCellStyle(numberStyle);
					} else {
						R0290cell7.setCellValue("");
						R0290cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0290cell8 = row.createCell(8);
					if (record.getR0290_commercial_entities() != null) {
						R0290cell8.setCellValue(record.getR0290_commercial_entities().doubleValue());
						R0290cell8.setCellStyle(numberStyle);
					} else {
						R0290cell8.setCellValue("");
						R0290cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0290cell9 = row.createCell(9);
					if (record.getR0290_private_corporates() != null) {
						R0290cell9.setCellValue(record.getR0290_private_corporates().doubleValue());
						R0290cell9.setCellStyle(numberStyle);
					} else {
						R0290cell9.setCellValue("");
						R0290cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0290cell10 = row.createCell(10);
					if (record.getR0290_sme() != null) {
						R0290cell10.setCellValue(record.getR0290_sme().doubleValue());
						R0290cell10.setCellStyle(numberStyle);
					} else {
						R0290cell10.setCellValue("");
						R0290cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0290cell11 = row.createCell(11);
					if (record.getR0290_individuals() != null) {
						R0290cell11.setCellValue(record.getR0290_individuals().doubleValue());
						R0290cell11.setCellStyle(numberStyle);
					} else {
						R0290cell11.setCellValue("");
						R0290cell11.setCellStyle(textStyle);
					}

					///// ROW41///////////
					// row41
					row = sheet.getRow(40);
					// Column E:
					Cell R0300cell4 = row.createCell(4);
					if (record.getR0300_aed_amount() != null) {
						R0300cell4.setCellValue(record.getR0300_aed_amount().doubleValue());
						R0300cell4.setCellStyle(numberStyle);
					} else {
						R0300cell4.setCellValue("");
						R0300cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0300cell5 = row.createCell(5);
					if (record.getR0300_fcy_amount() != null) {
						R0300cell5.setCellValue(record.getR0300_fcy_amount().doubleValue());
						R0300cell5.setCellStyle(numberStyle);
					} else {
						R0300cell5.setCellValue("");
						R0300cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0300cell7 = row.createCell(7);
					if (record.getR0300_non_commercial_entities() != null) {
						R0300cell7.setCellValue(record.getR0300_non_commercial_entities().doubleValue());
						R0300cell7.setCellStyle(numberStyle);
					} else {
						R0300cell7.setCellValue("");
						R0300cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0300cell8 = row.createCell(8);
					if (record.getR0300_commercial_entities() != null) {
						R0300cell8.setCellValue(record.getR0300_commercial_entities().doubleValue());
						R0300cell8.setCellStyle(numberStyle);
					} else {
						R0300cell8.setCellValue("");
						R0300cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0300cell9 = row.createCell(9);
					if (record.getR0300_private_corporates() != null) {
						R0300cell9.setCellValue(record.getR0300_private_corporates().doubleValue());
						R0300cell9.setCellStyle(numberStyle);
					} else {
						R0300cell9.setCellValue("");
						R0300cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0300cell10 = row.createCell(10);
					if (record.getR0300_sme() != null) {
						R0300cell10.setCellValue(record.getR0300_sme().doubleValue());
						R0300cell10.setCellStyle(numberStyle);
					} else {
						R0300cell10.setCellValue("");
						R0300cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0300cell11 = row.createCell(11);
					if (record.getR0300_individuals() != null) {
						R0300cell11.setCellValue(record.getR0300_individuals().doubleValue());
						R0300cell11.setCellStyle(numberStyle);
					} else {
						R0300cell11.setCellValue("");
						R0300cell11.setCellStyle(textStyle);
					}

					///// ROW42///////////
					// row42
					row = sheet.getRow(41);
					// Column E:
					Cell R0310cell4 = row.createCell(4);
					if (record.getR0310_aed_amount() != null) {
						R0310cell4.setCellValue(record.getR0310_aed_amount().doubleValue());
						R0310cell4.setCellStyle(numberStyle);
					} else {
						R0310cell4.setCellValue("");
						R0310cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0310cell5 = row.createCell(5);
					if (record.getR0310_fcy_amount() != null) {
						R0310cell5.setCellValue(record.getR0310_fcy_amount().doubleValue());
						R0310cell5.setCellStyle(numberStyle);
					} else {
						R0310cell5.setCellValue("");
						R0310cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0310cell7 = row.createCell(7);
					if (record.getR0310_non_commercial_entities() != null) {
						R0310cell7.setCellValue(record.getR0310_non_commercial_entities().doubleValue());
						R0310cell7.setCellStyle(numberStyle);
					} else {
						R0310cell7.setCellValue("");
						R0310cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0310cell8 = row.createCell(8);
					if (record.getR0310_commercial_entities() != null) {
						R0310cell8.setCellValue(record.getR0310_commercial_entities().doubleValue());
						R0310cell8.setCellStyle(numberStyle);
					} else {
						R0310cell8.setCellValue("");
						R0310cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0310cell9 = row.createCell(9);
					if (record.getR0310_private_corporates() != null) {
						R0310cell9.setCellValue(record.getR0310_private_corporates().doubleValue());
						R0310cell9.setCellStyle(numberStyle);
					} else {
						R0310cell9.setCellValue("");
						R0310cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0310cell10 = row.createCell(10);
					if (record.getR0310_sme() != null) {
						R0310cell10.setCellValue(record.getR0310_sme().doubleValue());
						R0310cell10.setCellStyle(numberStyle);
					} else {
						R0310cell10.setCellValue("");
						R0310cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0310cell11 = row.createCell(11);
					if (record.getR0310_individuals() != null) {
						R0310cell11.setCellValue(record.getR0310_individuals().doubleValue());
						R0310cell11.setCellStyle(numberStyle);
					} else {
						R0310cell11.setCellValue("");
						R0310cell11.setCellStyle(textStyle);
					}

					///// ROW43///////////
					// row43
					row = sheet.getRow(42);
					// Column E:
					Cell R0320cell4 = row.createCell(4);
					if (record.getR0320_aed_amount() != null) {
						R0320cell4.setCellValue(record.getR0320_aed_amount().doubleValue());
						R0320cell4.setCellStyle(numberStyle);
					} else {
						R0320cell4.setCellValue("");
						R0320cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0320cell5 = row.createCell(5);
					if (record.getR0320_fcy_amount() != null) {
						R0320cell5.setCellValue(record.getR0320_fcy_amount().doubleValue());
						R0320cell5.setCellStyle(numberStyle);
					} else {
						R0320cell5.setCellValue("");
						R0320cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0320cell7 = row.createCell(7);
					if (record.getR0320_non_commercial_entities() != null) {
						R0320cell7.setCellValue(record.getR0320_non_commercial_entities().doubleValue());
						R0320cell7.setCellStyle(numberStyle);
					} else {
						R0320cell7.setCellValue("");
						R0320cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0320cell8 = row.createCell(8);
					if (record.getR0320_commercial_entities() != null) {
						R0320cell8.setCellValue(record.getR0320_commercial_entities().doubleValue());
						R0320cell8.setCellStyle(numberStyle);
					} else {
						R0320cell8.setCellValue("");
						R0320cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0320cell9 = row.createCell(9);
					if (record.getR0320_private_corporates() != null) {
						R0320cell9.setCellValue(record.getR0320_private_corporates().doubleValue());
						R0320cell9.setCellStyle(numberStyle);
					} else {
						R0320cell9.setCellValue("");
						R0320cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0320cell10 = row.createCell(10);
					if (record.getR0320_sme() != null) {
						R0320cell10.setCellValue(record.getR0320_sme().doubleValue());
						R0320cell10.setCellStyle(numberStyle);
					} else {
						R0320cell10.setCellValue("");
						R0320cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0320cell11 = row.createCell(11);
					if (record.getR0320_individuals() != null) {
						R0320cell11.setCellValue(record.getR0320_individuals().doubleValue());
						R0320cell11.setCellStyle(numberStyle);
					} else {
						R0320cell11.setCellValue("");
						R0320cell11.setCellStyle(textStyle);
					}

					///// ROW44///////////
					// row44
					row = sheet.getRow(43);
					// Column E:
					Cell R0330cell4 = row.createCell(4);
					if (record.getR0330_aed_amount() != null) {
						R0330cell4.setCellValue(record.getR0330_aed_amount().doubleValue());
						R0330cell4.setCellStyle(numberStyle);
					} else {
						R0330cell4.setCellValue("");
						R0330cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0330cell5 = row.createCell(5);
					if (record.getR0330_fcy_amount() != null) {
						R0330cell5.setCellValue(record.getR0330_fcy_amount().doubleValue());
						R0330cell5.setCellStyle(numberStyle);
					} else {
						R0330cell5.setCellValue("");
						R0330cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0330cell7 = row.createCell(7);
					if (record.getR0330_non_commercial_entities() != null) {
						R0330cell7.setCellValue(record.getR0330_non_commercial_entities().doubleValue());
						R0330cell7.setCellStyle(numberStyle);
					} else {
						R0330cell7.setCellValue("");
						R0330cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0330cell8 = row.createCell(8);
					if (record.getR0330_commercial_entities() != null) {
						R0330cell8.setCellValue(record.getR0330_commercial_entities().doubleValue());
						R0330cell8.setCellStyle(numberStyle);
					} else {
						R0330cell8.setCellValue("");
						R0330cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0330cell9 = row.createCell(9);
					if (record.getR0330_private_corporates() != null) {
						R0330cell9.setCellValue(record.getR0330_private_corporates().doubleValue());
						R0330cell9.setCellStyle(numberStyle);
					} else {
						R0330cell9.setCellValue("");
						R0330cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0330cell10 = row.createCell(10);
					if (record.getR0330_sme() != null) {
						R0330cell10.setCellValue(record.getR0330_sme().doubleValue());
						R0330cell10.setCellStyle(numberStyle);
					} else {
						R0330cell10.setCellValue("");
						R0330cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0330cell11 = row.createCell(11);
					if (record.getR0330_individuals() != null) {
						R0330cell11.setCellValue(record.getR0330_individuals().doubleValue());
						R0330cell11.setCellStyle(numberStyle);
					} else {
						R0330cell11.setCellValue("");
						R0330cell11.setCellStyle(textStyle);
					}

					///// ROW45///////////
					// row45
					row = sheet.getRow(44);
					// Column E:
					Cell R0340cell4 = row.createCell(4);
					if (record.getR0340_aed_amount() != null) {
						R0340cell4.setCellValue(record.getR0340_aed_amount().doubleValue());
						R0340cell4.setCellStyle(numberStyle);
					} else {
						R0340cell4.setCellValue("");
						R0340cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0340cell5 = row.createCell(5);
					if (record.getR0340_fcy_amount() != null) {
						R0340cell5.setCellValue(record.getR0340_fcy_amount().doubleValue());
						R0340cell5.setCellStyle(numberStyle);
					} else {
						R0340cell5.setCellValue("");
						R0340cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0340cell7 = row.createCell(7);
					if (record.getR0340_non_commercial_entities() != null) {
						R0340cell7.setCellValue(record.getR0340_non_commercial_entities().doubleValue());
						R0340cell7.setCellStyle(numberStyle);
					} else {
						R0340cell7.setCellValue("");
						R0340cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0340cell8 = row.createCell(8);
					if (record.getR0340_commercial_entities() != null) {
						R0340cell8.setCellValue(record.getR0340_commercial_entities().doubleValue());
						R0340cell8.setCellStyle(numberStyle);
					} else {
						R0340cell8.setCellValue("");
						R0340cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0340cell9 = row.createCell(9);
					if (record.getR0340_private_corporates() != null) {
						R0340cell9.setCellValue(record.getR0340_private_corporates().doubleValue());
						R0340cell9.setCellStyle(numberStyle);
					} else {
						R0340cell9.setCellValue("");
						R0340cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0340cell10 = row.createCell(10);
					if (record.getR0340_sme() != null) {
						R0340cell10.setCellValue(record.getR0340_sme().doubleValue());
						R0340cell10.setCellStyle(numberStyle);
					} else {
						R0340cell10.setCellValue("");
						R0340cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0340cell11 = row.createCell(11);
					if (record.getR0340_individuals() != null) {
						R0340cell11.setCellValue(record.getR0340_individuals().doubleValue());
						R0340cell11.setCellStyle(numberStyle);
					} else {
						R0340cell11.setCellValue("");
						R0340cell11.setCellStyle(textStyle);
					}

					///// ROW46///////////
					// row46
					row = sheet.getRow(45);
					// Column E:
					Cell R0350cell4 = row.createCell(4);
					if (record.getR0350_aed_amount() != null) {
						R0350cell4.setCellValue(record.getR0350_aed_amount().doubleValue());
						R0350cell4.setCellStyle(numberStyle);
					} else {
						R0350cell4.setCellValue("");
						R0350cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0350cell5 = row.createCell(5);
					if (record.getR0350_fcy_amount() != null) {
						R0350cell5.setCellValue(record.getR0350_fcy_amount().doubleValue());
						R0350cell5.setCellStyle(numberStyle);
					} else {
						R0350cell5.setCellValue("");
						R0350cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0350cell7 = row.createCell(7);
					if (record.getR0350_non_commercial_entities() != null) {
						R0350cell7.setCellValue(record.getR0350_non_commercial_entities().doubleValue());
						R0350cell7.setCellStyle(numberStyle);
					} else {
						R0350cell7.setCellValue("");
						R0350cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0350cell8 = row.createCell(8);
					if (record.getR0350_commercial_entities() != null) {
						R0350cell8.setCellValue(record.getR0350_commercial_entities().doubleValue());
						R0350cell8.setCellStyle(numberStyle);
					} else {
						R0350cell8.setCellValue("");
						R0350cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0350cell9 = row.createCell(9);
					if (record.getR0350_private_corporates() != null) {
						R0350cell9.setCellValue(record.getR0350_private_corporates().doubleValue());
						R0350cell9.setCellStyle(numberStyle);
					} else {
						R0350cell9.setCellValue("");
						R0350cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0350cell10 = row.createCell(10);
					if (record.getR0350_sme() != null) {
						R0350cell10.setCellValue(record.getR0350_sme().doubleValue());
						R0350cell10.setCellStyle(numberStyle);
					} else {
						R0350cell10.setCellValue("");
						R0350cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0350cell11 = row.createCell(11);
					if (record.getR0350_individuals() != null) {
						R0350cell11.setCellValue(record.getR0350_individuals().doubleValue());
						R0350cell11.setCellStyle(numberStyle);
					} else {
						R0350cell11.setCellValue("");
						R0350cell11.setCellStyle(textStyle);
					}

					///// ROW47///////////
					// row47
					row = sheet.getRow(46);
					// Column E:
					Cell R0360cell4 = row.createCell(4);
					if (record.getR0360_aed_amount() != null) {
						R0360cell4.setCellValue(record.getR0360_aed_amount().doubleValue());
						R0360cell4.setCellStyle(numberStyle);
					} else {
						R0360cell4.setCellValue("");
						R0360cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0360cell5 = row.createCell(5);
					if (record.getR0360_fcy_amount() != null) {
						R0360cell5.setCellValue(record.getR0360_fcy_amount().doubleValue());
						R0360cell5.setCellStyle(numberStyle);
					} else {
						R0360cell5.setCellValue("");
						R0360cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0360cell7 = row.createCell(7);
					if (record.getR0360_non_commercial_entities() != null) {
						R0360cell7.setCellValue(record.getR0360_non_commercial_entities().doubleValue());
						R0360cell7.setCellStyle(numberStyle);
					} else {
						R0360cell7.setCellValue("");
						R0360cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0360cell8 = row.createCell(8);
					if (record.getR0360_commercial_entities() != null) {
						R0360cell8.setCellValue(record.getR0360_commercial_entities().doubleValue());
						R0360cell8.setCellStyle(numberStyle);
					} else {
						R0360cell8.setCellValue("");
						R0360cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0360cell9 = row.createCell(9);
					if (record.getR0360_private_corporates() != null) {
						R0360cell9.setCellValue(record.getR0360_private_corporates().doubleValue());
						R0360cell9.setCellStyle(numberStyle);
					} else {
						R0360cell9.setCellValue("");
						R0360cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0360cell10 = row.createCell(10);
					if (record.getR0360_sme() != null) {
						R0360cell10.setCellValue(record.getR0360_sme().doubleValue());
						R0360cell10.setCellStyle(numberStyle);
					} else {
						R0360cell10.setCellValue("");
						R0360cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0360cell11 = row.createCell(11);
					if (record.getR0360_individuals() != null) {
						R0360cell11.setCellValue(record.getR0360_individuals().doubleValue());
						R0360cell11.setCellStyle(numberStyle);
					} else {
						R0360cell11.setCellValue("");
						R0360cell11.setCellStyle(textStyle);
					}

					///// ROW48///////////
					// row48
					row = sheet.getRow(47);
					// Column E:
					Cell R0370cell4 = row.createCell(4);
					if (record.getR0370_aed_amount() != null) {
						R0370cell4.setCellValue(record.getR0370_aed_amount().doubleValue());
						R0370cell4.setCellStyle(numberStyle);
					} else {
						R0370cell4.setCellValue("");
						R0370cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0370cell5 = row.createCell(5);
					if (record.getR0370_fcy_amount() != null) {
						R0370cell5.setCellValue(record.getR0370_fcy_amount().doubleValue());
						R0370cell5.setCellStyle(numberStyle);
					} else {
						R0370cell5.setCellValue("");
						R0370cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0370cell7 = row.createCell(7);
					if (record.getR0370_non_commercial_entities() != null) {
						R0370cell7.setCellValue(record.getR0370_non_commercial_entities().doubleValue());
						R0370cell7.setCellStyle(numberStyle);
					} else {
						R0370cell7.setCellValue("");
						R0370cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0370cell8 = row.createCell(8);
					if (record.getR0370_commercial_entities() != null) {
						R0370cell8.setCellValue(record.getR0370_commercial_entities().doubleValue());
						R0370cell8.setCellStyle(numberStyle);
					} else {
						R0370cell8.setCellValue("");
						R0370cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0370cell9 = row.createCell(9);
					if (record.getR0370_private_corporates() != null) {
						R0370cell9.setCellValue(record.getR0370_private_corporates().doubleValue());
						R0370cell9.setCellStyle(numberStyle);
					} else {
						R0370cell9.setCellValue("");
						R0370cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0370cell10 = row.createCell(10);
					if (record.getR0370_sme() != null) {
						R0370cell10.setCellValue(record.getR0370_sme().doubleValue());
						R0370cell10.setCellStyle(numberStyle);
					} else {
						R0370cell10.setCellValue("");
						R0370cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0370cell11 = row.createCell(11);
					if (record.getR0370_individuals() != null) {
						R0370cell11.setCellValue(record.getR0370_individuals().doubleValue());
						R0370cell11.setCellStyle(numberStyle);
					} else {
						R0370cell11.setCellValue("");
						R0370cell11.setCellStyle(textStyle);
					}

					///// ROW50///////////
					// row50
					row = sheet.getRow(49);
					// Column E:
					Cell R0390cell4 = row.createCell(4);
					if (record.getR0390_aed_amount() != null) {
						R0390cell4.setCellValue(record.getR0390_aed_amount().doubleValue());
						R0390cell4.setCellStyle(numberStyle);
					} else {
						R0390cell4.setCellValue("");
						R0390cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0390cell5 = row.createCell(5);
					if (record.getR0390_fcy_amount() != null) {
						R0390cell5.setCellValue(record.getR0390_fcy_amount().doubleValue());
						R0390cell5.setCellStyle(numberStyle);
					} else {
						R0390cell5.setCellValue("");
						R0390cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0390cell7 = row.createCell(7);
					if (record.getR0390_non_commercial_entities() != null) {
						R0390cell7.setCellValue(record.getR0390_non_commercial_entities().doubleValue());
						R0390cell7.setCellStyle(numberStyle);
					} else {
						R0390cell7.setCellValue("");
						R0390cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0390cell8 = row.createCell(8);
					if (record.getR0390_commercial_entities() != null) {
						R0390cell8.setCellValue(record.getR0390_commercial_entities().doubleValue());
						R0390cell8.setCellStyle(numberStyle);
					} else {
						R0390cell8.setCellValue("");
						R0390cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0390cell9 = row.createCell(9);
					if (record.getR0390_private_corporates() != null) {
						R0390cell9.setCellValue(record.getR0390_private_corporates().doubleValue());
						R0390cell9.setCellStyle(numberStyle);
					} else {
						R0390cell9.setCellValue("");
						R0390cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0390cell10 = row.createCell(10);
					if (record.getR0390_sme() != null) {
						R0390cell10.setCellValue(record.getR0390_sme().doubleValue());
						R0390cell10.setCellStyle(numberStyle);
					} else {
						R0390cell10.setCellValue("");
						R0390cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0390cell11 = row.createCell(11);
					if (record.getR0390_individuals() != null) {
						R0390cell11.setCellValue(record.getR0390_individuals().doubleValue());
						R0390cell11.setCellStyle(numberStyle);
					} else {
						R0390cell11.setCellValue("");
						R0390cell11.setCellStyle(textStyle);
					}

					///// ROW51///////////
					// row51
					row = sheet.getRow(50);
					// Column E:
					Cell R0400cell4 = row.createCell(4);
					if (record.getR0400_aed_amount() != null) {
						R0400cell4.setCellValue(record.getR0400_aed_amount().doubleValue());
						R0400cell4.setCellStyle(numberStyle);
					} else {
						R0400cell4.setCellValue("");
						R0400cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0400cell5 = row.createCell(5);
					if (record.getR0400_fcy_amount() != null) {
						R0400cell5.setCellValue(record.getR0400_fcy_amount().doubleValue());
						R0400cell5.setCellStyle(numberStyle);
					} else {
						R0400cell5.setCellValue("");
						R0400cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0400cell7 = row.createCell(7);
					if (record.getR0400_non_commercial_entities() != null) {
						R0400cell7.setCellValue(record.getR0400_non_commercial_entities().doubleValue());
						R0400cell7.setCellStyle(numberStyle);
					} else {
						R0400cell7.setCellValue("");
						R0400cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0400cell8 = row.createCell(8);
					if (record.getR0400_commercial_entities() != null) {
						R0400cell8.setCellValue(record.getR0400_commercial_entities().doubleValue());
						R0400cell8.setCellStyle(numberStyle);
					} else {
						R0400cell8.setCellValue("");
						R0400cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0400cell9 = row.createCell(9);
					if (record.getR0400_private_corporates() != null) {
						R0400cell9.setCellValue(record.getR0400_private_corporates().doubleValue());
						R0400cell9.setCellStyle(numberStyle);
					} else {
						R0400cell9.setCellValue("");
						R0400cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0400cell10 = row.createCell(10);
					if (record.getR0400_sme() != null) {
						R0400cell10.setCellValue(record.getR0400_sme().doubleValue());
						R0400cell10.setCellStyle(numberStyle);
					} else {
						R0400cell10.setCellValue("");
						R0400cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0400cell11 = row.createCell(11);
					if (record.getR0400_individuals() != null) {
						R0400cell11.setCellValue(record.getR0400_individuals().doubleValue());
						R0400cell11.setCellStyle(numberStyle);
					} else {
						R0400cell11.setCellValue("");
						R0400cell11.setCellStyle(textStyle);
					}

					///// ROW52///////////
					// row52
					row = sheet.getRow(51);
					// Column E:
					Cell R0410cell4 = row.createCell(4);
					if (record.getR0410_aed_amount() != null) {
						R0410cell4.setCellValue(record.getR0410_aed_amount().doubleValue());
						R0410cell4.setCellStyle(numberStyle);
					} else {
						R0410cell4.setCellValue("");
						R0410cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0410cell5 = row.createCell(5);
					if (record.getR0410_fcy_amount() != null) {
						R0410cell5.setCellValue(record.getR0410_fcy_amount().doubleValue());
						R0410cell5.setCellStyle(numberStyle);
					} else {
						R0410cell5.setCellValue("");
						R0410cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0410cell7 = row.createCell(7);
					if (record.getR0410_non_commercial_entities() != null) {
						R0410cell7.setCellValue(record.getR0410_non_commercial_entities().doubleValue());
						R0410cell7.setCellStyle(numberStyle);
					} else {
						R0410cell7.setCellValue("");
						R0410cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0410cell8 = row.createCell(8);
					if (record.getR0410_commercial_entities() != null) {
						R0410cell8.setCellValue(record.getR0410_commercial_entities().doubleValue());
						R0410cell8.setCellStyle(numberStyle);
					} else {
						R0410cell8.setCellValue("");
						R0410cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0410cell9 = row.createCell(9);
					if (record.getR0410_private_corporates() != null) {
						R0410cell9.setCellValue(record.getR0410_private_corporates().doubleValue());
						R0410cell9.setCellStyle(numberStyle);
					} else {
						R0410cell9.setCellValue("");
						R0410cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0410cell10 = row.createCell(10);
					if (record.getR0410_sme() != null) {
						R0410cell10.setCellValue(record.getR0410_sme().doubleValue());
						R0410cell10.setCellStyle(numberStyle);
					} else {
						R0410cell10.setCellValue("");
						R0410cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0410cell11 = row.createCell(11);
					if (record.getR0410_individuals() != null) {
						R0410cell11.setCellValue(record.getR0410_individuals().doubleValue());
						R0410cell11.setCellStyle(numberStyle);
					} else {
						R0410cell11.setCellValue("");
						R0410cell11.setCellStyle(textStyle);
					}

					///// ROW53///////////
					// row53
					row = sheet.getRow(52);
					// Column E:
					Cell R0420cell4 = row.createCell(4);
					if (record.getR0420_aed_amount() != null) {
						R0420cell4.setCellValue(record.getR0420_aed_amount().doubleValue());
						R0420cell4.setCellStyle(numberStyle);
					} else {
						R0420cell4.setCellValue("");
						R0420cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0420cell5 = row.createCell(5);
					if (record.getR0420_fcy_amount() != null) {
						R0420cell5.setCellValue(record.getR0420_fcy_amount().doubleValue());
						R0420cell5.setCellStyle(numberStyle);
					} else {
						R0420cell5.setCellValue("");
						R0420cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0420cell7 = row.createCell(7);
					if (record.getR0420_non_commercial_entities() != null) {
						R0420cell7.setCellValue(record.getR0420_non_commercial_entities().doubleValue());
						R0420cell7.setCellStyle(numberStyle);
					} else {
						R0420cell7.setCellValue("");
						R0420cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0420cell8 = row.createCell(8);
					if (record.getR0420_commercial_entities() != null) {
						R0420cell8.setCellValue(record.getR0420_commercial_entities().doubleValue());
						R0420cell8.setCellStyle(numberStyle);
					} else {
						R0420cell8.setCellValue("");
						R0420cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0420cell9 = row.createCell(9);
					if (record.getR0420_private_corporates() != null) {
						R0420cell9.setCellValue(record.getR0420_private_corporates().doubleValue());
						R0420cell9.setCellStyle(numberStyle);
					} else {
						R0420cell9.setCellValue("");
						R0420cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0420cell10 = row.createCell(10);
					if (record.getR0420_sme() != null) {
						R0420cell10.setCellValue(record.getR0420_sme().doubleValue());
						R0420cell10.setCellStyle(numberStyle);
					} else {
						R0420cell10.setCellValue("");
						R0420cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0420cell11 = row.createCell(11);
					if (record.getR0420_individuals() != null) {
						R0420cell11.setCellValue(record.getR0420_individuals().doubleValue());
						R0420cell11.setCellStyle(numberStyle);
					} else {
						R0420cell11.setCellValue("");
						R0420cell11.setCellStyle(textStyle);
					}

					///// ROW54///////////
					// row54
					row = sheet.getRow(53);
					// Column E:
					Cell R0430cell4 = row.createCell(4);
					if (record.getR0430_aed_amount() != null) {
						R0430cell4.setCellValue(record.getR0430_aed_amount().doubleValue());
						R0430cell4.setCellStyle(numberStyle);
					} else {
						R0430cell4.setCellValue("");
						R0430cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0430cell5 = row.createCell(5);
					if (record.getR0430_fcy_amount() != null) {
						R0430cell5.setCellValue(record.getR0430_fcy_amount().doubleValue());
						R0430cell5.setCellStyle(numberStyle);
					} else {
						R0430cell5.setCellValue("");
						R0430cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0430cell7 = row.createCell(7);
					if (record.getR0430_non_commercial_entities() != null) {
						R0430cell7.setCellValue(record.getR0430_non_commercial_entities().doubleValue());
						R0430cell7.setCellStyle(numberStyle);
					} else {
						R0430cell7.setCellValue("");
						R0430cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0430cell8 = row.createCell(8);
					if (record.getR0430_commercial_entities() != null) {
						R0430cell8.setCellValue(record.getR0430_commercial_entities().doubleValue());
						R0430cell8.setCellStyle(numberStyle);
					} else {
						R0430cell8.setCellValue("");
						R0430cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0430cell9 = row.createCell(9);
					if (record.getR0430_private_corporates() != null) {
						R0430cell9.setCellValue(record.getR0430_private_corporates().doubleValue());
						R0430cell9.setCellStyle(numberStyle);
					} else {
						R0430cell9.setCellValue("");
						R0430cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0430cell10 = row.createCell(10);
					if (record.getR0430_sme() != null) {
						R0430cell10.setCellValue(record.getR0430_sme().doubleValue());
						R0430cell10.setCellStyle(numberStyle);
					} else {
						R0430cell10.setCellValue("");
						R0430cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0430cell11 = row.createCell(11);
					if (record.getR0430_individuals() != null) {
						R0430cell11.setCellValue(record.getR0430_individuals().doubleValue());
						R0430cell11.setCellStyle(numberStyle);
					} else {
						R0430cell11.setCellValue("");
						R0430cell11.setCellStyle(textStyle);
					}

					///// ROW55///////////
					// row55
					row = sheet.getRow(54);
					// Column E:
					Cell R0440cell4 = row.createCell(4);
					if (record.getR0440_aed_amount() != null) {
						R0440cell4.setCellValue(record.getR0440_aed_amount().doubleValue());
						R0440cell4.setCellStyle(numberStyle);
					} else {
						R0440cell4.setCellValue("");
						R0440cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0440cell5 = row.createCell(5);
					if (record.getR0440_fcy_amount() != null) {
						R0440cell5.setCellValue(record.getR0440_fcy_amount().doubleValue());
						R0440cell5.setCellStyle(numberStyle);
					} else {
						R0440cell5.setCellValue("");
						R0440cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0440cell7 = row.createCell(7);
					if (record.getR0440_non_commercial_entities() != null) {
						R0440cell7.setCellValue(record.getR0440_non_commercial_entities().doubleValue());
						R0440cell7.setCellStyle(numberStyle);
					} else {
						R0440cell7.setCellValue("");
						R0440cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0440cell8 = row.createCell(8);
					if (record.getR0440_commercial_entities() != null) {
						R0440cell8.setCellValue(record.getR0440_commercial_entities().doubleValue());
						R0440cell8.setCellStyle(numberStyle);
					} else {
						R0440cell8.setCellValue("");
						R0440cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0440cell9 = row.createCell(9);
					if (record.getR0440_private_corporates() != null) {
						R0440cell9.setCellValue(record.getR0440_private_corporates().doubleValue());
						R0440cell9.setCellStyle(numberStyle);
					} else {
						R0440cell9.setCellValue("");
						R0440cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0440cell10 = row.createCell(10);
					if (record.getR0440_sme() != null) {
						R0440cell10.setCellValue(record.getR0440_sme().doubleValue());
						R0440cell10.setCellStyle(numberStyle);
					} else {
						R0440cell10.setCellValue("");
						R0440cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0440cell11 = row.createCell(11);
					if (record.getR0440_individuals() != null) {
						R0440cell11.setCellValue(record.getR0440_individuals().doubleValue());
						R0440cell11.setCellStyle(numberStyle);
					} else {
						R0440cell11.setCellValue("");
						R0440cell11.setCellStyle(textStyle);
					}

					///// ROW56///////////
					// row56
					row = sheet.getRow(55);
					// Column E:
					Cell R0450cell4 = row.createCell(4);
					if (record.getR0450_aed_amount() != null) {
						R0450cell4.setCellValue(record.getR0450_aed_amount().doubleValue());
						R0450cell4.setCellStyle(numberStyle);
					} else {
						R0450cell4.setCellValue("");
						R0450cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0450cell5 = row.createCell(5);
					if (record.getR0450_fcy_amount() != null) {
						R0450cell5.setCellValue(record.getR0450_fcy_amount().doubleValue());
						R0450cell5.setCellStyle(numberStyle);
					} else {
						R0450cell5.setCellValue("");
						R0450cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0450cell7 = row.createCell(7);
					if (record.getR0450_non_commercial_entities() != null) {
						R0450cell7.setCellValue(record.getR0450_non_commercial_entities().doubleValue());
						R0450cell7.setCellStyle(numberStyle);
					} else {
						R0450cell7.setCellValue("");
						R0450cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0450cell8 = row.createCell(8);
					if (record.getR0450_commercial_entities() != null) {
						R0450cell8.setCellValue(record.getR0450_commercial_entities().doubleValue());
						R0450cell8.setCellStyle(numberStyle);
					} else {
						R0450cell8.setCellValue("");
						R0450cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0450cell9 = row.createCell(9);
					if (record.getR0450_private_corporates() != null) {
						R0450cell9.setCellValue(record.getR0450_private_corporates().doubleValue());
						R0450cell9.setCellStyle(numberStyle);
					} else {
						R0450cell9.setCellValue("");
						R0450cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0450cell10 = row.createCell(10);
					if (record.getR0450_sme() != null) {
						R0450cell10.setCellValue(record.getR0450_sme().doubleValue());
						R0450cell10.setCellStyle(numberStyle);
					} else {
						R0450cell10.setCellValue("");
						R0450cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0450cell11 = row.createCell(11);
					if (record.getR0450_individuals() != null) {
						R0450cell11.setCellValue(record.getR0450_individuals().doubleValue());
						R0450cell11.setCellStyle(numberStyle);
					} else {
						R0450cell11.setCellValue("");
						R0450cell11.setCellStyle(textStyle);
					}

					///// ROW58///////////
					// row58
					row = sheet.getRow(57);
					// Column E:
					Cell R0470cell4 = row.createCell(4);
					if (record.getR0470_aed_amount() != null) {
						R0470cell4.setCellValue(record.getR0470_aed_amount().doubleValue());
						R0470cell4.setCellStyle(numberStyle);
					} else {
						R0470cell4.setCellValue("");
						R0470cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0470cell5 = row.createCell(5);
					if (record.getR0470_fcy_amount() != null) {
						R0470cell5.setCellValue(record.getR0470_fcy_amount().doubleValue());
						R0470cell5.setCellStyle(numberStyle);
					} else {
						R0470cell5.setCellValue("");
						R0470cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0470cell7 = row.createCell(7);
					if (record.getR0470_non_commercial_entities() != null) {
						R0470cell7.setCellValue(record.getR0470_non_commercial_entities().doubleValue());
						R0470cell7.setCellStyle(numberStyle);
					} else {
						R0470cell7.setCellValue("");
						R0470cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0470cell8 = row.createCell(8);
					if (record.getR0470_commercial_entities() != null) {
						R0470cell8.setCellValue(record.getR0470_commercial_entities().doubleValue());
						R0470cell8.setCellStyle(numberStyle);
					} else {
						R0470cell8.setCellValue("");
						R0470cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0470cell9 = row.createCell(9);
					if (record.getR0470_private_corporates() != null) {
						R0470cell9.setCellValue(record.getR0470_private_corporates().doubleValue());
						R0470cell9.setCellStyle(numberStyle);
					} else {
						R0470cell9.setCellValue("");
						R0470cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0470cell10 = row.createCell(10);
					if (record.getR0470_sme() != null) {
						R0470cell10.setCellValue(record.getR0470_sme().doubleValue());
						R0470cell10.setCellStyle(numberStyle);
					} else {
						R0470cell10.setCellValue("");
						R0470cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0470cell11 = row.createCell(11);
					if (record.getR0470_individuals() != null) {
						R0470cell11.setCellValue(record.getR0470_individuals().doubleValue());
						R0470cell11.setCellStyle(numberStyle);
					} else {
						R0470cell11.setCellValue("");
						R0470cell11.setCellStyle(textStyle);
					}

					///// ROW59///////////
					// row59
					row = sheet.getRow(58);
					// Column E:
					Cell R0480cell4 = row.createCell(4);
					if (record.getR0480_aed_amount() != null) {
						R0480cell4.setCellValue(record.getR0480_aed_amount().doubleValue());
						R0480cell4.setCellStyle(numberStyle);
					} else {
						R0480cell4.setCellValue("");
						R0480cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0480cell5 = row.createCell(5);
					if (record.getR0480_fcy_amount() != null) {
						R0480cell5.setCellValue(record.getR0480_fcy_amount().doubleValue());
						R0480cell5.setCellStyle(numberStyle);
					} else {
						R0480cell5.setCellValue("");
						R0480cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0480cell7 = row.createCell(7);
					if (record.getR0480_non_commercial_entities() != null) {
						R0480cell7.setCellValue(record.getR0480_non_commercial_entities().doubleValue());
						R0480cell7.setCellStyle(numberStyle);
					} else {
						R0480cell7.setCellValue("");
						R0480cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0480cell8 = row.createCell(8);
					if (record.getR0480_commercial_entities() != null) {
						R0480cell8.setCellValue(record.getR0480_commercial_entities().doubleValue());
						R0480cell8.setCellStyle(numberStyle);
					} else {
						R0480cell8.setCellValue("");
						R0480cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0480cell9 = row.createCell(9);
					if (record.getR0480_private_corporates() != null) {
						R0480cell9.setCellValue(record.getR0480_private_corporates().doubleValue());
						R0480cell9.setCellStyle(numberStyle);
					} else {
						R0480cell9.setCellValue("");
						R0480cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0480cell10 = row.createCell(10);
					if (record.getR0480_sme() != null) {
						R0480cell10.setCellValue(record.getR0480_sme().doubleValue());
						R0480cell10.setCellStyle(numberStyle);
					} else {
						R0480cell10.setCellValue("");
						R0480cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0480cell11 = row.createCell(11);
					if (record.getR0480_individuals() != null) {
						R0480cell11.setCellValue(record.getR0480_individuals().doubleValue());
						R0480cell11.setCellStyle(numberStyle);
					} else {
						R0480cell11.setCellValue("");
						R0480cell11.setCellStyle(textStyle);
					}

					///// ROW60///////////
					// row60
					row = sheet.getRow(59);
					// Column E:
					Cell R0490cell4 = row.createCell(4);
					if (record.getR0490_aed_amount() != null) {
						R0490cell4.setCellValue(record.getR0490_aed_amount().doubleValue());
						R0490cell4.setCellStyle(numberStyle);
					} else {
						R0490cell4.setCellValue("");
						R0490cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0490cell5 = row.createCell(5);
					if (record.getR0490_fcy_amount() != null) {
						R0490cell5.setCellValue(record.getR0490_fcy_amount().doubleValue());
						R0490cell5.setCellStyle(numberStyle);
					} else {
						R0490cell5.setCellValue("");
						R0490cell5.setCellStyle(textStyle);
					}

					// Column H:
					Cell R0490cell7 = row.createCell(7);
					if (record.getR0490_non_commercial_entities() != null) {
						R0490cell7.setCellValue(record.getR0490_non_commercial_entities().doubleValue());
						R0490cell7.setCellStyle(numberStyle);
					} else {
						R0490cell7.setCellValue("");
						R0490cell7.setCellStyle(textStyle);
					}

					// Column I:
					Cell R0490cell8 = row.createCell(8);
					if (record.getR0490_commercial_entities() != null) {
						R0490cell8.setCellValue(record.getR0490_commercial_entities().doubleValue());
						R0490cell8.setCellStyle(numberStyle);
					} else {
						R0490cell8.setCellValue("");
						R0490cell8.setCellStyle(textStyle);
					}

					// Column J:
					Cell R0490cell9 = row.createCell(9);
					if (record.getR0490_private_corporates() != null) {
						R0490cell9.setCellValue(record.getR0490_private_corporates().doubleValue());
						R0490cell9.setCellStyle(numberStyle);
					} else {
						R0490cell9.setCellValue("");
						R0490cell9.setCellStyle(textStyle);
					}

					// Column K:
					Cell R0490cell10 = row.createCell(10);
					if (record.getR0490_sme() != null) {
						R0490cell10.setCellValue(record.getR0490_sme().doubleValue());
						R0490cell10.setCellStyle(numberStyle);
					} else {
						R0490cell10.setCellValue("");
						R0490cell10.setCellStyle(textStyle);
					}

					// Column L:
					Cell R0490cell11 = row.createCell(11);
					if (record.getR0490_individuals() != null) {
						R0490cell11.setCellValue(record.getR0490_individuals().doubleValue());
						R0490cell11.setCellStyle(numberStyle);
					} else {
						R0490cell11.setCellValue("");
						R0490cell11.setCellStyle(textStyle);
					}

					///// ROW62///////////
					// row62
					row = sheet.getRow(61);
					// Column E:
					Cell R0510cell4 = row.createCell(4);
					if (record.getR0510_aed_amount() != null) {
						R0510cell4.setCellValue(record.getR0510_aed_amount().doubleValue());
						R0510cell4.setCellStyle(numberStyle);
					} else {
						R0510cell4.setCellValue("");
						R0510cell4.setCellStyle(textStyle);
					}

					// Column F:
					Cell R0510cell5 = row.createCell(5);
					if (record.getR0510_fcy_amount() != null) {
						R0510cell5.setCellValue(record.getR0510_fcy_amount().doubleValue());
						R0510cell5.setCellStyle(numberStyle);
					} else {
						R0510cell5.setCellValue("");
						R0510cell5.setCellStyle(textStyle);
					}

					///// ROW65///////////
					// row65
					row = sheet.getRow(64);
					// Column M:
					Cell R0540cell12 = row.createCell(12);
					if (record.getR0540_minimum_rate() != null) {
						R0540cell12.setCellValue(record.getR0540_minimum_rate().doubleValue());
						R0540cell12.setCellStyle(numberStyle);
					} else {
						R0540cell12.setCellValue("");
						R0540cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0540cell13 = row.createCell(13);
					if (record.getR0540_maximum_rate() != null) {
						R0540cell13.setCellValue(record.getR0540_maximum_rate().doubleValue());
						R0540cell13.setCellStyle(numberStyle);
					} else {
						R0540cell13.setCellValue("");
						R0540cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0540cell14 = row.createCell(14);
					if (record.getR0540_average_rate() != null) {
						R0540cell14.setCellValue(record.getR0540_average_rate().doubleValue());
						R0540cell14.setCellStyle(numberStyle);
					} else {
						R0540cell14.setCellValue("");
						R0540cell14.setCellStyle(textStyle);
					}

					///// ROW66///////////
					// row66
					row = sheet.getRow(65);
					// Column M:
					Cell R0550cell12 = row.createCell(12);
					if (record.getR0550_minimum_rate() != null) {
						R0550cell12.setCellValue(record.getR0550_minimum_rate().doubleValue());
						R0550cell12.setCellStyle(numberStyle);
					} else {
						R0550cell12.setCellValue("");
						R0550cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0550cell13 = row.createCell(13);
					if (record.getR0550_maximum_rate() != null) {
						R0550cell13.setCellValue(record.getR0550_maximum_rate().doubleValue());
						R0550cell13.setCellStyle(numberStyle);
					} else {
						R0550cell13.setCellValue("");
						R0550cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0550cell14 = row.createCell(14);
					if (record.getR0550_average_rate() != null) {
						R0550cell14.setCellValue(record.getR0550_average_rate().doubleValue());
						R0550cell14.setCellStyle(numberStyle);
					} else {
						R0550cell14.setCellValue("");
						R0550cell14.setCellStyle(textStyle);
					}

					///// ROW67///////////
					// row67
					row = sheet.getRow(66);
					// Column M:
					Cell R0560cell12 = row.createCell(12);
					if (record.getR0560_minimum_rate() != null) {
						R0560cell12.setCellValue(record.getR0560_minimum_rate().doubleValue());
						R0560cell12.setCellStyle(numberStyle);
					} else {
						R0560cell12.setCellValue("");
						R0560cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0560cell13 = row.createCell(13);
					if (record.getR0560_maximum_rate() != null) {
						R0560cell13.setCellValue(record.getR0560_maximum_rate().doubleValue());
						R0560cell13.setCellStyle(numberStyle);
					} else {
						R0560cell13.setCellValue("");
						R0560cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0560cell14 = row.createCell(14);
					if (record.getR0560_average_rate() != null) {
						R0560cell14.setCellValue(record.getR0560_average_rate().doubleValue());
						R0560cell14.setCellStyle(numberStyle);
					} else {
						R0560cell14.setCellValue("");
						R0560cell14.setCellStyle(textStyle);
					}

					///// ROW68///////////
					// row68
					row = sheet.getRow(67);
					// Column M:
					Cell R0570cell12 = row.createCell(12);
					if (record.getR0570_minimum_rate() != null) {
						R0570cell12.setCellValue(record.getR0570_minimum_rate().doubleValue());
						R0570cell12.setCellStyle(numberStyle);
					} else {
						R0570cell12.setCellValue("");
						R0570cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0570cell13 = row.createCell(13);
					if (record.getR0570_maximum_rate() != null) {
						R0570cell13.setCellValue(record.getR0570_maximum_rate().doubleValue());
						R0570cell13.setCellStyle(numberStyle);
					} else {
						R0570cell13.setCellValue("");
						R0570cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0570cell14 = row.createCell(14);
					if (record.getR0570_average_rate() != null) {
						R0570cell14.setCellValue(record.getR0570_average_rate().doubleValue());
						R0570cell14.setCellStyle(numberStyle);
					} else {
						R0570cell14.setCellValue("");
						R0570cell14.setCellStyle(textStyle);
					}

					///// ROW69///////////
					// row69
					row = sheet.getRow(68);
					// Column M:
					Cell R0580cell12 = row.createCell(12);
					if (record.getR0580_minimum_rate() != null) {
						R0580cell12.setCellValue(record.getR0580_minimum_rate().doubleValue());
						R0580cell12.setCellStyle(numberStyle);
					} else {
						R0580cell12.setCellValue("");
						R0580cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0580cell13 = row.createCell(13);
					if (record.getR0580_maximum_rate() != null) {
						R0580cell13.setCellValue(record.getR0580_maximum_rate().doubleValue());
						R0580cell13.setCellStyle(numberStyle);
					} else {
						R0580cell13.setCellValue("");
						R0580cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0580cell14 = row.createCell(14);
					if (record.getR0580_average_rate() != null) {
						R0580cell14.setCellValue(record.getR0580_average_rate().doubleValue());
						R0580cell14.setCellStyle(numberStyle);
					} else {
						R0580cell14.setCellValue("");
						R0580cell14.setCellStyle(textStyle);
					}

					///// ROW70///////////
					// row70
					row = sheet.getRow(69);
					// Column M:
					Cell R0590cell12 = row.createCell(12);
					if (record.getR0590_minimum_rate() != null) {
						R0590cell12.setCellValue(record.getR0590_minimum_rate().doubleValue());
						R0590cell12.setCellStyle(numberStyle);
					} else {
						R0590cell12.setCellValue("");
						R0590cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0590cell13 = row.createCell(13);
					if (record.getR0590_maximum_rate() != null) {
						R0590cell13.setCellValue(record.getR0590_maximum_rate().doubleValue());
						R0590cell13.setCellStyle(numberStyle);
					} else {
						R0590cell13.setCellValue("");
						R0590cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0590cell14 = row.createCell(14);
					if (record.getR0590_average_rate() != null) {
						R0590cell14.setCellValue(record.getR0590_average_rate().doubleValue());
						R0590cell14.setCellStyle(numberStyle);
					} else {
						R0590cell14.setCellValue("");
						R0590cell14.setCellStyle(textStyle);
					}

					///// ROW71///////////
					// row71
					row = sheet.getRow(70);
					// Column M:
					Cell R0600cell12 = row.createCell(12);
					if (record.getR0600_minimum_rate() != null) {
						R0600cell12.setCellValue(record.getR0600_minimum_rate().doubleValue());
						R0600cell12.setCellStyle(numberStyle);
					} else {
						R0600cell12.setCellValue("");
						R0600cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0600cell13 = row.createCell(13);
					if (record.getR0600_maximum_rate() != null) {
						R0600cell13.setCellValue(record.getR0600_maximum_rate().doubleValue());
						R0600cell13.setCellStyle(numberStyle);
					} else {
						R0600cell13.setCellValue("");
						R0600cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0600cell14 = row.createCell(14);
					if (record.getR0600_average_rate() != null) {
						R0600cell14.setCellValue(record.getR0600_average_rate().doubleValue());
						R0600cell14.setCellStyle(numberStyle);
					} else {
						R0600cell14.setCellValue("");
						R0600cell14.setCellStyle(textStyle);
					}

					///// ROW72///////////
					// row72
					row = sheet.getRow(71);
					// Column M:
					Cell R0610cell12 = row.createCell(12);
					if (record.getR0610_minimum_rate() != null) {
						R0610cell12.setCellValue(record.getR0610_minimum_rate().doubleValue());
						R0610cell12.setCellStyle(numberStyle);
					} else {
						R0610cell12.setCellValue("");
						R0610cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0610cell13 = row.createCell(13);
					if (record.getR0610_maximum_rate() != null) {
						R0610cell13.setCellValue(record.getR0610_maximum_rate().doubleValue());
						R0610cell13.setCellStyle(numberStyle);
					} else {
						R0610cell13.setCellValue("");
						R0610cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0610cell14 = row.createCell(14);
					if (record.getR0610_average_rate() != null) {
						R0610cell14.setCellValue(record.getR0610_average_rate().doubleValue());
						R0610cell14.setCellStyle(numberStyle);
					} else {
						R0610cell14.setCellValue("");
						R0610cell14.setCellStyle(textStyle);
					}

					///// ROW73///////////
					// row73
				
					row = sheet.getRow(72);
					// Column M:
					Cell R0620cell12 = row.createCell(12);
					if (record.getR0620_minimum_rate() != null) {
						R0620cell12.setCellValue(record.getR0620_minimum_rate().doubleValue());
						R0620cell12.setCellStyle(numberStyle);
					} else {
						R0620cell12.setCellValue("");
						R0620cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0620cell13 = row.createCell(13);
					if (record.getR0620_maximum_rate() != null) {
						R0620cell13.setCellValue(record.getR0620_maximum_rate().doubleValue());
						R0620cell13.setCellStyle(numberStyle);
					} else {
						R0620cell13.setCellValue("");
						R0620cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0620cell14 = row.createCell(14);
					if (record.getR0620_average_rate() != null) {
						R0620cell14.setCellValue(record.getR0620_average_rate().doubleValue());
						R0620cell14.setCellStyle(numberStyle);
					} else {
						R0620cell14.setCellValue("");
						R0620cell14.setCellStyle(textStyle);
					}

					///// ROW74///////////
					// row74
					row = sheet.getRow(73);
					// Column M:
					Cell R0630cell12 = row.createCell(12);
					if (record.getR0630_minimum_rate() != null) {
						R0630cell12.setCellValue(record.getR0630_minimum_rate().doubleValue());
						R0630cell12.setCellStyle(numberStyle);
					} else {
						R0630cell12.setCellValue("");
						R0630cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0630cell13 = row.createCell(13);
					if (record.getR0630_maximum_rate() != null) {
						R0630cell13.setCellValue(record.getR0630_maximum_rate().doubleValue());
						R0630cell13.setCellStyle(numberStyle);
					} else {
						R0630cell13.setCellValue("");
						R0630cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0630cell14 = row.createCell(14);
					if (record.getR0630_average_rate() != null) {
						R0630cell14.setCellValue(record.getR0630_average_rate().doubleValue());
						R0630cell14.setCellStyle(numberStyle);
					} else {
						R0630cell14.setCellValue("");
						R0630cell14.setCellStyle(textStyle);
					}

					///// ROW75///////////
					// row75
					// Column M:
					row = sheet.getRow(74);
					Cell R0640cell12 = row.createCell(12);
					if (record.getR0640_minimum_rate() != null) {
						R0640cell12.setCellValue(record.getR0640_minimum_rate().doubleValue());
						R0640cell12.setCellStyle(numberStyle);
					} else {
						R0640cell12.setCellValue("");
						R0640cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0640cell13 = row.createCell(13);
					if (record.getR0640_maximum_rate() != null) {
						R0640cell13.setCellValue(record.getR0640_maximum_rate().doubleValue());
						R0640cell13.setCellStyle(numberStyle);
					} else {
						R0640cell13.setCellValue("");
						R0640cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0640cell14 = row.createCell(14);
					if (record.getR0640_average_rate() != null) {
						R0640cell14.setCellValue(record.getR0640_average_rate().doubleValue());
						R0640cell14.setCellStyle(numberStyle);
					} else {
						R0640cell14.setCellValue("");
						R0640cell14.setCellStyle(textStyle);
					}

					///// ROW76///////////
					// row76
					row = sheet.getRow(75);
					// Column M:
					Cell R0650cell12 = row.createCell(12);
					if (record.getR0650_minimum_rate() != null) {
						R0650cell12.setCellValue(record.getR0650_minimum_rate().doubleValue());
						R0650cell12.setCellStyle(numberStyle);
					} else {
						R0650cell12.setCellValue("");
						R0650cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0650cell13 = row.createCell(13);
					if (record.getR0650_maximum_rate() != null) {
						R0650cell13.setCellValue(record.getR0650_maximum_rate().doubleValue());
						R0650cell13.setCellStyle(numberStyle);
					} else {
						R0650cell13.setCellValue("");
						R0650cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0650cell14 = row.createCell(14);
					if (record.getR0650_average_rate() != null) {
						R0650cell14.setCellValue(record.getR0650_average_rate().doubleValue());
						R0650cell14.setCellStyle(numberStyle);
					} else {
						R0650cell14.setCellValue("");
						R0650cell14.setCellStyle(textStyle);
					}

					///// ROW77///////////
					// row77
					row = sheet.getRow(77);
					// Column M:
					Cell R0660cell12 = row.createCell(12);
					if (record.getR0660_minimum_rate() != null) {
						R0660cell12.setCellValue(record.getR0660_minimum_rate().doubleValue());
						R0660cell12.setCellStyle(numberStyle);
					} else {
						R0660cell12.setCellValue("");
						R0660cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0660cell13 = row.createCell(13);
					if (record.getR0660_maximum_rate() != null) {
						R0660cell13.setCellValue(record.getR0660_maximum_rate().doubleValue());
						R0660cell13.setCellStyle(numberStyle);
					} else {
						R0660cell13.setCellValue("");
						R0660cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0660cell14 = row.createCell(14);
					if (record.getR0660_average_rate() != null) {
						R0660cell14.setCellValue(record.getR0660_average_rate().doubleValue());
						R0660cell14.setCellStyle(numberStyle);
					} else {
						R0660cell14.setCellValue("");
						R0660cell14.setCellStyle(textStyle);
					}

					///// ROW78///////////
					// row78
					row = sheet.getRow(77);
					// Column M:
					Cell R0670cell12 = row.createCell(12);
					if (record.getR0670_minimum_rate() != null) {
						R0670cell12.setCellValue(record.getR0670_minimum_rate().doubleValue());
						R0670cell12.setCellStyle(numberStyle);
					} else {
						R0670cell12.setCellValue("");
						R0670cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0670cell13 = row.createCell(13);
					if (record.getR0670_maximum_rate() != null) {
						R0670cell13.setCellValue(record.getR0670_maximum_rate().doubleValue());
						R0670cell13.setCellStyle(numberStyle);
					} else {
						R0670cell13.setCellValue("");
						R0670cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0670cell14 = row.createCell(14);
					if (record.getR0670_average_rate() != null) {
						R0670cell14.setCellValue(record.getR0670_average_rate().doubleValue());
						R0670cell14.setCellStyle(numberStyle);
					} else {
						R0670cell14.setCellValue("");
						R0670cell14.setCellStyle(textStyle);
					}

					///// ROW79///////////
					// row79
					row = sheet.getRow(78);
					// Column M:
					Cell R0680cell12 = row.createCell(12);
					if (record.getR0680_minimum_rate() != null) {
						R0680cell12.setCellValue(record.getR0680_minimum_rate().doubleValue());
						R0680cell12.setCellStyle(numberStyle);
					} else {
						R0680cell12.setCellValue("");
						R0680cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0680cell13 = row.createCell(13);
					if (record.getR0680_maximum_rate() != null) {
						R0680cell13.setCellValue(record.getR0680_maximum_rate().doubleValue());
						R0680cell13.setCellStyle(numberStyle);
					} else {
						R0680cell13.setCellValue("");
						R0680cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0680cell14 = row.createCell(14);
					if (record.getR0680_average_rate() != null) {
						R0680cell14.setCellValue(record.getR0680_average_rate().doubleValue());
						R0680cell14.setCellStyle(numberStyle);
					} else {
						R0680cell14.setCellValue("");
						R0680cell14.setCellStyle(textStyle);
					}

					///// ROW80///////////
					// row80
					row = sheet.getRow(79);
					// Column M:
					Cell R0690cell12 = row.createCell(12);
					if (record.getR0690_minimum_rate() != null) {
						R0690cell12.setCellValue(record.getR0690_minimum_rate().doubleValue());
						R0690cell12.setCellStyle(numberStyle);
					} else {
						R0690cell12.setCellValue("");
						R0690cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0690cell13 = row.createCell(13);
					if (record.getR0690_maximum_rate() != null) {
						R0690cell13.setCellValue(record.getR0690_maximum_rate().doubleValue());
						R0690cell13.setCellStyle(numberStyle);
					} else {
						R0690cell13.setCellValue("");
						R0690cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0690cell14 = row.createCell(14);
					if (record.getR0690_average_rate() != null) {
						R0690cell14.setCellValue(record.getR0690_average_rate().doubleValue());
						R0690cell14.setCellStyle(numberStyle);
					} else {
						R0690cell14.setCellValue("");
						R0690cell14.setCellStyle(textStyle);
					}

					///// ROW81///////////
					// row81
					row = sheet.getRow(80);
					// Column M:
					Cell R0700cell12 = row.createCell(12);
					if (record.getR0700_minimum_rate() != null) {
						R0700cell12.setCellValue(record.getR0700_minimum_rate().doubleValue());
						R0700cell12.setCellStyle(numberStyle);
					} else {
						R0700cell12.setCellValue("");
						R0700cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0700cell13 = row.createCell(13);
					if (record.getR0700_maximum_rate() != null) {
						R0700cell13.setCellValue(record.getR0700_maximum_rate().doubleValue());
						R0700cell13.setCellStyle(numberStyle);
					} else {
						R0700cell13.setCellValue("");
						R0700cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0700cell14 = row.createCell(14);
					if (record.getR0700_average_rate() != null) {
						R0700cell14.setCellValue(record.getR0700_average_rate().doubleValue());
						R0700cell14.setCellStyle(numberStyle);
					} else {
						R0700cell14.setCellValue("");
						R0700cell14.setCellStyle(textStyle);
					}

					///// ROW82///////////
					// row82
					row = sheet.getRow(81);
					// Column M:
					Cell R0710cell12 = row.createCell(12);
					if (record.getR0710_minimum_rate() != null) {
						R0710cell12.setCellValue(record.getR0710_minimum_rate().doubleValue());
						R0710cell12.setCellStyle(numberStyle);
					} else {
						R0710cell12.setCellValue("");
						R0710cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0710cell13 = row.createCell(13);
					if (record.getR0710_maximum_rate() != null) {
						R0710cell13.setCellValue(record.getR0710_maximum_rate().doubleValue());
						R0710cell13.setCellStyle(numberStyle);
					} else {
						R0710cell13.setCellValue("");
						R0710cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0710cell14 = row.createCell(14);
					if (record.getR0710_average_rate() != null) {
						R0710cell14.setCellValue(record.getR0710_average_rate().doubleValue());
						R0710cell14.setCellStyle(numberStyle);
					} else {
						R0710cell14.setCellValue("");
						R0710cell14.setCellStyle(textStyle);
					}

					///// ROW83///////////
					// row83
					row = sheet.getRow(82);
					// Column M:
					Cell R0720cell12 = row.createCell(12);
					if (record.getR0720_minimum_rate() != null) {
						R0720cell12.setCellValue(record.getR0720_minimum_rate().doubleValue());
						R0720cell12.setCellStyle(numberStyle);
					} else {
						R0720cell12.setCellValue("");
						R0720cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0720cell13 = row.createCell(13);
					if (record.getR0720_maximum_rate() != null) {
						R0720cell13.setCellValue(record.getR0720_maximum_rate().doubleValue());
						R0720cell13.setCellStyle(numberStyle);
					} else {
						R0720cell13.setCellValue("");
						R0720cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0720cell14 = row.createCell(14);
					if (record.getR0720_average_rate() != null) {
						R0720cell14.setCellValue(record.getR0720_average_rate().doubleValue());
						R0720cell14.setCellStyle(numberStyle);
					} else {
						R0720cell14.setCellValue("");
						R0720cell14.setCellStyle(textStyle);
					}

					///// ROW84///////////
					// row84
					row = sheet.getRow(83);
					// Column M:
					Cell R0730cell12 = row.createCell(12);
					if (record.getR0730_minimum_rate() != null) {
						R0730cell12.setCellValue(record.getR0730_minimum_rate().doubleValue());
						R0730cell12.setCellStyle(numberStyle);
					} else {
						R0730cell12.setCellValue("");
						R0730cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0730cell13 = row.createCell(13);
					if (record.getR0730_maximum_rate() != null) {
						R0730cell13.setCellValue(record.getR0730_maximum_rate().doubleValue());
						R0730cell13.setCellStyle(numberStyle);
					} else {
						R0730cell13.setCellValue("");
						R0730cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0730cell14 = row.createCell(14);
					if (record.getR0730_average_rate() != null) {
						R0730cell14.setCellValue(record.getR0730_average_rate().doubleValue());
						R0730cell14.setCellStyle(numberStyle);
					} else {
						R0730cell14.setCellValue("");
						R0730cell14.setCellStyle(textStyle);
					}

					///// ROW85///////////
					// row85
					row = sheet.getRow(84);
					// Column M:
					Cell R0740cell12 = row.createCell(12);
					if (record.getR0740_minimum_rate() != null) {
						R0740cell12.setCellValue(record.getR0740_minimum_rate().doubleValue());
						R0740cell12.setCellStyle(numberStyle);
					} else {
						R0740cell12.setCellValue("");
						R0740cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0740cell13 = row.createCell(13);
					if (record.getR0740_maximum_rate() != null) {
						R0740cell13.setCellValue(record.getR0740_maximum_rate().doubleValue());
						R0740cell13.setCellStyle(numberStyle);
					} else {
						R0740cell13.setCellValue("");
						R0740cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0740cell14 = row.createCell(14);
					if (record.getR0740_average_rate() != null) {
						R0740cell14.setCellValue(record.getR0740_average_rate().doubleValue());
						R0740cell14.setCellStyle(numberStyle);
					} else {
						R0740cell14.setCellValue("");
						R0740cell14.setCellStyle(textStyle);
					}

					///// ROW86///////////
					// row86
					row = sheet.getRow(85);
					// Column M:
					Cell R0750cell12 = row.createCell(12);
					if (record.getR0750_minimum_rate() != null) {
						R0750cell12.setCellValue(record.getR0750_minimum_rate().doubleValue());
						R0750cell12.setCellStyle(numberStyle);
					} else {
						R0750cell12.setCellValue("");
						R0750cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0750cell13 = row.createCell(13);
					if (record.getR0750_maximum_rate() != null) {
						R0750cell13.setCellValue(record.getR0750_maximum_rate().doubleValue());
						R0750cell13.setCellStyle(numberStyle);
					} else {
						R0750cell13.setCellValue("");
						R0750cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0750cell14 = row.createCell(14);
					if (record.getR0750_average_rate() != null) {
						R0750cell14.setCellValue(record.getR0750_average_rate().doubleValue());
						R0750cell14.setCellStyle(numberStyle);
					} else {
						R0750cell14.setCellValue("");
						R0750cell14.setCellStyle(textStyle);
					}

					///// ROW88///////////
					// row88
					row = sheet.getRow(87);
					// Column M:
					Cell R0770cell12 = row.createCell(12);
					if (record.getR0770_minimum_rate() != null) {
						R0770cell12.setCellValue(record.getR0770_minimum_rate().doubleValue());
						R0770cell12.setCellStyle(numberStyle);
					} else {
						R0770cell12.setCellValue("");
						R0770cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0770cell13 = row.createCell(13);
					if (record.getR0770_maximum_rate() != null) {
						R0770cell13.setCellValue(record.getR0770_maximum_rate().doubleValue());
						R0770cell13.setCellStyle(numberStyle);
					} else {
						R0770cell13.setCellValue("");
						R0770cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0770cell14 = row.createCell(14);
					if (record.getR0770_average_rate() != null) {
						R0770cell14.setCellValue(record.getR0770_average_rate().doubleValue());
						R0770cell14.setCellStyle(numberStyle);
					} else {
						R0770cell14.setCellValue("");
						R0770cell14.setCellStyle(textStyle);
					}

					///// ROW89///////////
					// row89
					row = sheet.getRow(88);
					// Column M:
					Cell R0780cell12 = row.createCell(12);
					if (record.getR0780_minimum_rate() != null) {
						R0780cell12.setCellValue(record.getR0780_minimum_rate().doubleValue());
						R0780cell12.setCellStyle(numberStyle);
					} else {
						R0780cell12.setCellValue("");
						R0780cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0780cell13 = row.createCell(13);
					if (record.getR0780_maximum_rate() != null) {
						R0780cell13.setCellValue(record.getR0780_maximum_rate().doubleValue());
						R0780cell13.setCellStyle(numberStyle);
					} else {
						R0780cell13.setCellValue("");
						R0780cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0780cell14 = row.createCell(14);
					if (record.getR0780_average_rate() != null) {
						R0780cell14.setCellValue(record.getR0780_average_rate().doubleValue());
						R0780cell14.setCellStyle(numberStyle);
					} else {
						R0780cell14.setCellValue("");
						R0780cell14.setCellStyle(textStyle);
					}

					///// ROW90///////////
					// row90
					row = sheet.getRow(89);
					// Column M:
					Cell R0790cell12 = row.createCell(12);
					if (record.getR0790_minimum_rate() != null) {
						R0790cell12.setCellValue(record.getR0790_minimum_rate().doubleValue());
						R0790cell12.setCellStyle(numberStyle);
					} else {
						R0790cell12.setCellValue("");
						R0790cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0790cell13 = row.createCell(13);
					if (record.getR0790_maximum_rate() != null) {
						R0790cell13.setCellValue(record.getR0790_maximum_rate().doubleValue());
						R0790cell13.setCellStyle(numberStyle);
					} else {
						R0790cell13.setCellValue("");
						R0790cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0790cell14 = row.createCell(14);
					if (record.getR0790_average_rate() != null) {
						R0790cell14.setCellValue(record.getR0790_average_rate().doubleValue());
						R0790cell14.setCellStyle(numberStyle);
					} else {
						R0790cell14.setCellValue("");
						R0790cell14.setCellStyle(textStyle);
					}

					///// ROW91///////////
					// row91
					row = sheet.getRow(90);
					// Column M:
					Cell R0800cell12 = row.createCell(12);
					if (record.getR0800_minimum_rate() != null) {
						R0800cell12.setCellValue(record.getR0800_minimum_rate().doubleValue());
						R0800cell12.setCellStyle(numberStyle);
					} else {
						R0800cell12.setCellValue("");
						R0800cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0800cell13 = row.createCell(13);
					if (record.getR0800_maximum_rate() != null) {
						R0800cell13.setCellValue(record.getR0800_maximum_rate().doubleValue());
						R0800cell13.setCellStyle(numberStyle);
					} else {
						R0800cell13.setCellValue("");
						R0800cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0800cell14 = row.createCell(14);
					if (record.getR0800_average_rate() != null) {
						R0800cell14.setCellValue(record.getR0800_average_rate().doubleValue());
						R0800cell14.setCellStyle(numberStyle);
					} else {
						R0800cell14.setCellValue("");
						R0800cell14.setCellStyle(textStyle);
					}

					///// ROW92///////////
					// row92
					row = sheet.getRow(91);
					// Column M:
					Cell R0810cell12 = row.createCell(12);
					if (record.getR0810_minimum_rate() != null) {
						R0810cell12.setCellValue(record.getR0810_minimum_rate().doubleValue());
						R0810cell12.setCellStyle(numberStyle);
					} else {
						R0810cell12.setCellValue("");
						R0810cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0810cell13 = row.createCell(13);
					if (record.getR0810_maximum_rate() != null) {
						R0810cell13.setCellValue(record.getR0810_maximum_rate().doubleValue());
						R0810cell13.setCellStyle(numberStyle);
					} else {
						R0810cell13.setCellValue("");
						R0810cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0810cell14 = row.createCell(14);
					if (record.getR0810_average_rate() != null) {
						R0810cell14.setCellValue(record.getR0810_average_rate().doubleValue());
						R0810cell14.setCellStyle(numberStyle);
					} else {
						R0810cell14.setCellValue("");
						R0810cell14.setCellStyle(textStyle);
					}

					///// ROW93///////////
					// row93
					row = sheet.getRow(92);
					// Column M:
					Cell R0820cell12 = row.createCell(12);
					if (record.getR0820_minimum_rate() != null) {
						R0820cell12.setCellValue(record.getR0820_minimum_rate().doubleValue());
						R0820cell12.setCellStyle(numberStyle);
					} else {
						R0820cell12.setCellValue("");
						R0820cell12.setCellStyle(textStyle);
					}

					// Column N:
					Cell R0820cell13 = row.createCell(13);
					if (record.getR0820_maximum_rate() != null) {
						R0820cell13.setCellValue(record.getR0820_maximum_rate().doubleValue());
						R0820cell13.setCellStyle(numberStyle);
					} else {
						R0820cell13.setCellValue("");
						R0820cell13.setCellStyle(textStyle);
					}

					// Column O:
					Cell R0820cell14 = row.createCell(14);
					if (record.getR0820_average_rate() != null) {
						R0820cell14.setCellValue(record.getR0820_average_rate().doubleValue());
						R0820cell14.setCellStyle(numberStyle);
					} else {
						R0820cell14.setCellValue("");
						R0820cell14.setCellStyle(textStyle);
					}

				}

				int startRow1 = 94;

				// dataList1 for entity 2
				if (!dataList1.isEmpty()) {
					for (int i = 0; i < dataList1.size(); i++) {
						CBUAE_BRF2_13_Summary_Entity2 record1 = dataList1.get(i);

						System.out.println("rownumber = " + startRow + i);
						Row row = sheet.getRow(startRow + i);
						if (row == null) {
							row = sheet.createRow(startRow + i);
						}

						///// ROW94///////////

						row = sheet.getRow(93);

						///// ROW94///////////
						// row94
						// Column M:
						Cell R0830cell12 = row.createCell(12);
						if (record1.getR0830_minimum_rate() != null) {
							R0830cell12.setCellValue(record1.getR0830_minimum_rate().doubleValue());
							R0830cell12.setCellStyle(numberStyle);
						} else {
							R0830cell12.setCellValue("");
							R0830cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0830cell13 = row.createCell(13);
						if (record1.getR0830_maximum_rate() != null) {
							R0830cell13.setCellValue(record1.getR0830_maximum_rate().doubleValue());
							R0830cell13.setCellStyle(numberStyle);
						} else {
							R0830cell13.setCellValue("");
							R0830cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0830cell14 = row.createCell(14);
						if (record1.getR0830_average_rate() != null) {
							R0830cell14.setCellValue(record1.getR0830_average_rate().doubleValue());
							R0830cell14.setCellStyle(numberStyle);
						} else {
							R0830cell14.setCellValue("");
							R0830cell14.setCellStyle(textStyle);
						}

						///// ROW95///////////
						// row95
						row = sheet.getRow(94);
						// Column M:
						Cell R0840cell12 = row.createCell(12);
						if (record1.getR0840_minimum_rate() != null) {
							R0840cell12.setCellValue(record1.getR0840_minimum_rate().doubleValue());
							R0840cell12.setCellStyle(numberStyle);
						} else {
							R0840cell12.setCellValue("");
							R0840cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0840cell13 = row.createCell(13);
						if (record1.getR0840_maximum_rate() != null) {
							R0840cell13.setCellValue(record1.getR0840_maximum_rate().doubleValue());
							R0840cell13.setCellStyle(numberStyle);
						} else {
							R0840cell13.setCellValue("");
							R0840cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0840cell14 = row.createCell(14);
						if (record1.getR0840_average_rate() != null) {
							R0840cell14.setCellValue(record1.getR0840_average_rate().doubleValue());
							R0840cell14.setCellStyle(numberStyle);
						} else {
							R0840cell14.setCellValue("");
							R0840cell14.setCellStyle(textStyle);
						}

						///// ROW96///////////
						// row96
						row = sheet.getRow(95);
						// Column M:
						Cell R0850cell12 = row.createCell(12);
						if (record1.getR0850_minimum_rate() != null) {
							R0850cell12.setCellValue(record1.getR0850_minimum_rate().doubleValue());
							R0850cell12.setCellStyle(numberStyle);
						} else {
							R0850cell12.setCellValue("");
							R0850cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0850cell13 = row.createCell(13);
						if (record1.getR0850_maximum_rate() != null) {
							R0850cell13.setCellValue(record1.getR0850_maximum_rate().doubleValue());
							R0850cell13.setCellStyle(numberStyle);
						} else {
							R0850cell13.setCellValue("");
							R0850cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0850cell14 = row.createCell(14);
						if (record1.getR0850_average_rate() != null) {
							R0850cell14.setCellValue(record1.getR0850_average_rate().doubleValue());
							R0850cell14.setCellStyle(numberStyle);
						} else {
							R0850cell14.setCellValue("");
							R0850cell14.setCellStyle(textStyle);
						}

						///// ROW97///////////
						// row97
						row = sheet.getRow(96);
						// Column M:
						Cell R0860cell12 = row.createCell(12);
						if (record1.getR0860_minimum_rate() != null) {
							R0860cell12.setCellValue(record1.getR0860_minimum_rate().doubleValue());
							R0860cell12.setCellStyle(numberStyle);
						} else {
							R0860cell12.setCellValue("");
							R0860cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0860cell13 = row.createCell(13);
						if (record1.getR0860_maximum_rate() != null) {
							R0860cell13.setCellValue(record1.getR0860_maximum_rate().doubleValue());
							R0860cell13.setCellStyle(numberStyle);
						} else {
							R0860cell13.setCellValue("");
							R0860cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0860cell14 = row.createCell(14);
						if (record1.getR0860_average_rate() != null) {
							R0860cell14.setCellValue(record1.getR0860_average_rate().doubleValue());
							R0860cell14.setCellStyle(numberStyle);
						} else {
							R0860cell14.setCellValue("");
							R0860cell14.setCellStyle(textStyle);
						}

						///// ROW98///////////
						// row98
						row = sheet.getRow(97);
						// Column M:
						Cell R0870cell12 = row.createCell(12);
						if (record1.getR0870_minimum_rate() != null) {
							R0870cell12.setCellValue(record1.getR0870_minimum_rate().doubleValue());
							R0870cell12.setCellStyle(numberStyle);
						} else {
							R0870cell12.setCellValue("");
							R0870cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0870cell13 = row.createCell(13);
						if (record1.getR0870_maximum_rate() != null) {
							R0870cell13.setCellValue(record1.getR0870_maximum_rate().doubleValue());
							R0870cell13.setCellStyle(numberStyle);
						} else {
							R0870cell13.setCellValue("");
							R0870cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0870cell14 = row.createCell(14);
						if (record1.getR0870_average_rate() != null) {
							R0870cell14.setCellValue(record1.getR0870_average_rate().doubleValue());
							R0870cell14.setCellStyle(numberStyle);
						} else {
							R0870cell14.setCellValue("");
							R0870cell14.setCellStyle(textStyle);
						}

						///// ROW99///////////
						// row99
						row = sheet.getRow(98);
						// Column M:
						Cell R0880cell12 = row.createCell(12);
						if (record1.getR0880_minimum_rate() != null) {
							R0880cell12.setCellValue(record1.getR0880_minimum_rate().doubleValue());
							R0880cell12.setCellStyle(numberStyle);
						} else {
							R0880cell12.setCellValue("");
							R0880cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0880cell13 = row.createCell(13);
						if (record1.getR0880_maximum_rate() != null) {
							R0880cell13.setCellValue(record1.getR0880_maximum_rate().doubleValue());
							R0880cell13.setCellStyle(numberStyle);
						} else {
							R0880cell13.setCellValue("");
							R0880cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0880cell14 = row.createCell(14);
						if (record1.getR0880_average_rate() != null) {
							R0880cell14.setCellValue(record1.getR0880_average_rate().doubleValue());
							R0880cell14.setCellStyle(numberStyle);
						} else {
							R0880cell14.setCellValue("");
							R0880cell14.setCellStyle(textStyle);
						}

						///// ROW100///////////
						// row100
						row = sheet.getRow(99);
						// Column M:
						Cell R0890cell12 = row.createCell(12);
						if (record1.getR0890_minimum_rate() != null) {
							R0890cell12.setCellValue(record1.getR0890_minimum_rate().doubleValue());
							R0890cell12.setCellStyle(numberStyle);
						} else {
							R0890cell12.setCellValue("");
							R0890cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0890cell13 = row.createCell(13);
						if (record1.getR0890_maximum_rate() != null) {
							R0890cell13.setCellValue(record1.getR0890_maximum_rate().doubleValue());
							R0890cell13.setCellStyle(numberStyle);
						} else {
							R0890cell13.setCellValue("");
							R0890cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0890cell14 = row.createCell(14);
						if (record1.getR0890_average_rate() != null) {
							R0890cell14.setCellValue(record1.getR0890_average_rate().doubleValue());
							R0890cell14.setCellStyle(numberStyle);
						} else {
							R0890cell14.setCellValue("");
							R0890cell14.setCellStyle(textStyle);
						}

						///// ROW101///////////
						// row101
						row = sheet.getRow(100);
						// Column M:
						Cell R0900cell12 = row.createCell(12);
						if (record1.getR0900_minimum_rate() != null) {
							R0900cell12.setCellValue(record1.getR0900_minimum_rate().doubleValue());
							R0900cell12.setCellStyle(numberStyle);
						} else {
							R0900cell12.setCellValue("");
							R0900cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0900cell13 = row.createCell(13);
						if (record1.getR0900_maximum_rate() != null) {
							R0900cell13.setCellValue(record1.getR0900_maximum_rate().doubleValue());
							R0900cell13.setCellStyle(numberStyle);
						} else {
							R0900cell13.setCellValue("");
							R0900cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0900cell14 = row.createCell(14);
						if (record1.getR0900_average_rate() != null) {
							R0900cell14.setCellValue(record1.getR0900_average_rate().doubleValue());
							R0900cell14.setCellStyle(numberStyle);
						} else {
							R0900cell14.setCellValue("");
							R0900cell14.setCellStyle(textStyle);
						}

						///// ROW102///////////
						// row102
						row = sheet.getRow(101);
						// Column M:
						Cell R0910cell12 = row.createCell(12);
						if (record1.getR0910_minimum_rate() != null) {
							R0910cell12.setCellValue(record1.getR0910_minimum_rate().doubleValue());
							R0910cell12.setCellStyle(numberStyle);
						} else {
							R0910cell12.setCellValue("");
							R0910cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0910cell13 = row.createCell(13);
						if (record1.getR0910_maximum_rate() != null) {
							R0910cell13.setCellValue(record1.getR0910_maximum_rate().doubleValue());
							R0910cell13.setCellStyle(numberStyle);
						} else {
							R0910cell13.setCellValue("");
							R0910cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0910cell14 = row.createCell(14);
						if (record1.getR0910_average_rate() != null) {
							R0910cell14.setCellValue(record1.getR0910_average_rate().doubleValue());
							R0910cell14.setCellStyle(numberStyle);
						} else {
							R0910cell14.setCellValue("");
							R0910cell14.setCellStyle(textStyle);
						}

						///// ROW103///////////
						// row103
						row = sheet.getRow(102);
						// Column M:
						Cell R0920cell12 = row.createCell(12);
						if (record1.getR0920_minimum_rate() != null) {
							R0920cell12.setCellValue(record1.getR0920_minimum_rate().doubleValue());
							R0920cell12.setCellStyle(numberStyle);
						} else {
							R0920cell12.setCellValue("");
							R0920cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0920cell13 = row.createCell(13);
						if (record1.getR0920_maximum_rate() != null) {
							R0920cell13.setCellValue(record1.getR0920_maximum_rate().doubleValue());
							R0920cell13.setCellStyle(numberStyle);
						} else {
							R0920cell13.setCellValue("");
							R0920cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0920cell14 = row.createCell(14);
						if (record1.getR0920_average_rate() != null) {
							R0920cell14.setCellValue(record1.getR0920_average_rate().doubleValue());
							R0920cell14.setCellStyle(numberStyle);
						} else {
							R0920cell14.setCellValue("");
							R0920cell14.setCellStyle(textStyle);
						}

						///// ROW104///////////
						// row104
						row = sheet.getRow(103);
						// Column M:
						Cell R0930cell12 = row.createCell(12);
						if (record1.getR0930_minimum_rate() != null) {
							R0930cell12.setCellValue(record1.getR0930_minimum_rate().doubleValue());
							R0930cell12.setCellStyle(numberStyle);
						} else {
							R0930cell12.setCellValue("");
							R0930cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0930cell13 = row.createCell(13);
						if (record1.getR0930_maximum_rate() != null) {
							R0930cell13.setCellValue(record1.getR0930_maximum_rate().doubleValue());
							R0930cell13.setCellStyle(numberStyle);
						} else {
							R0930cell13.setCellValue("");
							R0930cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0930cell14 = row.createCell(14);
						if (record1.getR0930_average_rate() != null) {
							R0930cell14.setCellValue(record1.getR0930_average_rate().doubleValue());
							R0930cell14.setCellStyle(numberStyle);
						} else {
							R0930cell14.setCellValue("");
							R0930cell14.setCellStyle(textStyle);
						}

						///// ROW105///////////
						// row105
						row = sheet.getRow(104);
						// Column M:
						Cell R0940cell12 = row.createCell(12);
						if (record1.getR0940_minimum_rate() != null) {
							R0940cell12.setCellValue(record1.getR0940_minimum_rate().doubleValue());
							R0940cell12.setCellStyle(numberStyle);
						} else {
							R0940cell12.setCellValue("");
							R0940cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0940cell13 = row.createCell(13);
						if (record1.getR0940_maximum_rate() != null) {
							R0940cell13.setCellValue(record1.getR0940_maximum_rate().doubleValue());
							R0940cell13.setCellStyle(numberStyle);
						} else {
							R0940cell13.setCellValue("");
							R0940cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0940cell14 = row.createCell(14);
						if (record1.getR0940_average_rate() != null) {
							R0940cell14.setCellValue(record1.getR0940_average_rate().doubleValue());
							R0940cell14.setCellStyle(numberStyle);
						} else {
							R0940cell14.setCellValue("");
							R0940cell14.setCellStyle(textStyle);
						}

						///// ROW106///////////
						// row106
						row = sheet.getRow(105);
						// Column M:
						Cell R0950cell12 = row.createCell(12);
						if (record1.getR0950_minimum_rate() != null) {
							R0950cell12.setCellValue(record1.getR0950_minimum_rate().doubleValue());
							R0950cell12.setCellStyle(numberStyle);
						} else {
							R0950cell12.setCellValue("");
							R0950cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0950cell13 = row.createCell(13);
						if (record1.getR0950_maximum_rate() != null) {
							R0950cell13.setCellValue(record1.getR0950_maximum_rate().doubleValue());
							R0950cell13.setCellStyle(numberStyle);
						} else {
							R0950cell13.setCellValue("");
							R0950cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0950cell14 = row.createCell(14);
						if (record1.getR0950_average_rate() != null) {
							R0950cell14.setCellValue(record1.getR0950_average_rate().doubleValue());
							R0950cell14.setCellStyle(numberStyle);
						} else {
							R0950cell14.setCellValue("");
							R0950cell14.setCellStyle(textStyle);
						}

						///// ROW107///////////
						// row107
						row = sheet.getRow(106);
						// Column M:
						Cell R0960cell12 = row.createCell(12);
						if (record1.getR0960_minimum_rate() != null) {
							R0960cell12.setCellValue(record1.getR0960_minimum_rate().doubleValue());
							R0960cell12.setCellStyle(numberStyle);
						} else {
							R0960cell12.setCellValue("");
							R0960cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0960cell13 = row.createCell(13);
						if (record1.getR0960_maximum_rate() != null) {
							R0960cell13.setCellValue(record1.getR0960_maximum_rate().doubleValue());
							R0960cell13.setCellStyle(numberStyle);
						} else {
							R0960cell13.setCellValue("");
							R0960cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0960cell14 = row.createCell(14);
						if (record1.getR0960_average_rate() != null) {
							R0960cell14.setCellValue(record1.getR0960_average_rate().doubleValue());
							R0960cell14.setCellStyle(numberStyle);
						} else {
							R0960cell14.setCellValue("");
							R0960cell14.setCellStyle(textStyle);
						}

						///// ROW108///////////
						// row108
						row = sheet.getRow(107);
						// Column M:
						Cell R0970cell12 = row.createCell(12);
						if (record1.getR0970_minimum_rate() != null) {
							R0970cell12.setCellValue(record1.getR0970_minimum_rate().doubleValue());
							R0970cell12.setCellStyle(numberStyle);
						} else {
							R0970cell12.setCellValue("");
							R0970cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0970cell13 = row.createCell(13);
						if (record1.getR0970_maximum_rate() != null) {
							R0970cell13.setCellValue(record1.getR0970_maximum_rate().doubleValue());
							R0970cell13.setCellStyle(numberStyle);
						} else {
							R0970cell13.setCellValue("");
							R0970cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0970cell14 = row.createCell(14);
						if (record1.getR0970_average_rate() != null) {
							R0970cell14.setCellValue(record1.getR0970_average_rate().doubleValue());
							R0970cell14.setCellStyle(numberStyle);
						} else {
							R0970cell14.setCellValue("");
							R0970cell14.setCellStyle(textStyle);
						}

						///// ROW109///////////
						// row109
						row = sheet.getRow(108);
						// Column M:
						Cell R0980cell12 = row.createCell(12);
						if (record1.getR0980_minimum_rate() != null) {
							R0980cell12.setCellValue(record1.getR0980_minimum_rate().doubleValue());
							R0980cell12.setCellStyle(numberStyle);
						} else {
							R0980cell12.setCellValue("");
							R0980cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R0980cell13 = row.createCell(13);
						if (record1.getR0980_maximum_rate() != null) {
							R0980cell13.setCellValue(record1.getR0980_maximum_rate().doubleValue());
							R0980cell13.setCellStyle(numberStyle);
						} else {
							R0980cell13.setCellValue("");
							R0980cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R0980cell14 = row.createCell(14);
						if (record1.getR0980_average_rate() != null) {
							R0980cell14.setCellValue(record1.getR0980_average_rate().doubleValue());
							R0980cell14.setCellStyle(numberStyle);
						} else {
							R0980cell14.setCellValue("");
							R0980cell14.setCellStyle(textStyle);
						}

						///// ROW111///////////
						// row111
						row = sheet.getRow(110);
						// Column M:
						Cell R1000cell12 = row.createCell(12);
						if (record1.getR1000_minimum_rate() != null) {
							R1000cell12.setCellValue(record1.getR1000_minimum_rate().doubleValue());
							R1000cell12.setCellStyle(numberStyle);
						} else {
							R1000cell12.setCellValue("");
							R1000cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1000cell13 = row.createCell(13);
						if (record1.getR1000_maximum_rate() != null) {
							R1000cell13.setCellValue(record1.getR1000_maximum_rate().doubleValue());
							R1000cell13.setCellStyle(numberStyle);
						} else {
							R1000cell13.setCellValue("");
							R1000cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1000cell14 = row.createCell(14);
						if (record1.getR1000_average_rate() != null) {
							R1000cell14.setCellValue(record1.getR1000_average_rate().doubleValue());
							R1000cell14.setCellStyle(numberStyle);
						} else {
							R1000cell14.setCellValue("");
							R1000cell14.setCellStyle(textStyle);
						}

						///// ROW112///////////
						// row112
						row = sheet.getRow(111);
						// Column M:
						Cell R1010cell12 = row.createCell(12);
						if (record1.getR1010_minimum_rate() != null) {
							R1010cell12.setCellValue(record1.getR1010_minimum_rate().doubleValue());
							R1010cell12.setCellStyle(numberStyle);
						} else {
							R1010cell12.setCellValue("");
							R1010cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1010cell13 = row.createCell(13);
						if (record1.getR1010_maximum_rate() != null) {
							R1010cell13.setCellValue(record1.getR1010_maximum_rate().doubleValue());
							R1010cell13.setCellStyle(numberStyle);
						} else {
							R1010cell13.setCellValue("");
							R1010cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1010cell14 = row.createCell(14);
						if (record1.getR1010_average_rate() != null) {
							R1010cell14.setCellValue(record1.getR1010_average_rate().doubleValue());
							R1010cell14.setCellStyle(numberStyle);
						} else {
							R1010cell14.setCellValue("");
							R1010cell14.setCellStyle(textStyle);
						}

						///// ROW113///////////
						// row113
						row = sheet.getRow(112);
						// Column M:
						Cell R1020cell12 = row.createCell(12);
						if (record1.getR1020_minimum_rate() != null) {
							R1020cell12.setCellValue(record1.getR1020_minimum_rate().doubleValue());
							R1020cell12.setCellStyle(numberStyle);
						} else {
							R1020cell12.setCellValue("");
							R1020cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1020cell13 = row.createCell(13);
						if (record1.getR1020_maximum_rate() != null) {
							R1020cell13.setCellValue(record1.getR1020_maximum_rate().doubleValue());
							R1020cell13.setCellStyle(numberStyle);
						} else {
							R1020cell13.setCellValue("");
							R1020cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1020cell14 = row.createCell(14);
						if (record1.getR1020_average_rate() != null) {
							R1020cell14.setCellValue(record1.getR1020_average_rate().doubleValue());
							R1020cell14.setCellStyle(numberStyle);
						} else {
							R1020cell14.setCellValue("");
							R1020cell14.setCellStyle(textStyle);
						}

						///// ROW114///////////
						// row114
						row = sheet.getRow(113);
						// Column M:
						Cell R1030cell12 = row.createCell(12);
						if (record1.getR1030_minimum_rate() != null) {
							R1030cell12.setCellValue(record1.getR1030_minimum_rate().doubleValue());
							R1030cell12.setCellStyle(numberStyle);
						} else {
							R1030cell12.setCellValue("");
							R1030cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1030cell13 = row.createCell(13);
						if (record1.getR1030_maximum_rate() != null) {
							R1030cell13.setCellValue(record1.getR1030_maximum_rate().doubleValue());
							R1030cell13.setCellStyle(numberStyle);
						} else {
							R1030cell13.setCellValue("");
							R1030cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1030cell14 = row.createCell(14);
						if (record1.getR1030_average_rate() != null) {
							R1030cell14.setCellValue(record1.getR1030_average_rate().doubleValue());
							R1030cell14.setCellStyle(numberStyle);
						} else {
							R1030cell14.setCellValue("");
							R1030cell14.setCellStyle(textStyle);
						}

						///// ROW115///////////
						// row115
						row = sheet.getRow(114);
						// Column M:
						Cell R1040cell12 = row.createCell(12);
						if (record1.getR1040_minimum_rate() != null) {
							R1040cell12.setCellValue(record1.getR1040_minimum_rate().doubleValue());
							R1040cell12.setCellStyle(numberStyle);
						} else {
							R1040cell12.setCellValue("");
							R1040cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1040cell13 = row.createCell(13);
						if (record1.getR1040_maximum_rate() != null) {
							R1040cell13.setCellValue(record1.getR1040_maximum_rate().doubleValue());
							R1040cell13.setCellStyle(numberStyle);
						} else {
							R1040cell13.setCellValue("");
							R1040cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1040cell14 = row.createCell(14);
						if (record1.getR1040_average_rate() != null) {
							R1040cell14.setCellValue(record1.getR1040_average_rate().doubleValue());
							R1040cell14.setCellStyle(numberStyle);
						} else {
							R1040cell14.setCellValue("");
							R1040cell14.setCellStyle(textStyle);
						}

						///// ROW118///////////
						// row118
						row = sheet.getRow(117);
						// Column M:
						Cell R1070cell12 = row.createCell(12);
						if (record1.getR1070_minimum_rate() != null) {
							R1070cell12.setCellValue(record1.getR1070_minimum_rate().doubleValue());
							R1070cell12.setCellStyle(numberStyle);
						} else {
							R1070cell12.setCellValue("");
							R1070cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1070cell13 = row.createCell(13);
						if (record1.getR1070_maximum_rate() != null) {
							R1070cell13.setCellValue(record1.getR1070_maximum_rate().doubleValue());
							R1070cell13.setCellStyle(numberStyle);
						} else {
							R1070cell13.setCellValue("");
							R1070cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1070cell14 = row.createCell(14);
						if (record1.getR1070_average_rate() != null) {
							R1070cell14.setCellValue(record1.getR1070_average_rate().doubleValue());
							R1070cell14.setCellStyle(numberStyle);
						} else {
							R1070cell14.setCellValue("");
							R1070cell14.setCellStyle(textStyle);
						}

						///// ROW119///////////
						// row119
						row = sheet.getRow(118);
						// Column M:
						Cell R1080cell12 = row.createCell(12);
						if (record1.getR1080_minimum_rate() != null) {
							R1080cell12.setCellValue(record1.getR1080_minimum_rate().doubleValue());
							R1080cell12.setCellStyle(numberStyle);
						} else {
							R1080cell12.setCellValue("");
							R1080cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1080cell13 = row.createCell(13);
						if (record1.getR1080_maximum_rate() != null) {
							R1080cell13.setCellValue(record1.getR1080_maximum_rate().doubleValue());
							R1080cell13.setCellStyle(numberStyle);
						} else {
							R1080cell13.setCellValue("");
							R1080cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1080cell14 = row.createCell(14);
						if (record1.getR1080_average_rate() != null) {
							R1080cell14.setCellValue(record1.getR1080_average_rate().doubleValue());
							R1080cell14.setCellStyle(numberStyle);
						} else {
							R1080cell14.setCellValue("");
							R1080cell14.setCellStyle(textStyle);
						}

						///// ROW120///////////
						// row120
						row = sheet.getRow(119);
						// Column M:
						Cell R1090cell12 = row.createCell(12);
						if (record1.getR1090_minimum_rate() != null) {
							R1090cell12.setCellValue(record1.getR1090_minimum_rate().doubleValue());
							R1090cell12.setCellStyle(numberStyle);
						} else {
							R1090cell12.setCellValue("");
							R1090cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1090cell13 = row.createCell(13);
						if (record1.getR1090_maximum_rate() != null) {
							R1090cell13.setCellValue(record1.getR1090_maximum_rate().doubleValue());
							R1090cell13.setCellStyle(numberStyle);
						} else {
							R1090cell13.setCellValue("");
							R1090cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1090cell14 = row.createCell(14);
						if (record1.getR1090_average_rate() != null) {
							R1090cell14.setCellValue(record1.getR1090_average_rate().doubleValue());
							R1090cell14.setCellStyle(numberStyle);
						} else {
							R1090cell14.setCellValue("");
							R1090cell14.setCellStyle(textStyle);
						}

						///// ROW121///////////
						// row121
						row = sheet.getRow(120);
						// Column M:
						Cell R1100cell12 = row.createCell(12);
						if (record1.getR1100_minimum_rate() != null) {
							R1100cell12.setCellValue(record1.getR1100_minimum_rate().doubleValue());
							R1100cell12.setCellStyle(numberStyle);
						} else {
							R1100cell12.setCellValue("");
							R1100cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1100cell13 = row.createCell(13);
						if (record1.getR1100_maximum_rate() != null) {
							R1100cell13.setCellValue(record1.getR1100_maximum_rate().doubleValue());
							R1100cell13.setCellStyle(numberStyle);
						} else {
							R1100cell13.setCellValue("");
							R1100cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1100cell14 = row.createCell(14);
						if (record1.getR1100_average_rate() != null) {
							R1100cell14.setCellValue(record1.getR1100_average_rate().doubleValue());
							R1100cell14.setCellStyle(numberStyle);
						} else {
							R1100cell14.setCellValue("");
							R1100cell14.setCellStyle(textStyle);
						}

						///// ROW122///////////
						// row122
						row = sheet.getRow(121);
						// Column M:
						Cell R1110cell12 = row.createCell(12);
						if (record1.getR1110_minimum_rate() != null) {
							R1110cell12.setCellValue(record1.getR1110_minimum_rate().doubleValue());
							R1110cell12.setCellStyle(numberStyle);
						} else {
							R1110cell12.setCellValue("");
							R1110cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1110cell13 = row.createCell(13);
						if (record1.getR1110_maximum_rate() != null) {
							R1110cell13.setCellValue(record1.getR1110_maximum_rate().doubleValue());
							R1110cell13.setCellStyle(numberStyle);
						} else {
							R1110cell13.setCellValue("");
							R1110cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1110cell14 = row.createCell(14);
						if (record1.getR1110_average_rate() != null) {
							R1110cell14.setCellValue(record1.getR1110_average_rate().doubleValue());
							R1110cell14.setCellStyle(numberStyle);
						} else {
							R1110cell14.setCellValue("");
							R1110cell14.setCellStyle(textStyle);
						}

						///// ROW124///////////
						// row124
						row = sheet.getRow(123);
						// Column M:
						Cell R1130cell12 = row.createCell(12);
						if (record1.getR1130_minimum_rate() != null) {
							R1130cell12.setCellValue(record1.getR1130_minimum_rate().doubleValue());
							R1130cell12.setCellStyle(numberStyle);
						} else {
							R1130cell12.setCellValue("");
							R1130cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1130cell13 = row.createCell(13);
						if (record1.getR1130_maximum_rate() != null) {
							R1130cell13.setCellValue(record1.getR1130_maximum_rate().doubleValue());
							R1130cell13.setCellStyle(numberStyle);
						} else {
							R1130cell13.setCellValue("");
							R1130cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1130cell14 = row.createCell(14);
						if (record1.getR1130_average_rate() != null) {
							R1130cell14.setCellValue(record1.getR1130_average_rate().doubleValue());
							R1130cell14.setCellStyle(numberStyle);
						} else {
							R1130cell14.setCellValue("");
							R1130cell14.setCellStyle(textStyle);
						}

						///// ROW125///////////
						// row125
						row = sheet.getRow(124);
						// Column M:
						Cell R1140cell12 = row.createCell(12);
						if (record1.getR1140_minimum_rate() != null) {
							R1140cell12.setCellValue(record1.getR1140_minimum_rate().doubleValue());
							R1140cell12.setCellStyle(numberStyle);
						} else {
							R1140cell12.setCellValue("");
							R1140cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1140cell13 = row.createCell(13);
						if (record1.getR1140_maximum_rate() != null) {
							R1140cell13.setCellValue(record1.getR1140_maximum_rate().doubleValue());
							R1140cell13.setCellStyle(numberStyle);
						} else {
							R1140cell13.setCellValue("");
							R1140cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1140cell14 = row.createCell(14);
						if (record1.getR1140_average_rate() != null) {
							R1140cell14.setCellValue(record1.getR1140_average_rate().doubleValue());
							R1140cell14.setCellStyle(numberStyle);
						} else {
							R1140cell14.setCellValue("");
							R1140cell14.setCellStyle(textStyle);
						}

						///// ROW126///////////
						// row126
						row = sheet.getRow(125);
						// Column M:
						Cell R1150cell12 = row.createCell(12);
						if (record1.getR1150_minimum_rate() != null) {
							R1150cell12.setCellValue(record1.getR1150_minimum_rate().doubleValue());
							R1150cell12.setCellStyle(numberStyle);
						} else {
							R1150cell12.setCellValue("");
							R1150cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1150cell13 = row.createCell(13);
						if (record1.getR1150_maximum_rate() != null) {
							R1150cell13.setCellValue(record1.getR1150_maximum_rate().doubleValue());
							R1150cell13.setCellStyle(numberStyle);
						} else {
							R1150cell13.setCellValue("");
							R1150cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1150cell14 = row.createCell(14);
						if (record1.getR1150_average_rate() != null) {
							R1150cell14.setCellValue(record1.getR1150_average_rate().doubleValue());
							R1150cell14.setCellStyle(numberStyle);
						} else {
							R1150cell14.setCellValue("");
							R1150cell14.setCellStyle(textStyle);
						}

						///// ROW127///////////
						// row127
						row = sheet.getRow(126);
						// Column M:
						Cell R1160cell12 = row.createCell(12);
						if (record1.getR1160_minimum_rate() != null) {
							R1160cell12.setCellValue(record1.getR1160_minimum_rate().doubleValue());
							R1160cell12.setCellStyle(numberStyle);
						} else {
							R1160cell12.setCellValue("");
							R1160cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1160cell13 = row.createCell(13);
						if (record1.getR1160_maximum_rate() != null) {
							R1160cell13.setCellValue(record1.getR1160_maximum_rate().doubleValue());
							R1160cell13.setCellStyle(numberStyle);
						} else {
							R1160cell13.setCellValue("");
							R1160cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1160cell14 = row.createCell(14);
						if (record1.getR1160_average_rate() != null) {
							R1160cell14.setCellValue(record1.getR1160_average_rate().doubleValue());
							R1160cell14.setCellStyle(numberStyle);
						} else {
							R1160cell14.setCellValue("");
							R1160cell14.setCellStyle(textStyle);
						}

						///// ROW128///////////
						// row128
						row = sheet.getRow(127);
						// Column M:
						Cell R1170cell12 = row.createCell(12);
						if (record1.getR1170_minimum_rate() != null) {
							R1170cell12.setCellValue(record1.getR1170_minimum_rate().doubleValue());
							R1170cell12.setCellStyle(numberStyle);
						} else {
							R1170cell12.setCellValue("");
							R1170cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1170cell13 = row.createCell(13);
						if (record1.getR1170_maximum_rate() != null) {
							R1170cell13.setCellValue(record1.getR1170_maximum_rate().doubleValue());
							R1170cell13.setCellStyle(numberStyle);
						} else {
							R1170cell13.setCellValue("");
							R1170cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1170cell14 = row.createCell(14);
						if (record1.getR1170_average_rate() != null) {
							R1170cell14.setCellValue(record1.getR1170_average_rate().doubleValue());
							R1170cell14.setCellStyle(numberStyle);
						} else {
							R1170cell14.setCellValue("");
							R1170cell14.setCellStyle(textStyle);
						}

						///// ROW130///////////
						// row130
						row = sheet.getRow(129);
						// Column M:
						Cell R1190cell12 = row.createCell(12);
						if (record1.getR1190_minimum_rate() != null) {
							R1190cell12.setCellValue(record1.getR1190_minimum_rate().doubleValue());
							R1190cell12.setCellStyle(numberStyle);
						} else {
							R1190cell12.setCellValue("");
							R1190cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1190cell13 = row.createCell(13);
						if (record1.getR1190_maximum_rate() != null) {
							R1190cell13.setCellValue(record1.getR1190_maximum_rate().doubleValue());
							R1190cell13.setCellStyle(numberStyle);
						} else {
							R1190cell13.setCellValue("");
							R1190cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1190cell14 = row.createCell(14);
						if (record1.getR1190_average_rate() != null) {
							R1190cell14.setCellValue(record1.getR1190_average_rate().doubleValue());
							R1190cell14.setCellStyle(numberStyle);
						} else {
							R1190cell14.setCellValue("");
							R1190cell14.setCellStyle(textStyle);
						}

						///// ROW131///////////
						// row131
						row = sheet.getRow(130);
						// Column M:
						Cell R1200cell12 = row.createCell(12);
						if (record1.getR1200_minimum_rate() != null) {
							R1200cell12.setCellValue(record1.getR1200_minimum_rate().doubleValue());
							R1200cell12.setCellStyle(numberStyle);
						} else {
							R1200cell12.setCellValue("");
							R1200cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1200cell13 = row.createCell(13);
						if (record1.getR1200_maximum_rate() != null) {
							R1200cell13.setCellValue(record1.getR1200_maximum_rate().doubleValue());
							R1200cell13.setCellStyle(numberStyle);
						} else {
							R1200cell13.setCellValue("");
							R1200cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1200cell14 = row.createCell(14);
						if (record1.getR1200_average_rate() != null) {
							R1200cell14.setCellValue(record1.getR1200_average_rate().doubleValue());
							R1200cell14.setCellStyle(numberStyle);
						} else {
							R1200cell14.setCellValue("");
							R1200cell14.setCellStyle(textStyle);
						}

						///// ROW132///////////
						// row132
						row = sheet.getRow(131);
						// Column M:
						Cell R1210cell12 = row.createCell(12);
						if (record1.getR1210_minimum_rate() != null) {
							R1210cell12.setCellValue(record1.getR1210_minimum_rate().doubleValue());
							R1210cell12.setCellStyle(numberStyle);
						} else {
							R1210cell12.setCellValue("");
							R1210cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1210cell13 = row.createCell(13);
						if (record1.getR1210_maximum_rate() != null) {
							R1210cell13.setCellValue(record1.getR1210_maximum_rate().doubleValue());
							R1210cell13.setCellStyle(numberStyle);
						} else {
							R1210cell13.setCellValue("");
							R1210cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1210cell14 = row.createCell(14);
						if (record1.getR1210_average_rate() != null) {
							R1210cell14.setCellValue(record1.getR1210_average_rate().doubleValue());
							R1210cell14.setCellStyle(numberStyle);
						} else {
							R1210cell14.setCellValue("");
							R1210cell14.setCellStyle(textStyle);
						}

						///// ROW133///////////
						// row133
						row = sheet.getRow(132);
						// Column M:
						Cell R1220cell12 = row.createCell(12);
						if (record1.getR1220_minimum_rate() != null) {
							R1220cell12.setCellValue(record1.getR1220_minimum_rate().doubleValue());
							R1220cell12.setCellStyle(numberStyle);
						} else {
							R1220cell12.setCellValue("");
							R1220cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1220cell13 = row.createCell(13);
						if (record1.getR1220_maximum_rate() != null) {
							R1220cell13.setCellValue(record1.getR1220_maximum_rate().doubleValue());
							R1220cell13.setCellStyle(numberStyle);
						} else {
							R1220cell13.setCellValue("");
							R1220cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1220cell14 = row.createCell(14);
						if (record1.getR1220_average_rate() != null) {
							R1220cell14.setCellValue(record1.getR1220_average_rate().doubleValue());
							R1220cell14.setCellStyle(numberStyle);
						} else {
							R1220cell14.setCellValue("");
							R1220cell14.setCellStyle(textStyle);
						}

						///// ROW134///////////
						// row134
						row = sheet.getRow(133);
						// Column M:
						Cell R1230cell12 = row.createCell(12);
						if (record1.getR1230_minimum_rate() != null) {
							R1230cell12.setCellValue(record1.getR1230_minimum_rate().doubleValue());
							R1230cell12.setCellStyle(numberStyle);
						} else {
							R1230cell12.setCellValue("");
							R1230cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1230cell13 = row.createCell(13);
						if (record1.getR1230_maximum_rate() != null) {
							R1230cell13.setCellValue(record1.getR1230_maximum_rate().doubleValue());
							R1230cell13.setCellStyle(numberStyle);
						} else {
							R1230cell13.setCellValue("");
							R1230cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1230cell14 = row.createCell(14);
						if (record1.getR1230_average_rate() != null) {
							R1230cell14.setCellValue(record1.getR1230_average_rate().doubleValue());
							R1230cell14.setCellStyle(numberStyle);
						} else {
							R1230cell14.setCellValue("");
							R1230cell14.setCellStyle(textStyle);
						}

						///// ROW136///////////
						// row136
						row = sheet.getRow(135);
						// Column M:
						Cell R1250cell12 = row.createCell(12);
						if (record1.getR1250_minimum_rate() != null) {
							R1250cell12.setCellValue(record1.getR1250_minimum_rate().doubleValue());
							R1250cell12.setCellStyle(numberStyle);
						} else {
							R1250cell12.setCellValue("");
							R1250cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1250cell13 = row.createCell(13);
						if (record1.getR1250_maximum_rate() != null) {
							R1250cell13.setCellValue(record1.getR1250_maximum_rate().doubleValue());
							R1250cell13.setCellStyle(numberStyle);
						} else {
							R1250cell13.setCellValue("");
							R1250cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1250cell14 = row.createCell(14);
						if (record1.getR1250_average_rate() != null) {
							R1250cell14.setCellValue(record1.getR1250_average_rate().doubleValue());
							R1250cell14.setCellStyle(numberStyle);
						} else {
							R1250cell14.setCellValue("");
							R1250cell14.setCellStyle(textStyle);
						}

						///// ROW137///////////
						// row137
						row = sheet.getRow(136);
						// Column M:
						Cell R1260cell12 = row.createCell(12);
						if (record1.getR1260_minimum_rate() != null) {
							R1260cell12.setCellValue(record1.getR1260_minimum_rate().doubleValue());
							R1260cell12.setCellStyle(numberStyle);
						} else {
							R1260cell12.setCellValue("");
							R1260cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1260cell13 = row.createCell(13);
						if (record1.getR1260_maximum_rate() != null) {
							R1260cell13.setCellValue(record1.getR1260_maximum_rate().doubleValue());
							R1260cell13.setCellStyle(numberStyle);
						} else {
							R1260cell13.setCellValue("");
							R1260cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1260cell14 = row.createCell(14);
						if (record1.getR1260_average_rate() != null) {
							R1260cell14.setCellValue(record1.getR1260_average_rate().doubleValue());
							R1260cell14.setCellStyle(numberStyle);
						} else {
							R1260cell14.setCellValue("");
							R1260cell14.setCellStyle(textStyle);
						}

						///// ROW138///////////
						// row138
						row = sheet.getRow(137);
						// Column M:
						Cell R1270cell12 = row.createCell(12);
						if (record1.getR1270_minimum_rate() != null) {
							R1270cell12.setCellValue(record1.getR1270_minimum_rate().doubleValue());
							R1270cell12.setCellStyle(numberStyle);
						} else {
							R1270cell12.setCellValue("");
							R1270cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1270cell13 = row.createCell(13);
						if (record1.getR1270_maximum_rate() != null) {
							R1270cell13.setCellValue(record1.getR1270_maximum_rate().doubleValue());
							R1270cell13.setCellStyle(numberStyle);
						} else {
							R1270cell13.setCellValue("");
							R1270cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1270cell14 = row.createCell(14);
						if (record1.getR1270_average_rate() != null) {
							R1270cell14.setCellValue(record1.getR1270_average_rate().doubleValue());
							R1270cell14.setCellStyle(numberStyle);
						} else {
							R1270cell14.setCellValue("");
							R1270cell14.setCellStyle(textStyle);
						}

						///// ROW139///////////
						// row139
						row = sheet.getRow(138);
						// Column M:
						Cell R1280cell12 = row.createCell(12);
						if (record1.getR1280_minimum_rate() != null) {
							R1280cell12.setCellValue(record1.getR1280_minimum_rate().doubleValue());
							R1280cell12.setCellStyle(numberStyle);
						} else {
							R1280cell12.setCellValue("");
							R1280cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1280cell13 = row.createCell(13);
						if (record1.getR1280_maximum_rate() != null) {
							R1280cell13.setCellValue(record1.getR1280_maximum_rate().doubleValue());
							R1280cell13.setCellStyle(numberStyle);
						} else {
							R1280cell13.setCellValue("");
							R1280cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1280cell14 = row.createCell(14);
						if (record1.getR1280_average_rate() != null) {
							R1280cell14.setCellValue(record1.getR1280_average_rate().doubleValue());
							R1280cell14.setCellStyle(numberStyle);
						} else {
							R1280cell14.setCellValue("");
							R1280cell14.setCellStyle(textStyle);
						}

						///// ROW140///////////
						// row140
						row = sheet.getRow(139);
						// Column M:
						Cell R1290cell12 = row.createCell(12);
						if (record1.getR1290_minimum_rate() != null) {
							R1290cell12.setCellValue(record1.getR1290_minimum_rate().doubleValue());
							R1290cell12.setCellStyle(numberStyle);
						} else {
							R1290cell12.setCellValue("");
							R1290cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1290cell13 = row.createCell(13);
						if (record1.getR1290_maximum_rate() != null) {
							R1290cell13.setCellValue(record1.getR1290_maximum_rate().doubleValue());
							R1290cell13.setCellStyle(numberStyle);
						} else {
							R1290cell13.setCellValue("");
							R1290cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1290cell14 = row.createCell(14);
						if (record1.getR1290_average_rate() != null) {
							R1290cell14.setCellValue(record1.getR1290_average_rate().doubleValue());
							R1290cell14.setCellStyle(numberStyle);
						} else {
							R1290cell14.setCellValue("");
							R1290cell14.setCellStyle(textStyle);
						}

						///// ROW142///////////
						// row142
						row = sheet.getRow(141);
						// Column M:
						Cell R1310cell12 = row.createCell(12);
						if (record1.getR1310_minimum_rate() != null) {
							R1310cell12.setCellValue(record1.getR1310_minimum_rate().doubleValue());
							R1310cell12.setCellStyle(numberStyle);
						} else {
							R1310cell12.setCellValue("");
							R1310cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1310cell13 = row.createCell(13);
						if (record1.getR1310_maximum_rate() != null) {
							R1310cell13.setCellValue(record1.getR1310_maximum_rate().doubleValue());
							R1310cell13.setCellStyle(numberStyle);
						} else {
							R1310cell13.setCellValue("");
							R1310cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1310cell14 = row.createCell(14);
						if (record1.getR1310_average_rate() != null) {
							R1310cell14.setCellValue(record1.getR1310_average_rate().doubleValue());
							R1310cell14.setCellStyle(numberStyle);
						} else {
							R1310cell14.setCellValue("");
							R1310cell14.setCellStyle(textStyle);
						}

						///// ROW143///////////
						// row143
						row = sheet.getRow(142);
						// Column M:
						Cell R1320cell12 = row.createCell(12);
						if (record1.getR1320_minimum_rate() != null) {
							R1320cell12.setCellValue(record1.getR1320_minimum_rate().doubleValue());
							R1320cell12.setCellStyle(numberStyle);
						} else {
							R1320cell12.setCellValue("");
							R1320cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1320cell13 = row.createCell(13);
						if (record1.getR1320_maximum_rate() != null) {
							R1320cell13.setCellValue(record1.getR1320_maximum_rate().doubleValue());
							R1320cell13.setCellStyle(numberStyle);
						} else {
							R1320cell13.setCellValue("");
							R1320cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1320cell14 = row.createCell(14);
						if (record1.getR1320_average_rate() != null) {
							R1320cell14.setCellValue(record1.getR1320_average_rate().doubleValue());
							R1320cell14.setCellStyle(numberStyle);
						} else {
							R1320cell14.setCellValue("");
							R1320cell14.setCellStyle(textStyle);
						}

						///// ROW144///////////
						// row144
						row = sheet.getRow(143);
						// Column M:
						Cell R1330cell12 = row.createCell(12);
						if (record1.getR1330_minimum_rate() != null) {
							R1330cell12.setCellValue(record1.getR1330_minimum_rate().doubleValue());
							R1330cell12.setCellStyle(numberStyle);
						} else {
							R1330cell12.setCellValue("");
							R1330cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1330cell13 = row.createCell(13);
						if (record1.getR1330_maximum_rate() != null) {
							R1330cell13.setCellValue(record1.getR1330_maximum_rate().doubleValue());
							R1330cell13.setCellStyle(numberStyle);
						} else {
							R1330cell13.setCellValue("");
							R1330cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1330cell14 = row.createCell(14);
						if (record1.getR1330_average_rate() != null) {
							R1330cell14.setCellValue(record1.getR1330_average_rate().doubleValue());
							R1330cell14.setCellStyle(numberStyle);
						} else {
							R1330cell14.setCellValue("");
							R1330cell14.setCellStyle(textStyle);
						}

						///// ROW145///////////
						// row145
						row = sheet.getRow(144);
						// Column M:
						Cell R1340cell12 = row.createCell(12);
						if (record1.getR1340_minimum_rate() != null) {
							R1340cell12.setCellValue(record1.getR1340_minimum_rate().doubleValue());
							R1340cell12.setCellStyle(numberStyle);
						} else {
							R1340cell12.setCellValue("");
							R1340cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1340cell13 = row.createCell(13);
						if (record1.getR1340_maximum_rate() != null) {
							R1340cell13.setCellValue(record1.getR1340_maximum_rate().doubleValue());
							R1340cell13.setCellStyle(numberStyle);
						} else {
							R1340cell13.setCellValue("");
							R1340cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1340cell14 = row.createCell(14);
						if (record1.getR1340_average_rate() != null) {
							R1340cell14.setCellValue(record1.getR1340_average_rate().doubleValue());
							R1340cell14.setCellStyle(numberStyle);
						} else {
							R1340cell14.setCellValue("");
							R1340cell14.setCellStyle(textStyle);
						}

						///// ROW146///////////
						// row146
						row = sheet.getRow(145);
						// Column M:
						Cell R1350cell12 = row.createCell(12);
						if (record1.getR1350_minimum_rate() != null) {
							R1350cell12.setCellValue(record1.getR1350_minimum_rate().doubleValue());
							R1350cell12.setCellStyle(numberStyle);
						} else {
							R1350cell12.setCellValue("");
							R1350cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1350cell13 = row.createCell(13);
						if (record1.getR1350_maximum_rate() != null) {
							R1350cell13.setCellValue(record1.getR1350_maximum_rate().doubleValue());
							R1350cell13.setCellStyle(numberStyle);
						} else {
							R1350cell13.setCellValue("");
							R1350cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1350cell14 = row.createCell(14);
						if (record1.getR1350_average_rate() != null) {
							R1350cell14.setCellValue(record1.getR1350_average_rate().doubleValue());
							R1350cell14.setCellStyle(numberStyle);
						} else {
							R1350cell14.setCellValue("");
							R1350cell14.setCellStyle(textStyle);
						}

						///// ROW148///////////
						// row148
						row = sheet.getRow(147);
						// Column M:
						Cell R1370cell12 = row.createCell(12);
						if (record1.getR1470_minimum_rate() != null) {
							R1370cell12.setCellValue(record1.getR1470_minimum_rate().doubleValue());
							R1370cell12.setCellStyle(numberStyle);
						} else {
							R1370cell12.setCellValue("");
							R1370cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1370cell13 = row.createCell(13);
						if (record1.getR1470_maximum_rate() != null) {
							R1370cell13.setCellValue(record1.getR1470_maximum_rate().doubleValue());
							R1370cell13.setCellStyle(numberStyle);
						} else {
							R1370cell13.setCellValue("");
							R1370cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1370cell14 = row.createCell(14);
						if (record1.getR1470_average_rate() != null) {
							R1370cell14.setCellValue(record1.getR1470_average_rate().doubleValue());
							R1370cell14.setCellStyle(numberStyle);
						} else {
							R1370cell14.setCellValue("");
							R1370cell14.setCellStyle(textStyle);
						}

						///// ROW149///////////
						// row149
						row = sheet.getRow(148);
						// Column M:
						Cell R1380cell12 = row.createCell(12);
						if (record1.getR1480_minimum_rate() != null) {
							R1380cell12.setCellValue(record1.getR1480_minimum_rate().doubleValue());
							R1380cell12.setCellStyle(numberStyle);
						} else {
							R1380cell12.setCellValue("");
							R1380cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1380cell13 = row.createCell(13);
						if (record1.getR1480_maximum_rate() != null) {
							R1380cell13.setCellValue(record1.getR1480_maximum_rate().doubleValue());
							R1380cell13.setCellStyle(numberStyle);
						} else {
							R1380cell13.setCellValue("");
							R1380cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1380cell14 = row.createCell(14);
						if (record1.getR1480_average_rate() != null) {
							R1380cell14.setCellValue(record1.getR1480_average_rate().doubleValue());
							R1380cell14.setCellStyle(numberStyle);
						} else {
							R1380cell14.setCellValue("");
							R1380cell14.setCellStyle(textStyle);
						}

						///// ROW150///////////
						// row150
						row = sheet.getRow(149);
						// Column M:
						Cell R1390cell12 = row.createCell(12);
						if (record1.getR1490_minimum_rate() != null) {
							R1390cell12.setCellValue(record1.getR1490_minimum_rate().doubleValue());
							R1390cell12.setCellStyle(numberStyle);
						} else {
							R1390cell12.setCellValue("");
							R1390cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1390cell13 = row.createCell(13);
						if (record1.getR1490_maximum_rate() != null) {
							R1390cell13.setCellValue(record1.getR1490_maximum_rate().doubleValue());
							R1390cell13.setCellStyle(numberStyle);
						} else {
							R1390cell13.setCellValue("");
							R1390cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1390cell14 = row.createCell(14);
						if (record1.getR1490_average_rate() != null) {
							R1390cell14.setCellValue(record1.getR1490_average_rate().doubleValue());
							R1390cell14.setCellStyle(numberStyle);
						} else {
							R1390cell14.setCellValue("");
							R1390cell14.setCellStyle(textStyle);
						}

						///// ROW151///////////
						// row151
						row = sheet.getRow(150);
						// Column M:
						Cell R1400cell12 = row.createCell(12);
						if (record1.getR1400_minimum_rate() != null) {
							R1400cell12.setCellValue(record1.getR1400_minimum_rate().doubleValue());
							R1400cell12.setCellStyle(numberStyle);
						} else {
							R1400cell12.setCellValue("");
							R1400cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1400cell13 = row.createCell(13);
						if (record1.getR1400_maximum_rate() != null) {
							R1400cell13.setCellValue(record1.getR1400_maximum_rate().doubleValue());
							R1400cell13.setCellStyle(numberStyle);
						} else {
							R1400cell13.setCellValue("");
							R1400cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1400cell14 = row.createCell(14);
						if (record1.getR1400_average_rate() != null) {
							R1400cell14.setCellValue(record1.getR1400_average_rate().doubleValue());
							R1400cell14.setCellStyle(numberStyle);
						} else {
							R1400cell14.setCellValue("");
							R1400cell14.setCellStyle(textStyle);
						}

					///// ROW152///////////
						// row152
						row = sheet.getRow(151);
						// Column M:
						Cell R1410cell12 = row.createCell(12);
						if (record1.getR1410_minimum_rate() != null) {
							R1410cell12.setCellValue(record1.getR1410_minimum_rate().doubleValue());
							R1410cell12.setCellStyle(numberStyle);
						} else {
							R1410cell12.setCellValue("");
							R1410cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1410cell13 = row.createCell(13);
						if (record1.getR1410_maximum_rate() != null) {
							R1410cell13.setCellValue(record1.getR1410_maximum_rate().doubleValue());
							R1410cell13.setCellStyle(numberStyle);
						} else {
							R1410cell13.setCellValue("");
							R1410cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1410cell14 = row.createCell(14);
						if (record1.getR1410_average_rate() != null) {
							R1410cell14.setCellValue(record1.getR1410_average_rate().doubleValue());
							R1410cell14.setCellStyle(numberStyle);
						} else {
							R1410cell14.setCellValue("");
							R1410cell14.setCellStyle(textStyle);
						}

						
						///// ROW154///////////
						// row154
						row = sheet.getRow(153);
						// Column M:
						Cell R1430cell12 = row.createCell(12);
						if (record1.getR1430_minimum_rate() != null) {
							R1430cell12.setCellValue(record1.getR1430_minimum_rate().doubleValue());
							R1430cell12.setCellStyle(numberStyle);
						} else {
							R1430cell12.setCellValue("");
							R1430cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1430cell13 = row.createCell(13);
						if (record1.getR1430_maximum_rate() != null) {
							R1430cell13.setCellValue(record1.getR1430_maximum_rate().doubleValue());
							R1430cell13.setCellStyle(numberStyle);
						} else {
							R1430cell13.setCellValue("");
							R1430cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1430cell14 = row.createCell(14);
						if (record1.getR1430_average_rate() != null) {
							R1430cell14.setCellValue(record1.getR1430_average_rate().doubleValue());
							R1430cell14.setCellStyle(numberStyle);
						} else {
							R1430cell14.setCellValue("");
							R1430cell14.setCellStyle(textStyle);
						}

						///// ROW155///////////
						// row155
						row = sheet.getRow(154);
						// Column M:
						Cell R1440cell12 = row.createCell(12);
						if (record1.getR1440_minimum_rate() != null) {
							R1440cell12.setCellValue(record1.getR1440_minimum_rate().doubleValue());
							R1440cell12.setCellStyle(numberStyle);
						} else {
							R1440cell12.setCellValue("");
							R1440cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1440cell13 = row.createCell(13);
						if (record1.getR1440_maximum_rate() != null) {
							R1440cell13.setCellValue(record1.getR1440_maximum_rate().doubleValue());
							R1440cell13.setCellStyle(numberStyle);
						} else {
							R1440cell13.setCellValue("");
							R1440cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1440cell14 = row.createCell(14);
						if (record1.getR1440_average_rate() != null) {
							R1440cell14.setCellValue(record1.getR1440_average_rate().doubleValue());
							R1440cell14.setCellStyle(numberStyle);
						} else {
							R1440cell14.setCellValue("");
							R1440cell14.setCellStyle(textStyle);
						}

						///// ROW156///////////
						// row156
						row = sheet.getRow(155);
						// Column M:
						Cell R1450cell12 = row.createCell(12);
						if (record1.getR1450_minimum_rate() != null) {
							R1450cell12.setCellValue(record1.getR1450_minimum_rate().doubleValue());
							R1450cell12.setCellStyle(numberStyle);
						} else {
							R1450cell12.setCellValue("");
							R1450cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1450cell13 = row.createCell(13);
						if (record1.getR1450_maximum_rate() != null) {
							R1450cell13.setCellValue(record1.getR1450_maximum_rate().doubleValue());
							R1450cell13.setCellStyle(numberStyle);
						} else {
							R1450cell13.setCellValue("");
							R1450cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1450cell14 = row.createCell(14);
						if (record1.getR1450_average_rate() != null) {
							R1450cell14.setCellValue(record1.getR1450_average_rate().doubleValue());
							R1450cell14.setCellStyle(numberStyle);
						} else {
							R1450cell14.setCellValue("");
							R1450cell14.setCellStyle(textStyle);
						}

						///// ROW157///////////
						// row157
						row = sheet.getRow(156);
						// Column M:
						Cell R1460cell12 = row.createCell(12);
						if (record1.getR1460_minimum_rate() != null) {
							R1460cell12.setCellValue(record1.getR1460_minimum_rate().doubleValue());
							R1460cell12.setCellStyle(numberStyle);
						} else {
							R1460cell12.setCellValue("");
							R1460cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1460cell13 = row.createCell(13);
						if (record1.getR1460_maximum_rate() != null) {
							R1460cell13.setCellValue(record1.getR1460_maximum_rate().doubleValue());
							R1460cell13.setCellStyle(numberStyle);
						} else {
							R1460cell13.setCellValue("");
							R1460cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1460cell14 = row.createCell(14);
						if (record1.getR1460_average_rate() != null) {
							R1460cell14.setCellValue(record1.getR1460_average_rate().doubleValue());
							R1460cell14.setCellStyle(numberStyle);
						} else {
							R1460cell14.setCellValue("");
							R1460cell14.setCellStyle(textStyle);
						}

						///// ROW158///////////
						// row158
						row = sheet.getRow(157);
						// Column M:
						Cell R1470cell12 = row.createCell(12);
						if (record1.getR1470_minimum_rate() != null) {
							R1470cell12.setCellValue(record1.getR1470_minimum_rate().doubleValue());
							R1470cell12.setCellStyle(numberStyle);
						} else {
							R1470cell12.setCellValue("");
							R1470cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1470cell13 = row.createCell(13);
						if (record1.getR1470_maximum_rate() != null) {
							R1470cell13.setCellValue(record1.getR1470_maximum_rate().doubleValue());
							R1470cell13.setCellStyle(numberStyle);
						} else {
							R1470cell13.setCellValue("");
							R1470cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1470cell14 = row.createCell(14);
						if (record1.getR1470_average_rate() != null) {
							R1470cell14.setCellValue(record1.getR1470_average_rate().doubleValue());
							R1470cell14.setCellStyle(numberStyle);
						} else {
							R1470cell14.setCellValue("");
							R1470cell14.setCellStyle(textStyle);
						}

						///// ROW160///////////
						// row160
						row = sheet.getRow(159);
						// Column M:
						Cell R1490cell12 = row.createCell(12);
						if (record1.getR1490_minimum_rate() != null) {
							R1490cell12.setCellValue(record1.getR1490_minimum_rate().doubleValue());
							R1490cell12.setCellStyle(numberStyle);
						} else {
							R1490cell12.setCellValue("");
							R1490cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1490cell13 = row.createCell(13);
						if (record1.getR1490_maximum_rate() != null) {
							R1490cell13.setCellValue(record1.getR1490_maximum_rate().doubleValue());
							R1490cell13.setCellStyle(numberStyle);
						} else {
							R1490cell13.setCellValue("");
							R1490cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1490cell14 = row.createCell(14);
						if (record1.getR1490_average_rate() != null) {
							R1490cell14.setCellValue(record1.getR1490_average_rate().doubleValue());
							R1490cell14.setCellStyle(numberStyle);
						} else {
							R1490cell14.setCellValue("");
							R1490cell14.setCellStyle(textStyle);
						}

						///// ROW161///////////
						// row161
						row = sheet.getRow(160);
						// Column M:
						Cell R1500cell12 = row.createCell(12);
						if (record1.getR1500_minimum_rate() != null) {
							R1500cell12.setCellValue(record1.getR1500_minimum_rate().doubleValue());
							R1500cell12.setCellStyle(numberStyle);
						} else {
							R1500cell12.setCellValue("");
							R1500cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1500cell13 = row.createCell(13);
						if (record1.getR1500_maximum_rate() != null) {
							R1500cell13.setCellValue(record1.getR1500_maximum_rate().doubleValue());
							R1500cell13.setCellStyle(numberStyle);
						} else {
							R1500cell13.setCellValue("");
							R1500cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1500cell14 = row.createCell(14);
						if (record1.getR1500_average_rate() != null) {
							R1500cell14.setCellValue(record1.getR1500_average_rate().doubleValue());
							R1500cell14.setCellStyle(numberStyle);
						} else {
							R1500cell14.setCellValue("");
							R1500cell14.setCellStyle(textStyle);
						}

						///// ROW162///////////
						// row162
						row = sheet.getRow(161);
						// Column M:
						Cell R1510cell12 = row.createCell(12);
						if (record1.getR1510_minimum_rate() != null) {
							R1510cell12.setCellValue(record1.getR1510_minimum_rate().doubleValue());
							R1510cell12.setCellStyle(numberStyle);
						} else {
							R1510cell12.setCellValue("");
							R1510cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1510cell13 = row.createCell(13);
						if (record1.getR1510_maximum_rate() != null) {
							R1510cell13.setCellValue(record1.getR1510_maximum_rate().doubleValue());
							R1510cell13.setCellStyle(numberStyle);
						} else {
							R1510cell13.setCellValue("");
							R1510cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1510cell14 = row.createCell(14);
						if (record1.getR1510_average_rate() != null) {
							R1510cell14.setCellValue(record1.getR1510_average_rate().doubleValue());
							R1510cell14.setCellStyle(numberStyle);
						} else {
							R1510cell14.setCellValue("");
							R1510cell14.setCellStyle(textStyle);
						}

						///// ROW163///////////
						// row163
						row = sheet.getRow(162);
						// Column M:
						Cell R1520cell12 = row.createCell(12);
						if (record1.getR1520_minimum_rate() != null) {
							R1520cell12.setCellValue(record1.getR1520_minimum_rate().doubleValue());
							R1520cell12.setCellStyle(numberStyle);
						} else {
							R1520cell12.setCellValue("");
							R1520cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1520cell13 = row.createCell(13);
						if (record1.getR1520_maximum_rate() != null) {
							R1520cell13.setCellValue(record1.getR1520_maximum_rate().doubleValue());
							R1520cell13.setCellStyle(numberStyle);
						} else {
							R1520cell13.setCellValue("");
							R1520cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1520cell14 = row.createCell(14);
						if (record1.getR1520_average_rate() != null) {
							R1520cell14.setCellValue(record1.getR1520_average_rate().doubleValue());
							R1520cell14.setCellStyle(numberStyle);
						} else {
							R1520cell14.setCellValue("");
							R1520cell14.setCellStyle(textStyle);
						}

						///// ROW164///////////
						// row164
						row = sheet.getRow(163);
						// Column M:
						Cell R1530cell12 = row.createCell(12);
						if (record1.getR1530_minimum_rate() != null) {
							R1530cell12.setCellValue(record1.getR1530_minimum_rate().doubleValue());
							R1530cell12.setCellStyle(numberStyle);
						} else {
							R1530cell12.setCellValue("");
							R1530cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1530cell13 = row.createCell(13);
						if (record1.getR1530_maximum_rate() != null) {
							R1530cell13.setCellValue(record1.getR1530_maximum_rate().doubleValue());
							R1530cell13.setCellStyle(numberStyle);
						} else {
							R1530cell13.setCellValue("");
							R1530cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1530cell14 = row.createCell(14);
						if (record1.getR1530_average_rate() != null) {
							R1530cell14.setCellValue(record1.getR1530_average_rate().doubleValue());
							R1530cell14.setCellStyle(numberStyle);
						} else {
							R1530cell14.setCellValue("");
							R1530cell14.setCellStyle(textStyle);
						}

						///// ROW166///////////
						// row166
						row = sheet.getRow(165);
						// Column M:
						Cell R1550cell12 = row.createCell(12);
						if (record1.getR1550_minimum_rate() != null) {
							R1550cell12.setCellValue(record1.getR1550_minimum_rate().doubleValue());
							R1550cell12.setCellStyle(numberStyle);
						} else {
							R1550cell12.setCellValue("");
							R1550cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1550cell13 = row.createCell(13);
						if (record1.getR1550_maximum_rate() != null) {
							R1550cell13.setCellValue(record1.getR1550_maximum_rate().doubleValue());
							R1550cell13.setCellStyle(numberStyle);
						} else {
							R1550cell13.setCellValue("");
							R1550cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1550cell14 = row.createCell(14);
						if (record1.getR1550_average_rate() != null) {
							R1550cell14.setCellValue(record1.getR1550_average_rate().doubleValue());
							R1550cell14.setCellStyle(numberStyle);
						} else {
							R1550cell14.setCellValue("");
							R1550cell14.setCellStyle(textStyle);
						}

						///// ROW167///////////
						// row167
						row = sheet.getRow(166);
						// Column M:
						Cell R1560cell12 = row.createCell(12);
						if (record1.getR1560_minimum_rate() != null) {
							R1560cell12.setCellValue(record1.getR1560_minimum_rate().doubleValue());
							R1560cell12.setCellStyle(numberStyle);
						} else {
							R1560cell12.setCellValue("");
							R1560cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1560cell13 = row.createCell(13);
						if (record1.getR1560_maximum_rate() != null) {
							R1560cell13.setCellValue(record1.getR1560_maximum_rate().doubleValue());
							R1560cell13.setCellStyle(numberStyle);
						} else {
							R1560cell13.setCellValue("");
							R1560cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1560cell14 = row.createCell(14);
						if (record1.getR1560_average_rate() != null) {
							R1560cell14.setCellValue(record1.getR1560_average_rate().doubleValue());
							R1560cell14.setCellStyle(numberStyle);
						} else {
							R1560cell14.setCellValue("");
							R1560cell14.setCellStyle(textStyle);
						}

						///// ROW168///////////
						// row168
						row = sheet.getRow(167);
						// Column M:
						Cell R1570cell12 = row.createCell(12);
						if (record1.getR1570_minimum_rate() != null) {
							R1570cell12.setCellValue(record1.getR1570_minimum_rate().doubleValue());
							R1570cell12.setCellStyle(numberStyle);
						} else {
							R1570cell12.setCellValue("");
							R1570cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1570cell13 = row.createCell(13);
						if (record1.getR1570_maximum_rate() != null) {
							R1570cell13.setCellValue(record1.getR1570_maximum_rate().doubleValue());
							R1570cell13.setCellStyle(numberStyle);
						} else {
							R1570cell13.setCellValue("");
							R1570cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1570cell14 = row.createCell(14);
						if (record1.getR1570_average_rate() != null) {
							R1570cell14.setCellValue(record1.getR1570_average_rate().doubleValue());
							R1570cell14.setCellStyle(numberStyle);
						} else {
							R1570cell14.setCellValue("");
							R1570cell14.setCellStyle(textStyle);
						}

						///// ROW169///////////
						// row169
						row = sheet.getRow(168);
						// Column M:
						Cell R1580cell12 = row.createCell(12);
						if (record1.getR1580_minimum_rate() != null) {
							R1580cell12.setCellValue(record1.getR1580_minimum_rate().doubleValue());
							R1580cell12.setCellStyle(numberStyle);
						} else {
							R1580cell12.setCellValue("");
							R1580cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1580cell13 = row.createCell(13);
						if (record1.getR1580_maximum_rate() != null) {
							R1580cell13.setCellValue(record1.getR1580_maximum_rate().doubleValue());
							R1580cell13.setCellStyle(numberStyle);
						} else {
							R1580cell13.setCellValue("");
							R1580cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1580cell14 = row.createCell(14);
						if (record1.getR1580_average_rate() != null) {
							R1580cell14.setCellValue(record1.getR1580_average_rate().doubleValue());
							R1580cell14.setCellStyle(numberStyle);
						} else {
							R1580cell14.setCellValue("");
							R1580cell14.setCellStyle(textStyle);
						}

						///// ROW170///////////
						// row170
						row = sheet.getRow(169);
						// Column M:
						Cell R1590cell12 = row.createCell(12);
						if (record1.getR1590_minimum_rate() != null) {
							R1590cell12.setCellValue(record1.getR1590_minimum_rate().doubleValue());
							R1590cell12.setCellStyle(numberStyle);
						} else {
							R1590cell12.setCellValue("");
							R1590cell12.setCellStyle(textStyle);
						}

						// Column N:
						Cell R1590cell13 = row.createCell(13);
						if (record1.getR1590_maximum_rate() != null) {
							R1590cell13.setCellValue(record1.getR1590_maximum_rate().doubleValue());
							R1590cell13.setCellStyle(numberStyle);
						} else {
							R1590cell13.setCellValue("");
							R1590cell13.setCellStyle(textStyle);
						}

						// Column O:
						Cell R1590cell14 = row.createCell(14);
						if (record1.getR1590_average_rate() != null) {
							R1590cell14.setCellValue(record1.getR1590_average_rate().doubleValue());
							R1590cell14.setCellStyle(numberStyle);
						} else {
							R1590cell14.setCellValue("");
							R1590cell14.setCellStyle(textStyle);
						}

					}

					int startRow3 = 172;

					// dataList1 for entity 2
					if (!dataList2.isEmpty()) {
						for (int i = 0; i < dataList2.size(); i++) {
							CBUAE_BRF2_13_Summary_Entity3 record2 = dataList2.get(i);

							System.out.println("rownumber = " + startRow + i);
							Row row = sheet.getRow(startRow + i);
							if (row == null) {
								row = sheet.createRow(startRow + i);
							}

							

							

							///// ROW172///////////
							// row172
							row = sheet.getRow(171);
							// Column H:
							Cell R1610cell7 = row.createCell(7);
							if (record2.getR1610_non_commercial_entities() != null) {
								R1610cell7.setCellValue(record2.getR1610_non_commercial_entities().doubleValue());
								R1610cell7.setCellStyle(numberStyle);
							} else {
								R1610cell7.setCellValue("");
								R1610cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1610cell8 = row.createCell(8);
							if (record2.getR1610_commercial_entities() != null) {
								R1610cell8.setCellValue(record2.getR1610_commercial_entities().doubleValue());
								R1610cell8.setCellStyle(numberStyle);
							} else {
								R1610cell8.setCellValue("");
								R1610cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1610cell9 = row.createCell(9);
							if (record2.getR1610_private_corporates() != null) {
								R1610cell9.setCellValue(record2.getR1610_private_corporates().doubleValue());
								R1610cell9.setCellStyle(numberStyle);
							} else {
								R1610cell9.setCellValue("");
								R1610cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1610cell10 = row.createCell(10);
							if (record2.getR1610_sme() != null) {
								R1610cell10.setCellValue(record2.getR1610_sme().doubleValue());
								R1610cell10.setCellStyle(numberStyle);
							} else {
								R1610cell10.setCellValue("");
								R1610cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1610cell12 = row.createCell(12);
							if (record2.getR1610_minimum_rate() != null) {
								R1610cell12.setCellValue(record2.getR1610_minimum_rate().doubleValue());
								R1610cell12.setCellStyle(numberStyle);
							} else {
								R1610cell12.setCellValue("");
								R1610cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1610cell13 = row.createCell(13);
							if (record2.getR1610_maximum_rate() != null) {
								R1610cell13.setCellValue(record2.getR1610_maximum_rate().doubleValue());
								R1610cell13.setCellStyle(numberStyle);
							} else {
								R1610cell13.setCellValue("");
								R1610cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1610cell14 = row.createCell(14);
							if (record2.getR1610_average_rate() != null) {
								R1610cell14.setCellValue(record2.getR1610_average_rate().doubleValue());
								R1610cell14.setCellStyle(numberStyle);
							} else {
								R1610cell14.setCellValue("");
								R1610cell14.setCellStyle(textStyle);
							}

							///// ROW173///////////
							// row173
							row = sheet.getRow(172);
							// Column H:
							Cell R1620cell7 = row.createCell(7);
							if (record2.getR1620_non_commercial_entities() != null) {
								R1620cell7.setCellValue(record2.getR1620_non_commercial_entities().doubleValue());
								R1620cell7.setCellStyle(numberStyle);
							} else {
								R1620cell7.setCellValue("");
								R1620cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1620cell8 = row.createCell(8);
							if (record2.getR1620_commercial_entities() != null) {
								R1620cell8.setCellValue(record2.getR1620_commercial_entities().doubleValue());
								R1620cell8.setCellStyle(numberStyle);
							} else {
								R1620cell8.setCellValue("");
								R1620cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1620cell9 = row.createCell(9);
							if (record2.getR1620_private_corporates() != null) {
								R1620cell9.setCellValue(record2.getR1620_private_corporates().doubleValue());
								R1620cell9.setCellStyle(numberStyle);
							} else {
								R1620cell9.setCellValue("");
								R1620cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1620cell10 = row.createCell(10);
							if (record2.getR1620_sme() != null) {
								R1620cell10.setCellValue(record2.getR1620_sme().doubleValue());
								R1620cell10.setCellStyle(numberStyle);
							} else {
								R1620cell10.setCellValue("");
								R1620cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1620cell12 = row.createCell(12);
							if (record2.getR1620_minimum_rate() != null) {
								R1620cell12.setCellValue(record2.getR1620_minimum_rate().doubleValue());
								R1620cell12.setCellStyle(numberStyle);
							} else {
								R1620cell12.setCellValue("");
								R1620cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1620cell13 = row.createCell(13);
							if (record2.getR1620_maximum_rate() != null) {
								R1620cell13.setCellValue(record2.getR1620_maximum_rate().doubleValue());
								R1620cell13.setCellStyle(numberStyle);
							} else {
								R1620cell13.setCellValue("");
								R1620cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1620cell14 = row.createCell(14);
							if (record2.getR1620_average_rate() != null) {
								R1620cell14.setCellValue(record2.getR1620_average_rate().doubleValue());
								R1620cell14.setCellStyle(numberStyle);
							} else {
								R1620cell14.setCellValue("");
								R1620cell14.setCellStyle(textStyle);
							}

							///// ROW174///////////
							// row174
							row = sheet.getRow(173);
							// Column H:
							Cell R1630cell7 = row.createCell(7);
							if (record2.getR1630_non_commercial_entities() != null) {
								R1630cell7.setCellValue(record2.getR1630_non_commercial_entities().doubleValue());
								R1630cell7.setCellStyle(numberStyle);
							} else {
								R1630cell7.setCellValue("");
								R1630cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1630cell8 = row.createCell(8);
							if (record2.getR1630_commercial_entities() != null) {
								R1630cell8.setCellValue(record2.getR1630_commercial_entities().doubleValue());
								R1630cell8.setCellStyle(numberStyle);
							} else {
								R1630cell8.setCellValue("");
								R1630cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1630cell9 = row.createCell(9);
							if (record2.getR1630_private_corporates() != null) {
								R1630cell9.setCellValue(record2.getR1630_private_corporates().doubleValue());
								R1630cell9.setCellStyle(numberStyle);
							} else {
								R1630cell9.setCellValue("");
								R1630cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1630cell10 = row.createCell(10);
							if (record2.getR1630_sme() != null) {
								R1630cell10.setCellValue(record2.getR1630_sme().doubleValue());
								R1630cell10.setCellStyle(numberStyle);
							} else {
								R1630cell10.setCellValue("");
								R1630cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1630cell12 = row.createCell(12);
							if (record2.getR1630_minimum_rate() != null) {
								R1630cell12.setCellValue(record2.getR1630_minimum_rate().doubleValue());
								R1630cell12.setCellStyle(numberStyle);
							} else {
								R1630cell12.setCellValue("");
								R1630cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1630cell13 = row.createCell(13);
							if (record2.getR1630_maximum_rate() != null) {
								R1630cell13.setCellValue(record2.getR1630_maximum_rate().doubleValue());
								R1630cell13.setCellStyle(numberStyle);
							} else {
								R1630cell13.setCellValue("");
								R1630cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1630cell14 = row.createCell(14);
							if (record2.getR1630_average_rate() != null) {
								R1630cell14.setCellValue(record2.getR1630_average_rate().doubleValue());
								R1630cell14.setCellStyle(numberStyle);
							} else {
								R1630cell14.setCellValue("");
								R1630cell14.setCellStyle(textStyle);
							}

							///// ROW175///////////
							// row175
							row = sheet.getRow(174);
							// Column H:
							Cell R1640cell7 = row.createCell(7);
							if (record2.getR1640_non_commercial_entities() != null) {
								R1640cell7.setCellValue(record2.getR1640_non_commercial_entities().doubleValue());
								R1640cell7.setCellStyle(numberStyle);
							} else {
								R1640cell7.setCellValue("");
								R1640cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1640cell8 = row.createCell(8);
							if (record2.getR1640_commercial_entities() != null) {
								R1640cell8.setCellValue(record2.getR1640_commercial_entities().doubleValue());
								R1640cell8.setCellStyle(numberStyle);
							} else {
								R1640cell8.setCellValue("");
								R1640cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1640cell9 = row.createCell(9);
							if (record2.getR1640_private_corporates() != null) {
								R1640cell9.setCellValue(record2.getR1640_private_corporates().doubleValue());
								R1640cell9.setCellStyle(numberStyle);
							} else {
								R1640cell9.setCellValue("");
								R1640cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1640cell10 = row.createCell(10);
							if (record2.getR1640_sme() != null) {
								R1640cell10.setCellValue(record2.getR1640_sme().doubleValue());
								R1640cell10.setCellStyle(numberStyle);
							} else {
								R1640cell10.setCellValue("");
								R1640cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1640cell12 = row.createCell(12);
							if (record2.getR1640_minimum_rate() != null) {
								R1640cell12.setCellValue(record2.getR1640_minimum_rate().doubleValue());
								R1640cell12.setCellStyle(numberStyle);
							} else {
								R1640cell12.setCellValue("");
								R1640cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1640cell13 = row.createCell(13);
							if (record2.getR1640_maximum_rate() != null) {
								R1640cell13.setCellValue(record2.getR1640_maximum_rate().doubleValue());
								R1640cell13.setCellStyle(numberStyle);
							} else {
								R1640cell13.setCellValue("");
								R1640cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1640cell14 = row.createCell(14);
							if (record2.getR1640_average_rate() != null) {
								R1640cell14.setCellValue(record2.getR1640_average_rate().doubleValue());
								R1640cell14.setCellStyle(numberStyle);
							} else {
								R1640cell14.setCellValue("");
								R1640cell14.setCellStyle(textStyle);
							}

							///// ROW176///////////
							// row176
							row = sheet.getRow(175);
							// Column H:
							Cell R1650cell7 = row.createCell(7);
							if (record2.getR1650_non_commercial_entities() != null) {
								R1650cell7.setCellValue(record2.getR1650_non_commercial_entities().doubleValue());
								R1650cell7.setCellStyle(numberStyle);
							} else {
								R1650cell7.setCellValue("");
								R1650cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1650cell8 = row.createCell(8);
							if (record2.getR1650_commercial_entities() != null) {
								R1650cell8.setCellValue(record2.getR1650_commercial_entities().doubleValue());
								R1650cell8.setCellStyle(numberStyle);
							} else {
								R1650cell8.setCellValue("");
								R1650cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1650cell9 = row.createCell(9);
							if (record2.getR1650_private_corporates() != null) {
								R1650cell9.setCellValue(record2.getR1650_private_corporates().doubleValue());
								R1650cell9.setCellStyle(numberStyle);
							} else {
								R1650cell9.setCellValue("");
								R1650cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1650cell10 = row.createCell(10);
							if (record2.getR1650_sme() != null) {
								R1650cell10.setCellValue(record2.getR1650_sme().doubleValue());
								R1650cell10.setCellStyle(numberStyle);
							} else {
								R1650cell10.setCellValue("");
								R1650cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1650cell12 = row.createCell(12);
							if (record2.getR1650_minimum_rate() != null) {
								R1650cell12.setCellValue(record2.getR1650_minimum_rate().doubleValue());
								R1650cell12.setCellStyle(numberStyle);
							} else {
								R1650cell12.setCellValue("");
								R1650cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1650cell13 = row.createCell(13);
							if (record2.getR1650_maximum_rate() != null) {
								R1650cell13.setCellValue(record2.getR1650_maximum_rate().doubleValue());
								R1650cell13.setCellStyle(numberStyle);
							} else {
								R1650cell13.setCellValue("");
								R1650cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1650cell14 = row.createCell(14);
							if (record2.getR1650_average_rate() != null) {
								R1650cell14.setCellValue(record2.getR1650_average_rate().doubleValue());
								R1650cell14.setCellStyle(numberStyle);
							} else {
								R1650cell14.setCellValue("");
								R1650cell14.setCellStyle(textStyle);
							}

							///// ROW177///////////
							// row177
							row = sheet.getRow(176);
							// Column H:
							Cell R1660cell7 = row.createCell(7);
							if (record2.getR1660_non_commercial_entities() != null) {
								R1660cell7.setCellValue(record2.getR1660_non_commercial_entities().doubleValue());
								R1660cell7.setCellStyle(numberStyle);
							} else {
								R1660cell7.setCellValue("");
								R1660cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1660cell8 = row.createCell(8);
							if (record2.getR1660_commercial_entities() != null) {
								R1660cell8.setCellValue(record2.getR1660_commercial_entities().doubleValue());
								R1660cell8.setCellStyle(numberStyle);
							} else {
								R1660cell8.setCellValue("");
								R1660cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1660cell9 = row.createCell(9);
							if (record2.getR1660_private_corporates() != null) {
								R1660cell9.setCellValue(record2.getR1660_private_corporates().doubleValue());
								R1660cell9.setCellStyle(numberStyle);
							} else {
								R1660cell9.setCellValue("");
								R1660cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1660cell10 = row.createCell(10);
							if (record2.getR1660_sme() != null) {
								R1660cell10.setCellValue(record2.getR1660_sme().doubleValue());
								R1660cell10.setCellStyle(numberStyle);
							} else {
								R1660cell10.setCellValue("");
								R1660cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1660cell12 = row.createCell(12);
							if (record2.getR1660_minimum_rate() != null) {
								R1660cell12.setCellValue(record2.getR1660_minimum_rate().doubleValue());
								R1660cell12.setCellStyle(numberStyle);
							} else {
								R1660cell12.setCellValue("");
								R1660cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1660cell13 = row.createCell(13);
							if (record2.getR1660_maximum_rate() != null) {
								R1660cell13.setCellValue(record2.getR1660_maximum_rate().doubleValue());
								R1660cell13.setCellStyle(numberStyle);
							} else {
								R1660cell13.setCellValue("");
								R1660cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1660cell14 = row.createCell(14);
							if (record2.getR1660_average_rate() != null) {
								R1660cell14.setCellValue(record2.getR1660_average_rate().doubleValue());
								R1660cell14.setCellStyle(numberStyle);
							} else {
								R1660cell14.setCellValue("");
								R1660cell14.setCellStyle(textStyle);
							}

							///// ROW178///////////
							// row178
							row = sheet.getRow(177);
							// Column H:
							Cell R1670cell7 = row.createCell(7);
							if (record2.getR1670_non_commercial_entities() != null) {
								R1670cell7.setCellValue(record2.getR1670_non_commercial_entities().doubleValue());
								R1670cell7.setCellStyle(numberStyle);
							} else {
								R1670cell7.setCellValue("");
								R1670cell7.setCellStyle(textStyle);
							}

							// Column I:
							Cell R1670cell8 = row.createCell(8);
							if (record2.getR1670_commercial_entities() != null) {
								R1670cell8.setCellValue(record2.getR1670_commercial_entities().doubleValue());
								R1670cell8.setCellStyle(numberStyle);
							} else {
								R1670cell8.setCellValue("");
								R1670cell8.setCellStyle(textStyle);
							}

							// Column J:
							Cell R1670cell9 = row.createCell(9);
							if (record2.getR1670_private_corporates() != null) {
								R1670cell9.setCellValue(record2.getR1670_private_corporates().doubleValue());
								R1670cell9.setCellStyle(numberStyle);
							} else {
								R1670cell9.setCellValue("");
								R1670cell9.setCellStyle(textStyle);
							}

							// Column K:
							Cell R1670cell10 = row.createCell(10);
							if (record2.getR1670_sme() != null) {
								R1670cell10.setCellValue(record2.getR1670_sme().doubleValue());
								R1670cell10.setCellStyle(numberStyle);
							} else {
								R1670cell10.setCellValue("");
								R1670cell10.setCellStyle(textStyle);
							}

							// Column M:
							Cell R1670cell12 = row.createCell(12);
							if (record2.getR1670_minimum_rate() != null) {
								R1670cell12.setCellValue(record2.getR1670_minimum_rate().doubleValue());
								R1670cell12.setCellStyle(numberStyle);
							} else {
								R1670cell12.setCellValue("");
								R1670cell12.setCellStyle(textStyle);
							}

							// Column N:
							Cell R1670cell13 = row.createCell(13);
							if (record2.getR1670_maximum_rate() != null) {
								R1670cell13.setCellValue(record2.getR1670_maximum_rate().doubleValue());
								R1670cell13.setCellStyle(numberStyle);
							} else {
								R1670cell13.setCellValue("");
								R1670cell13.setCellStyle(textStyle);
							}

							// Column O:
							Cell R1670cell14 = row.createCell(14);
							if (record2.getR1670_average_rate() != null) {
								R1670cell14.setCellValue(record2.getR1670_average_rate().doubleValue());
								R1670cell14.setCellStyle(numberStyle);
							} else {
								R1670cell14.setCellValue("");
								R1670cell14.setCellStyle(textStyle);
							}

						}

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

	// DetailExcel
	public byte[] getBRF2_13DetailExcel(String filename, String fromdate, String todate) {
		try {
			logger.info("Generating Excel for BRF2_13 Details...");
			System.out.println("came to Detail download service");

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF2_13Details");

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
			List<CBUAE_BRF2_13_Detail_Entity> reportData = CBUAE_BRF2_13_DETAIL_REPO.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF2_13_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF2_13 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF2_13 Excel", e);
			return new byte[0];
		}
	}

}
