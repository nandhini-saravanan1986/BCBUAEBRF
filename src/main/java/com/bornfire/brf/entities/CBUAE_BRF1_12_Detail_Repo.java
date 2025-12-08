package com.bornfire.brf.entities;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CBUAE_BRF1_12_Detail_Repo extends JpaRepository<CBUAE_BRF1_12_Detail_Entity, String> {

	
	@Query(value = "select * from CBUAE_BRF1_12_DETAILTABLE where REPORT_DATE=?1", nativeQuery = true)
	List<CBUAE_BRF1_12_Detail_Entity> getListbydate(Date reportdate);
	

	@Query(value = "select * from CBUAE_BRF1_12_DETAILTABLE where REPORT_DATE=?1 offset ?2 rows fetch next ?3 rows only", nativeQuery = true)
	List<CBUAE_BRF1_12_Detail_Entity> getdatabydateList(Date reportdate,int startpage,int endpage);
	
	@Query(value = "select count(*) from CBUAE_BRF1_12_DETAILTABLE where REPORT_DATE=?1", nativeQuery = true)
	int getdatacount(Date reportdate);
	
	@Query(value = "select * from CBUAE_BRF1_12_DETAILTABLE where ROW_ID =?1 and COLUMN_ID=?2", nativeQuery = true)
	List<CBUAE_BRF1_12_Detail_Entity> GetDataByRowIdAndColumnId(String rowId,String ColumnId);


	CBUAE_BRF1_12_Detail_Entity findByAcctNumber(String acctNo);
 
}
