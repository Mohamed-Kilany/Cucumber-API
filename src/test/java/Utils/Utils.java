package Utils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.asserts.SoftAssert;

public class Utils {
    public static Gson gson = new Gson();
    public static SoftAssert softAssert = new SoftAssert();

    public static Faker faker = new Faker();
}
