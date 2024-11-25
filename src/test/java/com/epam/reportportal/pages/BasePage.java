package com.epam.reportportal.pages;

import static com.epam.reportportal.drivermanager.Browser.getDriver;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
  public BasePage() {
    PageFactory.initElements(getDriver(), this);
  }
}
