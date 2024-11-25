package com.epam.reportportal.drivermanager;

import com.epam.reportportal.drivermanager.drivercreator.*;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static com.epam.reportportal.configurations.Configuration.BROWSER_NAME;

public class Browser {

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
        DriverCreator creator = switch (getBrowserName()) {
            case "chrome" -> new ChromeDriverCreator();
            case "firefox" -> new FirefoxDriverCreator();
            case "edge" -> new EdgeDriverCreator();
            default -> throw new IllegalStateException("Unexpected value: " + getBrowserName());
        };
        return Objects.requireNonNull(creator.createDriver(), "Could not create driver");
    }

    public static void close() {
        if (!(driver.get() == null)) {
            Browser.getDriver().quit();
            driver.remove();
        }
    }


}