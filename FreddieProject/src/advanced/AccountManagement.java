package advanced;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DriverFactory;
import utilities.Screenshot;

public class AccountManagement {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("**********NEW TEST");
		System.out.println("Opening Selenium");
		driver = DriverFactory.start("firefox");
		driver.get("http://sdettraining.com/projects/");
		driver.findElement(By.linkText("Account Management System")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing Selenium\n");
		driver.quit();
	}
	
	@Test(dataProvider = "testData")
	public void loginTest(String username, String password, boolean expected) {
		System.out.println("Retrieving data");
		System.out.println(username);
		System.out.println(password);
		System.out.println(expected);
		
		// UI actions
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		
		// Take screenshot of credentials
		Screenshot.take(driver, username + "-credentials", "AMS");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		// Take screenshot of results
		Screenshot.take(driver, username + "-result", "AMS");
		
		// Assert value
		if (expected) {
			Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("Logged in"));
		} else {
			Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("Invalid user name"));
		}
		
		System.out.println("Test passed!");
		
	}
	
	@DataProvider
	private Object[][] testData() {
		return new Object[][] {
				{ "tim@testemail.com", "password", true },
				{ "lindsey@freddie.com", "lindseypassword", false },
				{ "kim@freddie.com", "kpassword", false }
		};
	}

}
