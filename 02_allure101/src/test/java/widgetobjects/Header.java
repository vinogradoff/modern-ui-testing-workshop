package widgetobjects;

import com.codeborne.selenide.*;
import io.qameta.allure.*;

import static com.codeborne.selenide.Selenide.*;

public class Header {

    SelenideElement searchField = $("[name=q]");

    @Step("Search for repository {repository}")
    public void searchRepository(String repository) {
        searchField.setValue(repository).pressEnter();
    }
}
