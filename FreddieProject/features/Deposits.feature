Feature: implement the deposits functionality

  Background: the user is logged in
    Given the user logged in

  @govReg
  Scenario: the user should be able to click on make deposit
    And the user sees Make Deposit
    When the user clicks Make Deposit
    Then the user is taken the deposits page

  @success
  Scenario: the user should be able to make a deposit
    Given the user is on the deposit page
    When the user enters deposit amount and clicks submit
    Then the user should see a confirmation message

  @success
  Scenario: the user should see their recent deposits
    Given the suer is on the deposit page
    Then the user should see recent deposits

  @rejection
  Scenario: a deposit should be rejected if larger than $5000
    Given the user enters a deposit of at least 5000
    Then the deposit is rejected
