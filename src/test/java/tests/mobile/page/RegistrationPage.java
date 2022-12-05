package tests.mobile.page;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public static SelenideElement
            closeOnboarding = $(AppiumBy.id("org.stepic.droid:id/closeOnboarding")),
            signUpButton = $(AppiumBy.id("org.stepic.droid:id/launchSignUpButton")),
            firstNameInput = $(AppiumBy.id("org.stepic.droid:id/firstNameField")),
            emailInput = $(AppiumBy.id("org.stepic.droid:id/emailField")),
            passwordInput = $(AppiumBy.id("org.stepic.droid:id/passwordField")),
            submitSignUp = $(AppiumBy.id("org.stepic.droid:id/signUpButton")),
            laterButton = $(AppiumBy.id("android:id/button2")),
            profileIcon = $(AppiumBy.id("org.stepic.droid:id/profile")),
            profileName = $(AppiumBy.id("org.stepic.droid:id/profileName"));

    @Step("Переход к окну регистрации")
    public void goToRegistration(){
        closeOnboarding.click();
        signUpButton.click();
    }

    @Step("Заполнение формы и регистрация")
    public void fillRegistrationForm(String firstName, String email, String password){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
        emailInput.click();
        emailInput.sendKeys(email);
        passwordInput.click();
        passwordInput.sendKeys(password);
        submitSignUp.click();
    }

    @Step("Проверка успешной регистрации")
    public void checkRegistration(String firstName){
        laterButton.click();
        profileIcon.click();
        profileName.shouldHave(text(firstName));
    }
}
