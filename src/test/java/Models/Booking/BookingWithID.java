package Models.Booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BookingWithID {
    private String bookingid;
    private Booking booking;
}
