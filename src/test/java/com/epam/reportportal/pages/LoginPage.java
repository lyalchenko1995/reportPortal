package com.epam.reportportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver webDriver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void openHomePage() {
        webDriver.manage().window().maximize();
//        webDriver.get(System.getenv("ENV_URL"));
        webDriver.get("http://localhost:8080/ui/#login");
    }

    public void login() {
//        getLoginField().sendKeys(System.getenv("USER_LOGIN"));
//        getPasswordField().sendKeys(System.getenv("USER_PASSWORD"));
        getLoginField().sendKeys("superadmin");
        getPasswordField().sendKeys("erebus");
        getLoginButton().click();
    }
}
