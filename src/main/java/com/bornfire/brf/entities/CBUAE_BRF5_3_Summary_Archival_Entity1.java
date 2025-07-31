
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
	@Table(name = "CBUAE_BRF5_3_ARCHIVALTABLE_SUMMARY1")

	public class CBUAE_BRF5_3_Summary_Archival_Entity1 {

		private String	r0010_product;
		private BigDecimal	r0010_outstandbal;
		private BigDecimal	r0010_secured_outstandbal;
		private BigDecimal	r0010_unsecured_outstandbal;
		private BigDecimal	r0010_stage1_assetclass;
		private BigDecimal	r0010_stage2_assetclass;
		private BigDecimal	r0010_stage3a_assetclass;
		private BigDecimal	r0010_stage3b_assetclass;
		private BigDecimal	r0010_stage3c_assetclass;
		private BigDecimal	r0010_stage1_provisionheld;
		private BigDecimal	r0010_stage2_provisionheld;
		private BigDecimal	r0010_stage3a_provisionheld;
		private BigDecimal	r0010_stage3b_provisionheld;
		private BigDecimal	r0010_stage3c_provisionheld;
		private BigDecimal	r0010_intrestfees_provisionheld;
		private BigDecimal	r0010_intrestsuspense_provisionheld;
		private BigDecimal	r0010_stage1_poci;
		private BigDecimal	r0010_stage2_poci;
		private BigDecimal	r0010_stage3a_poci;
		private BigDecimal	r0010_stage3b_poci;
		private BigDecimal	r0010_stage3c_poci;
		private BigDecimal	r0010_current_pastdues;
		private BigDecimal	r0010_less30days_pastdues;
		private BigDecimal	r0010_31to90days_pastdues;
		private BigDecimal	r0010_91to120days_pastdues;
		private BigDecimal	r0010_121to180days_pastdues;
		private BigDecimal	r0010_181to365days_pastdues;
		private BigDecimal	r0010_over365days_pastdues;
		private BigDecimal	r0010_total_pastdues;
		private BigDecimal	r0010_newloan_duringreport;
		private BigDecimal	r0010_newstage_duringreport;
		private BigDecimal	r0010_intrestfees_duringreport;
		private BigDecimal	r0010_performingac_acinfo;
		private BigDecimal	r0010_nonperformingac_acinfo;
		private String	r0020_product;
		private BigDecimal	r0020_outstandbal;
		private BigDecimal	r0020_secured_outstandbal;
		private BigDecimal	r0020_unsecured_outstandbal;
		private BigDecimal	r0020_stage1_assetclass;
		private BigDecimal	r0020_stage2_assetclass;
		private BigDecimal	r0020_stage3a_assetclass;
		private BigDecimal	r0020_stage3b_assetclass;
		private BigDecimal	r0020_stage3c_assetclass;
		private BigDecimal	r0020_stage1_provisionheld;
		private BigDecimal	r0020_stage2_provisionheld;
		private BigDecimal	r0020_stage3a_provisionheld;
		private BigDecimal	r0020_stage3b_provisionheld;
		private BigDecimal	r0020_stage3c_provisionheld;
		private BigDecimal	r0020_intrestfees_provisionheld;
		private BigDecimal	r0020_intrestsuspense_provisionheld;
		private BigDecimal	r0020_stage1_poci;
		private BigDecimal	r0020_stage2_poci;
		private BigDecimal	r0020_stage3a_poci;
		private BigDecimal	r0020_stage3b_poci;
		private BigDecimal	r0020_stage3c_poci;
		private BigDecimal	r0020_current_pastdues;
		private BigDecimal	r0020_less30days_pastdues;
		private BigDecimal	r0020_31to90days_pastdues;
		private BigDecimal	r0020_91to120days_pastdues;
		private BigDecimal	r0020_121to180days_pastdues;
		private BigDecimal	r0020_181to365days_pastdues;
		private BigDecimal	r0020_over365days_pastdues;
		private BigDecimal	r0020_total_pastdues;
		private BigDecimal	r0020_newloan_duringreport;
		private BigDecimal	r0020_newstage_duringreport;
		private BigDecimal	r0020_intrestfees_duringreport;
		private BigDecimal	r0020_performingac_acinfo;
		private BigDecimal	r0020_nonperformingac_acinfo;
		private String	r0030_product;
		private BigDecimal	r0030_outstandbal;
		private BigDecimal	r0030_secured_outstandbal;
		private BigDecimal	r0030_unsecured_outstandbal;
		private BigDecimal	r0030_stage1_assetclass;
		private BigDecimal	r0030_stage2_assetclass;
		private BigDecimal	r0030_stage3a_assetclass;
		private BigDecimal	r0030_stage3b_assetclass;
		private BigDecimal	r0030_stage3c_assetclass;
		private BigDecimal	r0030_stage1_provisionheld;
		private BigDecimal	r0030_stage2_provisionheld;
		private BigDecimal	r0030_stage3a_provisionheld;
		private BigDecimal	r0030_stage3b_provisionheld;
		private BigDecimal	r0030_stage3c_provisionheld;
		private BigDecimal	r0030_intrestfees_provisionheld;
		private BigDecimal	r0030_intrestsuspense_provisionheld;
		private BigDecimal	r0030_stage1_poci;
		private BigDecimal	r0030_stage2_poci;
		private BigDecimal	r0030_stage3a_poci;
		private BigDecimal	r0030_stage3b_poci;
		private BigDecimal	r0030_stage3c_poci;
		private BigDecimal	r0030_current_pastdues;
		private BigDecimal	r0030_less30days_pastdues;
		private BigDecimal	r0030_31to90days_pastdues;
		private BigDecimal	r0030_91to120days_pastdues;
		private BigDecimal	r0030_121to180days_pastdues;
		private BigDecimal	r0030_181to365days_pastdues;
		private BigDecimal	r0030_over365days_pastdues;
		private BigDecimal	r0030_total_pastdues;
		private BigDecimal	r0030_newloan_duringreport;
		private BigDecimal	r0030_newstage_duringreport;
		private BigDecimal	r0030_intrestfees_duringreport;
		private BigDecimal	r0030_performingac_acinfo;
		private BigDecimal	r0030_nonperformingac_acinfo;
		private String	r0040_product;
		private BigDecimal	r0040_outstandbal;
		private BigDecimal	r0040_secured_outstandbal;
		private BigDecimal	r0040_unsecured_outstandbal;
		private BigDecimal	r0040_stage1_assetclass;
		private BigDecimal	r0040_stage2_assetclass;
		private BigDecimal	r0040_stage3a_assetclass;
		private BigDecimal	r0040_stage3b_assetclass;
		private BigDecimal	r0040_stage3c_assetclass;
		private BigDecimal	r0040_stage1_provisionheld;
		private BigDecimal	r0040_stage2_provisionheld;
		private BigDecimal	r0040_stage3a_provisionheld;
		private BigDecimal	r0040_stage3b_provisionheld;
		private BigDecimal	r0040_stage3c_provisionheld;
		private BigDecimal	r0040_intrestfees_provisionheld;
		private BigDecimal	r0040_intrestsuspense_provisionheld;
		private BigDecimal	r0040_stage1_poci;
		private BigDecimal	r0040_stage2_poci;
		private BigDecimal	r0040_stage3a_poci;
		private BigDecimal	r0040_stage3b_poci;
		private BigDecimal	r0040_stage3c_poci;
		private BigDecimal	r0040_current_pastdues;
		private BigDecimal	r0040_less30days_pastdues;
		private BigDecimal	r0040_31to90days_pastdues;
		private BigDecimal	r0040_91to120days_pastdues;
		private BigDecimal	r0040_121to180days_pastdues;
		private BigDecimal	r0040_181to365days_pastdues;
		private BigDecimal	r0040_over365days_pastdues;
		private BigDecimal	r0040_total_pastdues;
		private BigDecimal	r0040_newloan_duringreport;
		private BigDecimal	r0040_newstage_duringreport;
		private BigDecimal	r0040_intrestfees_duringreport;
		private BigDecimal	r0040_performingac_acinfo;
		private BigDecimal	r0040_nonperformingac_acinfo;
		private String	r0050_product;
		private BigDecimal	r0050_outstandbal;
		private BigDecimal	r0050_secured_outstandbal;
		private BigDecimal	r0050_unsecured_outstandbal;
		private BigDecimal	r0050_stage1_assetclass;
		private BigDecimal	r0050_stage2_assetclass;
		private BigDecimal	r0050_stage3a_assetclass;
		private BigDecimal	r0050_stage3b_assetclass;
		private BigDecimal	r0050_stage3c_assetclass;
		private BigDecimal	r0050_stage1_provisionheld;
		private BigDecimal	r0050_stage2_provisionheld;
		private BigDecimal	r0050_stage3a_provisionheld;
		private BigDecimal	r0050_stage3b_provisionheld;
		private BigDecimal	r0050_stage3c_provisionheld;
		private BigDecimal	r0050_intrestfees_provisionheld;
		private BigDecimal	r0050_intrestsuspense_provisionheld;
		private BigDecimal	r0050_stage1_poci;
		private BigDecimal	r0050_stage2_poci;
		private BigDecimal	r0050_stage3a_poci;
		private BigDecimal	r0050_stage3b_poci;
		private BigDecimal	r0050_stage3c_poci;
		private BigDecimal	r0050_current_pastdues;
		private BigDecimal	r0050_less30days_pastdues;
		private BigDecimal	r0050_31to90days_pastdues;
		private BigDecimal	r0050_91to120days_pastdues;
		private BigDecimal	r0050_121to180days_pastdues;
		private BigDecimal	r0050_181to365days_pastdues;
		private BigDecimal	r0050_over365days_pastdues;
		private BigDecimal	r0050_total_pastdues;
		private BigDecimal	r0050_newloan_duringreport;
		private BigDecimal	r0050_newstage_duringreport;
		private BigDecimal	r0050_intrestfees_duringreport;
		private BigDecimal	r0050_performingac_acinfo;
		private BigDecimal	r0050_nonperformingac_acinfo;
		private String	r0060_product;
		private BigDecimal	r0060_outstandbal;
		private BigDecimal	r0060_secured_outstandbal;
		private BigDecimal	r0060_unsecured_outstandbal;
		private BigDecimal	r0060_stage1_assetclass;
		private BigDecimal	r0060_stage2_assetclass;
		private BigDecimal	r0060_stage3a_assetclass;
		private BigDecimal	r0060_stage3b_assetclass;
		private BigDecimal	r0060_stage3c_assetclass;
		private BigDecimal	r0060_stage1_provisionheld;
		private BigDecimal	r0060_stage2_provisionheld;
		private BigDecimal	r0060_stage3a_provisionheld;
		private BigDecimal	r0060_stage3b_provisionheld;
		private BigDecimal	r0060_stage3c_provisionheld;
		private BigDecimal	r0060_intrestfees_provisionheld;
		private BigDecimal	r0060_intrestsuspense_provisionheld;
		private BigDecimal	r0060_stage1_poci;
		private BigDecimal	r0060_stage2_poci;
		private BigDecimal	r0060_stage3a_poci;
		private BigDecimal	r0060_stage3b_poci;
		private BigDecimal	r0060_stage3c_poci;
		private BigDecimal	r0060_current_pastdues;
		private BigDecimal	r0060_less30days_pastdues;
		private BigDecimal	r0060_31to90days_pastdues;
		private BigDecimal	r0060_91to120days_pastdues;
		private BigDecimal	r0060_121to180days_pastdues;
		private BigDecimal	r0060_181to365days_pastdues;
		private BigDecimal	r0060_over365days_pastdues;
		private BigDecimal	r0060_total_pastdues;
		private BigDecimal	r0060_newloan_duringreport;
		private BigDecimal	r0060_newstage_duringreport;
		private BigDecimal	r0060_intrestfees_duringreport;
		private BigDecimal	r0060_performingac_acinfo;
		private BigDecimal	r0060_nonperformingac_acinfo;
		private String	r0070_product;
		private BigDecimal	r0070_outstandbal;
		private BigDecimal	r0070_secured_outstandbal;
		private BigDecimal	r0070_unsecured_outstandbal;
		private BigDecimal	r0070_stage1_assetclass;
		private BigDecimal	r0070_stage2_assetclass;
		private BigDecimal	r0070_stage3a_assetclass;
		private BigDecimal	r0070_stage3b_assetclass;
		private BigDecimal	r0070_stage3c_assetclass;
		private BigDecimal	r0070_stage1_provisionheld;
		private BigDecimal	r0070_stage2_provisionheld;
		private BigDecimal	r0070_stage3a_provisionheld;
		private BigDecimal	r0070_stage3b_provisionheld;
		private BigDecimal	r0070_stage3c_provisionheld;
		private BigDecimal	r0070_intrestfees_provisionheld;
		private BigDecimal	r0070_intrestsuspense_provisionheld;
		private BigDecimal	r0070_stage1_poci;
		private BigDecimal	r0070_stage2_poci;
		private BigDecimal	r0070_stage3a_poci;
		private BigDecimal	r0070_stage3b_poci;
		private BigDecimal	r0070_stage3c_poci;
		private BigDecimal	r0070_current_pastdues;
		private BigDecimal	r0070_less30days_pastdues;
		private BigDecimal	r0070_31to90days_pastdues;
		private BigDecimal	r0070_91to120days_pastdues;
		private BigDecimal	r0070_121to180days_pastdues;
		private BigDecimal	r0070_181to365days_pastdues;
		private BigDecimal	r0070_over365days_pastdues;
		private BigDecimal	r0070_total_pastdues;
		private BigDecimal	r0070_newloan_duringreport;
		private BigDecimal	r0070_newstage_duringreport;
		private BigDecimal	r0070_intrestfees_duringreport;
		private BigDecimal	r0070_performingac_acinfo;
		private BigDecimal	r0070_nonperformingac_acinfo;
		private String	r0080_product;
		private BigDecimal	r0080_outstandbal;
		private BigDecimal	r0080_secured_outstandbal;
		private BigDecimal	r0080_unsecured_outstandbal;
		private BigDecimal	r0080_stage1_assetclass;
		private BigDecimal	r0080_stage2_assetclass;
		private BigDecimal	r0080_stage3a_assetclass;
		private BigDecimal	r0080_stage3b_assetclass;
		private BigDecimal	r0080_stage3c_assetclass;
		private BigDecimal	r0080_stage1_provisionheld;
		private BigDecimal	r0080_stage2_provisionheld;
		private BigDecimal	r0080_stage3a_provisionheld;
		private BigDecimal	r0080_stage3b_provisionheld;
		private BigDecimal	r0080_stage3c_provisionheld;
		private BigDecimal	r0080_intrestfees_provisionheld;
		private BigDecimal	r0080_intrestsuspense_provisionheld;
		private BigDecimal	r0080_stage1_poci;
		private BigDecimal	r0080_stage2_poci;
		private BigDecimal	r0080_stage3a_poci;
		private BigDecimal	r0080_stage3b_poci;
		private BigDecimal	r0080_stage3c_poci;
		private BigDecimal	r0080_current_pastdues;
		private BigDecimal	r0080_less30days_pastdues;
		private BigDecimal	r0080_31to90days_pastdues;
		private BigDecimal	r0080_91to120days_pastdues;
		private BigDecimal	r0080_121to180days_pastdues;
		private BigDecimal	r0080_181to365days_pastdues;
		private BigDecimal	r0080_over365days_pastdues;
		private BigDecimal	r0080_total_pastdues;
		private BigDecimal	r0080_newloan_duringreport;
		private BigDecimal	r0080_newstage_duringreport;
		private BigDecimal	r0080_intrestfees_duringreport;
		private BigDecimal	r0080_performingac_acinfo;
		private BigDecimal	r0080_nonperformingac_acinfo;
		private String	r0090_product;
		private BigDecimal	r0090_outstandbal;
		private BigDecimal	r0090_secured_outstandbal;
		private BigDecimal	r0090_unsecured_outstandbal;
		private BigDecimal	r0090_stage1_assetclass;
		private BigDecimal	r0090_stage2_assetclass;
		private BigDecimal	r0090_stage3a_assetclass;
		private BigDecimal	r0090_stage3b_assetclass;
		private BigDecimal	r0090_stage3c_assetclass;
		private BigDecimal	r0090_stage1_provisionheld;
		private BigDecimal	r0090_stage2_provisionheld;
		private BigDecimal	r0090_stage3a_provisionheld;
		private BigDecimal	r0090_stage3b_provisionheld;
		private BigDecimal	r0090_stage3c_provisionheld;
		private BigDecimal	r0090_intrestfees_provisionheld;
		private BigDecimal	r0090_intrestsuspense_provisionheld;
		private BigDecimal	r0090_stage1_poci;
		private BigDecimal	r0090_stage2_poci;
		private BigDecimal	r0090_stage3a_poci;
		private BigDecimal	r0090_stage3b_poci;
		private BigDecimal	r0090_stage3c_poci;
		private BigDecimal	r0090_current_pastdues;
		private BigDecimal	r0090_less30days_pastdues;
		private BigDecimal	r0090_31to90days_pastdues;
		private BigDecimal	r0090_91to120days_pastdues;
		private BigDecimal	r0090_121to180days_pastdues;
		private BigDecimal	r0090_181to365days_pastdues;
		private BigDecimal	r0090_over365days_pastdues;
		private BigDecimal	r0090_total_pastdues;
		private BigDecimal	r0090_newloan_duringreport;
		private BigDecimal	r0090_newstage_duringreport;
		private BigDecimal	r0090_intrestfees_duringreport;
		private BigDecimal	r0090_performingac_acinfo;
		private BigDecimal	r0090_nonperformingac_acinfo;
		private String	r0100_product;
		private BigDecimal	r0100_outstandbal;
		private BigDecimal	r0100_secured_outstandbal;
		private BigDecimal	r0100_unsecured_outstandbal;
		private BigDecimal	r0100_stage1_assetclass;
		private BigDecimal	r0100_stage2_assetclass;
		private BigDecimal	r0100_stage3a_assetclass;
		private BigDecimal	r0100_stage3b_assetclass;
		private BigDecimal	r0100_stage3c_assetclass;
		private BigDecimal	r0100_stage1_provisionheld;
		private BigDecimal	r0100_stage2_provisionheld;
		private BigDecimal	r0100_stage3a_provisionheld;
		private BigDecimal	r0100_stage3b_provisionheld;
		private BigDecimal	r0100_stage3c_provisionheld;
		private BigDecimal	r0100_intrestfees_provisionheld;
		private BigDecimal	r0100_intrestsuspense_provisionheld;
		private BigDecimal	r0100_stage1_poci;
		private BigDecimal	r0100_stage2_poci;
		private BigDecimal	r0100_stage3a_poci;
		private BigDecimal	r0100_stage3b_poci;
		private BigDecimal	r0100_stage3c_poci;
		private BigDecimal	r0100_current_pastdues;
		private BigDecimal	r0100_less30days_pastdues;
		private BigDecimal	r0100_31to90days_pastdues;
		private BigDecimal	r0100_91to120days_pastdues;
		private BigDecimal	r0100_121to180days_pastdues;
		private BigDecimal	r0100_181to365days_pastdues;
		private BigDecimal	r0100_over365days_pastdues;
		private BigDecimal	r0100_total_pastdues;
		private BigDecimal	r0100_newloan_duringreport;
		private BigDecimal	r0100_newstage_duringreport;
		private BigDecimal	r0100_intrestfees_duringreport;
		private BigDecimal	r0100_performingac_acinfo;
		private BigDecimal	r0100_nonperformingac_acinfo;
		private String	r0110_product;
		private BigDecimal	r0110_outstandbal;
		private BigDecimal	r0110_secured_outstandbal;
		private BigDecimal	r0110_unsecured_outstandbal;
		private BigDecimal	r0110_stage1_assetclass;
		private BigDecimal	r0110_stage2_assetclass;
		private BigDecimal	r0110_stage3a_assetclass;
		private BigDecimal	r0110_stage3b_assetclass;
		private BigDecimal	r0110_stage3c_assetclass;
		private BigDecimal	r0110_stage1_provisionheld;
		private BigDecimal	r0110_stage2_provisionheld;
		private BigDecimal	r0110_stage3a_provisionheld;
		private BigDecimal	r0110_stage3b_provisionheld;
		private BigDecimal	r0110_stage3c_provisionheld;
		private BigDecimal	r0110_intrestfees_provisionheld;
		private BigDecimal	r0110_intrestsuspense_provisionheld;
		private BigDecimal	r0110_stage1_poci;
		private BigDecimal	r0110_stage2_poci;
		private BigDecimal	r0110_stage3a_poci;
		private BigDecimal	r0110_stage3b_poci;
		private BigDecimal	r0110_stage3c_poci;
		private BigDecimal	r0110_current_pastdues;
		private BigDecimal	r0110_less30days_pastdues;
		private BigDecimal	r0110_31to90days_pastdues;
		private BigDecimal	r0110_91to120days_pastdues;
		private BigDecimal	r0110_121to180days_pastdues;
		private BigDecimal	r0110_181to365days_pastdues;
		private BigDecimal	r0110_over365days_pastdues;
		private BigDecimal	r0110_total_pastdues;
		private BigDecimal	r0110_newloan_duringreport;
		private BigDecimal	r0110_newstage_duringreport;
		private BigDecimal	r0110_intrestfees_duringreport;
		private BigDecimal	r0110_performingac_acinfo;
		private BigDecimal	r0110_nonperformingac_acinfo;
		private String	r0120_product;
		private BigDecimal	r0120_outstandbal;
		private BigDecimal	r0120_secured_outstandbal;
		private BigDecimal	r0120_unsecured_outstandbal;
		private BigDecimal	r0120_stage1_assetclass;
		private BigDecimal	r0120_stage2_assetclass;
		private BigDecimal	r0120_stage3a_assetclass;
		private BigDecimal	r0120_stage3b_assetclass;
		private BigDecimal	r0120_stage3c_assetclass;
		private BigDecimal	r0120_stage1_provisionheld;
		private BigDecimal	r0120_stage2_provisionheld;
		private BigDecimal	r0120_stage3a_provisionheld;
		private BigDecimal	r0120_stage3b_provisionheld;
		private BigDecimal	r0120_stage3c_provisionheld;
		private BigDecimal	r0120_intrestfees_provisionheld;
		private BigDecimal	r0120_intrestsuspense_provisionheld;
		private BigDecimal	r0120_stage1_poci;
		private BigDecimal	r0120_stage2_poci;
		private BigDecimal	r0120_stage3a_poci;
		private BigDecimal	r0120_stage3b_poci;
		private BigDecimal	r0120_stage3c_poci;
		private BigDecimal	r0120_current_pastdues;
		private BigDecimal	r0120_less30days_pastdues;
		private BigDecimal	r0120_31to90days_pastdues;
		private BigDecimal	r0120_91to120days_pastdues;
		private BigDecimal	r0120_121to180days_pastdues;
		private BigDecimal	r0120_181to365days_pastdues;
		private BigDecimal	r0120_over365days_pastdues;
		private BigDecimal	r0120_total_pastdues;
		private BigDecimal	r0120_newloan_duringreport;
		private BigDecimal	r0120_newstage_duringreport;
		private BigDecimal	r0120_intrestfees_duringreport;
		private BigDecimal	r0120_performingac_acinfo;
		private BigDecimal	r0120_nonperformingac_acinfo;
		private String	r0130_product;
		private BigDecimal	r0130_outstandbal;
		private BigDecimal	r0130_secured_outstandbal;
		private BigDecimal	r0130_unsecured_outstandbal;
		private BigDecimal	r0130_stage1_assetclass;
		private BigDecimal	r0130_stage2_assetclass;
		private BigDecimal	r0130_stage3a_assetclass;
		private BigDecimal	r0130_stage3b_assetclass;
		private BigDecimal	r0130_stage3c_assetclass;
		private BigDecimal	r0130_stage1_provisionheld;
		private BigDecimal	r0130_stage2_provisionheld;
		private BigDecimal	r0130_stage3a_provisionheld;
		private BigDecimal	r0130_stage3b_provisionheld;
		private BigDecimal	r0130_stage3c_provisionheld;
		private BigDecimal	r0130_intrestfees_provisionheld;
		private BigDecimal	r0130_intrestsuspense_provisionheld;
		private BigDecimal	r0130_stage1_poci;
		private BigDecimal	r0130_stage2_poci;
		private BigDecimal	r0130_stage3a_poci;
		private BigDecimal	r0130_stage3b_poci;
		private BigDecimal	r0130_stage3c_poci;
		private BigDecimal	r0130_current_pastdues;
		private BigDecimal	r0130_less30days_pastdues;
		private BigDecimal	r0130_31to90days_pastdues;
		private BigDecimal	r0130_91to120days_pastdues;
		private BigDecimal	r0130_121to180days_pastdues;
		private BigDecimal	r0130_181to365days_pastdues;
		private BigDecimal	r0130_over365days_pastdues;
		private BigDecimal	r0130_total_pastdues;
		private BigDecimal	r0130_newloan_duringreport;
		private BigDecimal	r0130_newstage_duringreport;
		private BigDecimal	r0130_intrestfees_duringreport;
		private BigDecimal	r0130_performingac_acinfo;
		private BigDecimal	r0130_nonperformingac_acinfo;
		private String	r0140_product;
		private BigDecimal	r0140_outstandbal;
		private BigDecimal	r0140_secured_outstandbal;
		private BigDecimal	r0140_unsecured_outstandbal;
		private BigDecimal	r0140_stage1_assetclass;
		private BigDecimal	r0140_stage2_assetclass;
		private BigDecimal	r0140_stage3a_assetclass;
		private BigDecimal	r0140_stage3b_assetclass;
		private BigDecimal	r0140_stage3c_assetclass;
		private BigDecimal	r0140_stage1_provisionheld;
		private BigDecimal	r0140_stage2_provisionheld;
		private BigDecimal	r0140_stage3a_provisionheld;
		private BigDecimal	r0140_stage3b_provisionheld;
		private BigDecimal	r0140_stage3c_provisionheld;
		private BigDecimal	r0140_intrestfees_provisionheld;
		private BigDecimal	r0140_intrestsuspense_provisionheld;
		private BigDecimal	r0140_stage1_poci;
		private BigDecimal	r0140_stage2_poci;
		private BigDecimal	r0140_stage3a_poci;
		private BigDecimal	r0140_stage3b_poci;
		private BigDecimal	r0140_stage3c_poci;
		private BigDecimal	r0140_current_pastdues;
		private BigDecimal	r0140_less30days_pastdues;
		private BigDecimal	r0140_31to90days_pastdues;
		private BigDecimal	r0140_91to120days_pastdues;
		private BigDecimal	r0140_121to180days_pastdues;
		private BigDecimal	r0140_181to365days_pastdues;
		private BigDecimal	r0140_over365days_pastdues;
		private BigDecimal	r0140_total_pastdues;
		private BigDecimal	r0140_newloan_duringreport;
		private BigDecimal	r0140_newstage_duringreport;
		private BigDecimal	r0140_intrestfees_duringreport;
		private BigDecimal	r0140_performingac_acinfo;
		private BigDecimal	r0140_nonperformingac_acinfo;
		private String	r0150_product;
		private BigDecimal	r0150_outstandbal;
		private BigDecimal	r0150_secured_outstandbal;
		private BigDecimal	r0150_unsecured_outstandbal;
		private BigDecimal	r0150_stage1_assetclass;
		private BigDecimal	r0150_stage2_assetclass;
		private BigDecimal	r0150_stage3a_assetclass;
		private BigDecimal	r0150_stage3b_assetclass;
		private BigDecimal	r0150_stage3c_assetclass;
		private BigDecimal	r0150_stage1_provisionheld;
		private BigDecimal	r0150_stage2_provisionheld;
		private BigDecimal	r0150_stage3a_provisionheld;
		private BigDecimal	r0150_stage3b_provisionheld;
		private BigDecimal	r0150_stage3c_provisionheld;
		private BigDecimal	r0150_intrestfees_provisionheld;
		private BigDecimal	r0150_intrestsuspense_provisionheld;
		private BigDecimal	r0150_stage1_poci;
		private BigDecimal	r0150_stage2_poci;
		private BigDecimal	r0150_stage3a_poci;
		private BigDecimal	r0150_stage3b_poci;
		private BigDecimal	r0150_stage3c_poci;
		private BigDecimal	r0150_current_pastdues;
		private BigDecimal	r0150_less30days_pastdues;
		private BigDecimal	r0150_31to90days_pastdues;
		private BigDecimal	r0150_91to120days_pastdues;
		private BigDecimal	r0150_121to180days_pastdues;
		private BigDecimal	r0150_181to365days_pastdues;
		private BigDecimal	r0150_over365days_pastdues;
		private BigDecimal	r0150_total_pastdues;
		private BigDecimal	r0150_newloan_duringreport;
		private BigDecimal	r0150_newstage_duringreport;
		private BigDecimal	r0150_intrestfees_duringreport;
		private BigDecimal	r0150_performingac_acinfo;
		private BigDecimal	r0150_nonperformingac_acinfo;
		private String	r0160_product;
		private BigDecimal	r0160_outstandbal;
		private BigDecimal	r0160_secured_outstandbal;
		private BigDecimal	r0160_unsecured_outstandbal;
		private BigDecimal	r0160_stage1_assetclass;
		private BigDecimal	r0160_stage2_assetclass;
		private BigDecimal	r0160_stage3a_assetclass;
		private BigDecimal	r0160_stage3b_assetclass;
		private BigDecimal	r0160_stage3c_assetclass;
		private BigDecimal	r0160_stage1_provisionheld;
		private BigDecimal	r0160_stage2_provisionheld;
		private BigDecimal	r0160_stage3a_provisionheld;
		private BigDecimal	r0160_stage3b_provisionheld;
		private BigDecimal	r0160_stage3c_provisionheld;
		private BigDecimal	r0160_intrestfees_provisionheld;
		private BigDecimal	r0160_intrestsuspense_provisionheld;
		private BigDecimal	r0160_stage1_poci;
		private BigDecimal	r0160_stage2_poci;
		private BigDecimal	r0160_stage3a_poci;
		private BigDecimal	r0160_stage3b_poci;
		private BigDecimal	r0160_stage3c_poci;
		private BigDecimal	r0160_current_pastdues;
		private BigDecimal	r0160_less30days_pastdues;
		private BigDecimal	r0160_31to90days_pastdues;
		private BigDecimal	r0160_91to120days_pastdues;
		private BigDecimal	r0160_121to80days_pastdues;
		private BigDecimal	r0160_181to365days_pastdues;
		private BigDecimal	r0160_over365days_pastdues;
		private BigDecimal	r0160_total_pastdues;
		private BigDecimal	r0160_newloan_duringreport;
		private BigDecimal	r0160_newstage_duringreport;
		private BigDecimal	r0160_intrestfees_duringreport;
		private BigDecimal	r0160_performingac_acinfo;
		private BigDecimal	r0160_nonperformingac_acinfo;
		private String	r0170_product;
		private BigDecimal	r0170_outstandbal;
		private BigDecimal	r0170_secured_outstandbal;
		private BigDecimal	r0170_unsecured_outstandbal;
		private BigDecimal	r0170_stage1_assetclass;
		private BigDecimal	r0170_stage2_assetclass;
		private BigDecimal	r0170_stage3a_assetclass;
		private BigDecimal	r0170_stage3b_assetclass;
		private BigDecimal	r0170_stage3c_assetclass;
		private BigDecimal	r0170_stage1_provisionheld;
		private BigDecimal	r0170_stage2_provisionheld;
		private BigDecimal	r0170_stage3a_provisionheld;
		private BigDecimal	r0170_stage3b_provisionheld;
		private BigDecimal	r0170_stage3c_provisionheld;
		private BigDecimal	r0170_intrestfees_provisionheld;
		private BigDecimal	r0170_intrestsuspense_provisionheld;
		private BigDecimal	r0170_stage1_poci;
		private BigDecimal	r0170_stage2_poci;
		private BigDecimal	r0170_stage3a_poci;
		private BigDecimal	r0170_stage3b_poci;
		private BigDecimal	r0170_stage3c_poci;
		private BigDecimal	r0170_current_pastdues;
		private BigDecimal	r0170_less30days_pastdues;
		private BigDecimal	r0170_31to90days_pastdues;
		private BigDecimal	r0170_91to120days_pastdues;
		private BigDecimal	r0170_121to180days_pastdues;
		private BigDecimal	r0170_181to365days_pastdues;
		private BigDecimal	r0170_over365days_pastdues;
		private BigDecimal	r0170_total_pastdues;
		private BigDecimal	r0170_newloan_duringreport;
		private BigDecimal	r0170_newstage_duringreport;
		private BigDecimal	r0170_intrestfees_duringreport;
		private BigDecimal	r0170_performingac_acinfo;
		private BigDecimal	r0170_nonperformingac_acinfo;
		private String	r0180_product;
		private BigDecimal	r0180_outstandbal;
		private BigDecimal	r0180_secured_outstandbal;
		private BigDecimal	r0180_unsecured_outstandbal;
		private BigDecimal	r0180_stage1_assetclass;
		private BigDecimal	r0180_stage2_assetclass;
		private BigDecimal	r0180_stage3a_assetclass;
		private BigDecimal	r0180_stage3b_assetclass;
		private BigDecimal	r0180_stage3c_assetclass;
		private BigDecimal	r0180_stage1_provisionheld;
		private BigDecimal	r0180_stage2_provisionheld;
		private BigDecimal	r0180_stage3a_provisionheld;
		private BigDecimal	r0180_stage3b_provisionheld;
		private BigDecimal	r0180_stage3c_provisionheld;
		private BigDecimal	r0180_intrestfees_provisionheld;
		private BigDecimal	r0180_intrestsuspense_provisionheld;
		private BigDecimal	r0180_stage1_poci;
		private BigDecimal	r0180_stage2_poci;
		private BigDecimal	r0180_stage3a_poci;
		private BigDecimal	r0180_stage3b_poci;
		private BigDecimal	r0180_stage3c_poci;
		private BigDecimal	r0180_current_pastdues;
		private BigDecimal	r0180_less30days_pastdues;
		private BigDecimal	r0180_31to90days_pastdues;
		private BigDecimal	r0180_91to120days_pastdues;
		private BigDecimal	r0180_121to180days_pastdues;
		private BigDecimal	r0180_181to365days_pastdues;
		private BigDecimal	r0180_over365days_pastdues;
		private BigDecimal	r0180_total_pastdues;
		private BigDecimal	r0180_newloan_duringreport;
		private BigDecimal	r0180_newstage_duringreport;
		private BigDecimal	r0180_intrestfees_duringreport;
		private BigDecimal	r0180_performingac_acinfo;
		private BigDecimal	r0180_nonperformingac_acinfo;
		private String	r0190_product;
		private BigDecimal	r0190_outstandbal;
		private BigDecimal	r0190_secured_outstandbal;
		private BigDecimal	r0190_unsecured_outstandbal;
		private BigDecimal	r0190_stage1_assetclass;
		private BigDecimal	r0190_stage2_assetclass;
		private BigDecimal	r0190_stage3a_assetclass;
		private BigDecimal	r0190_stage3b_assetclass;
		private BigDecimal	r0190_stage3c_assetclass;
		private BigDecimal	r0190_stage1_provisionheld;
		private BigDecimal	r0190_stage2_provisionheld;
		private BigDecimal	r0190_stage3a_provisionheld;
		private BigDecimal	r0190_stage3b_provisionheld;
		private BigDecimal	r0190_stage3c_provisionheld;
		private BigDecimal	r0190_intrestfees_provisionheld;
		private BigDecimal	r0190_intrestsuspense_provisionheld;
		private BigDecimal	r0190_stage1_poci;
		private BigDecimal	r0190_stage2_poci;
		private BigDecimal	r0190_stage3a_poci;
		private BigDecimal	r0190_stage3b_poci;
		private BigDecimal	r0190_stage3c_poci;
		private BigDecimal	r0190_current_pastdues;
		private BigDecimal	r0190_less30days_pastdues;
		private BigDecimal	r0190_31to90days_pastdues;
		private BigDecimal	r0190_91to120days_pastdues;
		private BigDecimal	r0190_121to180days_pastdues;
		private BigDecimal	r0190_181to365days_pastdues;
		private BigDecimal	r0190_over365days_pastdues;
		private BigDecimal	r0190_total_pastdues;
		private BigDecimal	r0190_newloan_duringreport;
		private BigDecimal	r0190_newstage_duringreport;
		private BigDecimal	r0190_intrestfees_duringreport;
		private BigDecimal	r0190_performingac_acinfo;
		private BigDecimal	r0190_nonperformingac_acinfo;
		private String	r0200_product;
		private BigDecimal	r0200_outstandbal;
		private BigDecimal	r0200_secured_outstandbal;
		private BigDecimal	r0200_unsecured_outstandbal;
		private BigDecimal	r0200_stage1_assetclass;
		private BigDecimal	r0200_stage2_assetclass;
		private BigDecimal	r0200_stage3a_assetclass;
		private BigDecimal	r0200_stage3b_assetclass;
		private BigDecimal	r0200_stage3c_assetclass;
		private BigDecimal	r0200_stage1_provisionheld;
		private BigDecimal	r0200_stage2_provisionheld;
		private BigDecimal	r0200_stage3a_provisionheld;
		private BigDecimal	r0200_stage3b_provisionheld;
		private BigDecimal	r0200_stage3c_provisionheld;
		private BigDecimal	r0200_intrestfees_provisionheld;
		private BigDecimal	r0200_intrestsuspense_provisionheld;
		private BigDecimal	r0200_stage1_poci;
		private BigDecimal	r0200_stage2_poci;
		private BigDecimal	r0200_stage3a_poci;
		private BigDecimal	r0200_stage3b_poci;
		private BigDecimal	r0200_stage3c_poci;
		private BigDecimal	r0200_current_pastdues;
		private BigDecimal	r0200_less30days_pastdues;
		private BigDecimal	r0200_31to90days_pastdues;
		private BigDecimal	r0200_91to120days_pastdues;
		private BigDecimal	r0200_121to180days_pastdues;
		private BigDecimal	r0200_181to365days_pastdues;
		private BigDecimal	r0200_over365days_pastdues;
		private BigDecimal	r0200_total_pastdues;
		private BigDecimal	r0200_newloan_duringreport;
		private BigDecimal	r0200_newstage_duringreport;
		private BigDecimal	r0200_intrestfees_duringreport;
		private BigDecimal	r0200_performingac_acinfo;
		private BigDecimal	r0200_nonperformingac_acinfo;
		private String	r0210_product;
		private BigDecimal	r0210_outstandbal;
		private BigDecimal	r0210_secured_outstandbal;
		private BigDecimal	r0210_unsecured_outstandbal;
		private BigDecimal	r0210_stage1_assetclass;
		private BigDecimal	r0210_stage2_assetclass;
		private BigDecimal	r0210_stage3a_assetclass;
		private BigDecimal	r0210_stage3b_assetclass;
		private BigDecimal	r0210_stage3c_assetclass;
		private BigDecimal	r0210_stage1_provisionheld;
		private BigDecimal	r0210_stage2_provisionheld;
		private BigDecimal	r0210_stage3a_provisionheld;
		private BigDecimal	r0210_stage3b_provisionheld;
		private BigDecimal	r0210_stage3c_provisionheld;
		private BigDecimal	r0210_intrestfees_provisionheld;
		private BigDecimal	r0210_intrestsuspense_provisionheld;
		private BigDecimal	r0210_stage1_poci;
		private BigDecimal	r0210_stage2_poci;
		private BigDecimal	r0210_stage3a_poci;
		private BigDecimal	r0210_stage3b_poci;
		private BigDecimal	r0210_stage3c_poci;
		private BigDecimal	r0210_current_pastdues;
		private BigDecimal	r0210_less30days_pastdues;
		private BigDecimal	r0210_31to90days_pastdues;
		private BigDecimal	r0210_91to120days_pastdues;
		private BigDecimal	r0210_121to180days_pastdues;
		private BigDecimal	r0210_181to365days_pastdues;
		private BigDecimal	r0210_over365days_pastdues;
		private BigDecimal	r0210_total_pastdues;
		private BigDecimal	r0210_newloan_duringreport;
		private BigDecimal	r0210_newstage_duringreport;
		private BigDecimal	r0210_intrestfees_duringreport;
		private BigDecimal	r0210_performingac_acinfo;
		private BigDecimal	r0210_nonperformingac_acinfo;
		private String	r0220_product;
		private BigDecimal	r0220_outstandbal;
		private BigDecimal	r0220_secured_outstandbal;
		private BigDecimal	r0220_unsecured_outstandbal;
		private BigDecimal	r0220_stage1_assetclass;
		private BigDecimal	r0220_stage2_assetclass;
		private BigDecimal	r0220_stage3a_assetclass;
		private BigDecimal	r0220_stage3b_assetclass;
		private BigDecimal	r0220_stage3c_assetclass;
		private BigDecimal	r0220_stage1_provisionheld;
		private BigDecimal	r0220_stage2_provisionheld;
		private BigDecimal	r0220_stage3a_provisionheld;
		private BigDecimal	r0220_stage3b_provisionheld;
		private BigDecimal	r0220_stage3c_provisionheld;
		private BigDecimal	r0220_intrestfees_provisionheld;
		private BigDecimal	r0220_intrestsuspense_provisionheld;
		private BigDecimal	r0220_stage1_poci;
		private BigDecimal	r0220_stage2_poci;
		private BigDecimal	r0220_stage3a_poci;
		private BigDecimal	r0220_stage3b_poci;
		private BigDecimal	r0220_stage3c_poci;
		private BigDecimal	r0220_current_pastdues;
		private BigDecimal	r0220_less30days_pastdues;
		private BigDecimal	r0220_31to90days_pastdues;
		private BigDecimal	r0220_91to120days_pastdues;
		private BigDecimal	r0220_121to180days_pastdues;
		private BigDecimal	r0220_181to365days_pastdues;
		private BigDecimal	r0220_over365days_pastdues;
		private BigDecimal	r0220_total_pastdues;
		private BigDecimal	r0220_newloan_duringreport;
		private BigDecimal	r0220_newstage_duringreport;
		private BigDecimal	r0220_intrestfees_duringreport;
		private BigDecimal	r0220_performingac_acinfo;
		private BigDecimal	r0220_nonperformingac_acinfo;
		private String	r0230_product;
		private BigDecimal	r0230_outstandbal;
		private BigDecimal	r0230_secured_outstandbal;
		private BigDecimal	r0230_unsecured_outstandbal;
		private BigDecimal	r0230_stage1_assetclass;
		private BigDecimal	r0230_stage2_assetclass;
		private BigDecimal	r0230_stage3a_assetclass;
		private BigDecimal	r0230_stage3b_assetclass;
		private BigDecimal	r0230_stage3c_assetclass;
		private BigDecimal	r0230_stage1_provisionheld;
		private BigDecimal	r0230_stage2_provisionheld;
		private BigDecimal	r0230_stage3a_provisionheld;
		private BigDecimal	r0230_stage3b_provisionheld;
		private BigDecimal	r0230_stage3c_provisionheld;
		private BigDecimal	r0230_intrestfees_provisionheld;
		private BigDecimal	r0230_intrestsuspense_provisionheld;
		private BigDecimal	r0230_stage1_poci;
		private BigDecimal	r0230_stage2_poci;
		private BigDecimal	r0230_stage3a_poci;
		private BigDecimal	r0230_stage3b_poci;
		private BigDecimal	r0230_stage3c_poci;
		private BigDecimal	r0230_current_pastdues;
		private BigDecimal	r0230_less30days_pastdues;
		private BigDecimal	r0230_31to90days_pastdues;
		private BigDecimal	r0230_91to120days_pastdues;
		private BigDecimal	r0230_121to180days_pastdues;
		private BigDecimal	r0230_181to365days_pastdues;
		private BigDecimal	r0230_over365days_pastdues;
		private BigDecimal	r0230_total_pastdues;
		private BigDecimal	r0230_newloan_duringreport;
		private BigDecimal	r0230_newstage_duringreport;
		private BigDecimal	r0230_intrestfees_duringreport;
		private BigDecimal	r0230_performingac_acinfo;
		private BigDecimal	r0230_nonperformingac_acinfo;
		private String	r0240_product;
		private BigDecimal	r0240_outstandbal;
		private BigDecimal	r0240_secured_outstandbal;
		private BigDecimal	r0240_unsecured_outstandbal;
		private BigDecimal	r0240_stage1_assetclass;
		private BigDecimal	r0240_stage2_assetclass;
		private BigDecimal	r0240_stage3a_assetclass;
		private BigDecimal	r0240_stage3b_assetclass;
		private BigDecimal	r0240_stage3c_assetclass;
		private BigDecimal	r0240_stage1_provisionheld;
		private BigDecimal	r0240_stage2_provisionheld;
		private BigDecimal	r0240_stage3a_provisionheld;
		private BigDecimal	r0240_stage3b_provisionheld;
		private BigDecimal	r0240_stage3c_provisionheld;
		private BigDecimal	r0240_intrestfees_provisionheld;
		private BigDecimal	r0240_intrestsuspense_provisionheld;
		private BigDecimal	r0240_stage1_poci;
		private BigDecimal	r0240_stage2_poci;
		private BigDecimal	r0240_stage3a_poci;
		private BigDecimal	r0240_stage3b_poci;
		private BigDecimal	r0240_stage3c_poci;
		private BigDecimal	r0240_current_pastdues;
		private BigDecimal	r0240_less30days_pastdues;
		private BigDecimal	r0240_31to90days_pastdues;
		private BigDecimal	r0240_91to120days_pastdues;
		private BigDecimal	r0240_121to180days_pastdues;
		private BigDecimal	r0240_181to365days_pastdues;
		private BigDecimal	r0240_over365days_pastdues;
		private BigDecimal	r0240_total_pastdues;
		private BigDecimal	r0240_newloan_duringreport;
		private BigDecimal	r0240_newstage_duringreport;
		private BigDecimal	r0240_intrestfees_duringreport;
		private BigDecimal	r0240_performingac_acinfo;
		private BigDecimal	r0240_nonperformingac_acinfo;
		private String	r0250_product;
		private BigDecimal	r0250_outstandbal;
		private BigDecimal	r0250_secured_outstandbal;
		private BigDecimal	r0250_unsecured_outstandbal;
		private BigDecimal	r0250_stage1_assetclass;
		private BigDecimal	r0250_stage2_assetclass;
		private BigDecimal	r0250_stage3a_assetclass;
		private BigDecimal	r0250_stage3b_assetclass;
		private BigDecimal	r0250_stage3c_assetclass;
		private BigDecimal	r0250_stage1_provisionheld;
		private BigDecimal	r0250_stage2_provisionheld;
		private BigDecimal	r0250_stage3a_provisionheld;
		private BigDecimal	r0250_stage3b_provisionheld;
		private BigDecimal	r0250_stage3c_provisionheld;
		private BigDecimal	r0250_intrestfees_provisionheld;
		private BigDecimal	r0250_intrestsuspense_provisionheld;
		private BigDecimal	r0250_stage1_poci;
		private BigDecimal	r0250_stage2_poci;
		private BigDecimal	r0250_stage3a_poci;
		private BigDecimal	r0250_stage3b_poci;
		private BigDecimal	r0250_stage3c_poci;
		private BigDecimal	r0250_current_pastdues;
		private BigDecimal	r0250_less30days_pastdues;
		private BigDecimal	r0250_31to90days_pastdues;
		private BigDecimal	r0250_91to120days_pastdues;
		private BigDecimal	r0250_121to180days_pastdues;
		private BigDecimal	r0250_181to365days_pastdues;
		private BigDecimal	r0250_over365days_pastdues;
		private BigDecimal	r0250_total_pastdues;
		private BigDecimal	r0250_newloan_duringreport;
		private BigDecimal	r0250_newstage_duringreport;
		private BigDecimal	r0250_intrestfees_duringreport;
		private BigDecimal	r0250_performingac_acinfo;
		private BigDecimal	r0250_nonperformingac_acinfo;
		private String	r0260_product;
		private BigDecimal	r0260_outstandbal;
		private BigDecimal	r0260_secured_outstandbal;
		private BigDecimal	r0260_unsecured_outstandbal;
		private BigDecimal	r0260_stage1_assetclass;
		private BigDecimal	r0260_stage2_assetclass;
		private BigDecimal	r0260_stage3a_assetclass;
		private BigDecimal	r0260_stage3b_assetclass;
		private BigDecimal	r0260_stage3c_assetclass;
		private BigDecimal	r0260_stage1_provisionheld;
		private BigDecimal	r0260_stage2_provisionheld;
		private BigDecimal	r0260_stage3a_provisionheld;
		private BigDecimal	r0260_stage3b_provisionheld;
		private BigDecimal	r0260_stage3c_provisionheld;
		private BigDecimal	r0260_intrestfees_provisionheld;
		private BigDecimal	r0260_intrestsuspense_provisionheld;
		private BigDecimal	r0260_stage1_poci;
		private BigDecimal	r0260_stage2_poci;
		private BigDecimal	r0260_stage3a_poci;
		private BigDecimal	r0260_stage3b_poci;
		private BigDecimal	r0260_stage3c_poci;
		private BigDecimal	r0260_current_pastdues;
		private BigDecimal	r0260_less30days_pastdues;
		private BigDecimal	r0260_31to90days_pastdues;
		private BigDecimal	r0260_91to120days_pastdues;
		private BigDecimal	r0260_121to180days_pastdues;
		private BigDecimal	r0260_181to365days_pastdues;
		private BigDecimal	r0260_over365days_pastdues;
		private BigDecimal	r0260_total_pastdues;
		private BigDecimal	r0260_newloan_duringreport;
		private BigDecimal	r0260_newstage_duringreport;
		private BigDecimal	r0260_intrestfees_duringreport;
		private BigDecimal	r0260_performingac_acinfo;
		private BigDecimal	r0260_nonperformingac_acinfo;
		private String	r0270_product;
		private BigDecimal	r0270_outstandbal;
		private BigDecimal	r0270_secured_outstandbal;
		private BigDecimal	r0270_unsecured_outstandbal;
		private BigDecimal	r0270_stage1_assetclass;
		private BigDecimal	r0270_stage2_assetclass;
		private BigDecimal	r0270_stage3a_assetclass;
		private BigDecimal	r0270_stage3b_assetclass;
		private BigDecimal	r0270_stage3c_assetclass;
		private BigDecimal	r0270_stage1_provisionheld;
		private BigDecimal	r0270_stage2_provisionheld;
		private BigDecimal	r0270_stage3a_provisionheld;
		private BigDecimal	r0270_stage3b_provisionheld;
		private BigDecimal	r0270_stage3c_provisionheld;
		private BigDecimal	r0270_intrestfees_provisionheld;
		private BigDecimal	r0270_intrestsuspense_provisionheld;
		private BigDecimal	r0270_stage1_poci;
		private BigDecimal	r0270_stage2_poci;
		private BigDecimal	r0270_stage3a_poci;
		private BigDecimal	r0270_stage3b_poci;
		private BigDecimal	r0270_stage3c_poci;
		private BigDecimal	r0270_current_pastdues;
		private BigDecimal	r0270_less30days_pastdues;
		private BigDecimal	r0270_31to90days_pastdues;
		private BigDecimal	r0270_91to120days_pastdues;
		private BigDecimal	r0270_121to180days_pastdues;
		private BigDecimal	r0270_181to365days_pastdues;
		private BigDecimal	r0270_over365days_pastdues;
		private BigDecimal	r0270_total_pastdues;
		private BigDecimal	r0270_newloan_duringreport;
		private BigDecimal	r0270_newstage_duringreport;
		private BigDecimal	r0270_intrestfees_duringreport;
		private BigDecimal	r0270_performingac_acinfo;
		private BigDecimal	r0270_nonperformingac_acinfo;
		private String	r0280_product;
		private BigDecimal	r0280_outstandbal;
		private BigDecimal	r0280_secured_outstandbal;
		private BigDecimal	r0280_unsecured_outstandbal;
		private BigDecimal	r0280_stage1_assetclass;
		private BigDecimal	r0280_stage2_assetclass;
		private BigDecimal	r0280_stage3a_assetclass;
		private BigDecimal	r0280_stage3b_assetclass;
		private BigDecimal	r0280_stage3c_assetclass;
		private BigDecimal	r0280_stage1_provisionheld;
		private BigDecimal	r0280_stage2_provisionheld;
		private BigDecimal	r0280_stage3a_provisionheld;
		private BigDecimal	r0280_stage3b_provisionheld;
		private BigDecimal	r0280_stage3c_provisionheld;
		private BigDecimal	r0280_intrestfees_provisionheld;
		private BigDecimal	r0280_intrestsuspense_provisionheld;
		private BigDecimal	r0280_stage1_poci;
		private BigDecimal	r0280_stage2_poci;
		private BigDecimal	r0280_stage3a_poci;
		private BigDecimal	r0280_stage3b_poci;
		private BigDecimal	r0280_stage3c_poci;
		private BigDecimal	r0280_current_pastdues;
		private BigDecimal	r0280_less30days_pastdues;
		private BigDecimal	r0280_31to90days_pastdues;
		private BigDecimal	r0280_91to120days_pastdues;
		private BigDecimal	r0280_121to180days_pastdues;
		private BigDecimal	r0280_181to365days_pastdues;
		private BigDecimal	r0280_over365days_pastdues;
		private BigDecimal	r0280_total_pastdues;
		private BigDecimal	r0280_newloan_duringreport;
		private BigDecimal	r0280_newstage_duringreport;
		private BigDecimal	r0280_intrestfees_duringreport;
		private BigDecimal	r0280_performingac_acinfo;
		private BigDecimal	r0280_nonperformingac_acinfo;
		private String	r0290_product;
		private BigDecimal	r0290_outstandbal;
		private BigDecimal	r0290_secured_outstandbal;
		private BigDecimal	r0290_unsecured_outstandbal;
		private BigDecimal	r0290_stage1_assetclass;
		private BigDecimal	r0290_stage2_assetclass;
		private BigDecimal	r0290_stage3a_assetclass;
		private BigDecimal	r0290_stage3b_assetclass;
		private BigDecimal	r0290_stage3c_assetclass;
		private BigDecimal	r0290_stage1_provisionheld;
		private BigDecimal	r0290_stage2_provisionheld;
		private BigDecimal	r0290_stage3a_provisionheld;
		private BigDecimal	r0290_stage3b_provisionheld;
		private BigDecimal	r0290_stage3c_provisionheld;
		private BigDecimal	r0290_intrestfees_provisionheld;
		private BigDecimal	r0290_intrestsuspense_provisionheld;
		private BigDecimal	r0290_stage1_poci;
		private BigDecimal	r0290_stage2_poci;
		private BigDecimal	r0290_stage3a_poci;
		private BigDecimal	r0290_stage3b_poci;
		private BigDecimal	r0290_stage3c_poci;
		private BigDecimal	r0290_current_pastdues;
		private BigDecimal	r0290_less30days_pastdues;
		private BigDecimal	r0290_31to90days_pastdues;
		private BigDecimal	r0290_91to120days_pastdues;
		private BigDecimal	r0290_121to180days_pastdues;
		private BigDecimal	r0290_181to365days_pastdues;
		private BigDecimal	r0290_over365days_pastdues;
		private BigDecimal	r0290_total_pastdues;
		private BigDecimal	r0290_newloan_duringreport;
		private BigDecimal	r0290_newstage_duringreport;
		private BigDecimal	r0290_intrestfees_duringreport;
		private BigDecimal	r0290_performingac_acinfo;
		private BigDecimal	r0290_nonperformingac_acinfo;
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@Id
		private Date	report_date;
		private String	report_version;
		private String	report_frequency;
		private String	report_code;
		private String	report_desc;
		private String	modify_flg;
		private String	entity_flg;
		private String	delete_flg;
		public String getR0010_product() {
			return r0010_product;
		}
		public void setR0010_product(String r0010_product) {
			this.r0010_product = r0010_product;
		}
		public BigDecimal getR0010_outstandbal() {
			return r0010_outstandbal;
		}
		public void setR0010_outstandbal(BigDecimal r0010_outstandbal) {
			this.r0010_outstandbal = r0010_outstandbal;
		}
		public BigDecimal getR0010_secured_outstandbal() {
			return r0010_secured_outstandbal;
		}
		public void setR0010_secured_outstandbal(BigDecimal r0010_secured_outstandbal) {
			this.r0010_secured_outstandbal = r0010_secured_outstandbal;
		}
		public BigDecimal getR0010_unsecured_outstandbal() {
			return r0010_unsecured_outstandbal;
		}
		public void setR0010_unsecured_outstandbal(BigDecimal r0010_unsecured_outstandbal) {
			this.r0010_unsecured_outstandbal = r0010_unsecured_outstandbal;
		}
		public BigDecimal getR0010_stage1_assetclass() {
			return r0010_stage1_assetclass;
		}
		public void setR0010_stage1_assetclass(BigDecimal r0010_stage1_assetclass) {
			this.r0010_stage1_assetclass = r0010_stage1_assetclass;
		}
		public BigDecimal getR0010_stage2_assetclass() {
			return r0010_stage2_assetclass;
		}
		public void setR0010_stage2_assetclass(BigDecimal r0010_stage2_assetclass) {
			this.r0010_stage2_assetclass = r0010_stage2_assetclass;
		}
		public BigDecimal getR0010_stage3a_assetclass() {
			return r0010_stage3a_assetclass;
		}
		public void setR0010_stage3a_assetclass(BigDecimal r0010_stage3a_assetclass) {
			this.r0010_stage3a_assetclass = r0010_stage3a_assetclass;
		}
		public BigDecimal getR0010_stage3b_assetclass() {
			return r0010_stage3b_assetclass;
		}
		public void setR0010_stage3b_assetclass(BigDecimal r0010_stage3b_assetclass) {
			this.r0010_stage3b_assetclass = r0010_stage3b_assetclass;
		}
		public BigDecimal getR0010_stage3c_assetclass() {
			return r0010_stage3c_assetclass;
		}
		public void setR0010_stage3c_assetclass(BigDecimal r0010_stage3c_assetclass) {
			this.r0010_stage3c_assetclass = r0010_stage3c_assetclass;
		}
		public BigDecimal getR0010_stage1_provisionheld() {
			return r0010_stage1_provisionheld;
		}
		public void setR0010_stage1_provisionheld(BigDecimal r0010_stage1_provisionheld) {
			this.r0010_stage1_provisionheld = r0010_stage1_provisionheld;
		}
		public BigDecimal getR0010_stage2_provisionheld() {
			return r0010_stage2_provisionheld;
		}
		public void setR0010_stage2_provisionheld(BigDecimal r0010_stage2_provisionheld) {
			this.r0010_stage2_provisionheld = r0010_stage2_provisionheld;
		}
		public BigDecimal getR0010_stage3a_provisionheld() {
			return r0010_stage3a_provisionheld;
		}
		public void setR0010_stage3a_provisionheld(BigDecimal r0010_stage3a_provisionheld) {
			this.r0010_stage3a_provisionheld = r0010_stage3a_provisionheld;
		}
		public BigDecimal getR0010_stage3b_provisionheld() {
			return r0010_stage3b_provisionheld;
		}
		public void setR0010_stage3b_provisionheld(BigDecimal r0010_stage3b_provisionheld) {
			this.r0010_stage3b_provisionheld = r0010_stage3b_provisionheld;
		}
		public BigDecimal getR0010_stage3c_provisionheld() {
			return r0010_stage3c_provisionheld;
		}
		public void setR0010_stage3c_provisionheld(BigDecimal r0010_stage3c_provisionheld) {
			this.r0010_stage3c_provisionheld = r0010_stage3c_provisionheld;
		}
		public BigDecimal getR0010_intrestfees_provisionheld() {
			return r0010_intrestfees_provisionheld;
		}
		public void setR0010_intrestfees_provisionheld(BigDecimal r0010_intrestfees_provisionheld) {
			this.r0010_intrestfees_provisionheld = r0010_intrestfees_provisionheld;
		}
		public BigDecimal getR0010_intrestsuspense_provisionheld() {
			return r0010_intrestsuspense_provisionheld;
		}
		public void setR0010_intrestsuspense_provisionheld(BigDecimal r0010_intrestsuspense_provisionheld) {
			this.r0010_intrestsuspense_provisionheld = r0010_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0010_stage1_poci() {
			return r0010_stage1_poci;
		}
		public void setR0010_stage1_poci(BigDecimal r0010_stage1_poci) {
			this.r0010_stage1_poci = r0010_stage1_poci;
		}
		public BigDecimal getR0010_stage2_poci() {
			return r0010_stage2_poci;
		}
		public void setR0010_stage2_poci(BigDecimal r0010_stage2_poci) {
			this.r0010_stage2_poci = r0010_stage2_poci;
		}
		public BigDecimal getR0010_stage3a_poci() {
			return r0010_stage3a_poci;
		}
		public void setR0010_stage3a_poci(BigDecimal r0010_stage3a_poci) {
			this.r0010_stage3a_poci = r0010_stage3a_poci;
		}
		public BigDecimal getR0010_stage3b_poci() {
			return r0010_stage3b_poci;
		}
		public void setR0010_stage3b_poci(BigDecimal r0010_stage3b_poci) {
			this.r0010_stage3b_poci = r0010_stage3b_poci;
		}
		public BigDecimal getR0010_stage3c_poci() {
			return r0010_stage3c_poci;
		}
		public void setR0010_stage3c_poci(BigDecimal r0010_stage3c_poci) {
			this.r0010_stage3c_poci = r0010_stage3c_poci;
		}
		public BigDecimal getR0010_current_pastdues() {
			return r0010_current_pastdues;
		}
		public void setR0010_current_pastdues(BigDecimal r0010_current_pastdues) {
			this.r0010_current_pastdues = r0010_current_pastdues;
		}
		public BigDecimal getR0010_less30days_pastdues() {
			return r0010_less30days_pastdues;
		}
		public void setR0010_less30days_pastdues(BigDecimal r0010_less30days_pastdues) {
			this.r0010_less30days_pastdues = r0010_less30days_pastdues;
		}
		public BigDecimal getR0010_31to90days_pastdues() {
			return r0010_31to90days_pastdues;
		}
		public void setR0010_31to90days_pastdues(BigDecimal r0010_31to90days_pastdues) {
			this.r0010_31to90days_pastdues = r0010_31to90days_pastdues;
		}
		public BigDecimal getR0010_91to120days_pastdues() {
			return r0010_91to120days_pastdues;
		}
		public void setR0010_91to120days_pastdues(BigDecimal r0010_91to120days_pastdues) {
			this.r0010_91to120days_pastdues = r0010_91to120days_pastdues;
		}
		public BigDecimal getR0010_121to180days_pastdues() {
			return r0010_121to180days_pastdues;
		}
		public void setR0010_121to180days_pastdues(BigDecimal r0010_121to180days_pastdues) {
			this.r0010_121to180days_pastdues = r0010_121to180days_pastdues;
		}
		public BigDecimal getR0010_181to365days_pastdues() {
			return r0010_181to365days_pastdues;
		}
		public void setR0010_181to365days_pastdues(BigDecimal r0010_181to365days_pastdues) {
			this.r0010_181to365days_pastdues = r0010_181to365days_pastdues;
		}
		public BigDecimal getR0010_over365days_pastdues() {
			return r0010_over365days_pastdues;
		}
		public void setR0010_over365days_pastdues(BigDecimal r0010_over365days_pastdues) {
			this.r0010_over365days_pastdues = r0010_over365days_pastdues;
		}
		public BigDecimal getR0010_total_pastdues() {
			return r0010_total_pastdues;
		}
		public void setR0010_total_pastdues(BigDecimal r0010_total_pastdues) {
			this.r0010_total_pastdues = r0010_total_pastdues;
		}
		public BigDecimal getR0010_newloan_duringreport() {
			return r0010_newloan_duringreport;
		}
		public void setR0010_newloan_duringreport(BigDecimal r0010_newloan_duringreport) {
			this.r0010_newloan_duringreport = r0010_newloan_duringreport;
		}
		public BigDecimal getR0010_newstage_duringreport() {
			return r0010_newstage_duringreport;
		}
		public void setR0010_newstage_duringreport(BigDecimal r0010_newstage_duringreport) {
			this.r0010_newstage_duringreport = r0010_newstage_duringreport;
		}
		public BigDecimal getR0010_intrestfees_duringreport() {
			return r0010_intrestfees_duringreport;
		}
		public void setR0010_intrestfees_duringreport(BigDecimal r0010_intrestfees_duringreport) {
			this.r0010_intrestfees_duringreport = r0010_intrestfees_duringreport;
		}
		public BigDecimal getR0010_performingac_acinfo() {
			return r0010_performingac_acinfo;
		}
		public void setR0010_performingac_acinfo(BigDecimal r0010_performingac_acinfo) {
			this.r0010_performingac_acinfo = r0010_performingac_acinfo;
		}
		public BigDecimal getR0010_nonperformingac_acinfo() {
			return r0010_nonperformingac_acinfo;
		}
		public void setR0010_nonperformingac_acinfo(BigDecimal r0010_nonperformingac_acinfo) {
			this.r0010_nonperformingac_acinfo = r0010_nonperformingac_acinfo;
		}
		public String getR0020_product() {
			return r0020_product;
		}
		public void setR0020_product(String r0020_product) {
			this.r0020_product = r0020_product;
		}
		public BigDecimal getR0020_outstandbal() {
			return r0020_outstandbal;
		}
		public void setR0020_outstandbal(BigDecimal r0020_outstandbal) {
			this.r0020_outstandbal = r0020_outstandbal;
		}
		public BigDecimal getR0020_secured_outstandbal() {
			return r0020_secured_outstandbal;
		}
		public void setR0020_secured_outstandbal(BigDecimal r0020_secured_outstandbal) {
			this.r0020_secured_outstandbal = r0020_secured_outstandbal;
		}
		public BigDecimal getR0020_unsecured_outstandbal() {
			return r0020_unsecured_outstandbal;
		}
		public void setR0020_unsecured_outstandbal(BigDecimal r0020_unsecured_outstandbal) {
			this.r0020_unsecured_outstandbal = r0020_unsecured_outstandbal;
		}
		public BigDecimal getR0020_stage1_assetclass() {
			return r0020_stage1_assetclass;
		}
		public void setR0020_stage1_assetclass(BigDecimal r0020_stage1_assetclass) {
			this.r0020_stage1_assetclass = r0020_stage1_assetclass;
		}
		public BigDecimal getR0020_stage2_assetclass() {
			return r0020_stage2_assetclass;
		}
		public void setR0020_stage2_assetclass(BigDecimal r0020_stage2_assetclass) {
			this.r0020_stage2_assetclass = r0020_stage2_assetclass;
		}
		public BigDecimal getR0020_stage3a_assetclass() {
			return r0020_stage3a_assetclass;
		}
		public void setR0020_stage3a_assetclass(BigDecimal r0020_stage3a_assetclass) {
			this.r0020_stage3a_assetclass = r0020_stage3a_assetclass;
		}
		public BigDecimal getR0020_stage3b_assetclass() {
			return r0020_stage3b_assetclass;
		}
		public void setR0020_stage3b_assetclass(BigDecimal r0020_stage3b_assetclass) {
			this.r0020_stage3b_assetclass = r0020_stage3b_assetclass;
		}
		public BigDecimal getR0020_stage3c_assetclass() {
			return r0020_stage3c_assetclass;
		}
		public void setR0020_stage3c_assetclass(BigDecimal r0020_stage3c_assetclass) {
			this.r0020_stage3c_assetclass = r0020_stage3c_assetclass;
		}
		public BigDecimal getR0020_stage1_provisionheld() {
			return r0020_stage1_provisionheld;
		}
		public void setR0020_stage1_provisionheld(BigDecimal r0020_stage1_provisionheld) {
			this.r0020_stage1_provisionheld = r0020_stage1_provisionheld;
		}
		public BigDecimal getR0020_stage2_provisionheld() {
			return r0020_stage2_provisionheld;
		}
		public void setR0020_stage2_provisionheld(BigDecimal r0020_stage2_provisionheld) {
			this.r0020_stage2_provisionheld = r0020_stage2_provisionheld;
		}
		public BigDecimal getR0020_stage3a_provisionheld() {
			return r0020_stage3a_provisionheld;
		}
		public void setR0020_stage3a_provisionheld(BigDecimal r0020_stage3a_provisionheld) {
			this.r0020_stage3a_provisionheld = r0020_stage3a_provisionheld;
		}
		public BigDecimal getR0020_stage3b_provisionheld() {
			return r0020_stage3b_provisionheld;
		}
		public void setR0020_stage3b_provisionheld(BigDecimal r0020_stage3b_provisionheld) {
			this.r0020_stage3b_provisionheld = r0020_stage3b_provisionheld;
		}
		public BigDecimal getR0020_stage3c_provisionheld() {
			return r0020_stage3c_provisionheld;
		}
		public void setR0020_stage3c_provisionheld(BigDecimal r0020_stage3c_provisionheld) {
			this.r0020_stage3c_provisionheld = r0020_stage3c_provisionheld;
		}
		public BigDecimal getR0020_intrestfees_provisionheld() {
			return r0020_intrestfees_provisionheld;
		}
		public void setR0020_intrestfees_provisionheld(BigDecimal r0020_intrestfees_provisionheld) {
			this.r0020_intrestfees_provisionheld = r0020_intrestfees_provisionheld;
		}
		public BigDecimal getR0020_intrestsuspense_provisionheld() {
			return r0020_intrestsuspense_provisionheld;
		}
		public void setR0020_intrestsuspense_provisionheld(BigDecimal r0020_intrestsuspense_provisionheld) {
			this.r0020_intrestsuspense_provisionheld = r0020_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0020_stage1_poci() {
			return r0020_stage1_poci;
		}
		public void setR0020_stage1_poci(BigDecimal r0020_stage1_poci) {
			this.r0020_stage1_poci = r0020_stage1_poci;
		}
		public BigDecimal getR0020_stage2_poci() {
			return r0020_stage2_poci;
		}
		public void setR0020_stage2_poci(BigDecimal r0020_stage2_poci) {
			this.r0020_stage2_poci = r0020_stage2_poci;
		}
		public BigDecimal getR0020_stage3a_poci() {
			return r0020_stage3a_poci;
		}
		public void setR0020_stage3a_poci(BigDecimal r0020_stage3a_poci) {
			this.r0020_stage3a_poci = r0020_stage3a_poci;
		}
		public BigDecimal getR0020_stage3b_poci() {
			return r0020_stage3b_poci;
		}
		public void setR0020_stage3b_poci(BigDecimal r0020_stage3b_poci) {
			this.r0020_stage3b_poci = r0020_stage3b_poci;
		}
		public BigDecimal getR0020_stage3c_poci() {
			return r0020_stage3c_poci;
		}
		public void setR0020_stage3c_poci(BigDecimal r0020_stage3c_poci) {
			this.r0020_stage3c_poci = r0020_stage3c_poci;
		}
		public BigDecimal getR0020_current_pastdues() {
			return r0020_current_pastdues;
		}
		public void setR0020_current_pastdues(BigDecimal r0020_current_pastdues) {
			this.r0020_current_pastdues = r0020_current_pastdues;
		}
		public BigDecimal getR0020_less30days_pastdues() {
			return r0020_less30days_pastdues;
		}
		public void setR0020_less30days_pastdues(BigDecimal r0020_less30days_pastdues) {
			this.r0020_less30days_pastdues = r0020_less30days_pastdues;
		}
		public BigDecimal getR0020_31to90days_pastdues() {
			return r0020_31to90days_pastdues;
		}
		public void setR0020_31to90days_pastdues(BigDecimal r0020_31to90days_pastdues) {
			this.r0020_31to90days_pastdues = r0020_31to90days_pastdues;
		}
		public BigDecimal getR0020_91to120days_pastdues() {
			return r0020_91to120days_pastdues;
		}
		public void setR0020_91to120days_pastdues(BigDecimal r0020_91to120days_pastdues) {
			this.r0020_91to120days_pastdues = r0020_91to120days_pastdues;
		}
		public BigDecimal getR0020_121to180days_pastdues() {
			return r0020_121to180days_pastdues;
		}
		public void setR0020_121to180days_pastdues(BigDecimal r0020_121to180days_pastdues) {
			this.r0020_121to180days_pastdues = r0020_121to180days_pastdues;
		}
		public BigDecimal getR0020_181to365days_pastdues() {
			return r0020_181to365days_pastdues;
		}
		public void setR0020_181to365days_pastdues(BigDecimal r0020_181to365days_pastdues) {
			this.r0020_181to365days_pastdues = r0020_181to365days_pastdues;
		}
		public BigDecimal getR0020_over365days_pastdues() {
			return r0020_over365days_pastdues;
		}
		public void setR0020_over365days_pastdues(BigDecimal r0020_over365days_pastdues) {
			this.r0020_over365days_pastdues = r0020_over365days_pastdues;
		}
		public BigDecimal getR0020_total_pastdues() {
			return r0020_total_pastdues;
		}
		public void setR0020_total_pastdues(BigDecimal r0020_total_pastdues) {
			this.r0020_total_pastdues = r0020_total_pastdues;
		}
		public BigDecimal getR0020_newloan_duringreport() {
			return r0020_newloan_duringreport;
		}
		public void setR0020_newloan_duringreport(BigDecimal r0020_newloan_duringreport) {
			this.r0020_newloan_duringreport = r0020_newloan_duringreport;
		}
		public BigDecimal getR0020_newstage_duringreport() {
			return r0020_newstage_duringreport;
		}
		public void setR0020_newstage_duringreport(BigDecimal r0020_newstage_duringreport) {
			this.r0020_newstage_duringreport = r0020_newstage_duringreport;
		}
		public BigDecimal getR0020_intrestfees_duringreport() {
			return r0020_intrestfees_duringreport;
		}
		public void setR0020_intrestfees_duringreport(BigDecimal r0020_intrestfees_duringreport) {
			this.r0020_intrestfees_duringreport = r0020_intrestfees_duringreport;
		}
		public BigDecimal getR0020_performingac_acinfo() {
			return r0020_performingac_acinfo;
		}
		public void setR0020_performingac_acinfo(BigDecimal r0020_performingac_acinfo) {
			this.r0020_performingac_acinfo = r0020_performingac_acinfo;
		}
		public BigDecimal getR0020_nonperformingac_acinfo() {
			return r0020_nonperformingac_acinfo;
		}
		public void setR0020_nonperformingac_acinfo(BigDecimal r0020_nonperformingac_acinfo) {
			this.r0020_nonperformingac_acinfo = r0020_nonperformingac_acinfo;
		}
		public String getR0030_product() {
			return r0030_product;
		}
		public void setR0030_product(String r0030_product) {
			this.r0030_product = r0030_product;
		}
		public BigDecimal getR0030_outstandbal() {
			return r0030_outstandbal;
		}
		public void setR0030_outstandbal(BigDecimal r0030_outstandbal) {
			this.r0030_outstandbal = r0030_outstandbal;
		}
		public BigDecimal getR0030_secured_outstandbal() {
			return r0030_secured_outstandbal;
		}
		public void setR0030_secured_outstandbal(BigDecimal r0030_secured_outstandbal) {
			this.r0030_secured_outstandbal = r0030_secured_outstandbal;
		}
		public BigDecimal getR0030_unsecured_outstandbal() {
			return r0030_unsecured_outstandbal;
		}
		public void setR0030_unsecured_outstandbal(BigDecimal r0030_unsecured_outstandbal) {
			this.r0030_unsecured_outstandbal = r0030_unsecured_outstandbal;
		}
		public BigDecimal getR0030_stage1_assetclass() {
			return r0030_stage1_assetclass;
		}
		public void setR0030_stage1_assetclass(BigDecimal r0030_stage1_assetclass) {
			this.r0030_stage1_assetclass = r0030_stage1_assetclass;
		}
		public BigDecimal getR0030_stage2_assetclass() {
			return r0030_stage2_assetclass;
		}
		public void setR0030_stage2_assetclass(BigDecimal r0030_stage2_assetclass) {
			this.r0030_stage2_assetclass = r0030_stage2_assetclass;
		}
		public BigDecimal getR0030_stage3a_assetclass() {
			return r0030_stage3a_assetclass;
		}
		public void setR0030_stage3a_assetclass(BigDecimal r0030_stage3a_assetclass) {
			this.r0030_stage3a_assetclass = r0030_stage3a_assetclass;
		}
		public BigDecimal getR0030_stage3b_assetclass() {
			return r0030_stage3b_assetclass;
		}
		public void setR0030_stage3b_assetclass(BigDecimal r0030_stage3b_assetclass) {
			this.r0030_stage3b_assetclass = r0030_stage3b_assetclass;
		}
		public BigDecimal getR0030_stage3c_assetclass() {
			return r0030_stage3c_assetclass;
		}
		public void setR0030_stage3c_assetclass(BigDecimal r0030_stage3c_assetclass) {
			this.r0030_stage3c_assetclass = r0030_stage3c_assetclass;
		}
		public BigDecimal getR0030_stage1_provisionheld() {
			return r0030_stage1_provisionheld;
		}
		public void setR0030_stage1_provisionheld(BigDecimal r0030_stage1_provisionheld) {
			this.r0030_stage1_provisionheld = r0030_stage1_provisionheld;
		}
		public BigDecimal getR0030_stage2_provisionheld() {
			return r0030_stage2_provisionheld;
		}
		public void setR0030_stage2_provisionheld(BigDecimal r0030_stage2_provisionheld) {
			this.r0030_stage2_provisionheld = r0030_stage2_provisionheld;
		}
		public BigDecimal getR0030_stage3a_provisionheld() {
			return r0030_stage3a_provisionheld;
		}
		public void setR0030_stage3a_provisionheld(BigDecimal r0030_stage3a_provisionheld) {
			this.r0030_stage3a_provisionheld = r0030_stage3a_provisionheld;
		}
		public BigDecimal getR0030_stage3b_provisionheld() {
			return r0030_stage3b_provisionheld;
		}
		public void setR0030_stage3b_provisionheld(BigDecimal r0030_stage3b_provisionheld) {
			this.r0030_stage3b_provisionheld = r0030_stage3b_provisionheld;
		}
		public BigDecimal getR0030_stage3c_provisionheld() {
			return r0030_stage3c_provisionheld;
		}
		public void setR0030_stage3c_provisionheld(BigDecimal r0030_stage3c_provisionheld) {
			this.r0030_stage3c_provisionheld = r0030_stage3c_provisionheld;
		}
		public BigDecimal getR0030_intrestfees_provisionheld() {
			return r0030_intrestfees_provisionheld;
		}
		public void setR0030_intrestfees_provisionheld(BigDecimal r0030_intrestfees_provisionheld) {
			this.r0030_intrestfees_provisionheld = r0030_intrestfees_provisionheld;
		}
		public BigDecimal getR0030_intrestsuspense_provisionheld() {
			return r0030_intrestsuspense_provisionheld;
		}
		public void setR0030_intrestsuspense_provisionheld(BigDecimal r0030_intrestsuspense_provisionheld) {
			this.r0030_intrestsuspense_provisionheld = r0030_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0030_stage1_poci() {
			return r0030_stage1_poci;
		}
		public void setR0030_stage1_poci(BigDecimal r0030_stage1_poci) {
			this.r0030_stage1_poci = r0030_stage1_poci;
		}
		public BigDecimal getR0030_stage2_poci() {
			return r0030_stage2_poci;
		}
		public void setR0030_stage2_poci(BigDecimal r0030_stage2_poci) {
			this.r0030_stage2_poci = r0030_stage2_poci;
		}
		public BigDecimal getR0030_stage3a_poci() {
			return r0030_stage3a_poci;
		}
		public void setR0030_stage3a_poci(BigDecimal r0030_stage3a_poci) {
			this.r0030_stage3a_poci = r0030_stage3a_poci;
		}
		public BigDecimal getR0030_stage3b_poci() {
			return r0030_stage3b_poci;
		}
		public void setR0030_stage3b_poci(BigDecimal r0030_stage3b_poci) {
			this.r0030_stage3b_poci = r0030_stage3b_poci;
		}
		public BigDecimal getR0030_stage3c_poci() {
			return r0030_stage3c_poci;
		}
		public void setR0030_stage3c_poci(BigDecimal r0030_stage3c_poci) {
			this.r0030_stage3c_poci = r0030_stage3c_poci;
		}
		public BigDecimal getR0030_current_pastdues() {
			return r0030_current_pastdues;
		}
		public void setR0030_current_pastdues(BigDecimal r0030_current_pastdues) {
			this.r0030_current_pastdues = r0030_current_pastdues;
		}
		public BigDecimal getR0030_less30days_pastdues() {
			return r0030_less30days_pastdues;
		}
		public void setR0030_less30days_pastdues(BigDecimal r0030_less30days_pastdues) {
			this.r0030_less30days_pastdues = r0030_less30days_pastdues;
		}
		public BigDecimal getR0030_31to90days_pastdues() {
			return r0030_31to90days_pastdues;
		}
		public void setR0030_31to90days_pastdues(BigDecimal r0030_31to90days_pastdues) {
			this.r0030_31to90days_pastdues = r0030_31to90days_pastdues;
		}
		public BigDecimal getR0030_91to120days_pastdues() {
			return r0030_91to120days_pastdues;
		}
		public void setR0030_91to120days_pastdues(BigDecimal r0030_91to120days_pastdues) {
			this.r0030_91to120days_pastdues = r0030_91to120days_pastdues;
		}
		public BigDecimal getR0030_121to180days_pastdues() {
			return r0030_121to180days_pastdues;
		}
		public void setR0030_121to180days_pastdues(BigDecimal r0030_121to180days_pastdues) {
			this.r0030_121to180days_pastdues = r0030_121to180days_pastdues;
		}
		public BigDecimal getR0030_181to365days_pastdues() {
			return r0030_181to365days_pastdues;
		}
		public void setR0030_181to365days_pastdues(BigDecimal r0030_181to365days_pastdues) {
			this.r0030_181to365days_pastdues = r0030_181to365days_pastdues;
		}
		public BigDecimal getR0030_over365days_pastdues() {
			return r0030_over365days_pastdues;
		}
		public void setR0030_over365days_pastdues(BigDecimal r0030_over365days_pastdues) {
			this.r0030_over365days_pastdues = r0030_over365days_pastdues;
		}
		public BigDecimal getR0030_total_pastdues() {
			return r0030_total_pastdues;
		}
		public void setR0030_total_pastdues(BigDecimal r0030_total_pastdues) {
			this.r0030_total_pastdues = r0030_total_pastdues;
		}
		public BigDecimal getR0030_newloan_duringreport() {
			return r0030_newloan_duringreport;
		}
		public void setR0030_newloan_duringreport(BigDecimal r0030_newloan_duringreport) {
			this.r0030_newloan_duringreport = r0030_newloan_duringreport;
		}
		public BigDecimal getR0030_newstage_duringreport() {
			return r0030_newstage_duringreport;
		}
		public void setR0030_newstage_duringreport(BigDecimal r0030_newstage_duringreport) {
			this.r0030_newstage_duringreport = r0030_newstage_duringreport;
		}
		public BigDecimal getR0030_intrestfees_duringreport() {
			return r0030_intrestfees_duringreport;
		}
		public void setR0030_intrestfees_duringreport(BigDecimal r0030_intrestfees_duringreport) {
			this.r0030_intrestfees_duringreport = r0030_intrestfees_duringreport;
		}
		public BigDecimal getR0030_performingac_acinfo() {
			return r0030_performingac_acinfo;
		}
		public void setR0030_performingac_acinfo(BigDecimal r0030_performingac_acinfo) {
			this.r0030_performingac_acinfo = r0030_performingac_acinfo;
		}
		public BigDecimal getR0030_nonperformingac_acinfo() {
			return r0030_nonperformingac_acinfo;
		}
		public void setR0030_nonperformingac_acinfo(BigDecimal r0030_nonperformingac_acinfo) {
			this.r0030_nonperformingac_acinfo = r0030_nonperformingac_acinfo;
		}
		public String getR0040_product() {
			return r0040_product;
		}
		public void setR0040_product(String r0040_product) {
			this.r0040_product = r0040_product;
		}
		public BigDecimal getR0040_outstandbal() {
			return r0040_outstandbal;
		}
		public void setR0040_outstandbal(BigDecimal r0040_outstandbal) {
			this.r0040_outstandbal = r0040_outstandbal;
		}
		public BigDecimal getR0040_secured_outstandbal() {
			return r0040_secured_outstandbal;
		}
		public void setR0040_secured_outstandbal(BigDecimal r0040_secured_outstandbal) {
			this.r0040_secured_outstandbal = r0040_secured_outstandbal;
		}
		public BigDecimal getR0040_unsecured_outstandbal() {
			return r0040_unsecured_outstandbal;
		}
		public void setR0040_unsecured_outstandbal(BigDecimal r0040_unsecured_outstandbal) {
			this.r0040_unsecured_outstandbal = r0040_unsecured_outstandbal;
		}
		public BigDecimal getR0040_stage1_assetclass() {
			return r0040_stage1_assetclass;
		}
		public void setR0040_stage1_assetclass(BigDecimal r0040_stage1_assetclass) {
			this.r0040_stage1_assetclass = r0040_stage1_assetclass;
		}
		public BigDecimal getR0040_stage2_assetclass() {
			return r0040_stage2_assetclass;
		}
		public void setR0040_stage2_assetclass(BigDecimal r0040_stage2_assetclass) {
			this.r0040_stage2_assetclass = r0040_stage2_assetclass;
		}
		public BigDecimal getR0040_stage3a_assetclass() {
			return r0040_stage3a_assetclass;
		}
		public void setR0040_stage3a_assetclass(BigDecimal r0040_stage3a_assetclass) {
			this.r0040_stage3a_assetclass = r0040_stage3a_assetclass;
		}
		public BigDecimal getR0040_stage3b_assetclass() {
			return r0040_stage3b_assetclass;
		}
		public void setR0040_stage3b_assetclass(BigDecimal r0040_stage3b_assetclass) {
			this.r0040_stage3b_assetclass = r0040_stage3b_assetclass;
		}
		public BigDecimal getR0040_stage3c_assetclass() {
			return r0040_stage3c_assetclass;
		}
		public void setR0040_stage3c_assetclass(BigDecimal r0040_stage3c_assetclass) {
			this.r0040_stage3c_assetclass = r0040_stage3c_assetclass;
		}
		public BigDecimal getR0040_stage1_provisionheld() {
			return r0040_stage1_provisionheld;
		}
		public void setR0040_stage1_provisionheld(BigDecimal r0040_stage1_provisionheld) {
			this.r0040_stage1_provisionheld = r0040_stage1_provisionheld;
		}
		public BigDecimal getR0040_stage2_provisionheld() {
			return r0040_stage2_provisionheld;
		}
		public void setR0040_stage2_provisionheld(BigDecimal r0040_stage2_provisionheld) {
			this.r0040_stage2_provisionheld = r0040_stage2_provisionheld;
		}
		public BigDecimal getR0040_stage3a_provisionheld() {
			return r0040_stage3a_provisionheld;
		}
		public void setR0040_stage3a_provisionheld(BigDecimal r0040_stage3a_provisionheld) {
			this.r0040_stage3a_provisionheld = r0040_stage3a_provisionheld;
		}
		public BigDecimal getR0040_stage3b_provisionheld() {
			return r0040_stage3b_provisionheld;
		}
		public void setR0040_stage3b_provisionheld(BigDecimal r0040_stage3b_provisionheld) {
			this.r0040_stage3b_provisionheld = r0040_stage3b_provisionheld;
		}
		public BigDecimal getR0040_stage3c_provisionheld() {
			return r0040_stage3c_provisionheld;
		}
		public void setR0040_stage3c_provisionheld(BigDecimal r0040_stage3c_provisionheld) {
			this.r0040_stage3c_provisionheld = r0040_stage3c_provisionheld;
		}
		public BigDecimal getR0040_intrestfees_provisionheld() {
			return r0040_intrestfees_provisionheld;
		}
		public void setR0040_intrestfees_provisionheld(BigDecimal r0040_intrestfees_provisionheld) {
			this.r0040_intrestfees_provisionheld = r0040_intrestfees_provisionheld;
		}
		public BigDecimal getR0040_intrestsuspense_provisionheld() {
			return r0040_intrestsuspense_provisionheld;
		}
		public void setR0040_intrestsuspense_provisionheld(BigDecimal r0040_intrestsuspense_provisionheld) {
			this.r0040_intrestsuspense_provisionheld = r0040_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0040_stage1_poci() {
			return r0040_stage1_poci;
		}
		public void setR0040_stage1_poci(BigDecimal r0040_stage1_poci) {
			this.r0040_stage1_poci = r0040_stage1_poci;
		}
		public BigDecimal getR0040_stage2_poci() {
			return r0040_stage2_poci;
		}
		public void setR0040_stage2_poci(BigDecimal r0040_stage2_poci) {
			this.r0040_stage2_poci = r0040_stage2_poci;
		}
		public BigDecimal getR0040_stage3a_poci() {
			return r0040_stage3a_poci;
		}
		public void setR0040_stage3a_poci(BigDecimal r0040_stage3a_poci) {
			this.r0040_stage3a_poci = r0040_stage3a_poci;
		}
		public BigDecimal getR0040_stage3b_poci() {
			return r0040_stage3b_poci;
		}
		public void setR0040_stage3b_poci(BigDecimal r0040_stage3b_poci) {
			this.r0040_stage3b_poci = r0040_stage3b_poci;
		}
		public BigDecimal getR0040_stage3c_poci() {
			return r0040_stage3c_poci;
		}
		public void setR0040_stage3c_poci(BigDecimal r0040_stage3c_poci) {
			this.r0040_stage3c_poci = r0040_stage3c_poci;
		}
		public BigDecimal getR0040_current_pastdues() {
			return r0040_current_pastdues;
		}
		public void setR0040_current_pastdues(BigDecimal r0040_current_pastdues) {
			this.r0040_current_pastdues = r0040_current_pastdues;
		}
		public BigDecimal getR0040_less30days_pastdues() {
			return r0040_less30days_pastdues;
		}
		public void setR0040_less30days_pastdues(BigDecimal r0040_less30days_pastdues) {
			this.r0040_less30days_pastdues = r0040_less30days_pastdues;
		}
		public BigDecimal getR0040_31to90days_pastdues() {
			return r0040_31to90days_pastdues;
		}
		public void setR0040_31to90days_pastdues(BigDecimal r0040_31to90days_pastdues) {
			this.r0040_31to90days_pastdues = r0040_31to90days_pastdues;
		}
		public BigDecimal getR0040_91to120days_pastdues() {
			return r0040_91to120days_pastdues;
		}
		public void setR0040_91to120days_pastdues(BigDecimal r0040_91to120days_pastdues) {
			this.r0040_91to120days_pastdues = r0040_91to120days_pastdues;
		}
		public BigDecimal getR0040_121to180days_pastdues() {
			return r0040_121to180days_pastdues;
		}
		public void setR0040_121to180days_pastdues(BigDecimal r0040_121to180days_pastdues) {
			this.r0040_121to180days_pastdues = r0040_121to180days_pastdues;
		}
		public BigDecimal getR0040_181to365days_pastdues() {
			return r0040_181to365days_pastdues;
		}
		public void setR0040_181to365days_pastdues(BigDecimal r0040_181to365days_pastdues) {
			this.r0040_181to365days_pastdues = r0040_181to365days_pastdues;
		}
		public BigDecimal getR0040_over365days_pastdues() {
			return r0040_over365days_pastdues;
		}
		public void setR0040_over365days_pastdues(BigDecimal r0040_over365days_pastdues) {
			this.r0040_over365days_pastdues = r0040_over365days_pastdues;
		}
		public BigDecimal getR0040_total_pastdues() {
			return r0040_total_pastdues;
		}
		public void setR0040_total_pastdues(BigDecimal r0040_total_pastdues) {
			this.r0040_total_pastdues = r0040_total_pastdues;
		}
		public BigDecimal getR0040_newloan_duringreport() {
			return r0040_newloan_duringreport;
		}
		public void setR0040_newloan_duringreport(BigDecimal r0040_newloan_duringreport) {
			this.r0040_newloan_duringreport = r0040_newloan_duringreport;
		}
		public BigDecimal getR0040_newstage_duringreport() {
			return r0040_newstage_duringreport;
		}
		public void setR0040_newstage_duringreport(BigDecimal r0040_newstage_duringreport) {
			this.r0040_newstage_duringreport = r0040_newstage_duringreport;
		}
		public BigDecimal getR0040_intrestfees_duringreport() {
			return r0040_intrestfees_duringreport;
		}
		public void setR0040_intrestfees_duringreport(BigDecimal r0040_intrestfees_duringreport) {
			this.r0040_intrestfees_duringreport = r0040_intrestfees_duringreport;
		}
		public BigDecimal getR0040_performingac_acinfo() {
			return r0040_performingac_acinfo;
		}
		public void setR0040_performingac_acinfo(BigDecimal r0040_performingac_acinfo) {
			this.r0040_performingac_acinfo = r0040_performingac_acinfo;
		}
		public BigDecimal getR0040_nonperformingac_acinfo() {
			return r0040_nonperformingac_acinfo;
		}
		public void setR0040_nonperformingac_acinfo(BigDecimal r0040_nonperformingac_acinfo) {
			this.r0040_nonperformingac_acinfo = r0040_nonperformingac_acinfo;
		}
		public String getR0050_product() {
			return r0050_product;
		}
		public void setR0050_product(String r0050_product) {
			this.r0050_product = r0050_product;
		}
		public BigDecimal getR0050_outstandbal() {
			return r0050_outstandbal;
		}
		public void setR0050_outstandbal(BigDecimal r0050_outstandbal) {
			this.r0050_outstandbal = r0050_outstandbal;
		}
		public BigDecimal getR0050_secured_outstandbal() {
			return r0050_secured_outstandbal;
		}
		public void setR0050_secured_outstandbal(BigDecimal r0050_secured_outstandbal) {
			this.r0050_secured_outstandbal = r0050_secured_outstandbal;
		}
		public BigDecimal getR0050_unsecured_outstandbal() {
			return r0050_unsecured_outstandbal;
		}
		public void setR0050_unsecured_outstandbal(BigDecimal r0050_unsecured_outstandbal) {
			this.r0050_unsecured_outstandbal = r0050_unsecured_outstandbal;
		}
		public BigDecimal getR0050_stage1_assetclass() {
			return r0050_stage1_assetclass;
		}
		public void setR0050_stage1_assetclass(BigDecimal r0050_stage1_assetclass) {
			this.r0050_stage1_assetclass = r0050_stage1_assetclass;
		}
		public BigDecimal getR0050_stage2_assetclass() {
			return r0050_stage2_assetclass;
		}
		public void setR0050_stage2_assetclass(BigDecimal r0050_stage2_assetclass) {
			this.r0050_stage2_assetclass = r0050_stage2_assetclass;
		}
		public BigDecimal getR0050_stage3a_assetclass() {
			return r0050_stage3a_assetclass;
		}
		public void setR0050_stage3a_assetclass(BigDecimal r0050_stage3a_assetclass) {
			this.r0050_stage3a_assetclass = r0050_stage3a_assetclass;
		}
		public BigDecimal getR0050_stage3b_assetclass() {
			return r0050_stage3b_assetclass;
		}
		public void setR0050_stage3b_assetclass(BigDecimal r0050_stage3b_assetclass) {
			this.r0050_stage3b_assetclass = r0050_stage3b_assetclass;
		}
		public BigDecimal getR0050_stage3c_assetclass() {
			return r0050_stage3c_assetclass;
		}
		public void setR0050_stage3c_assetclass(BigDecimal r0050_stage3c_assetclass) {
			this.r0050_stage3c_assetclass = r0050_stage3c_assetclass;
		}
		public BigDecimal getR0050_stage1_provisionheld() {
			return r0050_stage1_provisionheld;
		}
		public void setR0050_stage1_provisionheld(BigDecimal r0050_stage1_provisionheld) {
			this.r0050_stage1_provisionheld = r0050_stage1_provisionheld;
		}
		public BigDecimal getR0050_stage2_provisionheld() {
			return r0050_stage2_provisionheld;
		}
		public void setR0050_stage2_provisionheld(BigDecimal r0050_stage2_provisionheld) {
			this.r0050_stage2_provisionheld = r0050_stage2_provisionheld;
		}
		public BigDecimal getR0050_stage3a_provisionheld() {
			return r0050_stage3a_provisionheld;
		}
		public void setR0050_stage3a_provisionheld(BigDecimal r0050_stage3a_provisionheld) {
			this.r0050_stage3a_provisionheld = r0050_stage3a_provisionheld;
		}
		public BigDecimal getR0050_stage3b_provisionheld() {
			return r0050_stage3b_provisionheld;
		}
		public void setR0050_stage3b_provisionheld(BigDecimal r0050_stage3b_provisionheld) {
			this.r0050_stage3b_provisionheld = r0050_stage3b_provisionheld;
		}
		public BigDecimal getR0050_stage3c_provisionheld() {
			return r0050_stage3c_provisionheld;
		}
		public void setR0050_stage3c_provisionheld(BigDecimal r0050_stage3c_provisionheld) {
			this.r0050_stage3c_provisionheld = r0050_stage3c_provisionheld;
		}
		public BigDecimal getR0050_intrestfees_provisionheld() {
			return r0050_intrestfees_provisionheld;
		}
		public void setR0050_intrestfees_provisionheld(BigDecimal r0050_intrestfees_provisionheld) {
			this.r0050_intrestfees_provisionheld = r0050_intrestfees_provisionheld;
		}
		public BigDecimal getR0050_intrestsuspense_provisionheld() {
			return r0050_intrestsuspense_provisionheld;
		}
		public void setR0050_intrestsuspense_provisionheld(BigDecimal r0050_intrestsuspense_provisionheld) {
			this.r0050_intrestsuspense_provisionheld = r0050_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0050_stage1_poci() {
			return r0050_stage1_poci;
		}
		public void setR0050_stage1_poci(BigDecimal r0050_stage1_poci) {
			this.r0050_stage1_poci = r0050_stage1_poci;
		}
		public BigDecimal getR0050_stage2_poci() {
			return r0050_stage2_poci;
		}
		public void setR0050_stage2_poci(BigDecimal r0050_stage2_poci) {
			this.r0050_stage2_poci = r0050_stage2_poci;
		}
		public BigDecimal getR0050_stage3a_poci() {
			return r0050_stage3a_poci;
		}
		public void setR0050_stage3a_poci(BigDecimal r0050_stage3a_poci) {
			this.r0050_stage3a_poci = r0050_stage3a_poci;
		}
		public BigDecimal getR0050_stage3b_poci() {
			return r0050_stage3b_poci;
		}
		public void setR0050_stage3b_poci(BigDecimal r0050_stage3b_poci) {
			this.r0050_stage3b_poci = r0050_stage3b_poci;
		}
		public BigDecimal getR0050_stage3c_poci() {
			return r0050_stage3c_poci;
		}
		public void setR0050_stage3c_poci(BigDecimal r0050_stage3c_poci) {
			this.r0050_stage3c_poci = r0050_stage3c_poci;
		}
		public BigDecimal getR0050_current_pastdues() {
			return r0050_current_pastdues;
		}
		public void setR0050_current_pastdues(BigDecimal r0050_current_pastdues) {
			this.r0050_current_pastdues = r0050_current_pastdues;
		}
		public BigDecimal getR0050_less30days_pastdues() {
			return r0050_less30days_pastdues;
		}
		public void setR0050_less30days_pastdues(BigDecimal r0050_less30days_pastdues) {
			this.r0050_less30days_pastdues = r0050_less30days_pastdues;
		}
		public BigDecimal getR0050_31to90days_pastdues() {
			return r0050_31to90days_pastdues;
		}
		public void setR0050_31to90days_pastdues(BigDecimal r0050_31to90days_pastdues) {
			this.r0050_31to90days_pastdues = r0050_31to90days_pastdues;
		}
		public BigDecimal getR0050_91to120days_pastdues() {
			return r0050_91to120days_pastdues;
		}
		public void setR0050_91to120days_pastdues(BigDecimal r0050_91to120days_pastdues) {
			this.r0050_91to120days_pastdues = r0050_91to120days_pastdues;
		}
		public BigDecimal getR0050_121to180days_pastdues() {
			return r0050_121to180days_pastdues;
		}
		public void setR0050_121to180days_pastdues(BigDecimal r0050_121to180days_pastdues) {
			this.r0050_121to180days_pastdues = r0050_121to180days_pastdues;
		}
		public BigDecimal getR0050_181to365days_pastdues() {
			return r0050_181to365days_pastdues;
		}
		public void setR0050_181to365days_pastdues(BigDecimal r0050_181to365days_pastdues) {
			this.r0050_181to365days_pastdues = r0050_181to365days_pastdues;
		}
		public BigDecimal getR0050_over365days_pastdues() {
			return r0050_over365days_pastdues;
		}
		public void setR0050_over365days_pastdues(BigDecimal r0050_over365days_pastdues) {
			this.r0050_over365days_pastdues = r0050_over365days_pastdues;
		}
		public BigDecimal getR0050_total_pastdues() {
			return r0050_total_pastdues;
		}
		public void setR0050_total_pastdues(BigDecimal r0050_total_pastdues) {
			this.r0050_total_pastdues = r0050_total_pastdues;
		}
		public BigDecimal getR0050_newloan_duringreport() {
			return r0050_newloan_duringreport;
		}
		public void setR0050_newloan_duringreport(BigDecimal r0050_newloan_duringreport) {
			this.r0050_newloan_duringreport = r0050_newloan_duringreport;
		}
		public BigDecimal getR0050_newstage_duringreport() {
			return r0050_newstage_duringreport;
		}
		public void setR0050_newstage_duringreport(BigDecimal r0050_newstage_duringreport) {
			this.r0050_newstage_duringreport = r0050_newstage_duringreport;
		}
		public BigDecimal getR0050_intrestfees_duringreport() {
			return r0050_intrestfees_duringreport;
		}
		public void setR0050_intrestfees_duringreport(BigDecimal r0050_intrestfees_duringreport) {
			this.r0050_intrestfees_duringreport = r0050_intrestfees_duringreport;
		}
		public BigDecimal getR0050_performingac_acinfo() {
			return r0050_performingac_acinfo;
		}
		public void setR0050_performingac_acinfo(BigDecimal r0050_performingac_acinfo) {
			this.r0050_performingac_acinfo = r0050_performingac_acinfo;
		}
		public BigDecimal getR0050_nonperformingac_acinfo() {
			return r0050_nonperformingac_acinfo;
		}
		public void setR0050_nonperformingac_acinfo(BigDecimal r0050_nonperformingac_acinfo) {
			this.r0050_nonperformingac_acinfo = r0050_nonperformingac_acinfo;
		}
		public String getR0060_product() {
			return r0060_product;
		}
		public void setR0060_product(String r0060_product) {
			this.r0060_product = r0060_product;
		}
		public BigDecimal getR0060_outstandbal() {
			return r0060_outstandbal;
		}
		public void setR0060_outstandbal(BigDecimal r0060_outstandbal) {
			this.r0060_outstandbal = r0060_outstandbal;
		}
		public BigDecimal getR0060_secured_outstandbal() {
			return r0060_secured_outstandbal;
		}
		public void setR0060_secured_outstandbal(BigDecimal r0060_secured_outstandbal) {
			this.r0060_secured_outstandbal = r0060_secured_outstandbal;
		}
		public BigDecimal getR0060_unsecured_outstandbal() {
			return r0060_unsecured_outstandbal;
		}
		public void setR0060_unsecured_outstandbal(BigDecimal r0060_unsecured_outstandbal) {
			this.r0060_unsecured_outstandbal = r0060_unsecured_outstandbal;
		}
		public BigDecimal getR0060_stage1_assetclass() {
			return r0060_stage1_assetclass;
		}
		public void setR0060_stage1_assetclass(BigDecimal r0060_stage1_assetclass) {
			this.r0060_stage1_assetclass = r0060_stage1_assetclass;
		}
		public BigDecimal getR0060_stage2_assetclass() {
			return r0060_stage2_assetclass;
		}
		public void setR0060_stage2_assetclass(BigDecimal r0060_stage2_assetclass) {
			this.r0060_stage2_assetclass = r0060_stage2_assetclass;
		}
		public BigDecimal getR0060_stage3a_assetclass() {
			return r0060_stage3a_assetclass;
		}
		public void setR0060_stage3a_assetclass(BigDecimal r0060_stage3a_assetclass) {
			this.r0060_stage3a_assetclass = r0060_stage3a_assetclass;
		}
		public BigDecimal getR0060_stage3b_assetclass() {
			return r0060_stage3b_assetclass;
		}
		public void setR0060_stage3b_assetclass(BigDecimal r0060_stage3b_assetclass) {
			this.r0060_stage3b_assetclass = r0060_stage3b_assetclass;
		}
		public BigDecimal getR0060_stage3c_assetclass() {
			return r0060_stage3c_assetclass;
		}
		public void setR0060_stage3c_assetclass(BigDecimal r0060_stage3c_assetclass) {
			this.r0060_stage3c_assetclass = r0060_stage3c_assetclass;
		}
		public BigDecimal getR0060_stage1_provisionheld() {
			return r0060_stage1_provisionheld;
		}
		public void setR0060_stage1_provisionheld(BigDecimal r0060_stage1_provisionheld) {
			this.r0060_stage1_provisionheld = r0060_stage1_provisionheld;
		}
		public BigDecimal getR0060_stage2_provisionheld() {
			return r0060_stage2_provisionheld;
		}
		public void setR0060_stage2_provisionheld(BigDecimal r0060_stage2_provisionheld) {
			this.r0060_stage2_provisionheld = r0060_stage2_provisionheld;
		}
		public BigDecimal getR0060_stage3a_provisionheld() {
			return r0060_stage3a_provisionheld;
		}
		public void setR0060_stage3a_provisionheld(BigDecimal r0060_stage3a_provisionheld) {
			this.r0060_stage3a_provisionheld = r0060_stage3a_provisionheld;
		}
		public BigDecimal getR0060_stage3b_provisionheld() {
			return r0060_stage3b_provisionheld;
		}
		public void setR0060_stage3b_provisionheld(BigDecimal r0060_stage3b_provisionheld) {
			this.r0060_stage3b_provisionheld = r0060_stage3b_provisionheld;
		}
		public BigDecimal getR0060_stage3c_provisionheld() {
			return r0060_stage3c_provisionheld;
		}
		public void setR0060_stage3c_provisionheld(BigDecimal r0060_stage3c_provisionheld) {
			this.r0060_stage3c_provisionheld = r0060_stage3c_provisionheld;
		}
		public BigDecimal getR0060_intrestfees_provisionheld() {
			return r0060_intrestfees_provisionheld;
		}
		public void setR0060_intrestfees_provisionheld(BigDecimal r0060_intrestfees_provisionheld) {
			this.r0060_intrestfees_provisionheld = r0060_intrestfees_provisionheld;
		}
		public BigDecimal getR0060_intrestsuspense_provisionheld() {
			return r0060_intrestsuspense_provisionheld;
		}
		public void setR0060_intrestsuspense_provisionheld(BigDecimal r0060_intrestsuspense_provisionheld) {
			this.r0060_intrestsuspense_provisionheld = r0060_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0060_stage1_poci() {
			return r0060_stage1_poci;
		}
		public void setR0060_stage1_poci(BigDecimal r0060_stage1_poci) {
			this.r0060_stage1_poci = r0060_stage1_poci;
		}
		public BigDecimal getR0060_stage2_poci() {
			return r0060_stage2_poci;
		}
		public void setR0060_stage2_poci(BigDecimal r0060_stage2_poci) {
			this.r0060_stage2_poci = r0060_stage2_poci;
		}
		public BigDecimal getR0060_stage3a_poci() {
			return r0060_stage3a_poci;
		}
		public void setR0060_stage3a_poci(BigDecimal r0060_stage3a_poci) {
			this.r0060_stage3a_poci = r0060_stage3a_poci;
		}
		public BigDecimal getR0060_stage3b_poci() {
			return r0060_stage3b_poci;
		}
		public void setR0060_stage3b_poci(BigDecimal r0060_stage3b_poci) {
			this.r0060_stage3b_poci = r0060_stage3b_poci;
		}
		public BigDecimal getR0060_stage3c_poci() {
			return r0060_stage3c_poci;
		}
		public void setR0060_stage3c_poci(BigDecimal r0060_stage3c_poci) {
			this.r0060_stage3c_poci = r0060_stage3c_poci;
		}
		public BigDecimal getR0060_current_pastdues() {
			return r0060_current_pastdues;
		}
		public void setR0060_current_pastdues(BigDecimal r0060_current_pastdues) {
			this.r0060_current_pastdues = r0060_current_pastdues;
		}
		public BigDecimal getR0060_less30days_pastdues() {
			return r0060_less30days_pastdues;
		}
		public void setR0060_less30days_pastdues(BigDecimal r0060_less30days_pastdues) {
			this.r0060_less30days_pastdues = r0060_less30days_pastdues;
		}
		public BigDecimal getR0060_31to90days_pastdues() {
			return r0060_31to90days_pastdues;
		}
		public void setR0060_31to90days_pastdues(BigDecimal r0060_31to90days_pastdues) {
			this.r0060_31to90days_pastdues = r0060_31to90days_pastdues;
		}
		public BigDecimal getR0060_91to120days_pastdues() {
			return r0060_91to120days_pastdues;
		}
		public void setR0060_91to120days_pastdues(BigDecimal r0060_91to120days_pastdues) {
			this.r0060_91to120days_pastdues = r0060_91to120days_pastdues;
		}
		public BigDecimal getR0060_121to180days_pastdues() {
			return r0060_121to180days_pastdues;
		}
		public void setR0060_121to180days_pastdues(BigDecimal r0060_121to180days_pastdues) {
			this.r0060_121to180days_pastdues = r0060_121to180days_pastdues;
		}
		public BigDecimal getR0060_181to365days_pastdues() {
			return r0060_181to365days_pastdues;
		}
		public void setR0060_181to365days_pastdues(BigDecimal r0060_181to365days_pastdues) {
			this.r0060_181to365days_pastdues = r0060_181to365days_pastdues;
		}
		public BigDecimal getR0060_over365days_pastdues() {
			return r0060_over365days_pastdues;
		}
		public void setR0060_over365days_pastdues(BigDecimal r0060_over365days_pastdues) {
			this.r0060_over365days_pastdues = r0060_over365days_pastdues;
		}
		public BigDecimal getR0060_total_pastdues() {
			return r0060_total_pastdues;
		}
		public void setR0060_total_pastdues(BigDecimal r0060_total_pastdues) {
			this.r0060_total_pastdues = r0060_total_pastdues;
		}
		public BigDecimal getR0060_newloan_duringreport() {
			return r0060_newloan_duringreport;
		}
		public void setR0060_newloan_duringreport(BigDecimal r0060_newloan_duringreport) {
			this.r0060_newloan_duringreport = r0060_newloan_duringreport;
		}
		public BigDecimal getR0060_newstage_duringreport() {
			return r0060_newstage_duringreport;
		}
		public void setR0060_newstage_duringreport(BigDecimal r0060_newstage_duringreport) {
			this.r0060_newstage_duringreport = r0060_newstage_duringreport;
		}
		public BigDecimal getR0060_intrestfees_duringreport() {
			return r0060_intrestfees_duringreport;
		}
		public void setR0060_intrestfees_duringreport(BigDecimal r0060_intrestfees_duringreport) {
			this.r0060_intrestfees_duringreport = r0060_intrestfees_duringreport;
		}
		public BigDecimal getR0060_performingac_acinfo() {
			return r0060_performingac_acinfo;
		}
		public void setR0060_performingac_acinfo(BigDecimal r0060_performingac_acinfo) {
			this.r0060_performingac_acinfo = r0060_performingac_acinfo;
		}
		public BigDecimal getR0060_nonperformingac_acinfo() {
			return r0060_nonperformingac_acinfo;
		}
		public void setR0060_nonperformingac_acinfo(BigDecimal r0060_nonperformingac_acinfo) {
			this.r0060_nonperformingac_acinfo = r0060_nonperformingac_acinfo;
		}
		public String getR0070_product() {
			return r0070_product;
		}
		public void setR0070_product(String r0070_product) {
			this.r0070_product = r0070_product;
		}
		public BigDecimal getR0070_outstandbal() {
			return r0070_outstandbal;
		}
		public void setR0070_outstandbal(BigDecimal r0070_outstandbal) {
			this.r0070_outstandbal = r0070_outstandbal;
		}
		public BigDecimal getR0070_secured_outstandbal() {
			return r0070_secured_outstandbal;
		}
		public void setR0070_secured_outstandbal(BigDecimal r0070_secured_outstandbal) {
			this.r0070_secured_outstandbal = r0070_secured_outstandbal;
		}
		public BigDecimal getR0070_unsecured_outstandbal() {
			return r0070_unsecured_outstandbal;
		}
		public void setR0070_unsecured_outstandbal(BigDecimal r0070_unsecured_outstandbal) {
			this.r0070_unsecured_outstandbal = r0070_unsecured_outstandbal;
		}
		public BigDecimal getR0070_stage1_assetclass() {
			return r0070_stage1_assetclass;
		}
		public void setR0070_stage1_assetclass(BigDecimal r0070_stage1_assetclass) {
			this.r0070_stage1_assetclass = r0070_stage1_assetclass;
		}
		public BigDecimal getR0070_stage2_assetclass() {
			return r0070_stage2_assetclass;
		}
		public void setR0070_stage2_assetclass(BigDecimal r0070_stage2_assetclass) {
			this.r0070_stage2_assetclass = r0070_stage2_assetclass;
		}
		public BigDecimal getR0070_stage3a_assetclass() {
			return r0070_stage3a_assetclass;
		}
		public void setR0070_stage3a_assetclass(BigDecimal r0070_stage3a_assetclass) {
			this.r0070_stage3a_assetclass = r0070_stage3a_assetclass;
		}
		public BigDecimal getR0070_stage3b_assetclass() {
			return r0070_stage3b_assetclass;
		}
		public void setR0070_stage3b_assetclass(BigDecimal r0070_stage3b_assetclass) {
			this.r0070_stage3b_assetclass = r0070_stage3b_assetclass;
		}
		public BigDecimal getR0070_stage3c_assetclass() {
			return r0070_stage3c_assetclass;
		}
		public void setR0070_stage3c_assetclass(BigDecimal r0070_stage3c_assetclass) {
			this.r0070_stage3c_assetclass = r0070_stage3c_assetclass;
		}
		public BigDecimal getR0070_stage1_provisionheld() {
			return r0070_stage1_provisionheld;
		}
		public void setR0070_stage1_provisionheld(BigDecimal r0070_stage1_provisionheld) {
			this.r0070_stage1_provisionheld = r0070_stage1_provisionheld;
		}
		public BigDecimal getR0070_stage2_provisionheld() {
			return r0070_stage2_provisionheld;
		}
		public void setR0070_stage2_provisionheld(BigDecimal r0070_stage2_provisionheld) {
			this.r0070_stage2_provisionheld = r0070_stage2_provisionheld;
		}
		public BigDecimal getR0070_stage3a_provisionheld() {
			return r0070_stage3a_provisionheld;
		}
		public void setR0070_stage3a_provisionheld(BigDecimal r0070_stage3a_provisionheld) {
			this.r0070_stage3a_provisionheld = r0070_stage3a_provisionheld;
		}
		public BigDecimal getR0070_stage3b_provisionheld() {
			return r0070_stage3b_provisionheld;
		}
		public void setR0070_stage3b_provisionheld(BigDecimal r0070_stage3b_provisionheld) {
			this.r0070_stage3b_provisionheld = r0070_stage3b_provisionheld;
		}
		public BigDecimal getR0070_stage3c_provisionheld() {
			return r0070_stage3c_provisionheld;
		}
		public void setR0070_stage3c_provisionheld(BigDecimal r0070_stage3c_provisionheld) {
			this.r0070_stage3c_provisionheld = r0070_stage3c_provisionheld;
		}
		public BigDecimal getR0070_intrestfees_provisionheld() {
			return r0070_intrestfees_provisionheld;
		}
		public void setR0070_intrestfees_provisionheld(BigDecimal r0070_intrestfees_provisionheld) {
			this.r0070_intrestfees_provisionheld = r0070_intrestfees_provisionheld;
		}
		public BigDecimal getR0070_intrestsuspense_provisionheld() {
			return r0070_intrestsuspense_provisionheld;
		}
		public void setR0070_intrestsuspense_provisionheld(BigDecimal r0070_intrestsuspense_provisionheld) {
			this.r0070_intrestsuspense_provisionheld = r0070_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0070_stage1_poci() {
			return r0070_stage1_poci;
		}
		public void setR0070_stage1_poci(BigDecimal r0070_stage1_poci) {
			this.r0070_stage1_poci = r0070_stage1_poci;
		}
		public BigDecimal getR0070_stage2_poci() {
			return r0070_stage2_poci;
		}
		public void setR0070_stage2_poci(BigDecimal r0070_stage2_poci) {
			this.r0070_stage2_poci = r0070_stage2_poci;
		}
		public BigDecimal getR0070_stage3a_poci() {
			return r0070_stage3a_poci;
		}
		public void setR0070_stage3a_poci(BigDecimal r0070_stage3a_poci) {
			this.r0070_stage3a_poci = r0070_stage3a_poci;
		}
		public BigDecimal getR0070_stage3b_poci() {
			return r0070_stage3b_poci;
		}
		public void setR0070_stage3b_poci(BigDecimal r0070_stage3b_poci) {
			this.r0070_stage3b_poci = r0070_stage3b_poci;
		}
		public BigDecimal getR0070_stage3c_poci() {
			return r0070_stage3c_poci;
		}
		public void setR0070_stage3c_poci(BigDecimal r0070_stage3c_poci) {
			this.r0070_stage3c_poci = r0070_stage3c_poci;
		}
		public BigDecimal getR0070_current_pastdues() {
			return r0070_current_pastdues;
		}
		public void setR0070_current_pastdues(BigDecimal r0070_current_pastdues) {
			this.r0070_current_pastdues = r0070_current_pastdues;
		}
		public BigDecimal getR0070_less30days_pastdues() {
			return r0070_less30days_pastdues;
		}
		public void setR0070_less30days_pastdues(BigDecimal r0070_less30days_pastdues) {
			this.r0070_less30days_pastdues = r0070_less30days_pastdues;
		}
		public BigDecimal getR0070_31to90days_pastdues() {
			return r0070_31to90days_pastdues;
		}
		public void setR0070_31to90days_pastdues(BigDecimal r0070_31to90days_pastdues) {
			this.r0070_31to90days_pastdues = r0070_31to90days_pastdues;
		}
		public BigDecimal getR0070_91to120days_pastdues() {
			return r0070_91to120days_pastdues;
		}
		public void setR0070_91to120days_pastdues(BigDecimal r0070_91to120days_pastdues) {
			this.r0070_91to120days_pastdues = r0070_91to120days_pastdues;
		}
		public BigDecimal getR0070_121to180days_pastdues() {
			return r0070_121to180days_pastdues;
		}
		public void setR0070_121to180days_pastdues(BigDecimal r0070_121to180days_pastdues) {
			this.r0070_121to180days_pastdues = r0070_121to180days_pastdues;
		}
		public BigDecimal getR0070_181to365days_pastdues() {
			return r0070_181to365days_pastdues;
		}
		public void setR0070_181to365days_pastdues(BigDecimal r0070_181to365days_pastdues) {
			this.r0070_181to365days_pastdues = r0070_181to365days_pastdues;
		}
		public BigDecimal getR0070_over365days_pastdues() {
			return r0070_over365days_pastdues;
		}
		public void setR0070_over365days_pastdues(BigDecimal r0070_over365days_pastdues) {
			this.r0070_over365days_pastdues = r0070_over365days_pastdues;
		}
		public BigDecimal getR0070_total_pastdues() {
			return r0070_total_pastdues;
		}
		public void setR0070_total_pastdues(BigDecimal r0070_total_pastdues) {
			this.r0070_total_pastdues = r0070_total_pastdues;
		}
		public BigDecimal getR0070_newloan_duringreport() {
			return r0070_newloan_duringreport;
		}
		public void setR0070_newloan_duringreport(BigDecimal r0070_newloan_duringreport) {
			this.r0070_newloan_duringreport = r0070_newloan_duringreport;
		}
		public BigDecimal getR0070_newstage_duringreport() {
			return r0070_newstage_duringreport;
		}
		public void setR0070_newstage_duringreport(BigDecimal r0070_newstage_duringreport) {
			this.r0070_newstage_duringreport = r0070_newstage_duringreport;
		}
		public BigDecimal getR0070_intrestfees_duringreport() {
			return r0070_intrestfees_duringreport;
		}
		public void setR0070_intrestfees_duringreport(BigDecimal r0070_intrestfees_duringreport) {
			this.r0070_intrestfees_duringreport = r0070_intrestfees_duringreport;
		}
		public BigDecimal getR0070_performingac_acinfo() {
			return r0070_performingac_acinfo;
		}
		public void setR0070_performingac_acinfo(BigDecimal r0070_performingac_acinfo) {
			this.r0070_performingac_acinfo = r0070_performingac_acinfo;
		}
		public BigDecimal getR0070_nonperformingac_acinfo() {
			return r0070_nonperformingac_acinfo;
		}
		public void setR0070_nonperformingac_acinfo(BigDecimal r0070_nonperformingac_acinfo) {
			this.r0070_nonperformingac_acinfo = r0070_nonperformingac_acinfo;
		}
		public String getR0080_product() {
			return r0080_product;
		}
		public void setR0080_product(String r0080_product) {
			this.r0080_product = r0080_product;
		}
		public BigDecimal getR0080_outstandbal() {
			return r0080_outstandbal;
		}
		public void setR0080_outstandbal(BigDecimal r0080_outstandbal) {
			this.r0080_outstandbal = r0080_outstandbal;
		}
		public BigDecimal getR0080_secured_outstandbal() {
			return r0080_secured_outstandbal;
		}
		public void setR0080_secured_outstandbal(BigDecimal r0080_secured_outstandbal) {
			this.r0080_secured_outstandbal = r0080_secured_outstandbal;
		}
		public BigDecimal getR0080_unsecured_outstandbal() {
			return r0080_unsecured_outstandbal;
		}
		public void setR0080_unsecured_outstandbal(BigDecimal r0080_unsecured_outstandbal) {
			this.r0080_unsecured_outstandbal = r0080_unsecured_outstandbal;
		}
		public BigDecimal getR0080_stage1_assetclass() {
			return r0080_stage1_assetclass;
		}
		public void setR0080_stage1_assetclass(BigDecimal r0080_stage1_assetclass) {
			this.r0080_stage1_assetclass = r0080_stage1_assetclass;
		}
		public BigDecimal getR0080_stage2_assetclass() {
			return r0080_stage2_assetclass;
		}
		public void setR0080_stage2_assetclass(BigDecimal r0080_stage2_assetclass) {
			this.r0080_stage2_assetclass = r0080_stage2_assetclass;
		}
		public BigDecimal getR0080_stage3a_assetclass() {
			return r0080_stage3a_assetclass;
		}
		public void setR0080_stage3a_assetclass(BigDecimal r0080_stage3a_assetclass) {
			this.r0080_stage3a_assetclass = r0080_stage3a_assetclass;
		}
		public BigDecimal getR0080_stage3b_assetclass() {
			return r0080_stage3b_assetclass;
		}
		public void setR0080_stage3b_assetclass(BigDecimal r0080_stage3b_assetclass) {
			this.r0080_stage3b_assetclass = r0080_stage3b_assetclass;
		}
		public BigDecimal getR0080_stage3c_assetclass() {
			return r0080_stage3c_assetclass;
		}
		public void setR0080_stage3c_assetclass(BigDecimal r0080_stage3c_assetclass) {
			this.r0080_stage3c_assetclass = r0080_stage3c_assetclass;
		}
		public BigDecimal getR0080_stage1_provisionheld() {
			return r0080_stage1_provisionheld;
		}
		public void setR0080_stage1_provisionheld(BigDecimal r0080_stage1_provisionheld) {
			this.r0080_stage1_provisionheld = r0080_stage1_provisionheld;
		}
		public BigDecimal getR0080_stage2_provisionheld() {
			return r0080_stage2_provisionheld;
		}
		public void setR0080_stage2_provisionheld(BigDecimal r0080_stage2_provisionheld) {
			this.r0080_stage2_provisionheld = r0080_stage2_provisionheld;
		}
		public BigDecimal getR0080_stage3a_provisionheld() {
			return r0080_stage3a_provisionheld;
		}
		public void setR0080_stage3a_provisionheld(BigDecimal r0080_stage3a_provisionheld) {
			this.r0080_stage3a_provisionheld = r0080_stage3a_provisionheld;
		}
		public BigDecimal getR0080_stage3b_provisionheld() {
			return r0080_stage3b_provisionheld;
		}
		public void setR0080_stage3b_provisionheld(BigDecimal r0080_stage3b_provisionheld) {
			this.r0080_stage3b_provisionheld = r0080_stage3b_provisionheld;
		}
		public BigDecimal getR0080_stage3c_provisionheld() {
			return r0080_stage3c_provisionheld;
		}
		public void setR0080_stage3c_provisionheld(BigDecimal r0080_stage3c_provisionheld) {
			this.r0080_stage3c_provisionheld = r0080_stage3c_provisionheld;
		}
		public BigDecimal getR0080_intrestfees_provisionheld() {
			return r0080_intrestfees_provisionheld;
		}
		public void setR0080_intrestfees_provisionheld(BigDecimal r0080_intrestfees_provisionheld) {
			this.r0080_intrestfees_provisionheld = r0080_intrestfees_provisionheld;
		}
		public BigDecimal getR0080_intrestsuspense_provisionheld() {
			return r0080_intrestsuspense_provisionheld;
		}
		public void setR0080_intrestsuspense_provisionheld(BigDecimal r0080_intrestsuspense_provisionheld) {
			this.r0080_intrestsuspense_provisionheld = r0080_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0080_stage1_poci() {
			return r0080_stage1_poci;
		}
		public void setR0080_stage1_poci(BigDecimal r0080_stage1_poci) {
			this.r0080_stage1_poci = r0080_stage1_poci;
		}
		public BigDecimal getR0080_stage2_poci() {
			return r0080_stage2_poci;
		}
		public void setR0080_stage2_poci(BigDecimal r0080_stage2_poci) {
			this.r0080_stage2_poci = r0080_stage2_poci;
		}
		public BigDecimal getR0080_stage3a_poci() {
			return r0080_stage3a_poci;
		}
		public void setR0080_stage3a_poci(BigDecimal r0080_stage3a_poci) {
			this.r0080_stage3a_poci = r0080_stage3a_poci;
		}
		public BigDecimal getR0080_stage3b_poci() {
			return r0080_stage3b_poci;
		}
		public void setR0080_stage3b_poci(BigDecimal r0080_stage3b_poci) {
			this.r0080_stage3b_poci = r0080_stage3b_poci;
		}
		public BigDecimal getR0080_stage3c_poci() {
			return r0080_stage3c_poci;
		}
		public void setR0080_stage3c_poci(BigDecimal r0080_stage3c_poci) {
			this.r0080_stage3c_poci = r0080_stage3c_poci;
		}
		public BigDecimal getR0080_current_pastdues() {
			return r0080_current_pastdues;
		}
		public void setR0080_current_pastdues(BigDecimal r0080_current_pastdues) {
			this.r0080_current_pastdues = r0080_current_pastdues;
		}
		public BigDecimal getR0080_less30days_pastdues() {
			return r0080_less30days_pastdues;
		}
		public void setR0080_less30days_pastdues(BigDecimal r0080_less30days_pastdues) {
			this.r0080_less30days_pastdues = r0080_less30days_pastdues;
		}
		public BigDecimal getR0080_31to90days_pastdues() {
			return r0080_31to90days_pastdues;
		}
		public void setR0080_31to90days_pastdues(BigDecimal r0080_31to90days_pastdues) {
			this.r0080_31to90days_pastdues = r0080_31to90days_pastdues;
		}
		public BigDecimal getR0080_91to120days_pastdues() {
			return r0080_91to120days_pastdues;
		}
		public void setR0080_91to120days_pastdues(BigDecimal r0080_91to120days_pastdues) {
			this.r0080_91to120days_pastdues = r0080_91to120days_pastdues;
		}
		public BigDecimal getR0080_121to180days_pastdues() {
			return r0080_121to180days_pastdues;
		}
		public void setR0080_121to180days_pastdues(BigDecimal r0080_121to180days_pastdues) {
			this.r0080_121to180days_pastdues = r0080_121to180days_pastdues;
		}
		public BigDecimal getR0080_181to365days_pastdues() {
			return r0080_181to365days_pastdues;
		}
		public void setR0080_181to365days_pastdues(BigDecimal r0080_181to365days_pastdues) {
			this.r0080_181to365days_pastdues = r0080_181to365days_pastdues;
		}
		public BigDecimal getR0080_over365days_pastdues() {
			return r0080_over365days_pastdues;
		}
		public void setR0080_over365days_pastdues(BigDecimal r0080_over365days_pastdues) {
			this.r0080_over365days_pastdues = r0080_over365days_pastdues;
		}
		public BigDecimal getR0080_total_pastdues() {
			return r0080_total_pastdues;
		}
		public void setR0080_total_pastdues(BigDecimal r0080_total_pastdues) {
			this.r0080_total_pastdues = r0080_total_pastdues;
		}
		public BigDecimal getR0080_newloan_duringreport() {
			return r0080_newloan_duringreport;
		}
		public void setR0080_newloan_duringreport(BigDecimal r0080_newloan_duringreport) {
			this.r0080_newloan_duringreport = r0080_newloan_duringreport;
		}
		public BigDecimal getR0080_newstage_duringreport() {
			return r0080_newstage_duringreport;
		}
		public void setR0080_newstage_duringreport(BigDecimal r0080_newstage_duringreport) {
			this.r0080_newstage_duringreport = r0080_newstage_duringreport;
		}
		public BigDecimal getR0080_intrestfees_duringreport() {
			return r0080_intrestfees_duringreport;
		}
		public void setR0080_intrestfees_duringreport(BigDecimal r0080_intrestfees_duringreport) {
			this.r0080_intrestfees_duringreport = r0080_intrestfees_duringreport;
		}
		public BigDecimal getR0080_performingac_acinfo() {
			return r0080_performingac_acinfo;
		}
		public void setR0080_performingac_acinfo(BigDecimal r0080_performingac_acinfo) {
			this.r0080_performingac_acinfo = r0080_performingac_acinfo;
		}
		public BigDecimal getR0080_nonperformingac_acinfo() {
			return r0080_nonperformingac_acinfo;
		}
		public void setR0080_nonperformingac_acinfo(BigDecimal r0080_nonperformingac_acinfo) {
			this.r0080_nonperformingac_acinfo = r0080_nonperformingac_acinfo;
		}
		public String getR0090_product() {
			return r0090_product;
		}
		public void setR0090_product(String r0090_product) {
			this.r0090_product = r0090_product;
		}
		public BigDecimal getR0090_outstandbal() {
			return r0090_outstandbal;
		}
		public void setR0090_outstandbal(BigDecimal r0090_outstandbal) {
			this.r0090_outstandbal = r0090_outstandbal;
		}
		public BigDecimal getR0090_secured_outstandbal() {
			return r0090_secured_outstandbal;
		}
		public void setR0090_secured_outstandbal(BigDecimal r0090_secured_outstandbal) {
			this.r0090_secured_outstandbal = r0090_secured_outstandbal;
		}
		public BigDecimal getR0090_unsecured_outstandbal() {
			return r0090_unsecured_outstandbal;
		}
		public void setR0090_unsecured_outstandbal(BigDecimal r0090_unsecured_outstandbal) {
			this.r0090_unsecured_outstandbal = r0090_unsecured_outstandbal;
		}
		public BigDecimal getR0090_stage1_assetclass() {
			return r0090_stage1_assetclass;
		}
		public void setR0090_stage1_assetclass(BigDecimal r0090_stage1_assetclass) {
			this.r0090_stage1_assetclass = r0090_stage1_assetclass;
		}
		public BigDecimal getR0090_stage2_assetclass() {
			return r0090_stage2_assetclass;
		}
		public void setR0090_stage2_assetclass(BigDecimal r0090_stage2_assetclass) {
			this.r0090_stage2_assetclass = r0090_stage2_assetclass;
		}
		public BigDecimal getR0090_stage3a_assetclass() {
			return r0090_stage3a_assetclass;
		}
		public void setR0090_stage3a_assetclass(BigDecimal r0090_stage3a_assetclass) {
			this.r0090_stage3a_assetclass = r0090_stage3a_assetclass;
		}
		public BigDecimal getR0090_stage3b_assetclass() {
			return r0090_stage3b_assetclass;
		}
		public void setR0090_stage3b_assetclass(BigDecimal r0090_stage3b_assetclass) {
			this.r0090_stage3b_assetclass = r0090_stage3b_assetclass;
		}
		public BigDecimal getR0090_stage3c_assetclass() {
			return r0090_stage3c_assetclass;
		}
		public void setR0090_stage3c_assetclass(BigDecimal r0090_stage3c_assetclass) {
			this.r0090_stage3c_assetclass = r0090_stage3c_assetclass;
		}
		public BigDecimal getR0090_stage1_provisionheld() {
			return r0090_stage1_provisionheld;
		}
		public void setR0090_stage1_provisionheld(BigDecimal r0090_stage1_provisionheld) {
			this.r0090_stage1_provisionheld = r0090_stage1_provisionheld;
		}
		public BigDecimal getR0090_stage2_provisionheld() {
			return r0090_stage2_provisionheld;
		}
		public void setR0090_stage2_provisionheld(BigDecimal r0090_stage2_provisionheld) {
			this.r0090_stage2_provisionheld = r0090_stage2_provisionheld;
		}
		public BigDecimal getR0090_stage3a_provisionheld() {
			return r0090_stage3a_provisionheld;
		}
		public void setR0090_stage3a_provisionheld(BigDecimal r0090_stage3a_provisionheld) {
			this.r0090_stage3a_provisionheld = r0090_stage3a_provisionheld;
		}
		public BigDecimal getR0090_stage3b_provisionheld() {
			return r0090_stage3b_provisionheld;
		}
		public void setR0090_stage3b_provisionheld(BigDecimal r0090_stage3b_provisionheld) {
			this.r0090_stage3b_provisionheld = r0090_stage3b_provisionheld;
		}
		public BigDecimal getR0090_stage3c_provisionheld() {
			return r0090_stage3c_provisionheld;
		}
		public void setR0090_stage3c_provisionheld(BigDecimal r0090_stage3c_provisionheld) {
			this.r0090_stage3c_provisionheld = r0090_stage3c_provisionheld;
		}
		public BigDecimal getR0090_intrestfees_provisionheld() {
			return r0090_intrestfees_provisionheld;
		}
		public void setR0090_intrestfees_provisionheld(BigDecimal r0090_intrestfees_provisionheld) {
			this.r0090_intrestfees_provisionheld = r0090_intrestfees_provisionheld;
		}
		public BigDecimal getR0090_intrestsuspense_provisionheld() {
			return r0090_intrestsuspense_provisionheld;
		}
		public void setR0090_intrestsuspense_provisionheld(BigDecimal r0090_intrestsuspense_provisionheld) {
			this.r0090_intrestsuspense_provisionheld = r0090_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0090_stage1_poci() {
			return r0090_stage1_poci;
		}
		public void setR0090_stage1_poci(BigDecimal r0090_stage1_poci) {
			this.r0090_stage1_poci = r0090_stage1_poci;
		}
		public BigDecimal getR0090_stage2_poci() {
			return r0090_stage2_poci;
		}
		public void setR0090_stage2_poci(BigDecimal r0090_stage2_poci) {
			this.r0090_stage2_poci = r0090_stage2_poci;
		}
		public BigDecimal getR0090_stage3a_poci() {
			return r0090_stage3a_poci;
		}
		public void setR0090_stage3a_poci(BigDecimal r0090_stage3a_poci) {
			this.r0090_stage3a_poci = r0090_stage3a_poci;
		}
		public BigDecimal getR0090_stage3b_poci() {
			return r0090_stage3b_poci;
		}
		public void setR0090_stage3b_poci(BigDecimal r0090_stage3b_poci) {
			this.r0090_stage3b_poci = r0090_stage3b_poci;
		}
		public BigDecimal getR0090_stage3c_poci() {
			return r0090_stage3c_poci;
		}
		public void setR0090_stage3c_poci(BigDecimal r0090_stage3c_poci) {
			this.r0090_stage3c_poci = r0090_stage3c_poci;
		}
		public BigDecimal getR0090_current_pastdues() {
			return r0090_current_pastdues;
		}
		public void setR0090_current_pastdues(BigDecimal r0090_current_pastdues) {
			this.r0090_current_pastdues = r0090_current_pastdues;
		}
		public BigDecimal getR0090_less30days_pastdues() {
			return r0090_less30days_pastdues;
		}
		public void setR0090_less30days_pastdues(BigDecimal r0090_less30days_pastdues) {
			this.r0090_less30days_pastdues = r0090_less30days_pastdues;
		}
		public BigDecimal getR0090_31to90days_pastdues() {
			return r0090_31to90days_pastdues;
		}
		public void setR0090_31to90days_pastdues(BigDecimal r0090_31to90days_pastdues) {
			this.r0090_31to90days_pastdues = r0090_31to90days_pastdues;
		}
		public BigDecimal getR0090_91to120days_pastdues() {
			return r0090_91to120days_pastdues;
		}
		public void setR0090_91to120days_pastdues(BigDecimal r0090_91to120days_pastdues) {
			this.r0090_91to120days_pastdues = r0090_91to120days_pastdues;
		}
		public BigDecimal getR0090_121to180days_pastdues() {
			return r0090_121to180days_pastdues;
		}
		public void setR0090_121to180days_pastdues(BigDecimal r0090_121to180days_pastdues) {
			this.r0090_121to180days_pastdues = r0090_121to180days_pastdues;
		}
		public BigDecimal getR0090_181to365days_pastdues() {
			return r0090_181to365days_pastdues;
		}
		public void setR0090_181to365days_pastdues(BigDecimal r0090_181to365days_pastdues) {
			this.r0090_181to365days_pastdues = r0090_181to365days_pastdues;
		}
		public BigDecimal getR0090_over365days_pastdues() {
			return r0090_over365days_pastdues;
		}
		public void setR0090_over365days_pastdues(BigDecimal r0090_over365days_pastdues) {
			this.r0090_over365days_pastdues = r0090_over365days_pastdues;
		}
		public BigDecimal getR0090_total_pastdues() {
			return r0090_total_pastdues;
		}
		public void setR0090_total_pastdues(BigDecimal r0090_total_pastdues) {
			this.r0090_total_pastdues = r0090_total_pastdues;
		}
		public BigDecimal getR0090_newloan_duringreport() {
			return r0090_newloan_duringreport;
		}
		public void setR0090_newloan_duringreport(BigDecimal r0090_newloan_duringreport) {
			this.r0090_newloan_duringreport = r0090_newloan_duringreport;
		}
		public BigDecimal getR0090_newstage_duringreport() {
			return r0090_newstage_duringreport;
		}
		public void setR0090_newstage_duringreport(BigDecimal r0090_newstage_duringreport) {
			this.r0090_newstage_duringreport = r0090_newstage_duringreport;
		}
		public BigDecimal getR0090_intrestfees_duringreport() {
			return r0090_intrestfees_duringreport;
		}
		public void setR0090_intrestfees_duringreport(BigDecimal r0090_intrestfees_duringreport) {
			this.r0090_intrestfees_duringreport = r0090_intrestfees_duringreport;
		}
		public BigDecimal getR0090_performingac_acinfo() {
			return r0090_performingac_acinfo;
		}
		public void setR0090_performingac_acinfo(BigDecimal r0090_performingac_acinfo) {
			this.r0090_performingac_acinfo = r0090_performingac_acinfo;
		}
		public BigDecimal getR0090_nonperformingac_acinfo() {
			return r0090_nonperformingac_acinfo;
		}
		public void setR0090_nonperformingac_acinfo(BigDecimal r0090_nonperformingac_acinfo) {
			this.r0090_nonperformingac_acinfo = r0090_nonperformingac_acinfo;
		}
		public String getR0100_product() {
			return r0100_product;
		}
		public void setR0100_product(String r0100_product) {
			this.r0100_product = r0100_product;
		}
		public BigDecimal getR0100_outstandbal() {
			return r0100_outstandbal;
		}
		public void setR0100_outstandbal(BigDecimal r0100_outstandbal) {
			this.r0100_outstandbal = r0100_outstandbal;
		}
		public BigDecimal getR0100_secured_outstandbal() {
			return r0100_secured_outstandbal;
		}
		public void setR0100_secured_outstandbal(BigDecimal r0100_secured_outstandbal) {
			this.r0100_secured_outstandbal = r0100_secured_outstandbal;
		}
		public BigDecimal getR0100_unsecured_outstandbal() {
			return r0100_unsecured_outstandbal;
		}
		public void setR0100_unsecured_outstandbal(BigDecimal r0100_unsecured_outstandbal) {
			this.r0100_unsecured_outstandbal = r0100_unsecured_outstandbal;
		}
		public BigDecimal getR0100_stage1_assetclass() {
			return r0100_stage1_assetclass;
		}
		public void setR0100_stage1_assetclass(BigDecimal r0100_stage1_assetclass) {
			this.r0100_stage1_assetclass = r0100_stage1_assetclass;
		}
		public BigDecimal getR0100_stage2_assetclass() {
			return r0100_stage2_assetclass;
		}
		public void setR0100_stage2_assetclass(BigDecimal r0100_stage2_assetclass) {
			this.r0100_stage2_assetclass = r0100_stage2_assetclass;
		}
		public BigDecimal getR0100_stage3a_assetclass() {
			return r0100_stage3a_assetclass;
		}
		public void setR0100_stage3a_assetclass(BigDecimal r0100_stage3a_assetclass) {
			this.r0100_stage3a_assetclass = r0100_stage3a_assetclass;
		}
		public BigDecimal getR0100_stage3b_assetclass() {
			return r0100_stage3b_assetclass;
		}
		public void setR0100_stage3b_assetclass(BigDecimal r0100_stage3b_assetclass) {
			this.r0100_stage3b_assetclass = r0100_stage3b_assetclass;
		}
		public BigDecimal getR0100_stage3c_assetclass() {
			return r0100_stage3c_assetclass;
		}
		public void setR0100_stage3c_assetclass(BigDecimal r0100_stage3c_assetclass) {
			this.r0100_stage3c_assetclass = r0100_stage3c_assetclass;
		}
		public BigDecimal getR0100_stage1_provisionheld() {
			return r0100_stage1_provisionheld;
		}
		public void setR0100_stage1_provisionheld(BigDecimal r0100_stage1_provisionheld) {
			this.r0100_stage1_provisionheld = r0100_stage1_provisionheld;
		}
		public BigDecimal getR0100_stage2_provisionheld() {
			return r0100_stage2_provisionheld;
		}
		public void setR0100_stage2_provisionheld(BigDecimal r0100_stage2_provisionheld) {
			this.r0100_stage2_provisionheld = r0100_stage2_provisionheld;
		}
		public BigDecimal getR0100_stage3a_provisionheld() {
			return r0100_stage3a_provisionheld;
		}
		public void setR0100_stage3a_provisionheld(BigDecimal r0100_stage3a_provisionheld) {
			this.r0100_stage3a_provisionheld = r0100_stage3a_provisionheld;
		}
		public BigDecimal getR0100_stage3b_provisionheld() {
			return r0100_stage3b_provisionheld;
		}
		public void setR0100_stage3b_provisionheld(BigDecimal r0100_stage3b_provisionheld) {
			this.r0100_stage3b_provisionheld = r0100_stage3b_provisionheld;
		}
		public BigDecimal getR0100_stage3c_provisionheld() {
			return r0100_stage3c_provisionheld;
		}
		public void setR0100_stage3c_provisionheld(BigDecimal r0100_stage3c_provisionheld) {
			this.r0100_stage3c_provisionheld = r0100_stage3c_provisionheld;
		}
		public BigDecimal getR0100_intrestfees_provisionheld() {
			return r0100_intrestfees_provisionheld;
		}
		public void setR0100_intrestfees_provisionheld(BigDecimal r0100_intrestfees_provisionheld) {
			this.r0100_intrestfees_provisionheld = r0100_intrestfees_provisionheld;
		}
		public BigDecimal getR0100_intrestsuspense_provisionheld() {
			return r0100_intrestsuspense_provisionheld;
		}
		public void setR0100_intrestsuspense_provisionheld(BigDecimal r0100_intrestsuspense_provisionheld) {
			this.r0100_intrestsuspense_provisionheld = r0100_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0100_stage1_poci() {
			return r0100_stage1_poci;
		}
		public void setR0100_stage1_poci(BigDecimal r0100_stage1_poci) {
			this.r0100_stage1_poci = r0100_stage1_poci;
		}
		public BigDecimal getR0100_stage2_poci() {
			return r0100_stage2_poci;
		}
		public void setR0100_stage2_poci(BigDecimal r0100_stage2_poci) {
			this.r0100_stage2_poci = r0100_stage2_poci;
		}
		public BigDecimal getR0100_stage3a_poci() {
			return r0100_stage3a_poci;
		}
		public void setR0100_stage3a_poci(BigDecimal r0100_stage3a_poci) {
			this.r0100_stage3a_poci = r0100_stage3a_poci;
		}
		public BigDecimal getR0100_stage3b_poci() {
			return r0100_stage3b_poci;
		}
		public void setR0100_stage3b_poci(BigDecimal r0100_stage3b_poci) {
			this.r0100_stage3b_poci = r0100_stage3b_poci;
		}
		public BigDecimal getR0100_stage3c_poci() {
			return r0100_stage3c_poci;
		}
		public void setR0100_stage3c_poci(BigDecimal r0100_stage3c_poci) {
			this.r0100_stage3c_poci = r0100_stage3c_poci;
		}
		public BigDecimal getR0100_current_pastdues() {
			return r0100_current_pastdues;
		}
		public void setR0100_current_pastdues(BigDecimal r0100_current_pastdues) {
			this.r0100_current_pastdues = r0100_current_pastdues;
		}
		public BigDecimal getR0100_less30days_pastdues() {
			return r0100_less30days_pastdues;
		}
		public void setR0100_less30days_pastdues(BigDecimal r0100_less30days_pastdues) {
			this.r0100_less30days_pastdues = r0100_less30days_pastdues;
		}
		public BigDecimal getR0100_31to90days_pastdues() {
			return r0100_31to90days_pastdues;
		}
		public void setR0100_31to90days_pastdues(BigDecimal r0100_31to90days_pastdues) {
			this.r0100_31to90days_pastdues = r0100_31to90days_pastdues;
		}
		public BigDecimal getR0100_91to120days_pastdues() {
			return r0100_91to120days_pastdues;
		}
		public void setR0100_91to120days_pastdues(BigDecimal r0100_91to120days_pastdues) {
			this.r0100_91to120days_pastdues = r0100_91to120days_pastdues;
		}
		public BigDecimal getR0100_121to180days_pastdues() {
			return r0100_121to180days_pastdues;
		}
		public void setR0100_121to180days_pastdues(BigDecimal r0100_121to180days_pastdues) {
			this.r0100_121to180days_pastdues = r0100_121to180days_pastdues;
		}
		public BigDecimal getR0100_181to365days_pastdues() {
			return r0100_181to365days_pastdues;
		}
		public void setR0100_181to365days_pastdues(BigDecimal r0100_181to365days_pastdues) {
			this.r0100_181to365days_pastdues = r0100_181to365days_pastdues;
		}
		public BigDecimal getR0100_over365days_pastdues() {
			return r0100_over365days_pastdues;
		}
		public void setR0100_over365days_pastdues(BigDecimal r0100_over365days_pastdues) {
			this.r0100_over365days_pastdues = r0100_over365days_pastdues;
		}
		public BigDecimal getR0100_total_pastdues() {
			return r0100_total_pastdues;
		}
		public void setR0100_total_pastdues(BigDecimal r0100_total_pastdues) {
			this.r0100_total_pastdues = r0100_total_pastdues;
		}
		public BigDecimal getR0100_newloan_duringreport() {
			return r0100_newloan_duringreport;
		}
		public void setR0100_newloan_duringreport(BigDecimal r0100_newloan_duringreport) {
			this.r0100_newloan_duringreport = r0100_newloan_duringreport;
		}
		public BigDecimal getR0100_newstage_duringreport() {
			return r0100_newstage_duringreport;
		}
		public void setR0100_newstage_duringreport(BigDecimal r0100_newstage_duringreport) {
			this.r0100_newstage_duringreport = r0100_newstage_duringreport;
		}
		public BigDecimal getR0100_intrestfees_duringreport() {
			return r0100_intrestfees_duringreport;
		}
		public void setR0100_intrestfees_duringreport(BigDecimal r0100_intrestfees_duringreport) {
			this.r0100_intrestfees_duringreport = r0100_intrestfees_duringreport;
		}
		public BigDecimal getR0100_performingac_acinfo() {
			return r0100_performingac_acinfo;
		}
		public void setR0100_performingac_acinfo(BigDecimal r0100_performingac_acinfo) {
			this.r0100_performingac_acinfo = r0100_performingac_acinfo;
		}
		public BigDecimal getR0100_nonperformingac_acinfo() {
			return r0100_nonperformingac_acinfo;
		}
		public void setR0100_nonperformingac_acinfo(BigDecimal r0100_nonperformingac_acinfo) {
			this.r0100_nonperformingac_acinfo = r0100_nonperformingac_acinfo;
		}
		public String getR0110_product() {
			return r0110_product;
		}
		public void setR0110_product(String r0110_product) {
			this.r0110_product = r0110_product;
		}
		public BigDecimal getR0110_outstandbal() {
			return r0110_outstandbal;
		}
		public void setR0110_outstandbal(BigDecimal r0110_outstandbal) {
			this.r0110_outstandbal = r0110_outstandbal;
		}
		public BigDecimal getR0110_secured_outstandbal() {
			return r0110_secured_outstandbal;
		}
		public void setR0110_secured_outstandbal(BigDecimal r0110_secured_outstandbal) {
			this.r0110_secured_outstandbal = r0110_secured_outstandbal;
		}
		public BigDecimal getR0110_unsecured_outstandbal() {
			return r0110_unsecured_outstandbal;
		}
		public void setR0110_unsecured_outstandbal(BigDecimal r0110_unsecured_outstandbal) {
			this.r0110_unsecured_outstandbal = r0110_unsecured_outstandbal;
		}
		public BigDecimal getR0110_stage1_assetclass() {
			return r0110_stage1_assetclass;
		}
		public void setR0110_stage1_assetclass(BigDecimal r0110_stage1_assetclass) {
			this.r0110_stage1_assetclass = r0110_stage1_assetclass;
		}
		public BigDecimal getR0110_stage2_assetclass() {
			return r0110_stage2_assetclass;
		}
		public void setR0110_stage2_assetclass(BigDecimal r0110_stage2_assetclass) {
			this.r0110_stage2_assetclass = r0110_stage2_assetclass;
		}
		public BigDecimal getR0110_stage3a_assetclass() {
			return r0110_stage3a_assetclass;
		}
		public void setR0110_stage3a_assetclass(BigDecimal r0110_stage3a_assetclass) {
			this.r0110_stage3a_assetclass = r0110_stage3a_assetclass;
		}
		public BigDecimal getR0110_stage3b_assetclass() {
			return r0110_stage3b_assetclass;
		}
		public void setR0110_stage3b_assetclass(BigDecimal r0110_stage3b_assetclass) {
			this.r0110_stage3b_assetclass = r0110_stage3b_assetclass;
		}
		public BigDecimal getR0110_stage3c_assetclass() {
			return r0110_stage3c_assetclass;
		}
		public void setR0110_stage3c_assetclass(BigDecimal r0110_stage3c_assetclass) {
			this.r0110_stage3c_assetclass = r0110_stage3c_assetclass;
		}
		public BigDecimal getR0110_stage1_provisionheld() {
			return r0110_stage1_provisionheld;
		}
		public void setR0110_stage1_provisionheld(BigDecimal r0110_stage1_provisionheld) {
			this.r0110_stage1_provisionheld = r0110_stage1_provisionheld;
		}
		public BigDecimal getR0110_stage2_provisionheld() {
			return r0110_stage2_provisionheld;
		}
		public void setR0110_stage2_provisionheld(BigDecimal r0110_stage2_provisionheld) {
			this.r0110_stage2_provisionheld = r0110_stage2_provisionheld;
		}
		public BigDecimal getR0110_stage3a_provisionheld() {
			return r0110_stage3a_provisionheld;
		}
		public void setR0110_stage3a_provisionheld(BigDecimal r0110_stage3a_provisionheld) {
			this.r0110_stage3a_provisionheld = r0110_stage3a_provisionheld;
		}
		public BigDecimal getR0110_stage3b_provisionheld() {
			return r0110_stage3b_provisionheld;
		}
		public void setR0110_stage3b_provisionheld(BigDecimal r0110_stage3b_provisionheld) {
			this.r0110_stage3b_provisionheld = r0110_stage3b_provisionheld;
		}
		public BigDecimal getR0110_stage3c_provisionheld() {
			return r0110_stage3c_provisionheld;
		}
		public void setR0110_stage3c_provisionheld(BigDecimal r0110_stage3c_provisionheld) {
			this.r0110_stage3c_provisionheld = r0110_stage3c_provisionheld;
		}
		public BigDecimal getR0110_intrestfees_provisionheld() {
			return r0110_intrestfees_provisionheld;
		}
		public void setR0110_intrestfees_provisionheld(BigDecimal r0110_intrestfees_provisionheld) {
			this.r0110_intrestfees_provisionheld = r0110_intrestfees_provisionheld;
		}
		public BigDecimal getR0110_intrestsuspense_provisionheld() {
			return r0110_intrestsuspense_provisionheld;
		}
		public void setR0110_intrestsuspense_provisionheld(BigDecimal r0110_intrestsuspense_provisionheld) {
			this.r0110_intrestsuspense_provisionheld = r0110_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0110_stage1_poci() {
			return r0110_stage1_poci;
		}
		public void setR0110_stage1_poci(BigDecimal r0110_stage1_poci) {
			this.r0110_stage1_poci = r0110_stage1_poci;
		}
		public BigDecimal getR0110_stage2_poci() {
			return r0110_stage2_poci;
		}
		public void setR0110_stage2_poci(BigDecimal r0110_stage2_poci) {
			this.r0110_stage2_poci = r0110_stage2_poci;
		}
		public BigDecimal getR0110_stage3a_poci() {
			return r0110_stage3a_poci;
		}
		public void setR0110_stage3a_poci(BigDecimal r0110_stage3a_poci) {
			this.r0110_stage3a_poci = r0110_stage3a_poci;
		}
		public BigDecimal getR0110_stage3b_poci() {
			return r0110_stage3b_poci;
		}
		public void setR0110_stage3b_poci(BigDecimal r0110_stage3b_poci) {
			this.r0110_stage3b_poci = r0110_stage3b_poci;
		}
		public BigDecimal getR0110_stage3c_poci() {
			return r0110_stage3c_poci;
		}
		public void setR0110_stage3c_poci(BigDecimal r0110_stage3c_poci) {
			this.r0110_stage3c_poci = r0110_stage3c_poci;
		}
		public BigDecimal getR0110_current_pastdues() {
			return r0110_current_pastdues;
		}
		public void setR0110_current_pastdues(BigDecimal r0110_current_pastdues) {
			this.r0110_current_pastdues = r0110_current_pastdues;
		}
		public BigDecimal getR0110_less30days_pastdues() {
			return r0110_less30days_pastdues;
		}
		public void setR0110_less30days_pastdues(BigDecimal r0110_less30days_pastdues) {
			this.r0110_less30days_pastdues = r0110_less30days_pastdues;
		}
		public BigDecimal getR0110_31to90days_pastdues() {
			return r0110_31to90days_pastdues;
		}
		public void setR0110_31to90days_pastdues(BigDecimal r0110_31to90days_pastdues) {
			this.r0110_31to90days_pastdues = r0110_31to90days_pastdues;
		}
		public BigDecimal getR0110_91to120days_pastdues() {
			return r0110_91to120days_pastdues;
		}
		public void setR0110_91to120days_pastdues(BigDecimal r0110_91to120days_pastdues) {
			this.r0110_91to120days_pastdues = r0110_91to120days_pastdues;
		}
		public BigDecimal getR0110_121to180days_pastdues() {
			return r0110_121to180days_pastdues;
		}
		public void setR0110_121to180days_pastdues(BigDecimal r0110_121to180days_pastdues) {
			this.r0110_121to180days_pastdues = r0110_121to180days_pastdues;
		}
		public BigDecimal getR0110_181to365days_pastdues() {
			return r0110_181to365days_pastdues;
		}
		public void setR0110_181to365days_pastdues(BigDecimal r0110_181to365days_pastdues) {
			this.r0110_181to365days_pastdues = r0110_181to365days_pastdues;
		}
		public BigDecimal getR0110_over365days_pastdues() {
			return r0110_over365days_pastdues;
		}
		public void setR0110_over365days_pastdues(BigDecimal r0110_over365days_pastdues) {
			this.r0110_over365days_pastdues = r0110_over365days_pastdues;
		}
		public BigDecimal getR0110_total_pastdues() {
			return r0110_total_pastdues;
		}
		public void setR0110_total_pastdues(BigDecimal r0110_total_pastdues) {
			this.r0110_total_pastdues = r0110_total_pastdues;
		}
		public BigDecimal getR0110_newloan_duringreport() {
			return r0110_newloan_duringreport;
		}
		public void setR0110_newloan_duringreport(BigDecimal r0110_newloan_duringreport) {
			this.r0110_newloan_duringreport = r0110_newloan_duringreport;
		}
		public BigDecimal getR0110_newstage_duringreport() {
			return r0110_newstage_duringreport;
		}
		public void setR0110_newstage_duringreport(BigDecimal r0110_newstage_duringreport) {
			this.r0110_newstage_duringreport = r0110_newstage_duringreport;
		}
		public BigDecimal getR0110_intrestfees_duringreport() {
			return r0110_intrestfees_duringreport;
		}
		public void setR0110_intrestfees_duringreport(BigDecimal r0110_intrestfees_duringreport) {
			this.r0110_intrestfees_duringreport = r0110_intrestfees_duringreport;
		}
		public BigDecimal getR0110_performingac_acinfo() {
			return r0110_performingac_acinfo;
		}
		public void setR0110_performingac_acinfo(BigDecimal r0110_performingac_acinfo) {
			this.r0110_performingac_acinfo = r0110_performingac_acinfo;
		}
		public BigDecimal getR0110_nonperformingac_acinfo() {
			return r0110_nonperformingac_acinfo;
		}
		public void setR0110_nonperformingac_acinfo(BigDecimal r0110_nonperformingac_acinfo) {
			this.r0110_nonperformingac_acinfo = r0110_nonperformingac_acinfo;
		}
		public String getR0120_product() {
			return r0120_product;
		}
		public void setR0120_product(String r0120_product) {
			this.r0120_product = r0120_product;
		}
		public BigDecimal getR0120_outstandbal() {
			return r0120_outstandbal;
		}
		public void setR0120_outstandbal(BigDecimal r0120_outstandbal) {
			this.r0120_outstandbal = r0120_outstandbal;
		}
		public BigDecimal getR0120_secured_outstandbal() {
			return r0120_secured_outstandbal;
		}
		public void setR0120_secured_outstandbal(BigDecimal r0120_secured_outstandbal) {
			this.r0120_secured_outstandbal = r0120_secured_outstandbal;
		}
		public BigDecimal getR0120_unsecured_outstandbal() {
			return r0120_unsecured_outstandbal;
		}
		public void setR0120_unsecured_outstandbal(BigDecimal r0120_unsecured_outstandbal) {
			this.r0120_unsecured_outstandbal = r0120_unsecured_outstandbal;
		}
		public BigDecimal getR0120_stage1_assetclass() {
			return r0120_stage1_assetclass;
		}
		public void setR0120_stage1_assetclass(BigDecimal r0120_stage1_assetclass) {
			this.r0120_stage1_assetclass = r0120_stage1_assetclass;
		}
		public BigDecimal getR0120_stage2_assetclass() {
			return r0120_stage2_assetclass;
		}
		public void setR0120_stage2_assetclass(BigDecimal r0120_stage2_assetclass) {
			this.r0120_stage2_assetclass = r0120_stage2_assetclass;
		}
		public BigDecimal getR0120_stage3a_assetclass() {
			return r0120_stage3a_assetclass;
		}
		public void setR0120_stage3a_assetclass(BigDecimal r0120_stage3a_assetclass) {
			this.r0120_stage3a_assetclass = r0120_stage3a_assetclass;
		}
		public BigDecimal getR0120_stage3b_assetclass() {
			return r0120_stage3b_assetclass;
		}
		public void setR0120_stage3b_assetclass(BigDecimal r0120_stage3b_assetclass) {
			this.r0120_stage3b_assetclass = r0120_stage3b_assetclass;
		}
		public BigDecimal getR0120_stage3c_assetclass() {
			return r0120_stage3c_assetclass;
		}
		public void setR0120_stage3c_assetclass(BigDecimal r0120_stage3c_assetclass) {
			this.r0120_stage3c_assetclass = r0120_stage3c_assetclass;
		}
		public BigDecimal getR0120_stage1_provisionheld() {
			return r0120_stage1_provisionheld;
		}
		public void setR0120_stage1_provisionheld(BigDecimal r0120_stage1_provisionheld) {
			this.r0120_stage1_provisionheld = r0120_stage1_provisionheld;
		}
		public BigDecimal getR0120_stage2_provisionheld() {
			return r0120_stage2_provisionheld;
		}
		public void setR0120_stage2_provisionheld(BigDecimal r0120_stage2_provisionheld) {
			this.r0120_stage2_provisionheld = r0120_stage2_provisionheld;
		}
		public BigDecimal getR0120_stage3a_provisionheld() {
			return r0120_stage3a_provisionheld;
		}
		public void setR0120_stage3a_provisionheld(BigDecimal r0120_stage3a_provisionheld) {
			this.r0120_stage3a_provisionheld = r0120_stage3a_provisionheld;
		}
		public BigDecimal getR0120_stage3b_provisionheld() {
			return r0120_stage3b_provisionheld;
		}
		public void setR0120_stage3b_provisionheld(BigDecimal r0120_stage3b_provisionheld) {
			this.r0120_stage3b_provisionheld = r0120_stage3b_provisionheld;
		}
		public BigDecimal getR0120_stage3c_provisionheld() {
			return r0120_stage3c_provisionheld;
		}
		public void setR0120_stage3c_provisionheld(BigDecimal r0120_stage3c_provisionheld) {
			this.r0120_stage3c_provisionheld = r0120_stage3c_provisionheld;
		}
		public BigDecimal getR0120_intrestfees_provisionheld() {
			return r0120_intrestfees_provisionheld;
		}
		public void setR0120_intrestfees_provisionheld(BigDecimal r0120_intrestfees_provisionheld) {
			this.r0120_intrestfees_provisionheld = r0120_intrestfees_provisionheld;
		}
		public BigDecimal getR0120_intrestsuspense_provisionheld() {
			return r0120_intrestsuspense_provisionheld;
		}
		public void setR0120_intrestsuspense_provisionheld(BigDecimal r0120_intrestsuspense_provisionheld) {
			this.r0120_intrestsuspense_provisionheld = r0120_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0120_stage1_poci() {
			return r0120_stage1_poci;
		}
		public void setR0120_stage1_poci(BigDecimal r0120_stage1_poci) {
			this.r0120_stage1_poci = r0120_stage1_poci;
		}
		public BigDecimal getR0120_stage2_poci() {
			return r0120_stage2_poci;
		}
		public void setR0120_stage2_poci(BigDecimal r0120_stage2_poci) {
			this.r0120_stage2_poci = r0120_stage2_poci;
		}
		public BigDecimal getR0120_stage3a_poci() {
			return r0120_stage3a_poci;
		}
		public void setR0120_stage3a_poci(BigDecimal r0120_stage3a_poci) {
			this.r0120_stage3a_poci = r0120_stage3a_poci;
		}
		public BigDecimal getR0120_stage3b_poci() {
			return r0120_stage3b_poci;
		}
		public void setR0120_stage3b_poci(BigDecimal r0120_stage3b_poci) {
			this.r0120_stage3b_poci = r0120_stage3b_poci;
		}
		public BigDecimal getR0120_stage3c_poci() {
			return r0120_stage3c_poci;
		}
		public void setR0120_stage3c_poci(BigDecimal r0120_stage3c_poci) {
			this.r0120_stage3c_poci = r0120_stage3c_poci;
		}
		public BigDecimal getR0120_current_pastdues() {
			return r0120_current_pastdues;
		}
		public void setR0120_current_pastdues(BigDecimal r0120_current_pastdues) {
			this.r0120_current_pastdues = r0120_current_pastdues;
		}
		public BigDecimal getR0120_less30days_pastdues() {
			return r0120_less30days_pastdues;
		}
		public void setR0120_less30days_pastdues(BigDecimal r0120_less30days_pastdues) {
			this.r0120_less30days_pastdues = r0120_less30days_pastdues;
		}
		public BigDecimal getR0120_31to90days_pastdues() {
			return r0120_31to90days_pastdues;
		}
		public void setR0120_31to90days_pastdues(BigDecimal r0120_31to90days_pastdues) {
			this.r0120_31to90days_pastdues = r0120_31to90days_pastdues;
		}
		public BigDecimal getR0120_91to120days_pastdues() {
			return r0120_91to120days_pastdues;
		}
		public void setR0120_91to120days_pastdues(BigDecimal r0120_91to120days_pastdues) {
			this.r0120_91to120days_pastdues = r0120_91to120days_pastdues;
		}
		public BigDecimal getR0120_121to180days_pastdues() {
			return r0120_121to180days_pastdues;
		}
		public void setR0120_121to180days_pastdues(BigDecimal r0120_121to180days_pastdues) {
			this.r0120_121to180days_pastdues = r0120_121to180days_pastdues;
		}
		public BigDecimal getR0120_181to365days_pastdues() {
			return r0120_181to365days_pastdues;
		}
		public void setR0120_181to365days_pastdues(BigDecimal r0120_181to365days_pastdues) {
			this.r0120_181to365days_pastdues = r0120_181to365days_pastdues;
		}
		public BigDecimal getR0120_over365days_pastdues() {
			return r0120_over365days_pastdues;
		}
		public void setR0120_over365days_pastdues(BigDecimal r0120_over365days_pastdues) {
			this.r0120_over365days_pastdues = r0120_over365days_pastdues;
		}
		public BigDecimal getR0120_total_pastdues() {
			return r0120_total_pastdues;
		}
		public void setR0120_total_pastdues(BigDecimal r0120_total_pastdues) {
			this.r0120_total_pastdues = r0120_total_pastdues;
		}
		public BigDecimal getR0120_newloan_duringreport() {
			return r0120_newloan_duringreport;
		}
		public void setR0120_newloan_duringreport(BigDecimal r0120_newloan_duringreport) {
			this.r0120_newloan_duringreport = r0120_newloan_duringreport;
		}
		public BigDecimal getR0120_newstage_duringreport() {
			return r0120_newstage_duringreport;
		}
		public void setR0120_newstage_duringreport(BigDecimal r0120_newstage_duringreport) {
			this.r0120_newstage_duringreport = r0120_newstage_duringreport;
		}
		public BigDecimal getR0120_intrestfees_duringreport() {
			return r0120_intrestfees_duringreport;
		}
		public void setR0120_intrestfees_duringreport(BigDecimal r0120_intrestfees_duringreport) {
			this.r0120_intrestfees_duringreport = r0120_intrestfees_duringreport;
		}
		public BigDecimal getR0120_performingac_acinfo() {
			return r0120_performingac_acinfo;
		}
		public void setR0120_performingac_acinfo(BigDecimal r0120_performingac_acinfo) {
			this.r0120_performingac_acinfo = r0120_performingac_acinfo;
		}
		public BigDecimal getR0120_nonperformingac_acinfo() {
			return r0120_nonperformingac_acinfo;
		}
		public void setR0120_nonperformingac_acinfo(BigDecimal r0120_nonperformingac_acinfo) {
			this.r0120_nonperformingac_acinfo = r0120_nonperformingac_acinfo;
		}
		public String getR0130_product() {
			return r0130_product;
		}
		public void setR0130_product(String r0130_product) {
			this.r0130_product = r0130_product;
		}
		public BigDecimal getR0130_outstandbal() {
			return r0130_outstandbal;
		}
		public void setR0130_outstandbal(BigDecimal r0130_outstandbal) {
			this.r0130_outstandbal = r0130_outstandbal;
		}
		public BigDecimal getR0130_secured_outstandbal() {
			return r0130_secured_outstandbal;
		}
		public void setR0130_secured_outstandbal(BigDecimal r0130_secured_outstandbal) {
			this.r0130_secured_outstandbal = r0130_secured_outstandbal;
		}
		public BigDecimal getR0130_unsecured_outstandbal() {
			return r0130_unsecured_outstandbal;
		}
		public void setR0130_unsecured_outstandbal(BigDecimal r0130_unsecured_outstandbal) {
			this.r0130_unsecured_outstandbal = r0130_unsecured_outstandbal;
		}
		public BigDecimal getR0130_stage1_assetclass() {
			return r0130_stage1_assetclass;
		}
		public void setR0130_stage1_assetclass(BigDecimal r0130_stage1_assetclass) {
			this.r0130_stage1_assetclass = r0130_stage1_assetclass;
		}
		public BigDecimal getR0130_stage2_assetclass() {
			return r0130_stage2_assetclass;
		}
		public void setR0130_stage2_assetclass(BigDecimal r0130_stage2_assetclass) {
			this.r0130_stage2_assetclass = r0130_stage2_assetclass;
		}
		public BigDecimal getR0130_stage3a_assetclass() {
			return r0130_stage3a_assetclass;
		}
		public void setR0130_stage3a_assetclass(BigDecimal r0130_stage3a_assetclass) {
			this.r0130_stage3a_assetclass = r0130_stage3a_assetclass;
		}
		public BigDecimal getR0130_stage3b_assetclass() {
			return r0130_stage3b_assetclass;
		}
		public void setR0130_stage3b_assetclass(BigDecimal r0130_stage3b_assetclass) {
			this.r0130_stage3b_assetclass = r0130_stage3b_assetclass;
		}
		public BigDecimal getR0130_stage3c_assetclass() {
			return r0130_stage3c_assetclass;
		}
		public void setR0130_stage3c_assetclass(BigDecimal r0130_stage3c_assetclass) {
			this.r0130_stage3c_assetclass = r0130_stage3c_assetclass;
		}
		public BigDecimal getR0130_stage1_provisionheld() {
			return r0130_stage1_provisionheld;
		}
		public void setR0130_stage1_provisionheld(BigDecimal r0130_stage1_provisionheld) {
			this.r0130_stage1_provisionheld = r0130_stage1_provisionheld;
		}
		public BigDecimal getR0130_stage2_provisionheld() {
			return r0130_stage2_provisionheld;
		}
		public void setR0130_stage2_provisionheld(BigDecimal r0130_stage2_provisionheld) {
			this.r0130_stage2_provisionheld = r0130_stage2_provisionheld;
		}
		public BigDecimal getR0130_stage3a_provisionheld() {
			return r0130_stage3a_provisionheld;
		}
		public void setR0130_stage3a_provisionheld(BigDecimal r0130_stage3a_provisionheld) {
			this.r0130_stage3a_provisionheld = r0130_stage3a_provisionheld;
		}
		public BigDecimal getR0130_stage3b_provisionheld() {
			return r0130_stage3b_provisionheld;
		}
		public void setR0130_stage3b_provisionheld(BigDecimal r0130_stage3b_provisionheld) {
			this.r0130_stage3b_provisionheld = r0130_stage3b_provisionheld;
		}
		public BigDecimal getR0130_stage3c_provisionheld() {
			return r0130_stage3c_provisionheld;
		}
		public void setR0130_stage3c_provisionheld(BigDecimal r0130_stage3c_provisionheld) {
			this.r0130_stage3c_provisionheld = r0130_stage3c_provisionheld;
		}
		public BigDecimal getR0130_intrestfees_provisionheld() {
			return r0130_intrestfees_provisionheld;
		}
		public void setR0130_intrestfees_provisionheld(BigDecimal r0130_intrestfees_provisionheld) {
			this.r0130_intrestfees_provisionheld = r0130_intrestfees_provisionheld;
		}
		public BigDecimal getR0130_intrestsuspense_provisionheld() {
			return r0130_intrestsuspense_provisionheld;
		}
		public void setR0130_intrestsuspense_provisionheld(BigDecimal r0130_intrestsuspense_provisionheld) {
			this.r0130_intrestsuspense_provisionheld = r0130_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0130_stage1_poci() {
			return r0130_stage1_poci;
		}
		public void setR0130_stage1_poci(BigDecimal r0130_stage1_poci) {
			this.r0130_stage1_poci = r0130_stage1_poci;
		}
		public BigDecimal getR0130_stage2_poci() {
			return r0130_stage2_poci;
		}
		public void setR0130_stage2_poci(BigDecimal r0130_stage2_poci) {
			this.r0130_stage2_poci = r0130_stage2_poci;
		}
		public BigDecimal getR0130_stage3a_poci() {
			return r0130_stage3a_poci;
		}
		public void setR0130_stage3a_poci(BigDecimal r0130_stage3a_poci) {
			this.r0130_stage3a_poci = r0130_stage3a_poci;
		}
		public BigDecimal getR0130_stage3b_poci() {
			return r0130_stage3b_poci;
		}
		public void setR0130_stage3b_poci(BigDecimal r0130_stage3b_poci) {
			this.r0130_stage3b_poci = r0130_stage3b_poci;
		}
		public BigDecimal getR0130_stage3c_poci() {
			return r0130_stage3c_poci;
		}
		public void setR0130_stage3c_poci(BigDecimal r0130_stage3c_poci) {
			this.r0130_stage3c_poci = r0130_stage3c_poci;
		}
		public BigDecimal getR0130_current_pastdues() {
			return r0130_current_pastdues;
		}
		public void setR0130_current_pastdues(BigDecimal r0130_current_pastdues) {
			this.r0130_current_pastdues = r0130_current_pastdues;
		}
		public BigDecimal getR0130_less30days_pastdues() {
			return r0130_less30days_pastdues;
		}
		public void setR0130_less30days_pastdues(BigDecimal r0130_less30days_pastdues) {
			this.r0130_less30days_pastdues = r0130_less30days_pastdues;
		}
		public BigDecimal getR0130_31to90days_pastdues() {
			return r0130_31to90days_pastdues;
		}
		public void setR0130_31to90days_pastdues(BigDecimal r0130_31to90days_pastdues) {
			this.r0130_31to90days_pastdues = r0130_31to90days_pastdues;
		}
		public BigDecimal getR0130_91to120days_pastdues() {
			return r0130_91to120days_pastdues;
		}
		public void setR0130_91to120days_pastdues(BigDecimal r0130_91to120days_pastdues) {
			this.r0130_91to120days_pastdues = r0130_91to120days_pastdues;
		}
		public BigDecimal getR0130_121to180days_pastdues() {
			return r0130_121to180days_pastdues;
		}
		public void setR0130_121to180days_pastdues(BigDecimal r0130_121to180days_pastdues) {
			this.r0130_121to180days_pastdues = r0130_121to180days_pastdues;
		}
		public BigDecimal getR0130_181to365days_pastdues() {
			return r0130_181to365days_pastdues;
		}
		public void setR0130_181to365days_pastdues(BigDecimal r0130_181to365days_pastdues) {
			this.r0130_181to365days_pastdues = r0130_181to365days_pastdues;
		}
		public BigDecimal getR0130_over365days_pastdues() {
			return r0130_over365days_pastdues;
		}
		public void setR0130_over365days_pastdues(BigDecimal r0130_over365days_pastdues) {
			this.r0130_over365days_pastdues = r0130_over365days_pastdues;
		}
		public BigDecimal getR0130_total_pastdues() {
			return r0130_total_pastdues;
		}
		public void setR0130_total_pastdues(BigDecimal r0130_total_pastdues) {
			this.r0130_total_pastdues = r0130_total_pastdues;
		}
		public BigDecimal getR0130_newloan_duringreport() {
			return r0130_newloan_duringreport;
		}
		public void setR0130_newloan_duringreport(BigDecimal r0130_newloan_duringreport) {
			this.r0130_newloan_duringreport = r0130_newloan_duringreport;
		}
		public BigDecimal getR0130_newstage_duringreport() {
			return r0130_newstage_duringreport;
		}
		public void setR0130_newstage_duringreport(BigDecimal r0130_newstage_duringreport) {
			this.r0130_newstage_duringreport = r0130_newstage_duringreport;
		}
		public BigDecimal getR0130_intrestfees_duringreport() {
			return r0130_intrestfees_duringreport;
		}
		public void setR0130_intrestfees_duringreport(BigDecimal r0130_intrestfees_duringreport) {
			this.r0130_intrestfees_duringreport = r0130_intrestfees_duringreport;
		}
		public BigDecimal getR0130_performingac_acinfo() {
			return r0130_performingac_acinfo;
		}
		public void setR0130_performingac_acinfo(BigDecimal r0130_performingac_acinfo) {
			this.r0130_performingac_acinfo = r0130_performingac_acinfo;
		}
		public BigDecimal getR0130_nonperformingac_acinfo() {
			return r0130_nonperformingac_acinfo;
		}
		public void setR0130_nonperformingac_acinfo(BigDecimal r0130_nonperformingac_acinfo) {
			this.r0130_nonperformingac_acinfo = r0130_nonperformingac_acinfo;
		}
		public String getR0140_product() {
			return r0140_product;
		}
		public void setR0140_product(String r0140_product) {
			this.r0140_product = r0140_product;
		}
		public BigDecimal getR0140_outstandbal() {
			return r0140_outstandbal;
		}
		public void setR0140_outstandbal(BigDecimal r0140_outstandbal) {
			this.r0140_outstandbal = r0140_outstandbal;
		}
		public BigDecimal getR0140_secured_outstandbal() {
			return r0140_secured_outstandbal;
		}
		public void setR0140_secured_outstandbal(BigDecimal r0140_secured_outstandbal) {
			this.r0140_secured_outstandbal = r0140_secured_outstandbal;
		}
		public BigDecimal getR0140_unsecured_outstandbal() {
			return r0140_unsecured_outstandbal;
		}
		public void setR0140_unsecured_outstandbal(BigDecimal r0140_unsecured_outstandbal) {
			this.r0140_unsecured_outstandbal = r0140_unsecured_outstandbal;
		}
		public BigDecimal getR0140_stage1_assetclass() {
			return r0140_stage1_assetclass;
		}
		public void setR0140_stage1_assetclass(BigDecimal r0140_stage1_assetclass) {
			this.r0140_stage1_assetclass = r0140_stage1_assetclass;
		}
		public BigDecimal getR0140_stage2_assetclass() {
			return r0140_stage2_assetclass;
		}
		public void setR0140_stage2_assetclass(BigDecimal r0140_stage2_assetclass) {
			this.r0140_stage2_assetclass = r0140_stage2_assetclass;
		}
		public BigDecimal getR0140_stage3a_assetclass() {
			return r0140_stage3a_assetclass;
		}
		public void setR0140_stage3a_assetclass(BigDecimal r0140_stage3a_assetclass) {
			this.r0140_stage3a_assetclass = r0140_stage3a_assetclass;
		}
		public BigDecimal getR0140_stage3b_assetclass() {
			return r0140_stage3b_assetclass;
		}
		public void setR0140_stage3b_assetclass(BigDecimal r0140_stage3b_assetclass) {
			this.r0140_stage3b_assetclass = r0140_stage3b_assetclass;
		}
		public BigDecimal getR0140_stage3c_assetclass() {
			return r0140_stage3c_assetclass;
		}
		public void setR0140_stage3c_assetclass(BigDecimal r0140_stage3c_assetclass) {
			this.r0140_stage3c_assetclass = r0140_stage3c_assetclass;
		}
		public BigDecimal getR0140_stage1_provisionheld() {
			return r0140_stage1_provisionheld;
		}
		public void setR0140_stage1_provisionheld(BigDecimal r0140_stage1_provisionheld) {
			this.r0140_stage1_provisionheld = r0140_stage1_provisionheld;
		}
		public BigDecimal getR0140_stage2_provisionheld() {
			return r0140_stage2_provisionheld;
		}
		public void setR0140_stage2_provisionheld(BigDecimal r0140_stage2_provisionheld) {
			this.r0140_stage2_provisionheld = r0140_stage2_provisionheld;
		}
		public BigDecimal getR0140_stage3a_provisionheld() {
			return r0140_stage3a_provisionheld;
		}
		public void setR0140_stage3a_provisionheld(BigDecimal r0140_stage3a_provisionheld) {
			this.r0140_stage3a_provisionheld = r0140_stage3a_provisionheld;
		}
		public BigDecimal getR0140_stage3b_provisionheld() {
			return r0140_stage3b_provisionheld;
		}
		public void setR0140_stage3b_provisionheld(BigDecimal r0140_stage3b_provisionheld) {
			this.r0140_stage3b_provisionheld = r0140_stage3b_provisionheld;
		}
		public BigDecimal getR0140_stage3c_provisionheld() {
			return r0140_stage3c_provisionheld;
		}
		public void setR0140_stage3c_provisionheld(BigDecimal r0140_stage3c_provisionheld) {
			this.r0140_stage3c_provisionheld = r0140_stage3c_provisionheld;
		}
		public BigDecimal getR0140_intrestfees_provisionheld() {
			return r0140_intrestfees_provisionheld;
		}
		public void setR0140_intrestfees_provisionheld(BigDecimal r0140_intrestfees_provisionheld) {
			this.r0140_intrestfees_provisionheld = r0140_intrestfees_provisionheld;
		}
		public BigDecimal getR0140_intrestsuspense_provisionheld() {
			return r0140_intrestsuspense_provisionheld;
		}
		public void setR0140_intrestsuspense_provisionheld(BigDecimal r0140_intrestsuspense_provisionheld) {
			this.r0140_intrestsuspense_provisionheld = r0140_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0140_stage1_poci() {
			return r0140_stage1_poci;
		}
		public void setR0140_stage1_poci(BigDecimal r0140_stage1_poci) {
			this.r0140_stage1_poci = r0140_stage1_poci;
		}
		public BigDecimal getR0140_stage2_poci() {
			return r0140_stage2_poci;
		}
		public void setR0140_stage2_poci(BigDecimal r0140_stage2_poci) {
			this.r0140_stage2_poci = r0140_stage2_poci;
		}
		public BigDecimal getR0140_stage3a_poci() {
			return r0140_stage3a_poci;
		}
		public void setR0140_stage3a_poci(BigDecimal r0140_stage3a_poci) {
			this.r0140_stage3a_poci = r0140_stage3a_poci;
		}
		public BigDecimal getR0140_stage3b_poci() {
			return r0140_stage3b_poci;
		}
		public void setR0140_stage3b_poci(BigDecimal r0140_stage3b_poci) {
			this.r0140_stage3b_poci = r0140_stage3b_poci;
		}
		public BigDecimal getR0140_stage3c_poci() {
			return r0140_stage3c_poci;
		}
		public void setR0140_stage3c_poci(BigDecimal r0140_stage3c_poci) {
			this.r0140_stage3c_poci = r0140_stage3c_poci;
		}
		public BigDecimal getR0140_current_pastdues() {
			return r0140_current_pastdues;
		}
		public void setR0140_current_pastdues(BigDecimal r0140_current_pastdues) {
			this.r0140_current_pastdues = r0140_current_pastdues;
		}
		public BigDecimal getR0140_less30days_pastdues() {
			return r0140_less30days_pastdues;
		}
		public void setR0140_less30days_pastdues(BigDecimal r0140_less30days_pastdues) {
			this.r0140_less30days_pastdues = r0140_less30days_pastdues;
		}
		public BigDecimal getR0140_31to90days_pastdues() {
			return r0140_31to90days_pastdues;
		}
		public void setR0140_31to90days_pastdues(BigDecimal r0140_31to90days_pastdues) {
			this.r0140_31to90days_pastdues = r0140_31to90days_pastdues;
		}
		public BigDecimal getR0140_91to120days_pastdues() {
			return r0140_91to120days_pastdues;
		}
		public void setR0140_91to120days_pastdues(BigDecimal r0140_91to120days_pastdues) {
			this.r0140_91to120days_pastdues = r0140_91to120days_pastdues;
		}
		public BigDecimal getR0140_121to180days_pastdues() {
			return r0140_121to180days_pastdues;
		}
		public void setR0140_121to180days_pastdues(BigDecimal r0140_121to180days_pastdues) {
			this.r0140_121to180days_pastdues = r0140_121to180days_pastdues;
		}
		public BigDecimal getR0140_181to365days_pastdues() {
			return r0140_181to365days_pastdues;
		}
		public void setR0140_181to365days_pastdues(BigDecimal r0140_181to365days_pastdues) {
			this.r0140_181to365days_pastdues = r0140_181to365days_pastdues;
		}
		public BigDecimal getR0140_over365days_pastdues() {
			return r0140_over365days_pastdues;
		}
		public void setR0140_over365days_pastdues(BigDecimal r0140_over365days_pastdues) {
			this.r0140_over365days_pastdues = r0140_over365days_pastdues;
		}
		public BigDecimal getR0140_total_pastdues() {
			return r0140_total_pastdues;
		}
		public void setR0140_total_pastdues(BigDecimal r0140_total_pastdues) {
			this.r0140_total_pastdues = r0140_total_pastdues;
		}
		public BigDecimal getR0140_newloan_duringreport() {
			return r0140_newloan_duringreport;
		}
		public void setR0140_newloan_duringreport(BigDecimal r0140_newloan_duringreport) {
			this.r0140_newloan_duringreport = r0140_newloan_duringreport;
		}
		public BigDecimal getR0140_newstage_duringreport() {
			return r0140_newstage_duringreport;
		}
		public void setR0140_newstage_duringreport(BigDecimal r0140_newstage_duringreport) {
			this.r0140_newstage_duringreport = r0140_newstage_duringreport;
		}
		public BigDecimal getR0140_intrestfees_duringreport() {
			return r0140_intrestfees_duringreport;
		}
		public void setR0140_intrestfees_duringreport(BigDecimal r0140_intrestfees_duringreport) {
			this.r0140_intrestfees_duringreport = r0140_intrestfees_duringreport;
		}
		public BigDecimal getR0140_performingac_acinfo() {
			return r0140_performingac_acinfo;
		}
		public void setR0140_performingac_acinfo(BigDecimal r0140_performingac_acinfo) {
			this.r0140_performingac_acinfo = r0140_performingac_acinfo;
		}
		public BigDecimal getR0140_nonperformingac_acinfo() {
			return r0140_nonperformingac_acinfo;
		}
		public void setR0140_nonperformingac_acinfo(BigDecimal r0140_nonperformingac_acinfo) {
			this.r0140_nonperformingac_acinfo = r0140_nonperformingac_acinfo;
		}
		public String getR0150_product() {
			return r0150_product;
		}
		public void setR0150_product(String r0150_product) {
			this.r0150_product = r0150_product;
		}
		public BigDecimal getR0150_outstandbal() {
			return r0150_outstandbal;
		}
		public void setR0150_outstandbal(BigDecimal r0150_outstandbal) {
			this.r0150_outstandbal = r0150_outstandbal;
		}
		public BigDecimal getR0150_secured_outstandbal() {
			return r0150_secured_outstandbal;
		}
		public void setR0150_secured_outstandbal(BigDecimal r0150_secured_outstandbal) {
			this.r0150_secured_outstandbal = r0150_secured_outstandbal;
		}
		public BigDecimal getR0150_unsecured_outstandbal() {
			return r0150_unsecured_outstandbal;
		}
		public void setR0150_unsecured_outstandbal(BigDecimal r0150_unsecured_outstandbal) {
			this.r0150_unsecured_outstandbal = r0150_unsecured_outstandbal;
		}
		public BigDecimal getR0150_stage1_assetclass() {
			return r0150_stage1_assetclass;
		}
		public void setR0150_stage1_assetclass(BigDecimal r0150_stage1_assetclass) {
			this.r0150_stage1_assetclass = r0150_stage1_assetclass;
		}
		public BigDecimal getR0150_stage2_assetclass() {
			return r0150_stage2_assetclass;
		}
		public void setR0150_stage2_assetclass(BigDecimal r0150_stage2_assetclass) {
			this.r0150_stage2_assetclass = r0150_stage2_assetclass;
		}
		public BigDecimal getR0150_stage3a_assetclass() {
			return r0150_stage3a_assetclass;
		}
		public void setR0150_stage3a_assetclass(BigDecimal r0150_stage3a_assetclass) {
			this.r0150_stage3a_assetclass = r0150_stage3a_assetclass;
		}
		public BigDecimal getR0150_stage3b_assetclass() {
			return r0150_stage3b_assetclass;
		}
		public void setR0150_stage3b_assetclass(BigDecimal r0150_stage3b_assetclass) {
			this.r0150_stage3b_assetclass = r0150_stage3b_assetclass;
		}
		public BigDecimal getR0150_stage3c_assetclass() {
			return r0150_stage3c_assetclass;
		}
		public void setR0150_stage3c_assetclass(BigDecimal r0150_stage3c_assetclass) {
			this.r0150_stage3c_assetclass = r0150_stage3c_assetclass;
		}
		public BigDecimal getR0150_stage1_provisionheld() {
			return r0150_stage1_provisionheld;
		}
		public void setR0150_stage1_provisionheld(BigDecimal r0150_stage1_provisionheld) {
			this.r0150_stage1_provisionheld = r0150_stage1_provisionheld;
		}
		public BigDecimal getR0150_stage2_provisionheld() {
			return r0150_stage2_provisionheld;
		}
		public void setR0150_stage2_provisionheld(BigDecimal r0150_stage2_provisionheld) {
			this.r0150_stage2_provisionheld = r0150_stage2_provisionheld;
		}
		public BigDecimal getR0150_stage3a_provisionheld() {
			return r0150_stage3a_provisionheld;
		}
		public void setR0150_stage3a_provisionheld(BigDecimal r0150_stage3a_provisionheld) {
			this.r0150_stage3a_provisionheld = r0150_stage3a_provisionheld;
		}
		public BigDecimal getR0150_stage3b_provisionheld() {
			return r0150_stage3b_provisionheld;
		}
		public void setR0150_stage3b_provisionheld(BigDecimal r0150_stage3b_provisionheld) {
			this.r0150_stage3b_provisionheld = r0150_stage3b_provisionheld;
		}
		public BigDecimal getR0150_stage3c_provisionheld() {
			return r0150_stage3c_provisionheld;
		}
		public void setR0150_stage3c_provisionheld(BigDecimal r0150_stage3c_provisionheld) {
			this.r0150_stage3c_provisionheld = r0150_stage3c_provisionheld;
		}
		public BigDecimal getR0150_intrestfees_provisionheld() {
			return r0150_intrestfees_provisionheld;
		}
		public void setR0150_intrestfees_provisionheld(BigDecimal r0150_intrestfees_provisionheld) {
			this.r0150_intrestfees_provisionheld = r0150_intrestfees_provisionheld;
		}
		public BigDecimal getR0150_intrestsuspense_provisionheld() {
			return r0150_intrestsuspense_provisionheld;
		}
		public void setR0150_intrestsuspense_provisionheld(BigDecimal r0150_intrestsuspense_provisionheld) {
			this.r0150_intrestsuspense_provisionheld = r0150_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0150_stage1_poci() {
			return r0150_stage1_poci;
		}
		public void setR0150_stage1_poci(BigDecimal r0150_stage1_poci) {
			this.r0150_stage1_poci = r0150_stage1_poci;
		}
		public BigDecimal getR0150_stage2_poci() {
			return r0150_stage2_poci;
		}
		public void setR0150_stage2_poci(BigDecimal r0150_stage2_poci) {
			this.r0150_stage2_poci = r0150_stage2_poci;
		}
		public BigDecimal getR0150_stage3a_poci() {
			return r0150_stage3a_poci;
		}
		public void setR0150_stage3a_poci(BigDecimal r0150_stage3a_poci) {
			this.r0150_stage3a_poci = r0150_stage3a_poci;
		}
		public BigDecimal getR0150_stage3b_poci() {
			return r0150_stage3b_poci;
		}
		public void setR0150_stage3b_poci(BigDecimal r0150_stage3b_poci) {
			this.r0150_stage3b_poci = r0150_stage3b_poci;
		}
		public BigDecimal getR0150_stage3c_poci() {
			return r0150_stage3c_poci;
		}
		public void setR0150_stage3c_poci(BigDecimal r0150_stage3c_poci) {
			this.r0150_stage3c_poci = r0150_stage3c_poci;
		}
		public BigDecimal getR0150_current_pastdues() {
			return r0150_current_pastdues;
		}
		public void setR0150_current_pastdues(BigDecimal r0150_current_pastdues) {
			this.r0150_current_pastdues = r0150_current_pastdues;
		}
		public BigDecimal getR0150_less30days_pastdues() {
			return r0150_less30days_pastdues;
		}
		public void setR0150_less30days_pastdues(BigDecimal r0150_less30days_pastdues) {
			this.r0150_less30days_pastdues = r0150_less30days_pastdues;
		}
		public BigDecimal getR0150_31to90days_pastdues() {
			return r0150_31to90days_pastdues;
		}
		public void setR0150_31to90days_pastdues(BigDecimal r0150_31to90days_pastdues) {
			this.r0150_31to90days_pastdues = r0150_31to90days_pastdues;
		}
		public BigDecimal getR0150_91to120days_pastdues() {
			return r0150_91to120days_pastdues;
		}
		public void setR0150_91to120days_pastdues(BigDecimal r0150_91to120days_pastdues) {
			this.r0150_91to120days_pastdues = r0150_91to120days_pastdues;
		}
		public BigDecimal getR0150_121to180days_pastdues() {
			return r0150_121to180days_pastdues;
		}
		public void setR0150_121to180days_pastdues(BigDecimal r0150_121to180days_pastdues) {
			this.r0150_121to180days_pastdues = r0150_121to180days_pastdues;
		}
		public BigDecimal getR0150_181to365days_pastdues() {
			return r0150_181to365days_pastdues;
		}
		public void setR0150_181to365days_pastdues(BigDecimal r0150_181to365days_pastdues) {
			this.r0150_181to365days_pastdues = r0150_181to365days_pastdues;
		}
		public BigDecimal getR0150_over365days_pastdues() {
			return r0150_over365days_pastdues;
		}
		public void setR0150_over365days_pastdues(BigDecimal r0150_over365days_pastdues) {
			this.r0150_over365days_pastdues = r0150_over365days_pastdues;
		}
		public BigDecimal getR0150_total_pastdues() {
			return r0150_total_pastdues;
		}
		public void setR0150_total_pastdues(BigDecimal r0150_total_pastdues) {
			this.r0150_total_pastdues = r0150_total_pastdues;
		}
		public BigDecimal getR0150_newloan_duringreport() {
			return r0150_newloan_duringreport;
		}
		public void setR0150_newloan_duringreport(BigDecimal r0150_newloan_duringreport) {
			this.r0150_newloan_duringreport = r0150_newloan_duringreport;
		}
		public BigDecimal getR0150_newstage_duringreport() {
			return r0150_newstage_duringreport;
		}
		public void setR0150_newstage_duringreport(BigDecimal r0150_newstage_duringreport) {
			this.r0150_newstage_duringreport = r0150_newstage_duringreport;
		}
		public BigDecimal getR0150_intrestfees_duringreport() {
			return r0150_intrestfees_duringreport;
		}
		public void setR0150_intrestfees_duringreport(BigDecimal r0150_intrestfees_duringreport) {
			this.r0150_intrestfees_duringreport = r0150_intrestfees_duringreport;
		}
		public BigDecimal getR0150_performingac_acinfo() {
			return r0150_performingac_acinfo;
		}
		public void setR0150_performingac_acinfo(BigDecimal r0150_performingac_acinfo) {
			this.r0150_performingac_acinfo = r0150_performingac_acinfo;
		}
		public BigDecimal getR0150_nonperformingac_acinfo() {
			return r0150_nonperformingac_acinfo;
		}
		public void setR0150_nonperformingac_acinfo(BigDecimal r0150_nonperformingac_acinfo) {
			this.r0150_nonperformingac_acinfo = r0150_nonperformingac_acinfo;
		}
		public String getR0160_product() {
			return r0160_product;
		}
		public void setR0160_product(String r0160_product) {
			this.r0160_product = r0160_product;
		}
		public BigDecimal getR0160_outstandbal() {
			return r0160_outstandbal;
		}
		public void setR0160_outstandbal(BigDecimal r0160_outstandbal) {
			this.r0160_outstandbal = r0160_outstandbal;
		}
		public BigDecimal getR0160_secured_outstandbal() {
			return r0160_secured_outstandbal;
		}
		public void setR0160_secured_outstandbal(BigDecimal r0160_secured_outstandbal) {
			this.r0160_secured_outstandbal = r0160_secured_outstandbal;
		}
		public BigDecimal getR0160_unsecured_outstandbal() {
			return r0160_unsecured_outstandbal;
		}
		public void setR0160_unsecured_outstandbal(BigDecimal r0160_unsecured_outstandbal) {
			this.r0160_unsecured_outstandbal = r0160_unsecured_outstandbal;
		}
		public BigDecimal getR0160_stage1_assetclass() {
			return r0160_stage1_assetclass;
		}
		public void setR0160_stage1_assetclass(BigDecimal r0160_stage1_assetclass) {
			this.r0160_stage1_assetclass = r0160_stage1_assetclass;
		}
		public BigDecimal getR0160_stage2_assetclass() {
			return r0160_stage2_assetclass;
		}
		public void setR0160_stage2_assetclass(BigDecimal r0160_stage2_assetclass) {
			this.r0160_stage2_assetclass = r0160_stage2_assetclass;
		}
		public BigDecimal getR0160_stage3a_assetclass() {
			return r0160_stage3a_assetclass;
		}
		public void setR0160_stage3a_assetclass(BigDecimal r0160_stage3a_assetclass) {
			this.r0160_stage3a_assetclass = r0160_stage3a_assetclass;
		}
		public BigDecimal getR0160_stage3b_assetclass() {
			return r0160_stage3b_assetclass;
		}
		public void setR0160_stage3b_assetclass(BigDecimal r0160_stage3b_assetclass) {
			this.r0160_stage3b_assetclass = r0160_stage3b_assetclass;
		}
		public BigDecimal getR0160_stage3c_assetclass() {
			return r0160_stage3c_assetclass;
		}
		public void setR0160_stage3c_assetclass(BigDecimal r0160_stage3c_assetclass) {
			this.r0160_stage3c_assetclass = r0160_stage3c_assetclass;
		}
		public BigDecimal getR0160_stage1_provisionheld() {
			return r0160_stage1_provisionheld;
		}
		public void setR0160_stage1_provisionheld(BigDecimal r0160_stage1_provisionheld) {
			this.r0160_stage1_provisionheld = r0160_stage1_provisionheld;
		}
		public BigDecimal getR0160_stage2_provisionheld() {
			return r0160_stage2_provisionheld;
		}
		public void setR0160_stage2_provisionheld(BigDecimal r0160_stage2_provisionheld) {
			this.r0160_stage2_provisionheld = r0160_stage2_provisionheld;
		}
		public BigDecimal getR0160_stage3a_provisionheld() {
			return r0160_stage3a_provisionheld;
		}
		public void setR0160_stage3a_provisionheld(BigDecimal r0160_stage3a_provisionheld) {
			this.r0160_stage3a_provisionheld = r0160_stage3a_provisionheld;
		}
		public BigDecimal getR0160_stage3b_provisionheld() {
			return r0160_stage3b_provisionheld;
		}
		public void setR0160_stage3b_provisionheld(BigDecimal r0160_stage3b_provisionheld) {
			this.r0160_stage3b_provisionheld = r0160_stage3b_provisionheld;
		}
		public BigDecimal getR0160_stage3c_provisionheld() {
			return r0160_stage3c_provisionheld;
		}
		public void setR0160_stage3c_provisionheld(BigDecimal r0160_stage3c_provisionheld) {
			this.r0160_stage3c_provisionheld = r0160_stage3c_provisionheld;
		}
		public BigDecimal getR0160_intrestfees_provisionheld() {
			return r0160_intrestfees_provisionheld;
		}
		public void setR0160_intrestfees_provisionheld(BigDecimal r0160_intrestfees_provisionheld) {
			this.r0160_intrestfees_provisionheld = r0160_intrestfees_provisionheld;
		}
		public BigDecimal getR0160_intrestsuspense_provisionheld() {
			return r0160_intrestsuspense_provisionheld;
		}
		public void setR0160_intrestsuspense_provisionheld(BigDecimal r0160_intrestsuspense_provisionheld) {
			this.r0160_intrestsuspense_provisionheld = r0160_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0160_stage1_poci() {
			return r0160_stage1_poci;
		}
		public void setR0160_stage1_poci(BigDecimal r0160_stage1_poci) {
			this.r0160_stage1_poci = r0160_stage1_poci;
		}
		public BigDecimal getR0160_stage2_poci() {
			return r0160_stage2_poci;
		}
		public void setR0160_stage2_poci(BigDecimal r0160_stage2_poci) {
			this.r0160_stage2_poci = r0160_stage2_poci;
		}
		public BigDecimal getR0160_stage3a_poci() {
			return r0160_stage3a_poci;
		}
		public void setR0160_stage3a_poci(BigDecimal r0160_stage3a_poci) {
			this.r0160_stage3a_poci = r0160_stage3a_poci;
		}
		public BigDecimal getR0160_stage3b_poci() {
			return r0160_stage3b_poci;
		}
		public void setR0160_stage3b_poci(BigDecimal r0160_stage3b_poci) {
			this.r0160_stage3b_poci = r0160_stage3b_poci;
		}
		public BigDecimal getR0160_stage3c_poci() {
			return r0160_stage3c_poci;
		}
		public void setR0160_stage3c_poci(BigDecimal r0160_stage3c_poci) {
			this.r0160_stage3c_poci = r0160_stage3c_poci;
		}
		public BigDecimal getR0160_current_pastdues() {
			return r0160_current_pastdues;
		}
		public void setR0160_current_pastdues(BigDecimal r0160_current_pastdues) {
			this.r0160_current_pastdues = r0160_current_pastdues;
		}
		public BigDecimal getR0160_less30days_pastdues() {
			return r0160_less30days_pastdues;
		}
		public void setR0160_less30days_pastdues(BigDecimal r0160_less30days_pastdues) {
			this.r0160_less30days_pastdues = r0160_less30days_pastdues;
		}
		public BigDecimal getR0160_31to90days_pastdues() {
			return r0160_31to90days_pastdues;
		}
		public void setR0160_31to90days_pastdues(BigDecimal r0160_31to90days_pastdues) {
			this.r0160_31to90days_pastdues = r0160_31to90days_pastdues;
		}
		public BigDecimal getR0160_91to120days_pastdues() {
			return r0160_91to120days_pastdues;
		}
		public void setR0160_91to120days_pastdues(BigDecimal r0160_91to120days_pastdues) {
			this.r0160_91to120days_pastdues = r0160_91to120days_pastdues;
		}
		public BigDecimal getR0160_121to80days_pastdues() {
			return r0160_121to80days_pastdues;
		}
		public void setR0160_121to80days_pastdues(BigDecimal r0160_121to80days_pastdues) {
			this.r0160_121to80days_pastdues = r0160_121to80days_pastdues;
		}
		public BigDecimal getR0160_181to365days_pastdues() {
			return r0160_181to365days_pastdues;
		}
		public void setR0160_181to365days_pastdues(BigDecimal r0160_181to365days_pastdues) {
			this.r0160_181to365days_pastdues = r0160_181to365days_pastdues;
		}
		public BigDecimal getR0160_over365days_pastdues() {
			return r0160_over365days_pastdues;
		}
		public void setR0160_over365days_pastdues(BigDecimal r0160_over365days_pastdues) {
			this.r0160_over365days_pastdues = r0160_over365days_pastdues;
		}
		public BigDecimal getR0160_total_pastdues() {
			return r0160_total_pastdues;
		}
		public void setR0160_total_pastdues(BigDecimal r0160_total_pastdues) {
			this.r0160_total_pastdues = r0160_total_pastdues;
		}
		public BigDecimal getR0160_newloan_duringreport() {
			return r0160_newloan_duringreport;
		}
		public void setR0160_newloan_duringreport(BigDecimal r0160_newloan_duringreport) {
			this.r0160_newloan_duringreport = r0160_newloan_duringreport;
		}
		public BigDecimal getR0160_newstage_duringreport() {
			return r0160_newstage_duringreport;
		}
		public void setR0160_newstage_duringreport(BigDecimal r0160_newstage_duringreport) {
			this.r0160_newstage_duringreport = r0160_newstage_duringreport;
		}
		public BigDecimal getR0160_intrestfees_duringreport() {
			return r0160_intrestfees_duringreport;
		}
		public void setR0160_intrestfees_duringreport(BigDecimal r0160_intrestfees_duringreport) {
			this.r0160_intrestfees_duringreport = r0160_intrestfees_duringreport;
		}
		public BigDecimal getR0160_performingac_acinfo() {
			return r0160_performingac_acinfo;
		}
		public void setR0160_performingac_acinfo(BigDecimal r0160_performingac_acinfo) {
			this.r0160_performingac_acinfo = r0160_performingac_acinfo;
		}
		public BigDecimal getR0160_nonperformingac_acinfo() {
			return r0160_nonperformingac_acinfo;
		}
		public void setR0160_nonperformingac_acinfo(BigDecimal r0160_nonperformingac_acinfo) {
			this.r0160_nonperformingac_acinfo = r0160_nonperformingac_acinfo;
		}
		public String getR0170_product() {
			return r0170_product;
		}
		public void setR0170_product(String r0170_product) {
			this.r0170_product = r0170_product;
		}
		public BigDecimal getR0170_outstandbal() {
			return r0170_outstandbal;
		}
		public void setR0170_outstandbal(BigDecimal r0170_outstandbal) {
			this.r0170_outstandbal = r0170_outstandbal;
		}
		public BigDecimal getR0170_secured_outstandbal() {
			return r0170_secured_outstandbal;
		}
		public void setR0170_secured_outstandbal(BigDecimal r0170_secured_outstandbal) {
			this.r0170_secured_outstandbal = r0170_secured_outstandbal;
		}
		public BigDecimal getR0170_unsecured_outstandbal() {
			return r0170_unsecured_outstandbal;
		}
		public void setR0170_unsecured_outstandbal(BigDecimal r0170_unsecured_outstandbal) {
			this.r0170_unsecured_outstandbal = r0170_unsecured_outstandbal;
		}
		public BigDecimal getR0170_stage1_assetclass() {
			return r0170_stage1_assetclass;
		}
		public void setR0170_stage1_assetclass(BigDecimal r0170_stage1_assetclass) {
			this.r0170_stage1_assetclass = r0170_stage1_assetclass;
		}
		public BigDecimal getR0170_stage2_assetclass() {
			return r0170_stage2_assetclass;
		}
		public void setR0170_stage2_assetclass(BigDecimal r0170_stage2_assetclass) {
			this.r0170_stage2_assetclass = r0170_stage2_assetclass;
		}
		public BigDecimal getR0170_stage3a_assetclass() {
			return r0170_stage3a_assetclass;
		}
		public void setR0170_stage3a_assetclass(BigDecimal r0170_stage3a_assetclass) {
			this.r0170_stage3a_assetclass = r0170_stage3a_assetclass;
		}
		public BigDecimal getR0170_stage3b_assetclass() {
			return r0170_stage3b_assetclass;
		}
		public void setR0170_stage3b_assetclass(BigDecimal r0170_stage3b_assetclass) {
			this.r0170_stage3b_assetclass = r0170_stage3b_assetclass;
		}
		public BigDecimal getR0170_stage3c_assetclass() {
			return r0170_stage3c_assetclass;
		}
		public void setR0170_stage3c_assetclass(BigDecimal r0170_stage3c_assetclass) {
			this.r0170_stage3c_assetclass = r0170_stage3c_assetclass;
		}
		public BigDecimal getR0170_stage1_provisionheld() {
			return r0170_stage1_provisionheld;
		}
		public void setR0170_stage1_provisionheld(BigDecimal r0170_stage1_provisionheld) {
			this.r0170_stage1_provisionheld = r0170_stage1_provisionheld;
		}
		public BigDecimal getR0170_stage2_provisionheld() {
			return r0170_stage2_provisionheld;
		}
		public void setR0170_stage2_provisionheld(BigDecimal r0170_stage2_provisionheld) {
			this.r0170_stage2_provisionheld = r0170_stage2_provisionheld;
		}
		public BigDecimal getR0170_stage3a_provisionheld() {
			return r0170_stage3a_provisionheld;
		}
		public void setR0170_stage3a_provisionheld(BigDecimal r0170_stage3a_provisionheld) {
			this.r0170_stage3a_provisionheld = r0170_stage3a_provisionheld;
		}
		public BigDecimal getR0170_stage3b_provisionheld() {
			return r0170_stage3b_provisionheld;
		}
		public void setR0170_stage3b_provisionheld(BigDecimal r0170_stage3b_provisionheld) {
			this.r0170_stage3b_provisionheld = r0170_stage3b_provisionheld;
		}
		public BigDecimal getR0170_stage3c_provisionheld() {
			return r0170_stage3c_provisionheld;
		}
		public void setR0170_stage3c_provisionheld(BigDecimal r0170_stage3c_provisionheld) {
			this.r0170_stage3c_provisionheld = r0170_stage3c_provisionheld;
		}
		public BigDecimal getR0170_intrestfees_provisionheld() {
			return r0170_intrestfees_provisionheld;
		}
		public void setR0170_intrestfees_provisionheld(BigDecimal r0170_intrestfees_provisionheld) {
			this.r0170_intrestfees_provisionheld = r0170_intrestfees_provisionheld;
		}
		public BigDecimal getR0170_intrestsuspense_provisionheld() {
			return r0170_intrestsuspense_provisionheld;
		}
		public void setR0170_intrestsuspense_provisionheld(BigDecimal r0170_intrestsuspense_provisionheld) {
			this.r0170_intrestsuspense_provisionheld = r0170_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0170_stage1_poci() {
			return r0170_stage1_poci;
		}
		public void setR0170_stage1_poci(BigDecimal r0170_stage1_poci) {
			this.r0170_stage1_poci = r0170_stage1_poci;
		}
		public BigDecimal getR0170_stage2_poci() {
			return r0170_stage2_poci;
		}
		public void setR0170_stage2_poci(BigDecimal r0170_stage2_poci) {
			this.r0170_stage2_poci = r0170_stage2_poci;
		}
		public BigDecimal getR0170_stage3a_poci() {
			return r0170_stage3a_poci;
		}
		public void setR0170_stage3a_poci(BigDecimal r0170_stage3a_poci) {
			this.r0170_stage3a_poci = r0170_stage3a_poci;
		}
		public BigDecimal getR0170_stage3b_poci() {
			return r0170_stage3b_poci;
		}
		public void setR0170_stage3b_poci(BigDecimal r0170_stage3b_poci) {
			this.r0170_stage3b_poci = r0170_stage3b_poci;
		}
		public BigDecimal getR0170_stage3c_poci() {
			return r0170_stage3c_poci;
		}
		public void setR0170_stage3c_poci(BigDecimal r0170_stage3c_poci) {
			this.r0170_stage3c_poci = r0170_stage3c_poci;
		}
		public BigDecimal getR0170_current_pastdues() {
			return r0170_current_pastdues;
		}
		public void setR0170_current_pastdues(BigDecimal r0170_current_pastdues) {
			this.r0170_current_pastdues = r0170_current_pastdues;
		}
		public BigDecimal getR0170_less30days_pastdues() {
			return r0170_less30days_pastdues;
		}
		public void setR0170_less30days_pastdues(BigDecimal r0170_less30days_pastdues) {
			this.r0170_less30days_pastdues = r0170_less30days_pastdues;
		}
		public BigDecimal getR0170_31to90days_pastdues() {
			return r0170_31to90days_pastdues;
		}
		public void setR0170_31to90days_pastdues(BigDecimal r0170_31to90days_pastdues) {
			this.r0170_31to90days_pastdues = r0170_31to90days_pastdues;
		}
		public BigDecimal getR0170_91to120days_pastdues() {
			return r0170_91to120days_pastdues;
		}
		public void setR0170_91to120days_pastdues(BigDecimal r0170_91to120days_pastdues) {
			this.r0170_91to120days_pastdues = r0170_91to120days_pastdues;
		}
		public BigDecimal getR0170_121to180days_pastdues() {
			return r0170_121to180days_pastdues;
		}
		public void setR0170_121to180days_pastdues(BigDecimal r0170_121to180days_pastdues) {
			this.r0170_121to180days_pastdues = r0170_121to180days_pastdues;
		}
		public BigDecimal getR0170_181to365days_pastdues() {
			return r0170_181to365days_pastdues;
		}
		public void setR0170_181to365days_pastdues(BigDecimal r0170_181to365days_pastdues) {
			this.r0170_181to365days_pastdues = r0170_181to365days_pastdues;
		}
		public BigDecimal getR0170_over365days_pastdues() {
			return r0170_over365days_pastdues;
		}
		public void setR0170_over365days_pastdues(BigDecimal r0170_over365days_pastdues) {
			this.r0170_over365days_pastdues = r0170_over365days_pastdues;
		}
		public BigDecimal getR0170_total_pastdues() {
			return r0170_total_pastdues;
		}
		public void setR0170_total_pastdues(BigDecimal r0170_total_pastdues) {
			this.r0170_total_pastdues = r0170_total_pastdues;
		}
		public BigDecimal getR0170_newloan_duringreport() {
			return r0170_newloan_duringreport;
		}
		public void setR0170_newloan_duringreport(BigDecimal r0170_newloan_duringreport) {
			this.r0170_newloan_duringreport = r0170_newloan_duringreport;
		}
		public BigDecimal getR0170_newstage_duringreport() {
			return r0170_newstage_duringreport;
		}
		public void setR0170_newstage_duringreport(BigDecimal r0170_newstage_duringreport) {
			this.r0170_newstage_duringreport = r0170_newstage_duringreport;
		}
		public BigDecimal getR0170_intrestfees_duringreport() {
			return r0170_intrestfees_duringreport;
		}
		public void setR0170_intrestfees_duringreport(BigDecimal r0170_intrestfees_duringreport) {
			this.r0170_intrestfees_duringreport = r0170_intrestfees_duringreport;
		}
		public BigDecimal getR0170_performingac_acinfo() {
			return r0170_performingac_acinfo;
		}
		public void setR0170_performingac_acinfo(BigDecimal r0170_performingac_acinfo) {
			this.r0170_performingac_acinfo = r0170_performingac_acinfo;
		}
		public BigDecimal getR0170_nonperformingac_acinfo() {
			return r0170_nonperformingac_acinfo;
		}
		public void setR0170_nonperformingac_acinfo(BigDecimal r0170_nonperformingac_acinfo) {
			this.r0170_nonperformingac_acinfo = r0170_nonperformingac_acinfo;
		}
		public String getR0180_product() {
			return r0180_product;
		}
		public void setR0180_product(String r0180_product) {
			this.r0180_product = r0180_product;
		}
		public BigDecimal getR0180_outstandbal() {
			return r0180_outstandbal;
		}
		public void setR0180_outstandbal(BigDecimal r0180_outstandbal) {
			this.r0180_outstandbal = r0180_outstandbal;
		}
		public BigDecimal getR0180_secured_outstandbal() {
			return r0180_secured_outstandbal;
		}
		public void setR0180_secured_outstandbal(BigDecimal r0180_secured_outstandbal) {
			this.r0180_secured_outstandbal = r0180_secured_outstandbal;
		}
		public BigDecimal getR0180_unsecured_outstandbal() {
			return r0180_unsecured_outstandbal;
		}
		public void setR0180_unsecured_outstandbal(BigDecimal r0180_unsecured_outstandbal) {
			this.r0180_unsecured_outstandbal = r0180_unsecured_outstandbal;
		}
		public BigDecimal getR0180_stage1_assetclass() {
			return r0180_stage1_assetclass;
		}
		public void setR0180_stage1_assetclass(BigDecimal r0180_stage1_assetclass) {
			this.r0180_stage1_assetclass = r0180_stage1_assetclass;
		}
		public BigDecimal getR0180_stage2_assetclass() {
			return r0180_stage2_assetclass;
		}
		public void setR0180_stage2_assetclass(BigDecimal r0180_stage2_assetclass) {
			this.r0180_stage2_assetclass = r0180_stage2_assetclass;
		}
		public BigDecimal getR0180_stage3a_assetclass() {
			return r0180_stage3a_assetclass;
		}
		public void setR0180_stage3a_assetclass(BigDecimal r0180_stage3a_assetclass) {
			this.r0180_stage3a_assetclass = r0180_stage3a_assetclass;
		}
		public BigDecimal getR0180_stage3b_assetclass() {
			return r0180_stage3b_assetclass;
		}
		public void setR0180_stage3b_assetclass(BigDecimal r0180_stage3b_assetclass) {
			this.r0180_stage3b_assetclass = r0180_stage3b_assetclass;
		}
		public BigDecimal getR0180_stage3c_assetclass() {
			return r0180_stage3c_assetclass;
		}
		public void setR0180_stage3c_assetclass(BigDecimal r0180_stage3c_assetclass) {
			this.r0180_stage3c_assetclass = r0180_stage3c_assetclass;
		}
		public BigDecimal getR0180_stage1_provisionheld() {
			return r0180_stage1_provisionheld;
		}
		public void setR0180_stage1_provisionheld(BigDecimal r0180_stage1_provisionheld) {
			this.r0180_stage1_provisionheld = r0180_stage1_provisionheld;
		}
		public BigDecimal getR0180_stage2_provisionheld() {
			return r0180_stage2_provisionheld;
		}
		public void setR0180_stage2_provisionheld(BigDecimal r0180_stage2_provisionheld) {
			this.r0180_stage2_provisionheld = r0180_stage2_provisionheld;
		}
		public BigDecimal getR0180_stage3a_provisionheld() {
			return r0180_stage3a_provisionheld;
		}
		public void setR0180_stage3a_provisionheld(BigDecimal r0180_stage3a_provisionheld) {
			this.r0180_stage3a_provisionheld = r0180_stage3a_provisionheld;
		}
		public BigDecimal getR0180_stage3b_provisionheld() {
			return r0180_stage3b_provisionheld;
		}
		public void setR0180_stage3b_provisionheld(BigDecimal r0180_stage3b_provisionheld) {
			this.r0180_stage3b_provisionheld = r0180_stage3b_provisionheld;
		}
		public BigDecimal getR0180_stage3c_provisionheld() {
			return r0180_stage3c_provisionheld;
		}
		public void setR0180_stage3c_provisionheld(BigDecimal r0180_stage3c_provisionheld) {
			this.r0180_stage3c_provisionheld = r0180_stage3c_provisionheld;
		}
		public BigDecimal getR0180_intrestfees_provisionheld() {
			return r0180_intrestfees_provisionheld;
		}
		public void setR0180_intrestfees_provisionheld(BigDecimal r0180_intrestfees_provisionheld) {
			this.r0180_intrestfees_provisionheld = r0180_intrestfees_provisionheld;
		}
		public BigDecimal getR0180_intrestsuspense_provisionheld() {
			return r0180_intrestsuspense_provisionheld;
		}
		public void setR0180_intrestsuspense_provisionheld(BigDecimal r0180_intrestsuspense_provisionheld) {
			this.r0180_intrestsuspense_provisionheld = r0180_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0180_stage1_poci() {
			return r0180_stage1_poci;
		}
		public void setR0180_stage1_poci(BigDecimal r0180_stage1_poci) {
			this.r0180_stage1_poci = r0180_stage1_poci;
		}
		public BigDecimal getR0180_stage2_poci() {
			return r0180_stage2_poci;
		}
		public void setR0180_stage2_poci(BigDecimal r0180_stage2_poci) {
			this.r0180_stage2_poci = r0180_stage2_poci;
		}
		public BigDecimal getR0180_stage3a_poci() {
			return r0180_stage3a_poci;
		}
		public void setR0180_stage3a_poci(BigDecimal r0180_stage3a_poci) {
			this.r0180_stage3a_poci = r0180_stage3a_poci;
		}
		public BigDecimal getR0180_stage3b_poci() {
			return r0180_stage3b_poci;
		}
		public void setR0180_stage3b_poci(BigDecimal r0180_stage3b_poci) {
			this.r0180_stage3b_poci = r0180_stage3b_poci;
		}
		public BigDecimal getR0180_stage3c_poci() {
			return r0180_stage3c_poci;
		}
		public void setR0180_stage3c_poci(BigDecimal r0180_stage3c_poci) {
			this.r0180_stage3c_poci = r0180_stage3c_poci;
		}
		public BigDecimal getR0180_current_pastdues() {
			return r0180_current_pastdues;
		}
		public void setR0180_current_pastdues(BigDecimal r0180_current_pastdues) {
			this.r0180_current_pastdues = r0180_current_pastdues;
		}
		public BigDecimal getR0180_less30days_pastdues() {
			return r0180_less30days_pastdues;
		}
		public void setR0180_less30days_pastdues(BigDecimal r0180_less30days_pastdues) {
			this.r0180_less30days_pastdues = r0180_less30days_pastdues;
		}
		public BigDecimal getR0180_31to90days_pastdues() {
			return r0180_31to90days_pastdues;
		}
		public void setR0180_31to90days_pastdues(BigDecimal r0180_31to90days_pastdues) {
			this.r0180_31to90days_pastdues = r0180_31to90days_pastdues;
		}
		public BigDecimal getR0180_91to120days_pastdues() {
			return r0180_91to120days_pastdues;
		}
		public void setR0180_91to120days_pastdues(BigDecimal r0180_91to120days_pastdues) {
			this.r0180_91to120days_pastdues = r0180_91to120days_pastdues;
		}
		public BigDecimal getR0180_121to180days_pastdues() {
			return r0180_121to180days_pastdues;
		}
		public void setR0180_121to180days_pastdues(BigDecimal r0180_121to180days_pastdues) {
			this.r0180_121to180days_pastdues = r0180_121to180days_pastdues;
		}
		public BigDecimal getR0180_181to365days_pastdues() {
			return r0180_181to365days_pastdues;
		}
		public void setR0180_181to365days_pastdues(BigDecimal r0180_181to365days_pastdues) {
			this.r0180_181to365days_pastdues = r0180_181to365days_pastdues;
		}
		public BigDecimal getR0180_over365days_pastdues() {
			return r0180_over365days_pastdues;
		}
		public void setR0180_over365days_pastdues(BigDecimal r0180_over365days_pastdues) {
			this.r0180_over365days_pastdues = r0180_over365days_pastdues;
		}
		public BigDecimal getR0180_total_pastdues() {
			return r0180_total_pastdues;
		}
		public void setR0180_total_pastdues(BigDecimal r0180_total_pastdues) {
			this.r0180_total_pastdues = r0180_total_pastdues;
		}
		public BigDecimal getR0180_newloan_duringreport() {
			return r0180_newloan_duringreport;
		}
		public void setR0180_newloan_duringreport(BigDecimal r0180_newloan_duringreport) {
			this.r0180_newloan_duringreport = r0180_newloan_duringreport;
		}
		public BigDecimal getR0180_newstage_duringreport() {
			return r0180_newstage_duringreport;
		}
		public void setR0180_newstage_duringreport(BigDecimal r0180_newstage_duringreport) {
			this.r0180_newstage_duringreport = r0180_newstage_duringreport;
		}
		public BigDecimal getR0180_intrestfees_duringreport() {
			return r0180_intrestfees_duringreport;
		}
		public void setR0180_intrestfees_duringreport(BigDecimal r0180_intrestfees_duringreport) {
			this.r0180_intrestfees_duringreport = r0180_intrestfees_duringreport;
		}
		public BigDecimal getR0180_performingac_acinfo() {
			return r0180_performingac_acinfo;
		}
		public void setR0180_performingac_acinfo(BigDecimal r0180_performingac_acinfo) {
			this.r0180_performingac_acinfo = r0180_performingac_acinfo;
		}
		public BigDecimal getR0180_nonperformingac_acinfo() {
			return r0180_nonperformingac_acinfo;
		}
		public void setR0180_nonperformingac_acinfo(BigDecimal r0180_nonperformingac_acinfo) {
			this.r0180_nonperformingac_acinfo = r0180_nonperformingac_acinfo;
		}
		public String getR0190_product() {
			return r0190_product;
		}
		public void setR0190_product(String r0190_product) {
			this.r0190_product = r0190_product;
		}
		public BigDecimal getR0190_outstandbal() {
			return r0190_outstandbal;
		}
		public void setR0190_outstandbal(BigDecimal r0190_outstandbal) {
			this.r0190_outstandbal = r0190_outstandbal;
		}
		public BigDecimal getR0190_secured_outstandbal() {
			return r0190_secured_outstandbal;
		}
		public void setR0190_secured_outstandbal(BigDecimal r0190_secured_outstandbal) {
			this.r0190_secured_outstandbal = r0190_secured_outstandbal;
		}
		public BigDecimal getR0190_unsecured_outstandbal() {
			return r0190_unsecured_outstandbal;
		}
		public void setR0190_unsecured_outstandbal(BigDecimal r0190_unsecured_outstandbal) {
			this.r0190_unsecured_outstandbal = r0190_unsecured_outstandbal;
		}
		public BigDecimal getR0190_stage1_assetclass() {
			return r0190_stage1_assetclass;
		}
		public void setR0190_stage1_assetclass(BigDecimal r0190_stage1_assetclass) {
			this.r0190_stage1_assetclass = r0190_stage1_assetclass;
		}
		public BigDecimal getR0190_stage2_assetclass() {
			return r0190_stage2_assetclass;
		}
		public void setR0190_stage2_assetclass(BigDecimal r0190_stage2_assetclass) {
			this.r0190_stage2_assetclass = r0190_stage2_assetclass;
		}
		public BigDecimal getR0190_stage3a_assetclass() {
			return r0190_stage3a_assetclass;
		}
		public void setR0190_stage3a_assetclass(BigDecimal r0190_stage3a_assetclass) {
			this.r0190_stage3a_assetclass = r0190_stage3a_assetclass;
		}
		public BigDecimal getR0190_stage3b_assetclass() {
			return r0190_stage3b_assetclass;
		}
		public void setR0190_stage3b_assetclass(BigDecimal r0190_stage3b_assetclass) {
			this.r0190_stage3b_assetclass = r0190_stage3b_assetclass;
		}
		public BigDecimal getR0190_stage3c_assetclass() {
			return r0190_stage3c_assetclass;
		}
		public void setR0190_stage3c_assetclass(BigDecimal r0190_stage3c_assetclass) {
			this.r0190_stage3c_assetclass = r0190_stage3c_assetclass;
		}
		public BigDecimal getR0190_stage1_provisionheld() {
			return r0190_stage1_provisionheld;
		}
		public void setR0190_stage1_provisionheld(BigDecimal r0190_stage1_provisionheld) {
			this.r0190_stage1_provisionheld = r0190_stage1_provisionheld;
		}
		public BigDecimal getR0190_stage2_provisionheld() {
			return r0190_stage2_provisionheld;
		}
		public void setR0190_stage2_provisionheld(BigDecimal r0190_stage2_provisionheld) {
			this.r0190_stage2_provisionheld = r0190_stage2_provisionheld;
		}
		public BigDecimal getR0190_stage3a_provisionheld() {
			return r0190_stage3a_provisionheld;
		}
		public void setR0190_stage3a_provisionheld(BigDecimal r0190_stage3a_provisionheld) {
			this.r0190_stage3a_provisionheld = r0190_stage3a_provisionheld;
		}
		public BigDecimal getR0190_stage3b_provisionheld() {
			return r0190_stage3b_provisionheld;
		}
		public void setR0190_stage3b_provisionheld(BigDecimal r0190_stage3b_provisionheld) {
			this.r0190_stage3b_provisionheld = r0190_stage3b_provisionheld;
		}
		public BigDecimal getR0190_stage3c_provisionheld() {
			return r0190_stage3c_provisionheld;
		}
		public void setR0190_stage3c_provisionheld(BigDecimal r0190_stage3c_provisionheld) {
			this.r0190_stage3c_provisionheld = r0190_stage3c_provisionheld;
		}
		public BigDecimal getR0190_intrestfees_provisionheld() {
			return r0190_intrestfees_provisionheld;
		}
		public void setR0190_intrestfees_provisionheld(BigDecimal r0190_intrestfees_provisionheld) {
			this.r0190_intrestfees_provisionheld = r0190_intrestfees_provisionheld;
		}
		public BigDecimal getR0190_intrestsuspense_provisionheld() {
			return r0190_intrestsuspense_provisionheld;
		}
		public void setR0190_intrestsuspense_provisionheld(BigDecimal r0190_intrestsuspense_provisionheld) {
			this.r0190_intrestsuspense_provisionheld = r0190_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0190_stage1_poci() {
			return r0190_stage1_poci;
		}
		public void setR0190_stage1_poci(BigDecimal r0190_stage1_poci) {
			this.r0190_stage1_poci = r0190_stage1_poci;
		}
		public BigDecimal getR0190_stage2_poci() {
			return r0190_stage2_poci;
		}
		public void setR0190_stage2_poci(BigDecimal r0190_stage2_poci) {
			this.r0190_stage2_poci = r0190_stage2_poci;
		}
		public BigDecimal getR0190_stage3a_poci() {
			return r0190_stage3a_poci;
		}
		public void setR0190_stage3a_poci(BigDecimal r0190_stage3a_poci) {
			this.r0190_stage3a_poci = r0190_stage3a_poci;
		}
		public BigDecimal getR0190_stage3b_poci() {
			return r0190_stage3b_poci;
		}
		public void setR0190_stage3b_poci(BigDecimal r0190_stage3b_poci) {
			this.r0190_stage3b_poci = r0190_stage3b_poci;
		}
		public BigDecimal getR0190_stage3c_poci() {
			return r0190_stage3c_poci;
		}
		public void setR0190_stage3c_poci(BigDecimal r0190_stage3c_poci) {
			this.r0190_stage3c_poci = r0190_stage3c_poci;
		}
		public BigDecimal getR0190_current_pastdues() {
			return r0190_current_pastdues;
		}
		public void setR0190_current_pastdues(BigDecimal r0190_current_pastdues) {
			this.r0190_current_pastdues = r0190_current_pastdues;
		}
		public BigDecimal getR0190_less30days_pastdues() {
			return r0190_less30days_pastdues;
		}
		public void setR0190_less30days_pastdues(BigDecimal r0190_less30days_pastdues) {
			this.r0190_less30days_pastdues = r0190_less30days_pastdues;
		}
		public BigDecimal getR0190_31to90days_pastdues() {
			return r0190_31to90days_pastdues;
		}
		public void setR0190_31to90days_pastdues(BigDecimal r0190_31to90days_pastdues) {
			this.r0190_31to90days_pastdues = r0190_31to90days_pastdues;
		}
		public BigDecimal getR0190_91to120days_pastdues() {
			return r0190_91to120days_pastdues;
		}
		public void setR0190_91to120days_pastdues(BigDecimal r0190_91to120days_pastdues) {
			this.r0190_91to120days_pastdues = r0190_91to120days_pastdues;
		}
		public BigDecimal getR0190_121to180days_pastdues() {
			return r0190_121to180days_pastdues;
		}
		public void setR0190_121to180days_pastdues(BigDecimal r0190_121to180days_pastdues) {
			this.r0190_121to180days_pastdues = r0190_121to180days_pastdues;
		}
		public BigDecimal getR0190_181to365days_pastdues() {
			return r0190_181to365days_pastdues;
		}
		public void setR0190_181to365days_pastdues(BigDecimal r0190_181to365days_pastdues) {
			this.r0190_181to365days_pastdues = r0190_181to365days_pastdues;
		}
		public BigDecimal getR0190_over365days_pastdues() {
			return r0190_over365days_pastdues;
		}
		public void setR0190_over365days_pastdues(BigDecimal r0190_over365days_pastdues) {
			this.r0190_over365days_pastdues = r0190_over365days_pastdues;
		}
		public BigDecimal getR0190_total_pastdues() {
			return r0190_total_pastdues;
		}
		public void setR0190_total_pastdues(BigDecimal r0190_total_pastdues) {
			this.r0190_total_pastdues = r0190_total_pastdues;
		}
		public BigDecimal getR0190_newloan_duringreport() {
			return r0190_newloan_duringreport;
		}
		public void setR0190_newloan_duringreport(BigDecimal r0190_newloan_duringreport) {
			this.r0190_newloan_duringreport = r0190_newloan_duringreport;
		}
		public BigDecimal getR0190_newstage_duringreport() {
			return r0190_newstage_duringreport;
		}
		public void setR0190_newstage_duringreport(BigDecimal r0190_newstage_duringreport) {
			this.r0190_newstage_duringreport = r0190_newstage_duringreport;
		}
		public BigDecimal getR0190_intrestfees_duringreport() {
			return r0190_intrestfees_duringreport;
		}
		public void setR0190_intrestfees_duringreport(BigDecimal r0190_intrestfees_duringreport) {
			this.r0190_intrestfees_duringreport = r0190_intrestfees_duringreport;
		}
		public BigDecimal getR0190_performingac_acinfo() {
			return r0190_performingac_acinfo;
		}
		public void setR0190_performingac_acinfo(BigDecimal r0190_performingac_acinfo) {
			this.r0190_performingac_acinfo = r0190_performingac_acinfo;
		}
		public BigDecimal getR0190_nonperformingac_acinfo() {
			return r0190_nonperformingac_acinfo;
		}
		public void setR0190_nonperformingac_acinfo(BigDecimal r0190_nonperformingac_acinfo) {
			this.r0190_nonperformingac_acinfo = r0190_nonperformingac_acinfo;
		}
		public String getR0200_product() {
			return r0200_product;
		}
		public void setR0200_product(String r0200_product) {
			this.r0200_product = r0200_product;
		}
		public BigDecimal getR0200_outstandbal() {
			return r0200_outstandbal;
		}
		public void setR0200_outstandbal(BigDecimal r0200_outstandbal) {
			this.r0200_outstandbal = r0200_outstandbal;
		}
		public BigDecimal getR0200_secured_outstandbal() {
			return r0200_secured_outstandbal;
		}
		public void setR0200_secured_outstandbal(BigDecimal r0200_secured_outstandbal) {
			this.r0200_secured_outstandbal = r0200_secured_outstandbal;
		}
		public BigDecimal getR0200_unsecured_outstandbal() {
			return r0200_unsecured_outstandbal;
		}
		public void setR0200_unsecured_outstandbal(BigDecimal r0200_unsecured_outstandbal) {
			this.r0200_unsecured_outstandbal = r0200_unsecured_outstandbal;
		}
		public BigDecimal getR0200_stage1_assetclass() {
			return r0200_stage1_assetclass;
		}
		public void setR0200_stage1_assetclass(BigDecimal r0200_stage1_assetclass) {
			this.r0200_stage1_assetclass = r0200_stage1_assetclass;
		}
		public BigDecimal getR0200_stage2_assetclass() {
			return r0200_stage2_assetclass;
		}
		public void setR0200_stage2_assetclass(BigDecimal r0200_stage2_assetclass) {
			this.r0200_stage2_assetclass = r0200_stage2_assetclass;
		}
		public BigDecimal getR0200_stage3a_assetclass() {
			return r0200_stage3a_assetclass;
		}
		public void setR0200_stage3a_assetclass(BigDecimal r0200_stage3a_assetclass) {
			this.r0200_stage3a_assetclass = r0200_stage3a_assetclass;
		}
		public BigDecimal getR0200_stage3b_assetclass() {
			return r0200_stage3b_assetclass;
		}
		public void setR0200_stage3b_assetclass(BigDecimal r0200_stage3b_assetclass) {
			this.r0200_stage3b_assetclass = r0200_stage3b_assetclass;
		}
		public BigDecimal getR0200_stage3c_assetclass() {
			return r0200_stage3c_assetclass;
		}
		public void setR0200_stage3c_assetclass(BigDecimal r0200_stage3c_assetclass) {
			this.r0200_stage3c_assetclass = r0200_stage3c_assetclass;
		}
		public BigDecimal getR0200_stage1_provisionheld() {
			return r0200_stage1_provisionheld;
		}
		public void setR0200_stage1_provisionheld(BigDecimal r0200_stage1_provisionheld) {
			this.r0200_stage1_provisionheld = r0200_stage1_provisionheld;
		}
		public BigDecimal getR0200_stage2_provisionheld() {
			return r0200_stage2_provisionheld;
		}
		public void setR0200_stage2_provisionheld(BigDecimal r0200_stage2_provisionheld) {
			this.r0200_stage2_provisionheld = r0200_stage2_provisionheld;
		}
		public BigDecimal getR0200_stage3a_provisionheld() {
			return r0200_stage3a_provisionheld;
		}
		public void setR0200_stage3a_provisionheld(BigDecimal r0200_stage3a_provisionheld) {
			this.r0200_stage3a_provisionheld = r0200_stage3a_provisionheld;
		}
		public BigDecimal getR0200_stage3b_provisionheld() {
			return r0200_stage3b_provisionheld;
		}
		public void setR0200_stage3b_provisionheld(BigDecimal r0200_stage3b_provisionheld) {
			this.r0200_stage3b_provisionheld = r0200_stage3b_provisionheld;
		}
		public BigDecimal getR0200_stage3c_provisionheld() {
			return r0200_stage3c_provisionheld;
		}
		public void setR0200_stage3c_provisionheld(BigDecimal r0200_stage3c_provisionheld) {
			this.r0200_stage3c_provisionheld = r0200_stage3c_provisionheld;
		}
		public BigDecimal getR0200_intrestfees_provisionheld() {
			return r0200_intrestfees_provisionheld;
		}
		public void setR0200_intrestfees_provisionheld(BigDecimal r0200_intrestfees_provisionheld) {
			this.r0200_intrestfees_provisionheld = r0200_intrestfees_provisionheld;
		}
		public BigDecimal getR0200_intrestsuspense_provisionheld() {
			return r0200_intrestsuspense_provisionheld;
		}
		public void setR0200_intrestsuspense_provisionheld(BigDecimal r0200_intrestsuspense_provisionheld) {
			this.r0200_intrestsuspense_provisionheld = r0200_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0200_stage1_poci() {
			return r0200_stage1_poci;
		}
		public void setR0200_stage1_poci(BigDecimal r0200_stage1_poci) {
			this.r0200_stage1_poci = r0200_stage1_poci;
		}
		public BigDecimal getR0200_stage2_poci() {
			return r0200_stage2_poci;
		}
		public void setR0200_stage2_poci(BigDecimal r0200_stage2_poci) {
			this.r0200_stage2_poci = r0200_stage2_poci;
		}
		public BigDecimal getR0200_stage3a_poci() {
			return r0200_stage3a_poci;
		}
		public void setR0200_stage3a_poci(BigDecimal r0200_stage3a_poci) {
			this.r0200_stage3a_poci = r0200_stage3a_poci;
		}
		public BigDecimal getR0200_stage3b_poci() {
			return r0200_stage3b_poci;
		}
		public void setR0200_stage3b_poci(BigDecimal r0200_stage3b_poci) {
			this.r0200_stage3b_poci = r0200_stage3b_poci;
		}
		public BigDecimal getR0200_stage3c_poci() {
			return r0200_stage3c_poci;
		}
		public void setR0200_stage3c_poci(BigDecimal r0200_stage3c_poci) {
			this.r0200_stage3c_poci = r0200_stage3c_poci;
		}
		public BigDecimal getR0200_current_pastdues() {
			return r0200_current_pastdues;
		}
		public void setR0200_current_pastdues(BigDecimal r0200_current_pastdues) {
			this.r0200_current_pastdues = r0200_current_pastdues;
		}
		public BigDecimal getR0200_less30days_pastdues() {
			return r0200_less30days_pastdues;
		}
		public void setR0200_less30days_pastdues(BigDecimal r0200_less30days_pastdues) {
			this.r0200_less30days_pastdues = r0200_less30days_pastdues;
		}
		public BigDecimal getR0200_31to90days_pastdues() {
			return r0200_31to90days_pastdues;
		}
		public void setR0200_31to90days_pastdues(BigDecimal r0200_31to90days_pastdues) {
			this.r0200_31to90days_pastdues = r0200_31to90days_pastdues;
		}
		public BigDecimal getR0200_91to120days_pastdues() {
			return r0200_91to120days_pastdues;
		}
		public void setR0200_91to120days_pastdues(BigDecimal r0200_91to120days_pastdues) {
			this.r0200_91to120days_pastdues = r0200_91to120days_pastdues;
		}
		public BigDecimal getR0200_121to180days_pastdues() {
			return r0200_121to180days_pastdues;
		}
		public void setR0200_121to180days_pastdues(BigDecimal r0200_121to180days_pastdues) {
			this.r0200_121to180days_pastdues = r0200_121to180days_pastdues;
		}
		public BigDecimal getR0200_181to365days_pastdues() {
			return r0200_181to365days_pastdues;
		}
		public void setR0200_181to365days_pastdues(BigDecimal r0200_181to365days_pastdues) {
			this.r0200_181to365days_pastdues = r0200_181to365days_pastdues;
		}
		public BigDecimal getR0200_over365days_pastdues() {
			return r0200_over365days_pastdues;
		}
		public void setR0200_over365days_pastdues(BigDecimal r0200_over365days_pastdues) {
			this.r0200_over365days_pastdues = r0200_over365days_pastdues;
		}
		public BigDecimal getR0200_total_pastdues() {
			return r0200_total_pastdues;
		}
		public void setR0200_total_pastdues(BigDecimal r0200_total_pastdues) {
			this.r0200_total_pastdues = r0200_total_pastdues;
		}
		public BigDecimal getR0200_newloan_duringreport() {
			return r0200_newloan_duringreport;
		}
		public void setR0200_newloan_duringreport(BigDecimal r0200_newloan_duringreport) {
			this.r0200_newloan_duringreport = r0200_newloan_duringreport;
		}
		public BigDecimal getR0200_newstage_duringreport() {
			return r0200_newstage_duringreport;
		}
		public void setR0200_newstage_duringreport(BigDecimal r0200_newstage_duringreport) {
			this.r0200_newstage_duringreport = r0200_newstage_duringreport;
		}
		public BigDecimal getR0200_intrestfees_duringreport() {
			return r0200_intrestfees_duringreport;
		}
		public void setR0200_intrestfees_duringreport(BigDecimal r0200_intrestfees_duringreport) {
			this.r0200_intrestfees_duringreport = r0200_intrestfees_duringreport;
		}
		public BigDecimal getR0200_performingac_acinfo() {
			return r0200_performingac_acinfo;
		}
		public void setR0200_performingac_acinfo(BigDecimal r0200_performingac_acinfo) {
			this.r0200_performingac_acinfo = r0200_performingac_acinfo;
		}
		public BigDecimal getR0200_nonperformingac_acinfo() {
			return r0200_nonperformingac_acinfo;
		}
		public void setR0200_nonperformingac_acinfo(BigDecimal r0200_nonperformingac_acinfo) {
			this.r0200_nonperformingac_acinfo = r0200_nonperformingac_acinfo;
		}
		public String getR0210_product() {
			return r0210_product;
		}
		public void setR0210_product(String r0210_product) {
			this.r0210_product = r0210_product;
		}
		public BigDecimal getR0210_outstandbal() {
			return r0210_outstandbal;
		}
		public void setR0210_outstandbal(BigDecimal r0210_outstandbal) {
			this.r0210_outstandbal = r0210_outstandbal;
		}
		public BigDecimal getR0210_secured_outstandbal() {
			return r0210_secured_outstandbal;
		}
		public void setR0210_secured_outstandbal(BigDecimal r0210_secured_outstandbal) {
			this.r0210_secured_outstandbal = r0210_secured_outstandbal;
		}
		public BigDecimal getR0210_unsecured_outstandbal() {
			return r0210_unsecured_outstandbal;
		}
		public void setR0210_unsecured_outstandbal(BigDecimal r0210_unsecured_outstandbal) {
			this.r0210_unsecured_outstandbal = r0210_unsecured_outstandbal;
		}
		public BigDecimal getR0210_stage1_assetclass() {
			return r0210_stage1_assetclass;
		}
		public void setR0210_stage1_assetclass(BigDecimal r0210_stage1_assetclass) {
			this.r0210_stage1_assetclass = r0210_stage1_assetclass;
		}
		public BigDecimal getR0210_stage2_assetclass() {
			return r0210_stage2_assetclass;
		}
		public void setR0210_stage2_assetclass(BigDecimal r0210_stage2_assetclass) {
			this.r0210_stage2_assetclass = r0210_stage2_assetclass;
		}
		public BigDecimal getR0210_stage3a_assetclass() {
			return r0210_stage3a_assetclass;
		}
		public void setR0210_stage3a_assetclass(BigDecimal r0210_stage3a_assetclass) {
			this.r0210_stage3a_assetclass = r0210_stage3a_assetclass;
		}
		public BigDecimal getR0210_stage3b_assetclass() {
			return r0210_stage3b_assetclass;
		}
		public void setR0210_stage3b_assetclass(BigDecimal r0210_stage3b_assetclass) {
			this.r0210_stage3b_assetclass = r0210_stage3b_assetclass;
		}
		public BigDecimal getR0210_stage3c_assetclass() {
			return r0210_stage3c_assetclass;
		}
		public void setR0210_stage3c_assetclass(BigDecimal r0210_stage3c_assetclass) {
			this.r0210_stage3c_assetclass = r0210_stage3c_assetclass;
		}
		public BigDecimal getR0210_stage1_provisionheld() {
			return r0210_stage1_provisionheld;
		}
		public void setR0210_stage1_provisionheld(BigDecimal r0210_stage1_provisionheld) {
			this.r0210_stage1_provisionheld = r0210_stage1_provisionheld;
		}
		public BigDecimal getR0210_stage2_provisionheld() {
			return r0210_stage2_provisionheld;
		}
		public void setR0210_stage2_provisionheld(BigDecimal r0210_stage2_provisionheld) {
			this.r0210_stage2_provisionheld = r0210_stage2_provisionheld;
		}
		public BigDecimal getR0210_stage3a_provisionheld() {
			return r0210_stage3a_provisionheld;
		}
		public void setR0210_stage3a_provisionheld(BigDecimal r0210_stage3a_provisionheld) {
			this.r0210_stage3a_provisionheld = r0210_stage3a_provisionheld;
		}
		public BigDecimal getR0210_stage3b_provisionheld() {
			return r0210_stage3b_provisionheld;
		}
		public void setR0210_stage3b_provisionheld(BigDecimal r0210_stage3b_provisionheld) {
			this.r0210_stage3b_provisionheld = r0210_stage3b_provisionheld;
		}
		public BigDecimal getR0210_stage3c_provisionheld() {
			return r0210_stage3c_provisionheld;
		}
		public void setR0210_stage3c_provisionheld(BigDecimal r0210_stage3c_provisionheld) {
			this.r0210_stage3c_provisionheld = r0210_stage3c_provisionheld;
		}
		public BigDecimal getR0210_intrestfees_provisionheld() {
			return r0210_intrestfees_provisionheld;
		}
		public void setR0210_intrestfees_provisionheld(BigDecimal r0210_intrestfees_provisionheld) {
			this.r0210_intrestfees_provisionheld = r0210_intrestfees_provisionheld;
		}
		public BigDecimal getR0210_intrestsuspense_provisionheld() {
			return r0210_intrestsuspense_provisionheld;
		}
		public void setR0210_intrestsuspense_provisionheld(BigDecimal r0210_intrestsuspense_provisionheld) {
			this.r0210_intrestsuspense_provisionheld = r0210_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0210_stage1_poci() {
			return r0210_stage1_poci;
		}
		public void setR0210_stage1_poci(BigDecimal r0210_stage1_poci) {
			this.r0210_stage1_poci = r0210_stage1_poci;
		}
		public BigDecimal getR0210_stage2_poci() {
			return r0210_stage2_poci;
		}
		public void setR0210_stage2_poci(BigDecimal r0210_stage2_poci) {
			this.r0210_stage2_poci = r0210_stage2_poci;
		}
		public BigDecimal getR0210_stage3a_poci() {
			return r0210_stage3a_poci;
		}
		public void setR0210_stage3a_poci(BigDecimal r0210_stage3a_poci) {
			this.r0210_stage3a_poci = r0210_stage3a_poci;
		}
		public BigDecimal getR0210_stage3b_poci() {
			return r0210_stage3b_poci;
		}
		public void setR0210_stage3b_poci(BigDecimal r0210_stage3b_poci) {
			this.r0210_stage3b_poci = r0210_stage3b_poci;
		}
		public BigDecimal getR0210_stage3c_poci() {
			return r0210_stage3c_poci;
		}
		public void setR0210_stage3c_poci(BigDecimal r0210_stage3c_poci) {
			this.r0210_stage3c_poci = r0210_stage3c_poci;
		}
		public BigDecimal getR0210_current_pastdues() {
			return r0210_current_pastdues;
		}
		public void setR0210_current_pastdues(BigDecimal r0210_current_pastdues) {
			this.r0210_current_pastdues = r0210_current_pastdues;
		}
		public BigDecimal getR0210_less30days_pastdues() {
			return r0210_less30days_pastdues;
		}
		public void setR0210_less30days_pastdues(BigDecimal r0210_less30days_pastdues) {
			this.r0210_less30days_pastdues = r0210_less30days_pastdues;
		}
		public BigDecimal getR0210_31to90days_pastdues() {
			return r0210_31to90days_pastdues;
		}
		public void setR0210_31to90days_pastdues(BigDecimal r0210_31to90days_pastdues) {
			this.r0210_31to90days_pastdues = r0210_31to90days_pastdues;
		}
		public BigDecimal getR0210_91to120days_pastdues() {
			return r0210_91to120days_pastdues;
		}
		public void setR0210_91to120days_pastdues(BigDecimal r0210_91to120days_pastdues) {
			this.r0210_91to120days_pastdues = r0210_91to120days_pastdues;
		}
		public BigDecimal getR0210_121to180days_pastdues() {
			return r0210_121to180days_pastdues;
		}
		public void setR0210_121to180days_pastdues(BigDecimal r0210_121to180days_pastdues) {
			this.r0210_121to180days_pastdues = r0210_121to180days_pastdues;
		}
		public BigDecimal getR0210_181to365days_pastdues() {
			return r0210_181to365days_pastdues;
		}
		public void setR0210_181to365days_pastdues(BigDecimal r0210_181to365days_pastdues) {
			this.r0210_181to365days_pastdues = r0210_181to365days_pastdues;
		}
		public BigDecimal getR0210_over365days_pastdues() {
			return r0210_over365days_pastdues;
		}
		public void setR0210_over365days_pastdues(BigDecimal r0210_over365days_pastdues) {
			this.r0210_over365days_pastdues = r0210_over365days_pastdues;
		}
		public BigDecimal getR0210_total_pastdues() {
			return r0210_total_pastdues;
		}
		public void setR0210_total_pastdues(BigDecimal r0210_total_pastdues) {
			this.r0210_total_pastdues = r0210_total_pastdues;
		}
		public BigDecimal getR0210_newloan_duringreport() {
			return r0210_newloan_duringreport;
		}
		public void setR0210_newloan_duringreport(BigDecimal r0210_newloan_duringreport) {
			this.r0210_newloan_duringreport = r0210_newloan_duringreport;
		}
		public BigDecimal getR0210_newstage_duringreport() {
			return r0210_newstage_duringreport;
		}
		public void setR0210_newstage_duringreport(BigDecimal r0210_newstage_duringreport) {
			this.r0210_newstage_duringreport = r0210_newstage_duringreport;
		}
		public BigDecimal getR0210_intrestfees_duringreport() {
			return r0210_intrestfees_duringreport;
		}
		public void setR0210_intrestfees_duringreport(BigDecimal r0210_intrestfees_duringreport) {
			this.r0210_intrestfees_duringreport = r0210_intrestfees_duringreport;
		}
		public BigDecimal getR0210_performingac_acinfo() {
			return r0210_performingac_acinfo;
		}
		public void setR0210_performingac_acinfo(BigDecimal r0210_performingac_acinfo) {
			this.r0210_performingac_acinfo = r0210_performingac_acinfo;
		}
		public BigDecimal getR0210_nonperformingac_acinfo() {
			return r0210_nonperformingac_acinfo;
		}
		public void setR0210_nonperformingac_acinfo(BigDecimal r0210_nonperformingac_acinfo) {
			this.r0210_nonperformingac_acinfo = r0210_nonperformingac_acinfo;
		}
		public String getR0220_product() {
			return r0220_product;
		}
		public void setR0220_product(String r0220_product) {
			this.r0220_product = r0220_product;
		}
		public BigDecimal getR0220_outstandbal() {
			return r0220_outstandbal;
		}
		public void setR0220_outstandbal(BigDecimal r0220_outstandbal) {
			this.r0220_outstandbal = r0220_outstandbal;
		}
		public BigDecimal getR0220_secured_outstandbal() {
			return r0220_secured_outstandbal;
		}
		public void setR0220_secured_outstandbal(BigDecimal r0220_secured_outstandbal) {
			this.r0220_secured_outstandbal = r0220_secured_outstandbal;
		}
		public BigDecimal getR0220_unsecured_outstandbal() {
			return r0220_unsecured_outstandbal;
		}
		public void setR0220_unsecured_outstandbal(BigDecimal r0220_unsecured_outstandbal) {
			this.r0220_unsecured_outstandbal = r0220_unsecured_outstandbal;
		}
		public BigDecimal getR0220_stage1_assetclass() {
			return r0220_stage1_assetclass;
		}
		public void setR0220_stage1_assetclass(BigDecimal r0220_stage1_assetclass) {
			this.r0220_stage1_assetclass = r0220_stage1_assetclass;
		}
		public BigDecimal getR0220_stage2_assetclass() {
			return r0220_stage2_assetclass;
		}
		public void setR0220_stage2_assetclass(BigDecimal r0220_stage2_assetclass) {
			this.r0220_stage2_assetclass = r0220_stage2_assetclass;
		}
		public BigDecimal getR0220_stage3a_assetclass() {
			return r0220_stage3a_assetclass;
		}
		public void setR0220_stage3a_assetclass(BigDecimal r0220_stage3a_assetclass) {
			this.r0220_stage3a_assetclass = r0220_stage3a_assetclass;
		}
		public BigDecimal getR0220_stage3b_assetclass() {
			return r0220_stage3b_assetclass;
		}
		public void setR0220_stage3b_assetclass(BigDecimal r0220_stage3b_assetclass) {
			this.r0220_stage3b_assetclass = r0220_stage3b_assetclass;
		}
		public BigDecimal getR0220_stage3c_assetclass() {
			return r0220_stage3c_assetclass;
		}
		public void setR0220_stage3c_assetclass(BigDecimal r0220_stage3c_assetclass) {
			this.r0220_stage3c_assetclass = r0220_stage3c_assetclass;
		}
		public BigDecimal getR0220_stage1_provisionheld() {
			return r0220_stage1_provisionheld;
		}
		public void setR0220_stage1_provisionheld(BigDecimal r0220_stage1_provisionheld) {
			this.r0220_stage1_provisionheld = r0220_stage1_provisionheld;
		}
		public BigDecimal getR0220_stage2_provisionheld() {
			return r0220_stage2_provisionheld;
		}
		public void setR0220_stage2_provisionheld(BigDecimal r0220_stage2_provisionheld) {
			this.r0220_stage2_provisionheld = r0220_stage2_provisionheld;
		}
		public BigDecimal getR0220_stage3a_provisionheld() {
			return r0220_stage3a_provisionheld;
		}
		public void setR0220_stage3a_provisionheld(BigDecimal r0220_stage3a_provisionheld) {
			this.r0220_stage3a_provisionheld = r0220_stage3a_provisionheld;
		}
		public BigDecimal getR0220_stage3b_provisionheld() {
			return r0220_stage3b_provisionheld;
		}
		public void setR0220_stage3b_provisionheld(BigDecimal r0220_stage3b_provisionheld) {
			this.r0220_stage3b_provisionheld = r0220_stage3b_provisionheld;
		}
		public BigDecimal getR0220_stage3c_provisionheld() {
			return r0220_stage3c_provisionheld;
		}
		public void setR0220_stage3c_provisionheld(BigDecimal r0220_stage3c_provisionheld) {
			this.r0220_stage3c_provisionheld = r0220_stage3c_provisionheld;
		}
		public BigDecimal getR0220_intrestfees_provisionheld() {
			return r0220_intrestfees_provisionheld;
		}
		public void setR0220_intrestfees_provisionheld(BigDecimal r0220_intrestfees_provisionheld) {
			this.r0220_intrestfees_provisionheld = r0220_intrestfees_provisionheld;
		}
		public BigDecimal getR0220_intrestsuspense_provisionheld() {
			return r0220_intrestsuspense_provisionheld;
		}
		public void setR0220_intrestsuspense_provisionheld(BigDecimal r0220_intrestsuspense_provisionheld) {
			this.r0220_intrestsuspense_provisionheld = r0220_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0220_stage1_poci() {
			return r0220_stage1_poci;
		}
		public void setR0220_stage1_poci(BigDecimal r0220_stage1_poci) {
			this.r0220_stage1_poci = r0220_stage1_poci;
		}
		public BigDecimal getR0220_stage2_poci() {
			return r0220_stage2_poci;
		}
		public void setR0220_stage2_poci(BigDecimal r0220_stage2_poci) {
			this.r0220_stage2_poci = r0220_stage2_poci;
		}
		public BigDecimal getR0220_stage3a_poci() {
			return r0220_stage3a_poci;
		}
		public void setR0220_stage3a_poci(BigDecimal r0220_stage3a_poci) {
			this.r0220_stage3a_poci = r0220_stage3a_poci;
		}
		public BigDecimal getR0220_stage3b_poci() {
			return r0220_stage3b_poci;
		}
		public void setR0220_stage3b_poci(BigDecimal r0220_stage3b_poci) {
			this.r0220_stage3b_poci = r0220_stage3b_poci;
		}
		public BigDecimal getR0220_stage3c_poci() {
			return r0220_stage3c_poci;
		}
		public void setR0220_stage3c_poci(BigDecimal r0220_stage3c_poci) {
			this.r0220_stage3c_poci = r0220_stage3c_poci;
		}
		public BigDecimal getR0220_current_pastdues() {
			return r0220_current_pastdues;
		}
		public void setR0220_current_pastdues(BigDecimal r0220_current_pastdues) {
			this.r0220_current_pastdues = r0220_current_pastdues;
		}
		public BigDecimal getR0220_less30days_pastdues() {
			return r0220_less30days_pastdues;
		}
		public void setR0220_less30days_pastdues(BigDecimal r0220_less30days_pastdues) {
			this.r0220_less30days_pastdues = r0220_less30days_pastdues;
		}
		public BigDecimal getR0220_31to90days_pastdues() {
			return r0220_31to90days_pastdues;
		}
		public void setR0220_31to90days_pastdues(BigDecimal r0220_31to90days_pastdues) {
			this.r0220_31to90days_pastdues = r0220_31to90days_pastdues;
		}
		public BigDecimal getR0220_91to120days_pastdues() {
			return r0220_91to120days_pastdues;
		}
		public void setR0220_91to120days_pastdues(BigDecimal r0220_91to120days_pastdues) {
			this.r0220_91to120days_pastdues = r0220_91to120days_pastdues;
		}
		public BigDecimal getR0220_121to180days_pastdues() {
			return r0220_121to180days_pastdues;
		}
		public void setR0220_121to180days_pastdues(BigDecimal r0220_121to180days_pastdues) {
			this.r0220_121to180days_pastdues = r0220_121to180days_pastdues;
		}
		public BigDecimal getR0220_181to365days_pastdues() {
			return r0220_181to365days_pastdues;
		}
		public void setR0220_181to365days_pastdues(BigDecimal r0220_181to365days_pastdues) {
			this.r0220_181to365days_pastdues = r0220_181to365days_pastdues;
		}
		public BigDecimal getR0220_over365days_pastdues() {
			return r0220_over365days_pastdues;
		}
		public void setR0220_over365days_pastdues(BigDecimal r0220_over365days_pastdues) {
			this.r0220_over365days_pastdues = r0220_over365days_pastdues;
		}
		public BigDecimal getR0220_total_pastdues() {
			return r0220_total_pastdues;
		}
		public void setR0220_total_pastdues(BigDecimal r0220_total_pastdues) {
			this.r0220_total_pastdues = r0220_total_pastdues;
		}
		public BigDecimal getR0220_newloan_duringreport() {
			return r0220_newloan_duringreport;
		}
		public void setR0220_newloan_duringreport(BigDecimal r0220_newloan_duringreport) {
			this.r0220_newloan_duringreport = r0220_newloan_duringreport;
		}
		public BigDecimal getR0220_newstage_duringreport() {
			return r0220_newstage_duringreport;
		}
		public void setR0220_newstage_duringreport(BigDecimal r0220_newstage_duringreport) {
			this.r0220_newstage_duringreport = r0220_newstage_duringreport;
		}
		public BigDecimal getR0220_intrestfees_duringreport() {
			return r0220_intrestfees_duringreport;
		}
		public void setR0220_intrestfees_duringreport(BigDecimal r0220_intrestfees_duringreport) {
			this.r0220_intrestfees_duringreport = r0220_intrestfees_duringreport;
		}
		public BigDecimal getR0220_performingac_acinfo() {
			return r0220_performingac_acinfo;
		}
		public void setR0220_performingac_acinfo(BigDecimal r0220_performingac_acinfo) {
			this.r0220_performingac_acinfo = r0220_performingac_acinfo;
		}
		public BigDecimal getR0220_nonperformingac_acinfo() {
			return r0220_nonperformingac_acinfo;
		}
		public void setR0220_nonperformingac_acinfo(BigDecimal r0220_nonperformingac_acinfo) {
			this.r0220_nonperformingac_acinfo = r0220_nonperformingac_acinfo;
		}
		public String getR0230_product() {
			return r0230_product;
		}
		public void setR0230_product(String r0230_product) {
			this.r0230_product = r0230_product;
		}
		public BigDecimal getR0230_outstandbal() {
			return r0230_outstandbal;
		}
		public void setR0230_outstandbal(BigDecimal r0230_outstandbal) {
			this.r0230_outstandbal = r0230_outstandbal;
		}
		public BigDecimal getR0230_secured_outstandbal() {
			return r0230_secured_outstandbal;
		}
		public void setR0230_secured_outstandbal(BigDecimal r0230_secured_outstandbal) {
			this.r0230_secured_outstandbal = r0230_secured_outstandbal;
		}
		public BigDecimal getR0230_unsecured_outstandbal() {
			return r0230_unsecured_outstandbal;
		}
		public void setR0230_unsecured_outstandbal(BigDecimal r0230_unsecured_outstandbal) {
			this.r0230_unsecured_outstandbal = r0230_unsecured_outstandbal;
		}
		public BigDecimal getR0230_stage1_assetclass() {
			return r0230_stage1_assetclass;
		}
		public void setR0230_stage1_assetclass(BigDecimal r0230_stage1_assetclass) {
			this.r0230_stage1_assetclass = r0230_stage1_assetclass;
		}
		public BigDecimal getR0230_stage2_assetclass() {
			return r0230_stage2_assetclass;
		}
		public void setR0230_stage2_assetclass(BigDecimal r0230_stage2_assetclass) {
			this.r0230_stage2_assetclass = r0230_stage2_assetclass;
		}
		public BigDecimal getR0230_stage3a_assetclass() {
			return r0230_stage3a_assetclass;
		}
		public void setR0230_stage3a_assetclass(BigDecimal r0230_stage3a_assetclass) {
			this.r0230_stage3a_assetclass = r0230_stage3a_assetclass;
		}
		public BigDecimal getR0230_stage3b_assetclass() {
			return r0230_stage3b_assetclass;
		}
		public void setR0230_stage3b_assetclass(BigDecimal r0230_stage3b_assetclass) {
			this.r0230_stage3b_assetclass = r0230_stage3b_assetclass;
		}
		public BigDecimal getR0230_stage3c_assetclass() {
			return r0230_stage3c_assetclass;
		}
		public void setR0230_stage3c_assetclass(BigDecimal r0230_stage3c_assetclass) {
			this.r0230_stage3c_assetclass = r0230_stage3c_assetclass;
		}
		public BigDecimal getR0230_stage1_provisionheld() {
			return r0230_stage1_provisionheld;
		}
		public void setR0230_stage1_provisionheld(BigDecimal r0230_stage1_provisionheld) {
			this.r0230_stage1_provisionheld = r0230_stage1_provisionheld;
		}
		public BigDecimal getR0230_stage2_provisionheld() {
			return r0230_stage2_provisionheld;
		}
		public void setR0230_stage2_provisionheld(BigDecimal r0230_stage2_provisionheld) {
			this.r0230_stage2_provisionheld = r0230_stage2_provisionheld;
		}
		public BigDecimal getR0230_stage3a_provisionheld() {
			return r0230_stage3a_provisionheld;
		}
		public void setR0230_stage3a_provisionheld(BigDecimal r0230_stage3a_provisionheld) {
			this.r0230_stage3a_provisionheld = r0230_stage3a_provisionheld;
		}
		public BigDecimal getR0230_stage3b_provisionheld() {
			return r0230_stage3b_provisionheld;
		}
		public void setR0230_stage3b_provisionheld(BigDecimal r0230_stage3b_provisionheld) {
			this.r0230_stage3b_provisionheld = r0230_stage3b_provisionheld;
		}
		public BigDecimal getR0230_stage3c_provisionheld() {
			return r0230_stage3c_provisionheld;
		}
		public void setR0230_stage3c_provisionheld(BigDecimal r0230_stage3c_provisionheld) {
			this.r0230_stage3c_provisionheld = r0230_stage3c_provisionheld;
		}
		public BigDecimal getR0230_intrestfees_provisionheld() {
			return r0230_intrestfees_provisionheld;
		}
		public void setR0230_intrestfees_provisionheld(BigDecimal r0230_intrestfees_provisionheld) {
			this.r0230_intrestfees_provisionheld = r0230_intrestfees_provisionheld;
		}
		public BigDecimal getR0230_intrestsuspense_provisionheld() {
			return r0230_intrestsuspense_provisionheld;
		}
		public void setR0230_intrestsuspense_provisionheld(BigDecimal r0230_intrestsuspense_provisionheld) {
			this.r0230_intrestsuspense_provisionheld = r0230_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0230_stage1_poci() {
			return r0230_stage1_poci;
		}
		public void setR0230_stage1_poci(BigDecimal r0230_stage1_poci) {
			this.r0230_stage1_poci = r0230_stage1_poci;
		}
		public BigDecimal getR0230_stage2_poci() {
			return r0230_stage2_poci;
		}
		public void setR0230_stage2_poci(BigDecimal r0230_stage2_poci) {
			this.r0230_stage2_poci = r0230_stage2_poci;
		}
		public BigDecimal getR0230_stage3a_poci() {
			return r0230_stage3a_poci;
		}
		public void setR0230_stage3a_poci(BigDecimal r0230_stage3a_poci) {
			this.r0230_stage3a_poci = r0230_stage3a_poci;
		}
		public BigDecimal getR0230_stage3b_poci() {
			return r0230_stage3b_poci;
		}
		public void setR0230_stage3b_poci(BigDecimal r0230_stage3b_poci) {
			this.r0230_stage3b_poci = r0230_stage3b_poci;
		}
		public BigDecimal getR0230_stage3c_poci() {
			return r0230_stage3c_poci;
		}
		public void setR0230_stage3c_poci(BigDecimal r0230_stage3c_poci) {
			this.r0230_stage3c_poci = r0230_stage3c_poci;
		}
		public BigDecimal getR0230_current_pastdues() {
			return r0230_current_pastdues;
		}
		public void setR0230_current_pastdues(BigDecimal r0230_current_pastdues) {
			this.r0230_current_pastdues = r0230_current_pastdues;
		}
		public BigDecimal getR0230_less30days_pastdues() {
			return r0230_less30days_pastdues;
		}
		public void setR0230_less30days_pastdues(BigDecimal r0230_less30days_pastdues) {
			this.r0230_less30days_pastdues = r0230_less30days_pastdues;
		}
		public BigDecimal getR0230_31to90days_pastdues() {
			return r0230_31to90days_pastdues;
		}
		public void setR0230_31to90days_pastdues(BigDecimal r0230_31to90days_pastdues) {
			this.r0230_31to90days_pastdues = r0230_31to90days_pastdues;
		}
		public BigDecimal getR0230_91to120days_pastdues() {
			return r0230_91to120days_pastdues;
		}
		public void setR0230_91to120days_pastdues(BigDecimal r0230_91to120days_pastdues) {
			this.r0230_91to120days_pastdues = r0230_91to120days_pastdues;
		}
		public BigDecimal getR0230_121to180days_pastdues() {
			return r0230_121to180days_pastdues;
		}
		public void setR0230_121to180days_pastdues(BigDecimal r0230_121to180days_pastdues) {
			this.r0230_121to180days_pastdues = r0230_121to180days_pastdues;
		}
		public BigDecimal getR0230_181to365days_pastdues() {
			return r0230_181to365days_pastdues;
		}
		public void setR0230_181to365days_pastdues(BigDecimal r0230_181to365days_pastdues) {
			this.r0230_181to365days_pastdues = r0230_181to365days_pastdues;
		}
		public BigDecimal getR0230_over365days_pastdues() {
			return r0230_over365days_pastdues;
		}
		public void setR0230_over365days_pastdues(BigDecimal r0230_over365days_pastdues) {
			this.r0230_over365days_pastdues = r0230_over365days_pastdues;
		}
		public BigDecimal getR0230_total_pastdues() {
			return r0230_total_pastdues;
		}
		public void setR0230_total_pastdues(BigDecimal r0230_total_pastdues) {
			this.r0230_total_pastdues = r0230_total_pastdues;
		}
		public BigDecimal getR0230_newloan_duringreport() {
			return r0230_newloan_duringreport;
		}
		public void setR0230_newloan_duringreport(BigDecimal r0230_newloan_duringreport) {
			this.r0230_newloan_duringreport = r0230_newloan_duringreport;
		}
		public BigDecimal getR0230_newstage_duringreport() {
			return r0230_newstage_duringreport;
		}
		public void setR0230_newstage_duringreport(BigDecimal r0230_newstage_duringreport) {
			this.r0230_newstage_duringreport = r0230_newstage_duringreport;
		}
		public BigDecimal getR0230_intrestfees_duringreport() {
			return r0230_intrestfees_duringreport;
		}
		public void setR0230_intrestfees_duringreport(BigDecimal r0230_intrestfees_duringreport) {
			this.r0230_intrestfees_duringreport = r0230_intrestfees_duringreport;
		}
		public BigDecimal getR0230_performingac_acinfo() {
			return r0230_performingac_acinfo;
		}
		public void setR0230_performingac_acinfo(BigDecimal r0230_performingac_acinfo) {
			this.r0230_performingac_acinfo = r0230_performingac_acinfo;
		}
		public BigDecimal getR0230_nonperformingac_acinfo() {
			return r0230_nonperformingac_acinfo;
		}
		public void setR0230_nonperformingac_acinfo(BigDecimal r0230_nonperformingac_acinfo) {
			this.r0230_nonperformingac_acinfo = r0230_nonperformingac_acinfo;
		}
		public String getR0240_product() {
			return r0240_product;
		}
		public void setR0240_product(String r0240_product) {
			this.r0240_product = r0240_product;
		}
		public BigDecimal getR0240_outstandbal() {
			return r0240_outstandbal;
		}
		public void setR0240_outstandbal(BigDecimal r0240_outstandbal) {
			this.r0240_outstandbal = r0240_outstandbal;
		}
		public BigDecimal getR0240_secured_outstandbal() {
			return r0240_secured_outstandbal;
		}
		public void setR0240_secured_outstandbal(BigDecimal r0240_secured_outstandbal) {
			this.r0240_secured_outstandbal = r0240_secured_outstandbal;
		}
		public BigDecimal getR0240_unsecured_outstandbal() {
			return r0240_unsecured_outstandbal;
		}
		public void setR0240_unsecured_outstandbal(BigDecimal r0240_unsecured_outstandbal) {
			this.r0240_unsecured_outstandbal = r0240_unsecured_outstandbal;
		}
		public BigDecimal getR0240_stage1_assetclass() {
			return r0240_stage1_assetclass;
		}
		public void setR0240_stage1_assetclass(BigDecimal r0240_stage1_assetclass) {
			this.r0240_stage1_assetclass = r0240_stage1_assetclass;
		}
		public BigDecimal getR0240_stage2_assetclass() {
			return r0240_stage2_assetclass;
		}
		public void setR0240_stage2_assetclass(BigDecimal r0240_stage2_assetclass) {
			this.r0240_stage2_assetclass = r0240_stage2_assetclass;
		}
		public BigDecimal getR0240_stage3a_assetclass() {
			return r0240_stage3a_assetclass;
		}
		public void setR0240_stage3a_assetclass(BigDecimal r0240_stage3a_assetclass) {
			this.r0240_stage3a_assetclass = r0240_stage3a_assetclass;
		}
		public BigDecimal getR0240_stage3b_assetclass() {
			return r0240_stage3b_assetclass;
		}
		public void setR0240_stage3b_assetclass(BigDecimal r0240_stage3b_assetclass) {
			this.r0240_stage3b_assetclass = r0240_stage3b_assetclass;
		}
		public BigDecimal getR0240_stage3c_assetclass() {
			return r0240_stage3c_assetclass;
		}
		public void setR0240_stage3c_assetclass(BigDecimal r0240_stage3c_assetclass) {
			this.r0240_stage3c_assetclass = r0240_stage3c_assetclass;
		}
		public BigDecimal getR0240_stage1_provisionheld() {
			return r0240_stage1_provisionheld;
		}
		public void setR0240_stage1_provisionheld(BigDecimal r0240_stage1_provisionheld) {
			this.r0240_stage1_provisionheld = r0240_stage1_provisionheld;
		}
		public BigDecimal getR0240_stage2_provisionheld() {
			return r0240_stage2_provisionheld;
		}
		public void setR0240_stage2_provisionheld(BigDecimal r0240_stage2_provisionheld) {
			this.r0240_stage2_provisionheld = r0240_stage2_provisionheld;
		}
		public BigDecimal getR0240_stage3a_provisionheld() {
			return r0240_stage3a_provisionheld;
		}
		public void setR0240_stage3a_provisionheld(BigDecimal r0240_stage3a_provisionheld) {
			this.r0240_stage3a_provisionheld = r0240_stage3a_provisionheld;
		}
		public BigDecimal getR0240_stage3b_provisionheld() {
			return r0240_stage3b_provisionheld;
		}
		public void setR0240_stage3b_provisionheld(BigDecimal r0240_stage3b_provisionheld) {
			this.r0240_stage3b_provisionheld = r0240_stage3b_provisionheld;
		}
		public BigDecimal getR0240_stage3c_provisionheld() {
			return r0240_stage3c_provisionheld;
		}
		public void setR0240_stage3c_provisionheld(BigDecimal r0240_stage3c_provisionheld) {
			this.r0240_stage3c_provisionheld = r0240_stage3c_provisionheld;
		}
		public BigDecimal getR0240_intrestfees_provisionheld() {
			return r0240_intrestfees_provisionheld;
		}
		public void setR0240_intrestfees_provisionheld(BigDecimal r0240_intrestfees_provisionheld) {
			this.r0240_intrestfees_provisionheld = r0240_intrestfees_provisionheld;
		}
		public BigDecimal getR0240_intrestsuspense_provisionheld() {
			return r0240_intrestsuspense_provisionheld;
		}
		public void setR0240_intrestsuspense_provisionheld(BigDecimal r0240_intrestsuspense_provisionheld) {
			this.r0240_intrestsuspense_provisionheld = r0240_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0240_stage1_poci() {
			return r0240_stage1_poci;
		}
		public void setR0240_stage1_poci(BigDecimal r0240_stage1_poci) {
			this.r0240_stage1_poci = r0240_stage1_poci;
		}
		public BigDecimal getR0240_stage2_poci() {
			return r0240_stage2_poci;
		}
		public void setR0240_stage2_poci(BigDecimal r0240_stage2_poci) {
			this.r0240_stage2_poci = r0240_stage2_poci;
		}
		public BigDecimal getR0240_stage3a_poci() {
			return r0240_stage3a_poci;
		}
		public void setR0240_stage3a_poci(BigDecimal r0240_stage3a_poci) {
			this.r0240_stage3a_poci = r0240_stage3a_poci;
		}
		public BigDecimal getR0240_stage3b_poci() {
			return r0240_stage3b_poci;
		}
		public void setR0240_stage3b_poci(BigDecimal r0240_stage3b_poci) {
			this.r0240_stage3b_poci = r0240_stage3b_poci;
		}
		public BigDecimal getR0240_stage3c_poci() {
			return r0240_stage3c_poci;
		}
		public void setR0240_stage3c_poci(BigDecimal r0240_stage3c_poci) {
			this.r0240_stage3c_poci = r0240_stage3c_poci;
		}
		public BigDecimal getR0240_current_pastdues() {
			return r0240_current_pastdues;
		}
		public void setR0240_current_pastdues(BigDecimal r0240_current_pastdues) {
			this.r0240_current_pastdues = r0240_current_pastdues;
		}
		public BigDecimal getR0240_less30days_pastdues() {
			return r0240_less30days_pastdues;
		}
		public void setR0240_less30days_pastdues(BigDecimal r0240_less30days_pastdues) {
			this.r0240_less30days_pastdues = r0240_less30days_pastdues;
		}
		public BigDecimal getR0240_31to90days_pastdues() {
			return r0240_31to90days_pastdues;
		}
		public void setR0240_31to90days_pastdues(BigDecimal r0240_31to90days_pastdues) {
			this.r0240_31to90days_pastdues = r0240_31to90days_pastdues;
		}
		public BigDecimal getR0240_91to120days_pastdues() {
			return r0240_91to120days_pastdues;
		}
		public void setR0240_91to120days_pastdues(BigDecimal r0240_91to120days_pastdues) {
			this.r0240_91to120days_pastdues = r0240_91to120days_pastdues;
		}
		public BigDecimal getR0240_121to180days_pastdues() {
			return r0240_121to180days_pastdues;
		}
		public void setR0240_121to180days_pastdues(BigDecimal r0240_121to180days_pastdues) {
			this.r0240_121to180days_pastdues = r0240_121to180days_pastdues;
		}
		public BigDecimal getR0240_181to365days_pastdues() {
			return r0240_181to365days_pastdues;
		}
		public void setR0240_181to365days_pastdues(BigDecimal r0240_181to365days_pastdues) {
			this.r0240_181to365days_pastdues = r0240_181to365days_pastdues;
		}
		public BigDecimal getR0240_over365days_pastdues() {
			return r0240_over365days_pastdues;
		}
		public void setR0240_over365days_pastdues(BigDecimal r0240_over365days_pastdues) {
			this.r0240_over365days_pastdues = r0240_over365days_pastdues;
		}
		public BigDecimal getR0240_total_pastdues() {
			return r0240_total_pastdues;
		}
		public void setR0240_total_pastdues(BigDecimal r0240_total_pastdues) {
			this.r0240_total_pastdues = r0240_total_pastdues;
		}
		public BigDecimal getR0240_newloan_duringreport() {
			return r0240_newloan_duringreport;
		}
		public void setR0240_newloan_duringreport(BigDecimal r0240_newloan_duringreport) {
			this.r0240_newloan_duringreport = r0240_newloan_duringreport;
		}
		public BigDecimal getR0240_newstage_duringreport() {
			return r0240_newstage_duringreport;
		}
		public void setR0240_newstage_duringreport(BigDecimal r0240_newstage_duringreport) {
			this.r0240_newstage_duringreport = r0240_newstage_duringreport;
		}
		public BigDecimal getR0240_intrestfees_duringreport() {
			return r0240_intrestfees_duringreport;
		}
		public void setR0240_intrestfees_duringreport(BigDecimal r0240_intrestfees_duringreport) {
			this.r0240_intrestfees_duringreport = r0240_intrestfees_duringreport;
		}
		public BigDecimal getR0240_performingac_acinfo() {
			return r0240_performingac_acinfo;
		}
		public void setR0240_performingac_acinfo(BigDecimal r0240_performingac_acinfo) {
			this.r0240_performingac_acinfo = r0240_performingac_acinfo;
		}
		public BigDecimal getR0240_nonperformingac_acinfo() {
			return r0240_nonperformingac_acinfo;
		}
		public void setR0240_nonperformingac_acinfo(BigDecimal r0240_nonperformingac_acinfo) {
			this.r0240_nonperformingac_acinfo = r0240_nonperformingac_acinfo;
		}
		public String getR0250_product() {
			return r0250_product;
		}
		public void setR0250_product(String r0250_product) {
			this.r0250_product = r0250_product;
		}
		public BigDecimal getR0250_outstandbal() {
			return r0250_outstandbal;
		}
		public void setR0250_outstandbal(BigDecimal r0250_outstandbal) {
			this.r0250_outstandbal = r0250_outstandbal;
		}
		public BigDecimal getR0250_secured_outstandbal() {
			return r0250_secured_outstandbal;
		}
		public void setR0250_secured_outstandbal(BigDecimal r0250_secured_outstandbal) {
			this.r0250_secured_outstandbal = r0250_secured_outstandbal;
		}
		public BigDecimal getR0250_unsecured_outstandbal() {
			return r0250_unsecured_outstandbal;
		}
		public void setR0250_unsecured_outstandbal(BigDecimal r0250_unsecured_outstandbal) {
			this.r0250_unsecured_outstandbal = r0250_unsecured_outstandbal;
		}
		public BigDecimal getR0250_stage1_assetclass() {
			return r0250_stage1_assetclass;
		}
		public void setR0250_stage1_assetclass(BigDecimal r0250_stage1_assetclass) {
			this.r0250_stage1_assetclass = r0250_stage1_assetclass;
		}
		public BigDecimal getR0250_stage2_assetclass() {
			return r0250_stage2_assetclass;
		}
		public void setR0250_stage2_assetclass(BigDecimal r0250_stage2_assetclass) {
			this.r0250_stage2_assetclass = r0250_stage2_assetclass;
		}
		public BigDecimal getR0250_stage3a_assetclass() {
			return r0250_stage3a_assetclass;
		}
		public void setR0250_stage3a_assetclass(BigDecimal r0250_stage3a_assetclass) {
			this.r0250_stage3a_assetclass = r0250_stage3a_assetclass;
		}
		public BigDecimal getR0250_stage3b_assetclass() {
			return r0250_stage3b_assetclass;
		}
		public void setR0250_stage3b_assetclass(BigDecimal r0250_stage3b_assetclass) {
			this.r0250_stage3b_assetclass = r0250_stage3b_assetclass;
		}
		public BigDecimal getR0250_stage3c_assetclass() {
			return r0250_stage3c_assetclass;
		}
		public void setR0250_stage3c_assetclass(BigDecimal r0250_stage3c_assetclass) {
			this.r0250_stage3c_assetclass = r0250_stage3c_assetclass;
		}
		public BigDecimal getR0250_stage1_provisionheld() {
			return r0250_stage1_provisionheld;
		}
		public void setR0250_stage1_provisionheld(BigDecimal r0250_stage1_provisionheld) {
			this.r0250_stage1_provisionheld = r0250_stage1_provisionheld;
		}
		public BigDecimal getR0250_stage2_provisionheld() {
			return r0250_stage2_provisionheld;
		}
		public void setR0250_stage2_provisionheld(BigDecimal r0250_stage2_provisionheld) {
			this.r0250_stage2_provisionheld = r0250_stage2_provisionheld;
		}
		public BigDecimal getR0250_stage3a_provisionheld() {
			return r0250_stage3a_provisionheld;
		}
		public void setR0250_stage3a_provisionheld(BigDecimal r0250_stage3a_provisionheld) {
			this.r0250_stage3a_provisionheld = r0250_stage3a_provisionheld;
		}
		public BigDecimal getR0250_stage3b_provisionheld() {
			return r0250_stage3b_provisionheld;
		}
		public void setR0250_stage3b_provisionheld(BigDecimal r0250_stage3b_provisionheld) {
			this.r0250_stage3b_provisionheld = r0250_stage3b_provisionheld;
		}
		public BigDecimal getR0250_stage3c_provisionheld() {
			return r0250_stage3c_provisionheld;
		}
		public void setR0250_stage3c_provisionheld(BigDecimal r0250_stage3c_provisionheld) {
			this.r0250_stage3c_provisionheld = r0250_stage3c_provisionheld;
		}
		public BigDecimal getR0250_intrestfees_provisionheld() {
			return r0250_intrestfees_provisionheld;
		}
		public void setR0250_intrestfees_provisionheld(BigDecimal r0250_intrestfees_provisionheld) {
			this.r0250_intrestfees_provisionheld = r0250_intrestfees_provisionheld;
		}
		public BigDecimal getR0250_intrestsuspense_provisionheld() {
			return r0250_intrestsuspense_provisionheld;
		}
		public void setR0250_intrestsuspense_provisionheld(BigDecimal r0250_intrestsuspense_provisionheld) {
			this.r0250_intrestsuspense_provisionheld = r0250_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0250_stage1_poci() {
			return r0250_stage1_poci;
		}
		public void setR0250_stage1_poci(BigDecimal r0250_stage1_poci) {
			this.r0250_stage1_poci = r0250_stage1_poci;
		}
		public BigDecimal getR0250_stage2_poci() {
			return r0250_stage2_poci;
		}
		public void setR0250_stage2_poci(BigDecimal r0250_stage2_poci) {
			this.r0250_stage2_poci = r0250_stage2_poci;
		}
		public BigDecimal getR0250_stage3a_poci() {
			return r0250_stage3a_poci;
		}
		public void setR0250_stage3a_poci(BigDecimal r0250_stage3a_poci) {
			this.r0250_stage3a_poci = r0250_stage3a_poci;
		}
		public BigDecimal getR0250_stage3b_poci() {
			return r0250_stage3b_poci;
		}
		public void setR0250_stage3b_poci(BigDecimal r0250_stage3b_poci) {
			this.r0250_stage3b_poci = r0250_stage3b_poci;
		}
		public BigDecimal getR0250_stage3c_poci() {
			return r0250_stage3c_poci;
		}
		public void setR0250_stage3c_poci(BigDecimal r0250_stage3c_poci) {
			this.r0250_stage3c_poci = r0250_stage3c_poci;
		}
		public BigDecimal getR0250_current_pastdues() {
			return r0250_current_pastdues;
		}
		public void setR0250_current_pastdues(BigDecimal r0250_current_pastdues) {
			this.r0250_current_pastdues = r0250_current_pastdues;
		}
		public BigDecimal getR0250_less30days_pastdues() {
			return r0250_less30days_pastdues;
		}
		public void setR0250_less30days_pastdues(BigDecimal r0250_less30days_pastdues) {
			this.r0250_less30days_pastdues = r0250_less30days_pastdues;
		}
		public BigDecimal getR0250_31to90days_pastdues() {
			return r0250_31to90days_pastdues;
		}
		public void setR0250_31to90days_pastdues(BigDecimal r0250_31to90days_pastdues) {
			this.r0250_31to90days_pastdues = r0250_31to90days_pastdues;
		}
		public BigDecimal getR0250_91to120days_pastdues() {
			return r0250_91to120days_pastdues;
		}
		public void setR0250_91to120days_pastdues(BigDecimal r0250_91to120days_pastdues) {
			this.r0250_91to120days_pastdues = r0250_91to120days_pastdues;
		}
		public BigDecimal getR0250_121to180days_pastdues() {
			return r0250_121to180days_pastdues;
		}
		public void setR0250_121to180days_pastdues(BigDecimal r0250_121to180days_pastdues) {
			this.r0250_121to180days_pastdues = r0250_121to180days_pastdues;
		}
		public BigDecimal getR0250_181to365days_pastdues() {
			return r0250_181to365days_pastdues;
		}
		public void setR0250_181to365days_pastdues(BigDecimal r0250_181to365days_pastdues) {
			this.r0250_181to365days_pastdues = r0250_181to365days_pastdues;
		}
		public BigDecimal getR0250_over365days_pastdues() {
			return r0250_over365days_pastdues;
		}
		public void setR0250_over365days_pastdues(BigDecimal r0250_over365days_pastdues) {
			this.r0250_over365days_pastdues = r0250_over365days_pastdues;
		}
		public BigDecimal getR0250_total_pastdues() {
			return r0250_total_pastdues;
		}
		public void setR0250_total_pastdues(BigDecimal r0250_total_pastdues) {
			this.r0250_total_pastdues = r0250_total_pastdues;
		}
		public BigDecimal getR0250_newloan_duringreport() {
			return r0250_newloan_duringreport;
		}
		public void setR0250_newloan_duringreport(BigDecimal r0250_newloan_duringreport) {
			this.r0250_newloan_duringreport = r0250_newloan_duringreport;
		}
		public BigDecimal getR0250_newstage_duringreport() {
			return r0250_newstage_duringreport;
		}
		public void setR0250_newstage_duringreport(BigDecimal r0250_newstage_duringreport) {
			this.r0250_newstage_duringreport = r0250_newstage_duringreport;
		}
		public BigDecimal getR0250_intrestfees_duringreport() {
			return r0250_intrestfees_duringreport;
		}
		public void setR0250_intrestfees_duringreport(BigDecimal r0250_intrestfees_duringreport) {
			this.r0250_intrestfees_duringreport = r0250_intrestfees_duringreport;
		}
		public BigDecimal getR0250_performingac_acinfo() {
			return r0250_performingac_acinfo;
		}
		public void setR0250_performingac_acinfo(BigDecimal r0250_performingac_acinfo) {
			this.r0250_performingac_acinfo = r0250_performingac_acinfo;
		}
		public BigDecimal getR0250_nonperformingac_acinfo() {
			return r0250_nonperformingac_acinfo;
		}
		public void setR0250_nonperformingac_acinfo(BigDecimal r0250_nonperformingac_acinfo) {
			this.r0250_nonperformingac_acinfo = r0250_nonperformingac_acinfo;
		}
		public String getR0260_product() {
			return r0260_product;
		}
		public void setR0260_product(String r0260_product) {
			this.r0260_product = r0260_product;
		}
		public BigDecimal getR0260_outstandbal() {
			return r0260_outstandbal;
		}
		public void setR0260_outstandbal(BigDecimal r0260_outstandbal) {
			this.r0260_outstandbal = r0260_outstandbal;
		}
		public BigDecimal getR0260_secured_outstandbal() {
			return r0260_secured_outstandbal;
		}
		public void setR0260_secured_outstandbal(BigDecimal r0260_secured_outstandbal) {
			this.r0260_secured_outstandbal = r0260_secured_outstandbal;
		}
		public BigDecimal getR0260_unsecured_outstandbal() {
			return r0260_unsecured_outstandbal;
		}
		public void setR0260_unsecured_outstandbal(BigDecimal r0260_unsecured_outstandbal) {
			this.r0260_unsecured_outstandbal = r0260_unsecured_outstandbal;
		}
		public BigDecimal getR0260_stage1_assetclass() {
			return r0260_stage1_assetclass;
		}
		public void setR0260_stage1_assetclass(BigDecimal r0260_stage1_assetclass) {
			this.r0260_stage1_assetclass = r0260_stage1_assetclass;
		}
		public BigDecimal getR0260_stage2_assetclass() {
			return r0260_stage2_assetclass;
		}
		public void setR0260_stage2_assetclass(BigDecimal r0260_stage2_assetclass) {
			this.r0260_stage2_assetclass = r0260_stage2_assetclass;
		}
		public BigDecimal getR0260_stage3a_assetclass() {
			return r0260_stage3a_assetclass;
		}
		public void setR0260_stage3a_assetclass(BigDecimal r0260_stage3a_assetclass) {
			this.r0260_stage3a_assetclass = r0260_stage3a_assetclass;
		}
		public BigDecimal getR0260_stage3b_assetclass() {
			return r0260_stage3b_assetclass;
		}
		public void setR0260_stage3b_assetclass(BigDecimal r0260_stage3b_assetclass) {
			this.r0260_stage3b_assetclass = r0260_stage3b_assetclass;
		}
		public BigDecimal getR0260_stage3c_assetclass() {
			return r0260_stage3c_assetclass;
		}
		public void setR0260_stage3c_assetclass(BigDecimal r0260_stage3c_assetclass) {
			this.r0260_stage3c_assetclass = r0260_stage3c_assetclass;
		}
		public BigDecimal getR0260_stage1_provisionheld() {
			return r0260_stage1_provisionheld;
		}
		public void setR0260_stage1_provisionheld(BigDecimal r0260_stage1_provisionheld) {
			this.r0260_stage1_provisionheld = r0260_stage1_provisionheld;
		}
		public BigDecimal getR0260_stage2_provisionheld() {
			return r0260_stage2_provisionheld;
		}
		public void setR0260_stage2_provisionheld(BigDecimal r0260_stage2_provisionheld) {
			this.r0260_stage2_provisionheld = r0260_stage2_provisionheld;
		}
		public BigDecimal getR0260_stage3a_provisionheld() {
			return r0260_stage3a_provisionheld;
		}
		public void setR0260_stage3a_provisionheld(BigDecimal r0260_stage3a_provisionheld) {
			this.r0260_stage3a_provisionheld = r0260_stage3a_provisionheld;
		}
		public BigDecimal getR0260_stage3b_provisionheld() {
			return r0260_stage3b_provisionheld;
		}
		public void setR0260_stage3b_provisionheld(BigDecimal r0260_stage3b_provisionheld) {
			this.r0260_stage3b_provisionheld = r0260_stage3b_provisionheld;
		}
		public BigDecimal getR0260_stage3c_provisionheld() {
			return r0260_stage3c_provisionheld;
		}
		public void setR0260_stage3c_provisionheld(BigDecimal r0260_stage3c_provisionheld) {
			this.r0260_stage3c_provisionheld = r0260_stage3c_provisionheld;
		}
		public BigDecimal getR0260_intrestfees_provisionheld() {
			return r0260_intrestfees_provisionheld;
		}
		public void setR0260_intrestfees_provisionheld(BigDecimal r0260_intrestfees_provisionheld) {
			this.r0260_intrestfees_provisionheld = r0260_intrestfees_provisionheld;
		}
		public BigDecimal getR0260_intrestsuspense_provisionheld() {
			return r0260_intrestsuspense_provisionheld;
		}
		public void setR0260_intrestsuspense_provisionheld(BigDecimal r0260_intrestsuspense_provisionheld) {
			this.r0260_intrestsuspense_provisionheld = r0260_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0260_stage1_poci() {
			return r0260_stage1_poci;
		}
		public void setR0260_stage1_poci(BigDecimal r0260_stage1_poci) {
			this.r0260_stage1_poci = r0260_stage1_poci;
		}
		public BigDecimal getR0260_stage2_poci() {
			return r0260_stage2_poci;
		}
		public void setR0260_stage2_poci(BigDecimal r0260_stage2_poci) {
			this.r0260_stage2_poci = r0260_stage2_poci;
		}
		public BigDecimal getR0260_stage3a_poci() {
			return r0260_stage3a_poci;
		}
		public void setR0260_stage3a_poci(BigDecimal r0260_stage3a_poci) {
			this.r0260_stage3a_poci = r0260_stage3a_poci;
		}
		public BigDecimal getR0260_stage3b_poci() {
			return r0260_stage3b_poci;
		}
		public void setR0260_stage3b_poci(BigDecimal r0260_stage3b_poci) {
			this.r0260_stage3b_poci = r0260_stage3b_poci;
		}
		public BigDecimal getR0260_stage3c_poci() {
			return r0260_stage3c_poci;
		}
		public void setR0260_stage3c_poci(BigDecimal r0260_stage3c_poci) {
			this.r0260_stage3c_poci = r0260_stage3c_poci;
		}
		public BigDecimal getR0260_current_pastdues() {
			return r0260_current_pastdues;
		}
		public void setR0260_current_pastdues(BigDecimal r0260_current_pastdues) {
			this.r0260_current_pastdues = r0260_current_pastdues;
		}
		public BigDecimal getR0260_less30days_pastdues() {
			return r0260_less30days_pastdues;
		}
		public void setR0260_less30days_pastdues(BigDecimal r0260_less30days_pastdues) {
			this.r0260_less30days_pastdues = r0260_less30days_pastdues;
		}
		public BigDecimal getR0260_31to90days_pastdues() {
			return r0260_31to90days_pastdues;
		}
		public void setR0260_31to90days_pastdues(BigDecimal r0260_31to90days_pastdues) {
			this.r0260_31to90days_pastdues = r0260_31to90days_pastdues;
		}
		public BigDecimal getR0260_91to120days_pastdues() {
			return r0260_91to120days_pastdues;
		}
		public void setR0260_91to120days_pastdues(BigDecimal r0260_91to120days_pastdues) {
			this.r0260_91to120days_pastdues = r0260_91to120days_pastdues;
		}
		public BigDecimal getR0260_121to180days_pastdues() {
			return r0260_121to180days_pastdues;
		}
		public void setR0260_121to180days_pastdues(BigDecimal r0260_121to180days_pastdues) {
			this.r0260_121to180days_pastdues = r0260_121to180days_pastdues;
		}
		public BigDecimal getR0260_181to365days_pastdues() {
			return r0260_181to365days_pastdues;
		}
		public void setR0260_181to365days_pastdues(BigDecimal r0260_181to365days_pastdues) {
			this.r0260_181to365days_pastdues = r0260_181to365days_pastdues;
		}
		public BigDecimal getR0260_over365days_pastdues() {
			return r0260_over365days_pastdues;
		}
		public void setR0260_over365days_pastdues(BigDecimal r0260_over365days_pastdues) {
			this.r0260_over365days_pastdues = r0260_over365days_pastdues;
		}
		public BigDecimal getR0260_total_pastdues() {
			return r0260_total_pastdues;
		}
		public void setR0260_total_pastdues(BigDecimal r0260_total_pastdues) {
			this.r0260_total_pastdues = r0260_total_pastdues;
		}
		public BigDecimal getR0260_newloan_duringreport() {
			return r0260_newloan_duringreport;
		}
		public void setR0260_newloan_duringreport(BigDecimal r0260_newloan_duringreport) {
			this.r0260_newloan_duringreport = r0260_newloan_duringreport;
		}
		public BigDecimal getR0260_newstage_duringreport() {
			return r0260_newstage_duringreport;
		}
		public void setR0260_newstage_duringreport(BigDecimal r0260_newstage_duringreport) {
			this.r0260_newstage_duringreport = r0260_newstage_duringreport;
		}
		public BigDecimal getR0260_intrestfees_duringreport() {
			return r0260_intrestfees_duringreport;
		}
		public void setR0260_intrestfees_duringreport(BigDecimal r0260_intrestfees_duringreport) {
			this.r0260_intrestfees_duringreport = r0260_intrestfees_duringreport;
		}
		public BigDecimal getR0260_performingac_acinfo() {
			return r0260_performingac_acinfo;
		}
		public void setR0260_performingac_acinfo(BigDecimal r0260_performingac_acinfo) {
			this.r0260_performingac_acinfo = r0260_performingac_acinfo;
		}
		public BigDecimal getR0260_nonperformingac_acinfo() {
			return r0260_nonperformingac_acinfo;
		}
		public void setR0260_nonperformingac_acinfo(BigDecimal r0260_nonperformingac_acinfo) {
			this.r0260_nonperformingac_acinfo = r0260_nonperformingac_acinfo;
		}
		public String getR0270_product() {
			return r0270_product;
		}
		public void setR0270_product(String r0270_product) {
			this.r0270_product = r0270_product;
		}
		public BigDecimal getR0270_outstandbal() {
			return r0270_outstandbal;
		}
		public void setR0270_outstandbal(BigDecimal r0270_outstandbal) {
			this.r0270_outstandbal = r0270_outstandbal;
		}
		public BigDecimal getR0270_secured_outstandbal() {
			return r0270_secured_outstandbal;
		}
		public void setR0270_secured_outstandbal(BigDecimal r0270_secured_outstandbal) {
			this.r0270_secured_outstandbal = r0270_secured_outstandbal;
		}
		public BigDecimal getR0270_unsecured_outstandbal() {
			return r0270_unsecured_outstandbal;
		}
		public void setR0270_unsecured_outstandbal(BigDecimal r0270_unsecured_outstandbal) {
			this.r0270_unsecured_outstandbal = r0270_unsecured_outstandbal;
		}
		public BigDecimal getR0270_stage1_assetclass() {
			return r0270_stage1_assetclass;
		}
		public void setR0270_stage1_assetclass(BigDecimal r0270_stage1_assetclass) {
			this.r0270_stage1_assetclass = r0270_stage1_assetclass;
		}
		public BigDecimal getR0270_stage2_assetclass() {
			return r0270_stage2_assetclass;
		}
		public void setR0270_stage2_assetclass(BigDecimal r0270_stage2_assetclass) {
			this.r0270_stage2_assetclass = r0270_stage2_assetclass;
		}
		public BigDecimal getR0270_stage3a_assetclass() {
			return r0270_stage3a_assetclass;
		}
		public void setR0270_stage3a_assetclass(BigDecimal r0270_stage3a_assetclass) {
			this.r0270_stage3a_assetclass = r0270_stage3a_assetclass;
		}
		public BigDecimal getR0270_stage3b_assetclass() {
			return r0270_stage3b_assetclass;
		}
		public void setR0270_stage3b_assetclass(BigDecimal r0270_stage3b_assetclass) {
			this.r0270_stage3b_assetclass = r0270_stage3b_assetclass;
		}
		public BigDecimal getR0270_stage3c_assetclass() {
			return r0270_stage3c_assetclass;
		}
		public void setR0270_stage3c_assetclass(BigDecimal r0270_stage3c_assetclass) {
			this.r0270_stage3c_assetclass = r0270_stage3c_assetclass;
		}
		public BigDecimal getR0270_stage1_provisionheld() {
			return r0270_stage1_provisionheld;
		}
		public void setR0270_stage1_provisionheld(BigDecimal r0270_stage1_provisionheld) {
			this.r0270_stage1_provisionheld = r0270_stage1_provisionheld;
		}
		public BigDecimal getR0270_stage2_provisionheld() {
			return r0270_stage2_provisionheld;
		}
		public void setR0270_stage2_provisionheld(BigDecimal r0270_stage2_provisionheld) {
			this.r0270_stage2_provisionheld = r0270_stage2_provisionheld;
		}
		public BigDecimal getR0270_stage3a_provisionheld() {
			return r0270_stage3a_provisionheld;
		}
		public void setR0270_stage3a_provisionheld(BigDecimal r0270_stage3a_provisionheld) {
			this.r0270_stage3a_provisionheld = r0270_stage3a_provisionheld;
		}
		public BigDecimal getR0270_stage3b_provisionheld() {
			return r0270_stage3b_provisionheld;
		}
		public void setR0270_stage3b_provisionheld(BigDecimal r0270_stage3b_provisionheld) {
			this.r0270_stage3b_provisionheld = r0270_stage3b_provisionheld;
		}
		public BigDecimal getR0270_stage3c_provisionheld() {
			return r0270_stage3c_provisionheld;
		}
		public void setR0270_stage3c_provisionheld(BigDecimal r0270_stage3c_provisionheld) {
			this.r0270_stage3c_provisionheld = r0270_stage3c_provisionheld;
		}
		public BigDecimal getR0270_intrestfees_provisionheld() {
			return r0270_intrestfees_provisionheld;
		}
		public void setR0270_intrestfees_provisionheld(BigDecimal r0270_intrestfees_provisionheld) {
			this.r0270_intrestfees_provisionheld = r0270_intrestfees_provisionheld;
		}
		public BigDecimal getR0270_intrestsuspense_provisionheld() {
			return r0270_intrestsuspense_provisionheld;
		}
		public void setR0270_intrestsuspense_provisionheld(BigDecimal r0270_intrestsuspense_provisionheld) {
			this.r0270_intrestsuspense_provisionheld = r0270_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0270_stage1_poci() {
			return r0270_stage1_poci;
		}
		public void setR0270_stage1_poci(BigDecimal r0270_stage1_poci) {
			this.r0270_stage1_poci = r0270_stage1_poci;
		}
		public BigDecimal getR0270_stage2_poci() {
			return r0270_stage2_poci;
		}
		public void setR0270_stage2_poci(BigDecimal r0270_stage2_poci) {
			this.r0270_stage2_poci = r0270_stage2_poci;
		}
		public BigDecimal getR0270_stage3a_poci() {
			return r0270_stage3a_poci;
		}
		public void setR0270_stage3a_poci(BigDecimal r0270_stage3a_poci) {
			this.r0270_stage3a_poci = r0270_stage3a_poci;
		}
		public BigDecimal getR0270_stage3b_poci() {
			return r0270_stage3b_poci;
		}
		public void setR0270_stage3b_poci(BigDecimal r0270_stage3b_poci) {
			this.r0270_stage3b_poci = r0270_stage3b_poci;
		}
		public BigDecimal getR0270_stage3c_poci() {
			return r0270_stage3c_poci;
		}
		public void setR0270_stage3c_poci(BigDecimal r0270_stage3c_poci) {
			this.r0270_stage3c_poci = r0270_stage3c_poci;
		}
		public BigDecimal getR0270_current_pastdues() {
			return r0270_current_pastdues;
		}
		public void setR0270_current_pastdues(BigDecimal r0270_current_pastdues) {
			this.r0270_current_pastdues = r0270_current_pastdues;
		}
		public BigDecimal getR0270_less30days_pastdues() {
			return r0270_less30days_pastdues;
		}
		public void setR0270_less30days_pastdues(BigDecimal r0270_less30days_pastdues) {
			this.r0270_less30days_pastdues = r0270_less30days_pastdues;
		}
		public BigDecimal getR0270_31to90days_pastdues() {
			return r0270_31to90days_pastdues;
		}
		public void setR0270_31to90days_pastdues(BigDecimal r0270_31to90days_pastdues) {
			this.r0270_31to90days_pastdues = r0270_31to90days_pastdues;
		}
		public BigDecimal getR0270_91to120days_pastdues() {
			return r0270_91to120days_pastdues;
		}
		public void setR0270_91to120days_pastdues(BigDecimal r0270_91to120days_pastdues) {
			this.r0270_91to120days_pastdues = r0270_91to120days_pastdues;
		}
		public BigDecimal getR0270_121to180days_pastdues() {
			return r0270_121to180days_pastdues;
		}
		public void setR0270_121to180days_pastdues(BigDecimal r0270_121to180days_pastdues) {
			this.r0270_121to180days_pastdues = r0270_121to180days_pastdues;
		}
		public BigDecimal getR0270_181to365days_pastdues() {
			return r0270_181to365days_pastdues;
		}
		public void setR0270_181to365days_pastdues(BigDecimal r0270_181to365days_pastdues) {
			this.r0270_181to365days_pastdues = r0270_181to365days_pastdues;
		}
		public BigDecimal getR0270_over365days_pastdues() {
			return r0270_over365days_pastdues;
		}
		public void setR0270_over365days_pastdues(BigDecimal r0270_over365days_pastdues) {
			this.r0270_over365days_pastdues = r0270_over365days_pastdues;
		}
		public BigDecimal getR0270_total_pastdues() {
			return r0270_total_pastdues;
		}
		public void setR0270_total_pastdues(BigDecimal r0270_total_pastdues) {
			this.r0270_total_pastdues = r0270_total_pastdues;
		}
		public BigDecimal getR0270_newloan_duringreport() {
			return r0270_newloan_duringreport;
		}
		public void setR0270_newloan_duringreport(BigDecimal r0270_newloan_duringreport) {
			this.r0270_newloan_duringreport = r0270_newloan_duringreport;
		}
		public BigDecimal getR0270_newstage_duringreport() {
			return r0270_newstage_duringreport;
		}
		public void setR0270_newstage_duringreport(BigDecimal r0270_newstage_duringreport) {
			this.r0270_newstage_duringreport = r0270_newstage_duringreport;
		}
		public BigDecimal getR0270_intrestfees_duringreport() {
			return r0270_intrestfees_duringreport;
		}
		public void setR0270_intrestfees_duringreport(BigDecimal r0270_intrestfees_duringreport) {
			this.r0270_intrestfees_duringreport = r0270_intrestfees_duringreport;
		}
		public BigDecimal getR0270_performingac_acinfo() {
			return r0270_performingac_acinfo;
		}
		public void setR0270_performingac_acinfo(BigDecimal r0270_performingac_acinfo) {
			this.r0270_performingac_acinfo = r0270_performingac_acinfo;
		}
		public BigDecimal getR0270_nonperformingac_acinfo() {
			return r0270_nonperformingac_acinfo;
		}
		public void setR0270_nonperformingac_acinfo(BigDecimal r0270_nonperformingac_acinfo) {
			this.r0270_nonperformingac_acinfo = r0270_nonperformingac_acinfo;
		}
		public String getR0280_product() {
			return r0280_product;
		}
		public void setR0280_product(String r0280_product) {
			this.r0280_product = r0280_product;
		}
		public BigDecimal getR0280_outstandbal() {
			return r0280_outstandbal;
		}
		public void setR0280_outstandbal(BigDecimal r0280_outstandbal) {
			this.r0280_outstandbal = r0280_outstandbal;
		}
		public BigDecimal getR0280_secured_outstandbal() {
			return r0280_secured_outstandbal;
		}
		public void setR0280_secured_outstandbal(BigDecimal r0280_secured_outstandbal) {
			this.r0280_secured_outstandbal = r0280_secured_outstandbal;
		}
		public BigDecimal getR0280_unsecured_outstandbal() {
			return r0280_unsecured_outstandbal;
		}
		public void setR0280_unsecured_outstandbal(BigDecimal r0280_unsecured_outstandbal) {
			this.r0280_unsecured_outstandbal = r0280_unsecured_outstandbal;
		}
		public BigDecimal getR0280_stage1_assetclass() {
			return r0280_stage1_assetclass;
		}
		public void setR0280_stage1_assetclass(BigDecimal r0280_stage1_assetclass) {
			this.r0280_stage1_assetclass = r0280_stage1_assetclass;
		}
		public BigDecimal getR0280_stage2_assetclass() {
			return r0280_stage2_assetclass;
		}
		public void setR0280_stage2_assetclass(BigDecimal r0280_stage2_assetclass) {
			this.r0280_stage2_assetclass = r0280_stage2_assetclass;
		}
		public BigDecimal getR0280_stage3a_assetclass() {
			return r0280_stage3a_assetclass;
		}
		public void setR0280_stage3a_assetclass(BigDecimal r0280_stage3a_assetclass) {
			this.r0280_stage3a_assetclass = r0280_stage3a_assetclass;
		}
		public BigDecimal getR0280_stage3b_assetclass() {
			return r0280_stage3b_assetclass;
		}
		public void setR0280_stage3b_assetclass(BigDecimal r0280_stage3b_assetclass) {
			this.r0280_stage3b_assetclass = r0280_stage3b_assetclass;
		}
		public BigDecimal getR0280_stage3c_assetclass() {
			return r0280_stage3c_assetclass;
		}
		public void setR0280_stage3c_assetclass(BigDecimal r0280_stage3c_assetclass) {
			this.r0280_stage3c_assetclass = r0280_stage3c_assetclass;
		}
		public BigDecimal getR0280_stage1_provisionheld() {
			return r0280_stage1_provisionheld;
		}
		public void setR0280_stage1_provisionheld(BigDecimal r0280_stage1_provisionheld) {
			this.r0280_stage1_provisionheld = r0280_stage1_provisionheld;
		}
		public BigDecimal getR0280_stage2_provisionheld() {
			return r0280_stage2_provisionheld;
		}
		public void setR0280_stage2_provisionheld(BigDecimal r0280_stage2_provisionheld) {
			this.r0280_stage2_provisionheld = r0280_stage2_provisionheld;
		}
		public BigDecimal getR0280_stage3a_provisionheld() {
			return r0280_stage3a_provisionheld;
		}
		public void setR0280_stage3a_provisionheld(BigDecimal r0280_stage3a_provisionheld) {
			this.r0280_stage3a_provisionheld = r0280_stage3a_provisionheld;
		}
		public BigDecimal getR0280_stage3b_provisionheld() {
			return r0280_stage3b_provisionheld;
		}
		public void setR0280_stage3b_provisionheld(BigDecimal r0280_stage3b_provisionheld) {
			this.r0280_stage3b_provisionheld = r0280_stage3b_provisionheld;
		}
		public BigDecimal getR0280_stage3c_provisionheld() {
			return r0280_stage3c_provisionheld;
		}
		public void setR0280_stage3c_provisionheld(BigDecimal r0280_stage3c_provisionheld) {
			this.r0280_stage3c_provisionheld = r0280_stage3c_provisionheld;
		}
		public BigDecimal getR0280_intrestfees_provisionheld() {
			return r0280_intrestfees_provisionheld;
		}
		public void setR0280_intrestfees_provisionheld(BigDecimal r0280_intrestfees_provisionheld) {
			this.r0280_intrestfees_provisionheld = r0280_intrestfees_provisionheld;
		}
		public BigDecimal getR0280_intrestsuspense_provisionheld() {
			return r0280_intrestsuspense_provisionheld;
		}
		public void setR0280_intrestsuspense_provisionheld(BigDecimal r0280_intrestsuspense_provisionheld) {
			this.r0280_intrestsuspense_provisionheld = r0280_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0280_stage1_poci() {
			return r0280_stage1_poci;
		}
		public void setR0280_stage1_poci(BigDecimal r0280_stage1_poci) {
			this.r0280_stage1_poci = r0280_stage1_poci;
		}
		public BigDecimal getR0280_stage2_poci() {
			return r0280_stage2_poci;
		}
		public void setR0280_stage2_poci(BigDecimal r0280_stage2_poci) {
			this.r0280_stage2_poci = r0280_stage2_poci;
		}
		public BigDecimal getR0280_stage3a_poci() {
			return r0280_stage3a_poci;
		}
		public void setR0280_stage3a_poci(BigDecimal r0280_stage3a_poci) {
			this.r0280_stage3a_poci = r0280_stage3a_poci;
		}
		public BigDecimal getR0280_stage3b_poci() {
			return r0280_stage3b_poci;
		}
		public void setR0280_stage3b_poci(BigDecimal r0280_stage3b_poci) {
			this.r0280_stage3b_poci = r0280_stage3b_poci;
		}
		public BigDecimal getR0280_stage3c_poci() {
			return r0280_stage3c_poci;
		}
		public void setR0280_stage3c_poci(BigDecimal r0280_stage3c_poci) {
			this.r0280_stage3c_poci = r0280_stage3c_poci;
		}
		public BigDecimal getR0280_current_pastdues() {
			return r0280_current_pastdues;
		}
		public void setR0280_current_pastdues(BigDecimal r0280_current_pastdues) {
			this.r0280_current_pastdues = r0280_current_pastdues;
		}
		public BigDecimal getR0280_less30days_pastdues() {
			return r0280_less30days_pastdues;
		}
		public void setR0280_less30days_pastdues(BigDecimal r0280_less30days_pastdues) {
			this.r0280_less30days_pastdues = r0280_less30days_pastdues;
		}
		public BigDecimal getR0280_31to90days_pastdues() {
			return r0280_31to90days_pastdues;
		}
		public void setR0280_31to90days_pastdues(BigDecimal r0280_31to90days_pastdues) {
			this.r0280_31to90days_pastdues = r0280_31to90days_pastdues;
		}
		public BigDecimal getR0280_91to120days_pastdues() {
			return r0280_91to120days_pastdues;
		}
		public void setR0280_91to120days_pastdues(BigDecimal r0280_91to120days_pastdues) {
			this.r0280_91to120days_pastdues = r0280_91to120days_pastdues;
		}
		public BigDecimal getR0280_121to180days_pastdues() {
			return r0280_121to180days_pastdues;
		}
		public void setR0280_121to180days_pastdues(BigDecimal r0280_121to180days_pastdues) {
			this.r0280_121to180days_pastdues = r0280_121to180days_pastdues;
		}
		public BigDecimal getR0280_181to365days_pastdues() {
			return r0280_181to365days_pastdues;
		}
		public void setR0280_181to365days_pastdues(BigDecimal r0280_181to365days_pastdues) {
			this.r0280_181to365days_pastdues = r0280_181to365days_pastdues;
		}
		public BigDecimal getR0280_over365days_pastdues() {
			return r0280_over365days_pastdues;
		}
		public void setR0280_over365days_pastdues(BigDecimal r0280_over365days_pastdues) {
			this.r0280_over365days_pastdues = r0280_over365days_pastdues;
		}
		public BigDecimal getR0280_total_pastdues() {
			return r0280_total_pastdues;
		}
		public void setR0280_total_pastdues(BigDecimal r0280_total_pastdues) {
			this.r0280_total_pastdues = r0280_total_pastdues;
		}
		public BigDecimal getR0280_newloan_duringreport() {
			return r0280_newloan_duringreport;
		}
		public void setR0280_newloan_duringreport(BigDecimal r0280_newloan_duringreport) {
			this.r0280_newloan_duringreport = r0280_newloan_duringreport;
		}
		public BigDecimal getR0280_newstage_duringreport() {
			return r0280_newstage_duringreport;
		}
		public void setR0280_newstage_duringreport(BigDecimal r0280_newstage_duringreport) {
			this.r0280_newstage_duringreport = r0280_newstage_duringreport;
		}
		public BigDecimal getR0280_intrestfees_duringreport() {
			return r0280_intrestfees_duringreport;
		}
		public void setR0280_intrestfees_duringreport(BigDecimal r0280_intrestfees_duringreport) {
			this.r0280_intrestfees_duringreport = r0280_intrestfees_duringreport;
		}
		public BigDecimal getR0280_performingac_acinfo() {
			return r0280_performingac_acinfo;
		}
		public void setR0280_performingac_acinfo(BigDecimal r0280_performingac_acinfo) {
			this.r0280_performingac_acinfo = r0280_performingac_acinfo;
		}
		public BigDecimal getR0280_nonperformingac_acinfo() {
			return r0280_nonperformingac_acinfo;
		}
		public void setR0280_nonperformingac_acinfo(BigDecimal r0280_nonperformingac_acinfo) {
			this.r0280_nonperformingac_acinfo = r0280_nonperformingac_acinfo;
		}
		public String getR0290_product() {
			return r0290_product;
		}
		public void setR0290_product(String r0290_product) {
			this.r0290_product = r0290_product;
		}
		public BigDecimal getR0290_outstandbal() {
			return r0290_outstandbal;
		}
		public void setR0290_outstandbal(BigDecimal r0290_outstandbal) {
			this.r0290_outstandbal = r0290_outstandbal;
		}
		public BigDecimal getR0290_secured_outstandbal() {
			return r0290_secured_outstandbal;
		}
		public void setR0290_secured_outstandbal(BigDecimal r0290_secured_outstandbal) {
			this.r0290_secured_outstandbal = r0290_secured_outstandbal;
		}
		public BigDecimal getR0290_unsecured_outstandbal() {
			return r0290_unsecured_outstandbal;
		}
		public void setR0290_unsecured_outstandbal(BigDecimal r0290_unsecured_outstandbal) {
			this.r0290_unsecured_outstandbal = r0290_unsecured_outstandbal;
		}
		public BigDecimal getR0290_stage1_assetclass() {
			return r0290_stage1_assetclass;
		}
		public void setR0290_stage1_assetclass(BigDecimal r0290_stage1_assetclass) {
			this.r0290_stage1_assetclass = r0290_stage1_assetclass;
		}
		public BigDecimal getR0290_stage2_assetclass() {
			return r0290_stage2_assetclass;
		}
		public void setR0290_stage2_assetclass(BigDecimal r0290_stage2_assetclass) {
			this.r0290_stage2_assetclass = r0290_stage2_assetclass;
		}
		public BigDecimal getR0290_stage3a_assetclass() {
			return r0290_stage3a_assetclass;
		}
		public void setR0290_stage3a_assetclass(BigDecimal r0290_stage3a_assetclass) {
			this.r0290_stage3a_assetclass = r0290_stage3a_assetclass;
		}
		public BigDecimal getR0290_stage3b_assetclass() {
			return r0290_stage3b_assetclass;
		}
		public void setR0290_stage3b_assetclass(BigDecimal r0290_stage3b_assetclass) {
			this.r0290_stage3b_assetclass = r0290_stage3b_assetclass;
		}
		public BigDecimal getR0290_stage3c_assetclass() {
			return r0290_stage3c_assetclass;
		}
		public void setR0290_stage3c_assetclass(BigDecimal r0290_stage3c_assetclass) {
			this.r0290_stage3c_assetclass = r0290_stage3c_assetclass;
		}
		public BigDecimal getR0290_stage1_provisionheld() {
			return r0290_stage1_provisionheld;
		}
		public void setR0290_stage1_provisionheld(BigDecimal r0290_stage1_provisionheld) {
			this.r0290_stage1_provisionheld = r0290_stage1_provisionheld;
		}
		public BigDecimal getR0290_stage2_provisionheld() {
			return r0290_stage2_provisionheld;
		}
		public void setR0290_stage2_provisionheld(BigDecimal r0290_stage2_provisionheld) {
			this.r0290_stage2_provisionheld = r0290_stage2_provisionheld;
		}
		public BigDecimal getR0290_stage3a_provisionheld() {
			return r0290_stage3a_provisionheld;
		}
		public void setR0290_stage3a_provisionheld(BigDecimal r0290_stage3a_provisionheld) {
			this.r0290_stage3a_provisionheld = r0290_stage3a_provisionheld;
		}
		public BigDecimal getR0290_stage3b_provisionheld() {
			return r0290_stage3b_provisionheld;
		}
		public void setR0290_stage3b_provisionheld(BigDecimal r0290_stage3b_provisionheld) {
			this.r0290_stage3b_provisionheld = r0290_stage3b_provisionheld;
		}
		public BigDecimal getR0290_stage3c_provisionheld() {
			return r0290_stage3c_provisionheld;
		}
		public void setR0290_stage3c_provisionheld(BigDecimal r0290_stage3c_provisionheld) {
			this.r0290_stage3c_provisionheld = r0290_stage3c_provisionheld;
		}
		public BigDecimal getR0290_intrestfees_provisionheld() {
			return r0290_intrestfees_provisionheld;
		}
		public void setR0290_intrestfees_provisionheld(BigDecimal r0290_intrestfees_provisionheld) {
			this.r0290_intrestfees_provisionheld = r0290_intrestfees_provisionheld;
		}
		public BigDecimal getR0290_intrestsuspense_provisionheld() {
			return r0290_intrestsuspense_provisionheld;
		}
		public void setR0290_intrestsuspense_provisionheld(BigDecimal r0290_intrestsuspense_provisionheld) {
			this.r0290_intrestsuspense_provisionheld = r0290_intrestsuspense_provisionheld;
		}
		public BigDecimal getR0290_stage1_poci() {
			return r0290_stage1_poci;
		}
		public void setR0290_stage1_poci(BigDecimal r0290_stage1_poci) {
			this.r0290_stage1_poci = r0290_stage1_poci;
		}
		public BigDecimal getR0290_stage2_poci() {
			return r0290_stage2_poci;
		}
		public void setR0290_stage2_poci(BigDecimal r0290_stage2_poci) {
			this.r0290_stage2_poci = r0290_stage2_poci;
		}
		public BigDecimal getR0290_stage3a_poci() {
			return r0290_stage3a_poci;
		}
		public void setR0290_stage3a_poci(BigDecimal r0290_stage3a_poci) {
			this.r0290_stage3a_poci = r0290_stage3a_poci;
		}
		public BigDecimal getR0290_stage3b_poci() {
			return r0290_stage3b_poci;
		}
		public void setR0290_stage3b_poci(BigDecimal r0290_stage3b_poci) {
			this.r0290_stage3b_poci = r0290_stage3b_poci;
		}
		public BigDecimal getR0290_stage3c_poci() {
			return r0290_stage3c_poci;
		}
		public void setR0290_stage3c_poci(BigDecimal r0290_stage3c_poci) {
			this.r0290_stage3c_poci = r0290_stage3c_poci;
		}
		public BigDecimal getR0290_current_pastdues() {
			return r0290_current_pastdues;
		}
		public void setR0290_current_pastdues(BigDecimal r0290_current_pastdues) {
			this.r0290_current_pastdues = r0290_current_pastdues;
		}
		public BigDecimal getR0290_less30days_pastdues() {
			return r0290_less30days_pastdues;
		}
		public void setR0290_less30days_pastdues(BigDecimal r0290_less30days_pastdues) {
			this.r0290_less30days_pastdues = r0290_less30days_pastdues;
		}
		public BigDecimal getR0290_31to90days_pastdues() {
			return r0290_31to90days_pastdues;
		}
		public void setR0290_31to90days_pastdues(BigDecimal r0290_31to90days_pastdues) {
			this.r0290_31to90days_pastdues = r0290_31to90days_pastdues;
		}
		public BigDecimal getR0290_91to120days_pastdues() {
			return r0290_91to120days_pastdues;
		}
		public void setR0290_91to120days_pastdues(BigDecimal r0290_91to120days_pastdues) {
			this.r0290_91to120days_pastdues = r0290_91to120days_pastdues;
		}
		public BigDecimal getR0290_121to180days_pastdues() {
			return r0290_121to180days_pastdues;
		}
		public void setR0290_121to180days_pastdues(BigDecimal r0290_121to180days_pastdues) {
			this.r0290_121to180days_pastdues = r0290_121to180days_pastdues;
		}
		public BigDecimal getR0290_181to365days_pastdues() {
			return r0290_181to365days_pastdues;
		}
		public void setR0290_181to365days_pastdues(BigDecimal r0290_181to365days_pastdues) {
			this.r0290_181to365days_pastdues = r0290_181to365days_pastdues;
		}
		public BigDecimal getR0290_over365days_pastdues() {
			return r0290_over365days_pastdues;
		}
		public void setR0290_over365days_pastdues(BigDecimal r0290_over365days_pastdues) {
			this.r0290_over365days_pastdues = r0290_over365days_pastdues;
		}
		public BigDecimal getR0290_total_pastdues() {
			return r0290_total_pastdues;
		}
		public void setR0290_total_pastdues(BigDecimal r0290_total_pastdues) {
			this.r0290_total_pastdues = r0290_total_pastdues;
		}
		public BigDecimal getR0290_newloan_duringreport() {
			return r0290_newloan_duringreport;
		}
		public void setR0290_newloan_duringreport(BigDecimal r0290_newloan_duringreport) {
			this.r0290_newloan_duringreport = r0290_newloan_duringreport;
		}
		public BigDecimal getR0290_newstage_duringreport() {
			return r0290_newstage_duringreport;
		}
		public void setR0290_newstage_duringreport(BigDecimal r0290_newstage_duringreport) {
			this.r0290_newstage_duringreport = r0290_newstage_duringreport;
		}
		public BigDecimal getR0290_intrestfees_duringreport() {
			return r0290_intrestfees_duringreport;
		}
		public void setR0290_intrestfees_duringreport(BigDecimal r0290_intrestfees_duringreport) {
			this.r0290_intrestfees_duringreport = r0290_intrestfees_duringreport;
		}
		public BigDecimal getR0290_performingac_acinfo() {
			return r0290_performingac_acinfo;
		}
		public void setR0290_performingac_acinfo(BigDecimal r0290_performingac_acinfo) {
			this.r0290_performingac_acinfo = r0290_performingac_acinfo;
		}
		public BigDecimal getR0290_nonperformingac_acinfo() {
			return r0290_nonperformingac_acinfo;
		}
		public void setR0290_nonperformingac_acinfo(BigDecimal r0290_nonperformingac_acinfo) {
			this.r0290_nonperformingac_acinfo = r0290_nonperformingac_acinfo;
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
		public CBUAE_BRF5_3_Summary_Archival_Entity1() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		
		
	}


