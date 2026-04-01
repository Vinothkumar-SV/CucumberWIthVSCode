package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {

    public CreateLeadPage enterCompanyName(String companyName) {
        clearAndType(getDriver().findElement(Locator.CREATELEAD_COMPANYNAME_FIELD), companyName);
        return this;
    }

    public CreateLeadPage enterFirstName(String firstName) {
        clearAndType(getDriver().findElement(Locator.CREATELEAD_FIRSTNAME_FIELD), firstName);
        return this;
    }

    public CreateLeadPage enterLastName(String lastName) {
        clearAndType(getDriver().findElement(Locator.CREATELEAD_LASTNAME_FIELD), lastName);
        return this;
    }

    public CreateLeadPage enterEmail(String email) {
        clearAndType(getDriver().findElement(Locator.CREATELEAD_EMAIL_FIELD), email);
        return this;
    }

    public ViewLeadPage clickCreateLeadSubmit() {
        click(getDriver().findElement(Locator.CREATELEAD_SUBMIT_BUTTON));
        return new ViewLeadPage();
    }
}
