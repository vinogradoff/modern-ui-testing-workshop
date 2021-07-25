package widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainMenu {

    SelenideElement menu = $("nav");

    public void openMenu(String menuName) {
        menu.$(byText(menuName)).click();
    }
}
