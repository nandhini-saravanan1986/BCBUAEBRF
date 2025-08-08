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
@Table(name = "CBUAE_BRF9_1_SUMMARYTABLE2")

public class CBUAE_BRF9_1_Summary_Entity2 {
	
	private String	remaining_countries;
	private BigDecimal	outward_family1;
	private BigDecimal	outward_investment1;
	private BigDecimal	outward_trade1;
	private BigDecimal	outward_other1;
	private BigDecimal	outward_total1;
	private BigDecimal	inward_family1;
	private BigDecimal	inward_investment1;
	private BigDecimal	inward_trade1;
	private BigDecimal	inward_other1;
	private BigDecimal	inward_total1;
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
	private BigDecimal	outward_family_rem;
	private BigDecimal	outward_investment_rem;
	private BigDecimal	outward_trade_rem;
	private BigDecimal	outward_other_rem;
	private BigDecimal	outward_total_rem;
	private BigDecimal	inward_family_rem;
	private BigDecimal	inward_investment_rem;
	private BigDecimal	inward_trade_rem;
	private BigDecimal	inward_other_rem;
	private BigDecimal	inward_total_rem;
	
	
	public String getRemaining_countries() {
		return remaining_countries;
	}
	public void setRemaining_countries(String remaining_countries) {
		this.remaining_countries = remaining_countries;
	}
	public BigDecimal getOutward_family1() {
		return outward_family1;
	}
	public void setOutward_family1(BigDecimal outward_family1) {
		this.outward_family1 = outward_family1;
	}
	public BigDecimal getOutward_investment1() {
		return outward_investment1;
	}
	public void setOutward_investment1(BigDecimal outward_investment1) {
		this.outward_investment1 = outward_investment1;
	}
	public BigDecimal getOutward_trade1() {
		return outward_trade1;
	}
	public void setOutward_trade1(BigDecimal outward_trade1) {
		this.outward_trade1 = outward_trade1;
	}
	public BigDecimal getOutward_other1() {
		return outward_other1;
	}
	public void setOutward_other1(BigDecimal outward_other1) {
		this.outward_other1 = outward_other1;
	}
	public BigDecimal getOutward_total1() {
		return outward_total1;
	}
	public void setOutward_total1(BigDecimal outward_total1) {
		this.outward_total1 = outward_total1;
	}
	public BigDecimal getInward_family1() {
		return inward_family1;
	}
	public void setInward_family1(BigDecimal inward_family1) {
		this.inward_family1 = inward_family1;
	}
	public BigDecimal getInward_investment1() {
		return inward_investment1;
	}
	public void setInward_investment1(BigDecimal inward_investment1) {
		this.inward_investment1 = inward_investment1;
	}
	public BigDecimal getInward_trade1() {
		return inward_trade1;
	}
	public void setInward_trade1(BigDecimal inward_trade1) {
		this.inward_trade1 = inward_trade1;
	}
	public BigDecimal getInward_other1() {
		return inward_other1;
	}
	public void setInward_other1(BigDecimal inward_other1) {
		this.inward_other1 = inward_other1;
	}
	public BigDecimal getInward_total1() {
		return inward_total1;
	}
	public void setInward_total1(BigDecimal inward_total1) {
		this.inward_total1 = inward_total1;
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
	public BigDecimal getOutward_family_rem() {
		return outward_family_rem;
	}
	public void setOutward_family_rem(BigDecimal outward_family_rem) {
		this.outward_family_rem = outward_family_rem;
	}
	public BigDecimal getOutward_investment_rem() {
		return outward_investment_rem;
	}
	public void setOutward_investment_rem(BigDecimal outward_investment_rem) {
		this.outward_investment_rem = outward_investment_rem;
	}
	public BigDecimal getOutward_trade_rem() {
		return outward_trade_rem;
	}
	public void setOutward_trade_rem(BigDecimal outward_trade_rem) {
		this.outward_trade_rem = outward_trade_rem;
	}
	public BigDecimal getOutward_other_rem() {
		return outward_other_rem;
	}
	public void setOutward_other_rem(BigDecimal outward_other_rem) {
		this.outward_other_rem = outward_other_rem;
	}
	public BigDecimal getOutward_total_rem() {
		return outward_total_rem;
	}
	public void setOutward_total_rem(BigDecimal outward_total_rem) {
		this.outward_total_rem = outward_total_rem;
	}
	public BigDecimal getInward_family_rem() {
		return inward_family_rem;
	}
	public void setInward_family_rem(BigDecimal inward_family_rem) {
		this.inward_family_rem = inward_family_rem;
	}
	public BigDecimal getInward_investment_rem() {
		return inward_investment_rem;
	}
	public void setInward_investment_rem(BigDecimal inward_investment_rem) {
		this.inward_investment_rem = inward_investment_rem;
	}
	public BigDecimal getInward_trade_rem() {
		return inward_trade_rem;
	}
	public void setInward_trade_rem(BigDecimal inward_trade_rem) {
		this.inward_trade_rem = inward_trade_rem;
	}
	public BigDecimal getInward_other_rem() {
		return inward_other_rem;
	}
	public void setInward_other_rem(BigDecimal inward_other_rem) {
		this.inward_other_rem = inward_other_rem;
	}
	public BigDecimal getInward_total_rem() {
		return inward_total_rem;
	}
	public void setInward_total_rem(BigDecimal inward_total_rem) {
		this.inward_total_rem = inward_total_rem;
	}
	
	
	public CBUAE_BRF9_1_Summary_Entity2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
