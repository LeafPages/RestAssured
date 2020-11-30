package basics;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentUsingDP {
	
	

	// Step 1: Convert main method to normal step
	// Step 2: Annotate that method with @Test
	// Step 3: Create dataprovider annotation and method
	// Step 4: Create n number of data array and store the file names and return them
	// Step 5: Change the return type as String[] 
	// Step 6: Add name to the DP
	// Step 7: Receive the same dp name in the @Test
	// Step 8: Change the @Test method argument to receive the input (String)
	
	@DataProvider(name="JSON")
	public String[] getFiles() {
		String[] files = new String[2];
		files[0] = "data1.json";
		files[1] = "data2.json";
		return files;
	}
	
	
	@Test(dataProvider="JSON")
	public void multipleData(String fileName) {
		
		// Read File
		File file = new File(fileName);		
		
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
