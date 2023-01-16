package org.skan.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.skan.config.WebDriverProvider;
import org.skan.helpers.Attach;
import org.skan.pages.WikipediaPage;

public class BaseTest {

    WikipediaPage wiki = new WikipediaPage();

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
    }
}
