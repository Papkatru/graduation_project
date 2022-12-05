package tests.api.test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Api")
@Tag("All")
@Epic("Stepik")
@Feature("Api tests")
@Owner("Papkatru")
public class APITests extends ApiTestBase {

    @Test
    @AllureId("12922")
    @DisplayName("Получение токена")
    public void getCookiesWithCSRFToken() {
        loginApi.getCookiesWithCSRFToken();
    }

    @Test
    @AllureId("12920")
    @DisplayName("Регистрация по API")
    public void registration() {
        loginApi.registration();
    }

    @Test
    @AllureId("12921")
    @DisplayName("Логин через API")
    public void login() {
        loginApi.login();
    }
}
