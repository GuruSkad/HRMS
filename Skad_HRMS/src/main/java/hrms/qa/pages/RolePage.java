package hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class RolePage extends TestBase {

//	locators for add people
	@FindBy(id = "add_role")
	private WebElement addRole;

	@FindBy(xpath = "//input[@placeholder='Enter user role']")
	private WebElement enterRole;
	@FindBy(xpath = "(//span[contains(@class,'btn btn-white')]/following-sibling::button)[1]")
	private WebElement clickadd;
	
	@FindBy(id ="user_role-error")
	private WebElement roleError;
	
	 @FindBy(css="form[id='form-user-role-new'] span[class='fs-14']")
	 private WebElement subtn;
	 
	
	//span[text()=' Dashboard']/following::td[1]//div/input
	public RolePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickaddRole() {
		addRole.click();
		enterRole.sendKeys("QA Automation Engineeer");
		waitForElementToBeClickable(clickadd);
		clickadd.click();
	}
	public String withoutValue() {
		addRole.click();
		subtn.click();
		boolean result=roleError.isDisplayed();
		if(result==true) 
		return roleError.getText();
		return null;
		
	}

}
