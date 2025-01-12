package com.epam.reportportal.ui.steps;

import com.epam.reportportal.ui.drivermanager.BrowserFactory;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseStep {

  protected static final Logger log = LoggerFactory.getLogger(BaseStep.class);
  protected WebDriverWait wait =
      new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(10));

  public static void openUrl(String url) {
    log.info("Opening URL: " + url);
    BrowserFactory.getDriver().get(url);
  }
}
