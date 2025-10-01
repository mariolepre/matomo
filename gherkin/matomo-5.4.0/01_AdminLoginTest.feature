Feature: Admin login with valid credentials
  As an administrator
  I want to see the dashboard when i login in the application

  Background:
    Given the user is on the login page("http://localhost:8082/login")

  Scenario: Log in as administrator
    When the user enter the username "admin" in the "Username or e-mail" field
    And the user enter the password "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
    And they click on the "Sign In" button
    Then The dashboard is displayed
