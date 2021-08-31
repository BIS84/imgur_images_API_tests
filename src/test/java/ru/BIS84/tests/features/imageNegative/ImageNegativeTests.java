package ru.BIS84.tests.features.imageNegative;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.BIS84.tests.base.BaseTest;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ImageNegativeTests extends BaseTest {

    @Test
    @DisplayName("Проверка, что большая картинка .bmp не загружается")
    void uploadImageFileTestBigBmp() {

        given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/big/big.bmp"))
                .expect()
                .statusCode(400)
                .body("data.error", equalTo(errorText))
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath();

    }

    @Test
    @DisplayName("Проверка, что большая картинка .jpg не загружается")
    void uploadImageFileTestBigJpg() {

        given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/big/big.jpg"))
                .expect()
                .statusCode(400)
                .body("data.error", equalTo(errorText))
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath();

    }

    @Test
    @DisplayName("Проверка, что большая картинка .png не загружается")
    void uploadImageFileTestBigPng() {

        given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/big/big.png"))
                .expect()
                .statusCode(400)
                .body("data.error", equalTo(errorText))
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath();

    }

    @Test
    @DisplayName("Проверка, что большая картинка .tif не загружается")
    void uploadImageFileTestBigTif() {

        given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/big/big.tif"))
                .expect()
                .statusCode(400)
                .body("data.error", equalTo(errorText))
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath();

    }
}