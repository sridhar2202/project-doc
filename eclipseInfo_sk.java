package businessComponents;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Reports.ExtentReport;
import io.netty.util.Constant;
import library.Constants;
import library.ReusableComponents_sk;
import pageObjects.CustomerDetailsPage_sk;
import pageObjects.DashBoardPage_sk;
import pageObjects.RateTabPage_sk;

public class RateInfo_sk {
	WebDriver driver;

	ReusableComponents_sk reusecomp = new ReusableComponents_sk();

	ExtentReports extent;
	ExtentTest logger;

	public RateInfo_sk(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void CreationTestScriptsTestFrame(String TCName) {
		// Creation of Reports for Script
		ExtentReport.CreateTest(TCName);
		ExtentReport.Test.info("Test Scenario :" + TCName);

	}
	public void sleep(WebDriver driver){
		reusecomp.sleep(200);
	}
	public void coverages(WebDriver driver, Map<String, String> testData) throws IOException {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.covgs1+"["+testData.get("coverage")+"]", Constants.XPATH);
			//			boolean elementClickable = reusecomp.isElementClickable(driver, RateTabPage.covgs1, Constants.XPATH);
			boolean elementClickable = reusecomp.isElementClickable(driver, RateTabPage_sk.covgs1+"["+testData.get("coverage")+"]", Constants.XPATH);
			System.out.println(elementClickable);
			reusecomp.sleep(500);
			if(elementClickable==true){
				reusecomp.sleep(200);
				//				String text = reusecomp.getText(driver, RateTabPage.covgs1, Constants.XPATH);
				String text = reusecomp.getText(driver, RateTabPage_sk.covgs1+"["+testData.get("coverage")+"]", Constants.XPATH);
				System.out.println(text);
				reusecomp.sleep(300);
				reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.covgs1+"["+testData.get("coverage")+"]", Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Element clickable");
			}
			else{
				System.out.println("Element not able to clickable");
				reusecomp.logFailedStepToReportWithScreenshot(driver, "Element not clickable");
			}
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void fra_ratetab(WebDriver driver, Map<String, String> testData) throws IOException {
		try {
			reusecomp.click(driver, RateTabPage_sk.rate_FRA ,	Constants.XPATH);
			boolean expensepercent_fra = reusecomp.isElementPresent(driver, RateTabPage_sk.expensepercent_rate_FRA , Constants.XPATH);
			String expensepercent_FRA = reusecomp.getText(driver,RateTabPage_sk.expensepercentvalue_rate_FRA, Constants.XPATH);
			System.out.println("expensepercent available :"+expensepercent_fra);
			System.out.println("expensepercent value :"+expensepercent_FRA);					
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Expense percent value displayed");
			reusecomp.click(driver, RateTabPage_sk.ratemainTab_FRA, Constants.XPATH);

			reusecomp.sleep(500);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//aso full feild check	
	public void fullFee_ASO_Attributes(WebDriver driver) throws IOException {
		try {
			//		
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptoASOBusiness, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "default value is blank for full fee");
			reusecomp.click(driver, RateTabPage_sk.fullfeebox, Constants.XPATH);
			String attribute_type = reusecomp.getAttribute(driver, RateTabPage_sk.fullfeebox, Constants.XPATH , "type");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"textboxtype is: " +attribute_type);
			reusecomp.clearValue(driver, RateTabPage_sk.fullfeebox, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver,"cleared" );
			reusecomp.getElement(driver, RateTabPage_sk.fullfeebox, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
			reusecomp.sleep(1000);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	select rg yr1 for std cvg FOR DENTAL ASO
	public void select_rg_yr0ne(WebDriver driver) throws IOException{
		try{
			reusecomp.input(driver, RateTabPage_sk.dentalasorg_yrone, "1", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	select rg yr1 for std cvg FIR STD ASO
	public void select_rg_yr0ne_STDASO(WebDriver driver) throws IOException{
		try{
			reusecomp.input(driver, RateTabPage_sk.stdasorg_yrone, "1", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//select rg yr1 field for std cvg
	public void select_rg_yr0ne1(WebDriver driver) throws IOException{
		try{
			reusecomp.input(driver, RateTabPage_sk.rg_yrone1, "1", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	logic check for full fee for std cvg
	public void logic_check_fullfee_field (WebDriver driver) throws IOException{
		try{
			//		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.fullfeebox, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.fullfeebox, Constants.XPATH);
			//		String attribute_enabled = reusecomp.getAttribute(driver, RateTabPage.fullfeebox,Constants.XPATH, "ng-required");
			//		reusecomp.logPassedStepToReportWithScreenshot(driver, attribute_enabled );
			Pattern setvalue=Pattern.compile("^[\\$][0-9]{0,1}\\,?[0-9]{0,3}[\\.][0-9]{2}$");
			String [] pricing={"$0.00","","0","-$1.00","1","12.00","12.3","-123","+123.00","$143.00","143.00","$9,999.99","9999","9,999.99","$10000"};
			for(int i=0;i<pricing.length;i++){
				reusecomp.input(driver, RateTabPage_sk.fullfeebox, pricing[i],Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "input is :"+pricing[i]);
				reusecomp.sleep(600);
				reusecomp.getElement(driver, RateTabPage_sk.fullfeebox,Constants.XPATH).sendKeys(Keys.TAB);
				reusecomp.sleep(1000);
				reusecomp.mouseHover(driver, RateTabPage_sk.fullfeebox, Constants.XPATH);
				reusecomp.sleep(1000);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "after tabout :"+pricing[i]);
				reusecomp.sleep(1000); 
				String displayedvaule = reusecomp.getAttribute(driver, RateTabPage_sk.fullfeebox,Constants.XPATH, "value");
				Matcher matchvalue=setvalue.matcher	(displayedvaule);
				boolean matchfound=matchvalue.find();
				if(matchfound==true){
					System.out.println("matchfound for: "+pricing[i]);
					reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for:"+pricing[i]);
					reusecomp.sleep(600);

				}
				else{
					System.out.println("no matches for: "+pricing[i]);
					reusecomp.logPassedStepToReportWithScreenshot(driver, "match not found for :"+pricing[i]);
					reusecomp.sleep(500);	
				}
			}
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	//			Pattern setvalue=Pattern.compile("^[\\$][0-9]{0,1}\\,?[0-9]{0,3}[\\.][0-9]{2}$");
	////			"^[+-]?[0-9]{2}\\,[0-9]{2}[\\.][0-9]{1}[\\%]$"	-43,34.1%
	////			"^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$"
	////			intln("matchfound for: "+pricing[i]);


	public void errorMSG_VB_AXcoverage_othercov(WebDriver driver) throws IOException {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbaxQuotedPremium,"" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbaxQuotedDiscount,"" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}
//			reusecomp.scrollWindow(driver, RateTabPage.padd_Label, Constants.XPATH);
//		reusecomp.click(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
//		reusecomp.sleep(1000);
//		reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-AX selected");
//		reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
//		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.btnapply, Constants.XPATH));
//		reusecomp.click(driver, RateTabPage.btnapply, Constants.XPATH);
//		reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
//		reusecomp.sleep(100);
//		reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal,Constants.XPATH);
//		reusecomp.input(driver, RateTabPage.quoteddiscount,"2", Constants.XPATH);
//		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH));
//		reusecomp.clearValue(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//		reusecomp.logPassedStepToReportWithScreenshot(driver, "Value Cleared");
//		reusecomp.sleep(500);
//		reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
//		reusecomp.sleep(200);
//		reusecomp.mouseHover(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//		reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//		reusecomp.sleep(100);
//		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH));
//		reusecomp.clearValue(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//		reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH).sendKeys(Keys.TAB);
//		reusecomp.mouseHover(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//		reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//		reusecomp.sleep(1000);
//		reusecomp.input(driver, RateTabPage.qoutedpremium, "1", Constants.XPATH);
//		reusecomp.input(driver, RateTabPage.quoteddiscount,"1", Constants.XPATH);
//		//			reusecomp.sleep(1000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void errorMSG_VB_HIcoverage_othercov(WebDriver driver) throws IOException {
		try {
		
				String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiQuotedPremium, Constants.XPATH,"value");
				System.out.println(quotedpremium1);

				if(quotedpremium1.isEmpty()){
					reusecomp.click(driver,  RateTabPage_sk.vbhiQuotedPremium, Constants.XPATH);
					reusecomp.sleep(200);						
					reusecomp.input(driver, RateTabPage_sk.vbhiQuotedPremium,"" , Constants.XPATH);
					reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
					reusecomp.sleep(300);
				}

				String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiQuotedDiscount, Constants.XPATH,"value");
				System.out.println(quotedmargin1);
				if(quotedmargin1.isEmpty()){
					reusecomp.click(driver,  RateTabPage_sk.vbhiQuotedDiscount, Constants.XPATH);
					reusecomp.sleep(200);									
					reusecomp.input(driver, RateTabPage_sk.vbhiQuotedDiscount,"" , Constants.XPATH);
					reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
					reusecomp.sleep(300);
				}
//				reusecomp.javascriptscrollintoview(driver, RateTabPage.dental_ASO_Label, Constants.XPATH);
//			reusecomp.sleep(1000);
//			reusecomp.click(driver, RateTabPage.vb_AX_Label,Constants.XPATH);
//			reusecomp.scrollWindow(driver, RateTabPage.padd_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.vb_HI_Label, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-HI selected");
//			reusecomp.sleep(1000);
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_HI_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
//			reusecomp.sleep(100);
//			reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal,Constants.XPATH);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"2", Constants.XPATH);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Value Cleared");
//			reusecomp.sleep(500);
//			reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.sleep(200);
//			reusecomp.mouseHover(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(100);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.mouseHover(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(1000);
//			reusecomp.input(driver, RateTabPage.qoutedpremium, "1", Constants.XPATH);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"1", Constants.XPATH);
			//			reusecomp.sleep(1000);

		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
	public void errorMSG_VB_CIAcoverage_othercov(WebDriver driver) throws IOException {
		try {
			
				String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH,"value");
				System.out.println(quotedpremium1);

				if(quotedpremium1.isEmpty()){
					reusecomp.click(driver,  RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH);
					reusecomp.sleep(200);						
					reusecomp.input(driver, RateTabPage_sk.vbciaQuotedPremium,"" , Constants.XPATH);
					reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
					reusecomp.sleep(300);
				}

				String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaQuotedDiscount, Constants.XPATH,"value");
				System.out.println(quotedmargin1);
				if(quotedmargin1.isEmpty()){
					reusecomp.click(driver,  RateTabPage_sk.vbciaQuotedDiscount, Constants.XPATH);
					reusecomp.sleep(200);									
					reusecomp.input(driver, RateTabPage_sk.vbciaQuotedDiscount,"" , Constants.XPATH);
					reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
					reusecomp.sleep(300);
				}
//				reusecomp.javascriptscrollintoview(driver, RateTabPage.dental_ASO_Label, Constants.XPATH);
//			reusecomp.sleep(1000);
//			reusecomp.click(driver, RateTabPage.vb_HI_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.vb_CIA_Label, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-CIA selected");
//			reusecomp.sleep(1000);
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_CIA_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
//			reusecomp.sleep(100);
//			reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal,Constants.XPATH);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"2", Constants.XPATH);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Value Cleared");
//			reusecomp.sleep(500);
//			reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.sleep(200);
//			reusecomp.mouseHover(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(100);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.mouseHover(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(1000);
//			reusecomp.input(driver, RateTabPage.qoutedpremium, "1", Constants.XPATH);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"1", Constants.XPATH);
			//			reusecomp.sleep(1000);

		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void errorMSG_VB_CIIcoverage_othercov(WebDriver driver) throws IOException {
		try {
			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbciiQuotedPremium,"" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbciiQuotedDiscount,"" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}
//			try {
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.dental_ASO_Label, Constants.XPATH);
//			reusecomp.sleep(1000);
//			reusecomp.click(driver, RateTabPage.vb_CIA_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.vb_CII_Label, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-CII selected");
//			reusecomp.sleep(1000);
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
//			reusecomp.sleep(100);
//			reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal,Constants.XPATH);
//			reusecomp.sleep(500);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"2", Constants.XPATH);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Value Cleared");
//			reusecomp.sleep(500);
//			reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.sleep(100);
//			reusecomp.mouseHover(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.mouseHover(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(1000);
//			reusecomp.input(driver, RateTabPage.qoutedpremium, "1", Constants.XPATH);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"1", Constants.XPATH);
			//				reusecomp.sleep(1000);

		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}



	}
	public void errorMSG_HyattLegalcoverage_othercov(WebDriver driver) throws IOException {
		try {
			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhyattlegalQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhyattlegalQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbhyattlegalQuotedPremium,"" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhyattlegalQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhyattlegalQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbhyattlegalQuotedDiscount,"" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}
//			try{
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.dependent_Life_Label, Constants.XPATH);
//			reusecomp.sleep(1000);
//			reusecomp.click(driver, RateTabPage.vb_CII_Label, Constants.XPATH);//deseleceted in previous method
//			reusecomp.click(driver, RateTabPage.hyatt_Legal_Label, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-Hyatt selected");
//			reusecomp.sleep(1000);
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
//			reusecomp.click(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
//			reusecomp.sleep(100);
//			reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal,Constants.XPATH);
//			reusecomp.sleep(500);
//			reusecomp.input(driver, RateTabPage.quoteddiscount,"2", Constants.XPATH);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH));
//			reusecomp.clearValue(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Value Cleared");
//			reusecomp.sleep(500);
//			reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.mouseHover(driver, RateTabPage.qoutedpremium, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(100);
//			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH));
//			reus ecomp.clearValue(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH).sendKeys(Keys.TAB);
//			reusecomp.mouseHover(driver, RateTabPage.quoteddiscount, Constants.XPATH);
//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Error msg displayed");
//			reusecomp.sleep(1000);
			//			reusecomp.input(driver, RateTabPage.qoutedpremium, "1", Constants.XPATH);
			//			reusecomp.input(driver, RateTabPage.quoteddiscount,"1", Constants.XPATH);
			//			reusecomp.sleep(1000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	VBCIA all values
	public void validate_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBCIAcvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vbciaEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbciaQuotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbciaQuotedDiscount,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaComissionyr1, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaComissionyr1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaComissionyr1,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 1 values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaComissionyr2, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaComissionyr2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaComissionyr2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 2 values entered");
				reusecomp.sleep(300);
				reusecomp.getElement(driver, RateTabPage_sk.vbciaComissionyr2, Constants.XPATH).sendKeys(Keys.TAB);

			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaAdminfee, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaAdminfee,Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaAdminfee,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Admin fee values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	VBCII all values
	public void validate_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBCIIcvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciiEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vbciiEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbciiQuotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbciiQuotedDiscount,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiComissionyr1, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiComissionyr1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciiComissionyr1,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 1 values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiComissionyr2, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiComissionyr2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciiComissionyr2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 2 values entered");
				reusecomp.sleep(300);
				reusecomp.getElement(driver, RateTabPage_sk.vbciiComissionyr2, Constants.XPATH).sendKeys(Keys.TAB);

			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vbciiAdminfee, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciiAdminfee,Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciiAdminfee,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Admin fee values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	VBHI all values
	public void validate_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBHIcvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal, Constants.XPATH);
			//					reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhiEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbhiEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vbhiEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhiQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbhiQuotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhiQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbhiQuotedDiscount,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiComissionyr1, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhiComissionyr1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbhiComissionyr1,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 1 values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiComissionyr2, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhiComissionyr2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbhiComissionyr2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 2 values entered");
				reusecomp.sleep(300);
				reusecomp.getElement(driver, RateTabPage_sk.vbhiComissionyr2, Constants.XPATH).sendKeys(Keys.TAB);

			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vbhiAdminfee, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhiAdminfee,Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbhiAdminfee,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Admin fee values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	VBAX all values
	public void validate_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBAXcvgs(WebDriver driver) throws Exception {
		try {
//			reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal, Constants.XPATH);
			//						reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbaxEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vbaxEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbaxQuotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbaxQuotedDiscount,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxComissionyr1, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxComissionyr1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbaxComissionyr1,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 1 values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxComissionyr2, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxComissionyr2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbaxComissionyr2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 2 values entered");
				reusecomp.sleep(300);
				reusecomp.getElement(driver, RateTabPage_sk.vbaxComissionyr2, Constants.XPATH).sendKeys(Keys.TAB);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vbaxAdminfee, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbaxAdminfee,Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbaxAdminfee,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Admin fee values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	public void logic_validation_for_riFields_ri6(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri6, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri6:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
				//				reusecomp.getElement(driver, RateTabPage.ri6, Constants.XPATH).sendKeys(Keys.TAB);
				//				reusecomp.sleep(200);
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri7(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri7, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri7:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
				//				
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri8(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri8, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri8:"+DisplayedActualValue);;
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri9(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri9, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri9:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri10(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri10, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri10:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri6_2(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri6_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri6_2:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri7_2(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue =reusecomp.getText(driver, RateTabPage_sk.ri7_2, Constants.XPATH);				
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri7_2:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri8_2(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri8_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri8_2:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri9_2(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri9_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri9_2:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void logic_validation_for_riFields_ri10_2(WebDriver driver)throws Exception{
		try{
			String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.ri10_2, Constants.XPATH)	;
			reusecomp.logPassedStepToReportWithScreenshot(driver, "populated value for ri10_2:"+DisplayedActualValue);
			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}[0-9]{0,3}\\.[0-9]{2}\\%$");
			Matcher matchvalue=setvalue.matcher	(DisplayedActualValue);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println("matchfound for: "+DisplayedActualValue);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "match found for: "+DisplayedActualValue);
				reusecomp.sleep(600);		
			}
			else{
				System.out.println("no matches for: "+DisplayedActualValue);
				reusecomp.logFailedStepToReportWithScreenshot(driver,"match not found for: "+DisplayedActualValue);
				reusecomp.sleep(500);
			}
		}catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		Logic validation for targer discounts uw manager floor discounts bundled floor discounts
	public void logic_validation_for_discounts_fields_for_VBcvgsd(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.targetdiscount, Constants.XPATH));
			String targetdiscountActual = reusecomp.getText(driver, RateTabPage_sk.targetdiscount, Constants.XPATH);
			//				String targetdiscountActual = reusecomp.getAttribute(driver, RateTabPage.targetdiscount, Constants.XPATH, "value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element targetdiscount actual: "+targetdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element targetdiscount actual: "+targetdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue=setvalue.matcher	(targetdiscountActual);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println(" format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+targetdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"match not found for: "+targetdiscountActual);
				reusecomp.sleep(500);
			}

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH));
			String uwmanagerdiscountActual = reusecomp.getText(driver, RateTabPage_sk.uwmanagerfloordiscount, Constants.XPATH);
			//				String uwmanagerdiscountActual = reusecomp.getAttribute(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue1=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue1=setvalue1.matcher (uwmanagerdiscountActual);
			boolean matchfound1=matchvalue1.find();
			if(matchfound1==true){
				System.out.println("format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format match not found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(500);

			} 

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.bundleddiscount, Constants.XPATH));
			String bundleddiscountActual = reusecomp.getText(driver, RateTabPage_sk.bundleddiscount, Constants.XPATH);
			//				String bundleddiscountActual = reusecomp.getAttribute(driver, RateTabPage.bundleddiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "bundled discount actual:"+bundleddiscountActual);
			ExtentReport.Test.log(Status.INFO, "bundled discount actual: " + bundleddiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue2=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//			String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue2=setvalue2.matcher (uwmanagerdiscountActual);
			boolean matchfound2=matchvalue2.find();
			if(matchfound2==true){
				System.out.println("format matchfound for: "+bundleddiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+bundleddiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format not found for: "+bundleddiscountActual);
				reusecomp.sleep(500);

			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}
	//	vbcia logic validation
	public void logic_validation_for_discounts_fields_for_VBCIAcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.targetdiscount, Constants.XPATH));
			String targetdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbciaTargetDiscount, Constants.XPATH);
			//				String targetdiscountActual = reusecomp.getAttribute(driver, RateTabPage.targetdiscount, Constants.XPATH, "value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element targetdiscount actual: "+targetdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element targetdiscount actual: "+targetdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue=setvalue.matcher	(targetdiscountActual);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println(" format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+targetdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"match not found for: "+targetdiscountActual);
				reusecomp.sleep(500);
			}

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH));
			String uwmanagerdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbciaUWManagerDiscount, Constants.XPATH);
			//				String uwmanagerdiscountActual = reusecomp.getAttribute(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue1=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue1=setvalue1.matcher (uwmanagerdiscountActual);
			boolean matchfound1=matchvalue1.find();
			if(matchfound1==true){
				System.out.println("format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format match not found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(500);

			} 

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.bundleddiscount, Constants.XPATH));
			String bundleddiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbciaBundledDiscount, Constants.XPATH);
			//				String bundleddiscountActual = reusecomp.getAttribute(driver, RateTabPage.bundleddiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "bundled discount actual:"+bundleddiscountActual);
			ExtentReport.Test.log(Status.INFO, "bundled discount actual: " + bundleddiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue2=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//			String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue2=setvalue2.matcher (uwmanagerdiscountActual);
			boolean matchfound2=matchvalue2.find();
			if(matchfound2==true){
				System.out.println("format matchfound for: "+bundleddiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+bundleddiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format not found for: "+bundleddiscountActual);
				reusecomp.sleep(500);

			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}
	//	logic validation VBCII
	public void logic_validation_for_discounts_fields_for_VBCIIcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.targetdiscount, Constants.XPATH));
			String targetdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbciiTargetDiscount, Constants.XPATH);
			//				String targetdiscountActual = reusecomp.getAttribute(driver, RateTabPage.targetdiscount, Constants.XPATH, "value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element targetdiscount actual: "+targetdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element targetdiscount actual: "+targetdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue=setvalue.matcher	(targetdiscountActual);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println(" format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+targetdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"match not found for: "+targetdiscountActual);
				reusecomp.sleep(500);
			}

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH));
			String uwmanagerdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbciiUWManagerDiscount, Constants.XPATH);
			//				String uwmanagerdiscountActual = reusecomp.getAttribute(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue1=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue1=setvalue1.matcher (uwmanagerdiscountActual);
			boolean matchfound1=matchvalue1.find();
			if(matchfound1==true){
				System.out.println("format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format match not found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(500);

			} 

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.bundleddiscount, Constants.XPATH));
			String bundleddiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbciiBundledDiscount, Constants.XPATH);
			//				String bundleddiscountActual = reusecomp.getAttribute(driver, RateTabPage.bundleddiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "bundled discount actual:"+bundleddiscountActual);
			ExtentReport.Test.log(Status.INFO, "bundled discount actual: " + bundleddiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue2=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//			String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue2=setvalue2.matcher (uwmanagerdiscountActual);
			boolean matchfound2=matchvalue2.find();
			if(matchfound2==true){
				System.out.println("format matchfound for: "+bundleddiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+bundleddiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format not found for: "+bundleddiscountActual);
				reusecomp.sleep(500);

			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}
	//	logic validation VBHI
	public void logic_validation_for_discounts_fields_for_VBHIcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.targetdiscount, Constants.XPATH));
			String targetdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbhiTargetDiscount, Constants.XPATH);
			//				String targetdiscountActual = reusiecomp.getAttribute(driver, RateTabPage.targetdiscount, Constants.XPATH, "value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element targetdiscount actual: "+targetdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element targetdiscount actual: "+targetdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue=setvalue.matcher	(targetdiscountActual);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println(" format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+targetdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"match not found for: "+targetdiscountActual);
				reusecomp.sleep(500);
			}

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH));
			String uwmanagerdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbhiUWManagerDiscount, Constants.XPATH);
			//				String uwmanagerdiscountActual = reusecomp.getAttribute(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue1=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue1=setvalue1.matcher (uwmanagerdiscountActual);
			boolean matchfound1=matchvalue1.find();
			if(matchfound1==true){
				System.out.println("format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format match not found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(500);

			} 

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.bundleddiscount, Constants.XPATH));
			String bundleddiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbhiBundledDiscount, Constants.XPATH);
			//				String bundleddiscountActual = reusecomp.getAttribute(driver, RateTabPage.bundleddiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "bundled discount actual:"+bundleddiscountActual);
			ExtentReport.Test.log(Status.INFO, "bundled discount actual: " + bundleddiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue2=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//			String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue2=setvalue2.matcher (uwmanagerdiscountActual);
			boolean matchfound2=matchvalue2.find();
			if(matchfound2==true){
				System.out.println("format matchfound for: "+bundleddiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+bundleddiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format not found for: "+bundleddiscountActual);
				reusecomp.sleep(500);

			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}
	//	logic validation VBHyatt
	public void logic_validation_for_discounts_fields_for_VBHYATTLEGALcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.targetdiscount, Constants.XPATH));
			String targetdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbhyattlegalTargetDiscount, Constants.XPATH);
			//				String targetdiscountActual = reusiecomp.getAttribute(driver, RateTabPage.targetdiscount, Constants.XPATH, "value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element targetdiscount actual: "+targetdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element targetdiscount actual: "+targetdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue=setvalue.matcher	(targetdiscountActual);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println(" format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+targetdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"match not found for: "+targetdiscountActual);
				reusecomp.sleep(500);
			}

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH));
			String uwmanagerdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbhyattlegalUWManagerDiscount, Constants.XPATH);
			//				String uwmanagerdiscountActual = reusecomp.getAttribute(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue1=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue1=setvalue1.matcher (uwmanagerdiscountActual);
			boolean matchfound1=matchvalue1.find();
			if(matchfound1==true){
				System.out.println("format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format match not found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(500);

			} 

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.bundleddiscount, Constants.XPATH));
			String bundleddiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbhyattlegalBundledDiscount, Constants.XPATH);
			//				String bundleddiscountActual = reusecomp.getAttribute(driver, RateTabPage.bundleddiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "bundled discount actual:"+bundleddiscountActual);
			ExtentReport.Test.log(Status.INFO, "bundled discount actual: " + bundleddiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue2=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//			String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue2=setvalue2.matcher (uwmanagerdiscountActual);
			boolean matchfound2=matchvalue2.find();
			if(matchfound2==true){
				System.out.println("format matchfound for: "+bundleddiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+bundleddiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format not found for: "+bundleddiscountActual);
				reusecomp.sleep(500);

			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}
	//	logic validation VBAX
	public void logic_validation_for_discounts_fields_for_VBAXcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.targetdiscount, Constants.XPATH));
			String targetdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbaxTargetDiscount, Constants.XPATH);
			//				String targetdiscountActual = reusecomp.getAttribute(driver, RateTabPage.targetdiscount, Constants.XPATH, "value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element targetdiscount actual: "+targetdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element targetdiscount actual: "+targetdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue=setvalue.matcher	(targetdiscountActual);
			boolean matchfound=matchvalue.find();
			if(matchfound==true){
				System.out.println(" format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+targetdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"match not found for: "+targetdiscountActual);
				reusecomp.sleep(500);
			}

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH));
			String uwmanagerdiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbaxUWManagerDiscount, Constants.XPATH);
			//				String uwmanagerdiscountActual = reusecomp.getAttribute(driver, RateTabPage.uwmanagerfloordiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			ExtentReport.Test.log(Status.INFO,"Element uw manager floor discount actual: "+uwmanagerdiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue1=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//					String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue1=setvalue1.matcher (uwmanagerdiscountActual);
			boolean matchfound1=matchvalue1.find();
			if(matchfound1==true){
				System.out.println("format matchfound for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format match not found for: "+uwmanagerdiscountActual);
				reusecomp.sleep(500);

			} 

			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.bundleddiscount, Constants.XPATH));
			String bundleddiscountActual = reusecomp.getText(driver, RateTabPage_sk.vbaxBundledDiscount, Constants.XPATH);
			//				String bundleddiscountActual = reusecomp.getAttribute(driver, RateTabPage.bundleddiscount, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "bundled discount actual:"+bundleddiscountActual);
			ExtentReport.Test.log(Status.INFO, "bundled discount actual: " + bundleddiscountActual);
			reusecomp.sleep(200);

			Pattern setvalue2=Pattern.compile("^[+-]?[0-9]{0,1}\\,?[0-9]{0,3}\\.[0-9]{2}\\%$");
			//			String [] pricing={targetdiscountActual,uwmanagerdiscountActual,bundleddiscountActual};
			Matcher matchvalue2=setvalue2.matcher (uwmanagerdiscountActual);
			boolean matchfound2=matchvalue2.find();
			if(matchfound2==true){
				System.out.println("format matchfound for: "+bundleddiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "format match found for: "+bundleddiscountActual);
				reusecomp.sleep(600);					
			}
			else{
				System.out.println("no format matches for: "+targetdiscountActual);
				reusecomp.logPassedStepToReportWithScreenshot(driver,"format not found for: "+bundleddiscountActual);
				reusecomp.sleep(500);

			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}

	//	STD ASO select from other cvgs
	public void STDASO_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptosec, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.dependent_Life_Label, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.std_ASO_Label , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "std ASO clicked");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	VADD from other cvg
	public void VADD_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptosec, Constants.XPATH);
			//				reusecomp.scrollWindow(driver, RateTabPage.vadd_Label, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vadd_Label , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "VADD clicked");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	dental ppo 2018 select option
	public void DentalPPO_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.sleep(500);
			reusecomp.selectDropDownByVisibleText(driver, RateTabPage_sk.secondselectoptempty ,"2018 Dental Low Renewal", Constants.XPATH);
			//				reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Dental PPO select");
			reusecomp.sleep(500);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	LTD 2017 reneval from select option
	public void LTD_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.sleep(500);
