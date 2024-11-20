package hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class DepartmentsPage extends TestBase {

	@FindBy(xpath = "(//button[@class='col-auto fs-12 font-weight-500 btn-primary ms-0 mb-2 mb-sm-2 mb-md-2 mb-lg-2 button-radius'])[1]")
	private WebElement addDepartment;

	@FindBy(xpath = "//td[contains(text(),17)]//preceding-sibling::td/div/input")
	private WebElement deleteDepartment;

	@FindBy(xpath = "(//td)[5]")
	private WebElement clickAction;

	@FindBy(id = "department_delete9be63901-3e10-4b9e-bc05-83565172da51")
	private WebElement delete;

	@FindBy(id = "dept_nme")
	private WebElement enterDepartment;

	@FindBy(xpath = "//form[@id='department-add-form']//input[@placeholder='Enter Department Code']")
	private WebElement enterDeptCode;

	@FindBy(css = "form[id='department-add-form'] button[name='submit']")
	private WebElement submit;

	@FindBy(xpath = "//a[normalize-space()='Sub Department']")
	private WebElement addSub;

	@FindBy(css = ".col-auto.fs-12.font-weight-500.btn-primary.ms-0.mb-2.mb-sm-2.mb-md-2.mb-lg-2.button-radius.Add-new-sub-dept")
	private WebElement addsubdepartmentbtn;
	
	@FindBy(id = "department_id")
	private WebElement deptID;
	
	@FindBy(css="form[id='add-subdepartment-form'] input[placeholder='Enter Sub Department Name']")
	private WebElement enterDeptName;
	
	 @FindBy(xpath = "//form[@id='add-subdepartment-form']//input[@placeholder='Enter Sub Department Code']")
	 private WebElement enterSubDeptCode;
	 
	 @FindBy(css="form[id='add-subdepartment-form'] button[name='submit']")
	 private WebElement subDeptSubmitButton;
	 
	public DepartmentsPage() {
		PageFactory.initElements(driver, this);
	}

	public void depclick() {
		waitForElementToBeClickable(addDepartment);
	}

	public void deleteDept() {
		deleteDepartment.click();
		waitForElementToBeClickable(clickAction);
		clickAction.click();

		waitForElementToBeClickable(delete);
		delete.click();

	}

	public void addept() {
		addDepartment.click();
		enterDepartment.sendKeys("Qa Engineer");
		enterDeptCode.sendKeys("1234");
		submit.click();
	}

	public void addSubDept()  {
		
		waitForElementToBeClickable(addSub);

		addSub.click();
		waitForElementToBeClickable(addsubdepartmentbtn);
		addsubdepartmentbtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s="Qa Engineer";
		selectDropdownByVisibleText(deptID, s);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterDeptName.sendKeys("Testing with automation");
		enterSubDeptCode.sendKeys("12345");
		subDeptSubmitButton.click();

		
	}
}
