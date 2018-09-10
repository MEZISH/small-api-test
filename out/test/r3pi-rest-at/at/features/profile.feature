@all @profile
Feature: Profile

  @test
  Scenario: User has valid address and email
    When random user data is retrieved
    Then user address should be present
    And user e-mail should be valid