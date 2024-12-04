package hrms.qa.testcases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;
import hrms.qa.pages.RolePage;
import hrms.qa.pages.UserAdministrationPage;

public class RoleTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	UserAdministrationPage userAdministrationPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	RolePage rolePage;

	public RoleTest() {
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
			userAdministrationPage = homePage.clickOnUserAdministrationPageLink();
			rolePage = homePage.clickOnRolePageLink();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void addRole() {
		try {
			System.out.println("successfully completed");
			rolePage.clickaddRole();
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void validation() {
		String value = rolePage.withoutValue();
		Assert.assertEquals(value, "This field is required.");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
