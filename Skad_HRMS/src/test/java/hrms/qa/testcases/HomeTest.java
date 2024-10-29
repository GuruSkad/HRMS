package hrms.qa.testcases;

import org.testng.annotations.BeforeMethod;

import hrms.qa.base.TestBase;
import hrms.qa.pages.LoginPage;

public class HomeTest extends TestBase {
	
	
	LoginPage loginPage;
	public HomeTest() {
	super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		 loginPage = new LoginPage();
	}


}
