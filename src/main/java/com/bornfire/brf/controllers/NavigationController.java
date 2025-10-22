package com.bornfire.brf.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	                                  
	                                   Model md, HttpServletRequest req) {

	    String account_id_bacid = (String) req.getSession().getAttribute("ACCOUNT_ID_BACID");
	    String userid = (String) req.getSession().getAttribute("USERID");

	    if (formmode == null || formmode.equals("list")) {
	        md.addAttribute("formmode", "list");
	        md.addAttribute("menuname", "BASE MAPPING PARAMETER");
	        md.addAttribute("Basemappingparameter", basemappingparameterrepository.getBaseMappingParameter(account_id_bacid));
	    } else if (formmode.equals("add")) {
	        md.addAttribute("menuname", "BASE MAPPING PARAMETER - ADD");
	        md.addAttribute("formmode", "add");
	    }else if (formmode.equals("delete")) {
             md.addAttribute("formmode", formmode);
			md.addAttribute("userProfile", loginServices.getUser(userid));

		}else if ("edit".equalsIgnoreCase(formmode) && account_id_bacid != null) {
            md.addAttribute("formmode", "edit");
            md.addAttribute("basemappingparameter", basemappingparameterrepository.findById(account_id_bacid)
                .orElse(new BaseMappingParameter()));
        }

	    return "BaseMappingParameter"; // your Thymeleaf page
	}

	@GetMapping("/createBaseMappingParameter")
	public String showCreateForm(@RequestParam(name = "formmode", required = false, defaultValue = "add") String formmode,
	                             Model md, HttpServletRequest req) {
	    String account_id_bacid = (String) req.getSession().getAttribute("ACCOUNT_ID_BACID");
	    md.addAttribute("formmode", "add");
	    md.addAttribute("menuname", "BASE MAPPING PARAMETER - ADD");
	    return "BaseMappingParameter"; // Thymeleaf template
	}
	
	@RequestMapping(value = "deletebasemappingparameter", method = RequestMethod.POST)
	@ResponseBody
	public String deletebasemappingparameter(@RequestParam("formmode") String userid, Model md, HttpServletRequest rq) {
		System.out.println("came to Delete user nav controller");
		String msg = basemappingparameterservice.deleteuser(userid);

		return msg;

	}
	
	@PostMapping("/updateBasemappingParameter")
	@ResponseBody
	public String updateBasemappingParameter(@ModelAttribute BaseMappingParameter basemappingparameter) {
		boolean updated = basemappingparameterservice.updatebasemappingparameter(basemappingparameter);

		if (updated) {
			return "Updated successful";
		} else {
			return "Record not found for update";
		}
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
}
