package hrms.qa.testcases;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
