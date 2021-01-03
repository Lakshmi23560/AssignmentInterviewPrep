import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class studentAPI {

	public static String ReadStudentJson() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(
				"C:/Training/TAAssignments/Lakshmi_Balla/Assignments/RestAssuredSample/RestAssuredDemo/src/main/java/com/Tekarch/StudentJson.json"));
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject.toJSONString();

	}

	@Test(priority = 1)
	public void studentDataValidate() throws FileNotFoundException, IOException, ParseException {

		String response = ReadStudentJson();
		JsonPath jp = new JsonPath(response);
		System.out.println("value of username :");
		System.out.println(jp.getString("username"));
		System.out.println(jp.getInt("sessionid.size()"));
		int sessionidcount = jp.getInt("sessionid.size()");
		System.out.println("sessionid's :");
		for (int i = 0; i < sessionidcount; i++) {
			System.out.println(jp.getString("sessionid[" + i + "]"));
		}
		int lastSessionid = jp.getInt("sessionid[" + (sessionidcount - 1) + "]");
		System.out.println("Last value of sessionid : " + lastSessionid);
		System.out.println("Marks of second Student :");
		System.out.println(jp.getInt("students[1].marks[0]"));
		System.out.println(jp.getInt("students[1].marks[1]"));
		System.out.println(jp.getInt("students[1].marks[2]"));
		System.out.println("Second state value of first student: ");
		System.out.println(jp.getString("students[0].adresss[1].state"));
		System.out.println("Seccond contact value of second student: ");
		System.out.println(jp.getInt("students[1].contact[1]"));
		System.out.println("Cities of Second student: ");
		System.out.println(jp.getString("students[1].adresss[0].city"));
		System.out.println(jp.getString("students[1].adresss[1].city"));
		System.out.println("Contacts of all students: ");
		System.out.println(jp.getInt("students[0].contact[0]"));
		System.out.println(jp.getInt("students[0].contact[1]"));
		System.out.println(jp.getInt("students[1].contact[0]"));
		System.out.println(jp.getInt("students[1].contact[1]"));
		System.out.println("Address of first student: ");
		System.out.println(jp.getString("students[0].adresss[0].state"));
		System.out.println(jp.getString("students[0].adresss[0].city"));
	}

	@Test(priority = 2)
	public void StudentPostAPI() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		String response = given().header("Content-Type", "application/json").when().get().then().assertThat()
				.statusCode(200).extract().response().asString();
		System.out.println(response);

		JsonPath jp = new JsonPath(response);
		System.out.println(jp.getInt("x.size()"));
		for (int i = 0; i < 100; i++) {
			if (jp.getInt("userId[" + i + "]") == 7) {
				System.out.println(jp.getString("title[" + i + "]"));
			}
		}
	}

}
