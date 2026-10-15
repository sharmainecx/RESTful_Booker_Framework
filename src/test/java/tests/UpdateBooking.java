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

public class UpdateBooking extends BasePage {

    @Test()
    public void updateBooking() throws IOException {

        String cookie = TestContext.getInstance().getToken();
        int id = TestContext.getInstance().getBookingId();

        Map<String, Object> data = JSONDataReader.readBooking("payloads/updatebooking.json");

        Response response =
        given()
                .spec(requestSpec)
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+cookie)
                .body(data)
                .when()
                .put(Endpoints.UpdateBooking, id);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getHeaders().hasHeaderWithName("Content-Type"));
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
        Assert.assertEquals(response.jsonPath().getString("bookingid"), data.get("bookingid"));
        Assert.assertEquals(response.jsonPath().getString("checkin"), data.get("checkin"));
    }
}
