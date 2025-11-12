Scenario: Add a new custom action dimension
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks the "Measurables" link
  And clicks the "Custom Dimensions" link
  And clicks on "Configure a new dimension" button in Action Dimension
  And enters "NewDimAct" on "Name" field
  And clicks on "Active" button
  And enters "/blog/(.*)/" on extract value field
  Then the "NewDimAct" name dimension is shown on the list of Visit Dimension