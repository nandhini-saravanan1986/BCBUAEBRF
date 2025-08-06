package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF5_5_Summary_Repo6  extends JpaRepository<CBUAE_BRF5_5_Summary_Entity6, Date> {


	@Query(value = "select * from CBUAE_BRF5_5_SUMMARYTABLE6 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF5_5_Summary_Entity6> getdatabydateList(Date report_date);
}

