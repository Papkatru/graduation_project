package tests.api.base;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    @BeforeAll
    @Step("Установка настроек браузера")
    static void setup() {
        RestAssured.baseURI = "https://stepik.org/api";
    }
}
