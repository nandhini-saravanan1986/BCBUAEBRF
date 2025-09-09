package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF16_1_Archival_Summary_Repo_3
		extends JpaRepository<CBUAE_BRF16_1_Archival_Summary_Entity_3, Date> {

	@Query(value = "select REPORT_DATE,REPORT_VERSION from CBUAE_BRF16_1_ARCHIVALTABLE_SUMMARY_3 order by REPORT_VERSION", nativeQuery = true)
	List<Object> getBRF16_3archival();

	@Query(value = "select * from CBUAE_BRF16_1_ARCHIVALTABLE_SUMMARY_3 where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF16_1_Archival_Summary_Entity_3> getdatabydateListarchival(Date report_date, String REPORT_VERSION);

}