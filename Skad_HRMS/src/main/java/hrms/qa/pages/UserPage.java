package hrms.qa.pages;


import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import hrms.qa.base.TestBase;

public class UserPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	locators for addPeople
	@FindBy(css = ".col-auto.fs-12.font-weight-600.btn-primary.mb-2.mb-sm-2.mb-md-2.mb-lg-2.ms-0")
	private WebElement addPeople;
	
	
	
//	locatore for personal details
	
	 @FindBy(xpath = "//input[@name='logo']")
	 private WebElement uploadNewImage;
	 
	 @FindBy(id = "employee_name")
	 private WebElement firstName;
	 
	  @FindBy(id = "last_name")
	  private WebElement lastName;
	  
	   @FindBy(id = "employee_no")
	   private WebElement emoloyeeID;
	   
	   @FindBy(id =  "date_of_birth")
	   private WebElement dateOfBrith;
	   
	   @FindBy (id = "date_of_joining")
	   private WebElement dateOfJoining;
	   
//	   @FindBy(id ="select2-data-19-dfcv")
//	   private WebElement gend;
	   
	 @FindBy(id   ="select2-data-19-q504")
	   private WebElement selectGender;
	 
@FindBy(css = "#select2-gender-mp-container")
private WebElement gend;
	   @FindBy(id = "mobile")
	   private WebElement mobileNo;
	   
	    @FindBy(id = "official_email")
	    private WebElement officialEmail;
	    
	    @FindBy(id = "personal_email")
	    private WebElement personalEmail;
	    
	    @FindBy(css = "body > div:nth-child(47) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(12) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1) > span:nth-child(1)")
	    private WebElement country;
	    
	    @FindBy(id = "//span[@id='select2-state_id-container']")
	    private WebElement state;
	    
	    @FindBy(xpath  = "select2-city_id-container")
	    private WebElement city;
	    
	    @FindBy(id   = "pin_code")
	    private WebElement pinCode;
	    
	    @FindBy(xpath  = "permanent_address")
	    private WebElement permanentAdress;
	    
	    @FindBy(id = "temporary_address")
	    private WebElement temporaryAddress;
	    
	    @FindBy(tagName = "label")
	    private WebElement getAllLabels;
	    
//locators for Organization details
	    
	    @FindBy(id = "job_title")  
		 private WebElement jobTitle;
	    
		    @FindBy(xpath = "(//span[@role='combobox'])[5]")
		 private WebElement department;
		    
		    @FindBy(xpath  = "(//span[@id='select2-assigned_sub_department-container'])[1]")
		 private WebElement sbDepartment;
		    
		    @FindBy(id  = "select2-employment_type-container")
		 private WebElement empType;
		    
		    @FindBy(id  = "select2-employed_through-container")
		 private WebElement employedThrough;
		    
		    @FindBy(id = "(//span[@role='combobox'])[9]")
		 private WebElement workMode;
		    
		    @FindBy(xpath  = "(//span[@role='combobox'])[10]")
		 private WebElement workolocation; 
	    
		    @FindBy(xpath  = "(//span[@role='combobox'])[11]")
			 private WebElement vendorName; 
	    
		    @FindBy(xpath  = "(//span[@role='combobox'])[11]")
			 private WebElement billingType; 
		    
		    @FindBy(xpath  = "(//span[@id='select2-timezone_id-container'])[1]")
			 private WebElement userTimeZone; 
	    
//locators for project and roles
	 @FindBy(xpath = "(//textarea[@placeholder='Please select a Role'])[1]")
	 private WebElement role;
	 
	    @FindBy(xpath = "(//span[@role='combobox'])[20]")
	    private WebElement reportingTo;
	    
	    
