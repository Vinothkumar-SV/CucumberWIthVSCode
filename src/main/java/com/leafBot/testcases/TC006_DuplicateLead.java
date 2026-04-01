package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC006_DuplicateLead extends ProjectSpecificMethods {

    @BeforeTest
    public void setData() {
        testcaseName = "TC006_DuplicateLead";
        testDescription = "Duplicate a Lead - LeafTaps";
        dataSheetName = "TC006";
        category = "Regression";
        authors = "Hari";
    }

    @Test(dataProvider = "fetchData")
    public void duplicateLead(String userName, String password, String emailAddress) throws InterruptedException {

        String fName
                = new LoginPage()
                        .enterUserName(userName)
                        .enterPassword(password)
                        .clickLogin()
                        .clickCRMSFA()
                        .clickLeadLink()
                        .clickFindLead()
                        .clickEmailTab()
                        .enterEmailAddress(emailAddress)
                        .clickFindleadsButton()
                        .getFirstResultingFirstName();
        new FindLeadPage()
                .clickFirstResultingLead()
                .clickDuplicateLeadLink()
                .clickCreateLeadDuplicate()
                .verifyFirstName(fName);

    }

}
