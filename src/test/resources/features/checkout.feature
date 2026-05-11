@regression
Feature: Checkout functionality

  Background:
    Given I open the login page
    When I enter "standard_user" into the username field
    And I enter "secret_sauce" into the password field
    And I click the login button

  Scenario: Complete checkout process
    When I add the first product to the cart
    And I navigate to the cart
    And I click the checkout button
    And I enter "Ulises" into the first name field
    And I enter "Lara" into the last name field
    And I enter "5986" into the zip code field
    And I click the continue button
    And I finish the checkout process
    Then I should see the confirmation message "Thank you for your order!"