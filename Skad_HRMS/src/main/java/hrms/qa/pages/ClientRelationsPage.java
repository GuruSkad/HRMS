package hrms.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.qa.base.TestBase;

public class ClientRelationsPage extends TestBase {

//	locators forinput field 

	@FindBy(css = ".col-auto.fs-12.font-weight-500.btn-primary.ms-0.mb-2.mb-sm-2.mb-md-2.mb-lg-2.button-radius")
	private WebElement addClient;

	@FindBy(xpath = "(//input[@placeholder='Enter Client Name'])[1]")
	private WebElement enterClientName;

	@FindBy(id = "phone_number")
	private WebElement phoneNumber;

	@FindBy(xpath = "(//input[@placeholder='Enter Email ID'])[1]")
	private WebElement emailID;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(css = "button[class='btn btn-primary btn-primary-submit w-auto border-radius-6 sweetClientSubmit']")
	private WebElement submitBtn;

	@FindBy(css = "form[id='client_added_form'] span[class='fs-14 font-weight-600 fc-secondary']")
	private WebElement discard;

//	locators for Error Message

	@FindBy(id = "client_name-error")
	private WebElement clientErrorMsg;

	@FindBy(id = "email-error")
	private WebElement emailErrorMsg;

	@FindBy(id = "phone_number-error")
	private WebElement phoneNoErrorMsg;

	@FindBy(id = "address-error")
	private WebElement addressError;

	public ClientRelationsPage() {
		PageFactory.initElements(driver, this);
	}

	public List<String> checkAlreadyExists() {
		try {
			addClient.click();
			enterClientName.sendKeys("Amazon");
			phoneNumber.sendKeys("2937197324");
			emailID.sendKeys("abc@gmail.com");
			address.sendKeys("uwgkiuewgfiwugoqi");
			waitForElementToBeClickable(submitBtn);
			submitBtn.click();
			Thread.sleep(3000);
			List<String>errorMessages=new ArrayList<String>();
			String clientError=clientErrorMsg.getText();
			errorMessages.add(clientError);
			String emailError=emailErrorMsg.getText();
			errorMessages.add(emailError);
			String phError=phoneNoErrorMsg.getText();
			errorMessages.add(phError);
			
			return errorMessages;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public List<String> errorMsg() {
		addClient.click();
		submitBtn.click();
		List<String>errorMessages=new ArrayList<String>();
		String clientError=clientErrorMsg.getText();
		errorMessages.add(clientError);
		String emailError=emailErrorMsg.getText();
		errorMessages.add(emailError);
		String phError=phoneNoErrorMsg.getText();
		errorMessages.add(phError);
		String addError=addressError.getText();
		errorMessages.add(addError);
		return errorMessages;
	}

}
