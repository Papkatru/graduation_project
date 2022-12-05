package tests.web.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import tests.api.page.LoginApi;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CoursesPage {

    LoginApi loginApi = new LoginApi();

    public static SelenideElement
            searchResult = $(".course-cards"),
            joinCourseButton = $(".course-promo-enrollment__join-btn"),
            courseHeader = $(".lesson-sidebar__header");

    @Step("Запись на курс")
    public void joinCourse(String courseName) {
        searchResult.findAll(".course-cards__item").findBy(new Text(courseName)).click();
        joinCourseButton.click();
        courseHeader.shouldHave(text(courseName));
    }

    @Step("Логин по api")
    public void loginByApi() {
        open("/static/frontend/organizations/vk.svg");
        String sessionIdFromResponse = loginApi.login();
        Cookie sessionId = new Cookie("sessionid", sessionIdFromResponse);
        WebDriverRunner.getWebDriver().manage().addCookie(sessionId);
        open("/");
        $("[alt='User avatar']").shouldHave(visible);
    }
}
