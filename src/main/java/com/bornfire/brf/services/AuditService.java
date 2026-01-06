package com.bornfire.brf.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bornfire.brf.entities.AuditServicesEntity;
import com.bornfire.brf.entities.AuditServicesRep;

@Service
public class AuditService {

	@Autowired
	private AuditServicesRep auditServicesRep;

	public List<AuditServicesEntity> getUserServices() {
		System.out.println(auditServicesRep.getUserAudit());
		return auditServicesRep.getUserAudit();
	}

	public List<AuditServicesEntity> getAuditServices() {
		System.out.println(auditServicesRep.getServiceAudit());
		return auditServicesRep.getServiceAudit();	
	}

	public void createBusinessAudit(final String customerId, final String functionCode, final String screenName,
			final Map<String, String> changeDetails, final String tableName) {
		try {
			final UUID auditID = UUID.randomUUID();
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			String userId = null;
			String username = null;
			if (attr != null) {
				HttpServletRequest request = attr.getRequest();
				userId = (String) request.getSession().getAttribute("USERID");
				username = (String) request.getSession().getAttribute("USERNAME");
			}
			final Date currentDate = new Date();

			AuditServicesEntity audit = new AuditServicesEntity();
			audit.setAudit_ref_no(auditID.toString());
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(userId);
			audit.setEntry_user_name(username);
			audit.setFunc_code(functionCode);
			audit.setAudit_table(tableName);
			audit.setAudit_screen(screenName);
			audit.setEvent_id(userId);
			audit.setEvent_name(username);

			if (changeDetails != null && !changeDetails.isEmpty()) {
				StringBuilder changes = new StringBuilder();
				changeDetails
						.forEach((field, value) -> changes.append(field).append(": ").append(value).append("||| "));
			
	            audit.setChange_details(changes.toString()); 
			}

			if ("VERIFY".equalsIgnoreCase(functionCode)) {
				audit.setAuth_user(userId);
				audit.setAuth_user_name(username);
				audit.setAuth_time(currentDate);
			}

			audit.setReport_id(customerId);

			System.out.println(audit);
			auditServicesRep.save(audit);

		} catch (Exception e) {
			System.err.println("Error creating business audit: " + e.getMessage());
			e.printStackTrace();
		}
	}
	

	public String fetchChanges(@RequestParam(required = false) String audit_ref_no) {

	return auditServicesRep.getchanges(audit_ref_no); 
	}
	// Inside AuditService.java

	public ByteArrayInputStream generateUserAuditExcel(String dateFilter) throws IOException {
	    List<AuditServicesEntity> allAudits = getUserServices(); // Assuming this fetches everything
	    List<AuditServicesEntity> filteredList;

	    // Filter by Date in Java (if your DB query doesn't do it)
	    if (dateFilter != null && !dateFilter.isEmpty()) {
	        filteredList = new ArrayList<>();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        
	        for (AuditServicesEntity audit : allAudits) {
	            if (audit.getEntry_time() != null) {
	                // Convert audit Date to String yyyy-MM-dd to compare
	                String auditDateStr = sdf.format(audit.getEntry_time());
	                if (auditDateStr.equals(dateFilter)) {
	                    filteredList.add(audit);
	                }
	            }
	        }
	    } else {
	        filteredList = allAudits;
	    }

	    String[] columns = {"Audit Ref No", "Table Name", "Function", "Entry User", 
	                        "Entry Date", "Entry Time", "Authorizer", "Modified Data"};

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
	        Sheet sheet = workbook.createSheet("Audit Log");

	        // ... (Styles creation code same as before) ...
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setColor(IndexedColors.WHITE.getIndex());
	        CellStyle headerStyle = workbook.createCellStyle();
	        headerStyle.setFont(headerFont);
	        headerStyle.setFillForegroundColor(IndexedColors.TEAL.getIndex());
	        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        CellStyle dateStyle = workbook.createCellStyle();
	        dateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("dd-MM-yyyy"));

	        // Header
	        Row headerRow = sheet.createRow(0);
	        for (int col = 0; col < columns.length; col++) {
	            Cell cell = headerRow.createCell(col);
	            cell.setCellValue(columns[col]);
	            cell.setCellStyle(headerStyle);
	        }

