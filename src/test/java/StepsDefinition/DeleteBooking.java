package StepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static StepsDefinition.CreateBooking.BookingId;
import static StepsDefinition.GetToken.TOKEN;
import static Utils.BaseData.*;
import static Utils.Utils.softAssert;
import static io.restassured.RestAssured.given;

public class DeleteBooking {

    Response response;

    @When("User sends a valid request to Delete-Booking API")
    public void valid_DeleteBooking() {
        response = given().
                header("Cookie", TOKEN).
                relaxedHTTPSValidation().
                contentType(Application_Json).
                pathParam(ID, BookingId).
                when().delete(BASE_URL + Bookings_Base + By_ID);
    }


    @Then("^User should receive (.*) status code$")
    public void assert_DeleteBooking(String statusCode) {
        softAssert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode));
    }
}