package tests.mobile.test;

import com.codeborne.selenide.Configuration;
import tests.mobile.drivers.BrowserstackMobileDriver;
import tests.mobile.drivers.LocalMobileDriver;
import tests.mobile.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.mobile.page.CatalogPage;
import tests.mobile.page.CoursesPage;
import tests.mobile.page.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CatalogPage catalogPage = new CatalogPage();
    CoursesPage coursesPage = new CoursesPage();

    @BeforeAll
    public static void setup() throws Exception {
        String host = System.getProperty("env");
        Configuration.browserSize = null;
        switch (host) {
            case "remote":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                throw new Exception("Wrong env");
        }
    }

    @BeforeEach
    public final void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public final void afterEach() {
        if (System.getProperty("env").equals("remote")) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            String sessionId = sessionId().toString();
            closeWebDriver();
            Attach.video(sessionId);
        } else {
            closeWebDriver();
        }
    }
}
