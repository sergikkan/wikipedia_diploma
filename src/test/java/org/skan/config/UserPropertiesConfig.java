package org.skan.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface UserPropertiesConfig extends Config {

    @Config.Key("username")
    @Config.DefaultValue("Skan2023")
    String username();

    @Config.Key("password")
    @Config.DefaultValue("Inspiration2022!")
    String password();


}
