package com.restasuured.auto.testscripts;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;	

public class SecondRestTest {

	@Test
	public void test2() {

		// Static restAssured Library
		baseURI = "https://reqres.in/api";

		given().
			get("/users?page=2").
		then().
			statusCode(200).							// checking status code
			body("data[1].id", equalTo(8)).				// Checking the ID=8 data 
			log().all();								// log all information

	}

}
