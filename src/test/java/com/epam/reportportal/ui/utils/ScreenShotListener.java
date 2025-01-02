package com.epam.reportportal.ui.utils;

import com.epam.reportportal.ui.drivermanager.Browser;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListener implements ITestListener {

  @Override
  public void onTestSuccess(ITestResult result) {
    WebDriver driver = Browser.getDriver();
    Allure.addAttachment(
        "Screenshot on Success",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = Browser.getDriver();
    Allure.addAttachment(
        "Screenshot on Failure",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    WebDriver driver = Browser.getDriver();
    Allure.addAttachment(
        "Screenshot on Skip",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }
}
