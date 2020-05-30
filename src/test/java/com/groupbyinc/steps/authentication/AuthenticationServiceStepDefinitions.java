package com.groupbyinc.steps.authentication;


import com.groupbyinc.Config;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

/**
 * Only One StepDefinition needs to be annotated to support Cucumber scenario scoping of beans. All injected beans were live and be reset at the start
 * of every new scenario.
 */
@SpringBootTest(classes = Config.class)
public class AuthenticationServiceStepDefinitions {

    private static final String JSON_TYPE = "application/json;charset=UTF-8";

    @Autowired
    private Config config;

    @Autowired
    private CommandCenterAuthToken commandCenterAuthToken;

    @Given("A Customer logs in with email of {string} and password of {string}")
    public void authenticate(String email, String password) {
        Response response = given()
            .header("Content-Type", JSON_TYPE)
            .body("{" +
                " \"email\": \"" + email + "\"," +
                " \"password\": \"" + password + "\"" +
                "}")
            .when().post(config.getUrl() + "/admin/v2/login")
                .then().statusCode(200).extract().response();
        String token = response.header("Authentication");

        commandCenterAuthToken.setToken("Bearer " + token);
    }
}