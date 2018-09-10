@all @post
Feature: Posting

  Scenario: User has valid posts
    Given there is a valid user
    When posts of the user are retrieved
    Then user should have valid posts

  Scenario: User can create a post
    Given there is a valid user
    When the user creates following valid post:
      | This is a valid post! |
    Then post should be posted