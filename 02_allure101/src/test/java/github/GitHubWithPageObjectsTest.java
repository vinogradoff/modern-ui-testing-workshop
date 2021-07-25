package github;

import org.junit.jupiter.api.*;
import widgetobjects.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubWithPageObjectsTest {

    @Test
    void selenideShouldBeFound() {
        open("https://github.com");
        new Header().searchRepository("selenide");
        new RepositoriesFound().openRepositoryFound(0);
        new Repository().title.shouldHave(text("selenide / selenide"));
    }
}
