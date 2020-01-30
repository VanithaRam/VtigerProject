package com.crm.vtiger.campaigntest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.generic.BaseTest;
import com.crm.vtiger.pages.CampaignInfoPage;
import com.crm.vtiger.pages.CampaignPage;
import com.crm.vtiger.pages.CreateCampaignPage;
import com.crm.vtiger.pages.HomePage;
import com.crm.vtiger.pages.ProdChildPage;

public class CampaignTestWithProduct extends BaseTest {
	
	@Test(groups= {"regression"})
	public void createCampaign()
	{
		/***************get test data********************/
		String campName=flib.getData(XL_PATH, SHEET2, 1, 0)+wdu.getRandomNumber();
		String sponsor = flib.getData(XL_PATH, SHEET2, 1, 2);
		String product = flib.getData(XL_PATH, SHEET2, 1, 3);	
		
		/***********Navigate To CampaignPage*************/
		HomePage hp = new HomePage(driver);
		CampaignPage cp = hp.navigateToCampaignPage();
		
		/*******Navigate to createCampaignPage*********/
		CreateCampaignPage ccp = cp.navigateToCreateCampPage();
		
		/***********Create new campaign**************/
		ProdChildPage pcp = ccp.createNewCampaign(campName, sponsor, product);
		CreateCampaignPage ccp1 = pcp.addProduct(product);
		CampaignInfoPage cip =ccp1.clickOnSave();
		
		/**************Verification******************/
		String campaignData = cip.getCampInfo().getText();
		Assert.assertEquals(campaignData, campName);
		
	}
}
