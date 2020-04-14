package com.api.tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTCallAPI {
	
	//Update
	
	@Test
	public void updateUserWithPUTTest(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF");
		request.contentType("application/json");
		
		File file = new File("/Users/bobit/Documents/workspace/RestAssuredTesting2020/"
				+ "src/test/java/com/api/tests/updateuser.json");
		request.body(file);
		Response response = request.put("/public-api/users/6");
		
		System.out.println(response.prettyPrint());
		
	}
	

}
