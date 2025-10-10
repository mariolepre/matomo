Scenario: Add a new website to track
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "All Websites"
  And clicks the "Add a new website" button
  And clicks "Intranet website" button
  And enters "TEST" on the name field
  And enters "http://test.matomo.it" on the URLs field
  And click on the "save" button
  Then the "test" website is shown on the list of website
  And a notification "Website created" is displayed