//			reusecomp.selectDropDownByVisibleText(driver, RateTabPage.secondselectoptempty ,"2016 LTD Renewal", Constants.XPATH);
			//				reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "LTD Renewal selected in select option");
			reusecomp.sleep(500);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	select options 2nd
	public void SecondOption_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.secondselectoptempty ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option2 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		select options 2nd version2
	public void SecondOption_selected_from_selectOptions_version2(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.secondselectoptempty_version2 ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option2 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	get all dropdown values for 2nd option
	public void getdropdownvalue_SecondOption(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropdownElementgetValues(driver,RateTabPage_sk.secondselectoptempty , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option1 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	get all dropdown values for 2nd option verison2
	public void getdropdownvalue_SecondOption_version2(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropdownElementgetValues(driver,RateTabPage_sk.secondselectoptempty_version2 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option2 is selected from dropdown in version2 ");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	selecct option 1st
	public void FirstOption_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.firstselectoptempty ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option1 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	get all dropdown values for 1st option
	public void getdropdownvalue_FirstOption(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropdownElementgetValues(driver,RateTabPage_sk.firstselectoptempty , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option1 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	get all dropdown values for 1st option version 2
	public void getdropdownvalue_FirstOption_version2(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropdownElementgetValues(driver,RateTabPage_sk.firstselectoptempty_version2 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option1 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	select option 3rd
	public void ThirdOption_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.thirdselectoptempty ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option3 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	Sudeep's code
	public void verifyUpdatesToUI(WebDriver driver) throws IOException {
        try {
              // QuotedMargin VLTD Scenario Single cov selected
              System.out.print("this metod is being called");
              reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
              ExtentReport.Test.log(Status.PASS, "Expand and collapse functions of invidual coverages are version");
              ExtentReport.Test.log(Status.PASS, "WCP header located and pricing section located");
              reusecomp.sleep(8000);
              ExtentReport.Test.log(Status.PASS, "Apply button located");
              reusecomp.click(driver,RateTabPage_sk.btnapply, Constants.XPATH);
              reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
              reusecomp.scrollWindow(driver, RateTabPage_sk.totalrow, Constants.XPATH);
              ExtentReport.Test.log(Status.PASS, "FI core section coverage is located in WCP UI");
              ExtentReport.Test.log(Status.PASS, "Horizontal scroll bar verified");
              reusecomp.sleep(100);
//              ExtentReport.Test.log(Status.PASS, "Scroll window to total row");
//              reusecomp.scrollWindow(driver, RateTabPage.totalrow, Constants.XPATH);
              reusecomp.logPassedStepToReportWithScreenshot(driver, "Total Table for FI CORE coverages");
              //reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, LoginPage.qmLTD2,Constants.XPATH));
              reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.calculate_ficore,Constants.XPATH));
              reusecomp.scrollWindow(driver, RateTabPage_sk.asoCovTotalLabel, Constants.XPATH);
              ExtentReport.Test.log(Status.PASS, "ASO and VB sections are verified");
              ExtentReport.Test.log(Status.PASS, "Core VB coverage values displayed all 12 digits");
              reusecomp.logPassedStepToReportWithScreenshot(driver, "Total Table for ASO/VB coverages");           

        } catch (Exception e) {
              reusecomp.logger.warning(e.getMessage());
              reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
        }
  }
//	plan design tab click
//	scrolluptowcp
	public void Click_addplan_DesignTab(WebDriver driver) throws Exception {
		try {
			reusecomp.click(driver, RateTabPage_sk.addPlan_planDesign, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Plan Design Tab clicked");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	//	scrolluptowcp
	public void Scrolluptowcp(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "coversges from select options displayed ");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		scrolluptocaselevel
	public void Scrolluptocaselevel(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptoCaselevel, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Versions added displeyed prior version collapsed");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());

		}}
	//	scrolluptoficore ver1
	public void scroll_to_ficore(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.btnapply, Constants.XPATH);
			//				reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "scrolled to ficore");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public String Update_the_values_participantLives_for_DentalASO_cvg_ver2(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.btnapply, Constants.XPATH);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", ""); 
		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoparticipatingLives_ver2, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalasoparticipatingLives_ver2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalasoparticipatingLives_ver2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalasoparticipatingLives_ver2, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoparticipatingLives_ver2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"dentalaso participatingLives_ver2 values populated: "+eligiblelives_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalaso participatingLives_ver2 values populated");
			reusecomp.sleep(300);
			return eligiblelives_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalasoparticipatingLives_ver2, Constants.XPATH);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoparticipatingLives_ver2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
			ExtentReport.Test.log(Status.INFO,"dentalaso participatingLives_ver2 values populated: "+eligiblelives_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalaso participatingLives_ver2 values populated");					
			return eligiblelives_version1;
		}
	}
	public String Update_the_values_quotedFee_for_DentalASO_cvg_ver2(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.btnapply, Constants.XPATH);
		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoquotedFee_ver2, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalasoquotedFee_ver2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalasoquotedFee_ver2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalasoquotedFee_ver2, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoquotedFee_ver2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"dentalasoquotedFee_ver2 values populated: "+eligiblelives_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoquotedFee_ver2 values populated");
			reusecomp.sleep(300);
			return eligiblelives_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalasoquotedFee_ver2, Constants.XPATH);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoquotedFee_ver2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
			ExtentReport.Test.log(Status.INFO,"dentalasoquotedFee_ver2 values populated: "+eligiblelives_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoquotedFee_ver2 values populated");					
			return eligiblelives_version1;
		}
	}
	public String Update_the_values_fullFee_for_DentalASO_cvg_ver2(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasofullFee_ver2, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalasofullFee_ver2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalasofullFee_ver2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalasofullFee_ver2, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasofullFee_ver2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"dentalasofullFee_ver2 values populated: "+eligiblelives_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasofullFee_ver2 values populated");
			reusecomp.sleep(300);
			return eligiblelives_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalasofullFee_ver2, Constants.XPATH);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasofullFee_ver2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
			ExtentReport.Test.log(Status.INFO,"dentalasofullFee_ver2 values populated: "+eligiblelives_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasofullFee_ver2 values populated");					
			return eligiblelives_version1;
		}
	}
	public String Update_the_values_rgyr1_for_DentalASO_cvg_ver2(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasorgyr1_ver2, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalasorgyr1_ver2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalasorgyr1_ver2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalasorgyr1_ver2, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasorgyr1_ver2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"dentalasorgyr1_ver2 values populated: "+eligiblelives_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasorgyr1_ver2 values populated");
			reusecomp.sleep(300);
			return eligiblelives_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalasorgyr1_ver2, Constants.XPATH);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasorgyr1_ver2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
			ExtentReport.Test.log(Status.INFO,"dentalasorgyr1_ver2 values populated: "+eligiblelives_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasorgyr1_ver2 values populated");					
			return eligiblelives_version1;
		}
	}
	public String Update_the_values_rgnextreneval_for_DentalASO_cvg_ver2(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasorgnextreneval_ver2, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalasorgnextreneval_ver2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalasorgnextreneval_ver2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalasorgnextreneval_ver2, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasorgnextreneval_ver2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"dentalasorgnextreneval_ver2 values populated: "+eligiblelives_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasorgnextreneval_ver2 values populated");
			reusecomp.sleep(300);
			return eligiblelives_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalasorgnextreneval_ver2, Constants.XPATH);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasorgnextreneval_ver2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
			ExtentReport.Test.log(Status.INFO,"dentalasorgnextreneval_ver2 values populated: "+eligiblelives_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasorgnextreneval_ver2 values populated");					
			return eligiblelives_version1;
		}
	}
	//		scrolluptoficore ver2
	public void scroll_to_ficore_version2(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.btnapply_version2, Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)", ""); 
			//				reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "scrolled to ficore version2");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());

		}}
	//	scrolluptoaddversion1
	public void scroll_to_addversion1(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.addversion1, Constants.XPATH);
			//				reusecomp.scrollWindow(driver, RateTabPage.scrolluptototal, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "scrolled to ficore");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void scroll_to_top(WebDriver driver) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(-0,-0)", "");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Scrolled on top");
			reusecomp.sleep(200);
		}
		catch (Exception e) {
				System.out.println(e.toString());
				reusecomp.logger.warning(e.getMessage());
				reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
			}
			}
	public void click_AnalyseTab(WebDriver driver) throws Exception {
		try {	
			reusecomp.click(driver, RateTabPage_sk.analyzeTab, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "AnalyzseTab is Clicked");
			reusecomp.sleep(2000);
			reusecomp.click(driver, RateTabPage_sk.cvgs, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "total covgs");
			reusecomp.sleep(2000);
			}
		catch (Exception e) {
				System.out.println(e.toString());
				reusecomp.logger.warning(e.getMessage());
				reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
			}
		}
	public void click_RateTabfromAnalysistab(WebDriver driver) throws Exception {
			try {	
	reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.ratetabfromanalyze,Constants.XPATH));
	reusecomp.javascriptExecutorClick(driver,  RateTabPage_sk.ratetabfromanalyze, Constants.XPATH);
	reusecomp.logPassedStepToReportWithScreenshot(driver, "ratetab clicked");
	reusecomp.sleep(400);
	}
		catch (Exception e) {
				System.out.println(e.toString());
				reusecomp.logger.warning(e.getMessage());
				reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
			}
		}
	public void click_RateTab(WebDriver driver) throws Exception {
		try {	
			reusecomp.click(driver, RateTabPage_sk.ratetabfromanalyze, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "RateTab is Clicked");
			reusecomp.sleep(2000);
			}
		catch (Exception e) {
				System.out.println(e.toString());
				reusecomp.logger.warning(e.getMessage());
				reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
			}
		}
	//	select optiond 6th
	public void sixOption_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.sixselectoptempty ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option6 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	select option 4th
	public void fourOption_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.fourselectoptempty ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select option4 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	select option 5th
	public void fiveOption_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.fiveselectoptempty ,"-Select-", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "select 5 is selected from dropdown");
			reusecomp.sleep(500);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	basic life 2016 from select option
	public void basicLife_selected_from_selectOptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.thirdselectoptempty ,"2016 Basic Life Renewal", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "BasicLife is selected from dropdown");
			reusecomp.sleep(400);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	dental ppo other cvgs
	public void DentalPPO_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
			reusecomp.click(driver, RateTabPage_sk.dental_PPO_Label , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Dental PPO selected from other cvgs");
			reusecomp.sleep(300);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	public void supplementLife_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.supplemental_Life_Label, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "supplemental Label selected from other cvgs");
			reusecomp.sleep(300);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void dependentLife_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dependent_Life_Label, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dependent Label selected from other cvgs");
			reusecomp.sleep(300);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void PADD_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.padd_Label, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "padd Label selected from other cvgs");
			reusecomp.sleep(300);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void DHMO_selected_from_selectoptions(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.sleep(500);
			reusecomp.selectDropDownByVisibleText(driver,RateTabPage_sk.secondselectoptempty ,"DHMO Alternate", Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "DHMO Test Exp selected from select options");
			reusecomp.sleep(700);

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_firstRow(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.eligiblelives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.eligiblelives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.eligiblelives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.eligiblelives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.qoutedpremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.qoutedpremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.qoutedpremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.quotedmargin1, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.quotedmargin1, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.quotedmargin1,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.expenseperctab1, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.expenseperctab1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.expenseperctab1,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.rg_yr1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.rg_yr1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.rg_yr1,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.rgNextreneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.rgNextreneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.rgNextreneval,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	//	DentalPPO all values
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DentalPPO_cvg(WebDriver driver) throws Exception {
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalEligibleLives,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
				//				return eligiblelives_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalEligibleLives, Constants.XPATH);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
				//				return eligiblelives_version1;
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH, "value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalquotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.dentalquotedPremium,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalquotedPremium selected: "+quotedpremium_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
				//				return quotedpremium_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalquotedPremium, Constants.XPATH);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
				ExtentReport.Test.log(Status.INFO,"Element quotedpremium1 selected: "+quotedpremium_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalquotedPremium values entered");					
				//				return quotedpremium_version1;
			}


			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalquotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.dentalquotedMargin,"568" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalquotedmargin selected: "+quotedmargin_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
				//				return quotedmargin_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalquotedMargin, Constants.XPATH);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values entered");					
				//				return quotedmargin_version1;
			}

			String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH,"value");
			System.out.println(expenseperc);
			if(expenseperc.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalExpensePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalExpensePercent,"23" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH).sendKeys(Keys.TAB);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalExpensePercent selected: "+expenseperc_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
				//				return expenseperc_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalExpensePercent, Constants.XPATH);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+expenseperc_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version1 values entered");					
				//				return expenseperc_version1;
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalRgye1,"4" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH).sendKeys(Keys.TAB);
				String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalExpensePercent selected: "+rg_yr1_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
				//				return rg_yr1_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalRgye1, Constants.XPATH);
				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg yr 1 values entered");					
				//				return rg_yr1_version1;
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalRgNextReneval,"1" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH).sendKeys(Keys.TAB);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalExpensePercent selected: "+rgnextrenewal_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
				//				return rgnextrenewal_version1;
			}			
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalRgNextReneval, Constants.XPATH);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rgnextrenewal values entered");					
				//				return rgnextrenewal_version1;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DentalASO_cvg(WebDriver driver) throws Exception {
		try{
//			reusecomp.scrollWindow(driver, RateTabPage.vb_HI_Label, Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoParticipatsives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalasoParticipatsives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalasoParticipatsives,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalasoParticipatsives, Constants.XPATH).sendKeys(Keys.TAB);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoParticipatsives, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
				//				return eligiblelives_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalasoParticipatsives, Constants.XPATH);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoParticipatsives, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
				//				return eligiblelives_version1;
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoquotedFee, Constants.XPATH, "value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalasoquotedFee, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.dentalasoquotedFee,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalasoquotedFee, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoquotedFee, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalasoquotedPremium selected: "+quotedpremium_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
				//				return quotedpremium_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalasoquotedFee, Constants.XPATH);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoquotedFee, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
				ExtentReport.Test.log(Status.INFO,"Element quotedpremium1 selected: "+quotedpremium_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoquotedPremium values entered");					
				//				return quotedpremium_version1;
			}


			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoFullFee, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalasoFullFee, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.dentalasoFullFee,"568" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalasoFullFee, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoFullFee, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalquotedmargin selected: "+quotedmargin_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
				//				return quotedmargin_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalasoFullFee, Constants.XPATH);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoFullFee, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values entered");					
				//				return quotedmargin_version1;
			}
			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalasoRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalasoRgye1,"4" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalasoRgye1, Constants.XPATH).sendKeys(Keys.TAB);
				String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoRgye1, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalasoExpensePercent selected: "+rg_yr1_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
				//				return rg_yr1_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalasoRgye1, Constants.XPATH);
				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoRgye1, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg yr 1 values entered");					
				//				return rg_yr1_version1;
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoRgnextrenewal, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dentalasoRgnextrenewal, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dentalasoRgnextrenewal,"1" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dentalasoRgnextrenewal, Constants.XPATH).sendKeys(Keys.TAB);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoRgnextrenewal, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalExpensePercent selected: "+rgnextrenewal_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
				//				return rgnextrenewal_version1;
			}			
			else{
				reusecomp.click(driver,  RateTabPage_sk.dentalasoRgnextrenewal, Constants.XPATH);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalasoRgnextrenewal, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rgnextrenewal values entered");					
				//				return rgnextrenewal_version1;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	Padd all values
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_Padd_cvg(WebDriver driver) throws Exception {
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.paddEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.paddEligibleLives,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.paddEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddEligibleLives, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
				//				return eligiblelives_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.paddEligibleLives, Constants.XPATH);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddEligibleLives, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
				//				return eligiblelives_version1;
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddquotedPremium, Constants.XPATH, "value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.paddquotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.paddquotedPremium,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.paddquotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddquotedPremium, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalquotedPremium selected: "+quotedpremium_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
				//				return quotedpremium_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.paddquotedPremium, Constants.XPATH);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddquotedPremium, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
				ExtentReport.Test.log(Status.INFO,"Element quotedpremium1 selected: "+quotedpremium_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "paddquotedPremium values entered");					
				//				return quotedpremium_version1;
			}


			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddquotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.paddquotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.paddquotedMargin,"568" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.paddquotedMargin, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddquotedMargin, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element paddquotedMargin selected: "+quotedmargin_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
				//				return quotedmargin_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.paddquotedMargin, Constants.XPATH);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddquotedMargin, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values entered");					
				//				return quotedmargin_version1;
			}

			String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.paddExpesePercent, Constants.XPATH,"value");
			System.out.println(expenseperc);
			if(expenseperc.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.paddExpesePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.paddExpesePercent,"23" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.paddExpesePercent, Constants.XPATH).sendKeys(Keys.TAB);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddExpesePercent, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element paddExpesePercent selected: "+expenseperc_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
				//				return expenseperc_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.paddExpesePercent, Constants.XPATH);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddExpesePercent, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+expenseperc_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version1 values entered");					
				//				return expenseperc_version1;
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.paddRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.paddRgye1,"4" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.paddRgye1, Constants.XPATH).sendKeys(Keys.TAB);
				String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddRgye1, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element paddRgye1 selected: "+rg_yr1_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
				//				return rg_yr1_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.paddRgye1, Constants.XPATH);
				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.paddRgye1, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg yr 1 values entered");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
				//				return rg_yr1_version1;
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.paddRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.paddRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.paddRgNextReneval,"1" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.paddRgNextReneval, Constants.XPATH).sendKeys(Keys.TAB);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddRgNextReneval, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element paddRgNextReneval selected: "+rgnextrenewal_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
				//				return rgnextrenewal_version1;
			}			
			else{
				reusecomp.click(driver,  RateTabPage_sk.paddRgNextReneval, Constants.XPATH);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.paddRgNextReneval, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rgnextrenewal values entered");					
				//				return rgnextrenewal_version1;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	SupplementalLife all values
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_SupplementalLife_cvg(WebDriver driver) throws Exception {
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.supplementallifeEligibleLives,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.supplementallifeEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeEligibleLives, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
				//				return eligiblelives_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeEligibleLives, Constants.XPATH);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeEligibleLives, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
				//				return eligiblelives_version1;
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifequotedPremium, Constants.XPATH, "value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.supplementallifequotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.supplementallifequotedPremium,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.supplementallifequotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifequotedPremium, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalquotedPremium selected: "+quotedpremium_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
				//				return quotedpremium_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.supplementallifequotedPremium, Constants.XPATH);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifequotedPremium, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
				ExtentReport.Test.log(Status.INFO,"Element quotedpremium1 selected: "+quotedpremium_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "supplementallifequotedPremium values entered");					
				//				return quotedpremium_version1;
			}


			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifequotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.supplementallifequotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.supplementallifequotedMargin,"568" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.supplementallifequotedMargin, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifequotedMargin, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element supplementallifequotedMargin selected: "+quotedmargin_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
				//				return quotedmargin_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.supplementallifequotedMargin, Constants.XPATH);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifequotedMargin, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values entered");					
				//				return quotedmargin_version1;
			}

			String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeExpesePercent, Constants.XPATH,"value");
			System.out.println(expenseperc);
			if(expenseperc.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeExpesePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.supplementallifeExpesePercent,"23" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.supplementallifeExpesePercent, Constants.XPATH).sendKeys(Keys.TAB);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeExpesePercent, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element supplementallifeExpesePercent selected: "+expenseperc_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
				//				return expenseperc_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeExpesePercent, Constants.XPATH);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeExpesePercent, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+expenseperc_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version1 values entered");					
				//				return expenseperc_version1;
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.supplementallifeRgye1,"4" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.supplementallifeRgye1, Constants.XPATH).sendKeys(Keys.TAB);
				String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeRgye1, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element supplementallifeRgye1 selected: "+rg_yr1_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
				//				return rg_yr1_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeRgye1, Constants.XPATH);
				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeRgye1, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "supplementallifeRgye1 values entered");					
				//				return rg_yr1_version1;
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.supplementallifeRgNextReneval,"1" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.supplementallifeRgNextReneval, Constants.XPATH).sendKeys(Keys.TAB);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeRgNextReneval, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element supplementallifeRgNextReneval selected: "+rgnextrenewal_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
				//				return rgnextrenewal_version1;
			}			
			else{
				reusecomp.click(driver,  RateTabPage_sk.supplementallifeRgNextReneval, Constants.XPATH);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.supplementallifeRgNextReneval, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rgnextrenewal values entered");					
				//				return rgnextrenewal_version1;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}//	Basic Life all values
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DependentLife_cvg(WebDriver driver) throws Exception {
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dependentlifeEligibleLives,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dependentlifeEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeEligibleLives, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
				//				return eligiblelives_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeEligibleLives, Constants.XPATH);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeEligibleLives, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
				//				return eligiblelives_version1;
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifequotedPremium, Constants.XPATH, "value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dependentlifequotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.dependentlifequotedPremium,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dependentlifequotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifequotedPremium, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dependentlifequotedPremium selected: "+quotedpremium_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
				//				return quotedpremium_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dependentlifequotedPremium, Constants.XPATH);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifequotedPremium, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
				ExtentReport.Test.log(Status.INFO,"Element quotedpremium1 selected: "+quotedpremium_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dependentlifequotedPremium values entered");					
				//				return quotedpremium_version1;
			}


			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifequotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dependentlifequotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.dependentlifequotedMargin,"568" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dependentlifequotedMargin, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifequotedMargin, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dependentlifequotedMargin selected: "+quotedmargin_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
				//				return quotedmargin_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dependentlifequotedMargin, Constants.XPATH);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifequotedMargin, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values entered");					
				//				return quotedmargin_version1;
			}

			String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeExpesePercent, Constants.XPATH,"value");
			System.out.println(expenseperc);
			if(expenseperc.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeExpesePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dependentlifeExpesePercent,"23" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dependentlifeExpesePercent, Constants.XPATH).sendKeys(Keys.TAB);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeExpesePercent, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element ExpensePercent selected: "+expenseperc_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
				//				return expenseperc_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeExpesePercent, Constants.XPATH);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeExpesePercent, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+expenseperc_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version1 values entered");					
				//				return expenseperc_version1;
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dependentlifeRgye1,"4" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dependentlifeRgye1, Constants.XPATH).sendKeys(Keys.TAB);
				String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeRgye1, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dependentlifeRgye1 selected: "+rg_yr1_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
				//				return rg_yr1_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeRgye1, Constants.XPATH);
				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeRgye1, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dependentlifeRgye1 values entered");					
				//				return rg_yr1_version1;
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dependentlifeRgNextReneval,"1" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.dependentlifeRgNextReneval, Constants.XPATH).sendKeys(Keys.TAB);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeRgNextReneval, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dependentlifeRgNextReneval selected: "+rgnextrenewal_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
				//				return rgnextrenewal_version1;
			}			
			else{
				reusecomp.click(driver,  RateTabPage_sk.dependentlifeRgNextReneval, Constants.XPATH);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dependentlifeRgNextReneval, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rgnextrenewal values entered");					
				//				return rgnextrenewal_version1;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	Basic Life all values
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_BasicLife_cvg(WebDriver driver) throws Exception {
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.basiclifeEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.basiclifeEligibleLives,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.basiclifeEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeEligibleLives, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
				//				return eligiblelives_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.basiclifeEligibleLives, Constants.XPATH);
				String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeEligibleLives, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
				//				return eligiblelives_version1;
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifequotedPremium, Constants.XPATH, "value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.basiclifequotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.basiclifequotedPremium,"1234" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.basiclifequotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifequotedPremium, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element dentalquotedPremium selected: "+quotedpremium_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
				//				return quotedpremium_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.basiclifequotedPremium, Constants.XPATH);
				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifequotedPremium, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
				ExtentReport.Test.log(Status.INFO,"Element quotedpremium1 selected: "+quotedpremium_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "basiclifequotedPremium values entered");					
				//				return quotedpremium_version1;
			}


			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifequotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.basiclifequotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.basiclifequotedMargin,"568" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.basiclifequotedMargin, Constants.XPATH).sendKeys(Keys.TAB);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifequotedMargin, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element basiclifequotedMargin selected: "+quotedmargin_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
				//				return quotedmargin_version1;

			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.basiclifequotedMargin, Constants.XPATH);
				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifequotedMargin, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values entered");					
				//				return quotedmargin_version1;
			}

			String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeExpesePercent, Constants.XPATH,"value");
			System.out.println(expenseperc);
			if(expenseperc.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.basiclifeExpesePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.basiclifeExpesePercent,"23" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.basiclifeExpesePercent, Constants.XPATH).sendKeys(Keys.TAB);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeExpesePercent, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element ExpensePercent selected: "+expenseperc_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
				//				return expenseperc_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.basiclifeExpesePercent, Constants.XPATH);
				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeExpesePercent, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+expenseperc_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version1 values entered");					
				//				return expenseperc_version1;
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.basiclifeRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.basiclifeRgye1,"4" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.basiclifeRgye1, Constants.XPATH).sendKeys(Keys.TAB);
				String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeRgye1, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element basiclifeRgye1 selected: "+rg_yr1_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
				//				return rg_yr1_version1;
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.basiclifeRgye1, Constants.XPATH);
				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeRgye1, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "basiclifeRgye1 values entered");					
				//				return rg_yr1_version1;
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.basiclifeRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.basiclifeRgNextReneval,"1" , Constants.XPATH);
				reusecomp.getElement(driver, RateTabPage_sk.basiclifeRgNextReneval, Constants.XPATH).sendKeys(Keys.TAB);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeRgNextReneval, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO,"Element basiclifeRgNextReneval selected: "+rgnextrenewal_version1);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
				//				return rgnextrenewal_version1;
			}			
			else{
				reusecomp.click(driver,  RateTabPage_sk.basiclifeRgNextReneval, Constants.XPATH);
				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.basiclifeRgNextReneval, Constants.XPATH,"value");
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
				reusecomp.sleep(200);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rgnextrenewal values entered");					
				//				return rgnextrenewal_version1;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	total row quoted premium ver 1
	public String getvalue_for_toatlrowquotedpremium_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalquotedpreium , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalquotedpreium, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"total row quotedpreium_version1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row quotedpreium_version1 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
