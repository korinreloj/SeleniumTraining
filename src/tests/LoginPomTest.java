package tests;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;
import pages.LoginPageFactory;
import utilities.DriverFactory;

public class LoginPomTest {
	
	String pathString = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";

	@Test
	public void loginPomTest() {
		// 1. Initialize driver
		WebDriver driver = DriverFactory.open("chrome");
		driver.get(pathString);
		
		// 2. Enter login information (Login Page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(userName);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		// 3. Get confirmation (Home Page)
		HomePage homePage = new HomePage(driver);
		String actualMessage = homePage.confirmationMessage(pathString);
		
		// 4. Assertions
		assertEquals(actualMessage, "Products");
		System.out.println("Login successful");
		
		// 5. Close the driver
		driver.close();
		driver.quit();
		
	}
	

	@Test
	public void loginFactoryTest() {
		// 1. Initialize driver
		WebDriver driver = DriverFactory.open("chrome");
		driver.get(pathString);
		
		// 2. Enter login information (Login Page)
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login(userName, password);
		
		// 3. Get confirmation (Home Page)
		HomePage homePage = new HomePage(driver);
		String actualMessage = homePage.confirmationMessage(pathString);
		
		// 4. Assertions
		assertEquals(actualMessage, "Products");
		System.out.println("Login successful");
		
		// 5. Close the driver
		driver.close();
		driver.quit();
		
	}
}
