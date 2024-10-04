package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutYourInformationPage {
    final SelenideElement
            firstNameInput = $("data-test=firstName"),
            lastNameInput = $("data-test=lastName"),
            postalCodeInput = $("data-test=postalCode");

    public CheckoutYourInformationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public CheckoutYourInformationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public CheckoutYourInformationPage setPostalCode(String value) {
        postalCodeInput.setValue(value);
        return this;
    }

}
