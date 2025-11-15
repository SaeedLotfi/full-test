package com.saeed.full.restassured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloApiRestAssuredTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void hello_withName_returnsGreeting() {
        given()
                .queryParam("name", "RestAssured")
                .when()
                .get("/api/hello")
                .then()
                .statusCode(200)
                .body(equalTo("Hello, RestAssured!"));

    }

    @Test
    void sum_returnsCorrectValue() {
        given().queryParam("a", "7").queryParam("b", "8")
                .when().get("/api/sum")
                .then().statusCode(200).body(equalTo("15"));
    }
}
