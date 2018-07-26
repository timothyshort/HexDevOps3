Feature: The TrainingRite Login functionality of the Account Management System
	As a registered member of the application
	I want to login
	
	Scenario: the member should be able to login with proper credentials
		Given the guest is on the login page
		When the user enters "tim@testemail.com" as username
		And the user enters "password" as password
		And the clicks the login button
		Then the user should see get a welcome message