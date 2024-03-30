package com.restasuured.auto.testscripts;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class ThirdRestTest {

	@Test
	// Get Request
	public void testGet() {

		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel"));
	}

	@Test
	public void testPost() {

		// we used the JsonObject class because we are communicating with server using JSON 
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("name", "userTest");
		jsonObject.put("job", "learning");

		System.out.println(jsonObject); // {"name":"userTest","job":"learning"}

		baseURI = "https://reqres.in/api";  // base URL 

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(jsonObject.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}

}
