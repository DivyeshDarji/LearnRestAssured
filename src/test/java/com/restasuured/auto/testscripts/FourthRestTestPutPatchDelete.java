package com.restasuured.auto.testscripts;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FourthRestTestPutPatchDelete {

	@Test(priority = 1)
	public void testPut() {

		// we used the JsonObject class because we are communicating with server using
		// JSON
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "DearTest");
		jsonObject.put("job", "Dearlearning");

		System.out.println("JSON Object: " + jsonObject); // {"name":"userTest","job":"learning"}

		baseURI = "https://reqres.in/"; // base URL

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonObject.toJSONString()).when().put("api/users/2").then().statusCode(200).log().all();
	}
	
	@Test(priority = 2)
	public void testPatch() {

		// we used the JsonObject class because we are communicating with server using
		// JSON
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Divyesh");
		jsonObject.put("job", "API Software Testing");

		System.out.println("JSON Object: " + jsonObject); // {"name":"userTest","job":"learning"}

		baseURI = "https://reqres.in/"; // base URL

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonObject.toJSONString()).when().put("api/users/2").then().statusCode(200).log().all();
	}
	
	
	@Test(priority = 3)
	public void testDelete() {

		baseURI = "https://reqres.in/"; // base URL

		when().delete("api/users/2").then().statusCode(204).log().all();
	}
}
