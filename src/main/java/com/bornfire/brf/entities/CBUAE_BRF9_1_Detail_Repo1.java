package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF9_1_Detail_Repo1 extends JpaRepository<CBUAE_BRF9_1_Detail_Entity1, String> {

	@Query(value = "select * from CBUAE_BRF9_1_DETAILTABLE1 where REPORT_DATE=?1", nativeQuery = true)
	List<CBUAE_BRF9_1_Detail_Entity1> getdatabydateList(Date reportdate);
	
	@Query(value = "select * from CBUAE_BRF9_1_DETAILTABLE1 where REPORT_DATE=?1 offset ?2 rows fetch next ?3 rows only", nativeQuery = true)
	List<CBUAE_BRF9_1_Detail_Entity1> getdatabydateList(Date reportdate,int startpage,int endpage);
	
	@Query(value = "select count(*) from CBUAE_BRF9_1_DETAILTABLE1 where REPORT_DATE=?1", nativeQuery = true)
	int getdatacount(Date reportdate);
	
	@Query(value = "select * from CBUAE_BRF9_1_DETAILTABLE1 where ROW_ID =?1 and COLUMN_ID=?2 AND REPORT_DATE=?3", nativeQuery = true)
	List<CBUAE_BRF9_1_Detail_Entity1> GetDataByRowIdAndColumnId(String rowId,String ColumnId,Date reportdate);
}

