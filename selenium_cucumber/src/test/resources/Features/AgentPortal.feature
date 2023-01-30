@sanityTest
Feature: Feature to check the agent portal

  Scenario Outline: Check whether agent is able to create a Status
    Given login to <url> with agent <username> and <password>
    And navigate to Status Page
    When I create a new status
    Then the new status should be available in the list
    
    Examples:
    |url|username|password|
    |https://interview2.supporthive.com/staff/|Agent1|Agent@123|