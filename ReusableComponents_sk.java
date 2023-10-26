package library;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import Reports.ExtentReport;

public class ReusableComponents_sk {

	public final Logger logger = Logger.getLogger(ReusableComponents_sk.class.getName());
	protected static int counter = 1;

	private Properties prop = null;
	public WebDriver driver = null;
	Set<String> allwindows = null;
	private int explicitWaitTime = 10;
	private static ExtentReports extent;
	public static ExtentTest Test;
	public static Recordset rs;

	/**
	 * This will delete any cookies stored from a previous session
	 */
	public void clearBrowserCache(WebDriver driver) {
		driver.manage().deleteAllCookies();
		logger.info("Browser Cache Deleted");
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
	
	

	/**
	 * This will refresh the webpage
	 */
	public void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
		logger.info("Browser Refreshed");
	}

	/**
	 * Get's the current url in the browser
	 * 
	 * @param url
	 */
	public void getURL(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * This will bypass a security certificate error in IE
	 */
	public void bypassSecurityCertificate(WebDriver driver) {
		Capabilities c = ((RemoteWebDriver) driver).getCapabilities();
		if (c.getBrowserName().equalsIgnoreCase("internet explorer")) {
			driver.switchTo().defaultContent();
			driver.findElement(By.id("overridelink")).click();
		}
	}

	/**
	 * Grab control of the top most open browser window
	 */
	public void getTopWindow(WebDriver driver) {

		try {

			Set<String> ids = driver.getWindowHandles();
			Iterator<String> iterator = ids.iterator();
			String nextID = null;
			while (iterator.hasNext()) {
				nextID = iterator.next();
			}
			driver.switchTo().window(nextID);
			System.out.println(driver.switchTo().window(nextID).getTitle());
			System.out.println(driver.switchTo().window(nextID).getCurrentUrl());
			System.out.println(driver.switchTo().window(nextID));
			logger.info("Switched To Top Window");
		} catch (Exception e) {

			logger.info("Not Switched To Top Window");
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "Not Switched To Top Window:" + e.getMessage());

		}

	}

