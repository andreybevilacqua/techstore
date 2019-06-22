package com.abevilacqua.techstore;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class TechStoreTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/products/1")
          .then()
             .statusCode(200);
    }

}
