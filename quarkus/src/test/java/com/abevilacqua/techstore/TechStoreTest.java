package com.abevilacqua.techstore;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
