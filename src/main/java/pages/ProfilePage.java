package pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class ProfilePage extends TestBase {
	
	@FindBy(xpath="//span[text()='Profile']")
	WebElement profileBtn;
	
	@FindBy(xpath="//span[text()='Edit profile']")
	WebElement editProfileBtn;
	
	@FindBy(xpath="(//span[text()='Name']/ancestor::label/../preceding-sibling::div/div/div/div[3]/div/div/*[name()=\"svg\"])[2]")
	WebElement profilePhoto;
	
	@FindBy(xpath="//span[text()='Apply']")
	WebElement applyBtn;
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@aria-label='Search query']")
	WebElement searchTweets;
	
	@FindBy(xpath="//span[text()='The Times Of India']")
	WebElement searchedTimeOfIndia;
	
	HashSet<String> listOfTweets = new HashSet<>();
	
	//initializing page object
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void updateProfile() throws Exception{
		utils.sendKeys(searchTweets, "Search Tweets", "The Times Of India");
		//searchTweets.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(searchedTimeOfIndia).perform();
		utils.click(searchedTimeOfIndia,"The Times Of India");
		scrollTillTweets();
		List<WebElement> list = driver.findElements(By.xpath("//div[@aria-label='Timeline: The Times Of India’s Tweets']/div/div//time"));
		
		for(WebElement element : list){
			System.out.println("Time is "+element.getText());
		}
		
		/*
		utils.click(profileBtn, "Profile Button");
		utils.click(editProfileBtn, "Edit Profile Button");
		utils.click(profilePhoto, "Profile photo Button");
		String imagePath = System.getProperty("user.dir")+"\\src\\test\\resources\\Photo.png";
		String exePath = "src\\test\\resources\\AutoIt.exe";
		ProcessBuilder proc = new ProcessBuilder(exePath, imagePath);
		proc.redirectErrorStream(true);
		proc.start();
		Thread.sleep(3000);
		utils.click(applyBtn, "Apply Button");
		utils.click(saveBtn, "Save Button");*/
	}
	
	void scrollTillTweets() throws Exception{
		
		String time = "";
		while(!time.equals("3h")){
			List<WebElement> list = driver.findElements(By.xpath("//div[@aria-label='Timeline: The Times Of India’s Tweets']/div/div//time"));
			//WebElement ele = driver.findElement(By.xpath("//div[@aria-label='Timeline: The Times Of India’s Tweets']/div/div//time[text()='"+i+"h']"));
			System.out.println("Tweets size is "+list.size());
			for(WebElement element : list){
				listOfTweets.add(element.getText());
			}
			
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",list.get(list.size()-1));
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//div[@aria-label='Timeline: The Times Of India’s Tweets']/div/div//time"));
			if(ele.getText().equals("3h")){
				time = "3h";
			}
		}
		System.out.println("Total tweets are "+listOfTweets.size());
		
	}
}
