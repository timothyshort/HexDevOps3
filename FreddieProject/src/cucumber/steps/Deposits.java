package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Deposits {
	
	@Given("^the user logged in$")
	public void the_user_logged_in() throws Throwable {
	    System.out.println("The user is logged in");
	}

	@Given("^the user sees Make Deposit$")
	public void the_user_sees_Make_Deposit() throws Throwable {
	    System.out.println("The user sees Make Deposit");
	}

	@When("^the user clicks Make Deposit$")
	public void the_user_clicks_Make_Deposit() throws Throwable {
	    System.out.println("The user clicks Make Deposit");
	}

	@Then("^the user is taken the deposits page$")
	public void the_user_is_taken_the_deposits_page() throws Throwable {
	    System.out.println("The user is taken to the deposits page");
	}



}