//	total row irr icon disappear ver 1
	public String getvalue_for_totalrowirr_icondisappear_ver1(WebDriver driver)throws Exception{
//		reusecomp.scrollWindownormal(driver, RateTabPage.totalirrafter);
		reusecomp.click(driver, RateTabPage_sk.totalirrafter, Constants.XPATH);
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)", "");
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(400,0)", "");
		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.totalirrafter, Constants.XPATH));
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalirr, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"total row irr_version1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr_version1 value is more than 15% and alert icon is disappeared");
	reusecomp.sleep(300);
		return DisplayedActualValue;
	}
//	total row irr red icon displayed ver 1
	public String getvalue_for_totalrowirr_rediconDisplay_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirrafter, Constants.XPATH);
		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.totalirr, Constants.XPATH));
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalirr, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"total row irr_version1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr_version1 value is less than 15% and red icon displayed");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	
//	total row irr icon remain blue ver 1
	public String getvalue_for_totalrowirr_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirrafter);
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(-100,0)", "");
		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.totalirrafter, Constants.XPATH));
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalirr, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"total row irr_version1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr_version1 value is less than 15% and alert icon remains blue");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	
//	total row irr redicon popup msg opened view ver 1
	public void getvalue_for_totalrowirrredicon_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirrredicon, Constants.XPATH);
