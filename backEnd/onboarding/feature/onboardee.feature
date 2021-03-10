Feature: Onboardee

    Scenario: Get Word record
    
    Given I Set GET word service api endpoint
    When I Set request HEADER
    And Send GET HTTP request
    Then I receive valid HTTP response code