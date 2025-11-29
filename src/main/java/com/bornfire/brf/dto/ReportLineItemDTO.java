package com.bornfire.brf.dto;

public class ReportLineItemDTO {
	// Fields for Row Data
	private int srlNo;
	private String fieldDescription;
	private String reportLabel;
	private String header;
	private String remarks;
    
    // Fields for Column Data
    private String columnId;
    private String columnName;

	// Constructor for Row Data
	public ReportLineItemDTO() {
	}

	// Constructor for Column Data
	public ReportLineItemDTO(String columnId, String columnName) {
		this.columnId = columnId;
		this.columnName = columnName;
	}

	// --- Getters and Setters for ALL fields ---
	public int getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(int srlNo) {
		this.srlNo = srlNo;
	}

	public String getFieldDescription() {
		return fieldDescription;
	}

	public void setFieldDescription(String fieldDescription) {
		this.fieldDescription = fieldDescription;
	}

	public String getReportLabel() {
		return reportLabel;
	}

	public void setReportLabel(String reportLabel) {
		this.reportLabel = reportLabel;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}