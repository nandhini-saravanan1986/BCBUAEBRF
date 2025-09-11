package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_11_Archival_Summary_Repo_1
		extends JpaRepository<CBUAE_BRF1_11_Archival_Summary_Entity_1, Date> {

	@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF1_11_ARCHIVALTABLE_SUMMARY_1 order by REPORT_VERSION", nativeQuery = true)
	List<Object> getbrf1_11archival();

	@Query(value = "select * from CBUAE_BRF1_11_ARCHIVALTABLE_SUMMARY_1 where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF1_11_Archival_Summary_Entity_1> getdatabydateListarchival(Date report_date, String REPORT_VERSION);

}