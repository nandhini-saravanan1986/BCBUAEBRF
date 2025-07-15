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
@Table(name = "CBUAE_BRF5_17_SUMMARYTABLE")

public class CBUAE_BRF5_17_SUMMARY_ENTITY {

	private String	r0010_product;
	private BigDecimal	r0010_before_resident_individual;
	private BigDecimal	r0010_after_resident_individual;
	private BigDecimal	r0010_before_nonresident_individual;
	private BigDecimal	r0010_after_nonresident_individual;
	private BigDecimal	r0010_before_resident_retail;
	private BigDecimal	r0010_after_resident_retail;
	private BigDecimal	r0010_before_nonresident_retail;
	private BigDecimal	r0010_after_nonresident_retail;
	private BigDecimal	r0010_before_resident_sme;
	private BigDecimal	r0010_after_resident_sme;
	private BigDecimal	r0010_before_nonresident_sme;
	private BigDecimal	r0010_after_nonresident_sme;
	private BigDecimal	r0010_before_resident_hni;
	private BigDecimal	r0010_after_resident_hni;
	private BigDecimal	r0010_before_nonresident_hni;
	private BigDecimal	r0010_after_nonresident_hni;
	private BigDecimal	r0010_before_resident_gre;
	private BigDecimal	r0010_after_resident_gre;
	private BigDecimal	r0010_before_nonresident_gre;
	private BigDecimal	r0010_after_nonresident_gre;
	private BigDecimal	r0010_before_resident_corporate;
	private BigDecimal	r0010_after_resident_corporate;
	private BigDecimal	r0010_before_nonresident_corporate;
	private BigDecimal	r0010_after_nonresident_corporate;
	private BigDecimal	r0010_before_resident_nbfi;
	private BigDecimal	r0010_after_resident_nbfi;
	private BigDecimal	r0010_before_nonresident_nbfi;
	private BigDecimal	r0010_after_nonresident_nbfi;
	private BigDecimal	r0010_before_resident_bank;
	private BigDecimal	r0010_after_resident_bank;
	private BigDecimal	r0010_before_nonresident_bank;
	private BigDecimal	r0010_after_nonresident_bank;
	private BigDecimal	r0010_before_resident_government;
	private BigDecimal	r0010_after_resident_government;
	private BigDecimal	r0010_before_nonresident_government;
	private BigDecimal	r0010_after_nonresident_government;
	private String	r0020_product;
	private BigDecimal	r0020_before_resident_individual;
	private BigDecimal	r0020_after_resident_individual;
	private BigDecimal	r0020_before_nonresident_individual;
	private BigDecimal	r0020_after_nonresident_individual;
	private BigDecimal	r0020_before_resident_retail;
	private BigDecimal	r0020_after_resident_retail;
	private BigDecimal	r0020_before_nonresident_retail;
	private BigDecimal	r0020_after_nonresident_retail;
	private BigDecimal	r0020_before_resident_sme;
	private BigDecimal	r0020_after_resident_sme;
	private BigDecimal	r0020_before_nonresident_sme;
	private BigDecimal	r0020_after_nonresident_sme;
	private BigDecimal	r0020_before_resident_hni;
	private BigDecimal	r0020_after_resident_hni;
	private BigDecimal	r0020_before_nonresident_hni;
	private BigDecimal	r0020_after_nonresident_hni;
	private BigDecimal	r0020_before_resident_gre;
	private BigDecimal	r0020_after_resident_gre;
	private BigDecimal	r0020_before_nonresident_gre;
	private BigDecimal	r0020_after_nonresident_gre;
	private BigDecimal	r0020_before_resident_corporate;
	private BigDecimal	r0020_after_resident_corporate;
	private BigDecimal	r0020_before_nonresident_corporate;
	private BigDecimal	r0020_after_nonresident_corporate;
	private BigDecimal	r0020_before_resident_nbfi;
	private BigDecimal	r0020_after_resident_nbfi;
	private BigDecimal	r0020_before_nonresident_nbfi;
	private BigDecimal	r0020_after_nonresident_nbfi;
	private BigDecimal	r0020_before_resident_bank;
	private BigDecimal	r0020_after_resident_bank;
	private BigDecimal	r0020_before_nonresident_bank;
	private BigDecimal	r0020_after_nonresident_bank;
	private BigDecimal	r0020_before_resident_government;
	private BigDecimal	r0020_after_resident_government;
	private BigDecimal	r0020_before_nonresident_government;
	private BigDecimal	r0020_after_nonresident_government;
	private String	r0030_product;
	private BigDecimal	r0030_before_resident_individual;
	private BigDecimal	r0030_after_resident_individual;
	private BigDecimal	r0030_before_nonresident_individual;
	private BigDecimal	r0030_after_nonresident_individual;
	private BigDecimal	r0030_before_resident_retail;
	private BigDecimal	r0030_after_resident_retail;
	private BigDecimal	r0030_before_nonresident_retail;
	private BigDecimal	r0030_after_nonresident_retail;
	private BigDecimal	r0030_before_resident_sme;
	private BigDecimal	r0030_after_resident_sme;
	private BigDecimal	r0030_before_nonresident_sme;
	private BigDecimal	r0030_after_nonresident_sme;
	private BigDecimal	r0030_before_resident_hni;
	private BigDecimal	r0030_after_resident_hni;
	private BigDecimal	r0030_before_nonresident_hni;
	private BigDecimal	r0030_after_nonresident_hni;
	private BigDecimal	r0030_before_resident_gre;
	private BigDecimal	r0030_after_resident_gre;
	private BigDecimal	r0030_before_nonresident_gre;
	private BigDecimal	r0030_after_nonresident_gre;
	private BigDecimal	r0030_before_resident_corporate;
	private BigDecimal	r0030_after_resident_corporate;
	private BigDecimal	r0030_before_nonresident_corporate;
	private BigDecimal	r0030_after_nonresident_corporate;
	private BigDecimal	r0030_before_resident_nbfi;
	private BigDecimal	r0030_after_resident_nbfi;
	private BigDecimal	r0030_before_nonresident_nbfi;
	private BigDecimal	r0030_after_nonresident_nbfi;
	private BigDecimal	r0030_before_resident_bank;
	private BigDecimal	r0030_after_resident_bank;
	private BigDecimal	r0030_before_nonresident_bank;
	private BigDecimal	r0030_after_nonresident_bank;
	private BigDecimal	r0030_before_resident_government;
	private BigDecimal	r0030_after_resident_government;
	private BigDecimal	r0030_before_nonresident_government;
	private BigDecimal	r0030_after_nonresident_government;
	private String	r0040_product;
	private BigDecimal	r0040_before_resident_individual;
	private BigDecimal	r0040_after_resident_individual;
	private BigDecimal	r0040_before_nonresident_individual;
	private BigDecimal	r0040_after_nonresident_individual;
	private BigDecimal	r0040_before_resident_retail;
	private BigDecimal	r0040_after_resident_retail;
	private BigDecimal	r0040_before_nonresident_retail;
	private BigDecimal	r0040_after_nonresident_retail;
	private BigDecimal	r0040_before_resident_sme;
	private BigDecimal	r0040_after_resident_sme;
	private BigDecimal	r0040_before_nonresident_sme;
	private BigDecimal	r0040_after_nonresident_sme;
	private BigDecimal	r0040_before_resident_hni;
	private BigDecimal	r0040_after_resident_hni;
	private BigDecimal	r0040_before_nonresident_hni;
	private BigDecimal	r0040_after_nonresident_hni;
	private BigDecimal	r0040_before_resident_gre;
	private BigDecimal	r0040_after_resident_gre;
	private BigDecimal	r0040_before_nonresident_gre;
	private BigDecimal	r0040_after_nonresident_gre;
	private BigDecimal	r0040_before_resident_corporate;
	private BigDecimal	r0040_after_resident_corporate;
	private BigDecimal	r0040_before_nonresident_corporate;
	private BigDecimal	r0040_after_nonresident_corporate;
	private BigDecimal	r0040_before_resident_nbfi;
	private BigDecimal	r0040_after_resident_nbfi;
	private BigDecimal	r0040_before_nonresident_nbfi;
	private BigDecimal	r0040_after_nonresident_nbfi;
	private BigDecimal	r0040_before_resident_bank;
	private BigDecimal	r0040_after_resident_bank;
	private BigDecimal	r0040_before_nonresident_bank;
	private BigDecimal	r0040_after_nonresident_bank;
	private BigDecimal	r0040_before_resident_government;
	private BigDecimal	r0040_after_resident_government;
	private BigDecimal	r0040_before_nonresident_government;
	private BigDecimal	r0040_after_nonresident_government;
	private String	r0050_product;
	private BigDecimal	r0050_before_resident_individual;
	private BigDecimal	r0050_after_resident_individual;
	private BigDecimal	r0050_before_nonresident_individual;
	private BigDecimal	r0050_after_nonresident_individual;
	private BigDecimal	r0050_before_resident_retail;
	private BigDecimal	r0050_after_resident_retail;
	private BigDecimal	r0050_before_nonresident_retail;
	private BigDecimal	r0050_after_nonresident_retail;
	private BigDecimal	r0050_before_resident_sme;
	private BigDecimal	r0050_after_resident_sme;
	private BigDecimal	r0050_before_nonresident_sme;
	private BigDecimal	r0050_after_nonresident_sme;
	private BigDecimal	r0050_before_resident_hni;
	private BigDecimal	r0050_after_resident_hni;
	private BigDecimal	r0050_before_nonresident_hni;
	private BigDecimal	r0050_after_nonresident_hni;
	private BigDecimal	r0050_before_resident_gre;
	private BigDecimal	r0050_after_resident_gre;
	private BigDecimal	r0050_before_nonresident_gre;
	private BigDecimal	r0050_after_nonresident_gre;
	private BigDecimal	r0050_before_resident_corporate;
	private BigDecimal	r0050_after_resident_corporate;
	private BigDecimal	r0050_before_nonresident_corporate;
	private BigDecimal	r0050_after_nonresident_corporate;
	private BigDecimal	r0050_before_resident_nbfi;
	private BigDecimal	r0050_after_resident_nbfi;
	private BigDecimal	r0050_before_nonresident_nbfi;
	private BigDecimal	r0050_after_nonresident_nbfi;
	private BigDecimal	r0050_before_resident_bank;
	private BigDecimal	r0050_after_resident_bank;
	private BigDecimal	r0050_before_nonresident_bank;
	private BigDecimal	r0050_after_nonresident_bank;
	private BigDecimal	r0050_before_resident_government;
	private BigDecimal	r0050_after_resident_government;
	private BigDecimal	r0050_before_nonresident_government;
	private BigDecimal	r0050_after_nonresident_government;
	private String	r0060_product;
	private BigDecimal	r0060_before_resident_individual;
	private BigDecimal	r0060_after_resident_individual;
	private BigDecimal	r0060_before_nonresident_individual;
	private BigDecimal	r0060_after_nonresident_individual;
	private BigDecimal	r0060_before_resident_retail;
	private BigDecimal	r0060_after_resident_retail;
	private BigDecimal	r0060_before_nonresident_retail;
	private BigDecimal	r0060_after_nonresident_retail;
	private BigDecimal	r0060_before_resident_sme;
	private BigDecimal	r0060_after_resident_sme;
	private BigDecimal	r0060_before_nonresident_sme;
	private BigDecimal	r0060_after_nonresident_sme;
	private BigDecimal	r0060_before_resident_hni;
	private BigDecimal	r0060_after_resident_hni;
	private BigDecimal	r0060_before_nonresident_hni;
	private BigDecimal	r0060_after_nonresident_hni;
	private BigDecimal	r0060_before_resident_gre;
	private BigDecimal	r0060_after_resident_gre;
	private BigDecimal	r0060_before_nonresident_gre;
	private BigDecimal	r0060_after_nonresident_gre;
	private BigDecimal	r0060_before_resident_corporate;
	private BigDecimal	r0060_after_resident_corporate;
	private BigDecimal	r0060_before_nonresident_corporate;
	private BigDecimal	r0060_after_nonresident_corporate;
	private BigDecimal	r0060_before_resident_nbfi;
	private BigDecimal	r0060_after_resident_nbfi;
	private BigDecimal	r0060_before_nonresident_nbfi;
	private BigDecimal	r0060_after_nonresident_nbfi;
	private BigDecimal	r0060_before_resident_bank;
	private BigDecimal	r0060_after_resident_bank;
	private BigDecimal	r0060_before_nonresident_bank;
	private BigDecimal	r0060_after_nonresident_bank;
	private BigDecimal	r0060_before_resident_government;
	private BigDecimal	r0060_after_resident_government;
	private BigDecimal	r0060_before_nonresident_government;
	private BigDecimal	r0060_after_nonresident_government;
	private String	r0070_product;
	private BigDecimal	r0070_before_resident_individual;
	private BigDecimal	r0070_after_resident_individual;
	private BigDecimal	r0070_before_nonresident_individual;
	private BigDecimal	r0070_after_nonresident_individual;
	private BigDecimal	r0070_before_resident_retail;
	private BigDecimal	r0070_after_resident_retail;
	private BigDecimal	r0070_before_nonresident_retail;
	private BigDecimal	r0070_after_nonresident_retail;
	private BigDecimal	r0070_before_resident_sme;
	private BigDecimal	r0070_after_resident_sme;
	private BigDecimal	r0070_before_nonresident_sme;
	private BigDecimal	r0070_after_nonresident_sme;
	private BigDecimal	r0070_before_resident_hni;
	private BigDecimal	r0070_after_resident_hni;
	private BigDecimal	r0070_before_nonresident_hni;
	private BigDecimal	r0070_after_nonresident_hni;
	private BigDecimal	r0070_before_resident_gre;
	private BigDecimal	r0070_after_resident_gre;
	private BigDecimal	r0070_before_nonresident_gre;
	private BigDecimal	r0070_after_nonresident_gre;
	private BigDecimal	r0070_before_resident_corporate;
	private BigDecimal	r0070_after_resident_corporate;
	private BigDecimal	r0070_before_nonresident_corporate;
	private BigDecimal	r0070_after_nonresident_corporate;
	private BigDecimal	r0070_before_resident_nbfi;
	private BigDecimal	r0070_after_resident_nbfi;
	private BigDecimal	r0070_before_nonresident_nbfi;
	private BigDecimal	r0070_after_nonresident_nbfi;
	private BigDecimal	r0070_before_resident_bank;
	private BigDecimal	r0070_after_resident_bank;
	private BigDecimal	r0070_before_nonresident_bank;
	private BigDecimal	r0070_after_nonresident_bank;
	private BigDecimal	r0070_before_resident_government;
	private BigDecimal	r0070_after_resident_government;
	private BigDecimal	r0070_before_nonresident_government;
	private BigDecimal	r0070_after_nonresident_government;
	private String	r0080_product;
	private BigDecimal	r0080_before_resident_individual;
	private BigDecimal	r0080_after_resident_individual;
	private BigDecimal	r0080_before_nonresident_individual;
	private BigDecimal	r0080_after_nonresident_individual;
	private BigDecimal	r0080_before_resident_retail;
	private BigDecimal	r0080_after_resident_retail;
	private BigDecimal	r0080_before_nonresident_retail;
	private BigDecimal	r0080_after_nonresident_retail;
	private BigDecimal	r0080_before_resident_sme;
	private BigDecimal	r0080_after_resident_sme;
	private BigDecimal	r0080_before_nonresident_sme;
	private BigDecimal	r0080_after_nonresident_sme;
	private BigDecimal	r0080_before_resident_hni;
	private BigDecimal	r0080_after_resident_hni;
	private BigDecimal	r0080_before_nonresident_hni;
	private BigDecimal	r0080_after_nonresident_hni;
	private BigDecimal	r0080_before_resident_gre;
	private BigDecimal	r0080_after_resident_gre;
	private BigDecimal	r0080_before_nonresident_gre;
	private BigDecimal	r0080_after_nonresident_gre;
	private BigDecimal	r0080_before_resident_corporate;
	private BigDecimal	r0080_after_resident_corporate;
	private BigDecimal	r0080_before_nonresident_corporate;
	private BigDecimal	r0080_after_nonresident_corporate;
	private BigDecimal	r0080_before_resident_nbfi;
	private BigDecimal	r0080_after_resident_nbfi;
	private BigDecimal	r0080_before_nonresident_nbfi;
	private BigDecimal	r0080_after_nonresident_nbfi;
	private BigDecimal	r0080_before_resident_bank;
	private BigDecimal	r0080_after_resident_bank;
	private BigDecimal	r0080_before_nonresident_bank;
	private BigDecimal	r0080_after_nonresident_bank;
	private BigDecimal	r0080_before_resident_government;
	private BigDecimal	r0080_after_resident_government;
	private BigDecimal	r0080_before_nonresident_government;
	private BigDecimal	r0080_after_nonresident_government;
	private String	r0090_product;
	private BigDecimal	r0090_before_resident_individual;
	private BigDecimal	r0090_after_resident_individual;
	private BigDecimal	r0090_before_nonresident_individual;
	private BigDecimal	r0090_after_nonresident_individual;
	private BigDecimal	r0090_before_resident_retail;
	private BigDecimal	r0090_after_resident_retail;
	private BigDecimal	r0090_before_nonresident_retail;
	private BigDecimal	r0090_after_nonresident_retail;
	private BigDecimal	r0090_before_resident_sme;
	private BigDecimal	r0090_after_resident_sme;
	private BigDecimal	r0090_before_nonresident_sme;
	private BigDecimal	r0090_after_nonresident_sme;
	private BigDecimal	r0090_before_resident_hni;
	private BigDecimal	r0090_after_resident_hni;
	private BigDecimal	r0090_before_nonresident_hni;
	private BigDecimal	r0090_after_nonresident_hni;
	private BigDecimal	r0090_before_resident_gre;
	private BigDecimal	r0090_after_resident_gre;
	private BigDecimal	r0090_before_nonresident_gre;
	private BigDecimal	r0090_after_nonresident_gre;
	private BigDecimal	r0090_before_resident_corporate;
	private BigDecimal	r0090_after_resident_corporate;
	private BigDecimal	r0090_before_nonresident_corporate;
	private BigDecimal	r0090_after_nonresident_corporate;
	private BigDecimal	r0090_before_resident_nbfi;
	private BigDecimal	r0090_after_resident_nbfi;
	private BigDecimal	r0090_before_nonresident_nbfi;
	private BigDecimal	r0090_after_nonresident_nbfi;
	private BigDecimal	r0090_before_resident_bank;
	private BigDecimal	r0090_after_resident_bank;
	private BigDecimal	r0090_before_nonresident_bank;
	private BigDecimal	r0090_after_nonresident_bank;
	private BigDecimal	r0090_before_resident_government;
	private BigDecimal	r0090_after_resident_government;
	private BigDecimal	r0090_before_nonresident_government;
	private BigDecimal	r0090_after_nonresident_government;
	private String	r0100_product;
	private BigDecimal	r0100_before_resident_individual;
	private BigDecimal	r0100_after_resident_individual;
	private BigDecimal	r0100_before_nonresident_individual;
	private BigDecimal	r0100_after_nonresident_individual;
	private BigDecimal	r0100_before_resident_retail;
	private BigDecimal	r0100_after_resident_retail;
	private BigDecimal	r0100_before_nonresident_retail;
	private BigDecimal	r0100_after_nonresident_retail;
	private BigDecimal	r0100_before_resident_sme;
	private BigDecimal	r0100_after_resident_sme;
	private BigDecimal	r0100_before_nonresident_sme;
	private BigDecimal	r0100_after_nonresident_sme;
	private BigDecimal	r0100_before_resident_hni;
	private BigDecimal	r0100_after_resident_hni;
	private BigDecimal	r0100_before_nonresident_hni;
	private BigDecimal	r0100_after_nonresident_hni;
	private BigDecimal	r0100_before_resident_gre;
	private BigDecimal	r0100_after_resident_gre;
	private BigDecimal	r0100_before_nonresident_gre;
	private BigDecimal	r0100_after_nonresident_gre;
	private BigDecimal	r0100_before_resident_corporate;
	private BigDecimal	r0100_after_resident_corporate;
	private BigDecimal	r0100_before_nonresident_corporate;
	private BigDecimal	r0100_after_nonresident_corporate;
	private BigDecimal	r0100_before_resident_nbfi;
	private BigDecimal	r0100_after_resident_nbfi;
	private BigDecimal	r0100_before_nonresident_nbfi;
	private BigDecimal	r0100_after_nonresident_nbfi;
	private BigDecimal	r0100_before_resident_bank;
	private BigDecimal	r0100_after_resident_bank;
	private BigDecimal	r0100_before_nonresident_bank;
	private BigDecimal	r0100_after_nonresident_bank;
	private BigDecimal	r0100_before_resident_government;
	private BigDecimal	r0100_after_resident_government;
	private BigDecimal	r0100_before_nonresident_government;
	private BigDecimal	r0100_after_nonresident_government;
	private String	r0110_product;
	private BigDecimal	r0110_before_resident_individual;
	private BigDecimal	r0110_after_resident_individual;
	private BigDecimal	r0110_before_nonresident_individual;
	private BigDecimal	r0110_after_nonresident_individual;
	private BigDecimal	r0110_before_resident_retail;
	private BigDecimal	r0110_after_resident_retail;
	private BigDecimal	r0110_before_nonresident_retail;
	private BigDecimal	r0110_after_nonresident_retail;
	private BigDecimal	r0110_before_resident_sme;
	private BigDecimal	r0110_after_resident_sme;
	private BigDecimal	r0110_before_nonresident_sme;
	private BigDecimal	r0110_after_nonresident_sme;
	private BigDecimal	r0110_before_resident_hni;
	private BigDecimal	r0110_after_resident_hni;
	private BigDecimal	r0110_before_nonresident_hni;
	private BigDecimal	r0110_after_nonresident_hni;
	private BigDecimal	r0110_before_resident_gre;
	private BigDecimal	r0110_after_resident_gre;
	private BigDecimal	r0110_before_nonresident_gre;
	private BigDecimal	r0110_after_nonresident_gre;
	private BigDecimal	r0110_before_resident_corporate;
	private BigDecimal	r0110_after_resident_corporate;
	private BigDecimal	r0110_before_nonresident_corporate;
	private BigDecimal	r0110_after_nonresident_corporate;
	private BigDecimal	r0110_before_resident_nbfi;
	private BigDecimal	r0110_after_resident_nbfi;
	private BigDecimal	r0110_before_nonresident_nbfi;
	private BigDecimal	r0110_after_nonresident_nbfi;
	private BigDecimal	r0110_before_resident_bank;
	private BigDecimal	r0110_after_resident_bank;
	private BigDecimal	r0110_before_nonresident_bank;
	private BigDecimal	r0110_after_nonresident_bank;
	private BigDecimal	r0110_before_resident_government;
	private BigDecimal	r0110_after_resident_government;
	private BigDecimal	r0110_before_nonresident_government;
	private BigDecimal	r0110_after_nonresident_government;
	private String	r0120_product;
	private BigDecimal	r0120_before_resident_individual;
	private BigDecimal	r0120_after_resident_individual;
	private BigDecimal	r0120_before_nonresident_individual;
	private BigDecimal	r0120_after_nonresident_individual;
	private BigDecimal	r0120_before_resident_retail;
	private BigDecimal	r0120_after_resident_retail;
	private BigDecimal	r0120_before_nonresident_retail;
	private BigDecimal	r0120_after_nonresident_retail;
	private BigDecimal	r0120_before_resident_sme;
	private BigDecimal	r0120_after_resident_sme;
	private BigDecimal	r0120_before_nonresident_sme;
	private BigDecimal	r0120_after_nonresident_sme;
	private BigDecimal	r0120_before_resident_hni;
	private BigDecimal	r0120_after_resident_hni;
	private BigDecimal	r0120_before_nonresident_hni;
	private BigDecimal	r0120_after_nonresident_hni;
	private BigDecimal	r0120_before_resident_gre;
	private BigDecimal	r0120_after_resident_gre;
	private BigDecimal	r0120_before_nonresident_gre;
	private BigDecimal	r0120_after_nonresident_gre;
	private BigDecimal	r0120_before_resident_corporate;
	private BigDecimal	r0120_after_resident_corporate;
	private BigDecimal	r0120_before_nonresident_corporate;
	private BigDecimal	r0120_after_nonresident_corporate;
	private BigDecimal	r0120_before_resident_nbfi;
	private BigDecimal	r0120_after_resident_nbfi;
	private BigDecimal	r0120_before_nonresident_nbfi;
	private BigDecimal	r0120_after_nonresident_nbfi;
	private BigDecimal	r0120_before_resident_bank;
	private BigDecimal	r0120_after_resident_bank;
	private BigDecimal	r0120_before_nonresident_bank;
	private BigDecimal	r0120_after_nonresident_bank;
	private BigDecimal	r0120_before_resident_government;
	private BigDecimal	r0120_after_resident_government;
	private BigDecimal	r0120_before_nonresident_government;
	private BigDecimal	r0120_after_nonresident_government;
	private String	r0130_product;
	private BigDecimal	r0130_before_resident_individual;
	private BigDecimal	r0130_after_resident_individual;
	private BigDecimal	r0130_before_nonresident_individual;
	private BigDecimal	r0130_after_nonresident_individual;
	private BigDecimal	r0130_before_resident_retail;
	private BigDecimal	r0130_after_resident_retail;
	private BigDecimal	r0130_before_nonresident_retail;
	private BigDecimal	r0130_after_nonresident_retail;
	private BigDecimal	r0130_before_resident_sme;
	private BigDecimal	r0130_after_resident_sme;
	private BigDecimal	r0130_before_nonresident_sme;
	private BigDecimal	r0130_after_nonresident_sme;
	private BigDecimal	r0130_before_resident_hni;
	private BigDecimal	r0130_after_resident_hni;
	private BigDecimal	r0130_before_nonresident_hni;
	private BigDecimal	r0130_after_nonresident_hni;
	private BigDecimal	r0130_before_resident_gre;
	private BigDecimal	r0130_after_resident_gre;
	private BigDecimal	r0130_before_nonresident_gre;
	private BigDecimal	r0130_after_nonresident_gre;
	private BigDecimal	r0130_before_resident_corporate;
	private BigDecimal	r0130_after_resident_corporate;
	private BigDecimal	r0130_before_nonresident_corporate;
	private BigDecimal	r0130_after_nonresident_corporate;
	private BigDecimal	r0130_before_resident_nbfi;
	private BigDecimal	r0130_after_resident_nbfi;
	private BigDecimal	r0130_before_nonresident_nbfi;
	private BigDecimal	r0130_after_nonresident_nbfi;
	private BigDecimal	r0130_before_resident_bank;
	private BigDecimal	r0130_after_resident_bank;
	private BigDecimal	r0130_before_nonresident_bank;
	private BigDecimal	r0130_after_nonresident_bank;
	private BigDecimal	r0130_before_resident_government;
	private BigDecimal	r0130_after_resident_government;
	private BigDecimal	r0130_before_nonresident_government;
	private BigDecimal	r0130_after_nonresident_government;
	private String	r0140_product;
	private BigDecimal	r0140_before_resident_individual;
	private BigDecimal	r0140_after_resident_individual;
	private BigDecimal	r0140_before_nonresident_individual;
	private BigDecimal	r0140_after_nonresident_individual;
	private BigDecimal	r0140_before_resident_retail;
	private BigDecimal	r0140_after_resident_retail;
	private BigDecimal	r0140_before_nonresident_retail;
	private BigDecimal	r0140_after_nonresident_retail;
	private BigDecimal	r0140_before_resident_sme;
	private BigDecimal	r0140_after_resident_sme;
	private BigDecimal	r0140_before_nonresident_sme;
	private BigDecimal	r0140_after_nonresident_sme;
	private BigDecimal	r0140_before_resident_hni;
	private BigDecimal	r0140_after_resident_hni;
	private BigDecimal	r0140_before_nonresident_hni;
	private BigDecimal	r0140_after_nonresident_hni;
	private BigDecimal	r0140_before_resident_gre;
	private BigDecimal	r0140_after_resident_gre;
	private BigDecimal	r0140_before_nonresident_gre;
	private BigDecimal	r0140_after_nonresident_gre;
	private BigDecimal	r0140_before_resident_corporate;
	private BigDecimal	r0140_after_resident_corporate;
	private BigDecimal	r0140_before_nonresident_corporate;
	private BigDecimal	r0140_after_nonresident_corporate;
	private BigDecimal	r0140_before_resident_nbfi;
	private BigDecimal	r0140_after_resident_nbfi;
	private BigDecimal	r0140_before_nonresident_nbfi;
	private BigDecimal	r0140_after_nonresident_nbfi;
	private BigDecimal	r0140_before_resident_bank;
	private BigDecimal	r0140_after_resident_bank;
	private BigDecimal	r0140_before_nonresident_bank;
	private BigDecimal	r0140_after_nonresident_bank;
	private BigDecimal	r0140_before_resident_government;
	private BigDecimal	r0140_after_resident_government;
	private BigDecimal	r0140_before_nonresident_government;
	private BigDecimal	r0140_after_nonresident_government;
	private String	r0150_product;
	private BigDecimal	r0150_before_resident_individual;
	private BigDecimal	r0150_after_resident_individual;
	private BigDecimal	r0150_before_nonresident_individual;
	private BigDecimal	r0150_after_nonresident_individual;
	private BigDecimal	r0150_before_resident_retail;
	private BigDecimal	r0150_after_resident_retail;
	private BigDecimal	r0150_before_nonresident_retail;
	private BigDecimal	r0150_after_nonresident_retail;
	private BigDecimal	r0150_before_resident_sme;
	private BigDecimal	r0150_after_resident_sme;
	private BigDecimal	r0150_before_nonresident_sme;
	private BigDecimal	r0150_after_nonresident_sme;
	private BigDecimal	r0150_before_resident_hni;
	private BigDecimal	r0150_after_resident_hni;
	private BigDecimal	r0150_before_nonresident_hni;
	private BigDecimal	r0150_after_nonresident_hni;
	private BigDecimal	r0150_before_resident_gre;
	private BigDecimal	r0150_after_resident_gre;
	private BigDecimal	r0150_before_nonresident_gre;
	private BigDecimal	r0150_after_nonresident_gre;
	private BigDecimal	r0150_before_resident_corporate;
	private BigDecimal	r0150_after_resident_corporate;
	private BigDecimal	r0150_before_nonresident_corporate;
	private BigDecimal	r0150_after_nonresident_corporate;
	private BigDecimal	r0150_before_resident_nbfi;
	private BigDecimal	r0150_after_resident_nbfi;
	private BigDecimal	r0150_before_nonresident_nbfi;
	private BigDecimal	r0150_after_nonresident_nbfi;
	private BigDecimal	r0150_before_resident_bank;
	private BigDecimal	r0150_after_resident_bank;
	private BigDecimal	r0150_before_nonresident_bank;
	private BigDecimal	r0150_after_nonresident_bank;
	private BigDecimal	r0150_before_resident_government;
	private BigDecimal	r0150_after_resident_government;
	private BigDecimal	r0150_before_nonresident_government;
	private BigDecimal	r0150_after_nonresident_government;
	private String	r0160_product;
	private BigDecimal	r0160_before_resident_individual;
	private BigDecimal	r0160_after_resident_individual;
	private BigDecimal	r0160_before_nonresident_individual;
	private BigDecimal	r0160_after_nonresident_individual;
	private BigDecimal	r0160_before_resident_retail;
	private BigDecimal	r0160_after_resident_retail;
	private BigDecimal	r0160_before_nonresident_retail;
	private BigDecimal	r0160_after_nonresident_retail;
	private BigDecimal	r0160_before_resident_sme;
	private BigDecimal	r0160_after_resident_sme;
	private BigDecimal	r0160_before_nonresident_sme;
	private BigDecimal	r0160_after_nonresident_sme;
	private BigDecimal	r0160_before_resident_hni;
	private BigDecimal	r0160_after_resident_hni;
	private BigDecimal	r0160_before_nonresident_hni;
	private BigDecimal	r0160_after_nonresident_hni;
	private BigDecimal	r0160_before_resident_gre;
	private BigDecimal	r0160_after_resident_gre;
	private BigDecimal	r0160_before_nonresident_gre;
	private BigDecimal	r0160_after_nonresident_gre;
	private BigDecimal	r0160_before_resident_corporate;
	private BigDecimal	r0160_after_resident_corporate;
	private BigDecimal	r0160_before_nonresident_corporate;
	private BigDecimal	r0160_after_nonresident_corporate;
	private BigDecimal	r0160_before_resident_nbfi;
	private BigDecimal	r0160_after_resident_nbfi;
	private BigDecimal	r0160_before_nonresident_nbfi;
	private BigDecimal	r0160_after_nonresident_nbfi;
	private BigDecimal	r0160_before_resident_bank;
	private BigDecimal	r0160_after_resident_bank;
	private BigDecimal	r0160_before_nonresident_bank;
	private BigDecimal	r0160_after_nonresident_bank;
	private BigDecimal	r0160_before_resident_government;
	private BigDecimal	r0160_after_resident_government;
	private BigDecimal	r0160_before_nonresident_government;
	private BigDecimal	r0160_after_nonresident_government;
	private String	r0170_product;
	private BigDecimal	r0170_before_resident_individual;
	private BigDecimal	r0170_after_resident_individual;
	private BigDecimal	r0170_before_nonresident_individual;
	private BigDecimal	r0170_after_nonresident_individual;
	private BigDecimal	r0170_before_resident_retail;
	private BigDecimal	r0170_after_resident_retail;
	private BigDecimal	r0170_before_nonresident_retail;
	private BigDecimal	r0170_after_nonresident_retail;
	private BigDecimal	r0170_before_resident_sme;
	private BigDecimal	r0170_after_resident_sme;
	private BigDecimal	r0170_before_nonresident_sme;
	private BigDecimal	r0170_after_nonresident_sme;
	private BigDecimal	r0170_before_resident_hni;
	private BigDecimal	r0170_after_resident_hni;
	private BigDecimal	r0170_before_nonresident_hni;
	private BigDecimal	r0170_after_nonresident_hni;
	private BigDecimal	r0170_before_resident_gre;
	private BigDecimal	r0170_after_resident_gre;
	private BigDecimal	r0170_before_nonresident_gre;
	private BigDecimal	r0170_after_nonresident_gre;
	private BigDecimal	r0170_before_resident_corporate;
	private BigDecimal	r0170_after_resident_corporate;
	private BigDecimal	r0170_before_nonresident_corporate;
	private BigDecimal	r0170_after_nonresident_corporate;
	private BigDecimal	r0170_before_resident_nbfi;
	private BigDecimal	r0170_after_resident_nbfi;
	private BigDecimal	r0170_before_nonresident_nbfi;
	private BigDecimal	r0170_after_nonresident_nbfi;
	private BigDecimal	r0170_before_resident_bank;
	private BigDecimal	r0170_after_resident_bank;
	private BigDecimal	r0170_before_nonresident_bank;
	private BigDecimal	r0170_after_nonresident_bank;
	private BigDecimal	r0170_before_resident_government;
	private BigDecimal	r0170_after_resident_government;
	private BigDecimal	r0170_before_nonresident_government;
	private BigDecimal	r0170_after_nonresident_government;
	private String	r0180_product;
	private BigDecimal	r0180_before_resident_individual;
	private BigDecimal	r0180_after_resident_individual;
	private BigDecimal	r0180_before_nonresident_individual;
	private BigDecimal	r0180_after_nonresident_individual;
	private BigDecimal	r0180_before_resident_retail;
	private BigDecimal	r0180_after_resident_retail;
	private BigDecimal	r0180_before_nonresident_retail;
	private BigDecimal	r0180_after_nonresident_retail;
	private BigDecimal	r0180_before_resident_sme;
	private BigDecimal	r0180_after_resident_sme;
	private BigDecimal	r0180_before_nonresident_sme;
	private BigDecimal	r0180_after_nonresident_sme;
	private BigDecimal	r0180_before_resident_hni;
	private BigDecimal	r0180_after_resident_hni;
	private BigDecimal	r0180_before_nonresident_hni;
	private BigDecimal	r0180_after_nonresident_hni;
	private BigDecimal	r0180_before_resident_gre;
	private BigDecimal	r0180_after_resident_gre;
	private BigDecimal	r0180_before_nonresident_gre;
	private BigDecimal	r0180_after_nonresident_gre;
	private BigDecimal	r0180_before_resident_corporate;
	private BigDecimal	r0180_after_resident_corporate;
	private BigDecimal	r0180_before_nonresident_corporate;
	private BigDecimal	r0180_after_nonresident_corporate;
	private BigDecimal	r0180_before_resident_nbfi;
	private BigDecimal	r0180_after_resident_nbfi;
	private BigDecimal	r0180_before_nonresident_nbfi;
	private BigDecimal	r0180_after_nonresident_nbfi;
	private BigDecimal	r0180_before_resident_bank;
	private BigDecimal	r0180_after_resident_bank;
	private BigDecimal	r0180_before_nonresident_bank;
	private BigDecimal	r0180_after_nonresident_bank;
	private BigDecimal	r0180_before_resident_government;
	private BigDecimal	r0180_after_resident_government;
	private BigDecimal	r0180_before_nonresident_government;
	private BigDecimal	r0180_after_nonresident_government;
	private String	r0190_product;
	private BigDecimal	r0190_before_resident_individual;
	private BigDecimal	r0190_after_resident_individual;
	private BigDecimal	r0190_before_nonresident_individual;
	private BigDecimal	r0190_after_nonresident_individual;
	private BigDecimal	r0190_before_resident_retail;
	private BigDecimal	r0190_after_resident_retail;
	private BigDecimal	r0190_before_nonresident_retail;
	private BigDecimal	r0190_after_nonresident_retail;
	private BigDecimal	r0190_before_resident_sme;
	private BigDecimal	r0190_after_resident_sme;
	private BigDecimal	r0190_before_nonresident_sme;
	private BigDecimal	r0190_after_nonresident_sme;
	private BigDecimal	r0190_before_resident_hni;
	private BigDecimal	r0190_after_resident_hni;
	private BigDecimal	r0190_before_nonresident_hni;
	private BigDecimal	r0190_after_nonresident_hni;
	private BigDecimal	r0190_before_resident_gre;
	private BigDecimal	r0190_after_resident_gre;
	private BigDecimal	r0190_before_nonresident_gre;
	private BigDecimal	r0190_after_nonresident_gre;
	private BigDecimal	r0190_before_resident_corporate;
	private BigDecimal	r0190_after_resident_corporate;
	private BigDecimal	r0190_before_nonresident_corporate;
	private BigDecimal	r0190_after_nonresident_corporate;
	private BigDecimal	r0190_before_resident_nbfi;
	private BigDecimal	r0190_after_resident_nbfi;
	private BigDecimal	r0190_before_nonresident_nbfi;
	private BigDecimal	r0190_after_nonresident_nbfi;
	private BigDecimal	r0190_before_resident_bank;
	private BigDecimal	r0190_after_resident_bank;
	private BigDecimal	r0190_before_nonresident_bank;
	private BigDecimal	r0190_after_nonresident_bank;
	private BigDecimal	r0190_before_resident_government;
	private BigDecimal	r0190_after_resident_government;
	private BigDecimal	r0190_before_nonresident_government;
	private BigDecimal	r0190_after_nonresident_government;
	private String	r0200_product;
	private BigDecimal	r0200_before_resident_individual;
	private BigDecimal	r0200_after_resident_individual;
	private BigDecimal	r0200_before_nonresident_individual;
	private BigDecimal	r0200_after_nonresident_individual;
	private BigDecimal	r0200_before_resident_retail;
	private BigDecimal	r0200_after_resident_retail;
	private BigDecimal	r0200_before_nonresident_retail;
	private BigDecimal	r0200_after_nonresident_retail;
	private BigDecimal	r0200_before_resident_sme;
	private BigDecimal	r0200_after_resident_sme;
	private BigDecimal	r0200_before_nonresident_sme;
	private BigDecimal	r0200_after_nonresident_sme;
	private BigDecimal	r0200_before_resident_hni;
	private BigDecimal	r0200_after_resident_hni;
	private BigDecimal	r0200_before_nonresident_hni;
	private BigDecimal	r0200_after_nonresident_hni;
	private BigDecimal	r0200_before_resident_gre;
	private BigDecimal	r0200_after_resident_gre;
	private BigDecimal	r0200_before_nonresident_gre;
	private BigDecimal	r0200_after_nonresident_gre;
	private BigDecimal	r0200_before_resident_corporate;
	private BigDecimal	r0200_after_resident_corporate;
	private BigDecimal	r0200_before_nonresident_corporate;
	private BigDecimal	r0200_after_nonresident_corporate;
	private BigDecimal	r0200_before_resident_nbfi;
	private BigDecimal	r0200_after_resident_nbfi;
	private BigDecimal	r0200_before_nonresident_nbfi;
	private BigDecimal	r0200_after_nonresident_nbfi;
	private BigDecimal	r0200_before_resident_bank;
	private BigDecimal	r0200_after_resident_bank;
	private BigDecimal	r0200_before_nonresident_bank;
	private BigDecimal	r0200_after_nonresident_bank;
	private BigDecimal	r0200_before_resident_government;
	private BigDecimal	r0200_after_resident_government;
	private BigDecimal	r0200_before_nonresident_government;
	private BigDecimal	r0200_after_nonresident_government;
	private String	r0210_product;
	private BigDecimal	r0210_before_resident_individual;
	private BigDecimal	r0210_after_resident_individual;
	private BigDecimal	r0210_before_nonresident_individual;
	private BigDecimal	r0210_after_nonresident_individual;
	private BigDecimal	r0210_before_resident_retail;
	private BigDecimal	r0210_after_resident_retail;
	private BigDecimal	r0210_before_nonresident_retail;
	private BigDecimal	r0210_after_nonresident_retail;
	private BigDecimal	r0210_before_resident_sme;
	private BigDecimal	r0210_after_resident_sme;
	private BigDecimal	r0210_before_nonresident_sme;
	private BigDecimal	r0210_after_nonresident_sme;
	private BigDecimal	r0210_before_resident_hni;
	private BigDecimal	r0210_after_resident_hni;
	private BigDecimal	r0210_before_nonresident_hni;
	private BigDecimal	r0210_after_nonresident_hni;
	private BigDecimal	r0210_before_resident_gre;
	private BigDecimal	r0210_after_resident_gre;
	private BigDecimal	r0210_before_nonresident_gre;
	private BigDecimal	r0210_after_nonresident_gre;
	private BigDecimal	r0210_before_resident_corporate;
	private BigDecimal	r0210_after_resident_corporate;
	private BigDecimal	r0210_before_nonresident_corporate;
	private BigDecimal	r0210_after_nonresident_corporate;
	private BigDecimal	r0210_before_resident_nbfi;
	private BigDecimal	r0210_after_resident_nbfi;
	private BigDecimal	r0210_before_nonresident_nbfi;
	private BigDecimal	r0210_after_nonresident_nbfi;
	private BigDecimal	r0210_before_resident_bank;
	private BigDecimal	r0210_after_resident_bank;
	private BigDecimal	r0210_before_nonresident_bank;
	private BigDecimal	r0210_after_nonresident_bank;
	private BigDecimal	r0210_before_resident_government;
	private BigDecimal	r0210_after_resident_government;
	private BigDecimal	r0210_before_nonresident_government;
	private BigDecimal	r0210_after_nonresident_government;
	private String	r0220_product;
	private BigDecimal	r0220_before_resident_individual;
	private BigDecimal	r0220_after_resident_individual;
	private BigDecimal	r0220_before_nonresident_individual;
	private BigDecimal	r0220_after_nonresident_individual;
	private BigDecimal	r0220_before_resident_retail;
	private BigDecimal	r0220_after_resident_retail;
	private BigDecimal	r0220_before_nonresident_retail;
	private BigDecimal	r0220_after_nonresident_retail;
	private BigDecimal	r0220_before_resident_sme;
	private BigDecimal	r0220_after_resident_sme;
	private BigDecimal	r0220_before_nonresident_sme;
	private BigDecimal	r0220_after_nonresident_sme;
	private BigDecimal	r0220_before_resident_hni;
	private BigDecimal	r0220_after_resident_hni;
	private BigDecimal	r0220_before_nonresident_hni;
	private BigDecimal	r0220_after_nonresident_hni;
	private BigDecimal	r0220_before_resident_gre;
	private BigDecimal	r0220_after_resident_gre;
	private BigDecimal	r0220_before_nonresident_gre;
	private BigDecimal	r0220_after_nonresident_gre;
	private BigDecimal	r0220_before_resident_corporate;
	private BigDecimal	r0220_after_resident_corporate;
	private BigDecimal	r0220_before_nonresident_corporate;
	private BigDecimal	r0220_after_nonresident_corporate;
	private BigDecimal	r0220_before_resident_nbfi;
	private BigDecimal	r0220_after_resident_nbfi;
	private BigDecimal	r0220_before_nonresident_nbfi;
	private BigDecimal	r0220_after_nonresident_nbfi;
	private BigDecimal	r0220_before_resident_bank;
	private BigDecimal	r0220_after_resident_bank;
	private BigDecimal	r0220_before_nonresident_bank;
	private BigDecimal	r0220_after_nonresident_bank;
	private BigDecimal	r0220_before_resident_government;
	private BigDecimal	r0220_after_resident_government;
	private BigDecimal	r0220_before_nonresident_government;
	private BigDecimal	r0220_after_nonresident_government;
	private String	r0230_product;
	private BigDecimal	r0230_before_resident_individual;
	private BigDecimal	r0230_after_resident_individual;
	private BigDecimal	r0230_before_nonresident_individual;
	private BigDecimal	r0230_after_nonresident_individual;
	private BigDecimal	r0230_before_resident_retail;
	private BigDecimal	r0230_after_resident_retail;
	private BigDecimal	r0230_before_nonresident_retail;
	private BigDecimal	r0230_after_nonresident_retail;
	private BigDecimal	r0230_before_resident_sme;
	private BigDecimal	r0230_after_resident_sme;
	private BigDecimal	r0230_before_nonresident_sme;
	private BigDecimal	r0230_after_nonresident_sme;
	private BigDecimal	r0230_before_resident_hni;
	private BigDecimal	r0230_after_resident_hni;
	private BigDecimal	r0230_before_nonresident_hni;
	private BigDecimal	r0230_after_nonresident_hni;
	private BigDecimal	r0230_before_resident_gre;
	private BigDecimal	r0230_after_resident_gre;
	private BigDecimal	r0230_before_nonresident_gre;
	private BigDecimal	r0230_after_nonresident_gre;
	private BigDecimal	r0230_before_resident_corporate;
	private BigDecimal	r0230_after_resident_corporate;
	private BigDecimal	r0230_before_nonresident_corporate;
	private BigDecimal	r0230_after_nonresident_corporate;
	private BigDecimal	r0230_before_resident_nbfi;
	private BigDecimal	r0230_after_resident_nbfi;
	private BigDecimal	r0230_before_nonresident_nbfi;
	private BigDecimal	r0230_after_nonresident_nbfi;
	private BigDecimal	r0230_before_resident_bank;
	private BigDecimal	r0230_after_resident_bank;
	private BigDecimal	r0230_before_nonresident_bank;
	private BigDecimal	r0230_after_nonresident_bank;
	private BigDecimal	r0230_before_resident_government;
	private BigDecimal	r0230_after_resident_government;
	private BigDecimal	r0230_before_nonresident_government;
	private BigDecimal	r0230_after_nonresident_government;
	
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
	public BigDecimal getR0010_before_resident_individual() {
		return r0010_before_resident_individual;
	}
	public void setR0010_before_resident_individual(BigDecimal r0010_before_resident_individual) {
		this.r0010_before_resident_individual = r0010_before_resident_individual;
	}
	public BigDecimal getR0010_after_resident_individual() {
		return r0010_after_resident_individual;
	}
	public void setR0010_after_resident_individual(BigDecimal r0010_after_resident_individual) {
		this.r0010_after_resident_individual = r0010_after_resident_individual;
	}
	public BigDecimal getR0010_before_nonresident_individual() {
		return r0010_before_nonresident_individual;
	}
	public void setR0010_before_nonresident_individual(BigDecimal r0010_before_nonresident_individual) {
		this.r0010_before_nonresident_individual = r0010_before_nonresident_individual;
	}
	public BigDecimal getR0010_after_nonresident_individual() {
		return r0010_after_nonresident_individual;
	}
	public void setR0010_after_nonresident_individual(BigDecimal r0010_after_nonresident_individual) {
		this.r0010_after_nonresident_individual = r0010_after_nonresident_individual;
	}
	public BigDecimal getR0010_before_resident_retail() {
		return r0010_before_resident_retail;
	}
	public void setR0010_before_resident_retail(BigDecimal r0010_before_resident_retail) {
		this.r0010_before_resident_retail = r0010_before_resident_retail;
	}
	public BigDecimal getR0010_after_resident_retail() {
		return r0010_after_resident_retail;
	}
	public void setR0010_after_resident_retail(BigDecimal r0010_after_resident_retail) {
		this.r0010_after_resident_retail = r0010_after_resident_retail;
	}
	public BigDecimal getR0010_before_nonresident_retail() {
		return r0010_before_nonresident_retail;
	}
	public void setR0010_before_nonresident_retail(BigDecimal r0010_before_nonresident_retail) {
		this.r0010_before_nonresident_retail = r0010_before_nonresident_retail;
	}
	public BigDecimal getR0010_after_nonresident_retail() {
		return r0010_after_nonresident_retail;
	}
	public void setR0010_after_nonresident_retail(BigDecimal r0010_after_nonresident_retail) {
		this.r0010_after_nonresident_retail = r0010_after_nonresident_retail;
	}
	public BigDecimal getR0010_before_resident_sme() {
		return r0010_before_resident_sme;
	}
	public void setR0010_before_resident_sme(BigDecimal r0010_before_resident_sme) {
		this.r0010_before_resident_sme = r0010_before_resident_sme;
	}
	public BigDecimal getR0010_after_resident_sme() {
		return r0010_after_resident_sme;
	}
	public void setR0010_after_resident_sme(BigDecimal r0010_after_resident_sme) {
		this.r0010_after_resident_sme = r0010_after_resident_sme;
	}
	public BigDecimal getR0010_before_nonresident_sme() {
		return r0010_before_nonresident_sme;
	}
	public void setR0010_before_nonresident_sme(BigDecimal r0010_before_nonresident_sme) {
		this.r0010_before_nonresident_sme = r0010_before_nonresident_sme;
	}
	public BigDecimal getR0010_after_nonresident_sme() {
		return r0010_after_nonresident_sme;
	}
	public void setR0010_after_nonresident_sme(BigDecimal r0010_after_nonresident_sme) {
		this.r0010_after_nonresident_sme = r0010_after_nonresident_sme;
	}
	public BigDecimal getR0010_before_resident_hni() {
		return r0010_before_resident_hni;
	}
	public void setR0010_before_resident_hni(BigDecimal r0010_before_resident_hni) {
		this.r0010_before_resident_hni = r0010_before_resident_hni;
	}
	public BigDecimal getR0010_after_resident_hni() {
		return r0010_after_resident_hni;
	}
	public void setR0010_after_resident_hni(BigDecimal r0010_after_resident_hni) {
		this.r0010_after_resident_hni = r0010_after_resident_hni;
	}
	public BigDecimal getR0010_before_nonresident_hni() {
		return r0010_before_nonresident_hni;
	}
	public void setR0010_before_nonresident_hni(BigDecimal r0010_before_nonresident_hni) {
		this.r0010_before_nonresident_hni = r0010_before_nonresident_hni;
	}
	public BigDecimal getR0010_after_nonresident_hni() {
		return r0010_after_nonresident_hni;
	}
	public void setR0010_after_nonresident_hni(BigDecimal r0010_after_nonresident_hni) {
		this.r0010_after_nonresident_hni = r0010_after_nonresident_hni;
	}
	public BigDecimal getR0010_before_resident_gre() {
		return r0010_before_resident_gre;
	}
	public void setR0010_before_resident_gre(BigDecimal r0010_before_resident_gre) {
		this.r0010_before_resident_gre = r0010_before_resident_gre;
	}
	public BigDecimal getR0010_after_resident_gre() {
		return r0010_after_resident_gre;
	}
	public void setR0010_after_resident_gre(BigDecimal r0010_after_resident_gre) {
		this.r0010_after_resident_gre = r0010_after_resident_gre;
	}
	public BigDecimal getR0010_before_nonresident_gre() {
		return r0010_before_nonresident_gre;
	}
	public void setR0010_before_nonresident_gre(BigDecimal r0010_before_nonresident_gre) {
		this.r0010_before_nonresident_gre = r0010_before_nonresident_gre;
	}
	public BigDecimal getR0010_after_nonresident_gre() {
		return r0010_after_nonresident_gre;
	}
	public void setR0010_after_nonresident_gre(BigDecimal r0010_after_nonresident_gre) {
		this.r0010_after_nonresident_gre = r0010_after_nonresident_gre;
	}
	public BigDecimal getR0010_before_resident_corporate() {
		return r0010_before_resident_corporate;
	}
	public void setR0010_before_resident_corporate(BigDecimal r0010_before_resident_corporate) {
		this.r0010_before_resident_corporate = r0010_before_resident_corporate;
	}
	public BigDecimal getR0010_after_resident_corporate() {
		return r0010_after_resident_corporate;
	}
	public void setR0010_after_resident_corporate(BigDecimal r0010_after_resident_corporate) {
		this.r0010_after_resident_corporate = r0010_after_resident_corporate;
	}
	public BigDecimal getR0010_before_nonresident_corporate() {
		return r0010_before_nonresident_corporate;
	}
	public void setR0010_before_nonresident_corporate(BigDecimal r0010_before_nonresident_corporate) {
		this.r0010_before_nonresident_corporate = r0010_before_nonresident_corporate;
	}
	public BigDecimal getR0010_after_nonresident_corporate() {
		return r0010_after_nonresident_corporate;
	}
	public void setR0010_after_nonresident_corporate(BigDecimal r0010_after_nonresident_corporate) {
		this.r0010_after_nonresident_corporate = r0010_after_nonresident_corporate;
	}
	public BigDecimal getR0010_before_resident_nbfi() {
		return r0010_before_resident_nbfi;
	}
	public void setR0010_before_resident_nbfi(BigDecimal r0010_before_resident_nbfi) {
		this.r0010_before_resident_nbfi = r0010_before_resident_nbfi;
	}
	public BigDecimal getR0010_after_resident_nbfi() {
		return r0010_after_resident_nbfi;
	}
	public void setR0010_after_resident_nbfi(BigDecimal r0010_after_resident_nbfi) {
		this.r0010_after_resident_nbfi = r0010_after_resident_nbfi;
	}
	public BigDecimal getR0010_before_nonresident_nbfi() {
		return r0010_before_nonresident_nbfi;
	}
	public void setR0010_before_nonresident_nbfi(BigDecimal r0010_before_nonresident_nbfi) {
		this.r0010_before_nonresident_nbfi = r0010_before_nonresident_nbfi;
	}
	public BigDecimal getR0010_after_nonresident_nbfi() {
		return r0010_after_nonresident_nbfi;
	}
	public void setR0010_after_nonresident_nbfi(BigDecimal r0010_after_nonresident_nbfi) {
		this.r0010_after_nonresident_nbfi = r0010_after_nonresident_nbfi;
	}
	public BigDecimal getR0010_before_resident_bank() {
		return r0010_before_resident_bank;
	}
	public void setR0010_before_resident_bank(BigDecimal r0010_before_resident_bank) {
		this.r0010_before_resident_bank = r0010_before_resident_bank;
	}
	public BigDecimal getR0010_after_resident_bank() {
		return r0010_after_resident_bank;
	}
	public void setR0010_after_resident_bank(BigDecimal r0010_after_resident_bank) {
		this.r0010_after_resident_bank = r0010_after_resident_bank;
	}
	public BigDecimal getR0010_before_nonresident_bank() {
		return r0010_before_nonresident_bank;
	}
	public void setR0010_before_nonresident_bank(BigDecimal r0010_before_nonresident_bank) {
		this.r0010_before_nonresident_bank = r0010_before_nonresident_bank;
	}
	public BigDecimal getR0010_after_nonresident_bank() {
		return r0010_after_nonresident_bank;
	}
	public void setR0010_after_nonresident_bank(BigDecimal r0010_after_nonresident_bank) {
		this.r0010_after_nonresident_bank = r0010_after_nonresident_bank;
	}
	public BigDecimal getR0010_before_resident_government() {
		return r0010_before_resident_government;
	}
	public void setR0010_before_resident_government(BigDecimal r0010_before_resident_government) {
		this.r0010_before_resident_government = r0010_before_resident_government;
	}
	public BigDecimal getR0010_after_resident_government() {
		return r0010_after_resident_government;
	}
	public void setR0010_after_resident_government(BigDecimal r0010_after_resident_government) {
		this.r0010_after_resident_government = r0010_after_resident_government;
	}
	public BigDecimal getR0010_before_nonresident_government() {
		return r0010_before_nonresident_government;
	}
	public void setR0010_before_nonresident_government(BigDecimal r0010_before_nonresident_government) {
		this.r0010_before_nonresident_government = r0010_before_nonresident_government;
	}
	public BigDecimal getR0010_after_nonresident_government() {
		return r0010_after_nonresident_government;
	}
	public void setR0010_after_nonresident_government(BigDecimal r0010_after_nonresident_government) {
		this.r0010_after_nonresident_government = r0010_after_nonresident_government;
	}
	public String getR0020_product() {
		return r0020_product;
	}
	public void setR0020_product(String r0020_product) {
		this.r0020_product = r0020_product;
	}
	public BigDecimal getR0020_before_resident_individual() {
		return r0020_before_resident_individual;
	}
	public void setR0020_before_resident_individual(BigDecimal r0020_before_resident_individual) {
		this.r0020_before_resident_individual = r0020_before_resident_individual;
	}
	public BigDecimal getR0020_after_resident_individual() {
		return r0020_after_resident_individual;
	}
	public void setR0020_after_resident_individual(BigDecimal r0020_after_resident_individual) {
		this.r0020_after_resident_individual = r0020_after_resident_individual;
	}
	public BigDecimal getR0020_before_nonresident_individual() {
		return r0020_before_nonresident_individual;
	}
	public void setR0020_before_nonresident_individual(BigDecimal r0020_before_nonresident_individual) {
		this.r0020_before_nonresident_individual = r0020_before_nonresident_individual;
	}
	public BigDecimal getR0020_after_nonresident_individual() {
		return r0020_after_nonresident_individual;
	}
	public void setR0020_after_nonresident_individual(BigDecimal r0020_after_nonresident_individual) {
		this.r0020_after_nonresident_individual = r0020_after_nonresident_individual;
	}
	public BigDecimal getR0020_before_resident_retail() {
		return r0020_before_resident_retail;
	}
	public void setR0020_before_resident_retail(BigDecimal r0020_before_resident_retail) {
		this.r0020_before_resident_retail = r0020_before_resident_retail;
	}
	public BigDecimal getR0020_after_resident_retail() {
		return r0020_after_resident_retail;
	}
	public void setR0020_after_resident_retail(BigDecimal r0020_after_resident_retail) {
		this.r0020_after_resident_retail = r0020_after_resident_retail;
	}
	public BigDecimal getR0020_before_nonresident_retail() {
		return r0020_before_nonresident_retail;
	}
	public void setR0020_before_nonresident_retail(BigDecimal r0020_before_nonresident_retail) {
		this.r0020_before_nonresident_retail = r0020_before_nonresident_retail;
	}
	public BigDecimal getR0020_after_nonresident_retail() {
		return r0020_after_nonresident_retail;
	}
	public void setR0020_after_nonresident_retail(BigDecimal r0020_after_nonresident_retail) {
		this.r0020_after_nonresident_retail = r0020_after_nonresident_retail;
	}
	public BigDecimal getR0020_before_resident_sme() {
		return r0020_before_resident_sme;
	}
	public void setR0020_before_resident_sme(BigDecimal r0020_before_resident_sme) {
		this.r0020_before_resident_sme = r0020_before_resident_sme;
	}
	public BigDecimal getR0020_after_resident_sme() {
		return r0020_after_resident_sme;
	}
	public void setR0020_after_resident_sme(BigDecimal r0020_after_resident_sme) {
		this.r0020_after_resident_sme = r0020_after_resident_sme;
	}
	public BigDecimal getR0020_before_nonresident_sme() {
		return r0020_before_nonresident_sme;
	}
	public void setR0020_before_nonresident_sme(BigDecimal r0020_before_nonresident_sme) {
		this.r0020_before_nonresident_sme = r0020_before_nonresident_sme;
	}
	public BigDecimal getR0020_after_nonresident_sme() {
		return r0020_after_nonresident_sme;
	}
	public void setR0020_after_nonresident_sme(BigDecimal r0020_after_nonresident_sme) {
		this.r0020_after_nonresident_sme = r0020_after_nonresident_sme;
	}
	public BigDecimal getR0020_before_resident_hni() {
		return r0020_before_resident_hni;
	}
	public void setR0020_before_resident_hni(BigDecimal r0020_before_resident_hni) {
		this.r0020_before_resident_hni = r0020_before_resident_hni;
	}
	public BigDecimal getR0020_after_resident_hni() {
		return r0020_after_resident_hni;
	}
	public void setR0020_after_resident_hni(BigDecimal r0020_after_resident_hni) {
		this.r0020_after_resident_hni = r0020_after_resident_hni;
	}
	public BigDecimal getR0020_before_nonresident_hni() {
		return r0020_before_nonresident_hni;
	}
	public void setR0020_before_nonresident_hni(BigDecimal r0020_before_nonresident_hni) {
		this.r0020_before_nonresident_hni = r0020_before_nonresident_hni;
	}
	public BigDecimal getR0020_after_nonresident_hni() {
		return r0020_after_nonresident_hni;
	}
	public void setR0020_after_nonresident_hni(BigDecimal r0020_after_nonresident_hni) {
		this.r0020_after_nonresident_hni = r0020_after_nonresident_hni;
	}
	public BigDecimal getR0020_before_resident_gre() {
		return r0020_before_resident_gre;
	}
	public void setR0020_before_resident_gre(BigDecimal r0020_before_resident_gre) {
		this.r0020_before_resident_gre = r0020_before_resident_gre;
	}
	public BigDecimal getR0020_after_resident_gre() {
		return r0020_after_resident_gre;
	}
	public void setR0020_after_resident_gre(BigDecimal r0020_after_resident_gre) {
		this.r0020_after_resident_gre = r0020_after_resident_gre;
	}
	public BigDecimal getR0020_before_nonresident_gre() {
		return r0020_before_nonresident_gre;
	}
	public void setR0020_before_nonresident_gre(BigDecimal r0020_before_nonresident_gre) {
		this.r0020_before_nonresident_gre = r0020_before_nonresident_gre;
	}
	public BigDecimal getR0020_after_nonresident_gre() {
		return r0020_after_nonresident_gre;
	}
	public void setR0020_after_nonresident_gre(BigDecimal r0020_after_nonresident_gre) {
		this.r0020_after_nonresident_gre = r0020_after_nonresident_gre;
	}
	public BigDecimal getR0020_before_resident_corporate() {
		return r0020_before_resident_corporate;
	}
	public void setR0020_before_resident_corporate(BigDecimal r0020_before_resident_corporate) {
		this.r0020_before_resident_corporate = r0020_before_resident_corporate;
	}
	public BigDecimal getR0020_after_resident_corporate() {
		return r0020_after_resident_corporate;
	}
	public void setR0020_after_resident_corporate(BigDecimal r0020_after_resident_corporate) {
		this.r0020_after_resident_corporate = r0020_after_resident_corporate;
	}
	public BigDecimal getR0020_before_nonresident_corporate() {
		return r0020_before_nonresident_corporate;
	}
	public void setR0020_before_nonresident_corporate(BigDecimal r0020_before_nonresident_corporate) {
		this.r0020_before_nonresident_corporate = r0020_before_nonresident_corporate;
	}
	public BigDecimal getR0020_after_nonresident_corporate() {
		return r0020_after_nonresident_corporate;
	}
	public void setR0020_after_nonresident_corporate(BigDecimal r0020_after_nonresident_corporate) {
		this.r0020_after_nonresident_corporate = r0020_after_nonresident_corporate;
	}
	public BigDecimal getR0020_before_resident_nbfi() {
		return r0020_before_resident_nbfi;
	}
	public void setR0020_before_resident_nbfi(BigDecimal r0020_before_resident_nbfi) {
		this.r0020_before_resident_nbfi = r0020_before_resident_nbfi;
	}
	public BigDecimal getR0020_after_resident_nbfi() {
		return r0020_after_resident_nbfi;
	}
	public void setR0020_after_resident_nbfi(BigDecimal r0020_after_resident_nbfi) {
		this.r0020_after_resident_nbfi = r0020_after_resident_nbfi;
	}
	public BigDecimal getR0020_before_nonresident_nbfi() {
		return r0020_before_nonresident_nbfi;
	}
	public void setR0020_before_nonresident_nbfi(BigDecimal r0020_before_nonresident_nbfi) {
		this.r0020_before_nonresident_nbfi = r0020_before_nonresident_nbfi;
	}
	public BigDecimal getR0020_after_nonresident_nbfi() {
		return r0020_after_nonresident_nbfi;
	}
	public void setR0020_after_nonresident_nbfi(BigDecimal r0020_after_nonresident_nbfi) {
		this.r0020_after_nonresident_nbfi = r0020_after_nonresident_nbfi;
	}
	public BigDecimal getR0020_before_resident_bank() {
		return r0020_before_resident_bank;
	}
	public void setR0020_before_resident_bank(BigDecimal r0020_before_resident_bank) {
		this.r0020_before_resident_bank = r0020_before_resident_bank;
	}
	public BigDecimal getR0020_after_resident_bank() {
		return r0020_after_resident_bank;
	}
	public void setR0020_after_resident_bank(BigDecimal r0020_after_resident_bank) {
		this.r0020_after_resident_bank = r0020_after_resident_bank;
	}
	public BigDecimal getR0020_before_nonresident_bank() {
		return r0020_before_nonresident_bank;
	}
	public void setR0020_before_nonresident_bank(BigDecimal r0020_before_nonresident_bank) {
		this.r0020_before_nonresident_bank = r0020_before_nonresident_bank;
	}
	public BigDecimal getR0020_after_nonresident_bank() {
		return r0020_after_nonresident_bank;
	}
	public void setR0020_after_nonresident_bank(BigDecimal r0020_after_nonresident_bank) {
		this.r0020_after_nonresident_bank = r0020_after_nonresident_bank;
	}
	public BigDecimal getR0020_before_resident_government() {
		return r0020_before_resident_government;
	}
	public void setR0020_before_resident_government(BigDecimal r0020_before_resident_government) {
		this.r0020_before_resident_government = r0020_before_resident_government;
	}
	public BigDecimal getR0020_after_resident_government() {
		return r0020_after_resident_government;
	}
	public void setR0020_after_resident_government(BigDecimal r0020_after_resident_government) {
		this.r0020_after_resident_government = r0020_after_resident_government;
	}
	public BigDecimal getR0020_before_nonresident_government() {
		return r0020_before_nonresident_government;
	}
	public void setR0020_before_nonresident_government(BigDecimal r0020_before_nonresident_government) {
		this.r0020_before_nonresident_government = r0020_before_nonresident_government;
	}
	public BigDecimal getR0020_after_nonresident_government() {
		return r0020_after_nonresident_government;
	}
	public void setR0020_after_nonresident_government(BigDecimal r0020_after_nonresident_government) {
		this.r0020_after_nonresident_government = r0020_after_nonresident_government;
	}
	public String getR0030_product() {
		return r0030_product;
	}
	public void setR0030_product(String r0030_product) {
		this.r0030_product = r0030_product;
	}
	public BigDecimal getR0030_before_resident_individual() {
		return r0030_before_resident_individual;
	}
	public void setR0030_before_resident_individual(BigDecimal r0030_before_resident_individual) {
		this.r0030_before_resident_individual = r0030_before_resident_individual;
	}
	public BigDecimal getR0030_after_resident_individual() {
		return r0030_after_resident_individual;
	}
	public void setR0030_after_resident_individual(BigDecimal r0030_after_resident_individual) {
		this.r0030_after_resident_individual = r0030_after_resident_individual;
	}
	public BigDecimal getR0030_before_nonresident_individual() {
		return r0030_before_nonresident_individual;
	}
	public void setR0030_before_nonresident_individual(BigDecimal r0030_before_nonresident_individual) {
		this.r0030_before_nonresident_individual = r0030_before_nonresident_individual;
	}
	public BigDecimal getR0030_after_nonresident_individual() {
		return r0030_after_nonresident_individual;
	}
	public void setR0030_after_nonresident_individual(BigDecimal r0030_after_nonresident_individual) {
		this.r0030_after_nonresident_individual = r0030_after_nonresident_individual;
	}
	public BigDecimal getR0030_before_resident_retail() {
		return r0030_before_resident_retail;
	}
	public void setR0030_before_resident_retail(BigDecimal r0030_before_resident_retail) {
		this.r0030_before_resident_retail = r0030_before_resident_retail;
	}
	public BigDecimal getR0030_after_resident_retail() {
		return r0030_after_resident_retail;
	}
	public void setR0030_after_resident_retail(BigDecimal r0030_after_resident_retail) {
		this.r0030_after_resident_retail = r0030_after_resident_retail;
	}
	public BigDecimal getR0030_before_nonresident_retail() {
		return r0030_before_nonresident_retail;
	}
	public void setR0030_before_nonresident_retail(BigDecimal r0030_before_nonresident_retail) {
		this.r0030_before_nonresident_retail = r0030_before_nonresident_retail;
	}
	public BigDecimal getR0030_after_nonresident_retail() {
		return r0030_after_nonresident_retail;
	}
	public void setR0030_after_nonresident_retail(BigDecimal r0030_after_nonresident_retail) {
		this.r0030_after_nonresident_retail = r0030_after_nonresident_retail;
	}
	public BigDecimal getR0030_before_resident_sme() {
		return r0030_before_resident_sme;
	}
	public void setR0030_before_resident_sme(BigDecimal r0030_before_resident_sme) {
		this.r0030_before_resident_sme = r0030_before_resident_sme;
	}
	public BigDecimal getR0030_after_resident_sme() {
		return r0030_after_resident_sme;
	}
	public void setR0030_after_resident_sme(BigDecimal r0030_after_resident_sme) {
		this.r0030_after_resident_sme = r0030_after_resident_sme;
	}
	public BigDecimal getR0030_before_nonresident_sme() {
		return r0030_before_nonresident_sme;
	}
	public void setR0030_before_nonresident_sme(BigDecimal r0030_before_nonresident_sme) {
		this.r0030_before_nonresident_sme = r0030_before_nonresident_sme;
	}
	public BigDecimal getR0030_after_nonresident_sme() {
		return r0030_after_nonresident_sme;
	}
	public void setR0030_after_nonresident_sme(BigDecimal r0030_after_nonresident_sme) {
		this.r0030_after_nonresident_sme = r0030_after_nonresident_sme;
	}
	public BigDecimal getR0030_before_resident_hni() {
		return r0030_before_resident_hni;
	}
	public void setR0030_before_resident_hni(BigDecimal r0030_before_resident_hni) {
		this.r0030_before_resident_hni = r0030_before_resident_hni;
	}
	public BigDecimal getR0030_after_resident_hni() {
		return r0030_after_resident_hni;
	}
	public void setR0030_after_resident_hni(BigDecimal r0030_after_resident_hni) {
		this.r0030_after_resident_hni = r0030_after_resident_hni;
	}
	public BigDecimal getR0030_before_nonresident_hni() {
		return r0030_before_nonresident_hni;
	}
	public void setR0030_before_nonresident_hni(BigDecimal r0030_before_nonresident_hni) {
		this.r0030_before_nonresident_hni = r0030_before_nonresident_hni;
	}
	public BigDecimal getR0030_after_nonresident_hni() {
		return r0030_after_nonresident_hni;
	}
	public void setR0030_after_nonresident_hni(BigDecimal r0030_after_nonresident_hni) {
		this.r0030_after_nonresident_hni = r0030_after_nonresident_hni;
	}
	public BigDecimal getR0030_before_resident_gre() {
		return r0030_before_resident_gre;
	}
	public void setR0030_before_resident_gre(BigDecimal r0030_before_resident_gre) {
		this.r0030_before_resident_gre = r0030_before_resident_gre;
	}
	public BigDecimal getR0030_after_resident_gre() {
		return r0030_after_resident_gre;
	}
	public void setR0030_after_resident_gre(BigDecimal r0030_after_resident_gre) {
		this.r0030_after_resident_gre = r0030_after_resident_gre;
	}
	public BigDecimal getR0030_before_nonresident_gre() {
		return r0030_before_nonresident_gre;
	}
	public void setR0030_before_nonresident_gre(BigDecimal r0030_before_nonresident_gre) {
		this.r0030_before_nonresident_gre = r0030_before_nonresident_gre;
	}
	public BigDecimal getR0030_after_nonresident_gre() {
		return r0030_after_nonresident_gre;
	}
	public void setR0030_after_nonresident_gre(BigDecimal r0030_after_nonresident_gre) {
		this.r0030_after_nonresident_gre = r0030_after_nonresident_gre;
	}
	public BigDecimal getR0030_before_resident_corporate() {
		return r0030_before_resident_corporate;
	}
	public void setR0030_before_resident_corporate(BigDecimal r0030_before_resident_corporate) {
		this.r0030_before_resident_corporate = r0030_before_resident_corporate;
	}
	public BigDecimal getR0030_after_resident_corporate() {
		return r0030_after_resident_corporate;
	}
	public void setR0030_after_resident_corporate(BigDecimal r0030_after_resident_corporate) {
		this.r0030_after_resident_corporate = r0030_after_resident_corporate;
	}
	public BigDecimal getR0030_before_nonresident_corporate() {
		return r0030_before_nonresident_corporate;
	}
	public void setR0030_before_nonresident_corporate(BigDecimal r0030_before_nonresident_corporate) {
		this.r0030_before_nonresident_corporate = r0030_before_nonresident_corporate;
	}
	public BigDecimal getR0030_after_nonresident_corporate() {
		return r0030_after_nonresident_corporate;
	}
	public void setR0030_after_nonresident_corporate(BigDecimal r0030_after_nonresident_corporate) {
		this.r0030_after_nonresident_corporate = r0030_after_nonresident_corporate;
	}
	public BigDecimal getR0030_before_resident_nbfi() {
		return r0030_before_resident_nbfi;
	}
	public void setR0030_before_resident_nbfi(BigDecimal r0030_before_resident_nbfi) {
		this.r0030_before_resident_nbfi = r0030_before_resident_nbfi;
	}
	public BigDecimal getR0030_after_resident_nbfi() {
		return r0030_after_resident_nbfi;
	}
	public void setR0030_after_resident_nbfi(BigDecimal r0030_after_resident_nbfi) {
		this.r0030_after_resident_nbfi = r0030_after_resident_nbfi;
	}
	public BigDecimal getR0030_before_nonresident_nbfi() {
		return r0030_before_nonresident_nbfi;
	}
	public void setR0030_before_nonresident_nbfi(BigDecimal r0030_before_nonresident_nbfi) {
		this.r0030_before_nonresident_nbfi = r0030_before_nonresident_nbfi;
	}
	public BigDecimal getR0030_after_nonresident_nbfi() {
		return r0030_after_nonresident_nbfi;
	}
	public void setR0030_after_nonresident_nbfi(BigDecimal r0030_after_nonresident_nbfi) {
		this.r0030_after_nonresident_nbfi = r0030_after_nonresident_nbfi;
	}
	public BigDecimal getR0030_before_resident_bank() {
		return r0030_before_resident_bank;
	}
	public void setR0030_before_resident_bank(BigDecimal r0030_before_resident_bank) {
		this.r0030_before_resident_bank = r0030_before_resident_bank;
	}
	public BigDecimal getR0030_after_resident_bank() {
		return r0030_after_resident_bank;
	}
	public void setR0030_after_resident_bank(BigDecimal r0030_after_resident_bank) {
		this.r0030_after_resident_bank = r0030_after_resident_bank;
	}
	public BigDecimal getR0030_before_nonresident_bank() {
		return r0030_before_nonresident_bank;
	}
	public void setR0030_before_nonresident_bank(BigDecimal r0030_before_nonresident_bank) {
		this.r0030_before_nonresident_bank = r0030_before_nonresident_bank;
	}
	public BigDecimal getR0030_after_nonresident_bank() {
		return r0030_after_nonresident_bank;
	}
	public void setR0030_after_nonresident_bank(BigDecimal r0030_after_nonresident_bank) {
		this.r0030_after_nonresident_bank = r0030_after_nonresident_bank;
	}
	public BigDecimal getR0030_before_resident_government() {
		return r0030_before_resident_government;
	}
	public void setR0030_before_resident_government(BigDecimal r0030_before_resident_government) {
		this.r0030_before_resident_government = r0030_before_resident_government;
	}
	public BigDecimal getR0030_after_resident_government() {
		return r0030_after_resident_government;
	}
	public void setR0030_after_resident_government(BigDecimal r0030_after_resident_government) {
		this.r0030_after_resident_government = r0030_after_resident_government;
	}
	public BigDecimal getR0030_before_nonresident_government() {
		return r0030_before_nonresident_government;
	}
	public void setR0030_before_nonresident_government(BigDecimal r0030_before_nonresident_government) {
		this.r0030_before_nonresident_government = r0030_before_nonresident_government;
	}
	public BigDecimal getR0030_after_nonresident_government() {
		return r0030_after_nonresident_government;
	}
	public void setR0030_after_nonresident_government(BigDecimal r0030_after_nonresident_government) {
		this.r0030_after_nonresident_government = r0030_after_nonresident_government;
	}
	public String getR0040_product() {
		return r0040_product;
	}
	public void setR0040_product(String r0040_product) {
		this.r0040_product = r0040_product;
	}
	public BigDecimal getR0040_before_resident_individual() {
		return r0040_before_resident_individual;
	}
	public void setR0040_before_resident_individual(BigDecimal r0040_before_resident_individual) {
		this.r0040_before_resident_individual = r0040_before_resident_individual;
	}
	public BigDecimal getR0040_after_resident_individual() {
		return r0040_after_resident_individual;
	}
	public void setR0040_after_resident_individual(BigDecimal r0040_after_resident_individual) {
		this.r0040_after_resident_individual = r0040_after_resident_individual;
	}
	public BigDecimal getR0040_before_nonresident_individual() {
		return r0040_before_nonresident_individual;
	}
	public void setR0040_before_nonresident_individual(BigDecimal r0040_before_nonresident_individual) {
		this.r0040_before_nonresident_individual = r0040_before_nonresident_individual;
	}
	public BigDecimal getR0040_after_nonresident_individual() {
		return r0040_after_nonresident_individual;
	}
	public void setR0040_after_nonresident_individual(BigDecimal r0040_after_nonresident_individual) {
		this.r0040_after_nonresident_individual = r0040_after_nonresident_individual;
	}
	public BigDecimal getR0040_before_resident_retail() {
		return r0040_before_resident_retail;
	}
	public void setR0040_before_resident_retail(BigDecimal r0040_before_resident_retail) {
		this.r0040_before_resident_retail = r0040_before_resident_retail;
	}
	public BigDecimal getR0040_after_resident_retail() {
		return r0040_after_resident_retail;
	}
	public void setR0040_after_resident_retail(BigDecimal r0040_after_resident_retail) {
		this.r0040_after_resident_retail = r0040_after_resident_retail;
	}
	public BigDecimal getR0040_before_nonresident_retail() {
		return r0040_before_nonresident_retail;
	}
	public void setR0040_before_nonresident_retail(BigDecimal r0040_before_nonresident_retail) {
		this.r0040_before_nonresident_retail = r0040_before_nonresident_retail;
	}
	public BigDecimal getR0040_after_nonresident_retail() {
		return r0040_after_nonresident_retail;
	}
	public void setR0040_after_nonresident_retail(BigDecimal r0040_after_nonresident_retail) {
		this.r0040_after_nonresident_retail = r0040_after_nonresident_retail;
	}
	public BigDecimal getR0040_before_resident_sme() {
		return r0040_before_resident_sme;
	}
	public void setR0040_before_resident_sme(BigDecimal r0040_before_resident_sme) {
		this.r0040_before_resident_sme = r0040_before_resident_sme;
	}
	public BigDecimal getR0040_after_resident_sme() {
		return r0040_after_resident_sme;
	}
	public void setR0040_after_resident_sme(BigDecimal r0040_after_resident_sme) {
		this.r0040_after_resident_sme = r0040_after_resident_sme;
	}
	public BigDecimal getR0040_before_nonresident_sme() {
		return r0040_before_nonresident_sme;
	}
	public void setR0040_before_nonresident_sme(BigDecimal r0040_before_nonresident_sme) {
		this.r0040_before_nonresident_sme = r0040_before_nonresident_sme;
	}
	public BigDecimal getR0040_after_nonresident_sme() {
		return r0040_after_nonresident_sme;
	}
	public void setR0040_after_nonresident_sme(BigDecimal r0040_after_nonresident_sme) {
		this.r0040_after_nonresident_sme = r0040_after_nonresident_sme;
	}
	public BigDecimal getR0040_before_resident_hni() {
		return r0040_before_resident_hni;
	}
	public void setR0040_before_resident_hni(BigDecimal r0040_before_resident_hni) {
		this.r0040_before_resident_hni = r0040_before_resident_hni;
	}
	public BigDecimal getR0040_after_resident_hni() {
		return r0040_after_resident_hni;
	}
	public void setR0040_after_resident_hni(BigDecimal r0040_after_resident_hni) {
		this.r0040_after_resident_hni = r0040_after_resident_hni;
	}
	public BigDecimal getR0040_before_nonresident_hni() {
		return r0040_before_nonresident_hni;
	}
	public void setR0040_before_nonresident_hni(BigDecimal r0040_before_nonresident_hni) {
		this.r0040_before_nonresident_hni = r0040_before_nonresident_hni;
	}
	public BigDecimal getR0040_after_nonresident_hni() {
		return r0040_after_nonresident_hni;
	}
	public void setR0040_after_nonresident_hni(BigDecimal r0040_after_nonresident_hni) {
		this.r0040_after_nonresident_hni = r0040_after_nonresident_hni;
	}
	public BigDecimal getR0040_before_resident_gre() {
		return r0040_before_resident_gre;
	}
	public void setR0040_before_resident_gre(BigDecimal r0040_before_resident_gre) {
		this.r0040_before_resident_gre = r0040_before_resident_gre;
	}
	public BigDecimal getR0040_after_resident_gre() {
		return r0040_after_resident_gre;
	}
	public void setR0040_after_resident_gre(BigDecimal r0040_after_resident_gre) {
		this.r0040_after_resident_gre = r0040_after_resident_gre;
	}
	public BigDecimal getR0040_before_nonresident_gre() {
		return r0040_before_nonresident_gre;
	}
	public void setR0040_before_nonresident_gre(BigDecimal r0040_before_nonresident_gre) {
		this.r0040_before_nonresident_gre = r0040_before_nonresident_gre;
	}
	public BigDecimal getR0040_after_nonresident_gre() {
		return r0040_after_nonresident_gre;
	}
	public void setR0040_after_nonresident_gre(BigDecimal r0040_after_nonresident_gre) {
		this.r0040_after_nonresident_gre = r0040_after_nonresident_gre;
	}
	public BigDecimal getR0040_before_resident_corporate() {
		return r0040_before_resident_corporate;
	}
	public void setR0040_before_resident_corporate(BigDecimal r0040_before_resident_corporate) {
		this.r0040_before_resident_corporate = r0040_before_resident_corporate;
	}
	public BigDecimal getR0040_after_resident_corporate() {
		return r0040_after_resident_corporate;
	}
	public void setR0040_after_resident_corporate(BigDecimal r0040_after_resident_corporate) {
		this.r0040_after_resident_corporate = r0040_after_resident_corporate;
	}
	public BigDecimal getR0040_before_nonresident_corporate() {
		return r0040_before_nonresident_corporate;
	}
	public void setR0040_before_nonresident_corporate(BigDecimal r0040_before_nonresident_corporate) {
		this.r0040_before_nonresident_corporate = r0040_before_nonresident_corporate;
	}
	public BigDecimal getR0040_after_nonresident_corporate() {
		return r0040_after_nonresident_corporate;
	}
	public void setR0040_after_nonresident_corporate(BigDecimal r0040_after_nonresident_corporate) {
		this.r0040_after_nonresident_corporate = r0040_after_nonresident_corporate;
	}
	public BigDecimal getR0040_before_resident_nbfi() {
		return r0040_before_resident_nbfi;
	}
	public void setR0040_before_resident_nbfi(BigDecimal r0040_before_resident_nbfi) {
		this.r0040_before_resident_nbfi = r0040_before_resident_nbfi;
	}
	public BigDecimal getR0040_after_resident_nbfi() {
		return r0040_after_resident_nbfi;
	}
	public void setR0040_after_resident_nbfi(BigDecimal r0040_after_resident_nbfi) {
		this.r0040_after_resident_nbfi = r0040_after_resident_nbfi;
	}
	public BigDecimal getR0040_before_nonresident_nbfi() {
		return r0040_before_nonresident_nbfi;
	}
	public void setR0040_before_nonresident_nbfi(BigDecimal r0040_before_nonresident_nbfi) {
		this.r0040_before_nonresident_nbfi = r0040_before_nonresident_nbfi;
	}
	public BigDecimal getR0040_after_nonresident_nbfi() {
		return r0040_after_nonresident_nbfi;
	}
	public void setR0040_after_nonresident_nbfi(BigDecimal r0040_after_nonresident_nbfi) {
		this.r0040_after_nonresident_nbfi = r0040_after_nonresident_nbfi;
	}
	public BigDecimal getR0040_before_resident_bank() {
		return r0040_before_resident_bank;
	}
	public void setR0040_before_resident_bank(BigDecimal r0040_before_resident_bank) {
		this.r0040_before_resident_bank = r0040_before_resident_bank;
	}
	public BigDecimal getR0040_after_resident_bank() {
		return r0040_after_resident_bank;
	}
	public void setR0040_after_resident_bank(BigDecimal r0040_after_resident_bank) {
		this.r0040_after_resident_bank = r0040_after_resident_bank;
	}
	public BigDecimal getR0040_before_nonresident_bank() {
		return r0040_before_nonresident_bank;
	}
	public void setR0040_before_nonresident_bank(BigDecimal r0040_before_nonresident_bank) {
		this.r0040_before_nonresident_bank = r0040_before_nonresident_bank;
	}
	public BigDecimal getR0040_after_nonresident_bank() {
		return r0040_after_nonresident_bank;
	}
	public void setR0040_after_nonresident_bank(BigDecimal r0040_after_nonresident_bank) {
		this.r0040_after_nonresident_bank = r0040_after_nonresident_bank;
	}
	public BigDecimal getR0040_before_resident_government() {
		return r0040_before_resident_government;
	}
	public void setR0040_before_resident_government(BigDecimal r0040_before_resident_government) {
		this.r0040_before_resident_government = r0040_before_resident_government;
	}
	public BigDecimal getR0040_after_resident_government() {
		return r0040_after_resident_government;
	}
	public void setR0040_after_resident_government(BigDecimal r0040_after_resident_government) {
		this.r0040_after_resident_government = r0040_after_resident_government;
	}
	public BigDecimal getR0040_before_nonresident_government() {
		return r0040_before_nonresident_government;
	}
	public void setR0040_before_nonresident_government(BigDecimal r0040_before_nonresident_government) {
		this.r0040_before_nonresident_government = r0040_before_nonresident_government;
	}
	public BigDecimal getR0040_after_nonresident_government() {
		return r0040_after_nonresident_government;
	}
	public void setR0040_after_nonresident_government(BigDecimal r0040_after_nonresident_government) {
		this.r0040_after_nonresident_government = r0040_after_nonresident_government;
	}
	public String getR0050_product() {
		return r0050_product;
	}
	public void setR0050_product(String r0050_product) {
		this.r0050_product = r0050_product;
	}
	public BigDecimal getR0050_before_resident_individual() {
		return r0050_before_resident_individual;
	}
	public void setR0050_before_resident_individual(BigDecimal r0050_before_resident_individual) {
		this.r0050_before_resident_individual = r0050_before_resident_individual;
	}
	public BigDecimal getR0050_after_resident_individual() {
		return r0050_after_resident_individual;
	}
	public void setR0050_after_resident_individual(BigDecimal r0050_after_resident_individual) {
		this.r0050_after_resident_individual = r0050_after_resident_individual;
	}
	public BigDecimal getR0050_before_nonresident_individual() {
		return r0050_before_nonresident_individual;
	}
	public void setR0050_before_nonresident_individual(BigDecimal r0050_before_nonresident_individual) {
		this.r0050_before_nonresident_individual = r0050_before_nonresident_individual;
	}
	public BigDecimal getR0050_after_nonresident_individual() {
		return r0050_after_nonresident_individual;
	}
	public void setR0050_after_nonresident_individual(BigDecimal r0050_after_nonresident_individual) {
		this.r0050_after_nonresident_individual = r0050_after_nonresident_individual;
	}
	public BigDecimal getR0050_before_resident_retail() {
		return r0050_before_resident_retail;
	}
	public void setR0050_before_resident_retail(BigDecimal r0050_before_resident_retail) {
		this.r0050_before_resident_retail = r0050_before_resident_retail;
	}
	public BigDecimal getR0050_after_resident_retail() {
		return r0050_after_resident_retail;
	}
	public void setR0050_after_resident_retail(BigDecimal r0050_after_resident_retail) {
		this.r0050_after_resident_retail = r0050_after_resident_retail;
	}
	public BigDecimal getR0050_before_nonresident_retail() {
		return r0050_before_nonresident_retail;
	}
	public void setR0050_before_nonresident_retail(BigDecimal r0050_before_nonresident_retail) {
		this.r0050_before_nonresident_retail = r0050_before_nonresident_retail;
	}
	public BigDecimal getR0050_after_nonresident_retail() {
		return r0050_after_nonresident_retail;
	}
	public void setR0050_after_nonresident_retail(BigDecimal r0050_after_nonresident_retail) {
		this.r0050_after_nonresident_retail = r0050_after_nonresident_retail;
	}
	public BigDecimal getR0050_before_resident_sme() {
		return r0050_before_resident_sme;
	}
	public void setR0050_before_resident_sme(BigDecimal r0050_before_resident_sme) {
		this.r0050_before_resident_sme = r0050_before_resident_sme;
	}
	public BigDecimal getR0050_after_resident_sme() {
		return r0050_after_resident_sme;
	}
	public void setR0050_after_resident_sme(BigDecimal r0050_after_resident_sme) {
		this.r0050_after_resident_sme = r0050_after_resident_sme;
	}
	public BigDecimal getR0050_before_nonresident_sme() {
		return r0050_before_nonresident_sme;
	}
	public void setR0050_before_nonresident_sme(BigDecimal r0050_before_nonresident_sme) {
		this.r0050_before_nonresident_sme = r0050_before_nonresident_sme;
	}
	public BigDecimal getR0050_after_nonresident_sme() {
		return r0050_after_nonresident_sme;
	}
	public void setR0050_after_nonresident_sme(BigDecimal r0050_after_nonresident_sme) {
		this.r0050_after_nonresident_sme = r0050_after_nonresident_sme;
	}
	public BigDecimal getR0050_before_resident_hni() {
		return r0050_before_resident_hni;
	}
	public void setR0050_before_resident_hni(BigDecimal r0050_before_resident_hni) {
		this.r0050_before_resident_hni = r0050_before_resident_hni;
	}
	public BigDecimal getR0050_after_resident_hni() {
		return r0050_after_resident_hni;
	}
	public void setR0050_after_resident_hni(BigDecimal r0050_after_resident_hni) {
		this.r0050_after_resident_hni = r0050_after_resident_hni;
	}
	public BigDecimal getR0050_before_nonresident_hni() {
		return r0050_before_nonresident_hni;
	}
	public void setR0050_before_nonresident_hni(BigDecimal r0050_before_nonresident_hni) {
		this.r0050_before_nonresident_hni = r0050_before_nonresident_hni;
	}
	public BigDecimal getR0050_after_nonresident_hni() {
		return r0050_after_nonresident_hni;
	}
	public void setR0050_after_nonresident_hni(BigDecimal r0050_after_nonresident_hni) {
		this.r0050_after_nonresident_hni = r0050_after_nonresident_hni;
	}
	public BigDecimal getR0050_before_resident_gre() {
		return r0050_before_resident_gre;
	}
	public void setR0050_before_resident_gre(BigDecimal r0050_before_resident_gre) {
		this.r0050_before_resident_gre = r0050_before_resident_gre;
	}
	public BigDecimal getR0050_after_resident_gre() {
		return r0050_after_resident_gre;
	}
	public void setR0050_after_resident_gre(BigDecimal r0050_after_resident_gre) {
		this.r0050_after_resident_gre = r0050_after_resident_gre;
	}
	public BigDecimal getR0050_before_nonresident_gre() {
		return r0050_before_nonresident_gre;
	}
	public void setR0050_before_nonresident_gre(BigDecimal r0050_before_nonresident_gre) {
		this.r0050_before_nonresident_gre = r0050_before_nonresident_gre;
	}
	public BigDecimal getR0050_after_nonresident_gre() {
		return r0050_after_nonresident_gre;
	}
	public void setR0050_after_nonresident_gre(BigDecimal r0050_after_nonresident_gre) {
		this.r0050_after_nonresident_gre = r0050_after_nonresident_gre;
	}
	public BigDecimal getR0050_before_resident_corporate() {
		return r0050_before_resident_corporate;
	}
	public void setR0050_before_resident_corporate(BigDecimal r0050_before_resident_corporate) {
		this.r0050_before_resident_corporate = r0050_before_resident_corporate;
	}
	public BigDecimal getR0050_after_resident_corporate() {
		return r0050_after_resident_corporate;
	}
	public void setR0050_after_resident_corporate(BigDecimal r0050_after_resident_corporate) {
		this.r0050_after_resident_corporate = r0050_after_resident_corporate;
	}
	public BigDecimal getR0050_before_nonresident_corporate() {
		return r0050_before_nonresident_corporate;
	}
	public void setR0050_before_nonresident_corporate(BigDecimal r0050_before_nonresident_corporate) {
		this.r0050_before_nonresident_corporate = r0050_before_nonresident_corporate;
	}
	public BigDecimal getR0050_after_nonresident_corporate() {
		return r0050_after_nonresident_corporate;
	}
	public void setR0050_after_nonresident_corporate(BigDecimal r0050_after_nonresident_corporate) {
		this.r0050_after_nonresident_corporate = r0050_after_nonresident_corporate;
	}
	public BigDecimal getR0050_before_resident_nbfi() {
		return r0050_before_resident_nbfi;
	}
	public void setR0050_before_resident_nbfi(BigDecimal r0050_before_resident_nbfi) {
		this.r0050_before_resident_nbfi = r0050_before_resident_nbfi;
	}
	public BigDecimal getR0050_after_resident_nbfi() {
		return r0050_after_resident_nbfi;
	}
	public void setR0050_after_resident_nbfi(BigDecimal r0050_after_resident_nbfi) {
		this.r0050_after_resident_nbfi = r0050_after_resident_nbfi;
	}
	public BigDecimal getR0050_before_nonresident_nbfi() {
		return r0050_before_nonresident_nbfi;
	}
	public void setR0050_before_nonresident_nbfi(BigDecimal r0050_before_nonresident_nbfi) {
		this.r0050_before_nonresident_nbfi = r0050_before_nonresident_nbfi;
	}
	public BigDecimal getR0050_after_nonresident_nbfi() {
		return r0050_after_nonresident_nbfi;
	}
	public void setR0050_after_nonresident_nbfi(BigDecimal r0050_after_nonresident_nbfi) {
		this.r0050_after_nonresident_nbfi = r0050_after_nonresident_nbfi;
	}
	public BigDecimal getR0050_before_resident_bank() {
		return r0050_before_resident_bank;
	}
	public void setR0050_before_resident_bank(BigDecimal r0050_before_resident_bank) {
		this.r0050_before_resident_bank = r0050_before_resident_bank;
	}
	public BigDecimal getR0050_after_resident_bank() {
		return r0050_after_resident_bank;
	}
	public void setR0050_after_resident_bank(BigDecimal r0050_after_resident_bank) {
		this.r0050_after_resident_bank = r0050_after_resident_bank;
	}
	public BigDecimal getR0050_before_nonresident_bank() {
		return r0050_before_nonresident_bank;
	}
	public void setR0050_before_nonresident_bank(BigDecimal r0050_before_nonresident_bank) {
		this.r0050_before_nonresident_bank = r0050_before_nonresident_bank;
	}
	public BigDecimal getR0050_after_nonresident_bank() {
		return r0050_after_nonresident_bank;
	}
	public void setR0050_after_nonresident_bank(BigDecimal r0050_after_nonresident_bank) {
		this.r0050_after_nonresident_bank = r0050_after_nonresident_bank;
	}
	public BigDecimal getR0050_before_resident_government() {
		return r0050_before_resident_government;
	}
	public void setR0050_before_resident_government(BigDecimal r0050_before_resident_government) {
		this.r0050_before_resident_government = r0050_before_resident_government;
	}
	public BigDecimal getR0050_after_resident_government() {
		return r0050_after_resident_government;
	}
	public void setR0050_after_resident_government(BigDecimal r0050_after_resident_government) {
		this.r0050_after_resident_government = r0050_after_resident_government;
	}
	public BigDecimal getR0050_before_nonresident_government() {
		return r0050_before_nonresident_government;
	}
	public void setR0050_before_nonresident_government(BigDecimal r0050_before_nonresident_government) {
		this.r0050_before_nonresident_government = r0050_before_nonresident_government;
	}
	public BigDecimal getR0050_after_nonresident_government() {
		return r0050_after_nonresident_government;
	}
	public void setR0050_after_nonresident_government(BigDecimal r0050_after_nonresident_government) {
		this.r0050_after_nonresident_government = r0050_after_nonresident_government;
	}
	public String getR0060_product() {
		return r0060_product;
	}
	public void setR0060_product(String r0060_product) {
		this.r0060_product = r0060_product;
	}
	public BigDecimal getR0060_before_resident_individual() {
		return r0060_before_resident_individual;
	}
	public void setR0060_before_resident_individual(BigDecimal r0060_before_resident_individual) {
		this.r0060_before_resident_individual = r0060_before_resident_individual;
	}
	public BigDecimal getR0060_after_resident_individual() {
		return r0060_after_resident_individual;
	}
	public void setR0060_after_resident_individual(BigDecimal r0060_after_resident_individual) {
		this.r0060_after_resident_individual = r0060_after_resident_individual;
	}
	public BigDecimal getR0060_before_nonresident_individual() {
		return r0060_before_nonresident_individual;
	}
	public void setR0060_before_nonresident_individual(BigDecimal r0060_before_nonresident_individual) {
		this.r0060_before_nonresident_individual = r0060_before_nonresident_individual;
	}
	public BigDecimal getR0060_after_nonresident_individual() {
		return r0060_after_nonresident_individual;
	}
	public void setR0060_after_nonresident_individual(BigDecimal r0060_after_nonresident_individual) {
		this.r0060_after_nonresident_individual = r0060_after_nonresident_individual;
	}
	public BigDecimal getR0060_before_resident_retail() {
		return r0060_before_resident_retail;
	}
	public void setR0060_before_resident_retail(BigDecimal r0060_before_resident_retail) {
		this.r0060_before_resident_retail = r0060_before_resident_retail;
	}
	public BigDecimal getR0060_after_resident_retail() {
		return r0060_after_resident_retail;
	}
	public void setR0060_after_resident_retail(BigDecimal r0060_after_resident_retail) {
		this.r0060_after_resident_retail = r0060_after_resident_retail;
	}
	public BigDecimal getR0060_before_nonresident_retail() {
		return r0060_before_nonresident_retail;
	}
	public void setR0060_before_nonresident_retail(BigDecimal r0060_before_nonresident_retail) {
		this.r0060_before_nonresident_retail = r0060_before_nonresident_retail;
	}
	public BigDecimal getR0060_after_nonresident_retail() {
		return r0060_after_nonresident_retail;
	}
	public void setR0060_after_nonresident_retail(BigDecimal r0060_after_nonresident_retail) {
		this.r0060_after_nonresident_retail = r0060_after_nonresident_retail;
	}
	public BigDecimal getR0060_before_resident_sme() {
		return r0060_before_resident_sme;
	}
	public void setR0060_before_resident_sme(BigDecimal r0060_before_resident_sme) {
		this.r0060_before_resident_sme = r0060_before_resident_sme;
	}
	public BigDecimal getR0060_after_resident_sme() {
		return r0060_after_resident_sme;
	}
	public void setR0060_after_resident_sme(BigDecimal r0060_after_resident_sme) {
		this.r0060_after_resident_sme = r0060_after_resident_sme;
	}
	public BigDecimal getR0060_before_nonresident_sme() {
		return r0060_before_nonresident_sme;
	}
	public void setR0060_before_nonresident_sme(BigDecimal r0060_before_nonresident_sme) {
		this.r0060_before_nonresident_sme = r0060_before_nonresident_sme;
	}
	public BigDecimal getR0060_after_nonresident_sme() {
		return r0060_after_nonresident_sme;
	}
	public void setR0060_after_nonresident_sme(BigDecimal r0060_after_nonresident_sme) {
		this.r0060_after_nonresident_sme = r0060_after_nonresident_sme;
	}
	public BigDecimal getR0060_before_resident_hni() {
		return r0060_before_resident_hni;
	}
	public void setR0060_before_resident_hni(BigDecimal r0060_before_resident_hni) {
		this.r0060_before_resident_hni = r0060_before_resident_hni;
	}
	public BigDecimal getR0060_after_resident_hni() {
		return r0060_after_resident_hni;
	}
	public void setR0060_after_resident_hni(BigDecimal r0060_after_resident_hni) {
		this.r0060_after_resident_hni = r0060_after_resident_hni;
	}
	public BigDecimal getR0060_before_nonresident_hni() {
		return r0060_before_nonresident_hni;
	}
	public void setR0060_before_nonresident_hni(BigDecimal r0060_before_nonresident_hni) {
		this.r0060_before_nonresident_hni = r0060_before_nonresident_hni;
	}
	public BigDecimal getR0060_after_nonresident_hni() {
		return r0060_after_nonresident_hni;
	}
	public void setR0060_after_nonresident_hni(BigDecimal r0060_after_nonresident_hni) {
		this.r0060_after_nonresident_hni = r0060_after_nonresident_hni;
	}
	public BigDecimal getR0060_before_resident_gre() {
		return r0060_before_resident_gre;
	}
	public void setR0060_before_resident_gre(BigDecimal r0060_before_resident_gre) {
		this.r0060_before_resident_gre = r0060_before_resident_gre;
	}
	public BigDecimal getR0060_after_resident_gre() {
		return r0060_after_resident_gre;
	}
	public void setR0060_after_resident_gre(BigDecimal r0060_after_resident_gre) {
		this.r0060_after_resident_gre = r0060_after_resident_gre;
	}
	public BigDecimal getR0060_before_nonresident_gre() {
		return r0060_before_nonresident_gre;
	}
	public void setR0060_before_nonresident_gre(BigDecimal r0060_before_nonresident_gre) {
		this.r0060_before_nonresident_gre = r0060_before_nonresident_gre;
	}
	public BigDecimal getR0060_after_nonresident_gre() {
		return r0060_after_nonresident_gre;
	}
	public void setR0060_after_nonresident_gre(BigDecimal r0060_after_nonresident_gre) {
		this.r0060_after_nonresident_gre = r0060_after_nonresident_gre;
	}
	public BigDecimal getR0060_before_resident_corporate() {
		return r0060_before_resident_corporate;
	}
	public void setR0060_before_resident_corporate(BigDecimal r0060_before_resident_corporate) {
		this.r0060_before_resident_corporate = r0060_before_resident_corporate;
	}
	public BigDecimal getR0060_after_resident_corporate() {
		return r0060_after_resident_corporate;
	}
	public void setR0060_after_resident_corporate(BigDecimal r0060_after_resident_corporate) {
		this.r0060_after_resident_corporate = r0060_after_resident_corporate;
	}
	public BigDecimal getR0060_before_nonresident_corporate() {
		return r0060_before_nonresident_corporate;
	}
	public void setR0060_before_nonresident_corporate(BigDecimal r0060_before_nonresident_corporate) {
		this.r0060_before_nonresident_corporate = r0060_before_nonresident_corporate;
	}
	public BigDecimal getR0060_after_nonresident_corporate() {
		return r0060_after_nonresident_corporate;
	}
	public void setR0060_after_nonresident_corporate(BigDecimal r0060_after_nonresident_corporate) {
		this.r0060_after_nonresident_corporate = r0060_after_nonresident_corporate;
	}
	public BigDecimal getR0060_before_resident_nbfi() {
		return r0060_before_resident_nbfi;
	}
	public void setR0060_before_resident_nbfi(BigDecimal r0060_before_resident_nbfi) {
		this.r0060_before_resident_nbfi = r0060_before_resident_nbfi;
	}
	public BigDecimal getR0060_after_resident_nbfi() {
		return r0060_after_resident_nbfi;
	}
	public void setR0060_after_resident_nbfi(BigDecimal r0060_after_resident_nbfi) {
		this.r0060_after_resident_nbfi = r0060_after_resident_nbfi;
	}
	public BigDecimal getR0060_before_nonresident_nbfi() {
		return r0060_before_nonresident_nbfi;
	}
	public void setR0060_before_nonresident_nbfi(BigDecimal r0060_before_nonresident_nbfi) {
		this.r0060_before_nonresident_nbfi = r0060_before_nonresident_nbfi;
	}
	public BigDecimal getR0060_after_nonresident_nbfi() {
		return r0060_after_nonresident_nbfi;
	}
	public void setR0060_after_nonresident_nbfi(BigDecimal r0060_after_nonresident_nbfi) {
		this.r0060_after_nonresident_nbfi = r0060_after_nonresident_nbfi;
	}
	public BigDecimal getR0060_before_resident_bank() {
		return r0060_before_resident_bank;
	}
	public void setR0060_before_resident_bank(BigDecimal r0060_before_resident_bank) {
		this.r0060_before_resident_bank = r0060_before_resident_bank;
	}
	public BigDecimal getR0060_after_resident_bank() {
		return r0060_after_resident_bank;
	}
	public void setR0060_after_resident_bank(BigDecimal r0060_after_resident_bank) {
		this.r0060_after_resident_bank = r0060_after_resident_bank;
	}
	public BigDecimal getR0060_before_nonresident_bank() {
		return r0060_before_nonresident_bank;
	}
	public void setR0060_before_nonresident_bank(BigDecimal r0060_before_nonresident_bank) {
		this.r0060_before_nonresident_bank = r0060_before_nonresident_bank;
	}
	public BigDecimal getR0060_after_nonresident_bank() {
		return r0060_after_nonresident_bank;
	}
	public void setR0060_after_nonresident_bank(BigDecimal r0060_after_nonresident_bank) {
		this.r0060_after_nonresident_bank = r0060_after_nonresident_bank;
	}
	public BigDecimal getR0060_before_resident_government() {
		return r0060_before_resident_government;
	}
	public void setR0060_before_resident_government(BigDecimal r0060_before_resident_government) {
		this.r0060_before_resident_government = r0060_before_resident_government;
	}
	public BigDecimal getR0060_after_resident_government() {
		return r0060_after_resident_government;
	}
	public void setR0060_after_resident_government(BigDecimal r0060_after_resident_government) {
		this.r0060_after_resident_government = r0060_after_resident_government;
	}
	public BigDecimal getR0060_before_nonresident_government() {
		return r0060_before_nonresident_government;
	}
	public void setR0060_before_nonresident_government(BigDecimal r0060_before_nonresident_government) {
		this.r0060_before_nonresident_government = r0060_before_nonresident_government;
	}
	public BigDecimal getR0060_after_nonresident_government() {
		return r0060_after_nonresident_government;
	}
	public void setR0060_after_nonresident_government(BigDecimal r0060_after_nonresident_government) {
		this.r0060_after_nonresident_government = r0060_after_nonresident_government;
	}
	public String getR0070_product() {
		return r0070_product;
	}
	public void setR0070_product(String r0070_product) {
		this.r0070_product = r0070_product;
	}
	public BigDecimal getR0070_before_resident_individual() {
		return r0070_before_resident_individual;
	}
	public void setR0070_before_resident_individual(BigDecimal r0070_before_resident_individual) {
		this.r0070_before_resident_individual = r0070_before_resident_individual;
	}
	public BigDecimal getR0070_after_resident_individual() {
		return r0070_after_resident_individual;
	}
	public void setR0070_after_resident_individual(BigDecimal r0070_after_resident_individual) {
		this.r0070_after_resident_individual = r0070_after_resident_individual;
	}
	public BigDecimal getR0070_before_nonresident_individual() {
		return r0070_before_nonresident_individual;
	}
	public void setR0070_before_nonresident_individual(BigDecimal r0070_before_nonresident_individual) {
		this.r0070_before_nonresident_individual = r0070_before_nonresident_individual;
	}
	public BigDecimal getR0070_after_nonresident_individual() {
		return r0070_after_nonresident_individual;
	}
	public void setR0070_after_nonresident_individual(BigDecimal r0070_after_nonresident_individual) {
		this.r0070_after_nonresident_individual = r0070_after_nonresident_individual;
	}
	public BigDecimal getR0070_before_resident_retail() {
		return r0070_before_resident_retail;
	}
	public void setR0070_before_resident_retail(BigDecimal r0070_before_resident_retail) {
		this.r0070_before_resident_retail = r0070_before_resident_retail;
	}
	public BigDecimal getR0070_after_resident_retail() {
		return r0070_after_resident_retail;
	}
	public void setR0070_after_resident_retail(BigDecimal r0070_after_resident_retail) {
		this.r0070_after_resident_retail = r0070_after_resident_retail;
	}
	public BigDecimal getR0070_before_nonresident_retail() {
		return r0070_before_nonresident_retail;
	}
	public void setR0070_before_nonresident_retail(BigDecimal r0070_before_nonresident_retail) {
		this.r0070_before_nonresident_retail = r0070_before_nonresident_retail;
	}
	public BigDecimal getR0070_after_nonresident_retail() {
		return r0070_after_nonresident_retail;
	}
	public void setR0070_after_nonresident_retail(BigDecimal r0070_after_nonresident_retail) {
		this.r0070_after_nonresident_retail = r0070_after_nonresident_retail;
	}
	public BigDecimal getR0070_before_resident_sme() {
		return r0070_before_resident_sme;
	}
	public void setR0070_before_resident_sme(BigDecimal r0070_before_resident_sme) {
		this.r0070_before_resident_sme = r0070_before_resident_sme;
	}
	public BigDecimal getR0070_after_resident_sme() {
		return r0070_after_resident_sme;
	}
	public void setR0070_after_resident_sme(BigDecimal r0070_after_resident_sme) {
		this.r0070_after_resident_sme = r0070_after_resident_sme;
	}
	public BigDecimal getR0070_before_nonresident_sme() {
		return r0070_before_nonresident_sme;
	}
	public void setR0070_before_nonresident_sme(BigDecimal r0070_before_nonresident_sme) {
		this.r0070_before_nonresident_sme = r0070_before_nonresident_sme;
	}
	public BigDecimal getR0070_after_nonresident_sme() {
		return r0070_after_nonresident_sme;
	}
	public void setR0070_after_nonresident_sme(BigDecimal r0070_after_nonresident_sme) {
		this.r0070_after_nonresident_sme = r0070_after_nonresident_sme;
	}
	public BigDecimal getR0070_before_resident_hni() {
		return r0070_before_resident_hni;
	}
	public void setR0070_before_resident_hni(BigDecimal r0070_before_resident_hni) {
		this.r0070_before_resident_hni = r0070_before_resident_hni;
	}
	public BigDecimal getR0070_after_resident_hni() {
		return r0070_after_resident_hni;
	}
	public void setR0070_after_resident_hni(BigDecimal r0070_after_resident_hni) {
		this.r0070_after_resident_hni = r0070_after_resident_hni;
	}
	public BigDecimal getR0070_before_nonresident_hni() {
		return r0070_before_nonresident_hni;
	}
	public void setR0070_before_nonresident_hni(BigDecimal r0070_before_nonresident_hni) {
		this.r0070_before_nonresident_hni = r0070_before_nonresident_hni;
	}
	public BigDecimal getR0070_after_nonresident_hni() {
		return r0070_after_nonresident_hni;
	}
	public void setR0070_after_nonresident_hni(BigDecimal r0070_after_nonresident_hni) {
		this.r0070_after_nonresident_hni = r0070_after_nonresident_hni;
	}
	public BigDecimal getR0070_before_resident_gre() {
		return r0070_before_resident_gre;
	}
	public void setR0070_before_resident_gre(BigDecimal r0070_before_resident_gre) {
		this.r0070_before_resident_gre = r0070_before_resident_gre;
	}
	public BigDecimal getR0070_after_resident_gre() {
		return r0070_after_resident_gre;
	}
	public void setR0070_after_resident_gre(BigDecimal r0070_after_resident_gre) {
		this.r0070_after_resident_gre = r0070_after_resident_gre;
	}
	public BigDecimal getR0070_before_nonresident_gre() {
		return r0070_before_nonresident_gre;
	}
	public void setR0070_before_nonresident_gre(BigDecimal r0070_before_nonresident_gre) {
		this.r0070_before_nonresident_gre = r0070_before_nonresident_gre;
	}
	public BigDecimal getR0070_after_nonresident_gre() {
		return r0070_after_nonresident_gre;
	}
	public void setR0070_after_nonresident_gre(BigDecimal r0070_after_nonresident_gre) {
		this.r0070_after_nonresident_gre = r0070_after_nonresident_gre;
	}
	public BigDecimal getR0070_before_resident_corporate() {
		return r0070_before_resident_corporate;
	}
	public void setR0070_before_resident_corporate(BigDecimal r0070_before_resident_corporate) {
		this.r0070_before_resident_corporate = r0070_before_resident_corporate;
	}
	public BigDecimal getR0070_after_resident_corporate() {
		return r0070_after_resident_corporate;
	}
	public void setR0070_after_resident_corporate(BigDecimal r0070_after_resident_corporate) {
		this.r0070_after_resident_corporate = r0070_after_resident_corporate;
	}
	public BigDecimal getR0070_before_nonresident_corporate() {
		return r0070_before_nonresident_corporate;
	}
	public void setR0070_before_nonresident_corporate(BigDecimal r0070_before_nonresident_corporate) {
		this.r0070_before_nonresident_corporate = r0070_before_nonresident_corporate;
	}
	public BigDecimal getR0070_after_nonresident_corporate() {
		return r0070_after_nonresident_corporate;
	}
	public void setR0070_after_nonresident_corporate(BigDecimal r0070_after_nonresident_corporate) {
		this.r0070_after_nonresident_corporate = r0070_after_nonresident_corporate;
	}
	public BigDecimal getR0070_before_resident_nbfi() {
		return r0070_before_resident_nbfi;
	}
	public void setR0070_before_resident_nbfi(BigDecimal r0070_before_resident_nbfi) {
		this.r0070_before_resident_nbfi = r0070_before_resident_nbfi;
	}
	public BigDecimal getR0070_after_resident_nbfi() {
		return r0070_after_resident_nbfi;
	}
	public void setR0070_after_resident_nbfi(BigDecimal r0070_after_resident_nbfi) {
		this.r0070_after_resident_nbfi = r0070_after_resident_nbfi;
	}
	public BigDecimal getR0070_before_nonresident_nbfi() {
		return r0070_before_nonresident_nbfi;
	}
	public void setR0070_before_nonresident_nbfi(BigDecimal r0070_before_nonresident_nbfi) {
		this.r0070_before_nonresident_nbfi = r0070_before_nonresident_nbfi;
	}
	public BigDecimal getR0070_after_nonresident_nbfi() {
		return r0070_after_nonresident_nbfi;
	}
	public void setR0070_after_nonresident_nbfi(BigDecimal r0070_after_nonresident_nbfi) {
		this.r0070_after_nonresident_nbfi = r0070_after_nonresident_nbfi;
	}
	public BigDecimal getR0070_before_resident_bank() {
		return r0070_before_resident_bank;
	}
	public void setR0070_before_resident_bank(BigDecimal r0070_before_resident_bank) {
		this.r0070_before_resident_bank = r0070_before_resident_bank;
	}
	public BigDecimal getR0070_after_resident_bank() {
		return r0070_after_resident_bank;
	}
	public void setR0070_after_resident_bank(BigDecimal r0070_after_resident_bank) {
		this.r0070_after_resident_bank = r0070_after_resident_bank;
	}
	public BigDecimal getR0070_before_nonresident_bank() {
		return r0070_before_nonresident_bank;
	}
	public void setR0070_before_nonresident_bank(BigDecimal r0070_before_nonresident_bank) {
		this.r0070_before_nonresident_bank = r0070_before_nonresident_bank;
	}
	public BigDecimal getR0070_after_nonresident_bank() {
		return r0070_after_nonresident_bank;
	}
	public void setR0070_after_nonresident_bank(BigDecimal r0070_after_nonresident_bank) {
		this.r0070_after_nonresident_bank = r0070_after_nonresident_bank;
	}
	public BigDecimal getR0070_before_resident_government() {
		return r0070_before_resident_government;
	}
	public void setR0070_before_resident_government(BigDecimal r0070_before_resident_government) {
		this.r0070_before_resident_government = r0070_before_resident_government;
	}
	public BigDecimal getR0070_after_resident_government() {
		return r0070_after_resident_government;
	}
	public void setR0070_after_resident_government(BigDecimal r0070_after_resident_government) {
		this.r0070_after_resident_government = r0070_after_resident_government;
	}
	public BigDecimal getR0070_before_nonresident_government() {
		return r0070_before_nonresident_government;
	}
	public void setR0070_before_nonresident_government(BigDecimal r0070_before_nonresident_government) {
		this.r0070_before_nonresident_government = r0070_before_nonresident_government;
	}
	public BigDecimal getR0070_after_nonresident_government() {
		return r0070_after_nonresident_government;
	}
	public void setR0070_after_nonresident_government(BigDecimal r0070_after_nonresident_government) {
		this.r0070_after_nonresident_government = r0070_after_nonresident_government;
	}
	public String getR0080_product() {
		return r0080_product;
	}
	public void setR0080_product(String r0080_product) {
		this.r0080_product = r0080_product;
	}
	public BigDecimal getR0080_before_resident_individual() {
		return r0080_before_resident_individual;
	}
	public void setR0080_before_resident_individual(BigDecimal r0080_before_resident_individual) {
		this.r0080_before_resident_individual = r0080_before_resident_individual;
	}
	public BigDecimal getR0080_after_resident_individual() {
		return r0080_after_resident_individual;
	}
	public void setR0080_after_resident_individual(BigDecimal r0080_after_resident_individual) {
		this.r0080_after_resident_individual = r0080_after_resident_individual;
	}
	public BigDecimal getR0080_before_nonresident_individual() {
		return r0080_before_nonresident_individual;
	}
	public void setR0080_before_nonresident_individual(BigDecimal r0080_before_nonresident_individual) {
		this.r0080_before_nonresident_individual = r0080_before_nonresident_individual;
	}
	public BigDecimal getR0080_after_nonresident_individual() {
		return r0080_after_nonresident_individual;
	}
	public void setR0080_after_nonresident_individual(BigDecimal r0080_after_nonresident_individual) {
		this.r0080_after_nonresident_individual = r0080_after_nonresident_individual;
	}
	public BigDecimal getR0080_before_resident_retail() {
		return r0080_before_resident_retail;
	}
	public void setR0080_before_resident_retail(BigDecimal r0080_before_resident_retail) {
		this.r0080_before_resident_retail = r0080_before_resident_retail;
	}
	public BigDecimal getR0080_after_resident_retail() {
		return r0080_after_resident_retail;
	}
	public void setR0080_after_resident_retail(BigDecimal r0080_after_resident_retail) {
		this.r0080_after_resident_retail = r0080_after_resident_retail;
	}
	public BigDecimal getR0080_before_nonresident_retail() {
		return r0080_before_nonresident_retail;
	}
	public void setR0080_before_nonresident_retail(BigDecimal r0080_before_nonresident_retail) {
		this.r0080_before_nonresident_retail = r0080_before_nonresident_retail;
	}
	public BigDecimal getR0080_after_nonresident_retail() {
		return r0080_after_nonresident_retail;
	}
	public void setR0080_after_nonresident_retail(BigDecimal r0080_after_nonresident_retail) {
		this.r0080_after_nonresident_retail = r0080_after_nonresident_retail;
	}
	public BigDecimal getR0080_before_resident_sme() {
		return r0080_before_resident_sme;
	}
	public void setR0080_before_resident_sme(BigDecimal r0080_before_resident_sme) {
		this.r0080_before_resident_sme = r0080_before_resident_sme;
	}
	public BigDecimal getR0080_after_resident_sme() {
		return r0080_after_resident_sme;
	}
	public void setR0080_after_resident_sme(BigDecimal r0080_after_resident_sme) {
		this.r0080_after_resident_sme = r0080_after_resident_sme;
	}
	public BigDecimal getR0080_before_nonresident_sme() {
		return r0080_before_nonresident_sme;
	}
	public void setR0080_before_nonresident_sme(BigDecimal r0080_before_nonresident_sme) {
		this.r0080_before_nonresident_sme = r0080_before_nonresident_sme;
	}
	public BigDecimal getR0080_after_nonresident_sme() {
		return r0080_after_nonresident_sme;
	}
	public void setR0080_after_nonresident_sme(BigDecimal r0080_after_nonresident_sme) {
		this.r0080_after_nonresident_sme = r0080_after_nonresident_sme;
	}
	public BigDecimal getR0080_before_resident_hni() {
		return r0080_before_resident_hni;
	}
	public void setR0080_before_resident_hni(BigDecimal r0080_before_resident_hni) {
		this.r0080_before_resident_hni = r0080_before_resident_hni;
	}
	public BigDecimal getR0080_after_resident_hni() {
		return r0080_after_resident_hni;
	}
	public void setR0080_after_resident_hni(BigDecimal r0080_after_resident_hni) {
		this.r0080_after_resident_hni = r0080_after_resident_hni;
	}
	public BigDecimal getR0080_before_nonresident_hni() {
		return r0080_before_nonresident_hni;
	}
	public void setR0080_before_nonresident_hni(BigDecimal r0080_before_nonresident_hni) {
		this.r0080_before_nonresident_hni = r0080_before_nonresident_hni;
	}
	public BigDecimal getR0080_after_nonresident_hni() {
		return r0080_after_nonresident_hni;
	}
	public void setR0080_after_nonresident_hni(BigDecimal r0080_after_nonresident_hni) {
		this.r0080_after_nonresident_hni = r0080_after_nonresident_hni;
	}
	public BigDecimal getR0080_before_resident_gre() {
		return r0080_before_resident_gre;
	}
	public void setR0080_before_resident_gre(BigDecimal r0080_before_resident_gre) {
		this.r0080_before_resident_gre = r0080_before_resident_gre;
	}
	public BigDecimal getR0080_after_resident_gre() {
		return r0080_after_resident_gre;
	}
	public void setR0080_after_resident_gre(BigDecimal r0080_after_resident_gre) {
		this.r0080_after_resident_gre = r0080_after_resident_gre;
	}
	public BigDecimal getR0080_before_nonresident_gre() {
		return r0080_before_nonresident_gre;
	}
	public void setR0080_before_nonresident_gre(BigDecimal r0080_before_nonresident_gre) {
		this.r0080_before_nonresident_gre = r0080_before_nonresident_gre;
	}
	public BigDecimal getR0080_after_nonresident_gre() {
		return r0080_after_nonresident_gre;
	}
	public void setR0080_after_nonresident_gre(BigDecimal r0080_after_nonresident_gre) {
		this.r0080_after_nonresident_gre = r0080_after_nonresident_gre;
	}
	public BigDecimal getR0080_before_resident_corporate() {
		return r0080_before_resident_corporate;
	}
	public void setR0080_before_resident_corporate(BigDecimal r0080_before_resident_corporate) {
		this.r0080_before_resident_corporate = r0080_before_resident_corporate;
	}
	public BigDecimal getR0080_after_resident_corporate() {
		return r0080_after_resident_corporate;
	}
	public void setR0080_after_resident_corporate(BigDecimal r0080_after_resident_corporate) {
		this.r0080_after_resident_corporate = r0080_after_resident_corporate;
	}
	public BigDecimal getR0080_before_nonresident_corporate() {
		return r0080_before_nonresident_corporate;
	}
	public void setR0080_before_nonresident_corporate(BigDecimal r0080_before_nonresident_corporate) {
		this.r0080_before_nonresident_corporate = r0080_before_nonresident_corporate;
	}
	public BigDecimal getR0080_after_nonresident_corporate() {
		return r0080_after_nonresident_corporate;
	}
	public void setR0080_after_nonresident_corporate(BigDecimal r0080_after_nonresident_corporate) {
		this.r0080_after_nonresident_corporate = r0080_after_nonresident_corporate;
	}
	public BigDecimal getR0080_before_resident_nbfi() {
		return r0080_before_resident_nbfi;
	}
	public void setR0080_before_resident_nbfi(BigDecimal r0080_before_resident_nbfi) {
		this.r0080_before_resident_nbfi = r0080_before_resident_nbfi;
	}
	public BigDecimal getR0080_after_resident_nbfi() {
		return r0080_after_resident_nbfi;
	}
	public void setR0080_after_resident_nbfi(BigDecimal r0080_after_resident_nbfi) {
		this.r0080_after_resident_nbfi = r0080_after_resident_nbfi;
	}
	public BigDecimal getR0080_before_nonresident_nbfi() {
		return r0080_before_nonresident_nbfi;
	}
	public void setR0080_before_nonresident_nbfi(BigDecimal r0080_before_nonresident_nbfi) {
		this.r0080_before_nonresident_nbfi = r0080_before_nonresident_nbfi;
	}
	public BigDecimal getR0080_after_nonresident_nbfi() {
		return r0080_after_nonresident_nbfi;
	}
	public void setR0080_after_nonresident_nbfi(BigDecimal r0080_after_nonresident_nbfi) {
		this.r0080_after_nonresident_nbfi = r0080_after_nonresident_nbfi;
	}
	public BigDecimal getR0080_before_resident_bank() {
		return r0080_before_resident_bank;
	}
	public void setR0080_before_resident_bank(BigDecimal r0080_before_resident_bank) {
		this.r0080_before_resident_bank = r0080_before_resident_bank;
	}
	public BigDecimal getR0080_after_resident_bank() {
		return r0080_after_resident_bank;
	}
	public void setR0080_after_resident_bank(BigDecimal r0080_after_resident_bank) {
		this.r0080_after_resident_bank = r0080_after_resident_bank;
	}
	public BigDecimal getR0080_before_nonresident_bank() {
		return r0080_before_nonresident_bank;
	}
	public void setR0080_before_nonresident_bank(BigDecimal r0080_before_nonresident_bank) {
		this.r0080_before_nonresident_bank = r0080_before_nonresident_bank;
	}
	public BigDecimal getR0080_after_nonresident_bank() {
		return r0080_after_nonresident_bank;
	}
	public void setR0080_after_nonresident_bank(BigDecimal r0080_after_nonresident_bank) {
		this.r0080_after_nonresident_bank = r0080_after_nonresident_bank;
	}
	public BigDecimal getR0080_before_resident_government() {
		return r0080_before_resident_government;
	}
	public void setR0080_before_resident_government(BigDecimal r0080_before_resident_government) {
		this.r0080_before_resident_government = r0080_before_resident_government;
	}
	public BigDecimal getR0080_after_resident_government() {
		return r0080_after_resident_government;
	}
	public void setR0080_after_resident_government(BigDecimal r0080_after_resident_government) {
		this.r0080_after_resident_government = r0080_after_resident_government;
	}
	public BigDecimal getR0080_before_nonresident_government() {
		return r0080_before_nonresident_government;
	}
	public void setR0080_before_nonresident_government(BigDecimal r0080_before_nonresident_government) {
		this.r0080_before_nonresident_government = r0080_before_nonresident_government;
	}
	public BigDecimal getR0080_after_nonresident_government() {
		return r0080_after_nonresident_government;
	}
	public void setR0080_after_nonresident_government(BigDecimal r0080_after_nonresident_government) {
		this.r0080_after_nonresident_government = r0080_after_nonresident_government;
	}
	public String getR0090_product() {
		return r0090_product;
	}
	public void setR0090_product(String r0090_product) {
		this.r0090_product = r0090_product;
	}
	public BigDecimal getR0090_before_resident_individual() {
		return r0090_before_resident_individual;
	}
	public void setR0090_before_resident_individual(BigDecimal r0090_before_resident_individual) {
		this.r0090_before_resident_individual = r0090_before_resident_individual;
	}
	public BigDecimal getR0090_after_resident_individual() {
		return r0090_after_resident_individual;
	}
	public void setR0090_after_resident_individual(BigDecimal r0090_after_resident_individual) {
		this.r0090_after_resident_individual = r0090_after_resident_individual;
	}
	public BigDecimal getR0090_before_nonresident_individual() {
		return r0090_before_nonresident_individual;
	}
	public void setR0090_before_nonresident_individual(BigDecimal r0090_before_nonresident_individual) {
		this.r0090_before_nonresident_individual = r0090_before_nonresident_individual;
	}
	public BigDecimal getR0090_after_nonresident_individual() {
		return r0090_after_nonresident_individual;
	}
	public void setR0090_after_nonresident_individual(BigDecimal r0090_after_nonresident_individual) {
		this.r0090_after_nonresident_individual = r0090_after_nonresident_individual;
	}
	public BigDecimal getR0090_before_resident_retail() {
		return r0090_before_resident_retail;
	}
	public void setR0090_before_resident_retail(BigDecimal r0090_before_resident_retail) {
		this.r0090_before_resident_retail = r0090_before_resident_retail;
	}
	public BigDecimal getR0090_after_resident_retail() {
		return r0090_after_resident_retail;
	}
	public void setR0090_after_resident_retail(BigDecimal r0090_after_resident_retail) {
		this.r0090_after_resident_retail = r0090_after_resident_retail;
	}
	public BigDecimal getR0090_before_nonresident_retail() {
		return r0090_before_nonresident_retail;
	}
	public void setR0090_before_nonresident_retail(BigDecimal r0090_before_nonresident_retail) {
		this.r0090_before_nonresident_retail = r0090_before_nonresident_retail;
	}
	public BigDecimal getR0090_after_nonresident_retail() {
		return r0090_after_nonresident_retail;
	}
	public void setR0090_after_nonresident_retail(BigDecimal r0090_after_nonresident_retail) {
		this.r0090_after_nonresident_retail = r0090_after_nonresident_retail;
	}
	public BigDecimal getR0090_before_resident_sme() {
		return r0090_before_resident_sme;
	}
	public void setR0090_before_resident_sme(BigDecimal r0090_before_resident_sme) {
		this.r0090_before_resident_sme = r0090_before_resident_sme;
	}
	public BigDecimal getR0090_after_resident_sme() {
		return r0090_after_resident_sme;
	}
	public void setR0090_after_resident_sme(BigDecimal r0090_after_resident_sme) {
		this.r0090_after_resident_sme = r0090_after_resident_sme;
	}
	public BigDecimal getR0090_before_nonresident_sme() {
		return r0090_before_nonresident_sme;
	}
	public void setR0090_before_nonresident_sme(BigDecimal r0090_before_nonresident_sme) {
		this.r0090_before_nonresident_sme = r0090_before_nonresident_sme;
	}
	public BigDecimal getR0090_after_nonresident_sme() {
		return r0090_after_nonresident_sme;
	}
	public void setR0090_after_nonresident_sme(BigDecimal r0090_after_nonresident_sme) {
		this.r0090_after_nonresident_sme = r0090_after_nonresident_sme;
	}
	public BigDecimal getR0090_before_resident_hni() {
		return r0090_before_resident_hni;
	}
	public void setR0090_before_resident_hni(BigDecimal r0090_before_resident_hni) {
		this.r0090_before_resident_hni = r0090_before_resident_hni;
	}
	public BigDecimal getR0090_after_resident_hni() {
		return r0090_after_resident_hni;
	}
	public void setR0090_after_resident_hni(BigDecimal r0090_after_resident_hni) {
		this.r0090_after_resident_hni = r0090_after_resident_hni;
	}
	public BigDecimal getR0090_before_nonresident_hni() {
		return r0090_before_nonresident_hni;
	}
	public void setR0090_before_nonresident_hni(BigDecimal r0090_before_nonresident_hni) {
		this.r0090_before_nonresident_hni = r0090_before_nonresident_hni;
	}
	public BigDecimal getR0090_after_nonresident_hni() {
		return r0090_after_nonresident_hni;
	}
	public void setR0090_after_nonresident_hni(BigDecimal r0090_after_nonresident_hni) {
		this.r0090_after_nonresident_hni = r0090_after_nonresident_hni;
	}
	public BigDecimal getR0090_before_resident_gre() {
		return r0090_before_resident_gre;
	}
	public void setR0090_before_resident_gre(BigDecimal r0090_before_resident_gre) {
		this.r0090_before_resident_gre = r0090_before_resident_gre;
	}
	public BigDecimal getR0090_after_resident_gre() {
		return r0090_after_resident_gre;
	}
	public void setR0090_after_resident_gre(BigDecimal r0090_after_resident_gre) {
		this.r0090_after_resident_gre = r0090_after_resident_gre;
	}
	public BigDecimal getR0090_before_nonresident_gre() {
		return r0090_before_nonresident_gre;
	}
	public void setR0090_before_nonresident_gre(BigDecimal r0090_before_nonresident_gre) {
		this.r0090_before_nonresident_gre = r0090_before_nonresident_gre;
	}
	public BigDecimal getR0090_after_nonresident_gre() {
		return r0090_after_nonresident_gre;
	}
	public void setR0090_after_nonresident_gre(BigDecimal r0090_after_nonresident_gre) {
		this.r0090_after_nonresident_gre = r0090_after_nonresident_gre;
	}
	public BigDecimal getR0090_before_resident_corporate() {
		return r0090_before_resident_corporate;
	}
	public void setR0090_before_resident_corporate(BigDecimal r0090_before_resident_corporate) {
		this.r0090_before_resident_corporate = r0090_before_resident_corporate;
	}
	public BigDecimal getR0090_after_resident_corporate() {
		return r0090_after_resident_corporate;
	}
	public void setR0090_after_resident_corporate(BigDecimal r0090_after_resident_corporate) {
		this.r0090_after_resident_corporate = r0090_after_resident_corporate;
	}
	public BigDecimal getR0090_before_nonresident_corporate() {
		return r0090_before_nonresident_corporate;
	}
	public void setR0090_before_nonresident_corporate(BigDecimal r0090_before_nonresident_corporate) {
		this.r0090_before_nonresident_corporate = r0090_before_nonresident_corporate;
	}
	public BigDecimal getR0090_after_nonresident_corporate() {
		return r0090_after_nonresident_corporate;
	}
	public void setR0090_after_nonresident_corporate(BigDecimal r0090_after_nonresident_corporate) {
		this.r0090_after_nonresident_corporate = r0090_after_nonresident_corporate;
	}
	public BigDecimal getR0090_before_resident_nbfi() {
		return r0090_before_resident_nbfi;
	}
	public void setR0090_before_resident_nbfi(BigDecimal r0090_before_resident_nbfi) {
		this.r0090_before_resident_nbfi = r0090_before_resident_nbfi;
	}
	public BigDecimal getR0090_after_resident_nbfi() {
		return r0090_after_resident_nbfi;
	}
	public void setR0090_after_resident_nbfi(BigDecimal r0090_after_resident_nbfi) {
		this.r0090_after_resident_nbfi = r0090_after_resident_nbfi;
	}
	public BigDecimal getR0090_before_nonresident_nbfi() {
		return r0090_before_nonresident_nbfi;
	}
	public void setR0090_before_nonresident_nbfi(BigDecimal r0090_before_nonresident_nbfi) {
		this.r0090_before_nonresident_nbfi = r0090_before_nonresident_nbfi;
	}
	public BigDecimal getR0090_after_nonresident_nbfi() {
		return r0090_after_nonresident_nbfi;
	}
	public void setR0090_after_nonresident_nbfi(BigDecimal r0090_after_nonresident_nbfi) {
		this.r0090_after_nonresident_nbfi = r0090_after_nonresident_nbfi;
	}
	public BigDecimal getR0090_before_resident_bank() {
		return r0090_before_resident_bank;
	}
	public void setR0090_before_resident_bank(BigDecimal r0090_before_resident_bank) {
		this.r0090_before_resident_bank = r0090_before_resident_bank;
	}
	public BigDecimal getR0090_after_resident_bank() {
		return r0090_after_resident_bank;
	}
	public void setR0090_after_resident_bank(BigDecimal r0090_after_resident_bank) {
		this.r0090_after_resident_bank = r0090_after_resident_bank;
	}
	public BigDecimal getR0090_before_nonresident_bank() {
		return r0090_before_nonresident_bank;
	}
	public void setR0090_before_nonresident_bank(BigDecimal r0090_before_nonresident_bank) {
		this.r0090_before_nonresident_bank = r0090_before_nonresident_bank;
	}
	public BigDecimal getR0090_after_nonresident_bank() {
		return r0090_after_nonresident_bank;
	}
	public void setR0090_after_nonresident_bank(BigDecimal r0090_after_nonresident_bank) {
		this.r0090_after_nonresident_bank = r0090_after_nonresident_bank;
	}
	public BigDecimal getR0090_before_resident_government() {
		return r0090_before_resident_government;
	}
	public void setR0090_before_resident_government(BigDecimal r0090_before_resident_government) {
		this.r0090_before_resident_government = r0090_before_resident_government;
	}
	public BigDecimal getR0090_after_resident_government() {
		return r0090_after_resident_government;
	}
	public void setR0090_after_resident_government(BigDecimal r0090_after_resident_government) {
		this.r0090_after_resident_government = r0090_after_resident_government;
	}
	public BigDecimal getR0090_before_nonresident_government() {
		return r0090_before_nonresident_government;
	}
	public void setR0090_before_nonresident_government(BigDecimal r0090_before_nonresident_government) {
		this.r0090_before_nonresident_government = r0090_before_nonresident_government;
	}
	public BigDecimal getR0090_after_nonresident_government() {
		return r0090_after_nonresident_government;
	}
	public void setR0090_after_nonresident_government(BigDecimal r0090_after_nonresident_government) {
		this.r0090_after_nonresident_government = r0090_after_nonresident_government;
	}
	public String getR0100_product() {
		return r0100_product;
	}
	public void setR0100_product(String r0100_product) {
		this.r0100_product = r0100_product;
	}
	public BigDecimal getR0100_before_resident_individual() {
		return r0100_before_resident_individual;
	}
	public void setR0100_before_resident_individual(BigDecimal r0100_before_resident_individual) {
		this.r0100_before_resident_individual = r0100_before_resident_individual;
	}
	public BigDecimal getR0100_after_resident_individual() {
		return r0100_after_resident_individual;
	}
	public void setR0100_after_resident_individual(BigDecimal r0100_after_resident_individual) {
		this.r0100_after_resident_individual = r0100_after_resident_individual;
	}
	public BigDecimal getR0100_before_nonresident_individual() {
		return r0100_before_nonresident_individual;
	}
	public void setR0100_before_nonresident_individual(BigDecimal r0100_before_nonresident_individual) {
		this.r0100_before_nonresident_individual = r0100_before_nonresident_individual;
	}
	public BigDecimal getR0100_after_nonresident_individual() {
		return r0100_after_nonresident_individual;
	}
	public void setR0100_after_nonresident_individual(BigDecimal r0100_after_nonresident_individual) {
		this.r0100_after_nonresident_individual = r0100_after_nonresident_individual;
	}
	public BigDecimal getR0100_before_resident_retail() {
		return r0100_before_resident_retail;
	}
	public void setR0100_before_resident_retail(BigDecimal r0100_before_resident_retail) {
		this.r0100_before_resident_retail = r0100_before_resident_retail;
	}
	public BigDecimal getR0100_after_resident_retail() {
		return r0100_after_resident_retail;
	}
	public void setR0100_after_resident_retail(BigDecimal r0100_after_resident_retail) {
		this.r0100_after_resident_retail = r0100_after_resident_retail;
	}
	public BigDecimal getR0100_before_nonresident_retail() {
		return r0100_before_nonresident_retail;
	}
	public void setR0100_before_nonresident_retail(BigDecimal r0100_before_nonresident_retail) {
		this.r0100_before_nonresident_retail = r0100_before_nonresident_retail;
	}
	public BigDecimal getR0100_after_nonresident_retail() {
		return r0100_after_nonresident_retail;
	}
	public void setR0100_after_nonresident_retail(BigDecimal r0100_after_nonresident_retail) {
		this.r0100_after_nonresident_retail = r0100_after_nonresident_retail;
	}
	public BigDecimal getR0100_before_resident_sme() {
		return r0100_before_resident_sme;
	}
	public void setR0100_before_resident_sme(BigDecimal r0100_before_resident_sme) {
		this.r0100_before_resident_sme = r0100_before_resident_sme;
	}
	public BigDecimal getR0100_after_resident_sme() {
		return r0100_after_resident_sme;
	}
	public void setR0100_after_resident_sme(BigDecimal r0100_after_resident_sme) {
		this.r0100_after_resident_sme = r0100_after_resident_sme;
	}
	public BigDecimal getR0100_before_nonresident_sme() {
		return r0100_before_nonresident_sme;
	}
	public void setR0100_before_nonresident_sme(BigDecimal r0100_before_nonresident_sme) {
		this.r0100_before_nonresident_sme = r0100_before_nonresident_sme;
	}
	public BigDecimal getR0100_after_nonresident_sme() {
		return r0100_after_nonresident_sme;
	}
	public void setR0100_after_nonresident_sme(BigDecimal r0100_after_nonresident_sme) {
		this.r0100_after_nonresident_sme = r0100_after_nonresident_sme;
	}
	public BigDecimal getR0100_before_resident_hni() {
		return r0100_before_resident_hni;
	}
	public void setR0100_before_resident_hni(BigDecimal r0100_before_resident_hni) {
		this.r0100_before_resident_hni = r0100_before_resident_hni;
	}
	public BigDecimal getR0100_after_resident_hni() {
		return r0100_after_resident_hni;
	}
	public void setR0100_after_resident_hni(BigDecimal r0100_after_resident_hni) {
		this.r0100_after_resident_hni = r0100_after_resident_hni;
	}
	public BigDecimal getR0100_before_nonresident_hni() {
		return r0100_before_nonresident_hni;
	}
	public void setR0100_before_nonresident_hni(BigDecimal r0100_before_nonresident_hni) {
		this.r0100_before_nonresident_hni = r0100_before_nonresident_hni;
	}
	public BigDecimal getR0100_after_nonresident_hni() {
		return r0100_after_nonresident_hni;
	}
	public void setR0100_after_nonresident_hni(BigDecimal r0100_after_nonresident_hni) {
		this.r0100_after_nonresident_hni = r0100_after_nonresident_hni;
	}
	public BigDecimal getR0100_before_resident_gre() {
		return r0100_before_resident_gre;
	}
	public void setR0100_before_resident_gre(BigDecimal r0100_before_resident_gre) {
		this.r0100_before_resident_gre = r0100_before_resident_gre;
	}
	public BigDecimal getR0100_after_resident_gre() {
		return r0100_after_resident_gre;
	}
	public void setR0100_after_resident_gre(BigDecimal r0100_after_resident_gre) {
		this.r0100_after_resident_gre = r0100_after_resident_gre;
	}
	public BigDecimal getR0100_before_nonresident_gre() {
		return r0100_before_nonresident_gre;
	}
	public void setR0100_before_nonresident_gre(BigDecimal r0100_before_nonresident_gre) {
		this.r0100_before_nonresident_gre = r0100_before_nonresident_gre;
	}
	public BigDecimal getR0100_after_nonresident_gre() {
		return r0100_after_nonresident_gre;
	}
	public void setR0100_after_nonresident_gre(BigDecimal r0100_after_nonresident_gre) {
		this.r0100_after_nonresident_gre = r0100_after_nonresident_gre;
	}
	public BigDecimal getR0100_before_resident_corporate() {
		return r0100_before_resident_corporate;
	}
	public void setR0100_before_resident_corporate(BigDecimal r0100_before_resident_corporate) {
		this.r0100_before_resident_corporate = r0100_before_resident_corporate;
	}
	public BigDecimal getR0100_after_resident_corporate() {
		return r0100_after_resident_corporate;
	}
	public void setR0100_after_resident_corporate(BigDecimal r0100_after_resident_corporate) {
		this.r0100_after_resident_corporate = r0100_after_resident_corporate;
	}
	public BigDecimal getR0100_before_nonresident_corporate() {
		return r0100_before_nonresident_corporate;
	}
	public void setR0100_before_nonresident_corporate(BigDecimal r0100_before_nonresident_corporate) {
		this.r0100_before_nonresident_corporate = r0100_before_nonresident_corporate;
	}
	public BigDecimal getR0100_after_nonresident_corporate() {
		return r0100_after_nonresident_corporate;
	}
	public void setR0100_after_nonresident_corporate(BigDecimal r0100_after_nonresident_corporate) {
		this.r0100_after_nonresident_corporate = r0100_after_nonresident_corporate;
	}
	public BigDecimal getR0100_before_resident_nbfi() {
		return r0100_before_resident_nbfi;
	}
	public void setR0100_before_resident_nbfi(BigDecimal r0100_before_resident_nbfi) {
		this.r0100_before_resident_nbfi = r0100_before_resident_nbfi;
	}
	public BigDecimal getR0100_after_resident_nbfi() {
		return r0100_after_resident_nbfi;
	}
	public void setR0100_after_resident_nbfi(BigDecimal r0100_after_resident_nbfi) {
		this.r0100_after_resident_nbfi = r0100_after_resident_nbfi;
	}
	public BigDecimal getR0100_before_nonresident_nbfi() {
		return r0100_before_nonresident_nbfi;
	}
	public void setR0100_before_nonresident_nbfi(BigDecimal r0100_before_nonresident_nbfi) {
		this.r0100_before_nonresident_nbfi = r0100_before_nonresident_nbfi;
	}
	public BigDecimal getR0100_after_nonresident_nbfi() {
		return r0100_after_nonresident_nbfi;
	}
	public void setR0100_after_nonresident_nbfi(BigDecimal r0100_after_nonresident_nbfi) {
		this.r0100_after_nonresident_nbfi = r0100_after_nonresident_nbfi;
	}
	public BigDecimal getR0100_before_resident_bank() {
		return r0100_before_resident_bank;
	}
	public void setR0100_before_resident_bank(BigDecimal r0100_before_resident_bank) {
		this.r0100_before_resident_bank = r0100_before_resident_bank;
	}
	public BigDecimal getR0100_after_resident_bank() {
		return r0100_after_resident_bank;
	}
	public void setR0100_after_resident_bank(BigDecimal r0100_after_resident_bank) {
		this.r0100_after_resident_bank = r0100_after_resident_bank;
	}
	public BigDecimal getR0100_before_nonresident_bank() {
		return r0100_before_nonresident_bank;
	}
	public void setR0100_before_nonresident_bank(BigDecimal r0100_before_nonresident_bank) {
		this.r0100_before_nonresident_bank = r0100_before_nonresident_bank;
	}
	public BigDecimal getR0100_after_nonresident_bank() {
		return r0100_after_nonresident_bank;
	}
	public void setR0100_after_nonresident_bank(BigDecimal r0100_after_nonresident_bank) {
		this.r0100_after_nonresident_bank = r0100_after_nonresident_bank;
	}
	public BigDecimal getR0100_before_resident_government() {
		return r0100_before_resident_government;
	}
	public void setR0100_before_resident_government(BigDecimal r0100_before_resident_government) {
		this.r0100_before_resident_government = r0100_before_resident_government;
	}
	public BigDecimal getR0100_after_resident_government() {
		return r0100_after_resident_government;
	}
	public void setR0100_after_resident_government(BigDecimal r0100_after_resident_government) {
		this.r0100_after_resident_government = r0100_after_resident_government;
	}
	public BigDecimal getR0100_before_nonresident_government() {
		return r0100_before_nonresident_government;
	}
	public void setR0100_before_nonresident_government(BigDecimal r0100_before_nonresident_government) {
		this.r0100_before_nonresident_government = r0100_before_nonresident_government;
	}
	public BigDecimal getR0100_after_nonresident_government() {
		return r0100_after_nonresident_government;
	}
	public void setR0100_after_nonresident_government(BigDecimal r0100_after_nonresident_government) {
		this.r0100_after_nonresident_government = r0100_after_nonresident_government;
	}
	public String getR0110_product() {
		return r0110_product;
	}
	public void setR0110_product(String r0110_product) {
		this.r0110_product = r0110_product;
	}
	public BigDecimal getR0110_before_resident_individual() {
		return r0110_before_resident_individual;
	}
	public void setR0110_before_resident_individual(BigDecimal r0110_before_resident_individual) {
		this.r0110_before_resident_individual = r0110_before_resident_individual;
	}
	public BigDecimal getR0110_after_resident_individual() {
		return r0110_after_resident_individual;
	}
	public void setR0110_after_resident_individual(BigDecimal r0110_after_resident_individual) {
		this.r0110_after_resident_individual = r0110_after_resident_individual;
	}
	public BigDecimal getR0110_before_nonresident_individual() {
		return r0110_before_nonresident_individual;
	}
	public void setR0110_before_nonresident_individual(BigDecimal r0110_before_nonresident_individual) {
		this.r0110_before_nonresident_individual = r0110_before_nonresident_individual;
	}
	public BigDecimal getR0110_after_nonresident_individual() {
		return r0110_after_nonresident_individual;
	}
	public void setR0110_after_nonresident_individual(BigDecimal r0110_after_nonresident_individual) {
		this.r0110_after_nonresident_individual = r0110_after_nonresident_individual;
	}
	public BigDecimal getR0110_before_resident_retail() {
		return r0110_before_resident_retail;
	}
	public void setR0110_before_resident_retail(BigDecimal r0110_before_resident_retail) {
		this.r0110_before_resident_retail = r0110_before_resident_retail;
	}
	public BigDecimal getR0110_after_resident_retail() {
		return r0110_after_resident_retail;
	}
	public void setR0110_after_resident_retail(BigDecimal r0110_after_resident_retail) {
		this.r0110_after_resident_retail = r0110_after_resident_retail;
	}
	public BigDecimal getR0110_before_nonresident_retail() {
		return r0110_before_nonresident_retail;
	}
	public void setR0110_before_nonresident_retail(BigDecimal r0110_before_nonresident_retail) {
		this.r0110_before_nonresident_retail = r0110_before_nonresident_retail;
	}
	public BigDecimal getR0110_after_nonresident_retail() {
		return r0110_after_nonresident_retail;
	}
	public void setR0110_after_nonresident_retail(BigDecimal r0110_after_nonresident_retail) {
		this.r0110_after_nonresident_retail = r0110_after_nonresident_retail;
	}
	public BigDecimal getR0110_before_resident_sme() {
		return r0110_before_resident_sme;
	}
	public void setR0110_before_resident_sme(BigDecimal r0110_before_resident_sme) {
		this.r0110_before_resident_sme = r0110_before_resident_sme;
	}
	public BigDecimal getR0110_after_resident_sme() {
		return r0110_after_resident_sme;
	}
	public void setR0110_after_resident_sme(BigDecimal r0110_after_resident_sme) {
		this.r0110_after_resident_sme = r0110_after_resident_sme;
	}
	public BigDecimal getR0110_before_nonresident_sme() {
		return r0110_before_nonresident_sme;
	}
	public void setR0110_before_nonresident_sme(BigDecimal r0110_before_nonresident_sme) {
		this.r0110_before_nonresident_sme = r0110_before_nonresident_sme;
	}
	public BigDecimal getR0110_after_nonresident_sme() {
		return r0110_after_nonresident_sme;
	}
	public void setR0110_after_nonresident_sme(BigDecimal r0110_after_nonresident_sme) {
		this.r0110_after_nonresident_sme = r0110_after_nonresident_sme;
	}
	public BigDecimal getR0110_before_resident_hni() {
		return r0110_before_resident_hni;
	}
	public void setR0110_before_resident_hni(BigDecimal r0110_before_resident_hni) {
		this.r0110_before_resident_hni = r0110_before_resident_hni;
	}
	public BigDecimal getR0110_after_resident_hni() {
		return r0110_after_resident_hni;
	}
	public void setR0110_after_resident_hni(BigDecimal r0110_after_resident_hni) {
		this.r0110_after_resident_hni = r0110_after_resident_hni;
	}
	public BigDecimal getR0110_before_nonresident_hni() {
		return r0110_before_nonresident_hni;
	}
	public void setR0110_before_nonresident_hni(BigDecimal r0110_before_nonresident_hni) {
		this.r0110_before_nonresident_hni = r0110_before_nonresident_hni;
	}
	public BigDecimal getR0110_after_nonresident_hni() {
		return r0110_after_nonresident_hni;
	}
	public void setR0110_after_nonresident_hni(BigDecimal r0110_after_nonresident_hni) {
		this.r0110_after_nonresident_hni = r0110_after_nonresident_hni;
	}
	public BigDecimal getR0110_before_resident_gre() {
		return r0110_before_resident_gre;
	}
	public void setR0110_before_resident_gre(BigDecimal r0110_before_resident_gre) {
		this.r0110_before_resident_gre = r0110_before_resident_gre;
	}
	public BigDecimal getR0110_after_resident_gre() {
		return r0110_after_resident_gre;
	}
	public void setR0110_after_resident_gre(BigDecimal r0110_after_resident_gre) {
		this.r0110_after_resident_gre = r0110_after_resident_gre;
	}
	public BigDecimal getR0110_before_nonresident_gre() {
		return r0110_before_nonresident_gre;
	}
	public void setR0110_before_nonresident_gre(BigDecimal r0110_before_nonresident_gre) {
		this.r0110_before_nonresident_gre = r0110_before_nonresident_gre;
	}
	public BigDecimal getR0110_after_nonresident_gre() {
		return r0110_after_nonresident_gre;
	}
	public void setR0110_after_nonresident_gre(BigDecimal r0110_after_nonresident_gre) {
		this.r0110_after_nonresident_gre = r0110_after_nonresident_gre;
	}
	public BigDecimal getR0110_before_resident_corporate() {
		return r0110_before_resident_corporate;
	}
	public void setR0110_before_resident_corporate(BigDecimal r0110_before_resident_corporate) {
		this.r0110_before_resident_corporate = r0110_before_resident_corporate;
	}
	public BigDecimal getR0110_after_resident_corporate() {
		return r0110_after_resident_corporate;
	}
	public void setR0110_after_resident_corporate(BigDecimal r0110_after_resident_corporate) {
		this.r0110_after_resident_corporate = r0110_after_resident_corporate;
	}
	public BigDecimal getR0110_before_nonresident_corporate() {
		return r0110_before_nonresident_corporate;
	}
	public void setR0110_before_nonresident_corporate(BigDecimal r0110_before_nonresident_corporate) {
		this.r0110_before_nonresident_corporate = r0110_before_nonresident_corporate;
	}
	public BigDecimal getR0110_after_nonresident_corporate() {
		return r0110_after_nonresident_corporate;
	}
	public void setR0110_after_nonresident_corporate(BigDecimal r0110_after_nonresident_corporate) {
		this.r0110_after_nonresident_corporate = r0110_after_nonresident_corporate;
	}
	public BigDecimal getR0110_before_resident_nbfi() {
		return r0110_before_resident_nbfi;
	}
	public void setR0110_before_resident_nbfi(BigDecimal r0110_before_resident_nbfi) {
		this.r0110_before_resident_nbfi = r0110_before_resident_nbfi;
	}
	public BigDecimal getR0110_after_resident_nbfi() {
		return r0110_after_resident_nbfi;
	}
	public void setR0110_after_resident_nbfi(BigDecimal r0110_after_resident_nbfi) {
		this.r0110_after_resident_nbfi = r0110_after_resident_nbfi;
	}
	public BigDecimal getR0110_before_nonresident_nbfi() {
		return r0110_before_nonresident_nbfi;
	}
	public void setR0110_before_nonresident_nbfi(BigDecimal r0110_before_nonresident_nbfi) {
		this.r0110_before_nonresident_nbfi = r0110_before_nonresident_nbfi;
	}
	public BigDecimal getR0110_after_nonresident_nbfi() {
		return r0110_after_nonresident_nbfi;
	}
	public void setR0110_after_nonresident_nbfi(BigDecimal r0110_after_nonresident_nbfi) {
		this.r0110_after_nonresident_nbfi = r0110_after_nonresident_nbfi;
	}
	public BigDecimal getR0110_before_resident_bank() {
		return r0110_before_resident_bank;
	}
	public void setR0110_before_resident_bank(BigDecimal r0110_before_resident_bank) {
		this.r0110_before_resident_bank = r0110_before_resident_bank;
	}
	public BigDecimal getR0110_after_resident_bank() {
		return r0110_after_resident_bank;
	}
	public void setR0110_after_resident_bank(BigDecimal r0110_after_resident_bank) {
		this.r0110_after_resident_bank = r0110_after_resident_bank;
	}
	public BigDecimal getR0110_before_nonresident_bank() {
		return r0110_before_nonresident_bank;
	}
	public void setR0110_before_nonresident_bank(BigDecimal r0110_before_nonresident_bank) {
		this.r0110_before_nonresident_bank = r0110_before_nonresident_bank;
	}
	public BigDecimal getR0110_after_nonresident_bank() {
		return r0110_after_nonresident_bank;
	}
	public void setR0110_after_nonresident_bank(BigDecimal r0110_after_nonresident_bank) {
		this.r0110_after_nonresident_bank = r0110_after_nonresident_bank;
	}
	public BigDecimal getR0110_before_resident_government() {
		return r0110_before_resident_government;
	}
	public void setR0110_before_resident_government(BigDecimal r0110_before_resident_government) {
		this.r0110_before_resident_government = r0110_before_resident_government;
	}
	public BigDecimal getR0110_after_resident_government() {
		return r0110_after_resident_government;
	}
	public void setR0110_after_resident_government(BigDecimal r0110_after_resident_government) {
		this.r0110_after_resident_government = r0110_after_resident_government;
	}
	public BigDecimal getR0110_before_nonresident_government() {
		return r0110_before_nonresident_government;
	}
	public void setR0110_before_nonresident_government(BigDecimal r0110_before_nonresident_government) {
		this.r0110_before_nonresident_government = r0110_before_nonresident_government;
	}
	public BigDecimal getR0110_after_nonresident_government() {
		return r0110_after_nonresident_government;
	}
	public void setR0110_after_nonresident_government(BigDecimal r0110_after_nonresident_government) {
		this.r0110_after_nonresident_government = r0110_after_nonresident_government;
	}
	public String getR0120_product() {
		return r0120_product;
	}
	public void setR0120_product(String r0120_product) {
		this.r0120_product = r0120_product;
	}
	public BigDecimal getR0120_before_resident_individual() {
		return r0120_before_resident_individual;
	}
	public void setR0120_before_resident_individual(BigDecimal r0120_before_resident_individual) {
		this.r0120_before_resident_individual = r0120_before_resident_individual;
	}
	public BigDecimal getR0120_after_resident_individual() {
		return r0120_after_resident_individual;
	}
	public void setR0120_after_resident_individual(BigDecimal r0120_after_resident_individual) {
		this.r0120_after_resident_individual = r0120_after_resident_individual;
	}
	public BigDecimal getR0120_before_nonresident_individual() {
		return r0120_before_nonresident_individual;
	}
	public void setR0120_before_nonresident_individual(BigDecimal r0120_before_nonresident_individual) {
		this.r0120_before_nonresident_individual = r0120_before_nonresident_individual;
	}
	public BigDecimal getR0120_after_nonresident_individual() {
		return r0120_after_nonresident_individual;
	}
	public void setR0120_after_nonresident_individual(BigDecimal r0120_after_nonresident_individual) {
		this.r0120_after_nonresident_individual = r0120_after_nonresident_individual;
	}
	public BigDecimal getR0120_before_resident_retail() {
		return r0120_before_resident_retail;
	}
	public void setR0120_before_resident_retail(BigDecimal r0120_before_resident_retail) {
		this.r0120_before_resident_retail = r0120_before_resident_retail;
	}
	public BigDecimal getR0120_after_resident_retail() {
		return r0120_after_resident_retail;
	}
	public void setR0120_after_resident_retail(BigDecimal r0120_after_resident_retail) {
		this.r0120_after_resident_retail = r0120_after_resident_retail;
	}
	public BigDecimal getR0120_before_nonresident_retail() {
		return r0120_before_nonresident_retail;
	}
	public void setR0120_before_nonresident_retail(BigDecimal r0120_before_nonresident_retail) {
		this.r0120_before_nonresident_retail = r0120_before_nonresident_retail;
	}
	public BigDecimal getR0120_after_nonresident_retail() {
		return r0120_after_nonresident_retail;
	}
	public void setR0120_after_nonresident_retail(BigDecimal r0120_after_nonresident_retail) {
		this.r0120_after_nonresident_retail = r0120_after_nonresident_retail;
	}
	public BigDecimal getR0120_before_resident_sme() {
		return r0120_before_resident_sme;
	}
	public void setR0120_before_resident_sme(BigDecimal r0120_before_resident_sme) {
		this.r0120_before_resident_sme = r0120_before_resident_sme;
	}
	public BigDecimal getR0120_after_resident_sme() {
		return r0120_after_resident_sme;
	}
	public void setR0120_after_resident_sme(BigDecimal r0120_after_resident_sme) {
		this.r0120_after_resident_sme = r0120_after_resident_sme;
	}
	public BigDecimal getR0120_before_nonresident_sme() {
		return r0120_before_nonresident_sme;
	}
	public void setR0120_before_nonresident_sme(BigDecimal r0120_before_nonresident_sme) {
		this.r0120_before_nonresident_sme = r0120_before_nonresident_sme;
	}
	public BigDecimal getR0120_after_nonresident_sme() {
		return r0120_after_nonresident_sme;
	}
	public void setR0120_after_nonresident_sme(BigDecimal r0120_after_nonresident_sme) {
		this.r0120_after_nonresident_sme = r0120_after_nonresident_sme;
	}
	public BigDecimal getR0120_before_resident_hni() {
		return r0120_before_resident_hni;
	}
	public void setR0120_before_resident_hni(BigDecimal r0120_before_resident_hni) {
		this.r0120_before_resident_hni = r0120_before_resident_hni;
	}
	public BigDecimal getR0120_after_resident_hni() {
		return r0120_after_resident_hni;
	}
	public void setR0120_after_resident_hni(BigDecimal r0120_after_resident_hni) {
		this.r0120_after_resident_hni = r0120_after_resident_hni;
	}
	public BigDecimal getR0120_before_nonresident_hni() {
		return r0120_before_nonresident_hni;
	}
	public void setR0120_before_nonresident_hni(BigDecimal r0120_before_nonresident_hni) {
		this.r0120_before_nonresident_hni = r0120_before_nonresident_hni;
	}
	public BigDecimal getR0120_after_nonresident_hni() {
		return r0120_after_nonresident_hni;
	}
	public void setR0120_after_nonresident_hni(BigDecimal r0120_after_nonresident_hni) {
		this.r0120_after_nonresident_hni = r0120_after_nonresident_hni;
	}
	public BigDecimal getR0120_before_resident_gre() {
		return r0120_before_resident_gre;
	}
	public void setR0120_before_resident_gre(BigDecimal r0120_before_resident_gre) {
		this.r0120_before_resident_gre = r0120_before_resident_gre;
	}
	public BigDecimal getR0120_after_resident_gre() {
		return r0120_after_resident_gre;
	}
	public void setR0120_after_resident_gre(BigDecimal r0120_after_resident_gre) {
		this.r0120_after_resident_gre = r0120_after_resident_gre;
	}
	public BigDecimal getR0120_before_nonresident_gre() {
		return r0120_before_nonresident_gre;
	}
	public void setR0120_before_nonresident_gre(BigDecimal r0120_before_nonresident_gre) {
		this.r0120_before_nonresident_gre = r0120_before_nonresident_gre;
	}
	public BigDecimal getR0120_after_nonresident_gre() {
		return r0120_after_nonresident_gre;
	}
	public void setR0120_after_nonresident_gre(BigDecimal r0120_after_nonresident_gre) {
		this.r0120_after_nonresident_gre = r0120_after_nonresident_gre;
	}
	public BigDecimal getR0120_before_resident_corporate() {
		return r0120_before_resident_corporate;
	}
	public void setR0120_before_resident_corporate(BigDecimal r0120_before_resident_corporate) {
		this.r0120_before_resident_corporate = r0120_before_resident_corporate;
	}
	public BigDecimal getR0120_after_resident_corporate() {
		return r0120_after_resident_corporate;
	}
	public void setR0120_after_resident_corporate(BigDecimal r0120_after_resident_corporate) {
		this.r0120_after_resident_corporate = r0120_after_resident_corporate;
	}
	public BigDecimal getR0120_before_nonresident_corporate() {
		return r0120_before_nonresident_corporate;
	}
	public void setR0120_before_nonresident_corporate(BigDecimal r0120_before_nonresident_corporate) {
		this.r0120_before_nonresident_corporate = r0120_before_nonresident_corporate;
	}
	public BigDecimal getR0120_after_nonresident_corporate() {
		return r0120_after_nonresident_corporate;
	}
	public void setR0120_after_nonresident_corporate(BigDecimal r0120_after_nonresident_corporate) {
		this.r0120_after_nonresident_corporate = r0120_after_nonresident_corporate;
	}
	public BigDecimal getR0120_before_resident_nbfi() {
		return r0120_before_resident_nbfi;
	}
	public void setR0120_before_resident_nbfi(BigDecimal r0120_before_resident_nbfi) {
		this.r0120_before_resident_nbfi = r0120_before_resident_nbfi;
	}
	public BigDecimal getR0120_after_resident_nbfi() {
		return r0120_after_resident_nbfi;
	}
	public void setR0120_after_resident_nbfi(BigDecimal r0120_after_resident_nbfi) {
		this.r0120_after_resident_nbfi = r0120_after_resident_nbfi;
	}
	public BigDecimal getR0120_before_nonresident_nbfi() {
		return r0120_before_nonresident_nbfi;
	}
	public void setR0120_before_nonresident_nbfi(BigDecimal r0120_before_nonresident_nbfi) {
		this.r0120_before_nonresident_nbfi = r0120_before_nonresident_nbfi;
	}
	public BigDecimal getR0120_after_nonresident_nbfi() {
		return r0120_after_nonresident_nbfi;
	}
	public void setR0120_after_nonresident_nbfi(BigDecimal r0120_after_nonresident_nbfi) {
		this.r0120_after_nonresident_nbfi = r0120_after_nonresident_nbfi;
	}
	public BigDecimal getR0120_before_resident_bank() {
		return r0120_before_resident_bank;
	}
	public void setR0120_before_resident_bank(BigDecimal r0120_before_resident_bank) {
		this.r0120_before_resident_bank = r0120_before_resident_bank;
	}
	public BigDecimal getR0120_after_resident_bank() {
		return r0120_after_resident_bank;
	}
	public void setR0120_after_resident_bank(BigDecimal r0120_after_resident_bank) {
		this.r0120_after_resident_bank = r0120_after_resident_bank;
	}
	public BigDecimal getR0120_before_nonresident_bank() {
		return r0120_before_nonresident_bank;
	}
	public void setR0120_before_nonresident_bank(BigDecimal r0120_before_nonresident_bank) {
		this.r0120_before_nonresident_bank = r0120_before_nonresident_bank;
	}
	public BigDecimal getR0120_after_nonresident_bank() {
		return r0120_after_nonresident_bank;
	}
	public void setR0120_after_nonresident_bank(BigDecimal r0120_after_nonresident_bank) {
		this.r0120_after_nonresident_bank = r0120_after_nonresident_bank;
	}
	public BigDecimal getR0120_before_resident_government() {
		return r0120_before_resident_government;
	}
	public void setR0120_before_resident_government(BigDecimal r0120_before_resident_government) {
		this.r0120_before_resident_government = r0120_before_resident_government;
	}
	public BigDecimal getR0120_after_resident_government() {
		return r0120_after_resident_government;
	}
	public void setR0120_after_resident_government(BigDecimal r0120_after_resident_government) {
		this.r0120_after_resident_government = r0120_after_resident_government;
	}
	public BigDecimal getR0120_before_nonresident_government() {
		return r0120_before_nonresident_government;
	}
	public void setR0120_before_nonresident_government(BigDecimal r0120_before_nonresident_government) {
		this.r0120_before_nonresident_government = r0120_before_nonresident_government;
	}
	public BigDecimal getR0120_after_nonresident_government() {
		return r0120_after_nonresident_government;
	}
	public void setR0120_after_nonresident_government(BigDecimal r0120_after_nonresident_government) {
		this.r0120_after_nonresident_government = r0120_after_nonresident_government;
	}
	public String getR0130_product() {
		return r0130_product;
	}
	public void setR0130_product(String r0130_product) {
		this.r0130_product = r0130_product;
	}
	public BigDecimal getR0130_before_resident_individual() {
		return r0130_before_resident_individual;
	}
	public void setR0130_before_resident_individual(BigDecimal r0130_before_resident_individual) {
		this.r0130_before_resident_individual = r0130_before_resident_individual;
	}
	public BigDecimal getR0130_after_resident_individual() {
		return r0130_after_resident_individual;
	}
	public void setR0130_after_resident_individual(BigDecimal r0130_after_resident_individual) {
		this.r0130_after_resident_individual = r0130_after_resident_individual;
	}
	public BigDecimal getR0130_before_nonresident_individual() {
		return r0130_before_nonresident_individual;
	}
	public void setR0130_before_nonresident_individual(BigDecimal r0130_before_nonresident_individual) {
		this.r0130_before_nonresident_individual = r0130_before_nonresident_individual;
	}
	public BigDecimal getR0130_after_nonresident_individual() {
		return r0130_after_nonresident_individual;
	}
	public void setR0130_after_nonresident_individual(BigDecimal r0130_after_nonresident_individual) {
		this.r0130_after_nonresident_individual = r0130_after_nonresident_individual;
	}
	public BigDecimal getR0130_before_resident_retail() {
		return r0130_before_resident_retail;
	}
	public void setR0130_before_resident_retail(BigDecimal r0130_before_resident_retail) {
		this.r0130_before_resident_retail = r0130_before_resident_retail;
	}
	public BigDecimal getR0130_after_resident_retail() {
		return r0130_after_resident_retail;
	}
	public void setR0130_after_resident_retail(BigDecimal r0130_after_resident_retail) {
		this.r0130_after_resident_retail = r0130_after_resident_retail;
	}
	public BigDecimal getR0130_before_nonresident_retail() {
		return r0130_before_nonresident_retail;
	}
	public void setR0130_before_nonresident_retail(BigDecimal r0130_before_nonresident_retail) {
		this.r0130_before_nonresident_retail = r0130_before_nonresident_retail;
	}
	public BigDecimal getR0130_after_nonresident_retail() {
		return r0130_after_nonresident_retail;
	}
	public void setR0130_after_nonresident_retail(BigDecimal r0130_after_nonresident_retail) {
		this.r0130_after_nonresident_retail = r0130_after_nonresident_retail;
	}
	public BigDecimal getR0130_before_resident_sme() {
		return r0130_before_resident_sme;
	}
	public void setR0130_before_resident_sme(BigDecimal r0130_before_resident_sme) {
		this.r0130_before_resident_sme = r0130_before_resident_sme;
	}
	public BigDecimal getR0130_after_resident_sme() {
		return r0130_after_resident_sme;
	}
	public void setR0130_after_resident_sme(BigDecimal r0130_after_resident_sme) {
		this.r0130_after_resident_sme = r0130_after_resident_sme;
	}
	public BigDecimal getR0130_before_nonresident_sme() {
		return r0130_before_nonresident_sme;
	}
	public void setR0130_before_nonresident_sme(BigDecimal r0130_before_nonresident_sme) {
		this.r0130_before_nonresident_sme = r0130_before_nonresident_sme;
	}
	public BigDecimal getR0130_after_nonresident_sme() {
		return r0130_after_nonresident_sme;
	}
	public void setR0130_after_nonresident_sme(BigDecimal r0130_after_nonresident_sme) {
		this.r0130_after_nonresident_sme = r0130_after_nonresident_sme;
	}
	public BigDecimal getR0130_before_resident_hni() {
		return r0130_before_resident_hni;
	}
	public void setR0130_before_resident_hni(BigDecimal r0130_before_resident_hni) {
		this.r0130_before_resident_hni = r0130_before_resident_hni;
	}
	public BigDecimal getR0130_after_resident_hni() {
		return r0130_after_resident_hni;
	}
	public void setR0130_after_resident_hni(BigDecimal r0130_after_resident_hni) {
		this.r0130_after_resident_hni = r0130_after_resident_hni;
	}
	public BigDecimal getR0130_before_nonresident_hni() {
		return r0130_before_nonresident_hni;
	}
	public void setR0130_before_nonresident_hni(BigDecimal r0130_before_nonresident_hni) {
		this.r0130_before_nonresident_hni = r0130_before_nonresident_hni;
	}
	public BigDecimal getR0130_after_nonresident_hni() {
		return r0130_after_nonresident_hni;
	}
	public void setR0130_after_nonresident_hni(BigDecimal r0130_after_nonresident_hni) {
		this.r0130_after_nonresident_hni = r0130_after_nonresident_hni;
	}
	public BigDecimal getR0130_before_resident_gre() {
		return r0130_before_resident_gre;
	}
	public void setR0130_before_resident_gre(BigDecimal r0130_before_resident_gre) {
		this.r0130_before_resident_gre = r0130_before_resident_gre;
	}
	public BigDecimal getR0130_after_resident_gre() {
		return r0130_after_resident_gre;
	}
	public void setR0130_after_resident_gre(BigDecimal r0130_after_resident_gre) {
		this.r0130_after_resident_gre = r0130_after_resident_gre;
	}
	public BigDecimal getR0130_before_nonresident_gre() {
		return r0130_before_nonresident_gre;
	}
	public void setR0130_before_nonresident_gre(BigDecimal r0130_before_nonresident_gre) {
		this.r0130_before_nonresident_gre = r0130_before_nonresident_gre;
	}
	public BigDecimal getR0130_after_nonresident_gre() {
		return r0130_after_nonresident_gre;
	}
	public void setR0130_after_nonresident_gre(BigDecimal r0130_after_nonresident_gre) {
		this.r0130_after_nonresident_gre = r0130_after_nonresident_gre;
	}
	public BigDecimal getR0130_before_resident_corporate() {
		return r0130_before_resident_corporate;
	}
	public void setR0130_before_resident_corporate(BigDecimal r0130_before_resident_corporate) {
		this.r0130_before_resident_corporate = r0130_before_resident_corporate;
	}
	public BigDecimal getR0130_after_resident_corporate() {
		return r0130_after_resident_corporate;
	}
	public void setR0130_after_resident_corporate(BigDecimal r0130_after_resident_corporate) {
		this.r0130_after_resident_corporate = r0130_after_resident_corporate;
	}
	public BigDecimal getR0130_before_nonresident_corporate() {
		return r0130_before_nonresident_corporate;
	}
	public void setR0130_before_nonresident_corporate(BigDecimal r0130_before_nonresident_corporate) {
		this.r0130_before_nonresident_corporate = r0130_before_nonresident_corporate;
	}
	public BigDecimal getR0130_after_nonresident_corporate() {
		return r0130_after_nonresident_corporate;
	}
	public void setR0130_after_nonresident_corporate(BigDecimal r0130_after_nonresident_corporate) {
		this.r0130_after_nonresident_corporate = r0130_after_nonresident_corporate;
	}
	public BigDecimal getR0130_before_resident_nbfi() {
		return r0130_before_resident_nbfi;
	}
	public void setR0130_before_resident_nbfi(BigDecimal r0130_before_resident_nbfi) {
		this.r0130_before_resident_nbfi = r0130_before_resident_nbfi;
	}
	public BigDecimal getR0130_after_resident_nbfi() {
		return r0130_after_resident_nbfi;
	}
	public void setR0130_after_resident_nbfi(BigDecimal r0130_after_resident_nbfi) {
		this.r0130_after_resident_nbfi = r0130_after_resident_nbfi;
	}
	public BigDecimal getR0130_before_nonresident_nbfi() {
		return r0130_before_nonresident_nbfi;
	}
	public void setR0130_before_nonresident_nbfi(BigDecimal r0130_before_nonresident_nbfi) {
		this.r0130_before_nonresident_nbfi = r0130_before_nonresident_nbfi;
	}
	public BigDecimal getR0130_after_nonresident_nbfi() {
		return r0130_after_nonresident_nbfi;
	}
	public void setR0130_after_nonresident_nbfi(BigDecimal r0130_after_nonresident_nbfi) {
		this.r0130_after_nonresident_nbfi = r0130_after_nonresident_nbfi;
	}
	public BigDecimal getR0130_before_resident_bank() {
		return r0130_before_resident_bank;
	}
	public void setR0130_before_resident_bank(BigDecimal r0130_before_resident_bank) {
		this.r0130_before_resident_bank = r0130_before_resident_bank;
	}
	public BigDecimal getR0130_after_resident_bank() {
		return r0130_after_resident_bank;
	}
	public void setR0130_after_resident_bank(BigDecimal r0130_after_resident_bank) {
		this.r0130_after_resident_bank = r0130_after_resident_bank;
	}
	public BigDecimal getR0130_before_nonresident_bank() {
		return r0130_before_nonresident_bank;
	}
	public void setR0130_before_nonresident_bank(BigDecimal r0130_before_nonresident_bank) {
		this.r0130_before_nonresident_bank = r0130_before_nonresident_bank;
	}
	public BigDecimal getR0130_after_nonresident_bank() {
		return r0130_after_nonresident_bank;
	}
	public void setR0130_after_nonresident_bank(BigDecimal r0130_after_nonresident_bank) {
		this.r0130_after_nonresident_bank = r0130_after_nonresident_bank;
	}
	public BigDecimal getR0130_before_resident_government() {
		return r0130_before_resident_government;
	}
	public void setR0130_before_resident_government(BigDecimal r0130_before_resident_government) {
		this.r0130_before_resident_government = r0130_before_resident_government;
	}
	public BigDecimal getR0130_after_resident_government() {
		return r0130_after_resident_government;
	}
	public void setR0130_after_resident_government(BigDecimal r0130_after_resident_government) {
		this.r0130_after_resident_government = r0130_after_resident_government;
	}
	public BigDecimal getR0130_before_nonresident_government() {
		return r0130_before_nonresident_government;
	}
	public void setR0130_before_nonresident_government(BigDecimal r0130_before_nonresident_government) {
		this.r0130_before_nonresident_government = r0130_before_nonresident_government;
	}
	public BigDecimal getR0130_after_nonresident_government() {
		return r0130_after_nonresident_government;
	}
	public void setR0130_after_nonresident_government(BigDecimal r0130_after_nonresident_government) {
		this.r0130_after_nonresident_government = r0130_after_nonresident_government;
	}
	public String getR0140_product() {
		return r0140_product;
	}
	public void setR0140_product(String r0140_product) {
		this.r0140_product = r0140_product;
	}
	public BigDecimal getR0140_before_resident_individual() {
		return r0140_before_resident_individual;
	}
	public void setR0140_before_resident_individual(BigDecimal r0140_before_resident_individual) {
		this.r0140_before_resident_individual = r0140_before_resident_individual;
	}
	public BigDecimal getR0140_after_resident_individual() {
		return r0140_after_resident_individual;
	}
	public void setR0140_after_resident_individual(BigDecimal r0140_after_resident_individual) {
		this.r0140_after_resident_individual = r0140_after_resident_individual;
	}
	public BigDecimal getR0140_before_nonresident_individual() {
		return r0140_before_nonresident_individual;
	}
	public void setR0140_before_nonresident_individual(BigDecimal r0140_before_nonresident_individual) {
		this.r0140_before_nonresident_individual = r0140_before_nonresident_individual;
	}
	public BigDecimal getR0140_after_nonresident_individual() {
		return r0140_after_nonresident_individual;
	}
	public void setR0140_after_nonresident_individual(BigDecimal r0140_after_nonresident_individual) {
		this.r0140_after_nonresident_individual = r0140_after_nonresident_individual;
	}
	public BigDecimal getR0140_before_resident_retail() {
		return r0140_before_resident_retail;
	}
	public void setR0140_before_resident_retail(BigDecimal r0140_before_resident_retail) {
		this.r0140_before_resident_retail = r0140_before_resident_retail;
	}
	public BigDecimal getR0140_after_resident_retail() {
		return r0140_after_resident_retail;
	}
	public void setR0140_after_resident_retail(BigDecimal r0140_after_resident_retail) {
		this.r0140_after_resident_retail = r0140_after_resident_retail;
	}
	public BigDecimal getR0140_before_nonresident_retail() {
		return r0140_before_nonresident_retail;
	}
	public void setR0140_before_nonresident_retail(BigDecimal r0140_before_nonresident_retail) {
		this.r0140_before_nonresident_retail = r0140_before_nonresident_retail;
	}
	public BigDecimal getR0140_after_nonresident_retail() {
		return r0140_after_nonresident_retail;
	}
	public void setR0140_after_nonresident_retail(BigDecimal r0140_after_nonresident_retail) {
		this.r0140_after_nonresident_retail = r0140_after_nonresident_retail;
	}
	public BigDecimal getR0140_before_resident_sme() {
		return r0140_before_resident_sme;
	}
	public void setR0140_before_resident_sme(BigDecimal r0140_before_resident_sme) {
		this.r0140_before_resident_sme = r0140_before_resident_sme;
	}
	public BigDecimal getR0140_after_resident_sme() {
		return r0140_after_resident_sme;
	}
	public void setR0140_after_resident_sme(BigDecimal r0140_after_resident_sme) {
		this.r0140_after_resident_sme = r0140_after_resident_sme;
	}
	public BigDecimal getR0140_before_nonresident_sme() {
		return r0140_before_nonresident_sme;
	}
	public void setR0140_before_nonresident_sme(BigDecimal r0140_before_nonresident_sme) {
		this.r0140_before_nonresident_sme = r0140_before_nonresident_sme;
	}
	public BigDecimal getR0140_after_nonresident_sme() {
		return r0140_after_nonresident_sme;
	}
	public void setR0140_after_nonresident_sme(BigDecimal r0140_after_nonresident_sme) {
		this.r0140_after_nonresident_sme = r0140_after_nonresident_sme;
	}
	public BigDecimal getR0140_before_resident_hni() {
		return r0140_before_resident_hni;
	}
	public void setR0140_before_resident_hni(BigDecimal r0140_before_resident_hni) {
		this.r0140_before_resident_hni = r0140_before_resident_hni;
	}
	public BigDecimal getR0140_after_resident_hni() {
		return r0140_after_resident_hni;
	}
	public void setR0140_after_resident_hni(BigDecimal r0140_after_resident_hni) {
		this.r0140_after_resident_hni = r0140_after_resident_hni;
	}
	public BigDecimal getR0140_before_nonresident_hni() {
		return r0140_before_nonresident_hni;
	}
	public void setR0140_before_nonresident_hni(BigDecimal r0140_before_nonresident_hni) {
		this.r0140_before_nonresident_hni = r0140_before_nonresident_hni;
	}
	public BigDecimal getR0140_after_nonresident_hni() {
		return r0140_after_nonresident_hni;
	}
	public void setR0140_after_nonresident_hni(BigDecimal r0140_after_nonresident_hni) {
		this.r0140_after_nonresident_hni = r0140_after_nonresident_hni;
	}
	public BigDecimal getR0140_before_resident_gre() {
		return r0140_before_resident_gre;
	}
	public void setR0140_before_resident_gre(BigDecimal r0140_before_resident_gre) {
		this.r0140_before_resident_gre = r0140_before_resident_gre;
	}
	public BigDecimal getR0140_after_resident_gre() {
		return r0140_after_resident_gre;
	}
	public void setR0140_after_resident_gre(BigDecimal r0140_after_resident_gre) {
		this.r0140_after_resident_gre = r0140_after_resident_gre;
	}
	public BigDecimal getR0140_before_nonresident_gre() {
		return r0140_before_nonresident_gre;
	}
	public void setR0140_before_nonresident_gre(BigDecimal r0140_before_nonresident_gre) {
		this.r0140_before_nonresident_gre = r0140_before_nonresident_gre;
	}
	public BigDecimal getR0140_after_nonresident_gre() {
		return r0140_after_nonresident_gre;
	}
	public void setR0140_after_nonresident_gre(BigDecimal r0140_after_nonresident_gre) {
		this.r0140_after_nonresident_gre = r0140_after_nonresident_gre;
	}
	public BigDecimal getR0140_before_resident_corporate() {
		return r0140_before_resident_corporate;
	}
	public void setR0140_before_resident_corporate(BigDecimal r0140_before_resident_corporate) {
		this.r0140_before_resident_corporate = r0140_before_resident_corporate;
	}
	public BigDecimal getR0140_after_resident_corporate() {
		return r0140_after_resident_corporate;
	}
	public void setR0140_after_resident_corporate(BigDecimal r0140_after_resident_corporate) {
		this.r0140_after_resident_corporate = r0140_after_resident_corporate;
	}
	public BigDecimal getR0140_before_nonresident_corporate() {
		return r0140_before_nonresident_corporate;
	}
	public void setR0140_before_nonresident_corporate(BigDecimal r0140_before_nonresident_corporate) {
		this.r0140_before_nonresident_corporate = r0140_before_nonresident_corporate;
	}
	public BigDecimal getR0140_after_nonresident_corporate() {
		return r0140_after_nonresident_corporate;
	}
	public void setR0140_after_nonresident_corporate(BigDecimal r0140_after_nonresident_corporate) {
		this.r0140_after_nonresident_corporate = r0140_after_nonresident_corporate;
	}
	public BigDecimal getR0140_before_resident_nbfi() {
		return r0140_before_resident_nbfi;
	}
	public void setR0140_before_resident_nbfi(BigDecimal r0140_before_resident_nbfi) {
		this.r0140_before_resident_nbfi = r0140_before_resident_nbfi;
	}
	public BigDecimal getR0140_after_resident_nbfi() {
		return r0140_after_resident_nbfi;
	}
	public void setR0140_after_resident_nbfi(BigDecimal r0140_after_resident_nbfi) {
		this.r0140_after_resident_nbfi = r0140_after_resident_nbfi;
	}
	public BigDecimal getR0140_before_nonresident_nbfi() {
		return r0140_before_nonresident_nbfi;
	}
	public void setR0140_before_nonresident_nbfi(BigDecimal r0140_before_nonresident_nbfi) {
		this.r0140_before_nonresident_nbfi = r0140_before_nonresident_nbfi;
	}
	public BigDecimal getR0140_after_nonresident_nbfi() {
		return r0140_after_nonresident_nbfi;
	}
	public void setR0140_after_nonresident_nbfi(BigDecimal r0140_after_nonresident_nbfi) {
		this.r0140_after_nonresident_nbfi = r0140_after_nonresident_nbfi;
	}
	public BigDecimal getR0140_before_resident_bank() {
		return r0140_before_resident_bank;
	}
	public void setR0140_before_resident_bank(BigDecimal r0140_before_resident_bank) {
		this.r0140_before_resident_bank = r0140_before_resident_bank;
	}
	public BigDecimal getR0140_after_resident_bank() {
		return r0140_after_resident_bank;
	}
	public void setR0140_after_resident_bank(BigDecimal r0140_after_resident_bank) {
		this.r0140_after_resident_bank = r0140_after_resident_bank;
	}
	public BigDecimal getR0140_before_nonresident_bank() {
		return r0140_before_nonresident_bank;
	}
	public void setR0140_before_nonresident_bank(BigDecimal r0140_before_nonresident_bank) {
		this.r0140_before_nonresident_bank = r0140_before_nonresident_bank;
	}
	public BigDecimal getR0140_after_nonresident_bank() {
		return r0140_after_nonresident_bank;
	}
	public void setR0140_after_nonresident_bank(BigDecimal r0140_after_nonresident_bank) {
		this.r0140_after_nonresident_bank = r0140_after_nonresident_bank;
	}
	public BigDecimal getR0140_before_resident_government() {
		return r0140_before_resident_government;
	}
	public void setR0140_before_resident_government(BigDecimal r0140_before_resident_government) {
		this.r0140_before_resident_government = r0140_before_resident_government;
	}
	public BigDecimal getR0140_after_resident_government() {
		return r0140_after_resident_government;
	}
	public void setR0140_after_resident_government(BigDecimal r0140_after_resident_government) {
		this.r0140_after_resident_government = r0140_after_resident_government;
	}
	public BigDecimal getR0140_before_nonresident_government() {
		return r0140_before_nonresident_government;
	}
	public void setR0140_before_nonresident_government(BigDecimal r0140_before_nonresident_government) {
		this.r0140_before_nonresident_government = r0140_before_nonresident_government;
	}
	public BigDecimal getR0140_after_nonresident_government() {
		return r0140_after_nonresident_government;
	}
	public void setR0140_after_nonresident_government(BigDecimal r0140_after_nonresident_government) {
		this.r0140_after_nonresident_government = r0140_after_nonresident_government;
	}
	public String getR0150_product() {
		return r0150_product;
	}
	public void setR0150_product(String r0150_product) {
		this.r0150_product = r0150_product;
	}
	public BigDecimal getR0150_before_resident_individual() {
		return r0150_before_resident_individual;
	}
	public void setR0150_before_resident_individual(BigDecimal r0150_before_resident_individual) {
		this.r0150_before_resident_individual = r0150_before_resident_individual;
	}
	public BigDecimal getR0150_after_resident_individual() {
		return r0150_after_resident_individual;
	}
	public void setR0150_after_resident_individual(BigDecimal r0150_after_resident_individual) {
		this.r0150_after_resident_individual = r0150_after_resident_individual;
	}
	public BigDecimal getR0150_before_nonresident_individual() {
		return r0150_before_nonresident_individual;
	}
	public void setR0150_before_nonresident_individual(BigDecimal r0150_before_nonresident_individual) {
		this.r0150_before_nonresident_individual = r0150_before_nonresident_individual;
	}
	public BigDecimal getR0150_after_nonresident_individual() {
		return r0150_after_nonresident_individual;
	}
	public void setR0150_after_nonresident_individual(BigDecimal r0150_after_nonresident_individual) {
		this.r0150_after_nonresident_individual = r0150_after_nonresident_individual;
	}
	public BigDecimal getR0150_before_resident_retail() {
		return r0150_before_resident_retail;
	}
	public void setR0150_before_resident_retail(BigDecimal r0150_before_resident_retail) {
		this.r0150_before_resident_retail = r0150_before_resident_retail;
	}
	public BigDecimal getR0150_after_resident_retail() {
		return r0150_after_resident_retail;
	}
	public void setR0150_after_resident_retail(BigDecimal r0150_after_resident_retail) {
		this.r0150_after_resident_retail = r0150_after_resident_retail;
	}
	public BigDecimal getR0150_before_nonresident_retail() {
		return r0150_before_nonresident_retail;
	}
	public void setR0150_before_nonresident_retail(BigDecimal r0150_before_nonresident_retail) {
		this.r0150_before_nonresident_retail = r0150_before_nonresident_retail;
	}
	public BigDecimal getR0150_after_nonresident_retail() {
		return r0150_after_nonresident_retail;
	}
	public void setR0150_after_nonresident_retail(BigDecimal r0150_after_nonresident_retail) {
		this.r0150_after_nonresident_retail = r0150_after_nonresident_retail;
	}
	public BigDecimal getR0150_before_resident_sme() {
		return r0150_before_resident_sme;
	}
	public void setR0150_before_resident_sme(BigDecimal r0150_before_resident_sme) {
		this.r0150_before_resident_sme = r0150_before_resident_sme;
	}
	public BigDecimal getR0150_after_resident_sme() {
		return r0150_after_resident_sme;
	}
	public void setR0150_after_resident_sme(BigDecimal r0150_after_resident_sme) {
		this.r0150_after_resident_sme = r0150_after_resident_sme;
	}
	public BigDecimal getR0150_before_nonresident_sme() {
		return r0150_before_nonresident_sme;
	}
	public void setR0150_before_nonresident_sme(BigDecimal r0150_before_nonresident_sme) {
		this.r0150_before_nonresident_sme = r0150_before_nonresident_sme;
	}
	public BigDecimal getR0150_after_nonresident_sme() {
		return r0150_after_nonresident_sme;
	}
	public void setR0150_after_nonresident_sme(BigDecimal r0150_after_nonresident_sme) {
		this.r0150_after_nonresident_sme = r0150_after_nonresident_sme;
	}
	public BigDecimal getR0150_before_resident_hni() {
		return r0150_before_resident_hni;
	}
	public void setR0150_before_resident_hni(BigDecimal r0150_before_resident_hni) {
		this.r0150_before_resident_hni = r0150_before_resident_hni;
	}
	public BigDecimal getR0150_after_resident_hni() {
		return r0150_after_resident_hni;
	}
	public void setR0150_after_resident_hni(BigDecimal r0150_after_resident_hni) {
		this.r0150_after_resident_hni = r0150_after_resident_hni;
	}
	public BigDecimal getR0150_before_nonresident_hni() {
		return r0150_before_nonresident_hni;
	}
	public void setR0150_before_nonresident_hni(BigDecimal r0150_before_nonresident_hni) {
		this.r0150_before_nonresident_hni = r0150_before_nonresident_hni;
	}
	public BigDecimal getR0150_after_nonresident_hni() {
		return r0150_after_nonresident_hni;
	}
	public void setR0150_after_nonresident_hni(BigDecimal r0150_after_nonresident_hni) {
		this.r0150_after_nonresident_hni = r0150_after_nonresident_hni;
	}
	public BigDecimal getR0150_before_resident_gre() {
		return r0150_before_resident_gre;
	}
	public void setR0150_before_resident_gre(BigDecimal r0150_before_resident_gre) {
		this.r0150_before_resident_gre = r0150_before_resident_gre;
	}
	public BigDecimal getR0150_after_resident_gre() {
		return r0150_after_resident_gre;
	}
	public void setR0150_after_resident_gre(BigDecimal r0150_after_resident_gre) {
		this.r0150_after_resident_gre = r0150_after_resident_gre;
	}
	public BigDecimal getR0150_before_nonresident_gre() {
		return r0150_before_nonresident_gre;
	}
	public void setR0150_before_nonresident_gre(BigDecimal r0150_before_nonresident_gre) {
		this.r0150_before_nonresident_gre = r0150_before_nonresident_gre;
	}
	public BigDecimal getR0150_after_nonresident_gre() {
		return r0150_after_nonresident_gre;
	}
	public void setR0150_after_nonresident_gre(BigDecimal r0150_after_nonresident_gre) {
		this.r0150_after_nonresident_gre = r0150_after_nonresident_gre;
	}
	public BigDecimal getR0150_before_resident_corporate() {
		return r0150_before_resident_corporate;
	}
	public void setR0150_before_resident_corporate(BigDecimal r0150_before_resident_corporate) {
		this.r0150_before_resident_corporate = r0150_before_resident_corporate;
	}
	public BigDecimal getR0150_after_resident_corporate() {
		return r0150_after_resident_corporate;
	}
	public void setR0150_after_resident_corporate(BigDecimal r0150_after_resident_corporate) {
		this.r0150_after_resident_corporate = r0150_after_resident_corporate;
	}
	public BigDecimal getR0150_before_nonresident_corporate() {
		return r0150_before_nonresident_corporate;
	}
	public void setR0150_before_nonresident_corporate(BigDecimal r0150_before_nonresident_corporate) {
		this.r0150_before_nonresident_corporate = r0150_before_nonresident_corporate;
	}
	public BigDecimal getR0150_after_nonresident_corporate() {
		return r0150_after_nonresident_corporate;
	}
	public void setR0150_after_nonresident_corporate(BigDecimal r0150_after_nonresident_corporate) {
		this.r0150_after_nonresident_corporate = r0150_after_nonresident_corporate;
	}
	public BigDecimal getR0150_before_resident_nbfi() {
		return r0150_before_resident_nbfi;
	}
	public void setR0150_before_resident_nbfi(BigDecimal r0150_before_resident_nbfi) {
		this.r0150_before_resident_nbfi = r0150_before_resident_nbfi;
	}
	public BigDecimal getR0150_after_resident_nbfi() {
		return r0150_after_resident_nbfi;
	}
	public void setR0150_after_resident_nbfi(BigDecimal r0150_after_resident_nbfi) {
		this.r0150_after_resident_nbfi = r0150_after_resident_nbfi;
	}
	public BigDecimal getR0150_before_nonresident_nbfi() {
		return r0150_before_nonresident_nbfi;
	}
	public void setR0150_before_nonresident_nbfi(BigDecimal r0150_before_nonresident_nbfi) {
		this.r0150_before_nonresident_nbfi = r0150_before_nonresident_nbfi;
	}
	public BigDecimal getR0150_after_nonresident_nbfi() {
		return r0150_after_nonresident_nbfi;
	}
	public void setR0150_after_nonresident_nbfi(BigDecimal r0150_after_nonresident_nbfi) {
		this.r0150_after_nonresident_nbfi = r0150_after_nonresident_nbfi;
	}
	public BigDecimal getR0150_before_resident_bank() {
		return r0150_before_resident_bank;
	}
	public void setR0150_before_resident_bank(BigDecimal r0150_before_resident_bank) {
		this.r0150_before_resident_bank = r0150_before_resident_bank;
	}
	public BigDecimal getR0150_after_resident_bank() {
		return r0150_after_resident_bank;
	}
	public void setR0150_after_resident_bank(BigDecimal r0150_after_resident_bank) {
		this.r0150_after_resident_bank = r0150_after_resident_bank;
	}
	public BigDecimal getR0150_before_nonresident_bank() {
		return r0150_before_nonresident_bank;
	}
	public void setR0150_before_nonresident_bank(BigDecimal r0150_before_nonresident_bank) {
		this.r0150_before_nonresident_bank = r0150_before_nonresident_bank;
	}
	public BigDecimal getR0150_after_nonresident_bank() {
		return r0150_after_nonresident_bank;
	}
	public void setR0150_after_nonresident_bank(BigDecimal r0150_after_nonresident_bank) {
		this.r0150_after_nonresident_bank = r0150_after_nonresident_bank;
	}
	public BigDecimal getR0150_before_resident_government() {
		return r0150_before_resident_government;
	}
	public void setR0150_before_resident_government(BigDecimal r0150_before_resident_government) {
		this.r0150_before_resident_government = r0150_before_resident_government;
	}
	public BigDecimal getR0150_after_resident_government() {
		return r0150_after_resident_government;
	}
	public void setR0150_after_resident_government(BigDecimal r0150_after_resident_government) {
		this.r0150_after_resident_government = r0150_after_resident_government;
	}
	public BigDecimal getR0150_before_nonresident_government() {
		return r0150_before_nonresident_government;
	}
	public void setR0150_before_nonresident_government(BigDecimal r0150_before_nonresident_government) {
		this.r0150_before_nonresident_government = r0150_before_nonresident_government;
	}
	public BigDecimal getR0150_after_nonresident_government() {
		return r0150_after_nonresident_government;
	}
	public void setR0150_after_nonresident_government(BigDecimal r0150_after_nonresident_government) {
		this.r0150_after_nonresident_government = r0150_after_nonresident_government;
	}
	public String getR0160_product() {
		return r0160_product;
	}
	public void setR0160_product(String r0160_product) {
		this.r0160_product = r0160_product;
	}
	public BigDecimal getR0160_before_resident_individual() {
		return r0160_before_resident_individual;
	}
	public void setR0160_before_resident_individual(BigDecimal r0160_before_resident_individual) {
		this.r0160_before_resident_individual = r0160_before_resident_individual;
	}
	public BigDecimal getR0160_after_resident_individual() {
		return r0160_after_resident_individual;
	}
	public void setR0160_after_resident_individual(BigDecimal r0160_after_resident_individual) {
		this.r0160_after_resident_individual = r0160_after_resident_individual;
	}
	public BigDecimal getR0160_before_nonresident_individual() {
		return r0160_before_nonresident_individual;
	}
	public void setR0160_before_nonresident_individual(BigDecimal r0160_before_nonresident_individual) {
		this.r0160_before_nonresident_individual = r0160_before_nonresident_individual;
	}
	public BigDecimal getR0160_after_nonresident_individual() {
		return r0160_after_nonresident_individual;
	}
	public void setR0160_after_nonresident_individual(BigDecimal r0160_after_nonresident_individual) {
		this.r0160_after_nonresident_individual = r0160_after_nonresident_individual;
	}
	public BigDecimal getR0160_before_resident_retail() {
		return r0160_before_resident_retail;
	}
	public void setR0160_before_resident_retail(BigDecimal r0160_before_resident_retail) {
		this.r0160_before_resident_retail = r0160_before_resident_retail;
	}
	public BigDecimal getR0160_after_resident_retail() {
		return r0160_after_resident_retail;
	}
	public void setR0160_after_resident_retail(BigDecimal r0160_after_resident_retail) {
		this.r0160_after_resident_retail = r0160_after_resident_retail;
	}
	public BigDecimal getR0160_before_nonresident_retail() {
		return r0160_before_nonresident_retail;
	}
	public void setR0160_before_nonresident_retail(BigDecimal r0160_before_nonresident_retail) {
		this.r0160_before_nonresident_retail = r0160_before_nonresident_retail;
	}
	public BigDecimal getR0160_after_nonresident_retail() {
		return r0160_after_nonresident_retail;
	}
	public void setR0160_after_nonresident_retail(BigDecimal r0160_after_nonresident_retail) {
		this.r0160_after_nonresident_retail = r0160_after_nonresident_retail;
	}
	public BigDecimal getR0160_before_resident_sme() {
		return r0160_before_resident_sme;
	}
	public void setR0160_before_resident_sme(BigDecimal r0160_before_resident_sme) {
		this.r0160_before_resident_sme = r0160_before_resident_sme;
	}
	public BigDecimal getR0160_after_resident_sme() {
		return r0160_after_resident_sme;
	}
	public void setR0160_after_resident_sme(BigDecimal r0160_after_resident_sme) {
		this.r0160_after_resident_sme = r0160_after_resident_sme;
	}
	public BigDecimal getR0160_before_nonresident_sme() {
		return r0160_before_nonresident_sme;
	}
	public void setR0160_before_nonresident_sme(BigDecimal r0160_before_nonresident_sme) {
		this.r0160_before_nonresident_sme = r0160_before_nonresident_sme;
	}
	public BigDecimal getR0160_after_nonresident_sme() {
		return r0160_after_nonresident_sme;
	}
	public void setR0160_after_nonresident_sme(BigDecimal r0160_after_nonresident_sme) {
		this.r0160_after_nonresident_sme = r0160_after_nonresident_sme;
	}
	public BigDecimal getR0160_before_resident_hni() {
		return r0160_before_resident_hni;
	}
	public void setR0160_before_resident_hni(BigDecimal r0160_before_resident_hni) {
		this.r0160_before_resident_hni = r0160_before_resident_hni;
	}
	public BigDecimal getR0160_after_resident_hni() {
		return r0160_after_resident_hni;
	}
	public void setR0160_after_resident_hni(BigDecimal r0160_after_resident_hni) {
		this.r0160_after_resident_hni = r0160_after_resident_hni;
	}
	public BigDecimal getR0160_before_nonresident_hni() {
		return r0160_before_nonresident_hni;
	}
	public void setR0160_before_nonresident_hni(BigDecimal r0160_before_nonresident_hni) {
		this.r0160_before_nonresident_hni = r0160_before_nonresident_hni;
	}
	public BigDecimal getR0160_after_nonresident_hni() {
		return r0160_after_nonresident_hni;
	}
	public void setR0160_after_nonresident_hni(BigDecimal r0160_after_nonresident_hni) {
		this.r0160_after_nonresident_hni = r0160_after_nonresident_hni;
	}
	public BigDecimal getR0160_before_resident_gre() {
		return r0160_before_resident_gre;
	}
	public void setR0160_before_resident_gre(BigDecimal r0160_before_resident_gre) {
		this.r0160_before_resident_gre = r0160_before_resident_gre;
	}
	public BigDecimal getR0160_after_resident_gre() {
		return r0160_after_resident_gre;
	}
	public void setR0160_after_resident_gre(BigDecimal r0160_after_resident_gre) {
		this.r0160_after_resident_gre = r0160_after_resident_gre;
	}
	public BigDecimal getR0160_before_nonresident_gre() {
		return r0160_before_nonresident_gre;
	}
	public void setR0160_before_nonresident_gre(BigDecimal r0160_before_nonresident_gre) {
		this.r0160_before_nonresident_gre = r0160_before_nonresident_gre;
	}
	public BigDecimal getR0160_after_nonresident_gre() {
		return r0160_after_nonresident_gre;
	}
	public void setR0160_after_nonresident_gre(BigDecimal r0160_after_nonresident_gre) {
		this.r0160_after_nonresident_gre = r0160_after_nonresident_gre;
	}
	public BigDecimal getR0160_before_resident_corporate() {
		return r0160_before_resident_corporate;
	}
	public void setR0160_before_resident_corporate(BigDecimal r0160_before_resident_corporate) {
		this.r0160_before_resident_corporate = r0160_before_resident_corporate;
	}
	public BigDecimal getR0160_after_resident_corporate() {
		return r0160_after_resident_corporate;
	}
	public void setR0160_after_resident_corporate(BigDecimal r0160_after_resident_corporate) {
		this.r0160_after_resident_corporate = r0160_after_resident_corporate;
	}
	public BigDecimal getR0160_before_nonresident_corporate() {
		return r0160_before_nonresident_corporate;
	}
	public void setR0160_before_nonresident_corporate(BigDecimal r0160_before_nonresident_corporate) {
		this.r0160_before_nonresident_corporate = r0160_before_nonresident_corporate;
	}
	public BigDecimal getR0160_after_nonresident_corporate() {
		return r0160_after_nonresident_corporate;
	}
	public void setR0160_after_nonresident_corporate(BigDecimal r0160_after_nonresident_corporate) {
		this.r0160_after_nonresident_corporate = r0160_after_nonresident_corporate;
	}
	public BigDecimal getR0160_before_resident_nbfi() {
		return r0160_before_resident_nbfi;
	}
	public void setR0160_before_resident_nbfi(BigDecimal r0160_before_resident_nbfi) {
		this.r0160_before_resident_nbfi = r0160_before_resident_nbfi;
	}
	public BigDecimal getR0160_after_resident_nbfi() {
		return r0160_after_resident_nbfi;
	}
	public void setR0160_after_resident_nbfi(BigDecimal r0160_after_resident_nbfi) {
		this.r0160_after_resident_nbfi = r0160_after_resident_nbfi;
	}
	public BigDecimal getR0160_before_nonresident_nbfi() {
		return r0160_before_nonresident_nbfi;
	}
	public void setR0160_before_nonresident_nbfi(BigDecimal r0160_before_nonresident_nbfi) {
		this.r0160_before_nonresident_nbfi = r0160_before_nonresident_nbfi;
	}
	public BigDecimal getR0160_after_nonresident_nbfi() {
		return r0160_after_nonresident_nbfi;
	}
	public void setR0160_after_nonresident_nbfi(BigDecimal r0160_after_nonresident_nbfi) {
		this.r0160_after_nonresident_nbfi = r0160_after_nonresident_nbfi;
	}
	public BigDecimal getR0160_before_resident_bank() {
		return r0160_before_resident_bank;
	}
	public void setR0160_before_resident_bank(BigDecimal r0160_before_resident_bank) {
		this.r0160_before_resident_bank = r0160_before_resident_bank;
	}
	public BigDecimal getR0160_after_resident_bank() {
		return r0160_after_resident_bank;
	}
	public void setR0160_after_resident_bank(BigDecimal r0160_after_resident_bank) {
		this.r0160_after_resident_bank = r0160_after_resident_bank;
	}
	public BigDecimal getR0160_before_nonresident_bank() {
		return r0160_before_nonresident_bank;
	}
	public void setR0160_before_nonresident_bank(BigDecimal r0160_before_nonresident_bank) {
		this.r0160_before_nonresident_bank = r0160_before_nonresident_bank;
	}
	public BigDecimal getR0160_after_nonresident_bank() {
		return r0160_after_nonresident_bank;
	}
	public void setR0160_after_nonresident_bank(BigDecimal r0160_after_nonresident_bank) {
		this.r0160_after_nonresident_bank = r0160_after_nonresident_bank;
	}
	public BigDecimal getR0160_before_resident_government() {
		return r0160_before_resident_government;
	}
	public void setR0160_before_resident_government(BigDecimal r0160_before_resident_government) {
		this.r0160_before_resident_government = r0160_before_resident_government;
	}
	public BigDecimal getR0160_after_resident_government() {
		return r0160_after_resident_government;
	}
	public void setR0160_after_resident_government(BigDecimal r0160_after_resident_government) {
		this.r0160_after_resident_government = r0160_after_resident_government;
	}
	public BigDecimal getR0160_before_nonresident_government() {
		return r0160_before_nonresident_government;
	}
	public void setR0160_before_nonresident_government(BigDecimal r0160_before_nonresident_government) {
		this.r0160_before_nonresident_government = r0160_before_nonresident_government;
	}
	public BigDecimal getR0160_after_nonresident_government() {
		return r0160_after_nonresident_government;
	}
	public void setR0160_after_nonresident_government(BigDecimal r0160_after_nonresident_government) {
		this.r0160_after_nonresident_government = r0160_after_nonresident_government;
	}
	public String getR0170_product() {
		return r0170_product;
	}
	public void setR0170_product(String r0170_product) {
		this.r0170_product = r0170_product;
	}
	public BigDecimal getR0170_before_resident_individual() {
		return r0170_before_resident_individual;
	}
	public void setR0170_before_resident_individual(BigDecimal r0170_before_resident_individual) {
		this.r0170_before_resident_individual = r0170_before_resident_individual;
	}
	public BigDecimal getR0170_after_resident_individual() {
		return r0170_after_resident_individual;
	}
	public void setR0170_after_resident_individual(BigDecimal r0170_after_resident_individual) {
		this.r0170_after_resident_individual = r0170_after_resident_individual;
	}
	public BigDecimal getR0170_before_nonresident_individual() {
		return r0170_before_nonresident_individual;
	}
	public void setR0170_before_nonresident_individual(BigDecimal r0170_before_nonresident_individual) {
		this.r0170_before_nonresident_individual = r0170_before_nonresident_individual;
	}
	public BigDecimal getR0170_after_nonresident_individual() {
		return r0170_after_nonresident_individual;
	}
	public void setR0170_after_nonresident_individual(BigDecimal r0170_after_nonresident_individual) {
		this.r0170_after_nonresident_individual = r0170_after_nonresident_individual;
	}
	public BigDecimal getR0170_before_resident_retail() {
		return r0170_before_resident_retail;
	}
	public void setR0170_before_resident_retail(BigDecimal r0170_before_resident_retail) {
		this.r0170_before_resident_retail = r0170_before_resident_retail;
	}
	public BigDecimal getR0170_after_resident_retail() {
		return r0170_after_resident_retail;
	}
	public void setR0170_after_resident_retail(BigDecimal r0170_after_resident_retail) {
		this.r0170_after_resident_retail = r0170_after_resident_retail;
	}
	public BigDecimal getR0170_before_nonresident_retail() {
		return r0170_before_nonresident_retail;
	}
	public void setR0170_before_nonresident_retail(BigDecimal r0170_before_nonresident_retail) {
		this.r0170_before_nonresident_retail = r0170_before_nonresident_retail;
	}
	public BigDecimal getR0170_after_nonresident_retail() {
		return r0170_after_nonresident_retail;
	}
	public void setR0170_after_nonresident_retail(BigDecimal r0170_after_nonresident_retail) {
		this.r0170_after_nonresident_retail = r0170_after_nonresident_retail;
	}
	public BigDecimal getR0170_before_resident_sme() {
		return r0170_before_resident_sme;
	}
	public void setR0170_before_resident_sme(BigDecimal r0170_before_resident_sme) {
		this.r0170_before_resident_sme = r0170_before_resident_sme;
	}
	public BigDecimal getR0170_after_resident_sme() {
		return r0170_after_resident_sme;
	}
	public void setR0170_after_resident_sme(BigDecimal r0170_after_resident_sme) {
		this.r0170_after_resident_sme = r0170_after_resident_sme;
	}
	public BigDecimal getR0170_before_nonresident_sme() {
		return r0170_before_nonresident_sme;
	}
	public void setR0170_before_nonresident_sme(BigDecimal r0170_before_nonresident_sme) {
		this.r0170_before_nonresident_sme = r0170_before_nonresident_sme;
	}
	public BigDecimal getR0170_after_nonresident_sme() {
		return r0170_after_nonresident_sme;
	}
	public void setR0170_after_nonresident_sme(BigDecimal r0170_after_nonresident_sme) {
		this.r0170_after_nonresident_sme = r0170_after_nonresident_sme;
	}
	public BigDecimal getR0170_before_resident_hni() {
		return r0170_before_resident_hni;
	}
	public void setR0170_before_resident_hni(BigDecimal r0170_before_resident_hni) {
		this.r0170_before_resident_hni = r0170_before_resident_hni;
	}
	public BigDecimal getR0170_after_resident_hni() {
		return r0170_after_resident_hni;
	}
	public void setR0170_after_resident_hni(BigDecimal r0170_after_resident_hni) {
		this.r0170_after_resident_hni = r0170_after_resident_hni;
	}
	public BigDecimal getR0170_before_nonresident_hni() {
		return r0170_before_nonresident_hni;
	}
	public void setR0170_before_nonresident_hni(BigDecimal r0170_before_nonresident_hni) {
		this.r0170_before_nonresident_hni = r0170_before_nonresident_hni;
	}
	public BigDecimal getR0170_after_nonresident_hni() {
		return r0170_after_nonresident_hni;
	}
	public void setR0170_after_nonresident_hni(BigDecimal r0170_after_nonresident_hni) {
		this.r0170_after_nonresident_hni = r0170_after_nonresident_hni;
	}
	public BigDecimal getR0170_before_resident_gre() {
		return r0170_before_resident_gre;
	}
	public void setR0170_before_resident_gre(BigDecimal r0170_before_resident_gre) {
		this.r0170_before_resident_gre = r0170_before_resident_gre;
	}
	public BigDecimal getR0170_after_resident_gre() {
		return r0170_after_resident_gre;
	}
	public void setR0170_after_resident_gre(BigDecimal r0170_after_resident_gre) {
		this.r0170_after_resident_gre = r0170_after_resident_gre;
	}
	public BigDecimal getR0170_before_nonresident_gre() {
		return r0170_before_nonresident_gre;
	}
	public void setR0170_before_nonresident_gre(BigDecimal r0170_before_nonresident_gre) {
		this.r0170_before_nonresident_gre = r0170_before_nonresident_gre;
	}
	public BigDecimal getR0170_after_nonresident_gre() {
		return r0170_after_nonresident_gre;
	}
	public void setR0170_after_nonresident_gre(BigDecimal r0170_after_nonresident_gre) {
		this.r0170_after_nonresident_gre = r0170_after_nonresident_gre;
	}
	public BigDecimal getR0170_before_resident_corporate() {
		return r0170_before_resident_corporate;
	}
	public void setR0170_before_resident_corporate(BigDecimal r0170_before_resident_corporate) {
		this.r0170_before_resident_corporate = r0170_before_resident_corporate;
	}
	public BigDecimal getR0170_after_resident_corporate() {
		return r0170_after_resident_corporate;
	}
	public void setR0170_after_resident_corporate(BigDecimal r0170_after_resident_corporate) {
		this.r0170_after_resident_corporate = r0170_after_resident_corporate;
	}
	public BigDecimal getR0170_before_nonresident_corporate() {
		return r0170_before_nonresident_corporate;
	}
	public void setR0170_before_nonresident_corporate(BigDecimal r0170_before_nonresident_corporate) {
		this.r0170_before_nonresident_corporate = r0170_before_nonresident_corporate;
	}
	public BigDecimal getR0170_after_nonresident_corporate() {
		return r0170_after_nonresident_corporate;
	}
	public void setR0170_after_nonresident_corporate(BigDecimal r0170_after_nonresident_corporate) {
		this.r0170_after_nonresident_corporate = r0170_after_nonresident_corporate;
	}
	public BigDecimal getR0170_before_resident_nbfi() {
		return r0170_before_resident_nbfi;
	}
	public void setR0170_before_resident_nbfi(BigDecimal r0170_before_resident_nbfi) {
		this.r0170_before_resident_nbfi = r0170_before_resident_nbfi;
	}
	public BigDecimal getR0170_after_resident_nbfi() {
		return r0170_after_resident_nbfi;
	}
	public void setR0170_after_resident_nbfi(BigDecimal r0170_after_resident_nbfi) {
		this.r0170_after_resident_nbfi = r0170_after_resident_nbfi;
	}
	public BigDecimal getR0170_before_nonresident_nbfi() {
		return r0170_before_nonresident_nbfi;
	}
	public void setR0170_before_nonresident_nbfi(BigDecimal r0170_before_nonresident_nbfi) {
		this.r0170_before_nonresident_nbfi = r0170_before_nonresident_nbfi;
	}
	public BigDecimal getR0170_after_nonresident_nbfi() {
		return r0170_after_nonresident_nbfi;
	}
	public void setR0170_after_nonresident_nbfi(BigDecimal r0170_after_nonresident_nbfi) {
		this.r0170_after_nonresident_nbfi = r0170_after_nonresident_nbfi;
	}
	public BigDecimal getR0170_before_resident_bank() {
		return r0170_before_resident_bank;
	}
	public void setR0170_before_resident_bank(BigDecimal r0170_before_resident_bank) {
		this.r0170_before_resident_bank = r0170_before_resident_bank;
	}
	public BigDecimal getR0170_after_resident_bank() {
		return r0170_after_resident_bank;
	}
	public void setR0170_after_resident_bank(BigDecimal r0170_after_resident_bank) {
		this.r0170_after_resident_bank = r0170_after_resident_bank;
	}
	public BigDecimal getR0170_before_nonresident_bank() {
		return r0170_before_nonresident_bank;
	}
	public void setR0170_before_nonresident_bank(BigDecimal r0170_before_nonresident_bank) {
		this.r0170_before_nonresident_bank = r0170_before_nonresident_bank;
	}
	public BigDecimal getR0170_after_nonresident_bank() {
		return r0170_after_nonresident_bank;
	}
	public void setR0170_after_nonresident_bank(BigDecimal r0170_after_nonresident_bank) {
		this.r0170_after_nonresident_bank = r0170_after_nonresident_bank;
	}
	public BigDecimal getR0170_before_resident_government() {
		return r0170_before_resident_government;
	}
	public void setR0170_before_resident_government(BigDecimal r0170_before_resident_government) {
		this.r0170_before_resident_government = r0170_before_resident_government;
	}
	public BigDecimal getR0170_after_resident_government() {
		return r0170_after_resident_government;
	}
	public void setR0170_after_resident_government(BigDecimal r0170_after_resident_government) {
		this.r0170_after_resident_government = r0170_after_resident_government;
	}
	public BigDecimal getR0170_before_nonresident_government() {
		return r0170_before_nonresident_government;
	}
	public void setR0170_before_nonresident_government(BigDecimal r0170_before_nonresident_government) {
		this.r0170_before_nonresident_government = r0170_before_nonresident_government;
	}
	public BigDecimal getR0170_after_nonresident_government() {
		return r0170_after_nonresident_government;
	}
	public void setR0170_after_nonresident_government(BigDecimal r0170_after_nonresident_government) {
		this.r0170_after_nonresident_government = r0170_after_nonresident_government;
	}
	public String getR0180_product() {
		return r0180_product;
	}
	public void setR0180_product(String r0180_product) {
		this.r0180_product = r0180_product;
	}
	public BigDecimal getR0180_before_resident_individual() {
		return r0180_before_resident_individual;
	}
	public void setR0180_before_resident_individual(BigDecimal r0180_before_resident_individual) {
		this.r0180_before_resident_individual = r0180_before_resident_individual;
	}
	public BigDecimal getR0180_after_resident_individual() {
		return r0180_after_resident_individual;
	}
	public void setR0180_after_resident_individual(BigDecimal r0180_after_resident_individual) {
		this.r0180_after_resident_individual = r0180_after_resident_individual;
	}
	public BigDecimal getR0180_before_nonresident_individual() {
		return r0180_before_nonresident_individual;
	}
	public void setR0180_before_nonresident_individual(BigDecimal r0180_before_nonresident_individual) {
		this.r0180_before_nonresident_individual = r0180_before_nonresident_individual;
	}
	public BigDecimal getR0180_after_nonresident_individual() {
		return r0180_after_nonresident_individual;
	}
	public void setR0180_after_nonresident_individual(BigDecimal r0180_after_nonresident_individual) {
		this.r0180_after_nonresident_individual = r0180_after_nonresident_individual;
	}
	public BigDecimal getR0180_before_resident_retail() {
		return r0180_before_resident_retail;
	}
	public void setR0180_before_resident_retail(BigDecimal r0180_before_resident_retail) {
		this.r0180_before_resident_retail = r0180_before_resident_retail;
	}
	public BigDecimal getR0180_after_resident_retail() {
		return r0180_after_resident_retail;
	}
	public void setR0180_after_resident_retail(BigDecimal r0180_after_resident_retail) {
		this.r0180_after_resident_retail = r0180_after_resident_retail;
	}
	public BigDecimal getR0180_before_nonresident_retail() {
		return r0180_before_nonresident_retail;
	}
	public void setR0180_before_nonresident_retail(BigDecimal r0180_before_nonresident_retail) {
		this.r0180_before_nonresident_retail = r0180_before_nonresident_retail;
	}
	public BigDecimal getR0180_after_nonresident_retail() {
		return r0180_after_nonresident_retail;
	}
	public void setR0180_after_nonresident_retail(BigDecimal r0180_after_nonresident_retail) {
		this.r0180_after_nonresident_retail = r0180_after_nonresident_retail;
	}
	public BigDecimal getR0180_before_resident_sme() {
		return r0180_before_resident_sme;
	}
	public void setR0180_before_resident_sme(BigDecimal r0180_before_resident_sme) {
		this.r0180_before_resident_sme = r0180_before_resident_sme;
	}
	public BigDecimal getR0180_after_resident_sme() {
		return r0180_after_resident_sme;
	}
	public void setR0180_after_resident_sme(BigDecimal r0180_after_resident_sme) {
		this.r0180_after_resident_sme = r0180_after_resident_sme;
	}
	public BigDecimal getR0180_before_nonresident_sme() {
		return r0180_before_nonresident_sme;
	}
	public void setR0180_before_nonresident_sme(BigDecimal r0180_before_nonresident_sme) {
		this.r0180_before_nonresident_sme = r0180_before_nonresident_sme;
	}
	public BigDecimal getR0180_after_nonresident_sme() {
		return r0180_after_nonresident_sme;
	}
	public void setR0180_after_nonresident_sme(BigDecimal r0180_after_nonresident_sme) {
		this.r0180_after_nonresident_sme = r0180_after_nonresident_sme;
	}
	public BigDecimal getR0180_before_resident_hni() {
		return r0180_before_resident_hni;
	}
	public void setR0180_before_resident_hni(BigDecimal r0180_before_resident_hni) {
		this.r0180_before_resident_hni = r0180_before_resident_hni;
	}
	public BigDecimal getR0180_after_resident_hni() {
		return r0180_after_resident_hni;
	}
	public void setR0180_after_resident_hni(BigDecimal r0180_after_resident_hni) {
		this.r0180_after_resident_hni = r0180_after_resident_hni;
	}
	public BigDecimal getR0180_before_nonresident_hni() {
		return r0180_before_nonresident_hni;
	}
	public void setR0180_before_nonresident_hni(BigDecimal r0180_before_nonresident_hni) {
		this.r0180_before_nonresident_hni = r0180_before_nonresident_hni;
	}
	public BigDecimal getR0180_after_nonresident_hni() {
		return r0180_after_nonresident_hni;
	}
	public void setR0180_after_nonresident_hni(BigDecimal r0180_after_nonresident_hni) {
		this.r0180_after_nonresident_hni = r0180_after_nonresident_hni;
	}
	public BigDecimal getR0180_before_resident_gre() {
		return r0180_before_resident_gre;
	}
	public void setR0180_before_resident_gre(BigDecimal r0180_before_resident_gre) {
		this.r0180_before_resident_gre = r0180_before_resident_gre;
	}
	public BigDecimal getR0180_after_resident_gre() {
		return r0180_after_resident_gre;
	}
	public void setR0180_after_resident_gre(BigDecimal r0180_after_resident_gre) {
		this.r0180_after_resident_gre = r0180_after_resident_gre;
	}
	public BigDecimal getR0180_before_nonresident_gre() {
		return r0180_before_nonresident_gre;
	}
	public void setR0180_before_nonresident_gre(BigDecimal r0180_before_nonresident_gre) {
		this.r0180_before_nonresident_gre = r0180_before_nonresident_gre;
	}
	public BigDecimal getR0180_after_nonresident_gre() {
		return r0180_after_nonresident_gre;
	}
	public void setR0180_after_nonresident_gre(BigDecimal r0180_after_nonresident_gre) {
		this.r0180_after_nonresident_gre = r0180_after_nonresident_gre;
	}
	public BigDecimal getR0180_before_resident_corporate() {
		return r0180_before_resident_corporate;
	}
	public void setR0180_before_resident_corporate(BigDecimal r0180_before_resident_corporate) {
		this.r0180_before_resident_corporate = r0180_before_resident_corporate;
	}
	public BigDecimal getR0180_after_resident_corporate() {
		return r0180_after_resident_corporate;
	}
	public void setR0180_after_resident_corporate(BigDecimal r0180_after_resident_corporate) {
		this.r0180_after_resident_corporate = r0180_after_resident_corporate;
	}
	public BigDecimal getR0180_before_nonresident_corporate() {
		return r0180_before_nonresident_corporate;
	}
	public void setR0180_before_nonresident_corporate(BigDecimal r0180_before_nonresident_corporate) {
		this.r0180_before_nonresident_corporate = r0180_before_nonresident_corporate;
	}
	public BigDecimal getR0180_after_nonresident_corporate() {
		return r0180_after_nonresident_corporate;
	}
	public void setR0180_after_nonresident_corporate(BigDecimal r0180_after_nonresident_corporate) {
		this.r0180_after_nonresident_corporate = r0180_after_nonresident_corporate;
	}
	public BigDecimal getR0180_before_resident_nbfi() {
		return r0180_before_resident_nbfi;
	}
	public void setR0180_before_resident_nbfi(BigDecimal r0180_before_resident_nbfi) {
		this.r0180_before_resident_nbfi = r0180_before_resident_nbfi;
	}
	public BigDecimal getR0180_after_resident_nbfi() {
		return r0180_after_resident_nbfi;
	}
	public void setR0180_after_resident_nbfi(BigDecimal r0180_after_resident_nbfi) {
		this.r0180_after_resident_nbfi = r0180_after_resident_nbfi;
	}
	public BigDecimal getR0180_before_nonresident_nbfi() {
		return r0180_before_nonresident_nbfi;
	}
	public void setR0180_before_nonresident_nbfi(BigDecimal r0180_before_nonresident_nbfi) {
		this.r0180_before_nonresident_nbfi = r0180_before_nonresident_nbfi;
	}
	public BigDecimal getR0180_after_nonresident_nbfi() {
		return r0180_after_nonresident_nbfi;
	}
	public void setR0180_after_nonresident_nbfi(BigDecimal r0180_after_nonresident_nbfi) {
		this.r0180_after_nonresident_nbfi = r0180_after_nonresident_nbfi;
	}
	public BigDecimal getR0180_before_resident_bank() {
		return r0180_before_resident_bank;
	}
	public void setR0180_before_resident_bank(BigDecimal r0180_before_resident_bank) {
		this.r0180_before_resident_bank = r0180_before_resident_bank;
	}
	public BigDecimal getR0180_after_resident_bank() {
		return r0180_after_resident_bank;
	}
	public void setR0180_after_resident_bank(BigDecimal r0180_after_resident_bank) {
		this.r0180_after_resident_bank = r0180_after_resident_bank;
	}
	public BigDecimal getR0180_before_nonresident_bank() {
		return r0180_before_nonresident_bank;
	}
	public void setR0180_before_nonresident_bank(BigDecimal r0180_before_nonresident_bank) {
		this.r0180_before_nonresident_bank = r0180_before_nonresident_bank;
	}
	public BigDecimal getR0180_after_nonresident_bank() {
		return r0180_after_nonresident_bank;
	}
	public void setR0180_after_nonresident_bank(BigDecimal r0180_after_nonresident_bank) {
		this.r0180_after_nonresident_bank = r0180_after_nonresident_bank;
	}
	public BigDecimal getR0180_before_resident_government() {
		return r0180_before_resident_government;
	}
	public void setR0180_before_resident_government(BigDecimal r0180_before_resident_government) {
		this.r0180_before_resident_government = r0180_before_resident_government;
	}
	public BigDecimal getR0180_after_resident_government() {
		return r0180_after_resident_government;
	}
	public void setR0180_after_resident_government(BigDecimal r0180_after_resident_government) {
		this.r0180_after_resident_government = r0180_after_resident_government;
	}
	public BigDecimal getR0180_before_nonresident_government() {
		return r0180_before_nonresident_government;
	}
	public void setR0180_before_nonresident_government(BigDecimal r0180_before_nonresident_government) {
		this.r0180_before_nonresident_government = r0180_before_nonresident_government;
	}
	public BigDecimal getR0180_after_nonresident_government() {
		return r0180_after_nonresident_government;
	}
	public void setR0180_after_nonresident_government(BigDecimal r0180_after_nonresident_government) {
		this.r0180_after_nonresident_government = r0180_after_nonresident_government;
	}
	public String getR0190_product() {
		return r0190_product;
	}
	public void setR0190_product(String r0190_product) {
		this.r0190_product = r0190_product;
	}
	public BigDecimal getR0190_before_resident_individual() {
		return r0190_before_resident_individual;
	}
	public void setR0190_before_resident_individual(BigDecimal r0190_before_resident_individual) {
		this.r0190_before_resident_individual = r0190_before_resident_individual;
	}
	public BigDecimal getR0190_after_resident_individual() {
		return r0190_after_resident_individual;
	}
	public void setR0190_after_resident_individual(BigDecimal r0190_after_resident_individual) {
		this.r0190_after_resident_individual = r0190_after_resident_individual;
	}
	public BigDecimal getR0190_before_nonresident_individual() {
		return r0190_before_nonresident_individual;
	}
	public void setR0190_before_nonresident_individual(BigDecimal r0190_before_nonresident_individual) {
		this.r0190_before_nonresident_individual = r0190_before_nonresident_individual;
	}
	public BigDecimal getR0190_after_nonresident_individual() {
		return r0190_after_nonresident_individual;
	}
	public void setR0190_after_nonresident_individual(BigDecimal r0190_after_nonresident_individual) {
		this.r0190_after_nonresident_individual = r0190_after_nonresident_individual;
	}
	public BigDecimal getR0190_before_resident_retail() {
		return r0190_before_resident_retail;
	}
	public void setR0190_before_resident_retail(BigDecimal r0190_before_resident_retail) {
		this.r0190_before_resident_retail = r0190_before_resident_retail;
	}
	public BigDecimal getR0190_after_resident_retail() {
		return r0190_after_resident_retail;
	}
	public void setR0190_after_resident_retail(BigDecimal r0190_after_resident_retail) {
		this.r0190_after_resident_retail = r0190_after_resident_retail;
	}
	public BigDecimal getR0190_before_nonresident_retail() {
		return r0190_before_nonresident_retail;
	}
	public void setR0190_before_nonresident_retail(BigDecimal r0190_before_nonresident_retail) {
		this.r0190_before_nonresident_retail = r0190_before_nonresident_retail;
	}
	public BigDecimal getR0190_after_nonresident_retail() {
		return r0190_after_nonresident_retail;
	}
	public void setR0190_after_nonresident_retail(BigDecimal r0190_after_nonresident_retail) {
		this.r0190_after_nonresident_retail = r0190_after_nonresident_retail;
	}
	public BigDecimal getR0190_before_resident_sme() {
		return r0190_before_resident_sme;
	}
	public void setR0190_before_resident_sme(BigDecimal r0190_before_resident_sme) {
		this.r0190_before_resident_sme = r0190_before_resident_sme;
	}
	public BigDecimal getR0190_after_resident_sme() {
		return r0190_after_resident_sme;
	}
	public void setR0190_after_resident_sme(BigDecimal r0190_after_resident_sme) {
		this.r0190_after_resident_sme = r0190_after_resident_sme;
	}
	public BigDecimal getR0190_before_nonresident_sme() {
		return r0190_before_nonresident_sme;
	}
	public void setR0190_before_nonresident_sme(BigDecimal r0190_before_nonresident_sme) {
		this.r0190_before_nonresident_sme = r0190_before_nonresident_sme;
	}
	public BigDecimal getR0190_after_nonresident_sme() {
		return r0190_after_nonresident_sme;
	}
	public void setR0190_after_nonresident_sme(BigDecimal r0190_after_nonresident_sme) {
		this.r0190_after_nonresident_sme = r0190_after_nonresident_sme;
	}
	public BigDecimal getR0190_before_resident_hni() {
		return r0190_before_resident_hni;
	}
	public void setR0190_before_resident_hni(BigDecimal r0190_before_resident_hni) {
		this.r0190_before_resident_hni = r0190_before_resident_hni;
	}
	public BigDecimal getR0190_after_resident_hni() {
		return r0190_after_resident_hni;
	}
	public void setR0190_after_resident_hni(BigDecimal r0190_after_resident_hni) {
		this.r0190_after_resident_hni = r0190_after_resident_hni;
	}
	public BigDecimal getR0190_before_nonresident_hni() {
		return r0190_before_nonresident_hni;
	}
	public void setR0190_before_nonresident_hni(BigDecimal r0190_before_nonresident_hni) {
		this.r0190_before_nonresident_hni = r0190_before_nonresident_hni;
	}
	public BigDecimal getR0190_after_nonresident_hni() {
		return r0190_after_nonresident_hni;
	}
	public void setR0190_after_nonresident_hni(BigDecimal r0190_after_nonresident_hni) {
		this.r0190_after_nonresident_hni = r0190_after_nonresident_hni;
	}
	public BigDecimal getR0190_before_resident_gre() {
		return r0190_before_resident_gre;
	}
	public void setR0190_before_resident_gre(BigDecimal r0190_before_resident_gre) {
		this.r0190_before_resident_gre = r0190_before_resident_gre;
	}
	public BigDecimal getR0190_after_resident_gre() {
		return r0190_after_resident_gre;
	}
	public void setR0190_after_resident_gre(BigDecimal r0190_after_resident_gre) {
		this.r0190_after_resident_gre = r0190_after_resident_gre;
	}
	public BigDecimal getR0190_before_nonresident_gre() {
		return r0190_before_nonresident_gre;
	}
	public void setR0190_before_nonresident_gre(BigDecimal r0190_before_nonresident_gre) {
		this.r0190_before_nonresident_gre = r0190_before_nonresident_gre;
	}
	public BigDecimal getR0190_after_nonresident_gre() {
		return r0190_after_nonresident_gre;
	}
	public void setR0190_after_nonresident_gre(BigDecimal r0190_after_nonresident_gre) {
		this.r0190_after_nonresident_gre = r0190_after_nonresident_gre;
	}
	public BigDecimal getR0190_before_resident_corporate() {
		return r0190_before_resident_corporate;
	}
	public void setR0190_before_resident_corporate(BigDecimal r0190_before_resident_corporate) {
		this.r0190_before_resident_corporate = r0190_before_resident_corporate;
	}
	public BigDecimal getR0190_after_resident_corporate() {
		return r0190_after_resident_corporate;
	}
	public void setR0190_after_resident_corporate(BigDecimal r0190_after_resident_corporate) {
		this.r0190_after_resident_corporate = r0190_after_resident_corporate;
	}
	public BigDecimal getR0190_before_nonresident_corporate() {
		return r0190_before_nonresident_corporate;
	}
	public void setR0190_before_nonresident_corporate(BigDecimal r0190_before_nonresident_corporate) {
		this.r0190_before_nonresident_corporate = r0190_before_nonresident_corporate;
	}
	public BigDecimal getR0190_after_nonresident_corporate() {
		return r0190_after_nonresident_corporate;
	}
	public void setR0190_after_nonresident_corporate(BigDecimal r0190_after_nonresident_corporate) {
		this.r0190_after_nonresident_corporate = r0190_after_nonresident_corporate;
	}
	public BigDecimal getR0190_before_resident_nbfi() {
		return r0190_before_resident_nbfi;
	}
	public void setR0190_before_resident_nbfi(BigDecimal r0190_before_resident_nbfi) {
		this.r0190_before_resident_nbfi = r0190_before_resident_nbfi;
	}
	public BigDecimal getR0190_after_resident_nbfi() {
		return r0190_after_resident_nbfi;
	}
	public void setR0190_after_resident_nbfi(BigDecimal r0190_after_resident_nbfi) {
		this.r0190_after_resident_nbfi = r0190_after_resident_nbfi;
	}
	public BigDecimal getR0190_before_nonresident_nbfi() {
		return r0190_before_nonresident_nbfi;
	}
	public void setR0190_before_nonresident_nbfi(BigDecimal r0190_before_nonresident_nbfi) {
		this.r0190_before_nonresident_nbfi = r0190_before_nonresident_nbfi;
	}
	public BigDecimal getR0190_after_nonresident_nbfi() {
		return r0190_after_nonresident_nbfi;
	}
	public void setR0190_after_nonresident_nbfi(BigDecimal r0190_after_nonresident_nbfi) {
		this.r0190_after_nonresident_nbfi = r0190_after_nonresident_nbfi;
	}
	public BigDecimal getR0190_before_resident_bank() {
		return r0190_before_resident_bank;
	}
	public void setR0190_before_resident_bank(BigDecimal r0190_before_resident_bank) {
		this.r0190_before_resident_bank = r0190_before_resident_bank;
	}
	public BigDecimal getR0190_after_resident_bank() {
		return r0190_after_resident_bank;
	}
	public void setR0190_after_resident_bank(BigDecimal r0190_after_resident_bank) {
		this.r0190_after_resident_bank = r0190_after_resident_bank;
	}
	public BigDecimal getR0190_before_nonresident_bank() {
		return r0190_before_nonresident_bank;
	}
	public void setR0190_before_nonresident_bank(BigDecimal r0190_before_nonresident_bank) {
		this.r0190_before_nonresident_bank = r0190_before_nonresident_bank;
	}
	public BigDecimal getR0190_after_nonresident_bank() {
		return r0190_after_nonresident_bank;
	}
	public void setR0190_after_nonresident_bank(BigDecimal r0190_after_nonresident_bank) {
		this.r0190_after_nonresident_bank = r0190_after_nonresident_bank;
	}
	public BigDecimal getR0190_before_resident_government() {
		return r0190_before_resident_government;
	}
	public void setR0190_before_resident_government(BigDecimal r0190_before_resident_government) {
		this.r0190_before_resident_government = r0190_before_resident_government;
	}
	public BigDecimal getR0190_after_resident_government() {
		return r0190_after_resident_government;
	}
	public void setR0190_after_resident_government(BigDecimal r0190_after_resident_government) {
		this.r0190_after_resident_government = r0190_after_resident_government;
	}
	public BigDecimal getR0190_before_nonresident_government() {
		return r0190_before_nonresident_government;
	}
	public void setR0190_before_nonresident_government(BigDecimal r0190_before_nonresident_government) {
		this.r0190_before_nonresident_government = r0190_before_nonresident_government;
	}
	public BigDecimal getR0190_after_nonresident_government() {
		return r0190_after_nonresident_government;
	}
	public void setR0190_after_nonresident_government(BigDecimal r0190_after_nonresident_government) {
		this.r0190_after_nonresident_government = r0190_after_nonresident_government;
	}
	public String getR0200_product() {
		return r0200_product;
	}
	public void setR0200_product(String r0200_product) {
		this.r0200_product = r0200_product;
	}
	public BigDecimal getR0200_before_resident_individual() {
		return r0200_before_resident_individual;
	}
	public void setR0200_before_resident_individual(BigDecimal r0200_before_resident_individual) {
		this.r0200_before_resident_individual = r0200_before_resident_individual;
	}
	public BigDecimal getR0200_after_resident_individual() {
		return r0200_after_resident_individual;
	}
	public void setR0200_after_resident_individual(BigDecimal r0200_after_resident_individual) {
		this.r0200_after_resident_individual = r0200_after_resident_individual;
	}
	public BigDecimal getR0200_before_nonresident_individual() {
		return r0200_before_nonresident_individual;
	}
	public void setR0200_before_nonresident_individual(BigDecimal r0200_before_nonresident_individual) {
		this.r0200_before_nonresident_individual = r0200_before_nonresident_individual;
	}
	public BigDecimal getR0200_after_nonresident_individual() {
		return r0200_after_nonresident_individual;
	}
	public void setR0200_after_nonresident_individual(BigDecimal r0200_after_nonresident_individual) {
		this.r0200_after_nonresident_individual = r0200_after_nonresident_individual;
	}
	public BigDecimal getR0200_before_resident_retail() {
		return r0200_before_resident_retail;
	}
	public void setR0200_before_resident_retail(BigDecimal r0200_before_resident_retail) {
		this.r0200_before_resident_retail = r0200_before_resident_retail;
	}
	public BigDecimal getR0200_after_resident_retail() {
		return r0200_after_resident_retail;
	}
	public void setR0200_after_resident_retail(BigDecimal r0200_after_resident_retail) {
		this.r0200_after_resident_retail = r0200_after_resident_retail;
	}
	public BigDecimal getR0200_before_nonresident_retail() {
		return r0200_before_nonresident_retail;
	}
	public void setR0200_before_nonresident_retail(BigDecimal r0200_before_nonresident_retail) {
		this.r0200_before_nonresident_retail = r0200_before_nonresident_retail;
	}
	public BigDecimal getR0200_after_nonresident_retail() {
		return r0200_after_nonresident_retail;
	}
	public void setR0200_after_nonresident_retail(BigDecimal r0200_after_nonresident_retail) {
		this.r0200_after_nonresident_retail = r0200_after_nonresident_retail;
	}
	public BigDecimal getR0200_before_resident_sme() {
		return r0200_before_resident_sme;
	}
	public void setR0200_before_resident_sme(BigDecimal r0200_before_resident_sme) {
		this.r0200_before_resident_sme = r0200_before_resident_sme;
	}
	public BigDecimal getR0200_after_resident_sme() {
		return r0200_after_resident_sme;
	}
	public void setR0200_after_resident_sme(BigDecimal r0200_after_resident_sme) {
		this.r0200_after_resident_sme = r0200_after_resident_sme;
	}
	public BigDecimal getR0200_before_nonresident_sme() {
		return r0200_before_nonresident_sme;
	}
	public void setR0200_before_nonresident_sme(BigDecimal r0200_before_nonresident_sme) {
		this.r0200_before_nonresident_sme = r0200_before_nonresident_sme;
	}
	public BigDecimal getR0200_after_nonresident_sme() {
		return r0200_after_nonresident_sme;
	}
	public void setR0200_after_nonresident_sme(BigDecimal r0200_after_nonresident_sme) {
		this.r0200_after_nonresident_sme = r0200_after_nonresident_sme;
	}
	public BigDecimal getR0200_before_resident_hni() {
		return r0200_before_resident_hni;
	}
	public void setR0200_before_resident_hni(BigDecimal r0200_before_resident_hni) {
		this.r0200_before_resident_hni = r0200_before_resident_hni;
	}
	public BigDecimal getR0200_after_resident_hni() {
		return r0200_after_resident_hni;
	}
	public void setR0200_after_resident_hni(BigDecimal r0200_after_resident_hni) {
		this.r0200_after_resident_hni = r0200_after_resident_hni;
	}
	public BigDecimal getR0200_before_nonresident_hni() {
		return r0200_before_nonresident_hni;
	}
	public void setR0200_before_nonresident_hni(BigDecimal r0200_before_nonresident_hni) {
		this.r0200_before_nonresident_hni = r0200_before_nonresident_hni;
	}
	public BigDecimal getR0200_after_nonresident_hni() {
		return r0200_after_nonresident_hni;
	}
	public void setR0200_after_nonresident_hni(BigDecimal r0200_after_nonresident_hni) {
		this.r0200_after_nonresident_hni = r0200_after_nonresident_hni;
	}
	public BigDecimal getR0200_before_resident_gre() {
		return r0200_before_resident_gre;
	}
	public void setR0200_before_resident_gre(BigDecimal r0200_before_resident_gre) {
		this.r0200_before_resident_gre = r0200_before_resident_gre;
	}
	public BigDecimal getR0200_after_resident_gre() {
		return r0200_after_resident_gre;
	}
	public void setR0200_after_resident_gre(BigDecimal r0200_after_resident_gre) {
		this.r0200_after_resident_gre = r0200_after_resident_gre;
	}
	public BigDecimal getR0200_before_nonresident_gre() {
		return r0200_before_nonresident_gre;
	}
	public void setR0200_before_nonresident_gre(BigDecimal r0200_before_nonresident_gre) {
		this.r0200_before_nonresident_gre = r0200_before_nonresident_gre;
	}
	public BigDecimal getR0200_after_nonresident_gre() {
		return r0200_after_nonresident_gre;
	}
	public void setR0200_after_nonresident_gre(BigDecimal r0200_after_nonresident_gre) {
		this.r0200_after_nonresident_gre = r0200_after_nonresident_gre;
	}
	public BigDecimal getR0200_before_resident_corporate() {
		return r0200_before_resident_corporate;
	}
	public void setR0200_before_resident_corporate(BigDecimal r0200_before_resident_corporate) {
		this.r0200_before_resident_corporate = r0200_before_resident_corporate;
	}
	public BigDecimal getR0200_after_resident_corporate() {
		return r0200_after_resident_corporate;
	}
	public void setR0200_after_resident_corporate(BigDecimal r0200_after_resident_corporate) {
		this.r0200_after_resident_corporate = r0200_after_resident_corporate;
	}
	public BigDecimal getR0200_before_nonresident_corporate() {
		return r0200_before_nonresident_corporate;
	}
	public void setR0200_before_nonresident_corporate(BigDecimal r0200_before_nonresident_corporate) {
		this.r0200_before_nonresident_corporate = r0200_before_nonresident_corporate;
	}
	public BigDecimal getR0200_after_nonresident_corporate() {
		return r0200_after_nonresident_corporate;
	}
	public void setR0200_after_nonresident_corporate(BigDecimal r0200_after_nonresident_corporate) {
		this.r0200_after_nonresident_corporate = r0200_after_nonresident_corporate;
	}
	public BigDecimal getR0200_before_resident_nbfi() {
		return r0200_before_resident_nbfi;
	}
	public void setR0200_before_resident_nbfi(BigDecimal r0200_before_resident_nbfi) {
		this.r0200_before_resident_nbfi = r0200_before_resident_nbfi;
	}
	public BigDecimal getR0200_after_resident_nbfi() {
		return r0200_after_resident_nbfi;
	}
	public void setR0200_after_resident_nbfi(BigDecimal r0200_after_resident_nbfi) {
		this.r0200_after_resident_nbfi = r0200_after_resident_nbfi;
	}
	public BigDecimal getR0200_before_nonresident_nbfi() {
		return r0200_before_nonresident_nbfi;
	}
	public void setR0200_before_nonresident_nbfi(BigDecimal r0200_before_nonresident_nbfi) {
		this.r0200_before_nonresident_nbfi = r0200_before_nonresident_nbfi;
	}
	public BigDecimal getR0200_after_nonresident_nbfi() {
		return r0200_after_nonresident_nbfi;
	}
	public void setR0200_after_nonresident_nbfi(BigDecimal r0200_after_nonresident_nbfi) {
		this.r0200_after_nonresident_nbfi = r0200_after_nonresident_nbfi;
	}
	public BigDecimal getR0200_before_resident_bank() {
		return r0200_before_resident_bank;
	}
	public void setR0200_before_resident_bank(BigDecimal r0200_before_resident_bank) {
		this.r0200_before_resident_bank = r0200_before_resident_bank;
	}
	public BigDecimal getR0200_after_resident_bank() {
		return r0200_after_resident_bank;
	}
	public void setR0200_after_resident_bank(BigDecimal r0200_after_resident_bank) {
		this.r0200_after_resident_bank = r0200_after_resident_bank;
	}
	public BigDecimal getR0200_before_nonresident_bank() {
		return r0200_before_nonresident_bank;
	}
	public void setR0200_before_nonresident_bank(BigDecimal r0200_before_nonresident_bank) {
		this.r0200_before_nonresident_bank = r0200_before_nonresident_bank;
	}
	public BigDecimal getR0200_after_nonresident_bank() {
		return r0200_after_nonresident_bank;
	}
	public void setR0200_after_nonresident_bank(BigDecimal r0200_after_nonresident_bank) {
		this.r0200_after_nonresident_bank = r0200_after_nonresident_bank;
	}
	public BigDecimal getR0200_before_resident_government() {
		return r0200_before_resident_government;
	}
	public void setR0200_before_resident_government(BigDecimal r0200_before_resident_government) {
		this.r0200_before_resident_government = r0200_before_resident_government;
	}
	public BigDecimal getR0200_after_resident_government() {
		return r0200_after_resident_government;
	}
	public void setR0200_after_resident_government(BigDecimal r0200_after_resident_government) {
		this.r0200_after_resident_government = r0200_after_resident_government;
	}
	public BigDecimal getR0200_before_nonresident_government() {
		return r0200_before_nonresident_government;
	}
	public void setR0200_before_nonresident_government(BigDecimal r0200_before_nonresident_government) {
		this.r0200_before_nonresident_government = r0200_before_nonresident_government;
	}
	public BigDecimal getR0200_after_nonresident_government() {
		return r0200_after_nonresident_government;
	}
	public void setR0200_after_nonresident_government(BigDecimal r0200_after_nonresident_government) {
		this.r0200_after_nonresident_government = r0200_after_nonresident_government;
	}
	public String getR0210_product() {
		return r0210_product;
	}
	public void setR0210_product(String r0210_product) {
		this.r0210_product = r0210_product;
	}
	public BigDecimal getR0210_before_resident_individual() {
		return r0210_before_resident_individual;
	}
	public void setR0210_before_resident_individual(BigDecimal r0210_before_resident_individual) {
		this.r0210_before_resident_individual = r0210_before_resident_individual;
	}
	public BigDecimal getR0210_after_resident_individual() {
		return r0210_after_resident_individual;
	}
	public void setR0210_after_resident_individual(BigDecimal r0210_after_resident_individual) {
		this.r0210_after_resident_individual = r0210_after_resident_individual;
	}
	public BigDecimal getR0210_before_nonresident_individual() {
		return r0210_before_nonresident_individual;
	}
	public void setR0210_before_nonresident_individual(BigDecimal r0210_before_nonresident_individual) {
		this.r0210_before_nonresident_individual = r0210_before_nonresident_individual;
	}
	public BigDecimal getR0210_after_nonresident_individual() {
		return r0210_after_nonresident_individual;
	}
	public void setR0210_after_nonresident_individual(BigDecimal r0210_after_nonresident_individual) {
		this.r0210_after_nonresident_individual = r0210_after_nonresident_individual;
	}
	public BigDecimal getR0210_before_resident_retail() {
		return r0210_before_resident_retail;
	}
	public void setR0210_before_resident_retail(BigDecimal r0210_before_resident_retail) {
		this.r0210_before_resident_retail = r0210_before_resident_retail;
	}
	public BigDecimal getR0210_after_resident_retail() {
		return r0210_after_resident_retail;
	}
	public void setR0210_after_resident_retail(BigDecimal r0210_after_resident_retail) {
		this.r0210_after_resident_retail = r0210_after_resident_retail;
	}
	public BigDecimal getR0210_before_nonresident_retail() {
		return r0210_before_nonresident_retail;
	}
	public void setR0210_before_nonresident_retail(BigDecimal r0210_before_nonresident_retail) {
		this.r0210_before_nonresident_retail = r0210_before_nonresident_retail;
	}
	public BigDecimal getR0210_after_nonresident_retail() {
		return r0210_after_nonresident_retail;
	}
	public void setR0210_after_nonresident_retail(BigDecimal r0210_after_nonresident_retail) {
		this.r0210_after_nonresident_retail = r0210_after_nonresident_retail;
	}
	public BigDecimal getR0210_before_resident_sme() {
		return r0210_before_resident_sme;
	}
	public void setR0210_before_resident_sme(BigDecimal r0210_before_resident_sme) {
		this.r0210_before_resident_sme = r0210_before_resident_sme;
	}
	public BigDecimal getR0210_after_resident_sme() {
		return r0210_after_resident_sme;
	}
	public void setR0210_after_resident_sme(BigDecimal r0210_after_resident_sme) {
		this.r0210_after_resident_sme = r0210_after_resident_sme;
	}
	public BigDecimal getR0210_before_nonresident_sme() {
		return r0210_before_nonresident_sme;
	}
	public void setR0210_before_nonresident_sme(BigDecimal r0210_before_nonresident_sme) {
		this.r0210_before_nonresident_sme = r0210_before_nonresident_sme;
	}
	public BigDecimal getR0210_after_nonresident_sme() {
		return r0210_after_nonresident_sme;
	}
	public void setR0210_after_nonresident_sme(BigDecimal r0210_after_nonresident_sme) {
		this.r0210_after_nonresident_sme = r0210_after_nonresident_sme;
	}
	public BigDecimal getR0210_before_resident_hni() {
		return r0210_before_resident_hni;
	}
	public void setR0210_before_resident_hni(BigDecimal r0210_before_resident_hni) {
		this.r0210_before_resident_hni = r0210_before_resident_hni;
	}
	public BigDecimal getR0210_after_resident_hni() {
		return r0210_after_resident_hni;
	}
	public void setR0210_after_resident_hni(BigDecimal r0210_after_resident_hni) {
		this.r0210_after_resident_hni = r0210_after_resident_hni;
	}
	public BigDecimal getR0210_before_nonresident_hni() {
		return r0210_before_nonresident_hni;
	}
	public void setR0210_before_nonresident_hni(BigDecimal r0210_before_nonresident_hni) {
		this.r0210_before_nonresident_hni = r0210_before_nonresident_hni;
	}
	public BigDecimal getR0210_after_nonresident_hni() {
		return r0210_after_nonresident_hni;
	}
	public void setR0210_after_nonresident_hni(BigDecimal r0210_after_nonresident_hni) {
		this.r0210_after_nonresident_hni = r0210_after_nonresident_hni;
	}
	public BigDecimal getR0210_before_resident_gre() {
		return r0210_before_resident_gre;
	}
	public void setR0210_before_resident_gre(BigDecimal r0210_before_resident_gre) {
		this.r0210_before_resident_gre = r0210_before_resident_gre;
	}
	public BigDecimal getR0210_after_resident_gre() {
		return r0210_after_resident_gre;
	}
	public void setR0210_after_resident_gre(BigDecimal r0210_after_resident_gre) {
		this.r0210_after_resident_gre = r0210_after_resident_gre;
	}
	public BigDecimal getR0210_before_nonresident_gre() {
		return r0210_before_nonresident_gre;
	}
	public void setR0210_before_nonresident_gre(BigDecimal r0210_before_nonresident_gre) {
		this.r0210_before_nonresident_gre = r0210_before_nonresident_gre;
	}
	public BigDecimal getR0210_after_nonresident_gre() {
		return r0210_after_nonresident_gre;
	}
	public void setR0210_after_nonresident_gre(BigDecimal r0210_after_nonresident_gre) {
		this.r0210_after_nonresident_gre = r0210_after_nonresident_gre;
	}
	public BigDecimal getR0210_before_resident_corporate() {
		return r0210_before_resident_corporate;
	}
	public void setR0210_before_resident_corporate(BigDecimal r0210_before_resident_corporate) {
		this.r0210_before_resident_corporate = r0210_before_resident_corporate;
	}
	public BigDecimal getR0210_after_resident_corporate() {
		return r0210_after_resident_corporate;
	}
	public void setR0210_after_resident_corporate(BigDecimal r0210_after_resident_corporate) {
		this.r0210_after_resident_corporate = r0210_after_resident_corporate;
	}
	public BigDecimal getR0210_before_nonresident_corporate() {
		return r0210_before_nonresident_corporate;
	}
	public void setR0210_before_nonresident_corporate(BigDecimal r0210_before_nonresident_corporate) {
		this.r0210_before_nonresident_corporate = r0210_before_nonresident_corporate;
	}
	public BigDecimal getR0210_after_nonresident_corporate() {
		return r0210_after_nonresident_corporate;
	}
	public void setR0210_after_nonresident_corporate(BigDecimal r0210_after_nonresident_corporate) {
		this.r0210_after_nonresident_corporate = r0210_after_nonresident_corporate;
	}
	public BigDecimal getR0210_before_resident_nbfi() {
		return r0210_before_resident_nbfi;
	}
	public void setR0210_before_resident_nbfi(BigDecimal r0210_before_resident_nbfi) {
		this.r0210_before_resident_nbfi = r0210_before_resident_nbfi;
	}
	public BigDecimal getR0210_after_resident_nbfi() {
		return r0210_after_resident_nbfi;
	}
	public void setR0210_after_resident_nbfi(BigDecimal r0210_after_resident_nbfi) {
		this.r0210_after_resident_nbfi = r0210_after_resident_nbfi;
	}
	public BigDecimal getR0210_before_nonresident_nbfi() {
		return r0210_before_nonresident_nbfi;
	}
	public void setR0210_before_nonresident_nbfi(BigDecimal r0210_before_nonresident_nbfi) {
		this.r0210_before_nonresident_nbfi = r0210_before_nonresident_nbfi;
	}
	public BigDecimal getR0210_after_nonresident_nbfi() {
		return r0210_after_nonresident_nbfi;
	}
	public void setR0210_after_nonresident_nbfi(BigDecimal r0210_after_nonresident_nbfi) {
		this.r0210_after_nonresident_nbfi = r0210_after_nonresident_nbfi;
	}
	public BigDecimal getR0210_before_resident_bank() {
		return r0210_before_resident_bank;
	}
	public void setR0210_before_resident_bank(BigDecimal r0210_before_resident_bank) {
		this.r0210_before_resident_bank = r0210_before_resident_bank;
	}
	public BigDecimal getR0210_after_resident_bank() {
		return r0210_after_resident_bank;
	}
	public void setR0210_after_resident_bank(BigDecimal r0210_after_resident_bank) {
		this.r0210_after_resident_bank = r0210_after_resident_bank;
	}
	public BigDecimal getR0210_before_nonresident_bank() {
		return r0210_before_nonresident_bank;
	}
	public void setR0210_before_nonresident_bank(BigDecimal r0210_before_nonresident_bank) {
		this.r0210_before_nonresident_bank = r0210_before_nonresident_bank;
	}
	public BigDecimal getR0210_after_nonresident_bank() {
		return r0210_after_nonresident_bank;
	}
	public void setR0210_after_nonresident_bank(BigDecimal r0210_after_nonresident_bank) {
		this.r0210_after_nonresident_bank = r0210_after_nonresident_bank;
	}
	public BigDecimal getR0210_before_resident_government() {
		return r0210_before_resident_government;
	}
	public void setR0210_before_resident_government(BigDecimal r0210_before_resident_government) {
		this.r0210_before_resident_government = r0210_before_resident_government;
	}
	public BigDecimal getR0210_after_resident_government() {
		return r0210_after_resident_government;
	}
	public void setR0210_after_resident_government(BigDecimal r0210_after_resident_government) {
		this.r0210_after_resident_government = r0210_after_resident_government;
	}
	public BigDecimal getR0210_before_nonresident_government() {
		return r0210_before_nonresident_government;
	}
	public void setR0210_before_nonresident_government(BigDecimal r0210_before_nonresident_government) {
		this.r0210_before_nonresident_government = r0210_before_nonresident_government;
	}
	public BigDecimal getR0210_after_nonresident_government() {
		return r0210_after_nonresident_government;
	}
	public void setR0210_after_nonresident_government(BigDecimal r0210_after_nonresident_government) {
		this.r0210_after_nonresident_government = r0210_after_nonresident_government;
	}
	public String getR0220_product() {
		return r0220_product;
	}
	public void setR0220_product(String r0220_product) {
		this.r0220_product = r0220_product;
	}
	public BigDecimal getR0220_before_resident_individual() {
		return r0220_before_resident_individual;
	}
	public void setR0220_before_resident_individual(BigDecimal r0220_before_resident_individual) {
		this.r0220_before_resident_individual = r0220_before_resident_individual;
	}
	public BigDecimal getR0220_after_resident_individual() {
		return r0220_after_resident_individual;
	}
	public void setR0220_after_resident_individual(BigDecimal r0220_after_resident_individual) {
		this.r0220_after_resident_individual = r0220_after_resident_individual;
	}
	public BigDecimal getR0220_before_nonresident_individual() {
		return r0220_before_nonresident_individual;
	}
	public void setR0220_before_nonresident_individual(BigDecimal r0220_before_nonresident_individual) {
		this.r0220_before_nonresident_individual = r0220_before_nonresident_individual;
	}
	public BigDecimal getR0220_after_nonresident_individual() {
		return r0220_after_nonresident_individual;
	}
	public void setR0220_after_nonresident_individual(BigDecimal r0220_after_nonresident_individual) {
		this.r0220_after_nonresident_individual = r0220_after_nonresident_individual;
	}
	public BigDecimal getR0220_before_resident_retail() {
		return r0220_before_resident_retail;
	}
	public void setR0220_before_resident_retail(BigDecimal r0220_before_resident_retail) {
		this.r0220_before_resident_retail = r0220_before_resident_retail;
	}
	public BigDecimal getR0220_after_resident_retail() {
		return r0220_after_resident_retail;
	}
	public void setR0220_after_resident_retail(BigDecimal r0220_after_resident_retail) {
		this.r0220_after_resident_retail = r0220_after_resident_retail;
	}
	public BigDecimal getR0220_before_nonresident_retail() {
		return r0220_before_nonresident_retail;
	}
	public void setR0220_before_nonresident_retail(BigDecimal r0220_before_nonresident_retail) {
		this.r0220_before_nonresident_retail = r0220_before_nonresident_retail;
	}
	public BigDecimal getR0220_after_nonresident_retail() {
		return r0220_after_nonresident_retail;
	}
	public void setR0220_after_nonresident_retail(BigDecimal r0220_after_nonresident_retail) {
		this.r0220_after_nonresident_retail = r0220_after_nonresident_retail;
	}
	public BigDecimal getR0220_before_resident_sme() {
		return r0220_before_resident_sme;
	}
	public void setR0220_before_resident_sme(BigDecimal r0220_before_resident_sme) {
		this.r0220_before_resident_sme = r0220_before_resident_sme;
	}
	public BigDecimal getR0220_after_resident_sme() {
		return r0220_after_resident_sme;
	}
	public void setR0220_after_resident_sme(BigDecimal r0220_after_resident_sme) {
		this.r0220_after_resident_sme = r0220_after_resident_sme;
	}
	public BigDecimal getR0220_before_nonresident_sme() {
		return r0220_before_nonresident_sme;
	}
	public void setR0220_before_nonresident_sme(BigDecimal r0220_before_nonresident_sme) {
		this.r0220_before_nonresident_sme = r0220_before_nonresident_sme;
	}
	public BigDecimal getR0220_after_nonresident_sme() {
		return r0220_after_nonresident_sme;
	}
	public void setR0220_after_nonresident_sme(BigDecimal r0220_after_nonresident_sme) {
		this.r0220_after_nonresident_sme = r0220_after_nonresident_sme;
	}
	public BigDecimal getR0220_before_resident_hni() {
		return r0220_before_resident_hni;
	}
	public void setR0220_before_resident_hni(BigDecimal r0220_before_resident_hni) {
		this.r0220_before_resident_hni = r0220_before_resident_hni;
	}
	public BigDecimal getR0220_after_resident_hni() {
		return r0220_after_resident_hni;
	}
	public void setR0220_after_resident_hni(BigDecimal r0220_after_resident_hni) {
		this.r0220_after_resident_hni = r0220_after_resident_hni;
	}
	public BigDecimal getR0220_before_nonresident_hni() {
		return r0220_before_nonresident_hni;
	}
	public void setR0220_before_nonresident_hni(BigDecimal r0220_before_nonresident_hni) {
		this.r0220_before_nonresident_hni = r0220_before_nonresident_hni;
	}
	public BigDecimal getR0220_after_nonresident_hni() {
		return r0220_after_nonresident_hni;
	}
	public void setR0220_after_nonresident_hni(BigDecimal r0220_after_nonresident_hni) {
		this.r0220_after_nonresident_hni = r0220_after_nonresident_hni;
	}
	public BigDecimal getR0220_before_resident_gre() {
		return r0220_before_resident_gre;
	}
	public void setR0220_before_resident_gre(BigDecimal r0220_before_resident_gre) {
		this.r0220_before_resident_gre = r0220_before_resident_gre;
	}
	public BigDecimal getR0220_after_resident_gre() {
		return r0220_after_resident_gre;
	}
	public void setR0220_after_resident_gre(BigDecimal r0220_after_resident_gre) {
		this.r0220_after_resident_gre = r0220_after_resident_gre;
	}
	public BigDecimal getR0220_before_nonresident_gre() {
		return r0220_before_nonresident_gre;
	}
	public void setR0220_before_nonresident_gre(BigDecimal r0220_before_nonresident_gre) {
		this.r0220_before_nonresident_gre = r0220_before_nonresident_gre;
	}
	public BigDecimal getR0220_after_nonresident_gre() {
		return r0220_after_nonresident_gre;
	}
	public void setR0220_after_nonresident_gre(BigDecimal r0220_after_nonresident_gre) {
		this.r0220_after_nonresident_gre = r0220_after_nonresident_gre;
	}
	public BigDecimal getR0220_before_resident_corporate() {
		return r0220_before_resident_corporate;
	}
	public void setR0220_before_resident_corporate(BigDecimal r0220_before_resident_corporate) {
		this.r0220_before_resident_corporate = r0220_before_resident_corporate;
	}
	public BigDecimal getR0220_after_resident_corporate() {
		return r0220_after_resident_corporate;
	}
	public void setR0220_after_resident_corporate(BigDecimal r0220_after_resident_corporate) {
		this.r0220_after_resident_corporate = r0220_after_resident_corporate;
	}
	public BigDecimal getR0220_before_nonresident_corporate() {
		return r0220_before_nonresident_corporate;
	}
	public void setR0220_before_nonresident_corporate(BigDecimal r0220_before_nonresident_corporate) {
		this.r0220_before_nonresident_corporate = r0220_before_nonresident_corporate;
	}
	public BigDecimal getR0220_after_nonresident_corporate() {
		return r0220_after_nonresident_corporate;
	}
	public void setR0220_after_nonresident_corporate(BigDecimal r0220_after_nonresident_corporate) {
		this.r0220_after_nonresident_corporate = r0220_after_nonresident_corporate;
	}
	public BigDecimal getR0220_before_resident_nbfi() {
		return r0220_before_resident_nbfi;
	}
	public void setR0220_before_resident_nbfi(BigDecimal r0220_before_resident_nbfi) {
		this.r0220_before_resident_nbfi = r0220_before_resident_nbfi;
	}
	public BigDecimal getR0220_after_resident_nbfi() {
		return r0220_after_resident_nbfi;
	}
	public void setR0220_after_resident_nbfi(BigDecimal r0220_after_resident_nbfi) {
		this.r0220_after_resident_nbfi = r0220_after_resident_nbfi;
	}
	public BigDecimal getR0220_before_nonresident_nbfi() {
		return r0220_before_nonresident_nbfi;
	}
	public void setR0220_before_nonresident_nbfi(BigDecimal r0220_before_nonresident_nbfi) {
		this.r0220_before_nonresident_nbfi = r0220_before_nonresident_nbfi;
	}
	public BigDecimal getR0220_after_nonresident_nbfi() {
		return r0220_after_nonresident_nbfi;
	}
	public void setR0220_after_nonresident_nbfi(BigDecimal r0220_after_nonresident_nbfi) {
		this.r0220_after_nonresident_nbfi = r0220_after_nonresident_nbfi;
	}
	public BigDecimal getR0220_before_resident_bank() {
		return r0220_before_resident_bank;
	}
	public void setR0220_before_resident_bank(BigDecimal r0220_before_resident_bank) {
		this.r0220_before_resident_bank = r0220_before_resident_bank;
	}
	public BigDecimal getR0220_after_resident_bank() {
		return r0220_after_resident_bank;
	}
	public void setR0220_after_resident_bank(BigDecimal r0220_after_resident_bank) {
		this.r0220_after_resident_bank = r0220_after_resident_bank;
	}
	public BigDecimal getR0220_before_nonresident_bank() {
		return r0220_before_nonresident_bank;
	}
	public void setR0220_before_nonresident_bank(BigDecimal r0220_before_nonresident_bank) {
		this.r0220_before_nonresident_bank = r0220_before_nonresident_bank;
	}
	public BigDecimal getR0220_after_nonresident_bank() {
		return r0220_after_nonresident_bank;
	}
	public void setR0220_after_nonresident_bank(BigDecimal r0220_after_nonresident_bank) {
		this.r0220_after_nonresident_bank = r0220_after_nonresident_bank;
	}
	public BigDecimal getR0220_before_resident_government() {
		return r0220_before_resident_government;
	}
	public void setR0220_before_resident_government(BigDecimal r0220_before_resident_government) {
		this.r0220_before_resident_government = r0220_before_resident_government;
	}
	public BigDecimal getR0220_after_resident_government() {
		return r0220_after_resident_government;
	}
	public void setR0220_after_resident_government(BigDecimal r0220_after_resident_government) {
		this.r0220_after_resident_government = r0220_after_resident_government;
	}
	public BigDecimal getR0220_before_nonresident_government() {
		return r0220_before_nonresident_government;
	}
	public void setR0220_before_nonresident_government(BigDecimal r0220_before_nonresident_government) {
		this.r0220_before_nonresident_government = r0220_before_nonresident_government;
	}
	public BigDecimal getR0220_after_nonresident_government() {
		return r0220_after_nonresident_government;
	}
	public void setR0220_after_nonresident_government(BigDecimal r0220_after_nonresident_government) {
		this.r0220_after_nonresident_government = r0220_after_nonresident_government;
	}
	public String getR0230_product() {
		return r0230_product;
	}
	public void setR0230_product(String r0230_product) {
		this.r0230_product = r0230_product;
	}
	public BigDecimal getR0230_before_resident_individual() {
		return r0230_before_resident_individual;
	}
	public void setR0230_before_resident_individual(BigDecimal r0230_before_resident_individual) {
		this.r0230_before_resident_individual = r0230_before_resident_individual;
	}
	public BigDecimal getR0230_after_resident_individual() {
		return r0230_after_resident_individual;
	}
	public void setR0230_after_resident_individual(BigDecimal r0230_after_resident_individual) {
		this.r0230_after_resident_individual = r0230_after_resident_individual;
	}
	public BigDecimal getR0230_before_nonresident_individual() {
		return r0230_before_nonresident_individual;
	}
	public void setR0230_before_nonresident_individual(BigDecimal r0230_before_nonresident_individual) {
		this.r0230_before_nonresident_individual = r0230_before_nonresident_individual;
	}
	public BigDecimal getR0230_after_nonresident_individual() {
		return r0230_after_nonresident_individual;
	}
	public void setR0230_after_nonresident_individual(BigDecimal r0230_after_nonresident_individual) {
		this.r0230_after_nonresident_individual = r0230_after_nonresident_individual;
	}
	public BigDecimal getR0230_before_resident_retail() {
		return r0230_before_resident_retail;
	}
	public void setR0230_before_resident_retail(BigDecimal r0230_before_resident_retail) {
		this.r0230_before_resident_retail = r0230_before_resident_retail;
	}
	public BigDecimal getR0230_after_resident_retail() {
		return r0230_after_resident_retail;
	}
	public void setR0230_after_resident_retail(BigDecimal r0230_after_resident_retail) {
		this.r0230_after_resident_retail = r0230_after_resident_retail;
	}
	public BigDecimal getR0230_before_nonresident_retail() {
		return r0230_before_nonresident_retail;
	}
	public void setR0230_before_nonresident_retail(BigDecimal r0230_before_nonresident_retail) {
		this.r0230_before_nonresident_retail = r0230_before_nonresident_retail;
	}
	public BigDecimal getR0230_after_nonresident_retail() {
		return r0230_after_nonresident_retail;
	}
	public void setR0230_after_nonresident_retail(BigDecimal r0230_after_nonresident_retail) {
		this.r0230_after_nonresident_retail = r0230_after_nonresident_retail;
	}
	public BigDecimal getR0230_before_resident_sme() {
		return r0230_before_resident_sme;
	}
	public void setR0230_before_resident_sme(BigDecimal r0230_before_resident_sme) {
		this.r0230_before_resident_sme = r0230_before_resident_sme;
	}
	public BigDecimal getR0230_after_resident_sme() {
		return r0230_after_resident_sme;
	}
	public void setR0230_after_resident_sme(BigDecimal r0230_after_resident_sme) {
		this.r0230_after_resident_sme = r0230_after_resident_sme;
	}
	public BigDecimal getR0230_before_nonresident_sme() {
		return r0230_before_nonresident_sme;
	}
	public void setR0230_before_nonresident_sme(BigDecimal r0230_before_nonresident_sme) {
		this.r0230_before_nonresident_sme = r0230_before_nonresident_sme;
	}
	public BigDecimal getR0230_after_nonresident_sme() {
		return r0230_after_nonresident_sme;
	}
	public void setR0230_after_nonresident_sme(BigDecimal r0230_after_nonresident_sme) {
		this.r0230_after_nonresident_sme = r0230_after_nonresident_sme;
	}
	public BigDecimal getR0230_before_resident_hni() {
		return r0230_before_resident_hni;
	}
	public void setR0230_before_resident_hni(BigDecimal r0230_before_resident_hni) {
		this.r0230_before_resident_hni = r0230_before_resident_hni;
	}
	public BigDecimal getR0230_after_resident_hni() {
		return r0230_after_resident_hni;
	}
	public void setR0230_after_resident_hni(BigDecimal r0230_after_resident_hni) {
		this.r0230_after_resident_hni = r0230_after_resident_hni;
	}
	public BigDecimal getR0230_before_nonresident_hni() {
		return r0230_before_nonresident_hni;
	}
	public void setR0230_before_nonresident_hni(BigDecimal r0230_before_nonresident_hni) {
		this.r0230_before_nonresident_hni = r0230_before_nonresident_hni;
	}
	public BigDecimal getR0230_after_nonresident_hni() {
		return r0230_after_nonresident_hni;
	}
	public void setR0230_after_nonresident_hni(BigDecimal r0230_after_nonresident_hni) {
		this.r0230_after_nonresident_hni = r0230_after_nonresident_hni;
	}
	public BigDecimal getR0230_before_resident_gre() {
		return r0230_before_resident_gre;
	}
	public void setR0230_before_resident_gre(BigDecimal r0230_before_resident_gre) {
		this.r0230_before_resident_gre = r0230_before_resident_gre;
	}
	public BigDecimal getR0230_after_resident_gre() {
		return r0230_after_resident_gre;
	}
	public void setR0230_after_resident_gre(BigDecimal r0230_after_resident_gre) {
		this.r0230_after_resident_gre = r0230_after_resident_gre;
	}
	public BigDecimal getR0230_before_nonresident_gre() {
		return r0230_before_nonresident_gre;
	}
	public void setR0230_before_nonresident_gre(BigDecimal r0230_before_nonresident_gre) {
		this.r0230_before_nonresident_gre = r0230_before_nonresident_gre;
	}
	public BigDecimal getR0230_after_nonresident_gre() {
		return r0230_after_nonresident_gre;
	}
	public void setR0230_after_nonresident_gre(BigDecimal r0230_after_nonresident_gre) {
		this.r0230_after_nonresident_gre = r0230_after_nonresident_gre;
	}
	public BigDecimal getR0230_before_resident_corporate() {
		return r0230_before_resident_corporate;
	}
	public void setR0230_before_resident_corporate(BigDecimal r0230_before_resident_corporate) {
		this.r0230_before_resident_corporate = r0230_before_resident_corporate;
	}
	public BigDecimal getR0230_after_resident_corporate() {
		return r0230_after_resident_corporate;
	}
	public void setR0230_after_resident_corporate(BigDecimal r0230_after_resident_corporate) {
		this.r0230_after_resident_corporate = r0230_after_resident_corporate;
	}
	public BigDecimal getR0230_before_nonresident_corporate() {
		return r0230_before_nonresident_corporate;
	}
	public void setR0230_before_nonresident_corporate(BigDecimal r0230_before_nonresident_corporate) {
		this.r0230_before_nonresident_corporate = r0230_before_nonresident_corporate;
	}
	public BigDecimal getR0230_after_nonresident_corporate() {
		return r0230_after_nonresident_corporate;
	}
	public void setR0230_after_nonresident_corporate(BigDecimal r0230_after_nonresident_corporate) {
		this.r0230_after_nonresident_corporate = r0230_after_nonresident_corporate;
	}
	public BigDecimal getR0230_before_resident_nbfi() {
		return r0230_before_resident_nbfi;
	}
	public void setR0230_before_resident_nbfi(BigDecimal r0230_before_resident_nbfi) {
		this.r0230_before_resident_nbfi = r0230_before_resident_nbfi;
	}
	public BigDecimal getR0230_after_resident_nbfi() {
		return r0230_after_resident_nbfi;
	}
	public void setR0230_after_resident_nbfi(BigDecimal r0230_after_resident_nbfi) {
		this.r0230_after_resident_nbfi = r0230_after_resident_nbfi;
	}
	public BigDecimal getR0230_before_nonresident_nbfi() {
		return r0230_before_nonresident_nbfi;
	}
	public void setR0230_before_nonresident_nbfi(BigDecimal r0230_before_nonresident_nbfi) {
		this.r0230_before_nonresident_nbfi = r0230_before_nonresident_nbfi;
	}
	public BigDecimal getR0230_after_nonresident_nbfi() {
		return r0230_after_nonresident_nbfi;
	}
	public void setR0230_after_nonresident_nbfi(BigDecimal r0230_after_nonresident_nbfi) {
		this.r0230_after_nonresident_nbfi = r0230_after_nonresident_nbfi;
	}
	public BigDecimal getR0230_before_resident_bank() {
		return r0230_before_resident_bank;
	}
	public void setR0230_before_resident_bank(BigDecimal r0230_before_resident_bank) {
		this.r0230_before_resident_bank = r0230_before_resident_bank;
	}
	public BigDecimal getR0230_after_resident_bank() {
		return r0230_after_resident_bank;
	}
	public void setR0230_after_resident_bank(BigDecimal r0230_after_resident_bank) {
		this.r0230_after_resident_bank = r0230_after_resident_bank;
	}
	public BigDecimal getR0230_before_nonresident_bank() {
		return r0230_before_nonresident_bank;
	}
	public void setR0230_before_nonresident_bank(BigDecimal r0230_before_nonresident_bank) {
		this.r0230_before_nonresident_bank = r0230_before_nonresident_bank;
	}
	public BigDecimal getR0230_after_nonresident_bank() {
		return r0230_after_nonresident_bank;
	}
	public void setR0230_after_nonresident_bank(BigDecimal r0230_after_nonresident_bank) {
		this.r0230_after_nonresident_bank = r0230_after_nonresident_bank;
	}
	public BigDecimal getR0230_before_resident_government() {
		return r0230_before_resident_government;
	}
	public void setR0230_before_resident_government(BigDecimal r0230_before_resident_government) {
		this.r0230_before_resident_government = r0230_before_resident_government;
	}
	public BigDecimal getR0230_after_resident_government() {
		return r0230_after_resident_government;
	}
	public void setR0230_after_resident_government(BigDecimal r0230_after_resident_government) {
		this.r0230_after_resident_government = r0230_after_resident_government;
	}
	public BigDecimal getR0230_before_nonresident_government() {
		return r0230_before_nonresident_government;
	}
	public void setR0230_before_nonresident_government(BigDecimal r0230_before_nonresident_government) {
		this.r0230_before_nonresident_government = r0230_before_nonresident_government;
	}
	public BigDecimal getR0230_after_nonresident_government() {
		return r0230_after_nonresident_government;
	}
	public void setR0230_after_nonresident_government(BigDecimal r0230_after_nonresident_government) {
		this.r0230_after_nonresident_government = r0230_after_nonresident_government;
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
	public CBUAE_BRF5_17_SUMMARY_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
