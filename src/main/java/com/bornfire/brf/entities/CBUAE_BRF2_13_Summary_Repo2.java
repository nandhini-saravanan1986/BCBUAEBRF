package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF2_13_Summary_Repo2 extends JpaRepository<CBUAE_BRF2_13_Summary_Entity2, Date> {

	@Query(value = "select * from CBUAE_BRF2_13_SUMMARYTABLE2 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF2_13_Summary_Entity2> getdatabydateList(Date report_date);
}
