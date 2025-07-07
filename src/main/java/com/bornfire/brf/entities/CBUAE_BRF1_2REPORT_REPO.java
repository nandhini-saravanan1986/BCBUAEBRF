package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_2REPORT_REPO extends JpaRepository<CBUAE_BRF1_2_REPORT_ENTITY1, Date> {

	@Query(value = "select * from CBUAE_BRF1_2_SUMMARYTABLE1  ", nativeQuery = true)
	List<CBUAE_BRF1_2_REPORT_ENTITY1> getdatabydateList(Date rpt_code);
	
	@Query(value = "select * from CBUAE_BRF1_2_SUMMARYTABLE2  ", nativeQuery = true)
	List<CBUAE_BRF1_2_REPORT_ENTITY2> getdatabydateList1(Date rpt_code);
}
