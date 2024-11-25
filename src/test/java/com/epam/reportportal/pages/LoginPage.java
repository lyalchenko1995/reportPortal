package com.epam.reportportal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  @FindBy(xpath = "//input[@name='login']")
  private WebElement loginField;

  @FindBy(xpath = "//input[@name='password']")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement loginButton;

  public WebElement getLoginField() {
    return loginField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getLoginButton() {
    return loginButton;
  }

  public void login() {
    //    getLoginField().sendKeys(System.getenv("USER_LOGIN"));
    //    getPasswordField().sendKeys(System.getenv("USER_PASSWORD"));
    getLoginField().sendKeys("superadmin");
    getPasswordField().sendKeys("erebus");
    getLoginButton().click();
  }
}
