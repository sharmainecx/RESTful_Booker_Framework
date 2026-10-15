package tests;

import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.XMLDataReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateBookingXML extends BasePage {


    @DataProvider(name = "bookings")
    public Object[][] bookings() throws IOException {
        List<Map<String, Object>> list = XMLDataReader.readBookings("payloads/createbooking.xml");

        Object[][]data = new Object[list.size()][1];
        for(int i = 0; i<list.size(); i++)
        {
            data[i][0] = list.get(i);
        }
        return data;
    }


    @Test(dataProvider = "bookings")
    public void createBooking(Map<String, Object> booking)throws IOException{
        String xml = XMLDataReader.toXml("booking", booking);

//        Response response =
                given()
                        .spec(requestSpec)
                        .config(RestAssured.config().encoderConfig(
                                EncoderConfig.encoderConfig()
                                        .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                        .header("Content-Type", "text/xml")
                        .header("Accept", "application/xml")
                        .body(xml.getBytes(StandardCharsets.UTF_8))
                        .log().all()
                        .when()
                        .post(Endpoints.CreateBooking)
                        .then()
                        .statusCode(200);

    }
}
