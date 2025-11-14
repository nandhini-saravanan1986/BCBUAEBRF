package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CBUAE_BRF1_1_MAPPING_TABLE")
public class CBUAE_BRF1_1_Mapping_Entity {

	@Id
	@Column(name = "FORACID", length = 50)
	private String foracid;

	@Column(name = "BR_CODE", length = 20)
	private String br_code;

	@Column(name = "SOL_ID", length = 20)
	private String sol_id;

	@Column(name = "CUST_ID", length = 20)
	private String cust_id;

	@Column(name = "GLSH_CODE", length = 20)
	private String glsh_code;

	@Column(name = "GL_CODE", length = 20)
	private String gl_code;

	@Column(name = "ACCT_CRNCY_CODE", length = 10)
	private String acct_crncy_code;

	@Column(name = "ACCT_NAME", length = 100)
	private String acct_name;

	@Column(name = "ACCT_BALANCE_AC")
	private BigDecimal acct_balance_ac;

	@Column(name = "ACCT_BALANCE_INR")
	private BigDecimal acct_balance_inr;

	@Column(name = "ACCT_BALANCE_LC")
	private BigDecimal acct_balance_lc;

	@Column(name = "ACCR_BALANCE_AC")
	private BigDecimal accr_balance_ac;

	@Column(name = "ACCR_BALANCE_INR")
	private BigDecimal accr_balance_inr;

	@Column(name = "ACCR_BALANCE_LC")
	private BigDecimal accr_balance_lc;

	@Column(name = "SCHM_TYPE", length = 20)
	private String schm_type;

	@Column(name = "SCHM_CODE", length = 20)
	private String schm_code;

	@Column(name = "SCHM_DESC", length = 100)
	private String schm_desc;

	@Column(name = "CATEGORY_2", length = 50)
	private String category_2;

	@Column(name = "CATEGORY", length = 50)
	private String category;

	@Column(name = "CLASSIFICATION", length = 50)
	private String classification;

	@Column(name = "NRE_STATUS", length = 10)
	private String nre_status;

	@Column(name = "CONSTITUTION_CODE", length = 20)
	private String constitution_code;

	@Column(name = "CONSTITUTION_DESC", length = 100)
	private String constitution_desc;

	@Column(name = "SEGMENT", length = 50)
	private String segment;

	@Column(name = "SUB_SEGMENT", length = 50)
	private String sub_segment;

	@Column(name = "SECTOR", length = 50)
	private String sector;

	@Column(name = "SUB_SECTOR", length = 50)
	private String sub_sector;

	@Column(name = "LEGAL_ENTITY_TYPE", length = 50)
	private String legal_entity_type;

	@Column(name = "GROUP_ID", length = 50)
	private String group_id;

	@Column(name = "PURPOSE_OF_ADVN", length = 100)
	private String purpose_of_advn;

	@Column(name = "ACID", length = 50)
	private String acid;

	@Column(name = "GL_SUB_HEAD_DESC", length = 100)
	private String gl_sub_head_desc;

	@Column(name = "SECTOR_CODE", length = 20)
	private String sector_code;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date report_date;

	@Column(name = "CUST_TYPE", length = 50)
	private String cust_type;

	@Column(name = "NETWORTH")
	private BigDecimal networth;

	@Column(name = "TURNOVER")
	private BigDecimal turnover;

	@Column(name = "REPORT_NAME_1", length = 100)
	private String report_name_1;

	@Column(name = "REPORT_LABEL_1", length = 100)
	private String report_label_1;

	@Column(name = "REPORT_ADDL_CRITERIA_1", length = 100)
	private String report_addl_criteria_1;

	@Column(name = "VERSION", length = 20)
	private String version;

	@Column(name = "REMARKS", length = 255)
	private String remarks;

	@Column(name = "EAB_BAL_LC")
	private BigDecimal eab_bal_lc;

	@Column(name = "BACID", length = 50)
	private String bacid;

