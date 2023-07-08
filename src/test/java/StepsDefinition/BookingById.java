package StepsDefinition;

import Models.Booking.Booking;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static StepsDefinition.CreateBooking.BookingId;
import static StepsDefinition.CreateBooking.RequestBooking;
import static StepsDefinition.GetToken.TOKEN;
import static Utils.BaseData.*;
import static Utils.Utils.gson;
import static Utils.Utils.softAssert;
import static io.restassured.RestAssured.given;

public class BookingById {

    Response response;

    @When("User sends a valid request to Get BookingByID API")
    public void valid_GET_BookingByID() {
        response = given().
                header("Cookie", TOKEN).
                relaxedHTTPSValidation().
                pathParam(ID, BookingId).
                when().get(BASE_URL + Bookings_Base + By_ID);
    }

    @Then("User gets the requested Booking")
    public void assert_BookingRetrieved() {
        Booking booking = gson.fromJson(String.valueOf(response.asPrettyString()), Booking.class);
        softAssert.assertEquals(RequestBooking.getFirstname(), booking.getFirstname());
        softAssert.assertEquals(RequestBooking.getLastname(), booking.getLastname());
        softAssert.assertEquals(RequestBooking.getTotalprice(), booking.getTotalprice());
        softAssert.assertEquals(RequestBooking.getDepositpaid(), booking.getDepositpaid());
        softAssert.assertEquals(RequestBooking.getBookingdates().getCheckin(), booking.getBookingdates().getCheckin());
        softAssert.assertEquals(RequestBooking.getBookingdates().getCheckout(), booking.getBookingdates().getCheckout());
        softAssert.assertEquals(RequestBooking.getAdditionalneeds(), booking.getAdditionalneeds());
        softAssert.assertAll();
    }

    @Then("User should receives 404 status code")
    public void assert_BookingNotFound() {
        softAssert.assertEquals(response.getStatusCode(), 404);
    }
}

