package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAPINoBDD {
	
	//No BDD
	
	@Test(priority=1, enabled=false)
	public void getUserAPITest(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF");
		
		Response response = request.get("/public-api/users");
		
		System.out.println(response.asString()); //to print all result in JSON
		System.out.println(response.prettyPrint()); //to print on the console appropriate format
		
		int statusCode = response.getStatusCode(); //
		Assert.assertEquals(statusCode, 200);
		
		String server =  response.getHeader("Server");
		Assert.assertEquals(server, "nginx");
	
	}
	
	@Test
	public void getUserByParamsTest(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF");
		request.queryParam("first_name", "Judah");
		request.queryParam("gender", "male");
		request.queryParam("status", "active");
		
        Response response = request.get("/public-api/users");
		
		System.out.println(response.asString()); //to print all result in JSON
		System.out.println(response.prettyPrint()); //to print on the console appropriate format
		
		int statusCode = response.getStatusCode(); //
		Assert.assertEquals(statusCode, 200);
		
		String server =  response.getHeader("Server");
		Assert.assertEquals(server, "nginx");
	}
	
	

}
