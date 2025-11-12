Scenario: Deletes an existing goal
  Given the user is on the home page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  When the user clicks the "Administration" link
  And clicks the "Measurables" link
  And clicks the "Goals" link
  And select "Web Test" on dropdown menù
  And checks the "Make more profit" on "Goal Name" column
  And clicks the "Yes" button on the popup of confirmation of delete 
  Then the goal "Make more profit" is not displayed anymore on the list of goals
