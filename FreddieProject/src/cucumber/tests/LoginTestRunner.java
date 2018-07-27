package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features-AMS",
		tags = "@development",
		glue = "cucumber.steps",
		dryRun = false
		)
public class LoginTestRunner {

}