	@Column(name = "COUNTRY_OF_INCORP", length = 50)
	private String country_of_incorp;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "VERIFY_USER", length = 50)
	private String verify_user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME")
	private Date create_time;

	@Column(name = "CREATE_USER", length = 50)
	private String create_user;

	@Column(name = "DEL_FLG", length = 1)
	private String del_flg;

	@Column(name = "ENTITY_FLG", length = 1)
	private String entity_flg;

	@Column(name = "MODIFY_FLG", length = 1)
	private String modify_flg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_TIME")
	private Date modify_time;

	@Column(name = "MODIFY_USER", length = 50)
	private String modify_user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERIFY_TIME")
	private Date verify_time;

	@Column(name = "REPORT_ADDL_CRITERIA_3", length = 100)
	private String report_addl_criteria_3;

	@Column(name = "REPORT_ADDL_CRITERIA_2", length = 100)
	private String report_addl_criteria_2;

	@Column(name = "NRE_FLG", length = 5)
	private String nre_flg;

	@Temporal(TemporalType.DATE)
	@Column(name = "MATURITY_DATE")
	private Date maturity_date;

	@Column(name = "HNI_NETWORTH")
	private BigDecimal hni_networth;

	@Column(name = "GL_SUB_HEAD_CODE", length = 20)
	private String gl_sub_head_code;

	@Column(name = "GENDER", length = 10)
	private String gender;

	@Column(name = "EAB_LC")
	private BigDecimal eab_lc;

	@Column(name = "ACT_BALANCE_AMT_LC")
	private BigDecimal act_balance_amt_lc;

	public String getForacid() {
		return foracid;
	}

	public void setForacid(String foracid) {
		this.foracid = foracid;
	}

	public String getBr_code() {
		return br_code;
	}

	public void setBr_code(String br_code) {
		this.br_code = br_code;
	}

	public String getSol_id() {
		return sol_id;
	}

	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getGlsh_code() {
		return glsh_code;
	}

	public void setGlsh_code(String glsh_code) {
		this.glsh_code = glsh_code;
	}

	public String getGl_code() {
		return gl_code;
	}

	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}

	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}

	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public BigDecimal getAcct_balance_ac() {
		return acct_balance_ac;
	}

	public void setAcct_balance_ac(BigDecimal acct_balance_ac) {
		this.acct_balance_ac = acct_balance_ac;
	}

	public BigDecimal getAcct_balance_inr() {
		return acct_balance_inr;
	}

	public void setAcct_balance_inr(BigDecimal acct_balance_inr) {
		this.acct_balance_inr = acct_balance_inr;
	}

	public BigDecimal getAcct_balance_lc() {
		return acct_balance_lc;
	}

	public void setAcct_balance_lc(BigDecimal acct_balance_lc) {
		this.acct_balance_lc = acct_balance_lc;
	}

	public BigDecimal getAccr_balance_ac() {
		return accr_balance_ac;
	}

	public void setAccr_balance_ac(BigDecimal accr_balance_ac) {
		this.accr_balance_ac = accr_balance_ac;
	}

	public BigDecimal getAccr_balance_inr() {
		return accr_balance_inr;
	}

	public void setAccr_balance_inr(BigDecimal accr_balance_inr) {
		this.accr_balance_inr = accr_balance_inr;
	}

	public BigDecimal getAccr_balance_lc() {
		return accr_balance_lc;
	}

	public void setAccr_balance_lc(BigDecimal accr_balance_lc) {
		this.accr_balance_lc = accr_balance_lc;
	}

	public String getSchm_type() {
		return schm_type;
	}

	public void setSchm_type(String schm_type) {
		this.schm_type = schm_type;
	}

	public String getSchm_code() {
		return schm_code;
	}

	public void setSchm_code(String schm_code) {
		this.schm_code = schm_code;
	}

	public String getSchm_desc() {
		return schm_desc;
	}

	public void setSchm_desc(String schm_desc) {
		this.schm_desc = schm_desc;
	}

	public String getCategory_2() {
		return category_2;
	}

	public void setCategory_2(String category_2) {
		this.category_2 = category_2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getNre_status() {
		return nre_status;
	}

	public void setNre_status(String nre_status) {
		this.nre_status = nre_status;
	}

	public String getConstitution_code() {
		return constitution_code;
	}

	public void setConstitution_code(String constitution_code) {
		this.constitution_code = constitution_code;
	}

	public String getConstitution_desc() {
		return constitution_desc;
	}

	public void setConstitution_desc(String constitution_desc) {
		this.constitution_desc = constitution_desc;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getSub_segment() {
		return sub_segment;
	}

	public void setSub_segment(String sub_segment) {
		this.sub_segment = sub_segment;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSub_sector() {
		return sub_sector;
	}

	public void setSub_sector(String sub_sector) {
		this.sub_sector = sub_sector;
	}

	public String getLegal_entity_type() {
		return legal_entity_type;
	}

	public void setLegal_entity_type(String legal_entity_type) {
		this.legal_entity_type = legal_entity_type;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getPurpose_of_advn() {
		return purpose_of_advn;
	}

	public void setPurpose_of_advn(String purpose_of_advn) {
		this.purpose_of_advn = purpose_of_advn;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getGl_sub_head_desc() {
		return gl_sub_head_desc;
	}

	public void setGl_sub_head_desc(String gl_sub_head_desc) {
		this.gl_sub_head_desc = gl_sub_head_desc;
	}

	public String getSector_code() {
		return sector_code;
	}

	public void setSector_code(String sector_code) {
		this.sector_code = sector_code;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	public BigDecimal getNetworth() {
		return networth;
	}

	public void setNetworth(BigDecimal networth) {
		this.networth = networth;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public String getReport_name_1() {
		return report_name_1;
	}

	public void setReport_name_1(String report_name_1) {
		this.report_name_1 = report_name_1;
	}

	public String getReport_label_1() {
		return report_label_1;
	}

	public void setReport_label_1(String report_label_1) {
		this.report_label_1 = report_label_1;
	}

	public String getReport_addl_criteria_1() {
		return report_addl_criteria_1;
	}

	public void setReport_addl_criteria_1(String report_addl_criteria_1) {
		this.report_addl_criteria_1 = report_addl_criteria_1;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getEab_bal_lc() {
		return eab_bal_lc;
	}

	public void setEab_bal_lc(BigDecimal eab_bal_lc) {
		this.eab_bal_lc = eab_bal_lc;
	}

	public String getBacid() {
		return bacid;
	}

	public void setBacid(String bacid) {
		this.bacid = bacid;
	}

	public String getCountry_of_incorp() {
		return country_of_incorp;
	}

	public void setCountry_of_incorp(String country_of_incorp) {
		this.country_of_incorp = country_of_incorp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
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

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public String getReport_addl_criteria_3() {
		return report_addl_criteria_3;
	}

	public void setReport_addl_criteria_3(String report_addl_criteria_3) {
		this.report_addl_criteria_3 = report_addl_criteria_3;
	}

	public String getReport_addl_criteria_2() {
		return report_addl_criteria_2;
	}

	public void setReport_addl_criteria_2(String report_addl_criteria_2) {
		this.report_addl_criteria_2 = report_addl_criteria_2;
	}

	public String getNre_flg() {
		return nre_flg;
	}

	public void setNre_flg(String nre_flg) {
		this.nre_flg = nre_flg;
	}

	public Date getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	public BigDecimal getHni_networth() {
		return hni_networth;
	}

	public void setHni_networth(BigDecimal hni_networth) {
		this.hni_networth = hni_networth;
	}

	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}

	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getEab_lc() {
		return eab_lc;
	}

	public void setEab_lc(BigDecimal eab_lc) {
		this.eab_lc = eab_lc;
	}

	public BigDecimal getAct_balance_amt_lc() {
		return act_balance_amt_lc;
	}

	public void setAct_balance_amt_lc(BigDecimal act_balance_amt_lc) {
		this.act_balance_amt_lc = act_balance_amt_lc;
	}

	public CBUAE_BRF1_1_Mapping_Entity(String foracid, String br_code, String sol_id, String cust_id, String glsh_code,
			String gl_code, String acct_crncy_code, String acct_name, BigDecimal acct_balance_ac,
			BigDecimal acct_balance_inr, BigDecimal acct_balance_lc, BigDecimal accr_balance_ac,
			BigDecimal accr_balance_inr, BigDecimal accr_balance_lc, String schm_type, String schm_code,
			String schm_desc, String category_2, String category, String classification, String nre_status,
			String constitution_code, String constitution_desc, String segment, String sub_segment, String sector,
			String sub_sector, String legal_entity_type, String group_id, String purpose_of_advn, String acid,
			String gl_sub_head_desc, String sector_code, Date report_date, String cust_type, BigDecimal networth,
			BigDecimal turnover, String report_name_1, String report_label_1, String report_addl_criteria_1,
			String version, String remarks, BigDecimal eab_bal_lc, String bacid, String country_of_incorp,
			String country, String verify_user, Date create_time, String create_user, String del_flg, String entity_flg,
			String modify_flg, Date modify_time, String modify_user, Date verify_time, String report_addl_criteria_3,
			String report_addl_criteria_2, String nre_flg, Date maturity_date, BigDecimal hni_networth,
			String gl_sub_head_code, String gender, BigDecimal eab_lc, BigDecimal act_balance_amt_lc) {
		super();
		this.foracid = foracid;
		this.br_code = br_code;
		this.sol_id = sol_id;
		this.cust_id = cust_id;
		this.glsh_code = glsh_code;
		this.gl_code = gl_code;
		this.acct_crncy_code = acct_crncy_code;
		this.acct_name = acct_name;
		this.acct_balance_ac = acct_balance_ac;
		this.acct_balance_inr = acct_balance_inr;
		this.acct_balance_lc = acct_balance_lc;
		this.accr_balance_ac = accr_balance_ac;
		this.accr_balance_inr = accr_balance_inr;
		this.accr_balance_lc = accr_balance_lc;
		this.schm_type = schm_type;
		this.schm_code = schm_code;
		this.schm_desc = schm_desc;
		this.category_2 = category_2;
		this.category = category;
		this.classification = classification;
		this.nre_status = nre_status;
		this.constitution_code = constitution_code;
		this.constitution_desc = constitution_desc;
		this.segment = segment;
		this.sub_segment = sub_segment;
		this.sector = sector;
		this.sub_sector = sub_sector;
		this.legal_entity_type = legal_entity_type;
		this.group_id = group_id;
		this.purpose_of_advn = purpose_of_advn;
		this.acid = acid;
		this.gl_sub_head_desc = gl_sub_head_desc;
		this.sector_code = sector_code;
		this.report_date = report_date;
		this.cust_type = cust_type;
		this.networth = networth;
		this.turnover = turnover;
		this.report_name_1 = report_name_1;
		this.report_label_1 = report_label_1;
		this.report_addl_criteria_1 = report_addl_criteria_1;
		this.version = version;
		this.remarks = remarks;
		this.eab_bal_lc = eab_bal_lc;
		this.bacid = bacid;
		this.country_of_incorp = country_of_incorp;
		this.country = country;
		this.verify_user = verify_user;
		this.create_time = create_time;
		this.create_user = create_user;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.verify_time = verify_time;
		this.report_addl_criteria_3 = report_addl_criteria_3;
		this.report_addl_criteria_2 = report_addl_criteria_2;
		this.nre_flg = nre_flg;
		this.maturity_date = maturity_date;
		this.hni_networth = hni_networth;
		this.gl_sub_head_code = gl_sub_head_code;
		this.gender = gender;
		this.eab_lc = eab_lc;
		this.act_balance_amt_lc = act_balance_amt_lc;
	}

	public CBUAE_BRF1_1_Mapping_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
