Scenario: Failed login with invalid credentials
  Given the user is on the login page "http://localhost:8082"
  When I enter username "admin" in the "Username or e-mail" field
  And the user enter the password "wrongpass" in the "Password" field
  And they click on the "Sign In" button
  Then An error message "Error: Wrong username and/or password." is displayed
