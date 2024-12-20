package hrms.qa.testcases;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.internal.Console;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;
import hrms.qa.pages.UserAdministrationPage;
import hrms.qa.pages.UserPage;
import hrms.qa.util.TestUtil;

public class UserTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	UserPage userPage;
	UserAdministrationPage userAdministrationPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	String sheetName = "Data";
	

	public UserTest() {
		super();
	}
	
	@BeforeTest
	public static void beforeTestMethod() {

		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "HRMSExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Test Results for HRMS");
	}
	
	@BeforeMethod
	public void setup(Method method ) {
		try {
			initialization();
			logger = extent.createTest(method.getName());
			loginPage = new LoginPage();
			homePage = loginPage.login(username, password);
			userAdministrationPage = homePage.clickOnUserAdministrationPageLink();
			userPage = homePage.clickOnAddUserPageLink();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getADDUSERTestData() {
		
		try {
			Object data[][] = TestUtil.addTestData(sheetName);
			if (data == null) {
				throw new RuntimeException("Data provider returned null");
			}
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	
//	@Test(dataProvider = "getADDUSERTestData")
//	public void  doLogi(String fName, String lName, String empID,String dob,String doj,
//			String gender,String Mob,String omail,String pmail,String ctry,String stat,String cty,String pcode,
//			String padd,String tadd,String jbtitle,String dptmt,String subDept,
//			  String emptype,String empthrogh,String woMode,String woLocation,
//			  String vendor,String billType,String timeZone) {
//		try {
//		
//			userPage.clickAddPeople();
//			userPage.createPersonalDetails(fName, lName, empID,dob,doj,gender,Mob,omail,pmail,ctry,stat,cty,pcode,padd,tadd,
//					jbtitle,dptmt,subDept,emptype,empthrogh,woMode,woLocation,vendor,billType,timeZone);
//			Assert.assertEquals(fName, null);
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Test
	public void fileUpload() {
		userPage.clickAddPeople();
		userPage.uploadFile();
	}

//@Test
//public void withOutValues() {
//	try {
//		userPage.clickAddPeople();		
//		userPage.withoutValuesValidation();	
//		System.out.println("without values completed");
//		
//	} catch (Exception e) {
//		
//		e.printStackTrace();
//	}
//}
//
//@Test
//public void getAllOption() {
//userPage.clickAddPeople();
//	List<WebElement> allDropdownOptions = userPage.getAllDropdownOptions();
//	for (WebElement option : allDropdownOptions) {
//	    System.out.println(option.getText()); // Print the text of each dropdown option
//	}
//	
//}



	@AfterMethod
	public void tearDown() {
		// Close the browser after each test execution
		driver.quit();
		System.out.println("Browser closed successfully.");
	}

}
