package org.skan.tests.web;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("WEB")
@Tag("ALL")
public class MainPageTests extends BaseTest {

    String searchQuery = "Facebook";

    @Test
    void openMainPageTest(){
        mainPage.openMainPage()
                .checkThatMainpageOpened();
    }

    @Test
    void searchTest(){
        mainPage.openMainPage()
                .checkThatMainpageOpened()
                .setSearchedText(searchQuery)
                .checkSearchResult(searchQuery);
    }

    @Test
    void openSearchArticleTest(){
        mainPage.openMainPage()
                .checkThatMainpageOpened()
                .setSearchedText(searchQuery)
                .checkSearchResult(searchQuery)
                .openSearchResult()
                .checkOpenedResult(searchQuery);
    }

    @Test
    void openForumTest(){
        mainPage.openMainPage()
                .checkThatMainpageOpened()
                .openForum()
                .checkThatForumOpened();
    }

    @Test
    void openDonationTest(){
        mainPage.openMainPage()
                .checkThatMainpageOpened()
                .openDonationPage()
                .checkThatDonationOpened();
    }
}
