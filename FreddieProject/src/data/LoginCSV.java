package data;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import utilities.CSV;
import utilities.GlobalConfigs;

@RunWith(value=Parameterized.class)
public class LoginCSV {
	String username;
	String password;
	
	@Before
	public void setup() {
		System.out.println("*********STARTING");
	}
	
	@After
	public void teardown() {
		System.out.println("************ENDING");
	}
	
	@Test
	public void loginTest() {
		System.out.println("RUNNING TEST");
		System.out.println("USERNAME: " + username);
		System.out.println("PASSWORD: " + password);
	}
	
	@Parameters
	public static List<String[]> getLoginData() {
		return CSV.get(GlobalConfigs.TESTDATA_DIR + "LoginData.txt");
	}
	
	public LoginCSV(String username, String password) {
		this.username = username;
		this.password = password;
	}
	

}
