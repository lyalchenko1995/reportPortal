package com.epam.reportportal.ui.drivermanager.drivercreator;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriver implements Driver {

  @Override
  public WebDriver createDriver() {
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    log.info("Edge options: {}", options);
    WebDriver webDriver = new org.openqa.selenium.edge.EdgeDriver(options);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // implicit wait
    return webDriver;
  }
}
