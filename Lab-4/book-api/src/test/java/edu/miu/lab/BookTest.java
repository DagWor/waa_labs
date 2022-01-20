package edu.miu.lab;

import edu.miu.lab.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class BookTest {

    @BeforeAll
    public static void setup() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/books";
    }

    @Test
    public void testGetAllBooks() {
        // Add new book
        Book newBook = new Book("231314914", "Test User", "Software Architecture", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .when()
                .post("")
                .then()
                .statusCode(201);
        // Get all books
        RestAssured.given()
                .when()
                .get("")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200)
                .and()
                .body("title", hasItems("Software Architecture"))
                .body("isbn", hasItems("231314914"));

    }

    @Test
    public void testGetOneBook() {
        // Add new book
        Book newBook = new Book("231314914", "Test User", "Software Architecture", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .when()
                .post("")
                .then()
                .statusCode(201);

        // Fetch the added book
        RestAssured.given()
                .when()
                .get("/231314914")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200)
                .and()
                .body("isbn", equalTo("231314914"))
                .body("title", equalTo("Software Architecture"))
                .body("author", equalTo("Test User"));
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("231314914", "Test User", "Software Architecture", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .and()
                .body("isbn", equalTo(newBook.getIsbn()));
    }

    @Test
    public void testDeleteBook() {
        Book newBook = new Book("231314914", "Test User", "Software Architecture", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .when()
                .post("")
                .then()
                .statusCode(201);
        RestAssured.given()
                .when()
                .delete("/" + newBook.getIsbn())
                .then()
                .statusCode(204);
    }

    @Test
    public void testUpdateBook() {
        // Add new book
        Book newBook = new Book("231314914", "Test User", "Software Architecture", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .when()
                .post("")
                .then()
                .statusCode(201);

        // Update the book
        newBook.setPrice(59.99);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .put("/" + newBook.getIsbn())
                .then()
                .statusCode(202);

        // Check if book is updated
        RestAssured.given()
                .when()
                .get("/" + newBook.getIsbn())
                .then()
                .statusCode(200)
                .and()
                .body("price", equalTo(59.99F));
    }

    @Test
    public void testSearchBook() {
        // Add a new book
        Book newBook = new Book("231314914", "Test User", "Software Architecture", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newBook)
                .when()
                .post("")
                .then()
                .statusCode(201);
        // Search book
        RestAssured.given()
                .when()
                .get("/search?author=" + newBook.getAuthor())
                .then()
                .statusCode(200)
                .and()
                .body("isbn", equalTo(newBook.getIsbn()))
                .body("author", equalTo(newBook.getAuthor()))
                .body("title", equalTo(newBook.getTitle()));
    }
}
