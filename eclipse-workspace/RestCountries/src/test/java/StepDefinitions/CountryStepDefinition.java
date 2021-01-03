package StepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CountryStepDefinition {

	public Response response;

	@Given("^Set service endpoint$")
	public void set_service_endpoint() throws Throwable {
		RestAssured.baseURI = "https://restcountries.eu/rest/v2/";
	}

	@When("^set header and get method with parameter \"([^\"]*)\"$")
	public void set_header_and_get_method_with_parameter(String alpha3Code) throws Throwable {
		response = RestAssured.given().header("Content-type", "application/json").get("alpha/{countrycode}",
				alpha3Code);
	}

	@Then("^validate the status code$")
	public void validate_the_status_code() throws Throwable {
		System.out.println("Status Code : " + response.getStatusCode());
		int StatusCode = response.getStatusCode();
		Assert.assertEquals(200, StatusCode);
	}

	@Then("^check the capital name \"([^\"]*)\" belong to that country code\\.$")
	public void check_the_capital_name_belong_to_that_country_code(String capitalname) throws Throwable {
		System.out.println("Capital is :" + response.jsonPath().get("capital"));
		Assert.assertEquals(capitalname, response.jsonPath().get("capital"));
		response.prettyPrint();
	}

	@When("^set header and get method with invalid parameter \"([^\"]*)\"$")
	public void set_header_and_get_method_with_invalid_parameter(String alpha3Code) throws Throwable {
		response = RestAssured.given().header("Content-type", "application/json").get("alpha/{countrycode}",
				alpha3Code);
	}

	@Then("^validate the status code with invalid code$")
	public void validate_the_status_code_with_invalid_code() throws Throwable {
		System.out.println("Status Code : " + response.getStatusCode());
		int StatusCode = response.getStatusCode();
		Assert.assertEquals(404, StatusCode);
	}

}
