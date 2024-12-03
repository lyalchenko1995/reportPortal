package com.epam.reportportal.drivermanager.drivercreator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverCreator implements DriverCreator {
  private static final Logger LOGGER = LogManager.getLogger(ChromeDriverCreator.class);

  public WebDriver createDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setCapability("platformName", Platform.WINDOWS);
    options.addArguments("--ignore-certificate-errors");
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");

    LOGGER.info("Chrome options: {}", options);
    return new ChromeDriver(options);
  }
}
