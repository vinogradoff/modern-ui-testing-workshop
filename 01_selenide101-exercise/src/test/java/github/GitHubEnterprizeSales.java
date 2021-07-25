package github;


import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubEnterprizeSales {

    @Test
    void tryToReachTheSalesTeam() {
        // goto Enterpize Menu on GitHub Homepage
        open("https://github.com");
        $("nav").$(byText("Enterprise")).click();
        // Assert: Header is "Build like the best"
        $("h1").shouldHave(text("Build like the best"));
        // Contact Sales
        $("div.enterprise-hero").$(byText("Contact Sales")).click();
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
