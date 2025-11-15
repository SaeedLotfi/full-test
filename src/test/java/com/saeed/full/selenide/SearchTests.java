package com.saeed.full.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class SearchTests {

    @BeforeAll
    static void setupAll() {
        // headless browser (good for CI)
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }

    @BeforeEach
    void openHomePage() {
        // open DuckDuckGo for demo purposes
        open("https://duckduckgo.com/");
    }

    @Test
    void search_forSelenide_showsResult() throws InterruptedException {
        // set query and press Enter
        $("[name='q']").setValue("Selenide").pressEnter();

        // assert result page contains related text
        $("body").shouldHave(text("Images"));
    }

    @AfterEach
    void tearDown() {
        // close browser after test
        Selenide.closeWebDriver();
    }
}

