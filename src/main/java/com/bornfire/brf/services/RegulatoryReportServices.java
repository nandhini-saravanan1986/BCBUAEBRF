package com.bornfire.brf.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Component
@Service
@Transactional
@ConfigurationProperties("output")

public class RegulatoryReportServices {
	@Autowired
	CBUAE_BRF16_4_ReportService CBUAE_BRF16_4_ReportServices;
	@Autowired
	CBUAE_BRF2_11_ReportService cbuae_brf2_11_ReportService;

	@Autowired
	CBUAE_BRF1_1_ReportService cbuae_brf1_1_reportservice;

	@Autowired
	CBUAE_BRF1_12_ReportService cbuae_brf1_12_reportservice;

	@Autowired
	CBUAE_BRF2_1_ReportService cbuae_brf2_1_reportservice;

	@Autowired
	CBUAE_BRF1_2_ReportService cbuae_brf1_2_reportservice;

	@Autowired
	CBUAE_BRF2_2_ReportService cbuae_brf2_2_reportservice;

	@Autowired
	CBUAE_BRF2_4_ReportService cbuae_brf2_4_reportservice;

	@Autowired
	CBUAE_BRF2_5_ReportService cbuae_brf2_5_reportservice;

	@Autowired
	CBUAE_BRF2_6_ReportService cbuae_brf2_6_reportservice;

	@Autowired
	CBUAE_BRF2_3_ReportService cbuae_brf2_3_reportservice;

	@Autowired
	CBUAE_BRF2_7_ReportService cbuae_brf2_7_reportservice;

	@Autowired
	CBUAE_BRF2_16_ReportService cbuae_brf2_16_reportservice;

	@Autowired
	CBUAE_BRF2_18_ReportService cbuae_brf2_18_reportservice;

	@Autowired
	CBUAE_BRF1_3_ReportService cbuae_brf1_3_reportservice;

	@Autowired
	CBUAE_BRF5_17_ReportService cbuae_brf5_17_reportservice;

	@Autowired
	CBUAE_BRF2_13_ReportService cbuae_brf2_13_reportservice;

	@Autowired
	CBUAE_BRF2_15_ReportService cbuae_brf2_15_reportservice;

	@Autowired
	CBUAE_BRF16_4_ReportService CBUAE_BRF_16_4_ReportServices;

	private static final Logger logger = LoggerFactory.getLogger(RegulatoryReportServices.class);

	public ModelAndView getReportView(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype, String subreportid, String secid, String reportingTime, Pageable pageable,
			BigDecimal srl_no, String req, String type, String version) {

		ModelAndView repsummary = new ModelAndView();

		logger.info("Getting View for the Report :" + reportId);
		switch (reportId) {

		case "BRF1_1":
			repsummary = cbuae_brf1_1_reportservice.getBRF1_1View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF5_17":
			repsummary = cbuae_brf5_17_reportservice.getBRF5_17View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF1_12":
			repsummary = cbuae_brf1_12_reportservice.getBRF1_12View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_1":
			repsummary = cbuae_brf2_1_reportservice.getBRF2_1View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF1_2":
			repsummary = cbuae_brf1_2_reportservice.getBRF1_2View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_2":
			repsummary = cbuae_brf2_2_reportservice.getBRF2_2View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_4":
			repsummary = cbuae_brf2_4_reportservice.getBRF2_4View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_5":
			repsummary = cbuae_brf2_5_reportservice.getBRF2_5View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_6":
			repsummary = cbuae_brf2_6_reportservice.getBRF2_6View(reportId, fromdate, todate, currency, dtltype,
					pageable);

		case "BRF2_3":
			repsummary = cbuae_brf2_3_reportservice.getBRF2_3View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_7":
			repsummary = cbuae_brf2_7_reportservice.getBRF2_7View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_16":
			repsummary = cbuae_brf2_16_reportservice.getBRF2_16View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_18":
			repsummary = cbuae_brf2_18_reportservice.getBRF2_18View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF1_3":
			repsummary = cbuae_brf1_3_reportservice.getBRF1_3View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_11":
			repsummary = cbuae_brf2_11_ReportService.getBRF2_11View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF16_4":
			repsummary = CBUAE_BRF_16_4_ReportServices.getBRF_16_4View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_13":
			repsummary = cbuae_brf2_13_reportservice.getBRF2_13View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_15":
			repsummary = cbuae_brf2_15_reportservice.getBRF2_15View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		}
		return repsummary;
	}

