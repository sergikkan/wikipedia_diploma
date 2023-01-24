package org.skan.config.mobile;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobile/emulator.properties")
public interface EmulatorConfig extends Config {

    String platformName();

    String platformVersion();

    String deviceName();

    String appPackage();

    String appActivity();

    String appPath();
}
