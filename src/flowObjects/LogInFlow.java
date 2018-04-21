package flowObjects;

import org.openqa.selenium.WebDriver;

import pageObjects.LogInPage;

public class LogInFlow {
	
	public static void logIn(WebDriver driver, String username, String password) {
		
		LogInPage.loginButton(driver).click();
		
		
		LogInPage.emailInput(driver).sendKeys(username);
		
		
		LogInPage.nextButton(driver).click();
		
		
		if (LogInPage.magicBtn(driver).size() > 0) {
			LogInPage.usePassBtn(driver).click();
		}
	
		LogInPage.passwordInput(driver).sendKeys(password);
		
	
		LogInPage.loginToDash(driver).click();
		
	}

}
