package tests;

import Context.TestContext;
import constants.Endpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JSONDataReader;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class CreateBooking extends BasePage {

    @Test()
    public void createBooking() throws IOException {
        Map<String, Object> booking = JSONDataReader.readBooking("payloads/createbooking.json");

        Response response =
        given()
                .spec(requestSpec)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(booking)
                .log().uri()
                .when()
                .post(Endpoints.CreateBooking);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
        Assert.assertNotNull(response.jsonPath().getInt("bookingid"));

        TestContext.getInstance().setBookingId(response.jsonPath().getInt("bookingid"));
    }
}
