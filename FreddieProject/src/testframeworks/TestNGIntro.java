package testframeworks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {
	
	@Test
	public void freddieLoginTest() {
		System.out.println("*********Executing login test***********");
	}
	
	@Test
	public void freddieFeatureTest() {
		String userID = "1etm";
		String actualID = "25tu";
		Assert.assertEquals(userID, actualID);
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Setting up the test");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing out the test");
	}

}
