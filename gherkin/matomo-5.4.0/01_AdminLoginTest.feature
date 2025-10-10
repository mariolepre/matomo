Scenario: Log in as administrator
  Given the user is on the login page "http://localhost:8082"
  When the user enter the username "admin" in the "Username or e-mail" field
  And the user enter the password "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And they click on the "Sign In" button
  Then The dashboard is displayed
