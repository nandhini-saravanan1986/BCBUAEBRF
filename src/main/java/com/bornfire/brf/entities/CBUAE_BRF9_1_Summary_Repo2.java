package com.bornfire.brf.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CBUAE_BRF9_1_Summary_Repo2 extends JpaRepository<CBUAE_BRF9_1_Summary_Entity2, Date> {

	@Query(value = "select * from CBUAE_BRF9_1_SUMMARYTABLE2 where report_date=?1 ", nativeQuery = true)
	List<CBUAE_BRF9_1_Summary_Entity2> getdatabydateList(Date report_date);
    
	@Query(value = "SELECT " +
            "REMAINING_COUNTRIES, " +
            "OUTWARD_FAMILY1, OUTWARD_INVESTMENT1, OUTWARD_TRADE1, OUTWARD_OTHER1, OUTWARD_TOTAL1, " +
            "INWARD_FAMILY1, INWARD_INVESTMENT1, INWARD_TRADE1, INWARD_OTHER1, INWARD_TOTAL1, " +
            "REPORT_DATE " +
            "FROM CBUAE_BRF9_1_SUMMARYTABLE2 " +
            "WHERE REPORT_DATE = ?1", nativeQuery = true)
List<Object[]> getdatabydateList1(Date reportDate);

}
