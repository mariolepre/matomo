Scenario: User logs out successfully
    Given the user is logged in as admin
    When the user click on "Logout" button
    Then login page is shown