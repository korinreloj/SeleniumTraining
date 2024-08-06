package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.DriverFactory;

public class Login {

	public static void main(String[] args) {
		String pathString = "https://www.saucedemo.com/";
		String userName = "standard_user";
		String password = "secret_sauce";
		int sortFilterIndex = 2;
		String sortFilterValue = "za";
		String sortFilterText= "Price (high to low)";
		
		String browserType = "chrome";
		new DriverFactory();
		WebDriver driver = DriverFactory.open(browserType);
		
		// 2. navigate web app: https://www.saucedemo.com/
		driver.get(pathString);
		
		// 3. enter username id="user-name"
		//driver.findElement(By.id("user-name")).sendKeys(userName);
//		driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']")).sendKeys(userName);
//		driver.findElement(By.name("user-name")).sendKeys(userName);
//		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(userName);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input")).sendKeys(userName);
		
		// 4. enter password id="password"
		driver.findElement(By.id("password")).sendKeys(password);
		
		// 5. click login button id="login-button"
		driver.findElement(By.id("login-button")).click();
		
		// 6. get confirmation id="header_container"
		String pageMessage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		System.out.println("Redirected to page: " + pageMessage);
		
		// 7. apply filter to sort products (dropdown)
		new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"))).selectByIndex(sortFilterIndex);
		new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"))).selectByValue(sortFilterValue);
		new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"))).selectByVisibleText(sortFilterText);
		
		// 8. close the browser
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
			System.out.println("LOGIN SUCCESSFUL");
		}
		
		driver.close();
		driver.quit();
	}

}
