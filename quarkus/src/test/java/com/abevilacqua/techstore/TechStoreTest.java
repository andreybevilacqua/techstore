package com.abevilacqua.techstore;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class TechStoreTest {

    @Test
    @DisplayName("Should get list of Products")
    void shouldGetListOfProducts() {
        given()
                .when()
                .get("/products")
                .then()
                .body("$.size()", is(5));
    }

    @Test
    @DisplayName("Should find product by ID")
    void shouldFindProductByID() {
        given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body(containsString("Mouse"), containsString("Really good mouse"));
    }

    @Test
    @DisplayName("Should create product")
    void shouldCreateProduct() {
        given()
                .body("{\"name\": \"New Product\", \"description\": \"Really good new product\", \"price\": \"256\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/products")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    @DisplayName("Should update product")
    void shouldUpdateProduct() {
        given()
                .body("{\"name\": \"New Mouse\", \"description\": \"Really good new mouse\", \"price\": \"80\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when().put("/products/1")
                .then().using().defaultParser(Parser.JSON)
                .assertThat().statusCode(200)
                .body(containsString("Really good new mouse"),
                        containsString("New Mouse"),
                        containsString("80"));
    }

    @Test
    @DisplayName("Should delete product")
    void shouldDeleteProduct() {
        shouldCreateProduct();
        given().
                when()
                .delete("/products/6")
                .then().assertThat().statusCode(204);
    }

}
