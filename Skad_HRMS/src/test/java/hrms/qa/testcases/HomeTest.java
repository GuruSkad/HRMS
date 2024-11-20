package hrms.qa.testcases;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrms.qa.base.TestBase;
import hrms.qa.pages.DepartmentsPage;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;

public class HomeTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	public HomeTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(username, password);
	}

	@Test
	public void testBrokenLinks() {
		// Find all URLs on the page
		homePage = loginPage.login(username, password);
		
		
		List<String> urls = homePage.findBrokenLink();
		System.out.println("Total links found: " + urls.size());

		// Check each URL for broken links
		checkBrokenLinks(urls);
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser after each test execution
		driver.quit();
		System.out.println("Browser closed successfully.");
	}
}
