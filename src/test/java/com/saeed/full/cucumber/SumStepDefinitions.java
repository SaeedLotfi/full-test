package com.saeed.full.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SumStepDefinitions {

    @LocalServerPort
    private int port;

    private int a;
    private int b;
    private int result;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Given("the numbers {int} and {int}")
    public void the_numbers_and(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @When("I call the sum endpoint")
    public void i_call_the_sum_endpoint() {
        String response =
                given().queryParam("a", a).queryParam("b", b).
                when().get("/api/sum")
                        .then().statusCode(200).extract().body().asString();

        this.result = Integer.parseInt(response);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }
}
