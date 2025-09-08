package com.bornfire.brf.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Component
@Service
@Transactional
@ConfigurationProperties("output")

public class RegulatoryReportServices {

	@Autowired
	CBUAE_BRF7_4_ReportService CBUAE_BRF7_4_ReportServices;
	@Autowired
	CBUAE_BRF8_6_ReportService CBUAE_BRF8_6_ReportServices;
	@Autowired
	CBUAE_BRF2_11_ReportService CBUAE_BRF2_11_ReportServices;
	@Autowired
	CBUAE_BRF5_4_ReportService CBUAE_BRF5_4_ReportServices;
	@Autowired
	CBUAE_BRF16_4_ReportService CBUAE_BRF16_4_ReportServices;

	@Autowired
	CBUAE_BRF1_1_ReportService cbuae_brf1_1_reportservice;

	@Autowired
	CBUAE_BRF5_20_ReportService cbuae_brf5_20_reportservice;

	@Autowired
	CBUAE_BRF1_10_ReportService cbuae_brf1_10_reportservice;

	@Autowired
	CBUAE_BRF1_12_ReportService cbuae_brf1_12_reportservice;

	@Autowired
	CBUAE_BRF2_1_ReportService cbuae_brf2_1_reportservice;

	@Autowired
	CBUAE_BRF1_2_ReportService cbuae_brf1_2_reportservice;

	@Autowired
	CBUAE_BRF9_1_ReportService cbuae_brf9_1_reportservice;

	@Autowired
	CBUAE_BRF1_7_ReportService cbuae_brf1_7_reportservice;

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
	CBUAE_BRF2_14_ReportService cbuae_brf2_14_reportservice;

	@Autowired
	CBUAE_BRF2_15_ReportService cbuae_brf2_15_reportservice;

	@Autowired
	CBUAE_BRF5_1_ReportService cbuae_brf5_1_reportservice;

	@Autowired
	CBUAE_BRF5_6_ReportService cbuae_brf5_6_reportservice;

	@Autowired
	CBUAE_BRF5_2_ReportService cbuae_brf5_2_reportservice;

	@Autowired
	CBUAE_BRF5_3_ReportService cbuae_brf5_3_reportservice;

	@Autowired
	CBUAE_BRF16_1_ReportService cbuae_brf16_1_reportservice;

	@Autowired
	CBUAE_BRF16_4_ReportService CBUAE_BRF_16_4_ReportServices;

	@Autowired
	CBUAE_BRF7_3_ReportService cbuae_brf7_3_reportservice;

	@Autowired
	CBUAE_BRF16_5_ReportService CBUAE_BRF16_5_ReportServices;

	@Autowired
	CBUAE_BRF16_2_Reportservice CBUAE_BRF16_2_ReportServices;

	@Autowired
	CBUAE_BRF16_3_ReportServices CBUAE_BRF16_3_ReportServices;

	@Autowired
	CBUAE_BRF5_5_ReportService cbuae_brf5_5_reportservice;

	@Autowired
	CBUAE_BRF1_9_ReportService cbuae_brf1_9_reportservice;

	@Autowired
	CBUAE_BRF1_8_ReportService CBUAE_BRF1_8_ReportService;

	@Autowired
	CBUAE_BRF1_11_ReportService cbuae_brf1_11_reportservice;

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

