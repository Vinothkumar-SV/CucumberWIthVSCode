package com.leafBot.pages;

import com.leafBot.locators.Locator;

import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {

    public MyLeadsPage clickLeadLink() {
        click(getDriver().findElement(Locator.MYHOME_LEADS_LINK));

        return new MyLeadsPage();
    }

}
