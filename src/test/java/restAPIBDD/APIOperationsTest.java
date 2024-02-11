package restAPIBDD;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIOperationsTest {
	
	String baseURI = "http://localhost:3000/employees";
	
	@Test
	public void GetOperation() {
		
		RestAssured.given()
				   .baseUri(baseURI)
				   .when()
				   .get()
				   .then()
				   .log()
				   .body()
				   .statusCode(200);
		
	}
	
	@Test
	public void GetOperationWithPara() {
		
		RestAssured.given()
				   .baseUri(baseURI)
				   .when()
				   .get("/3")
				   .then()
				   .log()
				   .all()
				   .statusCode(200)
				   .body("name", Matchers.equalTo("Naimesh"))
				   .body("salary", Matchers.equalTo("70000"));
		
	}
	
	@Test
	public void GetOperationWithQueryPara() {
		
		RestAssured.given()
				   .queryParam("CUSTOMER_ID", "68195")
				   .queryParam("PASSWORD", "1234!")
				   .queryParam("Account_No", "1")
				   .baseUri("http://demo.guru99.com/V4/sinkministatement.php")
				   .when()
				   .get()
				   .then()
				   .log()
				   .body()
				   .statusCode(200);
		
	}
	
	@Test
	public void PostOperationWithhashmap() {
		
		HashMap<String,String> obj = new HashMap<String,String>();
		obj.put("name", "Samir");
		obj.put("salary", "3000");
		obj.put("id", "9");
		
		RestAssured.given()
		           .contentType(ContentType.JSON)
                   .accept(ContentType.JSON)
                   .body(obj)
				   .baseUri(baseURI)
				   .when()
				   .post()
				   .then()
				   .log()
				   .body()
				   .statusCode(201);
		
	}
	
	@Test
	public void PutOperationWithhashmap() {
		
		HashMap<String,String> obj = new HashMap<String,String>();
		obj.put("id", "9");
		obj.put("name", "Kabir");
		obj.put("salary", "25000");
		
		
		RestAssured.given()
		           .contentType(ContentType.JSON)
                   .accept(ContentType.JSON)
                   .body(obj)
				   .baseUri(baseURI)
				   .when()
				   .put("/9")
				   .then()
				   .log()
				   .body()
				   .statusCode(200);
		
	}
	
	@Test
	public void XDeleteOperation() {
		
		RestAssured.given()
				   .baseUri(baseURI)
				   .when()
				   .delete("/9")
				   .then()
				   .log()
				   .body()
				   .statusCode(200);
		
	}

}
