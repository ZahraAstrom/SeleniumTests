package test.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	public static List<WebElement> postsList(WebDriver driver, int number) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("li.post_container:not(.new_post_buttons_container)"), number));
	}
	
	public static WebElement lastPost(WebDriver driver) {
		List<WebElement> posts = postsList(driver, 1);
		return posts.get(posts.size() -1);
	}
		
}
