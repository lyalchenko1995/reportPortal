package com.epam.reportportal.ui.utils;

import com.epam.reportportal.ui.drivermanager.BrowserFactory;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, IInvokedMethodListener {

  // for cross browser
  //  @Override
  //  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
  //    Map<String, String> parameters =
  //        testResult.getTestContext().getCurrentXmlTest().getAllParameters();
  //    Browser.initDriver(parameters.get("browserName"));
  //  }

  @Override
  public void onTestSuccess(ITestResult result) {
    WebDriver driver = BrowserFactory.getDriver();
    Allure.addAttachment(
        "Screenshot on Success",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = BrowserFactory.getDriver();
    Allure.addAttachment(
        "Screenshot on Failure",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    WebDriver driver = BrowserFactory.getDriver();
    Allure.addAttachment(
        "Screenshot on Skip",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }
}
