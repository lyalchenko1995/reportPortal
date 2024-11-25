package com.epam.reportportal.steps;

import com.epam.reportportal.drivermanager.Browser;
import com.epam.reportportal.pages.HomePage;
import com.epam.reportportal.pages.LaunchesPage;
import com.epam.reportportal.pages.LoginPage;
import com.epam.reportportal.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.reportportal.configurations.Configuration.BASE_URL;
import static com.epam.reportportal.utils.BrowserUtils.openUrl;
import static org.testng.Assert.assertNotEquals;

public class CucumberSteps {
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();;
    private LaunchesPage launchesPage = new LaunchesPage();

    @After("@Smoke")
    public void after() {
        Browser.close();
    }

    @Given("^open Report portal page$")
    public void openReportPortalPage() {
        openUrl(BASE_URL);
        loginPage.login();
        LOGGER.info("Login is successfully");
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
    }

    @When("^open launches page$")
    public void openLaunchesPage() {
        homePage.getLaunchesSideMenu().click();
    }

    @Then("^(.*) is not displayed in Total column$")
    public void textIsDisplayedInTotalColumn(String expectedText) {
        assertNotEquals(launchesPage.getTotalColumn().getText(), expectedText);
    }
}
