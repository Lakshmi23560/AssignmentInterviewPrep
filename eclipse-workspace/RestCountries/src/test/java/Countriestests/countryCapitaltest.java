package Countriestests;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class countryCapitaltest {

	@Test
	public void CapitalNameTest() {

		RestAssured.baseURI = "https://restcountries.eu/rest/v2/";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the code : ");
		String alpha3Code = s.nextLine();

		Response response = RestAssured.given().header("Content-type", "application/json").get("alpha/{countrycode}",
				alpha3Code);
		System.out.println("Capital is :" + response.jsonPath().get("capital"));
		System.out.println("Status Code : " + response.getStatusCode());
		response.prettyPrint();
		// Assert.assertEquals(200, response.getStatusCode());
		// System.out.println(response.asString());
	}
}
