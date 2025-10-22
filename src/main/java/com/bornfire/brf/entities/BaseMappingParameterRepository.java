package com.bornfire.brf.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BaseMappingParameterRepository extends JpaRepository<BaseMappingParameter, String> {

	@Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE", nativeQuery = true)
	List<BaseMappingParameter> getBaseMappingParameter(String accountIdBacid);

	@Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE where accountIdBacid =?1 ", nativeQuery = true)
	BaseMappingParameter getParticularDataByAccount_id_bacid(String accountIdBacid);

	List<BaseMappingParameter> findByReportCode(String reportCode);

	Optional<BaseMappingParameter> findTopByReportCode(String reportCode);

	@Query(value = "SELECT DISTINCT REPORT_CODE FROM CBUAE_BASE_MAPPING_TABLE", nativeQuery = true)
	List<String> findDistinctReportCodes();

}
