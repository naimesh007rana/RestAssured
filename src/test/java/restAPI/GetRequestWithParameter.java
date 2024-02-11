package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameter {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/2");
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		System.out.println("Response code is:"+response.statusCode());
		AssertJUnit.assertEquals(response.statusCode(), 200);
		AssertJUnit.assertTrue(responseBody.contains("Unnati"));
		
		JsonPath json = response.jsonPath();
		String actname = json.get("name");
		String expname = "Unnati";
		AssertJUnit.assertEquals(actname, expname);
		
	}

}