	/**
	 * Select Text from Menu
	 * 
	 * @param we
	 * @param text
	 * @return
	 * 
	 */
	public void getTopWindows(WebDriver driver) {

		try {
			String windowHandle = driver.getWindowHandle();
			System.out.println("1st: "+windowHandle);
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> iterator = ids.iterator();
			String nextID = null;
			while (iterator.hasNext()) {
				nextID = iterator.next();
		String title = driver.switchTo().window(nextID).getCurrentUrl();
		System.out.println("titles: "+ title);
			}
			driver.switchTo().window(nextID);
			System.out.println(driver.switchTo().window(nextID).getCurrentUrl());
			System.out.println(driver.switchTo().window(nextID));
			Thread.sleep(2000);
			driver.switchTo().window(windowHandle);
			logger.info("Switched To Top Window");
		} catch (Exception e) {

			logger.info("Not Switched To Top Window");
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "Not Switched To Top Window:" + e.getMessage());

		}

	}
	public void selectFromMenu(WebDriver driver, WebElement we, String text) {
		try {

			if (driver.findElement(By.cssSelector("#nav > label")).isDisplayed()) {
				driver.findElement(By.cssSelector("#nav > label")).click();
			}
			we.click();
			Actions actions = new Actions(driver);
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 1000);
			WebElement dropdownitem = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));
			actions.moveToElement(dropdownitem);
			actions.click().build().perform();

			logger.info("Menu Element Selected:" + text);

		} catch (Exception e) {

			logger.info("Element Not Selected From Menu:" + text);
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "Element Not Selected From Menu:" + e.getMessage());

		}
	}

	/**
	 * This performs a double click on the given web element
	 * 
	 * @param element
	 */

	public void doubleClick(WebDriver driver, WebElement element) {
		try {

			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
			logger.info("DoubleClick Operation Performed:" + element);

		}

		catch (Exception e) {

			logger.info("Double Click Failed:" + element);
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "Double Click Failed:" + e.getMessage());
		}
	}

	/**
	 * This takes a skip message and outputs it to the report
	 * 
	 * @param Test
	 *            - Test parameter to be used by extent report
	 * @param skipMsg
	 *            - String message to be displayed for skip
	 * @throws Exception
	 */
	public void reportingSkip(ExtentTest Test, String skipMsg) {
		Test.log(Status.SKIP, skipMsg);
		extent.flush();
	}

	/**
	 * Switches the focus to a new frame
	 * 
	 * @param frameName
	 */

	public void switchToFrame(WebDriver driver, String frameName) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(frameName);
			logger.info("Frame Switched:" + frameName);
		} catch (Exception e) {
			logger.info("Frame Not Switched:" + frameName);
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "Frame Not Switched:" + e.getMessage());
		}
	}

	/**
	 * Switches the focus to a second frame
	 * 
	 * @param FrameName
	 */
	public void switchToSecondFrame(WebDriver driver, String frame1, String frame2) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(frame1);
			driver.switchTo().frame(frame2);
			logger.info("Frame Switched");
		} catch (Exception e) {

			logger.info("Frame Not Switched");
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "Frame Not Switched:" + e.getMessage());
		}
	}

	/**
	 * Handles a pop-up alert given the title
	 * 
	 * @param title
	 */
	public void popuphandler(WebDriver driver, String title) {
		allwindows = driver.getWindowHandles();
		for (String childwindow : allwindows) {
			driver.switchTo().window(childwindow);
			String actualWindowTitle = driver.getTitle();
			logger.log(Level.INFO, "ActualWindowTitle : {0}", actualWindowTitle);

			if (actualWindowTitle.contains(title)) {
				break;
			}
		}
	}

	/**
	 * Wait for with the element to be clickable or visible
	 * 
	 * @param locator
	 *            - string name set in the properties file for a web element
	 * @param timeoutinseconds
	 *            - desired wait time
	 * @param condition
	 *            this is either visibilityOfElementLocated or ElementToBeClickable
	 * @return
	 */
	public WebElement explicitWait(WebDriver driver, String locator, int timeoutinseconds, String condition) {

		WebElement element = null;
		if (condition.equalsIgnoreCase("visibilityOfElementLocated")) {
			element = new WebDriverWait(driver, timeoutinseconds)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			return element;
		}

		if (condition.equalsIgnoreCase("ElementToBeClickable")) {
			element = new WebDriverWait(driver, timeoutinseconds)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			return element;
		}
		return element;

	}

	/**
	 * Wait for with the element to be clickable or visible
	 * 
	 * @param locator
	 *            - string name set in the properties file for a web element
	 * @param timeoutinseconds
	 *            - desired wait time
	 * @param condition
	 *            this is either visibilityOfElementLocated or ElementToBeClickable
	 * @return
	 */
	public void explicitWait(WebDriver driver, String locator) {
		new WebDriverWait(driver, explicitWaitTime).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	//Input with delete
	/**
	 * Input with Delete Key
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath *
	 *            cssselector)
	 */
	public void inputwithkey(WebDriver driver, String locatorKey,String data,String type) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
	Keys tab = Keys.TAB;
	getElement(driver, locatorKey, type).click();
	getElement(driver, locatorKey, type).clear();
	getElement(driver, locatorKey, type).sendKeys(del +data);
	getElement(driver, locatorKey, type).sendKeys(tab);	
	}
	/**
	 * Hovers the mouse over a specified web element
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath *
	 *            cssselector)
	 */
	public void mouseHover(WebDriver driver, String locatorKey, String type) {
		try {
			WebElement e = getElement(driver, locatorKey, type);
			Actions builder = new Actions(driver);
			builder.moveToElement(e).click().perform();
			logger.info("MouseHover Performed:" + locatorKey);
		} catch (Exception e) {
			logger.info("MouseHover Operation Failed:" + locatorKey);
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "MouseHover Operation Failed:" + e.getMessage());
		}
	}

	/**
	 * Use the locator key to return the web element
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return 
	 * @return
	 */
	public WebElement getElement(WebDriver driver, String locatorKey, String type) {

		WebElement element = null;
		try {
			if (type.equalsIgnoreCase(Constants.ID)) {
				element = driver.findElement(By.id(locatorKey));
			} else if (type.equalsIgnoreCase(Constants.NAME)) {
				element = driver.findElement(By.name(locatorKey));
			} else if (type.equalsIgnoreCase(Constants.CLASSNAME)) {
				element = driver.findElement(By.className(locatorKey));
			} else if (type.equalsIgnoreCase(Constants.LINKTEXT)) {
				element = driver.findElement(By.linkText(locatorKey));
			} else if (type.equalsIgnoreCase(Constants.XPATH)) {
				element = driver.findElement(By.xpath(locatorKey));
			} else if (type.equalsIgnoreCase(Constants.CSSSELECTOR)) {
				element = driver.findElement(By.cssSelector(locatorKey));
			} else {
				Assert.fail(Constants.THE_PROVIDED_LOCATOR_IS_NOT_FOUND_AT + locatorKey);
			}

		} catch (Exception e) {
			logger.info("GetElement Method Failed");
			logger.warning(e.getMessage());
			ExtentReport.Test.log(Status.FAIL, "GetElement Method Failed: " + e.getMessage());

		}

		return element;

	}

	/**
	 * Get Element from List
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param elementtoget
	 *            - element to get
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 */

	public WebElement getElementInAList(WebDriver driver, String locatorKey, String elementtoget, String type) {
		WebElement element = null;
		if (type.equalsIgnoreCase(Constants.XPATH)) {
			List<WebElement> elements = driver.findElements(By.xpath(locatorKey));
			for (int i = 0; i < elements.size(); i++) {
				element = elements.get(i);
				if (element.getText().equalsIgnoreCase(elementtoget)) {
					break;
				}
			}
		}
		return element;
	}

	/**
	 * Select Value from a List
	 * 
	 * @param locator
	 *            - string name set in the java file for a web element
	 * @param text
	 *            - text to be selected from list
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 */

	public void selectValueFromList(WebDriver driver, String locatorKey, String type, String text) {
		try {
			boolean flag = false;
			List<WebElement> list_values = (List<WebElement>) getElement(driver, locatorKey, type);
			for (WebElement e : list_values) {
				logger.info(e.getText().trim());

				if (e.getText().trim().equals(text)) {
					flag = true;
					e.click();
				}
			}

			if (!flag) {
				ExtentReport.Test.log(Status.FAIL, "Failed to click:" + locatorKey);
			} else {

				logPassedStepToReport(Test, "Sucessfully clicked:" + locatorKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.Test.log(Status.FAIL, "Failed to click:" + locatorKey + e.getMessage());

		}

	}

	public void input(WebDriver driver, String locatorKey, String data, String type) {
		getElement(driver, locatorKey, type).click();
		getElement(driver, locatorKey, type).clear();
		getElement(driver, locatorKey, type).sendKeys(data);

		logger.info("Input Entered: " + data);
	}

	/**
	 * Clicks the web element provided
	 * 
	 * @param lnkAddCovCard
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 */

	

	public void click(WebDriver driver, String locatorKey, String type) {
		getElement(driver, locatorKey, type).click();
	}


	/**
	 * click the webelement having javascript associated in the html tag.
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param xpath
	 *            type - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @author Enrollment Team
	 */

	public void javascriptExecutorClick(WebDriver driver, String locatorKey, String type) {

		WebElement element = getElement(driver, locatorKey, type);
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].click();", element);

	}

	/**
	 * This takes a passing message and outputs it to the report
	 * 
	 * @param Test
	 *            - Test parameter to be used by extent report
	 * @param passMsg
	 *            - String message to be displayed for pass
	 * @throws Exception
	 */
	public void javascriptscrollintoview(WebDriver driver, String locatorKey, String type) {

		WebElement element = getElement(driver, locatorKey, type);
		JavascriptExecutor js = ((JavascriptExecutor) driver);

	js.executeScript("arguments[0].scrollIntoView();",element );
	}
	public void logPassedStepToReport(ExtentTest Test, String passMsg) {
		Test.log(Status.PASS, passMsg);
		extent.flush();

	}

	public void logFailedStepToReport(ExtentTest Test, String failMsg) {
		logger.warning(failMsg);
		Test.log(Status.PASS, failMsg);
		extent.flush();
		Assert.fail(failMsg);

	}

	/**
	 * Handles data from the excel file
	 * 
	 * @param filePath
	 * @param sheetName
	 *            - Name of the sheet to find the data
	 * @param testCase
	 *            - Name of the Test Case within the excel file
	 * @return
	 */
	public Map<String, String> getData(String filePath, String sheetName, String testCase) {
		int testCaseRowNumber;
		XLSReader xl = new XLSReader(filePath);
		testCaseRowNumber = xl.testCaseRow(sheetName, testCase);

		return xl.gettestdata(sheetName, testCaseRowNumber);
	}

	/**
	 * Returns a true/false based on the element (checkboxes, radio buttons) being
	 * checked
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return boolean
	 */
	public boolean isElementChecked(WebDriver driver, String locatorKey, String type) {
		WebElement checkbox = getElement(driver, locatorKey, type);
		return checkbox.isSelected();
	}

	/**
	 * Returns a true/false based on the element being enabled or not This can help
	 * determine whether inputs are disabled, for example
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return boolean
	 */
	public boolean isElementEnabled(WebDriver driver, String locatorKey, String type) {
		WebElement element = getElement(driver, locatorKey, type);
		return element.isEnabled();
	}

	/**
	 * Returns a true/false based on the element being displayed or not
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return boolean
	 */
	public boolean isElementDisplayed(WebDriver driver, String locatorKey, String type) {
		WebElement element = getElement(driver, locatorKey, type);
		return element.isDisplayed();
	}

	/**
	 * This takes a screenshot, and returns the base64 encoded string which
	 * represents the image
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public String takeScreenShotAsBase64(WebDriver driver,String filepath) {
		
		String dest = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return "data:image/jpg;base64, " + dest;
	}

	/**
	 * This takes a screenshot and place in cucumber reports folder.
	 * 
	 * @param driver
	 * @Param Cucumber scenario name
	 * @param report
	 *            location
	 * @return
	 * @throws InterruptedException
	 */
	public void takeScreenShot(WebDriver driver, Scenario scenario, String reportpath) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);
			String REPORT_OUTPUT = reportpath;
			File destinationPath = new File(REPORT_OUTPUT + scenario.getGherkinName() + ".png");
			FileUtils.copyFile(sourcePath, destinationPath);
			String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
			String A = capture(driver, "Passed_Step" + timestamp);
			ExtentReport.Test.addScreenCaptureFromPath(A);

		} catch (Exception e) {

			logger.info("take screen shot method failed :");
			logger.warning(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Assertion to validate 2 strings are equal
	 * 
	 * @param actual
	 *            - string text on web ui
	 * @param expected
	 *            - string text for what is expected
	 * @throws IOException
	 */
	public void assertEquals(WebDriver driver, String actual, String expected) throws IOException {
		if (actual.equalsIgnoreCase(expected)) {
			logPassedStepToReportWithScreenshot(driver, "Data match. Expected: " + expected + " Actual: " + actual);
		} else {
			logFailedStepToReportWithScreenshot(driver, "Data mismatch. Expected: " + expected + " Actual: " + actual);
			Assert.fail("Data mismatch.");
		}
	}

	/**
	 * Assertion to validate 2 integers are equal
	 * 
	 * @param actual
	 *            - string integer value
	 * @param expected
	 *            - string integer value
	 */

	public void assertEquals(int actual, int expected) {
		if (actual == expected) {

			logger.info("Data Match. Expected: " + expected + " Actual: " + actual);
			logPassedStepToReport(Test, "Data Match. Expected: " + expected + " Actual: " + actual);

		} else {

			logger.info("Data Mismatch. Expected: " + expected + " Actual: " + actual);
			logFailedStepToReport(Test, "Data mismatch. Expected: " + expected + " Actual: " + actual);
			Assert.fail("Data Mismatch.");
		}
	}

	/**
	 * Checks to see if the web element is present on the page
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 */

	public boolean isElementPresent(WebDriver driver, String locatorKey, String type) {
		List<WebElement> elements = new ArrayList<>();
		if (type.equalsIgnoreCase("id")) {

			elements = driver.findElements(By.id(locatorKey));

		} else if (type.equalsIgnoreCase("name")) {

			elements = driver.findElements(By.name(locatorKey));

		} else if (type.equalsIgnoreCase(Constants.CLASSNAME)) {

			elements = driver.findElements(By.className(locatorKey));

		} else if (type.equalsIgnoreCase(Constants.LINKTEXT)) {

			elements = driver.findElements(By.linkText(locatorKey));

		} else if (type.equalsIgnoreCase(Constants.XPATH)) {

			elements = driver.findElements(By.xpath(locatorKey));

		} else if (type.equalsIgnoreCase(Constants.CSSSELECTOR)) {

			elements = driver.findElements(By.cssSelector(locatorKey));

		} else {

			Assert.fail(Constants.THE_PROVIDED_LOCATOR_IS_NOT_FOUND_AT + locatorKey);
		}

		logger.info("Element Present:" + locatorKey);

		return !elements.isEmpty();

	}

	/**
	 * Returns a true/false based whether or not the element exists on the page
	 * 
	 * @param selector
	 *            this will look something like by.xpath("whicheverXpath"), it tells
	 *            the driver how to find the element in question
	 * @return boolean
	 */
	public boolean isElementPresent(WebDriver driver, By selector) {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean returnVal = true;

		try {
			driver.findElement(selector);
			logger.info("Element Present: " + selector);

		} catch (NoSuchElementException e) {

			logger.info("Element Not Present:" + selector);
			logger.warning(e.getMessage());
			returnVal = false;

		} finally {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return returnVal;
	}

	/**
	 * Checks to see if the web element is not present on the page
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 */

	public void isElementNotPresent(WebDriver driver, String locator, String type)

	{
		try {
			int Size = driver.findElements(By.xpath(locator)).size();
			if (Size == 0) {

				logPassedStepToReport(Test, locator + " is not present");
				logger.info(locator + " is not present");

			} else {
				logFailedStepToReport(Test, locator + " is present");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			logFailedStepToReport(Test, locator + " is present" + e.getMessage());

		}

	}

	/**
	 * Returns a true/false based on the element being clickable - i.e. if it is
	 * both displayed and enabled This can help determine whether inputs are
	 * disabled, for example
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return boolean
	 */
	public boolean isElementClickable(WebDriver driver, String locatorKey, String type) {
		boolean elementIsDisplayed = isElementDisplayed(driver, locatorKey, type);
		boolean elementIsEnabled = isElementEnabled(driver, locatorKey, type);
		logger.info("Element Clickable");
		return (elementIsDisplayed && elementIsEnabled);
	}

	/**
	 * verify text of the element matches with the expected text or not
	 * 
	 * @param locator
	 *            - string name set in the properties file for a web element
	 * @Param text - expected text
	 * 
	 * @return
	 */

	public void verifyElementText(WebDriver driver, String locator, String type, String text) {
		try {
			WebElement element = getElement(driver, locator, type);

			String actualtext = element.getText();

			logger.info("Actual text is" + actualtext);

			if (actualtext.trim().equals(text)) {

				logPassedStepToReport(Test, text + "  is present");

			} else {
				logFailedStepToReport(Test, "Expected= " + text + "Actual= " + actualtext);
				logger.info("Expected= " + text + "Actual= " + actualtext);

			}

		} catch (Exception e) {
			e.printStackTrace();

			logFailedStepToReport(Test, text + "  is not present");

		}

	}

	/**
	 * verify text of the element matches with the expected text or not
	 * 
	 * @param locator
	 *            - string name set in the properties file for a web element
	 * @Param text - expected text
	 * 
	 * @return
	 */

	public void verifyElementTextIgnoreCase(WebDriver driver, String locator, String type, String text) {
		try {
			WebElement element = getElement(driver, locator, type);

			String actualtext = element.getText();

			logger.info("Actual text is" + actualtext);

			if (actualtext.trim().equals(text.toLowerCase())) {

				logPassedStepToReport(Test, text + "  is present");

			} else {
				logFailedStepToReport(Test, "Expected= " + text + "Actual= " + actualtext);
				logger.info("Expected= " + text + "Actual= " + actualtext);

			}

		} catch (Exception e) {
			e.printStackTrace();

			logFailedStepToReport(Test, text + "  is not present");

		}

	}

	/**
	 * Input method to default to xpath if no type is provided
	 * 
	 * @param locatorKey
	 * @param data
	 * @throws IOException
	 */
	public void input(WebDriver driver, String locatorKey, String data) throws IOException {
		try {
			input(driver, locatorKey, data, Constants.XPATH);
			logger.info("Text Input entered: " + locatorKey);
		} catch (Exception e) {
			logger.info("Text Input failed: " + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "Text Input Failed: " + e.getMessage());
		}
	}

	/**
	 * Enter text into a text field having javascript associated in the html tag.
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param data
	 *            - text to be entered into a text field
	 * @param xpath
	 *            type - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @author
	 * @throws IOException
	 */

	public void javascriptExecutorInput(WebDriver driver, String locatorKey, String data, String type)
			throws IOException {
		try {
			WebElement element = getElement(driver, locatorKey, type);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].value='" + data + "';", element);
			logger.info("Text Input Entered: " + data);

		} catch (Exception e) {

			logger.info("Text Input Failed: " + data);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "Text Input Failed: " + e.getMessage());
		}
	}

	/**
	 * Click method to default to xpath if no type is provided
	 * 
	 * @param locatorKey
	 * @throws IOException
	 */

	public void click(WebDriver driver, String locatorKey) throws IOException {
		try {

			click(driver, locatorKey, Constants.XPATH);
			logger.info("Element clicked: " + locatorKey);

		}

		catch (Exception e) {

			logger.info("Element Not Clicked: " + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "Element Not Clicked: " + locatorKey + e.getMessage());
		}
	}

	/**
	 * Right clicks the web element provided
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @throws IOException
	 */
	public void rightClick(WebDriver driver, String locatorKey, String type) throws IOException {
		try {

			Actions action = new Actions(driver);
			action.contextClick(getElement(driver, locatorKey, type)).perform();
			logger.info("Right Click Performed: " + locatorKey);

		} catch (Exception e) {

			logger.info("Right Click Failed: " + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "Right Click Failed: " + locatorKey + e.getMessage());
		}
	}

	/**
	 * Clicks the dynamic web element provided
	 * 
	 * @param locatorKey
	 *            - string name set in the properties file for a web element
	 * @param locaterType
	 *            - string text for the type of element to be clicked
	 * @throws IOException
	 */
	public void clickDynamicElement(WebDriver driver, String locatorKey, String locaterType) throws IOException {
		try {

			getElementWithReplacementValue(driver, locatorKey, locaterType).click();
			logger.info("Dynamic Element Clicked: " + locatorKey);
		} catch (Exception e) {

			logger.info("Dynamic Click Failed: " + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, " Click Failed: " + locatorKey + e.getMessage());
		}
	}

	/**
	 * Collects and returns a list of web elements at the specified path
	 * 
	 * @param locatorKey
	 *            - string name set in the properties file for a web element
	 * @return
	 */
	public List<WebElement> getElements(WebDriver driver, String locatorKey) {
		System.out.println("Print");
		return driver.findElements(By.xpath(locatorKey));
		
	}

	/**
	 * Reads and provides the text found at the locator key
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 */

	public String getText(WebDriver driver, String locatorKey, String type) {
		return getElement(driver, locatorKey, type).getText();
	}

	/**
	 * getText method to default to xpath if no type is provided
	 * 
	 * @param locatorKey
	 * @throws IOException
	 */
	public void getText(WebDriver driver, String locatorKey) throws IOException {
		try {
			getText(driver, locatorKey, Constants.XPATH);
			logger.info("Get Text Passed: " + locatorKey);
		}

		catch (Exception e) {

			logger.info("Get Text Failed: " + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, " Get Text Failed: " + locatorKey + e.getMessage());
		}
	}

	/**
	 * Searches object for attribute, if exists returns true, else false
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param attribute
	 *            - the name of the attribute whose text value you wish to return
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return boolean
	 */
	public boolean doesElementHaveAttribute(WebDriver driver, String locatorKey, String type, String attribute) {
		String fieldValue = getElement(driver, locatorKey, type).getAttribute(attribute);
		return (fieldValue != null);
	}

	/**
	 * Handle a pop-up alert
	 * 
	 * @param locator
	 *            - string name set in the java file for a web element
	 * @throws InterruptedException
	 */
	public void popupAlert(WebDriver driver, String locator, String type) throws InterruptedException {

		Thread.sleep(2000);
		switchToFrame(driver, "tapestry");
		Thread.sleep(2000);
		if (getElement(driver, locator, type).isDisplayed()) {
			Thread.sleep(2000);
			click(driver, locator, type);
		}
	}

	/**
	 * Scrolls within a window to put an element into view
	 * 
	 * @param locator
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @throws InterruptedException
	 */
	public void scrollWindow(WebDriver driver, String locator, String type) throws InterruptedException {
		WebElement element = getElement(driver, locator, type);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);

	}
	public void scrollWindownormal(WebDriver driver, String value) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value);
		Thread.sleep(2000);
	}
	/**
	 * Highlight the element provided
	 * 
	 * @param locator
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 */
	public void highlightElement(WebDriver driver, String locator, String type) {
		WebElement ele = getElement(driver, locator, type);
		((JavascriptExecutor) driver)
				.executeScript("argument[0].setAttribute('style','background: yellow; border: 2px solid red;');", ele);

	}

	/**
	 * Clears the value of text field
	 * 
	 * @param locator
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 */
	public void clearValue(WebDriver driver, String locator, String type) {
		getElement(driver, locator, type).clear();

	}

	/**
	 * clearValue method to default to xpath if no type is provided
	 * 
	 * @param locatorKey
	 */
	public void clearValue(WebDriver driver, String locator) {
		getElement(driver, locator, Constants.XPATH).clear();
	}

	public WebElement getElementWithReplacementValue(WebDriver driver, String locatorKey, String locaterType) {

		WebElement element = null;

		if (locaterType.equals(Constants.ID)) {
			element = driver.findElement(By.id(locatorKey));
		} else if (locaterType.equals(Constants.NAME)) {
			element = driver.findElement(By.name(locatorKey));
		} else if (locaterType.equals(Constants.CLASSNAME)) {
			element = driver.findElement(By.className(locatorKey));
		} else if (locaterType.equals(Constants.LINKTEXT)) {
			element = driver.findElement(By.linkText(locatorKey));
		} else if (locaterType.equals(Constants.XPATH)) {
			element = driver.findElement(By.xpath(locatorKey));
		} else if (locaterType.equals(Constants.CSSSELECTOR)) {
			element = driver.findElement(By.cssSelector(locatorKey));
		} else {
			Assert.fail("The provided Locator - " + locatorKey + " is not found");
		}
		return element;

	}

	/**
	 * Assertion to validate 2 strings are not equal
	 * 
	 * @param actual
	 *            - string text on web ui
	 * @param expected
	 *            - string text for what is expected
	 */
	public void assertNotEquals(String actual, String expected) {
		Assert.assertNotEquals(actual, expected);
	}

	/**
	 * Asserts to see if the provided condition is true
	 * 
	 * @param condition
	 */
	public void assertTrue(boolean condition) {
		Assert.assertTrue(condition);

	}

	public String replacementInLocator(String locator, String replaceValue) {

		String currentLocator = prop.getProperty(locator);
		return currentLocator.replace("$replacement-value$", replaceValue);
	}

	public List<WebElement> getElementsWithReplacementValue(WebDriver driver, String locatorKey) {
		return driver.findElements(By.xpath(locatorKey));
	}

	/**
	 * Method to count the rows in table
	 * 
	 * @param xapth
	 *            - xpath of the webtable
	 */
	public int getTableRowCount(WebDriver driver, String xpath) {
		try {
			WebElement webtable = driver.findElement(By.xpath(xpath));
			List<WebElement> rows = webtable.findElements(By.tagName("tr"));
			return rows.size();
		} catch (Exception e) {
			logger.info(e.getMessage());
			return 0;
		}

	}

	/**
	 * Method to check the content in table
	 * 
	 * @param xapth
	 *            - xpath of the webtable
	 * @param value
	 *            - value to be checked in table
	 */
	public boolean checkTableContains(WebDriver driver, String tableXPath, String value) {
		int count = 0;
		try {
			WebElement webtable = driver.findElement(By.xpath(tableXPath));
			List<WebElement> allRows = webtable.findElements(By.tagName("tr"));
			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));

				// Value of each cell
				for (WebElement cell : cells) {
					if (cell.getText().contains(value))

					{
						count = 1;
						break;
					}

				}

				if (count == 1) {
					break;
				}

			}
			if (count == 1) {
				logPassedStepToReportWithScreenshot(driver, value + " exists in table");
				return true;
			} else {
				logFailedStepToReport(Test, value + " does not exists in table");
			}

		} catch (Exception e) {
			logFailedStepToReport(Test, value + " does not exists in table" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * Method to check the table header
	 * 
	 * @param xapth
	 *            - xpath of the webtable
	 * @param value
	 *            - value to be checked in table header
	 */
	public boolean checkTableHeaderContains(WebDriver driver, String xpath, String value) {
		int cnt = 0;
		try {
			WebElement htmltable = driver.findElement(By.xpath(xpath));

			List<WebElement> allRows = htmltable.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));

				// Print the contents of each cell
				for (WebElement cell : cells) {
					if (cell.getText().contains(value)) {
						cnt = 1;
						break;
					}

				}
				if (cnt == 1) {
					break;
				}

			}

			if (cnt == 1) {
				logPassedStepToReportWithScreenshot(driver, value + " header exists in table");
				return true;
			} else {
				logFailedStepToReport(Test, value + " header does not exists in table");
			}

		} catch (Exception e) {
			logFailedStepToReport(Test, value + " header does not exists in table" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * Method to get the entire table content
	 * 
	 * @param xpath
	 *            - xpath of the webtable
	 * @return
	 */
	public String getTableContent(WebDriver driver, String xpath) {
		StringBuilder builder = new StringBuilder();
		WebElement table = driver.findElement(By.xpath(xpath));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				builder.append(cell.getText());
			}

		}
		String content = builder.toString();
		if (content.length() > 1) {
			return content;
		} else {
			return "No data in table";
		}
	}

	/**
	 * Authenticate user pop-up Window
	 * 
	 * @param parentWindow
	 * @param handle
	 * 
	 */

	public void authenticateUserWindow(WebDriver driver, String username, String password) {

		String parentWindow = driver.getWindowHandle();
		logger.info("Switching to new window");

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.contains(parentWindow)) {
				// Switch to popup
				driver.switchTo().window(handle);

				// Pass user Id and Password
				driver.findElement(By.id("Username")).sendKeys(username);
				driver.findElement(By.id("Password")).sendKeys(password);
				driver.findElement(By.name("btnLogin")).click();
			}
		}
	}

	/**
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	

	/**
	 * Decrypt a base64 encrypted string and return the decrypted String
	 * 
	 * @param decodedText
	 * @param decodedString
	 * @return decodedText
	 * 
	 */
	public String decryptText(String text) {

		// Decrypt Text
		byte[] decodedText = Base64.decodeBase64(text);

		return new String(decodedText);
	}

	/**
	 * Encrypt text Users can use this to encrypted text and add it to data sheet
	 * for sensitive data
	 * 
	 * @param encodedString
	 * @param encodedString
	 * @return encodedText
	 * 
	 */
	public String encryptText(String text) {

		// Encrypt Text
		byte[] encodedText = Base64.encodeBase64(text.getBytes());
		logger.log(Level.INFO, "Encrypted Text: {0}", new String(encodedText));
		return new String(encodedText);
	}

	/**
	 * Reads and provides the value of the an attribute specified for a specific
	 * object
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param attribute
	 *            - the name of the attribute whose text value you wish to return
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return the value of that attribute
	 */
	public String getAttribute(WebDriver driver, String locatorKey, String type, String attribute) {
		return getElement(driver, locatorKey, type).getAttribute(attribute);
	}

	/**
	 * Select a DropDown Value by the visible Test
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param data
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 * @throws IOException
	 */
	public void selectDropDownByVisibleText(WebDriver driver, String locatorKey, String data, String type)
			throws IOException {
		try {
			Select s = new Select(getElement(driver, locatorKey, type));
			s.selectByVisibleText(data);
			logger.info("Select Dropdown By Text: " + locatorKey + data);
		} catch (Exception e) {
			logger.info("Select Dropdown By Text Failed: " + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver,
					" Select DropDown By Text Failed: " + locatorKey + e.getMessage());
		}
	}

	/**
	 * Select a Dropdown element by value
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param value
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 */
	public String selectDropdownElementByValue(WebDriver driver, String locatorKey, String type, String value) {
		Select s = new Select(getElement(driver, locatorKey, type));
		s.selectByValue(value);
		return value;
	}

	/**
	 * Select a DropDown Value for specified index value
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param index
	 *            - drop down index value
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 * @author Enrollment Team MG
	 * @throws IOException
	 */
	public void selectDropdownElementgetValues(WebDriver driver, String locatorKey, String type) {
		Select s = new Select(getElement(driver, locatorKey, type));
		List<WebElement> all=s.getAllSelectedOptions();
		int size=all.size();
		for(int i=0;i<size;i++){
			String text = all.get(i).getText();
			System.out.println(text);
			ExtentReport.Test.log(Status.INFO,"Element selected: "+text);
		}
//		return value;
	}

	public void selectDropDownByIndex(WebDriver driver, String locatorKey, int index, String type) throws IOException {
		try {
			Select s = new Select(getElement(driver, locatorKey, type));
			s.selectByIndex(index);
			logger.info("DropDown Selected :" + index);
		} catch (Exception e) {
			logger.info("DropDown Not Selelcted :" + locatorKey + index);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "DropDown Not Selelcted :" + e.getMessage());
		}
	}

	/**
	 * Select DropDown Default Value (i.e.firstvalue in drop down - index(0))
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 * @author Enrollment Team MG
	 * @throws IOException
	 */
	public void selectDropDownDefaultValue(WebDriver driver, String locatorKey, String type) throws IOException {

		try {

			Select s = new Select(getElement(driver, locatorKey, type));
			s.selectByIndex(0);

			logger.info("Selected Default Value For:" + locatorKey);

		}

		catch (Exception e) {

			logger.info("DropDown DefaultValue Not Selected :" + locatorKey);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "DropDown DefaultValue Not Selected :" + e.getMessage());

		}

	}

	/**
	 * Select a Dropdown element by value using Java Script Executor
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param value
	 *            - attribute value
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return
	 * @author Enrollment Team MG
	 */
	public void javascriptExecutorDropdownSelect(WebDriver driver, String locatorKey, String type, String value) {

		WebElement select = getElement(driver, locatorKey, type);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var select = arguments[0]; " + "for(var i = 0; i < select.options.length; i++)"
				+ "{ if(select.options[i].text == arguments[1])" + "{ select.options[i].selected = true;} " + "}",
				select, value);

	}

	/**
	 * Reads and provides the value of the Drop Down for specified index
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param index
	 *            - index value
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return String - DropDown Value
	 * @author Enrollment Team MG
	 * @throws IOException
	 */
	public String getDropDownValueByIndex(WebDriver driver, String locatorKey, int index, String type)
			throws IOException {

		String dropdownvalue = null;

		try {

			Select s = new Select(getElement(driver, locatorKey, type));
			dropdownvalue = s.getOptions().get(index).getText();

			logger.info("Index Is: " + index);
			logger.info("DropDown Value Is: " + dropdownvalue);

		} catch (Exception e) {

			logger.info("DropDown Value Doesnt Exist For:" + index);
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "DropDown Value Doesnt Exist :" + e.getMessage());

		}

		return dropdownvalue;

	}

	/**
	 * Reads and provides the Default value/first value from the Drop Down
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param index
	 *            - index value
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return String - First value in the DropDown
	 * @author Enrollment Team MG
	 * @throws IOException
	 */
	public String getDropDownDefaultValue(WebDriver driver, String locatorKey, String type) throws IOException {

		String defaultvalue = null;

		try {

			Select s = new Select(getElement(driver, locatorKey, type));
			defaultvalue = s.getFirstSelectedOption().getText();

			logger.info("DropDown Default Value Is:" + defaultvalue);

		} catch (Exception e) {

			logger.info("DropDown Default Value Doesnt Exist :");
			logger.warning(e.getMessage());
			logFailedStepToReportWithScreenshot(driver, "DropDown Default Value Doesnt Exist :" + e.getMessage());

		}
		return defaultvalue;

	}

	/**
	 * Reads the size of the DropDown and provides all values from the Drop Down
	 * 
	 * @param locatorKey
	 *            - string name set in the java file for a web element
	 * @param data
	 *            - DropDown Value
	 * @param type
	 *            - string to tell which type of locator is being passed in
	 *            supported types: (id, name, classname, linktext, xpath,
	 *            cssselector)
	 * @return String - DropDown Values
	 * @author Enrollment Team MG
	 */
	public String[] getDropDownValues(WebDriver driver, String locatorKey, String type) {

		Select s = new Select(getElement(driver, locatorKey, type));

		List<WebElement> selectOptionValue = s.getOptions();
		int size = selectOptionValue.size();

		logger.info("DropDown Box Size Is:" + size);

		String[] value = new String[size];

		for (int i = 0; i < size; i++) {
			value[i] = selectOptionValue.get(i).getText();
			logger.info("DropDown Value Is:" + value[i]);
		}

		return value;

	}

	/**
	 * Switches to and accepts an alert
	 */
	public void acceptAlert(WebDriver driver) {
		Alert at = driver.switchTo().alert();
		at.accept();
		logger.info("Alert Accepted");

	}

	/**
	 * Highlight an element
	 */

	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	/**
	 * This takes a passing message and outputs it to the report
	 * 
	 * @param test
	 *            - test parameter to be used by extent report
	 * @param passMsg
	 *            - String message to be displayed for pass
	 * @throws IOException
	 * @throws Exception
	 */
	public void logPassedStepToReportWithScreenshot(WebDriver driver, String passMsg) throws IOException {
//		ExtentReport.Test.log(Status.PASS, passMsg);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
//		String A = capture(driver,"Passed Login_Step" + timestamp);
//		ExtentReport.Test.log(Status.PASS,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));
//		String A = takeScreenShotAsBase64(driver, "Passed Login_Step" + timestamp);
//		ExtentReport.Test.addScreenCaptureFromPath(A);
		
		ExtentReport.Test.log(Status.PASS, passMsg);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
		String A = takeScreenShotAsBase64(driver, "Passed Login_Step" + timestamp);
		String B = capture(driver,"Passed Login_Step" + timestamp);
//		ExtentReport.Test.addScreenCaptureFromPath(A);
//		ExtentReport.Test.log(Status.PASS,"" + ExtentReport.Test.addScreenCaptureFromBase64String(A));

		ExtentReport.Test.log(Status.PASS,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));

	}
	
	/**
	 * This takes a passing message and outputs it to the report
	 * 
	 * @param test
	 *            - test parameter to be used by extent report
	 * @param passMsg
	 *            - String message to be displayed for pass
	 * @throws IOException
	 * @throws Exception
	 */
	public void logPassedStepToReportWithScreenshotwithmsg(WebDriver driver,String passMsg, WebElement elmerrmsgcov) throws IOException {
//		ExtentReport.Test.log(Status.PASS, passMsg);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
//		String A = capture(driver,"Passed Login_Step" + timestamp);
//		ExtentReport.Test.log(Status.PASS,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));
//		String A = capturewithmessage(driver,passMsg,elmerrmsgcov) ;
//		ExtentReport.Test.addScreenCaptureFromPath(A);
		
		ExtentReport.Test.log(Status.PASS, passMsg);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
		String A = takeScreenShotAsBase64(driver, "Passed Login_Step" + timestamp);
//		ExtentReport.Test.addScreenCaptureFromPath(A);
		String B = capture(driver,"Passed Login_Step" + timestamp);
//		ExtentReport.Test.log(Status.PASS,"" + ExtentReport.Test.addScreenCaptureFromBase64String(A));

		ExtentReport.Test.log(Status.PASS,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));

	}

	/**
	 * This takes a failure message and outputs it to the report
	 * 
	 * @param test
	 *            - test parameter to be used by extent report
	 * @param failMsg
	 *            - String message to be displayed for fail
	 * @param e
	 * @throws IOException
	 * @throws Exception
	 */
	public void logFailedStepToReportWithScreenshot(WebDriver driver, String failMsg) throws IOException {
		logger.warning(failMsg);
		ExtentReport.Test.log(Status.FAIL, failMsg);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
//		String A = capture(driver,"Passed Login_Step" + timestamp);
		String A = takeScreenShotAsBase64(driver, "Passed Login_Step" + timestamp);
//		ExtentReport.Test.addScreenCaptureFromPath(A);
		ExtentReport.Test.log(Status.FAIL,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));
		String B = capture(driver, "Passed Login_Step" + timestamp);
