package cucumber.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;

public class Login {
	Hooks hooks;
	WebDriver driver;
	
	public Login(Hooks hooks) {
		System.out.println("LOGIN CONSTRUCTOR!");
		this.hooks = hooks;
	}
	
	@Given("^the guest is on the login page$")
	public void the_guest_is_on_the_login_page() throws Throwable {
		System.out.println("Login page");
		hooks.setup();
		driver = hooks.getDriver();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		// driver = 
		// driver = DriverFactory.start("firefox");
	    // driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}

	@When("^the user enters \"(.*)\" as username$")
	public void the_user_enters_tim_testemail_com_as_username(String email) throws Throwable {
	    System.out.println("Enter email");
	    driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
	}
	
	// Exercise:
	// Write the implementation for the password step
	@When("^the user enters (.*) as password$")
	public void the_user_enters_password(String password) {
		System.out.println("Entering password");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
	}
	
	// Exercise
	// Write implementation for two parameters
	@When("^the user enters \"(.*)\" and \"(.*)\" and clicks login$")
	public void enters_credentials(String email, String password) {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
	
	// Write implementation for datatable at step-level
	@When("the user enters credentials")
	public void the_user_enters_credentials(DataTable data) {
		// Convert into Collection list
		List<List<String>> credentials = data.raw();
		
		// Parse into local variables
		String email = credentials.get(0).get(0);
		String password = credentials.get(0).get(1);
		
		enterCredsAndClickLogin(email, password);
	}
	
	// Write implementation for datatable at step-level: using LIST
	@When("the user enters three bad login attempts and then a good login attempt")
	public void the_user_enters_three_login_credentials(DataTable data) {
		List<List<String>> credentials = data.raw();
		for (List<String> credential : credentials) {
			String email = credential.get(0);
			String password = credential.get(1);
			enterCredsAndClickLogin(email, password);
		}
	}
	
	// Write implementation for datatable at step-level: using MAP
	@When("the user enters two bad login attempts and then a good login attempt")
	public void the_user_enters_two_login_credentials(DataTable data) {
		List<Map<String, String>> credentials = data.asMaps(String.class, String.class);
		for (Map<String, String> credential : credentials) {
			String email = credential.get("Username");
			String password = credential.get("Password");
			enterCredsAndClickLogin(email, password);
		}
	}
	
	private void enterCredsAndClickLogin(String email, String password) {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).clear();
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).clear();			
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}

	@When("^the clicks the login button$")
	public void the_clicks_the_login_button() throws Throwable {
		System.out.println("Click login");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}

	@Then("^the user should see get a welcome message$")
	public void the_user_should_see_get_a_welcome_message() throws Throwable {
	    System.out.println("See welcome message");
	    try {
	    	System.out.println(driver.findElement(By.id("conf_message")).getText());
	    } catch (Exception e) {
	    	Assert.fail();
	    }
	}
	
	@Given("^when the user is on the login page$")
	public void when_the_user_is_on_the_login_page() throws Throwable {
	    System.out.println("user on login page");
	}

	@Given("^when the user logs using credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void when_the_user_logs_using_credentials_and(String username, String password) throws Throwable {
	    System.out.println("user credentials: " + username + " " + password);
	}

	@Then("^the user should able to see \"([^\"]*)\"$")
	public void the_user_should_able_to_see(String message) throws Throwable {
	    System.out.println("user sees: " + message);
	}

}
