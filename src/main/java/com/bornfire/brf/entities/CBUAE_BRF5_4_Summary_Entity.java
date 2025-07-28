
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
@Table(name = "CBUAE_BRF5_4_SUMMARYTABLE")
public class CBUAE_BRF5_4_Summary_Entity {
	
	@Id
	private Long	id;
	private String	r0010_name_of_the_borrower_group;
	private String	r0020_cin;
	private String	r0030_nature_of_credit_facility_granted;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0040_date_of_disbursement;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	r0050_due_date_of_repayment;
	private BigDecimal	r0060_market_value;
	private BigDecimal	r0070_drawing_power;
	private BigDecimal	r0080_present_outstanding;
	private BigDecimal	r0090_outstanding_as_of_drawing_power;
	private BigDecimal	r0100_excess_over_drawing_power;
	private BigDecimal	r0110_fd_bank_guarantee;
	private BigDecimal	r0120_mortgage_of_real_estate;
	private String	r0130_remarks_status;

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
	public String getR0010_name_of_the_borrower_group() {
		return r0010_name_of_the_borrower_group;
	}
	public void setR0010_name_of_the_borrower_group(String r0010_name_of_the_borrower_group) {
		this.r0010_name_of_the_borrower_group = r0010_name_of_the_borrower_group;
	}
	public String getR0020_cin() {
		return r0020_cin;
	}
	public void setR0020_cin(String r0020_cin) {
		this.r0020_cin = r0020_cin;
	}
	public String getR0030_nature_of_credit_facility_granted() {
		return r0030_nature_of_credit_facility_granted;
	}
	public void setR0030_nature_of_credit_facility_granted(String r0030_nature_of_credit_facility_granted) {
		this.r0030_nature_of_credit_facility_granted = r0030_nature_of_credit_facility_granted;
	}
	public Date getR0040_date_of_disbursement() {
		return r0040_date_of_disbursement;
	}
	public void setR0040_date_of_disbursement(Date r0040_date_of_disbursement) {
		this.r0040_date_of_disbursement = r0040_date_of_disbursement;
	}
	public Date getR0050_due_date_of_repayment() {
		return r0050_due_date_of_repayment;
	}
	public void setR0050_due_date_of_repayment(Date r0050_due_date_of_repayment) {
		this.r0050_due_date_of_repayment = r0050_due_date_of_repayment;
	}
	public BigDecimal getR0060_market_value() {
		return r0060_market_value;
	}
	public void setR0060_market_value(BigDecimal r0060_market_value) {
		this.r0060_market_value = r0060_market_value;
	}
	public BigDecimal getR0070_drawing_power() {
		return r0070_drawing_power;
	}
	public void setR0070_drawing_power(BigDecimal r0070_drawing_power) {
		this.r0070_drawing_power = r0070_drawing_power;
	}
	public BigDecimal getR0080_present_outstanding() {
		return r0080_present_outstanding;
	}
	public void setR0080_present_outstanding(BigDecimal r0080_present_outstanding) {
		this.r0080_present_outstanding = r0080_present_outstanding;
	}
	public BigDecimal getR0090_outstanding_as_of_drawing_power() {
		return r0090_outstanding_as_of_drawing_power;
	}
	public void setR0090_outstanding_as_of_drawing_power(BigDecimal r0090_outstanding_as_of_drawing_power) {
		this.r0090_outstanding_as_of_drawing_power = r0090_outstanding_as_of_drawing_power;
	}
	public BigDecimal getR0100_excess_over_drawing_power() {
		return r0100_excess_over_drawing_power;
	}
	public void setR0100_excess_over_drawing_power(BigDecimal r0100_excess_over_drawing_power) {
		this.r0100_excess_over_drawing_power = r0100_excess_over_drawing_power;
	}
	public BigDecimal getR0110_fd_bank_guarantee() {
		return r0110_fd_bank_guarantee;
	}
	public void setR0110_fd_bank_guarantee(BigDecimal r0110_fd_bank_guarantee) {
		this.r0110_fd_bank_guarantee = r0110_fd_bank_guarantee;
	}
	public BigDecimal getR0120_mortgage_of_real_estate() {
		return r0120_mortgage_of_real_estate;
	}
	public void setR0120_mortgage_of_real_estate(BigDecimal r0120_mortgage_of_real_estate) {
		this.r0120_mortgage_of_real_estate = r0120_mortgage_of_real_estate;
	}
	public String getR0130_remarks_status() {
		return r0130_remarks_status;
	}
	public void setR0130_remarks_status(String r0130_remarks_status) {
		this.r0130_remarks_status = r0130_remarks_status;
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
	public CBUAE_BRF5_4_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CBUAE_BRF5_4_Summary_Entity(Long id, String r0010_name_of_the_borrower_group, String r0020_cin,
			String r0030_nature_of_credit_facility_granted, Date r0040_date_of_disbursement,
			Date r0050_due_date_of_repayment, BigDecimal r0060_market_value, BigDecimal r0070_drawing_power,
			BigDecimal r0080_present_outstanding, BigDecimal r0090_outstanding_as_of_drawing_power,
			BigDecimal r0100_excess_over_drawing_power, BigDecimal r0110_fd_bank_guarantee,
			BigDecimal r0120_mortgage_of_real_estate, String r0130_remarks_status, Date report_date,
			String report_version, String report_frequency, String report_code, String report_desc, String modify_flg,
			String entity_flg, String delete_flg) {
		super();
		this.id = id;
		this.r0010_name_of_the_borrower_group = r0010_name_of_the_borrower_group;
		this.r0020_cin = r0020_cin;
		this.r0030_nature_of_credit_facility_granted = r0030_nature_of_credit_facility_granted;
		this.r0040_date_of_disbursement = r0040_date_of_disbursement;
		this.r0050_due_date_of_repayment = r0050_due_date_of_repayment;
		this.r0060_market_value = r0060_market_value;
		this.r0070_drawing_power = r0070_drawing_power;
		this.r0080_present_outstanding = r0080_present_outstanding;
		this.r0090_outstanding_as_of_drawing_power = r0090_outstanding_as_of_drawing_power;
		this.r0100_excess_over_drawing_power = r0100_excess_over_drawing_power;
		this.r0110_fd_bank_guarantee = r0110_fd_bank_guarantee;
		this.r0120_mortgage_of_real_estate = r0120_mortgage_of_real_estate;
		this.r0130_remarks_status = r0130_remarks_status;
		this.report_date = report_date;
		this.report_version = report_version;
		this.report_frequency = report_frequency;
		this.report_code = report_code;
		this.report_desc = report_desc;
		this.modify_flg = modify_flg;
		this.entity_flg = entity_flg;
		this.delete_flg = delete_flg;
	}

}
