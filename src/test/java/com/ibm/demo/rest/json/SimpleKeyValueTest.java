package com.ibm.demo.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SimpleKeyValueTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/simplekv")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}