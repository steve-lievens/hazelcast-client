package com.ibm.demo.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class SimpleKeyValueTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/ui/getheader")
          .then()
             .statusCode(200);
    }

}