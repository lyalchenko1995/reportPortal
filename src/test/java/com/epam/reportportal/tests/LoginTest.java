package com.epam.reportportal.tests;


import com.epam.reportportal.pages.HomePage;
import com.epam.reportportal.pages.LoginPage;
import com.epam.reportportal.utils.BaseTest;
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
    public void testLogin() {
        homePage.openHomePage();
        loginPage.login();
        System.out.println("passed");
    }
}
