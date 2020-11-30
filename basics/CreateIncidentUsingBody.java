package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentUsingBody {

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
				.queryParam("sysparm_fields", "number,sys_id,short_description,category,priority")
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
						"\r\n" + 
						" \"short_description\" : \"This is Babu's incident created from Rest Assured\",\r\n" + 
						" \"category\" : \"hardware\",\r\n" + 
						" \"priority\" : \"5\"\r\n" + 
						"\r\n" + 
						"}")
				.post();
		
		// Print the response
		response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());

	}

}
