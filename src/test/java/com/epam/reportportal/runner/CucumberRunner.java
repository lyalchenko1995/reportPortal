package com.epam.reportportal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com.epam.reportportal.steps",
        features = "src/test/resources/features"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
