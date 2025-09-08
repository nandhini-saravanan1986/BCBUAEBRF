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
@Table(name = "CBUAE_BRF2_16_ARCHIVALTABLE_SUMMARY")

public class CBUAE_BRF2_16_Archival_Summary_Entity {

	private String r0010_product;
	private String r0020_product;
	private BigDecimal r0020_market_value;
	private BigDecimal r0020_eligible_value;
	private BigDecimal r0020_mv_unencum_sec;
	private BigDecimal r0020_ev_unencum_sec;
	private BigDecimal r0020_mv_unencum_centralbank;
	private BigDecimal r0020_ev_unencum_centralbank;
	private String r0030_product;
	private BigDecimal r0030_market_value;
	private BigDecimal r0030_eligible_value;
	private BigDecimal r0030_mv_unencum_sec;
	private BigDecimal r0030_ev_unencum_sec;
	private BigDecimal r0030_mv_unencum_centralbank;
	private BigDecimal r0030_ev_unencum_centralbank;
	private String r0040_product;
	private BigDecimal r0040_market_value;
	private BigDecimal r0040_eligible_value;
	private BigDecimal r0040_mv_unencum_sec;
	private BigDecimal r0040_ev_unencum_sec;
	private BigDecimal r0040_mv_unencum_centralbank;
	private BigDecimal r0040_ev_unencum_centralbank;
	private String r0050_product;
	private BigDecimal r0050_market_value;
	private BigDecimal r0050_eligible_value;
	private BigDecimal r0050_mv_unencum_sec;
	private BigDecimal r0050_ev_unencum_sec;
	private BigDecimal r0050_mv_unencum_centralbank;
	private BigDecimal r0050_ev_unencum_centralbank;
	private String r0060_product;
	private BigDecimal r0060_market_value;
	private BigDecimal r0060_eligible_value;
	private BigDecimal r0060_mv_unencum_sec;
	private BigDecimal r0060_ev_unencum_sec;
	private BigDecimal r0060_mv_unencum_centralbank;
	private BigDecimal r0060_ev_unencum_centralbank;
	private String r0070_product;
	private BigDecimal r0070_market_value;
	private BigDecimal r0070_eligible_value;
	private BigDecimal r0070_mv_unencum_sec;
	private BigDecimal r0070_ev_unencum_sec;
	private BigDecimal r0070_mv_unencum_centralbank;
	private BigDecimal r0070_ev_unencum_centralbank;
	private String r0080_product;
	private BigDecimal r0080_market_value;
	private BigDecimal r0080_eligible_value;
	private BigDecimal r0080_mv_unencum_sec;
	private BigDecimal r0080_ev_unencum_sec;
	private BigDecimal r0080_mv_unencum_centralbank;
	private BigDecimal r0080_ev_unencum_centralbank;
	private String r0090_product;
	private BigDecimal r0090_market_value;
	private BigDecimal r0090_eligible_value;
	private BigDecimal r0090_mv_unencum_sec;
	private BigDecimal r0090_ev_unencum_sec;
	private BigDecimal r0090_mv_unencum_centralbank;
	private BigDecimal r0090_ev_unencum_centralbank;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date report_date;
	private String report_version;
	private String report_frequency;
	private String report_code;
	private String report_desc;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;

	public String getR0010_product() {
		return r0010_product;
	}

	public void setR0010_product(String r0010_product) {
		this.r0010_product = r0010_product;
	}

	public String getR0020_product() {
		return r0020_product;
	}

	public void setR0020_product(String r0020_product) {
		this.r0020_product = r0020_product;
	}

	public BigDecimal getR0020_market_value() {
		return r0020_market_value;
	}

	public void setR0020_market_value(BigDecimal r0020_market_value) {
		this.r0020_market_value = r0020_market_value;
	}

	public BigDecimal getR0020_eligible_value() {
		return r0020_eligible_value;
	}

	public void setR0020_eligible_value(BigDecimal r0020_eligible_value) {
		this.r0020_eligible_value = r0020_eligible_value;
	}

	public BigDecimal getR0020_mv_unencum_sec() {
		return r0020_mv_unencum_sec;
	}

	public void setR0020_mv_unencum_sec(BigDecimal r0020_mv_unencum_sec) {
		this.r0020_mv_unencum_sec = r0020_mv_unencum_sec;
	}

	public BigDecimal getR0020_ev_unencum_sec() {
		return r0020_ev_unencum_sec;
	}

	public void setR0020_ev_unencum_sec(BigDecimal r0020_ev_unencum_sec) {
		this.r0020_ev_unencum_sec = r0020_ev_unencum_sec;
	}

