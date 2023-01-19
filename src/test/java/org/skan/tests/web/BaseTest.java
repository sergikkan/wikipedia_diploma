package org.skan.tests.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.skan.drivers.web.WebDriverProvider;
import org.skan.helpers.Attach;
import org.skan.tests.web.pages.LoginPage;
import org.skan.tests.web.pages.MainpagePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    static String useRemote = System.getProperty("web", "remote");
    public MainpagePage mainPage = new MainpagePage();
    public LoginPage logIn = new LoginPage();

    public static final String
            userName = WebDriverProvider.config.username(),
            password = WebDriverProvider.config.password();


    @BeforeAll
    static void setUp() {

        WebDriverProvider.configure();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (useRemote.equals("remote")) {
            Attach.addVideo();
        }
        closeWebDriver();

    }

}
