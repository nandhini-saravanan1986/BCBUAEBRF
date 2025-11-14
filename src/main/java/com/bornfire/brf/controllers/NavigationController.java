package com.bornfire.brf.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bornfire.brf.dto.ReportLineItemDTO;
import com.bornfire.brf.entities.AccessAndRoles;
import com.bornfire.brf.entities.AccessandRolesRepository;
import com.bornfire.brf.entities.BaseMappingParameter;
import com.bornfire.brf.entities.BaseMappingParameterRepository;
import com.bornfire.brf.entities.CBUAE_BRFValidationsRepo;
import com.bornfire.brf.entities.RRReport;
import com.bornfire.brf.entities.RRReportRepo;
import com.bornfire.brf.entities.UserProfile;
import com.bornfire.brf.entities.UserProfileRep;
import com.bornfire.brf.services.AccessAndRolesServices;
import com.bornfire.brf.services.BaseMappingParameterServices;
import com.bornfire.brf.services.LoginServices;
import com.bornfire.brf.services.RegulatoryReportServices;
import com.bornfire.brf.services.ReportCodeMappingService;

@Controller
@ConfigurationProperties("default")
public class NavigationController {

	private static final Logger logger = LoggerFactory.getLogger(NavigationController.class);
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */

	UserProfileRep UserProfileReps;

	@Autowired
	RegulatoryReportServices regulatoryreportservices;

	@Autowired
	CBUAE_BRFValidationsRepo cbuae_brfvalidationsRepo;
	@Autowired
	RRReportRepo rrReportlist;

	@Autowired
	LoginServices loginServices;
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	AccessAndRolesServices AccessRoleService;

	@Autowired
	AccessandRolesRepository accessandrolesrepository;

	@Autowired
	BaseMappingParameterRepository basemappingparameterrepository;

	@Autowired
	BaseMappingParameterServices basemappingparameterservice;

	@Autowired
	private ReportCodeMappingService reportCodeMappingService;

	private String pagesize;

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	@RequestMapping(value = "Dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(Model md, HttpServletRequest req) {

		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");

		md.addAttribute("changepassword", loginServices.checkPasswordChangeReq(userid));
		md.addAttribute("checkpassExpiry", loginServices.checkpassexpirty(userid));
		md.addAttribute("checkAcctExpiry", loginServices.checkAcctexpirty(userid));
		int completed = 0;
		int uncompleted = 0;

		md.addAttribute("completed", completed);
		md.addAttribute("uncompleted", uncompleted);
		md.addAttribute("menu", "Dashboard");
		return "Dashboard";
	}

	@RequestMapping(value = "AccessandRoles", method = { RequestMethod.GET, RequestMethod.POST })
	public String IPSAccessandRoles(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid, @RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		// System.out.println("role id is : " + roleId);
		md.addAttribute("IPSRoleMenu", AccessRoleService.getRoleMenu(roleId));

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("menu", "ACCESS AND ROLES");
			md.addAttribute("menuname", "ACCESS AND ROLES");
			md.addAttribute("formmode", "list");
			md.addAttribute("AccessandRoles", accessandrolesrepository.rulelist());
		} else if (formmode.equals("add")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - ADD");
			md.addAttribute("formmode", "add");
		} else if (formmode.equals("edit")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - EDIT");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));
		} else if (formmode.equals("view")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - INQUIRY");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));

		} else if (formmode.equals("verify")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - VERIFY");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));

		} else if (formmode.equals("delete")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - DELETE");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));
		}

		md.addAttribute("adminflag", "adminflag");
		md.addAttribute("userprofileflag", "userprofileflag");

