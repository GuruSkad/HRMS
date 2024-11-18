package hrms.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	
	@FindBy(xpath = "//input[@type='email']")
	public WebElement userName;
	
	
	@FindBy(xpath ="//input[@type='password']")
	public WebElement password;
	
	
	
	@FindBy(id = "login")
	public WebElement loginButton;
	
	
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M2 4.75C2.')]")
	public WebElement userButton;
	
	
	@FindBy(xpath = "(//small[normalize-space()='Logout'])[1]")
	public WebElement logOutButton;
	
//	placeHolders
	@FindBy(xpath ="//input[@placeholder='Email']")
	public WebElement emailPlaceHolder;
	
	@FindBy(xpath ="//input[@id='password']")
	public WebElement passWordPlaceHolder;
	
	
//	Locators for Forgetpassword
	
	@FindBy(xpath = "(//a[normalize-space()='Forgot Password?'])[1]")
	public WebElement forgetPasswordButton;
	

	
	@FindBy(tagName = "button")
	public WebElement resetButtom;
	
	
//	locators for emptyUserName and emptyPassword
	
	
	@FindBy(xpath = "//label[@id='primary_email-error']")
	public WebElement emptyemailalert;
	
	
	@FindBy(xpath = "//label[@id='password-error']")
	public WebElement emptyPassWordAlert;
	
//	locators for all label validation
	@FindBy(tagName =   "label")
	public List<WebElement> allLabels;
	
	
//	locators for email and password label validation
	
	@FindBy(xpath = "//label[normalize-space()='Email Address']")
	public WebElement emailLabel;
	
	@FindBy(xpath = "(//label[normalize-space()='Password'])[1]")
	public WebElement passWordLabel;
	
//	initializing the page objects 
	
	public LoginPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		 return driver.getTitle();
	
	}
	
	public HomePage login(String un,String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		clickWithFluentWait(loginButton);
		return new HomePage();
		
	}
	
	public void clickLogOutButton() {
		userButton.click();
		logOutButton.click();
	}
	
	
//	 for forgetPassword
	public void clickForgetPassword(String un) {
		forgetPasswordButton.click();
		emailPlaceHolder.sendKeys(un);
		resetButtom.click();
	}
	
//	for emptyUserNameandPassword
	
    public void withoutEmail(String pwd) {
	passWordPlaceHolder.sendKeys(pwd);
	loginButton.click();
    }

    public void withoutPassWord(String un) {
	emailPlaceHolder.sendKeys(un);
	loginButton.click();
    }
	
	public boolean emptyemailalertmsg(String pwd) {
		
		withoutEmail(pwd);
		loginButton.click();
		return emptyemailalert.isDisplayed();
	}
	public boolean emptypwdalert(String un) {
		withoutPassWord(un);
		return emptyPassWordAlert.isDisplayed();
	}

	
//	for emailformat validation
	
	public HomePage inputValidation(String un,String pwd) {
		emailPlaceHolder.sendKeys(un);
		passWordPlaceHolder.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	
	
//	for email and password label validation
	public boolean emaillabelValidation() {
		return emailLabel.isDisplayed();
	
	}
	public boolean passWordlabelValidation() {
		return passWordLabel.isDisplayed();

	}
	
//	for all label validaion
	public List<WebElement> labelNameValidation() {
	   
	    List<WebElement> labels = allLabels;
	 
	    return labels; // Return the collected texts
	}
	   

}
