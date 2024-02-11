package gitHub;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllRepo {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="https://api.github.com/users/naimesh007rana/repos";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println("All Repos are:"+response.body().asString());
		
	}

}
