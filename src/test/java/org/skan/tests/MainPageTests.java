package org.skan.tests;
import org.junit.jupiter.api.Test;

public class MainPageTests extends BaseTest {

    String searchQuery = "Facebook";
    @Test
    void openMainPageTest(){
        mainPage.openMainPage()
                .checkThatMainpageOpened();
    }

    @Test
    void searchTest(){
        openMainPageTest();
        mainPage.setSearchedText(searchQuery)
                .checkSearchResult(searchQuery);
    }

    @Test
    void openSearchArticleTest(){
        searchTest();
        mainPage.openSearchResult()
                .checkOpenedResult(searchQuery);
    }

    @Test
    void openForumTest(){
        openMainPageTest();
        mainPage.openForum().checkThatForumOpened();
    }

    @Test
    void openDonationTest(){
        openMainPageTest();
        mainPage.openDonationPage().checkThatDonationOpened();

    }
}
