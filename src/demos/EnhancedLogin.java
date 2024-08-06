package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.DriverFactory;

public class EnhancedLogin {

	public static void main(String[] args) {
		String pathString = "https://www.saucedemo.com/";
		String userName = "standard_user";
		String password = "secret_sauce";
		int sortFilterIndex = 2;
//		String sortFilterValue = "za";
//		String sortFilterText= "Price (high to low)";
		String firstName = "Katara";
		String lastName = "Sokka";
		String postalCode = "1502";
		String checkoutMessage = "Checkout: Complete!";
		
		String browserType = "chrome";
		WebDriver driver = DriverFactory.open(browserType);
		
		// navigate web app: https://www.saucedemo.com/
		driver.get(pathString);
		
		// define web elements
		WebElement userNameElement = driver.findElement(By.cssSelector("input[class='input_error form_input'][placeholder='Username']"));
		WebElement passwordElement = driver.findElement(By.id("password"));
		WebElement loginButton= driver.findElement(By.id("login-button"));
		
		// fill out fields
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		loginButton.click();
		
		// get confirmation that proceeded to next page
		WebElement productsPageTitle = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
		WebElement filterElement = driver.findElement(By.cssSelector("select[class=\"product_sort_container\"]"));
		WebElement productRedShirt = driver.findElement(By.id("item_3_title_link"));
		String pageMessage = productsPageTitle.getText();
		System.out.println("Redirected to page: " + pageMessage);
		
		// apply filter to sort products (dropdown)
		new Select(filterElement).selectByIndex(sortFilterIndex);
//		new Select(filterElement).selectByValue(sortFilterValue);
//		new Select(filterElement).selectByVisibleText(sortFilterText);
		
		// close the browser
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
			System.out.println("LOGIN SUCCESSFUL");
		}

		productRedShirt.click();
		
		
		//add to cart
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
		WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
		String currentProductTitle = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
		System.out.println("Redirected to product: " + currentProductTitle);
		
		addToCartButton.click();
		shoppingCart.click();
		
		//shopping cart
		WebElement checkoutButton = driver.findElement(By.id("checkout"));
		String shoppingCartTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		System.out.println("Redirected to cart page: " + shoppingCartTitle);
		
		checkoutButton.click();
		
		//checkout step 1
		WebElement firstNameElement = driver.findElement(By.id("first-name"));
		WebElement lastNameElement = driver.findElement(By.id("last-name"));
		WebElement postalCodeElement = driver.findElement(By.id("postal-code"));
		WebElement continueButton = driver.findElement(By.id("continue"));
		
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);

		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
		postalCodeElement.sendKeys(postalCode);
		
		continueButton.click();
		
		//checkout step 2
		WebElement finishTransactionButton = driver.findElement(By.id("finish"));
		finishTransactionButton.click();
		
		// checkout successful page
		String checkoutMessageElement = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		if (checkoutMessage.equals(checkoutMessageElement)) {
			System.out.println(checkoutMessageElement);
		} else {
			System.out.println("Checkout Failed");
		}

		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();

//		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
		logoutLink.click();
		
		driver.close();
		driver.quit();
	}

}
