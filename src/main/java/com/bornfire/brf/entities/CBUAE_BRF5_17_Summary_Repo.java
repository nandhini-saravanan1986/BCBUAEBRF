package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF5_17_Summary_Repo extends JpaRepository<CBUAE_BRF5_17_Summary_Entity, Date> {

	@Query(value = "select * from CBUAE_BRF5_17_SUMMARYTABLE  ", nativeQuery = true)
	List<CBUAE_BRF5_17_Summary_Entity> getdatabydateList(Date rpt_code);

}