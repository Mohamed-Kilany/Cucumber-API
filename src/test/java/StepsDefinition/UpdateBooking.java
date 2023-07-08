package StepsDefinition;

import Models.Booking.Booking;
import Models.Booking.BookingDates;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;
import java.util.Objects;

import static StepsDefinition.CreateBooking.BookingId;
import static StepsDefinition.GetToken.TOKEN;
import static Utils.BaseData.*;
import static Utils.Utils.gson;
import static Utils.Utils.softAssert;
import static io.restassured.RestAssured.given;

public class UpdateBooking {
    Response response;
    BookingDates updatesBookingDate;
    Booking updatesBooking;

    @When("^User sends a valid (.*) request to update Bookings-IDs API$")
    public void valid_UpdateBooking(String method, Map<String, String> requestMap) {
        updatesBookingDate = new BookingDates(requestMap.get("checkin"), requestMap.get("checkout"));
        updatesBooking = new Booking(requestMap.get("firstName"),
                requestMap.get("lastName"),
                requestMap.get("totalPrice"),
                requestMap.get("depositPaid"),
                updatesBookingDate,
                requestMap.get("additionalNeeds"));

        if (Objects.equals(method, "PUT")) {
            response = given().
                    header("Cookie", TOKEN).
                    relaxedHTTPSValidation().
                    contentType(Application_Json).
                    pathParam(ID, BookingId).
                    body(updatesBooking).
                    when().put(BASE_URL + Bookings_Base + By_ID);
        } else if (Objects.equals(method, "PATCH")) {
            response = given().
                    header("Cookie", TOKEN).
                    relaxedHTTPSValidation().
                    contentType(Application_Json).
                    pathParam(ID, BookingId).
                    body(updatesBooking).
                    when().patch(BASE_URL + Bookings_Base + By_ID);
        }
    }


    @Then("User gets his booking updated")
    public void assert_BookingUpdated() {
        Booking booking = gson.fromJson(response.asPrettyString(), Booking.class);
        if (updatesBooking.getFirstname() != null) {
            softAssert.assertEquals(updatesBooking.getFirstname(), booking.getFirstname(), "fn");
        }
        if (updatesBooking.getLastname() != null) {
            softAssert.assertEquals(updatesBooking.getLastname(), booking.getLastname(), "ln");
        }
        if (updatesBooking.getTotalprice() != null) {
            softAssert.assertEquals(updatesBooking.getTotalprice(), booking.getTotalprice(), "tp");
        }
        if (updatesBooking.getDepositpaid() != null) {
            softAssert.assertEquals(updatesBooking.getDepositpaid(), booking.getDepositpaid(), "dp");
        }
        if (updatesBooking.getBookingdates().getCheckin() != null) {
            softAssert.assertEquals(updatesBooking.getBookingdates().getCheckin(), booking.getBookingdates().getCheckin(), "ci");
        }
        if (updatesBooking.getBookingdates().getCheckout() != null) {
            softAssert.assertEquals(updatesBooking.getBookingdates().getCheckout(), booking.getBookingdates().getCheckout(), "co");
        }
        if (updatesBooking.getAdditionalneeds() != null) {
            softAssert.assertEquals(updatesBooking.getAdditionalneeds(), booking.getAdditionalneeds(), "an");
        }
        softAssert.assertAll();
    }
}
