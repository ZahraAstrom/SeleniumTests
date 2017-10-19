package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.LogInFlow;
import flowObjects.TextPostFlow;
import pageObjects.TextPostPage;


public class TextPostTest {

	WebDriver driver;

	
	@BeforeTest
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
	public void newTextPost() {
		String random = TextPostFlow.generateString(10);
		
		String randomTitle = "title" + random;
		String randomBody = "body" + random;
		String randomTag = "tag" + random;
		
		TextPostFlow.createTextPost(driver, randomTitle, randomBody, randomTag);
		
		Assert.assertTrue(TextPostPage.createdTextPost(driver, randomTitle).getText().contains(randomTitle));
		Assert.assertTrue(TextPostPage.createdTextPost(driver, randomBody).getText().contains(randomBody));
		Assert.assertTrue(TextPostPage.createdTextPost(driver, randomTag).getText().contains(randomTag));
		
	     System.out.println("Successfully created a text post");
			
	     // Close the driver
	     driver.quit();
		
	}
	
	@Test
	public void reblogPost() {
		String random = TextPostFlow.generateString(10);
		String randomBody = "body" + random;
		
		TextPostFlow.reblogPost(driver, randomBody);
		
		Assert.assertTrue(TextPostPage.createdTextPost(driver, randomBody).getText().contains(randomBody));
		
	     System.out.println("Successfully reblogged a post");
			
	     // Close the driver
	     driver.quit();
		
	}
	
}
