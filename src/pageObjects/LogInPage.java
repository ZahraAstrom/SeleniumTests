package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	
	private static WebElement element = null;
	
	private static WebElement text(WebDriver driver, By locator) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement loginButton(WebDriver driver) {
//		element = new WebDriverWait(driver, 10)
//				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#signup_login_button span.signup_get_started_btn")));
//		
//		return element;
		
		return text(driver, By.cssSelector("button#signup_login_button span.signup_get_started_btn"));
	}
	
	public static WebElement emailInput(WebDriver driver) {
		element = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#signup_determine_email")));
		
		return element;
	}
			
	public static WebElement nextButton(WebDriver driver) {
		element = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.signup_determine_btn")));
		
		return element;
	}
	
	public static WebElement passwordInput(WebDriver driver) {
		element = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#signup_password")));
		
		return element;
	}
	
	public static WebElement loginToDash(WebDriver driver) {
		element = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.signup_login_btn")));
		
		return element;
	}
	
	public static List<WebElement> dashboard(WebDriver driver) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("li.post_container:not(.new_post_buttons_container)"), 1));
		
	}
}
