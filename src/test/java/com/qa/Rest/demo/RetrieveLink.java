package com.qa.Rest.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import resources.Utils;

public class RetrieveLink extends Utils {
	
		
	public void getShortLink() throws IOException  {
		
		given()
		
		.spec(requestSpecification())

		.when()
			.get("https://api-ssl.bitly.com/v4/bitlinks/bit.ly/3r23Avz")

		.then()
			.statusCode(200)
			.assertThat().body("long_url", equalTo("https://www.guru99.com/abap-tutorial.html"))
			.header("content-type","application/json");
		
	}
	
	

}
