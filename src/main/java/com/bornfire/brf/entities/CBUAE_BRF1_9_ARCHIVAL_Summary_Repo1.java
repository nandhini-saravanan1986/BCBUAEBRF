package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

	public interface CBUAE_BRF1_9_ARCHIVAL_Summary_Repo1 extends JpaRepository<CBUAE_BRF1_9_ARCHIVAL_Summary_Entity1, Date> {

		@Query(value = "select * from CBUAE_BRF1_9_ARCHIVALTABLE_SUMMARY_1 where report_date=?1 ", nativeQuery = true)
		List<CBUAE_BRF1_9_ARCHIVAL_Summary_Entity1> getdatabydateList(Date report_date);
		
		
		@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF1_9_ARCHIVALTABLE_SUMMARY_1 order by REPORT_VERSION", nativeQuery = true)
		List<Object> getbrf1_9archival();

		@Query(value = "select * from CBUAE_BRF1_9_ARCHIVALTABLE_SUMMARY_1 where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
		List<CBUAE_BRF1_9_ARCHIVAL_Summary_Entity1> getdatabydateListarchival(Date report_date, String REPORT_VERSION);

	}
