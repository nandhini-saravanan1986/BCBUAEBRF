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

import com.bornfire.brf.entities.CBUAE_BRF2_3_DETAIL_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF2_3_DETAIL_REPO;
import com.bornfire.brf.entities.CBUAE_BRF2_3_REPORT_ENTITY;
import com.bornfire.brf.entities.CBUAE_BRF2_3_REPORT_REPO;


@Component
@Service

public class CBUAE_BRF2_3_ReportService {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CBUAE_BRF2_3_DETAIL_REPO BRF2_3_DETAIL_REPO;
	
	@Autowired
	CBUAE_BRF2_3_REPORT_REPO BRF2_3_REPORT_REPO;
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	
	public ModelAndView getBRF2_3View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;	

		List<CBUAE_BRF2_3_REPORT_ENTITY> T1Master = new ArrayList<CBUAE_BRF2_3_REPORT_ENTITY>();
		try {
			Date d1 = dateformat.parse(todate);
			
			 T1Master=BRF2_3_REPORT_REPO.getdatabydateList(dateformat.parse(todate));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("BRF/BRF2_3");
		mv.addObject("reportsummary", T1Master);
	    mv.addObject("displaymode", "summary");
	
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public ModelAndView getBRF2_3currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<CBUAE_BRF2_3_DETAIL_ENTITY> T1Dt1 = new ArrayList<CBUAE_BRF2_3_DETAIL_ENTITY>();
		
		try {
			Date d1 = dateformat.parse(todate);
			
			T1Dt1=BRF2_3_DETAIL_REPO.getdatabydateList(dateformat.parse(todate));
			System.out.println("LISTCOUNT"+T1Dt1.size());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		mv.setViewName("BRF/BRF2_3");
		mv.addObject("displaymode", "Details");
		mv.addObject("reportdetails",T1Dt1 );
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
