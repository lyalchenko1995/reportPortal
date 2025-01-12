package com.epam.reportportal.ui.steps;

import static org.testng.Assert.assertNotEquals;

import com.epam.reportportal.ui.pages.LaunchesPage;

public class LaunchesPageSteps extends BaseStep {
  LaunchesPage launchesPage = new LaunchesPage();

  public void checkTotalColumnTextNotEqualTo(String expectedText) {
    assertNotEquals(launchesPage.getTotalColumn().getText(), expectedText);
  }

  public void checkPassedColumnTextNotEqualTo(String expectedText) {
    assertNotEquals(launchesPage.getPassedColumn().getText(), expectedText);
  }
}
