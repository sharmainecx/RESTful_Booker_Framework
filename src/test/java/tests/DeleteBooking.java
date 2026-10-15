package tests;

import Context.TestContext;
import constants.Endpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooking extends BasePage{

    @Test
    public void deleteBooking(){

        int id = TestContext.getInstance().getBookingId();
        String token = TestContext.getInstance().getToken();

        Response response =
        given()
                .spec(requestSpec)
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+token)
                .header("Accept", "application/json")
                .when()
                .delete(Endpoints.DeleteBooking, id);

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getBody().asString(), "Created");
    }

}
