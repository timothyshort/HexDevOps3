package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = "cukes.test",
		tags = "@AUT",
		dryRun = false
		)
public class DryRunner {

}
