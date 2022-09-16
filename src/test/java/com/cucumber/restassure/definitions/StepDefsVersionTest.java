package com.cucumber.restassure.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepDefsVersionTest {

    private Response response;
    private Map<Object,Object> map = new HashMap<Object,Object>();
    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        RestAssured.baseURI = "http://localhost:8082";
        RestAssured.basePath = "/version";
    }

    @And("the client receives server version of {double}")
    public void the_client_receives_server_version_body(double version) throws Throwable {
        response = given()
                .contentType(ContentType.TEXT)
                //.body(map)
                .when()
                .get()
                .then()
                .statusCode(200).contentType(ContentType.TEXT).
                extract().response();
        System.out.println("Version: " + response.statusCode());
        System.out.println("Version output: " + response.getStatusLine());
        Assertions.assertThat(response.getBody().asString()).isEqualTo(Double.toString(version));
    }
}