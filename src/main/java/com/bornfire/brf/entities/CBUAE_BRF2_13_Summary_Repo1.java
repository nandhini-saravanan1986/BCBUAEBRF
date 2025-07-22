package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF2_13_Summary_Repo1 extends JpaRepository<CBUAE_BRF2_13_Summary_Entity1, Date> {

	@Query(value = "select * from CBUAE_BRF2_13_SUMMARYTABLE1 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF2_13_Summary_Entity1> getdatabydateList(Date report_date);
}
