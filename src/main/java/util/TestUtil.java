package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	static int PAGE_LOAD_TIMEOUT = 20;
	static int IMPLICT_WAIT = 20;
	static int EXPLICIT_WAIT = 20;
	private WebDriver driver;
	
	public TestUtil(){
		this.driver = TestBase.driver;
	}
	
	public void click (WebElement element, String elementName){
		if(dynamicWait(element,"VisibilityOfElementLocated")){
			element.click();
			System.out.println("Clicked on "+elementName);
		}
	}
	
	public void sendKeys (WebElement element, String elementName, String value){
		if(dynamicWait(element,"VisibilityOfElementLocated")){
			if(dynamicWait(element,"ElementToBeClickable")){
				element.sendKeys(value);
				System.out.println("Entered "+value+"value on "+elementName+" text box");
			}else{
				System.out.println(elementName+" is not clickable");
			}
		}else{
			System.out.println(elementName+" is not visible");
		}
	}
	
	public boolean dynamicWait(WebElement element, String waitType){
		try{
			WebDriverWait waitObj = new WebDriverWait(driver, EXPLICIT_WAIT);
			switch (waitType)	{
				case  "VisibilityOfElementLocated" :
					waitObj.until(ExpectedConditions.visibilityOf(element));
				break;
				case  "ElementToBeClickable" :
					waitObj.until(ExpectedConditions.elementToBeClickable(element));
				break;
			}
			return true;
		}catch(Exception E){
			E.printStackTrace();
			return false;
		}
	}
		
}
