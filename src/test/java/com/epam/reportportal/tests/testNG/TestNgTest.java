package com.epam.reportportal.tests.testNG;


import com.epam.reportportal.drivermanager.Browser;
import com.epam.reportportal.pages.HomePage;
import com.epam.reportportal.pages.LaunchesPage;
import com.epam.reportportal.pages.LoginPage;

import static org.testng.Assert.*;

import com.epam.reportportal.tests.BaseTest;
import com.epam.reportportal.utils.DataProviders;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNgTest extends BaseTest {

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected LaunchesPage launchesPage;

    @Override
    protected void setUpExtended() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        launchesPage = new LaunchesPage();
    }

    @Test(dataProvider = "totalColumnDataProviderText", dataProviderClass = DataProviders.class, threadPoolSize = 2)
    public void testTotalColumn(String expectedText) {
        loginPage.login();
        LOGGER.info("Login is successfully");
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
        homePage.getLaunchesSideMenu().click();
        assertNotEquals(launchesPage.getTotalColumn().getText(), expectedText);
    }

//    @Test(dataProvider = "passedColumnDataProviderText", dataProviderClass = DataProviders.class)
//    public void testPassedColumn(String expectedText) {
//        loginPage.login();
//        LOGGER.info("Login is successfully");
//        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
//        homePage.getLaunchesSideMenu().click();
//        assertNotEquals(launchesPage.getPassedColumn().getText(), expectedText);
//    }
}
