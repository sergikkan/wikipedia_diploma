package org.skan.config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobile/emulator.properties")
public interface EmulatorConfig extends Config {

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("deviceName")
    String deviceName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("appPath")
    String appPath();
}
