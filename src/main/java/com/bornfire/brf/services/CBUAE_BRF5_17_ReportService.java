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

import com.bornfire.brf.entities.CBUAE_BRF5_17_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_17_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_17_Summary_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_17_Summary_Archival_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_17_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_17_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_17__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_17__Archival_Detail_Repo;

@Component
@Service

public class CBUAE_BRF5_17_ReportService {
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF5_17_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF5_17_Summary_Archival_Repo BRF5_17_Summary_Archival_Repo;

	@Autowired
	CBUAE_BRF5_17__Archival_Detail_Repo archival_detail_repo;

	@Autowired
	CBUAE_BRF5_17_Detail_Repo BRF5_17_Detail_Repo;

	@Autowired
	CBUAE_BRF5_17_Summary_Repo BRF5_17_Summary_Repo;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF5_17View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {
		System.out.println("getBRF5_17View");
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF5_17_Summary_Archival_Entity> T1Master = new ArrayList<CBUAE_BRF5_17_Summary_Archival_Entity>();
			try {
				Date d1 = dateformat.parse(todate);
				T1Master = BRF5_17_Summary_Archival_Repo.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}

			mv.addObject("reportsummary", T1Master);
		} else {
			List<CBUAE_BRF5_17_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF5_17_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);
				T1Master = BRF5_17_Summary_Repo.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}

		mv.setViewName("BRF/BRF5_17");
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF5_17currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF5_17__Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF5_17__Archival_Detail_Entity>();

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
					T1Dt1 = archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate),
							version);

					System.out.println("countavd" + T1Dt1.size());
				} else {

					T1Dt1 = archival_detail_repo.getdatabydateList(dateformat.parse(todate), version);
					System.out.println("countavd" + T1Dt1.size());
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(type);
			List<CBUAE_BRF5_17_Detail_Entity> T1Dt1 = new ArrayList<>();

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
					T1Dt1 = BRF5_17_Detail_Repo.GetDataByRowIdAndColumnId(rowId, columnId);
				} else {
					T1Dt1 = BRF5_17_Detail_Repo.getdatabydateList(d1);
				}
				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);
				System.out.println("LISTCOUNT: " + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("BRF/BRF5_17");
		mv.addObject("displaymode", "Details");
		// mv.addObject("reportdetails", T1Dt1);
		// mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public byte[] getBRF5_17Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF5_17ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}

		List<CBUAE_BRF5_17_Summary_Entity> dataList = BRF5_17_Summary_Repo.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF1.1 report. Returning empty result.");
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

			int startRow = 11;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF5_17_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					/// ROW12
					//// Column E
					Cell cell4 = row.createCell(4);
					if (record.getR0020_before_resident_individual() != null) {
						cell4.setCellValue(record.getR0020_before_resident_individual().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column F
					Cell cell5 = row.createCell(5);
					if (record.getR0020_after_resident_individual() != null) {
						cell5.setCellValue(record.getR0020_after_resident_individual().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column G
					Cell cell6 = row.createCell(6);
					if (record.getR0020_before_nonresident_individual() != null) {
						cell6.setCellValue(record.getR0020_before_nonresident_individual().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column H
					Cell cell7 = row.createCell(7);
					if (record.getR0020_after_nonresident_individual() != null) {
						cell7.setCellValue(record.getR0020_after_nonresident_individual().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column I
					Cell cell8 = row.createCell(8);
					if (record.getR0020_before_resident_retail() != null) {
						cell8.setCellValue(record.getR0020_before_resident_retail().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column J
					Cell cell9 = row.createCell(9);
					if (record.getR0020_after_resident_retail() != null) {
						cell9.setCellValue(record.getR0020_after_resident_retail().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column K
					Cell cell10 = row.createCell(10);
					if (record.getR0020_before_nonresident_retail() != null) {
						cell10.setCellValue(record.getR0020_before_nonresident_retail().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column L
					Cell cell11 = row.createCell(11);
					if (record.getR0020_after_nonresident_retail() != null) {
						cell11.setCellValue(record.getR0020_after_nonresident_retail().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column M
					Cell cell12 = row.createCell(12);
					if (record.getR0020_before_resident_sme() != null) {
						cell12.setCellValue(record.getR0020_before_resident_sme().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column N
					Cell cell13 = row.createCell(13);
					if (record.getR0020_after_resident_sme() != null) {
						cell13.setCellValue(record.getR0020_after_resident_sme().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column O
					Cell cell14 = row.createCell(14);
					if (record.getR0020_before_nonresident_sme() != null) {
						cell14.setCellValue(record.getR0020_before_nonresident_sme().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column P
					Cell cell15 = row.createCell(15);
					if (record.getR0020_after_nonresident_sme() != null) {
						cell15.setCellValue(record.getR0020_after_nonresident_sme().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column Q
					Cell cell16 = row.createCell(16);
					if (record.getR0020_before_resident_hni() != null) {
						cell16.setCellValue(record.getR0020_before_resident_hni().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column R
					Cell cell17 = row.createCell(17);
					if (record.getR0020_after_resident_hni() != null) {
						cell17.setCellValue(record.getR0020_after_resident_hni().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column S
					Cell cell18 = row.createCell(18);
					if (record.getR0020_before_nonresident_hni() != null) {
						cell18.setCellValue(record.getR0020_before_nonresident_hni().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column T
					Cell cell19 = row.createCell(19);
					if (record.getR0020_after_nonresident_hni() != null) {
						cell19.setCellValue(record.getR0020_after_nonresident_hni().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column U
					Cell cell20 = row.createCell(20);
					if (record.getR0020_before_resident_gre() != null) {
						cell20.setCellValue(record.getR0020_before_resident_gre().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column V
					Cell cell21 = row.createCell(21);
					if (record.getR0020_after_resident_gre() != null) {
						cell21.setCellValue(record.getR0020_after_resident_gre().doubleValue());
						cell21.setCellStyle(numberStyle);
					} else {
						cell21.setCellValue("");
						cell21.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column W
					Cell cell22 = row.createCell(22);
					if (record.getR0020_before_nonresident_gre() != null) {
						cell22.setCellValue(record.getR0020_before_nonresident_gre().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column X
					Cell cell23 = row.createCell(23);
					if (record.getR0020_after_nonresident_gre() != null) {
						cell23.setCellValue(record.getR0020_after_nonresident_gre().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column Y
					Cell cell24 = row.createCell(24);
					if (record.getR0020_before_resident_corporate() != null) {
						cell24.setCellValue(record.getR0020_before_resident_corporate().doubleValue());
						cell24.setCellStyle(numberStyle);
					} else {
						cell24.setCellValue("");
						cell24.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column Z
					Cell cell25 = row.createCell(25);
					if (record.getR0020_after_resident_corporate() != null) {
						cell25.setCellValue(record.getR0020_after_resident_corporate().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AA
					Cell cell26 = row.createCell(26);
					if (record.getR0020_before_nonresident_corporate() != null) {
						cell26.setCellValue(record.getR0020_before_nonresident_corporate().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AB
					Cell cell27 = row.createCell(27);
					if (record.getR0020_after_nonresident_corporate() != null) {
						cell27.setCellValue(record.getR0020_after_nonresident_corporate().doubleValue());
						cell27.setCellStyle(numberStyle);
					} else {
						cell27.setCellValue("");
						cell27.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AC
					Cell cell28 = row.createCell(28);
					if (record.getR0020_before_resident_nbfi() != null) {
						cell28.setCellValue(record.getR0020_before_resident_nbfi().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AD
					Cell cell29 = row.createCell(29);
					if (record.getR0020_after_resident_nbfi() != null) {
						cell29.setCellValue(record.getR0020_after_resident_nbfi().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AE
					Cell cell30 = row.createCell(30);
					if (record.getR0020_before_nonresident_nbfi() != null) {
						cell30.setCellValue(record.getR0020_before_nonresident_nbfi().doubleValue());
						cell30.setCellStyle(numberStyle);
					} else {
						cell30.setCellValue("");
						cell30.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AF
					Cell cell31 = row.createCell(31);
					if (record.getR0020_after_nonresident_nbfi() != null) {
						cell31.setCellValue(record.getR0020_after_nonresident_nbfi().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AG
					Cell cell32 = row.createCell(32);
					if (record.getR0020_before_resident_bank() != null) {
						cell32.setCellValue(record.getR0020_before_resident_bank().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AH
					Cell cell33 = row.createCell(33);
					if (record.getR0020_after_resident_bank() != null) {
						cell33.setCellValue(record.getR0020_after_resident_bank().doubleValue());
						cell33.setCellStyle(numberStyle);
					} else {
						cell33.setCellValue("");
						cell33.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AI
					Cell cell34 = row.createCell(34);
					if (record.getR0020_before_nonresident_bank() != null) {
						cell34.setCellValue(record.getR0020_before_nonresident_bank().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AJ
					Cell cell35 = row.createCell(35);
					if (record.getR0020_after_nonresident_bank() != null) {
						cell35.setCellValue(record.getR0020_after_nonresident_bank().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell35.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AK
					Cell cell36 = row.createCell(36);
					if (record.getR0020_before_resident_government() != null) {
						cell36.setCellValue(record.getR0020_before_resident_government().doubleValue());
						cell36.setCellStyle(numberStyle);
					} else {
						cell36.setCellValue("");
						cell36.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AL
					Cell cell37 = row.createCell(37);
					if (record.getR0020_after_resident_government() != null) {
						cell37.setCellValue(record.getR0020_after_resident_government().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AM
					Cell cell38 = row.createCell(38);
					if (record.getR0020_before_nonresident_government() != null) {
						cell38.setCellValue(record.getR0020_before_nonresident_government().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AN
					Cell cell39 = row.createCell(39);
					if (record.getR0020_after_nonresident_government() != null) {
						cell39.setCellValue(record.getR0020_after_nonresident_government().doubleValue());
						cell39.setCellStyle(numberStyle);
					} else {
						cell39.setCellValue("");
						cell39.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column E
					row = sheet.getRow(12);
					Cell R0030cell4 = row.createCell(4);
					if (record.getR0030_before_resident_individual() != null) {
						R0030cell4.setCellValue(record.getR0030_before_resident_individual().doubleValue());
						R0030cell4.setCellStyle(numberStyle);
					} else {
						R0030cell4.setCellValue("");
						R0030cell4.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column F
					Cell R0030cell5 = row.createCell(5);
					if (record.getR0030_after_resident_individual() != null) {
						R0030cell5.setCellValue(record.getR0030_after_resident_individual().doubleValue());
						R0030cell5.setCellStyle(numberStyle);
					} else {
						R0030cell5.setCellValue("");
						R0030cell5.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column G
					Cell R0030cell6 = row.createCell(6);
					if (record.getR0030_before_nonresident_individual() != null) {
						R0030cell6.setCellValue(record.getR0030_before_nonresident_individual().doubleValue());
						R0030cell6.setCellStyle(numberStyle);
					} else {
						R0030cell6.setCellValue("");
						R0030cell6.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column H
					Cell R0030cell7 = row.createCell(7);
					if (record.getR0030_after_nonresident_individual() != null) {
						R0030cell7.setCellValue(record.getR0030_after_nonresident_individual().doubleValue());
						R0030cell7.setCellStyle(numberStyle);
					} else {
						R0030cell7.setCellValue("");
						R0030cell7.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column I
					Cell R0030cell8 = row.createCell(8);
					if (record.getR0030_before_resident_retail() != null) {
						R0030cell8.setCellValue(record.getR0030_before_resident_retail().doubleValue());
						R0030cell8.setCellStyle(numberStyle);
					} else {
						R0030cell8.setCellValue("");
						R0030cell8.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column J
					Cell R0030cell9 = row.createCell(9);
					if (record.getR0030_after_resident_retail() != null) {
						R0030cell9.setCellValue(record.getR0030_after_resident_retail().doubleValue());
						R0030cell9.setCellStyle(numberStyle);
					} else {
						R0030cell9.setCellValue("");
						R0030cell9.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column K
					Cell R0030cell10 = row.createCell(10);
					if (record.getR0030_before_nonresident_retail() != null) {
						R0030cell10.setCellValue(record.getR0030_before_nonresident_retail().doubleValue());
						R0030cell10.setCellStyle(numberStyle);
					} else {
						R0030cell10.setCellValue("");
						R0030cell10.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column L
					Cell R0030cell11 = row.createCell(11);
					if (record.getR0030_after_nonresident_retail() != null) {
						R0030cell11.setCellValue(record.getR0030_after_nonresident_retail().doubleValue());
						R0030cell11.setCellStyle(numberStyle);
					} else {
						R0030cell11.setCellValue("");
						R0030cell11.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column M
					Cell R0030cell12 = row.createCell(12);
					if (record.getR0030_before_resident_sme() != null) {
						R0030cell12.setCellValue(record.getR0030_before_resident_sme().doubleValue());
						R0030cell12.setCellStyle(numberStyle);
					} else {
						R0030cell12.setCellValue("");
						R0030cell12.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column N
					Cell R0030cell13 = row.createCell(13);
					if (record.getR0030_after_resident_sme() != null) {
						R0030cell13.setCellValue(record.getR0030_after_resident_sme().doubleValue());
						R0030cell13.setCellStyle(numberStyle);
					} else {
						R0030cell13.setCellValue("");
						R0030cell13.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column O
					Cell R0030cell14 = row.createCell(14);
					if (record.getR0030_before_nonresident_sme() != null) {
						R0030cell14.setCellValue(record.getR0030_before_nonresident_sme().doubleValue());
						R0030cell14.setCellStyle(numberStyle);
					} else {
						R0030cell14.setCellValue("");
						R0030cell14.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column P
					Cell R0030cell15 = row.createCell(15);
					if (record.getR0030_after_nonresident_sme() != null) {
						R0030cell15.setCellValue(record.getR0030_after_nonresident_sme().doubleValue());
						R0030cell15.setCellStyle(numberStyle);
					} else {
						R0030cell15.setCellValue("");
						R0030cell15.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column Q
					Cell R0030cell16 = row.createCell(16);
					if (record.getR0030_before_resident_hni() != null) {
						R0030cell16.setCellValue(record.getR0030_before_resident_hni().doubleValue());
						R0030cell16.setCellStyle(numberStyle);
					} else {
						R0030cell16.setCellValue("");
						R0030cell16.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column R
					Cell R0030cell17 = row.createCell(17);
					if (record.getR0030_after_resident_hni() != null) {
						R0030cell17.setCellValue(record.getR0030_after_resident_hni().doubleValue());
						R0030cell17.setCellStyle(numberStyle);
					} else {
						R0030cell17.setCellValue("");
						R0030cell17.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column S
					Cell R0030cell18 = row.createCell(18);
					if (record.getR0030_before_nonresident_hni() != null) {
						R0030cell18.setCellValue(record.getR0030_before_nonresident_hni().doubleValue());
						R0030cell18.setCellStyle(numberStyle);
					} else {
						R0030cell18.setCellValue("");
						R0030cell18.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column T
					Cell R0030cell19 = row.createCell(19);
					if (record.getR0030_after_nonresident_hni() != null) {
						R0030cell19.setCellValue(record.getR0030_after_nonresident_hni().doubleValue());
						R0030cell19.setCellStyle(numberStyle);
					} else {
						R0030cell19.setCellValue("");
						R0030cell19.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column U
					Cell R0030cell20 = row.createCell(20);
					if (record.getR0030_before_resident_gre() != null) {
						R0030cell20.setCellValue(record.getR0030_before_resident_gre().doubleValue());
						R0030cell20.setCellStyle(numberStyle);
					} else {
						R0030cell20.setCellValue("");
						R0030cell20.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column V
					Cell R0030cell21 = row.createCell(21);
					if (record.getR0030_after_resident_gre() != null) {
						R0030cell21.setCellValue(record.getR0030_after_resident_gre().doubleValue());
						R0030cell21.setCellStyle(numberStyle);
					} else {
						R0030cell21.setCellValue("");
						R0030cell21.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column W
					Cell R0030cell22 = row.createCell(22);
					if (record.getR0030_before_nonresident_gre() != null) {
						R0030cell22.setCellValue(record.getR0030_before_nonresident_gre().doubleValue());
						R0030cell22.setCellStyle(numberStyle);
					} else {
						R0030cell22.setCellValue("");
						R0030cell22.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column X
					Cell R0030cell23 = row.createCell(23);
					if (record.getR0030_after_nonresident_gre() != null) {
						R0030cell23.setCellValue(record.getR0030_after_nonresident_gre().doubleValue());
						R0030cell23.setCellStyle(numberStyle);
					} else {
						R0030cell23.setCellValue("");
						R0030cell23.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column Y
					Cell R0030cell24 = row.createCell(24);
					if (record.getR0030_before_resident_corporate() != null) {
						R0030cell24.setCellValue(record.getR0030_before_resident_corporate().doubleValue());
						R0030cell24.setCellStyle(numberStyle);
					} else {
						R0030cell24.setCellValue("");
						R0030cell24.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column Z
					Cell R0030cell25 = row.createCell(25);
					if (record.getR0030_after_resident_corporate() != null) {
						R0030cell25.setCellValue(record.getR0030_after_resident_corporate().doubleValue());
						R0030cell25.setCellStyle(numberStyle);
					} else {
						R0030cell25.setCellValue("");
						R0030cell25.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AA
					Cell R0030cell26 = row.createCell(26);
					if (record.getR0030_before_nonresident_corporate() != null) {
						R0030cell26.setCellValue(record.getR0030_before_nonresident_corporate().doubleValue());
						R0030cell26.setCellStyle(numberStyle);
					} else {
						R0030cell26.setCellValue("");
						R0030cell26.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AB
					Cell R0030cell27 = row.createCell(27);
					if (record.getR0030_after_nonresident_corporate() != null) {
						R0030cell27.setCellValue(record.getR0030_after_nonresident_corporate().doubleValue());
						R0030cell27.setCellStyle(numberStyle);
					} else {
						R0030cell27.setCellValue("");
						R0030cell27.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AC
					Cell R0030cell28 = row.createCell(28);
					if (record.getR0030_before_resident_nbfi() != null) {
						R0030cell28.setCellValue(record.getR0030_before_resident_nbfi().doubleValue());
						R0030cell28.setCellStyle(numberStyle);
					} else {
						R0030cell28.setCellValue("");
						R0030cell28.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AD
					Cell R0030cell29 = row.createCell(29);
					if (record.getR0030_after_resident_nbfi() != null) {
						R0030cell29.setCellValue(record.getR0030_after_resident_nbfi().doubleValue());
						R0030cell29.setCellStyle(numberStyle);
					} else {
						R0030cell29.setCellValue("");
						R0030cell29.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AE
					Cell R0030cell30 = row.createCell(30);
					if (record.getR0030_before_nonresident_nbfi() != null) {
						R0030cell30.setCellValue(record.getR0030_before_nonresident_nbfi().doubleValue());
						R0030cell30.setCellStyle(numberStyle);
					} else {
						R0030cell30.setCellValue("");
						R0030cell30.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AF
					Cell R0030cell31 = row.createCell(31);
					if (record.getR0030_after_nonresident_nbfi() != null) {
						R0030cell31.setCellValue(record.getR0030_after_nonresident_nbfi().doubleValue());
						R0030cell31.setCellStyle(numberStyle);
					} else {
						R0030cell31.setCellValue("");
						R0030cell31.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AG
					Cell R0030cell32 = row.createCell(32);
					if (record.getR0030_before_resident_bank() != null) {
						R0030cell32.setCellValue(record.getR0030_before_resident_bank().doubleValue());
						R0030cell32.setCellStyle(numberStyle);
					} else {
						R0030cell32.setCellValue("");
						R0030cell32.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AH
					Cell R0030cell33 = row.createCell(33);
					if (record.getR0030_after_resident_bank() != null) {
						R0030cell33.setCellValue(record.getR0030_after_resident_bank().doubleValue());
						R0030cell33.setCellStyle(numberStyle);
					} else {
						R0030cell33.setCellValue("");
						R0030cell33.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AI
					Cell R0030cell34 = row.createCell(34);
					if (record.getR0030_before_nonresident_bank() != null) {
						R0030cell34.setCellValue(record.getR0030_before_nonresident_bank().doubleValue());
						R0030cell34.setCellStyle(numberStyle);
					} else {
						R0030cell34.setCellValue("");
						R0030cell34.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AJ
					Cell R0030cell35 = row.createCell(35);
					if (record.getR0030_after_nonresident_bank() != null) {
						R0030cell35.setCellValue(record.getR0030_after_nonresident_bank().doubleValue());
						R0030cell35.setCellStyle(numberStyle);
					} else {
						R0030cell35.setCellValue("");
						R0030cell35.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AK
					Cell R0030cell36 = row.createCell(36);
					if (record.getR0030_before_resident_government() != null) {
						R0030cell36.setCellValue(record.getR0030_before_resident_government().doubleValue());
						R0030cell36.setCellStyle(numberStyle);
					} else {
						R0030cell36.setCellValue("");
						R0030cell36.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AL
					Cell R0030cell37 = row.createCell(37);
					if (record.getR0030_after_resident_government() != null) {
						R0030cell37.setCellValue(record.getR0030_after_resident_government().doubleValue());
						R0030cell37.setCellStyle(numberStyle);
					} else {
						R0030cell37.setCellValue("");
						R0030cell37.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AM
					Cell R0030cell38 = row.createCell(38);
					if (record.getR0030_before_nonresident_government() != null) {
						R0030cell38.setCellValue(record.getR0030_before_nonresident_government().doubleValue());
						R0030cell38.setCellStyle(numberStyle);
					} else {
						R0030cell38.setCellValue("");
						R0030cell38.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AN
					Cell R0030cell39 = row.createCell(39);
					if (record.getR0030_after_nonresident_government() != null) {
						R0030cell39.setCellValue(record.getR0030_after_nonresident_government().doubleValue());
						R0030cell39.setCellStyle(numberStyle);
					} else {
						R0030cell39.setCellValue("");
						R0030cell39.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column E
					row = sheet.getRow(14);
					Cell R0050cell4 = row.createCell(4);
					if (record.getR0050_before_resident_individual() != null) {
						R0050cell4.setCellValue(record.getR0050_before_resident_individual().doubleValue());
						R0050cell4.setCellStyle(numberStyle);
					} else {
						R0050cell4.setCellValue("");
						R0050cell4.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column F
					Cell R0050cell5 = row.createCell(5);
					if (record.getR0050_after_resident_individual() != null) {
						R0050cell5.setCellValue(record.getR0050_after_resident_individual().doubleValue());
						R0050cell5.setCellStyle(numberStyle);
					} else {
						R0050cell5.setCellValue("");
						R0050cell5.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column G
					Cell R0050cell6 = row.createCell(6);
					if (record.getR0050_before_nonresident_individual() != null) {
						R0050cell6.setCellValue(record.getR0050_before_nonresident_individual().doubleValue());
						R0050cell6.setCellStyle(numberStyle);
					} else {
						R0050cell6.setCellValue("");
						R0050cell6.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column H
					Cell R0050cell7 = row.createCell(7);
					if (record.getR0050_after_nonresident_individual() != null) {
						R0050cell7.setCellValue(record.getR0050_after_nonresident_individual().doubleValue());
						R0050cell7.setCellStyle(numberStyle);
					} else {
						R0050cell7.setCellValue("");
						R0050cell7.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column I
					Cell R0050cell8 = row.createCell(8);
					if (record.getR0050_before_resident_retail() != null) {
						R0050cell8.setCellValue(record.getR0050_before_resident_retail().doubleValue());
						R0050cell8.setCellStyle(numberStyle);
					} else {
						R0050cell8.setCellValue("");
						R0050cell8.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column J
					Cell R0050cell9 = row.createCell(9);
					if (record.getR0050_after_resident_retail() != null) {
						R0050cell9.setCellValue(record.getR0050_after_resident_retail().doubleValue());
						R0050cell9.setCellStyle(numberStyle);
					} else {
						R0050cell9.setCellValue("");
						R0050cell9.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column K
					Cell R0050cell10 = row.createCell(10);
					if (record.getR0050_before_nonresident_retail() != null) {
						R0050cell10.setCellValue(record.getR0050_before_nonresident_retail().doubleValue());
						R0050cell10.setCellStyle(numberStyle);
					} else {
						R0050cell10.setCellValue("");
						R0050cell10.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column L
					Cell R0050cell11 = row.createCell(11);
					if (record.getR0050_after_nonresident_retail() != null) {
						R0050cell11.setCellValue(record.getR0050_after_nonresident_retail().doubleValue());
						R0050cell11.setCellStyle(numberStyle);
					} else {
						R0050cell11.setCellValue("");
						R0050cell11.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column M
					Cell R0050cell12 = row.createCell(12);
					if (record.getR0050_before_resident_sme() != null) {
						R0050cell12.setCellValue(record.getR0050_before_resident_sme().doubleValue());
						R0050cell12.setCellStyle(numberStyle);
					} else {
						R0050cell12.setCellValue("");
						R0050cell12.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column N
					Cell R0050cell13 = row.createCell(13);
					if (record.getR0050_after_resident_sme() != null) {
						R0050cell13.setCellValue(record.getR0050_after_resident_sme().doubleValue());
						R0050cell13.setCellStyle(numberStyle);
					} else {
						R0050cell13.setCellValue("");
						R0050cell13.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column O
					Cell R0050cell14 = row.createCell(14);
					if (record.getR0050_before_nonresident_sme() != null) {
						R0050cell14.setCellValue(record.getR0050_before_nonresident_sme().doubleValue());
						R0050cell14.setCellStyle(numberStyle);
					} else {
						R0050cell14.setCellValue("");
						R0050cell14.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column P
					Cell R0050cell15 = row.createCell(15);
					if (record.getR0050_after_nonresident_sme() != null) {
						R0050cell15.setCellValue(record.getR0050_after_nonresident_sme().doubleValue());
						R0050cell15.setCellStyle(numberStyle);
					} else {
						R0050cell15.setCellValue("");
						R0050cell15.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column Q
					Cell R0050cell16 = row.createCell(16);
					if (record.getR0050_before_resident_hni() != null) {
						R0050cell16.setCellValue(record.getR0050_before_resident_hni().doubleValue());
						R0050cell16.setCellStyle(numberStyle);
					} else {
						R0050cell16.setCellValue("");
						R0050cell16.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column R
					Cell R0050cell17 = row.createCell(17);
					if (record.getR0050_after_resident_hni() != null) {
						R0050cell17.setCellValue(record.getR0050_after_resident_hni().doubleValue());
						R0050cell17.setCellStyle(numberStyle);
					} else {
						R0050cell17.setCellValue("");
						R0050cell17.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column S
					Cell R0050cell18 = row.createCell(18);
					if (record.getR0050_before_nonresident_hni() != null) {
						R0050cell18.setCellValue(record.getR0050_before_nonresident_hni().doubleValue());
						R0050cell18.setCellStyle(numberStyle);
					} else {
						R0050cell18.setCellValue("");
						R0050cell18.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column T
					Cell R0050cell19 = row.createCell(19);
					if (record.getR0050_after_nonresident_hni() != null) {
						R0050cell19.setCellValue(record.getR0050_after_nonresident_hni().doubleValue());
						R0050cell19.setCellStyle(numberStyle);
					} else {
						R0050cell19.setCellValue("");
						R0050cell19.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column U
					Cell R0050cell20 = row.createCell(20);
					if (record.getR0050_before_resident_gre() != null) {
						R0050cell20.setCellValue(record.getR0050_before_resident_gre().doubleValue());
						R0050cell20.setCellStyle(numberStyle);
					} else {
						R0050cell20.setCellValue("");
						R0050cell20.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column V
					Cell R0050cell21 = row.createCell(21);
					if (record.getR0050_after_resident_gre() != null) {
						R0050cell21.setCellValue(record.getR0050_after_resident_gre().doubleValue());
						R0050cell21.setCellStyle(numberStyle);
					} else {
						R0050cell21.setCellValue("");
						R0050cell21.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column W
					Cell R0050cell22 = row.createCell(22);
					if (record.getR0050_before_nonresident_gre() != null) {
						R0050cell22.setCellValue(record.getR0050_before_nonresident_gre().doubleValue());
						R0050cell22.setCellStyle(numberStyle);
					} else {
						R0050cell22.setCellValue("");
						R0050cell22.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column X
					Cell R0050cell23 = row.createCell(23);
					if (record.getR0050_after_nonresident_gre() != null) {
						R0050cell23.setCellValue(record.getR0050_after_nonresident_gre().doubleValue());
						R0050cell23.setCellStyle(numberStyle);
					} else {
						R0050cell23.setCellValue("");
						R0050cell23.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column Y
					Cell R0050cell24 = row.createCell(24);
					if (record.getR0050_before_resident_corporate() != null) {
						R0050cell24.setCellValue(record.getR0050_before_resident_corporate().doubleValue());
						R0050cell24.setCellStyle(numberStyle);
					} else {
						R0050cell24.setCellValue("");
						R0050cell24.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column Z
					Cell R0050cell25 = row.createCell(25);
					if (record.getR0050_after_resident_corporate() != null) {
						R0050cell25.setCellValue(record.getR0050_after_resident_corporate().doubleValue());
						R0050cell25.setCellStyle(numberStyle);
					} else {
						R0050cell25.setCellValue("");
						R0050cell25.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AA
					Cell R0050cell26 = row.createCell(26);
					if (record.getR0050_before_nonresident_corporate() != null) {
						R0050cell26.setCellValue(record.getR0050_before_nonresident_corporate().doubleValue());
						R0050cell26.setCellStyle(numberStyle);
					} else {
						R0050cell26.setCellValue("");
						R0050cell26.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AB
					Cell R0050cell27 = row.createCell(27);
					if (record.getR0050_after_nonresident_corporate() != null) {
						R0050cell27.setCellValue(record.getR0050_after_nonresident_corporate().doubleValue());
						R0050cell27.setCellStyle(numberStyle);
					} else {
						R0050cell27.setCellValue("");
						R0050cell27.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AC
					Cell R0050cell28 = row.createCell(28);
					if (record.getR0050_before_resident_nbfi() != null) {
						R0050cell28.setCellValue(record.getR0050_before_resident_nbfi().doubleValue());
						R0050cell28.setCellStyle(numberStyle);
					} else {
						R0050cell28.setCellValue("");
						R0050cell28.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AD
					Cell R0050cell29 = row.createCell(29);
					if (record.getR0050_after_resident_nbfi() != null) {
						R0050cell29.setCellValue(record.getR0050_after_resident_nbfi().doubleValue());
						R0050cell29.setCellStyle(numberStyle);
					} else {
						R0050cell29.setCellValue("");
						R0050cell29.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AE
					Cell R0050cell30 = row.createCell(30);
					if (record.getR0050_before_nonresident_nbfi() != null) {
						R0050cell30.setCellValue(record.getR0050_before_nonresident_nbfi().doubleValue());
						R0050cell30.setCellStyle(numberStyle);
					} else {
						R0050cell30.setCellValue("");
						R0050cell30.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AF
					Cell R0050cell31 = row.createCell(31);
					if (record.getR0050_after_nonresident_nbfi() != null) {
						R0050cell31.setCellValue(record.getR0050_after_nonresident_nbfi().doubleValue());
						R0050cell31.setCellStyle(numberStyle);
					} else {
						R0050cell31.setCellValue("");
						R0050cell31.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AG
					Cell R0050cell32 = row.createCell(32);
					if (record.getR0050_before_resident_bank() != null) {
						R0050cell32.setCellValue(record.getR0050_before_resident_bank().doubleValue());
						R0050cell32.setCellStyle(numberStyle);
					} else {
						R0050cell32.setCellValue("");
						R0050cell32.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AH
					Cell R0050cell33 = row.createCell(33);
					if (record.getR0050_after_resident_bank() != null) {
						R0050cell33.setCellValue(record.getR0050_after_resident_bank().doubleValue());
						R0050cell33.setCellStyle(numberStyle);
					} else {
						R0050cell33.setCellValue("");
						R0050cell33.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AI
					Cell R0050cell34 = row.createCell(34);
					if (record.getR0050_before_nonresident_bank() != null) {
						R0050cell34.setCellValue(record.getR0050_before_nonresident_bank().doubleValue());
						R0050cell34.setCellStyle(numberStyle);
					} else {
						R0050cell34.setCellValue("");
						R0050cell34.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AJ
					Cell R0050cell35 = row.createCell(35);
					if (record.getR0050_after_nonresident_bank() != null) {
						R0050cell35.setCellValue(record.getR0050_after_nonresident_bank().doubleValue());
						R0050cell35.setCellStyle(numberStyle);
					} else {
						R0050cell35.setCellValue("");
						R0050cell35.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AK
					Cell R0050cell36 = row.createCell(36);
					if (record.getR0050_before_resident_government() != null) {
						R0050cell36.setCellValue(record.getR0050_before_resident_government().doubleValue());
						R0050cell36.setCellStyle(numberStyle);
					} else {
						R0050cell36.setCellValue("");
						R0050cell36.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AL
					Cell R0050cell37 = row.createCell(37);
					if (record.getR0050_after_resident_government() != null) {
						R0050cell37.setCellValue(record.getR0050_after_resident_government().doubleValue());
						R0050cell37.setCellStyle(numberStyle);
					} else {
						R0050cell37.setCellValue("");
						R0050cell37.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AM
					Cell R0050cell38 = row.createCell(38);
					if (record.getR0050_before_nonresident_government() != null) {
						R0050cell38.setCellValue(record.getR0050_before_nonresident_government().doubleValue());
						R0050cell38.setCellStyle(numberStyle);
					} else {
						R0050cell38.setCellValue("");
						R0050cell38.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AN
					Cell R0050cell39 = row.createCell(39);
					if (record.getR0050_after_nonresident_government() != null) {
						R0050cell39.setCellValue(record.getR0050_after_nonresident_government().doubleValue());
						R0050cell39.setCellStyle(numberStyle);
					} else {
						R0050cell39.setCellValue("");
						R0050cell39.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column E
					row = sheet.getRow(15);
					Cell R0060cell4 = row.createCell(4);
					if (record.getR0060_before_resident_individual() != null) {
						R0060cell4.setCellValue(record.getR0060_before_resident_individual().doubleValue());
						R0060cell4.setCellStyle(numberStyle);
					} else {
						R0060cell4.setCellValue("");
						R0060cell4.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column F
					Cell R0060cell5 = row.createCell(5);
					if (record.getR0060_after_resident_individual() != null) {
						R0060cell5.setCellValue(record.getR0060_after_resident_individual().doubleValue());
						R0060cell5.setCellStyle(numberStyle);
					} else {
						R0060cell5.setCellValue("");
						R0060cell5.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column G
					Cell R0060cell6 = row.createCell(6);
					if (record.getR0060_before_nonresident_individual() != null) {
						R0060cell6.setCellValue(record.getR0060_before_nonresident_individual().doubleValue());
						R0060cell6.setCellStyle(numberStyle);
					} else {
						R0060cell6.setCellValue("");
						R0060cell6.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column H
					Cell R0060cell7 = row.createCell(7);
					if (record.getR0060_after_nonresident_individual() != null) {
						R0060cell7.setCellValue(record.getR0060_after_nonresident_individual().doubleValue());
						R0060cell7.setCellStyle(numberStyle);
					} else {
						R0060cell7.setCellValue("");
						R0060cell7.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column I
					Cell R0060cell8 = row.createCell(8);
					if (record.getR0060_before_resident_retail() != null) {
						R0060cell8.setCellValue(record.getR0060_before_resident_retail().doubleValue());
						R0060cell8.setCellStyle(numberStyle);
					} else {
						R0060cell8.setCellValue("");
						R0060cell8.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column J
					Cell R0060cell9 = row.createCell(9);
					if (record.getR0060_after_resident_retail() != null) {
						R0060cell9.setCellValue(record.getR0060_after_resident_retail().doubleValue());
						R0060cell9.setCellStyle(numberStyle);
					} else {
						R0060cell9.setCellValue("");
						R0060cell9.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column K
					Cell R0060cell10 = row.createCell(10);
					if (record.getR0060_before_nonresident_retail() != null) {
						R0060cell10.setCellValue(record.getR0060_before_nonresident_retail().doubleValue());
						R0060cell10.setCellStyle(numberStyle);
					} else {
						R0060cell10.setCellValue("");
						R0060cell10.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column L
					Cell R0060cell11 = row.createCell(11);
					if (record.getR0060_after_nonresident_retail() != null) {
						R0060cell11.setCellValue(record.getR0060_after_nonresident_retail().doubleValue());
						R0060cell11.setCellStyle(numberStyle);
					} else {
						R0060cell11.setCellValue("");
						R0060cell11.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column M
					Cell R0060cell12 = row.createCell(12);
					if (record.getR0060_before_resident_sme() != null) {
						R0060cell12.setCellValue(record.getR0060_before_resident_sme().doubleValue());
						R0060cell12.setCellStyle(numberStyle);
					} else {
						R0060cell12.setCellValue("");
						R0060cell12.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column N
					Cell R0060cell13 = row.createCell(13);
					if (record.getR0060_after_resident_sme() != null) {
						R0060cell13.setCellValue(record.getR0060_after_resident_sme().doubleValue());
						R0060cell13.setCellStyle(numberStyle);
					} else {
						R0060cell13.setCellValue("");
						R0060cell13.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column O
					Cell R0060cell14 = row.createCell(14);
					if (record.getR0060_before_nonresident_sme() != null) {
						R0060cell14.setCellValue(record.getR0060_before_nonresident_sme().doubleValue());
						R0060cell14.setCellStyle(numberStyle);
					} else {
						R0060cell14.setCellValue("");
						R0060cell14.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column P
					Cell R0060cell15 = row.createCell(15);
					if (record.getR0060_after_nonresident_sme() != null) {
						R0060cell15.setCellValue(record.getR0060_after_nonresident_sme().doubleValue());
						R0060cell15.setCellStyle(numberStyle);
					} else {
						R0060cell15.setCellValue("");
						R0060cell15.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column Q
					Cell R0060cell16 = row.createCell(16);
					if (record.getR0060_before_resident_hni() != null) {
						R0060cell16.setCellValue(record.getR0060_before_resident_hni().doubleValue());
						R0060cell16.setCellStyle(numberStyle);
					} else {
						R0060cell16.setCellValue("");
						R0060cell16.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column R
					Cell R0060cell17 = row.createCell(17);
					if (record.getR0060_after_resident_hni() != null) {
						R0060cell17.setCellValue(record.getR0060_after_resident_hni().doubleValue());
						R0060cell17.setCellStyle(numberStyle);
					} else {
						R0060cell17.setCellValue("");
						R0060cell17.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column S
					Cell R0060cell18 = row.createCell(18);
					if (record.getR0060_before_nonresident_hni() != null) {
						R0060cell18.setCellValue(record.getR0060_before_nonresident_hni().doubleValue());
						R0060cell18.setCellStyle(numberStyle);
					} else {
						R0060cell18.setCellValue("");
						R0060cell18.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column T
					Cell R0060cell19 = row.createCell(19);
					if (record.getR0060_after_nonresident_hni() != null) {
						R0060cell19.setCellValue(record.getR0060_after_nonresident_hni().doubleValue());
						R0060cell19.setCellStyle(numberStyle);
					} else {
						R0060cell19.setCellValue("");
						R0060cell19.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column U
					Cell R0060cell20 = row.createCell(20);
					if (record.getR0060_before_resident_gre() != null) {
						R0060cell20.setCellValue(record.getR0060_before_resident_gre().doubleValue());
						R0060cell20.setCellStyle(numberStyle);
					} else {
						R0060cell20.setCellValue("");
						R0060cell20.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column V
					Cell R0060cell21 = row.createCell(21);
					if (record.getR0060_after_resident_gre() != null) {
						R0060cell21.setCellValue(record.getR0060_after_resident_gre().doubleValue());
						R0060cell21.setCellStyle(numberStyle);
					} else {
						R0060cell21.setCellValue("");
						R0060cell21.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column W
					Cell R0060cell22 = row.createCell(22);
					if (record.getR0060_before_nonresident_gre() != null) {
						R0060cell22.setCellValue(record.getR0060_before_nonresident_gre().doubleValue());
						R0060cell22.setCellStyle(numberStyle);
					} else {
						R0060cell22.setCellValue("");
						R0060cell22.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column X
					Cell R0060cell23 = row.createCell(23);
					if (record.getR0060_after_nonresident_gre() != null) {
						R0060cell23.setCellValue(record.getR0060_after_nonresident_gre().doubleValue());
						R0060cell23.setCellStyle(numberStyle);
					} else {
						R0060cell23.setCellValue("");
						R0060cell23.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column Y
					Cell R0060cell24 = row.createCell(24);
					if (record.getR0060_before_resident_corporate() != null) {
						R0060cell24.setCellValue(record.getR0060_before_resident_corporate().doubleValue());
						R0060cell24.setCellStyle(numberStyle);
					} else {
						R0060cell24.setCellValue("");
						R0060cell24.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column Z
					Cell R0060cell25 = row.createCell(25);
					if (record.getR0060_after_resident_corporate() != null) {
						R0060cell25.setCellValue(record.getR0060_after_resident_corporate().doubleValue());
						R0060cell25.setCellStyle(numberStyle);
					} else {
						R0060cell25.setCellValue("");
						R0060cell25.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AA
					Cell R0060cell26 = row.createCell(26);
					if (record.getR0060_before_nonresident_corporate() != null) {
						R0060cell26.setCellValue(record.getR0060_before_nonresident_corporate().doubleValue());
						R0060cell26.setCellStyle(numberStyle);
					} else {
						R0060cell26.setCellValue("");
						R0060cell26.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AB
					Cell R0060cell27 = row.createCell(27);
					if (record.getR0060_after_nonresident_corporate() != null) {
						R0060cell27.setCellValue(record.getR0060_after_nonresident_corporate().doubleValue());
						R0060cell27.setCellStyle(numberStyle);
					} else {
						R0060cell27.setCellValue("");
						R0060cell27.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AC
					Cell R0060cell28 = row.createCell(28);
					if (record.getR0060_before_resident_nbfi() != null) {
						R0060cell28.setCellValue(record.getR0060_before_resident_nbfi().doubleValue());
						R0060cell28.setCellStyle(numberStyle);
					} else {
						R0060cell28.setCellValue("");
						R0060cell28.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AD
					Cell R0060cell29 = row.createCell(29);
					if (record.getR0060_after_resident_nbfi() != null) {
						R0060cell29.setCellValue(record.getR0060_after_resident_nbfi().doubleValue());
						R0060cell29.setCellStyle(numberStyle);
					} else {
						R0060cell29.setCellValue("");
						R0060cell29.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AE
					Cell R0060cell30 = row.createCell(30);
					if (record.getR0060_before_nonresident_nbfi() != null) {
						R0060cell30.setCellValue(record.getR0060_before_nonresident_nbfi().doubleValue());
						R0060cell30.setCellStyle(numberStyle);
					} else {
						R0060cell30.setCellValue("");
						R0060cell30.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AF
					Cell R0060cell31 = row.createCell(31);
					if (record.getR0060_after_nonresident_nbfi() != null) {
						R0060cell31.setCellValue(record.getR0060_after_nonresident_nbfi().doubleValue());
						R0060cell31.setCellStyle(numberStyle);
					} else {
						R0060cell31.setCellValue("");
						R0060cell31.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AG
					Cell R0060cell32 = row.createCell(32);
					if (record.getR0060_before_resident_bank() != null) {
						R0060cell32.setCellValue(record.getR0060_before_resident_bank().doubleValue());
						R0060cell32.setCellStyle(numberStyle);
					} else {
						R0060cell32.setCellValue("");
						R0060cell32.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AH
					Cell R0060cell33 = row.createCell(33);
					if (record.getR0060_after_resident_bank() != null) {
						R0060cell33.setCellValue(record.getR0060_after_resident_bank().doubleValue());
						R0060cell33.setCellStyle(numberStyle);
					} else {
						R0060cell33.setCellValue("");
						R0060cell33.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AI
					Cell R0060cell34 = row.createCell(34);
					if (record.getR0060_before_nonresident_bank() != null) {
						R0060cell34.setCellValue(record.getR0060_before_nonresident_bank().doubleValue());
						R0060cell34.setCellStyle(numberStyle);
					} else {
						R0060cell34.setCellValue("");
						R0060cell34.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AJ
					Cell R0060cell35 = row.createCell(35);
					if (record.getR0060_after_nonresident_bank() != null) {
						R0060cell35.setCellValue(record.getR0060_after_nonresident_bank().doubleValue());
						R0060cell35.setCellStyle(numberStyle);
					} else {
						R0060cell35.setCellValue("");
						R0060cell35.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AK
					Cell R0060cell36 = row.createCell(36);
					if (record.getR0060_before_resident_government() != null) {
						R0060cell36.setCellValue(record.getR0060_before_resident_government().doubleValue());
						R0060cell36.setCellStyle(numberStyle);
					} else {
						R0060cell36.setCellValue("");
						R0060cell36.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AL
					Cell R0060cell37 = row.createCell(37);
					if (record.getR0060_after_resident_government() != null) {
						R0060cell37.setCellValue(record.getR0060_after_resident_government().doubleValue());
						R0060cell37.setCellStyle(numberStyle);
					} else {
						R0060cell37.setCellValue("");
						R0060cell37.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AM
					Cell R0060cell38 = row.createCell(38);
					if (record.getR0060_before_nonresident_government() != null) {
						R0060cell38.setCellValue(record.getR0060_before_nonresident_government().doubleValue());
						R0060cell38.setCellStyle(numberStyle);
					} else {
						R0060cell38.setCellValue("");
						R0060cell38.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AN
					Cell R0060cell39 = row.createCell(39);
					if (record.getR0060_after_nonresident_government() != null) {
						R0060cell39.setCellValue(record.getR0060_after_nonresident_government().doubleValue());
						R0060cell39.setCellStyle(numberStyle);
					} else {
						R0060cell39.setCellValue("");
						R0060cell39.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column E
					row = sheet.getRow(16);
					Cell R0070cell4 = row.createCell(4);
					if (record.getR0070_before_resident_individual() != null) {
						R0070cell4.setCellValue(record.getR0070_before_resident_individual().doubleValue());
						R0070cell4.setCellStyle(numberStyle);
					} else {
						R0070cell4.setCellValue("");
						R0070cell4.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column F
					Cell R0070cell5 = row.createCell(5);
					if (record.getR0070_after_resident_individual() != null) {
						R0070cell5.setCellValue(record.getR0070_after_resident_individual().doubleValue());
						R0070cell5.setCellStyle(numberStyle);
					} else {
						R0070cell5.setCellValue("");
						R0070cell5.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column G
					Cell R0070cell6 = row.createCell(6);
					if (record.getR0070_before_nonresident_individual() != null) {
						R0070cell6.setCellValue(record.getR0070_before_nonresident_individual().doubleValue());
						R0070cell6.setCellStyle(numberStyle);
					} else {
						R0070cell6.setCellValue("");
						R0070cell6.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column H
					Cell R0070cell7 = row.createCell(7);
					if (record.getR0070_after_nonresident_individual() != null) {
						R0070cell7.setCellValue(record.getR0070_after_nonresident_individual().doubleValue());
						R0070cell7.setCellStyle(numberStyle);
					} else {
						R0070cell7.setCellValue("");
						R0070cell7.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column I
					Cell R0070cell8 = row.createCell(8);
					if (record.getR0070_before_resident_retail() != null) {
						R0070cell8.setCellValue(record.getR0070_before_resident_retail().doubleValue());
						R0070cell8.setCellStyle(numberStyle);
					} else {
						R0070cell8.setCellValue("");
						R0070cell8.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column J
					Cell R0070cell9 = row.createCell(9);
					if (record.getR0070_after_resident_retail() != null) {
						R0070cell9.setCellValue(record.getR0070_after_resident_retail().doubleValue());
						R0070cell9.setCellStyle(numberStyle);
					} else {
						R0070cell9.setCellValue("");
						R0070cell9.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column K
					Cell R0070cell10 = row.createCell(10);
					if (record.getR0070_before_nonresident_retail() != null) {
						R0070cell10.setCellValue(record.getR0070_before_nonresident_retail().doubleValue());
						R0070cell10.setCellStyle(numberStyle);
					} else {
						R0070cell10.setCellValue("");
						R0070cell10.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column L
					Cell R0070cell11 = row.createCell(11);
					if (record.getR0070_after_nonresident_retail() != null) {
						R0070cell11.setCellValue(record.getR0070_after_nonresident_retail().doubleValue());
						R0070cell11.setCellStyle(numberStyle);
					} else {
						R0070cell11.setCellValue("");
						R0070cell11.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column M
					Cell R0070cell12 = row.createCell(12);
					if (record.getR0070_before_resident_sme() != null) {
						R0070cell12.setCellValue(record.getR0070_before_resident_sme().doubleValue());
						R0070cell12.setCellStyle(numberStyle);
					} else {
						R0070cell12.setCellValue("");
						R0070cell12.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column N
					Cell R0070cell13 = row.createCell(13);
					if (record.getR0070_after_resident_sme() != null) {
						R0070cell13.setCellValue(record.getR0070_after_resident_sme().doubleValue());
						R0070cell13.setCellStyle(numberStyle);
					} else {
						R0070cell13.setCellValue("");
						R0070cell13.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column O
					Cell R0070cell14 = row.createCell(14);
					if (record.getR0070_before_nonresident_sme() != null) {
						R0070cell14.setCellValue(record.getR0070_before_nonresident_sme().doubleValue());
						R0070cell14.setCellStyle(numberStyle);
					} else {
						R0070cell14.setCellValue("");
						R0070cell14.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column P
					Cell R0070cell15 = row.createCell(15);
					if (record.getR0070_after_nonresident_sme() != null) {
						R0070cell15.setCellValue(record.getR0070_after_nonresident_sme().doubleValue());
						R0070cell15.setCellStyle(numberStyle);
					} else {
						R0070cell15.setCellValue("");
						R0070cell15.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column Q
					Cell R0070cell16 = row.createCell(16);
					if (record.getR0070_before_resident_hni() != null) {
						R0070cell16.setCellValue(record.getR0070_before_resident_hni().doubleValue());
						R0070cell16.setCellStyle(numberStyle);
					} else {
						R0070cell16.setCellValue("");
						R0070cell16.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column R
					Cell R0070cell17 = row.createCell(17);
					if (record.getR0070_after_resident_hni() != null) {
						R0070cell17.setCellValue(record.getR0070_after_resident_hni().doubleValue());
						R0070cell17.setCellStyle(numberStyle);
					} else {
						R0070cell17.setCellValue("");
						R0070cell17.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column S
					Cell R0070cell18 = row.createCell(18);
					if (record.getR0070_before_nonresident_hni() != null) {
						R0070cell18.setCellValue(record.getR0070_before_nonresident_hni().doubleValue());
						R0070cell18.setCellStyle(numberStyle);
					} else {
						R0070cell18.setCellValue("");
						R0070cell18.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column T
					Cell R0070cell19 = row.createCell(19);
					if (record.getR0070_after_nonresident_hni() != null) {
						R0070cell19.setCellValue(record.getR0070_after_nonresident_hni().doubleValue());
						R0070cell19.setCellStyle(numberStyle);
					} else {
						R0070cell19.setCellValue("");
						R0070cell19.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column U
					Cell R0070cell20 = row.createCell(20);
					if (record.getR0070_before_resident_gre() != null) {
						R0070cell20.setCellValue(record.getR0070_before_resident_gre().doubleValue());
						R0070cell20.setCellStyle(numberStyle);
					} else {
						R0070cell20.setCellValue("");
						R0070cell20.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column V
					Cell R0070cell21 = row.createCell(21);
					if (record.getR0070_after_resident_gre() != null) {
						R0070cell21.setCellValue(record.getR0070_after_resident_gre().doubleValue());
						R0070cell21.setCellStyle(numberStyle);
					} else {
						R0070cell21.setCellValue("");
						R0070cell21.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column W
					Cell R0070cell22 = row.createCell(22);
					if (record.getR0070_before_nonresident_gre() != null) {
						R0070cell22.setCellValue(record.getR0070_before_nonresident_gre().doubleValue());
						R0070cell22.setCellStyle(numberStyle);
					} else {
						R0070cell22.setCellValue("");
						R0070cell22.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column X
					Cell R0070cell23 = row.createCell(23);
					if (record.getR0070_after_nonresident_gre() != null) {
						R0070cell23.setCellValue(record.getR0070_after_nonresident_gre().doubleValue());
						R0070cell23.setCellStyle(numberStyle);
					} else {
						R0070cell23.setCellValue("");
						R0070cell23.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column Y
					Cell R0070cell24 = row.createCell(24);
					if (record.getR0070_before_resident_corporate() != null) {
						R0070cell24.setCellValue(record.getR0070_before_resident_corporate().doubleValue());
						R0070cell24.setCellStyle(numberStyle);
					} else {
						R0070cell24.setCellValue("");
						R0070cell24.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column Z
					Cell R0070cell25 = row.createCell(25);
					if (record.getR0070_after_resident_corporate() != null) {
						R0070cell25.setCellValue(record.getR0070_after_resident_corporate().doubleValue());
						R0070cell25.setCellStyle(numberStyle);
					} else {
						R0070cell25.setCellValue("");
						R0070cell25.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AA
					Cell R0070cell26 = row.createCell(26);
					if (record.getR0070_before_nonresident_corporate() != null) {
						R0070cell26.setCellValue(record.getR0070_before_nonresident_corporate().doubleValue());
						R0070cell26.setCellStyle(numberStyle);
					} else {
						R0070cell26.setCellValue("");
						R0070cell26.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AB
					Cell R0070cell27 = row.createCell(27);
					if (record.getR0070_after_nonresident_corporate() != null) {
						R0070cell27.setCellValue(record.getR0070_after_nonresident_corporate().doubleValue());
						R0070cell27.setCellStyle(numberStyle);
					} else {
						R0070cell27.setCellValue("");
						R0070cell27.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AC
					Cell R0070cell28 = row.createCell(28);
					if (record.getR0070_before_resident_nbfi() != null) {
						R0070cell28.setCellValue(record.getR0070_before_resident_nbfi().doubleValue());
						R0070cell28.setCellStyle(numberStyle);
					} else {
						R0070cell28.setCellValue("");
						R0070cell28.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AD
					Cell R0070cell29 = row.createCell(29);
					if (record.getR0070_after_resident_nbfi() != null) {
						R0070cell29.setCellValue(record.getR0070_after_resident_nbfi().doubleValue());
						R0070cell29.setCellStyle(numberStyle);
					} else {
						R0070cell29.setCellValue("");
						R0070cell29.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AE
					Cell R0070cell30 = row.createCell(30);
					if (record.getR0070_before_nonresident_nbfi() != null) {
						R0070cell30.setCellValue(record.getR0070_before_nonresident_nbfi().doubleValue());
						R0070cell30.setCellStyle(numberStyle);
					} else {
						R0070cell30.setCellValue("");
						R0070cell30.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AF
					Cell R0070cell31 = row.createCell(31);
					if (record.getR0070_after_nonresident_nbfi() != null) {
						R0070cell31.setCellValue(record.getR0070_after_nonresident_nbfi().doubleValue());
						R0070cell31.setCellStyle(numberStyle);
					} else {
						R0070cell31.setCellValue("");
						R0070cell31.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AG
					Cell R0070cell32 = row.createCell(32);
					if (record.getR0070_before_resident_bank() != null) {
						R0070cell32.setCellValue(record.getR0070_before_resident_bank().doubleValue());
						R0070cell32.setCellStyle(numberStyle);
					} else {
						R0070cell32.setCellValue("");
						R0070cell32.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AH
					Cell R0070cell33 = row.createCell(33);
					if (record.getR0070_after_resident_bank() != null) {
						R0070cell33.setCellValue(record.getR0070_after_resident_bank().doubleValue());
						R0070cell33.setCellStyle(numberStyle);
					} else {
						R0070cell33.setCellValue("");
						R0070cell33.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AI
					Cell R0070cell34 = row.createCell(34);
					if (record.getR0070_before_nonresident_bank() != null) {
						R0070cell34.setCellValue(record.getR0070_before_nonresident_bank().doubleValue());
						R0070cell34.setCellStyle(numberStyle);
					} else {
						R0070cell34.setCellValue("");
						R0070cell34.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AJ
					Cell R0070cell35 = row.createCell(35);
					if (record.getR0070_after_nonresident_bank() != null) {
						R0070cell35.setCellValue(record.getR0070_after_nonresident_bank().doubleValue());
						R0070cell35.setCellStyle(numberStyle);
					} else {
						R0070cell35.setCellValue("");
						R0070cell35.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AK
					Cell R0070cell36 = row.createCell(36);
					if (record.getR0070_before_resident_government() != null) {
						R0070cell36.setCellValue(record.getR0070_before_resident_government().doubleValue());
						R0070cell36.setCellStyle(numberStyle);
					} else {
						R0070cell36.setCellValue("");
						R0070cell36.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AL
					Cell R0070cell37 = row.createCell(37);
					if (record.getR0070_after_resident_government() != null) {
						R0070cell37.setCellValue(record.getR0070_after_resident_government().doubleValue());
						R0070cell37.setCellStyle(numberStyle);
					} else {
						R0070cell37.setCellValue("");
						R0070cell37.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AM
					Cell R0070cell38 = row.createCell(38);
					if (record.getR0070_before_nonresident_government() != null) {
						R0070cell38.setCellValue(record.getR0070_before_nonresident_government().doubleValue());
						R0070cell38.setCellStyle(numberStyle);
					} else {
						R0070cell38.setCellValue("");
						R0070cell38.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AN
					Cell R0070cell39 = row.createCell(39);
					if (record.getR0070_after_nonresident_government() != null) {
						R0070cell39.setCellValue(record.getR0070_after_nonresident_government().doubleValue());
						R0070cell39.setCellStyle(numberStyle);
					} else {
						R0070cell39.setCellValue("");
						R0070cell39.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column E
					row = sheet.getRow(17);
					Cell R0080cell4 = row.createCell(4);
					if (record.getR0080_before_resident_individual() != null) {
						R0080cell4.setCellValue(record.getR0080_before_resident_individual().doubleValue());
						R0080cell4.setCellStyle(numberStyle);
					} else {
						R0080cell4.setCellValue("");
						R0080cell4.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column F
					Cell R0080cell5 = row.createCell(5);
					if (record.getR0080_after_resident_individual() != null) {
						R0080cell5.setCellValue(record.getR0080_after_resident_individual().doubleValue());
						R0080cell5.setCellStyle(numberStyle);
					} else {
						R0080cell5.setCellValue("");
						R0080cell5.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column G
					Cell R0080cell6 = row.createCell(6);
					if (record.getR0080_before_nonresident_individual() != null) {
						R0080cell6.setCellValue(record.getR0080_before_nonresident_individual().doubleValue());
						R0080cell6.setCellStyle(numberStyle);
					} else {
						R0080cell6.setCellValue("");
						R0080cell6.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column H
					Cell R0080cell7 = row.createCell(7);
					if (record.getR0080_after_nonresident_individual() != null) {
						R0080cell7.setCellValue(record.getR0080_after_nonresident_individual().doubleValue());
						R0080cell7.setCellStyle(numberStyle);
					} else {
						R0080cell7.setCellValue("");
						R0080cell7.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column I
					Cell R0080cell8 = row.createCell(8);
					if (record.getR0080_before_resident_retail() != null) {
						R0080cell8.setCellValue(record.getR0080_before_resident_retail().doubleValue());
						R0080cell8.setCellStyle(numberStyle);
					} else {
						R0080cell8.setCellValue("");
						R0080cell8.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column J
					Cell R0080cell9 = row.createCell(9);
					if (record.getR0080_after_resident_retail() != null) {
						R0080cell9.setCellValue(record.getR0080_after_resident_retail().doubleValue());
						R0080cell9.setCellStyle(numberStyle);
					} else {
						R0080cell9.setCellValue("");
						R0080cell9.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column K
					Cell R0080cell10 = row.createCell(10);
					if (record.getR0080_before_nonresident_retail() != null) {
						R0080cell10.setCellValue(record.getR0080_before_nonresident_retail().doubleValue());
						R0080cell10.setCellStyle(numberStyle);
					} else {
						R0080cell10.setCellValue("");
						R0080cell10.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column L
					Cell R0080cell11 = row.createCell(11);
					if (record.getR0080_after_nonresident_retail() != null) {
						R0080cell11.setCellValue(record.getR0080_after_nonresident_retail().doubleValue());
						R0080cell11.setCellStyle(numberStyle);
					} else {
						R0080cell11.setCellValue("");
						R0080cell11.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column M
					Cell R0080cell12 = row.createCell(12);
					if (record.getR0080_before_resident_sme() != null) {
						R0080cell12.setCellValue(record.getR0080_before_resident_sme().doubleValue());
						R0080cell12.setCellStyle(numberStyle);
					} else {
						R0080cell12.setCellValue("");
						R0080cell12.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column N
					Cell R0080cell13 = row.createCell(13);
					if (record.getR0080_after_resident_sme() != null) {
						R0080cell13.setCellValue(record.getR0080_after_resident_sme().doubleValue());
						R0080cell13.setCellStyle(numberStyle);
					} else {
						R0080cell13.setCellValue("");
						R0080cell13.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column O
					Cell R0080cell14 = row.createCell(14);
					if (record.getR0080_before_nonresident_sme() != null) {
						R0080cell14.setCellValue(record.getR0080_before_nonresident_sme().doubleValue());
						R0080cell14.setCellStyle(numberStyle);
					} else {
						R0080cell14.setCellValue("");
						R0080cell14.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column P
					Cell R0080cell15 = row.createCell(15);
					if (record.getR0080_after_nonresident_sme() != null) {
						R0080cell15.setCellValue(record.getR0080_after_nonresident_sme().doubleValue());
						R0080cell15.setCellStyle(numberStyle);
					} else {
						R0080cell15.setCellValue("");
						R0080cell15.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column Q
					Cell R0080cell16 = row.createCell(16);
					if (record.getR0080_before_resident_hni() != null) {
						R0080cell16.setCellValue(record.getR0080_before_resident_hni().doubleValue());
						R0080cell16.setCellStyle(numberStyle);
					} else {
						R0080cell16.setCellValue("");
						R0080cell16.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column R
					Cell R0080cell17 = row.createCell(17);
					if (record.getR0080_after_resident_hni() != null) {
						R0080cell17.setCellValue(record.getR0080_after_resident_hni().doubleValue());
						R0080cell17.setCellStyle(numberStyle);
					} else {
						R0080cell17.setCellValue("");
						R0080cell17.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column S
					Cell R0080cell18 = row.createCell(18);
					if (record.getR0080_before_nonresident_hni() != null) {
						R0080cell18.setCellValue(record.getR0080_before_nonresident_hni().doubleValue());
						R0080cell18.setCellStyle(numberStyle);
					} else {
						R0080cell18.setCellValue("");
						R0080cell18.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column T
					Cell R0080cell19 = row.createCell(19);
					if (record.getR0080_after_nonresident_hni() != null) {
						R0080cell19.setCellValue(record.getR0080_after_nonresident_hni().doubleValue());
						R0080cell19.setCellStyle(numberStyle);
					} else {
						R0080cell19.setCellValue("");
						R0080cell19.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column U
					Cell R0080cell20 = row.createCell(20);
					if (record.getR0080_before_resident_gre() != null) {
						R0080cell20.setCellValue(record.getR0080_before_resident_gre().doubleValue());
						R0080cell20.setCellStyle(numberStyle);
					} else {
						R0080cell20.setCellValue("");
						R0080cell20.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column V
					Cell R0080cell21 = row.createCell(21);
					if (record.getR0080_after_resident_gre() != null) {
						R0080cell21.setCellValue(record.getR0080_after_resident_gre().doubleValue());
						R0080cell21.setCellStyle(numberStyle);
					} else {
						R0080cell21.setCellValue("");
						R0080cell21.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column W
					Cell R0080cell22 = row.createCell(22);
					if (record.getR0080_before_nonresident_gre() != null) {
						R0080cell22.setCellValue(record.getR0080_before_nonresident_gre().doubleValue());
						R0080cell22.setCellStyle(numberStyle);
					} else {
						R0080cell22.setCellValue("");
						R0080cell22.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column X
					Cell R0080cell23 = row.createCell(23);
					if (record.getR0080_after_nonresident_gre() != null) {
						R0080cell23.setCellValue(record.getR0080_after_nonresident_gre().doubleValue());
						R0080cell23.setCellStyle(numberStyle);
					} else {
						R0080cell23.setCellValue("");
						R0080cell23.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column Y
					Cell R0080cell24 = row.createCell(24);
					if (record.getR0080_before_resident_corporate() != null) {
						R0080cell24.setCellValue(record.getR0080_before_resident_corporate().doubleValue());
						R0080cell24.setCellStyle(numberStyle);
					} else {
						R0080cell24.setCellValue("");
						R0080cell24.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column Z
					Cell R0080cell25 = row.createCell(25);
					if (record.getR0080_after_resident_corporate() != null) {
						R0080cell25.setCellValue(record.getR0080_after_resident_corporate().doubleValue());
						R0080cell25.setCellStyle(numberStyle);
					} else {
						R0080cell25.setCellValue("");
						R0080cell25.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AA
					Cell R0080cell26 = row.createCell(26);
					if (record.getR0080_before_nonresident_corporate() != null) {
						R0080cell26.setCellValue(record.getR0080_before_nonresident_corporate().doubleValue());
						R0080cell26.setCellStyle(numberStyle);
					} else {
						R0080cell26.setCellValue("");
						R0080cell26.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AB
					Cell R0080cell27 = row.createCell(27);
					if (record.getR0080_after_nonresident_corporate() != null) {
						R0080cell27.setCellValue(record.getR0080_after_nonresident_corporate().doubleValue());
						R0080cell27.setCellStyle(numberStyle);
					} else {
						R0080cell27.setCellValue("");
						R0080cell27.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AC
					Cell R0080cell28 = row.createCell(28);
					if (record.getR0080_before_resident_nbfi() != null) {
						R0080cell28.setCellValue(record.getR0080_before_resident_nbfi().doubleValue());
						R0080cell28.setCellStyle(numberStyle);
					} else {
						R0080cell28.setCellValue("");
						R0080cell28.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AD
					Cell R0080cell29 = row.createCell(29);
					if (record.getR0080_after_resident_nbfi() != null) {
						R0080cell29.setCellValue(record.getR0080_after_resident_nbfi().doubleValue());
						R0080cell29.setCellStyle(numberStyle);
					} else {
						R0080cell29.setCellValue("");
						R0080cell29.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AE
					Cell R0080cell30 = row.createCell(30);
					if (record.getR0080_before_nonresident_nbfi() != null) {
						R0080cell30.setCellValue(record.getR0080_before_nonresident_nbfi().doubleValue());
						R0080cell30.setCellStyle(numberStyle);
					} else {
						R0080cell30.setCellValue("");
						R0080cell30.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AF
					Cell R0080cell31 = row.createCell(31);
					if (record.getR0080_after_nonresident_nbfi() != null) {
						R0080cell31.setCellValue(record.getR0080_after_nonresident_nbfi().doubleValue());
						R0080cell31.setCellStyle(numberStyle);
					} else {
						R0080cell31.setCellValue("");
						R0080cell31.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AG
					Cell R0080cell32 = row.createCell(32);
					if (record.getR0080_before_resident_bank() != null) {
						R0080cell32.setCellValue(record.getR0080_before_resident_bank().doubleValue());
						R0080cell32.setCellStyle(numberStyle);
					} else {
						R0080cell32.setCellValue("");
						R0080cell32.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AH
					Cell R0080cell33 = row.createCell(33);
					if (record.getR0080_after_resident_bank() != null) {
						R0080cell33.setCellValue(record.getR0080_after_resident_bank().doubleValue());
						R0080cell33.setCellStyle(numberStyle);
					} else {
						R0080cell33.setCellValue("");
						R0080cell33.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AI
					Cell R0080cell34 = row.createCell(34);
					if (record.getR0080_before_nonresident_bank() != null) {
						R0080cell34.setCellValue(record.getR0080_before_nonresident_bank().doubleValue());
						R0080cell34.setCellStyle(numberStyle);
					} else {
						R0080cell34.setCellValue("");
						R0080cell34.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AJ
					Cell R0080cell35 = row.createCell(35);
					if (record.getR0080_after_nonresident_bank() != null) {
						R0080cell35.setCellValue(record.getR0080_after_nonresident_bank().doubleValue());
						R0080cell35.setCellStyle(numberStyle);
					} else {
						R0080cell35.setCellValue("");
						R0080cell35.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AK
					Cell R0080cell36 = row.createCell(36);
					if (record.getR0080_before_resident_government() != null) {
						R0080cell36.setCellValue(record.getR0080_before_resident_government().doubleValue());
						R0080cell36.setCellStyle(numberStyle);
					} else {
						R0080cell36.setCellValue("");
						R0080cell36.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AL
					Cell R0080cell37 = row.createCell(37);
					if (record.getR0080_after_resident_government() != null) {
						R0080cell37.setCellValue(record.getR0080_after_resident_government().doubleValue());
						R0080cell37.setCellStyle(numberStyle);
					} else {
						R0080cell37.setCellValue("");
						R0080cell37.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AM
					Cell R0080cell38 = row.createCell(38);
					if (record.getR0080_before_nonresident_government() != null) {
						R0080cell38.setCellValue(record.getR0080_before_nonresident_government().doubleValue());
						R0080cell38.setCellStyle(numberStyle);
					} else {
						R0080cell38.setCellValue("");
						R0080cell38.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AN
					Cell R0080cell39 = row.createCell(39);
					if (record.getR0080_after_nonresident_government() != null) {
						R0080cell39.setCellValue(record.getR0080_after_nonresident_government().doubleValue());
						R0080cell39.setCellStyle(numberStyle);
					} else {
						R0080cell39.setCellValue("");
						R0080cell39.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column E
					row = sheet.getRow(18);
					Cell R0090cell4 = row.createCell(4);
					if (record.getR0090_before_resident_individual() != null) {
						R0090cell4.setCellValue(record.getR0090_before_resident_individual().doubleValue());
						R0090cell4.setCellStyle(numberStyle);
					} else {
						R0090cell4.setCellValue("");
						R0090cell4.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column F
					Cell R0090cell5 = row.createCell(5);
					if (record.getR0090_after_resident_individual() != null) {
						R0090cell5.setCellValue(record.getR0090_after_resident_individual().doubleValue());
						R0090cell5.setCellStyle(numberStyle);
					} else {
						R0090cell5.setCellValue("");
						R0090cell5.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column G
					Cell R0090cell6 = row.createCell(6);
					if (record.getR0090_before_nonresident_individual() != null) {
						R0090cell6.setCellValue(record.getR0090_before_nonresident_individual().doubleValue());
						R0090cell6.setCellStyle(numberStyle);
					} else {
						R0090cell6.setCellValue("");
						R0090cell6.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column H
					Cell R0090cell7 = row.createCell(7);
					if (record.getR0090_after_nonresident_individual() != null) {
						R0090cell7.setCellValue(record.getR0090_after_nonresident_individual().doubleValue());
						R0090cell7.setCellStyle(numberStyle);
					} else {
						R0090cell7.setCellValue("");
						R0090cell7.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column I
					Cell R0090cell8 = row.createCell(8);
					if (record.getR0090_before_resident_retail() != null) {
						R0090cell8.setCellValue(record.getR0090_before_resident_retail().doubleValue());
						R0090cell8.setCellStyle(numberStyle);
					} else {
						R0090cell8.setCellValue("");
						R0090cell8.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column J
					Cell R0090cell9 = row.createCell(9);
					if (record.getR0090_after_resident_retail() != null) {
						R0090cell9.setCellValue(record.getR0090_after_resident_retail().doubleValue());
						R0090cell9.setCellStyle(numberStyle);
					} else {
						R0090cell9.setCellValue("");
						R0090cell9.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column K
					Cell R0090cell10 = row.createCell(10);
					if (record.getR0090_before_nonresident_retail() != null) {
						R0090cell10.setCellValue(record.getR0090_before_nonresident_retail().doubleValue());
						R0090cell10.setCellStyle(numberStyle);
					} else {
						R0090cell10.setCellValue("");
						R0090cell10.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column L
					Cell R0090cell11 = row.createCell(11);
					if (record.getR0090_after_nonresident_retail() != null) {
						R0090cell11.setCellValue(record.getR0090_after_nonresident_retail().doubleValue());
						R0090cell11.setCellStyle(numberStyle);
					} else {
						R0090cell11.setCellValue("");
						R0090cell11.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column M
					Cell R0090cell12 = row.createCell(12);
					if (record.getR0090_before_resident_sme() != null) {
						R0090cell12.setCellValue(record.getR0090_before_resident_sme().doubleValue());
						R0090cell12.setCellStyle(numberStyle);
					} else {
						R0090cell12.setCellValue("");
						R0090cell12.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column N
					Cell R0090cell13 = row.createCell(13);
					if (record.getR0090_after_resident_sme() != null) {
						R0090cell13.setCellValue(record.getR0090_after_resident_sme().doubleValue());
						R0090cell13.setCellStyle(numberStyle);
					} else {
						R0090cell13.setCellValue("");
						R0090cell13.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column O
					Cell R0090cell14 = row.createCell(14);
					if (record.getR0090_before_nonresident_sme() != null) {
						R0090cell14.setCellValue(record.getR0090_before_nonresident_sme().doubleValue());
						R0090cell14.setCellStyle(numberStyle);
					} else {
						R0090cell14.setCellValue("");
						R0090cell14.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column P
					Cell R0090cell15 = row.createCell(15);
					if (record.getR0090_after_nonresident_sme() != null) {
						R0090cell15.setCellValue(record.getR0090_after_nonresident_sme().doubleValue());
						R0090cell15.setCellStyle(numberStyle);
					} else {
						R0090cell15.setCellValue("");
						R0090cell15.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column Q
					Cell R0090cell16 = row.createCell(16);
					if (record.getR0090_before_resident_hni() != null) {
						R0090cell16.setCellValue(record.getR0090_before_resident_hni().doubleValue());
						R0090cell16.setCellStyle(numberStyle);
					} else {
						R0090cell16.setCellValue("");
						R0090cell16.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column R
					Cell R0090cell17 = row.createCell(17);
					if (record.getR0090_after_resident_hni() != null) {
						R0090cell17.setCellValue(record.getR0090_after_resident_hni().doubleValue());
						R0090cell17.setCellStyle(numberStyle);
					} else {
						R0090cell17.setCellValue("");
						R0090cell17.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column S
					Cell R0090cell18 = row.createCell(18);
					if (record.getR0090_before_nonresident_hni() != null) {
						R0090cell18.setCellValue(record.getR0090_before_nonresident_hni().doubleValue());
						R0090cell18.setCellStyle(numberStyle);
					} else {
						R0090cell18.setCellValue("");
						R0090cell18.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column T
					Cell R0090cell19 = row.createCell(19);
					if (record.getR0090_after_nonresident_hni() != null) {
						R0090cell19.setCellValue(record.getR0090_after_nonresident_hni().doubleValue());
						R0090cell19.setCellStyle(numberStyle);
					} else {
						R0090cell19.setCellValue("");
						R0090cell19.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column U
					Cell R0090cell20 = row.createCell(20);
					if (record.getR0090_before_resident_gre() != null) {
						R0090cell20.setCellValue(record.getR0090_before_resident_gre().doubleValue());
						R0090cell20.setCellStyle(numberStyle);
					} else {
						R0090cell20.setCellValue("");
						R0090cell20.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column V
					Cell R0090cell21 = row.createCell(21);
					if (record.getR0090_after_resident_gre() != null) {
						R0090cell21.setCellValue(record.getR0090_after_resident_gre().doubleValue());
						R0090cell21.setCellStyle(numberStyle);
					} else {
						R0090cell21.setCellValue("");
						R0090cell21.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column W
					Cell R0090cell22 = row.createCell(22);
					if (record.getR0090_before_nonresident_gre() != null) {
						R0090cell22.setCellValue(record.getR0090_before_nonresident_gre().doubleValue());
						R0090cell22.setCellStyle(numberStyle);
					} else {
						R0090cell22.setCellValue("");
						R0090cell22.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column X
					Cell R0090cell23 = row.createCell(23);
					if (record.getR0090_after_nonresident_gre() != null) {
						R0090cell23.setCellValue(record.getR0090_after_nonresident_gre().doubleValue());
						R0090cell23.setCellStyle(numberStyle);
					} else {
						R0090cell23.setCellValue("");
						R0090cell23.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column Y
					Cell R0090cell24 = row.createCell(24);
					if (record.getR0090_before_resident_corporate() != null) {
						R0090cell24.setCellValue(record.getR0090_before_resident_corporate().doubleValue());
						R0090cell24.setCellStyle(numberStyle);
					} else {
						R0090cell24.setCellValue("");
						R0090cell24.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column Z
					Cell R0090cell25 = row.createCell(25);
					if (record.getR0090_after_resident_corporate() != null) {
						R0090cell25.setCellValue(record.getR0090_after_resident_corporate().doubleValue());
						R0090cell25.setCellStyle(numberStyle);
					} else {
						R0090cell25.setCellValue("");
						R0090cell25.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AA
					Cell R0090cell26 = row.createCell(26);
					if (record.getR0090_before_nonresident_corporate() != null) {
						R0090cell26.setCellValue(record.getR0090_before_nonresident_corporate().doubleValue());
						R0090cell26.setCellStyle(numberStyle);
					} else {
						R0090cell26.setCellValue("");
						R0090cell26.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AB
					Cell R0090cell27 = row.createCell(27);
					if (record.getR0090_after_nonresident_corporate() != null) {
						R0090cell27.setCellValue(record.getR0090_after_nonresident_corporate().doubleValue());
						R0090cell27.setCellStyle(numberStyle);
					} else {
						R0090cell27.setCellValue("");
						R0090cell27.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AC
					Cell R0090cell28 = row.createCell(28);
					if (record.getR0090_before_resident_nbfi() != null) {
						R0090cell28.setCellValue(record.getR0090_before_resident_nbfi().doubleValue());
						R0090cell28.setCellStyle(numberStyle);
					} else {
						R0090cell28.setCellValue("");
						R0090cell28.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AD
					Cell R0090cell29 = row.createCell(29);
					if (record.getR0090_after_resident_nbfi() != null) {
						R0090cell29.setCellValue(record.getR0090_after_resident_nbfi().doubleValue());
						R0090cell29.setCellStyle(numberStyle);
					} else {
						R0090cell29.setCellValue("");
						R0090cell29.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AE
					Cell R0090cell30 = row.createCell(30);
					if (record.getR0090_before_nonresident_nbfi() != null) {
						R0090cell30.setCellValue(record.getR0090_before_nonresident_nbfi().doubleValue());
						R0090cell30.setCellStyle(numberStyle);
					} else {
						R0090cell30.setCellValue("");
						R0090cell30.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AF
					Cell R0090cell31 = row.createCell(31);
					if (record.getR0090_after_nonresident_nbfi() != null) {
						R0090cell31.setCellValue(record.getR0090_after_nonresident_nbfi().doubleValue());
						R0090cell31.setCellStyle(numberStyle);
					} else {
						R0090cell31.setCellValue("");
						R0090cell31.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AG
					Cell R0090cell32 = row.createCell(32);
					if (record.getR0090_before_resident_bank() != null) {
						R0090cell32.setCellValue(record.getR0090_before_resident_bank().doubleValue());
						R0090cell32.setCellStyle(numberStyle);
					} else {
						R0090cell32.setCellValue("");
						R0090cell32.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AH
					Cell R0090cell33 = row.createCell(33);
					if (record.getR0090_after_resident_bank() != null) {
						R0090cell33.setCellValue(record.getR0090_after_resident_bank().doubleValue());
						R0090cell33.setCellStyle(numberStyle);
					} else {
						R0090cell33.setCellValue("");
						R0090cell33.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AI
					Cell R0090cell34 = row.createCell(34);
					if (record.getR0090_before_nonresident_bank() != null) {
						R0090cell34.setCellValue(record.getR0090_before_nonresident_bank().doubleValue());
						R0090cell34.setCellStyle(numberStyle);
					} else {
						R0090cell34.setCellValue("");
						R0090cell34.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AJ
					Cell R0090cell35 = row.createCell(35);
					if (record.getR0090_after_nonresident_bank() != null) {
						R0090cell35.setCellValue(record.getR0090_after_nonresident_bank().doubleValue());
						R0090cell35.setCellStyle(numberStyle);
					} else {
						R0090cell35.setCellValue("");
						R0090cell35.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AK
					Cell R0090cell36 = row.createCell(36);
					if (record.getR0090_before_resident_government() != null) {
						R0090cell36.setCellValue(record.getR0090_before_resident_government().doubleValue());
						R0090cell36.setCellStyle(numberStyle);
					} else {
						R0090cell36.setCellValue("");
						R0090cell36.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AL
					Cell R0090cell37 = row.createCell(37);
					if (record.getR0090_after_resident_government() != null) {
						R0090cell37.setCellValue(record.getR0090_after_resident_government().doubleValue());
						R0090cell37.setCellStyle(numberStyle);
					} else {
						R0090cell37.setCellValue("");
						R0090cell37.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AM
					Cell R0090cell38 = row.createCell(38);
					if (record.getR0090_before_nonresident_government() != null) {
						R0090cell38.setCellValue(record.getR0090_before_nonresident_government().doubleValue());
						R0090cell38.setCellStyle(numberStyle);
					} else {
						R0090cell38.setCellValue("");
						R0090cell38.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AN
					Cell R0090cell39 = row.createCell(39);
					if (record.getR0090_after_nonresident_government() != null) {
						R0090cell39.setCellValue(record.getR0090_after_nonresident_government().doubleValue());
						R0090cell39.setCellStyle(numberStyle);
					} else {
						R0090cell39.setCellValue("");
						R0090cell39.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column E
					row = sheet.getRow(20);
					Cell R0110cell4 = row.createCell(4);
					if (record.getR0110_before_resident_individual() != null) {
						R0110cell4.setCellValue(record.getR0110_before_resident_individual().doubleValue());
						R0110cell4.setCellStyle(numberStyle);
					} else {
						R0110cell4.setCellValue("");
						R0110cell4.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column F
					Cell R0110cell5 = row.createCell(5);
					if (record.getR0110_after_resident_individual() != null) {
						R0110cell5.setCellValue(record.getR0110_after_resident_individual().doubleValue());
						R0110cell5.setCellStyle(numberStyle);
					} else {
						R0110cell5.setCellValue("");
						R0110cell5.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column G
					Cell R0110cell6 = row.createCell(6);
					if (record.getR0110_before_nonresident_individual() != null) {
						R0110cell6.setCellValue(record.getR0110_before_nonresident_individual().doubleValue());
						R0110cell6.setCellStyle(numberStyle);
					} else {
						R0110cell6.setCellValue("");
						R0110cell6.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column H
					Cell R0110cell7 = row.createCell(7);
					if (record.getR0110_after_nonresident_individual() != null) {
						R0110cell7.setCellValue(record.getR0110_after_nonresident_individual().doubleValue());
						R0110cell7.setCellStyle(numberStyle);
					} else {
						R0110cell7.setCellValue("");
						R0110cell7.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column I
					Cell R0110cell8 = row.createCell(8);
					if (record.getR0110_before_resident_retail() != null) {
						R0110cell8.setCellValue(record.getR0110_before_resident_retail().doubleValue());
						R0110cell8.setCellStyle(numberStyle);
					} else {
						R0110cell8.setCellValue("");
						R0110cell8.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column J
					Cell R0110cell9 = row.createCell(9);
					if (record.getR0110_after_resident_retail() != null) {
						R0110cell9.setCellValue(record.getR0110_after_resident_retail().doubleValue());
						R0110cell9.setCellStyle(numberStyle);
					} else {
						R0110cell9.setCellValue("");
						R0110cell9.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column K
					Cell R0110cell10 = row.createCell(10);
					if (record.getR0110_before_nonresident_retail() != null) {
						R0110cell10.setCellValue(record.getR0110_before_nonresident_retail().doubleValue());
						R0110cell10.setCellStyle(numberStyle);
					} else {
						R0110cell10.setCellValue("");
						R0110cell10.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column L
					Cell R0110cell11 = row.createCell(11);
					if (record.getR0110_after_nonresident_retail() != null) {
						R0110cell11.setCellValue(record.getR0110_after_nonresident_retail().doubleValue());
						R0110cell11.setCellStyle(numberStyle);
					} else {
						R0110cell11.setCellValue("");
						R0110cell11.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column M
					Cell R0110cell12 = row.createCell(12);
					if (record.getR0110_before_resident_sme() != null) {
						R0110cell12.setCellValue(record.getR0110_before_resident_sme().doubleValue());
						R0110cell12.setCellStyle(numberStyle);
					} else {
						R0110cell12.setCellValue("");
						R0110cell12.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column N
					Cell R0110cell13 = row.createCell(13);
					if (record.getR0110_after_resident_sme() != null) {
						R0110cell13.setCellValue(record.getR0110_after_resident_sme().doubleValue());
						R0110cell13.setCellStyle(numberStyle);
					} else {
						R0110cell13.setCellValue("");
						R0110cell13.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column O
					Cell R0110cell14 = row.createCell(14);
					if (record.getR0110_before_nonresident_sme() != null) {
						R0110cell14.setCellValue(record.getR0110_before_nonresident_sme().doubleValue());
						R0110cell14.setCellStyle(numberStyle);
					} else {
						R0110cell14.setCellValue("");
						R0110cell14.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column P
					Cell R0110cell15 = row.createCell(15);
					if (record.getR0110_after_nonresident_sme() != null) {
						R0110cell15.setCellValue(record.getR0110_after_nonresident_sme().doubleValue());
						R0110cell15.setCellStyle(numberStyle);
					} else {
						R0110cell15.setCellValue("");
						R0110cell15.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column Q
					Cell R0110cell16 = row.createCell(16);
					if (record.getR0110_before_resident_hni() != null) {
						R0110cell16.setCellValue(record.getR0110_before_resident_hni().doubleValue());
						R0110cell16.setCellStyle(numberStyle);
					} else {
						R0110cell16.setCellValue("");
						R0110cell16.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column R
					Cell R0110cell17 = row.createCell(17);
					if (record.getR0110_after_resident_hni() != null) {
						R0110cell17.setCellValue(record.getR0110_after_resident_hni().doubleValue());
						R0110cell17.setCellStyle(numberStyle);
					} else {
						R0110cell17.setCellValue("");
						R0110cell17.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column S
					Cell R0110cell18 = row.createCell(18);
					if (record.getR0110_before_nonresident_hni() != null) {
						R0110cell18.setCellValue(record.getR0110_before_nonresident_hni().doubleValue());
						R0110cell18.setCellStyle(numberStyle);
					} else {
						R0110cell18.setCellValue("");
						R0110cell18.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column T
					Cell R0110cell19 = row.createCell(19);
					if (record.getR0110_after_nonresident_hni() != null) {
						R0110cell19.setCellValue(record.getR0110_after_nonresident_hni().doubleValue());
						R0110cell19.setCellStyle(numberStyle);
					} else {
						R0110cell19.setCellValue("");
						R0110cell19.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column U
					Cell R0110cell20 = row.createCell(20);
					if (record.getR0110_before_resident_gre() != null) {
						R0110cell20.setCellValue(record.getR0110_before_resident_gre().doubleValue());
						R0110cell20.setCellStyle(numberStyle);
					} else {
						R0110cell20.setCellValue("");
						R0110cell20.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column V
					Cell R0110cell21 = row.createCell(21);
					if (record.getR0110_after_resident_gre() != null) {
						R0110cell21.setCellValue(record.getR0110_after_resident_gre().doubleValue());
						R0110cell21.setCellStyle(numberStyle);
					} else {
						R0110cell21.setCellValue("");
						R0110cell21.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column W
					Cell R0110cell22 = row.createCell(22);
					if (record.getR0110_before_nonresident_gre() != null) {
						R0110cell22.setCellValue(record.getR0110_before_nonresident_gre().doubleValue());
						R0110cell22.setCellStyle(numberStyle);
					} else {
						R0110cell22.setCellValue("");
						R0110cell22.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column X
					Cell R0110cell23 = row.createCell(23);
					if (record.getR0110_after_nonresident_gre() != null) {
						R0110cell23.setCellValue(record.getR0110_after_nonresident_gre().doubleValue());
						R0110cell23.setCellStyle(numberStyle);
					} else {
						R0110cell23.setCellValue("");
						R0110cell23.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column Y
					Cell R0110cell24 = row.createCell(24);
					if (record.getR0110_before_resident_corporate() != null) {
						R0110cell24.setCellValue(record.getR0110_before_resident_corporate().doubleValue());
						R0110cell24.setCellStyle(numberStyle);
					} else {
						R0110cell24.setCellValue("");
						R0110cell24.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column Z
					Cell R0110cell25 = row.createCell(25);
					if (record.getR0110_after_resident_corporate() != null) {
						R0110cell25.setCellValue(record.getR0110_after_resident_corporate().doubleValue());
						R0110cell25.setCellStyle(numberStyle);
					} else {
						R0110cell25.setCellValue("");
						R0110cell25.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AA
					Cell R0110cell26 = row.createCell(26);
					if (record.getR0110_before_nonresident_corporate() != null) {
						R0110cell26.setCellValue(record.getR0110_before_nonresident_corporate().doubleValue());
						R0110cell26.setCellStyle(numberStyle);
					} else {
						R0110cell26.setCellValue("");
						R0110cell26.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AB
					Cell R0110cell27 = row.createCell(27);
					if (record.getR0110_after_nonresident_corporate() != null) {
						R0110cell27.setCellValue(record.getR0110_after_nonresident_corporate().doubleValue());
						R0110cell27.setCellStyle(numberStyle);
					} else {
						R0110cell27.setCellValue("");
						R0110cell27.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AC
					Cell R0110cell28 = row.createCell(28);
					if (record.getR0110_before_resident_nbfi() != null) {
						R0110cell28.setCellValue(record.getR0110_before_resident_nbfi().doubleValue());
						R0110cell28.setCellStyle(numberStyle);
					} else {
						R0110cell28.setCellValue("");
						R0110cell28.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AD
					Cell R0110cell29 = row.createCell(29);
					if (record.getR0110_after_resident_nbfi() != null) {
						R0110cell29.setCellValue(record.getR0110_after_resident_nbfi().doubleValue());
						R0110cell29.setCellStyle(numberStyle);
					} else {
						R0110cell29.setCellValue("");
						R0110cell29.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AE
					Cell R0110cell30 = row.createCell(30);
					if (record.getR0110_before_nonresident_nbfi() != null) {
						R0110cell30.setCellValue(record.getR0110_before_nonresident_nbfi().doubleValue());
						R0110cell30.setCellStyle(numberStyle);
					} else {
						R0110cell30.setCellValue("");
						R0110cell30.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AF
					Cell R0110cell31 = row.createCell(31);
					if (record.getR0110_after_nonresident_nbfi() != null) {
						R0110cell31.setCellValue(record.getR0110_after_nonresident_nbfi().doubleValue());
						R0110cell31.setCellStyle(numberStyle);
					} else {
						R0110cell31.setCellValue("");
						R0110cell31.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AG
					Cell R0110cell32 = row.createCell(32);
					if (record.getR0110_before_resident_bank() != null) {
						R0110cell32.setCellValue(record.getR0110_before_resident_bank().doubleValue());
						R0110cell32.setCellStyle(numberStyle);
					} else {
						R0110cell32.setCellValue("");
						R0110cell32.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AH
					Cell R0110cell33 = row.createCell(33);
					if (record.getR0110_after_resident_bank() != null) {
						R0110cell33.setCellValue(record.getR0110_after_resident_bank().doubleValue());
						R0110cell33.setCellStyle(numberStyle);
					} else {
						R0110cell33.setCellValue("");
						R0110cell33.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AI
					Cell R0110cell34 = row.createCell(34);
					if (record.getR0110_before_nonresident_bank() != null) {
						R0110cell34.setCellValue(record.getR0110_before_nonresident_bank().doubleValue());
						R0110cell34.setCellStyle(numberStyle);
					} else {
						R0110cell34.setCellValue("");
						R0110cell34.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AJ
					Cell R0110cell35 = row.createCell(35);
					if (record.getR0110_after_nonresident_bank() != null) {
						R0110cell35.setCellValue(record.getR0110_after_nonresident_bank().doubleValue());
						R0110cell35.setCellStyle(numberStyle);
					} else {
						R0110cell35.setCellValue("");
						R0110cell35.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AK
					Cell R0110cell36 = row.createCell(36);
					if (record.getR0110_before_resident_government() != null) {
						R0110cell36.setCellValue(record.getR0110_before_resident_government().doubleValue());
						R0110cell36.setCellStyle(numberStyle);
					} else {
						R0110cell36.setCellValue("");
						R0110cell36.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AL
					Cell R0110cell37 = row.createCell(37);
					if (record.getR0110_after_resident_government() != null) {
						R0110cell37.setCellValue(record.getR0110_after_resident_government().doubleValue());
						R0110cell37.setCellStyle(numberStyle);
					} else {
						R0110cell37.setCellValue("");
						R0110cell37.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AM
					Cell R0110cell38 = row.createCell(38);
					if (record.getR0110_before_nonresident_government() != null) {
						R0110cell38.setCellValue(record.getR0110_before_nonresident_government().doubleValue());
						R0110cell38.setCellStyle(numberStyle);
					} else {
						R0110cell38.setCellValue("");
						R0110cell38.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AN
					Cell R0110cell39 = row.createCell(39);
					if (record.getR0110_after_nonresident_government() != null) {
						R0110cell39.setCellValue(record.getR0110_after_nonresident_government().doubleValue());
						R0110cell39.setCellStyle(numberStyle);
					} else {
						R0110cell39.setCellValue("");
						R0110cell39.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column E
					row = sheet.getRow(21);
					Cell R0120cell4 = row.createCell(4);
					if (record.getR0120_before_resident_individual() != null) {
						R0120cell4.setCellValue(record.getR0120_before_resident_individual().doubleValue());
						R0120cell4.setCellStyle(numberStyle);
					} else {
						R0120cell4.setCellValue("");
						R0120cell4.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column F
					Cell R0120cell5 = row.createCell(5);
					if (record.getR0120_after_resident_individual() != null) {
						R0120cell5.setCellValue(record.getR0120_after_resident_individual().doubleValue());
						R0120cell5.setCellStyle(numberStyle);
					} else {
						R0120cell5.setCellValue("");
						R0120cell5.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column G
					Cell R0120cell6 = row.createCell(6);
					if (record.getR0120_before_nonresident_individual() != null) {
						R0120cell6.setCellValue(record.getR0120_before_nonresident_individual().doubleValue());
						R0120cell6.setCellStyle(numberStyle);
					} else {
						R0120cell6.setCellValue("");
						R0120cell6.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column H
					Cell R0120cell7 = row.createCell(7);
					if (record.getR0120_after_nonresident_individual() != null) {
						R0120cell7.setCellValue(record.getR0120_after_nonresident_individual().doubleValue());
						R0120cell7.setCellStyle(numberStyle);
					} else {
						R0120cell7.setCellValue("");
						R0120cell7.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column I
					Cell R0120cell8 = row.createCell(8);
					if (record.getR0120_before_resident_retail() != null) {
						R0120cell8.setCellValue(record.getR0120_before_resident_retail().doubleValue());
						R0120cell8.setCellStyle(numberStyle);
					} else {
						R0120cell8.setCellValue("");
						R0120cell8.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column J
					Cell R0120cell9 = row.createCell(9);
					if (record.getR0120_after_resident_retail() != null) {
						R0120cell9.setCellValue(record.getR0120_after_resident_retail().doubleValue());
						R0120cell9.setCellStyle(numberStyle);
					} else {
						R0120cell9.setCellValue("");
						R0120cell9.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column K
					Cell R0120cell10 = row.createCell(10);
					if (record.getR0120_before_nonresident_retail() != null) {
						R0120cell10.setCellValue(record.getR0120_before_nonresident_retail().doubleValue());
						R0120cell10.setCellStyle(numberStyle);
					} else {
						R0120cell10.setCellValue("");
						R0120cell10.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column L
					Cell R0120cell11 = row.createCell(11);
					if (record.getR0120_after_nonresident_retail() != null) {
						R0120cell11.setCellValue(record.getR0120_after_nonresident_retail().doubleValue());
						R0120cell11.setCellStyle(numberStyle);
					} else {
						R0120cell11.setCellValue("");
						R0120cell11.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column M
					Cell R0120cell12 = row.createCell(12);
					if (record.getR0120_before_resident_sme() != null) {
						R0120cell12.setCellValue(record.getR0120_before_resident_sme().doubleValue());
						R0120cell12.setCellStyle(numberStyle);
					} else {
						R0120cell12.setCellValue("");
						R0120cell12.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column N
					Cell R0120cell13 = row.createCell(13);
					if (record.getR0120_after_resident_sme() != null) {
						R0120cell13.setCellValue(record.getR0120_after_resident_sme().doubleValue());
						R0120cell13.setCellStyle(numberStyle);
					} else {
						R0120cell13.setCellValue("");
						R0120cell13.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column O
					Cell R0120cell14 = row.createCell(14);
					if (record.getR0120_before_nonresident_sme() != null) {
						R0120cell14.setCellValue(record.getR0120_before_nonresident_sme().doubleValue());
						R0120cell14.setCellStyle(numberStyle);
					} else {
						R0120cell14.setCellValue("");
						R0120cell14.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column P
					Cell R0120cell15 = row.createCell(15);
					if (record.getR0120_after_nonresident_sme() != null) {
						R0120cell15.setCellValue(record.getR0120_after_nonresident_sme().doubleValue());
						R0120cell15.setCellStyle(numberStyle);
					} else {
						R0120cell15.setCellValue("");
						R0120cell15.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column Q
					Cell R0120cell16 = row.createCell(16);
					if (record.getR0120_before_resident_hni() != null) {
						R0120cell16.setCellValue(record.getR0120_before_resident_hni().doubleValue());
						R0120cell16.setCellStyle(numberStyle);
					} else {
						R0120cell16.setCellValue("");
						R0120cell16.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column R
					Cell R0120cell17 = row.createCell(17);
					if (record.getR0120_after_resident_hni() != null) {
						R0120cell17.setCellValue(record.getR0120_after_resident_hni().doubleValue());
						R0120cell17.setCellStyle(numberStyle);
					} else {
						R0120cell17.setCellValue("");
						R0120cell17.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column S
					Cell R0120cell18 = row.createCell(18);
					if (record.getR0120_before_nonresident_hni() != null) {
						R0120cell18.setCellValue(record.getR0120_before_nonresident_hni().doubleValue());
						R0120cell18.setCellStyle(numberStyle);
					} else {
						R0120cell18.setCellValue("");
						R0120cell18.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column T
					Cell R0120cell19 = row.createCell(19);
					if (record.getR0120_after_nonresident_hni() != null) {
						R0120cell19.setCellValue(record.getR0120_after_nonresident_hni().doubleValue());
						R0120cell19.setCellStyle(numberStyle);
					} else {
						R0120cell19.setCellValue("");
						R0120cell19.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column U
					Cell R0120cell20 = row.createCell(20);
					if (record.getR0120_before_resident_gre() != null) {
						R0120cell20.setCellValue(record.getR0120_before_resident_gre().doubleValue());
						R0120cell20.setCellStyle(numberStyle);
					} else {
						R0120cell20.setCellValue("");
						R0120cell20.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column V
					Cell R0120cell21 = row.createCell(21);
					if (record.getR0120_after_resident_gre() != null) {
						R0120cell21.setCellValue(record.getR0120_after_resident_gre().doubleValue());
						R0120cell21.setCellStyle(numberStyle);
					} else {
						R0120cell21.setCellValue("");
						R0120cell21.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column W
					Cell R0120cell22 = row.createCell(22);
					if (record.getR0120_before_nonresident_gre() != null) {
						R0120cell22.setCellValue(record.getR0120_before_nonresident_gre().doubleValue());
						R0120cell22.setCellStyle(numberStyle);
					} else {
						R0120cell22.setCellValue("");
						R0120cell22.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column X
					Cell R0120cell23 = row.createCell(23);
					if (record.getR0120_after_nonresident_gre() != null) {
						R0120cell23.setCellValue(record.getR0120_after_nonresident_gre().doubleValue());
						R0120cell23.setCellStyle(numberStyle);
					} else {
						R0120cell23.setCellValue("");
						R0120cell23.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column Y
					Cell R0120cell24 = row.createCell(24);
					if (record.getR0120_before_resident_corporate() != null) {
						R0120cell24.setCellValue(record.getR0120_before_resident_corporate().doubleValue());
						R0120cell24.setCellStyle(numberStyle);
					} else {
						R0120cell24.setCellValue("");
						R0120cell24.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column Z
					Cell R0120cell25 = row.createCell(25);
					if (record.getR0120_after_resident_corporate() != null) {
						R0120cell25.setCellValue(record.getR0120_after_resident_corporate().doubleValue());
						R0120cell25.setCellStyle(numberStyle);
					} else {
						R0120cell25.setCellValue("");
						R0120cell25.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AA
					Cell R0120cell26 = row.createCell(26);
					if (record.getR0120_before_nonresident_corporate() != null) {
						R0120cell26.setCellValue(record.getR0120_before_nonresident_corporate().doubleValue());
						R0120cell26.setCellStyle(numberStyle);
					} else {
						R0120cell26.setCellValue("");
						R0120cell26.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AB
					Cell R0120cell27 = row.createCell(27);
					if (record.getR0120_after_nonresident_corporate() != null) {
						R0120cell27.setCellValue(record.getR0120_after_nonresident_corporate().doubleValue());
						R0120cell27.setCellStyle(numberStyle);
					} else {
						R0120cell27.setCellValue("");
						R0120cell27.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AC
					Cell R0120cell28 = row.createCell(28);
					if (record.getR0120_before_resident_nbfi() != null) {
						R0120cell28.setCellValue(record.getR0120_before_resident_nbfi().doubleValue());
						R0120cell28.setCellStyle(numberStyle);
					} else {
						R0120cell28.setCellValue("");
						R0120cell28.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AD
					Cell R0120cell29 = row.createCell(29);
					if (record.getR0120_after_resident_nbfi() != null) {
						R0120cell29.setCellValue(record.getR0120_after_resident_nbfi().doubleValue());
						R0120cell29.setCellStyle(numberStyle);
					} else {
						R0120cell29.setCellValue("");
						R0120cell29.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AE
					Cell R0120cell30 = row.createCell(30);
					if (record.getR0120_before_nonresident_nbfi() != null) {
						R0120cell30.setCellValue(record.getR0120_before_nonresident_nbfi().doubleValue());
						R0120cell30.setCellStyle(numberStyle);
					} else {
						R0120cell30.setCellValue("");
						R0120cell30.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AF
					Cell R0120cell31 = row.createCell(31);
					if (record.getR0120_after_nonresident_nbfi() != null) {
						R0120cell31.setCellValue(record.getR0120_after_nonresident_nbfi().doubleValue());
						R0120cell31.setCellStyle(numberStyle);
					} else {
						R0120cell31.setCellValue("");
						R0120cell31.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AG
					Cell R0120cell32 = row.createCell(32);
					if (record.getR0120_before_resident_bank() != null) {
						R0120cell32.setCellValue(record.getR0120_before_resident_bank().doubleValue());
						R0120cell32.setCellStyle(numberStyle);
					} else {
						R0120cell32.setCellValue("");
						R0120cell32.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AH
					Cell R0120cell33 = row.createCell(33);
					if (record.getR0120_after_resident_bank() != null) {
						R0120cell33.setCellValue(record.getR0120_after_resident_bank().doubleValue());
						R0120cell33.setCellStyle(numberStyle);
					} else {
						R0120cell33.setCellValue("");
						R0120cell33.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AI
					Cell R0120cell34 = row.createCell(34);
					if (record.getR0120_before_nonresident_bank() != null) {
						R0120cell34.setCellValue(record.getR0120_before_nonresident_bank().doubleValue());
						R0120cell34.setCellStyle(numberStyle);
					} else {
						R0120cell34.setCellValue("");
						R0120cell34.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AJ
					Cell R0120cell35 = row.createCell(35);
					if (record.getR0120_after_nonresident_bank() != null) {
						R0120cell35.setCellValue(record.getR0120_after_nonresident_bank().doubleValue());
						R0120cell35.setCellStyle(numberStyle);
					} else {
						R0120cell35.setCellValue("");
						R0120cell35.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AK
					Cell R0120cell36 = row.createCell(36);
					if (record.getR0120_before_resident_government() != null) {
						R0120cell36.setCellValue(record.getR0120_before_resident_government().doubleValue());
						R0120cell36.setCellStyle(numberStyle);
					} else {
						R0120cell36.setCellValue("");
						R0120cell36.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AL
					Cell R0120cell37 = row.createCell(37);
					if (record.getR0120_after_resident_government() != null) {
						R0120cell37.setCellValue(record.getR0120_after_resident_government().doubleValue());
						R0120cell37.setCellStyle(numberStyle);
					} else {
						R0120cell37.setCellValue("");
						R0120cell37.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AM
					Cell R0120cell38 = row.createCell(38);
					if (record.getR0120_before_nonresident_government() != null) {
						R0120cell38.setCellValue(record.getR0120_before_nonresident_government().doubleValue());
						R0120cell38.setCellStyle(numberStyle);
					} else {
						R0120cell38.setCellValue("");
						R0120cell38.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AN
					Cell R0120cell39 = row.createCell(39);
					if (record.getR0120_after_nonresident_government() != null) {
						R0120cell39.setCellValue(record.getR0120_after_nonresident_government().doubleValue());
						R0120cell39.setCellStyle(numberStyle);
					} else {
						R0120cell39.setCellValue("");
						R0120cell39.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column E
					row = sheet.getRow(22);
					Cell R0130cell4 = row.createCell(4);
					if (record.getR0130_before_resident_individual() != null) {
						R0130cell4.setCellValue(record.getR0130_before_resident_individual().doubleValue());
						R0130cell4.setCellStyle(numberStyle);
					} else {
						R0130cell4.setCellValue("");
						R0130cell4.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column F
					Cell R0130cell5 = row.createCell(5);
					if (record.getR0130_after_resident_individual() != null) {
						R0130cell5.setCellValue(record.getR0130_after_resident_individual().doubleValue());
						R0130cell5.setCellStyle(numberStyle);
					} else {
						R0130cell5.setCellValue("");
						R0130cell5.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column G
					Cell R0130cell6 = row.createCell(6);
					if (record.getR0130_before_nonresident_individual() != null) {
						R0130cell6.setCellValue(record.getR0130_before_nonresident_individual().doubleValue());
						R0130cell6.setCellStyle(numberStyle);
					} else {
						R0130cell6.setCellValue("");
						R0130cell6.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column H
					Cell R0130cell7 = row.createCell(7);
					if (record.getR0130_after_nonresident_individual() != null) {
						R0130cell7.setCellValue(record.getR0130_after_nonresident_individual().doubleValue());
						R0130cell7.setCellStyle(numberStyle);
					} else {
						R0130cell7.setCellValue("");
						R0130cell7.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column I
					Cell R0130cell8 = row.createCell(8);
					if (record.getR0130_before_resident_retail() != null) {
						R0130cell8.setCellValue(record.getR0130_before_resident_retail().doubleValue());
						R0130cell8.setCellStyle(numberStyle);
					} else {
						R0130cell8.setCellValue("");
						R0130cell8.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column J
					Cell R0130cell9 = row.createCell(9);
					if (record.getR0130_after_resident_retail() != null) {
						R0130cell9.setCellValue(record.getR0130_after_resident_retail().doubleValue());
						R0130cell9.setCellStyle(numberStyle);
					} else {
						R0130cell9.setCellValue("");
						R0130cell9.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column K
					Cell R0130cell10 = row.createCell(10);
					if (record.getR0130_before_nonresident_retail() != null) {
						R0130cell10.setCellValue(record.getR0130_before_nonresident_retail().doubleValue());
						R0130cell10.setCellStyle(numberStyle);
					} else {
						R0130cell10.setCellValue("");
						R0130cell10.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column L
					Cell R0130cell11 = row.createCell(11);
					if (record.getR0130_after_nonresident_retail() != null) {
						R0130cell11.setCellValue(record.getR0130_after_nonresident_retail().doubleValue());
						R0130cell11.setCellStyle(numberStyle);
					} else {
						R0130cell11.setCellValue("");
						R0130cell11.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column M
					Cell R0130cell12 = row.createCell(12);
					if (record.getR0130_before_resident_sme() != null) {
						R0130cell12.setCellValue(record.getR0130_before_resident_sme().doubleValue());
						R0130cell12.setCellStyle(numberStyle);
					} else {
						R0130cell12.setCellValue("");
						R0130cell12.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column N
					Cell R0130cell13 = row.createCell(13);
					if (record.getR0130_after_resident_sme() != null) {
						R0130cell13.setCellValue(record.getR0130_after_resident_sme().doubleValue());
						R0130cell13.setCellStyle(numberStyle);
					} else {
						R0130cell13.setCellValue("");
						R0130cell13.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column O
					Cell R0130cell14 = row.createCell(14);
					if (record.getR0130_before_nonresident_sme() != null) {
						R0130cell14.setCellValue(record.getR0130_before_nonresident_sme().doubleValue());
						R0130cell14.setCellStyle(numberStyle);
					} else {
						R0130cell14.setCellValue("");
						R0130cell14.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column P
					Cell R0130cell15 = row.createCell(15);
					if (record.getR0130_after_nonresident_sme() != null) {
						R0130cell15.setCellValue(record.getR0130_after_nonresident_sme().doubleValue());
						R0130cell15.setCellStyle(numberStyle);
					} else {
						R0130cell15.setCellValue("");
						R0130cell15.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column Q
					Cell R0130cell16 = row.createCell(16);
					if (record.getR0130_before_resident_hni() != null) {
						R0130cell16.setCellValue(record.getR0130_before_resident_hni().doubleValue());
						R0130cell16.setCellStyle(numberStyle);
					} else {
						R0130cell16.setCellValue("");
						R0130cell16.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column R
					Cell R0130cell17 = row.createCell(17);
					if (record.getR0130_after_resident_hni() != null) {
						R0130cell17.setCellValue(record.getR0130_after_resident_hni().doubleValue());
						R0130cell17.setCellStyle(numberStyle);
					} else {
						R0130cell17.setCellValue("");
						R0130cell17.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column S
					Cell R0130cell18 = row.createCell(18);
					if (record.getR0130_before_nonresident_hni() != null) {
						R0130cell18.setCellValue(record.getR0130_before_nonresident_hni().doubleValue());
						R0130cell18.setCellStyle(numberStyle);
					} else {
						R0130cell18.setCellValue("");
						R0130cell18.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column T
					Cell R0130cell19 = row.createCell(19);
					if (record.getR0130_after_nonresident_hni() != null) {
						R0130cell19.setCellValue(record.getR0130_after_nonresident_hni().doubleValue());
						R0130cell19.setCellStyle(numberStyle);
					} else {
						R0130cell19.setCellValue("");
						R0130cell19.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column U
					Cell R0130cell20 = row.createCell(20);
					if (record.getR0130_before_resident_gre() != null) {
						R0130cell20.setCellValue(record.getR0130_before_resident_gre().doubleValue());
						R0130cell20.setCellStyle(numberStyle);
					} else {
						R0130cell20.setCellValue("");
						R0130cell20.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column V
					Cell R0130cell21 = row.createCell(21);
					if (record.getR0130_after_resident_gre() != null) {
						R0130cell21.setCellValue(record.getR0130_after_resident_gre().doubleValue());
						R0130cell21.setCellStyle(numberStyle);
					} else {
						R0130cell21.setCellValue("");
						R0130cell21.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column W
					Cell R0130cell22 = row.createCell(22);
					if (record.getR0130_before_nonresident_gre() != null) {
						R0130cell22.setCellValue(record.getR0130_before_nonresident_gre().doubleValue());
						R0130cell22.setCellStyle(numberStyle);
					} else {
						R0130cell22.setCellValue("");
						R0130cell22.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column X
					Cell R0130cell23 = row.createCell(23);
					if (record.getR0130_after_nonresident_gre() != null) {
						R0130cell23.setCellValue(record.getR0130_after_nonresident_gre().doubleValue());
						R0130cell23.setCellStyle(numberStyle);
					} else {
						R0130cell23.setCellValue("");
						R0130cell23.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column Y
					Cell R0130cell24 = row.createCell(24);
					if (record.getR0130_before_resident_corporate() != null) {
						R0130cell24.setCellValue(record.getR0130_before_resident_corporate().doubleValue());
						R0130cell24.setCellStyle(numberStyle);
					} else {
						R0130cell24.setCellValue("");
						R0130cell24.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column Z
					Cell R0130cell25 = row.createCell(25);
					if (record.getR0130_after_resident_corporate() != null) {
						R0130cell25.setCellValue(record.getR0130_after_resident_corporate().doubleValue());
						R0130cell25.setCellStyle(numberStyle);
					} else {
						R0130cell25.setCellValue("");
						R0130cell25.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AA
					Cell R0130cell26 = row.createCell(26);
					if (record.getR0130_before_nonresident_corporate() != null) {
						R0130cell26.setCellValue(record.getR0130_before_nonresident_corporate().doubleValue());
						R0130cell26.setCellStyle(numberStyle);
					} else {
						R0130cell26.setCellValue("");
						R0130cell26.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AB
					Cell R0130cell27 = row.createCell(27);
					if (record.getR0130_after_nonresident_corporate() != null) {
						R0130cell27.setCellValue(record.getR0130_after_nonresident_corporate().doubleValue());
						R0130cell27.setCellStyle(numberStyle);
					} else {
						R0130cell27.setCellValue("");
						R0130cell27.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AC
					Cell R0130cell28 = row.createCell(28);
					if (record.getR0130_before_resident_nbfi() != null) {
						R0130cell28.setCellValue(record.getR0130_before_resident_nbfi().doubleValue());
						R0130cell28.setCellStyle(numberStyle);
					} else {
						R0130cell28.setCellValue("");
						R0130cell28.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AD
					Cell R0130cell29 = row.createCell(29);
					if (record.getR0130_after_resident_nbfi() != null) {
						R0130cell29.setCellValue(record.getR0130_after_resident_nbfi().doubleValue());
						R0130cell29.setCellStyle(numberStyle);
					} else {
						R0130cell29.setCellValue("");
						R0130cell29.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AE
					Cell R0130cell30 = row.createCell(30);
					if (record.getR0130_before_nonresident_nbfi() != null) {
						R0130cell30.setCellValue(record.getR0130_before_nonresident_nbfi().doubleValue());
						R0130cell30.setCellStyle(numberStyle);
					} else {
						R0130cell30.setCellValue("");
						R0130cell30.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AF
					Cell R0130cell31 = row.createCell(31);
					if (record.getR0130_after_nonresident_nbfi() != null) {
						R0130cell31.setCellValue(record.getR0130_after_nonresident_nbfi().doubleValue());
						R0130cell31.setCellStyle(numberStyle);
					} else {
						R0130cell31.setCellValue("");
						R0130cell31.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AG
					Cell R0130cell32 = row.createCell(32);
					if (record.getR0130_before_resident_bank() != null) {
						R0130cell32.setCellValue(record.getR0130_before_resident_bank().doubleValue());
						R0130cell32.setCellStyle(numberStyle);
					} else {
						R0130cell32.setCellValue("");
						R0130cell32.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AH
					Cell R0130cell33 = row.createCell(33);
					if (record.getR0130_after_resident_bank() != null) {
						R0130cell33.setCellValue(record.getR0130_after_resident_bank().doubleValue());
						R0130cell33.setCellStyle(numberStyle);
					} else {
						R0130cell33.setCellValue("");
						R0130cell33.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AI
					Cell R0130cell34 = row.createCell(34);
					if (record.getR0130_before_nonresident_bank() != null) {
						R0130cell34.setCellValue(record.getR0130_before_nonresident_bank().doubleValue());
						R0130cell34.setCellStyle(numberStyle);
					} else {
						R0130cell34.setCellValue("");
						R0130cell34.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AJ
					Cell R0130cell35 = row.createCell(35);
					if (record.getR0130_after_nonresident_bank() != null) {
						R0130cell35.setCellValue(record.getR0130_after_nonresident_bank().doubleValue());
						R0130cell35.setCellStyle(numberStyle);
					} else {
						R0130cell35.setCellValue("");
						R0130cell35.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AK
					Cell R0130cell36 = row.createCell(36);
					if (record.getR0130_before_resident_government() != null) {
						R0130cell36.setCellValue(record.getR0130_before_resident_government().doubleValue());
						R0130cell36.setCellStyle(numberStyle);
					} else {
						R0130cell36.setCellValue("");
						R0130cell36.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AL
					Cell R0130cell37 = row.createCell(37);
					if (record.getR0130_after_resident_government() != null) {
						R0130cell37.setCellValue(record.getR0130_after_resident_government().doubleValue());
						R0130cell37.setCellStyle(numberStyle);
					} else {
						R0130cell37.setCellValue("");
						R0130cell37.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AM
					Cell R0130cell38 = row.createCell(38);
					if (record.getR0130_before_nonresident_government() != null) {
						R0130cell38.setCellValue(record.getR0130_before_nonresident_government().doubleValue());
						R0130cell38.setCellStyle(numberStyle);
					} else {
						R0130cell38.setCellValue("");
						R0130cell38.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AN
					Cell R0130cell39 = row.createCell(39);
					if (record.getR0130_after_nonresident_government() != null) {
						R0130cell39.setCellValue(record.getR0130_after_nonresident_government().doubleValue());
						R0130cell39.setCellStyle(numberStyle);
					} else {
						R0130cell39.setCellValue("");
						R0130cell39.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column E
					row = sheet.getRow(23);
					Cell R0140cell4 = row.createCell(4);
					if (record.getR0140_before_resident_individual() != null) {
						R0140cell4.setCellValue(record.getR0140_before_resident_individual().doubleValue());
						R0140cell4.setCellStyle(numberStyle);
					} else {
						R0140cell4.setCellValue("");
						R0140cell4.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column F
					Cell R0140cell5 = row.createCell(5);
					if (record.getR0140_after_resident_individual() != null) {
						R0140cell5.setCellValue(record.getR0140_after_resident_individual().doubleValue());
						R0140cell5.setCellStyle(numberStyle);
					} else {
						R0140cell5.setCellValue("");
						R0140cell5.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column G
					Cell R0140cell6 = row.createCell(6);
					if (record.getR0140_before_nonresident_individual() != null) {
						R0140cell6.setCellValue(record.getR0140_before_nonresident_individual().doubleValue());
						R0140cell6.setCellStyle(numberStyle);
					} else {
						R0140cell6.setCellValue("");
						R0140cell6.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column H
					Cell R0140cell7 = row.createCell(7);
					if (record.getR0140_after_nonresident_individual() != null) {
						R0140cell7.setCellValue(record.getR0140_after_nonresident_individual().doubleValue());
						R0140cell7.setCellStyle(numberStyle);
					} else {
						R0140cell7.setCellValue("");
						R0140cell7.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column I
					Cell R0140cell8 = row.createCell(8);
					if (record.getR0140_before_resident_retail() != null) {
						R0140cell8.setCellValue(record.getR0140_before_resident_retail().doubleValue());
						R0140cell8.setCellStyle(numberStyle);
					} else {
						R0140cell8.setCellValue("");
						R0140cell8.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column J
					Cell R0140cell9 = row.createCell(9);
					if (record.getR0140_after_resident_retail() != null) {
						R0140cell9.setCellValue(record.getR0140_after_resident_retail().doubleValue());
						R0140cell9.setCellStyle(numberStyle);
					} else {
						R0140cell9.setCellValue("");
						R0140cell9.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column K
					Cell R0140cell10 = row.createCell(10);
					if (record.getR0140_before_nonresident_retail() != null) {
						R0140cell10.setCellValue(record.getR0140_before_nonresident_retail().doubleValue());
						R0140cell10.setCellStyle(numberStyle);
					} else {
						R0140cell10.setCellValue("");
						R0140cell10.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column L
					Cell R0140cell11 = row.createCell(11);
					if (record.getR0140_after_nonresident_retail() != null) {
						R0140cell11.setCellValue(record.getR0140_after_nonresident_retail().doubleValue());
						R0140cell11.setCellStyle(numberStyle);
					} else {
						R0140cell11.setCellValue("");
						R0140cell11.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column M
					Cell R0140cell12 = row.createCell(12);
					if (record.getR0140_before_resident_sme() != null) {
						R0140cell12.setCellValue(record.getR0140_before_resident_sme().doubleValue());
						R0140cell12.setCellStyle(numberStyle);
					} else {
						R0140cell12.setCellValue("");
						R0140cell12.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column N
					Cell R0140cell13 = row.createCell(13);
					if (record.getR0140_after_resident_sme() != null) {
						R0140cell13.setCellValue(record.getR0140_after_resident_sme().doubleValue());
						R0140cell13.setCellStyle(numberStyle);
					} else {
						R0140cell13.setCellValue("");
						R0140cell13.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column O
					Cell R0140cell14 = row.createCell(14);
					if (record.getR0140_before_nonresident_sme() != null) {
						R0140cell14.setCellValue(record.getR0140_before_nonresident_sme().doubleValue());
						R0140cell14.setCellStyle(numberStyle);
					} else {
						R0140cell14.setCellValue("");
						R0140cell14.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column P
					Cell R0140cell15 = row.createCell(15);
					if (record.getR0140_after_nonresident_sme() != null) {
						R0140cell15.setCellValue(record.getR0140_after_nonresident_sme().doubleValue());
						R0140cell15.setCellStyle(numberStyle);
					} else {
						R0140cell15.setCellValue("");
						R0140cell15.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column Q
					Cell R0140cell16 = row.createCell(16);
					if (record.getR0140_before_resident_hni() != null) {
						R0140cell16.setCellValue(record.getR0140_before_resident_hni().doubleValue());
						R0140cell16.setCellStyle(numberStyle);
					} else {
						R0140cell16.setCellValue("");
						R0140cell16.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column R
					Cell R0140cell17 = row.createCell(17);
					if (record.getR0140_after_resident_hni() != null) {
						R0140cell17.setCellValue(record.getR0140_after_resident_hni().doubleValue());
						R0140cell17.setCellStyle(numberStyle);
					} else {
						R0140cell17.setCellValue("");
						R0140cell17.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column S
					Cell R0140cell18 = row.createCell(18);
					if (record.getR0140_before_nonresident_hni() != null) {
						R0140cell18.setCellValue(record.getR0140_before_nonresident_hni().doubleValue());
						R0140cell18.setCellStyle(numberStyle);
					} else {
						R0140cell18.setCellValue("");
						R0140cell18.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column T
					Cell R0140cell19 = row.createCell(19);
					if (record.getR0140_after_nonresident_hni() != null) {
						R0140cell19.setCellValue(record.getR0140_after_nonresident_hni().doubleValue());
						R0140cell19.setCellStyle(numberStyle);
					} else {
						R0140cell19.setCellValue("");
						R0140cell19.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column U
					Cell R0140cell20 = row.createCell(20);
					if (record.getR0140_before_resident_gre() != null) {
						R0140cell20.setCellValue(record.getR0140_before_resident_gre().doubleValue());
						R0140cell20.setCellStyle(numberStyle);
					} else {
						R0140cell20.setCellValue("");
						R0140cell20.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column V
					Cell R0140cell21 = row.createCell(21);
					if (record.getR0140_after_resident_gre() != null) {
						R0140cell21.setCellValue(record.getR0140_after_resident_gre().doubleValue());
						R0140cell21.setCellStyle(numberStyle);
					} else {
						R0140cell21.setCellValue("");
						R0140cell21.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column W
					Cell R0140cell22 = row.createCell(22);
					if (record.getR0140_before_nonresident_gre() != null) {
						R0140cell22.setCellValue(record.getR0140_before_nonresident_gre().doubleValue());
						R0140cell22.setCellStyle(numberStyle);
					} else {
						R0140cell22.setCellValue("");
						R0140cell22.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column X
					Cell R0140cell23 = row.createCell(23);
					if (record.getR0140_after_nonresident_gre() != null) {
						R0140cell23.setCellValue(record.getR0140_after_nonresident_gre().doubleValue());
						R0140cell23.setCellStyle(numberStyle);
					} else {
						R0140cell23.setCellValue("");
						R0140cell23.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column Y
					Cell R0140cell24 = row.createCell(24);
					if (record.getR0140_before_resident_corporate() != null) {
						R0140cell24.setCellValue(record.getR0140_before_resident_corporate().doubleValue());
						R0140cell24.setCellStyle(numberStyle);
					} else {
						R0140cell24.setCellValue("");
						R0140cell24.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column Z
					Cell R0140cell25 = row.createCell(25);
					if (record.getR0140_after_resident_corporate() != null) {
						R0140cell25.setCellValue(record.getR0140_after_resident_corporate().doubleValue());
						R0140cell25.setCellStyle(numberStyle);
					} else {
						R0140cell25.setCellValue("");
						R0140cell25.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AA
					Cell R0140cell26 = row.createCell(26);
					if (record.getR0140_before_nonresident_corporate() != null) {
						R0140cell26.setCellValue(record.getR0140_before_nonresident_corporate().doubleValue());
						R0140cell26.setCellStyle(numberStyle);
					} else {
						R0140cell26.setCellValue("");
						R0140cell26.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AB
					Cell R0140cell27 = row.createCell(27);
					if (record.getR0140_after_nonresident_corporate() != null) {
						R0140cell27.setCellValue(record.getR0140_after_nonresident_corporate().doubleValue());
						R0140cell27.setCellStyle(numberStyle);
					} else {
						R0140cell27.setCellValue("");
						R0140cell27.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AC
					Cell R0140cell28 = row.createCell(28);
					if (record.getR0140_before_resident_nbfi() != null) {
						R0140cell28.setCellValue(record.getR0140_before_resident_nbfi().doubleValue());
						R0140cell28.setCellStyle(numberStyle);
					} else {
						R0140cell28.setCellValue("");
						R0140cell28.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AD
					Cell R0140cell29 = row.createCell(29);
					if (record.getR0140_after_resident_nbfi() != null) {
						R0140cell29.setCellValue(record.getR0140_after_resident_nbfi().doubleValue());
						R0140cell29.setCellStyle(numberStyle);
					} else {
						R0140cell29.setCellValue("");
						R0140cell29.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AE
					Cell R0140cell30 = row.createCell(30);
					if (record.getR0140_before_nonresident_nbfi() != null) {
						R0140cell30.setCellValue(record.getR0140_before_nonresident_nbfi().doubleValue());
						R0140cell30.setCellStyle(numberStyle);
					} else {
						R0140cell30.setCellValue("");
						R0140cell30.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AF
					Cell R0140cell31 = row.createCell(31);
					if (record.getR0140_after_nonresident_nbfi() != null) {
						R0140cell31.setCellValue(record.getR0140_after_nonresident_nbfi().doubleValue());
						R0140cell31.setCellStyle(numberStyle);
					} else {
						R0140cell31.setCellValue("");
						R0140cell31.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AG
					Cell R0140cell32 = row.createCell(32);
					if (record.getR0140_before_resident_bank() != null) {
						R0140cell32.setCellValue(record.getR0140_before_resident_bank().doubleValue());
						R0140cell32.setCellStyle(numberStyle);
					} else {
						R0140cell32.setCellValue("");
						R0140cell32.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AH
					Cell R0140cell33 = row.createCell(33);
					if (record.getR0140_after_resident_bank() != null) {
						R0140cell33.setCellValue(record.getR0140_after_resident_bank().doubleValue());
						R0140cell33.setCellStyle(numberStyle);
					} else {
						R0140cell33.setCellValue("");
						R0140cell33.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AI
					Cell R0140cell34 = row.createCell(34);
					if (record.getR0140_before_nonresident_bank() != null) {
						R0140cell34.setCellValue(record.getR0140_before_nonresident_bank().doubleValue());
						R0140cell34.setCellStyle(numberStyle);
					} else {
						R0140cell34.setCellValue("");
						R0140cell34.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AJ
					Cell R0140cell35 = row.createCell(35);
					if (record.getR0140_after_nonresident_bank() != null) {
						R0140cell35.setCellValue(record.getR0140_after_nonresident_bank().doubleValue());
						R0140cell35.setCellStyle(numberStyle);
					} else {
						R0140cell35.setCellValue("");
						R0140cell35.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AK
					Cell R0140cell36 = row.createCell(36);
					if (record.getR0140_before_resident_government() != null) {
						R0140cell36.setCellValue(record.getR0140_before_resident_government().doubleValue());
						R0140cell36.setCellStyle(numberStyle);
					} else {
						R0140cell36.setCellValue("");
						R0140cell36.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AL
					Cell R0140cell37 = row.createCell(37);
					if (record.getR0140_after_resident_government() != null) {
						R0140cell37.setCellValue(record.getR0140_after_resident_government().doubleValue());
						R0140cell37.setCellStyle(numberStyle);
					} else {
						R0140cell37.setCellValue("");
						R0140cell37.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AM
					Cell R0140cell38 = row.createCell(38);
					if (record.getR0140_before_nonresident_government() != null) {
						R0140cell38.setCellValue(record.getR0140_before_nonresident_government().doubleValue());
						R0140cell38.setCellStyle(numberStyle);
					} else {
						R0140cell38.setCellValue("");
						R0140cell38.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AN
					Cell R0140cell39 = row.createCell(39);
					if (record.getR0140_after_nonresident_government() != null) {
						R0140cell39.setCellValue(record.getR0140_after_nonresident_government().doubleValue());
						R0140cell39.setCellStyle(numberStyle);
					} else {
						R0140cell39.setCellValue("");
						R0140cell39.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column E
					row = sheet.getRow(24);
					Cell R0150cell4 = row.createCell(4);
					if (record.getR0150_before_resident_individual() != null) {
						R0150cell4.setCellValue(record.getR0150_before_resident_individual().doubleValue());
						R0150cell4.setCellStyle(numberStyle);
					} else {
						R0150cell4.setCellValue("");
						R0150cell4.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column F
					Cell R0150cell5 = row.createCell(5);
					if (record.getR0150_after_resident_individual() != null) {
						R0150cell5.setCellValue(record.getR0150_after_resident_individual().doubleValue());
						R0150cell5.setCellStyle(numberStyle);
					} else {
						R0150cell5.setCellValue("");
						R0150cell5.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column G
					Cell R0150cell6 = row.createCell(6);
					if (record.getR0150_before_nonresident_individual() != null) {
						R0150cell6.setCellValue(record.getR0150_before_nonresident_individual().doubleValue());
						R0150cell6.setCellStyle(numberStyle);
					} else {
						R0150cell6.setCellValue("");
						R0150cell6.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column H
					Cell R0150cell7 = row.createCell(7);
					if (record.getR0150_after_nonresident_individual() != null) {
						R0150cell7.setCellValue(record.getR0150_after_nonresident_individual().doubleValue());
						R0150cell7.setCellStyle(numberStyle);
					} else {
						R0150cell7.setCellValue("");
						R0150cell7.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column I
					Cell R0150cell8 = row.createCell(8);
					if (record.getR0150_before_resident_retail() != null) {
						R0150cell8.setCellValue(record.getR0150_before_resident_retail().doubleValue());
						R0150cell8.setCellStyle(numberStyle);
					} else {
						R0150cell8.setCellValue("");
						R0150cell8.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column J
					Cell R0150cell9 = row.createCell(9);
					if (record.getR0150_after_resident_retail() != null) {
						R0150cell9.setCellValue(record.getR0150_after_resident_retail().doubleValue());
						R0150cell9.setCellStyle(numberStyle);
					} else {
						R0150cell9.setCellValue("");
						R0150cell9.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column K
					Cell R0150cell10 = row.createCell(10);
					if (record.getR0150_before_nonresident_retail() != null) {
						R0150cell10.setCellValue(record.getR0150_before_nonresident_retail().doubleValue());
						R0150cell10.setCellStyle(numberStyle);
					} else {
						R0150cell10.setCellValue("");
						R0150cell10.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column L
					Cell R0150cell11 = row.createCell(11);
					if (record.getR0150_after_nonresident_retail() != null) {
						R0150cell11.setCellValue(record.getR0150_after_nonresident_retail().doubleValue());
						R0150cell11.setCellStyle(numberStyle);
					} else {
						R0150cell11.setCellValue("");
						R0150cell11.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column M
					Cell R0150cell12 = row.createCell(12);
					if (record.getR0150_before_resident_sme() != null) {
						R0150cell12.setCellValue(record.getR0150_before_resident_sme().doubleValue());
						R0150cell12.setCellStyle(numberStyle);
					} else {
						R0150cell12.setCellValue("");
						R0150cell12.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column N
					Cell R0150cell13 = row.createCell(13);
					if (record.getR0150_after_resident_sme() != null) {
						R0150cell13.setCellValue(record.getR0150_after_resident_sme().doubleValue());
						R0150cell13.setCellStyle(numberStyle);
					} else {
						R0150cell13.setCellValue("");
						R0150cell13.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column O
					Cell R0150cell14 = row.createCell(14);
					if (record.getR0150_before_nonresident_sme() != null) {
						R0150cell14.setCellValue(record.getR0150_before_nonresident_sme().doubleValue());
						R0150cell14.setCellStyle(numberStyle);
					} else {
						R0150cell14.setCellValue("");
						R0150cell14.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column P
					Cell R0150cell15 = row.createCell(15);
					if (record.getR0150_after_nonresident_sme() != null) {
						R0150cell15.setCellValue(record.getR0150_after_nonresident_sme().doubleValue());
						R0150cell15.setCellStyle(numberStyle);
					} else {
						R0150cell15.setCellValue("");
						R0150cell15.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column Q
					Cell R0150cell16 = row.createCell(16);
					if (record.getR0150_before_resident_hni() != null) {
						R0150cell16.setCellValue(record.getR0150_before_resident_hni().doubleValue());
						R0150cell16.setCellStyle(numberStyle);
					} else {
						R0150cell16.setCellValue("");
						R0150cell16.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column R
					Cell R0150cell17 = row.createCell(17);
					if (record.getR0150_after_resident_hni() != null) {
						R0150cell17.setCellValue(record.getR0150_after_resident_hni().doubleValue());
						R0150cell17.setCellStyle(numberStyle);
					} else {
						R0150cell17.setCellValue("");
						R0150cell17.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column S
					Cell R0150cell18 = row.createCell(18);
					if (record.getR0150_before_nonresident_hni() != null) {
						R0150cell18.setCellValue(record.getR0150_before_nonresident_hni().doubleValue());
						R0150cell18.setCellStyle(numberStyle);
					} else {
						R0150cell18.setCellValue("");
						R0150cell18.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column T
					Cell R0150cell19 = row.createCell(19);
					if (record.getR0150_after_nonresident_hni() != null) {
						R0150cell19.setCellValue(record.getR0150_after_nonresident_hni().doubleValue());
						R0150cell19.setCellStyle(numberStyle);
					} else {
						R0150cell19.setCellValue("");
						R0150cell19.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column U
					Cell R0150cell20 = row.createCell(20);
					if (record.getR0150_before_resident_gre() != null) {
						R0150cell20.setCellValue(record.getR0150_before_resident_gre().doubleValue());
						R0150cell20.setCellStyle(numberStyle);
					} else {
						R0150cell20.setCellValue("");
						R0150cell20.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column V
					Cell R0150cell21 = row.createCell(21);
					if (record.getR0150_after_resident_gre() != null) {
						R0150cell21.setCellValue(record.getR0150_after_resident_gre().doubleValue());
						R0150cell21.setCellStyle(numberStyle);
					} else {
						R0150cell21.setCellValue("");
						R0150cell21.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column W
					Cell R0150cell22 = row.createCell(22);
					if (record.getR0150_before_nonresident_gre() != null) {
						R0150cell22.setCellValue(record.getR0150_before_nonresident_gre().doubleValue());
						R0150cell22.setCellStyle(numberStyle);
					} else {
						R0150cell22.setCellValue("");
						R0150cell22.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column X
					Cell R0150cell23 = row.createCell(23);
					if (record.getR0150_after_nonresident_gre() != null) {
						R0150cell23.setCellValue(record.getR0150_after_nonresident_gre().doubleValue());
						R0150cell23.setCellStyle(numberStyle);
					} else {
						R0150cell23.setCellValue("");
						R0150cell23.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column Y
					Cell R0150cell24 = row.createCell(24);
					if (record.getR0150_before_resident_corporate() != null) {
						R0150cell24.setCellValue(record.getR0150_before_resident_corporate().doubleValue());
						R0150cell24.setCellStyle(numberStyle);
					} else {
						R0150cell24.setCellValue("");
						R0150cell24.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column Z
					Cell R0150cell25 = row.createCell(25);
					if (record.getR0150_after_resident_corporate() != null) {
						R0150cell25.setCellValue(record.getR0150_after_resident_corporate().doubleValue());
						R0150cell25.setCellStyle(numberStyle);
					} else {
						R0150cell25.setCellValue("");
						R0150cell25.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AA
					Cell R0150cell26 = row.createCell(26);
					if (record.getR0150_before_nonresident_corporate() != null) {
						R0150cell26.setCellValue(record.getR0150_before_nonresident_corporate().doubleValue());
						R0150cell26.setCellStyle(numberStyle);
					} else {
						R0150cell26.setCellValue("");
						R0150cell26.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AB
					Cell R0150cell27 = row.createCell(27);
					if (record.getR0150_after_nonresident_corporate() != null) {
						R0150cell27.setCellValue(record.getR0150_after_nonresident_corporate().doubleValue());
						R0150cell27.setCellStyle(numberStyle);
					} else {
						R0150cell27.setCellValue("");
						R0150cell27.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AC
					Cell R0150cell28 = row.createCell(28);
					if (record.getR0150_before_resident_nbfi() != null) {
						R0150cell28.setCellValue(record.getR0150_before_resident_nbfi().doubleValue());
						R0150cell28.setCellStyle(numberStyle);
					} else {
						R0150cell28.setCellValue("");
						R0150cell28.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AD
					Cell R0150cell29 = row.createCell(29);
					if (record.getR0150_after_resident_nbfi() != null) {
						R0150cell29.setCellValue(record.getR0150_after_resident_nbfi().doubleValue());
						R0150cell29.setCellStyle(numberStyle);
					} else {
						R0150cell29.setCellValue("");
						R0150cell29.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AE
					Cell R0150cell30 = row.createCell(30);
					if (record.getR0150_before_nonresident_nbfi() != null) {
						R0150cell30.setCellValue(record.getR0150_before_nonresident_nbfi().doubleValue());
						R0150cell30.setCellStyle(numberStyle);
					} else {
						R0150cell30.setCellValue("");
						R0150cell30.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AF
					Cell R0150cell31 = row.createCell(31);
					if (record.getR0150_after_nonresident_nbfi() != null) {
						R0150cell31.setCellValue(record.getR0150_after_nonresident_nbfi().doubleValue());
						R0150cell31.setCellStyle(numberStyle);
					} else {
						R0150cell31.setCellValue("");
						R0150cell31.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AG
					Cell R0150cell32 = row.createCell(32);
					if (record.getR0150_before_resident_bank() != null) {
						R0150cell32.setCellValue(record.getR0150_before_resident_bank().doubleValue());
						R0150cell32.setCellStyle(numberStyle);
					} else {
						R0150cell32.setCellValue("");
						R0150cell32.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AH
					Cell R0150cell33 = row.createCell(33);
					if (record.getR0150_after_resident_bank() != null) {
						R0150cell33.setCellValue(record.getR0150_after_resident_bank().doubleValue());
						R0150cell33.setCellStyle(numberStyle);
					} else {
						R0150cell33.setCellValue("");
						R0150cell33.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AI
					Cell R0150cell34 = row.createCell(34);
					if (record.getR0150_before_nonresident_bank() != null) {
						R0150cell34.setCellValue(record.getR0150_before_nonresident_bank().doubleValue());
						R0150cell34.setCellStyle(numberStyle);
					} else {
						R0150cell34.setCellValue("");
						R0150cell34.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AJ
					Cell R0150cell35 = row.createCell(35);
					if (record.getR0150_after_nonresident_bank() != null) {
						R0150cell35.setCellValue(record.getR0150_after_nonresident_bank().doubleValue());
						R0150cell35.setCellStyle(numberStyle);
					} else {
						R0150cell35.setCellValue("");
						R0150cell35.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AK
					Cell R0150cell36 = row.createCell(36);
					if (record.getR0150_before_resident_government() != null) {
						R0150cell36.setCellValue(record.getR0150_before_resident_government().doubleValue());
						R0150cell36.setCellStyle(numberStyle);
					} else {
						R0150cell36.setCellValue("");
						R0150cell36.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AL
					Cell R0150cell37 = row.createCell(37);
					if (record.getR0150_after_resident_government() != null) {
						R0150cell37.setCellValue(record.getR0150_after_resident_government().doubleValue());
						R0150cell37.setCellStyle(numberStyle);
					} else {
						R0150cell37.setCellValue("");
						R0150cell37.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AM
					Cell R0150cell38 = row.createCell(38);
					if (record.getR0150_before_nonresident_government() != null) {
						R0150cell38.setCellValue(record.getR0150_before_nonresident_government().doubleValue());
						R0150cell38.setCellStyle(numberStyle);
					} else {
						R0150cell38.setCellValue("");
						R0150cell38.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AN
					Cell R0150cell39 = row.createCell(39);
					if (record.getR0150_after_nonresident_government() != null) {
						R0150cell39.setCellValue(record.getR0150_after_nonresident_government().doubleValue());
						R0150cell39.setCellStyle(numberStyle);
					} else {
						R0150cell39.setCellValue("");
						R0150cell39.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column E
					row = sheet.getRow(25);
					Cell R0160cell4 = row.createCell(4);
					if (record.getR0160_before_resident_individual() != null) {
						R0160cell4.setCellValue(record.getR0160_before_resident_individual().doubleValue());
						R0160cell4.setCellStyle(numberStyle);
					} else {
						R0160cell4.setCellValue("");
						R0160cell4.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column F
					Cell R0160cell5 = row.createCell(5);
					if (record.getR0160_after_resident_individual() != null) {
						R0160cell5.setCellValue(record.getR0160_after_resident_individual().doubleValue());
						R0160cell5.setCellStyle(numberStyle);
					} else {
						R0160cell5.setCellValue("");
						R0160cell5.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column G
					Cell R0160cell6 = row.createCell(6);
					if (record.getR0160_before_nonresident_individual() != null) {
						R0160cell6.setCellValue(record.getR0160_before_nonresident_individual().doubleValue());
						R0160cell6.setCellStyle(numberStyle);
					} else {
						R0160cell6.setCellValue("");
						R0160cell6.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column H
					Cell R0160cell7 = row.createCell(7);
					if (record.getR0160_after_nonresident_individual() != null) {
						R0160cell7.setCellValue(record.getR0160_after_nonresident_individual().doubleValue());
						R0160cell7.setCellStyle(numberStyle);
					} else {
						R0160cell7.setCellValue("");
						R0160cell7.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column I
					Cell R0160cell8 = row.createCell(8);
					if (record.getR0160_before_resident_retail() != null) {
						R0160cell8.setCellValue(record.getR0160_before_resident_retail().doubleValue());
						R0160cell8.setCellStyle(numberStyle);
					} else {
						R0160cell8.setCellValue("");
						R0160cell8.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column J
					Cell R0160cell9 = row.createCell(9);
					if (record.getR0160_after_resident_retail() != null) {
						R0160cell9.setCellValue(record.getR0160_after_resident_retail().doubleValue());
						R0160cell9.setCellStyle(numberStyle);
					} else {
						R0160cell9.setCellValue("");
						R0160cell9.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column K
					Cell R0160cell10 = row.createCell(10);
					if (record.getR0160_before_nonresident_retail() != null) {
						R0160cell10.setCellValue(record.getR0160_before_nonresident_retail().doubleValue());
						R0160cell10.setCellStyle(numberStyle);
					} else {
						R0160cell10.setCellValue("");
						R0160cell10.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column L
					Cell R0160cell11 = row.createCell(11);
					if (record.getR0160_after_nonresident_retail() != null) {
						R0160cell11.setCellValue(record.getR0160_after_nonresident_retail().doubleValue());
						R0160cell11.setCellStyle(numberStyle);
					} else {
						R0160cell11.setCellValue("");
						R0160cell11.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column M
					Cell R0160cell12 = row.createCell(12);
					if (record.getR0160_before_resident_sme() != null) {
						R0160cell12.setCellValue(record.getR0160_before_resident_sme().doubleValue());
						R0160cell12.setCellStyle(numberStyle);
					} else {
						R0160cell12.setCellValue("");
						R0160cell12.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column N
					Cell R0160cell13 = row.createCell(13);
					if (record.getR0160_after_resident_sme() != null) {
						R0160cell13.setCellValue(record.getR0160_after_resident_sme().doubleValue());
						R0160cell13.setCellStyle(numberStyle);
					} else {
						R0160cell13.setCellValue("");
						R0160cell13.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column O
					Cell R0160cell14 = row.createCell(14);
					if (record.getR0160_before_nonresident_sme() != null) {
						R0160cell14.setCellValue(record.getR0160_before_nonresident_sme().doubleValue());
						R0160cell14.setCellStyle(numberStyle);
					} else {
						R0160cell14.setCellValue("");
						R0160cell14.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column P
					Cell R0160cell15 = row.createCell(15);
					if (record.getR0160_after_nonresident_sme() != null) {
						R0160cell15.setCellValue(record.getR0160_after_nonresident_sme().doubleValue());
						R0160cell15.setCellStyle(numberStyle);
					} else {
						R0160cell15.setCellValue("");
						R0160cell15.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column Q
					Cell R0160cell16 = row.createCell(16);
					if (record.getR0160_before_resident_hni() != null) {
						R0160cell16.setCellValue(record.getR0160_before_resident_hni().doubleValue());
						R0160cell16.setCellStyle(numberStyle);
					} else {
						R0160cell16.setCellValue("");
						R0160cell16.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column R
					Cell R0160cell17 = row.createCell(17);
					if (record.getR0160_after_resident_hni() != null) {
						R0160cell17.setCellValue(record.getR0160_after_resident_hni().doubleValue());
						R0160cell17.setCellStyle(numberStyle);
					} else {
						R0160cell17.setCellValue("");
						R0160cell17.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column S
					Cell R0160cell18 = row.createCell(18);
					if (record.getR0160_before_nonresident_hni() != null) {
						R0160cell18.setCellValue(record.getR0160_before_nonresident_hni().doubleValue());
						R0160cell18.setCellStyle(numberStyle);
					} else {
						R0160cell18.setCellValue("");
						R0160cell18.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column T
					Cell R0160cell19 = row.createCell(19);
					if (record.getR0160_after_nonresident_hni() != null) {
						R0160cell19.setCellValue(record.getR0160_after_nonresident_hni().doubleValue());
						R0160cell19.setCellStyle(numberStyle);
					} else {
						R0160cell19.setCellValue("");
						R0160cell19.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column U
					Cell R0160cell20 = row.createCell(20);
					if (record.getR0160_before_resident_gre() != null) {
						R0160cell20.setCellValue(record.getR0160_before_resident_gre().doubleValue());
						R0160cell20.setCellStyle(numberStyle);
					} else {
						R0160cell20.setCellValue("");
						R0160cell20.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column V
					Cell R0160cell21 = row.createCell(21);
					if (record.getR0160_after_resident_gre() != null) {
						R0160cell21.setCellValue(record.getR0160_after_resident_gre().doubleValue());
						R0160cell21.setCellStyle(numberStyle);
					} else {
						R0160cell21.setCellValue("");
						R0160cell21.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column W
					Cell R0160cell22 = row.createCell(22);
					if (record.getR0160_before_nonresident_gre() != null) {
						R0160cell22.setCellValue(record.getR0160_before_nonresident_gre().doubleValue());
						R0160cell22.setCellStyle(numberStyle);
					} else {
						R0160cell22.setCellValue("");
						R0160cell22.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column X
					Cell R0160cell23 = row.createCell(23);
					if (record.getR0160_after_nonresident_gre() != null) {
						R0160cell23.setCellValue(record.getR0160_after_nonresident_gre().doubleValue());
						R0160cell23.setCellStyle(numberStyle);
					} else {
						R0160cell23.setCellValue("");
						R0160cell23.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column Y
					Cell R0160cell24 = row.createCell(24);
					if (record.getR0160_before_resident_corporate() != null) {
						R0160cell24.setCellValue(record.getR0160_before_resident_corporate().doubleValue());
						R0160cell24.setCellStyle(numberStyle);
					} else {
						R0160cell24.setCellValue("");
						R0160cell24.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column Z
					Cell R0160cell25 = row.createCell(25);
					if (record.getR0160_after_resident_corporate() != null) {
						R0160cell25.setCellValue(record.getR0160_after_resident_corporate().doubleValue());
						R0160cell25.setCellStyle(numberStyle);
					} else {
						R0160cell25.setCellValue("");
						R0160cell25.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AA
					Cell R0160cell26 = row.createCell(26);
					if (record.getR0160_before_nonresident_corporate() != null) {
						R0160cell26.setCellValue(record.getR0160_before_nonresident_corporate().doubleValue());
						R0160cell26.setCellStyle(numberStyle);
					} else {
						R0160cell26.setCellValue("");
						R0160cell26.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AB
					Cell R0160cell27 = row.createCell(27);
					if (record.getR0160_after_nonresident_corporate() != null) {
						R0160cell27.setCellValue(record.getR0160_after_nonresident_corporate().doubleValue());
						R0160cell27.setCellStyle(numberStyle);
					} else {
						R0160cell27.setCellValue("");
						R0160cell27.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AC
					Cell R0160cell28 = row.createCell(28);
					if (record.getR0160_before_resident_nbfi() != null) {
						R0160cell28.setCellValue(record.getR0160_before_resident_nbfi().doubleValue());
						R0160cell28.setCellStyle(numberStyle);
					} else {
						R0160cell28.setCellValue("");
						R0160cell28.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AD
					Cell R0160cell29 = row.createCell(29);
					if (record.getR0160_after_resident_nbfi() != null) {
						R0160cell29.setCellValue(record.getR0160_after_resident_nbfi().doubleValue());
						R0160cell29.setCellStyle(numberStyle);
					} else {
						R0160cell29.setCellValue("");
						R0160cell29.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AE
					Cell R0160cell30 = row.createCell(30);
					if (record.getR0160_before_nonresident_nbfi() != null) {
						R0160cell30.setCellValue(record.getR0160_before_nonresident_nbfi().doubleValue());
						R0160cell30.setCellStyle(numberStyle);
					} else {
						R0160cell30.setCellValue("");
						R0160cell30.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AF
					Cell R0160cell31 = row.createCell(31);
					if (record.getR0160_after_nonresident_nbfi() != null) {
						R0160cell31.setCellValue(record.getR0160_after_nonresident_nbfi().doubleValue());
						R0160cell31.setCellStyle(numberStyle);
					} else {
						R0160cell31.setCellValue("");
						R0160cell31.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AG
					Cell R0160cell32 = row.createCell(32);
					if (record.getR0160_before_resident_bank() != null) {
						R0160cell32.setCellValue(record.getR0160_before_resident_bank().doubleValue());
						R0160cell32.setCellStyle(numberStyle);
					} else {
						R0160cell32.setCellValue("");
						R0160cell32.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AH
					Cell R0160cell33 = row.createCell(33);
					if (record.getR0160_after_resident_bank() != null) {
						R0160cell33.setCellValue(record.getR0160_after_resident_bank().doubleValue());
						R0160cell33.setCellStyle(numberStyle);
					} else {
						R0160cell33.setCellValue("");
						R0160cell33.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AI
					Cell R0160cell34 = row.createCell(34);
					if (record.getR0160_before_nonresident_bank() != null) {
						R0160cell34.setCellValue(record.getR0160_before_nonresident_bank().doubleValue());
						R0160cell34.setCellStyle(numberStyle);
					} else {
						R0160cell34.setCellValue("");
						R0160cell34.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AJ
					Cell R0160cell35 = row.createCell(35);
					if (record.getR0160_after_nonresident_bank() != null) {
						R0160cell35.setCellValue(record.getR0160_after_nonresident_bank().doubleValue());
						R0160cell35.setCellStyle(numberStyle);
					} else {
						R0160cell35.setCellValue("");
						R0160cell35.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AK
					Cell R0160cell36 = row.createCell(36);
					if (record.getR0160_before_resident_government() != null) {
						R0160cell36.setCellValue(record.getR0160_before_resident_government().doubleValue());
						R0160cell36.setCellStyle(numberStyle);
					} else {
						R0160cell36.setCellValue("");
						R0160cell36.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AL
					Cell R0160cell37 = row.createCell(37);
					if (record.getR0160_after_resident_government() != null) {
						R0160cell37.setCellValue(record.getR0160_after_resident_government().doubleValue());
						R0160cell37.setCellStyle(numberStyle);
					} else {
						R0160cell37.setCellValue("");
						R0160cell37.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AM
					Cell R0160cell38 = row.createCell(38);
					if (record.getR0160_before_nonresident_government() != null) {
						R0160cell38.setCellValue(record.getR0160_before_nonresident_government().doubleValue());
						R0160cell38.setCellStyle(numberStyle);
					} else {
						R0160cell38.setCellValue("");
						R0160cell38.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AN
					Cell R0160cell39 = row.createCell(39);
					if (record.getR0160_after_nonresident_government() != null) {
						R0160cell39.setCellValue(record.getR0160_after_nonresident_government().doubleValue());
						R0160cell39.setCellStyle(numberStyle);
					} else {
						R0160cell39.setCellValue("");
						R0160cell39.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column E
					row = sheet.getRow(27);
					Cell R0180cell4 = row.createCell(4);
					if (record.getR0180_before_resident_individual() != null) {
						R0180cell4.setCellValue(record.getR0180_before_resident_individual().doubleValue());
						R0180cell4.setCellStyle(numberStyle);
					} else {
						R0180cell4.setCellValue("");
						R0180cell4.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column F
					Cell R0180cell5 = row.createCell(5);
					if (record.getR0180_after_resident_individual() != null) {
						R0180cell5.setCellValue(record.getR0180_after_resident_individual().doubleValue());
						R0180cell5.setCellStyle(numberStyle);
					} else {
						R0180cell5.setCellValue("");
						R0180cell5.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column G
					Cell R0180cell6 = row.createCell(6);
					if (record.getR0180_before_nonresident_individual() != null) {
						R0180cell6.setCellValue(record.getR0180_before_nonresident_individual().doubleValue());
						R0180cell6.setCellStyle(numberStyle);
					} else {
						R0180cell6.setCellValue("");
						R0180cell6.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column H
					Cell R0180cell7 = row.createCell(7);
					if (record.getR0180_after_nonresident_individual() != null) {
						R0180cell7.setCellValue(record.getR0180_after_nonresident_individual().doubleValue());
						R0180cell7.setCellStyle(numberStyle);
					} else {
						R0180cell7.setCellValue("");
						R0180cell7.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column I
					Cell R0180cell8 = row.createCell(8);
					if (record.getR0180_before_resident_retail() != null) {
						R0180cell8.setCellValue(record.getR0180_before_resident_retail().doubleValue());
						R0180cell8.setCellStyle(numberStyle);
					} else {
						R0180cell8.setCellValue("");
						R0180cell8.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column J
					Cell R0180cell9 = row.createCell(9);
					if (record.getR0180_after_resident_retail() != null) {
						R0180cell9.setCellValue(record.getR0180_after_resident_retail().doubleValue());
						R0180cell9.setCellStyle(numberStyle);
					} else {
						R0180cell9.setCellValue("");
						R0180cell9.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column K
					Cell R0180cell10 = row.createCell(10);
					if (record.getR0180_before_nonresident_retail() != null) {
						R0180cell10.setCellValue(record.getR0180_before_nonresident_retail().doubleValue());
						R0180cell10.setCellStyle(numberStyle);
					} else {
						R0180cell10.setCellValue("");
						R0180cell10.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column L
					Cell R0180cell11 = row.createCell(11);
					if (record.getR0180_after_nonresident_retail() != null) {
						R0180cell11.setCellValue(record.getR0180_after_nonresident_retail().doubleValue());
						R0180cell11.setCellStyle(numberStyle);
					} else {
						R0180cell11.setCellValue("");
						R0180cell11.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column M
					Cell R0180cell12 = row.createCell(12);
					if (record.getR0180_before_resident_sme() != null) {
						R0180cell12.setCellValue(record.getR0180_before_resident_sme().doubleValue());
						R0180cell12.setCellStyle(numberStyle);
					} else {
						R0180cell12.setCellValue("");
						R0180cell12.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column N
					Cell R0180cell13 = row.createCell(13);
					if (record.getR0180_after_resident_sme() != null) {
						R0180cell13.setCellValue(record.getR0180_after_resident_sme().doubleValue());
						R0180cell13.setCellStyle(numberStyle);
					} else {
						R0180cell13.setCellValue("");
						R0180cell13.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column O
					Cell R0180cell14 = row.createCell(14);
					if (record.getR0180_before_nonresident_sme() != null) {
						R0180cell14.setCellValue(record.getR0180_before_nonresident_sme().doubleValue());
						R0180cell14.setCellStyle(numberStyle);
					} else {
						R0180cell14.setCellValue("");
						R0180cell14.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column P
					Cell R0180cell15 = row.createCell(15);
					if (record.getR0180_after_nonresident_sme() != null) {
						R0180cell15.setCellValue(record.getR0180_after_nonresident_sme().doubleValue());
						R0180cell15.setCellStyle(numberStyle);
					} else {
						R0180cell15.setCellValue("");
						R0180cell15.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column Q
					Cell R0180cell16 = row.createCell(16);
					if (record.getR0180_before_resident_hni() != null) {
						R0180cell16.setCellValue(record.getR0180_before_resident_hni().doubleValue());
						R0180cell16.setCellStyle(numberStyle);
					} else {
						R0180cell16.setCellValue("");
						R0180cell16.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column R
					Cell R0180cell17 = row.createCell(17);
					if (record.getR0180_after_resident_hni() != null) {
						R0180cell17.setCellValue(record.getR0180_after_resident_hni().doubleValue());
						R0180cell17.setCellStyle(numberStyle);
					} else {
						R0180cell17.setCellValue("");
						R0180cell17.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column S
					Cell R0180cell18 = row.createCell(18);
					if (record.getR0180_before_nonresident_hni() != null) {
						R0180cell18.setCellValue(record.getR0180_before_nonresident_hni().doubleValue());
						R0180cell18.setCellStyle(numberStyle);
					} else {
						R0180cell18.setCellValue("");
						R0180cell18.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column T
					Cell R0180cell19 = row.createCell(19);
					if (record.getR0180_after_nonresident_hni() != null) {
						R0180cell19.setCellValue(record.getR0180_after_nonresident_hni().doubleValue());
						R0180cell19.setCellStyle(numberStyle);
					} else {
						R0180cell19.setCellValue("");
						R0180cell19.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column U
					Cell R0180cell20 = row.createCell(20);
					if (record.getR0180_before_resident_gre() != null) {
						R0180cell20.setCellValue(record.getR0180_before_resident_gre().doubleValue());
						R0180cell20.setCellStyle(numberStyle);
					} else {
						R0180cell20.setCellValue("");
						R0180cell20.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column V
					Cell R0180cell21 = row.createCell(21);
					if (record.getR0180_after_resident_gre() != null) {
						R0180cell21.setCellValue(record.getR0180_after_resident_gre().doubleValue());
						R0180cell21.setCellStyle(numberStyle);
					} else {
						R0180cell21.setCellValue("");
						R0180cell21.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column W
					Cell R0180cell22 = row.createCell(22);
					if (record.getR0180_before_nonresident_gre() != null) {
						R0180cell22.setCellValue(record.getR0180_before_nonresident_gre().doubleValue());
						R0180cell22.setCellStyle(numberStyle);
					} else {
						R0180cell22.setCellValue("");
						R0180cell22.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column X
					Cell R0180cell23 = row.createCell(23);
					if (record.getR0180_after_nonresident_gre() != null) {
						R0180cell23.setCellValue(record.getR0180_after_nonresident_gre().doubleValue());
						R0180cell23.setCellStyle(numberStyle);
					} else {
						R0180cell23.setCellValue("");
						R0180cell23.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column Y
					Cell R0180cell24 = row.createCell(24);
					if (record.getR0180_before_resident_corporate() != null) {
						R0180cell24.setCellValue(record.getR0180_before_resident_corporate().doubleValue());
						R0180cell24.setCellStyle(numberStyle);
					} else {
						R0180cell24.setCellValue("");
						R0180cell24.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column Z
					Cell R0180cell25 = row.createCell(25);
					if (record.getR0180_after_resident_corporate() != null) {
						R0180cell25.setCellValue(record.getR0180_after_resident_corporate().doubleValue());
						R0180cell25.setCellStyle(numberStyle);
					} else {
						R0180cell25.setCellValue("");
						R0180cell25.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AA
					Cell R0180cell26 = row.createCell(26);
					if (record.getR0180_before_nonresident_corporate() != null) {
						R0180cell26.setCellValue(record.getR0180_before_nonresident_corporate().doubleValue());
						R0180cell26.setCellStyle(numberStyle);
					} else {
						R0180cell26.setCellValue("");
						R0180cell26.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AB
					Cell R0180cell27 = row.createCell(27);
					if (record.getR0180_after_nonresident_corporate() != null) {
						R0180cell27.setCellValue(record.getR0180_after_nonresident_corporate().doubleValue());
						R0180cell27.setCellStyle(numberStyle);
					} else {
						R0180cell27.setCellValue("");
						R0180cell27.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AC
					Cell R0180cell28 = row.createCell(28);
					if (record.getR0180_before_resident_nbfi() != null) {
						R0180cell28.setCellValue(record.getR0180_before_resident_nbfi().doubleValue());
						R0180cell28.setCellStyle(numberStyle);
					} else {
						R0180cell28.setCellValue("");
						R0180cell28.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AD
					Cell R0180cell29 = row.createCell(29);
					if (record.getR0180_after_resident_nbfi() != null) {
						R0180cell29.setCellValue(record.getR0180_after_resident_nbfi().doubleValue());
						R0180cell29.setCellStyle(numberStyle);
					} else {
						R0180cell29.setCellValue("");
						R0180cell29.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AE
					Cell R0180cell30 = row.createCell(30);
					if (record.getR0180_before_nonresident_nbfi() != null) {
						R0180cell30.setCellValue(record.getR0180_before_nonresident_nbfi().doubleValue());
						R0180cell30.setCellStyle(numberStyle);
					} else {
						R0180cell30.setCellValue("");
						R0180cell30.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AF
					Cell R0180cell31 = row.createCell(31);
					if (record.getR0180_after_nonresident_nbfi() != null) {
						R0180cell31.setCellValue(record.getR0180_after_nonresident_nbfi().doubleValue());
						R0180cell31.setCellStyle(numberStyle);
					} else {
						R0180cell31.setCellValue("");
						R0180cell31.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AG
					Cell R0180cell32 = row.createCell(32);
					if (record.getR0180_before_resident_bank() != null) {
						R0180cell32.setCellValue(record.getR0180_before_resident_bank().doubleValue());
						R0180cell32.setCellStyle(numberStyle);
					} else {
						R0180cell32.setCellValue("");
						R0180cell32.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AH
					Cell R0180cell33 = row.createCell(33);
					if (record.getR0180_after_resident_bank() != null) {
						R0180cell33.setCellValue(record.getR0180_after_resident_bank().doubleValue());
						R0180cell33.setCellStyle(numberStyle);
					} else {
						R0180cell33.setCellValue("");
						R0180cell33.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AI
					Cell R0180cell34 = row.createCell(34);
					if (record.getR0180_before_nonresident_bank() != null) {
						R0180cell34.setCellValue(record.getR0180_before_nonresident_bank().doubleValue());
						R0180cell34.setCellStyle(numberStyle);
					} else {
						R0180cell34.setCellValue("");
						R0180cell34.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AJ
					Cell R0180cell35 = row.createCell(35);
					if (record.getR0180_after_nonresident_bank() != null) {
						R0180cell35.setCellValue(record.getR0180_after_nonresident_bank().doubleValue());
						R0180cell35.setCellStyle(numberStyle);
					} else {
						R0180cell35.setCellValue("");
						R0180cell35.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AK
					Cell R0180cell36 = row.createCell(36);
					if (record.getR0180_before_resident_government() != null) {
						R0180cell36.setCellValue(record.getR0180_before_resident_government().doubleValue());
						R0180cell36.setCellStyle(numberStyle);
					} else {
						R0180cell36.setCellValue("");
						R0180cell36.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AL
					Cell R0180cell37 = row.createCell(37);
					if (record.getR0180_after_resident_government() != null) {
						R0180cell37.setCellValue(record.getR0180_after_resident_government().doubleValue());
						R0180cell37.setCellStyle(numberStyle);
					} else {
						R0180cell37.setCellValue("");
						R0180cell37.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AM
					Cell R0180cell38 = row.createCell(38);
					if (record.getR0180_before_nonresident_government() != null) {
						R0180cell38.setCellValue(record.getR0180_before_nonresident_government().doubleValue());
						R0180cell38.setCellStyle(numberStyle);
					} else {
						R0180cell38.setCellValue("");
						R0180cell38.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AN
					Cell R0180cell39 = row.createCell(39);
					if (record.getR0180_after_nonresident_government() != null) {
						R0180cell39.setCellValue(record.getR0180_after_nonresident_government().doubleValue());
						R0180cell39.setCellStyle(numberStyle);
					} else {
						R0180cell39.setCellValue("");
						R0180cell39.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column E
					row = sheet.getRow(28);
					Cell R0190cell4 = row.createCell(4);
					if (record.getR0190_before_resident_individual() != null) {
						R0190cell4.setCellValue(record.getR0190_before_resident_individual().doubleValue());
						R0190cell4.setCellStyle(numberStyle);
					} else {
						R0190cell4.setCellValue("");
						R0190cell4.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column F
					Cell R0190cell5 = row.createCell(5);
					if (record.getR0190_after_resident_individual() != null) {
						R0190cell5.setCellValue(record.getR0190_after_resident_individual().doubleValue());
						R0190cell5.setCellStyle(numberStyle);
					} else {
						R0190cell5.setCellValue("");
						R0190cell5.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column G
					Cell R0190cell6 = row.createCell(6);
					if (record.getR0190_before_nonresident_individual() != null) {
						R0190cell6.setCellValue(record.getR0190_before_nonresident_individual().doubleValue());
						R0190cell6.setCellStyle(numberStyle);
					} else {
						R0190cell6.setCellValue("");
						R0190cell6.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column H
					Cell R0190cell7 = row.createCell(7);
					if (record.getR0190_after_nonresident_individual() != null) {
						R0190cell7.setCellValue(record.getR0190_after_nonresident_individual().doubleValue());
						R0190cell7.setCellStyle(numberStyle);
					} else {
						R0190cell7.setCellValue("");
						R0190cell7.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column I
					Cell R0190cell8 = row.createCell(8);
					if (record.getR0190_before_resident_retail() != null) {
						R0190cell8.setCellValue(record.getR0190_before_resident_retail().doubleValue());
						R0190cell8.setCellStyle(numberStyle);
					} else {
						R0190cell8.setCellValue("");
						R0190cell8.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column J
					Cell R0190cell9 = row.createCell(9);
					if (record.getR0190_after_resident_retail() != null) {
						R0190cell9.setCellValue(record.getR0190_after_resident_retail().doubleValue());
						R0190cell9.setCellStyle(numberStyle);
					} else {
						R0190cell9.setCellValue("");
						R0190cell9.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column K
					Cell R0190cell10 = row.createCell(10);
					if (record.getR0190_before_nonresident_retail() != null) {
						R0190cell10.setCellValue(record.getR0190_before_nonresident_retail().doubleValue());
						R0190cell10.setCellStyle(numberStyle);
					} else {
						R0190cell10.setCellValue("");
						R0190cell10.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column L
					Cell R0190cell11 = row.createCell(11);
					if (record.getR0190_after_nonresident_retail() != null) {
						R0190cell11.setCellValue(record.getR0190_after_nonresident_retail().doubleValue());
						R0190cell11.setCellStyle(numberStyle);
					} else {
						R0190cell11.setCellValue("");
						R0190cell11.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column M
					Cell R0190cell12 = row.createCell(12);
					if (record.getR0190_before_resident_sme() != null) {
						R0190cell12.setCellValue(record.getR0190_before_resident_sme().doubleValue());
						R0190cell12.setCellStyle(numberStyle);
					} else {
						R0190cell12.setCellValue("");
						R0190cell12.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column N
					Cell R0190cell13 = row.createCell(13);
					if (record.getR0190_after_resident_sme() != null) {
						R0190cell13.setCellValue(record.getR0190_after_resident_sme().doubleValue());
						R0190cell13.setCellStyle(numberStyle);
					} else {
						R0190cell13.setCellValue("");
						R0190cell13.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column O
					Cell R0190cell14 = row.createCell(14);
					if (record.getR0190_before_nonresident_sme() != null) {
						R0190cell14.setCellValue(record.getR0190_before_nonresident_sme().doubleValue());
						R0190cell14.setCellStyle(numberStyle);
					} else {
						R0190cell14.setCellValue("");
						R0190cell14.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column P
					Cell R0190cell15 = row.createCell(15);
					if (record.getR0190_after_nonresident_sme() != null) {
						R0190cell15.setCellValue(record.getR0190_after_nonresident_sme().doubleValue());
						R0190cell15.setCellStyle(numberStyle);
					} else {
						R0190cell15.setCellValue("");
						R0190cell15.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column Q
					Cell R0190cell16 = row.createCell(16);
					if (record.getR0190_before_resident_hni() != null) {
						R0190cell16.setCellValue(record.getR0190_before_resident_hni().doubleValue());
						R0190cell16.setCellStyle(numberStyle);
					} else {
						R0190cell16.setCellValue("");
						R0190cell16.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column R
					Cell R0190cell17 = row.createCell(17);
					if (record.getR0190_after_resident_hni() != null) {
						R0190cell17.setCellValue(record.getR0190_after_resident_hni().doubleValue());
						R0190cell17.setCellStyle(numberStyle);
					} else {
						R0190cell17.setCellValue("");
						R0190cell17.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column S
					Cell R0190cell18 = row.createCell(18);
					if (record.getR0190_before_nonresident_hni() != null) {
						R0190cell18.setCellValue(record.getR0190_before_nonresident_hni().doubleValue());
						R0190cell18.setCellStyle(numberStyle);
					} else {
						R0190cell18.setCellValue("");
						R0190cell18.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column T
					Cell R0190cell19 = row.createCell(19);
					if (record.getR0190_after_nonresident_hni() != null) {
						R0190cell19.setCellValue(record.getR0190_after_nonresident_hni().doubleValue());
						R0190cell19.setCellStyle(numberStyle);
					} else {
						R0190cell19.setCellValue("");
						R0190cell19.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column U
					Cell R0190cell20 = row.createCell(20);
					if (record.getR0190_before_resident_gre() != null) {
						R0190cell20.setCellValue(record.getR0190_before_resident_gre().doubleValue());
						R0190cell20.setCellStyle(numberStyle);
					} else {
						R0190cell20.setCellValue("");
						R0190cell20.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column V
					Cell R0190cell21 = row.createCell(21);
					if (record.getR0190_after_resident_gre() != null) {
						R0190cell21.setCellValue(record.getR0190_after_resident_gre().doubleValue());
						R0190cell21.setCellStyle(numberStyle);
					} else {
						R0190cell21.setCellValue("");
						R0190cell21.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column W
					Cell R0190cell22 = row.createCell(22);
					if (record.getR0190_before_nonresident_gre() != null) {
						R0190cell22.setCellValue(record.getR0190_before_nonresident_gre().doubleValue());
						R0190cell22.setCellStyle(numberStyle);
					} else {
						R0190cell22.setCellValue("");
						R0190cell22.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column X
					Cell R0190cell23 = row.createCell(23);
					if (record.getR0190_after_nonresident_gre() != null) {
						R0190cell23.setCellValue(record.getR0190_after_nonresident_gre().doubleValue());
						R0190cell23.setCellStyle(numberStyle);
					} else {
						R0190cell23.setCellValue("");
						R0190cell23.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column Y
					Cell R0190cell24 = row.createCell(24);
					if (record.getR0190_before_resident_corporate() != null) {
						R0190cell24.setCellValue(record.getR0190_before_resident_corporate().doubleValue());
						R0190cell24.setCellStyle(numberStyle);
					} else {
						R0190cell24.setCellValue("");
						R0190cell24.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column Z
					Cell R0190cell25 = row.createCell(25);
					if (record.getR0190_after_resident_corporate() != null) {
						R0190cell25.setCellValue(record.getR0190_after_resident_corporate().doubleValue());
						R0190cell25.setCellStyle(numberStyle);
					} else {
						R0190cell25.setCellValue("");
						R0190cell25.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AA
					Cell R0190cell26 = row.createCell(26);
					if (record.getR0190_before_nonresident_corporate() != null) {
						R0190cell26.setCellValue(record.getR0190_before_nonresident_corporate().doubleValue());
						R0190cell26.setCellStyle(numberStyle);
					} else {
						R0190cell26.setCellValue("");
						R0190cell26.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AB
					Cell R0190cell27 = row.createCell(27);
					if (record.getR0190_after_nonresident_corporate() != null) {
						R0190cell27.setCellValue(record.getR0190_after_nonresident_corporate().doubleValue());
						R0190cell27.setCellStyle(numberStyle);
					} else {
						R0190cell27.setCellValue("");
						R0190cell27.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AC
					Cell R0190cell28 = row.createCell(28);
					if (record.getR0190_before_resident_nbfi() != null) {
						R0190cell28.setCellValue(record.getR0190_before_resident_nbfi().doubleValue());
						R0190cell28.setCellStyle(numberStyle);
					} else {
						R0190cell28.setCellValue("");
						R0190cell28.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AD
					Cell R0190cell29 = row.createCell(29);
					if (record.getR0190_after_resident_nbfi() != null) {
						R0190cell29.setCellValue(record.getR0190_after_resident_nbfi().doubleValue());
						R0190cell29.setCellStyle(numberStyle);
					} else {
						R0190cell29.setCellValue("");
						R0190cell29.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AE
					Cell R0190cell30 = row.createCell(30);
					if (record.getR0190_before_nonresident_nbfi() != null) {
						R0190cell30.setCellValue(record.getR0190_before_nonresident_nbfi().doubleValue());
						R0190cell30.setCellStyle(numberStyle);
					} else {
						R0190cell30.setCellValue("");
						R0190cell30.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AF
					Cell R0190cell31 = row.createCell(31);
					if (record.getR0190_after_nonresident_nbfi() != null) {
						R0190cell31.setCellValue(record.getR0190_after_nonresident_nbfi().doubleValue());
						R0190cell31.setCellStyle(numberStyle);
					} else {
						R0190cell31.setCellValue("");
						R0190cell31.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AG
					Cell R0190cell32 = row.createCell(32);
					if (record.getR0190_before_resident_bank() != null) {
						R0190cell32.setCellValue(record.getR0190_before_resident_bank().doubleValue());
						R0190cell32.setCellStyle(numberStyle);
					} else {
						R0190cell32.setCellValue("");
						R0190cell32.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AH
					Cell R0190cell33 = row.createCell(33);
					if (record.getR0190_after_resident_bank() != null) {
						R0190cell33.setCellValue(record.getR0190_after_resident_bank().doubleValue());
						R0190cell33.setCellStyle(numberStyle);
					} else {
						R0190cell33.setCellValue("");
						R0190cell33.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AI
					Cell R0190cell34 = row.createCell(34);
					if (record.getR0190_before_nonresident_bank() != null) {
						R0190cell34.setCellValue(record.getR0190_before_nonresident_bank().doubleValue());
						R0190cell34.setCellStyle(numberStyle);
					} else {
						R0190cell34.setCellValue("");
						R0190cell34.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AJ
					Cell R0190cell35 = row.createCell(35);
					if (record.getR0190_after_nonresident_bank() != null) {
						R0190cell35.setCellValue(record.getR0190_after_nonresident_bank().doubleValue());
						R0190cell35.setCellStyle(numberStyle);
					} else {
						R0190cell35.setCellValue("");
						R0190cell35.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AK
					Cell R0190cell36 = row.createCell(36);
					if (record.getR0190_before_resident_government() != null) {
						R0190cell36.setCellValue(record.getR0190_before_resident_government().doubleValue());
						R0190cell36.setCellStyle(numberStyle);
					} else {
						R0190cell36.setCellValue("");
						R0190cell36.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AL
					Cell R0190cell37 = row.createCell(37);
					if (record.getR0190_after_resident_government() != null) {
						R0190cell37.setCellValue(record.getR0190_after_resident_government().doubleValue());
						R0190cell37.setCellStyle(numberStyle);
					} else {
						R0190cell37.setCellValue("");
						R0190cell37.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AM
					Cell R0190cell38 = row.createCell(38);
					if (record.getR0190_before_nonresident_government() != null) {
						R0190cell38.setCellValue(record.getR0190_before_nonresident_government().doubleValue());
						R0190cell38.setCellStyle(numberStyle);
					} else {
						R0190cell38.setCellValue("");
						R0190cell38.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AN
					Cell R0190cell39 = row.createCell(39);
					if (record.getR0190_after_nonresident_government() != null) {
						R0190cell39.setCellValue(record.getR0190_after_nonresident_government().doubleValue());
						R0190cell39.setCellStyle(numberStyle);
					} else {
						R0190cell39.setCellValue("");
						R0190cell39.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column E
					row = sheet.getRow(29);
					Cell R0200cell4 = row.createCell(4);
					if (record.getR0200_before_resident_individual() != null) {
						R0200cell4.setCellValue(record.getR0200_before_resident_individual().doubleValue());
						R0200cell4.setCellStyle(numberStyle);
					} else {
						R0200cell4.setCellValue("");
						R0200cell4.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column F
					Cell R0200cell5 = row.createCell(5);
					if (record.getR0200_after_resident_individual() != null) {
						R0200cell5.setCellValue(record.getR0200_after_resident_individual().doubleValue());
						R0200cell5.setCellStyle(numberStyle);
					} else {
						R0200cell5.setCellValue("");
						R0200cell5.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column G
					Cell R0200cell6 = row.createCell(6);
					if (record.getR0200_before_nonresident_individual() != null) {
						R0200cell6.setCellValue(record.getR0200_before_nonresident_individual().doubleValue());
						R0200cell6.setCellStyle(numberStyle);
					} else {
						R0200cell6.setCellValue("");
						R0200cell6.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column H
					Cell R0200cell7 = row.createCell(7);
					if (record.getR0200_after_nonresident_individual() != null) {
						R0200cell7.setCellValue(record.getR0200_after_nonresident_individual().doubleValue());
						R0200cell7.setCellStyle(numberStyle);
					} else {
						R0200cell7.setCellValue("");
						R0200cell7.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column I
					Cell R0200cell8 = row.createCell(8);
					if (record.getR0200_before_resident_retail() != null) {
						R0200cell8.setCellValue(record.getR0200_before_resident_retail().doubleValue());
						R0200cell8.setCellStyle(numberStyle);
					} else {
						R0200cell8.setCellValue("");
						R0200cell8.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column J
					Cell R0200cell9 = row.createCell(9);
					if (record.getR0200_after_resident_retail() != null) {
						R0200cell9.setCellValue(record.getR0200_after_resident_retail().doubleValue());
						R0200cell9.setCellStyle(numberStyle);
					} else {
						R0200cell9.setCellValue("");
						R0200cell9.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column K
					Cell R0200cell10 = row.createCell(10);
					if (record.getR0200_before_nonresident_retail() != null) {
						R0200cell10.setCellValue(record.getR0200_before_nonresident_retail().doubleValue());
						R0200cell10.setCellStyle(numberStyle);
					} else {
						R0200cell10.setCellValue("");
						R0200cell10.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column L
					Cell R0200cell11 = row.createCell(11);
					if (record.getR0200_after_nonresident_retail() != null) {
						R0200cell11.setCellValue(record.getR0200_after_nonresident_retail().doubleValue());
						R0200cell11.setCellStyle(numberStyle);
					} else {
						R0200cell11.setCellValue("");
						R0200cell11.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column M
					Cell R0200cell12 = row.createCell(12);
					if (record.getR0200_before_resident_sme() != null) {
						R0200cell12.setCellValue(record.getR0200_before_resident_sme().doubleValue());
						R0200cell12.setCellStyle(numberStyle);
					} else {
						R0200cell12.setCellValue("");
						R0200cell12.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column N
					Cell R0200cell13 = row.createCell(13);
					if (record.getR0200_after_resident_sme() != null) {
						R0200cell13.setCellValue(record.getR0200_after_resident_sme().doubleValue());
						R0200cell13.setCellStyle(numberStyle);
					} else {
						R0200cell13.setCellValue("");
						R0200cell13.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column O
					Cell R0200cell14 = row.createCell(14);
					if (record.getR0200_before_nonresident_sme() != null) {
						R0200cell14.setCellValue(record.getR0200_before_nonresident_sme().doubleValue());
						R0200cell14.setCellStyle(numberStyle);
					} else {
						R0200cell14.setCellValue("");
						R0200cell14.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column P
					Cell R0200cell15 = row.createCell(15);
					if (record.getR0200_after_nonresident_sme() != null) {
						R0200cell15.setCellValue(record.getR0200_after_nonresident_sme().doubleValue());
						R0200cell15.setCellStyle(numberStyle);
					} else {
						R0200cell15.setCellValue("");
						R0200cell15.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column Q
					Cell R0200cell16 = row.createCell(16);
					if (record.getR0200_before_resident_hni() != null) {
						R0200cell16.setCellValue(record.getR0200_before_resident_hni().doubleValue());
						R0200cell16.setCellStyle(numberStyle);
					} else {
						R0200cell16.setCellValue("");
						R0200cell16.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column R
					Cell R0200cell17 = row.createCell(17);
					if (record.getR0200_after_resident_hni() != null) {
						R0200cell17.setCellValue(record.getR0200_after_resident_hni().doubleValue());
						R0200cell17.setCellStyle(numberStyle);
					} else {
						R0200cell17.setCellValue("");
						R0200cell17.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column S
					Cell R0200cell18 = row.createCell(18);
					if (record.getR0200_before_nonresident_hni() != null) {
						R0200cell18.setCellValue(record.getR0200_before_nonresident_hni().doubleValue());
						R0200cell18.setCellStyle(numberStyle);
					} else {
						R0200cell18.setCellValue("");
						R0200cell18.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column T
					Cell R0200cell19 = row.createCell(19);
					if (record.getR0200_after_nonresident_hni() != null) {
						R0200cell19.setCellValue(record.getR0200_after_nonresident_hni().doubleValue());
						R0200cell19.setCellStyle(numberStyle);
					} else {
						R0200cell19.setCellValue("");
						R0200cell19.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column U
					Cell R0200cell20 = row.createCell(20);
					if (record.getR0200_before_resident_gre() != null) {
						R0200cell20.setCellValue(record.getR0200_before_resident_gre().doubleValue());
						R0200cell20.setCellStyle(numberStyle);
					} else {
						R0200cell20.setCellValue("");
						R0200cell20.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column V
					Cell R0200cell21 = row.createCell(21);
					if (record.getR0200_after_resident_gre() != null) {
						R0200cell21.setCellValue(record.getR0200_after_resident_gre().doubleValue());
						R0200cell21.setCellStyle(numberStyle);
					} else {
						R0200cell21.setCellValue("");
						R0200cell21.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column W
					Cell R0200cell22 = row.createCell(22);
					if (record.getR0200_before_nonresident_gre() != null) {
						R0200cell22.setCellValue(record.getR0200_before_nonresident_gre().doubleValue());
						R0200cell22.setCellStyle(numberStyle);
					} else {
						R0200cell22.setCellValue("");
						R0200cell22.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column X
					Cell R0200cell23 = row.createCell(23);
					if (record.getR0200_after_nonresident_gre() != null) {
						R0200cell23.setCellValue(record.getR0200_after_nonresident_gre().doubleValue());
						R0200cell23.setCellStyle(numberStyle);
					} else {
						R0200cell23.setCellValue("");
						R0200cell23.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column Y
					Cell R0200cell24 = row.createCell(24);
					if (record.getR0200_before_resident_corporate() != null) {
						R0200cell24.setCellValue(record.getR0200_before_resident_corporate().doubleValue());
						R0200cell24.setCellStyle(numberStyle);
					} else {
						R0200cell24.setCellValue("");
						R0200cell24.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column Z
					Cell R0200cell25 = row.createCell(25);
					if (record.getR0200_after_resident_corporate() != null) {
						R0200cell25.setCellValue(record.getR0200_after_resident_corporate().doubleValue());
						R0200cell25.setCellStyle(numberStyle);
					} else {
						R0200cell25.setCellValue("");
						R0200cell25.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AA
					Cell R0200cell26 = row.createCell(26);
					if (record.getR0200_before_nonresident_corporate() != null) {
						R0200cell26.setCellValue(record.getR0200_before_nonresident_corporate().doubleValue());
						R0200cell26.setCellStyle(numberStyle);
					} else {
						R0200cell26.setCellValue("");
						R0200cell26.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AB
					Cell R0200cell27 = row.createCell(27);
					if (record.getR0200_after_nonresident_corporate() != null) {
						R0200cell27.setCellValue(record.getR0200_after_nonresident_corporate().doubleValue());
						R0200cell27.setCellStyle(numberStyle);
					} else {
						R0200cell27.setCellValue("");
						R0200cell27.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AC
					Cell R0200cell28 = row.createCell(28);
					if (record.getR0200_before_resident_nbfi() != null) {
						R0200cell28.setCellValue(record.getR0200_before_resident_nbfi().doubleValue());
						R0200cell28.setCellStyle(numberStyle);
					} else {
						R0200cell28.setCellValue("");
						R0200cell28.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AD
					Cell R0200cell29 = row.createCell(29);
					if (record.getR0200_after_resident_nbfi() != null) {
						R0200cell29.setCellValue(record.getR0200_after_resident_nbfi().doubleValue());
						R0200cell29.setCellStyle(numberStyle);
					} else {
						R0200cell29.setCellValue("");
						R0200cell29.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AE
					Cell R0200cell30 = row.createCell(30);
					if (record.getR0200_before_nonresident_nbfi() != null) {
						R0200cell30.setCellValue(record.getR0200_before_nonresident_nbfi().doubleValue());
						R0200cell30.setCellStyle(numberStyle);
					} else {
						R0200cell30.setCellValue("");
						R0200cell30.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AF
					Cell R0200cell31 = row.createCell(31);
					if (record.getR0200_after_nonresident_nbfi() != null) {
						R0200cell31.setCellValue(record.getR0200_after_nonresident_nbfi().doubleValue());
						R0200cell31.setCellStyle(numberStyle);
					} else {
						R0200cell31.setCellValue("");
						R0200cell31.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AG
					Cell R0200cell32 = row.createCell(32);
					if (record.getR0200_before_resident_bank() != null) {
						R0200cell32.setCellValue(record.getR0200_before_resident_bank().doubleValue());
						R0200cell32.setCellStyle(numberStyle);
					} else {
						R0200cell32.setCellValue("");
						R0200cell32.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AH
					Cell R0200cell33 = row.createCell(33);
					if (record.getR0200_after_resident_bank() != null) {
						R0200cell33.setCellValue(record.getR0200_after_resident_bank().doubleValue());
						R0200cell33.setCellStyle(numberStyle);
					} else {
						R0200cell33.setCellValue("");
						R0200cell33.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AI
					Cell R0200cell34 = row.createCell(34);
					if (record.getR0200_before_nonresident_bank() != null) {
						R0200cell34.setCellValue(record.getR0200_before_nonresident_bank().doubleValue());
						R0200cell34.setCellStyle(numberStyle);
					} else {
						R0200cell34.setCellValue("");
						R0200cell34.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AJ
					Cell R0200cell35 = row.createCell(35);
					if (record.getR0200_after_nonresident_bank() != null) {
						R0200cell35.setCellValue(record.getR0200_after_nonresident_bank().doubleValue());
						R0200cell35.setCellStyle(numberStyle);
					} else {
						R0200cell35.setCellValue("");
						R0200cell35.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AK
					Cell R0200cell36 = row.createCell(36);
					if (record.getR0200_before_resident_government() != null) {
						R0200cell36.setCellValue(record.getR0200_before_resident_government().doubleValue());
						R0200cell36.setCellStyle(numberStyle);
					} else {
						R0200cell36.setCellValue("");
						R0200cell36.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AL
					Cell R0200cell37 = row.createCell(37);
					if (record.getR0200_after_resident_government() != null) {
						R0200cell37.setCellValue(record.getR0200_after_resident_government().doubleValue());
						R0200cell37.setCellStyle(numberStyle);
					} else {
						R0200cell37.setCellValue("");
						R0200cell37.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AM
					Cell R0200cell38 = row.createCell(38);
					if (record.getR0200_before_nonresident_government() != null) {
						R0200cell38.setCellValue(record.getR0200_before_nonresident_government().doubleValue());
						R0200cell38.setCellStyle(numberStyle);
					} else {
						R0200cell38.setCellValue("");
						R0200cell38.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AN
					Cell R0200cell39 = row.createCell(39);
					if (record.getR0200_after_nonresident_government() != null) {
						R0200cell39.setCellValue(record.getR0200_after_nonresident_government().doubleValue());
						R0200cell39.setCellStyle(numberStyle);
					} else {
						R0200cell39.setCellValue("");
						R0200cell39.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column E
					row = sheet.getRow(30);
					Cell R0210cell4 = row.createCell(4);
					if (record.getR0210_before_resident_individual() != null) {
						R0210cell4.setCellValue(record.getR0210_before_resident_individual().doubleValue());
						R0210cell4.setCellStyle(numberStyle);
					} else {
						R0210cell4.setCellValue("");
						R0210cell4.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column F
					Cell R0210cell5 = row.createCell(5);
					if (record.getR0210_after_resident_individual() != null) {
						R0210cell5.setCellValue(record.getR0210_after_resident_individual().doubleValue());
						R0210cell5.setCellStyle(numberStyle);
					} else {
						R0210cell5.setCellValue("");
						R0210cell5.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column G
					Cell R0210cell6 = row.createCell(6);
					if (record.getR0210_before_nonresident_individual() != null) {
						R0210cell6.setCellValue(record.getR0210_before_nonresident_individual().doubleValue());
						R0210cell6.setCellStyle(numberStyle);
					} else {
						R0210cell6.setCellValue("");
						R0210cell6.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column H
					Cell R0210cell7 = row.createCell(7);
					if (record.getR0210_after_nonresident_individual() != null) {
						R0210cell7.setCellValue(record.getR0210_after_nonresident_individual().doubleValue());
						R0210cell7.setCellStyle(numberStyle);
					} else {
						R0210cell7.setCellValue("");
						R0210cell7.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column I
					Cell R0210cell8 = row.createCell(8);
					if (record.getR0210_before_resident_retail() != null) {
						R0210cell8.setCellValue(record.getR0210_before_resident_retail().doubleValue());
						R0210cell8.setCellStyle(numberStyle);
					} else {
						R0210cell8.setCellValue("");
						R0210cell8.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column J
					Cell R0210cell9 = row.createCell(9);
					if (record.getR0210_after_resident_retail() != null) {
						R0210cell9.setCellValue(record.getR0210_after_resident_retail().doubleValue());
						R0210cell9.setCellStyle(numberStyle);
					} else {
						R0210cell9.setCellValue("");
						R0210cell9.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column K
					Cell R0210cell10 = row.createCell(10);
					if (record.getR0210_before_nonresident_retail() != null) {
						R0210cell10.setCellValue(record.getR0210_before_nonresident_retail().doubleValue());
						R0210cell10.setCellStyle(numberStyle);
					} else {
						R0210cell10.setCellValue("");
						R0210cell10.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column L
					Cell R0210cell11 = row.createCell(11);
					if (record.getR0210_after_nonresident_retail() != null) {
						R0210cell11.setCellValue(record.getR0210_after_nonresident_retail().doubleValue());
						R0210cell11.setCellStyle(numberStyle);
					} else {
						R0210cell11.setCellValue("");
						R0210cell11.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column M
					Cell R0210cell12 = row.createCell(12);
					if (record.getR0210_before_resident_sme() != null) {
						R0210cell12.setCellValue(record.getR0210_before_resident_sme().doubleValue());
						R0210cell12.setCellStyle(numberStyle);
					} else {
						R0210cell12.setCellValue("");
						R0210cell12.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column N
					Cell R0210cell13 = row.createCell(13);
					if (record.getR0210_after_resident_sme() != null) {
						R0210cell13.setCellValue(record.getR0210_after_resident_sme().doubleValue());
						R0210cell13.setCellStyle(numberStyle);
					} else {
						R0210cell13.setCellValue("");
						R0210cell13.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column O
					Cell R0210cell14 = row.createCell(14);
					if (record.getR0210_before_nonresident_sme() != null) {
						R0210cell14.setCellValue(record.getR0210_before_nonresident_sme().doubleValue());
						R0210cell14.setCellStyle(numberStyle);
					} else {
						R0210cell14.setCellValue("");
						R0210cell14.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column P
					Cell R0210cell15 = row.createCell(15);
					if (record.getR0210_after_nonresident_sme() != null) {
						R0210cell15.setCellValue(record.getR0210_after_nonresident_sme().doubleValue());
						R0210cell15.setCellStyle(numberStyle);
					} else {
						R0210cell15.setCellValue("");
						R0210cell15.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column Q
					Cell R0210cell16 = row.createCell(16);
					if (record.getR0210_before_resident_hni() != null) {
						R0210cell16.setCellValue(record.getR0210_before_resident_hni().doubleValue());
						R0210cell16.setCellStyle(numberStyle);
					} else {
						R0210cell16.setCellValue("");
						R0210cell16.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column R
					Cell R0210cell17 = row.createCell(17);
					if (record.getR0210_after_resident_hni() != null) {
						R0210cell17.setCellValue(record.getR0210_after_resident_hni().doubleValue());
						R0210cell17.setCellStyle(numberStyle);
					} else {
						R0210cell17.setCellValue("");
						R0210cell17.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column S
					Cell R0210cell18 = row.createCell(18);
					if (record.getR0210_before_nonresident_hni() != null) {
						R0210cell18.setCellValue(record.getR0210_before_nonresident_hni().doubleValue());
						R0210cell18.setCellStyle(numberStyle);
					} else {
						R0210cell18.setCellValue("");
						R0210cell18.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column T
					Cell R0210cell19 = row.createCell(19);
					if (record.getR0210_after_nonresident_hni() != null) {
						R0210cell19.setCellValue(record.getR0210_after_nonresident_hni().doubleValue());
						R0210cell19.setCellStyle(numberStyle);
					} else {
						R0210cell19.setCellValue("");
						R0210cell19.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column U
					Cell R0210cell20 = row.createCell(20);
					if (record.getR0210_before_resident_gre() != null) {
						R0210cell20.setCellValue(record.getR0210_before_resident_gre().doubleValue());
						R0210cell20.setCellStyle(numberStyle);
					} else {
						R0210cell20.setCellValue("");
						R0210cell20.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column V
					Cell R0210cell21 = row.createCell(21);
					if (record.getR0210_after_resident_gre() != null) {
						R0210cell21.setCellValue(record.getR0210_after_resident_gre().doubleValue());
						R0210cell21.setCellStyle(numberStyle);
					} else {
						R0210cell21.setCellValue("");
						R0210cell21.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column W
					Cell R0210cell22 = row.createCell(22);
					if (record.getR0210_before_nonresident_gre() != null) {
						R0210cell22.setCellValue(record.getR0210_before_nonresident_gre().doubleValue());
						R0210cell22.setCellStyle(numberStyle);
					} else {
						R0210cell22.setCellValue("");
						R0210cell22.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column X
					Cell R0210cell23 = row.createCell(23);
					if (record.getR0210_after_nonresident_gre() != null) {
						R0210cell23.setCellValue(record.getR0210_after_nonresident_gre().doubleValue());
						R0210cell23.setCellStyle(numberStyle);
					} else {
						R0210cell23.setCellValue("");
						R0210cell23.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column Y
					Cell R0210cell24 = row.createCell(24);
					if (record.getR0210_before_resident_corporate() != null) {
						R0210cell24.setCellValue(record.getR0210_before_resident_corporate().doubleValue());
						R0210cell24.setCellStyle(numberStyle);
					} else {
						R0210cell24.setCellValue("");
						R0210cell24.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column Z
					Cell R0210cell25 = row.createCell(25);
					if (record.getR0210_after_resident_corporate() != null) {
						R0210cell25.setCellValue(record.getR0210_after_resident_corporate().doubleValue());
						R0210cell25.setCellStyle(numberStyle);
					} else {
						R0210cell25.setCellValue("");
						R0210cell25.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AA
					Cell R0210cell26 = row.createCell(26);
					if (record.getR0210_before_nonresident_corporate() != null) {
						R0210cell26.setCellValue(record.getR0210_before_nonresident_corporate().doubleValue());
						R0210cell26.setCellStyle(numberStyle);
					} else {
						R0210cell26.setCellValue("");
						R0210cell26.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AB
					Cell R0210cell27 = row.createCell(27);
					if (record.getR0210_after_nonresident_corporate() != null) {
						R0210cell27.setCellValue(record.getR0210_after_nonresident_corporate().doubleValue());
						R0210cell27.setCellStyle(numberStyle);
					} else {
						R0210cell27.setCellValue("");
						R0210cell27.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AC
					Cell R0210cell28 = row.createCell(28);
					if (record.getR0210_before_resident_nbfi() != null) {
						R0210cell28.setCellValue(record.getR0210_before_resident_nbfi().doubleValue());
						R0210cell28.setCellStyle(numberStyle);
					} else {
						R0210cell28.setCellValue("");
						R0210cell28.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AD
					Cell R0210cell29 = row.createCell(29);
					if (record.getR0210_after_resident_nbfi() != null) {
						R0210cell29.setCellValue(record.getR0210_after_resident_nbfi().doubleValue());
						R0210cell29.setCellStyle(numberStyle);
					} else {
						R0210cell29.setCellValue("");
						R0210cell29.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AE
					Cell R0210cell30 = row.createCell(30);
					if (record.getR0210_before_nonresident_nbfi() != null) {
						R0210cell30.setCellValue(record.getR0210_before_nonresident_nbfi().doubleValue());
						R0210cell30.setCellStyle(numberStyle);
					} else {
						R0210cell30.setCellValue("");
						R0210cell30.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AF
					Cell R0210cell31 = row.createCell(31);
					if (record.getR0210_after_nonresident_nbfi() != null) {
						R0210cell31.setCellValue(record.getR0210_after_nonresident_nbfi().doubleValue());
						R0210cell31.setCellStyle(numberStyle);
					} else {
						R0210cell31.setCellValue("");
						R0210cell31.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AG
					Cell R0210cell32 = row.createCell(32);
					if (record.getR0210_before_resident_bank() != null) {
						R0210cell32.setCellValue(record.getR0210_before_resident_bank().doubleValue());
						R0210cell32.setCellStyle(numberStyle);
					} else {
						R0210cell32.setCellValue("");
						R0210cell32.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AH
					Cell R0210cell33 = row.createCell(33);
					if (record.getR0210_after_resident_bank() != null) {
						R0210cell33.setCellValue(record.getR0210_after_resident_bank().doubleValue());
						R0210cell33.setCellStyle(numberStyle);
					} else {
						R0210cell33.setCellValue("");
						R0210cell33.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AI
					Cell R0210cell34 = row.createCell(34);
					if (record.getR0210_before_nonresident_bank() != null) {
						R0210cell34.setCellValue(record.getR0210_before_nonresident_bank().doubleValue());
						R0210cell34.setCellStyle(numberStyle);
					} else {
						R0210cell34.setCellValue("");
						R0210cell34.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AJ
					Cell R0210cell35 = row.createCell(35);
					if (record.getR0210_after_nonresident_bank() != null) {
						R0210cell35.setCellValue(record.getR0210_after_nonresident_bank().doubleValue());
						R0210cell35.setCellStyle(numberStyle);
					} else {
						R0210cell35.setCellValue("");
						R0210cell35.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AK
					Cell R0210cell36 = row.createCell(36);
					if (record.getR0210_before_resident_government() != null) {
						R0210cell36.setCellValue(record.getR0210_before_resident_government().doubleValue());
						R0210cell36.setCellStyle(numberStyle);
					} else {
						R0210cell36.setCellValue("");
						R0210cell36.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AL
					Cell R0210cell37 = row.createCell(37);
					if (record.getR0210_after_resident_government() != null) {
						R0210cell37.setCellValue(record.getR0210_after_resident_government().doubleValue());
						R0210cell37.setCellStyle(numberStyle);
					} else {
						R0210cell37.setCellValue("");
						R0210cell37.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AM
					Cell R0210cell38 = row.createCell(38);
					if (record.getR0210_before_nonresident_government() != null) {
						R0210cell38.setCellValue(record.getR0210_before_nonresident_government().doubleValue());
						R0210cell38.setCellStyle(numberStyle);
					} else {
						R0210cell38.setCellValue("");
						R0210cell38.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AN
					Cell R0210cell39 = row.createCell(39);
					if (record.getR0210_after_nonresident_government() != null) {
						R0210cell39.setCellValue(record.getR0210_after_nonresident_government().doubleValue());
						R0210cell39.setCellStyle(numberStyle);
					} else {
						R0210cell39.setCellValue("");
						R0210cell39.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column E
					row = sheet.getRow(31);
					Cell R0220cell4 = row.createCell(4);
					if (record.getR0220_before_resident_individual() != null) {
						R0220cell4.setCellValue(record.getR0220_before_resident_individual().doubleValue());
						R0220cell4.setCellStyle(numberStyle);
					} else {
						R0220cell4.setCellValue("");
						R0220cell4.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column F
					Cell R0220cell5 = row.createCell(5);
					if (record.getR0220_after_resident_individual() != null) {
						R0220cell5.setCellValue(record.getR0220_after_resident_individual().doubleValue());
						R0220cell5.setCellStyle(numberStyle);
					} else {
						R0220cell5.setCellValue("");
						R0220cell5.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column G
					Cell R0220cell6 = row.createCell(6);
					if (record.getR0220_before_nonresident_individual() != null) {
						R0220cell6.setCellValue(record.getR0220_before_nonresident_individual().doubleValue());
						R0220cell6.setCellStyle(numberStyle);
					} else {
						R0220cell6.setCellValue("");
						R0220cell6.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column H
					Cell R0220cell7 = row.createCell(7);
					if (record.getR0220_after_nonresident_individual() != null) {
						R0220cell7.setCellValue(record.getR0220_after_nonresident_individual().doubleValue());
						R0220cell7.setCellStyle(numberStyle);
					} else {
						R0220cell7.setCellValue("");
						R0220cell7.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column I
					Cell R0220cell8 = row.createCell(8);
					if (record.getR0220_before_resident_retail() != null) {
						R0220cell8.setCellValue(record.getR0220_before_resident_retail().doubleValue());
						R0220cell8.setCellStyle(numberStyle);
					} else {
						R0220cell8.setCellValue("");
						R0220cell8.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column J
					Cell R0220cell9 = row.createCell(9);
					if (record.getR0220_after_resident_retail() != null) {
						R0220cell9.setCellValue(record.getR0220_after_resident_retail().doubleValue());
						R0220cell9.setCellStyle(numberStyle);
					} else {
						R0220cell9.setCellValue("");
						R0220cell9.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column K
					Cell R0220cell10 = row.createCell(10);
					if (record.getR0220_before_nonresident_retail() != null) {
						R0220cell10.setCellValue(record.getR0220_before_nonresident_retail().doubleValue());
						R0220cell10.setCellStyle(numberStyle);
					} else {
						R0220cell10.setCellValue("");
						R0220cell10.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column L
					Cell R0220cell11 = row.createCell(11);
					if (record.getR0220_after_nonresident_retail() != null) {
						R0220cell11.setCellValue(record.getR0220_after_nonresident_retail().doubleValue());
						R0220cell11.setCellStyle(numberStyle);
					} else {
						R0220cell11.setCellValue("");
						R0220cell11.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column M
					Cell R0220cell12 = row.createCell(12);
					if (record.getR0220_before_resident_sme() != null) {
						R0220cell12.setCellValue(record.getR0220_before_resident_sme().doubleValue());
						R0220cell12.setCellStyle(numberStyle);
					} else {
						R0220cell12.setCellValue("");
						R0220cell12.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column N
					Cell R0220cell13 = row.createCell(13);
					if (record.getR0220_after_resident_sme() != null) {
						R0220cell13.setCellValue(record.getR0220_after_resident_sme().doubleValue());
						R0220cell13.setCellStyle(numberStyle);
					} else {
						R0220cell13.setCellValue("");
						R0220cell13.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column O
					Cell R0220cell14 = row.createCell(14);
					if (record.getR0220_before_nonresident_sme() != null) {
						R0220cell14.setCellValue(record.getR0220_before_nonresident_sme().doubleValue());
						R0220cell14.setCellStyle(numberStyle);
					} else {
						R0220cell14.setCellValue("");
						R0220cell14.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column P
					Cell R0220cell15 = row.createCell(15);
					if (record.getR0220_after_nonresident_sme() != null) {
						R0220cell15.setCellValue(record.getR0220_after_nonresident_sme().doubleValue());
						R0220cell15.setCellStyle(numberStyle);
					} else {
						R0220cell15.setCellValue("");
						R0220cell15.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column Q
					Cell R0220cell16 = row.createCell(16);
					if (record.getR0220_before_resident_hni() != null) {
						R0220cell16.setCellValue(record.getR0220_before_resident_hni().doubleValue());
						R0220cell16.setCellStyle(numberStyle);
					} else {
						R0220cell16.setCellValue("");
						R0220cell16.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column R
					Cell R0220cell17 = row.createCell(17);
					if (record.getR0220_after_resident_hni() != null) {
						R0220cell17.setCellValue(record.getR0220_after_resident_hni().doubleValue());
						R0220cell17.setCellStyle(numberStyle);
					} else {
						R0220cell17.setCellValue("");
						R0220cell17.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column S
					Cell R0220cell18 = row.createCell(18);
					if (record.getR0220_before_nonresident_hni() != null) {
						R0220cell18.setCellValue(record.getR0220_before_nonresident_hni().doubleValue());
						R0220cell18.setCellStyle(numberStyle);
					} else {
						R0220cell18.setCellValue("");
						R0220cell18.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column T
					Cell R0220cell19 = row.createCell(19);
					if (record.getR0220_after_nonresident_hni() != null) {
						R0220cell19.setCellValue(record.getR0220_after_nonresident_hni().doubleValue());
						R0220cell19.setCellStyle(numberStyle);
					} else {
						R0220cell19.setCellValue("");
						R0220cell19.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column U
					Cell R0220cell20 = row.createCell(20);
					if (record.getR0220_before_resident_gre() != null) {
						R0220cell20.setCellValue(record.getR0220_before_resident_gre().doubleValue());
						R0220cell20.setCellStyle(numberStyle);
					} else {
						R0220cell20.setCellValue("");
						R0220cell20.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column V
					Cell R0220cell21 = row.createCell(21);
					if (record.getR0220_after_resident_gre() != null) {
						R0220cell21.setCellValue(record.getR0220_after_resident_gre().doubleValue());
						R0220cell21.setCellStyle(numberStyle);
					} else {
						R0220cell21.setCellValue("");
						R0220cell21.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column W
					Cell R0220cell22 = row.createCell(22);
					if (record.getR0220_before_nonresident_gre() != null) {
						R0220cell22.setCellValue(record.getR0220_before_nonresident_gre().doubleValue());
						R0220cell22.setCellStyle(numberStyle);
					} else {
						R0220cell22.setCellValue("");
						R0220cell22.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column X
					Cell R0220cell23 = row.createCell(23);
					if (record.getR0220_after_nonresident_gre() != null) {
						R0220cell23.setCellValue(record.getR0220_after_nonresident_gre().doubleValue());
						R0220cell23.setCellStyle(numberStyle);
					} else {
						R0220cell23.setCellValue("");
						R0220cell23.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column Y
					Cell R0220cell24 = row.createCell(24);
					if (record.getR0220_before_resident_corporate() != null) {
						R0220cell24.setCellValue(record.getR0220_before_resident_corporate().doubleValue());
						R0220cell24.setCellStyle(numberStyle);
					} else {
						R0220cell24.setCellValue("");
						R0220cell24.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column Z
					Cell R0220cell25 = row.createCell(25);
					if (record.getR0220_after_resident_corporate() != null) {
						R0220cell25.setCellValue(record.getR0220_after_resident_corporate().doubleValue());
						R0220cell25.setCellStyle(numberStyle);
					} else {
						R0220cell25.setCellValue("");
						R0220cell25.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AA
					Cell R0220cell26 = row.createCell(26);
					if (record.getR0220_before_nonresident_corporate() != null) {
						R0220cell26.setCellValue(record.getR0220_before_nonresident_corporate().doubleValue());
						R0220cell26.setCellStyle(numberStyle);
					} else {
						R0220cell26.setCellValue("");
						R0220cell26.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AB
					Cell R0220cell27 = row.createCell(27);
					if (record.getR0220_after_nonresident_corporate() != null) {
						R0220cell27.setCellValue(record.getR0220_after_nonresident_corporate().doubleValue());
						R0220cell27.setCellStyle(numberStyle);
					} else {
						R0220cell27.setCellValue("");
						R0220cell27.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AC
					Cell R0220cell28 = row.createCell(28);
					if (record.getR0220_before_resident_nbfi() != null) {
						R0220cell28.setCellValue(record.getR0220_before_resident_nbfi().doubleValue());
						R0220cell28.setCellStyle(numberStyle);
					} else {
						R0220cell28.setCellValue("");
						R0220cell28.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AD
					Cell R0220cell29 = row.createCell(29);
					if (record.getR0220_after_resident_nbfi() != null) {
						R0220cell29.setCellValue(record.getR0220_after_resident_nbfi().doubleValue());
						R0220cell29.setCellStyle(numberStyle);
					} else {
						R0220cell29.setCellValue("");
						R0220cell29.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AE
					Cell R0220cell30 = row.createCell(30);
					if (record.getR0220_before_nonresident_nbfi() != null) {
						R0220cell30.setCellValue(record.getR0220_before_nonresident_nbfi().doubleValue());
						R0220cell30.setCellStyle(numberStyle);
					} else {
						R0220cell30.setCellValue("");
						R0220cell30.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AF
					Cell R0220cell31 = row.createCell(31);
					if (record.getR0220_after_nonresident_nbfi() != null) {
						R0220cell31.setCellValue(record.getR0220_after_nonresident_nbfi().doubleValue());
						R0220cell31.setCellStyle(numberStyle);
					} else {
						R0220cell31.setCellValue("");
						R0220cell31.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AG
					Cell R0220cell32 = row.createCell(32);
					if (record.getR0220_before_resident_bank() != null) {
						R0220cell32.setCellValue(record.getR0220_before_resident_bank().doubleValue());
						R0220cell32.setCellStyle(numberStyle);
					} else {
						R0220cell32.setCellValue("");
						R0220cell32.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AH
					Cell R0220cell33 = row.createCell(33);
					if (record.getR0220_after_resident_bank() != null) {
						R0220cell33.setCellValue(record.getR0220_after_resident_bank().doubleValue());
						R0220cell33.setCellStyle(numberStyle);
					} else {
						R0220cell33.setCellValue("");
						R0220cell33.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AI
					Cell R0220cell34 = row.createCell(34);
					if (record.getR0220_before_nonresident_bank() != null) {
						R0220cell34.setCellValue(record.getR0220_before_nonresident_bank().doubleValue());
						R0220cell34.setCellStyle(numberStyle);
					} else {
						R0220cell34.setCellValue("");
						R0220cell34.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AJ
					Cell R0220cell35 = row.createCell(35);
					if (record.getR0220_after_nonresident_bank() != null) {
						R0220cell35.setCellValue(record.getR0220_after_nonresident_bank().doubleValue());
						R0220cell35.setCellStyle(numberStyle);
					} else {
						R0220cell35.setCellValue("");
						R0220cell35.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AK
					Cell R0220cell36 = row.createCell(36);
					if (record.getR0220_before_resident_government() != null) {
						R0220cell36.setCellValue(record.getR0220_before_resident_government().doubleValue());
						R0220cell36.setCellStyle(numberStyle);
					} else {
						R0220cell36.setCellValue("");
						R0220cell36.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AL
					Cell R0220cell37 = row.createCell(37);
					if (record.getR0220_after_resident_government() != null) {
						R0220cell37.setCellValue(record.getR0220_after_resident_government().doubleValue());
						R0220cell37.setCellStyle(numberStyle);
					} else {
						R0220cell37.setCellValue("");
						R0220cell37.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AM
					Cell R0220cell38 = row.createCell(38);
					if (record.getR0220_before_nonresident_government() != null) {
						R0220cell38.setCellValue(record.getR0220_before_nonresident_government().doubleValue());
						R0220cell38.setCellStyle(numberStyle);
					} else {
						R0220cell38.setCellValue("");
						R0220cell38.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AN
					Cell R0220cell39 = row.createCell(39);
					if (record.getR0220_after_nonresident_government() != null) {
						R0220cell39.setCellValue(record.getR0220_after_nonresident_government().doubleValue());
						R0220cell39.setCellStyle(numberStyle);
					} else {
						R0220cell39.setCellValue("");
						R0220cell39.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column E
					row = sheet.getRow(32);
					Cell R0230cell4 = row.createCell(4);
					if (record.getR0230_before_resident_individual() != null) {
						R0230cell4.setCellValue(record.getR0230_before_resident_individual().doubleValue());
						R0230cell4.setCellStyle(numberStyle);
					} else {
						R0230cell4.setCellValue("");
						R0230cell4.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column F
					Cell R0230cell5 = row.createCell(5);
					if (record.getR0230_after_resident_individual() != null) {
						R0230cell5.setCellValue(record.getR0230_after_resident_individual().doubleValue());
						R0230cell5.setCellStyle(numberStyle);
					} else {
						R0230cell5.setCellValue("");
						R0230cell5.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column G
					Cell R0230cell6 = row.createCell(6);
					if (record.getR0230_before_nonresident_individual() != null) {
						R0230cell6.setCellValue(record.getR0230_before_nonresident_individual().doubleValue());
						R0230cell6.setCellStyle(numberStyle);
					} else {
						R0230cell6.setCellValue("");
						R0230cell6.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column H
					Cell R0230cell7 = row.createCell(7);
					if (record.getR0230_after_nonresident_individual() != null) {
						R0230cell7.setCellValue(record.getR0230_after_nonresident_individual().doubleValue());
						R0230cell7.setCellStyle(numberStyle);
					} else {
						R0230cell7.setCellValue("");
						R0230cell7.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column I
					Cell R0230cell8 = row.createCell(8);
					if (record.getR0230_before_resident_retail() != null) {
						R0230cell8.setCellValue(record.getR0230_before_resident_retail().doubleValue());
						R0230cell8.setCellStyle(numberStyle);
					} else {
						R0230cell8.setCellValue("");
						R0230cell8.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column J
					Cell R0230cell9 = row.createCell(9);
					if (record.getR0230_after_resident_retail() != null) {
						R0230cell9.setCellValue(record.getR0230_after_resident_retail().doubleValue());
						R0230cell9.setCellStyle(numberStyle);
					} else {
						R0230cell9.setCellValue("");
						R0230cell9.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column K
					Cell R0230cell10 = row.createCell(10);
					if (record.getR0230_before_nonresident_retail() != null) {
						R0230cell10.setCellValue(record.getR0230_before_nonresident_retail().doubleValue());
						R0230cell10.setCellStyle(numberStyle);
					} else {
						R0230cell10.setCellValue("");
						R0230cell10.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column L
					Cell R0230cell11 = row.createCell(11);
					if (record.getR0230_after_nonresident_retail() != null) {
						R0230cell11.setCellValue(record.getR0230_after_nonresident_retail().doubleValue());
						R0230cell11.setCellStyle(numberStyle);
					} else {
						R0230cell11.setCellValue("");
						R0230cell11.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column M
					Cell R0230cell12 = row.createCell(12);
					if (record.getR0230_before_resident_sme() != null) {
						R0230cell12.setCellValue(record.getR0230_before_resident_sme().doubleValue());
						R0230cell12.setCellStyle(numberStyle);
					} else {
						R0230cell12.setCellValue("");
						R0230cell12.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column N
					Cell R0230cell13 = row.createCell(13);
					if (record.getR0230_after_resident_sme() != null) {
						R0230cell13.setCellValue(record.getR0230_after_resident_sme().doubleValue());
						R0230cell13.setCellStyle(numberStyle);
					} else {
						R0230cell13.setCellValue("");
						R0230cell13.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column O
					Cell R0230cell14 = row.createCell(14);
					if (record.getR0230_before_nonresident_sme() != null) {
						R0230cell14.setCellValue(record.getR0230_before_nonresident_sme().doubleValue());
						R0230cell14.setCellStyle(numberStyle);
					} else {
						R0230cell14.setCellValue("");
						R0230cell14.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column P
					Cell R0230cell15 = row.createCell(15);
					if (record.getR0230_after_nonresident_sme() != null) {
						R0230cell15.setCellValue(record.getR0230_after_nonresident_sme().doubleValue());
						R0230cell15.setCellStyle(numberStyle);
					} else {
						R0230cell15.setCellValue("");
						R0230cell15.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column Q
					Cell R0230cell16 = row.createCell(16);
					if (record.getR0230_before_resident_hni() != null) {
						R0230cell16.setCellValue(record.getR0230_before_resident_hni().doubleValue());
						R0230cell16.setCellStyle(numberStyle);
					} else {
						R0230cell16.setCellValue("");
						R0230cell16.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column R
					Cell R0230cell17 = row.createCell(17);
					if (record.getR0230_after_resident_hni() != null) {
						R0230cell17.setCellValue(record.getR0230_after_resident_hni().doubleValue());
						R0230cell17.setCellStyle(numberStyle);
					} else {
						R0230cell17.setCellValue("");
						R0230cell17.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column S
					Cell R0230cell18 = row.createCell(18);
					if (record.getR0230_before_nonresident_hni() != null) {
						R0230cell18.setCellValue(record.getR0230_before_nonresident_hni().doubleValue());
						R0230cell18.setCellStyle(numberStyle);
					} else {
						R0230cell18.setCellValue("");
						R0230cell18.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column T
					Cell R0230cell19 = row.createCell(19);
					if (record.getR0230_after_nonresident_hni() != null) {
						R0230cell19.setCellValue(record.getR0230_after_nonresident_hni().doubleValue());
						R0230cell19.setCellStyle(numberStyle);
					} else {
						R0230cell19.setCellValue("");
						R0230cell19.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column U
					Cell R0230cell20 = row.createCell(20);
					if (record.getR0230_before_resident_gre() != null) {
						R0230cell20.setCellValue(record.getR0230_before_resident_gre().doubleValue());
						R0230cell20.setCellStyle(numberStyle);
					} else {
						R0230cell20.setCellValue("");
						R0230cell20.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column V
					Cell R0230cell21 = row.createCell(21);
					if (record.getR0230_after_resident_gre() != null) {
						R0230cell21.setCellValue(record.getR0230_after_resident_gre().doubleValue());
						R0230cell21.setCellStyle(numberStyle);
					} else {
						R0230cell21.setCellValue("");
						R0230cell21.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column W
					Cell R0230cell22 = row.createCell(22);
					if (record.getR0230_before_nonresident_gre() != null) {
						R0230cell22.setCellValue(record.getR0230_before_nonresident_gre().doubleValue());
						R0230cell22.setCellStyle(numberStyle);
					} else {
						R0230cell22.setCellValue("");
						R0230cell22.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column X
					Cell R0230cell23 = row.createCell(23);
					if (record.getR0230_after_nonresident_gre() != null) {
						R0230cell23.setCellValue(record.getR0230_after_nonresident_gre().doubleValue());
						R0230cell23.setCellStyle(numberStyle);
					} else {
						R0230cell23.setCellValue("");
						R0230cell23.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column Y
					Cell R0230cell24 = row.createCell(24);
					if (record.getR0230_before_resident_corporate() != null) {
						R0230cell24.setCellValue(record.getR0230_before_resident_corporate().doubleValue());
						R0230cell24.setCellStyle(numberStyle);
					} else {
						R0230cell24.setCellValue("");
						R0230cell24.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column Z
					Cell R0230cell25 = row.createCell(25);
					if (record.getR0230_after_resident_corporate() != null) {
						R0230cell25.setCellValue(record.getR0230_after_resident_corporate().doubleValue());
						R0230cell25.setCellStyle(numberStyle);
					} else {
						R0230cell25.setCellValue("");
						R0230cell25.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AA
					Cell R0230cell26 = row.createCell(26);
					if (record.getR0230_before_nonresident_corporate() != null) {
						R0230cell26.setCellValue(record.getR0230_before_nonresident_corporate().doubleValue());
						R0230cell26.setCellStyle(numberStyle);
					} else {
						R0230cell26.setCellValue("");
						R0230cell26.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AB
					Cell R0230cell27 = row.createCell(27);
					if (record.getR0230_after_nonresident_corporate() != null) {
						R0230cell27.setCellValue(record.getR0230_after_nonresident_corporate().doubleValue());
						R0230cell27.setCellStyle(numberStyle);
					} else {
						R0230cell27.setCellValue("");
						R0230cell27.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AC
					Cell R0230cell28 = row.createCell(28);
					if (record.getR0230_before_resident_nbfi() != null) {
						R0230cell28.setCellValue(record.getR0230_before_resident_nbfi().doubleValue());
						R0230cell28.setCellStyle(numberStyle);
					} else {
						R0230cell28.setCellValue("");
						R0230cell28.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AD
					Cell R0230cell29 = row.createCell(29);
					if (record.getR0230_after_resident_nbfi() != null) {
						R0230cell29.setCellValue(record.getR0230_after_resident_nbfi().doubleValue());
						R0230cell29.setCellStyle(numberStyle);
					} else {
						R0230cell29.setCellValue("");
						R0230cell29.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AE
					Cell R0230cell30 = row.createCell(30);
					if (record.getR0230_before_nonresident_nbfi() != null) {
						R0230cell30.setCellValue(record.getR0230_before_nonresident_nbfi().doubleValue());
						R0230cell30.setCellStyle(numberStyle);
					} else {
						R0230cell30.setCellValue("");
						R0230cell30.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AF
					Cell R0230cell31 = row.createCell(31);
					if (record.getR0230_after_nonresident_nbfi() != null) {
						R0230cell31.setCellValue(record.getR0230_after_nonresident_nbfi().doubleValue());
						R0230cell31.setCellStyle(numberStyle);
					} else {
						R0230cell31.setCellValue("");
						R0230cell31.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AG
					Cell R0230cell32 = row.createCell(32);
					if (record.getR0230_before_resident_bank() != null) {
						R0230cell32.setCellValue(record.getR0230_before_resident_bank().doubleValue());
						R0230cell32.setCellStyle(numberStyle);
					} else {
						R0230cell32.setCellValue("");
						R0230cell32.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AH
					Cell R0230cell33 = row.createCell(33);
					if (record.getR0230_after_resident_bank() != null) {
						R0230cell33.setCellValue(record.getR0230_after_resident_bank().doubleValue());
						R0230cell33.setCellStyle(numberStyle);
					} else {
						R0230cell33.setCellValue("");
						R0230cell33.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AI
					Cell R0230cell34 = row.createCell(34);
					if (record.getR0230_before_nonresident_bank() != null) {
						R0230cell34.setCellValue(record.getR0230_before_nonresident_bank().doubleValue());
						R0230cell34.setCellStyle(numberStyle);
					} else {
						R0230cell34.setCellValue("");
						R0230cell34.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AJ
					Cell R0230cell35 = row.createCell(35);
					if (record.getR0230_after_nonresident_bank() != null) {
						R0230cell35.setCellValue(record.getR0230_after_nonresident_bank().doubleValue());
						R0230cell35.setCellStyle(numberStyle);
					} else {
						R0230cell35.setCellValue("");
						R0230cell35.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AK
					Cell R0230cell36 = row.createCell(36);
					if (record.getR0230_before_resident_government() != null) {
						R0230cell36.setCellValue(record.getR0230_before_resident_government().doubleValue());
						R0230cell36.setCellStyle(numberStyle);
					} else {
						R0230cell36.setCellValue("");
						R0230cell36.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AL
					Cell R0230cell37 = row.createCell(37);
					if (record.getR0230_after_resident_government() != null) {
						R0230cell37.setCellValue(record.getR0230_after_resident_government().doubleValue());
						R0230cell37.setCellStyle(numberStyle);
					} else {
						R0230cell37.setCellValue("");
						R0230cell37.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AM
					Cell R0230cell38 = row.createCell(38);
					if (record.getR0230_before_nonresident_government() != null) {
						R0230cell38.setCellValue(record.getR0230_before_nonresident_government().doubleValue());
						R0230cell38.setCellStyle(numberStyle);
					} else {
						R0230cell38.setCellValue("");
						R0230cell38.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AN
					Cell R0230cell39 = row.createCell(39);
					if (record.getR0230_after_nonresident_government() != null) {
						R0230cell39.setCellValue(record.getR0230_after_nonresident_government().doubleValue());
						R0230cell39.setCellStyle(numberStyle);
					} else {
						R0230cell39.setCellValue("");
						R0230cell39.setCellStyle(textStyle);
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

	public List<Object> getBRF5_17Archival() {
		List<Object> BRF5_17Archivallist = new ArrayList<>();
		try {
			BRF5_17Archivallist = BRF5_17_Summary_Archival_Repo.getBRF5_17archival();
			System.out.println("countser" + BRF5_17Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF5_17 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF5_17Archivallist;
	}

	public byte[] getBRF5_17ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		List<CBUAE_BRF5_17_Summary_Archival_Entity> dataList = BRF5_17_Summary_Archival_Repo
				.getdatabydateListarchival(dateformat.parse(todate), version);

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF5.17 report. Returning empty result.");
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

			int startRow = 11;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF5_17_Summary_Archival_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					/// ROW12
					//// Column E
					Cell cell4 = row.createCell(4);
					if (record.getR0020_before_resident_individual() != null) {
						cell4.setCellValue(record.getR0020_before_resident_individual().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column F
					Cell cell5 = row.createCell(5);
					if (record.getR0020_after_resident_individual() != null) {
						cell5.setCellValue(record.getR0020_after_resident_individual().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column G
					Cell cell6 = row.createCell(6);
					if (record.getR0020_before_nonresident_individual() != null) {
						cell6.setCellValue(record.getR0020_before_nonresident_individual().doubleValue());
						cell6.setCellStyle(numberStyle);
					} else {
						cell6.setCellValue("");
						cell6.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column H
					Cell cell7 = row.createCell(7);
					if (record.getR0020_after_nonresident_individual() != null) {
						cell7.setCellValue(record.getR0020_after_nonresident_individual().doubleValue());
						cell7.setCellStyle(numberStyle);
					} else {
						cell7.setCellValue("");
						cell7.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column I
					Cell cell8 = row.createCell(8);
					if (record.getR0020_before_resident_retail() != null) {
						cell8.setCellValue(record.getR0020_before_resident_retail().doubleValue());
						cell8.setCellStyle(numberStyle);
					} else {
						cell8.setCellValue("");
						cell8.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column J
					Cell cell9 = row.createCell(9);
					if (record.getR0020_after_resident_retail() != null) {
						cell9.setCellValue(record.getR0020_after_resident_retail().doubleValue());
						cell9.setCellStyle(numberStyle);
					} else {
						cell9.setCellValue("");
						cell9.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column K
					Cell cell10 = row.createCell(10);
					if (record.getR0020_before_nonresident_retail() != null) {
						cell10.setCellValue(record.getR0020_before_nonresident_retail().doubleValue());
						cell10.setCellStyle(numberStyle);
					} else {
						cell10.setCellValue("");
						cell10.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column L
					Cell cell11 = row.createCell(11);
					if (record.getR0020_after_nonresident_retail() != null) {
						cell11.setCellValue(record.getR0020_after_nonresident_retail().doubleValue());
						cell11.setCellStyle(numberStyle);
					} else {
						cell11.setCellValue("");
						cell11.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column M
					Cell cell12 = row.createCell(12);
					if (record.getR0020_before_resident_sme() != null) {
						cell12.setCellValue(record.getR0020_before_resident_sme().doubleValue());
						cell12.setCellStyle(numberStyle);
					} else {
						cell12.setCellValue("");
						cell12.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column N
					Cell cell13 = row.createCell(13);
					if (record.getR0020_after_resident_sme() != null) {
						cell13.setCellValue(record.getR0020_after_resident_sme().doubleValue());
						cell13.setCellStyle(numberStyle);
					} else {
						cell13.setCellValue("");
						cell13.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column O
					Cell cell14 = row.createCell(14);
					if (record.getR0020_before_nonresident_sme() != null) {
						cell14.setCellValue(record.getR0020_before_nonresident_sme().doubleValue());
						cell14.setCellStyle(numberStyle);
					} else {
						cell14.setCellValue("");
						cell14.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column P
					Cell cell15 = row.createCell(15);
					if (record.getR0020_after_nonresident_sme() != null) {
						cell15.setCellValue(record.getR0020_after_nonresident_sme().doubleValue());
						cell15.setCellStyle(numberStyle);
					} else {
						cell15.setCellValue("");
						cell15.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column Q
					Cell cell16 = row.createCell(16);
					if (record.getR0020_before_resident_hni() != null) {
						cell16.setCellValue(record.getR0020_before_resident_hni().doubleValue());
						cell16.setCellStyle(numberStyle);
					} else {
						cell16.setCellValue("");
						cell16.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column R
					Cell cell17 = row.createCell(17);
					if (record.getR0020_after_resident_hni() != null) {
						cell17.setCellValue(record.getR0020_after_resident_hni().doubleValue());
						cell17.setCellStyle(numberStyle);
					} else {
						cell17.setCellValue("");
						cell17.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column S
					Cell cell18 = row.createCell(18);
					if (record.getR0020_before_nonresident_hni() != null) {
						cell18.setCellValue(record.getR0020_before_nonresident_hni().doubleValue());
						cell18.setCellStyle(numberStyle);
					} else {
						cell18.setCellValue("");
						cell18.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column T
					Cell cell19 = row.createCell(19);
					if (record.getR0020_after_nonresident_hni() != null) {
						cell19.setCellValue(record.getR0020_after_nonresident_hni().doubleValue());
						cell19.setCellStyle(numberStyle);
					} else {
						cell19.setCellValue("");
						cell19.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column U
					Cell cell20 = row.createCell(20);
					if (record.getR0020_before_resident_gre() != null) {
						cell20.setCellValue(record.getR0020_before_resident_gre().doubleValue());
						cell20.setCellStyle(numberStyle);
					} else {
						cell20.setCellValue("");
						cell20.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column V
					Cell cell21 = row.createCell(21);
					if (record.getR0020_after_resident_gre() != null) {
						cell21.setCellValue(record.getR0020_after_resident_gre().doubleValue());
						cell21.setCellStyle(numberStyle);
					} else {
						cell21.setCellValue("");
						cell21.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column W
					Cell cell22 = row.createCell(22);
					if (record.getR0020_before_nonresident_gre() != null) {
						cell22.setCellValue(record.getR0020_before_nonresident_gre().doubleValue());
						cell22.setCellStyle(numberStyle);
					} else {
						cell22.setCellValue("");
						cell22.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column X
					Cell cell23 = row.createCell(23);
					if (record.getR0020_after_nonresident_gre() != null) {
						cell23.setCellValue(record.getR0020_after_nonresident_gre().doubleValue());
						cell23.setCellStyle(numberStyle);
					} else {
						cell23.setCellValue("");
						cell23.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column Y
					Cell cell24 = row.createCell(24);
					if (record.getR0020_before_resident_corporate() != null) {
						cell24.setCellValue(record.getR0020_before_resident_corporate().doubleValue());
						cell24.setCellStyle(numberStyle);
					} else {
						cell24.setCellValue("");
						cell24.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column Z
					Cell cell25 = row.createCell(25);
					if (record.getR0020_after_resident_corporate() != null) {
						cell25.setCellValue(record.getR0020_after_resident_corporate().doubleValue());
						cell25.setCellStyle(numberStyle);
					} else {
						cell25.setCellValue("");
						cell25.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AA
					Cell cell26 = row.createCell(26);
					if (record.getR0020_before_nonresident_corporate() != null) {
						cell26.setCellValue(record.getR0020_before_nonresident_corporate().doubleValue());
						cell26.setCellStyle(numberStyle);
					} else {
						cell26.setCellValue("");
						cell26.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AB
					Cell cell27 = row.createCell(27);
					if (record.getR0020_after_nonresident_corporate() != null) {
						cell27.setCellValue(record.getR0020_after_nonresident_corporate().doubleValue());
						cell27.setCellStyle(numberStyle);
					} else {
						cell27.setCellValue("");
						cell27.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AC
					Cell cell28 = row.createCell(28);
					if (record.getR0020_before_resident_nbfi() != null) {
						cell28.setCellValue(record.getR0020_before_resident_nbfi().doubleValue());
						cell28.setCellStyle(numberStyle);
					} else {
						cell28.setCellValue("");
						cell28.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AD
					Cell cell29 = row.createCell(29);
					if (record.getR0020_after_resident_nbfi() != null) {
						cell29.setCellValue(record.getR0020_after_resident_nbfi().doubleValue());
						cell29.setCellStyle(numberStyle);
					} else {
						cell29.setCellValue("");
						cell29.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AE
					Cell cell30 = row.createCell(30);
					if (record.getR0020_before_nonresident_nbfi() != null) {
						cell30.setCellValue(record.getR0020_before_nonresident_nbfi().doubleValue());
						cell30.setCellStyle(numberStyle);
					} else {
						cell30.setCellValue("");
						cell30.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AF
					Cell cell31 = row.createCell(31);
					if (record.getR0020_after_nonresident_nbfi() != null) {
						cell31.setCellValue(record.getR0020_after_nonresident_nbfi().doubleValue());
						cell31.setCellStyle(numberStyle);
					} else {
						cell31.setCellValue("");
						cell31.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AG
					Cell cell32 = row.createCell(32);
					if (record.getR0020_before_resident_bank() != null) {
						cell32.setCellValue(record.getR0020_before_resident_bank().doubleValue());
						cell32.setCellStyle(numberStyle);
					} else {
						cell32.setCellValue("");
						cell32.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AH
					Cell cell33 = row.createCell(33);
					if (record.getR0020_after_resident_bank() != null) {
						cell33.setCellValue(record.getR0020_after_resident_bank().doubleValue());
						cell33.setCellStyle(numberStyle);
					} else {
						cell33.setCellValue("");
						cell33.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AI
					Cell cell34 = row.createCell(34);
					if (record.getR0020_before_nonresident_bank() != null) {
						cell34.setCellValue(record.getR0020_before_nonresident_bank().doubleValue());
						cell34.setCellStyle(numberStyle);
					} else {
						cell34.setCellValue("");
						cell34.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AJ
					Cell cell35 = row.createCell(35);
					if (record.getR0020_after_nonresident_bank() != null) {
						cell35.setCellValue(record.getR0020_after_nonresident_bank().doubleValue());
						cell35.setCellStyle(numberStyle);
					} else {
						cell35.setCellValue("");
						cell35.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AK
					Cell cell36 = row.createCell(36);
					if (record.getR0020_before_resident_government() != null) {
						cell36.setCellValue(record.getR0020_before_resident_government().doubleValue());
						cell36.setCellStyle(numberStyle);
					} else {
						cell36.setCellValue("");
						cell36.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AL
					Cell cell37 = row.createCell(37);
					if (record.getR0020_after_resident_government() != null) {
						cell37.setCellValue(record.getR0020_after_resident_government().doubleValue());
						cell37.setCellStyle(numberStyle);
					} else {
						cell37.setCellValue("");
						cell37.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AM
					Cell cell38 = row.createCell(38);
					if (record.getR0020_before_nonresident_government() != null) {
						cell38.setCellValue(record.getR0020_before_nonresident_government().doubleValue());
						cell38.setCellStyle(numberStyle);
					} else {
						cell38.setCellValue("");
						cell38.setCellStyle(textStyle);
					}

					/// ROW12
					//// Column AN
					Cell cell39 = row.createCell(39);
					if (record.getR0020_after_nonresident_government() != null) {
						cell39.setCellValue(record.getR0020_after_nonresident_government().doubleValue());
						cell39.setCellStyle(numberStyle);
					} else {
						cell39.setCellValue("");
						cell39.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column E
					row = sheet.getRow(12);
					Cell R0030cell4 = row.createCell(4);
					if (record.getR0030_before_resident_individual() != null) {
						R0030cell4.setCellValue(record.getR0030_before_resident_individual().doubleValue());
						R0030cell4.setCellStyle(numberStyle);
					} else {
						R0030cell4.setCellValue("");
						R0030cell4.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column F
					Cell R0030cell5 = row.createCell(5);
					if (record.getR0030_after_resident_individual() != null) {
						R0030cell5.setCellValue(record.getR0030_after_resident_individual().doubleValue());
						R0030cell5.setCellStyle(numberStyle);
					} else {
						R0030cell5.setCellValue("");
						R0030cell5.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column G
					Cell R0030cell6 = row.createCell(6);
					if (record.getR0030_before_nonresident_individual() != null) {
						R0030cell6.setCellValue(record.getR0030_before_nonresident_individual().doubleValue());
						R0030cell6.setCellStyle(numberStyle);
					} else {
						R0030cell6.setCellValue("");
						R0030cell6.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column H
					Cell R0030cell7 = row.createCell(7);
					if (record.getR0030_after_nonresident_individual() != null) {
						R0030cell7.setCellValue(record.getR0030_after_nonresident_individual().doubleValue());
						R0030cell7.setCellStyle(numberStyle);
					} else {
						R0030cell7.setCellValue("");
						R0030cell7.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column I
					Cell R0030cell8 = row.createCell(8);
					if (record.getR0030_before_resident_retail() != null) {
						R0030cell8.setCellValue(record.getR0030_before_resident_retail().doubleValue());
						R0030cell8.setCellStyle(numberStyle);
					} else {
						R0030cell8.setCellValue("");
						R0030cell8.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column J
					Cell R0030cell9 = row.createCell(9);
					if (record.getR0030_after_resident_retail() != null) {
						R0030cell9.setCellValue(record.getR0030_after_resident_retail().doubleValue());
						R0030cell9.setCellStyle(numberStyle);
					} else {
						R0030cell9.setCellValue("");
						R0030cell9.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column K
					Cell R0030cell10 = row.createCell(10);
					if (record.getR0030_before_nonresident_retail() != null) {
						R0030cell10.setCellValue(record.getR0030_before_nonresident_retail().doubleValue());
						R0030cell10.setCellStyle(numberStyle);
					} else {
						R0030cell10.setCellValue("");
						R0030cell10.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column L
					Cell R0030cell11 = row.createCell(11);
					if (record.getR0030_after_nonresident_retail() != null) {
						R0030cell11.setCellValue(record.getR0030_after_nonresident_retail().doubleValue());
						R0030cell11.setCellStyle(numberStyle);
					} else {
						R0030cell11.setCellValue("");
						R0030cell11.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column M
					Cell R0030cell12 = row.createCell(12);
					if (record.getR0030_before_resident_sme() != null) {
						R0030cell12.setCellValue(record.getR0030_before_resident_sme().doubleValue());
						R0030cell12.setCellStyle(numberStyle);
					} else {
						R0030cell12.setCellValue("");
						R0030cell12.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column N
					Cell R0030cell13 = row.createCell(13);
					if (record.getR0030_after_resident_sme() != null) {
						R0030cell13.setCellValue(record.getR0030_after_resident_sme().doubleValue());
						R0030cell13.setCellStyle(numberStyle);
					} else {
						R0030cell13.setCellValue("");
						R0030cell13.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column O
					Cell R0030cell14 = row.createCell(14);
					if (record.getR0030_before_nonresident_sme() != null) {
						R0030cell14.setCellValue(record.getR0030_before_nonresident_sme().doubleValue());
						R0030cell14.setCellStyle(numberStyle);
					} else {
						R0030cell14.setCellValue("");
						R0030cell14.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column P
					Cell R0030cell15 = row.createCell(15);
					if (record.getR0030_after_nonresident_sme() != null) {
						R0030cell15.setCellValue(record.getR0030_after_nonresident_sme().doubleValue());
						R0030cell15.setCellStyle(numberStyle);
					} else {
						R0030cell15.setCellValue("");
						R0030cell15.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column Q
					Cell R0030cell16 = row.createCell(16);
					if (record.getR0030_before_resident_hni() != null) {
						R0030cell16.setCellValue(record.getR0030_before_resident_hni().doubleValue());
						R0030cell16.setCellStyle(numberStyle);
					} else {
						R0030cell16.setCellValue("");
						R0030cell16.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column R
					Cell R0030cell17 = row.createCell(17);
					if (record.getR0030_after_resident_hni() != null) {
						R0030cell17.setCellValue(record.getR0030_after_resident_hni().doubleValue());
						R0030cell17.setCellStyle(numberStyle);
					} else {
						R0030cell17.setCellValue("");
						R0030cell17.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column S
					Cell R0030cell18 = row.createCell(18);
					if (record.getR0030_before_nonresident_hni() != null) {
						R0030cell18.setCellValue(record.getR0030_before_nonresident_hni().doubleValue());
						R0030cell18.setCellStyle(numberStyle);
					} else {
						R0030cell18.setCellValue("");
						R0030cell18.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column T
					Cell R0030cell19 = row.createCell(19);
					if (record.getR0030_after_nonresident_hni() != null) {
						R0030cell19.setCellValue(record.getR0030_after_nonresident_hni().doubleValue());
						R0030cell19.setCellStyle(numberStyle);
					} else {
						R0030cell19.setCellValue("");
						R0030cell19.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column U
					Cell R0030cell20 = row.createCell(20);
					if (record.getR0030_before_resident_gre() != null) {
						R0030cell20.setCellValue(record.getR0030_before_resident_gre().doubleValue());
						R0030cell20.setCellStyle(numberStyle);
					} else {
						R0030cell20.setCellValue("");
						R0030cell20.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column V
					Cell R0030cell21 = row.createCell(21);
					if (record.getR0030_after_resident_gre() != null) {
						R0030cell21.setCellValue(record.getR0030_after_resident_gre().doubleValue());
						R0030cell21.setCellStyle(numberStyle);
					} else {
						R0030cell21.setCellValue("");
						R0030cell21.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column W
					Cell R0030cell22 = row.createCell(22);
					if (record.getR0030_before_nonresident_gre() != null) {
						R0030cell22.setCellValue(record.getR0030_before_nonresident_gre().doubleValue());
						R0030cell22.setCellStyle(numberStyle);
					} else {
						R0030cell22.setCellValue("");
						R0030cell22.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column X
					Cell R0030cell23 = row.createCell(23);
					if (record.getR0030_after_nonresident_gre() != null) {
						R0030cell23.setCellValue(record.getR0030_after_nonresident_gre().doubleValue());
						R0030cell23.setCellStyle(numberStyle);
					} else {
						R0030cell23.setCellValue("");
						R0030cell23.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column Y
					Cell R0030cell24 = row.createCell(24);
					if (record.getR0030_before_resident_corporate() != null) {
						R0030cell24.setCellValue(record.getR0030_before_resident_corporate().doubleValue());
						R0030cell24.setCellStyle(numberStyle);
					} else {
						R0030cell24.setCellValue("");
						R0030cell24.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column Z
					Cell R0030cell25 = row.createCell(25);
					if (record.getR0030_after_resident_corporate() != null) {
						R0030cell25.setCellValue(record.getR0030_after_resident_corporate().doubleValue());
						R0030cell25.setCellStyle(numberStyle);
					} else {
						R0030cell25.setCellValue("");
						R0030cell25.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AA
					Cell R0030cell26 = row.createCell(26);
					if (record.getR0030_before_nonresident_corporate() != null) {
						R0030cell26.setCellValue(record.getR0030_before_nonresident_corporate().doubleValue());
						R0030cell26.setCellStyle(numberStyle);
					} else {
						R0030cell26.setCellValue("");
						R0030cell26.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AB
					Cell R0030cell27 = row.createCell(27);
					if (record.getR0030_after_nonresident_corporate() != null) {
						R0030cell27.setCellValue(record.getR0030_after_nonresident_corporate().doubleValue());
						R0030cell27.setCellStyle(numberStyle);
					} else {
						R0030cell27.setCellValue("");
						R0030cell27.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AC
					Cell R0030cell28 = row.createCell(28);
					if (record.getR0030_before_resident_nbfi() != null) {
						R0030cell28.setCellValue(record.getR0030_before_resident_nbfi().doubleValue());
						R0030cell28.setCellStyle(numberStyle);
					} else {
						R0030cell28.setCellValue("");
						R0030cell28.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AD
					Cell R0030cell29 = row.createCell(29);
					if (record.getR0030_after_resident_nbfi() != null) {
						R0030cell29.setCellValue(record.getR0030_after_resident_nbfi().doubleValue());
						R0030cell29.setCellStyle(numberStyle);
					} else {
						R0030cell29.setCellValue("");
						R0030cell29.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AE
					Cell R0030cell30 = row.createCell(30);
					if (record.getR0030_before_nonresident_nbfi() != null) {
						R0030cell30.setCellValue(record.getR0030_before_nonresident_nbfi().doubleValue());
						R0030cell30.setCellStyle(numberStyle);
					} else {
						R0030cell30.setCellValue("");
						R0030cell30.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AF
					Cell R0030cell31 = row.createCell(31);
					if (record.getR0030_after_nonresident_nbfi() != null) {
						R0030cell31.setCellValue(record.getR0030_after_nonresident_nbfi().doubleValue());
						R0030cell31.setCellStyle(numberStyle);
					} else {
						R0030cell31.setCellValue("");
						R0030cell31.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AG
					Cell R0030cell32 = row.createCell(32);
					if (record.getR0030_before_resident_bank() != null) {
						R0030cell32.setCellValue(record.getR0030_before_resident_bank().doubleValue());
						R0030cell32.setCellStyle(numberStyle);
					} else {
						R0030cell32.setCellValue("");
						R0030cell32.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AH
					Cell R0030cell33 = row.createCell(33);
					if (record.getR0030_after_resident_bank() != null) {
						R0030cell33.setCellValue(record.getR0030_after_resident_bank().doubleValue());
						R0030cell33.setCellStyle(numberStyle);
					} else {
						R0030cell33.setCellValue("");
						R0030cell33.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AI
					Cell R0030cell34 = row.createCell(34);
					if (record.getR0030_before_nonresident_bank() != null) {
						R0030cell34.setCellValue(record.getR0030_before_nonresident_bank().doubleValue());
						R0030cell34.setCellStyle(numberStyle);
					} else {
						R0030cell34.setCellValue("");
						R0030cell34.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AJ
					Cell R0030cell35 = row.createCell(35);
					if (record.getR0030_after_nonresident_bank() != null) {
						R0030cell35.setCellValue(record.getR0030_after_nonresident_bank().doubleValue());
						R0030cell35.setCellStyle(numberStyle);
					} else {
						R0030cell35.setCellValue("");
						R0030cell35.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AK
					Cell R0030cell36 = row.createCell(36);
					if (record.getR0030_before_resident_government() != null) {
						R0030cell36.setCellValue(record.getR0030_before_resident_government().doubleValue());
						R0030cell36.setCellStyle(numberStyle);
					} else {
						R0030cell36.setCellValue("");
						R0030cell36.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AL
					Cell R0030cell37 = row.createCell(37);
					if (record.getR0030_after_resident_government() != null) {
						R0030cell37.setCellValue(record.getR0030_after_resident_government().doubleValue());
						R0030cell37.setCellStyle(numberStyle);
					} else {
						R0030cell37.setCellValue("");
						R0030cell37.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AM
					Cell R0030cell38 = row.createCell(38);
					if (record.getR0030_before_nonresident_government() != null) {
						R0030cell38.setCellValue(record.getR0030_before_nonresident_government().doubleValue());
						R0030cell38.setCellStyle(numberStyle);
					} else {
						R0030cell38.setCellValue("");
						R0030cell38.setCellStyle(textStyle);
					}

					/// ROW13
					//// Column AN
					Cell R0030cell39 = row.createCell(39);
					if (record.getR0030_after_nonresident_government() != null) {
						R0030cell39.setCellValue(record.getR0030_after_nonresident_government().doubleValue());
						R0030cell39.setCellStyle(numberStyle);
					} else {
						R0030cell39.setCellValue("");
						R0030cell39.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column E
					row = sheet.getRow(14);
					Cell R0050cell4 = row.createCell(4);
					if (record.getR0050_before_resident_individual() != null) {
						R0050cell4.setCellValue(record.getR0050_before_resident_individual().doubleValue());
						R0050cell4.setCellStyle(numberStyle);
					} else {
						R0050cell4.setCellValue("");
						R0050cell4.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column F
					Cell R0050cell5 = row.createCell(5);
					if (record.getR0050_after_resident_individual() != null) {
						R0050cell5.setCellValue(record.getR0050_after_resident_individual().doubleValue());
						R0050cell5.setCellStyle(numberStyle);
					} else {
						R0050cell5.setCellValue("");
						R0050cell5.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column G
					Cell R0050cell6 = row.createCell(6);
					if (record.getR0050_before_nonresident_individual() != null) {
						R0050cell6.setCellValue(record.getR0050_before_nonresident_individual().doubleValue());
						R0050cell6.setCellStyle(numberStyle);
					} else {
						R0050cell6.setCellValue("");
						R0050cell6.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column H
					Cell R0050cell7 = row.createCell(7);
					if (record.getR0050_after_nonresident_individual() != null) {
						R0050cell7.setCellValue(record.getR0050_after_nonresident_individual().doubleValue());
						R0050cell7.setCellStyle(numberStyle);
					} else {
						R0050cell7.setCellValue("");
						R0050cell7.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column I
					Cell R0050cell8 = row.createCell(8);
					if (record.getR0050_before_resident_retail() != null) {
						R0050cell8.setCellValue(record.getR0050_before_resident_retail().doubleValue());
						R0050cell8.setCellStyle(numberStyle);
					} else {
						R0050cell8.setCellValue("");
						R0050cell8.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column J
					Cell R0050cell9 = row.createCell(9);
					if (record.getR0050_after_resident_retail() != null) {
						R0050cell9.setCellValue(record.getR0050_after_resident_retail().doubleValue());
						R0050cell9.setCellStyle(numberStyle);
					} else {
						R0050cell9.setCellValue("");
						R0050cell9.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column K
					Cell R0050cell10 = row.createCell(10);
					if (record.getR0050_before_nonresident_retail() != null) {
						R0050cell10.setCellValue(record.getR0050_before_nonresident_retail().doubleValue());
						R0050cell10.setCellStyle(numberStyle);
					} else {
						R0050cell10.setCellValue("");
						R0050cell10.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column L
					Cell R0050cell11 = row.createCell(11);
					if (record.getR0050_after_nonresident_retail() != null) {
						R0050cell11.setCellValue(record.getR0050_after_nonresident_retail().doubleValue());
						R0050cell11.setCellStyle(numberStyle);
					} else {
						R0050cell11.setCellValue("");
						R0050cell11.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column M
					Cell R0050cell12 = row.createCell(12);
					if (record.getR0050_before_resident_sme() != null) {
						R0050cell12.setCellValue(record.getR0050_before_resident_sme().doubleValue());
						R0050cell12.setCellStyle(numberStyle);
					} else {
						R0050cell12.setCellValue("");
						R0050cell12.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column N
					Cell R0050cell13 = row.createCell(13);
					if (record.getR0050_after_resident_sme() != null) {
						R0050cell13.setCellValue(record.getR0050_after_resident_sme().doubleValue());
						R0050cell13.setCellStyle(numberStyle);
					} else {
						R0050cell13.setCellValue("");
						R0050cell13.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column O
					Cell R0050cell14 = row.createCell(14);
					if (record.getR0050_before_nonresident_sme() != null) {
						R0050cell14.setCellValue(record.getR0050_before_nonresident_sme().doubleValue());
						R0050cell14.setCellStyle(numberStyle);
					} else {
						R0050cell14.setCellValue("");
						R0050cell14.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column P
					Cell R0050cell15 = row.createCell(15);
					if (record.getR0050_after_nonresident_sme() != null) {
						R0050cell15.setCellValue(record.getR0050_after_nonresident_sme().doubleValue());
						R0050cell15.setCellStyle(numberStyle);
					} else {
						R0050cell15.setCellValue("");
						R0050cell15.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column Q
					Cell R0050cell16 = row.createCell(16);
					if (record.getR0050_before_resident_hni() != null) {
						R0050cell16.setCellValue(record.getR0050_before_resident_hni().doubleValue());
						R0050cell16.setCellStyle(numberStyle);
					} else {
						R0050cell16.setCellValue("");
						R0050cell16.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column R
					Cell R0050cell17 = row.createCell(17);
					if (record.getR0050_after_resident_hni() != null) {
						R0050cell17.setCellValue(record.getR0050_after_resident_hni().doubleValue());
						R0050cell17.setCellStyle(numberStyle);
					} else {
						R0050cell17.setCellValue("");
						R0050cell17.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column S
					Cell R0050cell18 = row.createCell(18);
					if (record.getR0050_before_nonresident_hni() != null) {
						R0050cell18.setCellValue(record.getR0050_before_nonresident_hni().doubleValue());
						R0050cell18.setCellStyle(numberStyle);
					} else {
						R0050cell18.setCellValue("");
						R0050cell18.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column T
					Cell R0050cell19 = row.createCell(19);
					if (record.getR0050_after_nonresident_hni() != null) {
						R0050cell19.setCellValue(record.getR0050_after_nonresident_hni().doubleValue());
						R0050cell19.setCellStyle(numberStyle);
					} else {
						R0050cell19.setCellValue("");
						R0050cell19.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column U
					Cell R0050cell20 = row.createCell(20);
					if (record.getR0050_before_resident_gre() != null) {
						R0050cell20.setCellValue(record.getR0050_before_resident_gre().doubleValue());
						R0050cell20.setCellStyle(numberStyle);
					} else {
						R0050cell20.setCellValue("");
						R0050cell20.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column V
					Cell R0050cell21 = row.createCell(21);
					if (record.getR0050_after_resident_gre() != null) {
						R0050cell21.setCellValue(record.getR0050_after_resident_gre().doubleValue());
						R0050cell21.setCellStyle(numberStyle);
					} else {
						R0050cell21.setCellValue("");
						R0050cell21.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column W
					Cell R0050cell22 = row.createCell(22);
					if (record.getR0050_before_nonresident_gre() != null) {
						R0050cell22.setCellValue(record.getR0050_before_nonresident_gre().doubleValue());
						R0050cell22.setCellStyle(numberStyle);
					} else {
						R0050cell22.setCellValue("");
						R0050cell22.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column X
					Cell R0050cell23 = row.createCell(23);
					if (record.getR0050_after_nonresident_gre() != null) {
						R0050cell23.setCellValue(record.getR0050_after_nonresident_gre().doubleValue());
						R0050cell23.setCellStyle(numberStyle);
					} else {
						R0050cell23.setCellValue("");
						R0050cell23.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column Y
					Cell R0050cell24 = row.createCell(24);
					if (record.getR0050_before_resident_corporate() != null) {
						R0050cell24.setCellValue(record.getR0050_before_resident_corporate().doubleValue());
						R0050cell24.setCellStyle(numberStyle);
					} else {
						R0050cell24.setCellValue("");
						R0050cell24.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column Z
					Cell R0050cell25 = row.createCell(25);
					if (record.getR0050_after_resident_corporate() != null) {
						R0050cell25.setCellValue(record.getR0050_after_resident_corporate().doubleValue());
						R0050cell25.setCellStyle(numberStyle);
					} else {
						R0050cell25.setCellValue("");
						R0050cell25.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AA
					Cell R0050cell26 = row.createCell(26);
					if (record.getR0050_before_nonresident_corporate() != null) {
						R0050cell26.setCellValue(record.getR0050_before_nonresident_corporate().doubleValue());
						R0050cell26.setCellStyle(numberStyle);
					} else {
						R0050cell26.setCellValue("");
						R0050cell26.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AB
					Cell R0050cell27 = row.createCell(27);
					if (record.getR0050_after_nonresident_corporate() != null) {
						R0050cell27.setCellValue(record.getR0050_after_nonresident_corporate().doubleValue());
						R0050cell27.setCellStyle(numberStyle);
					} else {
						R0050cell27.setCellValue("");
						R0050cell27.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AC
					Cell R0050cell28 = row.createCell(28);
					if (record.getR0050_before_resident_nbfi() != null) {
						R0050cell28.setCellValue(record.getR0050_before_resident_nbfi().doubleValue());
						R0050cell28.setCellStyle(numberStyle);
					} else {
						R0050cell28.setCellValue("");
						R0050cell28.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AD
					Cell R0050cell29 = row.createCell(29);
					if (record.getR0050_after_resident_nbfi() != null) {
						R0050cell29.setCellValue(record.getR0050_after_resident_nbfi().doubleValue());
						R0050cell29.setCellStyle(numberStyle);
					} else {
						R0050cell29.setCellValue("");
						R0050cell29.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AE
					Cell R0050cell30 = row.createCell(30);
					if (record.getR0050_before_nonresident_nbfi() != null) {
						R0050cell30.setCellValue(record.getR0050_before_nonresident_nbfi().doubleValue());
						R0050cell30.setCellStyle(numberStyle);
					} else {
						R0050cell30.setCellValue("");
						R0050cell30.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AF
					Cell R0050cell31 = row.createCell(31);
					if (record.getR0050_after_nonresident_nbfi() != null) {
						R0050cell31.setCellValue(record.getR0050_after_nonresident_nbfi().doubleValue());
						R0050cell31.setCellStyle(numberStyle);
					} else {
						R0050cell31.setCellValue("");
						R0050cell31.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AG
					Cell R0050cell32 = row.createCell(32);
					if (record.getR0050_before_resident_bank() != null) {
						R0050cell32.setCellValue(record.getR0050_before_resident_bank().doubleValue());
						R0050cell32.setCellStyle(numberStyle);
					} else {
						R0050cell32.setCellValue("");
						R0050cell32.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AH
					Cell R0050cell33 = row.createCell(33);
					if (record.getR0050_after_resident_bank() != null) {
						R0050cell33.setCellValue(record.getR0050_after_resident_bank().doubleValue());
						R0050cell33.setCellStyle(numberStyle);
					} else {
						R0050cell33.setCellValue("");
						R0050cell33.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AI
					Cell R0050cell34 = row.createCell(34);
					if (record.getR0050_before_nonresident_bank() != null) {
						R0050cell34.setCellValue(record.getR0050_before_nonresident_bank().doubleValue());
						R0050cell34.setCellStyle(numberStyle);
					} else {
						R0050cell34.setCellValue("");
						R0050cell34.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AJ
					Cell R0050cell35 = row.createCell(35);
					if (record.getR0050_after_nonresident_bank() != null) {
						R0050cell35.setCellValue(record.getR0050_after_nonresident_bank().doubleValue());
						R0050cell35.setCellStyle(numberStyle);
					} else {
						R0050cell35.setCellValue("");
						R0050cell35.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AK
					Cell R0050cell36 = row.createCell(36);
					if (record.getR0050_before_resident_government() != null) {
						R0050cell36.setCellValue(record.getR0050_before_resident_government().doubleValue());
						R0050cell36.setCellStyle(numberStyle);
					} else {
						R0050cell36.setCellValue("");
						R0050cell36.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AL
					Cell R0050cell37 = row.createCell(37);
					if (record.getR0050_after_resident_government() != null) {
						R0050cell37.setCellValue(record.getR0050_after_resident_government().doubleValue());
						R0050cell37.setCellStyle(numberStyle);
					} else {
						R0050cell37.setCellValue("");
						R0050cell37.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AM
					Cell R0050cell38 = row.createCell(38);
					if (record.getR0050_before_nonresident_government() != null) {
						R0050cell38.setCellValue(record.getR0050_before_nonresident_government().doubleValue());
						R0050cell38.setCellStyle(numberStyle);
					} else {
						R0050cell38.setCellValue("");
						R0050cell38.setCellStyle(textStyle);
					}

					/// ROW15
					//// Column AN
					Cell R0050cell39 = row.createCell(39);
					if (record.getR0050_after_nonresident_government() != null) {
						R0050cell39.setCellValue(record.getR0050_after_nonresident_government().doubleValue());
						R0050cell39.setCellStyle(numberStyle);
					} else {
						R0050cell39.setCellValue("");
						R0050cell39.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column E
					row = sheet.getRow(15);
					Cell R0060cell4 = row.createCell(4);
					if (record.getR0060_before_resident_individual() != null) {
						R0060cell4.setCellValue(record.getR0060_before_resident_individual().doubleValue());
						R0060cell4.setCellStyle(numberStyle);
					} else {
						R0060cell4.setCellValue("");
						R0060cell4.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column F
					Cell R0060cell5 = row.createCell(5);
					if (record.getR0060_after_resident_individual() != null) {
						R0060cell5.setCellValue(record.getR0060_after_resident_individual().doubleValue());
						R0060cell5.setCellStyle(numberStyle);
					} else {
						R0060cell5.setCellValue("");
						R0060cell5.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column G
					Cell R0060cell6 = row.createCell(6);
					if (record.getR0060_before_nonresident_individual() != null) {
						R0060cell6.setCellValue(record.getR0060_before_nonresident_individual().doubleValue());
						R0060cell6.setCellStyle(numberStyle);
					} else {
						R0060cell6.setCellValue("");
						R0060cell6.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column H
					Cell R0060cell7 = row.createCell(7);
					if (record.getR0060_after_nonresident_individual() != null) {
						R0060cell7.setCellValue(record.getR0060_after_nonresident_individual().doubleValue());
						R0060cell7.setCellStyle(numberStyle);
					} else {
						R0060cell7.setCellValue("");
						R0060cell7.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column I
					Cell R0060cell8 = row.createCell(8);
					if (record.getR0060_before_resident_retail() != null) {
						R0060cell8.setCellValue(record.getR0060_before_resident_retail().doubleValue());
						R0060cell8.setCellStyle(numberStyle);
					} else {
						R0060cell8.setCellValue("");
						R0060cell8.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column J
					Cell R0060cell9 = row.createCell(9);
					if (record.getR0060_after_resident_retail() != null) {
						R0060cell9.setCellValue(record.getR0060_after_resident_retail().doubleValue());
						R0060cell9.setCellStyle(numberStyle);
					} else {
						R0060cell9.setCellValue("");
						R0060cell9.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column K
					Cell R0060cell10 = row.createCell(10);
					if (record.getR0060_before_nonresident_retail() != null) {
						R0060cell10.setCellValue(record.getR0060_before_nonresident_retail().doubleValue());
						R0060cell10.setCellStyle(numberStyle);
					} else {
						R0060cell10.setCellValue("");
						R0060cell10.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column L
					Cell R0060cell11 = row.createCell(11);
					if (record.getR0060_after_nonresident_retail() != null) {
						R0060cell11.setCellValue(record.getR0060_after_nonresident_retail().doubleValue());
						R0060cell11.setCellStyle(numberStyle);
					} else {
						R0060cell11.setCellValue("");
						R0060cell11.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column M
					Cell R0060cell12 = row.createCell(12);
					if (record.getR0060_before_resident_sme() != null) {
						R0060cell12.setCellValue(record.getR0060_before_resident_sme().doubleValue());
						R0060cell12.setCellStyle(numberStyle);
					} else {
						R0060cell12.setCellValue("");
						R0060cell12.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column N
					Cell R0060cell13 = row.createCell(13);
					if (record.getR0060_after_resident_sme() != null) {
						R0060cell13.setCellValue(record.getR0060_after_resident_sme().doubleValue());
						R0060cell13.setCellStyle(numberStyle);
					} else {
						R0060cell13.setCellValue("");
						R0060cell13.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column O
					Cell R0060cell14 = row.createCell(14);
					if (record.getR0060_before_nonresident_sme() != null) {
						R0060cell14.setCellValue(record.getR0060_before_nonresident_sme().doubleValue());
						R0060cell14.setCellStyle(numberStyle);
					} else {
						R0060cell14.setCellValue("");
						R0060cell14.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column P
					Cell R0060cell15 = row.createCell(15);
					if (record.getR0060_after_nonresident_sme() != null) {
						R0060cell15.setCellValue(record.getR0060_after_nonresident_sme().doubleValue());
						R0060cell15.setCellStyle(numberStyle);
					} else {
						R0060cell15.setCellValue("");
						R0060cell15.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column Q
					Cell R0060cell16 = row.createCell(16);
					if (record.getR0060_before_resident_hni() != null) {
						R0060cell16.setCellValue(record.getR0060_before_resident_hni().doubleValue());
						R0060cell16.setCellStyle(numberStyle);
					} else {
						R0060cell16.setCellValue("");
						R0060cell16.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column R
					Cell R0060cell17 = row.createCell(17);
					if (record.getR0060_after_resident_hni() != null) {
						R0060cell17.setCellValue(record.getR0060_after_resident_hni().doubleValue());
						R0060cell17.setCellStyle(numberStyle);
					} else {
						R0060cell17.setCellValue("");
						R0060cell17.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column S
					Cell R0060cell18 = row.createCell(18);
					if (record.getR0060_before_nonresident_hni() != null) {
						R0060cell18.setCellValue(record.getR0060_before_nonresident_hni().doubleValue());
						R0060cell18.setCellStyle(numberStyle);
					} else {
						R0060cell18.setCellValue("");
						R0060cell18.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column T
					Cell R0060cell19 = row.createCell(19);
					if (record.getR0060_after_nonresident_hni() != null) {
						R0060cell19.setCellValue(record.getR0060_after_nonresident_hni().doubleValue());
						R0060cell19.setCellStyle(numberStyle);
					} else {
						R0060cell19.setCellValue("");
						R0060cell19.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column U
					Cell R0060cell20 = row.createCell(20);
					if (record.getR0060_before_resident_gre() != null) {
						R0060cell20.setCellValue(record.getR0060_before_resident_gre().doubleValue());
						R0060cell20.setCellStyle(numberStyle);
					} else {
						R0060cell20.setCellValue("");
						R0060cell20.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column V
					Cell R0060cell21 = row.createCell(21);
					if (record.getR0060_after_resident_gre() != null) {
						R0060cell21.setCellValue(record.getR0060_after_resident_gre().doubleValue());
						R0060cell21.setCellStyle(numberStyle);
					} else {
						R0060cell21.setCellValue("");
						R0060cell21.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column W
					Cell R0060cell22 = row.createCell(22);
					if (record.getR0060_before_nonresident_gre() != null) {
						R0060cell22.setCellValue(record.getR0060_before_nonresident_gre().doubleValue());
						R0060cell22.setCellStyle(numberStyle);
					} else {
						R0060cell22.setCellValue("");
						R0060cell22.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column X
					Cell R0060cell23 = row.createCell(23);
					if (record.getR0060_after_nonresident_gre() != null) {
						R0060cell23.setCellValue(record.getR0060_after_nonresident_gre().doubleValue());
						R0060cell23.setCellStyle(numberStyle);
					} else {
						R0060cell23.setCellValue("");
						R0060cell23.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column Y
					Cell R0060cell24 = row.createCell(24);
					if (record.getR0060_before_resident_corporate() != null) {
						R0060cell24.setCellValue(record.getR0060_before_resident_corporate().doubleValue());
						R0060cell24.setCellStyle(numberStyle);
					} else {
						R0060cell24.setCellValue("");
						R0060cell24.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column Z
					Cell R0060cell25 = row.createCell(25);
					if (record.getR0060_after_resident_corporate() != null) {
						R0060cell25.setCellValue(record.getR0060_after_resident_corporate().doubleValue());
						R0060cell25.setCellStyle(numberStyle);
					} else {
						R0060cell25.setCellValue("");
						R0060cell25.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AA
					Cell R0060cell26 = row.createCell(26);
					if (record.getR0060_before_nonresident_corporate() != null) {
						R0060cell26.setCellValue(record.getR0060_before_nonresident_corporate().doubleValue());
						R0060cell26.setCellStyle(numberStyle);
					} else {
						R0060cell26.setCellValue("");
						R0060cell26.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AB
					Cell R0060cell27 = row.createCell(27);
					if (record.getR0060_after_nonresident_corporate() != null) {
						R0060cell27.setCellValue(record.getR0060_after_nonresident_corporate().doubleValue());
						R0060cell27.setCellStyle(numberStyle);
					} else {
						R0060cell27.setCellValue("");
						R0060cell27.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AC
					Cell R0060cell28 = row.createCell(28);
					if (record.getR0060_before_resident_nbfi() != null) {
						R0060cell28.setCellValue(record.getR0060_before_resident_nbfi().doubleValue());
						R0060cell28.setCellStyle(numberStyle);
					} else {
						R0060cell28.setCellValue("");
						R0060cell28.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AD
					Cell R0060cell29 = row.createCell(29);
					if (record.getR0060_after_resident_nbfi() != null) {
						R0060cell29.setCellValue(record.getR0060_after_resident_nbfi().doubleValue());
						R0060cell29.setCellStyle(numberStyle);
					} else {
						R0060cell29.setCellValue("");
						R0060cell29.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AE
					Cell R0060cell30 = row.createCell(30);
					if (record.getR0060_before_nonresident_nbfi() != null) {
						R0060cell30.setCellValue(record.getR0060_before_nonresident_nbfi().doubleValue());
						R0060cell30.setCellStyle(numberStyle);
					} else {
						R0060cell30.setCellValue("");
						R0060cell30.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AF
					Cell R0060cell31 = row.createCell(31);
					if (record.getR0060_after_nonresident_nbfi() != null) {
						R0060cell31.setCellValue(record.getR0060_after_nonresident_nbfi().doubleValue());
						R0060cell31.setCellStyle(numberStyle);
					} else {
						R0060cell31.setCellValue("");
						R0060cell31.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AG
					Cell R0060cell32 = row.createCell(32);
					if (record.getR0060_before_resident_bank() != null) {
						R0060cell32.setCellValue(record.getR0060_before_resident_bank().doubleValue());
						R0060cell32.setCellStyle(numberStyle);
					} else {
						R0060cell32.setCellValue("");
						R0060cell32.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AH
					Cell R0060cell33 = row.createCell(33);
					if (record.getR0060_after_resident_bank() != null) {
						R0060cell33.setCellValue(record.getR0060_after_resident_bank().doubleValue());
						R0060cell33.setCellStyle(numberStyle);
					} else {
						R0060cell33.setCellValue("");
						R0060cell33.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AI
					Cell R0060cell34 = row.createCell(34);
					if (record.getR0060_before_nonresident_bank() != null) {
						R0060cell34.setCellValue(record.getR0060_before_nonresident_bank().doubleValue());
						R0060cell34.setCellStyle(numberStyle);
					} else {
						R0060cell34.setCellValue("");
						R0060cell34.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AJ
					Cell R0060cell35 = row.createCell(35);
					if (record.getR0060_after_nonresident_bank() != null) {
						R0060cell35.setCellValue(record.getR0060_after_nonresident_bank().doubleValue());
						R0060cell35.setCellStyle(numberStyle);
					} else {
						R0060cell35.setCellValue("");
						R0060cell35.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AK
					Cell R0060cell36 = row.createCell(36);
					if (record.getR0060_before_resident_government() != null) {
						R0060cell36.setCellValue(record.getR0060_before_resident_government().doubleValue());
						R0060cell36.setCellStyle(numberStyle);
					} else {
						R0060cell36.setCellValue("");
						R0060cell36.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AL
					Cell R0060cell37 = row.createCell(37);
					if (record.getR0060_after_resident_government() != null) {
						R0060cell37.setCellValue(record.getR0060_after_resident_government().doubleValue());
						R0060cell37.setCellStyle(numberStyle);
					} else {
						R0060cell37.setCellValue("");
						R0060cell37.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AM
					Cell R0060cell38 = row.createCell(38);
					if (record.getR0060_before_nonresident_government() != null) {
						R0060cell38.setCellValue(record.getR0060_before_nonresident_government().doubleValue());
						R0060cell38.setCellStyle(numberStyle);
					} else {
						R0060cell38.setCellValue("");
						R0060cell38.setCellStyle(textStyle);
					}

					/// ROW16
					//// Column AN
					Cell R0060cell39 = row.createCell(39);
					if (record.getR0060_after_nonresident_government() != null) {
						R0060cell39.setCellValue(record.getR0060_after_nonresident_government().doubleValue());
						R0060cell39.setCellStyle(numberStyle);
					} else {
						R0060cell39.setCellValue("");
						R0060cell39.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column E
					row = sheet.getRow(16);
					Cell R0070cell4 = row.createCell(4);
					if (record.getR0070_before_resident_individual() != null) {
						R0070cell4.setCellValue(record.getR0070_before_resident_individual().doubleValue());
						R0070cell4.setCellStyle(numberStyle);
					} else {
						R0070cell4.setCellValue("");
						R0070cell4.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column F
					Cell R0070cell5 = row.createCell(5);
					if (record.getR0070_after_resident_individual() != null) {
						R0070cell5.setCellValue(record.getR0070_after_resident_individual().doubleValue());
						R0070cell5.setCellStyle(numberStyle);
					} else {
						R0070cell5.setCellValue("");
						R0070cell5.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column G
					Cell R0070cell6 = row.createCell(6);
					if (record.getR0070_before_nonresident_individual() != null) {
						R0070cell6.setCellValue(record.getR0070_before_nonresident_individual().doubleValue());
						R0070cell6.setCellStyle(numberStyle);
					} else {
						R0070cell6.setCellValue("");
						R0070cell6.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column H
					Cell R0070cell7 = row.createCell(7);
					if (record.getR0070_after_nonresident_individual() != null) {
						R0070cell7.setCellValue(record.getR0070_after_nonresident_individual().doubleValue());
						R0070cell7.setCellStyle(numberStyle);
					} else {
						R0070cell7.setCellValue("");
						R0070cell7.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column I
					Cell R0070cell8 = row.createCell(8);
					if (record.getR0070_before_resident_retail() != null) {
						R0070cell8.setCellValue(record.getR0070_before_resident_retail().doubleValue());
						R0070cell8.setCellStyle(numberStyle);
					} else {
						R0070cell8.setCellValue("");
						R0070cell8.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column J
					Cell R0070cell9 = row.createCell(9);
					if (record.getR0070_after_resident_retail() != null) {
						R0070cell9.setCellValue(record.getR0070_after_resident_retail().doubleValue());
						R0070cell9.setCellStyle(numberStyle);
					} else {
						R0070cell9.setCellValue("");
						R0070cell9.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column K
					Cell R0070cell10 = row.createCell(10);
					if (record.getR0070_before_nonresident_retail() != null) {
						R0070cell10.setCellValue(record.getR0070_before_nonresident_retail().doubleValue());
						R0070cell10.setCellStyle(numberStyle);
					} else {
						R0070cell10.setCellValue("");
						R0070cell10.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column L
					Cell R0070cell11 = row.createCell(11);
					if (record.getR0070_after_nonresident_retail() != null) {
						R0070cell11.setCellValue(record.getR0070_after_nonresident_retail().doubleValue());
						R0070cell11.setCellStyle(numberStyle);
					} else {
						R0070cell11.setCellValue("");
						R0070cell11.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column M
					Cell R0070cell12 = row.createCell(12);
					if (record.getR0070_before_resident_sme() != null) {
						R0070cell12.setCellValue(record.getR0070_before_resident_sme().doubleValue());
						R0070cell12.setCellStyle(numberStyle);
					} else {
						R0070cell12.setCellValue("");
						R0070cell12.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column N
					Cell R0070cell13 = row.createCell(13);
					if (record.getR0070_after_resident_sme() != null) {
						R0070cell13.setCellValue(record.getR0070_after_resident_sme().doubleValue());
						R0070cell13.setCellStyle(numberStyle);
					} else {
						R0070cell13.setCellValue("");
						R0070cell13.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column O
					Cell R0070cell14 = row.createCell(14);
					if (record.getR0070_before_nonresident_sme() != null) {
						R0070cell14.setCellValue(record.getR0070_before_nonresident_sme().doubleValue());
						R0070cell14.setCellStyle(numberStyle);
					} else {
						R0070cell14.setCellValue("");
						R0070cell14.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column P
					Cell R0070cell15 = row.createCell(15);
					if (record.getR0070_after_nonresident_sme() != null) {
						R0070cell15.setCellValue(record.getR0070_after_nonresident_sme().doubleValue());
						R0070cell15.setCellStyle(numberStyle);
					} else {
						R0070cell15.setCellValue("");
						R0070cell15.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column Q
					Cell R0070cell16 = row.createCell(16);
					if (record.getR0070_before_resident_hni() != null) {
						R0070cell16.setCellValue(record.getR0070_before_resident_hni().doubleValue());
						R0070cell16.setCellStyle(numberStyle);
					} else {
						R0070cell16.setCellValue("");
						R0070cell16.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column R
					Cell R0070cell17 = row.createCell(17);
					if (record.getR0070_after_resident_hni() != null) {
						R0070cell17.setCellValue(record.getR0070_after_resident_hni().doubleValue());
						R0070cell17.setCellStyle(numberStyle);
					} else {
						R0070cell17.setCellValue("");
						R0070cell17.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column S
					Cell R0070cell18 = row.createCell(18);
					if (record.getR0070_before_nonresident_hni() != null) {
						R0070cell18.setCellValue(record.getR0070_before_nonresident_hni().doubleValue());
						R0070cell18.setCellStyle(numberStyle);
					} else {
						R0070cell18.setCellValue("");
						R0070cell18.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column T
					Cell R0070cell19 = row.createCell(19);
					if (record.getR0070_after_nonresident_hni() != null) {
						R0070cell19.setCellValue(record.getR0070_after_nonresident_hni().doubleValue());
						R0070cell19.setCellStyle(numberStyle);
					} else {
						R0070cell19.setCellValue("");
						R0070cell19.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column U
					Cell R0070cell20 = row.createCell(20);
					if (record.getR0070_before_resident_gre() != null) {
						R0070cell20.setCellValue(record.getR0070_before_resident_gre().doubleValue());
						R0070cell20.setCellStyle(numberStyle);
					} else {
						R0070cell20.setCellValue("");
						R0070cell20.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column V
					Cell R0070cell21 = row.createCell(21);
					if (record.getR0070_after_resident_gre() != null) {
						R0070cell21.setCellValue(record.getR0070_after_resident_gre().doubleValue());
						R0070cell21.setCellStyle(numberStyle);
					} else {
						R0070cell21.setCellValue("");
						R0070cell21.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column W
					Cell R0070cell22 = row.createCell(22);
					if (record.getR0070_before_nonresident_gre() != null) {
						R0070cell22.setCellValue(record.getR0070_before_nonresident_gre().doubleValue());
						R0070cell22.setCellStyle(numberStyle);
					} else {
						R0070cell22.setCellValue("");
						R0070cell22.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column X
					Cell R0070cell23 = row.createCell(23);
					if (record.getR0070_after_nonresident_gre() != null) {
						R0070cell23.setCellValue(record.getR0070_after_nonresident_gre().doubleValue());
						R0070cell23.setCellStyle(numberStyle);
					} else {
						R0070cell23.setCellValue("");
						R0070cell23.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column Y
					Cell R0070cell24 = row.createCell(24);
					if (record.getR0070_before_resident_corporate() != null) {
						R0070cell24.setCellValue(record.getR0070_before_resident_corporate().doubleValue());
						R0070cell24.setCellStyle(numberStyle);
					} else {
						R0070cell24.setCellValue("");
						R0070cell24.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column Z
					Cell R0070cell25 = row.createCell(25);
					if (record.getR0070_after_resident_corporate() != null) {
						R0070cell25.setCellValue(record.getR0070_after_resident_corporate().doubleValue());
						R0070cell25.setCellStyle(numberStyle);
					} else {
						R0070cell25.setCellValue("");
						R0070cell25.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AA
					Cell R0070cell26 = row.createCell(26);
					if (record.getR0070_before_nonresident_corporate() != null) {
						R0070cell26.setCellValue(record.getR0070_before_nonresident_corporate().doubleValue());
						R0070cell26.setCellStyle(numberStyle);
					} else {
						R0070cell26.setCellValue("");
						R0070cell26.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AB
					Cell R0070cell27 = row.createCell(27);
					if (record.getR0070_after_nonresident_corporate() != null) {
						R0070cell27.setCellValue(record.getR0070_after_nonresident_corporate().doubleValue());
						R0070cell27.setCellStyle(numberStyle);
					} else {
						R0070cell27.setCellValue("");
						R0070cell27.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AC
					Cell R0070cell28 = row.createCell(28);
					if (record.getR0070_before_resident_nbfi() != null) {
						R0070cell28.setCellValue(record.getR0070_before_resident_nbfi().doubleValue());
						R0070cell28.setCellStyle(numberStyle);
					} else {
						R0070cell28.setCellValue("");
						R0070cell28.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AD
					Cell R0070cell29 = row.createCell(29);
					if (record.getR0070_after_resident_nbfi() != null) {
						R0070cell29.setCellValue(record.getR0070_after_resident_nbfi().doubleValue());
						R0070cell29.setCellStyle(numberStyle);
					} else {
						R0070cell29.setCellValue("");
						R0070cell29.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AE
					Cell R0070cell30 = row.createCell(30);
					if (record.getR0070_before_nonresident_nbfi() != null) {
						R0070cell30.setCellValue(record.getR0070_before_nonresident_nbfi().doubleValue());
						R0070cell30.setCellStyle(numberStyle);
					} else {
						R0070cell30.setCellValue("");
						R0070cell30.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AF
					Cell R0070cell31 = row.createCell(31);
					if (record.getR0070_after_nonresident_nbfi() != null) {
						R0070cell31.setCellValue(record.getR0070_after_nonresident_nbfi().doubleValue());
						R0070cell31.setCellStyle(numberStyle);
					} else {
						R0070cell31.setCellValue("");
						R0070cell31.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AG
					Cell R0070cell32 = row.createCell(32);
					if (record.getR0070_before_resident_bank() != null) {
						R0070cell32.setCellValue(record.getR0070_before_resident_bank().doubleValue());
						R0070cell32.setCellStyle(numberStyle);
					} else {
						R0070cell32.setCellValue("");
						R0070cell32.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AH
					Cell R0070cell33 = row.createCell(33);
					if (record.getR0070_after_resident_bank() != null) {
						R0070cell33.setCellValue(record.getR0070_after_resident_bank().doubleValue());
						R0070cell33.setCellStyle(numberStyle);
					} else {
						R0070cell33.setCellValue("");
						R0070cell33.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AI
					Cell R0070cell34 = row.createCell(34);
					if (record.getR0070_before_nonresident_bank() != null) {
						R0070cell34.setCellValue(record.getR0070_before_nonresident_bank().doubleValue());
						R0070cell34.setCellStyle(numberStyle);
					} else {
						R0070cell34.setCellValue("");
						R0070cell34.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AJ
					Cell R0070cell35 = row.createCell(35);
					if (record.getR0070_after_nonresident_bank() != null) {
						R0070cell35.setCellValue(record.getR0070_after_nonresident_bank().doubleValue());
						R0070cell35.setCellStyle(numberStyle);
					} else {
						R0070cell35.setCellValue("");
						R0070cell35.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AK
					Cell R0070cell36 = row.createCell(36);
					if (record.getR0070_before_resident_government() != null) {
						R0070cell36.setCellValue(record.getR0070_before_resident_government().doubleValue());
						R0070cell36.setCellStyle(numberStyle);
					} else {
						R0070cell36.setCellValue("");
						R0070cell36.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AL
					Cell R0070cell37 = row.createCell(37);
					if (record.getR0070_after_resident_government() != null) {
						R0070cell37.setCellValue(record.getR0070_after_resident_government().doubleValue());
						R0070cell37.setCellStyle(numberStyle);
					} else {
						R0070cell37.setCellValue("");
						R0070cell37.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AM
					Cell R0070cell38 = row.createCell(38);
					if (record.getR0070_before_nonresident_government() != null) {
						R0070cell38.setCellValue(record.getR0070_before_nonresident_government().doubleValue());
						R0070cell38.setCellStyle(numberStyle);
					} else {
						R0070cell38.setCellValue("");
						R0070cell38.setCellStyle(textStyle);
					}

					/// ROW17
					//// Column AN
					Cell R0070cell39 = row.createCell(39);
					if (record.getR0070_after_nonresident_government() != null) {
						R0070cell39.setCellValue(record.getR0070_after_nonresident_government().doubleValue());
						R0070cell39.setCellStyle(numberStyle);
					} else {
						R0070cell39.setCellValue("");
						R0070cell39.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column E
					row = sheet.getRow(17);
					Cell R0080cell4 = row.createCell(4);
					if (record.getR0080_before_resident_individual() != null) {
						R0080cell4.setCellValue(record.getR0080_before_resident_individual().doubleValue());
						R0080cell4.setCellStyle(numberStyle);
					} else {
						R0080cell4.setCellValue("");
						R0080cell4.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column F
					Cell R0080cell5 = row.createCell(5);
					if (record.getR0080_after_resident_individual() != null) {
						R0080cell5.setCellValue(record.getR0080_after_resident_individual().doubleValue());
						R0080cell5.setCellStyle(numberStyle);
					} else {
						R0080cell5.setCellValue("");
						R0080cell5.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column G
					Cell R0080cell6 = row.createCell(6);
					if (record.getR0080_before_nonresident_individual() != null) {
						R0080cell6.setCellValue(record.getR0080_before_nonresident_individual().doubleValue());
						R0080cell6.setCellStyle(numberStyle);
					} else {
						R0080cell6.setCellValue("");
						R0080cell6.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column H
					Cell R0080cell7 = row.createCell(7);
					if (record.getR0080_after_nonresident_individual() != null) {
						R0080cell7.setCellValue(record.getR0080_after_nonresident_individual().doubleValue());
						R0080cell7.setCellStyle(numberStyle);
					} else {
						R0080cell7.setCellValue("");
						R0080cell7.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column I
					Cell R0080cell8 = row.createCell(8);
					if (record.getR0080_before_resident_retail() != null) {
						R0080cell8.setCellValue(record.getR0080_before_resident_retail().doubleValue());
						R0080cell8.setCellStyle(numberStyle);
					} else {
						R0080cell8.setCellValue("");
						R0080cell8.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column J
					Cell R0080cell9 = row.createCell(9);
					if (record.getR0080_after_resident_retail() != null) {
						R0080cell9.setCellValue(record.getR0080_after_resident_retail().doubleValue());
						R0080cell9.setCellStyle(numberStyle);
					} else {
						R0080cell9.setCellValue("");
						R0080cell9.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column K
					Cell R0080cell10 = row.createCell(10);
					if (record.getR0080_before_nonresident_retail() != null) {
						R0080cell10.setCellValue(record.getR0080_before_nonresident_retail().doubleValue());
						R0080cell10.setCellStyle(numberStyle);
					} else {
						R0080cell10.setCellValue("");
						R0080cell10.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column L
					Cell R0080cell11 = row.createCell(11);
					if (record.getR0080_after_nonresident_retail() != null) {
						R0080cell11.setCellValue(record.getR0080_after_nonresident_retail().doubleValue());
						R0080cell11.setCellStyle(numberStyle);
					} else {
						R0080cell11.setCellValue("");
						R0080cell11.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column M
					Cell R0080cell12 = row.createCell(12);
					if (record.getR0080_before_resident_sme() != null) {
						R0080cell12.setCellValue(record.getR0080_before_resident_sme().doubleValue());
						R0080cell12.setCellStyle(numberStyle);
					} else {
						R0080cell12.setCellValue("");
						R0080cell12.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column N
					Cell R0080cell13 = row.createCell(13);
					if (record.getR0080_after_resident_sme() != null) {
						R0080cell13.setCellValue(record.getR0080_after_resident_sme().doubleValue());
						R0080cell13.setCellStyle(numberStyle);
					} else {
						R0080cell13.setCellValue("");
						R0080cell13.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column O
					Cell R0080cell14 = row.createCell(14);
					if (record.getR0080_before_nonresident_sme() != null) {
						R0080cell14.setCellValue(record.getR0080_before_nonresident_sme().doubleValue());
						R0080cell14.setCellStyle(numberStyle);
					} else {
						R0080cell14.setCellValue("");
						R0080cell14.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column P
					Cell R0080cell15 = row.createCell(15);
					if (record.getR0080_after_nonresident_sme() != null) {
						R0080cell15.setCellValue(record.getR0080_after_nonresident_sme().doubleValue());
						R0080cell15.setCellStyle(numberStyle);
					} else {
						R0080cell15.setCellValue("");
						R0080cell15.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column Q
					Cell R0080cell16 = row.createCell(16);
					if (record.getR0080_before_resident_hni() != null) {
						R0080cell16.setCellValue(record.getR0080_before_resident_hni().doubleValue());
						R0080cell16.setCellStyle(numberStyle);
					} else {
						R0080cell16.setCellValue("");
						R0080cell16.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column R
					Cell R0080cell17 = row.createCell(17);
					if (record.getR0080_after_resident_hni() != null) {
						R0080cell17.setCellValue(record.getR0080_after_resident_hni().doubleValue());
						R0080cell17.setCellStyle(numberStyle);
					} else {
						R0080cell17.setCellValue("");
						R0080cell17.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column S
					Cell R0080cell18 = row.createCell(18);
					if (record.getR0080_before_nonresident_hni() != null) {
						R0080cell18.setCellValue(record.getR0080_before_nonresident_hni().doubleValue());
						R0080cell18.setCellStyle(numberStyle);
					} else {
						R0080cell18.setCellValue("");
						R0080cell18.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column T
					Cell R0080cell19 = row.createCell(19);
					if (record.getR0080_after_nonresident_hni() != null) {
						R0080cell19.setCellValue(record.getR0080_after_nonresident_hni().doubleValue());
						R0080cell19.setCellStyle(numberStyle);
					} else {
						R0080cell19.setCellValue("");
						R0080cell19.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column U
					Cell R0080cell20 = row.createCell(20);
					if (record.getR0080_before_resident_gre() != null) {
						R0080cell20.setCellValue(record.getR0080_before_resident_gre().doubleValue());
						R0080cell20.setCellStyle(numberStyle);
					} else {
						R0080cell20.setCellValue("");
						R0080cell20.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column V
					Cell R0080cell21 = row.createCell(21);
					if (record.getR0080_after_resident_gre() != null) {
						R0080cell21.setCellValue(record.getR0080_after_resident_gre().doubleValue());
						R0080cell21.setCellStyle(numberStyle);
					} else {
						R0080cell21.setCellValue("");
						R0080cell21.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column W
					Cell R0080cell22 = row.createCell(22);
					if (record.getR0080_before_nonresident_gre() != null) {
						R0080cell22.setCellValue(record.getR0080_before_nonresident_gre().doubleValue());
						R0080cell22.setCellStyle(numberStyle);
					} else {
						R0080cell22.setCellValue("");
						R0080cell22.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column X
					Cell R0080cell23 = row.createCell(23);
					if (record.getR0080_after_nonresident_gre() != null) {
						R0080cell23.setCellValue(record.getR0080_after_nonresident_gre().doubleValue());
						R0080cell23.setCellStyle(numberStyle);
					} else {
						R0080cell23.setCellValue("");
						R0080cell23.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column Y
					Cell R0080cell24 = row.createCell(24);
					if (record.getR0080_before_resident_corporate() != null) {
						R0080cell24.setCellValue(record.getR0080_before_resident_corporate().doubleValue());
						R0080cell24.setCellStyle(numberStyle);
					} else {
						R0080cell24.setCellValue("");
						R0080cell24.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column Z
					Cell R0080cell25 = row.createCell(25);
					if (record.getR0080_after_resident_corporate() != null) {
						R0080cell25.setCellValue(record.getR0080_after_resident_corporate().doubleValue());
						R0080cell25.setCellStyle(numberStyle);
					} else {
						R0080cell25.setCellValue("");
						R0080cell25.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AA
					Cell R0080cell26 = row.createCell(26);
					if (record.getR0080_before_nonresident_corporate() != null) {
						R0080cell26.setCellValue(record.getR0080_before_nonresident_corporate().doubleValue());
						R0080cell26.setCellStyle(numberStyle);
					} else {
						R0080cell26.setCellValue("");
						R0080cell26.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AB
					Cell R0080cell27 = row.createCell(27);
					if (record.getR0080_after_nonresident_corporate() != null) {
						R0080cell27.setCellValue(record.getR0080_after_nonresident_corporate().doubleValue());
						R0080cell27.setCellStyle(numberStyle);
					} else {
						R0080cell27.setCellValue("");
						R0080cell27.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AC
					Cell R0080cell28 = row.createCell(28);
					if (record.getR0080_before_resident_nbfi() != null) {
						R0080cell28.setCellValue(record.getR0080_before_resident_nbfi().doubleValue());
						R0080cell28.setCellStyle(numberStyle);
					} else {
						R0080cell28.setCellValue("");
						R0080cell28.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AD
					Cell R0080cell29 = row.createCell(29);
					if (record.getR0080_after_resident_nbfi() != null) {
						R0080cell29.setCellValue(record.getR0080_after_resident_nbfi().doubleValue());
						R0080cell29.setCellStyle(numberStyle);
					} else {
						R0080cell29.setCellValue("");
						R0080cell29.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AE
					Cell R0080cell30 = row.createCell(30);
					if (record.getR0080_before_nonresident_nbfi() != null) {
						R0080cell30.setCellValue(record.getR0080_before_nonresident_nbfi().doubleValue());
						R0080cell30.setCellStyle(numberStyle);
					} else {
						R0080cell30.setCellValue("");
						R0080cell30.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AF
					Cell R0080cell31 = row.createCell(31);
					if (record.getR0080_after_nonresident_nbfi() != null) {
						R0080cell31.setCellValue(record.getR0080_after_nonresident_nbfi().doubleValue());
						R0080cell31.setCellStyle(numberStyle);
					} else {
						R0080cell31.setCellValue("");
						R0080cell31.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AG
					Cell R0080cell32 = row.createCell(32);
					if (record.getR0080_before_resident_bank() != null) {
						R0080cell32.setCellValue(record.getR0080_before_resident_bank().doubleValue());
						R0080cell32.setCellStyle(numberStyle);
					} else {
						R0080cell32.setCellValue("");
						R0080cell32.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AH
					Cell R0080cell33 = row.createCell(33);
					if (record.getR0080_after_resident_bank() != null) {
						R0080cell33.setCellValue(record.getR0080_after_resident_bank().doubleValue());
						R0080cell33.setCellStyle(numberStyle);
					} else {
						R0080cell33.setCellValue("");
						R0080cell33.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AI
					Cell R0080cell34 = row.createCell(34);
					if (record.getR0080_before_nonresident_bank() != null) {
						R0080cell34.setCellValue(record.getR0080_before_nonresident_bank().doubleValue());
						R0080cell34.setCellStyle(numberStyle);
					} else {
						R0080cell34.setCellValue("");
						R0080cell34.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AJ
					Cell R0080cell35 = row.createCell(35);
					if (record.getR0080_after_nonresident_bank() != null) {
						R0080cell35.setCellValue(record.getR0080_after_nonresident_bank().doubleValue());
						R0080cell35.setCellStyle(numberStyle);
					} else {
						R0080cell35.setCellValue("");
						R0080cell35.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AK
					Cell R0080cell36 = row.createCell(36);
					if (record.getR0080_before_resident_government() != null) {
						R0080cell36.setCellValue(record.getR0080_before_resident_government().doubleValue());
						R0080cell36.setCellStyle(numberStyle);
					} else {
						R0080cell36.setCellValue("");
						R0080cell36.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AL
					Cell R0080cell37 = row.createCell(37);
					if (record.getR0080_after_resident_government() != null) {
						R0080cell37.setCellValue(record.getR0080_after_resident_government().doubleValue());
						R0080cell37.setCellStyle(numberStyle);
					} else {
						R0080cell37.setCellValue("");
						R0080cell37.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AM
					Cell R0080cell38 = row.createCell(38);
					if (record.getR0080_before_nonresident_government() != null) {
						R0080cell38.setCellValue(record.getR0080_before_nonresident_government().doubleValue());
						R0080cell38.setCellStyle(numberStyle);
					} else {
						R0080cell38.setCellValue("");
						R0080cell38.setCellStyle(textStyle);
					}

					/// ROW18
					//// Column AN
					Cell R0080cell39 = row.createCell(39);
					if (record.getR0080_after_nonresident_government() != null) {
						R0080cell39.setCellValue(record.getR0080_after_nonresident_government().doubleValue());
						R0080cell39.setCellStyle(numberStyle);
					} else {
						R0080cell39.setCellValue("");
						R0080cell39.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column E
					row = sheet.getRow(18);
					Cell R0090cell4 = row.createCell(4);
					if (record.getR0090_before_resident_individual() != null) {
						R0090cell4.setCellValue(record.getR0090_before_resident_individual().doubleValue());
						R0090cell4.setCellStyle(numberStyle);
					} else {
						R0090cell4.setCellValue("");
						R0090cell4.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column F
					Cell R0090cell5 = row.createCell(5);
					if (record.getR0090_after_resident_individual() != null) {
						R0090cell5.setCellValue(record.getR0090_after_resident_individual().doubleValue());
						R0090cell5.setCellStyle(numberStyle);
					} else {
						R0090cell5.setCellValue("");
						R0090cell5.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column G
					Cell R0090cell6 = row.createCell(6);
					if (record.getR0090_before_nonresident_individual() != null) {
						R0090cell6.setCellValue(record.getR0090_before_nonresident_individual().doubleValue());
						R0090cell6.setCellStyle(numberStyle);
					} else {
						R0090cell6.setCellValue("");
						R0090cell6.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column H
					Cell R0090cell7 = row.createCell(7);
					if (record.getR0090_after_nonresident_individual() != null) {
						R0090cell7.setCellValue(record.getR0090_after_nonresident_individual().doubleValue());
						R0090cell7.setCellStyle(numberStyle);
					} else {
						R0090cell7.setCellValue("");
						R0090cell7.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column I
					Cell R0090cell8 = row.createCell(8);
					if (record.getR0090_before_resident_retail() != null) {
						R0090cell8.setCellValue(record.getR0090_before_resident_retail().doubleValue());
						R0090cell8.setCellStyle(numberStyle);
					} else {
						R0090cell8.setCellValue("");
						R0090cell8.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column J
					Cell R0090cell9 = row.createCell(9);
					if (record.getR0090_after_resident_retail() != null) {
						R0090cell9.setCellValue(record.getR0090_after_resident_retail().doubleValue());
						R0090cell9.setCellStyle(numberStyle);
					} else {
						R0090cell9.setCellValue("");
						R0090cell9.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column K
					Cell R0090cell10 = row.createCell(10);
					if (record.getR0090_before_nonresident_retail() != null) {
						R0090cell10.setCellValue(record.getR0090_before_nonresident_retail().doubleValue());
						R0090cell10.setCellStyle(numberStyle);
					} else {
						R0090cell10.setCellValue("");
						R0090cell10.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column L
					Cell R0090cell11 = row.createCell(11);
					if (record.getR0090_after_nonresident_retail() != null) {
						R0090cell11.setCellValue(record.getR0090_after_nonresident_retail().doubleValue());
						R0090cell11.setCellStyle(numberStyle);
					} else {
						R0090cell11.setCellValue("");
						R0090cell11.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column M
					Cell R0090cell12 = row.createCell(12);
					if (record.getR0090_before_resident_sme() != null) {
						R0090cell12.setCellValue(record.getR0090_before_resident_sme().doubleValue());
						R0090cell12.setCellStyle(numberStyle);
					} else {
						R0090cell12.setCellValue("");
						R0090cell12.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column N
					Cell R0090cell13 = row.createCell(13);
					if (record.getR0090_after_resident_sme() != null) {
						R0090cell13.setCellValue(record.getR0090_after_resident_sme().doubleValue());
						R0090cell13.setCellStyle(numberStyle);
					} else {
						R0090cell13.setCellValue("");
						R0090cell13.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column O
					Cell R0090cell14 = row.createCell(14);
					if (record.getR0090_before_nonresident_sme() != null) {
						R0090cell14.setCellValue(record.getR0090_before_nonresident_sme().doubleValue());
						R0090cell14.setCellStyle(numberStyle);
					} else {
						R0090cell14.setCellValue("");
						R0090cell14.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column P
					Cell R0090cell15 = row.createCell(15);
					if (record.getR0090_after_nonresident_sme() != null) {
						R0090cell15.setCellValue(record.getR0090_after_nonresident_sme().doubleValue());
						R0090cell15.setCellStyle(numberStyle);
					} else {
						R0090cell15.setCellValue("");
						R0090cell15.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column Q
					Cell R0090cell16 = row.createCell(16);
					if (record.getR0090_before_resident_hni() != null) {
						R0090cell16.setCellValue(record.getR0090_before_resident_hni().doubleValue());
						R0090cell16.setCellStyle(numberStyle);
					} else {
						R0090cell16.setCellValue("");
						R0090cell16.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column R
					Cell R0090cell17 = row.createCell(17);
					if (record.getR0090_after_resident_hni() != null) {
						R0090cell17.setCellValue(record.getR0090_after_resident_hni().doubleValue());
						R0090cell17.setCellStyle(numberStyle);
					} else {
						R0090cell17.setCellValue("");
						R0090cell17.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column S
					Cell R0090cell18 = row.createCell(18);
					if (record.getR0090_before_nonresident_hni() != null) {
						R0090cell18.setCellValue(record.getR0090_before_nonresident_hni().doubleValue());
						R0090cell18.setCellStyle(numberStyle);
					} else {
						R0090cell18.setCellValue("");
						R0090cell18.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column T
					Cell R0090cell19 = row.createCell(19);
					if (record.getR0090_after_nonresident_hni() != null) {
						R0090cell19.setCellValue(record.getR0090_after_nonresident_hni().doubleValue());
						R0090cell19.setCellStyle(numberStyle);
					} else {
						R0090cell19.setCellValue("");
						R0090cell19.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column U
					Cell R0090cell20 = row.createCell(20);
					if (record.getR0090_before_resident_gre() != null) {
						R0090cell20.setCellValue(record.getR0090_before_resident_gre().doubleValue());
						R0090cell20.setCellStyle(numberStyle);
					} else {
						R0090cell20.setCellValue("");
						R0090cell20.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column V
					Cell R0090cell21 = row.createCell(21);
					if (record.getR0090_after_resident_gre() != null) {
						R0090cell21.setCellValue(record.getR0090_after_resident_gre().doubleValue());
						R0090cell21.setCellStyle(numberStyle);
					} else {
						R0090cell21.setCellValue("");
						R0090cell21.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column W
					Cell R0090cell22 = row.createCell(22);
					if (record.getR0090_before_nonresident_gre() != null) {
						R0090cell22.setCellValue(record.getR0090_before_nonresident_gre().doubleValue());
						R0090cell22.setCellStyle(numberStyle);
					} else {
						R0090cell22.setCellValue("");
						R0090cell22.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column X
					Cell R0090cell23 = row.createCell(23);
					if (record.getR0090_after_nonresident_gre() != null) {
						R0090cell23.setCellValue(record.getR0090_after_nonresident_gre().doubleValue());
						R0090cell23.setCellStyle(numberStyle);
					} else {
						R0090cell23.setCellValue("");
						R0090cell23.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column Y
					Cell R0090cell24 = row.createCell(24);
					if (record.getR0090_before_resident_corporate() != null) {
						R0090cell24.setCellValue(record.getR0090_before_resident_corporate().doubleValue());
						R0090cell24.setCellStyle(numberStyle);
					} else {
						R0090cell24.setCellValue("");
						R0090cell24.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column Z
					Cell R0090cell25 = row.createCell(25);
					if (record.getR0090_after_resident_corporate() != null) {
						R0090cell25.setCellValue(record.getR0090_after_resident_corporate().doubleValue());
						R0090cell25.setCellStyle(numberStyle);
					} else {
						R0090cell25.setCellValue("");
						R0090cell25.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AA
					Cell R0090cell26 = row.createCell(26);
					if (record.getR0090_before_nonresident_corporate() != null) {
						R0090cell26.setCellValue(record.getR0090_before_nonresident_corporate().doubleValue());
						R0090cell26.setCellStyle(numberStyle);
					} else {
						R0090cell26.setCellValue("");
						R0090cell26.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AB
					Cell R0090cell27 = row.createCell(27);
					if (record.getR0090_after_nonresident_corporate() != null) {
						R0090cell27.setCellValue(record.getR0090_after_nonresident_corporate().doubleValue());
						R0090cell27.setCellStyle(numberStyle);
					} else {
						R0090cell27.setCellValue("");
						R0090cell27.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AC
					Cell R0090cell28 = row.createCell(28);
					if (record.getR0090_before_resident_nbfi() != null) {
						R0090cell28.setCellValue(record.getR0090_before_resident_nbfi().doubleValue());
						R0090cell28.setCellStyle(numberStyle);
					} else {
						R0090cell28.setCellValue("");
						R0090cell28.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AD
					Cell R0090cell29 = row.createCell(29);
					if (record.getR0090_after_resident_nbfi() != null) {
						R0090cell29.setCellValue(record.getR0090_after_resident_nbfi().doubleValue());
						R0090cell29.setCellStyle(numberStyle);
					} else {
						R0090cell29.setCellValue("");
						R0090cell29.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AE
					Cell R0090cell30 = row.createCell(30);
					if (record.getR0090_before_nonresident_nbfi() != null) {
						R0090cell30.setCellValue(record.getR0090_before_nonresident_nbfi().doubleValue());
						R0090cell30.setCellStyle(numberStyle);
					} else {
						R0090cell30.setCellValue("");
						R0090cell30.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AF
					Cell R0090cell31 = row.createCell(31);
					if (record.getR0090_after_nonresident_nbfi() != null) {
						R0090cell31.setCellValue(record.getR0090_after_nonresident_nbfi().doubleValue());
						R0090cell31.setCellStyle(numberStyle);
					} else {
						R0090cell31.setCellValue("");
						R0090cell31.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AG
					Cell R0090cell32 = row.createCell(32);
					if (record.getR0090_before_resident_bank() != null) {
						R0090cell32.setCellValue(record.getR0090_before_resident_bank().doubleValue());
						R0090cell32.setCellStyle(numberStyle);
					} else {
						R0090cell32.setCellValue("");
						R0090cell32.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AH
					Cell R0090cell33 = row.createCell(33);
					if (record.getR0090_after_resident_bank() != null) {
						R0090cell33.setCellValue(record.getR0090_after_resident_bank().doubleValue());
						R0090cell33.setCellStyle(numberStyle);
					} else {
						R0090cell33.setCellValue("");
						R0090cell33.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AI
					Cell R0090cell34 = row.createCell(34);
					if (record.getR0090_before_nonresident_bank() != null) {
						R0090cell34.setCellValue(record.getR0090_before_nonresident_bank().doubleValue());
						R0090cell34.setCellStyle(numberStyle);
					} else {
						R0090cell34.setCellValue("");
						R0090cell34.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AJ
					Cell R0090cell35 = row.createCell(35);
					if (record.getR0090_after_nonresident_bank() != null) {
						R0090cell35.setCellValue(record.getR0090_after_nonresident_bank().doubleValue());
						R0090cell35.setCellStyle(numberStyle);
					} else {
						R0090cell35.setCellValue("");
						R0090cell35.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AK
					Cell R0090cell36 = row.createCell(36);
					if (record.getR0090_before_resident_government() != null) {
						R0090cell36.setCellValue(record.getR0090_before_resident_government().doubleValue());
						R0090cell36.setCellStyle(numberStyle);
					} else {
						R0090cell36.setCellValue("");
						R0090cell36.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AL
					Cell R0090cell37 = row.createCell(37);
					if (record.getR0090_after_resident_government() != null) {
						R0090cell37.setCellValue(record.getR0090_after_resident_government().doubleValue());
						R0090cell37.setCellStyle(numberStyle);
					} else {
						R0090cell37.setCellValue("");
						R0090cell37.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AM
					Cell R0090cell38 = row.createCell(38);
					if (record.getR0090_before_nonresident_government() != null) {
						R0090cell38.setCellValue(record.getR0090_before_nonresident_government().doubleValue());
						R0090cell38.setCellStyle(numberStyle);
					} else {
						R0090cell38.setCellValue("");
						R0090cell38.setCellStyle(textStyle);
					}

					/// ROW19
					//// Column AN
					Cell R0090cell39 = row.createCell(39);
					if (record.getR0090_after_nonresident_government() != null) {
						R0090cell39.setCellValue(record.getR0090_after_nonresident_government().doubleValue());
						R0090cell39.setCellStyle(numberStyle);
					} else {
						R0090cell39.setCellValue("");
						R0090cell39.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column E
					row = sheet.getRow(20);
					Cell R0110cell4 = row.createCell(4);
					if (record.getR0110_before_resident_individual() != null) {
						R0110cell4.setCellValue(record.getR0110_before_resident_individual().doubleValue());
						R0110cell4.setCellStyle(numberStyle);
					} else {
						R0110cell4.setCellValue("");
						R0110cell4.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column F
					Cell R0110cell5 = row.createCell(5);
					if (record.getR0110_after_resident_individual() != null) {
						R0110cell5.setCellValue(record.getR0110_after_resident_individual().doubleValue());
						R0110cell5.setCellStyle(numberStyle);
					} else {
						R0110cell5.setCellValue("");
						R0110cell5.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column G
					Cell R0110cell6 = row.createCell(6);
					if (record.getR0110_before_nonresident_individual() != null) {
						R0110cell6.setCellValue(record.getR0110_before_nonresident_individual().doubleValue());
						R0110cell6.setCellStyle(numberStyle);
					} else {
						R0110cell6.setCellValue("");
						R0110cell6.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column H
					Cell R0110cell7 = row.createCell(7);
					if (record.getR0110_after_nonresident_individual() != null) {
						R0110cell7.setCellValue(record.getR0110_after_nonresident_individual().doubleValue());
						R0110cell7.setCellStyle(numberStyle);
					} else {
						R0110cell7.setCellValue("");
						R0110cell7.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column I
					Cell R0110cell8 = row.createCell(8);
					if (record.getR0110_before_resident_retail() != null) {
						R0110cell8.setCellValue(record.getR0110_before_resident_retail().doubleValue());
						R0110cell8.setCellStyle(numberStyle);
					} else {
						R0110cell8.setCellValue("");
						R0110cell8.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column J
					Cell R0110cell9 = row.createCell(9);
					if (record.getR0110_after_resident_retail() != null) {
						R0110cell9.setCellValue(record.getR0110_after_resident_retail().doubleValue());
						R0110cell9.setCellStyle(numberStyle);
					} else {
						R0110cell9.setCellValue("");
						R0110cell9.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column K
					Cell R0110cell10 = row.createCell(10);
					if (record.getR0110_before_nonresident_retail() != null) {
						R0110cell10.setCellValue(record.getR0110_before_nonresident_retail().doubleValue());
						R0110cell10.setCellStyle(numberStyle);
					} else {
						R0110cell10.setCellValue("");
						R0110cell10.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column L
					Cell R0110cell11 = row.createCell(11);
					if (record.getR0110_after_nonresident_retail() != null) {
						R0110cell11.setCellValue(record.getR0110_after_nonresident_retail().doubleValue());
						R0110cell11.setCellStyle(numberStyle);
					} else {
						R0110cell11.setCellValue("");
						R0110cell11.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column M
					Cell R0110cell12 = row.createCell(12);
					if (record.getR0110_before_resident_sme() != null) {
						R0110cell12.setCellValue(record.getR0110_before_resident_sme().doubleValue());
						R0110cell12.setCellStyle(numberStyle);
					} else {
						R0110cell12.setCellValue("");
						R0110cell12.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column N
					Cell R0110cell13 = row.createCell(13);
					if (record.getR0110_after_resident_sme() != null) {
						R0110cell13.setCellValue(record.getR0110_after_resident_sme().doubleValue());
						R0110cell13.setCellStyle(numberStyle);
					} else {
						R0110cell13.setCellValue("");
						R0110cell13.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column O
					Cell R0110cell14 = row.createCell(14);
					if (record.getR0110_before_nonresident_sme() != null) {
						R0110cell14.setCellValue(record.getR0110_before_nonresident_sme().doubleValue());
						R0110cell14.setCellStyle(numberStyle);
					} else {
						R0110cell14.setCellValue("");
						R0110cell14.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column P
					Cell R0110cell15 = row.createCell(15);
					if (record.getR0110_after_nonresident_sme() != null) {
						R0110cell15.setCellValue(record.getR0110_after_nonresident_sme().doubleValue());
						R0110cell15.setCellStyle(numberStyle);
					} else {
						R0110cell15.setCellValue("");
						R0110cell15.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column Q
					Cell R0110cell16 = row.createCell(16);
					if (record.getR0110_before_resident_hni() != null) {
						R0110cell16.setCellValue(record.getR0110_before_resident_hni().doubleValue());
						R0110cell16.setCellStyle(numberStyle);
					} else {
						R0110cell16.setCellValue("");
						R0110cell16.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column R
					Cell R0110cell17 = row.createCell(17);
					if (record.getR0110_after_resident_hni() != null) {
						R0110cell17.setCellValue(record.getR0110_after_resident_hni().doubleValue());
						R0110cell17.setCellStyle(numberStyle);
					} else {
						R0110cell17.setCellValue("");
						R0110cell17.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column S
					Cell R0110cell18 = row.createCell(18);
					if (record.getR0110_before_nonresident_hni() != null) {
						R0110cell18.setCellValue(record.getR0110_before_nonresident_hni().doubleValue());
						R0110cell18.setCellStyle(numberStyle);
					} else {
						R0110cell18.setCellValue("");
						R0110cell18.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column T
					Cell R0110cell19 = row.createCell(19);
					if (record.getR0110_after_nonresident_hni() != null) {
						R0110cell19.setCellValue(record.getR0110_after_nonresident_hni().doubleValue());
						R0110cell19.setCellStyle(numberStyle);
					} else {
						R0110cell19.setCellValue("");
						R0110cell19.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column U
					Cell R0110cell20 = row.createCell(20);
					if (record.getR0110_before_resident_gre() != null) {
						R0110cell20.setCellValue(record.getR0110_before_resident_gre().doubleValue());
						R0110cell20.setCellStyle(numberStyle);
					} else {
						R0110cell20.setCellValue("");
						R0110cell20.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column V
					Cell R0110cell21 = row.createCell(21);
					if (record.getR0110_after_resident_gre() != null) {
						R0110cell21.setCellValue(record.getR0110_after_resident_gre().doubleValue());
						R0110cell21.setCellStyle(numberStyle);
					} else {
						R0110cell21.setCellValue("");
						R0110cell21.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column W
					Cell R0110cell22 = row.createCell(22);
					if (record.getR0110_before_nonresident_gre() != null) {
						R0110cell22.setCellValue(record.getR0110_before_nonresident_gre().doubleValue());
						R0110cell22.setCellStyle(numberStyle);
					} else {
						R0110cell22.setCellValue("");
						R0110cell22.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column X
					Cell R0110cell23 = row.createCell(23);
					if (record.getR0110_after_nonresident_gre() != null) {
						R0110cell23.setCellValue(record.getR0110_after_nonresident_gre().doubleValue());
						R0110cell23.setCellStyle(numberStyle);
					} else {
						R0110cell23.setCellValue("");
						R0110cell23.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column Y
					Cell R0110cell24 = row.createCell(24);
					if (record.getR0110_before_resident_corporate() != null) {
						R0110cell24.setCellValue(record.getR0110_before_resident_corporate().doubleValue());
						R0110cell24.setCellStyle(numberStyle);
					} else {
						R0110cell24.setCellValue("");
						R0110cell24.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column Z
					Cell R0110cell25 = row.createCell(25);
					if (record.getR0110_after_resident_corporate() != null) {
						R0110cell25.setCellValue(record.getR0110_after_resident_corporate().doubleValue());
						R0110cell25.setCellStyle(numberStyle);
					} else {
						R0110cell25.setCellValue("");
						R0110cell25.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AA
					Cell R0110cell26 = row.createCell(26);
					if (record.getR0110_before_nonresident_corporate() != null) {
						R0110cell26.setCellValue(record.getR0110_before_nonresident_corporate().doubleValue());
						R0110cell26.setCellStyle(numberStyle);
					} else {
						R0110cell26.setCellValue("");
						R0110cell26.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AB
					Cell R0110cell27 = row.createCell(27);
					if (record.getR0110_after_nonresident_corporate() != null) {
						R0110cell27.setCellValue(record.getR0110_after_nonresident_corporate().doubleValue());
						R0110cell27.setCellStyle(numberStyle);
					} else {
						R0110cell27.setCellValue("");
						R0110cell27.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AC
					Cell R0110cell28 = row.createCell(28);
					if (record.getR0110_before_resident_nbfi() != null) {
						R0110cell28.setCellValue(record.getR0110_before_resident_nbfi().doubleValue());
						R0110cell28.setCellStyle(numberStyle);
					} else {
						R0110cell28.setCellValue("");
						R0110cell28.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AD
					Cell R0110cell29 = row.createCell(29);
					if (record.getR0110_after_resident_nbfi() != null) {
						R0110cell29.setCellValue(record.getR0110_after_resident_nbfi().doubleValue());
						R0110cell29.setCellStyle(numberStyle);
					} else {
						R0110cell29.setCellValue("");
						R0110cell29.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AE
					Cell R0110cell30 = row.createCell(30);
					if (record.getR0110_before_nonresident_nbfi() != null) {
						R0110cell30.setCellValue(record.getR0110_before_nonresident_nbfi().doubleValue());
						R0110cell30.setCellStyle(numberStyle);
					} else {
						R0110cell30.setCellValue("");
						R0110cell30.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AF
					Cell R0110cell31 = row.createCell(31);
					if (record.getR0110_after_nonresident_nbfi() != null) {
						R0110cell31.setCellValue(record.getR0110_after_nonresident_nbfi().doubleValue());
						R0110cell31.setCellStyle(numberStyle);
					} else {
						R0110cell31.setCellValue("");
						R0110cell31.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AG
					Cell R0110cell32 = row.createCell(32);
					if (record.getR0110_before_resident_bank() != null) {
						R0110cell32.setCellValue(record.getR0110_before_resident_bank().doubleValue());
						R0110cell32.setCellStyle(numberStyle);
					} else {
						R0110cell32.setCellValue("");
						R0110cell32.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AH
					Cell R0110cell33 = row.createCell(33);
					if (record.getR0110_after_resident_bank() != null) {
						R0110cell33.setCellValue(record.getR0110_after_resident_bank().doubleValue());
						R0110cell33.setCellStyle(numberStyle);
					} else {
						R0110cell33.setCellValue("");
						R0110cell33.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AI
					Cell R0110cell34 = row.createCell(34);
					if (record.getR0110_before_nonresident_bank() != null) {
						R0110cell34.setCellValue(record.getR0110_before_nonresident_bank().doubleValue());
						R0110cell34.setCellStyle(numberStyle);
					} else {
						R0110cell34.setCellValue("");
						R0110cell34.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AJ
					Cell R0110cell35 = row.createCell(35);
					if (record.getR0110_after_nonresident_bank() != null) {
						R0110cell35.setCellValue(record.getR0110_after_nonresident_bank().doubleValue());
						R0110cell35.setCellStyle(numberStyle);
					} else {
						R0110cell35.setCellValue("");
						R0110cell35.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AK
					Cell R0110cell36 = row.createCell(36);
					if (record.getR0110_before_resident_government() != null) {
						R0110cell36.setCellValue(record.getR0110_before_resident_government().doubleValue());
						R0110cell36.setCellStyle(numberStyle);
					} else {
						R0110cell36.setCellValue("");
						R0110cell36.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AL
					Cell R0110cell37 = row.createCell(37);
					if (record.getR0110_after_resident_government() != null) {
						R0110cell37.setCellValue(record.getR0110_after_resident_government().doubleValue());
						R0110cell37.setCellStyle(numberStyle);
					} else {
						R0110cell37.setCellValue("");
						R0110cell37.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AM
					Cell R0110cell38 = row.createCell(38);
					if (record.getR0110_before_nonresident_government() != null) {
						R0110cell38.setCellValue(record.getR0110_before_nonresident_government().doubleValue());
						R0110cell38.setCellStyle(numberStyle);
					} else {
						R0110cell38.setCellValue("");
						R0110cell38.setCellStyle(textStyle);
					}

					/// ROW21
					//// Column AN
					Cell R0110cell39 = row.createCell(39);
					if (record.getR0110_after_nonresident_government() != null) {
						R0110cell39.setCellValue(record.getR0110_after_nonresident_government().doubleValue());
						R0110cell39.setCellStyle(numberStyle);
					} else {
						R0110cell39.setCellValue("");
						R0110cell39.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column E
					row = sheet.getRow(21);
					Cell R0120cell4 = row.createCell(4);
					if (record.getR0120_before_resident_individual() != null) {
						R0120cell4.setCellValue(record.getR0120_before_resident_individual().doubleValue());
						R0120cell4.setCellStyle(numberStyle);
					} else {
						R0120cell4.setCellValue("");
						R0120cell4.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column F
					Cell R0120cell5 = row.createCell(5);
					if (record.getR0120_after_resident_individual() != null) {
						R0120cell5.setCellValue(record.getR0120_after_resident_individual().doubleValue());
						R0120cell5.setCellStyle(numberStyle);
					} else {
						R0120cell5.setCellValue("");
						R0120cell5.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column G
					Cell R0120cell6 = row.createCell(6);
					if (record.getR0120_before_nonresident_individual() != null) {
						R0120cell6.setCellValue(record.getR0120_before_nonresident_individual().doubleValue());
						R0120cell6.setCellStyle(numberStyle);
					} else {
						R0120cell6.setCellValue("");
						R0120cell6.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column H
					Cell R0120cell7 = row.createCell(7);
					if (record.getR0120_after_nonresident_individual() != null) {
						R0120cell7.setCellValue(record.getR0120_after_nonresident_individual().doubleValue());
						R0120cell7.setCellStyle(numberStyle);
					} else {
						R0120cell7.setCellValue("");
						R0120cell7.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column I
					Cell R0120cell8 = row.createCell(8);
					if (record.getR0120_before_resident_retail() != null) {
						R0120cell8.setCellValue(record.getR0120_before_resident_retail().doubleValue());
						R0120cell8.setCellStyle(numberStyle);
					} else {
						R0120cell8.setCellValue("");
						R0120cell8.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column J
					Cell R0120cell9 = row.createCell(9);
					if (record.getR0120_after_resident_retail() != null) {
						R0120cell9.setCellValue(record.getR0120_after_resident_retail().doubleValue());
						R0120cell9.setCellStyle(numberStyle);
					} else {
						R0120cell9.setCellValue("");
						R0120cell9.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column K
					Cell R0120cell10 = row.createCell(10);
					if (record.getR0120_before_nonresident_retail() != null) {
						R0120cell10.setCellValue(record.getR0120_before_nonresident_retail().doubleValue());
						R0120cell10.setCellStyle(numberStyle);
					} else {
						R0120cell10.setCellValue("");
						R0120cell10.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column L
					Cell R0120cell11 = row.createCell(11);
					if (record.getR0120_after_nonresident_retail() != null) {
						R0120cell11.setCellValue(record.getR0120_after_nonresident_retail().doubleValue());
						R0120cell11.setCellStyle(numberStyle);
					} else {
						R0120cell11.setCellValue("");
						R0120cell11.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column M
					Cell R0120cell12 = row.createCell(12);
					if (record.getR0120_before_resident_sme() != null) {
						R0120cell12.setCellValue(record.getR0120_before_resident_sme().doubleValue());
						R0120cell12.setCellStyle(numberStyle);
					} else {
						R0120cell12.setCellValue("");
						R0120cell12.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column N
					Cell R0120cell13 = row.createCell(13);
					if (record.getR0120_after_resident_sme() != null) {
						R0120cell13.setCellValue(record.getR0120_after_resident_sme().doubleValue());
						R0120cell13.setCellStyle(numberStyle);
					} else {
						R0120cell13.setCellValue("");
						R0120cell13.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column O
					Cell R0120cell14 = row.createCell(14);
					if (record.getR0120_before_nonresident_sme() != null) {
						R0120cell14.setCellValue(record.getR0120_before_nonresident_sme().doubleValue());
						R0120cell14.setCellStyle(numberStyle);
					} else {
						R0120cell14.setCellValue("");
						R0120cell14.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column P
					Cell R0120cell15 = row.createCell(15);
					if (record.getR0120_after_nonresident_sme() != null) {
						R0120cell15.setCellValue(record.getR0120_after_nonresident_sme().doubleValue());
						R0120cell15.setCellStyle(numberStyle);
					} else {
						R0120cell15.setCellValue("");
						R0120cell15.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column Q
					Cell R0120cell16 = row.createCell(16);
					if (record.getR0120_before_resident_hni() != null) {
						R0120cell16.setCellValue(record.getR0120_before_resident_hni().doubleValue());
						R0120cell16.setCellStyle(numberStyle);
					} else {
						R0120cell16.setCellValue("");
						R0120cell16.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column R
					Cell R0120cell17 = row.createCell(17);
					if (record.getR0120_after_resident_hni() != null) {
						R0120cell17.setCellValue(record.getR0120_after_resident_hni().doubleValue());
						R0120cell17.setCellStyle(numberStyle);
					} else {
						R0120cell17.setCellValue("");
						R0120cell17.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column S
					Cell R0120cell18 = row.createCell(18);
					if (record.getR0120_before_nonresident_hni() != null) {
						R0120cell18.setCellValue(record.getR0120_before_nonresident_hni().doubleValue());
						R0120cell18.setCellStyle(numberStyle);
					} else {
						R0120cell18.setCellValue("");
						R0120cell18.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column T
					Cell R0120cell19 = row.createCell(19);
					if (record.getR0120_after_nonresident_hni() != null) {
						R0120cell19.setCellValue(record.getR0120_after_nonresident_hni().doubleValue());
						R0120cell19.setCellStyle(numberStyle);
					} else {
						R0120cell19.setCellValue("");
						R0120cell19.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column U
					Cell R0120cell20 = row.createCell(20);
					if (record.getR0120_before_resident_gre() != null) {
						R0120cell20.setCellValue(record.getR0120_before_resident_gre().doubleValue());
						R0120cell20.setCellStyle(numberStyle);
					} else {
						R0120cell20.setCellValue("");
						R0120cell20.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column V
					Cell R0120cell21 = row.createCell(21);
					if (record.getR0120_after_resident_gre() != null) {
						R0120cell21.setCellValue(record.getR0120_after_resident_gre().doubleValue());
						R0120cell21.setCellStyle(numberStyle);
					} else {
						R0120cell21.setCellValue("");
						R0120cell21.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column W
					Cell R0120cell22 = row.createCell(22);
					if (record.getR0120_before_nonresident_gre() != null) {
						R0120cell22.setCellValue(record.getR0120_before_nonresident_gre().doubleValue());
						R0120cell22.setCellStyle(numberStyle);
					} else {
						R0120cell22.setCellValue("");
						R0120cell22.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column X
					Cell R0120cell23 = row.createCell(23);
					if (record.getR0120_after_nonresident_gre() != null) {
						R0120cell23.setCellValue(record.getR0120_after_nonresident_gre().doubleValue());
						R0120cell23.setCellStyle(numberStyle);
					} else {
						R0120cell23.setCellValue("");
						R0120cell23.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column Y
					Cell R0120cell24 = row.createCell(24);
					if (record.getR0120_before_resident_corporate() != null) {
						R0120cell24.setCellValue(record.getR0120_before_resident_corporate().doubleValue());
						R0120cell24.setCellStyle(numberStyle);
					} else {
						R0120cell24.setCellValue("");
						R0120cell24.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column Z
					Cell R0120cell25 = row.createCell(25);
					if (record.getR0120_after_resident_corporate() != null) {
						R0120cell25.setCellValue(record.getR0120_after_resident_corporate().doubleValue());
						R0120cell25.setCellStyle(numberStyle);
					} else {
						R0120cell25.setCellValue("");
						R0120cell25.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AA
					Cell R0120cell26 = row.createCell(26);
					if (record.getR0120_before_nonresident_corporate() != null) {
						R0120cell26.setCellValue(record.getR0120_before_nonresident_corporate().doubleValue());
						R0120cell26.setCellStyle(numberStyle);
					} else {
						R0120cell26.setCellValue("");
						R0120cell26.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AB
					Cell R0120cell27 = row.createCell(27);
					if (record.getR0120_after_nonresident_corporate() != null) {
						R0120cell27.setCellValue(record.getR0120_after_nonresident_corporate().doubleValue());
						R0120cell27.setCellStyle(numberStyle);
					} else {
						R0120cell27.setCellValue("");
						R0120cell27.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AC
					Cell R0120cell28 = row.createCell(28);
					if (record.getR0120_before_resident_nbfi() != null) {
						R0120cell28.setCellValue(record.getR0120_before_resident_nbfi().doubleValue());
						R0120cell28.setCellStyle(numberStyle);
					} else {
						R0120cell28.setCellValue("");
						R0120cell28.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AD
					Cell R0120cell29 = row.createCell(29);
					if (record.getR0120_after_resident_nbfi() != null) {
						R0120cell29.setCellValue(record.getR0120_after_resident_nbfi().doubleValue());
						R0120cell29.setCellStyle(numberStyle);
					} else {
						R0120cell29.setCellValue("");
						R0120cell29.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AE
					Cell R0120cell30 = row.createCell(30);
					if (record.getR0120_before_nonresident_nbfi() != null) {
						R0120cell30.setCellValue(record.getR0120_before_nonresident_nbfi().doubleValue());
						R0120cell30.setCellStyle(numberStyle);
					} else {
						R0120cell30.setCellValue("");
						R0120cell30.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AF
					Cell R0120cell31 = row.createCell(31);
					if (record.getR0120_after_nonresident_nbfi() != null) {
						R0120cell31.setCellValue(record.getR0120_after_nonresident_nbfi().doubleValue());
						R0120cell31.setCellStyle(numberStyle);
					} else {
						R0120cell31.setCellValue("");
						R0120cell31.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AG
					Cell R0120cell32 = row.createCell(32);
					if (record.getR0120_before_resident_bank() != null) {
						R0120cell32.setCellValue(record.getR0120_before_resident_bank().doubleValue());
						R0120cell32.setCellStyle(numberStyle);
					} else {
						R0120cell32.setCellValue("");
						R0120cell32.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AH
					Cell R0120cell33 = row.createCell(33);
					if (record.getR0120_after_resident_bank() != null) {
						R0120cell33.setCellValue(record.getR0120_after_resident_bank().doubleValue());
						R0120cell33.setCellStyle(numberStyle);
					} else {
						R0120cell33.setCellValue("");
						R0120cell33.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AI
					Cell R0120cell34 = row.createCell(34);
					if (record.getR0120_before_nonresident_bank() != null) {
						R0120cell34.setCellValue(record.getR0120_before_nonresident_bank().doubleValue());
						R0120cell34.setCellStyle(numberStyle);
					} else {
						R0120cell34.setCellValue("");
						R0120cell34.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AJ
					Cell R0120cell35 = row.createCell(35);
					if (record.getR0120_after_nonresident_bank() != null) {
						R0120cell35.setCellValue(record.getR0120_after_nonresident_bank().doubleValue());
						R0120cell35.setCellStyle(numberStyle);
					} else {
						R0120cell35.setCellValue("");
						R0120cell35.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AK
					Cell R0120cell36 = row.createCell(36);
					if (record.getR0120_before_resident_government() != null) {
						R0120cell36.setCellValue(record.getR0120_before_resident_government().doubleValue());
						R0120cell36.setCellStyle(numberStyle);
					} else {
						R0120cell36.setCellValue("");
						R0120cell36.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AL
					Cell R0120cell37 = row.createCell(37);
					if (record.getR0120_after_resident_government() != null) {
						R0120cell37.setCellValue(record.getR0120_after_resident_government().doubleValue());
						R0120cell37.setCellStyle(numberStyle);
					} else {
						R0120cell37.setCellValue("");
						R0120cell37.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AM
					Cell R0120cell38 = row.createCell(38);
					if (record.getR0120_before_nonresident_government() != null) {
						R0120cell38.setCellValue(record.getR0120_before_nonresident_government().doubleValue());
						R0120cell38.setCellStyle(numberStyle);
					} else {
						R0120cell38.setCellValue("");
						R0120cell38.setCellStyle(textStyle);
					}

					/// ROW22
					//// Column AN
					Cell R0120cell39 = row.createCell(39);
					if (record.getR0120_after_nonresident_government() != null) {
						R0120cell39.setCellValue(record.getR0120_after_nonresident_government().doubleValue());
						R0120cell39.setCellStyle(numberStyle);
					} else {
						R0120cell39.setCellValue("");
						R0120cell39.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column E
					row = sheet.getRow(22);
					Cell R0130cell4 = row.createCell(4);
					if (record.getR0130_before_resident_individual() != null) {
						R0130cell4.setCellValue(record.getR0130_before_resident_individual().doubleValue());
						R0130cell4.setCellStyle(numberStyle);
					} else {
						R0130cell4.setCellValue("");
						R0130cell4.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column F
					Cell R0130cell5 = row.createCell(5);
					if (record.getR0130_after_resident_individual() != null) {
						R0130cell5.setCellValue(record.getR0130_after_resident_individual().doubleValue());
						R0130cell5.setCellStyle(numberStyle);
					} else {
						R0130cell5.setCellValue("");
						R0130cell5.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column G
					Cell R0130cell6 = row.createCell(6);
					if (record.getR0130_before_nonresident_individual() != null) {
						R0130cell6.setCellValue(record.getR0130_before_nonresident_individual().doubleValue());
						R0130cell6.setCellStyle(numberStyle);
					} else {
						R0130cell6.setCellValue("");
						R0130cell6.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column H
					Cell R0130cell7 = row.createCell(7);
					if (record.getR0130_after_nonresident_individual() != null) {
						R0130cell7.setCellValue(record.getR0130_after_nonresident_individual().doubleValue());
						R0130cell7.setCellStyle(numberStyle);
					} else {
						R0130cell7.setCellValue("");
						R0130cell7.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column I
					Cell R0130cell8 = row.createCell(8);
					if (record.getR0130_before_resident_retail() != null) {
						R0130cell8.setCellValue(record.getR0130_before_resident_retail().doubleValue());
						R0130cell8.setCellStyle(numberStyle);
					} else {
						R0130cell8.setCellValue("");
						R0130cell8.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column J
					Cell R0130cell9 = row.createCell(9);
					if (record.getR0130_after_resident_retail() != null) {
						R0130cell9.setCellValue(record.getR0130_after_resident_retail().doubleValue());
						R0130cell9.setCellStyle(numberStyle);
					} else {
						R0130cell9.setCellValue("");
						R0130cell9.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column K
					Cell R0130cell10 = row.createCell(10);
					if (record.getR0130_before_nonresident_retail() != null) {
						R0130cell10.setCellValue(record.getR0130_before_nonresident_retail().doubleValue());
						R0130cell10.setCellStyle(numberStyle);
					} else {
						R0130cell10.setCellValue("");
						R0130cell10.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column L
					Cell R0130cell11 = row.createCell(11);
					if (record.getR0130_after_nonresident_retail() != null) {
						R0130cell11.setCellValue(record.getR0130_after_nonresident_retail().doubleValue());
						R0130cell11.setCellStyle(numberStyle);
					} else {
						R0130cell11.setCellValue("");
						R0130cell11.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column M
					Cell R0130cell12 = row.createCell(12);
					if (record.getR0130_before_resident_sme() != null) {
						R0130cell12.setCellValue(record.getR0130_before_resident_sme().doubleValue());
						R0130cell12.setCellStyle(numberStyle);
					} else {
						R0130cell12.setCellValue("");
						R0130cell12.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column N
					Cell R0130cell13 = row.createCell(13);
					if (record.getR0130_after_resident_sme() != null) {
						R0130cell13.setCellValue(record.getR0130_after_resident_sme().doubleValue());
						R0130cell13.setCellStyle(numberStyle);
					} else {
						R0130cell13.setCellValue("");
						R0130cell13.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column O
					Cell R0130cell14 = row.createCell(14);
					if (record.getR0130_before_nonresident_sme() != null) {
						R0130cell14.setCellValue(record.getR0130_before_nonresident_sme().doubleValue());
						R0130cell14.setCellStyle(numberStyle);
					} else {
						R0130cell14.setCellValue("");
						R0130cell14.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column P
					Cell R0130cell15 = row.createCell(15);
					if (record.getR0130_after_nonresident_sme() != null) {
						R0130cell15.setCellValue(record.getR0130_after_nonresident_sme().doubleValue());
						R0130cell15.setCellStyle(numberStyle);
					} else {
						R0130cell15.setCellValue("");
						R0130cell15.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column Q
					Cell R0130cell16 = row.createCell(16);
					if (record.getR0130_before_resident_hni() != null) {
						R0130cell16.setCellValue(record.getR0130_before_resident_hni().doubleValue());
						R0130cell16.setCellStyle(numberStyle);
					} else {
						R0130cell16.setCellValue("");
						R0130cell16.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column R
					Cell R0130cell17 = row.createCell(17);
					if (record.getR0130_after_resident_hni() != null) {
						R0130cell17.setCellValue(record.getR0130_after_resident_hni().doubleValue());
						R0130cell17.setCellStyle(numberStyle);
					} else {
						R0130cell17.setCellValue("");
						R0130cell17.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column S
					Cell R0130cell18 = row.createCell(18);
					if (record.getR0130_before_nonresident_hni() != null) {
						R0130cell18.setCellValue(record.getR0130_before_nonresident_hni().doubleValue());
						R0130cell18.setCellStyle(numberStyle);
					} else {
						R0130cell18.setCellValue("");
						R0130cell18.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column T
					Cell R0130cell19 = row.createCell(19);
					if (record.getR0130_after_nonresident_hni() != null) {
						R0130cell19.setCellValue(record.getR0130_after_nonresident_hni().doubleValue());
						R0130cell19.setCellStyle(numberStyle);
					} else {
						R0130cell19.setCellValue("");
						R0130cell19.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column U
					Cell R0130cell20 = row.createCell(20);
					if (record.getR0130_before_resident_gre() != null) {
						R0130cell20.setCellValue(record.getR0130_before_resident_gre().doubleValue());
						R0130cell20.setCellStyle(numberStyle);
					} else {
						R0130cell20.setCellValue("");
						R0130cell20.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column V
					Cell R0130cell21 = row.createCell(21);
					if (record.getR0130_after_resident_gre() != null) {
						R0130cell21.setCellValue(record.getR0130_after_resident_gre().doubleValue());
						R0130cell21.setCellStyle(numberStyle);
					} else {
						R0130cell21.setCellValue("");
						R0130cell21.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column W
					Cell R0130cell22 = row.createCell(22);
					if (record.getR0130_before_nonresident_gre() != null) {
						R0130cell22.setCellValue(record.getR0130_before_nonresident_gre().doubleValue());
						R0130cell22.setCellStyle(numberStyle);
					} else {
						R0130cell22.setCellValue("");
						R0130cell22.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column X
					Cell R0130cell23 = row.createCell(23);
					if (record.getR0130_after_nonresident_gre() != null) {
						R0130cell23.setCellValue(record.getR0130_after_nonresident_gre().doubleValue());
						R0130cell23.setCellStyle(numberStyle);
					} else {
						R0130cell23.setCellValue("");
						R0130cell23.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column Y
					Cell R0130cell24 = row.createCell(24);
					if (record.getR0130_before_resident_corporate() != null) {
						R0130cell24.setCellValue(record.getR0130_before_resident_corporate().doubleValue());
						R0130cell24.setCellStyle(numberStyle);
					} else {
						R0130cell24.setCellValue("");
						R0130cell24.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column Z
					Cell R0130cell25 = row.createCell(25);
					if (record.getR0130_after_resident_corporate() != null) {
						R0130cell25.setCellValue(record.getR0130_after_resident_corporate().doubleValue());
						R0130cell25.setCellStyle(numberStyle);
					} else {
						R0130cell25.setCellValue("");
						R0130cell25.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AA
					Cell R0130cell26 = row.createCell(26);
					if (record.getR0130_before_nonresident_corporate() != null) {
						R0130cell26.setCellValue(record.getR0130_before_nonresident_corporate().doubleValue());
						R0130cell26.setCellStyle(numberStyle);
					} else {
						R0130cell26.setCellValue("");
						R0130cell26.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AB
					Cell R0130cell27 = row.createCell(27);
					if (record.getR0130_after_nonresident_corporate() != null) {
						R0130cell27.setCellValue(record.getR0130_after_nonresident_corporate().doubleValue());
						R0130cell27.setCellStyle(numberStyle);
					} else {
						R0130cell27.setCellValue("");
						R0130cell27.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AC
					Cell R0130cell28 = row.createCell(28);
					if (record.getR0130_before_resident_nbfi() != null) {
						R0130cell28.setCellValue(record.getR0130_before_resident_nbfi().doubleValue());
						R0130cell28.setCellStyle(numberStyle);
					} else {
						R0130cell28.setCellValue("");
						R0130cell28.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AD
					Cell R0130cell29 = row.createCell(29);
					if (record.getR0130_after_resident_nbfi() != null) {
						R0130cell29.setCellValue(record.getR0130_after_resident_nbfi().doubleValue());
						R0130cell29.setCellStyle(numberStyle);
					} else {
						R0130cell29.setCellValue("");
						R0130cell29.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AE
					Cell R0130cell30 = row.createCell(30);
					if (record.getR0130_before_nonresident_nbfi() != null) {
						R0130cell30.setCellValue(record.getR0130_before_nonresident_nbfi().doubleValue());
						R0130cell30.setCellStyle(numberStyle);
					} else {
						R0130cell30.setCellValue("");
						R0130cell30.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AF
					Cell R0130cell31 = row.createCell(31);
					if (record.getR0130_after_nonresident_nbfi() != null) {
						R0130cell31.setCellValue(record.getR0130_after_nonresident_nbfi().doubleValue());
						R0130cell31.setCellStyle(numberStyle);
					} else {
						R0130cell31.setCellValue("");
						R0130cell31.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AG
					Cell R0130cell32 = row.createCell(32);
					if (record.getR0130_before_resident_bank() != null) {
						R0130cell32.setCellValue(record.getR0130_before_resident_bank().doubleValue());
						R0130cell32.setCellStyle(numberStyle);
					} else {
						R0130cell32.setCellValue("");
						R0130cell32.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AH
					Cell R0130cell33 = row.createCell(33);
					if (record.getR0130_after_resident_bank() != null) {
						R0130cell33.setCellValue(record.getR0130_after_resident_bank().doubleValue());
						R0130cell33.setCellStyle(numberStyle);
					} else {
						R0130cell33.setCellValue("");
						R0130cell33.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AI
					Cell R0130cell34 = row.createCell(34);
					if (record.getR0130_before_nonresident_bank() != null) {
						R0130cell34.setCellValue(record.getR0130_before_nonresident_bank().doubleValue());
						R0130cell34.setCellStyle(numberStyle);
					} else {
						R0130cell34.setCellValue("");
						R0130cell34.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AJ
					Cell R0130cell35 = row.createCell(35);
					if (record.getR0130_after_nonresident_bank() != null) {
						R0130cell35.setCellValue(record.getR0130_after_nonresident_bank().doubleValue());
						R0130cell35.setCellStyle(numberStyle);
					} else {
						R0130cell35.setCellValue("");
						R0130cell35.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AK
					Cell R0130cell36 = row.createCell(36);
					if (record.getR0130_before_resident_government() != null) {
						R0130cell36.setCellValue(record.getR0130_before_resident_government().doubleValue());
						R0130cell36.setCellStyle(numberStyle);
					} else {
						R0130cell36.setCellValue("");
						R0130cell36.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AL
					Cell R0130cell37 = row.createCell(37);
					if (record.getR0130_after_resident_government() != null) {
						R0130cell37.setCellValue(record.getR0130_after_resident_government().doubleValue());
						R0130cell37.setCellStyle(numberStyle);
					} else {
						R0130cell37.setCellValue("");
						R0130cell37.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AM
					Cell R0130cell38 = row.createCell(38);
					if (record.getR0130_before_nonresident_government() != null) {
						R0130cell38.setCellValue(record.getR0130_before_nonresident_government().doubleValue());
						R0130cell38.setCellStyle(numberStyle);
					} else {
						R0130cell38.setCellValue("");
						R0130cell38.setCellStyle(textStyle);
					}

					/// ROW23
					//// Column AN
					Cell R0130cell39 = row.createCell(39);
					if (record.getR0130_after_nonresident_government() != null) {
						R0130cell39.setCellValue(record.getR0130_after_nonresident_government().doubleValue());
						R0130cell39.setCellStyle(numberStyle);
					} else {
						R0130cell39.setCellValue("");
						R0130cell39.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column E
					row = sheet.getRow(23);
					Cell R0140cell4 = row.createCell(4);
					if (record.getR0140_before_resident_individual() != null) {
						R0140cell4.setCellValue(record.getR0140_before_resident_individual().doubleValue());
						R0140cell4.setCellStyle(numberStyle);
					} else {
						R0140cell4.setCellValue("");
						R0140cell4.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column F
					Cell R0140cell5 = row.createCell(5);
					if (record.getR0140_after_resident_individual() != null) {
						R0140cell5.setCellValue(record.getR0140_after_resident_individual().doubleValue());
						R0140cell5.setCellStyle(numberStyle);
					} else {
						R0140cell5.setCellValue("");
						R0140cell5.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column G
					Cell R0140cell6 = row.createCell(6);
					if (record.getR0140_before_nonresident_individual() != null) {
						R0140cell6.setCellValue(record.getR0140_before_nonresident_individual().doubleValue());
						R0140cell6.setCellStyle(numberStyle);
					} else {
						R0140cell6.setCellValue("");
						R0140cell6.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column H
					Cell R0140cell7 = row.createCell(7);
					if (record.getR0140_after_nonresident_individual() != null) {
						R0140cell7.setCellValue(record.getR0140_after_nonresident_individual().doubleValue());
						R0140cell7.setCellStyle(numberStyle);
					} else {
						R0140cell7.setCellValue("");
						R0140cell7.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column I
					Cell R0140cell8 = row.createCell(8);
					if (record.getR0140_before_resident_retail() != null) {
						R0140cell8.setCellValue(record.getR0140_before_resident_retail().doubleValue());
						R0140cell8.setCellStyle(numberStyle);
					} else {
						R0140cell8.setCellValue("");
						R0140cell8.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column J
					Cell R0140cell9 = row.createCell(9);
					if (record.getR0140_after_resident_retail() != null) {
						R0140cell9.setCellValue(record.getR0140_after_resident_retail().doubleValue());
						R0140cell9.setCellStyle(numberStyle);
					} else {
						R0140cell9.setCellValue("");
						R0140cell9.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column K
					Cell R0140cell10 = row.createCell(10);
					if (record.getR0140_before_nonresident_retail() != null) {
						R0140cell10.setCellValue(record.getR0140_before_nonresident_retail().doubleValue());
						R0140cell10.setCellStyle(numberStyle);
					} else {
						R0140cell10.setCellValue("");
						R0140cell10.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column L
					Cell R0140cell11 = row.createCell(11);
					if (record.getR0140_after_nonresident_retail() != null) {
						R0140cell11.setCellValue(record.getR0140_after_nonresident_retail().doubleValue());
						R0140cell11.setCellStyle(numberStyle);
					} else {
						R0140cell11.setCellValue("");
						R0140cell11.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column M
					Cell R0140cell12 = row.createCell(12);
					if (record.getR0140_before_resident_sme() != null) {
						R0140cell12.setCellValue(record.getR0140_before_resident_sme().doubleValue());
						R0140cell12.setCellStyle(numberStyle);
					} else {
						R0140cell12.setCellValue("");
						R0140cell12.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column N
					Cell R0140cell13 = row.createCell(13);
					if (record.getR0140_after_resident_sme() != null) {
						R0140cell13.setCellValue(record.getR0140_after_resident_sme().doubleValue());
						R0140cell13.setCellStyle(numberStyle);
					} else {
						R0140cell13.setCellValue("");
						R0140cell13.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column O
					Cell R0140cell14 = row.createCell(14);
					if (record.getR0140_before_nonresident_sme() != null) {
						R0140cell14.setCellValue(record.getR0140_before_nonresident_sme().doubleValue());
						R0140cell14.setCellStyle(numberStyle);
					} else {
						R0140cell14.setCellValue("");
						R0140cell14.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column P
					Cell R0140cell15 = row.createCell(15);
					if (record.getR0140_after_nonresident_sme() != null) {
						R0140cell15.setCellValue(record.getR0140_after_nonresident_sme().doubleValue());
						R0140cell15.setCellStyle(numberStyle);
					} else {
						R0140cell15.setCellValue("");
						R0140cell15.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column Q
					Cell R0140cell16 = row.createCell(16);
					if (record.getR0140_before_resident_hni() != null) {
						R0140cell16.setCellValue(record.getR0140_before_resident_hni().doubleValue());
						R0140cell16.setCellStyle(numberStyle);
					} else {
						R0140cell16.setCellValue("");
						R0140cell16.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column R
					Cell R0140cell17 = row.createCell(17);
					if (record.getR0140_after_resident_hni() != null) {
						R0140cell17.setCellValue(record.getR0140_after_resident_hni().doubleValue());
						R0140cell17.setCellStyle(numberStyle);
					} else {
						R0140cell17.setCellValue("");
						R0140cell17.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column S
					Cell R0140cell18 = row.createCell(18);
					if (record.getR0140_before_nonresident_hni() != null) {
						R0140cell18.setCellValue(record.getR0140_before_nonresident_hni().doubleValue());
						R0140cell18.setCellStyle(numberStyle);
					} else {
						R0140cell18.setCellValue("");
						R0140cell18.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column T
					Cell R0140cell19 = row.createCell(19);
					if (record.getR0140_after_nonresident_hni() != null) {
						R0140cell19.setCellValue(record.getR0140_after_nonresident_hni().doubleValue());
						R0140cell19.setCellStyle(numberStyle);
					} else {
						R0140cell19.setCellValue("");
						R0140cell19.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column U
					Cell R0140cell20 = row.createCell(20);
					if (record.getR0140_before_resident_gre() != null) {
						R0140cell20.setCellValue(record.getR0140_before_resident_gre().doubleValue());
						R0140cell20.setCellStyle(numberStyle);
					} else {
						R0140cell20.setCellValue("");
						R0140cell20.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column V
					Cell R0140cell21 = row.createCell(21);
					if (record.getR0140_after_resident_gre() != null) {
						R0140cell21.setCellValue(record.getR0140_after_resident_gre().doubleValue());
						R0140cell21.setCellStyle(numberStyle);
					} else {
						R0140cell21.setCellValue("");
						R0140cell21.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column W
					Cell R0140cell22 = row.createCell(22);
					if (record.getR0140_before_nonresident_gre() != null) {
						R0140cell22.setCellValue(record.getR0140_before_nonresident_gre().doubleValue());
						R0140cell22.setCellStyle(numberStyle);
					} else {
						R0140cell22.setCellValue("");
						R0140cell22.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column X
					Cell R0140cell23 = row.createCell(23);
					if (record.getR0140_after_nonresident_gre() != null) {
						R0140cell23.setCellValue(record.getR0140_after_nonresident_gre().doubleValue());
						R0140cell23.setCellStyle(numberStyle);
					} else {
						R0140cell23.setCellValue("");
						R0140cell23.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column Y
					Cell R0140cell24 = row.createCell(24);
					if (record.getR0140_before_resident_corporate() != null) {
						R0140cell24.setCellValue(record.getR0140_before_resident_corporate().doubleValue());
						R0140cell24.setCellStyle(numberStyle);
					} else {
						R0140cell24.setCellValue("");
						R0140cell24.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column Z
					Cell R0140cell25 = row.createCell(25);
					if (record.getR0140_after_resident_corporate() != null) {
						R0140cell25.setCellValue(record.getR0140_after_resident_corporate().doubleValue());
						R0140cell25.setCellStyle(numberStyle);
					} else {
						R0140cell25.setCellValue("");
						R0140cell25.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AA
					Cell R0140cell26 = row.createCell(26);
					if (record.getR0140_before_nonresident_corporate() != null) {
						R0140cell26.setCellValue(record.getR0140_before_nonresident_corporate().doubleValue());
						R0140cell26.setCellStyle(numberStyle);
					} else {
						R0140cell26.setCellValue("");
						R0140cell26.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AB
					Cell R0140cell27 = row.createCell(27);
					if (record.getR0140_after_nonresident_corporate() != null) {
						R0140cell27.setCellValue(record.getR0140_after_nonresident_corporate().doubleValue());
						R0140cell27.setCellStyle(numberStyle);
					} else {
						R0140cell27.setCellValue("");
						R0140cell27.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AC
					Cell R0140cell28 = row.createCell(28);
					if (record.getR0140_before_resident_nbfi() != null) {
						R0140cell28.setCellValue(record.getR0140_before_resident_nbfi().doubleValue());
						R0140cell28.setCellStyle(numberStyle);
					} else {
						R0140cell28.setCellValue("");
						R0140cell28.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AD
					Cell R0140cell29 = row.createCell(29);
					if (record.getR0140_after_resident_nbfi() != null) {
						R0140cell29.setCellValue(record.getR0140_after_resident_nbfi().doubleValue());
						R0140cell29.setCellStyle(numberStyle);
					} else {
						R0140cell29.setCellValue("");
						R0140cell29.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AE
					Cell R0140cell30 = row.createCell(30);
					if (record.getR0140_before_nonresident_nbfi() != null) {
						R0140cell30.setCellValue(record.getR0140_before_nonresident_nbfi().doubleValue());
						R0140cell30.setCellStyle(numberStyle);
					} else {
						R0140cell30.setCellValue("");
						R0140cell30.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AF
					Cell R0140cell31 = row.createCell(31);
					if (record.getR0140_after_nonresident_nbfi() != null) {
						R0140cell31.setCellValue(record.getR0140_after_nonresident_nbfi().doubleValue());
						R0140cell31.setCellStyle(numberStyle);
					} else {
						R0140cell31.setCellValue("");
						R0140cell31.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AG
					Cell R0140cell32 = row.createCell(32);
					if (record.getR0140_before_resident_bank() != null) {
						R0140cell32.setCellValue(record.getR0140_before_resident_bank().doubleValue());
						R0140cell32.setCellStyle(numberStyle);
					} else {
						R0140cell32.setCellValue("");
						R0140cell32.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AH
					Cell R0140cell33 = row.createCell(33);
					if (record.getR0140_after_resident_bank() != null) {
						R0140cell33.setCellValue(record.getR0140_after_resident_bank().doubleValue());
						R0140cell33.setCellStyle(numberStyle);
					} else {
						R0140cell33.setCellValue("");
						R0140cell33.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AI
					Cell R0140cell34 = row.createCell(34);
					if (record.getR0140_before_nonresident_bank() != null) {
						R0140cell34.setCellValue(record.getR0140_before_nonresident_bank().doubleValue());
						R0140cell34.setCellStyle(numberStyle);
					} else {
						R0140cell34.setCellValue("");
						R0140cell34.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AJ
					Cell R0140cell35 = row.createCell(35);
					if (record.getR0140_after_nonresident_bank() != null) {
						R0140cell35.setCellValue(record.getR0140_after_nonresident_bank().doubleValue());
						R0140cell35.setCellStyle(numberStyle);
					} else {
						R0140cell35.setCellValue("");
						R0140cell35.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AK
					Cell R0140cell36 = row.createCell(36);
					if (record.getR0140_before_resident_government() != null) {
						R0140cell36.setCellValue(record.getR0140_before_resident_government().doubleValue());
						R0140cell36.setCellStyle(numberStyle);
					} else {
						R0140cell36.setCellValue("");
						R0140cell36.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AL
					Cell R0140cell37 = row.createCell(37);
					if (record.getR0140_after_resident_government() != null) {
						R0140cell37.setCellValue(record.getR0140_after_resident_government().doubleValue());
						R0140cell37.setCellStyle(numberStyle);
					} else {
						R0140cell37.setCellValue("");
						R0140cell37.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AM
					Cell R0140cell38 = row.createCell(38);
					if (record.getR0140_before_nonresident_government() != null) {
						R0140cell38.setCellValue(record.getR0140_before_nonresident_government().doubleValue());
						R0140cell38.setCellStyle(numberStyle);
					} else {
						R0140cell38.setCellValue("");
						R0140cell38.setCellStyle(textStyle);
					}

					/// ROW24
					//// Column AN
					Cell R0140cell39 = row.createCell(39);
					if (record.getR0140_after_nonresident_government() != null) {
						R0140cell39.setCellValue(record.getR0140_after_nonresident_government().doubleValue());
						R0140cell39.setCellStyle(numberStyle);
					} else {
						R0140cell39.setCellValue("");
						R0140cell39.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column E
					row = sheet.getRow(24);
					Cell R0150cell4 = row.createCell(4);
					if (record.getR0150_before_resident_individual() != null) {
						R0150cell4.setCellValue(record.getR0150_before_resident_individual().doubleValue());
						R0150cell4.setCellStyle(numberStyle);
					} else {
						R0150cell4.setCellValue("");
						R0150cell4.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column F
					Cell R0150cell5 = row.createCell(5);
					if (record.getR0150_after_resident_individual() != null) {
						R0150cell5.setCellValue(record.getR0150_after_resident_individual().doubleValue());
						R0150cell5.setCellStyle(numberStyle);
					} else {
						R0150cell5.setCellValue("");
						R0150cell5.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column G
					Cell R0150cell6 = row.createCell(6);
					if (record.getR0150_before_nonresident_individual() != null) {
						R0150cell6.setCellValue(record.getR0150_before_nonresident_individual().doubleValue());
						R0150cell6.setCellStyle(numberStyle);
					} else {
						R0150cell6.setCellValue("");
						R0150cell6.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column H
					Cell R0150cell7 = row.createCell(7);
					if (record.getR0150_after_nonresident_individual() != null) {
						R0150cell7.setCellValue(record.getR0150_after_nonresident_individual().doubleValue());
						R0150cell7.setCellStyle(numberStyle);
					} else {
						R0150cell7.setCellValue("");
						R0150cell7.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column I
					Cell R0150cell8 = row.createCell(8);
					if (record.getR0150_before_resident_retail() != null) {
						R0150cell8.setCellValue(record.getR0150_before_resident_retail().doubleValue());
						R0150cell8.setCellStyle(numberStyle);
					} else {
						R0150cell8.setCellValue("");
						R0150cell8.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column J
					Cell R0150cell9 = row.createCell(9);
					if (record.getR0150_after_resident_retail() != null) {
						R0150cell9.setCellValue(record.getR0150_after_resident_retail().doubleValue());
						R0150cell9.setCellStyle(numberStyle);
					} else {
						R0150cell9.setCellValue("");
						R0150cell9.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column K
					Cell R0150cell10 = row.createCell(10);
					if (record.getR0150_before_nonresident_retail() != null) {
						R0150cell10.setCellValue(record.getR0150_before_nonresident_retail().doubleValue());
						R0150cell10.setCellStyle(numberStyle);
					} else {
						R0150cell10.setCellValue("");
						R0150cell10.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column L
					Cell R0150cell11 = row.createCell(11);
					if (record.getR0150_after_nonresident_retail() != null) {
						R0150cell11.setCellValue(record.getR0150_after_nonresident_retail().doubleValue());
						R0150cell11.setCellStyle(numberStyle);
					} else {
						R0150cell11.setCellValue("");
						R0150cell11.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column M
					Cell R0150cell12 = row.createCell(12);
					if (record.getR0150_before_resident_sme() != null) {
						R0150cell12.setCellValue(record.getR0150_before_resident_sme().doubleValue());
						R0150cell12.setCellStyle(numberStyle);
					} else {
						R0150cell12.setCellValue("");
						R0150cell12.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column N
					Cell R0150cell13 = row.createCell(13);
					if (record.getR0150_after_resident_sme() != null) {
						R0150cell13.setCellValue(record.getR0150_after_resident_sme().doubleValue());
						R0150cell13.setCellStyle(numberStyle);
					} else {
						R0150cell13.setCellValue("");
						R0150cell13.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column O
					Cell R0150cell14 = row.createCell(14);
					if (record.getR0150_before_nonresident_sme() != null) {
						R0150cell14.setCellValue(record.getR0150_before_nonresident_sme().doubleValue());
						R0150cell14.setCellStyle(numberStyle);
					} else {
						R0150cell14.setCellValue("");
						R0150cell14.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column P
					Cell R0150cell15 = row.createCell(15);
					if (record.getR0150_after_nonresident_sme() != null) {
						R0150cell15.setCellValue(record.getR0150_after_nonresident_sme().doubleValue());
						R0150cell15.setCellStyle(numberStyle);
					} else {
						R0150cell15.setCellValue("");
						R0150cell15.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column Q
					Cell R0150cell16 = row.createCell(16);
					if (record.getR0150_before_resident_hni() != null) {
						R0150cell16.setCellValue(record.getR0150_before_resident_hni().doubleValue());
						R0150cell16.setCellStyle(numberStyle);
					} else {
						R0150cell16.setCellValue("");
						R0150cell16.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column R
					Cell R0150cell17 = row.createCell(17);
					if (record.getR0150_after_resident_hni() != null) {
						R0150cell17.setCellValue(record.getR0150_after_resident_hni().doubleValue());
						R0150cell17.setCellStyle(numberStyle);
					} else {
						R0150cell17.setCellValue("");
						R0150cell17.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column S
					Cell R0150cell18 = row.createCell(18);
					if (record.getR0150_before_nonresident_hni() != null) {
						R0150cell18.setCellValue(record.getR0150_before_nonresident_hni().doubleValue());
						R0150cell18.setCellStyle(numberStyle);
					} else {
						R0150cell18.setCellValue("");
						R0150cell18.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column T
					Cell R0150cell19 = row.createCell(19);
					if (record.getR0150_after_nonresident_hni() != null) {
						R0150cell19.setCellValue(record.getR0150_after_nonresident_hni().doubleValue());
						R0150cell19.setCellStyle(numberStyle);
					} else {
						R0150cell19.setCellValue("");
						R0150cell19.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column U
					Cell R0150cell20 = row.createCell(20);
					if (record.getR0150_before_resident_gre() != null) {
						R0150cell20.setCellValue(record.getR0150_before_resident_gre().doubleValue());
						R0150cell20.setCellStyle(numberStyle);
					} else {
						R0150cell20.setCellValue("");
						R0150cell20.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column V
					Cell R0150cell21 = row.createCell(21);
					if (record.getR0150_after_resident_gre() != null) {
						R0150cell21.setCellValue(record.getR0150_after_resident_gre().doubleValue());
						R0150cell21.setCellStyle(numberStyle);
					} else {
						R0150cell21.setCellValue("");
						R0150cell21.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column W
					Cell R0150cell22 = row.createCell(22);
					if (record.getR0150_before_nonresident_gre() != null) {
						R0150cell22.setCellValue(record.getR0150_before_nonresident_gre().doubleValue());
						R0150cell22.setCellStyle(numberStyle);
					} else {
						R0150cell22.setCellValue("");
						R0150cell22.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column X
					Cell R0150cell23 = row.createCell(23);
					if (record.getR0150_after_nonresident_gre() != null) {
						R0150cell23.setCellValue(record.getR0150_after_nonresident_gre().doubleValue());
						R0150cell23.setCellStyle(numberStyle);
					} else {
						R0150cell23.setCellValue("");
						R0150cell23.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column Y
					Cell R0150cell24 = row.createCell(24);
					if (record.getR0150_before_resident_corporate() != null) {
						R0150cell24.setCellValue(record.getR0150_before_resident_corporate().doubleValue());
						R0150cell24.setCellStyle(numberStyle);
					} else {
						R0150cell24.setCellValue("");
						R0150cell24.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column Z
					Cell R0150cell25 = row.createCell(25);
					if (record.getR0150_after_resident_corporate() != null) {
						R0150cell25.setCellValue(record.getR0150_after_resident_corporate().doubleValue());
						R0150cell25.setCellStyle(numberStyle);
					} else {
						R0150cell25.setCellValue("");
						R0150cell25.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AA
					Cell R0150cell26 = row.createCell(26);
					if (record.getR0150_before_nonresident_corporate() != null) {
						R0150cell26.setCellValue(record.getR0150_before_nonresident_corporate().doubleValue());
						R0150cell26.setCellStyle(numberStyle);
					} else {
						R0150cell26.setCellValue("");
						R0150cell26.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AB
					Cell R0150cell27 = row.createCell(27);
					if (record.getR0150_after_nonresident_corporate() != null) {
						R0150cell27.setCellValue(record.getR0150_after_nonresident_corporate().doubleValue());
						R0150cell27.setCellStyle(numberStyle);
					} else {
						R0150cell27.setCellValue("");
						R0150cell27.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AC
					Cell R0150cell28 = row.createCell(28);
					if (record.getR0150_before_resident_nbfi() != null) {
						R0150cell28.setCellValue(record.getR0150_before_resident_nbfi().doubleValue());
						R0150cell28.setCellStyle(numberStyle);
					} else {
						R0150cell28.setCellValue("");
						R0150cell28.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AD
					Cell R0150cell29 = row.createCell(29);
					if (record.getR0150_after_resident_nbfi() != null) {
						R0150cell29.setCellValue(record.getR0150_after_resident_nbfi().doubleValue());
						R0150cell29.setCellStyle(numberStyle);
					} else {
						R0150cell29.setCellValue("");
						R0150cell29.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AE
					Cell R0150cell30 = row.createCell(30);
					if (record.getR0150_before_nonresident_nbfi() != null) {
						R0150cell30.setCellValue(record.getR0150_before_nonresident_nbfi().doubleValue());
						R0150cell30.setCellStyle(numberStyle);
					} else {
						R0150cell30.setCellValue("");
						R0150cell30.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AF
					Cell R0150cell31 = row.createCell(31);
					if (record.getR0150_after_nonresident_nbfi() != null) {
						R0150cell31.setCellValue(record.getR0150_after_nonresident_nbfi().doubleValue());
						R0150cell31.setCellStyle(numberStyle);
					} else {
						R0150cell31.setCellValue("");
						R0150cell31.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AG
					Cell R0150cell32 = row.createCell(32);
					if (record.getR0150_before_resident_bank() != null) {
						R0150cell32.setCellValue(record.getR0150_before_resident_bank().doubleValue());
						R0150cell32.setCellStyle(numberStyle);
					} else {
						R0150cell32.setCellValue("");
						R0150cell32.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AH
					Cell R0150cell33 = row.createCell(33);
					if (record.getR0150_after_resident_bank() != null) {
						R0150cell33.setCellValue(record.getR0150_after_resident_bank().doubleValue());
						R0150cell33.setCellStyle(numberStyle);
					} else {
						R0150cell33.setCellValue("");
						R0150cell33.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AI
					Cell R0150cell34 = row.createCell(34);
					if (record.getR0150_before_nonresident_bank() != null) {
						R0150cell34.setCellValue(record.getR0150_before_nonresident_bank().doubleValue());
						R0150cell34.setCellStyle(numberStyle);
					} else {
						R0150cell34.setCellValue("");
						R0150cell34.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AJ
					Cell R0150cell35 = row.createCell(35);
					if (record.getR0150_after_nonresident_bank() != null) {
						R0150cell35.setCellValue(record.getR0150_after_nonresident_bank().doubleValue());
						R0150cell35.setCellStyle(numberStyle);
					} else {
						R0150cell35.setCellValue("");
						R0150cell35.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AK
					Cell R0150cell36 = row.createCell(36);
					if (record.getR0150_before_resident_government() != null) {
						R0150cell36.setCellValue(record.getR0150_before_resident_government().doubleValue());
						R0150cell36.setCellStyle(numberStyle);
					} else {
						R0150cell36.setCellValue("");
						R0150cell36.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AL
					Cell R0150cell37 = row.createCell(37);
					if (record.getR0150_after_resident_government() != null) {
						R0150cell37.setCellValue(record.getR0150_after_resident_government().doubleValue());
						R0150cell37.setCellStyle(numberStyle);
					} else {
						R0150cell37.setCellValue("");
						R0150cell37.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AM
					Cell R0150cell38 = row.createCell(38);
					if (record.getR0150_before_nonresident_government() != null) {
						R0150cell38.setCellValue(record.getR0150_before_nonresident_government().doubleValue());
						R0150cell38.setCellStyle(numberStyle);
					} else {
						R0150cell38.setCellValue("");
						R0150cell38.setCellStyle(textStyle);
					}

					/// ROW25
					//// Column AN
					Cell R0150cell39 = row.createCell(39);
					if (record.getR0150_after_nonresident_government() != null) {
						R0150cell39.setCellValue(record.getR0150_after_nonresident_government().doubleValue());
						R0150cell39.setCellStyle(numberStyle);
					} else {
						R0150cell39.setCellValue("");
						R0150cell39.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column E
					row = sheet.getRow(25);
					Cell R0160cell4 = row.createCell(4);
					if (record.getR0160_before_resident_individual() != null) {
						R0160cell4.setCellValue(record.getR0160_before_resident_individual().doubleValue());
						R0160cell4.setCellStyle(numberStyle);
					} else {
						R0160cell4.setCellValue("");
						R0160cell4.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column F
					Cell R0160cell5 = row.createCell(5);
					if (record.getR0160_after_resident_individual() != null) {
						R0160cell5.setCellValue(record.getR0160_after_resident_individual().doubleValue());
						R0160cell5.setCellStyle(numberStyle);
					} else {
						R0160cell5.setCellValue("");
						R0160cell5.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column G
					Cell R0160cell6 = row.createCell(6);
					if (record.getR0160_before_nonresident_individual() != null) {
						R0160cell6.setCellValue(record.getR0160_before_nonresident_individual().doubleValue());
						R0160cell6.setCellStyle(numberStyle);
					} else {
						R0160cell6.setCellValue("");
						R0160cell6.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column H
					Cell R0160cell7 = row.createCell(7);
					if (record.getR0160_after_nonresident_individual() != null) {
						R0160cell7.setCellValue(record.getR0160_after_nonresident_individual().doubleValue());
						R0160cell7.setCellStyle(numberStyle);
					} else {
						R0160cell7.setCellValue("");
						R0160cell7.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column I
					Cell R0160cell8 = row.createCell(8);
					if (record.getR0160_before_resident_retail() != null) {
						R0160cell8.setCellValue(record.getR0160_before_resident_retail().doubleValue());
						R0160cell8.setCellStyle(numberStyle);
					} else {
						R0160cell8.setCellValue("");
						R0160cell8.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column J
					Cell R0160cell9 = row.createCell(9);
					if (record.getR0160_after_resident_retail() != null) {
						R0160cell9.setCellValue(record.getR0160_after_resident_retail().doubleValue());
						R0160cell9.setCellStyle(numberStyle);
					} else {
						R0160cell9.setCellValue("");
						R0160cell9.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column K
					Cell R0160cell10 = row.createCell(10);
					if (record.getR0160_before_nonresident_retail() != null) {
						R0160cell10.setCellValue(record.getR0160_before_nonresident_retail().doubleValue());
						R0160cell10.setCellStyle(numberStyle);
					} else {
						R0160cell10.setCellValue("");
						R0160cell10.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column L
					Cell R0160cell11 = row.createCell(11);
					if (record.getR0160_after_nonresident_retail() != null) {
						R0160cell11.setCellValue(record.getR0160_after_nonresident_retail().doubleValue());
						R0160cell11.setCellStyle(numberStyle);
					} else {
						R0160cell11.setCellValue("");
						R0160cell11.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column M
					Cell R0160cell12 = row.createCell(12);
					if (record.getR0160_before_resident_sme() != null) {
						R0160cell12.setCellValue(record.getR0160_before_resident_sme().doubleValue());
						R0160cell12.setCellStyle(numberStyle);
					} else {
						R0160cell12.setCellValue("");
						R0160cell12.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column N
					Cell R0160cell13 = row.createCell(13);
					if (record.getR0160_after_resident_sme() != null) {
						R0160cell13.setCellValue(record.getR0160_after_resident_sme().doubleValue());
						R0160cell13.setCellStyle(numberStyle);
					} else {
						R0160cell13.setCellValue("");
						R0160cell13.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column O
					Cell R0160cell14 = row.createCell(14);
					if (record.getR0160_before_nonresident_sme() != null) {
						R0160cell14.setCellValue(record.getR0160_before_nonresident_sme().doubleValue());
						R0160cell14.setCellStyle(numberStyle);
					} else {
						R0160cell14.setCellValue("");
						R0160cell14.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column P
					Cell R0160cell15 = row.createCell(15);
					if (record.getR0160_after_nonresident_sme() != null) {
						R0160cell15.setCellValue(record.getR0160_after_nonresident_sme().doubleValue());
						R0160cell15.setCellStyle(numberStyle);
					} else {
						R0160cell15.setCellValue("");
						R0160cell15.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column Q
					Cell R0160cell16 = row.createCell(16);
					if (record.getR0160_before_resident_hni() != null) {
						R0160cell16.setCellValue(record.getR0160_before_resident_hni().doubleValue());
						R0160cell16.setCellStyle(numberStyle);
					} else {
						R0160cell16.setCellValue("");
						R0160cell16.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column R
					Cell R0160cell17 = row.createCell(17);
					if (record.getR0160_after_resident_hni() != null) {
						R0160cell17.setCellValue(record.getR0160_after_resident_hni().doubleValue());
						R0160cell17.setCellStyle(numberStyle);
					} else {
						R0160cell17.setCellValue("");
						R0160cell17.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column S
					Cell R0160cell18 = row.createCell(18);
					if (record.getR0160_before_nonresident_hni() != null) {
						R0160cell18.setCellValue(record.getR0160_before_nonresident_hni().doubleValue());
						R0160cell18.setCellStyle(numberStyle);
					} else {
						R0160cell18.setCellValue("");
						R0160cell18.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column T
					Cell R0160cell19 = row.createCell(19);
					if (record.getR0160_after_nonresident_hni() != null) {
						R0160cell19.setCellValue(record.getR0160_after_nonresident_hni().doubleValue());
						R0160cell19.setCellStyle(numberStyle);
					} else {
						R0160cell19.setCellValue("");
						R0160cell19.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column U
					Cell R0160cell20 = row.createCell(20);
					if (record.getR0160_before_resident_gre() != null) {
						R0160cell20.setCellValue(record.getR0160_before_resident_gre().doubleValue());
						R0160cell20.setCellStyle(numberStyle);
					} else {
						R0160cell20.setCellValue("");
						R0160cell20.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column V
					Cell R0160cell21 = row.createCell(21);
					if (record.getR0160_after_resident_gre() != null) {
						R0160cell21.setCellValue(record.getR0160_after_resident_gre().doubleValue());
						R0160cell21.setCellStyle(numberStyle);
					} else {
						R0160cell21.setCellValue("");
						R0160cell21.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column W
					Cell R0160cell22 = row.createCell(22);
					if (record.getR0160_before_nonresident_gre() != null) {
						R0160cell22.setCellValue(record.getR0160_before_nonresident_gre().doubleValue());
						R0160cell22.setCellStyle(numberStyle);
					} else {
						R0160cell22.setCellValue("");
						R0160cell22.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column X
					Cell R0160cell23 = row.createCell(23);
					if (record.getR0160_after_nonresident_gre() != null) {
						R0160cell23.setCellValue(record.getR0160_after_nonresident_gre().doubleValue());
						R0160cell23.setCellStyle(numberStyle);
					} else {
						R0160cell23.setCellValue("");
						R0160cell23.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column Y
					Cell R0160cell24 = row.createCell(24);
					if (record.getR0160_before_resident_corporate() != null) {
						R0160cell24.setCellValue(record.getR0160_before_resident_corporate().doubleValue());
						R0160cell24.setCellStyle(numberStyle);
					} else {
						R0160cell24.setCellValue("");
						R0160cell24.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column Z
					Cell R0160cell25 = row.createCell(25);
					if (record.getR0160_after_resident_corporate() != null) {
						R0160cell25.setCellValue(record.getR0160_after_resident_corporate().doubleValue());
						R0160cell25.setCellStyle(numberStyle);
					} else {
						R0160cell25.setCellValue("");
						R0160cell25.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AA
					Cell R0160cell26 = row.createCell(26);
					if (record.getR0160_before_nonresident_corporate() != null) {
						R0160cell26.setCellValue(record.getR0160_before_nonresident_corporate().doubleValue());
						R0160cell26.setCellStyle(numberStyle);
					} else {
						R0160cell26.setCellValue("");
						R0160cell26.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AB
					Cell R0160cell27 = row.createCell(27);
					if (record.getR0160_after_nonresident_corporate() != null) {
						R0160cell27.setCellValue(record.getR0160_after_nonresident_corporate().doubleValue());
						R0160cell27.setCellStyle(numberStyle);
					} else {
						R0160cell27.setCellValue("");
						R0160cell27.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AC
					Cell R0160cell28 = row.createCell(28);
					if (record.getR0160_before_resident_nbfi() != null) {
						R0160cell28.setCellValue(record.getR0160_before_resident_nbfi().doubleValue());
						R0160cell28.setCellStyle(numberStyle);
					} else {
						R0160cell28.setCellValue("");
						R0160cell28.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AD
					Cell R0160cell29 = row.createCell(29);
					if (record.getR0160_after_resident_nbfi() != null) {
						R0160cell29.setCellValue(record.getR0160_after_resident_nbfi().doubleValue());
						R0160cell29.setCellStyle(numberStyle);
					} else {
						R0160cell29.setCellValue("");
						R0160cell29.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AE
					Cell R0160cell30 = row.createCell(30);
					if (record.getR0160_before_nonresident_nbfi() != null) {
						R0160cell30.setCellValue(record.getR0160_before_nonresident_nbfi().doubleValue());
						R0160cell30.setCellStyle(numberStyle);
					} else {
						R0160cell30.setCellValue("");
						R0160cell30.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AF
					Cell R0160cell31 = row.createCell(31);
					if (record.getR0160_after_nonresident_nbfi() != null) {
						R0160cell31.setCellValue(record.getR0160_after_nonresident_nbfi().doubleValue());
						R0160cell31.setCellStyle(numberStyle);
					} else {
						R0160cell31.setCellValue("");
						R0160cell31.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AG
					Cell R0160cell32 = row.createCell(32);
					if (record.getR0160_before_resident_bank() != null) {
						R0160cell32.setCellValue(record.getR0160_before_resident_bank().doubleValue());
						R0160cell32.setCellStyle(numberStyle);
					} else {
						R0160cell32.setCellValue("");
						R0160cell32.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AH
					Cell R0160cell33 = row.createCell(33);
					if (record.getR0160_after_resident_bank() != null) {
						R0160cell33.setCellValue(record.getR0160_after_resident_bank().doubleValue());
						R0160cell33.setCellStyle(numberStyle);
					} else {
						R0160cell33.setCellValue("");
						R0160cell33.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AI
					Cell R0160cell34 = row.createCell(34);
					if (record.getR0160_before_nonresident_bank() != null) {
						R0160cell34.setCellValue(record.getR0160_before_nonresident_bank().doubleValue());
						R0160cell34.setCellStyle(numberStyle);
					} else {
						R0160cell34.setCellValue("");
						R0160cell34.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AJ
					Cell R0160cell35 = row.createCell(35);
					if (record.getR0160_after_nonresident_bank() != null) {
						R0160cell35.setCellValue(record.getR0160_after_nonresident_bank().doubleValue());
						R0160cell35.setCellStyle(numberStyle);
					} else {
						R0160cell35.setCellValue("");
						R0160cell35.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AK
					Cell R0160cell36 = row.createCell(36);
					if (record.getR0160_before_resident_government() != null) {
						R0160cell36.setCellValue(record.getR0160_before_resident_government().doubleValue());
						R0160cell36.setCellStyle(numberStyle);
					} else {
						R0160cell36.setCellValue("");
						R0160cell36.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AL
					Cell R0160cell37 = row.createCell(37);
					if (record.getR0160_after_resident_government() != null) {
						R0160cell37.setCellValue(record.getR0160_after_resident_government().doubleValue());
						R0160cell37.setCellStyle(numberStyle);
					} else {
						R0160cell37.setCellValue("");
						R0160cell37.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AM
					Cell R0160cell38 = row.createCell(38);
					if (record.getR0160_before_nonresident_government() != null) {
						R0160cell38.setCellValue(record.getR0160_before_nonresident_government().doubleValue());
						R0160cell38.setCellStyle(numberStyle);
					} else {
						R0160cell38.setCellValue("");
						R0160cell38.setCellStyle(textStyle);
					}

					/// ROW26
					//// Column AN
					Cell R0160cell39 = row.createCell(39);
					if (record.getR0160_after_nonresident_government() != null) {
						R0160cell39.setCellValue(record.getR0160_after_nonresident_government().doubleValue());
						R0160cell39.setCellStyle(numberStyle);
					} else {
						R0160cell39.setCellValue("");
						R0160cell39.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column E
					row = sheet.getRow(27);
					Cell R0180cell4 = row.createCell(4);
					if (record.getR0180_before_resident_individual() != null) {
						R0180cell4.setCellValue(record.getR0180_before_resident_individual().doubleValue());
						R0180cell4.setCellStyle(numberStyle);
					} else {
						R0180cell4.setCellValue("");
						R0180cell4.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column F
					Cell R0180cell5 = row.createCell(5);
					if (record.getR0180_after_resident_individual() != null) {
						R0180cell5.setCellValue(record.getR0180_after_resident_individual().doubleValue());
						R0180cell5.setCellStyle(numberStyle);
					} else {
						R0180cell5.setCellValue("");
						R0180cell5.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column G
					Cell R0180cell6 = row.createCell(6);
					if (record.getR0180_before_nonresident_individual() != null) {
						R0180cell6.setCellValue(record.getR0180_before_nonresident_individual().doubleValue());
						R0180cell6.setCellStyle(numberStyle);
					} else {
						R0180cell6.setCellValue("");
						R0180cell6.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column H
					Cell R0180cell7 = row.createCell(7);
					if (record.getR0180_after_nonresident_individual() != null) {
						R0180cell7.setCellValue(record.getR0180_after_nonresident_individual().doubleValue());
						R0180cell7.setCellStyle(numberStyle);
					} else {
						R0180cell7.setCellValue("");
						R0180cell7.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column I
					Cell R0180cell8 = row.createCell(8);
					if (record.getR0180_before_resident_retail() != null) {
						R0180cell8.setCellValue(record.getR0180_before_resident_retail().doubleValue());
						R0180cell8.setCellStyle(numberStyle);
					} else {
						R0180cell8.setCellValue("");
						R0180cell8.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column J
					Cell R0180cell9 = row.createCell(9);
					if (record.getR0180_after_resident_retail() != null) {
						R0180cell9.setCellValue(record.getR0180_after_resident_retail().doubleValue());
						R0180cell9.setCellStyle(numberStyle);
					} else {
						R0180cell9.setCellValue("");
						R0180cell9.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column K
					Cell R0180cell10 = row.createCell(10);
					if (record.getR0180_before_nonresident_retail() != null) {
						R0180cell10.setCellValue(record.getR0180_before_nonresident_retail().doubleValue());
						R0180cell10.setCellStyle(numberStyle);
					} else {
						R0180cell10.setCellValue("");
						R0180cell10.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column L
					Cell R0180cell11 = row.createCell(11);
					if (record.getR0180_after_nonresident_retail() != null) {
						R0180cell11.setCellValue(record.getR0180_after_nonresident_retail().doubleValue());
						R0180cell11.setCellStyle(numberStyle);
					} else {
						R0180cell11.setCellValue("");
						R0180cell11.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column M
					Cell R0180cell12 = row.createCell(12);
					if (record.getR0180_before_resident_sme() != null) {
						R0180cell12.setCellValue(record.getR0180_before_resident_sme().doubleValue());
						R0180cell12.setCellStyle(numberStyle);
					} else {
						R0180cell12.setCellValue("");
						R0180cell12.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column N
					Cell R0180cell13 = row.createCell(13);
					if (record.getR0180_after_resident_sme() != null) {
						R0180cell13.setCellValue(record.getR0180_after_resident_sme().doubleValue());
						R0180cell13.setCellStyle(numberStyle);
					} else {
						R0180cell13.setCellValue("");
						R0180cell13.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column O
					Cell R0180cell14 = row.createCell(14);
					if (record.getR0180_before_nonresident_sme() != null) {
						R0180cell14.setCellValue(record.getR0180_before_nonresident_sme().doubleValue());
						R0180cell14.setCellStyle(numberStyle);
					} else {
						R0180cell14.setCellValue("");
						R0180cell14.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column P
					Cell R0180cell15 = row.createCell(15);
					if (record.getR0180_after_nonresident_sme() != null) {
						R0180cell15.setCellValue(record.getR0180_after_nonresident_sme().doubleValue());
						R0180cell15.setCellStyle(numberStyle);
					} else {
						R0180cell15.setCellValue("");
						R0180cell15.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column Q
					Cell R0180cell16 = row.createCell(16);
					if (record.getR0180_before_resident_hni() != null) {
						R0180cell16.setCellValue(record.getR0180_before_resident_hni().doubleValue());
						R0180cell16.setCellStyle(numberStyle);
					} else {
						R0180cell16.setCellValue("");
						R0180cell16.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column R
					Cell R0180cell17 = row.createCell(17);
					if (record.getR0180_after_resident_hni() != null) {
						R0180cell17.setCellValue(record.getR0180_after_resident_hni().doubleValue());
						R0180cell17.setCellStyle(numberStyle);
					} else {
						R0180cell17.setCellValue("");
						R0180cell17.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column S
					Cell R0180cell18 = row.createCell(18);
					if (record.getR0180_before_nonresident_hni() != null) {
						R0180cell18.setCellValue(record.getR0180_before_nonresident_hni().doubleValue());
						R0180cell18.setCellStyle(numberStyle);
					} else {
						R0180cell18.setCellValue("");
						R0180cell18.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column T
					Cell R0180cell19 = row.createCell(19);
					if (record.getR0180_after_nonresident_hni() != null) {
						R0180cell19.setCellValue(record.getR0180_after_nonresident_hni().doubleValue());
						R0180cell19.setCellStyle(numberStyle);
					} else {
						R0180cell19.setCellValue("");
						R0180cell19.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column U
					Cell R0180cell20 = row.createCell(20);
					if (record.getR0180_before_resident_gre() != null) {
						R0180cell20.setCellValue(record.getR0180_before_resident_gre().doubleValue());
						R0180cell20.setCellStyle(numberStyle);
					} else {
						R0180cell20.setCellValue("");
						R0180cell20.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column V
					Cell R0180cell21 = row.createCell(21);
					if (record.getR0180_after_resident_gre() != null) {
						R0180cell21.setCellValue(record.getR0180_after_resident_gre().doubleValue());
						R0180cell21.setCellStyle(numberStyle);
					} else {
						R0180cell21.setCellValue("");
						R0180cell21.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column W
					Cell R0180cell22 = row.createCell(22);
					if (record.getR0180_before_nonresident_gre() != null) {
						R0180cell22.setCellValue(record.getR0180_before_nonresident_gre().doubleValue());
						R0180cell22.setCellStyle(numberStyle);
					} else {
						R0180cell22.setCellValue("");
						R0180cell22.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column X
					Cell R0180cell23 = row.createCell(23);
					if (record.getR0180_after_nonresident_gre() != null) {
						R0180cell23.setCellValue(record.getR0180_after_nonresident_gre().doubleValue());
						R0180cell23.setCellStyle(numberStyle);
					} else {
						R0180cell23.setCellValue("");
						R0180cell23.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column Y
					Cell R0180cell24 = row.createCell(24);
					if (record.getR0180_before_resident_corporate() != null) {
						R0180cell24.setCellValue(record.getR0180_before_resident_corporate().doubleValue());
						R0180cell24.setCellStyle(numberStyle);
					} else {
						R0180cell24.setCellValue("");
						R0180cell24.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column Z
					Cell R0180cell25 = row.createCell(25);
					if (record.getR0180_after_resident_corporate() != null) {
						R0180cell25.setCellValue(record.getR0180_after_resident_corporate().doubleValue());
						R0180cell25.setCellStyle(numberStyle);
					} else {
						R0180cell25.setCellValue("");
						R0180cell25.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AA
					Cell R0180cell26 = row.createCell(26);
					if (record.getR0180_before_nonresident_corporate() != null) {
						R0180cell26.setCellValue(record.getR0180_before_nonresident_corporate().doubleValue());
						R0180cell26.setCellStyle(numberStyle);
					} else {
						R0180cell26.setCellValue("");
						R0180cell26.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AB
					Cell R0180cell27 = row.createCell(27);
					if (record.getR0180_after_nonresident_corporate() != null) {
						R0180cell27.setCellValue(record.getR0180_after_nonresident_corporate().doubleValue());
						R0180cell27.setCellStyle(numberStyle);
					} else {
						R0180cell27.setCellValue("");
						R0180cell27.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AC
					Cell R0180cell28 = row.createCell(28);
					if (record.getR0180_before_resident_nbfi() != null) {
						R0180cell28.setCellValue(record.getR0180_before_resident_nbfi().doubleValue());
						R0180cell28.setCellStyle(numberStyle);
					} else {
						R0180cell28.setCellValue("");
						R0180cell28.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AD
					Cell R0180cell29 = row.createCell(29);
					if (record.getR0180_after_resident_nbfi() != null) {
						R0180cell29.setCellValue(record.getR0180_after_resident_nbfi().doubleValue());
						R0180cell29.setCellStyle(numberStyle);
					} else {
						R0180cell29.setCellValue("");
						R0180cell29.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AE
					Cell R0180cell30 = row.createCell(30);
					if (record.getR0180_before_nonresident_nbfi() != null) {
						R0180cell30.setCellValue(record.getR0180_before_nonresident_nbfi().doubleValue());
						R0180cell30.setCellStyle(numberStyle);
					} else {
						R0180cell30.setCellValue("");
						R0180cell30.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AF
					Cell R0180cell31 = row.createCell(31);
					if (record.getR0180_after_nonresident_nbfi() != null) {
						R0180cell31.setCellValue(record.getR0180_after_nonresident_nbfi().doubleValue());
						R0180cell31.setCellStyle(numberStyle);
					} else {
						R0180cell31.setCellValue("");
						R0180cell31.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AG
					Cell R0180cell32 = row.createCell(32);
					if (record.getR0180_before_resident_bank() != null) {
						R0180cell32.setCellValue(record.getR0180_before_resident_bank().doubleValue());
						R0180cell32.setCellStyle(numberStyle);
					} else {
						R0180cell32.setCellValue("");
						R0180cell32.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AH
					Cell R0180cell33 = row.createCell(33);
					if (record.getR0180_after_resident_bank() != null) {
						R0180cell33.setCellValue(record.getR0180_after_resident_bank().doubleValue());
						R0180cell33.setCellStyle(numberStyle);
					} else {
						R0180cell33.setCellValue("");
						R0180cell33.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AI
					Cell R0180cell34 = row.createCell(34);
					if (record.getR0180_before_nonresident_bank() != null) {
						R0180cell34.setCellValue(record.getR0180_before_nonresident_bank().doubleValue());
						R0180cell34.setCellStyle(numberStyle);
					} else {
						R0180cell34.setCellValue("");
						R0180cell34.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AJ
					Cell R0180cell35 = row.createCell(35);
					if (record.getR0180_after_nonresident_bank() != null) {
						R0180cell35.setCellValue(record.getR0180_after_nonresident_bank().doubleValue());
						R0180cell35.setCellStyle(numberStyle);
					} else {
						R0180cell35.setCellValue("");
						R0180cell35.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AK
					Cell R0180cell36 = row.createCell(36);
					if (record.getR0180_before_resident_government() != null) {
						R0180cell36.setCellValue(record.getR0180_before_resident_government().doubleValue());
						R0180cell36.setCellStyle(numberStyle);
					} else {
						R0180cell36.setCellValue("");
						R0180cell36.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AL
					Cell R0180cell37 = row.createCell(37);
					if (record.getR0180_after_resident_government() != null) {
						R0180cell37.setCellValue(record.getR0180_after_resident_government().doubleValue());
						R0180cell37.setCellStyle(numberStyle);
					} else {
						R0180cell37.setCellValue("");
						R0180cell37.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AM
					Cell R0180cell38 = row.createCell(38);
					if (record.getR0180_before_nonresident_government() != null) {
						R0180cell38.setCellValue(record.getR0180_before_nonresident_government().doubleValue());
						R0180cell38.setCellStyle(numberStyle);
					} else {
						R0180cell38.setCellValue("");
						R0180cell38.setCellStyle(textStyle);
					}

					/// ROW28
					//// Column AN
					Cell R0180cell39 = row.createCell(39);
					if (record.getR0180_after_nonresident_government() != null) {
						R0180cell39.setCellValue(record.getR0180_after_nonresident_government().doubleValue());
						R0180cell39.setCellStyle(numberStyle);
					} else {
						R0180cell39.setCellValue("");
						R0180cell39.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column E
					row = sheet.getRow(28);
					Cell R0190cell4 = row.createCell(4);
					if (record.getR0190_before_resident_individual() != null) {
						R0190cell4.setCellValue(record.getR0190_before_resident_individual().doubleValue());
						R0190cell4.setCellStyle(numberStyle);
					} else {
						R0190cell4.setCellValue("");
						R0190cell4.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column F
					Cell R0190cell5 = row.createCell(5);
					if (record.getR0190_after_resident_individual() != null) {
						R0190cell5.setCellValue(record.getR0190_after_resident_individual().doubleValue());
						R0190cell5.setCellStyle(numberStyle);
					} else {
						R0190cell5.setCellValue("");
						R0190cell5.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column G
					Cell R0190cell6 = row.createCell(6);
					if (record.getR0190_before_nonresident_individual() != null) {
						R0190cell6.setCellValue(record.getR0190_before_nonresident_individual().doubleValue());
						R0190cell6.setCellStyle(numberStyle);
					} else {
						R0190cell6.setCellValue("");
						R0190cell6.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column H
					Cell R0190cell7 = row.createCell(7);
					if (record.getR0190_after_nonresident_individual() != null) {
						R0190cell7.setCellValue(record.getR0190_after_nonresident_individual().doubleValue());
						R0190cell7.setCellStyle(numberStyle);
					} else {
						R0190cell7.setCellValue("");
						R0190cell7.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column I
					Cell R0190cell8 = row.createCell(8);
					if (record.getR0190_before_resident_retail() != null) {
						R0190cell8.setCellValue(record.getR0190_before_resident_retail().doubleValue());
						R0190cell8.setCellStyle(numberStyle);
					} else {
						R0190cell8.setCellValue("");
						R0190cell8.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column J
					Cell R0190cell9 = row.createCell(9);
					if (record.getR0190_after_resident_retail() != null) {
						R0190cell9.setCellValue(record.getR0190_after_resident_retail().doubleValue());
						R0190cell9.setCellStyle(numberStyle);
					} else {
						R0190cell9.setCellValue("");
						R0190cell9.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column K
					Cell R0190cell10 = row.createCell(10);
					if (record.getR0190_before_nonresident_retail() != null) {
						R0190cell10.setCellValue(record.getR0190_before_nonresident_retail().doubleValue());
						R0190cell10.setCellStyle(numberStyle);
					} else {
						R0190cell10.setCellValue("");
						R0190cell10.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column L
					Cell R0190cell11 = row.createCell(11);
					if (record.getR0190_after_nonresident_retail() != null) {
						R0190cell11.setCellValue(record.getR0190_after_nonresident_retail().doubleValue());
						R0190cell11.setCellStyle(numberStyle);
					} else {
						R0190cell11.setCellValue("");
						R0190cell11.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column M
					Cell R0190cell12 = row.createCell(12);
					if (record.getR0190_before_resident_sme() != null) {
						R0190cell12.setCellValue(record.getR0190_before_resident_sme().doubleValue());
						R0190cell12.setCellStyle(numberStyle);
					} else {
						R0190cell12.setCellValue("");
						R0190cell12.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column N
					Cell R0190cell13 = row.createCell(13);
					if (record.getR0190_after_resident_sme() != null) {
						R0190cell13.setCellValue(record.getR0190_after_resident_sme().doubleValue());
						R0190cell13.setCellStyle(numberStyle);
					} else {
						R0190cell13.setCellValue("");
						R0190cell13.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column O
					Cell R0190cell14 = row.createCell(14);
					if (record.getR0190_before_nonresident_sme() != null) {
						R0190cell14.setCellValue(record.getR0190_before_nonresident_sme().doubleValue());
						R0190cell14.setCellStyle(numberStyle);
					} else {
						R0190cell14.setCellValue("");
						R0190cell14.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column P
					Cell R0190cell15 = row.createCell(15);
					if (record.getR0190_after_nonresident_sme() != null) {
						R0190cell15.setCellValue(record.getR0190_after_nonresident_sme().doubleValue());
						R0190cell15.setCellStyle(numberStyle);
					} else {
						R0190cell15.setCellValue("");
						R0190cell15.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column Q
					Cell R0190cell16 = row.createCell(16);
					if (record.getR0190_before_resident_hni() != null) {
						R0190cell16.setCellValue(record.getR0190_before_resident_hni().doubleValue());
						R0190cell16.setCellStyle(numberStyle);
					} else {
						R0190cell16.setCellValue("");
						R0190cell16.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column R
					Cell R0190cell17 = row.createCell(17);
					if (record.getR0190_after_resident_hni() != null) {
						R0190cell17.setCellValue(record.getR0190_after_resident_hni().doubleValue());
						R0190cell17.setCellStyle(numberStyle);
					} else {
						R0190cell17.setCellValue("");
						R0190cell17.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column S
					Cell R0190cell18 = row.createCell(18);
					if (record.getR0190_before_nonresident_hni() != null) {
						R0190cell18.setCellValue(record.getR0190_before_nonresident_hni().doubleValue());
						R0190cell18.setCellStyle(numberStyle);
					} else {
						R0190cell18.setCellValue("");
						R0190cell18.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column T
					Cell R0190cell19 = row.createCell(19);
					if (record.getR0190_after_nonresident_hni() != null) {
						R0190cell19.setCellValue(record.getR0190_after_nonresident_hni().doubleValue());
						R0190cell19.setCellStyle(numberStyle);
					} else {
						R0190cell19.setCellValue("");
						R0190cell19.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column U
					Cell R0190cell20 = row.createCell(20);
					if (record.getR0190_before_resident_gre() != null) {
						R0190cell20.setCellValue(record.getR0190_before_resident_gre().doubleValue());
						R0190cell20.setCellStyle(numberStyle);
					} else {
						R0190cell20.setCellValue("");
						R0190cell20.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column V
					Cell R0190cell21 = row.createCell(21);
					if (record.getR0190_after_resident_gre() != null) {
						R0190cell21.setCellValue(record.getR0190_after_resident_gre().doubleValue());
						R0190cell21.setCellStyle(numberStyle);
					} else {
						R0190cell21.setCellValue("");
						R0190cell21.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column W
					Cell R0190cell22 = row.createCell(22);
					if (record.getR0190_before_nonresident_gre() != null) {
						R0190cell22.setCellValue(record.getR0190_before_nonresident_gre().doubleValue());
						R0190cell22.setCellStyle(numberStyle);
					} else {
						R0190cell22.setCellValue("");
						R0190cell22.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column X
					Cell R0190cell23 = row.createCell(23);
					if (record.getR0190_after_nonresident_gre() != null) {
						R0190cell23.setCellValue(record.getR0190_after_nonresident_gre().doubleValue());
						R0190cell23.setCellStyle(numberStyle);
					} else {
						R0190cell23.setCellValue("");
						R0190cell23.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column Y
					Cell R0190cell24 = row.createCell(24);
					if (record.getR0190_before_resident_corporate() != null) {
						R0190cell24.setCellValue(record.getR0190_before_resident_corporate().doubleValue());
						R0190cell24.setCellStyle(numberStyle);
					} else {
						R0190cell24.setCellValue("");
						R0190cell24.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column Z
					Cell R0190cell25 = row.createCell(25);
					if (record.getR0190_after_resident_corporate() != null) {
						R0190cell25.setCellValue(record.getR0190_after_resident_corporate().doubleValue());
						R0190cell25.setCellStyle(numberStyle);
					} else {
						R0190cell25.setCellValue("");
						R0190cell25.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AA
					Cell R0190cell26 = row.createCell(26);
					if (record.getR0190_before_nonresident_corporate() != null) {
						R0190cell26.setCellValue(record.getR0190_before_nonresident_corporate().doubleValue());
						R0190cell26.setCellStyle(numberStyle);
					} else {
						R0190cell26.setCellValue("");
						R0190cell26.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AB
					Cell R0190cell27 = row.createCell(27);
					if (record.getR0190_after_nonresident_corporate() != null) {
						R0190cell27.setCellValue(record.getR0190_after_nonresident_corporate().doubleValue());
						R0190cell27.setCellStyle(numberStyle);
					} else {
						R0190cell27.setCellValue("");
						R0190cell27.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AC
					Cell R0190cell28 = row.createCell(28);
					if (record.getR0190_before_resident_nbfi() != null) {
						R0190cell28.setCellValue(record.getR0190_before_resident_nbfi().doubleValue());
						R0190cell28.setCellStyle(numberStyle);
					} else {
						R0190cell28.setCellValue("");
						R0190cell28.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AD
					Cell R0190cell29 = row.createCell(29);
					if (record.getR0190_after_resident_nbfi() != null) {
						R0190cell29.setCellValue(record.getR0190_after_resident_nbfi().doubleValue());
						R0190cell29.setCellStyle(numberStyle);
					} else {
						R0190cell29.setCellValue("");
						R0190cell29.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AE
					Cell R0190cell30 = row.createCell(30);
					if (record.getR0190_before_nonresident_nbfi() != null) {
						R0190cell30.setCellValue(record.getR0190_before_nonresident_nbfi().doubleValue());
						R0190cell30.setCellStyle(numberStyle);
					} else {
						R0190cell30.setCellValue("");
						R0190cell30.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AF
					Cell R0190cell31 = row.createCell(31);
					if (record.getR0190_after_nonresident_nbfi() != null) {
						R0190cell31.setCellValue(record.getR0190_after_nonresident_nbfi().doubleValue());
						R0190cell31.setCellStyle(numberStyle);
					} else {
						R0190cell31.setCellValue("");
						R0190cell31.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AG
					Cell R0190cell32 = row.createCell(32);
					if (record.getR0190_before_resident_bank() != null) {
						R0190cell32.setCellValue(record.getR0190_before_resident_bank().doubleValue());
						R0190cell32.setCellStyle(numberStyle);
					} else {
						R0190cell32.setCellValue("");
						R0190cell32.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AH
					Cell R0190cell33 = row.createCell(33);
					if (record.getR0190_after_resident_bank() != null) {
						R0190cell33.setCellValue(record.getR0190_after_resident_bank().doubleValue());
						R0190cell33.setCellStyle(numberStyle);
					} else {
						R0190cell33.setCellValue("");
						R0190cell33.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AI
					Cell R0190cell34 = row.createCell(34);
					if (record.getR0190_before_nonresident_bank() != null) {
						R0190cell34.setCellValue(record.getR0190_before_nonresident_bank().doubleValue());
						R0190cell34.setCellStyle(numberStyle);
					} else {
						R0190cell34.setCellValue("");
						R0190cell34.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AJ
					Cell R0190cell35 = row.createCell(35);
					if (record.getR0190_after_nonresident_bank() != null) {
						R0190cell35.setCellValue(record.getR0190_after_nonresident_bank().doubleValue());
						R0190cell35.setCellStyle(numberStyle);
					} else {
						R0190cell35.setCellValue("");
						R0190cell35.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AK
					Cell R0190cell36 = row.createCell(36);
					if (record.getR0190_before_resident_government() != null) {
						R0190cell36.setCellValue(record.getR0190_before_resident_government().doubleValue());
						R0190cell36.setCellStyle(numberStyle);
					} else {
						R0190cell36.setCellValue("");
						R0190cell36.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AL
					Cell R0190cell37 = row.createCell(37);
					if (record.getR0190_after_resident_government() != null) {
						R0190cell37.setCellValue(record.getR0190_after_resident_government().doubleValue());
						R0190cell37.setCellStyle(numberStyle);
					} else {
						R0190cell37.setCellValue("");
						R0190cell37.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AM
					Cell R0190cell38 = row.createCell(38);
					if (record.getR0190_before_nonresident_government() != null) {
						R0190cell38.setCellValue(record.getR0190_before_nonresident_government().doubleValue());
						R0190cell38.setCellStyle(numberStyle);
					} else {
						R0190cell38.setCellValue("");
						R0190cell38.setCellStyle(textStyle);
					}

					/// ROW29
					//// Column AN
					Cell R0190cell39 = row.createCell(39);
					if (record.getR0190_after_nonresident_government() != null) {
						R0190cell39.setCellValue(record.getR0190_after_nonresident_government().doubleValue());
						R0190cell39.setCellStyle(numberStyle);
					} else {
						R0190cell39.setCellValue("");
						R0190cell39.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column E
					row = sheet.getRow(29);
					Cell R0200cell4 = row.createCell(4);
					if (record.getR0200_before_resident_individual() != null) {
						R0200cell4.setCellValue(record.getR0200_before_resident_individual().doubleValue());
						R0200cell4.setCellStyle(numberStyle);
					} else {
						R0200cell4.setCellValue("");
						R0200cell4.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column F
					Cell R0200cell5 = row.createCell(5);
					if (record.getR0200_after_resident_individual() != null) {
						R0200cell5.setCellValue(record.getR0200_after_resident_individual().doubleValue());
						R0200cell5.setCellStyle(numberStyle);
					} else {
						R0200cell5.setCellValue("");
						R0200cell5.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column G
					Cell R0200cell6 = row.createCell(6);
					if (record.getR0200_before_nonresident_individual() != null) {
						R0200cell6.setCellValue(record.getR0200_before_nonresident_individual().doubleValue());
						R0200cell6.setCellStyle(numberStyle);
					} else {
						R0200cell6.setCellValue("");
						R0200cell6.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column H
					Cell R0200cell7 = row.createCell(7);
					if (record.getR0200_after_nonresident_individual() != null) {
						R0200cell7.setCellValue(record.getR0200_after_nonresident_individual().doubleValue());
						R0200cell7.setCellStyle(numberStyle);
					} else {
						R0200cell7.setCellValue("");
						R0200cell7.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column I
					Cell R0200cell8 = row.createCell(8);
					if (record.getR0200_before_resident_retail() != null) {
						R0200cell8.setCellValue(record.getR0200_before_resident_retail().doubleValue());
						R0200cell8.setCellStyle(numberStyle);
					} else {
						R0200cell8.setCellValue("");
						R0200cell8.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column J
					Cell R0200cell9 = row.createCell(9);
					if (record.getR0200_after_resident_retail() != null) {
						R0200cell9.setCellValue(record.getR0200_after_resident_retail().doubleValue());
						R0200cell9.setCellStyle(numberStyle);
					} else {
						R0200cell9.setCellValue("");
						R0200cell9.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column K
					Cell R0200cell10 = row.createCell(10);
					if (record.getR0200_before_nonresident_retail() != null) {
						R0200cell10.setCellValue(record.getR0200_before_nonresident_retail().doubleValue());
						R0200cell10.setCellStyle(numberStyle);
					} else {
						R0200cell10.setCellValue("");
						R0200cell10.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column L
					Cell R0200cell11 = row.createCell(11);
					if (record.getR0200_after_nonresident_retail() != null) {
						R0200cell11.setCellValue(record.getR0200_after_nonresident_retail().doubleValue());
						R0200cell11.setCellStyle(numberStyle);
					} else {
						R0200cell11.setCellValue("");
						R0200cell11.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column M
					Cell R0200cell12 = row.createCell(12);
					if (record.getR0200_before_resident_sme() != null) {
						R0200cell12.setCellValue(record.getR0200_before_resident_sme().doubleValue());
						R0200cell12.setCellStyle(numberStyle);
					} else {
						R0200cell12.setCellValue("");
						R0200cell12.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column N
					Cell R0200cell13 = row.createCell(13);
					if (record.getR0200_after_resident_sme() != null) {
						R0200cell13.setCellValue(record.getR0200_after_resident_sme().doubleValue());
						R0200cell13.setCellStyle(numberStyle);
					} else {
						R0200cell13.setCellValue("");
						R0200cell13.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column O
					Cell R0200cell14 = row.createCell(14);
					if (record.getR0200_before_nonresident_sme() != null) {
						R0200cell14.setCellValue(record.getR0200_before_nonresident_sme().doubleValue());
						R0200cell14.setCellStyle(numberStyle);
					} else {
						R0200cell14.setCellValue("");
						R0200cell14.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column P
					Cell R0200cell15 = row.createCell(15);
					if (record.getR0200_after_nonresident_sme() != null) {
						R0200cell15.setCellValue(record.getR0200_after_nonresident_sme().doubleValue());
						R0200cell15.setCellStyle(numberStyle);
					} else {
						R0200cell15.setCellValue("");
						R0200cell15.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column Q
					Cell R0200cell16 = row.createCell(16);
					if (record.getR0200_before_resident_hni() != null) {
						R0200cell16.setCellValue(record.getR0200_before_resident_hni().doubleValue());
						R0200cell16.setCellStyle(numberStyle);
					} else {
						R0200cell16.setCellValue("");
						R0200cell16.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column R
					Cell R0200cell17 = row.createCell(17);
					if (record.getR0200_after_resident_hni() != null) {
						R0200cell17.setCellValue(record.getR0200_after_resident_hni().doubleValue());
						R0200cell17.setCellStyle(numberStyle);
					} else {
						R0200cell17.setCellValue("");
						R0200cell17.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column S
					Cell R0200cell18 = row.createCell(18);
					if (record.getR0200_before_nonresident_hni() != null) {
						R0200cell18.setCellValue(record.getR0200_before_nonresident_hni().doubleValue());
						R0200cell18.setCellStyle(numberStyle);
					} else {
						R0200cell18.setCellValue("");
						R0200cell18.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column T
					Cell R0200cell19 = row.createCell(19);
					if (record.getR0200_after_nonresident_hni() != null) {
						R0200cell19.setCellValue(record.getR0200_after_nonresident_hni().doubleValue());
						R0200cell19.setCellStyle(numberStyle);
					} else {
						R0200cell19.setCellValue("");
						R0200cell19.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column U
					Cell R0200cell20 = row.createCell(20);
					if (record.getR0200_before_resident_gre() != null) {
						R0200cell20.setCellValue(record.getR0200_before_resident_gre().doubleValue());
						R0200cell20.setCellStyle(numberStyle);
					} else {
						R0200cell20.setCellValue("");
						R0200cell20.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column V
					Cell R0200cell21 = row.createCell(21);
					if (record.getR0200_after_resident_gre() != null) {
						R0200cell21.setCellValue(record.getR0200_after_resident_gre().doubleValue());
						R0200cell21.setCellStyle(numberStyle);
					} else {
						R0200cell21.setCellValue("");
						R0200cell21.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column W
					Cell R0200cell22 = row.createCell(22);
					if (record.getR0200_before_nonresident_gre() != null) {
						R0200cell22.setCellValue(record.getR0200_before_nonresident_gre().doubleValue());
						R0200cell22.setCellStyle(numberStyle);
					} else {
						R0200cell22.setCellValue("");
						R0200cell22.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column X
					Cell R0200cell23 = row.createCell(23);
					if (record.getR0200_after_nonresident_gre() != null) {
						R0200cell23.setCellValue(record.getR0200_after_nonresident_gre().doubleValue());
						R0200cell23.setCellStyle(numberStyle);
					} else {
						R0200cell23.setCellValue("");
						R0200cell23.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column Y
					Cell R0200cell24 = row.createCell(24);
					if (record.getR0200_before_resident_corporate() != null) {
						R0200cell24.setCellValue(record.getR0200_before_resident_corporate().doubleValue());
						R0200cell24.setCellStyle(numberStyle);
					} else {
						R0200cell24.setCellValue("");
						R0200cell24.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column Z
					Cell R0200cell25 = row.createCell(25);
					if (record.getR0200_after_resident_corporate() != null) {
						R0200cell25.setCellValue(record.getR0200_after_resident_corporate().doubleValue());
						R0200cell25.setCellStyle(numberStyle);
					} else {
						R0200cell25.setCellValue("");
						R0200cell25.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AA
					Cell R0200cell26 = row.createCell(26);
					if (record.getR0200_before_nonresident_corporate() != null) {
						R0200cell26.setCellValue(record.getR0200_before_nonresident_corporate().doubleValue());
						R0200cell26.setCellStyle(numberStyle);
					} else {
						R0200cell26.setCellValue("");
						R0200cell26.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AB
					Cell R0200cell27 = row.createCell(27);
					if (record.getR0200_after_nonresident_corporate() != null) {
						R0200cell27.setCellValue(record.getR0200_after_nonresident_corporate().doubleValue());
						R0200cell27.setCellStyle(numberStyle);
					} else {
						R0200cell27.setCellValue("");
						R0200cell27.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AC
					Cell R0200cell28 = row.createCell(28);
					if (record.getR0200_before_resident_nbfi() != null) {
						R0200cell28.setCellValue(record.getR0200_before_resident_nbfi().doubleValue());
						R0200cell28.setCellStyle(numberStyle);
					} else {
						R0200cell28.setCellValue("");
						R0200cell28.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AD
					Cell R0200cell29 = row.createCell(29);
					if (record.getR0200_after_resident_nbfi() != null) {
						R0200cell29.setCellValue(record.getR0200_after_resident_nbfi().doubleValue());
						R0200cell29.setCellStyle(numberStyle);
					} else {
						R0200cell29.setCellValue("");
						R0200cell29.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AE
					Cell R0200cell30 = row.createCell(30);
					if (record.getR0200_before_nonresident_nbfi() != null) {
						R0200cell30.setCellValue(record.getR0200_before_nonresident_nbfi().doubleValue());
						R0200cell30.setCellStyle(numberStyle);
					} else {
						R0200cell30.setCellValue("");
						R0200cell30.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AF
					Cell R0200cell31 = row.createCell(31);
					if (record.getR0200_after_nonresident_nbfi() != null) {
						R0200cell31.setCellValue(record.getR0200_after_nonresident_nbfi().doubleValue());
						R0200cell31.setCellStyle(numberStyle);
					} else {
						R0200cell31.setCellValue("");
						R0200cell31.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AG
					Cell R0200cell32 = row.createCell(32);
					if (record.getR0200_before_resident_bank() != null) {
						R0200cell32.setCellValue(record.getR0200_before_resident_bank().doubleValue());
						R0200cell32.setCellStyle(numberStyle);
					} else {
						R0200cell32.setCellValue("");
						R0200cell32.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AH
					Cell R0200cell33 = row.createCell(33);
					if (record.getR0200_after_resident_bank() != null) {
						R0200cell33.setCellValue(record.getR0200_after_resident_bank().doubleValue());
						R0200cell33.setCellStyle(numberStyle);
					} else {
						R0200cell33.setCellValue("");
						R0200cell33.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AI
					Cell R0200cell34 = row.createCell(34);
					if (record.getR0200_before_nonresident_bank() != null) {
						R0200cell34.setCellValue(record.getR0200_before_nonresident_bank().doubleValue());
						R0200cell34.setCellStyle(numberStyle);
					} else {
						R0200cell34.setCellValue("");
						R0200cell34.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AJ
					Cell R0200cell35 = row.createCell(35);
					if (record.getR0200_after_nonresident_bank() != null) {
						R0200cell35.setCellValue(record.getR0200_after_nonresident_bank().doubleValue());
						R0200cell35.setCellStyle(numberStyle);
					} else {
						R0200cell35.setCellValue("");
						R0200cell35.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AK
					Cell R0200cell36 = row.createCell(36);
					if (record.getR0200_before_resident_government() != null) {
						R0200cell36.setCellValue(record.getR0200_before_resident_government().doubleValue());
						R0200cell36.setCellStyle(numberStyle);
					} else {
						R0200cell36.setCellValue("");
						R0200cell36.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AL
					Cell R0200cell37 = row.createCell(37);
					if (record.getR0200_after_resident_government() != null) {
						R0200cell37.setCellValue(record.getR0200_after_resident_government().doubleValue());
						R0200cell37.setCellStyle(numberStyle);
					} else {
						R0200cell37.setCellValue("");
						R0200cell37.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AM
					Cell R0200cell38 = row.createCell(38);
					if (record.getR0200_before_nonresident_government() != null) {
						R0200cell38.setCellValue(record.getR0200_before_nonresident_government().doubleValue());
						R0200cell38.setCellStyle(numberStyle);
					} else {
						R0200cell38.setCellValue("");
						R0200cell38.setCellStyle(textStyle);
					}

					/// ROW30
					//// Column AN
					Cell R0200cell39 = row.createCell(39);
					if (record.getR0200_after_nonresident_government() != null) {
						R0200cell39.setCellValue(record.getR0200_after_nonresident_government().doubleValue());
						R0200cell39.setCellStyle(numberStyle);
					} else {
						R0200cell39.setCellValue("");
						R0200cell39.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column E
					row = sheet.getRow(30);
					Cell R0210cell4 = row.createCell(4);
					if (record.getR0210_before_resident_individual() != null) {
						R0210cell4.setCellValue(record.getR0210_before_resident_individual().doubleValue());
						R0210cell4.setCellStyle(numberStyle);
					} else {
						R0210cell4.setCellValue("");
						R0210cell4.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column F
					Cell R0210cell5 = row.createCell(5);
					if (record.getR0210_after_resident_individual() != null) {
						R0210cell5.setCellValue(record.getR0210_after_resident_individual().doubleValue());
						R0210cell5.setCellStyle(numberStyle);
					} else {
						R0210cell5.setCellValue("");
						R0210cell5.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column G
					Cell R0210cell6 = row.createCell(6);
					if (record.getR0210_before_nonresident_individual() != null) {
						R0210cell6.setCellValue(record.getR0210_before_nonresident_individual().doubleValue());
						R0210cell6.setCellStyle(numberStyle);
					} else {
						R0210cell6.setCellValue("");
						R0210cell6.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column H
					Cell R0210cell7 = row.createCell(7);
					if (record.getR0210_after_nonresident_individual() != null) {
						R0210cell7.setCellValue(record.getR0210_after_nonresident_individual().doubleValue());
						R0210cell7.setCellStyle(numberStyle);
					} else {
						R0210cell7.setCellValue("");
						R0210cell7.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column I
					Cell R0210cell8 = row.createCell(8);
					if (record.getR0210_before_resident_retail() != null) {
						R0210cell8.setCellValue(record.getR0210_before_resident_retail().doubleValue());
						R0210cell8.setCellStyle(numberStyle);
					} else {
						R0210cell8.setCellValue("");
						R0210cell8.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column J
					Cell R0210cell9 = row.createCell(9);
					if (record.getR0210_after_resident_retail() != null) {
						R0210cell9.setCellValue(record.getR0210_after_resident_retail().doubleValue());
						R0210cell9.setCellStyle(numberStyle);
					} else {
						R0210cell9.setCellValue("");
						R0210cell9.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column K
					Cell R0210cell10 = row.createCell(10);
					if (record.getR0210_before_nonresident_retail() != null) {
						R0210cell10.setCellValue(record.getR0210_before_nonresident_retail().doubleValue());
						R0210cell10.setCellStyle(numberStyle);
					} else {
						R0210cell10.setCellValue("");
						R0210cell10.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column L
					Cell R0210cell11 = row.createCell(11);
					if (record.getR0210_after_nonresident_retail() != null) {
						R0210cell11.setCellValue(record.getR0210_after_nonresident_retail().doubleValue());
						R0210cell11.setCellStyle(numberStyle);
					} else {
						R0210cell11.setCellValue("");
						R0210cell11.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column M
					Cell R0210cell12 = row.createCell(12);
					if (record.getR0210_before_resident_sme() != null) {
						R0210cell12.setCellValue(record.getR0210_before_resident_sme().doubleValue());
						R0210cell12.setCellStyle(numberStyle);
					} else {
						R0210cell12.setCellValue("");
						R0210cell12.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column N
					Cell R0210cell13 = row.createCell(13);
					if (record.getR0210_after_resident_sme() != null) {
						R0210cell13.setCellValue(record.getR0210_after_resident_sme().doubleValue());
						R0210cell13.setCellStyle(numberStyle);
					} else {
						R0210cell13.setCellValue("");
						R0210cell13.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column O
					Cell R0210cell14 = row.createCell(14);
					if (record.getR0210_before_nonresident_sme() != null) {
						R0210cell14.setCellValue(record.getR0210_before_nonresident_sme().doubleValue());
						R0210cell14.setCellStyle(numberStyle);
					} else {
						R0210cell14.setCellValue("");
						R0210cell14.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column P
					Cell R0210cell15 = row.createCell(15);
					if (record.getR0210_after_nonresident_sme() != null) {
						R0210cell15.setCellValue(record.getR0210_after_nonresident_sme().doubleValue());
						R0210cell15.setCellStyle(numberStyle);
					} else {
						R0210cell15.setCellValue("");
						R0210cell15.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column Q
					Cell R0210cell16 = row.createCell(16);
					if (record.getR0210_before_resident_hni() != null) {
						R0210cell16.setCellValue(record.getR0210_before_resident_hni().doubleValue());
						R0210cell16.setCellStyle(numberStyle);
					} else {
						R0210cell16.setCellValue("");
						R0210cell16.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column R
					Cell R0210cell17 = row.createCell(17);
					if (record.getR0210_after_resident_hni() != null) {
						R0210cell17.setCellValue(record.getR0210_after_resident_hni().doubleValue());
						R0210cell17.setCellStyle(numberStyle);
					} else {
						R0210cell17.setCellValue("");
						R0210cell17.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column S
					Cell R0210cell18 = row.createCell(18);
					if (record.getR0210_before_nonresident_hni() != null) {
						R0210cell18.setCellValue(record.getR0210_before_nonresident_hni().doubleValue());
						R0210cell18.setCellStyle(numberStyle);
					} else {
						R0210cell18.setCellValue("");
						R0210cell18.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column T
					Cell R0210cell19 = row.createCell(19);
					if (record.getR0210_after_nonresident_hni() != null) {
						R0210cell19.setCellValue(record.getR0210_after_nonresident_hni().doubleValue());
						R0210cell19.setCellStyle(numberStyle);
					} else {
						R0210cell19.setCellValue("");
						R0210cell19.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column U
					Cell R0210cell20 = row.createCell(20);
					if (record.getR0210_before_resident_gre() != null) {
						R0210cell20.setCellValue(record.getR0210_before_resident_gre().doubleValue());
						R0210cell20.setCellStyle(numberStyle);
					} else {
						R0210cell20.setCellValue("");
						R0210cell20.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column V
					Cell R0210cell21 = row.createCell(21);
					if (record.getR0210_after_resident_gre() != null) {
						R0210cell21.setCellValue(record.getR0210_after_resident_gre().doubleValue());
						R0210cell21.setCellStyle(numberStyle);
					} else {
						R0210cell21.setCellValue("");
						R0210cell21.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column W
					Cell R0210cell22 = row.createCell(22);
					if (record.getR0210_before_nonresident_gre() != null) {
						R0210cell22.setCellValue(record.getR0210_before_nonresident_gre().doubleValue());
						R0210cell22.setCellStyle(numberStyle);
					} else {
						R0210cell22.setCellValue("");
						R0210cell22.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column X
					Cell R0210cell23 = row.createCell(23);
					if (record.getR0210_after_nonresident_gre() != null) {
						R0210cell23.setCellValue(record.getR0210_after_nonresident_gre().doubleValue());
						R0210cell23.setCellStyle(numberStyle);
					} else {
						R0210cell23.setCellValue("");
						R0210cell23.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column Y
					Cell R0210cell24 = row.createCell(24);
					if (record.getR0210_before_resident_corporate() != null) {
						R0210cell24.setCellValue(record.getR0210_before_resident_corporate().doubleValue());
						R0210cell24.setCellStyle(numberStyle);
					} else {
						R0210cell24.setCellValue("");
						R0210cell24.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column Z
					Cell R0210cell25 = row.createCell(25);
					if (record.getR0210_after_resident_corporate() != null) {
						R0210cell25.setCellValue(record.getR0210_after_resident_corporate().doubleValue());
						R0210cell25.setCellStyle(numberStyle);
					} else {
						R0210cell25.setCellValue("");
						R0210cell25.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AA
					Cell R0210cell26 = row.createCell(26);
					if (record.getR0210_before_nonresident_corporate() != null) {
						R0210cell26.setCellValue(record.getR0210_before_nonresident_corporate().doubleValue());
						R0210cell26.setCellStyle(numberStyle);
					} else {
						R0210cell26.setCellValue("");
						R0210cell26.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AB
					Cell R0210cell27 = row.createCell(27);
					if (record.getR0210_after_nonresident_corporate() != null) {
						R0210cell27.setCellValue(record.getR0210_after_nonresident_corporate().doubleValue());
						R0210cell27.setCellStyle(numberStyle);
					} else {
						R0210cell27.setCellValue("");
						R0210cell27.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AC
					Cell R0210cell28 = row.createCell(28);
					if (record.getR0210_before_resident_nbfi() != null) {
						R0210cell28.setCellValue(record.getR0210_before_resident_nbfi().doubleValue());
						R0210cell28.setCellStyle(numberStyle);
					} else {
						R0210cell28.setCellValue("");
						R0210cell28.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AD
					Cell R0210cell29 = row.createCell(29);
					if (record.getR0210_after_resident_nbfi() != null) {
						R0210cell29.setCellValue(record.getR0210_after_resident_nbfi().doubleValue());
						R0210cell29.setCellStyle(numberStyle);
					} else {
						R0210cell29.setCellValue("");
						R0210cell29.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AE
					Cell R0210cell30 = row.createCell(30);
					if (record.getR0210_before_nonresident_nbfi() != null) {
						R0210cell30.setCellValue(record.getR0210_before_nonresident_nbfi().doubleValue());
						R0210cell30.setCellStyle(numberStyle);
					} else {
						R0210cell30.setCellValue("");
						R0210cell30.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AF
					Cell R0210cell31 = row.createCell(31);
					if (record.getR0210_after_nonresident_nbfi() != null) {
						R0210cell31.setCellValue(record.getR0210_after_nonresident_nbfi().doubleValue());
						R0210cell31.setCellStyle(numberStyle);
					} else {
						R0210cell31.setCellValue("");
						R0210cell31.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AG
					Cell R0210cell32 = row.createCell(32);
					if (record.getR0210_before_resident_bank() != null) {
						R0210cell32.setCellValue(record.getR0210_before_resident_bank().doubleValue());
						R0210cell32.setCellStyle(numberStyle);
					} else {
						R0210cell32.setCellValue("");
						R0210cell32.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AH
					Cell R0210cell33 = row.createCell(33);
					if (record.getR0210_after_resident_bank() != null) {
						R0210cell33.setCellValue(record.getR0210_after_resident_bank().doubleValue());
						R0210cell33.setCellStyle(numberStyle);
					} else {
						R0210cell33.setCellValue("");
						R0210cell33.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AI
					Cell R0210cell34 = row.createCell(34);
					if (record.getR0210_before_nonresident_bank() != null) {
						R0210cell34.setCellValue(record.getR0210_before_nonresident_bank().doubleValue());
						R0210cell34.setCellStyle(numberStyle);
					} else {
						R0210cell34.setCellValue("");
						R0210cell34.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AJ
					Cell R0210cell35 = row.createCell(35);
					if (record.getR0210_after_nonresident_bank() != null) {
						R0210cell35.setCellValue(record.getR0210_after_nonresident_bank().doubleValue());
						R0210cell35.setCellStyle(numberStyle);
					} else {
						R0210cell35.setCellValue("");
						R0210cell35.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AK
					Cell R0210cell36 = row.createCell(36);
					if (record.getR0210_before_resident_government() != null) {
						R0210cell36.setCellValue(record.getR0210_before_resident_government().doubleValue());
						R0210cell36.setCellStyle(numberStyle);
					} else {
						R0210cell36.setCellValue("");
						R0210cell36.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AL
					Cell R0210cell37 = row.createCell(37);
					if (record.getR0210_after_resident_government() != null) {
						R0210cell37.setCellValue(record.getR0210_after_resident_government().doubleValue());
						R0210cell37.setCellStyle(numberStyle);
					} else {
						R0210cell37.setCellValue("");
						R0210cell37.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AM
					Cell R0210cell38 = row.createCell(38);
					if (record.getR0210_before_nonresident_government() != null) {
						R0210cell38.setCellValue(record.getR0210_before_nonresident_government().doubleValue());
						R0210cell38.setCellStyle(numberStyle);
					} else {
						R0210cell38.setCellValue("");
						R0210cell38.setCellStyle(textStyle);
					}

					/// ROW31
					//// Column AN
					Cell R0210cell39 = row.createCell(39);
					if (record.getR0210_after_nonresident_government() != null) {
						R0210cell39.setCellValue(record.getR0210_after_nonresident_government().doubleValue());
						R0210cell39.setCellStyle(numberStyle);
					} else {
						R0210cell39.setCellValue("");
						R0210cell39.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column E
					row = sheet.getRow(31);
					Cell R0220cell4 = row.createCell(4);
					if (record.getR0220_before_resident_individual() != null) {
						R0220cell4.setCellValue(record.getR0220_before_resident_individual().doubleValue());
						R0220cell4.setCellStyle(numberStyle);
					} else {
						R0220cell4.setCellValue("");
						R0220cell4.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column F
					Cell R0220cell5 = row.createCell(5);
					if (record.getR0220_after_resident_individual() != null) {
						R0220cell5.setCellValue(record.getR0220_after_resident_individual().doubleValue());
						R0220cell5.setCellStyle(numberStyle);
					} else {
						R0220cell5.setCellValue("");
						R0220cell5.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column G
					Cell R0220cell6 = row.createCell(6);
					if (record.getR0220_before_nonresident_individual() != null) {
						R0220cell6.setCellValue(record.getR0220_before_nonresident_individual().doubleValue());
						R0220cell6.setCellStyle(numberStyle);
					} else {
						R0220cell6.setCellValue("");
						R0220cell6.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column H
					Cell R0220cell7 = row.createCell(7);
					if (record.getR0220_after_nonresident_individual() != null) {
						R0220cell7.setCellValue(record.getR0220_after_nonresident_individual().doubleValue());
						R0220cell7.setCellStyle(numberStyle);
					} else {
						R0220cell7.setCellValue("");
						R0220cell7.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column I
					Cell R0220cell8 = row.createCell(8);
					if (record.getR0220_before_resident_retail() != null) {
						R0220cell8.setCellValue(record.getR0220_before_resident_retail().doubleValue());
						R0220cell8.setCellStyle(numberStyle);
					} else {
						R0220cell8.setCellValue("");
						R0220cell8.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column J
					Cell R0220cell9 = row.createCell(9);
					if (record.getR0220_after_resident_retail() != null) {
						R0220cell9.setCellValue(record.getR0220_after_resident_retail().doubleValue());
						R0220cell9.setCellStyle(numberStyle);
					} else {
						R0220cell9.setCellValue("");
						R0220cell9.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column K
					Cell R0220cell10 = row.createCell(10);
					if (record.getR0220_before_nonresident_retail() != null) {
						R0220cell10.setCellValue(record.getR0220_before_nonresident_retail().doubleValue());
						R0220cell10.setCellStyle(numberStyle);
					} else {
						R0220cell10.setCellValue("");
						R0220cell10.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column L
					Cell R0220cell11 = row.createCell(11);
					if (record.getR0220_after_nonresident_retail() != null) {
						R0220cell11.setCellValue(record.getR0220_after_nonresident_retail().doubleValue());
						R0220cell11.setCellStyle(numberStyle);
					} else {
						R0220cell11.setCellValue("");
						R0220cell11.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column M
					Cell R0220cell12 = row.createCell(12);
					if (record.getR0220_before_resident_sme() != null) {
						R0220cell12.setCellValue(record.getR0220_before_resident_sme().doubleValue());
						R0220cell12.setCellStyle(numberStyle);
					} else {
						R0220cell12.setCellValue("");
						R0220cell12.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column N
					Cell R0220cell13 = row.createCell(13);
					if (record.getR0220_after_resident_sme() != null) {
						R0220cell13.setCellValue(record.getR0220_after_resident_sme().doubleValue());
						R0220cell13.setCellStyle(numberStyle);
					} else {
						R0220cell13.setCellValue("");
						R0220cell13.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column O
					Cell R0220cell14 = row.createCell(14);
					if (record.getR0220_before_nonresident_sme() != null) {
						R0220cell14.setCellValue(record.getR0220_before_nonresident_sme().doubleValue());
						R0220cell14.setCellStyle(numberStyle);
					} else {
						R0220cell14.setCellValue("");
						R0220cell14.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column P
					Cell R0220cell15 = row.createCell(15);
					if (record.getR0220_after_nonresident_sme() != null) {
						R0220cell15.setCellValue(record.getR0220_after_nonresident_sme().doubleValue());
						R0220cell15.setCellStyle(numberStyle);
					} else {
						R0220cell15.setCellValue("");
						R0220cell15.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column Q
					Cell R0220cell16 = row.createCell(16);
					if (record.getR0220_before_resident_hni() != null) {
						R0220cell16.setCellValue(record.getR0220_before_resident_hni().doubleValue());
						R0220cell16.setCellStyle(numberStyle);
					} else {
						R0220cell16.setCellValue("");
						R0220cell16.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column R
					Cell R0220cell17 = row.createCell(17);
					if (record.getR0220_after_resident_hni() != null) {
						R0220cell17.setCellValue(record.getR0220_after_resident_hni().doubleValue());
						R0220cell17.setCellStyle(numberStyle);
					} else {
						R0220cell17.setCellValue("");
						R0220cell17.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column S
					Cell R0220cell18 = row.createCell(18);
					if (record.getR0220_before_nonresident_hni() != null) {
						R0220cell18.setCellValue(record.getR0220_before_nonresident_hni().doubleValue());
						R0220cell18.setCellStyle(numberStyle);
					} else {
						R0220cell18.setCellValue("");
						R0220cell18.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column T
					Cell R0220cell19 = row.createCell(19);
					if (record.getR0220_after_nonresident_hni() != null) {
						R0220cell19.setCellValue(record.getR0220_after_nonresident_hni().doubleValue());
						R0220cell19.setCellStyle(numberStyle);
					} else {
						R0220cell19.setCellValue("");
						R0220cell19.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column U
					Cell R0220cell20 = row.createCell(20);
					if (record.getR0220_before_resident_gre() != null) {
						R0220cell20.setCellValue(record.getR0220_before_resident_gre().doubleValue());
						R0220cell20.setCellStyle(numberStyle);
					} else {
						R0220cell20.setCellValue("");
						R0220cell20.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column V
					Cell R0220cell21 = row.createCell(21);
					if (record.getR0220_after_resident_gre() != null) {
						R0220cell21.setCellValue(record.getR0220_after_resident_gre().doubleValue());
						R0220cell21.setCellStyle(numberStyle);
					} else {
						R0220cell21.setCellValue("");
						R0220cell21.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column W
					Cell R0220cell22 = row.createCell(22);
					if (record.getR0220_before_nonresident_gre() != null) {
						R0220cell22.setCellValue(record.getR0220_before_nonresident_gre().doubleValue());
						R0220cell22.setCellStyle(numberStyle);
					} else {
						R0220cell22.setCellValue("");
						R0220cell22.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column X
					Cell R0220cell23 = row.createCell(23);
					if (record.getR0220_after_nonresident_gre() != null) {
						R0220cell23.setCellValue(record.getR0220_after_nonresident_gre().doubleValue());
						R0220cell23.setCellStyle(numberStyle);
					} else {
						R0220cell23.setCellValue("");
						R0220cell23.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column Y
					Cell R0220cell24 = row.createCell(24);
					if (record.getR0220_before_resident_corporate() != null) {
						R0220cell24.setCellValue(record.getR0220_before_resident_corporate().doubleValue());
						R0220cell24.setCellStyle(numberStyle);
					} else {
						R0220cell24.setCellValue("");
						R0220cell24.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column Z
					Cell R0220cell25 = row.createCell(25);
					if (record.getR0220_after_resident_corporate() != null) {
						R0220cell25.setCellValue(record.getR0220_after_resident_corporate().doubleValue());
						R0220cell25.setCellStyle(numberStyle);
					} else {
						R0220cell25.setCellValue("");
						R0220cell25.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AA
					Cell R0220cell26 = row.createCell(26);
					if (record.getR0220_before_nonresident_corporate() != null) {
						R0220cell26.setCellValue(record.getR0220_before_nonresident_corporate().doubleValue());
						R0220cell26.setCellStyle(numberStyle);
					} else {
						R0220cell26.setCellValue("");
						R0220cell26.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AB
					Cell R0220cell27 = row.createCell(27);
					if (record.getR0220_after_nonresident_corporate() != null) {
						R0220cell27.setCellValue(record.getR0220_after_nonresident_corporate().doubleValue());
						R0220cell27.setCellStyle(numberStyle);
					} else {
						R0220cell27.setCellValue("");
						R0220cell27.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AC
					Cell R0220cell28 = row.createCell(28);
					if (record.getR0220_before_resident_nbfi() != null) {
						R0220cell28.setCellValue(record.getR0220_before_resident_nbfi().doubleValue());
						R0220cell28.setCellStyle(numberStyle);
					} else {
						R0220cell28.setCellValue("");
						R0220cell28.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AD
					Cell R0220cell29 = row.createCell(29);
					if (record.getR0220_after_resident_nbfi() != null) {
						R0220cell29.setCellValue(record.getR0220_after_resident_nbfi().doubleValue());
						R0220cell29.setCellStyle(numberStyle);
					} else {
						R0220cell29.setCellValue("");
						R0220cell29.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AE
					Cell R0220cell30 = row.createCell(30);
					if (record.getR0220_before_nonresident_nbfi() != null) {
						R0220cell30.setCellValue(record.getR0220_before_nonresident_nbfi().doubleValue());
						R0220cell30.setCellStyle(numberStyle);
					} else {
						R0220cell30.setCellValue("");
						R0220cell30.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AF
					Cell R0220cell31 = row.createCell(31);
					if (record.getR0220_after_nonresident_nbfi() != null) {
						R0220cell31.setCellValue(record.getR0220_after_nonresident_nbfi().doubleValue());
						R0220cell31.setCellStyle(numberStyle);
					} else {
						R0220cell31.setCellValue("");
						R0220cell31.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AG
					Cell R0220cell32 = row.createCell(32);
					if (record.getR0220_before_resident_bank() != null) {
						R0220cell32.setCellValue(record.getR0220_before_resident_bank().doubleValue());
						R0220cell32.setCellStyle(numberStyle);
					} else {
						R0220cell32.setCellValue("");
						R0220cell32.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AH
					Cell R0220cell33 = row.createCell(33);
					if (record.getR0220_after_resident_bank() != null) {
						R0220cell33.setCellValue(record.getR0220_after_resident_bank().doubleValue());
						R0220cell33.setCellStyle(numberStyle);
					} else {
						R0220cell33.setCellValue("");
						R0220cell33.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AI
					Cell R0220cell34 = row.createCell(34);
					if (record.getR0220_before_nonresident_bank() != null) {
						R0220cell34.setCellValue(record.getR0220_before_nonresident_bank().doubleValue());
						R0220cell34.setCellStyle(numberStyle);
					} else {
						R0220cell34.setCellValue("");
						R0220cell34.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AJ
					Cell R0220cell35 = row.createCell(35);
					if (record.getR0220_after_nonresident_bank() != null) {
						R0220cell35.setCellValue(record.getR0220_after_nonresident_bank().doubleValue());
						R0220cell35.setCellStyle(numberStyle);
					} else {
						R0220cell35.setCellValue("");
						R0220cell35.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AK
					Cell R0220cell36 = row.createCell(36);
					if (record.getR0220_before_resident_government() != null) {
						R0220cell36.setCellValue(record.getR0220_before_resident_government().doubleValue());
						R0220cell36.setCellStyle(numberStyle);
					} else {
						R0220cell36.setCellValue("");
						R0220cell36.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AL
					Cell R0220cell37 = row.createCell(37);
					if (record.getR0220_after_resident_government() != null) {
						R0220cell37.setCellValue(record.getR0220_after_resident_government().doubleValue());
						R0220cell37.setCellStyle(numberStyle);
					} else {
						R0220cell37.setCellValue("");
						R0220cell37.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AM
					Cell R0220cell38 = row.createCell(38);
					if (record.getR0220_before_nonresident_government() != null) {
						R0220cell38.setCellValue(record.getR0220_before_nonresident_government().doubleValue());
						R0220cell38.setCellStyle(numberStyle);
					} else {
						R0220cell38.setCellValue("");
						R0220cell38.setCellStyle(textStyle);
					}

					/// ROW32
					//// Column AN
					Cell R0220cell39 = row.createCell(39);
					if (record.getR0220_after_nonresident_government() != null) {
						R0220cell39.setCellValue(record.getR0220_after_nonresident_government().doubleValue());
						R0220cell39.setCellStyle(numberStyle);
					} else {
						R0220cell39.setCellValue("");
						R0220cell39.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column E
					row = sheet.getRow(32);
					Cell R0230cell4 = row.createCell(4);
					if (record.getR0230_before_resident_individual() != null) {
						R0230cell4.setCellValue(record.getR0230_before_resident_individual().doubleValue());
						R0230cell4.setCellStyle(numberStyle);
					} else {
						R0230cell4.setCellValue("");
						R0230cell4.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column F
					Cell R0230cell5 = row.createCell(5);
					if (record.getR0230_after_resident_individual() != null) {
						R0230cell5.setCellValue(record.getR0230_after_resident_individual().doubleValue());
						R0230cell5.setCellStyle(numberStyle);
					} else {
						R0230cell5.setCellValue("");
						R0230cell5.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column G
					Cell R0230cell6 = row.createCell(6);
					if (record.getR0230_before_nonresident_individual() != null) {
						R0230cell6.setCellValue(record.getR0230_before_nonresident_individual().doubleValue());
						R0230cell6.setCellStyle(numberStyle);
					} else {
						R0230cell6.setCellValue("");
						R0230cell6.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column H
					Cell R0230cell7 = row.createCell(7);
					if (record.getR0230_after_nonresident_individual() != null) {
						R0230cell7.setCellValue(record.getR0230_after_nonresident_individual().doubleValue());
						R0230cell7.setCellStyle(numberStyle);
					} else {
						R0230cell7.setCellValue("");
						R0230cell7.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column I
					Cell R0230cell8 = row.createCell(8);
					if (record.getR0230_before_resident_retail() != null) {
						R0230cell8.setCellValue(record.getR0230_before_resident_retail().doubleValue());
						R0230cell8.setCellStyle(numberStyle);
					} else {
						R0230cell8.setCellValue("");
						R0230cell8.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column J
					Cell R0230cell9 = row.createCell(9);
					if (record.getR0230_after_resident_retail() != null) {
						R0230cell9.setCellValue(record.getR0230_after_resident_retail().doubleValue());
						R0230cell9.setCellStyle(numberStyle);
					} else {
						R0230cell9.setCellValue("");
						R0230cell9.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column K
					Cell R0230cell10 = row.createCell(10);
					if (record.getR0230_before_nonresident_retail() != null) {
						R0230cell10.setCellValue(record.getR0230_before_nonresident_retail().doubleValue());
						R0230cell10.setCellStyle(numberStyle);
					} else {
						R0230cell10.setCellValue("");
						R0230cell10.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column L
					Cell R0230cell11 = row.createCell(11);
					if (record.getR0230_after_nonresident_retail() != null) {
						R0230cell11.setCellValue(record.getR0230_after_nonresident_retail().doubleValue());
						R0230cell11.setCellStyle(numberStyle);
					} else {
						R0230cell11.setCellValue("");
						R0230cell11.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column M
					Cell R0230cell12 = row.createCell(12);
					if (record.getR0230_before_resident_sme() != null) {
						R0230cell12.setCellValue(record.getR0230_before_resident_sme().doubleValue());
						R0230cell12.setCellStyle(numberStyle);
					} else {
						R0230cell12.setCellValue("");
						R0230cell12.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column N
					Cell R0230cell13 = row.createCell(13);
					if (record.getR0230_after_resident_sme() != null) {
						R0230cell13.setCellValue(record.getR0230_after_resident_sme().doubleValue());
						R0230cell13.setCellStyle(numberStyle);
					} else {
						R0230cell13.setCellValue("");
						R0230cell13.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column O
					Cell R0230cell14 = row.createCell(14);
					if (record.getR0230_before_nonresident_sme() != null) {
						R0230cell14.setCellValue(record.getR0230_before_nonresident_sme().doubleValue());
						R0230cell14.setCellStyle(numberStyle);
					} else {
						R0230cell14.setCellValue("");
						R0230cell14.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column P
					Cell R0230cell15 = row.createCell(15);
					if (record.getR0230_after_nonresident_sme() != null) {
						R0230cell15.setCellValue(record.getR0230_after_nonresident_sme().doubleValue());
						R0230cell15.setCellStyle(numberStyle);
					} else {
						R0230cell15.setCellValue("");
						R0230cell15.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column Q
					Cell R0230cell16 = row.createCell(16);
					if (record.getR0230_before_resident_hni() != null) {
						R0230cell16.setCellValue(record.getR0230_before_resident_hni().doubleValue());
						R0230cell16.setCellStyle(numberStyle);
					} else {
						R0230cell16.setCellValue("");
						R0230cell16.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column R
					Cell R0230cell17 = row.createCell(17);
					if (record.getR0230_after_resident_hni() != null) {
						R0230cell17.setCellValue(record.getR0230_after_resident_hni().doubleValue());
						R0230cell17.setCellStyle(numberStyle);
					} else {
						R0230cell17.setCellValue("");
						R0230cell17.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column S
					Cell R0230cell18 = row.createCell(18);
					if (record.getR0230_before_nonresident_hni() != null) {
						R0230cell18.setCellValue(record.getR0230_before_nonresident_hni().doubleValue());
						R0230cell18.setCellStyle(numberStyle);
					} else {
						R0230cell18.setCellValue("");
						R0230cell18.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column T
					Cell R0230cell19 = row.createCell(19);
					if (record.getR0230_after_nonresident_hni() != null) {
						R0230cell19.setCellValue(record.getR0230_after_nonresident_hni().doubleValue());
						R0230cell19.setCellStyle(numberStyle);
					} else {
						R0230cell19.setCellValue("");
						R0230cell19.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column U
					Cell R0230cell20 = row.createCell(20);
					if (record.getR0230_before_resident_gre() != null) {
						R0230cell20.setCellValue(record.getR0230_before_resident_gre().doubleValue());
						R0230cell20.setCellStyle(numberStyle);
					} else {
						R0230cell20.setCellValue("");
						R0230cell20.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column V
					Cell R0230cell21 = row.createCell(21);
					if (record.getR0230_after_resident_gre() != null) {
						R0230cell21.setCellValue(record.getR0230_after_resident_gre().doubleValue());
						R0230cell21.setCellStyle(numberStyle);
					} else {
						R0230cell21.setCellValue("");
						R0230cell21.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column W
					Cell R0230cell22 = row.createCell(22);
					if (record.getR0230_before_nonresident_gre() != null) {
						R0230cell22.setCellValue(record.getR0230_before_nonresident_gre().doubleValue());
						R0230cell22.setCellStyle(numberStyle);
					} else {
						R0230cell22.setCellValue("");
						R0230cell22.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column X
					Cell R0230cell23 = row.createCell(23);
					if (record.getR0230_after_nonresident_gre() != null) {
						R0230cell23.setCellValue(record.getR0230_after_nonresident_gre().doubleValue());
						R0230cell23.setCellStyle(numberStyle);
					} else {
						R0230cell23.setCellValue("");
						R0230cell23.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column Y
					Cell R0230cell24 = row.createCell(24);
					if (record.getR0230_before_resident_corporate() != null) {
						R0230cell24.setCellValue(record.getR0230_before_resident_corporate().doubleValue());
						R0230cell24.setCellStyle(numberStyle);
					} else {
						R0230cell24.setCellValue("");
						R0230cell24.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column Z
					Cell R0230cell25 = row.createCell(25);
					if (record.getR0230_after_resident_corporate() != null) {
						R0230cell25.setCellValue(record.getR0230_after_resident_corporate().doubleValue());
						R0230cell25.setCellStyle(numberStyle);
					} else {
						R0230cell25.setCellValue("");
						R0230cell25.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AA
					Cell R0230cell26 = row.createCell(26);
					if (record.getR0230_before_nonresident_corporate() != null) {
						R0230cell26.setCellValue(record.getR0230_before_nonresident_corporate().doubleValue());
						R0230cell26.setCellStyle(numberStyle);
					} else {
						R0230cell26.setCellValue("");
						R0230cell26.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AB
					Cell R0230cell27 = row.createCell(27);
					if (record.getR0230_after_nonresident_corporate() != null) {
						R0230cell27.setCellValue(record.getR0230_after_nonresident_corporate().doubleValue());
						R0230cell27.setCellStyle(numberStyle);
					} else {
						R0230cell27.setCellValue("");
						R0230cell27.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AC
					Cell R0230cell28 = row.createCell(28);
					if (record.getR0230_before_resident_nbfi() != null) {
						R0230cell28.setCellValue(record.getR0230_before_resident_nbfi().doubleValue());
						R0230cell28.setCellStyle(numberStyle);
					} else {
						R0230cell28.setCellValue("");
						R0230cell28.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AD
					Cell R0230cell29 = row.createCell(29);
					if (record.getR0230_after_resident_nbfi() != null) {
						R0230cell29.setCellValue(record.getR0230_after_resident_nbfi().doubleValue());
						R0230cell29.setCellStyle(numberStyle);
					} else {
						R0230cell29.setCellValue("");
						R0230cell29.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AE
					Cell R0230cell30 = row.createCell(30);
					if (record.getR0230_before_nonresident_nbfi() != null) {
						R0230cell30.setCellValue(record.getR0230_before_nonresident_nbfi().doubleValue());
						R0230cell30.setCellStyle(numberStyle);
					} else {
						R0230cell30.setCellValue("");
						R0230cell30.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AF
					Cell R0230cell31 = row.createCell(31);
					if (record.getR0230_after_nonresident_nbfi() != null) {
						R0230cell31.setCellValue(record.getR0230_after_nonresident_nbfi().doubleValue());
						R0230cell31.setCellStyle(numberStyle);
					} else {
						R0230cell31.setCellValue("");
						R0230cell31.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AG
					Cell R0230cell32 = row.createCell(32);
					if (record.getR0230_before_resident_bank() != null) {
						R0230cell32.setCellValue(record.getR0230_before_resident_bank().doubleValue());
						R0230cell32.setCellStyle(numberStyle);
					} else {
						R0230cell32.setCellValue("");
						R0230cell32.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AH
					Cell R0230cell33 = row.createCell(33);
					if (record.getR0230_after_resident_bank() != null) {
						R0230cell33.setCellValue(record.getR0230_after_resident_bank().doubleValue());
						R0230cell33.setCellStyle(numberStyle);
					} else {
						R0230cell33.setCellValue("");
						R0230cell33.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AI
					Cell R0230cell34 = row.createCell(34);
					if (record.getR0230_before_nonresident_bank() != null) {
						R0230cell34.setCellValue(record.getR0230_before_nonresident_bank().doubleValue());
						R0230cell34.setCellStyle(numberStyle);
					} else {
						R0230cell34.setCellValue("");
						R0230cell34.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AJ
					Cell R0230cell35 = row.createCell(35);
					if (record.getR0230_after_nonresident_bank() != null) {
						R0230cell35.setCellValue(record.getR0230_after_nonresident_bank().doubleValue());
						R0230cell35.setCellStyle(numberStyle);
					} else {
						R0230cell35.setCellValue("");
						R0230cell35.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AK
					Cell R0230cell36 = row.createCell(36);
					if (record.getR0230_before_resident_government() != null) {
						R0230cell36.setCellValue(record.getR0230_before_resident_government().doubleValue());
						R0230cell36.setCellStyle(numberStyle);
					} else {
						R0230cell36.setCellValue("");
						R0230cell36.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AL
					Cell R0230cell37 = row.createCell(37);
					if (record.getR0230_after_resident_government() != null) {
						R0230cell37.setCellValue(record.getR0230_after_resident_government().doubleValue());
						R0230cell37.setCellStyle(numberStyle);
					} else {
						R0230cell37.setCellValue("");
						R0230cell37.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AM
					Cell R0230cell38 = row.createCell(38);
					if (record.getR0230_before_nonresident_government() != null) {
						R0230cell38.setCellValue(record.getR0230_before_nonresident_government().doubleValue());
						R0230cell38.setCellStyle(numberStyle);
					} else {
						R0230cell38.setCellValue("");
						R0230cell38.setCellStyle(textStyle);
					}

					/// ROW33
					//// Column AN
					Cell R0230cell39 = row.createCell(39);
					if (record.getR0230_after_nonresident_government() != null) {
						R0230cell39.setCellValue(record.getR0230_after_nonresident_government().doubleValue());
						R0230cell39.setCellStyle(numberStyle);
					} else {
						R0230cell39.setCellValue("");
						R0230cell39.setCellStyle(textStyle);
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
	public byte[] getBRF5_17DetailExcel(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF5_17 Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {
				byte[] ARCHIVALreport = getBRF5_17DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
						type, version);
				return ARCHIVALreport;
			}

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF5_17Details");

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
			List<CBUAE_BRF5_17_Detail_Entity> reportData = BRF5_17_Detail_Repo.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF5_17_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF5_17 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF5_17 Excel", e);
			return new byte[0];
		}
	}

	public byte[] getBRF5_17DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF5_17 ARCHIVAL Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {

			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF5_17Details");

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
			List<CBUAE_BRF5_17__Archival_Detail_Entity> reportData = archival_detail_repo
					.getdatabydateList(parsedToDate, version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF5_17__Archival_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF5_17 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF5_17 Excel", e);
			return new byte[0];
		}
	}

}
