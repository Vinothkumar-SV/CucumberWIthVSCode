package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;

public class HomePage extends ProjectSpecificMethods {

    public HomePage verifyLoggedName(String logName) {
        verifyPartialText(getDriver().findElement(Locator.HOME_LOGGEDNAME), logName);
        return this;
    }

    public MyHomePage clickCRMSFA() {
        click(getDriver().findElement(Locator.HOME_CRM_SFA_LINK));
        return new MyHomePage();
    }

    public LoginPage clickLogout() {
        click(getDriver().findElement(Locator.HOME_LOGOUT_BUTTON));
        return new LoginPage();
    }

    @Then("Homepage should be displayed")
    public HomePage verifyHomepage() {
        verifyDisplayed(getDriver().findElement(Locator.HOME_LOGGEDNAME));
        return this;
    }

}
