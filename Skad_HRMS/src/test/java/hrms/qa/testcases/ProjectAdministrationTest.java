package hrms.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;
import hrms.qa.pages.ProjectAdministrationPage;
import hrms.qa.util.TestUtil;

public class ProjectAdministrationTest extends TestBase {

	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	LoginPage loginPage;
	HomePage homePage;
	ProjectAdministrationPage projectAdministrationPage;
	String sheetName = "ProjectData";

	public ProjectAdministrationTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		try {
			initialization();
			loginPage = new LoginPage();
			homePage = loginPage.login(username, password);
			projectAdministrationPage = homePage.clickOnProjectAdministrationPageLink();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	@DataProvider
	public Object[][] getADDUSERTestData() {
		
		try {
			Object data[][] = TestUtil.addTestData(sheetName);
			if (data == null) {
				throw new RuntimeException("Data provider returned null");
			}
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Test(dataProvider = "getADDUSERTestData")
	public void  createProject( String projno, String proName, String proType, String dept, String vend,
			String sbDept, String memb, String proManag, String clName, String proDesc, String projURL, String proSOD,
			String proEOD, String duDate,String prio,String notify,String  estHours,String dDate) {
		try {
			projectAdministrationPage.checkProjects();
			projectAdministrationPage.addProjectdetails(projno, proName, proType, dept, vend, sbDept,
					memb, proManag, clName, proDesc, projURL, proSOD, proEOD, duDate, prio, notify, estHours, dDate);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	@AfterMethod
//	public void tearDown() {
//		// Close the browser after each test execution
//		driver.quit();
//		System.out.println("Browser closed successfully.");
//	}

}
