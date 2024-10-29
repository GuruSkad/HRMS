package hrms.qa.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(xpath = "//a[@class='col-auto fs-12 font-weight-600 btn-primary mb-2 mb-sm-2 mb-md-2 mb-lg-2 ms-0']")
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
	   
	 
	   private WebElement selectGender	=  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@role='combobox'])[1]")));;
	   private WebElement selectG	=  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@role='combobox'])[1]")));;
	   @FindBy(id = "mobile")
	   private WebElement mobileNo;
	   
	    @FindBy(id = "official_email")
	    private WebElement officialEmail;
	    
	    @FindBy(id = "personal_email")
	    private WebElement personalEmail;
	    
	    @FindBy(id = "select2-country_id-container")
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
		  addPeople.click();
	  }
	  
	  public List<WebElement> getGender() {
		 Select getGender=new Select(selectGender);
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
	 public List<WebElement> getWorkLocaiton() {
		 Select getwlc=new Select(workolocation);
		 return getwlc.getAllSelectedOptions();
		
	 }
	 public List<WebElement> getVendorName() {
		 Select getven=new Select(vendorName);
		 return getven.getAllSelectedOptions();
		
	 }
//	 public List<WebElement> getBillingType() {
//		 Select getBill=new Select(billingType);
//		 return getBill.getAllSelectedOptions();
//		
//	 }
//	 public List<WebElement> getBillingType() {
//		 Select getBill=new Select(billingType);
//		 return getBill.getAllSelectedOptions();
		
//	 }
	  public void createPersonalDetails(String fName, String lName, String empID,String dob,String doj,
										String gender,String Mob,String omail,String pmail,String ctry,
										String stat,String cty,String pcode,String padd,String tadd) {
		  try {
			firstName.sendKeys(fName);
			  lastName.sendKeys(lName);
			  emoloyeeID.clear();
			emoloyeeID.sendKeys(empID);
			
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("arguments[0].setAttribute('value','"+dob+"');", dateOfBrith);
			  
			  JavascriptExecutor j=(JavascriptExecutor)driver;
			  j.executeScript("arguments[0].setAttribute('value','"+doj+"');", dateOfJoining);
			  
			  JavascriptExecutor dropdown = (JavascriptExecutor) driver;
			  WebElement dropdown1= driver.findElement(By.xpath("//select[@name='gender']"));
			  dropdown.executeScript("arguments[0].click();", dropdown1);
			  
			  
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  

	}
	  public void enterOrganizationDetails(String jbtitle,String dptmt,String subDept,
			  String emptype,String empthrogh,String woMode,String woLocation,
			  String vendor,String billType,String timeZone) {
		  
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
		  
		  
	  }
	  
	  public void enterprojectRoles(String  rle,String rprtTo ) {
		  
		  
	  }


}