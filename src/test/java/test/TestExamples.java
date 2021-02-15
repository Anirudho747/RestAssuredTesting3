package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestExamples {
	
	@Test(enabled = false)
	public void test_1()
	{
/*		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asPrettyString());
		
		//System.out.println(response.asString());
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getTime());
		
		System.out.println(response.getHeader("content-type"));
		
		Assert.assertEquals(response.getStatusCode(),200);
*/	}

	@Test(enabled = false)
	public void get()
	{
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].email",equalTo("lindsay.ferguson@reqres.in"));
	}
	
	@Test(enabled = false)
	public void validateGet()
	{
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[2].email",equalTo("tobias.funke@reqres.in"))
		.body("data.first_name",hasItems("Michael","Lindsay","Tobias","Byron"));
	}
	
	@Test(enabled = false)
	public void post()
	{
		baseURI = "https://reqres.in/api";
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("Trinity","SideKick");
		JSONObject request = new JSONObject();
	
		request.put("Trinity","Sidekick");
		request.put("Morpheus","Supervisor");
		request.put("Neo","Saviour");
		
		//System.out.println(request.toJSONString());
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
	
	@Test(enabled = false)
	public void put()
	{
		baseURI = "https://reqres.in/api";
		JSONObject request = new JSONObject();
	
		request.put("Trinity","Sidekick");
		request.put("Morpheus","Supervisor");
		request.put("Neo","Saviour");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().put("/users/2")
		.then().statusCode(200).log().all();
		
	}
	
	@Test(enabled = false)
	public void patch()
	{
		baseURI = "https://reqres.in/api";
		JSONObject request = new JSONObject();
	
		request.put("Trinity","Sidekick");
		request.put("Morpheus","Supervisor");
		request.put("Neo","Saviour");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().patch("/users/2")
		.then().statusCode(204).log().all();
		
	}
	
	@Test
	public void delete()
	{
		baseURI = "https://reqres.in/api";
		when().delete("/users/2")
		.then().statusCode(204).log().all();
		
	}
	
}
