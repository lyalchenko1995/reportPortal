package com.epam.reportportal.tests;


import com.epam.reportportal.pages.HomePage;
import com.epam.reportportal.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    protected HomePage homePage;
    protected LoginPage loginPage;

    @Override
    protected void setUpExtended() {
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @Test
    public void testLogin() throws InterruptedException {
        logger.info("Test log4j - Open home page");
        loginPage.openHomePage();
        logger.info("Test log4j - Login");
        loginPage.login();
        logger.info("Test log4j - Sleep");
        Thread.sleep(3000);
        logger.info("Test log4j - Test passed");
    }
}
