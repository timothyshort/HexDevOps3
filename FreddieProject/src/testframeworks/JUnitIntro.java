package testframeworks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitIntro {
	
	// guides the flow of the program (or test) with annotations
	// pass/fail tests with assertions
	
	// run setup() before each test
	@Before
	public void setup() {
		System.out.println("Start browser session, initialize settings, connect to data source");
	}
	
	// Execute UI test steps
	@Test
	public void test1() {
		System.out.println("Running test1");
		// Assertions: compare two values and will fail if false
		String expectedValue = "success";
		String actualValue = "fail";
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void test2() {
		System.out.println("Running test2");
	}
	
	// run tearDown() after each test
	@After
	public void tearDown() {
		System.out.println("Close the browser session, generate reports");
	}

}
