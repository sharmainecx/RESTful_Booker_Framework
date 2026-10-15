package tests;

import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class BasePage {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void baseSetup(){
        RestAssured.baseURI = ConfigReader.getBaseUrl();

        requestSpec = new RequestSpecBuilder()
//                .setContentType(ContentType.JSON)
                .build();
    }
}
