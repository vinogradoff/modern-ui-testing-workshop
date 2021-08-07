package widgetobjects;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterprizeLanding {

    public SelenideElement header = $("h1");

    @Step("Contact Sales")
    public void contactSales() {
        $("div.enterprise-hero").$(byText("Contact Sales")).click();
    }
}