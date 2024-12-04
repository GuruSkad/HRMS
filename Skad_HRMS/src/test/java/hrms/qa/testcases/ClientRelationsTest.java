package hrms.qa.testcases;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.qa.base.TestBase;
import hrms.qa.pages.ClientRelationsPage;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;

public class ClientRelationsTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ClientRelationsPage clientRelationsPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	public ClientRelationsTest() {
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
			clientRelationsPage = homePage.clickOnClientRelationsLink();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void addclient() {
		List<String> msg = clientRelationsPage.checkAlreadyExists();
		for (String messages : msg) {
			System.out.println(messages);
		}
	}

	@Test
	public void errorMsgValidation() {
		List<String> msg = clientRelationsPage.errorMsg();
		for (String messages : msg) {
			System.out.println(messages);
		}
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser after each test execution
		driver.quit();
		System.out.println("Browser closed successfully.");
	}
}
