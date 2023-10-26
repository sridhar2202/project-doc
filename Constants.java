package library;

public class Constants {
	public static final String INPUT_XLS = System.getProperty("user.dir")+"\\data\\Employer_EnrollmentData.xlsx";
	public static final String REPORT_OUTPUT = System.getProperty("user.dir")+"\\target\\cucumber-reports\\screenshots\\";
	public static final String PASS = "Pass";
	public static final String FAIL = "Fail";
	public static final int MICROWAIT = 400;
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CLASSNAME = "classname";
	public static final String LINKTEXT = "linktext";
	public static final String XPATH = "xpath";
	public static final String CSSSELECTOR = "cssselector";
	public static final String THE_PROVIDED_LOCATOR_IS_NOT_FOUND_AT = "The Provided Locator is not found at: ";

	  private Constants() {
		    throw new IllegalStateException("Utility class");
		  }
}
