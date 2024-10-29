package hrms.qa.pages;

import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class TimeSheetPage extends TestBase {
	public  TimeSheetPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 

}
