package org.skan.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class WikipediaTests extends BaseTest {

    @Test
    void openMainPageTest(){
        open("/");
        $(".mw-wiki-logo").shouldBe(Condition.visible);
        $x("//span[contains(text(), 'Добро пожаловать')]").shouldBe(Condition.visible);
    }

    @Test
    void searchTest(){
        open("/");

    }

//    @Test
//    @DisplayName("Открытие главной страницы сайта")
//    @Test
//    void openMainPage(){
//        wiki.openMainPage()
//                .checkThatCategoriesButtonVisible()
//                .checkThatElementIsVisible("Мои заказы")
//                .checkThatElementIsVisible("Избранное")
//                .checkThatElementIsVisible("Корзина")
//                .checkThatElementIsVisible("Мои заказы")
//                .checkThatElementIsVisible("8 8000 700 714");
//    }
//
//    @Owner("serhiikan")
//    @DisplayName("Проверка поиска товара")
//    @Test
//    void checkProductSearching(){
//        wiki.openMainPage()
//                .searchProduct("iPhone 14");
//    }
//
//    @Owner("serhiikan")
//    @DisplayName("Открытие деталей товара")
//    @Test
//    void openProduct(){
//        wiki.openMainPage()
//                .searchProduct("iPhone 14")
//                .openProductDetails()
//                .checkThatProductOpened();
//    }
//
//    @Owner("serhiikan")
//    @DisplayName("Открытие страницы Мои заказы у неавторизованного пользователя")
//    @Test
//    void openMyOrdersWithoutAutorization(){
//        wiki.openMainPage()
//                .openMyOrders()
//                .CheckThatOpenedWithoutAutorization();
//    }
//
//    @Owner("serhiikan")
//    @DisplayName("Добавление найденного товара в корзину")
//    @Test
//    void addProductToCart(){
//        wiki.openMainPage()
//                .searchProduct("iPhone 14")
//                .openProductDetails()
//                .pressChooseSeller()
//                .chooseFirstSellerFromList()
//                .addProductToCart()
//                .openCart()
//                .checkThatProductInCart();
//    }
}
