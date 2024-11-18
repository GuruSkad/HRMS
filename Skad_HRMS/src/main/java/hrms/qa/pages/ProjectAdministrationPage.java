package hrms.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hrms.qa.base.TestBase;

public class ProjectAdministrationPage extends TestBase {

	@FindBy(xpath = "//a[@class='disableunderline']")
	private WebElement addProject;

	@FindBy(xpath = "//input[@name='logo']")
	private WebElement uploadLogo;

	@FindBy(id = "project_number")
	private WebElement projectNumber;

	@FindBy(id = "project_name")
	private WebElement projectName;

	@FindBy(xpath = "//select[@id='project_type']")
	private WebElement projectType;

	@FindBy(id = "departments")
	private WebElement department;

	@FindBy(xpath = "//select[@id='vendor']")
	private WebElement Vendor;

	@FindBy(id = "sub_department")
	private WebElement subDepartment;

	@FindBy(id = "members")
	private WebElement members;

	@FindBy(xpath = "//select[@id='project_manager']")
	private WebElement projectManager;

	@FindBy(id = "client_name")
	private WebElement clientName;

	@FindBy(id = "project_description")
	private WebElement projectDescription;

	@FindBy(id = "ticket_url")
	private WebElement jiraProjectURl;

	@FindBy(id = "start_date")
	private WebElement startDate;

	@FindBy(id = "end_date")
	private WebElement endDate;

	@FindBy(id = "priority")
	private WebElement priority;

	@FindBy(id = "notify_at")
	private WebElement notifyAt;

	@FindBy(id = "estimated_hours")
	private WebElement estimatedHoursdDate;

	@FindBy(id = "dueDate")
	private WebElement dueDate;

	@FindBy(css = ".drop-zone-svg-icon")
	private WebElement clickToUpload;

	@FindBy(css = "button[class='btn btn-primary btn-primary-submit sw_project_added']")
	private WebElement SubmitButton;

//	locators for currentProject 
	@FindBy(css = "a[role='tab'][type='1']")
	private WebElement currentProjects;

//	locators for upcomming project 
	@FindBy(css = "a[role='tab'][type='2']")
	private WebElement upcommingProject;

//	locators for completedProject 
	@FindBy(css = "a[role='tab'][type='3']")
	private WebElement completedProjects;

	public ProjectAdministrationPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addProjectdetails(String projno, String proName, String proType, String dept, String vend,
			String sbDept, String memb, String proManag, String clName, String proDesc, String projURL, String proSOD,
			String proEOD, String duDate, String prio, String notify, String estHours, String dDate) {
		try {
			// waitForElementToBeClickable(addProject);
			// addProject.click();
			clickWithFluentWait(addProject);

			projectNumber.sendKeys(projno);
			projectName.sendKeys(proName);
			selectDropdownByValue(projectType, proType);
			// waitForElementToBeClickable(department);
			// department.click();
			waitForElementToBeVisible(department);

			selectDropdownByVisibleText(department, dept);
			selectDropdownByVisibleText(Vendor, vend);
			selectDropdownByVisibleText(subDepartment, sbDept);
			try {
				selectDropdownByVisibleText(members, memb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selectDropdownByVisibleText(projectManager, proManag);
			selectDropdownByVisibleText(clientName, clName);
			projectDescription.sendKeys(proDesc);
			jiraProjectURl.sendKeys(projURL);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + proSOD + "');", startDate);

			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].setAttribute('value','" + proEOD + "');", endDate);

			selectDropdownByVisibleText(priority, prio);
			notifyAt.sendKeys(notify);
			estimatedHoursdDate.sendKeys(estHours);
			JavascriptExecutor jd = (JavascriptExecutor) driver;
			jd.executeScript("arguments[0].setAttribute('value','" + duDate + "');", dueDate);

			// uploadLogo.sendKeys(uploadFile);
			SubmitButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void selectProType() {
//		addProject.click();
//		Select sle = new Select(projectType);
//		sle.selectByValue("Billable");
//	}

	public void selectdptType() {
		waitForElementToBeClickable(addProject);
		addProject.click();
//		waitForElementToBeVisible(department);
//		department.clear();

		Select s = new Select(department);
		s.selectByIndex(2);
	}

	public void uploadFile() {
		clickWithFluentWait(addProject);
//		clickToUpload.click();
		waitForElementToBeVisible(clickToUpload);

		clickToUpload.sendKeys("C:\\Users\\ArunKumar\\Downloads\\ADATC- Detail requirement documentation - Copy.pdf");
		SubmitButton.click();
	}
	
	
	public void checkProjects() {
		currentProjects.click();
		upcommingProject.click();
		completedProjects.click();
	}
	
}
