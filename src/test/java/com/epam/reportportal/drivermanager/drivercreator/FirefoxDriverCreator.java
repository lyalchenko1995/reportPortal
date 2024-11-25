package com.epam.reportportal.drivermanager.drivercreator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverCreator implements DriverCreator {
  private static final Logger LOGGER = LogManager.getLogger(FirefoxDriverCreator.class);

  @Override
  public WebDriver createDriver() {
    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    LOGGER.info("Firefox options: {}", options);
    return new FirefoxDriver(options);
  }
}
