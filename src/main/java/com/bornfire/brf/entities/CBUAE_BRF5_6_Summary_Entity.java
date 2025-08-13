package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF5_6_SUMMARYTABLE") // Replace with actual table name if different
public class CBUAE_BRF5_6_Summary_Entity {

    @Column(name = "AMOUNT_DRAWN_DOWN_OUTSTANDING")
    private BigDecimal amountDrawnDownOutstanding;

    @Column(name = "AMT_OF_SYNDICATED_LOAN_PROVIDED")
    private BigDecimal amtOfSyndicatedLoanProvided;

    @Column(name = "COUNTERPARTY_TYPE")
    private String counterpartyType;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "ISSUER_NAME")
    private String issuerName;

    @Column(name = "ISSUER_TICKER")
    private String issuerTicker;

    @Column(name = "LEAD_BANK")
    private String leadBank;

    @Column(name = "LOANS_CLASSIFIED_UNDER_STAGE_3")
    private BigDecimal loansClassifiedUnderStage3;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "REPORT_CODE")
    private String reportCode;

    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "REPORT_DESC")
    private String reportDesc;

    @Column(name = "REPORT_FREQUENCY")
    private String reportFrequency;

    @Column(name = "REPORT_VERSION")
    private String reportVersion;

    @Column(name = "RESTRUCTURED_DISTRESSED_YN")
    private String restructuredDistressedYn;

    @Column(name = "RESTRUCTURED_NON_DISTRESSED_YN")
    private String restructuredNonDistressedYn;

    @Id
    @Column(name = "SRL_NO")
    private String srl_no;
    
    
	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public BigDecimal getAmountDrawnDownOutstanding() {
		return amountDrawnDownOutstanding;
	}

	public void setAmountDrawnDownOutstanding(BigDecimal amountDrawnDownOutstanding) {
		this.amountDrawnDownOutstanding = amountDrawnDownOutstanding;
	}

	public BigDecimal getAmtOfSyndicatedLoanProvided() {
		return amtOfSyndicatedLoanProvided;
	}

	public void setAmtOfSyndicatedLoanProvided(BigDecimal amtOfSyndicatedLoanProvided) {
		this.amtOfSyndicatedLoanProvided = amtOfSyndicatedLoanProvided;
	}

	public String getCounterpartyType() {
		return counterpartyType;
	}

	public void setCounterpartyType(String counterpartyType) {
		this.counterpartyType = counterpartyType;
	}

	public String getCountryOfRisk() {
		return countryOfRisk;
	}

	public void setCountryOfRisk(String countryOfRisk) {
		this.countryOfRisk = countryOfRisk;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getIssuerTicker() {
		return issuerTicker;
	}

	public void setIssuerTicker(String issuerTicker) {
		this.issuerTicker = issuerTicker;
	}

	public String getLeadBank() {
		return leadBank;
	}

	public void setLeadBank(String leadBank) {
		this.leadBank = leadBank;
	}

	public BigDecimal getLoansClassifiedUnderStage3() {
		return loansClassifiedUnderStage3;
	}

	public void setLoansClassifiedUnderStage3(BigDecimal loansClassifiedUnderStage3) {
		this.loansClassifiedUnderStage3 = loansClassifiedUnderStage3;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportDesc() {
		return reportDesc;
	}

	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}

	public String getReportFrequency() {
		return reportFrequency;
	}

	public void setReportFrequency(String reportFrequency) {
		this.reportFrequency = reportFrequency;
	}

	public String getReportVersion() {
		return reportVersion;
	}

	public void setReportVersion(String reportVersion) {
		this.reportVersion = reportVersion;
	}

	public String getRestructuredDistressedYn() {
		return restructuredDistressedYn;
	}

	public void setRestructuredDistressedYn(String restructuredDistressedYn) {
		this.restructuredDistressedYn = restructuredDistressedYn;
	}

	public String getRestructuredNonDistressedYn() {
		return restructuredNonDistressedYn;
	}

	public void setRestructuredNonDistressedYn(String restructuredNonDistressedYn) {
		this.restructuredNonDistressedYn = restructuredNonDistressedYn;
	}

	public CBUAE_BRF5_6_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

