package com.bornfire.brf.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface BaseMappingParameterRepository extends JpaRepository<BaseMappingParameter, String> {

    // Corrected method: added parameter and type
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE", nativeQuery = true)
    List<BaseMappingParameter> getBaseMappingParameter(String accountIdBacid);
    
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE where accountIdBacid =?1 ", nativeQuery = true)
    BaseMappingParameter getParticularDataByAccount_id_bacid(String accountIdBacid);


}
