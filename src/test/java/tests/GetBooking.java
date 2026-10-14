package tests;

import Context.TestContext;
import constants.Endpoints;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking extends BasePage{

    @Test()
    public void getBooking(){

        int id = TestContext.getInstance().getBookingId();

        given()
                .spec(requestSpec)
                .header("Accept", "application/json")
                .when()
                .get(Endpoints.GetBooking, id)
                .then()
                .statusCode(200);
    }
}
