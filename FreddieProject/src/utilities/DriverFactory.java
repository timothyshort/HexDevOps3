package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	// This function returns a WebDriver
	public static WebDriver start(String browserType) {
		String browserExecutablePath = "C:\\HexawareTraining\\Materials\\Software\\Selenium-BDD\\";
		System.out.println("Starting " + browserType + " browser");
		
		// Logic
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", browserExecutablePath + "chromedriver.exe");
			return new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", browserExecutablePath + "geckodriver.exe");
			return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", browserExecutablePath + "IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", browserExecutablePath + "chromedriver.exe");
			return new ChromeDriver();
		}
		
	}

}
