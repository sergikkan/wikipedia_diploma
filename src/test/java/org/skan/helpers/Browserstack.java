package org.skan.helpers;

import org.aeonbits.owner.ConfigFactory;
import org.skan.config.mobile.BrowserstackConfig;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static String videoUrl(String sessionId){
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json" , sessionId);

        return given()
                .log().all()
                .auth().basic(config.browserstackUser(), config.browserstackKey())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");


    }

}
