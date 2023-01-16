package org.skan.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.skan.pages.components.ElementIsVisibleComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WikipediaPage {
    ElementIsVisibleComponent elementIsVisibleComponent = new ElementIsVisibleComponent();

    @Step("Открыть главную страницу сайта")
    public WikipediaPage openMainPage() {
        open("/");
        //switchTo().alert().accept();
        return this;
    }

    @Step("Кнопка все категории видна на главной странице")
    public WikipediaPage checkThatCategoriesButtonVisible() {
        $("button.categories").shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить что {element} есть на главной странице")
    public WikipediaPage checkThatElementIsVisible(String element) {
        elementIsVisibleComponent.checkThatElementIsVissible(element);
        return this;
    }

    @Step("Найти товар в поисковой строке")
    public WikipediaPage searchProduct(String product){
        $(byAttribute("formcontrolname","search")).setValue(product).pressEnter();
        $$("dar-product-card div.content a div").filter(Condition.visible).first().shouldHave(Condition.text(product));
        return this;
    }

    @Step("Открыть детали товара")
    public WikipediaPage openProductDetails(){
        $$("dar-product-card div.content a div").filter(Condition.visible).first().click();
        return this;
    }

    @Step("Проверить что детали товара открыты")
    public WikipediaPage checkThatProductOpened(){
        $(".border-gallery dar-product-detail").shouldBe(Condition.visible);
        return this;
    }

    @Step("Открыть Мои закаы")
    public WikipediaPage openMyOrders(){
        $(byAttribute("href","/profile/orders")).click();
        return this;
    }

    @Step("Проверяем, что страница открыта без авторизации")
    public WikipediaPage CheckThatOpenedWithoutAutorization(){
        $(byTagAndText("span","Войти/Зарегистрироваться")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажать на выбрать продавца")
    public WikipediaPage pressChooseSeller(){
        $(byTagAndText("span","Выбрать продавца")).click();
        return this;
    }

    @Step("Выбрать первого продавца из списка")
    public WikipediaPage chooseFirstSellerFromList(){
        $$(byTagAndText("span","Выбрать")).first().click();
        return this;
    }

    @Step("Добавить товар в корзину")
    public WikipediaPage addProductToCart(){
        $("dar-modal-add-to-cart").$(byTagAndText("span","Добавить в корзину")).click();
        return this;
    }

    @Step("Открыть корзину")
    public WikipediaPage openCart(){
        $(byText("Корзина")).click();
        return this;
    }

    @Step("Проверяем что корзина не пуста")
    public WikipediaPage checkThatProductInCart(){
        $("dar-cart-product").shouldBe(Condition.visible);
        return this;
    }

}