package cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;

public class Login {
	WebDriver driver;
	
	
	@Given("^the guest is on the login page$")
	public void the_guest_is_on_the_login_page() throws Throwable {
		System.out.println("Login page");
		driver = DriverFactory.start("firefox");
	    driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}

	@When("^the user enters \"(.*)\" as username$")
	public void the_user_enters_tim_testemail_com_as_username(String email) throws Throwable {
	    System.out.println("Enter email");
	    driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
	}

	// Exercise:
	// Write the implementation for the password step
	@When("^the user enters \"(.*)\" as password$")
	public void the_user_enters_password(String password) {
		System.out.println("Entering password");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
	}


	@When("^the clicks the login button$")
	public void the_clicks_the_login_button() throws Throwable {
		System.out.println("Click login");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}

	@Then("^the user should see get a welcome message$")
	public void the_user_should_see_get_a_welcome_message() throws Throwable {
	    System.out.println("See welcome message");
	    System.out.println(driver.findElement(By.id("conf_message")).getText());
	}

}
