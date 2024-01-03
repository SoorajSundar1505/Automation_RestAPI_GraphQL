package com.graphql.automation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import base.setupGraphQL;
import graphQL.getUser;
import static org.hamcrest.Matchers.*;

public class verifyGetUser extends setupGraphQL{
	getUser user = new getUser();
	@Test
	public void getUserRequest() {
		given().spec(reqSpec).body(user.getUserQuery())
			   .when().post().then().log().all()
			   .statusCode(200)
			   .body("data.user.username", equalTo("Bret"),
					 "data.user.email", equalTo("Sincere@april.biz"));
			    
	}

}