//locators for back and submit button
	    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div/div[38]/div/button")
	    private WebElement submitButton;
	    
	    @FindBy(css = "a[name='submit']")
	    private WebElement backButton;
	 
	public UserPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	  public String uploadImage(String filePath) {
		  uploadNewImage.sendKeys(filePath);  // Upload the image
	        return uploadNewImage.getText();  // Capture the upload status message
	    }
	  
	  public void selectDateOfBirth(WebElement dateOfBrith,String dateVal) {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", dateOfBrith);
		  
	  }
	  
	  public void selectDateOfJoining(WebElement dateOfJoining,String doJ) {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].setAttribute('value','"+doJ+"');", dateOfJoining);
		  
	  }
	  
	  public void clickAddPeople() {
//		  addPeople.click();
		  clickWithFluentWait(addPeople);
	  }
	  
	  public List<WebElement> getGender() {
		  selectGender.click();
		 WebElement s= driver.findElement(By.id("select2-data-21-w9uo"));
		 Select getGender=new Select(s);
		 
	List<WebElement>genderList=	 getGender.getAllSelectedOptions();
	return genderList;
	  }
	  
	  
	 public List<WebElement> getCountry() {
		 Select getctry=new Select(country);
		 List<WebElement>countryList =getctry.getAllSelectedOptions();
		 return countryList;
	 }
	 
	
	 public List<WebElement> getState() {
		 Select getState=new Select(state);
		 List<WebElement>states= getState.getAllSelectedOptions();
		 return states;
	 }
	  
	// Method to return the list of available cities from the dropdown
	 public List<WebElement> getCities() {
	     Select citySelect = new Select(city); // 'cityDropdown' is the WebElement for the city dropdown
	     List<WebElement> cities = citySelect.getOptions(); // Get all available options
	     return cities;
	 }
	 
	 public List<WebElement> getDepartment() {
		 Select getdpt=new Select(department);
		 List<WebElement>departments= getdpt.getAllSelectedOptions();
		 return departments;
	 }
	 public List<WebElement> getEmploymentType() {
		 Select getemptpe=new Select(empType);
		 return getemptpe.getAllSelectedOptions();
		
	 }
	 public List<WebElement> getEmployedThrough() {
		 Select getempdthrough=new Select(sbDepartment);
		 return getempdthrough.getAllSelectedOptions();
		
	 }
	 public List<WebElement> getWorkMode() {
		 Select wmode=new Select(workMode);
		 return wmode.getAllSelectedOptions();
		
	 }
	 public List<WebElement> getWorkLocation() {
		 Select getwlc=new Select(workolocation);
		 return getwlc.getAllSelectedOptions();
		
	 }
	 public List<WebElement> getVendorName() {
		 Select getven=new Select(vendorName);
		 return getven.getAllSelectedOptions();
		
	 }
	 public List<WebElement> getAllDropdownOptions() {
	        List<WebElement> allOptions = new ArrayList<>();

	        // Collect options from each dropdown
	        allOptions.addAll(getGender());
	        allOptions.addAll(getCountry());
	        allOptions.addAll(getState());
	        allOptions.addAll(getCities());
	        allOptions.addAll(getDepartment());
	        allOptions.addAll(getEmploymentType());
	        allOptions.addAll(getEmployedThrough());
	        allOptions.addAll(getWorkMode());
	        allOptions.addAll(getWorkLocation());
	        allOptions.addAll(getVendorName());

	        return allOptions; // Return the list containing all dropdown options
	    }
	
	  public void createPersonalDetails(String fName, String lName, String empID,String dob,String doj,
										String gender,String Mob,String omail,String pmail,String ctry,
										String stat,String cty,String pcode,String padd,String tadd,String jbtitle,String dptmt,String subDept,
										  String emptype,String empthrogh,String woMode,String woLocation,
										  String vendor,String billType,String timeZone) {
		  try {
			firstName.sendKeys(fName);
			  lastName.sendKeys(lName);
			  emoloyeeID.clear();
			emoloyeeID.sendKeys(empID);
			
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("arguments[0].setAttribute('value','"+dob+"');", dateOfBrith);
			  
			  JavascriptExecutor j=(JavascriptExecutor)driver;
			  j.executeScript("arguments[0].setAttribute('value','"+doj+"');", dateOfJoining);
			  
//			  gend.click();
			  
			  selectGender.click();
			  selectGender.sendKeys(gender);
			  selectGender.sendKeys(Keys.ENTER);
			  Thread.sleep(3000);
//			  Select s=new Select(gend);
//			  s.selectByVisibleText(gender);
			  mobileNo.sendKeys(Mob);
			  officialEmail.sendKeys(omail);
			  personalEmail.sendKeys(pmail);
			  Select cry=new Select(country);
			  cry.selectByVisibleText(ctry);
			  Select st=new Select(state);
			  st.selectByVisibleText(stat);
			  Select cit=new Select(city);
			  cit.selectByVisibleText(cty);
			  pinCode.sendKeys(pcode);
			  permanentAdress.sendKeys(padd);
			  temporaryAddress.sendKeys(tadd);
			  jobTitle.sendKeys(jbtitle);
				Select dpt=new Select(  department);
				dpt.selectByVisibleText(dptmt);
				Select sbdpt=new Select(sbDepartment);
				sbdpt.selectByVisibleText(subDept);
				Select emptpe=new Select(empType);
				emptpe.selectByVisibleText(emptype);
				Select emthr=new Select(employedThrough);
				emthr.selectByVisibleText(empthrogh);
				Select wmod=new Select(workMode);
				wmod.selectByVisibleText(woMode);
				Select vend=new Select(vendorName);
				vend.selectByVisibleText(vendor);
				Select bill=new Select(billingType);
				bill.selectByVisibleText(billType);
				Select tmz=new Select(userTimeZone);
				tmz.selectByVisibleText(timeZone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  

	}
	  public void withoutValuesValidation() {
           clickWithFluentWait(submitButton);
	  }
	  
	  
	


}