package com.epam.reportportal.ui.steps;

import com.epam.reportportal.ui.drivermanager.Browser;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseStep {

  protected static final Logger log = LoggerFactory.getLogger(BaseStep.class);
  WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));

  public static void openUrl(String url) {
    log.info("Opening URL: " + url);
    Browser.getDriver().get(url);
  }
}
