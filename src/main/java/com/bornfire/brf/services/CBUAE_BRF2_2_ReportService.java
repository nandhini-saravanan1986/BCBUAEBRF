package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF1_12_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_3__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_2_Archival_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_2_Archival_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_2_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_2_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_2_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_2_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_2__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_2__Archival_Detail_Repo;

@Component
@Service

public class CBUAE_BRF2_2_ReportService {
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_2_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF2_2_Detail_Repo BRF2_2_DETAIL_Repo;

	@Autowired
	CBUAE_BRF2_2_Summary_Repo BRF2_2_Summary_Repo;

	@Autowired
	CBUAE_BRF2_2__Archival_Detail_Repo BRF2_2_archival_detail_repo;

	@Autowired
	CBUAE_BRF2_2_Archival_Summary_Repo BRF2_2_Archival_Summary_Repo;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF2_2View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF2_2_Archival_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_2_Archival_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF2_2_Archival_Summary_Repo.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}

		else {
			List<CBUAE_BRF2_2_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_2_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);
				T1Master = BRF2_2_Summary_Repo.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}
		mv.setViewName("BRF/BRF2_2");

		// mv.addObject("reportsummary", T1Master);
		// mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		// mv.addObject("reportsflag", "reportsflag");
		// mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF2_2currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int totalPages=0;

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF2_2__Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF2_2__Archival_Detail_Entity>();
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
					T1Dt1 = BRF2_2_archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId,
							dateformat.parse(todate), version);

					System.out.println("countavd" + T1Dt1.size());
				} else {

					T1Dt1 = BRF2_2_archival_detail_repo.getdatabydateList(dateformat.parse(todate), version);
					System.out.println("countavd" + T1Dt1.size());
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println(type);
			List<CBUAE_BRF2_2_Detail_Entity> T1Dt1 = new ArrayList<>();

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
					T1Dt1 = BRF2_2_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
					System.out.println("came to services");
				} else {
					T1Dt1 = BRF2_2_DETAIL_Repo.getdatabydateList(d1,currentPage,pageSize);
					totalPages=BRF2_2_DETAIL_Repo.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination","YES");
				}
				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);
				System.out.println("LISTCOUNT: " + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("BRF/BRF2_2");
		mv.addObject("displaymode", "Details");
		 mv.addObject("currentPage", currentPage);
	   	  	System.out.println("totalPages"+(int)Math.ceil((double)totalPages / 100));
	   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
		// mv.addObject("reportdetails", T1Dt1);
		// mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<Object> getBRF2_2Archival() {
		List<Object> BRF2_2Archivallist = new ArrayList<>();
		try {
			BRF2_2Archivallist = BRF2_2_Archival_Summary_Repo.getbrf2_2archival();
			System.out.println("countser" + BRF2_2Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF2_2 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF2_2Archivallist;
	}

	public byte[] getBRF2_2Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF2_2ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}
		List<CBUAE_BRF2_2_Summary_Entity> dataList = BRF2_2_Summary_Repo.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.2 report. Returning empty result.");
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

			int startRow = 10;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF2_2_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					// row11
					// Column E
					Cell cell4 = row.createCell(4);
					if (record.getR0020_nominal_amount() != null) {
						cell4.setCellValue(record.getR0020_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row12
					row = sheet.getRow(11);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0030_nominal_amount() != null) {
						cell4.setCellValue(record.getR0030_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row13
					row = sheet.getRow(12);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0040_nominal_amount() != null) {
						cell4.setCellValue(record.getR0040_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row14
					row = sheet.getRow(13);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0050_nominal_amount() != null) {
						cell4.setCellValue(record.getR0050_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row15
					row = sheet.getRow(14);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0060_nominal_amount() != null) {
						cell4.setCellValue(record.getR0060_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row17
					row = sheet.getRow(16);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0080_nominal_amount() != null) {
						cell4.setCellValue(record.getR0080_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row18
					row = sheet.getRow(17);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0090_nominal_amount() != null) {
						cell4.setCellValue(record.getR0090_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row19
					row = sheet.getRow(18);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0100_nominal_amount() != null) {
						cell4.setCellValue(record.getR0100_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row20
					row = sheet.getRow(19);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0110_nominal_amount() != null) {
						cell4.setCellValue(record.getR0110_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row22
					row = sheet.getRow(21);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0130_nominal_amount() != null) {
						cell4.setCellValue(record.getR0130_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row24
					row = sheet.getRow(23);

					// Column F
					Cell cell5 = row.createCell(5);
					if (record.getR0150_asset() != null) {
						cell5.setCellValue(record.getR0150_asset().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
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

	public byte[] getBRF2_2ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Archival Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		List<CBUAE_BRF2_2_Archival_Summary_Entity> dataList = BRF2_2_Archival_Summary_Repo
				.getdatabydateListarchival(dateformat.parse(todate), version);

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.2 report. Returning empty result.");
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

			int startRow = 10;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF2_2_Archival_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					// row11
					// Column E
					Cell cell4 = row.createCell(4);
					if (record.getR0020_nominal_amount() != null) {
						cell4.setCellValue(record.getR0020_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row12
					row = sheet.getRow(11);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0030_nominal_amount() != null) {
						cell4.setCellValue(record.getR0030_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row13
					row = sheet.getRow(12);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0040_nominal_amount() != null) {
						cell4.setCellValue(record.getR0040_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row14
					row = sheet.getRow(13);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0050_nominal_amount() != null) {
						cell4.setCellValue(record.getR0050_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row15
					row = sheet.getRow(14);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0060_nominal_amount() != null) {
						cell4.setCellValue(record.getR0060_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row17
					row = sheet.getRow(16);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0080_nominal_amount() != null) {
						cell4.setCellValue(record.getR0080_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row18
					row = sheet.getRow(17);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0090_nominal_amount() != null) {
						cell4.setCellValue(record.getR0090_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row19
					row = sheet.getRow(18);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0100_nominal_amount() != null) {
						cell4.setCellValue(record.getR0100_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row20
					row = sheet.getRow(19);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0110_nominal_amount() != null) {
						cell4.setCellValue(record.getR0110_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row22
					row = sheet.getRow(21);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0130_nominal_amount() != null) {
						cell4.setCellValue(record.getR0130_nominal_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row24
					row = sheet.getRow(23);

					// Column F
					Cell cell5 = row.createCell(5);
					if (record.getR0150_asset() != null) {
						cell5.setCellValue(record.getR0150_asset().doubleValue());
						cell5.setCellStyle(numberStyle);
					} else {
						cell5.setCellValue("");
						cell5.setCellStyle(textStyle);
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

	public byte[] getBRF2_2DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		try {
			logger.info("Generating Excel for BRF2_2 Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {
				byte[] ARCHIVALreport = getBRF2_2DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
						type, version);
				return ARCHIVALreport;
			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF2_2Details");

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
			List<CBUAE_BRF2_2_Detail_Entity> reportData = BRF2_2_DETAIL_Repo.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF2_2_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF2_2 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF2_2 Excel", e);
			return new byte[0];
		}
	}

	public byte[] getBRF2_2DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF2_2 ARCHIVAL Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {

			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF2_2Details");

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
			List<CBUAE_BRF2_2__Archival_Detail_Entity> reportData = BRF2_2_archival_detail_repo
					.getdatabydateList(parsedToDate, version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF2_2__Archival_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF2_2 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF2_2 Excel", e);
			return new byte[0];
		}
	}
	
	  public ModelAndView getViewOrEditPage(String custId, String acctNo, String formMode) {

		    ModelAndView mv = new ModelAndView("BRF/BRF2_2");

		    // Load data using acctNo (NOT custId)
		    if (acctNo != null && !acctNo.isEmpty()) {

		    	CBUAE_BRF2_2_Detail_Entity brf2_2Entity =
		    			BRF2_2_DETAIL_Repo.findByAcctNumber(acctNo);

		        if (brf2_2Entity != null && brf2_2Entity.getReportDate() != null) {
		            String formattedDate =
		                    new SimpleDateFormat("dd/MM/yyyy").format(brf2_2Entity.getReportDate());
		            mv.addObject("asondate", formattedDate);
		        }

		        mv.addObject("BRF2_2", brf2_2Entity);
		    }

		    mv.addObject("custId", custId);                      // keep if needed
		    mv.addObject("acctNo", acctNo);
		    mv.addObject("displaymode", "edit");
		    mv.addObject("formmode", (formMode != null ? formMode : "edit"));

		    return mv;
		}
	    
	    @Autowired
		private JdbcTemplate jdbcTemplate;
	    

	    @Transactional
		public ResponseEntity<?> updateDetailEdit(HttpServletRequest request) {
			try {
				
				  String custId = request.getParameter("custId");
				String acctNo = request.getParameter("acctNumber");
				String balanceStr = request.getParameter("acctBalanceInAed");
				String acctName = request.getParameter("acctName");
				String reportDateStr = request.getParameter("reportDate");

				logger.info("Received update for ACCT_NO: {}", acctNo);

				CBUAE_BRF2_2_Detail_Entity existing = BRF2_2_DETAIL_Repo.findByAcctNumber(acctNo);
				if (existing == null) {
					logger.warn("No record found for ACCT_NO: {}", acctNo);
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found for update.");
				}

				boolean isChanged = false;

				if (acctName != null && !acctName.isEmpty()) {
					if (existing.getAcctName() == null || !existing.getAcctName().equals(acctName)) {
						existing.setAcctName(acctName);
						isChanged = true;
						logger.info("Account name updated to {}", acctName);
					}
				}
				if (balanceStr != null && !balanceStr.isEmpty()) {
					BigDecimal newBalance = new BigDecimal(balanceStr);
					if (existing.getAcctBalanceInAed() == null
							|| existing.getAcctBalanceInAed().compareTo(newBalance) != 0) {
						existing.setAcctBalanceInAed(newBalance);
						isChanged = true;
						logger.info("Provision updated to {}", newBalance);
					}
				}

				if (isChanged) {
					BRF2_2_DETAIL_Repo.save(existing);
					logger.info("Record updated successfully for account {}", acctNo);

					// Format date for procedure
					String formattedDate = new SimpleDateFormat("dd-MM-yyyy")
							.format(new SimpleDateFormat("yyyy-MM-dd").parse(reportDateStr));

					// Run summary procedure after commit
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							try {
								logger.info("Transaction committed — calling CBUAE_BRF2_2_SUMMARY_PROCEDURE({})",
										formattedDate);
								jdbcTemplate.update("BEGIN CBUAE_BRF2_2_SUMMARY_PROCEDURE(?); END;", formattedDate);
								logger.info("Procedure executed successfully after commit.");
							} catch (Exception e) {
								logger.error("Error executing procedure after commit", e);
							}
						}
					});

					return ResponseEntity.ok("Record updated successfully!");
				} else {
					logger.info("No changes detected for ACCT_NO: {}", acctNo);
					return ResponseEntity.ok("No changes were made.");
				}

			} catch (Exception e) {
				logger.error("Error updating BRF2_2 record", e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Error updating record: " + e.getMessage());
			}
		}
}
