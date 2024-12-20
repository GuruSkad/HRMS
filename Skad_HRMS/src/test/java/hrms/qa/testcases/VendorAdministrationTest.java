package hrms.qa.testcases;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;
import hrms.qa.pages.UserPage;
import hrms.qa.pages.VendorAdministrationPage;
import hrms.qa.util.TestUtil;

public class VendorAdministrationTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	UserPage userPage;
	VendorAdministrationPage vendorAdministrationPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	String sheetName = "VendorAdministration";

	public VendorAdministrationTest() {
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
	public void setup() {
		try {
			initialization();
			loginPage = new LoginPage();
			homePage = loginPage.login(username, password);
			vendorAdministrationPage = homePage.clickOnVendorAdministrationLink();

		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	@Test(dataProvider = "getADDUSERTestData")
	public void createVendor(String empName, String mob, String eml, String contryId, String stateId, String ctyId,
			String pcode, String paddress) {
		vendorAdministrationPage.clickvendor(empName, mob, eml, contryId, stateId, ctyId, pcode, paddress);

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser after each test execution
		driver.quit();
		System.out.println("Browser closed successfully.");
	}

}
