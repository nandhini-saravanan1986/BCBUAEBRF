package com.bornfire.brf.entities;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CBUAE_BRF5_3_ARCHIVALTABLE_SUMMARY2")

public class CBUAE_BRF5_3_Summary_Archival_Entity2 {

	private String r0300_product;
	private BigDecimal r0300_outstandbal;
	private BigDecimal r0300_secured_outstandbal;
	private BigDecimal r0300_unsecured_outstandbal;
	private BigDecimal r0300_stage1_assetclass;
	private BigDecimal r0300_stage2_assetclass;
	private BigDecimal r0300_stage3a_assetclass;
	private BigDecimal r0300_stage3b_assetclass;
	private BigDecimal r0300_stage3c_assetclass;
	private BigDecimal r0300_stage1_provisionheld;
	private BigDecimal r0300_stage2_provisionheld;
	private BigDecimal r0300_stage3a_provisionheld;
	private BigDecimal r0300_stage3b_provisionheld;
	private BigDecimal r0300_stage3c_provisionheld;
	private BigDecimal r0300_intrestfees_provisionheld;
	private BigDecimal r0300_intrestsuspense_provisionheld;
	private BigDecimal r0300_stage1_poci;
	private BigDecimal r0300_stage2_poci;
	private BigDecimal r0300_stage3a_poci;
	private BigDecimal r0300_stage3b_poci;
	private BigDecimal r0300_stage3c_poci;
	private BigDecimal r0300_current_pastdues;
	private BigDecimal r0300_less30days_pastdues;
	private BigDecimal r0300_31to90days_pastdues;
	private BigDecimal r0300_91to120days_pastdues;
	private BigDecimal r0300_121to180days_pastdues;
	private BigDecimal r0300_181to365days_pastdues;
	private BigDecimal r0300_over365days_pastdues;
	private BigDecimal r0300_total_pastdues;
	private BigDecimal r0300_newloan_duringreport;
	private BigDecimal r0300_newstage_duringreport;
	private BigDecimal r0300_intrestfees_duringreport;
	private BigDecimal r0300_performingac_acinfo;
	private BigDecimal r0300_nonperformingac_acinfo;
	private String r0310_product;
	private BigDecimal r0310_outstandbal;
	private BigDecimal r0310_secured_outstandbal;
	private BigDecimal r0310_unsecured_outstandbal;
	private BigDecimal r0310_stage1_assetclass;
	private BigDecimal r0310_stage2_assetclass;
	private BigDecimal r0310_stage3a_assetclass;
	private BigDecimal r0310_stage3b_assetclass;
	private BigDecimal r0310_stage3c_assetclass;
	private BigDecimal r0310_stage1_provisionheld;
	private BigDecimal r0310_stage2_provisionheld;
	private BigDecimal r0310_stage3a_provisionheld;
	private BigDecimal r0310_stage3b_provisionheld;
	private BigDecimal r0310_stage3c_provisionheld;
	private BigDecimal r0310_intrestfees_provisionheld;
	private BigDecimal r0310_intrestsuspense_provisionheld;
	private BigDecimal r0310_stage1_poci;
	private BigDecimal r0310_stage2_poci;
	private BigDecimal r0310_stage3a_poci;
	private BigDecimal r0310_stage3b_poci;
	private BigDecimal r0310_stage3c_poci;
	private BigDecimal r0310_current_pastdues;
	private BigDecimal r0310_less30days_pastdues;
	private BigDecimal r0310_31to90days_pastdues;
	private BigDecimal r0310_91to120days_pastdues;
	private BigDecimal r0310_121to180days_pastdues;
	private BigDecimal r0310_181to365days_pastdues;
	private BigDecimal r0310_over365days_pastdues;
	private BigDecimal r0310_total_pastdues;
	private BigDecimal r0310_newloan_duringreport;
	private BigDecimal r0310_newstage_duringreport;
	private BigDecimal r0310_intrestfees_duringreport;
	private BigDecimal r0310_performingac_acinfo;
	private BigDecimal r0310_nonperformingac_acinfo;
	private String r0320_product;
	private BigDecimal r0320_outstandbal;
	private BigDecimal r0320_secured_outstandbal;
	private BigDecimal r0320_unsecured_outstandbal;
	private BigDecimal r0320_stage1_assetclass;
	private BigDecimal r0320_stage2_assetclass;
	private BigDecimal r0320_stage3a_assetclass;
	private BigDecimal r0320_stage3b_assetclass;
	private BigDecimal r0320_stage3c_assetclass;
	private BigDecimal r0320_stage1_provisionheld;
	private BigDecimal r0320_stage2_provisionheld;
	private BigDecimal r0320_stage3a_provisionheld;
	private BigDecimal r0320_stage3b_provisionheld;
	private BigDecimal r0320_stage3c_provisionheld;
	private BigDecimal r0320_intrestfees_provisionheld;
	private BigDecimal r0320_intrestsuspense_provisionheld;
	private BigDecimal r0320_stage1_poci;
	private BigDecimal r0320_stage2_poci;
	private BigDecimal r0320_stage3a_poci;
	private BigDecimal r0320_stage3b_poci;
	private BigDecimal r0320_stage3c_poci;
	private BigDecimal r0320_current_pastdues;
	private BigDecimal r0320_less30days_pastdues;
	private BigDecimal r0320_31to90days_pastdues;
	private BigDecimal r0320_91to120days_pastdues;
	private BigDecimal r0320_121to180days_pastdues;
	private BigDecimal r0320_181to365days_pastdues;
	private BigDecimal r0320_over365days_pastdues;
	private BigDecimal r0320_total_pastdues;
	private BigDecimal r0320_newloan_duringreport;
	private BigDecimal r0320_newstage_duringreport;
	private BigDecimal r0320_intrestfees_duringreport;
	private BigDecimal r0320_performingac_acinfo;
	private BigDecimal r0320_nonperformingac_acinfo;
	private String r0330_product;
	private BigDecimal r0330_outstandbal;
	private BigDecimal r0330_secured_outstandbal;
	private BigDecimal r0330_unsecured_outstandbal;
	private BigDecimal r0330_stage1_assetclass;
	private BigDecimal r0330_stage2_assetclass;
	private BigDecimal r0330_stage3a_assetclass;
	private BigDecimal r0330_stage3b_assetclass;
	private BigDecimal r0330_stage3c_assetclass;
	private BigDecimal r0330_stage1_provisionheld;
	private BigDecimal r0330_stage2_provisionheld;
	private BigDecimal r0330_stage3a_provisionheld;
	private BigDecimal r0330_stage3b_provisionheld;
	private BigDecimal r0330_stage3c_provisionheld;
	private BigDecimal r0330_intrestfees_provisionheld;
	private BigDecimal r0330_intrestsuspense_provisionheld;
	private BigDecimal r0330_stage1_poci;
	private BigDecimal r0330_stage2_poci;
	private BigDecimal r0330_stage3a_poci;
	private BigDecimal r0330_stage3b_poci;
	private BigDecimal r0330_stage3c_poci;
	private BigDecimal r0330_current_pastdues;
	private BigDecimal r0330_less30days_pastdues;
	private BigDecimal r0330_31to90days_pastdues;
	private BigDecimal r0330_91to120days_pastdues;
	private BigDecimal r0330_121to180days_pastdues;
	private BigDecimal r0330_181to365days_pastdues;
	private BigDecimal r0330_over365days_pastdues;
	private BigDecimal r0330_total_pastdues;
	private BigDecimal r0330_newloan_duringreport;
	private BigDecimal r0330_newstage_duringreport;
	private BigDecimal r0330_intrestfees_duringreport;
	private BigDecimal r0330_performingac_acinfo;
	private BigDecimal r0330_nonperformingac_acinfo;
	private String r0340_product;
	private BigDecimal r0340_outstandbal;
	private BigDecimal r0340_secured_outstandbal;
	private BigDecimal r0340_unsecured_outstandbal;
	private BigDecimal r0340_stage1_assetclass;
	private BigDecimal r0340_stage2_assetclass;
	private BigDecimal r0340_stage3a_assetclass;
	private BigDecimal r0340_stage3b_assetclass;
	private BigDecimal r0340_stage3c_assetclass;
	private BigDecimal r0340_stage1_provisionheld;
	private BigDecimal r0340_stage2_provisionheld;
	private BigDecimal r0340_stage3a_provisionheld;
	private BigDecimal r0340_stage3b_provisionheld;
	private BigDecimal r0340_stage3c_provisionheld;
	private BigDecimal r0340_intrestfees_provisionheld;
	private BigDecimal r0340_intrestsuspense_provisionheld;
	private BigDecimal r0340_stage1_poci;
	private BigDecimal r0340_stage2_poci;
	private BigDecimal r0340_stage3a_poci;
	private BigDecimal r0340_stage3b_poci;
	private BigDecimal r0340_stage3c_poci;
	private BigDecimal r0340_current_pastdues;
	private BigDecimal r0340_less30days_pastdues;
	private BigDecimal r0340_31to90days_pastdues;
	private BigDecimal r0340_91to120days_pastdues;
	private BigDecimal r0340_121to180days_pastdues;
	private BigDecimal r0340_181to365days_pastdues;
	private BigDecimal r0340_over365days_pastdues;
	private BigDecimal r0340_total_pastdues;
	private BigDecimal r0340_newloan_duringreport;
	private BigDecimal r0340_newstage_duringreport;
	private BigDecimal r0340_intrestfees_duringreport;
	private BigDecimal r0340_performingac_acinfo;
	private BigDecimal r0340_nonperformingac_acinfo;
	private String r0350_product;
	private BigDecimal r0350_outstandbal;
	private BigDecimal r0350_secured_outstandbal;
	private BigDecimal r0350_unsecured_outstandbal;
	private BigDecimal r0350_stage1_assetclass;
	private BigDecimal r0350_stage2_assetclass;
	private BigDecimal r0350_stage3a_assetclass;
	private BigDecimal r0350_stage3b_assetclass;
	private BigDecimal r0350_stage3c_assetclass;
	private BigDecimal r0350_stage1_provisionheld;
	private BigDecimal r0350_stage2_provisionheld;
	private BigDecimal r0350_stage3a_provisionheld;
	private BigDecimal r0350_stage3b_provisionheld;
	private BigDecimal r0350_stage3c_provisionheld;
	private BigDecimal r0350_intrestfees_provisionheld;
	private BigDecimal r0350_intrestsuspense_provisionheld;
	private BigDecimal r0350_stage1_poci;
	private BigDecimal r0350_stage2_poci;
	private BigDecimal r0350_stage3a_poci;
	private BigDecimal r0350_stage3b_poci;
	private BigDecimal r0350_stage3c_poci;
	private BigDecimal r0350_current_pastdues;
	private BigDecimal r0350_less30days_pastdues;
	private BigDecimal r0350_31to90days_pastdues;
	private BigDecimal r0350_91to120days_pastdues;
	private BigDecimal r0350_121to180days_pastdues;
	private BigDecimal r0350_181to365days_pastdues;
	private BigDecimal r0350_over365days_pastdues;
	private BigDecimal r0350_total_pastdues;
	private BigDecimal r0350_newloan_duringreport;
	private BigDecimal r0350_newstage_duringreport;
	private BigDecimal r0350_intrestfees_duringreport;
	private BigDecimal r0350_performingac_acinfo;
	private BigDecimal r0350_nonperformingac_acinfo;
	private String r0360_product;
	private BigDecimal r0360_outstandbal;
	private BigDecimal r0360_secured_outstandbal;
	private BigDecimal r0360_unsecured_outstandbal;
	private BigDecimal r0360_stage1_assetclass;
	private BigDecimal r0360_stage2_assetclass;
	private BigDecimal r0360_stage3a_assetclass;
	private BigDecimal r0360_stage3b_assetclass;
	private BigDecimal r0360_stage3c_assetclass;
	private BigDecimal r0360_stage1_provisionheld;
	private BigDecimal r0360_stage2_provisionheld;
	private BigDecimal r0360_stage3a_provisionheld;
	private BigDecimal r0360_stage3b_provisionheld;
	private BigDecimal r0360_stage3c_provisionheld;
	private BigDecimal r0360_intrestfees_provisionheld;
	private BigDecimal r0360_intrestsuspense_provisionheld;
	private BigDecimal r0360_stage1_poci;
	private BigDecimal r0360_stage2_poci;
	private BigDecimal r0360_stage3a_poci;
	private BigDecimal r0360_stage3b_poci;
	private BigDecimal r0360_stage3c_poci;
	private BigDecimal r0360_current_pastdues;
	private BigDecimal r0360_less30days_pastdues;
	private BigDecimal r0360_31to90days_pastdues;
	private BigDecimal r0360_91to120days_pastdues;
	private BigDecimal r0360_121to180days_pastdues;
	private BigDecimal r0360_181to365days_pastdues;
	private BigDecimal r0360_over365days_pastdues;
	private BigDecimal r0360_total_pastdues;
	private BigDecimal r0360_newloan_duringreport;
	private BigDecimal r0360_newstage_duringreport;
	private BigDecimal r0360_intrestfees_duringreport;
	private BigDecimal r0360_performingac_acinfo;
	private BigDecimal r0360_nonperformingac_acinfo;
	private String r0370_product;
	private BigDecimal r0370_outstandbal;
	private BigDecimal r0370_secured_outstandbal;
	private BigDecimal r0370_unsecured_outstandbal;
	private BigDecimal r0370_stage1_assetclass;
	private BigDecimal r0370_stage2_assetclass;
	private BigDecimal r0370_stage3a_assetclass;
	private BigDecimal r0370_stage3b_assetclass;
	private BigDecimal r0370_stage3c_assetclass;
	private BigDecimal r0370_stage1_provisionheld;
	private BigDecimal r0370_stage2_provisionheld;
	private BigDecimal r0370_stage3a_provisionheld;
	private BigDecimal r0370_stage3b_provisionheld;
	private BigDecimal r0370_stage3c_provisionheld;
	private BigDecimal r0370_intrestfees_provisionheld;
	private BigDecimal r0370_intrestsuspense_provisionheld;
	private BigDecimal r0370_stage1_poci;
	private BigDecimal r0370_stage2_poci;
	private BigDecimal r0370_stage3a_poci;
	private BigDecimal r0370_stage3b_poci;
	private BigDecimal r0370_stage3c_poci;
	private BigDecimal r0370_current_pastdues;
	private BigDecimal r0370_less30days_pastdues;
	private BigDecimal r0370_31to90days_pastdues;
	private BigDecimal r0370_91to120days_pastdues;
	private BigDecimal r0370_121to180days_pastdues;
	private BigDecimal r0370_181to365days_pastdues;
	private BigDecimal r0370_over365days_pastdues;
	private BigDecimal r0370_total_pastdues;
	private BigDecimal r0370_newloan_duringreport;
	private BigDecimal r0370_newstage_duringreport;
	private BigDecimal r0370_intrestfees_duringreport;
	private BigDecimal r0370_performingac_acinfo;
	private BigDecimal r0370_nonperformingac_acinfo;
	private String r0380_product;
	private BigDecimal r0380_outstandbal;
	private BigDecimal r0380_secured_outstandbal;
	private BigDecimal r0380_unsecured_outstandbal;
	private BigDecimal r0380_stage1_assetclass;
	private BigDecimal r0380_stage2_assetclass;
	private BigDecimal r0380_stage3a_assetclass;
	private BigDecimal r0380_stage3b_assetclass;
	private BigDecimal r0380_stage3c_assetclass;
	private BigDecimal r0380_stage1_provisionheld;
	private BigDecimal r0380_stage2_provisionheld;
	private BigDecimal r0380_stage3a_provisionheld;
	private BigDecimal r0380_stage3b_provisionheld;
	private BigDecimal r0380_stage3c_provisionheld;
	private BigDecimal r0380_intrestfees_provisionheld;
	private BigDecimal r0380_intrestsuspense_provisionheld;
	private BigDecimal r0380_stage1_poci;
	private BigDecimal r0380_stage2_poci;
	private BigDecimal r0380_stage3a_poci;
	private BigDecimal r0380_stage3b_poci;
	private BigDecimal r0380_stage3c_poci;
	private BigDecimal r0380_current_pastdues;
	private BigDecimal r0380_less30days_pastdues;
	private BigDecimal r0380_31to90days_pastdues;
	private BigDecimal r0380_91to120days_pastdues;
	private BigDecimal r0380_121to180days_pastdues;
	private BigDecimal r0380_181to365days_pastdues;
	private BigDecimal r0380_over365days_pastdues;
	private BigDecimal r0380_total_pastdues;
	private BigDecimal r0380_newloan_duringreport;
	private BigDecimal r0380_newstage_duringreport;
	private BigDecimal r0380_intrestfees_duringreport;
	private BigDecimal r0380_performingac_acinfo;
	private BigDecimal r0380_nonperformingac_acinfo;
	private String r0390_product;
	private BigDecimal r0390_outstandbal;
	private BigDecimal r0390_secured_outstandbal;
	private BigDecimal r0390_unsecured_outstandbal;
	private BigDecimal r0390_stage1_assetclass;
	private BigDecimal r0390_stage2_assetclass;
	private BigDecimal r0390_stage3a_assetclass;
	private BigDecimal r0390_stage3b_assetclass;
	private BigDecimal r0390_stage3c_assetclass;
	private BigDecimal r0390_stage1_provisionheld;
	private BigDecimal r0390_stage2_provisionheld;
	private BigDecimal r0390_stage3a_provisionheld;
	private BigDecimal r0390_stage3b_provisionheld;
	private BigDecimal r0390_stage3c_provisionheld;
	private BigDecimal r0390_intrestfees_provisionheld;
	private BigDecimal r0390_intrestsuspense_provisionheld;
	private BigDecimal r0390_stage1_poci;
	private BigDecimal r0390_stage2_poci;
	private BigDecimal r0390_stage3a_poci;
	private BigDecimal r0390_stage3b_poci;
	private BigDecimal r0390_stage3c_poci;
	private BigDecimal r0390_current_pastdues;
	private BigDecimal r0390_less30days_pastdues;
	private BigDecimal r0390_31to90days_pastdues;
	private BigDecimal r0390_91to120days_pastdues;
	private BigDecimal r0390_121to180days_pastdues;
	private BigDecimal r0390_181to365days_pastdues;
	private BigDecimal r0390_over365days_pastdues;
	private BigDecimal r0390_total_pastdues;
	private BigDecimal r0390_newloan_duringreport;
	private BigDecimal r0390_newstage_duringreport;
	private BigDecimal r0390_intrestfees_duringreport;
	private BigDecimal r0390_performingac_acinfo;
	private BigDecimal r0390_nonperformingac_acinfo;
	private String r0400_product;
	private BigDecimal r0400_outstandbal;
	private BigDecimal r0400_secured_outstandbal;
	private BigDecimal r0400_unsecured_outstandbal;
	private BigDecimal r0400_stage1_assetclass;
	private BigDecimal r0400_stage2_assetclass;
	private BigDecimal r0400_stage3a_assetclass;
	private BigDecimal r0400_stage3b_assetclass;
	private BigDecimal r0400_stage3c_assetclass;
	private BigDecimal r0400_stage1_provisionheld;
	private BigDecimal r0400_stage2_provisionheld;
	private BigDecimal r0400_stage3a_provisionheld;
	private BigDecimal r0400_stage3b_provisionheld;
	private BigDecimal r0400_stage3c_provisionheld;
	private BigDecimal r0400_intrestfees_provisionheld;
	private BigDecimal r0400_intrestsuspense_provisionheld;
	private BigDecimal r0400_stage1_poci;
	private BigDecimal r0400_stage2_poci;
	private BigDecimal r0400_stage3a_poci;
	private BigDecimal r0400_stage3b_poci;
	private BigDecimal r0400_stage3c_poci;
	private BigDecimal r0400_current_pastdues;
	private BigDecimal r0400_less30days_pastdues;
	private BigDecimal r0400_31to90days_pastdues;
	private BigDecimal r0400_91to120days_pastdues;
	private BigDecimal r0400_121to180days_pastdues;
	private BigDecimal r0400_181to365days_pastdues;
	private BigDecimal r0400_over365days_pastdues;
	private BigDecimal r0400_total_pastdues;
	private BigDecimal r0400_newloan_duringreport;
	private BigDecimal r0400_newstage_duringreport;
	private BigDecimal r0400_intrestfees_duringreport;
	private BigDecimal r0400_performingac_acinfo;
	private BigDecimal r0400_nonperformingac_acinfo;
	private String r0410_product;
	private BigDecimal r0410_outstandbal;
	private BigDecimal r0410_secured_outstandbal;
	private BigDecimal r0410_unsecured_outstandbal;
	private BigDecimal r0410_stage1_assetclass;
	private BigDecimal r0410_stage2_assetclass;
	private BigDecimal r0410_stage3a_assetclass;
	private BigDecimal r0410_stage3b_assetclass;
	private BigDecimal r0410_stage3c_assetclass;
	private BigDecimal r0410_stage1_provisionheld;
	private BigDecimal r0410_stage2_provisionheld;
	private BigDecimal r0410_stage3a_provisionheld;
	private BigDecimal r0410_stage3b_provisionheld;
	private BigDecimal r0410_stage3c_provisionheld;
	private BigDecimal r0410_intrestfees_provisionheld;
	private BigDecimal r0410_intrestsuspense_provisionheld;
	private BigDecimal r0410_stage1_poci;
	private BigDecimal r0410_stage2_poci;
	private BigDecimal r0410_stage3a_poci;
	private BigDecimal r0410_stage3b_poci;
	private BigDecimal r0410_stage3c_poci;
	private BigDecimal r0410_current_pastdues;
	private BigDecimal r0410_less30days_pastdues;
	private BigDecimal r0410_31to90days_pastdues;
	private BigDecimal r0410_91to120days_pastdues;
	private BigDecimal r0410_121to180days_pastdues;
	private BigDecimal r0410_181to365days_pastdues;
	private BigDecimal r0410_over365days_pastdues;
	private BigDecimal r0410_total_pastdues;
	private BigDecimal r0410_newloan_duringreport;
	private BigDecimal r0410_newstage_duringreport;
	private BigDecimal r0410_intrestfees_duringreport;
	private BigDecimal r0410_performingac_acinfo;
	private BigDecimal r0410_nonperformingac_acinfo;
	private String r0420_product;
	private BigDecimal r0420_outstandbal;
	private BigDecimal r0420_secured_outstandbal;
	private BigDecimal r0420_unsecured_outstandbal;
	private BigDecimal r0420_stage1_assetclass;
	private BigDecimal r0420_stage2_assetclass;
	private BigDecimal r0420_stage3a_assetclass;
	private BigDecimal r0420_stage3b_assetclass;
	private BigDecimal r0420_stage3c_assetclass;
	private BigDecimal r0420_stage1_provisionheld;
	private BigDecimal r0420_stage2_provisionheld;
	private BigDecimal r0420_stage3a_provisionheld;
	private BigDecimal r0420_stage3b_provisionheld;
	private BigDecimal r0420_stage3c_provisionheld;
	private BigDecimal r0420_intrestfees_provisionheld;
	private BigDecimal r0420_intrestsuspense_provisionheld;
	private BigDecimal r0420_stage1_poci;
	private BigDecimal r0420_stage2_poci;
	private BigDecimal r0420_stage3a_poci;
	private BigDecimal r0420_stage3b_poci;
	private BigDecimal r0420_stage3c_poci;
	private BigDecimal r0420_current_pastdues;
	private BigDecimal r0420_less30days_pastdues;
	private BigDecimal r0420_31to90days_pastdues;
	private BigDecimal r0420_91to120days_pastdues;
	private BigDecimal r0420_121to180days_pastdues;
	private BigDecimal r0420_181to365days_pastdues;
	private BigDecimal r0420_over365days_pastdues;
	private BigDecimal r0420_total_pastdues;
	private BigDecimal r0420_newloan_duringreport;
	private BigDecimal r0420_newstage_duringreport;
	private BigDecimal r0420_intrestfees_duringreport;
	private BigDecimal r0420_performingac_acinfo;
	private BigDecimal r0420_nonperformingac_acinfo;
	private String r0430_product;
	private BigDecimal r0430_outstandbal;
	private BigDecimal r0430_secured_outstandbal;
	private BigDecimal r0430_unsecured_outstandbal;
	private BigDecimal r0430_stage1_assetclass;
	private BigDecimal r0430_stage2_assetclass;
	private BigDecimal r0430_stage3a_assetclass;
	private BigDecimal r0430_stage3b_assetclass;
	private BigDecimal r0430_stage3c_assetclass;
	private BigDecimal r0430_stage1_provisionheld;
	private BigDecimal r0430_stage2_provisionheld;
	private BigDecimal r0430_stage3a_provisionheld;
	private BigDecimal r0430_stage3b_provisionheld;
	private BigDecimal r0430_stage3c_provisionheld;
	private BigDecimal r0430_intrestfees_provisionheld;
	private BigDecimal r0430_intrestsuspense_provisionheld;
	private BigDecimal r0430_stage1_poci;
	private BigDecimal r0430_stage2_poci;
	private BigDecimal r0430_stage3a_poci;
	private BigDecimal r0430_stage3b_poci;
	private BigDecimal r0430_stage3c_poci;
	private BigDecimal r0430_current_pastdues;
	private BigDecimal r0430_less30days_pastdues;
	private BigDecimal r0430_31to90days_pastdues;
	private BigDecimal r0430_91to120days_pastdues;
	private BigDecimal r0430_121to180days_pastdues;
	private BigDecimal r0430_181to365days_pastdues;
	private BigDecimal r0430_over365days_pastdues;
	private BigDecimal r0430_total_pastdues;
	private BigDecimal r0430_newloan_duringreport;
	private BigDecimal r0430_newstage_duringreport;
	private BigDecimal r0430_intrestfees_duringreport;
	private BigDecimal r0430_performingac_acinfo;
	private BigDecimal r0430_nonperformingac_acinfo;
	private String r0440_product;
	private BigDecimal r0440_outstandbal;
	private BigDecimal r0440_secured_outstandbal;
	private BigDecimal r0440_unsecured_outstandbal;
	private BigDecimal r0440_stage1_assetclass;
	private BigDecimal r0440_stage2_assetclass;
	private BigDecimal r0440_stage3a_assetclass;
	private BigDecimal r0440_stage3b_assetclass;
	private BigDecimal r0440_stage3c_assetclass;
	private BigDecimal r0440_stage1_provisionheld;
	private BigDecimal r0440_stage2_provisionheld;
	private BigDecimal r0440_stage3a_provisionheld;
	private BigDecimal r0440_stage3b_provisionheld;
	private BigDecimal r0440_stage3c_provisionheld;
	private BigDecimal r0440_intrestfees_provisionheld;
	private BigDecimal r0440_intrestsuspense_provisionheld;
	private BigDecimal r0440_stage1_poci;
	private BigDecimal r0440_stage2_poci;
	private BigDecimal r0440_stage3a_poci;
	private BigDecimal r0440_stage3b_poci;
	private BigDecimal r0440_stage3c_poci;
	private BigDecimal r0440_current_pastdues;
	private BigDecimal r0440_less30days_pastdues;
	private BigDecimal r0440_31to90days_pastdues;
	private BigDecimal r0440_91to120days_pastdues;
	private BigDecimal r0440_121to180days_pastdues;
	private BigDecimal r0440_181to365days_pastdues;
	private BigDecimal r0440_over365days_pastdues;
	private BigDecimal r0440_total_pastdues;
	private BigDecimal r0440_newloan_duringreport;
	private BigDecimal r0440_newstage_duringreport;
	private BigDecimal r0440_intrestfees_duringreport;
	private BigDecimal r0440_performingac_acinfo;
	private BigDecimal r0440_nonperformingac_acinfo;
	private String r0450_product;
	private BigDecimal r0450_outstandbal;
	private BigDecimal r0450_secured_outstandbal;
	private BigDecimal r0450_unsecured_outstandbal;
	private BigDecimal r0450_stage1_assetclass;
	private BigDecimal r0450_stage2_assetclass;
	private BigDecimal r0450_stage3a_assetclass;
	private BigDecimal r0450_stage3b_assetclass;
	private BigDecimal r0450_stage3c_assetclass;
	private BigDecimal r0450_stage1_provisionheld;
	private BigDecimal r0450_stage2_provisionheld;
	private BigDecimal r0450_stage3a_provisionheld;
	private BigDecimal r0450_stage3b_provisionheld;
	private BigDecimal r0450_stage3c_provisionheld;
	private BigDecimal r0450_intrestfees_provisionheld;
	private BigDecimal r0450_intrestsuspense_provisionheld;
	private BigDecimal r0450_stage1_poci;
	private BigDecimal r0450_stage2_poci;
	private BigDecimal r0450_stage3a_poci;
	private BigDecimal r0450_stage3b_poci;
	private BigDecimal r0450_stage3c_poci;
	private BigDecimal r0450_current_pastdues;
	private BigDecimal r0450_less30days_pastdues;
	private BigDecimal r0450_31to90days_pastdues;
	private BigDecimal r0450_91to120days_pastdues;
	private BigDecimal r0450_121to180days_pastdues;
	private BigDecimal r0450_181to365days_pastdues;
	private BigDecimal r0450_over365days_pastdues;
	private BigDecimal r0450_total_pastdues;
	private BigDecimal r0450_newloan_duringreport;
	private BigDecimal r0450_newstage_duringreport;
	private BigDecimal r0450_intrestfees_duringreport;
	private BigDecimal r0450_performingac_acinfo;
	private BigDecimal r0450_nonperformingac_acinfo;
	private String r0460_product;
	private BigDecimal r0460_outstandbal;
	private BigDecimal r0460_secured_outstandbal;
	private BigDecimal r0460_unsecured_outstandbal;
	private BigDecimal r0460_stage1_assetclass;
	private BigDecimal r0460_stage2_assetclass;
	private BigDecimal r0460_stage3a_assetclass;
	private BigDecimal r0460_stage3b_assetclass;
	private BigDecimal r0460_stage3c_assetclass;
	private BigDecimal r0460_stage1_provisionheld;
	private BigDecimal r0460_stage2_provisionheld;
	private BigDecimal r0460_stage3a_provisionheld;
	private BigDecimal r0460_stage3b_provisionheld;
	private BigDecimal r0460_stage3c_provisionheld;
	private BigDecimal r0460_intrestfees_provisionheld;
	private BigDecimal r0460_intrestsuspense_provisionheld;
	private BigDecimal r0460_stage1_poci;
	private BigDecimal r0460_stage2_poci;
	private BigDecimal r0460_stage3a_poci;
	private BigDecimal r0460_stage3b_poci;
	private BigDecimal r0460_stage3c_poci;
	private BigDecimal r0460_current_pastdues;
	private BigDecimal r0460_less30days_pastdues;
	private BigDecimal r0460_31to90days_pastdues;
	private BigDecimal r0460_91to120days_pastdues;
	private BigDecimal r0460_121to180days_pastdues;
	private BigDecimal r0460_181to365days_pastdues;
	private BigDecimal r0460_over365days_pastdues;
	private BigDecimal r0460_total_pastdues;
	private BigDecimal r0460_newloan_duringreport;
	private BigDecimal r0460_newstage_duringreport;
	private BigDecimal r0460_intrestfees_duringreport;
	private BigDecimal r0460_performingac_acinfo;
	private BigDecimal r0460_nonperformingac_acinfo;
	private String r0470_product;
	private BigDecimal r0470_outstandbal;
	private BigDecimal r0470_secured_outstandbal;
	private BigDecimal r0470_unsecured_outstandbal;
	private BigDecimal r0470_stage1_assetclass;
	private BigDecimal r0470_stage2_assetclass;
	private BigDecimal r0470_stage3a_assetclass;
	private BigDecimal r0470_stage3b_assetclass;
	private BigDecimal r0470_stage3c_assetclass;
	private BigDecimal r0470_stage1_provisionheld;
	private BigDecimal r0470_stage2_provisionheld;
	private BigDecimal r0470_stage3a_provisionheld;
	private BigDecimal r0470_stage3b_provisionheld;
	private BigDecimal r0470_stage3c_provisionheld;
	private BigDecimal r0470_intrestfees_provisionheld;
	private BigDecimal r0470_intrestsuspense_provisionheld;
	private BigDecimal r0470_stage1_poci;
	private BigDecimal r0470_stage2_poci;
	private BigDecimal r0470_stage3a_poci;
	private BigDecimal r0470_stage3b_poci;
	private BigDecimal r0470_stage3c_poci;
	private BigDecimal r0470_current_pastdues;
	private BigDecimal r0470_less30days_pastdues;
	private BigDecimal r0470_31to90days_pastdues;
	private BigDecimal r0470_91to120days_pastdues;
	private BigDecimal r0470_121to180days_pastdues;
	private BigDecimal r0470_181to365days_pastdues;
	private BigDecimal r0470_over365days_pastdues;
	private BigDecimal r0470_total_pastdues;
	private BigDecimal r0470_newloan_duringreport;
	private BigDecimal r0470_newstage_duringreport;
	private BigDecimal r0470_intrestfees_duringreport;
	private BigDecimal r0470_performingac_acinfo;
	private BigDecimal r0470_nonperformingac_acinfo;
	private String r0480_product;
	private BigDecimal r0480_outstandbal;
	private BigDecimal r0480_secured_outstandbal;
	private BigDecimal r0480_unsecured_outstandbal;
	private BigDecimal r0480_stage1_assetclass;
	private BigDecimal r0480_stage2_assetclass;
	private BigDecimal r0480_stage3a_assetclass;
	private BigDecimal r0480_stage3b_assetclass;
	private BigDecimal r0480_stage3c_assetclass;
	private BigDecimal r0480_stage1_provisionheld;
	private BigDecimal r0480_stage2_provisionheld;
	private BigDecimal r0480_stage3a_provisionheld;
	private BigDecimal r0480_stage3b_provisionheld;
	private BigDecimal r0480_stage3c_provisionheld;
	private BigDecimal r0480_intrestfees_provisionheld;
	private BigDecimal r0480_intrestsuspense_provisionheld;
	private BigDecimal r0480_stage1_poci;
	private BigDecimal r0480_stage2_poci;
	private BigDecimal r0480_stage3a_poci;
	private BigDecimal r0480_stage3b_poci;
	private BigDecimal r0480_stage3c_poci;
	private BigDecimal r0480_current_pastdues;
	private BigDecimal r0480_less30days_pastdues;
	private BigDecimal r0480_31to90days_pastdues;
	private BigDecimal r0480_91to120days_pastdues;
	private BigDecimal r0480_121to180days_pastdues;
	private BigDecimal r0480_181to365days_pastdues;
	private BigDecimal r0480_over365days_pastdues;
	private BigDecimal r0480_total_pastdues;
	private BigDecimal r0480_newloan_duringreport;
	private BigDecimal r0480_newstage_duringreport;
	private BigDecimal r0480_intrestfees_duringreport;
	private BigDecimal r0480_performingac_acinfo;
	private BigDecimal r0480_nonperformingac_acinfo;
	private String r0490_product;
	private BigDecimal r0490_outstandbal;
	private BigDecimal r0490_secured_outstandbal;
	private BigDecimal r0490_unsecured_outstandbal;
	private BigDecimal r0490_stage1_assetclass;
	private BigDecimal r0490_stage2_assetclass;
	private BigDecimal r0490_stage3a_assetclass;
	private BigDecimal r0490_stage3b_assetclass;
	private BigDecimal r0490_stage3c_assetclass;
	private BigDecimal r0490_stage1_provisionheld;
	private BigDecimal r0490_stage2_provisionheld;
	private BigDecimal r0490_stage3a_provisionheld;
	private BigDecimal r0490_stage3b_provisionheld;
	private BigDecimal r0490_stage3c_provisionheld;
	private BigDecimal r0490_intrestfees_provisionheld;
	private BigDecimal r0490_intrestsuspense_provisionheld;
	private BigDecimal r0490_stage1_poci;
	private BigDecimal r0490_stage2_poci;
	private BigDecimal r0490_stage3a_poci;
	private BigDecimal r0490_stage3b_poci;
	private BigDecimal r0490_stage3c_poci;
	private BigDecimal r0490_current_pastdues;
	private BigDecimal r0490_less30days_pastdues;
	private BigDecimal r0490_31to90days_pastdues;
	private BigDecimal r0490_91to120days_pastdues;
	private BigDecimal r0490_121to180days_pastdues;
	private BigDecimal r0490_181to365days_pastdues;
	private BigDecimal r0490_over365days_pastdues;
	private BigDecimal r0490_total_pastdues;
	private BigDecimal r0490_newloan_duringreport;
	private BigDecimal r0490_newstage_duringreport;
	private BigDecimal r0490_intrestfees_duringreport;
	private BigDecimal r0490_performingac_acinfo;
	private BigDecimal r0490_nonperformingac_acinfo;
	private String r0500_product;
	private BigDecimal r0500_outstandbal;
	private BigDecimal r0500_secured_outstandbal;
	private BigDecimal r0500_unsecured_outstandbal;
	private BigDecimal r0500_stage1_assetclass;
	private BigDecimal r0500_stage2_assetclass;
	private BigDecimal r0500_stage3a_assetclass;
	private BigDecimal r0500_stage3b_assetclass;
	private BigDecimal r0500_stage3c_assetclass;
	private BigDecimal r0500_stage1_provisionheld;
	private BigDecimal r0500_stage2_provisionheld;
	private BigDecimal r0500_stage3a_provisionheld;
	private BigDecimal r0500_stage3b_provisionheld;
	private BigDecimal r0500_stage3c_provisionheld;
	private BigDecimal r0500_intrestfees_provisionheld;
	private BigDecimal r0500_intrestsuspense_provisionheld;
	private BigDecimal r0500_stage1_poci;
	private BigDecimal r0500_stage2_poci;
	private BigDecimal r0500_stage3a_poci;
	private BigDecimal r0500_stage3b_poci;
	private BigDecimal r0500_stage3c_poci;
	private BigDecimal r0500_current_pastdues;
	private BigDecimal r0500_less30days_pastdues;
	private BigDecimal r0500_31to90days_pastdues;
	private BigDecimal r0500_91to120days_pastdues;
	private BigDecimal r0500_121to180days_pastdues;
	private BigDecimal r0500_181to365days_pastdues;
	private BigDecimal r0500_over365days_pastdues;
	private BigDecimal r0500_total_pastdues;
	private BigDecimal r0500_newloan_duringreport;
	private BigDecimal r0500_newstage_duringreport;
	private BigDecimal r0500_intrestfees_duringreport;
	private BigDecimal r0500_performingac_acinfo;
	private BigDecimal r0500_nonperformingac_acinfo;
	private String r0510_product;
	private BigDecimal r0510_outstandbal;
	private BigDecimal r0510_secured_outstandbal;
	private BigDecimal r0510_unsecured_outstandbal;
	private BigDecimal r0510_stage1_assetclass;
	private BigDecimal r0510_stage2_assetclass;
	private BigDecimal r0510_stage3a_assetclass;
	private BigDecimal r0510_stage3b_assetclass;
	private BigDecimal r0510_stage3c_assetclass;
	private BigDecimal r0510_stage1_provisionheld;
	private BigDecimal r0510_stage2_provisionheld;
	private BigDecimal r0510_stage3a_provisionheld;
	private BigDecimal r0510_stage3b_provisionheld;
	private BigDecimal r0510_stage3c_provisionheld;
	private BigDecimal r0510_intrestfees_provisionheld;
	private BigDecimal r0510_intrestsuspense_provisionheld;
	private BigDecimal r0510_stage1_poci;
	private BigDecimal r0510_stage2_poci;
	private BigDecimal r0510_stage3a_poci;
	private BigDecimal r0510_stage3b_poci;
	private BigDecimal r0510_stage3c_poci;
	private BigDecimal r0510_current_pastdues;
	private BigDecimal r0510_less30days_pastdues;
	private BigDecimal r0510_31to90days_pastdues;
	private BigDecimal r0510_91to120days_pastdues;
	private BigDecimal r0510_121to180days_pastdues;
	private BigDecimal r0510_181to365days_pastdues;
	private BigDecimal r0510_over365days_pastdues;
	private BigDecimal r0510_total_pastdues;
	private BigDecimal r0510_newloan_duringreport;
	private BigDecimal r0510_newstage_duringreport;
	private BigDecimal r0510_intrestfees_duringreport;
	private BigDecimal r0510_performingac_acinfo;
	private BigDecimal r0510_nonperformingac_acinfo;
	private String r0520_product;
	private BigDecimal r0520_outstandbal;
	private BigDecimal r0520_secured_outstandbal;
	private BigDecimal r0520_unsecured_outstandbal;
	private BigDecimal r0520_stage1_assetclass;
	private BigDecimal r0520_stage2_assetclass;
	private BigDecimal r0520_stage3a_assetclass;
	private BigDecimal r0520_stage3b_assetclass;
	private BigDecimal r0520_stage3c_assetclass;
	private BigDecimal r0520_stage1_provisionheld;
	private BigDecimal r0520_stage2_provisionheld;
	private BigDecimal r0520_stage3a_provisionheld;
	private BigDecimal r0520_stage3b_provisionheld;
	private BigDecimal r0520_stage3c_provisionheld;
	private BigDecimal r0520_intrestfees_provisionheld;
	private BigDecimal r0520_intrestsuspense_provisionheld;
	private BigDecimal r0520_stage1_poci;
	private BigDecimal r0520_stage2_poci;
	private BigDecimal r0520_stage3a_poci;
	private BigDecimal r0520_stage3b_poci;
	private BigDecimal r0520_stage3c_poci;
	private BigDecimal r0520_current_pastdues;
	private BigDecimal r0520_less30days_pastdues;
	private BigDecimal r0520_31to90days_pastdues;
	private BigDecimal r0520_91to120days_pastdues;
	private BigDecimal r0520_121to180days_pastdues;
	private BigDecimal r0520_181to365days_pastdues;
	private BigDecimal r0520_over365days_pastdues;
	private BigDecimal r0520_total_pastdues;
	private BigDecimal r0520_newloan_duringreport;
	private BigDecimal r0520_newstage_duringreport;
	private BigDecimal r0520_intrestfees_duringreport;
	private BigDecimal r0520_performingac_acinfo;
	private BigDecimal r0520_nonperformingac_acinfo;
	private String r0530_product;
	private BigDecimal r0530_outstandbal;
	private BigDecimal r0530_secured_outstandbal;
	private BigDecimal r0530_unsecured_outstandbal;
	private BigDecimal r0530_stage1_assetclass;
	private BigDecimal r0530_stage2_assetclass;
	private BigDecimal r0530_stage3a_assetclass;
	private BigDecimal r0530_stage3b_assetclass;
	private BigDecimal r0530_stage3c_assetclass;
	private BigDecimal r0530_stage1_provisionheld;
	private BigDecimal r0530_stage2_provisionheld;
	private BigDecimal r0530_stage3a_provisionheld;
	private BigDecimal r0530_stage3b_provisionheld;
	private BigDecimal r0530_stage3c_provisionheld;
	private BigDecimal r0530_intrestfees_provisionheld;
	private BigDecimal r0530_intrestsuspense_provisionheld;
	private BigDecimal r0530_stage1_poci;
	private BigDecimal r0530_stage2_poci;
	private BigDecimal r0530_stage3a_poci;
	private BigDecimal r0530_stage3b_poci;
	private BigDecimal r0530_stage3c_poci;
	private BigDecimal r0530_current_pastdues;
	private BigDecimal r0530_less30days_pastdues;
	private BigDecimal r0530_31to90days_pastdues;
	private BigDecimal r0530_91to120days_pastdues;
	private BigDecimal r0530_121to180days_pastdues;
	private BigDecimal r0530_181to365days_pastdues;
	private BigDecimal r0530_over365days_pastdues;
	private BigDecimal r0530_total_pastdues;
	private BigDecimal r0530_newloan_duringreport;
	private BigDecimal r0530_newstage_duringreport;
	private BigDecimal r0530_intrestfees_duringreport;
	private BigDecimal r0530_performingac_acinfo;
	private BigDecimal r0530_nonperformingac_acinfo;
	private String r0540_product;
	private BigDecimal r0540_outstandbal;
	private BigDecimal r0540_secured_outstandbal;
	private BigDecimal r0540_unsecured_outstandbal;
	private BigDecimal r0540_stage1_assetclass;
	private BigDecimal r0540_stage2_assetclass;
	private BigDecimal r0540_stage3a_assetclass;
	private BigDecimal r0540_stage3b_assetclass;
	private BigDecimal r0540_stage3c_assetclass;
	private BigDecimal r0540_stage1_provisionheld;
	private BigDecimal r0540_stage2_provisionheld;
	private BigDecimal r0540_stage3a_provisionheld;
	private BigDecimal r0540_stage3b_provisionheld;
	private BigDecimal r0540_stage3c_provisionheld;
	private BigDecimal r0540_intrestfees_provisionheld;
	private BigDecimal r0540_intrestsuspense_provisionheld;
	private BigDecimal r0540_stage1_poci;
	private BigDecimal r0540_stage2_poci;
	private BigDecimal r0540_stage3a_poci;
	private BigDecimal r0540_stage3b_poci;
	private BigDecimal r0540_stage3c_poci;
	private BigDecimal r0540_current_pastdues;
	private BigDecimal r0540_less30days_pastdues;
	private BigDecimal r0540_31to90days_pastdues;
	private BigDecimal r0540_91to120days_pastdues;
	private BigDecimal r0540_121to180days_pastdues;
	private BigDecimal r0540_181to365days_pastdues;
	private BigDecimal r0540_over365days_pastdues;
	private BigDecimal r0540_total_pastdues;
	private BigDecimal r0540_newloan_duringreport;
	private BigDecimal r0540_newstage_duringreport;
	private BigDecimal r0540_intrestfees_duringreport;
	private BigDecimal r0540_performingac_acinfo;
	private BigDecimal r0540_nonperformingac_acinfo;
	private String r0550_product;
	private BigDecimal r0550_outstandbal;
	private BigDecimal r0550_secured_outstandbal;
	private BigDecimal r0550_unsecured_outstandbal;
	private BigDecimal r0550_stage1_assetclass;
	private BigDecimal r0550_stage2_assetclass;
	private BigDecimal r0550_stage3a_assetclass;
	private BigDecimal r0550_stage3b_assetclass;
	private BigDecimal r0550_stage3c_assetclass;
	private BigDecimal r0550_stage1_provisionheld;
	private BigDecimal r0550_stage2_provisionheld;
	private BigDecimal r0550_stage3a_provisionheld;
	private BigDecimal r0550_stage3b_provisionheld;
	private BigDecimal r0550_stage3c_provisionheld;
	private BigDecimal r0550_intrestfees_provisionheld;
	private BigDecimal r0550_intrestsuspense_provisionheld;
	private BigDecimal r0550_stage1_poci;
	private BigDecimal r0550_stage2_poci;
	private BigDecimal r0550_stage3a_poci;
	private BigDecimal r0550_stage3b_poci;
	private BigDecimal r0550_stage3c_poci;
	private BigDecimal r0550_current_pastdues;
	private BigDecimal r0550_less30days_pastdues;
	private BigDecimal r0550_31to90days_pastdues;
	private BigDecimal r0550_91to120days_pastdues;
	private BigDecimal r0550_121to180days_pastdues;
	private BigDecimal r0550_181to365days_pastdues;
	private BigDecimal r0550_over365days_pastdues;
	private BigDecimal r0550_total_pastdues;
	private BigDecimal r0550_newloan_duringreport;
	private BigDecimal r0550_newstage_duringreport;
	private BigDecimal r0550_intrestfees_duringreport;
	private BigDecimal r0550_performingac_acinfo;
	private BigDecimal r0550_nonperformingac_acinfo;
	private String r0560_product;
	private BigDecimal r0560_outstandbal;
	private BigDecimal r0560_secured_outstandbal;
	private BigDecimal r0560_unsecured_outstandbal;
	private BigDecimal r0560_stage1_assetclass;
	private BigDecimal r0560_stage2_assetclass;
	private BigDecimal r0560_stage3a_assetclass;
	private BigDecimal r0560_stage3b_assetclass;
	private BigDecimal r0560_stage3c_assetclass;
	private BigDecimal r0560_stage1_provisionheld;
	private BigDecimal r0560_stage2_provisionheld;
	private BigDecimal r0560_stage3a_provisionheld;
	private BigDecimal r0560_stage3b_provisionheld;
	private BigDecimal r0560_stage3c_provisionheld;
	private BigDecimal r0560_intrestfees_provisionheld;
	private BigDecimal r0560_intrestsuspense_provisionheld;
	private BigDecimal r0560_stage1_poci;
	private BigDecimal r0560_stage2_poci;
	private BigDecimal r0560_stage3a_poci;
	private BigDecimal r0560_stage3b_poci;
	private BigDecimal r0560_stage3c_poci;
	private BigDecimal r0560_current_pastdues;
	private BigDecimal r0560_less30days_pastdues;
	private BigDecimal r0560_31to90days_pastdues;
	private BigDecimal r0560_91to120days_pastdues;
	private BigDecimal r0560_121to180days_pastdues;
	private BigDecimal r0560_181to365days_pastdues;
	private BigDecimal r0560_over365days_pastdues;
	private BigDecimal r0560_total_pastdues;
	private BigDecimal r0560_newloan_duringreport;
	private BigDecimal r0560_newstage_duringreport;
	private BigDecimal r0560_intrestfees_duringreport;
	private BigDecimal r0560_performingac_acinfo;
	private BigDecimal r0560_nonperformingac_acinfo;
	private String r0570_product;
	private BigDecimal r0570_outstandbal;
	private BigDecimal r0570_secured_outstandbal;
	private BigDecimal r0570_unsecured_outstandbal;
	private BigDecimal r0570_stage1_assetclass;
	private BigDecimal r0570_stage2_assetclass;
	private BigDecimal r0570_stage3a_assetclass;
	private BigDecimal r0570_stage3b_assetclass;
	private BigDecimal r0570_stage3c_assetclass;
	private BigDecimal r0570_stage1_provisionheld;
	private BigDecimal r0570_stage2_provisionheld;
	private BigDecimal r0570_stage3a_provisionheld;
	private BigDecimal r0570_stage3b_provisionheld;
	private BigDecimal r0570_stage3c_provisionheld;
	private BigDecimal r0570_intrestfees_provisionheld;
	private BigDecimal r0570_intrestsuspense_provisionheld;
	private BigDecimal r0570_stage1_poci;
	private BigDecimal r0570_stage2_poci;
	private BigDecimal r0570_stage3a_poci;
	private BigDecimal r0570_stage3b_poci;
	private BigDecimal r0570_stage3c_poci;
	private BigDecimal r0570_current_pastdues;
	private BigDecimal r0570_less30days_pastdues;
	private BigDecimal r0570_31to90days_pastdues;
	private BigDecimal r0570_91to120days_pastdues;
	private BigDecimal r0570_121to180days_pastdues;
	private BigDecimal r0570_181to365days_pastdues;
	private BigDecimal r0570_over365days_pastdues;
	private BigDecimal r0570_total_pastdues;
	private BigDecimal r0570_newloan_duringreport;
	private BigDecimal r0570_newstage_duringreport;
	private BigDecimal r0570_intrestfees_duringreport;
	private BigDecimal r0570_performingac_acinfo;
	private BigDecimal r0570_nonperformingac_acinfo;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id

