package com.epam.reportportal.utils;

import com.epam.reportportal.drivermanager.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserUtils {

  private static final Logger LOGGER = LogManager.getLogger(BrowserUtils.class);

  public static void openUrl(String url) {
    LOGGER.info("Opening URL: " + url);
    Browser.getDriver().get(url);
  }
}
