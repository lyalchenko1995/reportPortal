package com.epam.reportportal.ui.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaunchesPage extends BasePage {

  @FindBy(xpath = "//div[@data-id]")
  private List<WebElement> launchesList;

  @FindBy(xpath = "//div[@class='headerCell__title-container--cTbKe']//span[text()='total']")
  private WebElement totalColumn;

  @FindBy(xpath = "//div[@class='headerCell__title-container--cTbKe']//span[text()='passed']")
  private WebElement passedColumn;

  @FindBy(xpath = "//div[@class='headerCell__title-container--cTbKe']//span[text()='failed']")
  private WebElement failedColumn;

  public WebElement getFailedColumn() {
    return failedColumn;
  }

  public WebElement getPassedColumn() {
    return passedColumn;
  }

  public List<WebElement> getLaunchesList() {
    return launchesList;
  }

  public WebElement getTotalColumn() {
    return totalColumn;
  }

  // initialization from BasePage
}
