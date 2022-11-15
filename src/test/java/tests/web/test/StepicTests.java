package tests.web.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.base.TestBase;
import tests.web.data.StepikData;
import tests.web.page.StepikWebPage;

import static com.codeborne.selenide.Selenide.open;

@Tag("Web")
@Tag("All")
@Epic("Stepik")
@Feature("Web tests")
@Owner("Papkatru")
public class StepicTests extends TestBase {
    StepikWebPage stepikPage = new StepikWebPage();
    StepikData stepikData = new StepikData();

    @Test
    @AllureId("12924")
    @DisplayName("Регистрация")
    void registrationTest() {
        open("/");
        stepikPage.registration(stepikData);
    }

    @Test
    @AllureId("12923")
    @DisplayName("Поиск курса")
    void findCourse() {
        open("/");
        stepikPage.findCourse("Вселенная тестирования");
    }

    @Test
    @AllureId("12925")
    @DisplayName("Запись на курс")
    void joinCourse() {
        stepikPage.joinCourse("Вселенная тестирования");
    }
}
