package com.epam.reportportal.ui.utils;

import com.epam.reportportal.ui.drivermanager.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserUtils {

  private static final Logger LOGGER = LogManager.getLogger(BrowserUtils.class);

  public static void openUrl(String url) {
    LOGGER.info("Opening URL: " + url);
    Browser.getDriver().get(url);
  }
}
