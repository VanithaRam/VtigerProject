package com.crm.vtiger.organizationtest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.generic.BaseTest;
import com.crm.vtiger.pages.CreateOrganizationPage;
import com.crm.vtiger.pages.HomePage;
import com.crm.vtiger.pages.OrganizationInfoPage;
import com.crm.vtiger.pages.OrganizationPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OrgTest extends BaseTest
{	
	@Test(groups= {"smoke"})
	public void createOrganizationTest()
	{
		ExtentTest logger = report.startTest("createOrganizationTest");
		// get test data
		String orgName = flib.getData(XL_PATH, SHEET1, 1, 0)+wdu.getRandomNumber();
		logger.log(LogStatus.INFO, "Login to the application");
		
		//navigate to organization
		logger.log(LogStatus.INFO, "Navigating to Organization Page");
		HomePage hp = new HomePage(driver);
		OrganizationPage op = hp.navigateToOrgPage();
	
		// Create Organization 
		logger.log(LogStatus.INFO, "Creating New Organization");
		CreateOrganizationPage cop = op.createNewOrganizationPage();
		OrganizationInfoPage oip = cop.AddingOrg(orgName);
		
		//verification
		logger.log(LogStatus.INFO, "Verifying the Organization");
		String orgInfoData = oip.getOrgNameInfo().getText();
		
		 Assert.assertEquals(orgInfoData, orgName); 
		 logger.log(LogStatus.PASS, "Organization is created");
	
	
		report.endTest(logger);
	}
	}


