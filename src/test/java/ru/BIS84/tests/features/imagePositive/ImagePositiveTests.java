package ru.BIS84.tests.features.imagePositive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.BIS84.tests.base.BaseTest;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ImagePositiveTests extends BaseTest {
    String imageDeleteHash;

    @Test
    @DisplayName("Проверка, что маленькая картинка 1px.bmp загружается")
    void uploadImageFileTest1pxBmp() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/1px/1px.bmp"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    @DisplayName("Проверка, что маленькая картинка 1px.jpg загружается")
    void uploadImageFileTest1pxJpg() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/1px/1px.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test@DisplayName("Проверка, что маленькая картинка 1px.png загружается")
    void uploadImageFileTest1pxPng() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/1px/1px.png"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    @DisplayName("Проверка, что маленькая картинка 1px.tif загружается")
    void uploadImageFileTest1pxTif() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/1px/1px.tif"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    @DisplayName("Проверка, что нормальная картинка HD.bmp загружается")
    void uploadImageFileTestHdBmp() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/HD/HD.bmp"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    @DisplayName("Проверка, что нормальная картинка HD.jpg загружается")
    void uploadImageFileTestHdJpg() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/HD/HD.jpg"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    @DisplayName("Проверка, что нормальная картинка HD.png загружается")
    void uploadImageFileTestHdPng() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/HD/HD.png"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    @DisplayName("Проверка, что нормальная картинка HD.tif загружается")
    void uploadImageFileTestHdTif() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/HD/HD.tif"))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @AfterEach
    void tearDown() {

        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .then()
                .statusCode(200);
    }

}