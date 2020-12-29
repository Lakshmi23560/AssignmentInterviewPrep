package StepDefinitions;

import Utilities.Testbase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Testbase {

	@Before
	public void setup() throws Exception {
		propertyExtentSetup();
	}

	@After
	public void teardown() {
		// driver.close();
		reports.endTest(logger);
		reports.flush();

	}

}
