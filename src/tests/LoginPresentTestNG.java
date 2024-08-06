package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class LoginPresentTestNG {

	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("-------- Running loginElementsPresentTest --------");
		
		boolean userNameElement = driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']")).isDisplayed();
		boolean passwordElement = driver.findElement(By.id("password")).isDisplayed();
		boolean loginButton= driver.findElement(By.id("login-button")).isDisplayed();

		Assert.assertTrue(userNameElement, "userName element not present");
		Assert.assertTrue(passwordElement, "password element not present");
		Assert.assertTrue(loginButton, "loginButton element not present");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("-------- Starting loginElementsPresentTest --------");
		driver = DriverFactory.open("chrome");

		String pathString = "https://www.saucedemo.com/";
		driver.get(pathString);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("-------- Closing loginElementsPresentTest --------\n\n");
		
		driver.close();
		driver.quit();
	}
}
