package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountEnhanced {

	public static void main(String[] args) {
		// Declare variables
		WebDriver driver;
		
		// Declare and define variables
		String browserType = "Firefox";
		String browserExecutablePath = "C:\\HexawareTraining\\Materials\\Software\\Selenium-BDD\\";
		String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		String firstName = "Jason";
		String email = "jason@testemail.com";
		String gender = "Female";
		String createAccountLink = "Create Account";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean emailUpdates = false;
		
		// Initialize browser settings
		if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", browserExecutablePath + "chromedriver.exe");
			driver = new ChromeDriver();
			createAccountLink = "CREATE ACCOUNT";
		}
		else if (browserType.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", browserExecutablePath + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", browserExecutablePath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			createAccountLink = "CREATE ACCOUNT";
		}
		// Open browser and click Create Account
		driver.get(url);
		driver.findElement(By.linkText(createAccountLink)).click();
		
		// Fill out the form
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys(firstName);
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys(email);
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys("1231231234");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("jpassword");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("jpassword");
		new Select(driver.findElement(By.name("ctl00$MainContent$menuCountry"))).selectByValue("Canada");
		
		// radio button with selector: find radio button with group name and select specific value
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='" + gender + "'")).click();
		
		// checkbox algorithm
		selectCheckbox(driver, weeklyEmail, "MainContent_checkWeeklyEmail");
		selectCheckbox(driver, monthlyEmail, "MainContent_checkMonthlyEmail");
		selectCheckbox(driver, emailUpdates, "MainContent_checkUpdates");

		// Submit the form & validate
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		if (driver.findElement(By.id("MainContent_lblTransactionResult")).getText().equals("Customer information added successfully")) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed");
			System.out.println(driver.findElement(By.id("MainContent_lblTransactionResult")).getText());
		}
		
		// Close browser
		driver.quit();		
	}

	// checkbox algorithm function
	static void selectCheckbox(WebDriver driver, boolean desiredOption, String element) {
		if (desiredOption) {
			if (!driver.findElement(By.id(element)).isSelected()) {
				driver.findElement(By.id(element)).click();
			}
		} else {
			if (driver.findElement(By.id(element)).isSelected()) {
				driver.findElement(By.id(element)).click();
			}
		}
	}
}
