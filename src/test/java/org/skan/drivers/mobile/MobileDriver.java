package org.skan.drivers.mobile;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.skan.config.mobile.EmulatorConfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {

    EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class);

    public static URL getAppiumServerUrl(){
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(config.platformName())
                .setDeviceName(config.deviceName())
                .setPlatformVersion(config.platformVersion())
                .setApp(getAppPath())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity());

        return new RemoteWebDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath(){
        String appUrl ="https://github.com/wikimedia/apps-android-wikipedia/" +
                "releases/download/latest/app-alpha-universal-release.apk";
        String appPath = config.appPath();

        File app = new File(appPath);
        if(!app.exists()){
            try (InputStream in = new URL(appUrl).openStream()){
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}
