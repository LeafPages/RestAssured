package basics;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidentsAsXml {

	public static void main(String[] args) {		
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// 3) Send the request and get the response as XML
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.accept("application/xml")
				.get();
		
		// Print the response
		response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());
		
		// Content Type
		String contentType = response.getContentType();
		System.out.println(contentType);
		
		// Parse the response as XML
		XmlPath xmlResponse = response.xmlPath();
		
		// Pick one field
		List<String> lstData = xmlResponse.getList("response.result.sys_id");
		
		System.out.println(lstData.size());

	}

}
