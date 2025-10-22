package com.bornfire.brf.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RRReportRepository extends JpaRepository<RRReport, Integer> {
	@Query("SELECT DISTINCT r.rptCode FROM RRReport r WHERE r.delFlg != 'Y' ORDER BY r.rptCode ASC")
	List<String> findAllDistinctReportCodes();

	@Query("SELECT r.rptDescription FROM RRReport r WHERE r.rptCode = ?1 AND r.delFlg != 'Y'")
	Optional<String> findReportDescriptionByRptCode(String rptCode);
}