//		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr redicon alert msg view_version1");
	reusecomp.sleep(300);
	}
//	total row irr redicon ver 1
	public void getvalue_for_totalrowirrblueicon_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirrblueicon, Constants.XPATH);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr blueicon alert msg's are retained view_version1");
	reusecomp.sleep(300);
	}
//	total row IRR red icon dropdown
	public void getvalue_for_totalrowirrredicon_dropdown_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirrredicondropdown, Constants.XPATH);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr redicon alert msg view_version1");
	reusecomp.sleep(300);
	}
//	total row irr redicon dropdown selection ver 1
	public void getvalue_for_totalrowirrredicon_dropdown_selection_ver1(WebDriver driver)throws Exception{
		reusecomp.selectDropDownByIndex(driver, RateTabPage_sk.totalirrredicondropdown,3, Constants.XPATH);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr redicon alert department selection view_version1");
	reusecomp.sleep(300);
	}
//	total row irr redicon ver 1
	public void getvalue_for_totalrowirrredicon_commandvalue_ver1(WebDriver driver)throws Exception{
		WebElement maxlentgh = reusecomp.getElement(driver, RateTabPage_sk.totalirrredicon_commant, Constants.XPATH);
		String length = maxlentgh.getAttribute("maxlength");
		 reusecomp.input(driver, RateTabPage_sk.totalirrredicon_commant,"76tr(*&", Constants.XPATH);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr redicon alert command msg view_version1");
		reusecomp.sleep(300);
		ExtentReport.Test.log(Status.INFO,"total row irr command msg maxlegth_version1 "+length);
System.out.println(length);
	}
//	totall irr red icon alert close
	public void getvalue_for_totalrowirrredicon_alert_close_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirrredalertclose, Constants.XPATH);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)", "");
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr redicon alert msg closed and red icon changed into blue colour");
	reusecomp.sleep(300);
	}
//	total row irr redicon changed and retain into blue icon ver 1
	public void getvalue_for_totalrowirr_blueicon_recalculate_ver1(WebDriver driver)throws Exception{
		reusecomp.input(driver, RateTabPage_sk.vaddquotedMargin,"-99.5", Constants.XPATH);
//		reusecomp.input(driver, RateTabPage.vaddquotedMargin,"-40", Constants.XPATH);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "value changed in expense % field");
		reusecomp.sleep(300);
	}
//	total row irr redicon changed and retain into blue icon ver 1
	public void getvalue_for_totalrowirr_blueiconDisappear_recalculate_ver1(WebDriver driver)throws Exception{
		reusecomp.input(driver, RateTabPage_sk.vaddquotedMargin,"-98.00", Constants.XPATH);
//		reusecomp.input(driver, RateTabPage.vaddquotedMargin,"95", Constants.XPATH);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "value changed in quotedmargin field");
		reusecomp.sleep(300);
	}
//	total row vif ver 1
	public String getvalue_for_totalrowvif_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalvif , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalvif, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO, "total row vif_version1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row vif_version1 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String getvalue_for_targetmargin_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalTargetMargin , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalTargetMargin, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"Target Margin ver1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "Target Margin ver1 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String getvalue_for_uwmanagerfloormargin_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalUWmanagerMargin, Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalUWmanagerMargin, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"UW manager floor margin ver1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor margin ver1 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String getvalue_for_bundledfloormargin_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalBundledfloorMargin , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalBundledfloorMargin, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"Bundled floor margin ver1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled floor margin ver1 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
//	total row quoted premium ver 2
	public String getvalue_for_toatlrowquotedpremium_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalquotedpreium_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalquotedpreium_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"total row quotedpreium_version2 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row quotedpreium_version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
//	total row irr ver 2
	public String getvalue_for_totalrowirr_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalirr_version2, Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalirr_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"total row irr_version2 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row irr_version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
