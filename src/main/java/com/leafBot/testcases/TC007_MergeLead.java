package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPopPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;



public class TC007_MergeLead extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues(){
		testcaseName = "TC007_MergeLead";
		testDescription = "Merge two Lead on LeafTaps";
		dataSheetName = "TC007";
		category = "Regression";
		authors = "Hari";		
	}

	@Test(dataProvider = "fetchData")
	public void mergeLead(String uName, String pwd,String f_LeadName,String l_LeadName, String errorMsg){
		String fromLeadId = 
			new LoginPage()
				.enterUserName(uName)
				.enterPassword(pwd)
				.clickLogin()
				.clickCRMSFA()
				.clickLeadLink()
				.clickMergeLead()
				.clickFromLeadLookup()
				.enterFirstName( f_LeadName)
				.clickFindleadsButton()
				.getFirstResultingLead();
		
			new FindLeadPopPage()
				.clickResultingLeads()
				.clickToLeadLookup()
				.enterFirstName( l_LeadName)
				.clickFindleadsButton()
				.clickResultingLeads()
				.clickMergeButton()
				.clickFindLead()
				.enterLeadId(fromLeadId)
				.clickFindleadsButton()
				.verifyErrorMsg(errorMsg);

	}


}










