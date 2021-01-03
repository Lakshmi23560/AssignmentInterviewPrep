
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

public class RentalCarsAPI {

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
		System.out.println("StatusCode " + statuscode);
		// response.prettyPrint();
		String responsebody = response.getBody().asString();
		// System.out.println(responsebody);

		Assert.assertTrue(responsebody.contains(make));
		System.out.println("Response contains Tesla");

		List<String> list = response.jsonPath().getList("Car");
		for (int i = 0; i < list.size(); i++) {
			if ((response.jsonPath().getString("Car[" + i + "].make").equals(make)
					&& (response.jsonPath().getString("Car[" + i + "].metadata.Color").equals(color)))) {
				String carname = response.jsonPath().getString("Car[" + i + "].make");
				String notes = response.jsonPath().getString("Car[" + i + "].metadata.Notes");
				System.out.println("carName = " + carname + "  " + "notes = " + notes);
				// System.out.println(list);
			}
		}

	}

	@Test(priority = 2)
	public void getCarswithLowPrice() {
		RestAssured.baseURI = "http://localhost:8080";
		Response response = RestAssured.given().when().get("/api/Rentalcars/");
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode :" + statuscode);
		// response1.prettyPrint();
		List<String> list = response.jsonPath().getList("Car");
		System.out.println(list.size());
		int minprice = 0;
		int carprice = 0;
		for (int i = 0; i < list.size(); i++) {
			carprice = response.jsonPath().getInt("Car[" + i + "].perdayrent.Price");
			// System.out.println(price);
			if (i == 0) {
				minprice = carprice;
			}
			if (minprice > carprice) {
				minprice = carprice;
			}
		}
		// System.out.println(minprice);
		System.out.println("Cars with minimum price :");
		for (int i = 0; i < list.size(); i++) {
			carprice = response.jsonPath().getInt("Car[" + i + "].perdayrent.Price");
			if (minprice == carprice) {
				System.out.println(response.jsonPath().get("Car[" + i + "]"));
			}
		}
	}

	@Test(priority = 3)
	public void getCarswithDiscountLowPrice() {
		RestAssured.baseURI = "http://localhost:8080";
		Response response = RestAssured.given().when().get("/api/Rentalcars/");
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode " + statuscode);
		// response1.prettyPrint();
		List<String> list = response.jsonPath().getList("Car");
		System.out.println(list.size());
		float minprice = 0;
		float carprice = 0;
		float discount = 0;
		float discountprice = 0;
		float pricewithdiscount = 0;
		for (int i = 0; i < list.size(); i++) {
			carprice = response.jsonPath().getInt("Car[" + i + "].perdayrent.Price");
			discount = response.jsonPath().getInt("Car[" + i + "].perdayrent.Discount");
			discountprice = (carprice * discount) / 100;
			pricewithdiscount = carprice - discountprice;
			// System.out.println(pricewithdiscount);
			if (i == 0) {
				minprice = pricewithdiscount;
			}
			if (minprice > pricewithdiscount) {
				minprice = pricewithdiscount;
			}
		}
		// System.out.println("pricewithdiscount " + minprice);
		System.out.println("Cars with minimum discount price :");
		for (int i = 0; i < list.size(); i++) {
			carprice = response.jsonPath().getInt("Car[" + i + "].perdayrent.Price");
			discount = response.jsonPath().getInt("Car[" + i + "].perdayrent.Discount");
			discountprice = (carprice * discount) / 100;
			pricewithdiscount = carprice - discountprice;
			if (minprice == pricewithdiscount) {
				System.out.println(response.jsonPath().get("Car[" + i + "]"));
			}
		}
	}

	@Test(priority = 4)
	public void highestProfitCar() {
		RestAssured.baseURI = "http://localhost:8080";
		Response response = RestAssured.given().when().get("/api/Rentalcars/");
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode " + statuscode);
		// response1.prettyPrint();
		List<String> list = response.jsonPath().getList("Car");
		System.out.println(list.size());
		float revenue = 0;
		float minrevenue = 0;
		float maxrevenue = 0;
		float yoymaintenancecost = 0;
		float depreciation = 0;
		for (int i = 0; i < list.size(); i++) {
			yoymaintenancecost = response.jsonPath().get("Car[" + i + "].metrics.yoymaintenancecost");
			depreciation = response.jsonPath().get("Car[" + i + "].metrics.depreciation");
			revenue = yoymaintenancecost + depreciation;
			// System.out.println(revenue);
			if (i == 0) {
				minrevenue = revenue;
				maxrevenue = revenue;
			}
			if (minrevenue > revenue) {
				minrevenue = revenue;
			}
			if (maxrevenue < revenue) {
				maxrevenue = revenue;
			}
		}

		System.out.println("car with minimum revenue and highest profit :");
		for (int i = 0; i < list.size(); i++) {
			yoymaintenancecost = response.jsonPath().get("Car[" + i + "].metrics.yoymaintenancecost");
			depreciation = response.jsonPath().get("Car[" + i + "].metrics.depreciation");
			revenue = yoymaintenancecost + depreciation;

			if (minrevenue == revenue) {
				System.out.println(response.jsonPath().get("Car[" + i + "]"));
			}
		}

		System.out.println("car with maximum revenue and lowest profit :");
		for (int i = 0; i < list.size(); i++) {
			yoymaintenancecost = response.jsonPath().get("Car[" + i + "].metrics.yoymaintenancecost");
			depreciation = response.jsonPath().get("Car[" + i + "].metrics.depreciation");
			revenue = yoymaintenancecost + depreciation;
			if (maxrevenue == revenue) {
				System.out.println(response.jsonPath().get("Car[" + i + "]"));
			}
		}

	}
}
