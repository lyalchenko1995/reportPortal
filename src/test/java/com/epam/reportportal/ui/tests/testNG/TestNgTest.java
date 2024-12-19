package com.epam.reportportal.ui.tests.testNG;

import static org.testng.Assert.*;

import com.epam.reportportal.ui.drivermanager.Browser;
import com.epam.reportportal.ui.pages.HomePage;
import com.epam.reportportal.ui.pages.LaunchesPage;
import com.epam.reportportal.ui.pages.LoginPage;
import com.epam.reportportal.ui.tests.BaseTest;
import com.epam.reportportal.ui.utils.DataProviders;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestNgTest extends BaseTest {

  protected HomePage homePage;
  protected LoginPage loginPage;
  protected LaunchesPage launchesPage;

  @Override
  protected void setUpExtended() {
    loginPage = new LoginPage();
    homePage = new HomePage();
    launchesPage = new LaunchesPage();
  }

  @Test(
      dataProvider = "totalColumnDataProviderText",
      dataProviderClass = DataProviders.class,
      threadPoolSize = 2)
  public void testTotalColumn(String expectedText) {
    loginPage.login();
    LOGGER.info("Login is successfully");
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
    homePage.getLaunchesSideMenu().click();
    assertNotEquals(launchesPage.getTotalColumn().getText(), expectedText);
  }

  @Test(dataProvider = "passedColumnDataProviderText", dataProviderClass = DataProviders.class)
  public void testPassedColumn(String expectedText) {
    loginPage.login();
    LOGGER.info("Login is successfully");
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
    homePage.getLaunchesSideMenu().click();
    assertNotEquals(launchesPage.getPassedColumn().getText(), expectedText);
  }
}
