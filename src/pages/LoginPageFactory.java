package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    WebDriver driver;

    //initializing in class level
    @FindBy(css="input[class='input_error form_input'][placeholder='Username']")
    WebElement usernameTextbox;

    @FindBy(id="password")
    WebElement passwordTextbox;
    
    @FindBy(id="login-button")
    WebElement loginButton;
	
 // constructors initialize the state of the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Steps
	public void setUsername(String username) {
		usernameTextbox.sendKeys(username);
	}

	public void setPassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	
	public void clickSubmit() {
		loginButton.click();
	}
	
	//Actions
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickSubmit();
	}
}
