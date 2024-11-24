package com.epam.reportportal.pages;

import org.openqa.selenium.support.PageFactory;
import static com.epam.reportportal.drivermanager.Browser.getDriver;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
}
