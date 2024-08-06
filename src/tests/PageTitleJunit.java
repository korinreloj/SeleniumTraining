package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class PageTitleJunit {
	
	// 1. declare variables and objects at class lever in order to access in multiple throughout the program
	WebDriver driver;
	String pathString = "https://www.saucedemo.com/";
	
	@Test
	public void pageTitleTest() {
		System.out.println("Running the test");
		
//		String browserType = "chrome";
		String expectedPageTitle = "Swag Labs";
		
		driver.get(pathString);
		String actualPageTitle = driver.getTitle();
		
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
//		Assert.fail("We intentionally failed this test");
	}
	
	@Before //framework will run this first before the @Test
	public void setUp() {
		System.out.println("initializing the driver");
		driver = DriverFactory.open("chrome");
	}

	@After //framework will run this after the @Test
	public void tearDown() {
		System.out.println("Closing the driver");
		
		driver.close();
		driver.quit();
	}
}
