package restAPIXML;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLTest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="https://chercher.tech/sample/api/books.xml";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		
		NodeChildrenImpl book = response.then().extract().path("bookstore.book.title");
		System.out.println("books are:"+book.toString());
		System.out.println("first book is:"+book.get(0));
		System.out.println("second book is:"+book.get(1));
		
		NodeChildrenImpl booksTag = response.then().extract().path("bookstore.book");
		
		for(int i=0;i<booksTag.size();i++) {
			System.out.println("The Catagory is:"+booksTag.get(i).getAttribute("category"));
		}
		
		NodeChildrenImpl bookslan = response.then().extract().path("bookstore.book.title");
		
		for(int i=0;i<bookslan.size();i++) {
			System.out.println("The language is:"+bookslan.get(i).getAttribute("lang"));
		}
	}

}
