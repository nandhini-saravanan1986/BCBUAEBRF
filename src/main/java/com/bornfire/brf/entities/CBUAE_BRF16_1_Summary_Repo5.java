package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF16_1_Summary_Repo5 extends JpaRepository<CBUAE_BRF16_1_Summary_Entity5, Date> {
	
	@Query(value = "select * from CBUAE_BRF16_1_SUMMARYTABLE5 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF16_1_Summary_Entity5> getdatabydateList(Date report_date);

}
