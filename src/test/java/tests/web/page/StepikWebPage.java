package tests.web.page;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import tests.api.page.StepikApiPage;
import tests.web.data.StepikData;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static tests.web.elements.StepikElements.*;

public class StepikWebPage {

    StepikApiPage stepikApiPage = new StepikApiPage();

    @Step("Регистрация")
    public void registration(StepikData data) {
        registrationButton.click();
        fullNameInput.setValue(data.fullName);
        emailInput.setValue(data.email);
        passwordInput.setValue(data.password);
        submitRegistration.click();
        stepikSpinner.shouldNotHave(visible);
        sleep(2000);
        checkRegistration(data);
    }

    @Step("Проверка успешной регистрации")
    public void checkRegistration(StepikData data) {
        profileButton.click();
        profileList.find(new ByText("Профиль")).click();
        profileHeader.shouldHave(text(data.fullName));
    }

    @Step("Поиск курса")
    public void findCourse(String courseName) {
        searchInput.setValue(courseName).pressEnter();
        searchResult.shouldHave(text(courseName));
    }

    @Step("Запись на курс")
    public void joinCourse(String courseName) {
        loginByApi();
        catalogButton.click();
        findCourse(courseName);
        searchResult.findAll(".course-cards__item").findBy(new Text(courseName)).click();
        joinCourseButton.click();
        courseHeader.shouldHave(text(courseName));
    }

    @Step("Логин по api")
    public void loginByApi(){
        open("/static/frontend/organizations/vk.svg");
        String sessionIdFromResponse = stepikApiPage.login();
        Cookie sessionId = new Cookie("sessionid", sessionIdFromResponse);
        WebDriverRunner.getWebDriver().manage().addCookie(sessionId);
        open("/");
        $("[alt='User avatar']").shouldHave(visible);
    }
}
