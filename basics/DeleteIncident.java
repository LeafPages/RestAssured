package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident {

	public static void main(String[] args) {
		
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// 3) Send the request and get the response
		Response response = RestAssured
				.given()
					.log()
					.all()
				.delete("ff5b305907bc20101945f2ae7c1ed0cf");
		
		// Print the response
		response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());

	}

}
