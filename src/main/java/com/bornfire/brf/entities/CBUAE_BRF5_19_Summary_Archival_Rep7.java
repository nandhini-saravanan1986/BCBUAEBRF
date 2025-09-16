package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF5_19_Summary_Archival_Rep7 extends JpaRepository<CBUAE_BRF5_19_Summary_Archival_Entity7, Date> {

	@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF5_19_ARCHIVALTABLE_SUMMARYTABLE7 order by REPORT_VERSION", nativeQuery = true)
	List<Object> getbrfarchival();
	
	@Query(value = "select * from CBUAE_BRF5_19_ARCHIVALTABLE_SUMMARYTABLE7 where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF5_19_Summary_Archival_Entity7> getdatabydateListarchival(Date report_date,String REPORT_VERSION );

}
