package com.api.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import sun.security.provider.VerificationProvider;

import static io.restassured.RestAssured.*;


public class GETCallAPI {
	
	//BDD Approach 
	
	@Test(priority=1, enabled=false)
	public void getUsersAPITest(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
		 .contentType("application/json")
		 .header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF")
		.when().log().all()
		 .get("/public-api/users")
		.then().log().all()
		 .statusCode(200)
		 .and()
		 .header("Server", "nginx")
		 .header("X-Rate-Limit-Limit", "30");
	
	}
	
	@Test(priority=2, enabled=false)
	public void getSingleUserAPI(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
		 .contentType("application/json")
		 .header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF")
		 .when().log().all()
		 .get("/public-api/users?first_name=Maureen")
		.then().log().all()
		 .statusCode(200)
		 .and()
		 .header("Server", "nginx")
		 .header("X-Rate-Limit-Limit", "30"); 
		
	}
	
	@Test
	public void getUserWithOneQueryParametersAPITest(){
		
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
		 .contentType("application/json")
		 .header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF")
		 .queryParam("first_name", "Maureen")
		 .queryParam("gender", "female")
		 .queryParam("status", "active")
		.when().log().all()
		 .get("/public-api/users")
		.then().log().all()
		 .statusCode(200)
		 .and()
		 .header("Server", "nginx")
		 .header("X-Rate-Limit-Limit", "30"); 
	
	}
	
	
	

}
