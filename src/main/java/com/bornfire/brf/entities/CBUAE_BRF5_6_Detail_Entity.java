package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF5_6_DETAILTABLE")
public class CBUAE_BRF5_6_Detail_Entity {

    @Column(name = "CUST_ID")
    private String custId;

    @Column(name = "ACCT_NUMBER")
    private String acctNumber;

    @Column(name = "ACCT_NAME")
    private String acctName;

    @Column(name = "DATA_TYPE")
    private String dataType;

    @Column(name = "ROW_ID")
    private String rowId;

    @Column(name = "COLUMN_ID")
    private String columnId;

    @Column(name = "REPORT_REMARKS")
    private String reportRemarks;

    @Column(name = "MODIFICATION_REMARKS")
    private String modificationRemarks;

    @Column(name = "DATA_ENTRY_VERSION")
    private String dataEntryVersion;

    @Column(name = "ACCT_BALANCE_IN_AED")
    private BigDecimal acctBalanceInAed;

    @Id
    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "REPORT_NAME")
    private String reportName;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Column(name = "VERIFY_USER")
    private String verifyUser;

    @Column(name = "VERIFY_TIME")
    private Date verifyTime;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "ISSUER_NAME")
    private String issuerName;

    @Column(name = "ISSUER_TICKER")
    private String issuerTicker;

    @Column(name = "LEAD_BANK")
    private String leadBank;

    @Column(name = "RESTRUCTURED_DISTRESSED_YN")
    private String restructuredDistressedYn;

    @Column(name = "RESTRUCTURED_NON_DISTRESSED_YN")
    private String restructuredNonDistressedYn;

    @Column(name = "COUNTRY_OF_RISK")
    private String countryOfRisk;

    @Column(name = "COUNTERPARTY_TYPE")
    private String counterpartyType;

    @Column(name = "AMT_OF_SYNDICATED_LOAN_PROVIDED")
    private BigDecimal amtOfSyndicatedLoanProvided;

    @Column(name = "AMOUNT_DRAWN_DOWN_OUTSTANDING")
    private BigDecimal amountDrawnDownOutstanding;

    @Column(name = "LOANS_CLASSIFIED_UNDER_STAGE_3")
    private BigDecimal loansClassifiedUnderStage3;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getReportRemarks() {
		return reportRemarks;
	}

	public void setReportRemarks(String reportRemarks) {
		this.reportRemarks = reportRemarks;
	}

	public String getModificationRemarks() {
		return modificationRemarks;
	}

	public void setModificationRemarks(String modificationRemarks) {
		this.modificationRemarks = modificationRemarks;
	}

	public String getDataEntryVersion() {
		return dataEntryVersion;
	}

	public void setDataEntryVersion(String dataEntryVersion) {
		this.dataEntryVersion = dataEntryVersion;
	}

	public BigDecimal getAcctBalanceInAed() {
		return acctBalanceInAed;
	}

	public void setAcctBalanceInAed(BigDecimal acctBalanceInAed) {
		this.acctBalanceInAed = acctBalanceInAed;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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

	public String getCountryOfRisk() {
		return countryOfRisk;
	}

	public void setCountryOfRisk(String countryOfRisk) {
		this.countryOfRisk = countryOfRisk;
	}

	public String getCounterpartyType() {
		return counterpartyType;
	}

	public void setCounterpartyType(String counterpartyType) {
		this.counterpartyType = counterpartyType;
	}

	public BigDecimal getAmtOfSyndicatedLoanProvided() {
		return amtOfSyndicatedLoanProvided;
	}

	public void setAmtOfSyndicatedLoanProvided(BigDecimal amtOfSyndicatedLoanProvided) {
		this.amtOfSyndicatedLoanProvided = amtOfSyndicatedLoanProvided;
	}

	public BigDecimal getAmountDrawnDownOutstanding() {
		return amountDrawnDownOutstanding;
	}

	public void setAmountDrawnDownOutstanding(BigDecimal amountDrawnDownOutstanding) {
		this.amountDrawnDownOutstanding = amountDrawnDownOutstanding;
	}

	public BigDecimal getLoansClassifiedUnderStage3() {
		return loansClassifiedUnderStage3;
	}

	public void setLoansClassifiedUnderStage3(BigDecimal loansClassifiedUnderStage3) {
		this.loansClassifiedUnderStage3 = loansClassifiedUnderStage3;
	}

	public CBUAE_BRF5_6_Detail_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

