package org.skan.tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.skan.drivers.mobile.BrowserstackMobileDriver;
import org.skan.drivers.mobile.MobileDriver;
import org.skan.helpers.Attach;
import org.skan.tests.mobile.pages.WikipediaPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.skan.helpers.Attach.*;

public class BaseTest {

    static String driver = System.getProperty("mobileDeviceHost", "browserstack");

    public WikipediaPage wiki = new WikipediaPage();
    @BeforeAll
    static void setUp() {
        if (driver.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (driver.equals("emulation")) {
            Configuration.browser = MobileDriver.class.getName();
        } else {
            throw new RuntimeException("Incorrect stand name");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        if (driver.equals("browserstack")) {
            Attach.video(sessionId);
        }
    }
}
