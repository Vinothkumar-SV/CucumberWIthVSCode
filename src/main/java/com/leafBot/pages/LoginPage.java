package com.leafBot.pages;

import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

import io.cucumber.java.en.Given;

public class LoginPage extends ProjectSpecificMethods {

    // Locators
    // ...locators moved to Locator.java...
    @Given("Enter the username as {string}")
    public LoginPage enterUserName(String userName) {
        clearAndType(getDriver().findElement(Locator.LOGIN_USERNAME_FIELD), userName);
        return this;
    }

    @Given("Enter the Password as {string}")
    public LoginPage enterPassword(String password) {
        clearAndType(getDriver().findElement(Locator.LOGIN_PASSWORD_FIELD), password);
        return this;
    }

    @Given("Click on the Login")
    public HomePage clickLogin() {
        click(getDriver().findElement(Locator.LOGIN_BUTTON));
        return new HomePage();
    }

    public LoginPage clickLogInForFailer() {
        click(getDriver().findElement(Locator.LOGIN_ERROR_DIV));
        return this;
    }

    @Given("Verify the error message {string}")
    public LoginPage verifyErrorMsg(String errorMsg) {
        verifyPartialText(getDriver().findElement(Locator.LOGIN_ERROR_DIV), errorMsg);
        return this;
    }

}
