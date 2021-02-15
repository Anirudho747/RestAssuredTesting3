package test2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class xampl {

	@Test(enabled = true)
	public void  get()
	{
		 baseURI = "https://reqres.in/api/";
		 
		 given()
		.header("Content-Type","application/json").
		 get("users?page=2").
		 then().statusCode(200).
		 body("data[1].avatar", equalTo("https://reqres.in/img/faces/8-image.jpg")).
		 body("data.last_name",hasItems("Lawson","Funke","Edwards"));
		 
		 
//		 given()
//			.get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=5cf8430b7171d0e5ffe1fa10a7932bec")
//			.then()
//			.statusCode(200);
//		 
	}
	
	@Test(enabled = false)
	public void post()
	{
		baseURI = "https://reqres.in/api/";
		JSONObject request = new JSONObject();
		
		request.put("name","Sananda");
		request.put("job","Bride");
		
		request.put("name","Sayantan");
		request.put("job","Groom");
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("users?page=2").
		then().statusCode(201);
	}
	
	@Test(enabled=false)
	public void put()
	{
		baseURI="https://reqres.in/api/";
		
		JSONObject request = new JSONObject();
		
		request.put("name","Sananda");
		request.put("job","Dulhan");
		
//		request.put("name","Sayantan");
//		request.put("job","Dulha");
//		
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("users?page=2")
		.then()
		.statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void patch()
	{
		baseURI="https://reqres.in/api/";
		
		JSONObject req = new JSONObject();
		
		req.put("Name", "Bidyut Kanungo");
		req.put("job", "Singer");
		
		given()
		.body(req.toJSONString())
		.when()
		.patch("users?page=2")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(enabled=false)
	public void delete()
	{
		baseURI="https://reqres.in/api/";
		
		given()
		.delete("users?page=2")
		.then()
		.statusCode(204)
		.log().all();
	}
	
	
}
