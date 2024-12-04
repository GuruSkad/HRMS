package hrms.qa.testcases;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.qa.base.TestBase;
import hrms.qa.pages.DashBoardPage;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;

public class DashBoardTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	DashBoardPage dashBoardPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	public static Method method;

	public DashBoardTest() {
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
	public void setup(Method method) {
		
		initialization();
		logger = extent.createTest(method.getName());
		loginPage = new LoginPage();
		dashBoardPage = new DashBoardPage();
		loginPage.login(username, password);
	}

	@Test
	public void tes() {
		List<String> v = dashBoardPage.getvalues();
		for (String vs : v) {
			System.out.println(vs);
		}
	}

	@Test
	public void GetValues() {
		dashBoardPage.getAllCounts();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		// Close the browser after each test execution
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + "- Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "- Test Case Skippd", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test Case Pass", ExtentColor.GREEN));
		}
		driver.quit();
		System.out.println("Browser closed successfully.");
	}
	
	@AfterTest
	public void afterTest() {
	    // Ensure the report is written to the file
	    if (extent != null) {
	        extent.flush();
	    }
	}
}
