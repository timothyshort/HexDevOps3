package basics;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DriverFactory;

public class ShoppingCartDemo {
	
	@Test
	public void shopCartTest() {
		WebDriver driver = DriverFactory.start("firefox");
		driver.get("http://sdettraining.com/online/default.asp");
		String product = "tv";
		int searchResult = 3;
		
		// Search for product
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
		
		// Assert that we are seeing TVs
		String searchResultProduct = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[2]/font[2]/b")).getText();
		//System.out.println(searchResultProduct);
		Assert.assertTrue((searchResultProduct.toUpperCase()).contains(product.toUpperCase()));
		
		// Capture and price price of the product
		String searchResultPrice = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[3]/font")).getText();
		//System.out.println(searchResultPrice);
		
		// Parameterized Xpath
		WebElement productResult = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[" + searchResult + "]"));
		System.out.println(productResult.getText());
		//System.out.println("Product: " + productResult.findElement(By.xpath("td[2]/font[2]/b")).getText());
		//System.out.println("Price: " + productResult.findElement(By.xpath("td[3]/font")).getText());
		
		/*
		int row = 2;
		int column = 3;
		System.out.println(driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[" + row + "]/td[" + column + "]")).getText());
		*/
		
	}

}
