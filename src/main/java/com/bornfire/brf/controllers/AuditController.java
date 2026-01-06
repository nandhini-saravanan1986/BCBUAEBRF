package com.bornfire.brf.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bornfire.brf.services.AuditService;

@Controller
public class AuditController {
	
	@Autowired
	AuditService auditService;

	@RequestMapping(value = "User_Audit", method = RequestMethod.GET)
	public String userAudit(Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		System.out.println("The login userid is : " + userid);

		LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("The time is " + localDateTime);

		md.addAttribute("menu", "Audit");

		// Add both lists to the model
		md.addAttribute("auditlogs", auditService.getUserServices());
		//md.addAttribute("userAuditLevels", auditService.getUserAuditLevelList());

		return "User_Audit";
	}
	
	@RequestMapping(value = "Service_Audit", method = RequestMethod.GET)
	public String ServiceAudit(Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		System.out.println("The login userid is : " + userid);

		LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("The time is " + localDateTime);

		md.addAttribute("menu", "Audit");

		// Add both lists to the model
		md.addAttribute("AuditList", auditService.getAuditServices());
		//md.addAttribute("userAuditLevels", auditService.getUserAuditLevelList());

		return "Service_Audit";
	}
	@RequestMapping(value = "Service_Audit/DownloadExcel", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadServiceAuditExcel(@RequestParam(value = "audit_date", required = false) String auditDate) {
	    try {
	        ByteArrayInputStream in = auditService.generateServiceAuditExcel(auditDate);
	        
	        // Format filename date to dd-MM-yyyy
	        String dateForFilename = "All";
	        if (auditDate != null && !auditDate.isEmpty()) {
	            try {
	                LocalDate ld = LocalDate.parse(auditDate);
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	                dateForFilename = ld.format(formatter);
	            } catch (Exception e) {
	                dateForFilename = auditDate;
	            }
	        }
	        
	        String filename = "Service_Audit_" + dateForFilename + ".xlsx";

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=" + filename);

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	                .body(new InputStreamResource(in));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).build();
	    }
	}
	
	@RequestMapping(value = "getchanges", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String fetchChanges(@RequestParam(required = false) String audit_ref_no) {

		// Fetch data from the database using the repository
		String changeDetails = auditService.fetchChanges(audit_ref_no); // Example of getting data
		System.out.println(changeDetails);
		// Process the change details to format as required

		return changeDetails; // Return the formatted changes
	}
	

	@RequestMapping(value = "User_Audit/DownloadExcel", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadExcel(@RequestParam(value = "audit_date", required = false) String auditDate) {
	    try {
	        // 1. Generate the Excel file
	        ByteArrayInputStream in = auditService.generateUserAuditExcel(auditDate);
	        
	        // 2. Format the date for the Filename (yyyy-MM-dd -> dd-MM-yyyy)
	        String dateForFilename = "All";
	        
	        if (auditDate != null && !auditDate.isEmpty()) {
	            try {
	                // Parse the input (2025-12-09) and format to (09-12-2025)
	                LocalDate ld = LocalDate.parse(auditDate);
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	                dateForFilename = ld.format(formatter);
	            } catch (Exception e) {
	                // Fallback if parsing fails
	                dateForFilename = auditDate;
	            }
	        }

	        // 3. Construct Filename
	        String filename = "User_Audit_" + dateForFilename + ".xlsx";

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=" + filename);

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	                .body(new InputStreamResource(in));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).build();
	    }
	}

}
