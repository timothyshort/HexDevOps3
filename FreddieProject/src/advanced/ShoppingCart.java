package advanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.Home;
import pages.Products;
import pages.SearchPage;
import utilities.DriverFactory;
import utilities.GlobalConfigs;

public class ShoppingCart {
	WebDriver driver;
	
	// @Test
	public void smokeTest() {
		SearchPage search = new SearchPage(driver);
		search.clickSearch();
		// Assert ??
	}
	
	@Test
	public void endToEndTest() {
		SearchPage search = new SearchPage(driver);
		search.searchForProduct("tv");
		
		Products products = new Products(driver);
		products.addItemToCart(2);
		
		Assert.assertTrue(driver.getPageSource().contains("Proceed to Checkout"));
	}
	
	@Before
	public void setup() {
		driver = DriverFactory.start("firefox");
		driver.get(GlobalConfigs.ROOT_URL);
		Home.clickShoppingCartLink(driver); // page utility function
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
