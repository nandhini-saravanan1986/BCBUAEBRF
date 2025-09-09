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
@Table(name = "CBUAE_BRF16_2_ARCHIVALTABLE_SUMMARY")

public class CBUAE_BRF16_2_Archival_Summary_Entity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	private String	r0010_product;
	private BigDecimal	r0010_no_consumerfacing_employees;
	private BigDecimal	r0010_no_resigned_employees;
	private BigDecimal	r0010_no_dismissed_employees;
	private BigDecimal	r0010_contractual_breaches_employees;
	private BigDecimal	r0010_no_salesstaff_employees;
	private BigDecimal	r0010_no_remuneration_employees;
	private BigDecimal	r0010_no_remuneration50per_employees;
	private BigDecimal	r0010_aveperformance_employees;
	private BigDecimal	r0010_conduct_breaches_employees;
	private BigDecimal	r0010_no_complaints_employees;
	private BigDecimal	r0010_no_instancesbreaches_employees;
	private BigDecimal	r0010_no_whistleblower_employees;
	private BigDecimal	r0010_seniormanagement_training;
	private BigDecimal	r0010_bankemployee_training;
	private BigDecimal	r0010_no_cavc_training;
	private BigDecimal	r0010_fraudsandscam_training;
	private BigDecimal	r0010_nmarketconduct_training;
	private BigDecimal	r0010_to_consumerprotection_training;
	private BigDecimal	r0010_to_ombudsman_training;
	private String	r0020_product;
	private BigDecimal	r0020_no_consumerfacing_employees;
	private BigDecimal	r0020_no_resigned_employees;
	private BigDecimal	r0020_no_dismissed_employees;
	private BigDecimal	r0020_contractual_breaches_employees;
	private BigDecimal	r0020_no_salesstaff_employees;
	private BigDecimal	r0020_no_remuneration_employees;
	private BigDecimal	r0020_no_remuneration50per_employees;
	private BigDecimal	r0020_aveperformance_employees;
	private BigDecimal	r0020_conduct_breaches_employees;
	private BigDecimal	r0020_no_complaints_employees;
	private BigDecimal	r0020_no_instancesbreaches_employees;
	private BigDecimal	r0020_no_whistleblower_employees;
	private BigDecimal	r0020_seniormanagement_training;
	private BigDecimal	r0020_bankemployee_training;
	private BigDecimal	r0020_no_cavc_training;
	private BigDecimal	r0020_fraudsandscam_training;
	private BigDecimal	r0020_nmarketconduct_training;
	private BigDecimal	r0020_to_consumerprotection_training;
	private BigDecimal	r0020_to_ombudsman_training;
	private String	r0030_product;
	private BigDecimal	r0030_no_consumerfacing_employees;
	private BigDecimal	r0030_no_resigned_employees;
	private BigDecimal	r0030_no_dismissed_employees;
	private BigDecimal	r0030_contractual_breaches_employees;
	private BigDecimal	r0030_no_salesstaff_employees;
	private BigDecimal	r0030_no_remuneration_employees;
	private BigDecimal	r0030_no_remuneration50per_employees;
	private BigDecimal	r0030_aveperformance_employees;
	private BigDecimal	r0030_conduct_breaches_employees;
	private BigDecimal	r0030_no_complaints_employees;
	private BigDecimal	r0030_no_instancesbreaches_employees;
	private BigDecimal	r0030_no_whistleblower_employees;
	private BigDecimal	r0030_seniormanagement_training;
	private BigDecimal	r0030_bankemployee_training;
	private BigDecimal	r0030_no_cavc_training;
	private BigDecimal	r0030_fraudsandscam_training;
	private BigDecimal	r0030_nmarketconduct_training;
	private BigDecimal	r0030_to_consumerprotection_training;
	private BigDecimal	r0030_to_ombudsman_training;
	private String	r0040_product;
	private BigDecimal	r0040_no_consumerfacing_employees;
	private BigDecimal	r0040_no_resigned_employees;
	private BigDecimal	r0040_no_dismissed_employees;
	private BigDecimal	r0040_contractual_breaches_employees;
	private BigDecimal	r0040_no_salesstaff_employees;
	private BigDecimal	r0040_no_remuneration_employees;
	private BigDecimal	r0040_no_remuneration50per_employees;
	private BigDecimal	r0040_aveperformance_employees;
	private BigDecimal	r0040_conduct_breaches_employees;
	private BigDecimal	r0040_no_complaints_employees;
	private BigDecimal	r0040_no_instancesbreaches_employees;
	private BigDecimal	r0040_no_whistleblower_employees;
	private BigDecimal	r0040_seniormanagement_training;
	private BigDecimal	r0040_bankemployee_training;
	private BigDecimal	r0040_no_cavc_training;
	private BigDecimal	r0040_fraudsandscam_training;
	private BigDecimal	r0040_nmarketconduct_training;
	private BigDecimal	r0040_to_consumerprotection_training;
	private BigDecimal	r0040_to_ombudsman_training;
	private String	r0050_product;
	private BigDecimal	r0050_no_consumerfacing_employees;
	private BigDecimal	r0050_no_resigned_employees;
	private BigDecimal	r0050_no_dismissed_employees;
	private BigDecimal	r0050_contractual_breaches_employees;
	private BigDecimal	r0050_no_salesstaff_employees;
	private BigDecimal	r0050_no_remuneration_employees;
	private BigDecimal	r0050_no_remuneration50per_employees;
	private BigDecimal	r0050_aveperformance_employees;
	private BigDecimal	r0050_conduct_breaches_employees;
	private BigDecimal	r0050_no_complaints_employees;
	private BigDecimal	r0050_no_instancesbreaches_employees;
	private BigDecimal	r0050_no_whistleblower_employees;
	private BigDecimal	r0050_seniormanagement_training;
	private BigDecimal	r0050_bankemployee_training;
	private BigDecimal	r0050_no_cavc_training;
	private BigDecimal	r0050_fraudsandscam_training;
	private BigDecimal	r0050_nmarketconduct_training;
	private BigDecimal	r0050_to_consumerprotection_training;
	private BigDecimal	r0050_to_ombudsman_training;
	private String	r0060_product;
	private BigDecimal	r0060_no_consumerfacing_employees;
	private BigDecimal	r0060_no_resigned_employees;
	private BigDecimal	r0060_no_dismissed_employees;
	private BigDecimal	r0060_contractual_breaches_employees;
	private BigDecimal	r0060_no_salesstaff_employees;
	private BigDecimal	r0060_no_remuneration_employees;
	private BigDecimal	r0060_no_remuneration50per_employees;
	private BigDecimal	r0060_aveperformance_employees;
	private BigDecimal	r0060_conduct_breaches_employees;
	private BigDecimal	r0060_no_complaints_employees;
	private BigDecimal	r0060_no_instancesbreaches_employees;
	private BigDecimal	r0060_no_whistleblower_employees;
	private BigDecimal	r0060_seniormanagement_training;
	private BigDecimal	r0060_bankemployee_training;
	private BigDecimal	r0060_no_cavc_training;
	private BigDecimal	r0060_fraudsandscam_training;
	private BigDecimal	r0060_nmarketconduct_training;
	private BigDecimal	r0060_to_consumerprotection_training;
	private BigDecimal	r0060_to_ombudsman_training;
	private String	r0070_product;
	private BigDecimal	r0070_no_consumerfacing_employees;
	private BigDecimal	r0070_no_resigned_employees;
	private BigDecimal	r0070_no_dismissed_employees;
	private BigDecimal	r0070_contractual_breaches_employees;
	private BigDecimal	r0070_no_salesstaff_employees;
	private BigDecimal	r0070_no_remuneration_employees;
	private BigDecimal	r0070_no_remuneration50per_employees;
	private BigDecimal	r0070_aveperformance_employees;
	private BigDecimal	r0070_conduct_breaches_employees;
	private BigDecimal	r0070_no_complaints_employees;
	private BigDecimal	r0070_no_instancesbreaches_employees;
	private BigDecimal	r0070_no_whistleblower_employees;
	private BigDecimal	r0070_seniormanagement_training;
	private BigDecimal	r0070_bankemployee_training;
	private BigDecimal	r0070_no_cavc_training;
	private BigDecimal	r0070_fraudsandscam_training;
	private BigDecimal	r0070_nmarketconduct_training;
	private BigDecimal	r0070_to_consumerprotection_training;
	private BigDecimal	r0070_to_ombudsman_training;
	private String	r0080_product;
	private BigDecimal	r0080_no_consumerfacing_employees;
	private BigDecimal	r0080_no_resigned_employees;
	private BigDecimal	r0080_no_dismissed_employees;
	private BigDecimal	r0080_contractual_breaches_employees;
	private BigDecimal	r0080_no_salesstaff_employees;
	private BigDecimal	r0080_no_remuneration_employees;
	private BigDecimal	r0080_no_remuneration50per_employees;
	private BigDecimal	r0080_aveperformance_employees;
	private BigDecimal	r0080_conduct_breaches_employees;
	private BigDecimal	r0080_no_complaints_employees;
	private BigDecimal	r0080_no_instancesbreaches_employees;
	private BigDecimal	r0080_no_whistleblower_employees;
	private BigDecimal	r0080_seniormanagement_training;
	private BigDecimal	r0080_bankemployee_training;
	private BigDecimal	r0080_no_cavc_training;
	private BigDecimal	r0080_fraudsandscam_training;
	private BigDecimal	r0080_nmarketconduct_training;
	private BigDecimal	r0080_to_consumerprotection_training;
	private BigDecimal	r0080_to_ombudsman_training;
	private String	r0090_product;
	private BigDecimal	r0090_no_consumerfacing_employees;
	private BigDecimal	r0090_no_resigned_employees;
	private BigDecimal	r0090_no_dismissed_employees;
	private BigDecimal	r0090_contractual_breaches_employees;
	private BigDecimal	r0090_no_salesstaff_employees;
	private BigDecimal	r0090_no_remuneration_employees;
	private BigDecimal	r0090_no_remuneration50per_employees;
	private BigDecimal	r0090_aveperformance_employees;
	private BigDecimal	r0090_conduct_breaches_employees;
	private BigDecimal	r0090_no_complaints_employees;
	private BigDecimal	r0090_no_instancesbreaches_employees;
	private BigDecimal	r0090_no_whistleblower_employees;
	private BigDecimal	r0090_seniormanagement_training;
	private BigDecimal	r0090_bankemployee_training;
	private BigDecimal	r0090_no_cavc_training;
	private BigDecimal	r0090_fraudsandscam_training;
	private BigDecimal	r0090_nmarketconduct_training;
	private BigDecimal	r0090_to_consumerprotection_training;
	private BigDecimal	r0090_to_ombudsman_training;
	private String	r0100_product;
	private BigDecimal	r0100_no_consumerfacing_employees;
	private BigDecimal	r0100_no_resigned_employees;
	private BigDecimal	r0100_no_dismissed_employees;
	private BigDecimal	r0100_contractual_breaches_employees;
	private BigDecimal	r0100_no_salesstaff_employees;
	private BigDecimal	r0100_no_remuneration_employees;
	private BigDecimal	r0100_no_remuneration50per_employees;
	private BigDecimal	r0100_aveperformance_employees;
	private BigDecimal	r0100_conduct_breaches_employees;
	private BigDecimal	r0100_no_complaints_employees;
	private BigDecimal	r0100_no_instancesbreaches_employees;
	private BigDecimal	r0100_no_whistleblower_employees;
	private BigDecimal	r0100_seniormanagement_training;
	private BigDecimal	r0100_bankemployee_training;
	private BigDecimal	r0100_no_cavc_training;
	private BigDecimal	r0100_fraudsandscam_training;
	private BigDecimal	r0100_nmarketconduct_training;
	private BigDecimal	r0100_to_consumerprotection_training;
	private BigDecimal	r0100_to_ombudsman_training;
	private String	r0110_product;
	private BigDecimal	r0110_no_consumerfacing_employees;
	private BigDecimal	r0110_no_resigned_employees;
	private BigDecimal	r0110_no_dismissed_employees;
	private BigDecimal	r0110_contractual_breaches_employees;
	private BigDecimal	r0110_no_salesstaff_employees;
	private BigDecimal	r0110_no_remuneration_employees;
	private BigDecimal	r0110_no_remuneration50per_employees;
	private BigDecimal	r0110_aveperformance_employees;
	private BigDecimal	r0110_conduct_breaches_employees;
	private BigDecimal	r0110_no_complaints_employees;
	private BigDecimal	r0110_no_instancesbreaches_employees;
	private BigDecimal	r0110_no_whistleblower_employees;
	private BigDecimal	r0110_seniormanagement_training;
	private BigDecimal	r0110_bankemployee_training;
	private BigDecimal	r0110_no_cavc_training;
	private BigDecimal	r0110_fraudsandscam_training;
	private BigDecimal	r0110_nmarketconduct_training;
	private BigDecimal	r0110_to_consumerprotection_training;
	private BigDecimal	r0110_to_ombudsman_training;
	private String	r0120_product;
	private BigDecimal	r0120_no_consumerfacing_employees;
	private BigDecimal	r0120_no_resigned_employees;
	private BigDecimal	r0120_no_dismissed_employees;
	private BigDecimal	r0120_contractual_breaches_employees;
	private BigDecimal	r0120_no_salesstaff_employees;
	private BigDecimal	r0120_no_remuneration_employees;
	private BigDecimal	r0120_no_remuneration50per_employees;
	private BigDecimal	r0120_aveperformance_employees;
	private BigDecimal	r0120_conduct_breaches_employees;
	private BigDecimal	r0120_no_complaints_employees;
	private BigDecimal	r0120_no_instancesbreaches_employees;
	private BigDecimal	r0120_no_whistleblower_employees;
	private BigDecimal	r0120_seniormanagement_training;
	private BigDecimal	r0120_bankemployee_training;
	private BigDecimal	r0120_no_cavc_training;
	private BigDecimal	r0120_fraudsandscam_training;
	private BigDecimal	r0120_nmarketconduct_training;
	private BigDecimal	r0120_to_consumerprotection_training;
	private BigDecimal	r0120_to_ombudsman_training;
	private String	r0130_product;
	private BigDecimal	r0130_no_consumerfacing_employees;
	private BigDecimal	r0130_no_resigned_employees;
	private BigDecimal	r0130_no_dismissed_employees;
	private BigDecimal	r0130_contractual_breaches_employees;
	private BigDecimal	r0130_no_salesstaff_employees;
	private BigDecimal	r0130_no_remuneration_employees;
	private BigDecimal	r0130_no_remuneration50per_employees;
	private BigDecimal	r0130_aveperformance_employees;
	private BigDecimal	r0130_conduct_breaches_employees;
	private BigDecimal	r0130_no_complaints_employees;
	private BigDecimal	r0130_no_instancesbreaches_employees;
	private BigDecimal	r0130_no_whistleblower_employees;
	private BigDecimal	r0130_seniormanagement_training;
	private BigDecimal	r0130_bankemployee_training;
	private BigDecimal	r0130_no_cavc_training;
	private BigDecimal	r0130_fraudsandscam_training;
	private BigDecimal	r0130_nmarketconduct_training;
	private BigDecimal	r0130_to_consumerprotection_training;
	private BigDecimal	r0130_to_ombudsman_training;
	private String	r0140_product;
	private BigDecimal	r0140_no_consumerfacing_employees;
	private BigDecimal	r0140_no_resigned_employees;
	private BigDecimal	r0140_no_dismissed_employees;
	private BigDecimal	r0140_contractual_breaches_employees;
	private BigDecimal	r0140_no_salesstaff_employees;
	private BigDecimal	r0140_no_remuneration_employees;
	private BigDecimal	r0140_no_remuneration50per_employees;
	private BigDecimal	r0140_aveperformance_employees;
	private BigDecimal	r0140_conduct_breaches_employees;
	private BigDecimal	r0140_no_complaints_employees;
	private BigDecimal	r0140_no_instancesbreaches_employees;
	private BigDecimal	r0140_no_whistleblower_employees;
	private BigDecimal	r0140_seniormanagement_training;
	private BigDecimal	r0140_bankemployee_training;
	private BigDecimal	r0140_no_cavc_training;
	private BigDecimal	r0140_fraudsandscam_training;
	private BigDecimal	r0140_nmarketconduct_training;
	private BigDecimal	r0140_to_consumerprotection_training;
	private BigDecimal	r0140_to_ombudsman_training;
	private String	r0150_product;
	private BigDecimal	r0150_no_consumerfacing_employees;
	private BigDecimal	r0150_no_resigned_employees;
	private BigDecimal	r0150_no_dismissed_employees;
	private BigDecimal	r0150_contractual_breaches_employees;
	private BigDecimal	r0150_no_salesstaff_employees;
	private BigDecimal	r0150_no_remuneration_employees;
	private BigDecimal	r0150_no_remuneration50per_employees;
	private BigDecimal	r0150_aveperformance_employees;
	private BigDecimal	r0150_conduct_breaches_employees;
	private BigDecimal	r0150_no_complaints_employees;
	private BigDecimal	r0150_no_instancesbreaches_employees;
	private BigDecimal	r0150_no_whistleblower_employees;
	private BigDecimal	r0150_seniormanagement_training;
	private BigDecimal	r0150_bankemployee_training;
	private BigDecimal	r0150_no_cavc_training;
	private BigDecimal	r0150_fraudsandscam_training;
	private BigDecimal	r0150_nmarketconduct_training;
	private BigDecimal	r0150_to_consumerprotection_training;
	private BigDecimal	r0150_to_ombudsman_training;
	
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
	public String getR0010_product() {
		return r0010_product;
	}
	public void setR0010_product(String r0010_product) {
		this.r0010_product = r0010_product;
	}
	public BigDecimal getR0010_no_consumerfacing_employees() {
		return r0010_no_consumerfacing_employees;
	}
	public void setR0010_no_consumerfacing_employees(BigDecimal r0010_no_consumerfacing_employees) {
		this.r0010_no_consumerfacing_employees = r0010_no_consumerfacing_employees;
	}
	public BigDecimal getR0010_no_resigned_employees() {
		return r0010_no_resigned_employees;
	}
	public void setR0010_no_resigned_employees(BigDecimal r0010_no_resigned_employees) {
		this.r0010_no_resigned_employees = r0010_no_resigned_employees;
	}
	public BigDecimal getR0010_no_dismissed_employees() {
		return r0010_no_dismissed_employees;
	}
	public void setR0010_no_dismissed_employees(BigDecimal r0010_no_dismissed_employees) {
		this.r0010_no_dismissed_employees = r0010_no_dismissed_employees;
	}
	public BigDecimal getR0010_contractual_breaches_employees() {
		return r0010_contractual_breaches_employees;
	}
	public void setR0010_contractual_breaches_employees(BigDecimal r0010_contractual_breaches_employees) {
		this.r0010_contractual_breaches_employees = r0010_contractual_breaches_employees;
	}
	public BigDecimal getR0010_no_salesstaff_employees() {
		return r0010_no_salesstaff_employees;
	}
	public void setR0010_no_salesstaff_employees(BigDecimal r0010_no_salesstaff_employees) {
		this.r0010_no_salesstaff_employees = r0010_no_salesstaff_employees;
	}
	public BigDecimal getR0010_no_remuneration_employees() {
		return r0010_no_remuneration_employees;
	}
	public void setR0010_no_remuneration_employees(BigDecimal r0010_no_remuneration_employees) {
		this.r0010_no_remuneration_employees = r0010_no_remuneration_employees;
	}
	public BigDecimal getR0010_no_remuneration50per_employees() {
		return r0010_no_remuneration50per_employees;
	}
	public void setR0010_no_remuneration50per_employees(BigDecimal r0010_no_remuneration50per_employees) {
		this.r0010_no_remuneration50per_employees = r0010_no_remuneration50per_employees;
	}
	public BigDecimal getR0010_aveperformance_employees() {
		return r0010_aveperformance_employees;
	}
	public void setR0010_aveperformance_employees(BigDecimal r0010_aveperformance_employees) {
		this.r0010_aveperformance_employees = r0010_aveperformance_employees;
	}
	public BigDecimal getR0010_conduct_breaches_employees() {
		return r0010_conduct_breaches_employees;
	}
	public void setR0010_conduct_breaches_employees(BigDecimal r0010_conduct_breaches_employees) {
		this.r0010_conduct_breaches_employees = r0010_conduct_breaches_employees;
	}
	public BigDecimal getR0010_no_complaints_employees() {
		return r0010_no_complaints_employees;
	}
	public void setR0010_no_complaints_employees(BigDecimal r0010_no_complaints_employees) {
		this.r0010_no_complaints_employees = r0010_no_complaints_employees;
	}
	public BigDecimal getR0010_no_instancesbreaches_employees() {
		return r0010_no_instancesbreaches_employees;
	}
	public void setR0010_no_instancesbreaches_employees(BigDecimal r0010_no_instancesbreaches_employees) {
		this.r0010_no_instancesbreaches_employees = r0010_no_instancesbreaches_employees;
	}
	public BigDecimal getR0010_no_whistleblower_employees() {
		return r0010_no_whistleblower_employees;
	}
	public void setR0010_no_whistleblower_employees(BigDecimal r0010_no_whistleblower_employees) {
		this.r0010_no_whistleblower_employees = r0010_no_whistleblower_employees;
	}
	public BigDecimal getR0010_seniormanagement_training() {
		return r0010_seniormanagement_training;
	}
	public void setR0010_seniormanagement_training(BigDecimal r0010_seniormanagement_training) {
		this.r0010_seniormanagement_training = r0010_seniormanagement_training;
	}
	public BigDecimal getR0010_bankemployee_training() {
		return r0010_bankemployee_training;
	}
	public void setR0010_bankemployee_training(BigDecimal r0010_bankemployee_training) {
		this.r0010_bankemployee_training = r0010_bankemployee_training;
	}
	public BigDecimal getR0010_no_cavc_training() {
		return r0010_no_cavc_training;
	}
	public void setR0010_no_cavc_training(BigDecimal r0010_no_cavc_training) {
		this.r0010_no_cavc_training = r0010_no_cavc_training;
	}
	public BigDecimal getR0010_fraudsandscam_training() {
		return r0010_fraudsandscam_training;
	}
	public void setR0010_fraudsandscam_training(BigDecimal r0010_fraudsandscam_training) {
		this.r0010_fraudsandscam_training = r0010_fraudsandscam_training;
	}
	public BigDecimal getR0010_nmarketconduct_training() {
		return r0010_nmarketconduct_training;
	}
	public void setR0010_nmarketconduct_training(BigDecimal r0010_nmarketconduct_training) {
		this.r0010_nmarketconduct_training = r0010_nmarketconduct_training;
	}
	public BigDecimal getR0010_to_consumerprotection_training() {
		return r0010_to_consumerprotection_training;
	}
	public void setR0010_to_consumerprotection_training(BigDecimal r0010_to_consumerprotection_training) {
		this.r0010_to_consumerprotection_training = r0010_to_consumerprotection_training;
	}
	public BigDecimal getR0010_to_ombudsman_training() {
		return r0010_to_ombudsman_training;
	}
	public void setR0010_to_ombudsman_training(BigDecimal r0010_to_ombudsman_training) {
		this.r0010_to_ombudsman_training = r0010_to_ombudsman_training;
	}
	public String getR0020_product() {
		return r0020_product;
	}
	public void setR0020_product(String r0020_product) {
		this.r0020_product = r0020_product;
	}
	public BigDecimal getR0020_no_consumerfacing_employees() {
		return r0020_no_consumerfacing_employees;
	}
	public void setR0020_no_consumerfacing_employees(BigDecimal r0020_no_consumerfacing_employees) {
		this.r0020_no_consumerfacing_employees = r0020_no_consumerfacing_employees;
	}
	public BigDecimal getR0020_no_resigned_employees() {
		return r0020_no_resigned_employees;
	}
	public void setR0020_no_resigned_employees(BigDecimal r0020_no_resigned_employees) {
		this.r0020_no_resigned_employees = r0020_no_resigned_employees;
	}
	public BigDecimal getR0020_no_dismissed_employees() {
		return r0020_no_dismissed_employees;
	}
	public void setR0020_no_dismissed_employees(BigDecimal r0020_no_dismissed_employees) {
		this.r0020_no_dismissed_employees = r0020_no_dismissed_employees;
	}
	public BigDecimal getR0020_contractual_breaches_employees() {
		return r0020_contractual_breaches_employees;
	}
	public void setR0020_contractual_breaches_employees(BigDecimal r0020_contractual_breaches_employees) {
		this.r0020_contractual_breaches_employees = r0020_contractual_breaches_employees;
	}
	public BigDecimal getR0020_no_salesstaff_employees() {
		return r0020_no_salesstaff_employees;
	}
	public void setR0020_no_salesstaff_employees(BigDecimal r0020_no_salesstaff_employees) {
		this.r0020_no_salesstaff_employees = r0020_no_salesstaff_employees;
	}
	public BigDecimal getR0020_no_remuneration_employees() {
		return r0020_no_remuneration_employees;
	}
	public void setR0020_no_remuneration_employees(BigDecimal r0020_no_remuneration_employees) {
		this.r0020_no_remuneration_employees = r0020_no_remuneration_employees;
	}
	public BigDecimal getR0020_no_remuneration50per_employees() {
		return r0020_no_remuneration50per_employees;
	}
	public void setR0020_no_remuneration50per_employees(BigDecimal r0020_no_remuneration50per_employees) {
		this.r0020_no_remuneration50per_employees = r0020_no_remuneration50per_employees;
	}
	public BigDecimal getR0020_aveperformance_employees() {
		return r0020_aveperformance_employees;
	}
	public void setR0020_aveperformance_employees(BigDecimal r0020_aveperformance_employees) {
		this.r0020_aveperformance_employees = r0020_aveperformance_employees;
	}
	public BigDecimal getR0020_conduct_breaches_employees() {
		return r0020_conduct_breaches_employees;
	}
	public void setR0020_conduct_breaches_employees(BigDecimal r0020_conduct_breaches_employees) {
		this.r0020_conduct_breaches_employees = r0020_conduct_breaches_employees;
	}
	public BigDecimal getR0020_no_complaints_employees() {
		return r0020_no_complaints_employees;
	}
	public void setR0020_no_complaints_employees(BigDecimal r0020_no_complaints_employees) {
		this.r0020_no_complaints_employees = r0020_no_complaints_employees;
	}
	public BigDecimal getR0020_no_instancesbreaches_employees() {
		return r0020_no_instancesbreaches_employees;
	}
	public void setR0020_no_instancesbreaches_employees(BigDecimal r0020_no_instancesbreaches_employees) {
		this.r0020_no_instancesbreaches_employees = r0020_no_instancesbreaches_employees;
	}
	public BigDecimal getR0020_no_whistleblower_employees() {
		return r0020_no_whistleblower_employees;
	}
	public void setR0020_no_whistleblower_employees(BigDecimal r0020_no_whistleblower_employees) {
		this.r0020_no_whistleblower_employees = r0020_no_whistleblower_employees;
	}
	public BigDecimal getR0020_seniormanagement_training() {
		return r0020_seniormanagement_training;
	}
	public void setR0020_seniormanagement_training(BigDecimal r0020_seniormanagement_training) {
		this.r0020_seniormanagement_training = r0020_seniormanagement_training;
	}
	public BigDecimal getR0020_bankemployee_training() {
		return r0020_bankemployee_training;
	}
	public void setR0020_bankemployee_training(BigDecimal r0020_bankemployee_training) {
		this.r0020_bankemployee_training = r0020_bankemployee_training;
	}
	public BigDecimal getR0020_no_cavc_training() {
		return r0020_no_cavc_training;
	}
	public void setR0020_no_cavc_training(BigDecimal r0020_no_cavc_training) {
		this.r0020_no_cavc_training = r0020_no_cavc_training;
	}
	public BigDecimal getR0020_fraudsandscam_training() {
		return r0020_fraudsandscam_training;
	}
	public void setR0020_fraudsandscam_training(BigDecimal r0020_fraudsandscam_training) {
		this.r0020_fraudsandscam_training = r0020_fraudsandscam_training;
	}
	public BigDecimal getR0020_nmarketconduct_training() {
		return r0020_nmarketconduct_training;
	}
	public void setR0020_nmarketconduct_training(BigDecimal r0020_nmarketconduct_training) {
		this.r0020_nmarketconduct_training = r0020_nmarketconduct_training;
	}
	public BigDecimal getR0020_to_consumerprotection_training() {
		return r0020_to_consumerprotection_training;
	}
	public void setR0020_to_consumerprotection_training(BigDecimal r0020_to_consumerprotection_training) {
		this.r0020_to_consumerprotection_training = r0020_to_consumerprotection_training;
	}
	public BigDecimal getR0020_to_ombudsman_training() {
		return r0020_to_ombudsman_training;
	}
	public void setR0020_to_ombudsman_training(BigDecimal r0020_to_ombudsman_training) {
		this.r0020_to_ombudsman_training = r0020_to_ombudsman_training;
	}
	public String getR0030_product() {
		return r0030_product;
	}
	public void setR0030_product(String r0030_product) {
		this.r0030_product = r0030_product;
	}
	public BigDecimal getR0030_no_consumerfacing_employees() {
		return r0030_no_consumerfacing_employees;
	}
	public void setR0030_no_consumerfacing_employees(BigDecimal r0030_no_consumerfacing_employees) {
		this.r0030_no_consumerfacing_employees = r0030_no_consumerfacing_employees;
	}
	public BigDecimal getR0030_no_resigned_employees() {
		return r0030_no_resigned_employees;
	}
	public void setR0030_no_resigned_employees(BigDecimal r0030_no_resigned_employees) {
		this.r0030_no_resigned_employees = r0030_no_resigned_employees;
	}
	public BigDecimal getR0030_no_dismissed_employees() {
		return r0030_no_dismissed_employees;
	}
	public void setR0030_no_dismissed_employees(BigDecimal r0030_no_dismissed_employees) {
		this.r0030_no_dismissed_employees = r0030_no_dismissed_employees;
	}
	public BigDecimal getR0030_contractual_breaches_employees() {
		return r0030_contractual_breaches_employees;
	}
	public void setR0030_contractual_breaches_employees(BigDecimal r0030_contractual_breaches_employees) {
		this.r0030_contractual_breaches_employees = r0030_contractual_breaches_employees;
	}
	public BigDecimal getR0030_no_salesstaff_employees() {
		return r0030_no_salesstaff_employees;
	}
	public void setR0030_no_salesstaff_employees(BigDecimal r0030_no_salesstaff_employees) {
		this.r0030_no_salesstaff_employees = r0030_no_salesstaff_employees;
	}
	public BigDecimal getR0030_no_remuneration_employees() {
		return r0030_no_remuneration_employees;
	}
	public void setR0030_no_remuneration_employees(BigDecimal r0030_no_remuneration_employees) {
		this.r0030_no_remuneration_employees = r0030_no_remuneration_employees;
	}
	public BigDecimal getR0030_no_remuneration50per_employees() {
		return r0030_no_remuneration50per_employees;
	}
	public void setR0030_no_remuneration50per_employees(BigDecimal r0030_no_remuneration50per_employees) {
		this.r0030_no_remuneration50per_employees = r0030_no_remuneration50per_employees;
	}
	public BigDecimal getR0030_aveperformance_employees() {
		return r0030_aveperformance_employees;
	}
	public void setR0030_aveperformance_employees(BigDecimal r0030_aveperformance_employees) {
		this.r0030_aveperformance_employees = r0030_aveperformance_employees;
	}
	public BigDecimal getR0030_conduct_breaches_employees() {
		return r0030_conduct_breaches_employees;
	}
	public void setR0030_conduct_breaches_employees(BigDecimal r0030_conduct_breaches_employees) {
		this.r0030_conduct_breaches_employees = r0030_conduct_breaches_employees;
	}
	public BigDecimal getR0030_no_complaints_employees() {
		return r0030_no_complaints_employees;
	}
	public void setR0030_no_complaints_employees(BigDecimal r0030_no_complaints_employees) {
		this.r0030_no_complaints_employees = r0030_no_complaints_employees;
	}
	public BigDecimal getR0030_no_instancesbreaches_employees() {
		return r0030_no_instancesbreaches_employees;
	}
	public void setR0030_no_instancesbreaches_employees(BigDecimal r0030_no_instancesbreaches_employees) {
		this.r0030_no_instancesbreaches_employees = r0030_no_instancesbreaches_employees;
	}
	public BigDecimal getR0030_no_whistleblower_employees() {
		return r0030_no_whistleblower_employees;
	}
	public void setR0030_no_whistleblower_employees(BigDecimal r0030_no_whistleblower_employees) {
		this.r0030_no_whistleblower_employees = r0030_no_whistleblower_employees;
	}
	public BigDecimal getR0030_seniormanagement_training() {
		return r0030_seniormanagement_training;
	}
	public void setR0030_seniormanagement_training(BigDecimal r0030_seniormanagement_training) {
		this.r0030_seniormanagement_training = r0030_seniormanagement_training;
	}
	public BigDecimal getR0030_bankemployee_training() {
		return r0030_bankemployee_training;
	}
	public void setR0030_bankemployee_training(BigDecimal r0030_bankemployee_training) {
		this.r0030_bankemployee_training = r0030_bankemployee_training;
	}
	public BigDecimal getR0030_no_cavc_training() {
		return r0030_no_cavc_training;
	}
	public void setR0030_no_cavc_training(BigDecimal r0030_no_cavc_training) {
		this.r0030_no_cavc_training = r0030_no_cavc_training;
	}
	public BigDecimal getR0030_fraudsandscam_training() {
		return r0030_fraudsandscam_training;
	}
	public void setR0030_fraudsandscam_training(BigDecimal r0030_fraudsandscam_training) {
		this.r0030_fraudsandscam_training = r0030_fraudsandscam_training;
	}
	public BigDecimal getR0030_nmarketconduct_training() {
		return r0030_nmarketconduct_training;
	}
	public void setR0030_nmarketconduct_training(BigDecimal r0030_nmarketconduct_training) {
		this.r0030_nmarketconduct_training = r0030_nmarketconduct_training;
	}
	public BigDecimal getR0030_to_consumerprotection_training() {
		return r0030_to_consumerprotection_training;
	}
	public void setR0030_to_consumerprotection_training(BigDecimal r0030_to_consumerprotection_training) {
		this.r0030_to_consumerprotection_training = r0030_to_consumerprotection_training;
	}
	public BigDecimal getR0030_to_ombudsman_training() {
		return r0030_to_ombudsman_training;
	}
	public void setR0030_to_ombudsman_training(BigDecimal r0030_to_ombudsman_training) {
		this.r0030_to_ombudsman_training = r0030_to_ombudsman_training;
	}
	public String getR0040_product() {
		return r0040_product;
	}
	public void setR0040_product(String r0040_product) {
		this.r0040_product = r0040_product;
	}
	public BigDecimal getR0040_no_consumerfacing_employees() {
		return r0040_no_consumerfacing_employees;
	}
	public void setR0040_no_consumerfacing_employees(BigDecimal r0040_no_consumerfacing_employees) {
		this.r0040_no_consumerfacing_employees = r0040_no_consumerfacing_employees;
	}
	public BigDecimal getR0040_no_resigned_employees() {
		return r0040_no_resigned_employees;
	}
	public void setR0040_no_resigned_employees(BigDecimal r0040_no_resigned_employees) {
		this.r0040_no_resigned_employees = r0040_no_resigned_employees;
	}
	public BigDecimal getR0040_no_dismissed_employees() {
		return r0040_no_dismissed_employees;
	}
	public void setR0040_no_dismissed_employees(BigDecimal r0040_no_dismissed_employees) {
		this.r0040_no_dismissed_employees = r0040_no_dismissed_employees;
	}
	public BigDecimal getR0040_contractual_breaches_employees() {
		return r0040_contractual_breaches_employees;
	}
	public void setR0040_contractual_breaches_employees(BigDecimal r0040_contractual_breaches_employees) {
		this.r0040_contractual_breaches_employees = r0040_contractual_breaches_employees;
	}
	public BigDecimal getR0040_no_salesstaff_employees() {
		return r0040_no_salesstaff_employees;
	}
	public void setR0040_no_salesstaff_employees(BigDecimal r0040_no_salesstaff_employees) {
		this.r0040_no_salesstaff_employees = r0040_no_salesstaff_employees;
	}
	public BigDecimal getR0040_no_remuneration_employees() {
		return r0040_no_remuneration_employees;
	}
	public void setR0040_no_remuneration_employees(BigDecimal r0040_no_remuneration_employees) {
		this.r0040_no_remuneration_employees = r0040_no_remuneration_employees;
	}
	public BigDecimal getR0040_no_remuneration50per_employees() {
		return r0040_no_remuneration50per_employees;
	}
	public void setR0040_no_remuneration50per_employees(BigDecimal r0040_no_remuneration50per_employees) {
		this.r0040_no_remuneration50per_employees = r0040_no_remuneration50per_employees;
	}
	public BigDecimal getR0040_aveperformance_employees() {
		return r0040_aveperformance_employees;
	}
	public void setR0040_aveperformance_employees(BigDecimal r0040_aveperformance_employees) {
		this.r0040_aveperformance_employees = r0040_aveperformance_employees;
	}
	public BigDecimal getR0040_conduct_breaches_employees() {
		return r0040_conduct_breaches_employees;
	}
	public void setR0040_conduct_breaches_employees(BigDecimal r0040_conduct_breaches_employees) {
		this.r0040_conduct_breaches_employees = r0040_conduct_breaches_employees;
	}
	public BigDecimal getR0040_no_complaints_employees() {
		return r0040_no_complaints_employees;
	}
	public void setR0040_no_complaints_employees(BigDecimal r0040_no_complaints_employees) {
		this.r0040_no_complaints_employees = r0040_no_complaints_employees;
	}
	public BigDecimal getR0040_no_instancesbreaches_employees() {
		return r0040_no_instancesbreaches_employees;
	}
	public void setR0040_no_instancesbreaches_employees(BigDecimal r0040_no_instancesbreaches_employees) {
		this.r0040_no_instancesbreaches_employees = r0040_no_instancesbreaches_employees;
	}
	public BigDecimal getR0040_no_whistleblower_employees() {
		return r0040_no_whistleblower_employees;
	}
	public void setR0040_no_whistleblower_employees(BigDecimal r0040_no_whistleblower_employees) {
		this.r0040_no_whistleblower_employees = r0040_no_whistleblower_employees;
	}
	public BigDecimal getR0040_seniormanagement_training() {
		return r0040_seniormanagement_training;
	}
	public void setR0040_seniormanagement_training(BigDecimal r0040_seniormanagement_training) {
		this.r0040_seniormanagement_training = r0040_seniormanagement_training;
	}
	public BigDecimal getR0040_bankemployee_training() {
		return r0040_bankemployee_training;
	}
	public void setR0040_bankemployee_training(BigDecimal r0040_bankemployee_training) {
		this.r0040_bankemployee_training = r0040_bankemployee_training;
	}
	public BigDecimal getR0040_no_cavc_training() {
		return r0040_no_cavc_training;
	}
	public void setR0040_no_cavc_training(BigDecimal r0040_no_cavc_training) {
		this.r0040_no_cavc_training = r0040_no_cavc_training;
	}
	public BigDecimal getR0040_fraudsandscam_training() {
		return r0040_fraudsandscam_training;
	}
	public void setR0040_fraudsandscam_training(BigDecimal r0040_fraudsandscam_training) {
		this.r0040_fraudsandscam_training = r0040_fraudsandscam_training;
	}
	public BigDecimal getR0040_nmarketconduct_training() {
		return r0040_nmarketconduct_training;
	}
	public void setR0040_nmarketconduct_training(BigDecimal r0040_nmarketconduct_training) {
		this.r0040_nmarketconduct_training = r0040_nmarketconduct_training;
	}
	public BigDecimal getR0040_to_consumerprotection_training() {
		return r0040_to_consumerprotection_training;
	}
	public void setR0040_to_consumerprotection_training(BigDecimal r0040_to_consumerprotection_training) {
		this.r0040_to_consumerprotection_training = r0040_to_consumerprotection_training;
	}
	public BigDecimal getR0040_to_ombudsman_training() {
		return r0040_to_ombudsman_training;
	}
	public void setR0040_to_ombudsman_training(BigDecimal r0040_to_ombudsman_training) {
		this.r0040_to_ombudsman_training = r0040_to_ombudsman_training;
	}
	public String getR0050_product() {
		return r0050_product;
	}
	public void setR0050_product(String r0050_product) {
		this.r0050_product = r0050_product;
	}
	public BigDecimal getR0050_no_consumerfacing_employees() {
		return r0050_no_consumerfacing_employees;
	}
	public void setR0050_no_consumerfacing_employees(BigDecimal r0050_no_consumerfacing_employees) {
		this.r0050_no_consumerfacing_employees = r0050_no_consumerfacing_employees;
	}
	public BigDecimal getR0050_no_resigned_employees() {
		return r0050_no_resigned_employees;
	}
	public void setR0050_no_resigned_employees(BigDecimal r0050_no_resigned_employees) {
		this.r0050_no_resigned_employees = r0050_no_resigned_employees;
	}
	public BigDecimal getR0050_no_dismissed_employees() {
		return r0050_no_dismissed_employees;
	}
	public void setR0050_no_dismissed_employees(BigDecimal r0050_no_dismissed_employees) {
		this.r0050_no_dismissed_employees = r0050_no_dismissed_employees;
	}
	public BigDecimal getR0050_contractual_breaches_employees() {
		return r0050_contractual_breaches_employees;
	}
	public void setR0050_contractual_breaches_employees(BigDecimal r0050_contractual_breaches_employees) {
		this.r0050_contractual_breaches_employees = r0050_contractual_breaches_employees;
	}
	public BigDecimal getR0050_no_salesstaff_employees() {
		return r0050_no_salesstaff_employees;
	}
	public void setR0050_no_salesstaff_employees(BigDecimal r0050_no_salesstaff_employees) {
		this.r0050_no_salesstaff_employees = r0050_no_salesstaff_employees;
	}
	public BigDecimal getR0050_no_remuneration_employees() {
		return r0050_no_remuneration_employees;
	}
	public void setR0050_no_remuneration_employees(BigDecimal r0050_no_remuneration_employees) {
		this.r0050_no_remuneration_employees = r0050_no_remuneration_employees;
	}
	public BigDecimal getR0050_no_remuneration50per_employees() {
		return r0050_no_remuneration50per_employees;
	}
	public void setR0050_no_remuneration50per_employees(BigDecimal r0050_no_remuneration50per_employees) {
		this.r0050_no_remuneration50per_employees = r0050_no_remuneration50per_employees;
	}
	public BigDecimal getR0050_aveperformance_employees() {
		return r0050_aveperformance_employees;
	}
	public void setR0050_aveperformance_employees(BigDecimal r0050_aveperformance_employees) {
		this.r0050_aveperformance_employees = r0050_aveperformance_employees;
	}
	public BigDecimal getR0050_conduct_breaches_employees() {
		return r0050_conduct_breaches_employees;
	}
	public void setR0050_conduct_breaches_employees(BigDecimal r0050_conduct_breaches_employees) {
		this.r0050_conduct_breaches_employees = r0050_conduct_breaches_employees;
	}
	public BigDecimal getR0050_no_complaints_employees() {
		return r0050_no_complaints_employees;
	}
	public void setR0050_no_complaints_employees(BigDecimal r0050_no_complaints_employees) {
		this.r0050_no_complaints_employees = r0050_no_complaints_employees;
	}
	public BigDecimal getR0050_no_instancesbreaches_employees() {
		return r0050_no_instancesbreaches_employees;
	}
	public void setR0050_no_instancesbreaches_employees(BigDecimal r0050_no_instancesbreaches_employees) {
		this.r0050_no_instancesbreaches_employees = r0050_no_instancesbreaches_employees;
	}
	public BigDecimal getR0050_no_whistleblower_employees() {
		return r0050_no_whistleblower_employees;
	}
	public void setR0050_no_whistleblower_employees(BigDecimal r0050_no_whistleblower_employees) {
		this.r0050_no_whistleblower_employees = r0050_no_whistleblower_employees;
	}
	public BigDecimal getR0050_seniormanagement_training() {
		return r0050_seniormanagement_training;
	}
	public void setR0050_seniormanagement_training(BigDecimal r0050_seniormanagement_training) {
		this.r0050_seniormanagement_training = r0050_seniormanagement_training;
	}
	public BigDecimal getR0050_bankemployee_training() {
		return r0050_bankemployee_training;
	}
	public void setR0050_bankemployee_training(BigDecimal r0050_bankemployee_training) {
		this.r0050_bankemployee_training = r0050_bankemployee_training;
	}
	public BigDecimal getR0050_no_cavc_training() {
		return r0050_no_cavc_training;
	}
	public void setR0050_no_cavc_training(BigDecimal r0050_no_cavc_training) {
		this.r0050_no_cavc_training = r0050_no_cavc_training;
	}
	public BigDecimal getR0050_fraudsandscam_training() {
		return r0050_fraudsandscam_training;
	}
	public void setR0050_fraudsandscam_training(BigDecimal r0050_fraudsandscam_training) {
		this.r0050_fraudsandscam_training = r0050_fraudsandscam_training;
	}
	public BigDecimal getR0050_nmarketconduct_training() {
		return r0050_nmarketconduct_training;
	}
	public void setR0050_nmarketconduct_training(BigDecimal r0050_nmarketconduct_training) {
		this.r0050_nmarketconduct_training = r0050_nmarketconduct_training;
	}
	public BigDecimal getR0050_to_consumerprotection_training() {
		return r0050_to_consumerprotection_training;
	}
	public void setR0050_to_consumerprotection_training(BigDecimal r0050_to_consumerprotection_training) {
		this.r0050_to_consumerprotection_training = r0050_to_consumerprotection_training;
	}
	public BigDecimal getR0050_to_ombudsman_training() {
		return r0050_to_ombudsman_training;
	}
	public void setR0050_to_ombudsman_training(BigDecimal r0050_to_ombudsman_training) {
		this.r0050_to_ombudsman_training = r0050_to_ombudsman_training;
	}
	public String getR0060_product() {
		return r0060_product;
	}
	public void setR0060_product(String r0060_product) {
		this.r0060_product = r0060_product;
	}
	public BigDecimal getR0060_no_consumerfacing_employees() {
		return r0060_no_consumerfacing_employees;
	}
	public void setR0060_no_consumerfacing_employees(BigDecimal r0060_no_consumerfacing_employees) {
		this.r0060_no_consumerfacing_employees = r0060_no_consumerfacing_employees;
	}
	public BigDecimal getR0060_no_resigned_employees() {
		return r0060_no_resigned_employees;
	}
	public void setR0060_no_resigned_employees(BigDecimal r0060_no_resigned_employees) {
		this.r0060_no_resigned_employees = r0060_no_resigned_employees;
	}
	public BigDecimal getR0060_no_dismissed_employees() {
		return r0060_no_dismissed_employees;
	}
	public void setR0060_no_dismissed_employees(BigDecimal r0060_no_dismissed_employees) {
		this.r0060_no_dismissed_employees = r0060_no_dismissed_employees;
	}
	public BigDecimal getR0060_contractual_breaches_employees() {
		return r0060_contractual_breaches_employees;
	}
	public void setR0060_contractual_breaches_employees(BigDecimal r0060_contractual_breaches_employees) {
		this.r0060_contractual_breaches_employees = r0060_contractual_breaches_employees;
	}
	public BigDecimal getR0060_no_salesstaff_employees() {
		return r0060_no_salesstaff_employees;
	}
	public void setR0060_no_salesstaff_employees(BigDecimal r0060_no_salesstaff_employees) {
		this.r0060_no_salesstaff_employees = r0060_no_salesstaff_employees;
	}
	public BigDecimal getR0060_no_remuneration_employees() {
		return r0060_no_remuneration_employees;
	}
	public void setR0060_no_remuneration_employees(BigDecimal r0060_no_remuneration_employees) {
		this.r0060_no_remuneration_employees = r0060_no_remuneration_employees;
	}
	public BigDecimal getR0060_no_remuneration50per_employees() {
		return r0060_no_remuneration50per_employees;
	}
	public void setR0060_no_remuneration50per_employees(BigDecimal r0060_no_remuneration50per_employees) {
		this.r0060_no_remuneration50per_employees = r0060_no_remuneration50per_employees;
	}
	public BigDecimal getR0060_aveperformance_employees() {
		return r0060_aveperformance_employees;
	}
	public void setR0060_aveperformance_employees(BigDecimal r0060_aveperformance_employees) {
		this.r0060_aveperformance_employees = r0060_aveperformance_employees;
	}
	public BigDecimal getR0060_conduct_breaches_employees() {
		return r0060_conduct_breaches_employees;
	}
	public void setR0060_conduct_breaches_employees(BigDecimal r0060_conduct_breaches_employees) {
		this.r0060_conduct_breaches_employees = r0060_conduct_breaches_employees;
	}
	public BigDecimal getR0060_no_complaints_employees() {
		return r0060_no_complaints_employees;
	}
	public void setR0060_no_complaints_employees(BigDecimal r0060_no_complaints_employees) {
		this.r0060_no_complaints_employees = r0060_no_complaints_employees;
	}
	public BigDecimal getR0060_no_instancesbreaches_employees() {
		return r0060_no_instancesbreaches_employees;
	}
	public void setR0060_no_instancesbreaches_employees(BigDecimal r0060_no_instancesbreaches_employees) {
		this.r0060_no_instancesbreaches_employees = r0060_no_instancesbreaches_employees;
	}
	public BigDecimal getR0060_no_whistleblower_employees() {
		return r0060_no_whistleblower_employees;
	}
	public void setR0060_no_whistleblower_employees(BigDecimal r0060_no_whistleblower_employees) {
		this.r0060_no_whistleblower_employees = r0060_no_whistleblower_employees;
	}
	public BigDecimal getR0060_seniormanagement_training() {
		return r0060_seniormanagement_training;
	}
	public void setR0060_seniormanagement_training(BigDecimal r0060_seniormanagement_training) {
		this.r0060_seniormanagement_training = r0060_seniormanagement_training;
	}
	public BigDecimal getR0060_bankemployee_training() {
		return r0060_bankemployee_training;
	}
	public void setR0060_bankemployee_training(BigDecimal r0060_bankemployee_training) {
		this.r0060_bankemployee_training = r0060_bankemployee_training;
	}
	public BigDecimal getR0060_no_cavc_training() {
		return r0060_no_cavc_training;
	}
	public void setR0060_no_cavc_training(BigDecimal r0060_no_cavc_training) {
		this.r0060_no_cavc_training = r0060_no_cavc_training;
	}
	public BigDecimal getR0060_fraudsandscam_training() {
		return r0060_fraudsandscam_training;
	}
	public void setR0060_fraudsandscam_training(BigDecimal r0060_fraudsandscam_training) {
		this.r0060_fraudsandscam_training = r0060_fraudsandscam_training;
	}
	public BigDecimal getR0060_nmarketconduct_training() {
		return r0060_nmarketconduct_training;
	}
	public void setR0060_nmarketconduct_training(BigDecimal r0060_nmarketconduct_training) {
		this.r0060_nmarketconduct_training = r0060_nmarketconduct_training;
	}
	public BigDecimal getR0060_to_consumerprotection_training() {
		return r0060_to_consumerprotection_training;
	}
	public void setR0060_to_consumerprotection_training(BigDecimal r0060_to_consumerprotection_training) {
		this.r0060_to_consumerprotection_training = r0060_to_consumerprotection_training;
	}
	public BigDecimal getR0060_to_ombudsman_training() {
		return r0060_to_ombudsman_training;
	}
	public void setR0060_to_ombudsman_training(BigDecimal r0060_to_ombudsman_training) {
		this.r0060_to_ombudsman_training = r0060_to_ombudsman_training;
	}
	public String getR0070_product() {
		return r0070_product;
	}
	public void setR0070_product(String r0070_product) {
		this.r0070_product = r0070_product;
	}
	public BigDecimal getR0070_no_consumerfacing_employees() {
		return r0070_no_consumerfacing_employees;
	}
	public void setR0070_no_consumerfacing_employees(BigDecimal r0070_no_consumerfacing_employees) {
		this.r0070_no_consumerfacing_employees = r0070_no_consumerfacing_employees;
	}
	public BigDecimal getR0070_no_resigned_employees() {
		return r0070_no_resigned_employees;
	}
	public void setR0070_no_resigned_employees(BigDecimal r0070_no_resigned_employees) {
		this.r0070_no_resigned_employees = r0070_no_resigned_employees;
	}
	public BigDecimal getR0070_no_dismissed_employees() {
		return r0070_no_dismissed_employees;
	}
	public void setR0070_no_dismissed_employees(BigDecimal r0070_no_dismissed_employees) {
		this.r0070_no_dismissed_employees = r0070_no_dismissed_employees;
	}
	public BigDecimal getR0070_contractual_breaches_employees() {
		return r0070_contractual_breaches_employees;
	}
	public void setR0070_contractual_breaches_employees(BigDecimal r0070_contractual_breaches_employees) {
		this.r0070_contractual_breaches_employees = r0070_contractual_breaches_employees;
	}
	public BigDecimal getR0070_no_salesstaff_employees() {
		return r0070_no_salesstaff_employees;
	}
	public void setR0070_no_salesstaff_employees(BigDecimal r0070_no_salesstaff_employees) {
		this.r0070_no_salesstaff_employees = r0070_no_salesstaff_employees;
	}
	public BigDecimal getR0070_no_remuneration_employees() {
		return r0070_no_remuneration_employees;
	}
	public void setR0070_no_remuneration_employees(BigDecimal r0070_no_remuneration_employees) {
		this.r0070_no_remuneration_employees = r0070_no_remuneration_employees;
	}
	public BigDecimal getR0070_no_remuneration50per_employees() {
		return r0070_no_remuneration50per_employees;
	}
	public void setR0070_no_remuneration50per_employees(BigDecimal r0070_no_remuneration50per_employees) {
		this.r0070_no_remuneration50per_employees = r0070_no_remuneration50per_employees;
	}
	public BigDecimal getR0070_aveperformance_employees() {
		return r0070_aveperformance_employees;
	}
	public void setR0070_aveperformance_employees(BigDecimal r0070_aveperformance_employees) {
		this.r0070_aveperformance_employees = r0070_aveperformance_employees;
	}
	public BigDecimal getR0070_conduct_breaches_employees() {
		return r0070_conduct_breaches_employees;
	}
	public void setR0070_conduct_breaches_employees(BigDecimal r0070_conduct_breaches_employees) {
		this.r0070_conduct_breaches_employees = r0070_conduct_breaches_employees;
	}
	public BigDecimal getR0070_no_complaints_employees() {
		return r0070_no_complaints_employees;
	}
	public void setR0070_no_complaints_employees(BigDecimal r0070_no_complaints_employees) {
		this.r0070_no_complaints_employees = r0070_no_complaints_employees;
	}
	public BigDecimal getR0070_no_instancesbreaches_employees() {
		return r0070_no_instancesbreaches_employees;
	}
	public void setR0070_no_instancesbreaches_employees(BigDecimal r0070_no_instancesbreaches_employees) {
		this.r0070_no_instancesbreaches_employees = r0070_no_instancesbreaches_employees;
	}
	public BigDecimal getR0070_no_whistleblower_employees() {
		return r0070_no_whistleblower_employees;
	}
	public void setR0070_no_whistleblower_employees(BigDecimal r0070_no_whistleblower_employees) {
		this.r0070_no_whistleblower_employees = r0070_no_whistleblower_employees;
	}
	public BigDecimal getR0070_seniormanagement_training() {
		return r0070_seniormanagement_training;
	}
	public void setR0070_seniormanagement_training(BigDecimal r0070_seniormanagement_training) {
		this.r0070_seniormanagement_training = r0070_seniormanagement_training;
	}
	public BigDecimal getR0070_bankemployee_training() {
		return r0070_bankemployee_training;
	}
	public void setR0070_bankemployee_training(BigDecimal r0070_bankemployee_training) {
		this.r0070_bankemployee_training = r0070_bankemployee_training;
	}
	public BigDecimal getR0070_no_cavc_training() {
		return r0070_no_cavc_training;
	}
	public void setR0070_no_cavc_training(BigDecimal r0070_no_cavc_training) {
		this.r0070_no_cavc_training = r0070_no_cavc_training;
	}
	public BigDecimal getR0070_fraudsandscam_training() {
		return r0070_fraudsandscam_training;
	}
	public void setR0070_fraudsandscam_training(BigDecimal r0070_fraudsandscam_training) {
		this.r0070_fraudsandscam_training = r0070_fraudsandscam_training;
	}
	public BigDecimal getR0070_nmarketconduct_training() {
		return r0070_nmarketconduct_training;
	}
	public void setR0070_nmarketconduct_training(BigDecimal r0070_nmarketconduct_training) {
		this.r0070_nmarketconduct_training = r0070_nmarketconduct_training;
	}
	public BigDecimal getR0070_to_consumerprotection_training() {
		return r0070_to_consumerprotection_training;
	}
	public void setR0070_to_consumerprotection_training(BigDecimal r0070_to_consumerprotection_training) {
		this.r0070_to_consumerprotection_training = r0070_to_consumerprotection_training;
	}
	public BigDecimal getR0070_to_ombudsman_training() {
		return r0070_to_ombudsman_training;
	}
	public void setR0070_to_ombudsman_training(BigDecimal r0070_to_ombudsman_training) {
		this.r0070_to_ombudsman_training = r0070_to_ombudsman_training;
	}
	public String getR0080_product() {
		return r0080_product;
	}
	public void setR0080_product(String r0080_product) {
		this.r0080_product = r0080_product;
	}
	public BigDecimal getR0080_no_consumerfacing_employees() {
		return r0080_no_consumerfacing_employees;
	}
	public void setR0080_no_consumerfacing_employees(BigDecimal r0080_no_consumerfacing_employees) {
		this.r0080_no_consumerfacing_employees = r0080_no_consumerfacing_employees;
	}
	public BigDecimal getR0080_no_resigned_employees() {
		return r0080_no_resigned_employees;
	}
	public void setR0080_no_resigned_employees(BigDecimal r0080_no_resigned_employees) {
		this.r0080_no_resigned_employees = r0080_no_resigned_employees;
	}
	public BigDecimal getR0080_no_dismissed_employees() {
		return r0080_no_dismissed_employees;
	}
	public void setR0080_no_dismissed_employees(BigDecimal r0080_no_dismissed_employees) {
		this.r0080_no_dismissed_employees = r0080_no_dismissed_employees;
	}
	public BigDecimal getR0080_contractual_breaches_employees() {
		return r0080_contractual_breaches_employees;
	}
	public void setR0080_contractual_breaches_employees(BigDecimal r0080_contractual_breaches_employees) {
		this.r0080_contractual_breaches_employees = r0080_contractual_breaches_employees;
	}
	public BigDecimal getR0080_no_salesstaff_employees() {
		return r0080_no_salesstaff_employees;
	}
	public void setR0080_no_salesstaff_employees(BigDecimal r0080_no_salesstaff_employees) {
		this.r0080_no_salesstaff_employees = r0080_no_salesstaff_employees;
	}
	public BigDecimal getR0080_no_remuneration_employees() {
		return r0080_no_remuneration_employees;
	}
	public void setR0080_no_remuneration_employees(BigDecimal r0080_no_remuneration_employees) {
		this.r0080_no_remuneration_employees = r0080_no_remuneration_employees;
	}
	public BigDecimal getR0080_no_remuneration50per_employees() {
		return r0080_no_remuneration50per_employees;
	}
	public void setR0080_no_remuneration50per_employees(BigDecimal r0080_no_remuneration50per_employees) {
		this.r0080_no_remuneration50per_employees = r0080_no_remuneration50per_employees;
	}
	public BigDecimal getR0080_aveperformance_employees() {
		return r0080_aveperformance_employees;
	}
	public void setR0080_aveperformance_employees(BigDecimal r0080_aveperformance_employees) {
		this.r0080_aveperformance_employees = r0080_aveperformance_employees;
	}
	public BigDecimal getR0080_conduct_breaches_employees() {
		return r0080_conduct_breaches_employees;
	}
	public void setR0080_conduct_breaches_employees(BigDecimal r0080_conduct_breaches_employees) {
		this.r0080_conduct_breaches_employees = r0080_conduct_breaches_employees;
	}
	public BigDecimal getR0080_no_complaints_employees() {
		return r0080_no_complaints_employees;
	}
	public void setR0080_no_complaints_employees(BigDecimal r0080_no_complaints_employees) {
		this.r0080_no_complaints_employees = r0080_no_complaints_employees;
	}
	public BigDecimal getR0080_no_instancesbreaches_employees() {
		return r0080_no_instancesbreaches_employees;
	}
	public void setR0080_no_instancesbreaches_employees(BigDecimal r0080_no_instancesbreaches_employees) {
		this.r0080_no_instancesbreaches_employees = r0080_no_instancesbreaches_employees;
	}
	public BigDecimal getR0080_no_whistleblower_employees() {
		return r0080_no_whistleblower_employees;
	}
	public void setR0080_no_whistleblower_employees(BigDecimal r0080_no_whistleblower_employees) {
		this.r0080_no_whistleblower_employees = r0080_no_whistleblower_employees;
	}
	public BigDecimal getR0080_seniormanagement_training() {
		return r0080_seniormanagement_training;
	}
	public void setR0080_seniormanagement_training(BigDecimal r0080_seniormanagement_training) {
		this.r0080_seniormanagement_training = r0080_seniormanagement_training;
	}
	public BigDecimal getR0080_bankemployee_training() {
		return r0080_bankemployee_training;
	}
	public void setR0080_bankemployee_training(BigDecimal r0080_bankemployee_training) {
		this.r0080_bankemployee_training = r0080_bankemployee_training;
	}
	public BigDecimal getR0080_no_cavc_training() {
		return r0080_no_cavc_training;
	}
	public void setR0080_no_cavc_training(BigDecimal r0080_no_cavc_training) {
		this.r0080_no_cavc_training = r0080_no_cavc_training;
	}
	public BigDecimal getR0080_fraudsandscam_training() {
		return r0080_fraudsandscam_training;
	}
	public void setR0080_fraudsandscam_training(BigDecimal r0080_fraudsandscam_training) {
		this.r0080_fraudsandscam_training = r0080_fraudsandscam_training;
	}
	public BigDecimal getR0080_nmarketconduct_training() {
		return r0080_nmarketconduct_training;
	}
	public void setR0080_nmarketconduct_training(BigDecimal r0080_nmarketconduct_training) {
		this.r0080_nmarketconduct_training = r0080_nmarketconduct_training;
	}
	public BigDecimal getR0080_to_consumerprotection_training() {
		return r0080_to_consumerprotection_training;
	}
	public void setR0080_to_consumerprotection_training(BigDecimal r0080_to_consumerprotection_training) {
		this.r0080_to_consumerprotection_training = r0080_to_consumerprotection_training;
	}
	public BigDecimal getR0080_to_ombudsman_training() {
		return r0080_to_ombudsman_training;
	}
	public void setR0080_to_ombudsman_training(BigDecimal r0080_to_ombudsman_training) {
		this.r0080_to_ombudsman_training = r0080_to_ombudsman_training;
	}
	public String getR0090_product() {
		return r0090_product;
	}
	public void setR0090_product(String r0090_product) {
		this.r0090_product = r0090_product;
	}
	public BigDecimal getR0090_no_consumerfacing_employees() {
		return r0090_no_consumerfacing_employees;
	}
	public void setR0090_no_consumerfacing_employees(BigDecimal r0090_no_consumerfacing_employees) {
		this.r0090_no_consumerfacing_employees = r0090_no_consumerfacing_employees;
	}
	public BigDecimal getR0090_no_resigned_employees() {
		return r0090_no_resigned_employees;
	}
	public void setR0090_no_resigned_employees(BigDecimal r0090_no_resigned_employees) {
		this.r0090_no_resigned_employees = r0090_no_resigned_employees;
	}
	public BigDecimal getR0090_no_dismissed_employees() {
		return r0090_no_dismissed_employees;
	}
	public void setR0090_no_dismissed_employees(BigDecimal r0090_no_dismissed_employees) {
		this.r0090_no_dismissed_employees = r0090_no_dismissed_employees;
	}
	public BigDecimal getR0090_contractual_breaches_employees() {
		return r0090_contractual_breaches_employees;
	}
	public void setR0090_contractual_breaches_employees(BigDecimal r0090_contractual_breaches_employees) {
		this.r0090_contractual_breaches_employees = r0090_contractual_breaches_employees;
	}
	public BigDecimal getR0090_no_salesstaff_employees() {
		return r0090_no_salesstaff_employees;
	}
	public void setR0090_no_salesstaff_employees(BigDecimal r0090_no_salesstaff_employees) {
		this.r0090_no_salesstaff_employees = r0090_no_salesstaff_employees;
	}
	public BigDecimal getR0090_no_remuneration_employees() {
		return r0090_no_remuneration_employees;
	}
	public void setR0090_no_remuneration_employees(BigDecimal r0090_no_remuneration_employees) {
		this.r0090_no_remuneration_employees = r0090_no_remuneration_employees;
	}
	public BigDecimal getR0090_no_remuneration50per_employees() {
		return r0090_no_remuneration50per_employees;
	}
	public void setR0090_no_remuneration50per_employees(BigDecimal r0090_no_remuneration50per_employees) {
		this.r0090_no_remuneration50per_employees = r0090_no_remuneration50per_employees;
	}
	public BigDecimal getR0090_aveperformance_employees() {
		return r0090_aveperformance_employees;
	}
	public void setR0090_aveperformance_employees(BigDecimal r0090_aveperformance_employees) {
		this.r0090_aveperformance_employees = r0090_aveperformance_employees;
	}
	public BigDecimal getR0090_conduct_breaches_employees() {
		return r0090_conduct_breaches_employees;
	}
	public void setR0090_conduct_breaches_employees(BigDecimal r0090_conduct_breaches_employees) {
		this.r0090_conduct_breaches_employees = r0090_conduct_breaches_employees;
	}
	public BigDecimal getR0090_no_complaints_employees() {
		return r0090_no_complaints_employees;
	}
	public void setR0090_no_complaints_employees(BigDecimal r0090_no_complaints_employees) {
		this.r0090_no_complaints_employees = r0090_no_complaints_employees;
	}
	public BigDecimal getR0090_no_instancesbreaches_employees() {
		return r0090_no_instancesbreaches_employees;
	}
	public void setR0090_no_instancesbreaches_employees(BigDecimal r0090_no_instancesbreaches_employees) {
		this.r0090_no_instancesbreaches_employees = r0090_no_instancesbreaches_employees;
	}
	public BigDecimal getR0090_no_whistleblower_employees() {
		return r0090_no_whistleblower_employees;
	}
	public void setR0090_no_whistleblower_employees(BigDecimal r0090_no_whistleblower_employees) {
		this.r0090_no_whistleblower_employees = r0090_no_whistleblower_employees;
	}
	public BigDecimal getR0090_seniormanagement_training() {
		return r0090_seniormanagement_training;
	}
	public void setR0090_seniormanagement_training(BigDecimal r0090_seniormanagement_training) {
		this.r0090_seniormanagement_training = r0090_seniormanagement_training;
	}
	public BigDecimal getR0090_bankemployee_training() {
		return r0090_bankemployee_training;
	}
	public void setR0090_bankemployee_training(BigDecimal r0090_bankemployee_training) {
		this.r0090_bankemployee_training = r0090_bankemployee_training;
	}
	public BigDecimal getR0090_no_cavc_training() {
		return r0090_no_cavc_training;
	}
	public void setR0090_no_cavc_training(BigDecimal r0090_no_cavc_training) {
		this.r0090_no_cavc_training = r0090_no_cavc_training;
	}
	public BigDecimal getR0090_fraudsandscam_training() {
		return r0090_fraudsandscam_training;
	}
	public void setR0090_fraudsandscam_training(BigDecimal r0090_fraudsandscam_training) {
		this.r0090_fraudsandscam_training = r0090_fraudsandscam_training;
	}
	public BigDecimal getR0090_nmarketconduct_training() {
		return r0090_nmarketconduct_training;
	}
	public void setR0090_nmarketconduct_training(BigDecimal r0090_nmarketconduct_training) {
		this.r0090_nmarketconduct_training = r0090_nmarketconduct_training;
	}
	public BigDecimal getR0090_to_consumerprotection_training() {
		return r0090_to_consumerprotection_training;
	}
	public void setR0090_to_consumerprotection_training(BigDecimal r0090_to_consumerprotection_training) {
		this.r0090_to_consumerprotection_training = r0090_to_consumerprotection_training;
	}
	public BigDecimal getR0090_to_ombudsman_training() {
		return r0090_to_ombudsman_training;
	}
	public void setR0090_to_ombudsman_training(BigDecimal r0090_to_ombudsman_training) {
		this.r0090_to_ombudsman_training = r0090_to_ombudsman_training;
	}
	public String getR0100_product() {
		return r0100_product;
	}
	public void setR0100_product(String r0100_product) {
		this.r0100_product = r0100_product;
	}
	public BigDecimal getR0100_no_consumerfacing_employees() {
		return r0100_no_consumerfacing_employees;
	}
	public void setR0100_no_consumerfacing_employees(BigDecimal r0100_no_consumerfacing_employees) {
		this.r0100_no_consumerfacing_employees = r0100_no_consumerfacing_employees;
	}
	public BigDecimal getR0100_no_resigned_employees() {
		return r0100_no_resigned_employees;
	}
	public void setR0100_no_resigned_employees(BigDecimal r0100_no_resigned_employees) {
		this.r0100_no_resigned_employees = r0100_no_resigned_employees;
	}
	public BigDecimal getR0100_no_dismissed_employees() {
		return r0100_no_dismissed_employees;
	}
	public void setR0100_no_dismissed_employees(BigDecimal r0100_no_dismissed_employees) {
		this.r0100_no_dismissed_employees = r0100_no_dismissed_employees;
	}
	public BigDecimal getR0100_contractual_breaches_employees() {
		return r0100_contractual_breaches_employees;
	}
	public void setR0100_contractual_breaches_employees(BigDecimal r0100_contractual_breaches_employees) {
		this.r0100_contractual_breaches_employees = r0100_contractual_breaches_employees;
	}
	public BigDecimal getR0100_no_salesstaff_employees() {
		return r0100_no_salesstaff_employees;
	}
	public void setR0100_no_salesstaff_employees(BigDecimal r0100_no_salesstaff_employees) {
		this.r0100_no_salesstaff_employees = r0100_no_salesstaff_employees;
	}
	public BigDecimal getR0100_no_remuneration_employees() {
		return r0100_no_remuneration_employees;
	}
	public void setR0100_no_remuneration_employees(BigDecimal r0100_no_remuneration_employees) {
		this.r0100_no_remuneration_employees = r0100_no_remuneration_employees;
	}
	public BigDecimal getR0100_no_remuneration50per_employees() {
		return r0100_no_remuneration50per_employees;
	}
	public void setR0100_no_remuneration50per_employees(BigDecimal r0100_no_remuneration50per_employees) {
		this.r0100_no_remuneration50per_employees = r0100_no_remuneration50per_employees;
	}
	public BigDecimal getR0100_aveperformance_employees() {
		return r0100_aveperformance_employees;
	}
	public void setR0100_aveperformance_employees(BigDecimal r0100_aveperformance_employees) {
		this.r0100_aveperformance_employees = r0100_aveperformance_employees;
	}
	public BigDecimal getR0100_conduct_breaches_employees() {
		return r0100_conduct_breaches_employees;
	}
	public void setR0100_conduct_breaches_employees(BigDecimal r0100_conduct_breaches_employees) {
		this.r0100_conduct_breaches_employees = r0100_conduct_breaches_employees;
	}
	public BigDecimal getR0100_no_complaints_employees() {
		return r0100_no_complaints_employees;
	}
	public void setR0100_no_complaints_employees(BigDecimal r0100_no_complaints_employees) {
		this.r0100_no_complaints_employees = r0100_no_complaints_employees;
	}
	public BigDecimal getR0100_no_instancesbreaches_employees() {
		return r0100_no_instancesbreaches_employees;
	}
	public void setR0100_no_instancesbreaches_employees(BigDecimal r0100_no_instancesbreaches_employees) {
		this.r0100_no_instancesbreaches_employees = r0100_no_instancesbreaches_employees;
	}
	public BigDecimal getR0100_no_whistleblower_employees() {
		return r0100_no_whistleblower_employees;
	}
	public void setR0100_no_whistleblower_employees(BigDecimal r0100_no_whistleblower_employees) {
		this.r0100_no_whistleblower_employees = r0100_no_whistleblower_employees;
	}
	public BigDecimal getR0100_seniormanagement_training() {
		return r0100_seniormanagement_training;
	}
	public void setR0100_seniormanagement_training(BigDecimal r0100_seniormanagement_training) {
		this.r0100_seniormanagement_training = r0100_seniormanagement_training;
	}
	public BigDecimal getR0100_bankemployee_training() {
		return r0100_bankemployee_training;
	}
	public void setR0100_bankemployee_training(BigDecimal r0100_bankemployee_training) {
		this.r0100_bankemployee_training = r0100_bankemployee_training;
	}
	public BigDecimal getR0100_no_cavc_training() {
		return r0100_no_cavc_training;
	}
	public void setR0100_no_cavc_training(BigDecimal r0100_no_cavc_training) {
		this.r0100_no_cavc_training = r0100_no_cavc_training;
	}
	public BigDecimal getR0100_fraudsandscam_training() {
		return r0100_fraudsandscam_training;
	}
	public void setR0100_fraudsandscam_training(BigDecimal r0100_fraudsandscam_training) {
		this.r0100_fraudsandscam_training = r0100_fraudsandscam_training;
	}
	public BigDecimal getR0100_nmarketconduct_training() {
		return r0100_nmarketconduct_training;
	}
	public void setR0100_nmarketconduct_training(BigDecimal r0100_nmarketconduct_training) {
		this.r0100_nmarketconduct_training = r0100_nmarketconduct_training;
	}
	public BigDecimal getR0100_to_consumerprotection_training() {
		return r0100_to_consumerprotection_training;
	}
	public void setR0100_to_consumerprotection_training(BigDecimal r0100_to_consumerprotection_training) {
		this.r0100_to_consumerprotection_training = r0100_to_consumerprotection_training;
	}
	public BigDecimal getR0100_to_ombudsman_training() {
		return r0100_to_ombudsman_training;
	}
	public void setR0100_to_ombudsman_training(BigDecimal r0100_to_ombudsman_training) {
		this.r0100_to_ombudsman_training = r0100_to_ombudsman_training;
	}
	public String getR0110_product() {
		return r0110_product;
	}
	public void setR0110_product(String r0110_product) {
		this.r0110_product = r0110_product;
	}
	public BigDecimal getR0110_no_consumerfacing_employees() {
		return r0110_no_consumerfacing_employees;
	}
	public void setR0110_no_consumerfacing_employees(BigDecimal r0110_no_consumerfacing_employees) {
		this.r0110_no_consumerfacing_employees = r0110_no_consumerfacing_employees;
	}
	public BigDecimal getR0110_no_resigned_employees() {
		return r0110_no_resigned_employees;
	}
	public void setR0110_no_resigned_employees(BigDecimal r0110_no_resigned_employees) {
		this.r0110_no_resigned_employees = r0110_no_resigned_employees;
	}
	public BigDecimal getR0110_no_dismissed_employees() {
		return r0110_no_dismissed_employees;
	}
	public void setR0110_no_dismissed_employees(BigDecimal r0110_no_dismissed_employees) {
		this.r0110_no_dismissed_employees = r0110_no_dismissed_employees;
	}
	public BigDecimal getR0110_contractual_breaches_employees() {
		return r0110_contractual_breaches_employees;
	}
	public void setR0110_contractual_breaches_employees(BigDecimal r0110_contractual_breaches_employees) {
		this.r0110_contractual_breaches_employees = r0110_contractual_breaches_employees;
	}
	public BigDecimal getR0110_no_salesstaff_employees() {
		return r0110_no_salesstaff_employees;
	}
	public void setR0110_no_salesstaff_employees(BigDecimal r0110_no_salesstaff_employees) {
		this.r0110_no_salesstaff_employees = r0110_no_salesstaff_employees;
	}
	public BigDecimal getR0110_no_remuneration_employees() {
		return r0110_no_remuneration_employees;
	}
	public void setR0110_no_remuneration_employees(BigDecimal r0110_no_remuneration_employees) {
		this.r0110_no_remuneration_employees = r0110_no_remuneration_employees;
	}
	public BigDecimal getR0110_no_remuneration50per_employees() {
		return r0110_no_remuneration50per_employees;
	}
	public void setR0110_no_remuneration50per_employees(BigDecimal r0110_no_remuneration50per_employees) {
		this.r0110_no_remuneration50per_employees = r0110_no_remuneration50per_employees;
	}
	public BigDecimal getR0110_aveperformance_employees() {
		return r0110_aveperformance_employees;
	}
	public void setR0110_aveperformance_employees(BigDecimal r0110_aveperformance_employees) {
		this.r0110_aveperformance_employees = r0110_aveperformance_employees;
	}
	public BigDecimal getR0110_conduct_breaches_employees() {
		return r0110_conduct_breaches_employees;
	}
	public void setR0110_conduct_breaches_employees(BigDecimal r0110_conduct_breaches_employees) {
		this.r0110_conduct_breaches_employees = r0110_conduct_breaches_employees;
	}
	public BigDecimal getR0110_no_complaints_employees() {
		return r0110_no_complaints_employees;
	}
	public void setR0110_no_complaints_employees(BigDecimal r0110_no_complaints_employees) {
		this.r0110_no_complaints_employees = r0110_no_complaints_employees;
	}
	public BigDecimal getR0110_no_instancesbreaches_employees() {
		return r0110_no_instancesbreaches_employees;
	}
	public void setR0110_no_instancesbreaches_employees(BigDecimal r0110_no_instancesbreaches_employees) {
		this.r0110_no_instancesbreaches_employees = r0110_no_instancesbreaches_employees;
	}
	public BigDecimal getR0110_no_whistleblower_employees() {
		return r0110_no_whistleblower_employees;
	}
	public void setR0110_no_whistleblower_employees(BigDecimal r0110_no_whistleblower_employees) {
		this.r0110_no_whistleblower_employees = r0110_no_whistleblower_employees;
	}
	public BigDecimal getR0110_seniormanagement_training() {
		return r0110_seniormanagement_training;
	}
	public void setR0110_seniormanagement_training(BigDecimal r0110_seniormanagement_training) {
		this.r0110_seniormanagement_training = r0110_seniormanagement_training;
	}
	public BigDecimal getR0110_bankemployee_training() {
		return r0110_bankemployee_training;
	}
	public void setR0110_bankemployee_training(BigDecimal r0110_bankemployee_training) {
		this.r0110_bankemployee_training = r0110_bankemployee_training;
	}
	public BigDecimal getR0110_no_cavc_training() {
		return r0110_no_cavc_training;
	}
	public void setR0110_no_cavc_training(BigDecimal r0110_no_cavc_training) {
		this.r0110_no_cavc_training = r0110_no_cavc_training;
	}
	public BigDecimal getR0110_fraudsandscam_training() {
		return r0110_fraudsandscam_training;
	}
	public void setR0110_fraudsandscam_training(BigDecimal r0110_fraudsandscam_training) {
		this.r0110_fraudsandscam_training = r0110_fraudsandscam_training;
	}
	public BigDecimal getR0110_nmarketconduct_training() {
		return r0110_nmarketconduct_training;
	}
	public void setR0110_nmarketconduct_training(BigDecimal r0110_nmarketconduct_training) {
		this.r0110_nmarketconduct_training = r0110_nmarketconduct_training;
	}
	public BigDecimal getR0110_to_consumerprotection_training() {
		return r0110_to_consumerprotection_training;
	}
	public void setR0110_to_consumerprotection_training(BigDecimal r0110_to_consumerprotection_training) {
		this.r0110_to_consumerprotection_training = r0110_to_consumerprotection_training;
	}
	public BigDecimal getR0110_to_ombudsman_training() {
		return r0110_to_ombudsman_training;
	}
	public void setR0110_to_ombudsman_training(BigDecimal r0110_to_ombudsman_training) {
		this.r0110_to_ombudsman_training = r0110_to_ombudsman_training;
	}
	public String getR0120_product() {
		return r0120_product;
	}
	public void setR0120_product(String r0120_product) {
		this.r0120_product = r0120_product;
	}
	public BigDecimal getR0120_no_consumerfacing_employees() {
		return r0120_no_consumerfacing_employees;
	}
	public void setR0120_no_consumerfacing_employees(BigDecimal r0120_no_consumerfacing_employees) {
		this.r0120_no_consumerfacing_employees = r0120_no_consumerfacing_employees;
	}
	public BigDecimal getR0120_no_resigned_employees() {
		return r0120_no_resigned_employees;
	}
	public void setR0120_no_resigned_employees(BigDecimal r0120_no_resigned_employees) {
		this.r0120_no_resigned_employees = r0120_no_resigned_employees;
	}
	public BigDecimal getR0120_no_dismissed_employees() {
		return r0120_no_dismissed_employees;
	}
	public void setR0120_no_dismissed_employees(BigDecimal r0120_no_dismissed_employees) {
		this.r0120_no_dismissed_employees = r0120_no_dismissed_employees;
	}
	public BigDecimal getR0120_contractual_breaches_employees() {
		return r0120_contractual_breaches_employees;
	}
	public void setR0120_contractual_breaches_employees(BigDecimal r0120_contractual_breaches_employees) {
		this.r0120_contractual_breaches_employees = r0120_contractual_breaches_employees;
	}
	public BigDecimal getR0120_no_salesstaff_employees() {
		return r0120_no_salesstaff_employees;
	}
	public void setR0120_no_salesstaff_employees(BigDecimal r0120_no_salesstaff_employees) {
		this.r0120_no_salesstaff_employees = r0120_no_salesstaff_employees;
	}
	public BigDecimal getR0120_no_remuneration_employees() {
		return r0120_no_remuneration_employees;
	}
	public void setR0120_no_remuneration_employees(BigDecimal r0120_no_remuneration_employees) {
		this.r0120_no_remuneration_employees = r0120_no_remuneration_employees;
	}
	public BigDecimal getR0120_no_remuneration50per_employees() {
		return r0120_no_remuneration50per_employees;
	}
	public void setR0120_no_remuneration50per_employees(BigDecimal r0120_no_remuneration50per_employees) {
		this.r0120_no_remuneration50per_employees = r0120_no_remuneration50per_employees;
	}
	public BigDecimal getR0120_aveperformance_employees() {
		return r0120_aveperformance_employees;
	}
	public void setR0120_aveperformance_employees(BigDecimal r0120_aveperformance_employees) {
		this.r0120_aveperformance_employees = r0120_aveperformance_employees;
	}
	public BigDecimal getR0120_conduct_breaches_employees() {
		return r0120_conduct_breaches_employees;
	}
	public void setR0120_conduct_breaches_employees(BigDecimal r0120_conduct_breaches_employees) {
		this.r0120_conduct_breaches_employees = r0120_conduct_breaches_employees;
	}
	public BigDecimal getR0120_no_complaints_employees() {
		return r0120_no_complaints_employees;
	}
	public void setR0120_no_complaints_employees(BigDecimal r0120_no_complaints_employees) {
		this.r0120_no_complaints_employees = r0120_no_complaints_employees;
	}
	public BigDecimal getR0120_no_instancesbreaches_employees() {
		return r0120_no_instancesbreaches_employees;
	}
	public void setR0120_no_instancesbreaches_employees(BigDecimal r0120_no_instancesbreaches_employees) {
		this.r0120_no_instancesbreaches_employees = r0120_no_instancesbreaches_employees;
	}
	public BigDecimal getR0120_no_whistleblower_employees() {
		return r0120_no_whistleblower_employees;
	}
	public void setR0120_no_whistleblower_employees(BigDecimal r0120_no_whistleblower_employees) {
		this.r0120_no_whistleblower_employees = r0120_no_whistleblower_employees;
	}
	public BigDecimal getR0120_seniormanagement_training() {
		return r0120_seniormanagement_training;
	}
	public void setR0120_seniormanagement_training(BigDecimal r0120_seniormanagement_training) {
		this.r0120_seniormanagement_training = r0120_seniormanagement_training;
	}
	public BigDecimal getR0120_bankemployee_training() {
		return r0120_bankemployee_training;
	}
	public void setR0120_bankemployee_training(BigDecimal r0120_bankemployee_training) {
		this.r0120_bankemployee_training = r0120_bankemployee_training;
	}
	public BigDecimal getR0120_no_cavc_training() {
		return r0120_no_cavc_training;
	}
	public void setR0120_no_cavc_training(BigDecimal r0120_no_cavc_training) {
		this.r0120_no_cavc_training = r0120_no_cavc_training;
	}
	public BigDecimal getR0120_fraudsandscam_training() {
		return r0120_fraudsandscam_training;
	}
	public void setR0120_fraudsandscam_training(BigDecimal r0120_fraudsandscam_training) {
		this.r0120_fraudsandscam_training = r0120_fraudsandscam_training;
	}
	public BigDecimal getR0120_nmarketconduct_training() {
		return r0120_nmarketconduct_training;
	}
	public void setR0120_nmarketconduct_training(BigDecimal r0120_nmarketconduct_training) {
		this.r0120_nmarketconduct_training = r0120_nmarketconduct_training;
	}
	public BigDecimal getR0120_to_consumerprotection_training() {
		return r0120_to_consumerprotection_training;
	}
	public void setR0120_to_consumerprotection_training(BigDecimal r0120_to_consumerprotection_training) {
		this.r0120_to_consumerprotection_training = r0120_to_consumerprotection_training;
	}
	public BigDecimal getR0120_to_ombudsman_training() {
		return r0120_to_ombudsman_training;
	}
	public void setR0120_to_ombudsman_training(BigDecimal r0120_to_ombudsman_training) {
		this.r0120_to_ombudsman_training = r0120_to_ombudsman_training;
	}
	public String getR0130_product() {
		return r0130_product;
	}
	public void setR0130_product(String r0130_product) {
		this.r0130_product = r0130_product;
	}
	public BigDecimal getR0130_no_consumerfacing_employees() {
		return r0130_no_consumerfacing_employees;
	}
	public void setR0130_no_consumerfacing_employees(BigDecimal r0130_no_consumerfacing_employees) {
		this.r0130_no_consumerfacing_employees = r0130_no_consumerfacing_employees;
	}
	public BigDecimal getR0130_no_resigned_employees() {
		return r0130_no_resigned_employees;
	}
	public void setR0130_no_resigned_employees(BigDecimal r0130_no_resigned_employees) {
		this.r0130_no_resigned_employees = r0130_no_resigned_employees;
	}
	public BigDecimal getR0130_no_dismissed_employees() {
		return r0130_no_dismissed_employees;
	}
	public void setR0130_no_dismissed_employees(BigDecimal r0130_no_dismissed_employees) {
		this.r0130_no_dismissed_employees = r0130_no_dismissed_employees;
	}
	public BigDecimal getR0130_contractual_breaches_employees() {
		return r0130_contractual_breaches_employees;
	}
	public void setR0130_contractual_breaches_employees(BigDecimal r0130_contractual_breaches_employees) {
		this.r0130_contractual_breaches_employees = r0130_contractual_breaches_employees;
	}
	public BigDecimal getR0130_no_salesstaff_employees() {
		return r0130_no_salesstaff_employees;
	}
	public void setR0130_no_salesstaff_employees(BigDecimal r0130_no_salesstaff_employees) {
		this.r0130_no_salesstaff_employees = r0130_no_salesstaff_employees;
	}
	public BigDecimal getR0130_no_remuneration_employees() {
		return r0130_no_remuneration_employees;
	}
	public void setR0130_no_remuneration_employees(BigDecimal r0130_no_remuneration_employees) {
		this.r0130_no_remuneration_employees = r0130_no_remuneration_employees;
	}
	public BigDecimal getR0130_no_remuneration50per_employees() {
		return r0130_no_remuneration50per_employees;
	}
	public void setR0130_no_remuneration50per_employees(BigDecimal r0130_no_remuneration50per_employees) {
		this.r0130_no_remuneration50per_employees = r0130_no_remuneration50per_employees;
	}
	public BigDecimal getR0130_aveperformance_employees() {
		return r0130_aveperformance_employees;
	}
	public void setR0130_aveperformance_employees(BigDecimal r0130_aveperformance_employees) {
		this.r0130_aveperformance_employees = r0130_aveperformance_employees;
	}
	public BigDecimal getR0130_conduct_breaches_employees() {
		return r0130_conduct_breaches_employees;
	}
	public void setR0130_conduct_breaches_employees(BigDecimal r0130_conduct_breaches_employees) {
		this.r0130_conduct_breaches_employees = r0130_conduct_breaches_employees;
	}
	public BigDecimal getR0130_no_complaints_employees() {
		return r0130_no_complaints_employees;
	}
	public void setR0130_no_complaints_employees(BigDecimal r0130_no_complaints_employees) {
		this.r0130_no_complaints_employees = r0130_no_complaints_employees;
	}
	public BigDecimal getR0130_no_instancesbreaches_employees() {
		return r0130_no_instancesbreaches_employees;
	}
	public void setR0130_no_instancesbreaches_employees(BigDecimal r0130_no_instancesbreaches_employees) {
		this.r0130_no_instancesbreaches_employees = r0130_no_instancesbreaches_employees;
	}
	public BigDecimal getR0130_no_whistleblower_employees() {
		return r0130_no_whistleblower_employees;
	}
	public void setR0130_no_whistleblower_employees(BigDecimal r0130_no_whistleblower_employees) {
		this.r0130_no_whistleblower_employees = r0130_no_whistleblower_employees;
	}
	public BigDecimal getR0130_seniormanagement_training() {
		return r0130_seniormanagement_training;
	}
	public void setR0130_seniormanagement_training(BigDecimal r0130_seniormanagement_training) {
		this.r0130_seniormanagement_training = r0130_seniormanagement_training;
	}
	public BigDecimal getR0130_bankemployee_training() {
		return r0130_bankemployee_training;
	}
	public void setR0130_bankemployee_training(BigDecimal r0130_bankemployee_training) {
		this.r0130_bankemployee_training = r0130_bankemployee_training;
	}
	public BigDecimal getR0130_no_cavc_training() {
		return r0130_no_cavc_training;
	}
	public void setR0130_no_cavc_training(BigDecimal r0130_no_cavc_training) {
		this.r0130_no_cavc_training = r0130_no_cavc_training;
	}
	public BigDecimal getR0130_fraudsandscam_training() {
		return r0130_fraudsandscam_training;
	}
	public void setR0130_fraudsandscam_training(BigDecimal r0130_fraudsandscam_training) {
		this.r0130_fraudsandscam_training = r0130_fraudsandscam_training;
	}
	public BigDecimal getR0130_nmarketconduct_training() {
		return r0130_nmarketconduct_training;
	}
	public void setR0130_nmarketconduct_training(BigDecimal r0130_nmarketconduct_training) {
		this.r0130_nmarketconduct_training = r0130_nmarketconduct_training;
	}
	public BigDecimal getR0130_to_consumerprotection_training() {
		return r0130_to_consumerprotection_training;
	}
	public void setR0130_to_consumerprotection_training(BigDecimal r0130_to_consumerprotection_training) {
		this.r0130_to_consumerprotection_training = r0130_to_consumerprotection_training;
	}
	public BigDecimal getR0130_to_ombudsman_training() {
		return r0130_to_ombudsman_training;
	}
	public void setR0130_to_ombudsman_training(BigDecimal r0130_to_ombudsman_training) {
		this.r0130_to_ombudsman_training = r0130_to_ombudsman_training;
	}
	public String getR0140_product() {
		return r0140_product;
	}
	public void setR0140_product(String r0140_product) {
		this.r0140_product = r0140_product;
	}
	public BigDecimal getR0140_no_consumerfacing_employees() {
		return r0140_no_consumerfacing_employees;
	}
	public void setR0140_no_consumerfacing_employees(BigDecimal r0140_no_consumerfacing_employees) {
		this.r0140_no_consumerfacing_employees = r0140_no_consumerfacing_employees;
	}
	public BigDecimal getR0140_no_resigned_employees() {
		return r0140_no_resigned_employees;
	}
	public void setR0140_no_resigned_employees(BigDecimal r0140_no_resigned_employees) {
		this.r0140_no_resigned_employees = r0140_no_resigned_employees;
	}
	public BigDecimal getR0140_no_dismissed_employees() {
		return r0140_no_dismissed_employees;
	}
	public void setR0140_no_dismissed_employees(BigDecimal r0140_no_dismissed_employees) {
		this.r0140_no_dismissed_employees = r0140_no_dismissed_employees;
	}
	public BigDecimal getR0140_contractual_breaches_employees() {
		return r0140_contractual_breaches_employees;
	}
	public void setR0140_contractual_breaches_employees(BigDecimal r0140_contractual_breaches_employees) {
		this.r0140_contractual_breaches_employees = r0140_contractual_breaches_employees;
	}
	public BigDecimal getR0140_no_salesstaff_employees() {
		return r0140_no_salesstaff_employees;
	}
	public void setR0140_no_salesstaff_employees(BigDecimal r0140_no_salesstaff_employees) {
		this.r0140_no_salesstaff_employees = r0140_no_salesstaff_employees;
	}
	public BigDecimal getR0140_no_remuneration_employees() {
		return r0140_no_remuneration_employees;
	}
	public void setR0140_no_remuneration_employees(BigDecimal r0140_no_remuneration_employees) {
		this.r0140_no_remuneration_employees = r0140_no_remuneration_employees;
	}
	public BigDecimal getR0140_no_remuneration50per_employees() {
		return r0140_no_remuneration50per_employees;
	}
	public void setR0140_no_remuneration50per_employees(BigDecimal r0140_no_remuneration50per_employees) {
		this.r0140_no_remuneration50per_employees = r0140_no_remuneration50per_employees;
	}
	public BigDecimal getR0140_aveperformance_employees() {
		return r0140_aveperformance_employees;
	}
	public void setR0140_aveperformance_employees(BigDecimal r0140_aveperformance_employees) {
		this.r0140_aveperformance_employees = r0140_aveperformance_employees;
	}
	public BigDecimal getR0140_conduct_breaches_employees() {
		return r0140_conduct_breaches_employees;
	}
	public void setR0140_conduct_breaches_employees(BigDecimal r0140_conduct_breaches_employees) {
		this.r0140_conduct_breaches_employees = r0140_conduct_breaches_employees;
	}
	public BigDecimal getR0140_no_complaints_employees() {
		return r0140_no_complaints_employees;
	}
	public void setR0140_no_complaints_employees(BigDecimal r0140_no_complaints_employees) {
		this.r0140_no_complaints_employees = r0140_no_complaints_employees;
	}
	public BigDecimal getR0140_no_instancesbreaches_employees() {
		return r0140_no_instancesbreaches_employees;
	}
	public void setR0140_no_instancesbreaches_employees(BigDecimal r0140_no_instancesbreaches_employees) {
		this.r0140_no_instancesbreaches_employees = r0140_no_instancesbreaches_employees;
	}
	public BigDecimal getR0140_no_whistleblower_employees() {
		return r0140_no_whistleblower_employees;
	}
	public void setR0140_no_whistleblower_employees(BigDecimal r0140_no_whistleblower_employees) {
		this.r0140_no_whistleblower_employees = r0140_no_whistleblower_employees;
	}
	public BigDecimal getR0140_seniormanagement_training() {
		return r0140_seniormanagement_training;
	}
	public void setR0140_seniormanagement_training(BigDecimal r0140_seniormanagement_training) {
		this.r0140_seniormanagement_training = r0140_seniormanagement_training;
	}
	public BigDecimal getR0140_bankemployee_training() {
		return r0140_bankemployee_training;
	}
	public void setR0140_bankemployee_training(BigDecimal r0140_bankemployee_training) {
		this.r0140_bankemployee_training = r0140_bankemployee_training;
	}
	public BigDecimal getR0140_no_cavc_training() {
		return r0140_no_cavc_training;
	}
	public void setR0140_no_cavc_training(BigDecimal r0140_no_cavc_training) {
		this.r0140_no_cavc_training = r0140_no_cavc_training;
	}
	public BigDecimal getR0140_fraudsandscam_training() {
		return r0140_fraudsandscam_training;
	}
	public void setR0140_fraudsandscam_training(BigDecimal r0140_fraudsandscam_training) {
		this.r0140_fraudsandscam_training = r0140_fraudsandscam_training;
	}
	public BigDecimal getR0140_nmarketconduct_training() {
		return r0140_nmarketconduct_training;
	}
	public void setR0140_nmarketconduct_training(BigDecimal r0140_nmarketconduct_training) {
		this.r0140_nmarketconduct_training = r0140_nmarketconduct_training;
	}
	public BigDecimal getR0140_to_consumerprotection_training() {
		return r0140_to_consumerprotection_training;
	}
	public void setR0140_to_consumerprotection_training(BigDecimal r0140_to_consumerprotection_training) {
		this.r0140_to_consumerprotection_training = r0140_to_consumerprotection_training;
	}
	public BigDecimal getR0140_to_ombudsman_training() {
		return r0140_to_ombudsman_training;
	}
	public void setR0140_to_ombudsman_training(BigDecimal r0140_to_ombudsman_training) {
		this.r0140_to_ombudsman_training = r0140_to_ombudsman_training;
	}
	public String getR0150_product() {
		return r0150_product;
	}
	public void setR0150_product(String r0150_product) {
		this.r0150_product = r0150_product;
	}
	public BigDecimal getR0150_no_consumerfacing_employees() {
		return r0150_no_consumerfacing_employees;
	}
	public void setR0150_no_consumerfacing_employees(BigDecimal r0150_no_consumerfacing_employees) {
		this.r0150_no_consumerfacing_employees = r0150_no_consumerfacing_employees;
	}
	public BigDecimal getR0150_no_resigned_employees() {
		return r0150_no_resigned_employees;
	}
	public void setR0150_no_resigned_employees(BigDecimal r0150_no_resigned_employees) {
		this.r0150_no_resigned_employees = r0150_no_resigned_employees;
	}
	public BigDecimal getR0150_no_dismissed_employees() {
		return r0150_no_dismissed_employees;
	}
	public void setR0150_no_dismissed_employees(BigDecimal r0150_no_dismissed_employees) {
		this.r0150_no_dismissed_employees = r0150_no_dismissed_employees;
	}
	public BigDecimal getR0150_contractual_breaches_employees() {
		return r0150_contractual_breaches_employees;
	}
	public void setR0150_contractual_breaches_employees(BigDecimal r0150_contractual_breaches_employees) {
		this.r0150_contractual_breaches_employees = r0150_contractual_breaches_employees;
	}
	public BigDecimal getR0150_no_salesstaff_employees() {
		return r0150_no_salesstaff_employees;
	}
	public void setR0150_no_salesstaff_employees(BigDecimal r0150_no_salesstaff_employees) {
		this.r0150_no_salesstaff_employees = r0150_no_salesstaff_employees;
	}
	public BigDecimal getR0150_no_remuneration_employees() {
		return r0150_no_remuneration_employees;
	}
	public void setR0150_no_remuneration_employees(BigDecimal r0150_no_remuneration_employees) {
		this.r0150_no_remuneration_employees = r0150_no_remuneration_employees;
	}
	public BigDecimal getR0150_no_remuneration50per_employees() {
		return r0150_no_remuneration50per_employees;
	}
	public void setR0150_no_remuneration50per_employees(BigDecimal r0150_no_remuneration50per_employees) {
		this.r0150_no_remuneration50per_employees = r0150_no_remuneration50per_employees;
	}
	public BigDecimal getR0150_aveperformance_employees() {
		return r0150_aveperformance_employees;
	}
	public void setR0150_aveperformance_employees(BigDecimal r0150_aveperformance_employees) {
		this.r0150_aveperformance_employees = r0150_aveperformance_employees;
	}
	public BigDecimal getR0150_conduct_breaches_employees() {
		return r0150_conduct_breaches_employees;
	}
	public void setR0150_conduct_breaches_employees(BigDecimal r0150_conduct_breaches_employees) {
		this.r0150_conduct_breaches_employees = r0150_conduct_breaches_employees;
	}
	public BigDecimal getR0150_no_complaints_employees() {
		return r0150_no_complaints_employees;
	}
	public void setR0150_no_complaints_employees(BigDecimal r0150_no_complaints_employees) {
		this.r0150_no_complaints_employees = r0150_no_complaints_employees;
	}
	public BigDecimal getR0150_no_instancesbreaches_employees() {
		return r0150_no_instancesbreaches_employees;
	}
	public void setR0150_no_instancesbreaches_employees(BigDecimal r0150_no_instancesbreaches_employees) {
		this.r0150_no_instancesbreaches_employees = r0150_no_instancesbreaches_employees;
	}
	public BigDecimal getR0150_no_whistleblower_employees() {
		return r0150_no_whistleblower_employees;
	}
	public void setR0150_no_whistleblower_employees(BigDecimal r0150_no_whistleblower_employees) {
		this.r0150_no_whistleblower_employees = r0150_no_whistleblower_employees;
	}
	public BigDecimal getR0150_seniormanagement_training() {
		return r0150_seniormanagement_training;
	}
	public void setR0150_seniormanagement_training(BigDecimal r0150_seniormanagement_training) {
		this.r0150_seniormanagement_training = r0150_seniormanagement_training;
	}
	public BigDecimal getR0150_bankemployee_training() {
		return r0150_bankemployee_training;
	}
	public void setR0150_bankemployee_training(BigDecimal r0150_bankemployee_training) {
		this.r0150_bankemployee_training = r0150_bankemployee_training;
	}
	public BigDecimal getR0150_no_cavc_training() {
		return r0150_no_cavc_training;
	}
	public void setR0150_no_cavc_training(BigDecimal r0150_no_cavc_training) {
		this.r0150_no_cavc_training = r0150_no_cavc_training;
	}
	public BigDecimal getR0150_fraudsandscam_training() {
		return r0150_fraudsandscam_training;
	}
	public void setR0150_fraudsandscam_training(BigDecimal r0150_fraudsandscam_training) {
		this.r0150_fraudsandscam_training = r0150_fraudsandscam_training;
	}
	public BigDecimal getR0150_nmarketconduct_training() {
		return r0150_nmarketconduct_training;
	}
	public void setR0150_nmarketconduct_training(BigDecimal r0150_nmarketconduct_training) {
		this.r0150_nmarketconduct_training = r0150_nmarketconduct_training;
	}
	public BigDecimal getR0150_to_consumerprotection_training() {
		return r0150_to_consumerprotection_training;
	}
	public void setR0150_to_consumerprotection_training(BigDecimal r0150_to_consumerprotection_training) {
		this.r0150_to_consumerprotection_training = r0150_to_consumerprotection_training;
	}
	public BigDecimal getR0150_to_ombudsman_training() {
		return r0150_to_ombudsman_training;
	}
	public void setR0150_to_ombudsman_training(BigDecimal r0150_to_ombudsman_training) {
		this.r0150_to_ombudsman_training = r0150_to_ombudsman_training;
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
	public CBUAE_BRF16_2_Archival_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
