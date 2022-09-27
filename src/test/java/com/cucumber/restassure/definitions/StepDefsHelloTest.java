package com.cucumber.restassure.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepDefsHelloTest {

    private Response response;
    private Map<Object,Object> map = new HashMap<Object,Object>();

    @When("the client calls \\/baeldung")
    public void the_client_calls_baeldung() {
        RestAssured.baseURI = "http://localhost:8082";
        RestAssured.basePath = "/baeldung";
    }

    @Then("the baeldung client receives status code of {int}")
    public void the_baeldung_client_receives_status_code_of(Integer int1, String docString) {
        response = given()
                .contentType(ContentType.TEXT)
                //.body(map)
                .when()
                .get();
//                .then()
//                .statusCode(200).contentType(ContentType.TEXT).
//                .extract().response();
        System.out.println("Baeldung: " + response.statusCode());
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }

    @Then("the client receives server version baeldung")
    public void the_client_receives_server_baeldung() {
        Address address = new Address();
        address.setDoorNo("169");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setPincode(560077L);
        ResponseBody responseBody = response.getBody();
        Address res = responseBody.as(Address.class);
        System.out.println("BaeldungVersion: " + res);
        Assertions.assertThat(res.toString()).isEqualTo(address.toString());
    }

    @Given("the client calls \\/hello")
    public void the_client_calls_hello() {
        RestAssured.baseURI = "http://localhost:8082";
        RestAssured.basePath = "/hello";
    }

    @When("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer int1) {
        response = given()
                .contentType(ContentType.TEXT)
                //.body(map)
                .when()
                .get()
                .then()
//                .statusCode(200).contentType(ContentType.TEXT).
                .extract().response();
        System.out.println("Hello: " + response.statusCode());
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }

    @Then("the client receives hello version hello")
    public void the_client_receives_server_hello() {
        System.out.println("HelloVersion: " + response.getBody().asString());
        Assertions.assertThat(response.getBody().asString()).isEqualTo("hello");
    }

}