package library;
	
import java.util.Map;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Reports.ExtentReport;

public class TestCaseDriver {
	protected String testname;
	protected Map<String, String> testData;
	public WebDriver driver = null;

	private static ExtentReports extent;
	public static ExtentTest Test;
	protected Rotatable augmentedDriver;
	protected DesiredCapabilities capabilities = new DesiredCapabilities();
	protected int counter = 1;
	ReusableComponents_sk reusecomp = new ReusableComponents_sk();

	public TestCaseDriver() {
	}

	public static void sleep(long millis) {
		try {
		Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	public void quitDriver() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Map<String, String> getTestData() {
		return testData;
	}

	public Rotatable getAugmentedDriver() {
		return augmentedDriver;
	}

	/**
	 * This takes a skip message and outputs it to the report
	 * 
	 * @param test
	 *            - test parameter to be used by extent report
	 * @param skipMsg
	 *            - String message to be displayed for skip
	 * @throws Exception
	 */
	public void reportingSkip(ExtentTest test, String skipMsg) {
		ExtentReport.Test.log(Status.SKIP, skipMsg);
		extent.flush();
	}

	public Map<String, String> readExcel(String testname) {
		// Set-up test variable for run execution report
		Map<String, String> testData = reusecomp.getData(Constants.INPUT_XLS, "Config", testname);
		reusecomp.logger.info("test data read" + testname);
		// Check to see if this test is skipped
		if (testData.get("Skip Test").equalsIgnoreCase("Y")) {
			reportingSkip(reusecomp.Test, "This test was skipped");
			throw new SkipException("Skipped Test");
		}
		reusecomp.logger.info("Data has been read");
		return testData;
	}
}
