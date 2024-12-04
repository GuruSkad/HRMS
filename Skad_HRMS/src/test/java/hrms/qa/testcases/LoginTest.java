package hrms.qa.testcases;

import java.io.File;
import java.lang.System.Logger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	public LoginTest() {
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

	}

// launching browser before every test case and login
//	closing the browser after every test case

	@Test
	public void loginWithOutEmail() {

		boolean alertDisplayed = loginPage.emptyemailalertmsg(password);
		System.out.println("Empty Email Alert Displayed: " + alertDisplayed);
		Assert.assertTrue(alertDisplayed, "Expected alert for missing email was not displayed.");
		System.out.println("login WithOut UserName Validated");

	}

	@Test
	public void loginWithoutPassword() {

		boolean alertDisplayed = loginPage.emptypwdalert(username);
		System.out.println("Empty Password Alert Displayed: " + alertDisplayed);
		Assert.assertTrue(alertDisplayed, "Expected alert for missing password was not displayed.");
		System.out.println("login WithOut Password Validated");
	}

	@Test
	public void verifyBackButton() {

		homePage = loginPage.login(username, password);

		// Get the current URL after login
		String currentUrl = driver.getCurrentUrl();

		// Navigate back to the previous page (login page)
		driver.navigate().back();

		// Get the URL after navigating back
		String loggedUrl = driver.getCurrentUrl();

		// Assert that the URLs are not the same (login page vs logged-in page)
		Assert.assertNotEquals(currentUrl, loggedUrl, "Test failed: Back button did not redirect to login page");

		// Print success message
		System.out.println("Back button validated successfully.");

	}

	@Test
	public void invalidCredentialsValidation() {

		String userID = "9159@91.com";
		String passWord = "9159@91.com";
		homePage = loginPage.inputValidation(userID, passWord);
		System.out.println("invalid Credentials Validation completed");

	}

	@Test
	public void InvalidemailValidation() {

		try {
			boolean alertDisplayed = loginPage.emptyemailalertmsg(password);
			System.out.println("Invalid Email Alert Displayed: " + alertDisplayed);
			Assert.assertTrue(alertDisplayed, "Expected alert for missing email was not displayed.");
			System.out.println("An Exception druring Invalid email Validation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void validateLabelTextsAndVisibility() {

		List<WebElement> labelTexts = loginPage.labelNameValidation();

		List<String> texts = new ArrayList<String>();
		for (WebElement element : labelTexts) {
			String text = element.getText();
			texts.add(text);
		}
		for (String label : texts) {
			System.out.println("Label Text: " + label);
		}
	}

	@Test
	public void testResetPassword() {

		loginPage.clickForgetPassword(username);
		System.out.println("Reset Validation Completed");
	}

	@Test

	public void loginvalidation() {

		// Perform login and navigate to home page
		homePage = loginPage.login(username, password);
		System.out.println("login Validation completed");

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
