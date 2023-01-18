package org.skan.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.skan.config.UserPropertiesConfig;
import org.skan.config.WebDriverProvider;
import org.skan.helpers.Attach;
import org.skan.pages.LoginPage;
import org.skan.pages.MainpagePage;

public class BaseTest {
    MainpagePage mainPage = new MainpagePage();
    LoginPage logIn = new LoginPage();

    static UserPropertiesConfig userProperties = ConfigFactory.create(UserPropertiesConfig.class, System.getProperties());
    String userName = userProperties.username();
    String password = userProperties.password();

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        WebDriverProvider.configuration();

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
