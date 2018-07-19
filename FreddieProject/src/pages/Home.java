package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// BAD WAY: this class is nothing more than a utility class
public class Home {
	
	// We want to be able to interactive with ANY and ALL elements on this page
	
	// 1. Get all Link tags
	public static List<WebElement> getAllLinks(WebDriver driver) {
		return driver.findElements(By.tagName("a"));
	}
	
	// 2. Click on Loan Delivery Application
	public static void clickLoanDeliveryApplication(WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();
	}
	
	public static WebElement loanDeliveryLink(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]"));
	}
	
	// 3. Click on Account Management Application
	public static void clickAccountManagement(WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
	}
	
	// 4. Click on Shopping Cart Application
	public static void clickShoppingCartLink(WebDriver driver) {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[3]")).click();
	}

}
