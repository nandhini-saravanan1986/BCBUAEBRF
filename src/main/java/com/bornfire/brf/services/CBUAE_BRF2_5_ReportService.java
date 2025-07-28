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

import com.bornfire.brf.entities.CBUAE_BRF2_5_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF2_5_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF2_5_Detail_Entity;

import com.bornfire.brf.entities.CBUAE_BRF2_5_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF2_5_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF2_5_Summary_Repo2;


@Component
@Service

public class CBUAE_BRF2_5_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF2_5_ReportService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF2_5_Detail_Repo CBUAE_BRF2_5_DETAIL_REPO;
	
	@Autowired
	CBUAE_BRF2_5_Summary_Repo1 CBUAE_BRF2_5_SUMMARY_REPO1;
	
	@Autowired
	CBUAE_BRF2_5_Summary_Repo2 CBUAE_BRF2_5_SUMMARY_REPO2;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	
	public ModelAndView getBRF2_5View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF2_5_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF2_5_Summary_Entity1>();
		List<CBUAE_BRF2_5_Summary_Entity2> T1Master1 = new ArrayList<CBUAE_BRF2_5_Summary_Entity2>();
		try {
			Date d1 = dateformat.parse(todate);
			
			 T1Master=CBUAE_BRF2_5_SUMMARY_REPO1.getdatabydateList(dateformat.parse(todate));
			 T1Master1=CBUAE_BRF2_5_SUMMARY_REPO2.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("BRF/BRF2_5");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
	    mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF2_5currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF2_5_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	        	 T1Dt1 = CBUAE_BRF2_5_DETAIL_REPO.GetDataByRowIdAndColumnId(rowId, columnId, d1);
	        } else {
	            T1Dt1 = CBUAE_BRF2_5_DETAIL_REPO.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF2_5");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
		}
		
	//DetailExcel
	public byte[] getBRF2_5DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
			String type, String version) {
	    try {
	        logger.info("Generating Excel for BRF2_5 Details...");
	        System.out.println("came to Detail download service");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("BRF2_5Details");

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
	        List<CBUAE_BRF2_5_Detail_Entity> reportData = CBUAE_BRF2_5_DETAIL_REPO.getdatabydateList(parsedToDate);

	        if (reportData != null && !reportData.isEmpty()) {
	            int rowIndex = 1;
	            for (CBUAE_BRF2_5_Detail_Entity item : reportData) {
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
	            logger.info("No data found for BRF2_5 — only header will be written.");
	        }

	        // Write to byte[]
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        workbook.write(bos);
	        workbook.close();

	        logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
	        return bos.toByteArray();

	    } catch (Exception e) {
	        logger.error("Error generating BRF2_5 Excel", e);
	        return new byte[0];
	    }
	}

	
	
	public byte[] getBRF2_5Excel(String filename,String reportId, String fromdate, String todate, String currency, String dtltype) throws Exception {
		logger.info("Service: Starting Excel generation process in memory.");

		List<CBUAE_BRF2_5_Summary_Entity1> dataList =CBUAE_BRF2_5_SUMMARY_REPO1.getdatabydateList(dateformat.parse(todate)) ;
		List<CBUAE_BRF2_5_Summary_Entity2> dataList1 =CBUAE_BRF2_5_SUMMARY_REPO2.getdatabydateList(dateformat.parse(todate)) ;


		if (dataList.isEmpty()) {
			logger.warn("Service: No data found for BRF2.3 report. Returning empty result.");
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

			int startRow = 11;

			if (!dataList.isEmpty()) {
				for (int i = 0; i < dataList.size(); i++) {


					CBUAE_BRF2_5_Summary_Entity1 record = dataList.get(i);
					System.out.println("rownumber="+startRow + i);
					Row row = sheet.getRow(startRow + i);
					if (row == null) {
						row = sheet.createRow(startRow + i);
					}



/////ROW12///////////
//row12
// Column E: 
Cell R0030cell4 = row.createCell(4);
if (record.getR0030_overdraft() != null) {
	R0030cell4.setCellValue(record.getR0030_overdraft().doubleValue());
	R0030cell4.setCellStyle(numberStyle);
} else {
	R0030cell4.setCellValue("");
	R0030cell4.setCellStyle(textStyle);
}

//row12
//Column F: 
Cell R0030cell5 = row.createCell(5);
if (record.getR0030_0_7days() != null) {
	R0030cell5.setCellValue(record.getR0030_0_7days().doubleValue());
	R0030cell5.setCellStyle(numberStyle);
} else {
	R0030cell5.setCellValue("");
	R0030cell5.setCellStyle(textStyle);
}

//row12
//Column G: 
Cell R0030cell6 = row.createCell(6);
if (record.getR0030_8_14days() != null) {
	R0030cell6.setCellValue(record.getR0030_8_14days().doubleValue());
	R0030cell6.setCellStyle(numberStyle);
} else {
	R0030cell6.setCellValue("");
	R0030cell6.setCellStyle(textStyle);
}

//row12
//Column H: 
Cell R0030cell7 = row.createCell(7);
if (record.getR0030_15days_1months() != null) {
	R0030cell7.setCellValue(record.getR0030_15days_1months().doubleValue());
	R0030cell7.setCellStyle(numberStyle);
} else {
	R0030cell7.setCellValue("");
	R0030cell7.setCellStyle(textStyle);
}

//row12
//Column I: 
Cell R0030cell8 = row.createCell(8);
if (record.getR0030_1_2months() != null) {
    R0030cell8.setCellValue(record.getR0030_1_2months().doubleValue());
    R0030cell8.setCellStyle(numberStyle);
} else {
	R0030cell8.setCellValue("");
	R0030cell8.setCellStyle(textStyle);
}
			
			
//row12
//Column J: 
Cell R0030cell9 = row.createCell(9);
if (record.getR0030_2_3months() != null) {
	R0030cell9.setCellValue(record.getR0030_2_3months().doubleValue());
	R0030cell9.setCellStyle(numberStyle);
} else {
	R0030cell9.setCellValue("");
	R0030cell9.setCellStyle(textStyle);
}

//row12
//Column K: 
Cell R0030cell10 = row.createCell(10);
if (record.getR0030_3_6months() != null) {
	R0030cell10.setCellValue(record.getR0030_3_6months().doubleValue());
	R0030cell10.setCellStyle(numberStyle);
} else {
	R0030cell10.setCellValue("");
	R0030cell10.setCellStyle(textStyle);
}

//row12
//Column L: 
Cell R0030cell11 = row.createCell(11);
if (record.getR0030_6_12months() != null) {
	R0030cell11.setCellValue(record.getR0030_6_12months().doubleValue());
	R0030cell11.setCellStyle(numberStyle);
} else {
	R0030cell11.setCellValue("");
	R0030cell11.setCellStyle(textStyle);
}

//row12
//Column M: 
Cell R0030cell12 = row.createCell(12);
if (record.getR0030_1_2years() != null) {
	R0030cell12.setCellValue(record.getR0030_1_2years().doubleValue());
	R0030cell12.setCellStyle(numberStyle);
} else {
	R0030cell12.setCellValue("");
	R0030cell12.setCellStyle(textStyle);
}

//row12
//Column N: 
Cell R0030cell13 = row.createCell(13);
if (record.getR0030_2_3years() != null) {
	R0030cell13.setCellValue(record.getR0030_2_3years().doubleValue());
	R0030cell13.setCellStyle(numberStyle);
} else {
	R0030cell13.setCellValue("");
	R0030cell13.setCellStyle(textStyle);
}

//row12
//Column O: 
Cell R0030cell14 = row.createCell(14);
if (record.getR0030_3_4years() != null) {
	R0030cell14.setCellValue(record.getR0030_3_4years().doubleValue());
	R0030cell14.setCellStyle(numberStyle);
} else {
	R0030cell14.setCellValue("");
	R0030cell14.setCellStyle(textStyle);
}

//row12
//Column P: 
Cell R0030cell15 = row.createCell(15);
if (record.getR0030_4_5years() != null) {
	R0030cell15.setCellValue(record.getR0030_4_5years().doubleValue());
	R0030cell15.setCellStyle(numberStyle);
} else {
	R0030cell15.setCellValue("");
	R0030cell15.setCellStyle(textStyle);
}

//row12
//Column Q: 
Cell R0030cell16 = row.createCell(16);
if (record.getR0030_5years() != null) {
	R0030cell16.setCellValue(record.getR0030_5years().doubleValue());
	R0030cell16.setCellStyle(numberStyle);
} else {
	R0030cell16.setCellValue("");
	R0030cell16.setCellStyle(textStyle);
}

//row12
//Column R: 
Cell R0030cell17 = row.createCell(17);
if (record.getR0030_non_interest() != null) {
	R0030cell17.setCellValue(record.getR0030_non_interest().doubleValue());
	R0030cell17.setCellStyle(numberStyle);
} else {
	R0030cell17.setCellValue("");
	R0030cell17.setCellStyle(textStyle);
}

/////ROW13///////////
//ROW13
//Column E: 
row = sheet.getRow(12);
Cell R0040cell4 = row.createCell(4);
if (record.getR0040_overdraft() != null) {
R0040cell4.setCellValue(record.getR0040_overdraft().doubleValue());
R0040cell4.setCellStyle(numberStyle);
} else {
R0040cell4.setCellValue("");
R0040cell4.setCellStyle(textStyle);
}

//ROW13
//Column F: 
Cell R0040cell5 = row.createCell(5);
if (record.getR0040_0_7days() != null) {
R0040cell5.setCellValue(record.getR0040_0_7days().doubleValue());
R0040cell5.setCellStyle(numberStyle);
} else {
R0040cell5.setCellValue("");
R0040cell5.setCellStyle(textStyle);
}

//ROW13
//Column G: 
Cell R0040cell6 = row.createCell(6);
if (record.getR0040_8_14days() != null) {
R0040cell6.setCellValue(record.getR0040_8_14days().doubleValue());
R0040cell6.setCellStyle(numberStyle);
} else {
R0040cell6.setCellValue("");
R0040cell6.setCellStyle(textStyle);
}

//ROW13
//Column H: 
Cell R0040cell7 = row.createCell(7);
if (record.getR0040_15days_1months() != null) {
R0040cell7.setCellValue(record.getR0040_15days_1months().doubleValue());
R0040cell7.setCellStyle(numberStyle);
} else {
R0040cell7.setCellValue("");
R0040cell7.setCellStyle(textStyle);
}

//ROW13
//Column I: 
Cell R0040cell8 = row.createCell(8);
if (record.getR0040_1_2months() != null) {
R0040cell8.setCellValue(record.getR0040_1_2months().doubleValue());
R0040cell8.setCellStyle(numberStyle);
} else {
R0040cell8.setCellValue("");
R0040cell8.setCellStyle(textStyle);
}
		
		
//ROW13
//Column J: 
Cell R0040cell9 = row.createCell(9);
if (record.getR0040_2_3months() != null) {
R0040cell9.setCellValue(record.getR0040_2_3months().doubleValue());
R0040cell9.setCellStyle(numberStyle);
} else {
R0040cell9.setCellValue("");
R0040cell9.setCellStyle(textStyle);
}

//ROW13
//Column K: 
Cell R0040cell10 = row.createCell(10);
if (record.getR0040_3_6months() != null) {
R0040cell10.setCellValue(record.getR0040_3_6months().doubleValue());
R0040cell10.setCellStyle(numberStyle);
} else {
R0040cell10.setCellValue("");
R0040cell10.setCellStyle(textStyle);
}

//ROW13
//Column L: 
Cell R0040cell11 = row.createCell(11);
if (record.getR0040_6_12months() != null) {
R0040cell11.setCellValue(record.getR0040_6_12months().doubleValue());
R0040cell11.setCellStyle(numberStyle);
} else {
R0040cell11.setCellValue("");
R0040cell11.setCellStyle(textStyle);
}

//ROW13
//Column M: 
Cell R0040cell12 = row.createCell(12);
if (record.getR0040_1_2years() != null) {
R0040cell12.setCellValue(record.getR0040_1_2years().doubleValue());
R0040cell12.setCellStyle(numberStyle);
} else {
R0040cell12.setCellValue("");
R0040cell12.setCellStyle(textStyle);
}

//ROW13
//Column N: 
Cell R0040cell13 = row.createCell(13);
if (record.getR0040_2_3years() != null) {
R0040cell13.setCellValue(record.getR0040_2_3years().doubleValue());
R0040cell13.setCellStyle(numberStyle);
} else {
R0040cell13.setCellValue("");
R0040cell13.setCellStyle(textStyle);
}

//ROW13
//Column O: 
Cell R0040cell14 = row.createCell(14);
if (record.getR0040_3_4years() != null) {
R0040cell14.setCellValue(record.getR0040_3_4years().doubleValue());
R0040cell14.setCellStyle(numberStyle);
} else {
R0040cell14.setCellValue("");
R0040cell14.setCellStyle(textStyle);
}

//ROW13
//Column P: 
Cell R0040cell15 = row.createCell(15);
if (record.getR0040_4_5years() != null) {
R0040cell15.setCellValue(record.getR0040_4_5years().doubleValue());
R0040cell15.setCellStyle(numberStyle);
} else {
R0040cell15.setCellValue("");
R0040cell15.setCellStyle(textStyle);
}

//ROW13
//Column Q: 
Cell R0040cell16 = row.createCell(16);
if (record.getR0040_5years() != null) {
R0040cell16.setCellValue(record.getR0040_5years().doubleValue());
R0040cell16.setCellStyle(numberStyle);
} else {
R0040cell16.setCellValue("");
R0040cell16.setCellStyle(textStyle);
}

//ROW13
//Column R: 
Cell R0040cell17 = row.createCell(17);
if (record.getR0040_non_interest() != null) {
R0040cell17.setCellValue(record.getR0040_non_interest().doubleValue());
R0040cell17.setCellStyle(numberStyle);
} else {
R0040cell17.setCellValue("");
R0040cell17.setCellStyle(textStyle);
}


/////ROW14///////////
//ROW14
//Column E: 
row = sheet.getRow(13);
Cell R0050cell4 = row.createCell(4);
if (record.getR0050_overdraft() != null) {
R0050cell4.setCellValue(record.getR0050_overdraft().doubleValue());
R0050cell4.setCellStyle(numberStyle);
} else {
R0050cell4.setCellValue("");
R0050cell4.setCellStyle(textStyle);
}

//ROW14
//Column F: 
Cell R0050cell5 = row.createCell(5);
if (record.getR0050_0_7days() != null) {
R0050cell5.setCellValue(record.getR0050_0_7days().doubleValue());
R0050cell5.setCellStyle(numberStyle);
} else {
R0050cell5.setCellValue("");
R0050cell5.setCellStyle(textStyle);
}

//ROW14
//Column G: 
Cell R0050cell6 = row.createCell(6);
if (record.getR0050_8_14days() != null) {
R0050cell6.setCellValue(record.getR0050_8_14days().doubleValue());
R0050cell6.setCellStyle(numberStyle);
} else {
R0050cell6.setCellValue("");
R0050cell6.setCellStyle(textStyle);
}

//ROW14
//Column H: 
Cell R0050cell7 = row.createCell(7);
if (record.getR0050_15days_1months() != null) {
R0050cell7.setCellValue(record.getR0050_15days_1months().doubleValue());
R0050cell7.setCellStyle(numberStyle);
} else {
R0050cell7.setCellValue("");
R0050cell7.setCellStyle(textStyle);
}

//ROW14
//Column I: 
Cell R0050cell8 = row.createCell(8);
if (record.getR0050_1_2months() != null) {
R0050cell8.setCellValue(record.getR0050_1_2months().doubleValue());
R0050cell8.setCellStyle(numberStyle);
} else {
R0050cell8.setCellValue("");
R0050cell8.setCellStyle(textStyle);
}
		
		
//ROW14
//Column J: 
Cell R0050cell9 = row.createCell(9);
if (record.getR0050_2_3months() != null) {
R0050cell9.setCellValue(record.getR0050_2_3months().doubleValue());
R0050cell9.setCellStyle(numberStyle);
} else {
R0050cell9.setCellValue("");
R0050cell9.setCellStyle(textStyle);
}

//ROW14
//Column K: 
Cell R0050cell10 = row.createCell(10);
if (record.getR0050_3_6months() != null) {
R0050cell10.setCellValue(record.getR0050_3_6months().doubleValue());
R0050cell10.setCellStyle(numberStyle);
} else {
R0050cell10.setCellValue("");
R0050cell10.setCellStyle(textStyle);
}

//ROW14
//Column L: 
Cell R0050cell11 = row.createCell(11);
if (record.getR0050_6_12months() != null) {
R0050cell11.setCellValue(record.getR0050_6_12months().doubleValue());
R0050cell11.setCellStyle(numberStyle);
} else {
R0050cell11.setCellValue("");
R0050cell11.setCellStyle(textStyle);
}

//ROW14
//Column M: 
Cell R0050cell12 = row.createCell(12);
if (record.getR0050_1_2years() != null) {
R0050cell12.setCellValue(record.getR0050_1_2years().doubleValue());
R0050cell12.setCellStyle(numberStyle);
} else {
R0050cell12.setCellValue("");
R0050cell12.setCellStyle(textStyle);
}

//ROW14
//Column N: 
Cell R0050cell13 = row.createCell(13);
if (record.getR0050_2_3years() != null) {
R0050cell13.setCellValue(record.getR0050_2_3years().doubleValue());
R0050cell13.setCellStyle(numberStyle);
} else {
R0050cell13.setCellValue("");
R0050cell13.setCellStyle(textStyle);
}

//ROW14
//Column O: 
Cell R0050cell14 = row.createCell(14);
if (record.getR0050_3_4years() != null) {
R0050cell14.setCellValue(record.getR0050_3_4years().doubleValue());
R0050cell14.setCellStyle(numberStyle);
} else {
R0050cell14.setCellValue("");
R0050cell14.setCellStyle(textStyle);
}

//ROW14
//Column P: 
Cell R0050cell15 = row.createCell(15);
if (record.getR0050_4_5years() != null) {
R0050cell15.setCellValue(record.getR0050_4_5years().doubleValue());
R0050cell15.setCellStyle(numberStyle);
} else {
R0050cell15.setCellValue("");
R0050cell15.setCellStyle(textStyle);
}

//ROW14
//Column Q: 
Cell R0050cell16 = row.createCell(16);
if (record.getR0050_5years() != null) {
R0050cell16.setCellValue(record.getR0050_5years().doubleValue());
R0050cell16.setCellStyle(numberStyle);
} else {
R0050cell16.setCellValue("");
R0050cell16.setCellStyle(textStyle);
}

//ROW14
//Column R: 
Cell R0050cell17 = row.createCell(17);
if (record.getR0050_non_interest() != null) {
R0050cell17.setCellValue(record.getR0050_non_interest().doubleValue());
R0050cell17.setCellStyle(numberStyle);
} else {
R0050cell17.setCellValue("");
R0050cell17.setCellStyle(textStyle);
}

/////ROW16///////////
//ROW16
//Column E: 
row = sheet.getRow(15);
Cell R0070cell4 = row.createCell(4);
if (record.getR0070_overdraft() != null) {
R0070cell4.setCellValue(record.getR0070_overdraft().doubleValue());
R0070cell4.setCellStyle(numberStyle);
} else {
R0070cell4.setCellValue("");
R0070cell4.setCellStyle(textStyle);
}

//ROW16
//Column F: 
Cell R0070cell5 = row.createCell(5);
if (record.getR0070_0_7days() != null) {
R0070cell5.setCellValue(record.getR0070_0_7days().doubleValue());
R0070cell5.setCellStyle(numberStyle);
} else {
R0070cell5.setCellValue("");
R0070cell5.setCellStyle(textStyle);
}

//ROW16
//Column G: 
Cell R0070cell6 = row.createCell(6);
if (record.getR0070_8_14days() != null) {
R0070cell6.setCellValue(record.getR0070_8_14days().doubleValue());
R0070cell6.setCellStyle(numberStyle);
} else {
R0070cell6.setCellValue("");
R0070cell6.setCellStyle(textStyle);
}

//ROW16
//Column H: 
Cell R0070cell7 = row.createCell(7);
if (record.getR0070_15days_1months() != null) {
R0070cell7.setCellValue(record.getR0070_15days_1months().doubleValue());
R0070cell7.setCellStyle(numberStyle);
} else {
R0070cell7.setCellValue("");
R0070cell7.setCellStyle(textStyle);
}

//ROW16
//Column I: 
Cell R0070cell8 = row.createCell(8);
if (record.getR0070_1_2months() != null) {
R0070cell8.setCellValue(record.getR0070_1_2months().doubleValue());
R0070cell8.setCellStyle(numberStyle);
} else {
R0070cell8.setCellValue("");
R0070cell8.setCellStyle(textStyle);
}
		
		
//ROW16
//Column J: 
Cell R0070cell9 = row.createCell(9);
if (record.getR0070_2_3months() != null) {
R0070cell9.setCellValue(record.getR0070_2_3months().doubleValue());
R0070cell9.setCellStyle(numberStyle);
} else {
R0070cell9.setCellValue("");
R0070cell9.setCellStyle(textStyle);
}

//ROW16
//Column K: 
Cell R0070cell10 = row.createCell(10);
if (record.getR0070_3_6months() != null) {
R0070cell10.setCellValue(record.getR0070_3_6months().doubleValue());
R0070cell10.setCellStyle(numberStyle);
} else {
R0070cell10.setCellValue("");
R0070cell10.setCellStyle(textStyle);
}

//ROW16
//Column L: 
Cell R0070cell11 = row.createCell(11);
if (record.getR0070_6_12months() != null) {
R0070cell11.setCellValue(record.getR0070_6_12months().doubleValue());
R0070cell11.setCellStyle(numberStyle);
} else {
R0070cell11.setCellValue("");
R0070cell11.setCellStyle(textStyle);
}

//ROW16
//Column M: 
Cell R0070cell12 = row.createCell(12);
if (record.getR0070_1_2years() != null) {
R0070cell12.setCellValue(record.getR0070_1_2years().doubleValue());
R0070cell12.setCellStyle(numberStyle);
} else {
R0070cell12.setCellValue("");
R0070cell12.setCellStyle(textStyle);
}

//ROW16
//Column N: 
Cell R0070cell13 = row.createCell(13);
if (record.getR0070_2_3years() != null) {
R0070cell13.setCellValue(record.getR0070_2_3years().doubleValue());
R0070cell13.setCellStyle(numberStyle);
} else {
R0070cell13.setCellValue("");
R0070cell13.setCellStyle(textStyle);
}

//ROW16
//Column O: 
Cell R0070cell14 = row.createCell(14);
if (record.getR0070_3_4years() != null) {
R0070cell14.setCellValue(record.getR0070_3_4years().doubleValue());
R0070cell14.setCellStyle(numberStyle);
} else {
R0070cell14.setCellValue("");
R0070cell14.setCellStyle(textStyle);
}

//ROW16
//Column P: 
Cell R0070cell15 = row.createCell(15);
if (record.getR0070_4_5years() != null) {
R0070cell15.setCellValue(record.getR0070_4_5years().doubleValue());
R0070cell15.setCellStyle(numberStyle);
} else {
R0070cell15.setCellValue("");
R0070cell15.setCellStyle(textStyle);
}

//ROW16
//Column Q: 
Cell R0070cell16 = row.createCell(16);
if (record.getR0070_5years() != null) {
R0070cell16.setCellValue(record.getR0070_5years().doubleValue());
R0070cell16.setCellStyle(numberStyle);
} else {
R0070cell16.setCellValue("");
R0070cell16.setCellStyle(textStyle);
}

//ROW16
//Column R: 
Cell R0070cell17 = row.createCell(17);
if (record.getR0070_non_interest() != null) {
R0070cell17.setCellValue(record.getR0070_non_interest().doubleValue());
R0070cell17.setCellStyle(numberStyle);
} else {
R0070cell17.setCellValue("");
R0070cell17.setCellStyle(textStyle);
}

/////ROW17///////////
//ROW17
//Column E: 
row = sheet.getRow(16);
Cell R0080cell4 = row.createCell(4);
if (record.getR0080_overdraft() != null) {
R0080cell4.setCellValue(record.getR0080_overdraft().doubleValue());
R0080cell4.setCellStyle(numberStyle);
} else {
R0080cell4.setCellValue("");
R0080cell4.setCellStyle(textStyle);
}

//ROW17
//Column F: 
Cell R0080cell5 = row.createCell(5);
if (record.getR0080_0_7days() != null) {
R0080cell5.setCellValue(record.getR0080_0_7days().doubleValue());
R0080cell5.setCellStyle(numberStyle);
} else {
R0080cell5.setCellValue("");
R0080cell5.setCellStyle(textStyle);
}

//ROW17
//Column G: 
Cell R0080cell6 = row.createCell(6);
if (record.getR0080_8_14days() != null) {
R0080cell6.setCellValue(record.getR0080_8_14days().doubleValue());
R0080cell6.setCellStyle(numberStyle);
} else {
R0080cell6.setCellValue("");
R0080cell6.setCellStyle(textStyle);
}

//ROW17
//Column H: 
Cell R0080cell7 = row.createCell(7);
if (record.getR0080_15days_1months() != null) {
R0080cell7.setCellValue(record.getR0080_15days_1months().doubleValue());
R0080cell7.setCellStyle(numberStyle);
} else {
R0080cell7.setCellValue("");
R0080cell7.setCellStyle(textStyle);
}

//ROW17
//Column I: 
Cell R0080cell8 = row.createCell(8);
if (record.getR0080_1_2months() != null) {
R0080cell8.setCellValue(record.getR0080_1_2months().doubleValue());
R0080cell8.setCellStyle(numberStyle);
} else {
R0080cell8.setCellValue("");
R0080cell8.setCellStyle(textStyle);
}
		
		
//ROW17
//Column J: 
Cell R0080cell9 = row.createCell(9);
if (record.getR0080_2_3months() != null) {
R0080cell9.setCellValue(record.getR0080_2_3months().doubleValue());
R0080cell9.setCellStyle(numberStyle);
} else {
R0080cell9.setCellValue("");
R0080cell9.setCellStyle(textStyle);
}

//ROW17
//Column K: 
Cell R0080cell10 = row.createCell(10);
if (record.getR0080_3_6months() != null) {
R0080cell10.setCellValue(record.getR0080_3_6months().doubleValue());
R0080cell10.setCellStyle(numberStyle);
} else {
R0080cell10.setCellValue("");
R0080cell10.setCellStyle(textStyle);
}

//ROW17
//Column L: 
Cell R0080cell11 = row.createCell(11);
if (record.getR0080_6_12months() != null) {
R0080cell11.setCellValue(record.getR0080_6_12months().doubleValue());
R0080cell11.setCellStyle(numberStyle);
} else {
R0080cell11.setCellValue("");
R0080cell11.setCellStyle(textStyle);
}

//ROW17
//Column M: 
Cell R0080cell12 = row.createCell(12);
if (record.getR0080_1_2years() != null) {
R0080cell12.setCellValue(record.getR0080_1_2years().doubleValue());
R0080cell12.setCellStyle(numberStyle);
} else {
R0080cell12.setCellValue("");
R0080cell12.setCellStyle(textStyle);
}

//ROW17
//Column N: 
Cell R0080cell13 = row.createCell(13);
if (record.getR0080_2_3years() != null) {
R0080cell13.setCellValue(record.getR0080_2_3years().doubleValue());
R0080cell13.setCellStyle(numberStyle);
} else {
R0080cell13.setCellValue("");
R0080cell13.setCellStyle(textStyle);
}

//ROW17
//Column O: 
Cell R0080cell14 = row.createCell(14);
if (record.getR0080_3_4years() != null) {
R0080cell14.setCellValue(record.getR0080_3_4years().doubleValue());
R0080cell14.setCellStyle(numberStyle);
} else {
R0080cell14.setCellValue("");
R0080cell14.setCellStyle(textStyle);
}

//ROW17
//Column P: 
Cell R0080cell15 = row.createCell(15);
if (record.getR0080_4_5years() != null) {
R0080cell15.setCellValue(record.getR0080_4_5years().doubleValue());
R0080cell15.setCellStyle(numberStyle);
} else {
R0080cell15.setCellValue("");
R0080cell15.setCellStyle(textStyle);
}

//ROW17
//Column Q: 
Cell R0080cell16 = row.createCell(16);
if (record.getR0080_5years() != null) {
R0080cell16.setCellValue(record.getR0080_5years().doubleValue());
R0080cell16.setCellStyle(numberStyle);
} else {
R0080cell16.setCellValue("");
R0080cell16.setCellStyle(textStyle);
}

//ROW17
//Column R: 
Cell R0080cell17 = row.createCell(17);
if (record.getR0080_non_interest() != null) {
R0080cell17.setCellValue(record.getR0080_non_interest().doubleValue());
R0080cell17.setCellStyle(numberStyle);
} else {
R0080cell17.setCellValue("");
R0080cell17.setCellStyle(textStyle);
}

/////ROW18///////////
//ROW18
//Column E: 
row = sheet.getRow(17);
Cell R0090cell4 = row.createCell(4);
if (record.getR0090_overdraft() != null) {
R0090cell4.setCellValue(record.getR0090_overdraft().doubleValue());
R0090cell4.setCellStyle(numberStyle);
} else {
R0090cell4.setCellValue("");
R0090cell4.setCellStyle(textStyle);
}

//ROW18
//Column F: 
Cell R0090cell5 = row.createCell(5);
if (record.getR0090_0_7days() != null) {
R0090cell5.setCellValue(record.getR0090_0_7days().doubleValue());
R0090cell5.setCellStyle(numberStyle);
} else {
R0090cell5.setCellValue("");
R0090cell5.setCellStyle(textStyle);
}

//ROW18
//Column G: 
Cell R0090cell6 = row.createCell(6);
if (record.getR0090_8_14days() != null) {
R0090cell6.setCellValue(record.getR0090_8_14days().doubleValue());
R0090cell6.setCellStyle(numberStyle);
} else {
R0090cell6.setCellValue("");
R0090cell6.setCellStyle(textStyle);
}

//ROW18
//Column H: 
Cell R0090cell7 = row.createCell(7);
if (record.getR0090_15days_1months() != null) {
R0090cell7.setCellValue(record.getR0090_15days_1months().doubleValue());
R0090cell7.setCellStyle(numberStyle);
} else {
R0090cell7.setCellValue("");
R0090cell7.setCellStyle(textStyle);
}

//ROW18
//Column I: 
Cell R0090cell8 = row.createCell(8);
if (record.getR0090_1_2months() != null) {
R0090cell8.setCellValue(record.getR0090_1_2months().doubleValue());
R0090cell8.setCellStyle(numberStyle);
} else {
R0090cell8.setCellValue("");
R0090cell8.setCellStyle(textStyle);
}
		
		
//ROW18
//Column J: 
Cell R0090cell9 = row.createCell(9);
if (record.getR0090_2_3months() != null) {
R0090cell9.setCellValue(record.getR0090_2_3months().doubleValue());
R0090cell9.setCellStyle(numberStyle);
} else {
R0090cell9.setCellValue("");
R0090cell9.setCellStyle(textStyle);
}

//ROW18
//Column K: 
Cell R0090cell10 = row.createCell(10);
if (record.getR0090_3_6months() != null) {
R0090cell10.setCellValue(record.getR0090_3_6months().doubleValue());
R0090cell10.setCellStyle(numberStyle);
} else {
R0090cell10.setCellValue("");
R0090cell10.setCellStyle(textStyle);
}

//ROW18
//Column L: 
Cell R0090cell11 = row.createCell(11);
if (record.getR0090_6_12months() != null) {
R0090cell11.setCellValue(record.getR0090_6_12months().doubleValue());
R0090cell11.setCellStyle(numberStyle);
} else {
R0090cell11.setCellValue("");
R0090cell11.setCellStyle(textStyle);
}

//ROW18
//Column M: 
Cell R0090cell12 = row.createCell(12);
if (record.getR0090_1_2years() != null) {
R0090cell12.setCellValue(record.getR0090_1_2years().doubleValue());
R0090cell12.setCellStyle(numberStyle);
} else {
R0090cell12.setCellValue("");
R0090cell12.setCellStyle(textStyle);
}

//ROW18
//Column N: 
Cell R0090cell13 = row.createCell(13);
if (record.getR0090_2_3years() != null) {
R0090cell13.setCellValue(record.getR0090_2_3years().doubleValue());
R0090cell13.setCellStyle(numberStyle);
} else {
R0090cell13.setCellValue("");
R0090cell13.setCellStyle(textStyle);
}

//ROW18
//Column O: 
Cell R0090cell14 = row.createCell(14);
if (record.getR0090_3_4years() != null) {
R0090cell14.setCellValue(record.getR0090_3_4years().doubleValue());
R0090cell14.setCellStyle(numberStyle);
} else {
R0090cell14.setCellValue("");
R0090cell14.setCellStyle(textStyle);
}

//ROW18
//Column P: 
Cell R0090cell15 = row.createCell(15);
if (record.getR0090_4_5years() != null) {
R0090cell15.setCellValue(record.getR0090_4_5years().doubleValue());
R0090cell15.setCellStyle(numberStyle);
} else {
R0090cell15.setCellValue("");
R0090cell15.setCellStyle(textStyle);
}

//ROW18
//Column Q: 
Cell R0090cell16 = row.createCell(16);
if (record.getR0090_5years() != null) {
R0090cell16.setCellValue(record.getR0090_5years().doubleValue());
R0090cell16.setCellStyle(numberStyle);
} else {
R0090cell16.setCellValue("");
R0090cell16.setCellStyle(textStyle);
}

//ROW18
//Column R: 
Cell R0090cell17 = row.createCell(17);
if (record.getR0090_non_interest() != null) {
R0090cell17.setCellValue(record.getR0090_non_interest().doubleValue());
R0090cell17.setCellStyle(numberStyle);
} else {
R0090cell17.setCellValue("");
R0090cell17.setCellStyle(textStyle);
}

/////ROW20///////////
//ROW20
//Column E: 
row = sheet.getRow(19);
Cell R0100cell4 = row.createCell(4);
if (record.getR0100_overdraft() != null) {
R0100cell4.setCellValue(record.getR0100_overdraft().doubleValue());
R0100cell4.setCellStyle(numberStyle);
} else {
R0100cell4.setCellValue("");
R0100cell4.setCellStyle(textStyle);
}

//ROW20
//Column F: 
Cell R0100cell5 = row.createCell(5);
if (record.getR0100_0_7days() != null) {
R0100cell5.setCellValue(record.getR0100_0_7days().doubleValue());
R0100cell5.setCellStyle(numberStyle);
} else {
R0100cell5.setCellValue("");
R0100cell5.setCellStyle(textStyle);
}

//ROW20
//Column G: 
Cell R0100cell6 = row.createCell(6);
if (record.getR0100_8_14days() != null) {
R0100cell6.setCellValue(record.getR0100_8_14days().doubleValue());
R0100cell6.setCellStyle(numberStyle);
} else {
R0100cell6.setCellValue("");
R0100cell6.setCellStyle(textStyle);
}

//ROW20
//Column H: 
Cell R0100cell7 = row.createCell(7);
if (record.getR0100_15days_1months() != null) {
R0100cell7.setCellValue(record.getR0100_15days_1months().doubleValue());
R0100cell7.setCellStyle(numberStyle);
} else {
R0100cell7.setCellValue("");
R0100cell7.setCellStyle(textStyle);
}

//ROW20
//Column I: 
Cell R0100cell8 = row.createCell(8);
if (record.getR0100_1_2months() != null) {
R0100cell8.setCellValue(record.getR0100_1_2months().doubleValue());
R0100cell8.setCellStyle(numberStyle);
} else {
R0100cell8.setCellValue("");
R0100cell8.setCellStyle(textStyle);
}
		
		
//ROW20
//Column J: 
Cell R0100cell9 = row.createCell(9);
if (record.getR0100_2_3months() != null) {
R0100cell9.setCellValue(record.getR0100_2_3months().doubleValue());
R0100cell9.setCellStyle(numberStyle);
} else {
R0100cell9.setCellValue("");
R0100cell9.setCellStyle(textStyle);
}

//ROW20
//Column K: 
Cell R0100cell10 = row.createCell(10);
if (record.getR0100_3_6months() != null) {
R0100cell10.setCellValue(record.getR0100_3_6months().doubleValue());
R0100cell10.setCellStyle(numberStyle);
} else {
R0100cell10.setCellValue("");
R0100cell10.setCellStyle(textStyle);
}

//ROW20
//Column L: 
Cell R0100cell11 = row.createCell(11);
if (record.getR0100_6_12months() != null) {
R0100cell11.setCellValue(record.getR0100_6_12months().doubleValue());
R0100cell11.setCellStyle(numberStyle);
} else {
R0100cell11.setCellValue("");
R0100cell11.setCellStyle(textStyle);
}

//ROW20
//Column M: 
Cell R0100cell12 = row.createCell(12);
if (record.getR0100_1_2years() != null) {
R0100cell12.setCellValue(record.getR0100_1_2years().doubleValue());
R0100cell12.setCellStyle(numberStyle);
} else {
R0100cell12.setCellValue("");
R0100cell12.setCellStyle(textStyle);
}

//ROW20
//Column N: 
Cell R0100cell13 = row.createCell(13);
if (record.getR0100_2_3years() != null) {
R0100cell13.setCellValue(record.getR0100_2_3years().doubleValue());
R0100cell13.setCellStyle(numberStyle);
} else {
R0100cell13.setCellValue("");
R0100cell13.setCellStyle(textStyle);
}

//ROW20
//Column O: 
Cell R0100cell14 = row.createCell(14);
if (record.getR0100_3_4years() != null) {
R0100cell14.setCellValue(record.getR0100_3_4years().doubleValue());
R0100cell14.setCellStyle(numberStyle);
} else {
R0100cell14.setCellValue("");
R0100cell14.setCellStyle(textStyle);
}

//ROW20
//Column P: 
Cell R0100cell15 = row.createCell(15);
if (record.getR0100_4_5years() != null) {
R0100cell15.setCellValue(record.getR0100_4_5years().doubleValue());
R0100cell15.setCellStyle(numberStyle);
} else {
R0100cell15.setCellValue("");
R0100cell15.setCellStyle(textStyle);
}

//ROW20
//Column Q: 
Cell R0100cell16 = row.createCell(16);
if (record.getR0100_5years() != null) {
R0100cell16.setCellValue(record.getR0100_5years().doubleValue());
R0100cell16.setCellStyle(numberStyle);
} else {
R0100cell16.setCellValue("");
R0100cell16.setCellStyle(textStyle);
}

//ROW20
//Column R: 
Cell R0100cell17 = row.createCell(17);
if (record.getR0100_non_interest() != null) {
R0100cell17.setCellValue(record.getR0100_non_interest().doubleValue());
R0100cell17.setCellStyle(numberStyle);
} else {
R0100cell17.setCellValue("");
R0100cell17.setCellStyle(textStyle);
}

/////ROW20///////////
//ROW20
//Column E: 
row = sheet.getRow(19);
Cell R0110cell4 = row.createCell(4);
if (record.getR0110_overdraft() != null) {
R0110cell4.setCellValue(record.getR0110_overdraft().doubleValue());
R0110cell4.setCellStyle(numberStyle);
} else {
R0110cell4.setCellValue("");
R0110cell4.setCellStyle(textStyle);
}

//ROW20
//Column F: 
Cell R0110cell5 = row.createCell(5);
if (record.getR0110_0_7days() != null) {
R0110cell5.setCellValue(record.getR0110_0_7days().doubleValue());
R0110cell5.setCellStyle(numberStyle);
} else {
R0110cell5.setCellValue("");
R0110cell5.setCellStyle(textStyle);
}

//ROW20
//Column G: 
Cell R0110cell6 = row.createCell(6);
if (record.getR0110_8_14days() != null) {
R0110cell6.setCellValue(record.getR0110_8_14days().doubleValue());
R0110cell6.setCellStyle(numberStyle);
} else {
R0110cell6.setCellValue("");
R0110cell6.setCellStyle(textStyle);
}

//ROW20
//Column H: 
Cell R0110cell7 = row.createCell(7);
if (record.getR0110_15days_1months() != null) {
R0110cell7.setCellValue(record.getR0110_15days_1months().doubleValue());
R0110cell7.setCellStyle(numberStyle);
} else {
R0110cell7.setCellValue("");
R0110cell7.setCellStyle(textStyle);
}

//ROW20
//Column I: 
Cell R0110cell8 = row.createCell(8);
if (record.getR0110_1_2months() != null) {
R0110cell8.setCellValue(record.getR0110_1_2months().doubleValue());
R0110cell8.setCellStyle(numberStyle);
} else {
R0110cell8.setCellValue("");
R0110cell8.setCellStyle(textStyle);
}
		
		
//ROW20
//Column J: 
Cell R0110cell9 = row.createCell(9);
if (record.getR0110_2_3months() != null) {
R0110cell9.setCellValue(record.getR0110_2_3months().doubleValue());
R0110cell9.setCellStyle(numberStyle);
} else {
R0110cell9.setCellValue("");
R0110cell9.setCellStyle(textStyle);
}

//ROW20
//Column K: 
Cell R0110cell10 = row.createCell(10);
if (record.getR0110_3_6months() != null) {
R0110cell10.setCellValue(record.getR0110_3_6months().doubleValue());
R0110cell10.setCellStyle(numberStyle);
} else {
R0110cell10.setCellValue("");
R0110cell10.setCellStyle(textStyle);
}

//ROW20
//Column L: 
Cell R0110cell11 = row.createCell(11);
if (record.getR0110_6_12months() != null) {
R0110cell11.setCellValue(record.getR0110_6_12months().doubleValue());
R0110cell11.setCellStyle(numberStyle);
} else {
R0110cell11.setCellValue("");
R0110cell11.setCellStyle(textStyle);
}

//ROW20
//Column M: 
Cell R0110cell12 = row.createCell(12);
if (record.getR0110_1_2years() != null) {
R0110cell12.setCellValue(record.getR0110_1_2years().doubleValue());
R0110cell12.setCellStyle(numberStyle);
} else {
R0110cell12.setCellValue("");
R0110cell12.setCellStyle(textStyle);
}

//ROW20
//Column N: 
Cell R0110cell13 = row.createCell(13);
if (record.getR0110_2_3years() != null) {
R0110cell13.setCellValue(record.getR0110_2_3years().doubleValue());
R0110cell13.setCellStyle(numberStyle);
} else {
R0110cell13.setCellValue("");
R0110cell13.setCellStyle(textStyle);
}

//ROW20
//Column O: 
Cell R0110cell14 = row.createCell(14);
if (record.getR0110_3_4years() != null) {
R0110cell14.setCellValue(record.getR0110_3_4years().doubleValue());
R0110cell14.setCellStyle(numberStyle);
} else {
R0110cell14.setCellValue("");
R0110cell14.setCellStyle(textStyle);
}

//ROW20
//Column P: 
Cell R0110cell15 = row.createCell(15);
if (record.getR0110_4_5years() != null) {
R0110cell15.setCellValue(record.getR0110_4_5years().doubleValue());
R0110cell15.setCellStyle(numberStyle);
} else {
R0110cell15.setCellValue("");
R0110cell15.setCellStyle(textStyle);
}

//ROW20
//Column Q: 
Cell R0110cell16 = row.createCell(16);
if (record.getR0110_5years() != null) {
R0110cell16.setCellValue(record.getR0110_5years().doubleValue());
R0110cell16.setCellStyle(numberStyle);
} else {
R0110cell16.setCellValue("");
R0110cell16.setCellStyle(textStyle);
}

//ROW20
//Column R: 
Cell R0110cell17 = row.createCell(17);
if (record.getR0110_non_interest() != null) {
R0110cell17.setCellValue(record.getR0110_non_interest().doubleValue());
R0110cell17.setCellStyle(numberStyle);
} else {
R0110cell17.setCellValue("");
R0110cell17.setCellStyle(textStyle);
}


/////ROW21///////////
//ROW21
//Column E: 
row = sheet.getRow(20);
Cell R0120cell4 = row.createCell(4);
if (record.getR0120_overdraft() != null) {
R0120cell4.setCellValue(record.getR0120_overdraft().doubleValue());
R0120cell4.setCellStyle(numberStyle);
} else {
R0120cell4.setCellValue("");
R0120cell4.setCellStyle(textStyle);
}

//ROW21
//Column F: 
Cell R0120cell5 = row.createCell(5);
if (record.getR0120_0_7days() != null) {
R0120cell5.setCellValue(record.getR0120_0_7days().doubleValue());
R0120cell5.setCellStyle(numberStyle);
} else {
R0120cell5.setCellValue("");
R0120cell5.setCellStyle(textStyle);
}

//ROW21
//Column G: 
Cell R0120cell6 = row.createCell(6);
if (record.getR0120_8_14days() != null) {
R0120cell6.setCellValue(record.getR0120_8_14days().doubleValue());
R0120cell6.setCellStyle(numberStyle);
} else {
R0120cell6.setCellValue("");
R0120cell6.setCellStyle(textStyle);
}

//ROW21
//Column H: 
Cell R0120cell7 = row.createCell(7);
if (record.getR0120_15days_1months() != null) {
R0120cell7.setCellValue(record.getR0120_15days_1months().doubleValue());
R0120cell7.setCellStyle(numberStyle);
} else {
R0120cell7.setCellValue("");
R0120cell7.setCellStyle(textStyle);
}

//ROW21
//Column I: 
Cell R0120cell8 = row.createCell(8);
if (record.getR0120_1_2months() != null) {
R0120cell8.setCellValue(record.getR0120_1_2months().doubleValue());
R0120cell8.setCellStyle(numberStyle);
} else {
R0120cell8.setCellValue("");
R0120cell8.setCellStyle(textStyle);
}
		
		
//ROW21
//Column J: 
Cell R0120cell9 = row.createCell(9);
if (record.getR0120_2_3months() != null) {
R0120cell9.setCellValue(record.getR0120_2_3months().doubleValue());
R0120cell9.setCellStyle(numberStyle);
} else {
R0120cell9.setCellValue("");
R0120cell9.setCellStyle(textStyle);
}

//ROW21
//Column K: 
Cell R0120cell10 = row.createCell(10);
if (record.getR0120_3_6months() != null) {
R0120cell10.setCellValue(record.getR0120_3_6months().doubleValue());
R0120cell10.setCellStyle(numberStyle);
} else {
R0120cell10.setCellValue("");
R0120cell10.setCellStyle(textStyle);
}

//ROW21
//Column L: 
Cell R0120cell11 = row.createCell(11);
if (record.getR0120_6_12months() != null) {
R0120cell11.setCellValue(record.getR0120_6_12months().doubleValue());
R0120cell11.setCellStyle(numberStyle);
} else {
R0120cell11.setCellValue("");
R0120cell11.setCellStyle(textStyle);
}

//ROW21
//Column M: 
Cell R0120cell12 = row.createCell(12);
if (record.getR0120_1_2years() != null) {
R0120cell12.setCellValue(record.getR0120_1_2years().doubleValue());
R0120cell12.setCellStyle(numberStyle);
} else {
R0120cell12.setCellValue("");
R0120cell12.setCellStyle(textStyle);
}

//ROW21
//Column N: 
Cell R0120cell13 = row.createCell(13);
if (record.getR0120_2_3years() != null) {
R0120cell13.setCellValue(record.getR0120_2_3years().doubleValue());
R0120cell13.setCellStyle(numberStyle);
} else {
R0120cell13.setCellValue("");
R0120cell13.setCellStyle(textStyle);
}

//ROW21
//Column O: 
Cell R0120cell14 = row.createCell(14);
if (record.getR0120_3_4years() != null) {
R0120cell14.setCellValue(record.getR0120_3_4years().doubleValue());
R0120cell14.setCellStyle(numberStyle);
} else {
R0120cell14.setCellValue("");
R0120cell14.setCellStyle(textStyle);
}

//ROW21
//Column P: 
Cell R0120cell15 = row.createCell(15);
if (record.getR0120_4_5years() != null) {
R0120cell15.setCellValue(record.getR0120_4_5years().doubleValue());
R0120cell15.setCellStyle(numberStyle);
} else {
R0120cell15.setCellValue("");
R0120cell15.setCellStyle(textStyle);
}

//ROW21
//Column Q: 
Cell R0120cell16 = row.createCell(16);
if (record.getR0120_5years() != null) {
R0120cell16.setCellValue(record.getR0120_5years().doubleValue());
R0120cell16.setCellStyle(numberStyle);
} else {
R0120cell16.setCellValue("");
R0120cell16.setCellStyle(textStyle);
}

//ROW21
//Column R: 
Cell R0120cell17 = row.createCell(17);
if (record.getR0120_non_interest() != null) {
R0120cell17.setCellValue(record.getR0120_non_interest().doubleValue());
R0120cell17.setCellStyle(numberStyle);
} else {
R0120cell17.setCellValue("");
R0120cell17.setCellStyle(textStyle);
}

/////ROW22///////////
//ROW22
//Column E: 
row = sheet.getRow(21);
Cell R0130cell4 = row.createCell(4);
if (record.getR0130_overdraft() != null) {
R0130cell4.setCellValue(record.getR0130_overdraft().doubleValue());
R0130cell4.setCellStyle(numberStyle);
} else {
R0130cell4.setCellValue("");
R0130cell4.setCellStyle(textStyle);
}

//ROW22
//Column F: 
Cell R0130cell5 = row.createCell(5);
if (record.getR0130_0_7days() != null) {
R0130cell5.setCellValue(record.getR0130_0_7days().doubleValue());
R0130cell5.setCellStyle(numberStyle);
} else {
R0130cell5.setCellValue("");
R0130cell5.setCellStyle(textStyle);
}

//ROW22
//Column G: 
Cell R0130cell6 = row.createCell(6);
if (record.getR0130_8_14days() != null) {
R0130cell6.setCellValue(record.getR0130_8_14days().doubleValue());
R0130cell6.setCellStyle(numberStyle);
} else {
R0130cell6.setCellValue("");
R0130cell6.setCellStyle(textStyle);
}

//ROW22
//Column H: 
Cell R0130cell7 = row.createCell(7);
if (record.getR0130_15days_1months() != null) {
R0130cell7.setCellValue(record.getR0130_15days_1months().doubleValue());
R0130cell7.setCellStyle(numberStyle);
} else {
R0130cell7.setCellValue("");
R0130cell7.setCellStyle(textStyle);
}

//ROW22
//Column I: 
Cell R0130cell8 = row.createCell(8);
if (record.getR0130_1_2months() != null) {
R0130cell8.setCellValue(record.getR0130_1_2months().doubleValue());
R0130cell8.setCellStyle(numberStyle);
} else {
R0130cell8.setCellValue("");
R0130cell8.setCellStyle(textStyle);
}
		
		
//ROW22
//Column J: 
Cell R0130cell9 = row.createCell(9);
if (record.getR0130_2_3months() != null) {
R0130cell9.setCellValue(record.getR0130_2_3months().doubleValue());
R0130cell9.setCellStyle(numberStyle);
} else {
R0130cell9.setCellValue("");
R0130cell9.setCellStyle(textStyle);
}

//ROW22
//Column K: 
Cell R0130cell10 = row.createCell(10);
if (record.getR0130_3_6months() != null) {
R0130cell10.setCellValue(record.getR0130_3_6months().doubleValue());
R0130cell10.setCellStyle(numberStyle);
} else {
R0130cell10.setCellValue("");
R0130cell10.setCellStyle(textStyle);
}

//ROW22
//Column L: 
Cell R0130cell11 = row.createCell(11);
if (record.getR0130_6_12months() != null) {
R0130cell11.setCellValue(record.getR0130_6_12months().doubleValue());
R0130cell11.setCellStyle(numberStyle);
} else {
R0130cell11.setCellValue("");
R0130cell11.setCellStyle(textStyle);
}

//ROW22
//Column M: 
Cell R0130cell12 = row.createCell(12);
if (record.getR0130_1_2years() != null) {
R0130cell12.setCellValue(record.getR0130_1_2years().doubleValue());
R0130cell12.setCellStyle(numberStyle);
} else {
R0130cell12.setCellValue("");
R0130cell12.setCellStyle(textStyle);
}

//ROW22
//Column N: 
Cell R0130cell13 = row.createCell(13);
if (record.getR0130_2_3years() != null) {
R0130cell13.setCellValue(record.getR0130_2_3years().doubleValue());
R0130cell13.setCellStyle(numberStyle);
} else {
R0130cell13.setCellValue("");
R0130cell13.setCellStyle(textStyle);
}

//ROW22
//Column O: 
Cell R0130cell14 = row.createCell(14);
if (record.getR0130_3_4years() != null) {
R0130cell14.setCellValue(record.getR0130_3_4years().doubleValue());
R0130cell14.setCellStyle(numberStyle);
} else {
R0130cell14.setCellValue("");
R0130cell14.setCellStyle(textStyle);
}

//ROW22
//Column P: 
Cell R0130cell15 = row.createCell(15);
if (record.getR0130_4_5years() != null) {
R0130cell15.setCellValue(record.getR0130_4_5years().doubleValue());
R0130cell15.setCellStyle(numberStyle);
} else {
R0130cell15.setCellValue("");
R0130cell15.setCellStyle(textStyle);
}

//ROW22
//Column Q: 
Cell R0130cell16 = row.createCell(16);
if (record.getR0130_5years() != null) {
R0130cell16.setCellValue(record.getR0130_5years().doubleValue());
R0130cell16.setCellStyle(numberStyle);
} else {
R0130cell16.setCellValue("");
R0130cell16.setCellStyle(textStyle);
}

//ROW22
//Column R: 
Cell R0130cell17 = row.createCell(17);
if (record.getR0130_non_interest() != null) {
R0130cell17.setCellValue(record.getR0130_non_interest().doubleValue());
R0130cell17.setCellStyle(numberStyle);
} else {
R0130cell17.setCellValue("");
R0130cell17.setCellStyle(textStyle);
}

/////ROW23///////////
//ROW23
//Column E: 
row = sheet.getRow(22);
Cell R0140cell4 = row.createCell(4);
if (record.getR0140_overdraft() != null) {
R0140cell4.setCellValue(record.getR0140_overdraft().doubleValue());
R0140cell4.setCellStyle(numberStyle);
} else {
R0140cell4.setCellValue("");
R0140cell4.setCellStyle(textStyle);
}

//ROW23
//Column F: 
Cell R0140cell5 = row.createCell(5);
if (record.getR0140_0_7days() != null) {
R0140cell5.setCellValue(record.getR0140_0_7days().doubleValue());
R0140cell5.setCellStyle(numberStyle);
} else {
R0140cell5.setCellValue("");
R0140cell5.setCellStyle(textStyle);
}

//ROW23
//Column G: 
Cell R0140cell6 = row.createCell(6);
if (record.getR0140_8_14days() != null) {
R0140cell6.setCellValue(record.getR0140_8_14days().doubleValue());
R0140cell6.setCellStyle(numberStyle);
} else {
R0140cell6.setCellValue("");
R0140cell6.setCellStyle(textStyle);
}

//ROW23
//Column H: 
Cell R0140cell7 = row.createCell(7);
if (record.getR0140_15days_1months() != null) {
R0140cell7.setCellValue(record.getR0140_15days_1months().doubleValue());
R0140cell7.setCellStyle(numberStyle);
} else {
R0140cell7.setCellValue("");
R0140cell7.setCellStyle(textStyle);
}

//ROW23
//Column I: 
Cell R0140cell8 = row.createCell(8);
if (record.getR0140_1_2months() != null) {
R0140cell8.setCellValue(record.getR0140_1_2months().doubleValue());
R0140cell8.setCellStyle(numberStyle);
} else {
R0140cell8.setCellValue("");
R0140cell8.setCellStyle(textStyle);
}
		
		
//ROW23
//Column J: 
Cell R0140cell9 = row.createCell(9);
if (record.getR0140_2_3months() != null) {
R0140cell9.setCellValue(record.getR0140_2_3months().doubleValue());
R0140cell9.setCellStyle(numberStyle);
} else {
R0140cell9.setCellValue("");
R0140cell9.setCellStyle(textStyle);
}

//ROW23
//Column K: 
Cell R0140cell10 = row.createCell(10);
if (record.getR0140_3_6months() != null) {
R0140cell10.setCellValue(record.getR0140_3_6months().doubleValue());
R0140cell10.setCellStyle(numberStyle);
} else {
R0140cell10.setCellValue("");
R0140cell10.setCellStyle(textStyle);
}

//ROW23
//Column L: 
Cell R0140cell11 = row.createCell(11);
if (record.getR0140_6_12months() != null) {
R0140cell11.setCellValue(record.getR0140_6_12months().doubleValue());
R0140cell11.setCellStyle(numberStyle);
} else {
R0140cell11.setCellValue("");
R0140cell11.setCellStyle(textStyle);
}

//ROW23
//Column M: 
Cell R0140cell12 = row.createCell(12);
if (record.getR0140_1_2years() != null) {
R0140cell12.setCellValue(record.getR0140_1_2years().doubleValue());
R0140cell12.setCellStyle(numberStyle);
} else {
R0140cell12.setCellValue("");
R0140cell12.setCellStyle(textStyle);
}

//ROW23
//Column N: 
Cell R0140cell13 = row.createCell(13);
if (record.getR0140_2_3years() != null) {
R0140cell13.setCellValue(record.getR0140_2_3years().doubleValue());
R0140cell13.setCellStyle(numberStyle);
} else {
R0140cell13.setCellValue("");
R0140cell13.setCellStyle(textStyle);
}

//ROW23
//Column O: 
Cell R0140cell14 = row.createCell(14);
if (record.getR0140_3_4years() != null) {
R0140cell14.setCellValue(record.getR0140_3_4years().doubleValue());
R0140cell14.setCellStyle(numberStyle);
} else {
R0140cell14.setCellValue("");
R0140cell14.setCellStyle(textStyle);
}

//ROW23
//Column P: 
Cell R0140cell15 = row.createCell(15);
if (record.getR0140_4_5years() != null) {
R0140cell15.setCellValue(record.getR0140_4_5years().doubleValue());
R0140cell15.setCellStyle(numberStyle);
} else {
R0140cell15.setCellValue("");
R0140cell15.setCellStyle(textStyle);
}

//ROW23
//Column Q: 
Cell R0140cell16 = row.createCell(16);
if (record.getR0140_5years() != null) {
R0140cell16.setCellValue(record.getR0140_5years().doubleValue());
R0140cell16.setCellStyle(numberStyle);
} else {
R0140cell16.setCellValue("");
R0140cell16.setCellStyle(textStyle);
}

//ROW23
//Column R: 
Cell R0140cell17 = row.createCell(17);
if (record.getR0140_non_interest() != null) {
R0140cell17.setCellValue(record.getR0140_non_interest().doubleValue());
R0140cell17.setCellStyle(numberStyle);
} else {
R0140cell17.setCellValue("");
R0140cell17.setCellStyle(textStyle);
}


/////ROW24///////////
//ROW24
//Column E: 
row = sheet.getRow(23);
Cell R0150cell4 = row.createCell(4);
if (record.getR0150_overdraft() != null) {
R0150cell4.setCellValue(record.getR0150_overdraft().doubleValue());
R0150cell4.setCellStyle(numberStyle);
} else {
R0150cell4.setCellValue("");
R0150cell4.setCellStyle(textStyle);
}

//ROW24
//Column F: 
Cell R0150cell5 = row.createCell(5);
if (record.getR0150_0_7days() != null) {
R0150cell5.setCellValue(record.getR0150_0_7days().doubleValue());
R0150cell5.setCellStyle(numberStyle);
} else {
R0150cell5.setCellValue("");
R0150cell5.setCellStyle(textStyle);
}

//ROW24
//Column G: 
Cell R0150cell6 = row.createCell(6);
if (record.getR0150_8_14days() != null) {
R0150cell6.setCellValue(record.getR0150_8_14days().doubleValue());
R0150cell6.setCellStyle(numberStyle);
} else {
R0150cell6.setCellValue("");
R0150cell6.setCellStyle(textStyle);
}

//ROW24
//Column H: 
Cell R0150cell7 = row.createCell(7);
if (record.getR0150_15days_1months() != null) {
R0150cell7.setCellValue(record.getR0150_15days_1months().doubleValue());
R0150cell7.setCellStyle(numberStyle);
} else {
R0150cell7.setCellValue("");
R0150cell7.setCellStyle(textStyle);
}

//ROW24
//Column I: 
Cell R0150cell8 = row.createCell(8);
if (record.getR0150_1_2months() != null) {
R0150cell8.setCellValue(record.getR0150_1_2months().doubleValue());
R0150cell8.setCellStyle(numberStyle);
} else {
R0150cell8.setCellValue("");
R0150cell8.setCellStyle(textStyle);
}
		
		
//ROW24
//Column J: 
Cell R0150cell9 = row.createCell(9);
if (record.getR0150_2_3months() != null) {
R0150cell9.setCellValue(record.getR0150_2_3months().doubleValue());
R0150cell9.setCellStyle(numberStyle);
} else {
R0150cell9.setCellValue("");
R0150cell9.setCellStyle(textStyle);
}

//ROW24
//Column K: 
Cell R0150cell10 = row.createCell(10);
if (record.getR0150_3_6months() != null) {
R0150cell10.setCellValue(record.getR0150_3_6months().doubleValue());
R0150cell10.setCellStyle(numberStyle);
} else {
R0150cell10.setCellValue("");
R0150cell10.setCellStyle(textStyle);
}

//ROW24
//Column L: 
Cell R0150cell11 = row.createCell(11);
if (record.getR0150_6_12months() != null) {
R0150cell11.setCellValue(record.getR0150_6_12months().doubleValue());
R0150cell11.setCellStyle(numberStyle);
} else {
R0150cell11.setCellValue("");
R0150cell11.setCellStyle(textStyle);
}

//ROW24
//Column M: 
Cell R0150cell12 = row.createCell(12);
if (record.getR0150_1_2years() != null) {
R0150cell12.setCellValue(record.getR0150_1_2years().doubleValue());
R0150cell12.setCellStyle(numberStyle);
} else {
R0150cell12.setCellValue("");
R0150cell12.setCellStyle(textStyle);
}

//ROW24
//Column N: 
Cell R0150cell13 = row.createCell(13);
if (record.getR0150_2_3years() != null) {
R0150cell13.setCellValue(record.getR0150_2_3years().doubleValue());
R0150cell13.setCellStyle(numberStyle);
} else {
R0150cell13.setCellValue("");
R0150cell13.setCellStyle(textStyle);
}

//ROW24
//Column O: 
Cell R0150cell14 = row.createCell(14);
if (record.getR0150_3_4years() != null) {
R0150cell14.setCellValue(record.getR0150_3_4years().doubleValue());
R0150cell14.setCellStyle(numberStyle);
} else {
R0150cell14.setCellValue("");
R0150cell14.setCellStyle(textStyle);
}

//ROW24
//Column P: 
Cell R0150cell15 = row.createCell(15);
if (record.getR0150_4_5years() != null) {
R0150cell15.setCellValue(record.getR0150_4_5years().doubleValue());
R0150cell15.setCellStyle(numberStyle);
} else {
R0150cell15.setCellValue("");
R0150cell15.setCellStyle(textStyle);
}

//ROW24
//Column Q: 
Cell R0150cell16 = row.createCell(16);
if (record.getR0150_5years() != null) {
R0150cell16.setCellValue(record.getR0150_5years().doubleValue());
R0150cell16.setCellStyle(numberStyle);
} else {
R0150cell16.setCellValue("");
R0150cell16.setCellStyle(textStyle);
}

//ROW24
//Column R: 
Cell R0150cell17 = row.createCell(17);
if (record.getR0150_non_interest() != null) {
R0150cell17.setCellValue(record.getR0150_non_interest().doubleValue());
R0150cell17.setCellStyle(numberStyle);
} else {
R0150cell17.setCellValue("");
R0150cell17.setCellStyle(textStyle);
}


/////ROW25///////////
//ROW25
//Column E: 
row = sheet.getRow(24);
Cell R0160cell4 = row.createCell(4);
if (record.getR0160_overdraft() != null) {
R0160cell4.setCellValue(record.getR0160_overdraft().doubleValue());
R0160cell4.setCellStyle(numberStyle);
} else {
R0160cell4.setCellValue("");
R0160cell4.setCellStyle(textStyle);
}

//ROW25
//Column F: 
Cell R0160cell5 = row.createCell(5);
if (record.getR0160_0_7days() != null) {
R0160cell5.setCellValue(record.getR0160_0_7days().doubleValue());
R0160cell5.setCellStyle(numberStyle);
} else {
R0160cell5.setCellValue("");
R0160cell5.setCellStyle(textStyle);
}

//ROW25
//Column G: 
Cell R0160cell6 = row.createCell(6);
if (record.getR0160_8_14days() != null) {
R0160cell6.setCellValue(record.getR0160_8_14days().doubleValue());
R0160cell6.setCellStyle(numberStyle);
} else {
R0160cell6.setCellValue("");
R0160cell6.setCellStyle(textStyle);
}

//ROW25
//Column H: 
Cell R0160cell7 = row.createCell(7);
if (record.getR0160_15days_1months() != null) {
R0160cell7.setCellValue(record.getR0160_15days_1months().doubleValue());
R0160cell7.setCellStyle(numberStyle);
} else {
R0160cell7.setCellValue("");
R0160cell7.setCellStyle(textStyle);
}

//ROW25
//Column I: 
Cell R0160cell8 = row.createCell(8);
if (record.getR0160_1_2months() != null) {
R0160cell8.setCellValue(record.getR0160_1_2months().doubleValue());
R0160cell8.setCellStyle(numberStyle);
} else {
R0160cell8.setCellValue("");
R0160cell8.setCellStyle(textStyle);
}
		
		
//ROW25
//Column J: 
Cell R0160cell9 = row.createCell(9);
if (record.getR0160_2_3months() != null) {
R0160cell9.setCellValue(record.getR0160_2_3months().doubleValue());
R0160cell9.setCellStyle(numberStyle);
} else {
R0160cell9.setCellValue("");
R0160cell9.setCellStyle(textStyle);
}

//ROW25
//Column K: 
Cell R0160cell10 = row.createCell(10);
if (record.getR0160_3_6months() != null) {
R0160cell10.setCellValue(record.getR0160_3_6months().doubleValue());
R0160cell10.setCellStyle(numberStyle);
} else {
R0160cell10.setCellValue("");
R0160cell10.setCellStyle(textStyle);
}

//ROW25
//Column L: 
Cell R0160cell11 = row.createCell(11);
if (record.getR0160_6_12months() != null) {
R0160cell11.setCellValue(record.getR0160_6_12months().doubleValue());
R0160cell11.setCellStyle(numberStyle);
} else {
R0160cell11.setCellValue("");
R0160cell11.setCellStyle(textStyle);
}

//ROW25
//Column M: 
Cell R0160cell12 = row.createCell(12);
if (record.getR0160_1_2years() != null) {
R0160cell12.setCellValue(record.getR0160_1_2years().doubleValue());
R0160cell12.setCellStyle(numberStyle);
} else {
R0160cell12.setCellValue("");
R0160cell12.setCellStyle(textStyle);
}

//ROW25
//Column N: 
Cell R0160cell13 = row.createCell(13);
if (record.getR0160_2_3years() != null) {
R0160cell13.setCellValue(record.getR0160_2_3years().doubleValue());
R0160cell13.setCellStyle(numberStyle);
} else {
R0160cell13.setCellValue("");
R0160cell13.setCellStyle(textStyle);
}

//ROW25
//Column O: 
Cell R0160cell14 = row.createCell(14);
if (record.getR0160_3_4years() != null) {
R0160cell14.setCellValue(record.getR0160_3_4years().doubleValue());
R0160cell14.setCellStyle(numberStyle);
} else {
R0160cell14.setCellValue("");
R0160cell14.setCellStyle(textStyle);
}

//ROW25
//Column P: 
Cell R0160cell15 = row.createCell(15);
if (record.getR0160_4_5years() != null) {
R0160cell15.setCellValue(record.getR0160_4_5years().doubleValue());
R0160cell15.setCellStyle(numberStyle);
} else {
R0160cell15.setCellValue("");
R0160cell15.setCellStyle(textStyle);
}

//ROW25
//Column Q: 
Cell R0160cell16 = row.createCell(16);
if (record.getR0160_5years() != null) {
R0160cell16.setCellValue(record.getR0160_5years().doubleValue());
R0160cell16.setCellStyle(numberStyle);
} else {
R0160cell16.setCellValue("");
R0160cell16.setCellStyle(textStyle);
}

//ROW25
//Column R: 
Cell R0160cell17 = row.createCell(17);
if (record.getR0160_non_interest() != null) {
R0160cell17.setCellValue(record.getR0160_non_interest().doubleValue());
R0160cell17.setCellStyle(numberStyle);
} else {
R0160cell17.setCellValue("");
R0160cell17.setCellStyle(textStyle);
}


/////ROW26///////////
//ROW26
//Column E: 
row = sheet.getRow(25);
Cell R0170cell4 = row.createCell(4);
if (record.getR0170_overdraft() != null) {
R0170cell4.setCellValue(record.getR0170_overdraft().doubleValue());
R0170cell4.setCellStyle(numberStyle);
} else {
R0170cell4.setCellValue("");
R0170cell4.setCellStyle(textStyle);
}

//ROW26
//Column F: 
Cell R0170cell5 = row.createCell(5);
if (record.getR0170_0_7days() != null) {
R0170cell5.setCellValue(record.getR0170_0_7days().doubleValue());
R0170cell5.setCellStyle(numberStyle);
} else {
R0170cell5.setCellValue("");
R0170cell5.setCellStyle(textStyle);
}

//ROW26
//Column G: 
Cell R0170cell6 = row.createCell(6);
if (record.getR0170_8_14days() != null) {
R0170cell6.setCellValue(record.getR0170_8_14days().doubleValue());
R0170cell6.setCellStyle(numberStyle);
} else {
R0170cell6.setCellValue("");
R0170cell6.setCellStyle(textStyle);
}

//ROW26
//Column H: 
Cell R0170cell7 = row.createCell(7);
if (record.getR0170_15days_1months() != null) {
R0170cell7.setCellValue(record.getR0170_15days_1months().doubleValue());
R0170cell7.setCellStyle(numberStyle);
} else {
R0170cell7.setCellValue("");
R0170cell7.setCellStyle(textStyle);
}

//ROW26
//Column I: 
Cell R0170cell8 = row.createCell(8);
if (record.getR0170_1_2months() != null) {
R0170cell8.setCellValue(record.getR0170_1_2months().doubleValue());
R0170cell8.setCellStyle(numberStyle);
} else {
R0170cell8.setCellValue("");
R0170cell8.setCellStyle(textStyle);
}
		
		
//ROW26
//Column J: 
Cell R0170cell9 = row.createCell(9);
if (record.getR0170_2_3months() != null) {
R0170cell9.setCellValue(record.getR0170_2_3months().doubleValue());
R0170cell9.setCellStyle(numberStyle);
} else {
R0170cell9.setCellValue("");
R0170cell9.setCellStyle(textStyle);
}

//ROW26
//Column K: 
Cell R0170cell10 = row.createCell(10);
if (record.getR0170_3_6months() != null) {
R0170cell10.setCellValue(record.getR0170_3_6months().doubleValue());
R0170cell10.setCellStyle(numberStyle);
} else {
R0170cell10.setCellValue("");
R0170cell10.setCellStyle(textStyle);
}

//ROW26
//Column L: 
Cell R0170cell11 = row.createCell(11);
if (record.getR0170_6_12months() != null) {
R0170cell11.setCellValue(record.getR0170_6_12months().doubleValue());
R0170cell11.setCellStyle(numberStyle);
} else {
R0170cell11.setCellValue("");
R0170cell11.setCellStyle(textStyle);
}

//ROW26
//Column M: 
Cell R0170cell12 = row.createCell(12);
if (record.getR0170_1_2years() != null) {
R0170cell12.setCellValue(record.getR0170_1_2years().doubleValue());
R0170cell12.setCellStyle(numberStyle);
} else {
R0170cell12.setCellValue("");
R0170cell12.setCellStyle(textStyle);
}

//ROW26
//Column N: 
Cell R0170cell13 = row.createCell(13);
if (record.getR0170_2_3years() != null) {
R0170cell13.setCellValue(record.getR0170_2_3years().doubleValue());
R0170cell13.setCellStyle(numberStyle);
} else {
R0170cell13.setCellValue("");
R0170cell13.setCellStyle(textStyle);
}

//ROW26
//Column O: 
Cell R0170cell14 = row.createCell(14);
if (record.getR0170_3_4years() != null) {
R0170cell14.setCellValue(record.getR0170_3_4years().doubleValue());
R0170cell14.setCellStyle(numberStyle);
} else {
R0170cell14.setCellValue("");
R0170cell14.setCellStyle(textStyle);
}

//ROW26
//Column P: 
Cell R0170cell15 = row.createCell(15);
if (record.getR0170_4_5years() != null) {
R0170cell15.setCellValue(record.getR0170_4_5years().doubleValue());
R0170cell15.setCellStyle(numberStyle);
} else {
R0170cell15.setCellValue("");
R0170cell15.setCellStyle(textStyle);
}

//ROW26
//Column Q: 
Cell R0170cell16 = row.createCell(16);
if (record.getR0170_5years() != null) {
R0170cell16.setCellValue(record.getR0170_5years().doubleValue());
R0170cell16.setCellStyle(numberStyle);
} else {
R0170cell16.setCellValue("");
R0170cell16.setCellStyle(textStyle);
}

//ROW26
//Column R: 
Cell R0170cell17 = row.createCell(17);
if (record.getR0170_non_interest() != null) {
R0170cell17.setCellValue(record.getR0170_non_interest().doubleValue());
R0170cell17.setCellStyle(numberStyle);
} else {
R0170cell17.setCellValue("");
R0170cell17.setCellStyle(textStyle);
}


/////ROW27///////////
//ROW27
//Column E: 
row = sheet.getRow(26);
Cell R0180cell4 = row.createCell(4);
if (record.getR0180_overdraft() != null) {
R0180cell4.setCellValue(record.getR0180_overdraft().doubleValue());
R0180cell4.setCellStyle(numberStyle);
} else {
R0180cell4.setCellValue("");
R0180cell4.setCellStyle(textStyle);
}

//ROW27
//Column F: 
Cell R0180cell5 = row.createCell(5);
if (record.getR0180_0_7days() != null) {
R0180cell5.setCellValue(record.getR0180_0_7days().doubleValue());
R0180cell5.setCellStyle(numberStyle);
} else {
R0180cell5.setCellValue("");
R0180cell5.setCellStyle(textStyle);
}

//ROW27
//Column G: 
Cell R0180cell6 = row.createCell(6);
if (record.getR0180_8_14days() != null) {
R0180cell6.setCellValue(record.getR0180_8_14days().doubleValue());
R0180cell6.setCellStyle(numberStyle);
} else {
R0180cell6.setCellValue("");
R0180cell6.setCellStyle(textStyle);
}

//ROW27
//Column H: 
Cell R0180cell7 = row.createCell(7);
if (record.getR0180_15days_1months() != null) {
R0180cell7.setCellValue(record.getR0180_15days_1months().doubleValue());
R0180cell7.setCellStyle(numberStyle);
} else {
R0180cell7.setCellValue("");
R0180cell7.setCellStyle(textStyle);
}

//ROW27
//Column I: 
Cell R0180cell8 = row.createCell(8);
if (record.getR0180_1_2months() != null) {
R0180cell8.setCellValue(record.getR0180_1_2months().doubleValue());
R0180cell8.setCellStyle(numberStyle);
} else {
R0180cell8.setCellValue("");
R0180cell8.setCellStyle(textStyle);
}
		
		
//ROW27
//Column J: 
Cell R0180cell9 = row.createCell(9);
if (record.getR0180_2_3months() != null) {
R0180cell9.setCellValue(record.getR0180_2_3months().doubleValue());
R0180cell9.setCellStyle(numberStyle);
} else {
R0180cell9.setCellValue("");
R0180cell9.setCellStyle(textStyle);
}

//ROW27
//Column K: 
Cell R0180cell10 = row.createCell(10);
if (record.getR0180_3_6months() != null) {
R0180cell10.setCellValue(record.getR0180_3_6months().doubleValue());
R0180cell10.setCellStyle(numberStyle);
} else {
R0180cell10.setCellValue("");
R0180cell10.setCellStyle(textStyle);
}

//ROW27
//Column L: 
Cell R0180cell11 = row.createCell(11);
if (record.getR0180_6_12months() != null) {
R0180cell11.setCellValue(record.getR0180_6_12months().doubleValue());
R0180cell11.setCellStyle(numberStyle);
} else {
R0180cell11.setCellValue("");
R0180cell11.setCellStyle(textStyle);
}

//ROW27
//Column M: 
Cell R0180cell12 = row.createCell(12);
if (record.getR0180_1_2years() != null) {
R0180cell12.setCellValue(record.getR0180_1_2years().doubleValue());
R0180cell12.setCellStyle(numberStyle);
} else {
R0180cell12.setCellValue("");
R0180cell12.setCellStyle(textStyle);
}

//ROW27
//Column N: 
Cell R0180cell13 = row.createCell(13);
if (record.getR0180_2_3years() != null) {
R0180cell13.setCellValue(record.getR0180_2_3years().doubleValue());
R0180cell13.setCellStyle(numberStyle);
} else {
R0180cell13.setCellValue("");
R0180cell13.setCellStyle(textStyle);
}

//ROW27
//Column O: 
Cell R0180cell14 = row.createCell(14);
if (record.getR0180_3_4years() != null) {
R0180cell14.setCellValue(record.getR0180_3_4years().doubleValue());
R0180cell14.setCellStyle(numberStyle);
} else {
R0180cell14.setCellValue("");
R0180cell14.setCellStyle(textStyle);
}

//ROW27
//Column P: 
Cell R0180cell15 = row.createCell(15);
if (record.getR0180_4_5years() != null) {
R0180cell15.setCellValue(record.getR0180_4_5years().doubleValue());
R0180cell15.setCellStyle(numberStyle);
} else {
R0180cell15.setCellValue("");
R0180cell15.setCellStyle(textStyle);
}

//ROW27
//Column Q: 
Cell R0180cell16 = row.createCell(16);
if (record.getR0180_5years() != null) {
R0180cell16.setCellValue(record.getR0180_5years().doubleValue());
R0180cell16.setCellStyle(numberStyle);
} else {
R0180cell16.setCellValue("");
R0180cell16.setCellStyle(textStyle);
}

//ROW27
//Column R: 
Cell R0180cell17 = row.createCell(17);
if (record.getR0180_non_interest() != null) {
R0180cell17.setCellValue(record.getR0180_non_interest().doubleValue());
R0180cell17.setCellStyle(numberStyle);
} else {
R0180cell17.setCellValue("");
R0180cell17.setCellStyle(textStyle);
}


/////ROW28///////////
//ROW28
//Column E: 
row = sheet.getRow(27);
Cell R0190cell4 = row.createCell(4);
if (record.getR0190_overdraft() != null) {
R0190cell4.setCellValue(record.getR0190_overdraft().doubleValue());
R0190cell4.setCellStyle(numberStyle);
} else {
R0190cell4.setCellValue("");
R0190cell4.setCellStyle(textStyle);
}

//ROW28
//Column F: 
Cell R0190cell5 = row.createCell(5);
if (record.getR0190_0_7days() != null) {
R0190cell5.setCellValue(record.getR0190_0_7days().doubleValue());
R0190cell5.setCellStyle(numberStyle);
} else {
R0190cell5.setCellValue("");
R0190cell5.setCellStyle(textStyle);
}

//ROW28
//Column G: 
Cell R0190cell6 = row.createCell(6);
if (record.getR0190_8_14days() != null) {
R0190cell6.setCellValue(record.getR0190_8_14days().doubleValue());
R0190cell6.setCellStyle(numberStyle);
} else {
R0190cell6.setCellValue("");
R0190cell6.setCellStyle(textStyle);
}

//ROW28
//Column H: 
Cell R0190cell7 = row.createCell(7);
if (record.getR0190_15days_1months() != null) {
R0190cell7.setCellValue(record.getR0190_15days_1months().doubleValue());
R0190cell7.setCellStyle(numberStyle);
} else {
R0190cell7.setCellValue("");
R0190cell7.setCellStyle(textStyle);
}

//ROW28
//Column I: 
Cell R0190cell8 = row.createCell(8);
if (record.getR0190_1_2months() != null) {
R0190cell8.setCellValue(record.getR0190_1_2months().doubleValue());
R0190cell8.setCellStyle(numberStyle);
} else {
R0190cell8.setCellValue("");
R0190cell8.setCellStyle(textStyle);
}
		
		
//ROW28
//Column J: 
Cell R0190cell9 = row.createCell(9);
if (record.getR0190_2_3months() != null) {
R0190cell9.setCellValue(record.getR0190_2_3months().doubleValue());
R0190cell9.setCellStyle(numberStyle);
} else {
R0190cell9.setCellValue("");
R0190cell9.setCellStyle(textStyle);
}

//ROW28
//Column K: 
Cell R0190cell10 = row.createCell(10);
if (record.getR0190_3_6months() != null) {
R0190cell10.setCellValue(record.getR0190_3_6months().doubleValue());
R0190cell10.setCellStyle(numberStyle);
} else {
R0190cell10.setCellValue("");
R0190cell10.setCellStyle(textStyle);
}

//ROW28
//Column L: 
Cell R0190cell11 = row.createCell(11);
if (record.getR0190_6_12months() != null) {
R0190cell11.setCellValue(record.getR0190_6_12months().doubleValue());
R0190cell11.setCellStyle(numberStyle);
} else {
R0190cell11.setCellValue("");
R0190cell11.setCellStyle(textStyle);
}

//ROW28
//Column M: 
Cell R0190cell12 = row.createCell(12);
if (record.getR0190_1_2years() != null) {
R0190cell12.setCellValue(record.getR0190_1_2years().doubleValue());
R0190cell12.setCellStyle(numberStyle);
} else {
R0190cell12.setCellValue("");
R0190cell12.setCellStyle(textStyle);
}

//ROW28
//Column N: 
Cell R0190cell13 = row.createCell(13);
if (record.getR0190_2_3years() != null) {
R0190cell13.setCellValue(record.getR0190_2_3years().doubleValue());
R0190cell13.setCellStyle(numberStyle);
} else {
R0190cell13.setCellValue("");
R0190cell13.setCellStyle(textStyle);
}

//ROW28
//Column O: 
Cell R0190cell14 = row.createCell(14);
if (record.getR0190_3_4years() != null) {
R0190cell14.setCellValue(record.getR0190_3_4years().doubleValue());
R0190cell14.setCellStyle(numberStyle);
} else {
R0190cell14.setCellValue("");
R0190cell14.setCellStyle(textStyle);
}

//ROW28
//Column P: 
Cell R0190cell15 = row.createCell(15);
if (record.getR0190_4_5years() != null) {
R0190cell15.setCellValue(record.getR0190_4_5years().doubleValue());
R0190cell15.setCellStyle(numberStyle);
} else {
R0190cell15.setCellValue("");
R0190cell15.setCellStyle(textStyle);
}

//ROW28
//Column Q: 
Cell R0190cell16 = row.createCell(16);
if (record.getR0190_5years() != null) {
R0190cell16.setCellValue(record.getR0190_5years().doubleValue());
R0190cell16.setCellStyle(numberStyle);
} else {
R0190cell16.setCellValue("");
R0190cell16.setCellStyle(textStyle);
}

//ROW28
//Column R: 
Cell R0190cell17 = row.createCell(17);
if (record.getR0190_non_interest() != null) {
R0190cell17.setCellValue(record.getR0190_non_interest().doubleValue());
R0190cell17.setCellStyle(numberStyle);
} else {
R0190cell17.setCellValue("");
R0190cell17.setCellStyle(textStyle);
}


/////ROW29///////////
//ROW29
//Column E: 
row = sheet.getRow(28);
Cell R0200cell4 = row.createCell(4);
if (record.getR0200_overdraft() != null) {
R0200cell4.setCellValue(record.getR0200_overdraft().doubleValue());
R0200cell4.setCellStyle(numberStyle);
} else {
R0200cell4.setCellValue("");
R0200cell4.setCellStyle(textStyle);
}

//ROW29
//Column F: 
Cell R0200cell5 = row.createCell(5);
if (record.getR0200_0_7days() != null) {
R0200cell5.setCellValue(record.getR0200_0_7days().doubleValue());
R0200cell5.setCellStyle(numberStyle);
} else {
R0200cell5.setCellValue("");
R0200cell5.setCellStyle(textStyle);
}

//ROW29
//Column G: 
Cell R0200cell6 = row.createCell(6);
if (record.getR0200_8_14days() != null) {
R0200cell6.setCellValue(record.getR0200_8_14days().doubleValue());
R0200cell6.setCellStyle(numberStyle);
} else {
R0200cell6.setCellValue("");
R0200cell6.setCellStyle(textStyle);
}

//ROW29
//Column H: 
Cell R0200cell7 = row.createCell(7);
if (record.getR0200_15days_1months() != null) {
R0200cell7.setCellValue(record.getR0200_15days_1months().doubleValue());
R0200cell7.setCellStyle(numberStyle);
} else {
R0200cell7.setCellValue("");
R0200cell7.setCellStyle(textStyle);
}

//ROW29
//Column I: 
Cell R0200cell8 = row.createCell(8);
if (record.getR0200_1_2months() != null) {
R0200cell8.setCellValue(record.getR0200_1_2months().doubleValue());
R0200cell8.setCellStyle(numberStyle);
} else {
R0200cell8.setCellValue("");
R0200cell8.setCellStyle(textStyle);
}
		
		
//ROW29
//Column J: 
Cell R0200cell9 = row.createCell(9);
if (record.getR0200_2_3months() != null) {
R0200cell9.setCellValue(record.getR0200_2_3months().doubleValue());
R0200cell9.setCellStyle(numberStyle);
} else {
R0200cell9.setCellValue("");
R0200cell9.setCellStyle(textStyle);
}

//ROW29
//Column K: 
Cell R0200cell10 = row.createCell(10);
if (record.getR0200_3_6months() != null) {
R0200cell10.setCellValue(record.getR0200_3_6months().doubleValue());
R0200cell10.setCellStyle(numberStyle);
} else {
R0200cell10.setCellValue("");
R0200cell10.setCellStyle(textStyle);
}

//ROW29
//Column L: 
Cell R0200cell11 = row.createCell(11);
if (record.getR0200_6_12months() != null) {
R0200cell11.setCellValue(record.getR0200_6_12months().doubleValue());
R0200cell11.setCellStyle(numberStyle);
} else {
R0200cell11.setCellValue("");
R0200cell11.setCellStyle(textStyle);
}

//ROW29
//Column M: 
Cell R0200cell12 = row.createCell(12);
if (record.getR0200_1_2years() != null) {
R0200cell12.setCellValue(record.getR0200_1_2years().doubleValue());
R0200cell12.setCellStyle(numberStyle);
} else {
R0200cell12.setCellValue("");
R0200cell12.setCellStyle(textStyle);
}

//ROW29
//Column N: 
Cell R0200cell13 = row.createCell(13);
if (record.getR0200_2_3years() != null) {
R0200cell13.setCellValue(record.getR0200_2_3years().doubleValue());
R0200cell13.setCellStyle(numberStyle);
} else {
R0200cell13.setCellValue("");
R0200cell13.setCellStyle(textStyle);
}

//ROW29
//Column O: 
Cell R0200cell14 = row.createCell(14);
if (record.getR0200_3_4years() != null) {
R0200cell14.setCellValue(record.getR0200_3_4years().doubleValue());
R0200cell14.setCellStyle(numberStyle);
} else {
R0200cell14.setCellValue("");
R0200cell14.setCellStyle(textStyle);
}

//ROW29
//Column P: 
Cell R0200cell15 = row.createCell(15);
if (record.getR0200_4_5years() != null) {
R0200cell15.setCellValue(record.getR0200_4_5years().doubleValue());
R0200cell15.setCellStyle(numberStyle);
} else {
R0200cell15.setCellValue("");
R0200cell15.setCellStyle(textStyle);
}

//ROW29
//Column Q: 
Cell R0200cell16 = row.createCell(16);
if (record.getR0200_5years() != null) {
R0200cell16.setCellValue(record.getR0200_5years().doubleValue());
R0200cell16.setCellStyle(numberStyle);
} else {
R0200cell16.setCellValue("");
R0200cell16.setCellStyle(textStyle);
}

//ROW29
//Column R: 
Cell R0200cell17 = row.createCell(17);
if (record.getR0200_non_interest() != null) {
R0200cell17.setCellValue(record.getR0200_non_interest().doubleValue());
R0200cell17.setCellStyle(numberStyle);
} else {
R0200cell17.setCellValue("");
R0200cell17.setCellStyle(textStyle);
}

/////ROW31///////////
//ROW31
//Column E: 
row = sheet.getRow(30);
Cell R0220cell4 = row.createCell(4);
if (record.getR0220_overdraft() != null) {
R0220cell4.setCellValue(record.getR0220_overdraft().doubleValue());
R0220cell4.setCellStyle(numberStyle);
} else {
R0220cell4.setCellValue("");
R0220cell4.setCellStyle(textStyle);
}

//ROW31
//Column F: 
Cell R0220cell5 = row.createCell(5);
if (record.getR0220_0_7days() != null) {
R0220cell5.setCellValue(record.getR0220_0_7days().doubleValue());
R0220cell5.setCellStyle(numberStyle);
} else {
R0220cell5.setCellValue("");
R0220cell5.setCellStyle(textStyle);
}

//ROW31
//Column G: 
Cell R0220cell6 = row.createCell(6);
if (record.getR0220_8_14days() != null) {
R0220cell6.setCellValue(record.getR0220_8_14days().doubleValue());
R0220cell6.setCellStyle(numberStyle);
} else {
R0220cell6.setCellValue("");
R0220cell6.setCellStyle(textStyle);
}

//ROW31
//Column H: 
Cell R0220cell7 = row.createCell(7);
if (record.getR0220_15days_1months() != null) {
R0220cell7.setCellValue(record.getR0220_15days_1months().doubleValue());
R0220cell7.setCellStyle(numberStyle);
} else {
R0220cell7.setCellValue("");
R0220cell7.setCellStyle(textStyle);
}

//ROW31
//Column I: 
Cell R0220cell8 = row.createCell(8);
if (record.getR0220_1_2months() != null) {
R0220cell8.setCellValue(record.getR0220_1_2months().doubleValue());
R0220cell8.setCellStyle(numberStyle);
} else {
R0220cell8.setCellValue("");
R0220cell8.setCellStyle(textStyle);
}
		
		
//ROW31
//Column J: 
Cell R0220cell9 = row.createCell(9);
if (record.getR0220_2_3months() != null) {
R0220cell9.setCellValue(record.getR0220_2_3months().doubleValue());
R0220cell9.setCellStyle(numberStyle);
} else {
R0220cell9.setCellValue("");
R0220cell9.setCellStyle(textStyle);
}

//ROW31
//Column K: 
Cell R0220cell10 = row.createCell(10);
if (record.getR0220_3_6months() != null) {
R0220cell10.setCellValue(record.getR0220_3_6months().doubleValue());
R0220cell10.setCellStyle(numberStyle);
} else {
R0220cell10.setCellValue("");
R0220cell10.setCellStyle(textStyle);
}

//ROW31
//Column L: 
Cell R0220cell11 = row.createCell(11);
if (record.getR0220_6_12months() != null) {
R0220cell11.setCellValue(record.getR0220_6_12months().doubleValue());
R0220cell11.setCellStyle(numberStyle);
} else {
R0220cell11.setCellValue("");
R0220cell11.setCellStyle(textStyle);
}

//ROW31
//Column M: 
Cell R0220cell12 = row.createCell(12);
if (record.getR0220_1_2years() != null) {
R0220cell12.setCellValue(record.getR0220_1_2years().doubleValue());
R0220cell12.setCellStyle(numberStyle);
} else {
R0220cell12.setCellValue("");
R0220cell12.setCellStyle(textStyle);
}

//ROW31
//Column N: 
Cell R0220cell13 = row.createCell(13);
if (record.getR0220_2_3years() != null) {
R0220cell13.setCellValue(record.getR0220_2_3years().doubleValue());
R0220cell13.setCellStyle(numberStyle);
} else {
R0220cell13.setCellValue("");
R0220cell13.setCellStyle(textStyle);
}

//ROW31
//Column O: 
Cell R0220cell14 = row.createCell(14);
if (record.getR0220_3_4years() != null) {
R0220cell14.setCellValue(record.getR0220_3_4years().doubleValue());
R0220cell14.setCellStyle(numberStyle);
} else {
R0220cell14.setCellValue("");
R0220cell14.setCellStyle(textStyle);
}

//ROW31
//Column P: 
Cell R0220cell15 = row.createCell(15);
if (record.getR0220_4_5years() != null) {
R0220cell15.setCellValue(record.getR0220_4_5years().doubleValue());
R0220cell15.setCellStyle(numberStyle);
} else {
R0220cell15.setCellValue("");
R0220cell15.setCellStyle(textStyle);
}

//ROW31
//Column Q: 
Cell R0220cell16 = row.createCell(16);
if (record.getR0220_5years() != null) {
R0220cell16.setCellValue(record.getR0220_5years().doubleValue());
R0220cell16.setCellStyle(numberStyle);
} else {
R0220cell16.setCellValue("");
R0220cell16.setCellStyle(textStyle);
}

//ROW31
//Column R: 
Cell R0220cell17 = row.createCell(17);
if (record.getR0220_non_interest() != null) {
R0220cell17.setCellValue(record.getR0220_non_interest().doubleValue());
R0220cell17.setCellStyle(numberStyle);
} else {
R0220cell17.setCellValue("");
R0220cell17.setCellStyle(textStyle);
}


/////ROW32///////////
//ROW32
//Column E: 
row = sheet.getRow(31);
Cell R0230cell4 = row.createCell(4);
if (record.getR0230_overdraft() != null) {
R0230cell4.setCellValue(record.getR0230_overdraft().doubleValue());
R0230cell4.setCellStyle(numberStyle);
} else {
R0230cell4.setCellValue("");
R0230cell4.setCellStyle(textStyle);
}

//ROW32
//Column F: 
Cell R0230cell5 = row.createCell(5);
if (record.getR0230_0_7days() != null) {
R0230cell5.setCellValue(record.getR0230_0_7days().doubleValue());
R0230cell5.setCellStyle(numberStyle);
} else {
R0230cell5.setCellValue("");
R0230cell5.setCellStyle(textStyle);
}

//ROW32
//Column G: 
Cell R0230cell6 = row.createCell(6);
if (record.getR0230_8_14days() != null) {
R0230cell6.setCellValue(record.getR0230_8_14days().doubleValue());
R0230cell6.setCellStyle(numberStyle);
} else {
R0230cell6.setCellValue("");
R0230cell6.setCellStyle(textStyle);
}

//ROW32
//Column H: 
Cell R0230cell7 = row.createCell(7);
if (record.getR0230_15days_1months() != null) {
R0230cell7.setCellValue(record.getR0230_15days_1months().doubleValue());
R0230cell7.setCellStyle(numberStyle);
} else {
R0230cell7.setCellValue("");
R0230cell7.setCellStyle(textStyle);
}

//ROW32
//Column I: 
Cell R0230cell8 = row.createCell(8);
if (record.getR0230_1_2months() != null) {
R0230cell8.setCellValue(record.getR0230_1_2months().doubleValue());
R0230cell8.setCellStyle(numberStyle);
} else {
R0230cell8.setCellValue("");
R0230cell8.setCellStyle(textStyle);
}
		
		
//ROW32
//Column J: 
Cell R0230cell9 = row.createCell(9);
if (record.getR0230_2_3months() != null) {
R0230cell9.setCellValue(record.getR0230_2_3months().doubleValue());
R0230cell9.setCellStyle(numberStyle);
} else {
R0230cell9.setCellValue("");
R0230cell9.setCellStyle(textStyle);
}

//ROW32
//Column K: 
Cell R0230cell10 = row.createCell(10);
if (record.getR0230_3_6months() != null) {
R0230cell10.setCellValue(record.getR0230_3_6months().doubleValue());
R0230cell10.setCellStyle(numberStyle);
} else {
R0230cell10.setCellValue("");
R0230cell10.setCellStyle(textStyle);
}

//ROW32
//Column L: 
Cell R0230cell11 = row.createCell(11);
if (record.getR0230_6_12months() != null) {
R0230cell11.setCellValue(record.getR0230_6_12months().doubleValue());
R0230cell11.setCellStyle(numberStyle);
} else {
R0230cell11.setCellValue("");
R0230cell11.setCellStyle(textStyle);
}

//ROW32
//Column M: 
Cell R0230cell12 = row.createCell(12);
if (record.getR0230_1_2years() != null) {
R0230cell12.setCellValue(record.getR0230_1_2years().doubleValue());
R0230cell12.setCellStyle(numberStyle);
} else {
R0230cell12.setCellValue("");
R0230cell12.setCellStyle(textStyle);
}

//ROW32
//Column N: 
Cell R0230cell13 = row.createCell(13);
if (record.getR0230_2_3years() != null) {
R0230cell13.setCellValue(record.getR0230_2_3years().doubleValue());
R0230cell13.setCellStyle(numberStyle);
} else {
R0230cell13.setCellValue("");
R0230cell13.setCellStyle(textStyle);
}

//ROW32
//Column O: 
Cell R0230cell14 = row.createCell(14);
if (record.getR0230_3_4years() != null) {
R0230cell14.setCellValue(record.getR0230_3_4years().doubleValue());
R0230cell14.setCellStyle(numberStyle);
} else {
R0230cell14.setCellValue("");
R0230cell14.setCellStyle(textStyle);
}

//ROW32
//Column P: 
Cell R0230cell15 = row.createCell(15);
if (record.getR0230_4_5years() != null) {
R0230cell15.setCellValue(record.getR0230_4_5years().doubleValue());
R0230cell15.setCellStyle(numberStyle);
} else {
R0230cell15.setCellValue("");
R0230cell15.setCellStyle(textStyle);
}

//ROW32
//Column Q: 
Cell R0230cell16 = row.createCell(16);
if (record.getR0230_5years() != null) {
R0230cell16.setCellValue(record.getR0230_5years().doubleValue());
R0230cell16.setCellStyle(numberStyle);
} else {
R0230cell16.setCellValue("");
R0230cell16.setCellStyle(textStyle);
}

//ROW32
//Column R: 
Cell R0230cell17 = row.createCell(17);
if (record.getR0230_non_interest() != null) {
R0230cell17.setCellValue(record.getR0230_non_interest().doubleValue());
R0230cell17.setCellStyle(numberStyle);
} else {
R0230cell17.setCellValue("");
R0230cell17.setCellStyle(textStyle);
}


/////ROW33///////////
//ROW33
//Column E: 
row = sheet.getRow(32);
Cell R0240cell4 = row.createCell(4);
if (record.getR0240_overdraft() != null) {
R0240cell4.setCellValue(record.getR0240_overdraft().doubleValue());
R0240cell4.setCellStyle(numberStyle);
} else {
R0240cell4.setCellValue("");
R0240cell4.setCellStyle(textStyle);
}

//ROW33
//Column F: 
Cell R0240cell5 = row.createCell(5);
if (record.getR0240_0_7days() != null) {
R0240cell5.setCellValue(record.getR0240_0_7days().doubleValue());
R0240cell5.setCellStyle(numberStyle);
} else {
R0240cell5.setCellValue("");
R0240cell5.setCellStyle(textStyle);
}

//ROW33
//Column G: 
Cell R0240cell6 = row.createCell(6);
if (record.getR0240_8_14days() != null) {
R0240cell6.setCellValue(record.getR0240_8_14days().doubleValue());
R0240cell6.setCellStyle(numberStyle);
} else {
R0240cell6.setCellValue("");
R0240cell6.setCellStyle(textStyle);
}

//ROW33
//Column H: 
Cell R0240cell7 = row.createCell(7);
if (record.getR0240_15days_1months() != null) {
R0240cell7.setCellValue(record.getR0240_15days_1months().doubleValue());
R0240cell7.setCellStyle(numberStyle);
} else {
R0240cell7.setCellValue("");
R0240cell7.setCellStyle(textStyle);
}

//ROW33
//Column I: 
Cell R0240cell8 = row.createCell(8);
if (record.getR0240_1_2months() != null) {
R0240cell8.setCellValue(record.getR0240_1_2months().doubleValue());
R0240cell8.setCellStyle(numberStyle);
} else {
R0240cell8.setCellValue("");
R0240cell8.setCellStyle(textStyle);
}
		
		
//ROW33
//Column J: 
Cell R0240cell9 = row.createCell(9);
if (record.getR0240_2_3months() != null) {
R0240cell9.setCellValue(record.getR0240_2_3months().doubleValue());
R0240cell9.setCellStyle(numberStyle);
} else {
R0240cell9.setCellValue("");
R0240cell9.setCellStyle(textStyle);
}

//ROW33
//Column K: 
Cell R0240cell10 = row.createCell(10);
if (record.getR0240_3_6months() != null) {
R0240cell10.setCellValue(record.getR0240_3_6months().doubleValue());
R0240cell10.setCellStyle(numberStyle);
} else {
R0240cell10.setCellValue("");
R0240cell10.setCellStyle(textStyle);
}

//ROW33
//Column L: 
Cell R0240cell11 = row.createCell(11);
if (record.getR0240_6_12months() != null) {
R0240cell11.setCellValue(record.getR0240_6_12months().doubleValue());
R0240cell11.setCellStyle(numberStyle);
} else {
R0240cell11.setCellValue("");
R0240cell11.setCellStyle(textStyle);
}

//ROW33
//Column M: 
Cell R0240cell12 = row.createCell(12);
if (record.getR0240_1_2years() != null) {
R0240cell12.setCellValue(record.getR0240_1_2years().doubleValue());
R0240cell12.setCellStyle(numberStyle);
} else {
R0240cell12.setCellValue("");
R0240cell12.setCellStyle(textStyle);
}

//ROW33
//Column N: 
Cell R0240cell13 = row.createCell(13);
if (record.getR0240_2_3years() != null) {
R0240cell13.setCellValue(record.getR0240_2_3years().doubleValue());
R0240cell13.setCellStyle(numberStyle);
} else {
R0240cell13.setCellValue("");
R0240cell13.setCellStyle(textStyle);
}

//ROW33
//Column O: 
Cell R0240cell14 = row.createCell(14);
if (record.getR0240_3_4years() != null) {
R0240cell14.setCellValue(record.getR0240_3_4years().doubleValue());
R0240cell14.setCellStyle(numberStyle);
} else {
R0240cell14.setCellValue("");
R0240cell14.setCellStyle(textStyle);
}

//ROW33
//Column P: 
Cell R0240cell15 = row.createCell(15);
if (record.getR0240_4_5years() != null) {
R0240cell15.setCellValue(record.getR0240_4_5years().doubleValue());
R0240cell15.setCellStyle(numberStyle);
} else {
R0240cell15.setCellValue("");
R0240cell15.setCellStyle(textStyle);
}

//ROW33
//Column Q: 
Cell R0240cell16 = row.createCell(16);
if (record.getR0240_5years() != null) {
R0240cell16.setCellValue(record.getR0240_5years().doubleValue());
R0240cell16.setCellStyle(numberStyle);
} else {
R0240cell16.setCellValue("");
R0240cell16.setCellStyle(textStyle);
}

//ROW33
//Column R: 
Cell R0240cell17 = row.createCell(17);
if (record.getR0240_non_interest() != null) {
R0240cell17.setCellValue(record.getR0240_non_interest().doubleValue());
R0240cell17.setCellStyle(numberStyle);
} else {
R0240cell17.setCellValue("");
R0240cell17.setCellStyle(textStyle);
}


/////ROW34///////////
//ROW34
//Column E: 
row = sheet.getRow(33);
Cell R0250cell4 = row.createCell(4);
if (record.getR0250_overdraft() != null) {
R0250cell4.setCellValue(record.getR0250_overdraft().doubleValue());
R0250cell4.setCellStyle(numberStyle);
} else {
R0250cell4.setCellValue("");
R0250cell4.setCellStyle(textStyle);
}

//ROW34
//Column F: 
Cell R0250cell5 = row.createCell(5);
if (record.getR0250_0_7days() != null) {
R0250cell5.setCellValue(record.getR0250_0_7days().doubleValue());
R0250cell5.setCellStyle(numberStyle);
} else {
R0250cell5.setCellValue("");
R0250cell5.setCellStyle(textStyle);
}

//ROW34
//Column G: 
Cell R0250cell6 = row.createCell(6);
if (record.getR0250_8_14days() != null) {
R0250cell6.setCellValue(record.getR0250_8_14days().doubleValue());
R0250cell6.setCellStyle(numberStyle);
} else {
R0250cell6.setCellValue("");
R0250cell6.setCellStyle(textStyle);
}

//ROW34
//Column H: 
Cell R0250cell7 = row.createCell(7);
if (record.getR0250_15days_1months() != null) {
R0250cell7.setCellValue(record.getR0250_15days_1months().doubleValue());
R0250cell7.setCellStyle(numberStyle);
} else {
R0250cell7.setCellValue("");
R0250cell7.setCellStyle(textStyle);
}

//ROW34
//Column I: 
Cell R0250cell8 = row.createCell(8);
if (record.getR0250_1_2months() != null) {
R0250cell8.setCellValue(record.getR0250_1_2months().doubleValue());
R0250cell8.setCellStyle(numberStyle);
} else {
R0250cell8.setCellValue("");
R0250cell8.setCellStyle(textStyle);
}
		
		
//ROW34
//Column J: 
Cell R0250cell9 = row.createCell(9);
if (record.getR0250_2_3months() != null) {
R0250cell9.setCellValue(record.getR0250_2_3months().doubleValue());
R0250cell9.setCellStyle(numberStyle);
} else {
R0250cell9.setCellValue("");
R0250cell9.setCellStyle(textStyle);
}

//ROW34
//Column K: 
Cell R0250cell10 = row.createCell(10);
if (record.getR0250_3_6months() != null) {
R0250cell10.setCellValue(record.getR0250_3_6months().doubleValue());
R0250cell10.setCellStyle(numberStyle);
} else {
R0250cell10.setCellValue("");
R0250cell10.setCellStyle(textStyle);
}

//ROW34
//Column L: 
Cell R0250cell11 = row.createCell(11);
if (record.getR0250_6_12months() != null) {
R0250cell11.setCellValue(record.getR0250_6_12months().doubleValue());
R0250cell11.setCellStyle(numberStyle);
} else {
R0250cell11.setCellValue("");
R0250cell11.setCellStyle(textStyle);
}

//ROW34
//Column M: 
Cell R0250cell12 = row.createCell(12);
if (record.getR0250_1_2years() != null) {
R0250cell12.setCellValue(record.getR0250_1_2years().doubleValue());
R0250cell12.setCellStyle(numberStyle);
} else {
R0250cell12.setCellValue("");
R0250cell12.setCellStyle(textStyle);
}

//ROW34
//Column N: 
Cell R0250cell13 = row.createCell(13);
if (record.getR0250_2_3years() != null) {
R0250cell13.setCellValue(record.getR0250_2_3years().doubleValue());
R0250cell13.setCellStyle(numberStyle);
} else {
R0250cell13.setCellValue("");
R0250cell13.setCellStyle(textStyle);
}

//ROW34
//Column O: 
Cell R0250cell14 = row.createCell(14);
if (record.getR0250_3_4years() != null) {
R0250cell14.setCellValue(record.getR0250_3_4years().doubleValue());
R0250cell14.setCellStyle(numberStyle);
} else {
R0250cell14.setCellValue("");
R0250cell14.setCellStyle(textStyle);
}

//ROW34
//Column P: 
Cell R0250cell15 = row.createCell(15);
if (record.getR0250_4_5years() != null) {
R0250cell15.setCellValue(record.getR0250_4_5years().doubleValue());
R0250cell15.setCellStyle(numberStyle);
} else {
R0250cell15.setCellValue("");
R0250cell15.setCellStyle(textStyle);
}

//ROW34
//Column Q: 
Cell R0250cell16 = row.createCell(16);
if (record.getR0250_5years() != null) {
R0250cell16.setCellValue(record.getR0250_5years().doubleValue());
R0250cell16.setCellStyle(numberStyle);
} else {
R0250cell16.setCellValue("");
R0250cell16.setCellStyle(textStyle);
}

//ROW34
//Column R: 
Cell R0250cell17 = row.createCell(17);
if (record.getR0250_non_interest() != null) {
R0250cell17.setCellValue(record.getR0250_non_interest().doubleValue());
R0250cell17.setCellStyle(numberStyle);
} else {
R0250cell17.setCellValue("");
R0250cell17.setCellStyle(textStyle);
}


/////ROW35///////////
//ROW35
//Column E: 
row = sheet.getRow(34);
Cell R0260cell4 = row.createCell(4);
if (record.getR0260_overdraft() != null) {
R0260cell4.setCellValue(record.getR0260_overdraft().doubleValue());
R0260cell4.setCellStyle(numberStyle);
} else {
R0260cell4.setCellValue("");
R0260cell4.setCellStyle(textStyle);
}

//ROW35
//Column F: 
Cell R0260cell5 = row.createCell(5);
if (record.getR0260_0_7days() != null) {
R0260cell5.setCellValue(record.getR0260_0_7days().doubleValue());
R0260cell5.setCellStyle(numberStyle);
} else {
R0260cell5.setCellValue("");
R0260cell5.setCellStyle(textStyle);
}

//ROW35
//Column G: 
Cell R0260cell6 = row.createCell(6);
if (record.getR0260_8_14days() != null) {
R0260cell6.setCellValue(record.getR0260_8_14days().doubleValue());
R0260cell6.setCellStyle(numberStyle);
} else {
R0260cell6.setCellValue("");
R0260cell6.setCellStyle(textStyle);
}

//ROW35
//Column H: 
Cell R0260cell7 = row.createCell(7);
if (record.getR0260_15days_1months() != null) {
R0260cell7.setCellValue(record.getR0260_15days_1months().doubleValue());
R0260cell7.setCellStyle(numberStyle);
} else {
R0260cell7.setCellValue("");
R0260cell7.setCellStyle(textStyle);
}

//ROW35
//Column I: 
Cell R0260cell8 = row.createCell(8);
if (record.getR0260_1_2months() != null) {
R0260cell8.setCellValue(record.getR0260_1_2months().doubleValue());
R0260cell8.setCellStyle(numberStyle);
} else {
R0260cell8.setCellValue("");
R0260cell8.setCellStyle(textStyle);
}
		
		
//ROW35
//Column J: 
Cell R0260cell9 = row.createCell(9);
if (record.getR0260_2_3months() != null) {
R0260cell9.setCellValue(record.getR0260_2_3months().doubleValue());
R0260cell9.setCellStyle(numberStyle);
} else {
R0260cell9.setCellValue("");
R0260cell9.setCellStyle(textStyle);
}

//ROW35
//Column K: 
Cell R0260cell10 = row.createCell(10);
if (record.getR0260_3_6months() != null) {
R0260cell10.setCellValue(record.getR0260_3_6months().doubleValue());
R0260cell10.setCellStyle(numberStyle);
} else {
R0260cell10.setCellValue("");
R0260cell10.setCellStyle(textStyle);
}

//ROW35
//Column L: 
Cell R0260cell11 = row.createCell(11);
if (record.getR0260_6_12months() != null) {
R0260cell11.setCellValue(record.getR0260_6_12months().doubleValue());
R0260cell11.setCellStyle(numberStyle);
} else {
R0260cell11.setCellValue("");
R0260cell11.setCellStyle(textStyle);
}

//ROW35
//Column M: 
Cell R0260cell12 = row.createCell(12);
if (record.getR0260_1_2years() != null) {
R0260cell12.setCellValue(record.getR0260_1_2years().doubleValue());
R0260cell12.setCellStyle(numberStyle);
} else {
R0260cell12.setCellValue("");
R0260cell12.setCellStyle(textStyle);
}

//ROW35
//Column N: 
Cell R0260cell13 = row.createCell(13);
if (record.getR0260_2_3years() != null) {
R0260cell13.setCellValue(record.getR0260_2_3years().doubleValue());
R0260cell13.setCellStyle(numberStyle);
} else {
R0260cell13.setCellValue("");
R0260cell13.setCellStyle(textStyle);
}

//ROW35
//Column O: 
Cell R0260cell14 = row.createCell(14);
if (record.getR0260_3_4years() != null) {
R0260cell14.setCellValue(record.getR0260_3_4years().doubleValue());
R0260cell14.setCellStyle(numberStyle);
} else {
R0260cell14.setCellValue("");
R0260cell14.setCellStyle(textStyle);
}

//ROW35
//Column P: 
Cell R0260cell15 = row.createCell(15);
if (record.getR0260_4_5years() != null) {
R0260cell15.setCellValue(record.getR0260_4_5years().doubleValue());
R0260cell15.setCellStyle(numberStyle);
} else {
R0260cell15.setCellValue("");
R0260cell15.setCellStyle(textStyle);
}

//ROW35
//Column Q: 
Cell R0260cell16 = row.createCell(16);
if (record.getR0260_5years() != null) {
R0260cell16.setCellValue(record.getR0260_5years().doubleValue());
R0260cell16.setCellStyle(numberStyle);
} else {
R0260cell16.setCellValue("");
R0260cell16.setCellStyle(textStyle);
}

//ROW35
//Column R: 
Cell R0260cell17 = row.createCell(17);
if (record.getR0260_non_interest() != null) {
R0260cell17.setCellValue(record.getR0260_non_interest().doubleValue());
R0260cell17.setCellStyle(numberStyle);
} else {
R0260cell17.setCellValue("");
R0260cell17.setCellStyle(textStyle);
}


/////ROW36///////////
//ROW36
//Column E: 
row = sheet.getRow(35);
Cell R0270cell4 = row.createCell(4);
if (record.getR0270_overdraft() != null) {
R0270cell4.setCellValue(record.getR0270_overdraft().doubleValue());
R0270cell4.setCellStyle(numberStyle);
} else {
R0270cell4.setCellValue("");
R0270cell4.setCellStyle(textStyle);
}

//ROW36
//Column F: 
Cell R0270cell5 = row.createCell(5);
if (record.getR0270_0_7days() != null) {
R0270cell5.setCellValue(record.getR0270_0_7days().doubleValue());
R0270cell5.setCellStyle(numberStyle);
} else {
R0270cell5.setCellValue("");
R0270cell5.setCellStyle(textStyle);
}

//ROW36
//Column G: 
Cell R0270cell6 = row.createCell(6);
if (record.getR0270_8_14days() != null) {
R0270cell6.setCellValue(record.getR0270_8_14days().doubleValue());
R0270cell6.setCellStyle(numberStyle);
} else {
R0270cell6.setCellValue("");
R0270cell6.setCellStyle(textStyle);
}

//ROW36
//Column H: 
Cell R0270cell7 = row.createCell(7);
if (record.getR0270_15days_1months() != null) {
R0270cell7.setCellValue(record.getR0270_15days_1months().doubleValue());
R0270cell7.setCellStyle(numberStyle);
} else {
R0270cell7.setCellValue("");
R0270cell7.setCellStyle(textStyle);
}

//ROW36
//Column I: 
Cell R0270cell8 = row.createCell(8);
if (record.getR0270_1_2months() != null) {
R0270cell8.setCellValue(record.getR0270_1_2months().doubleValue());
R0270cell8.setCellStyle(numberStyle);
} else {
R0270cell8.setCellValue("");
R0270cell8.setCellStyle(textStyle);
}
		
		
//ROW36
//Column J: 
Cell R0270cell9 = row.createCell(9);
if (record.getR0270_2_3months() != null) {
R0270cell9.setCellValue(record.getR0270_2_3months().doubleValue());
R0270cell9.setCellStyle(numberStyle);
} else {
R0270cell9.setCellValue("");
R0270cell9.setCellStyle(textStyle);
}

//ROW36
//Column K: 
Cell R0270cell10 = row.createCell(10);
if (record.getR0270_3_6months() != null) {
R0270cell10.setCellValue(record.getR0270_3_6months().doubleValue());
R0270cell10.setCellStyle(numberStyle);
} else {
R0270cell10.setCellValue("");
R0270cell10.setCellStyle(textStyle);
}

//ROW36
//Column L: 
Cell R0270cell11 = row.createCell(11);
if (record.getR0270_6_12months() != null) {
R0270cell11.setCellValue(record.getR0270_6_12months().doubleValue());
R0270cell11.setCellStyle(numberStyle);
} else {
R0270cell11.setCellValue("");
R0270cell11.setCellStyle(textStyle);
}

//ROW36
//Column M: 
Cell R0270cell12 = row.createCell(12);
if (record.getR0270_1_2years() != null) {
R0270cell12.setCellValue(record.getR0270_1_2years().doubleValue());
R0270cell12.setCellStyle(numberStyle);
} else {
R0270cell12.setCellValue("");
R0270cell12.setCellStyle(textStyle);
}

//ROW36
//Column N: 
Cell R0270cell13 = row.createCell(13);
if (record.getR0270_2_3years() != null) {
R0270cell13.setCellValue(record.getR0270_2_3years().doubleValue());
R0270cell13.setCellStyle(numberStyle);
} else {
R0270cell13.setCellValue("");
R0270cell13.setCellStyle(textStyle);
}

//ROW36
//Column O: 
Cell R0270cell14 = row.createCell(14);
if (record.getR0270_3_4years() != null) {
R0270cell14.setCellValue(record.getR0270_3_4years().doubleValue());
R0270cell14.setCellStyle(numberStyle);
} else {
R0270cell14.setCellValue("");
R0270cell14.setCellStyle(textStyle);
}

//ROW36
//Column P: 
Cell R0270cell15 = row.createCell(15);
if (record.getR0270_4_5years() != null) {
R0270cell15.setCellValue(record.getR0270_4_5years().doubleValue());
R0270cell15.setCellStyle(numberStyle);
} else {
R0270cell15.setCellValue("");
R0270cell15.setCellStyle(textStyle);
}

//ROW36
//Column Q: 
Cell R0270cell16 = row.createCell(16);
if (record.getR0270_5years() != null) {
R0270cell16.setCellValue(record.getR0270_5years().doubleValue());
R0270cell16.setCellStyle(numberStyle);
} else {
R0270cell16.setCellValue("");
R0270cell16.setCellStyle(textStyle);
}

//ROW36
//Column R: 
Cell R0270cell17 = row.createCell(17);
if (record.getR0270_non_interest() != null) {
R0270cell17.setCellValue(record.getR0270_non_interest().doubleValue());
R0270cell17.setCellStyle(numberStyle);
} else {
R0270cell17.setCellValue("");
R0270cell17.setCellStyle(textStyle);
}


/////ROW38///////////
//ROW38
//Column E: 
row = sheet.getRow(37);
Cell R0290cell4 = row.createCell(4);
if (record.getR0290_overdraft() != null) {
R0290cell4.setCellValue(record.getR0290_overdraft().doubleValue());
R0290cell4.setCellStyle(numberStyle);
} else {
R0290cell4.setCellValue("");
R0290cell4.setCellStyle(textStyle);
}

//ROW38
//Column F: 
Cell R0290cell5 = row.createCell(5);
if (record.getR0290_0_7days() != null) {
R0290cell5.setCellValue(record.getR0290_0_7days().doubleValue());
R0290cell5.setCellStyle(numberStyle);
} else {
R0290cell5.setCellValue("");
R0290cell5.setCellStyle(textStyle);
}

//ROW38
//Column G: 
Cell R0290cell6 = row.createCell(6);
if (record.getR0290_8_14days() != null) {
R0290cell6.setCellValue(record.getR0290_8_14days().doubleValue());
R0290cell6.setCellStyle(numberStyle);
} else {
R0290cell6.setCellValue("");
R0290cell6.setCellStyle(textStyle);
}

//ROW38
//Column H: 
Cell R0290cell7 = row.createCell(7);
if (record.getR0290_15days_1months() != null) {
R0290cell7.setCellValue(record.getR0290_15days_1months().doubleValue());
R0290cell7.setCellStyle(numberStyle);
} else {
R0290cell7.setCellValue("");
R0290cell7.setCellStyle(textStyle);
}

//ROW38
//Column I: 
Cell R0290cell8 = row.createCell(8);
if (record.getR0290_1_2months() != null) {
R0290cell8.setCellValue(record.getR0290_1_2months().doubleValue());
R0290cell8.setCellStyle(numberStyle);
} else {
R0290cell8.setCellValue("");
R0290cell8.setCellStyle(textStyle);
}
		
		
//ROW38
//Column J: 
Cell R0290cell9 = row.createCell(9);
if (record.getR0290_2_3months() != null) {
R0290cell9.setCellValue(record.getR0290_2_3months().doubleValue());
R0290cell9.setCellStyle(numberStyle);
} else {
R0290cell9.setCellValue("");
R0290cell9.setCellStyle(textStyle);
}

//ROW38
//Column K: 
Cell R0290cell10 = row.createCell(10);
if (record.getR0290_3_6months() != null) {
R0290cell10.setCellValue(record.getR0290_3_6months().doubleValue());
R0290cell10.setCellStyle(numberStyle);
} else {
R0290cell10.setCellValue("");
R0290cell10.setCellStyle(textStyle);
}

//ROW38
//Column L: 
Cell R0290cell11 = row.createCell(11);
if (record.getR0290_6_12months() != null) {
R0290cell11.setCellValue(record.getR0290_6_12months().doubleValue());
R0290cell11.setCellStyle(numberStyle);
} else {
R0290cell11.setCellValue("");
R0290cell11.setCellStyle(textStyle);
}

//ROW38
//Column M: 
Cell R0290cell12 = row.createCell(12);
if (record.getR0290_1_2years() != null) {
R0290cell12.setCellValue(record.getR0290_1_2years().doubleValue());
R0290cell12.setCellStyle(numberStyle);
} else {
R0290cell12.setCellValue("");
R0290cell12.setCellStyle(textStyle);
}

//ROW38
//Column N: 
Cell R0290cell13 = row.createCell(13);
if (record.getR0290_2_3years() != null) {
R0290cell13.setCellValue(record.getR0290_2_3years().doubleValue());
R0290cell13.setCellStyle(numberStyle);
} else {
R0290cell13.setCellValue("");
R0290cell13.setCellStyle(textStyle);
}

//ROW38
//Column O: 
Cell R0290cell14 = row.createCell(14);
if (record.getR0290_3_4years() != null) {
R0290cell14.setCellValue(record.getR0290_3_4years().doubleValue());
R0290cell14.setCellStyle(numberStyle);
} else {
R0290cell14.setCellValue("");
R0290cell14.setCellStyle(textStyle);
}

//ROW38
//Column P: 
Cell R0290cell15 = row.createCell(15);
if (record.getR0290_4_5years() != null) {
R0290cell15.setCellValue(record.getR0290_4_5years().doubleValue());
R0290cell15.setCellStyle(numberStyle);
} else {
R0290cell15.setCellValue("");
R0290cell15.setCellStyle(textStyle);
}

//ROW38
//Column Q: 
Cell R0290cell16 = row.createCell(16);
if (record.getR0290_5years() != null) {
R0290cell16.setCellValue(record.getR0290_5years().doubleValue());
R0290cell16.setCellStyle(numberStyle);
} else {
R0290cell16.setCellValue("");
R0290cell16.setCellStyle(textStyle);
}

//ROW38
//Column R: 
Cell R0290cell17 = row.createCell(17);
if (record.getR0290_non_interest() != null) {
R0290cell17.setCellValue(record.getR0290_non_interest().doubleValue());
R0290cell17.setCellStyle(numberStyle);
} else {
R0290cell17.setCellValue("");
R0290cell17.setCellStyle(textStyle);
}


/////ROW39///////////
//ROW39
//Column E: 
row = sheet.getRow(38);
Cell R0300cell4 = row.createCell(4);
if (record.getR0300_overdraft() != null) {
R0300cell4.setCellValue(record.getR0300_overdraft().doubleValue());
R0300cell4.setCellStyle(numberStyle);
} else {
R0300cell4.setCellValue("");
R0300cell4.setCellStyle(textStyle);
}

//ROW39
//Column F: 
Cell R0300cell5 = row.createCell(5);
if (record.getR0300_0_7days() != null) {
R0300cell5.setCellValue(record.getR0300_0_7days().doubleValue());
R0300cell5.setCellStyle(numberStyle);
} else {
R0300cell5.setCellValue("");
R0300cell5.setCellStyle(textStyle);
}

//ROW39
//Column G: 
Cell R0300cell6 = row.createCell(6);
if (record.getR0300_8_14days() != null) {
R0300cell6.setCellValue(record.getR0300_8_14days().doubleValue());
R0300cell6.setCellStyle(numberStyle);
} else {
R0300cell6.setCellValue("");
R0300cell6.setCellStyle(textStyle);
}

//ROW39
//Column H: 
Cell R0300cell7 = row.createCell(7);
if (record.getR0300_15days_1months() != null) {
R0300cell7.setCellValue(record.getR0300_15days_1months().doubleValue());
R0300cell7.setCellStyle(numberStyle);
} else {
R0300cell7.setCellValue("");
R0300cell7.setCellStyle(textStyle);
}

//ROW39
//Column I: 
Cell R0300cell8 = row.createCell(8);
if (record.getR0300_1_2months() != null) {
R0300cell8.setCellValue(record.getR0300_1_2months().doubleValue());
R0300cell8.setCellStyle(numberStyle);
} else {
R0300cell8.setCellValue("");
R0300cell8.setCellStyle(textStyle);
}
		
		
//ROW39
//Column J: 
Cell R0300cell9 = row.createCell(9);
if (record.getR0300_2_3months() != null) {
R0300cell9.setCellValue(record.getR0300_2_3months().doubleValue());
R0300cell9.setCellStyle(numberStyle);
} else {
R0300cell9.setCellValue("");
R0300cell9.setCellStyle(textStyle);
}

//ROW39
//Column K: 
Cell R0300cell10 = row.createCell(10);
if (record.getR0300_3_6months() != null) {
R0300cell10.setCellValue(record.getR0300_3_6months().doubleValue());
R0300cell10.setCellStyle(numberStyle);
} else {
R0300cell10.setCellValue("");
R0300cell10.setCellStyle(textStyle);
}

//ROW39
//Column L: 
Cell R0300cell11 = row.createCell(11);
if (record.getR0300_6_12months() != null) {
R0300cell11.setCellValue(record.getR0300_6_12months().doubleValue());
R0300cell11.setCellStyle(numberStyle);
} else {
R0300cell11.setCellValue("");
R0300cell11.setCellStyle(textStyle);
}

//ROW39
//Column M: 
Cell R0300cell12 = row.createCell(12);
if (record.getR0300_1_2years() != null) {
R0300cell12.setCellValue(record.getR0300_1_2years().doubleValue());
R0300cell12.setCellStyle(numberStyle);
} else {
R0300cell12.setCellValue("");
R0300cell12.setCellStyle(textStyle);
}

//ROW39
//Column N: 
Cell R0300cell13 = row.createCell(13);
if (record.getR0300_2_3years() != null) {
R0300cell13.setCellValue(record.getR0300_2_3years().doubleValue());
R0300cell13.setCellStyle(numberStyle);
} else {
R0300cell13.setCellValue("");
R0300cell13.setCellStyle(textStyle);
}

//ROW39
//Column O: 
Cell R0300cell14 = row.createCell(14);
if (record.getR0300_3_4years() != null) {
R0300cell14.setCellValue(record.getR0300_3_4years().doubleValue());
R0300cell14.setCellStyle(numberStyle);
} else {
R0300cell14.setCellValue("");
R0300cell14.setCellStyle(textStyle);
}

//ROW39
//Column P: 
Cell R0300cell15 = row.createCell(15);
if (record.getR0300_4_5years() != null) {
R0300cell15.setCellValue(record.getR0300_4_5years().doubleValue());
R0300cell15.setCellStyle(numberStyle);
} else {
R0300cell15.setCellValue("");
R0300cell15.setCellStyle(textStyle);
}

//ROW39
//Column Q: 
Cell R0300cell16 = row.createCell(16);
if (record.getR0300_5years() != null) {
R0300cell16.setCellValue(record.getR0300_5years().doubleValue());
R0300cell16.setCellStyle(numberStyle);
} else {
R0300cell16.setCellValue("");
R0300cell16.setCellStyle(textStyle);
}

//ROW39
//Column R: 
Cell R0300cell17 = row.createCell(17);
if (record.getR0300_non_interest() != null) {
R0300cell17.setCellValue(record.getR0300_non_interest().doubleValue());
R0300cell17.setCellStyle(numberStyle);
} else {
R0300cell17.setCellValue("");
R0300cell17.setCellStyle(textStyle);
}

/////ROW40///////////
//ROW40
//Column E: 
row = sheet.getRow(39);
Cell R0310cell4 = row.createCell(4);
if (record.getR0310_overdraft() != null) {
R0310cell4.setCellValue(record.getR0310_overdraft().doubleValue());
R0310cell4.setCellStyle(numberStyle);
} else {
R0310cell4.setCellValue("");
R0310cell4.setCellStyle(textStyle);
}

//ROW40
//Column F: 
Cell R0310cell5 = row.createCell(5);
if (record.getR0310_0_7days() != null) {
R0310cell5.setCellValue(record.getR0310_0_7days().doubleValue());
R0310cell5.setCellStyle(numberStyle);
} else {
R0310cell5.setCellValue("");
R0310cell5.setCellStyle(textStyle);
}

//ROW40
//Column G: 
Cell R0310cell6 = row.createCell(6);
if (record.getR0310_8_14days() != null) {
R0310cell6.setCellValue(record.getR0310_8_14days().doubleValue());
R0310cell6.setCellStyle(numberStyle);
} else {
R0310cell6.setCellValue("");
R0310cell6.setCellStyle(textStyle);
}

//ROW40
//Column H: 
Cell R0310cell7 = row.createCell(7);
if (record.getR0310_15days_1months() != null) {
R0310cell7.setCellValue(record.getR0310_15days_1months().doubleValue());
R0310cell7.setCellStyle(numberStyle);
} else {
R0310cell7.setCellValue("");
R0310cell7.setCellStyle(textStyle);
}

//ROW40
//Column I: 
Cell R0310cell8 = row.createCell(8);
if (record.getR0310_1_2months() != null) {
R0310cell8.setCellValue(record.getR0310_1_2months().doubleValue());
R0310cell8.setCellStyle(numberStyle);
} else {
R0310cell8.setCellValue("");
R0310cell8.setCellStyle(textStyle);
}
		
		
//ROW40
//Column J: 
Cell R0310cell9 = row.createCell(9);
if (record.getR0310_2_3months() != null) {
R0310cell9.setCellValue(record.getR0310_2_3months().doubleValue());
R0310cell9.setCellStyle(numberStyle);
} else {
R0310cell9.setCellValue("");
R0310cell9.setCellStyle(textStyle);
}

//ROW40
//Column K: 
Cell R0310cell10 = row.createCell(10);
if (record.getR0310_3_6months() != null) {
R0310cell10.setCellValue(record.getR0310_3_6months().doubleValue());
R0310cell10.setCellStyle(numberStyle);
} else {
R0310cell10.setCellValue("");
R0310cell10.setCellStyle(textStyle);
}

//ROW40
//Column L: 
Cell R0310cell11 = row.createCell(11);
if (record.getR0310_6_12months() != null) {
R0310cell11.setCellValue(record.getR0310_6_12months().doubleValue());
R0310cell11.setCellStyle(numberStyle);
} else {
R0310cell11.setCellValue("");
R0310cell11.setCellStyle(textStyle);
}

//ROW40
//Column M: 
Cell R0310cell12 = row.createCell(12);
if (record.getR0310_1_2years() != null) {
R0310cell12.setCellValue(record.getR0310_1_2years().doubleValue());
R0310cell12.setCellStyle(numberStyle);
} else {
R0310cell12.setCellValue("");
R0310cell12.setCellStyle(textStyle);
}

//ROW40
//Column N: 
Cell R0310cell13 = row.createCell(13);
if (record.getR0310_2_3years() != null) {
R0310cell13.setCellValue(record.getR0310_2_3years().doubleValue());
R0310cell13.setCellStyle(numberStyle);
} else {
R0310cell13.setCellValue("");
R0310cell13.setCellStyle(textStyle);
}

//ROW40
//Column O: 
Cell R0310cell14 = row.createCell(14);
if (record.getR0310_3_4years() != null) {
R0310cell14.setCellValue(record.getR0310_3_4years().doubleValue());
R0310cell14.setCellStyle(numberStyle);
} else {
R0310cell14.setCellValue("");
R0310cell14.setCellStyle(textStyle);
}

//ROW40
//Column P: 
Cell R0310cell15 = row.createCell(15);
if (record.getR0310_4_5years() != null) {
R0310cell15.setCellValue(record.getR0310_4_5years().doubleValue());
R0310cell15.setCellStyle(numberStyle);
} else {
R0310cell15.setCellValue("");
R0310cell15.setCellStyle(textStyle);
}

//ROW40
//Column Q: 
Cell R0310cell16 = row.createCell(16);
if (record.getR0310_5years() != null) {
R0310cell16.setCellValue(record.getR0310_5years().doubleValue());
R0310cell16.setCellStyle(numberStyle);
} else {
R0310cell16.setCellValue("");
R0310cell16.setCellStyle(textStyle);
}

//ROW40
//Column R: 
Cell R0310cell17 = row.createCell(17);
if (record.getR0310_non_interest() != null) {
R0310cell17.setCellValue(record.getR0310_non_interest().doubleValue());
R0310cell17.setCellStyle(numberStyle);
} else {
R0310cell17.setCellValue("");
R0310cell17.setCellStyle(textStyle);
}


/////ROW41///////////
//ROW41
//Column E: 
row = sheet.getRow(40);
Cell R0320cell4 = row.createCell(4);
if (record.getR0320_overdraft() != null) {
R0320cell4.setCellValue(record.getR0320_overdraft().doubleValue());
R0320cell4.setCellStyle(numberStyle);
} else {
R0320cell4.setCellValue("");
R0320cell4.setCellStyle(textStyle);
}

//ROW41
//Column F: 
Cell R0320cell5 = row.createCell(5);
if (record.getR0320_0_7days() != null) {
R0320cell5.setCellValue(record.getR0320_0_7days().doubleValue());
R0320cell5.setCellStyle(numberStyle);
} else {
R0320cell5.setCellValue("");
R0320cell5.setCellStyle(textStyle);
}

//ROW41
//Column G: 
Cell R0320cell6 = row.createCell(6);
if (record.getR0320_8_14days() != null) {
R0320cell6.setCellValue(record.getR0320_8_14days().doubleValue());
R0320cell6.setCellStyle(numberStyle);
} else {
R0320cell6.setCellValue("");
R0320cell6.setCellStyle(textStyle);
}

//ROW41
//Column H: 
Cell R0320cell7 = row.createCell(7);
if (record.getR0320_15days_1months() != null) {
R0320cell7.setCellValue(record.getR0320_15days_1months().doubleValue());
R0320cell7.setCellStyle(numberStyle);
} else {
R0320cell7.setCellValue("");
R0320cell7.setCellStyle(textStyle);
}

//ROW41
//Column I: 
Cell R0320cell8 = row.createCell(8);
if (record.getR0320_1_2months() != null) {
R0320cell8.setCellValue(record.getR0320_1_2months().doubleValue());
R0320cell8.setCellStyle(numberStyle);
} else {
R0320cell8.setCellValue("");
R0320cell8.setCellStyle(textStyle);
}
		
		
//ROW41
//Column J: 
Cell R0320cell9 = row.createCell(9);
if (record.getR0320_2_3months() != null) {
R0320cell9.setCellValue(record.getR0320_2_3months().doubleValue());
R0320cell9.setCellStyle(numberStyle);
} else {
R0320cell9.setCellValue("");
R0320cell9.setCellStyle(textStyle);
}

//ROW41
//Column K: 
Cell R0320cell10 = row.createCell(10);
if (record.getR0320_3_6months() != null) {
R0320cell10.setCellValue(record.getR0320_3_6months().doubleValue());
R0320cell10.setCellStyle(numberStyle);
} else {
R0320cell10.setCellValue("");
R0320cell10.setCellStyle(textStyle);
}

//ROW41
//Column L: 
Cell R0320cell11 = row.createCell(11);
if (record.getR0320_6_12months() != null) {
R0320cell11.setCellValue(record.getR0320_6_12months().doubleValue());
R0320cell11.setCellStyle(numberStyle);
} else {
R0320cell11.setCellValue("");
R0320cell11.setCellStyle(textStyle);
}

//ROW41
//Column M: 
Cell R0320cell12 = row.createCell(12);
if (record.getR0320_1_2years() != null) {
R0320cell12.setCellValue(record.getR0320_1_2years().doubleValue());
R0320cell12.setCellStyle(numberStyle);
} else {
R0320cell12.setCellValue("");
R0320cell12.setCellStyle(textStyle);
}

//ROW41
//Column N: 
Cell R0320cell13 = row.createCell(13);
if (record.getR0320_2_3years() != null) {
R0320cell13.setCellValue(record.getR0320_2_3years().doubleValue());
R0320cell13.setCellStyle(numberStyle);
} else {
R0320cell13.setCellValue("");
R0320cell13.setCellStyle(textStyle);
}

//ROW41
//Column O: 
Cell R0320cell14 = row.createCell(14);
if (record.getR0320_3_4years() != null) {
R0320cell14.setCellValue(record.getR0320_3_4years().doubleValue());
R0320cell14.setCellStyle(numberStyle);
} else {
R0320cell14.setCellValue("");
R0320cell14.setCellStyle(textStyle);
}

//ROW41
//Column P: 
Cell R0320cell15 = row.createCell(15);
if (record.getR0320_4_5years() != null) {
R0320cell15.setCellValue(record.getR0320_4_5years().doubleValue());
R0320cell15.setCellStyle(numberStyle);
} else {
R0320cell15.setCellValue("");
R0320cell15.setCellStyle(textStyle);
}

//ROW41
//Column Q: 
Cell R0320cell16 = row.createCell(16);
if (record.getR0320_5years() != null) {
R0320cell16.setCellValue(record.getR0320_5years().doubleValue());
R0320cell16.setCellStyle(numberStyle);
} else {
R0320cell16.setCellValue("");
R0320cell16.setCellStyle(textStyle);
}

//ROW41
//Column R: 
Cell R0320cell17 = row.createCell(17);
if (record.getR0320_non_interest() != null) {
R0320cell17.setCellValue(record.getR0320_non_interest().doubleValue());
R0320cell17.setCellStyle(numberStyle);
} else {
R0320cell17.setCellValue("");
R0320cell17.setCellStyle(textStyle);
}


/////ROW42///////////
//ROW42
//Column E: 
row = sheet.getRow(41);
Cell R0330cell4 = row.createCell(4);
if (record.getR0330_overdraft() != null) {
R0330cell4.setCellValue(record.getR0330_overdraft().doubleValue());
R0330cell4.setCellStyle(numberStyle);
} else {
R0330cell4.setCellValue("");
R0330cell4.setCellStyle(textStyle);
}

//ROW42
//Column F: 
Cell R0330cell5 = row.createCell(5);
if (record.getR0330_0_7days() != null) {
R0330cell5.setCellValue(record.getR0330_0_7days().doubleValue());
R0330cell5.setCellStyle(numberStyle);
} else {
R0330cell5.setCellValue("");
R0330cell5.setCellStyle(textStyle);
}

//ROW42
//Column G: 
Cell R0330cell6 = row.createCell(6);
if (record.getR0330_8_14days() != null) {
R0330cell6.setCellValue(record.getR0330_8_14days().doubleValue());
R0330cell6.setCellStyle(numberStyle);
} else {
R0330cell6.setCellValue("");
R0330cell6.setCellStyle(textStyle);
}

//ROW42
//Column H: 
Cell R0330cell7 = row.createCell(7);
if (record.getR0330_15days_1months() != null) {
R0330cell7.setCellValue(record.getR0330_15days_1months().doubleValue());
R0330cell7.setCellStyle(numberStyle);
} else {
R0330cell7.setCellValue("");
R0330cell7.setCellStyle(textStyle);
}

//ROW42
//Column I: 
Cell R0330cell8 = row.createCell(8);
if (record.getR0330_1_2months() != null) {
R0330cell8.setCellValue(record.getR0330_1_2months().doubleValue());
R0330cell8.setCellStyle(numberStyle);
} else {
R0330cell8.setCellValue("");
R0330cell8.setCellStyle(textStyle);
}
		
		
//ROW42
//Column J: 
Cell R0330cell9 = row.createCell(9);
if (record.getR0330_2_3months() != null) {
R0330cell9.setCellValue(record.getR0330_2_3months().doubleValue());
R0330cell9.setCellStyle(numberStyle);
} else {
R0330cell9.setCellValue("");
R0330cell9.setCellStyle(textStyle);
}

//ROW42
//Column K: 
Cell R0330cell10 = row.createCell(10);
if (record.getR0330_3_6months() != null) {
R0330cell10.setCellValue(record.getR0330_3_6months().doubleValue());
R0330cell10.setCellStyle(numberStyle);
} else {
R0330cell10.setCellValue("");
R0330cell10.setCellStyle(textStyle);
}

//ROW42
//Column L: 
Cell R0330cell11 = row.createCell(11);
if (record.getR0330_6_12months() != null) {
R0330cell11.setCellValue(record.getR0330_6_12months().doubleValue());
R0330cell11.setCellStyle(numberStyle);
} else {
R0330cell11.setCellValue("");
R0330cell11.setCellStyle(textStyle);
}

//ROW42
//Column M: 
Cell R0330cell12 = row.createCell(12);
if (record.getR0330_1_2years() != null) {
R0330cell12.setCellValue(record.getR0330_1_2years().doubleValue());
R0330cell12.setCellStyle(numberStyle);
} else {
R0330cell12.setCellValue("");
R0330cell12.setCellStyle(textStyle);
}

//ROW42
//Column N: 
Cell R0330cell13 = row.createCell(13);
if (record.getR0330_2_3years() != null) {
R0330cell13.setCellValue(record.getR0330_2_3years().doubleValue());
R0330cell13.setCellStyle(numberStyle);
} else {
R0330cell13.setCellValue("");
R0330cell13.setCellStyle(textStyle);
}

//ROW42
//Column O: 
Cell R0330cell14 = row.createCell(14);
if (record.getR0330_3_4years() != null) {
R0330cell14.setCellValue(record.getR0330_3_4years().doubleValue());
R0330cell14.setCellStyle(numberStyle);
} else {
R0330cell14.setCellValue("");
R0330cell14.setCellStyle(textStyle);
}

//ROW42
//Column P: 
Cell R0330cell15 = row.createCell(15);
if (record.getR0330_4_5years() != null) {
R0330cell15.setCellValue(record.getR0330_4_5years().doubleValue());
R0330cell15.setCellStyle(numberStyle);
} else {
R0330cell15.setCellValue("");
R0330cell15.setCellStyle(textStyle);
}

//ROW42
//Column Q: 
Cell R0330cell16 = row.createCell(16);
if (record.getR0330_5years() != null) {
R0330cell16.setCellValue(record.getR0330_5years().doubleValue());
R0330cell16.setCellStyle(numberStyle);
} else {
R0330cell16.setCellValue("");
R0330cell16.setCellStyle(textStyle);
}

//ROW42
//Column R: 
Cell R0330cell17 = row.createCell(17);
if (record.getR0330_non_interest() != null) {
R0330cell17.setCellValue(record.getR0330_non_interest().doubleValue());
R0330cell17.setCellStyle(numberStyle);
} else {
R0330cell17.setCellValue("");
R0330cell17.setCellStyle(textStyle);
}


/////ROW43///////////
//ROW43
//Column E: 
row = sheet.getRow(42);
Cell R0340cell4 = row.createCell(4);
if (record.getR0340_overdraft() != null) {
R0340cell4.setCellValue(record.getR0340_overdraft().doubleValue());
R0340cell4.setCellStyle(numberStyle);
} else {
R0340cell4.setCellValue("");
R0340cell4.setCellStyle(textStyle);
}

//ROW43
//Column F: 
Cell R0340cell5 = row.createCell(5);
if (record.getR0340_0_7days() != null) {
R0340cell5.setCellValue(record.getR0340_0_7days().doubleValue());
R0340cell5.setCellStyle(numberStyle);
} else {
R0340cell5.setCellValue("");
R0340cell5.setCellStyle(textStyle);
}

//ROW43
//Column G: 
Cell R0340cell6 = row.createCell(6);
if (record.getR0340_8_14days() != null) {
R0340cell6.setCellValue(record.getR0340_8_14days().doubleValue());
R0340cell6.setCellStyle(numberStyle);
} else {
R0340cell6.setCellValue("");
R0340cell6.setCellStyle(textStyle);
}

//ROW43
//Column H: 
Cell R0340cell7 = row.createCell(7);
if (record.getR0340_15days_1months() != null) {
R0340cell7.setCellValue(record.getR0340_15days_1months().doubleValue());
R0340cell7.setCellStyle(numberStyle);
} else {
R0340cell7.setCellValue("");
R0340cell7.setCellStyle(textStyle);
}

//ROW43
//Column I: 
Cell R0340cell8 = row.createCell(8);
if (record.getR0340_1_2months() != null) {
R0340cell8.setCellValue(record.getR0340_1_2months().doubleValue());
R0340cell8.setCellStyle(numberStyle);
} else {
R0340cell8.setCellValue("");
R0340cell8.setCellStyle(textStyle);
}
		
		
//ROW43
//Column J: 
Cell R0340cell9 = row.createCell(9);
if (record.getR0340_2_3months() != null) {
R0340cell9.setCellValue(record.getR0340_2_3months().doubleValue());
R0340cell9.setCellStyle(numberStyle);
} else {
R0340cell9.setCellValue("");
R0340cell9.setCellStyle(textStyle);
}

//ROW43
//Column K: 
Cell R0340cell10 = row.createCell(10);
if (record.getR0340_3_6months() != null) {
R0340cell10.setCellValue(record.getR0340_3_6months().doubleValue());
R0340cell10.setCellStyle(numberStyle);
} else {
R0340cell10.setCellValue("");
R0340cell10.setCellStyle(textStyle);
}

//ROW43
//Column L: 
Cell R0340cell11 = row.createCell(11);
if (record.getR0340_6_12months() != null) {
R0340cell11.setCellValue(record.getR0340_6_12months().doubleValue());
R0340cell11.setCellStyle(numberStyle);
} else {
R0340cell11.setCellValue("");
R0340cell11.setCellStyle(textStyle);
}

//ROW43
//Column M: 
Cell R0340cell12 = row.createCell(12);
if (record.getR0340_1_2years() != null) {
R0340cell12.setCellValue(record.getR0340_1_2years().doubleValue());
R0340cell12.setCellStyle(numberStyle);
} else {
R0340cell12.setCellValue("");
R0340cell12.setCellStyle(textStyle);
}

//ROW43
//Column N: 
Cell R0340cell13 = row.createCell(13);
if (record.getR0340_2_3years() != null) {
R0340cell13.setCellValue(record.getR0340_2_3years().doubleValue());
R0340cell13.setCellStyle(numberStyle);
} else {
R0340cell13.setCellValue("");
R0340cell13.setCellStyle(textStyle);
}

//ROW43
//Column O: 
Cell R0340cell14 = row.createCell(14);
if (record.getR0340_3_4years() != null) {
R0340cell14.setCellValue(record.getR0340_3_4years().doubleValue());
R0340cell14.setCellStyle(numberStyle);
} else {
R0340cell14.setCellValue("");
R0340cell14.setCellStyle(textStyle);
}

//ROW43
//Column P: 
Cell R0340cell15 = row.createCell(15);
if (record.getR0340_4_5years() != null) {
R0340cell15.setCellValue(record.getR0340_4_5years().doubleValue());
R0340cell15.setCellStyle(numberStyle);
} else {
R0340cell15.setCellValue("");
R0340cell15.setCellStyle(textStyle);
}

//ROW43
//Column Q: 
Cell R0340cell16 = row.createCell(16);
if (record.getR0340_5years() != null) {
R0340cell16.setCellValue(record.getR0340_5years().doubleValue());
R0340cell16.setCellStyle(numberStyle);
} else {
R0340cell16.setCellValue("");
R0340cell16.setCellStyle(textStyle);
}

//ROW43
//Column R: 
Cell R0340cell17 = row.createCell(17);
if (record.getR0340_non_interest() != null) {
R0340cell17.setCellValue(record.getR0340_non_interest().doubleValue());
R0340cell17.setCellStyle(numberStyle);
} else {
R0340cell17.setCellValue("");
R0340cell17.setCellStyle(textStyle);
}

/////ROW44///////////
//ROW44
//Column E: 
row = sheet.getRow(43);
Cell R0350cell4 = row.createCell(4);
if (record.getR0350_overdraft() != null) {
R0350cell4.setCellValue(record.getR0350_overdraft().doubleValue());
R0350cell4.setCellStyle(numberStyle);
} else {
R0350cell4.setCellValue("");
R0350cell4.setCellStyle(textStyle);
}

//ROW44
//Column F: 
Cell R0350cell5 = row.createCell(5);
if (record.getR0350_0_7days() != null) {
R0350cell5.setCellValue(record.getR0350_0_7days().doubleValue());
R0350cell5.setCellStyle(numberStyle);
} else {
R0350cell5.setCellValue("");
R0350cell5.setCellStyle(textStyle);
}

//ROW44
//Column G: 
Cell R0350cell6 = row.createCell(6);
if (record.getR0350_8_14days() != null) {
R0350cell6.setCellValue(record.getR0350_8_14days().doubleValue());
R0350cell6.setCellStyle(numberStyle);
} else {
R0350cell6.setCellValue("");
R0350cell6.setCellStyle(textStyle);
}

//ROW44
//Column H: 
Cell R0350cell7 = row.createCell(7);
if (record.getR0350_15days_1months() != null) {
R0350cell7.setCellValue(record.getR0350_15days_1months().doubleValue());
R0350cell7.setCellStyle(numberStyle);
} else {
R0350cell7.setCellValue("");
R0350cell7.setCellStyle(textStyle);
}

//ROW44
//Column I: 
Cell R0350cell8 = row.createCell(8);
if (record.getR0350_1_2months() != null) {
R0350cell8.setCellValue(record.getR0350_1_2months().doubleValue());
R0350cell8.setCellStyle(numberStyle);
} else {
R0350cell8.setCellValue("");
R0350cell8.setCellStyle(textStyle);
}
		
		
//ROW44
//Column J: 
Cell R0350cell9 = row.createCell(9);
if (record.getR0350_2_3months() != null) {
R0350cell9.setCellValue(record.getR0350_2_3months().doubleValue());
R0350cell9.setCellStyle(numberStyle);
} else {
R0350cell9.setCellValue("");
R0350cell9.setCellStyle(textStyle);
}

//ROW44
//Column K: 
Cell R0350cell10 = row.createCell(10);
if (record.getR0350_3_6months() != null) {
R0350cell10.setCellValue(record.getR0350_3_6months().doubleValue());
R0350cell10.setCellStyle(numberStyle);
} else {
R0350cell10.setCellValue("");
R0350cell10.setCellStyle(textStyle);
}

//ROW44
//Column L: 
Cell R0350cell11 = row.createCell(11);
if (record.getR0350_6_12months() != null) {
R0350cell11.setCellValue(record.getR0350_6_12months().doubleValue());
R0350cell11.setCellStyle(numberStyle);
} else {
R0350cell11.setCellValue("");
R0350cell11.setCellStyle(textStyle);
}

//ROW44
//Column M: 
Cell R0350cell12 = row.createCell(12);
if (record.getR0350_1_2years() != null) {
R0350cell12.setCellValue(record.getR0350_1_2years().doubleValue());
R0350cell12.setCellStyle(numberStyle);
} else {
R0350cell12.setCellValue("");
R0350cell12.setCellStyle(textStyle);
}

//ROW44
//Column N: 
Cell R0350cell13 = row.createCell(13);
if (record.getR0350_2_3years() != null) {
R0350cell13.setCellValue(record.getR0350_2_3years().doubleValue());
R0350cell13.setCellStyle(numberStyle);
} else {
R0350cell13.setCellValue("");
R0350cell13.setCellStyle(textStyle);
}

//ROW44
//Column O: 
Cell R0350cell14 = row.createCell(14);
if (record.getR0350_3_4years() != null) {
R0350cell14.setCellValue(record.getR0350_3_4years().doubleValue());
R0350cell14.setCellStyle(numberStyle);
} else {
R0350cell14.setCellValue("");
R0350cell14.setCellStyle(textStyle);
}

//ROW44
//Column P: 
Cell R0350cell15 = row.createCell(15);
if (record.getR0350_4_5years() != null) {
R0350cell15.setCellValue(record.getR0350_4_5years().doubleValue());
R0350cell15.setCellStyle(numberStyle);
} else {
R0350cell15.setCellValue("");
R0350cell15.setCellStyle(textStyle);
}

//ROW44
//Column Q: 
Cell R0350cell16 = row.createCell(16);
if (record.getR0350_5years() != null) {
R0350cell16.setCellValue(record.getR0350_5years().doubleValue());
R0350cell16.setCellStyle(numberStyle);
} else {
R0350cell16.setCellValue("");
R0350cell16.setCellStyle(textStyle);
}

//ROW44
//Column R: 
Cell R0350cell17 = row.createCell(17);
if (record.getR0350_non_interest() != null) {
R0350cell17.setCellValue(record.getR0350_non_interest().doubleValue());
R0350cell17.setCellStyle(numberStyle);
} else {
R0350cell17.setCellValue("");
R0350cell17.setCellStyle(textStyle);
}


/////ROW45///////////
//ROW45
//Column E: 
row = sheet.getRow(44);
Cell R0360cell4 = row.createCell(4);
if (record.getR0360_overdraft() != null) {
R0360cell4.setCellValue(record.getR0360_overdraft().doubleValue());
R0360cell4.setCellStyle(numberStyle);
} else {
R0360cell4.setCellValue("");
R0360cell4.setCellStyle(textStyle);
}

//ROW45
//Column F: 
Cell R0360cell5 = row.createCell(5);
if (record.getR0360_0_7days() != null) {
R0360cell5.setCellValue(record.getR0360_0_7days().doubleValue());
R0360cell5.setCellStyle(numberStyle);
} else {
R0360cell5.setCellValue("");
R0360cell5.setCellStyle(textStyle);
}

//ROW45
//Column G: 
Cell R0360cell6 = row.createCell(6);
if (record.getR0360_8_14days() != null) {
R0360cell6.setCellValue(record.getR0360_8_14days().doubleValue());
R0360cell6.setCellStyle(numberStyle);
} else {
R0360cell6.setCellValue("");
R0360cell6.setCellStyle(textStyle);
}

//ROW45
//Column H: 
Cell R0360cell7 = row.createCell(7);
if (record.getR0360_15days_1months() != null) {
R0360cell7.setCellValue(record.getR0360_15days_1months().doubleValue());
R0360cell7.setCellStyle(numberStyle);
} else {
R0360cell7.setCellValue("");
R0360cell7.setCellStyle(textStyle);
}

//ROW45
//Column I: 
Cell R0360cell8 = row.createCell(8);
if (record.getR0360_1_2months() != null) {
R0360cell8.setCellValue(record.getR0360_1_2months().doubleValue());
R0360cell8.setCellStyle(numberStyle);
} else {
R0360cell8.setCellValue("");
R0360cell8.setCellStyle(textStyle);
}
		
		
//ROW45
//Column J: 
Cell R0360cell9 = row.createCell(9);
if (record.getR0360_2_3months() != null) {
R0360cell9.setCellValue(record.getR0360_2_3months().doubleValue());
R0360cell9.setCellStyle(numberStyle);
} else {
R0360cell9.setCellValue("");
R0360cell9.setCellStyle(textStyle);
}

//ROW45
//Column K: 
Cell R0360cell10 = row.createCell(10);
if (record.getR0360_3_6months() != null) {
R0360cell10.setCellValue(record.getR0360_3_6months().doubleValue());
R0360cell10.setCellStyle(numberStyle);
} else {
R0360cell10.setCellValue("");
R0360cell10.setCellStyle(textStyle);
}

//ROW45
//Column L: 
Cell R0360cell11 = row.createCell(11);
if (record.getR0360_6_12months() != null) {
R0360cell11.setCellValue(record.getR0360_6_12months().doubleValue());
R0360cell11.setCellStyle(numberStyle);
} else {
R0360cell11.setCellValue("");
R0360cell11.setCellStyle(textStyle);
}

//ROW45
//Column M: 
Cell R0360cell12 = row.createCell(12);
if (record.getR0360_1_2years() != null) {
R0360cell12.setCellValue(record.getR0360_1_2years().doubleValue());
R0360cell12.setCellStyle(numberStyle);
} else {
R0360cell12.setCellValue("");
R0360cell12.setCellStyle(textStyle);
}

//ROW45
//Column N: 
Cell R0360cell13 = row.createCell(13);
if (record.getR0360_2_3years() != null) {
R0360cell13.setCellValue(record.getR0360_2_3years().doubleValue());
R0360cell13.setCellStyle(numberStyle);
} else {
R0360cell13.setCellValue("");
R0360cell13.setCellStyle(textStyle);
}

//ROW45
//Column O: 
Cell R0360cell14 = row.createCell(14);
if (record.getR0360_3_4years() != null) {
R0360cell14.setCellValue(record.getR0360_3_4years().doubleValue());
R0360cell14.setCellStyle(numberStyle);
} else {
R0360cell14.setCellValue("");
R0360cell14.setCellStyle(textStyle);
}

//ROW45
//Column P: 
Cell R0360cell15 = row.createCell(15);
if (record.getR0360_4_5years() != null) {
R0360cell15.setCellValue(record.getR0360_4_5years().doubleValue());
R0360cell15.setCellStyle(numberStyle);
} else {
R0360cell15.setCellValue("");
R0360cell15.setCellStyle(textStyle);
}

//ROW45
//Column Q: 
Cell R0360cell16 = row.createCell(16);
if (record.getR0360_5years() != null) {
R0360cell16.setCellValue(record.getR0360_5years().doubleValue());
R0360cell16.setCellStyle(numberStyle);
} else {
R0360cell16.setCellValue("");
R0360cell16.setCellStyle(textStyle);
}

//ROW45
//Column R: 
Cell R0360cell17 = row.createCell(17);
if (record.getR0360_non_interest() != null) {
R0360cell17.setCellValue(record.getR0360_non_interest().doubleValue());
R0360cell17.setCellStyle(numberStyle);
} else {
R0360cell17.setCellValue("");
R0360cell17.setCellStyle(textStyle);
}


/////ROW46///////////
//ROW46
//Column E: 
row = sheet.getRow(45);
Cell R0370cell4 = row.createCell(4);
if (record.getR0370_overdraft() != null) {
R0370cell4.setCellValue(record.getR0370_overdraft().doubleValue());
R0370cell4.setCellStyle(numberStyle);
} else {
R0370cell4.setCellValue("");
R0370cell4.setCellStyle(textStyle);
}

//ROW46
//Column F: 
Cell R0370cell5 = row.createCell(5);
if (record.getR0370_0_7days() != null) {
R0370cell5.setCellValue(record.getR0370_0_7days().doubleValue());
R0370cell5.setCellStyle(numberStyle);
} else {
R0370cell5.setCellValue("");
R0370cell5.setCellStyle(textStyle);
}

//ROW46
//Column G: 
Cell R0370cell6 = row.createCell(6);
if (record.getR0370_8_14days() != null) {
R0370cell6.setCellValue(record.getR0370_8_14days().doubleValue());
R0370cell6.setCellStyle(numberStyle);
} else {
R0370cell6.setCellValue("");
R0370cell6.setCellStyle(textStyle);
}

//ROW46
//Column H: 
Cell R0370cell7 = row.createCell(7);
if (record.getR0370_15days_1months() != null) {
R0370cell7.setCellValue(record.getR0370_15days_1months().doubleValue());
R0370cell7.setCellStyle(numberStyle);
} else {
R0370cell7.setCellValue("");
R0370cell7.setCellStyle(textStyle);
}

//ROW46
//Column I: 
Cell R0370cell8 = row.createCell(8);
if (record.getR0370_1_2months() != null) {
R0370cell8.setCellValue(record.getR0370_1_2months().doubleValue());
R0370cell8.setCellStyle(numberStyle);
} else {
R0370cell8.setCellValue("");
R0370cell8.setCellStyle(textStyle);
}
		
		
//ROW46
//Column J: 
Cell R0370cell9 = row.createCell(9);
if (record.getR0370_2_3months() != null) {
R0370cell9.setCellValue(record.getR0370_2_3months().doubleValue());
R0370cell9.setCellStyle(numberStyle);
} else {
R0370cell9.setCellValue("");
R0370cell9.setCellStyle(textStyle);
}

//ROW46
//Column K: 
Cell R0370cell10 = row.createCell(10);
if (record.getR0370_3_6months() != null) {
R0370cell10.setCellValue(record.getR0370_3_6months().doubleValue());
R0370cell10.setCellStyle(numberStyle);
} else {
R0370cell10.setCellValue("");
R0370cell10.setCellStyle(textStyle);
}

//ROW46
//Column L: 
Cell R0370cell11 = row.createCell(11);
if (record.getR0370_6_12months() != null) {
R0370cell11.setCellValue(record.getR0370_6_12months().doubleValue());
R0370cell11.setCellStyle(numberStyle);
} else {
R0370cell11.setCellValue("");
R0370cell11.setCellStyle(textStyle);
}

//ROW46
//Column M: 
Cell R0370cell12 = row.createCell(12);
if (record.getR0370_1_2years() != null) {
R0370cell12.setCellValue(record.getR0370_1_2years().doubleValue());
R0370cell12.setCellStyle(numberStyle);
} else {
R0370cell12.setCellValue("");
R0370cell12.setCellStyle(textStyle);
}

//ROW46
//Column N: 
Cell R0370cell13 = row.createCell(13);
if (record.getR0370_2_3years() != null) {
R0370cell13.setCellValue(record.getR0370_2_3years().doubleValue());
R0370cell13.setCellStyle(numberStyle);
} else {
R0370cell13.setCellValue("");
R0370cell13.setCellStyle(textStyle);
}

//ROW46
//Column O: 
Cell R0370cell14 = row.createCell(14);
if (record.getR0370_3_4years() != null) {
R0370cell14.setCellValue(record.getR0370_3_4years().doubleValue());
R0370cell14.setCellStyle(numberStyle);
} else {
R0370cell14.setCellValue("");
R0370cell14.setCellStyle(textStyle);
}

//ROW46
//Column P: 
Cell R0370cell15 = row.createCell(15);
if (record.getR0370_4_5years() != null) {
R0370cell15.setCellValue(record.getR0370_4_5years().doubleValue());
R0370cell15.setCellStyle(numberStyle);
} else {
R0370cell15.setCellValue("");
R0370cell15.setCellStyle(textStyle);
}

//ROW46
//Column Q: 
Cell R0370cell16 = row.createCell(16);
if (record.getR0370_5years() != null) {
R0370cell16.setCellValue(record.getR0370_5years().doubleValue());
R0370cell16.setCellStyle(numberStyle);
} else {
R0370cell16.setCellValue("");
R0370cell16.setCellStyle(textStyle);
}

//ROW46
//Column R: 
Cell R0370cell17 = row.createCell(17);
if (record.getR0370_non_interest() != null) {
R0370cell17.setCellValue(record.getR0370_non_interest().doubleValue());
R0370cell17.setCellStyle(numberStyle);
} else {
R0370cell17.setCellValue("");
R0370cell17.setCellStyle(textStyle);
}


/////ROW47///////////
//ROW47
//Column E: 
row = sheet.getRow(46);
Cell R0380cell4 = row.createCell(4);
if (record.getR0380_overdraft() != null) {
R0380cell4.setCellValue(record.getR0380_overdraft().doubleValue());
R0380cell4.setCellStyle(numberStyle);
} else {
R0380cell4.setCellValue("");
R0380cell4.setCellStyle(textStyle);
}

//ROW47
//Column F: 
Cell R0380cell5 = row.createCell(5);
if (record.getR0380_0_7days() != null) {
R0380cell5.setCellValue(record.getR0380_0_7days().doubleValue());
R0380cell5.setCellStyle(numberStyle);
} else {
R0380cell5.setCellValue("");
R0380cell5.setCellStyle(textStyle);
}

//ROW47
//Column G: 
Cell R0380cell6 = row.createCell(6);
if (record.getR0380_8_14days() != null) {
R0380cell6.setCellValue(record.getR0380_8_14days().doubleValue());
R0380cell6.setCellStyle(numberStyle);
} else {
R0380cell6.setCellValue("");
R0380cell6.setCellStyle(textStyle);
}

//ROW47
//Column H: 
Cell R0380cell7 = row.createCell(7);
if (record.getR0380_15days_1months() != null) {
R0380cell7.setCellValue(record.getR0380_15days_1months().doubleValue());
R0380cell7.setCellStyle(numberStyle);
} else {
R0380cell7.setCellValue("");
R0380cell7.setCellStyle(textStyle);
}

//ROW47
//Column I: 
Cell R0380cell8 = row.createCell(8);
if (record.getR0380_1_2months() != null) {
R0380cell8.setCellValue(record.getR0380_1_2months().doubleValue());
R0380cell8.setCellStyle(numberStyle);
} else {
R0380cell8.setCellValue("");
R0380cell8.setCellStyle(textStyle);
}
		
		
//ROW47
//Column J: 
Cell R0380cell9 = row.createCell(9);
if (record.getR0380_2_3months() != null) {
R0380cell9.setCellValue(record.getR0380_2_3months().doubleValue());
R0380cell9.setCellStyle(numberStyle);
} else {
R0380cell9.setCellValue("");
R0380cell9.setCellStyle(textStyle);
}

//ROW47
//Column K: 
Cell R0380cell10 = row.createCell(10);
if (record.getR0380_3_6months() != null) {
R0380cell10.setCellValue(record.getR0380_3_6months().doubleValue());
R0380cell10.setCellStyle(numberStyle);
} else {
R0380cell10.setCellValue("");
R0380cell10.setCellStyle(textStyle);
}

//ROW47
//Column L: 
Cell R0380cell11 = row.createCell(11);
if (record.getR0380_6_12months() != null) {
R0380cell11.setCellValue(record.getR0380_6_12months().doubleValue());
R0380cell11.setCellStyle(numberStyle);
} else {
R0380cell11.setCellValue("");
R0380cell11.setCellStyle(textStyle);
}

//ROW47
//Column M: 
Cell R0380cell12 = row.createCell(12);
if (record.getR0380_1_2years() != null) {
R0380cell12.setCellValue(record.getR0380_1_2years().doubleValue());
R0380cell12.setCellStyle(numberStyle);
} else {
R0380cell12.setCellValue("");
R0380cell12.setCellStyle(textStyle);
}

//ROW47
//Column N: 
Cell R0380cell13 = row.createCell(13);
if (record.getR0380_2_3years() != null) {
R0380cell13.setCellValue(record.getR0380_2_3years().doubleValue());
R0380cell13.setCellStyle(numberStyle);
} else {
R0380cell13.setCellValue("");
R0380cell13.setCellStyle(textStyle);
}

//ROW47
//Column O: 
Cell R0380cell14 = row.createCell(14);
if (record.getR0380_3_4years() != null) {
R0380cell14.setCellValue(record.getR0380_3_4years().doubleValue());
R0380cell14.setCellStyle(numberStyle);
} else {
R0380cell14.setCellValue("");
R0380cell14.setCellStyle(textStyle);
}

//ROW47
//Column P: 
Cell R0380cell15 = row.createCell(15);
if (record.getR0380_4_5years() != null) {
R0380cell15.setCellValue(record.getR0380_4_5years().doubleValue());
R0380cell15.setCellStyle(numberStyle);
} else {
R0380cell15.setCellValue("");
R0380cell15.setCellStyle(textStyle);
}

//ROW47
//Column Q: 
Cell R0380cell16 = row.createCell(16);
if (record.getR0380_5years() != null) {
R0380cell16.setCellValue(record.getR0380_5years().doubleValue());
R0380cell16.setCellStyle(numberStyle);
} else {
R0380cell16.setCellValue("");
R0380cell16.setCellStyle(textStyle);
}

//ROW47
//Column R: 
Cell R0380cell17 = row.createCell(17);
if (record.getR0380_non_interest() != null) {
R0380cell17.setCellValue(record.getR0380_non_interest().doubleValue());
R0380cell17.setCellStyle(numberStyle);
} else {
R0380cell17.setCellValue("");
R0380cell17.setCellStyle(textStyle);
}

/////ROW51///////////
//ROW51
//Column E: 
row = sheet.getRow(50);
Cell R0420cell4 = row.createCell(4);
if (record.getR0420_overdraft() != null) {
R0420cell4.setCellValue(record.getR0420_overdraft().doubleValue());
R0420cell4.setCellStyle(numberStyle);
} else {
R0420cell4.setCellValue("");
R0420cell4.setCellStyle(textStyle);
}

//ROW51
//Column F: 
Cell R0420cell5 = row.createCell(5);
if (record.getR0420_0_7days() != null) {
R0420cell5.setCellValue(record.getR0420_0_7days().doubleValue());
R0420cell5.setCellStyle(numberStyle);
} else {
R0420cell5.setCellValue("");
R0420cell5.setCellStyle(textStyle);
}

//ROW51
//Column G: 
Cell R0420cell6 = row.createCell(6);
if (record.getR0420_8_14days() != null) {
R0420cell6.setCellValue(record.getR0420_8_14days().doubleValue());
R0420cell6.setCellStyle(numberStyle);
} else {
R0420cell6.setCellValue("");
R0420cell6.setCellStyle(textStyle);
}

//ROW51
//Column H: 
Cell R0420cell7 = row.createCell(7);
if (record.getR0420_15days_1months() != null) {
R0420cell7.setCellValue(record.getR0420_15days_1months().doubleValue());
R0420cell7.setCellStyle(numberStyle);
} else {
R0420cell7.setCellValue("");
R0420cell7.setCellStyle(textStyle);
}

//ROW51
//Column I: 
Cell R0420cell8 = row.createCell(8);
if (record.getR0420_1_2months() != null) {
R0420cell8.setCellValue(record.getR0420_1_2months().doubleValue());
R0420cell8.setCellStyle(numberStyle);
} else {
R0420cell8.setCellValue("");
R0420cell8.setCellStyle(textStyle);
}
		
		
//ROW51
//Column J: 
Cell R0420cell9 = row.createCell(9);
if (record.getR0420_2_3months() != null) {
R0420cell9.setCellValue(record.getR0420_2_3months().doubleValue());
R0420cell9.setCellStyle(numberStyle);
} else {
R0420cell9.setCellValue("");
R0420cell9.setCellStyle(textStyle);
}

//ROW51
//Column K: 
Cell R0420cell10 = row.createCell(10);
if (record.getR0420_3_6months() != null) {
R0420cell10.setCellValue(record.getR0420_3_6months().doubleValue());
R0420cell10.setCellStyle(numberStyle);
} else {
R0420cell10.setCellValue("");
R0420cell10.setCellStyle(textStyle);
}

//ROW51
//Column L: 
Cell R0420cell11 = row.createCell(11);
if (record.getR0420_6_12months() != null) {
R0420cell11.setCellValue(record.getR0420_6_12months().doubleValue());
R0420cell11.setCellStyle(numberStyle);
} else {
R0420cell11.setCellValue("");
R0420cell11.setCellStyle(textStyle);
}

//ROW51
//Column M: 
Cell R0420cell12 = row.createCell(12);
if (record.getR0420_1_2years() != null) {
R0420cell12.setCellValue(record.getR0420_1_2years().doubleValue());
R0420cell12.setCellStyle(numberStyle);
} else {
R0420cell12.setCellValue("");
R0420cell12.setCellStyle(textStyle);
}

//ROW51
//Column N: 
Cell R0420cell13 = row.createCell(13);
if (record.getR0420_2_3years() != null) {
R0420cell13.setCellValue(record.getR0420_2_3years().doubleValue());
R0420cell13.setCellStyle(numberStyle);
} else {
R0420cell13.setCellValue("");
R0420cell13.setCellStyle(textStyle);
}

//ROW51
//Column O: 
Cell R0420cell14 = row.createCell(14);
if (record.getR0420_3_4years() != null) {
R0420cell14.setCellValue(record.getR0420_3_4years().doubleValue());
R0420cell14.setCellStyle(numberStyle);
} else {
R0420cell14.setCellValue("");
R0420cell14.setCellStyle(textStyle);
}

//ROW51
//Column P: 
Cell R0420cell15 = row.createCell(15);
if (record.getR0420_4_5years() != null) {
R0420cell15.setCellValue(record.getR0420_4_5years().doubleValue());
R0420cell15.setCellStyle(numberStyle);
} else {
R0420cell15.setCellValue("");
R0420cell15.setCellStyle(textStyle);
}

//ROW51
//Column Q: 
Cell R0420cell16 = row.createCell(16);
if (record.getR0420_5years() != null) {
R0420cell16.setCellValue(record.getR0420_5years().doubleValue());
R0420cell16.setCellStyle(numberStyle);
} else {
R0420cell16.setCellValue("");
R0420cell16.setCellStyle(textStyle);
}

//ROW51
//Column R: 
Cell R0420cell17 = row.createCell(17);
if (record.getR0420_non_interest() != null) {
R0420cell17.setCellValue(record.getR0420_non_interest().doubleValue());
R0420cell17.setCellStyle(numberStyle);
} else {
R0420cell17.setCellValue("");
R0420cell17.setCellStyle(textStyle);
}


/////ROW52///////////
//ROW52
//Column E: 
row = sheet.getRow(51);
Cell R0430cell4 = row.createCell(4);
if (record.getR0430_overdraft() != null) {
R0430cell4.setCellValue(record.getR0430_overdraft().doubleValue());
R0430cell4.setCellStyle(numberStyle);
} else {
R0430cell4.setCellValue("");
R0430cell4.setCellStyle(textStyle);
}

//ROW52
//Column F: 
Cell R0430cell5 = row.createCell(5);
if (record.getR0430_0_7days() != null) {
R0430cell5.setCellValue(record.getR0430_0_7days().doubleValue());
R0430cell5.setCellStyle(numberStyle);
} else {
R0430cell5.setCellValue("");
R0430cell5.setCellStyle(textStyle);
}

//ROW52
//Column G: 
Cell R0430cell6 = row.createCell(6);
if (record.getR0430_8_14days() != null) {
R0430cell6.setCellValue(record.getR0430_8_14days().doubleValue());
R0430cell6.setCellStyle(numberStyle);
} else {
R0430cell6.setCellValue("");
R0430cell6.setCellStyle(textStyle);
}

//ROW52
//Column H: 
Cell R0430cell7 = row.createCell(7);
if (record.getR0430_15days_1months() != null) {
R0430cell7.setCellValue(record.getR0430_15days_1months().doubleValue());
R0430cell7.setCellStyle(numberStyle);
} else {
R0430cell7.setCellValue("");
R0430cell7.setCellStyle(textStyle);
}

//ROW52
//Column I: 
Cell R0430cell8 = row.createCell(8);
if (record.getR0430_1_2months() != null) {
R0430cell8.setCellValue(record.getR0430_1_2months().doubleValue());
R0430cell8.setCellStyle(numberStyle);
} else {
R0430cell8.setCellValue("");
R0430cell8.setCellStyle(textStyle);
}
		
		
//ROW52
//Column J: 
Cell R0430cell9 = row.createCell(9);
if (record.getR0430_2_3months() != null) {
R0430cell9.setCellValue(record.getR0430_2_3months().doubleValue());
R0430cell9.setCellStyle(numberStyle);
} else {
R0430cell9.setCellValue("");
R0430cell9.setCellStyle(textStyle);
}

//ROW52
//Column K: 
Cell R0430cell10 = row.createCell(10);
if (record.getR0430_3_6months() != null) {
R0430cell10.setCellValue(record.getR0430_3_6months().doubleValue());
R0430cell10.setCellStyle(numberStyle);
} else {
R0430cell10.setCellValue("");
R0430cell10.setCellStyle(textStyle);
}

//ROW52
//Column L: 
Cell R0430cell11 = row.createCell(11);
if (record.getR0430_6_12months() != null) {
R0430cell11.setCellValue(record.getR0430_6_12months().doubleValue());
R0430cell11.setCellStyle(numberStyle);
} else {
R0430cell11.setCellValue("");
R0430cell11.setCellStyle(textStyle);
}

//ROW52
//Column M: 
Cell R0430cell12 = row.createCell(12);
if (record.getR0430_1_2years() != null) {
R0430cell12.setCellValue(record.getR0430_1_2years().doubleValue());
R0430cell12.setCellStyle(numberStyle);
} else {
R0430cell12.setCellValue("");
R0430cell12.setCellStyle(textStyle);
}

//ROW52
//Column N: 
Cell R0430cell13 = row.createCell(13);
if (record.getR0430_2_3years() != null) {
R0430cell13.setCellValue(record.getR0430_2_3years().doubleValue());
R0430cell13.setCellStyle(numberStyle);
} else {
R0430cell13.setCellValue("");
R0430cell13.setCellStyle(textStyle);
}

//ROW52
//Column O: 
Cell R0430cell14 = row.createCell(14);
if (record.getR0430_3_4years() != null) {
R0430cell14.setCellValue(record.getR0430_3_4years().doubleValue());
R0430cell14.setCellStyle(numberStyle);
} else {
R0430cell14.setCellValue("");
R0430cell14.setCellStyle(textStyle);
}

//ROW52
//Column P: 
Cell R0430cell15 = row.createCell(15);
if (record.getR0430_4_5years() != null) {
R0430cell15.setCellValue(record.getR0430_4_5years().doubleValue());
R0430cell15.setCellStyle(numberStyle);
} else {
R0430cell15.setCellValue("");
R0430cell15.setCellStyle(textStyle);
}

//ROW52
//Column Q: 
Cell R0430cell16 = row.createCell(16);
if (record.getR0430_5years() != null) {
R0430cell16.setCellValue(record.getR0430_5years().doubleValue());
R0430cell16.setCellStyle(numberStyle);
} else {
R0430cell16.setCellValue("");
R0430cell16.setCellStyle(textStyle);
}

//ROW52
//Column R: 
Cell R0430cell17 = row.createCell(17);
if (record.getR0430_non_interest() != null) {
R0430cell17.setCellValue(record.getR0430_non_interest().doubleValue());
R0430cell17.setCellStyle(numberStyle);
} else {
R0430cell17.setCellValue("");
R0430cell17.setCellStyle(textStyle);
}


/////ROW53///////////
//ROW53
//Column E: 
row = sheet.getRow(52);
Cell R0440cell4 = row.createCell(4);
if (record.getR0440_overdraft() != null) {
R0440cell4.setCellValue(record.getR0440_overdraft().doubleValue());
R0440cell4.setCellStyle(numberStyle);
} else {
R0440cell4.setCellValue("");
R0440cell4.setCellStyle(textStyle);
}

//ROW53
//Column F: 
Cell R0440cell5 = row.createCell(5);
if (record.getR0440_0_7days() != null) {
R0440cell5.setCellValue(record.getR0440_0_7days().doubleValue());
R0440cell5.setCellStyle(numberStyle);
} else {
R0440cell5.setCellValue("");
R0440cell5.setCellStyle(textStyle);
}

//ROW53
//Column G: 
Cell R0440cell6 = row.createCell(6);
if (record.getR0440_8_14days() != null) {
R0440cell6.setCellValue(record.getR0440_8_14days().doubleValue());
R0440cell6.setCellStyle(numberStyle);
} else {
R0440cell6.setCellValue("");
R0440cell6.setCellStyle(textStyle);
}

//ROW53
//Column H: 
Cell R0440cell7 = row.createCell(7);
if (record.getR0440_15days_1months() != null) {
R0440cell7.setCellValue(record.getR0440_15days_1months().doubleValue());
R0440cell7.setCellStyle(numberStyle);
} else {
R0440cell7.setCellValue("");
R0440cell7.setCellStyle(textStyle);
}

//ROW53
//Column I: 
Cell R0440cell8 = row.createCell(8);
if (record.getR0440_1_2months() != null) {
R0440cell8.setCellValue(record.getR0440_1_2months().doubleValue());
R0440cell8.setCellStyle(numberStyle);
} else {
R0440cell8.setCellValue("");
R0440cell8.setCellStyle(textStyle);
}
		
		
//ROW53
//Column J: 
Cell R0440cell9 = row.createCell(9);
if (record.getR0440_2_3months() != null) {
R0440cell9.setCellValue(record.getR0440_2_3months().doubleValue());
R0440cell9.setCellStyle(numberStyle);
} else {
R0440cell9.setCellValue("");
R0440cell9.setCellStyle(textStyle);
}

//ROW53
//Column K: 
Cell R0440cell10 = row.createCell(10);
if (record.getR0440_3_6months() != null) {
R0440cell10.setCellValue(record.getR0440_3_6months().doubleValue());
R0440cell10.setCellStyle(numberStyle);
} else {
R0440cell10.setCellValue("");
R0440cell10.setCellStyle(textStyle);
}

//ROW53
//Column L: 
Cell R0440cell11 = row.createCell(11);
if (record.getR0440_6_12months() != null) {
R0440cell11.setCellValue(record.getR0440_6_12months().doubleValue());
R0440cell11.setCellStyle(numberStyle);
} else {
R0440cell11.setCellValue("");
R0440cell11.setCellStyle(textStyle);
}

//ROW53
//Column M: 
Cell R0440cell12 = row.createCell(12);
if (record.getR0440_1_2years() != null) {
R0440cell12.setCellValue(record.getR0440_1_2years().doubleValue());
R0440cell12.setCellStyle(numberStyle);
} else {
R0440cell12.setCellValue("");
R0440cell12.setCellStyle(textStyle);
}

//ROW53
//Column N: 
Cell R0440cell13 = row.createCell(13);
if (record.getR0440_2_3years() != null) {
R0440cell13.setCellValue(record.getR0440_2_3years().doubleValue());
R0440cell13.setCellStyle(numberStyle);
} else {
R0440cell13.setCellValue("");
R0440cell13.setCellStyle(textStyle);
}

//ROW53
//Column O: 
Cell R0440cell14 = row.createCell(14);
if (record.getR0440_3_4years() != null) {
R0440cell14.setCellValue(record.getR0440_3_4years().doubleValue());
R0440cell14.setCellStyle(numberStyle);
} else {
R0440cell14.setCellValue("");
R0440cell14.setCellStyle(textStyle);
}

//ROW53
//Column P: 
Cell R0440cell15 = row.createCell(15);
if (record.getR0440_4_5years() != null) {
R0440cell15.setCellValue(record.getR0440_4_5years().doubleValue());
R0440cell15.setCellStyle(numberStyle);
} else {
R0440cell15.setCellValue("");
R0440cell15.setCellStyle(textStyle);
}

//ROW53
//Column Q: 
Cell R0440cell16 = row.createCell(16);
if (record.getR0440_5years() != null) {
R0440cell16.setCellValue(record.getR0440_5years().doubleValue());
R0440cell16.setCellStyle(numberStyle);
} else {
R0440cell16.setCellValue("");
R0440cell16.setCellStyle(textStyle);
}

//ROW53
//Column R: 
Cell R0440cell17 = row.createCell(17);
if (record.getR0440_non_interest() != null) {
R0440cell17.setCellValue(record.getR0440_non_interest().doubleValue());
R0440cell17.setCellStyle(numberStyle);
} else {
R0440cell17.setCellValue("");
R0440cell17.setCellStyle(textStyle);
}


/////ROW54///////////
//ROW54
//Column E: 
row = sheet.getRow(53);
Cell R0450cell4 = row.createCell(4);
if (record.getR0450_overdraft() != null) {
R0450cell4.setCellValue(record.getR0450_overdraft().doubleValue());
R0450cell4.setCellStyle(numberStyle);
} else {
R0450cell4.setCellValue("");
R0450cell4.setCellStyle(textStyle);
}

//ROW54
//Column F: 
Cell R0450cell5 = row.createCell(5);
if (record.getR0450_0_7days() != null) {
R0450cell5.setCellValue(record.getR0450_0_7days().doubleValue());
R0450cell5.setCellStyle(numberStyle);
} else {
R0450cell5.setCellValue("");
R0450cell5.setCellStyle(textStyle);
}

//ROW54
//Column G: 
Cell R0450cell6 = row.createCell(6);
if (record.getR0450_8_14days() != null) {
R0450cell6.setCellValue(record.getR0450_8_14days().doubleValue());
R0450cell6.setCellStyle(numberStyle);
} else {
R0450cell6.setCellValue("");
R0450cell6.setCellStyle(textStyle);
}

//ROW54
//Column H: 
Cell R0450cell7 = row.createCell(7);
if (record.getR0450_15days_1months() != null) {
R0450cell7.setCellValue(record.getR0450_15days_1months().doubleValue());
R0450cell7.setCellStyle(numberStyle);
} else {
R0450cell7.setCellValue("");
R0450cell7.setCellStyle(textStyle);
}

//ROW54
//Column I: 
Cell R0450cell8 = row.createCell(8);
if (record.getR0450_1_2months() != null) {
R0450cell8.setCellValue(record.getR0450_1_2months().doubleValue());
R0450cell8.setCellStyle(numberStyle);
} else {
R0450cell8.setCellValue("");
R0450cell8.setCellStyle(textStyle);
}
		
		
//ROW54
//Column J: 
Cell R0450cell9 = row.createCell(9);
if (record.getR0450_2_3months() != null) {
R0450cell9.setCellValue(record.getR0450_2_3months().doubleValue());
R0450cell9.setCellStyle(numberStyle);
} else {
R0450cell9.setCellValue("");
R0450cell9.setCellStyle(textStyle);
}

//ROW54
//Column K: 
Cell R0450cell10 = row.createCell(10);
if (record.getR0450_3_6months() != null) {
R0450cell10.setCellValue(record.getR0450_3_6months().doubleValue());
R0450cell10.setCellStyle(numberStyle);
} else {
R0450cell10.setCellValue("");
R0450cell10.setCellStyle(textStyle);
}

//ROW54
//Column L: 
Cell R0450cell11 = row.createCell(11);
if (record.getR0450_6_12months() != null) {
R0450cell11.setCellValue(record.getR0450_6_12months().doubleValue());
R0450cell11.setCellStyle(numberStyle);
} else {
R0450cell11.setCellValue("");
R0450cell11.setCellStyle(textStyle);
}

//ROW54
//Column M: 
Cell R0450cell12 = row.createCell(12);
if (record.getR0450_1_2years() != null) {
R0450cell12.setCellValue(record.getR0450_1_2years().doubleValue());
R0450cell12.setCellStyle(numberStyle);
} else {
R0450cell12.setCellValue("");
R0450cell12.setCellStyle(textStyle);
}

//ROW54
//Column N: 
Cell R0450cell13 = row.createCell(13);
if (record.getR0450_2_3years() != null) {
R0450cell13.setCellValue(record.getR0450_2_3years().doubleValue());
R0450cell13.setCellStyle(numberStyle);
} else {
R0450cell13.setCellValue("");
R0450cell13.setCellStyle(textStyle);
}

//ROW54
//Column O: 
Cell R0450cell14 = row.createCell(14);
if (record.getR0450_3_4years() != null) {
R0450cell14.setCellValue(record.getR0450_3_4years().doubleValue());
R0450cell14.setCellStyle(numberStyle);
} else {
R0450cell14.setCellValue("");
R0450cell14.setCellStyle(textStyle);
}

//ROW54
//Column P: 
Cell R0450cell15 = row.createCell(15);
if (record.getR0450_4_5years() != null) {
R0450cell15.setCellValue(record.getR0450_4_5years().doubleValue());
R0450cell15.setCellStyle(numberStyle);
} else {
R0450cell15.setCellValue("");
R0450cell15.setCellStyle(textStyle);
}

//ROW54
//Column Q: 
Cell R0450cell16 = row.createCell(16);
if (record.getR0450_5years() != null) {
R0450cell16.setCellValue(record.getR0450_5years().doubleValue());
R0450cell16.setCellStyle(numberStyle);
} else {
R0450cell16.setCellValue("");
R0450cell16.setCellStyle(textStyle);
}

//ROW54
//Column R: 
Cell R0450cell17 = row.createCell(17);
if (record.getR0450_non_interest() != null) {
R0450cell17.setCellValue(record.getR0450_non_interest().doubleValue());
R0450cell17.setCellStyle(numberStyle);
} else {
R0450cell17.setCellValue("");
R0450cell17.setCellStyle(textStyle);
}


/////ROW55///////////
//ROW55
//Column E: 
row = sheet.getRow(54);
Cell R0460cell4 = row.createCell(4);
if (record.getR0460_overdraft() != null) {
R0460cell4.setCellValue(record.getR0460_overdraft().doubleValue());
R0460cell4.setCellStyle(numberStyle);
} else {
R0460cell4.setCellValue("");
R0460cell4.setCellStyle(textStyle);
}

//ROW55
//Column F: 
Cell R0460cell5 = row.createCell(5);
if (record.getR0460_0_7days() != null) {
R0460cell5.setCellValue(record.getR0460_0_7days().doubleValue());
R0460cell5.setCellStyle(numberStyle);
} else {
R0460cell5.setCellValue("");
R0460cell5.setCellStyle(textStyle);
}

//ROW55
//Column G: 
Cell R0460cell6 = row.createCell(6);
if (record.getR0460_8_14days() != null) {
R0460cell6.setCellValue(record.getR0460_8_14days().doubleValue());
R0460cell6.setCellStyle(numberStyle);
} else {
R0460cell6.setCellValue("");
R0460cell6.setCellStyle(textStyle);
}

//ROW55
//Column H: 
Cell R0460cell7 = row.createCell(7);
if (record.getR0460_15days_1months() != null) {
R0460cell7.setCellValue(record.getR0460_15days_1months().doubleValue());
R0460cell7.setCellStyle(numberStyle);
} else {
R0460cell7.setCellValue("");
R0460cell7.setCellStyle(textStyle);
}

//ROW55
//Column I: 
Cell R0460cell8 = row.createCell(8);
if (record.getR0460_1_2months() != null) {
R0460cell8.setCellValue(record.getR0460_1_2months().doubleValue());
R0460cell8.setCellStyle(numberStyle);
} else {
R0460cell8.setCellValue("");
R0460cell8.setCellStyle(textStyle);
}
		
		
//ROW55
//Column J: 
Cell R0460cell9 = row.createCell(9);
if (record.getR0460_2_3months() != null) {
R0460cell9.setCellValue(record.getR0460_2_3months().doubleValue());
R0460cell9.setCellStyle(numberStyle);
} else {
R0460cell9.setCellValue("");
R0460cell9.setCellStyle(textStyle);
}

//ROW55
//Column K: 
Cell R0460cell10 = row.createCell(10);
if (record.getR0460_3_6months() != null) {
R0460cell10.setCellValue(record.getR0460_3_6months().doubleValue());
R0460cell10.setCellStyle(numberStyle);
} else {
R0460cell10.setCellValue("");
R0460cell10.setCellStyle(textStyle);
}

//ROW55
//Column L: 
Cell R0460cell11 = row.createCell(11);
if (record.getR0460_6_12months() != null) {
R0460cell11.setCellValue(record.getR0460_6_12months().doubleValue());
R0460cell11.setCellStyle(numberStyle);
} else {
R0460cell11.setCellValue("");
R0460cell11.setCellStyle(textStyle);
}

//ROW55
//Column M: 
Cell R0460cell12 = row.createCell(12);
if (record.getR0460_1_2years() != null) {
R0460cell12.setCellValue(record.getR0460_1_2years().doubleValue());
R0460cell12.setCellStyle(numberStyle);
} else {
R0460cell12.setCellValue("");
R0460cell12.setCellStyle(textStyle);
}

//ROW55
//Column N: 
Cell R0460cell13 = row.createCell(13);
if (record.getR0460_2_3years() != null) {
R0460cell13.setCellValue(record.getR0460_2_3years().doubleValue());
R0460cell13.setCellStyle(numberStyle);
} else {
R0460cell13.setCellValue("");
R0460cell13.setCellStyle(textStyle);
}

//ROW55
//Column O: 
Cell R0460cell14 = row.createCell(14);
if (record.getR0460_3_4years() != null) {
R0460cell14.setCellValue(record.getR0460_3_4years().doubleValue());
R0460cell14.setCellStyle(numberStyle);
} else {
R0460cell14.setCellValue("");
R0460cell14.setCellStyle(textStyle);
}

//ROW55
//Column P: 
Cell R0460cell15 = row.createCell(15);
if (record.getR0460_4_5years() != null) {
R0460cell15.setCellValue(record.getR0460_4_5years().doubleValue());
R0460cell15.setCellStyle(numberStyle);
} else {
R0460cell15.setCellValue("");
R0460cell15.setCellStyle(textStyle);
}

//ROW55
//Column Q: 
Cell R0460cell16 = row.createCell(16);
if (record.getR0460_5years() != null) {
R0460cell16.setCellValue(record.getR0460_5years().doubleValue());
R0460cell16.setCellStyle(numberStyle);
} else {
R0460cell16.setCellValue("");
R0460cell16.setCellStyle(textStyle);
}

//ROW55
//Column R: 
Cell R0460cell17 = row.createCell(17);
if (record.getR0460_non_interest() != null) {
R0460cell17.setCellValue(record.getR0460_non_interest().doubleValue());
R0460cell17.setCellStyle(numberStyle);
} else {
R0460cell17.setCellValue("");
R0460cell17.setCellStyle(textStyle);
}


/////ROW57///////////
//ROW57
//Column E: 
row = sheet.getRow(56);
Cell R0480cell4 = row.createCell(4);
if (record.getR0480_overdraft() != null) {
R0480cell4.setCellValue(record.getR0480_overdraft().doubleValue());
R0480cell4.setCellStyle(numberStyle);
} else {
R0480cell4.setCellValue("");
R0480cell4.setCellStyle(textStyle);
}

//ROW57
//Column F: 
Cell R0480cell5 = row.createCell(5);
if (record.getR0480_0_7days() != null) {
R0480cell5.setCellValue(record.getR0480_0_7days().doubleValue());
R0480cell5.setCellStyle(numberStyle);
} else {
R0480cell5.setCellValue("");
R0480cell5.setCellStyle(textStyle);
}

//ROW57
//Column G: 
Cell R0480cell6 = row.createCell(6);
if (record.getR0480_8_14days() != null) {
R0480cell6.setCellValue(record.getR0480_8_14days().doubleValue());
R0480cell6.setCellStyle(numberStyle);
} else {
R0480cell6.setCellValue("");
R0480cell6.setCellStyle(textStyle);
}

//ROW57
//Column H: 
Cell R0480cell7 = row.createCell(7);
if (record.getR0480_15days_1months() != null) {
R0480cell7.setCellValue(record.getR0480_15days_1months().doubleValue());
R0480cell7.setCellStyle(numberStyle);
} else {
R0480cell7.setCellValue("");
R0480cell7.setCellStyle(textStyle);
}

//ROW57
//Column I: 
Cell R0480cell8 = row.createCell(8);
if (record.getR0480_1_2months() != null) {
R0480cell8.setCellValue(record.getR0480_1_2months().doubleValue());
R0480cell8.setCellStyle(numberStyle);
} else {
R0480cell8.setCellValue("");
R0480cell8.setCellStyle(textStyle);
}
		
		
//ROW57
//Column J: 
Cell R0480cell9 = row.createCell(9);
if (record.getR0480_2_3months() != null) {
R0480cell9.setCellValue(record.getR0480_2_3months().doubleValue());
R0480cell9.setCellStyle(numberStyle);
} else {
R0480cell9.setCellValue("");
R0480cell9.setCellStyle(textStyle);
}

//ROW57
//Column K: 
Cell R0480cell10 = row.createCell(10);
if (record.getR0480_3_6months() != null) {
R0480cell10.setCellValue(record.getR0480_3_6months().doubleValue());
R0480cell10.setCellStyle(numberStyle);
} else {
R0480cell10.setCellValue("");
R0480cell10.setCellStyle(textStyle);
}

//ROW57
//Column L: 
Cell R0480cell11 = row.createCell(11);
if (record.getR0480_6_12months() != null) {
R0480cell11.setCellValue(record.getR0480_6_12months().doubleValue());
R0480cell11.setCellStyle(numberStyle);
} else {
R0480cell11.setCellValue("");
R0480cell11.setCellStyle(textStyle);
}

//ROW57
//Column M: 
Cell R0480cell12 = row.createCell(12);
if (record.getR0480_1_2years() != null) {
R0480cell12.setCellValue(record.getR0480_1_2years().doubleValue());
R0480cell12.setCellStyle(numberStyle);
} else {
R0480cell12.setCellValue("");
R0480cell12.setCellStyle(textStyle);
}

//ROW57
//Column N: 
Cell R0480cell13 = row.createCell(13);
if (record.getR0480_2_3years() != null) {
R0480cell13.setCellValue(record.getR0480_2_3years().doubleValue());
R0480cell13.setCellStyle(numberStyle);
} else {
R0480cell13.setCellValue("");
R0480cell13.setCellStyle(textStyle);
}

//ROW57
//Column O: 
Cell R0480cell14 = row.createCell(14);
if (record.getR0480_3_4years() != null) {
R0480cell14.setCellValue(record.getR0480_3_4years().doubleValue());
R0480cell14.setCellStyle(numberStyle);
} else {
R0480cell14.setCellValue("");
R0480cell14.setCellStyle(textStyle);
}

//ROW57
//Column P: 
Cell R0480cell15 = row.createCell(15);
if (record.getR0480_4_5years() != null) {
R0480cell15.setCellValue(record.getR0480_4_5years().doubleValue());
R0480cell15.setCellStyle(numberStyle);
} else {
R0480cell15.setCellValue("");
R0480cell15.setCellStyle(textStyle);
}

//ROW57
//Column Q: 
Cell R0480cell16 = row.createCell(16);
if (record.getR0480_5years() != null) {
R0480cell16.setCellValue(record.getR0480_5years().doubleValue());
R0480cell16.setCellStyle(numberStyle);
} else {
R0480cell16.setCellValue("");
R0480cell16.setCellStyle(textStyle);
}

//ROW57
//Column R: 
Cell R0480cell17 = row.createCell(17);
if (record.getR0480_non_interest() != null) {
R0480cell17.setCellValue(record.getR0480_non_interest().doubleValue());
R0480cell17.setCellStyle(numberStyle);
} else {
R0480cell17.setCellValue("");
R0480cell17.setCellStyle(textStyle);
}

/////ROW58///////////
//ROW58
//Column E: 
row = sheet.getRow(57);
Cell R0490cell4 = row.createCell(4);
if (record.getR0490_overdraft() != null) {
R0490cell4.setCellValue(record.getR0490_overdraft().doubleValue());
R0490cell4.setCellStyle(numberStyle);
} else {
R0490cell4.setCellValue("");
R0490cell4.setCellStyle(textStyle);
}

//ROW58
//Column F: 
Cell R0490cell5 = row.createCell(5);
if (record.getR0490_0_7days() != null) {
R0490cell5.setCellValue(record.getR0490_0_7days().doubleValue());
R0490cell5.setCellStyle(numberStyle);
} else {
R0490cell5.setCellValue("");
R0490cell5.setCellStyle(textStyle);
}

//ROW58
//Column G: 
Cell R0490cell6 = row.createCell(6);
if (record.getR0490_8_14days() != null) {
R0490cell6.setCellValue(record.getR0490_8_14days().doubleValue());
R0490cell6.setCellStyle(numberStyle);
} else {
R0490cell6.setCellValue("");
R0490cell6.setCellStyle(textStyle);
}

//ROW58
//Column H: 
Cell R0490cell7 = row.createCell(7);
if (record.getR0490_15days_1months() != null) {
R0490cell7.setCellValue(record.getR0490_15days_1months().doubleValue());
R0490cell7.setCellStyle(numberStyle);
} else {
R0490cell7.setCellValue("");
R0490cell7.setCellStyle(textStyle);
}

//ROW58
//Column I: 
Cell R0490cell8 = row.createCell(8);
if (record.getR0490_1_2months() != null) {
R0490cell8.setCellValue(record.getR0490_1_2months().doubleValue());
R0490cell8.setCellStyle(numberStyle);
} else {
R0490cell8.setCellValue("");
R0490cell8.setCellStyle(textStyle);
}
		
		
//ROW58
//Column J: 
Cell R0490cell9 = row.createCell(9);
if (record.getR0490_2_3months() != null) {
R0490cell9.setCellValue(record.getR0490_2_3months().doubleValue());
R0490cell9.setCellStyle(numberStyle);
} else {
R0490cell9.setCellValue("");
R0490cell9.setCellStyle(textStyle);
}

//ROW58
//Column K: 
Cell R0490cell10 = row.createCell(10);
if (record.getR0490_3_6months() != null) {
R0490cell10.setCellValue(record.getR0490_3_6months().doubleValue());
R0490cell10.setCellStyle(numberStyle);
} else {
R0490cell10.setCellValue("");
R0490cell10.setCellStyle(textStyle);
}

//ROW58
//Column L: 
Cell R0490cell11 = row.createCell(11);
if (record.getR0490_6_12months() != null) {
R0490cell11.setCellValue(record.getR0490_6_12months().doubleValue());
R0490cell11.setCellStyle(numberStyle);
} else {
R0490cell11.setCellValue("");
R0490cell11.setCellStyle(textStyle);
}

//ROW58
//Column M: 
Cell R0490cell12 = row.createCell(12);
if (record.getR0490_1_2years() != null) {
R0490cell12.setCellValue(record.getR0490_1_2years().doubleValue());
R0490cell12.setCellStyle(numberStyle);
} else {
R0490cell12.setCellValue("");
R0490cell12.setCellStyle(textStyle);
}

//ROW58
//Column N: 
Cell R0490cell13 = row.createCell(13);
if (record.getR0490_2_3years() != null) {
R0490cell13.setCellValue(record.getR0490_2_3years().doubleValue());
R0490cell13.setCellStyle(numberStyle);
} else {
R0490cell13.setCellValue("");
R0490cell13.setCellStyle(textStyle);
}

//ROW58
//Column O: 
Cell R0490cell14 = row.createCell(14);
if (record.getR0490_3_4years() != null) {
R0490cell14.setCellValue(record.getR0490_3_4years().doubleValue());
R0490cell14.setCellStyle(numberStyle);
} else {
R0490cell14.setCellValue("");
R0490cell14.setCellStyle(textStyle);
}

//ROW58
//Column P: 
Cell R0490cell15 = row.createCell(15);
if (record.getR0490_4_5years() != null) {
R0490cell15.setCellValue(record.getR0490_4_5years().doubleValue());
R0490cell15.setCellStyle(numberStyle);
} else {
R0490cell15.setCellValue("");
R0490cell15.setCellStyle(textStyle);
}

//ROW58
//Column Q: 
Cell R0490cell16 = row.createCell(16);
if (record.getR0490_5years() != null) {
R0490cell16.setCellValue(record.getR0490_5years().doubleValue());
R0490cell16.setCellStyle(numberStyle);
} else {
R0490cell16.setCellValue("");
R0490cell16.setCellStyle(textStyle);
}

//ROW58
//Column R: 
Cell R0490cell17 = row.createCell(17);
if (record.getR0490_non_interest() != null) {
R0490cell17.setCellValue(record.getR0490_non_interest().doubleValue());
R0490cell17.setCellStyle(numberStyle);
} else {
R0490cell17.setCellValue("");
R0490cell17.setCellStyle(textStyle);
}


/////ROW59///////////
//ROW59
//Column E: 
row = sheet.getRow(58);
Cell R0500cell4 = row.createCell(4);
if (record.getR0500_overdraft() != null) {
R0500cell4.setCellValue(record.getR0500_overdraft().doubleValue());
R0500cell4.setCellStyle(numberStyle);
} else {
R0500cell4.setCellValue("");
R0500cell4.setCellStyle(textStyle);
}

//ROW59
//Column F: 
Cell R0500cell5 = row.createCell(5);
if (record.getR0500_0_7days() != null) {
R0500cell5.setCellValue(record.getR0500_0_7days().doubleValue());
R0500cell5.setCellStyle(numberStyle);
} else {
R0500cell5.setCellValue("");
R0500cell5.setCellStyle(textStyle);
}

//ROW59
//Column G: 
Cell R0500cell6 = row.createCell(6);
if (record.getR0500_8_14days() != null) {
R0500cell6.setCellValue(record.getR0500_8_14days().doubleValue());
R0500cell6.setCellStyle(numberStyle);
} else {
R0500cell6.setCellValue("");
R0500cell6.setCellStyle(textStyle);
}

//ROW59
//Column H: 
Cell R0500cell7 = row.createCell(7);
if (record.getR0500_15days_1months() != null) {
R0500cell7.setCellValue(record.getR0500_15days_1months().doubleValue());
R0500cell7.setCellStyle(numberStyle);
} else {
R0500cell7.setCellValue("");
R0500cell7.setCellStyle(textStyle);
}

//ROW59
//Column I: 
Cell R0500cell8 = row.createCell(8);
if (record.getR0500_1_2months() != null) {
R0500cell8.setCellValue(record.getR0500_1_2months().doubleValue());
R0500cell8.setCellStyle(numberStyle);
} else {
R0500cell8.setCellValue("");
R0500cell8.setCellStyle(textStyle);
}
		
		
//ROW59
//Column J: 
Cell R0500cell9 = row.createCell(9);
if (record.getR0500_2_3months() != null) {
R0500cell9.setCellValue(record.getR0500_2_3months().doubleValue());
R0500cell9.setCellStyle(numberStyle);
} else {
R0500cell9.setCellValue("");
R0500cell9.setCellStyle(textStyle);
}

//ROW59
//Column K: 
Cell R0500cell10 = row.createCell(10);
if (record.getR0500_3_6months() != null) {
R0500cell10.setCellValue(record.getR0500_3_6months().doubleValue());
R0500cell10.setCellStyle(numberStyle);
} else {
R0500cell10.setCellValue("");
R0500cell10.setCellStyle(textStyle);
}

//ROW59
//Column L: 
Cell R0500cell11 = row.createCell(11);
if (record.getR0500_6_12months() != null) {
R0500cell11.setCellValue(record.getR0500_6_12months().doubleValue());
R0500cell11.setCellStyle(numberStyle);
} else {
R0500cell11.setCellValue("");
R0500cell11.setCellStyle(textStyle);
}

//ROW59
//Column M: 
Cell R0500cell12 = row.createCell(12);
if (record.getR0500_1_2years() != null) {
R0500cell12.setCellValue(record.getR0500_1_2years().doubleValue());
R0500cell12.setCellStyle(numberStyle);
} else {
R0500cell12.setCellValue("");
R0500cell12.setCellStyle(textStyle);
}

//ROW59
//Column N: 
Cell R0500cell13 = row.createCell(13);
if (record.getR0500_2_3years() != null) {
R0500cell13.setCellValue(record.getR0500_2_3years().doubleValue());
R0500cell13.setCellStyle(numberStyle);
} else {
R0500cell13.setCellValue("");
R0500cell13.setCellStyle(textStyle);
}

//ROW59
//Column O: 
Cell R0500cell14 = row.createCell(14);
if (record.getR0500_3_4years() != null) {
R0500cell14.setCellValue(record.getR0500_3_4years().doubleValue());
R0500cell14.setCellStyle(numberStyle);
} else {
R0500cell14.setCellValue("");
R0500cell14.setCellStyle(textStyle);
}

//ROW59
//Column P: 
Cell R0500cell15 = row.createCell(15);
if (record.getR0500_4_5years() != null) {
R0500cell15.setCellValue(record.getR0500_4_5years().doubleValue());
R0500cell15.setCellStyle(numberStyle);
} else {
R0500cell15.setCellValue("");
R0500cell15.setCellStyle(textStyle);
}

//ROW59
//Column Q: 
Cell R0500cell16 = row.createCell(16);
if (record.getR0500_5years() != null) {
R0500cell16.setCellValue(record.getR0500_5years().doubleValue());
R0500cell16.setCellStyle(numberStyle);
} else {
R0500cell16.setCellValue("");
R0500cell16.setCellStyle(textStyle);
}

//ROW59
//Column R: 
Cell R0500cell17 = row.createCell(17);
if (record.getR0500_non_interest() != null) {
R0500cell17.setCellValue(record.getR0500_non_interest().doubleValue());
R0500cell17.setCellStyle(numberStyle);
} else {
R0500cell17.setCellValue("");
R0500cell17.setCellStyle(textStyle);
}




				}
			

int startRow1 = 60;

// dataList1 for entity 2
if (!dataList1.isEmpty()) {
 for (int i = 0; i < dataList1.size(); i++) {
     CBUAE_BRF2_5_Summary_Entity2 record1 = dataList1.get(i);

     System.out.println("rownumber = " + startRow + i);
     Row row = sheet.getRow(startRow + i);
     if (row == null) {
         row = sheet.createRow(startRow + i);
     }


 /////ROW60///////////
   //ROW60
   //Column E: 
   row = sheet.getRow(59);
   Cell R0510cell4 = row.createCell(4);
   if (record1.getR0510_overdraft() != null) {
   R0510cell4.setCellValue(record1.getR0510_overdraft().doubleValue());
   R0510cell4.setCellStyle(numberStyle);
   } else {
   R0510cell4.setCellValue("");
   R0510cell4.setCellStyle(textStyle);
   }

   //ROW60
   //Column F: 
   Cell R0510cell5 = row.createCell(5);
   if (record1.getR0510_0_7days() != null) {
   R0510cell5.setCellValue(record1.getR0510_0_7days().doubleValue());
   R0510cell5.setCellStyle(numberStyle);
   } else {
   R0510cell5.setCellValue("");
   R0510cell5.setCellStyle(textStyle);
   }

   //ROW60
   //Column G: 
   Cell R0510cell6 = row.createCell(6);
   if (record1.getR0510_8_14days() != null) {
   R0510cell6.setCellValue(record1.getR0510_8_14days().doubleValue());
   R0510cell6.setCellStyle(numberStyle);
   } else {
   R0510cell6.setCellValue("");
   R0510cell6.setCellStyle(textStyle);
   }

   //ROW60
   //Column H: 
   Cell R0510cell7 = row.createCell(7);
   if (record1.getR0510_15days_1months() != null) {
   R0510cell7.setCellValue(record1.getR0510_15days_1months().doubleValue());
   R0510cell7.setCellStyle(numberStyle);
   } else {
   R0510cell7.setCellValue("");
   R0510cell7.setCellStyle(textStyle);
   }

   //ROW60
   //Column I: 
   Cell R0510cell8 = row.createCell(8);
   if (record1.getR0510_1_2months() != null) {
   R0510cell8.setCellValue(record1.getR0510_1_2months().doubleValue());
   R0510cell8.setCellStyle(numberStyle);
   } else {
   R0510cell8.setCellValue("");
   R0510cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW60
   //Column J: 
   Cell R0510cell9 = row.createCell(9);
   if (record1.getR0510_2_3months() != null) {
   R0510cell9.setCellValue(record1.getR0510_2_3months().doubleValue());
   R0510cell9.setCellStyle(numberStyle);
   } else {
   R0510cell9.setCellValue("");
   R0510cell9.setCellStyle(textStyle);
   }

   //ROW60
   //Column K: 
   Cell R0510cell10 = row.createCell(10);
   if (record1.getR0510_3_6months() != null) {
   R0510cell10.setCellValue(record1.getR0510_3_6months().doubleValue());
   R0510cell10.setCellStyle(numberStyle);
   } else {
   R0510cell10.setCellValue("");
   R0510cell10.setCellStyle(textStyle);
   }

   //ROW60
   //Column L: 
   Cell R0510cell11 = row.createCell(11);
   if (record1.getR0510_6_12months() != null) {
   R0510cell11.setCellValue(record1.getR0510_6_12months().doubleValue());
   R0510cell11.setCellStyle(numberStyle);
   } else {
   R0510cell11.setCellValue("");
   R0510cell11.setCellStyle(textStyle);
   }

   //ROW60
   //Column M: 
   Cell R0510cell12 = row.createCell(12);
   if (record1.getR0510_1_2years() != null) {
   R0510cell12.setCellValue(record1.getR0510_1_2years().doubleValue());
   R0510cell12.setCellStyle(numberStyle);
   } else {
   R0510cell12.setCellValue("");
   R0510cell12.setCellStyle(textStyle);
   }

   //ROW60
   //Column N: 
   Cell R0510cell13 = row.createCell(13);
   if (record1.getR0510_2_3years() != null) {
   R0510cell13.setCellValue(record1.getR0510_2_3years().doubleValue());
   R0510cell13.setCellStyle(numberStyle);
   } else {
   R0510cell13.setCellValue("");
   R0510cell13.setCellStyle(textStyle);
   }

   //ROW60
   //Column O: 
   Cell R0510cell14 = row.createCell(14);
   if (record1.getR0510_3_4years() != null) {
   R0510cell14.setCellValue(record1.getR0510_3_4years().doubleValue());
   R0510cell14.setCellStyle(numberStyle);
   } else {
   R0510cell14.setCellValue("");
   R0510cell14.setCellStyle(textStyle);
   }

   //ROW60
   //Column P: 
   Cell R0510cell15 = row.createCell(15);
   if (record1.getR0510_4_5years() != null) {
   R0510cell15.setCellValue(record1.getR0510_4_5years().doubleValue());
   R0510cell15.setCellStyle(numberStyle);
   } else {
   R0510cell15.setCellValue("");
   R0510cell15.setCellStyle(textStyle);
   }

   //ROW60
   //Column Q: 
   Cell R0510cell16 = row.createCell(16);
   if (record1.getR0510_5years() != null) {
   R0510cell16.setCellValue(record1.getR0510_5years().doubleValue());
   R0510cell16.setCellStyle(numberStyle);
   } else {
   R0510cell16.setCellValue("");
   R0510cell16.setCellStyle(textStyle);
   }

   //ROW60
   //Column R: 
   Cell R0510cell17 = row.createCell(17);
   if (record1.getR0510_non_interest() != null) {
   R0510cell17.setCellValue(record1.getR0510_non_interest().doubleValue());
   R0510cell17.setCellStyle(numberStyle);
   } else {
   R0510cell17.setCellValue("");
   R0510cell17.setCellStyle(textStyle);
   }


   /////ROW61///////////
   //ROW61
   //Column E: 
   row = sheet.getRow(60);
   Cell R0520cell4 = row.createCell(4);
   if (record1.getR0520_overdraft() != null) {
   R0520cell4.setCellValue(record1.getR0520_overdraft().doubleValue());
   R0520cell4.setCellStyle(numberStyle);
   } else {
   R0520cell4.setCellValue("");
   R0520cell4.setCellStyle(textStyle);
   }

   //ROW61
   //Column F: 
   Cell R0520cell5 = row.createCell(5);
   if (record1.getR0520_0_7days() != null) {
   R0520cell5.setCellValue(record1.getR0520_0_7days().doubleValue());
   R0520cell5.setCellStyle(numberStyle);
   } else {
   R0520cell5.setCellValue("");
   R0520cell5.setCellStyle(textStyle);
   }

   //ROW61
   //Column G: 
   Cell R0520cell6 = row.createCell(6);
   if (record1.getR0520_8_14days() != null) {
   R0520cell6.setCellValue(record1.getR0520_8_14days().doubleValue());
   R0520cell6.setCellStyle(numberStyle);
   } else {
   R0520cell6.setCellValue("");
   R0520cell6.setCellStyle(textStyle);
   }

   //ROW61
   //Column H: 
   Cell R0520cell7 = row.createCell(7);
   if (record1.getR0520_15days_1months() != null) {
   R0520cell7.setCellValue(record1.getR0520_15days_1months().doubleValue());
   R0520cell7.setCellStyle(numberStyle);
   } else {
   R0520cell7.setCellValue("");
   R0520cell7.setCellStyle(textStyle);
   }

   //ROW61
   //Column I: 
   Cell R0520cell8 = row.createCell(8);
   if (record1.getR0520_1_2months() != null) {
   R0520cell8.setCellValue(record1.getR0520_1_2months().doubleValue());
   R0520cell8.setCellStyle(numberStyle);
   } else {
   R0520cell8.setCellValue("");
   R0520cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW61
   //Column J: 
   Cell R0520cell9 = row.createCell(9);
   if (record1.getR0520_2_3months() != null) {
   R0520cell9.setCellValue(record1.getR0520_2_3months().doubleValue());
   R0520cell9.setCellStyle(numberStyle);
   } else {
   R0520cell9.setCellValue("");
   R0520cell9.setCellStyle(textStyle);
   }

   //ROW61
   //Column K: 
   Cell R0520cell10 = row.createCell(10);
   if (record1.getR0520_3_6months() != null) {
   R0520cell10.setCellValue(record1.getR0520_3_6months().doubleValue());
   R0520cell10.setCellStyle(numberStyle);
   } else {
   R0520cell10.setCellValue("");
   R0520cell10.setCellStyle(textStyle);
   }

   //ROW61
   //Column L: 
   Cell R0520cell11 = row.createCell(11);
   if (record1.getR0520_6_12months() != null) {
   R0520cell11.setCellValue(record1.getR0520_6_12months().doubleValue());
   R0520cell11.setCellStyle(numberStyle);
   } else {
   R0520cell11.setCellValue("");
   R0520cell11.setCellStyle(textStyle);
   }

   //ROW61
   //Column M: 
   Cell R0520cell12 = row.createCell(12);
   if (record1.getR0520_1_2years() != null) {
   R0520cell12.setCellValue(record1.getR0520_1_2years().doubleValue());
   R0520cell12.setCellStyle(numberStyle);
   } else {
   R0520cell12.setCellValue("");
   R0520cell12.setCellStyle(textStyle);
   }

   //ROW61
   //Column N: 
   Cell R0520cell13 = row.createCell(13);
   if (record1.getR0520_2_3years() != null) {
   R0520cell13.setCellValue(record1.getR0520_2_3years().doubleValue());
   R0520cell13.setCellStyle(numberStyle);
   } else {
   R0520cell13.setCellValue("");
   R0520cell13.setCellStyle(textStyle);
   }

   //ROW61
   //Column O: 
   Cell R0520cell14 = row.createCell(14);
   if (record1.getR0520_3_4years() != null) {
   R0520cell14.setCellValue(record1.getR0520_3_4years().doubleValue());
   R0520cell14.setCellStyle(numberStyle);
   } else {
   R0520cell14.setCellValue("");
   R0520cell14.setCellStyle(textStyle);
   }

   //ROW61
   //Column P: 
   Cell R0520cell15 = row.createCell(15);
   if (record1.getR0520_4_5years() != null) {
   R0520cell15.setCellValue(record1.getR0520_4_5years().doubleValue());
   R0520cell15.setCellStyle(numberStyle);
   } else {
   R0520cell15.setCellValue("");
   R0520cell15.setCellStyle(textStyle);
   }

   //ROW61
   //Column Q: 
   Cell R0520cell16 = row.createCell(16);
   if (record1.getR0520_5years() != null) {
   R0520cell16.setCellValue(record1.getR0520_5years().doubleValue());
   R0520cell16.setCellStyle(numberStyle);
   } else {
   R0520cell16.setCellValue("");
   R0520cell16.setCellStyle(textStyle);
   }

   //ROW61
   //Column R: 
   Cell R0520cell17 = row.createCell(17);
   if (record1.getR0520_non_interest() != null) {
   R0520cell17.setCellValue(record1.getR0520_non_interest().doubleValue());
   R0520cell17.setCellStyle(numberStyle);
   } else {
   R0520cell17.setCellValue("");
   R0520cell17.setCellStyle(textStyle);
   }

   /////ROW62///////////
   //ROW62
   //Column E: 
   row = sheet.getRow(61);
   Cell R0530cell4 = row.createCell(4);
   if (record1.getR0530_overdraft() != null) {
   R0530cell4.setCellValue(record1.getR0530_overdraft().doubleValue());
   R0530cell4.setCellStyle(numberStyle);
   } else {
   R0530cell4.setCellValue("");
   R0530cell4.setCellStyle(textStyle);
   }

   //ROW62
   //Column F: 
   Cell R0530cell5 = row.createCell(5);
   if (record1.getR0530_0_7days() != null) {
   R0530cell5.setCellValue(record1.getR0530_0_7days().doubleValue());
   R0530cell5.setCellStyle(numberStyle);
   } else {
   R0530cell5.setCellValue("");
   R0530cell5.setCellStyle(textStyle);
   }

   //ROW62
   //Column G: 
   Cell R0530cell6 = row.createCell(6);
   if (record1.getR0530_8_14days() != null) {
   R0530cell6.setCellValue(record1.getR0530_8_14days().doubleValue());
   R0530cell6.setCellStyle(numberStyle);
   } else {
   R0530cell6.setCellValue("");
   R0530cell6.setCellStyle(textStyle);
   }

   //ROW62
   //Column H: 
   Cell R0530cell7 = row.createCell(7);
   if (record1.getR0530_15days_1months() != null) {
   R0530cell7.setCellValue(record1.getR0530_15days_1months().doubleValue());
   R0530cell7.setCellStyle(numberStyle);
   } else {
   R0530cell7.setCellValue("");
   R0530cell7.setCellStyle(textStyle);
   }

   //ROW62
   //Column I: 
   Cell R0530cell8 = row.createCell(8);
   if (record1.getR0530_1_2months() != null) {
   R0530cell8.setCellValue(record1.getR0530_1_2months().doubleValue());
   R0530cell8.setCellStyle(numberStyle);
   } else {
   R0530cell8.setCellValue("");
   R0530cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW62
   //Column J: 
   Cell R0530cell9 = row.createCell(9);
   if (record1.getR0530_2_3months() != null) {
   R0530cell9.setCellValue(record1.getR0530_2_3months().doubleValue());
   R0530cell9.setCellStyle(numberStyle);
   } else {
   R0530cell9.setCellValue("");
   R0530cell9.setCellStyle(textStyle);
   }

   //ROW62
   //Column K: 
   Cell R0530cell10 = row.createCell(10);
   if (record1.getR0530_3_6months() != null) {
   R0530cell10.setCellValue(record1.getR0530_3_6months().doubleValue());
   R0530cell10.setCellStyle(numberStyle);
   } else {
   R0530cell10.setCellValue("");
   R0530cell10.setCellStyle(textStyle);
   }

   //ROW62
   //Column L: 
   Cell R0530cell11 = row.createCell(11);
   if (record1.getR0530_6_12months() != null) {
   R0530cell11.setCellValue(record1.getR0530_6_12months().doubleValue());
   R0530cell11.setCellStyle(numberStyle);
   } else {
   R0530cell11.setCellValue("");
   R0530cell11.setCellStyle(textStyle);
   }

   //ROW62
   //Column M: 
   Cell R0530cell12 = row.createCell(12);
   if (record1.getR0530_1_2years() != null) {
   R0530cell12.setCellValue(record1.getR0530_1_2years().doubleValue());
   R0530cell12.setCellStyle(numberStyle);
   } else {
   R0530cell12.setCellValue("");
   R0530cell12.setCellStyle(textStyle);
   }

   //ROW62
   //Column N: 
   Cell R0530cell13 = row.createCell(13);
   if (record1.getR0530_2_3years() != null) {
   R0530cell13.setCellValue(record1.getR0530_2_3years().doubleValue());
   R0530cell13.setCellStyle(numberStyle);
   } else {
   R0530cell13.setCellValue("");
   R0530cell13.setCellStyle(textStyle);
   }

   //ROW62
   //Column O: 
   Cell R0530cell14 = row.createCell(14);
   if (record1.getR0530_3_4years() != null) {
   R0530cell14.setCellValue(record1.getR0530_3_4years().doubleValue());
   R0530cell14.setCellStyle(numberStyle);
   } else {
   R0530cell14.setCellValue("");
   R0530cell14.setCellStyle(textStyle);
   }

   //ROW62
   //Column P: 
   Cell R0530cell15 = row.createCell(15);
   if (record1.getR0530_4_5years() != null) {
   R0530cell15.setCellValue(record1.getR0530_4_5years().doubleValue());
   R0530cell15.setCellStyle(numberStyle);
   } else {
   R0530cell15.setCellValue("");
   R0530cell15.setCellStyle(textStyle);
   }

   //ROW62
   //Column Q: 
   Cell R0530cell16 = row.createCell(16);
   if (record1.getR0530_5years() != null) {
   R0530cell16.setCellValue(record1.getR0530_5years().doubleValue());
   R0530cell16.setCellStyle(numberStyle);
   } else {
   R0530cell16.setCellValue("");
   R0530cell16.setCellStyle(textStyle);
   }

   //ROW62
   //Column R: 
   Cell R0530cell17 = row.createCell(17);
   if (record1.getR0530_non_interest() != null) {
   R0530cell17.setCellValue(record1.getR0530_non_interest().doubleValue());
   R0530cell17.setCellStyle(numberStyle);
   } else {
   R0530cell17.setCellValue("");
   R0530cell17.setCellStyle(textStyle);
   }


   /////ROW64///////////
   //ROW64
   //Column E: 
   row = sheet.getRow(63);
   Cell R0550cell4 = row.createCell(4);
   if (record1.getR0550_overdraft() != null) {
   R0550cell4.setCellValue(record1.getR0550_overdraft().doubleValue());
   R0550cell4.setCellStyle(numberStyle);
   } else {
   R0550cell4.setCellValue("");
   R0550cell4.setCellStyle(textStyle);
   }

   //ROW64
   //Column F: 
   Cell R0550cell5 = row.createCell(5);
   if (record1.getR0550_0_7days() != null) {
   R0550cell5.setCellValue(record1.getR0550_0_7days().doubleValue());
   R0550cell5.setCellStyle(numberStyle);
   } else {
   R0550cell5.setCellValue("");
   R0550cell5.setCellStyle(textStyle);
   }

   //ROW64
   //Column G: 
   Cell R0550cell6 = row.createCell(6);
   if (record1.getR0550_8_14days() != null) {
   R0550cell6.setCellValue(record1.getR0550_8_14days().doubleValue());
   R0550cell6.setCellStyle(numberStyle);
   } else {
   R0550cell6.setCellValue("");
   R0550cell6.setCellStyle(textStyle);
   }

   //ROW64
   //Column H: 
   Cell R0550cell7 = row.createCell(7);
   if (record1.getR0550_15days_1months() != null) {
   R0550cell7.setCellValue(record1.getR0550_15days_1months().doubleValue());
   R0550cell7.setCellStyle(numberStyle);
   } else {
   R0550cell7.setCellValue("");
   R0550cell7.setCellStyle(textStyle);
   }

   //ROW64
   //Column I: 
   Cell R0550cell8 = row.createCell(8);
   if (record1.getR0550_1_2months() != null) {
   R0550cell8.setCellValue(record1.getR0550_1_2months().doubleValue());
   R0550cell8.setCellStyle(numberStyle);
   } else {
   R0550cell8.setCellValue("");
   R0550cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW64
   //Column J: 
   Cell R0550cell9 = row.createCell(9);
   if (record1.getR0550_2_3months() != null) {
   R0550cell9.setCellValue(record1.getR0550_2_3months().doubleValue());
   R0550cell9.setCellStyle(numberStyle);
   } else {
   R0550cell9.setCellValue("");
   R0550cell9.setCellStyle(textStyle);
   }

   //ROW64
   //Column K: 
   Cell R0550cell10 = row.createCell(10);
   if (record1.getR0550_3_6months() != null) {
   R0550cell10.setCellValue(record1.getR0550_3_6months().doubleValue());
   R0550cell10.setCellStyle(numberStyle);
   } else {
   R0550cell10.setCellValue("");
   R0550cell10.setCellStyle(textStyle);
   }

   //ROW64
   //Column L: 
   Cell R0550cell11 = row.createCell(11);
   if (record1.getR0550_6_12months() != null) {
   R0550cell11.setCellValue(record1.getR0550_6_12months().doubleValue());
   R0550cell11.setCellStyle(numberStyle);
   } else {
   R0550cell11.setCellValue("");
   R0550cell11.setCellStyle(textStyle);
   }

   //ROW64
   //Column M: 
   Cell R0550cell12 = row.createCell(12);
   if (record1.getR0550_1_2years() != null) {
   R0550cell12.setCellValue(record1.getR0550_1_2years().doubleValue());
   R0550cell12.setCellStyle(numberStyle);
   } else {
   R0550cell12.setCellValue("");
   R0550cell12.setCellStyle(textStyle);
   }

   //ROW64
   //Column N: 
   Cell R0550cell13 = row.createCell(13);
   if (record1.getR0550_2_3years() != null) {
   R0550cell13.setCellValue(record1.getR0550_2_3years().doubleValue());
   R0550cell13.setCellStyle(numberStyle);
   } else {
   R0550cell13.setCellValue("");
   R0550cell13.setCellStyle(textStyle);
   }

   //ROW64
   //Column O: 
   Cell R0550cell14 = row.createCell(14);
   if (record1.getR0550_3_4years() != null) {
   R0550cell14.setCellValue(record1.getR0550_3_4years().doubleValue());
   R0550cell14.setCellStyle(numberStyle);
   } else {
   R0550cell14.setCellValue("");
   R0550cell14.setCellStyle(textStyle);
   }

   //ROW64
   //Column P: 
   Cell R0550cell15 = row.createCell(15);
   if (record1.getR0550_4_5years() != null) {
   R0550cell15.setCellValue(record1.getR0550_4_5years().doubleValue());
   R0550cell15.setCellStyle(numberStyle);
   } else {
   R0550cell15.setCellValue("");
   R0550cell15.setCellStyle(textStyle);
   }

   //ROW64
   //Column Q: 
   Cell R0550cell16 = row.createCell(16);
   if (record1.getR0550_5years() != null) {
   R0550cell16.setCellValue(record1.getR0550_5years().doubleValue());
   R0550cell16.setCellStyle(numberStyle);
   } else {
   R0550cell16.setCellValue("");
   R0550cell16.setCellStyle(textStyle);
   }

   //ROW64
   //Column R: 
   Cell R0550cell17 = row.createCell(17);
   if (record1.getR0550_non_interest() != null) {
   R0550cell17.setCellValue(record1.getR0550_non_interest().doubleValue());
   R0550cell17.setCellStyle(numberStyle);
   } else {
   R0550cell17.setCellValue("");
   R0550cell17.setCellStyle(textStyle);
   }


   /////ROW65///////////
   //ROW65
   //Column E: 
   row = sheet.getRow(64);
   Cell R0560cell4 = row.createCell(4);
   if (record1.getR0560_overdraft() != null) {
   R0560cell4.setCellValue(record1.getR0560_overdraft().doubleValue());
   R0560cell4.setCellStyle(numberStyle);
   } else {
   R0560cell4.setCellValue("");
   R0560cell4.setCellStyle(textStyle);
   }

   //ROW65
   //Column F: 
   Cell R0560cell5 = row.createCell(5);
   if (record1.getR0560_0_7days() != null) {
   R0560cell5.setCellValue(record1.getR0560_0_7days().doubleValue());
   R0560cell5.setCellStyle(numberStyle);
   } else {
   R0560cell5.setCellValue("");
   R0560cell5.setCellStyle(textStyle);
   }

   //ROW65
   //Column G: 
   Cell R0560cell6 = row.createCell(6);
   if (record1.getR0560_8_14days() != null) {
   R0560cell6.setCellValue(record1.getR0560_8_14days().doubleValue());
   R0560cell6.setCellStyle(numberStyle);
   } else {
   R0560cell6.setCellValue("");
   R0560cell6.setCellStyle(textStyle);
   }

   //ROW65
   //Column H: 
   Cell R0560cell7 = row.createCell(7);
   if (record1.getR0560_15days_1months() != null) {
   R0560cell7.setCellValue(record1.getR0560_15days_1months().doubleValue());
   R0560cell7.setCellStyle(numberStyle);
   } else {
   R0560cell7.setCellValue("");
   R0560cell7.setCellStyle(textStyle);
   }

   //ROW65
   //Column I: 
   Cell R0560cell8 = row.createCell(8);
   if (record1.getR0560_1_2months() != null) {
   R0560cell8.setCellValue(record1.getR0560_1_2months().doubleValue());
   R0560cell8.setCellStyle(numberStyle);
   } else {
   R0560cell8.setCellValue("");
   R0560cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW65
   //Column J: 
   Cell R0560cell9 = row.createCell(9);
   if (record1.getR0560_2_3months() != null) {
   R0560cell9.setCellValue(record1.getR0560_2_3months().doubleValue());
   R0560cell9.setCellStyle(numberStyle);
   } else {
   R0560cell9.setCellValue("");
   R0560cell9.setCellStyle(textStyle);
   }

   //ROW65
   //Column K: 
   Cell R0560cell10 = row.createCell(10);
   if (record1.getR0560_3_6months() != null) {
   R0560cell10.setCellValue(record1.getR0560_3_6months().doubleValue());
   R0560cell10.setCellStyle(numberStyle);
   } else {
   R0560cell10.setCellValue("");
   R0560cell10.setCellStyle(textStyle);
   }

   //ROW65
   //Column L: 
   Cell R0560cell11 = row.createCell(11);
   if (record1.getR0560_6_12months() != null) {
   R0560cell11.setCellValue(record1.getR0560_6_12months().doubleValue());
   R0560cell11.setCellStyle(numberStyle);
   } else {
   R0560cell11.setCellValue("");
   R0560cell11.setCellStyle(textStyle);
   }

   //ROW65
   //Column M: 
   Cell R0560cell12 = row.createCell(12);
   if (record1.getR0560_1_2years() != null) {
   R0560cell12.setCellValue(record1.getR0560_1_2years().doubleValue());
   R0560cell12.setCellStyle(numberStyle);
   } else {
   R0560cell12.setCellValue("");
   R0560cell12.setCellStyle(textStyle);
   }

   //ROW65
   //Column N: 
   Cell R0560cell13 = row.createCell(13);
   if (record1.getR0560_2_3years() != null) {
   R0560cell13.setCellValue(record1.getR0560_2_3years().doubleValue());
   R0560cell13.setCellStyle(numberStyle);
   } else {
   R0560cell13.setCellValue("");
   R0560cell13.setCellStyle(textStyle);
   }

   //ROW65
   //Column O: 
   Cell R0560cell14 = row.createCell(14);
   if (record1.getR0560_3_4years() != null) {
   R0560cell14.setCellValue(record1.getR0560_3_4years().doubleValue());
   R0560cell14.setCellStyle(numberStyle);
   } else {
   R0560cell14.setCellValue("");
   R0560cell14.setCellStyle(textStyle);
   }

   //ROW65
   //Column P: 
   Cell R0560cell15 = row.createCell(15);
   if (record1.getR0560_4_5years() != null) {
   R0560cell15.setCellValue(record1.getR0560_4_5years().doubleValue());
   R0560cell15.setCellStyle(numberStyle);
   } else {
   R0560cell15.setCellValue("");
   R0560cell15.setCellStyle(textStyle);
   }

   //ROW65
   //Column Q: 
   Cell R0560cell16 = row.createCell(16);
   if (record1.getR0560_5years() != null) {
   R0560cell16.setCellValue(record1.getR0560_5years().doubleValue());
   R0560cell16.setCellStyle(numberStyle);
   } else {
   R0560cell16.setCellValue("");
   R0560cell16.setCellStyle(textStyle);
   }

   //ROW65
   //Column R: 
   Cell R0560cell17 = row.createCell(17);
   if (record1.getR0560_non_interest() != null) {
   R0560cell17.setCellValue(record1.getR0560_non_interest().doubleValue());
   R0560cell17.setCellStyle(numberStyle);
   } else {
   R0560cell17.setCellValue("");
   R0560cell17.setCellStyle(textStyle);
   }

   /////ROW66///////////
   //ROW66
   //Column E: 
   row = sheet.getRow(65);
   Cell R0570cell4 = row.createCell(4);
   if (record1.getR0570_overdraft() != null) {
   R0570cell4.setCellValue(record1.getR0570_overdraft().doubleValue());
   R0570cell4.setCellStyle(numberStyle);
   } else {
   R0570cell4.setCellValue("");
   R0570cell4.setCellStyle(textStyle);
   }

   //ROW66
   //Column F: 
   Cell R0570cell5 = row.createCell(5);
   if (record1.getR0570_0_7days() != null) {
   R0570cell5.setCellValue(record1.getR0570_0_7days().doubleValue());
   R0570cell5.setCellStyle(numberStyle);
   } else {
   R0570cell5.setCellValue("");
   R0570cell5.setCellStyle(textStyle);
   }

   //ROW66
   //Column G: 
   Cell R0570cell6 = row.createCell(6);
   if (record1.getR0570_8_14days() != null) {
   R0570cell6.setCellValue(record1.getR0570_8_14days().doubleValue());
   R0570cell6.setCellStyle(numberStyle);
   } else {
   R0570cell6.setCellValue("");
   R0570cell6.setCellStyle(textStyle);
   }

   //ROW66
   //Column H: 
   Cell R0570cell7 = row.createCell(7);
   if (record1.getR0570_15days_1months() != null) {
   R0570cell7.setCellValue(record1.getR0570_15days_1months().doubleValue());
   R0570cell7.setCellStyle(numberStyle);
   } else {
   R0570cell7.setCellValue("");
   R0570cell7.setCellStyle(textStyle);
   }

   //ROW66
   //Column I: 
   Cell R0570cell8 = row.createCell(8);
   if (record1.getR0570_1_2months() != null) {
   R0570cell8.setCellValue(record1.getR0570_1_2months().doubleValue());
   R0570cell8.setCellStyle(numberStyle);
   } else {
   R0570cell8.setCellValue("");
   R0570cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW66
   //Column J: 
   Cell R0570cell9 = row.createCell(9);
   if (record1.getR0570_2_3months() != null) {
   R0570cell9.setCellValue(record1.getR0570_2_3months().doubleValue());
   R0570cell9.setCellStyle(numberStyle);
   } else {
   R0570cell9.setCellValue("");
   R0570cell9.setCellStyle(textStyle);
   }

   //ROW66
   //Column K: 
   Cell R0570cell10 = row.createCell(10);
   if (record1.getR0570_3_6months() != null) {
   R0570cell10.setCellValue(record1.getR0570_3_6months().doubleValue());
   R0570cell10.setCellStyle(numberStyle);
   } else {
   R0570cell10.setCellValue("");
   R0570cell10.setCellStyle(textStyle);
   }

   //ROW66
   //Column L: 
   Cell R0570cell11 = row.createCell(11);
   if (record1.getR0570_6_12months() != null) {
   R0570cell11.setCellValue(record1.getR0570_6_12months().doubleValue());
   R0570cell11.setCellStyle(numberStyle);
   } else {
   R0570cell11.setCellValue("");
   R0570cell11.setCellStyle(textStyle);
   }

   //ROW66
   //Column M: 
   Cell R0570cell12 = row.createCell(12);
   if (record1.getR0570_1_2years() != null) {
   R0570cell12.setCellValue(record1.getR0570_1_2years().doubleValue());
   R0570cell12.setCellStyle(numberStyle);
   } else {
   R0570cell12.setCellValue("");
   R0570cell12.setCellStyle(textStyle);
   }

   //ROW66
   //Column N: 
   Cell R0570cell13 = row.createCell(13);
   if (record1.getR0570_2_3years() != null) {
   R0570cell13.setCellValue(record1.getR0570_2_3years().doubleValue());
   R0570cell13.setCellStyle(numberStyle);
   } else {
   R0570cell13.setCellValue("");
   R0570cell13.setCellStyle(textStyle);
   }

   //ROW66
   //Column O: 
   Cell R0570cell14 = row.createCell(14);
   if (record1.getR0570_3_4years() != null) {
   R0570cell14.setCellValue(record1.getR0570_3_4years().doubleValue());
   R0570cell14.setCellStyle(numberStyle);
   } else {
   R0570cell14.setCellValue("");
   R0570cell14.setCellStyle(textStyle);
   }

   //ROW66
   //Column P: 
   Cell R0570cell15 = row.createCell(15);
   if (record1.getR0570_4_5years() != null) {
   R0570cell15.setCellValue(record1.getR0570_4_5years().doubleValue());
   R0570cell15.setCellStyle(numberStyle);
   } else {
   R0570cell15.setCellValue("");
   R0570cell15.setCellStyle(textStyle);
   }

   //ROW66
   //Column Q: 
   Cell R0570cell16 = row.createCell(16);
   if (record1.getR0570_5years() != null) {
   R0570cell16.setCellValue(record1.getR0570_5years().doubleValue());
   R0570cell16.setCellStyle(numberStyle);
   } else {
   R0570cell16.setCellValue("");
   R0570cell16.setCellStyle(textStyle);
   }

   //ROW66
   //Column R: 
   Cell R0570cell17 = row.createCell(17);
   if (record1.getR0570_non_interest() != null) {
   R0570cell17.setCellValue(record1.getR0570_non_interest().doubleValue());
   R0570cell17.setCellStyle(numberStyle);
   } else {
   R0570cell17.setCellValue("");
   R0570cell17.setCellStyle(textStyle);
   }

   /////ROW67///////////
   //ROW67
   //Column E: 
   row = sheet.getRow(66);
   Cell R0580cell4 = row.createCell(4);
   if (record1.getR0580_overdraft() != null) {
   R0580cell4.setCellValue(record1.getR0580_overdraft().doubleValue());
   R0580cell4.setCellStyle(numberStyle);
   } else {
   R0580cell4.setCellValue("");
   R0580cell4.setCellStyle(textStyle);
   }

   //ROW67
   //Column F: 
   Cell R0580cell5 = row.createCell(5);
   if (record1.getR0580_0_7days() != null) {
   R0580cell5.setCellValue(record1.getR0580_0_7days().doubleValue());
   R0580cell5.setCellStyle(numberStyle);
   } else {
   R0580cell5.setCellValue("");
   R0580cell5.setCellStyle(textStyle);
   }

   //ROW67
   //Column G: 
   Cell R0580cell6 = row.createCell(6);
   if (record1.getR0580_8_14days() != null) {
   R0580cell6.setCellValue(record1.getR0580_8_14days().doubleValue());
   R0580cell6.setCellStyle(numberStyle);
   } else {
   R0580cell6.setCellValue("");
   R0580cell6.setCellStyle(textStyle);
   }

   //ROW67
   //Column H: 
   Cell R0580cell7 = row.createCell(7);
   if (record1.getR0580_15days_1months() != null) {
   R0580cell7.setCellValue(record1.getR0580_15days_1months().doubleValue());
   R0580cell7.setCellStyle(numberStyle);
   } else {
   R0580cell7.setCellValue("");
   R0580cell7.setCellStyle(textStyle);
   }

   //ROW67
   //Column I: 
   Cell R0580cell8 = row.createCell(8);
   if (record1.getR0580_1_2months() != null) {
   R0580cell8.setCellValue(record1.getR0580_1_2months().doubleValue());
   R0580cell8.setCellStyle(numberStyle);
   } else {
   R0580cell8.setCellValue("");
   R0580cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW67
   //Column J: 
   Cell R0580cell9 = row.createCell(9);
   if (record1.getR0580_2_3months() != null) {
   R0580cell9.setCellValue(record1.getR0580_2_3months().doubleValue());
   R0580cell9.setCellStyle(numberStyle);
   } else {
   R0580cell9.setCellValue("");
   R0580cell9.setCellStyle(textStyle);
   }

   //ROW67
   //Column K: 
   Cell R0580cell10 = row.createCell(10);
   if (record1.getR0580_3_6months() != null) {
   R0580cell10.setCellValue(record1.getR0580_3_6months().doubleValue());
   R0580cell10.setCellStyle(numberStyle);
   } else {
   R0580cell10.setCellValue("");
   R0580cell10.setCellStyle(textStyle);
   }

   //ROW67
   //Column L: 
   Cell R0580cell11 = row.createCell(11);
   if (record1.getR0580_6_12months() != null) {
   R0580cell11.setCellValue(record1.getR0580_6_12months().doubleValue());
   R0580cell11.setCellStyle(numberStyle);
   } else {
   R0580cell11.setCellValue("");
   R0580cell11.setCellStyle(textStyle);
   }

   //ROW67
   //Column M: 
   Cell R0580cell12 = row.createCell(12);
   if (record1.getR0580_1_2years() != null) {
   R0580cell12.setCellValue(record1.getR0580_1_2years().doubleValue());
   R0580cell12.setCellStyle(numberStyle);
   } else {
   R0580cell12.setCellValue("");
   R0580cell12.setCellStyle(textStyle);
   }

   //ROW67
   //Column N: 
   Cell R0580cell13 = row.createCell(13);
   if (record1.getR0580_2_3years() != null) {
   R0580cell13.setCellValue(record1.getR0580_2_3years().doubleValue());
   R0580cell13.setCellStyle(numberStyle);
   } else {
   R0580cell13.setCellValue("");
   R0580cell13.setCellStyle(textStyle);
   }

   //ROW67
   //Column O: 
   Cell R0580cell14 = row.createCell(14);
   if (record1.getR0580_3_4years() != null) {
   R0580cell14.setCellValue(record1.getR0580_3_4years().doubleValue());
   R0580cell14.setCellStyle(numberStyle);
   } else {
   R0580cell14.setCellValue("");
   R0580cell14.setCellStyle(textStyle);
   }

   //ROW67
   //Column P: 
   Cell R0580cell15 = row.createCell(15);
   if (record1.getR0580_4_5years() != null) {
   R0580cell15.setCellValue(record1.getR0580_4_5years().doubleValue());
   R0580cell15.setCellStyle(numberStyle);
   } else {
   R0580cell15.setCellValue("");
   R0580cell15.setCellStyle(textStyle);
   }

   //ROW67
   //Column Q: 
   Cell R0580cell16 = row.createCell(16);
   if (record1.getR0580_5years() != null) {
   R0580cell16.setCellValue(record1.getR0580_5years().doubleValue());
   R0580cell16.setCellStyle(numberStyle);
   } else {
   R0580cell16.setCellValue("");
   R0580cell16.setCellStyle(textStyle);
   }

   //ROW67
   //Column R: 
   Cell R0580cell17 = row.createCell(17);
   if (record1.getR0580_non_interest() != null) {
   R0580cell17.setCellValue(record1.getR0580_non_interest().doubleValue());
   R0580cell17.setCellStyle(numberStyle);
   } else {
   R0580cell17.setCellValue("");
   R0580cell17.setCellStyle(textStyle);
   }


   /////ROW71///////////
   //ROW71
   //Column E: 
   row = sheet.getRow(70);
   Cell R0620cell4 = row.createCell(4);
   if (record1.getR0620_overdraft() != null) {
   R0620cell4.setCellValue(record1.getR0620_overdraft().doubleValue());
   R0620cell4.setCellStyle(numberStyle);
   } else {
   R0620cell4.setCellValue("");
   R0620cell4.setCellStyle(textStyle);
   }

   //ROW71
   //Column F: 
   Cell R0620cell5 = row.createCell(5);
   if (record1.getR0620_0_7days() != null) {
   R0620cell5.setCellValue(record1.getR0620_0_7days().doubleValue());
   R0620cell5.setCellStyle(numberStyle);
   } else {
   R0620cell5.setCellValue("");
   R0620cell5.setCellStyle(textStyle);
   }

   //ROW71
   //Column G: 
   Cell R0620cell6 = row.createCell(6);
   if (record1.getR0620_8_14days() != null) {
   R0620cell6.setCellValue(record1.getR0620_8_14days().doubleValue());
   R0620cell6.setCellStyle(numberStyle);
   } else {
   R0620cell6.setCellValue("");
   R0620cell6.setCellStyle(textStyle);
   }

   //ROW71
   //Column H: 
   Cell R0620cell7 = row.createCell(7);
   if (record1.getR0620_15days_1months() != null) {
   R0620cell7.setCellValue(record1.getR0620_15days_1months().doubleValue());
   R0620cell7.setCellStyle(numberStyle);
   } else {
   R0620cell7.setCellValue("");
   R0620cell7.setCellStyle(textStyle);
   }

   //ROW71
   //Column I: 
   Cell R0620cell8 = row.createCell(8);
   if (record1.getR0620_1_2months() != null) {
   R0620cell8.setCellValue(record1.getR0620_1_2months().doubleValue());
   R0620cell8.setCellStyle(numberStyle);
   } else {
   R0620cell8.setCellValue("");
   R0620cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW71
   //Column J: 
   Cell R0620cell9 = row.createCell(9);
   if (record1.getR0620_2_3months() != null) {
   R0620cell9.setCellValue(record1.getR0620_2_3months().doubleValue());
   R0620cell9.setCellStyle(numberStyle);
   } else {
   R0620cell9.setCellValue("");
   R0620cell9.setCellStyle(textStyle);
   }

   //ROW71
   //Column K: 
   Cell R0620cell10 = row.createCell(10);
   if (record1.getR0620_3_6months() != null) {
   R0620cell10.setCellValue(record1.getR0620_3_6months().doubleValue());
   R0620cell10.setCellStyle(numberStyle);
   } else {
   R0620cell10.setCellValue("");
   R0620cell10.setCellStyle(textStyle);
   }

   //ROW71
   //Column L: 
   Cell R0620cell11 = row.createCell(11);
   if (record1.getR0620_6_12months() != null) {
   R0620cell11.setCellValue(record1.getR0620_6_12months().doubleValue());
   R0620cell11.setCellStyle(numberStyle);
   } else {
   R0620cell11.setCellValue("");
   R0620cell11.setCellStyle(textStyle);
   }

   //ROW71
   //Column M: 
   Cell R0620cell12 = row.createCell(12);
   if (record1.getR0620_1_2years() != null) {
   R0620cell12.setCellValue(record1.getR0620_1_2years().doubleValue());
   R0620cell12.setCellStyle(numberStyle);
   } else {
   R0620cell12.setCellValue("");
   R0620cell12.setCellStyle(textStyle);
   }

   //ROW71
   //Column N: 
   Cell R0620cell13 = row.createCell(13);
   if (record1.getR0620_2_3years() != null) {
   R0620cell13.setCellValue(record1.getR0620_2_3years().doubleValue());
   R0620cell13.setCellStyle(numberStyle);
   } else {
   R0620cell13.setCellValue("");
   R0620cell13.setCellStyle(textStyle);
   }

   //ROW71
   //Column O: 
   Cell R0620cell14 = row.createCell(14);
   if (record1.getR0620_3_4years() != null) {
   R0620cell14.setCellValue(record1.getR0620_3_4years().doubleValue());
   R0620cell14.setCellStyle(numberStyle);
   } else {
   R0620cell14.setCellValue("");
   R0620cell14.setCellStyle(textStyle);
   }

   //ROW71
   //Column P: 
   Cell R0620cell15 = row.createCell(15);
   if (record1.getR0620_4_5years() != null) {
   R0620cell15.setCellValue(record1.getR0620_4_5years().doubleValue());
   R0620cell15.setCellStyle(numberStyle);
   } else {
   R0620cell15.setCellValue("");
   R0620cell15.setCellStyle(textStyle);
   }

   //ROW71
   //Column Q: 
   Cell R0620cell16 = row.createCell(16);
   if (record1.getR0620_5years() != null) {
   R0620cell16.setCellValue(record1.getR0620_5years().doubleValue());
   R0620cell16.setCellStyle(numberStyle);
   } else {
   R0620cell16.setCellValue("");
   R0620cell16.setCellStyle(textStyle);
   }

   //ROW71
   //Column R: 
   Cell R0620cell17 = row.createCell(17);
   if (record1.getR0620_non_interest() != null) {
   R0620cell17.setCellValue(record1.getR0620_non_interest().doubleValue());
   R0620cell17.setCellStyle(numberStyle);
   } else {
   R0620cell17.setCellValue("");
   R0620cell17.setCellStyle(textStyle);
   }

   /////ROW72///////////
   //ROW72
   //Column E: 
   row = sheet.getRow(71);
   Cell R0630cell4 = row.createCell(4);
   if (record1.getR0630_overdraft() != null) {
   R0630cell4.setCellValue(record1.getR0630_overdraft().doubleValue());
   R0630cell4.setCellStyle(numberStyle);
   } else {
   R0630cell4.setCellValue("");
   R0630cell4.setCellStyle(textStyle);
   }

   //ROW72
   //Column F: 
   Cell R0630cell5 = row.createCell(5);
   if (record1.getR0630_0_7days() != null) {
   R0630cell5.setCellValue(record1.getR0630_0_7days().doubleValue());
   R0630cell5.setCellStyle(numberStyle);
   } else {
   R0630cell5.setCellValue("");
   R0630cell5.setCellStyle(textStyle);
   }

   //ROW72
   //Column G: 
   Cell R0630cell6 = row.createCell(6);
   if (record1.getR0630_8_14days() != null) {
   R0630cell6.setCellValue(record1.getR0630_8_14days().doubleValue());
   R0630cell6.setCellStyle(numberStyle);
   } else {
   R0630cell6.setCellValue("");
   R0630cell6.setCellStyle(textStyle);
   }

   //ROW72
   //Column H: 
   Cell R0630cell7 = row.createCell(7);
   if (record1.getR0630_15days_1months() != null) {
   R0630cell7.setCellValue(record1.getR0630_15days_1months().doubleValue());
   R0630cell7.setCellStyle(numberStyle);
   } else {
   R0630cell7.setCellValue("");
   R0630cell7.setCellStyle(textStyle);
   }

   //ROW72
   //Column I: 
   Cell R0630cell8 = row.createCell(8);
   if (record1.getR0630_1_2months() != null) {
   R0630cell8.setCellValue(record1.getR0630_1_2months().doubleValue());
   R0630cell8.setCellStyle(numberStyle);
   } else {
   R0630cell8.setCellValue("");
   R0630cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW72
   //Column J: 
   Cell R0630cell9 = row.createCell(9);
   if (record1.getR0630_2_3months() != null) {
   R0630cell9.setCellValue(record1.getR0630_2_3months().doubleValue());
   R0630cell9.setCellStyle(numberStyle);
   } else {
   R0630cell9.setCellValue("");
   R0630cell9.setCellStyle(textStyle);
   }

   //ROW72
   //Column K: 
   Cell R0630cell10 = row.createCell(10);
   if (record1.getR0630_3_6months() != null) {
   R0630cell10.setCellValue(record1.getR0630_3_6months().doubleValue());
   R0630cell10.setCellStyle(numberStyle);
   } else {
   R0630cell10.setCellValue("");
   R0630cell10.setCellStyle(textStyle);
   }

   //ROW72
   //Column L: 
   Cell R0630cell11 = row.createCell(11);
   if (record1.getR0630_6_12months() != null) {
   R0630cell11.setCellValue(record1.getR0630_6_12months().doubleValue());
   R0630cell11.setCellStyle(numberStyle);
   } else {
   R0630cell11.setCellValue("");
   R0630cell11.setCellStyle(textStyle);
   }

   //ROW72
   //Column M: 
   Cell R0630cell12 = row.createCell(12);
   if (record1.getR0630_1_2years() != null) {
   R0630cell12.setCellValue(record1.getR0630_1_2years().doubleValue());
   R0630cell12.setCellStyle(numberStyle);
   } else {
   R0630cell12.setCellValue("");
   R0630cell12.setCellStyle(textStyle);
   }

   //ROW72
   //Column N: 
   Cell R0630cell13 = row.createCell(13);
   if (record1.getR0630_2_3years() != null) {
   R0630cell13.setCellValue(record1.getR0630_2_3years().doubleValue());
   R0630cell13.setCellStyle(numberStyle);
   } else {
   R0630cell13.setCellValue("");
   R0630cell13.setCellStyle(textStyle);
   }

   //ROW72
   //Column O: 
   Cell R0630cell14 = row.createCell(14);
   if (record1.getR0630_3_4years() != null) {
   R0630cell14.setCellValue(record1.getR0630_3_4years().doubleValue());
   R0630cell14.setCellStyle(numberStyle);
   } else {
   R0630cell14.setCellValue("");
   R0630cell14.setCellStyle(textStyle);
   }

   //ROW72
   //Column P: 
   Cell R0630cell15 = row.createCell(15);
   if (record1.getR0630_4_5years() != null) {
   R0630cell15.setCellValue(record1.getR0630_4_5years().doubleValue());
   R0630cell15.setCellStyle(numberStyle);
   } else {
   R0630cell15.setCellValue("");
   R0630cell15.setCellStyle(textStyle);
   }

   //ROW72
   //Column Q: 
   Cell R0630cell16 = row.createCell(16);
   if (record1.getR0630_5years() != null) {
   R0630cell16.setCellValue(record1.getR0630_5years().doubleValue());
   R0630cell16.setCellStyle(numberStyle);
   } else {
   R0630cell16.setCellValue("");
   R0630cell16.setCellStyle(textStyle);
   }

   //ROW72
   //Column R: 
   Cell R0630cell17 = row.createCell(17);
   if (record1.getR0630_non_interest() != null) {
   R0630cell17.setCellValue(record1.getR0630_non_interest().doubleValue());
   R0630cell17.setCellStyle(numberStyle);
   } else {
   R0630cell17.setCellValue("");
   R0630cell17.setCellStyle(textStyle);
   }


   /////ROW73///////////
   //ROW73
   //Column E: 
   row = sheet.getRow(72);
   Cell R0640cell4 = row.createCell(4);
   if (record1.getR0640_overdraft() != null) {
   R0640cell4.setCellValue(record1.getR0640_overdraft().doubleValue());
   R0640cell4.setCellStyle(numberStyle);
   } else {
   R0640cell4.setCellValue("");
   R0640cell4.setCellStyle(textStyle);
   }

   //ROW73
   //Column F: 
   Cell R0640cell5 = row.createCell(5);
   if (record1.getR0640_0_7days() != null) {
   R0640cell5.setCellValue(record1.getR0640_0_7days().doubleValue());
   R0640cell5.setCellStyle(numberStyle);
   } else {
   R0640cell5.setCellValue("");
   R0640cell5.setCellStyle(textStyle);
   }

   //ROW73
   //Column G: 
   Cell R0640cell6 = row.createCell(6);
   if (record1.getR0640_8_14days() != null) {
   R0640cell6.setCellValue(record1.getR0640_8_14days().doubleValue());
   R0640cell6.setCellStyle(numberStyle);
   } else {
   R0640cell6.setCellValue("");
   R0640cell6.setCellStyle(textStyle);
   }

   //ROW73
   //Column H: 
   Cell R0640cell7 = row.createCell(7);
   if (record1.getR0640_15days_1months() != null) {
   R0640cell7.setCellValue(record1.getR0640_15days_1months().doubleValue());
   R0640cell7.setCellStyle(numberStyle);
   } else {
   R0640cell7.setCellValue("");
   R0640cell7.setCellStyle(textStyle);
   }

   //ROW73
   //Column I: 
   Cell R0640cell8 = row.createCell(8);
   if (record1.getR0640_1_2months() != null) {
   R0640cell8.setCellValue(record1.getR0640_1_2months().doubleValue());
   R0640cell8.setCellStyle(numberStyle);
   } else {
   R0640cell8.setCellValue("");
   R0640cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW73
   //Column J: 
   Cell R0640cell9 = row.createCell(9);
   if (record1.getR0640_2_3months() != null) {
   R0640cell9.setCellValue(record1.getR0640_2_3months().doubleValue());
   R0640cell9.setCellStyle(numberStyle);
   } else {
   R0640cell9.setCellValue("");
   R0640cell9.setCellStyle(textStyle);
   }

   //ROW73
   //Column K: 
   Cell R0640cell10 = row.createCell(10);
   if (record1.getR0640_3_6months() != null) {
   R0640cell10.setCellValue(record1.getR0640_3_6months().doubleValue());
   R0640cell10.setCellStyle(numberStyle);
   } else {
   R0640cell10.setCellValue("");
   R0640cell10.setCellStyle(textStyle);
   }

   //ROW73
   //Column L: 
   Cell R0640cell11 = row.createCell(11);
   if (record1.getR0640_6_12months() != null) {
   R0640cell11.setCellValue(record1.getR0640_6_12months().doubleValue());
   R0640cell11.setCellStyle(numberStyle);
   } else {
   R0640cell11.setCellValue("");
   R0640cell11.setCellStyle(textStyle);
   }

   //ROW73
   //Column M: 
   Cell R0640cell12 = row.createCell(12);
   if (record1.getR0640_1_2years() != null) {
   R0640cell12.setCellValue(record1.getR0640_1_2years().doubleValue());
   R0640cell12.setCellStyle(numberStyle);
   } else {
   R0640cell12.setCellValue("");
   R0640cell12.setCellStyle(textStyle);
   }

   //ROW73
   //Column N: 
   Cell R0640cell13 = row.createCell(13);
   if (record1.getR0640_2_3years() != null) {
   R0640cell13.setCellValue(record1.getR0640_2_3years().doubleValue());
   R0640cell13.setCellStyle(numberStyle);
   } else {
   R0640cell13.setCellValue("");
   R0640cell13.setCellStyle(textStyle);
   }

   //ROW73
   //Column O: 
   Cell R0640cell14 = row.createCell(14);
   if (record1.getR0640_3_4years() != null) {
   R0640cell14.setCellValue(record1.getR0640_3_4years().doubleValue());
   R0640cell14.setCellStyle(numberStyle);
   } else {
   R0640cell14.setCellValue("");
   R0640cell14.setCellStyle(textStyle);
   }

   //ROW73
   //Column P: 
   Cell R0640cell15 = row.createCell(15);
   if (record1.getR0640_4_5years() != null) {
   R0640cell15.setCellValue(record1.getR0640_4_5years().doubleValue());
   R0640cell15.setCellStyle(numberStyle);
   } else {
   R0640cell15.setCellValue("");
   R0640cell15.setCellStyle(textStyle);
   }

   //ROW73
   //Column Q: 
   Cell R0640cell16 = row.createCell(16);
   if (record1.getR0640_5years() != null) {
   R0640cell16.setCellValue(record1.getR0640_5years().doubleValue());
   R0640cell16.setCellStyle(numberStyle);
   } else {
   R0640cell16.setCellValue("");
   R0640cell16.setCellStyle(textStyle);
   }

   //ROW73
   //Column R: 
   Cell R0640cell17 = row.createCell(17);
   if (record1.getR0640_non_interest() != null) {
   R0640cell17.setCellValue(record1.getR0640_non_interest().doubleValue());
   R0640cell17.setCellStyle(numberStyle);
   } else {
   R0640cell17.setCellValue("");
   R0640cell17.setCellStyle(textStyle);
   }

   /////ROW74///////////
   //ROW74
   //Column E: 
   row = sheet.getRow(73);
   Cell R0650cell4 = row.createCell(4);
   if (record1.getR0650_overdraft() != null) {
   R0650cell4.setCellValue(record1.getR0650_overdraft().doubleValue());
   R0650cell4.setCellStyle(numberStyle);
   } else {
   R0650cell4.setCellValue("");
   R0650cell4.setCellStyle(textStyle);
   }

   //ROW74
   //Column F: 
   Cell R0650cell5 = row.createCell(5);
   if (record1.getR0650_0_7days() != null) {
   R0650cell5.setCellValue(record1.getR0650_0_7days().doubleValue());
   R0650cell5.setCellStyle(numberStyle);
   } else {
   R0650cell5.setCellValue("");
   R0650cell5.setCellStyle(textStyle);
   }

   //ROW74
   //Column G: 
   Cell R0650cell6 = row.createCell(6);
   if (record1.getR0650_8_14days() != null) {
   R0650cell6.setCellValue(record1.getR0650_8_14days().doubleValue());
   R0650cell6.setCellStyle(numberStyle);
   } else {
   R0650cell6.setCellValue("");
   R0650cell6.setCellStyle(textStyle);
   }

   //ROW74
   //Column H: 
   Cell R0650cell7 = row.createCell(7);
   if (record1.getR0650_15days_1months() != null) {
   R0650cell7.setCellValue(record1.getR0650_15days_1months().doubleValue());
   R0650cell7.setCellStyle(numberStyle);
   } else {
   R0650cell7.setCellValue("");
   R0650cell7.setCellStyle(textStyle);
   }

   //ROW74
   //Column I: 
   Cell R0650cell8 = row.createCell(8);
   if (record1.getR0650_1_2months() != null) {
   R0650cell8.setCellValue(record1.getR0650_1_2months().doubleValue());
   R0650cell8.setCellStyle(numberStyle);
   } else {
   R0650cell8.setCellValue("");
   R0650cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW74
   //Column J: 
   Cell R0650cell9 = row.createCell(9);
   if (record1.getR0650_2_3months() != null) {
   R0650cell9.setCellValue(record1.getR0650_2_3months().doubleValue());
   R0650cell9.setCellStyle(numberStyle);
   } else {
   R0650cell9.setCellValue("");
   R0650cell9.setCellStyle(textStyle);
   }

   //ROW74
   //Column K: 
   Cell R0650cell10 = row.createCell(10);
   if (record1.getR0650_3_6months() != null) {
   R0650cell10.setCellValue(record1.getR0650_3_6months().doubleValue());
   R0650cell10.setCellStyle(numberStyle);
   } else {
   R0650cell10.setCellValue("");
   R0650cell10.setCellStyle(textStyle);
   }

   //ROW74
   //Column L: 
   Cell R0650cell11 = row.createCell(11);
   if (record1.getR0650_6_12months() != null) {
   R0650cell11.setCellValue(record1.getR0650_6_12months().doubleValue());
   R0650cell11.setCellStyle(numberStyle);
   } else {
   R0650cell11.setCellValue("");
   R0650cell11.setCellStyle(textStyle);
   }

   //ROW74
   //Column M: 
   Cell R0650cell12 = row.createCell(12);
   if (record1.getR0650_1_2years() != null) {
   R0650cell12.setCellValue(record1.getR0650_1_2years().doubleValue());
   R0650cell12.setCellStyle(numberStyle);
   } else {
   R0650cell12.setCellValue("");
   R0650cell12.setCellStyle(textStyle);
   }

   //ROW74
   //Column N: 
   Cell R0650cell13 = row.createCell(13);
   if (record1.getR0650_2_3years() != null) {
   R0650cell13.setCellValue(record1.getR0650_2_3years().doubleValue());
   R0650cell13.setCellStyle(numberStyle);
   } else {
   R0650cell13.setCellValue("");
   R0650cell13.setCellStyle(textStyle);
   }

   //ROW74
   //Column O: 
   Cell R0650cell14 = row.createCell(14);
   if (record1.getR0650_3_4years() != null) {
   R0650cell14.setCellValue(record1.getR0650_3_4years().doubleValue());
   R0650cell14.setCellStyle(numberStyle);
   } else {
   R0650cell14.setCellValue("");
   R0650cell14.setCellStyle(textStyle);
   }

   //ROW74
   //Column P: 
   Cell R0650cell15 = row.createCell(15);
   if (record1.getR0650_4_5years() != null) {
   R0650cell15.setCellValue(record1.getR0650_4_5years().doubleValue());
   R0650cell15.setCellStyle(numberStyle);
   } else {
   R0650cell15.setCellValue("");
   R0650cell15.setCellStyle(textStyle);
   }

   //ROW74
   //Column Q: 
   Cell R0650cell16 = row.createCell(16);
   if (record1.getR0650_5years() != null) {
   R0650cell16.setCellValue(record1.getR0650_5years().doubleValue());
   R0650cell16.setCellStyle(numberStyle);
   } else {
   R0650cell16.setCellValue("");
   R0650cell16.setCellStyle(textStyle);
   }

   //ROW74
   //Column R: 
   Cell R0650cell17 = row.createCell(17);
   if (record1.getR0650_non_interest() != null) {
   R0650cell17.setCellValue(record1.getR0650_non_interest().doubleValue());
   R0650cell17.setCellStyle(numberStyle);
   } else {
   R0650cell17.setCellValue("");
   R0650cell17.setCellStyle(textStyle);
   }

   /////ROW75///////////
   //ROW75
   //Column E: 
   row = sheet.getRow(74);
   Cell R0660cell4 = row.createCell(4);
   if (record1.getR0660_overdraft() != null) {
   R0660cell4.setCellValue(record1.getR0660_overdraft().doubleValue());
   R0660cell4.setCellStyle(numberStyle);
   } else {
   R0660cell4.setCellValue("");
   R0660cell4.setCellStyle(textStyle);
   }

   //ROW75
   //Column F: 
   Cell R0660cell5 = row.createCell(5);
   if (record1.getR0660_0_7days() != null) {
   R0660cell5.setCellValue(record1.getR0660_0_7days().doubleValue());
   R0660cell5.setCellStyle(numberStyle);
   } else {
   R0660cell5.setCellValue("");
   R0660cell5.setCellStyle(textStyle);
   }

   //ROW75
   //Column G: 
   Cell R0660cell6 = row.createCell(6);
   if (record1.getR0660_8_14days() != null) {
   R0660cell6.setCellValue(record1.getR0660_8_14days().doubleValue());
   R0660cell6.setCellStyle(numberStyle);
   } else {
   R0660cell6.setCellValue("");
   R0660cell6.setCellStyle(textStyle);
   }

   //ROW75
   //Column H: 
   Cell R0660cell7 = row.createCell(7);
   if (record1.getR0660_15days_1months() != null) {
   R0660cell7.setCellValue(record1.getR0660_15days_1months().doubleValue());
   R0660cell7.setCellStyle(numberStyle);
   } else {
   R0660cell7.setCellValue("");
   R0660cell7.setCellStyle(textStyle);
   }

   //ROW75
   //Column I: 
   Cell R0660cell8 = row.createCell(8);
   if (record1.getR0660_1_2months() != null) {
   R0660cell8.setCellValue(record1.getR0660_1_2months().doubleValue());
   R0660cell8.setCellStyle(numberStyle);
   } else {
   R0660cell8.setCellValue("");
   R0660cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW75
   //Column J: 
   Cell R0660cell9 = row.createCell(9);
   if (record1.getR0660_2_3months() != null) {
   R0660cell9.setCellValue(record1.getR0660_2_3months().doubleValue());
   R0660cell9.setCellStyle(numberStyle);
   } else {
   R0660cell9.setCellValue("");
   R0660cell9.setCellStyle(textStyle);
   }

   //ROW75
   //Column K: 
   Cell R0660cell10 = row.createCell(10);
   if (record1.getR0660_3_6months() != null) {
   R0660cell10.setCellValue(record1.getR0660_3_6months().doubleValue());
   R0660cell10.setCellStyle(numberStyle);
   } else {
   R0660cell10.setCellValue("");
   R0660cell10.setCellStyle(textStyle);
   }

   //ROW75
   //Column L: 
   Cell R0660cell11 = row.createCell(11);
   if (record1.getR0660_6_12months() != null) {
   R0660cell11.setCellValue(record1.getR0660_6_12months().doubleValue());
   R0660cell11.setCellStyle(numberStyle);
   } else {
   R0660cell11.setCellValue("");
   R0660cell11.setCellStyle(textStyle);
   }

   //ROW75
   //Column M: 
   Cell R0660cell12 = row.createCell(12);
   if (record1.getR0660_1_2years() != null) {
   R0660cell12.setCellValue(record1.getR0660_1_2years().doubleValue());
   R0660cell12.setCellStyle(numberStyle);
   } else {
   R0660cell12.setCellValue("");
   R0660cell12.setCellStyle(textStyle);
   }

   //ROW75
   //Column N: 
   Cell R0660cell13 = row.createCell(13);
   if (record1.getR0660_2_3years() != null) {
   R0660cell13.setCellValue(record1.getR0660_2_3years().doubleValue());
   R0660cell13.setCellStyle(numberStyle);
   } else {
   R0660cell13.setCellValue("");
   R0660cell13.setCellStyle(textStyle);
   }

   //ROW75
   //Column O: 
   Cell R0660cell14 = row.createCell(14);
   if (record1.getR0660_3_4years() != null) {
   R0660cell14.setCellValue(record1.getR0660_3_4years().doubleValue());
   R0660cell14.setCellStyle(numberStyle);
   } else {
   R0660cell14.setCellValue("");
   R0660cell14.setCellStyle(textStyle);
   }

   //ROW75
   //Column P: 
   Cell R0660cell15 = row.createCell(15);
   if (record1.getR0660_4_5years() != null) {
   R0660cell15.setCellValue(record1.getR0660_4_5years().doubleValue());
   R0660cell15.setCellStyle(numberStyle);
   } else {
   R0660cell15.setCellValue("");
   R0660cell15.setCellStyle(textStyle);
   }

   //ROW75
   //Column Q: 
   Cell R0660cell16 = row.createCell(16);
   if (record1.getR0660_5years() != null) {
   R0660cell16.setCellValue(record1.getR0660_5years().doubleValue());
   R0660cell16.setCellStyle(numberStyle);
   } else {
   R0660cell16.setCellValue("");
   R0660cell16.setCellStyle(textStyle);
   }

   //ROW75
   //Column R: 
   Cell R0660cell17 = row.createCell(17);
   if (record1.getR0660_non_interest() != null) {
   R0660cell17.setCellValue(record1.getR0660_non_interest().doubleValue());
   R0660cell17.setCellStyle(numberStyle);
   } else {
   R0660cell17.setCellValue("");
   R0660cell17.setCellStyle(textStyle);
   }

   /////ROW78///////////
   //ROW78
   //Column E: 
   row = sheet.getRow(77);
   Cell R0690cell4 = row.createCell(4);
   if (record1.getR0690_overdraft() != null) {
   R0690cell4.setCellValue(record1.getR0690_overdraft().doubleValue());
   R0690cell4.setCellStyle(numberStyle);
   } else {
   R0690cell4.setCellValue("");
   R0690cell4.setCellStyle(textStyle);
   }

   //ROW78
   //Column F: 
   Cell R0690cell5 = row.createCell(5);
   if (record1.getR0690_0_7days() != null) {
   R0690cell5.setCellValue(record1.getR0690_0_7days().doubleValue());
   R0690cell5.setCellStyle(numberStyle);
   } else {
   R0690cell5.setCellValue("");
   R0690cell5.setCellStyle(textStyle);
   }

   //ROW78
   //Column G: 
   Cell R0690cell6 = row.createCell(6);
   if (record1.getR0690_8_14days() != null) {
   R0690cell6.setCellValue(record1.getR0690_8_14days().doubleValue());
   R0690cell6.setCellStyle(numberStyle);
   } else {
   R0690cell6.setCellValue("");
   R0690cell6.setCellStyle(textStyle);
   }

   //ROW78
   //Column H: 
   Cell R0690cell7 = row.createCell(7);
   if (record1.getR0690_15days_1months() != null) {
   R0690cell7.setCellValue(record1.getR0690_15days_1months().doubleValue());
   R0690cell7.setCellStyle(numberStyle);
   } else {
   R0690cell7.setCellValue("");
   R0690cell7.setCellStyle(textStyle);
   }

   //ROW78
   //Column I: 
   Cell R0690cell8 = row.createCell(8);
   if (record1.getR0690_1_2months() != null) {
   R0690cell8.setCellValue(record1.getR0690_1_2months().doubleValue());
   R0690cell8.setCellStyle(numberStyle);
   } else {
   R0690cell8.setCellValue("");
   R0690cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW78
   //Column J: 
   Cell R0690cell9 = row.createCell(9);
   if (record1.getR0690_2_3months() != null) {
   R0690cell9.setCellValue(record1.getR0690_2_3months().doubleValue());
   R0690cell9.setCellStyle(numberStyle);
   } else {
   R0690cell9.setCellValue("");
   R0690cell9.setCellStyle(textStyle);
   }

   //ROW78
   //Column K: 
   Cell R0690cell10 = row.createCell(10);
   if (record1.getR0690_3_6months() != null) {
   R0690cell10.setCellValue(record1.getR0690_3_6months().doubleValue());
   R0690cell10.setCellStyle(numberStyle);
   } else {
   R0690cell10.setCellValue("");
   R0690cell10.setCellStyle(textStyle);
   }

   //ROW78
   //Column L: 
   Cell R0690cell11 = row.createCell(11);
   if (record1.getR0690_6_12months() != null) {
   R0690cell11.setCellValue(record1.getR0690_6_12months().doubleValue());
   R0690cell11.setCellStyle(numberStyle);
   } else {
   R0690cell11.setCellValue("");
   R0690cell11.setCellStyle(textStyle);
   }

   //ROW78
   //Column M: 
   Cell R0690cell12 = row.createCell(12);
   if (record1.getR0690_1_2years() != null) {
   R0690cell12.setCellValue(record1.getR0690_1_2years().doubleValue());
   R0690cell12.setCellStyle(numberStyle);
   } else {
   R0690cell12.setCellValue("");
   R0690cell12.setCellStyle(textStyle);
   }

   //ROW78
   //Column N: 
   Cell R0690cell13 = row.createCell(13);
   if (record1.getR0690_2_3years() != null) {
   R0690cell13.setCellValue(record1.getR0690_2_3years().doubleValue());
   R0690cell13.setCellStyle(numberStyle);
   } else {
   R0690cell13.setCellValue("");
   R0690cell13.setCellStyle(textStyle);
   }

   //ROW78
   //Column O: 
   Cell R0690cell14 = row.createCell(14);
   if (record1.getR0690_3_4years() != null) {
   R0690cell14.setCellValue(record1.getR0690_3_4years().doubleValue());
   R0690cell14.setCellStyle(numberStyle);
   } else {
   R0690cell14.setCellValue("");
   R0690cell14.setCellStyle(textStyle);
   }

   //ROW78
   //Column P: 
   Cell R0690cell15 = row.createCell(15);
   if (record1.getR0690_4_5years() != null) {
   R0690cell15.setCellValue(record1.getR0690_4_5years().doubleValue());
   R0690cell15.setCellStyle(numberStyle);
   } else {
   R0690cell15.setCellValue("");
   R0690cell15.setCellStyle(textStyle);
   }

   //ROW78
   //Column Q: 
   Cell R0690cell16 = row.createCell(16);
   if (record1.getR0690_5years() != null) {
   R0690cell16.setCellValue(record1.getR0690_5years().doubleValue());
   R0690cell16.setCellStyle(numberStyle);
   } else {
   R0690cell16.setCellValue("");
   R0690cell16.setCellStyle(textStyle);
   }

   //ROW78
   //Column R: 
   Cell R0690cell17 = row.createCell(17);
   if (record1.getR0690_non_interest() != null) {
   R0690cell17.setCellValue(record1.getR0690_non_interest().doubleValue());
   R0690cell17.setCellStyle(numberStyle);
   } else {
   R0690cell17.setCellValue("");
   R0690cell17.setCellStyle(textStyle);
   }

   /////ROW79///////////
   //ROW79
   //Column E: 
   row = sheet.getRow(78);
   Cell R0700cell4 = row.createCell(4);
   if (record1.getR0700_overdraft() != null) {
   R0700cell4.setCellValue(record1.getR0700_overdraft().doubleValue());
   R0700cell4.setCellStyle(numberStyle);
   } else {
   R0700cell4.setCellValue("");
   R0700cell4.setCellStyle(textStyle);
   }

   //ROW79
   //Column F: 
   Cell R0700cell5 = row.createCell(5);
   if (record1.getR0700_0_7days() != null) {
   R0700cell5.setCellValue(record1.getR0700_0_7days().doubleValue());
   R0700cell5.setCellStyle(numberStyle);
   } else {
   R0700cell5.setCellValue("");
   R0700cell5.setCellStyle(textStyle);
   }

   //ROW79
   //Column G: 
   Cell R0700cell6 = row.createCell(6);
   if (record1.getR0700_8_14days() != null) {
   R0700cell6.setCellValue(record1.getR0700_8_14days().doubleValue());
   R0700cell6.setCellStyle(numberStyle);
   } else {
   R0700cell6.setCellValue("");
   R0700cell6.setCellStyle(textStyle);
   }

   //ROW79
   //Column H: 
   Cell R0700cell7 = row.createCell(7);
   if (record1.getR0700_15days_1months() != null) {
   R0700cell7.setCellValue(record1.getR0700_15days_1months().doubleValue());
   R0700cell7.setCellStyle(numberStyle);
   } else {
   R0700cell7.setCellValue("");
   R0700cell7.setCellStyle(textStyle);
   }

   //ROW79
   //Column I: 
   Cell R0700cell8 = row.createCell(8);
   if (record1.getR0700_1_2months() != null) {
   R0700cell8.setCellValue(record1.getR0700_1_2months().doubleValue());
   R0700cell8.setCellStyle(numberStyle);
   } else {
   R0700cell8.setCellValue("");
   R0700cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW79
   //Column J: 
   Cell R0700cell9 = row.createCell(9);
   if (record1.getR0700_2_3months() != null) {
   R0700cell9.setCellValue(record1.getR0700_2_3months().doubleValue());
   R0700cell9.setCellStyle(numberStyle);
   } else {
   R0700cell9.setCellValue("");
   R0700cell9.setCellStyle(textStyle);
   }

   //ROW79
   //Column K: 
   Cell R0700cell10 = row.createCell(10);
   if (record1.getR0700_3_6months() != null) {
   R0700cell10.setCellValue(record1.getR0700_3_6months().doubleValue());
   R0700cell10.setCellStyle(numberStyle);
   } else {
   R0700cell10.setCellValue("");
   R0700cell10.setCellStyle(textStyle);
   }

   //ROW79
   //Column L: 
   Cell R0700cell11 = row.createCell(11);
   if (record1.getR0700_6_12months() != null) {
   R0700cell11.setCellValue(record1.getR0700_6_12months().doubleValue());
   R0700cell11.setCellStyle(numberStyle);
   } else {
   R0700cell11.setCellValue("");
   R0700cell11.setCellStyle(textStyle);
   }

   //ROW79
   //Column M: 
   Cell R0700cell12 = row.createCell(12);
   if (record1.getR0700_1_2years() != null) {
   R0700cell12.setCellValue(record1.getR0700_1_2years().doubleValue());
   R0700cell12.setCellStyle(numberStyle);
   } else {
   R0700cell12.setCellValue("");
   R0700cell12.setCellStyle(textStyle);
   }

   //ROW79
   //Column N: 
   Cell R0700cell13 = row.createCell(13);
   if (record1.getR0700_2_3years() != null) {
   R0700cell13.setCellValue(record1.getR0700_2_3years().doubleValue());
   R0700cell13.setCellStyle(numberStyle);
   } else {
   R0700cell13.setCellValue("");
   R0700cell13.setCellStyle(textStyle);
   }

   //ROW79
   //Column O: 
   Cell R0700cell14 = row.createCell(14);
   if (record1.getR0700_3_4years() != null) {
   R0700cell14.setCellValue(record1.getR0700_3_4years().doubleValue());
   R0700cell14.setCellStyle(numberStyle);
   } else {
   R0700cell14.setCellValue("");
   R0700cell14.setCellStyle(textStyle);
   }

   //ROW79
   //Column P: 
   Cell R0700cell15 = row.createCell(15);
   if (record1.getR0700_4_5years() != null) {
   R0700cell15.setCellValue(record1.getR0700_4_5years().doubleValue());
   R0700cell15.setCellStyle(numberStyle);
   } else {
   R0700cell15.setCellValue("");
   R0700cell15.setCellStyle(textStyle);
   }

   //ROW79
   //Column Q: 
   Cell R0700cell16 = row.createCell(16);
   if (record1.getR0700_5years() != null) {
   R0700cell16.setCellValue(record1.getR0700_5years().doubleValue());
   R0700cell16.setCellStyle(numberStyle);
   } else {
   R0700cell16.setCellValue("");
   R0700cell16.setCellStyle(textStyle);
   }

   //ROW79
   //Column R: 
   Cell R0700cell17 = row.createCell(17);
   if (record1.getR0700_non_interest() != null) {
   R0700cell17.setCellValue(record1.getR0700_non_interest().doubleValue());
   R0700cell17.setCellStyle(numberStyle);
   } else {
   R0700cell17.setCellValue("");
   R0700cell17.setCellStyle(textStyle);
   }

   /////ROW80///////////
   //ROW80
   //Column E: 
   row = sheet.getRow(79);
   Cell R0710cell4 = row.createCell(4);
   if (record1.getR0710_overdraft() != null) {
   R0710cell4.setCellValue(record1.getR0710_overdraft().doubleValue());
   R0710cell4.setCellStyle(numberStyle);
   } else {
   R0710cell4.setCellValue("");
   R0710cell4.setCellStyle(textStyle);
   }

   //ROW80
   //Column F: 
   Cell R0710cell5 = row.createCell(5);
   if (record1.getR0710_0_7days() != null) {
   R0710cell5.setCellValue(record1.getR0710_0_7days().doubleValue());
   R0710cell5.setCellStyle(numberStyle);
   } else {
   R0710cell5.setCellValue("");
   R0710cell5.setCellStyle(textStyle);
   }

   //ROW80
   //Column G: 
   Cell R0710cell6 = row.createCell(6);
   if (record1.getR0710_8_14days() != null) {
   R0710cell6.setCellValue(record1.getR0710_8_14days().doubleValue());
   R0710cell6.setCellStyle(numberStyle);
   } else {
   R0710cell6.setCellValue("");
   R0710cell6.setCellStyle(textStyle);
   }

   //ROW80
   //Column H: 
   Cell R0710cell7 = row.createCell(7);
   if (record1.getR0710_15days_1months() != null) {
   R0710cell7.setCellValue(record1.getR0710_15days_1months().doubleValue());
   R0710cell7.setCellStyle(numberStyle);
   } else {
   R0710cell7.setCellValue("");
   R0710cell7.setCellStyle(textStyle);
   }

   //ROW80
   //Column I: 
   Cell R0710cell8 = row.createCell(8);
   if (record1.getR0710_1_2months() != null) {
   R0710cell8.setCellValue(record1.getR0710_1_2months().doubleValue());
   R0710cell8.setCellStyle(numberStyle);
   } else {
   R0710cell8.setCellValue("");
   R0710cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW80
   //Column J: 
   Cell R0710cell9 = row.createCell(9);
   if (record1.getR0710_2_3months() != null) {
   R0710cell9.setCellValue(record1.getR0710_2_3months().doubleValue());
   R0710cell9.setCellStyle(numberStyle);
   } else {
   R0710cell9.setCellValue("");
   R0710cell9.setCellStyle(textStyle);
   }

   //ROW80
   //Column K: 
   Cell R0710cell10 = row.createCell(10);
   if (record1.getR0710_3_6months() != null) {
   R0710cell10.setCellValue(record1.getR0710_3_6months().doubleValue());
   R0710cell10.setCellStyle(numberStyle);
   } else {
   R0710cell10.setCellValue("");
   R0710cell10.setCellStyle(textStyle);
   }

   //ROW80
   //Column L: 
   Cell R0710cell11 = row.createCell(11);
   if (record1.getR0710_6_12months() != null) {
   R0710cell11.setCellValue(record1.getR0710_6_12months().doubleValue());
   R0710cell11.setCellStyle(numberStyle);
   } else {
   R0710cell11.setCellValue("");
   R0710cell11.setCellStyle(textStyle);
   }

   //ROW80
   //Column M: 
   Cell R0710cell12 = row.createCell(12);
   if (record1.getR0710_1_2years() != null) {
   R0710cell12.setCellValue(record1.getR0710_1_2years().doubleValue());
   R0710cell12.setCellStyle(numberStyle);
   } else {
   R0710cell12.setCellValue("");
   R0710cell12.setCellStyle(textStyle);
   }

   //ROW80
   //Column N: 
   Cell R0710cell13 = row.createCell(13);
   if (record1.getR0710_2_3years() != null) {
   R0710cell13.setCellValue(record1.getR0710_2_3years().doubleValue());
   R0710cell13.setCellStyle(numberStyle);
   } else {
   R0710cell13.setCellValue("");
   R0710cell13.setCellStyle(textStyle);
   }

   //ROW80
   //Column O: 
   Cell R0710cell14 = row.createCell(14);
   if (record1.getR0710_3_4years() != null) {
   R0710cell14.setCellValue(record1.getR0710_3_4years().doubleValue());
   R0710cell14.setCellStyle(numberStyle);
   } else {
   R0710cell14.setCellValue("");
   R0710cell14.setCellStyle(textStyle);
   }

   //ROW80
   //Column P: 
   Cell R0710cell15 = row.createCell(15);
   if (record1.getR0710_4_5years() != null) {
   R0710cell15.setCellValue(record1.getR0710_4_5years().doubleValue());
   R0710cell15.setCellStyle(numberStyle);
   } else {
   R0710cell15.setCellValue("");
   R0710cell15.setCellStyle(textStyle);
   }

   //ROW80
   //Column Q: 
   Cell R0710cell16 = row.createCell(16);
   if (record1.getR0710_5years() != null) {
   R0710cell16.setCellValue(record1.getR0710_5years().doubleValue());
   R0710cell16.setCellStyle(numberStyle);
   } else {
   R0710cell16.setCellValue("");
   R0710cell16.setCellStyle(textStyle);
   }

   //ROW80
   //Column R: 
   Cell R0710cell17 = row.createCell(17);
   if (record1.getR0710_non_interest() != null) {
   R0710cell17.setCellValue(record1.getR0710_non_interest().doubleValue());
   R0710cell17.setCellStyle(numberStyle);
   } else {
   R0710cell17.setCellValue("");
   R0710cell17.setCellStyle(textStyle);
   }


   /////ROW81///////////
   //ROW81
   //Column E: 
   row = sheet.getRow(80);
   Cell R0720cell4 = row.createCell(4);
   if (record1.getR0720_overdraft() != null) {
   R0720cell4.setCellValue(record1.getR0720_overdraft().doubleValue());
   R0720cell4.setCellStyle(numberStyle);
   } else {
   R0720cell4.setCellValue("");
   R0720cell4.setCellStyle(textStyle);
   }

   //ROW81
   //Column F: 
   Cell R0720cell5 = row.createCell(5);
   if (record1.getR0720_0_7days() != null) {
   R0720cell5.setCellValue(record1.getR0720_0_7days().doubleValue());
   R0720cell5.setCellStyle(numberStyle);
   } else {
   R0720cell5.setCellValue("");
   R0720cell5.setCellStyle(textStyle);
   }

   //ROW81
   //Column G: 
   Cell R0720cell6 = row.createCell(6);
   if (record1.getR0720_8_14days() != null) {
   R0720cell6.setCellValue(record1.getR0720_8_14days().doubleValue());
   R0720cell6.setCellStyle(numberStyle);
   } else {
   R0720cell6.setCellValue("");
   R0720cell6.setCellStyle(textStyle);
   }

   //ROW81
   //Column H: 
   Cell R0720cell7 = row.createCell(7);
   if (record1.getR0720_15days_1months() != null) {
   R0720cell7.setCellValue(record1.getR0720_15days_1months().doubleValue());
   R0720cell7.setCellStyle(numberStyle);
   } else {
   R0720cell7.setCellValue("");
   R0720cell7.setCellStyle(textStyle);
   }

   //ROW81
   //Column I: 
   Cell R0720cell8 = row.createCell(8);
   if (record1.getR0720_1_2months() != null) {
   R0720cell8.setCellValue(record1.getR0720_1_2months().doubleValue());
   R0720cell8.setCellStyle(numberStyle);
   } else {
   R0720cell8.setCellValue("");
   R0720cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW81
   //Column J: 
   Cell R0720cell9 = row.createCell(9);
   if (record1.getR0720_2_3months() != null) {
   R0720cell9.setCellValue(record1.getR0720_2_3months().doubleValue());
   R0720cell9.setCellStyle(numberStyle);
   } else {
   R0720cell9.setCellValue("");
   R0720cell9.setCellStyle(textStyle);
   }

   //ROW81
   //Column K: 
   Cell R0720cell10 = row.createCell(10);
   if (record1.getR0720_3_6months() != null) {
   R0720cell10.setCellValue(record1.getR0720_3_6months().doubleValue());
   R0720cell10.setCellStyle(numberStyle);
   } else {
   R0720cell10.setCellValue("");
   R0720cell10.setCellStyle(textStyle);
   }

   //ROW81
   //Column L: 
   Cell R0720cell11 = row.createCell(11);
   if (record1.getR0720_6_12months() != null) {
   R0720cell11.setCellValue(record1.getR0720_6_12months().doubleValue());
   R0720cell11.setCellStyle(numberStyle);
   } else {
   R0720cell11.setCellValue("");
   R0720cell11.setCellStyle(textStyle);
   }

   //ROW81
   //Column M: 
   Cell R0720cell12 = row.createCell(12);
   if (record1.getR0720_1_2years() != null) {
   R0720cell12.setCellValue(record1.getR0720_1_2years().doubleValue());
   R0720cell12.setCellStyle(numberStyle);
   } else {
   R0720cell12.setCellValue("");
   R0720cell12.setCellStyle(textStyle);
   }

   //ROW81
   //Column N: 
   Cell R0720cell13 = row.createCell(13);
   if (record1.getR0720_2_3years() != null) {
   R0720cell13.setCellValue(record1.getR0720_2_3years().doubleValue());
   R0720cell13.setCellStyle(numberStyle);
   } else {
   R0720cell13.setCellValue("");
   R0720cell13.setCellStyle(textStyle);
   }

   //ROW81
   //Column O: 
   Cell R0720cell14 = row.createCell(14);
   if (record1.getR0720_3_4years() != null) {
   R0720cell14.setCellValue(record1.getR0720_3_4years().doubleValue());
   R0720cell14.setCellStyle(numberStyle);
   } else {
   R0720cell14.setCellValue("");
   R0720cell14.setCellStyle(textStyle);
   }

   //ROW81
   //Column P: 
   Cell R0720cell15 = row.createCell(15);
   if (record1.getR0720_4_5years() != null) {
   R0720cell15.setCellValue(record1.getR0720_4_5years().doubleValue());
   R0720cell15.setCellStyle(numberStyle);
   } else {
   R0720cell15.setCellValue("");
   R0720cell15.setCellStyle(textStyle);
   }

   //ROW81
   //Column Q: 
   Cell R0720cell16 = row.createCell(16);
   if (record1.getR0720_5years() != null) {
   R0720cell16.setCellValue(record1.getR0720_5years().doubleValue());
   R0720cell16.setCellStyle(numberStyle);
   } else {
   R0720cell16.setCellValue("");
   R0720cell16.setCellStyle(textStyle);
   }

   //ROW81
   //Column R: 
   Cell R0720cell17 = row.createCell(17);
   if (record1.getR0720_non_interest() != null) {
   R0720cell17.setCellValue(record1.getR0720_non_interest().doubleValue());
   R0720cell17.setCellStyle(numberStyle);
   } else {
   R0720cell17.setCellValue("");
   R0720cell17.setCellStyle(textStyle);
   }


   /////ROW82///////////
   //ROW82
   //Column E: 
   row = sheet.getRow(81);
   Cell R0730cell4 = row.createCell(4);
   if (record1.getR0730_overdraft() != null) {
   R0730cell4.setCellValue(record1.getR0730_overdraft().doubleValue());
   R0730cell4.setCellStyle(numberStyle);
   } else {
   R0730cell4.setCellValue("");
   R0730cell4.setCellStyle(textStyle);
   }

   //ROW82
   //Column F: 
   Cell R0730cell5 = row.createCell(5);
   if (record1.getR0730_0_7days() != null) {
   R0730cell5.setCellValue(record1.getR0730_0_7days().doubleValue());
   R0730cell5.setCellStyle(numberStyle);
   } else {
   R0730cell5.setCellValue("");
   R0730cell5.setCellStyle(textStyle);
   }

   //ROW82
   //Column G: 
   Cell R0730cell6 = row.createCell(6);
   if (record1.getR0730_8_14days() != null) {
   R0730cell6.setCellValue(record1.getR0730_8_14days().doubleValue());
   R0730cell6.setCellStyle(numberStyle);
   } else {
   R0730cell6.setCellValue("");
   R0730cell6.setCellStyle(textStyle);
   }

   //ROW82
   //Column H: 
   Cell R0730cell7 = row.createCell(7);
   if (record1.getR0730_15days_1months() != null) {
   R0730cell7.setCellValue(record1.getR0730_15days_1months().doubleValue());
   R0730cell7.setCellStyle(numberStyle);
   } else {
   R0730cell7.setCellValue("");
   R0730cell7.setCellStyle(textStyle);
   }

   //ROW82
   //Column I: 
   Cell R0730cell8 = row.createCell(8);
   if (record1.getR0730_1_2months() != null) {
   R0730cell8.setCellValue(record1.getR0730_1_2months().doubleValue());
   R0730cell8.setCellStyle(numberStyle);
   } else {
   R0730cell8.setCellValue("");
   R0730cell8.setCellStyle(textStyle);
   }
   		
   		
   //ROW82
   //Column J: 
   Cell R0730cell9 = row.createCell(9);
   if (record1.getR0730_2_3months() != null) {
   R0730cell9.setCellValue(record1.getR0730_2_3months().doubleValue());
   R0730cell9.setCellStyle(numberStyle);
   } else {
   R0730cell9.setCellValue("");
   R0730cell9.setCellStyle(textStyle);
   }

   //ROW82
   //Column K: 
   Cell R0730cell10 = row.createCell(10);
   if (record1.getR0730_3_6months() != null) {
   R0730cell10.setCellValue(record1.getR0730_3_6months().doubleValue());
   R0730cell10.setCellStyle(numberStyle);
   } else {
   R0730cell10.setCellValue("");
   R0730cell10.setCellStyle(textStyle);
   }

   //ROW82
   //Column L: 
   Cell R0730cell11 = row.createCell(11);
   if (record1.getR0730_6_12months() != null) {
   R0730cell11.setCellValue(record1.getR0730_6_12months().doubleValue());
   R0730cell11.setCellStyle(numberStyle);
   } else {
   R0730cell11.setCellValue("");
   R0730cell11.setCellStyle(textStyle);
   }

   //ROW82
   //Column M: 
   Cell R0730cell12 = row.createCell(12);
   if (record1.getR0730_1_2years() != null) {
   R0730cell12.setCellValue(record1.getR0730_1_2years().doubleValue());
   R0730cell12.setCellStyle(numberStyle);
   } else {
   R0730cell12.setCellValue("");
   R0730cell12.setCellStyle(textStyle);
   }

   //ROW82
   //Column N: 
   Cell R0730cell13 = row.createCell(13);
   if (record1.getR0730_2_3years() != null) {
   R0730cell13.setCellValue(record1.getR0730_2_3years().doubleValue());
   R0730cell13.setCellStyle(numberStyle);
   } else {
   R0730cell13.setCellValue("");
   R0730cell13.setCellStyle(textStyle);
   }

   //ROW82
   //Column O: 
   Cell R0730cell14 = row.createCell(14);
   if (record1.getR0730_3_4years() != null) {
   R0730cell14.setCellValue(record1.getR0730_3_4years().doubleValue());
   R0730cell14.setCellStyle(numberStyle);
   } else {
   R0730cell14.setCellValue("");
   R0730cell14.setCellStyle(textStyle);
   }

   //ROW82
   //Column P: 
   Cell R0730cell15 = row.createCell(15);
   if (record1.getR0730_4_5years() != null) {
   R0730cell15.setCellValue(record1.getR0730_4_5years().doubleValue());
   R0730cell15.setCellStyle(numberStyle);
   } else {
   R0730cell15.setCellValue("");
   R0730cell15.setCellStyle(textStyle);
   }

   //ROW82
   //Column Q: 
   Cell R0730cell16 = row.createCell(16);
   if (record1.getR0730_5years() != null) {
   R0730cell16.setCellValue(record1.getR0730_5years().doubleValue());
   R0730cell16.setCellStyle(numberStyle);
   } else {
   R0730cell16.setCellValue("");
   R0730cell16.setCellStyle(textStyle);
   }

   //ROW82
   //Column R: 
   Cell R0730cell17 = row.createCell(17);
   if (record1.getR0730_non_interest() != null) {
   R0730cell17.setCellValue(record1.getR0730_non_interest().doubleValue());
   R0730cell17.setCellStyle(numberStyle);
   } else {
   R0730cell17.setCellValue("");
   R0730cell17.setCellStyle(textStyle);
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
	
	
	
	
	}
