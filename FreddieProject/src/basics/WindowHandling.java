package basics;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.Windows;

public class WindowHandling {
	WebDriver driver;

	@Before
	public void setup() {
		driver = DriverFactory.start("firefox");
		driver.get("http://sdettraining.com/projects/windows.html");
	}
	
	
	@Test
	public void windowHandling() throws InterruptedException {
		// click create account
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		Thread.sleep(2000);
		
		String mainWindow = driver.getWindowHandle();
		
		/*
		// Iterate through all the windows
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			System.out.println("CURRENT WINDOW: " + driver.getTitle() + " " + driver.getCurrentUrl());
		}
		*/
		
		/*
		// Create a data structure that holds all windows
		ArrayList<String> openWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(mainWindow);
		driver.switchTo().window(openWindows.get(1));
		*/
		
		// Use a utility function to dynamically choose which window to switch to
		Windows.chooseWindowByTitle(driver, "Account Management");
		
		
		// Fill out new account
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("Tim@Testemail.com");
	}
	
	@Test
	public void popUpHandling() throws InterruptedException {
		boolean deleteAccount = false;
		
		// Click delete account button
		driver.findElement(By.id("delete_account")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(2000);
		
		// Handle alert
		if (deleteAccount) {
			// Accept the alert
			driver.switchTo().alert().accept();
		} else {
			// Cancel the alert
			driver.switchTo().alert().dismiss();
		}
		Thread.sleep(2000);
		
		// Click OK after validation
		System.out.println("CONFIRMATION: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}