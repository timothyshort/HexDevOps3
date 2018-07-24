Feature: Freddie Loan Delivery Service System App
  As a Freddie Mac client
  I want to submit loan application
  So that I can receive a quote

  Scenario: client fills out the LDSS form
  	Given client logs into to ldss
  	When client enters loan information
  	Then client receives a confirmation
  	And client receives a quote