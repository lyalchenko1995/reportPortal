package com.epam.reportportal.ui.utils;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.JiraClient;

public class JiraServiceProvider {
  private JiraClient jira;
  private String project;

  public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
    BasicCredentials creds = new BasicCredentials(username, password);
    this.jira = new JiraClient(jiraUrl, creds);
    this.project = project;
  }

  public JiraClient getJiraClient() {
    return jira;
  }
}
