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

    // 1️⃣ Get all records
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE", nativeQuery = true)
    List<BaseMappingParameter> getAllBaseMappingParameters();

    // 2️⃣ Find by REPORT_CODE
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE REPORT_CODE = :reportCode", nativeQuery = true)
    List<BaseMappingParameter> getByReportCode(String reportCode);

    // 3️⃣ Find distinct REPORT_CODEs
    @Query(value = "SELECT DISTINCT REPORT_CODE FROM CBUAE_BASE_MAPPING_TABLE", nativeQuery = true)
    List<String> getDistinctReportCodes();

    // 4️⃣ Find first record by REPORT_CODE (LIMIT 1 equivalent in Oracle)
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE REPORT_CODE = :reportCode AND ROWNUM = 1", nativeQuery = true)
    Optional<BaseMappingParameter> getTopByReportCode(String reportCode);

    // 5️⃣ Get distinct GL_HEAD by DATA_TYPE
    @Query(value = "SELECT DISTINCT GL_HEAD FROM CBUAE_BASE_MAPPING_TABLE WHERE DATA_TYPE = :dataType ORDER BY GL_HEAD", nativeQuery = true)
    List<String> getDistinctGlHeadsByDataType(String dataType);

    // 6️⃣ Get distinct GL_SUBHEAD_CODE by GL_HEAD
    @Query(value = "SELECT DISTINCT GL_SUBHEAD_CODE FROM CBUAE_BASE_MAPPING_TABLE WHERE GL_HEAD = :glHead ORDER BY GL_SUBHEAD_CODE", nativeQuery = true)
    List<String> getDistinctGlSubHeadCodesByGlHead(String glHead);

    // 7️⃣ Find by multiple GL_SUBHEAD_CODE
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE GL_SUBHEAD_CODE IN (:glSubHeadCodes)", nativeQuery = true)
    List<BaseMappingParameter> getByGlSubheadCodeIn(List<String> glSubHeadCodes);

    // 8️⃣ Find by GL_HEAD and GL_SUBHEAD_CODE
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE GL_HEAD = :glHead AND GL_SUBHEAD_CODE = :glSubHeadCode", nativeQuery = true)
    List<BaseMappingParameter> getByGlHeadAndGlSubheadCode(String glHead, String glSubHeadCode);

    // 9️⃣ Find by DATA_TYPE and REPORT_CODE
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE DATA_TYPE = :dataType AND REPORT_CODE = :reportCode", nativeQuery = true)
    List<BaseMappingParameter> getByDataTypeAndReportCode(String dataType, String reportCode);

    // 🔟 Find by ACCOUNT_ID_BACID (Primary Key)
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE ACCOUNT_ID_BACID = :accountIdBacid", nativeQuery = true)
    Optional<BaseMappingParameter> getByAccountIdBacid(String accountIdBacid);

    // 1️⃣1️⃣ Find all ACTIVE rows (NOT deleted)
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE DEL_FLG = 'N'", nativeQuery = true)
    List<BaseMappingParameter> getActiveRecords();

    // 1️⃣2️⃣ Find ACCOUNT_DESCRIPTION contains keyword
    @Query(value = "SELECT * FROM CBUAE_BASE_MAPPING_TABLE WHERE LOWER(ACCOUNT_DESCRIPTION) LIKE LOWER(CONCAT('%', :keyword, '%'))", nativeQuery = true)
    List<BaseMappingParameter> searchByAccountDescription(String keyword);

    // 1️⃣3️⃣ Get record count by GL_HEAD
    @Query(value = "SELECT COUNT(*) FROM CBUAE_BASE_MAPPING_TABLE WHERE GL_HEAD = :glHead", nativeQuery = true)
    int countByGlHead(String glHead);
}
