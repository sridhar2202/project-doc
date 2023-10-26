package Context;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import businessComponents.CRM_Eventinfo_sk;
import businessComponents.CRM_LeadCreation_DashBoardInfo_sk;
import businessComponents.CRM_LeadCreation_Logininfo_sk;
import businessComponents.CRM_LeadCreation_NewLeadinfo_sk;
import businessComponents.CRM_LeadCreation_leadtabinfo_sk;
import businessComponents.CRM_LeadUpdate_basicdetailsinfo_sk;
import businessComponents.CRM_Leadprogressinfo_sk;
import businessComponents.CRM_Quickcreateinfo_sk;
import businessComponents.CRM_admininfo_sk;
import businessComponents.CRM_aeinfo_sk;
import businessComponents.CustomerInfo_sk;
//import businessComponents.CustomerInfo;
//import businessComponents.CustomerInfo_sk;
import businessComponents.DashBoardInfo_sk;
//import businessComponents.DashBoardInfo;
//import businessComponents.DashBoardInfo_sk;
import businessComponents.LoginInfo_sk;
//import businessComponents.LoginInfo;
//import businessComponents.LoginInfo_sk;
import businessComponents.RateInfo_sk;
//import businessComponents.RateInfo;
//import businessComponents.RateInfo_sk;
import businessComponents.Regex_sk;
//import businessComponents.Regex;
//import businessComponents.Regex_sk;
import io.cucumber.datatable.DataTable;
import library.DriverFactory;
import library.ReusableComponents_sk;
import pageObjects.CRM_Eventcreation_sk;

public class TestContext_sk {


	DriverFactory driverfactory = new DriverFactory();
	WebDriver driver = driverfactory.Chromesetup();
	LoginInfo_sk login;
	DashBoardInfo_sk dashboard;
	CustomerInfo_sk customer;
	RateInfo_sk rate;
	Regex_sk regex;
	ReusableComponents_sk reusecomp;
	
	CRM_LeadCreation_Logininfo_sk login_crm;
	CRM_LeadCreation_DashBoardInfo_sk dashboard_crm;
	CRM_LeadCreation_leadtabinfo_sk leadtab_crm;
	CRM_LeadCreation_NewLeadinfo_sk newlead_crm;
	CRM_LeadUpdate_basicdetailsinfo_sk leadupdate_crm;
	CRM_Leadprogressinfo_sk leadprogress_crm;
	CRM_Eventinfo_sk event_crm;
	CRM_Quickcreateinfo_sk quickcreate_crm;
	CRM_admininfo_sk admin_crm;
	CRM_aeinfo_sk aemainpage_crm;
	
	DataTable testdata;
	
	
		public DriverFactory getDriverfactory() {
		return driverfactory;
	}

	public void setDriverfactory(DriverFactory driverfactory) {
		this.driverfactory = driverfactory;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public LoginInfo_sk getLogin() {
		return login;
	}

	public void setLogin(LoginInfo_sk login) {
		this.login = login;
	}

	public DashBoardInfo_sk getDashboard() {
		return dashboard;
	}

	public void setSearch(DashBoardInfo_sk dashboard) {
		this.dashboard = dashboard;
	}

	public CustomerInfo_sk getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInfo_sk customer) {
		this.customer = customer;
	}

	public RateInfo_sk getRate() {
		return rate;
	}

	public void setRate(RateInfo_sk rate) {
		this.rate = rate;
	}
	
	public CRM_LeadCreation_Logininfo_sk getCRMLeadCreationLogin() {
		return login_crm;
	}
	
	public void setCRMLeadCreationLogin(CRM_LeadCreation_Logininfo_sk login_crm) {
		this.login_crm= login_crm;
	}
	
	public CRM_LeadCreation_DashBoardInfo_sk getDashboard_crm() {
		return dashboard_crm;
	}
	
