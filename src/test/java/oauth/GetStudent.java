package oauth;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetStudent {
	
	@Test
	public void test1() {
		
		String accessToken = GetOAuthToken();
		
		Response response = RestAssured.given()
						                .auth()
						                .oauth2(accessToken)
						                .baseUri("http://44.212.38.181:8088/students/2")
						                .when()
						                .get();
		
		
		System.out.println("Response is " + response.getBody().asString() );
	}
	
	
	public String GetOAuthToken() {
		
		 Response response =
	                RestAssured.given()
	                        .baseUri("http://44.212.38.181:8088/")
	                        .auth().preemptive().basic("rest-assured", "password")
	                        .contentType("application/x-www-form-urlencoded")
	                        .formParam("grant_type", "password")
	                        .formParam("username", "onlyfullstack")
	                        .formParam("password", "secret")
	                        .when()
	                        .post("/oauth/token");
		 
		 JSONObject jsonObject = new JSONObject(response.getBody().asString());
		 String accessToken = jsonObject.get("access_token").toString();
		 
		 return accessToken;
		
	}


}
