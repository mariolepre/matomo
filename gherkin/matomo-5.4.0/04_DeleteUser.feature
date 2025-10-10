Scenario: Delete an user
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks the "System" link
  And clicks the "Users" link
  And clicks on the trash button on the row of the username "user"
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks on "confirm" button
  Then "user" with role "View" is no more displayed in the users table
  And a notification "The selected users have been removed." is displayed