package tests.api.page;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import tests.api.models.Login;
import tests.api.models.Profile;
import tests.api.models.User;
import tests.api.models.Users;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static tests.api.specs.Specs.*;

public class LoginApi {

    @Step("Получение csrf токена")
    public Map<String, String> getCookiesWithCSRFToken() {
        Map<String, String> csrfToken =
                given()
                        .with().spec(request)
                        .when()
                        .get("/visited-courses")
                        .then()
                        .spec(response)
                        .extract().cookies();
        assertFalse(csrfToken.get("csrftoken").isEmpty());
        return csrfToken;
    }

    @Step("Регистрация нового пользователя")
    public Profile registration() {
        Profile profile = new Profile();
        profile.setFirstName(new Faker().name().firstName());
        profile.setLastName(new Faker().name().lastName());
        profile.setEmail(new Faker().internet().emailAddress());
        profile.setPassword(new Faker().internet().password());
        String fullName = profile.getFirstName() + " " + profile.getLastName();
        User user = new User();
        user.setUser(profile);
        Map<String, String> cookies = getCookiesWithCSRFToken();
        Users response = given()
                .with().spec(request)
                .header("Referer", "https://stepik.org/catalog/search?auth=registration")
                .header("X-CSRFToken", cookies.get("csrftoken"))
                .cookie("sessionid", cookies.get("sessionid"))
                .cookie("csrftoken", cookies.get("csrftoken"))
                .body(user)
                .when()
                .post("/users")
                .then()
                .spec(registrationResponse)
                .extract().as(Users.class);
        assertThat(response.getUsers()[0].getFullName()).contains(fullName);
        return profile;
    }

    @Step("Логин")
    public String login() {
        Profile profile = registration();
        Login login = Login.builder().email(profile.getEmail())
                .password(profile.getPassword()).build();
        Map<String, String> cookies = getCookiesWithCSRFToken();
        String sessionId =
                given()
                        .with().spec(request)
                        .header("Referer", "https://stepik.org/catalog/search?auth=login")
                        .header("X-CSRFToken", cookies.get("csrftoken"))
                        .cookie("sessionid", cookies.get("sessionid"))
                        .cookie("csrftoken", cookies.get("csrftoken"))
                        .body(login)
                        .when()
                        .post("/users/login")
                        .then()
                        .spec(loginResponse)
                        .extract().header("Set-Cookie");
        String[] stringToArray = sessionId.split("[;,\\[\\]=]");
        return stringToArray[1];
    }
}
