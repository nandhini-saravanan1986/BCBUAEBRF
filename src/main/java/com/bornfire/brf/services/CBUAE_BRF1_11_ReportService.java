package com.bornfire.brf.services;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bornfire.brf.entities.CBUAE_BRF1_11_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_11_Detail_Repo;

import com.bornfire.brf.entities.CBUAE_BRF1_11_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF1_11_Summary_Entity2;


import com.bornfire.brf.entities.CBUAE_BRF1_11_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF1_11_Summary_Repo2;



@Component
@Service
public class CBUAE_BRF1_11_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_11_ReportService.class);
	
	@Autowired 
	AuditService auditService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	  @Autowired 
	  CBUAE_BRF1_11_Detail_Repo BRF1_11_DETAIL_Repo;
	 
	
	@Autowired
	CBUAE_BRF1_11_Summary_Repo1 BRF1_11Summary_Repo1;
	
	@Autowired
	CBUAE_BRF1_11_Summary_Repo2 BRF1_11Summary_Repo2;
	
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF1_11View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF1_11_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF1_11_Summary_Entity1>();
		List<CBUAE_BRF1_11_Summary_Entity2> T2Master = new ArrayList<CBUAE_BRF1_11_Summary_Entity2>();
		
	try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF1_11Summary_Repo1.getdatabydateList(dateformat.parse(todate));
			 
			 System.out.println("count is" + T1Master.size());
			 T2Master=BRF1_11Summary_Repo2.getdatabydateList(dateformat.parse(todate));
			
	 } catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF1_11");
		

		mv.addObject("reportsummary1", T1Master);
		mv.addObject("reportsummary2", T2Master);
		
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	
	public ModelAndView getBRF1_11currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF1_11_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = BRF1_11_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	            T1Dt1 = BRF1_11_DETAIL_Repo.getListbydate(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF1_11");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}

	
	
	// DetailExcel
			public byte[] getBRF1_11DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
					String type, String version) {
				try {
					logger.info("Generating Excel for BRF1_11 Details...");
					System.out.println("came to Detail download service");
					/*
					 * if (type.equals("ARCHIVAL") & version != null) { byte[] ARCHIVALreport =
					 * getBRF1_11DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
					 * type, version); return ARCHIVALreport; }
					 */
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("BRF1_11Details");

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
					List<CBUAE_BRF1_11_Detail_Entity> reportData = BRF1_11_DETAIL_Repo.getListbydate(parsedToDate);

					if (reportData != null && !reportData.isEmpty()) {
						int rowIndex = 1;
						for (CBUAE_BRF1_11_Detail_Entity item : reportData) {
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
						logger.info("No data found for BRF1_11 — only header will be written.");
					}

					// Write to byte[]
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					workbook.write(bos);
					workbook.close();

					logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
					return bos.toByteArray();

				} catch (Exception e) {
					logger.error("Error generating BRF1_11 Excel", e);
					return new byte[0];
				}
			}
			
			public byte[] getBRF1_11Excel(String filename, String reportId, String fromdate, String todate, String currency,
			        String dtltype, String type, String version) throws Exception {

			    logger.info("Service: Starting Excel generation process in memory.");

			    List<CBUAE_BRF1_11_Summary_Entity1> dataList = BRF1_11Summary_Repo1.getdatabydateList(dateformat.parse(todate));
			    List<CBUAE_BRF1_11_Summary_Entity2> dataList2 = BRF1_11Summary_Repo2.getdatabydateList(dateformat.parse(todate));
			    


			    if (dataList.isEmpty()) {
			        logger.warn("Service: No data found for BRF5.5 report. Returning empty result.");
			        return new byte[0];
			    }
			    if (dataList2.isEmpty()) {
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
			        // numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.000"));
			        numberStyle.setBorderBottom(BorderStyle.THIN);
			        numberStyle.setBorderTop(BorderStyle.THIN);
			        numberStyle.setBorderLeft(BorderStyle.THIN);
			        numberStyle.setBorderRight(BorderStyle.THIN);
			        numberStyle.setFont(font);

			        String[] rowCodesPart1 = {
			        		"R0020",  "R0030", "R0040"
			        	};
			        String[] rowCodesPart2 = {
			        	    "R0060" ,"R0070",  "R0080","R0090" ,  "R0100", "R0110", "R0120",
				        	    "R0130"
			        	};
			        String[] rowCodesPart3 = {
			        		"R0150","R0160", "R0170","R0180", "R0190", 
	        	    
			        };
			         
			        String[] rowCodesPart4 = {
			        		"R0210", "R0220", "R0230" 
			        	   
			        	};
			        
			        String[] rowCodesPart5 = {
			        		
			        	    "R0250",  "R0260","R0270", "R0280","R0290"
			        	};
			        String[] rowCodesPart6 = {
			        		"R0330","R0340", "R0350","R0360"
			        	};
			        String[] rowCodesPart7 = {
			        		 "R0380","R0390", "R0400","R0410","R0420"
			        	};
			        
			        String[] rowCodesPart8 = {
			        		 "R0440"
			        	};
			        
			        String[] rowCodesPart9 = {
			        		   "R0460", "R0470","R0480","R0490", "R0500","R0510","R0520","R0530","R0540"
			        	};
			        String[] rowCodesPart10 = {
			        		 "R0560", "R0570","R0580","R0590", "R0600","R0610","R0620","R0630"			        	       
			        	};
			        
			        String[] rowCodesPart11 = {
			        		"R0650", "R0660","R0670","R0680", "R0690","R0700","R0710"			        	       
			        	};
			        String[] rowCodesPart12 = {
			        		
			        		"R0740", "R0750","R0760","R0770", "R0780","R0790","R0800","R0810"
			        	   
			        	};
			        String[] rowCodesPart13 = {
			        		"R0840", "R0850","R0860","R0870", "R0880","R0890"
			        };
			        

			        String[] rowCodesPart14 = {
			        		 "R0900", "R0910", "R0920", "R0930"
				       };
			        
			        String[] rowCodesPart15 = {
			        		  "R0950", "R0960"
				       };

			        String[] rowCodesPart16 = {
			        	   "R0990", "R1000", "R1010", "R1020", "R1030" , "R1040","R1050","R1060","R1070",
			        	   "R1080","R1090","R1100","R1110","R1120","R1130","R1140",
			        	};
			        String[] rowCodesPart17 = {
			        		"R1160","R1170","R1180"
			        	};
			        
			        
			        String[] fieldSuffixes = {
			        		"banking_operations",
			        		"banking_subsidiaries_uae",
			        		"financial_subsidiary_uae",
			        		"financial_subsidiary_outside_uae",
			        		"all_other_subsidiary_uae",
			        		"all_other_subsidiary_outside_uae",
			        		
			        		
			        	};
			        
			        String[] fieldSuffixes2 = {
			        		
			        		"elimination",
			        		"reclassification",
			        		
			        	};
			        
			        
			     
					writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes, 9,4, numberStyle, textStyle);
					writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes2, 9,11, numberStyle, textStyle);

					
				    writeRowData2(sheet, dataList, rowCodesPart2, fieldSuffixes, 13,4, numberStyle, textStyle);
				    writeRowData2(sheet, dataList, rowCodesPart2, fieldSuffixes2, 13,11,  numberStyle, textStyle);

			        writeRowData3(sheet, dataList, rowCodesPart3, fieldSuffixes, 22,4, numberStyle, textStyle);	
			        writeRowData3(sheet, dataList, rowCodesPart3, fieldSuffixes2, 22,11, numberStyle, textStyle);	

				
					writeRowData4(sheet, dataList, rowCodesPart4, fieldSuffixes, 28,4, numberStyle, textStyle);	
					writeRowData4(sheet, dataList, rowCodesPart4, fieldSuffixes2, 28,11, numberStyle, textStyle);	

					writeRowData5(sheet, dataList, rowCodesPart5, fieldSuffixes, 32,4, numberStyle, textStyle);
					writeRowData5(sheet, dataList, rowCodesPart5, fieldSuffixes2, 32,11, numberStyle, textStyle);	

					
					writeRowData6(sheet, dataList, rowCodesPart6, fieldSuffixes, 40,4, numberStyle, textStyle);	
					writeRowData6(sheet, dataList, rowCodesPart6, fieldSuffixes2, 40,11, numberStyle, textStyle);	

					writeRowData7(sheet, dataList, rowCodesPart7, fieldSuffixes, 45,4, numberStyle, textStyle);
					writeRowData7(sheet, dataList, rowCodesPart7, fieldSuffixes2, 45,11, numberStyle, textStyle);	

					
					writeRowData8(sheet, dataList, rowCodesPart8, fieldSuffixes, 51,4, numberStyle, textStyle);
					writeRowData8(sheet, dataList, rowCodesPart8, fieldSuffixes2, 51,11, numberStyle, textStyle);

					writeRowData9(sheet, dataList, rowCodesPart9, fieldSuffixes, 53,4, numberStyle, textStyle);
					writeRowData9(sheet, dataList, rowCodesPart9, fieldSuffixes2, 53,11, numberStyle, textStyle);

					
					writeRowData10(sheet, dataList, rowCodesPart10, fieldSuffixes,63,4, numberStyle, textStyle);	
					writeRowData10(sheet, dataList, rowCodesPart10, fieldSuffixes2,63,11, numberStyle, textStyle);	

					writeRowData11(sheet, dataList, rowCodesPart11, fieldSuffixes, 72,4, numberStyle, textStyle);	
					writeRowData11(sheet, dataList, rowCodesPart11, fieldSuffixes2, 72,11, numberStyle, textStyle);	
 
					writeRowData12(sheet, dataList, rowCodesPart12, fieldSuffixes, 81,4, numberStyle, textStyle);	
					writeRowData12(sheet, dataList, rowCodesPart12, fieldSuffixes2, 81,11, numberStyle, textStyle);	

					writeRowData13(sheet, dataList, rowCodesPart13, fieldSuffixes, 91,4, numberStyle, textStyle);	
					writeRowData13(sheet, dataList, rowCodesPart13, fieldSuffixes2, 91,11, numberStyle, textStyle);	

					writeRowData14(sheet, dataList2, rowCodesPart14, fieldSuffixes, 97,4, numberStyle, textStyle);	
					writeRowData14(sheet, dataList2, rowCodesPart14, fieldSuffixes2, 97,11, numberStyle, textStyle);	
 
					writeRowData15(sheet, dataList2, rowCodesPart15, fieldSuffixes, 102,4, numberStyle, textStyle);
					writeRowData15(sheet, dataList2, rowCodesPart15, fieldSuffixes2, 102,11, numberStyle, textStyle);

					writeRowData16(sheet, dataList2, rowCodesPart16, fieldSuffixes, 106,4, numberStyle, textStyle);	
					writeRowData16(sheet, dataList2, rowCodesPart16, fieldSuffixes2, 106,11, numberStyle, textStyle);	

					writeRowData17(sheet, dataList2, rowCodesPart17, fieldSuffixes, 123,4, numberStyle, textStyle);	
					writeRowData17(sheet, dataList2, rowCodesPart17, fieldSuffixes2, 123,11, numberStyle, textStyle);	
 
						
					
			        
			       
			        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					workbook.write(out);
					logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
					
					return out.toByteArray();
			       

			    } 

			} 
			
			   
			private void writeRowData1(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData2(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData3(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData4(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData5(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData6(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData7(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}
			
			
			
			private void writeRowData8(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			
			private void writeRowData9(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData10(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData11(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			
			private void writeRowData12(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}

			
			private void writeRowData13(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity1> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity1 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity1.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}
								
			private void writeRowData14(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity2> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity2 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity2.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}
			private void writeRowData15(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity2> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity2 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity2.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}
		
			private void writeRowData16(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity2> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity2 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity2.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}
			private void writeRowData17(Sheet sheet, List<CBUAE_BRF1_11_Summary_Entity2> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        int startColIndex, CellStyle numberStyle, CellStyle textStyle) {
			    
			    for (CBUAE_BRF1_11_Summary_Entity2 record : dataList) {
			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			            }

			            int actualColIndex = startColIndex; // use passed index
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF1_11_Summary_Entity2.class.getDeclaredField(fieldName);
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
			                }
			            }
			        }
			    }
			}
								
}