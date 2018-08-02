package cucumber.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.DriverFactory;

public class Hooks {
	WebDriver driver;
	
	public void setup() {
		System.out.println("RUNNING SETUP IN HOOKS");
		driver = DriverFactory.start("firefox");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	/*
	
	@After
	public void tearDown() {
		driver.quit();
	}
	*/

}
