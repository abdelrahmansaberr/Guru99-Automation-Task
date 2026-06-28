package com.guru99.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.guru99.Steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}