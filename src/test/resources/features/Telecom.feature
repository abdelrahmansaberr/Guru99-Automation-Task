Feature: Guru99 Telecom Test Cases

  Scenario: Test Case 1 Successfully create a new customer
    Given the user on the home page
    When the user clicks on Add Customer from the side menu
    And the user checks the background button
    And fills out the customer form
    And clicks the customer submit button
    Then customer ID should be generated and captured

  Scenario: Test Case 2 Assign a tariff plan to the generated customer ID
    Given the user on homepage
    When the user clicks on Add Tariff Plan to Customer from the side menu
    And enters the saved Customer ID
    And clicks the ID submit button
    And selects a tariff plan radio button
    And clicks the plan submit button
    Then the confirmation message Congratulation Tariff Plan Assigned should appear