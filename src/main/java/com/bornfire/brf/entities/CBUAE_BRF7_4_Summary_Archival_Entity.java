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
@Table(name = "CBUAE_BRF7_4_ARCHIVALTABLE_SUMMARYTABLE")
public class CBUAE_BRF7_4_Summary_Archival_Entity {
	
	private String	r0010_product;
	private BigDecimal	r0010_fedaral_govt;
	private BigDecimal	r0010_non_comm_entity_fed_govt;
	private BigDecimal	r0010_local_govt;
	private BigDecimal	r0010_non_comm_entity_emirates_govt;
	private BigDecimal	r0010_gre;
	private BigDecimal	r0010_private_sector_gre;
	private BigDecimal	r0010_private_sector_banks;
	private BigDecimal	r0010_private_sector_financial_institutions;
	private BigDecimal	r0010_private_sector_other_private_entities;
	private BigDecimal	r0010_total_amount;
	private String	r0020_product;
	private BigDecimal	r0020_fedaral_govt;
	private BigDecimal	r0020_non_comm_entity_fed_govt;
	private BigDecimal	r0020_local_govt;
	private BigDecimal	r0020_non_comm_entity_emirates_govt;
	private BigDecimal	r0020_gre;
	private BigDecimal	r0020_private_sector_gre;
	private BigDecimal	r0020_private_sector_banks;
	private BigDecimal	r0020_private_sector_financial_institutions;
	private BigDecimal	r0020_private_sector_other_private_entities;
	private BigDecimal	r0020_total_amount;
	private String	r0030_product;
	private BigDecimal	r0030_fedaral_govt;
	private BigDecimal	r0030_non_comm_entity_fed_govt;
	private BigDecimal	r0030_local_govt;
	private BigDecimal	r0030_non_comm_entity_emirates_govt;
	private BigDecimal	r0030_gre;
	private BigDecimal	r0030_private_sector_gre;
	private BigDecimal	r0030_private_sector_banks;
	private BigDecimal	r0030_private_sector_financial_institutions;
	private BigDecimal	r0030_private_sector_other_private_entities;
	private BigDecimal	r0030_total_amount;
	private String	r0040_product;
	private BigDecimal	r0040_fedaral_govt;
	private BigDecimal	r0040_non_comm_entity_fed_govt;
	private BigDecimal	r0040_local_govt;
	private BigDecimal	r0040_non_comm_entity_emirates_govt;
	private BigDecimal	r0040_gre;
	private BigDecimal	r0040_private_sector_gre;
	private BigDecimal	r0040_private_sector_banks;
	private BigDecimal	r0040_private_sector_financial_institutions;
	private BigDecimal	r0040_private_sector_other_private_entities;
	private BigDecimal	r0040_total_amount;
	private String	r0050_product;
	private BigDecimal	r0050_fedaral_govt;
	private BigDecimal	r0050_non_comm_entity_fed_govt;
	private BigDecimal	r0050_local_govt;
	private BigDecimal	r0050_non_comm_entity_emirates_govt;
	private BigDecimal	r0050_gre;
	private BigDecimal	r0050_private_sector_gre;
	private BigDecimal	r0050_private_sector_banks;
	private BigDecimal	r0050_private_sector_financial_institutions;
	private BigDecimal	r0050_private_sector_other_private_entities;
	private BigDecimal	r0050_total_amount;
	private String	r0060_product;
	private BigDecimal	r0060_fedaral_govt;
	private BigDecimal	r0060_non_comm_entity_fed_govt;
	private BigDecimal	r0060_local_govt;
	private BigDecimal	r0060_non_comm_entity_emirates_govt;
	private BigDecimal	r0060_gre;
	private BigDecimal	r0060_private_sector_gre;
	private BigDecimal	r0060_private_sector_banks;
	private BigDecimal	r0060_private_sector_financial_institutions;
	private BigDecimal	r0060_private_sector_other_private_entities;
	private BigDecimal	r0060_total_amount;
	private String	r0070_product;
	private BigDecimal	r0070_fedaral_govt;
	private BigDecimal	r0070_non_comm_entity_fed_govt;
	private BigDecimal	r0070_local_govt;
	private BigDecimal	r0070_non_comm_entity_emirates_govt;
	private BigDecimal	r0070_gre;
	private BigDecimal	r0070_private_sector_gre;
	private BigDecimal	r0070_private_sector_banks;
	private BigDecimal	r0070_private_sector_financial_institutions;
	private BigDecimal	r0070_private_sector_other_private_entities;
	private BigDecimal	r0070_total_amount;
	private String	r0080_product;
	private BigDecimal	r0080_fedaral_govt;
	private BigDecimal	r0080_non_comm_entity_fed_govt;
	private BigDecimal	r0080_local_govt;
	private BigDecimal	r0080_non_comm_entity_emirates_govt;
	private BigDecimal	r0080_gre;
	private BigDecimal	r0080_private_sector_gre;
	private BigDecimal	r0080_private_sector_banks;
	private BigDecimal	r0080_private_sector_financial_institutions;
	private BigDecimal	r0080_private_sector_other_private_entities;
	private BigDecimal	r0080_total_amount;
	private String	r0090_product;
	private BigDecimal	r0090_fedaral_govt;
	private BigDecimal	r0090_non_comm_entity_fed_govt;
	private BigDecimal	r0090_local_govt;
	private BigDecimal	r0090_non_comm_entity_emirates_govt;
	private BigDecimal	r0090_gre;
	private BigDecimal	r0090_private_sector_gre;
	private BigDecimal	r0090_private_sector_banks;
	private BigDecimal	r0090_private_sector_financial_institutions;
	private BigDecimal	r0090_private_sector_other_private_entities;
	private BigDecimal	r0090_total_amount;
	private String	r0100_product;
	private BigDecimal	r0100_fedaral_govt;
	private BigDecimal	r0100_non_comm_entity_fed_govt;
	private BigDecimal	r0100_local_govt;
	private BigDecimal	r0100_non_comm_entity_emirates_govt;
	private BigDecimal	r0100_gre;
	private BigDecimal	r0100_private_sector_gre;
	private BigDecimal	r0100_private_sector_banks;
	private BigDecimal	r0100_private_sector_financial_institutions;
	private BigDecimal	r0100_private_sector_other_private_entities;
	private BigDecimal	r0100_total_amount;
	private String	r0110_product;
	private BigDecimal	r0110_fedaral_govt;
	private BigDecimal	r0110_non_comm_entity_fed_govt;
	private BigDecimal	r0110_local_govt;
	private BigDecimal	r0110_non_comm_entity_emirates_govt;
	private BigDecimal	r0110_gre;
	private BigDecimal	r0110_private_sector_gre;
	private BigDecimal	r0110_private_sector_banks;
	private BigDecimal	r0110_private_sector_financial_institutions;
	private BigDecimal	r0110_private_sector_other_private_entities;
	private BigDecimal	r0110_total_amount;
	private String	r0120_product;
	private BigDecimal	r0120_fedaral_govt;
	private BigDecimal	r0120_non_comm_entity_fed_govt;
	private BigDecimal	r0120_local_govt;
	private BigDecimal	r0120_non_comm_entity_emirates_govt;
	private BigDecimal	r0120_gre;
	private BigDecimal	r0120_private_sector_gre;
	private BigDecimal	r0120_private_sector_banks;
	private BigDecimal	r0120_private_sector_financial_institutions;
	private BigDecimal	r0120_private_sector_other_private_entities;
	private BigDecimal	r0120_total_amount;
	private String	r0130_product;
	private BigDecimal	r0130_fedaral_govt;
	private BigDecimal	r0130_non_comm_entity_fed_govt;
	private BigDecimal	r0130_local_govt;
	private BigDecimal	r0130_non_comm_entity_emirates_govt;
	private BigDecimal	r0130_gre;
	private BigDecimal	r0130_private_sector_gre;
	private BigDecimal	r0130_private_sector_banks;
	private BigDecimal	r0130_private_sector_financial_institutions;
	private BigDecimal	r0130_private_sector_other_private_entities;
	private BigDecimal	r0130_total_amount;
	private String	r0140_product;
	private BigDecimal	r0140_fedaral_govt;
	private BigDecimal	r0140_non_comm_entity_fed_govt;
	private BigDecimal	r0140_local_govt;
	private BigDecimal	r0140_non_comm_entity_emirates_govt;
	private BigDecimal	r0140_gre;
	private BigDecimal	r0140_private_sector_gre;
	private BigDecimal	r0140_private_sector_banks;
	private BigDecimal	r0140_private_sector_financial_institutions;
	private BigDecimal	r0140_private_sector_other_private_entities;
	private BigDecimal	r0140_total_amount;
	private String	r0150_product;
	private BigDecimal	r0150_fedaral_govt;
	private BigDecimal	r0150_non_comm_entity_fed_govt;
	private BigDecimal	r0150_local_govt;
	private BigDecimal	r0150_non_comm_entity_emirates_govt;
	private BigDecimal	r0150_gre;
	private BigDecimal	r0150_private_sector_gre;
	private BigDecimal	r0150_private_sector_banks;
	private BigDecimal	r0150_private_sector_financial_institutions;
	private BigDecimal	r0150_private_sector_other_private_entities;
	private BigDecimal	r0150_total_amount;
	private String	r0160_product;
	private BigDecimal	r0160_fedaral_govt;
	private BigDecimal	r0160_non_comm_entity_fed_govt;
	private BigDecimal	r0160_local_govt;
	private BigDecimal	r0160_non_comm_entity_emirates_govt;
	private BigDecimal	r0160_gre;
	private BigDecimal	r0160_private_sector_gre;
	private BigDecimal	r0160_private_sector_banks;
	private BigDecimal	r0160_private_sector_financial_institutions;
	private BigDecimal	r0160_private_sector_other_private_entities;
	private BigDecimal	r0160_total_amount;
	private String	r0170_product;
	private BigDecimal	r0170_fedaral_govt;
	private BigDecimal	r0170_non_comm_entity_fed_govt;
	private BigDecimal	r0170_local_govt;
	private BigDecimal	r0170_non_comm_entity_emirates_govt;
	private BigDecimal	r0170_gre;
	private BigDecimal	r0170_private_sector_gre;
	private BigDecimal	r0170_private_sector_banks;
	private BigDecimal	r0170_private_sector_financial_institutions;
	private BigDecimal	r0170_private_sector_other_private_entities;
	private BigDecimal	r0170_total_amount;
	private String	r0180_product;
	private BigDecimal	r0180_fedaral_govt;
	private BigDecimal	r0180_non_comm_entity_fed_govt;
	private BigDecimal	r0180_local_govt;
	private BigDecimal	r0180_non_comm_entity_emirates_govt;
	private BigDecimal	r0180_gre;
	private BigDecimal	r0180_private_sector_gre;
	private BigDecimal	r0180_private_sector_banks;
	private BigDecimal	r0180_private_sector_financial_institutions;
	private BigDecimal	r0180_private_sector_other_private_entities;
	private BigDecimal	r0180_total_amount;
	private String	r0190_product;
	private BigDecimal	r0190_fedaral_govt;
	private BigDecimal	r0190_non_comm_entity_fed_govt;
	private BigDecimal	r0190_local_govt;
	private BigDecimal	r0190_non_comm_entity_emirates_govt;
	private BigDecimal	r0190_gre;
	private BigDecimal	r0190_private_sector_gre;
	private BigDecimal	r0190_private_sector_banks;
	private BigDecimal	r0190_private_sector_financial_institutions;
	private BigDecimal	r0190_private_sector_other_private_entities;
	private BigDecimal	r0190_total_amount;
	private String	r0200_product;
	private BigDecimal	r0200_fedaral_govt;
	private BigDecimal	r0200_non_comm_entity_fed_govt;
	private BigDecimal	r0200_local_govt;
	private BigDecimal	r0200_non_comm_entity_emirates_govt;
	private BigDecimal	r0200_gre;
	private BigDecimal	r0200_private_sector_gre;
	private BigDecimal	r0200_private_sector_banks;
	private BigDecimal	r0200_private_sector_financial_institutions;
	private BigDecimal	r0200_private_sector_other_private_entities;
	private BigDecimal	r0200_total_amount;
	private String	r0210_product;
	private BigDecimal	r0210_fedaral_govt;
	private BigDecimal	r0210_non_comm_entity_fed_govt;
	private BigDecimal	r0210_local_govt;
	private BigDecimal	r0210_non_comm_entity_emirates_govt;
	private BigDecimal	r0210_gre;
	private BigDecimal	r0210_private_sector_gre;
	private BigDecimal	r0210_private_sector_banks;
	private BigDecimal	r0210_private_sector_financial_institutions;
	private BigDecimal	r0210_private_sector_other_private_entities;
	private BigDecimal	r0210_total_amount;
	private String	r0220_product;
	private BigDecimal	r0220_fedaral_govt;
	private BigDecimal	r0220_non_comm_entity_fed_govt;
	private BigDecimal	r0220_local_govt;
	private BigDecimal	r0220_non_comm_entity_emirates_govt;
	private BigDecimal	r0220_gre;
	private BigDecimal	r0220_private_sector_gre;
	private BigDecimal	r0220_private_sector_banks;
	private BigDecimal	r0220_private_sector_financial_institutions;
	private BigDecimal	r0220_private_sector_other_private_entities;
	private BigDecimal	r0220_total_amount;
	private String	r0230_product;
	private BigDecimal	r0230_fedaral_govt;
	private BigDecimal	r0230_non_comm_entity_fed_govt;
	private BigDecimal	r0230_local_govt;
	private BigDecimal	r0230_non_comm_entity_emirates_govt;
	private BigDecimal	r0230_gre;
	private BigDecimal	r0230_private_sector_gre;
	private BigDecimal	r0230_private_sector_banks;
	private BigDecimal	r0230_private_sector_financial_institutions;
	private BigDecimal	r0230_private_sector_other_private_entities;
	private BigDecimal	r0230_total_amount;
	private String	r0240_product;
	private BigDecimal	r0240_fedaral_govt;
	private BigDecimal	r0240_non_comm_entity_fed_govt;
	private BigDecimal	r0240_local_govt;
	private BigDecimal	r0240_non_comm_entity_emirates_govt;
	private BigDecimal	r0240_gre;
	private BigDecimal	r0240_private_sector_gre;
	private BigDecimal	r0240_private_sector_banks;
	private BigDecimal	r0240_private_sector_financial_institutions;
	private BigDecimal	r0240_private_sector_other_private_entities;
	private BigDecimal	r0240_total_amount;
	private String	r0250_product;
	private BigDecimal	r0250_fedaral_govt;
	private BigDecimal	r0250_non_comm_entity_fed_govt;
	private BigDecimal	r0250_local_govt;
	private BigDecimal	r0250_non_comm_entity_emirates_govt;
	private BigDecimal	r0250_gre;
	private BigDecimal	r0250_private_sector_gre;
	private BigDecimal	r0250_private_sector_banks;
	private BigDecimal	r0250_private_sector_financial_institutions;
	private BigDecimal	r0250_private_sector_other_private_entities;
	private BigDecimal	r0250_total_amount;
	private String	r0260_product;
	private BigDecimal	r0260_fedaral_govt;
	private BigDecimal	r0260_non_comm_entity_fed_govt;
	private BigDecimal	r0260_local_govt;
	private BigDecimal	r0260_non_comm_entity_emirates_govt;
	private BigDecimal	r0260_gre;
	private BigDecimal	r0260_private_sector_gre;
	private BigDecimal	r0260_private_sector_banks;
	private BigDecimal	r0260_private_sector_financial_institutions;
	private BigDecimal	r0260_private_sector_other_private_entities;
	private BigDecimal	r0260_total_amount;
	private String	r0270_product;
	private BigDecimal	r0270_fedaral_govt;
	private BigDecimal	r0270_non_comm_entity_fed_govt;
	private BigDecimal	r0270_local_govt;
	private BigDecimal	r0270_non_comm_entity_emirates_govt;
	private BigDecimal	r0270_gre;
	private BigDecimal	r0270_private_sector_gre;
	private BigDecimal	r0270_private_sector_banks;
	private BigDecimal	r0270_private_sector_financial_institutions;
	private BigDecimal	r0270_private_sector_other_private_entities;
	private BigDecimal	r0270_total_amount;
	private String	r0280_product;
	private BigDecimal	r0280_fedaral_govt;
	private BigDecimal	r0280_non_comm_entity_fed_govt;
	private BigDecimal	r0280_local_govt;
	private BigDecimal	r0280_non_comm_entity_emirates_govt;
	private BigDecimal	r0280_gre;
	private BigDecimal	r0280_private_sector_gre;
	private BigDecimal	r0280_private_sector_banks;
	private BigDecimal	r0280_private_sector_financial_institutions;
	private BigDecimal	r0280_private_sector_other_private_entities;
	private BigDecimal	r0280_total_amount;
	private String	r0290_product;
	private BigDecimal	r0290_fedaral_govt;
	private BigDecimal	r0290_non_comm_entity_fed_govt;
	private BigDecimal	r0290_local_govt;
	private BigDecimal	r0290_non_comm_entity_emirates_govt;
	private BigDecimal	r0290_gre;
	private BigDecimal	r0290_private_sector_gre;
	private BigDecimal	r0290_private_sector_banks;
	private BigDecimal	r0290_private_sector_financial_institutions;
	private BigDecimal	r0290_private_sector_other_private_entities;
	private BigDecimal	r0290_total_amount;
	private String	r0300_product;
	private BigDecimal	r0300_fedaral_govt;
	private BigDecimal	r0300_non_comm_entity_fed_govt;
	private BigDecimal	r0300_local_govt;
	private BigDecimal	r0300_non_comm_entity_emirates_govt;
	private BigDecimal	r0300_gre;
	private BigDecimal	r0300_private_sector_gre;
	private BigDecimal	r0300_private_sector_banks;
	private BigDecimal	r0300_private_sector_financial_institutions;
	private BigDecimal	r0300_private_sector_other_private_entities;
	private BigDecimal	r0300_total_amount;
	private String	r0310_product;
	private BigDecimal	r0310_fedaral_govt;
	private BigDecimal	r0310_non_comm_entity_fed_govt;
	private BigDecimal	r0310_local_govt;
	private BigDecimal	r0310_non_comm_entity_emirates_govt;
	private BigDecimal	r0310_gre;
	private BigDecimal	r0310_private_sector_gre;
	private BigDecimal	r0310_private_sector_banks;
	private BigDecimal	r0310_private_sector_financial_institutions;
	private BigDecimal	r0310_private_sector_other_private_entities;
	private BigDecimal	r0310_total_amount;
	private String	r0320_product;
	private BigDecimal	r0320_fedaral_govt;
	private BigDecimal	r0320_non_comm_entity_fed_govt;
	private BigDecimal	r0320_local_govt;
	private BigDecimal	r0320_non_comm_entity_emirates_govt;
	private BigDecimal	r0320_gre;
	private BigDecimal	r0320_private_sector_gre;
	private BigDecimal	r0320_private_sector_banks;
	private BigDecimal	r0320_private_sector_financial_institutions;
	private BigDecimal	r0320_private_sector_other_private_entities;
	private BigDecimal	r0320_total_amount;
	private String	r0330_product;
	private BigDecimal	r0330_fedaral_govt;
	private BigDecimal	r0330_non_comm_entity_fed_govt;
	private BigDecimal	r0330_local_govt;
	private BigDecimal	r0330_non_comm_entity_emirates_govt;
	private BigDecimal	r0330_gre;
	private BigDecimal	r0330_private_sector_gre;
	private BigDecimal	r0330_private_sector_banks;
	private BigDecimal	r0330_private_sector_financial_institutions;
	private BigDecimal	r0330_private_sector_other_private_entities;
	private BigDecimal	r0330_total_amount;
	private String	r0340_product;
	private BigDecimal	r0340_fedaral_govt;
	private BigDecimal	r0340_non_comm_entity_fed_govt;
	private BigDecimal	r0340_local_govt;
	private BigDecimal	r0340_non_comm_entity_emirates_govt;
	private BigDecimal	r0340_gre;
	private BigDecimal	r0340_private_sector_gre;
	private BigDecimal	r0340_private_sector_banks;
	private BigDecimal	r0340_private_sector_financial_institutions;
	private BigDecimal	r0340_private_sector_other_private_entities;
	private BigDecimal	r0340_total_amount;
	private String	r0350_product;
	private BigDecimal	r0350_fedaral_govt;
	private BigDecimal	r0350_non_comm_entity_fed_govt;
	private BigDecimal	r0350_local_govt;
	private BigDecimal	r0350_non_comm_entity_emirates_govt;
	private BigDecimal	r0350_gre;
	private BigDecimal	r0350_private_sector_gre;
	private BigDecimal	r0350_private_sector_banks;
	private BigDecimal	r0350_private_sector_financial_institutions;
	private BigDecimal	r0350_private_sector_other_private_entities;
	private BigDecimal	r0350_total_amount;
	private String	r0360_product;
	private BigDecimal	r0360_fedaral_govt;
	private BigDecimal	r0360_non_comm_entity_fed_govt;
	private BigDecimal	r0360_local_govt;
	private BigDecimal	r0360_non_comm_entity_emirates_govt;
	private BigDecimal	r0360_gre;
	private BigDecimal	r0360_private_sector_gre;
	private BigDecimal	r0360_private_sector_banks;
	private BigDecimal	r0360_private_sector_financial_institutions;
	private BigDecimal	r0360_private_sector_other_private_entities;
	private BigDecimal	r0360_total_amount;
	private String	r0370_product;
	private BigDecimal	r0370_fedaral_govt;
	private BigDecimal	r0370_non_comm_entity_fed_govt;
	private BigDecimal	r0370_local_govt;
	private BigDecimal	r0370_non_comm_entity_emirates_govt;
	private BigDecimal	r0370_gre;
	private BigDecimal	r0370_private_sector_gre;
	private BigDecimal	r0370_private_sector_banks;
	private BigDecimal	r0370_private_sector_financial_institutions;
	private BigDecimal	r0370_private_sector_other_private_entities;
	private BigDecimal	r0370_total_amount;
	private String	r0380_product;
	private BigDecimal	r0380_fedaral_govt;
	private BigDecimal	r0380_non_comm_entity_fed_govt;
	private BigDecimal	r0380_local_govt;
	private BigDecimal	r0380_non_comm_entity_emirates_govt;
	private BigDecimal	r0380_gre;
	private BigDecimal	r0380_private_sector_gre;
	private BigDecimal	r0380_private_sector_banks;
	private BigDecimal	r0380_private_sector_financial_institutions;
	private BigDecimal	r0380_private_sector_other_private_entities;
	private BigDecimal	r0380_total_amount;
	private String	r0390_product;
	private BigDecimal	r0390_fedaral_govt;
	private BigDecimal	r0390_non_comm_entity_fed_govt;
	private BigDecimal	r0390_local_govt;
	private BigDecimal	r0390_non_comm_entity_emirates_govt;
	private BigDecimal	r0390_gre;
	private BigDecimal	r0390_private_sector_gre;
	private BigDecimal	r0390_private_sector_banks;
	private BigDecimal	r0390_private_sector_financial_institutions;
	private BigDecimal	r0390_private_sector_other_private_entities;
	private BigDecimal	r0390_total_amount;
	private String	r0400_product;
	private BigDecimal	r0400_fedaral_govt;
	private BigDecimal	r0400_non_comm_entity_fed_govt;
	private BigDecimal	r0400_local_govt;
	private BigDecimal	r0400_non_comm_entity_emirates_govt;
	private BigDecimal	r0400_gre;
	private BigDecimal	r0400_private_sector_gre;
	private BigDecimal	r0400_private_sector_banks;
	private BigDecimal	r0400_private_sector_financial_institutions;
	private BigDecimal	r0400_private_sector_other_private_entities;
	private BigDecimal	r0400_total_amount;
	private String	r0410_product;
	private BigDecimal	r0410_fedaral_govt;
	private BigDecimal	r0410_non_comm_entity_fed_govt;
	private BigDecimal	r0410_local_govt;
	private BigDecimal	r0410_non_comm_entity_emirates_govt;
	private BigDecimal	r0410_gre;
	private BigDecimal	r0410_private_sector_gre;
	private BigDecimal	r0410_private_sector_banks;
	private BigDecimal	r0410_private_sector_financial_institutions;
	private BigDecimal	r0410_private_sector_other_private_entities;
	private BigDecimal	r0410_total_amount;
	private String	r0420_product;
	private BigDecimal	r0420_fedaral_govt;
	private BigDecimal	r0420_non_comm_entity_fed_govt;
	private BigDecimal	r0420_local_govt;
	private BigDecimal	r0420_non_comm_entity_emirates_govt;
	private BigDecimal	r0420_gre;
	private BigDecimal	r0420_private_sector_gre;
	private BigDecimal	r0420_private_sector_banks;
	private BigDecimal	r0420_private_sector_financial_institutions;
	private BigDecimal	r0420_private_sector_other_private_entities;
	private BigDecimal	r0420_total_amount;
	private String	r0430_product;
	private BigDecimal	r0430_fedaral_govt;
	private BigDecimal	r0430_non_comm_entity_fed_govt;
	private BigDecimal	r0430_local_govt;
	private BigDecimal	r0430_non_comm_entity_emirates_govt;
	private BigDecimal	r0430_gre;
	private BigDecimal	r0430_private_sector_gre;
	private BigDecimal	r0430_private_sector_banks;
	private BigDecimal	r0430_private_sector_financial_institutions;
	private BigDecimal	r0430_private_sector_other_private_entities;
	private BigDecimal	r0430_total_amount;
	private String	r0440_product;
	private BigDecimal	r0440_fedaral_govt;
	private BigDecimal	r0440_non_comm_entity_fed_govt;
	private BigDecimal	r0440_local_govt;
	private BigDecimal	r0440_non_comm_entity_emirates_govt;
	private BigDecimal	r0440_gre;
	private BigDecimal	r0440_private_sector_gre;
	private BigDecimal	r0440_private_sector_banks;
	private BigDecimal	r0440_private_sector_financial_institutions;
	private BigDecimal	r0440_private_sector_other_private_entities;
	private BigDecimal	r0440_total_amount;
	private String	r0450_product;
	private BigDecimal	r0450_fedaral_govt;
	private BigDecimal	r0450_non_comm_entity_fed_govt;
	private BigDecimal	r0450_local_govt;
	private BigDecimal	r0450_non_comm_entity_emirates_govt;
	private BigDecimal	r0450_gre;
	private BigDecimal	r0450_private_sector_gre;
	private BigDecimal	r0450_private_sector_banks;
	private BigDecimal	r0450_private_sector_financial_institutions;
	private BigDecimal	r0450_private_sector_other_private_entities;
	private BigDecimal	r0450_total_amount;
	private String	r0460_product;
	private BigDecimal	r0460_fedaral_govt;
	private BigDecimal	r0460_non_comm_entity_fed_govt;
	private BigDecimal	r0460_local_govt;
	private BigDecimal	r0460_non_comm_entity_emirates_govt;
	private BigDecimal	r0460_gre;
	private BigDecimal	r0460_private_sector_gre;
	private BigDecimal	r0460_private_sector_banks;
	private BigDecimal	r0460_private_sector_financial_institutions;
	private BigDecimal	r0460_private_sector_other_private_entities;
	private BigDecimal	r0460_total_amount;
	private String	r0470_product;
	private BigDecimal	r0470_fedaral_govt;
	private BigDecimal	r0470_non_comm_entity_fed_govt;
	private BigDecimal	r0470_local_govt;
	private BigDecimal	r0470_non_comm_entity_emirates_govt;
	private BigDecimal	r0470_gre;
	private BigDecimal	r0470_private_sector_gre;
	private BigDecimal	r0470_private_sector_banks;
	private BigDecimal	r0470_private_sector_financial_institutions;
	private BigDecimal	r0470_private_sector_other_private_entities;
	private BigDecimal	r0470_total_amount;
	private String	r0480_product;
	private BigDecimal	r0480_fedaral_govt;
	private BigDecimal	r0480_non_comm_entity_fed_govt;
	private BigDecimal	r0480_local_govt;
	private BigDecimal	r0480_non_comm_entity_emirates_govt;
	private BigDecimal	r0480_gre;
	private BigDecimal	r0480_private_sector_gre;
	private BigDecimal	r0480_private_sector_banks;
	private BigDecimal	r0480_private_sector_financial_institutions;
	private BigDecimal	r0480_private_sector_other_private_entities;
	private BigDecimal	r0480_total_amount;
	private String	r0490_product;
	private BigDecimal	r0490_fedaral_govt;
	private BigDecimal	r0490_non_comm_entity_fed_govt;
	private BigDecimal	r0490_local_govt;
	private BigDecimal	r0490_non_comm_entity_emirates_govt;
	private BigDecimal	r0490_gre;
	private BigDecimal	r0490_private_sector_gre;
	private BigDecimal	r0490_private_sector_banks;
	private BigDecimal	r0490_private_sector_financial_institutions;
	private BigDecimal	r0490_private_sector_other_private_entities;
	private BigDecimal	r0490_total_amount;
	private String	r0500_product;
	private BigDecimal	r0500_fedaral_govt;
	private BigDecimal	r0500_non_comm_entity_fed_govt;
	private BigDecimal	r0500_local_govt;
	private BigDecimal	r0500_non_comm_entity_emirates_govt;
	private BigDecimal	r0500_gre;
	private BigDecimal	r0500_private_sector_gre;
	private BigDecimal	r0500_private_sector_banks;
	private BigDecimal	r0500_private_sector_financial_institutions;
	private BigDecimal	r0500_private_sector_other_private_entities;
	private BigDecimal	r0500_total_amount;
	private String	r0510_product;
	private BigDecimal	r0510_fedaral_govt;
	private BigDecimal	r0510_non_comm_entity_fed_govt;
	private BigDecimal	r0510_local_govt;
	private BigDecimal	r0510_non_comm_entity_emirates_govt;
	private BigDecimal	r0510_gre;
	private BigDecimal	r0510_private_sector_gre;
	private BigDecimal	r0510_private_sector_banks;
	private BigDecimal	r0510_private_sector_financial_institutions;
	private BigDecimal	r0510_private_sector_other_private_entities;
	private BigDecimal	r0510_total_amount;
	private String	r0520_product;
	private BigDecimal	r0520_fedaral_govt;
	private BigDecimal	r0520_non_comm_entity_fed_govt;
	private BigDecimal	r0520_local_govt;
	private BigDecimal	r0520_non_comm_entity_emirates_govt;
	private BigDecimal	r0520_gre;
	private BigDecimal	r0520_private_sector_gre;
	private BigDecimal	r0520_private_sector_banks;
	private BigDecimal	r0520_private_sector_financial_institutions;
	private BigDecimal	r0520_private_sector_other_private_entities;
	private BigDecimal	r0520_total_amount;
	private String	r0530_product;
	private BigDecimal	r0530_fedaral_govt;
	private BigDecimal	r0530_non_comm_entity_fed_govt;
	private BigDecimal	r0530_local_govt;
	private BigDecimal	r0530_non_comm_entity_emirates_govt;
	private BigDecimal	r0530_gre;
	private BigDecimal	r0530_private_sector_gre;
	private BigDecimal	r0530_private_sector_banks;
	private BigDecimal	r0530_private_sector_financial_institutions;
	private BigDecimal	r0530_private_sector_other_private_entities;
	private BigDecimal	r0530_total_amount;
	private String	r0540_product;
	private BigDecimal	r0540_fedaral_govt;
	private BigDecimal	r0540_non_comm_entity_fed_govt;
	private BigDecimal	r0540_local_govt;
	private BigDecimal	r0540_non_comm_entity_emirates_govt;
	private BigDecimal	r0540_gre;
	private BigDecimal	r0540_private_sector_gre;
	private BigDecimal	r0540_private_sector_banks;
	private BigDecimal	r0540_private_sector_financial_institutions;
	private BigDecimal	r0540_private_sector_other_private_entities;
	private BigDecimal	r0540_total_amount;
	private String	r0550_product;
	private BigDecimal	r0550_fedaral_govt;
	private BigDecimal	r0550_non_comm_entity_fed_govt;
	private BigDecimal	r0550_local_govt;
	private BigDecimal	r0550_non_comm_entity_emirates_govt;
	private BigDecimal	r0550_gre;
	private BigDecimal	r0550_private_sector_gre;
	private BigDecimal	r0550_private_sector_banks;
	private BigDecimal	r0550_private_sector_financial_institutions;
	private BigDecimal	r0550_private_sector_other_private_entities;
	private BigDecimal	r0550_total_amount;
	private String	r0560_product;
	private BigDecimal	r0560_fedaral_govt;
	private BigDecimal	r0560_non_comm_entity_fed_govt;
	private BigDecimal	r0560_local_govt;
	private BigDecimal	r0560_non_comm_entity_emirates_govt;
	private BigDecimal	r0560_gre;
	private BigDecimal	r0560_private_sector_gre;
	private BigDecimal	r0560_private_sector_banks;
	private BigDecimal	r0560_private_sector_financial_institutions;
	private BigDecimal	r0560_private_sector_other_private_entities;
	private BigDecimal	r0560_total_amount;
	private String	r0570_product;
	private BigDecimal	r0570_fedaral_govt;
	private BigDecimal	r0570_non_comm_entity_fed_govt;
	private BigDecimal	r0570_local_govt;
	private BigDecimal	r0570_non_comm_entity_emirates_govt;
	private BigDecimal	r0570_gre;
	private BigDecimal	r0570_private_sector_gre;
	private BigDecimal	r0570_private_sector_banks;
	private BigDecimal	r0570_private_sector_financial_institutions;
	private BigDecimal	r0570_private_sector_other_private_entities;
	private BigDecimal	r0570_total_amount;
	private String	r0580_product;
	private BigDecimal	r0580_fedaral_govt;
	private BigDecimal	r0580_non_comm_entity_fed_govt;
	private BigDecimal	r0580_local_govt;
	private BigDecimal	r0580_non_comm_entity_emirates_govt;
	private BigDecimal	r0580_gre;
	private BigDecimal	r0580_private_sector_gre;
	private BigDecimal	r0580_private_sector_banks;
	private BigDecimal	r0580_private_sector_financial_institutions;
	private BigDecimal	r0580_private_sector_other_private_entities;
	private BigDecimal	r0580_total_amount;
	private String	r0590_product;
	private BigDecimal	r0590_fedaral_govt;
	private BigDecimal	r0590_non_comm_entity_fed_govt;
	private BigDecimal	r0590_local_govt;
	private BigDecimal	r0590_non_comm_entity_emirates_govt;
	private BigDecimal	r0590_gre;
	private BigDecimal	r0590_private_sector_gre;
	private BigDecimal	r0590_private_sector_banks;
	private BigDecimal	r0590_private_sector_financial_institutions;
	private BigDecimal	r0590_private_sector_other_private_entities;
	private BigDecimal	r0590_total_amount;
	private String	r0600_product;
	private BigDecimal	r0600_fedaral_govt;
	private BigDecimal	r0600_non_comm_entity_fed_govt;
	private BigDecimal	r0600_local_govt;
	private BigDecimal	r0600_non_comm_entity_emirates_govt;
	private BigDecimal	r0600_gre;
	private BigDecimal	r0600_private_sector_gre;
	private BigDecimal	r0600_private_sector_banks;
	private BigDecimal	r0600_private_sector_financial_institutions;
	private BigDecimal	r0600_private_sector_other_private_entities;
	private BigDecimal	r0600_total_amount;
	private String	r0610_product;
	private BigDecimal	r0610_fedaral_govt;
	private BigDecimal	r0610_non_comm_entity_fed_govt;
	private BigDecimal	r0610_local_govt;
	private BigDecimal	r0610_non_comm_entity_emirates_govt;
	private BigDecimal	r0610_gre;
	private BigDecimal	r0610_private_sector_gre;
	private BigDecimal	r0610_private_sector_banks;
	private BigDecimal	r0610_private_sector_financial_institutions;
	private BigDecimal	r0610_private_sector_other_private_entities;
	private BigDecimal	r0610_total_amount;
	private String	r0620_product;
	private BigDecimal	r0620_fedaral_govt;
	private BigDecimal	r0620_non_comm_entity_fed_govt;
	private BigDecimal	r0620_local_govt;
	private BigDecimal	r0620_non_comm_entity_emirates_govt;
	private BigDecimal	r0620_gre;
	private BigDecimal	r0620_private_sector_gre;
	private BigDecimal	r0620_private_sector_banks;
	private BigDecimal	r0620_private_sector_financial_institutions;
	private BigDecimal	r0620_private_sector_other_private_entities;
	private BigDecimal	r0620_total_amount;
	private String	r0630_product;
	private BigDecimal	r0630_fedaral_govt;
	private BigDecimal	r0630_non_comm_entity_fed_govt;
	private BigDecimal	r0630_local_govt;
	private BigDecimal	r0630_non_comm_entity_emirates_govt;
	private BigDecimal	r0630_gre;
	private BigDecimal	r0630_private_sector_gre;
	private BigDecimal	r0630_private_sector_banks;
	private BigDecimal	r0630_private_sector_financial_institutions;
	private BigDecimal	r0630_private_sector_other_private_entities;
	private BigDecimal	r0630_total_amount;
	private String	r0640_product;
	private BigDecimal	r0640_fedaral_govt;
	private BigDecimal	r0640_non_comm_entity_fed_govt;
	private BigDecimal	r0640_local_govt;
	private BigDecimal	r0640_non_comm_entity_emirates_govt;
	private BigDecimal	r0640_gre;
	private BigDecimal	r0640_private_sector_gre;
	private BigDecimal	r0640_private_sector_banks;
	private BigDecimal	r0640_private_sector_financial_institutions;
	private BigDecimal	r0640_private_sector_other_private_entities;
	private BigDecimal	r0640_total_amount;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	report_date;
	private String	report_version;
	private String	report_frequency;
	private String	report_code;
	private String	report_desc;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public String getR0010_product() {
		return r0010_product;
	}
	public void setR0010_product(String r0010_product) {
		this.r0010_product = r0010_product;
	}
	public BigDecimal getR0010_fedaral_govt() {
		return r0010_fedaral_govt;
	}
	public void setR0010_fedaral_govt(BigDecimal r0010_fedaral_govt) {
		this.r0010_fedaral_govt = r0010_fedaral_govt;
	}
	public BigDecimal getR0010_non_comm_entity_fed_govt() {
		return r0010_non_comm_entity_fed_govt;
	}
	public void setR0010_non_comm_entity_fed_govt(BigDecimal r0010_non_comm_entity_fed_govt) {
		this.r0010_non_comm_entity_fed_govt = r0010_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0010_local_govt() {
		return r0010_local_govt;
	}
	public void setR0010_local_govt(BigDecimal r0010_local_govt) {
		this.r0010_local_govt = r0010_local_govt;
	}
	public BigDecimal getR0010_non_comm_entity_emirates_govt() {
		return r0010_non_comm_entity_emirates_govt;
	}
	public void setR0010_non_comm_entity_emirates_govt(BigDecimal r0010_non_comm_entity_emirates_govt) {
		this.r0010_non_comm_entity_emirates_govt = r0010_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0010_gre() {
		return r0010_gre;
	}
	public void setR0010_gre(BigDecimal r0010_gre) {
		this.r0010_gre = r0010_gre;
	}
	public BigDecimal getR0010_private_sector_gre() {
		return r0010_private_sector_gre;
	}
	public void setR0010_private_sector_gre(BigDecimal r0010_private_sector_gre) {
		this.r0010_private_sector_gre = r0010_private_sector_gre;
	}
	public BigDecimal getR0010_private_sector_banks() {
		return r0010_private_sector_banks;
	}
	public void setR0010_private_sector_banks(BigDecimal r0010_private_sector_banks) {
		this.r0010_private_sector_banks = r0010_private_sector_banks;
	}
	public BigDecimal getR0010_private_sector_financial_institutions() {
		return r0010_private_sector_financial_institutions;
	}
	public void setR0010_private_sector_financial_institutions(BigDecimal r0010_private_sector_financial_institutions) {
		this.r0010_private_sector_financial_institutions = r0010_private_sector_financial_institutions;
	}
	public BigDecimal getR0010_private_sector_other_private_entities() {
		return r0010_private_sector_other_private_entities;
	}
	public void setR0010_private_sector_other_private_entities(BigDecimal r0010_private_sector_other_private_entities) {
		this.r0010_private_sector_other_private_entities = r0010_private_sector_other_private_entities;
	}
	public BigDecimal getR0010_total_amount() {
		return r0010_total_amount;
	}
	public void setR0010_total_amount(BigDecimal r0010_total_amount) {
		this.r0010_total_amount = r0010_total_amount;
	}
	public String getR0020_product() {
		return r0020_product;
	}
	public void setR0020_product(String r0020_product) {
		this.r0020_product = r0020_product;
	}
	public BigDecimal getR0020_fedaral_govt() {
		return r0020_fedaral_govt;
	}
	public void setR0020_fedaral_govt(BigDecimal r0020_fedaral_govt) {
		this.r0020_fedaral_govt = r0020_fedaral_govt;
	}
	public BigDecimal getR0020_non_comm_entity_fed_govt() {
		return r0020_non_comm_entity_fed_govt;
	}
	public void setR0020_non_comm_entity_fed_govt(BigDecimal r0020_non_comm_entity_fed_govt) {
		this.r0020_non_comm_entity_fed_govt = r0020_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0020_local_govt() {
		return r0020_local_govt;
	}
	public void setR0020_local_govt(BigDecimal r0020_local_govt) {
		this.r0020_local_govt = r0020_local_govt;
	}
	public BigDecimal getR0020_non_comm_entity_emirates_govt() {
		return r0020_non_comm_entity_emirates_govt;
	}
	public void setR0020_non_comm_entity_emirates_govt(BigDecimal r0020_non_comm_entity_emirates_govt) {
		this.r0020_non_comm_entity_emirates_govt = r0020_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0020_gre() {
		return r0020_gre;
	}
	public void setR0020_gre(BigDecimal r0020_gre) {
		this.r0020_gre = r0020_gre;
	}
	public BigDecimal getR0020_private_sector_gre() {
		return r0020_private_sector_gre;
	}
	public void setR0020_private_sector_gre(BigDecimal r0020_private_sector_gre) {
		this.r0020_private_sector_gre = r0020_private_sector_gre;
	}
	public BigDecimal getR0020_private_sector_banks() {
		return r0020_private_sector_banks;
	}
	public void setR0020_private_sector_banks(BigDecimal r0020_private_sector_banks) {
		this.r0020_private_sector_banks = r0020_private_sector_banks;
	}
	public BigDecimal getR0020_private_sector_financial_institutions() {
		return r0020_private_sector_financial_institutions;
	}
	public void setR0020_private_sector_financial_institutions(BigDecimal r0020_private_sector_financial_institutions) {
		this.r0020_private_sector_financial_institutions = r0020_private_sector_financial_institutions;
	}
	public BigDecimal getR0020_private_sector_other_private_entities() {
		return r0020_private_sector_other_private_entities;
	}
	public void setR0020_private_sector_other_private_entities(BigDecimal r0020_private_sector_other_private_entities) {
		this.r0020_private_sector_other_private_entities = r0020_private_sector_other_private_entities;
	}
	public BigDecimal getR0020_total_amount() {
		return r0020_total_amount;
	}
	public void setR0020_total_amount(BigDecimal r0020_total_amount) {
		this.r0020_total_amount = r0020_total_amount;
	}
	public String getR0030_product() {
		return r0030_product;
	}
	public void setR0030_product(String r0030_product) {
		this.r0030_product = r0030_product;
	}
	public BigDecimal getR0030_fedaral_govt() {
		return r0030_fedaral_govt;
	}
	public void setR0030_fedaral_govt(BigDecimal r0030_fedaral_govt) {
		this.r0030_fedaral_govt = r0030_fedaral_govt;
	}
	public BigDecimal getR0030_non_comm_entity_fed_govt() {
		return r0030_non_comm_entity_fed_govt;
	}
	public void setR0030_non_comm_entity_fed_govt(BigDecimal r0030_non_comm_entity_fed_govt) {
		this.r0030_non_comm_entity_fed_govt = r0030_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0030_local_govt() {
		return r0030_local_govt;
	}
	public void setR0030_local_govt(BigDecimal r0030_local_govt) {
		this.r0030_local_govt = r0030_local_govt;
	}
	public BigDecimal getR0030_non_comm_entity_emirates_govt() {
		return r0030_non_comm_entity_emirates_govt;
	}
	public void setR0030_non_comm_entity_emirates_govt(BigDecimal r0030_non_comm_entity_emirates_govt) {
		this.r0030_non_comm_entity_emirates_govt = r0030_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0030_gre() {
		return r0030_gre;
	}
	public void setR0030_gre(BigDecimal r0030_gre) {
		this.r0030_gre = r0030_gre;
	}
	public BigDecimal getR0030_private_sector_gre() {
		return r0030_private_sector_gre;
	}
	public void setR0030_private_sector_gre(BigDecimal r0030_private_sector_gre) {
		this.r0030_private_sector_gre = r0030_private_sector_gre;
	}
	public BigDecimal getR0030_private_sector_banks() {
		return r0030_private_sector_banks;
	}
	public void setR0030_private_sector_banks(BigDecimal r0030_private_sector_banks) {
		this.r0030_private_sector_banks = r0030_private_sector_banks;
	}
	public BigDecimal getR0030_private_sector_financial_institutions() {
		return r0030_private_sector_financial_institutions;
	}
	public void setR0030_private_sector_financial_institutions(BigDecimal r0030_private_sector_financial_institutions) {
		this.r0030_private_sector_financial_institutions = r0030_private_sector_financial_institutions;
	}
	public BigDecimal getR0030_private_sector_other_private_entities() {
		return r0030_private_sector_other_private_entities;
	}
	public void setR0030_private_sector_other_private_entities(BigDecimal r0030_private_sector_other_private_entities) {
		this.r0030_private_sector_other_private_entities = r0030_private_sector_other_private_entities;
	}
	public BigDecimal getR0030_total_amount() {
		return r0030_total_amount;
	}
	public void setR0030_total_amount(BigDecimal r0030_total_amount) {
		this.r0030_total_amount = r0030_total_amount;
	}
	public String getR0040_product() {
		return r0040_product;
	}
	public void setR0040_product(String r0040_product) {
		this.r0040_product = r0040_product;
	}
	public BigDecimal getR0040_fedaral_govt() {
		return r0040_fedaral_govt;
	}
	public void setR0040_fedaral_govt(BigDecimal r0040_fedaral_govt) {
		this.r0040_fedaral_govt = r0040_fedaral_govt;
	}
	public BigDecimal getR0040_non_comm_entity_fed_govt() {
		return r0040_non_comm_entity_fed_govt;
	}
	public void setR0040_non_comm_entity_fed_govt(BigDecimal r0040_non_comm_entity_fed_govt) {
		this.r0040_non_comm_entity_fed_govt = r0040_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0040_local_govt() {
		return r0040_local_govt;
	}
	public void setR0040_local_govt(BigDecimal r0040_local_govt) {
		this.r0040_local_govt = r0040_local_govt;
	}
	public BigDecimal getR0040_non_comm_entity_emirates_govt() {
		return r0040_non_comm_entity_emirates_govt;
	}
	public void setR0040_non_comm_entity_emirates_govt(BigDecimal r0040_non_comm_entity_emirates_govt) {
		this.r0040_non_comm_entity_emirates_govt = r0040_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0040_gre() {
		return r0040_gre;
	}
	public void setR0040_gre(BigDecimal r0040_gre) {
		this.r0040_gre = r0040_gre;
	}
	public BigDecimal getR0040_private_sector_gre() {
		return r0040_private_sector_gre;
	}
	public void setR0040_private_sector_gre(BigDecimal r0040_private_sector_gre) {
		this.r0040_private_sector_gre = r0040_private_sector_gre;
	}
	public BigDecimal getR0040_private_sector_banks() {
		return r0040_private_sector_banks;
	}
	public void setR0040_private_sector_banks(BigDecimal r0040_private_sector_banks) {
		this.r0040_private_sector_banks = r0040_private_sector_banks;
	}
	public BigDecimal getR0040_private_sector_financial_institutions() {
		return r0040_private_sector_financial_institutions;
	}
	public void setR0040_private_sector_financial_institutions(BigDecimal r0040_private_sector_financial_institutions) {
		this.r0040_private_sector_financial_institutions = r0040_private_sector_financial_institutions;
	}
	public BigDecimal getR0040_private_sector_other_private_entities() {
		return r0040_private_sector_other_private_entities;
	}
	public void setR0040_private_sector_other_private_entities(BigDecimal r0040_private_sector_other_private_entities) {
		this.r0040_private_sector_other_private_entities = r0040_private_sector_other_private_entities;
	}
	public BigDecimal getR0040_total_amount() {
		return r0040_total_amount;
	}
	public void setR0040_total_amount(BigDecimal r0040_total_amount) {
		this.r0040_total_amount = r0040_total_amount;
	}
	public String getR0050_product() {
		return r0050_product;
	}
	public void setR0050_product(String r0050_product) {
		this.r0050_product = r0050_product;
	}
	public BigDecimal getR0050_fedaral_govt() {
		return r0050_fedaral_govt;
	}
	public void setR0050_fedaral_govt(BigDecimal r0050_fedaral_govt) {
		this.r0050_fedaral_govt = r0050_fedaral_govt;
	}
	public BigDecimal getR0050_non_comm_entity_fed_govt() {
		return r0050_non_comm_entity_fed_govt;
	}
	public void setR0050_non_comm_entity_fed_govt(BigDecimal r0050_non_comm_entity_fed_govt) {
		this.r0050_non_comm_entity_fed_govt = r0050_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0050_local_govt() {
		return r0050_local_govt;
	}
	public void setR0050_local_govt(BigDecimal r0050_local_govt) {
		this.r0050_local_govt = r0050_local_govt;
	}
	public BigDecimal getR0050_non_comm_entity_emirates_govt() {
		return r0050_non_comm_entity_emirates_govt;
	}
	public void setR0050_non_comm_entity_emirates_govt(BigDecimal r0050_non_comm_entity_emirates_govt) {
		this.r0050_non_comm_entity_emirates_govt = r0050_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0050_gre() {
		return r0050_gre;
	}
	public void setR0050_gre(BigDecimal r0050_gre) {
		this.r0050_gre = r0050_gre;
	}
	public BigDecimal getR0050_private_sector_gre() {
		return r0050_private_sector_gre;
	}
	public void setR0050_private_sector_gre(BigDecimal r0050_private_sector_gre) {
		this.r0050_private_sector_gre = r0050_private_sector_gre;
	}
	public BigDecimal getR0050_private_sector_banks() {
		return r0050_private_sector_banks;
	}
	public void setR0050_private_sector_banks(BigDecimal r0050_private_sector_banks) {
		this.r0050_private_sector_banks = r0050_private_sector_banks;
	}
	public BigDecimal getR0050_private_sector_financial_institutions() {
		return r0050_private_sector_financial_institutions;
	}
	public void setR0050_private_sector_financial_institutions(BigDecimal r0050_private_sector_financial_institutions) {
		this.r0050_private_sector_financial_institutions = r0050_private_sector_financial_institutions;
	}
	public BigDecimal getR0050_private_sector_other_private_entities() {
		return r0050_private_sector_other_private_entities;
	}
	public void setR0050_private_sector_other_private_entities(BigDecimal r0050_private_sector_other_private_entities) {
		this.r0050_private_sector_other_private_entities = r0050_private_sector_other_private_entities;
	}
	public BigDecimal getR0050_total_amount() {
		return r0050_total_amount;
	}
	public void setR0050_total_amount(BigDecimal r0050_total_amount) {
		this.r0050_total_amount = r0050_total_amount;
	}
	public String getR0060_product() {
		return r0060_product;
	}
	public void setR0060_product(String r0060_product) {
		this.r0060_product = r0060_product;
	}
	public BigDecimal getR0060_fedaral_govt() {
		return r0060_fedaral_govt;
	}
	public void setR0060_fedaral_govt(BigDecimal r0060_fedaral_govt) {
		this.r0060_fedaral_govt = r0060_fedaral_govt;
	}
	public BigDecimal getR0060_non_comm_entity_fed_govt() {
		return r0060_non_comm_entity_fed_govt;
	}
	public void setR0060_non_comm_entity_fed_govt(BigDecimal r0060_non_comm_entity_fed_govt) {
		this.r0060_non_comm_entity_fed_govt = r0060_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0060_local_govt() {
		return r0060_local_govt;
	}
	public void setR0060_local_govt(BigDecimal r0060_local_govt) {
		this.r0060_local_govt = r0060_local_govt;
	}
	public BigDecimal getR0060_non_comm_entity_emirates_govt() {
		return r0060_non_comm_entity_emirates_govt;
	}
	public void setR0060_non_comm_entity_emirates_govt(BigDecimal r0060_non_comm_entity_emirates_govt) {
		this.r0060_non_comm_entity_emirates_govt = r0060_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0060_gre() {
		return r0060_gre;
	}
	public void setR0060_gre(BigDecimal r0060_gre) {
		this.r0060_gre = r0060_gre;
	}
	public BigDecimal getR0060_private_sector_gre() {
		return r0060_private_sector_gre;
	}
	public void setR0060_private_sector_gre(BigDecimal r0060_private_sector_gre) {
		this.r0060_private_sector_gre = r0060_private_sector_gre;
	}
	public BigDecimal getR0060_private_sector_banks() {
		return r0060_private_sector_banks;
	}
	public void setR0060_private_sector_banks(BigDecimal r0060_private_sector_banks) {
		this.r0060_private_sector_banks = r0060_private_sector_banks;
	}
	public BigDecimal getR0060_private_sector_financial_institutions() {
		return r0060_private_sector_financial_institutions;
	}
	public void setR0060_private_sector_financial_institutions(BigDecimal r0060_private_sector_financial_institutions) {
		this.r0060_private_sector_financial_institutions = r0060_private_sector_financial_institutions;
	}
	public BigDecimal getR0060_private_sector_other_private_entities() {
		return r0060_private_sector_other_private_entities;
	}
	public void setR0060_private_sector_other_private_entities(BigDecimal r0060_private_sector_other_private_entities) {
		this.r0060_private_sector_other_private_entities = r0060_private_sector_other_private_entities;
	}
	public BigDecimal getR0060_total_amount() {
		return r0060_total_amount;
	}
	public void setR0060_total_amount(BigDecimal r0060_total_amount) {
		this.r0060_total_amount = r0060_total_amount;
	}
	public String getR0070_product() {
		return r0070_product;
	}
	public void setR0070_product(String r0070_product) {
		this.r0070_product = r0070_product;
	}
	public BigDecimal getR0070_fedaral_govt() {
		return r0070_fedaral_govt;
	}
	public void setR0070_fedaral_govt(BigDecimal r0070_fedaral_govt) {
		this.r0070_fedaral_govt = r0070_fedaral_govt;
	}
	public BigDecimal getR0070_non_comm_entity_fed_govt() {
		return r0070_non_comm_entity_fed_govt;
	}
	public void setR0070_non_comm_entity_fed_govt(BigDecimal r0070_non_comm_entity_fed_govt) {
		this.r0070_non_comm_entity_fed_govt = r0070_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0070_local_govt() {
		return r0070_local_govt;
	}
	public void setR0070_local_govt(BigDecimal r0070_local_govt) {
		this.r0070_local_govt = r0070_local_govt;
	}
	public BigDecimal getR0070_non_comm_entity_emirates_govt() {
		return r0070_non_comm_entity_emirates_govt;
	}
	public void setR0070_non_comm_entity_emirates_govt(BigDecimal r0070_non_comm_entity_emirates_govt) {
		this.r0070_non_comm_entity_emirates_govt = r0070_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0070_gre() {
		return r0070_gre;
	}
	public void setR0070_gre(BigDecimal r0070_gre) {
		this.r0070_gre = r0070_gre;
	}
	public BigDecimal getR0070_private_sector_gre() {
		return r0070_private_sector_gre;
	}
	public void setR0070_private_sector_gre(BigDecimal r0070_private_sector_gre) {
		this.r0070_private_sector_gre = r0070_private_sector_gre;
	}
	public BigDecimal getR0070_private_sector_banks() {
		return r0070_private_sector_banks;
	}
	public void setR0070_private_sector_banks(BigDecimal r0070_private_sector_banks) {
		this.r0070_private_sector_banks = r0070_private_sector_banks;
	}
	public BigDecimal getR0070_private_sector_financial_institutions() {
		return r0070_private_sector_financial_institutions;
	}
	public void setR0070_private_sector_financial_institutions(BigDecimal r0070_private_sector_financial_institutions) {
		this.r0070_private_sector_financial_institutions = r0070_private_sector_financial_institutions;
	}
	public BigDecimal getR0070_private_sector_other_private_entities() {
		return r0070_private_sector_other_private_entities;
	}
	public void setR0070_private_sector_other_private_entities(BigDecimal r0070_private_sector_other_private_entities) {
		this.r0070_private_sector_other_private_entities = r0070_private_sector_other_private_entities;
	}
	public BigDecimal getR0070_total_amount() {
		return r0070_total_amount;
	}
	public void setR0070_total_amount(BigDecimal r0070_total_amount) {
		this.r0070_total_amount = r0070_total_amount;
	}
	public String getR0080_product() {
		return r0080_product;
	}
	public void setR0080_product(String r0080_product) {
		this.r0080_product = r0080_product;
	}
	public BigDecimal getR0080_fedaral_govt() {
		return r0080_fedaral_govt;
	}
	public void setR0080_fedaral_govt(BigDecimal r0080_fedaral_govt) {
		this.r0080_fedaral_govt = r0080_fedaral_govt;
	}
	public BigDecimal getR0080_non_comm_entity_fed_govt() {
		return r0080_non_comm_entity_fed_govt;
	}
	public void setR0080_non_comm_entity_fed_govt(BigDecimal r0080_non_comm_entity_fed_govt) {
		this.r0080_non_comm_entity_fed_govt = r0080_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0080_local_govt() {
		return r0080_local_govt;
	}
	public void setR0080_local_govt(BigDecimal r0080_local_govt) {
		this.r0080_local_govt = r0080_local_govt;
	}
	public BigDecimal getR0080_non_comm_entity_emirates_govt() {
		return r0080_non_comm_entity_emirates_govt;
	}
	public void setR0080_non_comm_entity_emirates_govt(BigDecimal r0080_non_comm_entity_emirates_govt) {
		this.r0080_non_comm_entity_emirates_govt = r0080_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0080_gre() {
		return r0080_gre;
	}
	public void setR0080_gre(BigDecimal r0080_gre) {
		this.r0080_gre = r0080_gre;
	}
	public BigDecimal getR0080_private_sector_gre() {
		return r0080_private_sector_gre;
	}
	public void setR0080_private_sector_gre(BigDecimal r0080_private_sector_gre) {
		this.r0080_private_sector_gre = r0080_private_sector_gre;
	}
	public BigDecimal getR0080_private_sector_banks() {
		return r0080_private_sector_banks;
	}
	public void setR0080_private_sector_banks(BigDecimal r0080_private_sector_banks) {
		this.r0080_private_sector_banks = r0080_private_sector_banks;
	}
	public BigDecimal getR0080_private_sector_financial_institutions() {
		return r0080_private_sector_financial_institutions;
	}
	public void setR0080_private_sector_financial_institutions(BigDecimal r0080_private_sector_financial_institutions) {
		this.r0080_private_sector_financial_institutions = r0080_private_sector_financial_institutions;
	}
	public BigDecimal getR0080_private_sector_other_private_entities() {
		return r0080_private_sector_other_private_entities;
	}
	public void setR0080_private_sector_other_private_entities(BigDecimal r0080_private_sector_other_private_entities) {
		this.r0080_private_sector_other_private_entities = r0080_private_sector_other_private_entities;
	}
	public BigDecimal getR0080_total_amount() {
		return r0080_total_amount;
	}
	public void setR0080_total_amount(BigDecimal r0080_total_amount) {
		this.r0080_total_amount = r0080_total_amount;
	}
	public String getR0090_product() {
		return r0090_product;
	}
	public void setR0090_product(String r0090_product) {
		this.r0090_product = r0090_product;
	}
	public BigDecimal getR0090_fedaral_govt() {
		return r0090_fedaral_govt;
	}
	public void setR0090_fedaral_govt(BigDecimal r0090_fedaral_govt) {
		this.r0090_fedaral_govt = r0090_fedaral_govt;
	}
	public BigDecimal getR0090_non_comm_entity_fed_govt() {
		return r0090_non_comm_entity_fed_govt;
	}
	public void setR0090_non_comm_entity_fed_govt(BigDecimal r0090_non_comm_entity_fed_govt) {
		this.r0090_non_comm_entity_fed_govt = r0090_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0090_local_govt() {
		return r0090_local_govt;
	}
	public void setR0090_local_govt(BigDecimal r0090_local_govt) {
		this.r0090_local_govt = r0090_local_govt;
	}
	public BigDecimal getR0090_non_comm_entity_emirates_govt() {
		return r0090_non_comm_entity_emirates_govt;
	}
	public void setR0090_non_comm_entity_emirates_govt(BigDecimal r0090_non_comm_entity_emirates_govt) {
		this.r0090_non_comm_entity_emirates_govt = r0090_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0090_gre() {
		return r0090_gre;
	}
	public void setR0090_gre(BigDecimal r0090_gre) {
		this.r0090_gre = r0090_gre;
	}
	public BigDecimal getR0090_private_sector_gre() {
		return r0090_private_sector_gre;
	}
	public void setR0090_private_sector_gre(BigDecimal r0090_private_sector_gre) {
		this.r0090_private_sector_gre = r0090_private_sector_gre;
	}
	public BigDecimal getR0090_private_sector_banks() {
		return r0090_private_sector_banks;
	}
	public void setR0090_private_sector_banks(BigDecimal r0090_private_sector_banks) {
		this.r0090_private_sector_banks = r0090_private_sector_banks;
	}
	public BigDecimal getR0090_private_sector_financial_institutions() {
		return r0090_private_sector_financial_institutions;
	}
	public void setR0090_private_sector_financial_institutions(BigDecimal r0090_private_sector_financial_institutions) {
		this.r0090_private_sector_financial_institutions = r0090_private_sector_financial_institutions;
	}
	public BigDecimal getR0090_private_sector_other_private_entities() {
		return r0090_private_sector_other_private_entities;
	}
	public void setR0090_private_sector_other_private_entities(BigDecimal r0090_private_sector_other_private_entities) {
		this.r0090_private_sector_other_private_entities = r0090_private_sector_other_private_entities;
	}
	public BigDecimal getR0090_total_amount() {
		return r0090_total_amount;
	}
	public void setR0090_total_amount(BigDecimal r0090_total_amount) {
		this.r0090_total_amount = r0090_total_amount;
	}
	public String getR0100_product() {
		return r0100_product;
	}
	public void setR0100_product(String r0100_product) {
		this.r0100_product = r0100_product;
	}
	public BigDecimal getR0100_fedaral_govt() {
		return r0100_fedaral_govt;
	}
	public void setR0100_fedaral_govt(BigDecimal r0100_fedaral_govt) {
		this.r0100_fedaral_govt = r0100_fedaral_govt;
	}
	public BigDecimal getR0100_non_comm_entity_fed_govt() {
		return r0100_non_comm_entity_fed_govt;
	}
	public void setR0100_non_comm_entity_fed_govt(BigDecimal r0100_non_comm_entity_fed_govt) {
		this.r0100_non_comm_entity_fed_govt = r0100_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0100_local_govt() {
		return r0100_local_govt;
	}
	public void setR0100_local_govt(BigDecimal r0100_local_govt) {
		this.r0100_local_govt = r0100_local_govt;
	}
	public BigDecimal getR0100_non_comm_entity_emirates_govt() {
		return r0100_non_comm_entity_emirates_govt;
	}
	public void setR0100_non_comm_entity_emirates_govt(BigDecimal r0100_non_comm_entity_emirates_govt) {
		this.r0100_non_comm_entity_emirates_govt = r0100_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0100_gre() {
		return r0100_gre;
	}
	public void setR0100_gre(BigDecimal r0100_gre) {
		this.r0100_gre = r0100_gre;
	}
	public BigDecimal getR0100_private_sector_gre() {
		return r0100_private_sector_gre;
	}
	public void setR0100_private_sector_gre(BigDecimal r0100_private_sector_gre) {
		this.r0100_private_sector_gre = r0100_private_sector_gre;
	}
	public BigDecimal getR0100_private_sector_banks() {
		return r0100_private_sector_banks;
	}
	public void setR0100_private_sector_banks(BigDecimal r0100_private_sector_banks) {
		this.r0100_private_sector_banks = r0100_private_sector_banks;
	}
	public BigDecimal getR0100_private_sector_financial_institutions() {
		return r0100_private_sector_financial_institutions;
	}
	public void setR0100_private_sector_financial_institutions(BigDecimal r0100_private_sector_financial_institutions) {
		this.r0100_private_sector_financial_institutions = r0100_private_sector_financial_institutions;
	}
	public BigDecimal getR0100_private_sector_other_private_entities() {
		return r0100_private_sector_other_private_entities;
	}
	public void setR0100_private_sector_other_private_entities(BigDecimal r0100_private_sector_other_private_entities) {
		this.r0100_private_sector_other_private_entities = r0100_private_sector_other_private_entities;
	}
	public BigDecimal getR0100_total_amount() {
		return r0100_total_amount;
	}
	public void setR0100_total_amount(BigDecimal r0100_total_amount) {
		this.r0100_total_amount = r0100_total_amount;
	}
	public String getR0110_product() {
		return r0110_product;
	}
	public void setR0110_product(String r0110_product) {
		this.r0110_product = r0110_product;
	}
	public BigDecimal getR0110_fedaral_govt() {
		return r0110_fedaral_govt;
	}
	public void setR0110_fedaral_govt(BigDecimal r0110_fedaral_govt) {
		this.r0110_fedaral_govt = r0110_fedaral_govt;
	}
	public BigDecimal getR0110_non_comm_entity_fed_govt() {
		return r0110_non_comm_entity_fed_govt;
	}
	public void setR0110_non_comm_entity_fed_govt(BigDecimal r0110_non_comm_entity_fed_govt) {
		this.r0110_non_comm_entity_fed_govt = r0110_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0110_local_govt() {
		return r0110_local_govt;
	}
	public void setR0110_local_govt(BigDecimal r0110_local_govt) {
		this.r0110_local_govt = r0110_local_govt;
	}
	public BigDecimal getR0110_non_comm_entity_emirates_govt() {
		return r0110_non_comm_entity_emirates_govt;
	}
	public void setR0110_non_comm_entity_emirates_govt(BigDecimal r0110_non_comm_entity_emirates_govt) {
		this.r0110_non_comm_entity_emirates_govt = r0110_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0110_gre() {
		return r0110_gre;
	}
	public void setR0110_gre(BigDecimal r0110_gre) {
		this.r0110_gre = r0110_gre;
	}
	public BigDecimal getR0110_private_sector_gre() {
		return r0110_private_sector_gre;
	}
	public void setR0110_private_sector_gre(BigDecimal r0110_private_sector_gre) {
		this.r0110_private_sector_gre = r0110_private_sector_gre;
	}
	public BigDecimal getR0110_private_sector_banks() {
		return r0110_private_sector_banks;
	}
	public void setR0110_private_sector_banks(BigDecimal r0110_private_sector_banks) {
		this.r0110_private_sector_banks = r0110_private_sector_banks;
	}
	public BigDecimal getR0110_private_sector_financial_institutions() {
		return r0110_private_sector_financial_institutions;
	}
	public void setR0110_private_sector_financial_institutions(BigDecimal r0110_private_sector_financial_institutions) {
		this.r0110_private_sector_financial_institutions = r0110_private_sector_financial_institutions;
	}
	public BigDecimal getR0110_private_sector_other_private_entities() {
		return r0110_private_sector_other_private_entities;
	}
	public void setR0110_private_sector_other_private_entities(BigDecimal r0110_private_sector_other_private_entities) {
		this.r0110_private_sector_other_private_entities = r0110_private_sector_other_private_entities;
	}
	public BigDecimal getR0110_total_amount() {
		return r0110_total_amount;
	}
	public void setR0110_total_amount(BigDecimal r0110_total_amount) {
		this.r0110_total_amount = r0110_total_amount;
	}
	public String getR0120_product() {
		return r0120_product;
	}
	public void setR0120_product(String r0120_product) {
		this.r0120_product = r0120_product;
	}
	public BigDecimal getR0120_fedaral_govt() {
		return r0120_fedaral_govt;
	}
	public void setR0120_fedaral_govt(BigDecimal r0120_fedaral_govt) {
		this.r0120_fedaral_govt = r0120_fedaral_govt;
	}
	public BigDecimal getR0120_non_comm_entity_fed_govt() {
		return r0120_non_comm_entity_fed_govt;
	}
	public void setR0120_non_comm_entity_fed_govt(BigDecimal r0120_non_comm_entity_fed_govt) {
		this.r0120_non_comm_entity_fed_govt = r0120_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0120_local_govt() {
		return r0120_local_govt;
	}
	public void setR0120_local_govt(BigDecimal r0120_local_govt) {
		this.r0120_local_govt = r0120_local_govt;
	}
	public BigDecimal getR0120_non_comm_entity_emirates_govt() {
		return r0120_non_comm_entity_emirates_govt;
	}
	public void setR0120_non_comm_entity_emirates_govt(BigDecimal r0120_non_comm_entity_emirates_govt) {
		this.r0120_non_comm_entity_emirates_govt = r0120_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0120_gre() {
		return r0120_gre;
	}
	public void setR0120_gre(BigDecimal r0120_gre) {
		this.r0120_gre = r0120_gre;
	}
	public BigDecimal getR0120_private_sector_gre() {
		return r0120_private_sector_gre;
	}
	public void setR0120_private_sector_gre(BigDecimal r0120_private_sector_gre) {
		this.r0120_private_sector_gre = r0120_private_sector_gre;
	}
	public BigDecimal getR0120_private_sector_banks() {
		return r0120_private_sector_banks;
	}
	public void setR0120_private_sector_banks(BigDecimal r0120_private_sector_banks) {
		this.r0120_private_sector_banks = r0120_private_sector_banks;
	}
	public BigDecimal getR0120_private_sector_financial_institutions() {
		return r0120_private_sector_financial_institutions;
	}
	public void setR0120_private_sector_financial_institutions(BigDecimal r0120_private_sector_financial_institutions) {
		this.r0120_private_sector_financial_institutions = r0120_private_sector_financial_institutions;
	}
	public BigDecimal getR0120_private_sector_other_private_entities() {
		return r0120_private_sector_other_private_entities;
	}
	public void setR0120_private_sector_other_private_entities(BigDecimal r0120_private_sector_other_private_entities) {
		this.r0120_private_sector_other_private_entities = r0120_private_sector_other_private_entities;
	}
	public BigDecimal getR0120_total_amount() {
		return r0120_total_amount;
	}
	public void setR0120_total_amount(BigDecimal r0120_total_amount) {
		this.r0120_total_amount = r0120_total_amount;
	}
	public String getR0130_product() {
		return r0130_product;
	}
	public void setR0130_product(String r0130_product) {
		this.r0130_product = r0130_product;
	}
	public BigDecimal getR0130_fedaral_govt() {
		return r0130_fedaral_govt;
	}
	public void setR0130_fedaral_govt(BigDecimal r0130_fedaral_govt) {
		this.r0130_fedaral_govt = r0130_fedaral_govt;
	}
	public BigDecimal getR0130_non_comm_entity_fed_govt() {
		return r0130_non_comm_entity_fed_govt;
	}
	public void setR0130_non_comm_entity_fed_govt(BigDecimal r0130_non_comm_entity_fed_govt) {
		this.r0130_non_comm_entity_fed_govt = r0130_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0130_local_govt() {
		return r0130_local_govt;
	}
	public void setR0130_local_govt(BigDecimal r0130_local_govt) {
		this.r0130_local_govt = r0130_local_govt;
	}
	public BigDecimal getR0130_non_comm_entity_emirates_govt() {
		return r0130_non_comm_entity_emirates_govt;
	}
	public void setR0130_non_comm_entity_emirates_govt(BigDecimal r0130_non_comm_entity_emirates_govt) {
		this.r0130_non_comm_entity_emirates_govt = r0130_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0130_gre() {
		return r0130_gre;
	}
	public void setR0130_gre(BigDecimal r0130_gre) {
		this.r0130_gre = r0130_gre;
	}
	public BigDecimal getR0130_private_sector_gre() {
		return r0130_private_sector_gre;
	}
	public void setR0130_private_sector_gre(BigDecimal r0130_private_sector_gre) {
		this.r0130_private_sector_gre = r0130_private_sector_gre;
	}
	public BigDecimal getR0130_private_sector_banks() {
		return r0130_private_sector_banks;
	}
	public void setR0130_private_sector_banks(BigDecimal r0130_private_sector_banks) {
		this.r0130_private_sector_banks = r0130_private_sector_banks;
	}
	public BigDecimal getR0130_private_sector_financial_institutions() {
		return r0130_private_sector_financial_institutions;
	}
	public void setR0130_private_sector_financial_institutions(BigDecimal r0130_private_sector_financial_institutions) {
		this.r0130_private_sector_financial_institutions = r0130_private_sector_financial_institutions;
	}
	public BigDecimal getR0130_private_sector_other_private_entities() {
		return r0130_private_sector_other_private_entities;
	}
	public void setR0130_private_sector_other_private_entities(BigDecimal r0130_private_sector_other_private_entities) {
		this.r0130_private_sector_other_private_entities = r0130_private_sector_other_private_entities;
	}
	public BigDecimal getR0130_total_amount() {
		return r0130_total_amount;
	}
	public void setR0130_total_amount(BigDecimal r0130_total_amount) {
		this.r0130_total_amount = r0130_total_amount;
	}
	public String getR0140_product() {
		return r0140_product;
	}
	public void setR0140_product(String r0140_product) {
		this.r0140_product = r0140_product;
	}
	public BigDecimal getR0140_fedaral_govt() {
		return r0140_fedaral_govt;
	}
	public void setR0140_fedaral_govt(BigDecimal r0140_fedaral_govt) {
		this.r0140_fedaral_govt = r0140_fedaral_govt;
	}
	public BigDecimal getR0140_non_comm_entity_fed_govt() {
		return r0140_non_comm_entity_fed_govt;
	}
	public void setR0140_non_comm_entity_fed_govt(BigDecimal r0140_non_comm_entity_fed_govt) {
		this.r0140_non_comm_entity_fed_govt = r0140_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0140_local_govt() {
		return r0140_local_govt;
	}
	public void setR0140_local_govt(BigDecimal r0140_local_govt) {
		this.r0140_local_govt = r0140_local_govt;
	}
	public BigDecimal getR0140_non_comm_entity_emirates_govt() {
		return r0140_non_comm_entity_emirates_govt;
	}
	public void setR0140_non_comm_entity_emirates_govt(BigDecimal r0140_non_comm_entity_emirates_govt) {
		this.r0140_non_comm_entity_emirates_govt = r0140_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0140_gre() {
		return r0140_gre;
	}
	public void setR0140_gre(BigDecimal r0140_gre) {
		this.r0140_gre = r0140_gre;
	}
	public BigDecimal getR0140_private_sector_gre() {
		return r0140_private_sector_gre;
	}
	public void setR0140_private_sector_gre(BigDecimal r0140_private_sector_gre) {
		this.r0140_private_sector_gre = r0140_private_sector_gre;
	}
	public BigDecimal getR0140_private_sector_banks() {
		return r0140_private_sector_banks;
	}
	public void setR0140_private_sector_banks(BigDecimal r0140_private_sector_banks) {
		this.r0140_private_sector_banks = r0140_private_sector_banks;
	}
	public BigDecimal getR0140_private_sector_financial_institutions() {
		return r0140_private_sector_financial_institutions;
	}
	public void setR0140_private_sector_financial_institutions(BigDecimal r0140_private_sector_financial_institutions) {
		this.r0140_private_sector_financial_institutions = r0140_private_sector_financial_institutions;
	}
	public BigDecimal getR0140_private_sector_other_private_entities() {
		return r0140_private_sector_other_private_entities;
	}
	public void setR0140_private_sector_other_private_entities(BigDecimal r0140_private_sector_other_private_entities) {
		this.r0140_private_sector_other_private_entities = r0140_private_sector_other_private_entities;
	}
	public BigDecimal getR0140_total_amount() {
		return r0140_total_amount;
	}
	public void setR0140_total_amount(BigDecimal r0140_total_amount) {
		this.r0140_total_amount = r0140_total_amount;
	}
	public String getR0150_product() {
		return r0150_product;
	}
	public void setR0150_product(String r0150_product) {
		this.r0150_product = r0150_product;
	}
	public BigDecimal getR0150_fedaral_govt() {
		return r0150_fedaral_govt;
	}
	public void setR0150_fedaral_govt(BigDecimal r0150_fedaral_govt) {
		this.r0150_fedaral_govt = r0150_fedaral_govt;
	}
	public BigDecimal getR0150_non_comm_entity_fed_govt() {
		return r0150_non_comm_entity_fed_govt;
	}
	public void setR0150_non_comm_entity_fed_govt(BigDecimal r0150_non_comm_entity_fed_govt) {
		this.r0150_non_comm_entity_fed_govt = r0150_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0150_local_govt() {
		return r0150_local_govt;
	}
	public void setR0150_local_govt(BigDecimal r0150_local_govt) {
		this.r0150_local_govt = r0150_local_govt;
	}
	public BigDecimal getR0150_non_comm_entity_emirates_govt() {
		return r0150_non_comm_entity_emirates_govt;
	}
	public void setR0150_non_comm_entity_emirates_govt(BigDecimal r0150_non_comm_entity_emirates_govt) {
		this.r0150_non_comm_entity_emirates_govt = r0150_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0150_gre() {
		return r0150_gre;
	}
	public void setR0150_gre(BigDecimal r0150_gre) {
		this.r0150_gre = r0150_gre;
	}
	public BigDecimal getR0150_private_sector_gre() {
		return r0150_private_sector_gre;
	}
	public void setR0150_private_sector_gre(BigDecimal r0150_private_sector_gre) {
		this.r0150_private_sector_gre = r0150_private_sector_gre;
	}
	public BigDecimal getR0150_private_sector_banks() {
		return r0150_private_sector_banks;
	}
	public void setR0150_private_sector_banks(BigDecimal r0150_private_sector_banks) {
		this.r0150_private_sector_banks = r0150_private_sector_banks;
	}
	public BigDecimal getR0150_private_sector_financial_institutions() {
		return r0150_private_sector_financial_institutions;
	}
	public void setR0150_private_sector_financial_institutions(BigDecimal r0150_private_sector_financial_institutions) {
		this.r0150_private_sector_financial_institutions = r0150_private_sector_financial_institutions;
	}
	public BigDecimal getR0150_private_sector_other_private_entities() {
		return r0150_private_sector_other_private_entities;
	}
	public void setR0150_private_sector_other_private_entities(BigDecimal r0150_private_sector_other_private_entities) {
		this.r0150_private_sector_other_private_entities = r0150_private_sector_other_private_entities;
	}
	public BigDecimal getR0150_total_amount() {
		return r0150_total_amount;
	}
	public void setR0150_total_amount(BigDecimal r0150_total_amount) {
		this.r0150_total_amount = r0150_total_amount;
	}
	public String getR0160_product() {
		return r0160_product;
	}
	public void setR0160_product(String r0160_product) {
		this.r0160_product = r0160_product;
	}
	public BigDecimal getR0160_fedaral_govt() {
		return r0160_fedaral_govt;
	}
	public void setR0160_fedaral_govt(BigDecimal r0160_fedaral_govt) {
		this.r0160_fedaral_govt = r0160_fedaral_govt;
	}
	public BigDecimal getR0160_non_comm_entity_fed_govt() {
		return r0160_non_comm_entity_fed_govt;
	}
	public void setR0160_non_comm_entity_fed_govt(BigDecimal r0160_non_comm_entity_fed_govt) {
		this.r0160_non_comm_entity_fed_govt = r0160_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0160_local_govt() {
		return r0160_local_govt;
	}
	public void setR0160_local_govt(BigDecimal r0160_local_govt) {
		this.r0160_local_govt = r0160_local_govt;
	}
	public BigDecimal getR0160_non_comm_entity_emirates_govt() {
		return r0160_non_comm_entity_emirates_govt;
	}
	public void setR0160_non_comm_entity_emirates_govt(BigDecimal r0160_non_comm_entity_emirates_govt) {
		this.r0160_non_comm_entity_emirates_govt = r0160_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0160_gre() {
		return r0160_gre;
	}
	public void setR0160_gre(BigDecimal r0160_gre) {
		this.r0160_gre = r0160_gre;
	}
	public BigDecimal getR0160_private_sector_gre() {
		return r0160_private_sector_gre;
	}
	public void setR0160_private_sector_gre(BigDecimal r0160_private_sector_gre) {
		this.r0160_private_sector_gre = r0160_private_sector_gre;
	}
	public BigDecimal getR0160_private_sector_banks() {
		return r0160_private_sector_banks;
	}
	public void setR0160_private_sector_banks(BigDecimal r0160_private_sector_banks) {
		this.r0160_private_sector_banks = r0160_private_sector_banks;
	}
	public BigDecimal getR0160_private_sector_financial_institutions() {
		return r0160_private_sector_financial_institutions;
	}
	public void setR0160_private_sector_financial_institutions(BigDecimal r0160_private_sector_financial_institutions) {
		this.r0160_private_sector_financial_institutions = r0160_private_sector_financial_institutions;
	}
	public BigDecimal getR0160_private_sector_other_private_entities() {
		return r0160_private_sector_other_private_entities;
	}
	public void setR0160_private_sector_other_private_entities(BigDecimal r0160_private_sector_other_private_entities) {
		this.r0160_private_sector_other_private_entities = r0160_private_sector_other_private_entities;
	}
	public BigDecimal getR0160_total_amount() {
		return r0160_total_amount;
	}
	public void setR0160_total_amount(BigDecimal r0160_total_amount) {
		this.r0160_total_amount = r0160_total_amount;
	}
	public String getR0170_product() {
		return r0170_product;
	}
	public void setR0170_product(String r0170_product) {
		this.r0170_product = r0170_product;
	}
	public BigDecimal getR0170_fedaral_govt() {
		return r0170_fedaral_govt;
	}
	public void setR0170_fedaral_govt(BigDecimal r0170_fedaral_govt) {
		this.r0170_fedaral_govt = r0170_fedaral_govt;
	}
	public BigDecimal getR0170_non_comm_entity_fed_govt() {
		return r0170_non_comm_entity_fed_govt;
	}
	public void setR0170_non_comm_entity_fed_govt(BigDecimal r0170_non_comm_entity_fed_govt) {
		this.r0170_non_comm_entity_fed_govt = r0170_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0170_local_govt() {
		return r0170_local_govt;
	}
	public void setR0170_local_govt(BigDecimal r0170_local_govt) {
		this.r0170_local_govt = r0170_local_govt;
	}
	public BigDecimal getR0170_non_comm_entity_emirates_govt() {
		return r0170_non_comm_entity_emirates_govt;
	}
	public void setR0170_non_comm_entity_emirates_govt(BigDecimal r0170_non_comm_entity_emirates_govt) {
		this.r0170_non_comm_entity_emirates_govt = r0170_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0170_gre() {
		return r0170_gre;
	}
	public void setR0170_gre(BigDecimal r0170_gre) {
		this.r0170_gre = r0170_gre;
	}
	public BigDecimal getR0170_private_sector_gre() {
		return r0170_private_sector_gre;
	}
	public void setR0170_private_sector_gre(BigDecimal r0170_private_sector_gre) {
		this.r0170_private_sector_gre = r0170_private_sector_gre;
	}
	public BigDecimal getR0170_private_sector_banks() {
		return r0170_private_sector_banks;
	}
	public void setR0170_private_sector_banks(BigDecimal r0170_private_sector_banks) {
		this.r0170_private_sector_banks = r0170_private_sector_banks;
	}
	public BigDecimal getR0170_private_sector_financial_institutions() {
		return r0170_private_sector_financial_institutions;
	}
	public void setR0170_private_sector_financial_institutions(BigDecimal r0170_private_sector_financial_institutions) {
		this.r0170_private_sector_financial_institutions = r0170_private_sector_financial_institutions;
	}
	public BigDecimal getR0170_private_sector_other_private_entities() {
		return r0170_private_sector_other_private_entities;
	}
	public void setR0170_private_sector_other_private_entities(BigDecimal r0170_private_sector_other_private_entities) {
		this.r0170_private_sector_other_private_entities = r0170_private_sector_other_private_entities;
	}
	public BigDecimal getR0170_total_amount() {
		return r0170_total_amount;
	}
	public void setR0170_total_amount(BigDecimal r0170_total_amount) {
		this.r0170_total_amount = r0170_total_amount;
	}
	public String getR0180_product() {
		return r0180_product;
	}
	public void setR0180_product(String r0180_product) {
		this.r0180_product = r0180_product;
	}
	public BigDecimal getR0180_fedaral_govt() {
		return r0180_fedaral_govt;
	}
	public void setR0180_fedaral_govt(BigDecimal r0180_fedaral_govt) {
		this.r0180_fedaral_govt = r0180_fedaral_govt;
	}
	public BigDecimal getR0180_non_comm_entity_fed_govt() {
		return r0180_non_comm_entity_fed_govt;
	}
	public void setR0180_non_comm_entity_fed_govt(BigDecimal r0180_non_comm_entity_fed_govt) {
		this.r0180_non_comm_entity_fed_govt = r0180_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0180_local_govt() {
		return r0180_local_govt;
	}
	public void setR0180_local_govt(BigDecimal r0180_local_govt) {
		this.r0180_local_govt = r0180_local_govt;
	}
	public BigDecimal getR0180_non_comm_entity_emirates_govt() {
		return r0180_non_comm_entity_emirates_govt;
	}
	public void setR0180_non_comm_entity_emirates_govt(BigDecimal r0180_non_comm_entity_emirates_govt) {
		this.r0180_non_comm_entity_emirates_govt = r0180_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0180_gre() {
		return r0180_gre;
	}
	public void setR0180_gre(BigDecimal r0180_gre) {
		this.r0180_gre = r0180_gre;
	}
	public BigDecimal getR0180_private_sector_gre() {
		return r0180_private_sector_gre;
	}
	public void setR0180_private_sector_gre(BigDecimal r0180_private_sector_gre) {
		this.r0180_private_sector_gre = r0180_private_sector_gre;
	}
	public BigDecimal getR0180_private_sector_banks() {
		return r0180_private_sector_banks;
	}
	public void setR0180_private_sector_banks(BigDecimal r0180_private_sector_banks) {
		this.r0180_private_sector_banks = r0180_private_sector_banks;
	}
	public BigDecimal getR0180_private_sector_financial_institutions() {
		return r0180_private_sector_financial_institutions;
	}
	public void setR0180_private_sector_financial_institutions(BigDecimal r0180_private_sector_financial_institutions) {
		this.r0180_private_sector_financial_institutions = r0180_private_sector_financial_institutions;
	}
	public BigDecimal getR0180_private_sector_other_private_entities() {
		return r0180_private_sector_other_private_entities;
	}
	public void setR0180_private_sector_other_private_entities(BigDecimal r0180_private_sector_other_private_entities) {
		this.r0180_private_sector_other_private_entities = r0180_private_sector_other_private_entities;
	}
	public BigDecimal getR0180_total_amount() {
		return r0180_total_amount;
	}
	public void setR0180_total_amount(BigDecimal r0180_total_amount) {
		this.r0180_total_amount = r0180_total_amount;
	}
	public String getR0190_product() {
		return r0190_product;
	}
	public void setR0190_product(String r0190_product) {
		this.r0190_product = r0190_product;
	}
	public BigDecimal getR0190_fedaral_govt() {
		return r0190_fedaral_govt;
	}
	public void setR0190_fedaral_govt(BigDecimal r0190_fedaral_govt) {
		this.r0190_fedaral_govt = r0190_fedaral_govt;
	}
	public BigDecimal getR0190_non_comm_entity_fed_govt() {
		return r0190_non_comm_entity_fed_govt;
	}
	public void setR0190_non_comm_entity_fed_govt(BigDecimal r0190_non_comm_entity_fed_govt) {
		this.r0190_non_comm_entity_fed_govt = r0190_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0190_local_govt() {
		return r0190_local_govt;
	}
	public void setR0190_local_govt(BigDecimal r0190_local_govt) {
		this.r0190_local_govt = r0190_local_govt;
	}
	public BigDecimal getR0190_non_comm_entity_emirates_govt() {
		return r0190_non_comm_entity_emirates_govt;
	}
	public void setR0190_non_comm_entity_emirates_govt(BigDecimal r0190_non_comm_entity_emirates_govt) {
		this.r0190_non_comm_entity_emirates_govt = r0190_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0190_gre() {
		return r0190_gre;
	}
	public void setR0190_gre(BigDecimal r0190_gre) {
		this.r0190_gre = r0190_gre;
	}
	public BigDecimal getR0190_private_sector_gre() {
		return r0190_private_sector_gre;
	}
	public void setR0190_private_sector_gre(BigDecimal r0190_private_sector_gre) {
		this.r0190_private_sector_gre = r0190_private_sector_gre;
	}
	public BigDecimal getR0190_private_sector_banks() {
		return r0190_private_sector_banks;
	}
	public void setR0190_private_sector_banks(BigDecimal r0190_private_sector_banks) {
		this.r0190_private_sector_banks = r0190_private_sector_banks;
	}
	public BigDecimal getR0190_private_sector_financial_institutions() {
		return r0190_private_sector_financial_institutions;
	}
	public void setR0190_private_sector_financial_institutions(BigDecimal r0190_private_sector_financial_institutions) {
		this.r0190_private_sector_financial_institutions = r0190_private_sector_financial_institutions;
	}
	public BigDecimal getR0190_private_sector_other_private_entities() {
		return r0190_private_sector_other_private_entities;
	}
	public void setR0190_private_sector_other_private_entities(BigDecimal r0190_private_sector_other_private_entities) {
		this.r0190_private_sector_other_private_entities = r0190_private_sector_other_private_entities;
	}
	public BigDecimal getR0190_total_amount() {
		return r0190_total_amount;
	}
	public void setR0190_total_amount(BigDecimal r0190_total_amount) {
		this.r0190_total_amount = r0190_total_amount;
	}
	public String getR0200_product() {
		return r0200_product;
	}
	public void setR0200_product(String r0200_product) {
		this.r0200_product = r0200_product;
	}
	public BigDecimal getR0200_fedaral_govt() {
		return r0200_fedaral_govt;
	}
	public void setR0200_fedaral_govt(BigDecimal r0200_fedaral_govt) {
		this.r0200_fedaral_govt = r0200_fedaral_govt;
	}
	public BigDecimal getR0200_non_comm_entity_fed_govt() {
		return r0200_non_comm_entity_fed_govt;
	}
	public void setR0200_non_comm_entity_fed_govt(BigDecimal r0200_non_comm_entity_fed_govt) {
		this.r0200_non_comm_entity_fed_govt = r0200_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0200_local_govt() {
		return r0200_local_govt;
	}
	public void setR0200_local_govt(BigDecimal r0200_local_govt) {
		this.r0200_local_govt = r0200_local_govt;
	}
	public BigDecimal getR0200_non_comm_entity_emirates_govt() {
		return r0200_non_comm_entity_emirates_govt;
	}
	public void setR0200_non_comm_entity_emirates_govt(BigDecimal r0200_non_comm_entity_emirates_govt) {
		this.r0200_non_comm_entity_emirates_govt = r0200_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0200_gre() {
		return r0200_gre;
	}
	public void setR0200_gre(BigDecimal r0200_gre) {
		this.r0200_gre = r0200_gre;
	}
	public BigDecimal getR0200_private_sector_gre() {
		return r0200_private_sector_gre;
	}
	public void setR0200_private_sector_gre(BigDecimal r0200_private_sector_gre) {
		this.r0200_private_sector_gre = r0200_private_sector_gre;
	}
	public BigDecimal getR0200_private_sector_banks() {
		return r0200_private_sector_banks;
	}
	public void setR0200_private_sector_banks(BigDecimal r0200_private_sector_banks) {
		this.r0200_private_sector_banks = r0200_private_sector_banks;
	}
	public BigDecimal getR0200_private_sector_financial_institutions() {
		return r0200_private_sector_financial_institutions;
	}
	public void setR0200_private_sector_financial_institutions(BigDecimal r0200_private_sector_financial_institutions) {
		this.r0200_private_sector_financial_institutions = r0200_private_sector_financial_institutions;
	}
	public BigDecimal getR0200_private_sector_other_private_entities() {
		return r0200_private_sector_other_private_entities;
	}
	public void setR0200_private_sector_other_private_entities(BigDecimal r0200_private_sector_other_private_entities) {
		this.r0200_private_sector_other_private_entities = r0200_private_sector_other_private_entities;
	}
	public BigDecimal getR0200_total_amount() {
		return r0200_total_amount;
	}
	public void setR0200_total_amount(BigDecimal r0200_total_amount) {
		this.r0200_total_amount = r0200_total_amount;
	}
	public String getR0210_product() {
		return r0210_product;
	}
	public void setR0210_product(String r0210_product) {
		this.r0210_product = r0210_product;
	}
	public BigDecimal getR0210_fedaral_govt() {
		return r0210_fedaral_govt;
	}
	public void setR0210_fedaral_govt(BigDecimal r0210_fedaral_govt) {
		this.r0210_fedaral_govt = r0210_fedaral_govt;
	}
	public BigDecimal getR0210_non_comm_entity_fed_govt() {
		return r0210_non_comm_entity_fed_govt;
	}
	public void setR0210_non_comm_entity_fed_govt(BigDecimal r0210_non_comm_entity_fed_govt) {
		this.r0210_non_comm_entity_fed_govt = r0210_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0210_local_govt() {
		return r0210_local_govt;
	}
	public void setR0210_local_govt(BigDecimal r0210_local_govt) {
		this.r0210_local_govt = r0210_local_govt;
	}
	public BigDecimal getR0210_non_comm_entity_emirates_govt() {
		return r0210_non_comm_entity_emirates_govt;
	}
	public void setR0210_non_comm_entity_emirates_govt(BigDecimal r0210_non_comm_entity_emirates_govt) {
		this.r0210_non_comm_entity_emirates_govt = r0210_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0210_gre() {
		return r0210_gre;
	}
	public void setR0210_gre(BigDecimal r0210_gre) {
		this.r0210_gre = r0210_gre;
	}
	public BigDecimal getR0210_private_sector_gre() {
		return r0210_private_sector_gre;
	}
	public void setR0210_private_sector_gre(BigDecimal r0210_private_sector_gre) {
		this.r0210_private_sector_gre = r0210_private_sector_gre;
	}
	public BigDecimal getR0210_private_sector_banks() {
		return r0210_private_sector_banks;
	}
	public void setR0210_private_sector_banks(BigDecimal r0210_private_sector_banks) {
		this.r0210_private_sector_banks = r0210_private_sector_banks;
	}
	public BigDecimal getR0210_private_sector_financial_institutions() {
		return r0210_private_sector_financial_institutions;
	}
	public void setR0210_private_sector_financial_institutions(BigDecimal r0210_private_sector_financial_institutions) {
		this.r0210_private_sector_financial_institutions = r0210_private_sector_financial_institutions;
	}
	public BigDecimal getR0210_private_sector_other_private_entities() {
		return r0210_private_sector_other_private_entities;
	}
	public void setR0210_private_sector_other_private_entities(BigDecimal r0210_private_sector_other_private_entities) {
		this.r0210_private_sector_other_private_entities = r0210_private_sector_other_private_entities;
	}
	public BigDecimal getR0210_total_amount() {
		return r0210_total_amount;
	}
	public void setR0210_total_amount(BigDecimal r0210_total_amount) {
		this.r0210_total_amount = r0210_total_amount;
	}
	public String getR0220_product() {
		return r0220_product;
	}
	public void setR0220_product(String r0220_product) {
		this.r0220_product = r0220_product;
	}
	public BigDecimal getR0220_fedaral_govt() {
		return r0220_fedaral_govt;
	}
	public void setR0220_fedaral_govt(BigDecimal r0220_fedaral_govt) {
		this.r0220_fedaral_govt = r0220_fedaral_govt;
	}
	public BigDecimal getR0220_non_comm_entity_fed_govt() {
		return r0220_non_comm_entity_fed_govt;
	}
	public void setR0220_non_comm_entity_fed_govt(BigDecimal r0220_non_comm_entity_fed_govt) {
		this.r0220_non_comm_entity_fed_govt = r0220_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0220_local_govt() {
		return r0220_local_govt;
	}
	public void setR0220_local_govt(BigDecimal r0220_local_govt) {
		this.r0220_local_govt = r0220_local_govt;
	}
	public BigDecimal getR0220_non_comm_entity_emirates_govt() {
		return r0220_non_comm_entity_emirates_govt;
	}
	public void setR0220_non_comm_entity_emirates_govt(BigDecimal r0220_non_comm_entity_emirates_govt) {
		this.r0220_non_comm_entity_emirates_govt = r0220_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0220_gre() {
		return r0220_gre;
	}
	public void setR0220_gre(BigDecimal r0220_gre) {
		this.r0220_gre = r0220_gre;
	}
	public BigDecimal getR0220_private_sector_gre() {
		return r0220_private_sector_gre;
	}
	public void setR0220_private_sector_gre(BigDecimal r0220_private_sector_gre) {
		this.r0220_private_sector_gre = r0220_private_sector_gre;
	}
	public BigDecimal getR0220_private_sector_banks() {
		return r0220_private_sector_banks;
	}
	public void setR0220_private_sector_banks(BigDecimal r0220_private_sector_banks) {
		this.r0220_private_sector_banks = r0220_private_sector_banks;
	}
	public BigDecimal getR0220_private_sector_financial_institutions() {
		return r0220_private_sector_financial_institutions;
	}
	public void setR0220_private_sector_financial_institutions(BigDecimal r0220_private_sector_financial_institutions) {
		this.r0220_private_sector_financial_institutions = r0220_private_sector_financial_institutions;
	}
	public BigDecimal getR0220_private_sector_other_private_entities() {
		return r0220_private_sector_other_private_entities;
	}
	public void setR0220_private_sector_other_private_entities(BigDecimal r0220_private_sector_other_private_entities) {
		this.r0220_private_sector_other_private_entities = r0220_private_sector_other_private_entities;
	}
	public BigDecimal getR0220_total_amount() {
		return r0220_total_amount;
	}
	public void setR0220_total_amount(BigDecimal r0220_total_amount) {
		this.r0220_total_amount = r0220_total_amount;
	}
	public String getR0230_product() {
		return r0230_product;
	}
	public void setR0230_product(String r0230_product) {
		this.r0230_product = r0230_product;
	}
	public BigDecimal getR0230_fedaral_govt() {
		return r0230_fedaral_govt;
	}
	public void setR0230_fedaral_govt(BigDecimal r0230_fedaral_govt) {
		this.r0230_fedaral_govt = r0230_fedaral_govt;
	}
	public BigDecimal getR0230_non_comm_entity_fed_govt() {
		return r0230_non_comm_entity_fed_govt;
	}
	public void setR0230_non_comm_entity_fed_govt(BigDecimal r0230_non_comm_entity_fed_govt) {
		this.r0230_non_comm_entity_fed_govt = r0230_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0230_local_govt() {
		return r0230_local_govt;
	}
	public void setR0230_local_govt(BigDecimal r0230_local_govt) {
		this.r0230_local_govt = r0230_local_govt;
	}
	public BigDecimal getR0230_non_comm_entity_emirates_govt() {
		return r0230_non_comm_entity_emirates_govt;
	}
	public void setR0230_non_comm_entity_emirates_govt(BigDecimal r0230_non_comm_entity_emirates_govt) {
		this.r0230_non_comm_entity_emirates_govt = r0230_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0230_gre() {
		return r0230_gre;
	}
	public void setR0230_gre(BigDecimal r0230_gre) {
		this.r0230_gre = r0230_gre;
	}
	public BigDecimal getR0230_private_sector_gre() {
		return r0230_private_sector_gre;
	}
	public void setR0230_private_sector_gre(BigDecimal r0230_private_sector_gre) {
		this.r0230_private_sector_gre = r0230_private_sector_gre;
	}
	public BigDecimal getR0230_private_sector_banks() {
		return r0230_private_sector_banks;
	}
	public void setR0230_private_sector_banks(BigDecimal r0230_private_sector_banks) {
		this.r0230_private_sector_banks = r0230_private_sector_banks;
	}
	public BigDecimal getR0230_private_sector_financial_institutions() {
		return r0230_private_sector_financial_institutions;
	}
	public void setR0230_private_sector_financial_institutions(BigDecimal r0230_private_sector_financial_institutions) {
		this.r0230_private_sector_financial_institutions = r0230_private_sector_financial_institutions;
	}
	public BigDecimal getR0230_private_sector_other_private_entities() {
		return r0230_private_sector_other_private_entities;
	}
	public void setR0230_private_sector_other_private_entities(BigDecimal r0230_private_sector_other_private_entities) {
		this.r0230_private_sector_other_private_entities = r0230_private_sector_other_private_entities;
	}
	public BigDecimal getR0230_total_amount() {
		return r0230_total_amount;
	}
	public void setR0230_total_amount(BigDecimal r0230_total_amount) {
		this.r0230_total_amount = r0230_total_amount;
	}
	public String getR0240_product() {
		return r0240_product;
	}
	public void setR0240_product(String r0240_product) {
		this.r0240_product = r0240_product;
	}
	public BigDecimal getR0240_fedaral_govt() {
		return r0240_fedaral_govt;
	}
	public void setR0240_fedaral_govt(BigDecimal r0240_fedaral_govt) {
		this.r0240_fedaral_govt = r0240_fedaral_govt;
	}
	public BigDecimal getR0240_non_comm_entity_fed_govt() {
		return r0240_non_comm_entity_fed_govt;
	}
	public void setR0240_non_comm_entity_fed_govt(BigDecimal r0240_non_comm_entity_fed_govt) {
		this.r0240_non_comm_entity_fed_govt = r0240_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0240_local_govt() {
		return r0240_local_govt;
	}
	public void setR0240_local_govt(BigDecimal r0240_local_govt) {
		this.r0240_local_govt = r0240_local_govt;
	}
	public BigDecimal getR0240_non_comm_entity_emirates_govt() {
		return r0240_non_comm_entity_emirates_govt;
	}
	public void setR0240_non_comm_entity_emirates_govt(BigDecimal r0240_non_comm_entity_emirates_govt) {
		this.r0240_non_comm_entity_emirates_govt = r0240_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0240_gre() {
		return r0240_gre;
	}
	public void setR0240_gre(BigDecimal r0240_gre) {
		this.r0240_gre = r0240_gre;
	}
	public BigDecimal getR0240_private_sector_gre() {
		return r0240_private_sector_gre;
	}
	public void setR0240_private_sector_gre(BigDecimal r0240_private_sector_gre) {
		this.r0240_private_sector_gre = r0240_private_sector_gre;
	}
	public BigDecimal getR0240_private_sector_banks() {
		return r0240_private_sector_banks;
	}
	public void setR0240_private_sector_banks(BigDecimal r0240_private_sector_banks) {
		this.r0240_private_sector_banks = r0240_private_sector_banks;
	}
	public BigDecimal getR0240_private_sector_financial_institutions() {
		return r0240_private_sector_financial_institutions;
	}
	public void setR0240_private_sector_financial_institutions(BigDecimal r0240_private_sector_financial_institutions) {
		this.r0240_private_sector_financial_institutions = r0240_private_sector_financial_institutions;
	}
	public BigDecimal getR0240_private_sector_other_private_entities() {
		return r0240_private_sector_other_private_entities;
	}
	public void setR0240_private_sector_other_private_entities(BigDecimal r0240_private_sector_other_private_entities) {
		this.r0240_private_sector_other_private_entities = r0240_private_sector_other_private_entities;
	}
	public BigDecimal getR0240_total_amount() {
		return r0240_total_amount;
	}
	public void setR0240_total_amount(BigDecimal r0240_total_amount) {
		this.r0240_total_amount = r0240_total_amount;
	}
	public String getR0250_product() {
		return r0250_product;
	}
	public void setR0250_product(String r0250_product) {
		this.r0250_product = r0250_product;
	}
	public BigDecimal getR0250_fedaral_govt() {
		return r0250_fedaral_govt;
	}
	public void setR0250_fedaral_govt(BigDecimal r0250_fedaral_govt) {
		this.r0250_fedaral_govt = r0250_fedaral_govt;
	}
	public BigDecimal getR0250_non_comm_entity_fed_govt() {
		return r0250_non_comm_entity_fed_govt;
	}
	public void setR0250_non_comm_entity_fed_govt(BigDecimal r0250_non_comm_entity_fed_govt) {
		this.r0250_non_comm_entity_fed_govt = r0250_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0250_local_govt() {
		return r0250_local_govt;
	}
	public void setR0250_local_govt(BigDecimal r0250_local_govt) {
		this.r0250_local_govt = r0250_local_govt;
	}
	public BigDecimal getR0250_non_comm_entity_emirates_govt() {
		return r0250_non_comm_entity_emirates_govt;
	}
	public void setR0250_non_comm_entity_emirates_govt(BigDecimal r0250_non_comm_entity_emirates_govt) {
		this.r0250_non_comm_entity_emirates_govt = r0250_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0250_gre() {
		return r0250_gre;
	}
	public void setR0250_gre(BigDecimal r0250_gre) {
		this.r0250_gre = r0250_gre;
	}
	public BigDecimal getR0250_private_sector_gre() {
		return r0250_private_sector_gre;
	}
	public void setR0250_private_sector_gre(BigDecimal r0250_private_sector_gre) {
		this.r0250_private_sector_gre = r0250_private_sector_gre;
	}
	public BigDecimal getR0250_private_sector_banks() {
		return r0250_private_sector_banks;
	}
	public void setR0250_private_sector_banks(BigDecimal r0250_private_sector_banks) {
		this.r0250_private_sector_banks = r0250_private_sector_banks;
	}
	public BigDecimal getR0250_private_sector_financial_institutions() {
		return r0250_private_sector_financial_institutions;
	}
	public void setR0250_private_sector_financial_institutions(BigDecimal r0250_private_sector_financial_institutions) {
		this.r0250_private_sector_financial_institutions = r0250_private_sector_financial_institutions;
	}
	public BigDecimal getR0250_private_sector_other_private_entities() {
		return r0250_private_sector_other_private_entities;
	}
	public void setR0250_private_sector_other_private_entities(BigDecimal r0250_private_sector_other_private_entities) {
		this.r0250_private_sector_other_private_entities = r0250_private_sector_other_private_entities;
	}
	public BigDecimal getR0250_total_amount() {
		return r0250_total_amount;
	}
	public void setR0250_total_amount(BigDecimal r0250_total_amount) {
		this.r0250_total_amount = r0250_total_amount;
	}
	public String getR0260_product() {
		return r0260_product;
	}
	public void setR0260_product(String r0260_product) {
		this.r0260_product = r0260_product;
	}
	public BigDecimal getR0260_fedaral_govt() {
		return r0260_fedaral_govt;
	}
	public void setR0260_fedaral_govt(BigDecimal r0260_fedaral_govt) {
		this.r0260_fedaral_govt = r0260_fedaral_govt;
	}
	public BigDecimal getR0260_non_comm_entity_fed_govt() {
		return r0260_non_comm_entity_fed_govt;
	}
	public void setR0260_non_comm_entity_fed_govt(BigDecimal r0260_non_comm_entity_fed_govt) {
		this.r0260_non_comm_entity_fed_govt = r0260_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0260_local_govt() {
		return r0260_local_govt;
	}
	public void setR0260_local_govt(BigDecimal r0260_local_govt) {
		this.r0260_local_govt = r0260_local_govt;
	}
	public BigDecimal getR0260_non_comm_entity_emirates_govt() {
		return r0260_non_comm_entity_emirates_govt;
	}
	public void setR0260_non_comm_entity_emirates_govt(BigDecimal r0260_non_comm_entity_emirates_govt) {
		this.r0260_non_comm_entity_emirates_govt = r0260_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0260_gre() {
		return r0260_gre;
	}
	public void setR0260_gre(BigDecimal r0260_gre) {
		this.r0260_gre = r0260_gre;
	}
	public BigDecimal getR0260_private_sector_gre() {
		return r0260_private_sector_gre;
	}
	public void setR0260_private_sector_gre(BigDecimal r0260_private_sector_gre) {
		this.r0260_private_sector_gre = r0260_private_sector_gre;
	}
	public BigDecimal getR0260_private_sector_banks() {
		return r0260_private_sector_banks;
	}
	public void setR0260_private_sector_banks(BigDecimal r0260_private_sector_banks) {
		this.r0260_private_sector_banks = r0260_private_sector_banks;
	}
	public BigDecimal getR0260_private_sector_financial_institutions() {
		return r0260_private_sector_financial_institutions;
	}
	public void setR0260_private_sector_financial_institutions(BigDecimal r0260_private_sector_financial_institutions) {
		this.r0260_private_sector_financial_institutions = r0260_private_sector_financial_institutions;
	}
	public BigDecimal getR0260_private_sector_other_private_entities() {
		return r0260_private_sector_other_private_entities;
	}
	public void setR0260_private_sector_other_private_entities(BigDecimal r0260_private_sector_other_private_entities) {
		this.r0260_private_sector_other_private_entities = r0260_private_sector_other_private_entities;
	}
	public BigDecimal getR0260_total_amount() {
		return r0260_total_amount;
	}
	public void setR0260_total_amount(BigDecimal r0260_total_amount) {
		this.r0260_total_amount = r0260_total_amount;
	}
	public String getR0270_product() {
		return r0270_product;
	}
	public void setR0270_product(String r0270_product) {
		this.r0270_product = r0270_product;
	}
	public BigDecimal getR0270_fedaral_govt() {
		return r0270_fedaral_govt;
	}
	public void setR0270_fedaral_govt(BigDecimal r0270_fedaral_govt) {
		this.r0270_fedaral_govt = r0270_fedaral_govt;
	}
	public BigDecimal getR0270_non_comm_entity_fed_govt() {
		return r0270_non_comm_entity_fed_govt;
	}
	public void setR0270_non_comm_entity_fed_govt(BigDecimal r0270_non_comm_entity_fed_govt) {
		this.r0270_non_comm_entity_fed_govt = r0270_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0270_local_govt() {
		return r0270_local_govt;
	}
	public void setR0270_local_govt(BigDecimal r0270_local_govt) {
		this.r0270_local_govt = r0270_local_govt;
	}
	public BigDecimal getR0270_non_comm_entity_emirates_govt() {
		return r0270_non_comm_entity_emirates_govt;
	}
	public void setR0270_non_comm_entity_emirates_govt(BigDecimal r0270_non_comm_entity_emirates_govt) {
		this.r0270_non_comm_entity_emirates_govt = r0270_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0270_gre() {
		return r0270_gre;
	}
	public void setR0270_gre(BigDecimal r0270_gre) {
		this.r0270_gre = r0270_gre;
	}
	public BigDecimal getR0270_private_sector_gre() {
		return r0270_private_sector_gre;
	}
	public void setR0270_private_sector_gre(BigDecimal r0270_private_sector_gre) {
		this.r0270_private_sector_gre = r0270_private_sector_gre;
	}
	public BigDecimal getR0270_private_sector_banks() {
		return r0270_private_sector_banks;
	}
	public void setR0270_private_sector_banks(BigDecimal r0270_private_sector_banks) {
		this.r0270_private_sector_banks = r0270_private_sector_banks;
	}
	public BigDecimal getR0270_private_sector_financial_institutions() {
		return r0270_private_sector_financial_institutions;
	}
	public void setR0270_private_sector_financial_institutions(BigDecimal r0270_private_sector_financial_institutions) {
		this.r0270_private_sector_financial_institutions = r0270_private_sector_financial_institutions;
	}
	public BigDecimal getR0270_private_sector_other_private_entities() {
		return r0270_private_sector_other_private_entities;
	}
	public void setR0270_private_sector_other_private_entities(BigDecimal r0270_private_sector_other_private_entities) {
		this.r0270_private_sector_other_private_entities = r0270_private_sector_other_private_entities;
	}
	public BigDecimal getR0270_total_amount() {
		return r0270_total_amount;
	}
	public void setR0270_total_amount(BigDecimal r0270_total_amount) {
		this.r0270_total_amount = r0270_total_amount;
	}
	public String getR0280_product() {
		return r0280_product;
	}
	public void setR0280_product(String r0280_product) {
		this.r0280_product = r0280_product;
	}
	public BigDecimal getR0280_fedaral_govt() {
		return r0280_fedaral_govt;
	}
	public void setR0280_fedaral_govt(BigDecimal r0280_fedaral_govt) {
		this.r0280_fedaral_govt = r0280_fedaral_govt;
	}
	public BigDecimal getR0280_non_comm_entity_fed_govt() {
		return r0280_non_comm_entity_fed_govt;
	}
	public void setR0280_non_comm_entity_fed_govt(BigDecimal r0280_non_comm_entity_fed_govt) {
		this.r0280_non_comm_entity_fed_govt = r0280_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0280_local_govt() {
		return r0280_local_govt;
	}
	public void setR0280_local_govt(BigDecimal r0280_local_govt) {
		this.r0280_local_govt = r0280_local_govt;
	}
	public BigDecimal getR0280_non_comm_entity_emirates_govt() {
		return r0280_non_comm_entity_emirates_govt;
	}
	public void setR0280_non_comm_entity_emirates_govt(BigDecimal r0280_non_comm_entity_emirates_govt) {
		this.r0280_non_comm_entity_emirates_govt = r0280_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0280_gre() {
		return r0280_gre;
	}
	public void setR0280_gre(BigDecimal r0280_gre) {
		this.r0280_gre = r0280_gre;
	}
	public BigDecimal getR0280_private_sector_gre() {
		return r0280_private_sector_gre;
	}
	public void setR0280_private_sector_gre(BigDecimal r0280_private_sector_gre) {
		this.r0280_private_sector_gre = r0280_private_sector_gre;
	}
	public BigDecimal getR0280_private_sector_banks() {
		return r0280_private_sector_banks;
	}
	public void setR0280_private_sector_banks(BigDecimal r0280_private_sector_banks) {
		this.r0280_private_sector_banks = r0280_private_sector_banks;
	}
	public BigDecimal getR0280_private_sector_financial_institutions() {
		return r0280_private_sector_financial_institutions;
	}
	public void setR0280_private_sector_financial_institutions(BigDecimal r0280_private_sector_financial_institutions) {
		this.r0280_private_sector_financial_institutions = r0280_private_sector_financial_institutions;
	}
	public BigDecimal getR0280_private_sector_other_private_entities() {
		return r0280_private_sector_other_private_entities;
	}
	public void setR0280_private_sector_other_private_entities(BigDecimal r0280_private_sector_other_private_entities) {
		this.r0280_private_sector_other_private_entities = r0280_private_sector_other_private_entities;
	}
	public BigDecimal getR0280_total_amount() {
		return r0280_total_amount;
	}
	public void setR0280_total_amount(BigDecimal r0280_total_amount) {
		this.r0280_total_amount = r0280_total_amount;
	}
	public String getR0290_product() {
		return r0290_product;
	}
	public void setR0290_product(String r0290_product) {
		this.r0290_product = r0290_product;
	}
	public BigDecimal getR0290_fedaral_govt() {
		return r0290_fedaral_govt;
	}
	public void setR0290_fedaral_govt(BigDecimal r0290_fedaral_govt) {
		this.r0290_fedaral_govt = r0290_fedaral_govt;
	}
	public BigDecimal getR0290_non_comm_entity_fed_govt() {
		return r0290_non_comm_entity_fed_govt;
	}
	public void setR0290_non_comm_entity_fed_govt(BigDecimal r0290_non_comm_entity_fed_govt) {
		this.r0290_non_comm_entity_fed_govt = r0290_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0290_local_govt() {
		return r0290_local_govt;
	}
	public void setR0290_local_govt(BigDecimal r0290_local_govt) {
		this.r0290_local_govt = r0290_local_govt;
	}
	public BigDecimal getR0290_non_comm_entity_emirates_govt() {
		return r0290_non_comm_entity_emirates_govt;
	}
	public void setR0290_non_comm_entity_emirates_govt(BigDecimal r0290_non_comm_entity_emirates_govt) {
		this.r0290_non_comm_entity_emirates_govt = r0290_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0290_gre() {
		return r0290_gre;
	}
	public void setR0290_gre(BigDecimal r0290_gre) {
		this.r0290_gre = r0290_gre;
	}
	public BigDecimal getR0290_private_sector_gre() {
		return r0290_private_sector_gre;
	}
	public void setR0290_private_sector_gre(BigDecimal r0290_private_sector_gre) {
		this.r0290_private_sector_gre = r0290_private_sector_gre;
	}
	public BigDecimal getR0290_private_sector_banks() {
		return r0290_private_sector_banks;
	}
	public void setR0290_private_sector_banks(BigDecimal r0290_private_sector_banks) {
		this.r0290_private_sector_banks = r0290_private_sector_banks;
	}
	public BigDecimal getR0290_private_sector_financial_institutions() {
		return r0290_private_sector_financial_institutions;
	}
	public void setR0290_private_sector_financial_institutions(BigDecimal r0290_private_sector_financial_institutions) {
		this.r0290_private_sector_financial_institutions = r0290_private_sector_financial_institutions;
	}
	public BigDecimal getR0290_private_sector_other_private_entities() {
		return r0290_private_sector_other_private_entities;
	}
	public void setR0290_private_sector_other_private_entities(BigDecimal r0290_private_sector_other_private_entities) {
		this.r0290_private_sector_other_private_entities = r0290_private_sector_other_private_entities;
	}
	public BigDecimal getR0290_total_amount() {
		return r0290_total_amount;
	}
	public void setR0290_total_amount(BigDecimal r0290_total_amount) {
		this.r0290_total_amount = r0290_total_amount;
	}
	public String getR0300_product() {
		return r0300_product;
	}
	public void setR0300_product(String r0300_product) {
		this.r0300_product = r0300_product;
	}
	public BigDecimal getR0300_fedaral_govt() {
		return r0300_fedaral_govt;
	}
	public void setR0300_fedaral_govt(BigDecimal r0300_fedaral_govt) {
		this.r0300_fedaral_govt = r0300_fedaral_govt;
	}
	public BigDecimal getR0300_non_comm_entity_fed_govt() {
		return r0300_non_comm_entity_fed_govt;
	}
	public void setR0300_non_comm_entity_fed_govt(BigDecimal r0300_non_comm_entity_fed_govt) {
		this.r0300_non_comm_entity_fed_govt = r0300_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0300_local_govt() {
		return r0300_local_govt;
	}
	public void setR0300_local_govt(BigDecimal r0300_local_govt) {
		this.r0300_local_govt = r0300_local_govt;
	}
	public BigDecimal getR0300_non_comm_entity_emirates_govt() {
		return r0300_non_comm_entity_emirates_govt;
	}
	public void setR0300_non_comm_entity_emirates_govt(BigDecimal r0300_non_comm_entity_emirates_govt) {
		this.r0300_non_comm_entity_emirates_govt = r0300_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0300_gre() {
		return r0300_gre;
	}
	public void setR0300_gre(BigDecimal r0300_gre) {
		this.r0300_gre = r0300_gre;
	}
	public BigDecimal getR0300_private_sector_gre() {
		return r0300_private_sector_gre;
	}
	public void setR0300_private_sector_gre(BigDecimal r0300_private_sector_gre) {
		this.r0300_private_sector_gre = r0300_private_sector_gre;
	}
	public BigDecimal getR0300_private_sector_banks() {
		return r0300_private_sector_banks;
	}
	public void setR0300_private_sector_banks(BigDecimal r0300_private_sector_banks) {
		this.r0300_private_sector_banks = r0300_private_sector_banks;
	}
	public BigDecimal getR0300_private_sector_financial_institutions() {
		return r0300_private_sector_financial_institutions;
	}
	public void setR0300_private_sector_financial_institutions(BigDecimal r0300_private_sector_financial_institutions) {
		this.r0300_private_sector_financial_institutions = r0300_private_sector_financial_institutions;
	}
	public BigDecimal getR0300_private_sector_other_private_entities() {
		return r0300_private_sector_other_private_entities;
	}
	public void setR0300_private_sector_other_private_entities(BigDecimal r0300_private_sector_other_private_entities) {
		this.r0300_private_sector_other_private_entities = r0300_private_sector_other_private_entities;
	}
	public BigDecimal getR0300_total_amount() {
		return r0300_total_amount;
	}
	public void setR0300_total_amount(BigDecimal r0300_total_amount) {
		this.r0300_total_amount = r0300_total_amount;
	}
	public String getR0310_product() {
		return r0310_product;
	}
	public void setR0310_product(String r0310_product) {
		this.r0310_product = r0310_product;
	}
	public BigDecimal getR0310_fedaral_govt() {
		return r0310_fedaral_govt;
	}
	public void setR0310_fedaral_govt(BigDecimal r0310_fedaral_govt) {
		this.r0310_fedaral_govt = r0310_fedaral_govt;
	}
	public BigDecimal getR0310_non_comm_entity_fed_govt() {
		return r0310_non_comm_entity_fed_govt;
	}
	public void setR0310_non_comm_entity_fed_govt(BigDecimal r0310_non_comm_entity_fed_govt) {
		this.r0310_non_comm_entity_fed_govt = r0310_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0310_local_govt() {
		return r0310_local_govt;
	}
	public void setR0310_local_govt(BigDecimal r0310_local_govt) {
		this.r0310_local_govt = r0310_local_govt;
	}
	public BigDecimal getR0310_non_comm_entity_emirates_govt() {
		return r0310_non_comm_entity_emirates_govt;
	}
	public void setR0310_non_comm_entity_emirates_govt(BigDecimal r0310_non_comm_entity_emirates_govt) {
		this.r0310_non_comm_entity_emirates_govt = r0310_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0310_gre() {
		return r0310_gre;
	}
	public void setR0310_gre(BigDecimal r0310_gre) {
		this.r0310_gre = r0310_gre;
	}
	public BigDecimal getR0310_private_sector_gre() {
		return r0310_private_sector_gre;
	}
	public void setR0310_private_sector_gre(BigDecimal r0310_private_sector_gre) {
		this.r0310_private_sector_gre = r0310_private_sector_gre;
	}
	public BigDecimal getR0310_private_sector_banks() {
		return r0310_private_sector_banks;
	}
	public void setR0310_private_sector_banks(BigDecimal r0310_private_sector_banks) {
		this.r0310_private_sector_banks = r0310_private_sector_banks;
	}
	public BigDecimal getR0310_private_sector_financial_institutions() {
		return r0310_private_sector_financial_institutions;
	}
	public void setR0310_private_sector_financial_institutions(BigDecimal r0310_private_sector_financial_institutions) {
		this.r0310_private_sector_financial_institutions = r0310_private_sector_financial_institutions;
	}
	public BigDecimal getR0310_private_sector_other_private_entities() {
		return r0310_private_sector_other_private_entities;
	}
	public void setR0310_private_sector_other_private_entities(BigDecimal r0310_private_sector_other_private_entities) {
		this.r0310_private_sector_other_private_entities = r0310_private_sector_other_private_entities;
	}
	public BigDecimal getR0310_total_amount() {
		return r0310_total_amount;
	}
	public void setR0310_total_amount(BigDecimal r0310_total_amount) {
		this.r0310_total_amount = r0310_total_amount;
	}
	public String getR0320_product() {
		return r0320_product;
	}
	public void setR0320_product(String r0320_product) {
		this.r0320_product = r0320_product;
	}
	public BigDecimal getR0320_fedaral_govt() {
		return r0320_fedaral_govt;
	}
	public void setR0320_fedaral_govt(BigDecimal r0320_fedaral_govt) {
		this.r0320_fedaral_govt = r0320_fedaral_govt;
	}
	public BigDecimal getR0320_non_comm_entity_fed_govt() {
		return r0320_non_comm_entity_fed_govt;
	}
	public void setR0320_non_comm_entity_fed_govt(BigDecimal r0320_non_comm_entity_fed_govt) {
		this.r0320_non_comm_entity_fed_govt = r0320_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0320_local_govt() {
		return r0320_local_govt;
	}
	public void setR0320_local_govt(BigDecimal r0320_local_govt) {
		this.r0320_local_govt = r0320_local_govt;
	}
	public BigDecimal getR0320_non_comm_entity_emirates_govt() {
		return r0320_non_comm_entity_emirates_govt;
	}
	public void setR0320_non_comm_entity_emirates_govt(BigDecimal r0320_non_comm_entity_emirates_govt) {
		this.r0320_non_comm_entity_emirates_govt = r0320_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0320_gre() {
		return r0320_gre;
	}
	public void setR0320_gre(BigDecimal r0320_gre) {
		this.r0320_gre = r0320_gre;
	}
	public BigDecimal getR0320_private_sector_gre() {
		return r0320_private_sector_gre;
	}
	public void setR0320_private_sector_gre(BigDecimal r0320_private_sector_gre) {
		this.r0320_private_sector_gre = r0320_private_sector_gre;
	}
	public BigDecimal getR0320_private_sector_banks() {
		return r0320_private_sector_banks;
	}
	public void setR0320_private_sector_banks(BigDecimal r0320_private_sector_banks) {
		this.r0320_private_sector_banks = r0320_private_sector_banks;
	}
	public BigDecimal getR0320_private_sector_financial_institutions() {
		return r0320_private_sector_financial_institutions;
	}
	public void setR0320_private_sector_financial_institutions(BigDecimal r0320_private_sector_financial_institutions) {
		this.r0320_private_sector_financial_institutions = r0320_private_sector_financial_institutions;
	}
	public BigDecimal getR0320_private_sector_other_private_entities() {
		return r0320_private_sector_other_private_entities;
	}
	public void setR0320_private_sector_other_private_entities(BigDecimal r0320_private_sector_other_private_entities) {
		this.r0320_private_sector_other_private_entities = r0320_private_sector_other_private_entities;
	}
	public BigDecimal getR0320_total_amount() {
		return r0320_total_amount;
	}
	public void setR0320_total_amount(BigDecimal r0320_total_amount) {
		this.r0320_total_amount = r0320_total_amount;
	}
	public String getR0330_product() {
		return r0330_product;
	}
	public void setR0330_product(String r0330_product) {
		this.r0330_product = r0330_product;
	}
	public BigDecimal getR0330_fedaral_govt() {
		return r0330_fedaral_govt;
	}
	public void setR0330_fedaral_govt(BigDecimal r0330_fedaral_govt) {
		this.r0330_fedaral_govt = r0330_fedaral_govt;
	}
	public BigDecimal getR0330_non_comm_entity_fed_govt() {
		return r0330_non_comm_entity_fed_govt;
	}
	public void setR0330_non_comm_entity_fed_govt(BigDecimal r0330_non_comm_entity_fed_govt) {
		this.r0330_non_comm_entity_fed_govt = r0330_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0330_local_govt() {
		return r0330_local_govt;
	}
	public void setR0330_local_govt(BigDecimal r0330_local_govt) {
		this.r0330_local_govt = r0330_local_govt;
	}
	public BigDecimal getR0330_non_comm_entity_emirates_govt() {
		return r0330_non_comm_entity_emirates_govt;
	}
	public void setR0330_non_comm_entity_emirates_govt(BigDecimal r0330_non_comm_entity_emirates_govt) {
		this.r0330_non_comm_entity_emirates_govt = r0330_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0330_gre() {
		return r0330_gre;
	}
	public void setR0330_gre(BigDecimal r0330_gre) {
		this.r0330_gre = r0330_gre;
	}
	public BigDecimal getR0330_private_sector_gre() {
		return r0330_private_sector_gre;
	}
	public void setR0330_private_sector_gre(BigDecimal r0330_private_sector_gre) {
		this.r0330_private_sector_gre = r0330_private_sector_gre;
	}
	public BigDecimal getR0330_private_sector_banks() {
		return r0330_private_sector_banks;
	}
	public void setR0330_private_sector_banks(BigDecimal r0330_private_sector_banks) {
		this.r0330_private_sector_banks = r0330_private_sector_banks;
	}
	public BigDecimal getR0330_private_sector_financial_institutions() {
		return r0330_private_sector_financial_institutions;
	}
	public void setR0330_private_sector_financial_institutions(BigDecimal r0330_private_sector_financial_institutions) {
		this.r0330_private_sector_financial_institutions = r0330_private_sector_financial_institutions;
	}
	public BigDecimal getR0330_private_sector_other_private_entities() {
		return r0330_private_sector_other_private_entities;
	}
	public void setR0330_private_sector_other_private_entities(BigDecimal r0330_private_sector_other_private_entities) {
		this.r0330_private_sector_other_private_entities = r0330_private_sector_other_private_entities;
	}
	public BigDecimal getR0330_total_amount() {
		return r0330_total_amount;
	}
	public void setR0330_total_amount(BigDecimal r0330_total_amount) {
		this.r0330_total_amount = r0330_total_amount;
	}
	public String getR0340_product() {
		return r0340_product;
	}
	public void setR0340_product(String r0340_product) {
		this.r0340_product = r0340_product;
	}
	public BigDecimal getR0340_fedaral_govt() {
		return r0340_fedaral_govt;
	}
	public void setR0340_fedaral_govt(BigDecimal r0340_fedaral_govt) {
		this.r0340_fedaral_govt = r0340_fedaral_govt;
	}
	public BigDecimal getR0340_non_comm_entity_fed_govt() {
		return r0340_non_comm_entity_fed_govt;
	}
	public void setR0340_non_comm_entity_fed_govt(BigDecimal r0340_non_comm_entity_fed_govt) {
		this.r0340_non_comm_entity_fed_govt = r0340_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0340_local_govt() {
		return r0340_local_govt;
	}
	public void setR0340_local_govt(BigDecimal r0340_local_govt) {
		this.r0340_local_govt = r0340_local_govt;
	}
	public BigDecimal getR0340_non_comm_entity_emirates_govt() {
		return r0340_non_comm_entity_emirates_govt;
	}
	public void setR0340_non_comm_entity_emirates_govt(BigDecimal r0340_non_comm_entity_emirates_govt) {
		this.r0340_non_comm_entity_emirates_govt = r0340_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0340_gre() {
		return r0340_gre;
	}
	public void setR0340_gre(BigDecimal r0340_gre) {
		this.r0340_gre = r0340_gre;
	}
	public BigDecimal getR0340_private_sector_gre() {
		return r0340_private_sector_gre;
	}
	public void setR0340_private_sector_gre(BigDecimal r0340_private_sector_gre) {
		this.r0340_private_sector_gre = r0340_private_sector_gre;
	}
	public BigDecimal getR0340_private_sector_banks() {
		return r0340_private_sector_banks;
	}
	public void setR0340_private_sector_banks(BigDecimal r0340_private_sector_banks) {
		this.r0340_private_sector_banks = r0340_private_sector_banks;
	}
	public BigDecimal getR0340_private_sector_financial_institutions() {
		return r0340_private_sector_financial_institutions;
	}
	public void setR0340_private_sector_financial_institutions(BigDecimal r0340_private_sector_financial_institutions) {
		this.r0340_private_sector_financial_institutions = r0340_private_sector_financial_institutions;
	}
	public BigDecimal getR0340_private_sector_other_private_entities() {
		return r0340_private_sector_other_private_entities;
	}
	public void setR0340_private_sector_other_private_entities(BigDecimal r0340_private_sector_other_private_entities) {
		this.r0340_private_sector_other_private_entities = r0340_private_sector_other_private_entities;
	}
	public BigDecimal getR0340_total_amount() {
		return r0340_total_amount;
	}
	public void setR0340_total_amount(BigDecimal r0340_total_amount) {
		this.r0340_total_amount = r0340_total_amount;
	}
	public String getR0350_product() {
		return r0350_product;
	}
	public void setR0350_product(String r0350_product) {
		this.r0350_product = r0350_product;
	}
	public BigDecimal getR0350_fedaral_govt() {
		return r0350_fedaral_govt;
	}
	public void setR0350_fedaral_govt(BigDecimal r0350_fedaral_govt) {
		this.r0350_fedaral_govt = r0350_fedaral_govt;
	}
	public BigDecimal getR0350_non_comm_entity_fed_govt() {
		return r0350_non_comm_entity_fed_govt;
	}
	public void setR0350_non_comm_entity_fed_govt(BigDecimal r0350_non_comm_entity_fed_govt) {
		this.r0350_non_comm_entity_fed_govt = r0350_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0350_local_govt() {
		return r0350_local_govt;
	}
	public void setR0350_local_govt(BigDecimal r0350_local_govt) {
		this.r0350_local_govt = r0350_local_govt;
	}
	public BigDecimal getR0350_non_comm_entity_emirates_govt() {
		return r0350_non_comm_entity_emirates_govt;
	}
	public void setR0350_non_comm_entity_emirates_govt(BigDecimal r0350_non_comm_entity_emirates_govt) {
		this.r0350_non_comm_entity_emirates_govt = r0350_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0350_gre() {
		return r0350_gre;
	}
	public void setR0350_gre(BigDecimal r0350_gre) {
		this.r0350_gre = r0350_gre;
	}
	public BigDecimal getR0350_private_sector_gre() {
		return r0350_private_sector_gre;
	}
	public void setR0350_private_sector_gre(BigDecimal r0350_private_sector_gre) {
		this.r0350_private_sector_gre = r0350_private_sector_gre;
	}
	public BigDecimal getR0350_private_sector_banks() {
		return r0350_private_sector_banks;
	}
	public void setR0350_private_sector_banks(BigDecimal r0350_private_sector_banks) {
		this.r0350_private_sector_banks = r0350_private_sector_banks;
	}
	public BigDecimal getR0350_private_sector_financial_institutions() {
		return r0350_private_sector_financial_institutions;
	}
	public void setR0350_private_sector_financial_institutions(BigDecimal r0350_private_sector_financial_institutions) {
		this.r0350_private_sector_financial_institutions = r0350_private_sector_financial_institutions;
	}
	public BigDecimal getR0350_private_sector_other_private_entities() {
		return r0350_private_sector_other_private_entities;
	}
	public void setR0350_private_sector_other_private_entities(BigDecimal r0350_private_sector_other_private_entities) {
		this.r0350_private_sector_other_private_entities = r0350_private_sector_other_private_entities;
	}
	public BigDecimal getR0350_total_amount() {
		return r0350_total_amount;
	}
	public void setR0350_total_amount(BigDecimal r0350_total_amount) {
		this.r0350_total_amount = r0350_total_amount;
	}
	public String getR0360_product() {
		return r0360_product;
	}
	public void setR0360_product(String r0360_product) {
		this.r0360_product = r0360_product;
	}
	public BigDecimal getR0360_fedaral_govt() {
		return r0360_fedaral_govt;
	}
	public void setR0360_fedaral_govt(BigDecimal r0360_fedaral_govt) {
		this.r0360_fedaral_govt = r0360_fedaral_govt;
	}
	public BigDecimal getR0360_non_comm_entity_fed_govt() {
		return r0360_non_comm_entity_fed_govt;
	}
	public void setR0360_non_comm_entity_fed_govt(BigDecimal r0360_non_comm_entity_fed_govt) {
		this.r0360_non_comm_entity_fed_govt = r0360_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0360_local_govt() {
		return r0360_local_govt;
	}
	public void setR0360_local_govt(BigDecimal r0360_local_govt) {
		this.r0360_local_govt = r0360_local_govt;
	}
	public BigDecimal getR0360_non_comm_entity_emirates_govt() {
		return r0360_non_comm_entity_emirates_govt;
	}
	public void setR0360_non_comm_entity_emirates_govt(BigDecimal r0360_non_comm_entity_emirates_govt) {
		this.r0360_non_comm_entity_emirates_govt = r0360_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0360_gre() {
		return r0360_gre;
	}
	public void setR0360_gre(BigDecimal r0360_gre) {
		this.r0360_gre = r0360_gre;
	}
	public BigDecimal getR0360_private_sector_gre() {
		return r0360_private_sector_gre;
	}
	public void setR0360_private_sector_gre(BigDecimal r0360_private_sector_gre) {
		this.r0360_private_sector_gre = r0360_private_sector_gre;
	}
	public BigDecimal getR0360_private_sector_banks() {
		return r0360_private_sector_banks;
	}
	public void setR0360_private_sector_banks(BigDecimal r0360_private_sector_banks) {
		this.r0360_private_sector_banks = r0360_private_sector_banks;
	}
	public BigDecimal getR0360_private_sector_financial_institutions() {
		return r0360_private_sector_financial_institutions;
	}
	public void setR0360_private_sector_financial_institutions(BigDecimal r0360_private_sector_financial_institutions) {
		this.r0360_private_sector_financial_institutions = r0360_private_sector_financial_institutions;
	}
	public BigDecimal getR0360_private_sector_other_private_entities() {
		return r0360_private_sector_other_private_entities;
	}
	public void setR0360_private_sector_other_private_entities(BigDecimal r0360_private_sector_other_private_entities) {
		this.r0360_private_sector_other_private_entities = r0360_private_sector_other_private_entities;
	}
	public BigDecimal getR0360_total_amount() {
		return r0360_total_amount;
	}
	public void setR0360_total_amount(BigDecimal r0360_total_amount) {
		this.r0360_total_amount = r0360_total_amount;
	}
	public String getR0370_product() {
		return r0370_product;
	}
	public void setR0370_product(String r0370_product) {
		this.r0370_product = r0370_product;
	}
	public BigDecimal getR0370_fedaral_govt() {
		return r0370_fedaral_govt;
	}
	public void setR0370_fedaral_govt(BigDecimal r0370_fedaral_govt) {
		this.r0370_fedaral_govt = r0370_fedaral_govt;
	}
	public BigDecimal getR0370_non_comm_entity_fed_govt() {
		return r0370_non_comm_entity_fed_govt;
	}
	public void setR0370_non_comm_entity_fed_govt(BigDecimal r0370_non_comm_entity_fed_govt) {
		this.r0370_non_comm_entity_fed_govt = r0370_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0370_local_govt() {
		return r0370_local_govt;
	}
	public void setR0370_local_govt(BigDecimal r0370_local_govt) {
		this.r0370_local_govt = r0370_local_govt;
	}
	public BigDecimal getR0370_non_comm_entity_emirates_govt() {
		return r0370_non_comm_entity_emirates_govt;
	}
	public void setR0370_non_comm_entity_emirates_govt(BigDecimal r0370_non_comm_entity_emirates_govt) {
		this.r0370_non_comm_entity_emirates_govt = r0370_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0370_gre() {
		return r0370_gre;
	}
	public void setR0370_gre(BigDecimal r0370_gre) {
		this.r0370_gre = r0370_gre;
	}
	public BigDecimal getR0370_private_sector_gre() {
		return r0370_private_sector_gre;
	}
	public void setR0370_private_sector_gre(BigDecimal r0370_private_sector_gre) {
		this.r0370_private_sector_gre = r0370_private_sector_gre;
	}
	public BigDecimal getR0370_private_sector_banks() {
		return r0370_private_sector_banks;
	}
	public void setR0370_private_sector_banks(BigDecimal r0370_private_sector_banks) {
		this.r0370_private_sector_banks = r0370_private_sector_banks;
	}
	public BigDecimal getR0370_private_sector_financial_institutions() {
		return r0370_private_sector_financial_institutions;
	}
	public void setR0370_private_sector_financial_institutions(BigDecimal r0370_private_sector_financial_institutions) {
		this.r0370_private_sector_financial_institutions = r0370_private_sector_financial_institutions;
	}
	public BigDecimal getR0370_private_sector_other_private_entities() {
		return r0370_private_sector_other_private_entities;
	}
	public void setR0370_private_sector_other_private_entities(BigDecimal r0370_private_sector_other_private_entities) {
		this.r0370_private_sector_other_private_entities = r0370_private_sector_other_private_entities;
	}
	public BigDecimal getR0370_total_amount() {
		return r0370_total_amount;
	}
	public void setR0370_total_amount(BigDecimal r0370_total_amount) {
		this.r0370_total_amount = r0370_total_amount;
	}
	public String getR0380_product() {
		return r0380_product;
	}
	public void setR0380_product(String r0380_product) {
		this.r0380_product = r0380_product;
	}
	public BigDecimal getR0380_fedaral_govt() {
		return r0380_fedaral_govt;
	}
	public void setR0380_fedaral_govt(BigDecimal r0380_fedaral_govt) {
		this.r0380_fedaral_govt = r0380_fedaral_govt;
	}
	public BigDecimal getR0380_non_comm_entity_fed_govt() {
		return r0380_non_comm_entity_fed_govt;
	}
	public void setR0380_non_comm_entity_fed_govt(BigDecimal r0380_non_comm_entity_fed_govt) {
		this.r0380_non_comm_entity_fed_govt = r0380_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0380_local_govt() {
		return r0380_local_govt;
	}
	public void setR0380_local_govt(BigDecimal r0380_local_govt) {
		this.r0380_local_govt = r0380_local_govt;
	}
	public BigDecimal getR0380_non_comm_entity_emirates_govt() {
		return r0380_non_comm_entity_emirates_govt;
	}
	public void setR0380_non_comm_entity_emirates_govt(BigDecimal r0380_non_comm_entity_emirates_govt) {
		this.r0380_non_comm_entity_emirates_govt = r0380_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0380_gre() {
		return r0380_gre;
	}
	public void setR0380_gre(BigDecimal r0380_gre) {
		this.r0380_gre = r0380_gre;
	}
	public BigDecimal getR0380_private_sector_gre() {
		return r0380_private_sector_gre;
	}
	public void setR0380_private_sector_gre(BigDecimal r0380_private_sector_gre) {
		this.r0380_private_sector_gre = r0380_private_sector_gre;
	}
	public BigDecimal getR0380_private_sector_banks() {
		return r0380_private_sector_banks;
	}
	public void setR0380_private_sector_banks(BigDecimal r0380_private_sector_banks) {
		this.r0380_private_sector_banks = r0380_private_sector_banks;
	}
	public BigDecimal getR0380_private_sector_financial_institutions() {
		return r0380_private_sector_financial_institutions;
	}
	public void setR0380_private_sector_financial_institutions(BigDecimal r0380_private_sector_financial_institutions) {
		this.r0380_private_sector_financial_institutions = r0380_private_sector_financial_institutions;
	}
	public BigDecimal getR0380_private_sector_other_private_entities() {
		return r0380_private_sector_other_private_entities;
	}
	public void setR0380_private_sector_other_private_entities(BigDecimal r0380_private_sector_other_private_entities) {
		this.r0380_private_sector_other_private_entities = r0380_private_sector_other_private_entities;
	}
	public BigDecimal getR0380_total_amount() {
		return r0380_total_amount;
	}
	public void setR0380_total_amount(BigDecimal r0380_total_amount) {
		this.r0380_total_amount = r0380_total_amount;
	}
	public String getR0390_product() {
		return r0390_product;
	}
	public void setR0390_product(String r0390_product) {
		this.r0390_product = r0390_product;
	}
	public BigDecimal getR0390_fedaral_govt() {
		return r0390_fedaral_govt;
	}
	public void setR0390_fedaral_govt(BigDecimal r0390_fedaral_govt) {
		this.r0390_fedaral_govt = r0390_fedaral_govt;
	}
	public BigDecimal getR0390_non_comm_entity_fed_govt() {
		return r0390_non_comm_entity_fed_govt;
	}
	public void setR0390_non_comm_entity_fed_govt(BigDecimal r0390_non_comm_entity_fed_govt) {
		this.r0390_non_comm_entity_fed_govt = r0390_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0390_local_govt() {
		return r0390_local_govt;
	}
	public void setR0390_local_govt(BigDecimal r0390_local_govt) {
		this.r0390_local_govt = r0390_local_govt;
	}
	public BigDecimal getR0390_non_comm_entity_emirates_govt() {
		return r0390_non_comm_entity_emirates_govt;
	}
	public void setR0390_non_comm_entity_emirates_govt(BigDecimal r0390_non_comm_entity_emirates_govt) {
		this.r0390_non_comm_entity_emirates_govt = r0390_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0390_gre() {
		return r0390_gre;
	}
	public void setR0390_gre(BigDecimal r0390_gre) {
		this.r0390_gre = r0390_gre;
	}
	public BigDecimal getR0390_private_sector_gre() {
		return r0390_private_sector_gre;
	}
	public void setR0390_private_sector_gre(BigDecimal r0390_private_sector_gre) {
		this.r0390_private_sector_gre = r0390_private_sector_gre;
	}
	public BigDecimal getR0390_private_sector_banks() {
		return r0390_private_sector_banks;
	}
	public void setR0390_private_sector_banks(BigDecimal r0390_private_sector_banks) {
		this.r0390_private_sector_banks = r0390_private_sector_banks;
	}
	public BigDecimal getR0390_private_sector_financial_institutions() {
		return r0390_private_sector_financial_institutions;
	}
	public void setR0390_private_sector_financial_institutions(BigDecimal r0390_private_sector_financial_institutions) {
		this.r0390_private_sector_financial_institutions = r0390_private_sector_financial_institutions;
	}
	public BigDecimal getR0390_private_sector_other_private_entities() {
		return r0390_private_sector_other_private_entities;
	}
	public void setR0390_private_sector_other_private_entities(BigDecimal r0390_private_sector_other_private_entities) {
		this.r0390_private_sector_other_private_entities = r0390_private_sector_other_private_entities;
	}
	public BigDecimal getR0390_total_amount() {
		return r0390_total_amount;
	}
	public void setR0390_total_amount(BigDecimal r0390_total_amount) {
		this.r0390_total_amount = r0390_total_amount;
	}
	public String getR0400_product() {
		return r0400_product;
	}
	public void setR0400_product(String r0400_product) {
		this.r0400_product = r0400_product;
	}
	public BigDecimal getR0400_fedaral_govt() {
		return r0400_fedaral_govt;
	}
	public void setR0400_fedaral_govt(BigDecimal r0400_fedaral_govt) {
		this.r0400_fedaral_govt = r0400_fedaral_govt;
	}
	public BigDecimal getR0400_non_comm_entity_fed_govt() {
		return r0400_non_comm_entity_fed_govt;
	}
	public void setR0400_non_comm_entity_fed_govt(BigDecimal r0400_non_comm_entity_fed_govt) {
		this.r0400_non_comm_entity_fed_govt = r0400_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0400_local_govt() {
		return r0400_local_govt;
	}
	public void setR0400_local_govt(BigDecimal r0400_local_govt) {
		this.r0400_local_govt = r0400_local_govt;
	}
	public BigDecimal getR0400_non_comm_entity_emirates_govt() {
		return r0400_non_comm_entity_emirates_govt;
	}
	public void setR0400_non_comm_entity_emirates_govt(BigDecimal r0400_non_comm_entity_emirates_govt) {
		this.r0400_non_comm_entity_emirates_govt = r0400_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0400_gre() {
		return r0400_gre;
	}
	public void setR0400_gre(BigDecimal r0400_gre) {
		this.r0400_gre = r0400_gre;
	}
	public BigDecimal getR0400_private_sector_gre() {
		return r0400_private_sector_gre;
	}
	public void setR0400_private_sector_gre(BigDecimal r0400_private_sector_gre) {
		this.r0400_private_sector_gre = r0400_private_sector_gre;
	}
	public BigDecimal getR0400_private_sector_banks() {
		return r0400_private_sector_banks;
	}
	public void setR0400_private_sector_banks(BigDecimal r0400_private_sector_banks) {
		this.r0400_private_sector_banks = r0400_private_sector_banks;
	}
	public BigDecimal getR0400_private_sector_financial_institutions() {
		return r0400_private_sector_financial_institutions;
	}
	public void setR0400_private_sector_financial_institutions(BigDecimal r0400_private_sector_financial_institutions) {
		this.r0400_private_sector_financial_institutions = r0400_private_sector_financial_institutions;
	}
	public BigDecimal getR0400_private_sector_other_private_entities() {
		return r0400_private_sector_other_private_entities;
	}
	public void setR0400_private_sector_other_private_entities(BigDecimal r0400_private_sector_other_private_entities) {
		this.r0400_private_sector_other_private_entities = r0400_private_sector_other_private_entities;
	}
	public BigDecimal getR0400_total_amount() {
		return r0400_total_amount;
	}
	public void setR0400_total_amount(BigDecimal r0400_total_amount) {
		this.r0400_total_amount = r0400_total_amount;
	}
	public String getR0410_product() {
		return r0410_product;
	}
	public void setR0410_product(String r0410_product) {
		this.r0410_product = r0410_product;
	}
	public BigDecimal getR0410_fedaral_govt() {
		return r0410_fedaral_govt;
	}
	public void setR0410_fedaral_govt(BigDecimal r0410_fedaral_govt) {
		this.r0410_fedaral_govt = r0410_fedaral_govt;
	}
	public BigDecimal getR0410_non_comm_entity_fed_govt() {
		return r0410_non_comm_entity_fed_govt;
	}
	public void setR0410_non_comm_entity_fed_govt(BigDecimal r0410_non_comm_entity_fed_govt) {
		this.r0410_non_comm_entity_fed_govt = r0410_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0410_local_govt() {
		return r0410_local_govt;
	}
	public void setR0410_local_govt(BigDecimal r0410_local_govt) {
		this.r0410_local_govt = r0410_local_govt;
	}
	public BigDecimal getR0410_non_comm_entity_emirates_govt() {
		return r0410_non_comm_entity_emirates_govt;
	}
	public void setR0410_non_comm_entity_emirates_govt(BigDecimal r0410_non_comm_entity_emirates_govt) {
		this.r0410_non_comm_entity_emirates_govt = r0410_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0410_gre() {
		return r0410_gre;
	}
	public void setR0410_gre(BigDecimal r0410_gre) {
		this.r0410_gre = r0410_gre;
	}
	public BigDecimal getR0410_private_sector_gre() {
		return r0410_private_sector_gre;
	}
	public void setR0410_private_sector_gre(BigDecimal r0410_private_sector_gre) {
		this.r0410_private_sector_gre = r0410_private_sector_gre;
	}
	public BigDecimal getR0410_private_sector_banks() {
		return r0410_private_sector_banks;
	}
	public void setR0410_private_sector_banks(BigDecimal r0410_private_sector_banks) {
		this.r0410_private_sector_banks = r0410_private_sector_banks;
	}
	public BigDecimal getR0410_private_sector_financial_institutions() {
		return r0410_private_sector_financial_institutions;
	}
	public void setR0410_private_sector_financial_institutions(BigDecimal r0410_private_sector_financial_institutions) {
		this.r0410_private_sector_financial_institutions = r0410_private_sector_financial_institutions;
	}
	public BigDecimal getR0410_private_sector_other_private_entities() {
		return r0410_private_sector_other_private_entities;
	}
	public void setR0410_private_sector_other_private_entities(BigDecimal r0410_private_sector_other_private_entities) {
		this.r0410_private_sector_other_private_entities = r0410_private_sector_other_private_entities;
	}
	public BigDecimal getR0410_total_amount() {
		return r0410_total_amount;
	}
	public void setR0410_total_amount(BigDecimal r0410_total_amount) {
		this.r0410_total_amount = r0410_total_amount;
	}
	public String getR0420_product() {
		return r0420_product;
	}
	public void setR0420_product(String r0420_product) {
		this.r0420_product = r0420_product;
	}
	public BigDecimal getR0420_fedaral_govt() {
		return r0420_fedaral_govt;
	}
	public void setR0420_fedaral_govt(BigDecimal r0420_fedaral_govt) {
		this.r0420_fedaral_govt = r0420_fedaral_govt;
	}
	public BigDecimal getR0420_non_comm_entity_fed_govt() {
		return r0420_non_comm_entity_fed_govt;
	}
	public void setR0420_non_comm_entity_fed_govt(BigDecimal r0420_non_comm_entity_fed_govt) {
		this.r0420_non_comm_entity_fed_govt = r0420_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0420_local_govt() {
		return r0420_local_govt;
	}
	public void setR0420_local_govt(BigDecimal r0420_local_govt) {
		this.r0420_local_govt = r0420_local_govt;
	}
	public BigDecimal getR0420_non_comm_entity_emirates_govt() {
		return r0420_non_comm_entity_emirates_govt;
	}
	public void setR0420_non_comm_entity_emirates_govt(BigDecimal r0420_non_comm_entity_emirates_govt) {
		this.r0420_non_comm_entity_emirates_govt = r0420_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0420_gre() {
		return r0420_gre;
	}
	public void setR0420_gre(BigDecimal r0420_gre) {
		this.r0420_gre = r0420_gre;
	}
	public BigDecimal getR0420_private_sector_gre() {
		return r0420_private_sector_gre;
	}
	public void setR0420_private_sector_gre(BigDecimal r0420_private_sector_gre) {
		this.r0420_private_sector_gre = r0420_private_sector_gre;
	}
	public BigDecimal getR0420_private_sector_banks() {
		return r0420_private_sector_banks;
	}
	public void setR0420_private_sector_banks(BigDecimal r0420_private_sector_banks) {
		this.r0420_private_sector_banks = r0420_private_sector_banks;
	}
	public BigDecimal getR0420_private_sector_financial_institutions() {
		return r0420_private_sector_financial_institutions;
	}
	public void setR0420_private_sector_financial_institutions(BigDecimal r0420_private_sector_financial_institutions) {
		this.r0420_private_sector_financial_institutions = r0420_private_sector_financial_institutions;
	}
	public BigDecimal getR0420_private_sector_other_private_entities() {
		return r0420_private_sector_other_private_entities;
	}
	public void setR0420_private_sector_other_private_entities(BigDecimal r0420_private_sector_other_private_entities) {
		this.r0420_private_sector_other_private_entities = r0420_private_sector_other_private_entities;
	}
	public BigDecimal getR0420_total_amount() {
		return r0420_total_amount;
	}
	public void setR0420_total_amount(BigDecimal r0420_total_amount) {
		this.r0420_total_amount = r0420_total_amount;
	}
	public String getR0430_product() {
		return r0430_product;
	}
	public void setR0430_product(String r0430_product) {
		this.r0430_product = r0430_product;
	}
	public BigDecimal getR0430_fedaral_govt() {
		return r0430_fedaral_govt;
	}
	public void setR0430_fedaral_govt(BigDecimal r0430_fedaral_govt) {
		this.r0430_fedaral_govt = r0430_fedaral_govt;
	}
	public BigDecimal getR0430_non_comm_entity_fed_govt() {
		return r0430_non_comm_entity_fed_govt;
	}
	public void setR0430_non_comm_entity_fed_govt(BigDecimal r0430_non_comm_entity_fed_govt) {
		this.r0430_non_comm_entity_fed_govt = r0430_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0430_local_govt() {
		return r0430_local_govt;
	}
	public void setR0430_local_govt(BigDecimal r0430_local_govt) {
		this.r0430_local_govt = r0430_local_govt;
	}
	public BigDecimal getR0430_non_comm_entity_emirates_govt() {
		return r0430_non_comm_entity_emirates_govt;
	}
	public void setR0430_non_comm_entity_emirates_govt(BigDecimal r0430_non_comm_entity_emirates_govt) {
		this.r0430_non_comm_entity_emirates_govt = r0430_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0430_gre() {
		return r0430_gre;
	}
	public void setR0430_gre(BigDecimal r0430_gre) {
		this.r0430_gre = r0430_gre;
	}
	public BigDecimal getR0430_private_sector_gre() {
		return r0430_private_sector_gre;
	}
	public void setR0430_private_sector_gre(BigDecimal r0430_private_sector_gre) {
		this.r0430_private_sector_gre = r0430_private_sector_gre;
	}
	public BigDecimal getR0430_private_sector_banks() {
		return r0430_private_sector_banks;
	}
	public void setR0430_private_sector_banks(BigDecimal r0430_private_sector_banks) {
		this.r0430_private_sector_banks = r0430_private_sector_banks;
	}
	public BigDecimal getR0430_private_sector_financial_institutions() {
		return r0430_private_sector_financial_institutions;
	}
	public void setR0430_private_sector_financial_institutions(BigDecimal r0430_private_sector_financial_institutions) {
		this.r0430_private_sector_financial_institutions = r0430_private_sector_financial_institutions;
	}
	public BigDecimal getR0430_private_sector_other_private_entities() {
		return r0430_private_sector_other_private_entities;
	}
	public void setR0430_private_sector_other_private_entities(BigDecimal r0430_private_sector_other_private_entities) {
		this.r0430_private_sector_other_private_entities = r0430_private_sector_other_private_entities;
	}
	public BigDecimal getR0430_total_amount() {
		return r0430_total_amount;
	}
	public void setR0430_total_amount(BigDecimal r0430_total_amount) {
		this.r0430_total_amount = r0430_total_amount;
	}
	public String getR0440_product() {
		return r0440_product;
	}
	public void setR0440_product(String r0440_product) {
		this.r0440_product = r0440_product;
	}
	public BigDecimal getR0440_fedaral_govt() {
		return r0440_fedaral_govt;
	}
	public void setR0440_fedaral_govt(BigDecimal r0440_fedaral_govt) {
		this.r0440_fedaral_govt = r0440_fedaral_govt;
	}
	public BigDecimal getR0440_non_comm_entity_fed_govt() {
		return r0440_non_comm_entity_fed_govt;
	}
	public void setR0440_non_comm_entity_fed_govt(BigDecimal r0440_non_comm_entity_fed_govt) {
		this.r0440_non_comm_entity_fed_govt = r0440_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0440_local_govt() {
		return r0440_local_govt;
	}
	public void setR0440_local_govt(BigDecimal r0440_local_govt) {
		this.r0440_local_govt = r0440_local_govt;
	}
	public BigDecimal getR0440_non_comm_entity_emirates_govt() {
		return r0440_non_comm_entity_emirates_govt;
	}
	public void setR0440_non_comm_entity_emirates_govt(BigDecimal r0440_non_comm_entity_emirates_govt) {
		this.r0440_non_comm_entity_emirates_govt = r0440_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0440_gre() {
		return r0440_gre;
	}
	public void setR0440_gre(BigDecimal r0440_gre) {
		this.r0440_gre = r0440_gre;
	}
	public BigDecimal getR0440_private_sector_gre() {
		return r0440_private_sector_gre;
	}
	public void setR0440_private_sector_gre(BigDecimal r0440_private_sector_gre) {
		this.r0440_private_sector_gre = r0440_private_sector_gre;
	}
	public BigDecimal getR0440_private_sector_banks() {
		return r0440_private_sector_banks;
	}
	public void setR0440_private_sector_banks(BigDecimal r0440_private_sector_banks) {
		this.r0440_private_sector_banks = r0440_private_sector_banks;
	}
	public BigDecimal getR0440_private_sector_financial_institutions() {
		return r0440_private_sector_financial_institutions;
	}
	public void setR0440_private_sector_financial_institutions(BigDecimal r0440_private_sector_financial_institutions) {
		this.r0440_private_sector_financial_institutions = r0440_private_sector_financial_institutions;
	}
	public BigDecimal getR0440_private_sector_other_private_entities() {
		return r0440_private_sector_other_private_entities;
	}
	public void setR0440_private_sector_other_private_entities(BigDecimal r0440_private_sector_other_private_entities) {
		this.r0440_private_sector_other_private_entities = r0440_private_sector_other_private_entities;
	}
	public BigDecimal getR0440_total_amount() {
		return r0440_total_amount;
	}
	public void setR0440_total_amount(BigDecimal r0440_total_amount) {
		this.r0440_total_amount = r0440_total_amount;
	}
	public String getR0450_product() {
		return r0450_product;
	}
	public void setR0450_product(String r0450_product) {
		this.r0450_product = r0450_product;
	}
	public BigDecimal getR0450_fedaral_govt() {
		return r0450_fedaral_govt;
	}
	public void setR0450_fedaral_govt(BigDecimal r0450_fedaral_govt) {
		this.r0450_fedaral_govt = r0450_fedaral_govt;
	}
	public BigDecimal getR0450_non_comm_entity_fed_govt() {
		return r0450_non_comm_entity_fed_govt;
	}
	public void setR0450_non_comm_entity_fed_govt(BigDecimal r0450_non_comm_entity_fed_govt) {
		this.r0450_non_comm_entity_fed_govt = r0450_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0450_local_govt() {
		return r0450_local_govt;
	}
	public void setR0450_local_govt(BigDecimal r0450_local_govt) {
		this.r0450_local_govt = r0450_local_govt;
	}
	public BigDecimal getR0450_non_comm_entity_emirates_govt() {
		return r0450_non_comm_entity_emirates_govt;
	}
	public void setR0450_non_comm_entity_emirates_govt(BigDecimal r0450_non_comm_entity_emirates_govt) {
		this.r0450_non_comm_entity_emirates_govt = r0450_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0450_gre() {
		return r0450_gre;
	}
	public void setR0450_gre(BigDecimal r0450_gre) {
		this.r0450_gre = r0450_gre;
	}
	public BigDecimal getR0450_private_sector_gre() {
		return r0450_private_sector_gre;
	}
	public void setR0450_private_sector_gre(BigDecimal r0450_private_sector_gre) {
		this.r0450_private_sector_gre = r0450_private_sector_gre;
	}
	public BigDecimal getR0450_private_sector_banks() {
		return r0450_private_sector_banks;
	}
	public void setR0450_private_sector_banks(BigDecimal r0450_private_sector_banks) {
		this.r0450_private_sector_banks = r0450_private_sector_banks;
	}
	public BigDecimal getR0450_private_sector_financial_institutions() {
		return r0450_private_sector_financial_institutions;
	}
	public void setR0450_private_sector_financial_institutions(BigDecimal r0450_private_sector_financial_institutions) {
		this.r0450_private_sector_financial_institutions = r0450_private_sector_financial_institutions;
	}
	public BigDecimal getR0450_private_sector_other_private_entities() {
		return r0450_private_sector_other_private_entities;
	}
	public void setR0450_private_sector_other_private_entities(BigDecimal r0450_private_sector_other_private_entities) {
		this.r0450_private_sector_other_private_entities = r0450_private_sector_other_private_entities;
	}
	public BigDecimal getR0450_total_amount() {
		return r0450_total_amount;
	}
	public void setR0450_total_amount(BigDecimal r0450_total_amount) {
		this.r0450_total_amount = r0450_total_amount;
	}
	public String getR0460_product() {
		return r0460_product;
	}
	public void setR0460_product(String r0460_product) {
		this.r0460_product = r0460_product;
	}
	public BigDecimal getR0460_fedaral_govt() {
		return r0460_fedaral_govt;
	}
	public void setR0460_fedaral_govt(BigDecimal r0460_fedaral_govt) {
		this.r0460_fedaral_govt = r0460_fedaral_govt;
	}
	public BigDecimal getR0460_non_comm_entity_fed_govt() {
		return r0460_non_comm_entity_fed_govt;
	}
	public void setR0460_non_comm_entity_fed_govt(BigDecimal r0460_non_comm_entity_fed_govt) {
		this.r0460_non_comm_entity_fed_govt = r0460_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0460_local_govt() {
		return r0460_local_govt;
	}
	public void setR0460_local_govt(BigDecimal r0460_local_govt) {
		this.r0460_local_govt = r0460_local_govt;
	}
	public BigDecimal getR0460_non_comm_entity_emirates_govt() {
		return r0460_non_comm_entity_emirates_govt;
	}
	public void setR0460_non_comm_entity_emirates_govt(BigDecimal r0460_non_comm_entity_emirates_govt) {
		this.r0460_non_comm_entity_emirates_govt = r0460_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0460_gre() {
		return r0460_gre;
	}
	public void setR0460_gre(BigDecimal r0460_gre) {
		this.r0460_gre = r0460_gre;
	}
	public BigDecimal getR0460_private_sector_gre() {
		return r0460_private_sector_gre;
	}
	public void setR0460_private_sector_gre(BigDecimal r0460_private_sector_gre) {
		this.r0460_private_sector_gre = r0460_private_sector_gre;
	}
	public BigDecimal getR0460_private_sector_banks() {
		return r0460_private_sector_banks;
	}
	public void setR0460_private_sector_banks(BigDecimal r0460_private_sector_banks) {
		this.r0460_private_sector_banks = r0460_private_sector_banks;
	}
	public BigDecimal getR0460_private_sector_financial_institutions() {
		return r0460_private_sector_financial_institutions;
	}
	public void setR0460_private_sector_financial_institutions(BigDecimal r0460_private_sector_financial_institutions) {
		this.r0460_private_sector_financial_institutions = r0460_private_sector_financial_institutions;
	}
	public BigDecimal getR0460_private_sector_other_private_entities() {
		return r0460_private_sector_other_private_entities;
	}
	public void setR0460_private_sector_other_private_entities(BigDecimal r0460_private_sector_other_private_entities) {
		this.r0460_private_sector_other_private_entities = r0460_private_sector_other_private_entities;
	}
	public BigDecimal getR0460_total_amount() {
		return r0460_total_amount;
	}
	public void setR0460_total_amount(BigDecimal r0460_total_amount) {
		this.r0460_total_amount = r0460_total_amount;
	}
	public String getR0470_product() {
		return r0470_product;
	}
	public void setR0470_product(String r0470_product) {
		this.r0470_product = r0470_product;
	}
	public BigDecimal getR0470_fedaral_govt() {
		return r0470_fedaral_govt;
	}
	public void setR0470_fedaral_govt(BigDecimal r0470_fedaral_govt) {
		this.r0470_fedaral_govt = r0470_fedaral_govt;
	}
	public BigDecimal getR0470_non_comm_entity_fed_govt() {
		return r0470_non_comm_entity_fed_govt;
	}
	public void setR0470_non_comm_entity_fed_govt(BigDecimal r0470_non_comm_entity_fed_govt) {
		this.r0470_non_comm_entity_fed_govt = r0470_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0470_local_govt() {
		return r0470_local_govt;
	}
	public void setR0470_local_govt(BigDecimal r0470_local_govt) {
		this.r0470_local_govt = r0470_local_govt;
	}
	public BigDecimal getR0470_non_comm_entity_emirates_govt() {
		return r0470_non_comm_entity_emirates_govt;
	}
	public void setR0470_non_comm_entity_emirates_govt(BigDecimal r0470_non_comm_entity_emirates_govt) {
		this.r0470_non_comm_entity_emirates_govt = r0470_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0470_gre() {
		return r0470_gre;
	}
	public void setR0470_gre(BigDecimal r0470_gre) {
		this.r0470_gre = r0470_gre;
	}
	public BigDecimal getR0470_private_sector_gre() {
		return r0470_private_sector_gre;
	}
	public void setR0470_private_sector_gre(BigDecimal r0470_private_sector_gre) {
		this.r0470_private_sector_gre = r0470_private_sector_gre;
	}
	public BigDecimal getR0470_private_sector_banks() {
		return r0470_private_sector_banks;
	}
	public void setR0470_private_sector_banks(BigDecimal r0470_private_sector_banks) {
		this.r0470_private_sector_banks = r0470_private_sector_banks;
	}
	public BigDecimal getR0470_private_sector_financial_institutions() {
		return r0470_private_sector_financial_institutions;
	}
	public void setR0470_private_sector_financial_institutions(BigDecimal r0470_private_sector_financial_institutions) {
		this.r0470_private_sector_financial_institutions = r0470_private_sector_financial_institutions;
	}
	public BigDecimal getR0470_private_sector_other_private_entities() {
		return r0470_private_sector_other_private_entities;
	}
	public void setR0470_private_sector_other_private_entities(BigDecimal r0470_private_sector_other_private_entities) {
		this.r0470_private_sector_other_private_entities = r0470_private_sector_other_private_entities;
	}
	public BigDecimal getR0470_total_amount() {
		return r0470_total_amount;
	}
	public void setR0470_total_amount(BigDecimal r0470_total_amount) {
		this.r0470_total_amount = r0470_total_amount;
	}
	public String getR0480_product() {
		return r0480_product;
	}
	public void setR0480_product(String r0480_product) {
		this.r0480_product = r0480_product;
	}
	public BigDecimal getR0480_fedaral_govt() {
		return r0480_fedaral_govt;
	}
	public void setR0480_fedaral_govt(BigDecimal r0480_fedaral_govt) {
		this.r0480_fedaral_govt = r0480_fedaral_govt;
	}
	public BigDecimal getR0480_non_comm_entity_fed_govt() {
		return r0480_non_comm_entity_fed_govt;
	}
	public void setR0480_non_comm_entity_fed_govt(BigDecimal r0480_non_comm_entity_fed_govt) {
		this.r0480_non_comm_entity_fed_govt = r0480_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0480_local_govt() {
		return r0480_local_govt;
	}
	public void setR0480_local_govt(BigDecimal r0480_local_govt) {
		this.r0480_local_govt = r0480_local_govt;
	}
	public BigDecimal getR0480_non_comm_entity_emirates_govt() {
		return r0480_non_comm_entity_emirates_govt;
	}
	public void setR0480_non_comm_entity_emirates_govt(BigDecimal r0480_non_comm_entity_emirates_govt) {
		this.r0480_non_comm_entity_emirates_govt = r0480_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0480_gre() {
		return r0480_gre;
	}
	public void setR0480_gre(BigDecimal r0480_gre) {
		this.r0480_gre = r0480_gre;
	}
	public BigDecimal getR0480_private_sector_gre() {
		return r0480_private_sector_gre;
	}
	public void setR0480_private_sector_gre(BigDecimal r0480_private_sector_gre) {
		this.r0480_private_sector_gre = r0480_private_sector_gre;
	}
	public BigDecimal getR0480_private_sector_banks() {
		return r0480_private_sector_banks;
	}
	public void setR0480_private_sector_banks(BigDecimal r0480_private_sector_banks) {
		this.r0480_private_sector_banks = r0480_private_sector_banks;
	}
	public BigDecimal getR0480_private_sector_financial_institutions() {
		return r0480_private_sector_financial_institutions;
	}
	public void setR0480_private_sector_financial_institutions(BigDecimal r0480_private_sector_financial_institutions) {
		this.r0480_private_sector_financial_institutions = r0480_private_sector_financial_institutions;
	}
	public BigDecimal getR0480_private_sector_other_private_entities() {
		return r0480_private_sector_other_private_entities;
	}
	public void setR0480_private_sector_other_private_entities(BigDecimal r0480_private_sector_other_private_entities) {
		this.r0480_private_sector_other_private_entities = r0480_private_sector_other_private_entities;
	}
	public BigDecimal getR0480_total_amount() {
		return r0480_total_amount;
	}
	public void setR0480_total_amount(BigDecimal r0480_total_amount) {
		this.r0480_total_amount = r0480_total_amount;
	}
	public String getR0490_product() {
		return r0490_product;
	}
	public void setR0490_product(String r0490_product) {
		this.r0490_product = r0490_product;
	}
	public BigDecimal getR0490_fedaral_govt() {
		return r0490_fedaral_govt;
	}
	public void setR0490_fedaral_govt(BigDecimal r0490_fedaral_govt) {
		this.r0490_fedaral_govt = r0490_fedaral_govt;
	}
	public BigDecimal getR0490_non_comm_entity_fed_govt() {
		return r0490_non_comm_entity_fed_govt;
	}
	public void setR0490_non_comm_entity_fed_govt(BigDecimal r0490_non_comm_entity_fed_govt) {
		this.r0490_non_comm_entity_fed_govt = r0490_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0490_local_govt() {
		return r0490_local_govt;
	}
	public void setR0490_local_govt(BigDecimal r0490_local_govt) {
		this.r0490_local_govt = r0490_local_govt;
	}
	public BigDecimal getR0490_non_comm_entity_emirates_govt() {
		return r0490_non_comm_entity_emirates_govt;
	}
	public void setR0490_non_comm_entity_emirates_govt(BigDecimal r0490_non_comm_entity_emirates_govt) {
		this.r0490_non_comm_entity_emirates_govt = r0490_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0490_gre() {
		return r0490_gre;
	}
	public void setR0490_gre(BigDecimal r0490_gre) {
		this.r0490_gre = r0490_gre;
	}
	public BigDecimal getR0490_private_sector_gre() {
		return r0490_private_sector_gre;
	}
	public void setR0490_private_sector_gre(BigDecimal r0490_private_sector_gre) {
		this.r0490_private_sector_gre = r0490_private_sector_gre;
	}
	public BigDecimal getR0490_private_sector_banks() {
		return r0490_private_sector_banks;
	}
	public void setR0490_private_sector_banks(BigDecimal r0490_private_sector_banks) {
		this.r0490_private_sector_banks = r0490_private_sector_banks;
	}
	public BigDecimal getR0490_private_sector_financial_institutions() {
		return r0490_private_sector_financial_institutions;
	}
	public void setR0490_private_sector_financial_institutions(BigDecimal r0490_private_sector_financial_institutions) {
		this.r0490_private_sector_financial_institutions = r0490_private_sector_financial_institutions;
	}
	public BigDecimal getR0490_private_sector_other_private_entities() {
		return r0490_private_sector_other_private_entities;
	}
	public void setR0490_private_sector_other_private_entities(BigDecimal r0490_private_sector_other_private_entities) {
		this.r0490_private_sector_other_private_entities = r0490_private_sector_other_private_entities;
	}
	public BigDecimal getR0490_total_amount() {
		return r0490_total_amount;
	}
	public void setR0490_total_amount(BigDecimal r0490_total_amount) {
		this.r0490_total_amount = r0490_total_amount;
	}
	public String getR0500_product() {
		return r0500_product;
	}
	public void setR0500_product(String r0500_product) {
		this.r0500_product = r0500_product;
	}
	public BigDecimal getR0500_fedaral_govt() {
		return r0500_fedaral_govt;
	}
	public void setR0500_fedaral_govt(BigDecimal r0500_fedaral_govt) {
		this.r0500_fedaral_govt = r0500_fedaral_govt;
	}
	public BigDecimal getR0500_non_comm_entity_fed_govt() {
		return r0500_non_comm_entity_fed_govt;
	}
	public void setR0500_non_comm_entity_fed_govt(BigDecimal r0500_non_comm_entity_fed_govt) {
		this.r0500_non_comm_entity_fed_govt = r0500_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0500_local_govt() {
		return r0500_local_govt;
	}
	public void setR0500_local_govt(BigDecimal r0500_local_govt) {
		this.r0500_local_govt = r0500_local_govt;
	}
	public BigDecimal getR0500_non_comm_entity_emirates_govt() {
		return r0500_non_comm_entity_emirates_govt;
	}
	public void setR0500_non_comm_entity_emirates_govt(BigDecimal r0500_non_comm_entity_emirates_govt) {
		this.r0500_non_comm_entity_emirates_govt = r0500_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0500_gre() {
		return r0500_gre;
	}
	public void setR0500_gre(BigDecimal r0500_gre) {
		this.r0500_gre = r0500_gre;
	}
	public BigDecimal getR0500_private_sector_gre() {
		return r0500_private_sector_gre;
	}
	public void setR0500_private_sector_gre(BigDecimal r0500_private_sector_gre) {
		this.r0500_private_sector_gre = r0500_private_sector_gre;
	}
	public BigDecimal getR0500_private_sector_banks() {
		return r0500_private_sector_banks;
	}
	public void setR0500_private_sector_banks(BigDecimal r0500_private_sector_banks) {
		this.r0500_private_sector_banks = r0500_private_sector_banks;
	}
	public BigDecimal getR0500_private_sector_financial_institutions() {
		return r0500_private_sector_financial_institutions;
	}
	public void setR0500_private_sector_financial_institutions(BigDecimal r0500_private_sector_financial_institutions) {
		this.r0500_private_sector_financial_institutions = r0500_private_sector_financial_institutions;
	}
	public BigDecimal getR0500_private_sector_other_private_entities() {
		return r0500_private_sector_other_private_entities;
	}
	public void setR0500_private_sector_other_private_entities(BigDecimal r0500_private_sector_other_private_entities) {
		this.r0500_private_sector_other_private_entities = r0500_private_sector_other_private_entities;
	}
	public BigDecimal getR0500_total_amount() {
		return r0500_total_amount;
	}
	public void setR0500_total_amount(BigDecimal r0500_total_amount) {
		this.r0500_total_amount = r0500_total_amount;
	}
	public String getR0510_product() {
		return r0510_product;
	}
	public void setR0510_product(String r0510_product) {
		this.r0510_product = r0510_product;
	}
	public BigDecimal getR0510_fedaral_govt() {
		return r0510_fedaral_govt;
	}
	public void setR0510_fedaral_govt(BigDecimal r0510_fedaral_govt) {
		this.r0510_fedaral_govt = r0510_fedaral_govt;
	}
	public BigDecimal getR0510_non_comm_entity_fed_govt() {
		return r0510_non_comm_entity_fed_govt;
	}
	public void setR0510_non_comm_entity_fed_govt(BigDecimal r0510_non_comm_entity_fed_govt) {
		this.r0510_non_comm_entity_fed_govt = r0510_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0510_local_govt() {
		return r0510_local_govt;
	}
	public void setR0510_local_govt(BigDecimal r0510_local_govt) {
		this.r0510_local_govt = r0510_local_govt;
	}
	public BigDecimal getR0510_non_comm_entity_emirates_govt() {
		return r0510_non_comm_entity_emirates_govt;
	}
	public void setR0510_non_comm_entity_emirates_govt(BigDecimal r0510_non_comm_entity_emirates_govt) {
		this.r0510_non_comm_entity_emirates_govt = r0510_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0510_gre() {
		return r0510_gre;
	}
	public void setR0510_gre(BigDecimal r0510_gre) {
		this.r0510_gre = r0510_gre;
	}
	public BigDecimal getR0510_private_sector_gre() {
		return r0510_private_sector_gre;
	}
	public void setR0510_private_sector_gre(BigDecimal r0510_private_sector_gre) {
		this.r0510_private_sector_gre = r0510_private_sector_gre;
	}
	public BigDecimal getR0510_private_sector_banks() {
		return r0510_private_sector_banks;
	}
	public void setR0510_private_sector_banks(BigDecimal r0510_private_sector_banks) {
		this.r0510_private_sector_banks = r0510_private_sector_banks;
	}
	public BigDecimal getR0510_private_sector_financial_institutions() {
		return r0510_private_sector_financial_institutions;
	}
	public void setR0510_private_sector_financial_institutions(BigDecimal r0510_private_sector_financial_institutions) {
		this.r0510_private_sector_financial_institutions = r0510_private_sector_financial_institutions;
	}
	public BigDecimal getR0510_private_sector_other_private_entities() {
		return r0510_private_sector_other_private_entities;
	}
	public void setR0510_private_sector_other_private_entities(BigDecimal r0510_private_sector_other_private_entities) {
		this.r0510_private_sector_other_private_entities = r0510_private_sector_other_private_entities;
	}
	public BigDecimal getR0510_total_amount() {
		return r0510_total_amount;
	}
	public void setR0510_total_amount(BigDecimal r0510_total_amount) {
		this.r0510_total_amount = r0510_total_amount;
	}
	public String getR0520_product() {
		return r0520_product;
	}
	public void setR0520_product(String r0520_product) {
		this.r0520_product = r0520_product;
	}
	public BigDecimal getR0520_fedaral_govt() {
		return r0520_fedaral_govt;
	}
	public void setR0520_fedaral_govt(BigDecimal r0520_fedaral_govt) {
		this.r0520_fedaral_govt = r0520_fedaral_govt;
	}
	public BigDecimal getR0520_non_comm_entity_fed_govt() {
		return r0520_non_comm_entity_fed_govt;
	}
	public void setR0520_non_comm_entity_fed_govt(BigDecimal r0520_non_comm_entity_fed_govt) {
		this.r0520_non_comm_entity_fed_govt = r0520_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0520_local_govt() {
		return r0520_local_govt;
	}
	public void setR0520_local_govt(BigDecimal r0520_local_govt) {
		this.r0520_local_govt = r0520_local_govt;
	}
	public BigDecimal getR0520_non_comm_entity_emirates_govt() {
		return r0520_non_comm_entity_emirates_govt;
	}
	public void setR0520_non_comm_entity_emirates_govt(BigDecimal r0520_non_comm_entity_emirates_govt) {
		this.r0520_non_comm_entity_emirates_govt = r0520_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0520_gre() {
		return r0520_gre;
	}
	public void setR0520_gre(BigDecimal r0520_gre) {
		this.r0520_gre = r0520_gre;
	}
	public BigDecimal getR0520_private_sector_gre() {
		return r0520_private_sector_gre;
	}
	public void setR0520_private_sector_gre(BigDecimal r0520_private_sector_gre) {
		this.r0520_private_sector_gre = r0520_private_sector_gre;
	}
	public BigDecimal getR0520_private_sector_banks() {
		return r0520_private_sector_banks;
	}
	public void setR0520_private_sector_banks(BigDecimal r0520_private_sector_banks) {
		this.r0520_private_sector_banks = r0520_private_sector_banks;
	}
	public BigDecimal getR0520_private_sector_financial_institutions() {
		return r0520_private_sector_financial_institutions;
	}
	public void setR0520_private_sector_financial_institutions(BigDecimal r0520_private_sector_financial_institutions) {
		this.r0520_private_sector_financial_institutions = r0520_private_sector_financial_institutions;
	}
	public BigDecimal getR0520_private_sector_other_private_entities() {
		return r0520_private_sector_other_private_entities;
	}
	public void setR0520_private_sector_other_private_entities(BigDecimal r0520_private_sector_other_private_entities) {
		this.r0520_private_sector_other_private_entities = r0520_private_sector_other_private_entities;
	}
	public BigDecimal getR0520_total_amount() {
		return r0520_total_amount;
	}
	public void setR0520_total_amount(BigDecimal r0520_total_amount) {
		this.r0520_total_amount = r0520_total_amount;
	}
	public String getR0530_product() {
		return r0530_product;
	}
	public void setR0530_product(String r0530_product) {
		this.r0530_product = r0530_product;
	}
	public BigDecimal getR0530_fedaral_govt() {
		return r0530_fedaral_govt;
	}
	public void setR0530_fedaral_govt(BigDecimal r0530_fedaral_govt) {
		this.r0530_fedaral_govt = r0530_fedaral_govt;
	}
	public BigDecimal getR0530_non_comm_entity_fed_govt() {
		return r0530_non_comm_entity_fed_govt;
	}
	public void setR0530_non_comm_entity_fed_govt(BigDecimal r0530_non_comm_entity_fed_govt) {
		this.r0530_non_comm_entity_fed_govt = r0530_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0530_local_govt() {
		return r0530_local_govt;
	}
	public void setR0530_local_govt(BigDecimal r0530_local_govt) {
		this.r0530_local_govt = r0530_local_govt;
	}
	public BigDecimal getR0530_non_comm_entity_emirates_govt() {
		return r0530_non_comm_entity_emirates_govt;
	}
	public void setR0530_non_comm_entity_emirates_govt(BigDecimal r0530_non_comm_entity_emirates_govt) {
		this.r0530_non_comm_entity_emirates_govt = r0530_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0530_gre() {
		return r0530_gre;
	}
	public void setR0530_gre(BigDecimal r0530_gre) {
		this.r0530_gre = r0530_gre;
	}
	public BigDecimal getR0530_private_sector_gre() {
		return r0530_private_sector_gre;
	}
	public void setR0530_private_sector_gre(BigDecimal r0530_private_sector_gre) {
		this.r0530_private_sector_gre = r0530_private_sector_gre;
	}
	public BigDecimal getR0530_private_sector_banks() {
		return r0530_private_sector_banks;
	}
	public void setR0530_private_sector_banks(BigDecimal r0530_private_sector_banks) {
		this.r0530_private_sector_banks = r0530_private_sector_banks;
	}
	public BigDecimal getR0530_private_sector_financial_institutions() {
		return r0530_private_sector_financial_institutions;
	}
	public void setR0530_private_sector_financial_institutions(BigDecimal r0530_private_sector_financial_institutions) {
		this.r0530_private_sector_financial_institutions = r0530_private_sector_financial_institutions;
	}
	public BigDecimal getR0530_private_sector_other_private_entities() {
		return r0530_private_sector_other_private_entities;
	}
	public void setR0530_private_sector_other_private_entities(BigDecimal r0530_private_sector_other_private_entities) {
		this.r0530_private_sector_other_private_entities = r0530_private_sector_other_private_entities;
	}
	public BigDecimal getR0530_total_amount() {
		return r0530_total_amount;
	}
	public void setR0530_total_amount(BigDecimal r0530_total_amount) {
		this.r0530_total_amount = r0530_total_amount;
	}
	public String getR0540_product() {
		return r0540_product;
	}
	public void setR0540_product(String r0540_product) {
		this.r0540_product = r0540_product;
	}
	public BigDecimal getR0540_fedaral_govt() {
		return r0540_fedaral_govt;
	}
	public void setR0540_fedaral_govt(BigDecimal r0540_fedaral_govt) {
		this.r0540_fedaral_govt = r0540_fedaral_govt;
	}
	public BigDecimal getR0540_non_comm_entity_fed_govt() {
		return r0540_non_comm_entity_fed_govt;
	}
	public void setR0540_non_comm_entity_fed_govt(BigDecimal r0540_non_comm_entity_fed_govt) {
		this.r0540_non_comm_entity_fed_govt = r0540_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0540_local_govt() {
		return r0540_local_govt;
	}
	public void setR0540_local_govt(BigDecimal r0540_local_govt) {
		this.r0540_local_govt = r0540_local_govt;
	}
	public BigDecimal getR0540_non_comm_entity_emirates_govt() {
		return r0540_non_comm_entity_emirates_govt;
	}
	public void setR0540_non_comm_entity_emirates_govt(BigDecimal r0540_non_comm_entity_emirates_govt) {
		this.r0540_non_comm_entity_emirates_govt = r0540_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0540_gre() {
		return r0540_gre;
	}
	public void setR0540_gre(BigDecimal r0540_gre) {
		this.r0540_gre = r0540_gre;
	}
	public BigDecimal getR0540_private_sector_gre() {
		return r0540_private_sector_gre;
	}
	public void setR0540_private_sector_gre(BigDecimal r0540_private_sector_gre) {
		this.r0540_private_sector_gre = r0540_private_sector_gre;
	}
	public BigDecimal getR0540_private_sector_banks() {
		return r0540_private_sector_banks;
	}
	public void setR0540_private_sector_banks(BigDecimal r0540_private_sector_banks) {
		this.r0540_private_sector_banks = r0540_private_sector_banks;
	}
	public BigDecimal getR0540_private_sector_financial_institutions() {
		return r0540_private_sector_financial_institutions;
	}
	public void setR0540_private_sector_financial_institutions(BigDecimal r0540_private_sector_financial_institutions) {
		this.r0540_private_sector_financial_institutions = r0540_private_sector_financial_institutions;
	}
	public BigDecimal getR0540_private_sector_other_private_entities() {
		return r0540_private_sector_other_private_entities;
	}
	public void setR0540_private_sector_other_private_entities(BigDecimal r0540_private_sector_other_private_entities) {
		this.r0540_private_sector_other_private_entities = r0540_private_sector_other_private_entities;
	}
	public BigDecimal getR0540_total_amount() {
		return r0540_total_amount;
	}
	public void setR0540_total_amount(BigDecimal r0540_total_amount) {
		this.r0540_total_amount = r0540_total_amount;
	}
	public String getR0550_product() {
		return r0550_product;
	}
	public void setR0550_product(String r0550_product) {
		this.r0550_product = r0550_product;
	}
	public BigDecimal getR0550_fedaral_govt() {
		return r0550_fedaral_govt;
	}
	public void setR0550_fedaral_govt(BigDecimal r0550_fedaral_govt) {
		this.r0550_fedaral_govt = r0550_fedaral_govt;
	}
	public BigDecimal getR0550_non_comm_entity_fed_govt() {
		return r0550_non_comm_entity_fed_govt;
	}
	public void setR0550_non_comm_entity_fed_govt(BigDecimal r0550_non_comm_entity_fed_govt) {
		this.r0550_non_comm_entity_fed_govt = r0550_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0550_local_govt() {
		return r0550_local_govt;
	}
	public void setR0550_local_govt(BigDecimal r0550_local_govt) {
		this.r0550_local_govt = r0550_local_govt;
	}
	public BigDecimal getR0550_non_comm_entity_emirates_govt() {
		return r0550_non_comm_entity_emirates_govt;
	}
	public void setR0550_non_comm_entity_emirates_govt(BigDecimal r0550_non_comm_entity_emirates_govt) {
		this.r0550_non_comm_entity_emirates_govt = r0550_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0550_gre() {
		return r0550_gre;
	}
	public void setR0550_gre(BigDecimal r0550_gre) {
		this.r0550_gre = r0550_gre;
	}
	public BigDecimal getR0550_private_sector_gre() {
		return r0550_private_sector_gre;
	}
	public void setR0550_private_sector_gre(BigDecimal r0550_private_sector_gre) {
		this.r0550_private_sector_gre = r0550_private_sector_gre;
	}
	public BigDecimal getR0550_private_sector_banks() {
		return r0550_private_sector_banks;
	}
	public void setR0550_private_sector_banks(BigDecimal r0550_private_sector_banks) {
		this.r0550_private_sector_banks = r0550_private_sector_banks;
	}
	public BigDecimal getR0550_private_sector_financial_institutions() {
		return r0550_private_sector_financial_institutions;
	}
	public void setR0550_private_sector_financial_institutions(BigDecimal r0550_private_sector_financial_institutions) {
		this.r0550_private_sector_financial_institutions = r0550_private_sector_financial_institutions;
	}
	public BigDecimal getR0550_private_sector_other_private_entities() {
		return r0550_private_sector_other_private_entities;
	}
	public void setR0550_private_sector_other_private_entities(BigDecimal r0550_private_sector_other_private_entities) {
		this.r0550_private_sector_other_private_entities = r0550_private_sector_other_private_entities;
	}
	public BigDecimal getR0550_total_amount() {
		return r0550_total_amount;
	}
	public void setR0550_total_amount(BigDecimal r0550_total_amount) {
		this.r0550_total_amount = r0550_total_amount;
	}
	public String getR0560_product() {
		return r0560_product;
	}
	public void setR0560_product(String r0560_product) {
		this.r0560_product = r0560_product;
	}
	public BigDecimal getR0560_fedaral_govt() {
		return r0560_fedaral_govt;
	}
	public void setR0560_fedaral_govt(BigDecimal r0560_fedaral_govt) {
		this.r0560_fedaral_govt = r0560_fedaral_govt;
	}
	public BigDecimal getR0560_non_comm_entity_fed_govt() {
		return r0560_non_comm_entity_fed_govt;
	}
	public void setR0560_non_comm_entity_fed_govt(BigDecimal r0560_non_comm_entity_fed_govt) {
		this.r0560_non_comm_entity_fed_govt = r0560_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0560_local_govt() {
		return r0560_local_govt;
	}
	public void setR0560_local_govt(BigDecimal r0560_local_govt) {
		this.r0560_local_govt = r0560_local_govt;
	}
	public BigDecimal getR0560_non_comm_entity_emirates_govt() {
		return r0560_non_comm_entity_emirates_govt;
	}
	public void setR0560_non_comm_entity_emirates_govt(BigDecimal r0560_non_comm_entity_emirates_govt) {
		this.r0560_non_comm_entity_emirates_govt = r0560_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0560_gre() {
		return r0560_gre;
	}
	public void setR0560_gre(BigDecimal r0560_gre) {
		this.r0560_gre = r0560_gre;
	}
	public BigDecimal getR0560_private_sector_gre() {
		return r0560_private_sector_gre;
	}
	public void setR0560_private_sector_gre(BigDecimal r0560_private_sector_gre) {
		this.r0560_private_sector_gre = r0560_private_sector_gre;
	}
	public BigDecimal getR0560_private_sector_banks() {
		return r0560_private_sector_banks;
	}
	public void setR0560_private_sector_banks(BigDecimal r0560_private_sector_banks) {
		this.r0560_private_sector_banks = r0560_private_sector_banks;
	}
	public BigDecimal getR0560_private_sector_financial_institutions() {
		return r0560_private_sector_financial_institutions;
	}
	public void setR0560_private_sector_financial_institutions(BigDecimal r0560_private_sector_financial_institutions) {
		this.r0560_private_sector_financial_institutions = r0560_private_sector_financial_institutions;
	}
	public BigDecimal getR0560_private_sector_other_private_entities() {
		return r0560_private_sector_other_private_entities;
	}
	public void setR0560_private_sector_other_private_entities(BigDecimal r0560_private_sector_other_private_entities) {
		this.r0560_private_sector_other_private_entities = r0560_private_sector_other_private_entities;
	}
	public BigDecimal getR0560_total_amount() {
		return r0560_total_amount;
	}
	public void setR0560_total_amount(BigDecimal r0560_total_amount) {
		this.r0560_total_amount = r0560_total_amount;
	}
	public String getR0570_product() {
		return r0570_product;
	}
	public void setR0570_product(String r0570_product) {
		this.r0570_product = r0570_product;
	}
	public BigDecimal getR0570_fedaral_govt() {
		return r0570_fedaral_govt;
	}
	public void setR0570_fedaral_govt(BigDecimal r0570_fedaral_govt) {
		this.r0570_fedaral_govt = r0570_fedaral_govt;
	}
	public BigDecimal getR0570_non_comm_entity_fed_govt() {
		return r0570_non_comm_entity_fed_govt;
	}
	public void setR0570_non_comm_entity_fed_govt(BigDecimal r0570_non_comm_entity_fed_govt) {
		this.r0570_non_comm_entity_fed_govt = r0570_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0570_local_govt() {
		return r0570_local_govt;
	}
	public void setR0570_local_govt(BigDecimal r0570_local_govt) {
		this.r0570_local_govt = r0570_local_govt;
	}
	public BigDecimal getR0570_non_comm_entity_emirates_govt() {
		return r0570_non_comm_entity_emirates_govt;
	}
	public void setR0570_non_comm_entity_emirates_govt(BigDecimal r0570_non_comm_entity_emirates_govt) {
		this.r0570_non_comm_entity_emirates_govt = r0570_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0570_gre() {
		return r0570_gre;
	}
	public void setR0570_gre(BigDecimal r0570_gre) {
		this.r0570_gre = r0570_gre;
	}
	public BigDecimal getR0570_private_sector_gre() {
		return r0570_private_sector_gre;
	}
	public void setR0570_private_sector_gre(BigDecimal r0570_private_sector_gre) {
		this.r0570_private_sector_gre = r0570_private_sector_gre;
	}
	public BigDecimal getR0570_private_sector_banks() {
		return r0570_private_sector_banks;
	}
	public void setR0570_private_sector_banks(BigDecimal r0570_private_sector_banks) {
		this.r0570_private_sector_banks = r0570_private_sector_banks;
	}
	public BigDecimal getR0570_private_sector_financial_institutions() {
		return r0570_private_sector_financial_institutions;
	}
	public void setR0570_private_sector_financial_institutions(BigDecimal r0570_private_sector_financial_institutions) {
		this.r0570_private_sector_financial_institutions = r0570_private_sector_financial_institutions;
	}
	public BigDecimal getR0570_private_sector_other_private_entities() {
		return r0570_private_sector_other_private_entities;
	}
	public void setR0570_private_sector_other_private_entities(BigDecimal r0570_private_sector_other_private_entities) {
		this.r0570_private_sector_other_private_entities = r0570_private_sector_other_private_entities;
	}
	public BigDecimal getR0570_total_amount() {
		return r0570_total_amount;
	}
	public void setR0570_total_amount(BigDecimal r0570_total_amount) {
		this.r0570_total_amount = r0570_total_amount;
	}
	public String getR0580_product() {
		return r0580_product;
	}
	public void setR0580_product(String r0580_product) {
		this.r0580_product = r0580_product;
	}
	public BigDecimal getR0580_fedaral_govt() {
		return r0580_fedaral_govt;
	}
	public void setR0580_fedaral_govt(BigDecimal r0580_fedaral_govt) {
		this.r0580_fedaral_govt = r0580_fedaral_govt;
	}
	public BigDecimal getR0580_non_comm_entity_fed_govt() {
		return r0580_non_comm_entity_fed_govt;
	}
	public void setR0580_non_comm_entity_fed_govt(BigDecimal r0580_non_comm_entity_fed_govt) {
		this.r0580_non_comm_entity_fed_govt = r0580_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0580_local_govt() {
		return r0580_local_govt;
	}
	public void setR0580_local_govt(BigDecimal r0580_local_govt) {
		this.r0580_local_govt = r0580_local_govt;
	}
	public BigDecimal getR0580_non_comm_entity_emirates_govt() {
		return r0580_non_comm_entity_emirates_govt;
	}
	public void setR0580_non_comm_entity_emirates_govt(BigDecimal r0580_non_comm_entity_emirates_govt) {
		this.r0580_non_comm_entity_emirates_govt = r0580_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0580_gre() {
		return r0580_gre;
	}
	public void setR0580_gre(BigDecimal r0580_gre) {
		this.r0580_gre = r0580_gre;
	}
	public BigDecimal getR0580_private_sector_gre() {
		return r0580_private_sector_gre;
	}
	public void setR0580_private_sector_gre(BigDecimal r0580_private_sector_gre) {
		this.r0580_private_sector_gre = r0580_private_sector_gre;
	}
	public BigDecimal getR0580_private_sector_banks() {
		return r0580_private_sector_banks;
	}
	public void setR0580_private_sector_banks(BigDecimal r0580_private_sector_banks) {
		this.r0580_private_sector_banks = r0580_private_sector_banks;
	}
	public BigDecimal getR0580_private_sector_financial_institutions() {
		return r0580_private_sector_financial_institutions;
	}
	public void setR0580_private_sector_financial_institutions(BigDecimal r0580_private_sector_financial_institutions) {
		this.r0580_private_sector_financial_institutions = r0580_private_sector_financial_institutions;
	}
	public BigDecimal getR0580_private_sector_other_private_entities() {
		return r0580_private_sector_other_private_entities;
	}
	public void setR0580_private_sector_other_private_entities(BigDecimal r0580_private_sector_other_private_entities) {
		this.r0580_private_sector_other_private_entities = r0580_private_sector_other_private_entities;
	}
	public BigDecimal getR0580_total_amount() {
		return r0580_total_amount;
	}
	public void setR0580_total_amount(BigDecimal r0580_total_amount) {
		this.r0580_total_amount = r0580_total_amount;
	}
	public String getR0590_product() {
		return r0590_product;
	}
	public void setR0590_product(String r0590_product) {
		this.r0590_product = r0590_product;
	}
	public BigDecimal getR0590_fedaral_govt() {
		return r0590_fedaral_govt;
	}
	public void setR0590_fedaral_govt(BigDecimal r0590_fedaral_govt) {
		this.r0590_fedaral_govt = r0590_fedaral_govt;
	}
	public BigDecimal getR0590_non_comm_entity_fed_govt() {
		return r0590_non_comm_entity_fed_govt;
	}
	public void setR0590_non_comm_entity_fed_govt(BigDecimal r0590_non_comm_entity_fed_govt) {
		this.r0590_non_comm_entity_fed_govt = r0590_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0590_local_govt() {
		return r0590_local_govt;
	}
	public void setR0590_local_govt(BigDecimal r0590_local_govt) {
		this.r0590_local_govt = r0590_local_govt;
	}
	public BigDecimal getR0590_non_comm_entity_emirates_govt() {
		return r0590_non_comm_entity_emirates_govt;
	}
	public void setR0590_non_comm_entity_emirates_govt(BigDecimal r0590_non_comm_entity_emirates_govt) {
		this.r0590_non_comm_entity_emirates_govt = r0590_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0590_gre() {
		return r0590_gre;
	}
	public void setR0590_gre(BigDecimal r0590_gre) {
		this.r0590_gre = r0590_gre;
	}
	public BigDecimal getR0590_private_sector_gre() {
		return r0590_private_sector_gre;
	}
	public void setR0590_private_sector_gre(BigDecimal r0590_private_sector_gre) {
		this.r0590_private_sector_gre = r0590_private_sector_gre;
	}
	public BigDecimal getR0590_private_sector_banks() {
		return r0590_private_sector_banks;
	}
	public void setR0590_private_sector_banks(BigDecimal r0590_private_sector_banks) {
		this.r0590_private_sector_banks = r0590_private_sector_banks;
	}
	public BigDecimal getR0590_private_sector_financial_institutions() {
		return r0590_private_sector_financial_institutions;
	}
	public void setR0590_private_sector_financial_institutions(BigDecimal r0590_private_sector_financial_institutions) {
		this.r0590_private_sector_financial_institutions = r0590_private_sector_financial_institutions;
	}
	public BigDecimal getR0590_private_sector_other_private_entities() {
		return r0590_private_sector_other_private_entities;
	}
	public void setR0590_private_sector_other_private_entities(BigDecimal r0590_private_sector_other_private_entities) {
		this.r0590_private_sector_other_private_entities = r0590_private_sector_other_private_entities;
	}
	public BigDecimal getR0590_total_amount() {
		return r0590_total_amount;
	}
	public void setR0590_total_amount(BigDecimal r0590_total_amount) {
		this.r0590_total_amount = r0590_total_amount;
	}
	public String getR0600_product() {
		return r0600_product;
	}
	public void setR0600_product(String r0600_product) {
		this.r0600_product = r0600_product;
	}
	public BigDecimal getR0600_fedaral_govt() {
		return r0600_fedaral_govt;
	}
	public void setR0600_fedaral_govt(BigDecimal r0600_fedaral_govt) {
		this.r0600_fedaral_govt = r0600_fedaral_govt;
	}
	public BigDecimal getR0600_non_comm_entity_fed_govt() {
		return r0600_non_comm_entity_fed_govt;
	}
	public void setR0600_non_comm_entity_fed_govt(BigDecimal r0600_non_comm_entity_fed_govt) {
		this.r0600_non_comm_entity_fed_govt = r0600_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0600_local_govt() {
		return r0600_local_govt;
	}
	public void setR0600_local_govt(BigDecimal r0600_local_govt) {
		this.r0600_local_govt = r0600_local_govt;
	}
	public BigDecimal getR0600_non_comm_entity_emirates_govt() {
		return r0600_non_comm_entity_emirates_govt;
	}
	public void setR0600_non_comm_entity_emirates_govt(BigDecimal r0600_non_comm_entity_emirates_govt) {
		this.r0600_non_comm_entity_emirates_govt = r0600_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0600_gre() {
		return r0600_gre;
	}
	public void setR0600_gre(BigDecimal r0600_gre) {
		this.r0600_gre = r0600_gre;
	}
	public BigDecimal getR0600_private_sector_gre() {
		return r0600_private_sector_gre;
	}
	public void setR0600_private_sector_gre(BigDecimal r0600_private_sector_gre) {
		this.r0600_private_sector_gre = r0600_private_sector_gre;
	}
	public BigDecimal getR0600_private_sector_banks() {
		return r0600_private_sector_banks;
	}
	public void setR0600_private_sector_banks(BigDecimal r0600_private_sector_banks) {
		this.r0600_private_sector_banks = r0600_private_sector_banks;
	}
	public BigDecimal getR0600_private_sector_financial_institutions() {
		return r0600_private_sector_financial_institutions;
	}
	public void setR0600_private_sector_financial_institutions(BigDecimal r0600_private_sector_financial_institutions) {
		this.r0600_private_sector_financial_institutions = r0600_private_sector_financial_institutions;
	}
	public BigDecimal getR0600_private_sector_other_private_entities() {
		return r0600_private_sector_other_private_entities;
	}
	public void setR0600_private_sector_other_private_entities(BigDecimal r0600_private_sector_other_private_entities) {
		this.r0600_private_sector_other_private_entities = r0600_private_sector_other_private_entities;
	}
	public BigDecimal getR0600_total_amount() {
		return r0600_total_amount;
	}
	public void setR0600_total_amount(BigDecimal r0600_total_amount) {
		this.r0600_total_amount = r0600_total_amount;
	}
	public String getR0610_product() {
		return r0610_product;
	}
	public void setR0610_product(String r0610_product) {
		this.r0610_product = r0610_product;
	}
	public BigDecimal getR0610_fedaral_govt() {
		return r0610_fedaral_govt;
	}
	public void setR0610_fedaral_govt(BigDecimal r0610_fedaral_govt) {
		this.r0610_fedaral_govt = r0610_fedaral_govt;
	}
	public BigDecimal getR0610_non_comm_entity_fed_govt() {
		return r0610_non_comm_entity_fed_govt;
	}
	public void setR0610_non_comm_entity_fed_govt(BigDecimal r0610_non_comm_entity_fed_govt) {
		this.r0610_non_comm_entity_fed_govt = r0610_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0610_local_govt() {
		return r0610_local_govt;
	}
	public void setR0610_local_govt(BigDecimal r0610_local_govt) {
		this.r0610_local_govt = r0610_local_govt;
	}
	public BigDecimal getR0610_non_comm_entity_emirates_govt() {
		return r0610_non_comm_entity_emirates_govt;
	}
	public void setR0610_non_comm_entity_emirates_govt(BigDecimal r0610_non_comm_entity_emirates_govt) {
		this.r0610_non_comm_entity_emirates_govt = r0610_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0610_gre() {
		return r0610_gre;
	}
	public void setR0610_gre(BigDecimal r0610_gre) {
		this.r0610_gre = r0610_gre;
	}
	public BigDecimal getR0610_private_sector_gre() {
		return r0610_private_sector_gre;
	}
	public void setR0610_private_sector_gre(BigDecimal r0610_private_sector_gre) {
		this.r0610_private_sector_gre = r0610_private_sector_gre;
	}
	public BigDecimal getR0610_private_sector_banks() {
		return r0610_private_sector_banks;
	}
	public void setR0610_private_sector_banks(BigDecimal r0610_private_sector_banks) {
		this.r0610_private_sector_banks = r0610_private_sector_banks;
	}
	public BigDecimal getR0610_private_sector_financial_institutions() {
		return r0610_private_sector_financial_institutions;
	}
	public void setR0610_private_sector_financial_institutions(BigDecimal r0610_private_sector_financial_institutions) {
		this.r0610_private_sector_financial_institutions = r0610_private_sector_financial_institutions;
	}
	public BigDecimal getR0610_private_sector_other_private_entities() {
		return r0610_private_sector_other_private_entities;
	}
	public void setR0610_private_sector_other_private_entities(BigDecimal r0610_private_sector_other_private_entities) {
		this.r0610_private_sector_other_private_entities = r0610_private_sector_other_private_entities;
	}
	public BigDecimal getR0610_total_amount() {
		return r0610_total_amount;
	}
	public void setR0610_total_amount(BigDecimal r0610_total_amount) {
		this.r0610_total_amount = r0610_total_amount;
	}
	public String getR0620_product() {
		return r0620_product;
	}
	public void setR0620_product(String r0620_product) {
		this.r0620_product = r0620_product;
	}
	public BigDecimal getR0620_fedaral_govt() {
		return r0620_fedaral_govt;
	}
	public void setR0620_fedaral_govt(BigDecimal r0620_fedaral_govt) {
		this.r0620_fedaral_govt = r0620_fedaral_govt;
	}
	public BigDecimal getR0620_non_comm_entity_fed_govt() {
		return r0620_non_comm_entity_fed_govt;
	}
	public void setR0620_non_comm_entity_fed_govt(BigDecimal r0620_non_comm_entity_fed_govt) {
		this.r0620_non_comm_entity_fed_govt = r0620_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0620_local_govt() {
		return r0620_local_govt;
	}
	public void setR0620_local_govt(BigDecimal r0620_local_govt) {
		this.r0620_local_govt = r0620_local_govt;
	}
	public BigDecimal getR0620_non_comm_entity_emirates_govt() {
		return r0620_non_comm_entity_emirates_govt;
	}
	public void setR0620_non_comm_entity_emirates_govt(BigDecimal r0620_non_comm_entity_emirates_govt) {
		this.r0620_non_comm_entity_emirates_govt = r0620_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0620_gre() {
		return r0620_gre;
	}
	public void setR0620_gre(BigDecimal r0620_gre) {
		this.r0620_gre = r0620_gre;
	}
	public BigDecimal getR0620_private_sector_gre() {
		return r0620_private_sector_gre;
	}
	public void setR0620_private_sector_gre(BigDecimal r0620_private_sector_gre) {
		this.r0620_private_sector_gre = r0620_private_sector_gre;
	}
	public BigDecimal getR0620_private_sector_banks() {
		return r0620_private_sector_banks;
	}
	public void setR0620_private_sector_banks(BigDecimal r0620_private_sector_banks) {
		this.r0620_private_sector_banks = r0620_private_sector_banks;
	}
	public BigDecimal getR0620_private_sector_financial_institutions() {
		return r0620_private_sector_financial_institutions;
	}
	public void setR0620_private_sector_financial_institutions(BigDecimal r0620_private_sector_financial_institutions) {
		this.r0620_private_sector_financial_institutions = r0620_private_sector_financial_institutions;
	}
	public BigDecimal getR0620_private_sector_other_private_entities() {
		return r0620_private_sector_other_private_entities;
	}
	public void setR0620_private_sector_other_private_entities(BigDecimal r0620_private_sector_other_private_entities) {
		this.r0620_private_sector_other_private_entities = r0620_private_sector_other_private_entities;
	}
	public BigDecimal getR0620_total_amount() {
		return r0620_total_amount;
	}
	public void setR0620_total_amount(BigDecimal r0620_total_amount) {
		this.r0620_total_amount = r0620_total_amount;
	}
	public String getR0630_product() {
		return r0630_product;
	}
	public void setR0630_product(String r0630_product) {
		this.r0630_product = r0630_product;
	}
	public BigDecimal getR0630_fedaral_govt() {
		return r0630_fedaral_govt;
	}
	public void setR0630_fedaral_govt(BigDecimal r0630_fedaral_govt) {
		this.r0630_fedaral_govt = r0630_fedaral_govt;
	}
	public BigDecimal getR0630_non_comm_entity_fed_govt() {
		return r0630_non_comm_entity_fed_govt;
	}
	public void setR0630_non_comm_entity_fed_govt(BigDecimal r0630_non_comm_entity_fed_govt) {
		this.r0630_non_comm_entity_fed_govt = r0630_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0630_local_govt() {
		return r0630_local_govt;
	}
	public void setR0630_local_govt(BigDecimal r0630_local_govt) {
		this.r0630_local_govt = r0630_local_govt;
	}
	public BigDecimal getR0630_non_comm_entity_emirates_govt() {
		return r0630_non_comm_entity_emirates_govt;
	}
	public void setR0630_non_comm_entity_emirates_govt(BigDecimal r0630_non_comm_entity_emirates_govt) {
		this.r0630_non_comm_entity_emirates_govt = r0630_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0630_gre() {
		return r0630_gre;
	}
	public void setR0630_gre(BigDecimal r0630_gre) {
		this.r0630_gre = r0630_gre;
	}
	public BigDecimal getR0630_private_sector_gre() {
		return r0630_private_sector_gre;
	}
	public void setR0630_private_sector_gre(BigDecimal r0630_private_sector_gre) {
		this.r0630_private_sector_gre = r0630_private_sector_gre;
	}
	public BigDecimal getR0630_private_sector_banks() {
		return r0630_private_sector_banks;
	}
	public void setR0630_private_sector_banks(BigDecimal r0630_private_sector_banks) {
		this.r0630_private_sector_banks = r0630_private_sector_banks;
	}
	public BigDecimal getR0630_private_sector_financial_institutions() {
		return r0630_private_sector_financial_institutions;
	}
	public void setR0630_private_sector_financial_institutions(BigDecimal r0630_private_sector_financial_institutions) {
		this.r0630_private_sector_financial_institutions = r0630_private_sector_financial_institutions;
	}
	public BigDecimal getR0630_private_sector_other_private_entities() {
		return r0630_private_sector_other_private_entities;
	}
	public void setR0630_private_sector_other_private_entities(BigDecimal r0630_private_sector_other_private_entities) {
		this.r0630_private_sector_other_private_entities = r0630_private_sector_other_private_entities;
	}
	public BigDecimal getR0630_total_amount() {
		return r0630_total_amount;
	}
	public void setR0630_total_amount(BigDecimal r0630_total_amount) {
		this.r0630_total_amount = r0630_total_amount;
	}
	public String getR0640_product() {
		return r0640_product;
	}
	public void setR0640_product(String r0640_product) {
		this.r0640_product = r0640_product;
	}
	public BigDecimal getR0640_fedaral_govt() {
		return r0640_fedaral_govt;
	}
	public void setR0640_fedaral_govt(BigDecimal r0640_fedaral_govt) {
		this.r0640_fedaral_govt = r0640_fedaral_govt;
	}
	public BigDecimal getR0640_non_comm_entity_fed_govt() {
		return r0640_non_comm_entity_fed_govt;
	}
	public void setR0640_non_comm_entity_fed_govt(BigDecimal r0640_non_comm_entity_fed_govt) {
		this.r0640_non_comm_entity_fed_govt = r0640_non_comm_entity_fed_govt;
	}
	public BigDecimal getR0640_local_govt() {
		return r0640_local_govt;
	}
	public void setR0640_local_govt(BigDecimal r0640_local_govt) {
		this.r0640_local_govt = r0640_local_govt;
	}
	public BigDecimal getR0640_non_comm_entity_emirates_govt() {
		return r0640_non_comm_entity_emirates_govt;
	}
	public void setR0640_non_comm_entity_emirates_govt(BigDecimal r0640_non_comm_entity_emirates_govt) {
		this.r0640_non_comm_entity_emirates_govt = r0640_non_comm_entity_emirates_govt;
	}
	public BigDecimal getR0640_gre() {
		return r0640_gre;
	}
	public void setR0640_gre(BigDecimal r0640_gre) {
		this.r0640_gre = r0640_gre;
	}
	public BigDecimal getR0640_private_sector_gre() {
		return r0640_private_sector_gre;
	}
	public void setR0640_private_sector_gre(BigDecimal r0640_private_sector_gre) {
		this.r0640_private_sector_gre = r0640_private_sector_gre;
	}
	public BigDecimal getR0640_private_sector_banks() {
		return r0640_private_sector_banks;
	}
	public void setR0640_private_sector_banks(BigDecimal r0640_private_sector_banks) {
		this.r0640_private_sector_banks = r0640_private_sector_banks;
	}
	public BigDecimal getR0640_private_sector_financial_institutions() {
		return r0640_private_sector_financial_institutions;
	}
	public void setR0640_private_sector_financial_institutions(BigDecimal r0640_private_sector_financial_institutions) {
		this.r0640_private_sector_financial_institutions = r0640_private_sector_financial_institutions;
	}
	public BigDecimal getR0640_private_sector_other_private_entities() {
		return r0640_private_sector_other_private_entities;
	}
	public void setR0640_private_sector_other_private_entities(BigDecimal r0640_private_sector_other_private_entities) {
		this.r0640_private_sector_other_private_entities = r0640_private_sector_other_private_entities;
	}
	public BigDecimal getR0640_total_amount() {
		return r0640_total_amount;
	}
	public void setR0640_total_amount(BigDecimal r0640_total_amount) {
		this.r0640_total_amount = r0640_total_amount;
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
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public CBUAE_BRF7_4_Summary_Archival_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
