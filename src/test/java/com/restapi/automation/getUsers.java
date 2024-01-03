package com.restapi.automation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import base.setupRestAPI;

public class getUsers extends setupRestAPI {
	
	@Test
	public void getUsers() {
		given().spec(reqSpec)
			   .when().get("/api/users?page=2")
			   .then().log().all().assertThat().statusCode(200)
			   .body("total", equalTo(12),
					 "data[0].id", equalTo(7),
					 "data[0].email", equalTo("michael.lawson@reqres.in"));
	}

}
