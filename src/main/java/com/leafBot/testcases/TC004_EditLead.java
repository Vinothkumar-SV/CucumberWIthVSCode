package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;



public class TC004_EditLead extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		testcaseName="TC004_EditLead";
		testDescription="Edit excisting Lead on LeafTaps";
		dataSheetName="TC004";
		category="Sanity";
		authors="Hari";
	}

	@Test(dataProvider="fetchData")
	public void editLead(String userName, String password , String f_Name, String updcompanyName){

		new LoginPage()
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()		
		.clickCRMSFA()		
		.clickLeadLink()		
		.clickFindLead()
		.enterFirstName(f_Name)
		.clickFindleadsButton()
		.clickFirstResultingLead()
		.clickEditLeadLink()
		.updateCompanyName(updcompanyName)
		.clickUpdateSubmit()
		.verifyCompanyName(updcompanyName);
		
	}

}
