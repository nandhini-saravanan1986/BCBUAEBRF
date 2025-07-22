package com.bornfire.brf.entities;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF2_18_Detail_Repo extends JpaRepository<CBUAE_BRF2_18_Detail_Entity, String> {
	
	
	@Query(value = "select * from CBUAE_BRF2_18_DETAILTABLE  ", nativeQuery = true)
	List<CBUAE_BRF2_18_Detail_Entity> getdatabydateList(Date reportdate);
	
	@Query(value = "select * from CBUAE_BRF2_18_DETAILTABLE where ROW_ID =?1 and COLUMN_ID=?2", nativeQuery = true)
	List<CBUAE_BRF2_18_Detail_Entity> GetDataByRowIdAndColumnId(String rowId,String ColumnId);
	
	
}
