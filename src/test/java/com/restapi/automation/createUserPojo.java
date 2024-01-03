package com.restapi.automation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;
import base.setupRestAPI;
import restAPI.postUserPojo;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class createUserPojo extends setupRestAPI{
	postUserPojo user = new postUserPojo();
	String responseSchema = System.getProperty("user.dir")+"\\src\\main\\resources\\resposeJsonSchemas\\postUserResponse.json";
	@Test
	public void createUserJSONFromPojo() throws JsonProcessingException {
		user.setName("testreqres1");
		user.setJob("SDE");
		
		ObjectMapper map = new ObjectMapper();   //Serialize
		String json = map.writeValueAsString(user);
		File file = new File(responseSchema);
		given().spec(reqSpec).body(json)
			   .when().post("/api/users")
			   .then().assertThat()
			   .body("name", equalTo(user.getName()),
					 "job", equalTo(user.getJob()));
	}
	
	@Test
	public void validateJsonSchema() throws JsonProcessingException {
		user.setName("testreqres1");
		user.setJob("SDE");
		
		ObjectMapper map = new ObjectMapper();   //Serialize
		String json = map.writeValueAsString(user);
		File file = new File(responseSchema);
		given().spec(reqSpec).body(json)
				.when().post("/api/users")
				   .then().assertThat()
				   .body(matchesJsonSchema(file));
	}
	

}
