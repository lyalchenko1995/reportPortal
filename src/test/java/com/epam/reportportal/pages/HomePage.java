package com.epam.reportportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver webDriver;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openHomePage() {
        webDriver.manage().window().maximize();
        webDriver.get("https://rp.epam.com/");
    }
}
