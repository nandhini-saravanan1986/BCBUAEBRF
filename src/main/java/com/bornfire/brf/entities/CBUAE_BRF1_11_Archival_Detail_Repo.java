package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF1_11_Archival_Detail_Repo
		extends JpaRepository<CBUAE_BRF1_11_Archival_Detail_Entity, String> {

	@Query(value = "select * from CBUAE_BRF1_11_ARCHIVALTABLE_DETAIL where REPORT_DATE=?1 AND DATA_ENTRY_VERSION=?2", nativeQuery = true)
	List<CBUAE_BRF1_11_Archival_Detail_Entity> getdatabydateList(Date reportdate, String DATA_ENTRY_VERSION);

	@Query(value = "select * from CBUAE_BRF1_11_ARCHIVALTABLE_DETAIL where ROW_ID =?1 and COLUMN_ID=?2 AND REPORT_DATE=?3 AND DATA_ENTRY_VERSION=?4", nativeQuery = true)
	List<CBUAE_BRF1_11_Archival_Detail_Entity> GetDataByRowIdAndColumnId(String rowId, String ColumnId, Date reportdate,
			String DATA_ENTRY_VERSION);

	@Query(value = "select * from CBUAE_BRF1_11_ARCHIVALTABLE_DETAIL "
			+ "where REPORT_DATE=?1 and DATA_ENTRY_VERSION=?2 "
			+ "offset ?3 rows fetch next ?4 rows only", nativeQuery = true)
	List<CBUAE_BRF1_11_Archival_Detail_Entity> getdatabydateList(Date reportdate, String version, int offset,
			int limit);

	@Query(value = "select count(*) from CBUAE_BRF1_11_ARCHIVALTABLE_DETAIL where REPORT_DATE = ?1 and DATA_ENTRY_VERSION = ?2", nativeQuery = true)
	int getdatacount(Date reportdate, String version);

}