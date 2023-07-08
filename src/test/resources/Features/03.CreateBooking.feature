Feature: User can create a booking

  Scenario: User can create a booking with valid inputs
    When User sends a valid request to Create-Booking API
      | firstName       | William     |
      | lastName        | Shakespeare |
      | totalPrice      | 50          |
      | depositPaid     | true        |
      | checkin         | 2023-07-01  |
      | checkout        | 2023-07-31  |
      | additionalNeeds | Nescafe     |
    Then User should receive the Booking ID along with the sent request