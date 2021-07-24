package widgetobjects;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class SalesForm {
    public SelenideElement additionalCommentsField = $("[for=contact_request_comments]");
    public SelenideElement sendRequestButton = $("fieldset#signup-form button");

    public void fillInForm(String name, String company, String email) {
        $("input#contact_request_name").setValue(name);
        $("input#contact_request_organization_name").setValue(company);
        $("input#contact_request_email").setValue(email);
    }

    public void chooseRequestOptionOther() {
        $("input#contact_request_purpose_other").click();
    }

    public void chooseRequestOptionSupport() {
        $("input#contact_request_purpose_support").click();
    }
}