	public BigDecimal getR0020_mv_unencum_centralbank() {
		return r0020_mv_unencum_centralbank;
	}

	public void setR0020_mv_unencum_centralbank(BigDecimal r0020_mv_unencum_centralbank) {
		this.r0020_mv_unencum_centralbank = r0020_mv_unencum_centralbank;
	}

	public BigDecimal getR0020_ev_unencum_centralbank() {
		return r0020_ev_unencum_centralbank;
	}

	public void setR0020_ev_unencum_centralbank(BigDecimal r0020_ev_unencum_centralbank) {
		this.r0020_ev_unencum_centralbank = r0020_ev_unencum_centralbank;
	}

	public String getR0030_product() {
		return r0030_product;
	}

	public void setR0030_product(String r0030_product) {
		this.r0030_product = r0030_product;
	}

	public BigDecimal getR0030_market_value() {
		return r0030_market_value;
	}

	public void setR0030_market_value(BigDecimal r0030_market_value) {
		this.r0030_market_value = r0030_market_value;
	}

	public BigDecimal getR0030_eligible_value() {
		return r0030_eligible_value;
	}

	public void setR0030_eligible_value(BigDecimal r0030_eligible_value) {
		this.r0030_eligible_value = r0030_eligible_value;
	}

	public BigDecimal getR0030_mv_unencum_sec() {
		return r0030_mv_unencum_sec;
	}

	public void setR0030_mv_unencum_sec(BigDecimal r0030_mv_unencum_sec) {
		this.r0030_mv_unencum_sec = r0030_mv_unencum_sec;
	}

	public BigDecimal getR0030_ev_unencum_sec() {
		return r0030_ev_unencum_sec;
	}

	public void setR0030_ev_unencum_sec(BigDecimal r0030_ev_unencum_sec) {
		this.r0030_ev_unencum_sec = r0030_ev_unencum_sec;
	}

	public BigDecimal getR0030_mv_unencum_centralbank() {
		return r0030_mv_unencum_centralbank;
	}

	public void setR0030_mv_unencum_centralbank(BigDecimal r0030_mv_unencum_centralbank) {
		this.r0030_mv_unencum_centralbank = r0030_mv_unencum_centralbank;
	}

	public BigDecimal getR0030_ev_unencum_centralbank() {
		return r0030_ev_unencum_centralbank;
	}

	public void setR0030_ev_unencum_centralbank(BigDecimal r0030_ev_unencum_centralbank) {
		this.r0030_ev_unencum_centralbank = r0030_ev_unencum_centralbank;
	}

	public String getR0040_product() {
		return r0040_product;
	}

	public void setR0040_product(String r0040_product) {
		this.r0040_product = r0040_product;
	}

	public BigDecimal getR0040_market_value() {
		return r0040_market_value;
	}

	public void setR0040_market_value(BigDecimal r0040_market_value) {
		this.r0040_market_value = r0040_market_value;
	}

	public BigDecimal getR0040_eligible_value() {
		return r0040_eligible_value;
	}

	public void setR0040_eligible_value(BigDecimal r0040_eligible_value) {
		this.r0040_eligible_value = r0040_eligible_value;
	}

	public BigDecimal getR0040_mv_unencum_sec() {
		return r0040_mv_unencum_sec;
	}

	public void setR0040_mv_unencum_sec(BigDecimal r0040_mv_unencum_sec) {
		this.r0040_mv_unencum_sec = r0040_mv_unencum_sec;
	}

	public BigDecimal getR0040_ev_unencum_sec() {
		return r0040_ev_unencum_sec;
	}

	public void setR0040_ev_unencum_sec(BigDecimal r0040_ev_unencum_sec) {
		this.r0040_ev_unencum_sec = r0040_ev_unencum_sec;
	}

	public BigDecimal getR0040_mv_unencum_centralbank() {
		return r0040_mv_unencum_centralbank;
	}

	public void setR0040_mv_unencum_centralbank(BigDecimal r0040_mv_unencum_centralbank) {
		this.r0040_mv_unencum_centralbank = r0040_mv_unencum_centralbank;
	}

	public BigDecimal getR0040_ev_unencum_centralbank() {
		return r0040_ev_unencum_centralbank;
	}

	public void setR0040_ev_unencum_centralbank(BigDecimal r0040_ev_unencum_centralbank) {
		this.r0040_ev_unencum_centralbank = r0040_ev_unencum_centralbank;
	}

	public String getR0050_product() {
		return r0050_product;
	}

	public void setR0050_product(String r0050_product) {
		this.r0050_product = r0050_product;
	}

