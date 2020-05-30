package com.groupbyinc.steps.ingestion;

import com.groupbyinc.Config;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static io.restassured.RestAssured.given;

public class IngestionStepDefinitions {

    private static final String FORM_DATA_TYPE = "multipart/form-data";

    @Autowired
    private Config config;

    //TODO: parametize to include other files
    @Given("A catalog has been uploaded")
    public void upload() {
        String catalog = this.getClass().getResource("/fullData.json").getFile();
        String uploadConfig = this.getClass().getResource("/uploadConfig.txt").getFile();
        String response = given()
            .header("Content-Type", FORM_DATA_TYPE)
            .multiPart("config", new File(uploadConfig))
            .multiPart("data", new File(catalog))
            .when().post(config.getUrl() + "/data/v1/upload/stream")
            .then().extract().response().asString();

        //TODO: may need to implement delay to ensure indexing of records
    }
}
