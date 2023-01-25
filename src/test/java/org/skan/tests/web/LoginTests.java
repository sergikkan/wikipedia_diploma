package org.skan.tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("WEB")
@Tag("ALL")
public class LoginTests extends BaseTest {
    @Test
    void loginTest(){
        mainPage.openMainPage();
        logIn.openLoginPage()
                .setLogin(userName)
                .setPassword(password)
                .checkThatLoginSuccess(userName);
    }

    @Test
    void openUserHomepageTest(){
        mainPage.openMainPage();
        logIn.openLoginPage()
                .setLogin(userName)
                .setPassword(password)
                .checkThatLoginSuccess(userName)
                .openUserPage()
                .checkThatUserPageOpened(userName);
    }

    @Test
    void openUserSettingsTest(){
        mainPage.openMainPage();
        logIn.openLoginPage()
                .setLogin(userName)
                .setPassword(password)
                .checkThatLoginSuccess(userName)
                .openSettings()
                .checkThatSettingsOpened();
    }
}
