package test.java.flowObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import test.java.pageObjects.TextPostPage;

public class TextPostFlow {
	
	public static void createTextPost(WebDriver driver, String randomTitle, String randomBody, String randomTag) {
		
		TextPostPage.newTextPostButton(driver).click();
		TextPostPage.titleField(driver).sendKeys(randomTitle);
		TextPostPage.mainTextField(driver).sendKeys(randomBody);
		TextPostPage.tagField(driver).sendKeys(randomTag);
		TextPostPage.postButton(driver).click();
		TextPostPage.disappearPost(driver);
		
	}

	//creates a randomly generated string
	public static String generateString(int length) {
		
		Random rng = new Random();
		//string of characters to pull from:
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	
	}
	
	public static void reblogPost(WebDriver driver, String randomBody) {
		
		TextPostPage.reblogButton(driver).click();
		TextPostPage.mainTextField(driver).sendKeys(randomBody);
		TextPostPage.postButton(driver).click();
		TextPostPage.disappearPost(driver);
		TextPostPage.dashboardButton(driver).click();
	}
}
