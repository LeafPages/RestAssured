package basics;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentUsingFile {

	public static void main(String[] args) {
		
		// Read File
		File file = new File("data1.json");
		
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// 3) Send the request and get the response
		Response response = RestAssured
				.given()
					.log()
					.all()
				.queryParam("sysparm_fields", "number,sys_id,short_description,category,priority")
				.contentType(ContentType.JSON)
				.body(file)
				.post();
		
		// Print the response
		response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());

	}

}
