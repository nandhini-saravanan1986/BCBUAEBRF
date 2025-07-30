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

import com.bornfire.brf.entities.CBUAE_BRF7_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Detail_Repo;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity1;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity2;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity3;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity4;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity7;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity8;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Entity9;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo1;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo2;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo3;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo4;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo7;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo8;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Summary_Repo9;
import com.bornfire.brf.services.AuditService;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Detail_Entity;
import com.bornfire.brf.entities.CBUAE_BRF7_3_Detail_Repo;

@Component
@Service
public class CBUAE_BRF7_3_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF7_3_ReportService.class);
	
	@Autowired 
	AuditService auditService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF7_3_Detail_Repo BRF7_3_DETAIL_Repo;
	
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo1 BRF7_3Summary_Repo1;
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo2 BRF7_3Summary_Repo2;
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo3 BRF7_3Summary_Repo3;
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo4 BRF7_3Summary_Repo4;
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo7 BRF7_3Summary_Repo7;
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo8 BRF7_3Summary_Repo8;
	
	@Autowired
	CBUAE_BRF7_3_Summary_Repo9 BRF7_3Summary_Repo9;
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF7_3View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF7_3_Summary_Entity1> T1Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity1>();
		List<CBUAE_BRF7_3_Summary_Entity2> T2Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity2>();
		List<CBUAE_BRF7_3_Summary_Entity3> T3Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity3>();
		List<CBUAE_BRF7_3_Summary_Entity4> T4Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity4>();
		
		
		//5,6 are iterative
		List<CBUAE_BRF7_3_Summary_Entity7> T7Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity7>();
		List<CBUAE_BRF7_3_Summary_Entity8> T8Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity8>();
		List<CBUAE_BRF7_3_Summary_Entity9> T9Master = new ArrayList<CBUAE_BRF7_3_Summary_Entity9>();
		
		
		
		try {
			Date d1 = dateformat.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			//T1Master = hs.createQuery("from  BRF1_REPORT_ENTITY a where a.report_date = ?1 ", BRF1_REPORT_ENTITY.class)
				//	.setParameter(1, df.parse(todate)).getResultList();
			 T1Master=BRF7_3Summary_Repo1.getdatabydateList(dateformat.parse(todate));
			 
			 System.out.println("count is" + T1Master.size());
			 T2Master=BRF7_3Summary_Repo2.getdatabydateList(dateformat.parse(todate));
			
			 T3Master=BRF7_3Summary_Repo3.getdatabydateList(dateformat.parse(todate));
				
			 T4Master=BRF7_3Summary_Repo4.getdatabydateList(dateformat.parse(todate));
				
			 T7Master=BRF7_3Summary_Repo7.getdatabydateList(dateformat.parse(todate));
				
			 T8Master=BRF7_3Summary_Repo8.getdatabydateList(dateformat.parse(todate));
				
			 T9Master=BRF7_3Summary_Repo9.getdatabydateList(dateformat.parse(todate));
				
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF7_3");
		

		mv.addObject("reportsummary1", T1Master);
		mv.addObject("reportsummary2", T2Master);
		mv.addObject("reportsummary3", T3Master);
		mv.addObject("reportsummary4", T4Master);
		mv.addObject("reportsummary7", T7Master);
		mv.addObject("reportsummary8", T8Master);
		mv.addObject("reportsummary9", T9Master);
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF7_3currentDtl(
	        String reportId, String fromdate, String todate, String currency,
	        String dtltype, Pageable pageable, String filter) {

	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();

	    ModelAndView mv = new ModelAndView();
	    List<CBUAE_BRF7_3_Detail_Entity> T1Dt1 = new ArrayList<>();

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
	            T1Dt1 = BRF7_3_DETAIL_Repo.GetDataByRowIdAndColumnId(rowId, columnId);
	        } else {
	            T1Dt1 = BRF7_3_DETAIL_Repo.getdatabydateList(d1);
	        }

	        System.out.println("LISTCOUNT: " + T1Dt1.size());

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    mv.setViewName("BRF/BRF7_3");
	    mv.addObject("displaymode", "Details");
	    mv.addObject("reportdetails", T1Dt1);
	    mv.addObject("reportmaster12", T1Dt1);
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    return mv;
	}

	
	
		
	// DetailExcel
		public byte[] getBRF7_3DetailExcel(String filename, String fromdate, String todate, String currency, String dtltype,
				String type, String version) {
			try {
				logger.info("Generating Excel for BRF7_3 Details...");
				System.out.println("came to Detail download service");
				/*
				 * if (type.equals("ARCHIVAL") & version != null) { byte[] ARCHIVALreport =
				 * getBRF7_3DetailExcelARCHIVAL(filename, fromdate, todate, currency, dtltype,
				 * type, version); return ARCHIVALreport; }
				 */
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("BRF7_3Details");

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
				List<CBUAE_BRF7_3_Detail_Entity> reportData = BRF7_3_DETAIL_Repo.getdatabydateList(parsedToDate);

				if (reportData != null && !reportData.isEmpty()) {
					int rowIndex = 1;
					for (CBUAE_BRF7_3_Detail_Entity item : reportData) {
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
					logger.info("No data found for BRF7_3 — only header will be written.");
				}

				// Write to byte[]
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				workbook.write(bos);
				workbook.close();

				logger.info("Excel generation completed with {} row(s).", reportData != null ? reportData.size() : 0);
				return bos.toByteArray();

			} catch (Exception e) {
				logger.error("Error generating BRF7_3 Excel", e);
				return new byte[0];
			}
		}




}
