package org.skan.drivers.web;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.skan.config.web.WebDriverConfig;


public class WebDriverProvider {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    public static boolean isRemoteWebDriver() {
        return !config.remoteUrl().equals("");
    }

    public static void configure() {
        Configuration.timeout= 20000;
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        DesiredCapabilities capabilities = new DesiredCapabilities();



        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = config.remoteUrl();
            Configuration.browserCapabilities = capabilities;
        }
    }
//    public static void configuration() {
//
//        Configuration.timeout= 10000;
//        Configuration.baseUrl = config.baseUrl();
//        Configuration.browser = config.browser();
//        Configuration.browserSize = config.browserSize();
//        Configuration.browserVersion = config.browserVersion();
//        String configSource = config.remoteUrl();
//        if (configSource != null) {
//            Configuration.remote = config.remoteUrl();
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            Configuration.browserCapabilities = capabilities;
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//        }
//    }

}
