Scenario: Invite a new user with "View" role
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks the "System" link
  And clicks the "Users" link
  And clicks the "Inviate a new user" link
  And enters "user" in the "Username" field
  And enters "user@matomo.com" in the "Email" field
  And clicks the "Invite user" button
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks "Confirm" button
  Then "Invitation sent." message is displayed in the users table
  