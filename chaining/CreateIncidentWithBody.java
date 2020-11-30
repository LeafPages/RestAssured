package chaining;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncidentWithBody extends BaseRequest{

	@Test
	public void createNewIncident() {

		Response response = requestSpecification
				.when()
				.body("{\"short_description\" : \"Good Start\",\"description\" : \"request from Rest Assured\",\"category\" : \"software\"}")
				.post();


		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());

		// Print the response time as well
		System.out.println(response.getTime());

		// Check what is the response format
		System.out.println(response.getContentType());

		// print the response
		response.prettyPrint();

		// Convert the response as JSON
		JsonPath jsonResponse = response.jsonPath();

		// it is get -> Single record
		sys_id = jsonResponse.get("result.sys_id");
		System.out.println(sys_id);

	}


}
