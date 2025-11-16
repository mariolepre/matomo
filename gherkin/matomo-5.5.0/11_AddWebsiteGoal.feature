Scenario: Adds a new goal for a "Web Test" website
  Given the user is on the home page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  When the user clicks the "Administration" link
  And clicks the "Measurables" link
  And clicks the "Goals" link
  And clicks the "Web Test" website on dropdown website lists
  And clicks the "Add a new goal" button
  And enters "Make profit" in the "Goal Name" field
  And selects "Improve Company Revenue" in the "Description" field
  And enters "/thank-you" in the "Pattern" field
  And clicks the "Add Goal" button
  Then "Make profit" goal name appears in the goals list
