@test
Feature: Test

  Scenario: User has valid address and email
    When random user data is retrieved
    Then user e-mail should be valid
    And user address should be present
    When posts of the user are retrieved
    Then user should have valid posts
    When the user creates following valid post:
      | title | This is a valid post!                                                                                                                                  |
      | body  | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla finibus nulla ut luctus imperdiet. Morbi at augue sed nisl sagittis rutrum sed ac ante. |
    Then post should be posted