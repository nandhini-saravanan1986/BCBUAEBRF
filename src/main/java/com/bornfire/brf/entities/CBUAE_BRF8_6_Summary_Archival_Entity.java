
package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CBUAE_BRF8_6_ARCHIVALTABLE_SUMMARY")
public class CBUAE_BRF8_6_Summary_Archival_Entity {
	
	@Id
	private Long	id;
	private String	r0010_outsourced_activity_domain;
	private String	r0020_description_of_outsourced_activity;
	private String	r0030_name_of_institution;
	private String	r0040_department_responsible;
	private String	r0050_outsourcing_activity_core_noncore;
	private String	r0060_cbuae_no_objection_reference;
	private String	r0070_total_number_of_outsourced_jobs;
	private String	r0080_number_of_critical_outsourced_jobs;
	private String	r0090_data_access_by_third_parties;
	private String	r0100_nature_of_data_involved;
	private String	r0110_is_service_provider_owned_by_bank;
	private String	r0120_name_of_vendor;
	private String	r0130_country_of_registration;
	private String	r0140_vendor_lei_or_reg_number;
	private String	r0150_holding_parent_company;
	private String	r0160_countries_service_performed;
	private String	r0170_countries_data_stored;
	private String	r0180_governing_law;
	private BigDecimal	r0190_annual_contract_value_aed;
	private BigDecimal	r0200_total_contract_value_aed;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0210_service_commencement_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0220_service_expiry_date;
	private String	r0230_outcome_of_risk_assessment;
	private String	r0240_substitutability;
	private String	r0250_time_critical_operation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0260_last_audit_date;
	private String	r0270_comments;
	@Column(name = "REPORT_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private String	report_version;
	private String	report_frequency;
	private String	report_code;
	private String	report_desc;
	private String	modify_flg;
	private String	entity_flg;
	private String	delete_flg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getR0010_outsourced_activity_domain() {
		return r0010_outsourced_activity_domain;
	}
	public void setR0010_outsourced_activity_domain(String r0010_outsourced_activity_domain) {
		this.r0010_outsourced_activity_domain = r0010_outsourced_activity_domain;
	}
	public String getR0020_description_of_outsourced_activity() {
		return r0020_description_of_outsourced_activity;
	}
	public void setR0020_description_of_outsourced_activity(String r0020_description_of_outsourced_activity) {
		this.r0020_description_of_outsourced_activity = r0020_description_of_outsourced_activity;
	}
	public String getR0030_name_of_institution() {
		return r0030_name_of_institution;
	}
	public void setR0030_name_of_institution(String r0030_name_of_institution) {
		this.r0030_name_of_institution = r0030_name_of_institution;
	}
	public String getR0040_department_responsible() {
		return r0040_department_responsible;
	}
	public void setR0040_department_responsible(String r0040_department_responsible) {
		this.r0040_department_responsible = r0040_department_responsible;
	}
	public String getR0050_outsourcing_activity_core_noncore() {
		return r0050_outsourcing_activity_core_noncore;
	}
	public void setR0050_outsourcing_activity_core_noncore(String r0050_outsourcing_activity_core_noncore) {
		this.r0050_outsourcing_activity_core_noncore = r0050_outsourcing_activity_core_noncore;
	}
	public String getR0060_cbuae_no_objection_reference() {
		return r0060_cbuae_no_objection_reference;
	}
	public void setR0060_cbuae_no_objection_reference(String r0060_cbuae_no_objection_reference) {
		this.r0060_cbuae_no_objection_reference = r0060_cbuae_no_objection_reference;
	}
	public String getR0070_total_number_of_outsourced_jobs() {
		return r0070_total_number_of_outsourced_jobs;
	}
	public void setR0070_total_number_of_outsourced_jobs(String r0070_total_number_of_outsourced_jobs) {
		this.r0070_total_number_of_outsourced_jobs = r0070_total_number_of_outsourced_jobs;
	}
	public String getR0080_number_of_critical_outsourced_jobs() {
		return r0080_number_of_critical_outsourced_jobs;
	}
	public void setR0080_number_of_critical_outsourced_jobs(String r0080_number_of_critical_outsourced_jobs) {
		this.r0080_number_of_critical_outsourced_jobs = r0080_number_of_critical_outsourced_jobs;
	}
	public String getR0090_data_access_by_third_parties() {
		return r0090_data_access_by_third_parties;
	}
	public void setR0090_data_access_by_third_parties(String r0090_data_access_by_third_parties) {
		this.r0090_data_access_by_third_parties = r0090_data_access_by_third_parties;
	}
	public String getR0100_nature_of_data_involved() {
		return r0100_nature_of_data_involved;
	}
	public void setR0100_nature_of_data_involved(String r0100_nature_of_data_involved) {
		this.r0100_nature_of_data_involved = r0100_nature_of_data_involved;
	}
	public String getR0110_is_service_provider_owned_by_bank() {
		return r0110_is_service_provider_owned_by_bank;
	}
	public void setR0110_is_service_provider_owned_by_bank(String r0110_is_service_provider_owned_by_bank) {
		this.r0110_is_service_provider_owned_by_bank = r0110_is_service_provider_owned_by_bank;
	}
	public String getR0120_name_of_vendor() {
		return r0120_name_of_vendor;
	}
	public void setR0120_name_of_vendor(String r0120_name_of_vendor) {
		this.r0120_name_of_vendor = r0120_name_of_vendor;
	}
	public String getR0130_country_of_registration() {
		return r0130_country_of_registration;
	}
	public void setR0130_country_of_registration(String r0130_country_of_registration) {
		this.r0130_country_of_registration = r0130_country_of_registration;
	}
	public String getR0140_vendor_lei_or_reg_number() {
		return r0140_vendor_lei_or_reg_number;
	}
	public void setR0140_vendor_lei_or_reg_number(String r0140_vendor_lei_or_reg_number) {
		this.r0140_vendor_lei_or_reg_number = r0140_vendor_lei_or_reg_number;
	}
	public String getR0150_holding_parent_company() {
		return r0150_holding_parent_company;
	}
	public void setR0150_holding_parent_company(String r0150_holding_parent_company) {
		this.r0150_holding_parent_company = r0150_holding_parent_company;
	}
	public String getR0160_countries_service_performed() {
		return r0160_countries_service_performed;
	}
	public void setR0160_countries_service_performed(String r0160_countries_service_performed) {
		this.r0160_countries_service_performed = r0160_countries_service_performed;
	}
	public String getR0170_countries_data_stored() {
		return r0170_countries_data_stored;
	}
	public void setR0170_countries_data_stored(String r0170_countries_data_stored) {
		this.r0170_countries_data_stored = r0170_countries_data_stored;
	}
	public String getR0180_governing_law() {
		return r0180_governing_law;
	}
	public void setR0180_governing_law(String r0180_governing_law) {
		this.r0180_governing_law = r0180_governing_law;
	}
	public BigDecimal getR0190_annual_contract_value_aed() {
		return r0190_annual_contract_value_aed;
	}
	public void setR0190_annual_contract_value_aed(BigDecimal r0190_annual_contract_value_aed) {
		this.r0190_annual_contract_value_aed = r0190_annual_contract_value_aed;
	}
	public BigDecimal getR0200_total_contract_value_aed() {
		return r0200_total_contract_value_aed;
	}
	public void setR0200_total_contract_value_aed(BigDecimal r0200_total_contract_value_aed) {
		this.r0200_total_contract_value_aed = r0200_total_contract_value_aed;
	}
	public Date getR0210_service_commencement_date() {
		return r0210_service_commencement_date;
	}
	public void setR0210_service_commencement_date(Date r0210_service_commencement_date) {
		this.r0210_service_commencement_date = r0210_service_commencement_date;
	}
	public Date getR0220_service_expiry_date() {
		return r0220_service_expiry_date;
	}
	public void setR0220_service_expiry_date(Date r0220_service_expiry_date) {
		this.r0220_service_expiry_date = r0220_service_expiry_date;
	}
	public String getR0230_outcome_of_risk_assessment() {
		return r0230_outcome_of_risk_assessment;
	}
	public void setR0230_outcome_of_risk_assessment(String r0230_outcome_of_risk_assessment) {
		this.r0230_outcome_of_risk_assessment = r0230_outcome_of_risk_assessment;
	}
	public String getR0240_substitutability() {
		return r0240_substitutability;
	}
	public void setR0240_substitutability(String r0240_substitutability) {
		this.r0240_substitutability = r0240_substitutability;
	}
	public String getR0250_time_critical_operation() {
		return r0250_time_critical_operation;
	}
	public void setR0250_time_critical_operation(String r0250_time_critical_operation) {
		this.r0250_time_critical_operation = r0250_time_critical_operation;
	}
	public Date getR0260_last_audit_date() {
		return r0260_last_audit_date;
	}
	public void setR0260_last_audit_date(Date r0260_last_audit_date) {
		this.r0260_last_audit_date = r0260_last_audit_date;
	}
	public String getR0270_comments() {
		return r0270_comments;
	}
	public void setR0270_comments(String r0270_comments) {
		this.r0270_comments = r0270_comments;
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
	public CBUAE_BRF8_6_Summary_Archival_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
