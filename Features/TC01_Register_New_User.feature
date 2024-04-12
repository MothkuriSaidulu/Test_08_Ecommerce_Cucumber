Feature: SignUp Module

  ##
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
    And Close the browser.

  @ForgotPassword
  Scenario: Verify if user is able change the password if passowrd incorrect.
    When User enter emaild as <email> and password as <password>.
    And User click on login button.
    And If user getting incorrect password.
    And User click on forgot password link.
		Then User land on Enter New Password screen.
		And User entered emaild as <email> and password as <password> and confirm passowrd as <password>.
		And User click on save new passowrd button.
		Then User should be able to see success message.
		