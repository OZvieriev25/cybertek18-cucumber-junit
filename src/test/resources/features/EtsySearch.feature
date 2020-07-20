Feature: Etsy search feature
  Agile story: User should be able to enter search terms and see result.

  Background: User is on the Etsy home page
    Given User is on the Etsy home page


  Scenario: Title verification
    Then User should see title as expected
    #expected: Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @etsyWip
  Scenario: Title verification after search term
    When User searches "wooden spoon" in the search box
    And User clicks to Search button
    Then User should see "wooden spoon" in the Etsy title

