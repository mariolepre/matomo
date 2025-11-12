Scenario: Edit intranet website URL's, exlude parameters and change Ecommerce, Time Zone
  Given the user is on the login page "http://localhost:8082"
  And enters "admin" in the "Username" field
  And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
  And clicks the "Sign In" button
  And clicks the "Administration" icon
  And clicks the "Measurables" link
  And clicks the "Menage" link
  And check the "Intranet Web Test" website is present
  And click the "Intranet Web Test" website modify icon
  And clean the "URLs" field
  And enters "https://intranetwebtest.matomo.it" on the "URL's" field
  And enters "172.0.0.1" on "Excluded IPs" field
  And enters "/^sess" on "Excluded Parameters" field
  And enters "/bot" on "Excluded User Agents" field
  And enters "https://intranetwebtest.matomo.it/info" on "Excluded refferers" field
  And select "Ecommerce enabled" on "Ecommerce" dropdown menù
  And select "UTC+1" in "Time Zone" dropdown menù
  And click on the "SAVE" button
  Then the notification "Website updated" is displayed