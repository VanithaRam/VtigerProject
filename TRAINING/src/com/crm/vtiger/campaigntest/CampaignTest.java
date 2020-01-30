package com.crm.vtiger.campaigntest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.generic.BaseTest;
import com.crm.vtiger.pages.CampaignInfoPage;
import com.crm.vtiger.pages.CampaignPage;
import com.crm.vtiger.pages.CreateCampaignPage;
import com.crm.vtiger.pages.HomePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CampaignTest extends BaseTest {
	
	@Test(groups= {"smoke"})
	public void createCampaign()
	{
		ExtentTest logger = report.startTest("createCampaign Test");
		
		logger.log(LogStatus.INFO, "logging to the Application");
		/***************get test data********************/
		String campName=flib.getData(XL_PATH, SHEET2, 1, 0)+wdu.getRandomNumber();
		String sponsor = flib.getData(XL_PATH, SHEET2, 1, 2);
		
		logger.log(LogStatus.INFO, "Navigating to Campaign Page");
		HomePage hp = new HomePage(driver);	
		CampaignPage cp = hp.navigateToCampaignPage();
		
		logger.log(LogStatus.INFO, "Navigating to createCampaignPage");
		CreateCampaignPage ccp = cp.navigateToCreateCampPage();
		
		logger.log(LogStatus.INFO, "Creating New Campaign");
		CampaignInfoPage cip = ccp.createNewCampaign(campName,sponsor);
		
		logger.log(LogStatus.INFO, "Verifying the Campaign");
		String campaignData = cip.getCampInfo().getText();
		Assert.assertEquals(campaignData, campName);
		logger.log(LogStatus.PASS, "New Campaign Created");
		
		report.endTest(logger);
	}
}
