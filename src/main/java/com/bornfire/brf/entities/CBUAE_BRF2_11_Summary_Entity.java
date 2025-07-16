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
@Table(name = "CBUAE_BRF2_11_SUMMARYTABLE")
public class CBUAE_BRF2_11_Summary_Entity {
	private String country_party;
	private String branch;
	private String head_office;
	private BigDecimal due_from_placements;
	private BigDecimal due_to_borrowing;
	private BigDecimal due_from_remaining;
	private BigDecimal due_to_bremaining;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date report_date;
	private String REPORT_VERSION;
	private String REPORT_CODE;
	private String REPORT_DESC;
	private String ENTITY_FLG;
	private String MODIFY_FLG;
	private String DEL_FLG;
	public String getCountry_party() {
		return country_party;
	}
	public void setCountry_party(String country_party) {
		this.country_party = country_party;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getHead_office() {
		return head_office;
	}
	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}
	public BigDecimal getDue_from_placements() {
		return due_from_placements;
	}
	public void setDue_from_placements(BigDecimal due_from_placements) {
		this.due_from_placements = due_from_placements;
	}
	public BigDecimal getDue_to_borrowing() {
		return due_to_borrowing;
	}
	public void setDue_to_borrowing(BigDecimal due_to_borrowing) {
		this.due_to_borrowing = due_to_borrowing;
	}
	public BigDecimal getDue_from_remaining() {
		return due_from_remaining;
	}
	public void setDue_from_remaining(BigDecimal due_from_remaining) {
		this.due_from_remaining = due_from_remaining;
	}
	public BigDecimal getDue_to_bremaining() {
		return due_to_bremaining;
	}
	public void setDue_to_bremaining(BigDecimal due_to_bremaining) {
		this.due_to_bremaining = due_to_bremaining;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getREPORT_VERSION() {
		return REPORT_VERSION;
	}
	public void setREPORT_VERSION(String rEPORT_VERSION) {
		REPORT_VERSION = rEPORT_VERSION;
	}
	public String getREPORT_CODE() {
		return REPORT_CODE;
	}
	public void setREPORT_CODE(String rEPORT_CODE) {
		REPORT_CODE = rEPORT_CODE;
	}
	public String getREPORT_DESC() {
		return REPORT_DESC;
	}
	public void setREPORT_DESC(String rEPORT_DESC) {
		REPORT_DESC = rEPORT_DESC;
	}
	public String getENTITY_FLG() {
		return ENTITY_FLG;
	}
	public void setENTITY_FLG(String eNTITY_FLG) {
		ENTITY_FLG = eNTITY_FLG;
	}
	public String getMODIFY_FLG() {
		return MODIFY_FLG;
	}
	public void setMODIFY_FLG(String mODIFY_FLG) {
		MODIFY_FLG = mODIFY_FLG;
	}
	public String getDEL_FLG() {
		return DEL_FLG;
	}
	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}
	
	
	public CBUAE_BRF2_11_Summary_Entity(String country_party, String branch, String head_office,
			BigDecimal due_from_placements, BigDecimal due_to_borrowing, BigDecimal due_from_remaining,
			BigDecimal due_to_bremaining, Date report_date, String rEPORT_VERSION, String rEPORT_CODE,
			String rEPORT_DESC, String eNTITY_FLG, String mODIFY_FLG, String dEL_FLG) {
		super();
		this.country_party = country_party;
		this.branch = branch;
		this.head_office = head_office;
		this.due_from_placements = due_from_placements;
		this.due_to_borrowing = due_to_borrowing;
		this.due_from_remaining = due_from_remaining;
		this.due_to_bremaining = due_to_bremaining;
		this.report_date = report_date;
		REPORT_VERSION = rEPORT_VERSION;
		REPORT_CODE = rEPORT_CODE;
		REPORT_DESC = rEPORT_DESC;
		ENTITY_FLG = eNTITY_FLG;
		MODIFY_FLG = mODIFY_FLG;
		DEL_FLG = dEL_FLG;
	}
	public CBUAE_BRF2_11_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
