package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF7_3_Summary_Repo4 extends JpaRepository<CBUAE_BRF7_3_Summary_Entity4, Date> {


	@Query(value = "select * from CBUAE_BRF7_3_SUMMARYTABLE4 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF7_3_Summary_Entity4> getdatabydateList(Date report_date);
}
