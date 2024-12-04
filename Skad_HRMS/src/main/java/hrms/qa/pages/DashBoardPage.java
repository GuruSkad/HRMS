package hrms.qa.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;


public class DashBoardPage extends TestBase {

	@FindBy(id = "active_project_co")
	public WebElement activeProjectCount;
	
	@FindBy(id="worked_hrs")
	public WebElement workedHrs;
	@FindBy(xpath = "(//button[contains(@class,'fs-12 font-weight-500')])[2]")
    private WebElement clickWorkedHours;
	
	@FindBy(id="active_employees")
	public WebElement activeEmployees;
	
	@FindBy(id="total_over_due")
	public WebElement overDue;
	
	@FindBy(id="project_filter")
	public WebElement selectProject;
	
	@FindBy(xpath="(//button[contains(@class,'fs-12 font-weight-500')])[1]")
	private WebElement clickDropDown;
	
	@FindBy(xpath="//button[@data-id='1']")
	private WebElement todayProj;
	
	@FindBy(xpath ="//button[@data-id='1']")
	private WebElement weeklProj;
	
	@FindBy(xpath ="//button[@data-id='1']")
	private WebElement monthProj;
	
	
	@FindBy(css="ul[class='dropdown-menu dropdown-menu-start ctl-drp-das-dow-sty worked-hours-block show'] li:nth-child(1) button:nth-child(1)")
	private WebElement todayWorkedHrs;
	
	@FindBy(css="ul[class='dropdown-menu dropdown-menu-start ctl-drp-das-dow-sty worked-hours-block show'] li:nth-child(1) button:nth-child(1)")
	private WebElement WeeklyWorkedHours;
	
	@FindBy(css="ul[class='dropdown-menu dropdown-menu-start ctl-drp-das-dow-sty worked-hours-block show'] li:nth-child(1) button:nth-child(1)")
	private WebElement monthlyWorkedHours;
	
	@FindBy(id="worked_hrs")
	private WebElement workedHoursCount;
	
	@FindBy(xpath="(//div[contains(@class,'fs-14 font-weight-600')]/following-sibling::button)[1]")
	private WebElement todaySubTaskCount;
	
	@FindBy(xpath="(//button[@class='dropdown-item task_type'])[1]")
	private WebElement weeklySubTaskCount;
	
	@FindBy(xpath="(//ul[@data-popper-placement='bottom-start']//button)[2]")
	private WebElement monthlySubTask;
	
	@FindBy(id="total_employees")
	private WebElement totalEmployeeCount;
	
	@FindBy(xpath = "(//div[contains(@class,'fs-14 font-weight-600')])[2]")
	private WebElement totalEmployeesInOffice;
	
	@FindBy(xpath = "(//div[contains(@class,'fs-14 font-weight-600')])[3]")
	private WebElement totalEmployessWFH;
	
	@FindBy(xpath = "//div[normalize-space(text())='4']" )
	private WebElement vendorEmployees;
	
	@FindBy(xpath = "(//div[@class='fs-14 font-weight-600 fc-primary no_location'])[1]")
	private WebElement totalEmployeesWithNoLocation;
	
	@FindBy(xpath = "(//div[contains(@class,'fs-14 font-weight-600')]/following-sibling::button)[1]")
	private WebElement clickSubTask;
	
	@FindBy(css = ".fs-24.fc-primary.font-weight-600.total_task")
	private WebElement totalSubTaskWorkedCount;
	
	@FindBy(css = ".fs-20.fc-primary.font-weight-600.ps-2.completed_task")
	private WebElement totalSubTaskCompletedCount;

	@FindBy(css = ".fs-20.fc-primary.font-weight-600.task_progress")
	private WebElement totalSubTaskInProgress;
	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	public List<String> getvalues() {
		List<String>values=new ArrayList<String>();
		String s=activeEmployees.getText();
		values.add(s);
		String s1=workedHrs.getText();
		values.add(s1);
		String s2=activeEmployees.getText();
		values.add(s2);
		String s3=overDue.getText();
		values.add(s3);
		return values;
		
	}
	public void getAllCounts() {
		clickDropDown.click();
		waitForElementToBeVisible(todayProj);
//		fetching Active project count 
//		selectDropdownOptionUsingKeys(todayProj, 1);
		
		todayProj.click();
		System.out.println("<-------------------Active Projects--------------->");
		
		System.out.println("Active project Count Based on  today------------->"+activeProjectCount.getText());
//		weeklProj.click();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", weeklProj);
		    waitForElementToBeVisible(activeProjectCount);
	
	
		waitForElementToBeVisible(activeProjectCount);
		System.out.println("Active Project Count Based on Week--------------->"+activeProjectCount.getText());
		waitForElementToBeClickable(monthProj);
		monthProj.click();
		System.out.println("Active porject Count Based on Month-------------->"+activeProjectCount.getText());
//		fetching workedHours
		clickWorkedHours.click();
		todayWorkedHrs.click();
		System.out.println("<----------------------Worked Hours----------------->");
		System.out.println("Worked Hours Count Based On Today----------------->"+workedHoursCount.getText());
		WeeklyWorkedHours.click();
		System.out.println("Worked Hours Count Based On Week------------------>"+workedHoursCount.getText());
		monthlyWorkedHours.click();
		System.out.println("Worked Hours Count Based On Month----------------->"+workedHoursCount.getText());
		System.out.println("<---------------Over Dues Task---------------->");
		System.out.println("Total OverDue Task-------------->"+overDue.getText());
		System.out.println("<----------------------Employees Based On Location------------>");
		System.out.println("Total Active Employees------------->"+activeEmployees.getText());
		System.out.println("Total Employees Count------------->"+totalEmployeeCount.getText());
		System.out.println("Total Employees In Office---------->"+totalEmployeesInOffice.getText());
		System.out.println("Total Employees In WorkFromHome--------->"+totalEmployessWFH.getText());
		System.out.println("Total Employees at Vendor------------>"+vendorEmployees.getText());
		clickSubTask.click();
		todaySubTaskCount.click();
		System.out.println("<--------------SubTask---------------->");
		System.out.println("Total sub Task Count Based on Today------------->"+totalSubTaskWorkedCount.getText());
		System.out.println("Total Sub Task Completed Count Based in Today------------->"+totalSubTaskCompletedCount.getText());
		System.out.println("Total Sub Task in Progress Based on Today----------->"+totalSubTaskInProgress.getText());
		waitForElementToBeClickable(weeklySubTaskCount);
		weeklySubTaskCount.click();
		
		System.out.println("Total Sub Task Count Based On Weekly------------>"+totalSubTaskWorkedCount.getText());
		System.out.println("Total Sub Task Completed Count Based in Weekly------------->"+totalSubTaskCompletedCount.getText());
		System.out.println("Total Sub Task in Progress Based on weekly----------->"+totalSubTaskInProgress.getText());
		monthlySubTask.click();
		System.out.println("Total Sub Task Count Based On Monthly------------->"+totalSubTaskWorkedCount.getText());
		System.out.println("Total Sub Task Completed Count Based in Montly------------->"+totalSubTaskCompletedCount.getText());
		System.out.println("Total Sub Task in Progress Based on Monthly----------->"+totalSubTaskInProgress.getText());
		
		
	}
}
