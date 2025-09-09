package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF16_1_Archival_Summary_Repo_2
		extends JpaRepository<CBUAE_BRF16_1_Archival_Summary_Entity_2, Date> {

	@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF16_1_ARCHIVALTABLE_SUMMARY_2 order by REPORT_VERSION", nativeQuery = true)
	List<Object> getBRF16_2archival();

	@Query(value = "select * from CBUAE_BRF16_1_ARCHIVALTABLE_SUMMARY_2 where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF16_1_Archival_Summary_Entity_2> getdatabydateListarchival(Date report_date, String REPORT_VERSION);

}