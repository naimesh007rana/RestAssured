package gitHub;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	
	@Test
	public void test1() throws IOException {
		
		byte[] file =Files.readAllBytes(Paths.get("GithubData.json"));
		
		RestAssured.baseURI="https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();
		Response response = (Response) request.auth().oauth2("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")
											   .contentType(ContentType.JSON)
				                               .accept(ContentType.JSON)
				                               .body(file)
				                               .post();
		
		System.out.println("respose code is:" + response.getStatusCode());
		System.out.println("response body is:"+response.body().asString());
		
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
	}

}
