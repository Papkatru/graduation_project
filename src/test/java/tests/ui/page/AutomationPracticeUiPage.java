package tests.ui.page;

import io.qameta.allure.Step;

import static tests.ui.elements.AutomationPracticeUiElements.*;

public class AutomationPracticeUiPage {

    @Step("Логин")
    public void login(String email, String password){
        signInButton.click();
        emailInput.setValue(email);
        passwordInput.setValue(password);
        submitLogin.click();
    }

    @Step("Поиск товара")
    public void searchGoods(String goods){

    }
}
