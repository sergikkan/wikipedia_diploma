package org.skan.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends MainPage{

    private SelenideElement loginButton =$("#pt-login a"),
            loginInput = $("#wpName1"),
            passInput = $("#wpPassword1"),
            confirmButton = $("#wpLoginAttempt"),
            spanWithLogin = $("#pt-userpage span"),
            userPageSpan = $("#pt-userpage span"),
            preferencesButton = $("#pt-preferences a");



    @Step("Нажать на кнопку Войти")
    public LoginPage openLoginPage(){
        loginButton.click();
        return this;
    }

    @Step("Ввести логин")
    public LoginPage setLogin(String login){
        loginInput.setValue(login);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String pass){
        passInput.setValue(pass);
        confirmButton.click();
        return this;
    }

    @Step("Проверить что авторизация прошла успешно")
    public LoginPage checkThatLoginSuccess(String login){
       spanWithLogin.shouldHave(text(login));
        return this;
    }

    @Step("Открыть страницу пользователя")
    public LoginPage openUserPage(){
        userPageSpan.click();
        return this;
    }

    @Step("Проверить что страница пользователя открылась")
    public LoginPage checkThatUserPageOpened(String login) {
        h1FirstHeading.shouldHave(text("Здравствуйте, \u202A"+login+"\u202C!"));
        return this;
    }

    @Step("Открыть страницу настройки")
    public LoginPage openSettings(){
        preferencesButton.click();

        return this;
    }

    @Step("Проверить что страница настройки открылась")
    public LoginPage checkThatSettingsOpened() {
        h1FirstHeading.shouldHave(text("Настройки"));
        return this;
    }
}
