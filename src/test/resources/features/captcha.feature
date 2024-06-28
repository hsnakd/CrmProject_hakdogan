@captcha
Feature: Captcha Page

  Scenario: Verify captcha checkbox
    Given I am on the vote page
    When I click the captcha checkbox
    Then I should see the captcha is checked
