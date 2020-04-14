package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETECallAPI {
	
	//Delete -- deleting user
	
	@Test
	public void deleteUserAPI(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF");
		
		Response response = request.delete("/public-api/users/12");
		//response = request.delete("/public-api/users/6");
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		JsonPath js = response.jsonPath();
		System.out.println(js.get("result"));
		Assert.assertNull(js.get("result"));
				
		
	}
	

}
