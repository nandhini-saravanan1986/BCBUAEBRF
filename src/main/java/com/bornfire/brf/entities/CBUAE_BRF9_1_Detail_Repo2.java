package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF9_1_Detail_Repo2 extends JpaRepository<CBUAE_BRF9_1_Detail_Entity2, String> {

	@Query(value = "select * from CBUAE_BRF9_1_DETAILTABLE2 where REPORT_DATE=?1", nativeQuery = true)
	List<CBUAE_BRF9_1_Detail_Entity2> getdatabydateList(Date reportdate);
	
	@Query(value = "select * from CBUAE_BRF9_1_DETAILTABLE2 where ROW_ID =?1 and COLUMN_ID=?2 AND REPORT_DATE=?3", nativeQuery = true)
	List<CBUAE_BRF9_1_Detail_Entity2> GetDataByRowIdAndColumnId(String rowId,String ColumnId,Date reportdate);
}
