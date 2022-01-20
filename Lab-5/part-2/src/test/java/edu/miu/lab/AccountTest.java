package edu.miu.lab;

import edu.miu.lab.domain.Account;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class AccountTest {

    @BeforeAll
    public static void setup() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/accounts";
    }


    @Test
    public void testGetAccount() {
        Account newAccount = new Account("231314914", "Test User", 0.0);
        RestAssured.given()
                .contentType("application/json")
                .body(newAccount)
                .when()
                .post("")
                .then()
                .statusCode(201);

        RestAssured.given()
                .when()
                .get("/231314914")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo("231314914"))
                .body("accountHolder", equalTo("Test User"))
                .body("balance", equalTo(0.0F));
    }

    @Test
    public void testCreateAccount() {
        Account newAccount = new Account("231314914", "Test User", 0.0);
        RestAssured.given()
                .contentType("application/json")
                .body(newAccount)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .and()
                .body("accountHolder", equalTo(newAccount.getAccountHolder()))
                .body("balance", equalTo(0.0F))
                .body("accountNumber", equalTo(newAccount.getAccountNumber()));
    }

    @Test
    public void testRemoveAccount() {
        Account newAccount = new Account("231314914", "Test User", 49.9);
        RestAssured.given()
                .contentType("application/json")
                .body(newAccount)
                .when()
                .post("")
                .then()
                .statusCode(201);
        RestAssured.given()
                .when()
                .delete("/" + newAccount.getAccountNumber())
                .then()
                .statusCode(204);
    }

    @Test
    public void testAccountDeposit() {
        // Add new account
        Account newAccount = new Account("231314914", "Test User", 0);
        RestAssured.given()
                .contentType("application/json")
                .body(newAccount)
                .when()
                .post("")
                .then()
                .statusCode(201);

        // Deposit money to account
        RestAssured.given()
                .contentType("application/json")
                .post("/deposit?amount=199.99&accountNumber=" + newAccount.getAccountNumber())
                .then()
                .statusCode(200);

        // Check if Account balance is updated
        RestAssured.given()
                .when()
                .get("/" + newAccount.getAccountNumber())
                .then()
                .statusCode(200)
                .and()
                .body("balance", equalTo(199.99F));
    }

    @Test
    public void testAccountWithdraw() {
        // Add new book
        Account newAccount = new Account("231314914", "Test User", 29.99);
        RestAssured.given()
                .contentType("application/json")
                .body(newAccount)
                .when()
                .post("")
                .then()
                .statusCode(201);

        // Withdraw money from account
        RestAssured.given()
                .contentType("application/json")
                .post("/withdraw?amount=29.99&accountNumber=" + newAccount.getAccountNumber())
                .then()
                .statusCode(200);

        // Check if Account balance is updated
        RestAssured.given()
                .when()
                .get("/" + newAccount.getAccountNumber())
                .then()
                .statusCode(200)
                .and()
                .body("balance", equalTo(0.0F));
    }

}
