@regression
Feature: Cart functionality

  Background:
    Given I open the login page
    When I enter "standard_user" into the username field
    And I enter "secret_sauce" into the password field
    And I click the login button

  Scenario: Add product to cart
    When I add the first product to the cart
    Then the cart badge should show "1"