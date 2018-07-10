package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// overloaded screenshots functions for taking a screenshot
public class Screenshot {
	
	// takes a screenshot of webdriver and makes a .jpg file
	public static void take(WebDriver driver, String file) {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filepath = "C:\\HexawareTraining\\Cohort3\\Selenium-BDD\\Workspace\\FreddieProject\\screenshots\\";
		String filename = filepath + file + ".jpg";
		File destinationFile = new File(filename);
		try {
			FileUtils.copyFile(screenshotFile, destinationFile);
		} catch (IOException e) {
			System.out.println("ERROR: Could not capture screenshot");
			e.printStackTrace();
		}
	}
	
	// takes screenshot with test case as folder
	public static void take(WebDriver driver, String file, String testCase) {
		// call .take() with testcase/file as the file parameter
		take(driver, testCase + "\\" + file);
	}
	
	// takes screenshot with test case folder and outcome folder
	public static void take(WebDriver driver, String file, String testCase, boolean outcome) {
		if (outcome) {
			take(driver, file, testCase + "\\passed");
		} else {
			take(driver, file, testCase + "\\failed");
		}
	}

}
