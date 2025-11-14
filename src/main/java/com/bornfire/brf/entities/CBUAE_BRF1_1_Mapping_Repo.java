package com.bornfire.brf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CBUAE_BRF1_1_Mapping_Repo extends JpaRepository<CBUAE_BRF1_1_Mapping_Entity, String> {

    @Query(value = "SELECT * FROM CBUAE_BRF1_1_MAPPING_TABLE WHERE REPORT_NAME_1 = :reportId AND REPORT_LABEL_1 IS NOT NULL", nativeQuery = true)
    List<CBUAE_BRF1_1_Mapping_Entity> findMappedAccounts(@Param("reportId") String reportId);

    @Query(value = "SELECT * FROM CBUAE_BRF1_1_MAPPING_TABLE WHERE REPORT_NAME_1 = :reportId AND (REPORT_LABEL_1 IS NULL OR REPORT_LABEL_1 = '')", nativeQuery = true)
    List<CBUAE_BRF1_1_Mapping_Entity> findUnmappedAccounts(@Param("reportId") String reportId);
}