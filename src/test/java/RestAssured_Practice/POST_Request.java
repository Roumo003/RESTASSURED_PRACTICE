package RestAssured_Practice;

import java.io.*;
import java.util.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class POST_Request{
	@Test
	public void Test_1() {
		baseURI = "https://reqres.in";
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("name","Rohan Banerjee");
//		map.put("job","IT professional");
//		JSONObject json = new JSONObject(map);
		JSONObject json = new JSONObject();
		json.put("name","Rohan");
		json.put("job","Banker");
		System.out.println(json.toJSONString());
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(json.toJSONString())
		.when().post("/api/users").then().statusCode(201).log().all();

	}

}
