package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC001_LoginLogOut extends ProjectSpecificMethods{	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@BeforeTest
	public void setValues() {
		testcaseName = "Login and LoginOut";
		testDescription = "Login testCase using DemoSalesManager UserName and LogOut";
		authors = "Hari";
		category = "Smoke";
		dataSheetName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void runVerifyLogin(String uName, String pwd) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.verifyHomepage();
	}


}





