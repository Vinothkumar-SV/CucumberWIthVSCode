package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods {

    public EditLeadPage updateCompanyName(String updcomnyName) {
        clearAndType(getDriver().findElement(Locator.EDITLEAD_COMPANYNAME_FIELD), updcomnyName);
        return this;
    }

    public ViewLeadPage clickUpdateSubmit() {
        click(getDriver().findElement(Locator.EDITLEAD_UPDATE_BUTTON));
        return new ViewLeadPage();
    }

}
