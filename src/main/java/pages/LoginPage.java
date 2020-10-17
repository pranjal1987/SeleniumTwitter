package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory
	
	@FindBy(xpath="//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/label[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement username;
	
	@FindBy(xpath="//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/label[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement password;
	
	@FindBy(name="")
	WebElement loginBtn;
	
	//initializing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Login method
	public HomePage login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();	
		return new HomePage();
	}
	
	

}
