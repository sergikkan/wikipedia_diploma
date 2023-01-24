package org.skan.config.mobile;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:mobile/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    String browserstackUser();

    String browserstackKey();

    String app();

    String device();

    String osVersion();
}
