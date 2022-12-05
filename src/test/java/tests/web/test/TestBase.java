package tests.web.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.ConfigProvider;
import tests.web.data.StepikData;
import tests.web.page.CatalogPage;
import tests.web.page.CoursesPage;
import tests.web.page.RegistrationPage;

import static helpers.Attachments.*;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CatalogPage catalogPage = new CatalogPage();
    CoursesPage coursesPage = new CoursesPage();
    StepikData stepikData = new StepikData();

    public static void setConfiguration() {
        Configuration.remote = ConfigProvider.config.getRemoteUrl();
        Configuration.browser = ConfigProvider.config.getBrowserName();
        Configuration.browserVersion = ConfigProvider.config.getBrowserVersion();
        Configuration.browserSize = ConfigProvider.config.getBrowserSize();
        Configuration.browserPosition = ConfigProvider.config.getBrowserPosition();
        Configuration.baseUrl = ConfigProvider.config.getBaseUrl();
        RestAssured.baseURI = ConfigProvider.config.getBaseURI();
    }


    @BeforeAll
    @Step("Установка настроек браузера")
    static void setup() {
        SelenideLogger.addListener("allureTest", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        setConfiguration();
    }

    @AfterEach
    @Step("Получить аттачменты")
    void getAttachments() {
        takeScreenshot();
        addSource();
        addHTMLSource();
        addBrowserConsoleLog();
        addVideo();
        WebDriverRunner.driver().close();
    }
}
