@login @regression
Feature: Login into website

  Background:
    Given I access the webdriver university home page
    When I click in login portal

  @successfully
  Scenario: Successfully Login
    And I enter a username webdriver
    And I enter a password webdriver123
    And I click on login button
    Then I validate the successfully message

  @unsuccessfully
  Scenario: Unsuccessfully Login
    And I enter a username webdriverasdasd
    And I enter a password webdriv8545
    And I click on login button
    Then I validate the unsuccessfully message

  @two
  Scenario Outline: <scenarios> Login
    And I enter a username <username>
    And I enter a password <password>
    And I click on login button
    Then I validate the message <loginMessage>

    Examples:
      | scenarios      | username  | password     | loginMessage         |
      | Successfully   | webdriver | webdriver123 | validation succeeded |
      | Unsuccessfully | wtfudoing | doinnothing  | validation failed    |