	public BigDecimal getR0050_market_value() {
		return r0050_market_value;
	}

	public void setR0050_market_value(BigDecimal r0050_market_value) {
		this.r0050_market_value = r0050_market_value;
	}

	public BigDecimal getR0050_eligible_value() {
		return r0050_eligible_value;
	}

	public void setR0050_eligible_value(BigDecimal r0050_eligible_value) {
		this.r0050_eligible_value = r0050_eligible_value;
	}

	public BigDecimal getR0050_mv_unencum_sec() {
		return r0050_mv_unencum_sec;
	}

	public void setR0050_mv_unencum_sec(BigDecimal r0050_mv_unencum_sec) {
		this.r0050_mv_unencum_sec = r0050_mv_unencum_sec;
	}

	public BigDecimal getR0050_ev_unencum_sec() {
		return r0050_ev_unencum_sec;
	}

	public void setR0050_ev_unencum_sec(BigDecimal r0050_ev_unencum_sec) {
		this.r0050_ev_unencum_sec = r0050_ev_unencum_sec;
	}

	public BigDecimal getR0050_mv_unencum_centralbank() {
		return r0050_mv_unencum_centralbank;
	}

	public void setR0050_mv_unencum_centralbank(BigDecimal r0050_mv_unencum_centralbank) {
		this.r0050_mv_unencum_centralbank = r0050_mv_unencum_centralbank;
	}

	public BigDecimal getR0050_ev_unencum_centralbank() {
		return r0050_ev_unencum_centralbank;
	}

	public void setR0050_ev_unencum_centralbank(BigDecimal r0050_ev_unencum_centralbank) {
		this.r0050_ev_unencum_centralbank = r0050_ev_unencum_centralbank;
	}

	public String getR0060_product() {
		return r0060_product;
	}

	public void setR0060_product(String r0060_product) {
		this.r0060_product = r0060_product;
	}

	public BigDecimal getR0060_market_value() {
		return r0060_market_value;
	}

	public void setR0060_market_value(BigDecimal r0060_market_value) {
		this.r0060_market_value = r0060_market_value;
	}

	public BigDecimal getR0060_eligible_value() {
		return r0060_eligible_value;
	}

	public void setR0060_eligible_value(BigDecimal r0060_eligible_value) {
		this.r0060_eligible_value = r0060_eligible_value;
	}

	public BigDecimal getR0060_mv_unencum_sec() {
		return r0060_mv_unencum_sec;
	}

	public void setR0060_mv_unencum_sec(BigDecimal r0060_mv_unencum_sec) {
		this.r0060_mv_unencum_sec = r0060_mv_unencum_sec;
	}

	public BigDecimal getR0060_ev_unencum_sec() {
		return r0060_ev_unencum_sec;
	}

	public void setR0060_ev_unencum_sec(BigDecimal r0060_ev_unencum_sec) {
		this.r0060_ev_unencum_sec = r0060_ev_unencum_sec;
	}

	public BigDecimal getR0060_mv_unencum_centralbank() {
		return r0060_mv_unencum_centralbank;
	}

	public void setR0060_mv_unencum_centralbank(BigDecimal r0060_mv_unencum_centralbank) {
		this.r0060_mv_unencum_centralbank = r0060_mv_unencum_centralbank;
	}

	public BigDecimal getR0060_ev_unencum_centralbank() {
		return r0060_ev_unencum_centralbank;
	}

	public void setR0060_ev_unencum_centralbank(BigDecimal r0060_ev_unencum_centralbank) {
		this.r0060_ev_unencum_centralbank = r0060_ev_unencum_centralbank;
	}

	public String getR0070_product() {
		return r0070_product;
	}

	public void setR0070_product(String r0070_product) {
		this.r0070_product = r0070_product;
	}

	public BigDecimal getR0070_market_value() {
		return r0070_market_value;
	}

	public void setR0070_market_value(BigDecimal r0070_market_value) {
		this.r0070_market_value = r0070_market_value;
	}

	public BigDecimal getR0070_eligible_value() {
		return r0070_eligible_value;
	}

	public void setR0070_eligible_value(BigDecimal r0070_eligible_value) {
		this.r0070_eligible_value = r0070_eligible_value;
	}

	public BigDecimal getR0070_mv_unencum_sec() {
		return r0070_mv_unencum_sec;
	}

	public void setR0070_mv_unencum_sec(BigDecimal r0070_mv_unencum_sec) {
		this.r0070_mv_unencum_sec = r0070_mv_unencum_sec;
	}

	public BigDecimal getR0070_ev_unencum_sec() {
		return r0070_ev_unencum_sec;
	}

