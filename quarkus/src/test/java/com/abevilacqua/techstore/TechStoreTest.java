package com.abevilacqua.techstore;

import io.quarkus.test.junit.QuarkusTest;
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
                .statusCode(201)
                .body("name", containsString("New Product"),
                        "description", containsString("Really good new product"),
                        "price", containsString("256"));
    }

    @Test
    @DisplayName("Should update product")
    void shouldUpdateProduct() {

    }

    @Test
    @DisplayName("Should delete product")
    void shouldDeleteProduct() {

    }

}
