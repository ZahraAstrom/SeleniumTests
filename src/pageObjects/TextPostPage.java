package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextPostPage {
	
	private static WebElement waitToClick(WebDriver driver, By locator) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement newTextPostButton(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("i.icon_post_text"));
				
	}

	public static WebElement titleField(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div.title-field .editor.editor-plaintext"));
		
	}
	
	public static WebElement mainTextField(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div.editor.editor-richtext"));
		
	}
	
	public static WebElement tagField(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div.tag-input-wrapper .editor.editor-plaintext"));
		
		
	}
	
	public static WebElement postButton(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("button.button-area.create_post_button"));
	}
	
	public static WebElement createdTextPost(WebDriver driver, String random) {
		return waitToClick(driver, By.xpath("//*[contains(text(), '" + random +"')]"));
		
	}
	
	public static List<WebElement> disappearPost(WebDriver driver) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("div.post-container-inner"), 1));
	}
	
	public static WebElement reblogButton(WebDriver driver) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.post_control.post-control-icon.reblog")));
		
	}
	
	public static WebElement dashboardButton(WebDriver driver) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#home_button.tab.iconic.tab_home.selected")));
	}
}
