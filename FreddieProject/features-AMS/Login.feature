Feature: The TrainingRite Login functionality of the Account Management System
  As a registered member of the application
  I want to login

  #Parameters: placeholder in one step, and a non-placeholder in another step
  Scenario: the member should be able to login with proper credentials, v1
    Given the guest is on the login page
    When the user enters "tim@testemail.com" as username
    And the user enters mypassword as password
    And the clicks the login button
    Then the user should see get a welcome message

  #Parameters: two placeholders in on step
  Scenario: the member should be able to login with proper credentials, v2
    Given the guest is on the login page
    When the user enters "tim@testemail.com" and "password" and clicks login
    Then the user should see get a welcome message

  #Parameters: one dataset at step-level
  Scenario: the member should be able to login with proper credentials, v3
    Given the guest is on the login page
    When the user enters credentials
      | jen@testemail.com | password |
    Then the user should see get a welcome message

  #Parameters: multiple datasets at step-level using List
  Scenario: after three failed attempts, the member should be able to login with proper credentials, with List
    Given the guest is on the login page
    When the user enters three bad login attempts and then a good login attempt
      | tim1@freddie.com  | myfreddie |
      | tim2@freddie.com  | myfreddie |
      | tim3@freddie.com  | myfreddie |
      | tim@testemail.com | password  |
    Then the user should see get a welcome message

  #Parameters: multiple datasets at step-level using Map
  Scenario: after two failed attempts, the member should be able to login with proper credentials, with Map
    Given the guest is on the login page
    When the user enters two bad login attempts and then a good login attempt
      | Username          | Password  |
      | jen1@freddie.com  | myfreddie |
      | jen2@freddie.com  | myfreddie |
      | tim@testemail.com | password  |
    Then the user should see get a welcome message

  #Parameters: multiple datasets at scenario-level
  @development
  Scenario Outline: the user should be able to access account information
    Given when the user is on the login page
    And when the user logs using credentials "<username>" and "<password>"
    Then the user should able to see "<account_info>"

    Examples: good sample data
      | username | password | account_info |
      | tim@testemail.com | password | bill pay |
      | tim@freddie.com | password | change password |
      | sarah@hex.com | password | update preferences |
      
    Examples: bad sample data
      | username | password | account_info |
      | 1@testemail.com | password | bill pay |
      | 2@freddie.com | password | change password |
      | 3@hex.com | password | update preferences | 