package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_7_Summary_Archival_Repo1 extends JpaRepository<CBUAE_BRF1_7_Summary_Archival_Entity1, Date> {
	
	@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF1_7_ARCHIVALTABLE_SUMMARY order by REPORT_VERSION", nativeQuery = true)
	List<Object> getBRF1_7archival();
	
	@Query(value = "select * from CBUAE_BRF1_7_ARCHIVALTABLE_SUMMARY1 where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF1_7_Summary_Archival_Entity1> getdatabydateListarchival(Date report_date,String REPORT_VERSION );

}
