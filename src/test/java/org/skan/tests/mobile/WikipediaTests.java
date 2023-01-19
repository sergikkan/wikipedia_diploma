package org.skan.tests.mobile;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("MOBILE")
@Tag("ALL")
public class WikipediaTests extends BaseTest {

    final String SEARCH_TEXT = "Java";
    String text = "This article is about the Indonesian island";
    final String LANGUAGE = "Русский";

    @Test
    void successSearchTest() {
        wiki.pressSkip()
                .pressOnSearchField()
                .setSearchText(SEARCH_TEXT)
                .checkSearchResult();
    }

    @Test
    void openNewsTest() {
        successSearchTest();
        wiki.openFirstResult()
                .checkTextInArticle(text);
    }

    @Test
    void addLanguageTest() {
            wiki.pressSkip()
                    .pressButtonMore()
                    .pressSettings()
                    .openLanguagesSettings()
                    .checkThatLanguageNotAdded(LANGUAGE)
                    .pressAddLanguage()
                    .pressOnLanguage(LANGUAGE)
                    .checkThatLanguageAdded(LANGUAGE);
    }
}
