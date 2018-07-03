package testframeworks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class JUnitParameterized {
	// Define class-level variables
	String email;
	String password;
	String expectedValue;
	String browser;
	
	@Parameters
	public static String[][] testData() {
		// call utility function to get data from external source
		// return utilities.CSV.get(C:\Training\testdata.csv)
		
		String[][] records = {
				{ "chrome", "tim@testemail.com", "password", "pass" },
				{ "ie", "badlogin", "badpassword", "fail" },
				{ "firefox", "jason@testemail.com", "jpassword", "pass" }
			};
		return records;
	}
	
	// Constructor: receives @parameters for each iteration
	public JUnitParameterized(String browser, String email, String password, String expectedValue) {
		System.out.println("RUNNING CONSTRUCTOR");
		this.browser = browser;
		this.email = email;
		this.password = password;
		this.expectedValue = expectedValue;
	}
	
	@Test
	public void test() {
		System.out.println("Username: " + email);
		System.out.println("Password: " + password);
		System.out.println("Expected: " + expectedValue);
		Assert.assertEquals(expectedValue, "pass");
	}
	
	@Before
	public void setup() {
		System.out.println("Starting on browser: " + browser);
	}
	

}