		return "AccessandRoles";
	}

	@RequestMapping(value = "BasemappingParameter", method = { RequestMethod.GET, RequestMethod.POST })
	public String BasemappingParameter(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String account_id_bacid, // Added account_id_bacid for direct access
			Model md, HttpServletRequest req) {

		String loggedInUserAccountIDBacid = (String) req.getSession().getAttribute("ACCOUNT_ID_BACID");
		String userid = (String) req.getSession().getAttribute("USERID"); // Assuming USERID is also in session

		if (formmode == null || formmode.isEmpty() || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("menu", "BASE MAPPING PARAMETER"); // Changed "menuname" to "menu" to match HTML
			md.addAttribute("Basemappingparameter", basemappingparameterrepository.findAllBaseMappingParameters()); // Use
																													// findAll
		} else if (formmode.equals("add")) {
			md.addAttribute("menu", "BASE MAPPING PARAMETER - ADD");
			md.addAttribute("formmode", "add");
			md.addAttribute("basemappingparameter", new BaseMappingParameter()); // Provide empty object for form
																					// binding
		} else if (formmode.equals("edit")) {
			md.addAttribute("formmode", "edit");
			md.addAttribute("menu", "BASE MAPPING PARAMETER - EDIT");
			if (account_id_bacid != null && !account_id_bacid.isEmpty()) {
				Optional<BaseMappingParameter> record = basemappingparameterrepository.findById(account_id_bacid);
				if (record.isPresent()) {
					md.addAttribute("basemappingparameter", record.get());
				} else {
					md.addAttribute("basemappingparameter", new BaseMappingParameter());
					md.addAttribute("alertmsg", "Record not found for ID: " + account_id_bacid); // Add alert
					// You might want to redirect to list or show error on page
				}
			} else {
				md.addAttribute("alertmsg", "Account ID/Bacid is required for editing.");
				md.addAttribute("basemappingparameter", new BaseMappingParameter());
			}
		} else if (formmode.equals("view")) {
			md.addAttribute("formmode", "view");
			md.addAttribute("menu", "BASE MAPPING PARAMETER - VIEW");
			if (account_id_bacid != null && !account_id_bacid.isEmpty()) {
				Optional<BaseMappingParameter> record = basemappingparameterrepository.findById(account_id_bacid);
				if (record.isPresent()) {
					md.addAttribute("basemappingparameter", record.get());
				} else {
					md.addAttribute("basemappingparameter", new BaseMappingParameter());
					md.addAttribute("alertmsg", "Record not found for ID: " + account_id_bacid);
				}
			} else {
				md.addAttribute("alertmsg", "Account ID/Bacid is required for viewing.");
				md.addAttribute("basemappingparameter", new BaseMappingParameter());
			}
		} else if (formmode.equals("delete")) {
			md.addAttribute("formmode", "delete");
			md.addAttribute("menu", "BASE MAPPING PARAMETER - DELETE");
			if (account_id_bacid != null && !account_id_bacid.isEmpty()) {
				Optional<BaseMappingParameter> record = basemappingparameterrepository.findById(account_id_bacid);
				if (record.isPresent()) {
					md.addAttribute("basemappingparameter", record.get());
				} else {
					md.addAttribute("basemappingparameter", new BaseMappingParameter());
					md.addAttribute("alertmsg", "Record not found for ID: " + account_id_bacid);
				}
			} else {
				md.addAttribute("alertmsg", "Account ID/Bacid is required for deletion.");
				md.addAttribute("basemappingparameter", new BaseMappingParameter());
			}
		}
		return "BaseMappingParameter"; // your Thymeleaf page
	}

	// Handles the POST request for adding a new BaseMappingParameter
	@PostMapping("/createBaseMappingParameter")
	@ResponseBody
	public String createBaseMappingParameter(@ModelAttribute BaseMappingParameter basemappingparameter) {
		System.out.println("Received for creation: " + basemappingparameter.getAccount_id_bacid());
		return basemappingparameterservice.createOrUpdate(basemappingparameter, "add");
	}

	// Handles the POST request for updating an existing BaseMappingParameter
	@PostMapping("/updateBasemappingParameter")
	@ResponseBody
	public String updateBasemappingParameter(@ModelAttribute BaseMappingParameter basemappingparameter) {
		System.out.println("Received for update: " + basemappingparameter.getAccount_id_bacid());
		boolean updated = basemappingparameterservice.updatebasemappingparameter(basemappingparameter);

		if (updated) {
			return "Updated successfully.";
		} else {
			return "Record not found for update.";
		}
	}

	// Handles the POST request for deleting a BaseMappingParameter
	@PostMapping("/deletebasemappingparameter") // Changed from GET to POST for delete operation best practice
	@ResponseBody
	public String deletebasemappingparameter(@RequestParam("formmode") String accountIdBacid) { // Renamed param for
																								// clarity
		System.out.println("Came to deletebasemappingparameter controller for ID: " + accountIdBacid);
		String msg = basemappingparameterservice.deleteBaseMappingParameter(accountIdBacid);
		return msg;
	}

	@RequestMapping(value = "createAccessRole", method = RequestMethod.POST)
	@ResponseBody
	public String createAccessRoleEn(@RequestParam("formmode") String formmode,
			@RequestParam(value = "adminValue", required = false) String adminValue,
			@RequestParam(value = "BRF_ReportsValue", required = false) String BRF_ReportsValue,
			@RequestParam(value = "Archival", required = false) String Archival,
			@RequestParam(value = "auditUsValue", required = false) String auditUsValue,
			@RequestParam(value = "finalString", required = false) String finalString,
			@ModelAttribute AccessAndRoles alertparam, Model md, HttpServletRequest rq) {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		md.addAttribute("IPSRoleMenu", AccessRoleService.getRoleMenu(roleId));

		String msg = AccessRoleService.addPARAMETER(alertparam, formmode, adminValue, BRF_ReportsValue, Archival,
				auditUsValue, finalString, userid);

		return msg;
	}

	@GetMapping("/checkRoleExists")
	@ResponseBody
	public String checkRoleExists(@RequestParam("roleId") String roleId) {
		boolean exists = accessandrolesrepository.findById(roleId).isPresent();
		return exists ? "exists" : "not_exists";
	}

	@RequestMapping(value = "UserProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public String userprofile(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		int currentPage = page.orElse(0);
		int pageSize = size.orElse(Integer.parseInt(pagesize));

		String loginuserid = (String) req.getSession().getAttribute("USERID");
		String WORKCLASSAC = (String) req.getSession().getAttribute("WORKCLASS");
		String ROLEIDAC = (String) req.getSession().getAttribute("ROLEID");
		md.addAttribute("RuleIDType", accessandrolesrepository.roleidtype());

		System.out.println("work class is : " + WORKCLASSAC);
		// Logging Navigation
		loginServices.SessionLogging("USERPROFILE", "M2", req.getSession().getId(), loginuserid, req.getRemoteAddr(),
				"ACTIVE");
		Session hs1 = sessionFactory.getCurrentSession();
		md.addAttribute("menu", "USER PROFILE"); // To highlight the menu

		if (formmode == null || formmode.equals("list")) {

			md.addAttribute("formmode", "list");// to set which form - valid values are "edit" , "add" & "list"
			md.addAttribute("WORKCLASSAC", WORKCLASSAC);
			md.addAttribute("ROLEIDAC", ROLEIDAC);
			md.addAttribute("loginuserid", loginuserid);

			Iterable<UserProfile> user = loginServices.getUsersList();

			md.addAttribute("userProfiles", user);

		} else if (formmode.equals("edit")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("userProfile", loginServices.getUser(userid));

		} else if (formmode.equals("view")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("userProfile", loginServices.getUser(userid));

		} else if (formmode.equals("delete")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("userProfile", loginServices.getUser(userid));

		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", formmode);
			md.addAttribute("userProfile", loginServices.getUser(""));
		} else if (formmode.equals("verify")) {
			md.addAttribute("WORKCLASSAC", WORKCLASSAC);
			md.addAttribute("ROLEIDAC", ROLEIDAC);
			md.addAttribute("formmode", formmode);
			md.addAttribute("userProfile", loginServices.getUser(userid));

		} else {

			md.addAttribute("formmode", formmode);
			md.addAttribute("FinUserProfiles", loginServices.getFinUsersList());
			md.addAttribute("userProfile", loginServices.getUser(""));

		}

		return "Userprofile";
	}

	@GetMapping("/getRoleDetails")
	@ResponseBody
	public AccessAndRoles getRoleDetails(@RequestParam String roleId) {
		System.out.println("role id for fetching is : " + roleId);
		return accessandrolesrepository.findById(roleId).orElse(null);
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestParam("formmode") String formmode, @ModelAttribute UserProfile userprofile,
			Model md, HttpServletRequest rq) {

		String mob = (String) rq.getSession().getAttribute("MOBILENUMBER");
		String role = (String) rq.getSession().getAttribute("ROLEDESC");
		String userId = (String) rq.getSession().getAttribute("USERID");
		String userName = (String) rq.getSession().getAttribute("USERNAME");
		String msg = loginServices.addUser(userprofile, formmode, userId, userName, mob, role);

		return msg;
	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteuser(@RequestParam("formmode") String userid, Model md, HttpServletRequest rq) {
		System.out.println("came to Delete user nav controller");
		String msg = loginServices.deleteuser(userid);

		return msg;

	}

	@RequestMapping(value = "verifyUser", method = RequestMethod.POST)
	@ResponseBody
	public String verifyUser(@ModelAttribute UserProfile userprofile, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.verifyUser(userprofile, userid);

		return msg;

	}

	@GetMapping("/checkDomainFlag")
	@ResponseBody
	public ResponseEntity<String> checkDomainFlag(@RequestParam String rptcode) {
		Optional<RRReport> report = rrReportlist.getParticularReport3(rptcode);

		if (report.isPresent()) {
			String domain = report.get().getDomain(); // Add getter in entity if not already
			if ("Y".equalsIgnoreCase(domain)) {
				return ResponseEntity.ok("ENABLED");
			} else {
				return ResponseEntity.ok("DISABLED");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
		}
	}

	@RequestMapping(value = "/ReportCodeMapping", method = { RequestMethod.GET, RequestMethod.POST })
	public String ReportCodeMapping(Model md, HttpServletRequest req) {
		md.addAttribute("menu", "Report Code Mapping");
		md.addAttribute("menuname", "ReportCodeMapping");
		md.addAttribute("formmode", "list");

		// Populate the ReportCode dropdown
		List<String> rptCodes = reportCodeMappingService.getAllReportCodes();
		md.addAttribute("RptCodes", rptCodes);
		md.addAttribute("item", new BaseMappingParameter()); // For the mapping form

		System.out.println("Enter in ReportCodeMapping controller - displaying list view");
		return "ReportCodeMapping";
	}

	@GetMapping("/getReportDataByCode")
	@ResponseBody
	public List<ReportLineItemDTO> getReportDataByCode(@RequestParam("reportCode") String reportCode) {
		System.out.println("Controller received request for report code: " + reportCode);
		System.out.println("reportCodeMappingService object: " + reportCodeMappingService);

		try {
			List<ReportLineItemDTO> data = reportCodeMappingService.getReportDataByCode(reportCode);
			System.out.println("Service call succeeded, records fetched: " + data.size());
			return data;
		} catch (Exception e) {
			System.err.println("Error fetching report data for " + reportCode + ": " + e.getMessage());
			return Collections.emptyList();
		} finally {
			System.out.println("Controller finished processing request for report code: " + reportCode);
		}
	}

	@GetMapping("/getRptName")
	@ResponseBody
	public String getRptName(@RequestParam("rptCode") String rptCode) {
		System.out.println("Controller received request for report name for code: " + rptCode);
		return reportCodeMappingService.getReportNameByCode(rptCode);
	}

	@PostMapping("/saveMapping")
	@ResponseBody
	public String saveMapping(@RequestBody BaseMappingParameter mapping) {
		System.out.println("Controller received mapping data for saving: " + mapping.getReport_code() + " - "
				+ mapping.getAccount_id_bacid());
		try {
			reportCodeMappingService.saveMapping(mapping);
			return "Mapping saved successfully!";
		} catch (Exception e) {
			System.err.println("Error saving mapping: " + e.getMessage());
			return "Error saving mapping: " + e.getMessage();
		}
	}

	@RequestMapping(value = "Monthly-1", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthly1(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 1 - BRF Report");
		System.out.println("count" + rrReportlist.getReportListmonthly1().size());
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly1());

		return "BRF/RRReports";

	}

	@RequestMapping(value = "Monthly-2", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthly2(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 2 - BRF Report");
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly2());

		return "BRF/RRReports";

	}

	@RequestMapping(value = "Monthly-3", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthly3(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 3 - BRF Report");
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly3());

		return "BRF/RRReports";

	}

	@RequestMapping(value = "HalfYearly-1", method = { RequestMethod.GET, RequestMethod.POST })
	public String HalfYearly1(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Half Yealry 1 - BRF Report");
		md.addAttribute("reportlist", rrReportlist.getReportHalfYearly1());

		return "BRF/RRReports";

	}

	@RequestMapping(value = "Yearly-1", method = { RequestMethod.GET, RequestMethod.POST })
	public String Yearly1(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Yealry 1 - BRF Report");
		md.addAttribute("reportlist", rrReportlist.getReportYearly1());

		return "BRF/RRReports";

	}

	@RequestMapping(value = "Fortnightly-Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String FortnightlyArchival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Fortnightly-Archival");
		System.out.println("count" + rrReportlist.getReportListFORTNIGHTLY().size());
		md.addAttribute("reportlist", rrReportlist.getReportListFORTNIGHTLY());
		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "Monthly-1Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthly1Archival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 1 - BRF ARCHIVAL");
		System.out.println("count" + rrReportlist.getReportListmonthly1().size());
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly1());

		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "Monthly-2Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthly2Archival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 2 - BRF ARCHIVAL");
		System.out.println("count" + rrReportlist.getReportListmonthly2().size());
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly2());

		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "Monthly-3Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthly3Archival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 3 - BRF ARCHIVAL");
		System.out.println("count" + rrReportlist.getReportListmonthly3().size());
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly3());

		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "Quarterly-2Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String Quarterly2Archival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Quarterly 2 - BRF ARCHIVAL");
		System.out.println("count" + rrReportlist.getReportListQuarterly2().size());
		md.addAttribute("reportlist", rrReportlist.getReportListQuarterly2());

		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "HalfYearly-1Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String HalfYearly1Archival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Monthly 3 - BRF ARCHIVAL");
		md.addAttribute("reportlist", rrReportlist.getReportHalfYearly1());

		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "Yearly-1Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String Yearly1Archival(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Yearly1 - BRF ARCHIVAL");
		System.out.println("count" + rrReportlist.getReportYearly1().size());
		md.addAttribute("reportlist", rrReportlist.getReportYearly1());

		return "BRF/BRFArchival";

	}

	@RequestMapping(value = "Archival", method = { RequestMethod.GET, RequestMethod.POST })
	public String Archival(Model md, @RequestParam(value = "rptcode", required = false) String rptcode,
			HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		RRReport data = rrReportlist.getReportbyrptcode(rptcode);
		md.addAttribute("reportlist", data);
		md.addAttribute("menu", data.getRptDescription());
		md.addAttribute("domain", data.getDomainId());
		md.addAttribute("rptcode", data.getRptCode());
		List<Object> Archivaldata = regulatoryreportservices.getArchival(rptcode);
		md.addAttribute("Archivaldata", Archivaldata);
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly1());
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly2());
		md.addAttribute("reportlist", rrReportlist.getReportListmonthly3());
		md.addAttribute("reportlist", rrReportlist.getReportListQuarterly2());
		md.addAttribute("reportlist", rrReportlist.getReportYearly1());

		return "BRF/BRFArchivalform";

	}

	@RequestMapping(value = "fort", method = { RequestMethod.GET, RequestMethod.POST })
	public String fort(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Fortnightly - BRF Report");
		System.out.println("count" + rrReportlist.getReportListFORTNIGHTLY().size());
		md.addAttribute("reportlist", rrReportlist.getReportListFORTNIGHTLY());

		return "BRF/RRReports";

	}

	@RequestMapping(value = "BRFValidations", method = { RequestMethod.GET, RequestMethod.POST })
	public String BRFValidations(Model md, @RequestParam(value = "rptcode", required = false) String rptcode,
			@RequestParam(value = "todate", required = false) String todate, HttpServletRequest req) {
		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// md.addAttribute("reportvalue", "RBS Reports");
		// md.addAttribute("reportid", "RBSReports");

		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		// md.addAttribute("reportsflag", "reportsflag");
		// md.addAttribute("menu", "RBS Data Maintenance");

		md.addAttribute("reportlist", cbuae_brfvalidationsRepo.getValidationList(rptcode));
		md.addAttribute("reportlist1", rrReportlist.getReportbyrptcode(rptcode));
		md.addAttribute("RoleId", roleId);

		// md.addAttribute("rpt_date", todate);
		return "BRF/BRFValidations";
	}

	@RequestMapping(value = "Quarterly-2", method = { RequestMethod.GET, RequestMethod.POST })
	public String Quarterly2(Model md, HttpServletRequest req) {
		// String roleId = (String) req.getSession().getAttribute("ROLEID");
		// String domainid = (String) req.getSession().getAttribute("DOMAINID");
		md.addAttribute("menu", "Quarterly 2 - BRF Report");
		System.out.println("count" + rrReportlist.getReportListQuarterly2().size());
		md.addAttribute("reportlist", rrReportlist.getReportListQuarterly2());

		return "BRF/RRReports";

	}
	 @GetMapping("/mapped_accounts/{reportId}")
	    @ResponseBody
	    public ResponseEntity<List<Map<String, Object>>> getMappedAccounts(@PathVariable String reportId) {
	        List<Map<String, Object>> data = regulatoryreportservices.getMappedAccounts(reportId);
	        return ResponseEntity.ok(data);
	    }

	    @GetMapping("/unmapped_accounts/{reportId}")
	    @ResponseBody
	    public ResponseEntity<List<Map<String, Object>>> getUnmappedAccounts(@PathVariable String reportId) {
	        List<Map<String, Object>> data = regulatoryreportservices.getUnmappedAccounts(reportId);
	        return ResponseEntity.ok(data);
	    }

	    // Pass reportId to find the correct service to handle the request
	    @GetMapping("/account/{reportId}/{foracid}")
	    @ResponseBody
	    public ResponseEntity<Map<String, Object>> getAccountById(@PathVariable String reportId, @PathVariable String foracid) {
	        return regulatoryreportservices.getAccountById(reportId, foracid)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping("/update_mapping/{reportId}")
	    @ResponseBody
	    public ResponseEntity<String> updateMapping(@PathVariable String reportId, @RequestBody Map<String, Object> entityData) {
	        String response = regulatoryreportservices.updateMapping(reportId, entityData);
	        return ResponseEntity.ok(response);
	    }

	    @GetMapping("/mapped_accounts/download/{reportId}")
	    public ResponseEntity<byte[]> downloadMappedAccounts(@PathVariable String reportId) throws IOException {
	        byte[] excelData = regulatoryreportservices.generateExcelForMappedAccounts(reportId);
	        // ... headers and response ...
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Mapped_Accounts.xlsx")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(excelData);
	    }

	    @GetMapping("/unmapped_accounts/download/{reportId}")
	    public ResponseEntity<byte[]> downloadUnmappedAccounts(@PathVariable String reportId) throws IOException {
	        byte[] excelData = regulatoryreportservices.generateExcelForUnmappedAccounts(reportId);
	        // ... headers and response ...
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Unmapped_Accounts.xlsx")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(excelData);
	    }
}