	public void setCRMLeadCreationDashboard(CRM_LeadCreation_DashBoardInfo_sk dashboard_crm) {
		this.dashboard_crm= dashboard_crm;
	}
	
	public CRM_LeadCreation_leadtabinfo_sk getLeadTab_crm() {
		return leadtab_crm;	
	}
	
	public void setLeadTab_crm(CRM_LeadCreation_leadtabinfo_sk lead_crm) {
		this.leadtab_crm=lead_crm;
	}
	
	public CRM_LeadCreation_NewLeadinfo_sk getNewlead_crm() {
		return newlead_crm;
	}
	
	public void setNewlead_crm(CRM_LeadCreation_NewLeadinfo_sk newlead_crm) {
		this.newlead_crm=newlead_crm;
	}
	public CRM_LeadUpdate_basicdetailsinfo_sk getLeadupdate_crm() {
		return leadupdate_crm;
	}
	
	public void setLeadupdate_crm(CRM_LeadUpdate_basicdetailsinfo_sk leadupdate_crm) {
		this.leadupdate_crm=leadupdate_crm;
	}
	
	public CRM_Leadprogressinfo_sk getLeadprogress_crm() {
		return leadprogress_crm;
	}
	
	public void setLeadprogress(CRM_Leadprogressinfo_sk leadprogress_crm) {
		this.leadprogress_crm= leadprogress_crm;
	}
	
	public CRM_Eventinfo_sk getEvent_crm() {
		return event_crm;
	}
	
	public void setEvent_crm(CRM_Eventinfo_sk event_crm ) {
		this.event_crm= event_crm;
	}
	
	public CRM_Quickcreateinfo_sk getQuickcreate_crm() {
		return quickcreate_crm;
	}
	
	public void setQuickcreate_crm(CRM_Quickcreateinfo_sk quickcreate_crm) {
		this.quickcreate_crm= quickcreate_crm;
	}
	
	public CRM_admininfo_sk getadmin_crm() {
		return admin_crm;
	}
	public void setadmin_crm(CRM_admininfo_sk admin_crm) {
		this.admin_crm= admin_crm;
	}
	
	public CRM_aeinfo_sk getaemainpage_crm() {
		return aemainpage_crm;
	}
	
	public void setaemainpage(CRM_aeinfo_sk aemainpage_crm) {
		this.aemainpage_crm=aemainpage_crm;
	}
	public Regex_sk getRegex() {
		return regex;
	}

	public void setRegex(Regex_sk regex) {
		this.regex = regex;
	}
	public ReusableComponents_sk getReusablecomp() {
		return reusecomp;
	}

	public void setReusablecomp(ReusableComponents_sk reusecomp) {
		this.reusecomp = reusecomp;
	}
	
	public void initializePageObjects(WebDriver driver){
		
		login = new LoginInfo_sk(driver);
		dashboard = new DashBoardInfo_sk(driver);
		customer = new CustomerInfo_sk(driver);
		rate = new RateInfo_sk(driver);
		regex=new Regex_sk(driver);
		reusecomp = new ReusableComponents_sk();
		login_crm= new CRM_LeadCreation_Logininfo_sk(driver);
		dashboard_crm = new CRM_LeadCreation_DashBoardInfo_sk(driver);
		leadtab_crm = new CRM_LeadCreation_leadtabinfo_sk(driver);
		newlead_crm=new CRM_LeadCreation_NewLeadinfo_sk(driver);
		leadupdate_crm= new CRM_LeadUpdate_basicdetailsinfo_sk(driver);
		leadprogress_crm= new CRM_Leadprogressinfo_sk(driver);
		event_crm= new CRM_Eventinfo_sk(driver);
		quickcreate_crm = new CRM_Quickcreateinfo_sk(driver);
		admin_crm= new CRM_admininfo_sk(driver);
		aemainpage_crm=new CRM_aeinfo_sk(driver);
	}
	
	
	
	
	
	
	
}
