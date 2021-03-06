package utilities;

import org.openqa.selenium.WebDriver;

public class Windows {
	
	// iterate through all windows and stop when the page title contains the parameter
	public static void chooseWindowByTitle(WebDriver driver, String titleParam) {
		for (String window : driver.getWindowHandles()) {
			if (driver.switchTo().window(window).getTitle().contains(titleParam)) {
				break;
			}
		}
	}

}
