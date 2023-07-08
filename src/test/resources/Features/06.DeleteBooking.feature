Feature: User deletes a Booking

  Scenario: User successfully deletes a booking by its Id
    When User sends a valid request to Delete-Booking API
    Then User should receive 201 status code