package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FreddieLenderApp {

	@Then("a client logs into the system")
	public void systemIn() {
		System.out.println("client logs in");
	}
	
	@Given("the client submits a loan application")
	public void the_client_submits_a_loan_application() {
		System.out.println("client submits a loan application");
	}

	@Given("the client gets a receipt confirmation")
	public void the_client_gets_a_receipt_confirmation() {
		System.out.println("client gets confirmation");
	}
	
}
