package github;

import com.codeborne.selenide.logevents.*;
import io.qameta.allure.*;
import io.qameta.allure.selenide.*;
import org.junit.jupiter.api.*;
import widgetobjects.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("GitHub Selenide")
@Feature("Searching of Selenide")
@Story("Checking the title with PageObjects")
@TmsLink("JSWSERVER-4735")
@Issue("JSWSERVER-15185")
@Link(name = "GitHub HomePage", url = "https://github.com")
public class GitHubWithPageObjectsTest {

    @BeforeAll
    static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void selenideShouldBeFound() {
        open("https://github.com");
        new Header().searchRepository("selenide");
        new RepositoriesFound().openRepositoryFound(0);
        new Repository().title.shouldHave(text("selenide / selenide"));
    }
}
