package com.epam.reportportal.ui.drivermanager.drivercreator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public interface DriverCreator {
  WebDriver createDriver();
  Logger log = LogManager.getLogger(DriverCreator.class); //public static final by default
}
