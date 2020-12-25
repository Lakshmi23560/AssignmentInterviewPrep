package RunnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features", glue = { "Stepdefinitions" }, plugin = { "pretty",
		"html:src//reports//SDFCReport.html" }, monochrome = true, tags = "Smoke or @Regression")
public class RunnerFile {

}
