
package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CBUAE_BRF8_6_Summary_Repo extends JpaRepository<CBUAE_BRF8_6_Summary_Entity, Long> { 

	@Query(value = "select * from CBUAE_BRF8_6_SUMMARYTABLE ORDER BY ID", nativeQuery = true)
	List<CBUAE_BRF8_6_Summary_Entity> getdatabydateList();
	
	@Query(value = "select * from CBUAE_BRF8_6_SUMMARYTABLE", nativeQuery = true)
	List<Object[]> getRawData();

	@Query(value = "select * from CBUAE_BRF8_6_SUMMARYTABLE where report_date=?1 And REPORT_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF8_6_Summary_Entity> getdatabydateListarchival(Date report_date,String REPORT_VERSION );
}
