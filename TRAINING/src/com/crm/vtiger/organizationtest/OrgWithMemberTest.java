package com.crm.vtiger.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.generic.BaseTest;
import com.crm.vtiger.pages.CreateOrganizationPage;
import com.crm.vtiger.pages.HomePage;
import com.crm.vtiger.pages.OrgChildPage;
import com.crm.vtiger.pages.OrganizationInfoPage;
import com.crm.vtiger.pages.OrganizationPage;

public class OrgWithMemberTest extends BaseTest {

	@Test(groups= {"regression"})
	public void createOrgWithMem()
	{
		//get the data
		String orgName = flib.getData(XL_PATH, SHEET1, 1, 0)+wdu.getRandomNumber();
		String memberName = flib.getData(XL_PATH, SHEET1, 1, 3);
		String email = flib.getData(XL_PATH, SHEET1, 1, 2);
		
		//navigate to homePage
		HomePage hp = new HomePage(driver);
		OrganizationPage op = hp.navigateToOrgPage();
	
		//create new Organization
		CreateOrganizationPage cop = op.createNewOrganizationPage();
		OrgChildPage ocp = cop.AddingOrg(orgName,email);
		CreateOrganizationPage cop1 = ocp.selectMember(memberName);
		OrganizationInfoPage oip = cop1.clickOnSave();
		
		//Verification
		String orgInfoData = oip.getOrgNameInfo().getText();
		Assert.assertEquals(orgInfoData, orgName);
		
		
	}
	
}
