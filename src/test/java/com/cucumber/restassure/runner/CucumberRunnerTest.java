package com.cucumber.restassure.runner;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty",
        "html:target/cucumber-report.html", "json:target/cucumber-report.json"},
        glue = {"com.cucumber.restassure.definitions"})
//, tags = "(@Test1 or @Test2 or @Test4) and not @Test3")
public class CucumberRunnerTest {
}