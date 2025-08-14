package RestAssured_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET_Request {
	@Test
	public void test_1()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test
	public void test_2()
	{
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2")
		.then().statusCode(200)
		.and().body("data[2].id",equalTo(9));;
	}

}
