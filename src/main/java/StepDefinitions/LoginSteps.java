package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import util.TestBase;

public class LoginSteps extends LoginPage {
	
	
	@Given("user is on Twitter Login page")
	public void user_is_on_Twitter_Login_page() {
		System.out.println("USER IS ON TWITTER LOGIN PAGE");
		TestBase.initialization();
		
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("USER ENTERED USERNAME AND PASSWORD");
		
		LoginPage login = new LoginPage();
		login.login(prop.getProperty("userName"), prop.getProperty("password"));
		

	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("USER CLICK ON LOGIN BUTTON");
	}

	@Then("user is navigated  home page")
	public void user_is_navigated_home_page() {
		System.out.println("USER IS NAVIGATED TO HOME PAGE");
	}
	
	

}
