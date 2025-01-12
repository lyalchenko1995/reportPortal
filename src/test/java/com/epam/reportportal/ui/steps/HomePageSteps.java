package com.epam.reportportal.ui.steps;

import com.epam.reportportal.ui.pages.HomePage;

public class HomePageSteps extends BaseStep {

  HomePage homePage = new HomePage();

  public void openLaunchesPage() {
    homePage.getLaunchesSideMenu().click();
    //    wait.until(ExpectedConditions.visibilityOf());
  }
}
