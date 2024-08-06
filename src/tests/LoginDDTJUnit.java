package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CSV;
import utilities.DriverFactory;

@RunWith(value = Parameterized.class)
public class LoginDDTJUnit {
	String username, password;
	String pathString = "https://www.saucedemo.com/";
	WebDriver driver;
	WebElement userNameElement, passwordElement, loginButton;

	@Test
	public void loginAccountTest() {
		System.out.println("Login Account: " + username + " | With password: " + password);

		defineWebElements();
		
		// fill out fields
		userNameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		loginButton.click();
	}
	
	@Before //framework will run this first before the @Test
	public void setUp() {
		System.out.println("initializing the driver");
		driver = DriverFactory.open("chrome");

		driver.get(pathString);
	}

	@After //framework will run this after the @Test
	public void tearDown() {
		System.out.println("Closing the driver");
		
		driver.close();
		driver.quit();
	}
	
	public void defineWebElements() {

		// define web elements
		userNameElement = driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']"));
		passwordElement = driver.findElement(By.id("password"));
		loginButton = driver.findElement(By.id("login-button"));
		
	}
	
	@Parameters
	public static List<String[]> getData(){
		String filename = "/Users/corinnejoycereloj/eclipse-workspace/Selenium/UserAccounts.csv";
		return CSV.get(filename);
	}
	
	//constructor that passes parameters to the test method
	public LoginDDTJUnit(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
