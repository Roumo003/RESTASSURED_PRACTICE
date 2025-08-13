package RestAssured_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Request {
	@Test
	public void test_1()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

}
