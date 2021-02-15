package test2;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class params extends DataForTests{
	

	@Test(dataProvider="dataForPost2")
	public void post(String fName,String job)
	{
        baseURI="https://reqres.in/api/";
		
		JSONObject request = new JSONObject();
		
		request.put("name", fName);
		request.put("job", job);
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("users?page=2")
		.then()
		.statusCode(200).log().all();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	@Test(dataProvider = "dataForDelete",enabled=false)
	public void delete(int id)
	{
       baseURI="https://reqres.in/api/";
		
		given()
		.delete("users"+id)
		.then()
		.statusCode(204)
		.log().all();
	}
}
