package github;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("Level 1")
@Feature("Level 2")
@Story("Level 3")
@DisplayName("Enterprise Sales contacts")
public class GitHubEnterprizeSales {

    @BeforeAll
    static void init() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @Description("trying to reach sales team and failing")
    @DisplayName("Robot should protect Sales Team contact from automation")
    void tryToReachTheSalesTeam() {
        // goto Enterpize Menu on GitHub Homepage
        open("https://github.com");
        $("nav").$(byText("Enterprise")).click();
        // Assert: Header is "Build like the best"
        $("h1").shouldHave(text("Build like the best"));
        // Contact Sales
        $("div.enterprise-hero").$(byText("Contact Sales")).click();
        sleep(20000);
        // Fill in: Name, Company, Work Email
        $("input#contact_request_name").setValue("Alexei");
        $("input#contact_request_organization_name").setValue("Radio QA");
        $("input#contact_request_email").setValue("info@radioqa.com");
        // I need help with: other
        $("input#contact_request_purpose_other").click();
        // Assert: another text field is showing
        $("[for=contact_request_comments]").shouldBe(visible);
        // I need help with: Customer Support for GitHub Enterprise
        $("input#contact_request_purpose_support").click();
        // Assert: no addition text field is visible
        $("[for=contact_request_comments]").should(disappear);
        // Assert: I cannot contact the Sales Team :(
        $("fieldset#signup-form button").shouldBe(disabled);
    }
}