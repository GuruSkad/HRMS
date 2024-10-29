package hrms.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hrms.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop;

    // Constructor to load the properties file
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/hrms/qa/config/config.prop"
            );
            prop.load(ip);
            
            // Debugging output
            System.out.println("Loaded properties:");
            System.out.println("Username: " + prop.getProperty("username"));
            System.out.println("Password: " + prop.getProperty("password"));
            System.out.println("Browser: " + prop.getProperty("browser"));
            System.out.println("URL: " + prop.getProperty("url"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Method to initialize the WebDriver
    public static void initialization() {
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

        // Navigate to the specified URL
        driver.get(prop.getProperty("url"));
    }

}
