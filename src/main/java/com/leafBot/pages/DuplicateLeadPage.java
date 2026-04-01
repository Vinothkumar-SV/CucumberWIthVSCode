package com.leafBot.pages;

import com.leafBot.locators.Locator;

import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class DuplicateLeadPage extends ProjectSpecificMethods {

    // Locators
    // ...locator moved to Locator.java...
    public ViewLeadPage clickCreateLeadDuplicate() {
        click(getDriver().findElement(Locator.CREATELEAD_SUBMIT_BUTTON));
        return new ViewLeadPage();
    }
}
