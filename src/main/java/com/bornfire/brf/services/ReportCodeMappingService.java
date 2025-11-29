package com.bornfire.brf.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.brf.dto.ReportLineItemDTO;
import com.bornfire.brf.entities.BaseMappingParameter;
import com.bornfire.brf.entities.BaseMappingParameterRepository;
import com.bornfire.brf.entities.RRReportRepository;
import com.bornfire.brf.entities.ReportCodeMappingRepo;

@Service
public class ReportCodeMappingService {

	@Autowired
	private ReportCodeMappingRepo reportCodeMappingRepo;

	@Autowired
	private RRReportRepository rrReportRepository;

	@Autowired
	private ReportLineItemService reportLineItemService;

	public List<String> getAllReportCodes() {
		return rrReportRepository.findAllDistinctReportCodes();
	}

	public String getReportNameByCode(String rptCode) {
		return rrReportRepository.findReportDescriptionByRptCode(rptCode).orElse("N/A");
	}

	public List<ReportLineItemDTO> getReportDataByCode(String reportCode) throws Exception {
		return reportLineItemService.getReportData(reportCode);
	}
    
    // The return type is updated here
    public List<ReportLineItemDTO> getReportColumnsByCode(String reportCode) throws Exception {
        return reportLineItemService.getReportColumns(reportCode);
    }
    @Autowired
    private BaseMappingParameterRepository basemappingparameterrepository;

 // In your ReportCodeMappingService.java
    public List<String> getGlHeadsByDataType(String dataType) {
        // Log the parameter received from the controller
        System.out.println("SERVICE LAYER: Fetching GL Heads for dataType: [" + dataType + "]");
        
        List<String> results = basemappingparameterrepository.getDistinctGlHeadsByDataType(dataType);
        
        // Log what the repository returned
        System.out.println("SERVICE LAYER: Found " + results.size() + " GL Heads.");
        
        return results;
    }

    public List<String> getGlSubHeadsByGlHead(String glHead) {
        // Log the parameter received from the controller
        System.out.println("SERVICE LAYER: Fetching Sub Heads for glHead: [" + glHead + "]");

        List<String> results = basemappingparameterrepository.getDistinctGlSubHeadCodesByGlHead(glHead);

        // Log what the repository returned
        System.out.println("SERVICE LAYER: Found " + results.size() + " Sub Heads.");

        return results;
    }

    public List<Map<String, Object>> getAccountDetails(List<String> glSubHeadCodes) {
        List<BaseMappingParameter> accounts = basemappingparameterrepository.getByGlSubheadCodeIn(glSubHeadCodes);
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (BaseMappingParameter account : accounts) {
            Map<String, Object> accountMap = new LinkedHashMap<>(); // Use LinkedHashMap to preserve order
            accountMap.put("glHead", account.getGl_head());
            accountMap.put("glSubHeadCode", account.getGl_subhead_code());
            accountMap.put("accountIdBacid", account.getAccount_id_bacid());
            accountMap.put("accountDescription", account.getAccount_description());
            accountMap.put("currency", account.getCurrency());
            resultList.add(accountMap);
        }
        
        return resultList;
    }

    /**
     * IMPORTANT: This is a placeholder. You must replace this with your actual logic
     * to query the account balance from its real source table using the BACID.
     */
    private BigDecimal fetchAccountBalance(String bacid) {
        // Dummy logic for demonstration purposes. Returns a random value.
        return new BigDecimal(Math.random() * 100000).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BaseMappingParameter saveMapping(BaseMappingParameter mapping) {
        mapping.setEntry_time(new Date());
        mapping.setEntry_user("SYSTEM");
        mapping.setAuth_flg("N");
        mapping.setDel_flg("N");
        mapping.setModify_flg("N");
        return basemappingparameterrepository.save(mapping);
    }
}