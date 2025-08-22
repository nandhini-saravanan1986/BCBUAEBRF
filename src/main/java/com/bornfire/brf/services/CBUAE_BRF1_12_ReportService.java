package com.bornfire.brf.services;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


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

import com.bornfire.brf.entities.CBUAE_BRF1_12_Summary_Entitiy;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Summary_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_12_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF1_1_Summary_Entity;
import com.bornfire.brf.services.AuditService;
import com.bornfire.brf.entities.CBUAE_BRF1_1_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_1_Detail_Repo;

@Component
@Service
public class CBUAE_BRF1_12_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_1_ReportService.class);
	
	@Autowired 
	AuditService auditService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF1_12_Detail_Repo BRF1_12_DETAIL_Repo;
	
	@Autowired
	CBUAE_BRF1_12_Summary_Repo BRF1_12Summary_Repo;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF1_12View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		System.out.println("brf1_12");
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF1_12_Summary_Entitiy> T1Master = new ArrayList<CBUAE_BRF1_12_Summary_Entitiy>();
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF1_12Summary_Repo.getdatabydateList(dateformat.parse(todate));
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF1_12");
		
		mv.addObject("reportsummary", T1Master);
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF1_12currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF1_12_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = BRF1_12_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	            T1Dt1 = BRF1_12_DETAIL_Repo.getListbydate(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF1_12");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}

	
	
	public byte[] getBRF1_12Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");
		
		List<CBUAE_BRF1_12_Summary_Entitiy> T1Master = new ArrayList<CBUAE_BRF1_12_Summary_Entitiy>();

		List<CBUAE_BRF1_12_Summary_Entitiy> dataList =BRF1_12Summary_Repo.getdatabydateList(dateformat.parse(todate)) ;

		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for Trade Market Risk report. Returning empty result.");
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
			font.setFontHeightInPoints((short)8); // size 8
			font.setFontName("Arial");    

			CellStyle numberStyle = workbook.createCellStyle();
			//numberStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.000"));
			numberStyle.setBorderBottom(BorderStyle.THIN);
			numberStyle.setBorderTop(BorderStyle.THIN);
			numberStyle.setBorderLeft(BorderStyle.THIN);
			numberStyle.setBorderRight(BorderStyle.THIN);
			numberStyle.setFont(font);
			// --- End of Style Definitions ---

			int startRow = 9;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {
					CBUAE_BRF1_12_Summary_Entitiy record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}

		
					
					  //row10 // Column 4: 
					Cell cell5 = row.createCell(4); 
					if(record.getR0020AverageQualify() != null) {
					  cell5.setCellValue(record.getR0020AverageQualify().doubleValue());
					  cell5.setCellStyle(numberStyle);
					  }
					else { cell5.setCellValue("");
					  cell5.setCellStyle(textStyle);
					  }
					
					// row11
					row = sheet.getRow(10);
					cell5 = row.createCell(4);
					if(record.getR0030AverageQualify() != null) {
					    cell5.setCellValue(record.getR0030AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row12
					row = sheet.getRow(11);
					cell5 = row.createCell(4);
					if(record.getR0040AverageQualify() != null) {
					    cell5.setCellValue(record.getR0040AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row13
					row = sheet.getRow(12);
					cell5 = row.createCell(4);
					if(record.getR0050AverageQualify() != null) {
					    cell5.setCellValue(record.getR0050AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row14
					row = sheet.getRow(13);
					cell5 = row.createCell(4);
					if(record.getR0060AverageQualify() != null) {
					    cell5.setCellValue(record.getR0060AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row15 — skipped

					// row16
					row = sheet.getRow(15);
					cell5 = row.createCell(4);
					if(record.getR0080AverageQualify() != null) {
					    cell5.setCellValue(record.getR0080AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row17
					row = sheet.getRow(16);
					cell5 = row.createCell(4);
					if(record.getR0090AverageQualify() != null) {
					    cell5.setCellValue(record.getR0090AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row18
					row = sheet.getRow(17);
					cell5 = row.createCell(4);
					if(record.getR0100AverageQualify() != null) {
					    cell5.setCellValue(record.getR0100AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row19
					row = sheet.getRow(18);
					cell5 = row.createCell(4);
					if(record.getR0110AverageQualify() != null) {
					    cell5.setCellValue(record.getR0110AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row20
					row = sheet.getRow(19);
					cell5 = row.createCell(4);
					if(record.getR0120AverageQualify() != null) {
					    cell5.setCellValue(record.getR0120AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row21 — skipped

					// row22
					row = sheet.getRow(21);
					cell5 = row.createCell(4);
					if(record.getR0140AverageQualify() != null) {
					    cell5.setCellValue(record.getR0140AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row23
					row = sheet.getRow(22);
					cell5 = row.createCell(4);
					if(record.getR0150AverageQualify() != null) {
					    cell5.setCellValue(record.getR0150AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row24
					row = sheet.getRow(23);
					cell5 = row.createCell(4);
					if(record.getR0160AverageQualify() != null) {
					    cell5.setCellValue(record.getR0160AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row25
					row = sheet.getRow(24);
					cell5 = row.createCell(4);
					if(record.getR0170AverageQualify() != null) {
					    cell5.setCellValue(record.getR0170AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row26
					row = sheet.getRow(25);
					cell5 = row.createCell(4);
					if(record.getR0180AverageQualify() != null) {
					    cell5.setCellValue(record.getR0180AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row27 — skipped

					// row28
					row = sheet.getRow(27);
					cell5 = row.createCell(4);
					if(record.getR0200AverageQualify() != null) {
					    cell5.setCellValue(record.getR0200AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row29
					row = sheet.getRow(28);
					cell5 = row.createCell(4);
					if(record.getR0210AverageQualify() != null) {
					    cell5.setCellValue(record.getR0210AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row30
					row = sheet.getRow(29);
					cell5 = row.createCell(4);
					if(record.getR0220AverageQualify() != null) {
					    cell5.setCellValue(record.getR0220AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row31
					row = sheet.getRow(30);
					cell5 = row.createCell(4);
					if(record.getR0230AverageQualify() != null) {
					    cell5.setCellValue(record.getR0230AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}

					// row32
					row = sheet.getRow(31);
					cell5 = row.createCell(4);
					if(record.getR0240AverageQualify() != null) {
					    cell5.setCellValue(record.getR0240AverageQualify().doubleValue());
					    cell5.setCellStyle(numberStyle);
					} else {
					    cell5.setCellValue("");
					    cell5.setCellStyle(textStyle);
					}
					
					
					
					
					
					
										
					
				}

				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			} else {
				System.out.println("No Trade Market Risk data found to generate the Excel file.");
			}

			// Write the final workbook content to the in-memory stream.
			workbook.write(out);

			logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());
			
			//audit
	        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        if (attrs != null) {
	            HttpServletRequest request = attrs.getRequest();
	            String userid = (String) request.getSession().getAttribute("USERID");
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF1_12_SUMMARY", null, "CBUAE_BRF1_12_SUMMARYTABLE");
	        }
	        
			return out.toByteArray();
		}
	}
	
	
	
	public byte[] getBRF1_12DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
	    try {
	        logger.info("Generating Excel for BRF1_12 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF1_12Details");

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
	        String[] headers = {
	            "CUST ID", "ACCT NO", "ACCT NAME", "ACCT BALANCE", "ROWID", "COLUMNID", "REPORT_DATE"
	        };

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
	        List<CBUAE_BRF1_12_Detail_Entity> reportData = BRF1_12_DETAIL_Repo.getListbydate(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF1_12_Detail_Entity item : reportData) {
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
	                row.createCell(6).setCellValue(
	                    item.getReportDate() != null ?
	                    new SimpleDateFormat("dd-MM-yyyy").format(item.getReportDate()) : ""
	                );

	                // Apply data style for all other cells
	                for (int j = 0; j < 7; j++) {
	                    if (j != 3) {
	                        row.getCell(j).setCellStyle(dataStyle);
	                    }
	                }
	            }
	        } else {
	            logger.info("No data found for BRF1_12 — only header will be written.");
	        }

	        // Write to byte[]
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        workbook.write(bos);
	        workbook.close();

	        logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
	        
	        //audit
	        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        if (attrs != null) {
	            HttpServletRequest request = attrs.getRequest();
	            String userid = (String) request.getSession().getAttribute("USERID");
	            auditService.createBusinessAudit(userid, "DOWNLOAD", "BRF1_12_DETAIL", null, "CBUAE_BRF1_12_DETAILTABLE");
	        }


	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF1_12 Excel", e);
	        return new byte[0];
	    }
	   
	 
	}




}