	private Date report_date;
	private String report_version;
	private String report_frequency;
	private String report_code;
	private String report_desc;
	private String modify_flg;
	private String entity_flg;
	private String delete_flg;

	public String getR0300_product() {
		return r0300_product;
	}

	public void setR0300_product(String r0300_product) {
		this.r0300_product = r0300_product;
	}

	public BigDecimal getR0300_outstandbal() {
		return r0300_outstandbal;
	}

	public void setR0300_outstandbal(BigDecimal r0300_outstandbal) {
		this.r0300_outstandbal = r0300_outstandbal;
	}

	public BigDecimal getR0300_secured_outstandbal() {
		return r0300_secured_outstandbal;
	}

	public void setR0300_secured_outstandbal(BigDecimal r0300_secured_outstandbal) {
		this.r0300_secured_outstandbal = r0300_secured_outstandbal;
	}

	public BigDecimal getR0300_unsecured_outstandbal() {
		return r0300_unsecured_outstandbal;
	}

	public void setR0300_unsecured_outstandbal(BigDecimal r0300_unsecured_outstandbal) {
		this.r0300_unsecured_outstandbal = r0300_unsecured_outstandbal;
	}

	public BigDecimal getR0300_stage1_assetclass() {
		return r0300_stage1_assetclass;
	}

	public void setR0300_stage1_assetclass(BigDecimal r0300_stage1_assetclass) {
		this.r0300_stage1_assetclass = r0300_stage1_assetclass;
	}

	public BigDecimal getR0300_stage2_assetclass() {
		return r0300_stage2_assetclass;
	}

	public void setR0300_stage2_assetclass(BigDecimal r0300_stage2_assetclass) {
		this.r0300_stage2_assetclass = r0300_stage2_assetclass;
	}

	public BigDecimal getR0300_stage3a_assetclass() {
		return r0300_stage3a_assetclass;
	}

	public void setR0300_stage3a_assetclass(BigDecimal r0300_stage3a_assetclass) {
		this.r0300_stage3a_assetclass = r0300_stage3a_assetclass;
	}

	public BigDecimal getR0300_stage3b_assetclass() {
		return r0300_stage3b_assetclass;
	}

	public void setR0300_stage3b_assetclass(BigDecimal r0300_stage3b_assetclass) {
		this.r0300_stage3b_assetclass = r0300_stage3b_assetclass;
	}

	public BigDecimal getR0300_stage3c_assetclass() {
		return r0300_stage3c_assetclass;
	}

	public void setR0300_stage3c_assetclass(BigDecimal r0300_stage3c_assetclass) {
		this.r0300_stage3c_assetclass = r0300_stage3c_assetclass;
	}

	public BigDecimal getR0300_stage1_provisionheld() {
		return r0300_stage1_provisionheld;
	}

	public void setR0300_stage1_provisionheld(BigDecimal r0300_stage1_provisionheld) {
		this.r0300_stage1_provisionheld = r0300_stage1_provisionheld;
	}

	public BigDecimal getR0300_stage2_provisionheld() {
		return r0300_stage2_provisionheld;
	}

	public void setR0300_stage2_provisionheld(BigDecimal r0300_stage2_provisionheld) {
		this.r0300_stage2_provisionheld = r0300_stage2_provisionheld;
	}

	public BigDecimal getR0300_stage3a_provisionheld() {
		return r0300_stage3a_provisionheld;
	}

	public void setR0300_stage3a_provisionheld(BigDecimal r0300_stage3a_provisionheld) {
		this.r0300_stage3a_provisionheld = r0300_stage3a_provisionheld;
	}

	public BigDecimal getR0300_stage3b_provisionheld() {
		return r0300_stage3b_provisionheld;
	}

	public void setR0300_stage3b_provisionheld(BigDecimal r0300_stage3b_provisionheld) {
		this.r0300_stage3b_provisionheld = r0300_stage3b_provisionheld;
	}

	public BigDecimal getR0300_stage3c_provisionheld() {
		return r0300_stage3c_provisionheld;
	}

	public void setR0300_stage3c_provisionheld(BigDecimal r0300_stage3c_provisionheld) {
		this.r0300_stage3c_provisionheld = r0300_stage3c_provisionheld;
	}

	public BigDecimal getR0300_intrestfees_provisionheld() {
		return r0300_intrestfees_provisionheld;
	}

	public void setR0300_intrestfees_provisionheld(BigDecimal r0300_intrestfees_provisionheld) {
		this.r0300_intrestfees_provisionheld = r0300_intrestfees_provisionheld;
	}

	public BigDecimal getR0300_intrestsuspense_provisionheld() {
		return r0300_intrestsuspense_provisionheld;
	}

