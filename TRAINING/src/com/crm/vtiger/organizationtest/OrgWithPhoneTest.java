package com.crm.vtiger.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.generic.BaseTest;
import com.crm.vtiger.pages.CreateOrganizationPage;
import com.crm.vtiger.pages.HomePage;
import com.crm.vtiger.pages.OrganizationInfoPage;
import com.crm.vtiger.pages.OrganizationPage;

public class OrgWithPhoneTest extends BaseTest{

	@Test(groups= {"regression"})
	public void createOrgWithPhone()
	{
		//get the data
		String orgName = flib.getData(XL_PATH, SHEET1, 1, 0)+wdu.getRandomNumber();
		String phoneNumber = flib.getData(XL_PATH,SHEET1, 1 ,1);
		String email = flib.getData(XL_PATH, SHEET1, 1, 2);
	
		
		//navigate to organization page
		HomePage hp = new HomePage(driver);
		OrganizationPage op = hp.navigateToOrgPage();
		CreateOrganizationPage cop = op.createNewOrganizationPage();
		OrganizationInfoPage oip = cop.AddingOrg(orgName, phoneNumber, email);
		
		//verification
		String orgInfoData = oip.getOrgNameInfo().getText();
		Assert.assertEquals(orgInfoData, orgName);
	}
}
