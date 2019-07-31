package com.cybertek.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports",
                "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        features = "src/test/resources/features/login.feature",
        glue = "com/cybertek/step_definitions"
        , dryRun = false



)
//plug in is for the report type
//features: get the feature file path from the src/test..
//glue: get the step_definition package path from com/cybertek


// when there is no codes/ steps definitions for the feature file-----> dry run =true to generate the steps
//when the codes/ step definitions are ready to execute -------> dry run =false to run the test

public class cukesrunner {
}
