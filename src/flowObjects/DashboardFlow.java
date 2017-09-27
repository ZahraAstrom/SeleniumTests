package flowObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.DashboardPage;

public class DashboardFlow {
	
	public static void scrollToNumber(WebDriver driver, int number) {
		
		Actions scrollAction = new Actions(driver);
		int previous = 1;
		
		
		while (DashboardPage.postsList(driver, previous).size() <= number) {
			scrollAction.moveToElement(DashboardPage.lastPost(driver));
			scrollAction.perform();
			previous = DashboardPage.postsList(driver, 1).size();
		
			
			 System.out.println("Scrolled: " + DashboardPage.postsList(driver, 1).size());
		}
	}

}
