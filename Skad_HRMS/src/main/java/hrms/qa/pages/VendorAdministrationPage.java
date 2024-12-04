package hrms.qa.pages;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class VendorAdministrationPage extends TestBase {
	UserPage userPage;

	@FindBy(css = "//a[@href='https://skad.timetracks.us/vendor/add']")
	private WebElement addVendor;

	@FindBy(id = "employee_name")
	private WebElement employeeName;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "country_id")
	private WebElement countryID;

	@FindBy(id = "state_id")
	private WebElement stateID;

	@FindBy(id = "city_id")
	private WebElement cityID;

	@FindBy(id = "pin_code")
	private WebElement pinCode;

	@FindBy(id = "address")
	private WebElement pAddress;

	public VendorAdministrationPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickvendor(String empName, String mob, String eml, String contryId, String stateId, String ctyId,
			String pcode, String paddress) {

		addVendor.click();
		employeeName.sendKeys(empName);
		mobile.sendKeys(mob);
		email.sendKeys(eml);
		selectDropdownByVisibleText(countryID, contryId);
		selectDropdownByVisibleText(stateID, stateId);
		selectDropdownByVisibleText(cityID, ctyId);
		pinCode.sendKeys(pcode);
		pAddress.sendKeys(paddress);
	}
}
