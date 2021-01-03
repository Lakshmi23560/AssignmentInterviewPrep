package StepDefinitions;

import org.testng.Assert;

import PageObjects.PoHomePage;
import PageObjects.PoRealEstatePage;
import Utilities.Testbase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefinition extends Testbase {

	PoHomePage homepage;
	PoRealEstatePage realestatePage;

	@Given("^the redfin application is launched for \"([^\"]*)\"$")
	public void the_redfin_application_is_launched_for(String testName) throws Throwable {

		Testbase.logger = Testbase.reports.startTest(testName);

	}

	@Then("^verify the home page using \"([^\"]*)\"$")
	public void verify_the_home_page_using(String homePageTitle) throws Throwable {
		homepage = new PoHomePage(driver);
		String ActualTitle = homepage.validateHomePage();
		Boolean result = oBrowsUtil.verify_Text(ActualTitle, homePageTitle, "HomePage");
		Assert.assertTrue(result);

	}

	@When("^enter the \"([^\"]*)\" in searchbox and press the enter button$")
	public void enter_the_in_searchbox_and_press_the_enter_button(String cityName) throws Throwable {
		homepage.enterTextSearchBox(cityName);

	}

	@Then("^validate pop up appears$")
	public void validate_pop_up_appears() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.popupValidation();
	}

	@When("^On the pop up select the entry \"([^\"]*)\"$")
	public void on_the_pop_up_select_the_entry(String SelectionFromPopUp) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.selectCityPopUp(SelectionFromPopUp);

	}

	@Then("^verify the city Real Estate page using \"([^\"]*)\"$")
	public void verify_the_city_Real_Estate_page_using(String estatePageHeader) throws Throwable {
		realestatePage = new PoRealEstatePage(driver);
		realestatePage.validateEstatePageHeader(estatePageHeader);

	}

	@Then("^assert the Search box on the top left side has \"([^\"]*)\"$")
	public void assert_the_Search_box_on_the_top_left_side_has(String cityName) throws Throwable {
		realestatePage.validateCityTag(cityName);
	}

	@When("^Select the min price as \"([^\"]*)\" and max price as \"([^\"]*)\"$")
	public void select_the_min_price_as_and_max_price_as(String MinPriceIndex, String MaxPriceIndex) throws Throwable {
		realestatePage.enterMinValue(MinPriceIndex);
		realestatePage.enterMaxValue(MaxPriceIndex);

	}

	@Then("^Verify all the homes listed are from \"([^\"]*)\", if no homes listed throw an errorMessage$")
	public void verify_all_the_homes_listed_are_from_if_no_homes_listed_throw_an_errorMessage(String searchResult)
			throws Throwable {
		realestatePage.validatesearchResult(searchResult);
	}

}
