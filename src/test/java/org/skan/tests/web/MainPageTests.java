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
