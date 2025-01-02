package com.epam.reportportal.ui.tests.testNG;

import com.epam.reportportal.ui.steps.HomePageSteps;
import com.epam.reportportal.ui.steps.LaunchesPageSteps;
import com.epam.reportportal.ui.steps.LoginSteps;
import com.epam.reportportal.ui.tests.BaseTest;
import com.epam.reportportal.ui.utils.DataProviders;
import org.testng.annotations.Test;

public class TestNgTest extends BaseTest {
  private LoginSteps loginSteps;
  private HomePageSteps homePageSteps;
  private LaunchesPageSteps launchesPageSteps;

  @Override
  protected void setUpExtended() {
    loginSteps = new LoginSteps();
    homePageSteps = new HomePageSteps();
    launchesPageSteps = new LaunchesPageSteps();
  }

  @Test(dataProvider = "totalColumnDataProviderText", dataProviderClass = DataProviders.class)
  public void testTotalColumn(String expectedText) {
    loginSteps.login();
    homePageSteps.openLaunchesPage();
    launchesPageSteps.checkTotalColumnTextNotEqualTo(expectedText);
    //    loginSteps.login();

  }

  @Test(dataProvider = "passedColumnDataProviderText", dataProviderClass = DataProviders.class)
  public void testPassedColumn(String expectedText) {
    loginSteps.login();
    homePageSteps.openLaunchesPage();
    launchesPageSteps.checkPassedColumnTextNotEqualTo(expectedText);
  }
}
