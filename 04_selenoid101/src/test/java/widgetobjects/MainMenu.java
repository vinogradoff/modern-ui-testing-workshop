package widgetobjects;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainMenu {

    SelenideElement menu = $("nav");

    @Step("Open menu {menuName}")
    public void openMenu(String menuName) {
        menu.$(byText(menuName)).click();
    }
}