	public void setR0070_ev_unencum_sec(BigDecimal r0070_ev_unencum_sec) {
		this.r0070_ev_unencum_sec = r0070_ev_unencum_sec;
	}

	public BigDecimal getR0070_mv_unencum_centralbank() {
		return r0070_mv_unencum_centralbank;
	}

	public void setR0070_mv_unencum_centralbank(BigDecimal r0070_mv_unencum_centralbank) {
		this.r0070_mv_unencum_centralbank = r0070_mv_unencum_centralbank;
	}

	public BigDecimal getR0070_ev_unencum_centralbank() {
		return r0070_ev_unencum_centralbank;
	}

	public void setR0070_ev_unencum_centralbank(BigDecimal r0070_ev_unencum_centralbank) {
		this.r0070_ev_unencum_centralbank = r0070_ev_unencum_centralbank;
	}

	public String getR0080_product() {
		return r0080_product;
	}

	public void setR0080_product(String r0080_product) {
		this.r0080_product = r0080_product;
	}

	public BigDecimal getR0080_market_value() {
		return r0080_market_value;
	}

	public void setR0080_market_value(BigDecimal r0080_market_value) {
		this.r0080_market_value = r0080_market_value;
	}

	public BigDecimal getR0080_eligible_value() {
		return r0080_eligible_value;
	}

	public void setR0080_eligible_value(BigDecimal r0080_eligible_value) {
		this.r0080_eligible_value = r0080_eligible_value;
	}

	public BigDecimal getR0080_mv_unencum_sec() {
		return r0080_mv_unencum_sec;
	}

	public void setR0080_mv_unencum_sec(BigDecimal r0080_mv_unencum_sec) {
		this.r0080_mv_unencum_sec = r0080_mv_unencum_sec;
	}

	public BigDecimal getR0080_ev_unencum_sec() {
		return r0080_ev_unencum_sec;
	}

	public void setR0080_ev_unencum_sec(BigDecimal r0080_ev_unencum_sec) {
		this.r0080_ev_unencum_sec = r0080_ev_unencum_sec;
	}

	public BigDecimal getR0080_mv_unencum_centralbank() {
		return r0080_mv_unencum_centralbank;
	}

	public void setR0080_mv_unencum_centralbank(BigDecimal r0080_mv_unencum_centralbank) {
		this.r0080_mv_unencum_centralbank = r0080_mv_unencum_centralbank;
	}

	public BigDecimal getR0080_ev_unencum_centralbank() {
		return r0080_ev_unencum_centralbank;
	}

	public void setR0080_ev_unencum_centralbank(BigDecimal r0080_ev_unencum_centralbank) {
		this.r0080_ev_unencum_centralbank = r0080_ev_unencum_centralbank;
	}

	public String getR0090_product() {
		return r0090_product;
	}

	public void setR0090_product(String r0090_product) {
		this.r0090_product = r0090_product;
	}

	public BigDecimal getR0090_market_value() {
		return r0090_market_value;
	}

	public void setR0090_market_value(BigDecimal r0090_market_value) {
		this.r0090_market_value = r0090_market_value;
	}

	public BigDecimal getR0090_eligible_value() {
		return r0090_eligible_value;
	}

	public void setR0090_eligible_value(BigDecimal r0090_eligible_value) {
		this.r0090_eligible_value = r0090_eligible_value;
	}

	public BigDecimal getR0090_mv_unencum_sec() {
		return r0090_mv_unencum_sec;
	}

	public void setR0090_mv_unencum_sec(BigDecimal r0090_mv_unencum_sec) {
		this.r0090_mv_unencum_sec = r0090_mv_unencum_sec;
	}

	public BigDecimal getR0090_ev_unencum_sec() {
		return r0090_ev_unencum_sec;
	}

	public void setR0090_ev_unencum_sec(BigDecimal r0090_ev_unencum_sec) {
		this.r0090_ev_unencum_sec = r0090_ev_unencum_sec;
	}

	public BigDecimal getR0090_mv_unencum_centralbank() {
		return r0090_mv_unencum_centralbank;
	}

	public void setR0090_mv_unencum_centralbank(BigDecimal r0090_mv_unencum_centralbank) {
		this.r0090_mv_unencum_centralbank = r0090_mv_unencum_centralbank;
	}

	public BigDecimal getR0090_ev_unencum_centralbank() {
		return r0090_ev_unencum_centralbank;
	}

	public void setR0090_ev_unencum_centralbank(BigDecimal r0090_ev_unencum_centralbank) {
		this.r0090_ev_unencum_centralbank = r0090_ev_unencum_centralbank;
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

	public CBUAE_BRF2_16_Archival_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
