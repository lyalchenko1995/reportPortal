package com.epam.reportportal.tests;

import com.epam.reportportal.pages.HomePage;
import com.epam.reportportal.pages.LoginPage;
import com.epam.reportportal.utils.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        WebDriver webDriver = DriverManager.getDriver();
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @AfterEach
    public void tearDownDriver() {
        DriverManager.tearDownDriver();
    }

    @Test
    public void testLogin() {
        homePage.openHomePage();
        loginPage.login();
        System.out.println("passed");
    }
}
