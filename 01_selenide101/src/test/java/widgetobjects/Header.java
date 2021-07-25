package widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class Header {

    SelenideElement searchField=$("[name=q]");

    public void searchRepository(String repository){
        searchField.setValue(repository).pressEnter();
    }
}
