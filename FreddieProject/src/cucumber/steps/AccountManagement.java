package cucumber.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.Screenshot;

public class AccountManagement {
	WebDriver driver;
	
	@Before
	public void setup(Scenario s) {
		System.out.println(s.getName());
		driver = DriverFactory.start("firefox");
	}
	
	@After
	public void tearDown(Scenario s) {
		if (s.isFailed()) {
			System.out.println("Scenario Failed: Taking Screenshot");
			Screenshot.take(driver, s.getName() + "Cucumber-fail");
		}
		driver.quit();
	}
	
	// Background
	@Given("^the user is on the login page$")
	public void the_user_is_on_the_login_page() throws Throwable {
	    driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	// Background
	@Given("^the user enters valid credentials$")
	public void the_user_enters_valid_credentials() throws Throwable {
	    System.out.println("Enters credentials");
	}

	@Then("^the user should see a welcome message$")
	public void the_user_should_see_a_welcome_message() throws Throwable {
	    System.out.println("Sees welcome message");
	}

	@Then("^the user should see their bill$")
	public void the_user_should_see_their_bill() throws Throwable {
	    System.out.println("See bills");
	}
	
	@Then("^the user should see account information$")
	public void the_user_should_see_account_information() throws Throwable {
		System.out.println("See account info");
	}

	@When("^the clicks logout$")
	public void the_clicks_logout() throws Throwable {
	    System.out.println("Clicks logout");
	}

	@Then("^user should be logged out$")
	public void user_should_be_logged_out() throws Throwable {
	    System.out.println("Logs out");
	}

	@When("^the user is idle for (\\d+) minutes$")
	public void the_user_is_idle_for_minutes(int arg1) throws Throwable {
	    System.out.println("Idle");
	}

	@Then("^the should be logged out$")
	public void the_should_be_logged_out() throws Throwable {
	    System.out.println("Logged off");
	}

}
