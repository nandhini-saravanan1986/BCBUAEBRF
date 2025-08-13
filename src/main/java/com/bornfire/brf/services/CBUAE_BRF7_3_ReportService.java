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
	            T1Dt1 = BRF7_3_DETAIL_Repo.getListbydate(d1);
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
				List<CBUAE_BRF7_3_Detail_Entity> reportData = BRF7_3_DETAIL_Repo.getListbydate(parsedToDate);

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




		public byte[] getBRF7_3Excel(String filename, String reportId, String fromdate, String todate, String currency,
                String dtltype, String type, String version) throws Exception {
logger.info("Service: Starting Excel generation process in memory.");

List<CBUAE_BRF7_3_Summary_Entity1> dataList = BRF7_3Summary_Repo1.getdatabydateList(dateformat.parse(todate));
List<CBUAE_BRF7_3_Summary_Entity2> dataList2 = BRF7_3Summary_Repo2.getdatabydateList(dateformat.parse(todate));
List<CBUAE_BRF7_3_Summary_Entity3> dataList3 = BRF7_3Summary_Repo3.getdatabydateList(dateformat.parse(todate));
List<CBUAE_BRF7_3_Summary_Entity4> dataList4 = BRF7_3Summary_Repo4.getdatabydateList(dateformat.parse(todate));

if (dataList.isEmpty()) {
logger.warn("Service: No data found for BRF7.3 report. Returning empty result.");
return new byte[0];
}
if (dataList2.isEmpty()) {
    logger.error("No data found for Entity2 - check query for date: {}", todate);
}
if (dataList3.isEmpty()) {
    logger.error("No data found for Entity3 - check query for date: {}", todate);
}
if (dataList4.isEmpty()) {
    logger.error("No data found for Entity4 - check query for date: {}", todate);
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
	    "R0030", "R0040", "R0050", "R0060", "R0070",
	    "R0080", "R0090", "R0100", "R0110", "R0120",
	    "R0130", "R0140", "R0150", "R0160", "R0170"
	};

String[] rowCodesPart2 = {
	    "R0190", "R0200", "R0210", "R0220", "R0230",
	    "R0240", "R0250","R0260"
	};

String[] rowCodesPart3 = {
	    "R0270", "R0280", "R0290", "R0300",
	    "R0310", "R0320", "R0330"
	};

String[] rowCodesPart4 = {
	    "R0360", "R0370", "R0380", "R0390", "R0400",
	    "R0410", "R0420", "R0430", "R0440"
	};

String[] rowCodesPart5 = {
	    "R0460", "R0470", "R0480", "R0490", "R0500", "R0510"
	};
String[] rowCodesPart6 = {
	    "R0520", "R0530", "R0540"
	};

String[] rowCodesPart7 = {
	    "R0560"
	};
String[] rowCodesPart8 = {
	    "R0580"
	};
String[] rowCodesPart9 = {
	    "R0600", "R0610", "R0620", "R0630", "R0640", "R0650", "R0660", "R0670"
	};
String[] rowCodesPart10 = {
	    "R0690"
	};
String[] rowCodesPart11 = {
	    "R0710"
	};
String[] rowCodesPart12 = {
	    "R0730"
	};
String[] rowCodesPart13 = {
	    "R0760", "R0770", "R0780", "R0790", "R0800", "R0810"
	};

String[] rowCodesPart14 = {
	    "R0820", "R0830", "R0840", "R0850"
	};

	String[] fieldSuffixes = {
	    "nat_amt", "hedg_nat_amt", "trad_nat_amt", "res_nat_amt", "non_res_nat_amt",
	    "within_1_year_nat_amt", "1_to_3_years_nat_amt", "over_3_years_nat_amt",
	    "gross_mkt_val", "res_lessthan_1_year_mkt_val", "res_1_to_3_years_mkt_val", "res_morethan_3_years_mkt_val",
	    "plusten_lessthan_1_year_hedg_net_loss_gain_underlying", "minusten_lessthan_1_year_hedg_net_loss_gain_underlying",
	    "plusten_1_to_3_years_hedg_net_loss_gain_underlying", "minusten_1_to_3_years_hedg_net_loss_gain_underlying",
	    "plusten_greaterthan_3_years_hedg_net_loss_gain_underlying", "minusten_greaterthan_3_years_hedg_net_loss_gain_underlying",
	    "plusten_lessthan_1_year_trad_net_loss_gain_underlying", "minusten_lessthan_1_year_trad_net_loss_gain_underlying",
	    "plusten_1_to_3_years_trad_net_loss_gain_underlying", "minusten_1_to_3_years_trad_net_loss_gain_underlying",
	    "plusten_greaterthan_3_years_trad_net_loss_gain_underlying", "minusten_greaterthan_3_years_trad_net_loss_gain_underlying"
	};
	
	String[] fieldSuffixes2 = {
		    "nat_amt", "hedg_nat_amt", "trad_nat_amt", "res_nat_amt", "non_res_nat_amt",
		    "within_1_year_nat_amt", "1_to_3_years_nat_amt", "over_3_years_nat_amt",
		    "gross_mkt_val", "res_lessthan_1_year_mkt_val", "res_1_to_3_years_mkt_val", "res_morethan_3_years_mkt_val"
		    };
	String[] fieldSuffixes3 = {
		    "plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift",
		    "minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift",
		    "plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift",
		    "minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift",
		    "plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift",
		    "minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift",
		    "plus_2bp_lessthan_1_year_trad_net_loss_parallelshift",
		    "minus_2bp_lessthan_1_year_trad_net_loss_parallelshift",
		    "plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift",
		    "minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift",
		    "plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift",
		    "minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift"
		};

	String[] fieldSuffixes4 = {
		    "nat_amt", "hedg_nat_amt", "trad_nat_amt", "res_nat_amt", "non_res_nat_amt",
		    "within_1_year_nat_amt", "1_to_3_years_nat_amt", "over_3_years_nat_amt"
		    };
	
	String[] fieldSuffixes5 = {
	"bought_hedg_net_delta_pos", "sold_hedg_net_delta_pos",
    "bought_trad_net_delta_pos", "sold_trad_net_delta_pos"
	};

	String[] fieldSuffixes6 = {"nat_amt"};
	
	String[] fieldSuffixes7 = {
		    "res_nat_amt", "non_res_nat_amt",
		    "within_1_year_nat_amt", "1_to_3_years_nat_amt", "over_3_years_nat_amt"
		    };
	String[] fieldSuffixes8 = {"plusten_lessthan_1_year_hedg_net_loss_gain_underlying", "minusten_lessthan_1_year_hedg_net_loss_gain_underlying",
		    "plusten_1_to_3_years_hedg_net_loss_gain_underlying", "minusten_1_to_3_years_hedg_net_loss_gain_underlying",
		    "plusten_greaterthan_3_years_hedg_net_loss_gain_underlying", "minusten_greaterthan_3_years_hedg_net_loss_gain_underlying",
		    "plusten_lessthan_1_year_trad_net_loss_gain_underlying", "minusten_lessthan_1_year_trad_net_loss_gain_underlying",
		    "plusten_1_to_3_years_trad_net_loss_gain_underlying", "minusten_1_to_3_years_trad_net_loss_gain_underlying",
		    "plusten_greaterthan_3_years_trad_net_loss_gain_underlying", "minusten_greaterthan_3_years_trad_net_loss_gain_underlying",
		    "plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift",
		    "minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift",
		    "plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift",
		    "minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift",
		    "plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift",
		    "minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift",
		    "plus_2bp_lessthan_1_year_trad_net_loss_parallelshift",
		    "minus_2bp_lessthan_1_year_trad_net_loss_parallelshift",
		    "plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift",
		    "minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift",
		    "plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift",
		    "minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift"
		};
	
	String[] fieldSuffixes9 = {"plusten_lessthan_1_year_hedg_net_loss_gain_underlying", "minusten_lessthan_1_year_hedg_net_loss_gain_underlying",
		    "plusten_1_to_3_years_hedg_net_loss_gain_underlying", "minusten_1_to_3_years_hedg_net_loss_gain_underlying",
		    "plusten_greaterthan_3_years_hedg_net_loss_gain_underlying", "minusten_greaterthan_3_years_hedg_net_loss_gain_underlying",
		    "plusten_lessthan_1_year_trad_net_loss_gain_underlying", "minusten_lessthan_1_year_trad_net_loss_gain_underlying",
		    "plusten_1_to_3_years_trad_net_loss_gain_underlying", "minusten_1_to_3_years_trad_net_loss_gain_underlying",
		    "plusten_greaterthan_3_years_trad_net_loss_gain_underlying", "minusten_greaterthan_3_years_trad_net_loss_gain_underlying"					    
		};
	
	String[] fieldSuffixes10 = {"pro_bought_net_gain_loss", "pro_sold_net_gain_loss"};
	
	// First set: R0030 - R0170 at row 12
	writeRowData1(sheet, dataList, rowCodesPart1, fieldSuffixes, 12, numberStyle, textStyle);

	// Second set: R0190 - R0260 at row 28 (skipping R0180 and one row)
	writeRowData1(sheet, dataList, rowCodesPart2, fieldSuffixes, 28, numberStyle, textStyle);

	// Third set: R0270 - R0330 at row 36 (i.e., Excel row 37)
	writeRowData2(sheet, dataList2, rowCodesPart3, fieldSuffixes, 36, numberStyle, textStyle);

	// Fourth set: R0360 - R0440 at row 43 (36 + 7 + 2(static) rows from previous block)
	writeRowData3(sheet, dataList2, rowCodesPart4, fieldSuffixes2, 45, numberStyle, textStyle);
	
	writeRowData4(sheet, dataList2, rowCodesPart4, fieldSuffixes3, 45, numberStyle, textStyle);
	
	// Fourth set: R0460 - R05410 at row 55 (45 + 9 + 1(static) rows from previous block)
	writeRowData3(sheet, dataList2, rowCodesPart5, fieldSuffixes2, 55, numberStyle, textStyle);
	
	writeRowData4(sheet, dataList2, rowCodesPart5, fieldSuffixes3, 55, numberStyle, textStyle);
	
	//R0520-R0540
	writeRowData5(sheet, dataList3, rowCodesPart6, fieldSuffixes2, 61, numberStyle, textStyle);
	
	writeRowData6(sheet, dataList3, rowCodesPart6, fieldSuffixes3, 61, numberStyle, textStyle);
	
	// Fifth set: R0560 at row 65 (61 + 2 + 1(static) rows from previous block)
	writeRowData5(sheet, dataList3, rowCodesPart7, fieldSuffixes4, 65, numberStyle, textStyle);
	
	writeRowData6(sheet, dataList3, rowCodesPart7, fieldSuffixes3, 65, numberStyle, textStyle);
	
	// SIXTH set: R0580 at row 67 (65 + 1(static) rows from previous block)
	writeRowData5(sheet, dataList3, rowCodesPart8, fieldSuffixes4, 67, numberStyle, textStyle);
	writeRowData6(sheet, dataList3, rowCodesPart8, fieldSuffixes3, 67, numberStyle, textStyle);
	
	// Seventh set: R0600-R0670 at row 69 (67 + 1(static) rows from previous block)
	writeRowData5(sheet, dataList3, rowCodesPart9, fieldSuffixes4, 69, numberStyle, textStyle);
	
	writeRowData7(sheet, dataList3, rowCodesPart9, fieldSuffixes5, 69, numberStyle, textStyle);
	
	//eighth set: only for R0690
	writeRowData8(sheet, dataList3, rowCodesPart10, fieldSuffixes6, 78, numberStyle, textStyle);
	
	writeRowData9(sheet, dataList3, rowCodesPart10, fieldSuffixes7, 78, numberStyle, textStyle);
	
	writeRowData10(sheet, dataList3, rowCodesPart10, fieldSuffixes3, 78, numberStyle, textStyle);
	
	//Ninth set: only for R0710
	writeRowData5(sheet, dataList3, rowCodesPart11, fieldSuffixes4, 80, numberStyle, textStyle);
	
	writeRowData11(sheet, dataList3, rowCodesPart11, fieldSuffixes8, 80, numberStyle, textStyle);
	
	//Tenth set: only for R0730
	writeRowData5(sheet, dataList3, rowCodesPart12, fieldSuffixes4, 82, numberStyle, textStyle);
	
	writeRowData11(sheet, dataList3, rowCodesPart12, fieldSuffixes9, 82, numberStyle, textStyle);
	
	// Eleventh set: R0760-R0850 at row 85 (82 + 2(static) rows from previous block)
	writeRowData5(sheet, dataList3, rowCodesPart13, fieldSuffixes4, 85, numberStyle, textStyle);
	
	writeRowData12(sheet, dataList3, rowCodesPart13, fieldSuffixes10, 85, numberStyle, textStyle);
	
	writeRowData13(sheet, dataList4, rowCodesPart14, fieldSuffixes4, 91, numberStyle, textStyle);
	
	writeRowData14(sheet, dataList4, rowCodesPart14, fieldSuffixes10, 91, numberStyle, textStyle);
	
workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
workbook.write(out);
logger.info("Service: Excel data successfully written to memory buffer ({} bytes).", out.size());

return out.toByteArray();
}
}

