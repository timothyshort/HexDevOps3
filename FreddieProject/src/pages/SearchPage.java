package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	// 1. Define (identify) all page elements "up top" as a web element
	
	// 2. Create a constructor to initialize page elements
	// defines all web elements and attaches to the current browser state
	
	// 3. Create Object methods to perform page actions with elements
	
	
	
	// Utility functions
	public static void searchForProduct(WebDriver driver, String product) {
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
	}
	
	// Search textbox
	public static void searchProductText(WebDriver driver, String product) {
		driver.findElement(By.name("txtSearch")).sendKeys(product);
	}
	
	// Search button
	public static void clickSearch(WebDriver driver) {
		driver.findElement(By.id("Go")).click();
	}
	

}