//		ExtentReport.Test.addScreenCaptureFromPath(A);
		driver.close();
		Assert.fail(failMsg);
		
		
	}
	
	/**
	 * This capture screenshot and outputs it to the report
	 * 
	 * @param screenshotname
	 *            - parameter to be used to capture screenshot
	 
	 * @param e
	 * @throws Exception
	 */
	public void logPassedStepToReportWithScreenshotwithmsg_forRegex(WebDriver driver, String passMsg) throws IOException {
//		ExtentReport.Test.log(Status.PASS, passMsg);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
//		String A = capture(driver,"Passed Login_Step" + timestamp);
//		ExtentReport.Test.log(Status.PASS,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));
//		String A = capturewithmessage(driver,passMsg,elmerrmsgcov) ;
//		ExtentReport.Test.addScreenCaptureFromPath(A);

		ExtentReport.Test.log(Status.PASS, passMsg);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String timestamp = new SimpleDateFormat("d-MMM-YY HH-mm-ss").format(new Date());
		String A = takeScreenShotAsBase64(driver, "Passed Login_Step" + timestamp);
		String B = capture(driver,"Passed Login_Step" + timestamp);
//		ExtentReport.Test.addScreenCaptureFromPath(A);
//		ExtentReport.Test.log(Status.PASS,"" + ExtentReport.Test.addScreenCaptureFromBase64String(A));

		ExtentReport.Test.log(Status.PASS,(MediaEntityBuilder.createScreenCaptureFromPath(A).build()));
		
	}
	public static String capture(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Screenshots\\" + screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}
	
	/**
	 * This retrieve the test iteration count from the data sheet
	 * 
	 * @param sheetname
	 *            - parameter to be passed to identify the number of iterations
	 
	 * @param e
	 * @throws IOException,FilloException
	 */

	public static Recordset testcaseCount(String sheetname) throws IOException, FilloException {

		String dataSheetPath = new File(Constants.INPUT_XLS).getCanonicalPath();
		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection(dataSheetPath);
		String filloquery = "Select *from " + sheetname;
		rs = con.executeQuery(filloquery);
		return rs;

	}
	
	public static String capturewithmessage(WebDriver driver,String passMsg, WebElement elmerrmsgcov) {
		
		String dest = System.getProperty("user.dir") + "\\Screenshots\\" + "Screenshot" + ".png";
		Shutterbug.shootPage(driver)
		.highlightWithText(elmerrmsgcov, Color.blue, 3,passMsg,Color.blue, new Font("SansSerif", Font.BOLD, 20))
		.monochrome(elmerrmsgcov)
		.save(dest);

		return dest;
		
	}
	
	public static void capturefullscreen(WebDriver driver,WebElement elm1,WebElement elm2,WebElement elm3) {
		Shutterbug.shootPage(driver)
        .blur(elm1)
        .highlight(elm2)
        .monochrome(elm3)
        .highlightWithText(elm3, Color.blue, 3, "Monochromed logo",Color.blue, new Font("SansSerif", Font.BOLD, 20))
        .highlightWithText(elm2, "Blurred secret words")
        .withTitle("Google home page - " + new Date())
        .withName("home_page")
        .withThumbnail(0.7)
        .save("C:\\testing\\screenshots\\");
	}

}
