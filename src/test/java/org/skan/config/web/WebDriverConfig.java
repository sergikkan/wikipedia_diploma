package org.skan.config.web;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:web/remote.properties",
        "classpath:web/local.properties"
    })

    public interface WebDriverConfig extends Config {

        @Key("baseUrl")
        @DefaultValue("https://ru.wikipedia.org")
        String baseUrl();

        @Key("browser")
        @DefaultValue("CHROME")
        String browser();

        @Key("browserSize")
        @DefaultValue("1920x1080")
        String browserSize();

        @Key("browserVersion")
        @DefaultValue("100")
        String browserVersion();
        @Key("remoteUrl")
        String remoteUrl();

        @Key("username")
        @DefaultValue("Skan2023")
        String username();

        @Key("password")
        @DefaultValue("Inspiration2022!")
        String password();

    }

