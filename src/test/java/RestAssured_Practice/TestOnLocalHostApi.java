package RestAssured_Practice;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

import org.json.simple.JSONObject;

/* The code in this manner 
 * Function 1 - in the get request we are checking whether
 *  we are getting the default details of
 *  the created local hosted api
 * Function 2 - We are adding data along with the Id
 * so it will create a request with 2 ids one is the
 * default generated id and 2nd with the id which 
 * is passing through code
 * Function 3 - We are modifying data by omitting the ID -4 which
 * is passing through code and correcting the response
 * Function 4 - Delete the last input data*/

public class TestOnLocalHostApi {
	//@Test
	public void Get_Request_Test() {
		baseURI = "http://localhost:3000";
		given().get("/users").
		then().statusCode(200).log().all();
	}
//	@Test
	public void Post_Request_Test() {
		baseURI = "http://localhost:3000";
		JSONObject json = new JSONObject();
		json.put("firstName" ,"Raghav");
		json.put("lastName" ,"Dayal");
		json.put("SubjectId" ,"2");
		json.put("Id" ,"4");
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(json.toJSONString()).
		when().post("/users").
		then().statusCode(201).log().all();
	}
	@Test
	public void Put_Request_Test() {
		baseURI = "http://localhost:3000";
	    Response response = RestAssured.get("/users");
	    String body = response.getBody().asString();
//		given().get("/users").
//		System.out.println("The response after post is "+response.toString());
		System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
        System.out.println(body);
//		JSONObject json = new JSONObject();
//		json.put("firstName" ,"Raghav");
//		json.put("lastName" ,"Dayal");
//		json.put("SubjectId" ,"2");
//		given().contentType(ContentType.JSON).accept(ContentType.JSON)
//		.body(json.toJSONString()).
//		when().put("/users/658b").
//		then().statusCode(200).log().all();
	}
//	@Test
	public void Delete_Request_Test() {
		baseURI = "http://localhost:3000";

//		given().contentType(ContentType.JSON).accept(ContentType.JSON)
//		.body(json.toJSONString()).
//		when().put("/users/7e87").
//		then().statusCode(200).log().all();
		
		when().delete("/users/658b").then().statusCode(200);
	}
	
	
	

}
