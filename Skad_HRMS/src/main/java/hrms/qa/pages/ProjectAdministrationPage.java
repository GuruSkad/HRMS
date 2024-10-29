package hrms.qa.pages;

import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class ProjectAdministrationPage extends TestBase {

	public ProjectAdministrationPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
