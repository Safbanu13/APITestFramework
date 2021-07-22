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

public class ExpandBitlinkTest extends Utils {

	TestDataBuild data=new TestDataBuild();
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	@Test
	public void ExpandLink() throws IOException {
			RestAssured.basePath="/v4/expand";

			given()
			
			.spec(requestSpecification())
			.body(data.expandBitlinkPL())
			
			.when()
				.post()

			.then()
				.statusCode(200)
				.and()
				.assertThat().body("id", equalTo("bit.ly/3r23Avz"))
				.and()
				.assertThat().body("long_url",equalTo("https://www.guru99.com/abap-tutorial.html"));
	}
}
