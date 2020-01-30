package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generic.WebDriverUtils;

public class CreateOrganizationPage extends WebDriverUtils
{
	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement orgNameTB;
	
	@FindBy(id="phone")
	private WebElement phoneNum;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addMemberBTN;
	
	@FindBy(id="email1")
	private WebElement emailTB;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBTN;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameTB() {
		return orgNameTB;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getAddMemberBTN() {
		return addMemberBTN;
	}

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	public CreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrganizationInfoPage AddingOrg(String orgName) {
		orgNameTB.sendKeys(orgName);
		saveBTN.click();
		return new OrganizationInfoPage(driver);
	}
	
	public OrganizationInfoPage AddingOrg(String orgName , String phoneNumber, String email) 
	{
		orgNameTB.sendKeys(orgName);
		phoneNum.sendKeys(phoneNumber);
		emailTB.sendKeys(email);
		saveBTN.click();
		return new OrganizationInfoPage(driver);
	}
	
	public OrgChildPage AddingOrg(String orgName,  String email)
	{
		orgNameTB.sendKeys(orgName);
		emailTB.sendKeys(email);
		addMemberBTN.click();
		switchToChildWindow(driver);
		return new OrgChildPage(driver);
	}
	
	public OrganizationInfoPage clickOnSave()
	{
		saveBTN.click();
		return new OrganizationInfoPage(driver);
	}
}
