Feature: Forgot Password Functionality

  Scenario: Successfully resetting password using email
    Given user is on the login page
    When user clicks on the Forgot Password link
    And user enters "test@example.com" as the email
    And user clicks the Submit button
    Then user should receive a password reset link

  Scenario: Successfully resetting password using phone number
    Given user is on the login page
    When user clicks on the Forgot Password link
    And user enters "5551234567" as the phone number
    And user clicks the Submit button
    Then user should receive a password reset link
