Scenario: Add a new website to track
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks the "Measurables" link
  And clicks the "Manage" link
  And clicks on the trash button on the row of the website "Web Test"
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks on "confirm" button
  Then the "Web Test" website is no more displayed on the list of website