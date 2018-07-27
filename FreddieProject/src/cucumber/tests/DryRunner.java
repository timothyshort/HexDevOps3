package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features-AMS",
		glue = "cucumber.steps",
		tags = "@development",
		dryRun = true
		)
public class DryRunner {

}
