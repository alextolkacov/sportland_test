Feature: Check men footbal shoes section

  Scenario: Check filters
    Given open "sportland.lv" link
    When push menu
    And choose "PRODUKTI" section
    And select "Futbols" under "APAVI" section in "ZĒNI" tab
    And sort products by "Izpārdošana"
    And select filters:
      | Futbola apavi cietam segumam |
      | Nike                         |
    Then on page appeared only "Nike" brand shoes
    And all products are on sale
    And create txt file with with info about products
    And create json file with the same information
    And close browser



