package hrms.qa.testcases;

import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
//
	@Test
	public void deleteFunctionality() throws InterruptedException {
		departmentPage = homePage.clickOnDepartmentsLink();
		departmentPage.deleteDept();
	}

//	@Test
//	public void addDepartment() throws InterruptedException {
//		departmentPage.addept();
//		Thread.sleep(3000);
//
//	}

	@Test
	public void addSubDepartment() throws InterruptedException {
	
		departmentPage.addSubDept();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
