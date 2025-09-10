package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF5_19_Summary_Rep3 extends JpaRepository<CBUAE_BRF5_19_Summary_Entity3, Date> {

	@Query(value = "select * from CBUAE_BRF5_19_SUMMARYTABLE3 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF5_19_Summary_Entity3> getdatabydateList(Date report_date);
}