	public ModelAndView getReportDetails(String reportId, String instanceCode, String asondate, String fromdate,
			String todate, String currency, String reportingTime, String dtltype, String subreportid, String secid,
			Pageable pageable, String Filter, String type, String version) {

		ModelAndView repdetail = new ModelAndView();
		logger.info("Getting Details for the Report :" + reportId);

		switch (reportId) {

		case "BRF1_1":
			repdetail = cbuae_brf1_1_reportservice.getBRF1_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF5_17":
			repdetail = cbuae_brf5_17_reportservice.getBRF5_17currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_1":
			repdetail = cbuae_brf2_1_reportservice.getBRF2_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF1_12":
			repdetail = cbuae_brf1_12_reportservice.getBRF1_12currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF1_2":
			repdetail = cbuae_brf1_2_reportservice.getBRF1_2currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF1_3":
			repdetail = cbuae_brf1_3_reportservice.getBRF1_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_2":
			repdetail = cbuae_brf2_2_reportservice.getBRF2_2currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_4":
			repdetail = cbuae_brf2_4_reportservice.getBRF2_4currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_5":
			repdetail = cbuae_brf2_5_reportservice.getBRF2_5currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_6":
			repdetail = cbuae_brf2_6_reportservice.getBRF2_6currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_3":
			repdetail = cbuae_brf2_3_reportservice.getBRF2_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_7":
			repdetail = cbuae_brf2_7_reportservice.getBRF2_7currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_16":
			repdetail = cbuae_brf2_16_reportservice.getBRF2_16currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_18":
			repdetail = cbuae_brf2_18_reportservice.getBRF2_18currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_13":
			repdetail = cbuae_brf2_13_reportservice.getBRF2_13currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_15":
			repdetail = cbuae_brf2_15_reportservice.getBRF2_15currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF16_4":
			repdetail = CBUAE_BRF16_4_ReportServices.getBRF16_4currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		}

		return repdetail;
	}

	public byte[] getDownloadFile(String reportId, String filename, String asondate, String fromdate, String todate,
			String currency, String subreportid, String secid, String dtltype, String reportingTime,
			String instancecode, String filter, String type, String version) {

		byte[] repfile = null;

		switch (reportId) {

		case "BRF1_1":
			try {
				repfile = cbuae_brf1_1_reportservice.getBRF1_1Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_17":
			try {
				repfile = cbuae_brf5_17_reportservice.getBRF5_17Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_1":
			try {
				repfile = cbuae_brf2_1_reportservice.getBRF2_1Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_12":
			try {
				repfile = cbuae_brf1_12_reportservice.getBRF1_12Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_2":
			try {
				repfile = cbuae_brf1_2_reportservice.getBRF1_2Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_3":
			try {
				repfile = cbuae_brf2_3_reportservice.getBRF2_3Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_5":
			try {
				repfile = cbuae_brf2_5_reportservice.getBRF2_5Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_2":
			try {
				repfile = cbuae_brf2_2_reportservice.getBRF2_2Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_3":
			try {
				repfile = cbuae_brf1_3_reportservice.getBRF1_3Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_7":
			try {
				repfile = cbuae_brf2_7_reportservice.getBRF2_7Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_4":
			try {
				repfile = cbuae_brf2_4_reportservice.getBRF2_4Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_6":
			try {
				repfile = cbuae_brf2_6_reportservice.getBRF2_6Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_16":
			try {
				repfile = cbuae_brf2_16_reportservice.getBRF2_16Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_18":
			try {
				repfile = cbuae_brf2_18_reportservice.getBRF2_18Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF16_4":
			try {
				repfile = CBUAE_BRF16_4_ReportServices.getBRF16_4Excel(filename, reportId, fromdate, todate, currency,
						dtltype);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_13":
			try {
				repfile = cbuae_brf2_13_reportservice.getBRF2_13Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_15":
			try {
				repfile = cbuae_brf2_15_reportservice.getBRF2_15Excel(filename, reportId, fromdate, todate, currency,
						dtltype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}

		return repfile;
	}

	public byte[] getDownloadDetailFile(String filename, String fromdate, String todate, String currency,
			String dtltype, String type, String version) {

		System.out.println("came to common service");
		if ("BRF1_12Detail".equals(filename)) {
			return cbuae_brf1_12_reportservice.getBRF1_12DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF1_1Detail")) {
			return cbuae_brf1_1_reportservice.getBRF1_1DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF5_17Detail")) {
			return cbuae_brf5_17_reportservice.getBRF5_17DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF1_2Detail")) {
			return cbuae_brf1_2_reportservice.getBRF1_2DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF1_3Detail")) {
			return cbuae_brf1_3_reportservice.getBRF1_3DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_3Detail")) {
			return cbuae_brf2_3_reportservice.getBRF2_3DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_5Detail")) {
			return cbuae_brf2_5_reportservice.getBRF2_5DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_6Detail")) {
			return cbuae_brf2_6_reportservice.getBRF2_6DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_16Detail")) {
			return cbuae_brf2_16_reportservice.getBRF2_16DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_18Detail")) {
			return cbuae_brf2_18_reportservice.getBRF2_18DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_13Detail")) {
			return cbuae_brf2_13_reportservice.getBRF2_13DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_15Detail")) {
			return cbuae_brf2_15_reportservice.getBRF2_15DetailExcel(filename, fromdate, todate);
		}
		return new byte[0];
	}

	public List<Object> getArchival(String rptcode) {

		List<Object> archivalData = new ArrayList<>();
		switch (rptcode) {
		case "BRF1_1":
			try {
				archivalData = cbuae_brf1_1_reportservice.getBRF1_1Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_17":
			try {
				archivalData = cbuae_brf5_17_reportservice.getBRF5_17Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF1_3":
			try {
				archivalData = cbuae_brf1_3_reportservice.getBRF1_3Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}

		return archivalData;
	}

}
