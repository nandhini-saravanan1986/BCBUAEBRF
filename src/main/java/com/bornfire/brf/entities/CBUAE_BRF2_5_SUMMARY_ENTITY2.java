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
@Table(name = "CBUAE_BRF2_5_SUMMARYTABLE2")

public class CBUAE_BRF2_5_SUMMARY_ENTITY2 {
	
	private String	r0510_product;
	private BigDecimal	r0510_overdraft;
	private BigDecimal	r0510_0_7days;
	private BigDecimal	r0510_8_14days;
	private BigDecimal	r0510_15days_1months;
	private BigDecimal	r0510_1_2months;
	private BigDecimal	r0510_2_3months;
	private BigDecimal	r0510_3_6months;
	private BigDecimal	r0510_6_12months;
	private BigDecimal	r0510_1_2years;
	private BigDecimal	r0510_2_3years;
	private BigDecimal	r0510_3_4years;
	private BigDecimal	r0510_4_5years;
	private BigDecimal	r0510_5years;
	private BigDecimal	r0510_non_interest;
	private BigDecimal	r0510_total;
	private String	r0520_product;
	private BigDecimal	r0520_overdraft;
	private BigDecimal	r0520_0_7days;
	private BigDecimal	r0520_8_14days;
	private BigDecimal	r0520_15days_1months;
	private BigDecimal	r0520_1_2months;
	private BigDecimal	r0520_2_3months;
	private BigDecimal	r0520_3_6months;
	private BigDecimal	r0520_6_12months;
	private BigDecimal	r0520_1_2years;
	private BigDecimal	r0520_2_3years;
	private BigDecimal	r0520_3_4years;
	private BigDecimal	r0520_4_5years;
	private BigDecimal	r0520_5years;
	private BigDecimal	r0520_non_interest;
	private BigDecimal	r0520_total;
	private String	r0530_product;
	private BigDecimal	r0530_overdraft;
	private BigDecimal	r0530_0_7days;
	private BigDecimal	r0530_8_14days;
	private BigDecimal	r0530_15days_1months;
	private BigDecimal	r0530_1_2months;
	private BigDecimal	r0530_2_3months;
	private BigDecimal	r0530_3_6months;
	private BigDecimal	r0530_6_12months;
	private BigDecimal	r0530_1_2years;
	private BigDecimal	r0530_2_3years;
	private BigDecimal	r0530_3_4years;
	private BigDecimal	r0530_4_5years;
	private BigDecimal	r0530_5years;
	private BigDecimal	r0530_non_interest;
	private BigDecimal	r0530_total;
	private String	r0540_product;
	private BigDecimal	r0540_overdraft;
	private BigDecimal	r0540_0_7days;
	private BigDecimal	r0540_8_14days;
	private BigDecimal	r0540_15days_1months;
	private BigDecimal	r0540_1_2months;
	private BigDecimal	r0540_2_3months;
	private BigDecimal	r0540_3_6months;
	private BigDecimal	r0540_6_12months;
	private BigDecimal	r0540_1_2years;
	private BigDecimal	r0540_2_3years;
	private BigDecimal	r0540_3_4years;
	private BigDecimal	r0540_4_5years;
	private BigDecimal	r0540_5years;
	private BigDecimal	r0540_non_interest;
	private BigDecimal	r0540_total;
	private String	r0550_product;
	private BigDecimal	r0550_overdraft;
	private BigDecimal	r0550_0_7days;
	private BigDecimal	r0550_8_14days;
	private BigDecimal	r0550_15days_1months;
	private BigDecimal	r0550_1_2months;
	private BigDecimal	r0550_2_3months;
	private BigDecimal	r0550_3_6months;
	private BigDecimal	r0550_6_12months;
	private BigDecimal	r0550_1_2years;
	private BigDecimal	r0550_2_3years;
	private BigDecimal	r0550_3_4years;
	private BigDecimal	r0550_4_5years;
	private BigDecimal	r0550_5years;
	private BigDecimal	r0550_non_interest;
	private BigDecimal	r0550_total;
	private String	r0560_product;
	private BigDecimal	r0560_overdraft;
	private BigDecimal	r0560_0_7days;
	private BigDecimal	r0560_8_14days;
	private BigDecimal	r0560_15days_1months;
	private BigDecimal	r0560_1_2months;
	private BigDecimal	r0560_2_3months;
	private BigDecimal	r0560_3_6months;
	private BigDecimal	r0560_6_12months;
	private BigDecimal	r0560_1_2years;
	private BigDecimal	r0560_2_3years;
	private BigDecimal	r0560_3_4years;
	private BigDecimal	r0560_4_5years;
	private BigDecimal	r0560_5years;
	private BigDecimal	r0560_non_interest;
	private BigDecimal	r0560_total;
	private String	r0570_product;
	private BigDecimal	r0570_overdraft;
	private BigDecimal	r0570_0_7days;
	private BigDecimal	r0570_8_14days;
	private BigDecimal	r0570_15days_1months;
	private BigDecimal	r0570_1_2months;
	private BigDecimal	r0570_2_3months;
	private BigDecimal	r0570_3_6months;
	private BigDecimal	r0570_6_12months;
	private BigDecimal	r0570_1_2years;
	private BigDecimal	r0570_2_3years;
	private BigDecimal	r0570_3_4years;
	private BigDecimal	r0570_4_5years;
	private BigDecimal	r0570_5years;
	private BigDecimal	r0570_non_interest;
	private BigDecimal	r0570_total;
	private String	r0580_product;
	private BigDecimal	r0580_overdraft;
	private BigDecimal	r0580_0_7days;
	private BigDecimal	r0580_8_14days;
	private BigDecimal	r0580_15days_1months;
	private BigDecimal	r0580_1_2months;
	private BigDecimal	r0580_2_3months;
	private BigDecimal	r0580_3_6months;
	private BigDecimal	r0580_6_12months;
	private BigDecimal	r0580_1_2years;
	private BigDecimal	r0580_2_3years;
	private BigDecimal	r0580_3_4years;
	private BigDecimal	r0580_4_5years;
	private BigDecimal	r0580_5years;
	private BigDecimal	r0580_non_interest;
	private BigDecimal	r0580_total;
	private String	r0590_product;
	private BigDecimal	r0590_overdraft;
	private BigDecimal	r0590_0_7days;
	private BigDecimal	r0590_8_14days;
	private BigDecimal	r0590_15days_1months;
	private BigDecimal	r0590_1_2months;
	private BigDecimal	r0590_2_3months;
	private BigDecimal	r0590_3_6months;
	private BigDecimal	r0590_6_12months;
	private BigDecimal	r0590_1_2years;
	private BigDecimal	r0590_2_3years;
	private BigDecimal	r0590_3_4years;
	private BigDecimal	r0590_4_5years;
	private BigDecimal	r0590_5years;
	private BigDecimal	r0590_non_interest;
	private BigDecimal	r0590_total;
	private String	r0600_product;
	private BigDecimal	r0600_overdraft;
	private BigDecimal	r0600_0_7days;
	private BigDecimal	r0600_8_14days;
	private BigDecimal	r0600_15days_1months;
	private BigDecimal	r0600_1_2months;
	private BigDecimal	r0600_2_3months;
	private BigDecimal	r0600_3_6months;
	private BigDecimal	r0600_6_12months;
	private BigDecimal	r0600_1_2years;
	private BigDecimal	r0600_2_3years;
	private BigDecimal	r0600_3_4years;
	private BigDecimal	r0600_4_5years;
	private BigDecimal	r0600_5years;
	private BigDecimal	r0600_non_interest;
	private BigDecimal	r0600_total;
	private String	r0610_product;
	private BigDecimal	r0610_overdraft;
	private BigDecimal	r0610_0_7days;
	private BigDecimal	r0610_8_14days;
	private BigDecimal	r0610_15days_1months;
	private BigDecimal	r0610_1_2months;
	private BigDecimal	r0610_2_3months;
	private BigDecimal	r0610_3_6months;
	private BigDecimal	r0610_6_12months;
	private BigDecimal	r0610_1_2years;
	private BigDecimal	r0610_2_3years;
	private BigDecimal	r0610_3_4years;
	private BigDecimal	r0610_4_5years;
	private BigDecimal	r0610_5years;
	private BigDecimal	r0610_non_interest;
	private BigDecimal	r0610_total;
	private String	r0620_product;
	private BigDecimal	r0620_overdraft;
	private BigDecimal	r0620_0_7days;
	private BigDecimal	r0620_8_14days;
	private BigDecimal	r0620_15days_1months;
	private BigDecimal	r0620_1_2months;
	private BigDecimal	r0620_2_3months;
	private BigDecimal	r0620_3_6months;
	private BigDecimal	r0620_6_12months;
	private BigDecimal	r0620_1_2years;
	private BigDecimal	r0620_2_3years;
	private BigDecimal	r0620_3_4years;
	private BigDecimal	r0620_4_5years;
	private BigDecimal	r0620_5years;
	private BigDecimal	r0620_non_interest;
	private BigDecimal	r0620_total;
	private String	r0630_product;
	private BigDecimal	r0630_overdraft;
	private BigDecimal	r0630_0_7days;
	private BigDecimal	r0630_8_14days;
	private BigDecimal	r0630_15days_1months;
	private BigDecimal	r0630_1_2months;
	private BigDecimal	r0630_2_3months;
	private BigDecimal	r0630_3_6months;
	private BigDecimal	r0630_6_12months;
	private BigDecimal	r0630_1_2years;
	private BigDecimal	r0630_2_3years;
	private BigDecimal	r0630_3_4years;
	private BigDecimal	r0630_4_5years;
	private BigDecimal	r0630_5years;
	private BigDecimal	r0630_non_interest;
	private BigDecimal	r0630_total;
	private String	r0640_product;
	private BigDecimal	r0640_overdraft;
	private BigDecimal	r0640_0_7days;
	private BigDecimal	r0640_8_14days;
	private BigDecimal	r0640_15days_1months;
	private BigDecimal	r0640_1_2months;
	private BigDecimal	r0640_2_3months;
	private BigDecimal	r0640_3_6months;
	private BigDecimal	r0640_6_12months;
	private BigDecimal	r0640_1_2years;
	private BigDecimal	r0640_2_3years;
	private BigDecimal	r0640_3_4years;
	private BigDecimal	r0640_4_5years;
	private BigDecimal	r0640_5years;
	private BigDecimal	r0640_non_interest;
	private BigDecimal	r0640_total;
	private String	r0650_product;
	private BigDecimal	r0650_overdraft;
	private BigDecimal	r0650_0_7days;
	private BigDecimal	r0650_8_14days;
	private BigDecimal	r0650_15days_1months;
	private BigDecimal	r0650_1_2months;
	private BigDecimal	r0650_2_3months;
	private BigDecimal	r0650_3_6months;
	private BigDecimal	r0650_6_12months;
	private BigDecimal	r0650_1_2years;
	private BigDecimal	r0650_2_3years;
	private BigDecimal	r0650_3_4years;
	private BigDecimal	r0650_4_5years;
	private BigDecimal	r0650_5years;
	private BigDecimal	r0650_non_interest;
	private BigDecimal	r0650_total;
	private String	r0660_product;
	private BigDecimal	r0660_overdraft;
	private BigDecimal	r0660_0_7days;
	private BigDecimal	r0660_8_14days;
	private BigDecimal	r0660_15days_1months;
	private BigDecimal	r0660_1_2months;
	private BigDecimal	r0660_2_3months;
	private BigDecimal	r0660_3_6months;
	private BigDecimal	r0660_6_12months;
	private BigDecimal	r0660_1_2years;
	private BigDecimal	r0660_2_3years;
	private BigDecimal	r0660_3_4years;
	private BigDecimal	r0660_4_5years;
	private BigDecimal	r0660_5years;
	private BigDecimal	r0660_non_interest;
	private BigDecimal	r0660_total;
	private String	r0670_product;
	private BigDecimal	r0670_overdraft;
	private BigDecimal	r0670_0_7days;
	private BigDecimal	r0670_8_14days;
	private BigDecimal	r0670_15days_1months;
	private BigDecimal	r0670_1_2months;
	private BigDecimal	r0670_2_3months;
	private BigDecimal	r0670_3_6months;
	private BigDecimal	r0670_6_12months;
	private BigDecimal	r0670_1_2years;
	private BigDecimal	r0670_2_3years;
	private BigDecimal	r0670_3_4years;
	private BigDecimal	r0670_4_5years;
	private BigDecimal	r0670_5years;
	private BigDecimal	r0670_non_interest;
	private BigDecimal	r0670_total;
	private String	r0680_product;
	private BigDecimal	r0680_overdraft;
	private BigDecimal	r0680_0_7days;
	private BigDecimal	r0680_8_14days;
	private BigDecimal	r0680_15days_1months;
	private BigDecimal	r0680_1_2months;
	private BigDecimal	r0680_2_3months;
	private BigDecimal	r0680_3_6months;
	private BigDecimal	r0680_6_12months;
	private BigDecimal	r0680_1_2years;
	private BigDecimal	r0680_2_3years;
	private BigDecimal	r0680_3_4years;
	private BigDecimal	r0680_4_5years;
	private BigDecimal	r0680_5years;
	private BigDecimal	r0680_non_interest;
	private BigDecimal	r0680_total;
	private String	r0690_product;
	private BigDecimal	r0690_overdraft;
	private BigDecimal	r0690_0_7days;
	private BigDecimal	r0690_8_14days;
	private BigDecimal	r0690_15days_1months;
	private BigDecimal	r0690_1_2months;
	private BigDecimal	r0690_2_3months;
	private BigDecimal	r0690_3_6months;
	private BigDecimal	r0690_6_12months;
	private BigDecimal	r0690_1_2years;
	private BigDecimal	r0690_2_3years;
	private BigDecimal	r0690_3_4years;
	private BigDecimal	r0690_4_5years;
	private BigDecimal	r0690_5years;
	private BigDecimal	r0690_non_interest;
	private BigDecimal	r0690_total;
	private String	r0700_product;
	private BigDecimal	r0700_overdraft;
	private BigDecimal	r0700_0_7days;
	private BigDecimal	r0700_8_14days;
	private BigDecimal	r0700_15days_1months;
	private BigDecimal	r0700_1_2months;
	private BigDecimal	r0700_2_3months;
	private BigDecimal	r0700_3_6months;
	private BigDecimal	r0700_6_12months;
	private BigDecimal	r0700_1_2years;
	private BigDecimal	r0700_2_3years;
	private BigDecimal	r0700_3_4years;
	private BigDecimal	r0700_4_5years;
	private BigDecimal	r0700_5years;
	private BigDecimal	r0700_non_interest;
	private BigDecimal	r0700_total;
	private String	r0710_product;
	private BigDecimal	r0710_overdraft;
	private BigDecimal	r0710_0_7days;
	private BigDecimal	r0710_8_14days;
	private BigDecimal	r0710_15days_1months;
	private BigDecimal	r0710_1_2months;
	private BigDecimal	r0710_2_3months;
	private BigDecimal	r0710_3_6months;
	private BigDecimal	r0710_6_12months;
	private BigDecimal	r0710_1_2years;
	private BigDecimal	r0710_2_3years;
	private BigDecimal	r0710_3_4years;
	private BigDecimal	r0710_4_5years;
	private BigDecimal	r0710_5years;
	private BigDecimal	r0710_non_interest;
	private BigDecimal	r0710_total;
	private String	r0720_product;
	private BigDecimal	r0720_overdraft;
	private BigDecimal	r0720_0_7days;
	private BigDecimal	r0720_8_14days;
	private BigDecimal	r0720_15days_1months;
	private BigDecimal	r0720_1_2months;
	private BigDecimal	r0720_2_3months;
	private BigDecimal	r0720_3_6months;
	private BigDecimal	r0720_6_12months;
	private BigDecimal	r0720_1_2years;
	private BigDecimal	r0720_2_3years;
	private BigDecimal	r0720_3_4years;
	private BigDecimal	r0720_4_5years;
	private BigDecimal	r0720_5years;
	private BigDecimal	r0720_non_interest;
	private BigDecimal	r0720_total;
	private String	r0730_product;
	private BigDecimal	r0730_overdraft;
	private BigDecimal	r0730_0_7days;
	private BigDecimal	r0730_8_14days;
	private BigDecimal	r0730_15days_1months;
	private BigDecimal	r0730_1_2months;
	private BigDecimal	r0730_2_3months;
	private BigDecimal	r0730_3_6months;
	private BigDecimal	r0730_6_12months;
	private BigDecimal	r0730_1_2years;
	private BigDecimal	r0730_2_3years;
	private BigDecimal	r0730_3_4years;
	private BigDecimal	r0730_4_5years;
	private BigDecimal	r0730_5years;
	private BigDecimal	r0730_non_interest;
	private BigDecimal	r0730_total;
	private String	r0740_product;
	private BigDecimal	r0740_overdraft;
	private BigDecimal	r0740_0_7days;
	private BigDecimal	r0740_8_14days;
	private BigDecimal	r0740_15days_1months;
	private BigDecimal	r0740_1_2months;
	private BigDecimal	r0740_2_3months;
	private BigDecimal	r0740_3_6months;
	private BigDecimal	r0740_6_12months;
	private BigDecimal	r0740_1_2years;
	private BigDecimal	r0740_2_3years;
	private BigDecimal	r0740_3_4years;
	private BigDecimal	r0740_4_5years;
	private BigDecimal	r0740_5years;
	private BigDecimal	r0740_non_interest;
	private BigDecimal	r0740_total;
	private String	r0750_product;
	private BigDecimal	r0750_overdraft;
	private BigDecimal	r0750_0_7days;
	private BigDecimal	r0750_8_14days;
	private BigDecimal	r0750_15days_1months;
	private BigDecimal	r0750_1_2months;
	private BigDecimal	r0750_2_3months;
	private BigDecimal	r0750_3_6months;
	private BigDecimal	r0750_6_12months;
	private BigDecimal	r0750_1_2years;
	private BigDecimal	r0750_2_3years;
	private BigDecimal	r0750_3_4years;
	private BigDecimal	r0750_4_5years;
	private BigDecimal	r0750_5years;
	private BigDecimal	r0750_non_interest;
	private BigDecimal	r0750_total;
	private String	r0760_product;
	private BigDecimal	r0760_overdraft;
	private BigDecimal	r0760_0_7days;
	private BigDecimal	r0760_8_14days;
	private BigDecimal	r0760_15days_1months;
	private BigDecimal	r0760_1_2months;
	private BigDecimal	r0760_2_3months;
	private BigDecimal	r0760_3_6months;
	private BigDecimal	r0760_6_12months;
	private BigDecimal	r0760_1_2years;
	private BigDecimal	r0760_2_3years;
	private BigDecimal	r0760_3_4years;
	private BigDecimal	r0760_4_5years;
	private BigDecimal	r0760_5years;
	private BigDecimal	r0760_non_interest;
	private BigDecimal	r0760_total;
	
	
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
	public String getR0510_product() {
		return r0510_product;
	}
	public void setR0510_product(String r0510_product) {
		this.r0510_product = r0510_product;
	}
	public BigDecimal getR0510_overdraft() {
		return r0510_overdraft;
	}
	public void setR0510_overdraft(BigDecimal r0510_overdraft) {
		this.r0510_overdraft = r0510_overdraft;
	}
	public BigDecimal getR0510_0_7days() {
		return r0510_0_7days;
	}
	public void setR0510_0_7days(BigDecimal r0510_0_7days) {
		this.r0510_0_7days = r0510_0_7days;
	}
	public BigDecimal getR0510_8_14days() {
		return r0510_8_14days;
	}
	public void setR0510_8_14days(BigDecimal r0510_8_14days) {
		this.r0510_8_14days = r0510_8_14days;
	}
	public BigDecimal getR0510_15days_1months() {
		return r0510_15days_1months;
	}
	public void setR0510_15days_1months(BigDecimal r0510_15days_1months) {
		this.r0510_15days_1months = r0510_15days_1months;
	}
	public BigDecimal getR0510_1_2months() {
		return r0510_1_2months;
	}
	public void setR0510_1_2months(BigDecimal r0510_1_2months) {
		this.r0510_1_2months = r0510_1_2months;
	}
	public BigDecimal getR0510_2_3months() {
		return r0510_2_3months;
	}
	public void setR0510_2_3months(BigDecimal r0510_2_3months) {
		this.r0510_2_3months = r0510_2_3months;
	}
	public BigDecimal getR0510_3_6months() {
		return r0510_3_6months;
	}
	public void setR0510_3_6months(BigDecimal r0510_3_6months) {
		this.r0510_3_6months = r0510_3_6months;
	}
	public BigDecimal getR0510_6_12months() {
		return r0510_6_12months;
	}
	public void setR0510_6_12months(BigDecimal r0510_6_12months) {
		this.r0510_6_12months = r0510_6_12months;
	}
	public BigDecimal getR0510_1_2years() {
		return r0510_1_2years;
	}
	public void setR0510_1_2years(BigDecimal r0510_1_2years) {
		this.r0510_1_2years = r0510_1_2years;
	}
	public BigDecimal getR0510_2_3years() {
		return r0510_2_3years;
	}
	public void setR0510_2_3years(BigDecimal r0510_2_3years) {
		this.r0510_2_3years = r0510_2_3years;
	}
	public BigDecimal getR0510_3_4years() {
		return r0510_3_4years;
	}
	public void setR0510_3_4years(BigDecimal r0510_3_4years) {
		this.r0510_3_4years = r0510_3_4years;
	}
	public BigDecimal getR0510_4_5years() {
		return r0510_4_5years;
	}
	public void setR0510_4_5years(BigDecimal r0510_4_5years) {
		this.r0510_4_5years = r0510_4_5years;
	}
	public BigDecimal getR0510_5years() {
		return r0510_5years;
	}
	public void setR0510_5years(BigDecimal r0510_5years) {
		this.r0510_5years = r0510_5years;
	}
	public BigDecimal getR0510_non_interest() {
		return r0510_non_interest;
	}
	public void setR0510_non_interest(BigDecimal r0510_non_interest) {
		this.r0510_non_interest = r0510_non_interest;
	}
	public BigDecimal getR0510_total() {
		return r0510_total;
	}
	public void setR0510_total(BigDecimal r0510_total) {
		this.r0510_total = r0510_total;
	}
	public String getR0520_product() {
		return r0520_product;
	}
	public void setR0520_product(String r0520_product) {
		this.r0520_product = r0520_product;
	}
	public BigDecimal getR0520_overdraft() {
		return r0520_overdraft;
	}
	public void setR0520_overdraft(BigDecimal r0520_overdraft) {
		this.r0520_overdraft = r0520_overdraft;
	}
	public BigDecimal getR0520_0_7days() {
		return r0520_0_7days;
	}
	public void setR0520_0_7days(BigDecimal r0520_0_7days) {
		this.r0520_0_7days = r0520_0_7days;
	}
	public BigDecimal getR0520_8_14days() {
		return r0520_8_14days;
	}
	public void setR0520_8_14days(BigDecimal r0520_8_14days) {
		this.r0520_8_14days = r0520_8_14days;
	}
	public BigDecimal getR0520_15days_1months() {
		return r0520_15days_1months;
	}
	public void setR0520_15days_1months(BigDecimal r0520_15days_1months) {
		this.r0520_15days_1months = r0520_15days_1months;
	}
	public BigDecimal getR0520_1_2months() {
		return r0520_1_2months;
	}
	public void setR0520_1_2months(BigDecimal r0520_1_2months) {
		this.r0520_1_2months = r0520_1_2months;
	}
	public BigDecimal getR0520_2_3months() {
		return r0520_2_3months;
	}
	public void setR0520_2_3months(BigDecimal r0520_2_3months) {
		this.r0520_2_3months = r0520_2_3months;
	}
	public BigDecimal getR0520_3_6months() {
		return r0520_3_6months;
	}
	public void setR0520_3_6months(BigDecimal r0520_3_6months) {
		this.r0520_3_6months = r0520_3_6months;
	}
	public BigDecimal getR0520_6_12months() {
		return r0520_6_12months;
	}
	public void setR0520_6_12months(BigDecimal r0520_6_12months) {
		this.r0520_6_12months = r0520_6_12months;
	}
	public BigDecimal getR0520_1_2years() {
		return r0520_1_2years;
	}
	public void setR0520_1_2years(BigDecimal r0520_1_2years) {
		this.r0520_1_2years = r0520_1_2years;
	}
	public BigDecimal getR0520_2_3years() {
		return r0520_2_3years;
	}
	public void setR0520_2_3years(BigDecimal r0520_2_3years) {
		this.r0520_2_3years = r0520_2_3years;
	}
	public BigDecimal getR0520_3_4years() {
		return r0520_3_4years;
	}
	public void setR0520_3_4years(BigDecimal r0520_3_4years) {
		this.r0520_3_4years = r0520_3_4years;
	}
	public BigDecimal getR0520_4_5years() {
		return r0520_4_5years;
	}
	public void setR0520_4_5years(BigDecimal r0520_4_5years) {
		this.r0520_4_5years = r0520_4_5years;
	}
	public BigDecimal getR0520_5years() {
		return r0520_5years;
	}
	public void setR0520_5years(BigDecimal r0520_5years) {
		this.r0520_5years = r0520_5years;
	}
	public BigDecimal getR0520_non_interest() {
		return r0520_non_interest;
	}
	public void setR0520_non_interest(BigDecimal r0520_non_interest) {
		this.r0520_non_interest = r0520_non_interest;
	}
	public BigDecimal getR0520_total() {
		return r0520_total;
	}
	public void setR0520_total(BigDecimal r0520_total) {
		this.r0520_total = r0520_total;
	}
	public String getR0530_product() {
		return r0530_product;
	}
	public void setR0530_product(String r0530_product) {
		this.r0530_product = r0530_product;
	}
	public BigDecimal getR0530_overdraft() {
		return r0530_overdraft;
	}
	public void setR0530_overdraft(BigDecimal r0530_overdraft) {
		this.r0530_overdraft = r0530_overdraft;
	}
	public BigDecimal getR0530_0_7days() {
		return r0530_0_7days;
	}
	public void setR0530_0_7days(BigDecimal r0530_0_7days) {
		this.r0530_0_7days = r0530_0_7days;
	}
	public BigDecimal getR0530_8_14days() {
		return r0530_8_14days;
	}
	public void setR0530_8_14days(BigDecimal r0530_8_14days) {
		this.r0530_8_14days = r0530_8_14days;
	}
	public BigDecimal getR0530_15days_1months() {
		return r0530_15days_1months;
	}
	public void setR0530_15days_1months(BigDecimal r0530_15days_1months) {
		this.r0530_15days_1months = r0530_15days_1months;
	}
	public BigDecimal getR0530_1_2months() {
		return r0530_1_2months;
	}
	public void setR0530_1_2months(BigDecimal r0530_1_2months) {
		this.r0530_1_2months = r0530_1_2months;
	}
	public BigDecimal getR0530_2_3months() {
		return r0530_2_3months;
	}
	public void setR0530_2_3months(BigDecimal r0530_2_3months) {
		this.r0530_2_3months = r0530_2_3months;
	}
	public BigDecimal getR0530_3_6months() {
		return r0530_3_6months;
	}
	public void setR0530_3_6months(BigDecimal r0530_3_6months) {
		this.r0530_3_6months = r0530_3_6months;
	}
	public BigDecimal getR0530_6_12months() {
		return r0530_6_12months;
	}
	public void setR0530_6_12months(BigDecimal r0530_6_12months) {
		this.r0530_6_12months = r0530_6_12months;
	}
	public BigDecimal getR0530_1_2years() {
		return r0530_1_2years;
	}
	public void setR0530_1_2years(BigDecimal r0530_1_2years) {
		this.r0530_1_2years = r0530_1_2years;
	}
	public BigDecimal getR0530_2_3years() {
		return r0530_2_3years;
	}
	public void setR0530_2_3years(BigDecimal r0530_2_3years) {
		this.r0530_2_3years = r0530_2_3years;
	}
	public BigDecimal getR0530_3_4years() {
		return r0530_3_4years;
	}
	public void setR0530_3_4years(BigDecimal r0530_3_4years) {
		this.r0530_3_4years = r0530_3_4years;
	}
	public BigDecimal getR0530_4_5years() {
		return r0530_4_5years;
	}
	public void setR0530_4_5years(BigDecimal r0530_4_5years) {
		this.r0530_4_5years = r0530_4_5years;
	}
	public BigDecimal getR0530_5years() {
		return r0530_5years;
	}
	public void setR0530_5years(BigDecimal r0530_5years) {
		this.r0530_5years = r0530_5years;
	}
	public BigDecimal getR0530_non_interest() {
		return r0530_non_interest;
	}
	public void setR0530_non_interest(BigDecimal r0530_non_interest) {
		this.r0530_non_interest = r0530_non_interest;
	}
	public BigDecimal getR0530_total() {
		return r0530_total;
	}
	public void setR0530_total(BigDecimal r0530_total) {
		this.r0530_total = r0530_total;
	}
	public String getR0540_product() {
		return r0540_product;
	}
	public void setR0540_product(String r0540_product) {
		this.r0540_product = r0540_product;
	}
	public BigDecimal getR0540_overdraft() {
		return r0540_overdraft;
	}
	public void setR0540_overdraft(BigDecimal r0540_overdraft) {
		this.r0540_overdraft = r0540_overdraft;
	}
	public BigDecimal getR0540_0_7days() {
		return r0540_0_7days;
	}
	public void setR0540_0_7days(BigDecimal r0540_0_7days) {
		this.r0540_0_7days = r0540_0_7days;
	}
	public BigDecimal getR0540_8_14days() {
		return r0540_8_14days;
	}
	public void setR0540_8_14days(BigDecimal r0540_8_14days) {
		this.r0540_8_14days = r0540_8_14days;
	}
	public BigDecimal getR0540_15days_1months() {
		return r0540_15days_1months;
	}
	public void setR0540_15days_1months(BigDecimal r0540_15days_1months) {
		this.r0540_15days_1months = r0540_15days_1months;
	}
	public BigDecimal getR0540_1_2months() {
		return r0540_1_2months;
	}
	public void setR0540_1_2months(BigDecimal r0540_1_2months) {
		this.r0540_1_2months = r0540_1_2months;
	}
	public BigDecimal getR0540_2_3months() {
		return r0540_2_3months;
	}
	public void setR0540_2_3months(BigDecimal r0540_2_3months) {
		this.r0540_2_3months = r0540_2_3months;
	}
	public BigDecimal getR0540_3_6months() {
		return r0540_3_6months;
	}
	public void setR0540_3_6months(BigDecimal r0540_3_6months) {
		this.r0540_3_6months = r0540_3_6months;
	}
	public BigDecimal getR0540_6_12months() {
		return r0540_6_12months;
	}
	public void setR0540_6_12months(BigDecimal r0540_6_12months) {
		this.r0540_6_12months = r0540_6_12months;
	}
	public BigDecimal getR0540_1_2years() {
		return r0540_1_2years;
	}
	public void setR0540_1_2years(BigDecimal r0540_1_2years) {
		this.r0540_1_2years = r0540_1_2years;
	}
	public BigDecimal getR0540_2_3years() {
		return r0540_2_3years;
	}
	public void setR0540_2_3years(BigDecimal r0540_2_3years) {
		this.r0540_2_3years = r0540_2_3years;
	}
	public BigDecimal getR0540_3_4years() {
		return r0540_3_4years;
	}
	public void setR0540_3_4years(BigDecimal r0540_3_4years) {
		this.r0540_3_4years = r0540_3_4years;
	}
	public BigDecimal getR0540_4_5years() {
		return r0540_4_5years;
	}
	public void setR0540_4_5years(BigDecimal r0540_4_5years) {
		this.r0540_4_5years = r0540_4_5years;
	}
	public BigDecimal getR0540_5years() {
		return r0540_5years;
	}
	public void setR0540_5years(BigDecimal r0540_5years) {
		this.r0540_5years = r0540_5years;
	}
	public BigDecimal getR0540_non_interest() {
		return r0540_non_interest;
	}
	public void setR0540_non_interest(BigDecimal r0540_non_interest) {
		this.r0540_non_interest = r0540_non_interest;
	}
	public BigDecimal getR0540_total() {
		return r0540_total;
	}
	public void setR0540_total(BigDecimal r0540_total) {
		this.r0540_total = r0540_total;
	}
	public String getR0550_product() {
		return r0550_product;
	}
	public void setR0550_product(String r0550_product) {
		this.r0550_product = r0550_product;
	}
	public BigDecimal getR0550_overdraft() {
		return r0550_overdraft;
	}
	public void setR0550_overdraft(BigDecimal r0550_overdraft) {
		this.r0550_overdraft = r0550_overdraft;
	}
	public BigDecimal getR0550_0_7days() {
		return r0550_0_7days;
	}
	public void setR0550_0_7days(BigDecimal r0550_0_7days) {
		this.r0550_0_7days = r0550_0_7days;
	}
	public BigDecimal getR0550_8_14days() {
		return r0550_8_14days;
	}
	public void setR0550_8_14days(BigDecimal r0550_8_14days) {
		this.r0550_8_14days = r0550_8_14days;
	}
	public BigDecimal getR0550_15days_1months() {
		return r0550_15days_1months;
	}
	public void setR0550_15days_1months(BigDecimal r0550_15days_1months) {
		this.r0550_15days_1months = r0550_15days_1months;
	}
	public BigDecimal getR0550_1_2months() {
		return r0550_1_2months;
	}
	public void setR0550_1_2months(BigDecimal r0550_1_2months) {
		this.r0550_1_2months = r0550_1_2months;
	}
	public BigDecimal getR0550_2_3months() {
		return r0550_2_3months;
	}
	public void setR0550_2_3months(BigDecimal r0550_2_3months) {
		this.r0550_2_3months = r0550_2_3months;
	}
	public BigDecimal getR0550_3_6months() {
		return r0550_3_6months;
	}
	public void setR0550_3_6months(BigDecimal r0550_3_6months) {
		this.r0550_3_6months = r0550_3_6months;
	}
	public BigDecimal getR0550_6_12months() {
		return r0550_6_12months;
	}
	public void setR0550_6_12months(BigDecimal r0550_6_12months) {
		this.r0550_6_12months = r0550_6_12months;
	}
	public BigDecimal getR0550_1_2years() {
		return r0550_1_2years;
	}
	public void setR0550_1_2years(BigDecimal r0550_1_2years) {
		this.r0550_1_2years = r0550_1_2years;
	}
	public BigDecimal getR0550_2_3years() {
		return r0550_2_3years;
	}
	public void setR0550_2_3years(BigDecimal r0550_2_3years) {
		this.r0550_2_3years = r0550_2_3years;
	}
	public BigDecimal getR0550_3_4years() {
		return r0550_3_4years;
	}
	public void setR0550_3_4years(BigDecimal r0550_3_4years) {
		this.r0550_3_4years = r0550_3_4years;
	}
	public BigDecimal getR0550_4_5years() {
		return r0550_4_5years;
	}
	public void setR0550_4_5years(BigDecimal r0550_4_5years) {
		this.r0550_4_5years = r0550_4_5years;
	}
	public BigDecimal getR0550_5years() {
		return r0550_5years;
	}
	public void setR0550_5years(BigDecimal r0550_5years) {
		this.r0550_5years = r0550_5years;
	}
	public BigDecimal getR0550_non_interest() {
		return r0550_non_interest;
	}
	public void setR0550_non_interest(BigDecimal r0550_non_interest) {
		this.r0550_non_interest = r0550_non_interest;
	}
	public BigDecimal getR0550_total() {
		return r0550_total;
	}
	public void setR0550_total(BigDecimal r0550_total) {
		this.r0550_total = r0550_total;
	}
	public String getR0560_product() {
		return r0560_product;
	}
	public void setR0560_product(String r0560_product) {
		this.r0560_product = r0560_product;
	}
	public BigDecimal getR0560_overdraft() {
		return r0560_overdraft;
	}
	public void setR0560_overdraft(BigDecimal r0560_overdraft) {
		this.r0560_overdraft = r0560_overdraft;
	}
	public BigDecimal getR0560_0_7days() {
		return r0560_0_7days;
	}
	public void setR0560_0_7days(BigDecimal r0560_0_7days) {
		this.r0560_0_7days = r0560_0_7days;
	}
	public BigDecimal getR0560_8_14days() {
		return r0560_8_14days;
	}
	public void setR0560_8_14days(BigDecimal r0560_8_14days) {
		this.r0560_8_14days = r0560_8_14days;
	}
	public BigDecimal getR0560_15days_1months() {
		return r0560_15days_1months;
	}
	public void setR0560_15days_1months(BigDecimal r0560_15days_1months) {
		this.r0560_15days_1months = r0560_15days_1months;
	}
	public BigDecimal getR0560_1_2months() {
		return r0560_1_2months;
	}
	public void setR0560_1_2months(BigDecimal r0560_1_2months) {
		this.r0560_1_2months = r0560_1_2months;
	}
	public BigDecimal getR0560_2_3months() {
		return r0560_2_3months;
	}
	public void setR0560_2_3months(BigDecimal r0560_2_3months) {
		this.r0560_2_3months = r0560_2_3months;
	}
	public BigDecimal getR0560_3_6months() {
		return r0560_3_6months;
	}
	public void setR0560_3_6months(BigDecimal r0560_3_6months) {
		this.r0560_3_6months = r0560_3_6months;
	}
	public BigDecimal getR0560_6_12months() {
		return r0560_6_12months;
	}
	public void setR0560_6_12months(BigDecimal r0560_6_12months) {
		this.r0560_6_12months = r0560_6_12months;
	}
	public BigDecimal getR0560_1_2years() {
		return r0560_1_2years;
	}
	public void setR0560_1_2years(BigDecimal r0560_1_2years) {
		this.r0560_1_2years = r0560_1_2years;
	}
	public BigDecimal getR0560_2_3years() {
		return r0560_2_3years;
	}
	public void setR0560_2_3years(BigDecimal r0560_2_3years) {
		this.r0560_2_3years = r0560_2_3years;
	}
	public BigDecimal getR0560_3_4years() {
		return r0560_3_4years;
	}
	public void setR0560_3_4years(BigDecimal r0560_3_4years) {
		this.r0560_3_4years = r0560_3_4years;
	}
	public BigDecimal getR0560_4_5years() {
		return r0560_4_5years;
	}
	public void setR0560_4_5years(BigDecimal r0560_4_5years) {
		this.r0560_4_5years = r0560_4_5years;
	}
	public BigDecimal getR0560_5years() {
		return r0560_5years;
	}
	public void setR0560_5years(BigDecimal r0560_5years) {
		this.r0560_5years = r0560_5years;
	}
	public BigDecimal getR0560_non_interest() {
		return r0560_non_interest;
	}
	public void setR0560_non_interest(BigDecimal r0560_non_interest) {
		this.r0560_non_interest = r0560_non_interest;
	}
	public BigDecimal getR0560_total() {
		return r0560_total;
	}
	public void setR0560_total(BigDecimal r0560_total) {
		this.r0560_total = r0560_total;
	}
	public String getR0570_product() {
		return r0570_product;
	}
	public void setR0570_product(String r0570_product) {
		this.r0570_product = r0570_product;
	}
	public BigDecimal getR0570_overdraft() {
		return r0570_overdraft;
	}
	public void setR0570_overdraft(BigDecimal r0570_overdraft) {
		this.r0570_overdraft = r0570_overdraft;
	}
	public BigDecimal getR0570_0_7days() {
		return r0570_0_7days;
	}
	public void setR0570_0_7days(BigDecimal r0570_0_7days) {
		this.r0570_0_7days = r0570_0_7days;
	}
	public BigDecimal getR0570_8_14days() {
		return r0570_8_14days;
	}
	public void setR0570_8_14days(BigDecimal r0570_8_14days) {
		this.r0570_8_14days = r0570_8_14days;
	}
	public BigDecimal getR0570_15days_1months() {
		return r0570_15days_1months;
	}
	public void setR0570_15days_1months(BigDecimal r0570_15days_1months) {
		this.r0570_15days_1months = r0570_15days_1months;
	}
	public BigDecimal getR0570_1_2months() {
		return r0570_1_2months;
	}
	public void setR0570_1_2months(BigDecimal r0570_1_2months) {
		this.r0570_1_2months = r0570_1_2months;
	}
	public BigDecimal getR0570_2_3months() {
		return r0570_2_3months;
	}
	public void setR0570_2_3months(BigDecimal r0570_2_3months) {
		this.r0570_2_3months = r0570_2_3months;
	}
	public BigDecimal getR0570_3_6months() {
		return r0570_3_6months;
	}
	public void setR0570_3_6months(BigDecimal r0570_3_6months) {
		this.r0570_3_6months = r0570_3_6months;
	}
	public BigDecimal getR0570_6_12months() {
		return r0570_6_12months;
	}
	public void setR0570_6_12months(BigDecimal r0570_6_12months) {
		this.r0570_6_12months = r0570_6_12months;
	}
	public BigDecimal getR0570_1_2years() {
		return r0570_1_2years;
	}
	public void setR0570_1_2years(BigDecimal r0570_1_2years) {
		this.r0570_1_2years = r0570_1_2years;
	}
	public BigDecimal getR0570_2_3years() {
		return r0570_2_3years;
	}
	public void setR0570_2_3years(BigDecimal r0570_2_3years) {
		this.r0570_2_3years = r0570_2_3years;
	}
	public BigDecimal getR0570_3_4years() {
		return r0570_3_4years;
	}
	public void setR0570_3_4years(BigDecimal r0570_3_4years) {
		this.r0570_3_4years = r0570_3_4years;
	}
	public BigDecimal getR0570_4_5years() {
		return r0570_4_5years;
	}
	public void setR0570_4_5years(BigDecimal r0570_4_5years) {
		this.r0570_4_5years = r0570_4_5years;
	}
	public BigDecimal getR0570_5years() {
		return r0570_5years;
	}
	public void setR0570_5years(BigDecimal r0570_5years) {
		this.r0570_5years = r0570_5years;
	}
	public BigDecimal getR0570_non_interest() {
		return r0570_non_interest;
	}
	public void setR0570_non_interest(BigDecimal r0570_non_interest) {
		this.r0570_non_interest = r0570_non_interest;
	}
	public BigDecimal getR0570_total() {
		return r0570_total;
	}
	public void setR0570_total(BigDecimal r0570_total) {
		this.r0570_total = r0570_total;
	}
	public String getR0580_product() {
		return r0580_product;
	}
	public void setR0580_product(String r0580_product) {
		this.r0580_product = r0580_product;
	}
	public BigDecimal getR0580_overdraft() {
		return r0580_overdraft;
	}
	public void setR0580_overdraft(BigDecimal r0580_overdraft) {
		this.r0580_overdraft = r0580_overdraft;
	}
	public BigDecimal getR0580_0_7days() {
		return r0580_0_7days;
	}
	public void setR0580_0_7days(BigDecimal r0580_0_7days) {
		this.r0580_0_7days = r0580_0_7days;
	}
	public BigDecimal getR0580_8_14days() {
		return r0580_8_14days;
	}
	public void setR0580_8_14days(BigDecimal r0580_8_14days) {
		this.r0580_8_14days = r0580_8_14days;
	}
	public BigDecimal getR0580_15days_1months() {
		return r0580_15days_1months;
	}
	public void setR0580_15days_1months(BigDecimal r0580_15days_1months) {
		this.r0580_15days_1months = r0580_15days_1months;
	}
	public BigDecimal getR0580_1_2months() {
		return r0580_1_2months;
	}
	public void setR0580_1_2months(BigDecimal r0580_1_2months) {
		this.r0580_1_2months = r0580_1_2months;
	}
	public BigDecimal getR0580_2_3months() {
		return r0580_2_3months;
	}
	public void setR0580_2_3months(BigDecimal r0580_2_3months) {
		this.r0580_2_3months = r0580_2_3months;
	}
	public BigDecimal getR0580_3_6months() {
		return r0580_3_6months;
	}
	public void setR0580_3_6months(BigDecimal r0580_3_6months) {
		this.r0580_3_6months = r0580_3_6months;
	}
	public BigDecimal getR0580_6_12months() {
		return r0580_6_12months;
	}
	public void setR0580_6_12months(BigDecimal r0580_6_12months) {
		this.r0580_6_12months = r0580_6_12months;
	}
	public BigDecimal getR0580_1_2years() {
		return r0580_1_2years;
	}
	public void setR0580_1_2years(BigDecimal r0580_1_2years) {
		this.r0580_1_2years = r0580_1_2years;
	}
	public BigDecimal getR0580_2_3years() {
		return r0580_2_3years;
	}
	public void setR0580_2_3years(BigDecimal r0580_2_3years) {
		this.r0580_2_3years = r0580_2_3years;
	}
	public BigDecimal getR0580_3_4years() {
		return r0580_3_4years;
	}
	public void setR0580_3_4years(BigDecimal r0580_3_4years) {
		this.r0580_3_4years = r0580_3_4years;
	}
	public BigDecimal getR0580_4_5years() {
		return r0580_4_5years;
	}
	public void setR0580_4_5years(BigDecimal r0580_4_5years) {
		this.r0580_4_5years = r0580_4_5years;
	}
	public BigDecimal getR0580_5years() {
		return r0580_5years;
	}
	public void setR0580_5years(BigDecimal r0580_5years) {
		this.r0580_5years = r0580_5years;
	}
	public BigDecimal getR0580_non_interest() {
		return r0580_non_interest;
	}
	public void setR0580_non_interest(BigDecimal r0580_non_interest) {
		this.r0580_non_interest = r0580_non_interest;
	}
	public BigDecimal getR0580_total() {
		return r0580_total;
	}
	public void setR0580_total(BigDecimal r0580_total) {
		this.r0580_total = r0580_total;
	}
	public String getR0590_product() {
		return r0590_product;
	}
	public void setR0590_product(String r0590_product) {
		this.r0590_product = r0590_product;
	}
	public BigDecimal getR0590_overdraft() {
		return r0590_overdraft;
	}
	public void setR0590_overdraft(BigDecimal r0590_overdraft) {
		this.r0590_overdraft = r0590_overdraft;
	}
	public BigDecimal getR0590_0_7days() {
		return r0590_0_7days;
	}
	public void setR0590_0_7days(BigDecimal r0590_0_7days) {
		this.r0590_0_7days = r0590_0_7days;
	}
	public BigDecimal getR0590_8_14days() {
		return r0590_8_14days;
	}
	public void setR0590_8_14days(BigDecimal r0590_8_14days) {
		this.r0590_8_14days = r0590_8_14days;
	}
	public BigDecimal getR0590_15days_1months() {
		return r0590_15days_1months;
	}
	public void setR0590_15days_1months(BigDecimal r0590_15days_1months) {
		this.r0590_15days_1months = r0590_15days_1months;
	}
	public BigDecimal getR0590_1_2months() {
		return r0590_1_2months;
	}
	public void setR0590_1_2months(BigDecimal r0590_1_2months) {
		this.r0590_1_2months = r0590_1_2months;
	}
	public BigDecimal getR0590_2_3months() {
		return r0590_2_3months;
	}
	public void setR0590_2_3months(BigDecimal r0590_2_3months) {
		this.r0590_2_3months = r0590_2_3months;
	}
	public BigDecimal getR0590_3_6months() {
		return r0590_3_6months;
	}
	public void setR0590_3_6months(BigDecimal r0590_3_6months) {
		this.r0590_3_6months = r0590_3_6months;
	}
	public BigDecimal getR0590_6_12months() {
		return r0590_6_12months;
	}
	public void setR0590_6_12months(BigDecimal r0590_6_12months) {
		this.r0590_6_12months = r0590_6_12months;
	}
	public BigDecimal getR0590_1_2years() {
		return r0590_1_2years;
	}
	public void setR0590_1_2years(BigDecimal r0590_1_2years) {
		this.r0590_1_2years = r0590_1_2years;
	}
	public BigDecimal getR0590_2_3years() {
		return r0590_2_3years;
	}
	public void setR0590_2_3years(BigDecimal r0590_2_3years) {
		this.r0590_2_3years = r0590_2_3years;
	}
	public BigDecimal getR0590_3_4years() {
		return r0590_3_4years;
	}
	public void setR0590_3_4years(BigDecimal r0590_3_4years) {
		this.r0590_3_4years = r0590_3_4years;
	}
	public BigDecimal getR0590_4_5years() {
		return r0590_4_5years;
	}
	public void setR0590_4_5years(BigDecimal r0590_4_5years) {
		this.r0590_4_5years = r0590_4_5years;
	}
	public BigDecimal getR0590_5years() {
		return r0590_5years;
	}
	public void setR0590_5years(BigDecimal r0590_5years) {
		this.r0590_5years = r0590_5years;
	}
	public BigDecimal getR0590_non_interest() {
		return r0590_non_interest;
	}
	public void setR0590_non_interest(BigDecimal r0590_non_interest) {
		this.r0590_non_interest = r0590_non_interest;
	}
	public BigDecimal getR0590_total() {
		return r0590_total;
	}
	public void setR0590_total(BigDecimal r0590_total) {
		this.r0590_total = r0590_total;
	}
	public String getR0600_product() {
		return r0600_product;
	}
	public void setR0600_product(String r0600_product) {
		this.r0600_product = r0600_product;
	}
	public BigDecimal getR0600_overdraft() {
		return r0600_overdraft;
	}
	public void setR0600_overdraft(BigDecimal r0600_overdraft) {
		this.r0600_overdraft = r0600_overdraft;
	}
	public BigDecimal getR0600_0_7days() {
		return r0600_0_7days;
	}
	public void setR0600_0_7days(BigDecimal r0600_0_7days) {
		this.r0600_0_7days = r0600_0_7days;
	}
	public BigDecimal getR0600_8_14days() {
		return r0600_8_14days;
	}
	public void setR0600_8_14days(BigDecimal r0600_8_14days) {
		this.r0600_8_14days = r0600_8_14days;
	}
	public BigDecimal getR0600_15days_1months() {
		return r0600_15days_1months;
	}
	public void setR0600_15days_1months(BigDecimal r0600_15days_1months) {
		this.r0600_15days_1months = r0600_15days_1months;
	}
	public BigDecimal getR0600_1_2months() {
		return r0600_1_2months;
	}
	public void setR0600_1_2months(BigDecimal r0600_1_2months) {
		this.r0600_1_2months = r0600_1_2months;
	}
	public BigDecimal getR0600_2_3months() {
		return r0600_2_3months;
	}
	public void setR0600_2_3months(BigDecimal r0600_2_3months) {
		this.r0600_2_3months = r0600_2_3months;
	}
	public BigDecimal getR0600_3_6months() {
		return r0600_3_6months;
	}
	public void setR0600_3_6months(BigDecimal r0600_3_6months) {
		this.r0600_3_6months = r0600_3_6months;
	}
	public BigDecimal getR0600_6_12months() {
		return r0600_6_12months;
	}
	public void setR0600_6_12months(BigDecimal r0600_6_12months) {
		this.r0600_6_12months = r0600_6_12months;
	}
	public BigDecimal getR0600_1_2years() {
		return r0600_1_2years;
	}
	public void setR0600_1_2years(BigDecimal r0600_1_2years) {
		this.r0600_1_2years = r0600_1_2years;
	}
	public BigDecimal getR0600_2_3years() {
		return r0600_2_3years;
	}
	public void setR0600_2_3years(BigDecimal r0600_2_3years) {
		this.r0600_2_3years = r0600_2_3years;
	}
	public BigDecimal getR0600_3_4years() {
		return r0600_3_4years;
	}
	public void setR0600_3_4years(BigDecimal r0600_3_4years) {
		this.r0600_3_4years = r0600_3_4years;
	}
	public BigDecimal getR0600_4_5years() {
		return r0600_4_5years;
	}
	public void setR0600_4_5years(BigDecimal r0600_4_5years) {
		this.r0600_4_5years = r0600_4_5years;
	}
	public BigDecimal getR0600_5years() {
		return r0600_5years;
	}
	public void setR0600_5years(BigDecimal r0600_5years) {
		this.r0600_5years = r0600_5years;
	}
	public BigDecimal getR0600_non_interest() {
		return r0600_non_interest;
	}
	public void setR0600_non_interest(BigDecimal r0600_non_interest) {
		this.r0600_non_interest = r0600_non_interest;
	}
	public BigDecimal getR0600_total() {
		return r0600_total;
	}
	public void setR0600_total(BigDecimal r0600_total) {
		this.r0600_total = r0600_total;
	}
	public String getR0610_product() {
		return r0610_product;
	}
	public void setR0610_product(String r0610_product) {
		this.r0610_product = r0610_product;
	}
	public BigDecimal getR0610_overdraft() {
		return r0610_overdraft;
	}
	public void setR0610_overdraft(BigDecimal r0610_overdraft) {
		this.r0610_overdraft = r0610_overdraft;
	}
	public BigDecimal getR0610_0_7days() {
		return r0610_0_7days;
	}
	public void setR0610_0_7days(BigDecimal r0610_0_7days) {
		this.r0610_0_7days = r0610_0_7days;
	}
	public BigDecimal getR0610_8_14days() {
		return r0610_8_14days;
	}
	public void setR0610_8_14days(BigDecimal r0610_8_14days) {
		this.r0610_8_14days = r0610_8_14days;
	}
	public BigDecimal getR0610_15days_1months() {
		return r0610_15days_1months;
	}
	public void setR0610_15days_1months(BigDecimal r0610_15days_1months) {
		this.r0610_15days_1months = r0610_15days_1months;
	}
	public BigDecimal getR0610_1_2months() {
		return r0610_1_2months;
	}
	public void setR0610_1_2months(BigDecimal r0610_1_2months) {
		this.r0610_1_2months = r0610_1_2months;
	}
	public BigDecimal getR0610_2_3months() {
		return r0610_2_3months;
	}
	public void setR0610_2_3months(BigDecimal r0610_2_3months) {
		this.r0610_2_3months = r0610_2_3months;
	}
	public BigDecimal getR0610_3_6months() {
		return r0610_3_6months;
	}
	public void setR0610_3_6months(BigDecimal r0610_3_6months) {
		this.r0610_3_6months = r0610_3_6months;
	}
	public BigDecimal getR0610_6_12months() {
		return r0610_6_12months;
	}
	public void setR0610_6_12months(BigDecimal r0610_6_12months) {
		this.r0610_6_12months = r0610_6_12months;
	}
	public BigDecimal getR0610_1_2years() {
		return r0610_1_2years;
	}
	public void setR0610_1_2years(BigDecimal r0610_1_2years) {
		this.r0610_1_2years = r0610_1_2years;
	}
	public BigDecimal getR0610_2_3years() {
		return r0610_2_3years;
	}
	public void setR0610_2_3years(BigDecimal r0610_2_3years) {
		this.r0610_2_3years = r0610_2_3years;
	}
	public BigDecimal getR0610_3_4years() {
		return r0610_3_4years;
	}
	public void setR0610_3_4years(BigDecimal r0610_3_4years) {
		this.r0610_3_4years = r0610_3_4years;
	}
	public BigDecimal getR0610_4_5years() {
		return r0610_4_5years;
	}
	public void setR0610_4_5years(BigDecimal r0610_4_5years) {
		this.r0610_4_5years = r0610_4_5years;
	}
	public BigDecimal getR0610_5years() {
		return r0610_5years;
	}
	public void setR0610_5years(BigDecimal r0610_5years) {
		this.r0610_5years = r0610_5years;
	}
	public BigDecimal getR0610_non_interest() {
		return r0610_non_interest;
	}
	public void setR0610_non_interest(BigDecimal r0610_non_interest) {
		this.r0610_non_interest = r0610_non_interest;
	}
	public BigDecimal getR0610_total() {
		return r0610_total;
	}
	public void setR0610_total(BigDecimal r0610_total) {
		this.r0610_total = r0610_total;
	}
	public String getR0620_product() {
		return r0620_product;
	}
	public void setR0620_product(String r0620_product) {
		this.r0620_product = r0620_product;
	}
	public BigDecimal getR0620_overdraft() {
		return r0620_overdraft;
	}
	public void setR0620_overdraft(BigDecimal r0620_overdraft) {
		this.r0620_overdraft = r0620_overdraft;
	}
	public BigDecimal getR0620_0_7days() {
		return r0620_0_7days;
	}
	public void setR0620_0_7days(BigDecimal r0620_0_7days) {
		this.r0620_0_7days = r0620_0_7days;
	}
	public BigDecimal getR0620_8_14days() {
		return r0620_8_14days;
	}
	public void setR0620_8_14days(BigDecimal r0620_8_14days) {
		this.r0620_8_14days = r0620_8_14days;
	}
	public BigDecimal getR0620_15days_1months() {
		return r0620_15days_1months;
	}
	public void setR0620_15days_1months(BigDecimal r0620_15days_1months) {
		this.r0620_15days_1months = r0620_15days_1months;
	}
	public BigDecimal getR0620_1_2months() {
		return r0620_1_2months;
	}
	public void setR0620_1_2months(BigDecimal r0620_1_2months) {
		this.r0620_1_2months = r0620_1_2months;
	}
	public BigDecimal getR0620_2_3months() {
		return r0620_2_3months;
	}
	public void setR0620_2_3months(BigDecimal r0620_2_3months) {
		this.r0620_2_3months = r0620_2_3months;
	}
	public BigDecimal getR0620_3_6months() {
		return r0620_3_6months;
	}
	public void setR0620_3_6months(BigDecimal r0620_3_6months) {
		this.r0620_3_6months = r0620_3_6months;
	}
	public BigDecimal getR0620_6_12months() {
		return r0620_6_12months;
	}
	public void setR0620_6_12months(BigDecimal r0620_6_12months) {
		this.r0620_6_12months = r0620_6_12months;
	}
	public BigDecimal getR0620_1_2years() {
		return r0620_1_2years;
	}
	public void setR0620_1_2years(BigDecimal r0620_1_2years) {
		this.r0620_1_2years = r0620_1_2years;
	}
	public BigDecimal getR0620_2_3years() {
		return r0620_2_3years;
	}
	public void setR0620_2_3years(BigDecimal r0620_2_3years) {
		this.r0620_2_3years = r0620_2_3years;
	}
	public BigDecimal getR0620_3_4years() {
		return r0620_3_4years;
	}
	public void setR0620_3_4years(BigDecimal r0620_3_4years) {
		this.r0620_3_4years = r0620_3_4years;
	}
	public BigDecimal getR0620_4_5years() {
		return r0620_4_5years;
	}
	public void setR0620_4_5years(BigDecimal r0620_4_5years) {
		this.r0620_4_5years = r0620_4_5years;
	}
	public BigDecimal getR0620_5years() {
		return r0620_5years;
	}
	public void setR0620_5years(BigDecimal r0620_5years) {
		this.r0620_5years = r0620_5years;
	}
	public BigDecimal getR0620_non_interest() {
		return r0620_non_interest;
	}
	public void setR0620_non_interest(BigDecimal r0620_non_interest) {
		this.r0620_non_interest = r0620_non_interest;
	}
	public BigDecimal getR0620_total() {
		return r0620_total;
	}
	public void setR0620_total(BigDecimal r0620_total) {
		this.r0620_total = r0620_total;
	}
	public String getR0630_product() {
		return r0630_product;
	}
	public void setR0630_product(String r0630_product) {
		this.r0630_product = r0630_product;
	}
	public BigDecimal getR0630_overdraft() {
		return r0630_overdraft;
	}
	public void setR0630_overdraft(BigDecimal r0630_overdraft) {
		this.r0630_overdraft = r0630_overdraft;
	}
	public BigDecimal getR0630_0_7days() {
		return r0630_0_7days;
	}
	public void setR0630_0_7days(BigDecimal r0630_0_7days) {
		this.r0630_0_7days = r0630_0_7days;
	}
	public BigDecimal getR0630_8_14days() {
		return r0630_8_14days;
	}
	public void setR0630_8_14days(BigDecimal r0630_8_14days) {
		this.r0630_8_14days = r0630_8_14days;
	}
	public BigDecimal getR0630_15days_1months() {
		return r0630_15days_1months;
	}
	public void setR0630_15days_1months(BigDecimal r0630_15days_1months) {
		this.r0630_15days_1months = r0630_15days_1months;
	}
	public BigDecimal getR0630_1_2months() {
		return r0630_1_2months;
	}
	public void setR0630_1_2months(BigDecimal r0630_1_2months) {
		this.r0630_1_2months = r0630_1_2months;
	}
	public BigDecimal getR0630_2_3months() {
		return r0630_2_3months;
	}
	public void setR0630_2_3months(BigDecimal r0630_2_3months) {
		this.r0630_2_3months = r0630_2_3months;
	}
	public BigDecimal getR0630_3_6months() {
		return r0630_3_6months;
	}
	public void setR0630_3_6months(BigDecimal r0630_3_6months) {
		this.r0630_3_6months = r0630_3_6months;
	}
	public BigDecimal getR0630_6_12months() {
		return r0630_6_12months;
	}
	public void setR0630_6_12months(BigDecimal r0630_6_12months) {
		this.r0630_6_12months = r0630_6_12months;
	}
	public BigDecimal getR0630_1_2years() {
		return r0630_1_2years;
	}
	public void setR0630_1_2years(BigDecimal r0630_1_2years) {
		this.r0630_1_2years = r0630_1_2years;
	}
	public BigDecimal getR0630_2_3years() {
		return r0630_2_3years;
	}
	public void setR0630_2_3years(BigDecimal r0630_2_3years) {
		this.r0630_2_3years = r0630_2_3years;
	}
	public BigDecimal getR0630_3_4years() {
		return r0630_3_4years;
	}
	public void setR0630_3_4years(BigDecimal r0630_3_4years) {
		this.r0630_3_4years = r0630_3_4years;
	}
	public BigDecimal getR0630_4_5years() {
		return r0630_4_5years;
	}
	public void setR0630_4_5years(BigDecimal r0630_4_5years) {
		this.r0630_4_5years = r0630_4_5years;
	}
	public BigDecimal getR0630_5years() {
		return r0630_5years;
	}
	public void setR0630_5years(BigDecimal r0630_5years) {
		this.r0630_5years = r0630_5years;
	}
	public BigDecimal getR0630_non_interest() {
		return r0630_non_interest;
	}
	public void setR0630_non_interest(BigDecimal r0630_non_interest) {
		this.r0630_non_interest = r0630_non_interest;
	}
	public BigDecimal getR0630_total() {
		return r0630_total;
	}
	public void setR0630_total(BigDecimal r0630_total) {
		this.r0630_total = r0630_total;
	}
	public String getR0640_product() {
		return r0640_product;
	}
	public void setR0640_product(String r0640_product) {
		this.r0640_product = r0640_product;
	}
	public BigDecimal getR0640_overdraft() {
		return r0640_overdraft;
	}
	public void setR0640_overdraft(BigDecimal r0640_overdraft) {
		this.r0640_overdraft = r0640_overdraft;
	}
	public BigDecimal getR0640_0_7days() {
		return r0640_0_7days;
	}
	public void setR0640_0_7days(BigDecimal r0640_0_7days) {
		this.r0640_0_7days = r0640_0_7days;
	}
	public BigDecimal getR0640_8_14days() {
		return r0640_8_14days;
	}
	public void setR0640_8_14days(BigDecimal r0640_8_14days) {
		this.r0640_8_14days = r0640_8_14days;
	}
	public BigDecimal getR0640_15days_1months() {
		return r0640_15days_1months;
	}
	public void setR0640_15days_1months(BigDecimal r0640_15days_1months) {
		this.r0640_15days_1months = r0640_15days_1months;
	}
	public BigDecimal getR0640_1_2months() {
		return r0640_1_2months;
	}
	public void setR0640_1_2months(BigDecimal r0640_1_2months) {
		this.r0640_1_2months = r0640_1_2months;
	}
	public BigDecimal getR0640_2_3months() {
		return r0640_2_3months;
	}
	public void setR0640_2_3months(BigDecimal r0640_2_3months) {
		this.r0640_2_3months = r0640_2_3months;
	}
	public BigDecimal getR0640_3_6months() {
		return r0640_3_6months;
	}
	public void setR0640_3_6months(BigDecimal r0640_3_6months) {
		this.r0640_3_6months = r0640_3_6months;
	}
	public BigDecimal getR0640_6_12months() {
		return r0640_6_12months;
	}
	public void setR0640_6_12months(BigDecimal r0640_6_12months) {
		this.r0640_6_12months = r0640_6_12months;
	}
	public BigDecimal getR0640_1_2years() {
		return r0640_1_2years;
	}
	public void setR0640_1_2years(BigDecimal r0640_1_2years) {
		this.r0640_1_2years = r0640_1_2years;
	}
	public BigDecimal getR0640_2_3years() {
		return r0640_2_3years;
	}
	public void setR0640_2_3years(BigDecimal r0640_2_3years) {
		this.r0640_2_3years = r0640_2_3years;
	}
	public BigDecimal getR0640_3_4years() {
		return r0640_3_4years;
	}
	public void setR0640_3_4years(BigDecimal r0640_3_4years) {
		this.r0640_3_4years = r0640_3_4years;
	}
	public BigDecimal getR0640_4_5years() {
		return r0640_4_5years;
	}
	public void setR0640_4_5years(BigDecimal r0640_4_5years) {
		this.r0640_4_5years = r0640_4_5years;
	}
	public BigDecimal getR0640_5years() {
		return r0640_5years;
	}
	public void setR0640_5years(BigDecimal r0640_5years) {
		this.r0640_5years = r0640_5years;
	}
	public BigDecimal getR0640_non_interest() {
		return r0640_non_interest;
	}
	public void setR0640_non_interest(BigDecimal r0640_non_interest) {
		this.r0640_non_interest = r0640_non_interest;
	}
	public BigDecimal getR0640_total() {
		return r0640_total;
	}
	public void setR0640_total(BigDecimal r0640_total) {
		this.r0640_total = r0640_total;
	}
	public String getR0650_product() {
		return r0650_product;
	}
	public void setR0650_product(String r0650_product) {
		this.r0650_product = r0650_product;
	}
	public BigDecimal getR0650_overdraft() {
		return r0650_overdraft;
	}
	public void setR0650_overdraft(BigDecimal r0650_overdraft) {
		this.r0650_overdraft = r0650_overdraft;
	}
	public BigDecimal getR0650_0_7days() {
		return r0650_0_7days;
	}
	public void setR0650_0_7days(BigDecimal r0650_0_7days) {
		this.r0650_0_7days = r0650_0_7days;
	}
	public BigDecimal getR0650_8_14days() {
		return r0650_8_14days;
	}
	public void setR0650_8_14days(BigDecimal r0650_8_14days) {
		this.r0650_8_14days = r0650_8_14days;
	}
	public BigDecimal getR0650_15days_1months() {
		return r0650_15days_1months;
	}
	public void setR0650_15days_1months(BigDecimal r0650_15days_1months) {
		this.r0650_15days_1months = r0650_15days_1months;
	}
	public BigDecimal getR0650_1_2months() {
		return r0650_1_2months;
	}
	public void setR0650_1_2months(BigDecimal r0650_1_2months) {
		this.r0650_1_2months = r0650_1_2months;
	}
	public BigDecimal getR0650_2_3months() {
		return r0650_2_3months;
	}
	public void setR0650_2_3months(BigDecimal r0650_2_3months) {
		this.r0650_2_3months = r0650_2_3months;
	}
	public BigDecimal getR0650_3_6months() {
		return r0650_3_6months;
	}
	public void setR0650_3_6months(BigDecimal r0650_3_6months) {
		this.r0650_3_6months = r0650_3_6months;
	}
	public BigDecimal getR0650_6_12months() {
		return r0650_6_12months;
	}
	public void setR0650_6_12months(BigDecimal r0650_6_12months) {
		this.r0650_6_12months = r0650_6_12months;
	}
	public BigDecimal getR0650_1_2years() {
		return r0650_1_2years;
	}
	public void setR0650_1_2years(BigDecimal r0650_1_2years) {
		this.r0650_1_2years = r0650_1_2years;
	}
	public BigDecimal getR0650_2_3years() {
		return r0650_2_3years;
	}
	public void setR0650_2_3years(BigDecimal r0650_2_3years) {
		this.r0650_2_3years = r0650_2_3years;
	}
	public BigDecimal getR0650_3_4years() {
		return r0650_3_4years;
	}
	public void setR0650_3_4years(BigDecimal r0650_3_4years) {
		this.r0650_3_4years = r0650_3_4years;
	}
	public BigDecimal getR0650_4_5years() {
		return r0650_4_5years;
	}
	public void setR0650_4_5years(BigDecimal r0650_4_5years) {
		this.r0650_4_5years = r0650_4_5years;
	}
	public BigDecimal getR0650_5years() {
		return r0650_5years;
	}
	public void setR0650_5years(BigDecimal r0650_5years) {
		this.r0650_5years = r0650_5years;
	}
	public BigDecimal getR0650_non_interest() {
		return r0650_non_interest;
	}
	public void setR0650_non_interest(BigDecimal r0650_non_interest) {
		this.r0650_non_interest = r0650_non_interest;
	}
	public BigDecimal getR0650_total() {
		return r0650_total;
	}
	public void setR0650_total(BigDecimal r0650_total) {
		this.r0650_total = r0650_total;
	}
	public String getR0660_product() {
		return r0660_product;
	}
	public void setR0660_product(String r0660_product) {
		this.r0660_product = r0660_product;
	}
	public BigDecimal getR0660_overdraft() {
		return r0660_overdraft;
	}
	public void setR0660_overdraft(BigDecimal r0660_overdraft) {
		this.r0660_overdraft = r0660_overdraft;
	}
	public BigDecimal getR0660_0_7days() {
		return r0660_0_7days;
	}
	public void setR0660_0_7days(BigDecimal r0660_0_7days) {
		this.r0660_0_7days = r0660_0_7days;
	}
	public BigDecimal getR0660_8_14days() {
		return r0660_8_14days;
	}
	public void setR0660_8_14days(BigDecimal r0660_8_14days) {
		this.r0660_8_14days = r0660_8_14days;
	}
	public BigDecimal getR0660_15days_1months() {
		return r0660_15days_1months;
	}
	public void setR0660_15days_1months(BigDecimal r0660_15days_1months) {
		this.r0660_15days_1months = r0660_15days_1months;
	}
	public BigDecimal getR0660_1_2months() {
		return r0660_1_2months;
	}
	public void setR0660_1_2months(BigDecimal r0660_1_2months) {
		this.r0660_1_2months = r0660_1_2months;
	}
	public BigDecimal getR0660_2_3months() {
		return r0660_2_3months;
	}
	public void setR0660_2_3months(BigDecimal r0660_2_3months) {
		this.r0660_2_3months = r0660_2_3months;
	}
	public BigDecimal getR0660_3_6months() {
		return r0660_3_6months;
	}
	public void setR0660_3_6months(BigDecimal r0660_3_6months) {
		this.r0660_3_6months = r0660_3_6months;
	}
	public BigDecimal getR0660_6_12months() {
		return r0660_6_12months;
	}
	public void setR0660_6_12months(BigDecimal r0660_6_12months) {
		this.r0660_6_12months = r0660_6_12months;
	}
	public BigDecimal getR0660_1_2years() {
		return r0660_1_2years;
	}
	public void setR0660_1_2years(BigDecimal r0660_1_2years) {
		this.r0660_1_2years = r0660_1_2years;
	}
	public BigDecimal getR0660_2_3years() {
		return r0660_2_3years;
	}
	public void setR0660_2_3years(BigDecimal r0660_2_3years) {
		this.r0660_2_3years = r0660_2_3years;
	}
	public BigDecimal getR0660_3_4years() {
		return r0660_3_4years;
	}
	public void setR0660_3_4years(BigDecimal r0660_3_4years) {
		this.r0660_3_4years = r0660_3_4years;
	}
	public BigDecimal getR0660_4_5years() {
		return r0660_4_5years;
	}
	public void setR0660_4_5years(BigDecimal r0660_4_5years) {
		this.r0660_4_5years = r0660_4_5years;
	}
	public BigDecimal getR0660_5years() {
		return r0660_5years;
	}
	public void setR0660_5years(BigDecimal r0660_5years) {
		this.r0660_5years = r0660_5years;
	}
	public BigDecimal getR0660_non_interest() {
		return r0660_non_interest;
	}
	public void setR0660_non_interest(BigDecimal r0660_non_interest) {
		this.r0660_non_interest = r0660_non_interest;
	}
	public BigDecimal getR0660_total() {
		return r0660_total;
	}
	public void setR0660_total(BigDecimal r0660_total) {
		this.r0660_total = r0660_total;
	}
	public String getR0670_product() {
		return r0670_product;
	}
	public void setR0670_product(String r0670_product) {
		this.r0670_product = r0670_product;
	}
	public BigDecimal getR0670_overdraft() {
		return r0670_overdraft;
	}
	public void setR0670_overdraft(BigDecimal r0670_overdraft) {
		this.r0670_overdraft = r0670_overdraft;
	}
	public BigDecimal getR0670_0_7days() {
		return r0670_0_7days;
	}
	public void setR0670_0_7days(BigDecimal r0670_0_7days) {
		this.r0670_0_7days = r0670_0_7days;
	}
	public BigDecimal getR0670_8_14days() {
		return r0670_8_14days;
	}
	public void setR0670_8_14days(BigDecimal r0670_8_14days) {
		this.r0670_8_14days = r0670_8_14days;
	}
	public BigDecimal getR0670_15days_1months() {
		return r0670_15days_1months;
	}
	public void setR0670_15days_1months(BigDecimal r0670_15days_1months) {
		this.r0670_15days_1months = r0670_15days_1months;
	}
	public BigDecimal getR0670_1_2months() {
		return r0670_1_2months;
	}
	public void setR0670_1_2months(BigDecimal r0670_1_2months) {
		this.r0670_1_2months = r0670_1_2months;
	}
	public BigDecimal getR0670_2_3months() {
		return r0670_2_3months;
	}
	public void setR0670_2_3months(BigDecimal r0670_2_3months) {
		this.r0670_2_3months = r0670_2_3months;
	}
	public BigDecimal getR0670_3_6months() {
		return r0670_3_6months;
	}
	public void setR0670_3_6months(BigDecimal r0670_3_6months) {
		this.r0670_3_6months = r0670_3_6months;
	}
	public BigDecimal getR0670_6_12months() {
		return r0670_6_12months;
	}
	public void setR0670_6_12months(BigDecimal r0670_6_12months) {
		this.r0670_6_12months = r0670_6_12months;
	}
	public BigDecimal getR0670_1_2years() {
		return r0670_1_2years;
	}
	public void setR0670_1_2years(BigDecimal r0670_1_2years) {
		this.r0670_1_2years = r0670_1_2years;
	}
	public BigDecimal getR0670_2_3years() {
		return r0670_2_3years;
	}
	public void setR0670_2_3years(BigDecimal r0670_2_3years) {
		this.r0670_2_3years = r0670_2_3years;
	}
	public BigDecimal getR0670_3_4years() {
		return r0670_3_4years;
	}
	public void setR0670_3_4years(BigDecimal r0670_3_4years) {
		this.r0670_3_4years = r0670_3_4years;
	}
	public BigDecimal getR0670_4_5years() {
		return r0670_4_5years;
	}
	public void setR0670_4_5years(BigDecimal r0670_4_5years) {
		this.r0670_4_5years = r0670_4_5years;
	}
	public BigDecimal getR0670_5years() {
		return r0670_5years;
	}
	public void setR0670_5years(BigDecimal r0670_5years) {
		this.r0670_5years = r0670_5years;
	}
	public BigDecimal getR0670_non_interest() {
		return r0670_non_interest;
	}
	public void setR0670_non_interest(BigDecimal r0670_non_interest) {
		this.r0670_non_interest = r0670_non_interest;
	}
	public BigDecimal getR0670_total() {
		return r0670_total;
	}
	public void setR0670_total(BigDecimal r0670_total) {
		this.r0670_total = r0670_total;
	}
	public String getR0680_product() {
		return r0680_product;
	}
	public void setR0680_product(String r0680_product) {
		this.r0680_product = r0680_product;
	}
	public BigDecimal getR0680_overdraft() {
		return r0680_overdraft;
	}
	public void setR0680_overdraft(BigDecimal r0680_overdraft) {
		this.r0680_overdraft = r0680_overdraft;
	}
	public BigDecimal getR0680_0_7days() {
		return r0680_0_7days;
	}
	public void setR0680_0_7days(BigDecimal r0680_0_7days) {
		this.r0680_0_7days = r0680_0_7days;
	}
	public BigDecimal getR0680_8_14days() {
		return r0680_8_14days;
	}
	public void setR0680_8_14days(BigDecimal r0680_8_14days) {
		this.r0680_8_14days = r0680_8_14days;
	}
	public BigDecimal getR0680_15days_1months() {
		return r0680_15days_1months;
	}
	public void setR0680_15days_1months(BigDecimal r0680_15days_1months) {
		this.r0680_15days_1months = r0680_15days_1months;
	}
	public BigDecimal getR0680_1_2months() {
		return r0680_1_2months;
	}
	public void setR0680_1_2months(BigDecimal r0680_1_2months) {
		this.r0680_1_2months = r0680_1_2months;
	}
	public BigDecimal getR0680_2_3months() {
		return r0680_2_3months;
	}
	public void setR0680_2_3months(BigDecimal r0680_2_3months) {
		this.r0680_2_3months = r0680_2_3months;
	}
	public BigDecimal getR0680_3_6months() {
		return r0680_3_6months;
	}
	public void setR0680_3_6months(BigDecimal r0680_3_6months) {
		this.r0680_3_6months = r0680_3_6months;
	}
	public BigDecimal getR0680_6_12months() {
		return r0680_6_12months;
	}
	public void setR0680_6_12months(BigDecimal r0680_6_12months) {
		this.r0680_6_12months = r0680_6_12months;
	}
	public BigDecimal getR0680_1_2years() {
		return r0680_1_2years;
	}
	public void setR0680_1_2years(BigDecimal r0680_1_2years) {
		this.r0680_1_2years = r0680_1_2years;
	}
	public BigDecimal getR0680_2_3years() {
		return r0680_2_3years;
	}
	public void setR0680_2_3years(BigDecimal r0680_2_3years) {
		this.r0680_2_3years = r0680_2_3years;
	}
	public BigDecimal getR0680_3_4years() {
		return r0680_3_4years;
	}
	public void setR0680_3_4years(BigDecimal r0680_3_4years) {
		this.r0680_3_4years = r0680_3_4years;
	}
	public BigDecimal getR0680_4_5years() {
		return r0680_4_5years;
	}
	public void setR0680_4_5years(BigDecimal r0680_4_5years) {
		this.r0680_4_5years = r0680_4_5years;
	}
	public BigDecimal getR0680_5years() {
		return r0680_5years;
	}
	public void setR0680_5years(BigDecimal r0680_5years) {
		this.r0680_5years = r0680_5years;
	}
	public BigDecimal getR0680_non_interest() {
		return r0680_non_interest;
	}
	public void setR0680_non_interest(BigDecimal r0680_non_interest) {
		this.r0680_non_interest = r0680_non_interest;
	}
	public BigDecimal getR0680_total() {
		return r0680_total;
	}
	public void setR0680_total(BigDecimal r0680_total) {
		this.r0680_total = r0680_total;
	}
	public String getR0690_product() {
		return r0690_product;
	}
	public void setR0690_product(String r0690_product) {
		this.r0690_product = r0690_product;
	}
	public BigDecimal getR0690_overdraft() {
		return r0690_overdraft;
	}
	public void setR0690_overdraft(BigDecimal r0690_overdraft) {
		this.r0690_overdraft = r0690_overdraft;
	}
	public BigDecimal getR0690_0_7days() {
		return r0690_0_7days;
	}
	public void setR0690_0_7days(BigDecimal r0690_0_7days) {
		this.r0690_0_7days = r0690_0_7days;
	}
	public BigDecimal getR0690_8_14days() {
		return r0690_8_14days;
	}
	public void setR0690_8_14days(BigDecimal r0690_8_14days) {
		this.r0690_8_14days = r0690_8_14days;
	}
	public BigDecimal getR0690_15days_1months() {
		return r0690_15days_1months;
	}
	public void setR0690_15days_1months(BigDecimal r0690_15days_1months) {
		this.r0690_15days_1months = r0690_15days_1months;
	}
	public BigDecimal getR0690_1_2months() {
		return r0690_1_2months;
	}
	public void setR0690_1_2months(BigDecimal r0690_1_2months) {
		this.r0690_1_2months = r0690_1_2months;
	}
	public BigDecimal getR0690_2_3months() {
		return r0690_2_3months;
	}
	public void setR0690_2_3months(BigDecimal r0690_2_3months) {
		this.r0690_2_3months = r0690_2_3months;
	}
	public BigDecimal getR0690_3_6months() {
		return r0690_3_6months;
	}
	public void setR0690_3_6months(BigDecimal r0690_3_6months) {
		this.r0690_3_6months = r0690_3_6months;
	}
	public BigDecimal getR0690_6_12months() {
		return r0690_6_12months;
	}
	public void setR0690_6_12months(BigDecimal r0690_6_12months) {
		this.r0690_6_12months = r0690_6_12months;
	}
	public BigDecimal getR0690_1_2years() {
		return r0690_1_2years;
	}
	public void setR0690_1_2years(BigDecimal r0690_1_2years) {
		this.r0690_1_2years = r0690_1_2years;
	}
	public BigDecimal getR0690_2_3years() {
		return r0690_2_3years;
	}
	public void setR0690_2_3years(BigDecimal r0690_2_3years) {
		this.r0690_2_3years = r0690_2_3years;
	}
	public BigDecimal getR0690_3_4years() {
		return r0690_3_4years;
	}
	public void setR0690_3_4years(BigDecimal r0690_3_4years) {
		this.r0690_3_4years = r0690_3_4years;
	}
	public BigDecimal getR0690_4_5years() {
		return r0690_4_5years;
	}
	public void setR0690_4_5years(BigDecimal r0690_4_5years) {
		this.r0690_4_5years = r0690_4_5years;
	}
	public BigDecimal getR0690_5years() {
		return r0690_5years;
	}
	public void setR0690_5years(BigDecimal r0690_5years) {
		this.r0690_5years = r0690_5years;
	}
	public BigDecimal getR0690_non_interest() {
		return r0690_non_interest;
	}
	public void setR0690_non_interest(BigDecimal r0690_non_interest) {
		this.r0690_non_interest = r0690_non_interest;
	}
	public BigDecimal getR0690_total() {
		return r0690_total;
	}
	public void setR0690_total(BigDecimal r0690_total) {
		this.r0690_total = r0690_total;
	}
	public String getR0700_product() {
		return r0700_product;
	}
	public void setR0700_product(String r0700_product) {
		this.r0700_product = r0700_product;
	}
	public BigDecimal getR0700_overdraft() {
		return r0700_overdraft;
	}
	public void setR0700_overdraft(BigDecimal r0700_overdraft) {
		this.r0700_overdraft = r0700_overdraft;
	}
	public BigDecimal getR0700_0_7days() {
		return r0700_0_7days;
	}
	public void setR0700_0_7days(BigDecimal r0700_0_7days) {
		this.r0700_0_7days = r0700_0_7days;
	}
	public BigDecimal getR0700_8_14days() {
		return r0700_8_14days;
	}
	public void setR0700_8_14days(BigDecimal r0700_8_14days) {
		this.r0700_8_14days = r0700_8_14days;
	}
	public BigDecimal getR0700_15days_1months() {
		return r0700_15days_1months;
	}
	public void setR0700_15days_1months(BigDecimal r0700_15days_1months) {
		this.r0700_15days_1months = r0700_15days_1months;
	}
	public BigDecimal getR0700_1_2months() {
		return r0700_1_2months;
	}
	public void setR0700_1_2months(BigDecimal r0700_1_2months) {
		this.r0700_1_2months = r0700_1_2months;
	}
	public BigDecimal getR0700_2_3months() {
		return r0700_2_3months;
	}
	public void setR0700_2_3months(BigDecimal r0700_2_3months) {
		this.r0700_2_3months = r0700_2_3months;
	}
	public BigDecimal getR0700_3_6months() {
		return r0700_3_6months;
	}
	public void setR0700_3_6months(BigDecimal r0700_3_6months) {
		this.r0700_3_6months = r0700_3_6months;
	}
	public BigDecimal getR0700_6_12months() {
		return r0700_6_12months;
	}
	public void setR0700_6_12months(BigDecimal r0700_6_12months) {
		this.r0700_6_12months = r0700_6_12months;
	}
	public BigDecimal getR0700_1_2years() {
		return r0700_1_2years;
	}
	public void setR0700_1_2years(BigDecimal r0700_1_2years) {
		this.r0700_1_2years = r0700_1_2years;
	}
	public BigDecimal getR0700_2_3years() {
		return r0700_2_3years;
	}
	public void setR0700_2_3years(BigDecimal r0700_2_3years) {
		this.r0700_2_3years = r0700_2_3years;
	}
	public BigDecimal getR0700_3_4years() {
		return r0700_3_4years;
	}
	public void setR0700_3_4years(BigDecimal r0700_3_4years) {
		this.r0700_3_4years = r0700_3_4years;
	}
	public BigDecimal getR0700_4_5years() {
		return r0700_4_5years;
	}
	public void setR0700_4_5years(BigDecimal r0700_4_5years) {
		this.r0700_4_5years = r0700_4_5years;
	}
	public BigDecimal getR0700_5years() {
		return r0700_5years;
	}
	public void setR0700_5years(BigDecimal r0700_5years) {
		this.r0700_5years = r0700_5years;
	}
	public BigDecimal getR0700_non_interest() {
		return r0700_non_interest;
	}
	public void setR0700_non_interest(BigDecimal r0700_non_interest) {
		this.r0700_non_interest = r0700_non_interest;
	}
	public BigDecimal getR0700_total() {
		return r0700_total;
	}
	public void setR0700_total(BigDecimal r0700_total) {
		this.r0700_total = r0700_total;
	}
	public String getR0710_product() {
		return r0710_product;
	}
	public void setR0710_product(String r0710_product) {
		this.r0710_product = r0710_product;
	}
	public BigDecimal getR0710_overdraft() {
		return r0710_overdraft;
	}
	public void setR0710_overdraft(BigDecimal r0710_overdraft) {
		this.r0710_overdraft = r0710_overdraft;
	}
	public BigDecimal getR0710_0_7days() {
		return r0710_0_7days;
	}
	public void setR0710_0_7days(BigDecimal r0710_0_7days) {
		this.r0710_0_7days = r0710_0_7days;
	}
	public BigDecimal getR0710_8_14days() {
		return r0710_8_14days;
	}
	public void setR0710_8_14days(BigDecimal r0710_8_14days) {
		this.r0710_8_14days = r0710_8_14days;
	}
	public BigDecimal getR0710_15days_1months() {
		return r0710_15days_1months;
	}
	public void setR0710_15days_1months(BigDecimal r0710_15days_1months) {
		this.r0710_15days_1months = r0710_15days_1months;
	}
	public BigDecimal getR0710_1_2months() {
		return r0710_1_2months;
	}
	public void setR0710_1_2months(BigDecimal r0710_1_2months) {
		this.r0710_1_2months = r0710_1_2months;
	}
	public BigDecimal getR0710_2_3months() {
		return r0710_2_3months;
	}
	public void setR0710_2_3months(BigDecimal r0710_2_3months) {
		this.r0710_2_3months = r0710_2_3months;
	}
	public BigDecimal getR0710_3_6months() {
		return r0710_3_6months;
	}
	public void setR0710_3_6months(BigDecimal r0710_3_6months) {
		this.r0710_3_6months = r0710_3_6months;
	}
	public BigDecimal getR0710_6_12months() {
		return r0710_6_12months;
	}
	public void setR0710_6_12months(BigDecimal r0710_6_12months) {
		this.r0710_6_12months = r0710_6_12months;
	}
	public BigDecimal getR0710_1_2years() {
		return r0710_1_2years;
	}
	public void setR0710_1_2years(BigDecimal r0710_1_2years) {
		this.r0710_1_2years = r0710_1_2years;
	}
	public BigDecimal getR0710_2_3years() {
		return r0710_2_3years;
	}
	public void setR0710_2_3years(BigDecimal r0710_2_3years) {
		this.r0710_2_3years = r0710_2_3years;
	}
	public BigDecimal getR0710_3_4years() {
		return r0710_3_4years;
	}
	public void setR0710_3_4years(BigDecimal r0710_3_4years) {
		this.r0710_3_4years = r0710_3_4years;
	}
	public BigDecimal getR0710_4_5years() {
		return r0710_4_5years;
	}
	public void setR0710_4_5years(BigDecimal r0710_4_5years) {
		this.r0710_4_5years = r0710_4_5years;
	}
	public BigDecimal getR0710_5years() {
		return r0710_5years;
	}
	public void setR0710_5years(BigDecimal r0710_5years) {
		this.r0710_5years = r0710_5years;
	}
	public BigDecimal getR0710_non_interest() {
		return r0710_non_interest;
	}
	public void setR0710_non_interest(BigDecimal r0710_non_interest) {
		this.r0710_non_interest = r0710_non_interest;
	}
	public BigDecimal getR0710_total() {
		return r0710_total;
	}
	public void setR0710_total(BigDecimal r0710_total) {
		this.r0710_total = r0710_total;
	}
	public String getR0720_product() {
		return r0720_product;
	}
	public void setR0720_product(String r0720_product) {
		this.r0720_product = r0720_product;
	}
	public BigDecimal getR0720_overdraft() {
		return r0720_overdraft;
	}
	public void setR0720_overdraft(BigDecimal r0720_overdraft) {
		this.r0720_overdraft = r0720_overdraft;
	}
	public BigDecimal getR0720_0_7days() {
		return r0720_0_7days;
	}
	public void setR0720_0_7days(BigDecimal r0720_0_7days) {
		this.r0720_0_7days = r0720_0_7days;
	}
	public BigDecimal getR0720_8_14days() {
		return r0720_8_14days;
	}
	public void setR0720_8_14days(BigDecimal r0720_8_14days) {
		this.r0720_8_14days = r0720_8_14days;
	}
	public BigDecimal getR0720_15days_1months() {
		return r0720_15days_1months;
	}
	public void setR0720_15days_1months(BigDecimal r0720_15days_1months) {
		this.r0720_15days_1months = r0720_15days_1months;
	}
	public BigDecimal getR0720_1_2months() {
		return r0720_1_2months;
	}
	public void setR0720_1_2months(BigDecimal r0720_1_2months) {
		this.r0720_1_2months = r0720_1_2months;
	}
	public BigDecimal getR0720_2_3months() {
		return r0720_2_3months;
	}
	public void setR0720_2_3months(BigDecimal r0720_2_3months) {
		this.r0720_2_3months = r0720_2_3months;
	}
	public BigDecimal getR0720_3_6months() {
		return r0720_3_6months;
	}
	public void setR0720_3_6months(BigDecimal r0720_3_6months) {
		this.r0720_3_6months = r0720_3_6months;
	}
	public BigDecimal getR0720_6_12months() {
		return r0720_6_12months;
	}
	public void setR0720_6_12months(BigDecimal r0720_6_12months) {
		this.r0720_6_12months = r0720_6_12months;
	}
	public BigDecimal getR0720_1_2years() {
		return r0720_1_2years;
	}
	public void setR0720_1_2years(BigDecimal r0720_1_2years) {
		this.r0720_1_2years = r0720_1_2years;
	}
	public BigDecimal getR0720_2_3years() {
		return r0720_2_3years;
	}
	public void setR0720_2_3years(BigDecimal r0720_2_3years) {
		this.r0720_2_3years = r0720_2_3years;
	}
	public BigDecimal getR0720_3_4years() {
		return r0720_3_4years;
	}
	public void setR0720_3_4years(BigDecimal r0720_3_4years) {
		this.r0720_3_4years = r0720_3_4years;
	}
	public BigDecimal getR0720_4_5years() {
		return r0720_4_5years;
	}
	public void setR0720_4_5years(BigDecimal r0720_4_5years) {
		this.r0720_4_5years = r0720_4_5years;
	}
	public BigDecimal getR0720_5years() {
		return r0720_5years;
	}
	public void setR0720_5years(BigDecimal r0720_5years) {
		this.r0720_5years = r0720_5years;
	}
	public BigDecimal getR0720_non_interest() {
		return r0720_non_interest;
	}
	public void setR0720_non_interest(BigDecimal r0720_non_interest) {
		this.r0720_non_interest = r0720_non_interest;
	}
	public BigDecimal getR0720_total() {
		return r0720_total;
	}
	public void setR0720_total(BigDecimal r0720_total) {
		this.r0720_total = r0720_total;
	}
	public String getR0730_product() {
		return r0730_product;
	}
	public void setR0730_product(String r0730_product) {
		this.r0730_product = r0730_product;
	}
	public BigDecimal getR0730_overdraft() {
		return r0730_overdraft;
	}
	public void setR0730_overdraft(BigDecimal r0730_overdraft) {
		this.r0730_overdraft = r0730_overdraft;
	}
	public BigDecimal getR0730_0_7days() {
		return r0730_0_7days;
	}
	public void setR0730_0_7days(BigDecimal r0730_0_7days) {
		this.r0730_0_7days = r0730_0_7days;
	}
	public BigDecimal getR0730_8_14days() {
		return r0730_8_14days;
	}
	public void setR0730_8_14days(BigDecimal r0730_8_14days) {
		this.r0730_8_14days = r0730_8_14days;
	}
	public BigDecimal getR0730_15days_1months() {
		return r0730_15days_1months;
	}
	public void setR0730_15days_1months(BigDecimal r0730_15days_1months) {
		this.r0730_15days_1months = r0730_15days_1months;
	}
	public BigDecimal getR0730_1_2months() {
		return r0730_1_2months;
	}
	public void setR0730_1_2months(BigDecimal r0730_1_2months) {
		this.r0730_1_2months = r0730_1_2months;
	}
	public BigDecimal getR0730_2_3months() {
		return r0730_2_3months;
	}
	public void setR0730_2_3months(BigDecimal r0730_2_3months) {
		this.r0730_2_3months = r0730_2_3months;
	}
	public BigDecimal getR0730_3_6months() {
		return r0730_3_6months;
	}
	public void setR0730_3_6months(BigDecimal r0730_3_6months) {
		this.r0730_3_6months = r0730_3_6months;
	}
	public BigDecimal getR0730_6_12months() {
		return r0730_6_12months;
	}
	public void setR0730_6_12months(BigDecimal r0730_6_12months) {
		this.r0730_6_12months = r0730_6_12months;
	}
	public BigDecimal getR0730_1_2years() {
		return r0730_1_2years;
	}
	public void setR0730_1_2years(BigDecimal r0730_1_2years) {
		this.r0730_1_2years = r0730_1_2years;
	}
	public BigDecimal getR0730_2_3years() {
		return r0730_2_3years;
	}
	public void setR0730_2_3years(BigDecimal r0730_2_3years) {
		this.r0730_2_3years = r0730_2_3years;
	}
	public BigDecimal getR0730_3_4years() {
		return r0730_3_4years;
	}
	public void setR0730_3_4years(BigDecimal r0730_3_4years) {
		this.r0730_3_4years = r0730_3_4years;
	}
	public BigDecimal getR0730_4_5years() {
		return r0730_4_5years;
	}
	public void setR0730_4_5years(BigDecimal r0730_4_5years) {
		this.r0730_4_5years = r0730_4_5years;
	}
	public BigDecimal getR0730_5years() {
		return r0730_5years;
	}
	public void setR0730_5years(BigDecimal r0730_5years) {
		this.r0730_5years = r0730_5years;
	}
	public BigDecimal getR0730_non_interest() {
		return r0730_non_interest;
	}
	public void setR0730_non_interest(BigDecimal r0730_non_interest) {
		this.r0730_non_interest = r0730_non_interest;
	}
	public BigDecimal getR0730_total() {
		return r0730_total;
	}
	public void setR0730_total(BigDecimal r0730_total) {
		this.r0730_total = r0730_total;
	}
	public String getR0740_product() {
		return r0740_product;
	}
	public void setR0740_product(String r0740_product) {
		this.r0740_product = r0740_product;
	}
	public BigDecimal getR0740_overdraft() {
		return r0740_overdraft;
	}
	public void setR0740_overdraft(BigDecimal r0740_overdraft) {
		this.r0740_overdraft = r0740_overdraft;
	}
	public BigDecimal getR0740_0_7days() {
		return r0740_0_7days;
	}
	public void setR0740_0_7days(BigDecimal r0740_0_7days) {
		this.r0740_0_7days = r0740_0_7days;
	}
	public BigDecimal getR0740_8_14days() {
		return r0740_8_14days;
	}
	public void setR0740_8_14days(BigDecimal r0740_8_14days) {
		this.r0740_8_14days = r0740_8_14days;
	}
	public BigDecimal getR0740_15days_1months() {
		return r0740_15days_1months;
	}
	public void setR0740_15days_1months(BigDecimal r0740_15days_1months) {
		this.r0740_15days_1months = r0740_15days_1months;
	}
	public BigDecimal getR0740_1_2months() {
		return r0740_1_2months;
	}
	public void setR0740_1_2months(BigDecimal r0740_1_2months) {
		this.r0740_1_2months = r0740_1_2months;
	}
	public BigDecimal getR0740_2_3months() {
		return r0740_2_3months;
	}
	public void setR0740_2_3months(BigDecimal r0740_2_3months) {
		this.r0740_2_3months = r0740_2_3months;
	}
	public BigDecimal getR0740_3_6months() {
		return r0740_3_6months;
	}
	public void setR0740_3_6months(BigDecimal r0740_3_6months) {
		this.r0740_3_6months = r0740_3_6months;
	}
	public BigDecimal getR0740_6_12months() {
		return r0740_6_12months;
	}
	public void setR0740_6_12months(BigDecimal r0740_6_12months) {
		this.r0740_6_12months = r0740_6_12months;
	}
	public BigDecimal getR0740_1_2years() {
		return r0740_1_2years;
	}
	public void setR0740_1_2years(BigDecimal r0740_1_2years) {
		this.r0740_1_2years = r0740_1_2years;
	}
	public BigDecimal getR0740_2_3years() {
		return r0740_2_3years;
	}
	public void setR0740_2_3years(BigDecimal r0740_2_3years) {
		this.r0740_2_3years = r0740_2_3years;
	}
	public BigDecimal getR0740_3_4years() {
		return r0740_3_4years;
	}
	public void setR0740_3_4years(BigDecimal r0740_3_4years) {
		this.r0740_3_4years = r0740_3_4years;
	}
	public BigDecimal getR0740_4_5years() {
		return r0740_4_5years;
	}
	public void setR0740_4_5years(BigDecimal r0740_4_5years) {
		this.r0740_4_5years = r0740_4_5years;
	}
	public BigDecimal getR0740_5years() {
		return r0740_5years;
	}
	public void setR0740_5years(BigDecimal r0740_5years) {
		this.r0740_5years = r0740_5years;
	}
	public BigDecimal getR0740_non_interest() {
		return r0740_non_interest;
	}
	public void setR0740_non_interest(BigDecimal r0740_non_interest) {
		this.r0740_non_interest = r0740_non_interest;
	}
	public BigDecimal getR0740_total() {
		return r0740_total;
	}
	public void setR0740_total(BigDecimal r0740_total) {
		this.r0740_total = r0740_total;
	}
	public String getR0750_product() {
		return r0750_product;
	}
	public void setR0750_product(String r0750_product) {
		this.r0750_product = r0750_product;
	}
	public BigDecimal getR0750_overdraft() {
		return r0750_overdraft;
	}
	public void setR0750_overdraft(BigDecimal r0750_overdraft) {
		this.r0750_overdraft = r0750_overdraft;
	}
	public BigDecimal getR0750_0_7days() {
		return r0750_0_7days;
	}
	public void setR0750_0_7days(BigDecimal r0750_0_7days) {
		this.r0750_0_7days = r0750_0_7days;
	}
	public BigDecimal getR0750_8_14days() {
		return r0750_8_14days;
	}
	public void setR0750_8_14days(BigDecimal r0750_8_14days) {
		this.r0750_8_14days = r0750_8_14days;
	}
	public BigDecimal getR0750_15days_1months() {
		return r0750_15days_1months;
	}
	public void setR0750_15days_1months(BigDecimal r0750_15days_1months) {
		this.r0750_15days_1months = r0750_15days_1months;
	}
	public BigDecimal getR0750_1_2months() {
		return r0750_1_2months;
	}
	public void setR0750_1_2months(BigDecimal r0750_1_2months) {
		this.r0750_1_2months = r0750_1_2months;
	}
	public BigDecimal getR0750_2_3months() {
		return r0750_2_3months;
	}
	public void setR0750_2_3months(BigDecimal r0750_2_3months) {
		this.r0750_2_3months = r0750_2_3months;
	}
	public BigDecimal getR0750_3_6months() {
		return r0750_3_6months;
	}
	public void setR0750_3_6months(BigDecimal r0750_3_6months) {
		this.r0750_3_6months = r0750_3_6months;
	}
	public BigDecimal getR0750_6_12months() {
		return r0750_6_12months;
	}
	public void setR0750_6_12months(BigDecimal r0750_6_12months) {
		this.r0750_6_12months = r0750_6_12months;
	}
	public BigDecimal getR0750_1_2years() {
		return r0750_1_2years;
	}
	public void setR0750_1_2years(BigDecimal r0750_1_2years) {
		this.r0750_1_2years = r0750_1_2years;
	}
	public BigDecimal getR0750_2_3years() {
		return r0750_2_3years;
	}
	public void setR0750_2_3years(BigDecimal r0750_2_3years) {
		this.r0750_2_3years = r0750_2_3years;
	}
	public BigDecimal getR0750_3_4years() {
		return r0750_3_4years;
	}
	public void setR0750_3_4years(BigDecimal r0750_3_4years) {
		this.r0750_3_4years = r0750_3_4years;
	}
	public BigDecimal getR0750_4_5years() {
		return r0750_4_5years;
	}
	public void setR0750_4_5years(BigDecimal r0750_4_5years) {
		this.r0750_4_5years = r0750_4_5years;
	}
	public BigDecimal getR0750_5years() {
		return r0750_5years;
	}
	public void setR0750_5years(BigDecimal r0750_5years) {
		this.r0750_5years = r0750_5years;
	}
	public BigDecimal getR0750_non_interest() {
		return r0750_non_interest;
	}
	public void setR0750_non_interest(BigDecimal r0750_non_interest) {
		this.r0750_non_interest = r0750_non_interest;
	}
	public BigDecimal getR0750_total() {
		return r0750_total;
	}
	public void setR0750_total(BigDecimal r0750_total) {
		this.r0750_total = r0750_total;
	}
	public String getR0760_product() {
		return r0760_product;
	}
	public void setR0760_product(String r0760_product) {
		this.r0760_product = r0760_product;
	}
	public BigDecimal getR0760_overdraft() {
		return r0760_overdraft;
	}
	public void setR0760_overdraft(BigDecimal r0760_overdraft) {
		this.r0760_overdraft = r0760_overdraft;
	}
	public BigDecimal getR0760_0_7days() {
		return r0760_0_7days;
	}
	public void setR0760_0_7days(BigDecimal r0760_0_7days) {
		this.r0760_0_7days = r0760_0_7days;
	}
	public BigDecimal getR0760_8_14days() {
		return r0760_8_14days;
	}
	public void setR0760_8_14days(BigDecimal r0760_8_14days) {
		this.r0760_8_14days = r0760_8_14days;
	}
	public BigDecimal getR0760_15days_1months() {
		return r0760_15days_1months;
	}
	public void setR0760_15days_1months(BigDecimal r0760_15days_1months) {
		this.r0760_15days_1months = r0760_15days_1months;
	}
	public BigDecimal getR0760_1_2months() {
		return r0760_1_2months;
	}
	public void setR0760_1_2months(BigDecimal r0760_1_2months) {
		this.r0760_1_2months = r0760_1_2months;
	}
	public BigDecimal getR0760_2_3months() {
		return r0760_2_3months;
	}
	public void setR0760_2_3months(BigDecimal r0760_2_3months) {
		this.r0760_2_3months = r0760_2_3months;
	}
	public BigDecimal getR0760_3_6months() {
		return r0760_3_6months;
	}
	public void setR0760_3_6months(BigDecimal r0760_3_6months) {
		this.r0760_3_6months = r0760_3_6months;
	}
	public BigDecimal getR0760_6_12months() {
		return r0760_6_12months;
	}
	public void setR0760_6_12months(BigDecimal r0760_6_12months) {
		this.r0760_6_12months = r0760_6_12months;
	}
	public BigDecimal getR0760_1_2years() {
		return r0760_1_2years;
	}
	public void setR0760_1_2years(BigDecimal r0760_1_2years) {
		this.r0760_1_2years = r0760_1_2years;
	}
	public BigDecimal getR0760_2_3years() {
		return r0760_2_3years;
	}
	public void setR0760_2_3years(BigDecimal r0760_2_3years) {
		this.r0760_2_3years = r0760_2_3years;
	}
	public BigDecimal getR0760_3_4years() {
		return r0760_3_4years;
	}
	public void setR0760_3_4years(BigDecimal r0760_3_4years) {
		this.r0760_3_4years = r0760_3_4years;
	}
	public BigDecimal getR0760_4_5years() {
		return r0760_4_5years;
	}
	public void setR0760_4_5years(BigDecimal r0760_4_5years) {
		this.r0760_4_5years = r0760_4_5years;
	}
	public BigDecimal getR0760_5years() {
		return r0760_5years;
	}
	public void setR0760_5years(BigDecimal r0760_5years) {
		this.r0760_5years = r0760_5years;
	}
	public BigDecimal getR0760_non_interest() {
		return r0760_non_interest;
	}
	public void setR0760_non_interest(BigDecimal r0760_non_interest) {
		this.r0760_non_interest = r0760_non_interest;
	}
	public BigDecimal getR0760_total() {
		return r0760_total;
	}
	public void setR0760_total(BigDecimal r0760_total) {
		this.r0760_total = r0760_total;
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
	public CBUAE_BRF2_5_SUMMARY_ENTITY2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
