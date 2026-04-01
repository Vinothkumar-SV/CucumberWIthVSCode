
package com.leafBot.pages;
import com.leafBot.locators.Locator;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class MergeLeadPage extends ProjectSpecificMethods {

	public FindLeadPopPage clickFromLeadLookup() {
		clickWithNoSnap(getDriver().findElement(Locator.FROM_LEAD_LOOKUP));
		switchToWindow(1);
		return new FindLeadPopPage();
	}

	public FindLeadPopPage clickToLeadLookup() {
		clickWithNoSnap(getDriver().findElement(Locator.TO_LEAD_LOOKUP));
		switchToWindow(1);
		return new FindLeadPopPage();
	}

	public ViewLeadPage clickMergeButton() {
		clickWithNoSnap(getDriver().findElement(Locator.MERGE_BUTTON));
		acceptAlert();
		return new ViewLeadPage();
	}
}