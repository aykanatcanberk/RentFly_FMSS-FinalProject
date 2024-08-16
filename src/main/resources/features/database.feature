Feature: Database Column and Constraint Validation

  Scenario: Verify email column type
    Given a connection to the database
    When checking the data type of email column
    Then the data type should be varchar with a maximum length of 50

  Scenario: Verify sign_up_date column type
    Given a connection to the database
    When checking the data type of sign_up_date column
    Then the data type of sign_up_date should be date

  Scenario: Verify password column type
    Given a connection to the database
    When checking the data type of password column
    Then the data type should be varchar with a maximum length of 250

  Scenario: Verify phone column type
    Given a connection to the database
    When checking the data type of phone column
    Then the data type of phone should be varchar with a maximum length of 50

  Scenario: Verify birth_date column type
    Given a connection to the database
    When checking the data type of birth_date column
    Then the data type of birth_date should be date

  Scenario: Verify status column type
    Given a connection to the database
    When checking the data type of status column
    Then the data type of status should be varchar with a maximum length of 50

  Scenario: Verify foreign key constraints
    Given a connection to the database
    When checking foreign key constraints
    Then the correct foreign key constraints should exist
