package com.epam.reportportal.ui.tests.jenkinsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsTest {
  protected WebDriver webDriver;

  @BeforeMethod
  public void setUp() {
    webDriver = createDriver();
  }

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

  @Test
  public void jenkinsTest() throws InterruptedException {
    webDriver.get("https://www.google.com/");
    Thread.sleep(3000);
  }
}
