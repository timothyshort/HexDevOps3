package testframeworks;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNGParameterization {
	
	@Test(dataProvider = "usernameTestData")
	public void usernameTest(String username, String password) {
		System.out.println("Executing test");
	}
	
	@DataProvider
	private String[][] usernameTestData() {
		String[][] usernames = {
				{ "tim@testemail.com", "password" },
				{ "lindsey@freddie.com", "lindseypassword" },
				{ "kim@freddie.com", "kpassword" }
		};
		
		return usernames;
	}
	
	// Generic DataProvider Test
	@Test(dataProvider = "genericData")
	public void generticTest(String mortgageType, double interestRate, double principal, String zipCode) {
		System.out.println("************");
		System.out.println(mortgageType);
		System.out.println(interestRate);
		System.out.println(principal);
		System.out.println(zipCode);
	}
	
	@DataProvider
	private Object[][] genericData() {
		Object[][] mortgageData = {
			{ "30-year FIXED", 4.5, 150000, "71108" },
			{ "15-year FHA", 4, 120000, "45669" }
		};
		
		return mortgageData;
	}
}
