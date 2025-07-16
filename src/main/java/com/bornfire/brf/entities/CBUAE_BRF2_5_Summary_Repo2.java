package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF2_5_Summary_Repo2 extends JpaRepository<CBUAE_BRF2_5_Summary_Entity2, Date> {

	@Query(value = "select * from CBUAE_BRF2_5_SUMMARYTABLE2  ", nativeQuery = true)
	List<CBUAE_BRF2_5_Summary_Entity2> getdatabydateList(Date rpt_code);

}
