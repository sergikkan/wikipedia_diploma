package org.skan.config.web;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:web/remote.properties",
        "classpath:web/local.properties"
    })
    public interface WebDriverConfig extends Config {

        @DefaultValue("https://ru.wikipedia.org")
        String baseUrl();

        @DefaultValue("CHROME")
        String browser();

        @DefaultValue("1920x1080")
        String browserSize();

        @DefaultValue("100")
        String browserVersion();

        String remoteUrl();

        String username();

        String password();
    }

