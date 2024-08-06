package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DriverFactory;
import utilities.Excel;

public class LoginDDTTestNG {
	
	String browserType = "chrome";
	String pathString = "https://www.saucedemo.com/";
	WebDriver driver;

	@Test(dataProvider = "getData")
	public void loginTest(String username, String password) {
		System.out.println("RECORD");
		System.out.println(username + " | " + password + "\n");
		
		// define web elements
		WebElement userNameElement = driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']"));
		WebElement passwordElement = driver.findElement(By.id("password"));
		WebElement loginButton= driver.findElement(By.id("login-button"));
		
		// fill out fields
		userNameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		loginButton.click();
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("-------- Starting loginElementsPresentTest --------");
		driver = DriverFactory.open(browserType);
		driver.get(pathString);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("-------- Closing loginElementsPresentTest --------\n\n");
		
		driver.close();
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() {
		String filename = "/Users/corinnejoycereloj/eclipse-workspace/Selenium/UserLogin.xls";
		return Excel.get(filename);
	}
}
