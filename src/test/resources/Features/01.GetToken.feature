Feature: User get a token

  Scenario: User successfully obtain a token from get token API
    When User sends a valid request to Create-Token API
      | USERNAME | admin       |
      | PASSWORD | password123 |
    Then User gets a token to use in other APIs