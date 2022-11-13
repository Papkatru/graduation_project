package tests.api.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.base.ApiTestBase;
import tests.api.page.StepikApiPage;

@Tag("API")
@Epic("Stepik")
@Owner("Papkatru")
public class StepikTests extends ApiTestBase {

    StepikApiPage stepikPage = new StepikApiPage();

    @Test
    @DisplayName("Получение токена")
    public void getCSRFToken() {
        stepikPage.getCSRFToken();
    }

    @Test
    @DisplayName("Регистрация")
    public void registration() {
        stepikPage.registration();
    }

    @Test
    @DisplayName("Логин")
    public void login() {
        stepikPage.login();
    }
}
