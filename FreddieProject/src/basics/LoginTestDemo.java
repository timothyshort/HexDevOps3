package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestDemo {

	public static void main(String[] args) {		
		// Open the browser
		System.setProperty("webdriver.gecko.driver", "C:\\HexawareTraining\\Materials\\Software\\Selenium-BDD\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// Open the login page url
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// *interacting with UI:
			// 1. locating the element: how?
			// 2. perform the action
			// 3. provide parameters
		
		// Enter username
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		
		// Enter password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("password");
		
		// Click login button
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		// Validate, verify
		
		
		// Close browser
		driver.quit();
	}

}
