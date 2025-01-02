package com.epam.reportportal.ui.drivermanager.drivercreator;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverCreator implements DriverCreator {

  @Override
  public WebDriver createDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    log.info("Firefox options: {}", options);
    WebDriver webDriver = new FirefoxDriver(options);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//implicit wait
    return webDriver;
  }
}
