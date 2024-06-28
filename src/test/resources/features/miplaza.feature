Feature: Apply to MiaPrep Online High School

  Scenario: User can navigate to the MiaPrep application page and submit the application
    Given The user is on the MiAcademy website
    When The user navigates to the MiaPrep Online High School page
    And The user clicks on "Apply to Our School"
    And The user fills in the Parent Information with "John Doe" and "john.doe@example.com"
    And The user proceeds to the Student Information page
    And The user fills in the Student Information with "Jane Doe" and "jane.doe@example.com"
    And The user submits the application form
    Then The user should see a confirmation message
