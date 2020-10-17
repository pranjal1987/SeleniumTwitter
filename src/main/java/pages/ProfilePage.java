package pages;

import org.openqa.selenium.WebElement;
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
	
	//initializing page object
		public ProfilePage() {
			PageFactory.initElements(driver, this);
		}
	
	public void updateProfile(){
		utils.click(profileBtn, "Profile");
		utils.click(editProfileBtn, "Edit");
		utils.click(profilePhoto, "Profile photo");
	}
}
