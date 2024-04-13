Feature: Verify Forgot password funtionality

  Background: 
    Given User launched the browser.
    When User entered url.
    
  @ForgotPassword
  Scenario Outline: Verify if user is able change the password if passowrd incorrect.
    When User enter emaild as "<emailID>" and password as "<password>".
    And User click on login button.
    And If user getting incorrect password.
    And User click on forgot password link.
    Then User land on Enter New Password screen.
    And User entered emaild as "<emailID>" and password as "<NewPassword>" and confirm passowrd as "<NewPassword>".
    And User click on save new passowrd button.
    Then User should be able to see success message.

    Examples: 
      | emailID          | password  |NewPassword|
      | SHhoyb@gmail.com | Chary@129 |Chary@123  |
