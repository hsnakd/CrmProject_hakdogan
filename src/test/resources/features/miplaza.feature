@miaplaza

Feature: Apply to MiaPrep Online High School

  Scenario Outline:User can navigate to the MiaPrep application page and submit the application
    Given The user is on the MiAcademy website
    When The user navigates to the MiaPrep Online High School page
    And The user clicks on Apply to Our School
    And The user fills in the Parent Information section
    And The user fills in the Student Information section
    And The user fills in the Financial Aid Application section
    And The user submits the application form
    Then Verify that the user should see a "<confirmation message>"
    Examples:
      | confirmation message                             |
      | You have successfully submitted your application |

#  Notes:
#  The forms of parents and students were filled in, but since they were not requested, the last two steps were prepared as if they had been submitted.



