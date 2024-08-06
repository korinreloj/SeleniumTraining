#Each feature contains one feature
#Feature files use Gherkin language - business language
Feature: Test the login functionality of swaglabs

#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
Scenario: The user should be able to login with valid username and password
  Given user is on the login page
  When user enters correct credentials
  Then user gets confirmation
