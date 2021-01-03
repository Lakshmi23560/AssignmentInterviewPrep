package RunnerFile;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features", glue = { "StepDefinitions" }, plugin = { "pretty",
		"html:test_output", "junit:junit_report.cucumber.xml",
		"json:json.cucumber.json" }, monochrome = true, dryRun = false)

public class Runnerfile extends AbstractTestNGCucumberTests {

}
