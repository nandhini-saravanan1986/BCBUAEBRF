package com.bornfire.brf.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF1_2REPORT_REPO;
import com.bornfire.brf.entities.CBUAE_BRF1_2_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF1_2_DETAIL_REPO;
import com.bornfire.brf.entities.CBUAE_BRF1_2_REPORT_ENTITY1;
import com.bornfire.brf.entities.CBUAE_BRF1_2_REPORT_ENTITY2;



@Component
@Service

public class CBUAE_BRF1_2_ReportService {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF1_2_DETAIL_REPO CBUAE_BRF1_2_DETAIL_REPO;
	
	@Autowired
	CBUAE_BRF1_2REPORT_REPO CBUAE_BRF1_2_REPORT_REPO;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF1_2View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF1_2_REPORT_ENTITY1> T1Master = new ArrayList<CBUAE_BRF1_2_REPORT_ENTITY1>();
		List<CBUAE_BRF1_2_REPORT_ENTITY2> T1Master1 = new ArrayList<CBUAE_BRF1_2_REPORT_ENTITY2>();
		try {
			Date d1 = dateformat.parse(todate);
			
			 T1Master=CBUAE_BRF1_2_REPORT_REPO.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		mv.setViewName("BRF/BRF1_2");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("displaymode", "summary");
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF1_2currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF1_2_DETAIL_ENTITY> T1Dt1 = new ArrayList<CBUAE_BRF1_2_DETAIL_ENTITY>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=CBUAE_BRF1_2_DETAIL_REPO.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		
		mv.setViewName("BRF/BRF1_2");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportdetails",T1Dt1 );
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
