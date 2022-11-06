package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeUiElements {
    public static SelenideElement
            signInButton = $(".login"),
            emailInput = $("#email"),
            passwordInput = $("#passwd"),
    submitLogin = $("#SubmitLogin"),
    accountButton = $(".account"),
    failLogonError = $(".alert");
}
