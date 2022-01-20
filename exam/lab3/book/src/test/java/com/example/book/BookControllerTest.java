package com.example.book;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookControllerTest {
    @BeforeAll
    public static void setup(){
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Test
    public void testGetOneBook(){
        given()
                .when()
                .get("book/123")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", {123}).body()
    }
}
