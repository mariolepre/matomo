Scenario: Create a new personal schedule report for website "Web Test"
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks the "Personal" link
  And clicks the "Schedule Reports" link
  And select "Web Test" website from the websites list
  And clicks "Create and schedule a report" button
  And add "Daily Report" in description field
  And select "All Websites Dashboard" on All Websites checkbox
  And clicks on "Create Report" button
  Then "Daily Report" description is shown in the Personal Scheduled Reports list