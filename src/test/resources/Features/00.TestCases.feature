Feature: Test Cases

  @TestCase
  Scenario: Test Case 1
    When User sends a valid request to Create-Token API
      | USERNAME | admin       |
      | PASSWORD | password123 |
    And User sends a valid request to Create-Booking API
      | firstName       | William     |
      | lastName        | Shakespeare |
      | totalPrice      | 50          |
      | depositPaid     | true        |
      | checkin         | 2023-07-01  |
      | checkout        | 2023-07-31  |
      | additionalNeeds | Nescafe     |
    And User sends a valid request to Delete-Booking API
    And User sends a valid request to Get BookingByID API
    Then User should receives 404 status code
