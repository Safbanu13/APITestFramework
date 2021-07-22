package com.qa.Rest.demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;


public class ShortenLinktest extends Utils {
	
	TestDataBuild data =new TestDataBuild();


@Test	
	public void postShortenLink() throws IOException {
	
		RestAssured.basePath="/v4/shorten";

		given()
		
		.spec(requestSpecification())
		.body(data.shortenPL())
		
		.when()
			.post()

		.then()
			.statusCode(200)
			.and()
			.assertThat().body("id", equalTo("bit.ly/3r23Avz"));
			

	}

}
