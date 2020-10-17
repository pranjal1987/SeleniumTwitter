package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop;

	//Constructor
	public TestBase() {

		//Read Properties File
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/dineshladdha/eclipse-workspace/"
					+ "TestTwitterApp/src/main/java/config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	//Initialization Driver Method
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
			//System.setProperty("webdriver.chrome.driver", "/Users/dineshladdha/Downloads/chromedriver");
			//driver = new ChromeDriver();
		}
		else if(browserName.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
			//System.setProperty("webdriver.gecko.driver", "/Users/dineshladdha/Downloads/geckodriver");
			//driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		
		// Launch the URL
		driver.get(prop.getProperty("url"));
	}




}
