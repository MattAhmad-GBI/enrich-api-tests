package com.groupbyinc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = { "src/test/resources/scenarios/organization.feature",
                "src/test/resources/scenarios/category.feature"},
    plugin = { "pretty", "html:cucumber-html-reports",
        "json:cucumber-html-reports/cucumber.json" }
)

public class RunCucumberTest {

}