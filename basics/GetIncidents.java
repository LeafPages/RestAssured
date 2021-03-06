package basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidents {

	public static void main(String[] args) {
		
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "Tuna@123");
		
		// 3) Send the request and get the response
		Response response = RestAssured.get();
		
		// Print the response
		response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());

	}

}
