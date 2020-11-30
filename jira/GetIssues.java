package jira;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIssues {

	public static void main(String[] args) {
		
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/search";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "gDvVdUJaEOtQdYzR2HdHD9ED");
		
		// 3) Send the request and get the response
		Response response = RestAssured
				.given()
				/*.queryParam("", "")
				.queryParam("", "")*/
				//.queryParams(parametersMap)
				.get();
		
		// Print the response
		//response.prettyPrint();
		
		JsonPath jsonPath = response.jsonPath();
			
		
		List<String> allSummaries = jsonPath.getList("issues.fields.issuetype.description");
		List<String> allId = jsonPath.getList("issues.id");
		
		//double floor = Math.floor(Math.random()*allId.size());
		
		for (int i = 0; i < allSummaries.size(); i++) {
			System.out.println(allSummaries.get(i));
			System.out.println(allId.get(i));
		}


	}

}
