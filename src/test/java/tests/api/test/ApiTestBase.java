package tests.api.test;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.api.page.LoginApi;

public class ApiTestBase {

    LoginApi loginApi = new LoginApi();

    @BeforeAll
    @Step("Установка настроек браузера")
    static void setup() {
        RestAssured.baseURI = "https://stepik.org/api";
    }
}