	        // Data
	        int rowIdx = 1;
	        for (AuditServicesEntity audit : filteredList) {
	            Row row = sheet.createRow(rowIdx++);
	            
	            row.createCell(0).setCellValue(audit.getAudit_ref_no());
	            row.createCell(1).setCellValue(audit.getAudit_table());
	            row.createCell(2).setCellValue(audit.getFunc_code());
	            row.createCell(3).setCellValue(audit.getEntry_user());
	            
	            Cell dateCell = row.createCell(4);
	            if(audit.getEntry_time() != null) {
	                dateCell.setCellValue(audit.getEntry_time());
	                dateCell.setCellStyle(dateStyle);
	            }
	            
	            // Time only (using string format for simplicity in display)
	            row.createCell(5).setCellValue(audit.getEntry_time() != null ? 
	                 new SimpleDateFormat("HH:mm:ss").format(audit.getEntry_time()) : "");
	                 
	            row.createCell(6).setCellValue(audit.getAuth_user());
	            row.createCell(7).setCellValue(audit.getChange_details());
	        }

	        for (int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        workbook.write(out);
	        return new ByteArrayInputStream(out.toByteArray());
	    }
	}
	public ByteArrayInputStream generateServiceAuditExcel(String dateFilter) throws IOException {
        // 1. Fetch Data
        List<AuditServicesEntity> allAudits = getAuditServices();
        List<AuditServicesEntity> filteredList;

        // 2. Filter by Date (if provided)
        if (dateFilter != null && !dateFilter.isEmpty()) {
            filteredList = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            for (AuditServicesEntity audit : allAudits) {
                if (audit.getEntry_time() != null) {
                    String auditDateStr = sdf.format(audit.getEntry_time());
                    if (auditDateStr.equals(dateFilter)) {
                        filteredList.add(audit);
                    }
                }
            }
        } else {
            filteredList = allAudits;
        }

        String[] columns = {"Cust ID", "Table Name", "Function", "Entry User", 
                            "Entry Time", "Authorizer", "Auth Time", "Modified Data"};

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Service Audit");

            // Styles
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.TEAL.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("dd-MM-yyyy HH:mm:ss"));
            
            CellStyle wrapStyle = workbook.createCellStyle();
            wrapStyle.setWrapText(true);

            // Header Row
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < columns.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(headerStyle);
            }

            // Data Rows
            int rowIdx = 1;
            for (AuditServicesEntity audit : filteredList) {
                Row row = sheet.createRow(rowIdx++);
                
                createCell(row, 0, audit.getReport_id());
                createCell(row, 1, audit.getAudit_table());
                createCell(row, 2, audit.getFunc_code());
                
                // Entry User formatting
                String entryUser = (audit.getEntry_user() != null ? audit.getEntry_user() : "") + 
                                   (audit.getEntry_user_name() != null ? " / " + audit.getEntry_user_name() : "");
                createCell(row, 3, entryUser);

                // Entry Time
                Cell entryTimeCell = row.createCell(4);
                if (audit.getEntry_time() != null) {
                    entryTimeCell.setCellValue(audit.getEntry_time());
                    entryTimeCell.setCellStyle(dateStyle);
                }

                // Auth User formatting
                String authUser = (audit.getAuth_user() != null ? audit.getAuth_user() : "") + 
                                  (audit.getAuth_user_name() != null ? " / " + audit.getAuth_user_name() : "");
                createCell(row, 5, authUser);

                // Auth Time
                Cell authTimeCell = row.createCell(6);
                if (audit.getAuth_time() != null) {
                    authTimeCell.setCellValue(audit.getAuth_time());
                    authTimeCell.setCellStyle(dateStyle);
                }

                createCell(row, 7, audit.getChange_details(), wrapStyle);
            }

            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                if(i != 7) sheet.autoSizeColumn(i); // Don't autosize huge change details
            }
            sheet.setColumnWidth(7, 15000); // Set fixed width for details

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
    
    private void createCell(Row row, int col, String val) {
        createCell(row, col, val, null);
    }

    private void createCell(Row row, int col, String val, CellStyle style) {
        Cell cell = row.createCell(col);
        cell.setCellValue(val != null ? val : "");
        if (style != null) cell.setCellStyle(style);
    }

}
