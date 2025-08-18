package RestAssured_Practice;
import org.testng.Assert;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

import org.json.simple.JSONArray;
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
	String Ragav_ID_Global = "";
	@Test(priority = 0)
	public void Get_Request_Test() {
		baseURI = "http://localhost:3000";
		given().get("/users").
		then().statusCode(200).log().all();
	}
	@Test(priority = 1)
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
	  public static void main(String[] args) {
	        
	    }
	@Test (priority = 2)
	public void Put_Request_Test() {
		baseURI = "http://localhost:3000";
	    Response response = RestAssured.get("/users");
	    String body = response.getBody().asString();
	    String jsonArray = response.getBody().asString();;
	    String raghav_Id = "" ;

        Gson gson = new Gson();
        people[] people = gson.fromJson(jsonArray, people[].class);
        
        System.out.println("The array is" + people);

        for (people p : people) {
           // System.out.println(p.firstName + " is " + p.lastName + " Subject" + p.SubjectId + " id" + p.id);
        	
        	if(p.firstName.equalsIgnoreCase("Raghav")&& p.lastName.equalsIgnoreCase("Dayal"))
        	{
        		raghav_Id = p.id;
        		System.out.println(raghav_Id);
        		Ragav_ID_Global = raghav_Id;
        	}
        }
		JSONObject json = new JSONObject();
		json.put("firstName" ,"Raghav");
		json.put("lastName" ,"Dayal");
		json.put("SubjectId" ,"2");
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(json.toJSONString()).
		when().put("/users/"+Ragav_ID_Global).
		then().statusCode(200).log().all();
        System.out.println("The value of global id is"+Ragav_ID_Global);
	}
	@Test(priority = 3)
	public void Delete_Request_Test() {
		baseURI = "http://localhost:3000";

//		given().contentType(ContentType.JSON).accept(ContentType.JSON)
//		.body(json.toJSONString()).
//		when().put("/users/7e87").
//		then().statusCode(200).log().all();
		System.out.println("The global uri is /users/"+Ragav_ID_Global);
		
	when().delete("/users/"+Ragav_ID_Global).then().statusCode(200);
   //	when().delete("/users/1f29").then().statusCode(200);
	}
	
	
	

}
