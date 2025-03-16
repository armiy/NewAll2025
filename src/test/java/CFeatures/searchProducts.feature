Feature: Searching a product using a search field
  Scenario Outline: Searching multiple products in the ebay website
    When users enter this <item> in the search field
    And users click the search button
    Then users land on the searched item this <pageTitle> page
    Examples:
      | item           | pageTitle |
      | iPhone         | eBay      |
      | Samsung phones | eBay      |
      | Boys shoes     | eBay      |
