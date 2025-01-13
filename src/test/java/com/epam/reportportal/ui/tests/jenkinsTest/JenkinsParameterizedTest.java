package com.epam.reportportal.ui.tests.jenkinsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class JenkinsParameterizedTest {
  protected WebDriver webDriver;

  @BeforeMethod
  public void setUp() {
    //    webDriver = createDriver();
  }

  @AfterMethod
  public void tearDown() {
    webDriver.quit();
  }

  //  private static WebDriver createDriver() {
  //    WebDriverManager.chromedriver().setup();
  //    ChromeOptions options = new ChromeOptions();
  //    options.addArguments("--incognito");
  //    options.addArguments("--remote-allow-origins=*");
  //    return new ChromeDriver(options);
  //  }

  //  parameter for jenkins for different browsers
  @Parameters({"Browser"})
  @Test
  public void jenkinsTest(String browserName) throws InterruptedException {
    if (browserName.equals("Edge")) {
      WebDriverManager.edgedriver().setup();
      EdgeOptions options = new EdgeOptions();
      options.addArguments("--incognito");
      options.addArguments("--remote-allow-origins=*");
      webDriver = new EdgeDriver(options);
    } else if (browserName.equals("Chrome")) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--incognito");
      options.addArguments("--remote-allow-origins=*");
      webDriver = new ChromeDriver(options);
    }

    webDriver.get("https://www.google.com/");
    Thread.sleep(3000);
  }
}
