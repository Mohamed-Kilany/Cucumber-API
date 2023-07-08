Feature: User updates a booking

  Scenario: User should be able to update a booking via PUT request
    When User sends a valid PUT request to update Bookings-IDs API
      | firstName       | William     |
      | lastName        | Shakespeare |
      | totalPrice      | 70          |
      | depositPaid     | true        |
      | checkin         | 2023-07-01  |
      | checkout        | 2023-08-31  |
      | additionalNeeds | Coffee      |
    Then User gets his booking updated


  Scenario: User should be able to update a booking via PATCH request
    When User sends a valid PATCH request to update Bookings-IDs API
      | totalPrice      | 100        |
      | checkin         | 2023-07-01 |
      | checkout        | 2023-09-30 |
      | additionalNeeds | Coffee     |
    Then User gets his booking updated