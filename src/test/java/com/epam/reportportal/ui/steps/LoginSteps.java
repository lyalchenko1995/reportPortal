package com.epam.reportportal.ui.steps;

import com.epam.reportportal.ui.pages.HomePage;
import com.epam.reportportal.ui.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps extends BaseStep {

  LoginPage loginPage = new LoginPage();
  HomePage homePage = new HomePage();

  public void login() {
    //    getLoginField().sendKeys(System.getenv("USER_LOGIN"));
    //    getPasswordField().sendKeys(System.getenv("USER_PASSWORD"));
    loginPage.getLoginField().sendKeys("superadmin");
    loginPage.getPasswordField().sendKeys("erebus");
    loginPage.getLoginButton().click();
    wait.until(ExpectedConditions.visibilityOf(homePage.getLaunchesSideMenu()));
    log.info("Login is successfully");
  }
}
