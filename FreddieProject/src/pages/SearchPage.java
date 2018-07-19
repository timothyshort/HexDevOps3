package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	// Define instance-level WebDriver
	private WebDriver driver;
	
	// 1. Define (identify) all page elements "up top" as a web element	
	@FindBy(name = "txtSearch")
	WebElement searchTxt;
	
	@FindBy(id = "Go")
	WebElement searchBtn;
	
	// 2. Create a constructor to initialize page elements
	// defines all web elements and attaches to the current browser state
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// 3. Create Object methods to perform page actions with elements
	// utilities
	public void setSearch(String product) {
		searchTxt.sendKeys(product);
	}
	public void clickSearch() {
		searchBtn.click();
	}
	
	
	public void searchForProduct(String product) {
		setSearch(product);
		clickSearch();
	}
	
	
	
	
	
	/*
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
	*/

}
