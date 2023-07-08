package Models.Booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Booking {
    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
