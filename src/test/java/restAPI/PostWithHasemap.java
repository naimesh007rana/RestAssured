package restAPI;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostWithHasemap {
	
	@Test
	public void Test1() {
		
		HashMap<String,String> obj = new HashMap<String,String>();
		obj.put("name", "Ronak");
		obj.put("salary", "30000");
		obj.put("id", "5");
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = (Response) request.contentType(ContentType.JSON)
				                               .accept(ContentType.JSON)
				                               .body(obj)
				                               .post();
		
		System.out.println("respose code is" + response.getStatusCode());
		System.out.println("response body is"+response.body().asString());
				
	}
}
