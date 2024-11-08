package com.epam.reportportal.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = createDriver();
        setUpExtended();
    }

    protected abstract void setUpExtended();

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    private static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
