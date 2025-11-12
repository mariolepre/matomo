Scenario: Add a new website to track
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "All Websites"
  And clicks the "Add a new website" button
  And clicks "Website" button
  And enters "Web Test" on the name field
  And enters "http://webtest.matomo.it" on the URLs field
  And click on the "SAVE" button
  Then the "Website created" website is shown on the list of website
  And a notification "Website created" is displayed