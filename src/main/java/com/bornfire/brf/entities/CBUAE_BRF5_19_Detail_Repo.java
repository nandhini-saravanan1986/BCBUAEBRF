package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF5_19_Detail_Repo extends JpaRepository<CBUAE_BRF5_19_Detail_Entity, String> {

	@Query(value = "select * from CBUAE_BRF5_19_DETAILTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<CBUAE_BRF5_19_Detail_Entity> getdatabydateList(Date reportdate);
	
	@Query(value = "select * from CBUAE_BRF5_19_DETAILTABLE where ROW_ID =?1 and COLUMN_ID=?2 AND REPORT_DATE=?3", nativeQuery = true)
	List<CBUAE_BRF5_19_Detail_Entity> GetDataByRowIdAndColumnId(String rowId,String ColumnId,Date reportdate);
}