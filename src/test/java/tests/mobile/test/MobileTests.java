package tests.mobile.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.data.StepikData;

@Tag("Mobile")
@Tag("All")
@Epic("Stepik")
@Feature("Mobile tests")
@Owner("Papkatru")
public class MobileTests extends TestBase {

    @Test
    @DisplayName("Регистрация в мобильном приложении")
    void mobileRegistrationTest() {
        StepikData data = new StepikData();
        registrationPage.goToRegistration();
        registrationPage.fillRegistrationForm(data.firstName, data.email, data.password);
        registrationPage.checkRegistration(data.firstName);
    }

    @Test
    @DisplayName("Поиск курса в мобильном приложении")
    void mobileSearchTest() {
        catalogPage.skipRegistration();
        catalogPage.findCourse("Вселенная тестирования");
    }

    @Test
    @DisplayName("Запись на курс в мобильном приложении")
    void mobileJoinCourseTest() {
        StepikData data = new StepikData();
        registrationPage.goToRegistration();
        registrationPage.fillRegistrationForm(data.firstName, data.email, data.password);
        coursesPage.joinCourse("Вселенная тестирования", "1.1 Давай знакомиться!");
    }
}
