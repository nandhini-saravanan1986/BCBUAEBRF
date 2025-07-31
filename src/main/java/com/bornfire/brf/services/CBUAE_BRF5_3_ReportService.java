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
import com.bornfire.brf.entities.CBUAE_BRF5_3_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Archival_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Archival_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF5_3_Summary_Entity2;
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
		} else {
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
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();
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

					T1Dt1 = BRF5_3_archival_detail_repo.getdatabydateList(dateformat.parse(todate), version);
					System.out.println("countavd" + T1Dt1.size());
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
					T1Dt1 = BRF5_3_Detail_Repo.GetDataByRowIdAndColumnId(rowId, columnId, d1);
				} else {
					T1Dt1 = BRF5_3_Detail_Repo.getdatabydateList(d1);
				}

				System.out.println("LISTCOUNT: " + T1Dt1.size());

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		mv.setViewName("BRF/BRF5_3");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
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
			logger.warn("Service: No data found for BRF5.2 report. Returning empty result.");
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
					CBUAE_BRF5_3_Summary_Entity1 record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

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

	public List<Object> getBRF5_3Archival() {
		List<Object> BRF5_3Archivallist = new ArrayList<>();
		try {
			BRF5_3Archivallist = BRF5_3_Summary_Archival_Repo1.getBRF5_3archival();
			BRF5_3Archivallist = BRF5_3_Summary_Archival_Repo2.getBRF5_3archival();
			System.out.println("countser" + BRF5_3Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF5_3 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF5_3Archivallist;
	}

	public byte[] getBRF5_3ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate,
			String currency, String dtltype, String type, String version) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		if (type.equals("ARCHIVAL") & version != null) {

		}
		List<CBUAE_BRF5_3_Summary_Archival_Entity1> dataList = BRF5_3_Summary_Archival_Repo1
				.getdatabydateListarchival(dateformat.parse(todate), version);
		List<CBUAE_BRF5_3_Summary_Archival_Entity2> dataList1 = BRF5_3_Summary_Archival_Repo2
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
					CBUAE_BRF5_3_Summary_Archival_Entity1 record = dataList.get(i);
					System.out.println("rownumber=" + startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
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
