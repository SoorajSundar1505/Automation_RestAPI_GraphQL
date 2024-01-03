package com.restapi.automation;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.setupRestAPI;

import static io.restassured.RestAssured.given;

import lombok.Data;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import restAPI.postUserLombok;
public class createUserLombok extends setupRestAPI{
	
	postUserLombok user = new postUserLombok();
	public postUserLombok buildeUserCreate() {
		return new postUserLombok("test", "swe");
//		return postUserLombok.builder().name("Austin").job("SWE").build();
	}
	
	
	@Test
	public void createUserUsingLombok() {
		postUserLombok create = buildeUserCreate(); 
		given().spec(reqSpec).body(create)
			   .when().post("/api/users")
			   .then().log().all()
			   .body("name", equalTo(create.getName()));
	}
}