package com.epam.reportportal.ui.pages;

import static com.epam.reportportal.ui.drivermanager.BrowserFactory.getDriver;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
  public BasePage() {
    PageFactory.initElements(getDriver(), this);
  }
}
