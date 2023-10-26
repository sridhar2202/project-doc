package library;
import java.util.Map;

import org.openqa.selenium.Rotatable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Reports.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import library.DriverFactory;

public class DriverFactory {
	public DriverFactory()
	{
		
	}
	private static DriverFactory instance = new DriverFactory();
	public static DriverFactory getinstance()
	{
		return instance;
	}
	
	protected String testname;
	protected Map<String, String> testData;
	public WebDriver driver = null;

	private static ExtentReports extent;
	public static ExtentTest Test;
	protected Rotatable augmentedDriver;
	protected DesiredCapabilities capabilities = new DesiredCapabilities();
	protected int counter = 1;
	ReusableComponents_sk reusecomp = new ReusableComponents_sk();
	
	//Added///////////
	
	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("driver", driver);

        return iTestContext;
    }
	
	@BeforeClass
	public  WebDriver Chromesetup()
	{
		ChromeOptions chromeptions=new ChromeOptions();
		WebDriverManager.chromedriver().clearResolutionCache().setup();
		driver=new ChromeDriver(chromeptions);
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver Edgesetup()
	{
		EdgeOptions edgeoptions=new EdgeOptions();
		WebDriverManager.edgedriver().clearResolutionCache().setup();
		driver=new EdgeDriver(edgeoptions);
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver Firefoxsetup()
	{
		FirefoxOptions firefoxoptions=new FirefoxOptions();
		WebDriverManager.firefoxdriver().clearResolutionCache().setup();
		driver= new FirefoxDriver(firefoxoptions);
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver Operasetup()
	{
		OperaOptions operaoptions=new OperaOptions();
		WebDriverManager.operadriver().clearResolutionCache().setup();
		driver= new OperaDriver(operaoptions);
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver IEsetup()
	{
		InternetExplorerOptions ieoptions=new InternetExplorerOptions();
		ieoptions.introduceFlakinessByIgnoringSecurityDomains();
		ieoptions.requireWindowFocus();
		ieoptions.disableNativeEvents();
		WebDriverManager.iedriver().clearResolutionCache().setup();
		driver= new InternetExplorerDriver(ieoptions);
		driver.manage().window().maximize();
		return driver;
	}
	
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
	public void quitDriver() {
		sleep(20);
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
	
}
