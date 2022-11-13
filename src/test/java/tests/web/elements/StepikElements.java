package tests.web.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StepikElements {
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
            stepikSpinner = $(".stepik-loader__message"),
            searchInput = $(".search-form__input"),
            searchResult = $(".course-cards"),
            joinCourseButton = $(".course-promo-enrollment__join-btn"),
            courseHeader = $(".lesson-sidebar__header"),
            catalogButton = $("[data-navbar-item='catalog']");
}
