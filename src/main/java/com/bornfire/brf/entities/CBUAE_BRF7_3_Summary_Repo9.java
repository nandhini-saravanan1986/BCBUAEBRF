package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF7_3_Summary_Repo9 extends JpaRepository<CBUAE_BRF7_3_Summary_Entity9, Date> {

	@Query(value = "select * from CBUAE_BRF7_3_SUMMARYTABLE9 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF7_3_Summary_Entity9> getdatabydateList(Date report_date);
}
