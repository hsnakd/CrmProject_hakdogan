Feature: PDF Download

  Scenario: Download the PDF file
    Given I navigate to the PDF file
    When I download the PDF file
    Then the PDF file should be downloaded
