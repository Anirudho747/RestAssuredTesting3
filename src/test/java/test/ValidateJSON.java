package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

public class ValidateJSON {

	@Test(enabled = true)
	public void test_1()
	{
		baseURI = "https://reqres.in/api";
		given().
		        get("/users?page=2").
		then().statusCode(200).
		assertThat().body(matchesJsonSchemaInClasspath("schema.json")). 
		body("data[2].email",equalTo("tobias.funke@reqres.in")).
	    body("data.first_name",hasItems("Michael","Lindsay","Tobias","Byron"));
	}
	
}
