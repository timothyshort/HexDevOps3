package basics;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String product = "camera";
		int searchResult = 3;
		
		// Search for product
		driver.findElement(By.name("txtSearch")).sendKeys(product);
		driver.findElement(By.id("Go")).click();
		
		// Assert that we are seeing products
		String searchResultProduct = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[2]/font[2]/b")).getText();
		System.out.println(searchResultProduct);
		Assert.assertTrue((searchResultProduct.toUpperCase()).contains(product.toUpperCase()));
		
		// Capture and price of the product
		String searchResultPrice = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[3]/font")).getText();
		System.out.println(searchResultPrice);
		
		// Parameterized Xpath
		WebElement productResult = driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[" + searchResult + "]"));
		//System.out.println(productResult.getText());
		System.out.println("Product: " + productResult.findElement(By.xpath("td[2]/font[2]/b")).getText());
		System.out.println("Price: " + productResult.findElement(By.xpath("td[3]/font")).getText());
		
		// Assert all results are products
		System.out.println("****ASSSER THAT ALL PRODUCTS ARE : " + product);
		// Find all listings in search results
		List<WebElement> tableResults = driver.findElements(By.xpath("/html/body/font/table[1]/tbody/tr"));
		// Iterate through the results
		for (WebElement result : tableResults) {
			System.out.println("PRODUCT: " + result.findElement(By.xpath("td[2]/font[2]")).getText());
			Assert.assertTrue(result.getText().toUpperCase().contains(product.toUpperCase()));
		}
		
		
		// Add item to cart
		driver.findElement(By.xpath("/html/body/font/table[1]/tbody/tr[1]/td[3]/a")).click();
		
		// Cart page
		// Extract grand total
		List<WebElement> shopCartItems = driver.findElements(By.xpath("/html/body/font/form/table/tbody/tr"));
		WebElement grandTotal = shopCartItems.get(shopCartItems.size()-1);
		System.out.println("CART TOTAL: " + grandTotal.findElement(By.xpath("td[2]")).getText());
		
		// Checkout, enter billing
		driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Proceed to Checkout']")).click();
		driver.findElement(By.cssSelector("input[name='cmdSubmit'][value='Submit Order']")).click();
		
		
		// Confirmation
		
		// 1. Confirm success message
		String confMessage = "Thank you for ordering with us!";
		String orderResult = driver.findElement(By.xpath("html/body")).getText();
		Assert.assertTrue(orderResult.contains(confMessage));
		
		// 2. Extract confirmation number (use RegEx)
		String pattern = "Order# (.*) safe";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(orderResult);
		m.find();
		String confNumber = m.group(1);
		System.out.println("Confirmation #" + confNumber);
	}

}
