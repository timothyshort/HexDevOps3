package advanced;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.Home;
import pages.SearchPage;
import utilities.DriverFactory;
import utilities.GlobalConfigs;

public class ShoppingCart {
	WebDriver driver;
	
	@Test
	public void endToEndTest() {
		Home.clickShoppingCartLink(driver);
		SearchPage.searchForProduct(driver, "camera");
	}
	
	@Before
	public void setup() {
		driver = DriverFactory.start("firefox");
		driver.get(GlobalConfigs.ROOT_URL);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
