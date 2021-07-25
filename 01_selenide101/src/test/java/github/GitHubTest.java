package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @Test
    void selenideShouldBeFound(){
        // open github
        open("https://github.com");
        // enter selenide in search field
        // press enter
        $("[name=q]").setValue("selenide").pressEnter();
        var firstLinkFound=$$(".repo-list li").first().$("a");
        firstLinkFound.click();
        // assert: selenide/selenide in the header of the page
        $("h1").shouldHave(text("selenide / selenide"));
    }
}