		case "BRF5_20":
			repsummary = cbuae_brf5_20_reportservice.getBRF5_20View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF5_17":
			repsummary = cbuae_brf5_17_reportservice.getBRF5_17View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF1_10":
			repsummary = cbuae_brf1_10_reportservice.getBRF1_10View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF1_12":
			repsummary = cbuae_brf1_12_reportservice.getBRF1_12View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF7_3":
			repsummary = cbuae_brf7_3_reportservice.getBRF7_3View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF2_1":
			repsummary = cbuae_brf2_1_reportservice.getBRF2_1View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF1_2":
			repsummary = cbuae_brf1_2_reportservice.getBRF1_2View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF1_7":
			repsummary = cbuae_brf1_7_reportservice.getBRF1_7View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF9_1":
			repsummary = cbuae_brf9_1_reportservice.getBRF9_1View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_2":
			repsummary = cbuae_brf2_2_reportservice.getBRF2_2View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_4":
			repsummary = cbuae_brf2_4_reportservice.getBRF2_4View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_5":
			repsummary = cbuae_brf2_5_reportservice.getBRF2_5View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_6":
			repsummary = cbuae_brf2_6_reportservice.getBRF2_6View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_3":
			repsummary = cbuae_brf2_3_reportservice.getBRF2_3View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_7":
			repsummary = cbuae_brf2_7_reportservice.getBRF2_7View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_16":
			repsummary = cbuae_brf2_16_reportservice.getBRF2_16View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_18":
			repsummary = cbuae_brf2_18_reportservice.getBRF2_18View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF1_3":
			repsummary = cbuae_brf1_3_reportservice.getBRF1_3View(reportId, fromdate, todate, currency, dtltype,
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

		case "BRF2_14":
			repsummary = cbuae_brf2_14_reportservice.getBRF2_14View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF2_15":
			repsummary = cbuae_brf2_15_reportservice.getBRF2_15View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF5_1":
			repsummary = cbuae_brf5_1_reportservice.getBRF5_1View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

	

		case "BRF5_5":
			repsummary = cbuae_brf5_5_reportservice.getBRF5_5View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF1_9":
			repsummary = cbuae_brf1_9_reportservice.getBRF1_9View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF1_11":
			repsummary = cbuae_brf1_11_reportservice.getBRF1_11View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF16_5":
			repsummary = CBUAE_BRF16_5_ReportServices.getBRF_16_5View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;
		case "BRF5_4":
			repsummary = CBUAE_BRF5_4_ReportServices.getBRF5_4View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;
		case "BRF2_11":
			repsummary = CBUAE_BRF2_11_ReportServices.getBRF2_11View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;
		case "BRF5_6":
			repsummary = cbuae_brf5_6_reportservice.getBRF5_6View(reportId, fromdate, todate, currency, dtltype,
					pageable);
			break;

		case "BRF16_1":
			repsummary = cbuae_brf16_1_reportservice.getBRF16_1View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;

		case "BRF16_2":
			repsummary = CBUAE_BRF16_2_ReportServices.getBRF_16_2View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
			break;
		case "BRF16_3":
			repsummary = CBUAE_BRF16_3_ReportServices.getBRF_16_3View(reportId, fromdate, todate, currency, dtltype,

					pageable, type, version);
			break;
		case "BRF7_4":
			repsummary = CBUAE_BRF7_4_ReportServices.getBRF7_4View(reportId, fromdate, todate, currency, dtltype,

					pageable, type, version);
			break;

		case "BRF8_6":
			repsummary = CBUAE_BRF8_6_ReportServices.getBRF8_6View(reportId, fromdate, todate, currency, dtltype,

					pageable, type, version);
			break;

		case "BRF1_8":
			repsummary = CBUAE_BRF1_8_ReportService.getBRF1_8View(reportId, fromdate, todate, currency, dtltype,
					pageable, type, version);
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

		case "BRF5_20":
			repdetail = cbuae_brf5_20_reportservice.getBRF5_20currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF9_1":
			repdetail = cbuae_brf9_1_reportservice.getBRF9_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF5_17":
			repdetail = cbuae_brf5_17_reportservice.getBRF5_17currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF1_10":
			repdetail = cbuae_brf1_10_reportservice.getBRF1_10currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF1_11":
			repdetail = cbuae_brf1_11_reportservice.getBRF1_11currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);

