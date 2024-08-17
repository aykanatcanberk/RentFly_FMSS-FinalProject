Feature: Sign Up Functionality

  Scenario: Successfully opening the Sign Up page
    Given user navigates to Sign Up page
    Then user should see the Sign Up page with all required fields

  Scenario: Successfully signing up with valid information
    Given user navigates to Sign Up page
    When user enters "John" as first name
    And user enters "Doe" as last name
    And user enters "test@example.com" as email
    And user enters "Password_" as password
    And user enters "5551234567" as phone
    And user clicks the Sign Up button
    Then user should be redirected to the homepage

  Scenario: Attempting to sign up with missing information
    Given user navigates to Sign Up page
    When user enters "John" as first name
    And user enters "Doe" as last name
    And user enters "test@example.com" as email
    And user enters "Password_" as password
    And user enters "" as phone
    And user clicks the Sign Up button
    Then user should see the message "Tüm alanları doldurmalısınız"

  Scenario: Attempting to sign up with an already registered email
    Given user navigates to Sign Up page
    When user enters "John" as first name
    And user enters "Doe" as last name
    And user enters "test@example.com" as email
    And user enters "Password_" as password
    And user enters "5551234567" as phone
    And user clicks the Sign Up button
    Then user should see the message "Bu email ile daha önce kayıt olunmuş"

  Scenario: Attempting to sign up with an invalid password format
    Given user navigates to Sign Up page
    When user enters "John" as first name
    And user enters "Doe" as last name
    And user enters "test@example.com" as email
    And user enters "123" as password
    And user enters "5551234567" as phone
    And user clicks the Sign Up button
    Then user should see the message "Şifre en az 8 karakter olmalı"

  Scenario: Attempting to sign up with an invalid phone number format
    Given user navigates to Sign Up page
    When user enters "John" as first name
    And user enters "Doe" as last name
    And user enters "test@example.com" as email
    And user enters "Password_" as password
    And user enters "aa12312a" as phone
    And user clicks the Sign Up button
    Then user should see the message "Geçersiz telefon numarası"

  Scenario: Attempting to sign up with an invalid email format
    Given user navigates to Sign Up page
    When user enters "John" as first name
    And user enters "Doe" as last name
    And user enters "testexample.com" as email
    And user enters "Password_" as password
    And user enters "5551234567" as phone
    And user clicks the Sign Up button
    Then user should see the message "Geçersiz email formatı"
