Feature: Google search

  @positive
  Scenario: Google search AWS
    Given I am opening url "https://google.com"
    And I populate google search field with text "amazon aws"
    When I click button 'Google Search'
    Then I see that search results contains "Cloud Computing Services - Amazon Web Services (AWS)"

  @negative
  Scenario: Google search AWWS
    Given I am opening url "https://google.com"
    And I populate google search field with text "amazon aws"
    When I click button 'Google Search'
    Then I see that search results contains "Cloud Computing Services - Amazon Web Services (AWWS)"