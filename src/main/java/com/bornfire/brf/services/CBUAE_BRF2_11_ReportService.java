package com.bornfire.brf.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.brf.entities.CBUAE_BRF1_1_Summary_Archival_Entity;
import com.bornfire.brf.entities.CBUAE_BRF1_1_Summary_Entity;

@Component
@Service
public class CBUAE_BRF2_11_ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBUAE_BRF1_1_ReportService.class);
	

	@Autowired
	SessionFactory sessionFactory;

	SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
	public ModelAndView getBRF2_11View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String type,String version) {
		System.out.println("getBRF1_1View");
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		
		if(type.equals("ARCHIVAL")&version!=null) {
			List<CBUAE_BRF1_1_Summary_Archival_Entity> T1Master = new ArrayList<CBUAE_BRF1_1_Summary_Archival_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				 //T1Master=BRF1_1_Summary_Archival_Repo.getdatabydateListarchival(dateformat.parse(todate),version);
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
		}
		else {
			List<CBUAE_BRF1_1_Summary_Entity> T1Master = new ArrayList<CBUAE_BRF1_1_Summary_Entity>();
			try {
				Date d1 = dateformat.parse(todate);

				
				 //T1Master=BRF1_1REPORT_Repo.getdatabydateList(dateformat.parse(todate));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			mv.addObject("reportsummary", T1Master);
		}
		

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("BRF/BRF2_11");
		
		
		//mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		//mv.addObject("reportsflag", "reportsflag");
		//mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
}
