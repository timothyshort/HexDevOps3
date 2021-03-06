package testframeworks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;

public class JUnitAssertionsExceptions {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = DriverFactory.start("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@After
	public void tearDown() {
		driver.quit();
		System.out.println("Closing test");
	}

	@Test
	public void test() {
		// Login page
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("badpassword");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		boolean expected = false;
		
		// looking a specific element and extracted the text
		if (expected) {
			try {
				Assert.assertTrue("Login message not as expected", driver.findElement(By.id("conf_message")).getText().contains("Logged in"));
			} catch (NoSuchElementException e) {
				fail("Could not find confirmation element");
			}
		} else {
			try {
				Assert.assertTrue("Invalid password message not as expected", driver.findElement(By.id("MainContent_lblTransactionResult")).getText().contains("Invalid password"));
			}
			catch (NoSuchElementException e) {
				fail("Could not find invalid message element");
			}
		}

		// look at the entire page
		String pageText = driver.findElement(By.xpath("html/body")).getText();
		if (expected) { Assert.assertTrue(pageText.contains("Logged in successfully")); }
		else { Assert.assertTrue(pageText.contains("Invalid password")); }
		
	}

}
