Feature: Google search

  @positive
  @allure.id:1
  @allure.label.owner:admin
  Scenario: Google search AWS
    Given I am opening url "https://google.com"
    And I populate google search field with text "amazon aws"
    When I click button 'Google Search'
    Then I see that search results contains "Cloud Computing Services - Amazon Web Services (AWS)"


  @negative
  @allure.id:2
  @allure.label.owner:admin
  Scenario: Google search AWWS
    Given I am opening url "https://google.com"
    And I populate google search field with text "amazon aws"
    When I click button 'Google Search'
    Then I see that search results contains "Cloud Computing Services - Amazon Web Services (AWWS)"

  @allure.id:3
  @allure.label.owner:admin
  Scenario: Google search AWS
    Given I am opening url "https://google.com"
    And I populate google search field with text "amazon aws"
    When I click button 'Google Search'
    Then I see that search results contains "Cloud Computing Services - Amazon Web Services (AWS)"
