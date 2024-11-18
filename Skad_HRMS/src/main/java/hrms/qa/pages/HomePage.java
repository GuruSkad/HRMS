package hrms.qa.pages;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(xpath    = "//span[normalize-space()='Task Oversight']")
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
	
	@FindBy(linkText  = "User")
	public WebElement addUserPageLink;
	
	@FindBy(id = "add_role")
	public WebElement adddRolePageLink;
	
    @FindBy(tagName = "a")
    private List<WebElement> allLinksbrokenLink;
	
    
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
	
	public ProjectAdministrationPage clickOnProjectAdministrationPageLink() {
//		projectAdministrationLink.click();
		clickWithFluentWait(projectAdministrationLink);
		return new ProjectAdministrationPage();
	}

	public TaskOverSightPage clickOnTaskOverSightPageLink() {
		clickWithFluentWait(taskOverSightPageLink);
	
//		return new TaskOverSightPage();
		return new TaskOverSightPage();
	}

	public DepartmentsPage clickOnDepartmentsLink() {
	clickWithFluentWait(departmentsPageLink);
		return new DepartmentsPage();
	}
	
	public ClientRelationsPage clickOnClientRelationsLink() {
		clientRelationsPageLink.click();
		return new ClientRelationsPage();
	}
	
	public VendorAdministrationPage clickOnVendorAdministrationLink() {
		vendorAdministrationPageLink.click();
		return new VendorAdministrationPage();
	}
	

	public LeaveTrackingPage clickOnLeaveTrackingPageLink() {
		leaveTrackingPageLink.click();
		return new LeaveTrackingPage();
	}
	
	public UserAdministrationPage clickOnUserAdministrationPageLink() {
		
//		userAdministrationPageLink.click();
		clickWithFluentWait(userAdministrationPageLink);
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
//		addUserPageLink.click();
		clickWithFluentWait(addUserPageLink);
		
		return new  UserPage();
	}
	public RolePage clickOnRolePageLink() {
		adddRolePageLink.click();
		return new RolePage();
	}
	
	 public List<String> findBrokenLink() {
	        List<String> urls = new ArrayList<>();

	        try {
				for (WebElement ele : allLinksbrokenLink) {
				    String urlLink = ele.getAttribute("href");
				    if (urlLink != null && !urlLink.isEmpty()) {
				        urls.add(urlLink);
				    }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return urls;
	    }



	
	
}
