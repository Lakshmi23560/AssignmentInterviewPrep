package StepDefinitions;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.PoAgentsPage;
import PageObjects.PoHomePage;
import PageObjects.PoPropertiesListingPage;
import PageObjects.PoPropertyPage;
import Utilities.Testbase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition extends Testbase {

	PoHomePage homepage;
	PoPropertiesListingPage PropertiesListingPage;
	PoPropertyPage propertypage;
	PoAgentsPage agentspage;

//	@Before
//	public void setUp() throws Exception {
//		Testbase.propertyExtentSetup();
//		// Testbase.Initialize();
//	}
//
//	@After
//	public void teardown() {
//		// driver.close();
//		reports.endTest(logger);
//		reports.flush();
//	}

	@Given("^the Zoopla application is launched for \"([^\"]*)\"$")
	public void the_Zoopla_application_is_launched_for(String testName) throws Throwable {
		Testbase.logger = Testbase.reports.startTest(testName);
	}

	@Then("^verify the home page using \"([^\"]*)\"$")
	public void verify_the_home_page_using(String homePageTitle) throws Throwable {
		homepage = new PoHomePage(driver);
		String ActualTitle = homepage.validateHomePage();
		Boolean result = oBrowsUtil.verify_Text(ActualTitle, homePageTitle, "HomePage");
		Assert.assertTrue(result);
	}

	@When("^enter the \"([^\"]*)\" in searchbox and press the search button$")
	public void enter_the_in_searchbox_and_press_the_search_button(String Location) throws Throwable {
		homepage.enterTextSearchBox(Location);
	}

	@Then("^validate list of properties page \"([^\"]*)\"$")
	public void validate_list_of_properties_page(String arg1) throws Throwable {
		PropertiesListingPage = new PoPropertiesListingPage(driver);
		PropertiesListingPage.validatePropertiesPage();
	}

	@When("^print all the price values in sorted order\\(descending order\\) on the console$")
	public void print_all_the_price_values_in_sorted_order_descending_order_on_the_console() throws Throwable {
		PropertiesListingPage.selectdropdownHighestprice();
	}

	@When("^select the fifth property on the list of properties$")
	public void select_the_fifth_property_on_the_list_of_properties() throws Throwable {
		PropertiesListingPage.selectFifthListing();
	}

	@Then("^verify the property list page with logo,agentname and telephone$")
	public void verify_the_property_list_page_with_logo_agentname_and_telephone() throws Throwable {
		propertypage = new PoPropertyPage(driver);
		String propertypagetitle = driver.getTitle();
		System.out.println(propertypagetitle);
		String propertypageAgent = propertypage.getAgentName();
		System.out.println("propertypage agent name : " + propertypageAgent);
	}

	@When("^click on the agentname link to get into agents page$")
	public void click_on_the_agentname_link_to_get_into_agents_page() throws Throwable {
		Thread.sleep(5000);
		propertypage.clickOnAgentName();

	}

	@Then("^Verify the properties listed  belong to the same mentioned \"([^\"]*)\" on the agents page\\.$")
	public void verify_the_properties_listed_belong_to_the_same_mentioned_on_the_agents_page(String agentname)
			throws Throwable {
		agentspage = new PoAgentsPage(driver);
		Thread.sleep(5000);
		String agentspagename = agentspage.validateAgentName();
		if (agentspagename.contains(agentname)) {
			logger.log(LogStatus.PASS, "property's page agent name and agent's page name are same");
		} else {
			logger.log(LogStatus.FAIL, "property's page agent name and agent's page name are not same"
					+ logger.addScreenCapture(takeScreenshot()));
		}

	}

}
