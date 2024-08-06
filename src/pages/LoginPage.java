package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']")).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickSubmit() {
		driver.findElement(By.id("login-button")).click();
	}
}
