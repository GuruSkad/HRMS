package hrms.qa.testcases;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.qa.base.TestBase;
import hrms.qa.pages.DepartmentsPage;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;

public class DepartmentTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DepartmentsPage departmentPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	public DepartmentTest() {
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
			departmentPage = homePage.clickOnDepartmentsLink();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
//	public void deleteFunctionality() throws InterruptedException {
//		departmentPage = homePage.clickOnDepartmentsLink();
//		departmentPage.deleteDept();
//	}

	@Test
	public void addDepartment() throws InterruptedException {
		departmentPage.addept();
		Thread.sleep(3000);

	}

	@Test
	public void addSubDepartment() throws InterruptedException {

		departmentPage.addSubDept();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
