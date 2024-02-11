package gitHub;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="https://api.github.com/repos/naimesh007rana/RestAssureRepo";
		RequestSpecification request = RestAssured.given();
		Response response = (Response) request.auth().oauth2("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")
                                                     .delete();
		System.out.println("All Repos are:"+response.body().asString());
		System.out.println("respose code is:" + response.getStatusCode());
		AssertJUnit.assertEquals(response.getStatusCode(), 204);

}
}
