package com.cucumber.restassure.definitions;

import com.cucumber.restassure.CucumberRestassureApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberRestassureApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberGlueTest {

}