package tests.web.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    public static SelenideElement
            searchInput = $(".navbar__search-input"),
            searchResult = $(".course-cards");

    @Step("Поиск курса")
    public void findCourse(String courseName) {
        searchInput.setValue(courseName).pressEnter();
        searchResult.shouldHave(text(courseName), Duration.ofSeconds(8));
    }
}
