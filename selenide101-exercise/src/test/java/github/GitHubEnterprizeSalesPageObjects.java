package github;


import org.junit.jupiter.api.*;
import widgetobjects.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubEnterprizeSalesPageObjects {

    @Test
    void tryToReachTheSalesTeam() {
        open("https://github.com");
        new MainMenu().openMenu("Enterprise");
        new EnterprizeLanding().header.shouldHave(text("Build like the best"));
        new EnterprizeLanding().contactSales();
        new SalesForm().fillInForm("Alexei", "Radio QA", "info@radioqa.com");
        new SalesForm().chooseRequestOptionOther();
        new SalesForm().additionalCommentsField.shouldBe(visible);
        new SalesForm().chooseRequestOptionSupport();
        new SalesForm().additionalCommentsField.should(disappear);
        new SalesForm().sendRequestButton.shouldBe(disabled);
    }
}
