package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF2_15_Detail_Archival_Repo extends JpaRepository<CBUAE_BRF2_15_Detail_Archival_Entity, String>{

	@Query(value = "select * from CBUAE_BRF2_15_ARCHIVALTABLE_DETAILTABLE where REPORT_DATE=?1 AND DATA_ENTRY_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF2_15_Detail_Archival_Entity> getdatabydateList(Date reportdate,String DATA_ENTRY_VERSION);
	
	@Query(value = "select * from CBUAE_BRF2_15_ARCHIVALTABLE_DETAILTABLE where REPORT_DATE=?1 And DATA_ENTRY_VERSION=?2 offset ?3 rows fetch next ?4 rows only", nativeQuery = true)
	List<CBUAE_BRF2_15_Detail_Archival_Entity> getdatabydateList(Date reportdate, String version,int startpage,int endpage);
	
	@Query(value = "select count(*) from CBUAE_BRF2_15_ARCHIVALTABLE_DETAILTABLE where REPORT_DATE = ?1 and DATA_ENTRY_VERSION = ?2", nativeQuery = true)
	int getdatacount(Date reportdate, String version);
	
	@Query(value = "select * from CBUAE_BRF2_15_ARCHIVALTABLE_DETAILTABLE where ROW_ID =?1 and COLUMN_ID=?2 AND REPORT_DATE=?3 AND DATA_ENTRY_VERSION=?4", nativeQuery = true)
	List<CBUAE_BRF2_15_Detail_Archival_Entity> GetDataByRowIdAndColumnId(String rowId,String ColumnId,Date reportdate,String DATA_ENTRY_VERSION);

}
