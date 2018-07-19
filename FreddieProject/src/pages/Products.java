package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	// Instance-level WebDriver
	WebDriver driver;
	String btnPath = "td[3]/a";
	
	// Define all page web elements as variables
	@FindBy(xpath="/html/body/font/table[1]/tbody/tr")
	List<WebElement> productListings; // return list of web elements
	
	// WebElement addToCartBtn;
	
	// Initialize web elements at instantiation
	public Products(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// addToCartBtn = this.driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[1]/td[3]/a"));
	}
	
	// All page actions as methods
	public void addItemToCart(int row) {
		productListings.get(row-1).findElement(By.xpath(btnPath)).click();
	}
	
	
	
	// Add product to cart
	
	// Test to see if we have the right products
	
	// Test the product pricing
	
	// Extract all products
	

}
