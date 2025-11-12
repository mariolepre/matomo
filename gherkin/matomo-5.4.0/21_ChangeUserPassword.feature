Scenario: Invite a new user with "View" role
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks "Personal" link
  And clicks "Security" link
  And insert "e2eW3Bt3s71nGB3nchM4rK_New" in "New password" field
  And insert "e2eW3Bt3s71nGB3nchM4rK_New" in "New password (repeat)" field
  And insert "e2eW3Bt3s71nGB3nchM4rK" in "Your current password" field
  And click "Save" button
  