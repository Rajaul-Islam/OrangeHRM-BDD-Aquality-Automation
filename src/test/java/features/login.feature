Feature: Login Functionality
  As a user of the OrangeHRM application
  I want to validate the login functionality
  So that I can securely access the system

  Background:
    When I open the OrangeHRM login page

  Scenario: TC_Login_01 - Verify successful login with valid credentials
    When I enter username "Admin"
    And I enter password "admin123"
    And I click the login button
    Then I should see the dashboard page

  Scenario: TC_Login_02 - Verify error message for invalid credentials
    When I enter username "invalidUser"
    And I enter password "wrongPass"
    And I click the login button
    Then I should see an error message "Invalid credentials"

  Scenario: TC_Login_03 - Verify login with blank username
    When I leave the username field empty
    And I enter password "admin123"
    And I click the login button
    Then I should see an empty text field error message with "Required" text

  Scenario: TC_Login_04 - Verify login with blank password
    When I enter username "Admin"
    And I leave the password field empty
    And I click the login button
    Then I should see an empty text field error message with "Required" text
