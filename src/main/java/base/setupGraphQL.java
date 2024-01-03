package base;

import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class setupGraphQL {
	
	protected RequestSpecification reqSpec;
	
	@BeforeSuite
	public void initGraphQL() {
		RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
		reqSpecBuilder.setBaseUri("https://graphqlzero.almansi.me/api");
		reqSpecBuilder.setContentType(ContentType.JSON);
		reqSpec=reqSpecBuilder.build();
	}

}
