Feature: Search Item on Ebay and put item in Cart Test
  #: Before Every Scenario
   # When users are on ebay website
@FindItemsbyCategory
  Scenario: Finding Samsung Mobile phones and putting in cart without login
    When users select  Computers/Tablets & Networking in category selection
    And users search click to search for Laptops
    And users click for Dell Laptops
    And user search for Dell specific
    Then users see this page title Dell 15.6" Touchscreen



