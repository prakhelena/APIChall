package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

@SpringBootTest
class DemoApplicationTests {


		
			
			static {
				RestAssured.baseURI = "http://localhost:8080";
			   }
			
			
			RequestSpecification requestSpecification;
			Response response;
			
			
			@Given("Uri, resource and parameter")
			public void uriResourceAndParameter() {
				requestSpecification = given().contentType(ContentType.JSON).accept(ContentType.JSON);
				
				
			  	}


			@When("User enters HTTP method get")
			public void userEntersHTTPMethodGet() {
				response = requestSpecification.when().log().all().get("/api/message");
			}

			@Then("User receives a message {string}")
			public void userReceivesAMessage(String string) {

				response.then().log().all().assertThat().statusCode(equalTo(200)).body("name",equalTo("Welcome to the machine."));
				

			}
		}
