package data;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.Excel;
import utilities.GlobalConfigs;

public class NewAccountEXCEL {
	
	@BeforeMethod
	public void setup() {
		System.out.println("*********STARTING");
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("************ENDING");
	}
	
	@Test(dataProvider = "getNewAccountData")
	public void loginTest(String firstName, String lastName, String gender, String email, String password, String phone, String country, String email1, String email2, String email3) {
		System.out.println("RUNNING TEST");
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Email: " + email);
	}
	
	@DataProvider
	private String[][] getNewAccountData() {
		return Excel.get(GlobalConfigs.TESTDATA_DIR + "NewAccountData.xlsx");
	}

}
