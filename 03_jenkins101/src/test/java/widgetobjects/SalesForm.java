package widgetobjects;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;


// TODO Add Steps
public class SalesForm {
    public SelenideElement additionalCommentsField = $("[for=contact_request_comments]");
    public SelenideElement sendRequestButton = $("fieldset#signup-form button");

    @Step("Fill in Form: name={name} company={company} email={email}")
    public void fillInForm(String name, String company, String email) {
        $("input#contact_request_name").setValue(name);
        $("input#contact_request_organization_name").setValue(company);
        $("input#contact_request_email").setValue(email);
    }

    @Step("Choose option: Other")
    public void chooseRequestOptionOther() {
        $("input#contact_request_purpose_other").click();
    }

    @Step("Choose option: Support")
    public void chooseRequestOptionSupport() {
        $("input#contact_request_purpose_support").click();
    }
}