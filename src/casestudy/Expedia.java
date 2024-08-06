package casestudy;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.DriverFactory;

public class Expedia {
	WebDriver driver;
	String browserType = "chrome";
	String webURL = "https://www.expedia.com/";
	String destination = "Cebu, Central Visayas, Philippines";
	String childAge = "8";
	
	@Test
	public void hotelReservation() {
		// 1. search
		driver.findElement(By.xpath("//*[@id=\"multi-product-search-form-1\"]/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"multi-product-search-form-1\"]/div/div/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[1]/div/div/div[2]/div[1]/button")).sendKeys(destination, Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/div/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[1]/div/div[3]/div/div/div[3]/div/div[2]/table/tbody/tr[3]/td[2]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/div[1]/div/div[3]/div/div/div[3]/div/div[2]/table/tbody/tr[4]/td[5]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/footer/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[3]/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[3]/div/div[2]/div/div/section/div[1]/div[2]/div[1]/div/button[2]")).click();
		new Select(driver.findElement(By.id("age-traveler_selector_children_age_selector-0-0"))).selectByValue(childAge);
		driver.findElement(By.id("traveler_selector_done_button")).click();
		driver.findElement(By.id("search_button")).click();
		
		// switch windows
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// 2. modify the results page, give criteria
		// 3. analyze the results and make our selection
		// 4. Book reservation
		// 5. fill out contact/billing
		// 6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Expedia"));
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.open(browserType);
		driver.get(webURL);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
