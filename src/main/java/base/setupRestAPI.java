package base;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class setupRestAPI {
	protected static RequestSpecification reqSpec;
	protected static ResponseSpecification resSpec;
	@BeforeSuite
	public void initRestAPI() {
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setBaseUri("https://reqres.in/");
		reqBuilder.setContentType(ContentType.JSON);
		reqBuilder.log(LogDetail.ALL);
		reqSpec = reqBuilder.build();
		
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		resBuilder.expectStatusCode(200);
		resBuilder.log(LogDetail.ALL);
		resSpec = resBuilder.build();
	}
}
