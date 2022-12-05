package tests.mobile.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {

    public static SelenideElement
            closeOnboarding = $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")),
            closeSignInForm = $(AppiumBy.id("org.stepic.droid:id/dismissButton")),
            searchFilter = $(AppiumBy.id("org.stepic.droid:id/filterIcon")),
            searchLanguageAny = $(AppiumBy.id("org.stepic.droid:id/anyRadioButton")),
            applyFilter = $(AppiumBy.id("org.stepic.droid:id/applyFilterAction")),
            searchInput = $(AppiumBy.id("org.stepic.droid:id/search_src_text"));
    public static ElementsCollection searchResults = $$(AppiumBy.id("org.stepic.droid:id/courseItemName"));

    @Step("Пропуск регистрации")
    public void skipRegistration(){
        closeOnboarding.click();
        closeSignInForm.click();
    }

    @Step("Поиск курса")
    public void findCourse(String courseName){
        searchInput.sendKeys(courseName);
        searchFilter.click();
        searchLanguageAny.click();
        applyFilter.click();
        searchResults.first().shouldHave(text(courseName), Duration.ofSeconds(8));
    }
}