		case "BRF2_1":
			repdetail = cbuae_brf2_1_reportservice.getBRF2_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF1_12":
			repdetail = cbuae_brf1_12_reportservice.getBRF1_12currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF7_3":
			repdetail = cbuae_brf7_3_reportservice.getBRF7_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF5_5":
			repdetail = cbuae_brf5_5_reportservice.getBRF5_5currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF1_9":
			repdetail = cbuae_brf1_9_reportservice.getBRF1_9currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF1_2":
			repdetail = cbuae_brf1_2_reportservice.getBRF1_2currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF1_7":
			repdetail = cbuae_brf1_7_reportservice.getBRF1_7currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF1_3":
			repdetail = cbuae_brf1_3_reportservice.getBRF1_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_2":
			repdetail = cbuae_brf2_2_reportservice.getBRF2_2currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_4":
			repdetail = cbuae_brf2_4_reportservice.getBRF2_4currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_5":
			repdetail = cbuae_brf2_5_reportservice.getBRF2_5currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_6":
			repdetail = cbuae_brf2_6_reportservice.getBRF2_6currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_3":
			repdetail = cbuae_brf2_3_reportservice.getBRF2_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_7":
			repdetail = cbuae_brf2_7_reportservice.getBRF2_7currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_16":
			repdetail = cbuae_brf2_16_reportservice.getBRF2_16currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_18":
			repdetail = cbuae_brf2_18_reportservice.getBRF2_18currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_13":
			repdetail = cbuae_brf2_13_reportservice.getBRF2_13currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF2_14":
			repdetail = cbuae_brf2_14_reportservice.getBRF2_14currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF2_15":
			repdetail = cbuae_brf2_15_reportservice.getBRF2_15currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF5_1":
			repdetail = cbuae_brf5_1_reportservice.getBRF5_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF5_2":
			repdetail = cbuae_brf5_2_reportservice.getBRF5_2currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF5_3":
			repdetail = cbuae_brf5_3_reportservice.getBRF5_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF16_4":
			repdetail = CBUAE_BRF16_4_ReportServices.getBRF16_4currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF16_5":
			repdetail = CBUAE_BRF16_5_ReportServices.getBRF16_5currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF5_4":
			repdetail = CBUAE_BRF5_4_ReportServices.getBRF5_4currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;
		case "BRF2_11":
			repdetail = CBUAE_BRF2_11_ReportServices.getBRF2_11currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF16_1":
			repdetail = cbuae_brf16_1_reportservice.getBRF16_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter, type, version);
			break;

		case "BRF16_2":
			repdetail = CBUAE_BRF16_2_ReportServices.getBRF16_2currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;
		case "BRF16_3":
			repdetail = CBUAE_BRF16_3_ReportServices.getBRF16_3currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
		case "BRF5_6":
			repdetail = cbuae_brf5_6_reportservice.getBRF5_6currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF7_4":
			repdetail = CBUAE_BRF7_4_ReportServices.getBRF7_4currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter,type, version);
			break;

		case "BRF8_6":
			repdetail = CBUAE_BRF8_6_ReportServices.getBRF8_6currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;

		case "BRF1_8":
			repdetail = CBUAE_BRF1_8_ReportService.getBRF1_8currentDtl(reportId, fromdate, todate, currency, dtltype,
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

		case "BRF5_20":
			try {
				repfile = cbuae_brf5_20_reportservice.getBRF5_20Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF9_1":
			try {
				repfile = cbuae_brf9_1_reportservice.getBRF9_1Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF7_3":
			try {
				repfile = cbuae_brf7_3_reportservice.getBRF7_3Excel(filename, reportId, fromdate, todate, currency,
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

		case "BRF1_10":
			try {
				repfile = cbuae_brf1_10_reportservice.getBRF1_10Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_11":
			try {
				repfile = cbuae_brf1_11_reportservice.getBRF1_11Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_1":
			try {
				repfile = cbuae_brf2_1_reportservice.getBRF2_1Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_12":
			try {
				repfile = cbuae_brf1_12_reportservice.getBRF1_12Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_2":
			try {
				repfile = cbuae_brf1_2_reportservice.getBRF1_2Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_7":
			try {
				repfile = cbuae_brf1_7_reportservice.getBRF1_7Excel(filename, reportId, fromdate, todate, currency,
						dtltype,type,version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_3":
			try {
				repfile = cbuae_brf2_3_reportservice.getBRF2_3Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_5":
			try {
				repfile = cbuae_brf2_5_reportservice.getBRF2_5Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_2":
			try {
				repfile = cbuae_brf2_2_reportservice.getBRF2_2Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
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
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_4":
			try {
				repfile = cbuae_brf2_4_reportservice.getBRF2_4Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_6":
			try {
				repfile = cbuae_brf2_6_reportservice.getBRF2_6Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_16":
			try {
				repfile = cbuae_brf2_16_reportservice.getBRF2_16Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_18":
			try {
				repfile = cbuae_brf2_18_reportservice.getBRF2_18Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
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

		case "BRF2_14":
			try {
				repfile = cbuae_brf2_14_reportservice.getBRF2_14Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_15":
			try {
				repfile = cbuae_brf2_15_reportservice.getBRF2_15Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_1":
			try {
				repfile = cbuae_brf5_1_reportservice.getBRF5_1Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_2":
			try {
				repfile = cbuae_brf5_2_reportservice.getBRF5_2Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_3":
			try {
				repfile = cbuae_brf5_3_reportservice.getBRF5_3Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_5":
			try {
				repfile = cbuae_brf5_5_reportservice.getBRF5_5Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_9":
			try {
				repfile = cbuae_brf1_9_reportservice.getBRF1_9Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF16_5":
			try {
				repfile = CBUAE_BRF16_5_ReportServices.getBRF16_5Excel(filename, reportId, fromdate, todate, currency,
						dtltype);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF5_4":
			try {
				repfile = CBUAE_BRF5_4_ReportServices.getBRF5_4Excel(filename, reportId, fromdate, todate, currency,
						dtltype);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF2_11":
			try {
				repfile = CBUAE_BRF2_11_ReportServices.getBRF2_11Excel(filename, reportId, fromdate, todate, currency,
						dtltype);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF16_1":
			try {
				repfile = cbuae_brf16_1_reportservice.getBRF16_1Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF16_2":
			try {
				repfile = CBUAE_BRF16_2_ReportServices.getBRF16_2Excel(filename, reportId, fromdate, todate, currency,
						dtltype);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF16_3":
			try {
				repfile = CBUAE_BRF16_3_ReportServices.getBRF16_3Excel(filename, reportId, fromdate, todate, currency,
						dtltype);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF7_4":
			try {
				repfile = CBUAE_BRF7_4_ReportServices.getBRF7_4Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF8_6":
			try {
				repfile = CBUAE_BRF8_6_ReportServices.getBRF8_6Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "BRF1_8":
			try {
				repfile = CBUAE_BRF1_8_ReportService.getBRF1_8Excel(filename, reportId, fromdate, todate, currency,
						dtltype, type, version);
			} catch (Exception e) {
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
			return cbuae_brf1_12_reportservice.getBRF1_12DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF1_1Detail")) {
			return cbuae_brf1_1_reportservice.getBRF1_1DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF5_20Detail")) {
			return cbuae_brf5_20_reportservice.getBRF5_20DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF9_1Detail")) {
			return cbuae_brf9_1_reportservice.getBRF9_1DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF1_10Detail")) {
			return cbuae_brf1_10_reportservice.getBRF1_10DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF1_11Detail")) {
			return cbuae_brf1_11_reportservice.getBRF1_11DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);

		} else if (filename.equals("BRF7_3Detail")) {
			return cbuae_brf7_3_reportservice.getBRF7_3DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF5_5Detail")) {
			return cbuae_brf5_5_reportservice.getBRF5_5DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF1_9Detail")) {
			return cbuae_brf1_9_reportservice.getBRF1_9DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF1_2Detail")) {
			return cbuae_brf1_2_reportservice.getBRF1_2DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF1_7Detail")) {
			return cbuae_brf1_7_reportservice.getBRF1_7DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF1_3Detail")) {
			return cbuae_brf1_3_reportservice.getBRF1_3DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_1Detail")) {
			return cbuae_brf2_1_reportservice.getBRF2_1DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_2Detail")) {
			return cbuae_brf2_2_reportservice.getBRF2_2DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_3Detail")) {
			return cbuae_brf2_3_reportservice.getBRF2_3DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_5Detail")) {
			return cbuae_brf2_5_reportservice.getBRF2_5DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_6Detail")) {
			return cbuae_brf2_6_reportservice.getBRF2_6DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF2_16Detail")) {
			return cbuae_brf2_16_reportservice.getBRF2_16DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_18Detail")) {
			return cbuae_brf2_18_reportservice.getBRF2_18DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_13Detail")) {
			return cbuae_brf2_13_reportservice.getBRF2_13DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_14Detail")) {
			return cbuae_brf2_14_reportservice.getBRF2_14DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_15Detail")) {
			return cbuae_brf2_15_reportservice.getBRF2_15DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF16_4Detail")) {
			return CBUAE_BRF16_4_ReportServices.getBRF16_4DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF5_1Detail")) {
			return cbuae_brf5_1_reportservice.getBRF5_1DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF5_2Detail")) {
			return cbuae_brf5_2_reportservice.getBRF5_2DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF5_3Detail")) {
			return cbuae_brf5_3_reportservice.getBRF5_3DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF5_17Detail")) {
			return cbuae_brf5_17_reportservice.getBRF5_17DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF16_5Detail")) {
			return CBUAE_BRF16_5_ReportServices.getBRF16_5DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF5_4Detail")) {
			return CBUAE_BRF5_4_ReportServices.getBRF5_4DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF2_11Detail")) {
			return CBUAE_BRF2_11_ReportServices.getBRF2_11DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF16_1Detail")) {
			return cbuae_brf16_1_reportservice.getBRF16_1DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF16_2Detail")) {
			return CBUAE_BRF16_2_ReportServices.getBRF16_2DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);

		} else if (filename.equals("BRF16_3Detail")) {
			return CBUAE_BRF16_3_ReportServices.getBRF16_3DetailExcel(filename, fromdate, todate);

		} else if (filename.equals("BRF5_6Detail")) {
			return cbuae_brf5_6_reportservice.getBRF5_6DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF7_4Detail")) {
			return CBUAE_BRF7_4_ReportServices.getBRF7_4DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		}

		else if (filename.equals("BRF8_6Detail")) {
			return CBUAE_BRF8_6_ReportServices.getBRF8_6DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);
		} else if (filename.equals("BRF1_8Detail")) {
			return CBUAE_BRF1_8_ReportService.getBRF1_8DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);

		} else if (filename.equals("BRF1_8Detail")) {
			return cbuae_brf2_4_reportservice.getBRF2_4DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);

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
		case "BRF1_2":
			try {
				archivalData = cbuae_brf1_2_reportservice.getBRF1_2Archival();
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
		case "BRF1_12":
			try {
				archivalData = cbuae_brf1_12_reportservice.getBRF1_12Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF2_1":
			try {
				archivalData = cbuae_brf2_1_reportservice.getBRF2_1Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF2_2":
			try {
				archivalData = cbuae_brf2_2_reportservice.getBRF2_2Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF2_3":
			try {
				archivalData = cbuae_brf2_3_reportservice.getBRF2_3Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF2_5":
			try {
				archivalData = cbuae_brf2_5_reportservice.getBRF2_5Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF2_6":
			try {
				archivalData = cbuae_brf2_6_reportservice.getBRF2_6Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "BRF2_7":
			try {
				archivalData = cbuae_brf2_7_reportservice.getBRF2_7Archival();
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
			
		case "BRF7_4":
			try {
				archivalData = CBUAE_BRF7_4_ReportServices.getBRF7_4Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
			
		case "BRF1_7":
			try {
				archivalData = cbuae_brf1_7_reportservice.getBRF1_7Archival();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
			
			
		}

		return archivalData;
	}

	private final ConcurrentHashMap<String, byte[]> jobStorage = new ConcurrentHashMap<>();

	@Async
	public void generateReportAsync(String jobId, String filename, String fromdate, String todate, String dtltype,
			String type, String currency, String version) {
		// System.out.println("Starting report generation for: " + filename);

		byte[] fileData = null;

		if (filename.equals("BRF1_1Detail")) {
			fileData = cbuae_brf1_1_reportservice.getBRF1_1DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF1_2Detail")) {
			fileData = cbuae_brf1_2_reportservice.getBRF1_2DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF2_4Detail")) {
			fileData = cbuae_brf2_4_reportservice.getBRF2_4DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);

		} else if (filename.equals("BRF2_15Detail")) {
			fileData = cbuae_brf2_15_reportservice.getBRF2_15DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_5Detail")) {
			fileData = cbuae_brf2_5_reportservice.getBRF2_5DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF1_3Detail")) {
			fileData = cbuae_brf1_3_reportservice.getBRF1_3DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF1_9Detail")) {
			fileData = cbuae_brf1_9_reportservice.getBRF1_9DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_14Detail")) {
			fileData = cbuae_brf2_14_reportservice.getBRF2_14DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_1Detail")) {
			fileData = cbuae_brf2_1_reportservice.getBRF2_1DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF1_12Detail")) {
			fileData = cbuae_brf1_12_reportservice.getBRF1_12DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_2Detail")) {
			fileData = cbuae_brf2_2_reportservice.getBRF2_2DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_3Detail")) {
			fileData = cbuae_brf2_3_reportservice.getBRF2_3DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);

		} else if (filename.equals("BRF5_17Detail")) {
			fileData = cbuae_brf5_17_reportservice.getBRF5_17DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_13Detail")) {
			fileData = cbuae_brf2_13_reportservice.getBRF2_13DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF2_6Detail")) {
			fileData = cbuae_brf2_6_reportservice.getBRF2_6DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF2_7Detail")) {
			fileData = cbuae_brf2_7_reportservice.getBRF2_7DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_14Detail")) {
			fileData = cbuae_brf2_14_reportservice.getBRF2_14DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_11Detail")) {
			fileData = CBUAE_BRF2_11_ReportServices.getBRF2_11DetailExcel(filename, fromdate, todate);

		} else if (filename.equals("BRF7_3Detail")) {
			fileData = cbuae_brf7_3_reportservice.getBRF7_3DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF2_11Detail")) {
			fileData = CBUAE_BRF2_11_ReportServices.getBRF2_11DetailExcel(filename, fromdate, todate);

		} else if (filename.equals("BRF7_3Detail")) {
			fileData = cbuae_brf7_3_reportservice.getBRF7_3DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_16Detail")) {
			fileData = cbuae_brf2_16_reportservice.getBRF2_16DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF2_18Detail")) {
			fileData = cbuae_brf2_18_reportservice.getBRF2_18DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		else if (filename.equals("BRF7_3Detail")) {
			fileData = cbuae_brf7_3_reportservice.getBRF7_3DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF5_4Detail")) {
			fileData = CBUAE_BRF5_4_ReportServices.getBRF5_4DetailExcel(filename, fromdate, todate);
		} else if (filename.equals("BRF5_5Detail")) {
			fileData = cbuae_brf5_5_reportservice.getBRF5_5DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF5_6Detail")) {
			fileData = cbuae_brf5_6_reportservice.getBRF5_6DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		} else if (filename.equals("BRF16_4Detail")) {
			fileData = CBUAE_BRF16_4_ReportServices.getBRF16_4DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);

		} else if (filename.equals("BRF16_5Detail")) {
			fileData = CBUAE_BRF16_5_ReportServices.getBRF16_5DetailExcel(filename, fromdate, todate);
		
		}

		else if (filename.equals("BRF1_8Detail")) {
			fileData = CBUAE_BRF1_8_ReportService.getBRF1_8DetailExcel(filename, fromdate, todate, currency, dtltype, type,
					version);

		}
		else if (filename.equals("BRF9_1Detail")) {
			fileData = cbuae_brf9_1_reportservice.getBRF9_1DetailExcel(filename, fromdate, todate, currency, dtltype,
					type, version);
		}

		
		 else if (filename.equals("BRF9_1Detail")) {
			 fileData = cbuae_brf9_1_reportservice.getBRF9_1DetailExcel(filename, fromdate, todate, currency, dtltype, type,
						version);
		} 
		 else if (filename.equals("BRF1_7Detail")) {
			 fileData =  cbuae_brf1_7_reportservice.getBRF1_7DetailExcel(filename, fromdate, todate, currency, dtltype, type,
						version);
			}
		
		 else if (filename.equals("BRF7_4Detail")) {
			 fileData =  CBUAE_BRF7_4_ReportServices.getBRF7_4DetailExcel(filename, fromdate, todate, currency, dtltype, type,
						version);
			}
		
		 else if (filename.equals("BRF1_8Detail")) {
			 fileData = CBUAE_BRF1_8_ReportService.getBRF1_8DetailExcel(filename, fromdate, todate, currency, dtltype, type,
						version);

			}


		



		if (fileData == null) {
			logger.warn("Excel generation failed or no data for jobId: {}", jobId);
			jobStorage.put(jobId, "Nodata".getBytes());
		} else {
			jobStorage.put(jobId, fileData);
		}

		System.out.println("Report generation completed for: " + filename);
	}

	public byte[] getReport(String jobId) {
		// System.out.println("Report generation completed for: " + jobId);
		return jobStorage.get(jobId);
	}

}
