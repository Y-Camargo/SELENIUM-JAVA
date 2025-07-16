Feature: Login to the application

Scenario: User logs in with valid credentials
  Given I open the login page
  When I enter the username "Paola" and password "secret_sauce"
  Then I should see the login page title

Scenario: User logs in with invalid credentials
  Given I open the login page
  When I enter the username "invalid_user" and password "wrong_pass"
  Then I should see the error message "Epic sadface: Username and password do not match any user in this service"
