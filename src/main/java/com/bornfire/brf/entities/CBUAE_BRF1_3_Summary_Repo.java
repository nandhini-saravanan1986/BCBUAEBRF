package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_3_Summary_Repo  extends JpaRepository<CBUAE_BRF1_3_Summary_Entity, Date> {

	@Query(value = "select * from CBUAE_BRF1_3_SUMMARYTABLE where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF1_3_Summary_Entity> getdatabydateList(Date reportdate);

}
