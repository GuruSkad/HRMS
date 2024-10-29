package hrms.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrms.qa.base.TestBase;
import hrms.qa.pages.HomePage;
import hrms.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	 String username = prop.getProperty("username"); 
	 String password = prop.getProperty("password");
	
	public LoginTest(){
		super();
	}
	

	@BeforeMethod
	public void setup() {
		initialization();
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
	
		String userID="9159@91.com";
		String passWord="9159@91.com";
		homePage=loginPage.inputValidation(userID,passWord);
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

            List<String> texts= new ArrayList<String>();
	        for(WebElement element : labelTexts) {   
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
public void tearDown() {
    // Close the browser after each test execution
    driver.quit();
    System.out.println("Browser closed successfully.");
}
}
