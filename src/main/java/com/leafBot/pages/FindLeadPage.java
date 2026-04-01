package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class FindLeadPage extends ProjectSpecificMethods {

    public FindLeadPage enterFirstName(String findFirstName) {
        clearAndType(getDriver().findElement(Locator.FINDLEAD_FIRSTNAME_FIELD), findFirstName);
        return this;
    }

    public FindLeadPage enterLeadId(String findLeadId) {
        clearAndType(getDriver().findElement(Locator.FINDLEAD_LEADID_FIELD), findLeadId);
        return this;
    }

    public FindLeadPage clickFindleadsButton() {
        click(getDriver().findElement(Locator.FINDLEAD_FINDLEADS_BUTTON));
        return this;
    }

    public String getFirstResultingLead() {
        return getElementText(getDriver().findElement(Locator.FINDLEAD_FIRSTRESULTING_LEAD));

    }

    public String getFirstResultingFirstName() throws InterruptedException {
        return getElementText(getDriver().findElement(Locator.FINDLEAD_FIRSTRESULTING_FIRSTNAME));
    }

    public ViewLeadPage clickFirstResultingLead() {
        click(getDriver().findElement(Locator.FINDLEAD_FIRSTRESULTING_LEAD));
        return new ViewLeadPage();
    }

    public FindLeadPage clickPhoneTab() {
        click(getDriver().findElement(Locator.FINDLEAD_PHONE_TAB));
        return this;
    }

    public FindLeadPage clickEmailTab() {
        click(getDriver().findElement(Locator.FINDLEAD_EMAIL_TAB));
        return this;
    }

    public FindLeadPage enterPhoneNumberField(String phoneNumber) {
        clearAndType(getDriver().findElement(Locator.FINDLEAD_PHONENUMBER_FIELD), phoneNumber);
        return this;
    }

    public FindLeadPage enterEmailAddress(String emailAddress) {
        clearAndType(getDriver().findElement(Locator.FINDLEAD_EMAILADDRESS_FIELD), emailAddress);
        return this;
    }

    public FindLeadPage verifyErrorMsg(String errorMsgValue) {
        verifyPartialText(getDriver().findElement(Locator.FINDLEAD_ERROR_MSG), errorMsgValue);
        return this;
    }

}
