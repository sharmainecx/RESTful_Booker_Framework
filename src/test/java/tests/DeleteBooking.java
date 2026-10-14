package tests;

import Context.TestContext;
import constants.Endpoints;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooking extends BasePage{

    @Test
    public void deleteBooking(){

        int id = TestContext.getInstance().getBookingId();
        String token = TestContext.getInstance().getToken();

        given()
                .spec(requestSpec)
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+token)
                .when()
                .delete(Endpoints.DeleteBooking, id)
                .then()
                .statusCode(201);

    }

}
