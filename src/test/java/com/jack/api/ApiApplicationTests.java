package com.jack.api;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static io.restassured.RestAssured.given;

@SpringBootTest
@Slf4j
class ApiApplicationTests {

    @Test
    void contextLoads() {
        Response response = given().
                when().
                params(Collections.emptyMap()).
                headers(Collections.emptyMap()).
                get("http://localhost:8070/coffee/all");
        log.info(response.getBody().asString());
    }

}
