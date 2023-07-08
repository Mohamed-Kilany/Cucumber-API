package StepsDefinition;

import Models.Booking.Booking;
import Models.Booking.BookingDates;
import Models.Booking.BookingWithID;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

import static StepsDefinition.GetToken.TOKEN;
import static Utils.BaseData.*;
import static Utils.Utils.gson;
import static Utils.Utils.softAssert;
import static io.restassured.RestAssured.given;

public class CreateBooking {

    public static int BookingId;
    public static Booking RequestBooking;
    public static BookingDates RequestBookingDates;
    Response response;

    @When("User sends a valid request to Create-Booking API")
    public void valid_POST_CreateBooking(Map<String, String> requestMap) {
        RequestBookingDates = new BookingDates(requestMap.get("checkin"), requestMap.get("checkout"));
        RequestBooking = new Booking(requestMap.get("firstName"),
                requestMap.get("lastName"),
                requestMap.get("totalPrice"),
                requestMap.get("depositPaid"),
                RequestBookingDates,
                requestMap.get("additionalNeeds"));

        response = given().
                header("Cookie", TOKEN).
                relaxedHTTPSValidation().
                contentType(Application_Json).
                body(RequestBooking).
                when().post(BASE_URL + Bookings_Base);
        BookingId = response.path("bookingid");
    }

    @Then("User should receive the Booking ID along with the sent request")
    public void assert_CreateBooking() {
        BookingWithID bookingWithID = gson.fromJson(response.asPrettyString(), BookingWithID.class);
        softAssert.assertNotNull(bookingWithID.getBookingid());
        softAssert.assertEquals(RequestBooking.getFirstname(), bookingWithID.getBooking().getFirstname());
        softAssert.assertEquals(RequestBooking.getLastname(), bookingWithID.getBooking().getLastname());
        softAssert.assertEquals(RequestBooking.getTotalprice(), bookingWithID.getBooking().getTotalprice());
        softAssert.assertEquals(RequestBooking.getDepositpaid(), bookingWithID.getBooking().getDepositpaid());
        softAssert.assertEquals(RequestBooking.getBookingdates().getCheckin(), bookingWithID.getBooking().getBookingdates().getCheckin());
        softAssert.assertEquals(RequestBooking.getBookingdates().getCheckout(), bookingWithID.getBooking().getBookingdates().getCheckout());
        softAssert.assertEquals(RequestBooking.getAdditionalneeds(), bookingWithID.getBooking().getAdditionalneeds());
        softAssert.assertAll();
    }
}
