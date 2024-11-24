package com.epam.reportportal.tests.jUnit;

import com.epam.reportportal.pages.HomePage;
import com.epam.reportportal.pages.LaunchesPage;
import com.epam.reportportal.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertNotEquals;

public class JUnitTest {

    protected WebDriver webDriver;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected LaunchesPage launchesPage;


    @BeforeEach
    public void setUp() {
        webDriver = createDriver();
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
        loginPage.login();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
        homePage.getLaunchesSideMenu().click();
        assertNotEquals(launchesPage.getFailedColumn().getText(), expectedText);
    }
}
