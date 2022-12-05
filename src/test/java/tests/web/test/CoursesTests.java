package tests.web.test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("Web")
@Tag("All")
@Epic("Stepik")
@Feature("Web tests")
@Owner("Papkatru")
public class CoursesTests extends TestBase{

    @Test
    @AllureId("12925")
    @DisplayName("Запись на курс")
    void joinCourseTest() {
        String courseName = "Вселенная тестирования";
        coursesPage.loginByApi();
        open("/");
        catalogPage.findCourse(courseName);
        coursesPage.joinCourse(courseName);
    }
}
