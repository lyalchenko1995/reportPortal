package com.epam.reportportal.ui.drivermanager.drivercreator;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriver implements Driver {

  @Override
  public WebDriver createDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    log.info("Firefox options: {}", options);
    WebDriver webDriver = new org.openqa.selenium.firefox.FirefoxDriver(options);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // implicit wait
    return webDriver;
  }
}
