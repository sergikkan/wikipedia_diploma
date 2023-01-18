package org.skan.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainpagePage extends MainPage{

    private SelenideElement logo =$("#p-logo a"),
            textOnMain =$x("//span[contains(text(), 'Добро пожаловать')]"),
            searchInput =$("#simpleSearch #searchInput"),
            searchResult= $("li.mw-search-result"),
            openSearchResult = $(".mw-search-result-heading a"),
            openForum = $("#n-forum a"),
            openDonation = $("#n-sitesupport a"),
            donationPageHeading =$("span.mw-headline");
            ;
    private ElementsCollection searchResultArray= $$("li.mw-search-result");

    @Step("Открыть главную страницу сайта")
    public MainpagePage openMainPage() {
        open("/");
        return this;
    }

    @Step("Проверить что главная страница открылась")
    public MainpagePage checkThatMainpageOpened(){
        logo.shouldBe(Condition.visible);
        textOnMain.shouldBe(Condition.visible);
        return this;
    }

    @Step("Ввести в строку поиска запрос и нажать enter")
    public MainpagePage setSearchedText(String text) {
        searchInput.setValue(text).pressEnter();
        return this;
    }

    @Step("Проверить что есть статьи в результате поиска")
    public MainpagePage checkSearchResult(String text) {
       searchResultArray.shouldBe(CollectionCondition.sizeGreaterThan(1));
       searchResult.shouldHave(text(text));
        return this;
    }

    @Step("Открыть статью после поиска")
    public MainpagePage openSearchResult() {
       openSearchResult.click();
        return this;
    }

    @Step("Проверить что в заголовке открывшейся статьи есть текст из поиска")
    public MainpagePage checkOpenedResult(String text) {
        h1FirstHeading.shouldHave(text(text));
        return this;
    }

    @Step("Открыть страницу Форума")
    public MainpagePage openForum() {
        openForum.click();
        return this;
    }

    @Step("Проверить что страница форума открылась")
    public MainpagePage checkThatForumOpened() {
        h1FirstHeading.shouldHave(text("Википедия:Форум"));
        return this;
    }

    @Step("Открыть страницу пожертвовать")
    public MainpagePage openDonationPage() {
        openDonation.click();
        return this;
    }

    @Step("Проверить что страница пожертвовать открылась")
    public MainpagePage checkThatDonationOpened() {
        donationPageHeading.shouldHave(text("Обращение основателя Википедии Джимми Уэйлса."));
        return this;
    }


}