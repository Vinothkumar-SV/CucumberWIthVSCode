package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class FindLeadPopPage extends ProjectSpecificMethods {

    // Locators
    // ...locators moved to Locator.java...
    public FindLeadPopPage enterFirstName(String findFirstName) {
        clearAndType(getDriver().findElement(Locator.FINDLEADPOP_FIRSTNAME_FIELD), findFirstName);
        return this;
    }

    public FindLeadPopPage clickFindleadsButton() {
        click(getDriver().findElement(Locator.FINDLEADPOP_FINDLEADS_BUTTON));
        return this;
    }

    public String getFirstResultingLead() {
        switchToWindow(1);
        return getElementText(getDriver().findElement(Locator.FINDLEADPOP_FIRSTRESULTING_LEAD));
    }

    public MergeLeadPage clickResultingLeads() {
        clickWithNoSnap(getDriver().findElement(Locator.FINDLEADPOP_FIRSTRESULTING_LEAD));
        switchToWindow(0);
        return new MergeLeadPage();
    }
}
