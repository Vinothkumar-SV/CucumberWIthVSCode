package com.leafBot.pages;

import com.leafBot.locators.Locator;

import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods {

    // Locators
    // ...locators moved to Locator.java...
    public CreateLeadPage clickCreateLead() {
        click(getDriver().findElement(Locator.MYLEADS_CREATELEAD_LINK));
        return new CreateLeadPage();
    }

    public FindLeadPage clickFindLead() {
        click(getDriver().findElement(Locator.MYLEADS_FINDLEADS_LINK));
        return new FindLeadPage();
    }

    public MergeLeadPage clickMergeLead() {
        click(getDriver().findElement(Locator.MYLEADS_MERGELEADS_LINK));
        return new MergeLeadPage();
    }

}
