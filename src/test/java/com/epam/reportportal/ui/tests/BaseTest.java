package com.epam.reportportal.ui.tests;

import static com.epam.reportportal.ui.configurations.Configuration.BASE_URL;
import static com.epam.reportportal.ui.steps.BaseStep.openUrl;

import com.epam.reportportal.ui.drivermanager.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

  @BeforeMethod
  public void init() {
    openUrl(BASE_URL);
    setUpExtended();
  }

  protected abstract void setUpExtended();

  @AfterMethod
  public void close() {
    BrowserFactory.close();
  }
}
