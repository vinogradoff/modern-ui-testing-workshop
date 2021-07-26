package widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// TODO Add steps
public class EnterprizeLanding {

    public SelenideElement header = $("h1");

    public void contactSales() {
        $("div.enterprise-hero").$(byText("Contact Sales")).click();
    }
}