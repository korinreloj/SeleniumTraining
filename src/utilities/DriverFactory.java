package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
//	This method returns a WebDriver Object
	public static WebDriver open(String browserType) {// create webdriver
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/corinnejoycereloj/eclipse-workspace/Selenium/chromedriver");
			System.out.println("Using Chrome");
			return new ChromeDriver();
		} 
		else {
			System.setProperty("webdriver.chrome.driver", "/Users/corinnejoycereloj/eclipse-workspace/Selenium/geckodriver");
			System.out.println("Using Firefox");
			return new FirefoxDriver();
		}
		
	}

}
