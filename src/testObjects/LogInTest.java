package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.LogInFlow;
import pageObjects.LogInPage;

public class LogInTest {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			//Create a new instance of the Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zee\\Documents\\Selenium Projects\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Browser is not correct.");
		}
	}
	
	@Parameters({"username", "password"})
	@Test
	public void logIn(String username, String password) throws InterruptedException {		
		
     //Launch the Website
		driver.get("http://tumblr.com");
		
		LogInFlow.logIn(driver, username, password);
	
		Assert.assertTrue(LogInPage.dashboard(driver).size() > 1);
		
     // Print a Log In message to the screen
     System.out.println("Successfully logged into www.tumblr.com");
		
     // Close the driver
     driver.quit();
	}

}
