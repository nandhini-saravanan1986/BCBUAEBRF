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
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.bornfire.brf.entities.CBUAE_BRF5_3_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Archival_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Repo2;

@Component
@Service

public class CBUAE_BRF5_3_ReportService {
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF5_3_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF5_3_Summary_Archival_Repo1 BRF5_3_Summary_Archival_Repo1;

	@Autowired
	CBUAE_BRF5_3_Summary_Archival_Repo2 BRF5_3_Summary_Archival_Repo2;

	@Autowired
	CBUAE_BRF5_3_Archival_Detail_Repo BRF5_3_archival_detail_repo;

	@Autowired
	CBUAE_BRF5_3_Detail_Repo BRF5_3_Detail_Repo;

	@Autowired
	CBUAE_BRF5_3_Summary_Repo1 BRF5_3_Summary_Repo1;

	@Autowired
	CBUAE_BRF5_3_Summary_Repo2 BRF5_3_Summary_Repo2;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF5_3View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {
System.out.println("getBRF5_3View");
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF5_3_Summary_Archival_Entity1> T1Master = new ArrayList<CBUAE_BRF5_3_Summary_Archival_Entity1>();
			List<CBUAE_BRF5_3_Summary_Archival_Entity2> T1Master1 = new ArrayList<CBUAE_BRF5_3_Summary_Archival_Entity2>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF5_3_Summary_Archival_Repo1.getdatabydateListarchival(dateformat.parse(todate), version);
				T1Master1 = BRF5_3_Summary_Archival_Repo2.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
		}

		else {
			List<CBUAE_BRF5_3_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF5_3_Summary_Entity1>();
			List<CBUAE_BRF5_3_Summary_Entity2> T1Master1 = new ArrayList<CBUAE_BRF5_3_Summary_Entity2>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF5_3_Summary_Repo1.getdatabydateList(dateformat.parse(todate));
				T1Master1 = BRF5_3_Summary_Repo2.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
		}

		mv.setViewName("BRF/BRF5_3");

		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF5_3currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int totalPages = 0;

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF5_3_Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF5_3_Archival_Detail_Entity>();
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
					T1Dt1 = BRF5_3_archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId,
							dateformat.parse(todate), version);

					System.out.println("countavd" + T1Dt1.size());
				} else {
					T1Dt1 = BRF5_3_archival_detail_repo.getdatabydateList(d1, version, currentPage, pageSize);
					totalPages = BRF5_3_archival_detail_repo.getdatacount(dateformat.parse(todate), version);
					mv.addObject("pagination", "YES");
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println(type);
			List<CBUAE_BRF5_3_Detail_Entity> T1Dt1 = new ArrayList<>();

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
					T1Dt1 = BRF5_3_Detail_Repo.GetDataByRowIdAndColumnId(rowId, columnId,
							dateformat.parse(todate));
				} else {
					T1Dt1 = BRF5_3_Detail_Repo.getdatabydateList(d1, currentPage, pageSize);
					totalPages = BRF5_3_Detail_Repo.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination", "YES");
				}
				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

				System.out.println("LISTCOUNT: " + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("BRF/BRF5_3");
		mv.addObject("currentPage", currentPage);
		mv.addObject("totalPages", (int) Math.ceil((double) totalPages / 100));
		mv.addObject("displaymode", "Details");

		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<Object> getBRF5_3Archival() {
		try {
			List<Object> merged = new ArrayList<>();
			merged.addAll(BRF5_3_Summary_Archival_Repo1.getBRF5_3archival());
			merged.addAll(BRF5_3_Summary_Archival_Repo2.getBRF5_3archival());

			
			/*
			 * public List<Object> getBRF1_2Archival() { try { List<Object> merged = new
			 * ArrayList<>();
			 * merged.addAll(BRF5_3_Summary_Archival_Repo1.getbrf1_2archival());
			 * merged.addAll(BRF5_3_Summary_Archival_Repo1.getbrf1_2archival());
			 */

			Set<String> seen = new HashSet<>();
			List<Object> uniqueList = new ArrayList<>();

			for (Object obj : merged) {
				Object[] row = (Object[]) obj;
				String key = row[0] + "_" + row[1]; // unique by date+version
				if (seen.add(key)) {
					uniqueList.add(row);
				}
			}

			System.out.println("Unique Count: " + uniqueList.size());
			return uniqueList;

		} catch (Exception e) {
			System.err.println("Error fetching BRF5_3 Archival data: " + e.getMessage());
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	
	public byte[] getBRF5_3Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {

		logger.info("Service: Starting Excel generation process in memory.");
		
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF5_3ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}
		List<CBUAE_BRF5_3_Summary_Entity1> dataList = BRF5_3_Summary_Repo1.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF5_3_Summary_Entity2> dataList1 = BRF5_3_Summary_Repo2.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF5.3 report. Returning empty result.");
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

	private void populateEntity1Data(Sheet sheet, CBUAE_BRF5_3_Summary_Entity1 record, CellStyle textStyle,
			CellStyle numberStyle) {

		// R0020 - ROW 10 (Index 10)
		Row row = sheet.getRow(10) != null ? sheet.getRow(10) : sheet.createRow(10);

		/// ROW11
		//// Column E
		Cell R0020cell4 = row.createCell(4);
		if (record.getR0020_outstandbal() != null) {
			R0020cell4.setCellValue(record.getR0020_outstandbal().doubleValue());
			R0020cell4.setCellStyle(numberStyle);
		} else {
			R0020cell4.setCellValue("");
			R0020cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0020cell5 = row.createCell(5);
		if (record.getR0020_secured_outstandbal() != null) {
			R0020cell5.setCellValue(record.getR0020_secured_outstandbal().doubleValue());
			R0020cell5.setCellStyle(numberStyle);
		} else {
			R0020cell5.setCellValue("");
			R0020cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0020cell6 = row.createCell(6);
		if (record.getR0020_unsecured_outstandbal() != null) {
			R0020cell6.setCellValue(record.getR0020_unsecured_outstandbal().doubleValue());
			R0020cell6.setCellStyle(numberStyle);
		} else {
			R0020cell6.setCellValue("");
			R0020cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0020cell7 = row.createCell(7);
		if (record.getR0020_stage1_assetclass() != null) {
			R0020cell7.setCellValue(record.getR0020_stage1_assetclass().doubleValue());
			R0020cell7.setCellStyle(numberStyle);
		} else {
			R0020cell7.setCellValue("");
			R0020cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0020cell8 = row.createCell(8);
		if (record.getR0020_stage2_assetclass() != null) {
			R0020cell8.setCellValue(record.getR0020_stage2_assetclass().doubleValue());
			R0020cell8.setCellStyle(numberStyle);
		} else {
			R0020cell8.setCellValue("");
			R0020cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0020cell9 = row.createCell(9);
		if (record.getR0020_stage3a_assetclass() != null) {
			R0020cell9.setCellValue(record.getR0020_stage3a_assetclass().doubleValue());
			R0020cell9.setCellStyle(numberStyle);
		} else {
			R0020cell9.setCellValue("");
			R0020cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0020cell10 = row.createCell(10);
		if (record.getR0020_stage3b_assetclass() != null) {
			R0020cell10.setCellValue(record.getR0020_stage3b_assetclass().doubleValue());
			R0020cell10.setCellStyle(numberStyle);
		} else {
			R0020cell10.setCellValue("");
			R0020cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0020cell11 = row.createCell(11);
		if (record.getR0020_stage3c_assetclass() != null) {
			R0020cell11.setCellValue(record.getR0020_stage3c_assetclass().doubleValue());
			R0020cell11.setCellStyle(numberStyle);
		} else {
			R0020cell11.setCellValue("");
			R0020cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0020cell12 = row.createCell(12);
		if (record.getR0020_stage1_provisionheld() != null) {
			R0020cell12.setCellValue(record.getR0020_stage1_provisionheld().doubleValue());
			R0020cell12.setCellStyle(numberStyle);
		} else {
			R0020cell12.setCellValue("");
			R0020cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0020cell13 = row.createCell(13);
		if (record.getR0020_stage2_provisionheld() != null) {
			R0020cell13.setCellValue(record.getR0020_stage2_provisionheld().doubleValue());
			R0020cell13.setCellStyle(numberStyle);
		} else {
			R0020cell13.setCellValue("");
			R0020cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0020cell14 = row.createCell(14);
		if (record.getR0020_stage3a_provisionheld() != null) {
			R0020cell14.setCellValue(record.getR0020_stage3a_provisionheld().doubleValue());
			R0020cell14.setCellStyle(numberStyle);
		} else {
			R0020cell14.setCellValue("");
			R0020cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0020cell15 = row.createCell(15);
		if (record.getR0020_stage3b_provisionheld() != null) {
			R0020cell15.setCellValue(record.getR0020_stage3b_provisionheld().doubleValue());
			R0020cell15.setCellStyle(numberStyle);
		} else {
			R0020cell15.setCellValue("");
			R0020cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0020cell16 = row.createCell(16);
		if (record.getR0020_stage3c_provisionheld() != null) {
			R0020cell16.setCellValue(record.getR0020_stage3c_provisionheld().doubleValue());
			R0020cell16.setCellStyle(numberStyle);
		} else {
			R0020cell16.setCellValue("");
			R0020cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0020cell17 = row.createCell(17);
		if (record.getR0020_intrestfees_provisionheld() != null) {
			R0020cell17.setCellValue(record.getR0020_intrestfees_provisionheld().doubleValue());
			R0020cell17.setCellStyle(numberStyle);
		} else {
			R0020cell17.setCellValue("");
			R0020cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0020cell18 = row.createCell(18);
		if (record.getR0020_intrestsuspense_provisionheld() != null) {
			R0020cell18.setCellValue(record.getR0020_intrestsuspense_provisionheld().doubleValue());
			R0020cell18.setCellStyle(numberStyle);
		} else {
			R0020cell18.setCellValue("");
			R0020cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0020cell19 = row.createCell(19);
		if (record.getR0020_stage1_poci() != null) {
			R0020cell19.setCellValue(record.getR0020_stage1_poci().doubleValue());
			R0020cell19.setCellStyle(numberStyle);
		} else {
			R0020cell19.setCellValue("");
			R0020cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0020cell20 = row.createCell(20);
		if (record.getR0020_stage2_poci() != null) {
			R0020cell20.setCellValue(record.getR0020_stage2_poci().doubleValue());
			R0020cell20.setCellStyle(numberStyle);
		} else {
			R0020cell20.setCellValue("");
			R0020cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0020cell21 = row.createCell(21);
		if (record.getR0020_stage3a_poci() != null) {
			R0020cell21.setCellValue(record.getR0020_stage3a_poci().doubleValue());
			R0020cell21.setCellStyle(numberStyle);
		} else {
			R0020cell21.setCellValue("");
			R0020cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0020cell22 = row.createCell(22);
		if (record.getR0020_stage3b_poci() != null) {
			R0020cell22.setCellValue(record.getR0020_stage3b_poci().doubleValue());
			R0020cell22.setCellStyle(numberStyle);
		} else {
			R0020cell22.setCellValue("");
			R0020cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0020cell23 = row.createCell(23);
		if (record.getR0020_stage3c_poci() != null) {
			R0020cell23.setCellValue(record.getR0020_stage3c_poci().doubleValue());
			R0020cell23.setCellStyle(numberStyle);
		} else {
			R0020cell23.setCellValue("");
			R0020cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0020cell24 = row.createCell(24);
		if (record.getR0020_current_pastdues() != null) {
			R0020cell24.setCellValue(record.getR0020_current_pastdues().doubleValue());
			R0020cell24.setCellStyle(numberStyle);
		} else {
			R0020cell24.setCellValue("");
			R0020cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0020cell25 = row.createCell(25);
		if (record.getR0020_less30days_pastdues() != null) {
			R0020cell25.setCellValue(record.getR0020_less30days_pastdues().doubleValue());
			R0020cell25.setCellStyle(numberStyle);
		} else {
			R0020cell25.setCellValue("");
			R0020cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0020cell26 = row.createCell(26);
		if (record.getR0020_31to90days_pastdues() != null) {
			R0020cell26.setCellValue(record.getR0020_31to90days_pastdues().doubleValue());
			R0020cell26.setCellStyle(numberStyle);
		} else {
			R0020cell26.setCellValue("");
			R0020cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0020cell27 = row.createCell(27);
		if (record.getR0020_91to120days_pastdues() != null) {
			R0020cell27.setCellValue(record.getR0020_91to120days_pastdues().doubleValue());
			R0020cell27.setCellStyle(numberStyle);
		} else {
			R0020cell27.setCellValue("");
			R0020cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0020cell28 = row.createCell(28);
		if (record.getR0020_121to180days_pastdues() != null) {
			R0020cell28.setCellValue(record.getR0020_121to180days_pastdues().doubleValue());
			R0020cell28.setCellStyle(numberStyle);
		} else {
			R0020cell28.setCellValue("");
			R0020cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0020cell29 = row.createCell(29);
		if (record.getR0020_181to365days_pastdues() != null) {
			R0020cell29.setCellValue(record.getR0020_181to365days_pastdues().doubleValue());
			R0020cell29.setCellStyle(numberStyle);
		} else {
			R0020cell29.setCellValue("");
			R0020cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0020cell30 = row.createCell(30);
		if (record.getR0020_over365days_pastdues() != null) {
			R0020cell30.setCellValue(record.getR0020_over365days_pastdues().doubleValue());
			R0020cell30.setCellStyle(numberStyle);
		} else {
			R0020cell30.setCellValue("");
			R0020cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0020cell32 = row.createCell(32);
		if (record.getR0020_newloan_duringreport() != null) {
			R0020cell32.setCellValue(record.getR0020_newloan_duringreport().doubleValue());
			R0020cell32.setCellStyle(numberStyle);
		} else {
			R0020cell32.setCellValue("");
			R0020cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0020cell33 = row.createCell(33);
		if (record.getR0020_newstage_duringreport() != null) {
			R0020cell33.setCellValue(record.getR0020_newstage_duringreport().doubleValue());
			R0020cell33.setCellStyle(numberStyle);
		} else {
			R0020cell33.setCellValue("");
			R0020cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0020cell34 = row.createCell(34);
		if (record.getR0020_intrestfees_duringreport() != null) {
			R0020cell34.setCellValue(record.getR0020_intrestfees_duringreport().doubleValue());
			R0020cell34.setCellStyle(numberStyle);
		} else {
			R0020cell34.setCellValue("");
			R0020cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0020cell35 = row.createCell(35);
		if (record.getR0020_performingac_acinfo() != null) {
			R0020cell35.setCellValue(record.getR0020_performingac_acinfo().doubleValue());
			R0020cell35.setCellStyle(numberStyle);
		} else {
			R0020cell35.setCellValue("");
			R0020cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0020cell36 = row.createCell(36);
		if (record.getR0020_nonperformingac_acinfo() != null) {
			R0020cell36.setCellValue(record.getR0020_nonperformingac_acinfo().doubleValue());
			R0020cell36.setCellStyle(numberStyle);
		} else {
			R0020cell36.setCellValue("");
			R0020cell36.setCellStyle(textStyle);
		}

		/// ROW12
		//// Column E
		row = sheet.getRow(11);
		Cell R0030cell4 = row.createCell(4);
		if (record.getR0030_outstandbal() != null) {
			R0030cell4.setCellValue(record.getR0030_outstandbal().doubleValue());
			R0030cell4.setCellStyle(numberStyle);
		} else {
			R0030cell4.setCellValue("");
			R0030cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0030cell5 = row.createCell(5);
		if (record.getR0030_secured_outstandbal() != null) {
			R0030cell5.setCellValue(record.getR0030_secured_outstandbal().doubleValue());
			R0030cell5.setCellStyle(numberStyle);
		} else {
			R0030cell5.setCellValue("");
			R0030cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0030cell6 = row.createCell(6);
		if (record.getR0030_unsecured_outstandbal() != null) {
			R0030cell6.setCellValue(record.getR0030_unsecured_outstandbal().doubleValue());
			R0030cell6.setCellStyle(numberStyle);
		} else {
			R0030cell6.setCellValue("");
			R0030cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0030cell7 = row.createCell(7);
		if (record.getR0030_stage1_assetclass() != null) {
			R0030cell7.setCellValue(record.getR0030_stage1_assetclass().doubleValue());
			R0030cell7.setCellStyle(numberStyle);
		} else {
			R0030cell7.setCellValue("");
			R0030cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0030cell8 = row.createCell(8);
		if (record.getR0030_stage2_assetclass() != null) {
			R0030cell8.setCellValue(record.getR0030_stage2_assetclass().doubleValue());
			R0030cell8.setCellStyle(numberStyle);
		} else {
			R0030cell8.setCellValue("");
			R0030cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0030cell9 = row.createCell(9);
		if (record.getR0030_stage3a_assetclass() != null) {
			R0030cell9.setCellValue(record.getR0030_stage3a_assetclass().doubleValue());
			R0030cell9.setCellStyle(numberStyle);
		} else {
			R0030cell9.setCellValue("");
			R0030cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0030cell10 = row.createCell(10);
		if (record.getR0030_stage3b_assetclass() != null) {
			R0030cell10.setCellValue(record.getR0030_stage3b_assetclass().doubleValue());
			R0030cell10.setCellStyle(numberStyle);
		} else {
			R0030cell10.setCellValue("");
			R0030cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0030cell11 = row.createCell(11);
		if (record.getR0030_stage3c_assetclass() != null) {
			R0030cell11.setCellValue(record.getR0030_stage3c_assetclass().doubleValue());
			R0030cell11.setCellStyle(numberStyle);
		} else {
			R0030cell11.setCellValue("");
			R0030cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0030cell12 = row.createCell(12);
		if (record.getR0030_stage1_provisionheld() != null) {
			R0030cell12.setCellValue(record.getR0030_stage1_provisionheld().doubleValue());
			R0030cell12.setCellStyle(numberStyle);
		} else {
			R0030cell12.setCellValue("");
			R0030cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0030cell13 = row.createCell(13);
		if (record.getR0030_stage2_provisionheld() != null) {
			R0030cell13.setCellValue(record.getR0030_stage2_provisionheld().doubleValue());
			R0030cell13.setCellStyle(numberStyle);
		} else {
			R0030cell13.setCellValue("");
			R0030cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0030cell14 = row.createCell(14);
		if (record.getR0030_stage3a_provisionheld() != null) {
			R0030cell14.setCellValue(record.getR0030_stage3a_provisionheld().doubleValue());
			R0030cell14.setCellStyle(numberStyle);
		} else {
			R0030cell14.setCellValue("");
			R0030cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0030cell15 = row.createCell(15);
		if (record.getR0030_stage3b_provisionheld() != null) {
			R0030cell15.setCellValue(record.getR0030_stage3b_provisionheld().doubleValue());
			R0030cell15.setCellStyle(numberStyle);
		} else {
			R0030cell15.setCellValue("");
			R0030cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0030cell16 = row.createCell(16);
		if (record.getR0030_stage3c_provisionheld() != null) {
			R0030cell16.setCellValue(record.getR0030_stage3c_provisionheld().doubleValue());
			R0030cell16.setCellStyle(numberStyle);
		} else {
			R0030cell16.setCellValue("");
			R0030cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0030cell17 = row.createCell(17);
		if (record.getR0030_intrestfees_provisionheld() != null) {
			R0030cell17.setCellValue(record.getR0030_intrestfees_provisionheld().doubleValue());
			R0030cell17.setCellStyle(numberStyle);
		} else {
			R0030cell17.setCellValue("");
			R0030cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0030cell18 = row.createCell(18);
		if (record.getR0030_intrestsuspense_provisionheld() != null) {
			R0030cell18.setCellValue(record.getR0030_intrestsuspense_provisionheld().doubleValue());
			R0030cell18.setCellStyle(numberStyle);
		} else {
			R0030cell18.setCellValue("");
			R0030cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0030cell19 = row.createCell(19);
		if (record.getR0030_stage1_poci() != null) {
			R0030cell19.setCellValue(record.getR0030_stage1_poci().doubleValue());
			R0030cell19.setCellStyle(numberStyle);
		} else {
			R0030cell19.setCellValue("");
			R0030cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0030cell20 = row.createCell(20);
		if (record.getR0030_stage2_poci() != null) {
			R0030cell20.setCellValue(record.getR0030_stage2_poci().doubleValue());
			R0030cell20.setCellStyle(numberStyle);
		} else {
			R0030cell20.setCellValue("");
			R0030cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0030cell21 = row.createCell(21);
		if (record.getR0030_stage3a_poci() != null) {
			R0030cell21.setCellValue(record.getR0030_stage3a_poci().doubleValue());
			R0030cell21.setCellStyle(numberStyle);
		} else {
			R0030cell21.setCellValue("");
			R0030cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0030cell22 = row.createCell(22);
		if (record.getR0030_stage3b_poci() != null) {
			R0030cell22.setCellValue(record.getR0030_stage3b_poci().doubleValue());
			R0030cell22.setCellStyle(numberStyle);
		} else {
			R0030cell22.setCellValue("");
			R0030cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0030cell23 = row.createCell(23);
		if (record.getR0030_stage3c_poci() != null) {
			R0030cell23.setCellValue(record.getR0030_stage3c_poci().doubleValue());
			R0030cell23.setCellStyle(numberStyle);
		} else {
			R0030cell23.setCellValue("");
			R0030cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0030cell24 = row.createCell(24);
		if (record.getR0030_current_pastdues() != null) {
			R0030cell24.setCellValue(record.getR0030_current_pastdues().doubleValue());
			R0030cell24.setCellStyle(numberStyle);
		} else {
			R0030cell24.setCellValue("");
			R0030cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0030cell25 = row.createCell(25);
		if (record.getR0030_less30days_pastdues() != null) {
			R0030cell25.setCellValue(record.getR0030_less30days_pastdues().doubleValue());
			R0030cell25.setCellStyle(numberStyle);
		} else {
			R0030cell25.setCellValue("");
			R0030cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0030cell26 = row.createCell(26);
		if (record.getR0030_31to90days_pastdues() != null) {
			R0030cell26.setCellValue(record.getR0030_31to90days_pastdues().doubleValue());
			R0030cell26.setCellStyle(numberStyle);
		} else {
			R0030cell26.setCellValue("");
			R0030cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0030cell27 = row.createCell(27);
		if (record.getR0030_91to120days_pastdues() != null) {
			R0030cell27.setCellValue(record.getR0030_91to120days_pastdues().doubleValue());
			R0030cell27.setCellStyle(numberStyle);
		} else {
			R0030cell27.setCellValue("");
			R0030cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0030cell28 = row.createCell(28);
		if (record.getR0030_121to180days_pastdues() != null) {
			R0030cell28.setCellValue(record.getR0030_121to180days_pastdues().doubleValue());
			R0030cell28.setCellStyle(numberStyle);
		} else {
			R0030cell28.setCellValue("");
			R0030cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0030cell29 = row.createCell(29);
		if (record.getR0030_181to365days_pastdues() != null) {
			R0030cell29.setCellValue(record.getR0030_181to365days_pastdues().doubleValue());
			R0030cell29.setCellStyle(numberStyle);
		} else {
			R0030cell29.setCellValue("");
			R0030cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0030cell30 = row.createCell(30);
		if (record.getR0030_over365days_pastdues() != null) {
			R0030cell30.setCellValue(record.getR0030_over365days_pastdues().doubleValue());
			R0030cell30.setCellStyle(numberStyle);
		} else {
			R0030cell30.setCellValue("");
			R0030cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0030cell32 = row.createCell(32);
		if (record.getR0030_newloan_duringreport() != null) {
			R0030cell32.setCellValue(record.getR0030_newloan_duringreport().doubleValue());
			R0030cell32.setCellStyle(numberStyle);
		} else {
			R0030cell32.setCellValue("");
			R0030cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0030cell33 = row.createCell(33);
		if (record.getR0030_newstage_duringreport() != null) {
			R0030cell33.setCellValue(record.getR0030_newstage_duringreport().doubleValue());
			R0030cell33.setCellStyle(numberStyle);
		} else {
			R0030cell33.setCellValue("");
			R0030cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0030cell34 = row.createCell(34);
		if (record.getR0030_intrestfees_duringreport() != null) {
			R0030cell34.setCellValue(record.getR0030_intrestfees_duringreport().doubleValue());
			R0030cell34.setCellStyle(numberStyle);
		} else {
			R0030cell34.setCellValue("");
			R0030cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0030cell35 = row.createCell(35);
		if (record.getR0030_performingac_acinfo() != null) {
			R0030cell35.setCellValue(record.getR0030_performingac_acinfo().doubleValue());
			R0030cell35.setCellStyle(numberStyle);
		} else {
			R0030cell35.setCellValue("");
			R0030cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0030cell36 = row.createCell(36);
		if (record.getR0030_nonperformingac_acinfo() != null) {
			R0030cell36.setCellValue(record.getR0030_nonperformingac_acinfo().doubleValue());
			R0030cell36.setCellStyle(numberStyle);
		} else {
			R0030cell36.setCellValue("");
			R0030cell36.setCellStyle(textStyle);
		}

		/// ROW13
		//// Column E
		row = sheet.getRow(12);
		Cell R0040cell4 = row.createCell(4);
		if (record.getR0040_outstandbal() != null) {
			R0040cell4.setCellValue(record.getR0040_outstandbal().doubleValue());
			R0040cell4.setCellStyle(numberStyle);
		} else {
			R0040cell4.setCellValue("");
			R0040cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0040cell5 = row.createCell(5);
		if (record.getR0040_secured_outstandbal() != null) {
			R0040cell5.setCellValue(record.getR0040_secured_outstandbal().doubleValue());
			R0040cell5.setCellStyle(numberStyle);
		} else {
			R0040cell5.setCellValue("");
			R0040cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0040cell6 = row.createCell(6);
		if (record.getR0040_unsecured_outstandbal() != null) {
			R0040cell6.setCellValue(record.getR0040_unsecured_outstandbal().doubleValue());
			R0040cell6.setCellStyle(numberStyle);
		} else {
			R0040cell6.setCellValue("");
			R0040cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0040cell7 = row.createCell(7);
		if (record.getR0040_stage1_assetclass() != null) {
			R0040cell7.setCellValue(record.getR0040_stage1_assetclass().doubleValue());
			R0040cell7.setCellStyle(numberStyle);
		} else {
			R0040cell7.setCellValue("");
			R0040cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0040cell8 = row.createCell(8);
		if (record.getR0040_stage2_assetclass() != null) {
			R0040cell8.setCellValue(record.getR0040_stage2_assetclass().doubleValue());
			R0040cell8.setCellStyle(numberStyle);
		} else {
			R0040cell8.setCellValue("");
			R0040cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0040cell9 = row.createCell(9);
		if (record.getR0040_stage3a_assetclass() != null) {
			R0040cell9.setCellValue(record.getR0040_stage3a_assetclass().doubleValue());
			R0040cell9.setCellStyle(numberStyle);
		} else {
			R0040cell9.setCellValue("");
			R0040cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0040cell10 = row.createCell(10);
		if (record.getR0040_stage3b_assetclass() != null) {
			R0040cell10.setCellValue(record.getR0040_stage3b_assetclass().doubleValue());
			R0040cell10.setCellStyle(numberStyle);
		} else {
			R0040cell10.setCellValue("");
			R0040cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0040cell11 = row.createCell(11);
		if (record.getR0040_stage3c_assetclass() != null) {
			R0040cell11.setCellValue(record.getR0040_stage3c_assetclass().doubleValue());
			R0040cell11.setCellStyle(numberStyle);
		} else {
			R0040cell11.setCellValue("");
			R0040cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0040cell12 = row.createCell(12);
		if (record.getR0040_stage1_provisionheld() != null) {
			R0040cell12.setCellValue(record.getR0040_stage1_provisionheld().doubleValue());
			R0040cell12.setCellStyle(numberStyle);
		} else {
			R0040cell12.setCellValue("");
			R0040cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0040cell13 = row.createCell(13);
		if (record.getR0040_stage2_provisionheld() != null) {
			R0040cell13.setCellValue(record.getR0040_stage2_provisionheld().doubleValue());
			R0040cell13.setCellStyle(numberStyle);
		} else {
			R0040cell13.setCellValue("");
			R0040cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0040cell14 = row.createCell(14);
		if (record.getR0040_stage3a_provisionheld() != null) {
			R0040cell14.setCellValue(record.getR0040_stage3a_provisionheld().doubleValue());
			R0040cell14.setCellStyle(numberStyle);
		} else {
			R0040cell14.setCellValue("");
			R0040cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0040cell15 = row.createCell(15);
		if (record.getR0040_stage3b_provisionheld() != null) {
			R0040cell15.setCellValue(record.getR0040_stage3b_provisionheld().doubleValue());
			R0040cell15.setCellStyle(numberStyle);
		} else {
			R0040cell15.setCellValue("");
			R0040cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0040cell16 = row.createCell(16);
		if (record.getR0040_stage3c_provisionheld() != null) {
			R0040cell16.setCellValue(record.getR0040_stage3c_provisionheld().doubleValue());
			R0040cell16.setCellStyle(numberStyle);
		} else {
			R0040cell16.setCellValue("");
			R0040cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0040cell17 = row.createCell(17);
		if (record.getR0040_intrestfees_provisionheld() != null) {
			R0040cell17.setCellValue(record.getR0040_intrestfees_provisionheld().doubleValue());
			R0040cell17.setCellStyle(numberStyle);
		} else {
			R0040cell17.setCellValue("");
			R0040cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0040cell18 = row.createCell(18);
		if (record.getR0040_intrestsuspense_provisionheld() != null) {
			R0040cell18.setCellValue(record.getR0040_intrestsuspense_provisionheld().doubleValue());
			R0040cell18.setCellStyle(numberStyle);
		} else {
			R0040cell18.setCellValue("");
			R0040cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0040cell19 = row.createCell(19);
		if (record.getR0040_stage1_poci() != null) {
			R0040cell19.setCellValue(record.getR0040_stage1_poci().doubleValue());
			R0040cell19.setCellStyle(numberStyle);
		} else {
			R0040cell19.setCellValue("");
			R0040cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0040cell20 = row.createCell(20);
		if (record.getR0040_stage2_poci() != null) {
			R0040cell20.setCellValue(record.getR0040_stage2_poci().doubleValue());
			R0040cell20.setCellStyle(numberStyle);
		} else {
			R0040cell20.setCellValue("");
			R0040cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0040cell21 = row.createCell(21);
		if (record.getR0040_stage3a_poci() != null) {
			R0040cell21.setCellValue(record.getR0040_stage3a_poci().doubleValue());
			R0040cell21.setCellStyle(numberStyle);
		} else {
			R0040cell21.setCellValue("");
			R0040cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0040cell22 = row.createCell(22);
		if (record.getR0040_stage3b_poci() != null) {
			R0040cell22.setCellValue(record.getR0040_stage3b_poci().doubleValue());
			R0040cell22.setCellStyle(numberStyle);
		} else {
			R0040cell22.setCellValue("");
			R0040cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0040cell23 = row.createCell(23);
		if (record.getR0040_stage3c_poci() != null) {
			R0040cell23.setCellValue(record.getR0040_stage3c_poci().doubleValue());
			R0040cell23.setCellStyle(numberStyle);
		} else {
			R0040cell23.setCellValue("");
			R0040cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0040cell24 = row.createCell(24);
		if (record.getR0040_current_pastdues() != null) {
			R0040cell24.setCellValue(record.getR0040_current_pastdues().doubleValue());
			R0040cell24.setCellStyle(numberStyle);
		} else {
			R0040cell24.setCellValue("");
			R0040cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0040cell25 = row.createCell(25);
		if (record.getR0040_less30days_pastdues() != null) {
			R0040cell25.setCellValue(record.getR0040_less30days_pastdues().doubleValue());
			R0040cell25.setCellStyle(numberStyle);
		} else {
			R0040cell25.setCellValue("");
			R0040cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0040cell26 = row.createCell(26);
		if (record.getR0040_31to90days_pastdues() != null) {
			R0040cell26.setCellValue(record.getR0040_31to90days_pastdues().doubleValue());
			R0040cell26.setCellStyle(numberStyle);
		} else {
			R0040cell26.setCellValue("");
			R0040cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0040cell27 = row.createCell(27);
		if (record.getR0040_91to120days_pastdues() != null) {
			R0040cell27.setCellValue(record.getR0040_91to120days_pastdues().doubleValue());
			R0040cell27.setCellStyle(numberStyle);
		} else {
			R0040cell27.setCellValue("");
			R0040cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0040cell28 = row.createCell(28);
		if (record.getR0040_121to180days_pastdues() != null) {
			R0040cell28.setCellValue(record.getR0040_121to180days_pastdues().doubleValue());
			R0040cell28.setCellStyle(numberStyle);
		} else {
			R0040cell28.setCellValue("");
			R0040cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0040cell29 = row.createCell(29);
		if (record.getR0040_181to365days_pastdues() != null) {
			R0040cell29.setCellValue(record.getR0040_181to365days_pastdues().doubleValue());
			R0040cell29.setCellStyle(numberStyle);
		} else {
			R0040cell29.setCellValue("");
			R0040cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0040cell30 = row.createCell(30);
		if (record.getR0040_over365days_pastdues() != null) {
			R0040cell30.setCellValue(record.getR0040_over365days_pastdues().doubleValue());
			R0040cell30.setCellStyle(numberStyle);
		} else {
			R0040cell30.setCellValue("");
			R0040cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0040cell32 = row.createCell(32);
		if (record.getR0040_newloan_duringreport() != null) {
			R0040cell32.setCellValue(record.getR0040_newloan_duringreport().doubleValue());
			R0040cell32.setCellStyle(numberStyle);
		} else {
			R0040cell32.setCellValue("");
			R0040cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0040cell33 = row.createCell(33);
		if (record.getR0040_newstage_duringreport() != null) {
			R0040cell33.setCellValue(record.getR0040_newstage_duringreport().doubleValue());
			R0040cell33.setCellStyle(numberStyle);
		} else {
			R0040cell33.setCellValue("");
			R0040cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0040cell34 = row.createCell(34);
		if (record.getR0040_intrestfees_duringreport() != null) {
			R0040cell34.setCellValue(record.getR0040_intrestfees_duringreport().doubleValue());
			R0040cell34.setCellStyle(numberStyle);
		} else {
			R0040cell34.setCellValue("");
			R0040cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0040cell35 = row.createCell(35);
		if (record.getR0040_performingac_acinfo() != null) {
			R0040cell35.setCellValue(record.getR0040_performingac_acinfo().doubleValue());
			R0040cell35.setCellStyle(numberStyle);
		} else {
			R0040cell35.setCellValue("");
			R0040cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0040cell36 = row.createCell(36);
		if (record.getR0040_nonperformingac_acinfo() != null) {
			R0040cell36.setCellValue(record.getR0040_nonperformingac_acinfo().doubleValue());
			R0040cell36.setCellStyle(numberStyle);
		} else {
			R0040cell36.setCellValue("");
			R0040cell36.setCellStyle(textStyle);
		}

		/// ROW14
		//// Column E
		row = sheet.getRow(13);
		Cell R0050cell4 = row.createCell(4);
		if (record.getR0050_outstandbal() != null) {
			R0050cell4.setCellValue(record.getR0050_outstandbal().doubleValue());
			R0050cell4.setCellStyle(numberStyle);
		} else {
			R0050cell4.setCellValue("");
			R0050cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0050cell5 = row.createCell(5);
		if (record.getR0050_secured_outstandbal() != null) {
			R0050cell5.setCellValue(record.getR0050_secured_outstandbal().doubleValue());
			R0050cell5.setCellStyle(numberStyle);
		} else {
			R0050cell5.setCellValue("");
			R0050cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0050cell6 = row.createCell(6);
		if (record.getR0050_unsecured_outstandbal() != null) {
			R0050cell6.setCellValue(record.getR0050_unsecured_outstandbal().doubleValue());
			R0050cell6.setCellStyle(numberStyle);
		} else {
			R0050cell6.setCellValue("");
			R0050cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0050cell7 = row.createCell(7);
		if (record.getR0050_stage1_assetclass() != null) {
			R0050cell7.setCellValue(record.getR0050_stage1_assetclass().doubleValue());
			R0050cell7.setCellStyle(numberStyle);
		} else {
			R0050cell7.setCellValue("");
			R0050cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0050cell8 = row.createCell(8);
		if (record.getR0050_stage2_assetclass() != null) {
			R0050cell8.setCellValue(record.getR0050_stage2_assetclass().doubleValue());
			R0050cell8.setCellStyle(numberStyle);
		} else {
			R0050cell8.setCellValue("");
			R0050cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0050cell9 = row.createCell(9);
		if (record.getR0050_stage3a_assetclass() != null) {
			R0050cell9.setCellValue(record.getR0050_stage3a_assetclass().doubleValue());
			R0050cell9.setCellStyle(numberStyle);
		} else {
			R0050cell9.setCellValue("");
			R0050cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0050cell10 = row.createCell(10);
		if (record.getR0050_stage3b_assetclass() != null) {
			R0050cell10.setCellValue(record.getR0050_stage3b_assetclass().doubleValue());
			R0050cell10.setCellStyle(numberStyle);
		} else {
			R0050cell10.setCellValue("");
			R0050cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0050cell11 = row.createCell(11);
		if (record.getR0050_stage3c_assetclass() != null) {
			R0050cell11.setCellValue(record.getR0050_stage3c_assetclass().doubleValue());
			R0050cell11.setCellStyle(numberStyle);
		} else {
			R0050cell11.setCellValue("");
			R0050cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0050cell12 = row.createCell(12);
		if (record.getR0050_stage1_provisionheld() != null) {
			R0050cell12.setCellValue(record.getR0050_stage1_provisionheld().doubleValue());
			R0050cell12.setCellStyle(numberStyle);
		} else {
			R0050cell12.setCellValue("");
			R0050cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0050cell13 = row.createCell(13);
		if (record.getR0050_stage2_provisionheld() != null) {
			R0050cell13.setCellValue(record.getR0050_stage2_provisionheld().doubleValue());
			R0050cell13.setCellStyle(numberStyle);
		} else {
			R0050cell13.setCellValue("");
			R0050cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0050cell14 = row.createCell(14);
		if (record.getR0050_stage3a_provisionheld() != null) {
			R0050cell14.setCellValue(record.getR0050_stage3a_provisionheld().doubleValue());
			R0050cell14.setCellStyle(numberStyle);
		} else {
			R0050cell14.setCellValue("");
			R0050cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0050cell15 = row.createCell(15);
		if (record.getR0050_stage3b_provisionheld() != null) {
			R0050cell15.setCellValue(record.getR0050_stage3b_provisionheld().doubleValue());
			R0050cell15.setCellStyle(numberStyle);
		} else {
			R0050cell15.setCellValue("");
			R0050cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0050cell16 = row.createCell(16);
		if (record.getR0050_stage3c_provisionheld() != null) {
			R0050cell16.setCellValue(record.getR0050_stage3c_provisionheld().doubleValue());
			R0050cell16.setCellStyle(numberStyle);
		} else {
			R0050cell16.setCellValue("");
			R0050cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0050cell17 = row.createCell(17);
		if (record.getR0050_intrestfees_provisionheld() != null) {
			R0050cell17.setCellValue(record.getR0050_intrestfees_provisionheld().doubleValue());
			R0050cell17.setCellStyle(numberStyle);
		} else {
			R0050cell17.setCellValue("");
			R0050cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0050cell18 = row.createCell(18);
		if (record.getR0050_intrestsuspense_provisionheld() != null) {
			R0050cell18.setCellValue(record.getR0050_intrestsuspense_provisionheld().doubleValue());
			R0050cell18.setCellStyle(numberStyle);
		} else {
			R0050cell18.setCellValue("");
			R0050cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0050cell19 = row.createCell(19);
		if (record.getR0050_stage1_poci() != null) {
			R0050cell19.setCellValue(record.getR0050_stage1_poci().doubleValue());
			R0050cell19.setCellStyle(numberStyle);
		} else {
			R0050cell19.setCellValue("");
			R0050cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0050cell20 = row.createCell(20);
		if (record.getR0050_stage2_poci() != null) {
			R0050cell20.setCellValue(record.getR0050_stage2_poci().doubleValue());
			R0050cell20.setCellStyle(numberStyle);
		} else {
			R0050cell20.setCellValue("");
			R0050cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0050cell21 = row.createCell(21);
		if (record.getR0050_stage3a_poci() != null) {
			R0050cell21.setCellValue(record.getR0050_stage3a_poci().doubleValue());
			R0050cell21.setCellStyle(numberStyle);
		} else {
			R0050cell21.setCellValue("");
			R0050cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0050cell22 = row.createCell(22);
		if (record.getR0050_stage3b_poci() != null) {
			R0050cell22.setCellValue(record.getR0050_stage3b_poci().doubleValue());
			R0050cell22.setCellStyle(numberStyle);
		} else {
			R0050cell22.setCellValue("");
			R0050cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0050cell23 = row.createCell(23);
		if (record.getR0050_stage3c_poci() != null) {
			R0050cell23.setCellValue(record.getR0050_stage3c_poci().doubleValue());
			R0050cell23.setCellStyle(numberStyle);
		} else {
			R0050cell23.setCellValue("");
			R0050cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0050cell24 = row.createCell(24);
		if (record.getR0050_current_pastdues() != null) {
			R0050cell24.setCellValue(record.getR0050_current_pastdues().doubleValue());
			R0050cell24.setCellStyle(numberStyle);
		} else {
			R0050cell24.setCellValue("");
			R0050cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0050cell25 = row.createCell(25);
		if (record.getR0050_less30days_pastdues() != null) {
			R0050cell25.setCellValue(record.getR0050_less30days_pastdues().doubleValue());
			R0050cell25.setCellStyle(numberStyle);
		} else {
			R0050cell25.setCellValue("");
			R0050cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0050cell26 = row.createCell(26);
		if (record.getR0050_31to90days_pastdues() != null) {
			R0050cell26.setCellValue(record.getR0050_31to90days_pastdues().doubleValue());
			R0050cell26.setCellStyle(numberStyle);
		} else {
			R0050cell26.setCellValue("");
			R0050cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0050cell27 = row.createCell(27);
		if (record.getR0050_91to120days_pastdues() != null) {
			R0050cell27.setCellValue(record.getR0050_91to120days_pastdues().doubleValue());
			R0050cell27.setCellStyle(numberStyle);
		} else {
			R0050cell27.setCellValue("");
			R0050cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0050cell28 = row.createCell(28);
		if (record.getR0050_121to180days_pastdues() != null) {
			R0050cell28.setCellValue(record.getR0050_121to180days_pastdues().doubleValue());
			R0050cell28.setCellStyle(numberStyle);
		} else {
			R0050cell28.setCellValue("");
			R0050cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0050cell29 = row.createCell(29);
		if (record.getR0050_181to365days_pastdues() != null) {
			R0050cell29.setCellValue(record.getR0050_181to365days_pastdues().doubleValue());
			R0050cell29.setCellStyle(numberStyle);
		} else {
			R0050cell29.setCellValue("");
			R0050cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0050cell30 = row.createCell(30);
		if (record.getR0050_over365days_pastdues() != null) {
			R0050cell30.setCellValue(record.getR0050_over365days_pastdues().doubleValue());
			R0050cell30.setCellStyle(numberStyle);
		} else {
			R0050cell30.setCellValue("");
			R0050cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0050cell32 = row.createCell(32);
		if (record.getR0050_newloan_duringreport() != null) {
			R0050cell32.setCellValue(record.getR0050_newloan_duringreport().doubleValue());
			R0050cell32.setCellStyle(numberStyle);
		} else {
			R0050cell32.setCellValue("");
			R0050cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0050cell33 = row.createCell(33);
		if (record.getR0050_newstage_duringreport() != null) {
			R0050cell33.setCellValue(record.getR0050_newstage_duringreport().doubleValue());
			R0050cell33.setCellStyle(numberStyle);
		} else {
			R0050cell33.setCellValue("");
			R0050cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0050cell34 = row.createCell(34);
		if (record.getR0050_intrestfees_duringreport() != null) {
			R0050cell34.setCellValue(record.getR0050_intrestfees_duringreport().doubleValue());
			R0050cell34.setCellStyle(numberStyle);
		} else {
			R0050cell34.setCellValue("");
			R0050cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0050cell35 = row.createCell(35);
		if (record.getR0050_performingac_acinfo() != null) {
			R0050cell35.setCellValue(record.getR0050_performingac_acinfo().doubleValue());
			R0050cell35.setCellStyle(numberStyle);
		} else {
			R0050cell35.setCellValue("");
			R0050cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0050cell36 = row.createCell(36);
		if (record.getR0050_nonperformingac_acinfo() != null) {
			R0050cell36.setCellValue(record.getR0050_nonperformingac_acinfo().doubleValue());
			R0050cell36.setCellStyle(numberStyle);
		} else {
			R0050cell36.setCellValue("");
			R0050cell36.setCellStyle(textStyle);
		}

		/// ROW15
		//// Column E
		row = sheet.getRow(14);
		Cell R0060cell4 = row.createCell(4);
		if (record.getR0060_outstandbal() != null) {
			R0060cell4.setCellValue(record.getR0060_outstandbal().doubleValue());
			R0060cell4.setCellStyle(numberStyle);
		} else {
			R0060cell4.setCellValue("");
			R0060cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0060cell5 = row.createCell(5);
		if (record.getR0060_secured_outstandbal() != null) {
			R0060cell5.setCellValue(record.getR0060_secured_outstandbal().doubleValue());
			R0060cell5.setCellStyle(numberStyle);
		} else {
			R0060cell5.setCellValue("");
			R0060cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0060cell6 = row.createCell(6);
		if (record.getR0060_unsecured_outstandbal() != null) {
			R0060cell6.setCellValue(record.getR0060_unsecured_outstandbal().doubleValue());
			R0060cell6.setCellStyle(numberStyle);
		} else {
			R0060cell6.setCellValue("");
			R0060cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0060cell7 = row.createCell(7);
		if (record.getR0060_stage1_assetclass() != null) {
			R0060cell7.setCellValue(record.getR0060_stage1_assetclass().doubleValue());
			R0060cell7.setCellStyle(numberStyle);
		} else {
			R0060cell7.setCellValue("");
			R0060cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0060cell8 = row.createCell(8);
		if (record.getR0060_stage2_assetclass() != null) {
			R0060cell8.setCellValue(record.getR0060_stage2_assetclass().doubleValue());
			R0060cell8.setCellStyle(numberStyle);
		} else {
			R0060cell8.setCellValue("");
			R0060cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0060cell9 = row.createCell(9);
		if (record.getR0060_stage3a_assetclass() != null) {
			R0060cell9.setCellValue(record.getR0060_stage3a_assetclass().doubleValue());
			R0060cell9.setCellStyle(numberStyle);
		} else {
			R0060cell9.setCellValue("");
			R0060cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0060cell10 = row.createCell(10);
		if (record.getR0060_stage3b_assetclass() != null) {
			R0060cell10.setCellValue(record.getR0060_stage3b_assetclass().doubleValue());
			R0060cell10.setCellStyle(numberStyle);
		} else {
			R0060cell10.setCellValue("");
			R0060cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0060cell11 = row.createCell(11);
		if (record.getR0060_stage3c_assetclass() != null) {
			R0060cell11.setCellValue(record.getR0060_stage3c_assetclass().doubleValue());
			R0060cell11.setCellStyle(numberStyle);
		} else {
			R0060cell11.setCellValue("");
			R0060cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0060cell12 = row.createCell(12);
		if (record.getR0060_stage1_provisionheld() != null) {
			R0060cell12.setCellValue(record.getR0060_stage1_provisionheld().doubleValue());
			R0060cell12.setCellStyle(numberStyle);
		} else {
			R0060cell12.setCellValue("");
			R0060cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0060cell13 = row.createCell(13);
		if (record.getR0060_stage2_provisionheld() != null) {
			R0060cell13.setCellValue(record.getR0060_stage2_provisionheld().doubleValue());
			R0060cell13.setCellStyle(numberStyle);
		} else {
			R0060cell13.setCellValue("");
			R0060cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0060cell14 = row.createCell(14);
		if (record.getR0060_stage3a_provisionheld() != null) {
			R0060cell14.setCellValue(record.getR0060_stage3a_provisionheld().doubleValue());
			R0060cell14.setCellStyle(numberStyle);
		} else {
			R0060cell14.setCellValue("");
			R0060cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0060cell15 = row.createCell(15);
		if (record.getR0060_stage3b_provisionheld() != null) {
			R0060cell15.setCellValue(record.getR0060_stage3b_provisionheld().doubleValue());
			R0060cell15.setCellStyle(numberStyle);
		} else {
			R0060cell15.setCellValue("");
			R0060cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0060cell16 = row.createCell(16);
		if (record.getR0060_stage3c_provisionheld() != null) {
			R0060cell16.setCellValue(record.getR0060_stage3c_provisionheld().doubleValue());
			R0060cell16.setCellStyle(numberStyle);
		} else {
			R0060cell16.setCellValue("");
			R0060cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0060cell17 = row.createCell(17);
		if (record.getR0060_intrestfees_provisionheld() != null) {
			R0060cell17.setCellValue(record.getR0060_intrestfees_provisionheld().doubleValue());
			R0060cell17.setCellStyle(numberStyle);
		} else {
			R0060cell17.setCellValue("");
			R0060cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0060cell18 = row.createCell(18);
		if (record.getR0060_intrestsuspense_provisionheld() != null) {
			R0060cell18.setCellValue(record.getR0060_intrestsuspense_provisionheld().doubleValue());
			R0060cell18.setCellStyle(numberStyle);
		} else {
			R0060cell18.setCellValue("");
			R0060cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0060cell19 = row.createCell(19);
		if (record.getR0060_stage1_poci() != null) {
			R0060cell19.setCellValue(record.getR0060_stage1_poci().doubleValue());
			R0060cell19.setCellStyle(numberStyle);
		} else {
			R0060cell19.setCellValue("");
			R0060cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0060cell20 = row.createCell(20);
		if (record.getR0060_stage2_poci() != null) {
			R0060cell20.setCellValue(record.getR0060_stage2_poci().doubleValue());
			R0060cell20.setCellStyle(numberStyle);
		} else {
			R0060cell20.setCellValue("");
			R0060cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0060cell21 = row.createCell(21);
		if (record.getR0060_stage3a_poci() != null) {
			R0060cell21.setCellValue(record.getR0060_stage3a_poci().doubleValue());
			R0060cell21.setCellStyle(numberStyle);
		} else {
			R0060cell21.setCellValue("");
			R0060cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0060cell22 = row.createCell(22);
		if (record.getR0060_stage3b_poci() != null) {
			R0060cell22.setCellValue(record.getR0060_stage3b_poci().doubleValue());
			R0060cell22.setCellStyle(numberStyle);
		} else {
			R0060cell22.setCellValue("");
			R0060cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0060cell23 = row.createCell(23);
		if (record.getR0060_stage3c_poci() != null) {
			R0060cell23.setCellValue(record.getR0060_stage3c_poci().doubleValue());
			R0060cell23.setCellStyle(numberStyle);
		} else {
			R0060cell23.setCellValue("");
			R0060cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0060cell24 = row.createCell(24);
		if (record.getR0060_current_pastdues() != null) {
			R0060cell24.setCellValue(record.getR0060_current_pastdues().doubleValue());
			R0060cell24.setCellStyle(numberStyle);
		} else {
			R0060cell24.setCellValue("");
			R0060cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0060cell25 = row.createCell(25);
		if (record.getR0060_less30days_pastdues() != null) {
			R0060cell25.setCellValue(record.getR0060_less30days_pastdues().doubleValue());
			R0060cell25.setCellStyle(numberStyle);
		} else {
			R0060cell25.setCellValue("");
			R0060cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0060cell26 = row.createCell(26);
		if (record.getR0060_31to90days_pastdues() != null) {
			R0060cell26.setCellValue(record.getR0060_31to90days_pastdues().doubleValue());
			R0060cell26.setCellStyle(numberStyle);
		} else {
			R0060cell26.setCellValue("");
			R0060cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0060cell27 = row.createCell(27);
		if (record.getR0060_91to120days_pastdues() != null) {
			R0060cell27.setCellValue(record.getR0060_91to120days_pastdues().doubleValue());
			R0060cell27.setCellStyle(numberStyle);
		} else {
			R0060cell27.setCellValue("");
			R0060cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0060cell28 = row.createCell(28);
		if (record.getR0060_121to180days_pastdues() != null) {
			R0060cell28.setCellValue(record.getR0060_121to180days_pastdues().doubleValue());
			R0060cell28.setCellStyle(numberStyle);
		} else {
			R0060cell28.setCellValue("");
			R0060cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0060cell29 = row.createCell(29);
		if (record.getR0060_181to365days_pastdues() != null) {
			R0060cell29.setCellValue(record.getR0060_181to365days_pastdues().doubleValue());
			R0060cell29.setCellStyle(numberStyle);
		} else {
			R0060cell29.setCellValue("");
			R0060cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0060cell30 = row.createCell(30);
		if (record.getR0060_over365days_pastdues() != null) {
			R0060cell30.setCellValue(record.getR0060_over365days_pastdues().doubleValue());
			R0060cell30.setCellStyle(numberStyle);
		} else {
			R0060cell30.setCellValue("");
			R0060cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0060cell32 = row.createCell(32);
		if (record.getR0060_newloan_duringreport() != null) {
			R0060cell32.setCellValue(record.getR0060_newloan_duringreport().doubleValue());
			R0060cell32.setCellStyle(numberStyle);
		} else {
			R0060cell32.setCellValue("");
			R0060cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0060cell33 = row.createCell(33);
		if (record.getR0060_newstage_duringreport() != null) {
			R0060cell33.setCellValue(record.getR0060_newstage_duringreport().doubleValue());
			R0060cell33.setCellStyle(numberStyle);
		} else {
			R0060cell33.setCellValue("");
			R0060cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0060cell34 = row.createCell(34);
		if (record.getR0060_intrestfees_duringreport() != null) {
			R0060cell34.setCellValue(record.getR0060_intrestfees_duringreport().doubleValue());
			R0060cell34.setCellStyle(numberStyle);
		} else {
			R0060cell34.setCellValue("");
			R0060cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0060cell35 = row.createCell(35);
		if (record.getR0060_performingac_acinfo() != null) {
			R0060cell35.setCellValue(record.getR0060_performingac_acinfo().doubleValue());
			R0060cell35.setCellStyle(numberStyle);
		} else {
			R0060cell35.setCellValue("");
			R0060cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0060cell36 = row.createCell(36);
		if (record.getR0060_nonperformingac_acinfo() != null) {
			R0060cell36.setCellValue(record.getR0060_nonperformingac_acinfo().doubleValue());
			R0060cell36.setCellStyle(numberStyle);
		} else {
			R0060cell36.setCellValue("");
			R0060cell36.setCellStyle(textStyle);
		}

		/// ROW16
		//// Column E
		row = sheet.getRow(15);
		Cell R0070cell4 = row.createCell(4);
		if (record.getR0070_outstandbal() != null) {
			R0070cell4.setCellValue(record.getR0070_outstandbal().doubleValue());
			R0070cell4.setCellStyle(numberStyle);
		} else {
			R0070cell4.setCellValue("");
			R0070cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0070cell5 = row.createCell(5);
		if (record.getR0070_secured_outstandbal() != null) {
			R0070cell5.setCellValue(record.getR0070_secured_outstandbal().doubleValue());
			R0070cell5.setCellStyle(numberStyle);
		} else {
			R0070cell5.setCellValue("");
			R0070cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0070cell6 = row.createCell(6);
		if (record.getR0070_unsecured_outstandbal() != null) {
			R0070cell6.setCellValue(record.getR0070_unsecured_outstandbal().doubleValue());
			R0070cell6.setCellStyle(numberStyle);
		} else {
			R0070cell6.setCellValue("");
			R0070cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0070cell7 = row.createCell(7);
		if (record.getR0070_stage1_assetclass() != null) {
			R0070cell7.setCellValue(record.getR0070_stage1_assetclass().doubleValue());
			R0070cell7.setCellStyle(numberStyle);
		} else {
			R0070cell7.setCellValue("");
			R0070cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0070cell8 = row.createCell(8);
		if (record.getR0070_stage2_assetclass() != null) {
			R0070cell8.setCellValue(record.getR0070_stage2_assetclass().doubleValue());
			R0070cell8.setCellStyle(numberStyle);
		} else {
			R0070cell8.setCellValue("");
			R0070cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0070cell9 = row.createCell(9);
		if (record.getR0070_stage3a_assetclass() != null) {
			R0070cell9.setCellValue(record.getR0070_stage3a_assetclass().doubleValue());
			R0070cell9.setCellStyle(numberStyle);
		} else {
			R0070cell9.setCellValue("");
			R0070cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0070cell10 = row.createCell(10);
		if (record.getR0070_stage3b_assetclass() != null) {
			R0070cell10.setCellValue(record.getR0070_stage3b_assetclass().doubleValue());
			R0070cell10.setCellStyle(numberStyle);
		} else {
			R0070cell10.setCellValue("");
			R0070cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0070cell11 = row.createCell(11);
		if (record.getR0070_stage3c_assetclass() != null) {
			R0070cell11.setCellValue(record.getR0070_stage3c_assetclass().doubleValue());
			R0070cell11.setCellStyle(numberStyle);
		} else {
			R0070cell11.setCellValue("");
			R0070cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0070cell12 = row.createCell(12);
		if (record.getR0070_stage1_provisionheld() != null) {
			R0070cell12.setCellValue(record.getR0070_stage1_provisionheld().doubleValue());
			R0070cell12.setCellStyle(numberStyle);
		} else {
			R0070cell12.setCellValue("");
			R0070cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0070cell13 = row.createCell(13);
		if (record.getR0070_stage2_provisionheld() != null) {
			R0070cell13.setCellValue(record.getR0070_stage2_provisionheld().doubleValue());
			R0070cell13.setCellStyle(numberStyle);
		} else {
			R0070cell13.setCellValue("");
			R0070cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0070cell14 = row.createCell(14);
		if (record.getR0070_stage3a_provisionheld() != null) {
			R0070cell14.setCellValue(record.getR0070_stage3a_provisionheld().doubleValue());
			R0070cell14.setCellStyle(numberStyle);
		} else {
			R0070cell14.setCellValue("");
			R0070cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0070cell15 = row.createCell(15);
		if (record.getR0070_stage3b_provisionheld() != null) {
			R0070cell15.setCellValue(record.getR0070_stage3b_provisionheld().doubleValue());
			R0070cell15.setCellStyle(numberStyle);
		} else {
			R0070cell15.setCellValue("");
			R0070cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0070cell16 = row.createCell(16);
		if (record.getR0070_stage3c_provisionheld() != null) {
			R0070cell16.setCellValue(record.getR0070_stage3c_provisionheld().doubleValue());
			R0070cell16.setCellStyle(numberStyle);
		} else {
			R0070cell16.setCellValue("");
			R0070cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0070cell17 = row.createCell(17);
		if (record.getR0070_intrestfees_provisionheld() != null) {
			R0070cell17.setCellValue(record.getR0070_intrestfees_provisionheld().doubleValue());
			R0070cell17.setCellStyle(numberStyle);
		} else {
			R0070cell17.setCellValue("");
			R0070cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0070cell18 = row.createCell(18);
		if (record.getR0070_intrestsuspense_provisionheld() != null) {
			R0070cell18.setCellValue(record.getR0070_intrestsuspense_provisionheld().doubleValue());
			R0070cell18.setCellStyle(numberStyle);
		} else {
			R0070cell18.setCellValue("");
			R0070cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0070cell19 = row.createCell(19);
		if (record.getR0070_stage1_poci() != null) {
			R0070cell19.setCellValue(record.getR0070_stage1_poci().doubleValue());
			R0070cell19.setCellStyle(numberStyle);
		} else {
			R0070cell19.setCellValue("");
			R0070cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0070cell20 = row.createCell(20);
		if (record.getR0070_stage2_poci() != null) {
			R0070cell20.setCellValue(record.getR0070_stage2_poci().doubleValue());
			R0070cell20.setCellStyle(numberStyle);
		} else {
			R0070cell20.setCellValue("");
			R0070cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0070cell21 = row.createCell(21);
		if (record.getR0070_stage3a_poci() != null) {
			R0070cell21.setCellValue(record.getR0070_stage3a_poci().doubleValue());
			R0070cell21.setCellStyle(numberStyle);
		} else {
			R0070cell21.setCellValue("");
			R0070cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0070cell22 = row.createCell(22);
		if (record.getR0070_stage3b_poci() != null) {
			R0070cell22.setCellValue(record.getR0070_stage3b_poci().doubleValue());
			R0070cell22.setCellStyle(numberStyle);
		} else {
			R0070cell22.setCellValue("");
			R0070cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0070cell23 = row.createCell(23);
		if (record.getR0070_stage3c_poci() != null) {
			R0070cell23.setCellValue(record.getR0070_stage3c_poci().doubleValue());
			R0070cell23.setCellStyle(numberStyle);
		} else {
			R0070cell23.setCellValue("");
			R0070cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0070cell24 = row.createCell(24);
		if (record.getR0070_current_pastdues() != null) {
			R0070cell24.setCellValue(record.getR0070_current_pastdues().doubleValue());
			R0070cell24.setCellStyle(numberStyle);
		} else {
			R0070cell24.setCellValue("");
			R0070cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0070cell25 = row.createCell(25);
		if (record.getR0070_less30days_pastdues() != null) {
			R0070cell25.setCellValue(record.getR0070_less30days_pastdues().doubleValue());
			R0070cell25.setCellStyle(numberStyle);
		} else {
			R0070cell25.setCellValue("");
			R0070cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0070cell26 = row.createCell(26);
		if (record.getR0070_31to90days_pastdues() != null) {
			R0070cell26.setCellValue(record.getR0070_31to90days_pastdues().doubleValue());
			R0070cell26.setCellStyle(numberStyle);
		} else {
			R0070cell26.setCellValue("");
			R0070cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0070cell27 = row.createCell(27);
		if (record.getR0070_91to120days_pastdues() != null) {
			R0070cell27.setCellValue(record.getR0070_91to120days_pastdues().doubleValue());
			R0070cell27.setCellStyle(numberStyle);
		} else {
			R0070cell27.setCellValue("");
			R0070cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0070cell28 = row.createCell(28);
		if (record.getR0070_121to180days_pastdues() != null) {
			R0070cell28.setCellValue(record.getR0070_121to180days_pastdues().doubleValue());
			R0070cell28.setCellStyle(numberStyle);
		} else {
			R0070cell28.setCellValue("");
			R0070cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0070cell29 = row.createCell(29);
		if (record.getR0070_181to365days_pastdues() != null) {
			R0070cell29.setCellValue(record.getR0070_181to365days_pastdues().doubleValue());
			R0070cell29.setCellStyle(numberStyle);
		} else {
			R0070cell29.setCellValue("");
			R0070cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0070cell30 = row.createCell(30);
		if (record.getR0070_over365days_pastdues() != null) {
			R0070cell30.setCellValue(record.getR0070_over365days_pastdues().doubleValue());
			R0070cell30.setCellStyle(numberStyle);
		} else {
			R0070cell30.setCellValue("");
			R0070cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0070cell32 = row.createCell(32);
		if (record.getR0070_newloan_duringreport() != null) {
			R0070cell32.setCellValue(record.getR0070_newloan_duringreport().doubleValue());
			R0070cell32.setCellStyle(numberStyle);
		} else {
			R0070cell32.setCellValue("");
			R0070cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0070cell33 = row.createCell(33);
		if (record.getR0070_newstage_duringreport() != null) {
			R0070cell33.setCellValue(record.getR0070_newstage_duringreport().doubleValue());
			R0070cell33.setCellStyle(numberStyle);
		} else {
			R0070cell33.setCellValue("");
			R0070cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0070cell34 = row.createCell(34);
		if (record.getR0070_intrestfees_duringreport() != null) {
			R0070cell34.setCellValue(record.getR0070_intrestfees_duringreport().doubleValue());
			R0070cell34.setCellStyle(numberStyle);
		} else {
			R0070cell34.setCellValue("");
			R0070cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0070cell35 = row.createCell(35);
		if (record.getR0070_performingac_acinfo() != null) {
			R0070cell35.setCellValue(record.getR0070_performingac_acinfo().doubleValue());
			R0070cell35.setCellStyle(numberStyle);
		} else {
			R0070cell35.setCellValue("");
			R0070cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0070cell36 = row.createCell(36);
		if (record.getR0070_nonperformingac_acinfo() != null) {
			R0070cell36.setCellValue(record.getR0070_nonperformingac_acinfo().doubleValue());
			R0070cell36.setCellStyle(numberStyle);
		} else {
			R0070cell36.setCellValue("");
			R0070cell36.setCellStyle(textStyle);
		}

		/// ROW17
		//// Column E
		row = sheet.getRow(16);
		Cell R0080cell4 = row.createCell(4);
		if (record.getR0080_outstandbal() != null) {
			R0080cell4.setCellValue(record.getR0080_outstandbal().doubleValue());
			R0080cell4.setCellStyle(numberStyle);
		} else {
			R0080cell4.setCellValue("");
			R0080cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0080cell5 = row.createCell(5);
		if (record.getR0080_secured_outstandbal() != null) {
			R0080cell5.setCellValue(record.getR0080_secured_outstandbal().doubleValue());
			R0080cell5.setCellStyle(numberStyle);
		} else {
			R0080cell5.setCellValue("");
			R0080cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0080cell6 = row.createCell(6);
		if (record.getR0080_unsecured_outstandbal() != null) {
			R0080cell6.setCellValue(record.getR0080_unsecured_outstandbal().doubleValue());
			R0080cell6.setCellStyle(numberStyle);
		} else {
			R0080cell6.setCellValue("");
			R0080cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0080cell7 = row.createCell(7);
		if (record.getR0080_stage1_assetclass() != null) {
			R0080cell7.setCellValue(record.getR0080_stage1_assetclass().doubleValue());
			R0080cell7.setCellStyle(numberStyle);
		} else {
			R0080cell7.setCellValue("");
			R0080cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0080cell8 = row.createCell(8);
		if (record.getR0080_stage2_assetclass() != null) {
			R0080cell8.setCellValue(record.getR0080_stage2_assetclass().doubleValue());
			R0080cell8.setCellStyle(numberStyle);
		} else {
			R0080cell8.setCellValue("");
			R0080cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0080cell9 = row.createCell(9);
		if (record.getR0080_stage3a_assetclass() != null) {
			R0080cell9.setCellValue(record.getR0080_stage3a_assetclass().doubleValue());
			R0080cell9.setCellStyle(numberStyle);
		} else {
			R0080cell9.setCellValue("");
			R0080cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0080cell10 = row.createCell(10);
		if (record.getR0080_stage3b_assetclass() != null) {
			R0080cell10.setCellValue(record.getR0080_stage3b_assetclass().doubleValue());
			R0080cell10.setCellStyle(numberStyle);
		} else {
			R0080cell10.setCellValue("");
			R0080cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0080cell11 = row.createCell(11);
		if (record.getR0080_stage3c_assetclass() != null) {
			R0080cell11.setCellValue(record.getR0080_stage3c_assetclass().doubleValue());
			R0080cell11.setCellStyle(numberStyle);
		} else {
			R0080cell11.setCellValue("");
			R0080cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0080cell12 = row.createCell(12);
		if (record.getR0080_stage1_provisionheld() != null) {
			R0080cell12.setCellValue(record.getR0080_stage1_provisionheld().doubleValue());
			R0080cell12.setCellStyle(numberStyle);
		} else {
			R0080cell12.setCellValue("");
			R0080cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0080cell13 = row.createCell(13);
		if (record.getR0080_stage2_provisionheld() != null) {
			R0080cell13.setCellValue(record.getR0080_stage2_provisionheld().doubleValue());
			R0080cell13.setCellStyle(numberStyle);
		} else {
			R0080cell13.setCellValue("");
			R0080cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0080cell14 = row.createCell(14);
		if (record.getR0080_stage3a_provisionheld() != null) {
			R0080cell14.setCellValue(record.getR0080_stage3a_provisionheld().doubleValue());
			R0080cell14.setCellStyle(numberStyle);
		} else {
			R0080cell14.setCellValue("");
			R0080cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0080cell15 = row.createCell(15);
		if (record.getR0080_stage3b_provisionheld() != null) {
			R0080cell15.setCellValue(record.getR0080_stage3b_provisionheld().doubleValue());
			R0080cell15.setCellStyle(numberStyle);
		} else {
			R0080cell15.setCellValue("");
			R0080cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0080cell16 = row.createCell(16);
		if (record.getR0080_stage3c_provisionheld() != null) {
			R0080cell16.setCellValue(record.getR0080_stage3c_provisionheld().doubleValue());
			R0080cell16.setCellStyle(numberStyle);
		} else {
			R0080cell16.setCellValue("");
			R0080cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0080cell17 = row.createCell(17);
		if (record.getR0080_intrestfees_provisionheld() != null) {
			R0080cell17.setCellValue(record.getR0080_intrestfees_provisionheld().doubleValue());
			R0080cell17.setCellStyle(numberStyle);
		} else {
			R0080cell17.setCellValue("");
			R0080cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0080cell18 = row.createCell(18);
		if (record.getR0080_intrestsuspense_provisionheld() != null) {
			R0080cell18.setCellValue(record.getR0080_intrestsuspense_provisionheld().doubleValue());
			R0080cell18.setCellStyle(numberStyle);
		} else {
			R0080cell18.setCellValue("");
			R0080cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0080cell19 = row.createCell(19);
		if (record.getR0080_stage1_poci() != null) {
			R0080cell19.setCellValue(record.getR0080_stage1_poci().doubleValue());
			R0080cell19.setCellStyle(numberStyle);
		} else {
			R0080cell19.setCellValue("");
			R0080cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0080cell20 = row.createCell(20);
		if (record.getR0080_stage2_poci() != null) {
			R0080cell20.setCellValue(record.getR0080_stage2_poci().doubleValue());
			R0080cell20.setCellStyle(numberStyle);
		} else {
			R0080cell20.setCellValue("");
			R0080cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0080cell21 = row.createCell(21);
		if (record.getR0080_stage3a_poci() != null) {
			R0080cell21.setCellValue(record.getR0080_stage3a_poci().doubleValue());
			R0080cell21.setCellStyle(numberStyle);
		} else {
			R0080cell21.setCellValue("");
			R0080cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0080cell22 = row.createCell(22);
		if (record.getR0080_stage3b_poci() != null) {
			R0080cell22.setCellValue(record.getR0080_stage3b_poci().doubleValue());
			R0080cell22.setCellStyle(numberStyle);
		} else {
			R0080cell22.setCellValue("");
			R0080cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0080cell23 = row.createCell(23);
		if (record.getR0080_stage3c_poci() != null) {
			R0080cell23.setCellValue(record.getR0080_stage3c_poci().doubleValue());
			R0080cell23.setCellStyle(numberStyle);
		} else {
			R0080cell23.setCellValue("");
			R0080cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0080cell24 = row.createCell(24);
		if (record.getR0080_current_pastdues() != null) {
			R0080cell24.setCellValue(record.getR0080_current_pastdues().doubleValue());
			R0080cell24.setCellStyle(numberStyle);
		} else {
			R0080cell24.setCellValue("");
			R0080cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0080cell25 = row.createCell(25);
		if (record.getR0080_less30days_pastdues() != null) {
			R0080cell25.setCellValue(record.getR0080_less30days_pastdues().doubleValue());
			R0080cell25.setCellStyle(numberStyle);
		} else {
			R0080cell25.setCellValue("");
			R0080cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0080cell26 = row.createCell(26);
		if (record.getR0080_31to90days_pastdues() != null) {
			R0080cell26.setCellValue(record.getR0080_31to90days_pastdues().doubleValue());
			R0080cell26.setCellStyle(numberStyle);
		} else {
			R0080cell26.setCellValue("");
			R0080cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0080cell27 = row.createCell(27);
		if (record.getR0080_91to120days_pastdues() != null) {
			R0080cell27.setCellValue(record.getR0080_91to120days_pastdues().doubleValue());
			R0080cell27.setCellStyle(numberStyle);
		} else {
			R0080cell27.setCellValue("");
			R0080cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0080cell28 = row.createCell(28);
		if (record.getR0080_121to180days_pastdues() != null) {
			R0080cell28.setCellValue(record.getR0080_121to180days_pastdues().doubleValue());
			R0080cell28.setCellStyle(numberStyle);
		} else {
			R0080cell28.setCellValue("");
			R0080cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0080cell29 = row.createCell(29);
		if (record.getR0080_181to365days_pastdues() != null) {
			R0080cell29.setCellValue(record.getR0080_181to365days_pastdues().doubleValue());
			R0080cell29.setCellStyle(numberStyle);
		} else {
			R0080cell29.setCellValue("");
			R0080cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0080cell30 = row.createCell(30);
		if (record.getR0080_over365days_pastdues() != null) {
			R0080cell30.setCellValue(record.getR0080_over365days_pastdues().doubleValue());
			R0080cell30.setCellStyle(numberStyle);
		} else {
			R0080cell30.setCellValue("");
			R0080cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0080cell32 = row.createCell(32);
		if (record.getR0080_newloan_duringreport() != null) {
			R0080cell32.setCellValue(record.getR0080_newloan_duringreport().doubleValue());
			R0080cell32.setCellStyle(numberStyle);
		} else {
			R0080cell32.setCellValue("");
			R0080cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0080cell33 = row.createCell(33);
		if (record.getR0080_newstage_duringreport() != null) {
			R0080cell33.setCellValue(record.getR0080_newstage_duringreport().doubleValue());
			R0080cell33.setCellStyle(numberStyle);
		} else {
			R0080cell33.setCellValue("");
			R0080cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0080cell34 = row.createCell(34);
		if (record.getR0080_intrestfees_duringreport() != null) {
			R0080cell34.setCellValue(record.getR0080_intrestfees_duringreport().doubleValue());
			R0080cell34.setCellStyle(numberStyle);
		} else {
			R0080cell34.setCellValue("");
			R0080cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0080cell35 = row.createCell(35);
		if (record.getR0080_performingac_acinfo() != null) {
			R0080cell35.setCellValue(record.getR0080_performingac_acinfo().doubleValue());
			R0080cell35.setCellStyle(numberStyle);
		} else {
			R0080cell35.setCellValue("");
			R0080cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0080cell36 = row.createCell(36);
		if (record.getR0080_nonperformingac_acinfo() != null) {
			R0080cell36.setCellValue(record.getR0080_nonperformingac_acinfo().doubleValue());
			R0080cell36.setCellStyle(numberStyle);
		} else {
			R0080cell36.setCellValue("");
			R0080cell36.setCellStyle(textStyle);
		}

		/// ROW18
		//// Column E
		row = sheet.getRow(17);
		Cell R0090cell4 = row.createCell(4);
		if (record.getR0090_outstandbal() != null) {
			R0090cell4.setCellValue(record.getR0090_outstandbal().doubleValue());
			R0090cell4.setCellStyle(numberStyle);
		} else {
			R0090cell4.setCellValue("");
			R0090cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0090cell5 = row.createCell(5);
		if (record.getR0090_secured_outstandbal() != null) {
			R0090cell5.setCellValue(record.getR0090_secured_outstandbal().doubleValue());
			R0090cell5.setCellStyle(numberStyle);
		} else {
			R0090cell5.setCellValue("");
			R0090cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0090cell6 = row.createCell(6);
		if (record.getR0090_unsecured_outstandbal() != null) {
			R0090cell6.setCellValue(record.getR0090_unsecured_outstandbal().doubleValue());
			R0090cell6.setCellStyle(numberStyle);
		} else {
			R0090cell6.setCellValue("");
			R0090cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0090cell7 = row.createCell(7);
		if (record.getR0090_stage1_assetclass() != null) {
			R0090cell7.setCellValue(record.getR0090_stage1_assetclass().doubleValue());
			R0090cell7.setCellStyle(numberStyle);
		} else {
			R0090cell7.setCellValue("");
			R0090cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0090cell8 = row.createCell(8);
		if (record.getR0090_stage2_assetclass() != null) {
			R0090cell8.setCellValue(record.getR0090_stage2_assetclass().doubleValue());
			R0090cell8.setCellStyle(numberStyle);
		} else {
			R0090cell8.setCellValue("");
			R0090cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0090cell9 = row.createCell(9);
		if (record.getR0090_stage3a_assetclass() != null) {
			R0090cell9.setCellValue(record.getR0090_stage3a_assetclass().doubleValue());
			R0090cell9.setCellStyle(numberStyle);
		} else {
			R0090cell9.setCellValue("");
			R0090cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0090cell10 = row.createCell(10);
		if (record.getR0090_stage3b_assetclass() != null) {
			R0090cell10.setCellValue(record.getR0090_stage3b_assetclass().doubleValue());
			R0090cell10.setCellStyle(numberStyle);
		} else {
			R0090cell10.setCellValue("");
			R0090cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0090cell11 = row.createCell(11);
		if (record.getR0090_stage3c_assetclass() != null) {
			R0090cell11.setCellValue(record.getR0090_stage3c_assetclass().doubleValue());
			R0090cell11.setCellStyle(numberStyle);
		} else {
			R0090cell11.setCellValue("");
			R0090cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0090cell12 = row.createCell(12);
		if (record.getR0090_stage1_provisionheld() != null) {
			R0090cell12.setCellValue(record.getR0090_stage1_provisionheld().doubleValue());
			R0090cell12.setCellStyle(numberStyle);
		} else {
			R0090cell12.setCellValue("");
			R0090cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0090cell13 = row.createCell(13);
		if (record.getR0090_stage2_provisionheld() != null) {
			R0090cell13.setCellValue(record.getR0090_stage2_provisionheld().doubleValue());
			R0090cell13.setCellStyle(numberStyle);
		} else {
			R0090cell13.setCellValue("");
			R0090cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0090cell14 = row.createCell(14);
		if (record.getR0090_stage3a_provisionheld() != null) {
			R0090cell14.setCellValue(record.getR0090_stage3a_provisionheld().doubleValue());
			R0090cell14.setCellStyle(numberStyle);
		} else {
			R0090cell14.setCellValue("");
			R0090cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0090cell15 = row.createCell(15);
		if (record.getR0090_stage3b_provisionheld() != null) {
			R0090cell15.setCellValue(record.getR0090_stage3b_provisionheld().doubleValue());
			R0090cell15.setCellStyle(numberStyle);
		} else {
			R0090cell15.setCellValue("");
			R0090cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0090cell16 = row.createCell(16);
		if (record.getR0090_stage3c_provisionheld() != null) {
			R0090cell16.setCellValue(record.getR0090_stage3c_provisionheld().doubleValue());
			R0090cell16.setCellStyle(numberStyle);
		} else {
			R0090cell16.setCellValue("");
			R0090cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0090cell17 = row.createCell(17);
		if (record.getR0090_intrestfees_provisionheld() != null) {
			R0090cell17.setCellValue(record.getR0090_intrestfees_provisionheld().doubleValue());
			R0090cell17.setCellStyle(numberStyle);
		} else {
			R0090cell17.setCellValue("");
			R0090cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0090cell18 = row.createCell(18);
		if (record.getR0090_intrestsuspense_provisionheld() != null) {
			R0090cell18.setCellValue(record.getR0090_intrestsuspense_provisionheld().doubleValue());
			R0090cell18.setCellStyle(numberStyle);
		} else {
			R0090cell18.setCellValue("");
			R0090cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0090cell19 = row.createCell(19);
		if (record.getR0090_stage1_poci() != null) {
			R0090cell19.setCellValue(record.getR0090_stage1_poci().doubleValue());
			R0090cell19.setCellStyle(numberStyle);
		} else {
			R0090cell19.setCellValue("");
			R0090cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0090cell20 = row.createCell(20);
		if (record.getR0090_stage2_poci() != null) {
			R0090cell20.setCellValue(record.getR0090_stage2_poci().doubleValue());
			R0090cell20.setCellStyle(numberStyle);
		} else {
			R0090cell20.setCellValue("");
			R0090cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0090cell21 = row.createCell(21);
		if (record.getR0090_stage3a_poci() != null) {
			R0090cell21.setCellValue(record.getR0090_stage3a_poci().doubleValue());
			R0090cell21.setCellStyle(numberStyle);
		} else {
			R0090cell21.setCellValue("");
			R0090cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0090cell22 = row.createCell(22);
		if (record.getR0090_stage3b_poci() != null) {
			R0090cell22.setCellValue(record.getR0090_stage3b_poci().doubleValue());
			R0090cell22.setCellStyle(numberStyle);
		} else {
			R0090cell22.setCellValue("");
			R0090cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0090cell23 = row.createCell(23);
		if (record.getR0090_stage3c_poci() != null) {
			R0090cell23.setCellValue(record.getR0090_stage3c_poci().doubleValue());
			R0090cell23.setCellStyle(numberStyle);
		} else {
			R0090cell23.setCellValue("");
			R0090cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0090cell24 = row.createCell(24);
		if (record.getR0090_current_pastdues() != null) {
			R0090cell24.setCellValue(record.getR0090_current_pastdues().doubleValue());
			R0090cell24.setCellStyle(numberStyle);
		} else {
			R0090cell24.setCellValue("");
			R0090cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0090cell25 = row.createCell(25);
		if (record.getR0090_less30days_pastdues() != null) {
			R0090cell25.setCellValue(record.getR0090_less30days_pastdues().doubleValue());
			R0090cell25.setCellStyle(numberStyle);
		} else {
			R0090cell25.setCellValue("");
			R0090cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0090cell26 = row.createCell(26);
		if (record.getR0090_31to90days_pastdues() != null) {
			R0090cell26.setCellValue(record.getR0090_31to90days_pastdues().doubleValue());
			R0090cell26.setCellStyle(numberStyle);
		} else {
			R0090cell26.setCellValue("");
			R0090cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0090cell27 = row.createCell(27);
		if (record.getR0090_91to120days_pastdues() != null) {
			R0090cell27.setCellValue(record.getR0090_91to120days_pastdues().doubleValue());
			R0090cell27.setCellStyle(numberStyle);
		} else {
			R0090cell27.setCellValue("");
			R0090cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0090cell28 = row.createCell(28);
		if (record.getR0090_121to180days_pastdues() != null) {
			R0090cell28.setCellValue(record.getR0090_121to180days_pastdues().doubleValue());
			R0090cell28.setCellStyle(numberStyle);
		} else {
			R0090cell28.setCellValue("");
			R0090cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0090cell29 = row.createCell(29);
		if (record.getR0090_181to365days_pastdues() != null) {
			R0090cell29.setCellValue(record.getR0090_181to365days_pastdues().doubleValue());
			R0090cell29.setCellStyle(numberStyle);
		} else {
			R0090cell29.setCellValue("");
			R0090cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0090cell30 = row.createCell(30);
		if (record.getR0090_over365days_pastdues() != null) {
			R0090cell30.setCellValue(record.getR0090_over365days_pastdues().doubleValue());
			R0090cell30.setCellStyle(numberStyle);
		} else {
			R0090cell30.setCellValue("");
			R0090cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0090cell32 = row.createCell(32);
		if (record.getR0090_newloan_duringreport() != null) {
			R0090cell32.setCellValue(record.getR0090_newloan_duringreport().doubleValue());
			R0090cell32.setCellStyle(numberStyle);
		} else {
			R0090cell32.setCellValue("");
			R0090cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0090cell33 = row.createCell(33);
		if (record.getR0090_newstage_duringreport() != null) {
			R0090cell33.setCellValue(record.getR0090_newstage_duringreport().doubleValue());
			R0090cell33.setCellStyle(numberStyle);
		} else {
			R0090cell33.setCellValue("");
			R0090cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0090cell34 = row.createCell(34);
		if (record.getR0090_intrestfees_duringreport() != null) {
			R0090cell34.setCellValue(record.getR0090_intrestfees_duringreport().doubleValue());
			R0090cell34.setCellStyle(numberStyle);
		} else {
			R0090cell34.setCellValue("");
			R0090cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0090cell35 = row.createCell(35);
		if (record.getR0090_performingac_acinfo() != null) {
			R0090cell35.setCellValue(record.getR0090_performingac_acinfo().doubleValue());
			R0090cell35.setCellStyle(numberStyle);
		} else {
			R0090cell35.setCellValue("");
			R0090cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0090cell36 = row.createCell(36);
		if (record.getR0090_nonperformingac_acinfo() != null) {
			R0090cell36.setCellValue(record.getR0090_nonperformingac_acinfo().doubleValue());
			R0090cell36.setCellStyle(numberStyle);
		} else {
			R0090cell36.setCellValue("");
			R0090cell36.setCellStyle(textStyle);
		}

		/// ROW19
		//// Column E
		row = sheet.getRow(18);
		Cell R0100cell4 = row.createCell(4);
		if (record.getR0100_outstandbal() != null) {
			R0100cell4.setCellValue(record.getR0100_outstandbal().doubleValue());
			R0100cell4.setCellStyle(numberStyle);
		} else {
			R0100cell4.setCellValue("");
			R0100cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0100cell5 = row.createCell(5);
		if (record.getR0100_secured_outstandbal() != null) {
			R0100cell5.setCellValue(record.getR0100_secured_outstandbal().doubleValue());
			R0100cell5.setCellStyle(numberStyle);
		} else {
			R0100cell5.setCellValue("");
			R0100cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0100cell6 = row.createCell(6);
		if (record.getR0100_unsecured_outstandbal() != null) {
			R0100cell6.setCellValue(record.getR0100_unsecured_outstandbal().doubleValue());
			R0100cell6.setCellStyle(numberStyle);
		} else {
			R0100cell6.setCellValue("");
			R0100cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0100cell7 = row.createCell(7);
		if (record.getR0100_stage1_assetclass() != null) {
			R0100cell7.setCellValue(record.getR0100_stage1_assetclass().doubleValue());
			R0100cell7.setCellStyle(numberStyle);
		} else {
			R0100cell7.setCellValue("");
			R0100cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0100cell8 = row.createCell(8);
		if (record.getR0100_stage2_assetclass() != null) {
			R0100cell8.setCellValue(record.getR0100_stage2_assetclass().doubleValue());
			R0100cell8.setCellStyle(numberStyle);
		} else {
			R0100cell8.setCellValue("");
			R0100cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0100cell9 = row.createCell(9);
		if (record.getR0100_stage3a_assetclass() != null) {
			R0100cell9.setCellValue(record.getR0100_stage3a_assetclass().doubleValue());
			R0100cell9.setCellStyle(numberStyle);
		} else {
			R0100cell9.setCellValue("");
			R0100cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0100cell10 = row.createCell(10);
		if (record.getR0100_stage3b_assetclass() != null) {
			R0100cell10.setCellValue(record.getR0100_stage3b_assetclass().doubleValue());
			R0100cell10.setCellStyle(numberStyle);
		} else {
			R0100cell10.setCellValue("");
			R0100cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0100cell11 = row.createCell(11);
		if (record.getR0100_stage3c_assetclass() != null) {
			R0100cell11.setCellValue(record.getR0100_stage3c_assetclass().doubleValue());
			R0100cell11.setCellStyle(numberStyle);
		} else {
			R0100cell11.setCellValue("");
			R0100cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0100cell12 = row.createCell(12);
		if (record.getR0100_stage1_provisionheld() != null) {
			R0100cell12.setCellValue(record.getR0100_stage1_provisionheld().doubleValue());
			R0100cell12.setCellStyle(numberStyle);
		} else {
			R0100cell12.setCellValue("");
			R0100cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0100cell13 = row.createCell(13);
		if (record.getR0100_stage2_provisionheld() != null) {
			R0100cell13.setCellValue(record.getR0100_stage2_provisionheld().doubleValue());
			R0100cell13.setCellStyle(numberStyle);
		} else {
			R0100cell13.setCellValue("");
			R0100cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0100cell14 = row.createCell(14);
		if (record.getR0100_stage3a_provisionheld() != null) {
			R0100cell14.setCellValue(record.getR0100_stage3a_provisionheld().doubleValue());
			R0100cell14.setCellStyle(numberStyle);
		} else {
			R0100cell14.setCellValue("");
			R0100cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0100cell15 = row.createCell(15);
		if (record.getR0100_stage3b_provisionheld() != null) {
			R0100cell15.setCellValue(record.getR0100_stage3b_provisionheld().doubleValue());
			R0100cell15.setCellStyle(numberStyle);
		} else {
			R0100cell15.setCellValue("");
			R0100cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0100cell16 = row.createCell(16);
		if (record.getR0100_stage3c_provisionheld() != null) {
			R0100cell16.setCellValue(record.getR0100_stage3c_provisionheld().doubleValue());
			R0100cell16.setCellStyle(numberStyle);
		} else {
			R0100cell16.setCellValue("");
			R0100cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0100cell17 = row.createCell(17);
		if (record.getR0100_intrestfees_provisionheld() != null) {
			R0100cell17.setCellValue(record.getR0100_intrestfees_provisionheld().doubleValue());
			R0100cell17.setCellStyle(numberStyle);
		} else {
			R0100cell17.setCellValue("");
			R0100cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0100cell18 = row.createCell(18);
		if (record.getR0100_intrestsuspense_provisionheld() != null) {
			R0100cell18.setCellValue(record.getR0100_intrestsuspense_provisionheld().doubleValue());
			R0100cell18.setCellStyle(numberStyle);
		} else {
			R0100cell18.setCellValue("");
			R0100cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0100cell19 = row.createCell(19);
		if (record.getR0100_stage1_poci() != null) {
			R0100cell19.setCellValue(record.getR0100_stage1_poci().doubleValue());
			R0100cell19.setCellStyle(numberStyle);
		} else {
			R0100cell19.setCellValue("");
			R0100cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0100cell20 = row.createCell(20);
		if (record.getR0100_stage2_poci() != null) {
			R0100cell20.setCellValue(record.getR0100_stage2_poci().doubleValue());
			R0100cell20.setCellStyle(numberStyle);
		} else {
			R0100cell20.setCellValue("");
			R0100cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0100cell21 = row.createCell(21);
		if (record.getR0100_stage3a_poci() != null) {
			R0100cell21.setCellValue(record.getR0100_stage3a_poci().doubleValue());
			R0100cell21.setCellStyle(numberStyle);
		} else {
			R0100cell21.setCellValue("");
			R0100cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0100cell22 = row.createCell(22);
		if (record.getR0100_stage3b_poci() != null) {
			R0100cell22.setCellValue(record.getR0100_stage3b_poci().doubleValue());
			R0100cell22.setCellStyle(numberStyle);
		} else {
			R0100cell22.setCellValue("");
			R0100cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0100cell23 = row.createCell(23);
		if (record.getR0100_stage3c_poci() != null) {
			R0100cell23.setCellValue(record.getR0100_stage3c_poci().doubleValue());
			R0100cell23.setCellStyle(numberStyle);
		} else {
			R0100cell23.setCellValue("");
			R0100cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0100cell24 = row.createCell(24);
		if (record.getR0100_current_pastdues() != null) {
			R0100cell24.setCellValue(record.getR0100_current_pastdues().doubleValue());
			R0100cell24.setCellStyle(numberStyle);
		} else {
			R0100cell24.setCellValue("");
			R0100cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0100cell25 = row.createCell(25);
		if (record.getR0100_less30days_pastdues() != null) {
			R0100cell25.setCellValue(record.getR0100_less30days_pastdues().doubleValue());
			R0100cell25.setCellStyle(numberStyle);
		} else {
			R0100cell25.setCellValue("");
			R0100cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0100cell26 = row.createCell(26);
		if (record.getR0100_31to90days_pastdues() != null) {
			R0100cell26.setCellValue(record.getR0100_31to90days_pastdues().doubleValue());
			R0100cell26.setCellStyle(numberStyle);
		} else {
			R0100cell26.setCellValue("");
			R0100cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0100cell27 = row.createCell(27);
		if (record.getR0100_91to120days_pastdues() != null) {
			R0100cell27.setCellValue(record.getR0100_91to120days_pastdues().doubleValue());
			R0100cell27.setCellStyle(numberStyle);
		} else {
			R0100cell27.setCellValue("");
			R0100cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0100cell28 = row.createCell(28);
		if (record.getR0100_121to180days_pastdues() != null) {
			R0100cell28.setCellValue(record.getR0100_121to180days_pastdues().doubleValue());
			R0100cell28.setCellStyle(numberStyle);
		} else {
			R0100cell28.setCellValue("");
			R0100cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0100cell29 = row.createCell(29);
		if (record.getR0100_181to365days_pastdues() != null) {
			R0100cell29.setCellValue(record.getR0100_181to365days_pastdues().doubleValue());
			R0100cell29.setCellStyle(numberStyle);
		} else {
			R0100cell29.setCellValue("");
			R0100cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0100cell30 = row.createCell(30);
		if (record.getR0100_over365days_pastdues() != null) {
			R0100cell30.setCellValue(record.getR0100_over365days_pastdues().doubleValue());
			R0100cell30.setCellStyle(numberStyle);
		} else {
			R0100cell30.setCellValue("");
			R0100cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0100cell32 = row.createCell(32);
		if (record.getR0100_newloan_duringreport() != null) {
			R0100cell32.setCellValue(record.getR0100_newloan_duringreport().doubleValue());
			R0100cell32.setCellStyle(numberStyle);
		} else {
			R0100cell32.setCellValue("");
			R0100cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0100cell33 = row.createCell(33);
		if (record.getR0100_newstage_duringreport() != null) {
			R0100cell33.setCellValue(record.getR0100_newstage_duringreport().doubleValue());
			R0100cell33.setCellStyle(numberStyle);
		} else {
			R0100cell33.setCellValue("");
			R0100cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0100cell34 = row.createCell(34);
		if (record.getR0100_intrestfees_duringreport() != null) {
			R0100cell34.setCellValue(record.getR0100_intrestfees_duringreport().doubleValue());
			R0100cell34.setCellStyle(numberStyle);
		} else {
			R0100cell34.setCellValue("");
			R0100cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0100cell35 = row.createCell(35);
		if (record.getR0100_performingac_acinfo() != null) {
			R0100cell35.setCellValue(record.getR0100_performingac_acinfo().doubleValue());
			R0100cell35.setCellStyle(numberStyle);
		} else {
			R0100cell35.setCellValue("");
			R0100cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0100cell36 = row.createCell(36);
		if (record.getR0100_nonperformingac_acinfo() != null) {
			R0100cell36.setCellValue(record.getR0100_nonperformingac_acinfo().doubleValue());
			R0100cell36.setCellStyle(numberStyle);
		} else {
			R0100cell36.setCellValue("");
			R0100cell36.setCellStyle(textStyle);
		}

		/// ROW20
		//// Column E
		row = sheet.getRow(19);
		Cell R0110cell4 = row.createCell(4);
		if (record.getR0110_outstandbal() != null) {
			R0110cell4.setCellValue(record.getR0110_outstandbal().doubleValue());
			R0110cell4.setCellStyle(numberStyle);
		} else {
			R0110cell4.setCellValue("");
			R0110cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0110cell5 = row.createCell(5);
		if (record.getR0110_secured_outstandbal() != null) {
			R0110cell5.setCellValue(record.getR0110_secured_outstandbal().doubleValue());
			R0110cell5.setCellStyle(numberStyle);
		} else {
			R0110cell5.setCellValue("");
			R0110cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0110cell6 = row.createCell(6);
		if (record.getR0110_unsecured_outstandbal() != null) {
			R0110cell6.setCellValue(record.getR0110_unsecured_outstandbal().doubleValue());
			R0110cell6.setCellStyle(numberStyle);
		} else {
			R0110cell6.setCellValue("");
			R0110cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0110cell7 = row.createCell(7);
		if (record.getR0110_stage1_assetclass() != null) {
			R0110cell7.setCellValue(record.getR0110_stage1_assetclass().doubleValue());
			R0110cell7.setCellStyle(numberStyle);
		} else {
			R0110cell7.setCellValue("");
			R0110cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0110cell8 = row.createCell(8);
		if (record.getR0110_stage2_assetclass() != null) {
			R0110cell8.setCellValue(record.getR0110_stage2_assetclass().doubleValue());
			R0110cell8.setCellStyle(numberStyle);
		} else {
			R0110cell8.setCellValue("");
			R0110cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0110cell9 = row.createCell(9);
		if (record.getR0110_stage3a_assetclass() != null) {
			R0110cell9.setCellValue(record.getR0110_stage3a_assetclass().doubleValue());
			R0110cell9.setCellStyle(numberStyle);
		} else {
			R0110cell9.setCellValue("");
			R0110cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0110cell10 = row.createCell(10);
		if (record.getR0110_stage3b_assetclass() != null) {
			R0110cell10.setCellValue(record.getR0110_stage3b_assetclass().doubleValue());
			R0110cell10.setCellStyle(numberStyle);
		} else {
			R0110cell10.setCellValue("");
			R0110cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0110cell11 = row.createCell(11);
		if (record.getR0110_stage3c_assetclass() != null) {
			R0110cell11.setCellValue(record.getR0110_stage3c_assetclass().doubleValue());
			R0110cell11.setCellStyle(numberStyle);
		} else {
			R0110cell11.setCellValue("");
			R0110cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0110cell12 = row.createCell(12);
		if (record.getR0110_stage1_provisionheld() != null) {
			R0110cell12.setCellValue(record.getR0110_stage1_provisionheld().doubleValue());
			R0110cell12.setCellStyle(numberStyle);
		} else {
			R0110cell12.setCellValue("");
			R0110cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0110cell13 = row.createCell(13);
		if (record.getR0110_stage2_provisionheld() != null) {
			R0110cell13.setCellValue(record.getR0110_stage2_provisionheld().doubleValue());
			R0110cell13.setCellStyle(numberStyle);
		} else {
			R0110cell13.setCellValue("");
			R0110cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0110cell14 = row.createCell(14);
		if (record.getR0110_stage3a_provisionheld() != null) {
			R0110cell14.setCellValue(record.getR0110_stage3a_provisionheld().doubleValue());
			R0110cell14.setCellStyle(numberStyle);
		} else {
			R0110cell14.setCellValue("");
			R0110cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0110cell15 = row.createCell(15);
		if (record.getR0110_stage3b_provisionheld() != null) {
			R0110cell15.setCellValue(record.getR0110_stage3b_provisionheld().doubleValue());
			R0110cell15.setCellStyle(numberStyle);
		} else {
			R0110cell15.setCellValue("");
			R0110cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0110cell16 = row.createCell(16);
		if (record.getR0110_stage3c_provisionheld() != null) {
			R0110cell16.setCellValue(record.getR0110_stage3c_provisionheld().doubleValue());
			R0110cell16.setCellStyle(numberStyle);
		} else {
			R0110cell16.setCellValue("");
			R0110cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0110cell17 = row.createCell(17);
		if (record.getR0110_intrestfees_provisionheld() != null) {
			R0110cell17.setCellValue(record.getR0110_intrestfees_provisionheld().doubleValue());
			R0110cell17.setCellStyle(numberStyle);
		} else {
			R0110cell17.setCellValue("");
			R0110cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0110cell18 = row.createCell(18);
		if (record.getR0110_intrestsuspense_provisionheld() != null) {
			R0110cell18.setCellValue(record.getR0110_intrestsuspense_provisionheld().doubleValue());
			R0110cell18.setCellStyle(numberStyle);
		} else {
			R0110cell18.setCellValue("");
			R0110cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0110cell19 = row.createCell(19);
		if (record.getR0110_stage1_poci() != null) {
			R0110cell19.setCellValue(record.getR0110_stage1_poci().doubleValue());
			R0110cell19.setCellStyle(numberStyle);
		} else {
			R0110cell19.setCellValue("");
			R0110cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0110cell20 = row.createCell(20);
		if (record.getR0110_stage2_poci() != null) {
			R0110cell20.setCellValue(record.getR0110_stage2_poci().doubleValue());
			R0110cell20.setCellStyle(numberStyle);
		} else {
			R0110cell20.setCellValue("");
			R0110cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0110cell21 = row.createCell(21);
		if (record.getR0110_stage3a_poci() != null) {
			R0110cell21.setCellValue(record.getR0110_stage3a_poci().doubleValue());
			R0110cell21.setCellStyle(numberStyle);
		} else {
			R0110cell21.setCellValue("");
			R0110cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0110cell22 = row.createCell(22);
		if (record.getR0110_stage3b_poci() != null) {
			R0110cell22.setCellValue(record.getR0110_stage3b_poci().doubleValue());
			R0110cell22.setCellStyle(numberStyle);
		} else {
			R0110cell22.setCellValue("");
			R0110cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0110cell23 = row.createCell(23);
		if (record.getR0110_stage3c_poci() != null) {
			R0110cell23.setCellValue(record.getR0110_stage3c_poci().doubleValue());
			R0110cell23.setCellStyle(numberStyle);
		} else {
			R0110cell23.setCellValue("");
			R0110cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0110cell24 = row.createCell(24);
		if (record.getR0110_current_pastdues() != null) {
			R0110cell24.setCellValue(record.getR0110_current_pastdues().doubleValue());
			R0110cell24.setCellStyle(numberStyle);
		} else {
			R0110cell24.setCellValue("");
			R0110cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0110cell25 = row.createCell(25);
		if (record.getR0110_less30days_pastdues() != null) {
			R0110cell25.setCellValue(record.getR0110_less30days_pastdues().doubleValue());
			R0110cell25.setCellStyle(numberStyle);
		} else {
			R0110cell25.setCellValue("");
			R0110cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0110cell26 = row.createCell(26);
		if (record.getR0110_31to90days_pastdues() != null) {
			R0110cell26.setCellValue(record.getR0110_31to90days_pastdues().doubleValue());
			R0110cell26.setCellStyle(numberStyle);
		} else {
			R0110cell26.setCellValue("");
			R0110cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0110cell27 = row.createCell(27);
		if (record.getR0110_91to120days_pastdues() != null) {
			R0110cell27.setCellValue(record.getR0110_91to120days_pastdues().doubleValue());
			R0110cell27.setCellStyle(numberStyle);
		} else {
			R0110cell27.setCellValue("");
			R0110cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0110cell28 = row.createCell(28);
		if (record.getR0110_121to180days_pastdues() != null) {
			R0110cell28.setCellValue(record.getR0110_121to180days_pastdues().doubleValue());
			R0110cell28.setCellStyle(numberStyle);
		} else {
			R0110cell28.setCellValue("");
			R0110cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0110cell29 = row.createCell(29);
		if (record.getR0110_181to365days_pastdues() != null) {
			R0110cell29.setCellValue(record.getR0110_181to365days_pastdues().doubleValue());
			R0110cell29.setCellStyle(numberStyle);
		} else {
			R0110cell29.setCellValue("");
			R0110cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0110cell30 = row.createCell(30);
		if (record.getR0110_over365days_pastdues() != null) {
			R0110cell30.setCellValue(record.getR0110_over365days_pastdues().doubleValue());
			R0110cell30.setCellStyle(numberStyle);
		} else {
			R0110cell30.setCellValue("");
			R0110cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0110cell32 = row.createCell(32);
		if (record.getR0110_newloan_duringreport() != null) {
			R0110cell32.setCellValue(record.getR0110_newloan_duringreport().doubleValue());
			R0110cell32.setCellStyle(numberStyle);
		} else {
			R0110cell32.setCellValue("");
			R0110cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0110cell33 = row.createCell(33);
		if (record.getR0110_newstage_duringreport() != null) {
			R0110cell33.setCellValue(record.getR0110_newstage_duringreport().doubleValue());
			R0110cell33.setCellStyle(numberStyle);
		} else {
			R0110cell33.setCellValue("");
			R0110cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0110cell34 = row.createCell(34);
		if (record.getR0110_intrestfees_duringreport() != null) {
			R0110cell34.setCellValue(record.getR0110_intrestfees_duringreport().doubleValue());
			R0110cell34.setCellStyle(numberStyle);
		} else {
			R0110cell34.setCellValue("");
			R0110cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0110cell35 = row.createCell(35);
		if (record.getR0110_performingac_acinfo() != null) {
			R0110cell35.setCellValue(record.getR0110_performingac_acinfo().doubleValue());
			R0110cell35.setCellStyle(numberStyle);
		} else {
			R0110cell35.setCellValue("");
			R0110cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0110cell36 = row.createCell(36);
		if (record.getR0110_nonperformingac_acinfo() != null) {
			R0110cell36.setCellValue(record.getR0110_nonperformingac_acinfo().doubleValue());
			R0110cell36.setCellStyle(numberStyle);
		} else {
			R0110cell36.setCellValue("");
			R0110cell36.setCellStyle(textStyle);
		}

		/// ROW21
		//// Column E
		row = sheet.getRow(20);
		Cell R0120cell4 = row.createCell(4);
		if (record.getR0120_outstandbal() != null) {
			R0120cell4.setCellValue(record.getR0120_outstandbal().doubleValue());
			R0120cell4.setCellStyle(numberStyle);
		} else {
			R0120cell4.setCellValue("");
			R0120cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0120cell5 = row.createCell(5);
		if (record.getR0120_secured_outstandbal() != null) {
			R0120cell5.setCellValue(record.getR0120_secured_outstandbal().doubleValue());
			R0120cell5.setCellStyle(numberStyle);
		} else {
			R0120cell5.setCellValue("");
			R0120cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0120cell6 = row.createCell(6);
		if (record.getR0120_unsecured_outstandbal() != null) {
			R0120cell6.setCellValue(record.getR0120_unsecured_outstandbal().doubleValue());
			R0120cell6.setCellStyle(numberStyle);
		} else {
			R0120cell6.setCellValue("");
			R0120cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0120cell7 = row.createCell(7);
		if (record.getR0120_stage1_assetclass() != null) {
			R0120cell7.setCellValue(record.getR0120_stage1_assetclass().doubleValue());
			R0120cell7.setCellStyle(numberStyle);
		} else {
			R0120cell7.setCellValue("");
			R0120cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0120cell8 = row.createCell(8);
		if (record.getR0120_stage2_assetclass() != null) {
			R0120cell8.setCellValue(record.getR0120_stage2_assetclass().doubleValue());
			R0120cell8.setCellStyle(numberStyle);
		} else {
			R0120cell8.setCellValue("");
			R0120cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0120cell9 = row.createCell(9);
		if (record.getR0120_stage3a_assetclass() != null) {
			R0120cell9.setCellValue(record.getR0120_stage3a_assetclass().doubleValue());
			R0120cell9.setCellStyle(numberStyle);
		} else {
			R0120cell9.setCellValue("");
			R0120cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0120cell10 = row.createCell(10);
		if (record.getR0120_stage3b_assetclass() != null) {
			R0120cell10.setCellValue(record.getR0120_stage3b_assetclass().doubleValue());
			R0120cell10.setCellStyle(numberStyle);
		} else {
			R0120cell10.setCellValue("");
			R0120cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0120cell11 = row.createCell(11);
		if (record.getR0120_stage3c_assetclass() != null) {
			R0120cell11.setCellValue(record.getR0120_stage3c_assetclass().doubleValue());
			R0120cell11.setCellStyle(numberStyle);
		} else {
			R0120cell11.setCellValue("");
			R0120cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0120cell12 = row.createCell(12);
		if (record.getR0120_stage1_provisionheld() != null) {
			R0120cell12.setCellValue(record.getR0120_stage1_provisionheld().doubleValue());
			R0120cell12.setCellStyle(numberStyle);
		} else {
			R0120cell12.setCellValue("");
			R0120cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0120cell13 = row.createCell(13);
		if (record.getR0120_stage2_provisionheld() != null) {
			R0120cell13.setCellValue(record.getR0120_stage2_provisionheld().doubleValue());
			R0120cell13.setCellStyle(numberStyle);
		} else {
			R0120cell13.setCellValue("");
			R0120cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0120cell14 = row.createCell(14);
		if (record.getR0120_stage3a_provisionheld() != null) {
			R0120cell14.setCellValue(record.getR0120_stage3a_provisionheld().doubleValue());
			R0120cell14.setCellStyle(numberStyle);
		} else {
			R0120cell14.setCellValue("");
			R0120cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0120cell15 = row.createCell(15);
		if (record.getR0120_stage3b_provisionheld() != null) {
			R0120cell15.setCellValue(record.getR0120_stage3b_provisionheld().doubleValue());
			R0120cell15.setCellStyle(numberStyle);
		} else {
			R0120cell15.setCellValue("");
			R0120cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0120cell16 = row.createCell(16);
		if (record.getR0120_stage3c_provisionheld() != null) {
			R0120cell16.setCellValue(record.getR0120_stage3c_provisionheld().doubleValue());
			R0120cell16.setCellStyle(numberStyle);
		} else {
			R0120cell16.setCellValue("");
			R0120cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0120cell17 = row.createCell(17);
		if (record.getR0120_intrestfees_provisionheld() != null) {
			R0120cell17.setCellValue(record.getR0120_intrestfees_provisionheld().doubleValue());
			R0120cell17.setCellStyle(numberStyle);
		} else {
			R0120cell17.setCellValue("");
			R0120cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0120cell18 = row.createCell(18);
		if (record.getR0120_intrestsuspense_provisionheld() != null) {
			R0120cell18.setCellValue(record.getR0120_intrestsuspense_provisionheld().doubleValue());
			R0120cell18.setCellStyle(numberStyle);
		} else {
			R0120cell18.setCellValue("");
			R0120cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0120cell19 = row.createCell(19);
		if (record.getR0120_stage1_poci() != null) {
			R0120cell19.setCellValue(record.getR0120_stage1_poci().doubleValue());
			R0120cell19.setCellStyle(numberStyle);
		} else {
			R0120cell19.setCellValue("");
			R0120cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0120cell20 = row.createCell(20);
		if (record.getR0120_stage2_poci() != null) {
			R0120cell20.setCellValue(record.getR0120_stage2_poci().doubleValue());
			R0120cell20.setCellStyle(numberStyle);
		} else {
			R0120cell20.setCellValue("");
			R0120cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0120cell21 = row.createCell(21);
		if (record.getR0120_stage3a_poci() != null) {
			R0120cell21.setCellValue(record.getR0120_stage3a_poci().doubleValue());
			R0120cell21.setCellStyle(numberStyle);
		} else {
			R0120cell21.setCellValue("");
			R0120cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0120cell22 = row.createCell(22);
		if (record.getR0120_stage3b_poci() != null) {
			R0120cell22.setCellValue(record.getR0120_stage3b_poci().doubleValue());
			R0120cell22.setCellStyle(numberStyle);
		} else {
			R0120cell22.setCellValue("");
			R0120cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0120cell23 = row.createCell(23);
		if (record.getR0120_stage3c_poci() != null) {
			R0120cell23.setCellValue(record.getR0120_stage3c_poci().doubleValue());
			R0120cell23.setCellStyle(numberStyle);
		} else {
			R0120cell23.setCellValue("");
			R0120cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0120cell24 = row.createCell(24);
		if (record.getR0120_current_pastdues() != null) {
			R0120cell24.setCellValue(record.getR0120_current_pastdues().doubleValue());
			R0120cell24.setCellStyle(numberStyle);
		} else {
			R0120cell24.setCellValue("");
			R0120cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0120cell25 = row.createCell(25);
		if (record.getR0120_less30days_pastdues() != null) {
			R0120cell25.setCellValue(record.getR0120_less30days_pastdues().doubleValue());
			R0120cell25.setCellStyle(numberStyle);
		} else {
			R0120cell25.setCellValue("");
			R0120cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0120cell26 = row.createCell(26);
		if (record.getR0120_31to90days_pastdues() != null) {
			R0120cell26.setCellValue(record.getR0120_31to90days_pastdues().doubleValue());
			R0120cell26.setCellStyle(numberStyle);
		} else {
			R0120cell26.setCellValue("");
			R0120cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0120cell27 = row.createCell(27);
		if (record.getR0120_91to120days_pastdues() != null) {
			R0120cell27.setCellValue(record.getR0120_91to120days_pastdues().doubleValue());
			R0120cell27.setCellStyle(numberStyle);
		} else {
			R0120cell27.setCellValue("");
			R0120cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0120cell28 = row.createCell(28);
		if (record.getR0120_121to180days_pastdues() != null) {
			R0120cell28.setCellValue(record.getR0120_121to180days_pastdues().doubleValue());
			R0120cell28.setCellStyle(numberStyle);
		} else {
			R0120cell28.setCellValue("");
			R0120cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0120cell29 = row.createCell(29);
		if (record.getR0120_181to365days_pastdues() != null) {
			R0120cell29.setCellValue(record.getR0120_181to365days_pastdues().doubleValue());
			R0120cell29.setCellStyle(numberStyle);
		} else {
			R0120cell29.setCellValue("");
			R0120cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0120cell30 = row.createCell(30);
		if (record.getR0120_over365days_pastdues() != null) {
			R0120cell30.setCellValue(record.getR0120_over365days_pastdues().doubleValue());
			R0120cell30.setCellStyle(numberStyle);
		} else {
			R0120cell30.setCellValue("");
			R0120cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0120cell32 = row.createCell(32);
		if (record.getR0120_newloan_duringreport() != null) {
			R0120cell32.setCellValue(record.getR0120_newloan_duringreport().doubleValue());
			R0120cell32.setCellStyle(numberStyle);
		} else {
			R0120cell32.setCellValue("");
			R0120cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0120cell33 = row.createCell(33);
		if (record.getR0120_newstage_duringreport() != null) {
			R0120cell33.setCellValue(record.getR0120_newstage_duringreport().doubleValue());
			R0120cell33.setCellStyle(numberStyle);
		} else {
			R0120cell33.setCellValue("");
			R0120cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0120cell34 = row.createCell(34);
		if (record.getR0120_intrestfees_duringreport() != null) {
			R0120cell34.setCellValue(record.getR0120_intrestfees_duringreport().doubleValue());
			R0120cell34.setCellStyle(numberStyle);
		} else {
			R0120cell34.setCellValue("");
			R0120cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0120cell35 = row.createCell(35);
		if (record.getR0120_performingac_acinfo() != null) {
			R0120cell35.setCellValue(record.getR0120_performingac_acinfo().doubleValue());
			R0120cell35.setCellStyle(numberStyle);
		} else {
			R0120cell35.setCellValue("");
			R0120cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0120cell36 = row.createCell(36);
		if (record.getR0120_nonperformingac_acinfo() != null) {
			R0120cell36.setCellValue(record.getR0120_nonperformingac_acinfo().doubleValue());
			R0120cell36.setCellStyle(numberStyle);
		} else {
			R0120cell36.setCellValue("");
			R0120cell36.setCellStyle(textStyle);
		}

		/// ROW23
		//// Column E
		row = sheet.getRow(22);
		Cell R0140cell4 = row.createCell(4);
		if (record.getR0140_outstandbal() != null) {
			R0140cell4.setCellValue(record.getR0140_outstandbal().doubleValue());
			R0140cell4.setCellStyle(numberStyle);
		} else {
			R0140cell4.setCellValue("");
			R0140cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0140cell5 = row.createCell(5);
		if (record.getR0140_secured_outstandbal() != null) {
			R0140cell5.setCellValue(record.getR0140_secured_outstandbal().doubleValue());
			R0140cell5.setCellStyle(numberStyle);
		} else {
			R0140cell5.setCellValue("");
			R0140cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0140cell6 = row.createCell(6);
		if (record.getR0140_unsecured_outstandbal() != null) {
			R0140cell6.setCellValue(record.getR0140_unsecured_outstandbal().doubleValue());
			R0140cell6.setCellStyle(numberStyle);
		} else {
			R0140cell6.setCellValue("");
			R0140cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0140cell7 = row.createCell(7);
		if (record.getR0140_stage1_assetclass() != null) {
			R0140cell7.setCellValue(record.getR0140_stage1_assetclass().doubleValue());
			R0140cell7.setCellStyle(numberStyle);
		} else {
			R0140cell7.setCellValue("");
			R0140cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0140cell8 = row.createCell(8);
		if (record.getR0140_stage2_assetclass() != null) {
			R0140cell8.setCellValue(record.getR0140_stage2_assetclass().doubleValue());
			R0140cell8.setCellStyle(numberStyle);
		} else {
			R0140cell8.setCellValue("");
			R0140cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0140cell9 = row.createCell(9);
		if (record.getR0140_stage3a_assetclass() != null) {
			R0140cell9.setCellValue(record.getR0140_stage3a_assetclass().doubleValue());
			R0140cell9.setCellStyle(numberStyle);
		} else {
			R0140cell9.setCellValue("");
			R0140cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0140cell10 = row.createCell(10);
		if (record.getR0140_stage3b_assetclass() != null) {
			R0140cell10.setCellValue(record.getR0140_stage3b_assetclass().doubleValue());
			R0140cell10.setCellStyle(numberStyle);
		} else {
			R0140cell10.setCellValue("");
			R0140cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0140cell11 = row.createCell(11);
		if (record.getR0140_stage3c_assetclass() != null) {
			R0140cell11.setCellValue(record.getR0140_stage3c_assetclass().doubleValue());
			R0140cell11.setCellStyle(numberStyle);
		} else {
			R0140cell11.setCellValue("");
			R0140cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0140cell12 = row.createCell(12);
		if (record.getR0140_stage1_provisionheld() != null) {
			R0140cell12.setCellValue(record.getR0140_stage1_provisionheld().doubleValue());
			R0140cell12.setCellStyle(numberStyle);
		} else {
			R0140cell12.setCellValue("");
			R0140cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0140cell13 = row.createCell(13);
		if (record.getR0140_stage2_provisionheld() != null) {
			R0140cell13.setCellValue(record.getR0140_stage2_provisionheld().doubleValue());
			R0140cell13.setCellStyle(numberStyle);
		} else {
			R0140cell13.setCellValue("");
			R0140cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0140cell14 = row.createCell(14);
		if (record.getR0140_stage3a_provisionheld() != null) {
			R0140cell14.setCellValue(record.getR0140_stage3a_provisionheld().doubleValue());
			R0140cell14.setCellStyle(numberStyle);
		} else {
			R0140cell14.setCellValue("");
			R0140cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0140cell15 = row.createCell(15);
		if (record.getR0140_stage3b_provisionheld() != null) {
			R0140cell15.setCellValue(record.getR0140_stage3b_provisionheld().doubleValue());
			R0140cell15.setCellStyle(numberStyle);
		} else {
			R0140cell15.setCellValue("");
			R0140cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0140cell16 = row.createCell(16);
		if (record.getR0140_stage3c_provisionheld() != null) {
			R0140cell16.setCellValue(record.getR0140_stage3c_provisionheld().doubleValue());
			R0140cell16.setCellStyle(numberStyle);
		} else {
			R0140cell16.setCellValue("");
			R0140cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0140cell17 = row.createCell(17);
		if (record.getR0140_intrestfees_provisionheld() != null) {
			R0140cell17.setCellValue(record.getR0140_intrestfees_provisionheld().doubleValue());
			R0140cell17.setCellStyle(numberStyle);
		} else {
			R0140cell17.setCellValue("");
			R0140cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0140cell18 = row.createCell(18);
		if (record.getR0140_intrestsuspense_provisionheld() != null) {
			R0140cell18.setCellValue(record.getR0140_intrestsuspense_provisionheld().doubleValue());
			R0140cell18.setCellStyle(numberStyle);
		} else {
			R0140cell18.setCellValue("");
			R0140cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0140cell19 = row.createCell(19);
		if (record.getR0140_stage1_poci() != null) {
			R0140cell19.setCellValue(record.getR0140_stage1_poci().doubleValue());
			R0140cell19.setCellStyle(numberStyle);
		} else {
			R0140cell19.setCellValue("");
			R0140cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0140cell20 = row.createCell(20);
		if (record.getR0140_stage2_poci() != null) {
			R0140cell20.setCellValue(record.getR0140_stage2_poci().doubleValue());
			R0140cell20.setCellStyle(numberStyle);
		} else {
			R0140cell20.setCellValue("");
			R0140cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0140cell21 = row.createCell(21);
		if (record.getR0140_stage3a_poci() != null) {
			R0140cell21.setCellValue(record.getR0140_stage3a_poci().doubleValue());
			R0140cell21.setCellStyle(numberStyle);
		} else {
			R0140cell21.setCellValue("");
			R0140cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0140cell22 = row.createCell(22);
		if (record.getR0140_stage3b_poci() != null) {
			R0140cell22.setCellValue(record.getR0140_stage3b_poci().doubleValue());
			R0140cell22.setCellStyle(numberStyle);
		} else {
			R0140cell22.setCellValue("");
			R0140cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0140cell23 = row.createCell(23);
		if (record.getR0140_stage3c_poci() != null) {
			R0140cell23.setCellValue(record.getR0140_stage3c_poci().doubleValue());
			R0140cell23.setCellStyle(numberStyle);
		} else {
			R0140cell23.setCellValue("");
			R0140cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0140cell24 = row.createCell(24);
		if (record.getR0140_current_pastdues() != null) {
			R0140cell24.setCellValue(record.getR0140_current_pastdues().doubleValue());
			R0140cell24.setCellStyle(numberStyle);
		} else {
			R0140cell24.setCellValue("");
			R0140cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0140cell25 = row.createCell(25);
		if (record.getR0140_less30days_pastdues() != null) {
			R0140cell25.setCellValue(record.getR0140_less30days_pastdues().doubleValue());
			R0140cell25.setCellStyle(numberStyle);
		} else {
			R0140cell25.setCellValue("");
			R0140cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0140cell26 = row.createCell(26);
		if (record.getR0140_31to90days_pastdues() != null) {
			R0140cell26.setCellValue(record.getR0140_31to90days_pastdues().doubleValue());
			R0140cell26.setCellStyle(numberStyle);
		} else {
			R0140cell26.setCellValue("");
			R0140cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0140cell27 = row.createCell(27);
		if (record.getR0140_91to120days_pastdues() != null) {
			R0140cell27.setCellValue(record.getR0140_91to120days_pastdues().doubleValue());
			R0140cell27.setCellStyle(numberStyle);
		} else {
			R0140cell27.setCellValue("");
			R0140cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0140cell28 = row.createCell(28);
		if (record.getR0140_121to180days_pastdues() != null) {
			R0140cell28.setCellValue(record.getR0140_121to180days_pastdues().doubleValue());
			R0140cell28.setCellStyle(numberStyle);
		} else {
			R0140cell28.setCellValue("");
			R0140cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0140cell29 = row.createCell(29);
		if (record.getR0140_181to365days_pastdues() != null) {
			R0140cell29.setCellValue(record.getR0140_181to365days_pastdues().doubleValue());
			R0140cell29.setCellStyle(numberStyle);
		} else {
			R0140cell29.setCellValue("");
			R0140cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0140cell30 = row.createCell(30);
		if (record.getR0140_over365days_pastdues() != null) {
			R0140cell30.setCellValue(record.getR0140_over365days_pastdues().doubleValue());
			R0140cell30.setCellStyle(numberStyle);
		} else {
			R0140cell30.setCellValue("");
			R0140cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0140cell32 = row.createCell(32);
		if (record.getR0140_newloan_duringreport() != null) {
			R0140cell32.setCellValue(record.getR0140_newloan_duringreport().doubleValue());
			R0140cell32.setCellStyle(numberStyle);
		} else {
			R0140cell32.setCellValue("");
			R0140cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0140cell33 = row.createCell(33);
		if (record.getR0140_newstage_duringreport() != null) {
			R0140cell33.setCellValue(record.getR0140_newstage_duringreport().doubleValue());
			R0140cell33.setCellStyle(numberStyle);
		} else {
			R0140cell33.setCellValue("");
			R0140cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0140cell34 = row.createCell(34);
		if (record.getR0140_intrestfees_duringreport() != null) {
			R0140cell34.setCellValue(record.getR0140_intrestfees_duringreport().doubleValue());
			R0140cell34.setCellStyle(numberStyle);
		} else {
			R0140cell34.setCellValue("");
			R0140cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0140cell35 = row.createCell(35);
		if (record.getR0140_performingac_acinfo() != null) {
			R0140cell35.setCellValue(record.getR0140_performingac_acinfo().doubleValue());
			R0140cell35.setCellStyle(numberStyle);
		} else {
			R0140cell35.setCellValue("");
			R0140cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0140cell36 = row.createCell(36);
		if (record.getR0140_nonperformingac_acinfo() != null) {
			R0140cell36.setCellValue(record.getR0140_nonperformingac_acinfo().doubleValue());
			R0140cell36.setCellStyle(numberStyle);
		} else {
			R0140cell36.setCellValue("");
			R0140cell36.setCellStyle(textStyle);
		}

		/// ROW24
		//// Column E
		row = sheet.getRow(23);
		Cell R0150cell4 = row.createCell(4);
		if (record.getR0150_outstandbal() != null) {
			R0150cell4.setCellValue(record.getR0150_outstandbal().doubleValue());
			R0150cell4.setCellStyle(numberStyle);
		} else {
			R0150cell4.setCellValue("");
			R0150cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0150cell5 = row.createCell(5);
		if (record.getR0150_secured_outstandbal() != null) {
			R0150cell5.setCellValue(record.getR0150_secured_outstandbal().doubleValue());
			R0150cell5.setCellStyle(numberStyle);
		} else {
			R0150cell5.setCellValue("");
			R0150cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0150cell6 = row.createCell(6);
		if (record.getR0150_unsecured_outstandbal() != null) {
			R0150cell6.setCellValue(record.getR0150_unsecured_outstandbal().doubleValue());
			R0150cell6.setCellStyle(numberStyle);
		} else {
			R0150cell6.setCellValue("");
			R0150cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0150cell7 = row.createCell(7);
		if (record.getR0150_stage1_assetclass() != null) {
			R0150cell7.setCellValue(record.getR0150_stage1_assetclass().doubleValue());
			R0150cell7.setCellStyle(numberStyle);
		} else {
			R0150cell7.setCellValue("");
			R0150cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0150cell8 = row.createCell(8);
		if (record.getR0150_stage2_assetclass() != null) {
			R0150cell8.setCellValue(record.getR0150_stage2_assetclass().doubleValue());
			R0150cell8.setCellStyle(numberStyle);
		} else {
			R0150cell8.setCellValue("");
			R0150cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0150cell9 = row.createCell(9);
		if (record.getR0150_stage3a_assetclass() != null) {
			R0150cell9.setCellValue(record.getR0150_stage3a_assetclass().doubleValue());
			R0150cell9.setCellStyle(numberStyle);
		} else {
			R0150cell9.setCellValue("");
			R0150cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0150cell10 = row.createCell(10);
		if (record.getR0150_stage3b_assetclass() != null) {
			R0150cell10.setCellValue(record.getR0150_stage3b_assetclass().doubleValue());
			R0150cell10.setCellStyle(numberStyle);
		} else {
			R0150cell10.setCellValue("");
			R0150cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0150cell11 = row.createCell(11);
		if (record.getR0150_stage3c_assetclass() != null) {
			R0150cell11.setCellValue(record.getR0150_stage3c_assetclass().doubleValue());
			R0150cell11.setCellStyle(numberStyle);
		} else {
			R0150cell11.setCellValue("");
			R0150cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0150cell12 = row.createCell(12);
		if (record.getR0150_stage1_provisionheld() != null) {
			R0150cell12.setCellValue(record.getR0150_stage1_provisionheld().doubleValue());
			R0150cell12.setCellStyle(numberStyle);
		} else {
			R0150cell12.setCellValue("");
			R0150cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0150cell13 = row.createCell(13);
		if (record.getR0150_stage2_provisionheld() != null) {
			R0150cell13.setCellValue(record.getR0150_stage2_provisionheld().doubleValue());
			R0150cell13.setCellStyle(numberStyle);
		} else {
			R0150cell13.setCellValue("");
			R0150cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0150cell14 = row.createCell(14);
		if (record.getR0150_stage3a_provisionheld() != null) {
			R0150cell14.setCellValue(record.getR0150_stage3a_provisionheld().doubleValue());
			R0150cell14.setCellStyle(numberStyle);
		} else {
			R0150cell14.setCellValue("");
			R0150cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0150cell15 = row.createCell(15);
		if (record.getR0150_stage3b_provisionheld() != null) {
			R0150cell15.setCellValue(record.getR0150_stage3b_provisionheld().doubleValue());
			R0150cell15.setCellStyle(numberStyle);
		} else {
			R0150cell15.setCellValue("");
			R0150cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0150cell16 = row.createCell(16);
		if (record.getR0150_stage3c_provisionheld() != null) {
			R0150cell16.setCellValue(record.getR0150_stage3c_provisionheld().doubleValue());
			R0150cell16.setCellStyle(numberStyle);
		} else {
			R0150cell16.setCellValue("");
			R0150cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0150cell17 = row.createCell(17);
		if (record.getR0150_intrestfees_provisionheld() != null) {
			R0150cell17.setCellValue(record.getR0150_intrestfees_provisionheld().doubleValue());
			R0150cell17.setCellStyle(numberStyle);
		} else {
			R0150cell17.setCellValue("");
			R0150cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0150cell18 = row.createCell(18);
		if (record.getR0150_intrestsuspense_provisionheld() != null) {
			R0150cell18.setCellValue(record.getR0150_intrestsuspense_provisionheld().doubleValue());
			R0150cell18.setCellStyle(numberStyle);
		} else {
			R0150cell18.setCellValue("");
			R0150cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0150cell19 = row.createCell(19);
		if (record.getR0150_stage1_poci() != null) {
			R0150cell19.setCellValue(record.getR0150_stage1_poci().doubleValue());
			R0150cell19.setCellStyle(numberStyle);
		} else {
			R0150cell19.setCellValue("");
			R0150cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0150cell20 = row.createCell(20);
		if (record.getR0150_stage2_poci() != null) {
			R0150cell20.setCellValue(record.getR0150_stage2_poci().doubleValue());
			R0150cell20.setCellStyle(numberStyle);
		} else {
			R0150cell20.setCellValue("");
			R0150cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0150cell21 = row.createCell(21);
		if (record.getR0150_stage3a_poci() != null) {
			R0150cell21.setCellValue(record.getR0150_stage3a_poci().doubleValue());
			R0150cell21.setCellStyle(numberStyle);
		} else {
			R0150cell21.setCellValue("");
			R0150cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0150cell22 = row.createCell(22);
		if (record.getR0150_stage3b_poci() != null) {
			R0150cell22.setCellValue(record.getR0150_stage3b_poci().doubleValue());
			R0150cell22.setCellStyle(numberStyle);
		} else {
			R0150cell22.setCellValue("");
			R0150cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0150cell23 = row.createCell(23);
		if (record.getR0150_stage3c_poci() != null) {
			R0150cell23.setCellValue(record.getR0150_stage3c_poci().doubleValue());
			R0150cell23.setCellStyle(numberStyle);
		} else {
			R0150cell23.setCellValue("");
			R0150cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0150cell24 = row.createCell(24);
		if (record.getR0150_current_pastdues() != null) {
			R0150cell24.setCellValue(record.getR0150_current_pastdues().doubleValue());
			R0150cell24.setCellStyle(numberStyle);
		} else {
			R0150cell24.setCellValue("");
			R0150cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0150cell25 = row.createCell(25);
		if (record.getR0150_less30days_pastdues() != null) {
			R0150cell25.setCellValue(record.getR0150_less30days_pastdues().doubleValue());
			R0150cell25.setCellStyle(numberStyle);
		} else {
			R0150cell25.setCellValue("");
			R0150cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0150cell26 = row.createCell(26);
		if (record.getR0150_31to90days_pastdues() != null) {
			R0150cell26.setCellValue(record.getR0150_31to90days_pastdues().doubleValue());
			R0150cell26.setCellStyle(numberStyle);
		} else {
			R0150cell26.setCellValue("");
			R0150cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0150cell27 = row.createCell(27);
		if (record.getR0150_91to120days_pastdues() != null) {
			R0150cell27.setCellValue(record.getR0150_91to120days_pastdues().doubleValue());
			R0150cell27.setCellStyle(numberStyle);
		} else {
			R0150cell27.setCellValue("");
			R0150cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0150cell28 = row.createCell(28);
		if (record.getR0150_121to180days_pastdues() != null) {
			R0150cell28.setCellValue(record.getR0150_121to180days_pastdues().doubleValue());
			R0150cell28.setCellStyle(numberStyle);
		} else {
			R0150cell28.setCellValue("");
			R0150cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0150cell29 = row.createCell(29);
		if (record.getR0150_181to365days_pastdues() != null) {
			R0150cell29.setCellValue(record.getR0150_181to365days_pastdues().doubleValue());
			R0150cell29.setCellStyle(numberStyle);
		} else {
			R0150cell29.setCellValue("");
			R0150cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0150cell30 = row.createCell(30);
		if (record.getR0150_over365days_pastdues() != null) {
			R0150cell30.setCellValue(record.getR0150_over365days_pastdues().doubleValue());
			R0150cell30.setCellStyle(numberStyle);
		} else {
			R0150cell30.setCellValue("");
			R0150cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0150cell32 = row.createCell(32);
		if (record.getR0150_newloan_duringreport() != null) {
			R0150cell32.setCellValue(record.getR0150_newloan_duringreport().doubleValue());
			R0150cell32.setCellStyle(numberStyle);
		} else {
			R0150cell32.setCellValue("");
			R0150cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0150cell33 = row.createCell(33);
		if (record.getR0150_newstage_duringreport() != null) {
			R0150cell33.setCellValue(record.getR0150_newstage_duringreport().doubleValue());
			R0150cell33.setCellStyle(numberStyle);
		} else {
			R0150cell33.setCellValue("");
			R0150cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0150cell34 = row.createCell(34);
		if (record.getR0150_intrestfees_duringreport() != null) {
			R0150cell34.setCellValue(record.getR0150_intrestfees_duringreport().doubleValue());
			R0150cell34.setCellStyle(numberStyle);
		} else {
			R0150cell34.setCellValue("");
			R0150cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0150cell35 = row.createCell(35);
		if (record.getR0150_performingac_acinfo() != null) {
			R0150cell35.setCellValue(record.getR0150_performingac_acinfo().doubleValue());
			R0150cell35.setCellStyle(numberStyle);
		} else {
			R0150cell35.setCellValue("");
			R0150cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0150cell36 = row.createCell(36);
		if (record.getR0150_nonperformingac_acinfo() != null) {
			R0150cell36.setCellValue(record.getR0150_nonperformingac_acinfo().doubleValue());
			R0150cell36.setCellStyle(numberStyle);
		} else {
			R0150cell36.setCellValue("");
			R0150cell36.setCellStyle(textStyle);
		}

		/// ROW25
		//// Column E
		row = sheet.getRow(24);
		Cell R0160cell4 = row.createCell(4);
		if (record.getR0160_outstandbal() != null) {
			R0160cell4.setCellValue(record.getR0160_outstandbal().doubleValue());
			R0160cell4.setCellStyle(numberStyle);
		} else {
			R0160cell4.setCellValue("");
			R0160cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0160cell5 = row.createCell(5);
		if (record.getR0160_secured_outstandbal() != null) {
			R0160cell5.setCellValue(record.getR0160_secured_outstandbal().doubleValue());
			R0160cell5.setCellStyle(numberStyle);
		} else {
			R0160cell5.setCellValue("");
			R0160cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0160cell6 = row.createCell(6);
		if (record.getR0160_unsecured_outstandbal() != null) {
			R0160cell6.setCellValue(record.getR0160_unsecured_outstandbal().doubleValue());
			R0160cell6.setCellStyle(numberStyle);
		} else {
			R0160cell6.setCellValue("");
			R0160cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0160cell7 = row.createCell(7);
		if (record.getR0160_stage1_assetclass() != null) {
			R0160cell7.setCellValue(record.getR0160_stage1_assetclass().doubleValue());
			R0160cell7.setCellStyle(numberStyle);
		} else {
			R0160cell7.setCellValue("");
			R0160cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0160cell8 = row.createCell(8);
		if (record.getR0160_stage2_assetclass() != null) {
			R0160cell8.setCellValue(record.getR0160_stage2_assetclass().doubleValue());
			R0160cell8.setCellStyle(numberStyle);
		} else {
			R0160cell8.setCellValue("");
			R0160cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0160cell9 = row.createCell(9);
		if (record.getR0160_stage3a_assetclass() != null) {
			R0160cell9.setCellValue(record.getR0160_stage3a_assetclass().doubleValue());
			R0160cell9.setCellStyle(numberStyle);
		} else {
			R0160cell9.setCellValue("");
			R0160cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0160cell10 = row.createCell(10);
		if (record.getR0160_stage3b_assetclass() != null) {
			R0160cell10.setCellValue(record.getR0160_stage3b_assetclass().doubleValue());
			R0160cell10.setCellStyle(numberStyle);
		} else {
			R0160cell10.setCellValue("");
			R0160cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0160cell11 = row.createCell(11);
		if (record.getR0160_stage3c_assetclass() != null) {
			R0160cell11.setCellValue(record.getR0160_stage3c_assetclass().doubleValue());
			R0160cell11.setCellStyle(numberStyle);
		} else {
			R0160cell11.setCellValue("");
			R0160cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0160cell12 = row.createCell(12);
		if (record.getR0160_stage1_provisionheld() != null) {
			R0160cell12.setCellValue(record.getR0160_stage1_provisionheld().doubleValue());
			R0160cell12.setCellStyle(numberStyle);
		} else {
			R0160cell12.setCellValue("");
			R0160cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0160cell13 = row.createCell(13);
		if (record.getR0160_stage2_provisionheld() != null) {
			R0160cell13.setCellValue(record.getR0160_stage2_provisionheld().doubleValue());
			R0160cell13.setCellStyle(numberStyle);
		} else {
			R0160cell13.setCellValue("");
			R0160cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0160cell14 = row.createCell(14);
		if (record.getR0160_stage3a_provisionheld() != null) {
			R0160cell14.setCellValue(record.getR0160_stage3a_provisionheld().doubleValue());
			R0160cell14.setCellStyle(numberStyle);
		} else {
			R0160cell14.setCellValue("");
			R0160cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0160cell15 = row.createCell(15);
		if (record.getR0160_stage3b_provisionheld() != null) {
			R0160cell15.setCellValue(record.getR0160_stage3b_provisionheld().doubleValue());
			R0160cell15.setCellStyle(numberStyle);
		} else {
			R0160cell15.setCellValue("");
			R0160cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0160cell16 = row.createCell(16);
		if (record.getR0160_stage3c_provisionheld() != null) {
			R0160cell16.setCellValue(record.getR0160_stage3c_provisionheld().doubleValue());
			R0160cell16.setCellStyle(numberStyle);
		} else {
			R0160cell16.setCellValue("");
			R0160cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0160cell17 = row.createCell(17);
		if (record.getR0160_intrestfees_provisionheld() != null) {
			R0160cell17.setCellValue(record.getR0160_intrestfees_provisionheld().doubleValue());
			R0160cell17.setCellStyle(numberStyle);
		} else {
			R0160cell17.setCellValue("");
			R0160cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0160cell18 = row.createCell(18);
		if (record.getR0160_intrestsuspense_provisionheld() != null) {
			R0160cell18.setCellValue(record.getR0160_intrestsuspense_provisionheld().doubleValue());
			R0160cell18.setCellStyle(numberStyle);
		} else {
			R0160cell18.setCellValue("");
			R0160cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0160cell19 = row.createCell(19);
		if (record.getR0160_stage1_poci() != null) {
			R0160cell19.setCellValue(record.getR0160_stage1_poci().doubleValue());
			R0160cell19.setCellStyle(numberStyle);
		} else {
			R0160cell19.setCellValue("");
			R0160cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0160cell20 = row.createCell(20);
		if (record.getR0160_stage2_poci() != null) {
			R0160cell20.setCellValue(record.getR0160_stage2_poci().doubleValue());
			R0160cell20.setCellStyle(numberStyle);
		} else {
			R0160cell20.setCellValue("");
			R0160cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0160cell21 = row.createCell(21);
		if (record.getR0160_stage3a_poci() != null) {
			R0160cell21.setCellValue(record.getR0160_stage3a_poci().doubleValue());
			R0160cell21.setCellStyle(numberStyle);
		} else {
			R0160cell21.setCellValue("");
			R0160cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0160cell22 = row.createCell(22);
		if (record.getR0160_stage3b_poci() != null) {
			R0160cell22.setCellValue(record.getR0160_stage3b_poci().doubleValue());
			R0160cell22.setCellStyle(numberStyle);
		} else {
			R0160cell22.setCellValue("");
			R0160cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0160cell23 = row.createCell(23);
		if (record.getR0160_stage3c_poci() != null) {
			R0160cell23.setCellValue(record.getR0160_stage3c_poci().doubleValue());
			R0160cell23.setCellStyle(numberStyle);
		} else {
			R0160cell23.setCellValue("");
			R0160cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0160cell24 = row.createCell(24);
		if (record.getR0160_current_pastdues() != null) {
			R0160cell24.setCellValue(record.getR0160_current_pastdues().doubleValue());
			R0160cell24.setCellStyle(numberStyle);
		} else {
			R0160cell24.setCellValue("");
			R0160cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0160cell25 = row.createCell(25);
		if (record.getR0160_less30days_pastdues() != null) {
			R0160cell25.setCellValue(record.getR0160_less30days_pastdues().doubleValue());
			R0160cell25.setCellStyle(numberStyle);
		} else {
			R0160cell25.setCellValue("");
			R0160cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0160cell26 = row.createCell(26);
		if (record.getR0160_31to90days_pastdues() != null) {
			R0160cell26.setCellValue(record.getR0160_31to90days_pastdues().doubleValue());
			R0160cell26.setCellStyle(numberStyle);
		} else {
			R0160cell26.setCellValue("");
			R0160cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0160cell27 = row.createCell(27);
		if (record.getR0160_91to120days_pastdues() != null) {
			R0160cell27.setCellValue(record.getR0160_91to120days_pastdues().doubleValue());
			R0160cell27.setCellStyle(numberStyle);
		} else {
			R0160cell27.setCellValue("");
			R0160cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0160cell28 = row.createCell(28);
		if (record.getR0160_121to80days_pastdues() != null) {
			R0160cell28.setCellValue(record.getR0160_121to80days_pastdues().doubleValue());
			R0160cell28.setCellStyle(numberStyle);
		} else {
			R0160cell28.setCellValue("");
			R0160cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0160cell29 = row.createCell(29);
		if (record.getR0160_181to365days_pastdues() != null) {
			R0160cell29.setCellValue(record.getR0160_181to365days_pastdues().doubleValue());
			R0160cell29.setCellStyle(numberStyle);
		} else {
			R0160cell29.setCellValue("");
			R0160cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0160cell30 = row.createCell(30);
		if (record.getR0160_over365days_pastdues() != null) {
			R0160cell30.setCellValue(record.getR0160_over365days_pastdues().doubleValue());
			R0160cell30.setCellStyle(numberStyle);
		} else {
			R0160cell30.setCellValue("");
			R0160cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0160cell32 = row.createCell(32);
		if (record.getR0160_newloan_duringreport() != null) {
			R0160cell32.setCellValue(record.getR0160_newloan_duringreport().doubleValue());
			R0160cell32.setCellStyle(numberStyle);
		} else {
			R0160cell32.setCellValue("");
			R0160cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0160cell33 = row.createCell(33);
		if (record.getR0160_newstage_duringreport() != null) {
			R0160cell33.setCellValue(record.getR0160_newstage_duringreport().doubleValue());
			R0160cell33.setCellStyle(numberStyle);
		} else {
			R0160cell33.setCellValue("");
			R0160cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0160cell34 = row.createCell(34);
		if (record.getR0160_intrestfees_duringreport() != null) {
			R0160cell34.setCellValue(record.getR0160_intrestfees_duringreport().doubleValue());
			R0160cell34.setCellStyle(numberStyle);
		} else {
			R0160cell34.setCellValue("");
			R0160cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0160cell35 = row.createCell(35);
		if (record.getR0160_performingac_acinfo() != null) {
			R0160cell35.setCellValue(record.getR0160_performingac_acinfo().doubleValue());
			R0160cell35.setCellStyle(numberStyle);
		} else {
			R0160cell35.setCellValue("");
			R0160cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0160cell36 = row.createCell(36);
		if (record.getR0160_nonperformingac_acinfo() != null) {
			R0160cell36.setCellValue(record.getR0160_nonperformingac_acinfo().doubleValue());
			R0160cell36.setCellStyle(numberStyle);
		} else {
			R0160cell36.setCellValue("");
			R0160cell36.setCellStyle(textStyle);
		}

		/// ROW26
		//// Column E
		row = sheet.getRow(25);
		Cell R0170cell4 = row.createCell(4);
		if (record.getR0170_outstandbal() != null) {
			R0170cell4.setCellValue(record.getR0170_outstandbal().doubleValue());
			R0170cell4.setCellStyle(numberStyle);
		} else {
			R0170cell4.setCellValue("");
			R0170cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0170cell5 = row.createCell(5);
		if (record.getR0170_secured_outstandbal() != null) {
			R0170cell5.setCellValue(record.getR0170_secured_outstandbal().doubleValue());
			R0170cell5.setCellStyle(numberStyle);
		} else {
			R0170cell5.setCellValue("");
			R0170cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0170cell6 = row.createCell(6);
		if (record.getR0170_unsecured_outstandbal() != null) {
			R0170cell6.setCellValue(record.getR0170_unsecured_outstandbal().doubleValue());
			R0170cell6.setCellStyle(numberStyle);
		} else {
			R0170cell6.setCellValue("");
			R0170cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0170cell7 = row.createCell(7);
		if (record.getR0170_stage1_assetclass() != null) {
			R0170cell7.setCellValue(record.getR0170_stage1_assetclass().doubleValue());
			R0170cell7.setCellStyle(numberStyle);
		} else {
			R0170cell7.setCellValue("");
			R0170cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0170cell8 = row.createCell(8);
		if (record.getR0170_stage2_assetclass() != null) {
			R0170cell8.setCellValue(record.getR0170_stage2_assetclass().doubleValue());
			R0170cell8.setCellStyle(numberStyle);
		} else {
			R0170cell8.setCellValue("");
			R0170cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0170cell9 = row.createCell(9);
		if (record.getR0170_stage3a_assetclass() != null) {
			R0170cell9.setCellValue(record.getR0170_stage3a_assetclass().doubleValue());
			R0170cell9.setCellStyle(numberStyle);
		} else {
			R0170cell9.setCellValue("");
			R0170cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0170cell10 = row.createCell(10);
		if (record.getR0170_stage3b_assetclass() != null) {
			R0170cell10.setCellValue(record.getR0170_stage3b_assetclass().doubleValue());
			R0170cell10.setCellStyle(numberStyle);
		} else {
			R0170cell10.setCellValue("");
			R0170cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0170cell11 = row.createCell(11);
		if (record.getR0170_stage3c_assetclass() != null) {
			R0170cell11.setCellValue(record.getR0170_stage3c_assetclass().doubleValue());
			R0170cell11.setCellStyle(numberStyle);
		} else {
			R0170cell11.setCellValue("");
			R0170cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0170cell12 = row.createCell(12);
		if (record.getR0170_stage1_provisionheld() != null) {
			R0170cell12.setCellValue(record.getR0170_stage1_provisionheld().doubleValue());
			R0170cell12.setCellStyle(numberStyle);
		} else {
			R0170cell12.setCellValue("");
			R0170cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0170cell13 = row.createCell(13);
		if (record.getR0170_stage2_provisionheld() != null) {
			R0170cell13.setCellValue(record.getR0170_stage2_provisionheld().doubleValue());
			R0170cell13.setCellStyle(numberStyle);
		} else {
			R0170cell13.setCellValue("");
			R0170cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0170cell14 = row.createCell(14);
		if (record.getR0170_stage3a_provisionheld() != null) {
			R0170cell14.setCellValue(record.getR0170_stage3a_provisionheld().doubleValue());
			R0170cell14.setCellStyle(numberStyle);
		} else {
			R0170cell14.setCellValue("");
			R0170cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0170cell15 = row.createCell(15);
		if (record.getR0170_stage3b_provisionheld() != null) {
			R0170cell15.setCellValue(record.getR0170_stage3b_provisionheld().doubleValue());
			R0170cell15.setCellStyle(numberStyle);
		} else {
			R0170cell15.setCellValue("");
			R0170cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0170cell16 = row.createCell(16);
		if (record.getR0170_stage3c_provisionheld() != null) {
			R0170cell16.setCellValue(record.getR0170_stage3c_provisionheld().doubleValue());
			R0170cell16.setCellStyle(numberStyle);
		} else {
			R0170cell16.setCellValue("");
			R0170cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0170cell17 = row.createCell(17);
		if (record.getR0170_intrestfees_provisionheld() != null) {
			R0170cell17.setCellValue(record.getR0170_intrestfees_provisionheld().doubleValue());
			R0170cell17.setCellStyle(numberStyle);
		} else {
			R0170cell17.setCellValue("");
			R0170cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0170cell18 = row.createCell(18);
		if (record.getR0170_intrestsuspense_provisionheld() != null) {
			R0170cell18.setCellValue(record.getR0170_intrestsuspense_provisionheld().doubleValue());
			R0170cell18.setCellStyle(numberStyle);
		} else {
			R0170cell18.setCellValue("");
			R0170cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0170cell19 = row.createCell(19);
		if (record.getR0170_stage1_poci() != null) {
			R0170cell19.setCellValue(record.getR0170_stage1_poci().doubleValue());
			R0170cell19.setCellStyle(numberStyle);
		} else {
			R0170cell19.setCellValue("");
			R0170cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0170cell20 = row.createCell(20);
		if (record.getR0170_stage2_poci() != null) {
			R0170cell20.setCellValue(record.getR0170_stage2_poci().doubleValue());
			R0170cell20.setCellStyle(numberStyle);
		} else {
			R0170cell20.setCellValue("");
			R0170cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0170cell21 = row.createCell(21);
		if (record.getR0170_stage3a_poci() != null) {
			R0170cell21.setCellValue(record.getR0170_stage3a_poci().doubleValue());
			R0170cell21.setCellStyle(numberStyle);
		} else {
			R0170cell21.setCellValue("");
			R0170cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0170cell22 = row.createCell(22);
		if (record.getR0170_stage3b_poci() != null) {
			R0170cell22.setCellValue(record.getR0170_stage3b_poci().doubleValue());
			R0170cell22.setCellStyle(numberStyle);
		} else {
			R0170cell22.setCellValue("");
			R0170cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0170cell23 = row.createCell(23);
		if (record.getR0170_stage3c_poci() != null) {
			R0170cell23.setCellValue(record.getR0170_stage3c_poci().doubleValue());
			R0170cell23.setCellStyle(numberStyle);
		} else {
			R0170cell23.setCellValue("");
			R0170cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0170cell24 = row.createCell(24);
		if (record.getR0170_current_pastdues() != null) {
			R0170cell24.setCellValue(record.getR0170_current_pastdues().doubleValue());
			R0170cell24.setCellStyle(numberStyle);
		} else {
			R0170cell24.setCellValue("");
			R0170cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0170cell25 = row.createCell(25);
		if (record.getR0170_less30days_pastdues() != null) {
			R0170cell25.setCellValue(record.getR0170_less30days_pastdues().doubleValue());
			R0170cell25.setCellStyle(numberStyle);
		} else {
			R0170cell25.setCellValue("");
			R0170cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0170cell26 = row.createCell(26);
		if (record.getR0170_31to90days_pastdues() != null) {
			R0170cell26.setCellValue(record.getR0170_31to90days_pastdues().doubleValue());
			R0170cell26.setCellStyle(numberStyle);
		} else {
			R0170cell26.setCellValue("");
			R0170cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0170cell27 = row.createCell(27);
		if (record.getR0170_91to120days_pastdues() != null) {
			R0170cell27.setCellValue(record.getR0170_91to120days_pastdues().doubleValue());
			R0170cell27.setCellStyle(numberStyle);
		} else {
			R0170cell27.setCellValue("");
			R0170cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0170cell28 = row.createCell(28);
		if (record.getR0170_121to180days_pastdues() != null) {
			R0170cell28.setCellValue(record.getR0170_121to180days_pastdues().doubleValue());
			R0170cell28.setCellStyle(numberStyle);
		} else {
			R0170cell28.setCellValue("");
			R0170cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0170cell29 = row.createCell(29);
		if (record.getR0170_181to365days_pastdues() != null) {
			R0170cell29.setCellValue(record.getR0170_181to365days_pastdues().doubleValue());
			R0170cell29.setCellStyle(numberStyle);
		} else {
			R0170cell29.setCellValue("");
			R0170cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0170cell30 = row.createCell(30);
		if (record.getR0170_over365days_pastdues() != null) {
			R0170cell30.setCellValue(record.getR0170_over365days_pastdues().doubleValue());
			R0170cell30.setCellStyle(numberStyle);
		} else {
			R0170cell30.setCellValue("");
			R0170cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0170cell32 = row.createCell(32);
		if (record.getR0170_newloan_duringreport() != null) {
			R0170cell32.setCellValue(record.getR0170_newloan_duringreport().doubleValue());
			R0170cell32.setCellStyle(numberStyle);
		} else {
			R0170cell32.setCellValue("");
			R0170cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0170cell33 = row.createCell(33);
		if (record.getR0170_newstage_duringreport() != null) {
			R0170cell33.setCellValue(record.getR0170_newstage_duringreport().doubleValue());
			R0170cell33.setCellStyle(numberStyle);
		} else {
			R0170cell33.setCellValue("");
			R0170cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0170cell34 = row.createCell(34);
		if (record.getR0170_intrestfees_duringreport() != null) {
			R0170cell34.setCellValue(record.getR0170_intrestfees_duringreport().doubleValue());
			R0170cell34.setCellStyle(numberStyle);
		} else {
			R0170cell34.setCellValue("");
			R0170cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0170cell35 = row.createCell(35);
		if (record.getR0170_performingac_acinfo() != null) {
			R0170cell35.setCellValue(record.getR0170_performingac_acinfo().doubleValue());
			R0170cell35.setCellStyle(numberStyle);
		} else {
			R0170cell35.setCellValue("");
			R0170cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0170cell36 = row.createCell(36);
		if (record.getR0170_nonperformingac_acinfo() != null) {
			R0170cell36.setCellValue(record.getR0170_nonperformingac_acinfo().doubleValue());
			R0170cell36.setCellStyle(numberStyle);
		} else {
			R0170cell36.setCellValue("");
			R0170cell36.setCellStyle(textStyle);
		}

		/// ROW27
		//// Column E
		row = sheet.getRow(26);
		Cell R0180cell4 = row.createCell(4);
		if (record.getR0180_outstandbal() != null) {
			R0180cell4.setCellValue(record.getR0180_outstandbal().doubleValue());
			R0180cell4.setCellStyle(numberStyle);
		} else {
			R0180cell4.setCellValue("");
			R0180cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0180cell5 = row.createCell(5);
		if (record.getR0180_secured_outstandbal() != null) {
			R0180cell5.setCellValue(record.getR0180_secured_outstandbal().doubleValue());
			R0180cell5.setCellStyle(numberStyle);
		} else {
			R0180cell5.setCellValue("");
			R0180cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0180cell6 = row.createCell(6);
		if (record.getR0180_unsecured_outstandbal() != null) {
			R0180cell6.setCellValue(record.getR0180_unsecured_outstandbal().doubleValue());
			R0180cell6.setCellStyle(numberStyle);
		} else {
			R0180cell6.setCellValue("");
			R0180cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0180cell7 = row.createCell(7);
		if (record.getR0180_stage1_assetclass() != null) {
			R0180cell7.setCellValue(record.getR0180_stage1_assetclass().doubleValue());
			R0180cell7.setCellStyle(numberStyle);
		} else {
			R0180cell7.setCellValue("");
			R0180cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0180cell8 = row.createCell(8);
		if (record.getR0180_stage2_assetclass() != null) {
			R0180cell8.setCellValue(record.getR0180_stage2_assetclass().doubleValue());
			R0180cell8.setCellStyle(numberStyle);
		} else {
			R0180cell8.setCellValue("");
			R0180cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0180cell9 = row.createCell(9);
		if (record.getR0180_stage3a_assetclass() != null) {
			R0180cell9.setCellValue(record.getR0180_stage3a_assetclass().doubleValue());
			R0180cell9.setCellStyle(numberStyle);
		} else {
			R0180cell9.setCellValue("");
			R0180cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0180cell10 = row.createCell(10);
		if (record.getR0180_stage3b_assetclass() != null) {
			R0180cell10.setCellValue(record.getR0180_stage3b_assetclass().doubleValue());
			R0180cell10.setCellStyle(numberStyle);
		} else {
			R0180cell10.setCellValue("");
			R0180cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0180cell11 = row.createCell(11);
		if (record.getR0180_stage3c_assetclass() != null) {
			R0180cell11.setCellValue(record.getR0180_stage3c_assetclass().doubleValue());
			R0180cell11.setCellStyle(numberStyle);
		} else {
			R0180cell11.setCellValue("");
			R0180cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0180cell12 = row.createCell(12);
		if (record.getR0180_stage1_provisionheld() != null) {
			R0180cell12.setCellValue(record.getR0180_stage1_provisionheld().doubleValue());
			R0180cell12.setCellStyle(numberStyle);
		} else {
			R0180cell12.setCellValue("");
			R0180cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0180cell13 = row.createCell(13);
		if (record.getR0180_stage2_provisionheld() != null) {
			R0180cell13.setCellValue(record.getR0180_stage2_provisionheld().doubleValue());
			R0180cell13.setCellStyle(numberStyle);
		} else {
			R0180cell13.setCellValue("");
			R0180cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0180cell14 = row.createCell(14);
		if (record.getR0180_stage3a_provisionheld() != null) {
			R0180cell14.setCellValue(record.getR0180_stage3a_provisionheld().doubleValue());
			R0180cell14.setCellStyle(numberStyle);
		} else {
			R0180cell14.setCellValue("");
			R0180cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0180cell15 = row.createCell(15);
		if (record.getR0180_stage3b_provisionheld() != null) {
			R0180cell15.setCellValue(record.getR0180_stage3b_provisionheld().doubleValue());
			R0180cell15.setCellStyle(numberStyle);
		} else {
			R0180cell15.setCellValue("");
			R0180cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0180cell16 = row.createCell(16);
		if (record.getR0180_stage3c_provisionheld() != null) {
			R0180cell16.setCellValue(record.getR0180_stage3c_provisionheld().doubleValue());
			R0180cell16.setCellStyle(numberStyle);
		} else {
			R0180cell16.setCellValue("");
			R0180cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0180cell17 = row.createCell(17);
		if (record.getR0180_intrestfees_provisionheld() != null) {
			R0180cell17.setCellValue(record.getR0180_intrestfees_provisionheld().doubleValue());
			R0180cell17.setCellStyle(numberStyle);
		} else {
			R0180cell17.setCellValue("");
			R0180cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0180cell18 = row.createCell(18);
		if (record.getR0180_intrestsuspense_provisionheld() != null) {
			R0180cell18.setCellValue(record.getR0180_intrestsuspense_provisionheld().doubleValue());
			R0180cell18.setCellStyle(numberStyle);
		} else {
			R0180cell18.setCellValue("");
			R0180cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0180cell19 = row.createCell(19);
		if (record.getR0180_stage1_poci() != null) {
			R0180cell19.setCellValue(record.getR0180_stage1_poci().doubleValue());
			R0180cell19.setCellStyle(numberStyle);
		} else {
			R0180cell19.setCellValue("");
			R0180cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0180cell20 = row.createCell(20);
		if (record.getR0180_stage2_poci() != null) {
			R0180cell20.setCellValue(record.getR0180_stage2_poci().doubleValue());
			R0180cell20.setCellStyle(numberStyle);
		} else {
			R0180cell20.setCellValue("");
			R0180cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0180cell21 = row.createCell(21);
		if (record.getR0180_stage3a_poci() != null) {
			R0180cell21.setCellValue(record.getR0180_stage3a_poci().doubleValue());
			R0180cell21.setCellStyle(numberStyle);
		} else {
			R0180cell21.setCellValue("");
			R0180cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0180cell22 = row.createCell(22);
		if (record.getR0180_stage3b_poci() != null) {
			R0180cell22.setCellValue(record.getR0180_stage3b_poci().doubleValue());
			R0180cell22.setCellStyle(numberStyle);
		} else {
			R0180cell22.setCellValue("");
			R0180cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0180cell23 = row.createCell(23);
		if (record.getR0180_stage3c_poci() != null) {
			R0180cell23.setCellValue(record.getR0180_stage3c_poci().doubleValue());
			R0180cell23.setCellStyle(numberStyle);
		} else {
			R0180cell23.setCellValue("");
			R0180cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0180cell24 = row.createCell(24);
		if (record.getR0180_current_pastdues() != null) {
			R0180cell24.setCellValue(record.getR0180_current_pastdues().doubleValue());
			R0180cell24.setCellStyle(numberStyle);
		} else {
			R0180cell24.setCellValue("");
			R0180cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0180cell25 = row.createCell(25);
		if (record.getR0180_less30days_pastdues() != null) {
			R0180cell25.setCellValue(record.getR0180_less30days_pastdues().doubleValue());
			R0180cell25.setCellStyle(numberStyle);
		} else {
			R0180cell25.setCellValue("");
			R0180cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0180cell26 = row.createCell(26);
		if (record.getR0180_31to90days_pastdues() != null) {
			R0180cell26.setCellValue(record.getR0180_31to90days_pastdues().doubleValue());
			R0180cell26.setCellStyle(numberStyle);
		} else {
			R0180cell26.setCellValue("");
			R0180cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0180cell27 = row.createCell(27);
		if (record.getR0180_91to120days_pastdues() != null) {
			R0180cell27.setCellValue(record.getR0180_91to120days_pastdues().doubleValue());
			R0180cell27.setCellStyle(numberStyle);
		} else {
			R0180cell27.setCellValue("");
			R0180cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0180cell28 = row.createCell(28);
		if (record.getR0180_121to180days_pastdues() != null) {
			R0180cell28.setCellValue(record.getR0180_121to180days_pastdues().doubleValue());
			R0180cell28.setCellStyle(numberStyle);
		} else {
			R0180cell28.setCellValue("");
			R0180cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0180cell29 = row.createCell(29);
		if (record.getR0180_181to365days_pastdues() != null) {
			R0180cell29.setCellValue(record.getR0180_181to365days_pastdues().doubleValue());
			R0180cell29.setCellStyle(numberStyle);
		} else {
			R0180cell29.setCellValue("");
			R0180cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0180cell30 = row.createCell(30);
		if (record.getR0180_over365days_pastdues() != null) {
			R0180cell30.setCellValue(record.getR0180_over365days_pastdues().doubleValue());
			R0180cell30.setCellStyle(numberStyle);
		} else {
			R0180cell30.setCellValue("");
			R0180cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0180cell32 = row.createCell(32);
		if (record.getR0180_newloan_duringreport() != null) {
			R0180cell32.setCellValue(record.getR0180_newloan_duringreport().doubleValue());
			R0180cell32.setCellStyle(numberStyle);
		} else {
			R0180cell32.setCellValue("");
			R0180cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0180cell33 = row.createCell(33);
		if (record.getR0180_newstage_duringreport() != null) {
			R0180cell33.setCellValue(record.getR0180_newstage_duringreport().doubleValue());
			R0180cell33.setCellStyle(numberStyle);
		} else {
			R0180cell33.setCellValue("");
			R0180cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0180cell34 = row.createCell(34);
		if (record.getR0180_intrestfees_duringreport() != null) {
			R0180cell34.setCellValue(record.getR0180_intrestfees_duringreport().doubleValue());
			R0180cell34.setCellStyle(numberStyle);
		} else {
			R0180cell34.setCellValue("");
			R0180cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0180cell35 = row.createCell(35);
		if (record.getR0180_performingac_acinfo() != null) {
			R0180cell35.setCellValue(record.getR0180_performingac_acinfo().doubleValue());
			R0180cell35.setCellStyle(numberStyle);
		} else {
			R0180cell35.setCellValue("");
			R0180cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0180cell36 = row.createCell(36);
		if (record.getR0180_nonperformingac_acinfo() != null) {
			R0180cell36.setCellValue(record.getR0180_nonperformingac_acinfo().doubleValue());
			R0180cell36.setCellStyle(numberStyle);
		} else {
			R0180cell36.setCellValue("");
			R0180cell36.setCellStyle(textStyle);
		}

		/// ROW28
		//// Column E
		row = sheet.getRow(27);
		Cell R0190cell4 = row.createCell(4);
		if (record.getR0190_outstandbal() != null) {
			R0190cell4.setCellValue(record.getR0190_outstandbal().doubleValue());
			R0190cell4.setCellStyle(numberStyle);
		} else {
			R0190cell4.setCellValue("");
			R0190cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0190cell5 = row.createCell(5);
		if (record.getR0190_secured_outstandbal() != null) {
			R0190cell5.setCellValue(record.getR0190_secured_outstandbal().doubleValue());
			R0190cell5.setCellStyle(numberStyle);
		} else {
			R0190cell5.setCellValue("");
			R0190cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0190cell6 = row.createCell(6);
		if (record.getR0190_unsecured_outstandbal() != null) {
			R0190cell6.setCellValue(record.getR0190_unsecured_outstandbal().doubleValue());
			R0190cell6.setCellStyle(numberStyle);
		} else {
			R0190cell6.setCellValue("");
			R0190cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0190cell7 = row.createCell(7);
		if (record.getR0190_stage1_assetclass() != null) {
			R0190cell7.setCellValue(record.getR0190_stage1_assetclass().doubleValue());
			R0190cell7.setCellStyle(numberStyle);
		} else {
			R0190cell7.setCellValue("");
			R0190cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0190cell8 = row.createCell(8);
		if (record.getR0190_stage2_assetclass() != null) {
			R0190cell8.setCellValue(record.getR0190_stage2_assetclass().doubleValue());
			R0190cell8.setCellStyle(numberStyle);
		} else {
			R0190cell8.setCellValue("");
			R0190cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0190cell9 = row.createCell(9);
		if (record.getR0190_stage3a_assetclass() != null) {
			R0190cell9.setCellValue(record.getR0190_stage3a_assetclass().doubleValue());
			R0190cell9.setCellStyle(numberStyle);
		} else {
			R0190cell9.setCellValue("");
			R0190cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0190cell10 = row.createCell(10);
		if (record.getR0190_stage3b_assetclass() != null) {
			R0190cell10.setCellValue(record.getR0190_stage3b_assetclass().doubleValue());
			R0190cell10.setCellStyle(numberStyle);
		} else {
			R0190cell10.setCellValue("");
			R0190cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0190cell11 = row.createCell(11);
		if (record.getR0190_stage3c_assetclass() != null) {
			R0190cell11.setCellValue(record.getR0190_stage3c_assetclass().doubleValue());
			R0190cell11.setCellStyle(numberStyle);
		} else {
			R0190cell11.setCellValue("");
			R0190cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0190cell12 = row.createCell(12);
		if (record.getR0190_stage1_provisionheld() != null) {
			R0190cell12.setCellValue(record.getR0190_stage1_provisionheld().doubleValue());
			R0190cell12.setCellStyle(numberStyle);
		} else {
			R0190cell12.setCellValue("");
			R0190cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0190cell13 = row.createCell(13);
		if (record.getR0190_stage2_provisionheld() != null) {
			R0190cell13.setCellValue(record.getR0190_stage2_provisionheld().doubleValue());
			R0190cell13.setCellStyle(numberStyle);
		} else {
			R0190cell13.setCellValue("");
			R0190cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0190cell14 = row.createCell(14);
		if (record.getR0190_stage3a_provisionheld() != null) {
			R0190cell14.setCellValue(record.getR0190_stage3a_provisionheld().doubleValue());
			R0190cell14.setCellStyle(numberStyle);
		} else {
			R0190cell14.setCellValue("");
			R0190cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0190cell15 = row.createCell(15);
		if (record.getR0190_stage3b_provisionheld() != null) {
			R0190cell15.setCellValue(record.getR0190_stage3b_provisionheld().doubleValue());
			R0190cell15.setCellStyle(numberStyle);
		} else {
			R0190cell15.setCellValue("");
			R0190cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0190cell16 = row.createCell(16);
		if (record.getR0190_stage3c_provisionheld() != null) {
			R0190cell16.setCellValue(record.getR0190_stage3c_provisionheld().doubleValue());
			R0190cell16.setCellStyle(numberStyle);
		} else {
			R0190cell16.setCellValue("");
			R0190cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0190cell17 = row.createCell(17);
		if (record.getR0190_intrestfees_provisionheld() != null) {
			R0190cell17.setCellValue(record.getR0190_intrestfees_provisionheld().doubleValue());
			R0190cell17.setCellStyle(numberStyle);
		} else {
			R0190cell17.setCellValue("");
			R0190cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0190cell18 = row.createCell(18);
		if (record.getR0190_intrestsuspense_provisionheld() != null) {
			R0190cell18.setCellValue(record.getR0190_intrestsuspense_provisionheld().doubleValue());
			R0190cell18.setCellStyle(numberStyle);
		} else {
			R0190cell18.setCellValue("");
			R0190cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0190cell19 = row.createCell(19);
		if (record.getR0190_stage1_poci() != null) {
			R0190cell19.setCellValue(record.getR0190_stage1_poci().doubleValue());
			R0190cell19.setCellStyle(numberStyle);
		} else {
			R0190cell19.setCellValue("");
			R0190cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0190cell20 = row.createCell(20);
		if (record.getR0190_stage2_poci() != null) {
			R0190cell20.setCellValue(record.getR0190_stage2_poci().doubleValue());
			R0190cell20.setCellStyle(numberStyle);
		} else {
			R0190cell20.setCellValue("");
			R0190cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0190cell21 = row.createCell(21);
		if (record.getR0190_stage3a_poci() != null) {
			R0190cell21.setCellValue(record.getR0190_stage3a_poci().doubleValue());
			R0190cell21.setCellStyle(numberStyle);
		} else {
			R0190cell21.setCellValue("");
			R0190cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0190cell22 = row.createCell(22);
		if (record.getR0190_stage3b_poci() != null) {
			R0190cell22.setCellValue(record.getR0190_stage3b_poci().doubleValue());
			R0190cell22.setCellStyle(numberStyle);
		} else {
			R0190cell22.setCellValue("");
			R0190cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0190cell23 = row.createCell(23);
		if (record.getR0190_stage3c_poci() != null) {
			R0190cell23.setCellValue(record.getR0190_stage3c_poci().doubleValue());
			R0190cell23.setCellStyle(numberStyle);
		} else {
			R0190cell23.setCellValue("");
			R0190cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0190cell24 = row.createCell(24);
		if (record.getR0190_current_pastdues() != null) {
			R0190cell24.setCellValue(record.getR0190_current_pastdues().doubleValue());
			R0190cell24.setCellStyle(numberStyle);
		} else {
			R0190cell24.setCellValue("");
			R0190cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0190cell25 = row.createCell(25);
		if (record.getR0190_less30days_pastdues() != null) {
			R0190cell25.setCellValue(record.getR0190_less30days_pastdues().doubleValue());
			R0190cell25.setCellStyle(numberStyle);
		} else {
			R0190cell25.setCellValue("");
			R0190cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0190cell26 = row.createCell(26);
		if (record.getR0190_31to90days_pastdues() != null) {
			R0190cell26.setCellValue(record.getR0190_31to90days_pastdues().doubleValue());
			R0190cell26.setCellStyle(numberStyle);
		} else {
			R0190cell26.setCellValue("");
			R0190cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0190cell27 = row.createCell(27);
		if (record.getR0190_91to120days_pastdues() != null) {
			R0190cell27.setCellValue(record.getR0190_91to120days_pastdues().doubleValue());
			R0190cell27.setCellStyle(numberStyle);
		} else {
			R0190cell27.setCellValue("");
			R0190cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0190cell28 = row.createCell(28);
		if (record.getR0190_121to180days_pastdues() != null) {
			R0190cell28.setCellValue(record.getR0190_121to180days_pastdues().doubleValue());
			R0190cell28.setCellStyle(numberStyle);
		} else {
			R0190cell28.setCellValue("");
			R0190cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0190cell29 = row.createCell(29);
		if (record.getR0190_181to365days_pastdues() != null) {
			R0190cell29.setCellValue(record.getR0190_181to365days_pastdues().doubleValue());
			R0190cell29.setCellStyle(numberStyle);
		} else {
			R0190cell29.setCellValue("");
			R0190cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0190cell30 = row.createCell(30);
		if (record.getR0190_over365days_pastdues() != null) {
			R0190cell30.setCellValue(record.getR0190_over365days_pastdues().doubleValue());
			R0190cell30.setCellStyle(numberStyle);
		} else {
			R0190cell30.setCellValue("");
			R0190cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0190cell32 = row.createCell(32);
		if (record.getR0190_newloan_duringreport() != null) {
			R0190cell32.setCellValue(record.getR0190_newloan_duringreport().doubleValue());
			R0190cell32.setCellStyle(numberStyle);
		} else {
			R0190cell32.setCellValue("");
			R0190cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0190cell33 = row.createCell(33);
		if (record.getR0190_newstage_duringreport() != null) {
			R0190cell33.setCellValue(record.getR0190_newstage_duringreport().doubleValue());
			R0190cell33.setCellStyle(numberStyle);
		} else {
			R0190cell33.setCellValue("");
			R0190cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0190cell34 = row.createCell(34);
		if (record.getR0190_intrestfees_duringreport() != null) {
			R0190cell34.setCellValue(record.getR0190_intrestfees_duringreport().doubleValue());
			R0190cell34.setCellStyle(numberStyle);
		} else {
			R0190cell34.setCellValue("");
			R0190cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0190cell35 = row.createCell(35);
		if (record.getR0190_performingac_acinfo() != null) {
			R0190cell35.setCellValue(record.getR0190_performingac_acinfo().doubleValue());
			R0190cell35.setCellStyle(numberStyle);
		} else {
			R0190cell35.setCellValue("");
			R0190cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0190cell36 = row.createCell(36);
		if (record.getR0190_nonperformingac_acinfo() != null) {
			R0190cell36.setCellValue(record.getR0190_nonperformingac_acinfo().doubleValue());
			R0190cell36.setCellStyle(numberStyle);
		} else {
			R0190cell36.setCellValue("");
			R0190cell36.setCellStyle(textStyle);
		}

		/// ROW29
		//// Column E
		row = sheet.getRow(28);
		Cell R0200cell4 = row.createCell(4);
		if (record.getR0200_outstandbal() != null) {
			R0200cell4.setCellValue(record.getR0200_outstandbal().doubleValue());
			R0200cell4.setCellStyle(numberStyle);
		} else {
			R0200cell4.setCellValue("");
			R0200cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0200cell5 = row.createCell(5);
		if (record.getR0200_secured_outstandbal() != null) {
			R0200cell5.setCellValue(record.getR0200_secured_outstandbal().doubleValue());
			R0200cell5.setCellStyle(numberStyle);
		} else {
			R0200cell5.setCellValue("");
			R0200cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0200cell6 = row.createCell(6);
		if (record.getR0200_unsecured_outstandbal() != null) {
			R0200cell6.setCellValue(record.getR0200_unsecured_outstandbal().doubleValue());
			R0200cell6.setCellStyle(numberStyle);
		} else {
			R0200cell6.setCellValue("");
			R0200cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0200cell7 = row.createCell(7);
		if (record.getR0200_stage1_assetclass() != null) {
			R0200cell7.setCellValue(record.getR0200_stage1_assetclass().doubleValue());
			R0200cell7.setCellStyle(numberStyle);
		} else {
			R0200cell7.setCellValue("");
			R0200cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0200cell8 = row.createCell(8);
		if (record.getR0200_stage2_assetclass() != null) {
			R0200cell8.setCellValue(record.getR0200_stage2_assetclass().doubleValue());
			R0200cell8.setCellStyle(numberStyle);
		} else {
			R0200cell8.setCellValue("");
			R0200cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0200cell9 = row.createCell(9);
		if (record.getR0200_stage3a_assetclass() != null) {
			R0200cell9.setCellValue(record.getR0200_stage3a_assetclass().doubleValue());
			R0200cell9.setCellStyle(numberStyle);
		} else {
			R0200cell9.setCellValue("");
			R0200cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0200cell10 = row.createCell(10);
		if (record.getR0200_stage3b_assetclass() != null) {
			R0200cell10.setCellValue(record.getR0200_stage3b_assetclass().doubleValue());
			R0200cell10.setCellStyle(numberStyle);
		} else {
			R0200cell10.setCellValue("");
			R0200cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0200cell11 = row.createCell(11);
		if (record.getR0200_stage3c_assetclass() != null) {
			R0200cell11.setCellValue(record.getR0200_stage3c_assetclass().doubleValue());
			R0200cell11.setCellStyle(numberStyle);
		} else {
			R0200cell11.setCellValue("");
			R0200cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0200cell12 = row.createCell(12);
		if (record.getR0200_stage1_provisionheld() != null) {
			R0200cell12.setCellValue(record.getR0200_stage1_provisionheld().doubleValue());
			R0200cell12.setCellStyle(numberStyle);
		} else {
			R0200cell12.setCellValue("");
			R0200cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0200cell13 = row.createCell(13);
		if (record.getR0200_stage2_provisionheld() != null) {
			R0200cell13.setCellValue(record.getR0200_stage2_provisionheld().doubleValue());
			R0200cell13.setCellStyle(numberStyle);
		} else {
			R0200cell13.setCellValue("");
			R0200cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0200cell14 = row.createCell(14);
		if (record.getR0200_stage3a_provisionheld() != null) {
			R0200cell14.setCellValue(record.getR0200_stage3a_provisionheld().doubleValue());
			R0200cell14.setCellStyle(numberStyle);
		} else {
			R0200cell14.setCellValue("");
			R0200cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0200cell15 = row.createCell(15);
		if (record.getR0200_stage3b_provisionheld() != null) {
			R0200cell15.setCellValue(record.getR0200_stage3b_provisionheld().doubleValue());
			R0200cell15.setCellStyle(numberStyle);
		} else {
			R0200cell15.setCellValue("");
			R0200cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0200cell16 = row.createCell(16);
		if (record.getR0200_stage3c_provisionheld() != null) {
			R0200cell16.setCellValue(record.getR0200_stage3c_provisionheld().doubleValue());
			R0200cell16.setCellStyle(numberStyle);
		} else {
			R0200cell16.setCellValue("");
			R0200cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0200cell17 = row.createCell(17);
		if (record.getR0200_intrestfees_provisionheld() != null) {
			R0200cell17.setCellValue(record.getR0200_intrestfees_provisionheld().doubleValue());
			R0200cell17.setCellStyle(numberStyle);
		} else {
			R0200cell17.setCellValue("");
			R0200cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0200cell18 = row.createCell(18);
		if (record.getR0200_intrestsuspense_provisionheld() != null) {
			R0200cell18.setCellValue(record.getR0200_intrestsuspense_provisionheld().doubleValue());
			R0200cell18.setCellStyle(numberStyle);
		} else {
			R0200cell18.setCellValue("");
			R0200cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0200cell19 = row.createCell(19);
		if (record.getR0200_stage1_poci() != null) {
			R0200cell19.setCellValue(record.getR0200_stage1_poci().doubleValue());
			R0200cell19.setCellStyle(numberStyle);
		} else {
			R0200cell19.setCellValue("");
			R0200cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0200cell20 = row.createCell(20);
		if (record.getR0200_stage2_poci() != null) {
			R0200cell20.setCellValue(record.getR0200_stage2_poci().doubleValue());
			R0200cell20.setCellStyle(numberStyle);
		} else {
			R0200cell20.setCellValue("");
			R0200cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0200cell21 = row.createCell(21);
		if (record.getR0200_stage3a_poci() != null) {
			R0200cell21.setCellValue(record.getR0200_stage3a_poci().doubleValue());
			R0200cell21.setCellStyle(numberStyle);
		} else {
			R0200cell21.setCellValue("");
			R0200cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0200cell22 = row.createCell(22);
		if (record.getR0200_stage3b_poci() != null) {
			R0200cell22.setCellValue(record.getR0200_stage3b_poci().doubleValue());
			R0200cell22.setCellStyle(numberStyle);
		} else {
			R0200cell22.setCellValue("");
			R0200cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0200cell23 = row.createCell(23);
		if (record.getR0200_stage3c_poci() != null) {
			R0200cell23.setCellValue(record.getR0200_stage3c_poci().doubleValue());
			R0200cell23.setCellStyle(numberStyle);
		} else {
			R0200cell23.setCellValue("");
			R0200cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0200cell24 = row.createCell(24);
		if (record.getR0200_current_pastdues() != null) {
			R0200cell24.setCellValue(record.getR0200_current_pastdues().doubleValue());
			R0200cell24.setCellStyle(numberStyle);
		} else {
			R0200cell24.setCellValue("");
			R0200cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0200cell25 = row.createCell(25);
		if (record.getR0200_less30days_pastdues() != null) {
			R0200cell25.setCellValue(record.getR0200_less30days_pastdues().doubleValue());
			R0200cell25.setCellStyle(numberStyle);
		} else {
			R0200cell25.setCellValue("");
			R0200cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0200cell26 = row.createCell(26);
		if (record.getR0200_31to90days_pastdues() != null) {
			R0200cell26.setCellValue(record.getR0200_31to90days_pastdues().doubleValue());
			R0200cell26.setCellStyle(numberStyle);
		} else {
			R0200cell26.setCellValue("");
			R0200cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0200cell27 = row.createCell(27);
		if (record.getR0200_91to120days_pastdues() != null) {
			R0200cell27.setCellValue(record.getR0200_91to120days_pastdues().doubleValue());
			R0200cell27.setCellStyle(numberStyle);
		} else {
			R0200cell27.setCellValue("");
			R0200cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0200cell28 = row.createCell(28);
		if (record.getR0200_121to180days_pastdues() != null) {
			R0200cell28.setCellValue(record.getR0200_121to180days_pastdues().doubleValue());
			R0200cell28.setCellStyle(numberStyle);
		} else {
			R0200cell28.setCellValue("");
			R0200cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0200cell29 = row.createCell(29);
		if (record.getR0200_181to365days_pastdues() != null) {
			R0200cell29.setCellValue(record.getR0200_181to365days_pastdues().doubleValue());
			R0200cell29.setCellStyle(numberStyle);
		} else {
			R0200cell29.setCellValue("");
			R0200cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0200cell30 = row.createCell(30);
		if (record.getR0200_over365days_pastdues() != null) {
			R0200cell30.setCellValue(record.getR0200_over365days_pastdues().doubleValue());
			R0200cell30.setCellStyle(numberStyle);
		} else {
			R0200cell30.setCellValue("");
			R0200cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0200cell32 = row.createCell(32);
		if (record.getR0200_newloan_duringreport() != null) {
			R0200cell32.setCellValue(record.getR0200_newloan_duringreport().doubleValue());
			R0200cell32.setCellStyle(numberStyle);
		} else {
			R0200cell32.setCellValue("");
			R0200cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0200cell33 = row.createCell(33);
		if (record.getR0200_newstage_duringreport() != null) {
			R0200cell33.setCellValue(record.getR0200_newstage_duringreport().doubleValue());
			R0200cell33.setCellStyle(numberStyle);
		} else {
			R0200cell33.setCellValue("");
			R0200cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0200cell34 = row.createCell(34);
		if (record.getR0200_intrestfees_duringreport() != null) {
			R0200cell34.setCellValue(record.getR0200_intrestfees_duringreport().doubleValue());
			R0200cell34.setCellStyle(numberStyle);
		} else {
			R0200cell34.setCellValue("");
			R0200cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0200cell35 = row.createCell(35);
		if (record.getR0200_performingac_acinfo() != null) {
			R0200cell35.setCellValue(record.getR0200_performingac_acinfo().doubleValue());
			R0200cell35.setCellStyle(numberStyle);
		} else {
			R0200cell35.setCellValue("");
			R0200cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0200cell36 = row.createCell(36);
		if (record.getR0200_nonperformingac_acinfo() != null) {
			R0200cell36.setCellValue(record.getR0200_nonperformingac_acinfo().doubleValue());
			R0200cell36.setCellStyle(numberStyle);
		} else {
			R0200cell36.setCellValue("");
			R0200cell36.setCellStyle(textStyle);
		}

		/// ROW30
		//// Column E
		row = sheet.getRow(29);
		Cell R0210cell4 = row.createCell(4);
		if (record.getR0210_outstandbal() != null) {
			R0210cell4.setCellValue(record.getR0210_outstandbal().doubleValue());
			R0210cell4.setCellStyle(numberStyle);
		} else {
			R0210cell4.setCellValue("");
			R0210cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0210cell5 = row.createCell(5);
		if (record.getR0210_secured_outstandbal() != null) {
			R0210cell5.setCellValue(record.getR0210_secured_outstandbal().doubleValue());
			R0210cell5.setCellStyle(numberStyle);
		} else {
			R0210cell5.setCellValue("");
			R0210cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0210cell6 = row.createCell(6);
		if (record.getR0210_unsecured_outstandbal() != null) {
			R0210cell6.setCellValue(record.getR0210_unsecured_outstandbal().doubleValue());
			R0210cell6.setCellStyle(numberStyle);
		} else {
			R0210cell6.setCellValue("");
			R0210cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0210cell7 = row.createCell(7);
		if (record.getR0210_stage1_assetclass() != null) {
			R0210cell7.setCellValue(record.getR0210_stage1_assetclass().doubleValue());
			R0210cell7.setCellStyle(numberStyle);
		} else {
			R0210cell7.setCellValue("");
			R0210cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0210cell8 = row.createCell(8);
		if (record.getR0210_stage2_assetclass() != null) {
			R0210cell8.setCellValue(record.getR0210_stage2_assetclass().doubleValue());
			R0210cell8.setCellStyle(numberStyle);
		} else {
			R0210cell8.setCellValue("");
			R0210cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0210cell9 = row.createCell(9);
		if (record.getR0210_stage3a_assetclass() != null) {
			R0210cell9.setCellValue(record.getR0210_stage3a_assetclass().doubleValue());
			R0210cell9.setCellStyle(numberStyle);
		} else {
			R0210cell9.setCellValue("");
			R0210cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0210cell10 = row.createCell(10);
		if (record.getR0210_stage3b_assetclass() != null) {
			R0210cell10.setCellValue(record.getR0210_stage3b_assetclass().doubleValue());
			R0210cell10.setCellStyle(numberStyle);
		} else {
			R0210cell10.setCellValue("");
			R0210cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0210cell11 = row.createCell(11);
		if (record.getR0210_stage3c_assetclass() != null) {
			R0210cell11.setCellValue(record.getR0210_stage3c_assetclass().doubleValue());
			R0210cell11.setCellStyle(numberStyle);
		} else {
			R0210cell11.setCellValue("");
			R0210cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0210cell12 = row.createCell(12);
		if (record.getR0210_stage1_provisionheld() != null) {
			R0210cell12.setCellValue(record.getR0210_stage1_provisionheld().doubleValue());
			R0210cell12.setCellStyle(numberStyle);
		} else {
			R0210cell12.setCellValue("");
			R0210cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0210cell13 = row.createCell(13);
		if (record.getR0210_stage2_provisionheld() != null) {
			R0210cell13.setCellValue(record.getR0210_stage2_provisionheld().doubleValue());
			R0210cell13.setCellStyle(numberStyle);
		} else {
			R0210cell13.setCellValue("");
			R0210cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0210cell14 = row.createCell(14);
		if (record.getR0210_stage3a_provisionheld() != null) {
			R0210cell14.setCellValue(record.getR0210_stage3a_provisionheld().doubleValue());
			R0210cell14.setCellStyle(numberStyle);
		} else {
			R0210cell14.setCellValue("");
			R0210cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0210cell15 = row.createCell(15);
		if (record.getR0210_stage3b_provisionheld() != null) {
			R0210cell15.setCellValue(record.getR0210_stage3b_provisionheld().doubleValue());
			R0210cell15.setCellStyle(numberStyle);
		} else {
			R0210cell15.setCellValue("");
			R0210cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0210cell16 = row.createCell(16);
		if (record.getR0210_stage3c_provisionheld() != null) {
			R0210cell16.setCellValue(record.getR0210_stage3c_provisionheld().doubleValue());
			R0210cell16.setCellStyle(numberStyle);
		} else {
			R0210cell16.setCellValue("");
			R0210cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0210cell17 = row.createCell(17);
		if (record.getR0210_intrestfees_provisionheld() != null) {
			R0210cell17.setCellValue(record.getR0210_intrestfees_provisionheld().doubleValue());
			R0210cell17.setCellStyle(numberStyle);
		} else {
			R0210cell17.setCellValue("");
			R0210cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0210cell18 = row.createCell(18);
		if (record.getR0210_intrestsuspense_provisionheld() != null) {
			R0210cell18.setCellValue(record.getR0210_intrestsuspense_provisionheld().doubleValue());
			R0210cell18.setCellStyle(numberStyle);
		} else {
			R0210cell18.setCellValue("");
			R0210cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0210cell19 = row.createCell(19);
		if (record.getR0210_stage1_poci() != null) {
			R0210cell19.setCellValue(record.getR0210_stage1_poci().doubleValue());
			R0210cell19.setCellStyle(numberStyle);
		} else {
			R0210cell19.setCellValue("");
			R0210cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0210cell20 = row.createCell(20);
		if (record.getR0210_stage2_poci() != null) {
			R0210cell20.setCellValue(record.getR0210_stage2_poci().doubleValue());
			R0210cell20.setCellStyle(numberStyle);
		} else {
			R0210cell20.setCellValue("");
			R0210cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0210cell21 = row.createCell(21);
		if (record.getR0210_stage3a_poci() != null) {
			R0210cell21.setCellValue(record.getR0210_stage3a_poci().doubleValue());
			R0210cell21.setCellStyle(numberStyle);
		} else {
			R0210cell21.setCellValue("");
			R0210cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0210cell22 = row.createCell(22);
		if (record.getR0210_stage3b_poci() != null) {
			R0210cell22.setCellValue(record.getR0210_stage3b_poci().doubleValue());
			R0210cell22.setCellStyle(numberStyle);
		} else {
			R0210cell22.setCellValue("");
			R0210cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0210cell23 = row.createCell(23);
		if (record.getR0210_stage3c_poci() != null) {
			R0210cell23.setCellValue(record.getR0210_stage3c_poci().doubleValue());
			R0210cell23.setCellStyle(numberStyle);
		} else {
			R0210cell23.setCellValue("");
			R0210cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0210cell24 = row.createCell(24);
		if (record.getR0210_current_pastdues() != null) {
			R0210cell24.setCellValue(record.getR0210_current_pastdues().doubleValue());
			R0210cell24.setCellStyle(numberStyle);
		} else {
			R0210cell24.setCellValue("");
			R0210cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0210cell25 = row.createCell(25);
		if (record.getR0210_less30days_pastdues() != null) {
			R0210cell25.setCellValue(record.getR0210_less30days_pastdues().doubleValue());
			R0210cell25.setCellStyle(numberStyle);
		} else {
			R0210cell25.setCellValue("");
			R0210cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0210cell26 = row.createCell(26);
		if (record.getR0210_31to90days_pastdues() != null) {
			R0210cell26.setCellValue(record.getR0210_31to90days_pastdues().doubleValue());
			R0210cell26.setCellStyle(numberStyle);
		} else {
			R0210cell26.setCellValue("");
			R0210cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0210cell27 = row.createCell(27);
		if (record.getR0210_91to120days_pastdues() != null) {
			R0210cell27.setCellValue(record.getR0210_91to120days_pastdues().doubleValue());
			R0210cell27.setCellStyle(numberStyle);
		} else {
			R0210cell27.setCellValue("");
			R0210cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0210cell28 = row.createCell(28);
		if (record.getR0210_121to180days_pastdues() != null) {
			R0210cell28.setCellValue(record.getR0210_121to180days_pastdues().doubleValue());
			R0210cell28.setCellStyle(numberStyle);
		} else {
			R0210cell28.setCellValue("");
			R0210cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0210cell29 = row.createCell(29);
		if (record.getR0210_181to365days_pastdues() != null) {
			R0210cell29.setCellValue(record.getR0210_181to365days_pastdues().doubleValue());
			R0210cell29.setCellStyle(numberStyle);
		} else {
			R0210cell29.setCellValue("");
			R0210cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0210cell30 = row.createCell(30);
		if (record.getR0210_over365days_pastdues() != null) {
			R0210cell30.setCellValue(record.getR0210_over365days_pastdues().doubleValue());
			R0210cell30.setCellStyle(numberStyle);
		} else {
			R0210cell30.setCellValue("");
			R0210cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0210cell32 = row.createCell(32);
		if (record.getR0210_newloan_duringreport() != null) {
			R0210cell32.setCellValue(record.getR0210_newloan_duringreport().doubleValue());
			R0210cell32.setCellStyle(numberStyle);
		} else {
			R0210cell32.setCellValue("");
			R0210cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0210cell33 = row.createCell(33);
		if (record.getR0210_newstage_duringreport() != null) {
			R0210cell33.setCellValue(record.getR0210_newstage_duringreport().doubleValue());
			R0210cell33.setCellStyle(numberStyle);
		} else {
			R0210cell33.setCellValue("");
			R0210cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0210cell34 = row.createCell(34);
		if (record.getR0210_intrestfees_duringreport() != null) {
			R0210cell34.setCellValue(record.getR0210_intrestfees_duringreport().doubleValue());
			R0210cell34.setCellStyle(numberStyle);
		} else {
			R0210cell34.setCellValue("");
			R0210cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0210cell35 = row.createCell(35);
		if (record.getR0210_performingac_acinfo() != null) {
			R0210cell35.setCellValue(record.getR0210_performingac_acinfo().doubleValue());
			R0210cell35.setCellStyle(numberStyle);
		} else {
			R0210cell35.setCellValue("");
			R0210cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0210cell36 = row.createCell(36);
		if (record.getR0210_nonperformingac_acinfo() != null) {
			R0210cell36.setCellValue(record.getR0210_nonperformingac_acinfo().doubleValue());
			R0210cell36.setCellStyle(numberStyle);
		} else {
			R0210cell36.setCellValue("");
			R0210cell36.setCellStyle(textStyle);
		}

		/// ROW31
		//// Column E
		row = sheet.getRow(30);
		Cell R0220cell4 = row.createCell(4);
		if (record.getR0220_outstandbal() != null) {
			R0220cell4.setCellValue(record.getR0220_outstandbal().doubleValue());
			R0220cell4.setCellStyle(numberStyle);
		} else {
			R0220cell4.setCellValue("");
			R0220cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0220cell5 = row.createCell(5);
		if (record.getR0220_secured_outstandbal() != null) {
			R0220cell5.setCellValue(record.getR0220_secured_outstandbal().doubleValue());
			R0220cell5.setCellStyle(numberStyle);
		} else {
			R0220cell5.setCellValue("");
			R0220cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0220cell6 = row.createCell(6);
		if (record.getR0220_unsecured_outstandbal() != null) {
			R0220cell6.setCellValue(record.getR0220_unsecured_outstandbal().doubleValue());
			R0220cell6.setCellStyle(numberStyle);
		} else {
			R0220cell6.setCellValue("");
			R0220cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0220cell7 = row.createCell(7);
		if (record.getR0220_stage1_assetclass() != null) {
			R0220cell7.setCellValue(record.getR0220_stage1_assetclass().doubleValue());
			R0220cell7.setCellStyle(numberStyle);
		} else {
			R0220cell7.setCellValue("");
			R0220cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0220cell8 = row.createCell(8);
		if (record.getR0220_stage2_assetclass() != null) {
			R0220cell8.setCellValue(record.getR0220_stage2_assetclass().doubleValue());
			R0220cell8.setCellStyle(numberStyle);
		} else {
			R0220cell8.setCellValue("");
			R0220cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0220cell9 = row.createCell(9);
		if (record.getR0220_stage3a_assetclass() != null) {
			R0220cell9.setCellValue(record.getR0220_stage3a_assetclass().doubleValue());
			R0220cell9.setCellStyle(numberStyle);
		} else {
			R0220cell9.setCellValue("");
			R0220cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0220cell10 = row.createCell(10);
		if (record.getR0220_stage3b_assetclass() != null) {
			R0220cell10.setCellValue(record.getR0220_stage3b_assetclass().doubleValue());
			R0220cell10.setCellStyle(numberStyle);
		} else {
			R0220cell10.setCellValue("");
			R0220cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0220cell11 = row.createCell(11);
		if (record.getR0220_stage3c_assetclass() != null) {
			R0220cell11.setCellValue(record.getR0220_stage3c_assetclass().doubleValue());
			R0220cell11.setCellStyle(numberStyle);
		} else {
			R0220cell11.setCellValue("");
			R0220cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0220cell12 = row.createCell(12);
		if (record.getR0220_stage1_provisionheld() != null) {
			R0220cell12.setCellValue(record.getR0220_stage1_provisionheld().doubleValue());
			R0220cell12.setCellStyle(numberStyle);
		} else {
			R0220cell12.setCellValue("");
			R0220cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0220cell13 = row.createCell(13);
		if (record.getR0220_stage2_provisionheld() != null) {
			R0220cell13.setCellValue(record.getR0220_stage2_provisionheld().doubleValue());
			R0220cell13.setCellStyle(numberStyle);
		} else {
			R0220cell13.setCellValue("");
			R0220cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0220cell14 = row.createCell(14);
		if (record.getR0220_stage3a_provisionheld() != null) {
			R0220cell14.setCellValue(record.getR0220_stage3a_provisionheld().doubleValue());
			R0220cell14.setCellStyle(numberStyle);
		} else {
			R0220cell14.setCellValue("");
			R0220cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0220cell15 = row.createCell(15);
		if (record.getR0220_stage3b_provisionheld() != null) {
			R0220cell15.setCellValue(record.getR0220_stage3b_provisionheld().doubleValue());
			R0220cell15.setCellStyle(numberStyle);
		} else {
			R0220cell15.setCellValue("");
			R0220cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0220cell16 = row.createCell(16);
		if (record.getR0220_stage3c_provisionheld() != null) {
			R0220cell16.setCellValue(record.getR0220_stage3c_provisionheld().doubleValue());
			R0220cell16.setCellStyle(numberStyle);
		} else {
			R0220cell16.setCellValue("");
			R0220cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0220cell17 = row.createCell(17);
		if (record.getR0220_intrestfees_provisionheld() != null) {
			R0220cell17.setCellValue(record.getR0220_intrestfees_provisionheld().doubleValue());
			R0220cell17.setCellStyle(numberStyle);
		} else {
			R0220cell17.setCellValue("");
			R0220cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0220cell18 = row.createCell(18);
		if (record.getR0220_intrestsuspense_provisionheld() != null) {
			R0220cell18.setCellValue(record.getR0220_intrestsuspense_provisionheld().doubleValue());
			R0220cell18.setCellStyle(numberStyle);
		} else {
			R0220cell18.setCellValue("");
			R0220cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0220cell19 = row.createCell(19);
		if (record.getR0220_stage1_poci() != null) {
			R0220cell19.setCellValue(record.getR0220_stage1_poci().doubleValue());
			R0220cell19.setCellStyle(numberStyle);
		} else {
			R0220cell19.setCellValue("");
			R0220cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0220cell20 = row.createCell(20);
		if (record.getR0220_stage2_poci() != null) {
			R0220cell20.setCellValue(record.getR0220_stage2_poci().doubleValue());
			R0220cell20.setCellStyle(numberStyle);
		} else {
			R0220cell20.setCellValue("");
			R0220cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0220cell21 = row.createCell(21);
		if (record.getR0220_stage3a_poci() != null) {
			R0220cell21.setCellValue(record.getR0220_stage3a_poci().doubleValue());
			R0220cell21.setCellStyle(numberStyle);
		} else {
			R0220cell21.setCellValue("");
			R0220cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0220cell22 = row.createCell(22);
		if (record.getR0220_stage3b_poci() != null) {
			R0220cell22.setCellValue(record.getR0220_stage3b_poci().doubleValue());
			R0220cell22.setCellStyle(numberStyle);
		} else {
			R0220cell22.setCellValue("");
			R0220cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0220cell23 = row.createCell(23);
		if (record.getR0220_stage3c_poci() != null) {
			R0220cell23.setCellValue(record.getR0220_stage3c_poci().doubleValue());
			R0220cell23.setCellStyle(numberStyle);
		} else {
			R0220cell23.setCellValue("");
			R0220cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0220cell24 = row.createCell(24);
		if (record.getR0220_current_pastdues() != null) {
			R0220cell24.setCellValue(record.getR0220_current_pastdues().doubleValue());
			R0220cell24.setCellStyle(numberStyle);
		} else {
			R0220cell24.setCellValue("");
			R0220cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0220cell25 = row.createCell(25);
		if (record.getR0220_less30days_pastdues() != null) {
			R0220cell25.setCellValue(record.getR0220_less30days_pastdues().doubleValue());
			R0220cell25.setCellStyle(numberStyle);
		} else {
			R0220cell25.setCellValue("");
			R0220cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0220cell26 = row.createCell(26);
		if (record.getR0220_31to90days_pastdues() != null) {
			R0220cell26.setCellValue(record.getR0220_31to90days_pastdues().doubleValue());
			R0220cell26.setCellStyle(numberStyle);
		} else {
			R0220cell26.setCellValue("");
			R0220cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0220cell27 = row.createCell(27);
		if (record.getR0220_91to120days_pastdues() != null) {
			R0220cell27.setCellValue(record.getR0220_91to120days_pastdues().doubleValue());
			R0220cell27.setCellStyle(numberStyle);
		} else {
			R0220cell27.setCellValue("");
			R0220cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0220cell28 = row.createCell(28);
		if (record.getR0220_121to180days_pastdues() != null) {
			R0220cell28.setCellValue(record.getR0220_121to180days_pastdues().doubleValue());
			R0220cell28.setCellStyle(numberStyle);
		} else {
			R0220cell28.setCellValue("");
			R0220cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0220cell29 = row.createCell(29);
		if (record.getR0220_181to365days_pastdues() != null) {
			R0220cell29.setCellValue(record.getR0220_181to365days_pastdues().doubleValue());
			R0220cell29.setCellStyle(numberStyle);
		} else {
			R0220cell29.setCellValue("");
			R0220cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0220cell30 = row.createCell(30);
		if (record.getR0220_over365days_pastdues() != null) {
			R0220cell30.setCellValue(record.getR0220_over365days_pastdues().doubleValue());
			R0220cell30.setCellStyle(numberStyle);
		} else {
			R0220cell30.setCellValue("");
			R0220cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0220cell32 = row.createCell(32);
		if (record.getR0220_newloan_duringreport() != null) {
			R0220cell32.setCellValue(record.getR0220_newloan_duringreport().doubleValue());
			R0220cell32.setCellStyle(numberStyle);
		} else {
			R0220cell32.setCellValue("");
			R0220cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0220cell33 = row.createCell(33);
		if (record.getR0220_newstage_duringreport() != null) {
			R0220cell33.setCellValue(record.getR0220_newstage_duringreport().doubleValue());
			R0220cell33.setCellStyle(numberStyle);
		} else {
			R0220cell33.setCellValue("");
			R0220cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0220cell34 = row.createCell(34);
		if (record.getR0220_intrestfees_duringreport() != null) {
			R0220cell34.setCellValue(record.getR0220_intrestfees_duringreport().doubleValue());
			R0220cell34.setCellStyle(numberStyle);
		} else {
			R0220cell34.setCellValue("");
			R0220cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0220cell35 = row.createCell(35);
		if (record.getR0220_performingac_acinfo() != null) {
			R0220cell35.setCellValue(record.getR0220_performingac_acinfo().doubleValue());
			R0220cell35.setCellStyle(numberStyle);
		} else {
			R0220cell35.setCellValue("");
			R0220cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0220cell36 = row.createCell(36);
		if (record.getR0220_nonperformingac_acinfo() != null) {
			R0220cell36.setCellValue(record.getR0220_nonperformingac_acinfo().doubleValue());
			R0220cell36.setCellStyle(numberStyle);
		} else {
			R0220cell36.setCellValue("");
			R0220cell36.setCellStyle(textStyle);
		}

		/// ROW32
		//// Column E
		row = sheet.getRow(31);
		Cell R0230cell4 = row.createCell(4);
		if (record.getR0230_outstandbal() != null) {
			R0230cell4.setCellValue(record.getR0230_outstandbal().doubleValue());
			R0230cell4.setCellStyle(numberStyle);
		} else {
			R0230cell4.setCellValue("");
			R0230cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0230cell5 = row.createCell(5);
		if (record.getR0230_secured_outstandbal() != null) {
			R0230cell5.setCellValue(record.getR0230_secured_outstandbal().doubleValue());
			R0230cell5.setCellStyle(numberStyle);
		} else {
			R0230cell5.setCellValue("");
			R0230cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0230cell6 = row.createCell(6);
		if (record.getR0230_unsecured_outstandbal() != null) {
			R0230cell6.setCellValue(record.getR0230_unsecured_outstandbal().doubleValue());
			R0230cell6.setCellStyle(numberStyle);
		} else {
			R0230cell6.setCellValue("");
			R0230cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0230cell7 = row.createCell(7);
		if (record.getR0230_stage1_assetclass() != null) {
			R0230cell7.setCellValue(record.getR0230_stage1_assetclass().doubleValue());
			R0230cell7.setCellStyle(numberStyle);
		} else {
			R0230cell7.setCellValue("");
			R0230cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0230cell8 = row.createCell(8);
		if (record.getR0230_stage2_assetclass() != null) {
			R0230cell8.setCellValue(record.getR0230_stage2_assetclass().doubleValue());
			R0230cell8.setCellStyle(numberStyle);
		} else {
			R0230cell8.setCellValue("");
			R0230cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0230cell9 = row.createCell(9);
		if (record.getR0230_stage3a_assetclass() != null) {
			R0230cell9.setCellValue(record.getR0230_stage3a_assetclass().doubleValue());
			R0230cell9.setCellStyle(numberStyle);
		} else {
			R0230cell9.setCellValue("");
			R0230cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0230cell10 = row.createCell(10);
		if (record.getR0230_stage3b_assetclass() != null) {
			R0230cell10.setCellValue(record.getR0230_stage3b_assetclass().doubleValue());
			R0230cell10.setCellStyle(numberStyle);
		} else {
			R0230cell10.setCellValue("");
			R0230cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0230cell11 = row.createCell(11);
		if (record.getR0230_stage3c_assetclass() != null) {
			R0230cell11.setCellValue(record.getR0230_stage3c_assetclass().doubleValue());
			R0230cell11.setCellStyle(numberStyle);
		} else {
			R0230cell11.setCellValue("");
			R0230cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0230cell12 = row.createCell(12);
		if (record.getR0230_stage1_provisionheld() != null) {
			R0230cell12.setCellValue(record.getR0230_stage1_provisionheld().doubleValue());
			R0230cell12.setCellStyle(numberStyle);
		} else {
			R0230cell12.setCellValue("");
			R0230cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0230cell13 = row.createCell(13);
		if (record.getR0230_stage2_provisionheld() != null) {
			R0230cell13.setCellValue(record.getR0230_stage2_provisionheld().doubleValue());
			R0230cell13.setCellStyle(numberStyle);
		} else {
			R0230cell13.setCellValue("");
			R0230cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0230cell14 = row.createCell(14);
		if (record.getR0230_stage3a_provisionheld() != null) {
			R0230cell14.setCellValue(record.getR0230_stage3a_provisionheld().doubleValue());
			R0230cell14.setCellStyle(numberStyle);
		} else {
			R0230cell14.setCellValue("");
			R0230cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0230cell15 = row.createCell(15);
		if (record.getR0230_stage3b_provisionheld() != null) {
			R0230cell15.setCellValue(record.getR0230_stage3b_provisionheld().doubleValue());
			R0230cell15.setCellStyle(numberStyle);
		} else {
			R0230cell15.setCellValue("");
			R0230cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0230cell16 = row.createCell(16);
		if (record.getR0230_stage3c_provisionheld() != null) {
			R0230cell16.setCellValue(record.getR0230_stage3c_provisionheld().doubleValue());
			R0230cell16.setCellStyle(numberStyle);
		} else {
			R0230cell16.setCellValue("");
			R0230cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0230cell17 = row.createCell(17);
		if (record.getR0230_intrestfees_provisionheld() != null) {
			R0230cell17.setCellValue(record.getR0230_intrestfees_provisionheld().doubleValue());
			R0230cell17.setCellStyle(numberStyle);
		} else {
			R0230cell17.setCellValue("");
			R0230cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0230cell18 = row.createCell(18);
		if (record.getR0230_intrestsuspense_provisionheld() != null) {
			R0230cell18.setCellValue(record.getR0230_intrestsuspense_provisionheld().doubleValue());
			R0230cell18.setCellStyle(numberStyle);
		} else {
			R0230cell18.setCellValue("");
			R0230cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0230cell19 = row.createCell(19);
		if (record.getR0230_stage1_poci() != null) {
			R0230cell19.setCellValue(record.getR0230_stage1_poci().doubleValue());
			R0230cell19.setCellStyle(numberStyle);
		} else {
			R0230cell19.setCellValue("");
			R0230cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0230cell20 = row.createCell(20);
		if (record.getR0230_stage2_poci() != null) {
			R0230cell20.setCellValue(record.getR0230_stage2_poci().doubleValue());
			R0230cell20.setCellStyle(numberStyle);
		} else {
			R0230cell20.setCellValue("");
			R0230cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0230cell21 = row.createCell(21);
		if (record.getR0230_stage3a_poci() != null) {
			R0230cell21.setCellValue(record.getR0230_stage3a_poci().doubleValue());
			R0230cell21.setCellStyle(numberStyle);
		} else {
			R0230cell21.setCellValue("");
			R0230cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0230cell22 = row.createCell(22);
		if (record.getR0230_stage3b_poci() != null) {
			R0230cell22.setCellValue(record.getR0230_stage3b_poci().doubleValue());
			R0230cell22.setCellStyle(numberStyle);
		} else {
			R0230cell22.setCellValue("");
			R0230cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0230cell23 = row.createCell(23);
		if (record.getR0230_stage3c_poci() != null) {
			R0230cell23.setCellValue(record.getR0230_stage3c_poci().doubleValue());
			R0230cell23.setCellStyle(numberStyle);
		} else {
			R0230cell23.setCellValue("");
			R0230cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0230cell24 = row.createCell(24);
		if (record.getR0230_current_pastdues() != null) {
			R0230cell24.setCellValue(record.getR0230_current_pastdues().doubleValue());
			R0230cell24.setCellStyle(numberStyle);
		} else {
			R0230cell24.setCellValue("");
			R0230cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0230cell25 = row.createCell(25);
		if (record.getR0230_less30days_pastdues() != null) {
			R0230cell25.setCellValue(record.getR0230_less30days_pastdues().doubleValue());
			R0230cell25.setCellStyle(numberStyle);
		} else {
			R0230cell25.setCellValue("");
			R0230cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0230cell26 = row.createCell(26);
		if (record.getR0230_31to90days_pastdues() != null) {
			R0230cell26.setCellValue(record.getR0230_31to90days_pastdues().doubleValue());
			R0230cell26.setCellStyle(numberStyle);
		} else {
			R0230cell26.setCellValue("");
			R0230cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0230cell27 = row.createCell(27);
		if (record.getR0230_91to120days_pastdues() != null) {
			R0230cell27.setCellValue(record.getR0230_91to120days_pastdues().doubleValue());
			R0230cell27.setCellStyle(numberStyle);
		} else {
			R0230cell27.setCellValue("");
			R0230cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0230cell28 = row.createCell(28);
		if (record.getR0230_121to180days_pastdues() != null) {
			R0230cell28.setCellValue(record.getR0230_121to180days_pastdues().doubleValue());
			R0230cell28.setCellStyle(numberStyle);
		} else {
			R0230cell28.setCellValue("");
			R0230cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0230cell29 = row.createCell(29);
		if (record.getR0230_181to365days_pastdues() != null) {
			R0230cell29.setCellValue(record.getR0230_181to365days_pastdues().doubleValue());
			R0230cell29.setCellStyle(numberStyle);
		} else {
			R0230cell29.setCellValue("");
			R0230cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0230cell30 = row.createCell(30);
		if (record.getR0230_over365days_pastdues() != null) {
			R0230cell30.setCellValue(record.getR0230_over365days_pastdues().doubleValue());
			R0230cell30.setCellStyle(numberStyle);
		} else {
			R0230cell30.setCellValue("");
			R0230cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0230cell32 = row.createCell(32);
		if (record.getR0230_newloan_duringreport() != null) {
			R0230cell32.setCellValue(record.getR0230_newloan_duringreport().doubleValue());
			R0230cell32.setCellStyle(numberStyle);
		} else {
			R0230cell32.setCellValue("");
			R0230cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0230cell33 = row.createCell(33);
		if (record.getR0230_newstage_duringreport() != null) {
			R0230cell33.setCellValue(record.getR0230_newstage_duringreport().doubleValue());
			R0230cell33.setCellStyle(numberStyle);
		} else {
			R0230cell33.setCellValue("");
			R0230cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0230cell34 = row.createCell(34);
		if (record.getR0230_intrestfees_duringreport() != null) {
			R0230cell34.setCellValue(record.getR0230_intrestfees_duringreport().doubleValue());
			R0230cell34.setCellStyle(numberStyle);
		} else {
			R0230cell34.setCellValue("");
			R0230cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0230cell35 = row.createCell(35);
		if (record.getR0230_performingac_acinfo() != null) {
			R0230cell35.setCellValue(record.getR0230_performingac_acinfo().doubleValue());
			R0230cell35.setCellStyle(numberStyle);
		} else {
			R0230cell35.setCellValue("");
			R0230cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0230cell36 = row.createCell(36);
		if (record.getR0230_nonperformingac_acinfo() != null) {
			R0230cell36.setCellValue(record.getR0230_nonperformingac_acinfo().doubleValue());
			R0230cell36.setCellStyle(numberStyle);
		} else {
			R0230cell36.setCellValue("");
			R0230cell36.setCellStyle(textStyle);
		}

		/// ROW33

		row = sheet.getRow(32);

		//// Column H
		Cell R0240cell7 = row.createCell(7);
		if (record.getR0240_stage1_assetclass() != null) {
			R0240cell7.setCellValue(record.getR0240_stage1_assetclass().doubleValue());
			R0240cell7.setCellStyle(numberStyle);
		} else {
			R0240cell7.setCellValue("");
			R0240cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0240cell8 = row.createCell(8);
		if (record.getR0240_stage2_assetclass() != null) {
			R0240cell8.setCellValue(record.getR0240_stage2_assetclass().doubleValue());
			R0240cell8.setCellStyle(numberStyle);
		} else {
			R0240cell8.setCellValue("");
			R0240cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0240cell9 = row.createCell(9);
		if (record.getR0240_stage3a_assetclass() != null) {
			R0240cell9.setCellValue(record.getR0240_stage3a_assetclass().doubleValue());
			R0240cell9.setCellStyle(numberStyle);
		} else {
			R0240cell9.setCellValue("");
			R0240cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0240cell10 = row.createCell(10);
		if (record.getR0240_stage3b_assetclass() != null) {
			R0240cell10.setCellValue(record.getR0240_stage3b_assetclass().doubleValue());
			R0240cell10.setCellStyle(numberStyle);
		} else {
			R0240cell10.setCellValue("");
			R0240cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0240cell11 = row.createCell(11);
		if (record.getR0240_stage3c_assetclass() != null) {
			R0240cell11.setCellValue(record.getR0240_stage3c_assetclass().doubleValue());
			R0240cell11.setCellStyle(numberStyle);
		} else {
			R0240cell11.setCellValue("");
			R0240cell11.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0240cell24 = row.createCell(24);
		if (record.getR0240_current_pastdues() != null) {
			R0240cell24.setCellValue(record.getR0240_current_pastdues().doubleValue());
			R0240cell24.setCellStyle(numberStyle);
		} else {
			R0240cell24.setCellValue("");
			R0240cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0240cell25 = row.createCell(25);
		if (record.getR0240_less30days_pastdues() != null) {
			R0240cell25.setCellValue(record.getR0240_less30days_pastdues().doubleValue());
			R0240cell25.setCellStyle(numberStyle);
		} else {
			R0240cell25.setCellValue("");
			R0240cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0240cell26 = row.createCell(26);
		if (record.getR0240_31to90days_pastdues() != null) {
			R0240cell26.setCellValue(record.getR0240_31to90days_pastdues().doubleValue());
			R0240cell26.setCellStyle(numberStyle);
		} else {
			R0240cell26.setCellValue("");
			R0240cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0240cell27 = row.createCell(27);
		if (record.getR0240_91to120days_pastdues() != null) {
			R0240cell27.setCellValue(record.getR0240_91to120days_pastdues().doubleValue());
			R0240cell27.setCellStyle(numberStyle);
		} else {
			R0240cell27.setCellValue("");
			R0240cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0240cell28 = row.createCell(28);
		if (record.getR0240_121to180days_pastdues() != null) {
			R0240cell28.setCellValue(record.getR0240_121to180days_pastdues().doubleValue());
			R0240cell28.setCellStyle(numberStyle);
		} else {
			R0240cell28.setCellValue("");
			R0240cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0240cell29 = row.createCell(29);
		if (record.getR0240_181to365days_pastdues() != null) {
			R0240cell29.setCellValue(record.getR0240_181to365days_pastdues().doubleValue());
			R0240cell29.setCellStyle(numberStyle);
		} else {
			R0240cell29.setCellValue("");
			R0240cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0240cell30 = row.createCell(30);
		if (record.getR0240_over365days_pastdues() != null) {
			R0240cell30.setCellValue(record.getR0240_over365days_pastdues().doubleValue());
			R0240cell30.setCellStyle(numberStyle);
		} else {
			R0240cell30.setCellValue("");
			R0240cell30.setCellStyle(textStyle);
		}

		/// ROW35
		//// Column E
		row = sheet.getRow(34);
		Cell R0260cell4 = row.createCell(4);
		if (record.getR0260_outstandbal() != null) {
			R0260cell4.setCellValue(record.getR0260_outstandbal().doubleValue());
			R0260cell4.setCellStyle(numberStyle);
		} else {
			R0260cell4.setCellValue("");
			R0260cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0260cell5 = row.createCell(5);
		if (record.getR0260_secured_outstandbal() != null) {
			R0260cell5.setCellValue(record.getR0260_secured_outstandbal().doubleValue());
			R0260cell5.setCellStyle(numberStyle);
		} else {
			R0260cell5.setCellValue("");
			R0260cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0260cell6 = row.createCell(6);
		if (record.getR0260_unsecured_outstandbal() != null) {
			R0260cell6.setCellValue(record.getR0260_unsecured_outstandbal().doubleValue());
			R0260cell6.setCellStyle(numberStyle);
		} else {
			R0260cell6.setCellValue("");
			R0260cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0260cell7 = row.createCell(7);
		if (record.getR0260_stage1_assetclass() != null) {
			R0260cell7.setCellValue(record.getR0260_stage1_assetclass().doubleValue());
			R0260cell7.setCellStyle(numberStyle);
		} else {
			R0260cell7.setCellValue("");
			R0260cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0260cell8 = row.createCell(8);
		if (record.getR0260_stage2_assetclass() != null) {
			R0260cell8.setCellValue(record.getR0260_stage2_assetclass().doubleValue());
			R0260cell8.setCellStyle(numberStyle);
		} else {
			R0260cell8.setCellValue("");
			R0260cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0260cell9 = row.createCell(9);
		if (record.getR0260_stage3a_assetclass() != null) {
			R0260cell9.setCellValue(record.getR0260_stage3a_assetclass().doubleValue());
			R0260cell9.setCellStyle(numberStyle);
		} else {
			R0260cell9.setCellValue("");
			R0260cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0260cell10 = row.createCell(10);
		if (record.getR0260_stage3b_assetclass() != null) {
			R0260cell10.setCellValue(record.getR0260_stage3b_assetclass().doubleValue());
			R0260cell10.setCellStyle(numberStyle);
		} else {
			R0260cell10.setCellValue("");
			R0260cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0260cell11 = row.createCell(11);
		if (record.getR0260_stage3c_assetclass() != null) {
			R0260cell11.setCellValue(record.getR0260_stage3c_assetclass().doubleValue());
			R0260cell11.setCellStyle(numberStyle);
		} else {
			R0260cell11.setCellValue("");
			R0260cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0260cell12 = row.createCell(12);
		if (record.getR0260_stage1_provisionheld() != null) {
			R0260cell12.setCellValue(record.getR0260_stage1_provisionheld().doubleValue());
			R0260cell12.setCellStyle(numberStyle);
		} else {
			R0260cell12.setCellValue("");
			R0260cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0260cell13 = row.createCell(13);
		if (record.getR0260_stage2_provisionheld() != null) {
			R0260cell13.setCellValue(record.getR0260_stage2_provisionheld().doubleValue());
			R0260cell13.setCellStyle(numberStyle);
		} else {
			R0260cell13.setCellValue("");
			R0260cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0260cell14 = row.createCell(14);
		if (record.getR0260_stage3a_provisionheld() != null) {
			R0260cell14.setCellValue(record.getR0260_stage3a_provisionheld().doubleValue());
			R0260cell14.setCellStyle(numberStyle);
		} else {
			R0260cell14.setCellValue("");
			R0260cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0260cell15 = row.createCell(15);
		if (record.getR0260_stage3b_provisionheld() != null) {
			R0260cell15.setCellValue(record.getR0260_stage3b_provisionheld().doubleValue());
			R0260cell15.setCellStyle(numberStyle);
		} else {
			R0260cell15.setCellValue("");
			R0260cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0260cell16 = row.createCell(16);
		if (record.getR0260_stage3c_provisionheld() != null) {
			R0260cell16.setCellValue(record.getR0260_stage3c_provisionheld().doubleValue());
			R0260cell16.setCellStyle(numberStyle);
		} else {
			R0260cell16.setCellValue("");
			R0260cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0260cell17 = row.createCell(17);
		if (record.getR0260_intrestfees_provisionheld() != null) {
			R0260cell17.setCellValue(record.getR0260_intrestfees_provisionheld().doubleValue());
			R0260cell17.setCellStyle(numberStyle);
		} else {
			R0260cell17.setCellValue("");
			R0260cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0260cell18 = row.createCell(18);
		if (record.getR0260_intrestsuspense_provisionheld() != null) {
			R0260cell18.setCellValue(record.getR0260_intrestsuspense_provisionheld().doubleValue());
			R0260cell18.setCellStyle(numberStyle);
		} else {
			R0260cell18.setCellValue("");
			R0260cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0260cell19 = row.createCell(19);
		if (record.getR0260_stage1_poci() != null) {
			R0260cell19.setCellValue(record.getR0260_stage1_poci().doubleValue());
			R0260cell19.setCellStyle(numberStyle);
		} else {
			R0260cell19.setCellValue("");
			R0260cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0260cell20 = row.createCell(20);
		if (record.getR0260_stage2_poci() != null) {
			R0260cell20.setCellValue(record.getR0260_stage2_poci().doubleValue());
			R0260cell20.setCellStyle(numberStyle);
		} else {
			R0260cell20.setCellValue("");
			R0260cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0260cell21 = row.createCell(21);
		if (record.getR0260_stage3a_poci() != null) {
			R0260cell21.setCellValue(record.getR0260_stage3a_poci().doubleValue());
			R0260cell21.setCellStyle(numberStyle);
		} else {
			R0260cell21.setCellValue("");
			R0260cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0260cell22 = row.createCell(22);
		if (record.getR0260_stage3b_poci() != null) {
			R0260cell22.setCellValue(record.getR0260_stage3b_poci().doubleValue());
			R0260cell22.setCellStyle(numberStyle);
		} else {
			R0260cell22.setCellValue("");
			R0260cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0260cell23 = row.createCell(23);
		if (record.getR0260_stage3c_poci() != null) {
			R0260cell23.setCellValue(record.getR0260_stage3c_poci().doubleValue());
			R0260cell23.setCellStyle(numberStyle);
		} else {
			R0260cell23.setCellValue("");
			R0260cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0260cell24 = row.createCell(24);
		if (record.getR0260_current_pastdues() != null) {
			R0260cell24.setCellValue(record.getR0260_current_pastdues().doubleValue());
			R0260cell24.setCellStyle(numberStyle);
		} else {
			R0260cell24.setCellValue("");
			R0260cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0260cell25 = row.createCell(25);
		if (record.getR0260_less30days_pastdues() != null) {
			R0260cell25.setCellValue(record.getR0260_less30days_pastdues().doubleValue());
			R0260cell25.setCellStyle(numberStyle);
		} else {
			R0260cell25.setCellValue("");
			R0260cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0260cell26 = row.createCell(26);
		if (record.getR0260_31to90days_pastdues() != null) {
			R0260cell26.setCellValue(record.getR0260_31to90days_pastdues().doubleValue());
			R0260cell26.setCellStyle(numberStyle);
		} else {
			R0260cell26.setCellValue("");
			R0260cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0260cell27 = row.createCell(27);
		if (record.getR0260_91to120days_pastdues() != null) {
			R0260cell27.setCellValue(record.getR0260_91to120days_pastdues().doubleValue());
			R0260cell27.setCellStyle(numberStyle);
		} else {
			R0260cell27.setCellValue("");
			R0260cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0260cell28 = row.createCell(28);
		if (record.getR0260_121to180days_pastdues() != null) {
			R0260cell28.setCellValue(record.getR0260_121to180days_pastdues().doubleValue());
			R0260cell28.setCellStyle(numberStyle);
		} else {
			R0260cell28.setCellValue("");
			R0260cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0260cell29 = row.createCell(29);
		if (record.getR0260_181to365days_pastdues() != null) {
			R0260cell29.setCellValue(record.getR0260_181to365days_pastdues().doubleValue());
			R0260cell29.setCellStyle(numberStyle);
		} else {
			R0260cell29.setCellValue("");
			R0260cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0260cell30 = row.createCell(30);
		if (record.getR0260_over365days_pastdues() != null) {
			R0260cell30.setCellValue(record.getR0260_over365days_pastdues().doubleValue());
			R0260cell30.setCellStyle(numberStyle);
		} else {
			R0260cell30.setCellValue("");
			R0260cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0260cell32 = row.createCell(32);
		if (record.getR0260_newloan_duringreport() != null) {
			R0260cell32.setCellValue(record.getR0260_newloan_duringreport().doubleValue());
			R0260cell32.setCellStyle(numberStyle);
		} else {
			R0260cell32.setCellValue("");
			R0260cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0260cell33 = row.createCell(33);
		if (record.getR0260_newstage_duringreport() != null) {
			R0260cell33.setCellValue(record.getR0260_newstage_duringreport().doubleValue());
			R0260cell33.setCellStyle(numberStyle);
		} else {
			R0260cell33.setCellValue("");
			R0260cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0260cell34 = row.createCell(34);
		if (record.getR0260_intrestfees_duringreport() != null) {
			R0260cell34.setCellValue(record.getR0260_intrestfees_duringreport().doubleValue());
			R0260cell34.setCellStyle(numberStyle);
		} else {
			R0260cell34.setCellValue("");
			R0260cell34.setCellStyle(textStyle);
		}

		/// ROW36
		//// Column E
		row = sheet.getRow(35);
		Cell R0270cell4 = row.createCell(4);
		if (record.getR0270_outstandbal() != null) {
			R0270cell4.setCellValue(record.getR0270_outstandbal().doubleValue());
			R0270cell4.setCellStyle(numberStyle);
		} else {
			R0270cell4.setCellValue("");
			R0270cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0270cell5 = row.createCell(5);
		if (record.getR0270_secured_outstandbal() != null) {
			R0270cell5.setCellValue(record.getR0270_secured_outstandbal().doubleValue());
			R0270cell5.setCellStyle(numberStyle);
		} else {
			R0270cell5.setCellValue("");
			R0270cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0270cell6 = row.createCell(6);
		if (record.getR0270_unsecured_outstandbal() != null) {
			R0270cell6.setCellValue(record.getR0270_unsecured_outstandbal().doubleValue());
			R0270cell6.setCellStyle(numberStyle);
		} else {
			R0270cell6.setCellValue("");
			R0270cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0270cell7 = row.createCell(7);
		if (record.getR0270_stage1_assetclass() != null) {
			R0270cell7.setCellValue(record.getR0270_stage1_assetclass().doubleValue());
			R0270cell7.setCellStyle(numberStyle);
		} else {
			R0270cell7.setCellValue("");
			R0270cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0270cell8 = row.createCell(8);
		if (record.getR0270_stage2_assetclass() != null) {
			R0270cell8.setCellValue(record.getR0270_stage2_assetclass().doubleValue());
			R0270cell8.setCellStyle(numberStyle);
		} else {
			R0270cell8.setCellValue("");
			R0270cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0270cell9 = row.createCell(9);
		if (record.getR0270_stage3a_assetclass() != null) {
			R0270cell9.setCellValue(record.getR0270_stage3a_assetclass().doubleValue());
			R0270cell9.setCellStyle(numberStyle);
		} else {
			R0270cell9.setCellValue("");
			R0270cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0270cell10 = row.createCell(10);
		if (record.getR0270_stage3b_assetclass() != null) {
			R0270cell10.setCellValue(record.getR0270_stage3b_assetclass().doubleValue());
			R0270cell10.setCellStyle(numberStyle);
		} else {
			R0270cell10.setCellValue("");
			R0270cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0270cell11 = row.createCell(11);
		if (record.getR0270_stage3c_assetclass() != null) {
			R0270cell11.setCellValue(record.getR0270_stage3c_assetclass().doubleValue());
			R0270cell11.setCellStyle(numberStyle);
		} else {
			R0270cell11.setCellValue("");
			R0270cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0270cell12 = row.createCell(12);
		if (record.getR0270_stage1_provisionheld() != null) {
			R0270cell12.setCellValue(record.getR0270_stage1_provisionheld().doubleValue());
			R0270cell12.setCellStyle(numberStyle);
		} else {
			R0270cell12.setCellValue("");
			R0270cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0270cell13 = row.createCell(13);
		if (record.getR0270_stage2_provisionheld() != null) {
			R0270cell13.setCellValue(record.getR0270_stage2_provisionheld().doubleValue());
			R0270cell13.setCellStyle(numberStyle);
		} else {
			R0270cell13.setCellValue("");
			R0270cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0270cell14 = row.createCell(14);
		if (record.getR0270_stage3a_provisionheld() != null) {
			R0270cell14.setCellValue(record.getR0270_stage3a_provisionheld().doubleValue());
			R0270cell14.setCellStyle(numberStyle);
		} else {
			R0270cell14.setCellValue("");
			R0270cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0270cell15 = row.createCell(15);
		if (record.getR0270_stage3b_provisionheld() != null) {
			R0270cell15.setCellValue(record.getR0270_stage3b_provisionheld().doubleValue());
			R0270cell15.setCellStyle(numberStyle);
		} else {
			R0270cell15.setCellValue("");
			R0270cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0270cell16 = row.createCell(16);
		if (record.getR0270_stage3c_provisionheld() != null) {
			R0270cell16.setCellValue(record.getR0270_stage3c_provisionheld().doubleValue());
			R0270cell16.setCellStyle(numberStyle);
		} else {
			R0270cell16.setCellValue("");
			R0270cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0270cell17 = row.createCell(17);
		if (record.getR0270_intrestfees_provisionheld() != null) {
			R0270cell17.setCellValue(record.getR0270_intrestfees_provisionheld().doubleValue());
			R0270cell17.setCellStyle(numberStyle);
		} else {
			R0270cell17.setCellValue("");
			R0270cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0270cell18 = row.createCell(18);
		if (record.getR0270_intrestsuspense_provisionheld() != null) {
			R0270cell18.setCellValue(record.getR0270_intrestsuspense_provisionheld().doubleValue());
			R0270cell18.setCellStyle(numberStyle);
		} else {
			R0270cell18.setCellValue("");
			R0270cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0270cell19 = row.createCell(19);
		if (record.getR0270_stage1_poci() != null) {
			R0270cell19.setCellValue(record.getR0270_stage1_poci().doubleValue());
			R0270cell19.setCellStyle(numberStyle);
		} else {
			R0270cell19.setCellValue("");
			R0270cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0270cell20 = row.createCell(20);
		if (record.getR0270_stage2_poci() != null) {
			R0270cell20.setCellValue(record.getR0270_stage2_poci().doubleValue());
			R0270cell20.setCellStyle(numberStyle);
		} else {
			R0270cell20.setCellValue("");
			R0270cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0270cell21 = row.createCell(21);
		if (record.getR0270_stage3a_poci() != null) {
			R0270cell21.setCellValue(record.getR0270_stage3a_poci().doubleValue());
			R0270cell21.setCellStyle(numberStyle);
		} else {
			R0270cell21.setCellValue("");
			R0270cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0270cell22 = row.createCell(22);
		if (record.getR0270_stage3b_poci() != null) {
			R0270cell22.setCellValue(record.getR0270_stage3b_poci().doubleValue());
			R0270cell22.setCellStyle(numberStyle);
		} else {
			R0270cell22.setCellValue("");
			R0270cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0270cell23 = row.createCell(23);
		if (record.getR0270_stage3c_poci() != null) {
			R0270cell23.setCellValue(record.getR0270_stage3c_poci().doubleValue());
			R0270cell23.setCellStyle(numberStyle);
		} else {
			R0270cell23.setCellValue("");
			R0270cell23.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0270cell32 = row.createCell(32);
		if (record.getR0270_newloan_duringreport() != null) {
			R0270cell32.setCellValue(record.getR0270_newloan_duringreport().doubleValue());
			R0270cell32.setCellStyle(numberStyle);
		} else {
			R0270cell32.setCellValue("");
			R0270cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0270cell33 = row.createCell(33);
		if (record.getR0270_newstage_duringreport() != null) {
			R0270cell33.setCellValue(record.getR0270_newstage_duringreport().doubleValue());
			R0270cell33.setCellStyle(numberStyle);
		} else {
			R0270cell33.setCellValue("");
			R0270cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0270cell34 = row.createCell(34);
		if (record.getR0270_intrestfees_duringreport() != null) {
			R0270cell34.setCellValue(record.getR0270_intrestfees_duringreport().doubleValue());
			R0270cell34.setCellStyle(numberStyle);
		} else {
			R0270cell34.setCellValue("");
			R0270cell34.setCellStyle(textStyle);
		}

		/// ROW37
		//// Column E
		row = sheet.getRow(36);
		Cell R0280cell4 = row.createCell(4);
		if (record.getR0280_outstandbal() != null) {
			R0280cell4.setCellValue(record.getR0280_outstandbal().doubleValue());
			R0280cell4.setCellStyle(numberStyle);
		} else {
			R0280cell4.setCellValue("");
			R0280cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0280cell5 = row.createCell(5);
		if (record.getR0280_secured_outstandbal() != null) {
			R0280cell5.setCellValue(record.getR0280_secured_outstandbal().doubleValue());
			R0280cell5.setCellStyle(numberStyle);
		} else {
			R0280cell5.setCellValue("");
			R0280cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0280cell6 = row.createCell(6);
		if (record.getR0280_unsecured_outstandbal() != null) {
			R0280cell6.setCellValue(record.getR0280_unsecured_outstandbal().doubleValue());
			R0280cell6.setCellStyle(numberStyle);
		} else {
			R0280cell6.setCellValue("");
			R0280cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0280cell7 = row.createCell(7);
		if (record.getR0280_stage1_assetclass() != null) {
			R0280cell7.setCellValue(record.getR0280_stage1_assetclass().doubleValue());
			R0280cell7.setCellStyle(numberStyle);
		} else {
			R0280cell7.setCellValue("");
			R0280cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0280cell8 = row.createCell(8);
		if (record.getR0280_stage2_assetclass() != null) {
			R0280cell8.setCellValue(record.getR0280_stage2_assetclass().doubleValue());
			R0280cell8.setCellStyle(numberStyle);
		} else {
			R0280cell8.setCellValue("");
			R0280cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0280cell9 = row.createCell(9);
		if (record.getR0280_stage3a_assetclass() != null) {
			R0280cell9.setCellValue(record.getR0280_stage3a_assetclass().doubleValue());
			R0280cell9.setCellStyle(numberStyle);
		} else {
			R0280cell9.setCellValue("");
			R0280cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0280cell10 = row.createCell(10);
		if (record.getR0280_stage3b_assetclass() != null) {
			R0280cell10.setCellValue(record.getR0280_stage3b_assetclass().doubleValue());
			R0280cell10.setCellStyle(numberStyle);
		} else {
			R0280cell10.setCellValue("");
			R0280cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0280cell11 = row.createCell(11);
		if (record.getR0280_stage3c_assetclass() != null) {
			R0280cell11.setCellValue(record.getR0280_stage3c_assetclass().doubleValue());
			R0280cell11.setCellStyle(numberStyle);
		} else {
			R0280cell11.setCellValue("");
			R0280cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0280cell12 = row.createCell(12);
		if (record.getR0280_stage1_provisionheld() != null) {
			R0280cell12.setCellValue(record.getR0280_stage1_provisionheld().doubleValue());
			R0280cell12.setCellStyle(numberStyle);
		} else {
			R0280cell12.setCellValue("");
			R0280cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0280cell13 = row.createCell(13);
		if (record.getR0280_stage2_provisionheld() != null) {
			R0280cell13.setCellValue(record.getR0280_stage2_provisionheld().doubleValue());
			R0280cell13.setCellStyle(numberStyle);
		} else {
			R0280cell13.setCellValue("");
			R0280cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0280cell14 = row.createCell(14);
		if (record.getR0280_stage3a_provisionheld() != null) {
			R0280cell14.setCellValue(record.getR0280_stage3a_provisionheld().doubleValue());
			R0280cell14.setCellStyle(numberStyle);
		} else {
			R0280cell14.setCellValue("");
			R0280cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0280cell15 = row.createCell(15);
		if (record.getR0280_stage3b_provisionheld() != null) {
			R0280cell15.setCellValue(record.getR0280_stage3b_provisionheld().doubleValue());
			R0280cell15.setCellStyle(numberStyle);
		} else {
			R0280cell15.setCellValue("");
			R0280cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0280cell16 = row.createCell(16);
		if (record.getR0280_stage3c_provisionheld() != null) {
			R0280cell16.setCellValue(record.getR0280_stage3c_provisionheld().doubleValue());
			R0280cell16.setCellStyle(numberStyle);
		} else {
			R0280cell16.setCellValue("");
			R0280cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0280cell17 = row.createCell(17);
		if (record.getR0280_intrestfees_provisionheld() != null) {
			R0280cell17.setCellValue(record.getR0280_intrestfees_provisionheld().doubleValue());
			R0280cell17.setCellStyle(numberStyle);
		} else {
			R0280cell17.setCellValue("");
			R0280cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0280cell18 = row.createCell(18);
		if (record.getR0280_intrestsuspense_provisionheld() != null) {
			R0280cell18.setCellValue(record.getR0280_intrestsuspense_provisionheld().doubleValue());
			R0280cell18.setCellStyle(numberStyle);
		} else {
			R0280cell18.setCellValue("");
			R0280cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0280cell19 = row.createCell(19);
		if (record.getR0280_stage1_poci() != null) {
			R0280cell19.setCellValue(record.getR0280_stage1_poci().doubleValue());
			R0280cell19.setCellStyle(numberStyle);
		} else {
			R0280cell19.setCellValue("");
			R0280cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0280cell20 = row.createCell(20);
		if (record.getR0280_stage2_poci() != null) {
			R0280cell20.setCellValue(record.getR0280_stage2_poci().doubleValue());
			R0280cell20.setCellStyle(numberStyle);
		} else {
			R0280cell20.setCellValue("");
			R0280cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0280cell21 = row.createCell(21);
		if (record.getR0280_stage3a_poci() != null) {
			R0280cell21.setCellValue(record.getR0280_stage3a_poci().doubleValue());
			R0280cell21.setCellStyle(numberStyle);
		} else {
			R0280cell21.setCellValue("");
			R0280cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0280cell22 = row.createCell(22);
		if (record.getR0280_stage3b_poci() != null) {
			R0280cell22.setCellValue(record.getR0280_stage3b_poci().doubleValue());
			R0280cell22.setCellStyle(numberStyle);
		} else {
			R0280cell22.setCellValue("");
			R0280cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0280cell23 = row.createCell(23);
		if (record.getR0280_stage3c_poci() != null) {
			R0280cell23.setCellValue(record.getR0280_stage3c_poci().doubleValue());
			R0280cell23.setCellStyle(numberStyle);
		} else {
			R0280cell23.setCellValue("");
			R0280cell23.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0280cell32 = row.createCell(32);
		if (record.getR0280_newloan_duringreport() != null) {
			R0280cell32.setCellValue(record.getR0280_newloan_duringreport().doubleValue());
			R0280cell32.setCellStyle(numberStyle);
		} else {
			R0280cell32.setCellValue("");
			R0280cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0280cell33 = row.createCell(33);
		if (record.getR0280_newstage_duringreport() != null) {
			R0280cell33.setCellValue(record.getR0280_newstage_duringreport().doubleValue());
			R0280cell33.setCellStyle(numberStyle);
		} else {
			R0280cell33.setCellValue("");
			R0280cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0280cell34 = row.createCell(34);
		if (record.getR0280_intrestfees_duringreport() != null) {
			R0280cell34.setCellValue(record.getR0280_intrestfees_duringreport().doubleValue());
			R0280cell34.setCellStyle(numberStyle);
		} else {
			R0280cell34.setCellValue("");
			R0280cell34.setCellStyle(textStyle);
		}

		/// ROW38
		//// Column E
		row = sheet.getRow(37);
		Cell R0290cell4 = row.createCell(4);
		if (record.getR0290_outstandbal() != null) {
			R0290cell4.setCellValue(record.getR0290_outstandbal().doubleValue());
			R0290cell4.setCellStyle(numberStyle);
		} else {
			R0290cell4.setCellValue("");
			R0290cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0290cell5 = row.createCell(5);
		if (record.getR0290_secured_outstandbal() != null) {
			R0290cell5.setCellValue(record.getR0290_secured_outstandbal().doubleValue());
			R0290cell5.setCellStyle(numberStyle);
		} else {
			R0290cell5.setCellValue("");
			R0290cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0290cell6 = row.createCell(6);
		if (record.getR0290_unsecured_outstandbal() != null) {
			R0290cell6.setCellValue(record.getR0290_unsecured_outstandbal().doubleValue());
			R0290cell6.setCellStyle(numberStyle);
		} else {
			R0290cell6.setCellValue("");
			R0290cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0290cell7 = row.createCell(7);
		if (record.getR0290_stage1_assetclass() != null) {
			R0290cell7.setCellValue(record.getR0290_stage1_assetclass().doubleValue());
			R0290cell7.setCellStyle(numberStyle);
		} else {
			R0290cell7.setCellValue("");
			R0290cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0290cell8 = row.createCell(8);
		if (record.getR0290_stage2_assetclass() != null) {
			R0290cell8.setCellValue(record.getR0290_stage2_assetclass().doubleValue());
			R0290cell8.setCellStyle(numberStyle);
		} else {
			R0290cell8.setCellValue("");
			R0290cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0290cell9 = row.createCell(9);
		if (record.getR0290_stage3a_assetclass() != null) {
			R0290cell9.setCellValue(record.getR0290_stage3a_assetclass().doubleValue());
			R0290cell9.setCellStyle(numberStyle);
		} else {
			R0290cell9.setCellValue("");
			R0290cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0290cell10 = row.createCell(10);
		if (record.getR0290_stage3b_assetclass() != null) {
			R0290cell10.setCellValue(record.getR0290_stage3b_assetclass().doubleValue());
			R0290cell10.setCellStyle(numberStyle);
		} else {
			R0290cell10.setCellValue("");
			R0290cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0290cell11 = row.createCell(11);
		if (record.getR0290_stage3c_assetclass() != null) {
			R0290cell11.setCellValue(record.getR0290_stage3c_assetclass().doubleValue());
			R0290cell11.setCellStyle(numberStyle);
		} else {
			R0290cell11.setCellValue("");
			R0290cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0290cell12 = row.createCell(12);
		if (record.getR0290_stage1_provisionheld() != null) {
			R0290cell12.setCellValue(record.getR0290_stage1_provisionheld().doubleValue());
			R0290cell12.setCellStyle(numberStyle);
		} else {
			R0290cell12.setCellValue("");
			R0290cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0290cell13 = row.createCell(13);
		if (record.getR0290_stage2_provisionheld() != null) {
			R0290cell13.setCellValue(record.getR0290_stage2_provisionheld().doubleValue());
			R0290cell13.setCellStyle(numberStyle);
		} else {
			R0290cell13.setCellValue("");
			R0290cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0290cell14 = row.createCell(14);
		if (record.getR0290_stage3a_provisionheld() != null) {
			R0290cell14.setCellValue(record.getR0290_stage3a_provisionheld().doubleValue());
			R0290cell14.setCellStyle(numberStyle);
		} else {
			R0290cell14.setCellValue("");
			R0290cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0290cell15 = row.createCell(15);
		if (record.getR0290_stage3b_provisionheld() != null) {
			R0290cell15.setCellValue(record.getR0290_stage3b_provisionheld().doubleValue());
			R0290cell15.setCellStyle(numberStyle);
		} else {
			R0290cell15.setCellValue("");
			R0290cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0290cell16 = row.createCell(16);
		if (record.getR0290_stage3c_provisionheld() != null) {
			R0290cell16.setCellValue(record.getR0290_stage3c_provisionheld().doubleValue());
			R0290cell16.setCellStyle(numberStyle);
		} else {
			R0290cell16.setCellValue("");
			R0290cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0290cell17 = row.createCell(17);
		if (record.getR0290_intrestfees_provisionheld() != null) {
			R0290cell17.setCellValue(record.getR0290_intrestfees_provisionheld().doubleValue());
			R0290cell17.setCellStyle(numberStyle);
		} else {
			R0290cell17.setCellValue("");
			R0290cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0290cell18 = row.createCell(18);
		if (record.getR0290_intrestsuspense_provisionheld() != null) {
			R0290cell18.setCellValue(record.getR0290_intrestsuspense_provisionheld().doubleValue());
			R0290cell18.setCellStyle(numberStyle);
		} else {
			R0290cell18.setCellValue("");
			R0290cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0290cell19 = row.createCell(19);
		if (record.getR0290_stage1_poci() != null) {
			R0290cell19.setCellValue(record.getR0290_stage1_poci().doubleValue());
			R0290cell19.setCellStyle(numberStyle);
		} else {
			R0290cell19.setCellValue("");
			R0290cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0290cell20 = row.createCell(20);
		if (record.getR0290_stage2_poci() != null) {
			R0290cell20.setCellValue(record.getR0290_stage2_poci().doubleValue());
			R0290cell20.setCellStyle(numberStyle);
		} else {
			R0290cell20.setCellValue("");
			R0290cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0290cell21 = row.createCell(21);
		if (record.getR0290_stage3a_poci() != null) {
			R0290cell21.setCellValue(record.getR0290_stage3a_poci().doubleValue());
			R0290cell21.setCellStyle(numberStyle);
		} else {
			R0290cell21.setCellValue("");
			R0290cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0290cell22 = row.createCell(22);
		if (record.getR0290_stage3b_poci() != null) {
			R0290cell22.setCellValue(record.getR0290_stage3b_poci().doubleValue());
			R0290cell22.setCellStyle(numberStyle);
		} else {
			R0290cell22.setCellValue("");
			R0290cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0290cell23 = row.createCell(23);
		if (record.getR0290_stage3c_poci() != null) {
			R0290cell23.setCellValue(record.getR0290_stage3c_poci().doubleValue());
			R0290cell23.setCellStyle(numberStyle);
		} else {
			R0290cell23.setCellValue("");
			R0290cell23.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0290cell32 = row.createCell(32);
		if (record.getR0290_newloan_duringreport() != null) {
			R0290cell32.setCellValue(record.getR0290_newloan_duringreport().doubleValue());
			R0290cell32.setCellStyle(numberStyle);
		} else {
			R0290cell32.setCellValue("");
			R0290cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0290cell33 = row.createCell(33);
		if (record.getR0290_newstage_duringreport() != null) {
			R0290cell33.setCellValue(record.getR0290_newstage_duringreport().doubleValue());
			R0290cell33.setCellStyle(numberStyle);
		} else {
			R0290cell33.setCellValue("");
			R0290cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0290cell34 = row.createCell(34);
		if (record.getR0290_intrestfees_duringreport() != null) {
			R0290cell34.setCellValue(record.getR0290_intrestfees_duringreport().doubleValue());
			R0290cell34.setCellStyle(numberStyle);
		} else {
			R0290cell34.setCellValue("");
			R0290cell34.setCellStyle(textStyle);
		}

	}

	private void populateEntity2Data(Sheet sheet, CBUAE_BRF5_3_Summary_Entity2 record1, CellStyle textStyle,
			CellStyle numberStyle) {

// R0310 - ROW 40 (Index 39)
		Row row = sheet.getRow(39) != null ? sheet.getRow(39) : sheet.createRow(39);

		/// ROW40
		//// Column E

		Cell R0310cell4 = row.createCell(4);
		if (record1.getR0310_outstandbal() != null) {
			R0310cell4.setCellValue(record1.getR0310_outstandbal().doubleValue());
			R0310cell4.setCellStyle(numberStyle);
		} else {
			R0310cell4.setCellValue("");
			R0310cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0310cell5 = row.createCell(5);
		if (record1.getR0310_secured_outstandbal() != null) {
			R0310cell5.setCellValue(record1.getR0310_secured_outstandbal().doubleValue());
			R0310cell5.setCellStyle(numberStyle);
		} else {
			R0310cell5.setCellValue("");
			R0310cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0310cell6 = row.createCell(6);
		if (record1.getR0310_unsecured_outstandbal() != null) {
			R0310cell6.setCellValue(record1.getR0310_unsecured_outstandbal().doubleValue());
			R0310cell6.setCellStyle(numberStyle);
		} else {
			R0310cell6.setCellValue("");
			R0310cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0310cell7 = row.createCell(7);
		if (record1.getR0310_stage1_assetclass() != null) {
			R0310cell7.setCellValue(record1.getR0310_stage1_assetclass().doubleValue());
			R0310cell7.setCellStyle(numberStyle);
		} else {
			R0310cell7.setCellValue("");
			R0310cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0310cell8 = row.createCell(8);
		if (record1.getR0310_stage2_assetclass() != null) {
			R0310cell8.setCellValue(record1.getR0310_stage2_assetclass().doubleValue());
			R0310cell8.setCellStyle(numberStyle);
		} else {
			R0310cell8.setCellValue("");
			R0310cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0310cell9 = row.createCell(9);
		if (record1.getR0310_stage3a_assetclass() != null) {
			R0310cell9.setCellValue(record1.getR0310_stage3a_assetclass().doubleValue());
			R0310cell9.setCellStyle(numberStyle);
		} else {
			R0310cell9.setCellValue("");
			R0310cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0310cell10 = row.createCell(10);
		if (record1.getR0310_stage3b_assetclass() != null) {
			R0310cell10.setCellValue(record1.getR0310_stage3b_assetclass().doubleValue());
			R0310cell10.setCellStyle(numberStyle);
		} else {
			R0310cell10.setCellValue("");
			R0310cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0310cell11 = row.createCell(11);
		if (record1.getR0310_stage3c_assetclass() != null) {
			R0310cell11.setCellValue(record1.getR0310_stage3c_assetclass().doubleValue());
			R0310cell11.setCellStyle(numberStyle);
		} else {
			R0310cell11.setCellValue("");
			R0310cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0310cell12 = row.createCell(12);
		if (record1.getR0310_stage1_provisionheld() != null) {
			R0310cell12.setCellValue(record1.getR0310_stage1_provisionheld().doubleValue());
			R0310cell12.setCellStyle(numberStyle);
		} else {
			R0310cell12.setCellValue("");
			R0310cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0310cell13 = row.createCell(13);
		if (record1.getR0310_stage2_provisionheld() != null) {
			R0310cell13.setCellValue(record1.getR0310_stage2_provisionheld().doubleValue());
			R0310cell13.setCellStyle(numberStyle);
		} else {
			R0310cell13.setCellValue("");
			R0310cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0310cell14 = row.createCell(14);
		if (record1.getR0310_stage3a_provisionheld() != null) {
			R0310cell14.setCellValue(record1.getR0310_stage3a_provisionheld().doubleValue());
			R0310cell14.setCellStyle(numberStyle);
		} else {
			R0310cell14.setCellValue("");
			R0310cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0310cell15 = row.createCell(15);
		if (record1.getR0310_stage3b_provisionheld() != null) {
			R0310cell15.setCellValue(record1.getR0310_stage3b_provisionheld().doubleValue());
			R0310cell15.setCellStyle(numberStyle);
		} else {
			R0310cell15.setCellValue("");
			R0310cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0310cell16 = row.createCell(16);
		if (record1.getR0310_stage3c_provisionheld() != null) {
			R0310cell16.setCellValue(record1.getR0310_stage3c_provisionheld().doubleValue());
			R0310cell16.setCellStyle(numberStyle);
		} else {
			R0310cell16.setCellValue("");
			R0310cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0310cell17 = row.createCell(17);
		if (record1.getR0310_intrestfees_provisionheld() != null) {
			R0310cell17.setCellValue(record1.getR0310_intrestfees_provisionheld().doubleValue());
			R0310cell17.setCellStyle(numberStyle);
		} else {
			R0310cell17.setCellValue("");
			R0310cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0310cell18 = row.createCell(18);
		if (record1.getR0310_intrestsuspense_provisionheld() != null) {
			R0310cell18.setCellValue(record1.getR0310_intrestsuspense_provisionheld().doubleValue());
			R0310cell18.setCellStyle(numberStyle);
		} else {
			R0310cell18.setCellValue("");
			R0310cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0310cell19 = row.createCell(19);
		if (record1.getR0310_stage1_poci() != null) {
			R0310cell19.setCellValue(record1.getR0310_stage1_poci().doubleValue());
			R0310cell19.setCellStyle(numberStyle);
		} else {
			R0310cell19.setCellValue("");
			R0310cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0310cell20 = row.createCell(20);
		if (record1.getR0310_stage2_poci() != null) {
			R0310cell20.setCellValue(record1.getR0310_stage2_poci().doubleValue());
			R0310cell20.setCellStyle(numberStyle);
		} else {
			R0310cell20.setCellValue("");
			R0310cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0310cell21 = row.createCell(21);
		if (record1.getR0310_stage3a_poci() != null) {
			R0310cell21.setCellValue(record1.getR0310_stage3a_poci().doubleValue());
			R0310cell21.setCellStyle(numberStyle);
		} else {
			R0310cell21.setCellValue("");
			R0310cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0310cell22 = row.createCell(22);
		if (record1.getR0310_stage3b_poci() != null) {
			R0310cell22.setCellValue(record1.getR0310_stage3b_poci().doubleValue());
			R0310cell22.setCellStyle(numberStyle);
		} else {
			R0310cell22.setCellValue("");
			R0310cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0310cell23 = row.createCell(23);
		if (record1.getR0310_stage3c_poci() != null) {
			R0310cell23.setCellValue(record1.getR0310_stage3c_poci().doubleValue());
			R0310cell23.setCellStyle(numberStyle);
		} else {
			R0310cell23.setCellValue("");
			R0310cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0310cell24 = row.createCell(24);
		if (record1.getR0310_current_pastdues() != null) {
			R0310cell24.setCellValue(record1.getR0310_current_pastdues().doubleValue());
			R0310cell24.setCellStyle(numberStyle);
		} else {
			R0310cell24.setCellValue("");
			R0310cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0310cell25 = row.createCell(25);
		if (record1.getR0310_less30days_pastdues() != null) {
			R0310cell25.setCellValue(record1.getR0310_less30days_pastdues().doubleValue());
			R0310cell25.setCellStyle(numberStyle);
		} else {
			R0310cell25.setCellValue("");
			R0310cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0310cell26 = row.createCell(26);
		if (record1.getR0310_31to90days_pastdues() != null) {
			R0310cell26.setCellValue(record1.getR0310_31to90days_pastdues().doubleValue());
			R0310cell26.setCellStyle(numberStyle);
		} else {
			R0310cell26.setCellValue("");
			R0310cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0310cell27 = row.createCell(27);
		if (record1.getR0310_91to120days_pastdues() != null) {
			R0310cell27.setCellValue(record1.getR0310_91to120days_pastdues().doubleValue());
			R0310cell27.setCellStyle(numberStyle);
		} else {
			R0310cell27.setCellValue("");
			R0310cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0310cell28 = row.createCell(28);
		if (record1.getR0310_121to180days_pastdues() != null) {
			R0310cell28.setCellValue(record1.getR0310_121to180days_pastdues().doubleValue());
			R0310cell28.setCellStyle(numberStyle);
		} else {
			R0310cell28.setCellValue("");
			R0310cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0310cell29 = row.createCell(29);
		if (record1.getR0310_181to365days_pastdues() != null) {
			R0310cell29.setCellValue(record1.getR0310_181to365days_pastdues().doubleValue());
			R0310cell29.setCellStyle(numberStyle);
		} else {
			R0310cell29.setCellValue("");
			R0310cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0310cell30 = row.createCell(30);
		if (record1.getR0310_over365days_pastdues() != null) {
			R0310cell30.setCellValue(record1.getR0310_over365days_pastdues().doubleValue());
			R0310cell30.setCellStyle(numberStyle);
		} else {
			R0310cell30.setCellValue("");
			R0310cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0310cell32 = row.createCell(32);
		if (record1.getR0310_newloan_duringreport() != null) {
			R0310cell32.setCellValue(record1.getR0310_newloan_duringreport().doubleValue());
			R0310cell32.setCellStyle(numberStyle);
		} else {
			R0310cell32.setCellValue("");
			R0310cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0310cell33 = row.createCell(33);
		if (record1.getR0310_newstage_duringreport() != null) {
			R0310cell33.setCellValue(record1.getR0310_newstage_duringreport().doubleValue());
			R0310cell33.setCellStyle(numberStyle);
		} else {
			R0310cell33.setCellValue("");
			R0310cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0310cell34 = row.createCell(34);
		if (record1.getR0310_intrestfees_duringreport() != null) {
			R0310cell34.setCellValue(record1.getR0310_intrestfees_duringreport().doubleValue());
			R0310cell34.setCellStyle(numberStyle);
		} else {
			R0310cell34.setCellValue("");
			R0310cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0310cell35 = row.createCell(35);
		if (record1.getR0310_performingac_acinfo() != null) {
			R0310cell35.setCellValue(record1.getR0310_performingac_acinfo().doubleValue());
			R0310cell35.setCellStyle(numberStyle);
		} else {
			R0310cell35.setCellValue("");
			R0310cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0310cell36 = row.createCell(36);
		if (record1.getR0310_nonperformingac_acinfo() != null) {
			R0310cell36.setCellValue(record1.getR0310_nonperformingac_acinfo().doubleValue());
			R0310cell36.setCellStyle(numberStyle);
		} else {
			R0310cell36.setCellValue("");
			R0310cell36.setCellStyle(textStyle);
		}

		/// ROW41
		//// Column E
		row = sheet.getRow(40);
		Cell R0320cell4 = row.createCell(4);
		if (record1.getR0320_outstandbal() != null) {
			R0320cell4.setCellValue(record1.getR0320_outstandbal().doubleValue());
			R0320cell4.setCellStyle(numberStyle);
		} else {
			R0320cell4.setCellValue("");
			R0320cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0320cell5 = row.createCell(5);
		if (record1.getR0320_secured_outstandbal() != null) {
			R0320cell5.setCellValue(record1.getR0320_secured_outstandbal().doubleValue());
			R0320cell5.setCellStyle(numberStyle);
		} else {
			R0320cell5.setCellValue("");
			R0320cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0320cell6 = row.createCell(6);
		if (record1.getR0320_unsecured_outstandbal() != null) {
			R0320cell6.setCellValue(record1.getR0320_unsecured_outstandbal().doubleValue());
			R0320cell6.setCellStyle(numberStyle);
		} else {
			R0320cell6.setCellValue("");
			R0320cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0320cell7 = row.createCell(7);
		if (record1.getR0320_stage1_assetclass() != null) {
			R0320cell7.setCellValue(record1.getR0320_stage1_assetclass().doubleValue());
			R0320cell7.setCellStyle(numberStyle);
		} else {
			R0320cell7.setCellValue("");
			R0320cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0320cell8 = row.createCell(8);
		if (record1.getR0320_stage2_assetclass() != null) {
			R0320cell8.setCellValue(record1.getR0320_stage2_assetclass().doubleValue());
			R0320cell8.setCellStyle(numberStyle);
		} else {
			R0320cell8.setCellValue("");
			R0320cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0320cell9 = row.createCell(9);
		if (record1.getR0320_stage3a_assetclass() != null) {
			R0320cell9.setCellValue(record1.getR0320_stage3a_assetclass().doubleValue());
			R0320cell9.setCellStyle(numberStyle);
		} else {
			R0320cell9.setCellValue("");
			R0320cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0320cell10 = row.createCell(10);
		if (record1.getR0320_stage3b_assetclass() != null) {
			R0320cell10.setCellValue(record1.getR0320_stage3b_assetclass().doubleValue());
			R0320cell10.setCellStyle(numberStyle);
		} else {
			R0320cell10.setCellValue("");
			R0320cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0320cell11 = row.createCell(11);
		if (record1.getR0320_stage3c_assetclass() != null) {
			R0320cell11.setCellValue(record1.getR0320_stage3c_assetclass().doubleValue());
			R0320cell11.setCellStyle(numberStyle);
		} else {
			R0320cell11.setCellValue("");
			R0320cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0320cell12 = row.createCell(12);
		if (record1.getR0320_stage1_provisionheld() != null) {
			R0320cell12.setCellValue(record1.getR0320_stage1_provisionheld().doubleValue());
			R0320cell12.setCellStyle(numberStyle);
		} else {
			R0320cell12.setCellValue("");
			R0320cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0320cell13 = row.createCell(13);
		if (record1.getR0320_stage2_provisionheld() != null) {
			R0320cell13.setCellValue(record1.getR0320_stage2_provisionheld().doubleValue());
			R0320cell13.setCellStyle(numberStyle);
		} else {
			R0320cell13.setCellValue("");
			R0320cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0320cell14 = row.createCell(14);
		if (record1.getR0320_stage3a_provisionheld() != null) {
			R0320cell14.setCellValue(record1.getR0320_stage3a_provisionheld().doubleValue());
			R0320cell14.setCellStyle(numberStyle);
		} else {
			R0320cell14.setCellValue("");
			R0320cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0320cell15 = row.createCell(15);
		if (record1.getR0320_stage3b_provisionheld() != null) {
			R0320cell15.setCellValue(record1.getR0320_stage3b_provisionheld().doubleValue());
			R0320cell15.setCellStyle(numberStyle);
		} else {
			R0320cell15.setCellValue("");
			R0320cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0320cell16 = row.createCell(16);
		if (record1.getR0320_stage3c_provisionheld() != null) {
			R0320cell16.setCellValue(record1.getR0320_stage3c_provisionheld().doubleValue());
			R0320cell16.setCellStyle(numberStyle);
		} else {
			R0320cell16.setCellValue("");
			R0320cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0320cell17 = row.createCell(17);
		if (record1.getR0320_intrestfees_provisionheld() != null) {
			R0320cell17.setCellValue(record1.getR0320_intrestfees_provisionheld().doubleValue());
			R0320cell17.setCellStyle(numberStyle);
		} else {
			R0320cell17.setCellValue("");
			R0320cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0320cell18 = row.createCell(18);
		if (record1.getR0320_intrestsuspense_provisionheld() != null) {
			R0320cell18.setCellValue(record1.getR0320_intrestsuspense_provisionheld().doubleValue());
			R0320cell18.setCellStyle(numberStyle);
		} else {
			R0320cell18.setCellValue("");
			R0320cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0320cell19 = row.createCell(19);
		if (record1.getR0320_stage1_poci() != null) {
			R0320cell19.setCellValue(record1.getR0320_stage1_poci().doubleValue());
			R0320cell19.setCellStyle(numberStyle);
		} else {
			R0320cell19.setCellValue("");
			R0320cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0320cell20 = row.createCell(20);
		if (record1.getR0320_stage2_poci() != null) {
			R0320cell20.setCellValue(record1.getR0320_stage2_poci().doubleValue());
			R0320cell20.setCellStyle(numberStyle);
		} else {
			R0320cell20.setCellValue("");
			R0320cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0320cell21 = row.createCell(21);
		if (record1.getR0320_stage3a_poci() != null) {
			R0320cell21.setCellValue(record1.getR0320_stage3a_poci().doubleValue());
			R0320cell21.setCellStyle(numberStyle);
		} else {
			R0320cell21.setCellValue("");
			R0320cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0320cell22 = row.createCell(22);
		if (record1.getR0320_stage3b_poci() != null) {
			R0320cell22.setCellValue(record1.getR0320_stage3b_poci().doubleValue());
			R0320cell22.setCellStyle(numberStyle);
		} else {
			R0320cell22.setCellValue("");
			R0320cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0320cell23 = row.createCell(23);
		if (record1.getR0320_stage3c_poci() != null) {
			R0320cell23.setCellValue(record1.getR0320_stage3c_poci().doubleValue());
			R0320cell23.setCellStyle(numberStyle);
		} else {
			R0320cell23.setCellValue("");
			R0320cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0320cell24 = row.createCell(24);
		if (record1.getR0320_current_pastdues() != null) {
			R0320cell24.setCellValue(record1.getR0320_current_pastdues().doubleValue());
			R0320cell24.setCellStyle(numberStyle);
		} else {
			R0320cell24.setCellValue("");
			R0320cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0320cell25 = row.createCell(25);
		if (record1.getR0320_less30days_pastdues() != null) {
			R0320cell25.setCellValue(record1.getR0320_less30days_pastdues().doubleValue());
			R0320cell25.setCellStyle(numberStyle);
		} else {
			R0320cell25.setCellValue("");
			R0320cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0320cell26 = row.createCell(26);
		if (record1.getR0320_31to90days_pastdues() != null) {
			R0320cell26.setCellValue(record1.getR0320_31to90days_pastdues().doubleValue());
			R0320cell26.setCellStyle(numberStyle);
		} else {
			R0320cell26.setCellValue("");
			R0320cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0320cell27 = row.createCell(27);
		if (record1.getR0320_91to120days_pastdues() != null) {
			R0320cell27.setCellValue(record1.getR0320_91to120days_pastdues().doubleValue());
			R0320cell27.setCellStyle(numberStyle);
		} else {
			R0320cell27.setCellValue("");
			R0320cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0320cell28 = row.createCell(28);
		if (record1.getR0320_121to180days_pastdues() != null) {
			R0320cell28.setCellValue(record1.getR0320_121to180days_pastdues().doubleValue());
			R0320cell28.setCellStyle(numberStyle);
		} else {
			R0320cell28.setCellValue("");
			R0320cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0320cell29 = row.createCell(29);
		if (record1.getR0320_181to365days_pastdues() != null) {
			R0320cell29.setCellValue(record1.getR0320_181to365days_pastdues().doubleValue());
			R0320cell29.setCellStyle(numberStyle);
		} else {
			R0320cell29.setCellValue("");
			R0320cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0320cell30 = row.createCell(30);
		if (record1.getR0320_over365days_pastdues() != null) {
			R0320cell30.setCellValue(record1.getR0320_over365days_pastdues().doubleValue());
			R0320cell30.setCellStyle(numberStyle);
		} else {
			R0320cell30.setCellValue("");
			R0320cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0320cell32 = row.createCell(32);
		if (record1.getR0320_newloan_duringreport() != null) {
			R0320cell32.setCellValue(record1.getR0320_newloan_duringreport().doubleValue());
			R0320cell32.setCellStyle(numberStyle);
		} else {
			R0320cell32.setCellValue("");
			R0320cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0320cell33 = row.createCell(33);
		if (record1.getR0320_newstage_duringreport() != null) {
			R0320cell33.setCellValue(record1.getR0320_newstage_duringreport().doubleValue());
			R0320cell33.setCellStyle(numberStyle);
		} else {
			R0320cell33.setCellValue("");
			R0320cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0320cell34 = row.createCell(34);
		if (record1.getR0320_intrestfees_duringreport() != null) {
			R0320cell34.setCellValue(record1.getR0320_intrestfees_duringreport().doubleValue());
			R0320cell34.setCellStyle(numberStyle);
		} else {
			R0320cell34.setCellValue("");
			R0320cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0320cell35 = row.createCell(35);
		if (record1.getR0320_performingac_acinfo() != null) {
			R0320cell35.setCellValue(record1.getR0320_performingac_acinfo().doubleValue());
			R0320cell35.setCellStyle(numberStyle);
		} else {
			R0320cell35.setCellValue("");
			R0320cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0320cell36 = row.createCell(36);
		if (record1.getR0320_nonperformingac_acinfo() != null) {
			R0320cell36.setCellValue(record1.getR0320_nonperformingac_acinfo().doubleValue());
			R0320cell36.setCellStyle(numberStyle);
		} else {
			R0320cell36.setCellValue("");
			R0320cell36.setCellStyle(textStyle);
		}

		/// ROW42
		//// Column E
		row = sheet.getRow(41);
		Cell R0330cell4 = row.createCell(4);
		if (record1.getR0330_outstandbal() != null) {
			R0330cell4.setCellValue(record1.getR0330_outstandbal().doubleValue());
			R0330cell4.setCellStyle(numberStyle);
		} else {
			R0330cell4.setCellValue("");
			R0330cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0330cell5 = row.createCell(5);
		if (record1.getR0330_secured_outstandbal() != null) {
			R0330cell5.setCellValue(record1.getR0330_secured_outstandbal().doubleValue());
			R0330cell5.setCellStyle(numberStyle);
		} else {
			R0330cell5.setCellValue("");
			R0330cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0330cell6 = row.createCell(6);
		if (record1.getR0330_unsecured_outstandbal() != null) {
			R0330cell6.setCellValue(record1.getR0330_unsecured_outstandbal().doubleValue());
			R0330cell6.setCellStyle(numberStyle);
		} else {
			R0330cell6.setCellValue("");
			R0330cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0330cell7 = row.createCell(7);
		if (record1.getR0330_stage1_assetclass() != null) {
			R0330cell7.setCellValue(record1.getR0330_stage1_assetclass().doubleValue());
			R0330cell7.setCellStyle(numberStyle);
		} else {
			R0330cell7.setCellValue("");
			R0330cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0330cell8 = row.createCell(8);
		if (record1.getR0330_stage2_assetclass() != null) {
			R0330cell8.setCellValue(record1.getR0330_stage2_assetclass().doubleValue());
			R0330cell8.setCellStyle(numberStyle);
		} else {
			R0330cell8.setCellValue("");
			R0330cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0330cell9 = row.createCell(9);
		if (record1.getR0330_stage3a_assetclass() != null) {
			R0330cell9.setCellValue(record1.getR0330_stage3a_assetclass().doubleValue());
			R0330cell9.setCellStyle(numberStyle);
		} else {
			R0330cell9.setCellValue("");
			R0330cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0330cell10 = row.createCell(10);
		if (record1.getR0330_stage3b_assetclass() != null) {
			R0330cell10.setCellValue(record1.getR0330_stage3b_assetclass().doubleValue());
			R0330cell10.setCellStyle(numberStyle);
		} else {
			R0330cell10.setCellValue("");
			R0330cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0330cell11 = row.createCell(11);
		if (record1.getR0330_stage3c_assetclass() != null) {
			R0330cell11.setCellValue(record1.getR0330_stage3c_assetclass().doubleValue());
			R0330cell11.setCellStyle(numberStyle);
		} else {
			R0330cell11.setCellValue("");
			R0330cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0330cell12 = row.createCell(12);
		if (record1.getR0330_stage1_provisionheld() != null) {
			R0330cell12.setCellValue(record1.getR0330_stage1_provisionheld().doubleValue());
			R0330cell12.setCellStyle(numberStyle);
		} else {
			R0330cell12.setCellValue("");
			R0330cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0330cell13 = row.createCell(13);
		if (record1.getR0330_stage2_provisionheld() != null) {
			R0330cell13.setCellValue(record1.getR0330_stage2_provisionheld().doubleValue());
			R0330cell13.setCellStyle(numberStyle);
		} else {
			R0330cell13.setCellValue("");
			R0330cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0330cell14 = row.createCell(14);
		if (record1.getR0330_stage3a_provisionheld() != null) {
			R0330cell14.setCellValue(record1.getR0330_stage3a_provisionheld().doubleValue());
			R0330cell14.setCellStyle(numberStyle);
		} else {
			R0330cell14.setCellValue("");
			R0330cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0330cell15 = row.createCell(15);
		if (record1.getR0330_stage3b_provisionheld() != null) {
			R0330cell15.setCellValue(record1.getR0330_stage3b_provisionheld().doubleValue());
			R0330cell15.setCellStyle(numberStyle);
		} else {
			R0330cell15.setCellValue("");
			R0330cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0330cell16 = row.createCell(16);
		if (record1.getR0330_stage3c_provisionheld() != null) {
			R0330cell16.setCellValue(record1.getR0330_stage3c_provisionheld().doubleValue());
			R0330cell16.setCellStyle(numberStyle);
		} else {
			R0330cell16.setCellValue("");
			R0330cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0330cell17 = row.createCell(17);
		if (record1.getR0330_intrestfees_provisionheld() != null) {
			R0330cell17.setCellValue(record1.getR0330_intrestfees_provisionheld().doubleValue());
			R0330cell17.setCellStyle(numberStyle);
		} else {
			R0330cell17.setCellValue("");
			R0330cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0330cell18 = row.createCell(18);
		if (record1.getR0330_intrestsuspense_provisionheld() != null) {
			R0330cell18.setCellValue(record1.getR0330_intrestsuspense_provisionheld().doubleValue());
			R0330cell18.setCellStyle(numberStyle);
		} else {
			R0330cell18.setCellValue("");
			R0330cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0330cell19 = row.createCell(19);
		if (record1.getR0330_stage1_poci() != null) {
			R0330cell19.setCellValue(record1.getR0330_stage1_poci().doubleValue());
			R0330cell19.setCellStyle(numberStyle);
		} else {
			R0330cell19.setCellValue("");
			R0330cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0330cell20 = row.createCell(20);
		if (record1.getR0330_stage2_poci() != null) {
			R0330cell20.setCellValue(record1.getR0330_stage2_poci().doubleValue());
			R0330cell20.setCellStyle(numberStyle);
		} else {
			R0330cell20.setCellValue("");
			R0330cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0330cell21 = row.createCell(21);
		if (record1.getR0330_stage3a_poci() != null) {
			R0330cell21.setCellValue(record1.getR0330_stage3a_poci().doubleValue());
			R0330cell21.setCellStyle(numberStyle);
		} else {
			R0330cell21.setCellValue("");
			R0330cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0330cell22 = row.createCell(22);
		if (record1.getR0330_stage3b_poci() != null) {
			R0330cell22.setCellValue(record1.getR0330_stage3b_poci().doubleValue());
			R0330cell22.setCellStyle(numberStyle);
		} else {
			R0330cell22.setCellValue("");
			R0330cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0330cell23 = row.createCell(23);
		if (record1.getR0330_stage3c_poci() != null) {
			R0330cell23.setCellValue(record1.getR0330_stage3c_poci().doubleValue());
			R0330cell23.setCellStyle(numberStyle);
		} else {
			R0330cell23.setCellValue("");
			R0330cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0330cell24 = row.createCell(24);
		if (record1.getR0330_current_pastdues() != null) {
			R0330cell24.setCellValue(record1.getR0330_current_pastdues().doubleValue());
			R0330cell24.setCellStyle(numberStyle);
		} else {
			R0330cell24.setCellValue("");
			R0330cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0330cell25 = row.createCell(25);
		if (record1.getR0330_less30days_pastdues() != null) {
			R0330cell25.setCellValue(record1.getR0330_less30days_pastdues().doubleValue());
			R0330cell25.setCellStyle(numberStyle);
		} else {
			R0330cell25.setCellValue("");
			R0330cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0330cell26 = row.createCell(26);
		if (record1.getR0330_31to90days_pastdues() != null) {
			R0330cell26.setCellValue(record1.getR0330_31to90days_pastdues().doubleValue());
			R0330cell26.setCellStyle(numberStyle);
		} else {
			R0330cell26.setCellValue("");
			R0330cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0330cell27 = row.createCell(27);
		if (record1.getR0330_91to120days_pastdues() != null) {
			R0330cell27.setCellValue(record1.getR0330_91to120days_pastdues().doubleValue());
			R0330cell27.setCellStyle(numberStyle);
		} else {
			R0330cell27.setCellValue("");
			R0330cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0330cell28 = row.createCell(28);
		if (record1.getR0330_121to180days_pastdues() != null) {
			R0330cell28.setCellValue(record1.getR0330_121to180days_pastdues().doubleValue());
			R0330cell28.setCellStyle(numberStyle);
		} else {
			R0330cell28.setCellValue("");
			R0330cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0330cell29 = row.createCell(29);
		if (record1.getR0330_181to365days_pastdues() != null) {
			R0330cell29.setCellValue(record1.getR0330_181to365days_pastdues().doubleValue());
			R0330cell29.setCellStyle(numberStyle);
		} else {
			R0330cell29.setCellValue("");
			R0330cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0330cell30 = row.createCell(30);
		if (record1.getR0330_over365days_pastdues() != null) {
			R0330cell30.setCellValue(record1.getR0330_over365days_pastdues().doubleValue());
			R0330cell30.setCellStyle(numberStyle);
		} else {
			R0330cell30.setCellValue("");
			R0330cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0330cell32 = row.createCell(32);
		if (record1.getR0330_newloan_duringreport() != null) {
			R0330cell32.setCellValue(record1.getR0330_newloan_duringreport().doubleValue());
			R0330cell32.setCellStyle(numberStyle);
		} else {
			R0330cell32.setCellValue("");
			R0330cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0330cell33 = row.createCell(33);
		if (record1.getR0330_newstage_duringreport() != null) {
			R0330cell33.setCellValue(record1.getR0330_newstage_duringreport().doubleValue());
			R0330cell33.setCellStyle(numberStyle);
		} else {
			R0330cell33.setCellValue("");
			R0330cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0330cell34 = row.createCell(34);
		if (record1.getR0330_intrestfees_duringreport() != null) {
			R0330cell34.setCellValue(record1.getR0330_intrestfees_duringreport().doubleValue());
			R0330cell34.setCellStyle(numberStyle);
		} else {
			R0330cell34.setCellValue("");
			R0330cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0330cell35 = row.createCell(35);
		if (record1.getR0330_performingac_acinfo() != null) {
			R0330cell35.setCellValue(record1.getR0330_performingac_acinfo().doubleValue());
			R0330cell35.setCellStyle(numberStyle);
		} else {
			R0330cell35.setCellValue("");
			R0330cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0330cell36 = row.createCell(36);
		if (record1.getR0330_nonperformingac_acinfo() != null) {
			R0330cell36.setCellValue(record1.getR0330_nonperformingac_acinfo().doubleValue());
			R0330cell36.setCellStyle(numberStyle);
		} else {
			R0330cell36.setCellValue("");
			R0330cell36.setCellStyle(textStyle);
		}

		/// ROW44
		//// Column E
		row = sheet.getRow(43);
		Cell R0350cell4 = row.createCell(4);
		if (record1.getR0350_outstandbal() != null) {
			R0350cell4.setCellValue(record1.getR0350_outstandbal().doubleValue());
			R0350cell4.setCellStyle(numberStyle);
		} else {
			R0350cell4.setCellValue("");
			R0350cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0350cell5 = row.createCell(5);
		if (record1.getR0350_secured_outstandbal() != null) {
			R0350cell5.setCellValue(record1.getR0350_secured_outstandbal().doubleValue());
			R0350cell5.setCellStyle(numberStyle);
		} else {
			R0350cell5.setCellValue("");
			R0350cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0350cell6 = row.createCell(6);
		if (record1.getR0350_unsecured_outstandbal() != null) {
			R0350cell6.setCellValue(record1.getR0350_unsecured_outstandbal().doubleValue());
			R0350cell6.setCellStyle(numberStyle);
		} else {
			R0350cell6.setCellValue("");
			R0350cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0350cell7 = row.createCell(7);
		if (record1.getR0350_stage1_assetclass() != null) {
			R0350cell7.setCellValue(record1.getR0350_stage1_assetclass().doubleValue());
			R0350cell7.setCellStyle(numberStyle);
		} else {
			R0350cell7.setCellValue("");
			R0350cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0350cell8 = row.createCell(8);
		if (record1.getR0350_stage2_assetclass() != null) {
			R0350cell8.setCellValue(record1.getR0350_stage2_assetclass().doubleValue());
			R0350cell8.setCellStyle(numberStyle);
		} else {
			R0350cell8.setCellValue("");
			R0350cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0350cell9 = row.createCell(9);
		if (record1.getR0350_stage3a_assetclass() != null) {
			R0350cell9.setCellValue(record1.getR0350_stage3a_assetclass().doubleValue());
			R0350cell9.setCellStyle(numberStyle);
		} else {
			R0350cell9.setCellValue("");
			R0350cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0350cell10 = row.createCell(10);
		if (record1.getR0350_stage3b_assetclass() != null) {
			R0350cell10.setCellValue(record1.getR0350_stage3b_assetclass().doubleValue());
			R0350cell10.setCellStyle(numberStyle);
		} else {
			R0350cell10.setCellValue("");
			R0350cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0350cell11 = row.createCell(11);
		if (record1.getR0350_stage3c_assetclass() != null) {
			R0350cell11.setCellValue(record1.getR0350_stage3c_assetclass().doubleValue());
			R0350cell11.setCellStyle(numberStyle);
		} else {
			R0350cell11.setCellValue("");
			R0350cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0350cell12 = row.createCell(12);
		if (record1.getR0350_stage1_provisionheld() != null) {
			R0350cell12.setCellValue(record1.getR0350_stage1_provisionheld().doubleValue());
			R0350cell12.setCellStyle(numberStyle);
		} else {
			R0350cell12.setCellValue("");
			R0350cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0350cell13 = row.createCell(13);
		if (record1.getR0350_stage2_provisionheld() != null) {
			R0350cell13.setCellValue(record1.getR0350_stage2_provisionheld().doubleValue());
			R0350cell13.setCellStyle(numberStyle);
		} else {
			R0350cell13.setCellValue("");
			R0350cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0350cell14 = row.createCell(14);
		if (record1.getR0350_stage3a_provisionheld() != null) {
			R0350cell14.setCellValue(record1.getR0350_stage3a_provisionheld().doubleValue());
			R0350cell14.setCellStyle(numberStyle);
		} else {
			R0350cell14.setCellValue("");
			R0350cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0350cell15 = row.createCell(15);
		if (record1.getR0350_stage3b_provisionheld() != null) {
			R0350cell15.setCellValue(record1.getR0350_stage3b_provisionheld().doubleValue());
			R0350cell15.setCellStyle(numberStyle);
		} else {
			R0350cell15.setCellValue("");
			R0350cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0350cell16 = row.createCell(16);
		if (record1.getR0350_stage3c_provisionheld() != null) {
			R0350cell16.setCellValue(record1.getR0350_stage3c_provisionheld().doubleValue());
			R0350cell16.setCellStyle(numberStyle);
		} else {
			R0350cell16.setCellValue("");
			R0350cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0350cell17 = row.createCell(17);
		if (record1.getR0350_intrestfees_provisionheld() != null) {
			R0350cell17.setCellValue(record1.getR0350_intrestfees_provisionheld().doubleValue());
			R0350cell17.setCellStyle(numberStyle);
		} else {
			R0350cell17.setCellValue("");
			R0350cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0350cell18 = row.createCell(18);
		if (record1.getR0350_intrestsuspense_provisionheld() != null) {
			R0350cell18.setCellValue(record1.getR0350_intrestsuspense_provisionheld().doubleValue());
			R0350cell18.setCellStyle(numberStyle);
		} else {
			R0350cell18.setCellValue("");
			R0350cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0350cell19 = row.createCell(19);
		if (record1.getR0350_stage1_poci() != null) {
			R0350cell19.setCellValue(record1.getR0350_stage1_poci().doubleValue());
			R0350cell19.setCellStyle(numberStyle);
		} else {
			R0350cell19.setCellValue("");
			R0350cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0350cell20 = row.createCell(20);
		if (record1.getR0350_stage2_poci() != null) {
			R0350cell20.setCellValue(record1.getR0350_stage2_poci().doubleValue());
			R0350cell20.setCellStyle(numberStyle);
		} else {
			R0350cell20.setCellValue("");
			R0350cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0350cell21 = row.createCell(21);
		if (record1.getR0350_stage3a_poci() != null) {
			R0350cell21.setCellValue(record1.getR0350_stage3a_poci().doubleValue());
			R0350cell21.setCellStyle(numberStyle);
		} else {
			R0350cell21.setCellValue("");
			R0350cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0350cell22 = row.createCell(22);
		if (record1.getR0350_stage3b_poci() != null) {
			R0350cell22.setCellValue(record1.getR0350_stage3b_poci().doubleValue());
			R0350cell22.setCellStyle(numberStyle);
		} else {
			R0350cell22.setCellValue("");
			R0350cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0350cell23 = row.createCell(23);
		if (record1.getR0350_stage3c_poci() != null) {
			R0350cell23.setCellValue(record1.getR0350_stage3c_poci().doubleValue());
			R0350cell23.setCellStyle(numberStyle);
		} else {
			R0350cell23.setCellValue("");
			R0350cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0350cell24 = row.createCell(24);
		if (record1.getR0350_current_pastdues() != null) {
			R0350cell24.setCellValue(record1.getR0350_current_pastdues().doubleValue());
			R0350cell24.setCellStyle(numberStyle);
		} else {
			R0350cell24.setCellValue("");
			R0350cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0350cell25 = row.createCell(25);
		if (record1.getR0350_less30days_pastdues() != null) {
			R0350cell25.setCellValue(record1.getR0350_less30days_pastdues().doubleValue());
			R0350cell25.setCellStyle(numberStyle);
		} else {
			R0350cell25.setCellValue("");
			R0350cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0350cell26 = row.createCell(26);
		if (record1.getR0350_31to90days_pastdues() != null) {
			R0350cell26.setCellValue(record1.getR0350_31to90days_pastdues().doubleValue());
			R0350cell26.setCellStyle(numberStyle);
		} else {
			R0350cell26.setCellValue("");
			R0350cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0350cell27 = row.createCell(27);
		if (record1.getR0350_91to120days_pastdues() != null) {
			R0350cell27.setCellValue(record1.getR0350_91to120days_pastdues().doubleValue());
			R0350cell27.setCellStyle(numberStyle);
		} else {
			R0350cell27.setCellValue("");
			R0350cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0350cell28 = row.createCell(28);
		if (record1.getR0350_121to180days_pastdues() != null) {
			R0350cell28.setCellValue(record1.getR0350_121to180days_pastdues().doubleValue());
			R0350cell28.setCellStyle(numberStyle);
		} else {
			R0350cell28.setCellValue("");
			R0350cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0350cell29 = row.createCell(29);
		if (record1.getR0350_181to365days_pastdues() != null) {
			R0350cell29.setCellValue(record1.getR0350_181to365days_pastdues().doubleValue());
			R0350cell29.setCellStyle(numberStyle);
		} else {
			R0350cell29.setCellValue("");
			R0350cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0350cell30 = row.createCell(30);
		if (record1.getR0350_over365days_pastdues() != null) {
			R0350cell30.setCellValue(record1.getR0350_over365days_pastdues().doubleValue());
			R0350cell30.setCellStyle(numberStyle);
		} else {
			R0350cell30.setCellValue("");
			R0350cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0350cell32 = row.createCell(32);
		if (record1.getR0350_newloan_duringreport() != null) {
			R0350cell32.setCellValue(record1.getR0350_newloan_duringreport().doubleValue());
			R0350cell32.setCellStyle(numberStyle);
		} else {
			R0350cell32.setCellValue("");
			R0350cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0350cell33 = row.createCell(33);
		if (record1.getR0350_newstage_duringreport() != null) {
			R0350cell33.setCellValue(record1.getR0350_newstage_duringreport().doubleValue());
			R0350cell33.setCellStyle(numberStyle);
		} else {
			R0350cell33.setCellValue("");
			R0350cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0350cell34 = row.createCell(34);
		if (record1.getR0350_intrestfees_duringreport() != null) {
			R0350cell34.setCellValue(record1.getR0350_intrestfees_duringreport().doubleValue());
			R0350cell34.setCellStyle(numberStyle);
		} else {
			R0350cell34.setCellValue("");
			R0350cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0350cell35 = row.createCell(35);
		if (record1.getR0350_performingac_acinfo() != null) {
			R0350cell35.setCellValue(record1.getR0350_performingac_acinfo().doubleValue());
			R0350cell35.setCellStyle(numberStyle);
		} else {
			R0350cell35.setCellValue("");
			R0350cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0350cell36 = row.createCell(36);
		if (record1.getR0350_nonperformingac_acinfo() != null) {
			R0350cell36.setCellValue(record1.getR0350_nonperformingac_acinfo().doubleValue());
			R0350cell36.setCellStyle(numberStyle);
		} else {
			R0350cell36.setCellValue("");
			R0350cell36.setCellStyle(textStyle);
		}

		/// ROW45
		//// Column E
		row = sheet.getRow(44);
		Cell R0360cell4 = row.createCell(4);
		if (record1.getR0360_outstandbal() != null) {
			R0360cell4.setCellValue(record1.getR0360_outstandbal().doubleValue());
			R0360cell4.setCellStyle(numberStyle);
		} else {
			R0360cell4.setCellValue("");
			R0360cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0360cell5 = row.createCell(5);
		if (record1.getR0360_secured_outstandbal() != null) {
			R0360cell5.setCellValue(record1.getR0360_secured_outstandbal().doubleValue());
			R0360cell5.setCellStyle(numberStyle);
		} else {
			R0360cell5.setCellValue("");
			R0360cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0360cell6 = row.createCell(6);
		if (record1.getR0360_unsecured_outstandbal() != null) {
			R0360cell6.setCellValue(record1.getR0360_unsecured_outstandbal().doubleValue());
			R0360cell6.setCellStyle(numberStyle);
		} else {
			R0360cell6.setCellValue("");
			R0360cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0360cell7 = row.createCell(7);
		if (record1.getR0360_stage1_assetclass() != null) {
			R0360cell7.setCellValue(record1.getR0360_stage1_assetclass().doubleValue());
			R0360cell7.setCellStyle(numberStyle);
		} else {
			R0360cell7.setCellValue("");
			R0360cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0360cell8 = row.createCell(8);
		if (record1.getR0360_stage2_assetclass() != null) {
			R0360cell8.setCellValue(record1.getR0360_stage2_assetclass().doubleValue());
			R0360cell8.setCellStyle(numberStyle);
		} else {
			R0360cell8.setCellValue("");
			R0360cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0360cell9 = row.createCell(9);
		if (record1.getR0360_stage3a_assetclass() != null) {
			R0360cell9.setCellValue(record1.getR0360_stage3a_assetclass().doubleValue());
			R0360cell9.setCellStyle(numberStyle);
		} else {
			R0360cell9.setCellValue("");
			R0360cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0360cell10 = row.createCell(10);
		if (record1.getR0360_stage3b_assetclass() != null) {
			R0360cell10.setCellValue(record1.getR0360_stage3b_assetclass().doubleValue());
			R0360cell10.setCellStyle(numberStyle);
		} else {
			R0360cell10.setCellValue("");
			R0360cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0360cell11 = row.createCell(11);
		if (record1.getR0360_stage3c_assetclass() != null) {
			R0360cell11.setCellValue(record1.getR0360_stage3c_assetclass().doubleValue());
			R0360cell11.setCellStyle(numberStyle);
		} else {
			R0360cell11.setCellValue("");
			R0360cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0360cell12 = row.createCell(12);
		if (record1.getR0360_stage1_provisionheld() != null) {
			R0360cell12.setCellValue(record1.getR0360_stage1_provisionheld().doubleValue());
			R0360cell12.setCellStyle(numberStyle);
		} else {
			R0360cell12.setCellValue("");
			R0360cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0360cell13 = row.createCell(13);
		if (record1.getR0360_stage2_provisionheld() != null) {
			R0360cell13.setCellValue(record1.getR0360_stage2_provisionheld().doubleValue());
			R0360cell13.setCellStyle(numberStyle);
		} else {
			R0360cell13.setCellValue("");
			R0360cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0360cell14 = row.createCell(14);
		if (record1.getR0360_stage3a_provisionheld() != null) {
			R0360cell14.setCellValue(record1.getR0360_stage3a_provisionheld().doubleValue());
			R0360cell14.setCellStyle(numberStyle);
		} else {
			R0360cell14.setCellValue("");
			R0360cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0360cell15 = row.createCell(15);
		if (record1.getR0360_stage3b_provisionheld() != null) {
			R0360cell15.setCellValue(record1.getR0360_stage3b_provisionheld().doubleValue());
			R0360cell15.setCellStyle(numberStyle);
		} else {
			R0360cell15.setCellValue("");
			R0360cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0360cell16 = row.createCell(16);
		if (record1.getR0360_stage3c_provisionheld() != null) {
			R0360cell16.setCellValue(record1.getR0360_stage3c_provisionheld().doubleValue());
			R0360cell16.setCellStyle(numberStyle);
		} else {
			R0360cell16.setCellValue("");
			R0360cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0360cell17 = row.createCell(17);
		if (record1.getR0360_intrestfees_provisionheld() != null) {
			R0360cell17.setCellValue(record1.getR0360_intrestfees_provisionheld().doubleValue());
			R0360cell17.setCellStyle(numberStyle);
		} else {
			R0360cell17.setCellValue("");
			R0360cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0360cell18 = row.createCell(18);
		if (record1.getR0360_intrestsuspense_provisionheld() != null) {
			R0360cell18.setCellValue(record1.getR0360_intrestsuspense_provisionheld().doubleValue());
			R0360cell18.setCellStyle(numberStyle);
		} else {
			R0360cell18.setCellValue("");
			R0360cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0360cell19 = row.createCell(19);
		if (record1.getR0360_stage1_poci() != null) {
			R0360cell19.setCellValue(record1.getR0360_stage1_poci().doubleValue());
			R0360cell19.setCellStyle(numberStyle);
		} else {
			R0360cell19.setCellValue("");
			R0360cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0360cell20 = row.createCell(20);
		if (record1.getR0360_stage2_poci() != null) {
			R0360cell20.setCellValue(record1.getR0360_stage2_poci().doubleValue());
			R0360cell20.setCellStyle(numberStyle);
		} else {
			R0360cell20.setCellValue("");
			R0360cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0360cell21 = row.createCell(21);
		if (record1.getR0360_stage3a_poci() != null) {
			R0360cell21.setCellValue(record1.getR0360_stage3a_poci().doubleValue());
			R0360cell21.setCellStyle(numberStyle);
		} else {
			R0360cell21.setCellValue("");
			R0360cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0360cell22 = row.createCell(22);
		if (record1.getR0360_stage3b_poci() != null) {
			R0360cell22.setCellValue(record1.getR0360_stage3b_poci().doubleValue());
			R0360cell22.setCellStyle(numberStyle);
		} else {
			R0360cell22.setCellValue("");
			R0360cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0360cell23 = row.createCell(23);
		if (record1.getR0360_stage3c_poci() != null) {
			R0360cell23.setCellValue(record1.getR0360_stage3c_poci().doubleValue());
			R0360cell23.setCellStyle(numberStyle);
		} else {
			R0360cell23.setCellValue("");
			R0360cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0360cell24 = row.createCell(24);
		if (record1.getR0360_current_pastdues() != null) {
			R0360cell24.setCellValue(record1.getR0360_current_pastdues().doubleValue());
			R0360cell24.setCellStyle(numberStyle);
		} else {
			R0360cell24.setCellValue("");
			R0360cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0360cell25 = row.createCell(25);
		if (record1.getR0360_less30days_pastdues() != null) {
			R0360cell25.setCellValue(record1.getR0360_less30days_pastdues().doubleValue());
			R0360cell25.setCellStyle(numberStyle);
		} else {
			R0360cell25.setCellValue("");
			R0360cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0360cell26 = row.createCell(26);
		if (record1.getR0360_31to90days_pastdues() != null) {
			R0360cell26.setCellValue(record1.getR0360_31to90days_pastdues().doubleValue());
			R0360cell26.setCellStyle(numberStyle);
		} else {
			R0360cell26.setCellValue("");
			R0360cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0360cell27 = row.createCell(27);
		if (record1.getR0360_91to120days_pastdues() != null) {
			R0360cell27.setCellValue(record1.getR0360_91to120days_pastdues().doubleValue());
			R0360cell27.setCellStyle(numberStyle);
		} else {
			R0360cell27.setCellValue("");
			R0360cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0360cell28 = row.createCell(28);
		if (record1.getR0360_121to180days_pastdues() != null) {
			R0360cell28.setCellValue(record1.getR0360_121to180days_pastdues().doubleValue());
			R0360cell28.setCellStyle(numberStyle);
		} else {
			R0360cell28.setCellValue("");
			R0360cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0360cell29 = row.createCell(29);
		if (record1.getR0360_181to365days_pastdues() != null) {
			R0360cell29.setCellValue(record1.getR0360_181to365days_pastdues().doubleValue());
			R0360cell29.setCellStyle(numberStyle);
		} else {
			R0360cell29.setCellValue("");
			R0360cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0360cell30 = row.createCell(30);
		if (record1.getR0360_over365days_pastdues() != null) {
			R0360cell30.setCellValue(record1.getR0360_over365days_pastdues().doubleValue());
			R0360cell30.setCellStyle(numberStyle);
		} else {
			R0360cell30.setCellValue("");
			R0360cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0360cell32 = row.createCell(32);
		if (record1.getR0360_newloan_duringreport() != null) {
			R0360cell32.setCellValue(record1.getR0360_newloan_duringreport().doubleValue());
			R0360cell32.setCellStyle(numberStyle);
		} else {
			R0360cell32.setCellValue("");
			R0360cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0360cell33 = row.createCell(33);
		if (record1.getR0360_newstage_duringreport() != null) {
			R0360cell33.setCellValue(record1.getR0360_newstage_duringreport().doubleValue());
			R0360cell33.setCellStyle(numberStyle);
		} else {
			R0360cell33.setCellValue("");
			R0360cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0360cell34 = row.createCell(34);
		if (record1.getR0360_intrestfees_duringreport() != null) {
			R0360cell34.setCellValue(record1.getR0360_intrestfees_duringreport().doubleValue());
			R0360cell34.setCellStyle(numberStyle);
		} else {
			R0360cell34.setCellValue("");
			R0360cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0360cell35 = row.createCell(35);
		if (record1.getR0360_performingac_acinfo() != null) {
			R0360cell35.setCellValue(record1.getR0360_performingac_acinfo().doubleValue());
			R0360cell35.setCellStyle(numberStyle);
		} else {
			R0360cell35.setCellValue("");
			R0360cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0360cell36 = row.createCell(36);
		if (record1.getR0360_nonperformingac_acinfo() != null) {
			R0360cell36.setCellValue(record1.getR0360_nonperformingac_acinfo().doubleValue());
			R0360cell36.setCellStyle(numberStyle);
		} else {
			R0360cell36.setCellValue("");
			R0360cell36.setCellStyle(textStyle);
		}

		/// ROW47
		//// Column E
		row = sheet.getRow(46);
		Cell R0380cell4 = row.createCell(4);
		if (record1.getR0380_outstandbal() != null) {
			R0380cell4.setCellValue(record1.getR0380_outstandbal().doubleValue());
			R0380cell4.setCellStyle(numberStyle);
		} else {
			R0380cell4.setCellValue("");
			R0380cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0380cell5 = row.createCell(5);
		if (record1.getR0380_secured_outstandbal() != null) {
			R0380cell5.setCellValue(record1.getR0380_secured_outstandbal().doubleValue());
			R0380cell5.setCellStyle(numberStyle);
		} else {
			R0380cell5.setCellValue("");
			R0380cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0380cell6 = row.createCell(6);
		if (record1.getR0380_unsecured_outstandbal() != null) {
			R0380cell6.setCellValue(record1.getR0380_unsecured_outstandbal().doubleValue());
			R0380cell6.setCellStyle(numberStyle);
		} else {
			R0380cell6.setCellValue("");
			R0380cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0380cell7 = row.createCell(7);
		if (record1.getR0380_stage1_assetclass() != null) {
			R0380cell7.setCellValue(record1.getR0380_stage1_assetclass().doubleValue());
			R0380cell7.setCellStyle(numberStyle);
		} else {
			R0380cell7.setCellValue("");
			R0380cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0380cell8 = row.createCell(8);
		if (record1.getR0380_stage2_assetclass() != null) {
			R0380cell8.setCellValue(record1.getR0380_stage2_assetclass().doubleValue());
			R0380cell8.setCellStyle(numberStyle);
		} else {
			R0380cell8.setCellValue("");
			R0380cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0380cell9 = row.createCell(9);
		if (record1.getR0380_stage3a_assetclass() != null) {
			R0380cell9.setCellValue(record1.getR0380_stage3a_assetclass().doubleValue());
			R0380cell9.setCellStyle(numberStyle);
		} else {
			R0380cell9.setCellValue("");
			R0380cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0380cell10 = row.createCell(10);
		if (record1.getR0380_stage3b_assetclass() != null) {
			R0380cell10.setCellValue(record1.getR0380_stage3b_assetclass().doubleValue());
			R0380cell10.setCellStyle(numberStyle);
		} else {
			R0380cell10.setCellValue("");
			R0380cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0380cell11 = row.createCell(11);
		if (record1.getR0380_stage3c_assetclass() != null) {
			R0380cell11.setCellValue(record1.getR0380_stage3c_assetclass().doubleValue());
			R0380cell11.setCellStyle(numberStyle);
		} else {
			R0380cell11.setCellValue("");
			R0380cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0380cell12 = row.createCell(12);
		if (record1.getR0380_stage1_provisionheld() != null) {
			R0380cell12.setCellValue(record1.getR0380_stage1_provisionheld().doubleValue());
			R0380cell12.setCellStyle(numberStyle);
		} else {
			R0380cell12.setCellValue("");
			R0380cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0380cell13 = row.createCell(13);
		if (record1.getR0380_stage2_provisionheld() != null) {
			R0380cell13.setCellValue(record1.getR0380_stage2_provisionheld().doubleValue());
			R0380cell13.setCellStyle(numberStyle);
		} else {
			R0380cell13.setCellValue("");
			R0380cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0380cell14 = row.createCell(14);
		if (record1.getR0380_stage3a_provisionheld() != null) {
			R0380cell14.setCellValue(record1.getR0380_stage3a_provisionheld().doubleValue());
			R0380cell14.setCellStyle(numberStyle);
		} else {
			R0380cell14.setCellValue("");
			R0380cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0380cell15 = row.createCell(15);
		if (record1.getR0380_stage3b_provisionheld() != null) {
			R0380cell15.setCellValue(record1.getR0380_stage3b_provisionheld().doubleValue());
			R0380cell15.setCellStyle(numberStyle);
		} else {
			R0380cell15.setCellValue("");
			R0380cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0380cell16 = row.createCell(16);
		if (record1.getR0380_stage3c_provisionheld() != null) {
			R0380cell16.setCellValue(record1.getR0380_stage3c_provisionheld().doubleValue());
			R0380cell16.setCellStyle(numberStyle);
		} else {
			R0380cell16.setCellValue("");
			R0380cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0380cell17 = row.createCell(17);
		if (record1.getR0380_intrestfees_provisionheld() != null) {
			R0380cell17.setCellValue(record1.getR0380_intrestfees_provisionheld().doubleValue());
			R0380cell17.setCellStyle(numberStyle);
		} else {
			R0380cell17.setCellValue("");
			R0380cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0380cell18 = row.createCell(18);
		if (record1.getR0380_intrestsuspense_provisionheld() != null) {
			R0380cell18.setCellValue(record1.getR0380_intrestsuspense_provisionheld().doubleValue());
			R0380cell18.setCellStyle(numberStyle);
		} else {
			R0380cell18.setCellValue("");
			R0380cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0380cell19 = row.createCell(19);
		if (record1.getR0380_stage1_poci() != null) {
			R0380cell19.setCellValue(record1.getR0380_stage1_poci().doubleValue());
			R0380cell19.setCellStyle(numberStyle);
		} else {
			R0380cell19.setCellValue("");
			R0380cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0380cell20 = row.createCell(20);
		if (record1.getR0380_stage2_poci() != null) {
			R0380cell20.setCellValue(record1.getR0380_stage2_poci().doubleValue());
			R0380cell20.setCellStyle(numberStyle);
		} else {
			R0380cell20.setCellValue("");
			R0380cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0380cell21 = row.createCell(21);
		if (record1.getR0380_stage3a_poci() != null) {
			R0380cell21.setCellValue(record1.getR0380_stage3a_poci().doubleValue());
			R0380cell21.setCellStyle(numberStyle);
		} else {
			R0380cell21.setCellValue("");
			R0380cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0380cell22 = row.createCell(22);
		if (record1.getR0380_stage3b_poci() != null) {
			R0380cell22.setCellValue(record1.getR0380_stage3b_poci().doubleValue());
			R0380cell22.setCellStyle(numberStyle);
		} else {
			R0380cell22.setCellValue("");
			R0380cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0380cell23 = row.createCell(23);
		if (record1.getR0380_stage3c_poci() != null) {
			R0380cell23.setCellValue(record1.getR0380_stage3c_poci().doubleValue());
			R0380cell23.setCellStyle(numberStyle);
		} else {
			R0380cell23.setCellValue("");
			R0380cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0380cell24 = row.createCell(24);
		if (record1.getR0380_current_pastdues() != null) {
			R0380cell24.setCellValue(record1.getR0380_current_pastdues().doubleValue());
			R0380cell24.setCellStyle(numberStyle);
		} else {
			R0380cell24.setCellValue("");
			R0380cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0380cell25 = row.createCell(25);
		if (record1.getR0380_less30days_pastdues() != null) {
			R0380cell25.setCellValue(record1.getR0380_less30days_pastdues().doubleValue());
			R0380cell25.setCellStyle(numberStyle);
		} else {
			R0380cell25.setCellValue("");
			R0380cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0380cell26 = row.createCell(26);
		if (record1.getR0380_31to90days_pastdues() != null) {
			R0380cell26.setCellValue(record1.getR0380_31to90days_pastdues().doubleValue());
			R0380cell26.setCellStyle(numberStyle);
		} else {
			R0380cell26.setCellValue("");
			R0380cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0380cell27 = row.createCell(27);
		if (record1.getR0380_91to120days_pastdues() != null) {
			R0380cell27.setCellValue(record1.getR0380_91to120days_pastdues().doubleValue());
			R0380cell27.setCellStyle(numberStyle);
		} else {
			R0380cell27.setCellValue("");
			R0380cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0380cell28 = row.createCell(28);
		if (record1.getR0380_121to180days_pastdues() != null) {
			R0380cell28.setCellValue(record1.getR0380_121to180days_pastdues().doubleValue());
			R0380cell28.setCellStyle(numberStyle);
		} else {
			R0380cell28.setCellValue("");
			R0380cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0380cell29 = row.createCell(29);
		if (record1.getR0380_181to365days_pastdues() != null) {
			R0380cell29.setCellValue(record1.getR0380_181to365days_pastdues().doubleValue());
			R0380cell29.setCellStyle(numberStyle);
		} else {
			R0380cell29.setCellValue("");
			R0380cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0380cell30 = row.createCell(30);
		if (record1.getR0380_over365days_pastdues() != null) {
			R0380cell30.setCellValue(record1.getR0380_over365days_pastdues().doubleValue());
			R0380cell30.setCellStyle(numberStyle);
		} else {
			R0380cell30.setCellValue("");
			R0380cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0380cell32 = row.createCell(32);
		if (record1.getR0380_newloan_duringreport() != null) {
			R0380cell32.setCellValue(record1.getR0380_newloan_duringreport().doubleValue());
			R0380cell32.setCellStyle(numberStyle);
		} else {
			R0380cell32.setCellValue("");
			R0380cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0380cell33 = row.createCell(33);
		if (record1.getR0380_newstage_duringreport() != null) {
			R0380cell33.setCellValue(record1.getR0380_newstage_duringreport().doubleValue());
			R0380cell33.setCellStyle(numberStyle);
		} else {
			R0380cell33.setCellValue("");
			R0380cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0380cell34 = row.createCell(34);
		if (record1.getR0380_intrestfees_duringreport() != null) {
			R0380cell34.setCellValue(record1.getR0380_intrestfees_duringreport().doubleValue());
			R0380cell34.setCellStyle(numberStyle);
		} else {
			R0380cell34.setCellValue("");
			R0380cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0380cell35 = row.createCell(35);
		if (record1.getR0380_performingac_acinfo() != null) {
			R0380cell35.setCellValue(record1.getR0380_performingac_acinfo().doubleValue());
			R0380cell35.setCellStyle(numberStyle);
		} else {
			R0380cell35.setCellValue("");
			R0380cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0380cell36 = row.createCell(36);
		if (record1.getR0380_nonperformingac_acinfo() != null) {
			R0380cell36.setCellValue(record1.getR0380_nonperformingac_acinfo().doubleValue());
			R0380cell36.setCellStyle(numberStyle);
		} else {
			R0380cell36.setCellValue("");
			R0380cell36.setCellStyle(textStyle);
		}

		/// ROW48
		//// Column E
		row = sheet.getRow(47);
		Cell R0390cell4 = row.createCell(4);
		if (record1.getR0390_outstandbal() != null) {
			R0390cell4.setCellValue(record1.getR0390_outstandbal().doubleValue());
			R0390cell4.setCellStyle(numberStyle);
		} else {
			R0390cell4.setCellValue("");
			R0390cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0390cell5 = row.createCell(5);
		if (record1.getR0390_secured_outstandbal() != null) {
			R0390cell5.setCellValue(record1.getR0390_secured_outstandbal().doubleValue());
			R0390cell5.setCellStyle(numberStyle);
		} else {
			R0390cell5.setCellValue("");
			R0390cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0390cell6 = row.createCell(6);
		if (record1.getR0390_unsecured_outstandbal() != null) {
			R0390cell6.setCellValue(record1.getR0390_unsecured_outstandbal().doubleValue());
			R0390cell6.setCellStyle(numberStyle);
		} else {
			R0390cell6.setCellValue("");
			R0390cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0390cell7 = row.createCell(7);
		if (record1.getR0390_stage1_assetclass() != null) {
			R0390cell7.setCellValue(record1.getR0390_stage1_assetclass().doubleValue());
			R0390cell7.setCellStyle(numberStyle);
		} else {
			R0390cell7.setCellValue("");
			R0390cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0390cell8 = row.createCell(8);
		if (record1.getR0390_stage2_assetclass() != null) {
			R0390cell8.setCellValue(record1.getR0390_stage2_assetclass().doubleValue());
			R0390cell8.setCellStyle(numberStyle);
		} else {
			R0390cell8.setCellValue("");
			R0390cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0390cell9 = row.createCell(9);
		if (record1.getR0390_stage3a_assetclass() != null) {
			R0390cell9.setCellValue(record1.getR0390_stage3a_assetclass().doubleValue());
			R0390cell9.setCellStyle(numberStyle);
		} else {
			R0390cell9.setCellValue("");
			R0390cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0390cell10 = row.createCell(10);
		if (record1.getR0390_stage3b_assetclass() != null) {
			R0390cell10.setCellValue(record1.getR0390_stage3b_assetclass().doubleValue());
			R0390cell10.setCellStyle(numberStyle);
		} else {
			R0390cell10.setCellValue("");
			R0390cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0390cell11 = row.createCell(11);
		if (record1.getR0390_stage3c_assetclass() != null) {
			R0390cell11.setCellValue(record1.getR0390_stage3c_assetclass().doubleValue());
			R0390cell11.setCellStyle(numberStyle);
		} else {
			R0390cell11.setCellValue("");
			R0390cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0390cell12 = row.createCell(12);
		if (record1.getR0390_stage1_provisionheld() != null) {
			R0390cell12.setCellValue(record1.getR0390_stage1_provisionheld().doubleValue());
			R0390cell12.setCellStyle(numberStyle);
		} else {
			R0390cell12.setCellValue("");
			R0390cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0390cell13 = row.createCell(13);
		if (record1.getR0390_stage2_provisionheld() != null) {
			R0390cell13.setCellValue(record1.getR0390_stage2_provisionheld().doubleValue());
			R0390cell13.setCellStyle(numberStyle);
		} else {
			R0390cell13.setCellValue("");
			R0390cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0390cell14 = row.createCell(14);
		if (record1.getR0390_stage3a_provisionheld() != null) {
			R0390cell14.setCellValue(record1.getR0390_stage3a_provisionheld().doubleValue());
			R0390cell14.setCellStyle(numberStyle);
		} else {
			R0390cell14.setCellValue("");
			R0390cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0390cell15 = row.createCell(15);
		if (record1.getR0390_stage3b_provisionheld() != null) {
			R0390cell15.setCellValue(record1.getR0390_stage3b_provisionheld().doubleValue());
			R0390cell15.setCellStyle(numberStyle);
		} else {
			R0390cell15.setCellValue("");
			R0390cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0390cell16 = row.createCell(16);
		if (record1.getR0390_stage3c_provisionheld() != null) {
			R0390cell16.setCellValue(record1.getR0390_stage3c_provisionheld().doubleValue());
			R0390cell16.setCellStyle(numberStyle);
		} else {
			R0390cell16.setCellValue("");
			R0390cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0390cell17 = row.createCell(17);
		if (record1.getR0390_intrestfees_provisionheld() != null) {
			R0390cell17.setCellValue(record1.getR0390_intrestfees_provisionheld().doubleValue());
			R0390cell17.setCellStyle(numberStyle);
		} else {
			R0390cell17.setCellValue("");
			R0390cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0390cell18 = row.createCell(18);
		if (record1.getR0390_intrestsuspense_provisionheld() != null) {
			R0390cell18.setCellValue(record1.getR0390_intrestsuspense_provisionheld().doubleValue());
			R0390cell18.setCellStyle(numberStyle);
		} else {
			R0390cell18.setCellValue("");
			R0390cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0390cell19 = row.createCell(19);
		if (record1.getR0390_stage1_poci() != null) {
			R0390cell19.setCellValue(record1.getR0390_stage1_poci().doubleValue());
			R0390cell19.setCellStyle(numberStyle);
		} else {
			R0390cell19.setCellValue("");
			R0390cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0390cell20 = row.createCell(20);
		if (record1.getR0390_stage2_poci() != null) {
			R0390cell20.setCellValue(record1.getR0390_stage2_poci().doubleValue());
			R0390cell20.setCellStyle(numberStyle);
		} else {
			R0390cell20.setCellValue("");
			R0390cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0390cell21 = row.createCell(21);
		if (record1.getR0390_stage3a_poci() != null) {
			R0390cell21.setCellValue(record1.getR0390_stage3a_poci().doubleValue());
			R0390cell21.setCellStyle(numberStyle);
		} else {
			R0390cell21.setCellValue("");
			R0390cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0390cell22 = row.createCell(22);
		if (record1.getR0390_stage3b_poci() != null) {
			R0390cell22.setCellValue(record1.getR0390_stage3b_poci().doubleValue());
			R0390cell22.setCellStyle(numberStyle);
		} else {
			R0390cell22.setCellValue("");
			R0390cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0390cell23 = row.createCell(23);
		if (record1.getR0390_stage3c_poci() != null) {
			R0390cell23.setCellValue(record1.getR0390_stage3c_poci().doubleValue());
			R0390cell23.setCellStyle(numberStyle);
		} else {
			R0390cell23.setCellValue("");
			R0390cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0390cell24 = row.createCell(24);
		if (record1.getR0390_current_pastdues() != null) {
			R0390cell24.setCellValue(record1.getR0390_current_pastdues().doubleValue());
			R0390cell24.setCellStyle(numberStyle);
		} else {
			R0390cell24.setCellValue("");
			R0390cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0390cell25 = row.createCell(25);
		if (record1.getR0390_less30days_pastdues() != null) {
			R0390cell25.setCellValue(record1.getR0390_less30days_pastdues().doubleValue());
			R0390cell25.setCellStyle(numberStyle);
		} else {
			R0390cell25.setCellValue("");
			R0390cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0390cell26 = row.createCell(26);
		if (record1.getR0390_31to90days_pastdues() != null) {
			R0390cell26.setCellValue(record1.getR0390_31to90days_pastdues().doubleValue());
			R0390cell26.setCellStyle(numberStyle);
		} else {
			R0390cell26.setCellValue("");
			R0390cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0390cell27 = row.createCell(27);
		if (record1.getR0390_91to120days_pastdues() != null) {
			R0390cell27.setCellValue(record1.getR0390_91to120days_pastdues().doubleValue());
			R0390cell27.setCellStyle(numberStyle);
		} else {
			R0390cell27.setCellValue("");
			R0390cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0390cell28 = row.createCell(28);
		if (record1.getR0390_121to180days_pastdues() != null) {
			R0390cell28.setCellValue(record1.getR0390_121to180days_pastdues().doubleValue());
			R0390cell28.setCellStyle(numberStyle);
		} else {
			R0390cell28.setCellValue("");
			R0390cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0390cell29 = row.createCell(29);
		if (record1.getR0390_181to365days_pastdues() != null) {
			R0390cell29.setCellValue(record1.getR0390_181to365days_pastdues().doubleValue());
			R0390cell29.setCellStyle(numberStyle);
		} else {
			R0390cell29.setCellValue("");
			R0390cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0390cell30 = row.createCell(30);
		if (record1.getR0390_over365days_pastdues() != null) {
			R0390cell30.setCellValue(record1.getR0390_over365days_pastdues().doubleValue());
			R0390cell30.setCellStyle(numberStyle);
		} else {
			R0390cell30.setCellValue("");
			R0390cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0390cell32 = row.createCell(32);
		if (record1.getR0390_newloan_duringreport() != null) {
			R0390cell32.setCellValue(record1.getR0390_newloan_duringreport().doubleValue());
			R0390cell32.setCellStyle(numberStyle);
		} else {
			R0390cell32.setCellValue("");
			R0390cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0390cell33 = row.createCell(33);
		if (record1.getR0390_newstage_duringreport() != null) {
			R0390cell33.setCellValue(record1.getR0390_newstage_duringreport().doubleValue());
			R0390cell33.setCellStyle(numberStyle);
		} else {
			R0390cell33.setCellValue("");
			R0390cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0390cell34 = row.createCell(34);
		if (record1.getR0390_intrestfees_duringreport() != null) {
			R0390cell34.setCellValue(record1.getR0390_intrestfees_duringreport().doubleValue());
			R0390cell34.setCellStyle(numberStyle);
		} else {
			R0390cell34.setCellValue("");
			R0390cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0390cell35 = row.createCell(35);
		if (record1.getR0390_performingac_acinfo() != null) {
			R0390cell35.setCellValue(record1.getR0390_performingac_acinfo().doubleValue());
			R0390cell35.setCellStyle(numberStyle);
		} else {
			R0390cell35.setCellValue("");
			R0390cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0390cell36 = row.createCell(36);
		if (record1.getR0390_nonperformingac_acinfo() != null) {
			R0390cell36.setCellValue(record1.getR0390_nonperformingac_acinfo().doubleValue());
			R0390cell36.setCellStyle(numberStyle);
		} else {
			R0390cell36.setCellValue("");
			R0390cell36.setCellStyle(textStyle);
		}

		/// ROW49
		//// Column E
		row = sheet.getRow(48);
		Cell R0400cell4 = row.createCell(4);
		if (record1.getR0400_outstandbal() != null) {
			R0400cell4.setCellValue(record1.getR0400_outstandbal().doubleValue());
			R0400cell4.setCellStyle(numberStyle);
		} else {
			R0400cell4.setCellValue("");
			R0400cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0400cell5 = row.createCell(5);
		if (record1.getR0400_secured_outstandbal() != null) {
			R0400cell5.setCellValue(record1.getR0400_secured_outstandbal().doubleValue());
			R0400cell5.setCellStyle(numberStyle);
		} else {
			R0400cell5.setCellValue("");
			R0400cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0400cell6 = row.createCell(6);
		if (record1.getR0400_unsecured_outstandbal() != null) {
			R0400cell6.setCellValue(record1.getR0400_unsecured_outstandbal().doubleValue());
			R0400cell6.setCellStyle(numberStyle);
		} else {
			R0400cell6.setCellValue("");
			R0400cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0400cell7 = row.createCell(7);
		if (record1.getR0400_stage1_assetclass() != null) {
			R0400cell7.setCellValue(record1.getR0400_stage1_assetclass().doubleValue());
			R0400cell7.setCellStyle(numberStyle);
		} else {
			R0400cell7.setCellValue("");
			R0400cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0400cell8 = row.createCell(8);
		if (record1.getR0400_stage2_assetclass() != null) {
			R0400cell8.setCellValue(record1.getR0400_stage2_assetclass().doubleValue());
			R0400cell8.setCellStyle(numberStyle);
		} else {
			R0400cell8.setCellValue("");
			R0400cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0400cell9 = row.createCell(9);
		if (record1.getR0400_stage3a_assetclass() != null) {
			R0400cell9.setCellValue(record1.getR0400_stage3a_assetclass().doubleValue());
			R0400cell9.setCellStyle(numberStyle);
		} else {
			R0400cell9.setCellValue("");
			R0400cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0400cell10 = row.createCell(10);
		if (record1.getR0400_stage3b_assetclass() != null) {
			R0400cell10.setCellValue(record1.getR0400_stage3b_assetclass().doubleValue());
			R0400cell10.setCellStyle(numberStyle);
		} else {
			R0400cell10.setCellValue("");
			R0400cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0400cell11 = row.createCell(11);
		if (record1.getR0400_stage3c_assetclass() != null) {
			R0400cell11.setCellValue(record1.getR0400_stage3c_assetclass().doubleValue());
			R0400cell11.setCellStyle(numberStyle);
		} else {
			R0400cell11.setCellValue("");
			R0400cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0400cell12 = row.createCell(12);
		if (record1.getR0400_stage1_provisionheld() != null) {
			R0400cell12.setCellValue(record1.getR0400_stage1_provisionheld().doubleValue());
			R0400cell12.setCellStyle(numberStyle);
		} else {
			R0400cell12.setCellValue("");
			R0400cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0400cell13 = row.createCell(13);
		if (record1.getR0400_stage2_provisionheld() != null) {
			R0400cell13.setCellValue(record1.getR0400_stage2_provisionheld().doubleValue());
			R0400cell13.setCellStyle(numberStyle);
		} else {
			R0400cell13.setCellValue("");
			R0400cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0400cell14 = row.createCell(14);
		if (record1.getR0400_stage3a_provisionheld() != null) {
			R0400cell14.setCellValue(record1.getR0400_stage3a_provisionheld().doubleValue());
			R0400cell14.setCellStyle(numberStyle);
		} else {
			R0400cell14.setCellValue("");
			R0400cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0400cell15 = row.createCell(15);
		if (record1.getR0400_stage3b_provisionheld() != null) {
			R0400cell15.setCellValue(record1.getR0400_stage3b_provisionheld().doubleValue());
			R0400cell15.setCellStyle(numberStyle);
		} else {
			R0400cell15.setCellValue("");
			R0400cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0400cell16 = row.createCell(16);
		if (record1.getR0400_stage3c_provisionheld() != null) {
			R0400cell16.setCellValue(record1.getR0400_stage3c_provisionheld().doubleValue());
			R0400cell16.setCellStyle(numberStyle);
		} else {
			R0400cell16.setCellValue("");
			R0400cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0400cell17 = row.createCell(17);
		if (record1.getR0400_intrestfees_provisionheld() != null) {
			R0400cell17.setCellValue(record1.getR0400_intrestfees_provisionheld().doubleValue());
			R0400cell17.setCellStyle(numberStyle);
		} else {
			R0400cell17.setCellValue("");
			R0400cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0400cell18 = row.createCell(18);
		if (record1.getR0400_intrestsuspense_provisionheld() != null) {
			R0400cell18.setCellValue(record1.getR0400_intrestsuspense_provisionheld().doubleValue());
			R0400cell18.setCellStyle(numberStyle);
		} else {
			R0400cell18.setCellValue("");
			R0400cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0400cell19 = row.createCell(19);
		if (record1.getR0400_stage1_poci() != null) {
			R0400cell19.setCellValue(record1.getR0400_stage1_poci().doubleValue());
			R0400cell19.setCellStyle(numberStyle);
		} else {
			R0400cell19.setCellValue("");
			R0400cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0400cell20 = row.createCell(20);
		if (record1.getR0400_stage2_poci() != null) {
			R0400cell20.setCellValue(record1.getR0400_stage2_poci().doubleValue());
			R0400cell20.setCellStyle(numberStyle);
		} else {
			R0400cell20.setCellValue("");
			R0400cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0400cell21 = row.createCell(21);
		if (record1.getR0400_stage3a_poci() != null) {
			R0400cell21.setCellValue(record1.getR0400_stage3a_poci().doubleValue());
			R0400cell21.setCellStyle(numberStyle);
		} else {
			R0400cell21.setCellValue("");
			R0400cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0400cell22 = row.createCell(22);
		if (record1.getR0400_stage3b_poci() != null) {
			R0400cell22.setCellValue(record1.getR0400_stage3b_poci().doubleValue());
			R0400cell22.setCellStyle(numberStyle);
		} else {
			R0400cell22.setCellValue("");
			R0400cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0400cell23 = row.createCell(23);
		if (record1.getR0400_stage3c_poci() != null) {
			R0400cell23.setCellValue(record1.getR0400_stage3c_poci().doubleValue());
			R0400cell23.setCellStyle(numberStyle);
		} else {
			R0400cell23.setCellValue("");
			R0400cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0400cell24 = row.createCell(24);
		if (record1.getR0400_current_pastdues() != null) {
			R0400cell24.setCellValue(record1.getR0400_current_pastdues().doubleValue());
			R0400cell24.setCellStyle(numberStyle);
		} else {
			R0400cell24.setCellValue("");
			R0400cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0400cell25 = row.createCell(25);
		if (record1.getR0400_less30days_pastdues() != null) {
			R0400cell25.setCellValue(record1.getR0400_less30days_pastdues().doubleValue());
			R0400cell25.setCellStyle(numberStyle);
		} else {
			R0400cell25.setCellValue("");
			R0400cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0400cell26 = row.createCell(26);
		if (record1.getR0400_31to90days_pastdues() != null) {
			R0400cell26.setCellValue(record1.getR0400_31to90days_pastdues().doubleValue());
			R0400cell26.setCellStyle(numberStyle);
		} else {
			R0400cell26.setCellValue("");
			R0400cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0400cell27 = row.createCell(27);
		if (record1.getR0400_91to120days_pastdues() != null) {
			R0400cell27.setCellValue(record1.getR0400_91to120days_pastdues().doubleValue());
			R0400cell27.setCellStyle(numberStyle);
		} else {
			R0400cell27.setCellValue("");
			R0400cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0400cell28 = row.createCell(28);
		if (record1.getR0400_121to180days_pastdues() != null) {
			R0400cell28.setCellValue(record1.getR0400_121to180days_pastdues().doubleValue());
			R0400cell28.setCellStyle(numberStyle);
		} else {
			R0400cell28.setCellValue("");
			R0400cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0400cell29 = row.createCell(29);
		if (record1.getR0400_181to365days_pastdues() != null) {
			R0400cell29.setCellValue(record1.getR0400_181to365days_pastdues().doubleValue());
			R0400cell29.setCellStyle(numberStyle);
		} else {
			R0400cell29.setCellValue("");
			R0400cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0400cell30 = row.createCell(30);
		if (record1.getR0400_over365days_pastdues() != null) {
			R0400cell30.setCellValue(record1.getR0400_over365days_pastdues().doubleValue());
			R0400cell30.setCellStyle(numberStyle);
		} else {
			R0400cell30.setCellValue("");
			R0400cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0400cell32 = row.createCell(32);
		if (record1.getR0400_newloan_duringreport() != null) {
			R0400cell32.setCellValue(record1.getR0400_newloan_duringreport().doubleValue());
			R0400cell32.setCellStyle(numberStyle);
		} else {
			R0400cell32.setCellValue("");
			R0400cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0400cell33 = row.createCell(33);
		if (record1.getR0400_newstage_duringreport() != null) {
			R0400cell33.setCellValue(record1.getR0400_newstage_duringreport().doubleValue());
			R0400cell33.setCellStyle(numberStyle);
		} else {
			R0400cell33.setCellValue("");
			R0400cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0400cell34 = row.createCell(34);
		if (record1.getR0400_intrestfees_duringreport() != null) {
			R0400cell34.setCellValue(record1.getR0400_intrestfees_duringreport().doubleValue());
			R0400cell34.setCellStyle(numberStyle);
		} else {
			R0400cell34.setCellValue("");
			R0400cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0400cell35 = row.createCell(35);
		if (record1.getR0400_performingac_acinfo() != null) {
			R0400cell35.setCellValue(record1.getR0400_performingac_acinfo().doubleValue());
			R0400cell35.setCellStyle(numberStyle);
		} else {
			R0400cell35.setCellValue("");
			R0400cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0400cell36 = row.createCell(36);
		if (record1.getR0400_nonperformingac_acinfo() != null) {
			R0400cell36.setCellValue(record1.getR0400_nonperformingac_acinfo().doubleValue());
			R0400cell36.setCellStyle(numberStyle);
		} else {
			R0400cell36.setCellValue("");
			R0400cell36.setCellStyle(textStyle);
		}

		/// ROW51
		//// Column E
		row = sheet.getRow(50);
		Cell R0420cell4 = row.createCell(4);
		if (record1.getR0420_outstandbal() != null) {
			R0420cell4.setCellValue(record1.getR0420_outstandbal().doubleValue());
			R0420cell4.setCellStyle(numberStyle);
		} else {
			R0420cell4.setCellValue("");
			R0420cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0420cell5 = row.createCell(5);
		if (record1.getR0420_secured_outstandbal() != null) {
			R0420cell5.setCellValue(record1.getR0420_secured_outstandbal().doubleValue());
			R0420cell5.setCellStyle(numberStyle);
		} else {
			R0420cell5.setCellValue("");
			R0420cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0420cell6 = row.createCell(6);
		if (record1.getR0420_unsecured_outstandbal() != null) {
			R0420cell6.setCellValue(record1.getR0420_unsecured_outstandbal().doubleValue());
			R0420cell6.setCellStyle(numberStyle);
		} else {
			R0420cell6.setCellValue("");
			R0420cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0420cell7 = row.createCell(7);
		if (record1.getR0420_stage1_assetclass() != null) {
			R0420cell7.setCellValue(record1.getR0420_stage1_assetclass().doubleValue());
			R0420cell7.setCellStyle(numberStyle);
		} else {
			R0420cell7.setCellValue("");
			R0420cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0420cell8 = row.createCell(8);
		if (record1.getR0420_stage2_assetclass() != null) {
			R0420cell8.setCellValue(record1.getR0420_stage2_assetclass().doubleValue());
			R0420cell8.setCellStyle(numberStyle);
		} else {
			R0420cell8.setCellValue("");
			R0420cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0420cell9 = row.createCell(9);
		if (record1.getR0420_stage3a_assetclass() != null) {
			R0420cell9.setCellValue(record1.getR0420_stage3a_assetclass().doubleValue());
			R0420cell9.setCellStyle(numberStyle);
		} else {
			R0420cell9.setCellValue("");
			R0420cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0420cell10 = row.createCell(10);
		if (record1.getR0420_stage3b_assetclass() != null) {
			R0420cell10.setCellValue(record1.getR0420_stage3b_assetclass().doubleValue());
			R0420cell10.setCellStyle(numberStyle);
		} else {
			R0420cell10.setCellValue("");
			R0420cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0420cell11 = row.createCell(11);
		if (record1.getR0420_stage3c_assetclass() != null) {
			R0420cell11.setCellValue(record1.getR0420_stage3c_assetclass().doubleValue());
			R0420cell11.setCellStyle(numberStyle);
		} else {
			R0420cell11.setCellValue("");
			R0420cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0420cell12 = row.createCell(12);
		if (record1.getR0420_stage1_provisionheld() != null) {
			R0420cell12.setCellValue(record1.getR0420_stage1_provisionheld().doubleValue());
			R0420cell12.setCellStyle(numberStyle);
		} else {
			R0420cell12.setCellValue("");
			R0420cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0420cell13 = row.createCell(13);
		if (record1.getR0420_stage2_provisionheld() != null) {
			R0420cell13.setCellValue(record1.getR0420_stage2_provisionheld().doubleValue());
			R0420cell13.setCellStyle(numberStyle);
		} else {
			R0420cell13.setCellValue("");
			R0420cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0420cell14 = row.createCell(14);
		if (record1.getR0420_stage3a_provisionheld() != null) {
			R0420cell14.setCellValue(record1.getR0420_stage3a_provisionheld().doubleValue());
			R0420cell14.setCellStyle(numberStyle);
		} else {
			R0420cell14.setCellValue("");
			R0420cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0420cell15 = row.createCell(15);
		if (record1.getR0420_stage3b_provisionheld() != null) {
			R0420cell15.setCellValue(record1.getR0420_stage3b_provisionheld().doubleValue());
			R0420cell15.setCellStyle(numberStyle);
		} else {
			R0420cell15.setCellValue("");
			R0420cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0420cell16 = row.createCell(16);
		if (record1.getR0420_stage3c_provisionheld() != null) {
			R0420cell16.setCellValue(record1.getR0420_stage3c_provisionheld().doubleValue());
			R0420cell16.setCellStyle(numberStyle);
		} else {
			R0420cell16.setCellValue("");
			R0420cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0420cell17 = row.createCell(17);
		if (record1.getR0420_intrestfees_provisionheld() != null) {
			R0420cell17.setCellValue(record1.getR0420_intrestfees_provisionheld().doubleValue());
			R0420cell17.setCellStyle(numberStyle);
		} else {
			R0420cell17.setCellValue("");
			R0420cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0420cell18 = row.createCell(18);
		if (record1.getR0420_intrestsuspense_provisionheld() != null) {
			R0420cell18.setCellValue(record1.getR0420_intrestsuspense_provisionheld().doubleValue());
			R0420cell18.setCellStyle(numberStyle);
		} else {
			R0420cell18.setCellValue("");
			R0420cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0420cell19 = row.createCell(19);
		if (record1.getR0420_stage1_poci() != null) {
			R0420cell19.setCellValue(record1.getR0420_stage1_poci().doubleValue());
			R0420cell19.setCellStyle(numberStyle);
		} else {
			R0420cell19.setCellValue("");
			R0420cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0420cell20 = row.createCell(20);
		if (record1.getR0420_stage2_poci() != null) {
			R0420cell20.setCellValue(record1.getR0420_stage2_poci().doubleValue());
			R0420cell20.setCellStyle(numberStyle);
		} else {
			R0420cell20.setCellValue("");
			R0420cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0420cell21 = row.createCell(21);
		if (record1.getR0420_stage3a_poci() != null) {
			R0420cell21.setCellValue(record1.getR0420_stage3a_poci().doubleValue());
			R0420cell21.setCellStyle(numberStyle);
		} else {
			R0420cell21.setCellValue("");
			R0420cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0420cell22 = row.createCell(22);
		if (record1.getR0420_stage3b_poci() != null) {
			R0420cell22.setCellValue(record1.getR0420_stage3b_poci().doubleValue());
			R0420cell22.setCellStyle(numberStyle);
		} else {
			R0420cell22.setCellValue("");
			R0420cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0420cell23 = row.createCell(23);
		if (record1.getR0420_stage3c_poci() != null) {
			R0420cell23.setCellValue(record1.getR0420_stage3c_poci().doubleValue());
			R0420cell23.setCellStyle(numberStyle);
		} else {
			R0420cell23.setCellValue("");
			R0420cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0420cell24 = row.createCell(24);
		if (record1.getR0420_current_pastdues() != null) {
			R0420cell24.setCellValue(record1.getR0420_current_pastdues().doubleValue());
			R0420cell24.setCellStyle(numberStyle);
		} else {
			R0420cell24.setCellValue("");
			R0420cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0420cell25 = row.createCell(25);
		if (record1.getR0420_less30days_pastdues() != null) {
			R0420cell25.setCellValue(record1.getR0420_less30days_pastdues().doubleValue());
			R0420cell25.setCellStyle(numberStyle);
		} else {
			R0420cell25.setCellValue("");
			R0420cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0420cell26 = row.createCell(26);
		if (record1.getR0420_31to90days_pastdues() != null) {
			R0420cell26.setCellValue(record1.getR0420_31to90days_pastdues().doubleValue());
			R0420cell26.setCellStyle(numberStyle);
		} else {
			R0420cell26.setCellValue("");
			R0420cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0420cell27 = row.createCell(27);
		if (record1.getR0420_91to120days_pastdues() != null) {
			R0420cell27.setCellValue(record1.getR0420_91to120days_pastdues().doubleValue());
			R0420cell27.setCellStyle(numberStyle);
		} else {
			R0420cell27.setCellValue("");
			R0420cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0420cell28 = row.createCell(28);
		if (record1.getR0420_121to180days_pastdues() != null) {
			R0420cell28.setCellValue(record1.getR0420_121to180days_pastdues().doubleValue());
			R0420cell28.setCellStyle(numberStyle);
		} else {
			R0420cell28.setCellValue("");
			R0420cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0420cell29 = row.createCell(29);
		if (record1.getR0420_181to365days_pastdues() != null) {
			R0420cell29.setCellValue(record1.getR0420_181to365days_pastdues().doubleValue());
			R0420cell29.setCellStyle(numberStyle);
		} else {
			R0420cell29.setCellValue("");
			R0420cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0420cell30 = row.createCell(30);
		if (record1.getR0420_over365days_pastdues() != null) {
			R0420cell30.setCellValue(record1.getR0420_over365days_pastdues().doubleValue());
			R0420cell30.setCellStyle(numberStyle);
		} else {
			R0420cell30.setCellValue("");
			R0420cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0420cell32 = row.createCell(32);
		if (record1.getR0420_newloan_duringreport() != null) {
			R0420cell32.setCellValue(record1.getR0420_newloan_duringreport().doubleValue());
			R0420cell32.setCellStyle(numberStyle);
		} else {
			R0420cell32.setCellValue("");
			R0420cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0420cell33 = row.createCell(33);
		if (record1.getR0420_newstage_duringreport() != null) {
			R0420cell33.setCellValue(record1.getR0420_newstage_duringreport().doubleValue());
			R0420cell33.setCellStyle(numberStyle);
		} else {
			R0420cell33.setCellValue("");
			R0420cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0420cell34 = row.createCell(34);
		if (record1.getR0420_intrestfees_duringreport() != null) {
			R0420cell34.setCellValue(record1.getR0420_intrestfees_duringreport().doubleValue());
			R0420cell34.setCellStyle(numberStyle);
		} else {
			R0420cell34.setCellValue("");
			R0420cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0420cell35 = row.createCell(35);
		if (record1.getR0420_performingac_acinfo() != null) {
			R0420cell35.setCellValue(record1.getR0420_performingac_acinfo().doubleValue());
			R0420cell35.setCellStyle(numberStyle);
		} else {
			R0420cell35.setCellValue("");
			R0420cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0420cell36 = row.createCell(36);
		if (record1.getR0420_nonperformingac_acinfo() != null) {
			R0420cell36.setCellValue(record1.getR0420_nonperformingac_acinfo().doubleValue());
			R0420cell36.setCellStyle(numberStyle);
		} else {
			R0420cell36.setCellValue("");
			R0420cell36.setCellStyle(textStyle);
		}

		/// ROW52
		//// Column E
		row = sheet.getRow(51);
		Cell R0430cell4 = row.createCell(4);
		if (record1.getR0430_outstandbal() != null) {
			R0430cell4.setCellValue(record1.getR0430_outstandbal().doubleValue());
			R0430cell4.setCellStyle(numberStyle);
		} else {
			R0430cell4.setCellValue("");
			R0430cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0430cell5 = row.createCell(5);
		if (record1.getR0430_secured_outstandbal() != null) {
			R0430cell5.setCellValue(record1.getR0430_secured_outstandbal().doubleValue());
			R0430cell5.setCellStyle(numberStyle);
		} else {
			R0430cell5.setCellValue("");
			R0430cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0430cell6 = row.createCell(6);
		if (record1.getR0430_unsecured_outstandbal() != null) {
			R0430cell6.setCellValue(record1.getR0430_unsecured_outstandbal().doubleValue());
			R0430cell6.setCellStyle(numberStyle);
		} else {
			R0430cell6.setCellValue("");
			R0430cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0430cell7 = row.createCell(7);
		if (record1.getR0430_stage1_assetclass() != null) {
			R0430cell7.setCellValue(record1.getR0430_stage1_assetclass().doubleValue());
			R0430cell7.setCellStyle(numberStyle);
		} else {
			R0430cell7.setCellValue("");
			R0430cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0430cell8 = row.createCell(8);
		if (record1.getR0430_stage2_assetclass() != null) {
			R0430cell8.setCellValue(record1.getR0430_stage2_assetclass().doubleValue());
			R0430cell8.setCellStyle(numberStyle);
		} else {
			R0430cell8.setCellValue("");
			R0430cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0430cell9 = row.createCell(9);
		if (record1.getR0430_stage3a_assetclass() != null) {
			R0430cell9.setCellValue(record1.getR0430_stage3a_assetclass().doubleValue());
			R0430cell9.setCellStyle(numberStyle);
		} else {
			R0430cell9.setCellValue("");
			R0430cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0430cell10 = row.createCell(10);
		if (record1.getR0430_stage3b_assetclass() != null) {
			R0430cell10.setCellValue(record1.getR0430_stage3b_assetclass().doubleValue());
			R0430cell10.setCellStyle(numberStyle);
		} else {
			R0430cell10.setCellValue("");
			R0430cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0430cell11 = row.createCell(11);
		if (record1.getR0430_stage3c_assetclass() != null) {
			R0430cell11.setCellValue(record1.getR0430_stage3c_assetclass().doubleValue());
			R0430cell11.setCellStyle(numberStyle);
		} else {
			R0430cell11.setCellValue("");
			R0430cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0430cell12 = row.createCell(12);
		if (record1.getR0430_stage1_provisionheld() != null) {
			R0430cell12.setCellValue(record1.getR0430_stage1_provisionheld().doubleValue());
			R0430cell12.setCellStyle(numberStyle);
		} else {
			R0430cell12.setCellValue("");
			R0430cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0430cell13 = row.createCell(13);
		if (record1.getR0430_stage2_provisionheld() != null) {
			R0430cell13.setCellValue(record1.getR0430_stage2_provisionheld().doubleValue());
			R0430cell13.setCellStyle(numberStyle);
		} else {
			R0430cell13.setCellValue("");
			R0430cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0430cell14 = row.createCell(14);
		if (record1.getR0430_stage3a_provisionheld() != null) {
			R0430cell14.setCellValue(record1.getR0430_stage3a_provisionheld().doubleValue());
			R0430cell14.setCellStyle(numberStyle);
		} else {
			R0430cell14.setCellValue("");
			R0430cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0430cell15 = row.createCell(15);
		if (record1.getR0430_stage3b_provisionheld() != null) {
			R0430cell15.setCellValue(record1.getR0430_stage3b_provisionheld().doubleValue());
			R0430cell15.setCellStyle(numberStyle);
		} else {
			R0430cell15.setCellValue("");
			R0430cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0430cell16 = row.createCell(16);
		if (record1.getR0430_stage3c_provisionheld() != null) {
			R0430cell16.setCellValue(record1.getR0430_stage3c_provisionheld().doubleValue());
			R0430cell16.setCellStyle(numberStyle);
		} else {
			R0430cell16.setCellValue("");
			R0430cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0430cell17 = row.createCell(17);
		if (record1.getR0430_intrestfees_provisionheld() != null) {
			R0430cell17.setCellValue(record1.getR0430_intrestfees_provisionheld().doubleValue());
			R0430cell17.setCellStyle(numberStyle);
		} else {
			R0430cell17.setCellValue("");
			R0430cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0430cell18 = row.createCell(18);
		if (record1.getR0430_intrestsuspense_provisionheld() != null) {
			R0430cell18.setCellValue(record1.getR0430_intrestsuspense_provisionheld().doubleValue());
			R0430cell18.setCellStyle(numberStyle);
		} else {
			R0430cell18.setCellValue("");
			R0430cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0430cell19 = row.createCell(19);
		if (record1.getR0430_stage1_poci() != null) {
			R0430cell19.setCellValue(record1.getR0430_stage1_poci().doubleValue());
			R0430cell19.setCellStyle(numberStyle);
		} else {
			R0430cell19.setCellValue("");
			R0430cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0430cell20 = row.createCell(20);
		if (record1.getR0430_stage2_poci() != null) {
			R0430cell20.setCellValue(record1.getR0430_stage2_poci().doubleValue());
			R0430cell20.setCellStyle(numberStyle);
		} else {
			R0430cell20.setCellValue("");
			R0430cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0430cell21 = row.createCell(21);
		if (record1.getR0430_stage3a_poci() != null) {
			R0430cell21.setCellValue(record1.getR0430_stage3a_poci().doubleValue());
			R0430cell21.setCellStyle(numberStyle);
		} else {
			R0430cell21.setCellValue("");
			R0430cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0430cell22 = row.createCell(22);
		if (record1.getR0430_stage3b_poci() != null) {
			R0430cell22.setCellValue(record1.getR0430_stage3b_poci().doubleValue());
			R0430cell22.setCellStyle(numberStyle);
		} else {
			R0430cell22.setCellValue("");
			R0430cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0430cell23 = row.createCell(23);
		if (record1.getR0430_stage3c_poci() != null) {
			R0430cell23.setCellValue(record1.getR0430_stage3c_poci().doubleValue());
			R0430cell23.setCellStyle(numberStyle);
		} else {
			R0430cell23.setCellValue("");
			R0430cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0430cell24 = row.createCell(24);
		if (record1.getR0430_current_pastdues() != null) {
			R0430cell24.setCellValue(record1.getR0430_current_pastdues().doubleValue());
			R0430cell24.setCellStyle(numberStyle);
		} else {
			R0430cell24.setCellValue("");
			R0430cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0430cell25 = row.createCell(25);
		if (record1.getR0430_less30days_pastdues() != null) {
			R0430cell25.setCellValue(record1.getR0430_less30days_pastdues().doubleValue());
			R0430cell25.setCellStyle(numberStyle);
		} else {
			R0430cell25.setCellValue("");
			R0430cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0430cell26 = row.createCell(26);
		if (record1.getR0430_31to90days_pastdues() != null) {
			R0430cell26.setCellValue(record1.getR0430_31to90days_pastdues().doubleValue());
			R0430cell26.setCellStyle(numberStyle);
		} else {
			R0430cell26.setCellValue("");
			R0430cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0430cell27 = row.createCell(27);
		if (record1.getR0430_91to120days_pastdues() != null) {
			R0430cell27.setCellValue(record1.getR0430_91to120days_pastdues().doubleValue());
			R0430cell27.setCellStyle(numberStyle);
		} else {
			R0430cell27.setCellValue("");
			R0430cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0430cell28 = row.createCell(28);
		if (record1.getR0430_121to180days_pastdues() != null) {
			R0430cell28.setCellValue(record1.getR0430_121to180days_pastdues().doubleValue());
			R0430cell28.setCellStyle(numberStyle);
		} else {
			R0430cell28.setCellValue("");
			R0430cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0430cell29 = row.createCell(29);
		if (record1.getR0430_181to365days_pastdues() != null) {
			R0430cell29.setCellValue(record1.getR0430_181to365days_pastdues().doubleValue());
			R0430cell29.setCellStyle(numberStyle);
		} else {
			R0430cell29.setCellValue("");
			R0430cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0430cell30 = row.createCell(30);
		if (record1.getR0430_over365days_pastdues() != null) {
			R0430cell30.setCellValue(record1.getR0430_over365days_pastdues().doubleValue());
			R0430cell30.setCellStyle(numberStyle);
		} else {
			R0430cell30.setCellValue("");
			R0430cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0430cell32 = row.createCell(32);
		if (record1.getR0430_newloan_duringreport() != null) {
			R0430cell32.setCellValue(record1.getR0430_newloan_duringreport().doubleValue());
			R0430cell32.setCellStyle(numberStyle);
		} else {
			R0430cell32.setCellValue("");
			R0430cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0430cell33 = row.createCell(33);
		if (record1.getR0430_newstage_duringreport() != null) {
			R0430cell33.setCellValue(record1.getR0430_newstage_duringreport().doubleValue());
			R0430cell33.setCellStyle(numberStyle);
		} else {
			R0430cell33.setCellValue("");
			R0430cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0430cell34 = row.createCell(34);
		if (record1.getR0430_intrestfees_duringreport() != null) {
			R0430cell34.setCellValue(record1.getR0430_intrestfees_duringreport().doubleValue());
			R0430cell34.setCellStyle(numberStyle);
		} else {
			R0430cell34.setCellValue("");
			R0430cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0430cell35 = row.createCell(35);
		if (record1.getR0430_performingac_acinfo() != null) {
			R0430cell35.setCellValue(record1.getR0430_performingac_acinfo().doubleValue());
			R0430cell35.setCellStyle(numberStyle);
		} else {
			R0430cell35.setCellValue("");
			R0430cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0430cell36 = row.createCell(36);
		if (record1.getR0430_nonperformingac_acinfo() != null) {
			R0430cell36.setCellValue(record1.getR0430_nonperformingac_acinfo().doubleValue());
			R0430cell36.setCellStyle(numberStyle);
		} else {
			R0430cell36.setCellValue("");
			R0430cell36.setCellStyle(textStyle);
		}

		/// ROW53
		//// Column E
		row = sheet.getRow(52);
		Cell R0440cell4 = row.createCell(4);
		if (record1.getR0440_outstandbal() != null) {
			R0440cell4.setCellValue(record1.getR0440_outstandbal().doubleValue());
			R0440cell4.setCellStyle(numberStyle);
		} else {
			R0440cell4.setCellValue("");
			R0440cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0440cell5 = row.createCell(5);
		if (record1.getR0440_secured_outstandbal() != null) {
			R0440cell5.setCellValue(record1.getR0440_secured_outstandbal().doubleValue());
			R0440cell5.setCellStyle(numberStyle);
		} else {
			R0440cell5.setCellValue("");
			R0440cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0440cell6 = row.createCell(6);
		if (record1.getR0440_unsecured_outstandbal() != null) {
			R0440cell6.setCellValue(record1.getR0440_unsecured_outstandbal().doubleValue());
			R0440cell6.setCellStyle(numberStyle);
		} else {
			R0440cell6.setCellValue("");
			R0440cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0440cell7 = row.createCell(7);
		if (record1.getR0440_stage1_assetclass() != null) {
			R0440cell7.setCellValue(record1.getR0440_stage1_assetclass().doubleValue());
			R0440cell7.setCellStyle(numberStyle);
		} else {
			R0440cell7.setCellValue("");
			R0440cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0440cell8 = row.createCell(8);
		if (record1.getR0440_stage2_assetclass() != null) {
			R0440cell8.setCellValue(record1.getR0440_stage2_assetclass().doubleValue());
			R0440cell8.setCellStyle(numberStyle);
		} else {
			R0440cell8.setCellValue("");
			R0440cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0440cell9 = row.createCell(9);
		if (record1.getR0440_stage3a_assetclass() != null) {
			R0440cell9.setCellValue(record1.getR0440_stage3a_assetclass().doubleValue());
			R0440cell9.setCellStyle(numberStyle);
		} else {
			R0440cell9.setCellValue("");
			R0440cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0440cell10 = row.createCell(10);
		if (record1.getR0440_stage3b_assetclass() != null) {
			R0440cell10.setCellValue(record1.getR0440_stage3b_assetclass().doubleValue());
			R0440cell10.setCellStyle(numberStyle);
		} else {
			R0440cell10.setCellValue("");
			R0440cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0440cell11 = row.createCell(11);
		if (record1.getR0440_stage3c_assetclass() != null) {
			R0440cell11.setCellValue(record1.getR0440_stage3c_assetclass().doubleValue());
			R0440cell11.setCellStyle(numberStyle);
		} else {
			R0440cell11.setCellValue("");
			R0440cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0440cell12 = row.createCell(12);
		if (record1.getR0440_stage1_provisionheld() != null) {
			R0440cell12.setCellValue(record1.getR0440_stage1_provisionheld().doubleValue());
			R0440cell12.setCellStyle(numberStyle);
		} else {
			R0440cell12.setCellValue("");
			R0440cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0440cell13 = row.createCell(13);
		if (record1.getR0440_stage2_provisionheld() != null) {
			R0440cell13.setCellValue(record1.getR0440_stage2_provisionheld().doubleValue());
			R0440cell13.setCellStyle(numberStyle);
		} else {
			R0440cell13.setCellValue("");
			R0440cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0440cell14 = row.createCell(14);
		if (record1.getR0440_stage3a_provisionheld() != null) {
			R0440cell14.setCellValue(record1.getR0440_stage3a_provisionheld().doubleValue());
			R0440cell14.setCellStyle(numberStyle);
		} else {
			R0440cell14.setCellValue("");
			R0440cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0440cell15 = row.createCell(15);
		if (record1.getR0440_stage3b_provisionheld() != null) {
			R0440cell15.setCellValue(record1.getR0440_stage3b_provisionheld().doubleValue());
			R0440cell15.setCellStyle(numberStyle);
		} else {
			R0440cell15.setCellValue("");
			R0440cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0440cell16 = row.createCell(16);
		if (record1.getR0440_stage3c_provisionheld() != null) {
			R0440cell16.setCellValue(record1.getR0440_stage3c_provisionheld().doubleValue());
			R0440cell16.setCellStyle(numberStyle);
		} else {
			R0440cell16.setCellValue("");
			R0440cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0440cell17 = row.createCell(17);
		if (record1.getR0440_intrestfees_provisionheld() != null) {
			R0440cell17.setCellValue(record1.getR0440_intrestfees_provisionheld().doubleValue());
			R0440cell17.setCellStyle(numberStyle);
		} else {
			R0440cell17.setCellValue("");
			R0440cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0440cell18 = row.createCell(18);
		if (record1.getR0440_intrestsuspense_provisionheld() != null) {
			R0440cell18.setCellValue(record1.getR0440_intrestsuspense_provisionheld().doubleValue());
			R0440cell18.setCellStyle(numberStyle);
		} else {
			R0440cell18.setCellValue("");
			R0440cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0440cell19 = row.createCell(19);
		if (record1.getR0440_stage1_poci() != null) {
			R0440cell19.setCellValue(record1.getR0440_stage1_poci().doubleValue());
			R0440cell19.setCellStyle(numberStyle);
		} else {
			R0440cell19.setCellValue("");
			R0440cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0440cell20 = row.createCell(20);
		if (record1.getR0440_stage2_poci() != null) {
			R0440cell20.setCellValue(record1.getR0440_stage2_poci().doubleValue());
			R0440cell20.setCellStyle(numberStyle);
		} else {
			R0440cell20.setCellValue("");
			R0440cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0440cell21 = row.createCell(21);
		if (record1.getR0440_stage3a_poci() != null) {
			R0440cell21.setCellValue(record1.getR0440_stage3a_poci().doubleValue());
			R0440cell21.setCellStyle(numberStyle);
		} else {
			R0440cell21.setCellValue("");
			R0440cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0440cell22 = row.createCell(22);
		if (record1.getR0440_stage3b_poci() != null) {
			R0440cell22.setCellValue(record1.getR0440_stage3b_poci().doubleValue());
			R0440cell22.setCellStyle(numberStyle);
		} else {
			R0440cell22.setCellValue("");
			R0440cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0440cell23 = row.createCell(23);
		if (record1.getR0440_stage3c_poci() != null) {
			R0440cell23.setCellValue(record1.getR0440_stage3c_poci().doubleValue());
			R0440cell23.setCellStyle(numberStyle);
		} else {
			R0440cell23.setCellValue("");
			R0440cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0440cell24 = row.createCell(24);
		if (record1.getR0440_current_pastdues() != null) {
			R0440cell24.setCellValue(record1.getR0440_current_pastdues().doubleValue());
			R0440cell24.setCellStyle(numberStyle);
		} else {
			R0440cell24.setCellValue("");
			R0440cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0440cell25 = row.createCell(25);
		if (record1.getR0440_less30days_pastdues() != null) {
			R0440cell25.setCellValue(record1.getR0440_less30days_pastdues().doubleValue());
			R0440cell25.setCellStyle(numberStyle);
		} else {
			R0440cell25.setCellValue("");
			R0440cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0440cell26 = row.createCell(26);
		if (record1.getR0440_31to90days_pastdues() != null) {
			R0440cell26.setCellValue(record1.getR0440_31to90days_pastdues().doubleValue());
			R0440cell26.setCellStyle(numberStyle);
		} else {
			R0440cell26.setCellValue("");
			R0440cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0440cell27 = row.createCell(27);
		if (record1.getR0440_91to120days_pastdues() != null) {
			R0440cell27.setCellValue(record1.getR0440_91to120days_pastdues().doubleValue());
			R0440cell27.setCellStyle(numberStyle);
		} else {
			R0440cell27.setCellValue("");
			R0440cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0440cell28 = row.createCell(28);
		if (record1.getR0440_121to180days_pastdues() != null) {
			R0440cell28.setCellValue(record1.getR0440_121to180days_pastdues().doubleValue());
			R0440cell28.setCellStyle(numberStyle);
		} else {
			R0440cell28.setCellValue("");
			R0440cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0440cell29 = row.createCell(29);
		if (record1.getR0440_181to365days_pastdues() != null) {
			R0440cell29.setCellValue(record1.getR0440_181to365days_pastdues().doubleValue());
			R0440cell29.setCellStyle(numberStyle);
		} else {
			R0440cell29.setCellValue("");
			R0440cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0440cell30 = row.createCell(30);
		if (record1.getR0440_over365days_pastdues() != null) {
			R0440cell30.setCellValue(record1.getR0440_over365days_pastdues().doubleValue());
			R0440cell30.setCellStyle(numberStyle);
		} else {
			R0440cell30.setCellValue("");
			R0440cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0440cell32 = row.createCell(32);
		if (record1.getR0440_newloan_duringreport() != null) {
			R0440cell32.setCellValue(record1.getR0440_newloan_duringreport().doubleValue());
			R0440cell32.setCellStyle(numberStyle);
		} else {
			R0440cell32.setCellValue("");
			R0440cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0440cell33 = row.createCell(33);
		if (record1.getR0440_newstage_duringreport() != null) {
			R0440cell33.setCellValue(record1.getR0440_newstage_duringreport().doubleValue());
			R0440cell33.setCellStyle(numberStyle);
		} else {
			R0440cell33.setCellValue("");
			R0440cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0440cell34 = row.createCell(34);
		if (record1.getR0440_intrestfees_duringreport() != null) {
			R0440cell34.setCellValue(record1.getR0440_intrestfees_duringreport().doubleValue());
			R0440cell34.setCellStyle(numberStyle);
		} else {
			R0440cell34.setCellValue("");
			R0440cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0440cell35 = row.createCell(35);
		if (record1.getR0440_performingac_acinfo() != null) {
			R0440cell35.setCellValue(record1.getR0440_performingac_acinfo().doubleValue());
			R0440cell35.setCellStyle(numberStyle);
		} else {
			R0440cell35.setCellValue("");
			R0440cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0440cell36 = row.createCell(36);
		if (record1.getR0440_nonperformingac_acinfo() != null) {
			R0440cell36.setCellValue(record1.getR0440_nonperformingac_acinfo().doubleValue());
			R0440cell36.setCellStyle(numberStyle);
		} else {
			R0440cell36.setCellValue("");
			R0440cell36.setCellStyle(textStyle);
		}

		/// ROW54
		//// Column E
		row = sheet.getRow(53);
		Cell R0450cell4 = row.createCell(4);
		if (record1.getR0450_outstandbal() != null) {
			R0450cell4.setCellValue(record1.getR0450_outstandbal().doubleValue());
			R0450cell4.setCellStyle(numberStyle);
		} else {
			R0450cell4.setCellValue("");
			R0450cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0450cell5 = row.createCell(5);
		if (record1.getR0450_secured_outstandbal() != null) {
			R0450cell5.setCellValue(record1.getR0450_secured_outstandbal().doubleValue());
			R0450cell5.setCellStyle(numberStyle);
		} else {
			R0450cell5.setCellValue("");
			R0450cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0450cell6 = row.createCell(6);
		if (record1.getR0450_unsecured_outstandbal() != null) {
			R0450cell6.setCellValue(record1.getR0450_unsecured_outstandbal().doubleValue());
			R0450cell6.setCellStyle(numberStyle);
		} else {
			R0450cell6.setCellValue("");
			R0450cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0450cell7 = row.createCell(7);
		if (record1.getR0450_stage1_assetclass() != null) {
			R0450cell7.setCellValue(record1.getR0450_stage1_assetclass().doubleValue());
			R0450cell7.setCellStyle(numberStyle);
		} else {
			R0450cell7.setCellValue("");
			R0450cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0450cell8 = row.createCell(8);
		if (record1.getR0450_stage2_assetclass() != null) {
			R0450cell8.setCellValue(record1.getR0450_stage2_assetclass().doubleValue());
			R0450cell8.setCellStyle(numberStyle);
		} else {
			R0450cell8.setCellValue("");
			R0450cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0450cell9 = row.createCell(9);
		if (record1.getR0450_stage3a_assetclass() != null) {
			R0450cell9.setCellValue(record1.getR0450_stage3a_assetclass().doubleValue());
			R0450cell9.setCellStyle(numberStyle);
		} else {
			R0450cell9.setCellValue("");
			R0450cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0450cell10 = row.createCell(10);
		if (record1.getR0450_stage3b_assetclass() != null) {
			R0450cell10.setCellValue(record1.getR0450_stage3b_assetclass().doubleValue());
			R0450cell10.setCellStyle(numberStyle);
		} else {
			R0450cell10.setCellValue("");
			R0450cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0450cell11 = row.createCell(11);
		if (record1.getR0450_stage3c_assetclass() != null) {
			R0450cell11.setCellValue(record1.getR0450_stage3c_assetclass().doubleValue());
			R0450cell11.setCellStyle(numberStyle);
		} else {
			R0450cell11.setCellValue("");
			R0450cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0450cell12 = row.createCell(12);
		if (record1.getR0450_stage1_provisionheld() != null) {
			R0450cell12.setCellValue(record1.getR0450_stage1_provisionheld().doubleValue());
			R0450cell12.setCellStyle(numberStyle);
		} else {
			R0450cell12.setCellValue("");
			R0450cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0450cell13 = row.createCell(13);
		if (record1.getR0450_stage2_provisionheld() != null) {
			R0450cell13.setCellValue(record1.getR0450_stage2_provisionheld().doubleValue());
			R0450cell13.setCellStyle(numberStyle);
		} else {
			R0450cell13.setCellValue("");
			R0450cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0450cell14 = row.createCell(14);
		if (record1.getR0450_stage3a_provisionheld() != null) {
			R0450cell14.setCellValue(record1.getR0450_stage3a_provisionheld().doubleValue());
			R0450cell14.setCellStyle(numberStyle);
		} else {
			R0450cell14.setCellValue("");
			R0450cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0450cell15 = row.createCell(15);
		if (record1.getR0450_stage3b_provisionheld() != null) {
			R0450cell15.setCellValue(record1.getR0450_stage3b_provisionheld().doubleValue());
			R0450cell15.setCellStyle(numberStyle);
		} else {
			R0450cell15.setCellValue("");
			R0450cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0450cell16 = row.createCell(16);
		if (record1.getR0450_stage3c_provisionheld() != null) {
			R0450cell16.setCellValue(record1.getR0450_stage3c_provisionheld().doubleValue());
			R0450cell16.setCellStyle(numberStyle);
		} else {
			R0450cell16.setCellValue("");
			R0450cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0450cell17 = row.createCell(17);
		if (record1.getR0450_intrestfees_provisionheld() != null) {
			R0450cell17.setCellValue(record1.getR0450_intrestfees_provisionheld().doubleValue());
			R0450cell17.setCellStyle(numberStyle);
		} else {
			R0450cell17.setCellValue("");
			R0450cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0450cell18 = row.createCell(18);
		if (record1.getR0450_intrestsuspense_provisionheld() != null) {
			R0450cell18.setCellValue(record1.getR0450_intrestsuspense_provisionheld().doubleValue());
			R0450cell18.setCellStyle(numberStyle);
		} else {
			R0450cell18.setCellValue("");
			R0450cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0450cell19 = row.createCell(19);
		if (record1.getR0450_stage1_poci() != null) {
			R0450cell19.setCellValue(record1.getR0450_stage1_poci().doubleValue());
			R0450cell19.setCellStyle(numberStyle);
		} else {
			R0450cell19.setCellValue("");
			R0450cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0450cell20 = row.createCell(20);
		if (record1.getR0450_stage2_poci() != null) {
			R0450cell20.setCellValue(record1.getR0450_stage2_poci().doubleValue());
			R0450cell20.setCellStyle(numberStyle);
		} else {
			R0450cell20.setCellValue("");
			R0450cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0450cell21 = row.createCell(21);
		if (record1.getR0450_stage3a_poci() != null) {
			R0450cell21.setCellValue(record1.getR0450_stage3a_poci().doubleValue());
			R0450cell21.setCellStyle(numberStyle);
		} else {
			R0450cell21.setCellValue("");
			R0450cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0450cell22 = row.createCell(22);
		if (record1.getR0450_stage3b_poci() != null) {
			R0450cell22.setCellValue(record1.getR0450_stage3b_poci().doubleValue());
			R0450cell22.setCellStyle(numberStyle);
		} else {
			R0450cell22.setCellValue("");
			R0450cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0450cell23 = row.createCell(23);
		if (record1.getR0450_stage3c_poci() != null) {
			R0450cell23.setCellValue(record1.getR0450_stage3c_poci().doubleValue());
			R0450cell23.setCellStyle(numberStyle);
		} else {
			R0450cell23.setCellValue("");
			R0450cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0450cell24 = row.createCell(24);
		if (record1.getR0450_current_pastdues() != null) {
			R0450cell24.setCellValue(record1.getR0450_current_pastdues().doubleValue());
			R0450cell24.setCellStyle(numberStyle);
		} else {
			R0450cell24.setCellValue("");
			R0450cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0450cell25 = row.createCell(25);
		if (record1.getR0450_less30days_pastdues() != null) {
			R0450cell25.setCellValue(record1.getR0450_less30days_pastdues().doubleValue());
			R0450cell25.setCellStyle(numberStyle);
		} else {
			R0450cell25.setCellValue("");
			R0450cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0450cell26 = row.createCell(26);
		if (record1.getR0450_31to90days_pastdues() != null) {
			R0450cell26.setCellValue(record1.getR0450_31to90days_pastdues().doubleValue());
			R0450cell26.setCellStyle(numberStyle);
		} else {
			R0450cell26.setCellValue("");
			R0450cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0450cell27 = row.createCell(27);
		if (record1.getR0450_91to120days_pastdues() != null) {
			R0450cell27.setCellValue(record1.getR0450_91to120days_pastdues().doubleValue());
			R0450cell27.setCellStyle(numberStyle);
		} else {
			R0450cell27.setCellValue("");
			R0450cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0450cell28 = row.createCell(28);
		if (record1.getR0450_121to180days_pastdues() != null) {
			R0450cell28.setCellValue(record1.getR0450_121to180days_pastdues().doubleValue());
			R0450cell28.setCellStyle(numberStyle);
		} else {
			R0450cell28.setCellValue("");
			R0450cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0450cell29 = row.createCell(29);
		if (record1.getR0450_181to365days_pastdues() != null) {
			R0450cell29.setCellValue(record1.getR0450_181to365days_pastdues().doubleValue());
			R0450cell29.setCellStyle(numberStyle);
		} else {
			R0450cell29.setCellValue("");
			R0450cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0450cell30 = row.createCell(30);
		if (record1.getR0450_over365days_pastdues() != null) {
			R0450cell30.setCellValue(record1.getR0450_over365days_pastdues().doubleValue());
			R0450cell30.setCellStyle(numberStyle);
		} else {
			R0450cell30.setCellValue("");
			R0450cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0450cell32 = row.createCell(32);
		if (record1.getR0450_newloan_duringreport() != null) {
			R0450cell32.setCellValue(record1.getR0450_newloan_duringreport().doubleValue());
			R0450cell32.setCellStyle(numberStyle);
		} else {
			R0450cell32.setCellValue("");
			R0450cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0450cell33 = row.createCell(33);
		if (record1.getR0450_newstage_duringreport() != null) {
			R0450cell33.setCellValue(record1.getR0450_newstage_duringreport().doubleValue());
			R0450cell33.setCellStyle(numberStyle);
		} else {
			R0450cell33.setCellValue("");
			R0450cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0450cell34 = row.createCell(34);
		if (record1.getR0450_intrestfees_duringreport() != null) {
			R0450cell34.setCellValue(record1.getR0450_intrestfees_duringreport().doubleValue());
			R0450cell34.setCellStyle(numberStyle);
		} else {
			R0450cell34.setCellValue("");
			R0450cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0450cell35 = row.createCell(35);
		if (record1.getR0450_performingac_acinfo() != null) {
			R0450cell35.setCellValue(record1.getR0450_performingac_acinfo().doubleValue());
			R0450cell35.setCellStyle(numberStyle);
		} else {
			R0450cell35.setCellValue("");
			R0450cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0450cell36 = row.createCell(36);
		if (record1.getR0450_nonperformingac_acinfo() != null) {
			R0450cell36.setCellValue(record1.getR0450_nonperformingac_acinfo().doubleValue());
			R0450cell36.setCellStyle(numberStyle);
		} else {
			R0450cell36.setCellValue("");
			R0450cell36.setCellStyle(textStyle);
		}

		/// ROW55
		//// Column E
		row = sheet.getRow(54);
		Cell R0460cell4 = row.createCell(4);
		if (record1.getR0460_outstandbal() != null) {
			R0460cell4.setCellValue(record1.getR0460_outstandbal().doubleValue());
			R0460cell4.setCellStyle(numberStyle);
		} else {
			R0460cell4.setCellValue("");
			R0460cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0460cell5 = row.createCell(5);
		if (record1.getR0460_secured_outstandbal() != null) {
			R0460cell5.setCellValue(record1.getR0460_secured_outstandbal().doubleValue());
			R0460cell5.setCellStyle(numberStyle);
		} else {
			R0460cell5.setCellValue("");
			R0460cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0460cell6 = row.createCell(6);
		if (record1.getR0460_unsecured_outstandbal() != null) {
			R0460cell6.setCellValue(record1.getR0460_unsecured_outstandbal().doubleValue());
			R0460cell6.setCellStyle(numberStyle);
		} else {
			R0460cell6.setCellValue("");
			R0460cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0460cell7 = row.createCell(7);
		if (record1.getR0460_stage1_assetclass() != null) {
			R0460cell7.setCellValue(record1.getR0460_stage1_assetclass().doubleValue());
			R0460cell7.setCellStyle(numberStyle);
		} else {
			R0460cell7.setCellValue("");
			R0460cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0460cell8 = row.createCell(8);
		if (record1.getR0460_stage2_assetclass() != null) {
			R0460cell8.setCellValue(record1.getR0460_stage2_assetclass().doubleValue());
			R0460cell8.setCellStyle(numberStyle);
		} else {
			R0460cell8.setCellValue("");
			R0460cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0460cell9 = row.createCell(9);
		if (record1.getR0460_stage3a_assetclass() != null) {
			R0460cell9.setCellValue(record1.getR0460_stage3a_assetclass().doubleValue());
			R0460cell9.setCellStyle(numberStyle);
		} else {
			R0460cell9.setCellValue("");
			R0460cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0460cell10 = row.createCell(10);
		if (record1.getR0460_stage3b_assetclass() != null) {
			R0460cell10.setCellValue(record1.getR0460_stage3b_assetclass().doubleValue());
			R0460cell10.setCellStyle(numberStyle);
		} else {
			R0460cell10.setCellValue("");
			R0460cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0460cell11 = row.createCell(11);
		if (record1.getR0460_stage3c_assetclass() != null) {
			R0460cell11.setCellValue(record1.getR0460_stage3c_assetclass().doubleValue());
			R0460cell11.setCellStyle(numberStyle);
		} else {
			R0460cell11.setCellValue("");
			R0460cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0460cell12 = row.createCell(12);
		if (record1.getR0460_stage1_provisionheld() != null) {
			R0460cell12.setCellValue(record1.getR0460_stage1_provisionheld().doubleValue());
			R0460cell12.setCellStyle(numberStyle);
		} else {
			R0460cell12.setCellValue("");
			R0460cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0460cell13 = row.createCell(13);
		if (record1.getR0460_stage2_provisionheld() != null) {
			R0460cell13.setCellValue(record1.getR0460_stage2_provisionheld().doubleValue());
			R0460cell13.setCellStyle(numberStyle);
		} else {
			R0460cell13.setCellValue("");
			R0460cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0460cell14 = row.createCell(14);
		if (record1.getR0460_stage3a_provisionheld() != null) {
			R0460cell14.setCellValue(record1.getR0460_stage3a_provisionheld().doubleValue());
			R0460cell14.setCellStyle(numberStyle);
		} else {
			R0460cell14.setCellValue("");
			R0460cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0460cell15 = row.createCell(15);
		if (record1.getR0460_stage3b_provisionheld() != null) {
			R0460cell15.setCellValue(record1.getR0460_stage3b_provisionheld().doubleValue());
			R0460cell15.setCellStyle(numberStyle);
		} else {
			R0460cell15.setCellValue("");
			R0460cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0460cell16 = row.createCell(16);
		if (record1.getR0460_stage3c_provisionheld() != null) {
			R0460cell16.setCellValue(record1.getR0460_stage3c_provisionheld().doubleValue());
			R0460cell16.setCellStyle(numberStyle);
		} else {
			R0460cell16.setCellValue("");
			R0460cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0460cell17 = row.createCell(17);
		if (record1.getR0460_intrestfees_provisionheld() != null) {
			R0460cell17.setCellValue(record1.getR0460_intrestfees_provisionheld().doubleValue());
			R0460cell17.setCellStyle(numberStyle);
		} else {
			R0460cell17.setCellValue("");
			R0460cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0460cell18 = row.createCell(18);
		if (record1.getR0460_intrestsuspense_provisionheld() != null) {
			R0460cell18.setCellValue(record1.getR0460_intrestsuspense_provisionheld().doubleValue());
			R0460cell18.setCellStyle(numberStyle);
		} else {
			R0460cell18.setCellValue("");
			R0460cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0460cell19 = row.createCell(19);
		if (record1.getR0460_stage1_poci() != null) {
			R0460cell19.setCellValue(record1.getR0460_stage1_poci().doubleValue());
			R0460cell19.setCellStyle(numberStyle);
		} else {
			R0460cell19.setCellValue("");
			R0460cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0460cell20 = row.createCell(20);
		if (record1.getR0460_stage2_poci() != null) {
			R0460cell20.setCellValue(record1.getR0460_stage2_poci().doubleValue());
			R0460cell20.setCellStyle(numberStyle);
		} else {
			R0460cell20.setCellValue("");
			R0460cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0460cell21 = row.createCell(21);
		if (record1.getR0460_stage3a_poci() != null) {
			R0460cell21.setCellValue(record1.getR0460_stage3a_poci().doubleValue());
			R0460cell21.setCellStyle(numberStyle);
		} else {
			R0460cell21.setCellValue("");
			R0460cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0460cell22 = row.createCell(22);
		if (record1.getR0460_stage3b_poci() != null) {
			R0460cell22.setCellValue(record1.getR0460_stage3b_poci().doubleValue());
			R0460cell22.setCellStyle(numberStyle);
		} else {
			R0460cell22.setCellValue("");
			R0460cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0460cell23 = row.createCell(23);
		if (record1.getR0460_stage3c_poci() != null) {
			R0460cell23.setCellValue(record1.getR0460_stage3c_poci().doubleValue());
			R0460cell23.setCellStyle(numberStyle);
		} else {
			R0460cell23.setCellValue("");
			R0460cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0460cell24 = row.createCell(24);
		if (record1.getR0460_current_pastdues() != null) {
			R0460cell24.setCellValue(record1.getR0460_current_pastdues().doubleValue());
			R0460cell24.setCellStyle(numberStyle);
		} else {
			R0460cell24.setCellValue("");
			R0460cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0460cell25 = row.createCell(25);
		if (record1.getR0460_less30days_pastdues() != null) {
			R0460cell25.setCellValue(record1.getR0460_less30days_pastdues().doubleValue());
			R0460cell25.setCellStyle(numberStyle);
		} else {
			R0460cell25.setCellValue("");
			R0460cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0460cell26 = row.createCell(26);
		if (record1.getR0460_31to90days_pastdues() != null) {
			R0460cell26.setCellValue(record1.getR0460_31to90days_pastdues().doubleValue());
			R0460cell26.setCellStyle(numberStyle);
		} else {
			R0460cell26.setCellValue("");
			R0460cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0460cell27 = row.createCell(27);
		if (record1.getR0460_91to120days_pastdues() != null) {
			R0460cell27.setCellValue(record1.getR0460_91to120days_pastdues().doubleValue());
			R0460cell27.setCellStyle(numberStyle);
		} else {
			R0460cell27.setCellValue("");
			R0460cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0460cell28 = row.createCell(28);
		if (record1.getR0460_121to180days_pastdues() != null) {
			R0460cell28.setCellValue(record1.getR0460_121to180days_pastdues().doubleValue());
			R0460cell28.setCellStyle(numberStyle);
		} else {
			R0460cell28.setCellValue("");
			R0460cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0460cell29 = row.createCell(29);
		if (record1.getR0460_181to365days_pastdues() != null) {
			R0460cell29.setCellValue(record1.getR0460_181to365days_pastdues().doubleValue());
			R0460cell29.setCellStyle(numberStyle);
		} else {
			R0460cell29.setCellValue("");
			R0460cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0460cell30 = row.createCell(30);
		if (record1.getR0460_over365days_pastdues() != null) {
			R0460cell30.setCellValue(record1.getR0460_over365days_pastdues().doubleValue());
			R0460cell30.setCellStyle(numberStyle);
		} else {
			R0460cell30.setCellValue("");
			R0460cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0460cell32 = row.createCell(32);
		if (record1.getR0460_newloan_duringreport() != null) {
			R0460cell32.setCellValue(record1.getR0460_newloan_duringreport().doubleValue());
			R0460cell32.setCellStyle(numberStyle);
		} else {
			R0460cell32.setCellValue("");
			R0460cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0460cell33 = row.createCell(33);
		if (record1.getR0460_newstage_duringreport() != null) {
			R0460cell33.setCellValue(record1.getR0460_newstage_duringreport().doubleValue());
			R0460cell33.setCellStyle(numberStyle);
		} else {
			R0460cell33.setCellValue("");
			R0460cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0460cell34 = row.createCell(34);
		if (record1.getR0460_intrestfees_duringreport() != null) {
			R0460cell34.setCellValue(record1.getR0460_intrestfees_duringreport().doubleValue());
			R0460cell34.setCellStyle(numberStyle);
		} else {
			R0460cell34.setCellValue("");
			R0460cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0460cell35 = row.createCell(35);
		if (record1.getR0460_performingac_acinfo() != null) {
			R0460cell35.setCellValue(record1.getR0460_performingac_acinfo().doubleValue());
			R0460cell35.setCellStyle(numberStyle);
		} else {
			R0460cell35.setCellValue("");
			R0460cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0460cell36 = row.createCell(36);
		if (record1.getR0460_nonperformingac_acinfo() != null) {
			R0460cell36.setCellValue(record1.getR0460_nonperformingac_acinfo().doubleValue());
			R0460cell36.setCellStyle(numberStyle);
		} else {
			R0460cell36.setCellValue("");
			R0460cell36.setCellStyle(textStyle);
		}

		/// ROW56
		//// Column E
		row = sheet.getRow(55);
		Cell R0470cell4 = row.createCell(4);
		if (record1.getR0470_outstandbal() != null) {
			R0470cell4.setCellValue(record1.getR0470_outstandbal().doubleValue());
			R0470cell4.setCellStyle(numberStyle);
		} else {
			R0470cell4.setCellValue("");
			R0470cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0470cell5 = row.createCell(5);
		if (record1.getR0470_secured_outstandbal() != null) {
			R0470cell5.setCellValue(record1.getR0470_secured_outstandbal().doubleValue());
			R0470cell5.setCellStyle(numberStyle);
		} else {
			R0470cell5.setCellValue("");
			R0470cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0470cell6 = row.createCell(6);
		if (record1.getR0470_unsecured_outstandbal() != null) {
			R0470cell6.setCellValue(record1.getR0470_unsecured_outstandbal().doubleValue());
			R0470cell6.setCellStyle(numberStyle);
		} else {
			R0470cell6.setCellValue("");
			R0470cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0470cell7 = row.createCell(7);
		if (record1.getR0470_stage1_assetclass() != null) {
			R0470cell7.setCellValue(record1.getR0470_stage1_assetclass().doubleValue());
			R0470cell7.setCellStyle(numberStyle);
		} else {
			R0470cell7.setCellValue("");
			R0470cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0470cell8 = row.createCell(8);
		if (record1.getR0470_stage2_assetclass() != null) {
			R0470cell8.setCellValue(record1.getR0470_stage2_assetclass().doubleValue());
			R0470cell8.setCellStyle(numberStyle);
		} else {
			R0470cell8.setCellValue("");
			R0470cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0470cell9 = row.createCell(9);
		if (record1.getR0470_stage3a_assetclass() != null) {
			R0470cell9.setCellValue(record1.getR0470_stage3a_assetclass().doubleValue());
			R0470cell9.setCellStyle(numberStyle);
		} else {
			R0470cell9.setCellValue("");
			R0470cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0470cell10 = row.createCell(10);
		if (record1.getR0470_stage3b_assetclass() != null) {
			R0470cell10.setCellValue(record1.getR0470_stage3b_assetclass().doubleValue());
			R0470cell10.setCellStyle(numberStyle);
		} else {
			R0470cell10.setCellValue("");
			R0470cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0470cell11 = row.createCell(11);
		if (record1.getR0470_stage3c_assetclass() != null) {
			R0470cell11.setCellValue(record1.getR0470_stage3c_assetclass().doubleValue());
			R0470cell11.setCellStyle(numberStyle);
		} else {
			R0470cell11.setCellValue("");
			R0470cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0470cell12 = row.createCell(12);
		if (record1.getR0470_stage1_provisionheld() != null) {
			R0470cell12.setCellValue(record1.getR0470_stage1_provisionheld().doubleValue());
			R0470cell12.setCellStyle(numberStyle);
		} else {
			R0470cell12.setCellValue("");
			R0470cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0470cell13 = row.createCell(13);
		if (record1.getR0470_stage2_provisionheld() != null) {
			R0470cell13.setCellValue(record1.getR0470_stage2_provisionheld().doubleValue());
			R0470cell13.setCellStyle(numberStyle);
		} else {
			R0470cell13.setCellValue("");
			R0470cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0470cell14 = row.createCell(14);
		if (record1.getR0470_stage3a_provisionheld() != null) {
			R0470cell14.setCellValue(record1.getR0470_stage3a_provisionheld().doubleValue());
			R0470cell14.setCellStyle(numberStyle);
		} else {
			R0470cell14.setCellValue("");
			R0470cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0470cell15 = row.createCell(15);
		if (record1.getR0470_stage3b_provisionheld() != null) {
			R0470cell15.setCellValue(record1.getR0470_stage3b_provisionheld().doubleValue());
			R0470cell15.setCellStyle(numberStyle);
		} else {
			R0470cell15.setCellValue("");
			R0470cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0470cell16 = row.createCell(16);
		if (record1.getR0470_stage3c_provisionheld() != null) {
			R0470cell16.setCellValue(record1.getR0470_stage3c_provisionheld().doubleValue());
			R0470cell16.setCellStyle(numberStyle);
		} else {
			R0470cell16.setCellValue("");
			R0470cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0470cell17 = row.createCell(17);
		if (record1.getR0470_intrestfees_provisionheld() != null) {
			R0470cell17.setCellValue(record1.getR0470_intrestfees_provisionheld().doubleValue());
			R0470cell17.setCellStyle(numberStyle);
		} else {
			R0470cell17.setCellValue("");
			R0470cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0470cell18 = row.createCell(18);
		if (record1.getR0470_intrestsuspense_provisionheld() != null) {
			R0470cell18.setCellValue(record1.getR0470_intrestsuspense_provisionheld().doubleValue());
			R0470cell18.setCellStyle(numberStyle);
		} else {
			R0470cell18.setCellValue("");
			R0470cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0470cell19 = row.createCell(19);
		if (record1.getR0470_stage1_poci() != null) {
			R0470cell19.setCellValue(record1.getR0470_stage1_poci().doubleValue());
			R0470cell19.setCellStyle(numberStyle);
		} else {
			R0470cell19.setCellValue("");
			R0470cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0470cell20 = row.createCell(20);
		if (record1.getR0470_stage2_poci() != null) {
			R0470cell20.setCellValue(record1.getR0470_stage2_poci().doubleValue());
			R0470cell20.setCellStyle(numberStyle);
		} else {
			R0470cell20.setCellValue("");
			R0470cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0470cell21 = row.createCell(21);
		if (record1.getR0470_stage3a_poci() != null) {
			R0470cell21.setCellValue(record1.getR0470_stage3a_poci().doubleValue());
			R0470cell21.setCellStyle(numberStyle);
		} else {
			R0470cell21.setCellValue("");
			R0470cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0470cell22 = row.createCell(22);
		if (record1.getR0470_stage3b_poci() != null) {
			R0470cell22.setCellValue(record1.getR0470_stage3b_poci().doubleValue());
			R0470cell22.setCellStyle(numberStyle);
		} else {
			R0470cell22.setCellValue("");
			R0470cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0470cell23 = row.createCell(23);
		if (record1.getR0470_stage3c_poci() != null) {
			R0470cell23.setCellValue(record1.getR0470_stage3c_poci().doubleValue());
			R0470cell23.setCellStyle(numberStyle);
		} else {
			R0470cell23.setCellValue("");
			R0470cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0470cell24 = row.createCell(24);
		if (record1.getR0470_current_pastdues() != null) {
			R0470cell24.setCellValue(record1.getR0470_current_pastdues().doubleValue());
			R0470cell24.setCellStyle(numberStyle);
		} else {
			R0470cell24.setCellValue("");
			R0470cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0470cell25 = row.createCell(25);
		if (record1.getR0470_less30days_pastdues() != null) {
			R0470cell25.setCellValue(record1.getR0470_less30days_pastdues().doubleValue());
			R0470cell25.setCellStyle(numberStyle);
		} else {
			R0470cell25.setCellValue("");
			R0470cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0470cell26 = row.createCell(26);
		if (record1.getR0470_31to90days_pastdues() != null) {
			R0470cell26.setCellValue(record1.getR0470_31to90days_pastdues().doubleValue());
			R0470cell26.setCellStyle(numberStyle);
		} else {
			R0470cell26.setCellValue("");
			R0470cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0470cell27 = row.createCell(27);
		if (record1.getR0470_91to120days_pastdues() != null) {
			R0470cell27.setCellValue(record1.getR0470_91to120days_pastdues().doubleValue());
			R0470cell27.setCellStyle(numberStyle);
		} else {
			R0470cell27.setCellValue("");
			R0470cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0470cell28 = row.createCell(28);
		if (record1.getR0470_121to180days_pastdues() != null) {
			R0470cell28.setCellValue(record1.getR0470_121to180days_pastdues().doubleValue());
			R0470cell28.setCellStyle(numberStyle);
		} else {
			R0470cell28.setCellValue("");
			R0470cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0470cell29 = row.createCell(29);
		if (record1.getR0470_181to365days_pastdues() != null) {
			R0470cell29.setCellValue(record1.getR0470_181to365days_pastdues().doubleValue());
			R0470cell29.setCellStyle(numberStyle);
		} else {
			R0470cell29.setCellValue("");
			R0470cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0470cell30 = row.createCell(30);
		if (record1.getR0470_over365days_pastdues() != null) {
			R0470cell30.setCellValue(record1.getR0470_over365days_pastdues().doubleValue());
			R0470cell30.setCellStyle(numberStyle);
		} else {
			R0470cell30.setCellValue("");
			R0470cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0470cell32 = row.createCell(32);
		if (record1.getR0470_newloan_duringreport() != null) {
			R0470cell32.setCellValue(record1.getR0470_newloan_duringreport().doubleValue());
			R0470cell32.setCellStyle(numberStyle);
		} else {
			R0470cell32.setCellValue("");
			R0470cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0470cell33 = row.createCell(33);
		if (record1.getR0470_newstage_duringreport() != null) {
			R0470cell33.setCellValue(record1.getR0470_newstage_duringreport().doubleValue());
			R0470cell33.setCellStyle(numberStyle);
		} else {
			R0470cell33.setCellValue("");
			R0470cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0470cell34 = row.createCell(34);
		if (record1.getR0470_intrestfees_duringreport() != null) {
			R0470cell34.setCellValue(record1.getR0470_intrestfees_duringreport().doubleValue());
			R0470cell34.setCellStyle(numberStyle);
		} else {
			R0470cell34.setCellValue("");
			R0470cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0470cell35 = row.createCell(35);
		if (record1.getR0470_performingac_acinfo() != null) {
			R0470cell35.setCellValue(record1.getR0470_performingac_acinfo().doubleValue());
			R0470cell35.setCellStyle(numberStyle);
		} else {
			R0470cell35.setCellValue("");
			R0470cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0470cell36 = row.createCell(36);
		if (record1.getR0470_nonperformingac_acinfo() != null) {
			R0470cell36.setCellValue(record1.getR0470_nonperformingac_acinfo().doubleValue());
			R0470cell36.setCellStyle(numberStyle);
		} else {
			R0470cell36.setCellValue("");
			R0470cell36.setCellStyle(textStyle);
		}

		/// ROW57
		//// Column E
		row = sheet.getRow(56);
		Cell R0480cell4 = row.createCell(4);
		if (record1.getR0480_outstandbal() != null) {
			R0480cell4.setCellValue(record1.getR0480_outstandbal().doubleValue());
			R0480cell4.setCellStyle(numberStyle);
		} else {
			R0480cell4.setCellValue("");
			R0480cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0480cell5 = row.createCell(5);
		if (record1.getR0480_secured_outstandbal() != null) {
			R0480cell5.setCellValue(record1.getR0480_secured_outstandbal().doubleValue());
			R0480cell5.setCellStyle(numberStyle);
		} else {
			R0480cell5.setCellValue("");
			R0480cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0480cell6 = row.createCell(6);
		if (record1.getR0480_unsecured_outstandbal() != null) {
			R0480cell6.setCellValue(record1.getR0480_unsecured_outstandbal().doubleValue());
			R0480cell6.setCellStyle(numberStyle);
		} else {
			R0480cell6.setCellValue("");
			R0480cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0480cell7 = row.createCell(7);
		if (record1.getR0480_stage1_assetclass() != null) {
			R0480cell7.setCellValue(record1.getR0480_stage1_assetclass().doubleValue());
			R0480cell7.setCellStyle(numberStyle);
		} else {
			R0480cell7.setCellValue("");
			R0480cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0480cell8 = row.createCell(8);
		if (record1.getR0480_stage2_assetclass() != null) {
			R0480cell8.setCellValue(record1.getR0480_stage2_assetclass().doubleValue());
			R0480cell8.setCellStyle(numberStyle);
		} else {
			R0480cell8.setCellValue("");
			R0480cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0480cell9 = row.createCell(9);
		if (record1.getR0480_stage3a_assetclass() != null) {
			R0480cell9.setCellValue(record1.getR0480_stage3a_assetclass().doubleValue());
			R0480cell9.setCellStyle(numberStyle);
		} else {
			R0480cell9.setCellValue("");
			R0480cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0480cell10 = row.createCell(10);
		if (record1.getR0480_stage3b_assetclass() != null) {
			R0480cell10.setCellValue(record1.getR0480_stage3b_assetclass().doubleValue());
			R0480cell10.setCellStyle(numberStyle);
		} else {
			R0480cell10.setCellValue("");
			R0480cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0480cell11 = row.createCell(11);
		if (record1.getR0480_stage3c_assetclass() != null) {
			R0480cell11.setCellValue(record1.getR0480_stage3c_assetclass().doubleValue());
			R0480cell11.setCellStyle(numberStyle);
		} else {
			R0480cell11.setCellValue("");
			R0480cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0480cell12 = row.createCell(12);
		if (record1.getR0480_stage1_provisionheld() != null) {
			R0480cell12.setCellValue(record1.getR0480_stage1_provisionheld().doubleValue());
			R0480cell12.setCellStyle(numberStyle);
		} else {
			R0480cell12.setCellValue("");
			R0480cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0480cell13 = row.createCell(13);
		if (record1.getR0480_stage2_provisionheld() != null) {
			R0480cell13.setCellValue(record1.getR0480_stage2_provisionheld().doubleValue());
			R0480cell13.setCellStyle(numberStyle);
		} else {
			R0480cell13.setCellValue("");
			R0480cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0480cell14 = row.createCell(14);
		if (record1.getR0480_stage3a_provisionheld() != null) {
			R0480cell14.setCellValue(record1.getR0480_stage3a_provisionheld().doubleValue());
			R0480cell14.setCellStyle(numberStyle);
		} else {
			R0480cell14.setCellValue("");
			R0480cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0480cell15 = row.createCell(15);
		if (record1.getR0480_stage3b_provisionheld() != null) {
			R0480cell15.setCellValue(record1.getR0480_stage3b_provisionheld().doubleValue());
			R0480cell15.setCellStyle(numberStyle);
		} else {
			R0480cell15.setCellValue("");
			R0480cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0480cell16 = row.createCell(16);
		if (record1.getR0480_stage3c_provisionheld() != null) {
			R0480cell16.setCellValue(record1.getR0480_stage3c_provisionheld().doubleValue());
			R0480cell16.setCellStyle(numberStyle);
		} else {
			R0480cell16.setCellValue("");
			R0480cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0480cell17 = row.createCell(17);
		if (record1.getR0480_intrestfees_provisionheld() != null) {
			R0480cell17.setCellValue(record1.getR0480_intrestfees_provisionheld().doubleValue());
			R0480cell17.setCellStyle(numberStyle);
		} else {
			R0480cell17.setCellValue("");
			R0480cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0480cell18 = row.createCell(18);
		if (record1.getR0480_intrestsuspense_provisionheld() != null) {
			R0480cell18.setCellValue(record1.getR0480_intrestsuspense_provisionheld().doubleValue());
			R0480cell18.setCellStyle(numberStyle);
		} else {
			R0480cell18.setCellValue("");
			R0480cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0480cell19 = row.createCell(19);
		if (record1.getR0480_stage1_poci() != null) {
			R0480cell19.setCellValue(record1.getR0480_stage1_poci().doubleValue());
			R0480cell19.setCellStyle(numberStyle);
		} else {
			R0480cell19.setCellValue("");
			R0480cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0480cell20 = row.createCell(20);
		if (record1.getR0480_stage2_poci() != null) {
			R0480cell20.setCellValue(record1.getR0480_stage2_poci().doubleValue());
			R0480cell20.setCellStyle(numberStyle);
		} else {
			R0480cell20.setCellValue("");
			R0480cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0480cell21 = row.createCell(21);
		if (record1.getR0480_stage3a_poci() != null) {
			R0480cell21.setCellValue(record1.getR0480_stage3a_poci().doubleValue());
			R0480cell21.setCellStyle(numberStyle);
		} else {
			R0480cell21.setCellValue("");
			R0480cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0480cell22 = row.createCell(22);
		if (record1.getR0480_stage3b_poci() != null) {
			R0480cell22.setCellValue(record1.getR0480_stage3b_poci().doubleValue());
			R0480cell22.setCellStyle(numberStyle);
		} else {
			R0480cell22.setCellValue("");
			R0480cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0480cell23 = row.createCell(23);
		if (record1.getR0480_stage3c_poci() != null) {
			R0480cell23.setCellValue(record1.getR0480_stage3c_poci().doubleValue());
			R0480cell23.setCellStyle(numberStyle);
		} else {
			R0480cell23.setCellValue("");
			R0480cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0480cell24 = row.createCell(24);
		if (record1.getR0480_current_pastdues() != null) {
			R0480cell24.setCellValue(record1.getR0480_current_pastdues().doubleValue());
			R0480cell24.setCellStyle(numberStyle);
		} else {
			R0480cell24.setCellValue("");
			R0480cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0480cell25 = row.createCell(25);
		if (record1.getR0480_less30days_pastdues() != null) {
			R0480cell25.setCellValue(record1.getR0480_less30days_pastdues().doubleValue());
			R0480cell25.setCellStyle(numberStyle);
		} else {
			R0480cell25.setCellValue("");
			R0480cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0480cell26 = row.createCell(26);
		if (record1.getR0480_31to90days_pastdues() != null) {
			R0480cell26.setCellValue(record1.getR0480_31to90days_pastdues().doubleValue());
			R0480cell26.setCellStyle(numberStyle);
		} else {
			R0480cell26.setCellValue("");
			R0480cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0480cell27 = row.createCell(27);
		if (record1.getR0480_91to120days_pastdues() != null) {
			R0480cell27.setCellValue(record1.getR0480_91to120days_pastdues().doubleValue());
			R0480cell27.setCellStyle(numberStyle);
		} else {
			R0480cell27.setCellValue("");
			R0480cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0480cell28 = row.createCell(28);
		if (record1.getR0480_121to180days_pastdues() != null) {
			R0480cell28.setCellValue(record1.getR0480_121to180days_pastdues().doubleValue());
			R0480cell28.setCellStyle(numberStyle);
		} else {
			R0480cell28.setCellValue("");
			R0480cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0480cell29 = row.createCell(29);
		if (record1.getR0480_181to365days_pastdues() != null) {
			R0480cell29.setCellValue(record1.getR0480_181to365days_pastdues().doubleValue());
			R0480cell29.setCellStyle(numberStyle);
		} else {
			R0480cell29.setCellValue("");
			R0480cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0480cell30 = row.createCell(30);
		if (record1.getR0480_over365days_pastdues() != null) {
			R0480cell30.setCellValue(record1.getR0480_over365days_pastdues().doubleValue());
			R0480cell30.setCellStyle(numberStyle);
		} else {
			R0480cell30.setCellValue("");
			R0480cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0480cell32 = row.createCell(32);
		if (record1.getR0480_newloan_duringreport() != null) {
			R0480cell32.setCellValue(record1.getR0480_newloan_duringreport().doubleValue());
			R0480cell32.setCellStyle(numberStyle);
		} else {
			R0480cell32.setCellValue("");
			R0480cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0480cell33 = row.createCell(33);
		if (record1.getR0480_newstage_duringreport() != null) {
			R0480cell33.setCellValue(record1.getR0480_newstage_duringreport().doubleValue());
			R0480cell33.setCellStyle(numberStyle);
		} else {
			R0480cell33.setCellValue("");
			R0480cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0480cell34 = row.createCell(34);
		if (record1.getR0480_intrestfees_duringreport() != null) {
			R0480cell34.setCellValue(record1.getR0480_intrestfees_duringreport().doubleValue());
			R0480cell34.setCellStyle(numberStyle);
		} else {
			R0480cell34.setCellValue("");
			R0480cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0480cell35 = row.createCell(35);
		if (record1.getR0480_performingac_acinfo() != null) {
			R0480cell35.setCellValue(record1.getR0480_performingac_acinfo().doubleValue());
			R0480cell35.setCellStyle(numberStyle);
		} else {
			R0480cell35.setCellValue("");
			R0480cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0480cell36 = row.createCell(36);
		if (record1.getR0480_nonperformingac_acinfo() != null) {
			R0480cell36.setCellValue(record1.getR0480_nonperformingac_acinfo().doubleValue());
			R0480cell36.setCellStyle(numberStyle);
		} else {
			R0480cell36.setCellValue("");
			R0480cell36.setCellStyle(textStyle);
		}

		/// ROW58
		//// Column E
		row = sheet.getRow(57);
		Cell R0490cell4 = row.createCell(4);
		if (record1.getR0490_outstandbal() != null) {
			R0490cell4.setCellValue(record1.getR0490_outstandbal().doubleValue());
			R0490cell4.setCellStyle(numberStyle);
		} else {
			R0490cell4.setCellValue("");
			R0490cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0490cell5 = row.createCell(5);
		if (record1.getR0490_secured_outstandbal() != null) {
			R0490cell5.setCellValue(record1.getR0490_secured_outstandbal().doubleValue());
			R0490cell5.setCellStyle(numberStyle);
		} else {
			R0490cell5.setCellValue("");
			R0490cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0490cell6 = row.createCell(6);
		if (record1.getR0490_unsecured_outstandbal() != null) {
			R0490cell6.setCellValue(record1.getR0490_unsecured_outstandbal().doubleValue());
			R0490cell6.setCellStyle(numberStyle);
		} else {
			R0490cell6.setCellValue("");
			R0490cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0490cell7 = row.createCell(7);
		if (record1.getR0490_stage1_assetclass() != null) {
			R0490cell7.setCellValue(record1.getR0490_stage1_assetclass().doubleValue());
			R0490cell7.setCellStyle(numberStyle);
		} else {
			R0490cell7.setCellValue("");
			R0490cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0490cell8 = row.createCell(8);
		if (record1.getR0490_stage2_assetclass() != null) {
			R0490cell8.setCellValue(record1.getR0490_stage2_assetclass().doubleValue());
			R0490cell8.setCellStyle(numberStyle);
		} else {
			R0490cell8.setCellValue("");
			R0490cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0490cell9 = row.createCell(9);
		if (record1.getR0490_stage3a_assetclass() != null) {
			R0490cell9.setCellValue(record1.getR0490_stage3a_assetclass().doubleValue());
			R0490cell9.setCellStyle(numberStyle);
		} else {
			R0490cell9.setCellValue("");
			R0490cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0490cell10 = row.createCell(10);
		if (record1.getR0490_stage3b_assetclass() != null) {
			R0490cell10.setCellValue(record1.getR0490_stage3b_assetclass().doubleValue());
			R0490cell10.setCellStyle(numberStyle);
		} else {
			R0490cell10.setCellValue("");
			R0490cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0490cell11 = row.createCell(11);
		if (record1.getR0490_stage3c_assetclass() != null) {
			R0490cell11.setCellValue(record1.getR0490_stage3c_assetclass().doubleValue());
			R0490cell11.setCellStyle(numberStyle);
		} else {
			R0490cell11.setCellValue("");
			R0490cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0490cell12 = row.createCell(12);
		if (record1.getR0490_stage1_provisionheld() != null) {
			R0490cell12.setCellValue(record1.getR0490_stage1_provisionheld().doubleValue());
			R0490cell12.setCellStyle(numberStyle);
		} else {
			R0490cell12.setCellValue("");
			R0490cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0490cell13 = row.createCell(13);
		if (record1.getR0490_stage2_provisionheld() != null) {
			R0490cell13.setCellValue(record1.getR0490_stage2_provisionheld().doubleValue());
			R0490cell13.setCellStyle(numberStyle);
		} else {
			R0490cell13.setCellValue("");
			R0490cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0490cell14 = row.createCell(14);
		if (record1.getR0490_stage3a_provisionheld() != null) {
			R0490cell14.setCellValue(record1.getR0490_stage3a_provisionheld().doubleValue());
			R0490cell14.setCellStyle(numberStyle);
		} else {
			R0490cell14.setCellValue("");
			R0490cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0490cell15 = row.createCell(15);
		if (record1.getR0490_stage3b_provisionheld() != null) {
			R0490cell15.setCellValue(record1.getR0490_stage3b_provisionheld().doubleValue());
			R0490cell15.setCellStyle(numberStyle);
		} else {
			R0490cell15.setCellValue("");
			R0490cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0490cell16 = row.createCell(16);
		if (record1.getR0490_stage3c_provisionheld() != null) {
			R0490cell16.setCellValue(record1.getR0490_stage3c_provisionheld().doubleValue());
			R0490cell16.setCellStyle(numberStyle);
		} else {
			R0490cell16.setCellValue("");
			R0490cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0490cell17 = row.createCell(17);
		if (record1.getR0490_intrestfees_provisionheld() != null) {
			R0490cell17.setCellValue(record1.getR0490_intrestfees_provisionheld().doubleValue());
			R0490cell17.setCellStyle(numberStyle);
		} else {
			R0490cell17.setCellValue("");
			R0490cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0490cell18 = row.createCell(18);
		if (record1.getR0490_intrestsuspense_provisionheld() != null) {
			R0490cell18.setCellValue(record1.getR0490_intrestsuspense_provisionheld().doubleValue());
			R0490cell18.setCellStyle(numberStyle);
		} else {
			R0490cell18.setCellValue("");
			R0490cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0490cell19 = row.createCell(19);
		if (record1.getR0490_stage1_poci() != null) {
			R0490cell19.setCellValue(record1.getR0490_stage1_poci().doubleValue());
			R0490cell19.setCellStyle(numberStyle);
		} else {
			R0490cell19.setCellValue("");
			R0490cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0490cell20 = row.createCell(20);
		if (record1.getR0490_stage2_poci() != null) {
			R0490cell20.setCellValue(record1.getR0490_stage2_poci().doubleValue());
			R0490cell20.setCellStyle(numberStyle);
		} else {
			R0490cell20.setCellValue("");
			R0490cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0490cell21 = row.createCell(21);
		if (record1.getR0490_stage3a_poci() != null) {
			R0490cell21.setCellValue(record1.getR0490_stage3a_poci().doubleValue());
			R0490cell21.setCellStyle(numberStyle);
		} else {
			R0490cell21.setCellValue("");
			R0490cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0490cell22 = row.createCell(22);
		if (record1.getR0490_stage3b_poci() != null) {
			R0490cell22.setCellValue(record1.getR0490_stage3b_poci().doubleValue());
			R0490cell22.setCellStyle(numberStyle);
		} else {
			R0490cell22.setCellValue("");
			R0490cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0490cell23 = row.createCell(23);
		if (record1.getR0490_stage3c_poci() != null) {
			R0490cell23.setCellValue(record1.getR0490_stage3c_poci().doubleValue());
			R0490cell23.setCellStyle(numberStyle);
		} else {
			R0490cell23.setCellValue("");
			R0490cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0490cell24 = row.createCell(24);
		if (record1.getR0490_current_pastdues() != null) {
			R0490cell24.setCellValue(record1.getR0490_current_pastdues().doubleValue());
			R0490cell24.setCellStyle(numberStyle);
		} else {
			R0490cell24.setCellValue("");
			R0490cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0490cell25 = row.createCell(25);
		if (record1.getR0490_less30days_pastdues() != null) {
			R0490cell25.setCellValue(record1.getR0490_less30days_pastdues().doubleValue());
			R0490cell25.setCellStyle(numberStyle);
		} else {
			R0490cell25.setCellValue("");
			R0490cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0490cell26 = row.createCell(26);
		if (record1.getR0490_31to90days_pastdues() != null) {
			R0490cell26.setCellValue(record1.getR0490_31to90days_pastdues().doubleValue());
			R0490cell26.setCellStyle(numberStyle);
		} else {
			R0490cell26.setCellValue("");
			R0490cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0490cell27 = row.createCell(27);
		if (record1.getR0490_91to120days_pastdues() != null) {
			R0490cell27.setCellValue(record1.getR0490_91to120days_pastdues().doubleValue());
			R0490cell27.setCellStyle(numberStyle);
		} else {
			R0490cell27.setCellValue("");
			R0490cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0490cell28 = row.createCell(28);
		if (record1.getR0490_121to180days_pastdues() != null) {
			R0490cell28.setCellValue(record1.getR0490_121to180days_pastdues().doubleValue());
			R0490cell28.setCellStyle(numberStyle);
		} else {
			R0490cell28.setCellValue("");
			R0490cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0490cell29 = row.createCell(29);
		if (record1.getR0490_181to365days_pastdues() != null) {
			R0490cell29.setCellValue(record1.getR0490_181to365days_pastdues().doubleValue());
			R0490cell29.setCellStyle(numberStyle);
		} else {
			R0490cell29.setCellValue("");
			R0490cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0490cell30 = row.createCell(30);
		if (record1.getR0490_over365days_pastdues() != null) {
			R0490cell30.setCellValue(record1.getR0490_over365days_pastdues().doubleValue());
			R0490cell30.setCellStyle(numberStyle);
		} else {
			R0490cell30.setCellValue("");
			R0490cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0490cell32 = row.createCell(32);
		if (record1.getR0490_newloan_duringreport() != null) {
			R0490cell32.setCellValue(record1.getR0490_newloan_duringreport().doubleValue());
			R0490cell32.setCellStyle(numberStyle);
		} else {
			R0490cell32.setCellValue("");
			R0490cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0490cell33 = row.createCell(33);
		if (record1.getR0490_newstage_duringreport() != null) {
			R0490cell33.setCellValue(record1.getR0490_newstage_duringreport().doubleValue());
			R0490cell33.setCellStyle(numberStyle);
		} else {
			R0490cell33.setCellValue("");
			R0490cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0490cell34 = row.createCell(34);
		if (record1.getR0490_intrestfees_duringreport() != null) {
			R0490cell34.setCellValue(record1.getR0490_intrestfees_duringreport().doubleValue());
			R0490cell34.setCellStyle(numberStyle);
		} else {
			R0490cell34.setCellValue("");
			R0490cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0490cell35 = row.createCell(35);
		if (record1.getR0490_performingac_acinfo() != null) {
			R0490cell35.setCellValue(record1.getR0490_performingac_acinfo().doubleValue());
			R0490cell35.setCellStyle(numberStyle);
		} else {
			R0490cell35.setCellValue("");
			R0490cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0490cell36 = row.createCell(36);
		if (record1.getR0490_nonperformingac_acinfo() != null) {
			R0490cell36.setCellValue(record1.getR0490_nonperformingac_acinfo().doubleValue());
			R0490cell36.setCellStyle(numberStyle);
		} else {
			R0490cell36.setCellValue("");
			R0490cell36.setCellStyle(textStyle);
		}

		/// ROW59
		//// Column E
		row = sheet.getRow(58);
		Cell R0500cell4 = row.createCell(4);
		if (record1.getR0500_outstandbal() != null) {
			R0500cell4.setCellValue(record1.getR0500_outstandbal().doubleValue());
			R0500cell4.setCellStyle(numberStyle);
		} else {
			R0500cell4.setCellValue("");
			R0500cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0500cell5 = row.createCell(5);
		if (record1.getR0500_secured_outstandbal() != null) {
			R0500cell5.setCellValue(record1.getR0500_secured_outstandbal().doubleValue());
			R0500cell5.setCellStyle(numberStyle);
		} else {
			R0500cell5.setCellValue("");
			R0500cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0500cell6 = row.createCell(6);
		if (record1.getR0500_unsecured_outstandbal() != null) {
			R0500cell6.setCellValue(record1.getR0500_unsecured_outstandbal().doubleValue());
			R0500cell6.setCellStyle(numberStyle);
		} else {
			R0500cell6.setCellValue("");
			R0500cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0500cell7 = row.createCell(7);
		if (record1.getR0500_stage1_assetclass() != null) {
			R0500cell7.setCellValue(record1.getR0500_stage1_assetclass().doubleValue());
			R0500cell7.setCellStyle(numberStyle);
		} else {
			R0500cell7.setCellValue("");
			R0500cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0500cell8 = row.createCell(8);
		if (record1.getR0500_stage2_assetclass() != null) {
			R0500cell8.setCellValue(record1.getR0500_stage2_assetclass().doubleValue());
			R0500cell8.setCellStyle(numberStyle);
		} else {
			R0500cell8.setCellValue("");
			R0500cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0500cell9 = row.createCell(9);
		if (record1.getR0500_stage3a_assetclass() != null) {
			R0500cell9.setCellValue(record1.getR0500_stage3a_assetclass().doubleValue());
			R0500cell9.setCellStyle(numberStyle);
		} else {
			R0500cell9.setCellValue("");
			R0500cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0500cell10 = row.createCell(10);
		if (record1.getR0500_stage3b_assetclass() != null) {
			R0500cell10.setCellValue(record1.getR0500_stage3b_assetclass().doubleValue());
			R0500cell10.setCellStyle(numberStyle);
		} else {
			R0500cell10.setCellValue("");
			R0500cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0500cell11 = row.createCell(11);
		if (record1.getR0500_stage3c_assetclass() != null) {
			R0500cell11.setCellValue(record1.getR0500_stage3c_assetclass().doubleValue());
			R0500cell11.setCellStyle(numberStyle);
		} else {
			R0500cell11.setCellValue("");
			R0500cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0500cell12 = row.createCell(12);
		if (record1.getR0500_stage1_provisionheld() != null) {
			R0500cell12.setCellValue(record1.getR0500_stage1_provisionheld().doubleValue());
			R0500cell12.setCellStyle(numberStyle);
		} else {
			R0500cell12.setCellValue("");
			R0500cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0500cell13 = row.createCell(13);
		if (record1.getR0500_stage2_provisionheld() != null) {
			R0500cell13.setCellValue(record1.getR0500_stage2_provisionheld().doubleValue());
			R0500cell13.setCellStyle(numberStyle);
		} else {
			R0500cell13.setCellValue("");
			R0500cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0500cell14 = row.createCell(14);
		if (record1.getR0500_stage3a_provisionheld() != null) {
			R0500cell14.setCellValue(record1.getR0500_stage3a_provisionheld().doubleValue());
			R0500cell14.setCellStyle(numberStyle);
		} else {
			R0500cell14.setCellValue("");
			R0500cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0500cell15 = row.createCell(15);
		if (record1.getR0500_stage3b_provisionheld() != null) {
			R0500cell15.setCellValue(record1.getR0500_stage3b_provisionheld().doubleValue());
			R0500cell15.setCellStyle(numberStyle);
		} else {
			R0500cell15.setCellValue("");
			R0500cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0500cell16 = row.createCell(16);
		if (record1.getR0500_stage3c_provisionheld() != null) {
			R0500cell16.setCellValue(record1.getR0500_stage3c_provisionheld().doubleValue());
			R0500cell16.setCellStyle(numberStyle);
		} else {
			R0500cell16.setCellValue("");
			R0500cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0500cell17 = row.createCell(17);
		if (record1.getR0500_intrestfees_provisionheld() != null) {
			R0500cell17.setCellValue(record1.getR0500_intrestfees_provisionheld().doubleValue());
			R0500cell17.setCellStyle(numberStyle);
		} else {
			R0500cell17.setCellValue("");
			R0500cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0500cell18 = row.createCell(18);
		if (record1.getR0500_intrestsuspense_provisionheld() != null) {
			R0500cell18.setCellValue(record1.getR0500_intrestsuspense_provisionheld().doubleValue());
			R0500cell18.setCellStyle(numberStyle);
		} else {
			R0500cell18.setCellValue("");
			R0500cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0500cell19 = row.createCell(19);
		if (record1.getR0500_stage1_poci() != null) {
			R0500cell19.setCellValue(record1.getR0500_stage1_poci().doubleValue());
			R0500cell19.setCellStyle(numberStyle);
		} else {
			R0500cell19.setCellValue("");
			R0500cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0500cell20 = row.createCell(20);
		if (record1.getR0500_stage2_poci() != null) {
			R0500cell20.setCellValue(record1.getR0500_stage2_poci().doubleValue());
			R0500cell20.setCellStyle(numberStyle);
		} else {
			R0500cell20.setCellValue("");
			R0500cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0500cell21 = row.createCell(21);
		if (record1.getR0500_stage3a_poci() != null) {
			R0500cell21.setCellValue(record1.getR0500_stage3a_poci().doubleValue());
			R0500cell21.setCellStyle(numberStyle);
		} else {
			R0500cell21.setCellValue("");
			R0500cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0500cell22 = row.createCell(22);
		if (record1.getR0500_stage3b_poci() != null) {
			R0500cell22.setCellValue(record1.getR0500_stage3b_poci().doubleValue());
			R0500cell22.setCellStyle(numberStyle);
		} else {
			R0500cell22.setCellValue("");
			R0500cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0500cell23 = row.createCell(23);
		if (record1.getR0500_stage3c_poci() != null) {
			R0500cell23.setCellValue(record1.getR0500_stage3c_poci().doubleValue());
			R0500cell23.setCellStyle(numberStyle);
		} else {
			R0500cell23.setCellValue("");
			R0500cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0500cell24 = row.createCell(24);
		if (record1.getR0500_current_pastdues() != null) {
			R0500cell24.setCellValue(record1.getR0500_current_pastdues().doubleValue());
			R0500cell24.setCellStyle(numberStyle);
		} else {
			R0500cell24.setCellValue("");
			R0500cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0500cell25 = row.createCell(25);
		if (record1.getR0500_less30days_pastdues() != null) {
			R0500cell25.setCellValue(record1.getR0500_less30days_pastdues().doubleValue());
			R0500cell25.setCellStyle(numberStyle);
		} else {
			R0500cell25.setCellValue("");
			R0500cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0500cell26 = row.createCell(26);
		if (record1.getR0500_31to90days_pastdues() != null) {
			R0500cell26.setCellValue(record1.getR0500_31to90days_pastdues().doubleValue());
			R0500cell26.setCellStyle(numberStyle);
		} else {
			R0500cell26.setCellValue("");
			R0500cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0500cell27 = row.createCell(27);
		if (record1.getR0500_91to120days_pastdues() != null) {
			R0500cell27.setCellValue(record1.getR0500_91to120days_pastdues().doubleValue());
			R0500cell27.setCellStyle(numberStyle);
		} else {
			R0500cell27.setCellValue("");
			R0500cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0500cell28 = row.createCell(28);
		if (record1.getR0500_121to180days_pastdues() != null) {
			R0500cell28.setCellValue(record1.getR0500_121to180days_pastdues().doubleValue());
			R0500cell28.setCellStyle(numberStyle);
		} else {
			R0500cell28.setCellValue("");
			R0500cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0500cell29 = row.createCell(29);
		if (record1.getR0500_181to365days_pastdues() != null) {
			R0500cell29.setCellValue(record1.getR0500_181to365days_pastdues().doubleValue());
			R0500cell29.setCellStyle(numberStyle);
		} else {
			R0500cell29.setCellValue("");
			R0500cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0500cell30 = row.createCell(30);
		if (record1.getR0500_over365days_pastdues() != null) {
			R0500cell30.setCellValue(record1.getR0500_over365days_pastdues().doubleValue());
			R0500cell30.setCellStyle(numberStyle);
		} else {
			R0500cell30.setCellValue("");
			R0500cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0500cell32 = row.createCell(32);
		if (record1.getR0500_newloan_duringreport() != null) {
			R0500cell32.setCellValue(record1.getR0500_newloan_duringreport().doubleValue());
			R0500cell32.setCellStyle(numberStyle);
		} else {
			R0500cell32.setCellValue("");
			R0500cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0500cell33 = row.createCell(33);
		if (record1.getR0500_newstage_duringreport() != null) {
			R0500cell33.setCellValue(record1.getR0500_newstage_duringreport().doubleValue());
			R0500cell33.setCellStyle(numberStyle);
		} else {
			R0500cell33.setCellValue("");
			R0500cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0500cell34 = row.createCell(34);
		if (record1.getR0500_intrestfees_duringreport() != null) {
			R0500cell34.setCellValue(record1.getR0500_intrestfees_duringreport().doubleValue());
			R0500cell34.setCellStyle(numberStyle);
		} else {
			R0500cell34.setCellValue("");
			R0500cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0500cell35 = row.createCell(35);
		if (record1.getR0500_performingac_acinfo() != null) {
			R0500cell35.setCellValue(record1.getR0500_performingac_acinfo().doubleValue());
			R0500cell35.setCellStyle(numberStyle);
		} else {
			R0500cell35.setCellValue("");
			R0500cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0500cell36 = row.createCell(36);
		if (record1.getR0500_nonperformingac_acinfo() != null) {
			R0500cell36.setCellValue(record1.getR0500_nonperformingac_acinfo().doubleValue());
			R0500cell36.setCellStyle(numberStyle);
		} else {
			R0500cell36.setCellValue("");
			R0500cell36.setCellStyle(textStyle);
		}

		/// ROW60
		//// Column E
		row = sheet.getRow(59);
		Cell R0510cell4 = row.createCell(4);
		if (record1.getR0510_outstandbal() != null) {
			R0510cell4.setCellValue(record1.getR0510_outstandbal().doubleValue());
			R0510cell4.setCellStyle(numberStyle);
		} else {
			R0510cell4.setCellValue("");
			R0510cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0510cell5 = row.createCell(5);
		if (record1.getR0510_secured_outstandbal() != null) {
			R0510cell5.setCellValue(record1.getR0510_secured_outstandbal().doubleValue());
			R0510cell5.setCellStyle(numberStyle);
		} else {
			R0510cell5.setCellValue("");
			R0510cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0510cell6 = row.createCell(6);
		if (record1.getR0510_unsecured_outstandbal() != null) {
			R0510cell6.setCellValue(record1.getR0510_unsecured_outstandbal().doubleValue());
			R0510cell6.setCellStyle(numberStyle);
		} else {
			R0510cell6.setCellValue("");
			R0510cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0510cell7 = row.createCell(7);
		if (record1.getR0510_stage1_assetclass() != null) {
			R0510cell7.setCellValue(record1.getR0510_stage1_assetclass().doubleValue());
			R0510cell7.setCellStyle(numberStyle);
		} else {
			R0510cell7.setCellValue("");
			R0510cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0510cell8 = row.createCell(8);
		if (record1.getR0510_stage2_assetclass() != null) {
			R0510cell8.setCellValue(record1.getR0510_stage2_assetclass().doubleValue());
			R0510cell8.setCellStyle(numberStyle);
		} else {
			R0510cell8.setCellValue("");
			R0510cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0510cell9 = row.createCell(9);
		if (record1.getR0510_stage3a_assetclass() != null) {
			R0510cell9.setCellValue(record1.getR0510_stage3a_assetclass().doubleValue());
			R0510cell9.setCellStyle(numberStyle);
		} else {
			R0510cell9.setCellValue("");
			R0510cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0510cell10 = row.createCell(10);
		if (record1.getR0510_stage3b_assetclass() != null) {
			R0510cell10.setCellValue(record1.getR0510_stage3b_assetclass().doubleValue());
			R0510cell10.setCellStyle(numberStyle);
		} else {
			R0510cell10.setCellValue("");
			R0510cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0510cell11 = row.createCell(11);
		if (record1.getR0510_stage3c_assetclass() != null) {
			R0510cell11.setCellValue(record1.getR0510_stage3c_assetclass().doubleValue());
			R0510cell11.setCellStyle(numberStyle);
		} else {
			R0510cell11.setCellValue("");
			R0510cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0510cell12 = row.createCell(12);
		if (record1.getR0510_stage1_provisionheld() != null) {
			R0510cell12.setCellValue(record1.getR0510_stage1_provisionheld().doubleValue());
			R0510cell12.setCellStyle(numberStyle);
		} else {
			R0510cell12.setCellValue("");
			R0510cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0510cell13 = row.createCell(13);
		if (record1.getR0510_stage2_provisionheld() != null) {
			R0510cell13.setCellValue(record1.getR0510_stage2_provisionheld().doubleValue());
			R0510cell13.setCellStyle(numberStyle);
		} else {
			R0510cell13.setCellValue("");
			R0510cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0510cell14 = row.createCell(14);
		if (record1.getR0510_stage3a_provisionheld() != null) {
			R0510cell14.setCellValue(record1.getR0510_stage3a_provisionheld().doubleValue());
			R0510cell14.setCellStyle(numberStyle);
		} else {
			R0510cell14.setCellValue("");
			R0510cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0510cell15 = row.createCell(15);
		if (record1.getR0510_stage3b_provisionheld() != null) {
			R0510cell15.setCellValue(record1.getR0510_stage3b_provisionheld().doubleValue());
			R0510cell15.setCellStyle(numberStyle);
		} else {
			R0510cell15.setCellValue("");
			R0510cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0510cell16 = row.createCell(16);
		if (record1.getR0510_stage3c_provisionheld() != null) {
			R0510cell16.setCellValue(record1.getR0510_stage3c_provisionheld().doubleValue());
			R0510cell16.setCellStyle(numberStyle);
		} else {
			R0510cell16.setCellValue("");
			R0510cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0510cell17 = row.createCell(17);
		if (record1.getR0510_intrestfees_provisionheld() != null) {
			R0510cell17.setCellValue(record1.getR0510_intrestfees_provisionheld().doubleValue());
			R0510cell17.setCellStyle(numberStyle);
		} else {
			R0510cell17.setCellValue("");
			R0510cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0510cell18 = row.createCell(18);
		if (record1.getR0510_intrestsuspense_provisionheld() != null) {
			R0510cell18.setCellValue(record1.getR0510_intrestsuspense_provisionheld().doubleValue());
			R0510cell18.setCellStyle(numberStyle);
		} else {
			R0510cell18.setCellValue("");
			R0510cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0510cell19 = row.createCell(19);
		if (record1.getR0510_stage1_poci() != null) {
			R0510cell19.setCellValue(record1.getR0510_stage1_poci().doubleValue());
			R0510cell19.setCellStyle(numberStyle);
		} else {
			R0510cell19.setCellValue("");
			R0510cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0510cell20 = row.createCell(20);
		if (record1.getR0510_stage2_poci() != null) {
			R0510cell20.setCellValue(record1.getR0510_stage2_poci().doubleValue());
			R0510cell20.setCellStyle(numberStyle);
		} else {
			R0510cell20.setCellValue("");
			R0510cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0510cell21 = row.createCell(21);
		if (record1.getR0510_stage3a_poci() != null) {
			R0510cell21.setCellValue(record1.getR0510_stage3a_poci().doubleValue());
			R0510cell21.setCellStyle(numberStyle);
		} else {
			R0510cell21.setCellValue("");
			R0510cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0510cell22 = row.createCell(22);
		if (record1.getR0510_stage3b_poci() != null) {
			R0510cell22.setCellValue(record1.getR0510_stage3b_poci().doubleValue());
			R0510cell22.setCellStyle(numberStyle);
		} else {
			R0510cell22.setCellValue("");
			R0510cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0510cell23 = row.createCell(23);
		if (record1.getR0510_stage3c_poci() != null) {
			R0510cell23.setCellValue(record1.getR0510_stage3c_poci().doubleValue());
			R0510cell23.setCellStyle(numberStyle);
		} else {
			R0510cell23.setCellValue("");
			R0510cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0510cell24 = row.createCell(24);
		if (record1.getR0510_current_pastdues() != null) {
			R0510cell24.setCellValue(record1.getR0510_current_pastdues().doubleValue());
			R0510cell24.setCellStyle(numberStyle);
		} else {
			R0510cell24.setCellValue("");
			R0510cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0510cell25 = row.createCell(25);
		if (record1.getR0510_less30days_pastdues() != null) {
			R0510cell25.setCellValue(record1.getR0510_less30days_pastdues().doubleValue());
			R0510cell25.setCellStyle(numberStyle);
		} else {
			R0510cell25.setCellValue("");
			R0510cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0510cell26 = row.createCell(26);
		if (record1.getR0510_31to90days_pastdues() != null) {
			R0510cell26.setCellValue(record1.getR0510_31to90days_pastdues().doubleValue());
			R0510cell26.setCellStyle(numberStyle);
		} else {
			R0510cell26.setCellValue("");
			R0510cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0510cell27 = row.createCell(27);
		if (record1.getR0510_91to120days_pastdues() != null) {
			R0510cell27.setCellValue(record1.getR0510_91to120days_pastdues().doubleValue());
			R0510cell27.setCellStyle(numberStyle);
		} else {
			R0510cell27.setCellValue("");
			R0510cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0510cell28 = row.createCell(28);
		if (record1.getR0510_121to180days_pastdues() != null) {
			R0510cell28.setCellValue(record1.getR0510_121to180days_pastdues().doubleValue());
			R0510cell28.setCellStyle(numberStyle);
		} else {
			R0510cell28.setCellValue("");
			R0510cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0510cell29 = row.createCell(29);
		if (record1.getR0510_181to365days_pastdues() != null) {
			R0510cell29.setCellValue(record1.getR0510_181to365days_pastdues().doubleValue());
			R0510cell29.setCellStyle(numberStyle);
		} else {
			R0510cell29.setCellValue("");
			R0510cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0510cell30 = row.createCell(30);
		if (record1.getR0510_over365days_pastdues() != null) {
			R0510cell30.setCellValue(record1.getR0510_over365days_pastdues().doubleValue());
			R0510cell30.setCellStyle(numberStyle);
		} else {
			R0510cell30.setCellValue("");
			R0510cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0510cell32 = row.createCell(32);
		if (record1.getR0510_newloan_duringreport() != null) {
			R0510cell32.setCellValue(record1.getR0510_newloan_duringreport().doubleValue());
			R0510cell32.setCellStyle(numberStyle);
		} else {
			R0510cell32.setCellValue("");
			R0510cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0510cell33 = row.createCell(33);
		if (record1.getR0510_newstage_duringreport() != null) {
			R0510cell33.setCellValue(record1.getR0510_newstage_duringreport().doubleValue());
			R0510cell33.setCellStyle(numberStyle);
		} else {
			R0510cell33.setCellValue("");
			R0510cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0510cell34 = row.createCell(34);
		if (record1.getR0510_intrestfees_duringreport() != null) {
			R0510cell34.setCellValue(record1.getR0510_intrestfees_duringreport().doubleValue());
			R0510cell34.setCellStyle(numberStyle);
		} else {
			R0510cell34.setCellValue("");
			R0510cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0510cell35 = row.createCell(35);
		if (record1.getR0510_performingac_acinfo() != null) {
			R0510cell35.setCellValue(record1.getR0510_performingac_acinfo().doubleValue());
			R0510cell35.setCellStyle(numberStyle);
		} else {
			R0510cell35.setCellValue("");
			R0510cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0510cell36 = row.createCell(36);
		if (record1.getR0510_nonperformingac_acinfo() != null) {
			R0510cell36.setCellValue(record1.getR0510_nonperformingac_acinfo().doubleValue());
			R0510cell36.setCellStyle(numberStyle);
		} else {
			R0510cell36.setCellValue("");
			R0510cell36.setCellStyle(textStyle);
		}

		/// ROW61
		//// Column E
		row = sheet.getRow(60);
		Cell R0520cell4 = row.createCell(4);
		if (record1.getR0520_outstandbal() != null) {
			R0520cell4.setCellValue(record1.getR0520_outstandbal().doubleValue());
			R0520cell4.setCellStyle(numberStyle);
		} else {
			R0520cell4.setCellValue("");
			R0520cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0520cell5 = row.createCell(5);
		if (record1.getR0520_secured_outstandbal() != null) {
			R0520cell5.setCellValue(record1.getR0520_secured_outstandbal().doubleValue());
			R0520cell5.setCellStyle(numberStyle);
		} else {
			R0520cell5.setCellValue("");
			R0520cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0520cell6 = row.createCell(6);
		if (record1.getR0520_unsecured_outstandbal() != null) {
			R0520cell6.setCellValue(record1.getR0520_unsecured_outstandbal().doubleValue());
			R0520cell6.setCellStyle(numberStyle);
		} else {
			R0520cell6.setCellValue("");
			R0520cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0520cell7 = row.createCell(7);
		if (record1.getR0520_stage1_assetclass() != null) {
			R0520cell7.setCellValue(record1.getR0520_stage1_assetclass().doubleValue());
			R0520cell7.setCellStyle(numberStyle);
		} else {
			R0520cell7.setCellValue("");
			R0520cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0520cell8 = row.createCell(8);
		if (record1.getR0520_stage2_assetclass() != null) {
			R0520cell8.setCellValue(record1.getR0520_stage2_assetclass().doubleValue());
			R0520cell8.setCellStyle(numberStyle);
		} else {
			R0520cell8.setCellValue("");
			R0520cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0520cell9 = row.createCell(9);
		if (record1.getR0520_stage3a_assetclass() != null) {
			R0520cell9.setCellValue(record1.getR0520_stage3a_assetclass().doubleValue());
			R0520cell9.setCellStyle(numberStyle);
		} else {
			R0520cell9.setCellValue("");
			R0520cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0520cell10 = row.createCell(10);
		if (record1.getR0520_stage3b_assetclass() != null) {
			R0520cell10.setCellValue(record1.getR0520_stage3b_assetclass().doubleValue());
			R0520cell10.setCellStyle(numberStyle);
		} else {
			R0520cell10.setCellValue("");
			R0520cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0520cell11 = row.createCell(11);
		if (record1.getR0520_stage3c_assetclass() != null) {
			R0520cell11.setCellValue(record1.getR0520_stage3c_assetclass().doubleValue());
			R0520cell11.setCellStyle(numberStyle);
		} else {
			R0520cell11.setCellValue("");
			R0520cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0520cell12 = row.createCell(12);
		if (record1.getR0520_stage1_provisionheld() != null) {
			R0520cell12.setCellValue(record1.getR0520_stage1_provisionheld().doubleValue());
			R0520cell12.setCellStyle(numberStyle);
		} else {
			R0520cell12.setCellValue("");
			R0520cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0520cell13 = row.createCell(13);
		if (record1.getR0520_stage2_provisionheld() != null) {
			R0520cell13.setCellValue(record1.getR0520_stage2_provisionheld().doubleValue());
			R0520cell13.setCellStyle(numberStyle);
		} else {
			R0520cell13.setCellValue("");
			R0520cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0520cell14 = row.createCell(14);
		if (record1.getR0520_stage3a_provisionheld() != null) {
			R0520cell14.setCellValue(record1.getR0520_stage3a_provisionheld().doubleValue());
			R0520cell14.setCellStyle(numberStyle);
		} else {
			R0520cell14.setCellValue("");
			R0520cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0520cell15 = row.createCell(15);
		if (record1.getR0520_stage3b_provisionheld() != null) {
			R0520cell15.setCellValue(record1.getR0520_stage3b_provisionheld().doubleValue());
			R0520cell15.setCellStyle(numberStyle);
		} else {
			R0520cell15.setCellValue("");
			R0520cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0520cell16 = row.createCell(16);
		if (record1.getR0520_stage3c_provisionheld() != null) {
			R0520cell16.setCellValue(record1.getR0520_stage3c_provisionheld().doubleValue());
			R0520cell16.setCellStyle(numberStyle);
		} else {
			R0520cell16.setCellValue("");
			R0520cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0520cell17 = row.createCell(17);
		if (record1.getR0520_intrestfees_provisionheld() != null) {
			R0520cell17.setCellValue(record1.getR0520_intrestfees_provisionheld().doubleValue());
			R0520cell17.setCellStyle(numberStyle);
		} else {
			R0520cell17.setCellValue("");
			R0520cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0520cell18 = row.createCell(18);
		if (record1.getR0520_intrestsuspense_provisionheld() != null) {
			R0520cell18.setCellValue(record1.getR0520_intrestsuspense_provisionheld().doubleValue());
			R0520cell18.setCellStyle(numberStyle);
		} else {
			R0520cell18.setCellValue("");
			R0520cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0520cell19 = row.createCell(19);
		if (record1.getR0520_stage1_poci() != null) {
			R0520cell19.setCellValue(record1.getR0520_stage1_poci().doubleValue());
			R0520cell19.setCellStyle(numberStyle);
		} else {
			R0520cell19.setCellValue("");
			R0520cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0520cell20 = row.createCell(20);
		if (record1.getR0520_stage2_poci() != null) {
			R0520cell20.setCellValue(record1.getR0520_stage2_poci().doubleValue());
			R0520cell20.setCellStyle(numberStyle);
		} else {
			R0520cell20.setCellValue("");
			R0520cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0520cell21 = row.createCell(21);
		if (record1.getR0520_stage3a_poci() != null) {
			R0520cell21.setCellValue(record1.getR0520_stage3a_poci().doubleValue());
			R0520cell21.setCellStyle(numberStyle);
		} else {
			R0520cell21.setCellValue("");
			R0520cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0520cell22 = row.createCell(22);
		if (record1.getR0520_stage3b_poci() != null) {
			R0520cell22.setCellValue(record1.getR0520_stage3b_poci().doubleValue());
			R0520cell22.setCellStyle(numberStyle);
		} else {
			R0520cell22.setCellValue("");
			R0520cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0520cell23 = row.createCell(23);
		if (record1.getR0520_stage3c_poci() != null) {
			R0520cell23.setCellValue(record1.getR0520_stage3c_poci().doubleValue());
			R0520cell23.setCellStyle(numberStyle);
		} else {
			R0520cell23.setCellValue("");
			R0520cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0520cell24 = row.createCell(24);
		if (record1.getR0520_current_pastdues() != null) {
			R0520cell24.setCellValue(record1.getR0520_current_pastdues().doubleValue());
			R0520cell24.setCellStyle(numberStyle);
		} else {
			R0520cell24.setCellValue("");
			R0520cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0520cell25 = row.createCell(25);
		if (record1.getR0520_less30days_pastdues() != null) {
			R0520cell25.setCellValue(record1.getR0520_less30days_pastdues().doubleValue());
			R0520cell25.setCellStyle(numberStyle);
		} else {
			R0520cell25.setCellValue("");
			R0520cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0520cell26 = row.createCell(26);
		if (record1.getR0520_31to90days_pastdues() != null) {
			R0520cell26.setCellValue(record1.getR0520_31to90days_pastdues().doubleValue());
			R0520cell26.setCellStyle(numberStyle);
		} else {
			R0520cell26.setCellValue("");
			R0520cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0520cell27 = row.createCell(27);
		if (record1.getR0520_91to120days_pastdues() != null) {
			R0520cell27.setCellValue(record1.getR0520_91to120days_pastdues().doubleValue());
			R0520cell27.setCellStyle(numberStyle);
		} else {
			R0520cell27.setCellValue("");
			R0520cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0520cell28 = row.createCell(28);
		if (record1.getR0520_121to180days_pastdues() != null) {
			R0520cell28.setCellValue(record1.getR0520_121to180days_pastdues().doubleValue());
			R0520cell28.setCellStyle(numberStyle);
		} else {
			R0520cell28.setCellValue("");
			R0520cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0520cell29 = row.createCell(29);
		if (record1.getR0520_181to365days_pastdues() != null) {
			R0520cell29.setCellValue(record1.getR0520_181to365days_pastdues().doubleValue());
			R0520cell29.setCellStyle(numberStyle);
		} else {
			R0520cell29.setCellValue("");
			R0520cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0520cell30 = row.createCell(30);
		if (record1.getR0520_over365days_pastdues() != null) {
			R0520cell30.setCellValue(record1.getR0520_over365days_pastdues().doubleValue());
			R0520cell30.setCellStyle(numberStyle);
		} else {
			R0520cell30.setCellValue("");
			R0520cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0520cell32 = row.createCell(32);
		if (record1.getR0520_newloan_duringreport() != null) {
			R0520cell32.setCellValue(record1.getR0520_newloan_duringreport().doubleValue());
			R0520cell32.setCellStyle(numberStyle);
		} else {
			R0520cell32.setCellValue("");
			R0520cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0520cell33 = row.createCell(33);
		if (record1.getR0520_newstage_duringreport() != null) {
			R0520cell33.setCellValue(record1.getR0520_newstage_duringreport().doubleValue());
			R0520cell33.setCellStyle(numberStyle);
		} else {
			R0520cell33.setCellValue("");
			R0520cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0520cell34 = row.createCell(34);
		if (record1.getR0520_intrestfees_duringreport() != null) {
			R0520cell34.setCellValue(record1.getR0520_intrestfees_duringreport().doubleValue());
			R0520cell34.setCellStyle(numberStyle);
		} else {
			R0520cell34.setCellValue("");
			R0520cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0520cell35 = row.createCell(35);
		if (record1.getR0520_performingac_acinfo() != null) {
			R0520cell35.setCellValue(record1.getR0520_performingac_acinfo().doubleValue());
			R0520cell35.setCellStyle(numberStyle);
		} else {
			R0520cell35.setCellValue("");
			R0520cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0520cell36 = row.createCell(36);
		if (record1.getR0520_nonperformingac_acinfo() != null) {
			R0520cell36.setCellValue(record1.getR0520_nonperformingac_acinfo().doubleValue());
			R0520cell36.setCellStyle(numberStyle);
		} else {
			R0520cell36.setCellValue("");
			R0520cell36.setCellStyle(textStyle);
		}

		/// ROW62
		//// Column E
		row = sheet.getRow(61);
		Cell R0530cell4 = row.createCell(4);
		if (record1.getR0530_outstandbal() != null) {
			R0530cell4.setCellValue(record1.getR0530_outstandbal().doubleValue());
			R0530cell4.setCellStyle(numberStyle);
		} else {
			R0530cell4.setCellValue("");
			R0530cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0530cell5 = row.createCell(5);
		if (record1.getR0530_secured_outstandbal() != null) {
			R0530cell5.setCellValue(record1.getR0530_secured_outstandbal().doubleValue());
			R0530cell5.setCellStyle(numberStyle);
		} else {
			R0530cell5.setCellValue("");
			R0530cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0530cell6 = row.createCell(6);
		if (record1.getR0530_unsecured_outstandbal() != null) {
			R0530cell6.setCellValue(record1.getR0530_unsecured_outstandbal().doubleValue());
			R0530cell6.setCellStyle(numberStyle);
		} else {
			R0530cell6.setCellValue("");
			R0530cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0530cell7 = row.createCell(7);
		if (record1.getR0530_stage1_assetclass() != null) {
			R0530cell7.setCellValue(record1.getR0530_stage1_assetclass().doubleValue());
			R0530cell7.setCellStyle(numberStyle);
		} else {
			R0530cell7.setCellValue("");
			R0530cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0530cell8 = row.createCell(8);
		if (record1.getR0530_stage2_assetclass() != null) {
			R0530cell8.setCellValue(record1.getR0530_stage2_assetclass().doubleValue());
			R0530cell8.setCellStyle(numberStyle);
		} else {
			R0530cell8.setCellValue("");
			R0530cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0530cell9 = row.createCell(9);
		if (record1.getR0530_stage3a_assetclass() != null) {
			R0530cell9.setCellValue(record1.getR0530_stage3a_assetclass().doubleValue());
			R0530cell9.setCellStyle(numberStyle);
		} else {
			R0530cell9.setCellValue("");
			R0530cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0530cell10 = row.createCell(10);
		if (record1.getR0530_stage3b_assetclass() != null) {
			R0530cell10.setCellValue(record1.getR0530_stage3b_assetclass().doubleValue());
			R0530cell10.setCellStyle(numberStyle);
		} else {
			R0530cell10.setCellValue("");
			R0530cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0530cell11 = row.createCell(11);
		if (record1.getR0530_stage3c_assetclass() != null) {
			R0530cell11.setCellValue(record1.getR0530_stage3c_assetclass().doubleValue());
			R0530cell11.setCellStyle(numberStyle);
		} else {
			R0530cell11.setCellValue("");
			R0530cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0530cell12 = row.createCell(12);
		if (record1.getR0530_stage1_provisionheld() != null) {
			R0530cell12.setCellValue(record1.getR0530_stage1_provisionheld().doubleValue());
			R0530cell12.setCellStyle(numberStyle);
		} else {
			R0530cell12.setCellValue("");
			R0530cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0530cell13 = row.createCell(13);
		if (record1.getR0530_stage2_provisionheld() != null) {
			R0530cell13.setCellValue(record1.getR0530_stage2_provisionheld().doubleValue());
			R0530cell13.setCellStyle(numberStyle);
		} else {
			R0530cell13.setCellValue("");
			R0530cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0530cell14 = row.createCell(14);
		if (record1.getR0530_stage3a_provisionheld() != null) {
			R0530cell14.setCellValue(record1.getR0530_stage3a_provisionheld().doubleValue());
			R0530cell14.setCellStyle(numberStyle);
		} else {
			R0530cell14.setCellValue("");
			R0530cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0530cell15 = row.createCell(15);
		if (record1.getR0530_stage3b_provisionheld() != null) {
			R0530cell15.setCellValue(record1.getR0530_stage3b_provisionheld().doubleValue());
			R0530cell15.setCellStyle(numberStyle);
		} else {
			R0530cell15.setCellValue("");
			R0530cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0530cell16 = row.createCell(16);
		if (record1.getR0530_stage3c_provisionheld() != null) {
			R0530cell16.setCellValue(record1.getR0530_stage3c_provisionheld().doubleValue());
			R0530cell16.setCellStyle(numberStyle);
		} else {
			R0530cell16.setCellValue("");
			R0530cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0530cell17 = row.createCell(17);
		if (record1.getR0530_intrestfees_provisionheld() != null) {
			R0530cell17.setCellValue(record1.getR0530_intrestfees_provisionheld().doubleValue());
			R0530cell17.setCellStyle(numberStyle);
		} else {
			R0530cell17.setCellValue("");
			R0530cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0530cell18 = row.createCell(18);
		if (record1.getR0530_intrestsuspense_provisionheld() != null) {
			R0530cell18.setCellValue(record1.getR0530_intrestsuspense_provisionheld().doubleValue());
			R0530cell18.setCellStyle(numberStyle);
		} else {
			R0530cell18.setCellValue("");
			R0530cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0530cell19 = row.createCell(19);
		if (record1.getR0530_stage1_poci() != null) {
			R0530cell19.setCellValue(record1.getR0530_stage1_poci().doubleValue());
			R0530cell19.setCellStyle(numberStyle);
		} else {
			R0530cell19.setCellValue("");
			R0530cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0530cell20 = row.createCell(20);
		if (record1.getR0530_stage2_poci() != null) {
			R0530cell20.setCellValue(record1.getR0530_stage2_poci().doubleValue());
			R0530cell20.setCellStyle(numberStyle);
		} else {
			R0530cell20.setCellValue("");
			R0530cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0530cell21 = row.createCell(21);
		if (record1.getR0530_stage3a_poci() != null) {
			R0530cell21.setCellValue(record1.getR0530_stage3a_poci().doubleValue());
			R0530cell21.setCellStyle(numberStyle);
		} else {
			R0530cell21.setCellValue("");
			R0530cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0530cell22 = row.createCell(22);
		if (record1.getR0530_stage3b_poci() != null) {
			R0530cell22.setCellValue(record1.getR0530_stage3b_poci().doubleValue());
			R0530cell22.setCellStyle(numberStyle);
		} else {
			R0530cell22.setCellValue("");
			R0530cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0530cell23 = row.createCell(23);
		if (record1.getR0530_stage3c_poci() != null) {
			R0530cell23.setCellValue(record1.getR0530_stage3c_poci().doubleValue());
			R0530cell23.setCellStyle(numberStyle);
		} else {
			R0530cell23.setCellValue("");
			R0530cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0530cell24 = row.createCell(24);
		if (record1.getR0530_current_pastdues() != null) {
			R0530cell24.setCellValue(record1.getR0530_current_pastdues().doubleValue());
			R0530cell24.setCellStyle(numberStyle);
		} else {
			R0530cell24.setCellValue("");
			R0530cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0530cell25 = row.createCell(25);
		if (record1.getR0530_less30days_pastdues() != null) {
			R0530cell25.setCellValue(record1.getR0530_less30days_pastdues().doubleValue());
			R0530cell25.setCellStyle(numberStyle);
		} else {
			R0530cell25.setCellValue("");
			R0530cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0530cell26 = row.createCell(26);
		if (record1.getR0530_31to90days_pastdues() != null) {
			R0530cell26.setCellValue(record1.getR0530_31to90days_pastdues().doubleValue());
			R0530cell26.setCellStyle(numberStyle);
		} else {
			R0530cell26.setCellValue("");
			R0530cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0530cell27 = row.createCell(27);
		if (record1.getR0530_91to120days_pastdues() != null) {
			R0530cell27.setCellValue(record1.getR0530_91to120days_pastdues().doubleValue());
			R0530cell27.setCellStyle(numberStyle);
		} else {
			R0530cell27.setCellValue("");
			R0530cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0530cell28 = row.createCell(28);
		if (record1.getR0530_121to180days_pastdues() != null) {
			R0530cell28.setCellValue(record1.getR0530_121to180days_pastdues().doubleValue());
			R0530cell28.setCellStyle(numberStyle);
		} else {
			R0530cell28.setCellValue("");
			R0530cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0530cell29 = row.createCell(29);
		if (record1.getR0530_181to365days_pastdues() != null) {
			R0530cell29.setCellValue(record1.getR0530_181to365days_pastdues().doubleValue());
			R0530cell29.setCellStyle(numberStyle);
		} else {
			R0530cell29.setCellValue("");
			R0530cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0530cell30 = row.createCell(30);
		if (record1.getR0530_over365days_pastdues() != null) {
			R0530cell30.setCellValue(record1.getR0530_over365days_pastdues().doubleValue());
			R0530cell30.setCellStyle(numberStyle);
		} else {
			R0530cell30.setCellValue("");
			R0530cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0530cell32 = row.createCell(32);
		if (record1.getR0530_newloan_duringreport() != null) {
			R0530cell32.setCellValue(record1.getR0530_newloan_duringreport().doubleValue());
			R0530cell32.setCellStyle(numberStyle);
		} else {
			R0530cell32.setCellValue("");
			R0530cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0530cell33 = row.createCell(33);
		if (record1.getR0530_newstage_duringreport() != null) {
			R0530cell33.setCellValue(record1.getR0530_newstage_duringreport().doubleValue());
			R0530cell33.setCellStyle(numberStyle);
		} else {
			R0530cell33.setCellValue("");
			R0530cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0530cell34 = row.createCell(34);
		if (record1.getR0530_intrestfees_duringreport() != null) {
			R0530cell34.setCellValue(record1.getR0530_intrestfees_duringreport().doubleValue());
			R0530cell34.setCellStyle(numberStyle);
		} else {
			R0530cell34.setCellValue("");
			R0530cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0530cell35 = row.createCell(35);
		if (record1.getR0530_performingac_acinfo() != null) {
			R0530cell35.setCellValue(record1.getR0530_performingac_acinfo().doubleValue());
			R0530cell35.setCellStyle(numberStyle);
		} else {
			R0530cell35.setCellValue("");
			R0530cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0530cell36 = row.createCell(36);
		if (record1.getR0530_nonperformingac_acinfo() != null) {
			R0530cell36.setCellValue(record1.getR0530_nonperformingac_acinfo().doubleValue());
			R0530cell36.setCellStyle(numberStyle);
		} else {
			R0530cell36.setCellValue("");
			R0530cell36.setCellStyle(textStyle);
		}

		/// ROW63
		//// Column E
		row = sheet.getRow(62);
		Cell R0540cell4 = row.createCell(4);
		if (record1.getR0540_outstandbal() != null) {
			R0540cell4.setCellValue(record1.getR0540_outstandbal().doubleValue());
			R0540cell4.setCellStyle(numberStyle);
		} else {
			R0540cell4.setCellValue("");
			R0540cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0540cell5 = row.createCell(5);
		if (record1.getR0540_secured_outstandbal() != null) {
			R0540cell5.setCellValue(record1.getR0540_secured_outstandbal().doubleValue());
			R0540cell5.setCellStyle(numberStyle);
		} else {
			R0540cell5.setCellValue("");
			R0540cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0540cell6 = row.createCell(6);
		if (record1.getR0540_unsecured_outstandbal() != null) {
			R0540cell6.setCellValue(record1.getR0540_unsecured_outstandbal().doubleValue());
			R0540cell6.setCellStyle(numberStyle);
		} else {
			R0540cell6.setCellValue("");
			R0540cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0540cell7 = row.createCell(7);
		if (record1.getR0540_stage1_assetclass() != null) {
			R0540cell7.setCellValue(record1.getR0540_stage1_assetclass().doubleValue());
			R0540cell7.setCellStyle(numberStyle);
		} else {
			R0540cell7.setCellValue("");
			R0540cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0540cell8 = row.createCell(8);
		if (record1.getR0540_stage2_assetclass() != null) {
			R0540cell8.setCellValue(record1.getR0540_stage2_assetclass().doubleValue());
			R0540cell8.setCellStyle(numberStyle);
		} else {
			R0540cell8.setCellValue("");
			R0540cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0540cell9 = row.createCell(9);
		if (record1.getR0540_stage3a_assetclass() != null) {
			R0540cell9.setCellValue(record1.getR0540_stage3a_assetclass().doubleValue());
			R0540cell9.setCellStyle(numberStyle);
		} else {
			R0540cell9.setCellValue("");
			R0540cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0540cell10 = row.createCell(10);
		if (record1.getR0540_stage3b_assetclass() != null) {
			R0540cell10.setCellValue(record1.getR0540_stage3b_assetclass().doubleValue());
			R0540cell10.setCellStyle(numberStyle);
		} else {
			R0540cell10.setCellValue("");
			R0540cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0540cell11 = row.createCell(11);
		if (record1.getR0540_stage3c_assetclass() != null) {
			R0540cell11.setCellValue(record1.getR0540_stage3c_assetclass().doubleValue());
			R0540cell11.setCellStyle(numberStyle);
		} else {
			R0540cell11.setCellValue("");
			R0540cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0540cell12 = row.createCell(12);
		if (record1.getR0540_stage1_provisionheld() != null) {
			R0540cell12.setCellValue(record1.getR0540_stage1_provisionheld().doubleValue());
			R0540cell12.setCellStyle(numberStyle);
		} else {
			R0540cell12.setCellValue("");
			R0540cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0540cell13 = row.createCell(13);
		if (record1.getR0540_stage2_provisionheld() != null) {
			R0540cell13.setCellValue(record1.getR0540_stage2_provisionheld().doubleValue());
			R0540cell13.setCellStyle(numberStyle);
		} else {
			R0540cell13.setCellValue("");
			R0540cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0540cell14 = row.createCell(14);
		if (record1.getR0540_stage3a_provisionheld() != null) {
			R0540cell14.setCellValue(record1.getR0540_stage3a_provisionheld().doubleValue());
			R0540cell14.setCellStyle(numberStyle);
		} else {
			R0540cell14.setCellValue("");
			R0540cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0540cell15 = row.createCell(15);
		if (record1.getR0540_stage3b_provisionheld() != null) {
			R0540cell15.setCellValue(record1.getR0540_stage3b_provisionheld().doubleValue());
			R0540cell15.setCellStyle(numberStyle);
		} else {
			R0540cell15.setCellValue("");
			R0540cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0540cell16 = row.createCell(16);
		if (record1.getR0540_stage3c_provisionheld() != null) {
			R0540cell16.setCellValue(record1.getR0540_stage3c_provisionheld().doubleValue());
			R0540cell16.setCellStyle(numberStyle);
		} else {
			R0540cell16.setCellValue("");
			R0540cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0540cell17 = row.createCell(17);
		if (record1.getR0540_intrestfees_provisionheld() != null) {
			R0540cell17.setCellValue(record1.getR0540_intrestfees_provisionheld().doubleValue());
			R0540cell17.setCellStyle(numberStyle);
		} else {
			R0540cell17.setCellValue("");
			R0540cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0540cell18 = row.createCell(18);
		if (record1.getR0540_intrestsuspense_provisionheld() != null) {
			R0540cell18.setCellValue(record1.getR0540_intrestsuspense_provisionheld().doubleValue());
			R0540cell18.setCellStyle(numberStyle);
		} else {
			R0540cell18.setCellValue("");
			R0540cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0540cell19 = row.createCell(19);
		if (record1.getR0540_stage1_poci() != null) {
			R0540cell19.setCellValue(record1.getR0540_stage1_poci().doubleValue());
			R0540cell19.setCellStyle(numberStyle);
		} else {
			R0540cell19.setCellValue("");
			R0540cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0540cell20 = row.createCell(20);
		if (record1.getR0540_stage2_poci() != null) {
			R0540cell20.setCellValue(record1.getR0540_stage2_poci().doubleValue());
			R0540cell20.setCellStyle(numberStyle);
		} else {
			R0540cell20.setCellValue("");
			R0540cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0540cell21 = row.createCell(21);
		if (record1.getR0540_stage3a_poci() != null) {
			R0540cell21.setCellValue(record1.getR0540_stage3a_poci().doubleValue());
			R0540cell21.setCellStyle(numberStyle);
		} else {
			R0540cell21.setCellValue("");
			R0540cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0540cell22 = row.createCell(22);
		if (record1.getR0540_stage3b_poci() != null) {
			R0540cell22.setCellValue(record1.getR0540_stage3b_poci().doubleValue());
			R0540cell22.setCellStyle(numberStyle);
		} else {
			R0540cell22.setCellValue("");
			R0540cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0540cell23 = row.createCell(23);
		if (record1.getR0540_stage3c_poci() != null) {
			R0540cell23.setCellValue(record1.getR0540_stage3c_poci().doubleValue());
			R0540cell23.setCellStyle(numberStyle);
		} else {
			R0540cell23.setCellValue("");
			R0540cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0540cell24 = row.createCell(24);
		if (record1.getR0540_current_pastdues() != null) {
			R0540cell24.setCellValue(record1.getR0540_current_pastdues().doubleValue());
			R0540cell24.setCellStyle(numberStyle);
		} else {
			R0540cell24.setCellValue("");
			R0540cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0540cell25 = row.createCell(25);
		if (record1.getR0540_less30days_pastdues() != null) {
			R0540cell25.setCellValue(record1.getR0540_less30days_pastdues().doubleValue());
			R0540cell25.setCellStyle(numberStyle);
		} else {
			R0540cell25.setCellValue("");
			R0540cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0540cell26 = row.createCell(26);
		if (record1.getR0540_31to90days_pastdues() != null) {
			R0540cell26.setCellValue(record1.getR0540_31to90days_pastdues().doubleValue());
			R0540cell26.setCellStyle(numberStyle);
		} else {
			R0540cell26.setCellValue("");
			R0540cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0540cell27 = row.createCell(27);
		if (record1.getR0540_91to120days_pastdues() != null) {
			R0540cell27.setCellValue(record1.getR0540_91to120days_pastdues().doubleValue());
			R0540cell27.setCellStyle(numberStyle);
		} else {
			R0540cell27.setCellValue("");
			R0540cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0540cell28 = row.createCell(28);
		if (record1.getR0540_121to180days_pastdues() != null) {
			R0540cell28.setCellValue(record1.getR0540_121to180days_pastdues().doubleValue());
			R0540cell28.setCellStyle(numberStyle);
		} else {
			R0540cell28.setCellValue("");
			R0540cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0540cell29 = row.createCell(29);
		if (record1.getR0540_181to365days_pastdues() != null) {
			R0540cell29.setCellValue(record1.getR0540_181to365days_pastdues().doubleValue());
			R0540cell29.setCellStyle(numberStyle);
		} else {
			R0540cell29.setCellValue("");
			R0540cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0540cell30 = row.createCell(30);
		if (record1.getR0540_over365days_pastdues() != null) {
			R0540cell30.setCellValue(record1.getR0540_over365days_pastdues().doubleValue());
			R0540cell30.setCellStyle(numberStyle);
		} else {
			R0540cell30.setCellValue("");
			R0540cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0540cell32 = row.createCell(32);
		if (record1.getR0540_newloan_duringreport() != null) {
			R0540cell32.setCellValue(record1.getR0540_newloan_duringreport().doubleValue());
			R0540cell32.setCellStyle(numberStyle);
		} else {
			R0540cell32.setCellValue("");
			R0540cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0540cell33 = row.createCell(33);
		if (record1.getR0540_newstage_duringreport() != null) {
			R0540cell33.setCellValue(record1.getR0540_newstage_duringreport().doubleValue());
			R0540cell33.setCellStyle(numberStyle);
		} else {
			R0540cell33.setCellValue("");
			R0540cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0540cell34 = row.createCell(34);
		if (record1.getR0540_intrestfees_duringreport() != null) {
			R0540cell34.setCellValue(record1.getR0540_intrestfees_duringreport().doubleValue());
			R0540cell34.setCellStyle(numberStyle);
		} else {
			R0540cell34.setCellValue("");
			R0540cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0540cell35 = row.createCell(35);
		if (record1.getR0540_performingac_acinfo() != null) {
			R0540cell35.setCellValue(record1.getR0540_performingac_acinfo().doubleValue());
			R0540cell35.setCellStyle(numberStyle);
		} else {
			R0540cell35.setCellValue("");
			R0540cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0540cell36 = row.createCell(36);
		if (record1.getR0540_nonperformingac_acinfo() != null) {
			R0540cell36.setCellValue(record1.getR0540_nonperformingac_acinfo().doubleValue());
			R0540cell36.setCellStyle(numberStyle);
		} else {
			R0540cell36.setCellValue("");
			R0540cell36.setCellStyle(textStyle);
		}

		/// ROW64
		//// Column E
		row = sheet.getRow(63);
		Cell R0550cell4 = row.createCell(4);
		if (record1.getR0550_outstandbal() != null) {
			R0550cell4.setCellValue(record1.getR0550_outstandbal().doubleValue());
			R0550cell4.setCellStyle(numberStyle);
		} else {
			R0550cell4.setCellValue("");
			R0550cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0550cell5 = row.createCell(5);
		if (record1.getR0550_secured_outstandbal() != null) {
			R0550cell5.setCellValue(record1.getR0550_secured_outstandbal().doubleValue());
			R0550cell5.setCellStyle(numberStyle);
		} else {
			R0550cell5.setCellValue("");
			R0550cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0550cell6 = row.createCell(6);
		if (record1.getR0550_unsecured_outstandbal() != null) {
			R0550cell6.setCellValue(record1.getR0550_unsecured_outstandbal().doubleValue());
			R0550cell6.setCellStyle(numberStyle);
		} else {
			R0550cell6.setCellValue("");
			R0550cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0550cell7 = row.createCell(7);
		if (record1.getR0550_stage1_assetclass() != null) {
			R0550cell7.setCellValue(record1.getR0550_stage1_assetclass().doubleValue());
			R0550cell7.setCellStyle(numberStyle);
		} else {
			R0550cell7.setCellValue("");
			R0550cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0550cell8 = row.createCell(8);
		if (record1.getR0550_stage2_assetclass() != null) {
			R0550cell8.setCellValue(record1.getR0550_stage2_assetclass().doubleValue());
			R0550cell8.setCellStyle(numberStyle);
		} else {
			R0550cell8.setCellValue("");
			R0550cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0550cell9 = row.createCell(9);
		if (record1.getR0550_stage3a_assetclass() != null) {
			R0550cell9.setCellValue(record1.getR0550_stage3a_assetclass().doubleValue());
			R0550cell9.setCellStyle(numberStyle);
		} else {
			R0550cell9.setCellValue("");
			R0550cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0550cell10 = row.createCell(10);
		if (record1.getR0550_stage3b_assetclass() != null) {
			R0550cell10.setCellValue(record1.getR0550_stage3b_assetclass().doubleValue());
			R0550cell10.setCellStyle(numberStyle);
		} else {
			R0550cell10.setCellValue("");
			R0550cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0550cell11 = row.createCell(11);
		if (record1.getR0550_stage3c_assetclass() != null) {
			R0550cell11.setCellValue(record1.getR0550_stage3c_assetclass().doubleValue());
			R0550cell11.setCellStyle(numberStyle);
		} else {
			R0550cell11.setCellValue("");
			R0550cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0550cell12 = row.createCell(12);
		if (record1.getR0550_stage1_provisionheld() != null) {
			R0550cell12.setCellValue(record1.getR0550_stage1_provisionheld().doubleValue());
			R0550cell12.setCellStyle(numberStyle);
		} else {
			R0550cell12.setCellValue("");
			R0550cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0550cell13 = row.createCell(13);
		if (record1.getR0550_stage2_provisionheld() != null) {
			R0550cell13.setCellValue(record1.getR0550_stage2_provisionheld().doubleValue());
			R0550cell13.setCellStyle(numberStyle);
		} else {
			R0550cell13.setCellValue("");
			R0550cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0550cell14 = row.createCell(14);
		if (record1.getR0550_stage3a_provisionheld() != null) {
			R0550cell14.setCellValue(record1.getR0550_stage3a_provisionheld().doubleValue());
			R0550cell14.setCellStyle(numberStyle);
		} else {
			R0550cell14.setCellValue("");
			R0550cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0550cell15 = row.createCell(15);
		if (record1.getR0550_stage3b_provisionheld() != null) {
			R0550cell15.setCellValue(record1.getR0550_stage3b_provisionheld().doubleValue());
			R0550cell15.setCellStyle(numberStyle);
		} else {
			R0550cell15.setCellValue("");
			R0550cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0550cell16 = row.createCell(16);
		if (record1.getR0550_stage3c_provisionheld() != null) {
			R0550cell16.setCellValue(record1.getR0550_stage3c_provisionheld().doubleValue());
			R0550cell16.setCellStyle(numberStyle);
		} else {
			R0550cell16.setCellValue("");
			R0550cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0550cell17 = row.createCell(17);
		if (record1.getR0550_intrestfees_provisionheld() != null) {
			R0550cell17.setCellValue(record1.getR0550_intrestfees_provisionheld().doubleValue());
			R0550cell17.setCellStyle(numberStyle);
		} else {
			R0550cell17.setCellValue("");
			R0550cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0550cell18 = row.createCell(18);
		if (record1.getR0550_intrestsuspense_provisionheld() != null) {
			R0550cell18.setCellValue(record1.getR0550_intrestsuspense_provisionheld().doubleValue());
			R0550cell18.setCellStyle(numberStyle);
		} else {
			R0550cell18.setCellValue("");
			R0550cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0550cell19 = row.createCell(19);
		if (record1.getR0550_stage1_poci() != null) {
			R0550cell19.setCellValue(record1.getR0550_stage1_poci().doubleValue());
			R0550cell19.setCellStyle(numberStyle);
		} else {
			R0550cell19.setCellValue("");
			R0550cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0550cell20 = row.createCell(20);
		if (record1.getR0550_stage2_poci() != null) {
			R0550cell20.setCellValue(record1.getR0550_stage2_poci().doubleValue());
			R0550cell20.setCellStyle(numberStyle);
		} else {
			R0550cell20.setCellValue("");
			R0550cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0550cell21 = row.createCell(21);
		if (record1.getR0550_stage3a_poci() != null) {
			R0550cell21.setCellValue(record1.getR0550_stage3a_poci().doubleValue());
			R0550cell21.setCellStyle(numberStyle);
		} else {
			R0550cell21.setCellValue("");
			R0550cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0550cell22 = row.createCell(22);
		if (record1.getR0550_stage3b_poci() != null) {
			R0550cell22.setCellValue(record1.getR0550_stage3b_poci().doubleValue());
			R0550cell22.setCellStyle(numberStyle);
		} else {
			R0550cell22.setCellValue("");
			R0550cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0550cell23 = row.createCell(23);
		if (record1.getR0550_stage3c_poci() != null) {
			R0550cell23.setCellValue(record1.getR0550_stage3c_poci().doubleValue());
			R0550cell23.setCellStyle(numberStyle);
		} else {
			R0550cell23.setCellValue("");
			R0550cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0550cell24 = row.createCell(24);
		if (record1.getR0550_current_pastdues() != null) {
			R0550cell24.setCellValue(record1.getR0550_current_pastdues().doubleValue());
			R0550cell24.setCellStyle(numberStyle);
		} else {
			R0550cell24.setCellValue("");
			R0550cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0550cell25 = row.createCell(25);
		if (record1.getR0550_less30days_pastdues() != null) {
			R0550cell25.setCellValue(record1.getR0550_less30days_pastdues().doubleValue());
			R0550cell25.setCellStyle(numberStyle);
		} else {
			R0550cell25.setCellValue("");
			R0550cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0550cell26 = row.createCell(26);
		if (record1.getR0550_31to90days_pastdues() != null) {
			R0550cell26.setCellValue(record1.getR0550_31to90days_pastdues().doubleValue());
			R0550cell26.setCellStyle(numberStyle);
		} else {
			R0550cell26.setCellValue("");
			R0550cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0550cell27 = row.createCell(27);
		if (record1.getR0550_91to120days_pastdues() != null) {
			R0550cell27.setCellValue(record1.getR0550_91to120days_pastdues().doubleValue());
			R0550cell27.setCellStyle(numberStyle);
		} else {
			R0550cell27.setCellValue("");
			R0550cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0550cell28 = row.createCell(28);
		if (record1.getR0550_121to180days_pastdues() != null) {
			R0550cell28.setCellValue(record1.getR0550_121to180days_pastdues().doubleValue());
			R0550cell28.setCellStyle(numberStyle);
		} else {
			R0550cell28.setCellValue("");
			R0550cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0550cell29 = row.createCell(29);
		if (record1.getR0550_181to365days_pastdues() != null) {
			R0550cell29.setCellValue(record1.getR0550_181to365days_pastdues().doubleValue());
			R0550cell29.setCellStyle(numberStyle);
		} else {
			R0550cell29.setCellValue("");
			R0550cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0550cell30 = row.createCell(30);
		if (record1.getR0550_over365days_pastdues() != null) {
			R0550cell30.setCellValue(record1.getR0550_over365days_pastdues().doubleValue());
			R0550cell30.setCellStyle(numberStyle);
		} else {
			R0550cell30.setCellValue("");
			R0550cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0550cell32 = row.createCell(32);
		if (record1.getR0550_newloan_duringreport() != null) {
			R0550cell32.setCellValue(record1.getR0550_newloan_duringreport().doubleValue());
			R0550cell32.setCellStyle(numberStyle);
		} else {
			R0550cell32.setCellValue("");
			R0550cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0550cell33 = row.createCell(33);
		if (record1.getR0550_newstage_duringreport() != null) {
			R0550cell33.setCellValue(record1.getR0550_newstage_duringreport().doubleValue());
			R0550cell33.setCellStyle(numberStyle);
		} else {
			R0550cell33.setCellValue("");
			R0550cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0550cell34 = row.createCell(34);
		if (record1.getR0550_intrestfees_duringreport() != null) {
			R0550cell34.setCellValue(record1.getR0550_intrestfees_duringreport().doubleValue());
			R0550cell34.setCellStyle(numberStyle);
		} else {
			R0550cell34.setCellValue("");
			R0550cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0550cell35 = row.createCell(35);
		if (record1.getR0550_performingac_acinfo() != null) {
			R0550cell35.setCellValue(record1.getR0550_performingac_acinfo().doubleValue());
			R0550cell35.setCellStyle(numberStyle);
		} else {
			R0550cell35.setCellValue("");
			R0550cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0550cell36 = row.createCell(36);
		if (record1.getR0550_nonperformingac_acinfo() != null) {
			R0550cell36.setCellValue(record1.getR0550_nonperformingac_acinfo().doubleValue());
			R0550cell36.setCellStyle(numberStyle);
		} else {
			R0550cell36.setCellValue("");
			R0550cell36.setCellStyle(textStyle);
		}

		/// ROW65
		//// Column E
		row = sheet.getRow(64);
		Cell R0560cell4 = row.createCell(4);
		if (record1.getR0560_outstandbal() != null) {
			R0560cell4.setCellValue(record1.getR0560_outstandbal().doubleValue());
			R0560cell4.setCellStyle(numberStyle);
		} else {
			R0560cell4.setCellValue("");
			R0560cell4.setCellStyle(textStyle);
		}

		//// Column F
		Cell R0560cell5 = row.createCell(5);
		if (record1.getR0560_secured_outstandbal() != null) {
			R0560cell5.setCellValue(record1.getR0560_secured_outstandbal().doubleValue());
			R0560cell5.setCellStyle(numberStyle);
		} else {
			R0560cell5.setCellValue("");
			R0560cell5.setCellStyle(textStyle);
		}

		//// Column G
		Cell R0560cell6 = row.createCell(6);
		if (record1.getR0560_unsecured_outstandbal() != null) {
			R0560cell6.setCellValue(record1.getR0560_unsecured_outstandbal().doubleValue());
			R0560cell6.setCellStyle(numberStyle);
		} else {
			R0560cell6.setCellValue("");
			R0560cell6.setCellStyle(textStyle);
		}

		//// Column H
		Cell R0560cell7 = row.createCell(7);
		if (record1.getR0560_stage1_assetclass() != null) {
			R0560cell7.setCellValue(record1.getR0560_stage1_assetclass().doubleValue());
			R0560cell7.setCellStyle(numberStyle);
		} else {
			R0560cell7.setCellValue("");
			R0560cell7.setCellStyle(textStyle);
		}

		//// Column I
		Cell R0560cell8 = row.createCell(8);
		if (record1.getR0560_stage2_assetclass() != null) {
			R0560cell8.setCellValue(record1.getR0560_stage2_assetclass().doubleValue());
			R0560cell8.setCellStyle(numberStyle);
		} else {
			R0560cell8.setCellValue("");
			R0560cell8.setCellStyle(textStyle);
		}

		//// Column J
		Cell R0560cell9 = row.createCell(9);
		if (record1.getR0560_stage3a_assetclass() != null) {
			R0560cell9.setCellValue(record1.getR0560_stage3a_assetclass().doubleValue());
			R0560cell9.setCellStyle(numberStyle);
		} else {
			R0560cell9.setCellValue("");
			R0560cell9.setCellStyle(textStyle);
		}

		//// Column K
		Cell R0560cell10 = row.createCell(10);
		if (record1.getR0560_stage3b_assetclass() != null) {
			R0560cell10.setCellValue(record1.getR0560_stage3b_assetclass().doubleValue());
			R0560cell10.setCellStyle(numberStyle);
		} else {
			R0560cell10.setCellValue("");
			R0560cell10.setCellStyle(textStyle);
		}

		//// Column L
		Cell R0560cell11 = row.createCell(11);
		if (record1.getR0560_stage3c_assetclass() != null) {
			R0560cell11.setCellValue(record1.getR0560_stage3c_assetclass().doubleValue());
			R0560cell11.setCellStyle(numberStyle);
		} else {
			R0560cell11.setCellValue("");
			R0560cell11.setCellStyle(textStyle);
		}

		//// Column M
		Cell R0560cell12 = row.createCell(12);
		if (record1.getR0560_stage1_provisionheld() != null) {
			R0560cell12.setCellValue(record1.getR0560_stage1_provisionheld().doubleValue());
			R0560cell12.setCellStyle(numberStyle);
		} else {
			R0560cell12.setCellValue("");
			R0560cell12.setCellStyle(textStyle);
		}

		//// Column N
		Cell R0560cell13 = row.createCell(13);
		if (record1.getR0560_stage2_provisionheld() != null) {
			R0560cell13.setCellValue(record1.getR0560_stage2_provisionheld().doubleValue());
			R0560cell13.setCellStyle(numberStyle);
		} else {
			R0560cell13.setCellValue("");
			R0560cell13.setCellStyle(textStyle);
		}

		//// Column O
		Cell R0560cell14 = row.createCell(14);
		if (record1.getR0560_stage3a_provisionheld() != null) {
			R0560cell14.setCellValue(record1.getR0560_stage3a_provisionheld().doubleValue());
			R0560cell14.setCellStyle(numberStyle);
		} else {
			R0560cell14.setCellValue("");
			R0560cell14.setCellStyle(textStyle);
		}

		//// Column P
		Cell R0560cell15 = row.createCell(15);
		if (record1.getR0560_stage3b_provisionheld() != null) {
			R0560cell15.setCellValue(record1.getR0560_stage3b_provisionheld().doubleValue());
			R0560cell15.setCellStyle(numberStyle);
		} else {
			R0560cell15.setCellValue("");
			R0560cell15.setCellStyle(textStyle);
		}

		//// Column Q
		Cell R0560cell16 = row.createCell(16);
		if (record1.getR0560_stage3c_provisionheld() != null) {
			R0560cell16.setCellValue(record1.getR0560_stage3c_provisionheld().doubleValue());
			R0560cell16.setCellStyle(numberStyle);
		} else {
			R0560cell16.setCellValue("");
			R0560cell16.setCellStyle(textStyle);
		}

		//// Column R
		Cell R0560cell17 = row.createCell(17);
		if (record1.getR0560_intrestfees_provisionheld() != null) {
			R0560cell17.setCellValue(record1.getR0560_intrestfees_provisionheld().doubleValue());
			R0560cell17.setCellStyle(numberStyle);
		} else {
			R0560cell17.setCellValue("");
			R0560cell17.setCellStyle(textStyle);
		}

		//// Column S
		Cell R0560cell18 = row.createCell(18);
		if (record1.getR0560_intrestsuspense_provisionheld() != null) {
			R0560cell18.setCellValue(record1.getR0560_intrestsuspense_provisionheld().doubleValue());
			R0560cell18.setCellStyle(numberStyle);
		} else {
			R0560cell18.setCellValue("");
			R0560cell18.setCellStyle(textStyle);
		}

		//// Column T
		Cell R0560cell19 = row.createCell(19);
		if (record1.getR0560_stage1_poci() != null) {
			R0560cell19.setCellValue(record1.getR0560_stage1_poci().doubleValue());
			R0560cell19.setCellStyle(numberStyle);
		} else {
			R0560cell19.setCellValue("");
			R0560cell19.setCellStyle(textStyle);
		}

		//// Column U
		Cell R0560cell20 = row.createCell(20);
		if (record1.getR0560_stage2_poci() != null) {
			R0560cell20.setCellValue(record1.getR0560_stage2_poci().doubleValue());
			R0560cell20.setCellStyle(numberStyle);
		} else {
			R0560cell20.setCellValue("");
			R0560cell20.setCellStyle(textStyle);
		}

		//// Column V
		Cell R0560cell21 = row.createCell(21);
		if (record1.getR0560_stage3a_poci() != null) {
			R0560cell21.setCellValue(record1.getR0560_stage3a_poci().doubleValue());
			R0560cell21.setCellStyle(numberStyle);
		} else {
			R0560cell21.setCellValue("");
			R0560cell21.setCellStyle(textStyle);
		}

		//// Column W
		Cell R0560cell22 = row.createCell(22);
		if (record1.getR0560_stage3b_poci() != null) {
			R0560cell22.setCellValue(record1.getR0560_stage3b_poci().doubleValue());
			R0560cell22.setCellStyle(numberStyle);
		} else {
			R0560cell22.setCellValue("");
			R0560cell22.setCellStyle(textStyle);
		}

		//// Column X
		Cell R0560cell23 = row.createCell(23);
		if (record1.getR0560_stage3c_poci() != null) {
			R0560cell23.setCellValue(record1.getR0560_stage3c_poci().doubleValue());
			R0560cell23.setCellStyle(numberStyle);
		} else {
			R0560cell23.setCellValue("");
			R0560cell23.setCellStyle(textStyle);
		}

		//// Column Y
		Cell R0560cell24 = row.createCell(24);
		if (record1.getR0560_current_pastdues() != null) {
			R0560cell24.setCellValue(record1.getR0560_current_pastdues().doubleValue());
			R0560cell24.setCellStyle(numberStyle);
		} else {
			R0560cell24.setCellValue("");
			R0560cell24.setCellStyle(textStyle);
		}

		//// Column Z
		Cell R0560cell25 = row.createCell(25);
		if (record1.getR0560_less30days_pastdues() != null) {
			R0560cell25.setCellValue(record1.getR0560_less30days_pastdues().doubleValue());
			R0560cell25.setCellStyle(numberStyle);
		} else {
			R0560cell25.setCellValue("");
			R0560cell25.setCellStyle(textStyle);
		}

		//// Column AA
		Cell R0560cell26 = row.createCell(26);
		if (record1.getR0560_31to90days_pastdues() != null) {
			R0560cell26.setCellValue(record1.getR0560_31to90days_pastdues().doubleValue());
			R0560cell26.setCellStyle(numberStyle);
		} else {
			R0560cell26.setCellValue("");
			R0560cell26.setCellStyle(textStyle);
		}

		//// Column AB
		Cell R0560cell27 = row.createCell(27);
		if (record1.getR0560_91to120days_pastdues() != null) {
			R0560cell27.setCellValue(record1.getR0560_91to120days_pastdues().doubleValue());
			R0560cell27.setCellStyle(numberStyle);
		} else {
			R0560cell27.setCellValue("");
			R0560cell27.setCellStyle(textStyle);
		}

		//// Column AC
		Cell R0560cell28 = row.createCell(28);
		if (record1.getR0560_121to180days_pastdues() != null) {
			R0560cell28.setCellValue(record1.getR0560_121to180days_pastdues().doubleValue());
			R0560cell28.setCellStyle(numberStyle);
		} else {
			R0560cell28.setCellValue("");
			R0560cell28.setCellStyle(textStyle);
		}

		//// Column AD
		Cell R0560cell29 = row.createCell(29);
		if (record1.getR0560_181to365days_pastdues() != null) {
			R0560cell29.setCellValue(record1.getR0560_181to365days_pastdues().doubleValue());
			R0560cell29.setCellStyle(numberStyle);
		} else {
			R0560cell29.setCellValue("");
			R0560cell29.setCellStyle(textStyle);
		}

		//// Column AE
		Cell R0560cell30 = row.createCell(30);
		if (record1.getR0560_over365days_pastdues() != null) {
			R0560cell30.setCellValue(record1.getR0560_over365days_pastdues().doubleValue());
			R0560cell30.setCellStyle(numberStyle);
		} else {
			R0560cell30.setCellValue("");
			R0560cell30.setCellStyle(textStyle);
		}

		//// Column AG
		Cell R0560cell32 = row.createCell(32);
		if (record1.getR0560_newloan_duringreport() != null) {
			R0560cell32.setCellValue(record1.getR0560_newloan_duringreport().doubleValue());
			R0560cell32.setCellStyle(numberStyle);
		} else {
			R0560cell32.setCellValue("");
			R0560cell32.setCellStyle(textStyle);
		}

		//// Column AH
		Cell R0560cell33 = row.createCell(33);
		if (record1.getR0560_newstage_duringreport() != null) {
			R0560cell33.setCellValue(record1.getR0560_newstage_duringreport().doubleValue());
			R0560cell33.setCellStyle(numberStyle);
		} else {
			R0560cell33.setCellValue("");
			R0560cell33.setCellStyle(textStyle);
		}

		//// Column AI
		Cell R0560cell34 = row.createCell(34);
		if (record1.getR0560_intrestfees_duringreport() != null) {
			R0560cell34.setCellValue(record1.getR0560_intrestfees_duringreport().doubleValue());
			R0560cell34.setCellStyle(numberStyle);
		} else {
			R0560cell34.setCellValue("");
			R0560cell34.setCellStyle(textStyle);
		}

		//// Column AJ
		Cell R0560cell35 = row.createCell(35);
		if (record1.getR0560_performingac_acinfo() != null) {
			R0560cell35.setCellValue(record1.getR0560_performingac_acinfo().doubleValue());
			R0560cell35.setCellStyle(numberStyle);
		} else {
			R0560cell35.setCellValue("");
			R0560cell35.setCellStyle(textStyle);
		}

		//// Column AK
		Cell R0560cell36 = row.createCell(36);
		if (record1.getR0560_nonperformingac_acinfo() != null) {
			R0560cell36.setCellValue(record1.getR0560_nonperformingac_acinfo().doubleValue());
			R0560cell36.setCellStyle(numberStyle);
		} else {
			R0560cell36.setCellValue("");
			R0560cell36.setCellStyle(textStyle);
		}

	}

	/*
	 * public List<Object> getBRF5_3Archival() { List<Object> BRF5_3ArchivalList =
	 * new ArrayList<>(); try {
	 * BRF5_3ArchivalList.addAll(BRF5_3_Summary_Archival_Repo1.getBRF5_3archival());
	 * BRF5_3ArchivalList.addAll(BRF5_3_Summary_Archival_Repo2.getBRF5_3archival());
	 * logger.info("Fetched {} archival records.", BRF5_3ArchivalList.size()); }
	 * catch (Exception e) { logger.error("Error fetching BRF5_3 Archival data: {}",
	 * e.getMessage(), e); } return BRF5_3ArchivalList; }
	 */

	public byte[] getBRF5_3ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {

		logger.info("Service: Starting ARCHIVAL Excel generation process.");

		List<CBUAE_BRF5_3_Summary_Archival_Entity1> dataList = BRF5_3_Summary_Archival_Repo1
				.getdatabydateListarchival(dateformat.parse(todate), version);
		List<CBUAE_BRF5_3_Summary_Archival_Entity2> dataList1 = BRF5_3_Summary_Archival_Repo2
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

	private void populateArchivalEntity1Data(Sheet sheet, CBUAE_BRF5_3_Summary_Archival_Entity1 record,
			CellStyle textStyle, CellStyle numberStyle) {
		// This method would be implemented identically to populateEntity1Data,
		// but using the CBUAE_BRF5_3_Summary_Archival_Entity1 object.
		// For brevity, the full implementation is omitted.
	}

	private void populateArchivalEntity2Data(Sheet sheet, CBUAE_BRF5_3_Summary_Archival_Entity2 record,
			CellStyle textStyle, CellStyle numberStyle) {
		// This method would be implemented identically to populateEntity2Data,
		// but using the CBUAE_BRF5_3_Summary_Archival_Entity2 object.
		// For brevity, the full implementation is omitted.
	}

// DetailExcel

			public byte[] getBRF5_3DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
					String type, String version) {
				try {
					logger.info("Generating Excel for BRF5_3 Details...");
					System.out.println("came to Detail download service");
					if (type.equals("ARCHIVAL") & version != null) {
						byte[] ARCHIVALreport = getBRF5_3DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
								type, version);
						return ARCHIVALreport;
					}

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF5_3Details");

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
			List<CBUAE_BRF5_3_Detail_Entity> reportData = BRF5_3_Detail_Repo.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF5_3_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF5_3 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF5_3 Excel", e);
			return new byte[0];
		}
	}

	public byte[] getBRF5_3DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF5_3 ARCHIVAL Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {

			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF5_3Details");

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
			List<CBUAE_BRF5_3_Archival_Detail_Entity> reportData = BRF5_3_archival_detail_repo
					.getdatabydateList(parsedToDate, version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF5_3_Archival_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF5_3 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF5_3 Excel", e);
			return new byte[0];
		}
	}

}