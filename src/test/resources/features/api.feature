Feature: Checkout product in Demoblaze

  Scenario: Successful checkout after login
    Given User is on Demoblaze homepage
    When User logs in with username "testaja" and password "testaja#"
    And User selects a product and adds it to cart
    And User proceeds to checkout and fills in details
    Then Purchase confirmation should be displayed
