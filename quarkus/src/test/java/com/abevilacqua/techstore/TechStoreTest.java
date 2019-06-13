package com.abevilacqua.techstore;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TechStoreTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/")
          .then()
             .statusCode(200)
             .body(is("Hey there from TechStore!!!"));
    }

}
