package com.bornfire.brf.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
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

import com.bornfire.brf.entities.CBUAE_BRF1_12_Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Archival_Summary_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Archival_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Archival_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF1_7__Archival_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Archival_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF1_7_Summary_Archival_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF1_7__Archival_Detail_Repo;

@Component
@Service

public class CBUAE_BRF1_7_ReportService {

	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_7_ReportService.class);

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CBUAE_BRF1_7_Detail_Repo CBUAE_BRF1_7_DETAIL_REPO;

	@Autowired
	CBUAE_BRF1_7_Summary_Repo1 CBUAE_BRF1_7_REPORT_REPO1;

	@Autowired
	CBUAE_BRF1_7_Summary_Repo2 CBUAE_BRF1_7_REPORT_REPO2;
	
	@Autowired
	CBUAE_BRF1_7_Summary_Archival_Repo1 CBUAE_BRF1_7_Summary_Archival_Repo1;
	
	@Autowired
	CBUAE_BRF1_7_Summary_Archival_Repo2 CBUAE_BRF1_7_Summary_Archival_Repo2;
	
	@Autowired
	CBUAE_BRF1_7__Archival_Detail_Repo CBUAE_BRF1_7__Archival_Detail_Repo;
	
	
	

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView getBRF1_7View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable, String type, String version) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		
		if (type.equals("ARCHIVAL") & version != null) {
			
			List<CBUAE_BRF1_7_Summary_Archival_Entity1> T1Master = new ArrayList<CBUAE_BRF1_7_Summary_Archival_Entity1>();
			List<CBUAE_BRF1_7_Summary_Archival_Entity2> T1Master1 = new ArrayList<CBUAE_BRF1_7_Summary_Archival_Entity2>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = CBUAE_BRF1_7_Summary_Archival_Repo1.getdatabydateListarchival(dateformat.parse(todate), version);
				T1Master1 = CBUAE_BRF1_7_Summary_Archival_Repo2.getdatabydateListarchival(dateformat.parse(todate), version);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
		}
		else {
			List<CBUAE_BRF1_7_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF1_7_Summary_Entity1>();
			List<CBUAE_BRF1_7_Summary_Entity2> T1Master1 = new ArrayList<CBUAE_BRF1_7_Summary_Entity2>();
			try {
				Date d1 = dateformat.parse(todate);

				T1Master = CBUAE_BRF1_7_REPORT_REPO1.getdatabydateList(dateformat.parse(todate));
				T1Master1 = CBUAE_BRF1_7_REPORT_REPO2.getdatabydateList(dateformat.parse(todate));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
		}
		
		

		mv.setViewName("BRF/BRF1_7");		
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF1_7currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter, String type, String version) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();
	    int totalPages=0;
	    ModelAndView mv = new ModelAndView();
	    
	    if (type.equals("ARCHIVAL") & version != null) {
			System.out.println(version);
			List<CBUAE_BRF1_7__Archival_Detail_Entity> T1Dt1 = new ArrayList<CBUAE_BRF1_7__Archival_Detail_Entity>();
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
					T1Dt1 = CBUAE_BRF1_7__Archival_Detail_Repo.GetDataByRowIdAndColumnId(rowId, columnId,
							dateformat.parse(todate), version);

					System.out.println("countavd" + T1Dt1.size());
				} else {
					T1Dt1 = CBUAE_BRF1_7__Archival_Detail_Repo.getdatabydateList(d1, version, currentPage, pageSize);
					totalPages = CBUAE_BRF1_7__Archival_Detail_Repo.getdatacount(dateformat.parse(todate), version);
					mv.addObject("pagination", "YES");
					System.out.println("countavd" + T1Dt1.size());
				}

				mv.addObject("reportdetails", T1Dt1);
				mv.addObject("reportmaster12", T1Dt1);

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	    else {
	    	List<CBUAE_BRF1_7_Detail_Entity> T1Dt1 = new ArrayList<>();

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
		        	T1Dt1 = CBUAE_BRF1_7_DETAIL_REPO.GetDataByRowIdAndColumnId(rowId, columnId, dateformat.parse(todate));
		        } else {
		           
		            T1Dt1 = CBUAE_BRF1_7_DETAIL_REPO.getdatabydateList(d1,currentPage,pageSize);
					totalPages=CBUAE_BRF1_7_DETAIL_REPO.getdatacount(dateformat.parse(todate));
					mv.addObject("pagination","YES");
		        }

		        System.out.println("LISTCOUNT: " + T1Dt1.size());

		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    
		    mv.addObject("reportdetails", T1Dt1);
		    mv.addObject("reportmaster12", T1Dt1);
	    }
	    
	    
	    

	    mv.setViewName("BRF/BRF1_7");
	    mv.addObject("currentPage", currentPage);
   	  	mv.addObject("totalPages",(int)Math.ceil((double)totalPages / 100)); 
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}

	public byte[] getBRF1_7Excel(String filename, String reportId, String fromdate, String todate, String currency,
			String dtltype,String type, String version) throws Exception {
		
		if (type.equals("ARCHIVAL") & version != null) {
			byte[] ARCHIVALreport = getBRF1_7ExcelARCHIVAL(filename, reportId, fromdate, todate, currency, dtltype,type, version);
			return ARCHIVALreport;
		}
		
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF1_7_Summary_Entity1> dataList = CBUAE_BRF1_7_REPORT_REPO1
				.getdatabydateList(dateformat.parse(todate));
		List<CBUAE_BRF1_7_Summary_Entity2> dataList1 = CBUAE_BRF1_7_REPORT_REPO2
				.getdatabydateList(dateformat.parse(todate));

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF1.7 report. Returning empty result.");
			return new byte[0];
		}
		if (dataList1.isEmpty()) {
		    logger.error("No data found for Entity2 - check query for date: {}", todate);
		}
		
		String templateDir = env.getProperty("output.exportpathtemp");
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
		
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 8);
		font.setFontName("Arial");
		
		CellStyle textStyle = workbook.createCellStyle();
		textStyle.setBorderBottom(BorderStyle.THIN);
		textStyle.setBorderTop(BorderStyle.THIN);
		textStyle.setBorderLeft(BorderStyle.THIN);
		textStyle.setBorderRight(BorderStyle.THIN);
		textStyle.setFont(font);
		
		CellStyle numberStyle = workbook.createCellStyle();
		//numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
		numberStyle.setBorderBottom(BorderStyle.THIN);
		numberStyle.setBorderTop(BorderStyle.THIN);
		numberStyle.setBorderLeft(BorderStyle.THIN);
		numberStyle.setBorderRight(BorderStyle.THIN);
		numberStyle.setFont(font);
		
		String[] rowCodesPart1 = {
				"R0020","R0030","R0040","R0050","R0070","R0080","R0100","R0110",
				"R0120","R0140","R0150","R0160","R0170","R0180","R0190","R0210", 
				"R0220","R0230","R0260","R0270","R0280","R0310","R0320","R0330",
				"R0350","R0360","R0390","R0400","R0420","R0430","R0450","R0460",
				"R0480","R0490","R0520","R0530","R0540","R0550","R0560","R0580",
				"R0590","R0600"
			};

		String[] rowCodesPart2 = {
				"R0610","R0620","R0640","R0650","R0660","R0670","R0680","R0690",
				"R0710","R0720","R0730","R0740","R0750","R0760","R0770","R0780",
				"R0800","R0810","R0820","R0840","R0850","R0860","R0870","R0880",
				"R0890","R0900"
			};					

		
		String[] fieldSuffixes = {
			    "aed_ksa","fcy_ksa","aed_oman","fcy_oman","aed_kuwait",
			    "fcy_kuwait","aed_qatar","fcy_qatar","aed_bahrain",
			    "fcy_bahrain","aed_rest", "fcy_rest"
			    };
			
			String[] fieldSuffixes2 = {
					"aed_ksa","fcy_ksa","aed_oman","fcy_oman","aed_kuwait",
				    "fcy_kuwait","aed_qatar","fcy_qatar","aed_bahrain",
				    "fcy_bahrain","aed_rest", "fcy_rest"
           			};
			
			// First set: R0020 - R0600 at row 12
			writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes, 12, numberStyle, textStyle);

			// Second set: R0610 - R0910 at row 71 
			writeRowData2(sheet, dataList1, rowCodesPart2, fieldSuffixes2, 71, numberStyle, textStyle);
		
			
			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.write(out);
			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
			
			return out.toByteArray();
			}
			}
	
	//R0010-R0600
			private void writeRowData1(Sheet sheet, List<CBUAE_BRF1_7_Summary_Entity1> dataList,
	                String[] rowCodes, String[] fieldSuffixes, int baseRow,
	                CellStyle numberStyle, CellStyle textStyle) {
					
					for (CBUAE_BRF1_7_Summary_Entity1 record : dataList) {
					for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
					  String rowCode = rowCodes[rowIndex];
					  Row row = sheet.getRow(baseRow + rowIndex);
					  if (row == null) row = sheet.createRow(baseRow + rowIndex);
					
					  for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					      String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					      Cell cell = row.createCell(4 + colIndex);
					      try {
					          Field field = CBUAE_BRF1_7_Summary_Entity1.class.getDeclaredField(fieldName);
					          field.setAccessible(true);
					          Object value = field.get(record);
					          if (value instanceof BigDecimal) {
					              cell.setCellValue(((BigDecimal) value).doubleValue());
					              cell.setCellStyle(numberStyle);
					          } else {
					              cell.setCellValue("");
					              cell.setCellStyle(textStyle);
					          }
					      } catch (NoSuchFieldException | IllegalAccessException e) {
					          cell.setCellValue("");
					          cell.setCellStyle(textStyle);
					          LoggerFactory.getLogger(getClass()).warn("Field not found or inaccessible: {}", fieldName);
					      }
					  }
					}
					}
					}
	
			//R0610-R0910 Entity changed
			private void writeRowData2(Sheet sheet, List<CBUAE_BRF1_7_Summary_Entity2> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        CellStyle numberStyle, CellStyle textStyle) {
			    
			    logger.info("writeRowData2 - Starting with {} records", dataList.size());
			    
			    if (dataList.isEmpty()) {
			        logger.warn("writeRowData2 - dataList is empty!");
			        return;
			    }

			    for (CBUAE_BRF1_7_Summary_Entity2 record : dataList) {
			        logger.info("Processing record: {}", record.toString()); // Make sure you have toString() implemented
			        
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			                logger.info("Created new row at index {}", baseRow + rowIndex);
			            }

			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(4 + colIndex);
			                
			                try {
			                    Field field = CBUAE_BRF1_7_Summary_Entity2.class.getDeclaredField(fieldName);
			                    field.setAccessible(true);
			                    Object value = field.get(record);
			                    
			                    if (value instanceof BigDecimal) {
			                        cell.setCellValue(((BigDecimal) value).doubleValue());
			                        cell.setCellStyle(numberStyle);
			                        logger.debug("Set value {} for field {}", value, fieldName);
			                    } else {
			                        cell.setCellValue("");
			                        cell.setCellStyle(textStyle);
			                    }
			                } catch (NoSuchFieldException e) {
			                    logger.error("Field not found: {}", fieldName);
			                    cell.setCellValue("");
			                    cell.setCellStyle(textStyle);
			                } catch (IllegalAccessException e) {
			                    logger.error("Access error for field: {}", fieldName, e);
			                    cell.setCellValue("");
			                    cell.setCellStyle(textStyle);
			                }
			            }
			        }
			    }
			}
			
			
			public byte[] getBRF1_7ExcelARCHIVAL(String filename, String reportId, String fromdate, String todate, String currency,
					String dtltype,String type, String version) throws Exception {
				logger.info("Service: Starting Excel generation process in memory.");
				
				

				List<CBUAE_BRF1_7_Summary_Archival_Entity1> dataList = CBUAE_BRF1_7_Summary_Archival_Repo1.getdatabydateListarchival(dateformat.parse(todate),version);
				List<CBUAE_BRF1_7_Summary_Archival_Entity2> dataList1 = CBUAE_BRF1_7_Summary_Archival_Repo2.getdatabydateListarchival(dateformat.parse(todate),version);
				

				if (dataList.isEmpty()) {
					logger.warn("Service: No data found for BRF1.7 report. Returning empty result.");
					return new byte[0];
				}
				if (dataList1.isEmpty()) {
				    logger.error("No data found for Entity2 - check query for date: {}", todate);
				}
				
				String templateDir = env.getProperty("output.exportpathtemp");
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
				
				Font font = workbook.createFont();
				font.setFontHeightInPoints((short) 8);
				font.setFontName("Arial");
				
				CellStyle textStyle = workbook.createCellStyle();
				textStyle.setBorderBottom(BorderStyle.THIN);
				textStyle.setBorderTop(BorderStyle.THIN);
				textStyle.setBorderLeft(BorderStyle.THIN);
				textStyle.setBorderRight(BorderStyle.THIN);
				textStyle.setFont(font);
				
				CellStyle numberStyle = workbook.createCellStyle();
				//numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
				numberStyle.setBorderBottom(BorderStyle.THIN);
				numberStyle.setBorderTop(BorderStyle.THIN);
				numberStyle.setBorderLeft(BorderStyle.THIN);
				numberStyle.setBorderRight(BorderStyle.THIN);
				numberStyle.setFont(font);
				
				String[] rowCodesPart1 = {
						"R0020","R0030","R0040","R0050","R0070","R0080","R0100","R0110",
						"R0120","R0140","R0150","R0160","R0170","R0180","R0190","R0210", 
						"R0220","R0230","R0260","R0270","R0280","R0310","R0320","R0330",
						"R0350","R0360","R0390","R0400","R0420","R0430","R0450","R0460",
						"R0480","R0490","R0520","R0530","R0540","R0550","R0560","R0580",
						"R0590","R0600"
					};

				String[] rowCodesPart2 = {
						"R0610","R0620","R0640","R0650","R0660","R0670","R0680","R0690",
						"R0710","R0720","R0730","R0740","R0750","R0760","R0770","R0780",
						"R0800","R0810","R0820","R0840","R0850","R0860","R0870","R0880",
						"R0890","R0900"
					};					

				
				String[] fieldSuffixes = {
					    "aed_ksa","fcy_ksa","aed_oman","fcy_oman","aed_kuwait",
					    "fcy_kuwait","aed_qatar","fcy_qatar","aed_bahrain",
					    "fcy_bahrain","aed_rest", "fcy_rest"
					    };
					
					String[] fieldSuffixes2 = {
							"aed_ksa","fcy_ksa","aed_oman","fcy_oman","aed_kuwait",
						    "fcy_kuwait","aed_qatar","fcy_qatar","aed_bahrain",
						    "fcy_bahrain","aed_rest", "fcy_rest"
		           			};
					
					// First set: R0020 - R0600 at row 12
					writeRowData1ARCHIVAL(sheet, dataList, rowCodesPart1, fieldSuffixes, 12, numberStyle, textStyle);

					// Second set: R0610 - R0910 at row 71 
					writeRowData2ARCHIVAL(sheet, dataList1, rowCodesPart2, fieldSuffixes2, 71, numberStyle, textStyle);
				
					
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					workbook.write(out);
					logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
					
					return out.toByteArray();
					}
					}
			
			
			//R0010-R0600
			private void writeRowData1ARCHIVAL(Sheet sheet, List<CBUAE_BRF1_7_Summary_Archival_Entity1> dataList,
	                String[] rowCodes, String[] fieldSuffixes, int baseRow,
	                CellStyle numberStyle, CellStyle textStyle) {
					
					for (CBUAE_BRF1_7_Summary_Archival_Entity1 record : dataList) {
					for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
					  String rowCode = rowCodes[rowIndex];
					  Row row = sheet.getRow(baseRow + rowIndex);
					  if (row == null) row = sheet.createRow(baseRow + rowIndex);
					
					  for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
					      String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
					      Cell cell = row.createCell(4 + colIndex);
					      try {
					          Field field = CBUAE_BRF1_7_Summary_Archival_Entity1.class.getDeclaredField(fieldName);
					          field.setAccessible(true);
					          Object value = field.get(record);
					          if (value instanceof BigDecimal) {
					              cell.setCellValue(((BigDecimal) value).doubleValue());
					              cell.setCellStyle(numberStyle);
					          } else {
					              cell.setCellValue("");
					              cell.setCellStyle(textStyle);
					          }
					      } catch (NoSuchFieldException | IllegalAccessException e) {
					          cell.setCellValue("");
					          cell.setCellStyle(textStyle);
					          LoggerFactory.getLogger(getClass()).warn("Field not found or inaccessible: {}", fieldName);
					      }
					  }
					}
					}
					}
	
			//R0610-R0910 Entity changed
			private void writeRowData2ARCHIVAL(Sheet sheet, List<CBUAE_BRF1_7_Summary_Archival_Entity2> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        CellStyle numberStyle, CellStyle textStyle) {
			    
			    logger.info("writeRowData2 - Starting with {} records", dataList.size());
			    
			    if (dataList.isEmpty()) {
			        logger.warn("writeRowData2 - dataList is empty!");
			        return;
			    }

			    for (CBUAE_BRF1_7_Summary_Archival_Entity2 record : dataList) {
			        logger.info("Processing record: {}", record.toString()); // Make sure you have toString() implemented
			        
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			                logger.info("Created new row at index {}", baseRow + rowIndex);
			            }

			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(4 + colIndex);
			                
			                try {
			                    Field field = CBUAE_BRF1_7_Summary_Archival_Entity2.class.getDeclaredField(fieldName);
			                    field.setAccessible(true);
			                    Object value = field.get(record);
			                    
			                    if (value instanceof BigDecimal) {
			                        cell.setCellValue(((BigDecimal) value).doubleValue());
			                        cell.setCellStyle(numberStyle);
			                        logger.debug("Set value {} for field {}", value, fieldName);
			                    } else {
			                        cell.setCellValue("");
			                        cell.setCellStyle(textStyle);
			                    }
			                } catch (NoSuchFieldException e) {
			                    logger.error("Field not found: {}", fieldName);
			                    cell.setCellValue("");
			                    cell.setCellStyle(textStyle);
			                } catch (IllegalAccessException e) {
			                    logger.error("Access error for field: {}", fieldName, e);
			                    cell.setCellValue("");
			                    cell.setCellStyle(textStyle);
			                }
			            }
			        }
			    }
			}
			
			
			
	// DetailExcel
	public byte[] getBRF1_7DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		try {
			logger.info("Generating Excel for BRF1_7 Details...");
			if (type.equals("ARCHIVAL") & version != null) {
				byte[] ARCHIVALreport = getBRF1_7DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
						type, version);
				return ARCHIVALreport;
			}
			
			System.out.println("came to Detail download service");

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF1_7Details");

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
			List<CBUAE_BRF1_7_Detail_Entity> reportData = CBUAE_BRF1_7_DETAIL_REPO.getdatabydateList(parsedToDate);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF1_7_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF1_7 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF1_7 Excel", e);
			return new byte[0];
		}
	}
	
	
	public byte[] getBRF1_7DetailExcelARCHIVAL(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
		try {
			logger.info("Generating Excel for BRF1_7 Details...");			
			System.out.println("came to Detail download service");

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("BRF1_7Details");

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
			List<CBUAE_BRF1_7__Archival_Detail_Entity> reportData = CBUAE_BRF1_7__Archival_Detail_Repo.getdatabydateList(parsedToDate,version);

			if (reportData != null && !reportData.isEmpty()) {
				int rowIndex = 1;
				for (CBUAE_BRF1_7__Archival_Detail_Entity item : reportData) {
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
				logger.info("No data found for BRF1_7 — only header will be written.");
			}

			// Write to byte[]
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			workbook.write(bos);
			workbook.close();

			logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
			return bos.toByteArray();

		} catch (Exception e) {
			logger.error("Error generating BRF1_7 Excel", e);
			return new byte[0];
		}
	}


	public List<Object> getBRF1_7Archival() {
		List<Object> BRF1_7Archivallist = new ArrayList<>();
		try {
			BRF1_7Archivallist = CBUAE_BRF1_7_Summary_Archival_Repo1.getBRF1_7archival();
			System.out.println("countser" + BRF1_7Archivallist.size());
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error fetching BRF1_12 Archival data: " + e.getMessage());
			e.printStackTrace();

			// Optionally, you can rethrow it or return empty list
			// throw new RuntimeException("Failed to fetch data", e);
		}
		return BRF1_7Archivallist;
	}
	
}
