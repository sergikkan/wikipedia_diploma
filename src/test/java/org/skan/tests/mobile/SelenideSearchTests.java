package org.skan.tests.mobile;


import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("MOBILE")
@Tag("ALL")
public class SelenideSearchTests extends BaseTest {

    String text = "This article is about the Indonesian island";

    @Test
    void successSearchTest() {
        step("Нажимаем на поиск", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });
        step("Вводим поисковый запрос", () ->{
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Проверяем что новости найдены", () ->{
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void openNewsTest() {
        step("Нажимаем на поиск", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });
        step("Вводим поисковый запрос", () ->{
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Проверяем что новости найдены", () ->{
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
        step("Открываем первую новость", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });step("Проверяем что на открывшейся странице есть совпадение по тексту", () -> {
            $(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[1]")).shouldHave(Condition.text(text));
        });
    }
}
