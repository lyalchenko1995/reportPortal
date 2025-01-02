package com.epam.reportportal.ui.drivermanager.drivercreator;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverCreator implements DriverCreator {

  @Override
  public WebDriver createDriver() {
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--incognito");
    options.addArguments("--start-maximized");
    log.info("Edge options: {}", options);
    WebDriver webDriver = new EdgeDriver(options);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//implicit wait
    return webDriver;
  }
}
