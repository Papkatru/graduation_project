package tests.ui.test;

import org.junit.jupiter.api.Test;
import tests.ui.base.TestBase;
import tests.ui.page.AutomationPracticeUiPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static tests.ui.elements.AutomationPracticeUiElements.accountButton;
import static tests.ui.elements.AutomationPracticeUiElements.failLogonError;

public class AutomationPracticeUiTests extends TestBase {
    AutomationPracticeUiPage automationPracticeUiPage = new AutomationPracticeUiPage();

    @Test
    void loginSuccessTest(){
        open("/");
        automationPracticeUiPage.login("test1234321@mail.ru", "test1234321");
        accountButton.shouldBe(visible); //todo заменить на shouldHave("userName")
    }

    @Test
    void loginFailureTest(){
        open("/");
        automationPracticeUiPage.login("test1234321@mail.ru", "test123432");
        failLogonError.shouldHave(text("Authentication failed"));
    }

    @Test
    void buyGoodsTest(){

    }

    @Test
    void findGoodsTest(){

    }

    @Test
    void editProfileTest(){

    }
}
