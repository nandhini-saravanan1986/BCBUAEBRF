package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_12SummaryRepo extends JpaRepository<CBUAE_BRF1_12SummaryEntitiy, Date> {

	@Query(value = "select * from CBUAE_BRF1_12_SUMMARYTABLE  ", nativeQuery = true)
	List<CBUAE_BRF1_12SummaryEntitiy> getdatabydateList(Date rpt_code);
}
