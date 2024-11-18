package hrms.qa.testcases;

import org.testng.annotations.BeforeMethod;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;
import hrms.qa.pages.RolePage;
import hrms.qa.pages.UserAdministrationPage;

public class RoleTest  extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	UserAdministrationPage userAdministrationPage;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
RolePage rolePage;
	
	public RoleTest() {
	super();
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

	
	
}
