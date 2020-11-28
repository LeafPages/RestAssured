package basics;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidentsFilters {

	public static void main(String[] args) {		
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// 3) Send the request and get the response
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.get();
		
		// Print the response
		response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());
		
		// Content Type
		String contentType = response.getContentType();
		System.out.println(contentType);
		
		// Parse the response
		JsonPath jsonResponse = response.jsonPath();
		
		// Atleast look for field
		List<String> allSys_id = jsonResponse.getList("result.sys_id");
		
		// Print how many item in a list
		System.out.println(allSys_id.size());

	}

}
