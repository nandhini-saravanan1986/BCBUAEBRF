package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_2_SUMMARY_REPO2 extends JpaRepository<CBUAE_BRF1_2_SUMMARY_ENTITY2, Date> {

	@Query(value = "select * from CBUAE_BRF1_2_SUMMARYTABLE2 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF1_2_SUMMARY_ENTITY2> getdatabydateList(Date report_date);
}