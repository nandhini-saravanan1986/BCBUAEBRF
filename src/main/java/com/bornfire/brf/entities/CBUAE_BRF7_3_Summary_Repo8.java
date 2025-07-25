package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF7_3_Summary_Repo8 extends JpaRepository<CBUAE_BRF7_3_Summary_Entity8, Date> {

	@Query(value = "select * from CBUAE_BRF7_3_SUMMARYTABLE8 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF7_3_Summary_Entity8> getdatabydateList(Date report_date);
}
