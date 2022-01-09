package ru.BIS84.tests.features.account;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.BIS84.tests.base.BaseTest;

import static io.restassured.RestAssured.given;

public class AccountTests extends BaseTest {

    @Test
    @DisplayName("Проверка, что имя пользователя правильное")
    void getAccountPositiveTest() {
        given()
                .header("Authorization", token)
                .log()
                .ifValidationFails()
                .when()
                .get("account/{username}", username)
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("data.url", CoreMatchers.equalTo(username));
    }

    @Test
    @DisplayName("Проверка, что Email правильный")
    void getAccountSettingsTest() {
        given()
                .header("Authorization", token)
                .when()
                .get("account/{username}/settings", username)
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("success", CoreMatchers.is(true))
                .body("data.account_url", CoreMatchers.equalTo(username))
                .body("data.active_emails[0]", CoreMatchers.equalTo(activeEmails));
    }

}