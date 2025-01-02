package com.epam.reportportal.api.test;

import static com.epam.reportportal.api.apiobject.objectbuilder.LaunchBuilder.buildLaunchDto1;

import com.epam.reportportal.api.step.LaunchStep;
import org.testng.annotations.Test;

public class launchApiTest extends BaseTest {

  LaunchStep launchStep = new LaunchStep();

  @Test(description = "Positive GET test")
  public void getLaunchPositiveTest() {
    launchStep.getAllLunches();
  }

  @Test(description = "Negative GET test")
  public void getLaunchNegativeTest() {
    launchStep.getNumberOfLunches();
  }

  @Test(description = "Negative GET test")
  public void getLaunchById() {
    launchStep.getLaunchById(111);
  }

  //
  @Test(description = "Positive POST test")
  public void postLaunchPositiveTest() {
    int id = launchStep.createLaunch(buildLaunchDto1());
    launchStep.getLaunchById(id);
  }

  @Test(description = "Positive DELETE test")
  public void deleteLaunchPositiveTest() {
    launchStep.deleteLaunchById(9);
  }
}
