package com.qa.Rest.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

public class CreateBitlinktest extends Utils  {

	TestDataBuild data=new TestDataBuild();
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	

//Code to test valid new bitlink creation
	@Test(priority=1)
	public void createNewBitlink() throws IOException {
		RestAssured.basePath="/v4/bitlinks";

			given()
			.spec(requestSpecification())
			.body(data.createBitlinkPL())

		.when()
			.post()

		.then()
			.log().all()
			.statusCode(200)
			.and()
			.assertThat().body("id", equalTo("bitly.is/3r1cJVj"))
			.and()
			.assertThat().body("link",equalTo("https://bitly.is/3r1cJVj"));
	}
	
	/*Code to test blank long url*/
	@Test(priority=2)
	
	public void testStatusCodes() throws IOException {
		RestAssured.basePath="/v4/bitlinks";

		given()
		.spec(requestSpecification())
		.body(data.blanklongurl())

	.when()
		.post()

	.then()
		.log().all()
		.statusCode(400)
		.and()
		.assertThat().body("message", equalTo("INVALID_ARG_LONG_URL"))
		.body("errors[0].field", equalTo("long_url"))
		.body("errors[0].error_code", equalTo("invalid"));
					
	}
	
	/*POST request without payload*/
	@Test(priority=3)
	
	public void blankPayload() throws IOException {
		
		RestAssured.basePath="/v4/bitlinks";

		given()
		.spec(requestSpecification())
		.body("")

	.when()
		.post()

	.then()
		.log().all()
		.statusCode(422)
		.and()
		.assertThat().body("message", equalTo("UNPROCESSABLE_ENTITY"))
		.body("description", equalTo("The JSON value provided is invalid."));
		
		
		
	}
	
	
	
	
	

}
