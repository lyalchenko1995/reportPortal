package com.epam.reportportal.ui.drivermanager;

import static com.epam.reportportal.ui.configurations.Configuration.BROWSER_NAME;

import com.epam.reportportal.ui.drivermanager.drivercreator.*;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    if (null == driver.get()) {
      driver.set(initDriver());
    }
    return driver.get();
  }

  public static String getBrowserName() {
    return BROWSER_NAME;
  }

  private static WebDriver initDriver() {
    Driver creator =
        switch (getBrowserName()) {
          case "chrome" -> new ChromeDriver();
          case "firefox" -> new FirefoxDriver();
          case "edge" -> new EdgeDriver();
          default -> throw new IllegalStateException("Unexpected value: " + getBrowserName());
        };
    return Objects.requireNonNull(creator.createDriver(), "Could not create driver");
  }

  // for cross browser
  //  public static WebDriver initDriver(String browser) {
  //    DriverCreator creator =
  //        switch (browser) {
  //          case "chrome" -> new ChromeDriverCreator();
  //          case "firefox" -> new FirefoxDriverCreator();
  //          case "edge" -> new EdgeDriverCreator();
  //          default -> throw new IllegalStateException("Unexpected value: " + browser);
  //        };
  //    driver.set(creator.createDriver());
  //    return Objects.requireNonNull(creator.createDriver(), "Could not create driver");
  //  }

  public static void close() {
    if (!(driver.get() == null)) {
      BrowserFactory.getDriver().quit();
      driver.remove();
    }
  }
}
