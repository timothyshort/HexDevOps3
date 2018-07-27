@development
Feature: the back-end options of the account management system
	As a registered member
	I want to access account information
	
	#Background: context or assumption for each scenario
	Background: the user is logged in
		Given the user is on the login page
		And the user enters valid credentials
	
	Scenario: user should see a welcome message
		Then the user should see a welcome message
	
	Scenario: user should be able to see their bill
		Then the user should see their bill
	
	Scenario: user should be able to see their account information
		Then the user should see account information
	
	Scenario: user should be able to logout
		When the clicks logout
		Then user should be logged out
	
	Scenario: user is logged out after 15 minutes of inactivity
		When the user is idle for 15 minutes
		Then the should be logged out