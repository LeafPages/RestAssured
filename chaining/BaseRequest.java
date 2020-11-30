package chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	public RequestSpecification requestSpecification = null;
	public static String sys_id;

	@BeforeMethod
	public void inIt() {
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";

		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");

		requestSpecification = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON);

	}

}
