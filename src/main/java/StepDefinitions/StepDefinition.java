package StepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProfilePage;
import util.TestBase;

public class StepDefinition extends LoginPage {
	
	LoginPage login;
	ProfilePage profilePage;
	
	@Before
	public void setUp(){
		TestBase.loadConfiguration();
		TestBase.initializeDriver();
		login = new LoginPage();
		profilePage = new ProfilePage();
	}
	
	@After
	public void tearDown(){
		//TestBase.driver.close();
	}
	
	@Given("user is on Twitter Login page")
	public void user_is_on_Twitter_Login_page() {
		System.out.println("USER IS ON TWITTER LOGIN PAGE");
		//Pending - Login page validation
		
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("USER ENTERED USERNAME AND PASSWORD");
		login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("USER CLICK ON LOGIN BUTTON");
	}

	@Then("user is navigated  home page")
	public void user_is_navigated_home_page() {
		System.out.println("USER IS NAVIGATED TO HOME PAGE");
	}
	
	//Profile Page methods
	@Given("user is logged in on twitter")
	public void user_is_logged_in_on_twitter() throws Exception {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//
		profilePage.updateProfile();
		
	}
		
	
	
	

}
