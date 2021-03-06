package ru.BIS84.tests.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {
    protected static Properties properties;
    protected static String host;
    protected static String username;
    protected static String token;
    protected static String activeEmails;
    protected static String errorText;

    @BeforeAll
    static void beforeAll() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/application.properties"));
        host = properties.getProperty("host", "https://api.imgur.com/3/");
        username = properties.getProperty("username");
        token = properties.getProperty("auth.token");
        activeEmails = properties.getProperty("active.emails");
        errorText = properties.getProperty("errorText");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = host;
    }
}