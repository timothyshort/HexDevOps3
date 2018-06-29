package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	// This function returns a WebDriver
	public static WebDriver start(String browserType) {
		System.out.println("Starting " + browserType + " browser");
		// Logic
		
		System.setProperty("webdriver.gecko.driver", "C:\\HexawareTraining\\Materials\\Software\\Selenium-BDD\\geckodriver.exe");
		return new FirefoxDriver();
	}

}
