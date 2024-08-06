package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class ATagsTest {

	WebDriver driver;
	
	@Test
	public void aTagsTest() {
		System.out.println("-------- Running aTagsTest --------");
		boolean privacyPolicyPresent = false;
		
		// test presence of a tags/hyperlinks
		List<WebElement> aElements = driver.findElements(By.tagName("a"));
		System.out.println("Number of a elements: " + aElements.size());
		
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("Privacy Policy")) {
				privacyPolicyPresent = true;
				break;
			}
		}

		Assert.assertTrue(privacyPolicyPresent);
//		Assert.assertTrue(!privacyPolicyPresent);
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("-------- Starting aTagsTest --------");
		driver = DriverFactory.open("chrome");

		String pathString = "https://practicetestautomation.com/practice-test-login/";
		driver.get(pathString);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("-------- Closing aTagsTest --------\n\n");
		
		driver.close();
		driver.quit();
	}
}
