Feature: User gets a booking by Id

  Scenario: User successfully retrieves a booking by its Id from get bookingById API
    When User sends a valid request to Get BookingByID API
    Then User gets the requested Booking
