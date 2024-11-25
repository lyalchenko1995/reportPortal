Feature: Report Portal

  Background:
    Given open Report portal page

  @Smoke
  Scenario Outline: test2
    When open launches page
    Then <text> is not displayed in Total column
    Examples:
      | text |
      | total11 |
      | total22 |
      | total33 |
