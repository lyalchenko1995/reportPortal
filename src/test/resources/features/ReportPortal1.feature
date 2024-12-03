Feature: Feature1

  Background:
    Given open Report portal page

    @Smoke
    Scenario Outline: Scenario1
      When open launches page
      Then <text> is not displayed in Total column
      Examples:
        | text |
        | total1 |
        | total2 |
        | total3 |
        | total4 |
        | total5 |