//C0010-C0240
private void writeRowData1(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity1> dataList,
    String[] rowCodes, String[] fieldSuffixes, int baseRow,
    CellStyle numberStyle, CellStyle textStyle) {
	
	for (CBUAE_BRF7_3_Summary_Entity1 record : dataList) {
	for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
	  String rowCode = rowCodes[rowIndex];
	  Row row = sheet.getRow(baseRow + rowIndex);
	  if (row == null) row = sheet.createRow(baseRow + rowIndex);
	
	  for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
	      String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
	      Cell cell = row.createCell(4 + colIndex);
	      try {
	          Field field = CBUAE_BRF7_3_Summary_Entity1.class.getDeclaredField(fieldName);
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

//C0010-C0240 Entity changed
private void writeRowData2(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity2> dataList,
    String[] rowCodes, String[] fieldSuffixes, int baseRow,
    CellStyle numberStyle, CellStyle textStyle) {

logger.info("writeRowData2 - Starting with {} records", dataList.size());

if (dataList.isEmpty()) {
    logger.warn("writeRowData2 - dataList is empty!");
    return;
}

for (CBUAE_BRF7_3_Summary_Entity2 record : dataList) {
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
                Field field = CBUAE_BRF7_3_Summary_Entity2.class.getDeclaredField(fieldName);
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

//C0010-C0120
private void writeRowData3(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity2> dataList,
    String[] rowCodes, String[] fieldSuffixes, int baseRow,
    CellStyle numberStyle, CellStyle textStyle) {

logger.info("writeRowData3 - Starting with {} records", dataList.size());

if (dataList.isEmpty()) {
    logger.warn("writeRowData3 - dataList is empty!");
    return;
}

for (CBUAE_BRF7_3_Summary_Entity2 record : dataList) {
    logger.info("Processing record: {}", record.toString());

    for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
        String rowCode = rowCodes[rowIndex];
        Row row = sheet.getRow(baseRow + rowIndex);
        if (row == null) {
            row = sheet.createRow(baseRow + rowIndex);
            logger.info("Created new row at index {}", baseRow + rowIndex);
        }

        int actualColIndex = 4; // Start from column E
        for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
            // Write only first 12 and last 12 columns
            if (colIndex >= 12 && colIndex < 24) {
                continue; // Skip middle 12
            }

            String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
            Cell cell = row.createCell(actualColIndex++);

            try {
                Field field = CBUAE_BRF7_3_Summary_Entity2.class.getDeclaredField(fieldName);
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

//C0250-C0360
private void writeRowData4(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity2> dataList,
    String[] rowCodes, String[] fieldSuffixes, int baseRow,
    CellStyle numberStyle, CellStyle textStyle) {

logger.info("writeRowData3 - Starting with {} records", dataList.size());

if (dataList.isEmpty()) {
    logger.warn("writeRowData3 - dataList is empty!");
    return;
}

for (CBUAE_BRF7_3_Summary_Entity2 record : dataList) {
    logger.info("Processing record: {}", record.toString());

    for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
        String rowCode = rowCodes[rowIndex];
        Row row = sheet.getRow(baseRow + rowIndex);
        if (row == null) {
            row = sheet.createRow(baseRow + rowIndex);
            logger.info("Created new row at index {}", baseRow + rowIndex);
        }

        int actualColIndex = 28; 
        for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
           
            String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
            Cell cell = row.createCell(actualColIndex++);

            try {
                Field field = CBUAE_BRF7_3_Summary_Entity2.class.getDeclaredField(fieldName);
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

//C0010-C0120 Entity changed
private void writeRowData5(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
    String[] rowCodes, String[] fieldSuffixes, int baseRow,
    CellStyle numberStyle, CellStyle textStyle) {

logger.info("writeRowData3 - Starting with {} records", dataList.size());

if (dataList.isEmpty()) {
    logger.warn("writeRowData3 - dataList is empty!");
    return;
}

for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
    logger.info("Processing record: {}", record.toString());

    for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
        String rowCode = rowCodes[rowIndex];
        Row row = sheet.getRow(baseRow + rowIndex);
        if (row == null) {
            row = sheet.createRow(baseRow + rowIndex);
            logger.info("Created new row at index {}", baseRow + rowIndex);
        }

        int actualColIndex = 4; // Start from column E
        for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
            // Write only first 12 and last 12 columns
            if (colIndex >= 12 && colIndex < 24) {
                continue; // Skip middle 12
            }

            String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
            Cell cell = row.createCell(actualColIndex++);

            try {
                Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0250-C0360 Entity changed
private void writeRowData6(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
    String[] rowCodes, String[] fieldSuffixes, int baseRow,
    CellStyle numberStyle, CellStyle textStyle) {

logger.info("writeRowData3 - Starting with {} records", dataList.size());

if (dataList.isEmpty()) {
    logger.warn("writeRowData3 - dataList is empty!");
    return;
}

for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
    logger.info("Processing record: {}", record.toString());

    for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
        String rowCode = rowCodes[rowIndex];
        Row row = sheet.getRow(baseRow + rowIndex);
        if (row == null) {
            row = sheet.createRow(baseRow + rowIndex);
            logger.info("Created new row at index {}", baseRow + rowIndex);
        }

        int actualColIndex = 28; 
        for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
           
            String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
            Cell cell = row.createCell(actualColIndex++);

            try {
                Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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


//C0370-C0400 Entity changed
private void writeRowData7(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
	        String[] rowCodes, String[] fieldSuffixes, int baseRow,
	        CellStyle numberStyle, CellStyle textStyle) {

	    logger.info("writeRowData3 - Starting with {} records", dataList.size());

	    if (dataList.isEmpty()) {
	        logger.warn("writeRowData3 - dataList is empty!");
	        return;
	    }

	    for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
	        logger.info("Processing record: {}", record.toString());

	        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
	            String rowCode = rowCodes[rowIndex];
	            Row row = sheet.getRow(baseRow + rowIndex);
	            if (row == null) {
	                row = sheet.createRow(baseRow + rowIndex);
	                logger.info("Created new row at index {}", baseRow + rowIndex);
	            }

	            int actualColIndex = 40; 
	            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
	               
	                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
	                Cell cell = row.createCell(actualColIndex++);

	                try {
	                    Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0010
private void writeRowData8(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
	        String[] rowCodes, String[] fieldSuffixes, int baseRow,
	        CellStyle numberStyle, CellStyle textStyle) {

	    logger.info("writeRowData3 - Starting with {} records", dataList.size());

	    if (dataList.isEmpty()) {
	        logger.warn("writeRowData3 - dataList is empty!");
	        return;
	    }

	    for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
	        logger.info("Processing record: {}", record.toString());

	        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
	            String rowCode = rowCodes[rowIndex];
	            Row row = sheet.getRow(baseRow + rowIndex);
	            if (row == null) {
	                row = sheet.createRow(baseRow + rowIndex);
	                logger.info("Created new row at index {}", baseRow + rowIndex);
	            }

	            int actualColIndex = 4; // Start from column E
	            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
	               
	                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
	                Cell cell = row.createCell(actualColIndex++);

	                try {
	                    Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0040 - C0080
private void writeRowData9(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
			        String[] rowCodes, String[] fieldSuffixes, int baseRow,
			        CellStyle numberStyle, CellStyle textStyle) {

			    logger.info("writeRowData3 - Starting with {} records", dataList.size());

			    if (dataList.isEmpty()) {
			        logger.warn("writeRowData3 - dataList is empty!");
			        return;
			    }

			    for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
			        logger.info("Processing record: {}", record.toString());

			        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
			            String rowCode = rowCodes[rowIndex];
			            Row row = sheet.getRow(baseRow + rowIndex);
			            if (row == null) {
			                row = sheet.createRow(baseRow + rowIndex);
			                logger.info("Created new row at index {}", baseRow + rowIndex);
			            }

			            int actualColIndex = 7; // Start from column E
			            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
			               
			                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
			                Cell cell = row.createCell(actualColIndex++);

			                try {
			                    Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0250-C0360 Entity changed
private void writeRowData10(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
        String[] rowCodes, String[] fieldSuffixes, int baseRow,
        CellStyle numberStyle, CellStyle textStyle) {

    logger.info("writeRowData3 - Starting with {} records", dataList.size());

    if (dataList.isEmpty()) {
        logger.warn("writeRowData3 - dataList is empty!");
        return;
    }

    for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
        logger.info("Processing record: {}", record.toString());

        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
            String rowCode = rowCodes[rowIndex];
            Row row = sheet.getRow(baseRow + rowIndex);
            if (row == null) {
                row = sheet.createRow(baseRow + rowIndex);
                logger.info("Created new row at index {}", baseRow + rowIndex);
            }

            int actualColIndex = 28; 
            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
               
                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
                Cell cell = row.createCell(actualColIndex++);

                try {
                    Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0130-C0360 Entity changed
private void writeRowData11(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
        String[] rowCodes, String[] fieldSuffixes, int baseRow,
        CellStyle numberStyle, CellStyle textStyle) {

    logger.info("writeRowData3 - Starting with {} records", dataList.size());

    if (dataList.isEmpty()) {
        logger.warn("writeRowData3 - dataList is empty!");
        return;
    }

    for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
        logger.info("Processing record: {}", record.toString());

        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
            String rowCode = rowCodes[rowIndex];
            Row row = sheet.getRow(baseRow + rowIndex);
            if (row == null) {
                row = sheet.createRow(baseRow + rowIndex);
                logger.info("Created new row at index {}", baseRow + rowIndex);
            }

            int actualColIndex = 16; 
            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
               
                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
                Cell cell = row.createCell(actualColIndex++);

                try {
                    Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0410-C0420 Entity changed
private void writeRowData12(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity3> dataList,
        String[] rowCodes, String[] fieldSuffixes, int baseRow,
        CellStyle numberStyle, CellStyle textStyle) {

    logger.info("writeRowData3 - Starting with {} records", dataList.size());

    if (dataList.isEmpty()) {
        logger.warn("writeRowData3 - dataList is empty!");
        return;
    }

    for (CBUAE_BRF7_3_Summary_Entity3 record : dataList) {
        logger.info("Processing record: {}", record.toString());

        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
            String rowCode = rowCodes[rowIndex];
            Row row = sheet.getRow(baseRow + rowIndex);
            if (row == null) {
                row = sheet.createRow(baseRow + rowIndex);
                logger.info("Created new row at index {}", baseRow + rowIndex);
            }

            int actualColIndex = 44; 
            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
               
                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
                Cell cell = row.createCell(actualColIndex++);

                try {
                    Field field = CBUAE_BRF7_3_Summary_Entity3.class.getDeclaredField(fieldName);
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

//C0010-C0120 Entity changed
private void writeRowData13(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity4> dataList,
        String[] rowCodes, String[] fieldSuffixes, int baseRow,
        CellStyle numberStyle, CellStyle textStyle) {

    logger.info("writeRowData3 - Starting with {} records", dataList.size());

    if (dataList.isEmpty()) {
        logger.warn("writeRowData3 - dataList is empty!");
        return;
    }

    for (CBUAE_BRF7_3_Summary_Entity4 record : dataList) {
        logger.info("Processing record: {}", record.toString());

        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
            String rowCode = rowCodes[rowIndex];
            Row row = sheet.getRow(baseRow + rowIndex);
            if (row == null) {
                row = sheet.createRow(baseRow + rowIndex);
                logger.info("Created new row at index {}", baseRow + rowIndex);
            }

            int actualColIndex = 4; // Start from column E
            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
                // Write only first 12 and last 12 columns
                if (colIndex >= 12 && colIndex < 24) {
                    continue; // Skip middle 12
                }

                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
                Cell cell = row.createCell(actualColIndex++);

                try {
                    Field field = CBUAE_BRF7_3_Summary_Entity4.class.getDeclaredField(fieldName);
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

//C0410-C0420 Entity changed
private void writeRowData14(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity4> dataList,
        String[] rowCodes, String[] fieldSuffixes, int baseRow,
        CellStyle numberStyle, CellStyle textStyle) {

    logger.info("writeRowData3 - Starting with {} records", dataList.size());

    if (dataList.isEmpty()) {
        logger.warn("writeRowData3 - dataList is empty!");
        return;
    }

    for (CBUAE_BRF7_3_Summary_Entity4 record : dataList) {
        logger.info("Processing record: {}", record.toString());

        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
            String rowCode = rowCodes[rowIndex];
            Row row = sheet.getRow(baseRow + rowIndex);
            if (row == null) {
                row = sheet.createRow(baseRow + rowIndex);
                logger.info("Created new row at index {}", baseRow + rowIndex);
            }

            int actualColIndex = 44; 
            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
               
                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
                Cell cell = row.createCell(actualColIndex++);

                try {
                    Field field = CBUAE_BRF7_3_Summary_Entity4.class.getDeclaredField(fieldName);
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


private void writeRowData100(Sheet sheet, List<CBUAE_BRF7_3_Summary_Entity4> dataList,
        String[] rowCodes, String[] fieldSuffixes, int baseRow,
        CellStyle numberStyle, CellStyle textStyle) {

    logger.info("writeRowData3 - Starting with {} records", dataList.size());

    if (dataList.isEmpty()) {
        logger.warn("writeRowData3 - dataList is empty!");
        return;
    }

    for (CBUAE_BRF7_3_Summary_Entity4 record : dataList) {
        logger.info("Processing record: {}", record.toString());

        for (int rowIndex = 0; rowIndex < rowCodes.length; rowIndex++) {
            String rowCode = rowCodes[rowIndex];
            Row row = sheet.getRow(baseRow + rowIndex);
            if (row == null) {
                row = sheet.createRow(baseRow + rowIndex);
                logger.info("Created new row at index {}", baseRow + rowIndex);
            }

            int actualColIndex = 44; 
            for (int colIndex = 0; colIndex < fieldSuffixes.length; colIndex++) {
               
                String fieldName = rowCode.toLowerCase() + "_" + fieldSuffixes[colIndex];
                Cell cell = row.createCell(actualColIndex++);

                try {
                    Field field = CBUAE_BRF7_3_Summary_Entity4.class.getDeclaredField(fieldName);
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
}
