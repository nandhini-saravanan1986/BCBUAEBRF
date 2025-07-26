package com.bornfire.brf.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CBUAE_BRF16_5_SUMMARYTABLE")
public class CBUAE_BRF16_5_Summary_Entity {
	@Id
	private Long	id;
	private String	r0010_complaint_catogory;
	private String	r0020_root_cause;
	private String	r0030_corrective_action;

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
	public String getR0010_complaint_catogory() {
		return r0010_complaint_catogory;
	}
	public void setR0010_complaint_catogory(String r0010_complaint_catogory) {
		this.r0010_complaint_catogory = r0010_complaint_catogory;
	}
	public String getR0020_root_cause() {
		return r0020_root_cause;
	}
	public void setR0020_root_cause(String r0020_root_cause) {
		this.r0020_root_cause = r0020_root_cause;
	}
	public String getR0030_corrective_action() {
		return r0030_corrective_action;
	}
	public void setR0030_corrective_action(String r0030_corrective_action) {
		this.r0030_corrective_action = r0030_corrective_action;
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
	public CBUAE_BRF16_5_Summary_Entity(Long id, String r0010_complaint_catogory, String r0020_root_cause,
			String r0030_corrective_action, Date report_date, String report_version, String report_frequency,
			String report_code, String report_desc, String modify_flg, String entity_flg, String delete_flg) {
		super();
		this.id = id;
		this.r0010_complaint_catogory = r0010_complaint_catogory;
		this.r0020_root_cause = r0020_root_cause;
		this.r0030_corrective_action = r0030_corrective_action;
		this.report_date = report_date;
		this.report_version = report_version;
		this.report_frequency = report_frequency;
		this.report_code = report_code;
		this.report_desc = report_desc;
		this.modify_flg = modify_flg;
		this.entity_flg = entity_flg;
		this.delete_flg = delete_flg;
	}
	public CBUAE_BRF16_5_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
