package hrms.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hrms.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Robot robot;
	public static Actions action;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest logger;
	public static ExtentReports extent;
	public static Method method;

	// Constructor to load the properties file

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/hrms/qa/config/config.prop");
			prop.load(ip);

//            // Debugging output
//            System.out.println("Loaded properties:");
//            System.out.println("Username: " + prop.getProperty("username"));
//            System.out.println("Password: " + prop.getProperty("password"));
//            System.out.println("Browser: " + prop.getProperty("browser"));
//            System.out.println("URL: " + prop.getProperty("url"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to initialize the WebDriver
	public static void initialization() {

		try {
			String browserName = prop.getProperty("browser");

			if (browserName.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equals("FF")) {
				driver = new FirefoxDriver();
			}

			// Maximize the window and configure timeouts
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.WAIT_TIMEOUT));
			robot = new Robot();
			action = new Actions(driver);

			// Navigate to the specified URL
			driver.get(prop.getProperty("url"));
		} catch (AWTException e) {

			e.getMessage();
		}
	}

	public static void waitForElementToBeClickable(WebElement locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForElementToBeVisible(WebElement element) {
//		wait.until(ExpectedConditions.invisibilityOf(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickWithFluentWait(WebElement element) {
		// Set up Fluent Wait with a polling interval
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
				.ignoring(ElementClickInterceptedException.class).ignoring(StaleElementReferenceException.class);

		try {
			// Wait for element to be clickable
			WebElement clickableElement = wait.until(driver -> {
				if (element.isDisplayed() && element.isEnabled()) {
					return element;
				}
				return null;
			});

			// Scroll element into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickableElement);

			// Attempt JavaScript click as fallback
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableElement);
			} catch (Exception e) {
				clickableElement.click(); // Fallback to native click if JavaScript fails
			}

		} catch (Exception e) {
			System.out.println("Element not clickable: " + e.getMessage());
		}
	}

	public static void checkBrokenLinks(List<String> urls) {

		for (String url : urls) {
			try {
				// Skip URLs that start with "javascript:"
				if (url.startsWith("javascript:")) {
					System.out.println(url + " -----> Skipped (JavaScript URL)");
					continue;
				}

				// Proceed with HTTP connection
				HttpURLConnection httpUrlConnection = (HttpURLConnection) (new URL(url).openConnection());
				httpUrlConnection.setConnectTimeout(5000);
				httpUrlConnection.connect();

				if (httpUrlConnection.getResponseCode() >= 400) {
					System.out.println(url + " -----> " + httpUrlConnection.getResponseMessage() + " is a broken link");
				} else {
					System.out.println(url + " -----> " + httpUrlConnection.getResponseMessage());
				}

			} catch (MalformedURLException e) {
				System.out.println("Malformed URL: " + url + " - " + e.getMessage());
			} catch (IOException e) {
				System.out.println("I/O error for URL: " + url + " - " + e.getMessage());
			}
		}
	}

	// Method to select dropdown by index
	public void selectDropdownByIndex(WebElement dropdownElement, int index) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(index);
	}

	// Method to select dropdown by visible text
	public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	// Method to select dropdown by value
	public void selectDropdownByValue(WebElement dropdownElement, String value) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(value);
	}

	public static void selectDropdownOptionUsingKeys(WebElement dropdownElement, int downPressCount) {
		try {
			// Click to open the dropdown
			dropdownElement.click();

			// Press Down Arrow key the specified number of times
			for (int i = 0; i < downPressCount; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(200); // Add a small delay between key presses
			}

			// Press Enter to select the highlighted option
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println("Error while selecting dropdown option: " + e.getMessage());
		}
	}

	public void setFromAndToDateIfEnabled(WebElement dateFieldXPath, String fromDate, String toDate) {
		try {
			WebElement dateField = dateFieldXPath;
			// Check if the field is enabled
			if (dateField.isEnabled()) {
				System.out.println("Date field is enabled.");

				// Combine the From Date and To Date
				String dateRange = fromDate + " - " + toDate;

				// Use JavaScript Executor to set the value
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].value = arguments[1];", dateField, dateRange);
				System.out.println("Date range set to: " + dateRange);
			} else {
				System.out.println("Date field is not enabled.");
			}
		} catch (Exception e) {
			System.out.println("Error while interacting with the date field: " + e.getMessage());
		}
	}
}
