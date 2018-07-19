package advanced;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.Home;
import utilities.DriverFactory;

public class HomePageLinks {
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = DriverFactory.start("firefox");
		driver.get("http://sdettraining.com/projects/");
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void testMainAppLinks() {
		// Test 3 main links
		//Home.clickLoanDeliveryApplication(driver);
		Home.loanDeliveryLink(driver).click();
		driver.navigate().back();
		Home.clickAccountManagement(driver);
		driver.navigate().back();
		Home.clickShoppingCartLink(driver);
	}
	
	
	
	public void testHomePage() {
		// Test all links
		for (WebElement aTag : pages.Home.getAllLinks(driver)) {
			aTag.click();
			System.out.println(driver.getTitle());
			// Assert statement
			driver.navigate().back();
		}
	}

}