	public void setR0300_intrestsuspense_provisionheld(BigDecimal r0300_intrestsuspense_provisionheld) {
		this.r0300_intrestsuspense_provisionheld = r0300_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0300_stage1_poci() {
		return r0300_stage1_poci;
	}

	public void setR0300_stage1_poci(BigDecimal r0300_stage1_poci) {
		this.r0300_stage1_poci = r0300_stage1_poci;
	}

	public BigDecimal getR0300_stage2_poci() {
		return r0300_stage2_poci;
	}

	public void setR0300_stage2_poci(BigDecimal r0300_stage2_poci) {
		this.r0300_stage2_poci = r0300_stage2_poci;
	}

	public BigDecimal getR0300_stage3a_poci() {
		return r0300_stage3a_poci;
	}

	public void setR0300_stage3a_poci(BigDecimal r0300_stage3a_poci) {
		this.r0300_stage3a_poci = r0300_stage3a_poci;
	}

	public BigDecimal getR0300_stage3b_poci() {
		return r0300_stage3b_poci;
	}

	public void setR0300_stage3b_poci(BigDecimal r0300_stage3b_poci) {
		this.r0300_stage3b_poci = r0300_stage3b_poci;
	}

	public BigDecimal getR0300_stage3c_poci() {
		return r0300_stage3c_poci;
	}

	public void setR0300_stage3c_poci(BigDecimal r0300_stage3c_poci) {
		this.r0300_stage3c_poci = r0300_stage3c_poci;
	}

	public BigDecimal getR0300_current_pastdues() {
		return r0300_current_pastdues;
	}

	public void setR0300_current_pastdues(BigDecimal r0300_current_pastdues) {
		this.r0300_current_pastdues = r0300_current_pastdues;
	}

	public BigDecimal getR0300_less30days_pastdues() {
		return r0300_less30days_pastdues;
	}

	public void setR0300_less30days_pastdues(BigDecimal r0300_less30days_pastdues) {
		this.r0300_less30days_pastdues = r0300_less30days_pastdues;
	}

	public BigDecimal getR0300_31to90days_pastdues() {
		return r0300_31to90days_pastdues;
	}

	public void setR0300_31to90days_pastdues(BigDecimal r0300_31to90days_pastdues) {
		this.r0300_31to90days_pastdues = r0300_31to90days_pastdues;
	}

	public BigDecimal getR0300_91to120days_pastdues() {
		return r0300_91to120days_pastdues;
	}

	public void setR0300_91to120days_pastdues(BigDecimal r0300_91to120days_pastdues) {
		this.r0300_91to120days_pastdues = r0300_91to120days_pastdues;
	}

	public BigDecimal getR0300_121to180days_pastdues() {
		return r0300_121to180days_pastdues;
	}

	public void setR0300_121to180days_pastdues(BigDecimal r0300_121to180days_pastdues) {
		this.r0300_121to180days_pastdues = r0300_121to180days_pastdues;
	}

	public BigDecimal getR0300_181to365days_pastdues() {
		return r0300_181to365days_pastdues;
	}

	public void setR0300_181to365days_pastdues(BigDecimal r0300_181to365days_pastdues) {
		this.r0300_181to365days_pastdues = r0300_181to365days_pastdues;
	}

	public BigDecimal getR0300_over365days_pastdues() {
		return r0300_over365days_pastdues;
	}

	public void setR0300_over365days_pastdues(BigDecimal r0300_over365days_pastdues) {
		this.r0300_over365days_pastdues = r0300_over365days_pastdues;
	}

	public BigDecimal getR0300_total_pastdues() {
		return r0300_total_pastdues;
	}

	public void setR0300_total_pastdues(BigDecimal r0300_total_pastdues) {
		this.r0300_total_pastdues = r0300_total_pastdues;
	}

	public BigDecimal getR0300_newloan_duringreport() {
		return r0300_newloan_duringreport;
	}

	public void setR0300_newloan_duringreport(BigDecimal r0300_newloan_duringreport) {
		this.r0300_newloan_duringreport = r0300_newloan_duringreport;
	}

	public BigDecimal getR0300_newstage_duringreport() {
		return r0300_newstage_duringreport;
	}

	public void setR0300_newstage_duringreport(BigDecimal r0300_newstage_duringreport) {
		this.r0300_newstage_duringreport = r0300_newstage_duringreport;
	}

	public BigDecimal getR0300_intrestfees_duringreport() {
		return r0300_intrestfees_duringreport;
	}

	public void setR0300_intrestfees_duringreport(BigDecimal r0300_intrestfees_duringreport) {
		this.r0300_intrestfees_duringreport = r0300_intrestfees_duringreport;
	}

	public BigDecimal getR0300_performingac_acinfo() {
		return r0300_performingac_acinfo;
	}

	public void setR0300_performingac_acinfo(BigDecimal r0300_performingac_acinfo) {
		this.r0300_performingac_acinfo = r0300_performingac_acinfo;
	}

	public BigDecimal getR0300_nonperformingac_acinfo() {
		return r0300_nonperformingac_acinfo;
	}

	public void setR0300_nonperformingac_acinfo(BigDecimal r0300_nonperformingac_acinfo) {
		this.r0300_nonperformingac_acinfo = r0300_nonperformingac_acinfo;
	}

	public String getR0310_product() {
		return r0310_product;
	}

	public void setR0310_product(String r0310_product) {
		this.r0310_product = r0310_product;
	}

	public BigDecimal getR0310_outstandbal() {
		return r0310_outstandbal;
	}

	public void setR0310_outstandbal(BigDecimal r0310_outstandbal) {
		this.r0310_outstandbal = r0310_outstandbal;
	}

	public BigDecimal getR0310_secured_outstandbal() {
		return r0310_secured_outstandbal;
	}

	public void setR0310_secured_outstandbal(BigDecimal r0310_secured_outstandbal) {
		this.r0310_secured_outstandbal = r0310_secured_outstandbal;
	}

	public BigDecimal getR0310_unsecured_outstandbal() {
		return r0310_unsecured_outstandbal;
	}

	public void setR0310_unsecured_outstandbal(BigDecimal r0310_unsecured_outstandbal) {
		this.r0310_unsecured_outstandbal = r0310_unsecured_outstandbal;
	}

	public BigDecimal getR0310_stage1_assetclass() {
		return r0310_stage1_assetclass;
	}

	public void setR0310_stage1_assetclass(BigDecimal r0310_stage1_assetclass) {
		this.r0310_stage1_assetclass = r0310_stage1_assetclass;
	}

	public BigDecimal getR0310_stage2_assetclass() {
		return r0310_stage2_assetclass;
	}

	public void setR0310_stage2_assetclass(BigDecimal r0310_stage2_assetclass) {
		this.r0310_stage2_assetclass = r0310_stage2_assetclass;
	}

	public BigDecimal getR0310_stage3a_assetclass() {
		return r0310_stage3a_assetclass;
	}

	public void setR0310_stage3a_assetclass(BigDecimal r0310_stage3a_assetclass) {
		this.r0310_stage3a_assetclass = r0310_stage3a_assetclass;
	}

	public BigDecimal getR0310_stage3b_assetclass() {
		return r0310_stage3b_assetclass;
	}

	public void setR0310_stage3b_assetclass(BigDecimal r0310_stage3b_assetclass) {
		this.r0310_stage3b_assetclass = r0310_stage3b_assetclass;
	}

	public BigDecimal getR0310_stage3c_assetclass() {
		return r0310_stage3c_assetclass;
	}

	public void setR0310_stage3c_assetclass(BigDecimal r0310_stage3c_assetclass) {
		this.r0310_stage3c_assetclass = r0310_stage3c_assetclass;
	}

	public BigDecimal getR0310_stage1_provisionheld() {
		return r0310_stage1_provisionheld;
	}

	public void setR0310_stage1_provisionheld(BigDecimal r0310_stage1_provisionheld) {
		this.r0310_stage1_provisionheld = r0310_stage1_provisionheld;
	}

	public BigDecimal getR0310_stage2_provisionheld() {
		return r0310_stage2_provisionheld;
	}

	public void setR0310_stage2_provisionheld(BigDecimal r0310_stage2_provisionheld) {
		this.r0310_stage2_provisionheld = r0310_stage2_provisionheld;
	}

	public BigDecimal getR0310_stage3a_provisionheld() {
		return r0310_stage3a_provisionheld;
	}

	public void setR0310_stage3a_provisionheld(BigDecimal r0310_stage3a_provisionheld) {
		this.r0310_stage3a_provisionheld = r0310_stage3a_provisionheld;
	}

	public BigDecimal getR0310_stage3b_provisionheld() {
		return r0310_stage3b_provisionheld;
	}

	public void setR0310_stage3b_provisionheld(BigDecimal r0310_stage3b_provisionheld) {
		this.r0310_stage3b_provisionheld = r0310_stage3b_provisionheld;
	}

	public BigDecimal getR0310_stage3c_provisionheld() {
		return r0310_stage3c_provisionheld;
	}

	public void setR0310_stage3c_provisionheld(BigDecimal r0310_stage3c_provisionheld) {
		this.r0310_stage3c_provisionheld = r0310_stage3c_provisionheld;
	}

	public BigDecimal getR0310_intrestfees_provisionheld() {
		return r0310_intrestfees_provisionheld;
	}

	public void setR0310_intrestfees_provisionheld(BigDecimal r0310_intrestfees_provisionheld) {
		this.r0310_intrestfees_provisionheld = r0310_intrestfees_provisionheld;
	}

	public BigDecimal getR0310_intrestsuspense_provisionheld() {
		return r0310_intrestsuspense_provisionheld;
	}

	public void setR0310_intrestsuspense_provisionheld(BigDecimal r0310_intrestsuspense_provisionheld) {
		this.r0310_intrestsuspense_provisionheld = r0310_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0310_stage1_poci() {
		return r0310_stage1_poci;
	}

	public void setR0310_stage1_poci(BigDecimal r0310_stage1_poci) {
		this.r0310_stage1_poci = r0310_stage1_poci;
	}

	public BigDecimal getR0310_stage2_poci() {
		return r0310_stage2_poci;
	}

	public void setR0310_stage2_poci(BigDecimal r0310_stage2_poci) {
		this.r0310_stage2_poci = r0310_stage2_poci;
	}

	public BigDecimal getR0310_stage3a_poci() {
		return r0310_stage3a_poci;
	}

	public void setR0310_stage3a_poci(BigDecimal r0310_stage3a_poci) {
		this.r0310_stage3a_poci = r0310_stage3a_poci;
	}

	public BigDecimal getR0310_stage3b_poci() {
		return r0310_stage3b_poci;
	}

	public void setR0310_stage3b_poci(BigDecimal r0310_stage3b_poci) {
		this.r0310_stage3b_poci = r0310_stage3b_poci;
	}

	public BigDecimal getR0310_stage3c_poci() {
		return r0310_stage3c_poci;
	}

	public void setR0310_stage3c_poci(BigDecimal r0310_stage3c_poci) {
		this.r0310_stage3c_poci = r0310_stage3c_poci;
	}

	public BigDecimal getR0310_current_pastdues() {
		return r0310_current_pastdues;
	}

	public void setR0310_current_pastdues(BigDecimal r0310_current_pastdues) {
		this.r0310_current_pastdues = r0310_current_pastdues;
	}

	public BigDecimal getR0310_less30days_pastdues() {
		return r0310_less30days_pastdues;
	}

	public void setR0310_less30days_pastdues(BigDecimal r0310_less30days_pastdues) {
		this.r0310_less30days_pastdues = r0310_less30days_pastdues;
	}

	public BigDecimal getR0310_31to90days_pastdues() {
		return r0310_31to90days_pastdues;
	}

	public void setR0310_31to90days_pastdues(BigDecimal r0310_31to90days_pastdues) {
		this.r0310_31to90days_pastdues = r0310_31to90days_pastdues;
	}

	public BigDecimal getR0310_91to120days_pastdues() {
		return r0310_91to120days_pastdues;
	}

	public void setR0310_91to120days_pastdues(BigDecimal r0310_91to120days_pastdues) {
		this.r0310_91to120days_pastdues = r0310_91to120days_pastdues;
	}

	public BigDecimal getR0310_121to180days_pastdues() {
		return r0310_121to180days_pastdues;
	}

	public void setR0310_121to180days_pastdues(BigDecimal r0310_121to180days_pastdues) {
		this.r0310_121to180days_pastdues = r0310_121to180days_pastdues;
	}

	public BigDecimal getR0310_181to365days_pastdues() {
		return r0310_181to365days_pastdues;
	}

	public void setR0310_181to365days_pastdues(BigDecimal r0310_181to365days_pastdues) {
		this.r0310_181to365days_pastdues = r0310_181to365days_pastdues;
	}

	public BigDecimal getR0310_over365days_pastdues() {
		return r0310_over365days_pastdues;
	}

	public void setR0310_over365days_pastdues(BigDecimal r0310_over365days_pastdues) {
		this.r0310_over365days_pastdues = r0310_over365days_pastdues;
	}

	public BigDecimal getR0310_total_pastdues() {
		return r0310_total_pastdues;
	}

	public void setR0310_total_pastdues(BigDecimal r0310_total_pastdues) {
		this.r0310_total_pastdues = r0310_total_pastdues;
	}

	public BigDecimal getR0310_newloan_duringreport() {
		return r0310_newloan_duringreport;
	}

	public void setR0310_newloan_duringreport(BigDecimal r0310_newloan_duringreport) {
		this.r0310_newloan_duringreport = r0310_newloan_duringreport;
	}

	public BigDecimal getR0310_newstage_duringreport() {
		return r0310_newstage_duringreport;
	}

	public void setR0310_newstage_duringreport(BigDecimal r0310_newstage_duringreport) {
		this.r0310_newstage_duringreport = r0310_newstage_duringreport;
	}

	public BigDecimal getR0310_intrestfees_duringreport() {
		return r0310_intrestfees_duringreport;
	}

	public void setR0310_intrestfees_duringreport(BigDecimal r0310_intrestfees_duringreport) {
		this.r0310_intrestfees_duringreport = r0310_intrestfees_duringreport;
	}

	public BigDecimal getR0310_performingac_acinfo() {
		return r0310_performingac_acinfo;
	}

	public void setR0310_performingac_acinfo(BigDecimal r0310_performingac_acinfo) {
		this.r0310_performingac_acinfo = r0310_performingac_acinfo;
	}

	public BigDecimal getR0310_nonperformingac_acinfo() {
		return r0310_nonperformingac_acinfo;
	}

	public void setR0310_nonperformingac_acinfo(BigDecimal r0310_nonperformingac_acinfo) {
		this.r0310_nonperformingac_acinfo = r0310_nonperformingac_acinfo;
	}

	public String getR0320_product() {
		return r0320_product;
	}

	public void setR0320_product(String r0320_product) {
		this.r0320_product = r0320_product;
	}

	public BigDecimal getR0320_outstandbal() {
		return r0320_outstandbal;
	}

	public void setR0320_outstandbal(BigDecimal r0320_outstandbal) {
		this.r0320_outstandbal = r0320_outstandbal;
	}

	public BigDecimal getR0320_secured_outstandbal() {
		return r0320_secured_outstandbal;
	}

	public void setR0320_secured_outstandbal(BigDecimal r0320_secured_outstandbal) {
		this.r0320_secured_outstandbal = r0320_secured_outstandbal;
	}

	public BigDecimal getR0320_unsecured_outstandbal() {
		return r0320_unsecured_outstandbal;
	}

	public void setR0320_unsecured_outstandbal(BigDecimal r0320_unsecured_outstandbal) {
		this.r0320_unsecured_outstandbal = r0320_unsecured_outstandbal;
	}

	public BigDecimal getR0320_stage1_assetclass() {
		return r0320_stage1_assetclass;
	}

	public void setR0320_stage1_assetclass(BigDecimal r0320_stage1_assetclass) {
		this.r0320_stage1_assetclass = r0320_stage1_assetclass;
	}

	public BigDecimal getR0320_stage2_assetclass() {
		return r0320_stage2_assetclass;
	}

	public void setR0320_stage2_assetclass(BigDecimal r0320_stage2_assetclass) {
		this.r0320_stage2_assetclass = r0320_stage2_assetclass;
	}

	public BigDecimal getR0320_stage3a_assetclass() {
		return r0320_stage3a_assetclass;
	}

	public void setR0320_stage3a_assetclass(BigDecimal r0320_stage3a_assetclass) {
		this.r0320_stage3a_assetclass = r0320_stage3a_assetclass;
	}

	public BigDecimal getR0320_stage3b_assetclass() {
		return r0320_stage3b_assetclass;
	}

	public void setR0320_stage3b_assetclass(BigDecimal r0320_stage3b_assetclass) {
		this.r0320_stage3b_assetclass = r0320_stage3b_assetclass;
	}

	public BigDecimal getR0320_stage3c_assetclass() {
		return r0320_stage3c_assetclass;
	}

	public void setR0320_stage3c_assetclass(BigDecimal r0320_stage3c_assetclass) {
		this.r0320_stage3c_assetclass = r0320_stage3c_assetclass;
	}

	public BigDecimal getR0320_stage1_provisionheld() {
		return r0320_stage1_provisionheld;
	}

	public void setR0320_stage1_provisionheld(BigDecimal r0320_stage1_provisionheld) {
		this.r0320_stage1_provisionheld = r0320_stage1_provisionheld;
	}

	public BigDecimal getR0320_stage2_provisionheld() {
		return r0320_stage2_provisionheld;
	}

	public void setR0320_stage2_provisionheld(BigDecimal r0320_stage2_provisionheld) {
		this.r0320_stage2_provisionheld = r0320_stage2_provisionheld;
	}

	public BigDecimal getR0320_stage3a_provisionheld() {
		return r0320_stage3a_provisionheld;
	}

	public void setR0320_stage3a_provisionheld(BigDecimal r0320_stage3a_provisionheld) {
		this.r0320_stage3a_provisionheld = r0320_stage3a_provisionheld;
	}

	public BigDecimal getR0320_stage3b_provisionheld() {
		return r0320_stage3b_provisionheld;
	}

	public void setR0320_stage3b_provisionheld(BigDecimal r0320_stage3b_provisionheld) {
		this.r0320_stage3b_provisionheld = r0320_stage3b_provisionheld;
	}

	public BigDecimal getR0320_stage3c_provisionheld() {
		return r0320_stage3c_provisionheld;
	}

	public void setR0320_stage3c_provisionheld(BigDecimal r0320_stage3c_provisionheld) {
		this.r0320_stage3c_provisionheld = r0320_stage3c_provisionheld;
	}

	public BigDecimal getR0320_intrestfees_provisionheld() {
		return r0320_intrestfees_provisionheld;
	}

	public void setR0320_intrestfees_provisionheld(BigDecimal r0320_intrestfees_provisionheld) {
		this.r0320_intrestfees_provisionheld = r0320_intrestfees_provisionheld;
	}

	public BigDecimal getR0320_intrestsuspense_provisionheld() {
		return r0320_intrestsuspense_provisionheld;
	}

	public void setR0320_intrestsuspense_provisionheld(BigDecimal r0320_intrestsuspense_provisionheld) {
		this.r0320_intrestsuspense_provisionheld = r0320_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0320_stage1_poci() {
		return r0320_stage1_poci;
	}

	public void setR0320_stage1_poci(BigDecimal r0320_stage1_poci) {
		this.r0320_stage1_poci = r0320_stage1_poci;
	}

	public BigDecimal getR0320_stage2_poci() {
		return r0320_stage2_poci;
	}

	public void setR0320_stage2_poci(BigDecimal r0320_stage2_poci) {
		this.r0320_stage2_poci = r0320_stage2_poci;
	}

	public BigDecimal getR0320_stage3a_poci() {
		return r0320_stage3a_poci;
	}

	public void setR0320_stage3a_poci(BigDecimal r0320_stage3a_poci) {
		this.r0320_stage3a_poci = r0320_stage3a_poci;
	}

	public BigDecimal getR0320_stage3b_poci() {
		return r0320_stage3b_poci;
	}

	public void setR0320_stage3b_poci(BigDecimal r0320_stage3b_poci) {
		this.r0320_stage3b_poci = r0320_stage3b_poci;
	}

	public BigDecimal getR0320_stage3c_poci() {
		return r0320_stage3c_poci;
	}

	public void setR0320_stage3c_poci(BigDecimal r0320_stage3c_poci) {
		this.r0320_stage3c_poci = r0320_stage3c_poci;
	}

	public BigDecimal getR0320_current_pastdues() {
		return r0320_current_pastdues;
	}

	public void setR0320_current_pastdues(BigDecimal r0320_current_pastdues) {
		this.r0320_current_pastdues = r0320_current_pastdues;
	}

	public BigDecimal getR0320_less30days_pastdues() {
		return r0320_less30days_pastdues;
	}

	public void setR0320_less30days_pastdues(BigDecimal r0320_less30days_pastdues) {
		this.r0320_less30days_pastdues = r0320_less30days_pastdues;
	}

	public BigDecimal getR0320_31to90days_pastdues() {
		return r0320_31to90days_pastdues;
	}

	public void setR0320_31to90days_pastdues(BigDecimal r0320_31to90days_pastdues) {
		this.r0320_31to90days_pastdues = r0320_31to90days_pastdues;
	}

	public BigDecimal getR0320_91to120days_pastdues() {
		return r0320_91to120days_pastdues;
	}

	public void setR0320_91to120days_pastdues(BigDecimal r0320_91to120days_pastdues) {
		this.r0320_91to120days_pastdues = r0320_91to120days_pastdues;
	}

	public BigDecimal getR0320_121to180days_pastdues() {
		return r0320_121to180days_pastdues;
	}

	public void setR0320_121to180days_pastdues(BigDecimal r0320_121to180days_pastdues) {
		this.r0320_121to180days_pastdues = r0320_121to180days_pastdues;
	}

	public BigDecimal getR0320_181to365days_pastdues() {
		return r0320_181to365days_pastdues;
	}

	public void setR0320_181to365days_pastdues(BigDecimal r0320_181to365days_pastdues) {
		this.r0320_181to365days_pastdues = r0320_181to365days_pastdues;
	}

	public BigDecimal getR0320_over365days_pastdues() {
		return r0320_over365days_pastdues;
	}

	public void setR0320_over365days_pastdues(BigDecimal r0320_over365days_pastdues) {
		this.r0320_over365days_pastdues = r0320_over365days_pastdues;
	}

	public BigDecimal getR0320_total_pastdues() {
		return r0320_total_pastdues;
	}

	public void setR0320_total_pastdues(BigDecimal r0320_total_pastdues) {
		this.r0320_total_pastdues = r0320_total_pastdues;
	}

	public BigDecimal getR0320_newloan_duringreport() {
		return r0320_newloan_duringreport;
	}

	public void setR0320_newloan_duringreport(BigDecimal r0320_newloan_duringreport) {
		this.r0320_newloan_duringreport = r0320_newloan_duringreport;
	}

	public BigDecimal getR0320_newstage_duringreport() {
		return r0320_newstage_duringreport;
	}

	public void setR0320_newstage_duringreport(BigDecimal r0320_newstage_duringreport) {
		this.r0320_newstage_duringreport = r0320_newstage_duringreport;
	}

	public BigDecimal getR0320_intrestfees_duringreport() {
		return r0320_intrestfees_duringreport;
	}

	public void setR0320_intrestfees_duringreport(BigDecimal r0320_intrestfees_duringreport) {
		this.r0320_intrestfees_duringreport = r0320_intrestfees_duringreport;
	}

	public BigDecimal getR0320_performingac_acinfo() {
		return r0320_performingac_acinfo;
	}

	public void setR0320_performingac_acinfo(BigDecimal r0320_performingac_acinfo) {
		this.r0320_performingac_acinfo = r0320_performingac_acinfo;
	}

	public BigDecimal getR0320_nonperformingac_acinfo() {
		return r0320_nonperformingac_acinfo;
	}

	public void setR0320_nonperformingac_acinfo(BigDecimal r0320_nonperformingac_acinfo) {
		this.r0320_nonperformingac_acinfo = r0320_nonperformingac_acinfo;
	}

	public String getR0330_product() {
		return r0330_product;
	}

	public void setR0330_product(String r0330_product) {
		this.r0330_product = r0330_product;
	}

	public BigDecimal getR0330_outstandbal() {
		return r0330_outstandbal;
	}

	public void setR0330_outstandbal(BigDecimal r0330_outstandbal) {
		this.r0330_outstandbal = r0330_outstandbal;
	}

	public BigDecimal getR0330_secured_outstandbal() {
		return r0330_secured_outstandbal;
	}

	public void setR0330_secured_outstandbal(BigDecimal r0330_secured_outstandbal) {
		this.r0330_secured_outstandbal = r0330_secured_outstandbal;
	}

	public BigDecimal getR0330_unsecured_outstandbal() {
		return r0330_unsecured_outstandbal;
	}

	public void setR0330_unsecured_outstandbal(BigDecimal r0330_unsecured_outstandbal) {
		this.r0330_unsecured_outstandbal = r0330_unsecured_outstandbal;
	}

	public BigDecimal getR0330_stage1_assetclass() {
		return r0330_stage1_assetclass;
	}

	public void setR0330_stage1_assetclass(BigDecimal r0330_stage1_assetclass) {
		this.r0330_stage1_assetclass = r0330_stage1_assetclass;
	}

	public BigDecimal getR0330_stage2_assetclass() {
		return r0330_stage2_assetclass;
	}

	public void setR0330_stage2_assetclass(BigDecimal r0330_stage2_assetclass) {
		this.r0330_stage2_assetclass = r0330_stage2_assetclass;
	}

	public BigDecimal getR0330_stage3a_assetclass() {
		return r0330_stage3a_assetclass;
	}

	public void setR0330_stage3a_assetclass(BigDecimal r0330_stage3a_assetclass) {
		this.r0330_stage3a_assetclass = r0330_stage3a_assetclass;
	}

	public BigDecimal getR0330_stage3b_assetclass() {
		return r0330_stage3b_assetclass;
	}

	public void setR0330_stage3b_assetclass(BigDecimal r0330_stage3b_assetclass) {
		this.r0330_stage3b_assetclass = r0330_stage3b_assetclass;
	}

	public BigDecimal getR0330_stage3c_assetclass() {
		return r0330_stage3c_assetclass;
	}

	public void setR0330_stage3c_assetclass(BigDecimal r0330_stage3c_assetclass) {
		this.r0330_stage3c_assetclass = r0330_stage3c_assetclass;
	}

	public BigDecimal getR0330_stage1_provisionheld() {
		return r0330_stage1_provisionheld;
	}

	public void setR0330_stage1_provisionheld(BigDecimal r0330_stage1_provisionheld) {
		this.r0330_stage1_provisionheld = r0330_stage1_provisionheld;
	}

	public BigDecimal getR0330_stage2_provisionheld() {
		return r0330_stage2_provisionheld;
	}

	public void setR0330_stage2_provisionheld(BigDecimal r0330_stage2_provisionheld) {
		this.r0330_stage2_provisionheld = r0330_stage2_provisionheld;
	}

	public BigDecimal getR0330_stage3a_provisionheld() {
		return r0330_stage3a_provisionheld;
	}

	public void setR0330_stage3a_provisionheld(BigDecimal r0330_stage3a_provisionheld) {
		this.r0330_stage3a_provisionheld = r0330_stage3a_provisionheld;
	}

	public BigDecimal getR0330_stage3b_provisionheld() {
		return r0330_stage3b_provisionheld;
	}

	public void setR0330_stage3b_provisionheld(BigDecimal r0330_stage3b_provisionheld) {
		this.r0330_stage3b_provisionheld = r0330_stage3b_provisionheld;
	}

	public BigDecimal getR0330_stage3c_provisionheld() {
		return r0330_stage3c_provisionheld;
	}

	public void setR0330_stage3c_provisionheld(BigDecimal r0330_stage3c_provisionheld) {
		this.r0330_stage3c_provisionheld = r0330_stage3c_provisionheld;
	}

	public BigDecimal getR0330_intrestfees_provisionheld() {
		return r0330_intrestfees_provisionheld;
	}

	public void setR0330_intrestfees_provisionheld(BigDecimal r0330_intrestfees_provisionheld) {
		this.r0330_intrestfees_provisionheld = r0330_intrestfees_provisionheld;
	}

	public BigDecimal getR0330_intrestsuspense_provisionheld() {
		return r0330_intrestsuspense_provisionheld;
	}

	public void setR0330_intrestsuspense_provisionheld(BigDecimal r0330_intrestsuspense_provisionheld) {
		this.r0330_intrestsuspense_provisionheld = r0330_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0330_stage1_poci() {
		return r0330_stage1_poci;
	}

	public void setR0330_stage1_poci(BigDecimal r0330_stage1_poci) {
		this.r0330_stage1_poci = r0330_stage1_poci;
	}

	public BigDecimal getR0330_stage2_poci() {
		return r0330_stage2_poci;
	}

	public void setR0330_stage2_poci(BigDecimal r0330_stage2_poci) {
		this.r0330_stage2_poci = r0330_stage2_poci;
	}

	public BigDecimal getR0330_stage3a_poci() {
		return r0330_stage3a_poci;
	}

	public void setR0330_stage3a_poci(BigDecimal r0330_stage3a_poci) {
		this.r0330_stage3a_poci = r0330_stage3a_poci;
	}

	public BigDecimal getR0330_stage3b_poci() {
		return r0330_stage3b_poci;
	}

	public void setR0330_stage3b_poci(BigDecimal r0330_stage3b_poci) {
		this.r0330_stage3b_poci = r0330_stage3b_poci;
	}

	public BigDecimal getR0330_stage3c_poci() {
		return r0330_stage3c_poci;
	}

	public void setR0330_stage3c_poci(BigDecimal r0330_stage3c_poci) {
		this.r0330_stage3c_poci = r0330_stage3c_poci;
	}

	public BigDecimal getR0330_current_pastdues() {
		return r0330_current_pastdues;
	}

	public void setR0330_current_pastdues(BigDecimal r0330_current_pastdues) {
		this.r0330_current_pastdues = r0330_current_pastdues;
	}

	public BigDecimal getR0330_less30days_pastdues() {
		return r0330_less30days_pastdues;
	}

	public void setR0330_less30days_pastdues(BigDecimal r0330_less30days_pastdues) {
		this.r0330_less30days_pastdues = r0330_less30days_pastdues;
	}

	public BigDecimal getR0330_31to90days_pastdues() {
		return r0330_31to90days_pastdues;
	}

	public void setR0330_31to90days_pastdues(BigDecimal r0330_31to90days_pastdues) {
		this.r0330_31to90days_pastdues = r0330_31to90days_pastdues;
	}

	public BigDecimal getR0330_91to120days_pastdues() {
		return r0330_91to120days_pastdues;
	}

	public void setR0330_91to120days_pastdues(BigDecimal r0330_91to120days_pastdues) {
		this.r0330_91to120days_pastdues = r0330_91to120days_pastdues;
	}

	public BigDecimal getR0330_121to180days_pastdues() {
		return r0330_121to180days_pastdues;
	}

	public void setR0330_121to180days_pastdues(BigDecimal r0330_121to180days_pastdues) {
		this.r0330_121to180days_pastdues = r0330_121to180days_pastdues;
	}

	public BigDecimal getR0330_181to365days_pastdues() {
		return r0330_181to365days_pastdues;
	}

	public void setR0330_181to365days_pastdues(BigDecimal r0330_181to365days_pastdues) {
		this.r0330_181to365days_pastdues = r0330_181to365days_pastdues;
	}

	public BigDecimal getR0330_over365days_pastdues() {
		return r0330_over365days_pastdues;
	}

	public void setR0330_over365days_pastdues(BigDecimal r0330_over365days_pastdues) {
		this.r0330_over365days_pastdues = r0330_over365days_pastdues;
	}

	public BigDecimal getR0330_total_pastdues() {
		return r0330_total_pastdues;
	}

	public void setR0330_total_pastdues(BigDecimal r0330_total_pastdues) {
		this.r0330_total_pastdues = r0330_total_pastdues;
	}

	public BigDecimal getR0330_newloan_duringreport() {
		return r0330_newloan_duringreport;
	}

	public void setR0330_newloan_duringreport(BigDecimal r0330_newloan_duringreport) {
		this.r0330_newloan_duringreport = r0330_newloan_duringreport;
	}

	public BigDecimal getR0330_newstage_duringreport() {
		return r0330_newstage_duringreport;
	}

	public void setR0330_newstage_duringreport(BigDecimal r0330_newstage_duringreport) {
		this.r0330_newstage_duringreport = r0330_newstage_duringreport;
	}

	public BigDecimal getR0330_intrestfees_duringreport() {
		return r0330_intrestfees_duringreport;
	}

	public void setR0330_intrestfees_duringreport(BigDecimal r0330_intrestfees_duringreport) {
		this.r0330_intrestfees_duringreport = r0330_intrestfees_duringreport;
	}

	public BigDecimal getR0330_performingac_acinfo() {
		return r0330_performingac_acinfo;
	}

	public void setR0330_performingac_acinfo(BigDecimal r0330_performingac_acinfo) {
		this.r0330_performingac_acinfo = r0330_performingac_acinfo;
	}

	public BigDecimal getR0330_nonperformingac_acinfo() {
		return r0330_nonperformingac_acinfo;
	}

	public void setR0330_nonperformingac_acinfo(BigDecimal r0330_nonperformingac_acinfo) {
		this.r0330_nonperformingac_acinfo = r0330_nonperformingac_acinfo;
	}

	public String getR0340_product() {
		return r0340_product;
	}

	public void setR0340_product(String r0340_product) {
		this.r0340_product = r0340_product;
	}

	public BigDecimal getR0340_outstandbal() {
		return r0340_outstandbal;
	}

	public void setR0340_outstandbal(BigDecimal r0340_outstandbal) {
		this.r0340_outstandbal = r0340_outstandbal;
	}

	public BigDecimal getR0340_secured_outstandbal() {
		return r0340_secured_outstandbal;
	}

	public void setR0340_secured_outstandbal(BigDecimal r0340_secured_outstandbal) {
		this.r0340_secured_outstandbal = r0340_secured_outstandbal;
	}

	public BigDecimal getR0340_unsecured_outstandbal() {
		return r0340_unsecured_outstandbal;
	}

	public void setR0340_unsecured_outstandbal(BigDecimal r0340_unsecured_outstandbal) {
		this.r0340_unsecured_outstandbal = r0340_unsecured_outstandbal;
	}

	public BigDecimal getR0340_stage1_assetclass() {
		return r0340_stage1_assetclass;
	}

	public void setR0340_stage1_assetclass(BigDecimal r0340_stage1_assetclass) {
		this.r0340_stage1_assetclass = r0340_stage1_assetclass;
	}

	public BigDecimal getR0340_stage2_assetclass() {
		return r0340_stage2_assetclass;
	}

	public void setR0340_stage2_assetclass(BigDecimal r0340_stage2_assetclass) {
		this.r0340_stage2_assetclass = r0340_stage2_assetclass;
	}

	public BigDecimal getR0340_stage3a_assetclass() {
		return r0340_stage3a_assetclass;
	}

	public void setR0340_stage3a_assetclass(BigDecimal r0340_stage3a_assetclass) {
		this.r0340_stage3a_assetclass = r0340_stage3a_assetclass;
	}

	public BigDecimal getR0340_stage3b_assetclass() {
		return r0340_stage3b_assetclass;
	}

	public void setR0340_stage3b_assetclass(BigDecimal r0340_stage3b_assetclass) {
		this.r0340_stage3b_assetclass = r0340_stage3b_assetclass;
	}

	public BigDecimal getR0340_stage3c_assetclass() {
		return r0340_stage3c_assetclass;
	}

	public void setR0340_stage3c_assetclass(BigDecimal r0340_stage3c_assetclass) {
		this.r0340_stage3c_assetclass = r0340_stage3c_assetclass;
	}

	public BigDecimal getR0340_stage1_provisionheld() {
		return r0340_stage1_provisionheld;
	}

	public void setR0340_stage1_provisionheld(BigDecimal r0340_stage1_provisionheld) {
		this.r0340_stage1_provisionheld = r0340_stage1_provisionheld;
	}

	public BigDecimal getR0340_stage2_provisionheld() {
		return r0340_stage2_provisionheld;
	}

	public void setR0340_stage2_provisionheld(BigDecimal r0340_stage2_provisionheld) {
		this.r0340_stage2_provisionheld = r0340_stage2_provisionheld;
	}

	public BigDecimal getR0340_stage3a_provisionheld() {
		return r0340_stage3a_provisionheld;
	}

	public void setR0340_stage3a_provisionheld(BigDecimal r0340_stage3a_provisionheld) {
		this.r0340_stage3a_provisionheld = r0340_stage3a_provisionheld;
	}

	public BigDecimal getR0340_stage3b_provisionheld() {
		return r0340_stage3b_provisionheld;
	}

	public void setR0340_stage3b_provisionheld(BigDecimal r0340_stage3b_provisionheld) {
		this.r0340_stage3b_provisionheld = r0340_stage3b_provisionheld;
	}

	public BigDecimal getR0340_stage3c_provisionheld() {
		return r0340_stage3c_provisionheld;
	}

	public void setR0340_stage3c_provisionheld(BigDecimal r0340_stage3c_provisionheld) {
		this.r0340_stage3c_provisionheld = r0340_stage3c_provisionheld;
	}

	public BigDecimal getR0340_intrestfees_provisionheld() {
		return r0340_intrestfees_provisionheld;
	}

	public void setR0340_intrestfees_provisionheld(BigDecimal r0340_intrestfees_provisionheld) {
		this.r0340_intrestfees_provisionheld = r0340_intrestfees_provisionheld;
	}

	public BigDecimal getR0340_intrestsuspense_provisionheld() {
		return r0340_intrestsuspense_provisionheld;
	}

	public void setR0340_intrestsuspense_provisionheld(BigDecimal r0340_intrestsuspense_provisionheld) {
		this.r0340_intrestsuspense_provisionheld = r0340_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0340_stage1_poci() {
		return r0340_stage1_poci;
	}

	public void setR0340_stage1_poci(BigDecimal r0340_stage1_poci) {
		this.r0340_stage1_poci = r0340_stage1_poci;
	}

	public BigDecimal getR0340_stage2_poci() {
		return r0340_stage2_poci;
	}

	public void setR0340_stage2_poci(BigDecimal r0340_stage2_poci) {
		this.r0340_stage2_poci = r0340_stage2_poci;
	}

	public BigDecimal getR0340_stage3a_poci() {
		return r0340_stage3a_poci;
	}

	public void setR0340_stage3a_poci(BigDecimal r0340_stage3a_poci) {
		this.r0340_stage3a_poci = r0340_stage3a_poci;
	}

	public BigDecimal getR0340_stage3b_poci() {
		return r0340_stage3b_poci;
	}

	public void setR0340_stage3b_poci(BigDecimal r0340_stage3b_poci) {
		this.r0340_stage3b_poci = r0340_stage3b_poci;
	}

	public BigDecimal getR0340_stage3c_poci() {
		return r0340_stage3c_poci;
	}

	public void setR0340_stage3c_poci(BigDecimal r0340_stage3c_poci) {
		this.r0340_stage3c_poci = r0340_stage3c_poci;
	}

	public BigDecimal getR0340_current_pastdues() {
		return r0340_current_pastdues;
	}

	public void setR0340_current_pastdues(BigDecimal r0340_current_pastdues) {
		this.r0340_current_pastdues = r0340_current_pastdues;
	}

	public BigDecimal getR0340_less30days_pastdues() {
		return r0340_less30days_pastdues;
	}

	public void setR0340_less30days_pastdues(BigDecimal r0340_less30days_pastdues) {
		this.r0340_less30days_pastdues = r0340_less30days_pastdues;
	}

	public BigDecimal getR0340_31to90days_pastdues() {
		return r0340_31to90days_pastdues;
	}

	public void setR0340_31to90days_pastdues(BigDecimal r0340_31to90days_pastdues) {
		this.r0340_31to90days_pastdues = r0340_31to90days_pastdues;
	}

	public BigDecimal getR0340_91to120days_pastdues() {
		return r0340_91to120days_pastdues;
	}

	public void setR0340_91to120days_pastdues(BigDecimal r0340_91to120days_pastdues) {
		this.r0340_91to120days_pastdues = r0340_91to120days_pastdues;
	}

	public BigDecimal getR0340_121to180days_pastdues() {
		return r0340_121to180days_pastdues;
	}

	public void setR0340_121to180days_pastdues(BigDecimal r0340_121to180days_pastdues) {
		this.r0340_121to180days_pastdues = r0340_121to180days_pastdues;
	}

	public BigDecimal getR0340_181to365days_pastdues() {
		return r0340_181to365days_pastdues;
	}

	public void setR0340_181to365days_pastdues(BigDecimal r0340_181to365days_pastdues) {
		this.r0340_181to365days_pastdues = r0340_181to365days_pastdues;
	}

	public BigDecimal getR0340_over365days_pastdues() {
		return r0340_over365days_pastdues;
	}

	public void setR0340_over365days_pastdues(BigDecimal r0340_over365days_pastdues) {
		this.r0340_over365days_pastdues = r0340_over365days_pastdues;
	}

	public BigDecimal getR0340_total_pastdues() {
		return r0340_total_pastdues;
	}

	public void setR0340_total_pastdues(BigDecimal r0340_total_pastdues) {
		this.r0340_total_pastdues = r0340_total_pastdues;
	}

	public BigDecimal getR0340_newloan_duringreport() {
		return r0340_newloan_duringreport;
	}

	public void setR0340_newloan_duringreport(BigDecimal r0340_newloan_duringreport) {
		this.r0340_newloan_duringreport = r0340_newloan_duringreport;
	}

	public BigDecimal getR0340_newstage_duringreport() {
		return r0340_newstage_duringreport;
	}

	public void setR0340_newstage_duringreport(BigDecimal r0340_newstage_duringreport) {
		this.r0340_newstage_duringreport = r0340_newstage_duringreport;
	}

	public BigDecimal getR0340_intrestfees_duringreport() {
		return r0340_intrestfees_duringreport;
	}

	public void setR0340_intrestfees_duringreport(BigDecimal r0340_intrestfees_duringreport) {
		this.r0340_intrestfees_duringreport = r0340_intrestfees_duringreport;
	}

	public BigDecimal getR0340_performingac_acinfo() {
		return r0340_performingac_acinfo;
	}

	public void setR0340_performingac_acinfo(BigDecimal r0340_performingac_acinfo) {
		this.r0340_performingac_acinfo = r0340_performingac_acinfo;
	}

	public BigDecimal getR0340_nonperformingac_acinfo() {
		return r0340_nonperformingac_acinfo;
	}

	public void setR0340_nonperformingac_acinfo(BigDecimal r0340_nonperformingac_acinfo) {
		this.r0340_nonperformingac_acinfo = r0340_nonperformingac_acinfo;
	}

	public String getR0350_product() {
		return r0350_product;
	}

	public void setR0350_product(String r0350_product) {
		this.r0350_product = r0350_product;
	}

	public BigDecimal getR0350_outstandbal() {
		return r0350_outstandbal;
	}

	public void setR0350_outstandbal(BigDecimal r0350_outstandbal) {
		this.r0350_outstandbal = r0350_outstandbal;
	}

	public BigDecimal getR0350_secured_outstandbal() {
		return r0350_secured_outstandbal;
	}

	public void setR0350_secured_outstandbal(BigDecimal r0350_secured_outstandbal) {
		this.r0350_secured_outstandbal = r0350_secured_outstandbal;
	}

	public BigDecimal getR0350_unsecured_outstandbal() {
		return r0350_unsecured_outstandbal;
	}

	public void setR0350_unsecured_outstandbal(BigDecimal r0350_unsecured_outstandbal) {
		this.r0350_unsecured_outstandbal = r0350_unsecured_outstandbal;
	}

	public BigDecimal getR0350_stage1_assetclass() {
		return r0350_stage1_assetclass;
	}

	public void setR0350_stage1_assetclass(BigDecimal r0350_stage1_assetclass) {
		this.r0350_stage1_assetclass = r0350_stage1_assetclass;
	}

	public BigDecimal getR0350_stage2_assetclass() {
		return r0350_stage2_assetclass;
	}

	public void setR0350_stage2_assetclass(BigDecimal r0350_stage2_assetclass) {
		this.r0350_stage2_assetclass = r0350_stage2_assetclass;
	}

	public BigDecimal getR0350_stage3a_assetclass() {
		return r0350_stage3a_assetclass;
	}

	public void setR0350_stage3a_assetclass(BigDecimal r0350_stage3a_assetclass) {
		this.r0350_stage3a_assetclass = r0350_stage3a_assetclass;
	}

	public BigDecimal getR0350_stage3b_assetclass() {
		return r0350_stage3b_assetclass;
	}

	public void setR0350_stage3b_assetclass(BigDecimal r0350_stage3b_assetclass) {
		this.r0350_stage3b_assetclass = r0350_stage3b_assetclass;
	}

	public BigDecimal getR0350_stage3c_assetclass() {
		return r0350_stage3c_assetclass;
	}

	public void setR0350_stage3c_assetclass(BigDecimal r0350_stage3c_assetclass) {
		this.r0350_stage3c_assetclass = r0350_stage3c_assetclass;
	}

	public BigDecimal getR0350_stage1_provisionheld() {
		return r0350_stage1_provisionheld;
	}

	public void setR0350_stage1_provisionheld(BigDecimal r0350_stage1_provisionheld) {
		this.r0350_stage1_provisionheld = r0350_stage1_provisionheld;
	}

	public BigDecimal getR0350_stage2_provisionheld() {
		return r0350_stage2_provisionheld;
	}

	public void setR0350_stage2_provisionheld(BigDecimal r0350_stage2_provisionheld) {
		this.r0350_stage2_provisionheld = r0350_stage2_provisionheld;
	}

	public BigDecimal getR0350_stage3a_provisionheld() {
		return r0350_stage3a_provisionheld;
	}

	public void setR0350_stage3a_provisionheld(BigDecimal r0350_stage3a_provisionheld) {
		this.r0350_stage3a_provisionheld = r0350_stage3a_provisionheld;
	}

	public BigDecimal getR0350_stage3b_provisionheld() {
		return r0350_stage3b_provisionheld;
	}

	public void setR0350_stage3b_provisionheld(BigDecimal r0350_stage3b_provisionheld) {
		this.r0350_stage3b_provisionheld = r0350_stage3b_provisionheld;
	}

	public BigDecimal getR0350_stage3c_provisionheld() {
		return r0350_stage3c_provisionheld;
	}

	public void setR0350_stage3c_provisionheld(BigDecimal r0350_stage3c_provisionheld) {
		this.r0350_stage3c_provisionheld = r0350_stage3c_provisionheld;
	}

	public BigDecimal getR0350_intrestfees_provisionheld() {
		return r0350_intrestfees_provisionheld;
	}

	public void setR0350_intrestfees_provisionheld(BigDecimal r0350_intrestfees_provisionheld) {
		this.r0350_intrestfees_provisionheld = r0350_intrestfees_provisionheld;
	}

	public BigDecimal getR0350_intrestsuspense_provisionheld() {
		return r0350_intrestsuspense_provisionheld;
	}

	public void setR0350_intrestsuspense_provisionheld(BigDecimal r0350_intrestsuspense_provisionheld) {
		this.r0350_intrestsuspense_provisionheld = r0350_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0350_stage1_poci() {
		return r0350_stage1_poci;
	}

	public void setR0350_stage1_poci(BigDecimal r0350_stage1_poci) {
		this.r0350_stage1_poci = r0350_stage1_poci;
	}

	public BigDecimal getR0350_stage2_poci() {
		return r0350_stage2_poci;
	}

	public void setR0350_stage2_poci(BigDecimal r0350_stage2_poci) {
		this.r0350_stage2_poci = r0350_stage2_poci;
	}

	public BigDecimal getR0350_stage3a_poci() {
		return r0350_stage3a_poci;
	}

	public void setR0350_stage3a_poci(BigDecimal r0350_stage3a_poci) {
		this.r0350_stage3a_poci = r0350_stage3a_poci;
	}

	public BigDecimal getR0350_stage3b_poci() {
		return r0350_stage3b_poci;
	}

	public void setR0350_stage3b_poci(BigDecimal r0350_stage3b_poci) {
		this.r0350_stage3b_poci = r0350_stage3b_poci;
	}

	public BigDecimal getR0350_stage3c_poci() {
		return r0350_stage3c_poci;
	}

	public void setR0350_stage3c_poci(BigDecimal r0350_stage3c_poci) {
		this.r0350_stage3c_poci = r0350_stage3c_poci;
	}

	public BigDecimal getR0350_current_pastdues() {
		return r0350_current_pastdues;
	}

	public void setR0350_current_pastdues(BigDecimal r0350_current_pastdues) {
		this.r0350_current_pastdues = r0350_current_pastdues;
	}

	public BigDecimal getR0350_less30days_pastdues() {
		return r0350_less30days_pastdues;
	}

	public void setR0350_less30days_pastdues(BigDecimal r0350_less30days_pastdues) {
		this.r0350_less30days_pastdues = r0350_less30days_pastdues;
	}

	public BigDecimal getR0350_31to90days_pastdues() {
		return r0350_31to90days_pastdues;
	}

	public void setR0350_31to90days_pastdues(BigDecimal r0350_31to90days_pastdues) {
		this.r0350_31to90days_pastdues = r0350_31to90days_pastdues;
	}

	public BigDecimal getR0350_91to120days_pastdues() {
		return r0350_91to120days_pastdues;
	}

	public void setR0350_91to120days_pastdues(BigDecimal r0350_91to120days_pastdues) {
		this.r0350_91to120days_pastdues = r0350_91to120days_pastdues;
	}

	public BigDecimal getR0350_121to180days_pastdues() {
		return r0350_121to180days_pastdues;
	}

	public void setR0350_121to180days_pastdues(BigDecimal r0350_121to180days_pastdues) {
		this.r0350_121to180days_pastdues = r0350_121to180days_pastdues;
	}

	public BigDecimal getR0350_181to365days_pastdues() {
		return r0350_181to365days_pastdues;
	}

	public void setR0350_181to365days_pastdues(BigDecimal r0350_181to365days_pastdues) {
		this.r0350_181to365days_pastdues = r0350_181to365days_pastdues;
	}

	public BigDecimal getR0350_over365days_pastdues() {
		return r0350_over365days_pastdues;
	}

	public void setR0350_over365days_pastdues(BigDecimal r0350_over365days_pastdues) {
		this.r0350_over365days_pastdues = r0350_over365days_pastdues;
	}

	public BigDecimal getR0350_total_pastdues() {
		return r0350_total_pastdues;
	}

	public void setR0350_total_pastdues(BigDecimal r0350_total_pastdues) {
		this.r0350_total_pastdues = r0350_total_pastdues;
	}

	public BigDecimal getR0350_newloan_duringreport() {
		return r0350_newloan_duringreport;
	}

	public void setR0350_newloan_duringreport(BigDecimal r0350_newloan_duringreport) {
		this.r0350_newloan_duringreport = r0350_newloan_duringreport;
	}

	public BigDecimal getR0350_newstage_duringreport() {
		return r0350_newstage_duringreport;
	}

	public void setR0350_newstage_duringreport(BigDecimal r0350_newstage_duringreport) {
		this.r0350_newstage_duringreport = r0350_newstage_duringreport;
	}

	public BigDecimal getR0350_intrestfees_duringreport() {
		return r0350_intrestfees_duringreport;
	}

	public void setR0350_intrestfees_duringreport(BigDecimal r0350_intrestfees_duringreport) {
		this.r0350_intrestfees_duringreport = r0350_intrestfees_duringreport;
	}

	public BigDecimal getR0350_performingac_acinfo() {
		return r0350_performingac_acinfo;
	}

	public void setR0350_performingac_acinfo(BigDecimal r0350_performingac_acinfo) {
		this.r0350_performingac_acinfo = r0350_performingac_acinfo;
	}

	public BigDecimal getR0350_nonperformingac_acinfo() {
		return r0350_nonperformingac_acinfo;
	}

	public void setR0350_nonperformingac_acinfo(BigDecimal r0350_nonperformingac_acinfo) {
		this.r0350_nonperformingac_acinfo = r0350_nonperformingac_acinfo;
	}

	public String getR0360_product() {
		return r0360_product;
	}

	public void setR0360_product(String r0360_product) {
		this.r0360_product = r0360_product;
	}

	public BigDecimal getR0360_outstandbal() {
		return r0360_outstandbal;
	}

	public void setR0360_outstandbal(BigDecimal r0360_outstandbal) {
		this.r0360_outstandbal = r0360_outstandbal;
	}

	public BigDecimal getR0360_secured_outstandbal() {
		return r0360_secured_outstandbal;
	}

	public void setR0360_secured_outstandbal(BigDecimal r0360_secured_outstandbal) {
		this.r0360_secured_outstandbal = r0360_secured_outstandbal;
	}

	public BigDecimal getR0360_unsecured_outstandbal() {
		return r0360_unsecured_outstandbal;
	}

	public void setR0360_unsecured_outstandbal(BigDecimal r0360_unsecured_outstandbal) {
		this.r0360_unsecured_outstandbal = r0360_unsecured_outstandbal;
	}

	public BigDecimal getR0360_stage1_assetclass() {
		return r0360_stage1_assetclass;
	}

	public void setR0360_stage1_assetclass(BigDecimal r0360_stage1_assetclass) {
		this.r0360_stage1_assetclass = r0360_stage1_assetclass;
	}

	public BigDecimal getR0360_stage2_assetclass() {
		return r0360_stage2_assetclass;
	}

	public void setR0360_stage2_assetclass(BigDecimal r0360_stage2_assetclass) {
		this.r0360_stage2_assetclass = r0360_stage2_assetclass;
	}

	public BigDecimal getR0360_stage3a_assetclass() {
		return r0360_stage3a_assetclass;
	}

	public void setR0360_stage3a_assetclass(BigDecimal r0360_stage3a_assetclass) {
		this.r0360_stage3a_assetclass = r0360_stage3a_assetclass;
	}

	public BigDecimal getR0360_stage3b_assetclass() {
		return r0360_stage3b_assetclass;
	}

	public void setR0360_stage3b_assetclass(BigDecimal r0360_stage3b_assetclass) {
		this.r0360_stage3b_assetclass = r0360_stage3b_assetclass;
	}

	public BigDecimal getR0360_stage3c_assetclass() {
		return r0360_stage3c_assetclass;
	}

	public void setR0360_stage3c_assetclass(BigDecimal r0360_stage3c_assetclass) {
		this.r0360_stage3c_assetclass = r0360_stage3c_assetclass;
	}

	public BigDecimal getR0360_stage1_provisionheld() {
		return r0360_stage1_provisionheld;
	}

	public void setR0360_stage1_provisionheld(BigDecimal r0360_stage1_provisionheld) {
		this.r0360_stage1_provisionheld = r0360_stage1_provisionheld;
	}

	public BigDecimal getR0360_stage2_provisionheld() {
		return r0360_stage2_provisionheld;
	}

	public void setR0360_stage2_provisionheld(BigDecimal r0360_stage2_provisionheld) {
		this.r0360_stage2_provisionheld = r0360_stage2_provisionheld;
	}

	public BigDecimal getR0360_stage3a_provisionheld() {
		return r0360_stage3a_provisionheld;
	}

	public void setR0360_stage3a_provisionheld(BigDecimal r0360_stage3a_provisionheld) {
		this.r0360_stage3a_provisionheld = r0360_stage3a_provisionheld;
	}

	public BigDecimal getR0360_stage3b_provisionheld() {
		return r0360_stage3b_provisionheld;
	}

	public void setR0360_stage3b_provisionheld(BigDecimal r0360_stage3b_provisionheld) {
		this.r0360_stage3b_provisionheld = r0360_stage3b_provisionheld;
	}

	public BigDecimal getR0360_stage3c_provisionheld() {
		return r0360_stage3c_provisionheld;
	}

	public void setR0360_stage3c_provisionheld(BigDecimal r0360_stage3c_provisionheld) {
		this.r0360_stage3c_provisionheld = r0360_stage3c_provisionheld;
	}

	public BigDecimal getR0360_intrestfees_provisionheld() {
		return r0360_intrestfees_provisionheld;
	}

	public void setR0360_intrestfees_provisionheld(BigDecimal r0360_intrestfees_provisionheld) {
		this.r0360_intrestfees_provisionheld = r0360_intrestfees_provisionheld;
	}

	public BigDecimal getR0360_intrestsuspense_provisionheld() {
		return r0360_intrestsuspense_provisionheld;
	}

	public void setR0360_intrestsuspense_provisionheld(BigDecimal r0360_intrestsuspense_provisionheld) {
		this.r0360_intrestsuspense_provisionheld = r0360_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0360_stage1_poci() {
		return r0360_stage1_poci;
	}

	public void setR0360_stage1_poci(BigDecimal r0360_stage1_poci) {
		this.r0360_stage1_poci = r0360_stage1_poci;
	}

	public BigDecimal getR0360_stage2_poci() {
		return r0360_stage2_poci;
	}

	public void setR0360_stage2_poci(BigDecimal r0360_stage2_poci) {
		this.r0360_stage2_poci = r0360_stage2_poci;
	}

	public BigDecimal getR0360_stage3a_poci() {
		return r0360_stage3a_poci;
	}

	public void setR0360_stage3a_poci(BigDecimal r0360_stage3a_poci) {
		this.r0360_stage3a_poci = r0360_stage3a_poci;
	}

	public BigDecimal getR0360_stage3b_poci() {
		return r0360_stage3b_poci;
	}

	public void setR0360_stage3b_poci(BigDecimal r0360_stage3b_poci) {
		this.r0360_stage3b_poci = r0360_stage3b_poci;
	}

	public BigDecimal getR0360_stage3c_poci() {
		return r0360_stage3c_poci;
	}

	public void setR0360_stage3c_poci(BigDecimal r0360_stage3c_poci) {
		this.r0360_stage3c_poci = r0360_stage3c_poci;
	}

	public BigDecimal getR0360_current_pastdues() {
		return r0360_current_pastdues;
	}

	public void setR0360_current_pastdues(BigDecimal r0360_current_pastdues) {
		this.r0360_current_pastdues = r0360_current_pastdues;
	}

	public BigDecimal getR0360_less30days_pastdues() {
		return r0360_less30days_pastdues;
	}

	public void setR0360_less30days_pastdues(BigDecimal r0360_less30days_pastdues) {
		this.r0360_less30days_pastdues = r0360_less30days_pastdues;
	}

	public BigDecimal getR0360_31to90days_pastdues() {
		return r0360_31to90days_pastdues;
	}

	public void setR0360_31to90days_pastdues(BigDecimal r0360_31to90days_pastdues) {
		this.r0360_31to90days_pastdues = r0360_31to90days_pastdues;
	}

	public BigDecimal getR0360_91to120days_pastdues() {
		return r0360_91to120days_pastdues;
	}

	public void setR0360_91to120days_pastdues(BigDecimal r0360_91to120days_pastdues) {
		this.r0360_91to120days_pastdues = r0360_91to120days_pastdues;
	}

	public BigDecimal getR0360_121to180days_pastdues() {
		return r0360_121to180days_pastdues;
	}

	public void setR0360_121to180days_pastdues(BigDecimal r0360_121to180days_pastdues) {
		this.r0360_121to180days_pastdues = r0360_121to180days_pastdues;
	}

	public BigDecimal getR0360_181to365days_pastdues() {
		return r0360_181to365days_pastdues;
	}

	public void setR0360_181to365days_pastdues(BigDecimal r0360_181to365days_pastdues) {
		this.r0360_181to365days_pastdues = r0360_181to365days_pastdues;
	}

	public BigDecimal getR0360_over365days_pastdues() {
		return r0360_over365days_pastdues;
	}

	public void setR0360_over365days_pastdues(BigDecimal r0360_over365days_pastdues) {
		this.r0360_over365days_pastdues = r0360_over365days_pastdues;
	}

	public BigDecimal getR0360_total_pastdues() {
		return r0360_total_pastdues;
	}

	public void setR0360_total_pastdues(BigDecimal r0360_total_pastdues) {
		this.r0360_total_pastdues = r0360_total_pastdues;
	}

	public BigDecimal getR0360_newloan_duringreport() {
		return r0360_newloan_duringreport;
	}

	public void setR0360_newloan_duringreport(BigDecimal r0360_newloan_duringreport) {
		this.r0360_newloan_duringreport = r0360_newloan_duringreport;
	}

	public BigDecimal getR0360_newstage_duringreport() {
		return r0360_newstage_duringreport;
	}

	public void setR0360_newstage_duringreport(BigDecimal r0360_newstage_duringreport) {
		this.r0360_newstage_duringreport = r0360_newstage_duringreport;
	}

	public BigDecimal getR0360_intrestfees_duringreport() {
		return r0360_intrestfees_duringreport;
	}

	public void setR0360_intrestfees_duringreport(BigDecimal r0360_intrestfees_duringreport) {
		this.r0360_intrestfees_duringreport = r0360_intrestfees_duringreport;
	}

	public BigDecimal getR0360_performingac_acinfo() {
		return r0360_performingac_acinfo;
	}

	public void setR0360_performingac_acinfo(BigDecimal r0360_performingac_acinfo) {
		this.r0360_performingac_acinfo = r0360_performingac_acinfo;
	}

	public BigDecimal getR0360_nonperformingac_acinfo() {
		return r0360_nonperformingac_acinfo;
	}

	public void setR0360_nonperformingac_acinfo(BigDecimal r0360_nonperformingac_acinfo) {
		this.r0360_nonperformingac_acinfo = r0360_nonperformingac_acinfo;
	}

	public String getR0370_product() {
		return r0370_product;
	}

	public void setR0370_product(String r0370_product) {
		this.r0370_product = r0370_product;
	}

	public BigDecimal getR0370_outstandbal() {
		return r0370_outstandbal;
	}

	public void setR0370_outstandbal(BigDecimal r0370_outstandbal) {
		this.r0370_outstandbal = r0370_outstandbal;
	}

	public BigDecimal getR0370_secured_outstandbal() {
		return r0370_secured_outstandbal;
	}

	public void setR0370_secured_outstandbal(BigDecimal r0370_secured_outstandbal) {
		this.r0370_secured_outstandbal = r0370_secured_outstandbal;
	}

	public BigDecimal getR0370_unsecured_outstandbal() {
		return r0370_unsecured_outstandbal;
	}

	public void setR0370_unsecured_outstandbal(BigDecimal r0370_unsecured_outstandbal) {
		this.r0370_unsecured_outstandbal = r0370_unsecured_outstandbal;
	}

	public BigDecimal getR0370_stage1_assetclass() {
		return r0370_stage1_assetclass;
	}

	public void setR0370_stage1_assetclass(BigDecimal r0370_stage1_assetclass) {
		this.r0370_stage1_assetclass = r0370_stage1_assetclass;
	}

	public BigDecimal getR0370_stage2_assetclass() {
		return r0370_stage2_assetclass;
	}

	public void setR0370_stage2_assetclass(BigDecimal r0370_stage2_assetclass) {
		this.r0370_stage2_assetclass = r0370_stage2_assetclass;
	}

	public BigDecimal getR0370_stage3a_assetclass() {
		return r0370_stage3a_assetclass;
	}

	public void setR0370_stage3a_assetclass(BigDecimal r0370_stage3a_assetclass) {
		this.r0370_stage3a_assetclass = r0370_stage3a_assetclass;
	}

	public BigDecimal getR0370_stage3b_assetclass() {
		return r0370_stage3b_assetclass;
	}

	public void setR0370_stage3b_assetclass(BigDecimal r0370_stage3b_assetclass) {
		this.r0370_stage3b_assetclass = r0370_stage3b_assetclass;
	}

	public BigDecimal getR0370_stage3c_assetclass() {
		return r0370_stage3c_assetclass;
	}

	public void setR0370_stage3c_assetclass(BigDecimal r0370_stage3c_assetclass) {
		this.r0370_stage3c_assetclass = r0370_stage3c_assetclass;
	}

	public BigDecimal getR0370_stage1_provisionheld() {
		return r0370_stage1_provisionheld;
	}

	public void setR0370_stage1_provisionheld(BigDecimal r0370_stage1_provisionheld) {
		this.r0370_stage1_provisionheld = r0370_stage1_provisionheld;
	}

	public BigDecimal getR0370_stage2_provisionheld() {
		return r0370_stage2_provisionheld;
	}

	public void setR0370_stage2_provisionheld(BigDecimal r0370_stage2_provisionheld) {
		this.r0370_stage2_provisionheld = r0370_stage2_provisionheld;
	}

	public BigDecimal getR0370_stage3a_provisionheld() {
		return r0370_stage3a_provisionheld;
	}

	public void setR0370_stage3a_provisionheld(BigDecimal r0370_stage3a_provisionheld) {
		this.r0370_stage3a_provisionheld = r0370_stage3a_provisionheld;
	}

	public BigDecimal getR0370_stage3b_provisionheld() {
		return r0370_stage3b_provisionheld;
	}

	public void setR0370_stage3b_provisionheld(BigDecimal r0370_stage3b_provisionheld) {
		this.r0370_stage3b_provisionheld = r0370_stage3b_provisionheld;
	}

	public BigDecimal getR0370_stage3c_provisionheld() {
		return r0370_stage3c_provisionheld;
	}

	public void setR0370_stage3c_provisionheld(BigDecimal r0370_stage3c_provisionheld) {
		this.r0370_stage3c_provisionheld = r0370_stage3c_provisionheld;
	}

	public BigDecimal getR0370_intrestfees_provisionheld() {
		return r0370_intrestfees_provisionheld;
	}

	public void setR0370_intrestfees_provisionheld(BigDecimal r0370_intrestfees_provisionheld) {
		this.r0370_intrestfees_provisionheld = r0370_intrestfees_provisionheld;
	}

	public BigDecimal getR0370_intrestsuspense_provisionheld() {
		return r0370_intrestsuspense_provisionheld;
	}

	public void setR0370_intrestsuspense_provisionheld(BigDecimal r0370_intrestsuspense_provisionheld) {
		this.r0370_intrestsuspense_provisionheld = r0370_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0370_stage1_poci() {
		return r0370_stage1_poci;
	}

	public void setR0370_stage1_poci(BigDecimal r0370_stage1_poci) {
		this.r0370_stage1_poci = r0370_stage1_poci;
	}

	public BigDecimal getR0370_stage2_poci() {
		return r0370_stage2_poci;
	}

	public void setR0370_stage2_poci(BigDecimal r0370_stage2_poci) {
		this.r0370_stage2_poci = r0370_stage2_poci;
	}

	public BigDecimal getR0370_stage3a_poci() {
		return r0370_stage3a_poci;
	}

	public void setR0370_stage3a_poci(BigDecimal r0370_stage3a_poci) {
		this.r0370_stage3a_poci = r0370_stage3a_poci;
	}

	public BigDecimal getR0370_stage3b_poci() {
		return r0370_stage3b_poci;
	}

	public void setR0370_stage3b_poci(BigDecimal r0370_stage3b_poci) {
		this.r0370_stage3b_poci = r0370_stage3b_poci;
	}

	public BigDecimal getR0370_stage3c_poci() {
		return r0370_stage3c_poci;
	}

	public void setR0370_stage3c_poci(BigDecimal r0370_stage3c_poci) {
		this.r0370_stage3c_poci = r0370_stage3c_poci;
	}

	public BigDecimal getR0370_current_pastdues() {
		return r0370_current_pastdues;
	}

	public void setR0370_current_pastdues(BigDecimal r0370_current_pastdues) {
		this.r0370_current_pastdues = r0370_current_pastdues;
	}

	public BigDecimal getR0370_less30days_pastdues() {
		return r0370_less30days_pastdues;
	}

	public void setR0370_less30days_pastdues(BigDecimal r0370_less30days_pastdues) {
		this.r0370_less30days_pastdues = r0370_less30days_pastdues;
	}

	public BigDecimal getR0370_31to90days_pastdues() {
		return r0370_31to90days_pastdues;
	}

	public void setR0370_31to90days_pastdues(BigDecimal r0370_31to90days_pastdues) {
		this.r0370_31to90days_pastdues = r0370_31to90days_pastdues;
	}

	public BigDecimal getR0370_91to120days_pastdues() {
		return r0370_91to120days_pastdues;
	}

	public void setR0370_91to120days_pastdues(BigDecimal r0370_91to120days_pastdues) {
		this.r0370_91to120days_pastdues = r0370_91to120days_pastdues;
	}

	public BigDecimal getR0370_121to180days_pastdues() {
		return r0370_121to180days_pastdues;
	}

	public void setR0370_121to180days_pastdues(BigDecimal r0370_121to180days_pastdues) {
		this.r0370_121to180days_pastdues = r0370_121to180days_pastdues;
	}

	public BigDecimal getR0370_181to365days_pastdues() {
		return r0370_181to365days_pastdues;
	}

	public void setR0370_181to365days_pastdues(BigDecimal r0370_181to365days_pastdues) {
		this.r0370_181to365days_pastdues = r0370_181to365days_pastdues;
	}

	public BigDecimal getR0370_over365days_pastdues() {
		return r0370_over365days_pastdues;
	}

	public void setR0370_over365days_pastdues(BigDecimal r0370_over365days_pastdues) {
		this.r0370_over365days_pastdues = r0370_over365days_pastdues;
	}

	public BigDecimal getR0370_total_pastdues() {
		return r0370_total_pastdues;
	}

	public void setR0370_total_pastdues(BigDecimal r0370_total_pastdues) {
		this.r0370_total_pastdues = r0370_total_pastdues;
	}

	public BigDecimal getR0370_newloan_duringreport() {
		return r0370_newloan_duringreport;
	}

	public void setR0370_newloan_duringreport(BigDecimal r0370_newloan_duringreport) {
		this.r0370_newloan_duringreport = r0370_newloan_duringreport;
	}

	public BigDecimal getR0370_newstage_duringreport() {
		return r0370_newstage_duringreport;
	}

	public void setR0370_newstage_duringreport(BigDecimal r0370_newstage_duringreport) {
		this.r0370_newstage_duringreport = r0370_newstage_duringreport;
	}

	public BigDecimal getR0370_intrestfees_duringreport() {
		return r0370_intrestfees_duringreport;
	}

	public void setR0370_intrestfees_duringreport(BigDecimal r0370_intrestfees_duringreport) {
		this.r0370_intrestfees_duringreport = r0370_intrestfees_duringreport;
	}

	public BigDecimal getR0370_performingac_acinfo() {
		return r0370_performingac_acinfo;
	}

	public void setR0370_performingac_acinfo(BigDecimal r0370_performingac_acinfo) {
		this.r0370_performingac_acinfo = r0370_performingac_acinfo;
	}

	public BigDecimal getR0370_nonperformingac_acinfo() {
		return r0370_nonperformingac_acinfo;
	}

	public void setR0370_nonperformingac_acinfo(BigDecimal r0370_nonperformingac_acinfo) {
		this.r0370_nonperformingac_acinfo = r0370_nonperformingac_acinfo;
	}

	public String getR0380_product() {
		return r0380_product;
	}

	public void setR0380_product(String r0380_product) {
		this.r0380_product = r0380_product;
	}

	public BigDecimal getR0380_outstandbal() {
		return r0380_outstandbal;
	}

	public void setR0380_outstandbal(BigDecimal r0380_outstandbal) {
		this.r0380_outstandbal = r0380_outstandbal;
	}

	public BigDecimal getR0380_secured_outstandbal() {
		return r0380_secured_outstandbal;
	}

	public void setR0380_secured_outstandbal(BigDecimal r0380_secured_outstandbal) {
		this.r0380_secured_outstandbal = r0380_secured_outstandbal;
	}

	public BigDecimal getR0380_unsecured_outstandbal() {
		return r0380_unsecured_outstandbal;
	}

	public void setR0380_unsecured_outstandbal(BigDecimal r0380_unsecured_outstandbal) {
		this.r0380_unsecured_outstandbal = r0380_unsecured_outstandbal;
	}

	public BigDecimal getR0380_stage1_assetclass() {
		return r0380_stage1_assetclass;
	}

	public void setR0380_stage1_assetclass(BigDecimal r0380_stage1_assetclass) {
		this.r0380_stage1_assetclass = r0380_stage1_assetclass;
	}

	public BigDecimal getR0380_stage2_assetclass() {
		return r0380_stage2_assetclass;
	}

	public void setR0380_stage2_assetclass(BigDecimal r0380_stage2_assetclass) {
		this.r0380_stage2_assetclass = r0380_stage2_assetclass;
	}

	public BigDecimal getR0380_stage3a_assetclass() {
		return r0380_stage3a_assetclass;
	}

	public void setR0380_stage3a_assetclass(BigDecimal r0380_stage3a_assetclass) {
		this.r0380_stage3a_assetclass = r0380_stage3a_assetclass;
	}

	public BigDecimal getR0380_stage3b_assetclass() {
		return r0380_stage3b_assetclass;
	}

	public void setR0380_stage3b_assetclass(BigDecimal r0380_stage3b_assetclass) {
		this.r0380_stage3b_assetclass = r0380_stage3b_assetclass;
	}

	public BigDecimal getR0380_stage3c_assetclass() {
		return r0380_stage3c_assetclass;
	}

	public void setR0380_stage3c_assetclass(BigDecimal r0380_stage3c_assetclass) {
		this.r0380_stage3c_assetclass = r0380_stage3c_assetclass;
	}

	public BigDecimal getR0380_stage1_provisionheld() {
		return r0380_stage1_provisionheld;
	}

	public void setR0380_stage1_provisionheld(BigDecimal r0380_stage1_provisionheld) {
		this.r0380_stage1_provisionheld = r0380_stage1_provisionheld;
	}

	public BigDecimal getR0380_stage2_provisionheld() {
		return r0380_stage2_provisionheld;
	}

	public void setR0380_stage2_provisionheld(BigDecimal r0380_stage2_provisionheld) {
		this.r0380_stage2_provisionheld = r0380_stage2_provisionheld;
	}

	public BigDecimal getR0380_stage3a_provisionheld() {
		return r0380_stage3a_provisionheld;
	}

	public void setR0380_stage3a_provisionheld(BigDecimal r0380_stage3a_provisionheld) {
		this.r0380_stage3a_provisionheld = r0380_stage3a_provisionheld;
	}

	public BigDecimal getR0380_stage3b_provisionheld() {
		return r0380_stage3b_provisionheld;
	}

	public void setR0380_stage3b_provisionheld(BigDecimal r0380_stage3b_provisionheld) {
		this.r0380_stage3b_provisionheld = r0380_stage3b_provisionheld;
	}

	public BigDecimal getR0380_stage3c_provisionheld() {
		return r0380_stage3c_provisionheld;
	}

	public void setR0380_stage3c_provisionheld(BigDecimal r0380_stage3c_provisionheld) {
		this.r0380_stage3c_provisionheld = r0380_stage3c_provisionheld;
	}

	public BigDecimal getR0380_intrestfees_provisionheld() {
		return r0380_intrestfees_provisionheld;
	}

	public void setR0380_intrestfees_provisionheld(BigDecimal r0380_intrestfees_provisionheld) {
		this.r0380_intrestfees_provisionheld = r0380_intrestfees_provisionheld;
	}

	public BigDecimal getR0380_intrestsuspense_provisionheld() {
		return r0380_intrestsuspense_provisionheld;
	}

	public void setR0380_intrestsuspense_provisionheld(BigDecimal r0380_intrestsuspense_provisionheld) {
		this.r0380_intrestsuspense_provisionheld = r0380_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0380_stage1_poci() {
		return r0380_stage1_poci;
	}

	public void setR0380_stage1_poci(BigDecimal r0380_stage1_poci) {
		this.r0380_stage1_poci = r0380_stage1_poci;
	}

	public BigDecimal getR0380_stage2_poci() {
		return r0380_stage2_poci;
	}

	public void setR0380_stage2_poci(BigDecimal r0380_stage2_poci) {
		this.r0380_stage2_poci = r0380_stage2_poci;
	}

	public BigDecimal getR0380_stage3a_poci() {
		return r0380_stage3a_poci;
	}

	public void setR0380_stage3a_poci(BigDecimal r0380_stage3a_poci) {
		this.r0380_stage3a_poci = r0380_stage3a_poci;
	}

	public BigDecimal getR0380_stage3b_poci() {
		return r0380_stage3b_poci;
	}

	public void setR0380_stage3b_poci(BigDecimal r0380_stage3b_poci) {
		this.r0380_stage3b_poci = r0380_stage3b_poci;
	}

	public BigDecimal getR0380_stage3c_poci() {
		return r0380_stage3c_poci;
	}

	public void setR0380_stage3c_poci(BigDecimal r0380_stage3c_poci) {
		this.r0380_stage3c_poci = r0380_stage3c_poci;
	}

	public BigDecimal getR0380_current_pastdues() {
		return r0380_current_pastdues;
	}

	public void setR0380_current_pastdues(BigDecimal r0380_current_pastdues) {
		this.r0380_current_pastdues = r0380_current_pastdues;
	}

	public BigDecimal getR0380_less30days_pastdues() {
		return r0380_less30days_pastdues;
	}

	public void setR0380_less30days_pastdues(BigDecimal r0380_less30days_pastdues) {
		this.r0380_less30days_pastdues = r0380_less30days_pastdues;
	}

	public BigDecimal getR0380_31to90days_pastdues() {
		return r0380_31to90days_pastdues;
	}

	public void setR0380_31to90days_pastdues(BigDecimal r0380_31to90days_pastdues) {
		this.r0380_31to90days_pastdues = r0380_31to90days_pastdues;
	}

	public BigDecimal getR0380_91to120days_pastdues() {
		return r0380_91to120days_pastdues;
	}

	public void setR0380_91to120days_pastdues(BigDecimal r0380_91to120days_pastdues) {
		this.r0380_91to120days_pastdues = r0380_91to120days_pastdues;
	}

	public BigDecimal getR0380_121to180days_pastdues() {
		return r0380_121to180days_pastdues;
	}

	public void setR0380_121to180days_pastdues(BigDecimal r0380_121to180days_pastdues) {
		this.r0380_121to180days_pastdues = r0380_121to180days_pastdues;
	}

	public BigDecimal getR0380_181to365days_pastdues() {
		return r0380_181to365days_pastdues;
	}

	public void setR0380_181to365days_pastdues(BigDecimal r0380_181to365days_pastdues) {
		this.r0380_181to365days_pastdues = r0380_181to365days_pastdues;
	}

	public BigDecimal getR0380_over365days_pastdues() {
		return r0380_over365days_pastdues;
	}

	public void setR0380_over365days_pastdues(BigDecimal r0380_over365days_pastdues) {
		this.r0380_over365days_pastdues = r0380_over365days_pastdues;
	}

	public BigDecimal getR0380_total_pastdues() {
		return r0380_total_pastdues;
	}

	public void setR0380_total_pastdues(BigDecimal r0380_total_pastdues) {
		this.r0380_total_pastdues = r0380_total_pastdues;
	}

	public BigDecimal getR0380_newloan_duringreport() {
		return r0380_newloan_duringreport;
	}

	public void setR0380_newloan_duringreport(BigDecimal r0380_newloan_duringreport) {
		this.r0380_newloan_duringreport = r0380_newloan_duringreport;
	}

	public BigDecimal getR0380_newstage_duringreport() {
		return r0380_newstage_duringreport;
	}

	public void setR0380_newstage_duringreport(BigDecimal r0380_newstage_duringreport) {
		this.r0380_newstage_duringreport = r0380_newstage_duringreport;
	}

	public BigDecimal getR0380_intrestfees_duringreport() {
		return r0380_intrestfees_duringreport;
	}

	public void setR0380_intrestfees_duringreport(BigDecimal r0380_intrestfees_duringreport) {
		this.r0380_intrestfees_duringreport = r0380_intrestfees_duringreport;
	}

	public BigDecimal getR0380_performingac_acinfo() {
		return r0380_performingac_acinfo;
	}

	public void setR0380_performingac_acinfo(BigDecimal r0380_performingac_acinfo) {
		this.r0380_performingac_acinfo = r0380_performingac_acinfo;
	}

	public BigDecimal getR0380_nonperformingac_acinfo() {
		return r0380_nonperformingac_acinfo;
	}

	public void setR0380_nonperformingac_acinfo(BigDecimal r0380_nonperformingac_acinfo) {
		this.r0380_nonperformingac_acinfo = r0380_nonperformingac_acinfo;
	}

	public String getR0390_product() {
		return r0390_product;
	}

	public void setR0390_product(String r0390_product) {
		this.r0390_product = r0390_product;
	}

	public BigDecimal getR0390_outstandbal() {
		return r0390_outstandbal;
	}

	public void setR0390_outstandbal(BigDecimal r0390_outstandbal) {
		this.r0390_outstandbal = r0390_outstandbal;
	}

	public BigDecimal getR0390_secured_outstandbal() {
		return r0390_secured_outstandbal;
	}

	public void setR0390_secured_outstandbal(BigDecimal r0390_secured_outstandbal) {
		this.r0390_secured_outstandbal = r0390_secured_outstandbal;
	}

	public BigDecimal getR0390_unsecured_outstandbal() {
		return r0390_unsecured_outstandbal;
	}

	public void setR0390_unsecured_outstandbal(BigDecimal r0390_unsecured_outstandbal) {
		this.r0390_unsecured_outstandbal = r0390_unsecured_outstandbal;
	}

	public BigDecimal getR0390_stage1_assetclass() {
		return r0390_stage1_assetclass;
	}

	public void setR0390_stage1_assetclass(BigDecimal r0390_stage1_assetclass) {
		this.r0390_stage1_assetclass = r0390_stage1_assetclass;
	}

	public BigDecimal getR0390_stage2_assetclass() {
		return r0390_stage2_assetclass;
	}

	public void setR0390_stage2_assetclass(BigDecimal r0390_stage2_assetclass) {
		this.r0390_stage2_assetclass = r0390_stage2_assetclass;
	}

	public BigDecimal getR0390_stage3a_assetclass() {
		return r0390_stage3a_assetclass;
	}

	public void setR0390_stage3a_assetclass(BigDecimal r0390_stage3a_assetclass) {
		this.r0390_stage3a_assetclass = r0390_stage3a_assetclass;
	}

	public BigDecimal getR0390_stage3b_assetclass() {
		return r0390_stage3b_assetclass;
	}

	public void setR0390_stage3b_assetclass(BigDecimal r0390_stage3b_assetclass) {
		this.r0390_stage3b_assetclass = r0390_stage3b_assetclass;
	}

	public BigDecimal getR0390_stage3c_assetclass() {
		return r0390_stage3c_assetclass;
	}

	public void setR0390_stage3c_assetclass(BigDecimal r0390_stage3c_assetclass) {
		this.r0390_stage3c_assetclass = r0390_stage3c_assetclass;
	}

	public BigDecimal getR0390_stage1_provisionheld() {
		return r0390_stage1_provisionheld;
	}

	public void setR0390_stage1_provisionheld(BigDecimal r0390_stage1_provisionheld) {
		this.r0390_stage1_provisionheld = r0390_stage1_provisionheld;
	}

	public BigDecimal getR0390_stage2_provisionheld() {
		return r0390_stage2_provisionheld;
	}

	public void setR0390_stage2_provisionheld(BigDecimal r0390_stage2_provisionheld) {
		this.r0390_stage2_provisionheld = r0390_stage2_provisionheld;
	}

	public BigDecimal getR0390_stage3a_provisionheld() {
		return r0390_stage3a_provisionheld;
	}

	public void setR0390_stage3a_provisionheld(BigDecimal r0390_stage3a_provisionheld) {
		this.r0390_stage3a_provisionheld = r0390_stage3a_provisionheld;
	}

	public BigDecimal getR0390_stage3b_provisionheld() {
		return r0390_stage3b_provisionheld;
	}

	public void setR0390_stage3b_provisionheld(BigDecimal r0390_stage3b_provisionheld) {
		this.r0390_stage3b_provisionheld = r0390_stage3b_provisionheld;
	}

	public BigDecimal getR0390_stage3c_provisionheld() {
		return r0390_stage3c_provisionheld;
	}

	public void setR0390_stage3c_provisionheld(BigDecimal r0390_stage3c_provisionheld) {
		this.r0390_stage3c_provisionheld = r0390_stage3c_provisionheld;
	}

	public BigDecimal getR0390_intrestfees_provisionheld() {
		return r0390_intrestfees_provisionheld;
	}

	public void setR0390_intrestfees_provisionheld(BigDecimal r0390_intrestfees_provisionheld) {
		this.r0390_intrestfees_provisionheld = r0390_intrestfees_provisionheld;
	}

	public BigDecimal getR0390_intrestsuspense_provisionheld() {
		return r0390_intrestsuspense_provisionheld;
	}

	public void setR0390_intrestsuspense_provisionheld(BigDecimal r0390_intrestsuspense_provisionheld) {
		this.r0390_intrestsuspense_provisionheld = r0390_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0390_stage1_poci() {
		return r0390_stage1_poci;
	}

	public void setR0390_stage1_poci(BigDecimal r0390_stage1_poci) {
		this.r0390_stage1_poci = r0390_stage1_poci;
	}

	public BigDecimal getR0390_stage2_poci() {
		return r0390_stage2_poci;
	}

	public void setR0390_stage2_poci(BigDecimal r0390_stage2_poci) {
		this.r0390_stage2_poci = r0390_stage2_poci;
	}

	public BigDecimal getR0390_stage3a_poci() {
		return r0390_stage3a_poci;
	}

	public void setR0390_stage3a_poci(BigDecimal r0390_stage3a_poci) {
		this.r0390_stage3a_poci = r0390_stage3a_poci;
	}

	public BigDecimal getR0390_stage3b_poci() {
		return r0390_stage3b_poci;
	}

	public void setR0390_stage3b_poci(BigDecimal r0390_stage3b_poci) {
		this.r0390_stage3b_poci = r0390_stage3b_poci;
	}

	public BigDecimal getR0390_stage3c_poci() {
		return r0390_stage3c_poci;
	}

	public void setR0390_stage3c_poci(BigDecimal r0390_stage3c_poci) {
		this.r0390_stage3c_poci = r0390_stage3c_poci;
	}

	public BigDecimal getR0390_current_pastdues() {
		return r0390_current_pastdues;
	}

	public void setR0390_current_pastdues(BigDecimal r0390_current_pastdues) {
		this.r0390_current_pastdues = r0390_current_pastdues;
	}

	public BigDecimal getR0390_less30days_pastdues() {
		return r0390_less30days_pastdues;
	}

	public void setR0390_less30days_pastdues(BigDecimal r0390_less30days_pastdues) {
		this.r0390_less30days_pastdues = r0390_less30days_pastdues;
	}

	public BigDecimal getR0390_31to90days_pastdues() {
		return r0390_31to90days_pastdues;
	}

	public void setR0390_31to90days_pastdues(BigDecimal r0390_31to90days_pastdues) {
		this.r0390_31to90days_pastdues = r0390_31to90days_pastdues;
	}

	public BigDecimal getR0390_91to120days_pastdues() {
		return r0390_91to120days_pastdues;
	}

	public void setR0390_91to120days_pastdues(BigDecimal r0390_91to120days_pastdues) {
		this.r0390_91to120days_pastdues = r0390_91to120days_pastdues;
	}

	public BigDecimal getR0390_121to180days_pastdues() {
		return r0390_121to180days_pastdues;
	}

	public void setR0390_121to180days_pastdues(BigDecimal r0390_121to180days_pastdues) {
		this.r0390_121to180days_pastdues = r0390_121to180days_pastdues;
	}

	public BigDecimal getR0390_181to365days_pastdues() {
		return r0390_181to365days_pastdues;
	}

	public void setR0390_181to365days_pastdues(BigDecimal r0390_181to365days_pastdues) {
		this.r0390_181to365days_pastdues = r0390_181to365days_pastdues;
	}

	public BigDecimal getR0390_over365days_pastdues() {
		return r0390_over365days_pastdues;
	}

	public void setR0390_over365days_pastdues(BigDecimal r0390_over365days_pastdues) {
		this.r0390_over365days_pastdues = r0390_over365days_pastdues;
	}

	public BigDecimal getR0390_total_pastdues() {
		return r0390_total_pastdues;
	}

	public void setR0390_total_pastdues(BigDecimal r0390_total_pastdues) {
		this.r0390_total_pastdues = r0390_total_pastdues;
	}

	public BigDecimal getR0390_newloan_duringreport() {
		return r0390_newloan_duringreport;
	}

	public void setR0390_newloan_duringreport(BigDecimal r0390_newloan_duringreport) {
		this.r0390_newloan_duringreport = r0390_newloan_duringreport;
	}

	public BigDecimal getR0390_newstage_duringreport() {
		return r0390_newstage_duringreport;
	}

	public void setR0390_newstage_duringreport(BigDecimal r0390_newstage_duringreport) {
		this.r0390_newstage_duringreport = r0390_newstage_duringreport;
	}

	public BigDecimal getR0390_intrestfees_duringreport() {
		return r0390_intrestfees_duringreport;
	}

	public void setR0390_intrestfees_duringreport(BigDecimal r0390_intrestfees_duringreport) {
		this.r0390_intrestfees_duringreport = r0390_intrestfees_duringreport;
	}

	public BigDecimal getR0390_performingac_acinfo() {
		return r0390_performingac_acinfo;
	}

	public void setR0390_performingac_acinfo(BigDecimal r0390_performingac_acinfo) {
		this.r0390_performingac_acinfo = r0390_performingac_acinfo;
	}

	public BigDecimal getR0390_nonperformingac_acinfo() {
		return r0390_nonperformingac_acinfo;
	}

	public void setR0390_nonperformingac_acinfo(BigDecimal r0390_nonperformingac_acinfo) {
		this.r0390_nonperformingac_acinfo = r0390_nonperformingac_acinfo;
	}

	public String getR0400_product() {
		return r0400_product;
	}

	public void setR0400_product(String r0400_product) {
		this.r0400_product = r0400_product;
	}

	public BigDecimal getR0400_outstandbal() {
		return r0400_outstandbal;
	}

	public void setR0400_outstandbal(BigDecimal r0400_outstandbal) {
		this.r0400_outstandbal = r0400_outstandbal;
	}

	public BigDecimal getR0400_secured_outstandbal() {
		return r0400_secured_outstandbal;
	}

	public void setR0400_secured_outstandbal(BigDecimal r0400_secured_outstandbal) {
		this.r0400_secured_outstandbal = r0400_secured_outstandbal;
	}

	public BigDecimal getR0400_unsecured_outstandbal() {
		return r0400_unsecured_outstandbal;
	}

	public void setR0400_unsecured_outstandbal(BigDecimal r0400_unsecured_outstandbal) {
		this.r0400_unsecured_outstandbal = r0400_unsecured_outstandbal;
	}

	public BigDecimal getR0400_stage1_assetclass() {
		return r0400_stage1_assetclass;
	}

	public void setR0400_stage1_assetclass(BigDecimal r0400_stage1_assetclass) {
		this.r0400_stage1_assetclass = r0400_stage1_assetclass;
	}

	public BigDecimal getR0400_stage2_assetclass() {
		return r0400_stage2_assetclass;
	}

	public void setR0400_stage2_assetclass(BigDecimal r0400_stage2_assetclass) {
		this.r0400_stage2_assetclass = r0400_stage2_assetclass;
	}

	public BigDecimal getR0400_stage3a_assetclass() {
		return r0400_stage3a_assetclass;
	}

	public void setR0400_stage3a_assetclass(BigDecimal r0400_stage3a_assetclass) {
		this.r0400_stage3a_assetclass = r0400_stage3a_assetclass;
	}

	public BigDecimal getR0400_stage3b_assetclass() {
		return r0400_stage3b_assetclass;
	}

	public void setR0400_stage3b_assetclass(BigDecimal r0400_stage3b_assetclass) {
		this.r0400_stage3b_assetclass = r0400_stage3b_assetclass;
	}

	public BigDecimal getR0400_stage3c_assetclass() {
		return r0400_stage3c_assetclass;
	}

	public void setR0400_stage3c_assetclass(BigDecimal r0400_stage3c_assetclass) {
		this.r0400_stage3c_assetclass = r0400_stage3c_assetclass;
	}

	public BigDecimal getR0400_stage1_provisionheld() {
		return r0400_stage1_provisionheld;
	}

	public void setR0400_stage1_provisionheld(BigDecimal r0400_stage1_provisionheld) {
		this.r0400_stage1_provisionheld = r0400_stage1_provisionheld;
	}

	public BigDecimal getR0400_stage2_provisionheld() {
		return r0400_stage2_provisionheld;
	}

	public void setR0400_stage2_provisionheld(BigDecimal r0400_stage2_provisionheld) {
		this.r0400_stage2_provisionheld = r0400_stage2_provisionheld;
	}

	public BigDecimal getR0400_stage3a_provisionheld() {
		return r0400_stage3a_provisionheld;
	}

	public void setR0400_stage3a_provisionheld(BigDecimal r0400_stage3a_provisionheld) {
		this.r0400_stage3a_provisionheld = r0400_stage3a_provisionheld;
	}

	public BigDecimal getR0400_stage3b_provisionheld() {
		return r0400_stage3b_provisionheld;
	}

	public void setR0400_stage3b_provisionheld(BigDecimal r0400_stage3b_provisionheld) {
		this.r0400_stage3b_provisionheld = r0400_stage3b_provisionheld;
	}

	public BigDecimal getR0400_stage3c_provisionheld() {
		return r0400_stage3c_provisionheld;
	}

	public void setR0400_stage3c_provisionheld(BigDecimal r0400_stage3c_provisionheld) {
		this.r0400_stage3c_provisionheld = r0400_stage3c_provisionheld;
	}

	public BigDecimal getR0400_intrestfees_provisionheld() {
		return r0400_intrestfees_provisionheld;
	}

	public void setR0400_intrestfees_provisionheld(BigDecimal r0400_intrestfees_provisionheld) {
		this.r0400_intrestfees_provisionheld = r0400_intrestfees_provisionheld;
	}

	public BigDecimal getR0400_intrestsuspense_provisionheld() {
		return r0400_intrestsuspense_provisionheld;
	}

	public void setR0400_intrestsuspense_provisionheld(BigDecimal r0400_intrestsuspense_provisionheld) {
		this.r0400_intrestsuspense_provisionheld = r0400_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0400_stage1_poci() {
		return r0400_stage1_poci;
	}

	public void setR0400_stage1_poci(BigDecimal r0400_stage1_poci) {
		this.r0400_stage1_poci = r0400_stage1_poci;
	}

	public BigDecimal getR0400_stage2_poci() {
		return r0400_stage2_poci;
	}

	public void setR0400_stage2_poci(BigDecimal r0400_stage2_poci) {
		this.r0400_stage2_poci = r0400_stage2_poci;
	}

	public BigDecimal getR0400_stage3a_poci() {
		return r0400_stage3a_poci;
	}

	public void setR0400_stage3a_poci(BigDecimal r0400_stage3a_poci) {
		this.r0400_stage3a_poci = r0400_stage3a_poci;
	}

	public BigDecimal getR0400_stage3b_poci() {
		return r0400_stage3b_poci;
	}

	public void setR0400_stage3b_poci(BigDecimal r0400_stage3b_poci) {
		this.r0400_stage3b_poci = r0400_stage3b_poci;
	}

	public BigDecimal getR0400_stage3c_poci() {
		return r0400_stage3c_poci;
	}

	public void setR0400_stage3c_poci(BigDecimal r0400_stage3c_poci) {
		this.r0400_stage3c_poci = r0400_stage3c_poci;
	}

	public BigDecimal getR0400_current_pastdues() {
		return r0400_current_pastdues;
	}

	public void setR0400_current_pastdues(BigDecimal r0400_current_pastdues) {
		this.r0400_current_pastdues = r0400_current_pastdues;
	}

	public BigDecimal getR0400_less30days_pastdues() {
		return r0400_less30days_pastdues;
	}

	public void setR0400_less30days_pastdues(BigDecimal r0400_less30days_pastdues) {
		this.r0400_less30days_pastdues = r0400_less30days_pastdues;
	}

	public BigDecimal getR0400_31to90days_pastdues() {
		return r0400_31to90days_pastdues;
	}

	public void setR0400_31to90days_pastdues(BigDecimal r0400_31to90days_pastdues) {
		this.r0400_31to90days_pastdues = r0400_31to90days_pastdues;
	}

	public BigDecimal getR0400_91to120days_pastdues() {
		return r0400_91to120days_pastdues;
	}

	public void setR0400_91to120days_pastdues(BigDecimal r0400_91to120days_pastdues) {
		this.r0400_91to120days_pastdues = r0400_91to120days_pastdues;
	}

	public BigDecimal getR0400_121to180days_pastdues() {
		return r0400_121to180days_pastdues;
	}

	public void setR0400_121to180days_pastdues(BigDecimal r0400_121to180days_pastdues) {
		this.r0400_121to180days_pastdues = r0400_121to180days_pastdues;
	}

	public BigDecimal getR0400_181to365days_pastdues() {
		return r0400_181to365days_pastdues;
	}

	public void setR0400_181to365days_pastdues(BigDecimal r0400_181to365days_pastdues) {
		this.r0400_181to365days_pastdues = r0400_181to365days_pastdues;
	}

	public BigDecimal getR0400_over365days_pastdues() {
		return r0400_over365days_pastdues;
	}

	public void setR0400_over365days_pastdues(BigDecimal r0400_over365days_pastdues) {
		this.r0400_over365days_pastdues = r0400_over365days_pastdues;
	}

	public BigDecimal getR0400_total_pastdues() {
		return r0400_total_pastdues;
	}

	public void setR0400_total_pastdues(BigDecimal r0400_total_pastdues) {
		this.r0400_total_pastdues = r0400_total_pastdues;
	}

	public BigDecimal getR0400_newloan_duringreport() {
		return r0400_newloan_duringreport;
	}

	public void setR0400_newloan_duringreport(BigDecimal r0400_newloan_duringreport) {
		this.r0400_newloan_duringreport = r0400_newloan_duringreport;
	}

	public BigDecimal getR0400_newstage_duringreport() {
		return r0400_newstage_duringreport;
	}

	public void setR0400_newstage_duringreport(BigDecimal r0400_newstage_duringreport) {
		this.r0400_newstage_duringreport = r0400_newstage_duringreport;
	}

	public BigDecimal getR0400_intrestfees_duringreport() {
		return r0400_intrestfees_duringreport;
	}

	public void setR0400_intrestfees_duringreport(BigDecimal r0400_intrestfees_duringreport) {
		this.r0400_intrestfees_duringreport = r0400_intrestfees_duringreport;
	}

	public BigDecimal getR0400_performingac_acinfo() {
		return r0400_performingac_acinfo;
	}

	public void setR0400_performingac_acinfo(BigDecimal r0400_performingac_acinfo) {
		this.r0400_performingac_acinfo = r0400_performingac_acinfo;
	}

	public BigDecimal getR0400_nonperformingac_acinfo() {
		return r0400_nonperformingac_acinfo;
	}

	public void setR0400_nonperformingac_acinfo(BigDecimal r0400_nonperformingac_acinfo) {
		this.r0400_nonperformingac_acinfo = r0400_nonperformingac_acinfo;
	}

	public String getR0410_product() {
		return r0410_product;
	}

	public void setR0410_product(String r0410_product) {
		this.r0410_product = r0410_product;
	}

	public BigDecimal getR0410_outstandbal() {
		return r0410_outstandbal;
	}

	public void setR0410_outstandbal(BigDecimal r0410_outstandbal) {
		this.r0410_outstandbal = r0410_outstandbal;
	}

	public BigDecimal getR0410_secured_outstandbal() {
		return r0410_secured_outstandbal;
	}

	public void setR0410_secured_outstandbal(BigDecimal r0410_secured_outstandbal) {
		this.r0410_secured_outstandbal = r0410_secured_outstandbal;
	}

	public BigDecimal getR0410_unsecured_outstandbal() {
		return r0410_unsecured_outstandbal;
	}

	public void setR0410_unsecured_outstandbal(BigDecimal r0410_unsecured_outstandbal) {
		this.r0410_unsecured_outstandbal = r0410_unsecured_outstandbal;
	}

	public BigDecimal getR0410_stage1_assetclass() {
		return r0410_stage1_assetclass;
	}

	public void setR0410_stage1_assetclass(BigDecimal r0410_stage1_assetclass) {
		this.r0410_stage1_assetclass = r0410_stage1_assetclass;
	}

	public BigDecimal getR0410_stage2_assetclass() {
		return r0410_stage2_assetclass;
	}

	public void setR0410_stage2_assetclass(BigDecimal r0410_stage2_assetclass) {
		this.r0410_stage2_assetclass = r0410_stage2_assetclass;
	}

	public BigDecimal getR0410_stage3a_assetclass() {
		return r0410_stage3a_assetclass;
	}

	public void setR0410_stage3a_assetclass(BigDecimal r0410_stage3a_assetclass) {
		this.r0410_stage3a_assetclass = r0410_stage3a_assetclass;
	}

	public BigDecimal getR0410_stage3b_assetclass() {
		return r0410_stage3b_assetclass;
	}

	public void setR0410_stage3b_assetclass(BigDecimal r0410_stage3b_assetclass) {
		this.r0410_stage3b_assetclass = r0410_stage3b_assetclass;
	}

	public BigDecimal getR0410_stage3c_assetclass() {
		return r0410_stage3c_assetclass;
	}

	public void setR0410_stage3c_assetclass(BigDecimal r0410_stage3c_assetclass) {
		this.r0410_stage3c_assetclass = r0410_stage3c_assetclass;
	}

	public BigDecimal getR0410_stage1_provisionheld() {
		return r0410_stage1_provisionheld;
	}

	public void setR0410_stage1_provisionheld(BigDecimal r0410_stage1_provisionheld) {
		this.r0410_stage1_provisionheld = r0410_stage1_provisionheld;
	}

	public BigDecimal getR0410_stage2_provisionheld() {
		return r0410_stage2_provisionheld;
	}

	public void setR0410_stage2_provisionheld(BigDecimal r0410_stage2_provisionheld) {
		this.r0410_stage2_provisionheld = r0410_stage2_provisionheld;
	}

	public BigDecimal getR0410_stage3a_provisionheld() {
		return r0410_stage3a_provisionheld;
	}

	public void setR0410_stage3a_provisionheld(BigDecimal r0410_stage3a_provisionheld) {
		this.r0410_stage3a_provisionheld = r0410_stage3a_provisionheld;
	}

	public BigDecimal getR0410_stage3b_provisionheld() {
		return r0410_stage3b_provisionheld;
	}

	public void setR0410_stage3b_provisionheld(BigDecimal r0410_stage3b_provisionheld) {
		this.r0410_stage3b_provisionheld = r0410_stage3b_provisionheld;
	}

	public BigDecimal getR0410_stage3c_provisionheld() {
		return r0410_stage3c_provisionheld;
	}

	public void setR0410_stage3c_provisionheld(BigDecimal r0410_stage3c_provisionheld) {
		this.r0410_stage3c_provisionheld = r0410_stage3c_provisionheld;
	}

	public BigDecimal getR0410_intrestfees_provisionheld() {
		return r0410_intrestfees_provisionheld;
	}

	public void setR0410_intrestfees_provisionheld(BigDecimal r0410_intrestfees_provisionheld) {
		this.r0410_intrestfees_provisionheld = r0410_intrestfees_provisionheld;
	}

	public BigDecimal getR0410_intrestsuspense_provisionheld() {
		return r0410_intrestsuspense_provisionheld;
	}

	public void setR0410_intrestsuspense_provisionheld(BigDecimal r0410_intrestsuspense_provisionheld) {
		this.r0410_intrestsuspense_provisionheld = r0410_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0410_stage1_poci() {
		return r0410_stage1_poci;
	}

	public void setR0410_stage1_poci(BigDecimal r0410_stage1_poci) {
		this.r0410_stage1_poci = r0410_stage1_poci;
	}

	public BigDecimal getR0410_stage2_poci() {
		return r0410_stage2_poci;
	}

	public void setR0410_stage2_poci(BigDecimal r0410_stage2_poci) {
		this.r0410_stage2_poci = r0410_stage2_poci;
	}

	public BigDecimal getR0410_stage3a_poci() {
		return r0410_stage3a_poci;
	}

	public void setR0410_stage3a_poci(BigDecimal r0410_stage3a_poci) {
		this.r0410_stage3a_poci = r0410_stage3a_poci;
	}

	public BigDecimal getR0410_stage3b_poci() {
		return r0410_stage3b_poci;
	}

	public void setR0410_stage3b_poci(BigDecimal r0410_stage3b_poci) {
		this.r0410_stage3b_poci = r0410_stage3b_poci;
	}

	public BigDecimal getR0410_stage3c_poci() {
		return r0410_stage3c_poci;
	}

	public void setR0410_stage3c_poci(BigDecimal r0410_stage3c_poci) {
		this.r0410_stage3c_poci = r0410_stage3c_poci;
	}

	public BigDecimal getR0410_current_pastdues() {
		return r0410_current_pastdues;
	}

	public void setR0410_current_pastdues(BigDecimal r0410_current_pastdues) {
		this.r0410_current_pastdues = r0410_current_pastdues;
	}

	public BigDecimal getR0410_less30days_pastdues() {
		return r0410_less30days_pastdues;
	}

	public void setR0410_less30days_pastdues(BigDecimal r0410_less30days_pastdues) {
		this.r0410_less30days_pastdues = r0410_less30days_pastdues;
	}

	public BigDecimal getR0410_31to90days_pastdues() {
		return r0410_31to90days_pastdues;
	}

	public void setR0410_31to90days_pastdues(BigDecimal r0410_31to90days_pastdues) {
		this.r0410_31to90days_pastdues = r0410_31to90days_pastdues;
	}

	public BigDecimal getR0410_91to120days_pastdues() {
		return r0410_91to120days_pastdues;
	}

	public void setR0410_91to120days_pastdues(BigDecimal r0410_91to120days_pastdues) {
		this.r0410_91to120days_pastdues = r0410_91to120days_pastdues;
	}

	public BigDecimal getR0410_121to180days_pastdues() {
		return r0410_121to180days_pastdues;
	}

	public void setR0410_121to180days_pastdues(BigDecimal r0410_121to180days_pastdues) {
		this.r0410_121to180days_pastdues = r0410_121to180days_pastdues;
	}

	public BigDecimal getR0410_181to365days_pastdues() {
		return r0410_181to365days_pastdues;
	}

	public void setR0410_181to365days_pastdues(BigDecimal r0410_181to365days_pastdues) {
		this.r0410_181to365days_pastdues = r0410_181to365days_pastdues;
	}

	public BigDecimal getR0410_over365days_pastdues() {
		return r0410_over365days_pastdues;
	}

	public void setR0410_over365days_pastdues(BigDecimal r0410_over365days_pastdues) {
		this.r0410_over365days_pastdues = r0410_over365days_pastdues;
	}

	public BigDecimal getR0410_total_pastdues() {
		return r0410_total_pastdues;
	}

	public void setR0410_total_pastdues(BigDecimal r0410_total_pastdues) {
		this.r0410_total_pastdues = r0410_total_pastdues;
	}

	public BigDecimal getR0410_newloan_duringreport() {
		return r0410_newloan_duringreport;
	}

	public void setR0410_newloan_duringreport(BigDecimal r0410_newloan_duringreport) {
		this.r0410_newloan_duringreport = r0410_newloan_duringreport;
	}

	public BigDecimal getR0410_newstage_duringreport() {
		return r0410_newstage_duringreport;
	}

	public void setR0410_newstage_duringreport(BigDecimal r0410_newstage_duringreport) {
		this.r0410_newstage_duringreport = r0410_newstage_duringreport;
	}

	public BigDecimal getR0410_intrestfees_duringreport() {
		return r0410_intrestfees_duringreport;
	}

	public void setR0410_intrestfees_duringreport(BigDecimal r0410_intrestfees_duringreport) {
		this.r0410_intrestfees_duringreport = r0410_intrestfees_duringreport;
	}

	public BigDecimal getR0410_performingac_acinfo() {
		return r0410_performingac_acinfo;
	}

	public void setR0410_performingac_acinfo(BigDecimal r0410_performingac_acinfo) {
		this.r0410_performingac_acinfo = r0410_performingac_acinfo;
	}

	public BigDecimal getR0410_nonperformingac_acinfo() {
		return r0410_nonperformingac_acinfo;
	}

	public void setR0410_nonperformingac_acinfo(BigDecimal r0410_nonperformingac_acinfo) {
		this.r0410_nonperformingac_acinfo = r0410_nonperformingac_acinfo;
	}

	public String getR0420_product() {
		return r0420_product;
	}

	public void setR0420_product(String r0420_product) {
		this.r0420_product = r0420_product;
	}

	public BigDecimal getR0420_outstandbal() {
		return r0420_outstandbal;
	}

	public void setR0420_outstandbal(BigDecimal r0420_outstandbal) {
		this.r0420_outstandbal = r0420_outstandbal;
	}

	public BigDecimal getR0420_secured_outstandbal() {
		return r0420_secured_outstandbal;
	}

	public void setR0420_secured_outstandbal(BigDecimal r0420_secured_outstandbal) {
		this.r0420_secured_outstandbal = r0420_secured_outstandbal;
	}

	public BigDecimal getR0420_unsecured_outstandbal() {
		return r0420_unsecured_outstandbal;
	}

	public void setR0420_unsecured_outstandbal(BigDecimal r0420_unsecured_outstandbal) {
		this.r0420_unsecured_outstandbal = r0420_unsecured_outstandbal;
	}

	public BigDecimal getR0420_stage1_assetclass() {
		return r0420_stage1_assetclass;
	}

	public void setR0420_stage1_assetclass(BigDecimal r0420_stage1_assetclass) {
		this.r0420_stage1_assetclass = r0420_stage1_assetclass;
	}

	public BigDecimal getR0420_stage2_assetclass() {
		return r0420_stage2_assetclass;
	}

	public void setR0420_stage2_assetclass(BigDecimal r0420_stage2_assetclass) {
		this.r0420_stage2_assetclass = r0420_stage2_assetclass;
	}

	public BigDecimal getR0420_stage3a_assetclass() {
		return r0420_stage3a_assetclass;
	}

	public void setR0420_stage3a_assetclass(BigDecimal r0420_stage3a_assetclass) {
		this.r0420_stage3a_assetclass = r0420_stage3a_assetclass;
	}

	public BigDecimal getR0420_stage3b_assetclass() {
		return r0420_stage3b_assetclass;
	}

	public void setR0420_stage3b_assetclass(BigDecimal r0420_stage3b_assetclass) {
		this.r0420_stage3b_assetclass = r0420_stage3b_assetclass;
	}

	public BigDecimal getR0420_stage3c_assetclass() {
		return r0420_stage3c_assetclass;
	}

	public void setR0420_stage3c_assetclass(BigDecimal r0420_stage3c_assetclass) {
		this.r0420_stage3c_assetclass = r0420_stage3c_assetclass;
	}

	public BigDecimal getR0420_stage1_provisionheld() {
		return r0420_stage1_provisionheld;
	}

	public void setR0420_stage1_provisionheld(BigDecimal r0420_stage1_provisionheld) {
		this.r0420_stage1_provisionheld = r0420_stage1_provisionheld;
	}

	public BigDecimal getR0420_stage2_provisionheld() {
		return r0420_stage2_provisionheld;
	}

	public void setR0420_stage2_provisionheld(BigDecimal r0420_stage2_provisionheld) {
		this.r0420_stage2_provisionheld = r0420_stage2_provisionheld;
	}

	public BigDecimal getR0420_stage3a_provisionheld() {
		return r0420_stage3a_provisionheld;
	}

	public void setR0420_stage3a_provisionheld(BigDecimal r0420_stage3a_provisionheld) {
		this.r0420_stage3a_provisionheld = r0420_stage3a_provisionheld;
	}

	public BigDecimal getR0420_stage3b_provisionheld() {
		return r0420_stage3b_provisionheld;
	}

	public void setR0420_stage3b_provisionheld(BigDecimal r0420_stage3b_provisionheld) {
		this.r0420_stage3b_provisionheld = r0420_stage3b_provisionheld;
	}

	public BigDecimal getR0420_stage3c_provisionheld() {
		return r0420_stage3c_provisionheld;
	}

	public void setR0420_stage3c_provisionheld(BigDecimal r0420_stage3c_provisionheld) {
		this.r0420_stage3c_provisionheld = r0420_stage3c_provisionheld;
	}

	public BigDecimal getR0420_intrestfees_provisionheld() {
		return r0420_intrestfees_provisionheld;
	}

	public void setR0420_intrestfees_provisionheld(BigDecimal r0420_intrestfees_provisionheld) {
		this.r0420_intrestfees_provisionheld = r0420_intrestfees_provisionheld;
	}

	public BigDecimal getR0420_intrestsuspense_provisionheld() {
		return r0420_intrestsuspense_provisionheld;
	}

	public void setR0420_intrestsuspense_provisionheld(BigDecimal r0420_intrestsuspense_provisionheld) {
		this.r0420_intrestsuspense_provisionheld = r0420_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0420_stage1_poci() {
		return r0420_stage1_poci;
	}

	public void setR0420_stage1_poci(BigDecimal r0420_stage1_poci) {
		this.r0420_stage1_poci = r0420_stage1_poci;
	}

	public BigDecimal getR0420_stage2_poci() {
		return r0420_stage2_poci;
	}

	public void setR0420_stage2_poci(BigDecimal r0420_stage2_poci) {
		this.r0420_stage2_poci = r0420_stage2_poci;
	}

	public BigDecimal getR0420_stage3a_poci() {
		return r0420_stage3a_poci;
	}

	public void setR0420_stage3a_poci(BigDecimal r0420_stage3a_poci) {
		this.r0420_stage3a_poci = r0420_stage3a_poci;
	}

	public BigDecimal getR0420_stage3b_poci() {
		return r0420_stage3b_poci;
	}

	public void setR0420_stage3b_poci(BigDecimal r0420_stage3b_poci) {
		this.r0420_stage3b_poci = r0420_stage3b_poci;
	}

	public BigDecimal getR0420_stage3c_poci() {
		return r0420_stage3c_poci;
	}

	public void setR0420_stage3c_poci(BigDecimal r0420_stage3c_poci) {
		this.r0420_stage3c_poci = r0420_stage3c_poci;
	}

	public BigDecimal getR0420_current_pastdues() {
		return r0420_current_pastdues;
	}

	public void setR0420_current_pastdues(BigDecimal r0420_current_pastdues) {
		this.r0420_current_pastdues = r0420_current_pastdues;
	}

	public BigDecimal getR0420_less30days_pastdues() {
		return r0420_less30days_pastdues;
	}

	public void setR0420_less30days_pastdues(BigDecimal r0420_less30days_pastdues) {
		this.r0420_less30days_pastdues = r0420_less30days_pastdues;
	}

	public BigDecimal getR0420_31to90days_pastdues() {
		return r0420_31to90days_pastdues;
	}

	public void setR0420_31to90days_pastdues(BigDecimal r0420_31to90days_pastdues) {
		this.r0420_31to90days_pastdues = r0420_31to90days_pastdues;
	}

	public BigDecimal getR0420_91to120days_pastdues() {
		return r0420_91to120days_pastdues;
	}

	public void setR0420_91to120days_pastdues(BigDecimal r0420_91to120days_pastdues) {
		this.r0420_91to120days_pastdues = r0420_91to120days_pastdues;
	}

	public BigDecimal getR0420_121to180days_pastdues() {
		return r0420_121to180days_pastdues;
	}

	public void setR0420_121to180days_pastdues(BigDecimal r0420_121to180days_pastdues) {
		this.r0420_121to180days_pastdues = r0420_121to180days_pastdues;
	}

	public BigDecimal getR0420_181to365days_pastdues() {
		return r0420_181to365days_pastdues;
	}

	public void setR0420_181to365days_pastdues(BigDecimal r0420_181to365days_pastdues) {
		this.r0420_181to365days_pastdues = r0420_181to365days_pastdues;
	}

	public BigDecimal getR0420_over365days_pastdues() {
		return r0420_over365days_pastdues;
	}

	public void setR0420_over365days_pastdues(BigDecimal r0420_over365days_pastdues) {
		this.r0420_over365days_pastdues = r0420_over365days_pastdues;
	}

	public BigDecimal getR0420_total_pastdues() {
		return r0420_total_pastdues;
	}

	public void setR0420_total_pastdues(BigDecimal r0420_total_pastdues) {
		this.r0420_total_pastdues = r0420_total_pastdues;
	}

	public BigDecimal getR0420_newloan_duringreport() {
		return r0420_newloan_duringreport;
	}

	public void setR0420_newloan_duringreport(BigDecimal r0420_newloan_duringreport) {
		this.r0420_newloan_duringreport = r0420_newloan_duringreport;
	}

	public BigDecimal getR0420_newstage_duringreport() {
		return r0420_newstage_duringreport;
	}

	public void setR0420_newstage_duringreport(BigDecimal r0420_newstage_duringreport) {
		this.r0420_newstage_duringreport = r0420_newstage_duringreport;
	}

	public BigDecimal getR0420_intrestfees_duringreport() {
		return r0420_intrestfees_duringreport;
	}

	public void setR0420_intrestfees_duringreport(BigDecimal r0420_intrestfees_duringreport) {
		this.r0420_intrestfees_duringreport = r0420_intrestfees_duringreport;
	}

	public BigDecimal getR0420_performingac_acinfo() {
		return r0420_performingac_acinfo;
	}

	public void setR0420_performingac_acinfo(BigDecimal r0420_performingac_acinfo) {
		this.r0420_performingac_acinfo = r0420_performingac_acinfo;
	}

	public BigDecimal getR0420_nonperformingac_acinfo() {
		return r0420_nonperformingac_acinfo;
	}

	public void setR0420_nonperformingac_acinfo(BigDecimal r0420_nonperformingac_acinfo) {
		this.r0420_nonperformingac_acinfo = r0420_nonperformingac_acinfo;
	}

	public String getR0430_product() {
		return r0430_product;
	}

	public void setR0430_product(String r0430_product) {
		this.r0430_product = r0430_product;
	}

	public BigDecimal getR0430_outstandbal() {
		return r0430_outstandbal;
	}

	public void setR0430_outstandbal(BigDecimal r0430_outstandbal) {
		this.r0430_outstandbal = r0430_outstandbal;
	}

	public BigDecimal getR0430_secured_outstandbal() {
		return r0430_secured_outstandbal;
	}

	public void setR0430_secured_outstandbal(BigDecimal r0430_secured_outstandbal) {
		this.r0430_secured_outstandbal = r0430_secured_outstandbal;
	}

	public BigDecimal getR0430_unsecured_outstandbal() {
		return r0430_unsecured_outstandbal;
	}

	public void setR0430_unsecured_outstandbal(BigDecimal r0430_unsecured_outstandbal) {
		this.r0430_unsecured_outstandbal = r0430_unsecured_outstandbal;
	}

	public BigDecimal getR0430_stage1_assetclass() {
		return r0430_stage1_assetclass;
	}

	public void setR0430_stage1_assetclass(BigDecimal r0430_stage1_assetclass) {
		this.r0430_stage1_assetclass = r0430_stage1_assetclass;
	}

	public BigDecimal getR0430_stage2_assetclass() {
		return r0430_stage2_assetclass;
	}

	public void setR0430_stage2_assetclass(BigDecimal r0430_stage2_assetclass) {
		this.r0430_stage2_assetclass = r0430_stage2_assetclass;
	}

	public BigDecimal getR0430_stage3a_assetclass() {
		return r0430_stage3a_assetclass;
	}

	public void setR0430_stage3a_assetclass(BigDecimal r0430_stage3a_assetclass) {
		this.r0430_stage3a_assetclass = r0430_stage3a_assetclass;
	}

	public BigDecimal getR0430_stage3b_assetclass() {
		return r0430_stage3b_assetclass;
	}

	public void setR0430_stage3b_assetclass(BigDecimal r0430_stage3b_assetclass) {
		this.r0430_stage3b_assetclass = r0430_stage3b_assetclass;
	}

	public BigDecimal getR0430_stage3c_assetclass() {
		return r0430_stage3c_assetclass;
	}

	public void setR0430_stage3c_assetclass(BigDecimal r0430_stage3c_assetclass) {
		this.r0430_stage3c_assetclass = r0430_stage3c_assetclass;
	}

	public BigDecimal getR0430_stage1_provisionheld() {
		return r0430_stage1_provisionheld;
	}

	public void setR0430_stage1_provisionheld(BigDecimal r0430_stage1_provisionheld) {
		this.r0430_stage1_provisionheld = r0430_stage1_provisionheld;
	}

	public BigDecimal getR0430_stage2_provisionheld() {
		return r0430_stage2_provisionheld;
	}

	public void setR0430_stage2_provisionheld(BigDecimal r0430_stage2_provisionheld) {
		this.r0430_stage2_provisionheld = r0430_stage2_provisionheld;
	}

	public BigDecimal getR0430_stage3a_provisionheld() {
		return r0430_stage3a_provisionheld;
	}

	public void setR0430_stage3a_provisionheld(BigDecimal r0430_stage3a_provisionheld) {
		this.r0430_stage3a_provisionheld = r0430_stage3a_provisionheld;
	}

	public BigDecimal getR0430_stage3b_provisionheld() {
		return r0430_stage3b_provisionheld;
	}

	public void setR0430_stage3b_provisionheld(BigDecimal r0430_stage3b_provisionheld) {
		this.r0430_stage3b_provisionheld = r0430_stage3b_provisionheld;
	}

	public BigDecimal getR0430_stage3c_provisionheld() {
		return r0430_stage3c_provisionheld;
	}

	public void setR0430_stage3c_provisionheld(BigDecimal r0430_stage3c_provisionheld) {
		this.r0430_stage3c_provisionheld = r0430_stage3c_provisionheld;
	}

	public BigDecimal getR0430_intrestfees_provisionheld() {
		return r0430_intrestfees_provisionheld;
	}

	public void setR0430_intrestfees_provisionheld(BigDecimal r0430_intrestfees_provisionheld) {
		this.r0430_intrestfees_provisionheld = r0430_intrestfees_provisionheld;
	}

	public BigDecimal getR0430_intrestsuspense_provisionheld() {
		return r0430_intrestsuspense_provisionheld;
	}

	public void setR0430_intrestsuspense_provisionheld(BigDecimal r0430_intrestsuspense_provisionheld) {
		this.r0430_intrestsuspense_provisionheld = r0430_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0430_stage1_poci() {
		return r0430_stage1_poci;
	}

	public void setR0430_stage1_poci(BigDecimal r0430_stage1_poci) {
		this.r0430_stage1_poci = r0430_stage1_poci;
	}

	public BigDecimal getR0430_stage2_poci() {
		return r0430_stage2_poci;
	}

	public void setR0430_stage2_poci(BigDecimal r0430_stage2_poci) {
		this.r0430_stage2_poci = r0430_stage2_poci;
	}

	public BigDecimal getR0430_stage3a_poci() {
		return r0430_stage3a_poci;
	}

	public void setR0430_stage3a_poci(BigDecimal r0430_stage3a_poci) {
		this.r0430_stage3a_poci = r0430_stage3a_poci;
	}

	public BigDecimal getR0430_stage3b_poci() {
		return r0430_stage3b_poci;
	}

	public void setR0430_stage3b_poci(BigDecimal r0430_stage3b_poci) {
		this.r0430_stage3b_poci = r0430_stage3b_poci;
	}

	public BigDecimal getR0430_stage3c_poci() {
		return r0430_stage3c_poci;
	}

	public void setR0430_stage3c_poci(BigDecimal r0430_stage3c_poci) {
		this.r0430_stage3c_poci = r0430_stage3c_poci;
	}

	public BigDecimal getR0430_current_pastdues() {
		return r0430_current_pastdues;
	}

	public void setR0430_current_pastdues(BigDecimal r0430_current_pastdues) {
		this.r0430_current_pastdues = r0430_current_pastdues;
	}

	public BigDecimal getR0430_less30days_pastdues() {
		return r0430_less30days_pastdues;
	}

	public void setR0430_less30days_pastdues(BigDecimal r0430_less30days_pastdues) {
		this.r0430_less30days_pastdues = r0430_less30days_pastdues;
	}

	public BigDecimal getR0430_31to90days_pastdues() {
		return r0430_31to90days_pastdues;
	}

	public void setR0430_31to90days_pastdues(BigDecimal r0430_31to90days_pastdues) {
		this.r0430_31to90days_pastdues = r0430_31to90days_pastdues;
	}

	public BigDecimal getR0430_91to120days_pastdues() {
		return r0430_91to120days_pastdues;
	}

	public void setR0430_91to120days_pastdues(BigDecimal r0430_91to120days_pastdues) {
		this.r0430_91to120days_pastdues = r0430_91to120days_pastdues;
	}

	public BigDecimal getR0430_121to180days_pastdues() {
		return r0430_121to180days_pastdues;
	}

	public void setR0430_121to180days_pastdues(BigDecimal r0430_121to180days_pastdues) {
		this.r0430_121to180days_pastdues = r0430_121to180days_pastdues;
	}

	public BigDecimal getR0430_181to365days_pastdues() {
		return r0430_181to365days_pastdues;
	}

	public void setR0430_181to365days_pastdues(BigDecimal r0430_181to365days_pastdues) {
		this.r0430_181to365days_pastdues = r0430_181to365days_pastdues;
	}

	public BigDecimal getR0430_over365days_pastdues() {
		return r0430_over365days_pastdues;
	}

	public void setR0430_over365days_pastdues(BigDecimal r0430_over365days_pastdues) {
		this.r0430_over365days_pastdues = r0430_over365days_pastdues;
	}

	public BigDecimal getR0430_total_pastdues() {
		return r0430_total_pastdues;
	}

	public void setR0430_total_pastdues(BigDecimal r0430_total_pastdues) {
		this.r0430_total_pastdues = r0430_total_pastdues;
	}

	public BigDecimal getR0430_newloan_duringreport() {
		return r0430_newloan_duringreport;
	}

	public void setR0430_newloan_duringreport(BigDecimal r0430_newloan_duringreport) {
		this.r0430_newloan_duringreport = r0430_newloan_duringreport;
	}

	public BigDecimal getR0430_newstage_duringreport() {
		return r0430_newstage_duringreport;
	}

	public void setR0430_newstage_duringreport(BigDecimal r0430_newstage_duringreport) {
		this.r0430_newstage_duringreport = r0430_newstage_duringreport;
	}

	public BigDecimal getR0430_intrestfees_duringreport() {
		return r0430_intrestfees_duringreport;
	}

	public void setR0430_intrestfees_duringreport(BigDecimal r0430_intrestfees_duringreport) {
		this.r0430_intrestfees_duringreport = r0430_intrestfees_duringreport;
	}

	public BigDecimal getR0430_performingac_acinfo() {
		return r0430_performingac_acinfo;
	}

	public void setR0430_performingac_acinfo(BigDecimal r0430_performingac_acinfo) {
		this.r0430_performingac_acinfo = r0430_performingac_acinfo;
	}

	public BigDecimal getR0430_nonperformingac_acinfo() {
		return r0430_nonperformingac_acinfo;
	}

	public void setR0430_nonperformingac_acinfo(BigDecimal r0430_nonperformingac_acinfo) {
		this.r0430_nonperformingac_acinfo = r0430_nonperformingac_acinfo;
	}

	public String getR0440_product() {
		return r0440_product;
	}

	public void setR0440_product(String r0440_product) {
		this.r0440_product = r0440_product;
	}

	public BigDecimal getR0440_outstandbal() {
		return r0440_outstandbal;
	}

	public void setR0440_outstandbal(BigDecimal r0440_outstandbal) {
		this.r0440_outstandbal = r0440_outstandbal;
	}

	public BigDecimal getR0440_secured_outstandbal() {
		return r0440_secured_outstandbal;
	}

	public void setR0440_secured_outstandbal(BigDecimal r0440_secured_outstandbal) {
		this.r0440_secured_outstandbal = r0440_secured_outstandbal;
	}

	public BigDecimal getR0440_unsecured_outstandbal() {
		return r0440_unsecured_outstandbal;
	}

	public void setR0440_unsecured_outstandbal(BigDecimal r0440_unsecured_outstandbal) {
		this.r0440_unsecured_outstandbal = r0440_unsecured_outstandbal;
	}

	public BigDecimal getR0440_stage1_assetclass() {
		return r0440_stage1_assetclass;
	}

	public void setR0440_stage1_assetclass(BigDecimal r0440_stage1_assetclass) {
		this.r0440_stage1_assetclass = r0440_stage1_assetclass;
	}

	public BigDecimal getR0440_stage2_assetclass() {
		return r0440_stage2_assetclass;
	}

	public void setR0440_stage2_assetclass(BigDecimal r0440_stage2_assetclass) {
		this.r0440_stage2_assetclass = r0440_stage2_assetclass;
	}

	public BigDecimal getR0440_stage3a_assetclass() {
		return r0440_stage3a_assetclass;
	}

	public void setR0440_stage3a_assetclass(BigDecimal r0440_stage3a_assetclass) {
		this.r0440_stage3a_assetclass = r0440_stage3a_assetclass;
	}

	public BigDecimal getR0440_stage3b_assetclass() {
		return r0440_stage3b_assetclass;
	}

	public void setR0440_stage3b_assetclass(BigDecimal r0440_stage3b_assetclass) {
		this.r0440_stage3b_assetclass = r0440_stage3b_assetclass;
	}

	public BigDecimal getR0440_stage3c_assetclass() {
		return r0440_stage3c_assetclass;
	}

	public void setR0440_stage3c_assetclass(BigDecimal r0440_stage3c_assetclass) {
		this.r0440_stage3c_assetclass = r0440_stage3c_assetclass;
	}

	public BigDecimal getR0440_stage1_provisionheld() {
		return r0440_stage1_provisionheld;
	}

	public void setR0440_stage1_provisionheld(BigDecimal r0440_stage1_provisionheld) {
		this.r0440_stage1_provisionheld = r0440_stage1_provisionheld;
	}

	public BigDecimal getR0440_stage2_provisionheld() {
		return r0440_stage2_provisionheld;
	}

	public void setR0440_stage2_provisionheld(BigDecimal r0440_stage2_provisionheld) {
		this.r0440_stage2_provisionheld = r0440_stage2_provisionheld;
	}

	public BigDecimal getR0440_stage3a_provisionheld() {
		return r0440_stage3a_provisionheld;
	}

	public void setR0440_stage3a_provisionheld(BigDecimal r0440_stage3a_provisionheld) {
		this.r0440_stage3a_provisionheld = r0440_stage3a_provisionheld;
	}

	public BigDecimal getR0440_stage3b_provisionheld() {
		return r0440_stage3b_provisionheld;
	}

	public void setR0440_stage3b_provisionheld(BigDecimal r0440_stage3b_provisionheld) {
		this.r0440_stage3b_provisionheld = r0440_stage3b_provisionheld;
	}

	public BigDecimal getR0440_stage3c_provisionheld() {
		return r0440_stage3c_provisionheld;
	}

	public void setR0440_stage3c_provisionheld(BigDecimal r0440_stage3c_provisionheld) {
		this.r0440_stage3c_provisionheld = r0440_stage3c_provisionheld;
	}

	public BigDecimal getR0440_intrestfees_provisionheld() {
		return r0440_intrestfees_provisionheld;
	}

	public void setR0440_intrestfees_provisionheld(BigDecimal r0440_intrestfees_provisionheld) {
		this.r0440_intrestfees_provisionheld = r0440_intrestfees_provisionheld;
	}

	public BigDecimal getR0440_intrestsuspense_provisionheld() {
		return r0440_intrestsuspense_provisionheld;
	}

	public void setR0440_intrestsuspense_provisionheld(BigDecimal r0440_intrestsuspense_provisionheld) {
		this.r0440_intrestsuspense_provisionheld = r0440_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0440_stage1_poci() {
		return r0440_stage1_poci;
	}

	public void setR0440_stage1_poci(BigDecimal r0440_stage1_poci) {
		this.r0440_stage1_poci = r0440_stage1_poci;
	}

	public BigDecimal getR0440_stage2_poci() {
		return r0440_stage2_poci;
	}

	public void setR0440_stage2_poci(BigDecimal r0440_stage2_poci) {
		this.r0440_stage2_poci = r0440_stage2_poci;
	}

	public BigDecimal getR0440_stage3a_poci() {
		return r0440_stage3a_poci;
	}

	public void setR0440_stage3a_poci(BigDecimal r0440_stage3a_poci) {
		this.r0440_stage3a_poci = r0440_stage3a_poci;
	}

	public BigDecimal getR0440_stage3b_poci() {
		return r0440_stage3b_poci;
	}

	public void setR0440_stage3b_poci(BigDecimal r0440_stage3b_poci) {
		this.r0440_stage3b_poci = r0440_stage3b_poci;
	}

	public BigDecimal getR0440_stage3c_poci() {
		return r0440_stage3c_poci;
	}

	public void setR0440_stage3c_poci(BigDecimal r0440_stage3c_poci) {
		this.r0440_stage3c_poci = r0440_stage3c_poci;
	}

	public BigDecimal getR0440_current_pastdues() {
		return r0440_current_pastdues;
	}

	public void setR0440_current_pastdues(BigDecimal r0440_current_pastdues) {
		this.r0440_current_pastdues = r0440_current_pastdues;
	}

	public BigDecimal getR0440_less30days_pastdues() {
		return r0440_less30days_pastdues;
	}

	public void setR0440_less30days_pastdues(BigDecimal r0440_less30days_pastdues) {
		this.r0440_less30days_pastdues = r0440_less30days_pastdues;
	}

	public BigDecimal getR0440_31to90days_pastdues() {
		return r0440_31to90days_pastdues;
	}

	public void setR0440_31to90days_pastdues(BigDecimal r0440_31to90days_pastdues) {
		this.r0440_31to90days_pastdues = r0440_31to90days_pastdues;
	}

	public BigDecimal getR0440_91to120days_pastdues() {
		return r0440_91to120days_pastdues;
	}

	public void setR0440_91to120days_pastdues(BigDecimal r0440_91to120days_pastdues) {
		this.r0440_91to120days_pastdues = r0440_91to120days_pastdues;
	}

	public BigDecimal getR0440_121to180days_pastdues() {
		return r0440_121to180days_pastdues;
	}

	public void setR0440_121to180days_pastdues(BigDecimal r0440_121to180days_pastdues) {
		this.r0440_121to180days_pastdues = r0440_121to180days_pastdues;
	}

	public BigDecimal getR0440_181to365days_pastdues() {
		return r0440_181to365days_pastdues;
	}

	public void setR0440_181to365days_pastdues(BigDecimal r0440_181to365days_pastdues) {
		this.r0440_181to365days_pastdues = r0440_181to365days_pastdues;
	}

	public BigDecimal getR0440_over365days_pastdues() {
		return r0440_over365days_pastdues;
	}

	public void setR0440_over365days_pastdues(BigDecimal r0440_over365days_pastdues) {
		this.r0440_over365days_pastdues = r0440_over365days_pastdues;
	}

	public BigDecimal getR0440_total_pastdues() {
		return r0440_total_pastdues;
	}

	public void setR0440_total_pastdues(BigDecimal r0440_total_pastdues) {
		this.r0440_total_pastdues = r0440_total_pastdues;
	}

	public BigDecimal getR0440_newloan_duringreport() {
		return r0440_newloan_duringreport;
	}

	public void setR0440_newloan_duringreport(BigDecimal r0440_newloan_duringreport) {
		this.r0440_newloan_duringreport = r0440_newloan_duringreport;
	}

	public BigDecimal getR0440_newstage_duringreport() {
		return r0440_newstage_duringreport;
	}

	public void setR0440_newstage_duringreport(BigDecimal r0440_newstage_duringreport) {
		this.r0440_newstage_duringreport = r0440_newstage_duringreport;
	}

	public BigDecimal getR0440_intrestfees_duringreport() {
		return r0440_intrestfees_duringreport;
	}

	public void setR0440_intrestfees_duringreport(BigDecimal r0440_intrestfees_duringreport) {
		this.r0440_intrestfees_duringreport = r0440_intrestfees_duringreport;
	}

	public BigDecimal getR0440_performingac_acinfo() {
		return r0440_performingac_acinfo;
	}

	public void setR0440_performingac_acinfo(BigDecimal r0440_performingac_acinfo) {
		this.r0440_performingac_acinfo = r0440_performingac_acinfo;
	}

	public BigDecimal getR0440_nonperformingac_acinfo() {
		return r0440_nonperformingac_acinfo;
	}

	public void setR0440_nonperformingac_acinfo(BigDecimal r0440_nonperformingac_acinfo) {
		this.r0440_nonperformingac_acinfo = r0440_nonperformingac_acinfo;
	}

	public String getR0450_product() {
		return r0450_product;
	}

	public void setR0450_product(String r0450_product) {
		this.r0450_product = r0450_product;
	}

	public BigDecimal getR0450_outstandbal() {
		return r0450_outstandbal;
	}

	public void setR0450_outstandbal(BigDecimal r0450_outstandbal) {
		this.r0450_outstandbal = r0450_outstandbal;
	}

	public BigDecimal getR0450_secured_outstandbal() {
		return r0450_secured_outstandbal;
	}

	public void setR0450_secured_outstandbal(BigDecimal r0450_secured_outstandbal) {
		this.r0450_secured_outstandbal = r0450_secured_outstandbal;
	}

	public BigDecimal getR0450_unsecured_outstandbal() {
		return r0450_unsecured_outstandbal;
	}

	public void setR0450_unsecured_outstandbal(BigDecimal r0450_unsecured_outstandbal) {
		this.r0450_unsecured_outstandbal = r0450_unsecured_outstandbal;
	}

	public BigDecimal getR0450_stage1_assetclass() {
		return r0450_stage1_assetclass;
	}

	public void setR0450_stage1_assetclass(BigDecimal r0450_stage1_assetclass) {
		this.r0450_stage1_assetclass = r0450_stage1_assetclass;
	}

	public BigDecimal getR0450_stage2_assetclass() {
		return r0450_stage2_assetclass;
	}

	public void setR0450_stage2_assetclass(BigDecimal r0450_stage2_assetclass) {
		this.r0450_stage2_assetclass = r0450_stage2_assetclass;
	}

	public BigDecimal getR0450_stage3a_assetclass() {
		return r0450_stage3a_assetclass;
	}

	public void setR0450_stage3a_assetclass(BigDecimal r0450_stage3a_assetclass) {
		this.r0450_stage3a_assetclass = r0450_stage3a_assetclass;
	}

	public BigDecimal getR0450_stage3b_assetclass() {
		return r0450_stage3b_assetclass;
	}

	public void setR0450_stage3b_assetclass(BigDecimal r0450_stage3b_assetclass) {
		this.r0450_stage3b_assetclass = r0450_stage3b_assetclass;
	}

	public BigDecimal getR0450_stage3c_assetclass() {
		return r0450_stage3c_assetclass;
	}

	public void setR0450_stage3c_assetclass(BigDecimal r0450_stage3c_assetclass) {
		this.r0450_stage3c_assetclass = r0450_stage3c_assetclass;
	}

	public BigDecimal getR0450_stage1_provisionheld() {
		return r0450_stage1_provisionheld;
	}

	public void setR0450_stage1_provisionheld(BigDecimal r0450_stage1_provisionheld) {
		this.r0450_stage1_provisionheld = r0450_stage1_provisionheld;
	}

	public BigDecimal getR0450_stage2_provisionheld() {
		return r0450_stage2_provisionheld;
	}

	public void setR0450_stage2_provisionheld(BigDecimal r0450_stage2_provisionheld) {
		this.r0450_stage2_provisionheld = r0450_stage2_provisionheld;
	}

	public BigDecimal getR0450_stage3a_provisionheld() {
		return r0450_stage3a_provisionheld;
	}

	public void setR0450_stage3a_provisionheld(BigDecimal r0450_stage3a_provisionheld) {
		this.r0450_stage3a_provisionheld = r0450_stage3a_provisionheld;
	}

	public BigDecimal getR0450_stage3b_provisionheld() {
		return r0450_stage3b_provisionheld;
	}

	public void setR0450_stage3b_provisionheld(BigDecimal r0450_stage3b_provisionheld) {
		this.r0450_stage3b_provisionheld = r0450_stage3b_provisionheld;
	}

	public BigDecimal getR0450_stage3c_provisionheld() {
		return r0450_stage3c_provisionheld;
	}

	public void setR0450_stage3c_provisionheld(BigDecimal r0450_stage3c_provisionheld) {
		this.r0450_stage3c_provisionheld = r0450_stage3c_provisionheld;
	}

	public BigDecimal getR0450_intrestfees_provisionheld() {
		return r0450_intrestfees_provisionheld;
	}

	public void setR0450_intrestfees_provisionheld(BigDecimal r0450_intrestfees_provisionheld) {
		this.r0450_intrestfees_provisionheld = r0450_intrestfees_provisionheld;
	}

	public BigDecimal getR0450_intrestsuspense_provisionheld() {
		return r0450_intrestsuspense_provisionheld;
	}

	public void setR0450_intrestsuspense_provisionheld(BigDecimal r0450_intrestsuspense_provisionheld) {
		this.r0450_intrestsuspense_provisionheld = r0450_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0450_stage1_poci() {
		return r0450_stage1_poci;
	}

	public void setR0450_stage1_poci(BigDecimal r0450_stage1_poci) {
		this.r0450_stage1_poci = r0450_stage1_poci;
	}

	public BigDecimal getR0450_stage2_poci() {
		return r0450_stage2_poci;
	}

	public void setR0450_stage2_poci(BigDecimal r0450_stage2_poci) {
		this.r0450_stage2_poci = r0450_stage2_poci;
	}

	public BigDecimal getR0450_stage3a_poci() {
		return r0450_stage3a_poci;
	}

	public void setR0450_stage3a_poci(BigDecimal r0450_stage3a_poci) {
		this.r0450_stage3a_poci = r0450_stage3a_poci;
	}

	public BigDecimal getR0450_stage3b_poci() {
		return r0450_stage3b_poci;
	}

	public void setR0450_stage3b_poci(BigDecimal r0450_stage3b_poci) {
		this.r0450_stage3b_poci = r0450_stage3b_poci;
	}

	public BigDecimal getR0450_stage3c_poci() {
		return r0450_stage3c_poci;
	}

	public void setR0450_stage3c_poci(BigDecimal r0450_stage3c_poci) {
		this.r0450_stage3c_poci = r0450_stage3c_poci;
	}

	public BigDecimal getR0450_current_pastdues() {
		return r0450_current_pastdues;
	}

	public void setR0450_current_pastdues(BigDecimal r0450_current_pastdues) {
		this.r0450_current_pastdues = r0450_current_pastdues;
	}

	public BigDecimal getR0450_less30days_pastdues() {
		return r0450_less30days_pastdues;
	}

	public void setR0450_less30days_pastdues(BigDecimal r0450_less30days_pastdues) {
		this.r0450_less30days_pastdues = r0450_less30days_pastdues;
	}

	public BigDecimal getR0450_31to90days_pastdues() {
		return r0450_31to90days_pastdues;
	}

	public void setR0450_31to90days_pastdues(BigDecimal r0450_31to90days_pastdues) {
		this.r0450_31to90days_pastdues = r0450_31to90days_pastdues;
	}

	public BigDecimal getR0450_91to120days_pastdues() {
		return r0450_91to120days_pastdues;
	}

	public void setR0450_91to120days_pastdues(BigDecimal r0450_91to120days_pastdues) {
		this.r0450_91to120days_pastdues = r0450_91to120days_pastdues;
	}

	public BigDecimal getR0450_121to180days_pastdues() {
		return r0450_121to180days_pastdues;
	}

	public void setR0450_121to180days_pastdues(BigDecimal r0450_121to180days_pastdues) {
		this.r0450_121to180days_pastdues = r0450_121to180days_pastdues;
	}

	public BigDecimal getR0450_181to365days_pastdues() {
		return r0450_181to365days_pastdues;
	}

	public void setR0450_181to365days_pastdues(BigDecimal r0450_181to365days_pastdues) {
		this.r0450_181to365days_pastdues = r0450_181to365days_pastdues;
	}

	public BigDecimal getR0450_over365days_pastdues() {
		return r0450_over365days_pastdues;
	}

	public void setR0450_over365days_pastdues(BigDecimal r0450_over365days_pastdues) {
		this.r0450_over365days_pastdues = r0450_over365days_pastdues;
	}

	public BigDecimal getR0450_total_pastdues() {
		return r0450_total_pastdues;
	}

	public void setR0450_total_pastdues(BigDecimal r0450_total_pastdues) {
		this.r0450_total_pastdues = r0450_total_pastdues;
	}

	public BigDecimal getR0450_newloan_duringreport() {
		return r0450_newloan_duringreport;
	}

	public void setR0450_newloan_duringreport(BigDecimal r0450_newloan_duringreport) {
		this.r0450_newloan_duringreport = r0450_newloan_duringreport;
	}

	public BigDecimal getR0450_newstage_duringreport() {
		return r0450_newstage_duringreport;
	}

	public void setR0450_newstage_duringreport(BigDecimal r0450_newstage_duringreport) {
		this.r0450_newstage_duringreport = r0450_newstage_duringreport;
	}

	public BigDecimal getR0450_intrestfees_duringreport() {
		return r0450_intrestfees_duringreport;
	}

	public void setR0450_intrestfees_duringreport(BigDecimal r0450_intrestfees_duringreport) {
		this.r0450_intrestfees_duringreport = r0450_intrestfees_duringreport;
	}

	public BigDecimal getR0450_performingac_acinfo() {
		return r0450_performingac_acinfo;
	}

	public void setR0450_performingac_acinfo(BigDecimal r0450_performingac_acinfo) {
		this.r0450_performingac_acinfo = r0450_performingac_acinfo;
	}

	public BigDecimal getR0450_nonperformingac_acinfo() {
		return r0450_nonperformingac_acinfo;
	}

	public void setR0450_nonperformingac_acinfo(BigDecimal r0450_nonperformingac_acinfo) {
		this.r0450_nonperformingac_acinfo = r0450_nonperformingac_acinfo;
	}

	public String getR0460_product() {
		return r0460_product;
	}

	public void setR0460_product(String r0460_product) {
		this.r0460_product = r0460_product;
	}

	public BigDecimal getR0460_outstandbal() {
		return r0460_outstandbal;
	}

	public void setR0460_outstandbal(BigDecimal r0460_outstandbal) {
		this.r0460_outstandbal = r0460_outstandbal;
	}

	public BigDecimal getR0460_secured_outstandbal() {
		return r0460_secured_outstandbal;
	}

	public void setR0460_secured_outstandbal(BigDecimal r0460_secured_outstandbal) {
		this.r0460_secured_outstandbal = r0460_secured_outstandbal;
	}

	public BigDecimal getR0460_unsecured_outstandbal() {
		return r0460_unsecured_outstandbal;
	}

	public void setR0460_unsecured_outstandbal(BigDecimal r0460_unsecured_outstandbal) {
		this.r0460_unsecured_outstandbal = r0460_unsecured_outstandbal;
	}

	public BigDecimal getR0460_stage1_assetclass() {
		return r0460_stage1_assetclass;
	}

	public void setR0460_stage1_assetclass(BigDecimal r0460_stage1_assetclass) {
		this.r0460_stage1_assetclass = r0460_stage1_assetclass;
	}

	public BigDecimal getR0460_stage2_assetclass() {
		return r0460_stage2_assetclass;
	}

	public void setR0460_stage2_assetclass(BigDecimal r0460_stage2_assetclass) {
		this.r0460_stage2_assetclass = r0460_stage2_assetclass;
	}

	public BigDecimal getR0460_stage3a_assetclass() {
		return r0460_stage3a_assetclass;
	}

	public void setR0460_stage3a_assetclass(BigDecimal r0460_stage3a_assetclass) {
		this.r0460_stage3a_assetclass = r0460_stage3a_assetclass;
	}

	public BigDecimal getR0460_stage3b_assetclass() {
		return r0460_stage3b_assetclass;
	}

	public void setR0460_stage3b_assetclass(BigDecimal r0460_stage3b_assetclass) {
		this.r0460_stage3b_assetclass = r0460_stage3b_assetclass;
	}

	public BigDecimal getR0460_stage3c_assetclass() {
		return r0460_stage3c_assetclass;
	}

	public void setR0460_stage3c_assetclass(BigDecimal r0460_stage3c_assetclass) {
		this.r0460_stage3c_assetclass = r0460_stage3c_assetclass;
	}

	public BigDecimal getR0460_stage1_provisionheld() {
		return r0460_stage1_provisionheld;
	}

	public void setR0460_stage1_provisionheld(BigDecimal r0460_stage1_provisionheld) {
		this.r0460_stage1_provisionheld = r0460_stage1_provisionheld;
	}

	public BigDecimal getR0460_stage2_provisionheld() {
		return r0460_stage2_provisionheld;
	}

	public void setR0460_stage2_provisionheld(BigDecimal r0460_stage2_provisionheld) {
		this.r0460_stage2_provisionheld = r0460_stage2_provisionheld;
	}

	public BigDecimal getR0460_stage3a_provisionheld() {
		return r0460_stage3a_provisionheld;
	}

	public void setR0460_stage3a_provisionheld(BigDecimal r0460_stage3a_provisionheld) {
		this.r0460_stage3a_provisionheld = r0460_stage3a_provisionheld;
	}

	public BigDecimal getR0460_stage3b_provisionheld() {
		return r0460_stage3b_provisionheld;
	}

	public void setR0460_stage3b_provisionheld(BigDecimal r0460_stage3b_provisionheld) {
		this.r0460_stage3b_provisionheld = r0460_stage3b_provisionheld;
	}

	public BigDecimal getR0460_stage3c_provisionheld() {
		return r0460_stage3c_provisionheld;
	}

	public void setR0460_stage3c_provisionheld(BigDecimal r0460_stage3c_provisionheld) {
		this.r0460_stage3c_provisionheld = r0460_stage3c_provisionheld;
	}

	public BigDecimal getR0460_intrestfees_provisionheld() {
		return r0460_intrestfees_provisionheld;
	}

	public void setR0460_intrestfees_provisionheld(BigDecimal r0460_intrestfees_provisionheld) {
		this.r0460_intrestfees_provisionheld = r0460_intrestfees_provisionheld;
	}

	public BigDecimal getR0460_intrestsuspense_provisionheld() {
		return r0460_intrestsuspense_provisionheld;
	}

	public void setR0460_intrestsuspense_provisionheld(BigDecimal r0460_intrestsuspense_provisionheld) {
		this.r0460_intrestsuspense_provisionheld = r0460_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0460_stage1_poci() {
		return r0460_stage1_poci;
	}

	public void setR0460_stage1_poci(BigDecimal r0460_stage1_poci) {
		this.r0460_stage1_poci = r0460_stage1_poci;
	}

	public BigDecimal getR0460_stage2_poci() {
		return r0460_stage2_poci;
	}

	public void setR0460_stage2_poci(BigDecimal r0460_stage2_poci) {
		this.r0460_stage2_poci = r0460_stage2_poci;
	}

	public BigDecimal getR0460_stage3a_poci() {
		return r0460_stage3a_poci;
	}

	public void setR0460_stage3a_poci(BigDecimal r0460_stage3a_poci) {
		this.r0460_stage3a_poci = r0460_stage3a_poci;
	}

	public BigDecimal getR0460_stage3b_poci() {
		return r0460_stage3b_poci;
	}

	public void setR0460_stage3b_poci(BigDecimal r0460_stage3b_poci) {
		this.r0460_stage3b_poci = r0460_stage3b_poci;
	}

	public BigDecimal getR0460_stage3c_poci() {
		return r0460_stage3c_poci;
	}

	public void setR0460_stage3c_poci(BigDecimal r0460_stage3c_poci) {
		this.r0460_stage3c_poci = r0460_stage3c_poci;
	}

	public BigDecimal getR0460_current_pastdues() {
		return r0460_current_pastdues;
	}

	public void setR0460_current_pastdues(BigDecimal r0460_current_pastdues) {
		this.r0460_current_pastdues = r0460_current_pastdues;
	}

	public BigDecimal getR0460_less30days_pastdues() {
		return r0460_less30days_pastdues;
	}

	public void setR0460_less30days_pastdues(BigDecimal r0460_less30days_pastdues) {
		this.r0460_less30days_pastdues = r0460_less30days_pastdues;
	}

	public BigDecimal getR0460_31to90days_pastdues() {
		return r0460_31to90days_pastdues;
	}

	public void setR0460_31to90days_pastdues(BigDecimal r0460_31to90days_pastdues) {
		this.r0460_31to90days_pastdues = r0460_31to90days_pastdues;
	}

	public BigDecimal getR0460_91to120days_pastdues() {
		return r0460_91to120days_pastdues;
	}

	public void setR0460_91to120days_pastdues(BigDecimal r0460_91to120days_pastdues) {
		this.r0460_91to120days_pastdues = r0460_91to120days_pastdues;
	}

	public BigDecimal getR0460_121to180days_pastdues() {
		return r0460_121to180days_pastdues;
	}

	public void setR0460_121to180days_pastdues(BigDecimal r0460_121to180days_pastdues) {
		this.r0460_121to180days_pastdues = r0460_121to180days_pastdues;
	}

	public BigDecimal getR0460_181to365days_pastdues() {
		return r0460_181to365days_pastdues;
	}

	public void setR0460_181to365days_pastdues(BigDecimal r0460_181to365days_pastdues) {
		this.r0460_181to365days_pastdues = r0460_181to365days_pastdues;
	}

	public BigDecimal getR0460_over365days_pastdues() {
		return r0460_over365days_pastdues;
	}

	public void setR0460_over365days_pastdues(BigDecimal r0460_over365days_pastdues) {
		this.r0460_over365days_pastdues = r0460_over365days_pastdues;
	}

	public BigDecimal getR0460_total_pastdues() {
		return r0460_total_pastdues;
	}

	public void setR0460_total_pastdues(BigDecimal r0460_total_pastdues) {
		this.r0460_total_pastdues = r0460_total_pastdues;
	}

	public BigDecimal getR0460_newloan_duringreport() {
		return r0460_newloan_duringreport;
	}

	public void setR0460_newloan_duringreport(BigDecimal r0460_newloan_duringreport) {
		this.r0460_newloan_duringreport = r0460_newloan_duringreport;
	}

	public BigDecimal getR0460_newstage_duringreport() {
		return r0460_newstage_duringreport;
	}

	public void setR0460_newstage_duringreport(BigDecimal r0460_newstage_duringreport) {
		this.r0460_newstage_duringreport = r0460_newstage_duringreport;
	}

	public BigDecimal getR0460_intrestfees_duringreport() {
		return r0460_intrestfees_duringreport;
	}

	public void setR0460_intrestfees_duringreport(BigDecimal r0460_intrestfees_duringreport) {
		this.r0460_intrestfees_duringreport = r0460_intrestfees_duringreport;
	}

	public BigDecimal getR0460_performingac_acinfo() {
		return r0460_performingac_acinfo;
	}

	public void setR0460_performingac_acinfo(BigDecimal r0460_performingac_acinfo) {
		this.r0460_performingac_acinfo = r0460_performingac_acinfo;
	}

	public BigDecimal getR0460_nonperformingac_acinfo() {
		return r0460_nonperformingac_acinfo;
	}

	public void setR0460_nonperformingac_acinfo(BigDecimal r0460_nonperformingac_acinfo) {
		this.r0460_nonperformingac_acinfo = r0460_nonperformingac_acinfo;
	}

	public String getR0470_product() {
		return r0470_product;
	}

	public void setR0470_product(String r0470_product) {
		this.r0470_product = r0470_product;
	}

	public BigDecimal getR0470_outstandbal() {
		return r0470_outstandbal;
	}

	public void setR0470_outstandbal(BigDecimal r0470_outstandbal) {
		this.r0470_outstandbal = r0470_outstandbal;
	}

	public BigDecimal getR0470_secured_outstandbal() {
		return r0470_secured_outstandbal;
	}

	public void setR0470_secured_outstandbal(BigDecimal r0470_secured_outstandbal) {
		this.r0470_secured_outstandbal = r0470_secured_outstandbal;
	}

	public BigDecimal getR0470_unsecured_outstandbal() {
		return r0470_unsecured_outstandbal;
	}

	public void setR0470_unsecured_outstandbal(BigDecimal r0470_unsecured_outstandbal) {
		this.r0470_unsecured_outstandbal = r0470_unsecured_outstandbal;
	}

	public BigDecimal getR0470_stage1_assetclass() {
		return r0470_stage1_assetclass;
	}

	public void setR0470_stage1_assetclass(BigDecimal r0470_stage1_assetclass) {
		this.r0470_stage1_assetclass = r0470_stage1_assetclass;
	}

	public BigDecimal getR0470_stage2_assetclass() {
		return r0470_stage2_assetclass;
	}

	public void setR0470_stage2_assetclass(BigDecimal r0470_stage2_assetclass) {
		this.r0470_stage2_assetclass = r0470_stage2_assetclass;
	}

	public BigDecimal getR0470_stage3a_assetclass() {
		return r0470_stage3a_assetclass;
	}

	public void setR0470_stage3a_assetclass(BigDecimal r0470_stage3a_assetclass) {
		this.r0470_stage3a_assetclass = r0470_stage3a_assetclass;
	}

	public BigDecimal getR0470_stage3b_assetclass() {
		return r0470_stage3b_assetclass;
	}

	public void setR0470_stage3b_assetclass(BigDecimal r0470_stage3b_assetclass) {
		this.r0470_stage3b_assetclass = r0470_stage3b_assetclass;
	}

	public BigDecimal getR0470_stage3c_assetclass() {
		return r0470_stage3c_assetclass;
	}

	public void setR0470_stage3c_assetclass(BigDecimal r0470_stage3c_assetclass) {
		this.r0470_stage3c_assetclass = r0470_stage3c_assetclass;
	}

	public BigDecimal getR0470_stage1_provisionheld() {
		return r0470_stage1_provisionheld;
	}

	public void setR0470_stage1_provisionheld(BigDecimal r0470_stage1_provisionheld) {
		this.r0470_stage1_provisionheld = r0470_stage1_provisionheld;
	}

	public BigDecimal getR0470_stage2_provisionheld() {
		return r0470_stage2_provisionheld;
	}

	public void setR0470_stage2_provisionheld(BigDecimal r0470_stage2_provisionheld) {
		this.r0470_stage2_provisionheld = r0470_stage2_provisionheld;
	}

	public BigDecimal getR0470_stage3a_provisionheld() {
		return r0470_stage3a_provisionheld;
	}

	public void setR0470_stage3a_provisionheld(BigDecimal r0470_stage3a_provisionheld) {
		this.r0470_stage3a_provisionheld = r0470_stage3a_provisionheld;
	}

	public BigDecimal getR0470_stage3b_provisionheld() {
		return r0470_stage3b_provisionheld;
	}

	public void setR0470_stage3b_provisionheld(BigDecimal r0470_stage3b_provisionheld) {
		this.r0470_stage3b_provisionheld = r0470_stage3b_provisionheld;
	}

	public BigDecimal getR0470_stage3c_provisionheld() {
		return r0470_stage3c_provisionheld;
	}

	public void setR0470_stage3c_provisionheld(BigDecimal r0470_stage3c_provisionheld) {
		this.r0470_stage3c_provisionheld = r0470_stage3c_provisionheld;
	}

	public BigDecimal getR0470_intrestfees_provisionheld() {
		return r0470_intrestfees_provisionheld;
	}

	public void setR0470_intrestfees_provisionheld(BigDecimal r0470_intrestfees_provisionheld) {
		this.r0470_intrestfees_provisionheld = r0470_intrestfees_provisionheld;
	}

	public BigDecimal getR0470_intrestsuspense_provisionheld() {
		return r0470_intrestsuspense_provisionheld;
	}

	public void setR0470_intrestsuspense_provisionheld(BigDecimal r0470_intrestsuspense_provisionheld) {
		this.r0470_intrestsuspense_provisionheld = r0470_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0470_stage1_poci() {
		return r0470_stage1_poci;
	}

	public void setR0470_stage1_poci(BigDecimal r0470_stage1_poci) {
		this.r0470_stage1_poci = r0470_stage1_poci;
	}

	public BigDecimal getR0470_stage2_poci() {
		return r0470_stage2_poci;
	}

	public void setR0470_stage2_poci(BigDecimal r0470_stage2_poci) {
		this.r0470_stage2_poci = r0470_stage2_poci;
	}

	public BigDecimal getR0470_stage3a_poci() {
		return r0470_stage3a_poci;
	}

	public void setR0470_stage3a_poci(BigDecimal r0470_stage3a_poci) {
		this.r0470_stage3a_poci = r0470_stage3a_poci;
	}

	public BigDecimal getR0470_stage3b_poci() {
		return r0470_stage3b_poci;
	}

	public void setR0470_stage3b_poci(BigDecimal r0470_stage3b_poci) {
		this.r0470_stage3b_poci = r0470_stage3b_poci;
	}

	public BigDecimal getR0470_stage3c_poci() {
		return r0470_stage3c_poci;
	}

	public void setR0470_stage3c_poci(BigDecimal r0470_stage3c_poci) {
		this.r0470_stage3c_poci = r0470_stage3c_poci;
	}

	public BigDecimal getR0470_current_pastdues() {
		return r0470_current_pastdues;
	}

	public void setR0470_current_pastdues(BigDecimal r0470_current_pastdues) {
		this.r0470_current_pastdues = r0470_current_pastdues;
	}

	public BigDecimal getR0470_less30days_pastdues() {
		return r0470_less30days_pastdues;
	}

	public void setR0470_less30days_pastdues(BigDecimal r0470_less30days_pastdues) {
		this.r0470_less30days_pastdues = r0470_less30days_pastdues;
	}

	public BigDecimal getR0470_31to90days_pastdues() {
		return r0470_31to90days_pastdues;
	}

	public void setR0470_31to90days_pastdues(BigDecimal r0470_31to90days_pastdues) {
		this.r0470_31to90days_pastdues = r0470_31to90days_pastdues;
	}

	public BigDecimal getR0470_91to120days_pastdues() {
		return r0470_91to120days_pastdues;
	}

	public void setR0470_91to120days_pastdues(BigDecimal r0470_91to120days_pastdues) {
		this.r0470_91to120days_pastdues = r0470_91to120days_pastdues;
	}

	public BigDecimal getR0470_121to180days_pastdues() {
		return r0470_121to180days_pastdues;
	}

	public void setR0470_121to180days_pastdues(BigDecimal r0470_121to180days_pastdues) {
		this.r0470_121to180days_pastdues = r0470_121to180days_pastdues;
	}

	public BigDecimal getR0470_181to365days_pastdues() {
		return r0470_181to365days_pastdues;
	}

	public void setR0470_181to365days_pastdues(BigDecimal r0470_181to365days_pastdues) {
		this.r0470_181to365days_pastdues = r0470_181to365days_pastdues;
	}

	public BigDecimal getR0470_over365days_pastdues() {
		return r0470_over365days_pastdues;
	}

	public void setR0470_over365days_pastdues(BigDecimal r0470_over365days_pastdues) {
		this.r0470_over365days_pastdues = r0470_over365days_pastdues;
	}

	public BigDecimal getR0470_total_pastdues() {
		return r0470_total_pastdues;
	}

	public void setR0470_total_pastdues(BigDecimal r0470_total_pastdues) {
		this.r0470_total_pastdues = r0470_total_pastdues;
	}

	public BigDecimal getR0470_newloan_duringreport() {
		return r0470_newloan_duringreport;
	}

	public void setR0470_newloan_duringreport(BigDecimal r0470_newloan_duringreport) {
		this.r0470_newloan_duringreport = r0470_newloan_duringreport;
	}

	public BigDecimal getR0470_newstage_duringreport() {
		return r0470_newstage_duringreport;
	}

	public void setR0470_newstage_duringreport(BigDecimal r0470_newstage_duringreport) {
		this.r0470_newstage_duringreport = r0470_newstage_duringreport;
	}

	public BigDecimal getR0470_intrestfees_duringreport() {
		return r0470_intrestfees_duringreport;
	}

	public void setR0470_intrestfees_duringreport(BigDecimal r0470_intrestfees_duringreport) {
		this.r0470_intrestfees_duringreport = r0470_intrestfees_duringreport;
	}

	public BigDecimal getR0470_performingac_acinfo() {
		return r0470_performingac_acinfo;
	}

	public void setR0470_performingac_acinfo(BigDecimal r0470_performingac_acinfo) {
		this.r0470_performingac_acinfo = r0470_performingac_acinfo;
	}

	public BigDecimal getR0470_nonperformingac_acinfo() {
		return r0470_nonperformingac_acinfo;
	}

	public void setR0470_nonperformingac_acinfo(BigDecimal r0470_nonperformingac_acinfo) {
		this.r0470_nonperformingac_acinfo = r0470_nonperformingac_acinfo;
	}

	public String getR0480_product() {
		return r0480_product;
	}

	public void setR0480_product(String r0480_product) {
		this.r0480_product = r0480_product;
	}

	public BigDecimal getR0480_outstandbal() {
		return r0480_outstandbal;
	}

	public void setR0480_outstandbal(BigDecimal r0480_outstandbal) {
		this.r0480_outstandbal = r0480_outstandbal;
	}

	public BigDecimal getR0480_secured_outstandbal() {
		return r0480_secured_outstandbal;
	}

	public void setR0480_secured_outstandbal(BigDecimal r0480_secured_outstandbal) {
		this.r0480_secured_outstandbal = r0480_secured_outstandbal;
	}

	public BigDecimal getR0480_unsecured_outstandbal() {
		return r0480_unsecured_outstandbal;
	}

	public void setR0480_unsecured_outstandbal(BigDecimal r0480_unsecured_outstandbal) {
		this.r0480_unsecured_outstandbal = r0480_unsecured_outstandbal;
	}

	public BigDecimal getR0480_stage1_assetclass() {
		return r0480_stage1_assetclass;
	}

	public void setR0480_stage1_assetclass(BigDecimal r0480_stage1_assetclass) {
		this.r0480_stage1_assetclass = r0480_stage1_assetclass;
	}

	public BigDecimal getR0480_stage2_assetclass() {
		return r0480_stage2_assetclass;
	}

	public void setR0480_stage2_assetclass(BigDecimal r0480_stage2_assetclass) {
		this.r0480_stage2_assetclass = r0480_stage2_assetclass;
	}

	public BigDecimal getR0480_stage3a_assetclass() {
		return r0480_stage3a_assetclass;
	}

	public void setR0480_stage3a_assetclass(BigDecimal r0480_stage3a_assetclass) {
		this.r0480_stage3a_assetclass = r0480_stage3a_assetclass;
	}

	public BigDecimal getR0480_stage3b_assetclass() {
		return r0480_stage3b_assetclass;
	}

	public void setR0480_stage3b_assetclass(BigDecimal r0480_stage3b_assetclass) {
		this.r0480_stage3b_assetclass = r0480_stage3b_assetclass;
	}

	public BigDecimal getR0480_stage3c_assetclass() {
		return r0480_stage3c_assetclass;
	}

	public void setR0480_stage3c_assetclass(BigDecimal r0480_stage3c_assetclass) {
		this.r0480_stage3c_assetclass = r0480_stage3c_assetclass;
	}

	public BigDecimal getR0480_stage1_provisionheld() {
		return r0480_stage1_provisionheld;
	}

	public void setR0480_stage1_provisionheld(BigDecimal r0480_stage1_provisionheld) {
		this.r0480_stage1_provisionheld = r0480_stage1_provisionheld;
	}

	public BigDecimal getR0480_stage2_provisionheld() {
		return r0480_stage2_provisionheld;
	}

	public void setR0480_stage2_provisionheld(BigDecimal r0480_stage2_provisionheld) {
		this.r0480_stage2_provisionheld = r0480_stage2_provisionheld;
	}

	public BigDecimal getR0480_stage3a_provisionheld() {
		return r0480_stage3a_provisionheld;
	}

	public void setR0480_stage3a_provisionheld(BigDecimal r0480_stage3a_provisionheld) {
		this.r0480_stage3a_provisionheld = r0480_stage3a_provisionheld;
	}

	public BigDecimal getR0480_stage3b_provisionheld() {
		return r0480_stage3b_provisionheld;
	}

	public void setR0480_stage3b_provisionheld(BigDecimal r0480_stage3b_provisionheld) {
		this.r0480_stage3b_provisionheld = r0480_stage3b_provisionheld;
	}

	public BigDecimal getR0480_stage3c_provisionheld() {
		return r0480_stage3c_provisionheld;
	}

	public void setR0480_stage3c_provisionheld(BigDecimal r0480_stage3c_provisionheld) {
		this.r0480_stage3c_provisionheld = r0480_stage3c_provisionheld;
	}

	public BigDecimal getR0480_intrestfees_provisionheld() {
		return r0480_intrestfees_provisionheld;
	}

	public void setR0480_intrestfees_provisionheld(BigDecimal r0480_intrestfees_provisionheld) {
		this.r0480_intrestfees_provisionheld = r0480_intrestfees_provisionheld;
	}

	public BigDecimal getR0480_intrestsuspense_provisionheld() {
		return r0480_intrestsuspense_provisionheld;
	}

	public void setR0480_intrestsuspense_provisionheld(BigDecimal r0480_intrestsuspense_provisionheld) {
		this.r0480_intrestsuspense_provisionheld = r0480_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0480_stage1_poci() {
		return r0480_stage1_poci;
	}

	public void setR0480_stage1_poci(BigDecimal r0480_stage1_poci) {
		this.r0480_stage1_poci = r0480_stage1_poci;
	}

	public BigDecimal getR0480_stage2_poci() {
		return r0480_stage2_poci;
	}

	public void setR0480_stage2_poci(BigDecimal r0480_stage2_poci) {
		this.r0480_stage2_poci = r0480_stage2_poci;
	}

	public BigDecimal getR0480_stage3a_poci() {
		return r0480_stage3a_poci;
	}

	public void setR0480_stage3a_poci(BigDecimal r0480_stage3a_poci) {
		this.r0480_stage3a_poci = r0480_stage3a_poci;
	}

	public BigDecimal getR0480_stage3b_poci() {
		return r0480_stage3b_poci;
	}

	public void setR0480_stage3b_poci(BigDecimal r0480_stage3b_poci) {
		this.r0480_stage3b_poci = r0480_stage3b_poci;
	}

	public BigDecimal getR0480_stage3c_poci() {
		return r0480_stage3c_poci;
	}

	public void setR0480_stage3c_poci(BigDecimal r0480_stage3c_poci) {
		this.r0480_stage3c_poci = r0480_stage3c_poci;
	}

	public BigDecimal getR0480_current_pastdues() {
		return r0480_current_pastdues;
	}

	public void setR0480_current_pastdues(BigDecimal r0480_current_pastdues) {
		this.r0480_current_pastdues = r0480_current_pastdues;
	}

	public BigDecimal getR0480_less30days_pastdues() {
		return r0480_less30days_pastdues;
	}

	public void setR0480_less30days_pastdues(BigDecimal r0480_less30days_pastdues) {
		this.r0480_less30days_pastdues = r0480_less30days_pastdues;
	}

	public BigDecimal getR0480_31to90days_pastdues() {
		return r0480_31to90days_pastdues;
	}

	public void setR0480_31to90days_pastdues(BigDecimal r0480_31to90days_pastdues) {
		this.r0480_31to90days_pastdues = r0480_31to90days_pastdues;
	}

	public BigDecimal getR0480_91to120days_pastdues() {
		return r0480_91to120days_pastdues;
	}

	public void setR0480_91to120days_pastdues(BigDecimal r0480_91to120days_pastdues) {
		this.r0480_91to120days_pastdues = r0480_91to120days_pastdues;
	}

	public BigDecimal getR0480_121to180days_pastdues() {
		return r0480_121to180days_pastdues;
	}

	public void setR0480_121to180days_pastdues(BigDecimal r0480_121to180days_pastdues) {
		this.r0480_121to180days_pastdues = r0480_121to180days_pastdues;
	}

	public BigDecimal getR0480_181to365days_pastdues() {
		return r0480_181to365days_pastdues;
	}

	public void setR0480_181to365days_pastdues(BigDecimal r0480_181to365days_pastdues) {
		this.r0480_181to365days_pastdues = r0480_181to365days_pastdues;
	}

	public BigDecimal getR0480_over365days_pastdues() {
		return r0480_over365days_pastdues;
	}

	public void setR0480_over365days_pastdues(BigDecimal r0480_over365days_pastdues) {
		this.r0480_over365days_pastdues = r0480_over365days_pastdues;
	}

	public BigDecimal getR0480_total_pastdues() {
		return r0480_total_pastdues;
	}

	public void setR0480_total_pastdues(BigDecimal r0480_total_pastdues) {
		this.r0480_total_pastdues = r0480_total_pastdues;
	}

	public BigDecimal getR0480_newloan_duringreport() {
		return r0480_newloan_duringreport;
	}

	public void setR0480_newloan_duringreport(BigDecimal r0480_newloan_duringreport) {
		this.r0480_newloan_duringreport = r0480_newloan_duringreport;
	}

	public BigDecimal getR0480_newstage_duringreport() {
		return r0480_newstage_duringreport;
	}

	public void setR0480_newstage_duringreport(BigDecimal r0480_newstage_duringreport) {
		this.r0480_newstage_duringreport = r0480_newstage_duringreport;
	}

	public BigDecimal getR0480_intrestfees_duringreport() {
		return r0480_intrestfees_duringreport;
	}

	public void setR0480_intrestfees_duringreport(BigDecimal r0480_intrestfees_duringreport) {
		this.r0480_intrestfees_duringreport = r0480_intrestfees_duringreport;
	}

	public BigDecimal getR0480_performingac_acinfo() {
		return r0480_performingac_acinfo;
	}

	public void setR0480_performingac_acinfo(BigDecimal r0480_performingac_acinfo) {
		this.r0480_performingac_acinfo = r0480_performingac_acinfo;
	}

	public BigDecimal getR0480_nonperformingac_acinfo() {
		return r0480_nonperformingac_acinfo;
	}

	public void setR0480_nonperformingac_acinfo(BigDecimal r0480_nonperformingac_acinfo) {
		this.r0480_nonperformingac_acinfo = r0480_nonperformingac_acinfo;
	}

	public String getR0490_product() {
		return r0490_product;
	}

	public void setR0490_product(String r0490_product) {
		this.r0490_product = r0490_product;
	}

	public BigDecimal getR0490_outstandbal() {
		return r0490_outstandbal;
	}

	public void setR0490_outstandbal(BigDecimal r0490_outstandbal) {
		this.r0490_outstandbal = r0490_outstandbal;
	}

	public BigDecimal getR0490_secured_outstandbal() {
		return r0490_secured_outstandbal;
	}

	public void setR0490_secured_outstandbal(BigDecimal r0490_secured_outstandbal) {
		this.r0490_secured_outstandbal = r0490_secured_outstandbal;
	}

	public BigDecimal getR0490_unsecured_outstandbal() {
		return r0490_unsecured_outstandbal;
	}

	public void setR0490_unsecured_outstandbal(BigDecimal r0490_unsecured_outstandbal) {
		this.r0490_unsecured_outstandbal = r0490_unsecured_outstandbal;
	}

	public BigDecimal getR0490_stage1_assetclass() {
		return r0490_stage1_assetclass;
	}

	public void setR0490_stage1_assetclass(BigDecimal r0490_stage1_assetclass) {
		this.r0490_stage1_assetclass = r0490_stage1_assetclass;
	}

	public BigDecimal getR0490_stage2_assetclass() {
		return r0490_stage2_assetclass;
	}

	public void setR0490_stage2_assetclass(BigDecimal r0490_stage2_assetclass) {
		this.r0490_stage2_assetclass = r0490_stage2_assetclass;
	}

	public BigDecimal getR0490_stage3a_assetclass() {
		return r0490_stage3a_assetclass;
	}

	public void setR0490_stage3a_assetclass(BigDecimal r0490_stage3a_assetclass) {
		this.r0490_stage3a_assetclass = r0490_stage3a_assetclass;
	}

	public BigDecimal getR0490_stage3b_assetclass() {
		return r0490_stage3b_assetclass;
	}

	public void setR0490_stage3b_assetclass(BigDecimal r0490_stage3b_assetclass) {
		this.r0490_stage3b_assetclass = r0490_stage3b_assetclass;
	}

	public BigDecimal getR0490_stage3c_assetclass() {
		return r0490_stage3c_assetclass;
	}

	public void setR0490_stage3c_assetclass(BigDecimal r0490_stage3c_assetclass) {
		this.r0490_stage3c_assetclass = r0490_stage3c_assetclass;
	}

	public BigDecimal getR0490_stage1_provisionheld() {
		return r0490_stage1_provisionheld;
	}

	public void setR0490_stage1_provisionheld(BigDecimal r0490_stage1_provisionheld) {
		this.r0490_stage1_provisionheld = r0490_stage1_provisionheld;
	}

	public BigDecimal getR0490_stage2_provisionheld() {
		return r0490_stage2_provisionheld;
	}

	public void setR0490_stage2_provisionheld(BigDecimal r0490_stage2_provisionheld) {
		this.r0490_stage2_provisionheld = r0490_stage2_provisionheld;
	}

	public BigDecimal getR0490_stage3a_provisionheld() {
		return r0490_stage3a_provisionheld;
	}

	public void setR0490_stage3a_provisionheld(BigDecimal r0490_stage3a_provisionheld) {
		this.r0490_stage3a_provisionheld = r0490_stage3a_provisionheld;
	}

	public BigDecimal getR0490_stage3b_provisionheld() {
		return r0490_stage3b_provisionheld;
	}

	public void setR0490_stage3b_provisionheld(BigDecimal r0490_stage3b_provisionheld) {
		this.r0490_stage3b_provisionheld = r0490_stage3b_provisionheld;
	}

	public BigDecimal getR0490_stage3c_provisionheld() {
		return r0490_stage3c_provisionheld;
	}

	public void setR0490_stage3c_provisionheld(BigDecimal r0490_stage3c_provisionheld) {
		this.r0490_stage3c_provisionheld = r0490_stage3c_provisionheld;
	}

	public BigDecimal getR0490_intrestfees_provisionheld() {
		return r0490_intrestfees_provisionheld;
	}

	public void setR0490_intrestfees_provisionheld(BigDecimal r0490_intrestfees_provisionheld) {
		this.r0490_intrestfees_provisionheld = r0490_intrestfees_provisionheld;
	}

	public BigDecimal getR0490_intrestsuspense_provisionheld() {
		return r0490_intrestsuspense_provisionheld;
	}

	public void setR0490_intrestsuspense_provisionheld(BigDecimal r0490_intrestsuspense_provisionheld) {
		this.r0490_intrestsuspense_provisionheld = r0490_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0490_stage1_poci() {
		return r0490_stage1_poci;
	}

	public void setR0490_stage1_poci(BigDecimal r0490_stage1_poci) {
		this.r0490_stage1_poci = r0490_stage1_poci;
	}

	public BigDecimal getR0490_stage2_poci() {
		return r0490_stage2_poci;
	}

	public void setR0490_stage2_poci(BigDecimal r0490_stage2_poci) {
		this.r0490_stage2_poci = r0490_stage2_poci;
	}

	public BigDecimal getR0490_stage3a_poci() {
		return r0490_stage3a_poci;
	}

	public void setR0490_stage3a_poci(BigDecimal r0490_stage3a_poci) {
		this.r0490_stage3a_poci = r0490_stage3a_poci;
	}

	public BigDecimal getR0490_stage3b_poci() {
		return r0490_stage3b_poci;
	}

	public void setR0490_stage3b_poci(BigDecimal r0490_stage3b_poci) {
		this.r0490_stage3b_poci = r0490_stage3b_poci;
	}

	public BigDecimal getR0490_stage3c_poci() {
		return r0490_stage3c_poci;
	}

	public void setR0490_stage3c_poci(BigDecimal r0490_stage3c_poci) {
		this.r0490_stage3c_poci = r0490_stage3c_poci;
	}

	public BigDecimal getR0490_current_pastdues() {
		return r0490_current_pastdues;
	}

	public void setR0490_current_pastdues(BigDecimal r0490_current_pastdues) {
		this.r0490_current_pastdues = r0490_current_pastdues;
	}

	public BigDecimal getR0490_less30days_pastdues() {
		return r0490_less30days_pastdues;
	}

	public void setR0490_less30days_pastdues(BigDecimal r0490_less30days_pastdues) {
		this.r0490_less30days_pastdues = r0490_less30days_pastdues;
	}

	public BigDecimal getR0490_31to90days_pastdues() {
		return r0490_31to90days_pastdues;
	}

	public void setR0490_31to90days_pastdues(BigDecimal r0490_31to90days_pastdues) {
		this.r0490_31to90days_pastdues = r0490_31to90days_pastdues;
	}

	public BigDecimal getR0490_91to120days_pastdues() {
		return r0490_91to120days_pastdues;
	}

	public void setR0490_91to120days_pastdues(BigDecimal r0490_91to120days_pastdues) {
		this.r0490_91to120days_pastdues = r0490_91to120days_pastdues;
	}

	public BigDecimal getR0490_121to180days_pastdues() {
		return r0490_121to180days_pastdues;
	}

	public void setR0490_121to180days_pastdues(BigDecimal r0490_121to180days_pastdues) {
		this.r0490_121to180days_pastdues = r0490_121to180days_pastdues;
	}

	public BigDecimal getR0490_181to365days_pastdues() {
		return r0490_181to365days_pastdues;
	}

	public void setR0490_181to365days_pastdues(BigDecimal r0490_181to365days_pastdues) {
		this.r0490_181to365days_pastdues = r0490_181to365days_pastdues;
	}

	public BigDecimal getR0490_over365days_pastdues() {
		return r0490_over365days_pastdues;
	}

	public void setR0490_over365days_pastdues(BigDecimal r0490_over365days_pastdues) {
		this.r0490_over365days_pastdues = r0490_over365days_pastdues;
	}

	public BigDecimal getR0490_total_pastdues() {
		return r0490_total_pastdues;
	}

	public void setR0490_total_pastdues(BigDecimal r0490_total_pastdues) {
		this.r0490_total_pastdues = r0490_total_pastdues;
	}

	public BigDecimal getR0490_newloan_duringreport() {
		return r0490_newloan_duringreport;
	}

	public void setR0490_newloan_duringreport(BigDecimal r0490_newloan_duringreport) {
		this.r0490_newloan_duringreport = r0490_newloan_duringreport;
	}

	public BigDecimal getR0490_newstage_duringreport() {
		return r0490_newstage_duringreport;
	}

	public void setR0490_newstage_duringreport(BigDecimal r0490_newstage_duringreport) {
		this.r0490_newstage_duringreport = r0490_newstage_duringreport;
	}

	public BigDecimal getR0490_intrestfees_duringreport() {
		return r0490_intrestfees_duringreport;
	}

	public void setR0490_intrestfees_duringreport(BigDecimal r0490_intrestfees_duringreport) {
		this.r0490_intrestfees_duringreport = r0490_intrestfees_duringreport;
	}

	public BigDecimal getR0490_performingac_acinfo() {
		return r0490_performingac_acinfo;
	}

	public void setR0490_performingac_acinfo(BigDecimal r0490_performingac_acinfo) {
		this.r0490_performingac_acinfo = r0490_performingac_acinfo;
	}

	public BigDecimal getR0490_nonperformingac_acinfo() {
		return r0490_nonperformingac_acinfo;
	}

	public void setR0490_nonperformingac_acinfo(BigDecimal r0490_nonperformingac_acinfo) {
		this.r0490_nonperformingac_acinfo = r0490_nonperformingac_acinfo;
	}

	public String getR0500_product() {
		return r0500_product;
	}

	public void setR0500_product(String r0500_product) {
		this.r0500_product = r0500_product;
	}

	public BigDecimal getR0500_outstandbal() {
		return r0500_outstandbal;
	}

	public void setR0500_outstandbal(BigDecimal r0500_outstandbal) {
		this.r0500_outstandbal = r0500_outstandbal;
	}

	public BigDecimal getR0500_secured_outstandbal() {
		return r0500_secured_outstandbal;
	}

	public void setR0500_secured_outstandbal(BigDecimal r0500_secured_outstandbal) {
		this.r0500_secured_outstandbal = r0500_secured_outstandbal;
	}

	public BigDecimal getR0500_unsecured_outstandbal() {
		return r0500_unsecured_outstandbal;
	}

	public void setR0500_unsecured_outstandbal(BigDecimal r0500_unsecured_outstandbal) {
		this.r0500_unsecured_outstandbal = r0500_unsecured_outstandbal;
	}

	public BigDecimal getR0500_stage1_assetclass() {
		return r0500_stage1_assetclass;
	}

	public void setR0500_stage1_assetclass(BigDecimal r0500_stage1_assetclass) {
		this.r0500_stage1_assetclass = r0500_stage1_assetclass;
	}

	public BigDecimal getR0500_stage2_assetclass() {
		return r0500_stage2_assetclass;
	}

	public void setR0500_stage2_assetclass(BigDecimal r0500_stage2_assetclass) {
		this.r0500_stage2_assetclass = r0500_stage2_assetclass;
	}

	public BigDecimal getR0500_stage3a_assetclass() {
		return r0500_stage3a_assetclass;
	}

	public void setR0500_stage3a_assetclass(BigDecimal r0500_stage3a_assetclass) {
		this.r0500_stage3a_assetclass = r0500_stage3a_assetclass;
	}

	public BigDecimal getR0500_stage3b_assetclass() {
		return r0500_stage3b_assetclass;
	}

	public void setR0500_stage3b_assetclass(BigDecimal r0500_stage3b_assetclass) {
		this.r0500_stage3b_assetclass = r0500_stage3b_assetclass;
	}

	public BigDecimal getR0500_stage3c_assetclass() {
		return r0500_stage3c_assetclass;
	}

	public void setR0500_stage3c_assetclass(BigDecimal r0500_stage3c_assetclass) {
		this.r0500_stage3c_assetclass = r0500_stage3c_assetclass;
	}

	public BigDecimal getR0500_stage1_provisionheld() {
		return r0500_stage1_provisionheld;
	}

	public void setR0500_stage1_provisionheld(BigDecimal r0500_stage1_provisionheld) {
		this.r0500_stage1_provisionheld = r0500_stage1_provisionheld;
	}

	public BigDecimal getR0500_stage2_provisionheld() {
		return r0500_stage2_provisionheld;
	}

	public void setR0500_stage2_provisionheld(BigDecimal r0500_stage2_provisionheld) {
		this.r0500_stage2_provisionheld = r0500_stage2_provisionheld;
	}

	public BigDecimal getR0500_stage3a_provisionheld() {
		return r0500_stage3a_provisionheld;
	}

	public void setR0500_stage3a_provisionheld(BigDecimal r0500_stage3a_provisionheld) {
		this.r0500_stage3a_provisionheld = r0500_stage3a_provisionheld;
	}

	public BigDecimal getR0500_stage3b_provisionheld() {
		return r0500_stage3b_provisionheld;
	}

	public void setR0500_stage3b_provisionheld(BigDecimal r0500_stage3b_provisionheld) {
		this.r0500_stage3b_provisionheld = r0500_stage3b_provisionheld;
	}

	public BigDecimal getR0500_stage3c_provisionheld() {
		return r0500_stage3c_provisionheld;
	}

	public void setR0500_stage3c_provisionheld(BigDecimal r0500_stage3c_provisionheld) {
		this.r0500_stage3c_provisionheld = r0500_stage3c_provisionheld;
	}

	public BigDecimal getR0500_intrestfees_provisionheld() {
		return r0500_intrestfees_provisionheld;
	}

	public void setR0500_intrestfees_provisionheld(BigDecimal r0500_intrestfees_provisionheld) {
		this.r0500_intrestfees_provisionheld = r0500_intrestfees_provisionheld;
	}

	public BigDecimal getR0500_intrestsuspense_provisionheld() {
		return r0500_intrestsuspense_provisionheld;
	}

	public void setR0500_intrestsuspense_provisionheld(BigDecimal r0500_intrestsuspense_provisionheld) {
		this.r0500_intrestsuspense_provisionheld = r0500_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0500_stage1_poci() {
		return r0500_stage1_poci;
	}

	public void setR0500_stage1_poci(BigDecimal r0500_stage1_poci) {
		this.r0500_stage1_poci = r0500_stage1_poci;
	}

	public BigDecimal getR0500_stage2_poci() {
		return r0500_stage2_poci;
	}

	public void setR0500_stage2_poci(BigDecimal r0500_stage2_poci) {
		this.r0500_stage2_poci = r0500_stage2_poci;
	}

	public BigDecimal getR0500_stage3a_poci() {
		return r0500_stage3a_poci;
	}

	public void setR0500_stage3a_poci(BigDecimal r0500_stage3a_poci) {
		this.r0500_stage3a_poci = r0500_stage3a_poci;
	}

	public BigDecimal getR0500_stage3b_poci() {
		return r0500_stage3b_poci;
	}

	public void setR0500_stage3b_poci(BigDecimal r0500_stage3b_poci) {
		this.r0500_stage3b_poci = r0500_stage3b_poci;
	}

	public BigDecimal getR0500_stage3c_poci() {
		return r0500_stage3c_poci;
	}

	public void setR0500_stage3c_poci(BigDecimal r0500_stage3c_poci) {
		this.r0500_stage3c_poci = r0500_stage3c_poci;
	}

	public BigDecimal getR0500_current_pastdues() {
		return r0500_current_pastdues;
	}

	public void setR0500_current_pastdues(BigDecimal r0500_current_pastdues) {
		this.r0500_current_pastdues = r0500_current_pastdues;
	}

	public BigDecimal getR0500_less30days_pastdues() {
		return r0500_less30days_pastdues;
	}

	public void setR0500_less30days_pastdues(BigDecimal r0500_less30days_pastdues) {
		this.r0500_less30days_pastdues = r0500_less30days_pastdues;
	}

	public BigDecimal getR0500_31to90days_pastdues() {
		return r0500_31to90days_pastdues;
	}

	public void setR0500_31to90days_pastdues(BigDecimal r0500_31to90days_pastdues) {
		this.r0500_31to90days_pastdues = r0500_31to90days_pastdues;
	}

	public BigDecimal getR0500_91to120days_pastdues() {
		return r0500_91to120days_pastdues;
	}

	public void setR0500_91to120days_pastdues(BigDecimal r0500_91to120days_pastdues) {
		this.r0500_91to120days_pastdues = r0500_91to120days_pastdues;
	}

	public BigDecimal getR0500_121to180days_pastdues() {
		return r0500_121to180days_pastdues;
	}

	public void setR0500_121to180days_pastdues(BigDecimal r0500_121to180days_pastdues) {
		this.r0500_121to180days_pastdues = r0500_121to180days_pastdues;
	}

	public BigDecimal getR0500_181to365days_pastdues() {
		return r0500_181to365days_pastdues;
	}

	public void setR0500_181to365days_pastdues(BigDecimal r0500_181to365days_pastdues) {
		this.r0500_181to365days_pastdues = r0500_181to365days_pastdues;
	}

	public BigDecimal getR0500_over365days_pastdues() {
		return r0500_over365days_pastdues;
	}

	public void setR0500_over365days_pastdues(BigDecimal r0500_over365days_pastdues) {
		this.r0500_over365days_pastdues = r0500_over365days_pastdues;
	}

	public BigDecimal getR0500_total_pastdues() {
		return r0500_total_pastdues;
	}

	public void setR0500_total_pastdues(BigDecimal r0500_total_pastdues) {
		this.r0500_total_pastdues = r0500_total_pastdues;
	}

	public BigDecimal getR0500_newloan_duringreport() {
		return r0500_newloan_duringreport;
	}

	public void setR0500_newloan_duringreport(BigDecimal r0500_newloan_duringreport) {
		this.r0500_newloan_duringreport = r0500_newloan_duringreport;
	}

	public BigDecimal getR0500_newstage_duringreport() {
		return r0500_newstage_duringreport;
	}

	public void setR0500_newstage_duringreport(BigDecimal r0500_newstage_duringreport) {
		this.r0500_newstage_duringreport = r0500_newstage_duringreport;
	}

	public BigDecimal getR0500_intrestfees_duringreport() {
		return r0500_intrestfees_duringreport;
	}

	public void setR0500_intrestfees_duringreport(BigDecimal r0500_intrestfees_duringreport) {
		this.r0500_intrestfees_duringreport = r0500_intrestfees_duringreport;
	}

	public BigDecimal getR0500_performingac_acinfo() {
		return r0500_performingac_acinfo;
	}

	public void setR0500_performingac_acinfo(BigDecimal r0500_performingac_acinfo) {
		this.r0500_performingac_acinfo = r0500_performingac_acinfo;
	}

	public BigDecimal getR0500_nonperformingac_acinfo() {
		return r0500_nonperformingac_acinfo;
	}

	public void setR0500_nonperformingac_acinfo(BigDecimal r0500_nonperformingac_acinfo) {
		this.r0500_nonperformingac_acinfo = r0500_nonperformingac_acinfo;
	}

	public String getR0510_product() {
		return r0510_product;
	}

	public void setR0510_product(String r0510_product) {
		this.r0510_product = r0510_product;
	}

	public BigDecimal getR0510_outstandbal() {
		return r0510_outstandbal;
	}

	public void setR0510_outstandbal(BigDecimal r0510_outstandbal) {
		this.r0510_outstandbal = r0510_outstandbal;
	}

	public BigDecimal getR0510_secured_outstandbal() {
		return r0510_secured_outstandbal;
	}

	public void setR0510_secured_outstandbal(BigDecimal r0510_secured_outstandbal) {
		this.r0510_secured_outstandbal = r0510_secured_outstandbal;
	}

	public BigDecimal getR0510_unsecured_outstandbal() {
		return r0510_unsecured_outstandbal;
	}

	public void setR0510_unsecured_outstandbal(BigDecimal r0510_unsecured_outstandbal) {
		this.r0510_unsecured_outstandbal = r0510_unsecured_outstandbal;
	}

	public BigDecimal getR0510_stage1_assetclass() {
		return r0510_stage1_assetclass;
	}

	public void setR0510_stage1_assetclass(BigDecimal r0510_stage1_assetclass) {
		this.r0510_stage1_assetclass = r0510_stage1_assetclass;
	}

	public BigDecimal getR0510_stage2_assetclass() {
		return r0510_stage2_assetclass;
	}

	public void setR0510_stage2_assetclass(BigDecimal r0510_stage2_assetclass) {
		this.r0510_stage2_assetclass = r0510_stage2_assetclass;
	}

	public BigDecimal getR0510_stage3a_assetclass() {
		return r0510_stage3a_assetclass;
	}

	public void setR0510_stage3a_assetclass(BigDecimal r0510_stage3a_assetclass) {
		this.r0510_stage3a_assetclass = r0510_stage3a_assetclass;
	}

	public BigDecimal getR0510_stage3b_assetclass() {
		return r0510_stage3b_assetclass;
	}

	public void setR0510_stage3b_assetclass(BigDecimal r0510_stage3b_assetclass) {
		this.r0510_stage3b_assetclass = r0510_stage3b_assetclass;
	}

	public BigDecimal getR0510_stage3c_assetclass() {
		return r0510_stage3c_assetclass;
	}

	public void setR0510_stage3c_assetclass(BigDecimal r0510_stage3c_assetclass) {
		this.r0510_stage3c_assetclass = r0510_stage3c_assetclass;
	}

	public BigDecimal getR0510_stage1_provisionheld() {
		return r0510_stage1_provisionheld;
	}

	public void setR0510_stage1_provisionheld(BigDecimal r0510_stage1_provisionheld) {
		this.r0510_stage1_provisionheld = r0510_stage1_provisionheld;
	}

	public BigDecimal getR0510_stage2_provisionheld() {
		return r0510_stage2_provisionheld;
	}

	public void setR0510_stage2_provisionheld(BigDecimal r0510_stage2_provisionheld) {
		this.r0510_stage2_provisionheld = r0510_stage2_provisionheld;
	}

	public BigDecimal getR0510_stage3a_provisionheld() {
		return r0510_stage3a_provisionheld;
	}

	public void setR0510_stage3a_provisionheld(BigDecimal r0510_stage3a_provisionheld) {
		this.r0510_stage3a_provisionheld = r0510_stage3a_provisionheld;
	}

	public BigDecimal getR0510_stage3b_provisionheld() {
		return r0510_stage3b_provisionheld;
	}

	public void setR0510_stage3b_provisionheld(BigDecimal r0510_stage3b_provisionheld) {
		this.r0510_stage3b_provisionheld = r0510_stage3b_provisionheld;
	}

	public BigDecimal getR0510_stage3c_provisionheld() {
		return r0510_stage3c_provisionheld;
	}

	public void setR0510_stage3c_provisionheld(BigDecimal r0510_stage3c_provisionheld) {
		this.r0510_stage3c_provisionheld = r0510_stage3c_provisionheld;
	}

	public BigDecimal getR0510_intrestfees_provisionheld() {
		return r0510_intrestfees_provisionheld;
	}

	public void setR0510_intrestfees_provisionheld(BigDecimal r0510_intrestfees_provisionheld) {
		this.r0510_intrestfees_provisionheld = r0510_intrestfees_provisionheld;
	}

	public BigDecimal getR0510_intrestsuspense_provisionheld() {
		return r0510_intrestsuspense_provisionheld;
	}

	public void setR0510_intrestsuspense_provisionheld(BigDecimal r0510_intrestsuspense_provisionheld) {
		this.r0510_intrestsuspense_provisionheld = r0510_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0510_stage1_poci() {
		return r0510_stage1_poci;
	}

	public void setR0510_stage1_poci(BigDecimal r0510_stage1_poci) {
		this.r0510_stage1_poci = r0510_stage1_poci;
	}

	public BigDecimal getR0510_stage2_poci() {
		return r0510_stage2_poci;
	}

	public void setR0510_stage2_poci(BigDecimal r0510_stage2_poci) {
		this.r0510_stage2_poci = r0510_stage2_poci;
	}

	public BigDecimal getR0510_stage3a_poci() {
		return r0510_stage3a_poci;
	}

	public void setR0510_stage3a_poci(BigDecimal r0510_stage3a_poci) {
		this.r0510_stage3a_poci = r0510_stage3a_poci;
	}

	public BigDecimal getR0510_stage3b_poci() {
		return r0510_stage3b_poci;
	}

	public void setR0510_stage3b_poci(BigDecimal r0510_stage3b_poci) {
		this.r0510_stage3b_poci = r0510_stage3b_poci;
	}

	public BigDecimal getR0510_stage3c_poci() {
		return r0510_stage3c_poci;
	}

	public void setR0510_stage3c_poci(BigDecimal r0510_stage3c_poci) {
		this.r0510_stage3c_poci = r0510_stage3c_poci;
	}

	public BigDecimal getR0510_current_pastdues() {
		return r0510_current_pastdues;
	}

	public void setR0510_current_pastdues(BigDecimal r0510_current_pastdues) {
		this.r0510_current_pastdues = r0510_current_pastdues;
	}

	public BigDecimal getR0510_less30days_pastdues() {
		return r0510_less30days_pastdues;
	}

	public void setR0510_less30days_pastdues(BigDecimal r0510_less30days_pastdues) {
		this.r0510_less30days_pastdues = r0510_less30days_pastdues;
	}

	public BigDecimal getR0510_31to90days_pastdues() {
		return r0510_31to90days_pastdues;
	}

	public void setR0510_31to90days_pastdues(BigDecimal r0510_31to90days_pastdues) {
		this.r0510_31to90days_pastdues = r0510_31to90days_pastdues;
	}

	public BigDecimal getR0510_91to120days_pastdues() {
		return r0510_91to120days_pastdues;
	}

	public void setR0510_91to120days_pastdues(BigDecimal r0510_91to120days_pastdues) {
		this.r0510_91to120days_pastdues = r0510_91to120days_pastdues;
	}

	public BigDecimal getR0510_121to180days_pastdues() {
		return r0510_121to180days_pastdues;
	}

	public void setR0510_121to180days_pastdues(BigDecimal r0510_121to180days_pastdues) {
		this.r0510_121to180days_pastdues = r0510_121to180days_pastdues;
	}

	public BigDecimal getR0510_181to365days_pastdues() {
		return r0510_181to365days_pastdues;
	}

	public void setR0510_181to365days_pastdues(BigDecimal r0510_181to365days_pastdues) {
		this.r0510_181to365days_pastdues = r0510_181to365days_pastdues;
	}

	public BigDecimal getR0510_over365days_pastdues() {
		return r0510_over365days_pastdues;
	}

	public void setR0510_over365days_pastdues(BigDecimal r0510_over365days_pastdues) {
		this.r0510_over365days_pastdues = r0510_over365days_pastdues;
	}

	public BigDecimal getR0510_total_pastdues() {
		return r0510_total_pastdues;
	}

	public void setR0510_total_pastdues(BigDecimal r0510_total_pastdues) {
		this.r0510_total_pastdues = r0510_total_pastdues;
	}

	public BigDecimal getR0510_newloan_duringreport() {
		return r0510_newloan_duringreport;
	}

	public void setR0510_newloan_duringreport(BigDecimal r0510_newloan_duringreport) {
		this.r0510_newloan_duringreport = r0510_newloan_duringreport;
	}

	public BigDecimal getR0510_newstage_duringreport() {
		return r0510_newstage_duringreport;
	}

	public void setR0510_newstage_duringreport(BigDecimal r0510_newstage_duringreport) {
		this.r0510_newstage_duringreport = r0510_newstage_duringreport;
	}

	public BigDecimal getR0510_intrestfees_duringreport() {
		return r0510_intrestfees_duringreport;
	}

	public void setR0510_intrestfees_duringreport(BigDecimal r0510_intrestfees_duringreport) {
		this.r0510_intrestfees_duringreport = r0510_intrestfees_duringreport;
	}

	public BigDecimal getR0510_performingac_acinfo() {
		return r0510_performingac_acinfo;
	}

	public void setR0510_performingac_acinfo(BigDecimal r0510_performingac_acinfo) {
		this.r0510_performingac_acinfo = r0510_performingac_acinfo;
	}

	public BigDecimal getR0510_nonperformingac_acinfo() {
		return r0510_nonperformingac_acinfo;
	}

	public void setR0510_nonperformingac_acinfo(BigDecimal r0510_nonperformingac_acinfo) {
		this.r0510_nonperformingac_acinfo = r0510_nonperformingac_acinfo;
	}

	public String getR0520_product() {
		return r0520_product;
	}

	public void setR0520_product(String r0520_product) {
		this.r0520_product = r0520_product;
	}

	public BigDecimal getR0520_outstandbal() {
		return r0520_outstandbal;
	}

	public void setR0520_outstandbal(BigDecimal r0520_outstandbal) {
		this.r0520_outstandbal = r0520_outstandbal;
	}

	public BigDecimal getR0520_secured_outstandbal() {
		return r0520_secured_outstandbal;
	}

	public void setR0520_secured_outstandbal(BigDecimal r0520_secured_outstandbal) {
		this.r0520_secured_outstandbal = r0520_secured_outstandbal;
	}

	public BigDecimal getR0520_unsecured_outstandbal() {
		return r0520_unsecured_outstandbal;
	}

	public void setR0520_unsecured_outstandbal(BigDecimal r0520_unsecured_outstandbal) {
		this.r0520_unsecured_outstandbal = r0520_unsecured_outstandbal;
	}

	public BigDecimal getR0520_stage1_assetclass() {
		return r0520_stage1_assetclass;
	}

	public void setR0520_stage1_assetclass(BigDecimal r0520_stage1_assetclass) {
		this.r0520_stage1_assetclass = r0520_stage1_assetclass;
	}

	public BigDecimal getR0520_stage2_assetclass() {
		return r0520_stage2_assetclass;
	}

	public void setR0520_stage2_assetclass(BigDecimal r0520_stage2_assetclass) {
		this.r0520_stage2_assetclass = r0520_stage2_assetclass;
	}

	public BigDecimal getR0520_stage3a_assetclass() {
		return r0520_stage3a_assetclass;
	}

	public void setR0520_stage3a_assetclass(BigDecimal r0520_stage3a_assetclass) {
		this.r0520_stage3a_assetclass = r0520_stage3a_assetclass;
	}

	public BigDecimal getR0520_stage3b_assetclass() {
		return r0520_stage3b_assetclass;
	}

	public void setR0520_stage3b_assetclass(BigDecimal r0520_stage3b_assetclass) {
		this.r0520_stage3b_assetclass = r0520_stage3b_assetclass;
	}

	public BigDecimal getR0520_stage3c_assetclass() {
		return r0520_stage3c_assetclass;
	}

	public void setR0520_stage3c_assetclass(BigDecimal r0520_stage3c_assetclass) {
		this.r0520_stage3c_assetclass = r0520_stage3c_assetclass;
	}

	public BigDecimal getR0520_stage1_provisionheld() {
		return r0520_stage1_provisionheld;
	}

	public void setR0520_stage1_provisionheld(BigDecimal r0520_stage1_provisionheld) {
		this.r0520_stage1_provisionheld = r0520_stage1_provisionheld;
	}

	public BigDecimal getR0520_stage2_provisionheld() {
		return r0520_stage2_provisionheld;
	}

	public void setR0520_stage2_provisionheld(BigDecimal r0520_stage2_provisionheld) {
		this.r0520_stage2_provisionheld = r0520_stage2_provisionheld;
	}

	public BigDecimal getR0520_stage3a_provisionheld() {
		return r0520_stage3a_provisionheld;
	}

	public void setR0520_stage3a_provisionheld(BigDecimal r0520_stage3a_provisionheld) {
		this.r0520_stage3a_provisionheld = r0520_stage3a_provisionheld;
	}

	public BigDecimal getR0520_stage3b_provisionheld() {
		return r0520_stage3b_provisionheld;
	}

	public void setR0520_stage3b_provisionheld(BigDecimal r0520_stage3b_provisionheld) {
		this.r0520_stage3b_provisionheld = r0520_stage3b_provisionheld;
	}

	public BigDecimal getR0520_stage3c_provisionheld() {
		return r0520_stage3c_provisionheld;
	}

	public void setR0520_stage3c_provisionheld(BigDecimal r0520_stage3c_provisionheld) {
		this.r0520_stage3c_provisionheld = r0520_stage3c_provisionheld;
	}

	public BigDecimal getR0520_intrestfees_provisionheld() {
		return r0520_intrestfees_provisionheld;
	}

	public void setR0520_intrestfees_provisionheld(BigDecimal r0520_intrestfees_provisionheld) {
		this.r0520_intrestfees_provisionheld = r0520_intrestfees_provisionheld;
	}

	public BigDecimal getR0520_intrestsuspense_provisionheld() {
		return r0520_intrestsuspense_provisionheld;
	}

	public void setR0520_intrestsuspense_provisionheld(BigDecimal r0520_intrestsuspense_provisionheld) {
		this.r0520_intrestsuspense_provisionheld = r0520_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0520_stage1_poci() {
		return r0520_stage1_poci;
	}

	public void setR0520_stage1_poci(BigDecimal r0520_stage1_poci) {
		this.r0520_stage1_poci = r0520_stage1_poci;
	}

	public BigDecimal getR0520_stage2_poci() {
		return r0520_stage2_poci;
	}

	public void setR0520_stage2_poci(BigDecimal r0520_stage2_poci) {
		this.r0520_stage2_poci = r0520_stage2_poci;
	}

	public BigDecimal getR0520_stage3a_poci() {
		return r0520_stage3a_poci;
	}

	public void setR0520_stage3a_poci(BigDecimal r0520_stage3a_poci) {
		this.r0520_stage3a_poci = r0520_stage3a_poci;
	}

	public BigDecimal getR0520_stage3b_poci() {
		return r0520_stage3b_poci;
	}

	public void setR0520_stage3b_poci(BigDecimal r0520_stage3b_poci) {
		this.r0520_stage3b_poci = r0520_stage3b_poci;
	}

	public BigDecimal getR0520_stage3c_poci() {
		return r0520_stage3c_poci;
	}

	public void setR0520_stage3c_poci(BigDecimal r0520_stage3c_poci) {
		this.r0520_stage3c_poci = r0520_stage3c_poci;
	}

	public BigDecimal getR0520_current_pastdues() {
		return r0520_current_pastdues;
	}

	public void setR0520_current_pastdues(BigDecimal r0520_current_pastdues) {
		this.r0520_current_pastdues = r0520_current_pastdues;
	}

	public BigDecimal getR0520_less30days_pastdues() {
		return r0520_less30days_pastdues;
	}

	public void setR0520_less30days_pastdues(BigDecimal r0520_less30days_pastdues) {
		this.r0520_less30days_pastdues = r0520_less30days_pastdues;
	}

	public BigDecimal getR0520_31to90days_pastdues() {
		return r0520_31to90days_pastdues;
	}

	public void setR0520_31to90days_pastdues(BigDecimal r0520_31to90days_pastdues) {
		this.r0520_31to90days_pastdues = r0520_31to90days_pastdues;
	}

	public BigDecimal getR0520_91to120days_pastdues() {
		return r0520_91to120days_pastdues;
	}

	public void setR0520_91to120days_pastdues(BigDecimal r0520_91to120days_pastdues) {
		this.r0520_91to120days_pastdues = r0520_91to120days_pastdues;
	}

	public BigDecimal getR0520_121to180days_pastdues() {
		return r0520_121to180days_pastdues;
	}

	public void setR0520_121to180days_pastdues(BigDecimal r0520_121to180days_pastdues) {
		this.r0520_121to180days_pastdues = r0520_121to180days_pastdues;
	}

	public BigDecimal getR0520_181to365days_pastdues() {
		return r0520_181to365days_pastdues;
	}

	public void setR0520_181to365days_pastdues(BigDecimal r0520_181to365days_pastdues) {
		this.r0520_181to365days_pastdues = r0520_181to365days_pastdues;
	}

	public BigDecimal getR0520_over365days_pastdues() {
		return r0520_over365days_pastdues;
	}

	public void setR0520_over365days_pastdues(BigDecimal r0520_over365days_pastdues) {
		this.r0520_over365days_pastdues = r0520_over365days_pastdues;
	}

	public BigDecimal getR0520_total_pastdues() {
		return r0520_total_pastdues;
	}

	public void setR0520_total_pastdues(BigDecimal r0520_total_pastdues) {
		this.r0520_total_pastdues = r0520_total_pastdues;
	}

	public BigDecimal getR0520_newloan_duringreport() {
		return r0520_newloan_duringreport;
	}

	public void setR0520_newloan_duringreport(BigDecimal r0520_newloan_duringreport) {
		this.r0520_newloan_duringreport = r0520_newloan_duringreport;
	}

	public BigDecimal getR0520_newstage_duringreport() {
		return r0520_newstage_duringreport;
	}

	public void setR0520_newstage_duringreport(BigDecimal r0520_newstage_duringreport) {
		this.r0520_newstage_duringreport = r0520_newstage_duringreport;
	}

	public BigDecimal getR0520_intrestfees_duringreport() {
		return r0520_intrestfees_duringreport;
	}

	public void setR0520_intrestfees_duringreport(BigDecimal r0520_intrestfees_duringreport) {
		this.r0520_intrestfees_duringreport = r0520_intrestfees_duringreport;
	}

	public BigDecimal getR0520_performingac_acinfo() {
		return r0520_performingac_acinfo;
	}

	public void setR0520_performingac_acinfo(BigDecimal r0520_performingac_acinfo) {
		this.r0520_performingac_acinfo = r0520_performingac_acinfo;
	}

	public BigDecimal getR0520_nonperformingac_acinfo() {
		return r0520_nonperformingac_acinfo;
	}

	public void setR0520_nonperformingac_acinfo(BigDecimal r0520_nonperformingac_acinfo) {
		this.r0520_nonperformingac_acinfo = r0520_nonperformingac_acinfo;
	}

	public String getR0530_product() {
		return r0530_product;
	}

	public void setR0530_product(String r0530_product) {
		this.r0530_product = r0530_product;
	}

	public BigDecimal getR0530_outstandbal() {
		return r0530_outstandbal;
	}

	public void setR0530_outstandbal(BigDecimal r0530_outstandbal) {
		this.r0530_outstandbal = r0530_outstandbal;
	}

	public BigDecimal getR0530_secured_outstandbal() {
		return r0530_secured_outstandbal;
	}

	public void setR0530_secured_outstandbal(BigDecimal r0530_secured_outstandbal) {
		this.r0530_secured_outstandbal = r0530_secured_outstandbal;
	}

	public BigDecimal getR0530_unsecured_outstandbal() {
		return r0530_unsecured_outstandbal;
	}

	public void setR0530_unsecured_outstandbal(BigDecimal r0530_unsecured_outstandbal) {
		this.r0530_unsecured_outstandbal = r0530_unsecured_outstandbal;
	}

	public BigDecimal getR0530_stage1_assetclass() {
		return r0530_stage1_assetclass;
	}

	public void setR0530_stage1_assetclass(BigDecimal r0530_stage1_assetclass) {
		this.r0530_stage1_assetclass = r0530_stage1_assetclass;
	}

	public BigDecimal getR0530_stage2_assetclass() {
		return r0530_stage2_assetclass;
	}

	public void setR0530_stage2_assetclass(BigDecimal r0530_stage2_assetclass) {
		this.r0530_stage2_assetclass = r0530_stage2_assetclass;
	}

	public BigDecimal getR0530_stage3a_assetclass() {
		return r0530_stage3a_assetclass;
	}

	public void setR0530_stage3a_assetclass(BigDecimal r0530_stage3a_assetclass) {
		this.r0530_stage3a_assetclass = r0530_stage3a_assetclass;
	}

	public BigDecimal getR0530_stage3b_assetclass() {
		return r0530_stage3b_assetclass;
	}

	public void setR0530_stage3b_assetclass(BigDecimal r0530_stage3b_assetclass) {
		this.r0530_stage3b_assetclass = r0530_stage3b_assetclass;
	}

	public BigDecimal getR0530_stage3c_assetclass() {
		return r0530_stage3c_assetclass;
	}

	public void setR0530_stage3c_assetclass(BigDecimal r0530_stage3c_assetclass) {
		this.r0530_stage3c_assetclass = r0530_stage3c_assetclass;
	}

	public BigDecimal getR0530_stage1_provisionheld() {
		return r0530_stage1_provisionheld;
	}

	public void setR0530_stage1_provisionheld(BigDecimal r0530_stage1_provisionheld) {
		this.r0530_stage1_provisionheld = r0530_stage1_provisionheld;
	}

	public BigDecimal getR0530_stage2_provisionheld() {
		return r0530_stage2_provisionheld;
	}

	public void setR0530_stage2_provisionheld(BigDecimal r0530_stage2_provisionheld) {
		this.r0530_stage2_provisionheld = r0530_stage2_provisionheld;
	}

	public BigDecimal getR0530_stage3a_provisionheld() {
		return r0530_stage3a_provisionheld;
	}

	public void setR0530_stage3a_provisionheld(BigDecimal r0530_stage3a_provisionheld) {
		this.r0530_stage3a_provisionheld = r0530_stage3a_provisionheld;
	}

	public BigDecimal getR0530_stage3b_provisionheld() {
		return r0530_stage3b_provisionheld;
	}

	public void setR0530_stage3b_provisionheld(BigDecimal r0530_stage3b_provisionheld) {
		this.r0530_stage3b_provisionheld = r0530_stage3b_provisionheld;
	}

	public BigDecimal getR0530_stage3c_provisionheld() {
		return r0530_stage3c_provisionheld;
	}

	public void setR0530_stage3c_provisionheld(BigDecimal r0530_stage3c_provisionheld) {
		this.r0530_stage3c_provisionheld = r0530_stage3c_provisionheld;
	}

	public BigDecimal getR0530_intrestfees_provisionheld() {
		return r0530_intrestfees_provisionheld;
	}

	public void setR0530_intrestfees_provisionheld(BigDecimal r0530_intrestfees_provisionheld) {
		this.r0530_intrestfees_provisionheld = r0530_intrestfees_provisionheld;
	}

	public BigDecimal getR0530_intrestsuspense_provisionheld() {
		return r0530_intrestsuspense_provisionheld;
	}

	public void setR0530_intrestsuspense_provisionheld(BigDecimal r0530_intrestsuspense_provisionheld) {
		this.r0530_intrestsuspense_provisionheld = r0530_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0530_stage1_poci() {
		return r0530_stage1_poci;
	}

	public void setR0530_stage1_poci(BigDecimal r0530_stage1_poci) {
		this.r0530_stage1_poci = r0530_stage1_poci;
	}

	public BigDecimal getR0530_stage2_poci() {
		return r0530_stage2_poci;
	}

	public void setR0530_stage2_poci(BigDecimal r0530_stage2_poci) {
		this.r0530_stage2_poci = r0530_stage2_poci;
	}

	public BigDecimal getR0530_stage3a_poci() {
		return r0530_stage3a_poci;
	}

	public void setR0530_stage3a_poci(BigDecimal r0530_stage3a_poci) {
		this.r0530_stage3a_poci = r0530_stage3a_poci;
	}

	public BigDecimal getR0530_stage3b_poci() {
		return r0530_stage3b_poci;
	}

	public void setR0530_stage3b_poci(BigDecimal r0530_stage3b_poci) {
		this.r0530_stage3b_poci = r0530_stage3b_poci;
	}

	public BigDecimal getR0530_stage3c_poci() {
		return r0530_stage3c_poci;
	}

	public void setR0530_stage3c_poci(BigDecimal r0530_stage3c_poci) {
		this.r0530_stage3c_poci = r0530_stage3c_poci;
	}

	public BigDecimal getR0530_current_pastdues() {
		return r0530_current_pastdues;
	}

	public void setR0530_current_pastdues(BigDecimal r0530_current_pastdues) {
		this.r0530_current_pastdues = r0530_current_pastdues;
	}

	public BigDecimal getR0530_less30days_pastdues() {
		return r0530_less30days_pastdues;
	}

	public void setR0530_less30days_pastdues(BigDecimal r0530_less30days_pastdues) {
		this.r0530_less30days_pastdues = r0530_less30days_pastdues;
	}

	public BigDecimal getR0530_31to90days_pastdues() {
		return r0530_31to90days_pastdues;
	}

	public void setR0530_31to90days_pastdues(BigDecimal r0530_31to90days_pastdues) {
		this.r0530_31to90days_pastdues = r0530_31to90days_pastdues;
	}

	public BigDecimal getR0530_91to120days_pastdues() {
		return r0530_91to120days_pastdues;
	}

	public void setR0530_91to120days_pastdues(BigDecimal r0530_91to120days_pastdues) {
		this.r0530_91to120days_pastdues = r0530_91to120days_pastdues;
	}

	public BigDecimal getR0530_121to180days_pastdues() {
		return r0530_121to180days_pastdues;
	}

	public void setR0530_121to180days_pastdues(BigDecimal r0530_121to180days_pastdues) {
		this.r0530_121to180days_pastdues = r0530_121to180days_pastdues;
	}

	public BigDecimal getR0530_181to365days_pastdues() {
		return r0530_181to365days_pastdues;
	}

	public void setR0530_181to365days_pastdues(BigDecimal r0530_181to365days_pastdues) {
		this.r0530_181to365days_pastdues = r0530_181to365days_pastdues;
	}

	public BigDecimal getR0530_over365days_pastdues() {
		return r0530_over365days_pastdues;
	}

	public void setR0530_over365days_pastdues(BigDecimal r0530_over365days_pastdues) {
		this.r0530_over365days_pastdues = r0530_over365days_pastdues;
	}

	public BigDecimal getR0530_total_pastdues() {
		return r0530_total_pastdues;
	}

	public void setR0530_total_pastdues(BigDecimal r0530_total_pastdues) {
		this.r0530_total_pastdues = r0530_total_pastdues;
	}

	public BigDecimal getR0530_newloan_duringreport() {
		return r0530_newloan_duringreport;
	}

	public void setR0530_newloan_duringreport(BigDecimal r0530_newloan_duringreport) {
		this.r0530_newloan_duringreport = r0530_newloan_duringreport;
	}

	public BigDecimal getR0530_newstage_duringreport() {
		return r0530_newstage_duringreport;
	}

	public void setR0530_newstage_duringreport(BigDecimal r0530_newstage_duringreport) {
		this.r0530_newstage_duringreport = r0530_newstage_duringreport;
	}

	public BigDecimal getR0530_intrestfees_duringreport() {
		return r0530_intrestfees_duringreport;
	}

	public void setR0530_intrestfees_duringreport(BigDecimal r0530_intrestfees_duringreport) {
		this.r0530_intrestfees_duringreport = r0530_intrestfees_duringreport;
	}

	public BigDecimal getR0530_performingac_acinfo() {
		return r0530_performingac_acinfo;
	}

	public void setR0530_performingac_acinfo(BigDecimal r0530_performingac_acinfo) {
		this.r0530_performingac_acinfo = r0530_performingac_acinfo;
	}

	public BigDecimal getR0530_nonperformingac_acinfo() {
		return r0530_nonperformingac_acinfo;
	}

	public void setR0530_nonperformingac_acinfo(BigDecimal r0530_nonperformingac_acinfo) {
		this.r0530_nonperformingac_acinfo = r0530_nonperformingac_acinfo;
	}

	public String getR0540_product() {
		return r0540_product;
	}

	public void setR0540_product(String r0540_product) {
		this.r0540_product = r0540_product;
	}

	public BigDecimal getR0540_outstandbal() {
		return r0540_outstandbal;
	}

	public void setR0540_outstandbal(BigDecimal r0540_outstandbal) {
		this.r0540_outstandbal = r0540_outstandbal;
	}

	public BigDecimal getR0540_secured_outstandbal() {
		return r0540_secured_outstandbal;
	}

	public void setR0540_secured_outstandbal(BigDecimal r0540_secured_outstandbal) {
		this.r0540_secured_outstandbal = r0540_secured_outstandbal;
	}

	public BigDecimal getR0540_unsecured_outstandbal() {
		return r0540_unsecured_outstandbal;
	}

	public void setR0540_unsecured_outstandbal(BigDecimal r0540_unsecured_outstandbal) {
		this.r0540_unsecured_outstandbal = r0540_unsecured_outstandbal;
	}

	public BigDecimal getR0540_stage1_assetclass() {
		return r0540_stage1_assetclass;
	}

	public void setR0540_stage1_assetclass(BigDecimal r0540_stage1_assetclass) {
		this.r0540_stage1_assetclass = r0540_stage1_assetclass;
	}

	public BigDecimal getR0540_stage2_assetclass() {
		return r0540_stage2_assetclass;
	}

	public void setR0540_stage2_assetclass(BigDecimal r0540_stage2_assetclass) {
		this.r0540_stage2_assetclass = r0540_stage2_assetclass;
	}

	public BigDecimal getR0540_stage3a_assetclass() {
		return r0540_stage3a_assetclass;
	}

	public void setR0540_stage3a_assetclass(BigDecimal r0540_stage3a_assetclass) {
		this.r0540_stage3a_assetclass = r0540_stage3a_assetclass;
	}

	public BigDecimal getR0540_stage3b_assetclass() {
		return r0540_stage3b_assetclass;
	}

	public void setR0540_stage3b_assetclass(BigDecimal r0540_stage3b_assetclass) {
		this.r0540_stage3b_assetclass = r0540_stage3b_assetclass;
	}

	public BigDecimal getR0540_stage3c_assetclass() {
		return r0540_stage3c_assetclass;
	}

	public void setR0540_stage3c_assetclass(BigDecimal r0540_stage3c_assetclass) {
		this.r0540_stage3c_assetclass = r0540_stage3c_assetclass;
	}

	public BigDecimal getR0540_stage1_provisionheld() {
		return r0540_stage1_provisionheld;
	}

	public void setR0540_stage1_provisionheld(BigDecimal r0540_stage1_provisionheld) {
		this.r0540_stage1_provisionheld = r0540_stage1_provisionheld;
	}

	public BigDecimal getR0540_stage2_provisionheld() {
		return r0540_stage2_provisionheld;
	}

	public void setR0540_stage2_provisionheld(BigDecimal r0540_stage2_provisionheld) {
		this.r0540_stage2_provisionheld = r0540_stage2_provisionheld;
	}

	public BigDecimal getR0540_stage3a_provisionheld() {
		return r0540_stage3a_provisionheld;
	}

	public void setR0540_stage3a_provisionheld(BigDecimal r0540_stage3a_provisionheld) {
		this.r0540_stage3a_provisionheld = r0540_stage3a_provisionheld;
	}

	public BigDecimal getR0540_stage3b_provisionheld() {
		return r0540_stage3b_provisionheld;
	}

	public void setR0540_stage3b_provisionheld(BigDecimal r0540_stage3b_provisionheld) {
		this.r0540_stage3b_provisionheld = r0540_stage3b_provisionheld;
	}

	public BigDecimal getR0540_stage3c_provisionheld() {
		return r0540_stage3c_provisionheld;
	}

	public void setR0540_stage3c_provisionheld(BigDecimal r0540_stage3c_provisionheld) {
		this.r0540_stage3c_provisionheld = r0540_stage3c_provisionheld;
	}

	public BigDecimal getR0540_intrestfees_provisionheld() {
		return r0540_intrestfees_provisionheld;
	}

	public void setR0540_intrestfees_provisionheld(BigDecimal r0540_intrestfees_provisionheld) {
		this.r0540_intrestfees_provisionheld = r0540_intrestfees_provisionheld;
	}

	public BigDecimal getR0540_intrestsuspense_provisionheld() {
		return r0540_intrestsuspense_provisionheld;
	}

	public void setR0540_intrestsuspense_provisionheld(BigDecimal r0540_intrestsuspense_provisionheld) {
		this.r0540_intrestsuspense_provisionheld = r0540_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0540_stage1_poci() {
		return r0540_stage1_poci;
	}

	public void setR0540_stage1_poci(BigDecimal r0540_stage1_poci) {
		this.r0540_stage1_poci = r0540_stage1_poci;
	}

	public BigDecimal getR0540_stage2_poci() {
		return r0540_stage2_poci;
	}

	public void setR0540_stage2_poci(BigDecimal r0540_stage2_poci) {
		this.r0540_stage2_poci = r0540_stage2_poci;
	}

	public BigDecimal getR0540_stage3a_poci() {
		return r0540_stage3a_poci;
	}

	public void setR0540_stage3a_poci(BigDecimal r0540_stage3a_poci) {
		this.r0540_stage3a_poci = r0540_stage3a_poci;
	}

	public BigDecimal getR0540_stage3b_poci() {
		return r0540_stage3b_poci;
	}

	public void setR0540_stage3b_poci(BigDecimal r0540_stage3b_poci) {
		this.r0540_stage3b_poci = r0540_stage3b_poci;
	}

	public BigDecimal getR0540_stage3c_poci() {
		return r0540_stage3c_poci;
	}

	public void setR0540_stage3c_poci(BigDecimal r0540_stage3c_poci) {
		this.r0540_stage3c_poci = r0540_stage3c_poci;
	}

	public BigDecimal getR0540_current_pastdues() {
		return r0540_current_pastdues;
	}

	public void setR0540_current_pastdues(BigDecimal r0540_current_pastdues) {
		this.r0540_current_pastdues = r0540_current_pastdues;
	}

	public BigDecimal getR0540_less30days_pastdues() {
		return r0540_less30days_pastdues;
	}

	public void setR0540_less30days_pastdues(BigDecimal r0540_less30days_pastdues) {
		this.r0540_less30days_pastdues = r0540_less30days_pastdues;
	}

	public BigDecimal getR0540_31to90days_pastdues() {
		return r0540_31to90days_pastdues;
	}

	public void setR0540_31to90days_pastdues(BigDecimal r0540_31to90days_pastdues) {
		this.r0540_31to90days_pastdues = r0540_31to90days_pastdues;
	}

	public BigDecimal getR0540_91to120days_pastdues() {
		return r0540_91to120days_pastdues;
	}

	public void setR0540_91to120days_pastdues(BigDecimal r0540_91to120days_pastdues) {
		this.r0540_91to120days_pastdues = r0540_91to120days_pastdues;
	}

	public BigDecimal getR0540_121to180days_pastdues() {
		return r0540_121to180days_pastdues;
	}

	public void setR0540_121to180days_pastdues(BigDecimal r0540_121to180days_pastdues) {
		this.r0540_121to180days_pastdues = r0540_121to180days_pastdues;
	}

	public BigDecimal getR0540_181to365days_pastdues() {
		return r0540_181to365days_pastdues;
	}

	public void setR0540_181to365days_pastdues(BigDecimal r0540_181to365days_pastdues) {
		this.r0540_181to365days_pastdues = r0540_181to365days_pastdues;
	}

	public BigDecimal getR0540_over365days_pastdues() {
		return r0540_over365days_pastdues;
	}

	public void setR0540_over365days_pastdues(BigDecimal r0540_over365days_pastdues) {
		this.r0540_over365days_pastdues = r0540_over365days_pastdues;
	}

	public BigDecimal getR0540_total_pastdues() {
		return r0540_total_pastdues;
	}

	public void setR0540_total_pastdues(BigDecimal r0540_total_pastdues) {
		this.r0540_total_pastdues = r0540_total_pastdues;
	}

	public BigDecimal getR0540_newloan_duringreport() {
		return r0540_newloan_duringreport;
	}

	public void setR0540_newloan_duringreport(BigDecimal r0540_newloan_duringreport) {
		this.r0540_newloan_duringreport = r0540_newloan_duringreport;
	}

	public BigDecimal getR0540_newstage_duringreport() {
		return r0540_newstage_duringreport;
	}

	public void setR0540_newstage_duringreport(BigDecimal r0540_newstage_duringreport) {
		this.r0540_newstage_duringreport = r0540_newstage_duringreport;
	}

	public BigDecimal getR0540_intrestfees_duringreport() {
		return r0540_intrestfees_duringreport;
	}

	public void setR0540_intrestfees_duringreport(BigDecimal r0540_intrestfees_duringreport) {
		this.r0540_intrestfees_duringreport = r0540_intrestfees_duringreport;
	}

	public BigDecimal getR0540_performingac_acinfo() {
		return r0540_performingac_acinfo;
	}

	public void setR0540_performingac_acinfo(BigDecimal r0540_performingac_acinfo) {
		this.r0540_performingac_acinfo = r0540_performingac_acinfo;
	}

	public BigDecimal getR0540_nonperformingac_acinfo() {
		return r0540_nonperformingac_acinfo;
	}

	public void setR0540_nonperformingac_acinfo(BigDecimal r0540_nonperformingac_acinfo) {
		this.r0540_nonperformingac_acinfo = r0540_nonperformingac_acinfo;
	}

	public String getR0550_product() {
		return r0550_product;
	}

	public void setR0550_product(String r0550_product) {
		this.r0550_product = r0550_product;
	}

	public BigDecimal getR0550_outstandbal() {
		return r0550_outstandbal;
	}

	public void setR0550_outstandbal(BigDecimal r0550_outstandbal) {
		this.r0550_outstandbal = r0550_outstandbal;
	}

	public BigDecimal getR0550_secured_outstandbal() {
		return r0550_secured_outstandbal;
	}

	public void setR0550_secured_outstandbal(BigDecimal r0550_secured_outstandbal) {
		this.r0550_secured_outstandbal = r0550_secured_outstandbal;
	}

	public BigDecimal getR0550_unsecured_outstandbal() {
		return r0550_unsecured_outstandbal;
	}

	public void setR0550_unsecured_outstandbal(BigDecimal r0550_unsecured_outstandbal) {
		this.r0550_unsecured_outstandbal = r0550_unsecured_outstandbal;
	}

	public BigDecimal getR0550_stage1_assetclass() {
		return r0550_stage1_assetclass;
	}

	public void setR0550_stage1_assetclass(BigDecimal r0550_stage1_assetclass) {
		this.r0550_stage1_assetclass = r0550_stage1_assetclass;
	}

	public BigDecimal getR0550_stage2_assetclass() {
		return r0550_stage2_assetclass;
	}

	public void setR0550_stage2_assetclass(BigDecimal r0550_stage2_assetclass) {
		this.r0550_stage2_assetclass = r0550_stage2_assetclass;
	}

	public BigDecimal getR0550_stage3a_assetclass() {
		return r0550_stage3a_assetclass;
	}

	public void setR0550_stage3a_assetclass(BigDecimal r0550_stage3a_assetclass) {
		this.r0550_stage3a_assetclass = r0550_stage3a_assetclass;
	}

	public BigDecimal getR0550_stage3b_assetclass() {
		return r0550_stage3b_assetclass;
	}

	public void setR0550_stage3b_assetclass(BigDecimal r0550_stage3b_assetclass) {
		this.r0550_stage3b_assetclass = r0550_stage3b_assetclass;
	}

	public BigDecimal getR0550_stage3c_assetclass() {
		return r0550_stage3c_assetclass;
	}

	public void setR0550_stage3c_assetclass(BigDecimal r0550_stage3c_assetclass) {
		this.r0550_stage3c_assetclass = r0550_stage3c_assetclass;
	}

	public BigDecimal getR0550_stage1_provisionheld() {
		return r0550_stage1_provisionheld;
	}

	public void setR0550_stage1_provisionheld(BigDecimal r0550_stage1_provisionheld) {
		this.r0550_stage1_provisionheld = r0550_stage1_provisionheld;
	}

	public BigDecimal getR0550_stage2_provisionheld() {
		return r0550_stage2_provisionheld;
	}

	public void setR0550_stage2_provisionheld(BigDecimal r0550_stage2_provisionheld) {
		this.r0550_stage2_provisionheld = r0550_stage2_provisionheld;
	}

	public BigDecimal getR0550_stage3a_provisionheld() {
		return r0550_stage3a_provisionheld;
	}

	public void setR0550_stage3a_provisionheld(BigDecimal r0550_stage3a_provisionheld) {
		this.r0550_stage3a_provisionheld = r0550_stage3a_provisionheld;
	}

	public BigDecimal getR0550_stage3b_provisionheld() {
		return r0550_stage3b_provisionheld;
	}

	public void setR0550_stage3b_provisionheld(BigDecimal r0550_stage3b_provisionheld) {
		this.r0550_stage3b_provisionheld = r0550_stage3b_provisionheld;
	}

	public BigDecimal getR0550_stage3c_provisionheld() {
		return r0550_stage3c_provisionheld;
	}

	public void setR0550_stage3c_provisionheld(BigDecimal r0550_stage3c_provisionheld) {
		this.r0550_stage3c_provisionheld = r0550_stage3c_provisionheld;
	}

	public BigDecimal getR0550_intrestfees_provisionheld() {
		return r0550_intrestfees_provisionheld;
	}

	public void setR0550_intrestfees_provisionheld(BigDecimal r0550_intrestfees_provisionheld) {
		this.r0550_intrestfees_provisionheld = r0550_intrestfees_provisionheld;
	}

	public BigDecimal getR0550_intrestsuspense_provisionheld() {
		return r0550_intrestsuspense_provisionheld;
	}

	public void setR0550_intrestsuspense_provisionheld(BigDecimal r0550_intrestsuspense_provisionheld) {
		this.r0550_intrestsuspense_provisionheld = r0550_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0550_stage1_poci() {
		return r0550_stage1_poci;
	}

	public void setR0550_stage1_poci(BigDecimal r0550_stage1_poci) {
		this.r0550_stage1_poci = r0550_stage1_poci;
	}

	public BigDecimal getR0550_stage2_poci() {
		return r0550_stage2_poci;
	}

	public void setR0550_stage2_poci(BigDecimal r0550_stage2_poci) {
		this.r0550_stage2_poci = r0550_stage2_poci;
	}

	public BigDecimal getR0550_stage3a_poci() {
		return r0550_stage3a_poci;
	}

	public void setR0550_stage3a_poci(BigDecimal r0550_stage3a_poci) {
		this.r0550_stage3a_poci = r0550_stage3a_poci;
	}

	public BigDecimal getR0550_stage3b_poci() {
		return r0550_stage3b_poci;
	}

	public void setR0550_stage3b_poci(BigDecimal r0550_stage3b_poci) {
		this.r0550_stage3b_poci = r0550_stage3b_poci;
	}

	public BigDecimal getR0550_stage3c_poci() {
		return r0550_stage3c_poci;
	}

	public void setR0550_stage3c_poci(BigDecimal r0550_stage3c_poci) {
		this.r0550_stage3c_poci = r0550_stage3c_poci;
	}

	public BigDecimal getR0550_current_pastdues() {
		return r0550_current_pastdues;
	}

	public void setR0550_current_pastdues(BigDecimal r0550_current_pastdues) {
		this.r0550_current_pastdues = r0550_current_pastdues;
	}

	public BigDecimal getR0550_less30days_pastdues() {
		return r0550_less30days_pastdues;
	}

	public void setR0550_less30days_pastdues(BigDecimal r0550_less30days_pastdues) {
		this.r0550_less30days_pastdues = r0550_less30days_pastdues;
	}

	public BigDecimal getR0550_31to90days_pastdues() {
		return r0550_31to90days_pastdues;
	}

	public void setR0550_31to90days_pastdues(BigDecimal r0550_31to90days_pastdues) {
		this.r0550_31to90days_pastdues = r0550_31to90days_pastdues;
	}

	public BigDecimal getR0550_91to120days_pastdues() {
		return r0550_91to120days_pastdues;
	}

	public void setR0550_91to120days_pastdues(BigDecimal r0550_91to120days_pastdues) {
		this.r0550_91to120days_pastdues = r0550_91to120days_pastdues;
	}

	public BigDecimal getR0550_121to180days_pastdues() {
		return r0550_121to180days_pastdues;
	}

	public void setR0550_121to180days_pastdues(BigDecimal r0550_121to180days_pastdues) {
		this.r0550_121to180days_pastdues = r0550_121to180days_pastdues;
	}

	public BigDecimal getR0550_181to365days_pastdues() {
		return r0550_181to365days_pastdues;
	}

	public void setR0550_181to365days_pastdues(BigDecimal r0550_181to365days_pastdues) {
		this.r0550_181to365days_pastdues = r0550_181to365days_pastdues;
	}

	public BigDecimal getR0550_over365days_pastdues() {
		return r0550_over365days_pastdues;
	}

	public void setR0550_over365days_pastdues(BigDecimal r0550_over365days_pastdues) {
		this.r0550_over365days_pastdues = r0550_over365days_pastdues;
	}

	public BigDecimal getR0550_total_pastdues() {
		return r0550_total_pastdues;
	}

	public void setR0550_total_pastdues(BigDecimal r0550_total_pastdues) {
		this.r0550_total_pastdues = r0550_total_pastdues;
	}

	public BigDecimal getR0550_newloan_duringreport() {
		return r0550_newloan_duringreport;
	}

	public void setR0550_newloan_duringreport(BigDecimal r0550_newloan_duringreport) {
		this.r0550_newloan_duringreport = r0550_newloan_duringreport;
	}

	public BigDecimal getR0550_newstage_duringreport() {
		return r0550_newstage_duringreport;
	}

	public void setR0550_newstage_duringreport(BigDecimal r0550_newstage_duringreport) {
		this.r0550_newstage_duringreport = r0550_newstage_duringreport;
	}

	public BigDecimal getR0550_intrestfees_duringreport() {
		return r0550_intrestfees_duringreport;
	}

	public void setR0550_intrestfees_duringreport(BigDecimal r0550_intrestfees_duringreport) {
		this.r0550_intrestfees_duringreport = r0550_intrestfees_duringreport;
	}

	public BigDecimal getR0550_performingac_acinfo() {
		return r0550_performingac_acinfo;
	}

	public void setR0550_performingac_acinfo(BigDecimal r0550_performingac_acinfo) {
		this.r0550_performingac_acinfo = r0550_performingac_acinfo;
	}

	public BigDecimal getR0550_nonperformingac_acinfo() {
		return r0550_nonperformingac_acinfo;
	}

	public void setR0550_nonperformingac_acinfo(BigDecimal r0550_nonperformingac_acinfo) {
		this.r0550_nonperformingac_acinfo = r0550_nonperformingac_acinfo;
	}

	public String getR0560_product() {
		return r0560_product;
	}

	public void setR0560_product(String r0560_product) {
		this.r0560_product = r0560_product;
	}

	public BigDecimal getR0560_outstandbal() {
		return r0560_outstandbal;
	}

	public void setR0560_outstandbal(BigDecimal r0560_outstandbal) {
		this.r0560_outstandbal = r0560_outstandbal;
	}

	public BigDecimal getR0560_secured_outstandbal() {
		return r0560_secured_outstandbal;
	}

	public void setR0560_secured_outstandbal(BigDecimal r0560_secured_outstandbal) {
		this.r0560_secured_outstandbal = r0560_secured_outstandbal;
	}

	public BigDecimal getR0560_unsecured_outstandbal() {
		return r0560_unsecured_outstandbal;
	}

	public void setR0560_unsecured_outstandbal(BigDecimal r0560_unsecured_outstandbal) {
		this.r0560_unsecured_outstandbal = r0560_unsecured_outstandbal;
	}

	public BigDecimal getR0560_stage1_assetclass() {
		return r0560_stage1_assetclass;
	}

	public void setR0560_stage1_assetclass(BigDecimal r0560_stage1_assetclass) {
		this.r0560_stage1_assetclass = r0560_stage1_assetclass;
	}

	public BigDecimal getR0560_stage2_assetclass() {
		return r0560_stage2_assetclass;
	}

	public void setR0560_stage2_assetclass(BigDecimal r0560_stage2_assetclass) {
		this.r0560_stage2_assetclass = r0560_stage2_assetclass;
	}

	public BigDecimal getR0560_stage3a_assetclass() {
		return r0560_stage3a_assetclass;
	}

	public void setR0560_stage3a_assetclass(BigDecimal r0560_stage3a_assetclass) {
		this.r0560_stage3a_assetclass = r0560_stage3a_assetclass;
	}

	public BigDecimal getR0560_stage3b_assetclass() {
		return r0560_stage3b_assetclass;
	}

	public void setR0560_stage3b_assetclass(BigDecimal r0560_stage3b_assetclass) {
		this.r0560_stage3b_assetclass = r0560_stage3b_assetclass;
	}

	public BigDecimal getR0560_stage3c_assetclass() {
		return r0560_stage3c_assetclass;
	}

	public void setR0560_stage3c_assetclass(BigDecimal r0560_stage3c_assetclass) {
		this.r0560_stage3c_assetclass = r0560_stage3c_assetclass;
	}

	public BigDecimal getR0560_stage1_provisionheld() {
		return r0560_stage1_provisionheld;
	}

	public void setR0560_stage1_provisionheld(BigDecimal r0560_stage1_provisionheld) {
		this.r0560_stage1_provisionheld = r0560_stage1_provisionheld;
	}

	public BigDecimal getR0560_stage2_provisionheld() {
		return r0560_stage2_provisionheld;
	}

	public void setR0560_stage2_provisionheld(BigDecimal r0560_stage2_provisionheld) {
		this.r0560_stage2_provisionheld = r0560_stage2_provisionheld;
	}

	public BigDecimal getR0560_stage3a_provisionheld() {
		return r0560_stage3a_provisionheld;
	}

	public void setR0560_stage3a_provisionheld(BigDecimal r0560_stage3a_provisionheld) {
		this.r0560_stage3a_provisionheld = r0560_stage3a_provisionheld;
	}

	public BigDecimal getR0560_stage3b_provisionheld() {
		return r0560_stage3b_provisionheld;
	}

	public void setR0560_stage3b_provisionheld(BigDecimal r0560_stage3b_provisionheld) {
		this.r0560_stage3b_provisionheld = r0560_stage3b_provisionheld;
	}

	public BigDecimal getR0560_stage3c_provisionheld() {
		return r0560_stage3c_provisionheld;
	}

	public void setR0560_stage3c_provisionheld(BigDecimal r0560_stage3c_provisionheld) {
		this.r0560_stage3c_provisionheld = r0560_stage3c_provisionheld;
	}

	public BigDecimal getR0560_intrestfees_provisionheld() {
		return r0560_intrestfees_provisionheld;
	}

	public void setR0560_intrestfees_provisionheld(BigDecimal r0560_intrestfees_provisionheld) {
		this.r0560_intrestfees_provisionheld = r0560_intrestfees_provisionheld;
	}

	public BigDecimal getR0560_intrestsuspense_provisionheld() {
		return r0560_intrestsuspense_provisionheld;
	}

	public void setR0560_intrestsuspense_provisionheld(BigDecimal r0560_intrestsuspense_provisionheld) {
		this.r0560_intrestsuspense_provisionheld = r0560_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0560_stage1_poci() {
		return r0560_stage1_poci;
	}

	public void setR0560_stage1_poci(BigDecimal r0560_stage1_poci) {
		this.r0560_stage1_poci = r0560_stage1_poci;
	}

	public BigDecimal getR0560_stage2_poci() {
		return r0560_stage2_poci;
	}

	public void setR0560_stage2_poci(BigDecimal r0560_stage2_poci) {
		this.r0560_stage2_poci = r0560_stage2_poci;
	}

	public BigDecimal getR0560_stage3a_poci() {
		return r0560_stage3a_poci;
	}

	public void setR0560_stage3a_poci(BigDecimal r0560_stage3a_poci) {
		this.r0560_stage3a_poci = r0560_stage3a_poci;
	}

	public BigDecimal getR0560_stage3b_poci() {
		return r0560_stage3b_poci;
	}

	public void setR0560_stage3b_poci(BigDecimal r0560_stage3b_poci) {
		this.r0560_stage3b_poci = r0560_stage3b_poci;
	}

	public BigDecimal getR0560_stage3c_poci() {
		return r0560_stage3c_poci;
	}

	public void setR0560_stage3c_poci(BigDecimal r0560_stage3c_poci) {
		this.r0560_stage3c_poci = r0560_stage3c_poci;
	}

	public BigDecimal getR0560_current_pastdues() {
		return r0560_current_pastdues;
	}

	public void setR0560_current_pastdues(BigDecimal r0560_current_pastdues) {
		this.r0560_current_pastdues = r0560_current_pastdues;
	}

	public BigDecimal getR0560_less30days_pastdues() {
		return r0560_less30days_pastdues;
	}

	public void setR0560_less30days_pastdues(BigDecimal r0560_less30days_pastdues) {
		this.r0560_less30days_pastdues = r0560_less30days_pastdues;
	}

	public BigDecimal getR0560_31to90days_pastdues() {
		return r0560_31to90days_pastdues;
	}

	public void setR0560_31to90days_pastdues(BigDecimal r0560_31to90days_pastdues) {
		this.r0560_31to90days_pastdues = r0560_31to90days_pastdues;
	}

	public BigDecimal getR0560_91to120days_pastdues() {
		return r0560_91to120days_pastdues;
	}

	public void setR0560_91to120days_pastdues(BigDecimal r0560_91to120days_pastdues) {
		this.r0560_91to120days_pastdues = r0560_91to120days_pastdues;
	}

	public BigDecimal getR0560_121to180days_pastdues() {
		return r0560_121to180days_pastdues;
	}

	public void setR0560_121to180days_pastdues(BigDecimal r0560_121to180days_pastdues) {
		this.r0560_121to180days_pastdues = r0560_121to180days_pastdues;
	}

	public BigDecimal getR0560_181to365days_pastdues() {
		return r0560_181to365days_pastdues;
	}

	public void setR0560_181to365days_pastdues(BigDecimal r0560_181to365days_pastdues) {
		this.r0560_181to365days_pastdues = r0560_181to365days_pastdues;
	}

	public BigDecimal getR0560_over365days_pastdues() {
		return r0560_over365days_pastdues;
	}

	public void setR0560_over365days_pastdues(BigDecimal r0560_over365days_pastdues) {
		this.r0560_over365days_pastdues = r0560_over365days_pastdues;
	}

	public BigDecimal getR0560_total_pastdues() {
		return r0560_total_pastdues;
	}

	public void setR0560_total_pastdues(BigDecimal r0560_total_pastdues) {
		this.r0560_total_pastdues = r0560_total_pastdues;
	}

	public BigDecimal getR0560_newloan_duringreport() {
		return r0560_newloan_duringreport;
	}

	public void setR0560_newloan_duringreport(BigDecimal r0560_newloan_duringreport) {
		this.r0560_newloan_duringreport = r0560_newloan_duringreport;
	}

	public BigDecimal getR0560_newstage_duringreport() {
		return r0560_newstage_duringreport;
	}

	public void setR0560_newstage_duringreport(BigDecimal r0560_newstage_duringreport) {
		this.r0560_newstage_duringreport = r0560_newstage_duringreport;
	}

	public BigDecimal getR0560_intrestfees_duringreport() {
		return r0560_intrestfees_duringreport;
	}

	public void setR0560_intrestfees_duringreport(BigDecimal r0560_intrestfees_duringreport) {
		this.r0560_intrestfees_duringreport = r0560_intrestfees_duringreport;
	}

	public BigDecimal getR0560_performingac_acinfo() {
		return r0560_performingac_acinfo;
	}

	public void setR0560_performingac_acinfo(BigDecimal r0560_performingac_acinfo) {
		this.r0560_performingac_acinfo = r0560_performingac_acinfo;
	}

	public BigDecimal getR0560_nonperformingac_acinfo() {
		return r0560_nonperformingac_acinfo;
	}

	public void setR0560_nonperformingac_acinfo(BigDecimal r0560_nonperformingac_acinfo) {
		this.r0560_nonperformingac_acinfo = r0560_nonperformingac_acinfo;
	}

	public String getR0570_product() {
		return r0570_product;
	}

	public void setR0570_product(String r0570_product) {
		this.r0570_product = r0570_product;
	}

	public BigDecimal getR0570_outstandbal() {
		return r0570_outstandbal;
	}

	public void setR0570_outstandbal(BigDecimal r0570_outstandbal) {
		this.r0570_outstandbal = r0570_outstandbal;
	}

	public BigDecimal getR0570_secured_outstandbal() {
		return r0570_secured_outstandbal;
	}

	public void setR0570_secured_outstandbal(BigDecimal r0570_secured_outstandbal) {
		this.r0570_secured_outstandbal = r0570_secured_outstandbal;
	}

	public BigDecimal getR0570_unsecured_outstandbal() {
		return r0570_unsecured_outstandbal;
	}

	public void setR0570_unsecured_outstandbal(BigDecimal r0570_unsecured_outstandbal) {
		this.r0570_unsecured_outstandbal = r0570_unsecured_outstandbal;
	}

	public BigDecimal getR0570_stage1_assetclass() {
		return r0570_stage1_assetclass;
	}

	public void setR0570_stage1_assetclass(BigDecimal r0570_stage1_assetclass) {
		this.r0570_stage1_assetclass = r0570_stage1_assetclass;
	}

	public BigDecimal getR0570_stage2_assetclass() {
		return r0570_stage2_assetclass;
	}

	public void setR0570_stage2_assetclass(BigDecimal r0570_stage2_assetclass) {
		this.r0570_stage2_assetclass = r0570_stage2_assetclass;
	}

	public BigDecimal getR0570_stage3a_assetclass() {
		return r0570_stage3a_assetclass;
	}

	public void setR0570_stage3a_assetclass(BigDecimal r0570_stage3a_assetclass) {
		this.r0570_stage3a_assetclass = r0570_stage3a_assetclass;
	}

	public BigDecimal getR0570_stage3b_assetclass() {
		return r0570_stage3b_assetclass;
	}

	public void setR0570_stage3b_assetclass(BigDecimal r0570_stage3b_assetclass) {
		this.r0570_stage3b_assetclass = r0570_stage3b_assetclass;
	}

	public BigDecimal getR0570_stage3c_assetclass() {
		return r0570_stage3c_assetclass;
	}

	public void setR0570_stage3c_assetclass(BigDecimal r0570_stage3c_assetclass) {
		this.r0570_stage3c_assetclass = r0570_stage3c_assetclass;
	}

	public BigDecimal getR0570_stage1_provisionheld() {
		return r0570_stage1_provisionheld;
	}

	public void setR0570_stage1_provisionheld(BigDecimal r0570_stage1_provisionheld) {
		this.r0570_stage1_provisionheld = r0570_stage1_provisionheld;
	}

	public BigDecimal getR0570_stage2_provisionheld() {
		return r0570_stage2_provisionheld;
	}

	public void setR0570_stage2_provisionheld(BigDecimal r0570_stage2_provisionheld) {
		this.r0570_stage2_provisionheld = r0570_stage2_provisionheld;
	}

	public BigDecimal getR0570_stage3a_provisionheld() {
		return r0570_stage3a_provisionheld;
	}

	public void setR0570_stage3a_provisionheld(BigDecimal r0570_stage3a_provisionheld) {
		this.r0570_stage3a_provisionheld = r0570_stage3a_provisionheld;
	}

	public BigDecimal getR0570_stage3b_provisionheld() {
		return r0570_stage3b_provisionheld;
	}

	public void setR0570_stage3b_provisionheld(BigDecimal r0570_stage3b_provisionheld) {
		this.r0570_stage3b_provisionheld = r0570_stage3b_provisionheld;
	}

	public BigDecimal getR0570_stage3c_provisionheld() {
		return r0570_stage3c_provisionheld;
	}

	public void setR0570_stage3c_provisionheld(BigDecimal r0570_stage3c_provisionheld) {
		this.r0570_stage3c_provisionheld = r0570_stage3c_provisionheld;
	}

	public BigDecimal getR0570_intrestfees_provisionheld() {
		return r0570_intrestfees_provisionheld;
	}

	public void setR0570_intrestfees_provisionheld(BigDecimal r0570_intrestfees_provisionheld) {
		this.r0570_intrestfees_provisionheld = r0570_intrestfees_provisionheld;
	}

	public BigDecimal getR0570_intrestsuspense_provisionheld() {
		return r0570_intrestsuspense_provisionheld;
	}

	public void setR0570_intrestsuspense_provisionheld(BigDecimal r0570_intrestsuspense_provisionheld) {
		this.r0570_intrestsuspense_provisionheld = r0570_intrestsuspense_provisionheld;
	}

	public BigDecimal getR0570_stage1_poci() {
		return r0570_stage1_poci;
	}

	public void setR0570_stage1_poci(BigDecimal r0570_stage1_poci) {
		this.r0570_stage1_poci = r0570_stage1_poci;
	}

	public BigDecimal getR0570_stage2_poci() {
		return r0570_stage2_poci;
	}

	public void setR0570_stage2_poci(BigDecimal r0570_stage2_poci) {
		this.r0570_stage2_poci = r0570_stage2_poci;
	}

	public BigDecimal getR0570_stage3a_poci() {
		return r0570_stage3a_poci;
	}

	public void setR0570_stage3a_poci(BigDecimal r0570_stage3a_poci) {
		this.r0570_stage3a_poci = r0570_stage3a_poci;
	}

	public BigDecimal getR0570_stage3b_poci() {
		return r0570_stage3b_poci;
	}

	public void setR0570_stage3b_poci(BigDecimal r0570_stage3b_poci) {
		this.r0570_stage3b_poci = r0570_stage3b_poci;
	}

	public BigDecimal getR0570_stage3c_poci() {
		return r0570_stage3c_poci;
	}

	public void setR0570_stage3c_poci(BigDecimal r0570_stage3c_poci) {
		this.r0570_stage3c_poci = r0570_stage3c_poci;
	}

	public BigDecimal getR0570_current_pastdues() {
		return r0570_current_pastdues;
	}

	public void setR0570_current_pastdues(BigDecimal r0570_current_pastdues) {
		this.r0570_current_pastdues = r0570_current_pastdues;
	}

	public BigDecimal getR0570_less30days_pastdues() {
		return r0570_less30days_pastdues;
	}

	public void setR0570_less30days_pastdues(BigDecimal r0570_less30days_pastdues) {
		this.r0570_less30days_pastdues = r0570_less30days_pastdues;
	}

	public BigDecimal getR0570_31to90days_pastdues() {
		return r0570_31to90days_pastdues;
	}

	public void setR0570_31to90days_pastdues(BigDecimal r0570_31to90days_pastdues) {
		this.r0570_31to90days_pastdues = r0570_31to90days_pastdues;
	}

	public BigDecimal getR0570_91to120days_pastdues() {
		return r0570_91to120days_pastdues;
	}

	public void setR0570_91to120days_pastdues(BigDecimal r0570_91to120days_pastdues) {
		this.r0570_91to120days_pastdues = r0570_91to120days_pastdues;
	}

	public BigDecimal getR0570_121to180days_pastdues() {
		return r0570_121to180days_pastdues;
	}

	public void setR0570_121to180days_pastdues(BigDecimal r0570_121to180days_pastdues) {
		this.r0570_121to180days_pastdues = r0570_121to180days_pastdues;
	}

	public BigDecimal getR0570_181to365days_pastdues() {
		return r0570_181to365days_pastdues;
	}

	public void setR0570_181to365days_pastdues(BigDecimal r0570_181to365days_pastdues) {
		this.r0570_181to365days_pastdues = r0570_181to365days_pastdues;
	}

	public BigDecimal getR0570_over365days_pastdues() {
		return r0570_over365days_pastdues;
	}

	public void setR0570_over365days_pastdues(BigDecimal r0570_over365days_pastdues) {
		this.r0570_over365days_pastdues = r0570_over365days_pastdues;
	}

	public BigDecimal getR0570_total_pastdues() {
		return r0570_total_pastdues;
	}

	public void setR0570_total_pastdues(BigDecimal r0570_total_pastdues) {
		this.r0570_total_pastdues = r0570_total_pastdues;
	}

	public BigDecimal getR0570_newloan_duringreport() {
		return r0570_newloan_duringreport;
	}

	public void setR0570_newloan_duringreport(BigDecimal r0570_newloan_duringreport) {
		this.r0570_newloan_duringreport = r0570_newloan_duringreport;
	}

	public BigDecimal getR0570_newstage_duringreport() {
		return r0570_newstage_duringreport;
	}

	public void setR0570_newstage_duringreport(BigDecimal r0570_newstage_duringreport) {
		this.r0570_newstage_duringreport = r0570_newstage_duringreport;
	}

	public BigDecimal getR0570_intrestfees_duringreport() {
		return r0570_intrestfees_duringreport;
	}

	public void setR0570_intrestfees_duringreport(BigDecimal r0570_intrestfees_duringreport) {
		this.r0570_intrestfees_duringreport = r0570_intrestfees_duringreport;
	}

	public BigDecimal getR0570_performingac_acinfo() {
		return r0570_performingac_acinfo;
	}

	public void setR0570_performingac_acinfo(BigDecimal r0570_performingac_acinfo) {
		this.r0570_performingac_acinfo = r0570_performingac_acinfo;
	}

	public BigDecimal getR0570_nonperformingac_acinfo() {
		return r0570_nonperformingac_acinfo;
	}

	public void setR0570_nonperformingac_acinfo(BigDecimal r0570_nonperformingac_acinfo) {
		this.r0570_nonperformingac_acinfo = r0570_nonperformingac_acinfo;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getReport_version() {
		return report_version;
	}

	public void setReport_version(String report_version) {
		this.report_version = report_version;
	}

	public String getReport_frequency() {
		return report_frequency;
	}

	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public String getReport_desc() {
		return report_desc;
	}

	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public String getDelete_flg() {
		return delete_flg;
	}

	public void setDelete_flg(String delete_flg) {
		this.delete_flg = delete_flg;
	}

	public CBUAE_BRF5_3_Summary_Archival_Entity2() {
		super();
		// TODO Auto-generated constructor stub
	}

}
