package github;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.*;
import io.qameta.allure.*;
import io.qameta.allure.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("GitHub Selenide")
@Feature("Searching of Selenide")
@Story("Checking the title")
@DisplayName("Simple GitHub Tests")
public class GitHubTest {

    @BeforeAll
    static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @DisplayName("Selenide should be found as a Repository")
    @Description("1. Search for Selenide\n" +
            "2. Check that the first hit is the right repository")
    void selenideShouldBeFound() {
        // open github
        open("https://github.com");
        // enter selenide in search field
        // press enter
        $("[name=q]").setValue("selenide").pressEnter();
        var firstLinkFound = $$(".repo-list li").first().$("a");
        firstLinkFound.click();
        doScreenshot();
        // assert: selenide/selenide in the header of the page
        attachText();
        $("h1").shouldHave(text("selenide / selenide"));
    }

    @Attachment("Helpful information")
    private String attachText() {
        return "Congratulation, it works!";
    }

    @Attachment("Screenshot")
    private byte[] doScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
