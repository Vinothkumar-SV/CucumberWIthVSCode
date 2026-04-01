package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {

    // Locators
    // ...locators moved to Locator.java...
    public ViewLeadPage verifyFirstName(String fname) {
        verifyPartialText(getDriver().findElement(Locator.VIEWLEAD_FIRSTNAME_TEXT), fname);
        return this;
    }

    public FindLeadPage clickFindLead() {
        click(getDriver().findElement(Locator.VIEWLEAD_FINDLEADS_LINK));
        return new FindLeadPage();
    }

    public ViewLeadPage verifyCompanyName(String CompanyName) {
        verifyPartialText(getDriver().findElement(Locator.VIEWLEAD_COMPANYNAME_TEXT), CompanyName);
        return this;
    }

    public EditLeadPage clickEditLeadLink() {
        click(getDriver().findElement(Locator.VIEWLEAD_EDITLEAD_LINK));
        return new EditLeadPage();
    }

    public DuplicateLeadPage clickDuplicateLeadLink() {
        click(getDriver().findElement(Locator.VIEWLEAD_DUPLICATELEAD_LINK));
        return new DuplicateLeadPage();
    }

    public MyLeadsPage clickDeleteLeadLink() {
        click(getDriver().findElement(Locator.VIEWLEAD_DELETELEAD_LINK));
        return new MyLeadsPage();
    }

}
