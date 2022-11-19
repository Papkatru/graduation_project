package tests.mobile.test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.mobile.base.TestBase;
import tests.mobile.page.StepikMobilePage;
import tests.web.data.StepikData;

@Tag("Mobile")
@Tag("All")
@Epic("Stepik")
@Feature("Mobile tests")
@Owner("Papkatru")
public class StepikTests extends TestBase {

    StepikMobilePage mobilePage = new StepikMobilePage();

    @Test
    @DisplayName("Регистрация в мобильном приложении")
    void mobileRegistrationTest() {
        StepikData data = new StepikData();
        mobilePage.goToRegistration();
        mobilePage.fillRegistrationForm(data);
        mobilePage.checkRegistration(data);
    }

    @Test
    @DisplayName("Поиск курса в мобильном приложении")
    void mobileSearchTest() {
        mobilePage.skipRegistration();
        mobilePage.findCourse("Вселенная тестирования");
    }

    @Test
    @DisplayName("Запись на курс в мобильном приложении")
    void mobileJoinCourseTest() {
        StepikData data = new StepikData();
        mobilePage.goToRegistration();
        mobilePage.fillRegistrationForm(data);
        mobilePage.joinCourse("Вселенная тестирования", "1.1 Давай знакомиться!");
    }
}
