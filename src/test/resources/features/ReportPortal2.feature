Feature: Feature2

  Background:
    Given open Report portal page

  @Smoke
  Scenario Outline: Scenario2
    When open launches page
    Then <text> is not displayed in Total column
    Examples:
      | text |
      | total11 |
      | total22 |
      | total33 |
