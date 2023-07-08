package StepsDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.ArrayList;

import static StepsDefinition.GetToken.TOKEN;
import static Utils.BaseData.BASE_URL;
import static Utils.BaseData.Bookings_Base;
import static Utils.Utils.softAssert;
import static io.restassured.RestAssured.given;

public class BookingsList {
    Response response;
    ArrayList<Integer> ids;

    @When("User sends a valid request to Bookings-IDs API")
    public void valid_POST_CreateToken() {
        response = given().
                header("Cookie", TOKEN).
                relaxedHTTPSValidation().
                when().get(BASE_URL + Bookings_Base);
        ids = response.path("bookingid");
    }

    @Then("User gets a list of bookings Ids")
    public void assert_BookingList() {
        for (int id : ids) {
            softAssert.assertNotEquals(id, null);
        }
        softAssert.assertAll();
    }
}
