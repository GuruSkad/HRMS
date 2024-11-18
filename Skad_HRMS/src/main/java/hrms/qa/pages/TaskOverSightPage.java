package hrms.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class TaskOverSightPage extends TestBase {

	@FindBy(xpath = "(//button[@class='fs-12 font-weight-500 btn-primary button-radius add_task_btn'])[1]")
	private WebElement addTask;

//	@FindBy(css = ".fs-12.font-weight-500.btn-primary.button-radius.add_task_btn")
//	private WebElement addTask;
//	
	@FindBy(id = "job_name")
	private WebElement enterName;

	@FindBy(id = "description")
	private WebElement description;

	@FindBy(id = "project_id")
	private WebElement selectProject;

	@FindBy(id = "SelectOpen")
	private WebElement addPeople;

	@FindBy()
	private WebElement attachFile;

	@FindBy(css = "#start_date")
	private WebElement startDate;

	@FindBy(id = "end_date")
	private WebElement endDate;

	@FindBy(id = "due_date")
	private WebElement dueDate;

	@FindBy(id = "add_task_ticketid")
	private WebElement ticketID;

	@FindBy(id = "estimate_hours")
	private WebElement estimatedHours;

	@FindBy(id = "task_status")
	private WebElement selectStatus;

	@FindBy(id = "priority")
	private WebElement priority;

	@FindBy(id = "stage_add_task")
	private WebElement labelName;

	@FindBy(xpath = "//form[@id='AddTaskForm']//button[@name='submit']")
	private WebElement submit;

	public TaskOverSightPage() {
//	this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createTask() {
		waitForElementToBeClickable(addTask);
		addTask.click();
		enterName.sendKeys("TaskCREation");
		description.sendKeys("bfdakjrlqbliualiurohfrwq");
		String value = "WSD";
		selectDropdownByVisibleText(selectProject, value);
		String stDate = "11/30/2024";
		startDate.sendKeys(stDate);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('value','" + stDate + "');", startDate);
		String status = "Testing";
		selectDropdownByVisibleText(selectStatus, status);
		submit.click();

	}

}