//	total row vif ver 2
	public String getvalue_for_totalrowvif_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.totalvif_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.totalvif_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO, "total row vif_version2 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "total row vif_version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String getvalue_for_targetmargin_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalTargetMargin_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalTargetMargin_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"Target Margin ver2 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "Target Margin ver2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String getvalue_for_uwmanagerfloormargin_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalUWmanagerMargin_version2, Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalUWmanagerMargin_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"UW manager floor margin ver2 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor margin ver2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String getvalue_for_bundledfloormargin_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalBundledfloorMargin_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalBundledfloorMargin_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO, "Bundled floor margin ver2 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled floor margin ver2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	public String Update_the_values_eligibleLives_for_DentalPPO_cvg(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalEligibleLives, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalEligibleLives,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"eligible live values populated: "+eligiblelives_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values populated");
			reusecomp.sleep(300);
			return eligiblelives_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalEligibleLives, Constants.XPATH);
			String eligiblelives_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version1);
			ExtentReport.Test.log(Status.INFO,"eligible live values populated: "+eligiblelives_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values populated");					
			return eligiblelives_version1;
		}
	}
	public String Update_the_values_quotedPremium_for_DentalPPO_cvg(WebDriver driver) throws Exception {

		String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH, "value");
		System.out.println(quotedpremium1);

		if(quotedpremium1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedPremium, Constants.XPATH);
			reusecomp.sleep(200);						
			reusecomp.input(driver, RateTabPage_sk.dentalquotedPremium,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
			String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"quoted premium values populated: "+quotedpremium_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values populated");
			reusecomp.sleep(300);
			return quotedpremium_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedPremium, Constants.XPATH);
			String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
			ExtentReport.Test.log(Status.INFO,"quotedPremium values populated: "+quotedpremium_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dental quotedPremium values populated");					
			return quotedpremium_version1;
		}
	}
	public String Update_the_values_quotedMargin_for_DentalPPO_cvg(WebDriver driver) throws Exception {

		String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH,"value");
		System.out.println(quotedmargin1);
		if(quotedmargin1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedMargin, Constants.XPATH);
			reusecomp.sleep(200);									
			reusecomp.input(driver, RateTabPage_sk.dentalquotedMargin,"568" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH).sendKeys(Keys.TAB);
			String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"quoted margin values populated: "+quotedmargin_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values populated");
			reusecomp.sleep(300);
			return quotedmargin_version1;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedMargin, Constants.XPATH);
			String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
			ExtentReport.Test.log(Status.INFO,"quoted margin values populated: "+quotedmargin_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version1 values populated");					
			return quotedmargin_version1;
		}
	}
	public String Update_the_values_expensePercent_for_DentalPPO_cvg(WebDriver driver) throws Exception {

		String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH,"value");
		System.out.println(expenseperc);
		if(expenseperc.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalExpensePercent, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalExpensePercent,"23" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH).sendKeys(Keys.TAB);
			String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"expensepercent values populated: "+expenseperc_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values populated");
			reusecomp.sleep(300);
			return expenseperc_version1;
		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalExpensePercent, Constants.XPATH);
			String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
			ExtentReport.Test.log(Status.INFO,"expensepercent values populated: "+expenseperc_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version1 values populated");					
			return expenseperc_version1;
		}
	}
	public String Update_the_values_rgyrone_for_DentalPPO_cvg(WebDriver driver) throws Exception {
		String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH,"value");
		System.out.println(rg_yr1);
		if(rg_yr1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalRgye1, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalRgye1,"4" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH).sendKeys(Keys.TAB);
			String rg_yr1_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"rg yr1 values populated "+rg_yr1_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values populated");
			reusecomp.sleep(300);
			return rg_yr1_version1;
		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalRgye1, Constants.XPATH);
			String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
			ExtentReport.Test.log(Status.INFO,"rg yr1 values populated: "+rg_yr1_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values populated");					
			return rg_yr1_version1;
		}
	}
	public String Update_the_values_nextreneval_for_DentalPPO_cvg(WebDriver driver) throws Exception {

		String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH,"value");
		System.out.println(rgnextrenewal);
		if(rgnextrenewal.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalRgNextReneval, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalRgNextReneval,"1" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH).sendKeys(Keys.TAB);
			String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"Rg next renewal values populated: "+rgnextrenewal_version1);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values populated");
			reusecomp.sleep(300);
			return rgnextrenewal_version1;
		}			
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalRgNextReneval, Constants.XPATH);
			String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
			ExtentReport.Test.log(Status.INFO,"Rg next renewal values populated: "+rgnextrenewal_version1);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values populated");					
			return rgnextrenewal_version1;
		}
	}
//	irr ver1
	public String getvalue_for_riFields_irr_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalirr , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalirr, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"irr value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "irr value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	vif ver1
	public String getvalue_for_riFields_vif_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalvif , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalvif, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"vif values populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "vif values populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI1 ver1
	public String getvalue_for_riFields_ri1_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi1 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi1, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI1 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	RI2 ver1
	public String getvalue_for_riFields_ri2_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI2 values populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI2 values populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI3 ver1
	public String getvalue_for_riFields_ri3_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi3  , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi3, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI3 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI3 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	RI4 ver1
	public String getvalue_for_riFields_ri4_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi4 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi4, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI4 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI4 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	RI5 ver1
	public String getvalue_for_riFields_ri5_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi5 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi5, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI5 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI5 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
//	RI6 ver1
	public String getvalue_for_riFields_ri6_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi6 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi6, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI6 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI6 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI7 ver1
	public String getvalue_for_riFields_ri7_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi7 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi7, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI7 values populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI7 values populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI8 ver1
	public String getvalue_for_riFields_ri8_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi8  , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi8, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI8 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI8 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI9 ver1
	public String getvalue_for_riFields_ri9_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi9 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi9, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI9 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI9 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI10 ver1
	public String getvalue_for_riFields_ri10_ver1(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi10 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi10, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI10 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI10 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
	//	RI fields version2
//	irr ver2
	public String getvalue_for_riFields_irr_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalirr_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalirr_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"irr value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "irr version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	vif ver1
	public String getvalue_for_riFields_vif_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalvif_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalvif_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"vif values populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "vif version2 values populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI1 ver1
	public String getvalue_for_riFields_ri1_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi1_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi1_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI1 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI1 version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	RI2 ver1
	public String getvalue_for_riFields_ri2_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi2_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi2_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI2 values populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI2 version2 values populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}	
//	RI3 ver1
	public String getvalue_for_riFields_ri3_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi3_version2  , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi3_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI3 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI3 version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
//	RI4 ver1
	public String getvalue_for_riFields_ri4_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi4_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi4_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI4 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI4 version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		 
