package com.epam.reportportal.ui.tests.jira;

import com.epam.reportportal.ui.utils.JiraServiceProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.rcarz.jiraclient.Issue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JiraTest {

  private WebDriver webDriver;
  private JiraServiceProvider jiraServiceProvider;

  @BeforeMethod
  public void setUp() {
    webDriver = createDriver();
    jiraServiceProvider =
        new JiraServiceProvider(
            "https://ars-epam-test.atlassian.net/",
            "arsenii_lialchenko@epam.com",
            "userAuth",
            "SMS");
  }

  private static WebDriver createDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    options.addArguments("--remote-allow-origins=*");
    return new ChromeDriver(options);
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    webDriver.quit();

    String issueKey = "SMS-3"; // Это нужно заменить на динамическое значение, связанное с тестом
    try {
      Issue issue = jiraServiceProvider.getJiraClient().getIssue(issueKey);

      if (result.isSuccess()) {
        issue.addComment("Automation test is Passed. Status changed to Done");
        issue
            .transition()
            .execute("Done"); // Название состояния в JIRA для успешно завершённого теста
      } else {
        issue.addComment("Automation test is Failed. Status changed to To Do");
        issue.transition().execute("To Do"); // Название состояния в JIRA для неуспешного теста
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void jiraTest() throws InterruptedException {
    webDriver.get("https://www.google.com/");
    Thread.sleep(3000);
  }
}
