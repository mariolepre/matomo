Scenario: Edits an existing goal
  Given the user is on the home page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  hen the user clicks the "Administration" link
  And clicks the "Measurables" link
  And clicks the "Goals" link
  And select "Web Test" on dropdown menù
  And checks the "Make profit" on "Goal Name" column
  And clicks the "Modify" icon of "Make Profit" 
  And selects "Destination URL" in the "Goal Type" dropdown
  And enters "Make more profit" on "Goal Name" field
  And enters "Maximize Company Revenue" on "Description" field
  And select "Stay for a certain amount of time" on "Goal is triggered" checkbox
  And enters "2" in "Time in Minutes" field
  And enters "10" on "Goal Revenue" field
  And clicks on "Update Goal" button
  And enters "/thank-you-success" in the "Pattern" field
  And selects "contains" in the "Match Type" dropdown
  And clears the "Goal Value" field
  And enters "2" in the "Goal Value" field
  And clicks the "Save" button
  Then the "Make more profit" goal shows the modification