//	RI5 ver1
	public String getvalue_for_riFields_ri5_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi5_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi5_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI5 value populated: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI5 version2 value populated");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}
	
	public String getvalue_for_riFields_ri6_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi6_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi6_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI6 value populated_ver2: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI6 value populated_ver2");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
	public String getvalue_for_riFields_ri7_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi7_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi7_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI7 value populated_ver2: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI7 value populated_ver2");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
	public String getvalue_for_riFields_ri8_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi8_version2  , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi8_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI8 value populated_ver2: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI8 value populated_ver2");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
	public String getvalue_for_riFields_ri9_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi9_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi9_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI9 value populated_ver2: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "9 value populated_ver2");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
	public String getvalue_for_riFields_ri10_ver2(WebDriver driver)throws Exception{
		reusecomp.click(driver, RateTabPage_sk.dentalRi10_version2 , Constants.XPATH);
		String DisplayedActualValue = reusecomp.getText(driver, RateTabPage_sk.dentalRi10_version2, Constants.XPATH);
		ExtentReport.Test.log(Status.INFO,"RI10 value populated_ver2: "+DisplayedActualValue);
		reusecomp.logPassedStepToReportWithScreenshot(driver, "RI10 value populated_ver2");
		reusecomp.sleep(300);
		return DisplayedActualValue;
	}		
	public String Update_the_values_eligibleLives_for_DentalPPO_cvg_ver2(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
		String eligiblelives2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives_version2, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives2);

		if(eligiblelives2.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalEligibleLives_version2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalEligibleLives_version2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalEligibleLives_version2, Constants.XPATH).sendKeys(Keys.TAB);
			String eligiblelives_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives_version2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"eligible live version2 values entered: "+eligiblelives_version2);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live version2 values entered");
			reusecomp.sleep(300);
			return eligiblelives_version2;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalEligibleLives_version2, Constants.XPATH);
			String eligiblelives_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives_version2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version2);
			ExtentReport.Test.log(Status.INFO,"eligible live version2 values entered: "+eligiblelives_version2);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live version2 values entered");					
			return eligiblelives_version2;
		}
	}
	public String Update_the_values_quotedPremium_for_DentalPPO_cvg_ver2(WebDriver driver) throws Exception {

		String quotedpremium2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium_version2, Constants.XPATH, "value");
		System.out.println(quotedpremium2);

		if(quotedpremium2.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedPremium_version2, Constants.XPATH);
			reusecomp.sleep(200);						
			reusecomp.input(driver, RateTabPage_sk.dentalquotedPremium_version2,"1234" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalquotedPremium_version2, Constants.XPATH).sendKeys(Keys.TAB);
			String quotedpremium_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium_version2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"quoted premium version2 values populated: "+quotedpremium_version2);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium version2 values populated");
			reusecomp.sleep(300);
			return quotedpremium_version2;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedPremium_version2, Constants.XPATH);
			String quotedpremium_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedPremium_version2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version2);
			ExtentReport.Test.log(Status.INFO,"quoted premium version2 values populated: "+quotedpremium_version2);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalquotedPremium version2 values populated");					
			return quotedpremium_version2;
		}
	}
	public String Update_the_values_quotedMargin_for_DentalPPO_cvg_ver2(WebDriver driver) throws Exception {

		String quotedmargin2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin_version2, Constants.XPATH,"value");
		System.out.println(quotedmargin2);
		if(quotedmargin2.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedMargin_version2, Constants.XPATH);
			reusecomp.sleep(200);									
			reusecomp.input(driver, RateTabPage_sk.dentalquotedMargin_version2,"568" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalquotedMargin_version2, Constants.XPATH).sendKeys(Keys.TAB);
			String quotedmargin_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin_version2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"quoted margin version2 values populated: "+quotedmargin_version2);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin version2 values populated");
			reusecomp.sleep(300);
			return quotedmargin_version2;

		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalquotedMargin_version2, Constants.XPATH);
			String quotedmargin_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalquotedMargin_version2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version2);
			ExtentReport.Test.log(Status.INFO,"quoted margin version2 values populated: "+quotedmargin_version2);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version2 values populated");					
			return quotedmargin_version2;
		}
	}
	public String Update_the_values_expensePercent_for_DentalPPO_cvg_ver2(WebDriver driver) throws Exception {

		String expenseperc = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent_version2, Constants.XPATH,"value");
		System.out.println(expenseperc);
		if(expenseperc.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalExpensePercent_version2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalExpensePercent_version2,"23" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalExpensePercent_version2, Constants.XPATH).sendKeys(Keys.TAB);
			String expenseperc_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent_version2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"expensepercent version2 values populated: "+expenseperc_version2);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent version2 values populated");
			reusecomp.sleep(300);
			return expenseperc_version2;
		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalExpensePercent_version2, Constants.XPATH);
			String expenseperc_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalExpensePercent_version2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version2);
			ExtentReport.Test.log(Status.INFO,"expensepercent version2 values populated: "+expenseperc_version2);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version2 values populated");					
			return expenseperc_version2;
		}
	}
	public String Update_the_values_rgyrone_for_DentalPPO_cvg_ver2(WebDriver driver) throws Exception {
		String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1_version2, Constants.XPATH,"value");
		System.out.println(rg_yr1);
		if(rg_yr1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalRgye1_version2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalRgye1_version2,"4" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalRgye1_version2, Constants.XPATH).sendKeys(Keys.TAB);
			String rg_yr1_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1_version2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"rg yr1 version2 values populated: "+rg_yr1_version2);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 version2 values populated");
			reusecomp.sleep(300);
			return rg_yr1_version2;
		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalRgye1_version2, Constants.XPATH);
			String rg_yr1_version2 =reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgye1_version2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version2);
			ExtentReport.Test.log(Status.INFO,"rg yr1 version2 values populated: "+rg_yr1_version2);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 version2 values populated");					
			return rg_yr1_version2;
		}
	}
	public String Update_the_values_nextreneval_for_DentalPPO_cvg_ver2(WebDriver driver) throws Exception {

		String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval_version2, Constants.XPATH,"value");
		System.out.println(rgnextrenewal);
		if(rgnextrenewal.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.dentalRgNextReneval_version2, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.dentalRgNextReneval_version2,"1" , Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.dentalRgNextReneval_version2, Constants.XPATH).sendKeys(Keys.TAB);
			String rgnextrenewal_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval_version2, Constants.XPATH,"value");
			ExtentReport.Test.log(Status.INFO,"Rg next renewal version2 values populated: "+rgnextrenewal_version2);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal version2 values populated");
			reusecomp.sleep(300);
			return rgnextrenewal_version2;
		}			
		else{
			reusecomp.click(driver,  RateTabPage_sk.dentalRgNextReneval_version2, Constants.XPATH);
			String rgnextrenewal_version2 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalRgNextReneval_version2, Constants.XPATH,"value");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version2);
			ExtentReport.Test.log(Status.INFO,"Rg next renewal version2 values populated: "+rgnextrenewal_version2);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal version2 values populated");					
			return rgnextrenewal_version2;
		}
	}
	//	DentalPPO all values version2
	//	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DentalPPO_cvg_version2(WebDriver driver) throws Exception {
	//		try {
	//			reusecomp.scrollWindow(driver, RateTabPage.vb_HI_Label_version2, Constants.XPATH);
	//			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
	//
	//			String eligiblelives = reusecomp.getAttribute(driver, RateTabPage.dentalEligibleLives_version2, Constants.XPATH,"value");
	//			System.out.println("value: "+eligiblelives);
	//
	//			if(eligiblelives.isEmpty()){
	//				reusecomp.click(driver,  RateTabPage.dentalEligibleLives_version2, Constants.XPATH);
	//				reusecomp.sleep(200);
	//				reusecomp.input(driver, RateTabPage.dentalEligibleLives,"1234" , Constants.XPATH);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
	//				reusecomp.sleep(300);
	//			}
	//			else{
	//				reusecomp.click(driver,  RateTabPage.dentalEligibleLives, Constants.XPATH);
	//				String eligiblelives_version2 = reusecomp.getAttribute(driver, RateTabPage.dentalEligibleLives, Constants.XPATH,"value");
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+eligiblelives_version2);
	//				ExtentReport.Test.log(Status.INFO,"Element selected: "+eligiblelives_version2);
	//				reusecomp.sleep(200);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
	//			}
	//
	//			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage.dentalquotedPremium, Constants.XPATH,"value");
	//			System.out.println(quotedpremium1);
	//
	//			if(quotedpremium1.isEmpty()){
	//				reusecomp.click(driver,  RateTabPage.dentalquotedPremium, Constants.XPATH);
	//				reusecomp.sleep(200);						
	//				reusecomp.input(driver, RateTabPage.dentalquotedPremium,"1234" , Constants.XPATH);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
	//				reusecomp.sleep(300);
	//			}
	//			else{
	//				reusecomp.click(driver,  RateTabPage.dentalquotedPremium, Constants.XPATH);
	//				String quotedpremium_version1 = reusecomp.getAttribute(driver, RateTabPage.dentalquotedPremium, Constants.XPATH,"value");
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedpremium_version1);
	//				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedpremium_version1);
	//				reusecomp.sleep(200);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");					
	//			}
	//
	//
	//			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage.dentalquotedMargin, Constants.XPATH,"value");
	//			System.out.println(quotedmargin1);
	//			if(quotedmargin1.isEmpty()){
	//				reusecomp.click(driver,  RateTabPage.dentalquotedMargin, Constants.XPATH);
	//				reusecomp.sleep(200);									
	//				reusecomp.input(driver, RateTabPage.dentalquotedMargin,"568" , Constants.XPATH);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
	//				reusecomp.sleep(300);
	//			}
	//			else{
	//				reusecomp.click(driver,  RateTabPage.dentalquotedMargin, Constants.XPATH);
	//				String quotedmargin_version1 = reusecomp.getAttribute(driver, RateTabPage.dentalquotedMargin, Constants.XPATH,"value");
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+quotedmargin_version1);
	//				ExtentReport.Test.log(Status.INFO,"Element selected: "+quotedmargin_version1);
	//				reusecomp.sleep(200);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "quotedmargin_version2 values entered");					
	//			}
	//
	//			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage.dentalExpensePercent, Constants.XPATH,"value");
	//			System.out.println(expenseperc1);
	//			if(expenseperc1.isEmpty()){
	//				reusecomp.click(driver,  RateTabPage.dentalExpensePercent, Constants.XPATH);
	//				reusecomp.sleep(200);
	//				reusecomp.input(driver, RateTabPage.dentalExpensePercent,"23" , Constants.XPATH);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
	//				reusecomp.sleep(300);
	//			}
	//			else{
	//				reusecomp.click(driver,  RateTabPage.dentalExpensePercent, Constants.XPATH);
	//				String expenseperc_version1 = reusecomp.getAttribute(driver, RateTabPage.dentalExpensePercent, Constants.XPATH,"value");
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+expenseperc_version1);
	//				ExtentReport.Test.log(Status.INFO,"Element selected: "+expenseperc_version1);
	//				reusecomp.sleep(200);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "expenseperc_version2 values entered");					
	//			}
	//
	//			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage.dentalRgye1, Constants.XPATH,"value");
	//			System.out.println(rg_yr1);
	//			if(rg_yr1.isEmpty()){
	//				reusecomp.click(driver,  RateTabPage.dentalRgye1, Constants.XPATH);
	//				reusecomp.sleep(200);
	//				reusecomp.input(driver, RateTabPage.dentalRgye1,"4" , Constants.XPATH);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
	//				reusecomp.sleep(300);
	//			}
	//			else{
	//				reusecomp.click(driver,  RateTabPage.dentalRgye1, Constants.XPATH);
	//				String rg_yr1_version1 =reusecomp.getAttribute(driver, RateTabPage.dentalRgye1, Constants.XPATH,"value");
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rg_yr1_version1);
	//				ExtentReport.Test.log(Status.INFO,"Element selected: "+rg_yr1_version1);
	//				reusecomp.sleep(200);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");					
	//			}
	//
	//			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage.dentalRgNextReneval, Constants.XPATH,"value");
	//			System.out.println(rgnextrenewal);
	//			if(rgnextrenewal.isEmpty()){
	//				reusecomp.click(driver,  RateTabPage.dentalRgNextReneval, Constants.XPATH);
	//				reusecomp.sleep(200);
	//				reusecomp.input(driver, RateTabPage.dentalRgNextReneval,"1" , Constants.XPATH);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
	//				reusecomp.sleep(300);
	//			}			
	//			else{
	//				reusecomp.click(driver,  RateTabPage.dentalRgNextReneval, Constants.XPATH);
	//				String rgnextrenewal_version1 = reusecomp.getAttribute(driver, RateTabPage.dentalRgNextReneval, Constants.XPATH,"value");
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected field: "+rgnextrenewal_version1);
	//				ExtentReport.Test.log(Status.INFO,"Element selected: "+rgnextrenewal_version1);
	//				reusecomp.sleep(200);
	//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");					
	//			}
	//
	//		}
	//		catch (Exception e) {
	//			System.out.println(e.toString());
	//			reusecomp.logger.warning(e.getMessage());
	//			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
	//		}
	//	}
	//	DentalPPO all values
	public void Not_AllValues_Updated_for_DentalPPO_cvg(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dentalEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			reusecomp.clearValue(driver,  RateTabPage_sk.dentalEligibleLives, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values clear");
			reusecomp.sleep(300);



		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	Dental aso CVGS all
//	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DentalASO_cvg(WebDriver driver) throws Exception {
//		try {
//			reusecomp.scrollWindow(driver, RateTabPage.vb_HI_Label, Constants.XPATH);
//			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
//
//			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage.dentalasoParticipatsives, Constants.XPATH,"value");
//			System.out.println("value: "+eligiblelives1);
//
//			if(!eligiblelives1.isEmpty()){
//				reusecomp.click(driver,  RateTabPage.dentalasoParticipatsives, Constants.XPATH);
//				reusecomp.sleep(200);
//				reusecomp.input(driver, RateTabPage.dentalasoParticipatsives,"1234" , Constants.XPATH);
//				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoParticipatsives values entered");
//				reusecomp.sleep(300);
//			}
//			else{
//				reusecomp.click(driver,  RateTabPage.dentalasoParticipatsives, Constants.XPATH);
//				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoParticipatsives values entered");					
//			}
//
//			String dentalasoquotedFee = reusecomp.getAttribute(driver, RateTabPage.dentalasoquotedFee, Constants.XPATH,"value");
//			System.out.println(dentalasoquotedFee);
//
//			if(dentalasoquotedFee.isEmpty()){
//				reusecomp.click(driver,  RateTabPage.dentalasoquotedFee, Constants.XPATH);
//				reusecomp.sleep(200);						
//				reusecomp.input(driver, RateTabPage.dentalasoquotedFee,"1234" , Constants.XPATH);
//				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoquotedFee values entered");
//				reusecomp.sleep(300);
//			}
//
//			String dentalasoFullFee = reusecomp.getAttribute(driver, RateTabPage.dentalasoFullFee, Constants.XPATH,"value");
//			System.out.println(dentalasoFullFee);
//			if(dentalasoFullFee.isEmpty()){
//				reusecomp.click(driver,  RateTabPage.dentalasoFullFee, Constants.XPATH);
//				reusecomp.sleep(200);									
//				reusecomp.input(driver, RateTabPage.dentalasoFullFee,"568" , Constants.XPATH);
//				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoFullFee values entered");
//				reusecomp.sleep(300);
//			}
//
//			String dentalasoRgye1 = reusecomp.getAttribute(driver, RateTabPage.dentalasoRgye1, Constants.XPATH,"value");
//			System.out.println(dentalasoRgye1);
//			if(dentalasoRgye1.isEmpty()){
//				reusecomp.click(driver,  RateTabPage.dentalasoRgye1, Constants.XPATH);
//				reusecomp.sleep(200);
//				reusecomp.input(driver, RateTabPage.dentalasoRgye1,"23" , Constants.XPATH);
//				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoRgye1 values entered");
//				reusecomp.sleep(300);
//			}
//
//			String dentalasoRgnextrenewal = reusecomp.getAttribute(driver, RateTabPage.dentalasoRgnextrenewal, Constants.XPATH,"value");
//			System.out.println(dentalasoRgnextrenewal);
//			if(dentalasoRgnextrenewal.isEmpty()){
//				reusecomp.click(driver,  RateTabPage.dentalasoRgnextrenewal, Constants.XPATH);
//				reusecomp.sleep(200);
//				reusecomp.input(driver, RateTabPage.dentalasoRgnextrenewal,"4" , Constants.XPATH);
//				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalasoRgnextrenewal values entered");
//				reusecomp.sleep(300);
//			}
//
//		}
//		catch (Exception e) {
//			System.out.println(e.toString());
//			reusecomp.logger.warning(e.getMessage());
//			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
//		}
//	}
//	DHMO CVGS
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DHMO_cvg(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(!eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dhmoEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoquotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoquotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.dhmoquotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoquotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoquotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.dhmoquotedMargin,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoExpensePercent, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoExpensePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoExpensePercent,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoRgye1,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoRgNextReneval,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	dhmo versiob2
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_DHMO_cvg_version2(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoEligibleLives_version2, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoEligibleLives_version2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoEligibleLives_version2,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live_version2 values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.dhmoEligibleLives_version2, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live version2 values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoquotedPremium_version2, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoquotedPremium_version2, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.dhmoquotedPremium_version2,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium version2 values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoquotedMargin_version2, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoquotedMargin_version2, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.dhmoquotedMargin_version2,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin version2 values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoExpensePercent_version2, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoExpensePercent_version2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoExpensePercent_version2,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoRgye1_version2, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoRgye1_version2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoRgye1_version2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 version2 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.dhmoRgNextReneval_version2, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.dhmoRgNextReneval_version2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.dhmoRgNextReneval_version2,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal version2 values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		LTD cvgs
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_LTD_cvg(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//					reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.ltdEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.ltdEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.ltdEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.ltdEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.ltdquotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.ltdquotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.ltdquotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.ltdquotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.ltdquotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.ltdquotedMargin,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.ltdExpesePercent, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.ltdExpesePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.ltdExpesePercent,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.ltdRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.ltdRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.ltdRgye1,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.ltdRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.ltdRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.ltdRgNextReneval,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
// vadd cvgs
public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_Vadd_cvg(WebDriver driver) throws Exception {
	try {
		reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
		//					reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

		String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vaddEligibleLives, Constants.XPATH,"value");
		System.out.println("value: "+eligiblelives1);

		if(eligiblelives1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.vaddEligibleLives, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.vaddEligibleLives,"1234" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
			reusecomp.sleep(300);
		}
		else{
			reusecomp.click(driver,  RateTabPage_sk.vaddEligibleLives, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
		}

		String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vaddquotedPremium, Constants.XPATH,"value");
		System.out.println(quotedpremium1);

		if(quotedpremium1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.vaddquotedPremium, Constants.XPATH);
			reusecomp.sleep(200);						
			reusecomp.input(driver, RateTabPage_sk.vaddquotedPremium,"326" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
			reusecomp.sleep(300);
		}

		String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vaddquotedMargin, Constants.XPATH,"value");
		System.out.println(quotedmargin1);
		if(quotedmargin1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.vaddquotedMargin, Constants.XPATH);
			reusecomp.sleep(200);									
//			reusecomp.input(driver, RateTabPage.vaddquotedMargin,"-73" , Constants.XPATH);
			reusecomp.input(driver, RateTabPage_sk.vaddquotedMargin,"-99" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
			reusecomp.sleep(300);
		}

		String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vaddExpesePercent, Constants.XPATH,"value");
		System.out.println(expenseperc1);
		if(expenseperc1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.vaddExpesePercent, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.vaddExpesePercent,"23" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
			reusecomp.sleep(300);
		}

		String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vaddRgye1, Constants.XPATH,"value");
		System.out.println(rg_yr1);
		if(rg_yr1.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.vaddRgye1, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.vaddRgye1,"4" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
			reusecomp.sleep(300);
		}

		String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vaddRgNextReneval, Constants.XPATH,"value");
		System.out.println(rgnextrenewal);
		if(rgnextrenewal.isEmpty()){
			reusecomp.click(driver,  RateTabPage_sk.vaddRgNextReneval, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.input(driver, RateTabPage_sk.vaddRgNextReneval,"1" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
			reusecomp.sleep(300);
		}			

	}
	catch (Exception e) {
		System.out.println(e.toString());
		reusecomp.logger.warning(e.getMessage());
		reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
	}
}
	//		vltd cbu
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_VLTDCBU_cvg(WebDriver driver) throws Exception {
		try {
//			reusecomp.scrollWindow(driver, RateTabPage.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
//			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vltdcbuEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vltdcbuEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vltdcbuquotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuquotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vltdcbuquotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vltdcbuquotedMargin, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuquotedMargin, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vltdcbuquotedMargin,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vltdcbuExpesePercent, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuExpesePercent, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vltdcbuExpesePercent,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vltdcbuRgye1, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuRgye1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vltdcbuRgye1,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vltdcbuRgNextReneval, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vltdcbuRgNextReneval, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vltdcbuRgNextReneval,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		VB-CIA Cvg
	public void Update_the_values_eligibleLives_quotedPremium_quotedDiscount_ComissionYr1_ComissionYr2_AdminFee_VBCIA_cvg(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vbciaEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbciaQuotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbciaQuotedDiscount,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}

			String expenseperc1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaComissionyr1, Constants.XPATH,"value");
			System.out.println(expenseperc1);
			if(expenseperc1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaComissionyr1, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaComissionyr1,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 1 values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaComissionyr2, Constants.XPATH,"value");
			System.out.println(rg_yr1);
			if(rg_yr1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaComissionyr2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaComissionyr2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "comission yr 2 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal = reusecomp.getAttribute(driver, RateTabPage_sk.vbciaAdminfee, Constants.XPATH,"value");
			System.out.println(rgnextrenewal);
			if(rgnextrenewal.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbciaAdminfee, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbciaAdminfee,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "vbciaAdminfee values entered");
				reusecomp.sleep(300);
			}			

		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_secondRow(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);

			//			reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);

			String eligiblelives2 = reusecomp.getAttribute(driver, RateTabPage_sk.eligiblelives2, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives2);

			if(eligiblelives2.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.eligiblelives2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.eligiblelives2,"12343" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}

			String quotedpremium2 = reusecomp.getAttribute(driver, RateTabPage_sk.qoutedpremium2, Constants.XPATH,"value");
			System.out.println(quotedpremium2);

			if(quotedpremium2.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.qoutedpremium2, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.qoutedpremium2,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin2 = reusecomp.getAttribute(driver, RateTabPage_sk.quotedmargin2, Constants.XPATH,"value");
			System.out.println(quotedmargin2);
			if(quotedmargin2.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.quotedmargin2, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.quotedmargin2,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin values entered");
				reusecomp.sleep(300);
			}

			String expenseperc2 = reusecomp.getAttribute(driver, RateTabPage_sk.expenseperctab2, Constants.XPATH,"value");
			System.out.println(expenseperc2);
			if(expenseperc2.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.expenseperctab2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.expenseperctab2,"23" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "expensepercent values entered");
				reusecomp.sleep(300);
			}

			String rg_yr1_2 = reusecomp.getAttribute(driver, RateTabPage_sk.rg_yr1_2, Constants.XPATH,"value");
			System.out.println(rg_yr1_2);
			if(rg_yr1_2.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.rg_yr1_2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.rg_yr1_2,"4" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr1 values entered");
				reusecomp.sleep(300);
			}

			String rgnextrenewal2 = reusecomp.getAttribute(driver, RateTabPage_sk.rgNextreneval2, Constants.XPATH,"value");
			System.out.println(rgnextrenewal2);
			if(rgnextrenewal2.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.rgNextreneval2, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.rgNextreneval2,"1" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Rg next renewal values entered");
				reusecomp.sleep(300);
			}
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void Update_the_values_eligibleLives_quotedPremium_quotedMargin_expensePercent_rgyrone_nextreneval_for_fristtRow(WebDriver driver) throws Exception {
		try {
			reusecomp.sleep(600);
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			//				reusecomp.input(driver, RateTabPage.eligiblelives2,"20" , Constants.XPATH);
			//				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values enterd");
			//				reusecomp.sleep(200);
			reusecomp.getElement(driver, RateTabPage_sk.eligiblelives, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.sleep(100);
			reusecomp.input(driver, RateTabPage_sk.qoutedpremium,"4567" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
			reusecomp.sleep(200);
			reusecomp.getElement(driver, RateTabPage_sk.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.sleep(100);
			reusecomp.input(driver, RateTabPage_sk.quotedmargin1,"345" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted margin value entered");
			reusecomp.sleep(200);
			reusecomp.getElement(driver, RateTabPage_sk.quotedmargin1, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.sleep(100);
			reusecomp.input(driver, RateTabPage_sk.expenseperctab1,"20" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Expense% value entered");
			reusecomp.sleep(200);
			reusecomp.getElement(driver, RateTabPage_sk.expenseperctab1, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.sleep(100);
			reusecomp.input(driver, RateTabPage_sk.rg_yr1,"2" , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "rg yr 1 value entered");
			reusecomp.sleep(200);
			reusecomp.getElement(driver, RateTabPage_sk.rg_yr1, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.sleep(100);			
			reusecomp.input(driver, RateTabPage_sk.rgNextreneval,"1", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "next reneval value entered");
			reusecomp.sleep(100);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void scrollupto_vbax(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver,"Margin values are displayed");
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			//				reusecomp.click(driver, RateTabPage.ri6 , Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_1_DENTALPPO(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.dentalRi1 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_DENTALPPO(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.dentalRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_DENTALPPO(WebDriver driver) throws Exception {
		try {
			reusecomp.click(driver, RateTabPage_sk.dentalRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dentalRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dentalRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dentalRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmoRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmoRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmoRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmoRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmoRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.basiclifeRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.basiclifeRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.basiclifeRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.basiclifeRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.basiclifeRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_SUPPLEMENTALLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.supplementallifeRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_SUPPLEMENTALLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.supplementallifeRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_SUPPLEMENTALLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.supplementallifeRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_SUPPLEMENTALLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.supplementallifeRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_SUPPLEMENTALLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.supplementallifeRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dependentlifeRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dependentlifeRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dependentlifeRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dependentlifeRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dependentlifeRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}


	public void validate_ri_field_6_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.ltdRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.ltdRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.ltdRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.ltdRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.ltdRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	public void validate_ri_field_6_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vltdcbuRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vltdcbuRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vltdcbuRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vltdcbuRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vltdcbuRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.paddRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.paddRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.paddRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.paddRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.paddRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_6_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.vb_AX_Label, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(200);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vaddRi6 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 6 selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_7_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri7, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vaddRi7 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 7 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_8_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri8, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vaddRi8 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 8 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_9_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri6, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vaddRi9 , Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 9 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_ri_field_10_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vaddRi10 , Constants.XPATH);
			reusecomp.sleep(200);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(1000,0);");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase 10 selected");
			//				
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	public void logic_input_validation_user_value_entry10_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.basiclifeRi10 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.basiclifeRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.basiclifeRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.basiclifeRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_BASICLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.basiclifeRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dentalRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dentalRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dentalRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dentalRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_DENTALPPO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dentalRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dependentlifeRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dependentlifeRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dependentlifeRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dependentlifeRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_DEPENDENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dependentlifeRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.ltdRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.ltdRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.ltdRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.ltdRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_LTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.ltdRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vltdcbuRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vltdcbuRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vltdcbuRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vltdcbuRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_VLTD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vltdcbuRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_SUPPLEMENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.supplementallifeRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_SUPPLEMENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.supplementallifeRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_SUPPLEMENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.supplementallifeRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_SUPPLEMENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.supplementallifeRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_SUPPLEMENTLIFE(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.supplementallifeRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dhmoRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dhmoRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dhmoRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dhmoRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.dhmoRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vaddRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vaddRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vaddRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vaddRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_VADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vaddRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry10_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds10: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.paddRi10,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry9_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds9: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.paddRi9 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry8_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds8: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.paddRi8 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry7_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds7: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.paddRi7 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_input_validation_user_value_entry6_PADD(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "reneval increase fileds6: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.paddRi6 ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_targetdiscount_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "target discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciaTargetDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_uwManagerFloorDiscount_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciaUWManagerDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_bundledFloorDiscount_DHMO(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled Floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciaBundledDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBAX_targetdiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "target discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbaxTargetDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBHI_targetdiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "target discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbhiTargetDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBCII_targetdiscount(WebDriver driver) throws Exception {
		try {
			//					reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//					reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "target discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciiTargetDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBCIA_targetdiscount(WebDriver driver) throws Exception {
		try {
			//						reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//						reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "target discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciaTargetDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_HYATTLEGAL_targetdiscount(WebDriver driver) throws Exception {
		try {
			//							reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//							reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "target discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbhyattlegalTargetDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBAX_uwManagerFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbaxUWManagerDiscount,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBHI_uwManagerFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbhiUWManagerDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBCIA_uwManagerFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciaUWManagerDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBCII_uwManagerFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciiUWManagerDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_HYATTLEGAL_uwManagerFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "UW manager floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbhyattlegalUWManagerDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}

	public void logic_validation_user_value_entry_VBAX_bundledFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled Floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbaxBundledDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBHI_bundledFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled Floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbhiBundledDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBCIA_bundledFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled Floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciaBundledDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_VBCII_bundledFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled Floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbciiBundledDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}
	public void logic_validation_user_value_entry_HYATTLEGAL_bundledFloorDiscount(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			//				reusecomp.javascriptscrollintoview(driver, RateTabPage.ri10_2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Bundled Floor discount: user entry verification:Negative validation");
			reusecomp.input(driver, RateTabPage_sk.vbhyattlegalBundledDiscount ,"34", Constants.XPATH);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, e.getMessage());
			reusecomp.logPassedStepToReportWithScreenshot(driver, "User Entry failed");
		}
	}

	public void STDASO_selected_from_selectopts(WebDriver driver) throws IOException {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.std_ATPselectopt, Constants.XPATH));
			reusecomp.selectDropDownByVisibleText(driver, RateTabPage_sk.std_ATPselectopt, "-Select-", Constants.XPATH);
			reusecomp.sleep(100);
			reusecomp.selectDropDownByVisibleText(driver, RateTabPage_sk.std_ATPselectopt, "2017 STD ATP Renewal", Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Std ATP is selected from dropdown");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	dental ASO selected from other cvgs version1
	public String DentalASO_selected_from_othercvgs(WebDriver driver) throws Exception {

		reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH);
		reusecomp.sleep(300);
//		reusecomp.scrollWindownormal(driver, "window.scrollBy(0,100);");
		boolean elementChecked = reusecomp.isElementChecked(driver, RateTabPage_sk.dental_ASO_Label , Constants.XPATH);
		if(elementChecked){
			reusecomp.sleep(200);
			String selectedcvg_ver1 = reusecomp.getText(driver,RateTabPage_sk.dental_ASO_Label, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver1);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg_ver1);
			//		reusecomp.assertEquals(driver, selectedcvg_ver2,selectedcvg);
			return selectedcvg_ver1;
		}
		else{
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.dental_ASO_Label , Constants.XPATH);
			String selectedcvg_ver1 = reusecomp.getText(driver,RateTabPage_sk.dental_ASO_Label, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver1);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg_ver1);
			return selectedcvg_ver1;
		}
	}
	//	dental PPO other cvg version2
	public String DentalPPO_selected_from_othercvgs_version2(WebDriver driver) throws Exception {
		reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptosec, Constants.XPATH);
		boolean elementChecked = reusecomp.isElementChecked(driver, RateTabPage_sk.dental_PPO_Label_version2 , Constants.XPATH);
		if(elementChecked){
			reusecomp.sleep(200);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.dental_PPO_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg_ver2);
			//		reusecomp.assertEquals(driver, selectedcvg_ver2,selectedcvg);
			return selectedcvg_ver2;
		}
		else{
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.dental_PPO_Label_version2 , Constants.XPATH);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.dental_PPO_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg_ver2);
			return selectedcvg_ver2;
		}

	}
	//	dental ASO selected from other cvgs version2
	public String DentalASO_selected_from_othercvgs_version2(WebDriver driver) throws Exception {
		reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptosec, Constants.XPATH);
		boolean elementChecked = reusecomp.isElementChecked(driver, RateTabPage_sk.dental_ASO_Label_version2 , Constants.XPATH);
		if(elementChecked){
			reusecomp.sleep(200);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.dental_ASO_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg_ver2);
			//			reusecomp.assertEquals(driver, selectedcvg_ver2,selectedcvg);
			return selectedcvg_ver2;
		}
		else{
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.dental_ASO_Label_version2 , Constants.XPATH);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.dental_ASO_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg_ver2);
			return selectedcvg_ver2;
		}

	}
	//	COMPARE
	public void comparevalue(WebDriver driver,String actual, String expected) throws IOException{
		try {
			reusecomp.sleep(100);
			reusecomp.assertEquals(driver, actual,expected);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	public void DentalASO_selected_from_othercvgs_getText(WebDriver driver) throws Exception {
	//		try {
	//			String selectedcvg = reusecomp.getText(driver,RateTabPage.dental_ASO_Label, Constants.XPATH);
	//			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg);
	//			ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg);
	//			reusecomp.sleep(200);
	//			reusecomp.logPassedStepToReportWithScreenshot(driver, "dental ASO clicked");
	//		}
	//		catch (Exception e) {
	//			System.out.println(e.toString());
	//			reusecomp.logger.warning(e.getMessage());
	//			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
	//		}
	//	}
	//		VB-AX select from other cvgs
	public void VB_AX_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
//			reusecomp.scrollWindow(driver, RateTabPage.std_ASO_Label, Constants.XPATH);
			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,200);");
			reusecomp.click(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-AX selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}	
	//	VB-AX select from other cvgs
	public String VB_AX_selected_from_othercvgss(WebDriver driver) throws Exception {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		//		reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
		reusecomp.sleep(100);
		boolean elementChecked = reusecomp.isElementChecked(driver, RateTabPage_sk.vb_AX_Label , Constants.XPATH);
		if(elementChecked==true){
			reusecomp.sleep(200);
			String selectedcvg_ver1 = reusecomp.getText(driver,RateTabPage_sk.vb_AX_Label, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver1);
			ExtentReport.Test.log(Status.INFO,"Element vb_AX_Label: "+selectedcvg_ver1);
			return selectedcvg_ver1;
		}
		else{
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.vb_AX_Label , Constants.XPATH);
			String selectedcvg_ver1 = reusecomp.getText(driver,RateTabPage_sk.vb_AX_Label, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver1);
			ExtentReport.Test.log(Status.INFO,"Element vb_AX_Label: "+selectedcvg_ver1);
			return selectedcvg_ver1;
		}

	}	
	//VB-AX select from other cvgs version2
	public String VB_AX_selected_from_othercvgss_version2(WebDriver driver) throws Exception {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		//	reusecomp.click(driver, RateTabPage.vb_AX_Label_version2, Constants.XPATH);
		reusecomp.sleep(100);
		boolean elementChecked = reusecomp.isElementChecked(driver, RateTabPage_sk.vb_AX_Label_version2 , Constants.XPATH);
		if(elementChecked==true){
			reusecomp.sleep(200);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.vb_AX_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"Element vb_AX_Label_version2: "+selectedcvg_ver2);
			return selectedcvg_ver2;
		}
		else{
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.vb_AX_Label_version2 , Constants.XPATH);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.vb_AX_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"Element vb_AX_Label_version2: "+selectedcvg_ver2);
			return selectedcvg_ver2;
		}
	}	
//	ltd other cvg ver2
	public String LTD_selected_from_othercvgss_version2(WebDriver driver) throws Exception {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		reusecomp.sleep(100);
		boolean elementChecked = reusecomp.isElementChecked(driver, RateTabPage_sk.ltd_Label_version2 , Constants.XPATH);
		if(elementChecked==true){
			reusecomp.sleep(200);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.ltd_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"ltd_Label_version2: "+selectedcvg_ver2);
			return selectedcvg_ver2;
		}
		else{
			reusecomp.sleep(200);
			reusecomp.click(driver, RateTabPage_sk.ltd_Label_version2 , Constants.XPATH);
			String selectedcvg_ver2 = reusecomp.getText(driver,RateTabPage_sk.ltd_Label_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg_ver2);
			ExtentReport.Test.log(Status.INFO,"ltd_Label_version2: "+selectedcvg_ver2);
			return selectedcvg_ver2;
		}
	}	
	//public void VB_AX_selected_from_othercvgs_getText(WebDriver driver) throws Exception {
	//	try {
	//		String selectedcvg = reusecomp.getText(driver,RateTabPage.vb_AX_Label, Constants.XPATH);
	//		reusecomp.logPassedStepToReportWithScreenshot(driver, "Selected cvgs: "+selectedcvg);
	//		ExtentReport.Test.log(Status.INFO,"Element selected: "+selectedcvg);
	//		reusecomp.sleep(200);
	//		reusecomp.logPassedStepToReportWithScreenshot(driver, "vb-ax selected");
	//	}
	//	catch (Exception e) {
	//		System.out.println(e.toString());
	//		reusecomp.logger.warning(e.getMessage());
	//		reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
	//	}
	//}
	//dhmo select from other cvgs
	public void dhmo_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolldownwcp, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmo_Label, Constants.XPATH);
			//			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dhmo selected");
			reusecomp.sleep(500);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}	
	//	dhmo selected from other cvgs version2
	public void dhmo_selected_from_othercvgs_version2(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolldownwcp, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.dhmo_Label_version2, Constants.XPATH);
			//			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "dhmo version2 selected");
			reusecomp.sleep(500);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}	
	//		vb-hi select from oher cvgs
	public void VB_HI_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,300);");
