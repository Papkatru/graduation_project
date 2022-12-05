package tests.web.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.web.data.StepikData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public static SelenideElement
            registrationButton = $(".navbar__auth_reg"),
            fullNameInput = $("[name='full_name']"),
            emailInput = $("[name='email']"),
            passwordInput = $("[name='password']"),
            submitRegistration = $("[type='submit']"),
            profileButton = $(".navbar__profile-img"),
            profileList = $(".menu_right"),
            profileHeader = $(".profile-header-widget__info"),
            coursesHeader = $(".catalog-block__title"),
            stepikSpinner = $(".stepik-loader__message");

    @Step("Регистрация")
    public void registration(StepikData data) {
        registrationButton.click();
        fullNameInput.setValue(data.fullName);
        emailInput.setValue(data.email);
        passwordInput.setValue(data.password);
        submitRegistration.click();
        stepikSpinner.shouldNotBe(visible);
        coursesHeader.shouldBe(visible);
    }

    @Step("Проверка успешной регистрации")
    public void checkRegistration(StepikData data) {
        while (profileList.has(hidden)) {
            profileButton.click();
        }
        profileList.find("[data-qa='menu-item-profile']").click();
        profileHeader.shouldHave(text(data.fullName));
    }
}
