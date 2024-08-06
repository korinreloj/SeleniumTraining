package stepimplementations;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDDLoginTest {
	WebDriver driver;
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("User is on login page");
	}
	
	@When("^user enters correct credentials$")
	public void user_enters_correct_credentials() {
		System.out.println("User enters username and password");
	  
	}
	
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("User gets confirmation");
	}
}
