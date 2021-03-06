package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountDemo {

	public static void main(String[] args) {
		// Initialize browser settings
		System.setProperty("webdriver.gecko.driver", "C:\\HexawareTraining\\Materials\\Software\\Selenium-BDD\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		
		// Click Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		
		// Fill out the form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Jason");
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("jason@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys("1231231234");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("jpassword");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("jpassword");
		
		// radio button: use ID
		driver.findElement(By.id("MainContent_Male")).click();
		
		// select: new Select element from Selenium ui support class
		new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByValue("Canada");
		
		// checkbox: use ID/name (note: independence)
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		
		
		// Submit the form
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
		// Validation: conditional logic - if (expected condition) > test passes; else > test fails
		// if result is equal to success message
		if (driver.findElement(By.id("MainContent_lblTransactionResult")).getText().equals("Customer information added successfully")) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed");
			System.out.println(driver.findElement(By.id("MainContent_lblTransactionResult")).getText());
		}
		
		// Close browser
		driver.quit();
		
	}

}
