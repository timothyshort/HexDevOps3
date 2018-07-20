Feature: The Freddie Mac Mortgage Lender Submission Application
  As a Freddie Mac customer
  I want to submit a loan application
  So that I can get feedback on a loan

  Scenario: a user can submit a loan application
    Given a client logs into the system
    When the client submits a loan application
    Then the client gets a receipt confirmation

#Additional scenarios
