package com.epam.reportportal.ui.drivermanager.drivercreator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverCreator implements DriverCreator {

  @Override
  public WebDriver createDriver() {
    System.setProperty("webdriver.edge.driver", "drivers/MicrosoftWebDriver.exe");
    return new EdgeDriver();
  }
}
