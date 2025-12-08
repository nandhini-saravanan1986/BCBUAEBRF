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

import com.bornfire.brf.entities.CBUAE_BRF2_1_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_1__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_1_Archival_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_1_Archival_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_1_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_1_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_1_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_1_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_1__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF2_1__Archival_Detail_Repo;

@Component
@Service

public class CBUAE_BRF2_1_ReportService {
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_1_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF2_1_Detail_Repo BRF2_1_DETAIL_Repo;

	@Autowired
	CBUAE_BRF2_1_Summary_Repo BRF2_1_Summary_Repo;

	@Autowired
	CBUAE_BRF2_1__Archival_Detail_Repo BRF2_1_archival_detail_repo;

	@Autowired
	CBUAE_BRF2_1_Archival_Summary_Repo BRF2_1_Archival_Summary_Repo;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF2_1View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF2_1_Archival_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_1_Archival_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = BRF2_1_Archival_Summary_Repo.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}

		else {

			List<CBUAE_BRF2_1_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF2_1_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				// T1Master = hs.createQuery("from BRF1_REPORT_ENTITY a where a.report_date = ?1
				// ", BRF1_REPORT_ENTITY.class)
				// .setParameter(1, df.parse(todate)).getResultList();
				T1Master = BRF2_1_Summary_Repo.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF2_1");

		// mv.addObject("reportsummary", T1Master);
		// mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		// mv.addObject("reportsflag", "reportsflag");
		// mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF2_1currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter, String type, String version) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int totalPages=0;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();

		if (type.equals("ARCHIVAL") & version != null) {
			List<CBUAE_BRF2_1__Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF2_1__Archival_Detail_Entity>();
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
					T1Dt1 = BRF2_1_archival_detail_repo.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate),
							version);

					System.out.println("countavd" + T1Dt1.size());
				} else {

					T1Dt1 = BRF2_1_archival_detail_repo.getdatabydateList(dateformat.parse(todate), version);
					System.out.println("countavd" + T1Dt1.size());
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		} else {
			List<CBUAE_BRF2_1_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF2_1_Detail_Entity>();
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
					T1Dt1 = BRF2_1_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
				} else {
					T1Dt1 = BRF2_1_DETAIL_Repo.getdatabydateList(dateformat.parse(todate),currentPage,pageSize);
					totalPages=BRF2_1_DETAIL_Repo.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination","YES");
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);
				System.out.println("LISTCOUNT" + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		// Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist,
		// PageRequest.of(currentPage, pageSize), T1Dt1.size());
		mv.setViewName("BRF/BRF2_1");
		mv.addObject("displaymode", "Details");
		mv.addObject("currentPage", currentPage);
		//System.out.println("totalPages"+totalPages);
   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
		// mv.addObject("reportdetails", T1Dt1Page.getContent());

		// mv.addObject("reportmaster1", qr);
		// mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<Object> getBRF2_1Archival() {
		List<Object> BRF2_1Archivallist = new ArrayList<>();
		try {
			BRF2_1Archivallist = BRF2_1_Archival_Summary_Repo.getbrf2_1archival();
			System.out.println("countser" + BRF2_1Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF2_1 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF2_1Archivallist;
	}

	public byte[] getBRF2_1Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF2_1ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,
					type, version);
			return ARCHIVALreport;
		}
		List<CBUAE_BRF2_1_Summary_Entity> dataList = BRF2_1_Summary_Repo.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.1 report. Returning empty result.");
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

			int startRow = 9;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF2_1_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					// row10
					// Column E
					Cell cell4 = row.createCell(4);
					if (record.getR0020_amount() != null) {
						cell4.setCellValue(record.getR0020_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row11
					row = sheet.getRow(10);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0030_amount() != null) {
						cell4.setCellValue(record.getR0030_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row12
					row = sheet.getRow(11);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0040_amount() != null) {
						cell4.setCellValue(record.getR0040_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row13
					row = sheet.getRow(12);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0050_amount() != null) {
						cell4.setCellValue(record.getR0050_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row14
					row = sheet.getRow(13);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0060_amount() != null) {
						cell4.setCellValue(record.getR0060_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row15
					row = sheet.getRow(14);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0070_amount() != null) {
						cell4.setCellValue(record.getR0070_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row16
					row = sheet.getRow(15);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0080_amount() != null) {
						cell4.setCellValue(record.getR0080_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row19
					row = sheet.getRow(18);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0110_amount() != null) {
						cell4.setCellValue(record.getR0110_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row20
					row = sheet.getRow(19);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0120_amount() != null) {
						cell4.setCellValue(record.getR0120_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row21
					row = sheet.getRow(20);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0130_amount() != null) {
						cell4.setCellValue(record.getR0130_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row22
					row = sheet.getRow(21);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0140_amount() != null) {
						cell4.setCellValue(record.getR0140_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row24
					row = sheet.getRow(23);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0160_amount() != null) {
						cell4.setCellValue(record.getR0160_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row25
					row = sheet.getRow(24);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0170_amount() != null) {
						cell4.setCellValue(record.getR0170_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row29
					row = sheet.getRow(28);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0210_amount() != null) {
						cell4.setCellValue(record.getR0210_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row30
					row = sheet.getRow(29);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0220_amount() != null) {
						cell4.setCellValue(record.getR0220_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row31
					row = sheet.getRow(30);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0230_amount() != null) {
						cell4.setCellValue(record.getR0230_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row32
					row = sheet.getRow(31);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0240_amount() != null) {
						cell4.setCellValue(record.getR0240_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row33
					row = sheet.getRow(32);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0250_amount() != null) {
						cell4.setCellValue(record.getR0250_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row34
					row = sheet.getRow(33);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0260_amount() != null) {
						cell4.setCellValue(record.getR0260_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row35
					row = sheet.getRow(34);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0270_amount() != null) {
						cell4.setCellValue(record.getR0270_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row36
					row = sheet.getRow(35);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0280_amount() != null) {
						cell4.setCellValue(record.getR0280_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row37
					row = sheet.getRow(36);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0290_amount() != null) {
						cell4.setCellValue(record.getR0290_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
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

	public byte[] getBRF2_1ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Archival Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		List<CBUAE_BRF2_1_Archival_Summary_Entity> dataList = BRF2_1_Archival_Summary_Repo
				.getdatabydateListarchival(dateformat.parse(todate), version);
		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF1.3 report. Returning empty result.");
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

			int startRow = 9;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF2_1_Archival_Summary_Entity record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

					// row10
					// Column E
					Cell cell4 = row.createCell(4);
					if (record.getR0020_amount() != null) {
						cell4.setCellValue(record.getR0020_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row11
					row = sheet.getRow(10);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0030_amount() != null) {
						cell4.setCellValue(record.getR0030_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row12
					row = sheet.getRow(11);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0040_amount() != null) {
						cell4.setCellValue(record.getR0040_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row13
					row = sheet.getRow(12);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0050_amount() != null) {
						cell4.setCellValue(record.getR0050_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row14
					row = sheet.getRow(13);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0060_amount() != null) {
						cell4.setCellValue(record.getR0060_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row15
					row = sheet.getRow(14);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0070_amount() != null) {
						cell4.setCellValue(record.getR0070_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row16
					row = sheet.getRow(15);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0080_amount() != null) {
						cell4.setCellValue(record.getR0080_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row19
					row = sheet.getRow(18);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0110_amount() != null) {
						cell4.setCellValue(record.getR0110_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row20
					row = sheet.getRow(19);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0120_amount() != null) {
						cell4.setCellValue(record.getR0120_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row21
					row = sheet.getRow(20);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0130_amount() != null) {
						cell4.setCellValue(record.getR0130_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row22
					row = sheet.getRow(21);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0140_amount() != null) {
						cell4.setCellValue(record.getR0140_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row24
					row = sheet.getRow(23);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0160_amount() != null) {
						cell4.setCellValue(record.getR0160_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row25
					row = sheet.getRow(24);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0170_amount() != null) {
						cell4.setCellValue(record.getR0170_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row29
					row = sheet.getRow(28);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0210_amount() != null) {
						cell4.setCellValue(record.getR0210_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row30
					row = sheet.getRow(29);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0220_amount() != null) {
						cell4.setCellValue(record.getR0220_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row31
					row = sheet.getRow(30);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0230_amount() != null) {
						cell4.setCellValue(record.getR0230_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row32
					row = sheet.getRow(31);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0240_amount() != null) {
						cell4.setCellValue(record.getR0240_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row33
					row = sheet.getRow(32);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0250_amount() != null) {
						cell4.setCellValue(record.getR0250_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row34
					row = sheet.getRow(33);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0260_amount() != null) {
						cell4.setCellValue(record.getR0260_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row35
					row = sheet.getRow(34);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0270_amount() != null) {
						cell4.setCellValue(record.getR0270_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row36
					row = sheet.getRow(35);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0280_amount() != null) {
						cell4.setCellValue(record.getR0280_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
					}

					// row37
					row = sheet.getRow(36);

					// Column E
					cell4 = row.createCell(4);
					if (record.getR0290_amount() != null) {
						cell4.setCellValue(record.getR0290_amount().doubleValue());
						cell4.setCellStyle(numberStyle);
					} else {
						cell4.setCellValue("");
						cell4.setCellStyle(textStyle);
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

	public byte[] getBRF2_1DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		try {
			logger.info("Generating Excel for BRF2_1 Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {
				byte[] ARCHIVALreport = getBRF2_1DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
						type, version);
				return ARCHIVALreport;
			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF2_1Details");

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
			List<CBUAE_BRF2_1_Detail_Entity> reportData = BRF2_1_DETAIL_Repo.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF2_1_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF2_1 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF2_1 Excel", e);
			return new byte[0];
		}
	}

	public byte[] getBRF2_1DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {
		try {
			logger.info("Generating Excel for BRF2_1 ARCHIVAL Details...");
			System.out.println("came to Detail download service");
			if (type.equals("ARCHIVAL") & version != null) {

			}
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF2_1Details");

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
			List<CBUAE_BRF2_1__Archival_Detail_Entity> reportData = BRF2_1_archival_detail_repo
					.getdatabydateList(parsedToDate, version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF2_1__Archival_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF2_1 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF2_1 Excel", e);
			return new byte[0];
		}
	}
	
	 public ModelAndView getViewOrEditPage(String custId, String acctNo, String formMode) {

		    ModelAndView mv = new ModelAndView("BRF/BRF2_1");

		    // Load data using acctNo (NOT custId)
		    if (acctNo != null && !acctNo.isEmpty()) {

		    	CBUAE_BRF2_1_Detail_Entity brf2_1Entity =
		    			BRF2_1_DETAIL_Repo.findByAcctNumber(acctNo);

		        if (brf2_1Entity != null && brf2_1Entity.getReportDate() != null) {
		            String formattedDate =
		                    new SimpleDateFormat("dd/MM/yyyy").format(brf2_1Entity.getReportDate());
		            mv.addObject("asondate", formattedDate);
		        }

		        mv.addObject("BRF2_1", brf2_1Entity);
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

				CBUAE_BRF2_1_Detail_Entity existing = BRF2_1_DETAIL_Repo.findByAcctNumber(acctNo);
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
					BRF2_1_DETAIL_Repo.save(existing);
					logger.info("Record updated successfully for account {}", acctNo);

					// Format date for procedure
					String formattedDate = new SimpleDateFormat("dd-MM-yyyy")
							.format(new SimpleDateFormat("yyyy-MM-dd").parse(reportDateStr));

					// Run summary procedure after commit
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							try {
								logger.info("Transaction committed — calling CBUAE_BRF2_1_SUMMARY_PROCEDURE({})",
										formattedDate);
								jdbcTemplate.update("BEGIN CBUAE_BRF2_1_SUMMARY_PROCEDURE(?); END;", formattedDate);
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
				logger.error("Error updating BRF2_1 record", e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Error updating record: " + e.getMessage());
			}
		}
}
