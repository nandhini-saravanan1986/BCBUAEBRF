package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CBUAE_BRF9_1_DETAILTABLE2")

public class CBUAE_BRF9_1_Detail_Entity2 {

	@Id
    @Column(name = "CUST_ID", length = 100)
    private String custId;

    @Column(name = "ACCT_NUMBER", length = 100)
    private String acctNumber;

    @Column(name = "ACCT_NAME", length = 100)
    private String acctName;

    @Column(name = "DATA_TYPE", length = 100)
    private String dataType;
    
    @Column(name = "ROW_ID", length = 100)
    private String rowId;
    
    @Column(name = "COLUMN_ID", length = 100)
    private String columnId;

    @Column(name = "REPORT_REMARKS", length = 100)
    private String reportRemarks;

    @Column(name = "MODIFICATION_REMARKS", length = 100)
    private String modificationRemarks;

    @Column(name = "DATA_ENTRY_VERSION", length = 100)
    private String dataEntryVersion;

    @Column(name = "ACCT_BALANCE_IN_AED", precision = 24, scale = 3)
    private BigDecimal acctBalanceInAed;
    
    @Column(name = "REPORT_DATE")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date reportDate;

    @Column(name = "REPORT_NAME", length = 100)
    private String reportName;

    @Column(name = "CREATE_USER", length = 50)
    private String createUser;

    @Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createTime;

    @Column(name = "MODIFY_USER", length = 50)
    private String modifyUser;

    @Column(name = "MODIFY_TIME")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date modifyTime;

    @Column(name = "VERIFY_USER", length = 50)
    private String verifyUser;

    @Column(name = "VERIFY_TIME")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date verifyTime;

    @Column(name = "ENTITY_FLG", length = 1)
    private String entityFlg;

    @Column(name = "MODIFY_FLG", length = 1)
    private String modifyFlg;

    @Column(name = "DEL_FLG", length = 1)
    private String delFlg;
    
    @Column(name = "FAMILY_OUTWARD")
    private BigDecimal	family_outward;
    
    @Column(name = "INVESTMENT_OUTWARD")
	private BigDecimal	investment_outward;
    
    @Column(name = "TRADE_OUTWARD")
	private BigDecimal	trade_outward;
    
    @Column(name = "OTHER_OUTWARD")
	private BigDecimal	other_outward;
    
    @Column(name = "FAMILY_INWARD")
	private BigDecimal	family_inward;
    
    @Column(name = "INVESTMENT_INWARD")
	private BigDecimal	investment_inward;
    
    @Column(name = "TRADE_INWARD")
	private BigDecimal	trade_inward;
    
    @Column(name = "OTHER_INWARD")
	private BigDecimal	other_inward;
    
    
    

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

	public BigDecimal getFamily_outward() {
		return family_outward;
	}

	public void setFamily_outward(BigDecimal family_outward) {
		this.family_outward = family_outward;
	}

	public BigDecimal getInvestment_outward() {
		return investment_outward;
	}

	public void setInvestment_outward(BigDecimal investment_outward) {
		this.investment_outward = investment_outward;
	}

	public BigDecimal getTrade_outward() {
		return trade_outward;
	}

	public void setTrade_outward(BigDecimal trade_outward) {
		this.trade_outward = trade_outward;
	}

	public BigDecimal getOther_outward() {
		return other_outward;
	}

	public void setOther_outward(BigDecimal other_outward) {
		this.other_outward = other_outward;
	}

	public BigDecimal getFamily_inward() {
		return family_inward;
	}

	public void setFamily_inward(BigDecimal family_inward) {
		this.family_inward = family_inward;
	}

	public BigDecimal getInvestment_inward() {
		return investment_inward;
	}

	public void setInvestment_inward(BigDecimal investment_inward) {
		this.investment_inward = investment_inward;
	}

	public BigDecimal getTrade_inward() {
		return trade_inward;
	}

	public void setTrade_inward(BigDecimal trade_inward) {
		this.trade_inward = trade_inward;
	}

	public BigDecimal getOther_inward() {
		return other_inward;
	}

	public void setOther_inward(BigDecimal other_inward) {
		this.other_inward = other_inward;
	}

	
	
	public CBUAE_BRF9_1_Detail_Entity2() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    

}
