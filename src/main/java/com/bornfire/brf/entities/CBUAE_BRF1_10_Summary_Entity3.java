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
@Table(name = "CBUAE_BRF1_10_SUMMARYTABLE3")

public class CBUAE_BRF1_10_Summary_Entity3 {
	
	private String	r1020_product;
	private String	r1030_product;
	private BigDecimal	r1030_stage1_for_loans_advan;
	private BigDecimal	r1030_stage1_for_investments;
	private BigDecimal	r1030_stage1_for_all_oth_assets;
	private BigDecimal	r1030_stage2_for_loans_advan;
	private BigDecimal	r1030_stage2_for_investments;
	private BigDecimal	r1030_stage2_for_all_oth_assets;
	private BigDecimal	r1030_stage3_for_loans_advan;
	private BigDecimal	r1030_stage3_for_investments;
	private BigDecimal	r1030_stage3_for_all_oth_assets;
	private BigDecimal	r1030_legacy_interest_suspense;
	private BigDecimal	r1030_prov_inte_fee_due_mt90_days;
	private BigDecimal	r1030_total;
	private String	r1040_product;
	private BigDecimal	r1040_stage1_for_loans_advan;
	private BigDecimal	r1040_stage1_for_investments;
	private BigDecimal	r1040_stage1_for_all_oth_assets;
	private BigDecimal	r1040_stage2_for_loans_advan;
	private BigDecimal	r1040_stage2_for_investments;
	private BigDecimal	r1040_stage2_for_all_oth_assets;
	private BigDecimal	r1040_stage3_for_loans_advan;
	private BigDecimal	r1040_stage3_for_investments;
	private BigDecimal	r1040_stage3_for_all_oth_assets;
	private BigDecimal	r1040_legacy_interest_suspense;
	private BigDecimal	r1040_prov_inte_fee_due_mt90_days;
	private BigDecimal	r1040_total;
	private String	r1050_product;
	private BigDecimal	r1050_stage1_for_loans_advan;
	private BigDecimal	r1050_stage1_for_investments;
	private BigDecimal	r1050_stage1_for_all_oth_assets;
	private BigDecimal	r1050_stage2_for_loans_advan;
	private BigDecimal	r1050_stage2_for_investments;
	private BigDecimal	r1050_stage2_for_all_oth_assets;
	private BigDecimal	r1050_stage3_for_loans_advan;
	private BigDecimal	r1050_stage3_for_investments;
	private BigDecimal	r1050_stage3_for_all_oth_assets;
	private BigDecimal	r1050_legacy_interest_suspense;
	private BigDecimal	r1050_prov_inte_fee_due_mt90_days;
	private BigDecimal	r1050_total;
	private String	r1060_product;
	private BigDecimal	r1060_stage1_for_loans_advan;
	private BigDecimal	r1060_stage1_for_investments;
	private BigDecimal	r1060_stage1_for_all_oth_assets;
	private BigDecimal	r1060_stage2_for_loans_advan;
	private BigDecimal	r1060_stage2_for_investments;
	private BigDecimal	r1060_stage2_for_all_oth_assets;
	private BigDecimal	r1060_stage3_for_loans_advan;
	private BigDecimal	r1060_stage3_for_investments;
	private BigDecimal	r1060_stage3_for_all_oth_assets;
	private BigDecimal	r1060_legacy_interest_suspense;
	private BigDecimal	r1060_prov_inte_fee_due_mt90_days;
	private BigDecimal	r1060_total;
	private String	r1070_product;
	private BigDecimal	r1070_stage1_for_loans_advan;
	private BigDecimal	r1070_stage1_for_investments;
	private BigDecimal	r1070_stage1_for_all_oth_assets;
	private BigDecimal	r1070_stage2_for_loans_advan;
	private BigDecimal	r1070_stage2_for_investments;
	private BigDecimal	r1070_stage2_for_all_oth_assets;
	private BigDecimal	r1070_stage3_for_loans_advan;
	private BigDecimal	r1070_stage3_for_investments;
	private BigDecimal	r1070_stage3_for_all_oth_assets;
	private BigDecimal	r1070_legacy_interest_suspense;
	private BigDecimal	r1070_prov_inte_fee_due_mt90_days;
	private BigDecimal	r1070_total;
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
	public String getR1020_product() {
		return r1020_product;
	}
	public void setR1020_product(String r1020_product) {
		this.r1020_product = r1020_product;
	}
	public String getR1030_product() {
		return r1030_product;
	}
	public void setR1030_product(String r1030_product) {
		this.r1030_product = r1030_product;
	}
	public BigDecimal getR1030_stage1_for_loans_advan() {
		return r1030_stage1_for_loans_advan;
	}
	public void setR1030_stage1_for_loans_advan(BigDecimal r1030_stage1_for_loans_advan) {
		this.r1030_stage1_for_loans_advan = r1030_stage1_for_loans_advan;
	}
	public BigDecimal getR1030_stage1_for_investments() {
		return r1030_stage1_for_investments;
	}
	public void setR1030_stage1_for_investments(BigDecimal r1030_stage1_for_investments) {
		this.r1030_stage1_for_investments = r1030_stage1_for_investments;
	}
	public BigDecimal getR1030_stage1_for_all_oth_assets() {
		return r1030_stage1_for_all_oth_assets;
	}
	public void setR1030_stage1_for_all_oth_assets(BigDecimal r1030_stage1_for_all_oth_assets) {
		this.r1030_stage1_for_all_oth_assets = r1030_stage1_for_all_oth_assets;
	}
	public BigDecimal getR1030_stage2_for_loans_advan() {
		return r1030_stage2_for_loans_advan;
	}
	public void setR1030_stage2_for_loans_advan(BigDecimal r1030_stage2_for_loans_advan) {
		this.r1030_stage2_for_loans_advan = r1030_stage2_for_loans_advan;
	}
	public BigDecimal getR1030_stage2_for_investments() {
		return r1030_stage2_for_investments;
	}
	public void setR1030_stage2_for_investments(BigDecimal r1030_stage2_for_investments) {
		this.r1030_stage2_for_investments = r1030_stage2_for_investments;
	}
	public BigDecimal getR1030_stage2_for_all_oth_assets() {
		return r1030_stage2_for_all_oth_assets;
	}
	public void setR1030_stage2_for_all_oth_assets(BigDecimal r1030_stage2_for_all_oth_assets) {
		this.r1030_stage2_for_all_oth_assets = r1030_stage2_for_all_oth_assets;
	}
	public BigDecimal getR1030_stage3_for_loans_advan() {
		return r1030_stage3_for_loans_advan;
	}
	public void setR1030_stage3_for_loans_advan(BigDecimal r1030_stage3_for_loans_advan) {
		this.r1030_stage3_for_loans_advan = r1030_stage3_for_loans_advan;
	}
	public BigDecimal getR1030_stage3_for_investments() {
		return r1030_stage3_for_investments;
	}
	public void setR1030_stage3_for_investments(BigDecimal r1030_stage3_for_investments) {
		this.r1030_stage3_for_investments = r1030_stage3_for_investments;
	}
	public BigDecimal getR1030_stage3_for_all_oth_assets() {
		return r1030_stage3_for_all_oth_assets;
	}
	public void setR1030_stage3_for_all_oth_assets(BigDecimal r1030_stage3_for_all_oth_assets) {
		this.r1030_stage3_for_all_oth_assets = r1030_stage3_for_all_oth_assets;
	}
	public BigDecimal getR1030_legacy_interest_suspense() {
		return r1030_legacy_interest_suspense;
	}
	public void setR1030_legacy_interest_suspense(BigDecimal r1030_legacy_interest_suspense) {
		this.r1030_legacy_interest_suspense = r1030_legacy_interest_suspense;
	}
	public BigDecimal getR1030_prov_inte_fee_due_mt90_days() {
		return r1030_prov_inte_fee_due_mt90_days;
	}
	public void setR1030_prov_inte_fee_due_mt90_days(BigDecimal r1030_prov_inte_fee_due_mt90_days) {
		this.r1030_prov_inte_fee_due_mt90_days = r1030_prov_inte_fee_due_mt90_days;
	}
	public BigDecimal getR1030_total() {
		return r1030_total;
	}
	public void setR1030_total(BigDecimal r1030_total) {
		this.r1030_total = r1030_total;
	}
	public String getR1040_product() {
		return r1040_product;
	}
	public void setR1040_product(String r1040_product) {
		this.r1040_product = r1040_product;
	}
	public BigDecimal getR1040_stage1_for_loans_advan() {
		return r1040_stage1_for_loans_advan;
	}
	public void setR1040_stage1_for_loans_advan(BigDecimal r1040_stage1_for_loans_advan) {
		this.r1040_stage1_for_loans_advan = r1040_stage1_for_loans_advan;
	}
	public BigDecimal getR1040_stage1_for_investments() {
		return r1040_stage1_for_investments;
	}
	public void setR1040_stage1_for_investments(BigDecimal r1040_stage1_for_investments) {
		this.r1040_stage1_for_investments = r1040_stage1_for_investments;
	}
	public BigDecimal getR1040_stage1_for_all_oth_assets() {
		return r1040_stage1_for_all_oth_assets;
	}
	public void setR1040_stage1_for_all_oth_assets(BigDecimal r1040_stage1_for_all_oth_assets) {
		this.r1040_stage1_for_all_oth_assets = r1040_stage1_for_all_oth_assets;
	}
	public BigDecimal getR1040_stage2_for_loans_advan() {
		return r1040_stage2_for_loans_advan;
	}
	public void setR1040_stage2_for_loans_advan(BigDecimal r1040_stage2_for_loans_advan) {
		this.r1040_stage2_for_loans_advan = r1040_stage2_for_loans_advan;
	}
	public BigDecimal getR1040_stage2_for_investments() {
		return r1040_stage2_for_investments;
	}
	public void setR1040_stage2_for_investments(BigDecimal r1040_stage2_for_investments) {
		this.r1040_stage2_for_investments = r1040_stage2_for_investments;
	}
	public BigDecimal getR1040_stage2_for_all_oth_assets() {
		return r1040_stage2_for_all_oth_assets;
	}
	public void setR1040_stage2_for_all_oth_assets(BigDecimal r1040_stage2_for_all_oth_assets) {
		this.r1040_stage2_for_all_oth_assets = r1040_stage2_for_all_oth_assets;
	}
	public BigDecimal getR1040_stage3_for_loans_advan() {
		return r1040_stage3_for_loans_advan;
	}
	public void setR1040_stage3_for_loans_advan(BigDecimal r1040_stage3_for_loans_advan) {
		this.r1040_stage3_for_loans_advan = r1040_stage3_for_loans_advan;
	}
	public BigDecimal getR1040_stage3_for_investments() {
		return r1040_stage3_for_investments;
	}
	public void setR1040_stage3_for_investments(BigDecimal r1040_stage3_for_investments) {
		this.r1040_stage3_for_investments = r1040_stage3_for_investments;
	}
	public BigDecimal getR1040_stage3_for_all_oth_assets() {
		return r1040_stage3_for_all_oth_assets;
	}
	public void setR1040_stage3_for_all_oth_assets(BigDecimal r1040_stage3_for_all_oth_assets) {
		this.r1040_stage3_for_all_oth_assets = r1040_stage3_for_all_oth_assets;
	}
	public BigDecimal getR1040_legacy_interest_suspense() {
		return r1040_legacy_interest_suspense;
	}
	public void setR1040_legacy_interest_suspense(BigDecimal r1040_legacy_interest_suspense) {
		this.r1040_legacy_interest_suspense = r1040_legacy_interest_suspense;
	}
	public BigDecimal getR1040_prov_inte_fee_due_mt90_days() {
		return r1040_prov_inte_fee_due_mt90_days;
	}
	public void setR1040_prov_inte_fee_due_mt90_days(BigDecimal r1040_prov_inte_fee_due_mt90_days) {
		this.r1040_prov_inte_fee_due_mt90_days = r1040_prov_inte_fee_due_mt90_days;
	}
	public BigDecimal getR1040_total() {
		return r1040_total;
	}
	public void setR1040_total(BigDecimal r1040_total) {
		this.r1040_total = r1040_total;
	}
	public String getR1050_product() {
		return r1050_product;
	}
	public void setR1050_product(String r1050_product) {
		this.r1050_product = r1050_product;
	}
	public BigDecimal getR1050_stage1_for_loans_advan() {
		return r1050_stage1_for_loans_advan;
	}
	public void setR1050_stage1_for_loans_advan(BigDecimal r1050_stage1_for_loans_advan) {
		this.r1050_stage1_for_loans_advan = r1050_stage1_for_loans_advan;
	}
	public BigDecimal getR1050_stage1_for_investments() {
		return r1050_stage1_for_investments;
	}
	public void setR1050_stage1_for_investments(BigDecimal r1050_stage1_for_investments) {
		this.r1050_stage1_for_investments = r1050_stage1_for_investments;
	}
	public BigDecimal getR1050_stage1_for_all_oth_assets() {
		return r1050_stage1_for_all_oth_assets;
	}
	public void setR1050_stage1_for_all_oth_assets(BigDecimal r1050_stage1_for_all_oth_assets) {
		this.r1050_stage1_for_all_oth_assets = r1050_stage1_for_all_oth_assets;
	}
	public BigDecimal getR1050_stage2_for_loans_advan() {
		return r1050_stage2_for_loans_advan;
	}
	public void setR1050_stage2_for_loans_advan(BigDecimal r1050_stage2_for_loans_advan) {
		this.r1050_stage2_for_loans_advan = r1050_stage2_for_loans_advan;
	}
	public BigDecimal getR1050_stage2_for_investments() {
		return r1050_stage2_for_investments;
	}
	public void setR1050_stage2_for_investments(BigDecimal r1050_stage2_for_investments) {
		this.r1050_stage2_for_investments = r1050_stage2_for_investments;
	}
	public BigDecimal getR1050_stage2_for_all_oth_assets() {
		return r1050_stage2_for_all_oth_assets;
	}
	public void setR1050_stage2_for_all_oth_assets(BigDecimal r1050_stage2_for_all_oth_assets) {
		this.r1050_stage2_for_all_oth_assets = r1050_stage2_for_all_oth_assets;
	}
	public BigDecimal getR1050_stage3_for_loans_advan() {
		return r1050_stage3_for_loans_advan;
	}
	public void setR1050_stage3_for_loans_advan(BigDecimal r1050_stage3_for_loans_advan) {
		this.r1050_stage3_for_loans_advan = r1050_stage3_for_loans_advan;
	}
	public BigDecimal getR1050_stage3_for_investments() {
		return r1050_stage3_for_investments;
	}
	public void setR1050_stage3_for_investments(BigDecimal r1050_stage3_for_investments) {
		this.r1050_stage3_for_investments = r1050_stage3_for_investments;
	}
	public BigDecimal getR1050_stage3_for_all_oth_assets() {
		return r1050_stage3_for_all_oth_assets;
	}
	public void setR1050_stage3_for_all_oth_assets(BigDecimal r1050_stage3_for_all_oth_assets) {
		this.r1050_stage3_for_all_oth_assets = r1050_stage3_for_all_oth_assets;
	}
	public BigDecimal getR1050_legacy_interest_suspense() {
		return r1050_legacy_interest_suspense;
	}
	public void setR1050_legacy_interest_suspense(BigDecimal r1050_legacy_interest_suspense) {
		this.r1050_legacy_interest_suspense = r1050_legacy_interest_suspense;
	}
	public BigDecimal getR1050_prov_inte_fee_due_mt90_days() {
		return r1050_prov_inte_fee_due_mt90_days;
	}
	public void setR1050_prov_inte_fee_due_mt90_days(BigDecimal r1050_prov_inte_fee_due_mt90_days) {
		this.r1050_prov_inte_fee_due_mt90_days = r1050_prov_inte_fee_due_mt90_days;
	}
	public BigDecimal getR1050_total() {
		return r1050_total;
	}
	public void setR1050_total(BigDecimal r1050_total) {
		this.r1050_total = r1050_total;
	}
	public String getR1060_product() {
		return r1060_product;
	}
	public void setR1060_product(String r1060_product) {
		this.r1060_product = r1060_product;
	}
	public BigDecimal getR1060_stage1_for_loans_advan() {
		return r1060_stage1_for_loans_advan;
	}
	public void setR1060_stage1_for_loans_advan(BigDecimal r1060_stage1_for_loans_advan) {
		this.r1060_stage1_for_loans_advan = r1060_stage1_for_loans_advan;
	}
	public BigDecimal getR1060_stage1_for_investments() {
		return r1060_stage1_for_investments;
	}
	public void setR1060_stage1_for_investments(BigDecimal r1060_stage1_for_investments) {
		this.r1060_stage1_for_investments = r1060_stage1_for_investments;
	}
	public BigDecimal getR1060_stage1_for_all_oth_assets() {
		return r1060_stage1_for_all_oth_assets;
	}
	public void setR1060_stage1_for_all_oth_assets(BigDecimal r1060_stage1_for_all_oth_assets) {
		this.r1060_stage1_for_all_oth_assets = r1060_stage1_for_all_oth_assets;
	}
	public BigDecimal getR1060_stage2_for_loans_advan() {
		return r1060_stage2_for_loans_advan;
	}
	public void setR1060_stage2_for_loans_advan(BigDecimal r1060_stage2_for_loans_advan) {
		this.r1060_stage2_for_loans_advan = r1060_stage2_for_loans_advan;
	}
	public BigDecimal getR1060_stage2_for_investments() {
		return r1060_stage2_for_investments;
	}
	public void setR1060_stage2_for_investments(BigDecimal r1060_stage2_for_investments) {
		this.r1060_stage2_for_investments = r1060_stage2_for_investments;
	}
	public BigDecimal getR1060_stage2_for_all_oth_assets() {
		return r1060_stage2_for_all_oth_assets;
	}
	public void setR1060_stage2_for_all_oth_assets(BigDecimal r1060_stage2_for_all_oth_assets) {
		this.r1060_stage2_for_all_oth_assets = r1060_stage2_for_all_oth_assets;
	}
	public BigDecimal getR1060_stage3_for_loans_advan() {
		return r1060_stage3_for_loans_advan;
	}
	public void setR1060_stage3_for_loans_advan(BigDecimal r1060_stage3_for_loans_advan) {
		this.r1060_stage3_for_loans_advan = r1060_stage3_for_loans_advan;
	}
	public BigDecimal getR1060_stage3_for_investments() {
		return r1060_stage3_for_investments;
	}
	public void setR1060_stage3_for_investments(BigDecimal r1060_stage3_for_investments) {
		this.r1060_stage3_for_investments = r1060_stage3_for_investments;
	}
	public BigDecimal getR1060_stage3_for_all_oth_assets() {
		return r1060_stage3_for_all_oth_assets;
	}
	public void setR1060_stage3_for_all_oth_assets(BigDecimal r1060_stage3_for_all_oth_assets) {
		this.r1060_stage3_for_all_oth_assets = r1060_stage3_for_all_oth_assets;
	}
	public BigDecimal getR1060_legacy_interest_suspense() {
		return r1060_legacy_interest_suspense;
	}
	public void setR1060_legacy_interest_suspense(BigDecimal r1060_legacy_interest_suspense) {
		this.r1060_legacy_interest_suspense = r1060_legacy_interest_suspense;
	}
	public BigDecimal getR1060_prov_inte_fee_due_mt90_days() {
		return r1060_prov_inte_fee_due_mt90_days;
	}
	public void setR1060_prov_inte_fee_due_mt90_days(BigDecimal r1060_prov_inte_fee_due_mt90_days) {
		this.r1060_prov_inte_fee_due_mt90_days = r1060_prov_inte_fee_due_mt90_days;
	}
	public BigDecimal getR1060_total() {
		return r1060_total;
	}
	public void setR1060_total(BigDecimal r1060_total) {
		this.r1060_total = r1060_total;
	}
	public String getR1070_product() {
		return r1070_product;
	}
	public void setR1070_product(String r1070_product) {
		this.r1070_product = r1070_product;
	}
	public BigDecimal getR1070_stage1_for_loans_advan() {
		return r1070_stage1_for_loans_advan;
	}
	public void setR1070_stage1_for_loans_advan(BigDecimal r1070_stage1_for_loans_advan) {
		this.r1070_stage1_for_loans_advan = r1070_stage1_for_loans_advan;
	}
	public BigDecimal getR1070_stage1_for_investments() {
		return r1070_stage1_for_investments;
	}
	public void setR1070_stage1_for_investments(BigDecimal r1070_stage1_for_investments) {
		this.r1070_stage1_for_investments = r1070_stage1_for_investments;
	}
	public BigDecimal getR1070_stage1_for_all_oth_assets() {
		return r1070_stage1_for_all_oth_assets;
	}
	public void setR1070_stage1_for_all_oth_assets(BigDecimal r1070_stage1_for_all_oth_assets) {
		this.r1070_stage1_for_all_oth_assets = r1070_stage1_for_all_oth_assets;
	}
	public BigDecimal getR1070_stage2_for_loans_advan() {
		return r1070_stage2_for_loans_advan;
	}
	public void setR1070_stage2_for_loans_advan(BigDecimal r1070_stage2_for_loans_advan) {
		this.r1070_stage2_for_loans_advan = r1070_stage2_for_loans_advan;
	}
	public BigDecimal getR1070_stage2_for_investments() {
		return r1070_stage2_for_investments;
	}
	public void setR1070_stage2_for_investments(BigDecimal r1070_stage2_for_investments) {
		this.r1070_stage2_for_investments = r1070_stage2_for_investments;
	}
	public BigDecimal getR1070_stage2_for_all_oth_assets() {
		return r1070_stage2_for_all_oth_assets;
	}
	public void setR1070_stage2_for_all_oth_assets(BigDecimal r1070_stage2_for_all_oth_assets) {
		this.r1070_stage2_for_all_oth_assets = r1070_stage2_for_all_oth_assets;
	}
	public BigDecimal getR1070_stage3_for_loans_advan() {
		return r1070_stage3_for_loans_advan;
	}
	public void setR1070_stage3_for_loans_advan(BigDecimal r1070_stage3_for_loans_advan) {
		this.r1070_stage3_for_loans_advan = r1070_stage3_for_loans_advan;
	}
	public BigDecimal getR1070_stage3_for_investments() {
		return r1070_stage3_for_investments;
	}
	public void setR1070_stage3_for_investments(BigDecimal r1070_stage3_for_investments) {
		this.r1070_stage3_for_investments = r1070_stage3_for_investments;
	}
	public BigDecimal getR1070_stage3_for_all_oth_assets() {
		return r1070_stage3_for_all_oth_assets;
	}
	public void setR1070_stage3_for_all_oth_assets(BigDecimal r1070_stage3_for_all_oth_assets) {
		this.r1070_stage3_for_all_oth_assets = r1070_stage3_for_all_oth_assets;
	}
	public BigDecimal getR1070_legacy_interest_suspense() {
		return r1070_legacy_interest_suspense;
	}
	public void setR1070_legacy_interest_suspense(BigDecimal r1070_legacy_interest_suspense) {
		this.r1070_legacy_interest_suspense = r1070_legacy_interest_suspense;
	}
	public BigDecimal getR1070_prov_inte_fee_due_mt90_days() {
		return r1070_prov_inte_fee_due_mt90_days;
	}
	public void setR1070_prov_inte_fee_due_mt90_days(BigDecimal r1070_prov_inte_fee_due_mt90_days) {
		this.r1070_prov_inte_fee_due_mt90_days = r1070_prov_inte_fee_due_mt90_days;
	}
	public BigDecimal getR1070_total() {
		return r1070_total;
	}
	public void setR1070_total(BigDecimal r1070_total) {
		this.r1070_total = r1070_total;
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
	
	
	
	public CBUAE_BRF1_10_Summary_Entity3() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
