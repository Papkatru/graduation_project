package tests.mobile.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CoursesPage {

    CatalogPage catalogPage = new CatalogPage();

    public static SelenideElement
            catalogIcon = $(AppiumBy.id("org.stepic.droid:id/catalog")),
            laterButton = $(AppiumBy.id("android:id/button2")),
            joinCourse = $(AppiumBy.id("org.stepic.droid:id/courseEnrollAction")),
            courseTitle = $(AppiumBy.id("org.stepic.droid:id/centeredToolbarTitle"));
    public static ElementsCollection searchResults = $$(AppiumBy.id("org.stepic.droid:id/courseItemName"));

    @Step("Запись на курс")
    public void joinCourse(String courseName, String expectedCourseContent){
        laterButton.click();
        catalogIcon.click();
        catalogPage.findCourse(courseName);
        searchResults.first().click();
        joinCourse.click();
        courseTitle.shouldHave(text(expectedCourseContent), Duration.ofSeconds(8));
    }
}
