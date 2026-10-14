package tests;

import Context.TestContext;
import constants.Endpoints;
import org.testng.annotations.Test;
import utils.JSONDataReader;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends BasePage {

    @Test()
    public void updateBooking() throws IOException {

        String cookie = TestContext.getInstance().getToken();
        int id = TestContext.getInstance().getBookingId();

        Map<String, Object> data = JSONDataReader.readBooking("payloads/updatebooking.json");

        given()
                .spec(requestSpec)
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+cookie)
                .body(data)
                .when()
                .put(Endpoints.UpdateBooking, id)
                .then()
                .statusCode(200);
    }
}
