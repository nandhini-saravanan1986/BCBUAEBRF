package com.bornfire.brf.services;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import com.bornfire.brf.services.CBUAE_BRF1_1_ReportService;
@Component
@Service
@Transactional
@ConfigurationProperties("output")
public class RegulatoryReportServices {
	
	@Autowired
	CBUAE_BRF1_1_ReportService cbuae_brf1_1_reportservice;
	
	@Autowired
	CBUAE_BRF1_12_ReportService cbuae_brf1_12_reportservice;
	
	
	private static final Logger logger = LoggerFactory.getLogger(RegulatoryReportServices.class);
	
	public ModelAndView getReportView(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype, String subreportid, String secid, String reportingTime, Pageable pageable,
			BigDecimal srl_no, String req) {

		ModelAndView repsummary = new ModelAndView();

		logger.info("Getting View for the Report :" + reportId);
		switch (reportId) {

		case "BRF001":
			repsummary = cbuae_brf1_1_reportservice.getBRF1_1View(reportId, fromdate, todate, currency, dtltype, pageable);
			break;
		case "BRF1_12":
			repsummary = cbuae_brf1_12_reportservice.getBRF1_12View(reportId, fromdate, todate, currency, dtltype, pageable);
			break;
			
		}
		return repsummary;
	}
	
	public ModelAndView getReportDetails(String reportId, String instanceCode, String asondate, String fromdate,
			String todate, String currency, String reportingTime, String dtltype, String subreportid, String secid,
			Pageable pageable, String Filter) {

		ModelAndView repdetail = new ModelAndView();
		logger.info("Getting Details for the Report :" + reportId);

		switch (reportId) {

		case "BRF001":
			repdetail = cbuae_brf1_1_reportservice.getBRF1_1currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;
		
		case "BRF1_12":
			repdetail = cbuae_brf1_12_reportservice.getBRF1_12currentDtl(reportId, fromdate, todate, currency, dtltype,
					pageable, Filter);
			break;
			}
			
	
		return repdetail;
	}
	
	public byte[] getDownloadFile(String reportId,String filename, String asondate, String fromdate, String todate, String currency,
			String subreportid, String secid, String dtltype, String reportingTime, 
			String instancecode, String filter)  {

		byte[] repfile = null;
		
		

		switch (reportId) {
		
			case "BRF001":
				try {
					repfile = cbuae_brf1_1_reportservice.getBRF1_1Excel(filename, reportId, fromdate, todate, currency, dtltype);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
		return repfile;
	}

}
