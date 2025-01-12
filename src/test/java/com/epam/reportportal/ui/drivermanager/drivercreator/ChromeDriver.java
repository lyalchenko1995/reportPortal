package com.epam.reportportal.ui.drivermanager.drivercreator;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriver implements Driver {

  public WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setCapability("platformName", Platform.WINDOWS);
    options.addArguments("--ignore-certificate-errors");
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");

    log.info("Chrome options: {}", options);
    WebDriver webDriver = new org.openqa.selenium.chrome.ChromeDriver(options);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // implicit wait
    return webDriver;
  }
}
