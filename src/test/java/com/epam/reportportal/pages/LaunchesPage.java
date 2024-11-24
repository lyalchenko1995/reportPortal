package com.epam.reportportal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaunchesPage extends BasePage {

    @FindBy(xpath = "//div[@data-id]")
    public List<WebElement> launchesList;

    @FindBy(xpath = "//div[@class='headerCell__title-container--cTbKe']//span[text()='total']")
    public WebElement totalColumn;

    @FindBy(xpath = "//div[@class='headerCell__title-container--cTbKe']//span[text()='passed']")
    public WebElement passedColumn;

    @FindBy(xpath = "//div[@class='headerCell__title-container--cTbKe']//span[text()='failed']")
    public WebElement failedColumn;

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
}
