package github;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import widgetobjects.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("Level 1")
@Feature("Level 2")
@Story("Level 2")
@DisplayName("Enterprise Sales contacts")
public class GitHubEnterprizeSalesWithPageObjects {

    @BeforeAll
    static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Description("Page objects used")
    @DisplayName("Robot should protect Sales Team contact from automation (PageObjects)")
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