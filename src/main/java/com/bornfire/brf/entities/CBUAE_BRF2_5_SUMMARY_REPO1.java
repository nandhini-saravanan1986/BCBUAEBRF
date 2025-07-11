package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF2_5_SUMMARY_REPO1 extends JpaRepository<CBUAE_BRF2_5_SUMMARY_ENTITY1, Date> {

	@Query(value = "select * from CBUAE_BRF2_5_SUMMARYTABLE1  ", nativeQuery = true)
	List<CBUAE_BRF2_5_SUMMARY_ENTITY1> getdatabydateList(Date rpt_code);

}
