package tests;

import Context.TestContext;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Login extends BasePage{

    @Test
    public void authLogin()
    {
        Map<String, String> hm = new HashMap<>();
        hm.put("username", ConfigReader.getUsername());
        hm.put("password", ConfigReader.getPassword());

        Response response = given()
                .spec(requestSpec)
                .header("Content-Type", "application/json")
                .body(hm)
                .log().uri()
                .when()
                .post(Endpoints.Login);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");

        TestContext.getInstance().setToken(response.jsonPath().getString("token"));
    }
}
