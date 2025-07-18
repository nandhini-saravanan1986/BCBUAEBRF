package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF5_17_Summary_Archival_Repo extends JpaRepository<CBUAE_BRF5_17_Summary_Archival_Entity, Date> {
	
	@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF5_17_ARCHIVALTABLE_SUMMARY order by REPORT_VERSION", nativeQuery = true)
	List<Object> getBRF5_17archival();
	
	@Query(value = "select * from CBUAE_BRF5_17_ARCHIVALTABLE_SUMMARY where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF5_17_Summary_Archival_Entity> getdatabydateListarchival(Date report_date,String REPORT_VERSION );

}
