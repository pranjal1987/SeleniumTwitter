package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	static int PAGE_LOAD_TIMEOUT = 15;
	static int IMPLICT_WAIT = 15;
	static int EXPLICIT_WAIT = 15;
	private WebDriver driver;
	
	public TestUtil(){
		this.driver = TestBase.driver;
	}
	
	public void click (WebElement element, String elementName){
		if(dynamicWait(element)){
			element.click();
			System.out.println("Clicked on "+elementName);
		}
	}
	
	public boolean dynamicWait(WebElement element){
		try{
			WebDriverWait waitObj = new WebDriverWait(driver, EXPLICIT_WAIT);
			waitObj.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch(Exception E){
			E.printStackTrace();
			return false;
		}
	}
		
}
