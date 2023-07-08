Feature: User gets a list of bookings Ids

  Scenario: User successfully obtain a list of bookings from get bookingsIds API
    When User sends a valid request to Bookings-IDs API
    Then User gets a list of bookings Ids