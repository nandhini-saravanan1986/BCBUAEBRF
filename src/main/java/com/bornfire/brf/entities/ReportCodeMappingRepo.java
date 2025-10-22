package com.bornfire.brf.entities; // You might have a 'repo' package

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCodeMappingRepo extends JpaRepository<BaseMappingParameter, String> {

	@Query("SELECT DISTINCT r.rptCode FROM RRReport r WHERE r.delFlg != 'Y' ORDER BY r.rptCode")
	List<String> findAllDistinctReportCodes();

	@Query("SELECT r.rptDescription FROM RRReport r WHERE r.rptCode = ?1 AND r.delFlg != 'Y'")
	Optional<String> findReportDescriptionByRptCode(String rptCode);
}