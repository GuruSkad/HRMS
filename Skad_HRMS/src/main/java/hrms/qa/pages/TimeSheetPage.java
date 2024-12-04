package hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class TimeSheetPage extends TestBase {

	@FindBy(xpath = "(//div[@class='input-field']//input)[1]")
	private WebElement dateInput;

	@FindBy(xpath = "//a[contains(@class,'col-auto fs-12')]/following-sibling::a[1]")
	private WebElement weeklyTimeSheetButton;

	@FindBy(id = "department_list")
	private WebElement deptID;

	@FindBy(id = "dep_members")
	private WebElement departmentMembers;

	@FindBy(xpath = "//button[contains(@class,'col-auto fs-14')]")
	private WebElement addTask;

	@FindBy(id = "add_project_id")
	private WebElement projectID;

	@FindBy(id = "add_job_id")
	private WebElement selectTask;

	@FindBy(id = "notes")
	private WebElement notes;

	@FindBy(xpath = "(//div[@class='d-flex align-items-center']//input)[3]")
	private WebElement taskCompletedCheckBox;

	@FindBy(id = "start_time")
	private WebElement startTime;

	@FindBy(id = "stop_time")
	private WebElement stopTime;

	@FindBy(id = "addTimesheetBtn")
	private WebElement addSubmitButton;

	public TimeSheetPage() {

		PageFactory.initElements(driver, this);

	}

	public void selectDate() {

		weeklyTimeSheetButton.click();
		String wrFromDat = "11/01/24";
		String wrToDate = "06/01/24";
		setFromAndToDateIfEnabled(dateInput, wrFromDat, wrToDate);
		String fromDate = "11/01/24";
		String toDate = "12/03/24";
		setFromAndToDateIfEnabled(dateInput, fromDate, toDate);

		String s = "Testing";
		selectDropdownByVisibleText(deptID, s);

		String mem = "Testing";
		selectDropdownByVisibleText(departmentMembers, mem);

	}

	public void addingTask() {
//		waitForElementToBeVisible(addTask);
//		addTask.click();
		selectDropdownByValue(projectID, "WSD");
		selectDropdownByValue(selectTask, "General");
		notes.sendKeys("Test Automation");
		taskCompletedCheckBox.click();
		addSubmitButton.click();
	}

}
