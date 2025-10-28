package com.bornfire.brf.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BASE_MAPPING_TABLE")

public class BaseMappingParameter {
	private String	gl_head;
	private String	gl_subhead_code;
	 @Id
	@Column(name = "ACCOUNT_ID_BACID") 
	private String	account_id_bacid;
	private String	account_description;
	private String	currency;
	private String	data_type;
	private String	entity_flg;
	private String	auth_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	auth_time;
	private Date	report_date;
	private String	report_version;
	private String	report_frequency;
	@Column(name = "REPORT_CODE")
	private String reportCode;
	private String	report_desc;
	public String getGl_head() {
		return gl_head;
	}
	public void setGl_head(String gl_head) {
		this.gl_head = gl_head;
	}
	public String getGl_subhead_code() {
		return gl_subhead_code;
	}
	public void setGl_subhead_code(String gl_subhead_code) {
		this.gl_subhead_code = gl_subhead_code;
	}
	public String getAccount_id_bacid() {
		return account_id_bacid;
	}
	public void setAccount_id_bacid(String account_id_bacid) {
		this.account_id_bacid = account_id_bacid;
	}
	public String getAccount_description() {
		return account_description;
	}
	public void setAccount_description(String account_description) {
		this.account_description = account_description;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getAuth_flg() {
		return auth_flg;
	}
	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
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
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
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
		return reportCode;
	}
	public void setReport_code(String report_code) {
		this.reportCode = report_code;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public BaseMappingParameter(String gl_head, String gl_subhead_code, String account_id_bacid,
			String account_description, String currency, String data_type, String entity_flg, String auth_flg,
			String modify_flg, String del_flg, String entry_user, String modify_user, String auth_user, Date entry_time,
			Date modify_time, Date auth_time, Date report_date, String report_version, String report_frequency,
			String report_code, String report_desc) {
		super();
		this.gl_head = gl_head;
		this.gl_subhead_code = gl_subhead_code;
		this.account_id_bacid = account_id_bacid;
		this.account_description = account_description;
		this.currency = currency;
		this.data_type = data_type;
		this.entity_flg = entity_flg;
		this.auth_flg = auth_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
		this.report_date = report_date;
		this.report_version = report_version;
		this.report_frequency = report_frequency;
		this.reportCode = report_code;
		this.report_desc = report_desc;
	}
	public BaseMappingParameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
