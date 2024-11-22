package com.home.tests.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report","json:target/basicreport.json" },
        glue = { "com.home.tests.steps" },
        features = { "classpath:featureFiles/"}
        ,tags ={"@regression"}
        ,dryRun = false
        ,monochrome=true
)

public class TestRunner {

}
