Feature: Login to JPetStore
      
  @invalidsignin
  Scenario Outline: Login with invalid credentials
    Given User already in JPetStore login page
    When User enters username "<username>" and password "<password>"
    And User clicks on login button
    Then User should see an error message and stay on login page

    Examples:
      | username   | password  |
      | invalid123 | wrongpass | 
      
  @signin
  Scenario Outline: Login with valid credentials
    Given User already in JPetStore login page
    When User enters username "<username>" and password "<password>"
    And User clicks on login button
    Then User should be logged in successfully

    Examples:
      | username | password   |
      | raji2025 | raji@1233  |
