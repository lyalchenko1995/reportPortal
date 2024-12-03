package com.epam.reportportal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
    plugin = "pretty",
    monochrome = true,
    glue = "com.epam.reportportal.steps",
    features = {"${featureFile}"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
  @Parameters({"featureFile"})
  public CucumberRunner(String featureFile) {
    System.setProperty("cucumber.features", featureFile);
  }

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
