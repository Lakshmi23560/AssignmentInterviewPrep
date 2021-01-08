
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.util.List;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RentalCarsAPI{

	@Before
	public void setup() {
		getStub();
	}

	public void getStub() {

		stubFor(get(urlEqualTo("/api/Rentalcars/")).willReturn(aResponse().withStatus(200).withBodyFile("carsJson.json")
				.withHeader("Content-type", "application/json")));
	}

	@Test(priority = 1)
	public void verifyTeslaBlue() {
		String make = "Tesla";
		String color = "Blue";
		RestAssured.baseURI = "http://localhost:8080";
		Response response = RestAssured.given().when().get("/api/Rentalcars/");
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		// response.prettyPrint();
		String responsebody = response.getBody().asString();
		// System.out.println(responsebody);

		Assert.assertTrue(responsebody.contains(make));
		System.out.println("Resesponse contains Tesla");

		List<String> list = response.jsonPath().getList("Car");
		for (int i = 0; i < list.size(); i++) {
			if ((response.jsonPath().getString("Car[" + i + "].make").equals(make)
					&& (response.jsonPath().getString("Car[" + i + "].metadata.Color").equals(color)))) {
				System.out.println(response.jsonPath().getString("Car[" + i + "]"));
				// System.out.println(list);
			}
		}

	}
}
