package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class LoginTestParameterized {
	
	public static void main(String[] args) throws InterruptedException {
		// Define datasets
		String[] usernames = { "tim@testemail.com", "abadtestemail@mail.com", "jason@testemail.com"};
		String[] passwords = { "password", "yesthisisabadpassword", "jpassword" };
		String[] browsers = { "Chrome", "Firefox", "IE" };
		boolean[] expectations = { true, false, true }; 
		int numberOfCases = usernames.length;
		
		// Iterate through test case
		for (int i=0; i<numberOfCases; i++) {
			System.out.println("***TEST CASE: " + i + " ***");
			
			// Print the test cases
			String username = usernames[i];
			String password = passwords[i];
			boolean expected = expectations[i];
			String browserType = browsers[i];
			System.out.println(username + " " + password);
			
			// Open browser
			WebDriver driver = DriverFactory.start(browserType);
			driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
			
			// Enter login
			driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
			driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
			driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
			
			// Validate expected outcome
			String pageText = driver.findElement(By.xpath("html/body")).getText();
			if (expected) {
				System.out.println("Expected: Pass");
				if (pageText.contains("Logged in successfully")) {
					System.out.println("Test passed!");
				}
				else {
					System.out.println("Test FAILED");
				}
			}
			else {
				System.out.println("Expected: Fail");
				if (pageText.contains("Invalid user name")) {
					System.out.println("Test passed!");
				}
				else {
					System.out.println("Test FAILED");
				}
			}
			System.out.println("Acual Text\n" + pageText);
			
			// Close browser
			// Thread.sleep(5000);
			driver.quit();
		}
	}

}
