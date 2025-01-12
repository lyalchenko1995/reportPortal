package com.epam.reportportal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(xpath = "(//div[@class='sidebarButton__sidebar-nav-btn--gbV_N'])[2]")
  private WebElement launchesSideMenu;

  public WebElement getLaunchesSideMenu() {
    return launchesSideMenu;
  }

  // initialization from BasePage
}
