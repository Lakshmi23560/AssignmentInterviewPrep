
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WiremockStub {

	public void createStub() {
		stubFor(get(urlEqualTo("/api/services")).willReturn(aResponse().withStatus(200)
				.withBody("This is a sample response").withHeader("Content-type", "application/json")));

	}

	@Test
	public void verifyStub() {
		createStub();

		RestAssured.baseURI = "http://localhost:8080";

		Response response = RestAssured.given().log().all().when().get("/api/services");

		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		response.prettyPrint();

	}

}
