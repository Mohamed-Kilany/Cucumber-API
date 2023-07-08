package StepsDefinition;

import Models.GetToken.UserCredentials;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

import static Utils.BaseData.*;
import static Utils.Utils.gson;
import static Utils.Utils.softAssert;
import static io.restassured.RestAssured.given;

public class GetToken {
    public static String TOKEN;
    Response response;

    private String requestBody(String username, String password) {
        UserCredentials userCredentials = new UserCredentials(username, password);
        return gson.toJson(userCredentials);
    }

    @When("User sends a valid request to Create-Token API")
    public void valid_POST_CreateToken(Map<String, String> credentials) {
        response = given().
                relaxedHTTPSValidation().
                contentType(Application_Json).
                body(requestBody(credentials.get("USERNAME"), credentials.get("PASSWORD"))).
                when().post(BASE_URL + Auth_Base);
        TOKEN = "token=" + response.path("token");
    }

    @Then("User gets a token to use in other APIs")
    public void assert_Token() {
        softAssert.assertNotNull(TOKEN);
        softAssert.assertAll();
    }
}


