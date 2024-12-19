package com.epam.reportportal.ui.tests;

import static com.epam.reportportal.ui.configurations.Configuration.BASE_URL;
import static com.epam.reportportal.ui.utils.BrowserUtils.openUrl;

import com.epam.reportportal.ui.drivermanager.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
  protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

  @BeforeMethod
  public void init() {
    openUrl(BASE_URL);
    setUpExtended();
  }

  protected abstract void setUpExtended();

  @AfterMethod
  public void close() {
    Browser.close();
  }
}
