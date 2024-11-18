package hrms.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;
import hrms.qa.pages.TaskOverSightPage;

public class TaskOverSightTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TaskOverSightPage taskOverSightPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	public TaskOverSightTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		try {
			initialization();
			loginPage = new LoginPage();
			homePage = loginPage.login(username, password);
			taskOverSightPage = homePage.clickOnTaskOverSightPageLink();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testteask() {
//		homePage.clickOnTaskOverSightPageLink();
		taskOverSightPage.createTask();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
