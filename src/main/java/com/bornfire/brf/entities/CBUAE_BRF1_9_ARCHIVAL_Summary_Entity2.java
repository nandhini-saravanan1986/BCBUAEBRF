package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "CBUAE_BRF1_9_ARCHIVALTABLE_SUMMARY_2")
public class CBUAE_BRF1_9_ARCHIVAL_Summary_Entity2 {

	
	
private String	r0900_asstes;
private BigDecimal	r0900_banking_operations;
private BigDecimal	r0900_banking_subsidiaries_uae;
private BigDecimal	r0900_financial_subsidiary_uae;
private BigDecimal	r0900_financial_subsidiary_outside_uae;
private BigDecimal	r0900_all_other_subsidiary_uae;
private BigDecimal	r0900_all_other_subsidiary_outside_uae;
private BigDecimal	r0900_gross_assets;
private BigDecimal	r0900_elimination;
private BigDecimal	r0900_reclassification;
private BigDecimal	r0900_consolidated_assets;
private String	r0910_asstes;
private BigDecimal	r0910_banking_operations;
private BigDecimal	r0910_banking_subsidiaries_uae;
private BigDecimal	r0910_financial_subsidiary_uae;
private BigDecimal	r0910_financial_subsidiary_outside_uae;
private BigDecimal	r0910_all_other_subsidiary_uae;
private BigDecimal	r0910_all_other_subsidiary_outside_uae;
private BigDecimal	r0910_gross_assets;
private BigDecimal	r0910_elimination;
private BigDecimal	r0910_reclassification;
private BigDecimal	r0910_consolidated_assets;
private String	r0920_asstes;
private BigDecimal	r0920_banking_operations;
private BigDecimal	r0920_banking_subsidiaries_uae;
private BigDecimal	r0920_financial_subsidiary_uae;
private BigDecimal	r0920_financial_subsidiary_outside_uae;
private BigDecimal	r0920_all_other_subsidiary_uae;
private BigDecimal	r0920_all_other_subsidiary_outside_uae;
private BigDecimal	r0920_gross_assets;
private BigDecimal	r0920_elimination;
private BigDecimal	r0920_reclassification;
private BigDecimal	r0920_consolidated_assets;
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
public String getR0900_asstes() {
	return r0900_asstes;
}
public void setR0900_asstes(String r0900_asstes) {
	this.r0900_asstes = r0900_asstes;
}
public BigDecimal getR0900_banking_operations() {
	return r0900_banking_operations;
}
public void setR0900_banking_operations(BigDecimal r0900_banking_operations) {
	this.r0900_banking_operations = r0900_banking_operations;
}
public BigDecimal getR0900_banking_subsidiaries_uae() {
	return r0900_banking_subsidiaries_uae;
}
public void setR0900_banking_subsidiaries_uae(BigDecimal r0900_banking_subsidiaries_uae) {
	this.r0900_banking_subsidiaries_uae = r0900_banking_subsidiaries_uae;
}
public BigDecimal getR0900_financial_subsidiary_uae() {
	return r0900_financial_subsidiary_uae;
}
public void setR0900_financial_subsidiary_uae(BigDecimal r0900_financial_subsidiary_uae) {
	this.r0900_financial_subsidiary_uae = r0900_financial_subsidiary_uae;
}
public BigDecimal getR0900_financial_subsidiary_outside_uae() {
	return r0900_financial_subsidiary_outside_uae;
}
public void setR0900_financial_subsidiary_outside_uae(BigDecimal r0900_financial_subsidiary_outside_uae) {
	this.r0900_financial_subsidiary_outside_uae = r0900_financial_subsidiary_outside_uae;
}
public BigDecimal getR0900_all_other_subsidiary_uae() {
	return r0900_all_other_subsidiary_uae;
}
public void setR0900_all_other_subsidiary_uae(BigDecimal r0900_all_other_subsidiary_uae) {
	this.r0900_all_other_subsidiary_uae = r0900_all_other_subsidiary_uae;
}
public BigDecimal getR0900_all_other_subsidiary_outside_uae() {
	return r0900_all_other_subsidiary_outside_uae;
}
public void setR0900_all_other_subsidiary_outside_uae(BigDecimal r0900_all_other_subsidiary_outside_uae) {
	this.r0900_all_other_subsidiary_outside_uae = r0900_all_other_subsidiary_outside_uae;
}
public BigDecimal getR0900_gross_assets() {
	return r0900_gross_assets;
}
public void setR0900_gross_assets(BigDecimal r0900_gross_assets) {
	this.r0900_gross_assets = r0900_gross_assets;
}
public BigDecimal getR0900_elimination() {
	return r0900_elimination;
}
public void setR0900_elimination(BigDecimal r0900_elimination) {
	this.r0900_elimination = r0900_elimination;
}
public BigDecimal getR0900_reclassification() {
	return r0900_reclassification;
}
public void setR0900_reclassification(BigDecimal r0900_reclassification) {
	this.r0900_reclassification = r0900_reclassification;
}
public BigDecimal getR0900_consolidated_assets() {
	return r0900_consolidated_assets;
}
public void setR0900_consolidated_assets(BigDecimal r0900_consolidated_assets) {
	this.r0900_consolidated_assets = r0900_consolidated_assets;
}
public String getR0910_asstes() {
	return r0910_asstes;
}
public void setR0910_asstes(String r0910_asstes) {
	this.r0910_asstes = r0910_asstes;
}
public BigDecimal getR0910_banking_operations() {
	return r0910_banking_operations;
}
public void setR0910_banking_operations(BigDecimal r0910_banking_operations) {
	this.r0910_banking_operations = r0910_banking_operations;
}
public BigDecimal getR0910_banking_subsidiaries_uae() {
	return r0910_banking_subsidiaries_uae;
}
public void setR0910_banking_subsidiaries_uae(BigDecimal r0910_banking_subsidiaries_uae) {
	this.r0910_banking_subsidiaries_uae = r0910_banking_subsidiaries_uae;
}
public BigDecimal getR0910_financial_subsidiary_uae() {
	return r0910_financial_subsidiary_uae;
}
public void setR0910_financial_subsidiary_uae(BigDecimal r0910_financial_subsidiary_uae) {
	this.r0910_financial_subsidiary_uae = r0910_financial_subsidiary_uae;
}
public BigDecimal getR0910_financial_subsidiary_outside_uae() {
	return r0910_financial_subsidiary_outside_uae;
}
public void setR0910_financial_subsidiary_outside_uae(BigDecimal r0910_financial_subsidiary_outside_uae) {
	this.r0910_financial_subsidiary_outside_uae = r0910_financial_subsidiary_outside_uae;
}
public BigDecimal getR0910_all_other_subsidiary_uae() {
	return r0910_all_other_subsidiary_uae;
}
public void setR0910_all_other_subsidiary_uae(BigDecimal r0910_all_other_subsidiary_uae) {
	this.r0910_all_other_subsidiary_uae = r0910_all_other_subsidiary_uae;
}
public BigDecimal getR0910_all_other_subsidiary_outside_uae() {
	return r0910_all_other_subsidiary_outside_uae;
}
public void setR0910_all_other_subsidiary_outside_uae(BigDecimal r0910_all_other_subsidiary_outside_uae) {
	this.r0910_all_other_subsidiary_outside_uae = r0910_all_other_subsidiary_outside_uae;
}
public BigDecimal getR0910_gross_assets() {
	return r0910_gross_assets;
}
public void setR0910_gross_assets(BigDecimal r0910_gross_assets) {
	this.r0910_gross_assets = r0910_gross_assets;
}
public BigDecimal getR0910_elimination() {
	return r0910_elimination;
}
public void setR0910_elimination(BigDecimal r0910_elimination) {
	this.r0910_elimination = r0910_elimination;
}
public BigDecimal getR0910_reclassification() {
	return r0910_reclassification;
}
public void setR0910_reclassification(BigDecimal r0910_reclassification) {
	this.r0910_reclassification = r0910_reclassification;
}
public BigDecimal getR0910_consolidated_assets() {
	return r0910_consolidated_assets;
}
public void setR0910_consolidated_assets(BigDecimal r0910_consolidated_assets) {
	this.r0910_consolidated_assets = r0910_consolidated_assets;
}
public String getR0920_asstes() {
	return r0920_asstes;
}
public void setR0920_asstes(String r0920_asstes) {
	this.r0920_asstes = r0920_asstes;
}
public BigDecimal getR0920_banking_operations() {
	return r0920_banking_operations;
}
public void setR0920_banking_operations(BigDecimal r0920_banking_operations) {
	this.r0920_banking_operations = r0920_banking_operations;
}
public BigDecimal getR0920_banking_subsidiaries_uae() {
	return r0920_banking_subsidiaries_uae;
}
public void setR0920_banking_subsidiaries_uae(BigDecimal r0920_banking_subsidiaries_uae) {
	this.r0920_banking_subsidiaries_uae = r0920_banking_subsidiaries_uae;
}
public BigDecimal getR0920_financial_subsidiary_uae() {
	return r0920_financial_subsidiary_uae;
}
public void setR0920_financial_subsidiary_uae(BigDecimal r0920_financial_subsidiary_uae) {
	this.r0920_financial_subsidiary_uae = r0920_financial_subsidiary_uae;
}
public BigDecimal getR0920_financial_subsidiary_outside_uae() {
	return r0920_financial_subsidiary_outside_uae;
}
public void setR0920_financial_subsidiary_outside_uae(BigDecimal r0920_financial_subsidiary_outside_uae) {
	this.r0920_financial_subsidiary_outside_uae = r0920_financial_subsidiary_outside_uae;
}
public BigDecimal getR0920_all_other_subsidiary_uae() {
	return r0920_all_other_subsidiary_uae;
}
public void setR0920_all_other_subsidiary_uae(BigDecimal r0920_all_other_subsidiary_uae) {
	this.r0920_all_other_subsidiary_uae = r0920_all_other_subsidiary_uae;
}
public BigDecimal getR0920_all_other_subsidiary_outside_uae() {
	return r0920_all_other_subsidiary_outside_uae;
}
public void setR0920_all_other_subsidiary_outside_uae(BigDecimal r0920_all_other_subsidiary_outside_uae) {
	this.r0920_all_other_subsidiary_outside_uae = r0920_all_other_subsidiary_outside_uae;
}
public BigDecimal getR0920_gross_assets() {
	return r0920_gross_assets;
}
public void setR0920_gross_assets(BigDecimal r0920_gross_assets) {
	this.r0920_gross_assets = r0920_gross_assets;
}
public BigDecimal getR0920_elimination() {
	return r0920_elimination;
}
public void setR0920_elimination(BigDecimal r0920_elimination) {
	this.r0920_elimination = r0920_elimination;
}
public BigDecimal getR0920_reclassification() {
	return r0920_reclassification;
}
public void setR0920_reclassification(BigDecimal r0920_reclassification) {
	this.r0920_reclassification = r0920_reclassification;
}
public BigDecimal getR0920_consolidated_assets() {
	return r0920_consolidated_assets;
}
public void setR0920_consolidated_assets(BigDecimal r0920_consolidated_assets) {
	this.r0920_consolidated_assets = r0920_consolidated_assets;
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
public CBUAE_BRF1_9_ARCHIVAL_Summary_Entity2() {
	super();
	// TODO Auto-generated constructor stub
}

}
