package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String confirmationMessage(String username) {
		return driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
	}
}
