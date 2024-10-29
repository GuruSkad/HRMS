package hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
//locators for AllPageLinks
	
	
	@FindBy(xpath = "(//span[normalize-space()='Dashboard'])[1]")
	public WebElement dashBoardLink;
	
	@FindBy(xpath = "//a[@href='https://skad.timetracks.us/timesheets']")
	public WebElement timeSheetLink;
	
	@FindBy(xpath = "//span[normalize-space()='Project Administration']")
	public WebElement projectAdministrationLink;
	
	@FindBy(xpath = "//span[normalize-space()='Task Oversight']" )
	public WebElement timeSheetPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Task Oversight']")
	public WebElement taskOverSightLink;
	
	@FindBy(xpath = "//a[@href='https://skad.timetracks.us/tasks']")
	public WebElement taskOverSightPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Departments']")
	public WebElement departmentsPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Client Relations']")
	public WebElement clientRelationsPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Vendor Administration']")
	public WebElement vendorAdministrationPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Leave Tracking']")
	public WebElement leaveTrackingPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='User Administration']")
	public WebElement userAdministrationPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Report Generation']")
	public WebElement reportGenerationPageLink;
	
	@FindBy(xpath = "//span[normalize-space()='Log Monitoring']")
	public WebElement logMonitoringPageLink;
	
	@FindBy(xpath = "//a[normalize-space()='User']")
	public WebElement addUserPageLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public DashBoardPage clickOnDashBoardLink() {
		dashBoardLink.click();
		return new DashBoardPage();
	}
	
	public TimeSheetPage clickOnTimeSheetLink() {
		timeSheetLink.click();
		return new TimeSheetPage();
	}
	
	public ProjectAdministrationPage clickOnProjectAdministrationPgageLink() {
		projectAdministrationLink.click();
		return new ProjectAdministrationPage();
	}

	public TimeSheetPage clickOnTaskOverSightPageLink() {
		taskOverSightPageLink.click();
		return new TaskOverSightPage();
	}

	public TimeSheetPage clickOnDepartmentsLink() {
		departmentsPageLink.click();
		return new DepartmentsPage();
	}
	
	public TimeSheetPage clickOnClientRelationsLink() {
		clientRelationsPageLink.click();
		return new ClientRelationsPage();
	}
	
	public TimeSheetPage clickOnVendorAdministrationLink() {
		vendorAdministrationPageLink.click();
		return new VendorAdministrationPage();
	}
	

	public TimeSheetPage clickOnLeaveTrackingPageLink() {
		leaveTrackingPageLink.click();
		return new LeaveTrackingPage();
	}
	
	public UserAdministrationPage clickOnUserAdministrationPageLink() {
		userAdministrationPageLink.click();
		return new UserAdministrationPage();
	}
	

	public ReportGenerationPage clickOnReportGenerationPageLink() {
		reportGenerationPageLink.click();
		return new ReportGenerationPage();
	}
	
	public LogMonitoringPage clickOnLogMonitoringPageLink() {
		logMonitoringPageLink.click();
		return new LogMonitoringPage();
	}
	
	public UserPage clickOnAddUserPageLink() {
		addUserPageLink.click();
		return new  UserPage();
	}
	
	
	
}
