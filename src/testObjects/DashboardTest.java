package testObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.DashboardFlow;
import flowObjects.LogInFlow;
import pageObjects.DashboardPage;

public class DashboardTest {
	
	WebDriver driver;

	
	@BeforeMethod
	@Parameters({"browser", "username", "password"})
	public void setUp(String browser, String username, String password) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			//Create a new instance of the Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zee\\Documents\\Selenium Projects\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Browser is not correct.");
		}
	
	driver.get("http://tumblr.com");
	
	LogInFlow.logIn(driver, username, password);
	
	}
	
	@Test
	public void dashboardScroll() {
		DashboardFlow.scrollToNumber(driver, 50);
		
		Assert.assertTrue(DashboardPage.postsList(driver, 50).size() >= 50);
	}
	
	@Test
	public void notesAbove1000() {
		
		int number = 1000;
		
		List<Integer> result = DashboardFlow.getNoteData(driver, number);
		
		Assert.assertTrue(result.get(result.size() -1) >= number);
		
		
	}

}
