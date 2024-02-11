package restAPI;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void Test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = (Response) request.contentType(ContentType.JSON)
				                               .accept(ContentType.JSON)
				                               .body("{\r\n"
														+ "    \"name\": \"Rakesh\",\r\n"
														+ "    \"salary\": \"7000\",\r\n"
														+ "    \"id\": 4\r\n"
														+ "}")
				                               .post();
		
		System.out.println("respose code is" + response.getStatusCode());
		System.out.println("response body is"+response.body().asString());
				
				
				
	}
	

}
