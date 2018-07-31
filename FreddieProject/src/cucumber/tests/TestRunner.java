package cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "features", "features-AMS" },
		glue = "cucumber.steps",
		tags = { "@AccountSystem" },
		plugin = { "pretty",
				"json:reports/cucumberDocumentation.json",
				"html:reports" },
		// format = { "json:reports/cucumberResults.json" },
		dryRun = false)
public class TestRunner {

}

/*
 * tags can run at Scenario or Feature level
 * Condition evaluates to True or False
 * TRUE: "@success" - run all scenarios with tag 
 * FALSE: "~@success" - run all scenarios without tag
 * AND: { "@success", "@govReg"} - scenarios has BOTH tags
 * OR: { "@success, @govReg" } - scenarios with ANY tags
 * COMPLEX: { "@success", "@govReg, @end2end" } - scenario has @success and at least one of @govReg and @end2end
*/