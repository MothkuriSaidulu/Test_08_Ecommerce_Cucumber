Feature: SignUp Module

  Background: 
    Given User launched the browser.
    When User entered url.

  @signUp
  Scenario: verify new user is able signup successfully.
    And User clicked on Register here.
    Then User should be land on Register page.
    And User fill the details.
    When User clicked on register button.
    Then User should be able see "Account Created Successfully" message.

  ##And Close the browser.

