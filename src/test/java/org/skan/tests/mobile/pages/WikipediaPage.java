package org.skan.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaPage{

    private static final By
            SKIP = AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"),
            SEARCH_FIELD = AppiumBy.accessibilityId("Search Wikipedia"),
            SEARCH_INPUT = AppiumBy.id("org.wikipedia.alpha:id/search_src_text"),
            TEXT_VIEW =AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView[1]"),
            MORE_BUTTON = AppiumBy.id("menu_icon"),
            SETTINGS_BUTTON = AppiumBy.xpath("//android.widget.LinearLayout[2]/android.widget.TextView"),
            LANGUAGES_SETTINGS_BUTTON = AppiumBy.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]"),
            ADD_LANGUAGE = AppiumBy.xpath("//*[@text='ADD LANGUAGE']");

    @Step("Нажимаем на кнопку пропустить")
    public WikipediaPage pressSkip(){
        $(SKIP).click();
        return this;
    }

    @Step("Нажимаем на поле поиска")
    public WikipediaPage pressOnSearchField(){
        $(SEARCH_FIELD).click();
        return this;
    }

    @Step("Вводим поисковый запрос")
    public WikipediaPage setSearchText(String text){
        $(SEARCH_INPUT).sendKeys(text);
        return this;
    }

    @Step("Проверяем что новости найдены")
    public WikipediaPage checkSearchResult(){
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открываем первую новость")
    public WikipediaPage openFirstResult(){
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        return this;
    }

    @Step("Проверяем что в статье есть определенный текст")
    public WikipediaPage checkTextInArticle(String text){
        $(TEXT_VIEW).shouldHave(Condition.text(text));
        return this;
    }

    @Step("Нажимаем на кнопку Еще")
    public WikipediaPage pressButtonMore(){
        $(MORE_BUTTON).click();
        return this;
    }

    @Step("Нажимаем на кнопку Настройки")
    public WikipediaPage pressSettings(){
        $(SETTINGS_BUTTON).click();
        return this;
    }

    @Step("Открываем настройки языков")
    public WikipediaPage openLanguagesSettings(){
        $(LANGUAGES_SETTINGS_BUTTON).click();
        return this;
    }

    @Step("Проверяем, что нужный нам язык не добавлен")
    public WikipediaPage checkThatLanguageNotAdded(String language){
        $(AppiumBy.xpath("//*[@text='"+language+"']")).shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Нажимаем на кнопку добавить язык")
    public WikipediaPage pressAddLanguage(){
        $(ADD_LANGUAGE).click();
        return this;
    }

    @Step("Нажимаем на нужный язык")
    public WikipediaPage pressOnLanguage(String language){
        $(AppiumBy.xpath("//*[@text='"+language+"']")).click();
        return this;
    }

    @Step("Проверяем, что выбранный язык добавлен")
    public WikipediaPage checkThatLanguageAdded(String language){
        $(AppiumBy.xpath("//*[@text='"+language+"']")).shouldBe(Condition.visible);
        return this;
    }


}
