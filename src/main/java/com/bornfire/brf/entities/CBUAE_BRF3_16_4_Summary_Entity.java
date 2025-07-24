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
@Table(name = "CBUAE_BRF3_16_4_SUMMARYTABLE")
public class CBUAE_BRF3_16_4_Summary_Entity {
	private String	r0010_lfi_type;
	private String	r0020_lfi_name;
	private String	r0030_consumer_name;
	private String	r0040_service_request_number;
	private String	r0050_people_of_determination;
	private String	r0060_consumer_type;
	private String	r0070_residence_type;
	private String	r0080_emirates_id_only_for_resident_customer;
	private String	r0090_trade_license_no;
	private String	r0100_passport_no_for_resident_and_non_resident;
	private String	r0110_nationality;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0120_date_of_birth;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0130_complaint_creation_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0140_complaint_closure_date;
	private String	r0150_complaint_ack_duration;
	private String	r0160_complaint_closure_duration;
	private String	r0170_status;
	private String	r0180_complaint_outcome;
	private String	r0190_product;
	private String	r0200_category;
	private String	r0210_complaint_channel;
	private String	r0220_complaint_description;
	private String	r0230_root_cause_analysis_yn;
	private String	r0240_root_cause;
	private String	r0250_financial_redressal_yes_or_no;
	private BigDecimal	r0260_financial_redressal_value_aed;
	private String	r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint;
	private String	r0280_resposible_officer_and_team;
	private String	r0290_escalated_to_sanadak;
	private String	r0300_is_the_complaint_pending_in_court;
	private String	r0310_remarks;
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
	public CBUAE_BRF3_16_4_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CBUAE_BRF3_16_4_Summary_Entity(String r0010_lfi_type, String r0020_lfi_name, String r0030_consumer_name,
			String r0040_service_request_number, String r0050_people_of_determination, String r0060_consumer_type,
			String r0070_residence_type, String r0080_emirates_id_only_for_resident_customer,
			String r0090_trade_license_no, String r0100_passport_no_for_resident_and_non_resident,
			String r0110_nationality, Date r0120_date_of_birth, Date r0130_complaint_creation_date,
			Date r0140_complaint_closure_date, String r0150_complaint_ack_duration,
			String r0160_complaint_closure_duration, String r0170_status, String r0180_complaint_outcome,
			String r0190_product, String r0200_category, String r0210_complaint_channel,
			String r0220_complaint_description, String r0230_root_cause_analysis_yn, String r0240_root_cause,
			String r0250_financial_redressal_yes_or_no, BigDecimal r0260_financial_redressal_value_aed,
			String r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint,
			String r0280_resposible_officer_and_team, String r0290_escalated_to_sanadak,
			String r0300_is_the_complaint_pending_in_court, String r0310_remarks, Date report_date,
			String report_version, String report_frequency, String report_code, String report_desc, String modify_flg,
			String entity_flg, String delete_flg) {
		super();
		this.r0010_lfi_type = r0010_lfi_type;
		this.r0020_lfi_name = r0020_lfi_name;
		this.r0030_consumer_name = r0030_consumer_name;
		this.r0040_service_request_number = r0040_service_request_number;
		this.r0050_people_of_determination = r0050_people_of_determination;
		this.r0060_consumer_type = r0060_consumer_type;
		this.r0070_residence_type = r0070_residence_type;
		this.r0080_emirates_id_only_for_resident_customer = r0080_emirates_id_only_for_resident_customer;
		this.r0090_trade_license_no = r0090_trade_license_no;
		this.r0100_passport_no_for_resident_and_non_resident = r0100_passport_no_for_resident_and_non_resident;
		this.r0110_nationality = r0110_nationality;
		this.r0120_date_of_birth = r0120_date_of_birth;
		this.r0130_complaint_creation_date = r0130_complaint_creation_date;
		this.r0140_complaint_closure_date = r0140_complaint_closure_date;
		this.r0150_complaint_ack_duration = r0150_complaint_ack_duration;
		this.r0160_complaint_closure_duration = r0160_complaint_closure_duration;
		this.r0170_status = r0170_status;
		this.r0180_complaint_outcome = r0180_complaint_outcome;
		this.r0190_product = r0190_product;
		this.r0200_category = r0200_category;
		this.r0210_complaint_channel = r0210_complaint_channel;
		this.r0220_complaint_description = r0220_complaint_description;
		this.r0230_root_cause_analysis_yn = r0230_root_cause_analysis_yn;
		this.r0240_root_cause = r0240_root_cause;
		this.r0250_financial_redressal_yes_or_no = r0250_financial_redressal_yes_or_no;
		this.r0260_financial_redressal_value_aed = r0260_financial_redressal_value_aed;
		this.r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint = r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint;
		this.r0280_resposible_officer_and_team = r0280_resposible_officer_and_team;
		this.r0290_escalated_to_sanadak = r0290_escalated_to_sanadak;
		this.r0300_is_the_complaint_pending_in_court = r0300_is_the_complaint_pending_in_court;
		this.r0310_remarks = r0310_remarks;
		this.report_date = report_date;
		this.report_version = report_version;
		this.report_frequency = report_frequency;
		this.report_code = report_code;
		this.report_desc = report_desc;
		this.modify_flg = modify_flg;
		this.entity_flg = entity_flg;
		this.delete_flg = delete_flg;
	}
	public String getR0010_lfi_type() {
		return r0010_lfi_type;
	}
	public void setR0010_lfi_type(String r0010_lfi_type) {
		this.r0010_lfi_type = r0010_lfi_type;
	}
	public String getR0020_lfi_name() {
		return r0020_lfi_name;
	}
	public void setR0020_lfi_name(String r0020_lfi_name) {
		this.r0020_lfi_name = r0020_lfi_name;
	}
	public String getR0030_consumer_name() {
		return r0030_consumer_name;
	}
	public void setR0030_consumer_name(String r0030_consumer_name) {
		this.r0030_consumer_name = r0030_consumer_name;
	}
	public String getR0040_service_request_number() {
		return r0040_service_request_number;
	}
	public void setR0040_service_request_number(String r0040_service_request_number) {
		this.r0040_service_request_number = r0040_service_request_number;
	}
	public String getR0050_people_of_determination() {
		return r0050_people_of_determination;
	}
	public void setR0050_people_of_determination(String r0050_people_of_determination) {
		this.r0050_people_of_determination = r0050_people_of_determination;
	}
	public String getR0060_consumer_type() {
		return r0060_consumer_type;
	}
	public void setR0060_consumer_type(String r0060_consumer_type) {
		this.r0060_consumer_type = r0060_consumer_type;
	}
	public String getR0070_residence_type() {
		return r0070_residence_type;
	}
	public void setR0070_residence_type(String r0070_residence_type) {
		this.r0070_residence_type = r0070_residence_type;
	}
	public String getR0080_emirates_id_only_for_resident_customer() {
		return r0080_emirates_id_only_for_resident_customer;
	}
	public void setR0080_emirates_id_only_for_resident_customer(String r0080_emirates_id_only_for_resident_customer) {
		this.r0080_emirates_id_only_for_resident_customer = r0080_emirates_id_only_for_resident_customer;
	}
	public String getR0090_trade_license_no() {
		return r0090_trade_license_no;
	}
	public void setR0090_trade_license_no(String r0090_trade_license_no) {
		this.r0090_trade_license_no = r0090_trade_license_no;
	}
	public String getR0100_passport_no_for_resident_and_non_resident() {
		return r0100_passport_no_for_resident_and_non_resident;
	}
	public void setR0100_passport_no_for_resident_and_non_resident(String r0100_passport_no_for_resident_and_non_resident) {
		this.r0100_passport_no_for_resident_and_non_resident = r0100_passport_no_for_resident_and_non_resident;
	}
	public String getR0110_nationality() {
		return r0110_nationality;
	}
	public void setR0110_nationality(String r0110_nationality) {
		this.r0110_nationality = r0110_nationality;
	}
	public Date getR0120_date_of_birth() {
		return r0120_date_of_birth;
	}
	public void setR0120_date_of_birth(Date r0120_date_of_birth) {
		this.r0120_date_of_birth = r0120_date_of_birth;
	}
	public Date getR0130_complaint_creation_date() {
		return r0130_complaint_creation_date;
	}
	public void setR0130_complaint_creation_date(Date r0130_complaint_creation_date) {
		this.r0130_complaint_creation_date = r0130_complaint_creation_date;
	}
	public Date getR0140_complaint_closure_date() {
		return r0140_complaint_closure_date;
	}
	public void setR0140_complaint_closure_date(Date r0140_complaint_closure_date) {
		this.r0140_complaint_closure_date = r0140_complaint_closure_date;
	}
	public String getR0150_complaint_ack_duration() {
		return r0150_complaint_ack_duration;
	}
	public void setR0150_complaint_ack_duration(String r0150_complaint_ack_duration) {
		this.r0150_complaint_ack_duration = r0150_complaint_ack_duration;
	}
	public String getR0160_complaint_closure_duration() {
		return r0160_complaint_closure_duration;
	}
	public void setR0160_complaint_closure_duration(String r0160_complaint_closure_duration) {
		this.r0160_complaint_closure_duration = r0160_complaint_closure_duration;
	}
	public String getR0170_status() {
		return r0170_status;
	}
	public void setR0170_status(String r0170_status) {
		this.r0170_status = r0170_status;
	}
	public String getR0180_complaint_outcome() {
		return r0180_complaint_outcome;
	}
	public void setR0180_complaint_outcome(String r0180_complaint_outcome) {
		this.r0180_complaint_outcome = r0180_complaint_outcome;
	}
	public String getR0190_product() {
		return r0190_product;
	}
	public void setR0190_product(String r0190_product) {
		this.r0190_product = r0190_product;
	}
	public String getR0200_category() {
		return r0200_category;
	}
	public void setR0200_category(String r0200_category) {
		this.r0200_category = r0200_category;
	}
	public String getR0210_complaint_channel() {
		return r0210_complaint_channel;
	}
	public void setR0210_complaint_channel(String r0210_complaint_channel) {
		this.r0210_complaint_channel = r0210_complaint_channel;
	}
	public String getR0220_complaint_description() {
		return r0220_complaint_description;
	}
	public void setR0220_complaint_description(String r0220_complaint_description) {
		this.r0220_complaint_description = r0220_complaint_description;
	}
	public String getR0230_root_cause_analysis_yn() {
		return r0230_root_cause_analysis_yn;
	}
	public void setR0230_root_cause_analysis_yn(String r0230_root_cause_analysis_yn) {
		this.r0230_root_cause_analysis_yn = r0230_root_cause_analysis_yn;
	}
	public String getR0240_root_cause() {
		return r0240_root_cause;
	}
	public void setR0240_root_cause(String r0240_root_cause) {
		this.r0240_root_cause = r0240_root_cause;
	}
	public String getR0250_financial_redressal_yes_or_no() {
		return r0250_financial_redressal_yes_or_no;
	}
	public void setR0250_financial_redressal_yes_or_no(String r0250_financial_redressal_yes_or_no) {
		this.r0250_financial_redressal_yes_or_no = r0250_financial_redressal_yes_or_no;
	}
	public BigDecimal getR0260_financial_redressal_value_aed() {
		return r0260_financial_redressal_value_aed;
	}
	public void setR0260_financial_redressal_value_aed(BigDecimal r0260_financial_redressal_value_aed) {
		this.r0260_financial_redressal_value_aed = r0260_financial_redressal_value_aed;
	}
	public String getR0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint() {
		return r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint;
	}
	public void setR0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint(
			String r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint) {
		this.r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint = r0270_resolution_and_sanadak_details_sharing_to_writing_to_complaint;
	}
	public String getR0280_resposible_officer_and_team() {
		return r0280_resposible_officer_and_team;
	}
	public void setR0280_resposible_officer_and_team(String r0280_resposible_officer_and_team) {
		this.r0280_resposible_officer_and_team = r0280_resposible_officer_and_team;
	}
	public String getR0290_escalated_to_sanadak() {
		return r0290_escalated_to_sanadak;
	}
	public void setR0290_escalated_to_sanadak(String r0290_escalated_to_sanadak) {
		this.r0290_escalated_to_sanadak = r0290_escalated_to_sanadak;
	}
	public String getR0300_is_the_complaint_pending_in_court() {
		return r0300_is_the_complaint_pending_in_court;
	}
	public void setR0300_is_the_complaint_pending_in_court(String r0300_is_the_complaint_pending_in_court) {
		this.r0300_is_the_complaint_pending_in_court = r0300_is_the_complaint_pending_in_court;
	}
	public String getR0310_remarks() {
		return r0310_remarks;
	}
	public void setR0310_remarks(String r0310_remarks) {
		this.r0310_remarks = r0310_remarks;
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

}