//			reusecomp.javascriptscrollintoview(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vb_HI_Label, Constants.XPATH);
			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-HI selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
	//		VB-CII select from oher cvgs
	public void VB_CII_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,300);");
//			reusecomp.scrollWindow(driver, RateTabPage.padd_Label, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vb_CII_Label, Constants.XPATH);
			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-CII selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
	//		VB-CIA select from oher cvgs
	public void VB_CIA_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,300);");
//			reusecomp.scrollWindow(driver, RateTabPage.padd_Label, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.vb_CIA_Label, Constants.XPATH);
			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "VB-CIA selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		VB-HYATTLEGAL select from oher cvgs
	public void VB_HYATTLEGAL_selected_from_othercvgs(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,300);");
//			reusecomp.scrollWindow(driver, RateTabPage.padd_Label, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.hyatt_Legal_Label, Constants.XPATH);
			reusecomp.sleep(100);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Hyatt Legal selected");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		validation for Apply Button
	public void Applybtn(WebDriver driver) throws Exception {
		try {
//			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.btnapply, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void scrollupto_Applybtn(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.basic_Life_Label, Constants.XPATH);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.hyatt_Legal_Label, Constants.XPATH));
			//				reusecomp.sleep(5000);
			//				reusecomp.logPassedStepToReportWithScreenshot(driver, "Margin values are displayed");
			reusecomp.sleep(500);

		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void scrollupto_updown(WebDriver driver) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "scrolled upto specific area");
			reusecomp.sleep(500);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void scrollupto_up(WebDriver driver) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)", "");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(400,0)", "");
			reusecomp.logPassedStepToReportWithScreenshot(driver, "scrolled upto specific area");
			reusecomp.sleep(700);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void LTDcvg(WebDriver driver) throws Exception {
		try {
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.scrolluptoothercoverages, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.ltd_Label, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.ltd_Label, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "LTD cvg is selected");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void VLTDcvg(WebDriver driver) throws Exception {
		try {
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.scrolluptoothercoverages, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.vltd_Label, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.vltd_Label, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "VLTD cvg is selected");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void experience_Rated_VLTDcvg(WebDriver driver) throws Exception {
		try {
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.scrolluptoothercoverages, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.experience_Rated_VLTD, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.experience_Rated_VLTD, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Experience Rated VLTD cvg is selected");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void experience_Rated_LTDcvg(WebDriver driver) throws Exception {
		try {
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.scrolluptoothercoverages, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.experience_Rated_LTD, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.experience_Rated_LTD, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Experience Rated LTD cvg is selected");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	apply btn version1
	public void Applybtn1(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply, Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.btnapply, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	aplly btn for verion2
	public void Applybtn1_version2(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply_version2, Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.btnapply_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply buttonversion2 clicked");
			reusecomp.sleep(500);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	
	//	save button
	public void savebtn1(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.scrollWindow(driver, RateTabPage.addversion1, Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(-200,200)", "");

			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.savebtn_version1, Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.savebtn_version1, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "save button1 clicked");
			reusecomp.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	save btn verion2
	public void savebtn_version2(WebDriver driver) throws Exception {
		try {
			//reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.savebtn_version2, Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.savebtn_version2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "save button version2 clicked");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	save btn verion3
	public void savebtn_version3(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.savebtn_version3, Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.savebtn_version3, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "save button version3 clicked");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	addversion button
	public void addversion1(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.addversion1, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.addversion1, Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver, RateTabPage_sk.addversion1, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Add version 2 button clicked");
			reusecomp.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	veraion btn 2
	public void clickversion2(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.scrollWindow(driver, RateTabPage.versionbtn2, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.versionbtn2, Constants.XPATH));
//			reusecomp.javascriptExecutorClick(driver, RateTabPage.addversion2, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.versionbtn2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, " version2 button clicked");
			reusecomp.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
//	version btn 3
	public void clickversion3(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
//			reusecomp.scrollWindow(driver, RateTabPage.versionbtn2, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.versionbtn3, Constants.XPATH));
//			reusecomp.javascriptExecutorClick(driver, RateTabPage.addversion2, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.versionbtn3, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, " version3 button clicked");
			reusecomp.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
//	addversion button version2
	public void addversion2(WebDriver driver) throws Exception {
		try {
			//				reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
			reusecomp.scrollWindow(driver, RateTabPage_sk.addversion2, Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.addversion2, Constants.XPATH));
//			reusecomp.javascriptExecutorClick(driver, RateTabPage.addversion2, Constants.XPATH);
			reusecomp.click(driver, RateTabPage_sk.addversion2, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Add version button from version 2 clicked");
			reusecomp.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
	//	validation for TargetDiscount UW manager Floor Discounts Bundled floor discounts for VB coverages
	public void Validation_VB_threediscounts(WebDriver driver) throws Exception {
		try {
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "check discound fields(TargetDiscount,UWmanagerFloorDiscount,BundledFloorDiscount) values");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
	public void Validation_VB_threediscountsTakeScreenshot(WebDriver driver) throws Exception {
		try {
			reusecomp.sleep(200);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "error message displayed");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}	
	//		Validation for not user filed from Eligible lives to Admin fee for VB coverages
	public void verify_not_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBAXcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			reusecomp.sleep(400);
			//		reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.eligiblelives, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.vbaxEligibleLives, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbaxEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible lives should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
			reusecomp.clearValue(driver, RateTabPage_sk.vbaxQuotedPremium, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbaxQuotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void verify_not_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBHIcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			reusecomp.sleep(400);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.eligiblelives, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.vbhiEligibleLives, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbhiEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible lives should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
			reusecomp.clearValue(driver, RateTabPage_sk.vbhiQuotedPremium, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbhiQuotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void verify_not_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBCIIcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			reusecomp.sleep(400);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.eligiblelives, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.vbciiEligibleLives, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbciiEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible lives should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
			reusecomp.clearValue(driver, RateTabPage_sk.vbciiQuotedPremium, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbciiQuotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void verify_not_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBCIAcvgs(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			reusecomp.sleep(400);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.eligiblelives, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.vbciaEligibleLives, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbciaEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible lives should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
			reusecomp.clearValue(driver, RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbciaQuotedPremium, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void verify_not_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBcvgs_HyattLegal(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal,Constants.XPATH);
			reusecomp.sleep(400);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.eligiblelives, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.vbhyattlegalEligibleLives, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.vbhyattlegalEligibleLives, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible lives should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.qoutedpremium, Constants.XPATH));
			reusecomp.clearValue(driver, RateTabPage_sk.qoutedpremium, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.qoutedpremium, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium should not leave blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
			//				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage.quoteddiscount, Constants.XPATH));
			reusecomp.input(driver, RateTabPage_sk.quoteddiscount, Constants.XPATH);
			reusecomp.getElement(driver, RateTabPage_sk.quoteddiscount, Constants.XPATH).sendKeys(Keys.TAB);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount should not blank or outerbox should be red color-verify");
			reusecomp.sleep(100);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void validate_all_user_values_entered_from_eligiblelives_to_adminfee_for_VBcvgs_HyattLegal(WebDriver driver) throws Exception{
		try{
			reusecomp.scrollWindow(driver, RateTabPage_sk.scrolluptototal, Constants.XPATH);
			//		reusecomp.input(driver, RateTabPage.eligiblelives,"29" , Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
			String eligiblelives1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhyattlegalEligibleLives, Constants.XPATH,"value");
			System.out.println("value: "+eligiblelives1);

			if(eligiblelives1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhyattlegalEligibleLives, Constants.XPATH);
				reusecomp.sleep(200);
				reusecomp.input(driver, RateTabPage_sk.vbhyattlegalEligibleLives,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");
				reusecomp.sleep(300);
			}
			else{
				reusecomp.click(driver,  RateTabPage_sk.vbhyattlegalEligibleLives, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "eligible live values entered");					
			}

			String quotedpremium1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhyattlegalQuotedPremium, Constants.XPATH,"value");
			System.out.println(quotedpremium1);

			if(quotedpremium1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhyattlegalQuotedPremium, Constants.XPATH);
				reusecomp.sleep(200);						
				reusecomp.input(driver, RateTabPage_sk.vbhyattlegalQuotedPremium,"1234" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted premium values entered");
				reusecomp.sleep(300);
			}

			String quotedmargin1 = reusecomp.getAttribute(driver, RateTabPage_sk.vbhyattlegalQuotedDiscount, Constants.XPATH,"value");
			System.out.println(quotedmargin1);
			if(quotedmargin1.isEmpty()){
				reusecomp.click(driver,  RateTabPage_sk.vbhyattlegalQuotedDiscount, Constants.XPATH);
				reusecomp.sleep(200);									
				reusecomp.input(driver, RateTabPage_sk.vbhyattlegalQuotedDiscount,"568" , Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "quoted discount values entered");
				reusecomp.sleep(300);
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//		Validation for Calculation Button
	public void calculate_btn(WebDriver driver) throws Exception{
		try{
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.coverage_VB,Constants.XPATH);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.calculate_ficore, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.calculate_ficore, Constants.XPATH);
			reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "calculate button selected");
			Thread.sleep(1000);
		}

		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	//	calculate and export
	public void calculateandexport_btn(WebDriver driver) throws Exception{
		try{
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.coverage_VB,Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.calculateandexport_version1, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.calculateandexport_version1, Constants.XPATH);
			reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "calculate and export button version 1selected");
			reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "calculate and export button version1  selected");

		}

		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	public void calculateandexport_btn_version2(WebDriver driver) throws Exception{
		try{
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.coverage_VB_version2,Constants.XPATH);
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.calculateandexport_version2, Constants.XPATH));
			reusecomp.click(driver, RateTabPage_sk.calculateandexport_version2, Constants.XPATH);
			reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "calculate and export button version2 selected");
			reusecomp.sleep(500);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "calculate and export button version2  selected");

		}

		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}

	public void expensepercentValue_for_SingleCvg_WCP(WebDriver driver, Map<String, String> testData) throws IOException {
		try {
			reusecomp.click(driver, RateTabPage_sk.analyzeTab, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "AnalyzeTab is Clicked");
			reusecomp.click(driver, RateTabPage_sk.cvgs, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "total covgs");
			reusecomp.sleep(2000);
			reusecomp.click(driver, RateTabPage_sk.cvgs, Constants.XPATH);
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.expensespercent_Analyze, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Expense % value is avaliable");

			String Expensevaluefrom_analyzetab = reusecomp.getText(driver, RateTabPage_sk.expensevalue_Analyze, Constants.XPATH);
			System.out.println(Expensevaluefrom_analyzetab);

			String Expensevaluefrom_analyzetab1=reusecomp.getAttribute(driver, RateTabPage_sk.expensevalue_Analyze, Constants.XPATH, "value");
			ExtentReport.Test.log(Status.INFO, "Expensevaluefrom_analyzetab: " +Expensevaluefrom_analyzetab);

			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,0);");
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.ratetabfromanalyze,Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver,  RateTabPage_sk.ratetabfromanalyze, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "ratetab clicked");
			reusecomp.sleep(400);
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.scrolluptowcp, Constants.XPATH );
			reusecomp.sleep(1000);
			System.out.println("scrolled");
			boolean dentalPPO_inOthers= reusecomp.isElementClickable(driver, RateTabPage_sk.dental_box_label, Constants.XPATH);
			System.out.println(dentalPPO_inOthers);
			if(dentalPPO_inOthers==true){
				reusecomp.click(driver, RateTabPage_sk.dental_PPO_Label, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalPPO selected");
				reusecomp.sleep(300);
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply, Constants.XPATH));
				reusecomp.click(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				reusecomp.scrollWindow(driver, RateTabPage_sk.expenseperct_dentalppo, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "exenses Percentsnprepopulated");

				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.expenseperct_dentalppo,Constants.XPATH));
				String expensepercentvaluefrom_wcp = reusecomp.getAttribute(driver, RateTabPage_sk.expenseperct_dentalppo, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO, "Expensevaluefrom_wcp: " +expensepercentvaluefrom_wcp);

				reusecomp.assertEquals(driver, Expensevaluefrom_analyzetab1,expensepercentvaluefrom_wcp);
			}
			else{
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalPPO disabled");
				reusecomp.sleep(300);
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply ,Constants.XPATH));
				reusecomp.click(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				reusecomp.sleep(500);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				//							reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "exenses Percentsnprepopulated");

				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.expenseperct_dentalppo,Constants.XPATH));
				String expensepercentvaluefrom_wcp = reusecomp.getAttribute(driver, RateTabPage_sk.expenseperct_dentalppo, Constants.XPATH,"value");
				Thread.sleep(9000);
				ExtentReport.Test.log(Status.INFO, "Expensevaluefrom_wcp: " +expensepercentvaluefrom_wcp);

				reusecomp.assertEquals(driver, Expensevaluefrom_analyzetab,expensepercentvaluefrom_wcp);
				//			                if(Expensevsluefrom_analyzetab==expensepercentvsaluefrom_wcp){
			}

		}

		catch (Exception e) {

			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}

	}

	public void expensepercentValue_for_MultiCvg_ExpensevaluePrepopulated_WCP(WebDriver driver, Map<String, String> testData) throws IOException {
		try {
			reusecomp.click(driver, RateTabPage_sk.analyzeTab, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "AnalyzeTab is Clicked");
			reusecomp.click(driver, RateTabPage_sk.cvgs, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "total covgs");
			reusecomp.sleep(2000);
			reusecomp.click(driver, RateTabPage_sk.cvgs, Constants.XPATH);
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.expensespercent_Analyze, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Expense % value is avaliable");

			String Expensevaluefrom_analyzetab = reusecomp.getText(driver, RateTabPage_sk.expensevalue_Analyze, Constants.XPATH);
			System.out.println(Expensevaluefrom_analyzetab);

			String Expensevaluefrom_analyzetab1=reusecomp.getAttribute(driver, RateTabPage_sk.expensevalue_Analyze, Constants.XPATH, "value");
			ExtentReport.Test.log(Status.INFO, "Expensevaluefrom_analyzetab: " +Expensevaluefrom_analyzetab);

			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,0);");
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.ratetabfromanalyze,Constants.XPATH));
			reusecomp.javascriptExecutorClick(driver,  RateTabPage_sk.ratetabfromanalyze, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "ratetab clicked");
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.scrolldownwcp, Constants.XPATH );
			reusecomp.sleep(200);
			System.out.println("scrolled");
			boolean dentalPPO_inOthers= reusecomp.isElementClickable(driver, RateTabPage_sk.dental_box_label, Constants.XPATH);
			System.out.println(dentalPPO_inOthers);
			if(dentalPPO_inOthers==true){
				reusecomp.click(driver, RateTabPage_sk.dental_PPO_Label, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalPPO selected");
				reusecomp.sleep(300);
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply, Constants.XPATH));
				reusecomp.click(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				reusecomp.scrollWindow(driver, RateTabPage_sk.expenseperct_dentalppo, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "exenses Percentsnprepopulated by using composite formula");

				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.expenseperct_dentalppo,Constants.XPATH));
				String expensepercentvaluefrom_wcp = reusecomp.getAttribute(driver, RateTabPage_sk.expenseperct_dentalppo, Constants.XPATH,"value");
				ExtentReport.Test.log(Status.INFO, "Expensevaluefrom_wcp: " +expensepercentvaluefrom_wcp);

				reusecomp.assertEquals(driver, Expensevaluefrom_analyzetab1,expensepercentvaluefrom_wcp);
			}
			else{
				reusecomp.logPassedStepToReportWithScreenshot(driver, "dentalPPO disabled");
				reusecomp.sleep(300);
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.vb_AX_Label, Constants.XPATH);
				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.btnapply ,Constants.XPATH));
				reusecomp.click(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "Apply button clicked");
				reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.btnapply, Constants.XPATH);
				//						reusecomp.scrollWindow(driver, RateTabPage.btnapply, Constants.XPATH);
				reusecomp.logPassedStepToReportWithScreenshot(driver, "exenses Percentsnprepopulated by using composite formula");

				reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.expenseperct_dentalppo,Constants.XPATH));
				String expensepercentvaluefrom_wcp = reusecomp.getAttribute(driver, RateTabPage_sk.expenseperct_dentalppo, Constants.XPATH,"value");
				Thread.sleep(9000);
				ExtentReport.Test.log(Status.INFO, "Expensevaluefrom_wcp: " +expensepercentvaluefrom_wcp);

				//		                reusecomp.assertEquals(driver, Expensevaluefrom_analyzetab,expensepercentvaluefrom_wcp);
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
	}
	public void expensepercentValue_for_dentalppo_valueBlank_Analyzetab_WCP(WebDriver driver) throws IOException {
		try {
			reusecomp.javascriptscrollintoview(driver, RateTabPage_sk.expensespercent_Analyze, Constants.XPATH);
			reusecomp.logPassedStepToReportWithScreenshot(driver, "Expense % value is blank");
			reusecomp.highLighterMethod(driver, reusecomp.getElement(driver, RateTabPage_sk.expensespercent_Analyze, Constants.XPATH));
			reusecomp.scrollWindownormal(driver, "window.scrollBy(0,0);");
		}
		catch (Exception e) {
			System.out.println(e.toString());
			reusecomp.logger.warning(e.getMessage());
			reusecomp.logFailedStepToReportWithScreenshot(driver, e.getMessage());
		}
		}

	}


