package com.epam.reportportal.ui.tests.jUnit;

import static org.testng.Assert.assertNotEquals;

import com.epam.reportportal.ui.pages.HomePage;
import com.epam.reportportal.ui.pages.LaunchesPage;
import com.epam.reportportal.ui.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnitTest {

  protected WebDriver webDriver;

  protected HomePage homePage;
  protected LoginPage loginPage;
  protected LaunchesPage launchesPage;

  @BeforeEach
  public void setUp() {
    webDriver = createDriver();
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // implicit wait
    loginPage = new LoginPage();
    homePage = new HomePage();
    launchesPage = new LaunchesPage();
  }

  @AfterEach
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

  @ParameterizedTest
  @ValueSource(strings = {"failed1", "failed2", "failed3", "failed4", "failed5"})
  public void testFailedColumn(String expectedText) {
    //    login
    loginPage.getLoginField().sendKeys("superadmin");
    loginPage.getPasswordField().sendKeys("erebus");
    loginPage.getLoginButton().click();
    //
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
    homePage.getLaunchesSideMenu().click();
    assertNotEquals(launchesPage.getFailedColumn().getText(), expectedText);
  }
}
