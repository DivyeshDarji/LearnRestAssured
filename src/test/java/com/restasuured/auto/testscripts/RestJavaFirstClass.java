package com.restasuured.auto.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestJavaFirstClass {

	@Test
	public void test() {

		// Hiting the END point & Saving the response in response object
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println("Status Code: " + response.getStatusCode());

		System.out.println("Response Time: " + response.getTime());

		System.out.println("Response Status Line: " + response.getStatusLine());

		System.out.println("Response Header Content-Type: " + response.getHeader("content-type"));

		System.out.println("Response Body: " + response.getBody().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}
}
