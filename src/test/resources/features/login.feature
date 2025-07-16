Feature: Login to the application

Scenario: User logs in with valid credentials
  Given I open the login page
  When I enter the username "Paola" and password "secret_sauce"
  Then I should see the login page title
