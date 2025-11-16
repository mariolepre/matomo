Scenario: Adds a new intranet website
  Given the user is on the home page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "All Websites" link
  And clicks the "Add a new intranet website" button
  And clicks on "Intranet Website"
  And enters "Intranet Web Test" in the "Name" field
  And enters "http://intranetwebtest.matomo.it" in the "Website URL" field
  And clicks the "SAVE" button
  Then the message "Website created" is displayed
  And "Intranet Portal" appears in the websites list
