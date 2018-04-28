package test.java.flowObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.java.pageObjects.DashboardPage;

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
	
	public static List<Integer> getNoteData(WebDriver driver, int minNoteNumber) {
		
		List<Integer> postNoteNumber = new ArrayList<Integer>();
		List<WebElement> posts = DashboardPage.postsList(driver, 1);
		
		for (int i = 0; i < posts.size(); i++) {
			WebElement singlePost = posts.get(i).findElement(By.cssSelector("span.note_link_current"));
			String dataCountString = singlePost.getAttribute("data-count");
			int dataCountInt = Integer.parseInt(dataCountString);
				
				if (dataCountInt >= minNoteNumber) {
					postNoteNumber.add(dataCountInt);
				}
		}
		
		Collections.sort(postNoteNumber, Collections.reverseOrder());
		return postNoteNumber;
	}
				
				
//		for (int i: postNoteNumber) {
//			System.out.println(i);
//		}
		
		
	
	public static List<Integer> topFiveNotes(WebDriver driver) {
		
		List<Integer> postNoteNumber = new ArrayList<Integer>();
		List<WebElement> posts = DashboardPage.postsList(driver, 1);
		
		for (int i = 0; i < posts.size(); i++) {
			WebElement singlePost = posts.get(i).findElement(By.cssSelector("span.note_link_current"));
			String dataCountString = singlePost.getAttribute("data-count");
			int dataCountInt = Integer.parseInt(dataCountString);
			postNoteNumber.add(dataCountInt); 
		}
		
		Collections.sort(postNoteNumber, Collections.reverseOrder());
		return postNoteNumber.subList(0, 5);
	
	}

	public static List<Integer> scrollForNotes(WebDriver driver, int postsRequired) {
		
		List<Integer> postNoteNumber = new ArrayList<Integer>();
		List<WebElement> posts = DashboardPage.postsList(driver, 1);
		
		Actions scrollAction = new Actions(driver);
		
		for (int i = 0; i < postsRequired; i++) {
			WebElement singlePost = posts.get(i).findElement(By.cssSelector("span.note_link_current"));
			String dataCountString = singlePost.getAttribute("data-count");
			int dataCountInt = Integer.parseInt(dataCountString);
			postNoteNumber.add(dataCountInt); 
			
			
				if (i == posts.size()-1) {
					scrollAction.moveToElement(posts.get(posts.size()-1));
					scrollAction.perform();
					
					posts = DashboardPage.postsList(driver, posts.size());
					
				}		
				
		}
		
		Collections.sort(postNoteNumber, Collections.reverseOrder());
		return postNoteNumber.subList(0, 5);
		
	}
	
	public static List<ArrayList<String>> topFiftyTitles (WebDriver driver) {
		
		List<ArrayList <String>> titledPosts = new ArrayList<ArrayList <String>>();
		List<WebElement> posts = DashboardPage.postsList(driver, 1);
		
		Actions scrollAction = new Actions(driver);
		
		for (int i = 0; titledPosts.size() < 50; i++) {
			List<WebElement> postTitle = posts.get(i).findElements(By.cssSelector("div.post_title"));
				if ( postTitle.size() != 0 ) {
					WebElement singlePost = posts.get(i).findElement(By.cssSelector("span.note_link_current"));
					String dataCountString = singlePost.getAttribute("data-count");
					String titleString = postTitle.get(0).getText();
					
					ArrayList<String> currentPost = new ArrayList<String>();
					currentPost.add(titleString);
					currentPost.add(dataCountString);
					titledPosts.add(currentPost);
				}
				
				if (i == posts.size()-1) {
					scrollAction.moveToElement(posts.get(posts.size()-1));
					scrollAction.perform();
					
					posts = DashboardPage.postsList(driver, posts.size());
				}
							
		}
		
		Collections.sort(titledPosts, new Comparator<ArrayList<String>>() {

			@Override
			public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {
				return Integer.compare(Integer.parseInt(arg1.get(1)), Integer.parseInt(arg0.get(1)));
			}
			
		});
		return titledPosts;
	}
	
	

}